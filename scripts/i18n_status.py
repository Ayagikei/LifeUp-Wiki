#!/usr/bin/env python3
"""English-pivot wiki i18n tracker: status / stamp / init."""
from __future__ import annotations

import argparse
import hashlib
import json
import shutil
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
CATALOG_PATH = ROOT / "docs" / "_i18n" / "catalog.json"
STATUS_PATH = ROOT / "docs" / "_i18n" / "status.json"
EN_DIR = ROOT / "docs" / "en"
SKIP_NAMES = {".DS_Store"}


def sha256_text(path: Path) -> str:
    data = path.read_bytes().replace(b"\r\n", b"\n")
    return hashlib.sha256(data).hexdigest()


def load_json(path: Path, default):
    if not path.exists():
        return default
    return json.loads(path.read_text())


def save_json(path: Path, payload) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(payload, indent=2, ensure_ascii=False) + "\n")


def catalog() -> dict:
    return load_json(CATALOG_PATH, {})


def target_codes(cat: dict) -> list[str]:
    return [item["code"] for item in cat.get("targetLocales", [])]


def tracked_paths(cat: dict) -> list[str]:
    return [item["path"] for item in cat.get("files", [])]


def locale_dir(code: str) -> Path:
    return ROOT / "docs" / code


def file_status(en_hash: str, dest: Path, stamped: str | None) -> str:
    if not dest.exists():
        return "missing"
    if not stamped:
        return "untracked"
    if stamped != en_hash:
        return "stale"
    return "synced"


def cmd_status(args: argparse.Namespace) -> int:
    cat = catalog()
    st = load_json(STATUS_PATH, {"files": {}})
    locales = args.locales or target_codes(cat)
    paths = args.paths or tracked_paths(cat)
    files = st.setdefault("files", {})
    counts = {code: {"missing": 0, "untracked": 0, "stale": 0, "synced": 0} for code in locales}

    print(f"{'path':<46} {'en':<10} " + " ".join(f"{c:<10}" for c in locales))
    for rel in paths:
        src = EN_DIR / rel
        if not src.exists():
            print(f"{rel:<46} {'ABSENT':<10}")
            continue
        digest = sha256_text(src)
        row = [f"{rel:<46} {digest[:8]:<10}"]
        entry = files.setdefault(rel, {"en": digest, "locales": {}})
        entry["en"] = digest
        loc_map = entry.setdefault("locales", {})
        for code in locales:
            state = file_status(digest, locale_dir(code) / rel, loc_map.get(code, {}).get("sourceHashAtSync"))
            counts[code][state] += 1
            row.append(f"{state:<10}")
        print(" ".join(row))

    print("\nsummary")
    for code in locales:
        c = counts[code]
        print(f"  {code}: synced={c['synced']} stale={c['stale']} missing={c['missing']} untracked={c['untracked']}")
    save_json(STATUS_PATH, st)
    return 0


def cmd_stamp(args: argparse.Namespace) -> int:
    cat = catalog()
    st = load_json(STATUS_PATH, {"files": {}})
    files = st.setdefault("files", {})
    codes = [args.locale]
    paths = args.paths or tracked_paths(cat)
    for rel in paths:
        src = EN_DIR / rel
        if not src.exists():
            continue
        digest = sha256_text(src)
        entry = files.setdefault(rel, {"en": digest, "locales": {}})
        entry["en"] = digest
        loc_map = entry.setdefault("locales", {})
        for code in codes:
            dest = locale_dir(code) / rel
            if not dest.exists():
                continue
            loc_map[code] = {"sourceHashAtSync": digest}
            print(f"stamp {code} {rel}")
    save_json(STATUS_PATH, st)
    return 0


def cmd_init(args: argparse.Namespace) -> int:
    for code in args.locales:
        dest_root = locale_dir(code)
        dest_root.mkdir(parents=True, exist_ok=True)
        copied = 0
        for src in EN_DIR.rglob("*"):
            if not src.is_file() or src.name in SKIP_NAMES:
                continue
            if src.suffix.lower() == ".md":
                continue
            rel = src.relative_to(EN_DIR)
            dest = dest_root / rel
            dest.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(src, dest)
            copied += 1
        print(f"init {code}: copied {copied} non-md files -> {dest_root}")
    return 0


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    sub = parser.add_subparsers(dest="cmd", required=True)

    p_status = sub.add_parser("status")
    p_status.add_argument("locales", nargs="*")
    p_status.add_argument("--paths", nargs="*")
    p_status.set_defaults(func=cmd_status)

    p_stamp = sub.add_parser("stamp")
    p_stamp.add_argument("locale")
    p_stamp.add_argument("paths", nargs="*")
    p_stamp.set_defaults(func=cmd_stamp)

    p_init = sub.add_parser("init")
    p_init.add_argument("locales", nargs="+")
    p_init.set_defaults(func=cmd_init)

    args = parser.parse_args()
    return args.func(args)


if __name__ == "__main__":
    sys.exit(main())

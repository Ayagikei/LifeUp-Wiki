# AGENTS.md

## Project Snapshot

- This repository hosts the **LifeUp Wiki** documentation site.
- The site is built with Docsify and published from the `docs/` directory.
- **14 published locales:** `zh-cn`, `zh-hant`, `en`, `ja`, `ko`, `es`, `de`, `fr`, `it`, `pt`, `tr`, `ru`, `id`, `ar`.
- Language trees:
  - `docs/zh-cn` (Simplified Chinese, dual source)
  - `docs/en` (English, dual source and pivot for new locales)
  - `docs/zh-hant` (Traditional Chinese, manually maintained)
  - `docs/ja` … `docs/ar` (English-pivot translations; see `docs/_i18n/`)
- Root `docs/index.html` redirects by `navigator.language` to a locale entry page.
- Each locale’s `_navbar.md` includes a **Language** dropdown linking all locales.

## Source of Truth

- `docs/zh-cn` and `docs/en` are the manually maintained source content.
- New locales follow the `docs/en` path tree. Track freshness with `python3 scripts/i18n_status.py`.
- Shared assets are mainly in `docs/_media` and language-specific `_media` folders.

## Locale Coverage (14 locales)

- **All 14 published locales** (`zh-cn`, `zh-hant`, `en`, `ja`, `ko`, `es`, `de`, `fr`, `it`, `pt`, `tr`, `ru`, `id`, `ar`) should stay aligned for **user-facing, cross-locale topics** (FAQ, ulives/LifeUp membership, download, release log, etc.). Do not stop at `en` + `zh-cn` only.
- **Authoring flow:** update `docs/en` and `docs/zh-cn` first (dual sources), mirror `docs/zh-hant` manually when `zh-cn` changes, then translate to the 12 English-pivot locales and run `python3 scripts/i18n_status.py stamp <locale> <path>`.
- **China-only topics (e.g. HarmonyOS):** maintain dedicated pages only under `docs/zh-cn` and `docs/zh-hant` (`guide/harmonyos-compatibility.md`, related FAQ blocks). Other locales **do not** need HarmonyOS sections or mentions unless the English pivot gains an equivalent page later.
- **Wording source for ulives membership/pricing:** prefer matching [ulives-docs](https://ulives.lifeupapp.net/docs/comparison-with-lifeup) / FAQ phrasing when syncing bundle-pricing and LifeUp-benefits bullets across locales.

## Traditional Chinese (Critical)

- `docs/zh-hant` is **manually maintained** alongside `docs/zh-cn`.
- Match App `values-zh-rTW` terminology (e.g. **實驗室**, **自訂**); do not rely on OpenCC output in published pages.
- Prefer `zh-hant` internal links in `docs/zh-hant/**` (not `zh-cn` URLs).
- `opencc.main.kts` and `.github/workflows/opencc.yml` remain optional **draft** helpers only; CI does not commit converted files.

## Wiki i18n (English-pivot locales)

- Pivot: `docs/en`. Do not treat `zh-cn` as a translation of English.
- `docs/zh-hant` is manually maintained; update it when `docs/zh-cn` changes for user-facing pages.
- New locale dirs mirror English paths (`feature/`, `Introduction.md`, `ReleaseLog.md`).
- Inventory and waves: `docs/_i18n/catalog.json`. Freshness: `python3 scripts/i18n_status.py status|stamp|init`.
- After translating a locale file, stamp it. Do not copy English `.md` into a locale as a published placeholder.
- Keep English heading IDs (`:id=`). Translate visible text only.
- Plan: `docs/plans/2026-08-29-wiki-i18n/delivery-plan.md`.

### Release log (public Android releases)

- On each public release, update in the same change: `docs/en/ReleaseLog.md`, `docs/zh-cn/introduction/release_log.md`, `docs/zh-hant/introduction/release_log.md`, and every catalog target locale’s `ReleaseLog.md`.
- After translating a locale `ReleaseLog.md`, run `python3 scripts/i18n_status.py stamp <locale> ReleaseLog.md`.


## Docsify Linking Convention

- Prefer explicit heading IDs for stable in-page and cross-page anchors.
- Define IDs on headings with docsify syntax, for example: `## Section Title :id=section_id`.
- Link to anchors by ID (example: `#section_id` or `/guide/faq?id=section_id`) instead of relying on auto-generated slug anchors.
- Keep heading IDs stable once published to avoid breaking existing links.

## Docsify Authoring Conventions

- Use modern callout syntax (`> [!NOTE]`, `> [!TIP]`, `> [!WARNING]`) instead of legacy `!>` / `?>` markers.
- Ensure `docsify-plugin-flexible-alerts` is available in locale entry pages when authoring callouts.
- Keep callout usage concise in complex HTML blocks; prefer simple markdown inside `<details>` when possible.
- In navigation/instruction text, prefer Unicode arrows (`→`, `↔`) over ASCII `->` for readability.
- Keep platform naming/style consistent in docs: `App`, `macOS`, `Wi-Fi`, `Google Play`, `GitHub Releases`.
- Some docs intentionally use visible heading text like `#### # Quick Start`; keep the extra `#` when it is part of the page’s visual style.

## Collapsible FAQ Convention

- We use native HTML `details` + `summary` for collapsible FAQ blocks in docsify pages.
- Global custom styles are defined in:
  - `docs/en/css/lifeup_vue_override.css`
  - `docs/zh-cn/css/lifeup_vue_override.css` and `docs/zh-hant/css/lifeup_vue_override.css` (keep in sync when styles change)
- Main style hooks: `.markdown-section details`, `.markdown-section summary`, and `.markdown-section .faq-content`.
- The CSS also supports plain markdown directly inside `<details>` (without a `.faq-content` wrapper).
- Default behavior: keep FAQ items collapsed (do not add the `open` attribute unless explicitly needed).
- For the English FAQ page, keep only major section headings and avoid a manual TOC block.
- Recommended markup pattern:

```html
<details>
  <summary>Question</summary>
  <div class="faq-content">
    <p>Answer...</p>
  </div>
</details>
```

## Local Development Notes

- Start local docs preview:

```bash
docsify serve ./docs
```

- Optional OpenCC draft (does not replace manual zh-hant edits):

```bash
kotlinc -script opencc.main.kts
```

## Agent Working Agreement

- Prefer minimal, focused changes.
- Avoid refactoring unrelated files.
- Preserve existing link and folder conventions when editing docs.

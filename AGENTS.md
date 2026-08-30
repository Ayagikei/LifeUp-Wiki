# AGENTS.md

## Project Snapshot

- This repository hosts the **LifeUp Wiki** documentation site.
- The site is built with Docsify and published from the `docs/` directory.
- **14 published locales:** `zh-cn`, `zh-hant`, `en`, `ja`, `ko`, `es`, `de`, `fr`, `it`, `pt`, `tr`, `ru`, `id`, `ar`.
- Language trees:
  - `docs/zh-cn` (Simplified Chinese, dual source)
  - `docs/en` (English, dual source and pivot for new locales)
  - `docs/zh-hant` (Traditional Chinese, OpenCC from zh-cn)
  - `docs/ja` … `docs/ar` (English-pivot translations; see `docs/_i18n/`)
- Root `docs/index.html` redirects by `navigator.language` to a locale entry page.
- Each locale’s `_navbar.md` includes a **Language** dropdown linking all locales.

## Source of Truth

- `docs/zh-cn` and `docs/en` are the manually maintained source content.
- New locales follow the `docs/en` path tree. Track freshness with `python3 scripts/i18n_status.py`.
- Shared assets are mainly in `docs/_media` and language-specific `_media` folders.

## Traditional Chinese Automation (Critical)

- `docs/zh-hant` is auto-generated from `docs/zh-cn` by `opencc.main.kts`.
- GitHub Actions workflow `.github/workflows/opencc.yml` runs this conversion on push to `master`.
- The workflow automatically commits converted updates (commit message: `chore: update zh-hant`).
- Publish workflows (`.github/workflows/pages.yml` and `.github/workflows/qiniu.yml`) run after the OpenCC workflow.

### Rule

- **Do not manually maintain or edit files under `docs/zh-hant`.**
- To update Traditional Chinese docs, edit `docs/zh-cn` and push changes; GitHub Action handles conversion and commit automatically.

## Wiki i18n (English-pivot locales)

- Pivot: `docs/en`. Do not treat `zh-cn` as a translation of English.
- `docs/zh-hant` stays OpenCC from `zh-cn`; never hand-edit it.
- New locale dirs mirror English paths (`feature/`, `Introduction.md`, `ReleaseLog.md`).
- Inventory and waves: `docs/_i18n/catalog.json`. Freshness: `python3 scripts/i18n_status.py status|stamp|init`.
- After translating a locale file, stamp it. Do not copy English `.md` into a locale as a published placeholder.
- Keep English heading IDs (`:id=`). Translate visible text only.
- Plan: `docs/plans/2026-08-29-wiki-i18n/delivery-plan.md`.


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
  - `docs/zh-cn/css/lifeup_vue_override.css` (and `zh-hant` is updated by the OpenCC workflow sync)
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

- Local OpenCC run is optional (preview/debug only); CI automation is the default path:

```bash
kotlinc -script opencc.main.kts
```

## Agent Working Agreement

- Prefer minimal, focused changes.
- Avoid refactoring unrelated files.
- Preserve existing link and folder conventions when editing docs.

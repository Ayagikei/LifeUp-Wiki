# Backup and Restore

> [!IMPORTANT]
> LifeUp is offline-first. Most of your personal data stays on your device. If backup is not configured, uninstalling the app, switching phones, or device damage can cause permanent data loss.

## Quick Navigation

- [Why Backup Matters](#why-backup)
- [How to Configure Backup Methods](#configure-methods)
- [How to Backup](#how-to-backup)
- [How to Restore](#how-to-restore)
- [New Phone Migration](#phone-migration)
- [Common Issues](#common-issues)

## 1) Why Backup Matters :id=why-backup

### What risks are you protecting against?

Most users lose data in one of these situations:

1. App uninstall (files in default backup path may be removed by system cleanup)
2. Phone migration without moving backup files
3. Device damage/loss

A reliable backup means your data exists on another device or storage medium, not only on the same phone.

### What is included in a backup?

Backups include your local core data, such as tasks, attributes, shop data, achievements, feelings, Pomodoro records, and settings. Media files (attachments, icons, backgrounds, audio) can also be included.

> [!TIP]
> If backup size is over 10MB, enable "Ignore media/picture files" or increase backup interval for better stability.

## 2) How to Configure Backup Methods :id=configure-methods

For most English users, this priority works best:

| Method | Recommended | Best for | Auto backup | Notes |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Daily usage, easy cloud sync | Yes | One-tap authorization in app |
| Dropbox | ⭐⭐⭐⭐ | Daily usage, cross-device sync | Yes | Also supports in-app authorization |
| Local export (Custom Path) | ⭐⭐⭐⭐ | Manual copy to PC/NAS | No (manual) | Reliable fallback and versioned archives |
| WebDAV | ⭐⭐⭐ | Self-hosting / existing WebDAV service | Yes | Good alternative if you already use WebDAV |
| Auto backup to Download folder (Android 10+) | ⭐⭐⭐ | Reduce uninstall risk | Yes | Does not protect against device damage |

<details>
<summary>Set up Google Drive/Dropbox auto backup (recommended)</summary>

In the app, go to:
`Sidebar -> Settings -> Data Backup/Restore/Clear`

Then:

1. Authorize Google Drive or Dropbox
2. In "Cloud Backup Config", select your method
3. Enable "Enable auto cloud backup"
4. Set "Auto backup interval"
5. Optionally enable "Ignore media/picture files"

</details>

<details>
<summary>Set up WebDAV cloud backup (optional)</summary>

If you use a WebDAV-compatible service:

1. Open `WebDAV Configuration`
2. Fill URL, account, and password
3. Run a connection test
4. Use WebDAV as your cloud backup method

</details>

<details>
<summary>Export to custom path (manual fallback)</summary>

Use this when you want manual, portable backups:

1. Tap `Backup`
2. Choose `Custom Path`
3. Save the generated file (usually `.lfbak`)
4. Copy it to PC/NAS/cloud storage

> [!WARNING]
> Do not keep your only backup on the same phone.

</details>

## 3) How to Backup :id=how-to-backup

<details>
<summary>Run daily auto backup workflow</summary>

1. Complete one cloud setup (Google Drive or Dropbox)
2. Enable auto cloud backup and interval
3. Trigger one manual backup once to verify everything works
4. Check the "last backup" hint periodically

</details>

<details>
<summary>Run manual backup before critical changes</summary>

Create an extra local export before:

- major app updates
- system reset/reflash
- phone migration

Use: `Backup -> Custom Path`, then copy file to external storage.

</details>

## 4) How to Restore :id=how-to-restore

<details>
<summary>Restore from cloud backup (Google Drive / Dropbox / WebDAV)</summary>

1. Configure the same cloud account/method on target device
2. Tap `Restore` and choose that method
3. Confirm restore (app will restart)

> [!WARNING]
> Restore overwrites current local data. If current data matters, export a local backup first.

</details>

<details>
<summary>Restore from local backup file</summary>

1. Move backup file to target device
2. Tap `Restore -> Custom Path`
3. Select backup file and confirm

You can also enable "Support file system to open backup files" to import directly from file manager or sharing apps.

> [!TIP]
> If restore fails with read/write error, try another file path and reselect the file.

</details>

### New Phone Migration :id=phone-migration

<details>
<summary>Migrate to a new phone (system or backup path)</summary>

#### Option A: Use built-in phone migration first

Some phones support full app-data migration (brand migration tools / system clone).

1. Run the system migration from old phone to new phone.
2. Open LifeUp and verify key data (tasks, attributes, shop data, achievements).
3. Even if migration looks fine, create one fresh backup on the new phone.

#### Option B: Migrate via cloud backup or backup file (universal)

1. On old phone, create a fresh backup first.
2. On new phone, install LifeUp.
3. For cloud migration: configure the same cloud method/account, then restore.
4. For file migration: transfer backup file, then use `Restore -> Custom Path`.
5. After restore, trigger one manual backup to verify backup chain on new phone.

> [!WARNING]
> Restore overwrites local data. If new phone already has important new entries, export first.

</details>

## 5) Common Issues :id=common-issues

<details>
<summary>Fix restore error: invalid backup file</summary>

- Confirm the file is generated by LifeUp.
- `.lfbak` is the recommended format.

</details>

<details>
<summary>Fix restore error: higher backup version file</summary>

Update LifeUp to latest version, then restore again.

</details>

<details>
<summary>Improve slow or unstable cloud backup</summary>

- Enable "Ignore media/picture files".
- Increase auto backup interval.
- Clean unused media files before backup.

</details>

<details>
<summary>Decide whether Download-folder auto backup is enough</summary>

- It helps against uninstall-related loss.
- It does not cover device damage/loss.
- Safer strategy: combine cloud backup + periodic local export.

</details>

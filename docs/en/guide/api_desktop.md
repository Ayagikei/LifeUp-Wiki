<h1 align="center" padding="100">Local Network (API) Desktop Client 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

We built a lightweight desktop client for LifeUp based on LifeUp APIs. It supports Windows, Linux, and macOS.

**It is not a standalone app.** It reads your LifeUp offline data from your phone through API access.

<br/>

## Features

> [!NOTE]
> The current version is mainly a technical preview of API capabilities. It focuses on core browsing operations and does not cover every in-app feature.

- Fully open source. You can customize UI and implement your own features.
- Current basic capabilities:
  - Query task list and complete tasks
  - Query attribute list and levels
  - Query item list and buy items
  - Query feelings and view full-size images on desktop
  - Export feelings to Markdown files
  - Add tasks (not all in-app options are covered yet)

<br/>

## Download

All desktop packages are published on [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Before using desktop, make sure LifeUp Cloud is v2.0.0 or above.<br/>
> If you use the GitHub Releases build, update LifeUp Cloud in `Settings` → `Labs`.<br/>
> If you use the Google Play build, you can update from [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) or [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Some browsers may block installer downloads due to security policy. Choose **Keep/Allow** (wording varies by browser), or use another downloader.

### Installation Platforms

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> The MSI is not currently EV-signed, so Windows may show an "unrecognized app" warning.<br/>
> After confirming the file is from the official GitHub release, click **More info → Run anyway**.

#### **Linux**

- Download from [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) and use `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- macOS builds are not fully tested yet, and some features like **Auto Connect** may be unavailable.

> [!TIP]
> **macOS Gatekeeper / signature**<br/>
> Current macOS builds are not notarized. You may see an "unidentified developer" warning.<br/>
> You can open the `.dmg`, move the app to Applications, then right-click the app and choose **Open**,<br/>
> or go to **System Settings → Privacy & Security** and click **Open Anyway**.<br/>
> See [Apple’s official guide](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) for details.

<!-- tabs:end -->

If a package is temporarily missing, refresh later. Release assets may still be uploading.

<br/>

## How to use

### First-time setup

#### Prerequisites

- Your phone and desktop must be on the same LAN (for example, same Wi-Fi).
- <del>If your network is complex, first test whether desktop can ping your phone IP.</del>
  - New desktop versions support automatic phone IP detection, so this is often unnecessary.

#### On your phone

1. Update LifeUp to the latest version.
2. In LifeUp, open `Settings` → `Labs`, then install **LifeUp Cloud**.
3. Open LifeUp Cloud and grant required permissions:
   - Floating window / draw-over-apps permission
   - LifeUp data read permission
4. Tap **Start Service** in LifeUp Cloud.

**Recommended additional setup**

- Do compatibility setup for both LifeUp and LifeUp Cloud, and disable battery optimization to reduce background kill issues.
- If you use MIUI (Xiaomi/Redmi), allow **Display UI in background** for both apps.
- Keep both LifeUp and LifeUp Cloud running.

#### On desktop

1. Install the desktop app from the release package.
2. In desktop settings, enter the service IP shown in LifeUp Cloud.
   - In desktop v1.1.0+, you can try **Auto Connect**.
3. If everything is configured correctly, you should be able to view LifeUp data on desktop.
   - If it fails, revisit the additional setup above.

### Non-first use

1. Open LifeUp and LifeUp Cloud on your phone.
2. Tap **Start Service** in LifeUp Cloud.
3. Launch the desktop client.

<br/>

## FAQ

<details>
<summary>Can I add tasks from desktop?</summary>

Not yet in the current preview build. The desktop currently focuses on data query/browsing.

At this stage, you can still add tasks by calling APIs via LifeUp Cloud.

</details>

<details>
<summary>I clicked "Request LifeUp Permission" in LifeUp Cloud, but nothing happened / API not found.</summary>

1. If nothing happens, you may already have granted it.
2. If API not found appears, join member beta and update LifeUp to the latest beta version.

</details>

<details>
<summary>After phone lock for a while, desktop can no longer read data.</summary>

Do compatibility setup for both LifeUp and LifeUp Cloud.

</details>

<details>
<summary>When LifeUp and LifeUp Cloud are in background, some APIs fail to execute.</summary>

> This usually does not affect basic desktop usage, but may affect custom API calls.

Make sure LifeUp Cloud has floating window/draw-over-apps permission.

If you are on MIUI (Xiaomi/Redmi), also enable the **Display UI in background** permission for both apps.

</details>

<details>
<summary>Windows install fails with `Failed to launch JVM`.</summary>

Reference: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

This is usually related to local JVM accessibility configuration.

A common workaround is to comment out these lines in `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

After editing, restart the app and test again.

> `~` means your user home directory.

</details>

<br/>

## Contribution

The SDK, LifeUp Cloud, and LifeUp Desktop are all open source.

Source code:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

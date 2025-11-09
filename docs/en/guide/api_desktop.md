<h1 align="center" padding="100">Local Area Network (API) Desktop Client 🖥 </h1> <p align="center"> <img src="guide/_media/api/desktop.png" /> </p>

We have developed a simple LAN desktop version of "LifeUp" using the API capabilities of "LifeUp", which supports multiple platforms such as Windows, Linux, and MacOS.

**Please note that it is not a standalone program. It needs to read offline data in "LifeUp" on your phone through API.**

<br/>

## Features

- **The current version is only a technical demonstration and preview of the API interface, mainly providing some basic information browsing functions, and does not cover all application functions.**
- Completely open source, you can freely change its UI and implement the functions you want.
- Basic functions:
  - Query task list, complete task
  - Query attribute list, level
  - Query commodity list, purchase commodity
  - Query sentiment list and browse large pictures through a computer image browser
  - Export feelings to markdown files
  - Add tasks (not fully covering the options in the app)
  - …
  - ...

<br/>

## Download

All distribution packages are published on the [LifeUp Desktop GitHub Releases page](https://github.com/Ayagikei/LifeUp-Desktop/releases). Open the latest release, expand the **Assets** section, then download the installer that matches your platform:

- **Windows**: `LifeUp Desktop.msi`
- **macOS (Intel/x64)**: `LifeUp-Desktop-x64.dmg`
- **macOS (Apple Silicon/ARM64)**: `LifeUp-Desktop-arm64.dmg`
- **Linux**: `lifeup-desktop.deb`

If the file you need is missing, wait a moment and refresh—the upload for that release may still be in progress.

?> **Windows SmartScreen**
> The MSI is not yet signed with an Extended Validation certificate, so Windows may show the "unrecognized app" banner. Click **More info → Run anyway** after confirming the file was downloaded from the official GitHub release.

?> **macOS security & signature**
> The current macOS builds are not notarized, so Gatekeeper will warn that the app is from an unidentified developer. Open the `.dmg`, drag LifeUp Desktop into Applications, then right-click the app and choose **Open**, or go to **System Settings → Privacy & Security** and click **Open Anyway**. Consult [Apple’s official guide](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) if you need more detail. Some features such as `auto-connect` are still experimental on macOS and may behave differently from Windows/Linux builds.

!> Some browsers enforce strict download policies and may block or delete the installer packages. Choose **Keep/Allow** (wording varies by browser) so the download can finish.

!> You need to use "LifeUp Cloud" version 1.3.0 or above. The current "LifeUp Cloud" does not support checking for updates. You can download and overwrite the installation in Google Play or [Releases · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/releases).

<br/>

## How to use

To use the desktop client, you will need to follow a few steps:

### First use

#### Precautions

- Your phone and computer are on the same LAN (such as connected to the same WIFI).
- <del>⚠If your network configuration is very complicated, please try to ping your phone's IP address on your computer before attempting to use it.</del>
  - The new version of the desktop supports automatic detection of the phone’s IP, which can skip this step.


#### On your phone

1. Update your "LifeUp" to the latest version.

2. In "LifeUp"-"Settings"-"Labs", find "LifeUp Cloud" and download and install it.

   Our desktop version needs it to read data and perform operations.

3. Run "LifeUp Cloud" and give floating window permission and LifeUp data reading permission.

4. Click "Start Service" in "LifeUp Cloud".

**Additional steps**

- We recommend that you perform "compatibility configuration" for both "LifeUp" and "LifeUp Cloud", turn off battery optimization, avoid system errors killing the application, **and support using the phone after locking the screen.**
- **If your phone is a MIUI system (Xiaomi, Redmi), please make sure that you have allowed "Display interface in the background" permission for "LifeUp" and "LifeUp Cloud".**
- Make sure "LifeUp" and "LifeUp Cloud" are both running.

#### On Desktop

1. Download and install the desktop application via the download link in the previous section.
2. Fill in the service IP address displayed in "LifeUp Cloud" in the desktop version settings page.
   - After the v1.1.0 version of the desktop, you can try clicking the “Auto Connect” button.
3. Congratulations, if everything goes well, you should be able to view your LifeUp data on the desktop version.
   - **If it fails, you may need the additional steps mentioned above.**

### Non-first use

1. Open "LifeUp" and "LifeUp Cloud" on your phone.
2. Click "Start Service" in "LifeUp Cloud".
3. Run the desktop client.

<br/>

## FAQ

**Can I add tasks on the desktop?**

Not at the moment. The current preview version mainly provides data query capabilities, and this adding tasks feature will be developed in future versions.

However, at this stage, you can also add tasks by calling the API through "LifeUp Cloud".

**After clicking "Request LifeUp Permission" in " LifeUp Cloud", there is no response or the API is not found?**

1. If there is no response, you may have authorized it before. Consider it a success.
2. If the API is not found, please join the member beta test and update to the latest version of "Life Up".

**After the phone is locked for a period of time, the desktop cannot read data or use it?**

Please perform compatibility configuration for "Life Up" - "LifeUp Cloud".

**When "Life Up" and "LifeUp Cloud" are in the background, some interfaces cannot be called normally?**

> This theoretically does not affect the use of the desktop, but may affect custom API calls.

Please make sure that you have granted "LifeUp Cloud" the permission to draw over other apps.

If you are using MIUI (Xiaomi, Redmi), you also need to additionally configure the "Show on Lock Screen" permission for these two apps in the system settings.

<br/>

## Contribution

The SDK, "LifeUp Cloud", and "Life Up Desktop" are all open source projects.

You can obtain the source code and run it using IDEA at the following links:

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

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

- **[Windows Version](https://github.com/Ayagikei/LifeUp-Desktop/releases/download/1.1.1/LifeUp.Desktop-1.1.1-windows.zip)**
  - [GitHub Release](https://github.com/Ayagikei/LifeUp-Desktop/releases/latest)
- Linux (untested, to be released later)
- **MacOS**
  - [Release LifeUp Desktop v1.1.0 · Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop/releases/tag/1.1.0-macos)
  - The MacOS version is currently unsigned and requires permission to operate when installing: [Open a Mac app from an unidentified developer - Apple Support](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac)
  - The MacOS version has not been tested in detail, and some functions such as `auto-connect` may not work.


!> You need to use "LifeUp Cloud" version 1.3.0 or above. The current "LifeUp Cloud" does not support checking for updates. You can download and overwrite the installation in Google Play or [Releases · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/releases).

!> Your browser's security policy may block the download. You need to allow the download to proceed.

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
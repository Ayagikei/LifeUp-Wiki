# Keep LifeUp Running in the Background

## Why this is needed

Some phone manufacturers aggressively restrict background apps to improve battery benchmark results. As a result, features that rely on background execution may fail.

### Compatibility impact matrix

| Feature | Requires background keep-alive? | Extra permissions | Notes |
| --- | --- | --- | --- |
| Task reminder (system notification) | ✔️ | Notification permission | This is the default reminder method. If reminders are delayed or missing, configure background keep-alive and make sure notifications are enabled for LifeUp. |
| Task reminder (calendar event) | ✖️ | Calendar read/write permission | You can switch to this mode in `Settings` → `Tasks` → `Change Reminder System`. |
| Pomodoro end reminder | ✔️ | - | If keep-alive is not configured, reminders may be missed, and countdown may pause or freeze in the background. |
| Count-up Timer | ✖️ | - | - |
| App widget auto refresh | Usually yes (device/OS dependent) | - | Without proper keep-alive, widgets may stay on "Loading" or show stale states like "All tasks completed". |
| Widget action: complete count task / open task detail (non-MIUI) | ✖️ | - | - |
| Widget action: complete count task / open task detail (MIUI) | Depends | May require MIUI-specific background popup/display permission | MIUI may block widget-triggered UI actions in background. |

- Some systems freeze or kill background tasks when the screen is off.
- Widgets may behave differently across launchers and OS variants.
- If you only care about reminders, you can switch to calendar reminders to reduce background dependency.

## How to configure

> [!WARNING]
> These settings may slightly increase battery usage.

Based on our tests on a OnePlus 8T, 24-hour background usage consumed about **30 mAh**. For most users, this is a small impact.

LifeUp only performs limited passive background operations, such as reminders, widget updates, and Pomodoro timing.

---

### Common setup steps

#### General settings

> You do not need to complete every step. Each step can improve background priority and stability.

**Android system settings**

1. In LifeUp, open `Sidebar` → `Settings` → `Compatibility Issues`, then tap `Jump to Battery Optimization Settings`. Find LifeUp and set it to **Do Not Optimize**.

   a. On some devices, LifeUp may not appear after jumping to this page. If so, skip this step.

2. If you need reminders, ensure notification permission is granted to LifeUp.

3. (Optional) In task settings, enable `Quick Add notification`.

<br/>

**Manufacturer background manager (Phone Manager)**

Many manufacturers add extra background restrictions. If you are not on a Pixel/AOSP-like device, you usually need additional configuration.

1. Lock LifeUp in the system multitasking/recent apps screen.

2. In system app management / battery management / phone manager, set LifeUp to allow background running (no restrictions) and allow auto-start.

   a. For manufacturer-specific guides, see [dontkillmyapp.com](https://dontkillmyapp.com/).

3. When using LifeUp features, avoid aggressive modes like super power saving or strict do-not-disturb policies, or add LifeUp to relevant allowlists.

<br/>

**Still not working?**

Based on user reports and our tests, LifeUp works normally on mainstream devices after correct setup. However, system updates may move or rename settings.

1. Re-check all steps above and fill in any missed settings.

   a. Phone-manager restrictions are often scattered across multiple pages and are not listed as standard app permissions.

   b. Try optional steps (for example, enabling persistent notification) and test again.

   c. Search your system settings for battery optimization, background restrictions, auto-start, and popup/background display options.

   d. If you only care about reminders, try `Calendar Reminder` mode.

2. Ask other users with the same device brand/model in the community, and include your OS version.

3. Contact your phone manufacturer support and ask how to prevent a specific app from being killed in background.

---

### App widgets not working

1. Open LifeUp first and keep it running in foreground for a moment.
2. Re-add the widget (if needed, try more than once).
3. If it fails again later, review this guide and re-check keep-alive settings.
4. If you use a third-party launcher, switch to the system launcher and test again.
5. If you use a custom theme, switch to the default system theme and test again.
6. Restart your phone.
7. Try another launcher to rule out launcher-specific issues.

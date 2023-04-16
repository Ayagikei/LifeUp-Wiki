# Keep app alive

## Why

### Compatibility configuration

| Feature                                                      | Need keep the app alive?                  | Any other needed  permission?                                | Notes                                                        |
| ------------------------------------------------------------ | ----------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Task reminder (system notification)                          | ✔️                                         | -                                                            | The default method, **need to configure the keepalive as follows** |
| Task reminder (calendar event)                               | -                                         | need [Calendar Read/Write] permission                        | **Can be set in the app - [Settings] - [Tasks] - [Change Reminder System] options** |
| Pomodoro timer end reminder                                  | ✔️                                         | -                                                            | **need to configure the keepalive as follows；**<br/>If it is not configured, there may be various phenomena such as not reminding, the countdown is frozen, etc. |
| Positive timer                                               | -                                         | -                                                            | -                                                            |
| App widget update                                            | ✔️<br/>（depending on the devices and OS） |                                                              | **need to configure the keepalive as follows；**<br/>If it is not configured, it may always display "Loading" or "All tasks have been completed" and other phenomena |
| App widget finish count tasks/jump to in-app task detail page<br/>（non MIUI OS） | -                                         | -                                                            | -                                                            |
| App widget finish count tasks/jump to in-app task detail page<br/>（MIUI OS） | -                                         | may need the MIUI specific [Display UI in background] permission? |                                                              |

- Some OS will kill the pomodoro reminders when LifeUp in running background or when the phone screen closed.
- LifeUp app widget might not working properly on some home screen app and OS.
- The default reminder method might need LifeUp running in background:
    - you can also consider switching to the system calendar APP reminder (this will require calendar read and write permissions) in the `Settings` - `Tasks Settings` page.
- For MIUI OS, it may restrict the widget from popping up the UI, which will affect the widget to complete the counting task. 



## How

!> These methods may increase the battery draining.

**According to our actual test using the OnePlus 8T device, the power consumption of running in the background for 24 hours is only 30 milliamps per hour.**

This will not significantly affect your power consumption.

But this data may be affected by application logic updates, usage habits and device changes.

LifeUp only performs limited passive operations in the background: such as sending reminders, updating widgets, running Pomodoro, etc.




---

### Common ways to keep the app running in the background

### General Settings

> The following steps are not required to be performed in full, but each step may improve the priority of running LifeUp in the background. Ensure that the function can run normally.

**Android System**

1. Enter LifeUp, click on the sidebar - “Settings” - “Compatibility Issues”, click on “Jump to Battery Optimization Settings”, find LifeUp on this page and set it to “Do not optimize”.

   a. Some phones may not be able to find LifeUp after jumping, you can ignore this configuration.

2. If you want to receive notifications, please make sure that you have granted *LifeUp* notifications permissions.

3. In the matter setting interface of LifeUp, turn on `Quick Add notification` (optional)

<br/>

**Manufacturer Customization (Phone Manager)**

Many mobile phone manufacturers have added a lot of additional configuration items to prevent applications from running in the background. If you are not using a Pixel or AOSP device, you need some extra configuration.

1. In the system’s multitasking management interface, lock the application

2. In the system, find the application’s background management settings (or power optimization settings, or phone manager), and set LifeUp to “Allow background running (no background restrictions)” and “Allow self-starting”

   a. For details, please check https://dontkillmyapp.com/

3. When using LifeUp related functions, **avoid turning on functions such as super power saving, do not disturb, etc.**; or add LifeUp to the whitelist.

<br/>

**Still not working after setting?**

According to our actual tests and user feedback for each manufacturer:

**After correctly configuring the above options, LifeUp can use all functions normally on all mainstream devices.**

But as the phone system is constantly updated, the relevant configuration items may change from time to time.

1. **Please re-check and fill in the gaps according to the above steps**

   a. The restrictions of phone manager type are not traditional application permissions, and the configuration items may be scattered in different system settings pages

   b. Try to operate some of the optional steps, such as turning on the persistent notification of LifeUp, and see if it will help

   c. Manually search for options that may affect battery optimization on your phone.

   d. If you only care about reminders, you can try switching to the “Calendar Reminder” mode

2. Consult other users who use the same manufacturer’s device in the community, and clearly describe your current system version

3. Please consult or give feedback to the system engineer of your phone, and ask how to make an application not be killed in the background / keep alive in the background.



---

### App Widgets not working

1. First open LifeUp and let it run normally
2. Re-enable a new app widget (if abnormal, you can try several times)
3. If it expires after a period of time, please configure it according to https://wiki.lifeupapp.fun/en/#/guide/background_running
4. If you are using a non-system launcher app, please switch to the system launcher first.
5. If you are using a non-default system theme, try switching back to the system default theme (some themes will break  app widgets )
6. If none of the above works, please try restarting the phone
7. Try changing other launcher programs to rule out the problem from the launcher app.
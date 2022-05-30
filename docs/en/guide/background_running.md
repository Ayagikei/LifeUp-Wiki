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

**Warning:** 

These methods may increase the battery draining.

It depends on the OS and use environment. 

It is recommended to perform the following operations after encountering actual problems.


---

### Common ways to keep the app running in the background

1. Check your BATTERT options in the system SETTINGS app and disable the battery optimization for LifeUp.
2. Lock LifeUp in your multitasking pane.
3. (Optional but may help) Enable the `Quick Add notification` in the Task Setting screen.
4. When using functions such as Pomodoro and Reminder, make sure that you have turned on the LifeUp notifications, and have not turned on Do Not Disturb and special power saving modes.

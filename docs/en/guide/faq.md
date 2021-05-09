# FAQ

> Some parts of this article use machine translation, and the text may not be accurate. Welcome to revise. 

Due to the limited time and energy of the two developers, in order to quickly implement the entire incentive system, there are still many imperfect functions/details/interaction UI in the app, which can only be compensated by time.

If you help us to promote the application (whether it is to friends or app market reviews, or articles, videos), perhaps we can obtain more development/design resources to make `LifeUp` more perfect.

If the app really helps you, please consider buy us a coffee :)

[BuyMeACoffee](../html/buymeacoffe.html ':include :type=iframe width=210px height=80px')

> Click on the upper right corner to view the directory and switch.

## Tasks

-**How ​​to uncomplete tasks?**

1. When completed a task, click the "Undo" button in the prompt box at the bottom.

2. On the `History` page of the `Sidebar`, tap the `Undo` button.

3. On the `Ended` module on the `Calendar` page, tap the `Undo` button.

   >-You can undo non-repeated tasks at any time, as well as**repeated items that is completed today**.
   >-Because the [Team Tasks] involves functions such as server time calculation and dynamic publishing, undo is not supported.
   
   
-**How ​​to view historical overdue items? How to change their state to completed?**

  When the item is overdue, an overdue reminder dialog will automatically pop up, and the overdue item can be directly set to the completed state in it.

  After closing the dialog, you can also view or change the status of the tasks at any time on the `sidebar`-`History` or `Calendar`-`Ended` page.
  
   

-**Can I enable experience points or gold coin punishment?**

  Yes, the exp punishment is enabled by default (the factor is 0.2x). The coin punishment is not enabled by default (the factor is 0).

  It can be set freely in `Sidebar`-`Settings`-`Advanced Settings`.
  
-**How ​​to understand the repetition mechanism?**

  In short, you only need to manually set the**first** [start-deadline] time of the item and the repetition frequency, and the subsequent time will be automatically calculated by the application.


-**How ​​to hide completed items (actually unstarted items)?**

  There are two situations:
  
  1. If the item shows `xx date deadline`, it means that the item has started. You can edit items as needed and set the correct `start time`.
  2. If the item shows `xx date starts`, and the date is not the current day. You can check whether the folding button at the bottom is folded (▾shape); then check the menu bar (three dots) in the upper right corner of the homepage, click `Filter`, and check whether `Show Today Tasks` is selected

> Note:
>
> (1) The smart list (week, month) list does not support the folding function
>
> (2) By default, the complete cycle of repetitive items is the entire cycle. For example, a task that is repeated every 21 days can be completed every day of 21 days. If you want to display it only in the last few days, you can adjust the start time. (It only needs to be adjusted once, and the application will automatically calculate the subsequent date)


-**Does the deadline date allow to specify a specific time to the minute?**

  Yes. After setting the date, click the `time` button to set the specific time.

-**How ​​to set multiple reminders?**
  
  You can create multiple reminders by creating subtasks. And you can even use this function to set different copywriting for each reminder.

  

-**How ​​to create a to-do list for a specified day of the week? Such as every Monday and Wednesday.**

  When setting `Repeat Frequency`, select `Weekdays`.

  

-**[Xiaomi] The device does not respond to the counting items on the desktop widget, and the details cannot be entered in the blank space of the click items?**

  MIUI has a special permission "Background Application Display Interface", which requires manual authorization by the user.
  
  

-**Can subtasks be displayed on the homepage list?**

  Not currently supported,**configuration items may be arranged in the future**.

  Similar products actually have two solutions (home page display/editing only, details page display), the former has Google Tasks, the latter has tick lists, Microsoft todo and other applications. The two schemes have their own advantages and disadvantages, which are related to the definition of subtasks:
  
  1. The former is defined as a subtask and an important task, which requires attention. The advantage is that it is more convenient to operate the subtask. The latter definition of subtasks is a step definition and remarks, which only need to be paid attention to when the task is executed, so there is no need to display it in the list.
  2. When the display is not collapsed in the list, if there are too many subtasks, it will inevitably affect the display of the entire list.
  3. When the display is collapsed in the list, the operation cost is the same as that of entering the details page.

-**The law of Ebbinghaus memory method:**

  This repetition frequency is based on the forgetting curve. Since the minimum frequency of "Ren Sheng" is limited to one day, corresponding adjustments have been made. The timetable is as follows:
  On the same day → 1 day later → 1 day later → 2 days later → 4 days later → 7 days later → 15 days later → 30 days later, a total of 8 times
  
---

## Reward (experience value, goods)

-**How ​​to remove the shop item?**

  On the `Shop` page, long press the item, and then select the trash can button at the top.
  
-**How ​​to clear experience points and coins?**

  The corresponding value can be cleared in the `sidebar`-`Settings`-`Data backup, restore, clear` interface.

  Note: After clearing the value, the server data may not be synchronized in time. Please do not log in again or uninstall the app immediately, otherwise the previous data may be restored.

-**What is the upper limit of the attribute level and the experience value gradient?**

  It can be regarded as an unlimited level (currently 2000+, which can hardly be reached by normal means).

  The experience value required for each level will have a gradient adjustment, but the current gradient is actually unreasonable. (Therefore, it is not possible to evaluate the reward only by looking at the upper limit of the level. The upper limit of experience value is about 2^63).

  In fact, many users will be in the 2500 experience level for a long time, and the entire level system will be adjusted in the future (the total number of experience points will not be affected).

-**How ​​to set up a loan?**
  
  In the menu (three dots) in the upper right corner of the `Shop` page, select `Settings` to set the loan amount.

  > Note: The current loan implementation only allows negative values, and there is no corresponding set of redemption interest (to be developed later).

-**How ​​to customize attributes?**
  
  The name, description and icon of the property can be customized in `Sidebar`-`Settings`-`Advanced Settings`.

  > Additions and deletions are not supported for the time being, and the skill system will be launched in the future to achieve this part of the expansion.
  
  
  

---

## Reminder/Pomodoro/Countdown


-**Did not receive the reminder at the specified time [most devices]? Or the Pomodoro won’t ring [Huawei, VIVO devices]? Or the desktop widget data is loaded abnormally [Huawei device]?**

  In fact, there are instructions in the application. Due to the limited permissions of the independent application, the default reminder method will be restricted by the system, and it may become invalid after turning off the background.

  You can try to**change to the system calendar reminder mode (`Settings`-`Tasks Settings`)**, after the replacement, you can check whether the system calendar app has successfully inserted the reminder time.

  If the Pomodoro doesn’t ring after the screen stops, it’s possible that the background of the app was killed by the system. You can set the background management of the system, set "Ren Sheng" to not manage, and set the background permissions. (The operation steps of each system are different, please refer to [Background Running](guide/background_running.md)).


-**How ​​to use the countdown effect of the item?**

  The countdown effect will be in the form of app notifications. You can first confirm that the application notification permissions are normal.
  
-**Does the Pomodoro have a count-up/auto-next function?**

  After the current work timer ends,**will continue to count on the page**, you can decide whether to add this time to the focus time.

  The dedicated timing mode will also be planned and developed in the future.
  
-**Does the Pomodoro have the summary statistics function similar to the professional Pomodoro APP?**

 **Currently, the Pomodoro function of "Ren Sheng" is a secondary function and is in the early stage of development (still in the experiment, only enabled by default). It does not support complex summary statistics for the time being. Development will be arranged in the future.**

  For the time being, only support: the detailed record of each focus and the simple summary statistics of today in the "Status" page.

  > And since the Pomodoro module is relatively independent, you can contact the developer if you are interested in assisting in the development. Can accept and assist development in the form of interface docking.



---

## Miscellaneous
-**I don't want to use the world module, can I hide it?**

  You can go to the hidden world module in `Sidebar`-`Settings`-`Display Settings`~

-**How ​​to initialize the overdue and abandonment numbers in the "Me" page**

  The statistics here are based on historical records. You can go to the `sidebar`-`History` page to delete the corresponding error records.

  This page will be reconstructed later, or you can choose to ignore this value.

-**Step count is not accurate?**
  
 **As mentioned in the application guide, the Android system currently does not provide a unified way to obtain the number of steps, only the total number of steps can be obtained. If you connect to the sports SDKs of various manufacturers, it will affect the size of the application and access to permissions. At present, it seems that the gains outweigh the losses and will not be accessed for the time being.**

  Currently, the data is calculated by calculating the difference. Therefore, the accuracy of the data is related to the timing of starting the application and the timing of the phone restart (the best scenario is to open the application once every night at 23:59, and try not to restart the device). If you have a device such as a bracelet, you may need specific software to synchronize the number of steps to the sensor before the application can get it.

  If it is not accurate, you can try to manually enter the number of steps, or directly hide the step counter module in `Settings`-`Display`.
  
-**Is there a multi-platform version (iOS, PC, WEB)?**
  
  There is no multi-platform version at the moment. For a better user experience, LifeUp currently uses the Android native framework for development, and the code logic cannot be reused on multiple platforms. At present, the application volume is small and the profitability is very weak. We also lack manpower, technology and energy to learn and focus on cross-platform version development. Transplant the development results of the current two or three years of LifeUp to other end, even if you have mastered the corresponding development technology, there is a high probability that it will take more than half a year of development time cost (completely focus on the development of the other end, stop maintaining the estimated time for the Android end ), we cannot bear this kind of risk at present.

  The current plan can only attempt to develop a cross-platform version based on continuing to maintain the Android version in his spare time, and build building blocks step by step.

  If you are interested in participating in the development of a cross-platform version (the current plan is to use flutter), you are also welcome to contact us.


  ---
  
  
  
  ## For other questions, please contact us via email.

  kei.ayagi@gmail.com
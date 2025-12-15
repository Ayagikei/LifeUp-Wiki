# Release Notes

## Timeline

![timeline](_media/release_log/timeline.png)

## Notes

| Platform          | Version                | Update Date                 |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.101.3               | 2025/12/14                  |
| LifeUp-iOS        | check [feature/ulives] | 🎉Alternative app available |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v1.3.0                 | 2025/01/01                  |

(Part of the translation is provided by Machine/AI Translate and may not be accurate)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.101.3 (2025/12/14)**

**🐛 Bug Fixes**

1. Fixed an issue where the "Due Today" option incorrectly ignored the next-day deadline offset.

**v1.101.2 (2025/12/13)**

**🐛 Bug Fixes**

1. Fixed an issue where the search state was reset when returning to the Shop, Inventory, or Task pages.
2. Fixed a crash related to `AlarmManager` limits (approx. 500 concurrent alarms).
3. Fixed crashes related to dynamic colors, timezone dialogs, and pop-up menus.
4. Optimized crash reporting to ignore common network errors.

**v1.101.1 (2025/12/01)**

**🐛 Bug Fixes**

1. Fixed potential crashes caused by translation formatting errors.

**v1.101.0 (2025/11/29)**

**✨Features**

1. **Synthesis item filter**: Filter synthesis by items for faster lookup and management.
2. **Item details → Synthesis recipe**: View an item's synthesis recipe directly on the item details page.
3. **Shop → Synthesis entry**: If an item is usable in synthesis, a Synthesis button now appears next to the Purchase button.
4. **Inventory history filters**: Added filters by date, items, and description.
5. **What’s New dialog**: New version highlights dialog on first launch after update.
6. **Pomodoro per‑task focus time**: Refactored Pomodoro logic; supports custom focus duration per task.
7. **Item usage effect: “Record feelings after use”**; the feelings page also supports filtering by item.
8. **Pomodoro lifecycle broadcasts (API)**: Added lifecycle broadcast events.
9. **Simple query API**: Now supports fetching a single task’s details.
10. **Count tasks auto-increment**: Supports automatic increment.
11. **Recurrence end by date**: Tasks now support ending recurrence by a specific date.
12. **Desktop widget settings upgrade**: Improved the in-app desktop widget settings page so every supported widget can be previewed and, when the system permits, quickly added to the home screen.

**♻️Optimization**

1. **List management UX + dark mode**: Polished interactions and dark mode; the “All” list now shows a disabled delete state instead of an undeletable action.
2. **Shop settings page**: Moved to an independent page and accessible from the main Settings.
3. **Task default background**: Clarified wording in the help dialog.
4. **Quick Complete indicator**: When enabled, the tasks page shows a top indicator of Quick Complete state.
5. **Per‑list collapse memory**: Collapse/expand state is recorded per list to avoid “All” affecting the day list.
6. **Overdue dialog (dark mode)**: Improved dark mode styles when processing overdue tasks.
7. **Feelings filter button logic**: Only displayed for types that support filtering (items/tasks).
8. **Team local-tasks-only flow**: Improved interaction when collecting local tasks only.
9. **Synthesis page UI polish**: Refined the layout and visual feedback on the synthesis page for a smoother presentation.
10. **Item interaction polish**: Streamlined interactions related to items for a more responsive feel.

**🐛 Bug Fixes**

1. Fixed an issue where the top filter bar did not display correctly after filtering on the History page.
2. Fixed an issue where negative tasks might not calculate penalties with the correct 1× penalty count in certain cases.
3. Fixed an issue where the Pomodoro timer’s task picker could lose the “Cancel selection” option under certain conditions.
4. Fixed several issues around following the system dark mode settings.
5. Fixed a missing reward popup when a widget completed a count task.

**v1.100.6 (2025/11/08)**

**🐛 Bug Fixes**

1. Fixed a crash when selecting items if input focus overflowed due to external keyboards/gamepads; fix effectiveness under verification.
2. Fixed the smart time zone management dialog so it can scroll to reveal the bottom content and buttons.

**v1.100.5 (2025/09/28)**

**✨Features**

1. **Custom sound effects now support built-in sound selection**: Access a library of built-in audio effects for a more convenient customization experience.
2. **Enhanced synthesis filtering**: Added "Show only synthesizable" filter option on the synthesis page for better item management.
3. **API emoji support**: Item, attribute, and achievement APIs now support direct emoji input for enhanced customization.
4. **Team creation improvements**: Added ability to select target lists when creating teams for better organization.
5. **Team task copying**: Support copying team tasks as local tasks without requiring team membership.
6. **Task API enhancement**: Added parameter support for setting "light note font" state in task-related APIs.

**♻️Optimization**

1. **Improved "discard changes" logic**: Optimized the discard changes confirmation dialog for item editing, synthesis, achievements, and achievement lists - now only appears when actual changes have been made.
2. **Achievement unlock conditions**: Achievement unlock conditions are now expanded by default for better visibility.
3. **Enhanced synthesis performance**: Optimized query performance for synthesis details page.
4. **Toast API stability**: Improved stability and reliability of toast API calls.
5. **Team task completion flow**: Enhanced team task completion process with better error handling and user guidance.
6. **Synthesis drag behavior**: Improved drag-to-edge scrolling behavior when custom sorting items on synthesis page.
7. **Team task collection flow**: Enhanced workflow after collecting team tasks with support for jumping to corresponding lists.
8. **Calendar reminder optimization**: Improved calendar reminder related logic for better reliability.

**🐛 Bug Fixes**

1. Fixed issue where custom backgrounds from older versions incorrectly used global default "light note font" state.
2. Fixed status bar adaptation issues on custom sound effects page.
3. Fixed achievement description potentially overlapping with unlock buttons.
4. Fixed scrolling issues when drag-sorting on synthesis details page.
5. Fixed occasional disappearance of search button when World module is placed in sidebar.
6. Attempted to fix night mode system following abnormalities.
7. Attempted to fix issue where consecutive team task completions could lead to task duplication.
8. Fixed "feelings" functionality failure when unlocking achievements.

**v1.100.4 (2025/09/07)**

**♻️Optimization**

1. **Crash reporting improvements**: Enhanced crash collection and reporting for better issue analysis and debugging.

**🐛 Bug Fixes**

1. Fixed a crash issue caused by Facebook SDK.

**v1.100.3 (2025/09/06)**

**🐛 Bug Fixes**

1. Fixed an issue where searching was not working when selecting items.

**v1.100.2 (2025/09/05)**

**🐛 Bug Fixes**

1. Fixed an issue where **default list couldn't be selected** in certain situations when creating or editing items in the store.

**v1.100.1 (2025/09/03)**

**✨Features**

1. **Custom background font color options**: Added support for custom note font color options, further personalizing the interface experience.
2. **Enhanced item usage effects**: Random coin reduction effects now also support enabling the "Limit Usage" function.

**♻️Optimization**

1. **Calendar reminder functionality optimization**: Added options to adjust the duration of inserted calendar reminder events.
2. **Task editing interaction optimization**: Improved logic for the "discard changes" popup when editing tasks - no longer shows when exiting without any edits.
3. **Multi-language localization updates**: Updated localized multi-language text to improve user experience.

**🐛 Bug Fixes**

1. Fixed **compatibility configuration page and reminder settings page** not adapting to dark mode.
2. Attempted to fix **crash issues related to popup and input method focus** across multiple pages, improving app stability.
3. Fixed issue where **editing achievements couldn't change whether to automatically use items**.

**v1.100.0-alpha (2025/07/29)**

**✨Features**

1. **Pomodoro timer, experience values, warehouse history, coin details** added one-click jump to corresponding statistics page functionality.
2. Support for more flexible reminder event settings (X minutes before start or deadline).
3. Support for hiding synthesis lists.
4. Support for changing attributes for step counts and persistence rewards.
5. Support for customizing sidebar functional modules (such as putting store, community in sidebar or hiding unnecessary modules).
6. Added experimental option **"Low Restriction Mode"**: relaxes numerical limits within the app (such as experience values, coin digits, number of attributes selectable for tasks).
7. Optimized UI and interaction logic of overdue processing popup.
8. Added description for auto-use item options.
9. More repeatable unlock conditions support:
   - Daily pomodoro tree acquisition.
   - Daily pomodoro focus time.
   - Daily completion of N different tasks.
   - Daily use of a specific item N times.
   - Daily completion of a specific task N times.
10. Smart list options migrated to list management popup (click list button at top of task list page).
11. Added **"Quick Complete"** option: when enabled, completing tasks will skip all popups.
12. Extended the influence range of custom coin icons, now supports monochrome icons (such as coin icons at the top of the store).
13. Item details now identify which list the item belongs to, making it easier to confirm item ownership from warehouse.
14. When editing synthesis recipes, supports drag-to-sort and click-to-edit items.
15. Added API for directly editing coin numbers.
16. Query API supports querying pomodoro information (pomodoro count).
17. Numerical limits for some APIs relaxed (default API is low restriction).
18. **Redesigned and optimized achievement condition progress calculation mechanism**: Improved calculation performance and progress update speed.

**♻️Optimization**

1. Optimized persistence days on **"My"** page, supports manual click to recalculate.
2. Fixed RTL layout issues on calendar page, week start day set to **"Monday"** (previously Sunday).
3. Group display within task and store smart lists supports collapse/expand by group labels.
4. When task list expands completed, unstarted, frozen at bottom, corresponding labels will also appear at top.
5. Item icons imported from World module are persistently saved locally, avoiding inability to load when offline.
6. List selection popup now identifies smart lists.
7. Optimized default list logic for team tasks and random tasks: when default list is archived, defaults to selecting the first list.
8. Optimized overdue processing logic for count tasks: if count is achieved, defaults to **"Completed"** status.

**🐛 Bug Fixes**

1. Fixed issue where **"auto-use item"** checkbox state couldn't be correctly restored when editing achievements.
2. Fixed smart list top card counting issue: failed to exclude tasks belonging to archived lists.
3. Fixed global memory issue for item purchase **"auto-use"** checkbox state, changed to independent memory per item.
4. Fixed issue where unlock achievement API couldn't correctly update progress in certain situations.
5. Fixed default list logic issues for team tasks and random tasks.
6. Technical dependency library upgrades, target API version adjusted to 35 (Android 15).

**Alpha/Beta Patch Fixes**

1. Removed unnecessary dependencies and adapted to 16K page size, **reducing app package size**.
2. Fixed **auto-use item** functionality logic: For URL items, now only 1 item will be used with the rest stored in warehouse. (Previously only 1 would take effect but wasn't stored in warehouse, causing loss of usage effect)
3. Fixed issue where **repeatable achievement conditions** couldn't recalculate progress.
4. Fixed issue where **backup files** didn't include task templates.
5. Fixed issue where most emojis would regenerate abnormal icons after backup restoration.
6. Updated **QQ channel link** for in-app feedback.
7. Added **feelings publishing broadcast** feature.
8. **Redesigned** compatibility configuration and reminder method settings interface.
9. Added "Restrict item usage" option for **coin reduction effects**.
10. **API-related updates**: Added task API support for motivational message parameters.
11. Fixed abnormal top spacing issue on new item default settings page.

**v1.99.5 (2025/07/29)**

**🐛 Bug Fixes**

1. Attempted to fix the issue where custom backgrounds might not display correctly in certain situations.

**v1.99.3 (2025/06/30)**

**✨Features**

1. Subtask API supports relative adjustment (set_type).
2. Supports automatic cleanup of expired calendar reminder events.
3. Optimized processing logic for archived lists:

* Smart lists no longer display archived tasks.
- Tasks in archived lists do not automatically advance by default (similar to frozen status).

**♻️Optimization**

1. When continuously adding tasks/achievements, supports automatic scrolling to the top and focusing the input field.
2. Optimized the wording related to completing negative tasks.
3. Optimized the display logic for the "Discard Changes" pop-up on the edit task page.
4. Optimized the event duration for calendar reminders to avoid potential issues on some devices.

**🐛 Bug Fixes**

1. Fixed the issue where widgets did not support displaying custom coin icons.
2. Fixed the issue where the task detail page did not support displaying multi-item rewards.
3. Fixed issues where certain scenarios (e.g., widgets) might not adhere to list sorting rules.

**v1.99.1-rc02 (2025/06/20)**

**✨Features**

1. Supports repeatable achievement unlock conditions for "Complete N consecutive tasks".
2. New/Edit Task API now supports task type, and relative adjustment of gold/experience values.
3. Achievement API supports setting gold, and relative adjustment of gold/experience values.
4. APIs support jumping to specific achievement lists and synthesis lists.

**♻️Optimization**

1. Optimized the order of warehouse item history records generated when opening boxes.
2. Statistics page filter options now support memory.
3. Filter page options now support "Select All" operation.
4. Strengthened the deduplication interception logic for task creation.
5. Task detail page operations supplemented: freeze, adjust deadline.
6. Supports displaying synthesis list ID.

**🐛 Bug Fixes**

1. Fixed the issue where the previous Task API could not create/edit Ebbinghaus tasks.
2. Fixed the issue where the task list display and the list name in the top bar might be inconsistent when launching the app from the task list widget.
3. Fixed the issue where the text in the simple mode card might not be fully displayed.

**v1.99.0 (2025/05/17)**

**✨Features**

1. Added support for repeatable achievement types
2. Added notification reminder actions: complete task, remind later  
3. Custom background: added option to enhance text readability
4. Added support for adjusting achievement icon cropping styles
5. Added support for adjusting monthly/yearly task anchor dates

**♻️Optimizations**

1. Optimized achievement unlock progress calculation logic
2. Improved product selection interactions
3. Adjusted reminder permission button position in new/edit task screens
4. Optimized relative reminder time storage logic
5. Allowed freezing non-repeating and infinitely repeating tasks

**🐛Bug Fixes**

> Some fixes will be gradually rolled out to [Member Stable Version] and [Official Version]

1. Fixed issue where editing achievements might accidentally reset API unlock condition progress
2. Fixed issue where products with 0 stock could still be purchased via API
3. Fixed issue where deleted lists could be selected in new product page under certain conditions
4. Fixed issue where task templates couldn't save auto-calculated coin reward status
5. Removed detail page transition animations to fix long-press interaction failures
6. Fixed issue where frozen tasks appeared in Pomodoro task selection
7. Fixed issue where editing tasks through certain methods would incorrectly reset status to incomplete
8. Fixed interaction issues with feeling popups

**v1.98.5 (2025/05/01)**

**✨Features**

1. Added support for setting anchor dates (e.g., end of the month) for monthly and yearly recurring tasks.
2. Improved multi-select interaction for products: default to multi-select mode, and restore previous selections when re-selecting.

**♻️Optimization**

1. Added support for remembering relative reminder time settings.
2. Minor UI optimizations.

**🐛Bug Fixes**

1. Fixed the issue where products could still be purchased via API when store stock was insufficient.
2. Fixed the issue where task templates failed to restore automatic coin rewards.
3. Fixed the occasional failure of long-press on task titles.
4. Fixed the issue where new products could select deleted lists under certain conditions.
5. Fixed the missing clear button in the reminder time field when editing tasks.

**v1.98.4 (2025/04/14)**

**🐛Bug Fixes**

1. Fixed an issue where the progress bar might not update promptly after completing subtasks on the task details page.  
2. Fixed an issue where editing a completed task could incorrectly revert its status to "incomplete."  
3. Fixed an issue where modifying the status of overdue tasks might incorrectly affect the target completion count.  
4. Fixed an issue where the Pomodoro task selection logic incorrectly displayed frozen tasks and archived lists.  

**v1.98.3 (2025/02/16)**

**♻️Optimization**

1. Added a warning when using the default notification reminder method and lacking the "exact alarm" permission.

**🐛Bug Fixes**

1. Fixed an issue where the "complete task" API was not working when the UI field was true.
2. Fixed an issue where the purchase and use of certain quantities of items might not work correctly (e.g., 10).
3. Fixed an issue where the feelings page might show "loading" indefinitely in certain scenarios.

**v1.98.2 (2025/02/06)**

**🐛Bug Fixes**

1. Fixed an issue where, when using a item that deducts experience, there might be insufficient experience even when there is enough.
2. Fixed an issue where editing a item after copying it might result in abnormal duplicate usage effects.
3. Fixed an issue where calling the "adjust item" API might result in abnormal purchase limits.
4. Fixed an issue where modifying certain tomato records might result in an abnormal reduction in tomato counts.

**v1.98.1 (2025/01/14)**

**Bug Fixes**

1. Attempted to fix an issue with Google login authorization, where data for a limited number of accounts could not be correctly authorized and parsed.

**v1.98.0 (2025/01/01)**

**✨Features**

1. Integrated Google login and Drive authorization using Credential Manager.
2. Support for selecting Emoji as icons.
3. Added ContentProvider Query API: Synthesis functionality.
4. Added ContentProvider Query API: Tomato record functionality.
5. Added ContentProvider Query API: Support for multiple item returns.
6. Added tomato API (adjust tomato count).
7. Added export_backup API (export backup).
8. Added purchase_item API (purchase item).
9. Added synthesize API (trigger synthesis).
10. Added subtask API (create or adjust subtasks).
11. Added subtask_operation API (operate subtasks, e.g., complete).
12. Added synthesis_formula API (synthesis formula).
13. Added edit_task API (edit task).
14. Added category API (create or adjust list).
15. Added history_operation API (adjust history).
16. Added AppSettingsScheme API (adjust some app settings).
17. Added achievement API (create or edit achievement).
18. Added skill API (create or edit attribute).
19. Added support for displaying subtask id and gid.
20. Added support for displaying synthesis id.
21. Added support for querying creditLimit.
22. ContentProvider API supports querying subtasks (id, gid).
23. ContentProvider API query items: Added "maximum purchasable quantity" field return.
24. ContentProvider Shop API supports querying items by specified id list.
25. Optimized return value when querying incorrect ContentProvider URL.
26. Query interface supports querying single achievement.

**♻️Optimization**

1. Optimized default custom sorting for newly added items.
2. Optimized default custom sorting for newly added attributes.
3. Added `purchase_limit`, `disable_use`, and `effects` parameters to the "add_item" API.
4. Added `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time`, and `pin` parameters to the "add_task" API.
5. Added support for more task frequencies to the "add_task" API.
6. Added support for `effects` and `purchase_limit` parameters to the "item" API.
7. Added support for terminating operations in preceding APIs (e.g., input).
8. Added support for specifying the `signed` parameter for numeric placeholders.
9. Added random number and random decimal placeholders.

**v1.97.3 (2024/12/16)**

**✨Features**

1. Allows remembering the last selection of the "Use team description as task notes" switch.

**♻️Optimization**

1. Optimized the performance related to the usage effect of products.

**🐛Bug Fixes**

1. Fixed the issue of specific API call failures. When using a specific callback function to call the product API, the unpacking function works normally, but the internal API operation to add items cannot be executed.

**1.97.2 (2024/12/08)**

**✨Features**

1. Added automatic task generation using system's WorkManager mechanism to prevent missing task generation when widgets are not used and the app hasn't been launched for over a day.
2. Improved API exception handling by returning a unified success field and passing exception information to the content provider interface.

**♻️Optimization**

1. Optimized the default time generation logic to improve the accuracy of monthly and yearly time generation.
2. Optimized the logic for deleting unused image files by adding a secondary verification step from the database to prevent accidental file deletion.

**🐛 Bug Fixes**

1. Improved error messages for API when entities are not found.
2. Fixed concurrency issues in the built-in downloader.
3. Fixed Pomodoro statistics logic for cross-day scenarios, unifying record attribution to the time period of the end time (previously cross-day records couldn't be correctly attributed to the day's time period).
4. Fixed issues where task continuity and time period completion counts could be incorrect in certain scenarios.

**1.97.1 (2024/11/20)**

**✨Features**

1. Updated Translations.
2. Supported automatic display of multiple item rewards in notes.

**♻️Optimization**

1. Optimized network request handling to reduce unnecessary HTTP requests and improve performance.
2. Optimized the display of level in the status page, improving visual experience and efficiency in conveying information.

**🐛 Bug Fixes**

1. Fixed the color of subtask count text.
2. Fixed the time calculation errors for monthly and yearly tasks, ensuring accurate task trigger times.
3. Fixed the time calculation issues for monthly and yearly subtasks, ensuring all subtasks are scheduled accurately.
4. Fixed the issue where the task background could not be restored correctly when restoring from a task template, ensuring task background settings are applied properly.

**1.97.0 (2024/10/21)**

**♻️Optimization**

1. Optimized the display effect of task cards for unstarted tasks.
2. Addressed some performance issues.
3. Optimized the task detail page, resolving the issue where clicking the task name occasionally failed to trigger interactions.

**✨Features**

1. Added JSON format fields to the API broadcast for task overdue.

**🐛 Bug Fixes**

1. Fixed an issue where enabling Material 3 caused crashes when executing certain UI-related APIs.
2. Removed some obsolete experimental options, such as the feelings switch and the new attribute switch.

**🎉1.97.0-rc (2024/09/11)**

**✨Features**

**Key Updates**

- This update mainly focuses on performance optimizations and bug fixes.
- Significantly optimized the overall app performance. Retrieving task lists and performing various operations are now smoother. Target Android API version is updated to Android 14.

**Others**

1. When there are not enough coins, the item purchase button will now appear disabled.
2. Added the ability to search achievements by name in the achievement list 🔍.
3. Added support for font size settings within the app.
4. Optimized the random logic for World - Random Tasks, now reducing the frequency of the latest batch of tasks appearing, making it more randomized.
5. Optimized notification grouping logic, now notifications such as attribute and achievement unlocks should group correctly.
6. Statistics - Share now supports toggling the display of QR codes.

**♻️Optimizations**

1. Optimized network access logic.
2. Added a background blur effect to popups.
3. Optimized buttons in the shop, warehouse, and showcase pages, now using official Material button styles.
4. The Content Provider API for querying task history records now returns the task's end time.
5. The Content Provider API for querying task history records now supports filtering by task Group Id.
6. Updated the versions of many dependencies.
7. The Goto API now supports navigation to the "New Item Default Settings" page.
8. When navigating to the "Create Achievement" page via the Goto API, the category_id parameter is now required.
9. Added in-app guidance for task, counter task, and item link effects in the API.
10. Optimized the logic and error messages for new users checking for updates.
11. Added loading and error messages for account deletion operations.
12. Optimized the clickable area for completing the main task on the task detail page.
13. Improved the error message when importing backups, now more strictly preventing importing invalid backup files.

**🐛Bug Fixes**

1. Fixed an issue where, when creating a new task, if the error message for empty task content was triggered first, the error message would not automatically disappear even after text was entered.
2. Fixed an issue where the filter button was not displayed on the Statistics page when using bottom navigation mode.
3. Fixed layout issues on certain small screen devices with narrow aspect ratios.
4. Fixed an issue where subtask rewards might be abnormally linked when copying tasks (this issue occurred since version 1.96.0).
5. Fixed error messages caused by abnormal Dropbox connection during automatic Dropbox backup.
6. Attempted to fix memory consumption and crash issues when previewing extremely large images.
7. Fixed an issue where, after purchasing an item and marking it for use, the widget data would not refresh correctly if the use failed.
8. Fixed an issue where editing an achievement would change the completion time of the achievement and could wrongly trigger achievement unlock notifications.
9. Fixed an issue where, in split-screen mode on large screens, when displaying both the task list page and detail page, completing tasks, subtasks, or updating counters would not synchronize the two pages.
10. Fixed an issue where long-pressing overdue single tasks on the task list page would not allow clearing the deadline display.

**1.96.1(2024/07/11)**

**🐛Bug Fixes**

1. Fixed an issue where the displayed reward item count was incorrect when completing subtasks (actual rewards were not affected).

**🎉1.96.0 - beta01(2024/06/19)**

**✨Features**

**Key Updates**

1. When completing tasks or unlocking achievements, items can now be used directly to trigger item effects.
2. The limit for the number of items used at once is now relaxed to 1000.
3. Purchase of loot boxes or synthesis items now also supports direct use (open/synthesize).
4. Team tasks will now support posting feelings to local feelings.
5. Third-party URL Schemes in task notes are now supported for direct parsing and navigation.
6. The History page now supports searching historical records by task notes.
7. Added support for timing historical tasks.
8. The Statistics page now supports filtering by major categories.
9. Refactored the attribute experience reward and penalty popups: optimized the logic for item usage attribute selection limits, and split overdue attribute experience reduction popups.

**♻️Optimizations**

1. The UI effect for single selection when choosing items is now consistent with multi-selection.
2. Optimized the loading speed of the task list.
3. When adding or editing tasks, the due time is no longer required to be after the current time, providing flexibility for creating historical records.
4. If showing data IDs is enabled, the feelings popup will now also display the corresponding ID.
5. Optimized performance issues related to the overdue processing popup.
6. Unified the button order for countdown timing and pause states.
7. The interaction for deleting posts on the World Module - Personal Profile page is now more intuitive.
8. Optimized loading effects for the feelings and achievements pages.

**🐛Bug Fixes**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨Features**

**Major Updates**

1. Support for in-app split-screen display on large-screen devices such as tablets and foldable screens

**♻️Optimizations**

1. Store and Warehouse widgets now support consistent in-app cropping effects for images
2. On the statistics page, when only one day is selected, line charts are now supported

**🐛 Bug Fixes**

1. Fixed an issue where the task type displayed incorrectly when editing API tasks
2. Fixed an issue with abnormal task completion, abandonment, and overdue statistics on the statistics page

**1.94.3 (2024/05/10)**

**♻️Optimizations**

1. Widgets now attempt to update the theme to adapt when the system dark mode changes
2. When the "World" module is hidden, the red dot notification for system achievements no longer counts data related to the "World" module

**🐛 Bug Fixes**

1. Fixed a low-probability crash issue when multi-selecting items
2. Fixed a low-probability crash issue related to pop-up windows
3. Fixed an issue where the warehouse widget might not refresh when calling the modify item API
4. Fixed an issue where the warehouse widget could use "unusable" items

**1.94.2 (2024/04/26)**

**🐛 Bug Fixes**

1. Fixed an issue with abnormal task current count calculations (which caused inaccurate progress for tasks with set target repeat counts)
   - This fix rolls back a previous optimization related to the performance of undoing tasks, awaiting a more reasonable solution in the future

**1.94.1 (2024/04/22)**

**🐛 Bug Fixes**

1. Fixed an issue where the count of Pomodoros was calculated as one less than actual when using stopwatch, adding time via API, or manually adding time records.
2. Fixed a glitch where the selection bar might flicker and disappear after selecting items on the store/inventory pages and then scrolling.

**🎉1.94.0 (2024/04/22)**

**Key Updates**

1. Supports multiple item rewards
2. Inventory widgets

**UI Themes**

1. Custom (task, item text) colors now include more preset values
2. Adapted to Android 14's monochrome adaptive icon feature
3. Added many language adaptations (Google Play version)

**Achievements**

1. If there are achievements with unclaimed rewards, a small red dot will now be shown on the achievement list.

**Tasks**

1. Subtasks for penalty tasks will now execute the penalty logic properly
2. Added "Smart Time Zone Management"; if you are involved in cross-time-zone work, LifeUp also supports automatic detection of time zone changes and supports global time adjustments
3. The statistics basis on the details page now remembers the last selection, and we optimized some default values in certain scenarios
4. Optimized the grace handling of continuous task completion days on the "My" page, now if you forget to complete a task one day, catching up can still continue the streak

**Attributes**

1. Supports deleting experience records
2. Supports resetting the experience of an individual attribute

**Widgets**

1. Now, clicking the blank space in the store or inventory widgets directly enters the list the widget points to, instead of the last list
2. Task widgets now display the progress of count tasks

**API**

1. Added an API to edit Pomodoro records
2. Completing tasks API now also properly handles penalty tasks
3. Completing tasks API now also supports processing count tasks (adds `count` parameter)
4. Completing tasks API now supports a reward coefficient parameter
5. Adjusting items API now supports changing the item list id
6. Creating, adjusting items API supports sorting criteria parameter
7. Jump API now supports jumping to the use item popup
8. Unified some parameter definitions, like `itemId` -> `item_id`
9. Added broadcast notifications for starting, pausing, and ending a stopwatch
10. Adjusting items API's `title_color_string` now supports passing an empty string to restore the default value
11. Completing tasks broadcast now includes list id
12. Opening boxes, crafting now also triggers the use item broadcast

**♻️Optimizations**

1. Adding or editing tasks now includes a warning if no attribute is selected and experience is entered
2. Optimized upload retry records
3. Optimized the title display and input restrictions on the custom level page
4. Optimized the performance and timing issues of undoing tasks that have been repeated extensively
5. Refactored the use item popup, calendar interface logic, etc.
6. Optimized the related logic of task reminders, ensuring reminders from deleted or previous data are not issued again
7. Optimized waiting copy in the backup interface
8. Images selected in the custom attribute page are now also added to the history selection
9. Editing Pomodoro records now attempts to correct (increase or decrease) the right number of Pomodoros

**🐛Bug Fixes**

1. Fixed a system achievement related to stats and backups not being triggered normally after restructuring
2. Fixed potential conflicts between random API and toast API widgets with the default toast
3. Fixed the task detail not refreshing in some scenarios when entering from a widget
4. Fixed the potential for errors in multiple box openings in some special situations (preemptively using up item inventory)
5. Fixed the issue of not displaying subtasks in the details page after editing a task without subtasks and adding new ones
6. Fixed some special cases where editing coin rewards was not possible
7. Fixed some cases where claiming team items might not work
8. Fixed MD2 style anomalies in some bottom popups
9. Fixed potential incorrect additional time values in Pomodoro timers
10. Fixed the issue where the color bar in the experience change widget might not display
11. Fixed some tasks not displaying properly in the calendar-in-progress
12. Fixed some list loading issues on the history, Feelings pages
13. Fixed an issue where calling the complete task API twice in quick succession did not allow for two consecutive completions

**1.93.3 (2024/01/09)**

**✨Features**

1. Added the [Feelings] API.

**♻️Optimization**

1. The calculation of average value indicators on the statistics page now excludes future dates.
2. After hiding the system achievements list, no more alerts for unlocking system achievements.
3. Updated the `goto` API to no longer support pop-ups for purchasing "unbuyable" items.
4. Optimized the editing of tasks to solve the issue where the input for target repetition count was obscured.

**🐛 Bug Fixes**

1. Fixed the edge-to-edge UI effect on the custom attribute page.
2. Fixed an issue where the penalty would not be revoked if a task was set to abandoned and then completed on the history/calendar page.
3. Fixed the display style issue of the bottom popup and bottom system navigation bar in Material2 mode.
4. Fixed the incorrect border color of the to-do item input box in night mode.
5. Fixed a display issue that could occur after screen rotation when using the three-button navigation system mode.

**1.93.3 (2023/12/02)**

**♻️Optimization**

1. Unified addition of a debug parameter to APIs for easier debugging

**🐛 Bug Fixes**

1. Fixed the issue where selecting "Ignore reminder pop-up" was not effective
2. Fixed the issue with editing feelings created directly on the Feelings page
3. Fixed the issue where uploading team dynamic photos allowed selecting up to 9 images, whereas the actual limit should be 3
4. Fixed the issue where the use_item API would not trigger countdown or URL effects when ui is set to false
5. Fixed the issue where using items in the store widget might trigger the effect twice

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️Optimization**

1. Optimized the logic for database upgrades to avoid delays in database upgrade processes
2. Optimized the default value of the "Start Time" when editing tasks

**🐛 Bug Fixes**

1. Fixed an issue where editing product APIs led to the loss of product usage effects
2. Fixed the issue where overdue and abandoned tasks set to completed status did not restore rewards
3. Fixed a problem with custom task sorting not meeting expectations
4. Fixed display and sorting issues related to overdue single tasks
5. Fixed an SQL exception issue when filtering the history page
6. Fixed an issue in the simplified mode where clicking on the task title again had no response
7. Fixed an issue where renaming task templates did not take effect

**🎉1.93.0 (2023/10/24)**

**✨Features**

**UI Theme**

1. Fully adapt to Material Design 3.
2. Support customization of Material Design 3 theme colors, including custom colors, colors from wallpaper, and colors from images.
3. Improve some animation effects, such as pop-ups.
4. Optimize edge-to-edge (immersive) adaptation effects.

**Tasks**

1. Support task templates.
2. Statistics on the details page support switching based on time criteria and optimize default options.
3. The history page supports searching for task names and adjusts the related UI and interactions.

**Achievements**

1. Support secret achievements.
2. When adding achievements, support “Continue Adding Next Achievement.”

**Attributes**

1. Support hiding attributes.

**Pomodoro Timer**

1. Support editing time records.
2. In the Pomodoro page, support task completion (long press on the selected task while in pause mode).

**Feelings**

1. Support adding Feelings directly on the Feelings page.

**API**

1. Add the “use_item” API.
2. Add the “random” API.
3. Add the “edit_exp” API.
4. The “item” API now supports adjusting parameters such as “action_text,” “disable_use,” and “title_color_string.”
5. The “shop_settings” API supports the “silent” parameter.
6. Support the “time” placeholder. Now you can set tasks with dates like “due tomorrow” or “due next month” without the need for automation tools.

**♻️Optimization**

1. Added prefixes to some places displaying data IDs.
2. Optimized the display of team activities.
3. Attempted to address the issue where some Toast notifications were too long to fully display.
4. Improved the logic for widget completion in teams, ensuring consistency with in-app behavior.
5. Statistics page: After selecting a “Custom” time range, clicking “Custom” again now triggers a reselection of dates.
6. Ensured compatibility with Harmony OS 4 for progress bar notifications to display action buttons.
7. Enhanced the interaction logic of notification requests.
8. Addressed the issue where the input method could obstruct input for “Repeat Count.”
9. Now, when creating tasks, the user’s choice of non-specific start times (such as automatic or due today) is recorded. When editing, these options are restored, rather than specific times, to avoid discrepancies in edited times.
10. When creating tasks, if unexpected warnings about duplicates occur, they will now also be displayed in the “Check for Duplicates” pop-up.
11. Added Indonesian language support.
12. Updated translations.

**🐛 Bug Fixes**

1. Fixed the issue where, in certain cases, the world module could become stuck loading (spinning indefinitely).
2. Fixed the issue where, in certain cases, the shop/warehouse could keep displaying loading (spinning indefinitely).
3. Fixed issues that could occur when calling APIs with UI content via a content provider.
4. Fixed issues with task sorting that did not meet expectations.
5. Fixed the issue where data on the statistics page was incorrect after selecting a “Custom” time range.
6. Fixed the issue where pop-ups for notification requests did not support scrolling.
7. Fixed the issue where, in certain cases, the world module search displayed all content.
8. Fixed the issue where the “Show Completed” option also displayed frozen tasks.
9. Fixed issues with calculating average values on the statistics page.

**1.92.2 (2023/08/29)**

**✨Features**

1. Step statistics chart (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️Optimization**

1. The new team page now adds a reminder of the current word count and upper limit word count

**🐛 Bug Fixes**

1. Fix the problem that "LifeUp" may repeatedly create calendar reminder accounts under certain special conditions
2. Fix the problem that the menu button of the editing team is not displayed correctly
3. Fix the problem that the Pomodoro may not trigger the vibration reminder in the automatic start timing mode
4. Fix the problem that the Pomodoro notification may incorrectly display the focused items when no focused items are selected

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimization**

1. The duration on the status page and statistics page can now be displayed in the format of "XX days XX hours XX minutes."

**🐛 Bug Fixes**

1. Fixed the issue where the interaction for closing notification permission popup was not as expected on Android 12 and later versions.
2. Fixed the problem where the attribute pie chart might display as a transparent color, causing it not to appear.

**1.92.1-rc01 (2023/08/13)**

> Membership closed beta release date

**✨ Features**

1. The new version of statistics integrates the statistical cards from the old version, now merged into a single page and adapted to a bottom navigation bar mode.

2. Upgraded the in-app update mechanism and reminder function.

   Now supports three update channels: Stable Release, Stable Version of Membership Closed Beta, and Experimental Version of Membership Closed Beta, to focus on subsequent updates for closed beta members.

3. TargetSdkVersion is now adapted for Android 13 and dynamic notification permission requests.

4. Redesigned the profile editing page.

5. GP version optimized the login/offline mode selection process and instructions.

**♻️ Optimization**

1. Maintenance and updates to relevant technical dependencies.
2. Improved WSA adaptation and login instructions.
3. When backup fails, it will now provide a popup explaining the reason for failure, avoiding the issue of incomplete display of toast messages.

**🐛 Bug Fixes**

1. Fixed potential calculation overflow crash issue in the coin history record page.
2. Fixed the possibility of menu issues in the team details page that didn't align with expected permissions.
3. Attempted to fix the time deviation issue in the countdown timer.
4. Fixed the interruption of the task completion process and the disappearance of the reflection writing popup caused by screen rotation.

**1.92.0-rc02 (2023/07/16)**

**🐛Fix**

1. Fix the issue that the shop widget may not work when jumping to other apps (executing API)
2. Fix the occasional abnormality when switching lists in the shop widget
3. Fix the issue that the shop widget does not hide sold out or non-purchasable items according to the app settings
4. Fix the issue that the shop widget may not respond when clicking on a certain item
5. Fix some rare crash issues

**🎉1.92.0-rc01 (2023/07/11)**

**✨Features**

1. Statistics 2.0
2. Share card

**♻️Optimization**

1. Now you can set prices for “non-purchasable” items and use them for scenarios such as returns
2. When you turn off “Set task penalty separately” in the settings, the penalty button will no longer be displayed
3. Optimize the UI of subtasks in team details
4. Optimize the UI of impressions

**🐛Fix**

1. Fix the issue that when the attribute clipping style is changed to “rounded rectangle”, the edit icon may show the old icon for a long time

**1.91.3-rc04 (2023/06/07)**

**♻️Optimization**

1. The API for jumping to task details now supports task_gid and task_name parameters
2. The Content Provider supports the URL of the remote icon of the product
   - In order to fix the problem that some product icons cannot be displayed correctly on the desktop in the future

**🐛Bug Fixes**

1. Fix the problem that the shop list widget does not display the current coins correctly

**1.91.3 (2023/06/03)**

**✨Features**

1. Shop item list widget (big and small version)
2. Today's change widget for experience points
3. Added an API for jumping to task details
4. Feelings: now supports sorting in positive order of time, and adds year display

**♻️Optimization**

1. It is now supported to set prices for "unpurchasable" items and use them in scenarios such as returns
2. When the "independent setting task penalty" is turned off in the settings, the penalty button will no longer be displayed
3. Optimize the display UI of subtasks in team details
4. Optimize the display UI of impressions

**🐛Bug Fixes**

1. Fix the problem that if you clear the motivational words when editing a task, you cannot click "Confirm" to close the pop-up window
2. Fix the problem that the frozen task cannot be searched by using the API
3. Fix the problem that the store and warehouse cannot hide the default list

**1.91.2 (2023/05/09)**

**✨Features**

1. Shop and inventory lists support setting hide separately
2. `Goto` API now supports jumping to subpages of the main page (such as tasks, status, shop, inventory)
3. The coin statistics in the statistics now support the exclusion of purchase consumption

**♻️Optimizations**

1. When creating a new achievement or editing a locked achievement, the "Reset" button will no longer be displayed
2. The coin widget now supports clicking to jump to the shop
3. When the sound effect fails to play, a clear error message will be displayed

**🐛Bug Fixes**

1. When adding Tomato records, if the end time is set directly, the expected duration may not meet the problem
2. After repairing the task filter label, the input method problem will pop up
3. Fixed the problem that the ATM interest does not support setting the absolute value through the API
4. Fix the abnormal data loading problem of the history page
5. Fix the problem that when the widget completes the counting task, clicking "Cancel" will get stuck on the transparent page
6. Fix the problem that the statistics page cannot be automatically refreshed when it is in the bottom navigation bar mode
7. Fix the problem that the team task collection is abnormal when it is in the GMT +-x.5 time zone

**1.91.1 (2023/03/27)**

**✨Features**

1. Added "Notification Management" option to the Settings.
2. The New Task API now supports setting backgrounds.
3. Added API broadcast events related to product countdowns ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️Optimizations**

1. The feedback pop-up will no longer close automatically when clicked outside.
2. Widgets will no longer force completion of tasks that have not been started.
3. The task completion API will no longer force completion of tasks that have not been started when the "ui" parameter is set to true.
4. When the setting for individual task penalty coefficients is turned off, the previously set task penalty coefficients will be ignored and the global value will be used instead.
5. Automatically removes whitespace from URLs entered by users.
6. When the "Hide Unpurchasable Items" option is enabled and an unpurchasable item is created, a prompt will be displayed.
7. When the user enables custom levels but does not define any levels, it will now reset to the built-in level table.
8. Improved widget preview images.
9. Step inputs are now restricted to numbers. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. When using the built-in browser for product links, the "https" prefix is no longer required.
11. Added "Compatibility Configuration" instructions for the product countdown feature.

**🐛Bug Fixes**

1. Fixed unexpected click handling behavior when selecting products in the store and warehouse.
2. Fixed the issue where non-repeating tasks could not be set with a deadline when adding them via API.
3. Fixed the issue where custom attribute images may not update on certain devices.
4. Fixed the issue where custom sound effects may cause the app to crash. A new method has been implemented, which should make background sound effects more stable and use less memory, but the playback speed may be slower.
5. Fixed the issue where on Android 12 and above devices without the "Ignore Battery Optimization" configuration, enabling the automatic pomodoro timer or break time may cause a crash in the background.
6. Fixed the issue where product countdown sound effects were affected by the pomodoro sound effects setting.
7. Fixed the issue where floating-point calculation errors occurred when setting ATM daily interest rates in the API.
8. Fixed the issue where some images could not be loaded on Android 6.
9. Fixed the issue where, when restoring backed-up app data from a higher version to a lower version, error prompts were not displayed correctly.
10. Fixed the issue where some devices experienced layout overlap on the pomodoro page.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨Features**

1. Support custom level gradients.
2. Add initial batch of widgets:
   - Coins (small, large, target)
   - Attributes (small, large)
3. Support querying most of the data details in LifeUp through Content Provider API, including:
   - Offer a new version of "LifeUp Cloud".
   - Provide a rudimentary first version of the desktop version (Windows, Linux, MacOS) for local network use.
4. Support multiple selection deletion for tomato timer records.
5. Support setting automatic start of rest and work for the tomato clock.
6. API improvements and added fields, including:
   - ATM deposits and withdrawals.
   - Setting whether to prohibit purchasing for goods.
   - Setting label colors for tasks.
   - Directly set ATM balance.
   - Simple query for specified product details.
   - Add a third button and operation option to the popup interface.

**♻️Optimizations**

1. Improve query, processing speed, and performance when dealing with large amounts of data.
2. Fix the incorrect margins for adaptive icons.
3. Optimize the display effect of the tomato timer records.
4. Improve the interaction when restoring backup.
5. Add UI display for obtaining membership license through Google Play.
6. Provide a prompt to disable the one-click import feature if the selected backup file is not from LifeUp when importing directly from the file system.
7. Close the input method automatically when searching for goods in the product selection popup.
8. API behavior changes, including:
   - Confirm_dialog popup API. If certain button text or operation is not provided, the button will not be displayed. This provides greater flexibility in popup control, for example, you can set up a text-only popup without buttons for displaying text and motivational language.
   - Penalty API. In previous versions, it could only deduct up to 100 items, now the limit has been extended to 9 digits.

**🐛Bug Fixes**

1. Fix the issue where the tomato timer page would display "loading" at the end under certain circumstances.
2. Fix crashes caused by certain third-party libraries.
3. Fix the issue where the app would crash when placing the tomato clock in the bottom navigation bar due to a prompt popup.
4. Fix the abnormal display of attribute values when browsing other users' profiles.
5. Fix the issue where the API events and notifications for attribute level reductions were not sent correctly.
6. Fix some interaction issues with long press-editing pages.
7. Fix some abnormal margins on the image management and synthesis pages.
8. Fix some popup windows that were not scrollable, resulting in abnormal usage in landscape mode.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Support reading and authorizing operations for Content Provider information.
2. During service startup, apply for a wake lock to allow response even when the screen is locked.
3. Add a series of interfaces for Content Providers.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Initial release, designed to be used in conjunction with "LifeUp Cloud" and the mobile app.

Support the following operations:

- Query tasks, lists, goods, achievements, feelings lists.
- Purchase goods, complete tasks.
- Support using the desktop image browser to view enlarged images of feelings.

**1.90.7 (2022/11/07)**

**✨Features**

1. Added: Vietnamese translation and translator's signature (Google version)
2. Added: "Skip cropping" image selection method, which is suitable for selecting gif animations (member function)
3. Added: delete task API
4. Added: Support setting to abandon the task sound effect
5. Added: Simple synthesis MAX quantity operation
6. Support re-locking unlocked achievements
7. "Add Product API" supports specifying list id

**♻️Optimization**

1. Improve the description of deleting history
2. The experience limit is changed from (3/4 places) to (4/5 places)
3. Added penalty coefficient display on details page
4. Globally improve the interaction design of the date-time selection box
5. The achievement details pop-up window will now differentiate the icon color according to whether the conditions are completed or not.
6. Change tomato shortcut icon
7. When creating an item from a smart list, if the selectable list is 0 or 1, automatically select it
8. The developer mode displays the item list ID
9. Limit the input length of some common fields to avoid crashes

**🐛 Fixed**

1. Fixed the problem that the reward calculation for changing the item history record was abnormal in some scenarios
2. Fix the problem that the "Show Archived" switch does not match the display in some scenarios
3. Improve the data loading logic of the widget (may fix some abnormal problems)
4. Repair the automatic calculation logic of manually adding timing records, now you only need to fill in any item
5. Fix the abnormal refresh problem of the tomato timing record page
6. Fixed the problem that sub-tasks could not clear commodity rewards
7. Fixed the problem that after selecting all items, re-selecting some items does not take effect
8. Optimize the memory required for preview images
9. Widget refresh is now triggered after adjusting the list order
10. Optimized the problem that some backup methods will get stuck on the interface

**1.90.6 (2022/10/21)**

**✨Features**

1. Add API for setting the number of steps on a specified date
2. Added API for querying the status of specified attributes (experience value, level)
3. Support direct import of backup data from file manage
4. APIs related to reward items are no longer limited 99

**♻️Optimization**

1. Optimize the transition animation effect when entering the event details page
2. Optimize the edit items page, increase the UI effect of enabling penalty, and improve its guide
3. Change the operation icons on the timing page
4. In the purchase pop-up window, add warnings and instructions for items with negative own numbers
5. Optimize the immersive status bar effect of the home page
6. Added compatibility configuration reminder to Pomodoro page
7. Improve the speed of exporting backup and restoring backup files
8. Instructions for the stock number setting
9. Temporarily remove the setting of [When the product inventory is 0, the corresponding task reward will be automatically removed].
10. Optimize the license check mechanism with free trial version.
11. When a task that is "Pin" is selected, the action is now displayed as "Unpin"
12. When switching to positive timing, the *experimental* warning no longer pops up every time

**🐛 Fixed**

1. Fixed the abnormal system boundary of some pages or with tablets
2. Fixed an issue where incorrect data would be displayed when entering the inventory for the first time in some cases
3. Fixed an issue that data cannot be recovered at all due to internal damage (such as image damage) when restoring damaged backup files
4. Fixed an issue that the "Buy" button will be displayed unexpectedly after long-pressing the sold-out item
5. Fixed an issue that the attribute introduction of the new team page is the old version

**1.90.5 (2022/09/22)**

**♻️Optimization**

1. Adapt to some devices with abnormal webp conversion (the cropped image may be larger than the original image on these devices). After selecting a picture, determine the size of the picture and perform secondary compression.
2. Improve the description of target repetitions in the details page
3. Support the use of the same product to accumulate the time during the countdown
4. Add more novice guide tasks
5. Update translations

**🐛 Fixed**

1. Fix the abnormal UI problem of the composite page
2. Fixed several known crash issues
3. Improve the problem that the countdown of goods may be abnormally interrupted and accumulated time under long-term countdown
4. Fix the UI exception of the input feeling pop-up window when the widget completes the task

**1.90.4 (2022/09/15)**

1. Fix the abnormal problem when the widget completes the task (may cause a transparent page to appear, and the operation cannot be continued)
2. Disable the widget's ability to select images from impressions

**1.90.3 (2022/09/14)**

1. Fixed the focus issue when sorting subtasks
2. Improve attributes color in frozen/unstarted tasks
3. Add given-up tasks event broadcast
4. Fixed the probability text color
5. Improve the starter tasks(preset tasks)
6. Fixed the issue that the import items dialog may select the "All" list by default
7. Fixed the shop item group issues
8. A warning is now given when setting an unusual time (time does not match repeat frequency).
9. Improve the task calculation rules in the calendar, which should now accurately predict the deadlines of future tasks.
10. Fixed an issue where the completion of the calendar could be calculated for frozen tasks.
11. Improved default start time settings when editing tasks.
12. Improve license detection mechanism.
13. Optimize the processing of the countdown of items. Repeated execution is prohibited to reduce the time accumulation problem that does not meet expectations.
14. Fixed edge-to-edge issue when using virtual keys on some pages.
15. Fixed an issue where you couldn't select a thought image when the desktop widget completed a task.

**1.90.2 (2022/08/31)**

**✨Features**

1. Add broadcast events.
   Now you can use Tasker/MacroDroid to receive events such as using items, completing tasks, etc., and triggering Tasker's actions.

   For example: If the item is used, it will trigger the replacement of random wallpapers.
   In theory, if you want, you can implement functions such as application locks and game interaction scenarios.

2. New API:

- Give up tasks
- Freeze tasks
- Unfreeze tasks
- Empty interface
- Query

3. Added return value for add new item and task API
4. When importing items from the market, now you can select the target list
5. Adapt to the secondary color of Material 3
6. Update language translation, add Korean language support

**♻️Improvements**

1. When unboxes in batches, also display the probability of a single product
2. Optimize some UI display effects in night mode
3. Optimize the interactive logic of the date-time selection pop-up window. When selecting the current day, it will automatically switch to the time selection page.
4. When the API calls item selection and list selection, the pop-up window no longer supports direct closing (to prevent API calls from being lost)
5. Optimize the default height of some pop-up windows at the bottom of the tablet horizontal screen
6. Optimize the automatic closing timing of the pop-up window

**🐛 Fixes**

1. Fix the problem that the API search task may fail in some cases
2. Fixed occasional crash on the task list page
3. Fixed the problem that the "Undo" operation button appears when long-pressing the normal achievements that are not unlocked.
4. Fixed an issue where the achievement details pop-up window might be displayed incompletely
5. Fix the problem that when uploading the window, it may fail due to the abnormally large picture
6. Fix the problem that own_number and stock_number of item API do not support negative numbers
7. Fix the problem that the number of days of persistence on the "Me" page is sometimes abnormally displayed as 1
8. Fix the problem that sometimes -x days ago is displayed
9. Fixed the issue that subsequent APIs may be canceled abnormally when calling APIs in batches
10. Fix the problem that the content filled in by the new team may be lost when the page is destroyed

**1.90.1 (2022/08/22)**

**🐛 Fixes**

1. Fix API call concurrency issue
2. Fix the problem that when a large number of products (thousands) are selected, multiple selections of products may cause a freeze
3. Fix the abnormal problem when the widget completes the team task
4. Fixed the issue that editing subtask experience would not be backfilled

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨Features**

1. Optimization of task reward settings:
   - Reward settings UI adjustment
   - Sub-task support setting experience and item rewards
   - Change the original "only text" reward to an independent "words" reward
   - Support setting default experience value

2. Items support setting attribute level purchase restrictions.

3. The item supports the "URL" effect.
   Not only can you jump to web pages, but you can also call other applications or the API of LifeUp. Realize the effect of increasing the price after using the item.

4. **Open APIs.**
   Now you can match automation software or carry out secondary development.

   [For more details, please check the API documents.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. The shop supports viewing the unrefined counting effect

6. Notification optimization:

   - Add attribute level changed notification
   - Add unlocked achievement notification
   - Notification group optimization

7. Support adding timing records manually.

8. Now support setting the Pomodoro page to the navigation bar

9. Support to hide [System Achievement] list

10. The target API version is adapted to Android 12L

11. Optimization of immersion effects

12. App Widgets supports displaying the pop-up window of completing the task

13. Now you can complete the task on the matter details page

14. In the overdue pop-up window, you can set the number of count tasks

15. You can now edit the name of the team task

16. Optimize the network request timing of the world module, reduce traffic consumption and reduce server pressure

**♻️Improvements**

1. Night mode now supports all theme colors, and makes a separate night color customization for each theme color, which is adapted to Material 3
1. Add the "battery optimization" link in the Compatibility configuration dialog
1. Add the "Keep screen on" switch in the Pomodoro Settings
1. Provide the two options: "End" and "Add up" for the countdown of the item in the paused state
1. When the number of editing targets is greater than the current number, an error prompt is provided
1. Negative matters should not be displayed in penalty factor settings
1. Optimize the refresh effect on the History page
1. Optimize the logic of automatically triggering the main task after completing the sub-task, and change it to directly on the details page processing
1.

**🐛Fixes**

1. Fixed the issue that the + button will show on the Moments page sometime
2. Fixed the issue that negative tasks will not pop up feelings dialog
3. Fixed the issue of the goal of negative tasks without taking effect.
4. Try to repair the effect of setting "freezing to ..." for team tasks
5. Fixed the issue that the picture of the feeling page may be displayed wrongly

**1.89.5 (2022/8/5)**

1. Optimize network connection problem
2. Update translation

**1.89.4 (2022/7/13)**

1. Fix information about Xiaohong Dot Questions
2. Repeat the task repeatedly generating problems (this time it should really be repaired .jpg)

**1.89.3 (2022/7/05)**

**♻️Improvements**

1. Optimize the judgment of the sliding switch list

**🐛Fixes**

1. Fix the problem that the calculation may not be completed when there are a lot of achievement
   conditions
2. Fix the problem that the notification reminder of the indefinite task will display an abnormal
   deadline
3. Fixed the issue that editing the background of an item would affect the copied item after copying
   an item
4. Fix the problem that the skill of editing team tasks may not be inherited

**1.89.2 (2022/6/23)**

**♻️Improvements**

1. Remove unnecessary CARMRA permission
2. Update translations

**🐛Fixes**

1. Fixed some crashes

**1.89.0-1.89.1 (2022/6/09)**

**✨Features**

1. Support multi-unlocking conditional achievements
2. achievement details support viewing condition details and progress
3. Tasks tag
4. Repeative tasks with no deadline
5. Hide items that're sold out or disabled purchase
6. When setting the experience value reduction effect for the item, it is optional to limit the use
7. The inventory page supports multi-select, select-all and batch returns
8. Default task list supports archive operation
9. Resign some pages such as settings, Q&A, shop tool bar, and add lists page
10. Redesigned some in-app icons (default tasks card icons, coins, experience points, achievement
    icons)
11. Image storage moved to external app private path to prevent accidental file deletion

**♻️Improvements**

1. Added [Compatibility Configuration] article link to the settings page
2. Pomodoro countdown - reset operation adds confirmations dialog
3. Added description for task freeze
4. Added description for achievement sub-categories
5. In offline mode, add a button to exit offline mode on the edit profile page
6. Optimize the statistics of plenty(negative) tasks, support the display of the given-up number of
   times of the day and support the tracking of achievements
7. Optimize application startup speed
8. Achievement icon support to view larger image
9. Added likes (received) statistics for random tasks
10. Unified optimization of search interaction
11. When selecting an item, switch to an empty list to display an empty layout (instead of loading)
12. View the large image page to adapt to the current theme color settings
13. Optimize the animation effect when the height of the selected item and task pop-up window
    changes
14. In backup settings, "Delete local data" also supports deleting media files
15. Unified the storage and deletion logic of temporary files for taking pictures
16. Distinguish between the default item icon and the icon that fails to load
17. Enable the independent plenty setting for tasks by default now
18. Optimize the refresh, animation logic and loading speed of the feelings page
19. Some details pop-up windows add a shortcut "select" button
20. When the main switches of "sound effects" and "vibration" in the advance settings page are
    turned off, corresponding instructions are also provided in the tomato settings.
21. New achievements and sub-category sorting optimization
22. Base library and dependency upgrade
23. Optimize the calculation method and speed of achievement progress
24. Improve the calculation method of "target (repetitions) times" to follow the statistical
    improvement of historical records, which is consistent with the number of times in the details
25. When entering the number of coins and the number of target repetitions, all current values will
    be automatically selected
26. Optimize the error prompt when WebDAV configuration is abnormal
27. Optimize the error prompt when the Google Drive backup is abnormal
28. Now supports selecting the task name on the details page

**🐛Fixes**

1. Fixed the problem that the set count affects the tasks reward invalid after the tasks executes
   the repetition logic
2. Fix the sorting and grouping problem of the shop page
3. Fixed the abnormal problem of page up and down in random tasks in some cases
4. Fixed the problem that the pomodoro stat on the status page was inaccurate after using the
   positive timing in some cases
5. Fixed the issue where the repeat logic of team tasks would lose the count tasks type setting
6. Fixed an issue where the task being selected by Tomato would be highlighted when selecting tasks
   related to achievement conditions
7. Fix the problem that the feeling picture is not stored independently and displaye issues
8. Fix the problem that the failure prompt may pop up frequently when the login fails
9. Some special input boxes for new tasks, teams, and subtasks should not allow keyboard input,
   which may cause the app to crash
10. Optimized the way to count the number of completions of unlimited items in app widgets,
    consistent with the in-app
11. Fixed the issue that after the ATM adjusts the interest rate, the interest may be calculated
    based on the accumulated time and the adjusted interest rate
12. Fixed an issue where frozen tasks might still be displayed in the smart list
13. Optimized the problem that the action button blocked by the selection bar can still be clicked
    when certain objects (tasks, shop items) are selected
14. Fixed an issue where changing the color of an item would not refresh the UI immediately 15.Fixed
    an issue where suddenly setting a high interest rate after keeping the interest rate low (failed
    to get 1 gold) may get huge interest
15. Fixed the problem that the search box pops up after completing the task after opening the search
    bar and using the product
16. Fixed an issue where the number of in-app completions of the day might not match the widget
    after changing the name of an infinite task
17. Fixed weird animations when completing unlimited tasks
18. Fixed an issue where copying a task would not copy the background of the task
19. Fixed the problem that in some cases, the achievement conditions were completed, but the
    achievement could not be unlocked
20. Fixed date interval calculation exception issue (may potentially affect multiple logics)
21. Fixed the problem that the feelings are not automatically filtered from the tasks detail page

**1.88.4 (2022/4/21)**

1. Fix the problem that warehouse search will cause crash
2. Fix the display disorder of custom background and history page
3. Fix the UI overlap problem when editing
4. Fix the problem that the quantity may be displayed abnormally when the achievement is rewarded
   with goods
5. Fix the problem that the completion times of achievement calculation items may not match the
   actual times in some special cases
6. Fix the problem that the title may disappear when the history page is clicked quickly
7. When creating or editing an item, after clicking on the property, the soft keyboard cannot be
   popped up by clicking the input box that is in focus again.
8. Fixed the crash issue when setting monthly purchase limit in French language

**1.88.3 (2022/4/09)**

1. Fixed that after restoring the backup, the cloud backup will prompt a conflict problem
2. Fixed the problem that the edited task start time and subtask reminder time did not select the filled time by default
3. Fix the problem that other effects will only be calculated once during batch simple synthesis
4. Fixed the issue that any attribute of the system achievement reaching level 10 would not be counted into the custom attribute
5. Fixed the abnormal display of the text UI on the "My" page for non-members

**1.88.2(-)**

> Updates included in 1.88.3

**1.88.1 (2022/4/02)**

1. Fix a crash caused by backup reminder

**1.88.0 (2022/3/30)**

✨Features

1. Added the function of sharing "random tasks" in the world module
2. Counting items can optionally set the coefficient to affect the number of items
3. Support setting loan interest rate
4. Picture management supports one-click filtering of unused pictures + select all operations
5. Support custom image cropping size (that is, use higher-definition icons, membership functions)
6. Explicitly display the "feelings" switch within the achievement
7. Optimize the sorting algorithm of the "All" list

⚡️Optimized

1. Optimize the visual effects of some pop-up windows
2. Optimize the interaction of backup/restore functions
3. Optimize the loading speed of the delegated page
4. Greatly optimized the loading speed of the product selection pop-up window

🐛 Fixes

1. Fixed the problem of custom background disorder
2. Fixed the problem that the task may be created to the deleted list
3. Some crash bug fixes

**1.87.1（2022/3/07）**

1. The sorting menu of shop and inventory explicitly displays "custom" sorting
2. Fix the problem that abnormal sorting may occur in the inventory
3. Added a button to jump to email feedback on the feedback page
4. Optimize the prompt for restore failure due to database version problems
5. Fixed the problem that the number of coins in the compact mode card is not displayed

**1.87.0 official version (2022/3/04)**

1. Fix the problem that the custom card background will zoom abnormally in some cases
2. Fixed an issue where clicking on the task reminder notification may jump to the wrong task details when continuously receiving task reminders
3. Fixed the problem that the numbers on the card were not refreshed normally when sliding to increase the count task count
4. Added new  guide task for some language

**1.87.0-rc02（2022/2/25）**

1. Improve error handling and prompts for recovery operations
2. Optimize the interaction of setting "day of the week", and increase the warning of abnormal setting (start-period is not on the same day)
3. Optimize the night mode color matching of some pages
4. Fix the problem that the cache may be displayed incorrectly in the picture selection box and picture management
5. Fixed the problem that the "Download" operation in the backup conflict pop-up window does not support Google Drive/Dropbox
6. Fix the problem that the search of the store may show wrong results
7. Fix the problem that the top of the task may fail
8. Fix some UI exceptions and text issues

**1.87.0-rc01（2022/2/23）**

**✨Feature**

1. Achievement sub-category supports folding operation
2. Introduce the Material You design style switch (experimental)
3. Inventory supports sorting by shop
4. Inventory supports commodity "star" operation
5. The shop supports select all operations
6. Shop and Inventory related operations support selecting MAX quantity
7. Tasks support continuous creation
8. Task support configuration: The description of the product reward will be automatically added to the card remarks (that is, "Reward: [a product] x1" will be automatically displayed)
9. The task supports the specified freezing duration

**⚡️Improvements**

1. Add a "Skip" button to the backup conflict pop-up window
2. Play version supports French/Polish
3. Task click notification reminder now supports jumping to task details
4. When editing the time related to the task, the default pop-up window will point to the time before editing instead of the current time
5. Each list selection entry of the store supports "Rename", "Delete", "New" operations
6. Extension page UI redesign
7. Added a second confirmation pop-up window for "Delete Calendar Account"
8. The product will no longer be automatically removed from the shelf if it is sold out
9. The "Get up early" task in the example task is changed to 0 penalty
10. When getting an item reward, if the item quantity is negative, a related warning will now appear
11. Optimize the random algorithm of gold coins in the effect of commodity use
12. "Set as complete" operation adds complete sound effect
13. Optimize some UI display in night mode
14. Optimize the performance of the task list

**🐛Fixes**

1. Fix the abnormality of "unconcerned" copy in some languages
2. Fix the problem that the product icon on the "Return" pop-up window may display abnormally
3. Fix the problem that the task may be repeatedly generated when the task is completed quickly
4. Fix the problem that the memory of the current list of the "synthesis" system may be invalid
5. Fix the problem that QQ login may not be possible in the horizontal screen state
6. Fixed the issue that when editing a recipe in the [All] list in the "Synthesis" system, the recipe might disappear from the original list
7. Fixed an issue where clicking to complete an infinite task multiple times in a row may cause the display of the number of completions to return to zero
8. Fixed the issue that the backup interval could not be set to "Monthly"
9. Fix the problem that the experience icon is not displayed in the simple mode
10. Fix the problem that the "Achievements" and "Achievement List" columns are missing in the picture management
11. Fix the problem that the task details page does not support abandoning team tasks
12. Fix the problem that the guide of the world module is not displayed correctly
13. Fix the problem that the product can be successfully shared when the image upload fails, but the local image will be overwritten
14. Fix some rare crashes and exceptions

**1.86.0（2022/1/20）**

**Feature**

1. Achievement sub-category: Divide categories, automatically count category counts
2. Google Drive backup
3. Picture management function (in the backup page)
4. Product random gold coin effect
5. Batch copy of achievements
6. Step counting supports multiple input of steps and multiple rewards
7. Pomodoro supports setting up commodity exchange
8. Support custom return discount ratio
9. Use exclusive format for backup (some systems support direct opening and import backup)
10. Simple synthesis supports batch operation
11. Newly added custom sound effect option: commodity use
12. New achievement unlocking condition: current ATM deposit
13. Statistics on the number of times that negative matters support the detail page
14. "All" list supports renaming
15. The naming and description of notification channels for unified applications

**Improvements**

1. Prioritize achievements that have been unlocked but not received rewards
2. The Pomodoro Today’s focus time on the status page will be displayed in hours according to the time.
3. The warehouse adds commodity description display
4. New account registration will pop up a confirmation dialog
5. Support for displaying maintenance announcements
6. Added "Skip" confirmation dialog for Pomodoro Extra Time
7. Support saving data when uninstalling the application (system support required)
8. Optimize backup and recovery logic
9. Optimize the overdue logic of single items and unlimited items, and support editing
10. Optimize the chart statistics time basis of unlimited events, based on the completion time rather than the deadline time
11. The compact mode card will also show the overdue time of single and unlimited items
12. Try to improve the survival rate of the countdown function in the background
13. Optimize the impression function:
    -On by default
    -The team task setting page does not display the "Impressions" switch that does not actually take effect
    -Remove the confusing feeling switch memory function
14. Select the pop-up window for the list of commodities and warehouses to increase the number of commodities displayed
15. When the notification bar continues to time, the vibration effect in progress will also be cancelled
16. The dynamic text in the world module supports selected copy
17. Optimize the data refresh animation effect of the custom achievement page
18. Optimize the recovery logic, display the "Loading" dialog box instead of directly stuck interface
19. Optimized the problem that the bottom button may not be seen in the "Crash pop-up window"
20. Click the task notification reminder, and now it will jump to the list page where the task is located
21. Custom attribute icon, now supports selecting application built-in icon library
22. Optimize the "Read Later" sharing operation name instead of directly displaying the application name
23. Optimized the notification of achievement unlocking, the achievement description will now be displayed
24. When the desktop widget enters the homepage, it will automatically jump to the "delegation" module
25. Optimized the display of copywriting after the completion of the day list
26. Optimize the operation copy and sequence of the product countdown effect
27. When all attributes are hidden, the status page no longer displays the "Attribute" card

**Fixes**

1. Fix a rare crash issue when unlocking pop-up windows for achievements
2. Fix the display problem that one task may squeeze multiple lines when emptying desktop widgets with insufficient width
3. Fix the issue that the first exercise authorization for step counting may support the display of the total number of steps accumulated by the sensor
4. Fix the crash or recovery confusion when pausing a countdown and then starting another countdown
5. Fix the problem that the 0-minute countdown effect of the product can be entered and it will crash
6. Fix the problem that the name of the currently selected list is not refreshed in time when renaming the currently selected list on the page of adding or editing items
7. Fix the abnormal display of cards with repeated frequency of "annual"
8. Fix the problem that custom gold coins will not take effect in time in some cases
9. Fix the issue that widgets will display frozen items
10. Fix the problem that the custom achievement does not display the "long press operation" prompt
11. Fix the problem that the total experience value of the "My" page does not count the experience value of the custom attribute
12. Fix the problem that the "Impressions" page refreshes back to the top after previewing the picture abnormally
13. Fix the problem that the static shortcut of "Tomato" will only jump to the homepage when the application has been started under MIUI system
14. Fixed an issue where non-members might also load custom backgrounds
15. Fixed the problem that the number of gold coins on the store page was not refreshed in time
16. Fix the problem that the calendar cannot be turned to the next year
17. Fix the problem that the list name on the widget will not be refreshed in time after the name of the list is modified

**Release Candidate -> Official Version**

1. Optimize the success rate of uploading large files on Google Drive, increase the retry and optimize the block strategy
2. Fixed the problem that members may not display the button for individual custom task backgrounds in a non-Chinese environment
3. The backup of Google Drive/DropBox failed and jumped to the backup page instead of the WebDAV configuration page
4. Add a pop-up window description of Google Play verification failure, and provide data export path
5. The nickname of the "My" page changes color according to the membership status
6. Eliminate the floating point error problem of ATM interest rate in most scenarios
7. When deleting local data, custom background, attribute picture and sound effect files will also be deleted synchronously
8. Fix the abnormal problem of step count chart
9. Fix the problem that the properties of the new to-do page are not refreshed after clicking the question mark button of the property from the new to-do page, jumping to the property customization page for editing, and returning to the new to-do page
10. When customizing the effect of the product, clicking outside the pop-up window will no longer automatically cancel the pop-up window, avoiding the loss of editing content
11. Optimize the foreign language UI problem of the product setting page (the Russian text is too long)
12. Attempt to fix the crash of color toast on some models
13. Fix the problem that the use button can still be clicked when the warehouse page is selected
14. Fix the logic of displaying overdue single tasks in the smart list, and adapt to the new overdue time storage method
15. When the warehouse is selected, the toggle list should be deselected

**1.85.4 (2021/12/08)**

Regular bug fix version, the next feature version is still under development~

1. Fix the problem that the default icon of the gold coin of the widget in the non-dark mode is not displayed correctly
2. Fix the problem that the animation of the progress bar does not play normally in the case of continuous upgrade/downgrade
3. Fix the problem that the number of gold coins on the warehouse page is not updated in time
4. Fix the issue that the deadline may be forcibly changed when editing the "day of the week" item
5. Fix the problem that screen rotation may cause the information of the changed subtasks to be lost when editing items
6. Fix the problem that the number of gold coins does not actually take effect when creating new or editing products
7. The display conditions of the annual completion times on the amendment details page
8. Optimize the storage of pictures in the app, and should not be scanned by the system photo album
9. Optimize the description of the feeling switch
10. Fix some crashes

**1.85.3 (2021/11/18)**

1. Optimize the time calculation method of the timing, will make up for the CPU sleep time
2. Fix the problem that editing the icon while copying the product will cause the original product icon to be lost
3. Other minor bug fixes (such as team tag)

**1.85.2 (2021/11/07)**

1. Fix the problem that records and rewards cannot be generated during settlement after the timing is suspended
2. Fix that using the "move to" operation under the smart list will cause the list to display inaccurately
3. Fix the problem that the current value display of "Current number of gold coins" does not match the actual calculation (the current value display does not include ATM deposits)
4. Fix the problem that the record and reward will be repeated after the Pomodoro work is over, and then the skip button is clicked twice in a row

**1.85.1 (2021/11/02)**

0. Fix loading problem of feelings list

**1.85.0 2021/10/20)**
*Feature*

1. Pomodoro supports positive timing mode
2. Paste multiple lines of text to quickly create subtasks
3. Commodity support copy operation
4. Swipe to switch the direction of the list of items, support reverse (settings-items)
5. Support clearing the Pomodoro to get the record
6. The Pomodoro adds a forced horizontal and vertical screen switch button
7. Achievement unlocking conditions have been increased:
   ● The number of products obtained by synthesis
   ● Cumulative acquisition quantity of goods
   ● The current quantity of the product
   ● Life level
   ● (Repetitive) the focus time of the task
8. The skill icon also supports multiple cropping settings
9. Static shortcut:
   ● New task
   ● Enter the Pomodoro page
10. Sound effect customization increased:
    ● Obtain achievement rewards (including system achievements and custom achievements)
    ● Unpacking
    ● Synthesis (including simple synthesis and synthesis)
    ● Notification sound effect
11. Gold coin icon customization
12. Product use effect supports setting multiple experience value change effects
13. Changes to the experience pie chart adaptation skills
14. The history page supports status filtering
15. Team tag function

*Improve*

1. When the subtask gold coin reward is 0, the gold coin reward will not be displayed in the details
2. Create a new achievement list page and add a guide to "Create Achievement"
3. Optimize the icon display of widgets
4. Complete subtasks to add sound effects (details, new pages)
5. After entering content on the new or editing (items, products, achievements, synthesis) page, click the return button, and a confirmation box to discard changes should pop up
6. Sort optimization of product creation (in the case of custom sorting, newly added products should be the top priority)
7. When editing items/products, the input method should not pop up automatically
8. New item page should support horizontal screen and no data loss
9. Member theme color adaptation for desktop widgets
10. Optimize the product selection box, change the display and then load the data asynchronously
11. The warehouse label also adds "composite" and "ATM" entrances
12. Put the [Set as complete] and [Undo] operations in the history change status back to the first level menu
13. Add the Pomodoro quick entry for details of the event
14. Optimization of the sorting of the "All" list of the store (addition of the option of grouping by list, only stores)
15. After selecting the days of the week to repeat, the deadline time should be calculated again. (Prevent the user from choosing a work day to repeat, and the deadline still stays on Saturday and Sunday.)
16. When returning to the "Delegation" page, if the "+" button is not displayed, the display will be triggered.

*Fixes*

1. Fixed the problem that the progress on the list was not refreshed in time when the achievement page was configured to the bottom navigation bar
2. The state switching problem of historical items is fixed
3. Negative countdown overdue display repair
4. The achievement of gold coins should be included in the deposit in the ATM
5. Fixed the problem that when the Pomodoro is paused, reentering the Pomodoro twice will cause the time to be cleared
6. Fix the purchase restriction may become invalid under certain circumstances
7. Fix the problem that countdown records will repeat in rare cases
8. Fix the problem that clicking different task cards in quick succession may cause the task content of one of the cards to be blank after returning to the page
9. Logic adjustment of automatic calculation of gold coins and experience points
10. Fixed some crashes

**1.84.4 (2021/10/09)**

1. Fix the problem that the built-in icon may not be displayed

2. Update Q group

**1.84.3 (2021/10)**

1. Update overseas text

**1.84.2 (2021/09/26)**

1. Fix the deadlock problem that may be caused by synthesis

2. Fix the problem of abnormal usage effects displayed in the product details that are not available

3. Optimize the visual effect of rounded corners of widgets

**1.84.1 (2021/09/20)**

1. Fix the problem that the target repeat count cannot be cleared during editing

**1.84.0 (2021/09/19)**

***Features***

1. Skill system (attribute customization)

   All the original mechanisms are adapted to the attribute customization system, such as achievement attributes reaching unlock conditions, product experience rewards, etc.

2. Customize the edible effect of the Pomodoro, allowing you to change the experience value and attribute types

3. The store icon supports changing the cropping style (store settings)

4. The product details will now display a list of usage effects

5. Add member theme color #6bab8b

6. Support deleting reminder calendar account

***Improvements***

1. The Pomodoro page supports horizontal display

2. Added the description of "Loanable Amount" in the product settings

3. Add a reminder of the file size of the cloud synchronization

4. Upgrade Facebook and Dropbox related dependencies

5. Part of the page UI display and text optimization

6. Optimize the interaction of new subtasks

***Fixes***

1. Fix the problem that the default icon version of the attribute is inconsistent

2. Fix the problem that quick click to open the box may cause repeated unboxing or crash

3. Fix the problem that calendar events that have been reminded will not be removed synchronously when deleting items

4. Fix the abnormal status after setting the item from "Completed" to "Overdue" on the history page. The historical data should be automatically repaired when upgrading to the new version

5. Fix the problem that the currently selected list is incorrectly marked in the list selection dialog when creating a new product; and the display of the "all" list is removed

6. Fix the problem of editing other content + target repetition times, the editing will fail again

7. Create a new achievement page, fix the problem that the attribute selection cannot be edited and left blank

8. Other minor bug fixes and optimizations

**1.83.16 (2021/08/20)**

1. Fix the crash and ineffectiveness of avatar modification in offline mode
2. Optimize the interaction of product unpacking effect selection
3. Fix the focus problem of some long text input boxes
4. Fix the issue that the reminder deadline and time are displayed incorrectly in some cases
5. Fix the problem that the related configuration changes of the concise mode will not take effect immediately

**1.83.15**

1. Support marking penalties tasks in app widgets
2. Fix the abnormal behavior of "folding non-seven days' matter"
3. The upper limit of the number of impression pictures has been increased to 9 pictures
4. The login page will show the last login method
5. When the penalty is cancelled (marked as completed), no additional reward will be given
6. The smart list now supports displaying completed items
7. Fix the abnormal situation of automatically backing up to the download folder in some cases
8. Fix some UI display problems

**1.83.14**

1. Fix the issue that Pomodoro may not record the time length when executing "skip"
2. Fix the problem that penalty items will be executed overdue and penalty logic
3. Fix issues related to editing penalties
4. Fix issues related to selecting pictures in landscape mode
5. Fix the occasional restore failure when restoring a backup from a custom path

**1.83.8-1.83.13**
Features

1. Support independent setting of card background
2. The delete record function now supports deleting thoughts, warehouses, and timing records
3. System achievements can choose whether to get experience points or gold coin rewards
4. Event search function
5. Support local automatic backup to "download" folder (Android 10 and above)

Improvements

1. Improve the default notification reminder calling method, which can theoretically enhance the notification success rate above Android6
2. Increase the notification priority of the Pomodoro timer to [High], improve the survival probability of the background timer and the notification display
3. On the page, add QQ group and official website links, optimize the UI, QQ supports one-click group addition
4. Improve the trigger timing of achievement notifications, which should be reminded immediately after triggering on the homepage
5. Add a check box of "Apply to current list only" in the "Filter" option of the item list, and separate the default and all list options
6. Add animation effects when compositing
7. Feedback Increase the feedback channel of the Rabbit Xiaochao community, which is convenient for uploading pictures and tracking issues
8. Increase the relative value display in the counting item input box
9. Optimize the unselected Tab display effect
10. Remove the random prompt when clicking on the avatar, and click to enter the personal homepage instead
11. When the gold coin reward is not set, it will be displayed as "not set" instead of "0"
12. When the probability of unboxing setting is lower than 0.01%, it will no longer display "0.00%" but change to "<0.01%"
13. Feel that the switch is no longer memorized, and it is turned off by default
14. Optimize the application process for calendar and camera permissions
15. Optimize the click effect and display effect of some pages
16. Optimize the calendar reminder method, try to solve the problem that some devices may delete the calendar account

Fixes

1. Fix the crash problem of continuous filtering on the impression page
2. Try to fix the rare crash of the dialog box that is set out of the box
3. Fix the problem that when the input box is long, clicking on the text will automatically jump to the bottom
4. Fix the issue that random gold coin rewards cannot be set when creating a team
5. The domestic distribution version completely removes Firebase related dependencies
6. Fix the occasional exception when refreshing the achievement list page
7. Fix an occasional abnormal crash when selecting the built-in icon
8. Fix the problem that the subtasks are still visible when returning to the details page after deleting all subtasks
9. Fix the problem that the name of the synthetic default list cannot be edited
10. Fix the problem that the filter box will be displayed on the profile page
11. Fix the problem that the team item cannot be inherited after setting the product reward

**1.83.7 (2021/06/24)**

1. The list is sorted by gold coin added
2. Add language selection to the guide page
3. Optimize the loading speed of achievement page
4. Change QQ group to join information with one click
5. Fixed the problem that continuous clicking during unpacking may trigger inventory changes multiple times
6. Fixed the incorrect display of single overdue items in the daily items list

**1.83.6 (2021/06/22)**

Features

1. (Members) Support independent setting of card background
2. The delete record function now supports deleting thoughts, warehouses, and timing records
3. System achievements can choose whether to get experience points or gold coin rewards
4. Event search function
5. Support local automatic backup to "download" folder (Android 10 and above)

Optimization

1. Improve the default notification reminder calling method, which can theoretically enhance the notification success rate above Android6
2. Increase the notification priority of the Pomodoro timer to [High], improve the survival probability of the background timer and the notification display
3. On the page, add QQ group and official website links, optimize the UI, QQ supports one-click group addition
4. Improve the trigger timing of achievement notifications, which should be reminded immediately after triggering on the homepage
5. Add a check box of "Apply to current list only" in the "Filter" option of the item list, and separate the default and all list options
6. Add animation effects when compositing
7. Feedback Increase the feedback channel of the Rabbit Xiaochao community, which is convenient for uploading pictures and tracking issues
8. Increase the relative value display in the counting item input box
9. Optimize the unselected Tab display effect
10. Remove the random prompt when clicking on the avatar, and click to enter the personal homepage instead
11. When the gold coin reward is not set, it will be displayed as "not set" instead of "0"
12. When the probability of unboxing setting is lower than 0.01%, it will no longer display "0.00%" but change to "<0.01%"

**1.83.0-alpha04 (2021/05/23)**

1. Support the free configuration, sorting and disabling of the bottom module
   Modules need to be adapted gradually in the future, and currently only support some functional modules (such as Pomodoro, historical unadapted)
2. The second pause mode is added to the countdown effect of the product, which will stay in the notification bar and can be resumed at any time
    And add the "experimental" logo
3. When choosing to skip the Pomodoro, add a reminder that you cannot get a Pomodoro
4. Add a hint to expand and collapse the sample task
5. Fix the crash that may be caused by the layout at the top of the list on some pages
6. Optimize the network error prompt when the network is disconnected
7. Optimized the gold coin reward reminder when completing the sub-tasks, changed to non-obstructive Toast reminder

**1.83.0-alpha03 (2021/05)**

1. Fix the problem that the empty layout display of the composite page may exceed the screen
2. Fix the problem that the "Charm" attribute name of the newly created page is displayed incorrectly
3. Fix some issues with gold coin settings
4. Optimize the animation effect of the achievement page to adapt to the scene at the bottom navigation bar
    (Adapted but the interface is not ready yet, please wait for subsequent updates)
5. Upgrade the target SDK version to Android11
6. Fix the empty layout display problem of the "Moment" page
7. Fix the problem of abnormal interest calculation

**1.83.0-alpha02 (2021/05/16)**

1. Fix the problem that synthetic recipes can be created in the "All" list
2. After entering the synthesis system interface, no matter which list you are in, the actual display content is the "All" list.
3. Simple repair of the calculation method of ATM interest

**1.83.0-alpha01 (2021/05/16)**

1. A complete synthesis system, supporting any N-to-N synthesis implementation
   - Checklist
   - New/Edit
   - Synthesis dialog
   - Night mode and multi-language support
   - "Entrance" is at the top of the store page
2. Refactoring the internal code of the new item page
    For the scalability of the application, we have almost completely sorted out the code of the newly created items, and may also redesign the UI in the future.
    Subsequent alpha updates will also add "target repeat date", "relative reminder time", "penalty type items (to be determined)" and other functions.
    If you encounter a problem, you can switch to the old version of the page at any time.

3. Add ATM entrance at the top of the store
4. The item attachment supports up to 9 pictures, and the storage path has been adjusted
5. Team TAG function
    The implementation is built-in, but the specific TAG content has not been configured yet, so it will not be displayed for the time being

**1.82.16 (2021/05)**

1. Fix the problem that the example items cannot execute the overdue logic correctly (only valid for new users)
2. Fix the problem that the number of completions of infinite items in certain scenarios will be missing 1 time

**1.82.15 (2021/05)**

1. Fix the background sound effect playback problem

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Fix the problem that unlimited items may cause the list to load slowly and the cancellation count is inaccurate
2. Fix the problem that the completion of the task in the desktop widget may be played multiple times to complete the sound effect
3. Fix the problem that the total count of the top items in the smart list is not accurate
4. Support delete all local data and delete account functions
5. Fix the problem that the editing of subtasks of team items cannot be inherited

**1.82.12 (2021/05)**

1. Fix the counting problem of undo complete infinite items
2. Fix the issue that the frozen items will still be reminded
3. Some optimizations have been made to the list switching, which may increase the switching speed of old devices and add loading animations
4. Fix the problem that the custom rest end sound effect does not take effect, and supports setting the end sound effect of commodity timing
5. Fix the problem that Pomodoro cannot count the concentration time when using the "skip" operation
6. Fix the problem that the pause button of the product countdown does not take effect

**1.82.11 (2021/05)**

1. Fix the counting problem of undo complete infinite items
2. Fix the issue that the frozen items will still be reminded
3. Some optimizations have been made to the list switching, which may increase the switching speed of old devices and add loading animations
4. Fix the problem that the custom rest end sound effect does not take effect, and supports setting the end sound effect of commodity timing
5. Support Russian language

**1.82.10 (2021/05)**

1. Fix the problem that Pomodoro cannot count the concentration time when using the "skip" operation
2. Fix the problem that the pause button of the product countdown does not take effect
3. Capture a crash caused by failure to create a calendar reminder

**1.82.9 (2021/05)**

1. Fix the problem that the time limit of the copied item may be emptied, and it may cause a crash when repeated
2. Optimize the refresh speed after completing unlimited items
2. Fix the problem of calculating reminder time for team tasks
3. Fix the problem that the completion of sliding may cause the animation to not end correctly and remain blank
4. Team tasks should support sliding abandonment
5. The product introduction in the purchase window supports sliding browsing

**1.82.8 (2021/04/28)**

**features**

1. Added the current complete streak display
2. The shop item countdown effect is optimized, and two operations of ending and pausing are added; it is calculated in absolute time when it is abnormally terminated
3. Support for setting the vibration mode and bell switch of the Pomodoro separately
4. Partially supports preview of future deadlines of ongoing events in the calendar
5. Support restarting single and unlimited events
6. Modify the data display on the "Me" page, and change "Overdue" and "Give Up" to "Achievement (Unlocked)" and "Feelings"; now the statistics page displays the number of "Overdue" and "Abandoned"
7. Support to directly apply to create widgets from the "desktop widgets" setting page (only in Android 8 or higher)

**improvements**

1. Support for viewing large images of shop items
2. Optimize the power consumption problem that may be caused by step counting
3. Fix some display problems when the font is too large
4. Optimize the cancellation of unlimited items
5. Optimize the display of Pomodoro notifications and add a progress bar display
6. After the event is completed, remove the notification reminder that is currently being displayed
7. Optimize the income and expenditure statistics of gold coins
8. Add some user guidelines and tips
9. When editing items, support clearing the product reward selection
10. When dealing with continuous crashes, add "Known Issues" notice
11. Optimize the display effect when the attribute is not selected

【repair】

1. After the homepage sorts the list, the status should be refreshed immediately
2. Fix the issue that the details page will not refresh the subtask list immediately
3. Forcibly fix the crash problem of Weibo authorized login
4. Fix the problem that the name of the item that may be displayed in the Pomodoro notification is incorrect
5. Fixed an issue where the Pomodoro’s notification countdown display was inaccurate
6. Fix the issue that the reward box will not pop up when the item and achievement only have merchandise rewards
7. Fix the problem of not being able to purchase 0 gold coins under certain circumstances
8. Optimize the calculation method of repairing Ebbinghaus items
9. Optimize the calculation method of the number of completions today for unlimited events

**1.82.7 (2021/04/10)**

1. Fixed the UI display when empty data in the [Moments] screen
2. Font size will follow system settings again
3. Update English and Portuguese translation

**1.82.5 (2021/04/02)**

1. Fixed some issue about pomodoro record
2. Added some new guide

**1.82.4-alpha01/beta (2021/03/25)**

1. Fixed rewards of loot boxes
2. View feelings of selected tasks
3. Exp/random coin rewards for custom achievement
4. Tasks in the smart list now will be grouped by list
5. Yearly repeatation
6. More improvements and bug fixes

**1.82.1 (2021/03/12)**

1. Fixed some issues about smart lists
2. Fixed an issue where progress bar might not changed after completed a task
3. Fixed an issue with force complete an count task
4. Fixed an issue where displaying "NULL" in the overdue bottom dialog

**1.82.0 (2021/03/11)**

1. Smart lists
2. Redesigned attributes icons
3. New item effect "Countdown"
4. Pomodoro timer will continue to record extra time after completed timer, and you can choose to update the focus time and get extra reward.
5. Count tasks now can be force completed when not reached target times.
6. Now you can choose to complete an unstarted tasks, and decide whether to postpone the time
7. More issuses fixed and improvements

**1.81.6**

1. Fixed isuues about pomodoro reminder hint

**1.81.5 (2021/03/02)**

1. Italian translation(partial)
2. Fixed notification icon
3. Fixed the reminder not working well with weekday repeat
4. Fixed "take photo" selection not working
5. More minor fixes

**1.81.0~1.81.4**

1. Redesign some UI and animations
2. Task will be auto completed when all sub-tasks of it is completed
3. Fixed bug about multi exps changed
4. Fixed bug about dropbox restore
5. Now you can return item without getting coins
6. 12-hour clock display setting
7. Freeze/Unfreeze multible tasks

**1.80.7（2021/01/26)**

1. Add shop item statistic
2. Redesign attributes description dialog
3. Custom attributes description
4. Add a config settings for compact mode: hide all extra info
5. Fixed a restore from backup file bug
6. More fixes and improvements...

**1.80.6（2021/01/22)**

1. Now the item with loot boxes effect can be shared to market
2. New search page: now you can searching user by nickname
3. Filter team/makret items with time range
4. Quick add tasks notification
5. Media files can be ignored when performing backup.
6. More fixes and improvements...

**1.80.5（2021/01/14)**

1. Open 10/50 loot boxes by one click
2. Add unlock condition [Get selected item for specify times from Loot Boxes]
3. ATM interest rate settings
4. Input number for selling/eating tomatoes
5. Custom rest timer end sound effect
6. Add some user guide
7. Fixed some problems and make some improvements

**1.80.4（2021/01/04)**

1. Fix a crash on Android 6

**1.80.3（2021/01/04)**

1. Free style crop picture
2. View/Add the icon of the items in the market
3. When selecting task/item, now you can create a new one directly
4. Support COPY action for user achievements
5. A lot of fixes and improvements

**1.80.0（2020/12/24)**

1. Loot boxes shop item effect!
2. Integrated with Dropbox backup
3. Configurations for compact mode
4. Add photo select history bar
5. A lot of fixes and improvements

**1.79.x（2020/12)**

1. 3 more unlock condition settings
2. Custom sound effects settings
3. Set item reward for achievements
4. Pomodoro timer record page
5. Create task from the Calendar page
6. 5 new theme color.
7. Lots of improvements and fixes

**1.78.x（2020/11)**

1. Custom achievements unlock condition
2. Custom task experience points
3. Lots of improvements and fixes

**1.77.1（2020/11/05)**

1. List switch toolbar
2. Show completed task switch
3. List can be archived now
4. Add coin status card
5. Now you can create feelings for a user achivements
6. Add a setting to follow system's night mode

**1.77.0（2020/10/28)**

1. Add Market module for community, in where you can share the shop item design or import the item
2. Fix the logic of the month repeat
3. Fix webdav auto backup not working when haven't backup at least once

**1.76.0（2020/10/13)**

1. Default coin of subtask
2. Add in-app icons for creating shop item and achievements
3. Custom tomato price
4. Global sound effect enable settings
5. Now feelings can be search by task content

**1.75.2（Released at 2020/10/05）**

1. Default coin number setting of subtask
2. Add over 100+ icons that can be selected as shop item/achievements icons
3. add "Enable sound effect" settings
4. Filter feelings by task content and better ui of filters
5. Create pomodoro shortcuts
6. Custom tomatoes selling prices
7. Pomodoro page will keep screen on when counting down now
8. Fixed some problems

**1.75.1（Released at 2020/09/20）**

1. Fix lots bugs of 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Gamify pomodoro timer
2. Custom task/list tag color
3. WebDAV auto backup
4. Hide modules settings
5. Lots of improvements and fixes

**1.74.2（Released at 2020/08/23）**

1. Portuguese Language

**1.74.0（Released at 2020/08/13）**

1. ATM: Deposit & Withdrawal coins
2. Now support that selecting shop items as task reward
3. Shop item stock quantity setting
4. Improve animation and fixed some bugs
5. Add hint for Repeat Frequency setting
6. More.. (update description later)

**1.73.0（Released at 2020/07/26）**

**Features:**

- User achievements
- Exp decrease animation
- Edit the completed time of history record
- Team subtask coin setting

**Improvement:**

- Add coin sound effect

**Fix:**

- The problem of losing subtask coin setting after repeating a task

**1.72.1（Released at 2020/06/14）**

**Features:**

- Clear achievements data

**Improvement:**

- Better display of shop item description

**Fix:**

- The problem of editing pictures of shop items
- The problem of editing the text of feelings

**1.72.0（Released at 2020/06/11）**

**Features:**

- Subtask Remind
- Subtask Coin
- App Widget
  1. Opacity Setting
  2. Display Coin Number
  3. Display Count Task Input Dialog
- Statistics Page Time Select
- Inventory: Return Item
- Add subtask support for team

**Improvement:**

- Swipe a count task now will add 1 completed time instead of marking it as completed
- Add Help Translate Button
- Add Enabled Multi Exp Reward Setting for count task

**Fix:**

- Fixed that transparent part of png picture showing black after cropping.
- Fixed that App Widget not working well on some devices.
- Fixed that Coin Number showing in the Detail Page when it's set to 0.
- Fixed that Swipe to Finish (no dialog mode) will make the page displayed incorrectly
- Fixed that subtask cannot be created when click the ENTER button on some devices

**1.71.3/1.71.4（Released at 2020/04/16）**

**Minor Fixes about icon and crash report**

**1.71.2（Released at 2020/04/14）**

**Features:**

- Turkish Language (thanks **İbrahim DOĞAN** for helping translation)

- Customize task card background and opacity
- Customize the action button text of inventory item
- Feelings Favorites
- Feelings Search

**Improvement:**

- New Icon

- Report type support multiple languages
- Improve UI of the Settings Page
- Improve the method of switching theme color and language. No need to restart the app to make it work.
- Improve the crop picture page
- Improve UI of the select list
- Add shop item description showing on the shop item list page

**Fixed:**

- Fixed bug that achievement unlock date incorrectly showing
- Fixed bug that shop item picture showing empty when the file deleted.
- Not clear the status of sub-tasks after single task become overdue.
- Fixed bug that not enough space for Difficulty Degree to show in the Task Detail Page.
- Fixed bug that after setting overdue task to finished, completed times of the next task not plus one.
- Fixed bug that the max coin number not showing correctly in the task default settings.
- Make the data backup/restore page scrollable.
- Fixed that swipe to complete task not working well when fast swiping multiple tasks.
- Now app widgets will show the Frozen status
- Fixed bug that the progress bar on task page showing incorrect progress sometimes

**Server Fixed（2020/4/13）**

- Fixed that report function not working

**v1.71.1 (Released at 2020/03/17)**

**Improvement:**

- Better progress bar animation in task page

**Fixed:**

- Fixed a bug that may cause crash when launching application on some devices
- Fixed a bug about selecting photos

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Features:**

- Feelings Feature

- Add Swipe Action: Finish Task (No Dialog)

**Fixed:**

- Fixed bug that task card state showing incorrectly

- Fixed bug that task which was undo may be disappeared when overdue

- Fixed that the selected sort not showing correctly

**v1.70.6 (Released at 2020/03/09)**

**Improvement:**

- Make the Achievement unlocked Hint colors same as the theme color

**Fixed：**

- Fixed overdue dialog status not showing correctly after clicking the button

- Fixed a bug that COPY cannot copy sub-tasks
- Fixed a crash occurred when using "Move To..."
- Fixed the Selecting Card not correctly showing on some devices

**v1.70.5 (Released at 2020/03/06)**

**Fixed：**

- To-Do Card keep loading when change theme color or enable/disable night mode

**v1.70.4 (Released at 2020/03/05)**

**Improvements：**

- Shop Page will show coin number when there is no items
- Can access the Coin Detail Page by clicking the coin number in the Shop Page
- Improve text format of the app widget in English
- Can access the Task Detail Page by clicking the task on the App Widget

**Fixed：**

- Team activity incorrect showing style

**v1.70.3 (Released at 2020/03/05)**

**Improvements:**

- Shop Page will now show coin number when there is no items
- Click the coin number in the Shop Page to enter Coin Detail Page now
- Improve the English text format on the App Widget
- Click the App Widget item to enter Task Detail Page

**Fixed：**

- Fixed when Filter Today, the footer hint "xx task(s) is not yet started" not showing after completing task

**v1.70.3 (Released at 2020/03/05)**

**Important Fixes:**

- Fixes bugs about input coin number
- Fixes bugs that sub-tasks not refreshing correctly
- Fixes bugs that cannot like others' activity
- Fixes bugs that App Widget cannot finishing tasks

**v1.70.2 (Released at 2020/03/04)**

**Features：**

- Community is now available for all time zone

- Copy Tasks
- Support edit new task default settings
- Shop List

- Improve App Widget actions
- Add menu for ended tasks for In Calendar Page

**Improvements**：

- Improve animations of task card

- Remove an unneeded permission
- Add complete sound
- Improve History Page UI style
- Add "Lost Calendar Write/Read Permission" Dialog when enabling System Calendar Reminder and not granted permissions

**Fixed：**

- Fixes bugs about Count Task in compact mode
- Fixes bugs about repeat tasks
- Fixes crash that may occurs when delete sub-tasks
- Fixes crash that occurs when input incorrect WebDAV URL
- Fixes incorrect theme color showing , which may occurs after restore a backup

### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**🚀Features**

1. Support Archive Management

- Backup to computer
- Restore from computer
- Support drag-and-drop

2. Support Creating New Thoughts

- Support image selection
- Support image sync to mobile

3. Support Task Details View
4. Purchase System Improvements

- Use new "Purchase Items" API
- Keep purchase limits consistent with app

5. Support Optional API Token Validation
6. Multi-platform Support

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Improved error handling and notifications

**v1.1.1 (2023/08/29)**

**🔧Optimization and bug fixes**

1. Fixed unexpected behavior when gold coins are input
2. Fixed the problem that checking for updates may cause the app to crash

**v1.1.0 (2023/06/25)**

**🚀Features**

1. Support automatic check of “LifeUp Cloud ” IP address and connection (requires LifeUp Cloud v1.3.0)
2. Support adding tasks, but the options currently supported are limited (Fixed [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Support exporting impressions as markdown format (Fixed [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Add Traditional Chinese language text
5. Add MacOS release version
6. Support for checking updates

**🔧Optimization and bug fixes**

1. Fix the problem that the achievement subcategories cannot be displayed correctly
2. Fix the problem that some icons cannot be displayed correctly (requires LifeUp v1.91.3 version)
3. Fix the title mismatch problem (Fixed [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Add shortcuts option for Windows installer (Fixed [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Improve the way of getting window size, adapt to resolutions lower than 1080p

**v1.0.2 (2023/02/20)**

1. Add more detailed error report pop-up [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Improve packaging configuration

**v1.0.1 (2023/02/12)**

1. First release

### **LifeUp Cloud**

**v2.0.0 (2025/01/01)**

**🚀Features**

1. Service Optimization

- Enhanced service discovery logic and compatibility
- More devices support automatic IP detection
- Optimized service start/pause state transitions
- Improved error handling and notifications

2. Security & Performance

- Added optional API Token validation
- Added CORS configuration options
- Support custom port settings
- Support custom wake lock duration

3. UI Enhancement

- Brand new interface design
- Improved overall visual experience

**v1.3.0 (2023/06/25)**

**🚀Features**

1. Support registering mDNS service to enable desktop to automatically discover its IP (requires desktop v1.1.0)
2. Added result values for APIs invoked via ContentProvider.

**🔧Improvements**

1. Increased the click range of the scan QR code button
2. Fixed ActivityNotFound crash

**v1.2.0 (2023/03/10)**

1. Support scanning QR code to invoke API
2. Improve the display of IP list

**v1.1.2 (2023/02/12)**

1. Support querying complete data through Content Provider, which is used to support desktop functions
2. Standardize HTTP response content

**v1.0.3-preview (2022/11/22)**

1. First release (plus some first release bug fixes)

<!-- tabs:end -->

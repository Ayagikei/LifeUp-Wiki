# Development Roadmap

Because *LifeUp* is currently maintained in spare time and has limited ability resources, we do not guarantee that the development plan can be executed accurately, and we will not promise a specific launch time.

<br/>

## Update strategy

The update cycle of local features will remain within 14-21 days.

And after each feature update, we may release several fixes.

Because the function of the "World" module involves multiple factors such as double-end joint development, requirement synchronization, server deployment, server performance limitations, and compatibility.

The development cycle will be longer than the local function and mainly be maintenance instead of introducing new features.



**Update priority (approximately):**

Crash bug fixes >> Experience bug fixes affecting new users >> Feature updates > UI and detail bug fixes.

<br/>

## Version number strategy

Use a three-digit version number, such as `1.80.3`.

**The first** (such as **1**.80.3) is the version number used for the major revision of the application, and 1 is the initial official version. There will be a lot of code refactoring/UI redesign changes if it improves.



**The middle bit** (such as 1.**80**.3) is the feature version number (feature). The version number will increase when a medium-level feature function is released or when a relatively large number of minor feature functions are accumulated.

Like:

> Version 64 launched the Shop&Store&Warehouse system.
>
> Version 70 launched Simple Mode.
>
> Version 80 launched the unboxing system.



**The third digit** (e.g., 1.80.**3**) is the revision number to fix some issues/crashes with each feature release. At the same time, it may also bring some minor  features.



> The old version also used the three-digit version number represented by English letters, such as 1.58c.
>
> The basic strategy is the same as above, except that the third section becomes an English letter and starts from `a`.
>
> However, because some application markets do not support this version number strategy, it is now abandoned.

<br/>

# October 2022 (written) roadmap

The development of `LifeUp` in the past few years has always focused on developing new functional modules or adding new features to existing modules.
Today, we believe that the functional modules of `LifeUp` are more than self-consistent in width but insufficient in depth.
Therefore, the following development goals aim at functional depth, continuously improve existing available modules, and increase practicality (calendar integration, widgets, statistics);

We will also continuously improve API functionality, allowing it to meet expansion needs. For example, support the community to develop its own task list and shop items list UI.

In addition, we will try to improve our data system and explore using Flutter to develop cross-platform versions.

| Module | Subfunction | Estimated Version | Requirement Reason | Priority | Result |
| -------- | ---------------------------------------- -------------------- | ---------- | ------------------ -------------------------------------------- | ------ | ---- |
| Calendar Integration | - Google Calendar Two-Way Synchronization<br/>- System Calendar Two-Way Synchronization | v1.91 | - Lots of feedback. <br/>- `LifeUp` is a to-do tool. Its functions overlap but are inconsistent with the schedule (calendar) application. The development work will be enormous if we develop all the calendar features in `LifeUp`. External integration may be a better solution to reduce the need for cross-platform synchronization to a certain extent. | P0 | ~ |
| Widgets | - Attributes Widget<br/>- Items Widget<br/>- etc... | v1.92~1.95 | - Usability. <br/>- Beautiful widgets also provide a level of gamification and motivation. | P1 | ~ |
| Statistics | - Statistics of various indicators<br/>- Detailed statistics of Pomodoro<br/>- Generate sharing cards | v1.92~1.95 | - The statistics of Pomodoro are lacking. <br/>- The statistics module has not been improved for a long time, and the design and data are outdated. <br/>- The sharing card is suitable for external sharing by users, which can bring incentives and attract more users to a certain extent (requires exquisite UI design). | P1 | ~ |
| APIs | - Develop an SDK<br/>- Support query list<br/>- More common APIs | v1.91~1.95 | - Lack of list data interface. After supporting the list query, third parties can develop customized UI (such as a task list), and we can significantly enhance the extensibility.  <br/>- `LifeUp` can't be an all-in-one application, but providing an APIs function allows everyone to customize and expand their world. And this can also realize the open source community. | P1 | ~ |
| Data System| - Separate backup of data and pictures<br/>- Support partial data export and import<br/>- Support built-in multi-file switching| ~ | - WebDAV uploading large files is easy to fail. <br/>- Partial data export and import, which users can use for sharing their reward system. It can also lay the groundwork for incremental synchronization.   <br/>- Built-in multiple files, users can directly switch various systems to use and debug applications at will. As a result, there is no need to clear data repeatedly. | P1 | ~ |
| Multiplatform | - Continue to learn and use Flutter to develop cross-platform version | ~<br/>2.0 | - iOS version prototype development. <br/>- It is more inclined to explore new implementations rather than to fork the Android version. <br/>- Maybe for Windows/Mac OS, etc., need to investigate. | P1 | ~ |
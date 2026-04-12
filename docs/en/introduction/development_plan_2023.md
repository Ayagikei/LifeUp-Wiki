# 2022/10 - 2023/12 Development Plan

!> This is an expired development plan, kept only for archive and reference purposes. The environment continues to change, and our plans will adjust accordingly. This plan broadly indicates our development direction, but we do not promise to execute it completely, and we may also develop beyond the plan.

<br/>

LifeUp's development in previous years has always focused on developing new functional modules or adding new features to existing modules.

Today, we believe LifeUp's functional modules have enough self-consistent width but are insufficient in depth.

Therefore, the following development goals aim at functional depth, continuously improving existing available modules, increasing practicality (calendar integration, widgets, statistics);

And continuously expanding APIs functionality so that APIs can be fully extended for various external functions.
In addition, try to improve our data system and explore using Flutter to develop cross-platform versions.

<br/>

- **2023/01/26**
  - Added "LAN PC side" item to "Multi-platform", also added corresponding explanation to "APIs".
  - Adjusted "Calendar Integration" estimated version, progress may be delayed.
  - Adjusted "Custom Required Experience" estimated version, progress may be advanced.
- **2022/10/16**
  - **Added roadmap for Attributes, Achievements, and Basic Capabilities**

| Module | Subfunction | Estimated Version | Requirement Reason | Priority | Result |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Calendar Integration | - Google Calendar Two-Way Sync<br/>- System Calendar Two-Way Sync | v1.91~1.93 | - Lots of overseas feedback.<br/>- LifeUp is a to-do tool with overlapping but inconsistent functions with schedule (calendar) apps. Developing all calendar features in LifeUp would be enormous. External integration may be a better solution. | P0 | ~ |
| Widgets | - Attributes Widget<br/>- Items Widget<br/>- etc... | v1.92~1.95 | - Usability.<br/>- Beautiful widgets also provide a level of gamification and motivation. | P1 | ~ |
| Statistics | - Various indicator statistics<br/>- Detailed Pomodoro statistics<br/>- Generate sharing cards | v1.92~1.95 | - Pomodoro statistics lacking.<br/>- Statistics module hasn't been improved for a long time, design and data are outdated.<br/>- Sharing cards suitable for user external sharing, can bring incentives and attract more users to some extent (requires exquisite UI design). | P1 | - Expected to develop some statistics cards in v1.91 |
| APIs | - Develop SDK<br/>- Support list queries<br/>- More common APIs | v1.91~1.95 | - Lacking list data interface. After supporting list query, third parties can develop custom UI (like task list), extensibility can be greatly enhanced.<br/>- Based on above interfaces, develop corresponding SDKs and LAN PC side.<br/>- LifeUp can't be all-in-one, but API enables everyone to customize and expand their LifeUp, and realize open source community. | P1 | - Expected to provide first version query API in v1.91 |
| Attributes | - Custom required experience | v1.91~1.92 | ~ | P2 | - Expected to complete development in v1.91 |
| Achievements | - Repeat-type achievements | v1.94~1.97 | ~ | P2 | ~ |
| Basic Capabilities | - Batch editing (tasks, achievements, etc.)<br/>- Multi-select items, auto-pack into boxes, etc. | v1.94~1.97 | ~ | P1 | ~ |
| Data System | - Separate backup of data and images<br/>- Support partial data export/import<br/>- Support built-in multi-file switching | ~ | - WebDAV uploading large files fails easily, free cloud services have traffic limits, full backup with images is too large.<br/>- Partial export/import can be used for users to share reward systems.<br/>- Built-in multi-files allow users to directly switch between systems for debugging without clearing data repeatedly. | P1 | ~ |
| Multi-platform | - Continue learning and using Flutter to develop cross-platform version | LAN PC side: v1.91-1.92<br/>Flutter: v2.0 | - iOS version prototype development.<br/>- More inclined to explore new implementations rather than one-to-one replicating Android version.<br/>- Maybe suitable for Windows/Mac OS and other platforms, need to investigate.<br/>- Develop LAN PC side based on APIs (version reading phone data). | P1 | - Expected to provide first version PC side in v1.91 |
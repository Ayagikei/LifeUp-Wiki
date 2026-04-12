# 2024-2025 Development Plan

!> This is our current development plan. We will do our best to guide product improvements and upgrades according to this plan. However, due to the ever-changing environment, the content in the development plan may be modified or added/subtracted. Specific product release shall prevail.

### I. Development Plan

> Updated: 2025/09/14

| Module | Subfunction | Requirement Reason | Priority | Result |
| ---- | ------ | -------- | ------ | ---- |
| Basic Capabilities (1) | Multi-select items & auto-use items when acquired | ~ | P0 | ✅ Multi-select released in v1.94<br/>✅ Auto-use items released in v1.96 |
| Basic Capabilities (2) | Generalized reward popup (support any number of attributes and items) | ~ | P0 | ✅ Released in v1.96; settings to be relaxed in future versions |
| Basic Capabilities (3) | Sound resource management & item sound effects | ~ | P0 | ✅ Released |
| Basic Capabilities (4) | Notification optimization | ~ | P0 | ✅ Released |
| Large Screen Adaptation (tablet/foldable) | Adapt for tablets and foldables based on Activity embedding | ~ | P1 | ✅ Expected in v1.95 |
| Widgets | Widget expansion (inventory widget) | ~ | | ✅ Released in v1.94 |
| Calendar Integration | - Google Calendar Two-Way Sync<br/>- System Calendar Two-Way Sync | - Lots of overseas feedback.<br/>- LifeUp is a to-do tool with overlapping but inconsistent functions with schedule (calendar) apps. | P1 | 🚧 |
| API | - Expand API capabilities to cover all basic functions<br/>- Desktop client feature completion, support backup/restore, etc. | - Still missing many APIs like editing.<br/>- LifeUp can't be all-in-one, but API enables customization and expansion. | P1 | 🚧 Expected in v1.98.x |
| Achievements | - Repeat-type achievements | ~ | P2 | ✅ Released |
| Data System | - Separate backup of data and images<br/>- Support partial data export/import<br/>- Support built-in multi-file switching | - WebDAV uploading large files fails easily.<br/>- Partial export/import can be used for sharing reward systems.<br/>- Built-in multi-files for easy testing without clearing data. | P1 | 🚧 |
| Multi-platform (Flutter direction) | - Continue learning and using Flutter for cross-platform version | - iOS version prototype development | P2 | 🚧 Paused |
| Multi-platform (KMP direction) | - Explore more possibilities using KMP | - Explore and learn KMP technology for the future | P0 | ✅ Released ulives - iOS new app |

In summary:

1. We will implement the previously established direction: stability and optimizing existing features, not adding new functional modules arbitrarily.
2. We will use one or two major versions to solve some basic functional defects and pain points.
3. Then proceed with calendar integration and repeat-type achievements.
4. Continuously improve APIs and other aspects.

Multi-platform will be one of our key goals for 2024.

---

### II. 2023 Review

LifeUp's half-amateur-half-leisure development journey has passed its fifth anniversary, stepping into its sixth year. We've released hundreds of versions, with nearly 5000 code commits just on the Android repository.

<br/>

Although the development plan proposed in October 2022 focused on deepening LifeUp's functional system, due to environmental changes, we still encountered many obstacles and troubles along the way.

#### 1.1 Environment

Typical examples include:

- Being affected by "anti-fraud" false reports in some provinces with no appeal channel, taking several rounds to resolve some issues. But recently there were again false report issues in Shandong, and we haven't found an appeal or reproduction path yet.
- Chinese domestic Android app market review standards are increasing layer by layer, with inconsistent standards among markets and personnel, and reviewers being unprofessional.
  - Some app markets often reject reviews on unchanged parts.
  - One V app market almost rejected our LifeUp app using "privacy compliance" as a reason. The market required our app to apply for [read all file permissions] or [read all photo permissions] with corresponding explanations, so users could select images from the album. However, LifeUp uses a more privacy-protective approach, doesn't need such permissions, and doesn't directly read user files. Instead, our app jumps to the system's built-in album app and only receives the image selected by the user, ensuring maximum privacy protection.
    But reviewers weren't familiar with this best practice, and it took several working days of customer service communication to get approved.

<br/>

To reduce environmental impact on us:

We strengthened the in-app update mechanism and reduced the frequency of submitting for market review.

The domestic version now supports in-app updates and can switch between stable or beta channels.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

We also updated the official website (https://lifeupapp.fun/en/index.html) as an alternative download channel.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

To make it more convenient for everyone to download and install the app through the website, avoiding market review risks and delays.

In-app network requests also added backup channels to alleviate and prevent access issues caused by false reports in some provinces.

<br/>

As review standards become increasingly strict, and witnessing various obstacles encountered by other independent developers in the domestic Android market,

it can be said that for independent developers, the domestic Android platform is no longer the ideal first-choice launch target.

After all, domestic Android has the strictest qualification requirements and the most complex and **changeable** review standards.

> But ironically, at the same time, some low-quality copycat apps can easily get on shelves and mark "manual re-inspection passed".

This might be why many independent developer works seen on Xiaohongshu only have iOS versions.

Google Play and App Store remain the first choice.

?> Everyone can pay more attention to and support those independent developers and small teams still adhering to the domestic Android platform~

<br/>

So, in 2024:

- We'll move unfinished parts from the previous plan to this period, such as calendar integration, repeat-type achievements, basic capabilities, data system, etc.
- Multi-platform development will be an important goal for us, possibly including two directions:
  - Use Flutter to replicate LifeUp (due to limited manpower, this will be advanced by our backend colleague - Xiao Xiao)
  - Explore more possibilities using KMP (Kotlin Multiplatform)

#### 1.2 Domestic User Growth

In addition, LifeUp also had significant user growth in the Chinese app market in 2023. Thanks to everyone's support!

- To reduce the time spent manually issuing redemption codes and focus more on development: In 2023 we additionally connected automated payment methods (WeChat, Alipay) and supported WeChat login.
  - This freed up a lot of our time.

- In 2023, there was a user spread on Qzone that crashed our server for several days again.
- We also tried operating WeChat public account, Xiaohongshu, Bilibili, etc., to promote and introduce LifeUp updates and creative usage.

- Through discussions with other independent developers, we found most have experienced similar difficulties, ultimately choosing to close certain instant messaging and social media channels. We deeply relate.
  - In large companies, there are usually dedicated customer service teams or bots to handle numerous inquiries, effectively turning them into specific needs or problem feedback for developers.
  - **But independent developers generally have to bear customer service and operations work; dealing with unreasonable users consumes 100% of this independent developer's development time, ultimately affecting the developer, product, and core users of the product.**
  - Therefore, we increasingly tend to recommend users provide feedback via email, etc.

<br/>

So, in 2024:

- We'll continue reducing human investment in repetitive consultation work, and instead improve documentation and FAQs. Even if consultation exists, it will be handled uniformly through email, QQ channel, etc.
- Try a small amount of social media operation.

#### 1.3 Overseas User Growth

Early in 2022, we joined Google Play Pass and saw a wave of user growth.

But this growth didn't last long; by mid-2022, user growth gradually decreased significantly, with no sign of improvement.

Because LifeUp is a one-time purchase app, user growth is very important to us, and is the cornerstone for us to continue operating and have a chance to develop full-time in the future.

We tried many methods to improve growth:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Hired a professional designer to redesign store promotional images
- Improved app and promotional image multi-language support
- Improved app description
- Improved getting started documentation
- Increased update frequency
- ...

Although we implemented many methods and improved some indicators. We still couldn't return to a stable growth period.

We could only let it be.

<br/>

The good news is that at the end of 2023, there seems to be some improvement.

<br/>

So, in 2024:

- Improve internationalization construction (documentation, in-app language support, etc.).

#### 1.4 Quality Management

Since LifeUp is an offline tool app developed and tested solely by me, avoiding serious crash issues is especially important.

The version iteration process in 2023 took longer than before, and we reserved sufficient time for beta testing to ensure thorough preparation.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

These measures seem to effectively prevent large-scale serious crashes from occurring.

However, each version update still inevitably brings some problems, including some on critical paths.

Therefore, we'll continue improving LifeUp's quality management, with stability as the most important indicator (especially under the increasingly severe environment and review challenges).

<br/>

So, in 2024:

- Strengthen quality management.

#### 1.5 Deepening Functions

As mentioned in the third anniversary article, LifeUp is an app that gradually explored and grew.

So things like stores, custom achievements, API such features weren't in the initial plan, but were gradually developed and added with updates and feedback.

But this also introduced some problems:

- Some modules have rough planning details.
  - For example, item rewards initially only considered single rewards.
  - Attributes and other systems also didn't initially consider customization, and only gradual refactoring could support additions/deletions and custom levels, etc.
  - There are many such problems, like attribute reward/punishment popups and history display at most support 3.
- These newly added modules lack overall analysis and planning for the app.

We will continue in the direction stated in the third anniversary article, deepening the app's existing functional modules and solving some pain point issues, rather than pursuing new functional modules.

For example, we'll support direct multi-select item rewards, improve backup mechanism, notification optimization, widget completion, etc.

#### 1.6 API and Extensibility

As mentioned above, we no longer plan to introduce new functional modules.

But there will definitely be demands to extend the app.

So we introduced the API function in 2023.

We provide LifeUp's core as the foundation capability.

Even if users don't understand programming, they can use automation tools like Tasker/MacroDroid to extend functions, achieving automation capabilities.

Typical examples include:

- NFC, QR code to complete tasks
- Auto check-in when waking up
- Custom widgets
- And so on...

If users understand programming, they can extend even more gameplay or even Apps from this.

![img](_media/development_plan_2024/desktop.png)

We also developed a simple desktop version based on API (and open-sourced it).

Even after several versions of API expansion, we still lack many capabilities.

For example, not supporting "thought" related operations, not supporting updating data through Content Provider, etc.

We will continue expanding API in 2024 to cover every aspect of the app as much as possible.

> Although we currently see many users using API for personal use, there are still few shared runnable products. We need to continue providing stronger API capabilities to build an API ecosystem.

#### 1.7 About the Future

With the above problems and environmental changes, we also gradually adjusted the lifetime membership price of LifeUp (even so, LifeUp's membership pricing is far lower than most other apps), and updates will gradually tend toward providing features as membership features.

We gradually realize that apps ultimately serve core users.

Core users' feedback and support can ultimately be reflected in app improvements, achieving co-creation and positive cycle between developer and users.

If we try to please everyone, the app will become a mess of code, deviate from core users' demands, and reduce developer earnings and motivation.

<br/>

We mentioned KMP (Kotlin Multiplatform) above, which is a relatively emerging cross-platform technology. It can also use native capabilities mixed.

During LifeUp's development, we gradually had some new ideas. But not all ideas can or are suitable to land on LifeUp.

For example, replacing the entire UI, major changes to store logic, etc., which would inevitably seriously impact existing users' experience. We've also seen many cases of major app changes leading to failure.

<br/>

Also, when LifeUp was initially developed, the official database framework "Room" wasn't available yet, so we chose a domestic niche database framework.

Now some performance problems have become prominent, and it's difficult to replace.

Additionally, LifeUp now supports both Material 3 and legacy Material Design, plus dark mode, multi-language, domestic phone system fragmentation (compatibility configuration documentation only gets longer, native systems and overseas versions generally only need single page configuration) and other issues. Every page needs to consider many complex things.

<br/>

So we planned to explore KMP to see if we can use some technology with KMP.

Also to have the chance to implement more ideas and new projects in the future - more skills don't hurt.
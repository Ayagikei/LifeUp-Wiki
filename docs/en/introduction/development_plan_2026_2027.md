# 2026-2027 Development Plan

!> This is our current development plan. We will do our best to guide product improvements and upgrades according this plan. However, due to the ever-changing environment, the content in the development plan may be modified or added/subtracted. The actual product release shall prevail.

### I. Development Plan

> Updated: 2026/04

Unlike 2024-2025, we expect to continue improving existing modules of LifeUp and **ulives** in 2026-2027, rather than adding brand new functional modules.

| Module | Subfunction | Requirement Reason | Priority | Result |
| ---- | ------ | -------- | ------ | ---- |
| Calendar Integration | - Google Calendar Two-Way Sync<br/>- System Calendar Two-Way Sync | - Lots of overseas feedback.<br/>- LifeUp is a to-do tool with overlapping but inconsistent functions with schedule (calendar) apps. Developing all calendar features in LifeUp would be enormous. External integration may be a better solution. | P0 | 🚧 |
| Crafting Feature Optimization | - Integration with Shop<br/>- Enhanced filtering | - Crafting is one of LifeUp's core features. Continuously optimizing its integration with shop and filtering efficiency to improve user convenience. | P0 | ✅ Released |
| Item Feature Optimization | - Richer use effects (modify other item quantities)<br/>- Trigger sound effects<br/>- Support usage limits<br/>- Expanded limit conditions | - Item system is core to LifeUp's gamification. Currently being tuned in v1.103, continuously enhancing item flexibility and gameplay. | P0 | 🚧 v1.103 tuning |
| Attribute Feature Optimization | - Attribute sub-categories (grouping)<br/>- Title system support<br/>- Support [Status] type<br/>- Status page optimization<br/>- Life Level widget | - Attribute system is another core of gamification. We will continue improving attribute system with more dimension customization and display. | P0 | 🚧 Sub-categories released, others in planning |
| Task Feature Optimization | - Explicit tag editing and filtering<br/>- Sub-task editing interaction optimization<br/>- Custom sub-task forced completion behavior<br/>- Custom overdue or push behavior | - Task is LifeUp's core feature, continuously optimizing task editing and interaction experience. | P1 | 🚧 |
| Count Task Batch Rewards | - Support batch reward claiming for count tasks | - Current count task reward mechanism is relatively simple, batch rewards can provide more flexible goal incentives. | P1 | 🚧 |
| Thought/Reflection Feature Optimization | - Support more browsing styles | - Thought feature is LifeUp's characteristic, continuously optimizing its display and interaction. | P2 | 🚧 |
| Achievement Expansion | - Weekly/monthly/yearly type statistics<br/>- Unlock other achievement conditions | - Achievement system needs more diverse unlock conditions for richer achievement experience. | P2 | 🚧 |
| Data System | - Separate backup of data and images<br/>- Support partial data export/import<br/>- Support built-in multi-file switching | - WebDAV uploading large files fails easily, free cloud services have traffic limits, full backup with images is too large.<br/>- Partial export/import can be used for users to share reward systems.<br/>- Built-in multi-files allow users to directly switch between systems for debugging without clearing data repeatedly. | P1 | 🚧 |
| API | - Expand API capabilities and coverage to all basic functions | - Still missing some APIs like some thought-related operations.<br/>- LifeUp can't be all-in-one, but API enables everyone to customize and expand their LifeUp, and realize open source community. | P1 | 🚧 |
| **ulives** Development | - Continue improving **ulives** features<br/>- Explore multi-platform support (iOS/iPadOS/macOS/others) | - **ulives** is LifeUp's next generation product, developed with modern cross-platform technology.<br/>- Future有望 cross Android or other platforms. | P0 | 🚧 |

In summary:

1. We will continue to follow the established direction, focusing on stability and optimizing existing features.
2. Continuously improve functional depth of each module to enhance user experience.
3. Advance **ulives** development and explore more platform support.
4. Continue improving APIs and other aspects.

---

### II. Review and Outlook

#### 2.1 About **ulives**

In 2025, we launched **ulives** on iOS as LifeUp's next-generation product. Some users may wonder: why launch a new app? Why pay again?

Here are our thoughts and explanations:

**Technology and Architecture Constraints**

LifeUp is developed based on Android technology and has accumulated a lot of logic and historical compatibility issues during its development. Given technical architecture constraints, it's nearly impossible to replicate an identical version on iOS or HarmonyOS while maintaining data compatibility.

Moreover, LifeUp developed gradually, with some product designs compromised by compatibility and early design decisions, which we may not be able to change easily. For example:

- **Custom Currency**: LifeUp's underlying is a type of currency, making major architectural changes difficult.
- **World Module**: Early in LifeUp's development, due to server-side cooperation, we planned to add this module, but most features weren't thoroughly considered, resulting in lacking team features now.

Creating something new allows us to view these from a new product perspective with modern concepts.

**Technical Debt**

Technologically, LifeUp also stepped on some landmines:

- Using a database ORM framework suitable for early rapid development but basically unmaintained, making migration difficult.
- The underlying doesn't even support composite indexes, causing performance bottlenecks.
- We've spent considerable effort continuously optimizing app performance under large data volumes.

For **ulives**, we used modern cross-platform technology (Kotlin Multiplatform) to re-examine and develop these aspects. Future possibilities include crossing Android or other platforms (currently only supports iOS, iPadOS, and macOS).

**Cost and Pricing**

LifeUp's early low one-time pricing and single-platform positioning left us with limited cost control for features requiring investment (like World Module or AI features).

LifeUp (Android)'s low pricing is based on single-platform maintenance costs. **ulives** may have some adjustments and more planning.

Since development teams are different, it's a complete re-development, and **ulives** is currently fully offline. We indeed cannot share memberships or give extra discounts, and may not provide such discounts in the future to avoid hurting paid users.

---

#### 2.2 AI Efficiency

In recent years, we've witnessed the booming development of AI-assisted development, where many developers can use AI to develop app after app in a short time.

Indeed, we also try to use AI in our development process to quickly implement functional main frameworks and code scaffolding. However, AI is not all-powerful—determining technical solution routes, final acceptance, and ensuring everything works still requires significant human effort.

What truly takes time is polishing the details. Especially for iOS platform animation optimization, interaction smoothness tuning, edge case handling—the time invested here is often several times that of the functional logic itself.

---

#### 2.3 User Extensions and AI Integration

We've also seen many users implement interesting functions using AI combined with LifeUp's API:

- Some use MCP (Model Context Protocol) to connect LifeUp with various AI toolchains
- Some combine LifeUp with note apps like Obsidian for workflow automation
- Some implement their own web tools and automation scripts through APIs

We continue to welcome users sharing AI-based extension methods, and look forward to seeing more interesting ideas!

---

#### 2.4 Development Rhythm and Quality

We insist on long-term maintenance of LifeUp, **ulives**, and our other apps. We already have multi-year development plans and goals for LifeUp, and will continue advancing.

We won't pursue quickly launching new features while ignoring quality and stability. Every feature goes through careful design, development, testing, and optimization to ensure the final delivered product can withstand the test of time.

This is why we choose to invest more time in deepening and optimizing existing features rather than continuously launching new functional modules.

---

> Preview: In 2025 we also launched **ulives**, developed using Kotlin Multiplatform, currently only supporting iOS, iPadOS, and macOS, with plans to support more platforms in the future.
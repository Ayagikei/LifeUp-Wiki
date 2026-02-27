# FAQ

LifeUp is maintained by two indie teammates in our spare time:

- One developer mainly maintains the app.
- One teammate focuses on backend services and operations.

Some features and UI details are still being polished, and we are improving them step by step.

If LifeUp helps you, sharing it with others is a big help for us too.

If you'd like to support development, you can also buy us a coffee.

## ⚙️ Compatibility Configuration

If you run into issues like:

- reminders not firing
- Pomodoro reminders or item countdowns not working in background
- widget actions failing (for example, unable to check off count tasks)
- widget refresh problems

please read the compatibility guide:

> [!WARNING]
> [Compatibility configuration](/guide/compatibility.md)

## 🌍 Universal

<details>
<summary>Refund policy</summary>

LifeUp is currently listed as a paid app on Google Play due to historical reasons, making it difficult to migrate to a post-download payment model.

Google Play may automatically refund your order if you uninstall shortly after purchase.

If that automatic refund does not happen, contact us within **7 days** at [lifeup@ulives.io](mailto:lifeup@ulives.io).
Please include your GPA order number and send the email from the same Google account used for purchase.

For anti-abuse reasons, we can provide manual refund support only **once per user**.
We cannot process refund requests after 7 days from the purchase date.

Note: Google Play reviews do not include enough order details for refund handling.

</details>

<details>
<summary>Is my data private and secure?</summary>

Yes. We take privacy seriously.

Most data stays on your device and does not pass through our servers.

The main exception is the World module, where users can publicly share designs and templates.
All sharing there is opt-in: nothing is published unless you choose to share it, and you can delete shared content at any time.

You can read more in our [Privacy Policy](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms).

</details>

<details>
<summary>How can I back up my data if servers do not store it?</summary>

LifeUp supports both export/import backups and cloud-style backup targets.

You can use:
- Exported backup files
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Why is there no XX language? Or why is the translation incomplete and displayed in English?</summary>

Most languages in *LifeUp* are maintained by the community.

Starting in 2026, we will use AI translation for major languages to improve baseline quality and speed up updates.

Community proofreading and corrections are still very welcome.

You can contribute here: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Can I hide the World module if I do not need it?</summary>

Yes.

You can customize the bottom navigation bar in:
`Sidebar` → `Settings` → `Display` → `Module Config`.

From there, you can hide the World module or replace it with another module.

</details>

<details>
<summary>Pedometer is inaccurate, or I do not need this module?</summary>

> You can tap the small question-mark icon next to the pedometer in the app to see how it works.

- For better accuracy, open the app in the morning and evening, and avoid frequent device restarts.
- You can also enter step counts manually.
- If you do not need it, hide the pedometer in `Settings` → `Display`.

</details>

## ✅ Tasks

<details>
<summary>How do I undo a completed task?</summary>

You can undo completion in several places:

1. Right after completion, tap **Undo** in the bottom prompt.
2. On `Sidebar` → `History`, tap `Undo`.
3. On `Calendar` → `Ended`, tap `Undo`.

If the task deadline has already passed, direct undo is unavailable.
In that case, edit the record status instead (for example, set it to overdue or abandoned).

</details>

<details>
<summary>How do I mark an overdue task as completed?</summary>

When a task becomes overdue, an overdue dialog appears and allows you to mark it as completed.

After closing the dialog, you can still update task status later from:
- `Sidebar` → `History`
- `Calendar` → `Ended`

</details>

<details>
<summary>Is there an EXP/coin penalty for task failure?</summary>

Yes.

- EXP penalty is enabled by default (factor: `0.2x`).
- Coin penalty is disabled by default (factor: `0`).

You can change global settings in:
`Sidebar` → `Settings` → `Advanced`

You can also set penalties per task in the task editor.

</details>

<details>
<summary>How does the repetition mechanism work?</summary>

Set only the **first** cycle's `start time`, `deadline`, repeat frequency, and optional reminder time.

LifeUp will then calculate subsequent cycles automatically.

</details>

<details>
<summary>How do I set up a task that needs to be completed N times irregularly within a period?</summary>

LifeUp does not yet have a direct setting for "at least/at most N times per cycle." However, you can achieve this in several ways:

| Method | Setup | Pros | Cons |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Set frequency to `Weekly`, enable `Counting Task`, set count (e.g., 3). | Simple setup; progress is clear (e.g., 1/3). | **Rewards are only given after the final count is completed.** No reward for individual completions. |
| **Infinite Task + Target** | Set frequency to `Infinite`, target count to 3, deadline to Sunday. | **Rewards are given for each completion.** | **Must be recreated manually each week** (since the task ends after completion). |
| **Subtasks** | Set frequency to `Weekly`, add 3 subtasks inside. | Can set individual rewards and reminders for each completion. | Requires entering the detail page to check off subtasks; more steps involved. |
| **Infinite Task (Stats Only)** | Set frequency to `Infinite`. | Easiest setup; rewards and stats for every completion. | **No forced constraint.** You must check your stats manually to see if you met the weekly goal. |

> [!NOTE]
> We are considering adding a "Real-time Reward" feature for **Counting Tasks** (rewarding each count immediately), which is currently under evaluation.

</details>

<details>
<summary>How do I hide completed or unstarted tasks?</summary>

This usually happens in one of these cases:

1. If a task shows `xx deadline`, that task has already started.
   - Edit the task and adjust `start time` if needed.

2. If a task shows `xx starts` and the date is not today:
   - Check whether the bottom fold button is collapsed.
   - Open the top-right menu (`...`) → `Filter`.
   - Confirm `Show Today Tasks` is enabled.

> Note:
> - Smart lists (week/month) do not support folding.
> - For repeating tasks, one full cycle is valid by default. For example, a 21-day cycle can be completed on any of those 21 days. If you only want it visible near the end, adjust the start time once and let LifeUp calculate later cycles automatically.

</details>

<details>
<summary>How do I avoid tasks becoming overdue at midnight?</summary>

Overdue timing is controlled by the task deadline time.

After setting the deadline date, tap the `time` button and choose a later time.

For example, if you do not want an item to expire at `00:00`, set deadline time to something like `02:00` (next day).

You can also change global defaults in:
`Settings` → `Item` → `New item default settings`

(Changing defaults does not affect existing items.)

</details>

<details>
<summary>Why does the target number of times start from 1/N?</summary>

Unlike counting tasks, (1/N) **here does not represent total progress.**

Instead, **it indicates the current repetition count. Whether this repetition is complete is shown by ⚪ or ✅.**

<br/>

For example, ⚪1/10 means:
This task will be repeated 10 times in total (a total of 10 cards will be generated), and it is currently at the 1st time and has not been completed.

And ✅1/10 means:
The current card belongs to the 1st time and is completed.

If total progress were used, completed cards would display confusing statuses like (⚪1/10 and ✅1/10 coexist). Furthermore, cards might disappear upon reaching the goal (e.g., ✅9/10), which is counterintuitive.

</details>

<details>
<summary>How can I set multiple reminders for one task?</summary>

Create subtasks and assign different reminder descriptions/times to each one.

This is the recommended way to simulate multiple reminders for one main task.

</details>

<details>
<summary>Can subtasks be shown directly in the task list?</summary>

Not at the moment. We may consider this in future updates.

</details>

## 🎁 Rewards (Experience Points, Goods)

<details>
<summary>Can I assign different EXP values to different attributes for one task?</summary>

Not directly in the current version.

For fast setup, one task currently uses one EXP value per attribute. If you need different EXP values by attribute, use this workaround:

1. Create an item.
2. Configure different EXP effects for different attributes on that item.
3. Set the item to be auto-used after task completion.

This gives you task completion + item effect as a combined reward pipeline.

We plan to improve native support for this in future versions.

</details>

<details>
<summary>How are EXP and coins calculated automatically?</summary>

EXP mainly depends on:
- `difficulty`
- `importance`
- `number of selected attributes`

Coins mainly depend on:
- `difficulty`
- `importance`

</details>

<details>
<summary>How is Life Level calculated?</summary>

Life Level EXP is positively related to EXP gained from any attribute.

When penalties apply, Life Level EXP is also reduced proportionally.

Life Level is designed as a broad, aggregated indicator, so we do not recommend over-focusing on the formula.

What matters most is that it reflects your overall long-term progress.

Formula reference: each EXP gain/loss action contributes 1/5 to Life Level EXP, regardless of how many attributes are rewarded in that action.

</details>

<details>
<summary>Can I set custom EXP and coin rewards for tasks?</summary>

Yes.

When creating a task or achievement, tap the corresponding reward button and configure values manually.

</details>

<details>
<summary>Why are item images missing or not displaying?</summary>

LifeUp is offline-first, so item images are stored locally on your device.

If images are missing, check what happened recently:

**After importing a backup:**
- The backup may not include image files.
- Re-import a complete backup that includes images.

**After cleanup/file-management operations:**
- LifeUp does not actively delete image files.
- Third-party cleaner/file tools with broad permissions may delete them by mistake.
- Use such tools carefully.

**For items imported from World:**
- It may be a temporary network loading issue.
- Try again later, or replace with local images.

If you still have an old backup with images, you can restore that backup first to recover media, then restore your latest data backup.

</details>

<details>
<summary>How do I delete a shop item?</summary>

On the `Shop` page, long-press the item, then tap the `trash` button at the top.

</details>

<details>
<summary>How do I clear EXP and coins?</summary>

Go to:
`Sidebar` → `Settings` → `Data backup, restore, clear`

You can clear EXP and coin values there.

Note: if you use online features, related server-side displays may take a short time to refresh.

</details>

<details>
<summary>What are the level caps and experience gradients for attributes?</summary>

It can be regarded as having unlimited levels (currently 2000+, which is hard to reach by normal means).

The experience required for each level scales up, though the current gradient is steep. (Thus, rewards shouldn't be evaluated solely by level caps; the experience cap is approximately 2^63).

In fact, many users will remain in the 2500 EXP gradient for a long time. We may optimize the level system or allow customization in the future. (Total experience points will not be affected).

| Level    | Experience Points Required for Each Level |
| -------- | ----------------------------------------- |
| 1 → 2     | 300                                       |
| 2 → 3     | 700                                       |
| 3 → 4     | 1500                                      |
| 4 → 99    | 2500                                      |
| 99 → 150  | 5000                                      |
| 150 → 200 | 7500                                      |
| 200 → 250 | 15000                                     |
| 250 → 300 | 30000                                     |
| 300 → 325 | 50000                                     |
| 325 → 350 | 100000                                    |
| >350     | 500000                                    |

</details>

<details>
<summary>How do I configure loans, ATM interest, and loan interest?</summary>

On the `Shop` page, open the top-right menu (`...`) and select `Settings`.

</details>

<details>
<summary>How do I customize attributes or skills?</summary>

Go to:
`Sidebar` → `Settings` → `Advanced` → `Custom Properties`

You can add, edit, or delete custom attributes freely.

If you want to track skills, create attributes named after skills (for example, `Fishing` or `Programming`).

</details>

<details>
<summary>Can I modify attributes used by sports rewards or World like-count rewards?</summary>

Not in the current version.

These built-in reward mappings are fixed for now.

</details>

<details>
<summary>How do I set up Loot Box rewards?</summary>

When creating a shop item, add a `Loot Box` effect to that item.

Then configure reward pool, probability, and related settings in that effect.

</details>

<details>
<summary>Can I set a Loot Box probability lower than 1%?</summary>

Yes.

After configuring the Loot Box effect, tap the in-app `?` help button for probability details and setup guidance.

</details>

<details>
<summary>How can I get more icons?</summary>

We are a small indie team and currently cannot maintain a large built-in icon set.

You can get more icons in these ways:

1. Import items from `World` → `Market` and reuse their icons.
2. Use external icon resources (make sure usage rights are valid):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. If possible, prefer transparent-background icons for better in-app display.

</details>

## ⏰ Reminder / Pomodoro / Countdown

<details>
<summary>How do I use the shop item countdown effect?</summary>

Countdown effects are delivered as app notifications.

First, confirm that notification permission for LifeUp is enabled.

</details>

<details>
<summary>Does Pomodoro support auto-next?</summary>

Not currently.

You can try count-up timer mode.

In Pomodoro mode, when one work session ends, the timer keeps counting up. You can then decide whether to add extra time to focus records. Auto-next would conflict with this workflow.

</details>

<details>
<summary>How can I quickly start Pomodoro from the task list?</summary>

You can:
1. Long-press a task and tap `Timer` in the action menu.
2. Or configure a swipe action to `Timer` in `Tasks` settings.

</details>

<details>
<summary>Does Pomodoro provide summary statistics like dedicated Pomodoro apps?</summary>

Not yet.

LifeUp's Pomodoro is still a lightweight module in early-stage development.

Currently available:
- Per-session detailed records
- Basic daily summary stats on the `Status` page

</details>

## 💾 Backup and Restore

<details>
<summary>How do I back up data?</summary>

Please read the [Backup and Restore Guide](/guide/backup.md) first.

In short, supported backup methods include:
- Google Drive (recommended)
- Dropbox
- Export backup files
- WebDAV servers

</details>

<details>
<summary>Why is LifeUp designed as an offline-first app?</summary>

LifeUp follows an offline-first architecture by design.

This means:
- Your data is owned and controlled by you.
- Data stays local unless you explicitly choose backup/sync options.
- Most core features still work without network access.

Because the client handles core logic locally, you can keep using LifeUp even when network or server availability is limited (except online features such as the World module).

</details>

## 🧭 Planning

<details>
<summary>Will there be an iOS version of LifeUp?</summary>

In **2025**, we launched [ulives](https://app.ulives.io/), a new productivity app for iOS users.

A direct LifeUp port to iOS is not realistic:
- LifeUp is built with native Android technology.
- Its offline-first architecture ties UI, local data model, and business logic closely to the Android implementation.
- A direct port would still require major rewrites to keep data and logic consistent.

So we reorganized and rebuilt with a cross-platform direction through ulives.

ulives keeps the core spirit of LifeUp while also addressing several long-standing design and product issues from earlier generations. You can think of it as a fresh evolution, not just a one-to-one clone.

</details>

## 🆘 Still Need Help?

<details>
<summary>Contact us</summary>

You can reach us at [lifeup@ulives.io](mailto:lifeup@ulives.io).

You can also open an issue on GitHub:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Would you like to support us?</summary>

Thank you for supporting LifeUp.

If LifeUp has been helpful to you, you can support us in two simple ways:

1. Buy us a coffee from the **About** page in the **Google Play version** of the app.
2. Help more people discover LifeUp by sharing your experience:
   - Recommend LifeUp to friends
   - Post your usage stories and workflows
   - Share tips, guides, or tutorials

</details>

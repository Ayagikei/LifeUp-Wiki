<h1 align="center" padding="100">Open interface</h1>

<p align="center">Create endless possibilities! </p>





?> In the v1.90 version, `LifeUp` has opened a variety of functional interfaces, and any external application integration is welcome. <br/>It also provides the “URL” effect for shop items, and users can directly use commodities to call external applications or the interface of `LifeUp`. <br/>These features can give your `LifeUp` unlimited possibilities, but it also requires a little learning understanding and hands-on ability.



## Scenario example

| Caller | Scenario | Notes |
| ------ | -------- | ----- |
|**LifeUp->Other Applications**<br/>Implemented through the "URL" effect of the shop item| **After using the shop item:**<br/>1. Use a browser to visit a webpage<br/>2. Jump to WeChat and scan Scan, or specify a small program<br/>3. Automatically add accounting records ([such as "Qianji" supports accounting interface](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Store the automation tool Tasker configuration (even share it in the Market), and automatically import the configuration into Tasker after use<br/>5. Trigger Tasker to change wallpaper<br/>6. ... (as long as the external application supports this method call) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) is an automation tool and it supports exporting configuration as Uri |
|**LifeUp->LifeUp**<br/>Implemented through the "URL" effect of the shop item| **After using the shop item:**<br/>1. Open a specific page<br/>2. Increase the ATM interest rate<br/>3. The pop-up window allows the user to select the product and reduce the price of the product (price reduction coupon)<br/>4. Trigger a task to complete<br/>5. Pop up a custom motivational message<br/>6. Create a task reward template: just enter the name to create a task automatically<br/>7. Pop up The window asks the user for branch selection, creating a small contextual interaction<br/>8. More in-app operations... |  |
|**External applications/webpages->LifeUp** | **Configure automation tools:**<br/>1. Determine when the phone is turned on for the first time every day, complete the task of getting up early, or directly trigger the "getting up late" penalty<br/>2. After every 25 words, swipe a specific NFC card and automatically complete the task<br/>3. The GPS determines that a new place is reached, and unlocks the "new place" achievement<br/>4. When connecting to the working WIFI every day, trigger the unlocking condition progress to increase. After accumulating 20 days, unlock the achievement of "Worker"<br/>5. Reward yourself with "arrive home" gold coins when connecting to your home WIFI for the first time every day<br/>6. Capture notifications from other Tomato or Focus applications, and automatically record the timing  to `LifeUp`<br/>7. Capture the completion or end notification of sports and learning software, and automatically issue "strength" and "knowledge" experience points<br/>8. Within the time period set by yourself, every time you open your phone, you will trigger a penalty<br/>9. ...<br/>**External Application linkage/self-developed application:**<br/>1. If you are not satisfied with the Pomodoro of `LifeUp`: you can develop your own timing software, which can be a web application or Android application, and link with "LifeUp" through the interface to Add timing records or add rewards<br/>2. Modify some intelligence mini-games (such as a Wordle example below). When the game is successfully completed, trigger `LifeUp` to send rewards<br/>3. ... |  |


<br/>In other words, all the above scenarios are actually "events" that trigger "actions".

This update of `LifeUp` provides the event trigger point of "use of items", and then provides various "actions" (rewards, completion of tasks, etc.).

if you need

- Click the web button
- Swipe the NFC card
- Wake up every day to unlock the screen for the first time

This kind of event requires the intervention of external applications. For example, do secondary development yourself or use automation tools such as `Tasker` and `MacroDroid`.



**The LifeUp 1.90.2 update will add a series of "events", but these events can to be received by automated tools or external applications.**

Can be used to achieve:

After using the item, trigger automated tools such as Tasker to switch the launcher wallpaper.

After completing the task, trigger an automated tool such as Tasker to open an app.

**In the 1.90.2 version, it is possible to realize the "LifeUp event" triggering "Tasker's operation".**

Tasker has extremely high permissions, which can be used to change wallpapers, uninstall apps, increase volume, choose to open specified apps, and more. You can even write UI interaction logic without programming foundation.


---

## Recommendations

**If you are not familiar with programming,** you can search and import special shop items directly in the [World] - [Market] - [Link]/[API]/[Automate] tag. You can also try to edit parameters to meet your need.

**If you are familiar with computer knowledge,** you can try to read the following interface documentation and edit the desired effect yourself. And use it with automation software such as [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Even if you don't edit Tasker's configuration, as long as you can successfully install Tasker, you can import automated configurations shared by others in Market or other communities.

**If you have a programming foundation,** you can try to develop web pages or Android applications to make them integrated with LifeUp. This web page and customized versions of Wordle are some examples. You are also welcome to make and share automation tool configurations.

---

## Call other application

If you want to call an external application in *LifeUp*, you only need to add a "Link" effect to the shop item, **enter a web page or application-specific link**, and then use the shop item to trigger the call.



**The following are some examples (you can also go to "World"-"Market"-"Link" to view public items with interface call effects):**

- Browser to open Google: https://www.google.com
- Facebook: [fb://](fb://)
- ...



Theoretically, as long as the external APP provides the URL, you can jump by using the shop item.

**You can search for the application link you need by searching `URL Schemes` on Google.**

**These links have nothing to do with `LifeUp`, `LifeUp` only provides the jump URL function.**

**Therefore we do not and do not maintain a list of URLs. But you can view the public shop items containing the link effect on the [World]-[Market]-[Link] page.**



---

## Call LifeUp APIs

If you:

- Need to call the `LifeUp` interface in `LifeUp`. You only need to add a "link" effect to the shop item, input **a specific URL** according to the APIs documents, and then use the shop item to complete the call.
- Calling through the web page, you only need to jump to the LifeUp APIs by hyperlink.
- To call through the APP developed by yourself, you only need to use the Intent to jump to the corresponding interface link.
- Called by an automated tool (such as Tasker), fill in the corresponding API link in Tasker's Brower URL.



**Some examples:**

When you click the link below, "LifeUp" will a prompt "You have learned to call APIs!".

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

When you click the link below, you will get a coin in "LifeUp", and the reason for it is "Learn API Calls".

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

If you copy the link to the item's "link" effect, using the item can also trigger the same effect.



**An example of external application linkage:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle is a little word guessing game: guess words of length 5. Orange represents the word in the answer that contains the letter. Green is included and in the correct position.

**This version of Wordle supports linkage with "LifeUp":**

1. If you guess the word correctly, you can get 10 coins. And there is a customized reason for obtaining it.
2. If you fail to guess the word in the end, there will be a consolation prize of 1 coin.

![](_media/api/wordle.png ':size=30%')

<br/>

**Example of linkage with Tasker:**

> Tasker is invoked by selecting `Action Category`-`Program`-`Shortcut`. Enter the link starting with lifeup:// in the shortcut column.

Unlocking the screen for the first time after 5 o'clock every day can trigger the completion of the task you specify (such as getting up).

**Note: A Task Group Id is required to import this configuration. You can turn on [Developer Mode] in [Settings]-[Labs], and then check the gid on the task details page. **

If you have Tasker installed, [click here to import the configured tasks. ](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)



![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**How to use MacroDroid to call LifeUp APIs:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) is also an automation tool, it is free to download and the UI is easier to use.

1. Add macros, then set the conditions you need (or set them later)
2. Add `Actions`
3. Select `Applications`
4. Select `Open Website`
5. Enter a URL starting with `lifeup://` in the `Enter URL` field
6. **[Uncheck]** all the options below, such as `URL encode parameters`...
7. Save it, you can click the action, and then select the `Test action` to verify

<br/>

**Through this function, you can infinitely expand the possibility of LifeUp, whether you know about programming or not!**

Please see below for specific calling rules.

---

## Interface documentation

### Basics - Examples

| Type             | Description   |
| ---------------- | ------------- |
| Example          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Interface format | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Fixed prefix     | lifeup://api/ |
| Method name      | toast         |
| Parameters       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

If the value of your parameter contains special symbols such as +, space, =, %, &, #, etc., it needs to be escaped:

| Special characters | Meaning                                         | Replace to |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | The + sign in the URL represents a space        | +          |
| spaces             | spaces in URLs can be + or encoded              | %20        |
| /                  | separates directory and subdirectory            | %2F        |
| ?                  | separates the actual URL and parameters         | %3F        |
| %                  | Specify special characters                      | %          |
| #                  | means bookmark                                  | %23        |
| &                  | Separator between parameters specified in URL   | %26        |
| =                  | The value of the specified parameter in the URL | %3D        |

Take the interface of the above pop-up message as an example. If you want the final prompted text stands: `You have learned to call APIs!`
Then you need to replace the spaces to +, the final effect is:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**This is a simple coding tool implemented in Javscript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Almost all data storage in LifeUp has a unique id.

Some of the following interfaces support modifying **specified** shop items and completing **specified** tasks.

For `LifeUp` to find the corresponding data, you need to provide it with an id.

**You can enable "Settings" - "Labs" - "Developer Mode" to view the original id of the data on each detail page in the app.** 

For example, the attributes name displayed like "strength (1)", its attribute id is 1.

#### Task id

It can be viewed on the event details page.

id: If it is a repeating task, the id will be updated every time it repeats.

gid: The id of the item group. For the same repetitive task, its gid will not change.

#### List id

After enabling "Developer Mode", view it in the "Select List" pop-up window.

#### Attribute id

After enabling "Developer Mode", view it on the "Custom Properties" page.

#### Shop item id

After enabling "Developer Mode", click on the shop item to view the details.

#### Achievement condition id

After customizing the unlock condition for the achievement "requires an external API call to unlock", you can see the condition id on the details page.and 

<br/>

### Basics - Return Values

Some interfaces may have return values.

**If you are developing an Android application,** you can use the `onActivityResult` method to receive the return value.

**If you are using an automation application such as Tasker:**

Generally, such applications cannot receive return values ​​of type Activity. So you need to add a `broadcast` parameter and then use the `received intent` event to receive the return value.

For details, see the broadcast broadcast parameters below.

<br/>

### Popup message

**Method name:** toast

**Description:** Various styles of messages pop up

**Example:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Explanation:** The prompt "Live well, eat well!" pops up in a bonus style and displays it for a longer time.

> Click on the link of the example to test the effect

| Parameter | Meaning                | Type               | Example              | Required | Notes |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Text message to prompt | Any text           | You learned to call! | yes      |       |
| type      | Text style type        | Number from 0 to 6 | 1                    | no       | 0 - Normal style<br/>1 - Bonus style<br/>2 - Tomato style<br/>3 - Success style<br/>4 - Prompt style<br/>5 - Warning style<br/>6 - Error style |
| isLong    | Display duration       | true or false      | true                 | no       | true - long<br/>false - short |

<br/>

### Reward

**Method name:** reward

**Description:** Provide the reward directly. The reason for the reward can be customized.

**Example:**

- Get 1 coin, and the reason for getting it is "Learn API Calls". And the reason will be displayed on the gold coin details page:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Get 300 experience points for "Learning, Creativity" , and the reason for obtaining them is "Learn API Calls". And the reason will be displayed on the EXP details page:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Obtained 1 fuzzy matching "treasure" item, and the reason for getting it is "Learn API Calls". And the reason will be displayed on the inventory history page:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parameter | Meaning                       | Type                            | Example            | Required | Notes                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | reward type                   | currently only supported following values: <br/>coin<br/>exp<br/>item | coin | yes | coin - coins<br/>exp - experience points<br/>item - shop items |
| content   | reward reason                 | any text                        | Learning API Calls | Yes      |                                  |
| skills    | skills (attributes)           | array of numbers greater than 0 | 1                  | No       | Available only when type is exp<br/>Supported arrays (eg &skills=1&skills=2&skills=3)<br/>For how to obtain, see above The article "Basic Knowledge - LifeUp Data ID" |
| number    | number of rewards             | a number greater than 0         | 1                  | Yes      | If it is a gold coin, the maximum value is 999999<br/>If it is an experience value, the maximum value is 99999<br/>If it is a item, the maximum value is 999 |
| item_id   | item id                       | number greater than 0           | 1                  | no*      | only available when type is item |
| item_name | item name                     | any text                        | treasure           | no*      | only available when type is item, fuzzy matching with item names |
| silent    | whether to disable UI prompts | true or false                   | false              | no       | default is false                 |

<br/>

### Penalty

**Method name:** penalty

**Description:** Provide a penalty directly. The reason for the penalty can be customized.

**Example:** *Basically the same as the reward interface

- Penalize 1 coin, the reason for obtaining it is "sleep in". And the reason will be displayed on the coin details page:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Penalize 300 "Strength" experience points for "sleep in". And the reason will be displayed on the EXP details page:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Penalize 1 fuzzy matching "trasure" item for "sleep in". And the reason will be displayed on the inventory history page:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=trasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=trasure</a>

| Parameter | Meaning                       | Type                                                 | Example  | Required | Notes            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | penalty type                  | Currently only supported: <br/>coin<br/>exp<br/>item | coin     | yes      | coin - coins<br/>exp - experience points<br/>item - shop items |
| content   | reason for penalty            | any text                                             | Sleep In | Yes      |                  |
| skills    | skills (attributes)           | array of numbers greater than 0                      | 1        | No       | Available only when type is exp<br/>Supported arrays (eg &skills=1&skills=2&skills=3)<br/>For how to obtain, see above The article "Basic Knowledge - LifeUp Data ID" |
| number    | number of rewards             | a number greater than 0                              | 1        | Yes      | If it is a coin, the maximum value is 999999<br/>If it is an experience value, the maximum value is 99999<br/>If it is a item, the maximum value is 999 |
| item_id   | item id                       | number greater than 0                                | 1        | no*      | only available when type is item |
| item_name | item name                     | any text                                             | treasure | no*      | only available when type is item, fuzzy matching with item names |
| silent    | whether to disable UI prompts | true or false                                        | false    | no       | default is false |

<br/>

### Task

#### Add a Task

**Method name:** add_task

**Description:** Create tasks automatically

**Example 1:**

<a href="lifeup://api/add_task?todo=This is an automatically added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=treasure">lifeup://api/add_task?todo=This is an automatically added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=treasure</a>

**Explanation 1:** Add a task to the default list (id is 0) with the content "This is an automatically added task", the notes are "notes", the coin reward is random from 10 to 11, the experience value reward is 2048, the selected The skill ids are 1, 2, and 3 (generally corresponding to the first 3 built-in attributes). The shop item reward is a fuzzy search for a "treasure" shop item.

**Example 2:**

[lifeup://api/add_task?todo=Task due tomorrow&deadline=[$time|today|86400000]](lifeup://api/add_task?todo=Task due tomorrow&deadline=[$time|today|86400000])

**Explanation 2:** Dynamically add a task due tomorrow using a time placeholder.

Note: This feature requires LifeUp version 1.93.0-beta01 (502) or higher.

| Parameter      | Meaning                         | Type                                        | Example                        | Required | Notes |
| -------------- | ------------------------------- | ------------------------------------------- | ------------------------------ | -------- | ----- |
| todo           | task content                    | any text                                    | Write journey                  | yes      |       |
| notes          | notes                           | any text                                    | Notes                          | no       |       |
| coin           | coin reward amount              | a number greater than 0                     | 10                             | no       | The maximum value is 999999 |
| coin_var       | coin reward amount offset value | a number greater than 0                     | 1                              | no       | If the value is greater than 0, when completing the task, gold coins will be randomly calculated in the interval [coin, coin+coin_var] |
| exp            | experience reward               | a number greater than 0                     | 1                              | no       | maximum value is 99999 |
| skills         | attribute (skill) id            | array of numbers greater than 0             | 1                              | no       | Support array (ie &skills=1&skills=2&skills=3)<br/>For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |
| category       | list id                         | a number greater than or equal to 0         | 0                              | no       | 0 or not passed represents the default list, and cannot select a smart list<br/>For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |
| frequency      | repetition frequency            | number, see remarks for the range of values ​​| 0                              | no       | <br/> -1 - Unlimited<br/> -3 - Ebbinghaus<br/> -4 - Monthly<br/> -5 - Yearly |
| importance     | importance level                | number from 1 to 4                          | 1                              | no       | default is 1 |
| difficulty     | difficulty level                | number from 1 to 4                          | 2                              | no       | default is 1 |
| item_id        | id of the rewarded item         | a number greater than 0                     | 1                              | no       |       |
| item_name      | the name of the reward item     | any text                                    | treasure                       | no       | fuzzy search item name |
| item_amount    | amount of reward                | Number from 1 to 99                         | 1                              | no       | default is 1 |
| deadline       | deadline time                   | timestamp (milliseconds)                    | 0                              | no       | Consider using an external tool to calculate the timestamp and provide it.<br/>Alternatively, you can refer to the time placeholders in the [variable placeholders] in the following text.|
| color          | the color of the task tag       | color text                                  | \#66CCFF                       | no       | available in v1.91+<br/>Note that the # character needs to be escaped when used. <br/>For example, when the color value of the example is actually used, it should be `color=%2366CCFF`|
| background_url | background picture URL          | URL text                                    | http://www.aaabbbccc.com/1.jpg | no       |       |

**Return Value:**

Only supported since version 1.90.2

| Parameter | Meaning                   | Value  | Example | Required | Notes |
| --------- | ------------------------- | ------ | ------- | -------- | ----- |
| task_id   | new task id               | number | 1000    | yes      |       |
| task_gid  | newly added task group id | number | 1000    | yes      |       |

<br/>

#### Complete a Task

**Method name:** complete

**Description:** Trigger task completion. Only unfinished tasks will be searched.

**Example:**

- Complete the task with id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Complete the task with "task group id" of 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Search for tasks by name and complete them: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Explanation:**

Each task has an id.

For repeating tasks, the id will be refreshed every time, but the "task group id" will remain the same.

The method of obtaining the id is to open the "Developer Mode" on the "Labs" page and then view it on the "Task Details" page.

| Parameter | Meaning                         | Type                  | Example | Required | Notes |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | task id                         | number greater than 0 | 1       | no*      | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid       | task group id                   | number greater than 0 | 1       | no*      | task group id; |
| name      | name                            | any text              | get up  | no*      | fuzzy search, only one of the tasks found |
| ui        | Whether to display the popup UI | true or false         | true    | no       | the default is false, only a message is displayed in the background |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

#### Give up a Task

**Method name:** give_up

**Description:** Trigger the task to give up.

**Example:**

- Search for tasks by name and give up: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid       | task group id | number greater than 0 | 1       | no*      | task group id; |
| name      | name          | any text              | get up  | no*      | fuzzy search, only one of the tasks found |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

#### Freeze a task

**Method name:** freeze

**Description:** Trigger task freeze, only for repeating tasks.

**Example:**

- Search for tasks by name and freeze: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid       | task group id | number greater than 0 | 1       | no*      | task group id; |
| name      | name          | any text              | get up  | no*      | fuzzy search, only one of the tasks found |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

#### Unfreeze a task

**Method name:** unfreeze

**Description:** Trigger task freeze, only for repeating tasks.

**Example:**

- Search for tasks by name and unfreeze: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid       | task group id | number greater than 0 | 1       | no*      | task group id; |
| name      | name          | any text              | get up  | no*      | fuzzy search, only one of the tasks found |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

#### Delete a task

**Method name:** delete_task

**Description:** Delete  a task.

**Example:**

- Search for tasks by name and delete it: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid       | task group id | number greater than 0 | 1       | no*      | task group id; |
| name      | name          | any text              | get up  | no*      | fuzzy search, only one of the tasks found |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

### Shop Settings

**Method name:** shop_settings

**Instructions:** Adjust various store settings

**Example:**

- Set ATM interest rate to 0.01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Increase interest rate by 0.01% per click: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Meaning              | Type | Example | Required | Notes |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | type                 | Currently only following values  supported: <br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | yes | atm_interest - ATM daily rate<br/>credit_interest - loan daily rate<br/>line_of_credit - loanable amount<br/>discount_rate_for_returning - return discount Scale<br/>atm_balance - Set ATM balance |
| value     | numeric value        | decimal number or integer | 0.01 | yes | different keys correspond to different value ranges<br/>For example, ATM balances do not support decimal points |
| set_type  | How to set the value | One of the following values:<br/>absolute<br/>relative | absolute | yes |absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value|
| silent    | Whether to execute silently (without displaying UI) | Boolean | false | No | Supported from v1.93.0-beta01 (502) and later<br/>Default is false, which means it will display UI prompts |
<br/>

### Jump

**Method name:** goto

**Description:** Jump to a page in `LifeUp`

**Example:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explanation:** Jump to the Labs page

| Parameter | Meaning | Value | Example | Required | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | page | One of the following values:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail | lab | yes | |

#### 1. Jump to the item purchase pop-up window

When the `page` parameter is set to `purchase_dialog`, you can specify the item ID:

For example: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parameter | Meaning | Value            | Example | Required | Notes   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | Item ID | Positive integer | 1       | Yes      | Item ID |

<br/>

#### 2. Jump to the subpage of the home page

When the `page` parameter is `main`, you can additionally specify the subpage to jump to:

For example, jump to the store page: `lifeup://api/goto?page=main&sub_page=shop`

| Parameter   | Meaning       | Value | Example | Required | Notes  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | sub page name | Fixed one of the following values:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | no       |      |
| category_id | list id       | number | 0      | no       | If `sub_page` is a list page, you can specify the list id to jump to. <br/>Such as shop item list, inventory list, task list. |

<br/>

#### 3. Jump to task details

When the `page` parameter is `task_detail`, you can additionally specify the task id to jump to:

For example, jump to the details page of the specified task id 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parameter | Meaning       | Value         | Example      | Required | Notes |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | task id       | task id       | 53           | No*      | task id; if it is a repeating task, the id will be updated every time it is repeated. |
| task_gid  | task group id | task group id | 3            | No*      | task group id |
| task_name | task name     | string        | get up early | No*      | task name, fuzzy match one. |

**Notice:**

1. Only one of the three parameters needs to be provided.
    - If multiple are provided at the same time, there will be an internal priority order. But this is undefined behavior, APP will not guarantee the order.

<br/>

### Shop

#### Adding items

**Method name:** add_item

**Description:** To create a shop item. The icon only supports network URLs, and the use effect is not supported yet.

**Example:** <a href="lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest">lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest</a>

**Explanation:** Create a shop item with the name "Take a 10-minute break", the description as "Go and take a short break! ", and the action text copy as "Rest" with a price of 10 gold coins.

| Parameter        | Meaning                      | Type                                | Example         | Required | Notes |
| ---------------- | ---------------------------- | ----------------------------------- | --------------- | -------- | ----- |
| name             | shop item name               | any text                            | 10 minute break | yes      | shop item name |
| desc             | description                  | any text                            | get a gift      | no       |       |
| icon             | icon                         | any text                            |                 | no       | icon should be a web address URL |
| price            | price value                  | number from 1 to 999999]            | 1               | no       |       |
| action_text      | action button text           | any text                            | rest            | no       |       |
| disable_purchase | whether to disable purchases | true or false                       | 1               | no       | default false |
| stock_number     | number of stocks             | number from -1, 99999]              | 1               | no       |       |
| category         | shop item list id            | a number greater than or equal to 0 | 0               | no       | 0 or not passed represents the default list, and cannot select a smart list<br/>For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |

**Return Value:**

Only supported since version 1.90.2

| Parameter | Meaning     | Type   | Example | Required | Notes |
| --------- | ----------- | ------ | ------- | -------- | ----- |
| item_id   | new item id | number | 1000    | yes      |       |

<br/>

#### Edit items

**method name:** item

**Description:** Various operations on the shop item with the specified id only support the [On Shelf] shop item.

**Example:** [lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative)

**Explanation:** For a shop with an id of 1, increase its price by 1 coin and increase the own number of it by 1

| Parameter          | Meaning            | Type                    | Example    | Required | Notes |
| ------------------ | ------------------ | ----------------------- | ---------- | -------- | ----- |
| id                 | shop item id       | a number greater than 0 | 1          | no*      |       |
| name               | shop item name     | any text                | treasure   | no*      | when used for unknown id, fuzzy search for commodities, not name modification |
| set_name           | modify name        | any text                | treasure   | no       | cannot be empty if you provide this param |
| set_desc           | modify description | any text                | get a gift | no       |       |
| set_icon           | modify icon        | any text                |            | no       | Icon should be a web address URL |
| set_price          | adjust price value | number                  | 1          | no       |       |
| set_price_type     | price adjustment method (absolute/relative) | One of the following values: <br/>absolute<br/>relative | relative | no | absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value |
| own_number         | modify own number  | number [-, +]           | 1          | no       |       |
| own_number_type    | own number adjustment method (absolute/relative) | One of the following values:<br/>absolute<br/>relative | relative | no | absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value |
| stock_number       | stock number       | number [-, +]           | 1          | no       |       |
| stock_number_type  | stock number adjustment method (absolute/relative) | One of the following values: <br/>absolute<br/>relative | relative | no | absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value |
| disable_purchase   | Is it disabled to purchase the item | `true` or `false` | true | no | available in v1.91 |
| action_text        | Action text        | Any text                | Unlock     | No       | Supported from v1.93.0-beta01 (502) and later |
| disable_use        | Disable use        | Boolean                 | true       | No       | Supported from v1.93.0-beta01 (502) and later |
| title_color_string | Title color        | Color string            | #66CCFF    | No       | Requires v1.91+<br/>Note that in practical use, the # character needs to be escaped.<br/>For example, the color value in the example should be used as color=%2366CCFF. |

**Notice:**

1. In order for `LifeUp` to search for a shop item, either an `id` or `name` must be provided.

<br/>

#### Adjust the Loot Box effect

**Method name:** loot_box

**Description:** Modify the loot box effect of the specified box item, support adjustment of probability, number of rewards and increase content. (Delete is not supported for now)

**Example:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Explanation:** Increase the proportion of the [large] bag of gold coins in the gold coin box by 1 point.

| Parameter   | Meaning                               | Type                                                    | Example        | Required | Notes                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | item id                               | a number greater than 0                                 | 1              | no*      | Please refer to the above "Basic Knowledge - Person-liter Data ID" for how to obtain |
| name        | item name                             | any text                                                | Treasure chest | no*      | When used for unknown id, fuzzy search product, not name modification |
| sub_id      | content item id                       | a number greater than 0                                 | treasure chest | no*      | id of chest contents                                         |
| sub_name    | content item name                     | any text                                                | Get a gift     | no*      | For fuzzy search items when the id of the contents of the box is unknown |
| set_type    | adjustment method (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | no       | absolute - absolute value, that is, directly set the target to value<br/>relative - relative values, adding or subtracting from the original value |
| amount      | number of content item                | number                                                  | 1              | no       | number of rewards for a single item                          |
| probability | probability of the content item       | number                                                  | relative       | no       | -                                                            |
| fixed       | whether it is a fixed reward          | boolean                                                 | true/false     | no       | -                                                            |

**Notice:**

1. In order to search for a product, either id or name must be provided.
1. In order to search for content, either sub_id or sub_name must be provided.

<br/>

#### Use items

?> This API was introduced in version v1.93.0-beta01 (502).

**Method name:** use_item

**Description:** Create an item; the icon only supports web addresses and does not currently support custom usage effects.

**Example:**

- Open a coin box: [lifeup://api/use_item?name=coin_box&use_times=1](javascript:void(0))

| Parameter | Meaning     | Type                    | Example  | Required | Notes                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | Item ID     | a number greater than 0 | 1        | No*      | For obtaining the item ID, please refer to the "Basic Knowledge - LifeUp Data ID" section |
| name      | Item name   | Any text                | coin_box | No*      | Used for unknown IDs; performs a fuzzy search for items      |
| use_times | Usage times | a number greater than 0 | 1        | No       | Default is 1 time<br/>For regular items or opening boxes, it corresponds to the quantity of the item<br/>For simple synthesis items, this value corresponds to the "synthesis quantity" rather than the number of consumed items |

**Return:**

!> This API may fail for some reasons, and specific failure reasons may be provided in the return values.

| Parameter | Meaning            | Type     | Example          | Required | Notes                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Result code        | a number | 0                | Yes      | 0 - Successful usage<br/>1 - Database exception<br/>2 - Insufficient experience points restriction<br/>3 - Item not found<br/>4 - Running countdown conflict<br/>5 - Insufficient inventory |
| desc      | Result description | Text     | RunningCountDown | Yes      |                                                              |

<br/>

### ATM

**⚠ Only available in v1.91+**

> The deposit and withdrawal operations here will be verified.
>
> If you need to adjust the ATM balance value directly, you can check the "Shop Settings" interface above.



#### Deposit

**Method name: **deposit

**Description:** The deposit will be checked for legality (whether the coin balance is sufficient).

**Example:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Explanation:** Deposit 500 coins.

| Parameter | Meaning        | Type                    | Example | Required | Notes |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | deposit amount | a number greater than 0 | 100     | yes      | -     |

**Return: **

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | yes      | -     |

<br/>

#### Withdraw

**Method name: **withdraw

**Description:** Withdrawals will be checked for legality (whether the ATM balance is sufficient).

**Example:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Explanation:** Withdraw 500 coins.

| Parameter | Meaning           | Type                    | Example | Required | Notes |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | withdrawal amount | a number greater than 0 | 100     | yes      | -     |

**Return: **

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Whether the operation was successful | `true` or `false` | true    | yes      | -     |

<br/>

### Add Pomodoro Record

**Method name:** add_pomodoro

**Description:** Add tomato timing record

**Example:**

- Add a timing record with a duration of 25 minutes (1500000 ms) and point to a task whose name contains learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Add timing record for `2022-08-01 11:00:00` - `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Explanation:**

| Parameter        | Meaning                    | Type                    | Example       | Required | Notes |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | timing start time          | timestamp               | 1659322800000 | no*      | If you know nothing about Timestamp, google it! |
| duration         | focus duration             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | no* | |
| end_time         | timing end time            | timestamp               | 1659326400000 | no*      |       |
| reward_tomatoes  | whether to reward tomatoes | true or false           | true          | no       | default is false |
| task_id          | task id                    | a number greater than 0 | coin          | no       |       |
| task_gid         | task group id              | a number greater than 0 | remarks       | no       |       |
| task_name        | name                       | any text                | 10            | no       | fuzzy search, only one of the tasks found |

**Notice:**

1. One of start_time, duration, end_time must be provided.
2. In the case of only duration, the default end_time is the current time.
3. end_time needs to be greater than start_time.
4. duration is at least 30000 milliseconds (30 seconds).
5. If both start_time, duration, end_time are provided, duration should be less than or equal to (end_time - start_time).

<br/>

### Unlock Achievement Conditions

**Method name:** unlock_condition

**Description:** Unlock achievement condition: requires an external API call to unlock

**Example:**

- Call the unlock condition with unlock id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Meaning      | Type                  | Example | Required | Notes |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | condition id | number greater than 0 | 2       | yes      |       |

<br/>

### Set the number of steps

**Method name:** step

**Description:** Set the number of steps on the specified date, for example, it can be used to enter the number of steps with a wristband + automation tool. And can be used to modify historical records.

**Example:**

- Adjust the number of steps for 2022-10-21 in GMT+8 time zone to 9999 steps: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parameter | Meaning                         | Type                                | Example       | Required | Notes |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | number of steps                 | a number greater than or equal to 0 | 9999          | yes      |       |
| time      | arbitrary timestamp of the date | timestamp (ms)                      | 1666282995643 | yes      |       |

<br/>

### Edit Experience

?> This API was introduced in version v1.93.0-beta01 (502).

**Method name:** edit_exp

**Description:** This API can batch set the current experience values for attributes. It can directly set a specific experience value or a particular level.

**Example:**

> This API affects data, and to prevent accidental usage, direct clickable links are not provided here.

- Reset the experience values for the attributes [Strength] and [Knowledge] to 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Directly adjust the experience value for [Charm] to level 50: lifeup://api/edit_exp?skills=3&level=50

| Parameter | Meaning              | Type                                      | Example | Required | Notes |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | Attribute (Skill) ID | Array of numbers greater than 0           | 1       | No       | Supports arrays (i.e., &skills=1&skills=2&skills=3)<br/>For obtaining the attribute ID, please refer to the "Basic Knowledge - LifeUp Data ID" section |
| exp       | Set experience value | Number greater than or equal to 0 (int32) | 9999    | No, but either exp or level must be provided |                                                               |
| level     | Set level            | Number greater than or equal to 0 (int32) | 50      | No, but either exp or level must be provided | Represents the starting experience value for a particular level<br/>and will be affected by custom level gradients. |

<br/>

### Add or edit Feelings

?> This API is available as of version v1.93.4 (536).

**Method name:** feeling

**Description:** It is used to create or update records of feelings.

**Example:**

> Since this API involves data manipulation, direct clickable links are not provided here.

- Create a new record of feeling: lifeup://feeling?content=Happy&time=1633036800
- Update an existing record of feeling and mark it as a favorite: lifeup://feeling?id=1&is_favorite=true

| Parameter   | Meaning           | Type                   | Example    | Required | Notes                                                        |
| ----------- | ----------------- | ---------------------- | ---------- | -------- | ------------------------------------------------------------ |
| id          | Feeling Record ID | Number greater than 0  | 1          | No       | If provided, the method tries to update a specific record    |
| content     | Content           | Any text               | Happy      | No       | Used for creating a new record or updating the content of an existing one |
| time        | Timestamp         | Unix timestamp         | 1633036800 | No       | The time of the record, defaults to current time             |
| is_favorite | Favorite Flag     | true or false          | true       | No       | Marks the record as a favorite or not                        |
| relate_type | Relation Type     | Number between 0 and 2 | 1          | No       | Specifies the type of relation associated with the record    |
| relate_id   | Related ID        | Number greater than 0  | 2          | No       | Specifies the ID of the related item                         |

**Note:**

1. If the `id` parameter is provided, the method attempts to update the corresponding record of feeling. An exception is thrown if no matching record is found.
2. If `id` is not provided, but `content` is, the method will create a new record of feeling.

<br/>

### Simple Query

!> The functions here are used with automated tools/secondary development. If you need to query a complete list of data, you can refer to our [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) and [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Method name:** query

**Description:** query parameters

**Example:** - Query the current number of coins: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)


| Parameter | Meaning            | Type                                                        | Example | Required                                    | Notes                                                        |
| --------- | ------------------ | ----------------------------------------------------------- | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key       | type of query      | Only one of the following values:<br/>coin<br/>atm<br/>item | coin    | yes                                         | coin - current amount of coins<br/>atm - current ATM balance<br/>item - Item information for the specified `itemId` |
| itemId    | the id of the item | a number greater than 0                                     | 1       | When the key is `item`, it must be provided |                                                              |

**Return Value:**

Only supported since version 1.90.2

When querying coin/atm:

| Parameter | Meaning                             | Type               | Example | Required | Notes |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Numeric value returned by the query | number             | 1000    | yes      |       |

When querying an item: 

| Parameter        | Meaning                         | Type     | Example   | Required | Notes |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | the id of the item              | number   | 1         | yes      |       |
| name             | the name of the item            | any text | Coffee    | yes      |       |
| desc             | description                     | any text |           | no       |       |
| icon             | icon URL                        | any text | icon.webp | no       | If it is a local file, only the file name is returned |
| category_id      | category data id                | number   | 1         | yes      |       |
| stock_number     | shop stock quantity             | number   | -1        | yes      | `-1` represents infinite shop inventory |
| own_number       | the own number in the Inventory | number   | 10        | yes      |       |
| price            | the price                       | number   | 100       | yes      |       |
| order            | sort by                         | number   | 100       | yes      | Weight value when custom sorting |
| disable_purchase | Whether to disable purchase     |          | true      | yes      |       |



<br/>

### Query Attributes

!> The functions here are used with automated tools/secondary development.

**Method name:** query_skill

**Description:** Query the name, level, total experience value of the specified attribute, the experience value required to reach the next level, and the experience value of the current level.

It is possible to use this api to custom your attributes widgets.

**Example:**

- Query strength attribute: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)


| Parameter | Meaning              | Type                    | Example | Required | Notes |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | attribute (skill) id | a number greater than 0 | 1       | yes      | For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |

**Return Value:**

Only supported since version 1.90.6

| Parameter            | Meaning                              | Type   | Example  | Required | Notes |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| name                 | attribute name                       | string | strength | yes      |       |
| level                | level                                | number | 10       | yes      |       |
| total_exp            | total experience points              | number | 10000    | yes      |       |
| until_next_level_exp | EXP required to reach the next level | number | 99       | yes      |       |
| current_level_exp    | Earned EXP above current level       | Number | 1000     | Yes      |       |

<br/>

### Special interface

#### Random

?> This API has not been released yet, please stay tuned. Planned for release in v1.93.0-beta02.

**Method name:** random

**Description:** A simple random interface that can trigger one of multiple APIs at random.

**Example:**

- Equally likely to randomly display `scissors`, `rock`, or `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- 90% probability to display `rock`, 5% probability for `scissors`, and 5% probability for `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parameter | Meaning    | Values                 | Example                                | Required | Notes |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | Random API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Yes      | Supports calling in array form (i.e., multiple api parameters, as seen in the examples above) |
| weight    | Weight     | Numbers greater than 0 | 1                                      | No       | Supports calling in array form.<br/><br/>If weight is not specified, all weights are equal (equal probability).<br/>If weights are specified, they are assigned sequentially: e.g., the first weight corresponds to the first api parameter.<br/><br/>**Please ensure that the number of weight parameters matches the number of api parameters, or it may not take effect.** |

<br/>

#### Confirm Dialog

**Method name:** confirm_dialog

**Description:** A pop-up selection window pops up. You can customize the title, text, positive button, and negative button. Other interfaces can also be called when the button is clicked.

**Example:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Other usage scenarios:
  - Choice of rewards
  - Event branch selection


| Parameter       | Meaning              | Type     | Example  | Required | Notes |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | popup title          | any text | Title    | yes      |       |
| message         | detailed description of the popup window | any text | This is the content of the popup window | no | - |
| positive_text   | positive button text | any text | YES      | no       |       |
| negative_text   | negative button text | any text | NO       | no       |       |
| neutral_text    | neutral button text  | any text | QUESTION | no       |       |
| positive_action | the link response of the positive button | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | It is actually the escaped text of the popup message interface. For escape rules, please refer to `Basic Knowledge - Escape`. |
| negative_action | the link response of the negative button | URL (other interface) | Same as above | no | - |
| neutral_action  | the link response of the neutral button  | URL (other interface) | Same as above | no | - |
| cancel_action   | the link response of the cancel action   | URL (other interface) | Same as above | no | - |

<br/>


#### No Action

**Method name:** placeholder

**Note:** This interface itself does not handle any logic, but you can use it with callback and broadcast.

**Example:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Variable Placeholder

`LifeUp` provides user intervention processing methods for parameters.

| Placeholder       | Meaning          | Example |
| ----------------- | ---------------- | ------- |
| [$text\|title]    | text placeholder | [$text\|Enter task name] |
| [$number\|Title]  | Number placeholder (without decimal point) | [$number\|Enter price] |
| [$decimal\|title] | Number placeholder (with decimal point) | [$decimal\|Enter ATM rate] |
| [$item]           | Select an item, it will be replaced with item id | [$item] |
| [$task_category]  | Select task list, which will be replaced with task list id | [$task_category] |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Time Placeholder (Supported from v1.93.0-beta01 (502) + only) <br/><br/>Possible values for Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset in milliseconds should be an integer, default is 0 milliseconds | Midnight today: [$time\|today]<br/>Midnight tomorrow: [$time\|today\|8600000] |

**Example 1: When using, select an item to reduce the price by 1 coin**

For instance, after setting the API for price reduction of a specific shop item, you may want to allow the user to select the specified item when calling instead of preset the id.

The following API can only reduce the price of the shop item with id 1 by 1 coin:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

You only need to modify the item id to a placeholder [$item], and when the call is made, the user can actively select the item that they want to reduce the price:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Example 2: Task template, just enter the task name and selection list to create a pre-set reward template**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>


<br/>

#### End Callback

You can add the callback parameter to all interfaces to implement the processing of calling back the URL after the call.

This can also be used to splice multiple interfaces, for example, if you want to implement a prompt after the jump:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

You can use the callback parameter. Please also refer to the above **Basics - Escaping**. You can write this kind of processing:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>



Of course, you can add multiple links to a shop item to achieve this effect.



Besides, this callback is more used for:

X application -> LifeUp -> X application

or

X application -> LifeUp -> Y application

<br/>

#### Broadcast return value

!> The functions here are used with automated tools/secondary development, and there are certain thresholds.

By adding this parameter, the original return value of the API can also be sent by broadcasting. so that automated tools such as Tasker can receive it.

The value of broadcast is equivalent to the value of the operation column of "Intentions Received" in Tasker. You can fill in any text, as long as the two correspond.

**For example, using the API for querying gold coins with Tasker ([If you're using MacroDroid, please check this link.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Add the broadcast parameter to enable it to broadcast the return value to the Tasker, which can be any text, such as `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Add event in Tasker -> "Intent Received", fill in "app.lifeup.query.coin" in the action column

3. The task in Tasker can then receive the return value of `value` in the form of a `%value` variable.

4. Then you can judge the number of gold coins in Tasker to achieve various effects. (For example, change the desktop wallpaper according to the number of gold coins?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Broadcast Event Notification

!> The functions here are used with automated tools/secondary development.

> In version 1.90.2, we will broadcast various events to the outside world. You can use automation tools such as Tasker to receive these events to trigger Tasker actions.
### Enable

**By default, broadcast events are turned off.**

You can enable it in `Settings`-`Labs`-`Developer mode`-`Broadcast events`.

### Example: Change wallpaper with an item

1. Create a new item called "Change Wallpaper".
2. In Tasker, go to `Configuration file`->`Event`->`System`->`Intent Received`, enter `app.lifeup.item.use` in the operation column, and return.
3. Click New Task and enter any name (for example, change wallpaper).
4. Click the + sign in the lower right corner to add a task, select `Task`->`If`
5. Adjust the condition column to `%name eq change wallpaper`.
6. Go back, `Insert Action` select `If`.
7. Click the + sign in the lower right corner again to add a task, select `Display` -> `Set Wallpaper`
8. (Optional) Replace `Type` with `All`
9. In the image column, click the 🔍 icon and select the wallpaper file you want
10. Exit and check if this configuration is enabled.
11. Use the "Wallpaper Change" item in `LifeUp`, you should be able to see the wallpaper change successfully

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Using `No Action`+`Broadcast return value` can achieve this effect in a more concise way, you can explore it.

<br/>

### Task completed

**Name:** app.lifeup.task.complete

**Return value:**

| Parameters | Meaning       | Examples        |
| ---------- | ------------- | --------------- |
| task_id    | task id       | 1               |
| task_gid   | task group id | 1               |
| name       | task name     | Getting started |

### Task given up

**Name:** app.lifeup.task.giveup

**Return value:**

| Parameters | Meaning       | Examples        |
| ---------- | ------------- | --------------- |
| task_id    | task id       | 1               |
| task_gid   | task group id | 1               |
| name       | task name     | Getting started |

### Task overdue

**Name:** app.lifeup.task.overdue

**Return value:**


| Parameters | Meaning                 | Examples                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | task id **array**       | [1, 2, 3]                       |
| task_gids  | task group id **array** | [1, 2, 3]                       |
| names      | task name **array**     | [Getting started, Drink Waters] |


### Achivement unlocked

**Name:** app.lifeup.achievement.unlock

**Return value:**

| Parameters     | Meaning          | Examples                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | achievement id   | 1                        |
| name           | achievement name | Using LifeUp for 30 days |

### Items purchased

**Name:** app.lifeup.item.purchase

**Return value:**

| Parameters | Meaning           | Examples          |
| ---------- | ----------------- | ----------------- |
| item_id    | item id           | 1                 |
| name       | item name         | Break 10 branches |
| amount     | purchase quantity | 1                 |

### Item used

**Name:** app.lifeup.item.use

**Return value:**

| Parameters | Meaning      | Examples          |
| ---------- | ------------ | ----------------- |
| item_id    | item id      | 1                 |
| name       | item name    | Break 10 branches |
| amount     | use quantity | 1                 |

### Level up

**Name:** app.lifeup.level.up

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### Level down

**Name:** app.lifeup.level.down

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | name          | strength |
| level      | current level | 2        |

### Shop item countdown

**Name:** 

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**Return value:**

| Parameters | Meaning                       | Examples                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | item id                       | 1                         |
| name       | item name                     | play games for 30 minutes |
| time_left  | time remaining (milliseconds) | 30000                     |







## Integration

We very much welcome any form of integration from other developers.

> More details will be provided soon...

### Need more APIs?

The API functionality is currently only in one version iteration.

In the future, we will continue to add more APIs to meet more usage scenarios.

If you need more APIs, you can leave Issues on [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>


### How to call

#### Android

##### Using the SDK

Please refer to the `core` module at: https://github.com/Ayagikei/LifeUp-SDK.

##### Without Using the SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Web page

If the webpage is called, whether it can be triggered depends on the browser. Regular browsers such as Quark, Chrome, and Edge are fine. But some other built-in browsers in the system may remind the user "whether to open Rensheng" every time it pops up.

If you are developing your own embedded WebView application, you must ensure that the WebView can handle the lifeup scheme.

To ensure a consistent experience, you can use the product link effect in `LifeUp` and check "Use built-in browser" to open it. But due to security settings, this way only supports HTTPS links (not HTTP)

**HTML**

Jump directly to the hyperlink

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

In fact, it is also called a hyperlink

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Application/Web/Automation Developer
Let us know if you've developed anything related to LifeUp!

<br/>

### Any programming language/platform that supports the HTTP protocol

For details, please refer to https://github.com/Ayagikei/LifeUp-SDK and [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).


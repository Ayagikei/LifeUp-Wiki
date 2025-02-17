<h1 align="center" padding="100">Open interface</h1>

<p align="center">Create endless possibilities! </p>





?> In the v1.90 version, `LifeUp` has opened a variety of functional interfaces, and any external application integration is welcome. <br/>It also provides the “URL” effect for shop items, and users can directly use commodities to call external applications or the interface of `LifeUp`. <br/>These features can give your `LifeUp` unlimited possibilities, but it also requires a little learning understanding and hands-on ability.



**Updated on 2024/04/23**

The API parameters and definitions in this document are based on version v1.94.0.

It is recommended to upgrade your application to version v1.94.0 before using the API.

If you have not received the update, please wait for it to be pushed through Google Play.



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



**The LifeUp 1.90.2 update will add a series of "events", but these events can be received by automated tools or external applications.**

Can be used to achieve:

After using the item, trigger automated tools such as Tasker to switch the launcher wallpaper.

After completing the task, trigger an automated tool such as Tasker to open an app.

**In the 1.90.2 version, it is possible to realize the "LifeUp event" triggering "Tasker's operation".**

Tasker has extremely high permissions, which can be used to change wallpapers, uninstall apps, increase volume, choose to open specified apps, and more. You can even write UI interaction logic without programming foundation.


---

## Recommendations

**If you are not familiar with programming,** you can search and import special shop items directly in the [World] - [Market] - [Link]/[API]/[Automate] tag. You can also try to edit parameters to meet your needs.

**If you are familiar with computer knowledge,** you can try to read the following interface documentation and edit the desired effect yourself. And use it with automation software such as [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Even if you don't edit Tasker's configuration, as long as you can successfully install Tasker, you can import automated configurations shared by others in Market or other communities.

**If you have a programming foundation,** you can try to develop web pages or Android applications to make them integrated with LifeUp. This web page and customized versions of Wordle are some examples. You are also welcome to make and share automation tool configurations.

---

## Call other application

If you want to call an external application in *LifeUp*, you only need to add a "Link" effect to the shop item, **enter a web page or application-specific link**, and then use the shop item to trigger the call.



**The following are some examples (you can also go to "World"-"Market"-"Link" to view public items with interface call effects):**

- Browser to open Google: https://www.google.com
- Facebook: [fb://](fb://)
- Open an app using its package name/app ID: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...



Theoretically, as long as the external APP provides the URL, you can jump by using the shop item.

**You can search for the application link you need by searching `URL Schemes` on Google.**

**These links have nothing to do with `LifeUp`, `LifeUp` only provides the jump URL function.**

**Therefore we do not and do not maintain a list of URLs. But you can view the public shop items containing the link effect on the [World]-[Market]-[Link] page.**

You can find an app's package name (aka ID):

- in its Play Store URL: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- by using an app manager app
- by using the App Info action in Tasker
- by using the Launch App action in Macrodroid



---

## Call LifeUp APIs

If you:

- Need to call the `LifeUp` interface in `LifeUp`. You only need to add a "link" effect to the shop item, input **a specific URL** according to the APIs documents, and then use the shop item to complete the call.
- Calling through the web page, you only need to jump to the LifeUp APIs by hyperlink.
- To call through the APP developed by yourself, you only need to use the Intent to jump to the corresponding interface link.
- Called by an automated tool (such as Tasker), fill in the corresponding API link in Tasker's Browser URL.



**Some examples:**

When you click the link below, "LifeUp" will prompt "You have learned to call APIs!".

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

**This is a simple coding tool implemented in Javascript:**

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

### Basics - JSON Data Structure

?> Requires v1.98.0+

This section introduces the commonly used JSON data structures in the API.

#### 1. Item Reward Structure

A JSON array specifying item rewards, each item containing an ID and quantity.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Achievement Unlock Condition Structure

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Purchase Limit Structure

```json
[
    {
        "type": "daily",     // Limit type: daily (daily), total (total)
        "value": 5           // Limit quantity
    }
]
```

#### 4. Item Effect Structure

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Effect Type Description

| Type Code | Meaning | Parameter Description |
| ------- | ---- | ------- |
| 0 | No special effect | No parameters |
| 1 | Not usable | No parameters |
| 2 | Increase gold | min: Minimum gold amount<br/>max: Maximum gold amount (optional, if not filled, it equals min) |
| 3 | Decrease gold | min: Minimum gold amount<br/>max: Maximum gold amount (optional, if not filled, it equals min) |
| 4 | Increase experience | ids: Skill ID array<br/>value: Experience value<br/>using_limit: Whether to use limit (optional, default false) |
| 5 | Decrease experience | ids: Skill ID array<br/>value: Experience value<br/>using_limit: Whether to use limit (optional, default false) |
| 6 | Simple synthesis | require_number: Required quantity<br/>item_id: Item ID |
| 7 | Open box | items: Item array, each item contains:<br/>- item_id: Item ID<br/>- amount: Quantity<br/>- probability: Probability<br/>- is_fixed_reward: Whether it is a fixed reward |
| 8 | Countdown | seconds: Countdown seconds |
| 9 | Web link | url: Link address<br/>use_web_view: Whether to use the built-in browser (optional, default false) |

**Effect Example:**

Increase random gold:
```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Increase experience points:
```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Open box effect:
```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

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

- Penalize 1 fuzzy matching "treasure" item for "sleep in". And the reason will be displayed on the inventory history page:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

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


### Tasks

#### Add a Task

?> Some fields like `pin` requires v1.98.0+

**Method:** add_task

**Description:** Create a task directly

**Example:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parameter         | Meaning             | Values                | Example   | Required | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Task content        | any text             | Write diary | Yes     |                                |
| notes            | Notes               | any text             | Notes      | No       | Defaults to empty               |
| coin             | Coin reward         | [0, 999999]         | 10         | No       | Defaults to 0                   |
| coin_var         | Coin reward variance| number >= 0          | 1          | No       | Defaults to 0; if >0, random reward between [coin, coin+coin_var] |
| exp              | Experience reward   | [0, 99999]          | 100        | No       | Defaults to 0                   |
| skills           | Skill IDs           | array of numbers > 0 | 1          | No       | Supports arrays (e.g., &skills=1&skills=2) |
| category         | List ID             | number >= 0          | 0          | No       | Defaults to 0 (default list); smart lists not allowed |
| frequency        | Repeat frequency    | integer              | 0          | No       | Defaults to 0 (once)<br/>0 - Once<br/>1 - Daily<br/>N (N>1) - Every N days<br/>-1 - Unlimited<br/>-4 - Monthly<br/>-5 - Yearly |
| importance       | Importance level    | [1, 4]              | 1          | No       | Defaults to 1                   |
| difficulty       | Difficulty level    | [1, 4]              | 1          | No       | Defaults to 1                   |
| deadline         | Due time            | timestamp (milliseconds) | 1640995200000 | No |                               |
| color            | Tag color           | color string         | #66CCFF    | No       | # must be escaped as %23        |
| background_url   | Background image URL| web URL             | http://example.com/bg.jpg | No | Must be accessible web image |
| background_alpha | Background opacity  | float between [0, 1] | 0.5        | No       | Defaults to 1.0                |
| start_time       | Start time          | timestamp (milliseconds) | 1640995200000 | No | Task start time              |
| auto_use_item    | Auto use reward items| true or false      | false      | No       | Automatically use rewards on completion |
| remind_time      | Reminder time       | timestamp (milliseconds) | 1640995200000 | No | Task reminder time          |
| pin              | Pin task            | true or false       | false      | No       | Pin task to top                |
| frozen           | Freeze status       | true or false       | false      | No       | Defaults to false              |
| freeze_until     | Freeze until        | timestamp (milliseconds) | 1640995200000 | No | Only effective when frozen is true |
| coin_penalty_factor | Coin penalty factor| float between [0, 100) | 0.5    | No       |                               |
| exp_penalty_factor | Experience penalty factor| float between [0, 100) | 0.5 | No    |                               |
| write_feelings   | Enable feelings     | true or false       | false      | No       | Defaults to false              |
| item_id          | Item ID             | number > 0          | 1          | No*      | Either item_id or item_name required |
| item_name        | Item name           | any text            | Treasure   | No*      | Either item_id or item_name required |
| item_amount      | Item quantity       | [1, 99]             | 1          | No       | Defaults to 1                  |
| items            | Item rewards        | JSON text           | See [Item Rewards Structure](#1-item-rewards-structure) | No | Set multiple item rewards |

**Response:**

| Field    | Type    | Description      | Example | Notes                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | Task ID          | 1000    |                          |
| task_gid | Number  | Task group ID    | 1000    |                          |

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
| count                    | Count value                        | Number                                                 | 1         | No       | Only applicable to count tasks, please use in conjunction with the `count_set_type` parameter     |
| count_set_type           | How to set the count value         | One of the following:<br/>absolute<br/>relative        | absolute  | No       | Default is relative<br/>absolute - Set the target to the value directly<br/>relative - Add or subtract based on the original value |
| count_force_sum_up       | Force tally of count task rewards  | true or false                                          | true      | No       |                                                                                                    |
| reward_factor            | Reward factor                      | Floating point number greater than 0                   | 1.1       | No       | Not applicable to count tasks<br/>Reward factor affects the amount of experience and coins (not the quantity of goods) |

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

### Edit Task

?> Requires v1.98.0+

**Method:** edit_task

**Description:** Edit content and properties of an existing task

**Example:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parameter           | Meaning              | Values                | Example   | Required | Notes                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | Task ID              | number greater than 0 | 1        | No*      | One of id, gid, or name required |
| gid                | Task group ID        | number greater than 0 | 1        | No*      | One of id, gid, or name required |
| name               | Task name            | any text             | Write diary| No*      | One of id, gid, or name required |
| todo               | Task content         | any text             | Write weekly| No      |                                |
| notes              | Notes                | any text             | Note content| No      |                                |
| coin               | Coin reward          | [0, 999999]         | 10        | No       | Coins earned upon completion    |
| coin_var           | Coin variance        | number greater than 0 | 1        | No       | Random reward between [coin, coin+coin_var] |
| exp                | Experience reward    | [0, 99999]          | 20        | No       | Experience points earned        |
| skills             | Skill IDs            | array of numbers greater than 0 | 1 | No    | Supports arrays (e.g., &skills=1&skills=2) |
| category           | List ID              | number greater than or equal to 0 | 0 | No  | 0 for default list, smart lists not supported |
| frequency          | Repeat frequency     | integer              | 0         | No       | -1 - Unlimited<br/>-3 - Ebbinghaus<br/>-4 - Monthly<br/>-5 - Yearly |
| importance         | Importance level     | [1, 4]              | 1         | No       | Defaults to 1                   |
| difficulty         | Difficulty level     | [1, 4]              | 2         | No       | Defaults to 1                   |
| deadline           | Due date             | timestamp (milliseconds) | 1640995200000 | No |                               |
| remind_time        | Reminder time        | timestamp (milliseconds) | 1640995200000 | No |                               |
| start_time         | Start time           | timestamp (milliseconds) | 1640995200000 | No |                               |
| color              | Tag color            | color string         | #66CCFF   | No       | # must be escaped as %23        |
| background_url     | Background image URL | web URL address      | http://example.com/bg.jpg | No |                         |
| background_alpha   | Background opacity   | floating point between [0, 1] | 0.5 | No   |                                |
| item_id            | Item ID              | number greater than 0 | 1        | No*      | One of item_id or item_name required |
| item_name          | Item name            | any text             | Treasure  | No*      | One of item_id or item_name required |
| item_amount        | Item amount          | [1, 99]             | 1         | No       | Defaults to 1                   |
| items              | Items reward JSON    | JSON text           | [{"itemId":1,"amount":1}] | No | Set multiple item rewards |
| auto_use_item      | Auto use item        | true or false        | false     | No       |                                |
| frozen             | Freeze status        | true or false        | false     | No       | Defaults to false              |
| freeze_until       | Freeze until         | timestamp (milliseconds) | 1640995200000 | No | Only effective when frozen is true |
| coin_penalty_factor| Coin penalty factor  | floating point between [0, 100) | 0.5 | No |                                |
| exp_penalty_factor | Experience penalty factor | floating point between [0, 100) | 0.5 | No |                             |
| write_feelings     | Enable feelings      | true or false        | false     | No       |                                |
| pin                | Pin task             | true or false        | false     | No       |                                |

**Response:**

| Field     | Type    | Description      | Example | Notes             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | Task ID          | 1000    |                  |
| task_gid  | Number  | Task group ID    | 1000    |                  |

<br/>

### History Task Operation

?> Requires v1.98.0+

**Method:** history_operation

**Description:** Operate on completed/abandoned/expired tasks

**Examples:**
- Delete history task: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Mark task as given up: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Restart task: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> This API is only applicable to non-uncompleted tasks (completed, given up, or expired)

| Parameter      | Meaning           | Values               | Example    | Required | Notes                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | Task ID           | number greater than 0 | 1         | Yes      | ID of the history task          |
| operation     | Operation type    | One of:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Yes | delete - Delete task<br/>complete - Mark as completed<br/>undo_complete - Undo completion<br/>set_to_give_up - Mark as given up<br/>set_to_overdue - Mark as expired<br/>edit_completed_time - Modify completion time<br/>restart - Restart task |
| completed_time | Completion time   | timestamp (milliseconds) | 1640995200000 | No* | Required only when operation is edit_completed_time |

**Response:**

| Field    | Type    | Description    | Example | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | Task ID        | 1000    | ID of the operated task  |

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
| page | page | One of the following values:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>use_item_dialog | lab | yes | `purchase_dialog` refers to the purchase popup<br/> `use_item_dialog` refers to the use item popup<br/>Other entries refer to specific major pages |

#### 1. Jump to the item purchase/use pop-up window

When the `page` parameter is set to `purchase_dialog` or `use_item_dialog`, you can specify the item ID:

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

#### Adding Items

?> Some fields like `effects` requires v1.98.0+

**Method name:** add_item

**Description:** Create a shop item with customizable properties including purchase limits and use effects.

**Example:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest)

| Parameter        | Meaning                | Values               | Example       | Required | Notes                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Item name             | any text             | 10 minute break | Yes    |                                 |
| desc            | Description           | any text             | Take a break  | No       |                                 |
| icon            | Icon                  | URL text             | http://...    | No       | Must be a web URL               |
| price           | Price                 | [0, 999999]         | 10            | No       | Default is 0                    |
| stock_number    | Stock quantity        | [-1, 99999]         | -1            | No       | -1 means unlimited              |
| action_text     | Action button text    | any text             | rest          | No       |                                 |
| disable_purchase| Disable purchase      | true or false        | false         | No       | Default is false                |
| disable_use     | Disable use           | true or false        | false         | No       | Default is false                |
| category        | Category ID           | number greater than or equal to 0 | 0 | No    | 0 for default category          |
| order           | Display order         | integer              | 1             | No       | Position in category            |
| purchase_limit  | Purchase limits       | JSON text            | See [Purchase Limit Structure](#3-purchase-limit-structure) | No | Limit purchase frequency |
| effects         | Use effects           | JSON text            | See [Item Effects Structure](#4-item-effects-structure) | No | Item usage effects |
| own_number      | Initial owned quantity | integer             | 0             | No       | Set initial inventory quantity  |
| unlist          | Hide from shop        | true or false        | false         | No       | Default is false                |

**Return Data:**

| Field    | Type    | Description    | Example | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | Item ID        | 1000    | ID of the created item   |

!> The effects parameter will override disable_use. If you set effects to indicate an unusable item, disable_use will be ignored.

<br/>


#### Edit Item

?> Requires v1.98.0+

**Method:** item

**Description:** Modify existing items, including price, stock, effects, and other properties

**Examples:**
- Adjust price: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Modify effects: [lifeup://api/item?id=1&effects=[{"type":2,"info":{"min":100,"max":200}}]](lifeup://api/item?id=1&effects=[{"type":2,"info":{"min":100,"max":200}}])

| Parameter         | Meaning             | Values               | Example   | Required | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | Item ID             | number greater than 0| 1         | No*      | Either id or name required      |
| name             | Item name           | any text             | Treasure  | No*      | For fuzzy search, not renaming  |
| set_name         | Set name            | any text             | Treasure  | No       | Cannot be empty                 |
| set_desc         | Set description     | any text             | Get gift  | No       |                                |
| set_icon         | Set icon            | URL text             | http://...| No       | Must be a web URL               |
| set_price        | Adjust price        | integer              | 1         | No       |                                |
| set_price_type   | Price adjust method | absolute or relative | relative  | No       | absolute-set directly<br/>relative-add/subtract |
| own_number       | Adjust owned quantity| integer             | 1         | No       | Supports negative with relative |
| own_number_type  | Own number adjustment| absolute or relative| relative  | No       | absolute-set directly<br/>relative-add/subtract |
| stock_number     | Adjust stock        | [-1, 99999]         | 1         | No       | -1 means unlimited stock        |
| stock_number_type| Stock adjust method | absolute or relative | relative  | No       | absolute-set directly<br/>relative-add/subtract |
| disable_purchase | Disable purchase    | true or false        | false     | No       | Defaults to false              |
| disable_use      | Disable use         | true or false        | false     | No       | Defaults to false              |
| action_text      | Use button text     | any text             | Use       | No       |                                |
| title_color_string| Title color        | color string         | #66CCFF   | No       | # must be escaped as %23<br/>Empty value restores default |
| effects          | Use effects         | JSON text            | See [Item Effects Structure](#4-item-effects-structure) | No | Set item usage effects |
| purchase_limit   | Purchase limits     | JSON text            | See [Purchase Limit Structure](#3-purchase-limit-structure) | No | Limit purchase frequency |
| category_id      | Category ID         | number >= 0          | 1         | No       | 0 for default category         |
| order            | Display order       | integer              | 1         | No       | Position in category           |
| unlist           | Remove from shop    | true or false        | false     | No       | Defaults to false              |

!> Either id or name parameter must be provided to locate the item to modify

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

### Pomodoro Record

#### Add Pomodoro Record

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

#### Edit Pomodoro Record

> Introduced in v1.94.0
> **Method name:** edit_pomodoro

**Description:** Edit an existing Pomodoro timing record or add a new record if a valid `edit_item_id` is provided.

**Example:**

- Edit a record with a specified ID, set duration to 45 minutes (2700000 ms), and reward tomatoes: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Edit a record by start and end time: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parameters:**

| Parameter       | Meaning                    | Type                  | Example       | Required | Notes                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | Task ID                    | Number greater than 0 | 101           | No       | Unique identifier for the task                   |
| task_gid        | Task group ID              | Number greater than 0 | 5             | No       | If provided, it overrides task_id                |
| task_name       | Task name                  | Any text              | Study         | No       | Must be provided if task_id or task_gid is not   |
| start_time      | Timing start time          | Timestamp             | 1659322800000 | No*      | Can Google to understand what a timestamp is     |
| end_time        | Timing end time            | Timestamp             | 1659326400000 | No*      | -                                                |
| duration        | Focus duration             | Number (milliseconds) | 2700000       | No*      | Must be at least 30000 milliseconds (30 seconds) |
| reward_tomatoes | Whether to reward tomatoes | true or false         | true          | No       | Default is false                                 |
| edit_item_id    | ID of the item to edit     | Number greater than 0 | 123           | Yes      | Specifies the record ID to edit                  |
| ui              | Display reward tomatoes UI | true or false         | true          | No       |                                                  |

**Return values:**

| Parameter | Meaning                          | Type   | Example | Required | Notes                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomatoes gained from this action | Number | 2       | No       | Returned if `ui` is true |

**Notes:**

1. At least one of `start_time`, `duration`, `end_time` must be provided.
2. `end_time` needs to be greater than `start_time`.
3. `duration` should be less than or equal to (`end_time` - `start_time`).
4. If `edit_item_id` is provided and the corresponding record is found, it will be edited; otherwise, a new record will be created based on other parameters.

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

- Create a new record of feeling: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Update an existing record of feeling and mark it as a favorite: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)

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

### Tomato Count

?> Requires v1.98.0+

**Method:** tomato

**Description:** Adjust the number of tomatoes (increase, decrease, or set to a specific amount)

**Examples:**
- Add 1 tomato: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Remove 2 tomatoes: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Set pomodoro count to 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parameter | Meaning        | Values                                        | Example   | Required | Notes                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Operation type | One of:<br/>increase<br/>decrease<br/>set     | increase  | No       | increase - Add pomodoros (default)<br/>decrease - Remove pomodoros<br/>set - Set pomodoro count to specified value |
| number    | Amount         | Integer                                       | 1         | Yes      | Different meanings based on action:<br/>increase/decrease - Amount to add/remove<br/>set - Target amount to set |

**Response:**

| Field    | Type    | Description              | Example |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Current pomodoro count   | 10      |

<br/>

### Synthesis

?> Requires v1.98.0+

**Method:** synthesize

**Description:** Synthesize items using an existing formula

**Examples:**
- Synthesize once using formula ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Synthesize 5 times using formula ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

| Parameter | Meaning            | Values                | Example | Required | Notes                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formula ID        | number greater than 0 | 1       | Yes      | ID of synthesis formula  |
| times     | Number of times   | number greater than 0 | 5       | No       | Defaults to 1           |

**Response:**

| Field           | Type    | Description     | Example          | Notes                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formula ID      | 1                |                          |
| result         | Integer | Result code     | 0                | See result codes below   |
| desc           | Text    | Result description | SynthesisSuccess | See result codes below |
| synthesisResults| Text   | Synthesis results | {...}           | Only returned on success |

**Result Codes:**

| Code | Description          | Notes                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Synthesis successful  |
| 1    | FormulaNotFound     | Formula not found     |
| 2    | InsufficientMaterials| Not enough materials |
| 3    | DatabaseError       | Database error        |
| 4    | UnknownError        | Other errors         |

<br/>

### Synthesis Formula Management

?> Requires v1.98.0+

**Method:** synthesis_formula

**Description:** Create, modify, or delete synthesis formulas

**Examples:**
- Create a new formula: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
    - Here, the inputItems are `[{"item_id": 296, "amount": 88}]`
    - Here, the outputItems are `[{"item_id": 295, "amount": 1}]`
- Delete formula: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parameter   | Meaning        | Values                | Example                        | Required | Notes                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formula ID     | number greater than 0 | 1                             | No       | Required for modify or delete  |
| delete      | Delete flag    | true or false        | true                          | No       | Used only for deletion         |
| inputItems  | Input items    | Item array, see below | [{"item_id":1,"amount":2}]     | Yes      | Required for create or modify  |
| outputItems | Output items   | Item array, see below | [{"item_id":3,"amount":1}]     | Yes      | Required for create or modify  |
| category    | Category ID    | number greater than 0 | 1                             | No       | Defaults to common category    |

!> inputItems and outputItems are JSON arrays where each item contains item_id and amount fields. All item IDs must exist and amounts must be greater than 0

**Response:**

| Field     | Type    | Description      | Example     | Notes                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formula ID       | 1           | Returned on success      |
| result    | Integer | Result code      | 0           | See result codes below   |
| desc      | Text    | Result description | AddSuccess | See result codes below   |

**Result Codes:**

| Code | Description     | Notes             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operation success |
| 1    | Failed         | Operation failed  |

<br/>

### Subtask Management

?> Requires v1.98.0+

**Method:** subtask

**Description:** Create or edit subtasks

**Examples:**
- Add a subtask to main task ID 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Edit subtask and set rewards: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parameter     | Meaning            | Values                | Example    | Required | Notes                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | Main task ID       | number greater than 0 | 1         | No*      | One of main_id, main_gid, or main_name required |
| main_gid     | Main task group ID | number greater than 0 | 1         | No*      | One of main_id, main_gid, or main_name required |
| main_name    | Main task name     | any text             | Study task | No*      | One of main_id, main_gid, or main_name required |
| edit_id      | Subtask ID to edit | number greater than 0 | 2         | No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| edit_gid     | Subtask group ID   | number greater than 0 | 2         | No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| edit_name    | Subtask name       | any text             | Do homework| No*      | One of edit_id, edit_gid, or edit_name required when editing; not needed for creation |
| todo         | Task content       | any text             | Do homework| No       | Required when creating new subtask |
| remind_time  | Reminder time      | timestamp (milliseconds)| 1640995200000 | No | Pass null to clear reminder    |
| order        | Order              | integer              | 1          | No       | Position in task list           |
| coin         | Coin reward        | [0, 999999]         | 10         | No       | Coins earned upon completion    |
| coin_var     | Coin variance      | integer              | 5          | No       | Random variance in coin reward  |
| exp          | Experience reward  | [0, 99999]          | 5          | No       | Experience points earned        |
| auto_use_item| Auto use item      | true or false        | true       | No       | Whether to use item automatically on completion |
| item_id      | Item ID            | number greater than 0 | 1         | No*      | One of item_id or item_name required |
| item_name    | Item name          | any text             | Health Potion| No*    | One of item_id or item_name required |
| item_amount  | Item amount        | number greater than 0 | 1         | No       | Only valid when setting item reward |
| items        | Items JSON         | JSON text            | [{"item_id":1,"amount":1}] | No | Set multiple item rewards at once |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | May be empty     |

<br/>


### Category Management

?> Requires v1.98.0+

**Method:** category

**Description:** Add or edit categories (task lists, achievement lists, shop lists, synthesis lists)

**Examples:**
- Create a task list: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Edit a shop list: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parameter        | Meaning           | Values               | Example    | Required | Notes                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Category type     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Yes | tasks - Task lists<br/>achievements - Achievement lists<br/>shop - Shop lists<br/>synthesis - Synthesis lists |
| edit_id         | Category ID to edit| number greater than 0| 1         | No       | Required when editing           |
| name            | Category name     | any text             | Study List | No       | Required for new categories; optional when editing |
| order           | Sort order        | integer              | 1         | No       | Position in the list            |
| hidden          | Hide category     | true or false        | false     | No       | Only supported for task and shop lists |
| inventory_hidden| Hide in inventory | true or false        | false     | No       | Only supported for shop lists   |
| icon_uri        | Icon URI          | URI text             | content://... | No  | Only supported for achievement lists |
| desc            | Description       | any text             | This is a description | No | Only supported for achievement lists |
| color           | Tag color         | color string         | #66CCFF   | No       | Only supported for task lists; # must be escaped as %23 |

**Response:**

| Field | Type    | Description    | Example | Notes                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Category ID    | 1000    | ID of new or edited category |

<br/>


### Export Backup

?> Requires v1.98.0+

**Method:** export_backup

**Description:** Create a backup file and return its URI (Content Provider calls only)

!> This API can only be called through Content Provider, direct URL Scheme calls are not supported

| Parameter      | Meaning        | Values          | Example | Required | Notes                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Include media files | true or false | true    | No       | Whether to include media files (images, sound effects, etc.) in backup<br/>Defaults to true |
| callingPackage| Caller package name | any text      | com.example.app | No | Package identifier for Content Provider calls |

**Response:**

| Field          | Type   | Description          | Example                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | Backup file URI      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Subtask Operation

?> Requires v1.98.0+

**Method:** subtask_operation

**Description:** Complete, undo completion, or delete subtasks

**Examples:**
- Complete a subtask: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Delete a subtask: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Undo subtask completion: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parameter     | Meaning          | Values               | Example    | Required | Notes                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | Main task ID     | number greater than 0| 1         | No*      | One of main_id, main_gid, or main_name required |
| main_gid     | Main task group ID| number greater than 0| 1        | No*      | One of main_id, main_gid, or main_name required |
| main_name    | Main task name   | any text            | Study task | No*      | One of main_id, main_gid, or main_name required |
| edit_id      | Subtask ID       | number greater than 0| 2         | No*      | One of edit_id, edit_gid, or edit_name required |
| edit_gid     | Subtask group ID | number greater than 0| 2         | No*      | One of edit_id, edit_gid, or edit_name required |
| edit_name    | Subtask name     | any text            | Do homework| No*      | One of edit_id, edit_gid, or edit_name required |
| operation    | Operation type   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Yes | complete - Complete task<br/>undo_complete - Undo completion<br/>delete - Delete task |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | May be empty     |

<br/>

### Achievement Management

?> Requires v1.98.0+

**Method:** achievement

**Description:** Add or edit custom achievements and achievement subcategories

**Examples:**
- Create an achievement: [lifeup://api/achievement?name=Collector&desc=Collect 100 items](lifeup://api/achievement?name=Collector&desc=Collect 100 items)
- Create an achievement with unlock conditions: [lifeup://api/achievement?name=Millionaire&conditions_json=[{"type":7,"target":1000000}]](lifeup://api/achievement?name=Millionaire&conditions_json=[{"type":7,"target":1000000}])
- Edit existing achievement: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Achievement Parameters

| Parameter      | Meaning           | Values               | Example   | Required | Notes                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | Achievement ID to edit | number greater than 0 | 1      | No       | Required when editing          |
| is_subcategory| Is subcategory    | true or false        | false     | No       | Defaults to false               |
| name          | Achievement name   | any text             | Collector | No*      | Required for new achievements   |
| desc          | Description       | any text             | Collect 100 items | No |                               |
| order         | Sort order        | integer              | 1         | No       | Position in list                |
| category_id   | Category ID       | number greater than 0 | 1        | No*      | Required when creating subcategory |
| unlocked      | Unlock status     | true or false        | true      | No       | true - unlock immediately<br/>false - reset to locked |
| unlock_time   | Unlock time       | timestamp (milliseconds) | 1640995200000 | No | Only effective when already unlocked |
| delete        | Delete flag       | true or false        | false     | No       |                                |
| secret        | Hidden achievement| true or false        | false     | No       |                                |
| write_feeling | Record feelings   | true or false        | false     | No       |                                |
| color         | Title color       | color string         | #66CCFF   | No       | # must be escaped as %23        |
| auto_use_item | Auto use item     | true or false        | false     | No       |                                |
| skills        | Skill IDs         | array of numbers greater than 0 | 1 | No    | Supports arrays (e.g., &skills=1&skills=2) |
| exp           | Experience reward | integer              | 100       | No       |                                |
| item_id       | Item ID           | number greater than 0 | 1        | No*      | One of item_id or item_name required |
| item_name     | Item name         | any text             | Treasure  | No*      | One of item_id or item_name required |
| item_amount   | Item quantity     | [1, 99]             | 1         | No       | Defaults to 1                   |
| items         | Item rewards JSON | JSON text            | [{"item_id":1,"amount":2}] | No | Set multiple item rewards, see format below |
| conditions_json| Unlock conditions JSON | JSON text      | [{"type":7,"target":1000000}] | No | Set unlock conditions, see format below |

#### 2. Subcategory Parameters

| Parameter     | Meaning           | Values               | Example   | Required | Notes                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Collapse status   | true or false        | false     | No       | Only applies to subcategories   |

**Response:**

| Field  | Type    | Description      | Example | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID   | 1000    | ID of new or edited achievement |

#### 3. Unlock Condition Types

| Type Code | Description             | Requires related_id | related_id Type | target Description  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Task completion count   | Yes                | Task ID         | Number of completions |
| 1         | Task completion streak  | Yes                | Task ID         | Streak count       |
| 3         | Pomodoro count         | No                 | -               | Number of pomodoros |
| 4         | Days using LifeUp      | No                 | -               | Number of days     |
| 5         | Like count             | No                 | -               | Number of likes    |
| 6         | Daily completion streak | No                 | -               | Streak days        |
| 7         | Current coins          | No                 | -               | Amount of coins    |
| 8         | Coins earned in one day| No                 | -               | Amount of coins    |
| 9         | Task pomodoro count    | Yes                | Task ID         | Number of pomodoros |
| 10        | Item purchase count    | Yes                | Item ID         | Purchase count     |
| 11        | Item usage count       | Yes                | Item ID         | Usage count        |
| 12        | Loot box item count    | Yes                | Item ID         | Obtained count     |
| 13        | Skill level reached    | Yes                | Skill ID        | Level value        |
| 14        | Life level            | No                 | -               | Level value        |
| 15        | Total items obtained   | Yes                | Item ID         | Total obtain count |
| 16        | Items from synthesis   | Yes                | Item ID         | Synthesis count    |
| 17        | Current item quantity  | Yes                | Item ID         | Own count          |
| 18        | Task focus duration    | Yes                | Task ID         | Duration (minutes) |
| 19        | ATM savings           | No                 | -               | Savings amount     |
| 20        | External API          | No                 | -               | API defined        |

#### 4. JSON Format Specifications

##### Unlock Conditions (conditions_json)
```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    }
]
```

##### Item Rewards (items)
```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Skill Management

?> Requires v1.98.0+

**Method:** skill

**Description:** Create or edit custom skills (attributes)

**Examples:**
- Create a skill: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Edit skill experience: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Delete skill: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parameter    | Meaning           | Values               | Example    | Required | Notes                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Skill ID          | number greater than 0 | 1         | No       | Required when editing           |
| content     | Skill name        | any text             | Programming| No*      | Required for new skills         |
| desc        | Description       | any text             | Coding ability | No    |                                |
| icon        | Icon              | any text             | 💻         | No       | Can use emoji                   |
| color       | Color             | color string         | #FF6B6B    | No       | # must be escaped as %23        |
| type        | Type              | integer              | 0          | No       |                                |
| order       | Sort order        | integer              | 1          | No       | Position in list                |
| status      | Status            | integer              | 0          | No       |                                |
| exp         | Experience points | number greater than or equal to 0 | 100 | No | Current skill experience        |
| delete      | Delete flag       | true or false        | false      | No       | Only valid when editing         |

**Response:**

| Field  | Type    | Description    | Example | Notes                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Skill ID       | 1000    | ID of new or edited skill |

<br/>

### App Settings

?> Requires v1.98.0+

**Method:** app_settings

**Description:** Adjust app interface settings

**Examples:**
- Enable compact mode: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Enable Material You theme: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Change settings and restart UI immediately: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parameter              | Meaning           | Values          | Example | Required | Notes                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Enable compact mode| true or false  | true    | No       | Simplify interface elements     |
| is_enable_material_you| Enable Material You| true or false  | true    | No       | Enable Material You theme       |
| restart_activities    | Restart interface | true or false   | true    | No       | Apply interface changes immediately |

**Response:**

| Field  | Type    | Description  | Example | Notes                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Result code  | 0       | 0 indicates success      |

<br/>

### Simple Query

!> The functions here are used with automated tools/secondary development. If you need to query a complete list of data, you can refer to our [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) and [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Method name:** query

**Description:** query parameters

**Example:** - Query the current number of coins: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)


| Parameter   | Meaning              | Type                                                         | Example | Required                                    | Notes                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | type of query        | Only one of the following values:<br/>coin<br/>atm<br/>item<br/>item_id_list | coin    | yes                                         | coin - current amount of coins<br/>atm - current ATM balance<br/>item - Item information for the specified `itemId`<br/>item_id_list - List of item IDs specified by `categoryId` |
| item_id     | the id of the item   | a number greater than 0                                      | 1       | When the key is `item`, it must be provided |                                                              |
| category_id | the Shop category id | Number greater than or equal to 0                            | 0       | no*                                         | Required only when the key is `item_id_list`, representing the ID of the list to be queried. |

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

It is possible to use this api to customize your attributes widgets.

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

?> This API is released in v1.93.0.

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
| message         | detailed description of the popup window | any text | This is the content of the popup window | no |  |
| positive_text   | positive button text | any text | YES      | no       |       |
| negative_text   | negative button text | any text | NO       | no       |       |
| neutral_text    | neutral button text  | any text | QUESTION | no       |       |
| positive_action | the link response of the positive button | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | It is actually the escaped text of the popup message interface. For escape rules, please refer to `Basic Knowledge - Escape`. |
| negative_action | the link response of the negative button | URL (other interface) | Same as above | no |  |
| neutral_action  | the link response of the neutral button  | URL (other interface) | Same as above | no |  |
| cancel_action   | the link response of the cancel action   | URL (other interface) | Same as above | no |  |

<br/>


#### No Action

**Method name:** placeholder

**Note:** This interface itself does not handle any logic, but you can use it with callback and broadcast.

**Example:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Variable Placeholder

`LifeUp` provides user intervention processing methods for parameters.

| Placeholder                          | Meaning                                                      | Example                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Text placeholder                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Number placeholder (without decimal point)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Number placeholder (without decimal point), show sign        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Number placeholder (with decimal point)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Number placeholder (with decimal point), show sign           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Select an item, it will be replaced with item id              | [$item]                                                      |
| [$task_category]                     | Select task list, which will be replaced with task list id    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Time Placeholder (Supported from v1.93.0-beta01 (502) + only) <br/><br/>Possible values for Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset in milliseconds should be an integer, default is 0 milliseconds | Midnight today: [$time\|today]<br/>Midnight tomorrow: [$time\|today\|8600000] |
| [$random_number\|Min\|Max]           | Random number placeholder (without decimal point)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Random number placeholder (with decimal point)                | [$random_decimal\|1.0\|2.0]                                  |

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

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### Task given up

**Name:** app.lifeup.task.giveup

**Return value:**

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | task name        | Getting started |
| category_id | task category id | 1               |

### Task overdue

**Name:** app.lifeup.task.overdue

**Return value:**


| Parameters | Meaning                 | Examples                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | task id **array**       | [1, 2, 3]                       |
| task_gids  | task group id **array** | [1, 2, 3]                       |
| names      | task name **array**     | [Getting started, Drink Waters] |
| task_ids_json  | task id **Json array**   | [1, 2, 3]                       |
| task_gids_json | task group id **Json array** | [1, 2, 3]                       |
| names_json     | task name **Json array** | ["Getting started", "Drink Waters"]                      |


### Achievement unlocked

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


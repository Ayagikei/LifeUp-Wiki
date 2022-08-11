<h1 align="center" padding="100">Open interface</h1>

<p align="center">Create endless possibilities! </p>





?> In the v1.90 version, `LifeUp` has opened a variety of functional interfaces, and any external application integration is welcome. <br/>It also provides the "link" effect of commodities, and users can directly use commodities to call external applications or the interface of "LifeUp". <br/>This can make your `LifeUp` get unlimited possibilities, but it also requires you to have a certain learning understanding and hands-on ability.



## Scenario example

| Caller | Scenario | Notes |
| ----------------------------------------- | ------- -------------------------------------------------- --- | -------- |
|**LifeUp->external application**<br/>The "link" effect of the shop item| After using the shop item:<br/>1. Use a browser to visit a webpage<br/>2. Jump to WeChat and scan Scan, or specify a small program<br/>3. Automatically add accounting records ([such as "Qianji" supports accounting interface](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/ >4. ... (as long as the external application supports this method call) |  |
|**LifeUp->LifeUp**<br/>The "link" effect of the shop item| After using the shop item:<br/>1. Open a certain page of LifeUp<br/>2. Increase the ATM interest rate<br/ >3. Raise the price of a shop item<br/>4. Complete a task<br/>5. Pop up a custom text message<br/>6. Create a task reward template, just enter a name to automatically create a task<br/> br/>7. More in-app operations... |  |
|**External application/webpage->LifeUp** | External application linkage/with automation software/self-developed application:<br/>1. The automated tool judges that it is home, and automatically hits the "go home" card<br/> 2. Reach an untouched place, automatically unlock achievements<br/>3. Complete the goal, swipe the NFC card, automatically punch in the task<br/>4. Capture other focus notification messages, automatically add timing records to the promotion<br/> br/>5. Capture the notification of fitness software, and automatically issue "strength" experience points.<br/>6. When xx conditions are triggered, automatically issue gold coins and commodity rewards<br/>7. ... |  |

---

## Recommendations

**If you are not familiar with basic knowledge of programming or computer,** you can search and import related shop items directly in the [World] -  [Market]; you can also try to edit parameters according to examples or other people's shop items.

**If you are familiar with the relevant basic knowledge,** you can try to read the following interface documentation and edit the desired effect yourself. And use it with automation software such as *[Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm)*.

**If you have programming foundation,** you can try to develop web pages, Android applications to make them integrated with LifeUp. This web page and customized versions of Wordle are some examples.

---

## Call external APP

If you want to call an external application in *LifeUp*, you only need to add a "Link" effect to the shop item, and **enter a web page or application-specific link**, and then use the shop item to complete the call.



**The following are some examples (you can also go to "World"-"Market"-"Link" to view public items with interface call effects):**

- Browser to open Baidu: https://www.baidu.com
- WeChat: [weixin://](weixin://)
- <del>Wechat scan (may be invalid): [weixin://scanqrcode](weixin://scanqrcode)</del>
- Scan Alipay: [alipayqr://platformapi/startapp?saId=10000007](alipayqr://platformapi/startapp?saId=10000007)
- Alipay Ant Forest: [alipays://platformapi/startapp?appId=60000002](alipays://platformapi/startapp?appId=60000002)
- Alipay AutoNavi map: [alipays://platformapi/startapp?appId=2018070960585195](alipays://platformapi/startapp?appId=2018070960585195)
- Alipay accounting: [alipay://platformapi/startapp?appId=20000168](alipay://platformapi/startapp?appId=20000168)
- QQ: [mqq://](mqq://)
- NetEase Cloud: [orpheuswidget://](orpheuswidget://)
- Netease Cloud Listening to Songs and Recognizing Songs: [orpheuswidget://recognize](orpheuswidget://recognize)
- Automatic accounting interface of Qianji: [Automatic Accounting Interface · Qianji User Guide (qianjiapp.com)](http://docs.qianjiapp.com/plugin/auto_tasker.html)
- ...

In theory, as long as the external APP opens the corresponding link, you can jump by using the shop item.

**You can search for the application link you need by searching `URL Schemes` on Google. **

**These links have nothing to do with "LifeUp", "LifeUp" only provides the jump link function. **

**Therefore we do not and do not maintain a list of links. <del>But in the future, we will consider supporting the window sharing of this type of shop item. </del> (Showcase sharing is currently supported)**



---

## Call the open interface of LifeUp

If you:

- You need to call the "LifeUp" interface in "LifeUp", you only need to add a "link" effect to the shop item, and **enter a web page or application-specific link**, and then use the shop item to complete the call.
- Calling through the web page, you only need to jump to our interface link by hyperlink.
- To call through the APP developed by yourself, you only need to use the Intent to jump to the corresponding interface link.
- Called by an automated tool (such as Tasker), and fill in the corresponding interface link in the appropriate place.



**Some examples:**

When you click the link below, "LifeUp" will pop up a prompt "You have learned to call!".

[lifeup://api/toast?text=You learned to call! &type=1&isLong=true](lifeup://api/toast?text=You learned to call!&type=1&isLong=true)

When you click the link below, you will get a gold coin in "LifeUp", and the reason for it is "Learn API Calls".

[lifeup://api/reward?type=coin&content=Learn API Call&number=1](lifeup://api/reward?type=coin&content=Learn API Call&number=1)

When you copy the link to the item's "link" effect, using the item can trigger a similar effect.



**An example of external application linkage:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en-us/example/wordle/index.html)

Wordle is a little word guessing game: guess words of length 5. Orange represents the word in the answer that contains the letter. Green is included and in the correct position.

**This version of Wordle supports linkage with "LifeUp":**

1. When you guess the word correctly, you can get 10 gold coins. And there is a corresponding reason for obtaining it.
2. When you fail to guess the word in the end, there will be a consolation prize of 1 gold coin.

![](_media/api/wordle.png ':size=30%')

<br/>

**Through this function, you can infinitely expand the possibility of people leveling, whether you will develop it or not! **

Please see below for specific calling rules.

---

## Interface documentation

### Basics - Examples

| Type | Description |
| -------- | ---------------------------------------- -------------------- |
| Example | [lifeup://api/toast?text=You learned to call! &type=1&isLong=true](lifeup://api/toast?text=You learned to call!&type=1&isLong=true) |
| interface format | fixed prefix/method name?parameter1=value1¶meter2=value2 |
| fixed prefix | lifeup://api/ |
| method name | toast |
| Parameters | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping

If the value of your parameter contains special symbols such as +, space, =, %, &, #, etc., it needs to be escaped:

| special characters | meaning | replacement content |
| :------- | :---------------------------- | :------- |
| + | The + sign in the URL represents a space | + |
| spaces | spaces in URLs can be + or encoded | %20 |
| / | separates directory and subdirectory | %2F |
| ? | separates the actual URL and parameters | %3F |
| % | Specify special characters | % |
| # | means bookmark | %23 |
| & | Separator between parameters specified in URL | %26 |
| = | The value of the specified parameter in the URL | %3D |

For example, the text content in the above example, if the text to be finally prompted is: ?text=You have learned to call!

Then you need to replace the special symbols `?` and `=` in the text as, the final effect is:

[lifeup://api/toast?text=%3Ftext%3D You learned to call! &type=1&isLong=true](lifeup://api/toast?text=%3Ftext%3DYou learned to call!&type=1&isLong=true)

<br/>

### Basic knowledge - person-liter data ID

The data storage in LifeUp basically has a unique id.

Some of the following interfaces support modifying **specified** shop items and completing **specified** tasks.

In order for "LifeUp" to find the corresponding data, you need to provide it with an id.

**You can enable "Settings" - "Experiment" - "Developer Mode" to view the original id of the data on each detail page in the app. **

For example, strength (1), its attribute id is 1.

#### event id

It can be viewed on the event details page.

id: If it is a repeating task, the id will be updated every time it repeats.

gid: The id of the item group. For the same repetitive task, its gid will not change.

#### list id

After enabling "Developer Mode", view it in the "Select List" pop-up window.

#### attribute id

After enabling "Developer Mode", view it on the "Custom Properties" page.

#### shop item id

"Developer Mode", and then click on the shop item to view the details to view.

#### Achievement condition id

After customizing the unlock condition for the achievement "requires an external API call to unlock", you can see the condition id on the details page

<br/>

### Popup message

**Method name: **toast

**Description:** Various styles of messages pop up

**Example:**[[lifeup://api/toast?text=Live well, eat well! &type=1&isLong=true](lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true)](lifeup://api/goto?page=lab)

**Explanation:** The prompt "Live well, eat well!" pops up in a reward style, and displays it for a longer time.

> Click on the link of the example to test the effect

| Parameter | Meaning | Value | Example | Required | Remarks |
| ------ | ---------------- | --------------- | --------- ----- | -------- | ----------------------------------- ------------------------- |
| text | Text message to prompt | Arbitrary text | You learned to call! | yes | |
| type | Text style type | Number from 0 to 6 | 1 | No | 0 - Normal style<br/>1 - Bonus style<br/>2 - Tomato style<br/>3 - Success style<br/ >4 - Prompt style<br/>5 - Warning style<br/>6 - Error style |
| isLong | Display duration | true or false | true | no | true - long<br/>false - short |

<br/>

### award

**Method name:**reward

**Description:**Provide the reward directly, and the reason for the reward can be customized

**Example:**

- Get 1 gold coin, and the reason for getting it is "Learn API Calls". And the reason will be displayed on the gold coin details page:

[lifeup://api/reward?type=coin&content=Learn API Call&number=1](lifeup://api/reward?type=coin&content=Learn API Call&number=1)

- Obtain 300 "Learning, Creativity" experience points, and the reason for obtaining it is "Learning API Calls". And the reason will be displayed on the EXP details page:

[lifeup://api/reward?type=exp&content=Learning API Calls&number=300&skills=2&skills=6](lifeup://api/reward?type=exp&content=Learning API Calls&number=300&skills=2&skills=6)

- Obtained 1 fuzzy matching "Gold Coin" item, and the reason for obtaining it is "Learning API Call". And the reason will be displayed on the warehouse history page:

[lifeup://api/reward?type=item&content=Learn API Call&number=1&item_name=Gold Coins](lifeup://api/reward?type=item&content=Learn API Call &number=1&item_name=Gold Coins)

| Parameter | Meaning | Value | Example | Required | Remarks |
| --------- | ---------------- | ---------------------- ------- | ----------- | -------- | --------------------- --------------------------------------- |
| type | Reward type | Currently only supported: <br/>coin<br/>exp | coin | yes | coin - gold coins<br/>exp - experience points |
| content | Reward Reason | Arbitrary Text | Learning API Calls | Yes | |
| skills | Skills (attributes) | Array of numbers greater than 0 | 1 | No | Available only when type is exp<br/>Supported arrays (eg &skills=1&skills=2&skills=3)<br/>For how to obtain, see above The article "Basic Knowledge - LifeUp Data ID" |
| number | Number of rewards | A number greater than 0 | 1 | Yes | If it is a gold coin, the maximum value is 999999<br/> If it is an experience value, the maximum value is 99999<br/> If it is a commodity, the maximum value is 99999 99 |
| item_id | item id | number greater than 0 | 1 | no* | only available when type is item |
| item_name | item name | any text | gold coins | no* | only available when type is item, fuzzy matching |
| silent | Whether to disable UI prompts | true or false | false | no | default is false |

<br/>

### Task

#### Add task

**Method name: **add_task

**Description:** Various styles of messages pop up

**Example:**

[lifeup://api/add_task?todo=This is an automatically added task¬es=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=gold](lifeup://api/add_task?todo=this is an automatically added task¬es=notes&coin=10&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=gold coins)

**Explanation: **Add a content to the default list (id is 0) with the content "This is an automatically added task", the remark is "Remark", the gold coin reward is random from 10 to 11, the experience value reward is 2048, the selected The skill ids are 1, 2, and 3 (generally corresponding to the first 3 built-in attributes), and the shop item reward is a fuzzy search for a "gold coin" shop item.

| Parameter | Meaning | Value | Example | Required | Remarks |
| ----------- | -------------- | -------------------- | - --- | -------- | ------------------------------------- ----------------------- |
| todo | task content | arbitrary text | coin | yes | coin - gold |
| notes | Notes | Any text | Notes | No | |
| coin | Gold reward | A number greater than 0 | 10 | No | The maximum value is 999999 |
| coin_var | Gold coin reward offset value | A number greater than 0 | 1 | No | If the value is greater than 0, when completing the task, gold coins will be randomly calculated in the interval [coin, coin+coin_var] |
| exp | experience reward | a number greater than 0 | 1 | no | maximum value is 99999 |
| skills | Attribute (skill) id | Array of numbers greater than 0 | 1 | No | Support array (ie &skills=1&skills=2&skills=3)<br/>For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |
| category | list id | a number greater than or equal to 0 | 0 | no | 0 or not passed represents the default list, and cannot select a smart list<br/>For the acquisition method, please refer to the above "Basic Knowledge - Person Level Data ID" |
| frequency | repetition frequency | number, see remarks for the range of values ​​| 0 | no | <br/> -1 - Unlimited<br/> -4 - Monthly<br/> -5 - Yearly |
| importance | importance | number [1, 4] | 1 | no | default is 1 |
| difficulty | difficulty level | number[1, 4] | 2 | no | default is 1 |
| item_id | id of the rewarded item | a number greater than 0 | 1 |
| item_name | The name of the reward item | Any text | Treasure chest | No |
| item_amount | amount of reward | [1, 99] | 1 | no | default is 1 |

<br/>

#### mission accomplished

**Method name: **complete

**Description:**Trigger task completion, only unfinished tasks will be searched

**Example:**

- Complete the task with id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Complete the task with "task group id" of 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Search for tasks by name and complete them: [lifeup://api/complete?name=Start using&ui=true](lifeup://api/complete?name=Start using&ui=true)

**explain:**

Each task has an id.

For repeating tasks, the id will be refreshed every time, but the "task group id" will remain the same.

The method of obtaining the id is to open the "Developer Mode" on the "Experiment" page, and then view it on the "Task Details" page.

| Parameter | Meaning | Value | Example | Required | Remarks |
| ---- | -------------- | ------------- | ---- | -------- | - --------------------------------------------- |
| id | task id | number greater than 0 | coin | no* | task id; if it is a repeating task, the id will be updated every time it repeats. |
| gid | task group id | number greater than 0 | remarks | no* | task group id; |
| name | name | any text | 10 | no* | fuzzy search, only one of the tasks found |
| ui | Whether to display the popup UI | true or false | true | no | The default is false, only a message is displayed in the background |

**Notice:**

1. In order to be able to match the task, one of id, gid, and name must be provided.

<br/>

### Store Settings

**Method name: **shop_settings

**Instructions:** Adjust various store settings

**Example:**

-
Set ATM interest rate to 0.01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
-
Increase interest rate by 0.01% per click: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Meaning | Value | Example | Required | Remarks |
| -------- | ------------ | ------------------------ ------------- | ------------ | -------- | -------------- -------------------------------------------------------- |
| key | type | Currently only supported: <br/>atm_interest | atm_interest | yes | atm_interest - ATM daily rate<br/>credit_interest - loan daily rate<br/>line_of_credit - loanable amount<br/>discount_rate_for_returning - return discount Scale |
| value | numeric value | floating point number (decimal point) | 0.01 | yes | different keys correspond to different value ranges |
| set_type | How to set the value | One of the following values:<br/>absolute<br/>relative | absolute | For example, adding or subtracting from the original value |

<br/>

### Jump

**Method name: **goto

**Description:** Jump to a page in "LifeUp"

**Example:**[lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explanation:** Jump to the experiment page

| Parameter | Meaning | Value | Example | Required | Remarks |
| ---- | ---- | --------------------------------------- --------------------- | ---- | -------- | ---- |
| page | page| Fix one of the following values:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/> add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/> dlc<br/>pomodoro_record<br/>synthesis<br/>pic_manage | lab | yes | |

<br/>

### Commodities

#### Adding goods

**Method name: **add_item

**Description:** To create a shop item, the icon only supports network addresses, and the use effect does not support customization.

**Example:**[lifeup://api/add_item?name=10 minutes break&desc=Go and take a short break! &price=10&action_text=rest](lifeup://api/add_item?name=break 10 minutes&desc=Go and rest for a short time!&price=10&action_text=break)

**Explanation:** Create a shop item with the name of "Take a 10-minute break", the description as "Go and take a good rest for a short period of time!", and the operation copy as "Rest" with a price of 10 gold coins.

| Parameter | Meaning | Value | Example | Required | Remarks |
| ---------------- | ------------ | ---------------- | -- ---------- | -------- | -------------------- |
| name | shop item name | Any text | 10 minute break | Yes | shop item name |
| desc | description | any text | get a gift | no | |
| icon | icon | any text | | no | icon should be a web address URL |
| price | price value | number [0, 999999] | 1 | no | |
| action_text | action button text | any text | rest | no | |
| disable_purchase | whether to disable purchases | true or false | 1 | no | default false |
| stock_number | number of stocks | [-1, 99999] | 1 | no | |

<br/>

#### Adjust items

**method name: **item

**Description:** Various operations on the shop item with the specified id only support the [On Shelf] shop item.

**Example:**[lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative)

**Explanation:** For a commodity with an id of 1, increase its price by 1 gold and increase the number of possessions by 1

| Parameter | Meaning | Value | Example | Required | Remarks |
| ----------------- | ------------------------- | ----- ----------------------------------- | ------------ | - ------- | ------------------------------------------------------ ------------------ |
| id | shop item id | A number greater than 0 | 1 | No* ||
| name | Commodity name | Arbitrary text | Treasure chest | No* | When used for unknown id, fuzzy search for commodities, not name modification |
| set_name | Modify name | Any text | Treasure chest | No | cannot be empty |
| set_desc | Modify description | Arbitrary text | Get a gift | No | |
| set_icon | Modify icon | Any text | | No | Icon should be a web address URL |
| set_price | adjust price value | number | 1 | no | |
| set_price_type | Price adjustment method (absolute/relative) | One of the following values: <br/>absolute<br/>relative | relative | No | absolute - absolute value, that is, directly set the target to value<br/>relative - Relative values, such as adding or subtracting from the original value |
| own_number | Adjust own number | number | 1 | no | |
| own_number_type | Price adjustment method (absolute/relative) | One of the following values:<br/>absolute<br/>relative | relative | No | absolute - absolute value, that is, directly set the target to value<br/>relative - Relative values, such as adding or subtracting from the original value |
| stock_number | stock number | number greater than or equal to 0 | 1 | no | |
| stock_number_type | Price adjustment method (absolute/relative) | One of the following values: <br/>absolute<br/>relative | relative | No | absolute - absolute value, that is, directly set the target to value<br/>relative - Relative values, such as adding or subtracting from the original value |

**Notice:**

1. In order to search for a shop item, either id or name must be provided.

<br/>

### Add tomato record

**Method name: **add_pomodoro

**Description: **Add tomato timing record

**Example:**

- Add a timing record with a duration of 25 minutes (1500000 ms) and point to a task whose name contains learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning &duration=1500000)
- Add timing record for 2022-08-01 11:00:00 - 2022-08-01 12:00:00: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro ?start_time=1659322800000&end_time=1659326400000)

**explain:**

For the explanation of task id/task group id, see the "Complete Task" interface above.



| Parameter | Meaning | Value | Example | Required | Remarks |
| --------------- | ------------ | -------------------- --------- | ------------- | -------- | ----------------- ---------------------------- |
| start_time | Timing start time | Timestamp | 1659322800000 | No* | You can understand the definition of timestamp on Baidu |
| duration | Focus duration | Number (milliseconds) <br/>Must be greater than 30000 | 1500000 | No* | |
| end_time | Timing end time | Timestamp | 1659326400000 | No* | |
| reward_tomatoes | whether to reward tomatoes | true or false | true | no | default is true |
| task_id | task id | a number greater than 0 | coin | no |
| task_gid | task group id | a number greater than 0 | remarks | no |
| task_name | name | any text | 10 | no | fuzzy search, only one of the tasks found |

**Notice:**

1. One of start_time, duration, end_time must be provided.
2. In the case of only duration, the default end_time is the current time.
3. end_time needs to be greater than start_time.
4. duration is at least 30000 milliseconds (30 seconds).
5. If both start_time, duration, end_time are provided, duration should be less than or equal to (end_time - start_time).

<br/>

### Unlock achievement conditions

**Method name: **unlock_condition

**Description:**Unlock achievement condition: requires external API call to unlock

**Example:**

- Call the unlock condition with unlock id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Meaning | Value | Example | Required | Remarks |
| ---- | ------ | ------------- | ---- | -------- | --------- ------------------------------------ |
| id | Condition id | Number greater than 0 | 2 | Yes |

<br/>

### Special interface

### Pop-ups

**Method name: **confirm_dialog

**Description:** A selection pop-up window pops up, you can customize the title, text, positive button, and negative button. Other interfaces can also be called when the button is clicked.

**Example:**

- [lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D believe &negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D do not believe](lifeup ://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D believe & negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D do not believe)

- Other usage scenarios:

Choice of rewards

branch selection

| Parameter | Meaning | Value | Example | Required | Remarks |
| --------------- | ------------------ | -------------- - | -------------------------------------------- | --- ----- | -------------------------------------------- ---------------- |
| title | Popup title | Any text | Title | Yes | |
| message | Detailed description of the popup window | Any text | This is the content of the popup window | No | |
| positive_text | Positive Button Text | Any Text | OK | No | |
| negative_text | Negative Button Text | Arbitrary Text | Reject | No | |
| positive_action | The link response of the positive button | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | No | It is actually the escaped text of the popup message interface. For escape rules, please refer to `Basic Knowledge - Escape`. |
| negative_action | Negative button's link response | URL (other interface) | Same as above | No | |
| cancel_action | Cancel the link response of the pop-up window | URL (other interface) | Same as above | No | |

<br/>


#### variable placeholder

"LifeUp" provides user intervention processing methods for parameters.

| placeholder | meaning | example |
| ---------------- | -------------------------------- -- | ---------------------- |
| [$text\|title] | text placeholder | [$text\|enter task name] |
| [$number\|Title] | Number placeholder (without decimal point) | [$number\|Enter price] |
| [$decimal\|title] | Number placeholder (with decimal point) | [$number\|Enter ATM rate] |
| [$item] | Select an item, it will be replaced with item id | [$item] |
| [$task_category] | Select task list, which will be replaced with task list id | [$task_category] |

**Example 1: When using, select an item to reduce the price by 1 gold**

For example, after you set the API for price reduction of a certain shop item, you may want to allow the user to select the specified shop item when calling. ** instead of specifying the id when calling.

The following api can only reduce the price of the shop item with id 1 by 1 gold:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

You only need to modify the item id to a placeholder `[$item]`, and when the call is made, the user can actively select the item that he wants to reduce the price:

[lifeup://api/item?id=[$item|Please select the item you want to reduce the price by 1 coin]&set_price=-1&set_price_type=relative](lifeup://api/item?id=[$item|Please select The item you want to drop by 1 gold]&set_price=-1&set_price_type=relative)



**Example 2: Task template, just enter the task name and selection list to create a pre-set reward template**

[lifeup://api/add_task?todo=[$text|Enter a task name]¬es=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]](lifeup:/ /api/add_task?todo=[$text|Enter a task name]¬es=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category])


<br/>

#### end callback

You can add the `callback` parameter to all interfaces to implement the processing of calling back the `URL` after the call.

This can also be used to splice multiple interfaces, for example, if you want to implement a prompt after the jump:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

You can use the `callback` parameter, refer to the above **Basic Knowledge - Escape**, you can write this kind of processing:

[lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D test callback](lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast% 3Ftext%3D test callback)



Of course, you can also add multiple links to a shop item to achieve this effect.

This callback is more used for:

A application -> LifeUp -> A application

or

A application -> person liters -> B application

<br/>

---

## linkage

We very much welcome any form of linkage from other developers.

### Application Developer

If you are an application developer and support linkage with "LifeUp", interesting functions and mechanisms have been realized.

You can contact us to recommend apps to each other within the app.

> If you need Google Play listing, etc., you can also contact for assistance.


### Web Developer

If you are a web developer and have developed web works that call the "LifeUp" API, you are welcome to share your works in the form of shop items within the app.

You can also contact us for mutual referrals.

If you have static web pages and you are not familiar with hosting, you can also contact us for assistance with hosting your web pages.

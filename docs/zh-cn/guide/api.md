# 开放接口与调用

在 v1.90 版本中，《人升》既开放了自己接口，亦实现了商品的“跳转”调用外部应用的效果。

这可以使你的《人升》获得无限的可能性，但也需要你有一定的学习理解和动手能力。

## 场景示例

| 调用方                                    | 场景                                                         | 备注     |
| ----------------------------------------- | ------------------------------------------------------------ | -------- |
| **人升 ->
外部应用**<br/>商品的“跳转”效果 | 使用商品后：<br/>1. 使用浏览器访问某个网页<br/>2. 跳转微信扫一扫，或指定小程序<br/>3. 自动添加记账记录（[如《钱迹》支持记账接口](http://docs.qianjiapp.com/plugin/auto_tasker.html)）<br/>4. ... （只要外部应用支持该方法调用） |          |
| **人升 ->
人升**<br/>商品的“跳转”效果     | 使用商品后：<br/>1. 打开人升某个页面<br/>2. 提升 ATM 利率<br/>3. 提升某个商品价格<br/>4. 完成某个任务<br/>5. 弹出自定义文本消息<br/>6. 自动创建任务<br/>7. 更多应用内的操作... | 会员功能 |
| **外部应用/网页 ->
人升**                 | 使用自动化软件/自己开发应用/外部应用联动：<br/>1. 判断定位到家了，自动打「回家」卡<br/>2. 到达一个未踏足的地方，自动解锁打卡成就<br/>3. 完成目标，刷一下 NFC 卡片，自动打卡任务<br/>4. 捕获其他专注软件的通知消息，自动添加计时记录到人升中<br/>5. 触发了xx条件，自动发放金币、商品奖励<br/>6. ... |          |

---

## 调用外部 APP

如果你想要在「人升」中调用外部应用，只需要为商品添加“跳转”效果，并**输入网页或应用专属链接**，再使用该商品即可完成调用。

以下是一些示例：

- 浏览器打开百度：https://www.baidu.com
- 微信：[weixin://](weixin://)
- 微信扫一扫：[weixin://scanqrcode](weixin://scanqrcode)
-
支付宝扫一扫：[alipayqr://platformapi/startapp?saId=10000007](alipayqr://platformapi/startapp?saId=10000007)
-
支付宝蚂蚁森林：[alipay://platformapi/startapp?appId=60000002](alipay://platformapi/startapp?appId=60000002)
- 支付宝记账：[alipay://platformapi/startapp?appId=20000168](alipay://platformapi/startapp?appId=20000168)
- QQ：[mqq://](mqq://)
- 网易云：[orpheuswidget://](orpheuswidget://)
- 网易云听歌识曲：[orpheuswidget://recognize](orpheuswidget://recognize)
- ...

理论上，只要外部 APP 开放了对应的链接，你就可以通过使用商品的方式进行跳转。

**你可以通过百度搜索`URL Schemes`的方式搜索你需要的应用链接。**

**这些链接与「人升」无关，「人升」只提供跳转功能。**

**因此我们不会也没人力维护链接列表。但我们后续会考虑支持橱窗分享此类型商品。**



---

## 调用人升

如果你：

- 需要在「人升」中调用「人升」的接口，也是只需要为商品添加“跳转”效果，并**输入网页或应用专属链接**，再使用该商品即可完成调用。
- 通过网页调用，则只需要超链接跳转我们的接口链接即可。
- 通过自己开发的 APP 调用，只需要使用 Intent 跳转对应的接口链接即可。
- 通过自动化工具（如 Tasker）调用，在合适的地方填入对应的接口链接即可。

**一些例子：**

当你点击下面这个链接，「人升」会弹出提示“你学会了调用！”。

[lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true)

当你点击下面这个链接，「人升」中会获得一个金币，并且获得原因为“学习API调用”。

[lifeup://api/reward?type=coin&content=学习API调用&number=1](lifeup://api/reward?type=coin&content=学习API调用&number=1)

当你把链接复制到商品的“跳转”效果中，使用商品也能够触发类似的效果。

**通过该功能，无论你是否会开发，你都可以无限扩展人升的可能性！**

具体调用规则请看下文。



---

## 接口文档

> 1.90 内测版本开发匆忙，本次内测只开放了一部分接口且参数比较简陋，更像是一个概念展示。
>
> 我们会在内测途中以及未来更新逐渐扩充 API ，助你实现更酷炫的效果。

### 示例

| 类型     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 示例     | [lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true) |
| 接口格式 | 固定前缀/方法名?参数1=数值1&参数2=数值2                      |
| 固定前缀 | lifeup://api/                                                |
| 方法名   | toast                                                        |
| 参数     | ?text=你学会了调用！&type=1&isLong=true                      |

<br/>

### 弹出消息

**方法名：**toast

**说明：**弹出各种样式的消息

**
示例：**[[lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true)](lifeup://api/goto?page=lab)

> 点击示例的链接可以测试效果

| 参数   | 含义             | 取值            | 示例           | 是否必须 | 备注                                                         |
| ------ | ---------------- | --------------- | -------------- | -------- | ------------------------------------------------------------ |
| text   | 要提示的文本消息 | 任意文本        | 你学会了调用！ | 是       |                                                              |
| type   | 文本样式类型     | 数字从0到6其一  | 1              | 否       | 0 - 普通样式<br/>1 - 奖励样式<br/>2 - 番茄样式<br/>3 - 成功样式<br/>4 - 提示样式<br/>5 - 警告样式<br/>6 - 错误样式 |
| isLong | 显示时长         | true 或者 false | true           | 否       | true - 长<br/>false - 短                                     |

<br/>

### 奖励

**方法名：**reward

**说明：**弹出各种样式的消息

**
示例：**[lifeup://api/reward?type=coin&content=学习API调用&number=1](lifeup://api/reward?type=coin&content=学习API调用&number=1)

| 参数    | 含义             | 取值                  | 示例        | 是否必须 | 备注                         |
| ------- | ---------------- | --------------------- | ----------- | -------- | ---------------------------- |
| type    | 奖励类型         | 目前仅支持：<br/>coin | coin        | 是       | coin - 金币                  |
| content | 奖励原因         | 任意文本              | 学习API调用 | 是       |                              |
| number  | 奖励数量         | 大于 0 的数字         | 1           | 是       | 如果是金币，取值最大为999999 |
| silent  | 是否要禁用UI提示 | true 或者 false       | false       | 否       |                              |

<br/>

### 任务

#### 添加任务

**方法名：**add_task

**说明：**弹出各种样式的消息

**
示例：**[lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10](lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10)

> 内测初版暂时不支持设置清单、经验值等参数，后续版本会补充

| 参数  | 含义     | 取值          | 示例 | 是否必须 | 备注                         |
| ----- | -------- | ------------- | ---- | -------- | ---------------------------- |
| todo  | 任务内容 | 任意文本      | coin | 是       | coin - 金币                  |
| notes | 备注     | 任意文本      | 备注 | 否       |                              |
| coin  | 金币奖励 | 大于 0 的数字 | 10   | 否       | 如果是金币，取值最大为999999 |

<br/>

### 商店设置（目前仅支持ATM利率）

**方法名：**shop_settings

**说明：**弹出各种样式的消息

**示例：**

-
将ATM利率设置为0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
-
每次点击将利率提升0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| 参数     | 含义         | 取值                                     | 示例         | 是否必须 | 备注                                                         |
| -------- | ------------ | ---------------------------------------- | ------------ | -------- | ------------------------------------------------------------ |
| key      | 类型         | 目前仅支持：<br/>atm_interest            | atm_interest | 是       | atm_interest - ATM利率                                       |
| value    | 数值         | 浮点数（小数点）                         | 0.01         | 是       |                                                              |
| set_type | 如何设置数值 | 以下数值其一：<br/>absolute<br/>relative | absolute     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，比如在原数值的基础上增加或减少 |

<br/>

### 跳转

**方法名：**goto

**说明：**跳转「人升」中的某个页面

**示例：**[lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

| 参数 | 含义 | 取值                                                         | 示例 | 是否必须 | 备注 |
| ---- | ---- | ------------------------------------------------------------ | ---- | -------- | ---- |
| page | 页面 | 固定以下数值其一：<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/> | lab  | 是       |      |


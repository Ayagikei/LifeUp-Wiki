<h1 align="center" padding="100">开放接口与调用</h1>

<p align="center">创造无限可能性！</p>





?> 在 v1.90 版本中，`人升`既开放了多种功能接口，欢迎任意外部应用联动。<br/>亦提供了商品的“链接”效果，用户可以直接使用商品来调用外部应用或者《人升》的接口。<br/>这可以使你的`人升`获得无限的可能性，但也需要你有一定的学习理解和动手能力。



## 场景示例

| 调用方                                    | 场景                                                         | 备注     |
| ----------------------------------------- | ------------------------------------------------------------ | -------- |
|**人升 ->外部应用**<br/>商品的“链接”效果 | **使用商品后：**<br/>1. 使用浏览器访问某个网页<br/>2. 跳转微信扫一扫，或指定小程序<br/>3. 自动添加记账记录（[如《钱迹》支持记账接口](http://docs.qianjiapp.com/plugin/auto_tasker.html)）<br/>4. 存储自动化工具 Tasker 配置（甚至分享到橱窗），使用后自动将配置导入 Tasker<br/>5. 使用 Tasker 随机切换桌面壁纸<br/>6. 触发 Tasker 显示自己编写的交互 UI 逻辑<br/>7. ... （只要外部应用支持该方法调用）<br/> | 任意用户都可调用<br/>Tasker 是一款自动化工具，并且它支持将配置导出成 Uri |
|**人升 ->人升**<br/>商品的“链接”效果     | **使用商品后：**<br/>1. 打开人升某个页面<br/>2. 提升 ATM 利率<br/>3. 弹窗让用户选择商品，降低商品价格（降价券）<br/>4. 触发某个任务完成<br/>5. 弹出自定义的激励语消息<br/>6. 创造任务奖励模板，只需要输入名称即可自动创建任务<br/>7. 弹窗询问用户的分支选择，创造情景化的小互动<br/>8. 更多应用内的操作... | 👑仅限会员使用 |
|**外部应用/网页 ->人升**                 | **配置自动化工具：**<br/>1. 判断每天第一次打开手机的时间，完成早起任务，或者直接触发“晚起”惩罚<br/>2. 每背完 25 个单词，刷一次特定的 NFC 卡片，自动打卡任务<br/>3. GPS 判断到达某个新地方，解锁“新地点”成就<br/>4. 每天连接打工 WIFI 时，触发解锁条件进度增长。累计 20 天的时候，解锁「打工人」成就<br/>5. 每天首次连接家里 WIFI 时，奖励自己“到家”金币<br/>6. 捕获其他番茄或专注软件的通知，自动将计时记录到人升中<br/>7. 捕获运动类、背单词类软件的完成或结束通知，自动发放「力量」、「学识」经验值<br/>8. 在自己设定的时间段内，每开一次手机，触发一次惩罚<br/>9. ...<br>**外部应用联动/自己开发应用：**<br/>1. 若不满意「人升」的番茄钟：可以自己开发计时软件，可以是网页应用或安卓应用，通过接口与「人升」联动，以添加计时记录或添加奖励<br/>2. 改动一些智力小游戏（如下文中有个 Wordle 例子），成功完成游戏时，触发「人升」发送奖励<br/>3. 开发应用与「人升」联动实现应用锁功能 | 👑仅限会员使用 |

<br/>换种说法，上述所有场景其实都是「事件」触发了「操作」。

而`人升`本次更新是提供了「使用商品」这个事件触发点，然后是提供了各式各样的「操作」（奖励、完成任务等等）。

如果你需要

- 点击网页按钮
- 刷 NFC 卡片
- 每天起床第一次解锁屏幕

这种事件，就需要外部应用的介入。



如果是应用内的指标事件，你可以通过搭配成就来实现。

**如果你想实现，力量达到5级后，提升 ATM 利率0.01%。就可以通过功能组合实现：**

> 成就跟踪力量等级 -> 达到5级后，自动解锁成就 -> 获取特殊商品奖励 -> 使用后提升 ATM 利率。

诸如番茄钟专注时长之类的场景也能举一反三。



**人升1.90.2更新将会增加一系列「事件」，但这些事件需要自动化工具或者外部应用接收。**

可以用来实现：

使用商品后，触发 Tasker 等自动化工具切换桌面壁纸。

完成任务后，触发 Tasker 等自动化工具打开某个 App。

**换种说法，就是 1.90.2 版本之前，只能由「Tasker的事件」触发「人升的操作」。**

**而在 1.90.2 版本，可以实现「人升的事件」触发「Tasker的操作」。**

Tasker 拥有着极高的权限，可以实现操作更换壁纸、卸载应用、提升音量、选择打开指定 app 等等操作。甚至可以自己无编程基础编写 UI 交互逻辑。



---

## 使用建议

**如果你不熟悉网络或计算机基础知识，**你可以直接在橱窗搜索、进货相关的商品；也可以尝试根据示例或者其他人的商品，编辑参数。

**如果你熟悉相关基础知识，**可以尝试阅读下述的接口文档，自己编辑出所需的效果。并且搭配自动化软件（如 Tasker）使用，即便不会编辑 Tasker 的配置，只要你能成功安装 Tasker，也能在橱窗或者其他社区导入其他人分享的自动化配置。

**如果你有编程基础，**可以尝试开发网页、安卓应用与人升联动。这个网页就是个超简单的例子。或者编写自动化工具的配置，分享给大家！

<br/>
如果你在使用途中遇到了任何关于 API 自身的问题，欢迎随时反馈~

但如果你是使用外部工具如 Tasker、获取外部应用的 API，或者学习编程遇到了困难，**我们仅提供有限支持**。因为这并非我们职责，我们需要将有限的时间投入到《人升》的维护开发中。如需长时间支持，请走付费咨询流程~感谢理解。

---

## 调用外部 APP

如果你想要在「人升」中调用外部应用，只需要为商品添加“链接”效果，并**输入网页或应用专属链接**，再使用该商品即可完成调用。


### 示例

**以下是一些示例（你也可以前往「世界」-「橱窗」-「调用」查看带有接口调用效果的物品）：**

- 浏览器打开百度：https://www.baidu.com
- 微信：[weixin://](weixin://)
- <del>微信扫一扫（可能失效了）：[weixin://scanqrcode](weixin://scanqrcode)</del>
- 支付宝扫一扫：[alipayqr://platformapi/startapp?saId=10000007](alipayqr://platformapi/startapp?saId=10000007)
- 支付宝蚂蚁森林：[alipays://platformapi/startapp?appId=60000002](alipays://platformapi/startapp?appId=60000002)
- 支付宝高德地图：[alipays://platformapi/startapp?appId=2018070960585195](alipays://platformapi/startapp?appId=2018070960585195)
- 支付宝记账：[alipay://platformapi/startapp?appId=20000168](alipay://platformapi/startapp?appId=20000168)
- QQ：[mqq://](mqq://)
- 网易云：[orpheuswidget://](orpheuswidget://)
- 网易云听歌识曲：[orpheuswidget://recognize](orpheuswidget://recognize)
- 钱迹的自动化记账接口：[自动化记账接口 · 钱迹用户指南 (qianjiapp.com)](http://docs.qianjiapp.com/plugin/auto_tasker.html)
- ...

理论上，只要外部 APP 开放了对应的链接，你就可以通过使用商品的方式进行跳转。

**这些链接与「人升」无关，「人升」只提供跳转功能。**

**因此我们不会也没人力维护链接列表。<del>但我们后续会考虑支持橱窗分享此类型商品。</del>（目前已支持橱窗分享）**

<br/>

### 如何获取上述 URL 链接

**常规方式**

- 使用网络搜索`URL Schemes`的方式搜索你需要的应用链接。
- 在「人升」`世界`-`橱窗`搜索应用，查看是否有人已经分享过链接。
- 查询对应的应用使用文档，看看开发者有没有提供。
- 咨询对应的开发者。

<br/>

**非常规方式**

> 通过这种方式获取的 URL 不一定能够正常或稳定使用。

- 查看对应的 H5 网页跳转应用的网页源码。
- 使用技术手段查看 AndroidManifest 文件。

<br/>

**通过第三方高权限 APP 做跳板**

比如 Anywhere（方法由用户 @喵喵喵 贡献），可以在**酷安**下载。

\>>需要的app：***Anywhere-***，*当前Activity*

\>>>方法：使用 Anywhere- 的 活动列表——选择需要打开的活动——点击即可自动制作卡片——然后长按卡片——自动生成了卡片的URL——长按复制入人升商品使用中即可(不需要锁定Anywhere-在后台) 

\>>>> *Anywhere-*：一般用app(Launcher)就可以直接打开选中的app，还可以直接制卡快捷搜索看看 **捷径社区** 里有没有app的直接URL，有的话就直接把appURL直接输入人升链接中就行。(一个一个活动试也是有用的)

\>>>>> *当前Activity*：使用 *当前Activity* 可以查看当前活动的名称，以便在Anywhere- 中选择活动。





---

## 调用人升

如果你：

- 需要在「人升」中调用「人升」的接口，也是只需要为商品添加“链接”效果，并**输入网页或应用专属链接**，再使用该商品即可完成调用。
- 通过网页调用，则只需要超链接跳转我们的接口链接即可。
- 通过自己开发的 APP 调用，只需要使用 Intent 跳转对应的接口链接即可。
- 通过自动化工具（如 Tasker）调用，在合适的地方填入对应的接口链接即可。



**一些例子：**

当你点击下面这个链接，「人升」会弹出提示“你学会了调用！”。

[lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true)

当你点击下面这个链接，「人升」中会获得一个金币，并且获得原因为“学习API调用”。

[lifeup://api/reward?type=coin&content=学习API调用&number=1](lifeup://api/reward?type=coin&content=学习API调用&number=1)

当你把链接复制到商品的“链接”效果中，使用商品也能够触发类似的效果。



**一个外部应用联动的例子：**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/zh-cn/example/wordle/index.html)

Wordle 是猜单词的小游戏：猜长度为 5 的单词。橙黄色代表答案的单词中包含该字母。绿色代表包含且位置正确。

**该版本的 Wordle 支持与「人升」联动：**

1. 当你猜中了单词，能够获得 10 点金币。并且有对应的获得原因。
2. 当你最终也没猜中单词，会有安慰奖 1 点金币。

![](_media/api/wordle.png ':size=30%')

<br/>

**与 Tasker 联动的例子：**

?> Tasker 是一款付费的自动化工具，需要从 Google Play 或官网付费获取正版。如果你没有对应的渠道，也可以试试下方的 MacroDroid。

> Tasker 调用的方式是，选择`操作类别`-`程序`-`快捷方式`。在快捷方式一栏输入 lifeup:// 开头的链接即可。

每天 5 点后第一次解锁屏幕，能触发完成一个名称包含“起床”的任务。

**注意：你需要先自己创建这个名字包含“起床”的每日任务。**

如果你已经安装了 Tasker，[点击这里可以导入已经配置好的任务。](taskerproject://H4sIAAAAAAAAAKVWTW/TQBA9p78iskRPxV7biZNQxyiFHCpFCLVVLxzQKt6kWxzHsrdBvRWEVFS1KkgIIW6IigKqWi6IEvFv2qThxF9g1rv5atyKlEs8nje7fjtv3ir2Co6ekPA+ZjgdhUVFSbstWlR0Jc1aRcVSkaojxZlJ2Q/DZo16JC4KIDYNJd0iRcXgaMquupgRR7cslLFMlMnqRt7WRJLDZBQ2MlnTMG2NDOCah+uRAytEwFPUdUzD1uDB3xrURY4OBXHAM36DON2T/c7Bl4ujo/PTre7Rh97hx99vnv35tds7/NTZf9053u2+fHW2tdv7/qPT3jnb2rM1voqvLreIz+KzVJs+Gj0JHKXpAlWEEByAh7xeixfE4TID1v2letJSKztcmbLvNX2XMtr0KzQSn6Q1UT6Cif0kEVPCKdtbi5xbPnnq4k1b4y8y3wwcHZoDD5kIAbO1sF9ha4OdBQltjIU4UnwQLq0mtU2U2ZxG5qoXOCzcIJDzgknhdTNv5tE/CG9eEr6QKHz24vnP3vHB+Wm7++6k+/bbxfsXMAgADHVeoQ0ylFn0orbmgEDwK94aDjCC3/iNxRiTGIsx1hD94nsltGudVFm/Xevoym4ZOSOHCmPd8jFseN5ud/a2e9tfOzufxcQCeyzpB9SNwAZzvCFxzJOMB3p+jneFiWTMiRPhMXd0TIhBoOfHqQCJjJWxcnrBmsKfIAY3n9QkCCn3B1CCgCdK1cEM4yqTPciNeiKbKYx6YpmFojqsD2d+MOiAirJF6VEo40bDXlFBijaBGddg5jhma4JrAm09gbaZQ6O0I+LUsBfBeEcys7Dhu9It8Vmk/VahKk7Ctwdm9glTXerXPRpV11Tsu2GTuiqL7191qVwpr5YerDxeLS0tlhYq5WVn1mPz0ApYUQpDvCmuZ222zuZhQqbc62YUbrPNgDiPKuu4hVUP+3VV8JmegNhJ3k28O/JaEv2bGAp9MBQerZGN4I6m4YCCEo3AI4zc5QYpimt9MC4j0oJXgcikFwpJXkAoa6IrvYAsM1/IXfZC4f+8kLuBFxK7oyebZQpDjGGZa7CsxMwEzJKYPmGyvhLiKf5nODN/AQAzsyt1CAAA)



![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**MacroDroid 的调用方式：**

> MacroDroid 也是一款自动化工具，它可以免费下载，UI也更加易用。

1. 增加宏，然后设定你所需要的条件（或者稍后设置）
2. 新增`动作`
3. 选择`应用程序`
4. 选择`打开网站`
5. 在`输入网址`一栏输入 `lifeup://` 开头的 URL 地址
6. 【取消勾选】下面的所有可选项，比如不要勾选`URL参数编码`...
7. 保存即可，可以点击该动作，然后选择`测试`动作进行验证

<br/>

**通过该功能，无论你是否会开发，你都可以无限扩展人升的可能性！**

具体调用规则请看下文。

---

## 接口文档

### 基础知识 - 示例

| 类型     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 示例     | [lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true) |
| 接口格式 | 固定前缀/方法名?参数1=数值1&参数2=数值2                      |
| 固定前缀 | lifeup://api/                                                |
| 方法名   | toast                                                        |
| 参数     | ?text=你学会了调用！&type=1&isLong=true                      |

<br/>

### 基础知识 - 转义（编码）

如果你的参数的数值里面有+、空格、=、%、&、#等特殊符号，需要转义（编码）处理：

| 特殊字符 | 代表含义                     | 替换内容 |
| :------- | :--------------------------- | :------- |
| +        | URL 中+号表示空格            | +        |
| 空格     | URL中的空格可以用+号或者编码 | %20      |
| /        | 分隔目录和子目录             | %2F      |
| ?        | 分隔实际的URL和参数          | %3F      |
| %        | 指定特殊字符                 | %        |
| #        | 表示书签                     | %23      |
| &        | URL 中指定的参数间的分隔符   | %26      |
| =        | URL 中指定参数的值           | %3D      |

比如上述例子中的文本内容，如果要最终提示的文本是：`?text=你学会了调用！`（这个例子其实有点奇怪，后续换个合理点的）

则需要替换文本中的特殊符号`?`和`=`为，最终效果为：

[lifeup://api/toast?text=%3Ftext%3D你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=%3Ftext%3D你学会了调用！&type=1&isLong=true)

<br/>

在某些特殊场景下，你可能需要将某个URL作为另外一个URL的参数，这时候也是需要转义（编码）的。

<br/>




**这是一个用 JS 实现的简单编码工具：**

这个工具会将中文、空格、各种符号编码。

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>


<br/>

### 基础知识 - 人升数据 ID

「人升」中的数据存储基本都会有一个唯一 id。

下述的部分接口支持修改**指定**的商品、完成**指定**的任务。

为了让「人升」能找到对应的数据，你需要为其提供 id。

**你可以启用「设置」-「实验」-「开发者模式」，即可在应用内的各个详情页面查看到数据的原始id。**

比如力量（1），它的属性id就是1。

#### 事项 id

可以在事项详情页面查看。

id：如果是重复任务，每次重复，id都会更新。

gid: 事项组id，针对同一个重复任务，其 gid 都不会发生变化。

#### 清单 id

开启「开发者模式」后，在「选择清单」弹窗查看。

#### 属性 id

开启「开发者模式」后，在「自定义属性」页面查看。

#### 商品 id

「开发者模式」，然后点击商品查看详情查看。

#### 成就条件 id

为成就自定义解锁条件「需要外部API调用以解锁」后，可以在详情页面看到条件id

<br/>

### 基础知识 - 返回值

有一部分接口可能会有返回值。

**如果你是在开发 Android 应用，**可以用`onActivityResult`方法接收返回值。

**如果你是用 Tasker 等自动化应用：**

一般这类应用没法接收 Activity 类型的返回值。所以你需要增加一个 broadcast 参数，然后使用`收到的意图`事件来接收返回值。

详情可以查看下文的 broadcast 广播参数。

<br/>

### 弹出消息

**方法名：**toast

**说明：**弹出各种样式的消息

**示例：**[[lifeup://api/toast?text=好好生活，好好吃饭！&type=1&isLong=true](lifeup://api/toast?text=好好生活，好好吃饭！&type=1&isLong=true)](lifeup://api/goto?page=lab)

**解释：**以奖励样式弹出提示“好好生活，好好吃饭！”，并且显示较长时间。

> 点击示例的链接可以测试效果

| 参数   | 含义             | 取值            | 示例           | 是否必须 | 备注                                                         |
| ------ | ---------------- | --------------- | -------------- | -------- | ------------------------------------------------------------ |
| text   | 要提示的文本消息 | 任意文本        | 你学会了调用！ | 是       |                                                              |
| type   | 文本样式类型     | 数字从0到6其一  | 1              | 否       | 0 - 普通样式<br/>1 - 奖励样式<br/>2 - 番茄样式<br/>3 - 成功样式<br/>4 - 提示样式<br/>5 - 警告样式<br/>6 - 错误样式 |
| isLong | 显示时长         | true 或者 false | true           | 否       | true - 长<br/>false - 短                                     |

<br/>

### 奖励

**方法名：**reward

**说明：**直接提供奖励，可定制奖励理由

**示例：**

- 获得 1 点金币，获得原因为「学习API调用」。且原因会在金币详情页面展示：

  [lifeup://api/reward?type=coin&content=学习API调用&number=1](lifeup://api/reward?type=coin&content=学习API调用&number=1)

- 获得 300 点「学识、创造力」经验值，获得原因为「学习API调用」。且原因会在经验值详情页面展示：

  [lifeup://api/reward?type=exp&content=学习API调用&number=300&skills=2&skills=6](lifeup://api/reward?type=exp&content=学习API调用&number=300&skills=2&skills=6)

- 获得 1 个模糊匹配「金币」商品，获得原因为「学习API调用」。且原因会在仓库历史页面展示：

  [lifeup://api/reward?type=item&content=学习API调用&number=1&item_name=金币](lifeup://api/reward?type=item&content=学习API调用&number=1&item_name=金币)

| 参数      | 含义             | 取值                                   | 示例        | 是否必须 | 备注                                                         |
| --------- | ---------------- | -------------------------------------- | ----------- | -------- | ------------------------------------------------------------ |
| type      | 奖励类型         | 目前仅支持：<br/>coin<br/>exp<br/>item | coin        | 是       | coin - 金币<br/>exp - 经验值<br/>item - 商品                 |
| content   | 奖励原因         | 任意文本                               | 学习API调用 | 是       | -                                                            |
| skills    | 技能（属性）     | 大于 0 的数字数组                      | 1           | 否       | 仅当 type 为 exp 时可用<br/>支持数组（如&skills=1&skills=2&skills=3）<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| number    | 奖励数量         | 大于 0 的数字                          | 1           | 是       | 如果是金币，取值最大为999999<br/>如果是经验值，取值最大为99999<br/>如果是商品，取值最大为99 |
| item_id   | 商品id           | 大于 0 的数字                          | 1           | 否*      | 仅当 type 为 item 时可用                                     |
| item_name | 商品名称         | 任意文本                               | 金币        | 否*      | 仅当 type 为 item 时可用，模糊匹配                           |
| silent    | 是否要禁用UI提示 | true 或者 false                        | false       | 否       | 默认为 false                                                 |

<br/>

### 惩罚

**方法名：**penalty

**说明：**直接提供惩罚，可定制惩罚理由

**示例：** *基本同奖励接口

- 惩罚 1 点金币，获得原因为「睡了懒觉」。且原因会在金币详情页面展示：

  [lifeup://api/penalty?type=coin&content=睡了懒觉&number=1](lifeup://api/penalty?type=coin&content=睡了懒觉&number=1)

- 惩罚 300 点「力量」经验值，原因为「睡了懒觉」。且原因会在经验值详情页面展示：

  [lifeup://api/penalty?type=exp&content=睡了懒觉&number=300&skills=1](lifeup://api/penalty?type=exp&content=睡了懒觉&number=300&skills=1)

- 惩罚 1 个模糊匹配「金币」商品，原因为「睡了懒觉」。且原因会在仓库历史页面展示：

  [lifeup://api/penalty?type=item&content=睡了懒觉&number=1&item_name=金币](lifeup://api/penalty?type=item&content=睡了懒觉&number=1&item_name=金币)

| 参数      | 含义             | 取值                                   | 示例     | 是否必须 | 备注                                                         |
| --------- | ---------------- | -------------------------------------- | -------- | -------- | ------------------------------------------------------------ |
| type      | 惩罚类型         | 目前仅支持：<br/>coin<br/>exp<br/>item | coin     | 是       | coin - 金币<br/>exp - 经验值<br/>item - 商品                 |
| content   | 惩罚原因         | 任意文本                               | 睡了懒觉 | 是       | -                                                            |
| skills    | 技能（属性）     | 大于 0 的数字数组                      | 1        | 否       | 仅当 type 为 exp 时可用<br/>支持数组（如&skills=1&skills=2&skills=3）<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| number    | 奖励数量         | 大于 0 的数字                          | 1        | 是       | 如果是金币，取值最大为999999<br/>如果是经验值，取值最大为99999<br/>如果是商品，取值最大为99 |
| item_id   | 商品id           | 大于 0 的数字                          | 1        | 否*      | 仅当 type 为 item 时可用                                     |
| item_name | 商品名称         | 任意文本                               | 金币     | 否*      | 仅当 type 为 item 时可用，模糊匹配                           |
| silent    | 是否要禁用UI提示 | true 或者 false                        | false    | 否       | 默认为 false                                                 |

<br/>

### 任务

#### 添加任务

**方法名：**add_task

**说明：**自动添加任务

**示例：**

[lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金币](lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金币)

**解释：**向默认清单（id为0）中添加一个内容为“这是自动添加的任务”，备注为“备注”，金币奖励为10~11随机，经验值奖励为2048，选择的技能id为1、2、3（一般对应前3个内置属性），商品奖励为模糊搜索一件“金币”商品。

| 参数           | 含义           | 取值                 | 示例                           | 是否必须 | 备注                                                         |
| -------------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------------------------------------ |
| todo           | 任务内容       | 任意文本             | coin                           | 是       | coin - 金币                                                  |
| notes          | 备注           | 任意文本             | 备注                           | 否       |                                                              |
| coin           | 金币奖励       | 大于 0 的数字        | 10                             | 否       | 取值最大为999999                                             |
| coin_var       | 金币奖励偏移值 | 大于 0 的数字        | 1                              | 否       | 如果该数值大于0，完成任务时，金币会随机计算区间为[coin, coin+coin_var] |
| exp            | 经验值奖励     | 大于 0 的数字        | 1                              | 否       | 取值最大为99999                                              |
| skills         | 属性（技能）id | 大于 0 的数字数组    | 1                              | 否       | 支持数组（即&skills=1&skills=2&skills=3）<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| category       | 清单id         | 大于或等于 0 的数字  | 0                              | 否       | 0 或不传递代表默认清单，不能选择智能清单<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| frequency      | 重复频次       | 数字，取值范围见备注 | 0                              | 否       | 默认为0<br/>0 - 单次<br/>1 - 每日<br/>大于 0 的其他数字 - 每 N 日<br/>-1 - 无限<br/>-4 - 每月<br/> -5 - 每年 |
| importance     | 重要程度       | 数字 [1, 4]          | 1                              | 否       | 默认为1                                                      |
| difficulty     | 困难程度       | 数字 [1, 4]          | 2                              | 否       | 默认为1                                                      |
| item_id        | 奖励商品的id   | 大于 0 的数字        | 1                              | 否       | 如需奖励商品，只需要提供id或名称其一<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| item_name      | 奖励商品的名称 | 任意文本             | 宝箱                           | 否       | 如需奖励商品，只需要提供id或名称其一<br/>名称会用于模糊匹配  |
| item_amount    | 奖励数量       | [1, 99]              | 1                              | 否       | 默认为1                                                      |
| deadline       | 本次期限时间   | 时间戳（毫秒）       | 0                              | 否       | -                                                            |
| color          | 标签颜色       | 字符串               | \#66CCFF                       | 否       | 需要 v1.91+<br/>注意在实际使用时，# 字符需要转义。<br/>比如示例的色值实际使用时，应为 `color=%2366CCFF` |
| background_url | 图片背景       | 字符串（远程URL）    | http://www.aaabbbccc.com/1.jpg | 否       | 仅支持手机可访问的地址                                       |

**返回值：**

仅 1.90.2 版本支持

| 参数     | 含义           | 取值 | 示例 | 是否必须 | 备注 |
| -------- | -------------- | ---- | ---- | -------- | ---- |
| task_id  | 新增的任务id   | 数字 | 1000 | 是       | -    |
| task_gid | 新增的任务组id | 数字 | 1000 | 是       | -    |



<br/>

#### 完成任务

**方法名：**complete

**说明：**触发任务完成，只会搜索到未完成的任务

**示例：**

- 完成id为1的任务：[lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- 完成「任务组id」为1的任务：[lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- 根据名字搜索任务并完成：[lifeup://api/complete?name=开始使用&ui=true](lifeup://api/complete?name=开始使用&ui=true)

**解释：**

每个任务都有一个 id。

对于重复任务而言，每次重复id都会刷新，但「任务组id」会保持不变。

id 的获取方法为「实验」页面打开「开发者模式」，然后在「任务详情」页面即可查看。

| 参数 | 含义           | 取值          | 示例 | 是否必须 | 备注                                           |
| ---- | -------------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任务id         | 大于 0 的数字 | 1    | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| gid  | 任务组id       | 大于 0 的数字 | 1    | 否*      | 任务组id；                                     |
| name | 名称           | 任意文本      | 睡觉 | 否*      | 模糊搜索，只会完成搜索到的其中一个任务         |
| ui   | 是否展示弹窗UI | true 或 false | true | 否       | 默认为 false，只在后台显示一条消息             |

**注意：**

1. 为了能够匹配到任务，id、gid、name 必须提供其一。

<br/>

#### 放弃任务

**方法名：**give_up

**说明：**触发任务放弃

**示例：**

- 根据名字搜索任务并放弃：[lifeup://api/give_up?name=早起](lifeup://api/give_up?name=早起)

**解释：**

| 参数 | 含义     | 取值          | 示例 | 是否必须 | 备注                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任务id   | 大于 0 的数字 | 1    | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| gid  | 任务组id | 大于 0 的数字 | 1    | 否*      | 任务组id；                                     |
| name | 名称     | 任意文本      | 早起 | 否*      | 模糊搜索，只会完成搜索到的其中一个任务         |

**注意：**

1. 为了能够匹配到任务，id、gid、name 必须提供其一。

<br/>

#### 冻结任务

**方法名：**freeze

**说明：**触发任务冻结，只适用于重复任务

**示例：**

- 根据名字搜索任务并冻结：[lifeup://api/freeze?name=早起](lifeup://api/freeze?name=早起)

**解释：**

| 参数 | 含义        | 取值          | 示例          | 是否必须 | 备注                                           |
| ---- | ----------- | ------------- | ------------- | -------- | ---------------------------------------------- |
| id   | 任务id      | 大于 0 的数字 | 1             | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| gid  | 任务组id    | 大于 0 的数字 | 1             | 否*      | 任务组id；                                     |
| name | 名称        | 任意文本      | 早起          | 否*      | 模糊搜索，只会完成搜索到的其中一个任务         |
| time | 冻结直至... | 时间戳        | 1661688800682 | 否       | -                                              |

**注意：**

1. 为了能够匹配到任务，id、gid、name 必须提供其一。

<br/>

#### 解冻任务

**方法名：**unfreeze

**说明：**触发任务解冻

**示例：**

- 根据名字搜索任务并解冻：[lifeup://api/unfreeze?name=早起](lifeup://api/unfreeze?name=早起)

**解释：**

| 参数 | 含义     | 取值          | 示例 | 是否必须 | 备注                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任务id   | 大于 0 的数字 | 1    | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| gid  | 任务组id | 大于 0 的数字 | 1    | 否*      | 任务组id；                                     |
| name | 名称     | 任意文本      | 早起 | 否*      | 模糊搜索，只会完成搜索到的其中一个任务         |

**注意：**

1. 为了能够匹配到任务，id、gid、name 必须提供其一。

<br/>

#### 删除任务

**方法名：**delete_task

**说明：**触发任务删除

**示例：**

- 根据名字搜索任务并删除：[lifeup://api/delete_task?name=早起](lifeup://api/delete_task?name=早起)

**解释：**

| 参数 | 含义     | 取值          | 示例 | 是否必须 | 备注                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任务id   | 大于 0 的数字 | 1    | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| gid  | 任务组id | 大于 0 的数字 | 1    | 否*      | 任务组id；                                     |
| name | 名称     | 任意文本      | 早起 | 否*      | 模糊搜索，只会完成搜索到的其中一个任务         |

**注意：**

1. 为了能够匹配到任务，id、gid、name 必须提供其一。

<br/>

### 商店设置

**方法名：**shop_settings

**说明：**调整各种商店设置

**示例：**

-
将ATM利率设置为0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
-
每次点击将利率提升0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| 参数     | 含义         | 取值                                                         | 示例         | 是否必须 | 备注                                                         |
| -------- | ------------ | ------------------------------------------------------------ | ------------ | -------- | ------------------------------------------------------------ |
| key      | 类型         | 目前仅支持：<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | 是       | atm_interest - ATM日利率<br/>credit_interest - 贷款日利率<br/>line_of_credit - 可贷款金额<br/>discount_rate_for_returning - 退货打折比例<br/>atm_balance - ATM 余额 |
| value    | 数值         | 浮点数（小数点）                                             | 0.01         | 是       | 不同的 key 对应不同的数值范围<br/>比如 ATM 余额不支持小数点  |
| set_type | 如何设置数值 | 以下数值其一：<br/>absolute<br/>relative                     | absolute     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，在原数值的基础上增加或减少 |

<br/>

### 跳转

**方法名：**goto

**说明：**跳转「人升」中的某个页面

**示例：**[lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**解释：**跳转到实验页面

| 参数 | 含义 | 取值                                                         | 示例 | 是否必须 | 备注                                                   |
| ---- | ---- | ------------------------------------------------------------ | ---- | -------- | ------------------------------------------------------ |
| page | 页面 | 固定以下数值其一：<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>dlc<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog | lab  | 是       | `purchase_dialog`指购买弹窗<br/>其他的都是具体的大页面 |

当 `page` 参数为 `purchase_dialog`时，你可以指定商品id：

示例如：`lifeup://api/goto?page=purchase_dialog&id=1`

| 参数 | 含义   | 取值          | 示例 | 是否必须 | 备注   |
| ---- | ------ | ------------- | ---- | -------- | ------ |
| id   | 商品id | 大于 0 的数字 | 1    | 是       | 商品id |

<br/>

### 商品

#### 添加商品

**方法名：**add_item

**说明：**创建商品，图标仅支持网络地址，暂不支持自定义使用效果。

**示例：**[lifeup://api/add_item?name=休息10分钟&desc=去好好休息一小段时间吧！&price=10&action_text=休息](lifeup://api/add_item?name=休息10分钟&desc=去好好休息一小段时间吧！&price=10&action_text=休息)

**解释：**创建一个名称为「休息10分钟」，描述为「去好好休息一小段时间吧！」，操作文案为「休息」的价格10金币的商品。

| 参数             | 含义         | 取值                | 示例         | 是否必须 | 备注                                                         |
| ---------------- | ------------ | ------------------- | ------------ | -------- | ------------------------------------------------------------ |
| name             | 商品名称     | 任意文本            | 休息10分钟   | 是       | 商品名称                                                     |
| desc             | 描述         | 任意文本            | 获得一个礼物 | 否       | -                                                            |
| icon             | 图标         | 任意文本            |              | 否       | 图标应为网络地址 URL                                         |
| price            | 价格数值     | 数字 [0, 999999]    | 1            | 否       | -                                                            |
| action_text      | 操作按钮文案 | 任意文本            | 休息         | 否       | -                                                            |
| disable_purchase | 是否禁用购买 | true 或 false       | 1            | 否       | 默认 false                                                   |
| stock_number     | 库存数       | [-1, 99999]         | 1            | 否       | -                                                            |
| category         | 商店清单id   | 大于或等于 0 的数字 | 0            | 否       | 0 或不传递代表默认清单，不能选择智能清单<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |

**返回值：**

仅 1.90.2 版本支持

| 参数    | 含义         | 取值 | 示例 | 是否必须 | 备注 |
| ------- | ------------ | ---- | ---- | -------- | ---- |
| item_id | 新增的商品id | 数字 | 1000 | 是       |      |



<br/>

#### 调整商品

**方法名：**item

**说明：**对指定 id 的商品的各种操作，仅支持【在架】商品。

**示例：**[lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative&own_number=1&own_number_type=relative)

**解释：**对 id 为 1 的商品，将其价格提升 1 金币，并提升拥有数 1

| 参数              | 含义                          | 取值                                     | 示例         | 是否必须 | 备注                                                         |
| ----------------- | ----------------------------- | ---------------------------------------- | ------------ | -------- | ------------------------------------------------------------ |
| id                | 商品id                        | 大于0的数字                              | 1            | 否*      | 获取方式请查看上文 「基础知识 - 人升数据 ID」                |
| name              | 商品名称                      | 任意文本                                 | 宝箱         | 否*      | 用于未知 id 时，模糊搜索商品，并非修改名称                   |
| set_name          | 修改名称                      | 任意文本                                 | 宝箱         | 否       | 不可为空                                                     |
| set_desc          | 修改描述                      | 任意文本                                 | 获得一个礼物 | 否       | -                                                            |
| set_icon          | 修改图标                      | 任意文本                                 |              | 否       | 图标应为网络地址 URL                                         |
| set_price         | 调整价格数值                  | 数字                                     | 1            | 否       | -                                                            |
| set_price_type    | 调整价格方式（绝对/相对）     | 以下数值其一：<br/>absolute<br/>relative | relative     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，比如在原数值的基础上增加或减少 |
| own_number        | 调整拥有数                    | 正负数                                   | 1            | 否       | 使用绝对取值时，数值应该为[0, MAX]<br/>使用相对取值时，支持负数，但最终结果数值最小为0 |
| own_number_type   | 调整拥有数量方式（绝对/相对） | 以下数值其一：<br/>absolute<br/>relative | relative     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，比如在原数值的基础上增加或减少 |
| stock_number      | 库存数                        | 正负数                                   | 1            | 否       | 使用绝对取值时，数值应该为[0, MAX]<br/>使用相对取值时，支持负数，但最终结果数值最小为0 |
| stock_number_type | 调整库存数方式（绝对/相对）   | 以下数值其一：<br/>absolute<br/>relative | relative     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，比如在原数值的基础上增加或减少 |
| disable_purchase  | 是否禁止购买                  | 布尔值                                   | true         | 否       | 仅 v1.91 +支持                                               |

**注意：**

1. 为了搜索到商品，必须提供 id 或 name 其一。

<br/>

#### 调整开箱效果

**方法名：**loot_box

**说明：**修改指定箱子的开箱效果，支持调整概率、奖励数和增加内容物。（暂不支持删除）

**示例：**[lifeup://api/loot_box?name=金币箱&sub_name=【大】袋金币&set_type=relative&probability=1&fixed=false](lifeup://api/loot_box?name=金币箱&sub_name=【大】袋金币&set_type=relative&amount=1&probability=1&fixed=false)

**解释：**增加金币箱中的【大】袋金币的比重 1 点。

| 参数        | 含义                  | 取值                                     | 示例         | 是否必须 | 备注                                                         |
| ----------- | --------------------- | ---------------------------------------- | ------------ | -------- | ------------------------------------------------------------ |
| id          | 商品id                | 大于0的数字                              | 1            | 否*      | 获取方式请查看上文 「基础知识 - 人升数据 ID」                |
| name        | 商品名称              | 任意文本                                 | 金币箱       | 否*      | 用于未知 id 时，模糊搜索商品，并非修改名称                   |
| sub_id      | 箱子内容物的 id       | 大于0的数字                              | 1            | 否*      | 箱子内容物的 id                                              |
| sub_name    | 箱子内容物的名称      | 任意文本                                 | 【大】袋金币 | 否*      | 用于箱子内容物未知 id 时，模糊搜索商品                       |
| set_type    | 调整方式（绝对/相对） | 以下数值其一：<br/>absolute<br/>relative | relative     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，比如在原数值的基础上增加或减少<br/>**同时作用于[amount]、[probability]两个字段** |
| amount      | 奖励数                | 数字                                     | 1            | 否       | 某个单一物品的奖励个数                                       |
| probability | 奖励比重              | 数字                                     | 1            | 否       | -                                                            |
| fixed       | 是否是固定奖励        | 布尔值                                   | true/false   | 否       | -                                                            |

**注意：**

1. 为了搜索到商品，必须提供 id 或 name 其一。
1. 为了搜索到内容物，必须提供 sub_id 或 sub_name 其一。

<br/>

### ATM

**⚠ 仅 v1.91 + 支持**

> 这里的存取款操作会进行合法校验。
>
> 如果你需要直接调整 ATM 数值，可查看上文中的「商店设置」接口。

#### 存款

**方法名：**deposit

**说明：**存款，会进行合法性校验（金币余额是否充足）。

**示例：**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**解释：**存款 500 金币。

| 参数   | 含义     | 取值          | 示例 | 是否必须 | 备注 |
| ------ | -------- | ------------- | ---- | -------- | ---- |
| amount | 存款数量 | 大于 0 的数字 | 100  | 是       | -    |

**返回值：**

| 参数   | 含义         | 取值   | 示例 | 是否必须 | 备注 |
| ------ | ------------ | ------ | ---- | -------- | ---- |
| result | 操作是否成功 | 布尔值 | true | 是       | -    |

<br/>

#### 取款

**方法名：**withdraw

**说明：**取款，会进行合法性校验（ATM 余额是否充足）。

**示例：**[lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**解释：**取款 500 金币。

| 参数   | 含义     | 取值          | 示例 | 是否必须 | 备注 |
| ------ | -------- | ------------- | ---- | -------- | ---- |
| amount | 取款数量 | 大于 0 的数字 | 100  | 是       | -    |

**返回值：**

| 参数   | 含义         | 取值   | 示例 | 是否必须 | 备注 |
| ------ | ------------ | ------ | ---- | -------- | ---- |
| result | 操作是否成功 | 布尔值 | true | 是       | -    |

<br/>

### 添加番茄记录

**方法名：**add_pomodoro

**说明：**添加番茄计时记录

**示例：**

- 添加时长为 25 分钟（1500000 毫秒）的计时记录，并指向名称包含学习的任务：[lifeup://api/add_pomodoro?task_name=学习&duration=1500000](lifeup://api/add_pomodoro?task_name=学习&duration=1500000)
- 添加2022-08-01 11:00:00 - 2022-08-01 12:00:00 的计时记录：[lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**解释：**

任务id/任务组id的解释可以查看上文的「完成任务」接口。



| 参数            | 含义         | 取值                          | 示例          | 是否必须 | 备注                                          |
| --------------- | ------------ | ----------------------------- | ------------- | -------- | --------------------------------------------- |
| start_time      | 计时开始时间 | 时间戳                        | 1659322800000 | 否*      | 可以百度了解时间戳的定义                      |
| duration        | 专注时长     | 数字（毫秒）<br/>需大于 30000 | 1500000       | 否*      | -                                             |
| end_time        | 计时结束时间 | 时间戳                        | 1659326400000 | 否*      | -                                             |
| reward_tomatoes | 是否奖励番茄 | true 或者 false               | true          | 否       | 默认为 false                                  |
| task_id         | 任务id       | 大于 0 的数字                 | coin          | 否       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| task_gid        | 任务组id     | 大于 0 的数字                 | 备注          | 否       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| task_name       | 名称         | 任意文本                      | 10            | 否       | 模糊搜索，只会搜索到的其中一个任务            |

**注意：**

1. start_time, duration, end_time 必须提供其一。
2. 在只有 duration 的情况下，会默认 end_time 为当前时间。
3. end_time 需要大于  start_time。
4. duration 至少为 30000 毫秒（30秒）。
5. 如果同时提供了 start_time, duration, end_time，duration 应该比 (end_time - start_time) 小或相等。

<br/>

### 解锁成就条件

**方法名：**unlock_condition

**说明：**解锁成就条件：需要外部API调用以解锁

**示例：**

- 调用解锁 id 为 2 的解锁条件：[lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| 参数 | 含义   | 取值          | 示例 | 是否必须 | 备注                                          |
| ---- | ------ | ------------- | ---- | -------- | --------------------------------------------- |
| id   | 条件id | 大于 0 的数字 | 2    | 是       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |

<br/>

### 设置步数

**方法名：**step

**说明：**设置指定日期的步数，比如可以用于搭配手环+自动化工具录入步数。并且可以用于修改历史纪录。

**示例：**

- 调整GMT+8时区下的2022-10-21的步数为9999步：[lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| 参数  | 含义                 | 取值                | 示例          | 是否必须 | 备注 |
| ----- | -------------------- | ------------------- | ------------- | -------- | ---- |
| count | 步数                 | 大于或等于 0 的数字 | 9999          | 是       | -    |
| time  | 所属日期的任意时间戳 | 时间戳（ms）        | 1666282995643 | 是       | -    |

<br/>

### 简单查询

!> 此处的功能是用于搭配自动化工具/二次开发的。如果你需要查询完整的数据列表，可以参考我们的 LifeUp SDK、《云人升》、《人升桌面端》。

**方法名：**query

**说明：**查询参数

**版本：**需要 v1.90.2

**示例：**

- 查询当前金币数：[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

| 参数    | 含义       | 取值                                         | 示例 | 是否必须                | 备注                                                         |
| ------- | ---------- | -------------------------------------------- | ---- | ----------------------- | ------------------------------------------------------------ |
| key     | 查询的类型 | 仅限以下数值其一：<br/>coin<br/>atm<br/>item | coin | 是                      | coin - 当前金币数<br/>atm - 当前 ATM 存款<br/>item - 指定 `item_id` 的商品信息 |
| item_id | 商品id     | 大于 0 的数字                                | 1    | 当 key 为 item 时，必须 | 查询的商品 id                                                |

**返回值：**

当查询 coin/atm 时：

| 参数  | 含义           | 取值 | 示例 | 是否必须 | 备注 |
| ----- | -------------- | ---- | ---- | -------- | ---- |
| value | 查询返回的数值 | 数字 | 1000 | 是       |      |

当查询 item 时：

| 参数             | 含义         | 取值     | 示例      | 是否必须 | 备注                           |
| ---------------- | ------------ | -------- | --------- | -------- | ------------------------------ |
| item_id          | 商品id       | 数字     | 1         | 是       | -                              |
| name             | 名称         | 任意文本 | 商品      | 是       | -                              |
| desc             | 描述         | 任意文本 |           | 否       | -                              |
| icon             | 图标地址     | 任意文本 | icon.webp | 否       | 如果是本地文件时，只返回文件名 |
| category_id      | 清单 id      | 数字     | 1         | 是       | -                              |
| stock_number     | 商店库存数量 | 数字     | -1        | 是       | -1 代表无限商店库存            |
| own_number       | 仓库拥有数   | 数字     | 10        | 是       | -                              |
| price            | 价格         | 数字     | 100       | 是       | -                              |
| order            | 排序依据     | 数字     | 100       | 是       | 自定义排序时的权重值           |
| disable_purchase | 是否禁止购买 |          | true      | 是       | -                              |



<br/>

### 查询属性状态

!> 此处的功能是用于搭配自动化工具/二次开发的

**方法名：**query_skill

**说明：**查询指定属性的名称、等级、总经验值、直至下一级等级所需经验值、目前等级经验值。

可以由于自动化工具获取等级，自定义开发属性小部件等。

**版本：**需要 v1.90.6

**示例：**

- 查询力量属性：[lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| 参数 | 含义             | 取值        | 示例 | 是否必须 | 备注                                          |
| ---- | ---------------- | ----------- | ---- | -------- | --------------------------------------------- |
| id   | 技能（属性）的id | 大于0的数字 | 1    | 是       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |

**返回值：**

| 参数                 | 含义                         | 取值   | 示例  | 是否必须 | 备注 |
| -------------------- | ---------------------------- | ------ | ----- | -------- | ---- |
| name                 | 属性名称                     | 字符串 | 力量  | 是       | -    |
| level                | 等级                         | 数字   | 10    | 是       | -    |
| total_exp            | 总经验值                     | 数字   | 10000 | 是       | -    |
| until_next_level_exp | 升到下一级所需的经验值       | 数字   | 99    | 是       | -    |
| current_level_exp    | 超过当前等级的已获得的经验值 | 数字   | 1000  | 是       | -    |

<br/>

### 特殊接口

#### 弹窗

**方法名：**confirm_dialog

**说明：**弹出一个选择弹窗，可以自定义标题、文本、积极按钮、消极按钮。点击按钮时也可以调用其他接口。

**示例：**

- [lifeup://api/confirm_dialog?title=你相信爱吗&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D相信&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D不相信](lifeup://api/confirm_dialog?title=你相信爱吗&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D相信&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D不相信)

- 其他使用场景：

  奖励二选一

  分支选择

| 参数            | 含义               | 取值            | 示例                                         | 是否必须 | 备注                                                         |
| --------------- | ------------------ | --------------- | -------------------------------------------- | -------- | ------------------------------------------------------------ |
| title           | 弹窗标题           | 任意文本        | 标题                                         | 是       | -                                                            |
| message         | 弹窗详细描述       | 任意文本        | 这是弹窗内容                                 | 否       | -                                                            |
| positive_text   | 积极按钮文案       | 任意文本        | 确定                                         | 否       | -                                                            |
| negative_text   | 消极按钮文案       | 任意文本        | 拒绝                                         | 否       | -                                                            |
| neutral_text    | 中性按钮文案       | 任意文本        | 说明                                         | 否       | -                                                            |
| positive_action | 积极按钮的链接响应 | URL（其他接口） | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D你点了确定 | 否       | 实际上就是弹出消息接口经过转义的文本。转义规则可参考`基础知识-转义`。 |
| negative_action | 消极按钮的链接响应 | URL（其他接口） | 同上                                         | 否       | 同上                                                         |
| neutral_action  | 中性按钮的链接响应 | URL（其他接口） | 同上                                         | 否       | 同上                                                         |
| cancel_action   | 取消弹窗的链接响应 | URL（其他接口） | 同上                                         | 否       | 「取消」指的是                                               |

<br/>

#### 空接口

**方法名：**placeholder

**说明：**该接口本身不处理任何逻辑，但你可以搭配 callback、broadcast 使用。

**示例：**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)


#### 变量占位符

「人升」提供了对参数的用户介入处理手段。

| 占位符           | 含义                               | 示例                   |
| ---------------- | ---------------------------------- | ---------------------- |
| [$text\|标题]    | 文本占位符                         | [$text\|输入任务名称]  |
| [$number\|标题]  | 数字占位符（不含小数点）           | [$number\|输入价格]    |
| [$decimal\|标题] | 数字占位符（含小数点）             | [$number\|输入ATM利率] |
| [$item]          | 选择商品，将被替换为商品id         | [$item]                |
| [$task_category] | 选择任务清单，将被替换为任务清单id | [$task_category]       |

**示例1：使用时，选择物品降价1金币**

比如当你设置为某个商品降价的 api 后，**可能希望在调用的时候，再允许用户选择指定商品。**而非调用时就指定 id。

以下 api 只能让 id 为 1 的商品降价 1 金币：

```url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
```

只需要将商品 id 修改为占位符`[$item]`，就可以实现调用的时候，用户能主动选择想要降价的商品：

[lifeup://api/item?id=[$item|请选择你想要降价1金币的商品]&set_price=-1&set_price_type=relative](lifeup://api/item?id=[$item|请选择你想要降价1金币的商品]&set_price=-1&set_price_type=relative)



**示例2：任务模板，只需要输入任务名称和选择清单，即可创建提前设置好的奖励模板**

[lifeup://api/add_task?todo=[$text|输入任务名称]&notes=这是个任务的奖励模板&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]](lifeup://api/add_task?todo=[$text|输入任务名称]&notes=这是个任务的奖励模板&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category])


<br/>

#### 结束回调

所有接口你都可以加上`callback`参数，实现调用后回调该`URL`的处理。

这也可以用于拼接多个接口，比如想要实现跳转后提示激励语：

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

可以使用`callback`参数，参考上文**基础知识-转义**，就可以写出这种的处理：

[lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D测试callback](lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D测试callback)



当然，你也完全可以为一个商品添加多个链接来实现该效果。

该回调更多是用于：

A应用 -> 人升 -> A应用

或

A应用 -> 人升 -> B应用

<br/>

#### Broadcast 广播返回值

!> 此处的功能是用于搭配自动化工具/二次开发的，有一定门槛。

增加这个参数，可以将 API 原本的返回值也通过广播发送出去。以便 Tasker 等自动化工具能够接收到。

broadcast 的数值相当于 Tasker 中的「收到的意图」的操作一栏的数值，你可以填写任意文本，只要这两者对应上即可。

**比如 Tasker 使用查询金币的 API（[如果你在使用MacroDroid，请查看这篇教程](https://github.com/Ayagikei/LifeUp/issues/43)）：**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. 添加 broadcast 参数，让它能够广播返回值到 Tasker，可以是任意文本，比如`app.lifeup.query.coin`。

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. 在 Tasker 中添加事件->「收到的意图」，在操作一栏填写「app.lifeup.query.coin」

3. 然后可以在 Tasker 中的任务以`%value`变量的方式接收到`value`的返回值。

4. 然后你可以在 Tasker 中判断金币数实现各种效果了。（比如根据金币数更换桌面壁纸？）

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## 广播事件通知

!> 此处的功能是用于搭配自动化工具/二次开发的，有一定门槛。

> 1.90.2 版本我们会以广播的形式向外部发送人升的各种事件。你可以使用 Tasker 等自动化工具接收这些事件来触发 Tasker 的动作。

### 启用

默认广播事件是关闭的。

你可以在`设置`-`实验`-`开发者模式`-`广播事件`启用它。

### 示例：使用商品更换壁纸

1. 新建一个商品，名称叫做「更换壁纸」。
2. 在 Tasker 中，`配置文件`->`事件`->`系统`->`收到的意图`，在操作一栏输入`app.lifeup.item.use`，返回。
3. 点击新建任务，输入任意名称（比如更换壁纸）。
4. 点击右下角+号添加任务，选择`任务`->`If`
5. 将条件一栏调整为 `%name = 更换壁纸`。
6. 返回，`插入操作`选择`If`。
7. 再次点击右下角+号添加任务，选择`显示`->`设置壁纸`
8. （可选）`类型`更换为`全部`
9. 图像一栏，点击🔍图标，选择你想要的壁纸文件
10. 退出，检查是否已经启用了这个配置。
11. 在`人升`中使用「更换壁纸」商品，你应该能成功见到壁纸更换了

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

使用`空接口`+`Broadcast 广播返回值`可以以更简洁的方式实现这个效果，可以摸索下。

<br/>

### 完成任务

**名称：**app.lifeup.task.complete

**返回值：**

| 参数     | 含义     | 示例         |
| -------- | -------- | ------------ |
| task_id  | 任务id   | 1            |
| task_gid | 任务组id | 1            |
| name     | 事项名称 | 开始使用人升 |

### 放弃任务

**名称：**app.lifeup.task.giveup

**返回值：**

| 参数     | 含义     | 示例            |
| -------- | -------- | --------------- |
| task_id  | 任务id   | 1               |
| task_gid | 任务组id | 1               |
| name     | 事项名称 | Getting started |

### 逾期任务

**名称：**app.lifeup.task.overdue

**返回值：**


| 参数      | 含义             | 示例                            |
| --------- | ---------------- | ------------------------------- |
| task_ids  | 任务id**数组**   | [1, 2, 3]                       |
| task_gids | 任务组id**数组** | [1, 2, 3]                       |
| names     | 事项名称**数组** | [Getting started, Drink Waters] |



### 解锁成就

**名称：**app.lifeup.achievement.unlock

**返回值：**

| 参数           | 含义     | 示例             |
| -------------- | -------- | ---------------- |
| achievement_id | 成就id   | 1                |
| name           | 成就名称 | 连续使用人升30天 |

### 购买商品

**名称：**app.lifeup.item.purchase

**返回值：**

| 参数    | 含义     | 示例       |
| ------- | -------- | ---------- |
| item_id | 商品id   | 1          |
| name    | 商品名称 | 休息10分支 |
| amount  | 购买数量 | 1          |

### 使用商品

**名称：**app.lifeup.item.use

**返回值：**

| 参数    | 含义     | 示例       |
| ------- | -------- | ---------- |
| item_id | 商品id   | 1          |
| name    | 商品名称 | 休息10分支 |
| amount  | 使用数量 | 1          |

### 等级提升

**名称：**app.lifeup.level.up

**返回值：**

| 参数     | 含义     | 示例 |
| -------- | -------- | ---- |
| skill_id | 任务id   | 1    |
| name     | 名称     | 力量 |
| level    | 当前等级 | 2    |

### 等级降低

**名称：**app.lifeup.level.down

**返回值：**

| 参数     | 含义     | 示例 |
| -------- | -------- | ---- |
| skill_id | 任务id   | 1    |
| name     | 名称     | 力量 |
| level    | 当前等级 | 2    |

### 商品倒计时

**名称：**

- 开始：app.lifeup.item.countdown.start
- 停止：app.lifeup.item.countdown.stop
- 完成（正常结束）：app.lifeup.item.countdown.complete

**返回值：**



| 参数      | 含义             | 示例       |
| --------- | ---------------- | ---------- |
| item_id   | 商品id           | 1          |
| name      | 商品名称         | 学习30分钟 |
| time_left | 剩余时间（毫秒） | 30000      |



---

## 联动

我们非常欢迎其他开发者任何形式的联动。

### 需要更多 API？

API 功能目前仅经过了一个版本的迭代。

未来我们会持续加入更多的 API，以满足更多的使用场景。

如果你有需要的 API 场景，可以在 [Github 留下 Issues](https://github.com/Ayagikei/LifeUp/issues/new/choose) 或者我们的 [QQ 频道](https://ti.qq.com/open_qq/index.html?url=https%3A%2F%2Fqun.qq.com%2Fqqweb%2Fqunpro%2Fshare%3F_wv%3D3%26_wwv%3D128%26appChannel%3Dshare%26inviteCode%3D1W7IRQv%26businessType%3D9%26from%3D246610%26biz%3Dka%23%2Fout)进行留言。

<br/>


### 如何调用

#### Android

```kotlin
    /**
    * 定义一个方法处理 uri
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
        // 然后在合适的地方调用即可
        call(context, "lifeup://api/toast?text=你学会了调用！&type=1&isLong=true")
        ...
    }
```

<br/>

#### 网页

网页调用的话，能否触发也依赖于浏览器。常规的浏览器如夸克、Chrome、Edge都是可以的。但一些其他的系统内置的浏览器，可能会每次弹出时提醒用户“是否打开人升”。

如果你是自己开发的内嵌 WebView 应用，需要确保 WebView 能够处理 lifeup scheme。

如果你想要保证体验一致的话，可以使用「人升」里的商品链接效果，并勾选“使用内置浏览器”打开。但由于安全设置，这种方式仅支持 HTTPS 链接（不支持 HTTP）

**HTML**

直接超链接跳转即可

```htm
<a href="lifeup://api/toast?text=你学会了调用！&amp;type=1&amp;isLong=true" target="_blank" rel="noopener">点击这里调用</a>
```

**Javascript**

其实也是调用超链接

```javascript
location.href='lifeup://api/reward?type=coin&content=Wordle没猜对，安慰奖&number=1'
```

<br/>


### 应用开发者

如果你是应用开发者，且支持与「人升」联动，实现了有趣的功能和机制。

可以联系我们在应用内互相推荐应用。

> 如需 Google Play 上架等也可联系协助。

<br/>


### 网页开发者

如果你是网页开发者，开发了调用「人升」API 的网页作品，欢迎在应用内通过商品的形式分享你的作品。

也可以联系我们进行互相推荐。

如果你的是静态网页，且不熟悉托管，也可以联系我们协助托管网页。

<br/>

### 任意支持 HTTP 协议的编程语言/平台

详情请查阅应用内-侧边栏-设置-实验-《云人升》。

<h1 align="center" padding="100">开放接口与调用</h1>

<p align="center">动手创造无限可能性！</p>





?> 在 v1.90 版本中，`人升`既开放了多种功能接口，欢迎任意外部应用联动。<br/>亦提供了商品的“链接”效果，用户可以直接使用商品来调用外部应用或者《人升》的接口。<br/>这可以使你的`人升`获得无限的可能性，但也需要你有一定的学习理解和动手能力。



**2025/08/30**

本文的 API 参数和定义基于 v1.100.0 版本编写。

使用 API 前，建议将应用升级到 v1.100.0 版本，如果没法检测到更新，请切换更新渠道到【会员内测-尝鲜版】。



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

这种触发事件，就需要使用到外部的自动化工具，或者通过编程实现。



如果是应用内的指标事件，你可以通过搭配成就来实现。

**如果你想实现，力量达到5级后，提升 ATM 利率0.01%。就可以通过功能组合实现：**

> 成就跟踪力量等级 -> 达到5级后，自动解锁成就 -> 获取特殊商品奖励 -> 使用后提升 ATM 利率。

诸如番茄钟专注时长之类的场景也能举一反三。



**人升1.90.2更新将会增加一系列「广播事件通知」，但这些事件需要由自动化工具或者外部应用接收。**

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

**以下是一些示例，你可以把这些链接添加到「人升」中任意商品的「链接」使用效果里触发，也可以直接在这里点击确认效果：**

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

**因此我们不会也没人力维护链接列表。**

**但由于「世界」-「橱窗」已支持上传链接类商品，你可以搜索橱窗是否有你想要的商品。**

<br/>

### 如何获取上述 URL 链接

> 获取其他应用的 URL 链接并不属于**人升**的功能、会员的权益或者开发者的职责，此处仅为简单介绍。

**常规方式**

- 使用网络搜索`URL Schemes`的方式搜索你需要的应用链接。
- 在「人升」`世界`-`橱窗`搜索应用，查看是否有人已经分享过链接。
- 查询对应的应用使用文档，查阅或咨询开发者有没有提供。
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



### 链接🔗

**一些例子：**

当你点击下面这个链接，「人升」会弹出提示“你学会了调用！”。

[lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true)

当你点击下面这个链接，「人升」中会获得一个金币，并且获得原因为“学习API调用”。

[lifeup://api/reward?type=coin&content=学习API调用&number=1](lifeup://api/reward?type=coin&content=学习API调用&number=1)

当你把链接复制到商品的“链接”效果中，使用商品也能够触发类似的效果。



### 外部网页🌐（Wordle）

**一个外部应用联动的例子：**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/zh-cn/example/wordle/index.html)

Wordle 是猜单词的小游戏：猜长度为 5 的单词。橙黄色代表答案的单词中包含该字母。绿色代表包含且位置正确。

**该版本的 Wordle 支持与「人升」联动：**

1. 当你猜中了单词，能够获得 10 点金币。并且有对应的获得原因。
2. 当你最终也没猜中单词，会有安慰奖 1 点金币。

![](_media/api/wordle.png ':size=30%')

<br/>

### 自动化工具-Tasker

**与 Tasker 联动的例子：**

?> Tasker 是一款付费的自动化工具，需要从 Google Play 或官网付费获取正版。如果你没有对应的渠道，也可以试试下方的 MacroDroid。

> Tasker 调用的方式是，选择`操作类别`-`程序`-`快捷方式`。在快捷方式一栏输入 lifeup:// 开头的链接即可。

每天 5 点后第一次解锁屏幕，能触发完成一个名称包含“起床”的任务。

**注意：你需要先自己创建这个名字包含“起床”的每日任务。**

如果你已经安装了 Tasker，[点击这里可以导入已经配置好的任务。](taskerproject://H4sIAAAAAAAAAKVWTW/TQBA9p78iskRPxV7biZNQxyiFHCpFCLVVLxzQKt6kWxzHsrdBvRWEVFS1KkgIIW6IigKqWi6IEvFv2qThxF9g1rv5atyKlEs8nje7fjtv3ir2Co6ekPA+ZjgdhUVFSbstWlR0Jc1aRcVSkaojxZlJ2Q/DZo16JC4KIDYNJd0iRcXgaMquupgRR7cslLFMlMnqRt7WRJLDZBQ2MlnTMG2NDOCah+uRAytEwFPUdUzD1uDB3xrURY4OBXHAM36DON2T/c7Bl4ujo/PTre7Rh97hx99vnv35tds7/NTZf9053u2+fHW2tdv7/qPT3jnb2rM1voqvLreIz+KzVJs+Gj0JHKXpAlWEEByAh7xeixfE4TID1v2letJSKztcmbLvNX2XMtr0KzQSn6Q1UT6Cif0kEVPCKdtbi5xbPnnq4k1b4y8y3wwcHZoDD5kIAbO1sF9ha4OdBQltjIU4UnwQLq0mtU2U2ZxG5qoXOCzcIJDzgknhdTNv5tE/CG9eEr6QKHz24vnP3vHB+Wm7++6k+/bbxfsXMAgADHVeoQ0ylFn0orbmgEDwK94aDjCC3/iNxRiTGIsx1hD94nsltGudVFm/Xevoym4ZOSOHCmPd8jFseN5ud/a2e9tfOzufxcQCeyzpB9SNwAZzvCFxzJOMB3p+jneFiWTMiRPhMXd0TIhBoOfHqQCJjJWxcnrBmsKfIAY3n9QkCCn3B1CCgCdK1cEM4yqTPciNeiKbKYx6YpmFojqsD2d+MOiAirJF6VEo40bDXlFBijaBGddg5jhma4JrAm09gbaZQ6O0I+LUsBfBeEcys7Dhu9It8Vmk/VahKk7Ctwdm9glTXerXPRpV11Tsu2GTuiqL7191qVwpr5YerDxeLS0tlhYq5WVn1mPz0ApYUQpDvCmuZ222zuZhQqbc62YUbrPNgDiPKuu4hVUP+3VV8JmegNhJ3k28O/JaEv2bGAp9MBQerZGN4I6m4YCCEo3AI4zc5QYpimt9MC4j0oJXgcikFwpJXkAoa6IrvYAsM1/IXfZC4f+8kLuBFxK7oyebZQpDjGGZa7CsxMwEzJKYPmGyvhLiKf5nODN/AQAzsyt1CAAA)



![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

### 自动化工具-MacroDroid

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


> 你可以通过新建`触发器 - 设备事件 - 收到 Intent`，向「动作框」中填入下方`广播事件通知`对应的名称，来调用人升中功能多样的传入广播触发功能。(intent Extra 中，Extra 名称对应`返回值参数`)
> 对于参数取值为「JSON文本」的复合型数据类型，你可以通过新建`动作 - 网络互动 - HTTP 请求`，参考开放接口中「云人升」文档中的配置信息进行配置

**通过该功能，无论你是否会开发，你都可以无限扩展人升的可能性！**

具体调用规则请看下文。

---

## 基础知识

### 基础知识 - 示例

人升的 API 是以 URL Scheme 的方式提供的。

URL（Uniform Resource Locator，统一资源定位符）是用于定位互联网上资源的地址。它的结构通常包括以下部分：

```
scheme://host/path?query
```

- scheme: 指定协议，例如 http、https 或应用自定义的 Scheme（如 lifeup://）。
- host: 资源所在的服务器地址（在自定义 URL Scheme 中可以省略）。
- path: 资源在服务器上的路径。
- query: 查询参数，通常用于传递数据。

<br/>

URL 并不算是编程语言，它只是一个描述资源的地址。跟网址其实是类似的，它也能实现跳转到 app 内的某一个页面。

在人升的 API 中，一个 URL 基本可以代表一个应用内的操作，比如以下这个示例就是让「人升」弹出一个提示：

| 类型     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 示例     | [lifeup://api/toast?text=你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=你学会了调用！&type=1&isLong=true) |
| 接口格式 | 固定前缀/方法名?参数1=数值1&参数2=数值2                      |
| 固定前缀 | lifeup://api/                                                |
| 方法名   | toast                                                        |
| 参数     | ?text=你学会了调用！&type=1&isLong=true                      |


<br/>

### 基础知识 - URL 转义（编码）

URL 中的某些字符，如空格或特殊符号，不能直接在 URL 中使用。又或者是一些符号有特殊含义：比如`&`一般作为参数的拼接，`:`、`/`是URL的基本组成成分，它们作为一个参数的值时，就需要进行转义（编码）操作，以便程序将它们认为是一个值。

为了确保 URL 可以正确传输和解析，需要对这些字符进行编码。URL 编码将这些字符转换为百分号 % 开头的编码值。


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

比如上述例子中的文本内容，如果要最终提示的文本是：`?text=你学会了调用！`

则需要替换文本中的特殊符号`?`和`=`为，最终效果为：

[lifeup://api/toast?text=%3Ftext%3D你学会了调用！&type=1&isLong=true](lifeup://api/toast?text=%3Ftext%3D你学会了调用！&type=1&isLong=true)

<br/>

!> 手动处理编码问题十分容易出错，仅适用于简单场景。复杂场景请考虑使用对应的开发工具或者库，它们将自动为你处理编码。🧑‍💻

大多数现代开发工具和库都会自动处理 URL 编码和解码，因此开发者只需确保传递的数据格式正确。

<br/>

**这是一个用 JS 实现的简单编码工具：**

这个工具会将中文、空格、各种符号编码。

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

2024/10/04更新：

由于编码方面太容易出现问题， 市面上也很少面向普通用户的URL Builder（构造工具），我们尝试使用 AI 协助开发了一款 URL 构造器。

在其中，你只需要按照 API 定义填入 API 名称、参数名称（键）和参数数值即可。

[点击这里跳转到工具](https://wiki.lifeupapp.fun/zh-cn/guide/html/url-builder-parser.html)

<br/>

### 基础知识 - URL 嵌套

有些 API 支持将 完整的 URL 作为查询参数传递，这被称为嵌套 URL。嵌套 URL 必须经过额外的**两次**URL 编码，以确保它们在整个 URL 中正确解析。具体来说，嵌套的 URL 中的特殊字符不仅需要进行常规编码，还需要对包含的 URL 本身进行额外的编码。

在这个例子中，我们希望通过 lifeup://api/random 接口，随机调用显示“石头”、“剪刀”或“布”的 toast 接口。为了实现这一目标，

1. **原始URL**

其实这是由一层嵌套实现的 API。其中作为参数的三个原始 API 为三个 `toast` API 调用，它们分别用于显示“石头”、“剪刀”和“布”：

- lifeup://api/toast?text=石头
- lifeup://api/toast?text=剪刀
- lifeup://api/toast?text=布

2. **第一次 URL 编码**

因为我们将这些 API 调用作为参数传递给 lifeup://api/random，所以需要对嵌套的 URL 进行第一次编码。主要是对特殊字符（如 :、/、? 和 =）进行编码。

- lifeup://api/toast?text=石头 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头
- lifeup://api/toast?text=剪刀 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀
- lifeup://api/toast?text=布 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布

3. **组合嵌套 URL**

接下来，将这三个编码后的 URL 作为 lifeup://api/random 的查询参数传递

```
lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布
```

<br/>

### 基础知识 - 复杂场景下 URL 应如何编写？

我们设计这套 API 的初衷是为了让社区开发者能够利用《人升》作为基础平台，进行二次开发和扩展更多的功能。例如，开发者可以获取《人升》的数据，来设计个性化的小部件、人物形象等扩展内容。

随着开发的推进，我们发现《人升》的商品和效果可以很好地与 API 融合。为了降低使用门槛，让更多用户轻松体验 API 的功能并参与开发的乐趣，我们增加了一些简化的 API 机制。这些机制让用户即便对 URL 概念了解不深，也能轻松实现一些简单的 API 调用：

- 商品调用 API（无需外部调用）
- 应用内显示数据 ID（无需通过接口获取 ID）
- 模糊搜索商品名称（ID 可选）
- 输入、随机占位符，弹窗 API（无需外部开发或自动化工具即可实现简单交互）

这些机制的目的是帮助用户「快速体验 API」，它们适用于简单的场景，而不适合复杂的条件控制或逻辑操作。如果我们在《人升》中加入过多的基础控制逻辑，它就会逐渐变成一个“自动化工具”或“编程软件”，这并非我们 API 的设计初衷。

API 的核心价值在于开放接口，主要面向外部开发，而非仅限于内部使用。它的主要应用场景包括：

- 无需编程门槛的快速体验：用户可以轻松调用商品的使用效果
- 无需编程门槛的自动化应用：通过 Tasker、Macrodroid 等自动化工具集成
- Android 开发：提供 SDK 支持
- 跨设备开发（桌面端）：支持云人升平台

<br/>

虽然这些简化机制让更多用户体验到了 API 的便利，但也带来了某些误解。为了避免错误的理解和信息传播，我们在这里做一些澄清：

> 1. URL 机制设计不合理，一会需要编码，一会又不需要编码。

URL 和编码标准是由互联网标准规定的，并非《人升》的独特设计。具体细节请参考：[https://en.wikipedia.org/wiki/Percent-encoding](https://en.wikipedia.org/wiki/Percent-encoding)

编码的需求非常明确：在 URL 中，每一个查询参数的“值”都需要进行编码。这是标准化的要求，不是偶然现象。

> 2. URL 参数顺序影响执行逻辑。

绝大多数情况下，URL 参数的顺序是无关紧要的，不会影响 API 的执行逻辑。解析是基于参数名称，而不是顺序。

目前只有随机（`random`） API 的比重参数与顺序有关。

> 3. URL 不能嵌套超过两层。

实际上，URL 可以根据需要进行多层嵌套，嵌套层级没有限制。错误的嵌套通常是因为没有正确理解 URL 规范。

> 4. URL 中的中文千万不要编码，否则会出错。

根据规范，URL 中的中文字符是需要编码的。然而，由于 Android 的 API 容错机制，即使未编码的中文也能正确解析，但为了兼容性和标准化，建议始终进行编码。

---

**建议：** 对于复杂的 URL 场景，请使用程序或工具来协助生成正确的 URL，以避免不必要的错误。如果希望更好地利用 API，建议多了解一些 URL 规范，这样能够更准确地编写和调试 API。


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

### 基础知识 - 排序依据（order）

部分 API 接口提供了排序依据（`order`）的设置字段：

`order` 字段用于确定项目在列表中的相对排序。

**注意：`order` 的数值本身并无独立意义，只有在与其他项目进行对比时才发挥作用**。

因此，更新 `order` 字段时，建议您 **同时对多个项目的 `order` 值进行交换或对整个列表的 `order` 值进行重新排序**，以确保排序结果的可预测性。

**请勿仅更新单个项目的 `order` 值**，因为这将导致排序结果不可预期。

此外，App 的内部排序逻辑可能会根据不同版本随时进行调整，单次更新 `order` 值无法保证在未来版本中的一致性或预期效果。

### 基础知识 - JSON 数据结构

?> 需要 v1.98.0+

本节介绍 API 中常用的 JSON 数据结构。

#### 1. 物品奖励结构

用于指定物品奖励的 JSON 数组，每个物品包含 ID 和数量。

```json
[
    {
        "item_id": 1,    // 物品ID
        "amount": 2      // 数量
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. 成就解锁条件结构

```json
[
    {
        "type": 7,           // 条件类型
        "related_id": null,  // 关联ID（部分类型必须提供）
        "target": 1000000    // 目标数值
    }
]
```

#### 3. 购买限制结构

```json
[
    {
        "type": "daily",     // 限制类型：daily（每日）、total（总计）
        "value": 5           // 限制数量
    }
]
```

#### 4. 商品效果结构

```json
[
    {
        "type": 2,           // 效果类型
        "info": {            // 效果参数，根据type不同而不同
            "min": 100,      // 最小值（用于金币奖励等）
            "max": 200       // 最大值（用于金币奖励等）
        }
    }
]
```

#### 效果类型说明

| 类型代码 | 含义 | 参数说明 |
| ------- | ---- | ------- |
| 0 | 无特殊效果 | 无需参数 |
| 1 | 不可使用 | 无需参数 |
| 2 | 增加金币 | min: 最小金币数<br/>max: 最大金币数（可选，不填则等于min） |
| 3 | 减少金币 | min: 最小金币数<br/>max: 最大金币数（可选，不填则等于min） |
| 4 | 增加经验值 | ids: 技能ID数组<br/>value: 经验值<br/>using_limit: 是否使用限制（可选，默认false） |
| 5 | 减少经验值 | ids: 技能ID数组<br/>value: 经验值<br/>using_limit: 是否使用限制（可选，默认false） |
| 6 | 简易合成 | require_number: 需求数量<br/>item_id: 物品ID |
| 7 | 开箱 | items: 物品数组，每个物品包含：<br/>- item_id: 物品ID<br/>- amount: 数量<br/>- probability: 概率<br/>- is_fixed_reward: 是否固定奖励 |
| 8 | 倒计时 | seconds: 倒计时秒数 |
| 9 | 网页链接 | url: 链接地址<br/>use_web_view: 是否使用内置浏览器（可选，默认false） |

**效果示例：**

增加随机金币：
```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

增加经验值：
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

开箱效果：
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

## 接口文档

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

### 编辑金币

**方法名：**edit_coin

**说明：**直接编辑用户的金币余额。金币数量将被设置为指定的值。变更原因可自定义，并将显示在金币历史记录中。

**示例：**

- 将金币设置为1000，原因为"API调整"：<a href="lifeup://api/edit_coin?coin=1000&content=API调整">lifeup://api/edit_coin?coin=1000&content=API调整</a>
- 静默将金币设置为500：<a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| 参数 | 含义 | 取值 | 示例 | 是否必须 | 备注 |
| ---- | ---- | ---- | ---- | -------- | ---- |
| coin | 目标金币数量 | 大于等于0的数字 | 1000 | 是 | 操作后的最终金币余额，最大值为999999 |
| content | 变更原因 | 任意文本 | API调整 | 否 | 如未提供则使用系统默认原因 |
| reason | 变更原因（别名） | 任意文本 | API调整 | 否 | content参数的别名 |
| silent | 禁用UI通知 | true或false | false | 否 | 默认为false，设置为true时不显示提示消息 |


<br/>

### 任务

#### 添加任务

?> 部分参数需要 v1.98.0+

**方法名：**add_task

**说明：**直接添加一个任务

**示例：**
[lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金币](lifeup://api/add_task?todo=这是自动添加的任务&notes=备注&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金币)

| 参数             | 含义           | 取值                | 示例       | 是否必须 | 备注                           |
| --------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| todo            | 任务内容       | 任意文本           | 写日记     | 是       |                               |
| notes           | 备注           | 任意文本           | 备注       | 否       | 默认为空                       |
| coin            | 金币奖励       | 大于等于0的数字    | 10        | 否       | 默认为 0，受系统限制约束        |
| coin_var        | 金币奖励浮动值  | 大于等于 0 的数字  | 1         | 否       | 默认为 0；如大于 0，则在 [coin, coin+coin_var] 范围内随机 |
| exp             | 经验值奖励     | 大于等于0的数字    | 100       | 否       | 默认为 0，受系统限制约束        |
| skills          | 技能ID         | 大于 0 的数字数组   | 1         | 否       | 支持数组（如 &skills=1&skills=2）|
| category        | 清单ID         | 大于等于 0 的数字   | 0         | 否       | 默认为 0（默认清单）；不能选择智能清单 |
| frequency       | 重复频次       | 整数               | 0         | 否       | 默认为 0（单次）<br/>0 - 单次<br/>1 - 每日<br/>N (N>1) - 每 N 日<br/>-1 - 无限<br/>-3 - 艾宾浩斯（需v1.99.1）<br/>-4 - 每月<br/>-5 - 每年 |
| importance      | 重要程度       | [1, 4]            | 1         | 否       | 默认为 1                       |
| difficulty      | 困难程度       | [1, 4]            | 1         | 否       | 默认为 1                       |
| deadline        | 截止时间       | 时间戳（毫秒）     | 1640995200000 | 否    |                               |
| color           | 标签颜色       | 颜色字符串         | #66CCFF    | 否       | #需要转义为%23                 |
| background_url  | 背景图片URL    | 网络地址URL        | http://example.com/bg.jpg | 否 | 必须是可访问的网络图片地址    |
| background_alpha| 背景透明度     | [0, 1] 之间的浮点数 | 0.5        | 否      | 默认为 1.0                    |
| enable_outline  | 启用文字轮廓   | true 或者 false    | false      | 否       | 仅当设置 background_url 时有效，为文字添加轮廓以提高可读性 |
| use_light_remark_text_color | 使用浅色备注文字 | true 或者 false | false | 否 | 仅当设置 background_url 时有效，使用浅色显示备注文字 |
| start_time      | 开始时间       | 时间戳（毫秒）     | 1640995200000 | 否     | 任务开始时间                  |
| auto_use_item   | 自动使用奖励物品| true 或者 false   | false      | 否       | 完成任务时自动使用奖励物品      |
| remind_time     | 提醒时间       | 时间戳（毫秒）     | 1640995200000 | 否    | 任务提醒时间                  |
| pin             | 置顶           | true 或者 false    | false     | 否       | 将任务置顶显示                 |
| words           | 完成激励语     | 任意文本           | 太棒了！   | 否       | 任务完成时显示的激励文本       |
| frozen          | 是否冻结       | true 或者 false    | false     | 否       | 默认为 false                   |
| freeze_until    | 冻结截止时间   | 时间戳（毫秒）     | 1640995200000 | 否    | 仅当 frozen 为 true 时生效     |
| coin_penalty_factor | 金币惩罚系数| [0, 100) 之间的浮点数 | 0.5    | 否       |                               |
| exp_penalty_factor | 经验惩罚系数 | [0, 100) 之间的浮点数 | 0.5    | 否       |                               |
| write_feelings  | 是否启用感想   | true 或者 false    | false     | 否       | 默认为 false                   |
| item_id         | 物品ID         | 大于 0 的数字      | 1         | 否*      | 与 item_name 必须提供其中一个   |
| item_name       | 物品名称       | 任意文本           | 宝箱      | 否*      | 与 item_id 必须提供其中一个     |
| item_amount     | 物品数量       | [1, 99]           | 1         | 否       | 默认为 1                       |
| items           | 物品奖励       | JSON文本           | 参见[物品奖励结构](#1-物品奖励结构) | 否 | 可一次性设置多个物品奖励 |
| task_type       | 任务类型       | [0, 3]            | 0         | 否       | 需v1.99.1, 0 - 普通任务<br/>1 - 计数任务<br/>2 - 负面任务<br/>3 - API任务 |
| target_times    | 目标次数       | 大于0的整数        | 1         | 否       | 仅当 task_type 为1(计数任务)时有效 |
| is_affect_shop_reward | 是否影响商店奖励 | true/false      | false    | 否       | 当 task_type 为1(计数任务)时有效，是否影响商品的奖励计算         |


**返回数据：**

| 字段名   | 类型   | 说明       | 示例 | 备注             |
| -------- | ------ | ---------- | ---- | ---------------- |
| task_id  | 数字   | 任务ID     | 1000 |                  |
| task_gid | 数字   | 任务组ID   | 1000 |                  |

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

| 参数                      | 含义                     | 取值                                     | 示例     | 是否必须 | 备注                                                         |
| ------------------------- | ------------------------ | ---------------------------------------- | -------- | -------- | ------------------------------------------------------------ |
| id                        | 任务id                   | 大于 0 的数字                            | 1        | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。               |
| gid                       | 任务组id                 | 大于 0 的数字                            | 1        | 否*      | 任务组id；                                                   |
| name                      | 名称                     | 任意文本                                 | 睡觉     | 否*      | 模糊搜索，只会完成搜索到的其中一个任务                       |
| ui                        | 是否展示弹窗UI           | true 或 false                            | true     | 否       | 默认为 false，只在后台显示一条消息                           |
| 以下参数引入自v1.94.0版本 |                          |                                          |          |          |                                                              |
| count                     | 计数值                   | 数字                                     | 1        | 否       | 仅适用于计数任务，请搭配`count_set_type`参数使用             |
| count_set_type            | 如何设置计数值           | 以下数值其一：<br/>absolute<br/>relative | absolute | 否       | 默认值为relative<br/>absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，在原数值的基础上增加或减少 |
| count_force_sum_up        | 是否强制结算计数任务奖励 | true 或 false                            | true     | 否       |                                                              |
| reward_factor             | 奖励系数                 | 大于0的浮点数                            | 1.1      | 否       | 不适用于计数任务<br/>奖励系数会影响奖励的经验值、金币数值（暂不影响商品数量） |

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
2. 已经完成的任务不可删除。

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

### 编辑任务

?> 需要 v1.98.0+

**方法名：**edit_task

**说明：**编辑已有任务的内容和属性

**示例：**
[lifeup://api/edit_task?id=1&todo=修改后的任务内容&notes=备注&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=修改后的任务内容&notes=备注&coin=10&exp=20&skills=1&skills=2&category=0)

| 参数                | 含义           | 取值                | 示例     | 是否必须 | 备注                           |
| ------------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| id                 | 任务ID         | 大于 0 的数字      | 1        | 否*      | id、gid、name 必须提供其中一个  |
| gid                | 任务组ID       | 大于 0 的数字      | 1        | 否*      | id、gid、name 必须提供其中一个  |
| name               | 任务名称       | 任意文本           | 写日记    | 否*      | id、gid、name 必须提供其中一个  |
| todo               | 任务内容       | 任意文本           | 写周记    | 否       |                               |
| notes              | 备注           | 任意文本           | 备注内容  | 否       |                               |
| coin               | 金币奖励       | 大于等于0的数字     | 10       | 否       | 完成任务获得的金币数量，受系统限制约束         |
| coin_var           | 金币浮动值     | 大于 0 的数字      | 1        | 否       | 奖励将在 [coin, coin+coin_var] 范围内随机 |
| exp                | 经验值奖励     | 大于等于0的数字     | 20       | 否       | 完成任务获得的经验值，受系统限制约束           |
| skills             | 技能ID         | 大于 0 的数字数组   | 1        | 否       | 支持数组（如 &skills=1&skills=2）|
| category           | 列表ID         | 大于或等于 0 的数字 | 0        | 否       | 0 表示默认列表，不能选择智能列表 |
| frequency       | 重复频次       | 整数               | 0         | 否       | 默认为 0（单次）<br/>0 - 单次<br/>1 - 每日<br/>N (N>1) - 每 N 日<br/>-1 - 无限<br/>-3 - 艾宾浩斯（需v1.99.1）<br/>-4 - 每月<br/>-5 - 每年 |
| importance         | 重要程度       | [1, 4]            | 1        | 否       | 默认为 1                       |
| difficulty         | 难度等级       | [1, 4]            | 2        | 否       | 默认为 1                       |
| deadline           | 截止时间       | 时间戳（毫秒）     | 1640995200000 | 否 |                               |
| remind_time        | 提醒时间       | 时间戳（毫秒）     | 1640995200000 | 否 |                               |
| start_time         | 开始时间       | 时间戳（毫秒）     | 1640995200000 | 否 |                               |
| color              | 标签颜色       | 颜色字符串         | #66CCFF  | 否       | #需要转义为%23                 |
| background_url     | 背景图片URL    | 网络地址URL        | http://example.com/bg.jpg | 否 |                    |
| background_alpha   | 背景透明度     | [0, 1] 之间的浮点数 | 0.5      | 否       |                               |
| enable_outline     | 启用文字轮廓   | true 或者 false    | false    | 否       | 仅当设置 background_url 时有效，为文字添加轮廓以提高可读性 |
| use_light_remark_text_color | 使用浅色备注文字 | true 或者 false | false | 否 | 仅当设置 background_url 时有效，使用浅色显示备注文字 |
| item_id            | 物品ID         | 大于 0 的数字      | 1        | 否*      | 与 item_name 必须提供其中一个  |
| item_name          | 物品名称       | 任意文本           | 宝箱      | 否*      | 与 item_id 必须提供其中一个    |
| item_amount        | 物品数量       | [1, 99]           | 1        | 否       | 默认为 1                       |
| items              | 物品奖励JSON   | JSON文本           | [{"item_id":1,"amount":1}] | 否 | 可一次设置多个物品奖励 |
| auto_use_item      | 自动使用物品   | true 或者 false    | false    | 否       |                               |
| frozen             | 是否冻结       | true 或者 false    | false    | 否       | 默认为 false                  |
| freeze_until       | 冻结截止时间   | 时间戳（毫秒）     | 1640995200000 | 否 | 仅当 frozen 为 true 时生效    |
| coin_penalty_factor| 金币惩罚系数   | [0, 100) 之间的浮点数 | 0.5    | 否       |                               |
| exp_penalty_factor | 经验惩罚系数   | [0, 100) 之间的浮点数 | 0.5    | 否       |                               |
| write_feelings     | 是否启用感想   | true 或者 false    | false    | 否       |                               |
| pin                | 是否置顶       | true 或者 false    | false    | 否       |                               |
| words              | 完成激励语     | 任意文本           | 太棒了！  | 否       | 任务完成时显示的激励文本       |
| task_type       | 任务类型       | [0, 3]            | 0         | 否       | 需v1.99.1, 0 - 普通任务<br/>1 - 计数任务<br/>2 - 负面任务<br/>3 - API任务 |
| target_times    | 目标次数       | 大于0的整数        | 1         | 否       | 仅当 task_type 为1(计数任务)时有效 |
| is_affect_shop_reward | 是否影响商店奖励 | true/false      | false    | 否       | 当 task_type 为1(计数任务)时有效，是否影响商品的奖励计算         |
| coin_set_type     | 如何设置金币值 | One of:<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置金币为 value<br/>relative - 在原金币值的基础上增加或减少 |
| exp_set_type      | 如何设置经验值 | One of:<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置经验值为 value<br/>relative - 在原经验值的基础上增加或减少 |

**返回数据：**

| 字段名    | 类型   | 说明       | 示例 | 备注             |
| --------- | ------ | ---------- | ---- | ---------------- |
| task_id   | 数字   | 任务ID     | 1000 |                  |
| task_gid  | 数字   | 任务组ID   | 1000 |                  |

<br/>

### 历史任务操作

?> 需要 v1.98.0+

**方法名：**history_operation

**说明：**对已完成/已放弃/已过期的任务进行操作

**示例：**
- 删除历史任务：[lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- 将任务标记为放弃：[lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- 重新开始任务：[lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> 此 API 仅适用于非未完成状态的任务（已完成、已放弃或已过期）

| 参数           | 含义           | 取值                | 示例     | 是否必须 | 备注                           |
| ------------- | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| id            | 任务ID         | 大于 0 的数字      | 1        | 是       | 历史任务的ID                   |
| operation     | 操作类型       | 以下数值其一：<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | 是 | delete - 删除任务<br/>complete - 标记为已完成<br/>undo_complete - 撤销完成<br/>set_to_give_up - 标记为放弃<br/>set_to_overdue - 标记为过期<br/>edit_completed_time - 修改完成时间<br/>restart - 重新开始任务 |
| completed_time | 完成时间       | 时间戳（毫秒）     | 1640995200000 | 否* | 仅当 operation 为 edit_completed_time 时必须提供 |

**返回数据：**

| 字段名   | 类型   | 说明     | 示例 | 备注             |
| -------- | ------ | -------- | ---- | ---------------- |
| task_id  | 数字   | 任务ID   | 1000 | 操作的任务ID     |

<br/>

### 商店设置

**方法名：**shop_settings

**说明：**调整各种商店设置

**示例：**

- 将ATM利率设置为0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- 每次点击将利率提升0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| 参数     | 含义                     | 取值                                                         | 示例         | 是否必须 | 备注                                                         |
| -------- | ------------------------ | ------------------------------------------------------------ | ------------ | -------- | ------------------------------------------------------------ |
| key      | 类型                     | 目前仅支持：<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | 是       | atm_interest - ATM日利率<br/>credit_interest - 贷款日利率<br/>line_of_credit - 可贷款金额<br/>discount_rate_for_returning - 退货打折比例<br/>atm_balance - ATM 余额 |
| value    | 数值                     | 浮点数（小数点）                                             | 0.01         | 是       | 不同的 key 对应不同的数值范围<br/>比如 ATM 余额不支持小数点  |
| set_type | 如何设置数值             | 以下数值其一：<br/>absolute<br/>relative                     | absolute     | 否       | absolute - 绝对取值，即直接将目标设置为 value<br/>relative - 相对取值，在原数值的基础上增加或减少 |
| silent   | 是否沉默执行（不显示UI） | 布尔值                                                       | false        | 否       | 仅 v1.93.0-beta01（502）+ 支持<br/>默认为 false，即会显示 UI 提示 |

<br/>

### 跳转

**方法名：**goto

**说明：**跳转「人升」中的某个页面

**示例：**[lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**解释：**跳转到实验页面

| 参数 | 含义 | 取值                                                         | 示例 | 是否必须 | 备注                                                         |
| ---- | ---- | ------------------------------------------------------------ | ---- | -------- | ------------------------------------------------------------ |
| page | 页面 | 固定以下数值其一：<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>dlc<br/>pomodoro_record<br/>synthesis - 合成<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>new_default<br/>achievement_list - 成就清单<br/>user_achievement - 具体某个成就清单，见下文<br/> | lab  | 是       | `purchase_dialog`指购买弹窗<br/>`use_item_dialog`指使用商品弹窗<br/>其他的都是具体的大页面 |


#### 1. 跳转商品购买/使用弹窗

> `use_item_dialog`参数引入自v1.94.0版本

当 `page` 参数为 `purchase_dialog`或`use_item_dialog`时，你可以指定商品id：

示例如：`lifeup://api/goto?page=purchase_dialog&id=1`

| 参数 | 含义   | 取值          | 示例 | 是否必须 | 备注   |
| ---- | ------ | ------------- | ---- | -------- | ------ |
| id   | 商品id | 大于 0 的数字 | 1    | 是       | 商品id |

<br/>

#### 2. 跳转首页的子页面

当 `page` 参数为 `main`时，你还可以额外指定跳转的子页面：

示例如，跳转到商店页面：`lifeup://api/goto?page=main&sub_page=shop`

| 参数        | 含义       | 取值                                                         | 示例 | 是否必须 | 备注                                                         |
| ----------- | ---------- | ------------------------------------------------------------ | ---- | -------- | ------------------------------------------------------------ |
| sub_page    | 子页面名称 | 固定以下数值其一：<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop | 否       |                                                              |
| category_id | 清单id     | 数字                                                         | 0    | 否       | 如果`sub_page`为含清单列表的页面，则可以指定跳转的清单id。<br/>如商店清单、仓库清单、任务清单。 |

#### 3. 跳转任务详情

当 `page` 参数为 `task_detail`时，你还可以额外指定跳转的任务 id：

示例如，跳转到指定任务 id 为 53 的详情页面：`lifeup://api/goto?page=task_detail&task_id=53`

| 参数      | 含义     | 取值     | 示例 | 是否必须 | 备注                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| task_id   | 任务id   | 任务id   | 53   | 否*      | 任务id；如果是重复任务，每次重复，id都会更新。 |
| task_gid  | 任务组id | 任务组id | 3    | 否*      | 任务组id                                       |
| task_name | 任务名称 | 字符串   | 早起 | 否*      | 任务名称，模糊匹配一个。                       |

**注意：**

1. 三个参数只需要提供其中之一。
   - 如果同时提供多个，会有内部的优先级顺序。但这属于未定义行为，APP 不会保证顺序。


#### 4. 跳转新建成就页面

当 `page` 参数为 `add_achievement`时，你还**需要**额外指定跳转的清单 id：

示例如，跳转到指定清单 id 为 1 的新建成就页面：`lifeup://api/goto?page=add_achievement&category_id=1`

| 参数      | 含义     | 取值     | 示例 | 是否必须 | 备注                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 成就清单id   | 成就清单id   | 1   | 是      |  |

#### 5. 跳转具体的成就清单页面

当 `page` 参数为 `user_achievement`时，你还**需要**额外指定跳转的清单 id：

示例如，跳转到指定清单 id 为 1 的成就清单页面：`lifeup://api/goto?page=user_achievement&category_id=1`

| 参数      | 含义     | 取值     | 示例 | 是否必须 | 备注                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 成就清单id   | 成就清单id   | 1   | 是      |  |

#### 6. 跳转具体的合成清单页面

当 `page` 参数为 `synthesis`时，你还**可选**额外指定跳转的清单 id：

示例如，跳转到指定清单 id 为 1 的合成清单页面：`lifeup://api/goto?page=synthesis&category_id=1`

| 参数      | 含义     | 取值     | 示例 | 是否必须 | 备注                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 合成清单id   | 合成清单id   | 1   | 否      |  |




<br/>

### 商品

#### 添加商品

?> 部分参数需要 v1.98.0+，比如`effects`、`purchase_limit`

**方法名：**add_item

**说明：**创建商品，包含自定义购买限制和使用效果等功能

**示例：**[lifeup://api/add_item?name=休息10分钟&desc=去好好休息一小段时间吧！&price=10&action_text=休息](lifeup://api/add_item?name=休息10分钟&desc=去好好休息一小段时间吧！&price=10&action_text=休息)

| 参数             | 含义           | 取值                | 示例         | 是否必须 | 备注                           |
| --------------- | -------------- | ------------------ | ------------ | -------- | ------------------------------ |
| name            | 商品名称       | 任意文本           | 休息10分钟    | 是      |                                |
| desc            | 描述           | 任意文本           | 休息一下      | 否       |                               |
| icon            | 图标           | 网络地址URL        | http://...    | 否      | 必须是网络URL地址              |
| price           | 价格           | [0, 999999]       | 10            | 否      | 默认为 0                       |
| stock_number    | 库存数量       | [-1, 99999]       | -1            | 否      | -1 表示无限                    |
| action_text     | 使用按钮文案   | 任意文本           | 休息          | 否      |                                |
| disable_purchase| 禁止购买       | true 或者 false    | false         | 否      | 默认为 false                   |
| disable_use     | 禁止使用       | true 或者 false    | false         | 否      | 默认为 false                   |
| category        | 分类ID         | 大于或等于 0 的数字 | 0             | 否      | 0 表示默认分类                 |
| order           | 显示顺序       | 整数              | 1             | 否       | 在分类中的排序位置              |
| purchase_limit  | 购买限制       | JSON文本          | 参见[购买限制结构](#3-购买限制结构) | 否 | 限制购买频率 |
| effects         | 使用效果       | JSON文本          | 参见[商品效果结构](#4-商品效果结构) | 否 | 使用商品时的效果 |
| own_number      | 初始拥有数量   | 整数              | 0             | 否       | 设置初始库存数量               |
| unlist          | 从商店隐藏     | true 或者 false   | false         | 否       | 默认为 false                   |

**返回数据：**

| 字段名   | 类型   | 说明       | 示例  | 备注             |
| -------- | ------ | ---------- | ----- | ---------------- |
| item_id  | 数字   | 商品ID     | 1000  | 创建的商品ID     |

!> effects 参数会覆盖 disable_use 的设置。如果您设置了 effects 指定商品不可使用，disable_use 将被忽略。

<br/>


#### 调整商品

?> 需要 v1.98.0+

**方法名：**item

**说明：**对现有商品进行修改，包括价格、库存、效果等各项属性

**示例：**
- 调整价格：[lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- 修改效果：[lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
    - effect 参数的编码前内容为：`[{"type":2,"info":{"min":100,"max":200}}]`

| 参数              | 含义           | 取值                | 示例       | 是否必须 | 备注                           |
| ---------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| id               | 商品ID         | 大于 0 的数字      | 1          | 否*      | id 和 name 必须提供其中一个    |
| name             | 商品名称       | 任意文本           | 宝箱       | 否*      | 用于模糊搜索商品，不是用于改名 |
| set_name         | 修改名称       | 任意文本           | 宝箱       | 否       | 不可为空                       |
| set_desc         | 修改描述       | 任意文本           | 获得礼物   | 否       |                               |
| set_icon         | 修改图标       | URL文本            | http://... | 否       | 必须是网络URL地址              |
| set_price        | 调整价格       | 整数               | 1          | 否       |                               |
| set_price_type   | 价格调整方式   | absolute 或 relative | relative | 否       | absolute-直接设置<br/>relative-增减值 |
| own_number       | 调整拥有数量   | 整数               | 1          | 否       | 使用relative时支持负数         |
| own_number_type  | 拥有数调整方式 | absolute 或 relative | relative | 否       | absolute-直接设置<br/>relative-增减值 |
| stock_number     | 调整库存数量   | [-1, 99999]       | 1          | 否       | -1表示无限库存                 |
| stock_number_type| 库存调整方式   | absolute 或 relative | relative | 否       | absolute-直接设置<br/>relative-增减值 |
| disable_purchase | 禁止购买       | true 或者 false    | false      | 否       | 默认为 false                   |
| disable_use      | 禁止使用       | true 或者 false    | false      | 否       | 默认为 false                   |
| action_text      | 使用按钮文案   | 任意文本           | 使用       | 否       |                               |
| title_color_string| 标题颜色      | 颜色字符串         | #66CCFF    | 否       | #需要转义为%23<br/>传空值可恢复默认 |
| effects          | 使用效果       | JSON文本           | 参见[商品效果结构](#4-商品效果结构) | 否 | 设置商品使用效果 |
| purchase_limit   | 购买限制       | JSON文本           | 参见[购买限制结构](#3-购买限制结构) | 否 | 限制购买频率 |
| category_id      | 所属分类ID     | 大于等于 0 的数字  | 1          | 否       | 0表示默认分类                  |
| order            | 显示顺序       | 整数               | 1          | 否       | 在分类中的排序位置             |
| unlist           | 下架商品       | true 或者 false    | false      | 否       | 默认为 false                   |

!> id 和 name 参数必须提供其中一个，用于定位要修改的商品

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

#### 使用商品

?> 该 API 于 v1.93.0-beta01（502）版本更新引入。

**方法名：**use_item

**说明：**创建商品，图标仅支持网络地址，暂不支持自定义使用效果。

**示例：**

- 打开一个金币箱：[lifeup://api/use_item?name=金币箱&use_times=1](lifeup://api/use_item?name=金币箱&use_times=1)

| 参数      | 含义       | 取值          | 示例   | 是否必须 | 备注                                                         |
| --------- | ---------- | ------------- | ------ | -------- | ------------------------------------------------------------ |
| id        | 商品id     | 大于 0 的数字 | 1      | 否*      | 获取方式请查看上文 「基础知识 - 人升数据 ID」                |
| name      | 商品名称   | 任意文本      | 金币箱 | 否*      | 用于未知 id 时，模糊搜索商品，并非修改名称                   |
| use_times | 使用的次数 | 大于 0 的数字 | 1      | 否       | 默认为 1 次<br/>对于普通商品、开箱而言，对应商品的数量<br/>对于简易合成商品，该值对应的是【合成数量】，而非消耗的商品数量 |

**返回值：**

!> 该 API 可能会由于部分原因失败，部分特殊失败原因会以返回值的形式提供。

| 参数   | 含义     | 取值 | 示例             | 是否必须 | 备注                                                         |
| ------ | -------- | ---- | ---------------- | -------- | ------------------------------------------------------------ |
| result | 结果码   | 数字 | 0                | 是       | 0 - 使用成功<br/>1- 数据库异常<br/>2 - 经验值不足限制<br/>3 - 找不到商品<br/>4 - 运行倒计时冲突<br/>5 - 库存不足 |
| desc   | 结果描述 | 文本 | RunningCountDown | 是       |                                                              |



<br/>

### ATM

?> 该 API 于 v1.91 +版本更新引入。

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

### 番茄记录

#### 添加番茄记录

**方法名：**add_pomodoro

**说明：**添加番茄计时记录

**示例：**

- 添加时长为 25 分钟（1500000 毫秒）的计时记录，并指向名称包含学习的任务：[lifeup://api/add_pomodoro?task_name=学习&duration=1500000](lifeup://api/add_pomodoro?task_name=学习&duration=1500000)
- 添加2022-08-01 11:00:00 - 2022-08-01 12:00:00 的计时记录：[lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**解释：**

任务id/任务组id的解释可以查看上文的「完成任务」接口。



| 参数            | 含义                   | 取值                          | 示例          | 是否必须 | 备注                                          |
| --------------- | ---------------------- | ----------------------------- | ------------- | -------- | --------------------------------------------- |
| start_time      | 计时开始时间           | 时间戳                        | 1659322800000 | 否*      | 可以百度了解时间戳的定义                      |
| duration        | 专注时长               | 数字（毫秒）<br/>需大于 30000 | 1500000       | 否*      | -                                             |
| end_time        | 计时结束时间           | 时间戳                        | 1659326400000 | 否*      | -                                             |
| reward_tomatoes | 是否奖励番茄           | true 或者 false               | true          | 否       | 默认为 false                                  |
| task_id         | 任务id                 | 大于 0 的数字                 | coin          | 否       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| task_gid        | 任务组id               | 大于 0 的数字                 | 备注          | 否       | 获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| task_name       | 名称                   | 任意文本                      | 10            | 否       | 模糊搜索，只会搜索到的其中一个任务            |
| ui              | 是否展示奖励番茄数的UI | true 或者 false               | true          | 否       | v1.94.0 引入，默认为 true                     |

**注意：**

1. start_time, duration, end_time 必须提供其一。
2. 在只有 duration 的情况下，会默认 end_time 为当前时间。
3. end_time 需要大于  start_time。
4. duration 至少为 30000 毫秒（30秒）。
5. 如果同时提供了 start_time, duration, end_time，duration 应该比 (end_time - start_time) 小或相等。

<br/>

#### 编辑番茄记录

> 该方法引入自v1.94.0

**方法名：**edit_pomodoro

**说明：**编辑现有的番茄计时记录或添加新的记录，如果提供有效的 `edit_item_id`。

**示例：**

- 编辑指定 ID 的记录，设置时长为 45 分钟（2700000 毫秒），并奖励番茄：[lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- 根据开始和结束时间编辑记录：[lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**参数：**

| 参数            | 含义                   | 取值            | 示例          | 是否必须 | 备注                                        |
| --------------- | ---------------------- | --------------- | ------------- | -------- | ------------------------------------------- |
| task_id         | 任务 ID                | 大于 0 的数字   | 101           | 否       | 任务的唯一标识                              |
| task_gid        | 任务组 ID              | 大于 0 的数字   | 5             | 否       | 如果提供，会覆盖 task_id                    |
| task_name       | 任务名称               | 任意文本        | 学习          | 否       | 如果 task_id 或 task_gid 不提供，则必须提供 |
| start_time      | 计时开始时间           | 时间戳          | 1659322800000 | 否*      | 可以百度了解时间戳的定义                    |
| end_time        | 计时结束时间           | 时间戳          | 1659326400000 | 否*      | -                                           |
| duration        | 专注时长               | 数字（毫秒）    | 2700000       | 否*      | 至少为 30000 毫秒（30秒）                   |
| reward_tomatoes | 是否奖励番茄           | true 或者 false | true          | 否       | 默认为 false                                |
| edit_item_id    | 编辑项的 ID            | 大于 0 的数字   | 123           | 是       | 指定编辑的记录 ID                           |
| ui              | 是否展示奖励番茄数的UI | true 或者 false | true          | 否       |                                             |

**返回值：**

| 参数     | 含义                 | 取值 | 示例 | 是否必须 | 备注                     |
| -------- | -------------------- | ---- | ---- | -------- | ------------------------ |
| tomatoes | 此次操作获得的番茄数 | 数字 | 2    | 否       | 如果 `ui` 为 true 时返回 |

**注意：**

1. `start_time`, `end_time`, `duration` 必须至少提供一个。
2. `end_time` 需要大于 `start_time`。
3. `duration` 应该小于或等于 (`end_time` - `start_time`)。
4. 如果提供 `edit_item_id` 且找到对应记录进行编辑；否则根据其他参数创建新记录。

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

### 编辑经验值

?> 该 API 于 v1.93.0-beta01（502）版本更新引入。

**方法名：**edit_exp

**说明：**该 API 能批量设置属性的当前经验值，能直接设置某个经验值或者某个等级。

**示例：**

> 该 API 会影响数据，为避免误触，此处不提供点击跳转。

- 将【力量】、【学识】属性的经验值重置为0：[lifeup://api/edit_exp?skills=1&skills=2&exp=0](lifeup://api/edit_exp?skills=1&skills=2&exp=0)
- 将【魅力】经验值直接调整为50级：[lifeup://api/edit_exp?skills=3&level=50](lifeup://api/edit_exp?skills=3&level=50)

| 参数   | 含义           | 取值                         | 示例 | 是否必须                               | 备注                                                         |
| ------ | -------------- | ---------------------------- | ---- | -------------------------------------- | ------------------------------------------------------------ |
| skills | 属性（技能）id | 大于 0 的数字数组            | 1    | 否                                     | 支持数组（即&skills=1&skills=2&skills=3）<br/>获取方式请查看上文 「基础知识 - 人升数据 ID」 |
| exp    | 设置的经验值   | 大于或等于 0 的数字（int32） | 9999 | 否<br/>但 exp和 level 必须提供其中一个 |                                                              |
| level  | 设置的等级     | 大于或等于 0 的数字（int32） | 50   | 否<br/>但 exp和 level 必须提供其中一个 | 代表某个等级起始的经验值<br/>并且会受自定义等级梯度的影响    |

<br/>

### 感想

?> 该 API 于 v1.93.4（536）版本更新引入。

**方法名：**feeling

**说明：**创建或更新感想。

**示例：**

- 创建一个新的感想：[lifeup://api/feeling?content=开心&time=1633036800](lifeup://api/feeling?content=开心&time=1633036800)
- 更新特定 id 的感想，并标记为收藏状态：[lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)


| 参数        | 含义       | 取值          | 示例       | 是否必须 | 备注                                                                                                   |
| ----------- | ---------- | ------------- | ---------- | -------- |------------------------------------------------------------------------------------------------------|
| id          | 感想记录id | 大于 0 的数字 | 1          | 否       | 如果提供，则用于更新特定记录                                                                                       |
| content     | 内容       | 任意文本      | 快乐       | 否       | 用于创建记录或更新记录的内容                                                                                       |
| time        | 时间戳     | Unix 时间戳   | 1633036800 | 否       | 记录的时间，默认为当前时间                                                                                        |
| is_favorite | 是否收藏   | true 或 false | true       | 否       | 标记记录是否为收藏                                                                                            |
| relate_type | 关联类型   | 数字 0-2      | 1          | 否       | 指定记录的关联类型<br/>0：任务<br/>1：自定义成就<br/>2：无关联                                                             |
| relate_id   | 关联id     | 大于 0 的数字 | 2          | 否       | 指定记录的关联id<br/>当 relate_type 为 0 时，代表任务 id<br/>当 relate_type 为 1 时，代表成就 id<br/>当 relate_type 为 2，无需提供 |

**注意：**

1. 如果提供 `id` 参数，则方法会尝试更新对应的感想记录。如果没有找到相应的记录，将抛出异常。
2. 如果不提供 `id`，但提供了 `content`，则方法会创建一个新的感想记录。

<br/>

### 番茄数量

?> 需要 v1.98.0+

**方法名：**tomato

**说明：**调整番茄数量（增加、减少或设置指定数量）

**示例：**
- 增加1个番茄：[lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- 减少2个番茄：[lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- 设置番茄数为10：[lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| 参数   | 含义     | 取值                                           | 示例     | 是否必须 | 备注                                                    |
| ------ | -------- | ---------------------------------------------- | -------- | -------- | ------------------------------------------------------- |
| action | 操作类型 | 以下值之一：<br/>increase<br/>decrease<br/>set | increase | 否       | increase - 增加番茄数（默认）<br/>decrease - 减少番茄数<br/>set - 设置番茄数为指定值 |
| number | 数量     | 整数                                           | 1        | 是       | 根据 action 不同含义不同：<br/>increase/decrease - 增加/减少的数量<br/>set - 设置的目标数量 |

**返回数据：**

| 字段名   | 类型 | 说明         | 示例 |
| -------- | ---- | ------------ | ---- |
| tomatoes | 整数 | 当前番茄总数 | 10   |


<br/>

### 购买物品

?> 需要 v1.98.0+

**方法名：**purchase_item

**说明：**购买指定的商品

**示例：**
- 购买ID为1的商品：[lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- 购买名称为"生命药水"的商品：[lifeup://api/purchase_item?name=生命药水](lifeup://api/purchase_item?name=生命药水)
- 购买5个ID为1的商品：[lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

| 参数              | 含义     | 取值              | 示例       | 是否必须 | 备注                            |
| ---------------- | -------- | ----------------- | ---------- | -------- | ------------------------------- |
| id               | 商品ID   | 大于 0 的数字      | 1         | 否*      | id 和 name 必须提供其中一个     |
| name             | 商品名称 | 任意文本           | 生命药水   | 否*      | id 和 name 必须提供其中一个     |
| purchase_quantity| 购买数量 | 大于 0 的数字      | 5         | 否       | 默认值为 1                      |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例            | 备注                    |
| ------ | ------ | -------- | --------------- | ---------------------- |
| itemId | 数字   | 商品ID   | 1               | 仅购买成功时返回        |
| result | 整数   | 结果代码 | 0               | 见下方结果代码说明      |
| desc   | 文本   | 结果描述 | PurchaseSuccess | 见下方结果代码说明      |

**结果代码说明：**

| 代码 | 描述                        | 说明                          |
| ---- | -------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | 购买成功                       |
| 1    | DatabaseError             | 数据库错误                     |
| 2    | NotEnoughCoin             | 金币不足                       |
| 3    | ItemNotFound              | 商品未找到                     |
| 4    | PurchaseAndUseSuccess     | 购买并使用成功                 |
| 5    | PurchaseSuccessAndUseFailure | 购买成功但使用失败           |

<br/>

### 物品合成

?> 需要 v1.98.0+

**方法名：**synthesize

**说明：**使用已有的合成配方合成物品

**示例：**
- 使用ID为1的配方合成一次：[lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- 使用ID为1的配方合成5次：[lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

| 参数  | 含义     | 取值            | 示例 | 是否必须 | 备注          |
| ----- | -------- | --------------- | ---- | -------- | ------------- |
| id    | 配方ID   | 大于 0 的数字    | 1    | 是       | 合成配方的ID  |
| times | 合成次数 | 大于 0 的数字    | 5    | 否       | 默认值为 1    |

**返回数据：**

| 字段名           | 类型   | 说明         | 示例            | 备注                |
| --------------- | ------ | ------------ | --------------- | ------------------ |
| formulaId       | 数字   | 配方ID       | 1               |                    |
| result          | 整数   | 结果代码     | 0               | 见下方结果代码说明  |
| desc            | 文本   | 结果描述     | SynthesisSuccess| 见下方结果代码说明  |
| synthesisResults| 文本   | 合成结果列表 | {...}           | 仅合成成功时返回    |

**结果代码说明：**

| 代码 | 描述                 | 说明         |
| ---- | ------------------- | ------------ |
| 0    | SynthesisSuccess    | 合成成功     |
| 1    | FormulaNotFound     | 配方不存在   |
| 2    | InsufficientMaterials| 材料不足     |
| 3    | DatabaseError       | 数据库错误   |
| 4    | UnknownError        | 其他错误     |

<br/>

### 合成配方管理

?> 需要 v1.98.0+

**方法名：**synthesis_formula

**说明：**新建、修改或删除合成配方

**示例：**
- 创建新配方：[lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
    - 这里的 inputItems 为 `[{"item_id": 296, "amount": 88}]`
    - 这里的 outputItems 为 `[{"item_id": 295, "amount": 1}]`
- 删除配方：[lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| 参数        | 含义       | 取值                | 示例                               | 是否必须 | 备注                   |
| ----------- | ---------- | ------------------- | ---------------------------------- | -------- | ---------------------- |
| id          | 配方ID     | 大于 0 的数字       | 1                                  | 否       | 修改或删除时必须提供   |
| delete      | 是否删除   | true 或者 false     | true                               | 否       | 仅删除配方时使用       |
| inputItems  | 材料列表   | 商品数组，格式见下文 | [{"item_id":1,"amount":2}]          | 是       | 新建或修改时必须提供   |
| outputItems | 产物列表   | 商品数组，格式见下文 | [{"item_id":3,"amount":1}]          | 是       | 新建或修改时必须提供   |
| category    | 分类ID     | 大于 0 的数字       | 1                                  | 否       | 如不提供，默认为默认清单         |

!> inputItems 和 outputItems 的格式为 JSON 数组，每个商品包含 item_id（商品ID）和 amount（数量）两个字段，所有商品ID必须存在且数量必须大于0

**返回数据：**

| 字段名    | 类型   | 说明       | 示例        | 备注               |
| --------- | ------ | ---------- | ----------- | ------------------ |
| formulaId | 数字   | 配方ID     | 1           | 操作成功时返回     |
| result    | 整数   | 结果代码   | 0           | 见下方结果代码说明 |
| desc      | 文本   | 结果描述   | AddSuccess  | 见下方结果代码说明 |

**结果代码说明：**

| 代码 | 描述         | 说明       |
| ---- | ------------ | ---------- |
| 0    | Success      | 操作成功   |
| 1    | Failed       | 操作失败   |

<br/>

### 子任务管理

?> 需要 v1.98.0+

**方法名：**subtask

**说明：**新建或编辑子任务

**示例：**
- 为任务ID为1的主任务添加子任务：[lifeup://api/subtask?main_id=1&todo=完成作业](lifeup://api/subtask?main_id=1&todo=完成作业)
- 编辑子任务并设置奖励：[lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| 参数          | 含义           | 取值                | 示例      | 是否必须 | 备注                           |
| ------------ | -------------- | ------------------ | --------- | -------- | ------------------------------ |
| main_id      | 主任务ID       | 大于 0 的数字      | 1         | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| main_gid     | 主任务组ID     | 大于 0 的数字      | 1         | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| main_name    | 主任务名称     | 任意文本           | 学习任务   | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| edit_id      | 编辑的子任务ID | 大于 0 的数字      | 2         | 否*      | 编辑时与 edit_gid、edit_name 必须提供其中一个；新建时无需提供 |
| edit_gid     | 编辑的子任务组ID| 大于 0 的数字     | 2         | 否*      | 编辑时与 edit_id、edit_name 必须提供其中一个；新建时无需提供 |
| edit_name    | 编辑的子任务名称| 任意文本          | 完成作业   | 否*      | 编辑时与 edit_id、edit_gid 必须提供其中一个；新建时无需提供 |
| todo         | 任务内容       | 任意文本           | 完成作业   | 否       | 新建时必须提供                 |
| remind_time  | 提醒时间       | 时间戳（毫秒）     | 1640995200000 | 否    | 传入 null 可清除提醒时间       |
| order        | 排序           | 整数              | 1          | 否       | 任务在列表中的排序位置          |
| coin         | 金币奖励       | [0, 999999]      | 10         | 否       | 完成任务获得的金币数量          |
| coin_var     | 金币奖励浮动值 | 整数              | 5          | 否       | 金币奖励的浮动范围             |
| exp          | 经验值奖励     | [0, 99999]       | 5          | 否       | 完成任务获得的经验值            |
| auto_use_item| 自动使用物品   | true 或者 false   | true       | 否       | 完成任务时是否自动使用物品      |
| item_id      | 物品ID         | 大于 0 的数字     | 1          | 否*      | 与 item_name 必须提供其中一个   |
| item_name    | 物品名称       | 任意文本          | 生命药水    | 否*      | 与 item_id 必须提供其中一个     |
| item_amount  | 物品数量       | 大于 0 的数字     | 1          | 否       | 仅在设置物品奖励时有效          |
| items        | 物品奖励JSON   | JSON文本          | [{"item_id":1,"amount":1}] | 否 | 可一次性设置多个物品奖励      |
| coin_set_type| 金币奖励类型   | 以下数值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置金币为 value<br/>relative - 在原金币值的基础上增加或减少 |
| exp_set_type | 经验值奖励类型 | 以下数值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置经验值为 value<br/>relative - 在原经验值的基础上增加或减少 |

**返回数据：**

| 字段名        | 类型   | 说明         | 示例 | 备注             |
| ------------ | ------ | ------------ | ---- | ---------------- |
| main_task_id | 数字   | 主任务ID     | 1    |                  |
| subtask_id   | 数字   | 子任务ID     | 2    |                  |
| subtask_gid  | 数字   | 子任务组ID   | 3    | 可能为空         |

<br/>

### 子任务操作

?> 需要 v1.98.0+

**方法名：**subtask_operation

**说明：**对子任务进行完成、撤销完成或删除操作

**示例：**
- 完成子任务：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- 删除子任务：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- 撤销完成子任务：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| 参数          | 含义           | 取值                | 示例      | 是否必须 | 备注                           |
| ------------ | -------------- | ------------------ | --------- | -------- | ------------------------------ |
| main_id      | 主任务ID       | 大于 0 的数字      | 1         | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| main_gid     | 主任务组ID     | 大于 0 的数字      | 1         | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| main_name    | 主任务名称     | 任意文本           | 学习任务   | 否*      | main_id、main_gid、main_name 必须提供其中一个 |
| edit_id      | 子任务ID       | 大于 0 的数字      | 2         | 否*      | edit_id、edit_gid、edit_name 必须提供其中一个 |
| edit_gid     | 子任务组ID     | 大于 0 的数字      | 2         | 否*      | edit_id、edit_gid、edit_name 必须提供其中一个 |
| edit_name    | 子任务名称     | 任意文本           | 完成作业   | 否*      | edit_id、edit_gid、edit_name 必须提供其中一个 |
| operation    | 操作类型       | 以下数值其一：<br/>complete<br/>undo_complete<br/>delete | complete | 是 | complete - 完成任务<br/>undo_complete - 撤销完成<br/>delete - 删除任务 |

**返回数据：**

| 字段名        | 类型   | 说明         | 示例 | 备注             |
| ------------ | ------ | ------------ | ---- | ---------------- |
| main_task_id | 数字   | 主任务ID     | 1    |                  |
| subtask_id   | 数字   | 子任务ID     | 2    |                  |
| subtask_gid  | 数字   | 子任务组ID   | 3    | 可能为空         |

<br/>

### 清单管理

?> 需要 v1.98.0+

**方法名：**category

**说明：**添加或编辑各类清单（任务清单、成就清单、商店清单、合成清单）

**示例：**
- 创建任务清单：[lifeup://api/category?type=tasks&name=学习清单](lifeup://api/category?type=tasks&name=学习清单)
- 编辑商店清单：[lifeup://api/category?type=shop&edit_id=1&name=装备商店&order=1](lifeup://api/category?type=shop&edit_id=1&name=装备商店&order=1)

| 参数             | 含义           | 取值                | 示例       | 是否必须 | 备注                           |
| --------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| type            | 清单类型       | 以下数值其一：<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | 是 | tasks - 任务清单<br/>achievements - 成就清单<br/>shop - 商店清单<br/>synthesis - 合成清单 |
| edit_id         | 编辑的清单ID   | 大于 0 的数字      | 1          | 否       | 编辑时必须提供                 |
| name            | 清单名称       | 任意文本           | 学习清单    | 否       | 新建时必须提供；编辑时可选      |
| order           | 排序           | 整数               | 1          | 否       | 清单在列表中的排序位置          |
| hidden          | 是否隐藏       | true 或者 false    | false      | 否       | 仅任务清单和商店清单支持        |
| inventory_hidden| 是否在仓库隐藏 | true 或者 false    | false      | 否       | 仅商店清单支持                 |
| icon_uri        | 图标URI        | URI文本            | content://... | 否    | 仅成就清单支持                 |
| desc            | 描述           | 任意文本           | 这是描述     | 否      | 仅成就清单支持                 |
| color           | 标签颜色       | 颜色字符串         | #66CCFF     | 否      | 仅任务清单支持；#需要转义为%23  |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例 | 备注             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 数字   | 清单ID   | 1000 | 新建或编辑的清单ID |

<br/>

### 成就管理

?> 需要 v1.98.0+

**方法名：**achievement

**说明：**添加或编辑自定义成就和成就子分类

**示例：**
- 创建一个成就：[lifeup://api/achievement?name=收藏家&desc=收集100个物品&category_id=1](lifeup://api/achievement?name=收藏家&desc=收集100个物品&category_id=1)
  - 你可能需要将`category_id`替换成你实际可用的成就清单 id 以测试该示例
- 创建需要解锁条件的成就：[lifeup://api/achievement?name=百万富翁&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=百万富翁&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - 你可能需要将`category_id`替换成你实际可用的成就清单 id 以测试该示例
  - `conditions_json`编码前内容为`[{"type":7,"target":1000000}]`
- 编辑现有成就：[lifeup://api/achievement?edit_id=1&name=新成就名称&exp=100](lifeup://api/achievement?edit_id=1&name=新成就名称&exp=100)

#### 1. 成就参数

| 参数          | 含义           | 取值                | 示例     | 是否必须 | 备注                           |
| ------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| edit_id      | 编辑的成就ID   | 大于 0 的数字      | 1        | 否       | 编辑时必须提供                 |
| is_subcategory| 是否为子分类   | true 或者 false    | false    | 否       | 默认为 false                   |
| name         | 成就名称       | 任意文本           | 收藏家    | 否*      | 新建时必须提供                 |
| desc         | 成就描述       | 任意文本           | 收集100个物品 | 否    |                               |
| order        | 排序           | 整数              | 1         | 否       | 在列表中的排序位置              |
| category_id  | 所属分类ID     | 大于 0 的数字      | 1         | 否*      | 创建子分类时必须提供            |
| unlocked     | 是否解锁       | true 或者 false    | true      | 否       | true-立即解锁<br/>false-重置为未解锁 |
| unlock_time  | 解锁时间       | 时间戳（毫秒）     | 1640995200000 | 否   | 仅当成就已解锁时有效           |
| delete       | 是否删除       | true 或者 false    | false     | 否       |                                |
| secret       | 是否为隐藏成就 | true 或者 false    | false     | 否       |                                |
| write_feeling| 是否记录感想   | true 或者 false    | false     | 否       |                                |
| color        | 标题颜色       | 颜色字符串         | #66CCFF   | 否       | #需要转义为%23                  |
| auto_use_item| 自动使用物品   | true 或者 false    | false     | 否       |                                |
| skills       | 技能ID         | 大于 0 的数字数组   | 1         | 否       | 支持数组（如 &skills=1&skills=2）|
| exp          | 经验值奖励     | 整数              | 100       | 否       |                                |
| item_id      | 物品ID         | 大于 0 的数字      | 1         | 否*      | 与 item_name 必须提供其中一个   |
| item_name    | 物品名称       | 任意文本           | 宝箱      | 否*      | 与 item_id 必须提供其中一个     |
| item_amount  | 物品数量       | [1, 99]           | 1         | 否       | 默认为 1                       |
| items        | 物品奖励JSON   | JSON文本           | [{"item_id":1,"amount":2}] | 否 | 可一次设置多个物品奖励，格式见下文 |
| conditions_json | 解锁条件JSON | JSON文本          | [{"type":7,"target":1000000}] | 否 | 设置解锁条件，格式见下文 |
| coin         | 金币奖励       | [0, 999999]      | 10         | 否       | 完成任务获得的金币数量          |
| coin_var     | 金币奖励浮动值 | 整数              | 5          | 否       | 金币奖励的浮动范围             |
| coin_set_type| 金币奖励类型   | 以下数值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置金币为 value<br/>relative - 在原金币值的基础上增加或减少 |
| exp_set_type | 经验值奖励类型 | 以下数值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接设置经验值为 value<br/>relative - 在原经验值的基础上增加或减少 |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例 | 备注             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 数字   | 成就ID   | 1000 | 新建或编辑的成就ID |


#### 2. 子分类专用参数

| 参数          | 含义           | 取值                | 示例     | 是否必须 | 备注                           |
| ------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| is_collapsed | 是否折叠       | true 或者 false    | false    | 否       | 仅适用于子分类                  |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例 | 备注             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 数字   | 成就ID   | 1000 | 新建或编辑的成就ID (子分类) |

#### 3. 解锁条件类型说明

| 类型代码 | 含义               | 是否需要related_id | related_id类型 | target说明        |
| ------- | ------------------ | ---------------- | -------------- | ----------------- |
| 0       | 完成任务次数        | 是              | 任务ID         | 完成次数           |
| 1       | 连续完成任务次数     | 是              | 任务ID         | 连续次数           |
| 3       | 番茄数量           | 否              | -              | 番茄数量           |
| 4       | 使用人升天数        | 否              | -              | 使用天数           |
| 5       | 被点赞数           | 否              | -              | 点赞数量           |
| 6       | 连续完成天数        | 否              | -              | 连续天数           |
| 7       | 当前金币数         | 否              | -              | 金币数量           |
| 8       | 一天内金币获得数     | 否              | -              | 金币数量           |
| 9       | 任务的番茄数        | 是              | 任务ID         | 番茄数量           |
| 10      | 物品购买数         | 是              | 物品ID         | 购买次数           |
| 11      | 物品使用数         | 是              | 物品ID         | 使用次数           |
| 12      | 物品开箱获得数      | 是              | 物品ID         | 获得次数           |
| 13      | 技能达到指定等级     | 是              | 技能ID         | 等级数值           |
| 14      | 人生等级           | 否              | -              | 等级数值           |
| 15      | 物品累计获得数      | 是              | 物品ID         | 获得总次数         |
| 16      | 物品合成获得数      | 是              | 物品ID         | 合成获得次数        |
| 17      | 物品当前拥有数量     | 是              | 物品ID         | 拥有数量           |
| 18      | 任务番茄钟专注时长   | 是              | 任务ID         | 专注时长(分钟)      |
| 19      | ATM存款           | 否              | -              | 存款数量           |
| 20      | 外部API           | 否              | -              | 根据API定义        |

#### 4. JSON格式说明

##### 解锁条件 (conditions_json)
```json
[
   {
       "type": 7,           // 条件类型（参考上表）
       "related_id": null,  // 关联ID（部分类型必须提供）
       "target": 1000000    // 目标数值
   },
   {
       "type": 10,          // 示例：购买指定物品
       "related_id": 1,     // 物品ID
       "target": 5          // 购买5次
   }
]
```

##### 物品奖励 (items)
```
[
    {
        "item_id": 1,    // 物品ID
        "amount": 2      // 数量
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### 技能管理

?> 需要 v1.98.0+

**方法名：**skill

**说明：**新建或编辑自定义技能（属性）

**示例：**
- 创建一个技能：[lifeup://api/skill?content=编程&desc=代码能力&color=%23FF6B6B](lifeup://api/skill?content=编程&desc=代码能力&color=%23FF6B6B)
- 编辑技能经验值：[lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- 删除技能：[lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| 参数         | 含义           | 取值                | 示例       | 是否必须 | 备注                           |
| ----------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| id          | 技能ID         | 大于 0 的数字      | 1          | 否       | 编辑时必须提供                 |
| content     | 技能名称       | 任意文本           | 编程        | 否*      | 新建时必须提供                 |
| desc        | 技能描述       | 任意文本           | 代码能力    | 否       |                               |
| icon        | 图标           | 任意文本           | 💻         | 否       | 可以使用 emoji                 |
| color       | 颜色           | 颜色字符串         | #FF6B6B    | 否       | #需要转义为%23                 |
| type        | 类型           | 整数               | 0          | 否       |                               |
| order       | 排序           | 整数               | 1          | 否       | 在列表中的排序位置             |
| status      | 状态           | 整数               | 0          | 否       |                               |
| exp         | 经验值         | 大于或等于 0 的数字 | 100        | 否       | 技能当前经验值                 |
| delete      | 是否删除       | true 或者 false    | false      | 否       | 仅在编辑模式下有效             |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例 | 备注             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 数字   | 技能ID   | 1000 | 新建或编辑的技能ID |

<br/>

### 导出备份

?> 需要 v1.98.0+

**方法名：**export_backup

**说明：**创建一个备份文件并返回其 URI（仅支持通过 Content Provider 调用）

!> 此 API 只能通过 Content Provider 方式调用，不支持直接使用 URL Scheme 调用

| 参数          | 含义           | 取值            | 示例  | 是否必须 | 备注                                           |
| ------------- | -------------- | --------------- | ----- | -------- | ---------------------------------------------- |
| withMedia     | 是否包含媒体文件 | true 或者 false | true  | 否       | 是否在备份中包含媒体文件（图片、音效等）<br/>默认为 true |
| callingPackage| 调用方包名     | 任意文本        | com.example.app | 否 | Content Provider 调用时的包名标识 |

**返回数据：**

| 字段名          | 类型   | 说明                 | 示例                                          |
| --------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | 文本   | 备份文件的 URI 地址  | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### 应用设置

?> 需要 v1.98.0+

**方法名：**app_settings

**说明：**调整应用的界面设置

**示例：**
- 启用简洁模式：[lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- 启用 Material You 主题：[lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- 更改设置并立即重启界面：[lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| 参数                    | 含义              | 取值            | 示例  | 是否必须 | 备注                           |
| ---------------------- | ----------------- | --------------- | ----- | -------- | ------------------------------ |
| is_enable_compact_mode | 是否启用简洁模式   | true 或者 false | true  | 否       | 精简界面元素                    |
| is_enable_material_you | 是否启用Material You| true 或者 false | true  | 否       | 启用 Material You 主题          |
| restart_activities     | 是否重启界面       | true 或者 false | true  | 否       | 立即应用界面更改                |

**返回数据：**

| 字段名 | 类型   | 说明     | 示例 | 备注             |
| ------ | ------ | -------- | ---- | ---------------- |
| result | 整数   | 结果代码 | 0    | 0 表示设置成功   |

<br/>

### 简单查询

!> 此处的功能是用于搭配自动化工具/二次开发的。如果你需要查询完整的数据列表，可以参考我们的 LifeUp SDK、《云人升》、《人升桌面端》。

**方法名：**query

**说明：**查询参数

**版本：**需要 v1.90.2

**示例：**

- 查询当前金币数：[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

| 参数        | 含义       | 取值                                                         | 示例 | 是否必须                        | 备注                                                         |
| ----------- | ---------- | ------------------------------------------------------------ | ---- | ------------------------------- | ------------------------------------------------------------ |
| key         | 查询的类型 | 仅限以下数值其一：<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato | coin | 是                              | coin - 当前金币数<br/>atm - 当前 ATM 存款<br/>item - 指定 `itemId` 的商品信息<br/>item_id_list - 指定`categoryId`的商品id列表<br/>tomato - 番茄数据 |
| item_id     | 商品id     | 大于 0 的数字                                                | 1    | 当 key 为 item 时，必须         | 查询的商品 id                                                |
| category_id | 清单id     | 大于或者等于 0 的数字                                        | 1    | 当 key 为 item_id_list 时，必须 | 只有当key为`item_id_list`时需要，代表查询的清单 id           |

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

当查询 item_id_list 时：

| 参数     | 含义                            | 取值   | 示例    | 是否必须 | 备注 |
| -------- | ------------------------------- | ------ | ------- | -------- | ---- |
| item_ids | 查询返回的商品id数组，以`,`分隔 | 字符串 | 1,2,3,4 | 是       |      |

当查询 tomato 时：

| 参数      | 含义         | 取值 | 示例 | 是否必须 | 备注 |
| --------- | ------------ | ---- | ---- | -------- | ---- |
| total     | 总番茄数量   | 数字 | 100  | 是       |      |
| available | 可用番茄数量 | 数字 | 50   | 是       |      |
| exchanged | 已兑换番茄数量 | 数字 | 50   | 是       |      |



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

#### 随机

?> 该 API 于 v1.93.0-beta02 发布。

**方法名：**random

**说明：**简单的随机接口，可以随机触发多个 API 中的其中一个。

**示例：**

- 同等概率随机显示`石头`、`剪刀`、`布`：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布)

- 90%概率显示`石头`、5%概率`剪刀`、5%概率`布`，：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布&weight=90&weight=5&weight=5)

| 参数   | 含义       | 取值        | 示例                                   | 是否必须 | 备注                                                         |
| ------ | ---------- | ----------- | -------------------------------------- | -------- | ------------------------------------------------------------ |
| api    | 随机的 API | 任意文本    | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石头 | 是       | 支持数组形式调用（即可以存在多个api参数，见上述例子）        |
| weight | 比重       | 大于0的数字 | 1                                      | 否       | 支持数组形式调用<br/><br/>如果不指定比重，默认比重都一样（概率同等均等）。<br/>如果指定比重，会按顺序分配：如第一个weight分配到第一个api参数。<br/><br/>**请确保weight参数的数量与 api 参数的数量一致，否则可能会不生效。** |

<br/>

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

**说明：**该接口自身不处理任何逻辑，但你可以搭配 callback、broadcast 使用。

**示例：**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)


#### 变量占位符

「人升」提供了对参数的用户介入处理手段。

| 占位符                              | 含义                                                         | 示例                                                         |
| ----------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| [$text\|标题]                       | 文本占位符                                                   | [$text\|输入任务名称]                                        |
| [$number\|标题]                     | 数字占位符（不含小数点）                                     | [$number\|输入价格]                                          |
| [$number\|标题\|signed]            | 数字占位符（不含小数点），并显示正负符号                     | [$number\|输入价格\|signed]                                  |
| [$decimal\|标题]                    | 数字占位符（含小数点）                                       | [$decimal\|输入ATM利率]                                       |
| [$decimal\|标题\|signed]           | 数字占位符（含小数点），并显示正负符号                       | [$decimal\|输入ATM利率\|signed]                                |
| [$item]                             | 选择商品，将被替换为商品id                                   | [$item]                                                      |
| [$task_category]                    | 选择任务清单，将被替换为任务清单id                           | [$task_category]                                             |
| [$time\|锚定时间\|偏移毫秒（可选）] | 时间占位符<br/><br/>其中锚定时间的取值有：<br/>`current`、`today`、`this_monday`、`last_monday`、`this_month`、`last_month`、`this_year`、`last_year`<br/><br/>偏移毫秒应该为整数，默认为 0 毫秒 | 今天0点：[$time\|today]<br/>明天0点：[$time\|today\|86400000] |
| [$random_number\|最小值\|最大值]    | 随机数字占位符（不含小数点）                                 | [$random_number\|0\|3000]                                    |
| [$random_decimal\|最小值\|最大值]   | 随机数字占位符（含小数点）                                   | [$random_decimal\|1.0\|2.0]                                  |

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

!> 此处的功能是用于搭配自动化工具/二次开发的，有一定使用知识和使用门槛。

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

| 参数        | 含义           | 示例         |
| ----------- | -------------- | ------------ |
| task_id     | 任务id         | 1            |
| task_gid    | 任务组id       | 1            |
| name        | 任务名称       | 开始使用人升 |
| category_id | 任务所属清单id | 1            |

### 放弃任务

**名称：**app.lifeup.task.giveup

**返回值：**

| 参数        | 含义           | 示例            |
| ----------- | -------------- | --------------- |
| task_id     | 任务id         | 1               |
| task_gid    | 任务组id       | 1               |
| name        | 事项名称       | Getting started |
| category_id | 任务所属清单id | 1               |

### 逾期任务

**名称：**app.lifeup.task.overdue

**返回值：**


| 参数      | 含义             | 示例                            |
| --------- | ---------------- | ------------------------------- |
| task_ids  | 任务id**数组**   | [1, 2, 3]                       |
| task_gids | 任务组id**数组** | [1, 2, 3]                       |
| names     | 事项名称**数组** | [Getting started, Drink Waters] |
| task_ids_json  | 任务id**Json数组**   | [1, 2, 3]                       |
| task_gids_json | 任务组id**Json数组** | [1, 2, 3]                       |
| names_json     | 事项名称**Json数组** | ["Getting started", "Drink Waters"]                      |



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

### 添加感想

**名称：**app.lifeup.feelings.add

**返回值：**

| 参数              | 含义                     | 示例                  |
| ----------------- | ------------------------ | --------------------- |
| feelings_id       | 感想id                   | 1                     |
| action_type       | 操作类型                 | add 或 update         |
| content           | 感想内容                 | 今天心情不错！         |
| create_time       | 创建时间戳               | 1642060800000         |
| relate_type       | 关联类型                 | 0                     |
| related_id        | 关联对象id               | 1                     |
| attachments_count | 附件数量                 | 2                     |
| attachments       | 附件数组                 | ["/path/1", "/path/2"] |

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

##### 使用 SDK

请参考：https://github.com/Ayagikei/LifeUp-SDK 的 `core` 模块。

##### 不使用 SDK

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

# 兼容性配置

这里列举了部分设备的兼容性配置问题，

如果你不进行相应的配置，可能无法正常使用【提醒】、【番茄钟】、【倒计时】、【小部件】等相应功能。

这些限制与应用本身并无关系，甚至与 Android 也没多少关系，**大都是由手机厂商“定制”导致的问题。**并且由于是手机厂商“定制”的系统，应用开发者们也没法从代码层面提供解决方案。

> 如果你使用的是 AOSP 或类 AOSP 系统（如 Pixel 手机），基本上只需要“忽略电池优化”即可正常使用`人升`所有功能。



## 主要问题

!> 我们已经在应用流程设下了无数提示，包含但不限于：初始任务、新手教程、常见问题、设置页面小红点和二次确认才能移除小红点，部分相关的功能的额外提醒。但仍然没法阻挡有陆陆续续的用户可以完美绕开所有提示来到QQ群或者私聊反馈相同的问题。<br><br/>**为了你的应用正常使用体验，请务必重视以下配置❗❗<br/>特别是如果你需要使用桌面小部件、番茄钟、倒计时、提醒等功能时。**

?> 下方涉及「需要后台运行」的功能点，由于不同手机、系统涉及到很多不一样的选项。经常有用户漏配一些选项（比如华为需要把电池优化调成“手动管理”），导致 app 仍有问题。<br/><br/>**经我们确认，主流设备（如华为/荣耀、小米/红米、OPPO/Realme/一加、VIVO/iQOO、三星、Pixel等），只要正常配置后，相关设置项都能正常使用过。**<br/><br/>如果你在配置后仍有问题，如需反馈，请带上所有的配置项截图、视频在频道发帖。可以跟其他同型号的用户对比一下设置项，也可以向对应的手机工程师/客服反馈问题。

| 功能                                                         | 需要后台运行      | 需要其他权限               | 备注                                                         |
| ------------------------------------------------------------ | ----------------- | -------------------------- | ------------------------------------------------------------ |
| 事项提醒（系统通知）                                         | ✔️                 | 需要“通知”权限<br/>        | 默认方式，**请参考[后台保活文章](guide/background_running)进行配置**；<br/>并确认已经启用了“通知”。 |
| 事项提醒（日历事件）                                         | -                 | 需要“日历读写”权限         | **可在应用内【设置】-【事项】-【更换提醒方式】处更改**       |
| <span style="color: #ff6666;">番茄钟/商品倒计时</span>       | ✔️                 | -                          | **请参考[后台保活文章](guide/background_running)进行配置；**<br/>如果未配置可能出现不提醒、倒计时被冻结（回到应用内才计时）、通知倒计时不精准、通知的操作按钮无法点击等多种现象 |
| 正计时                                                       | -                 | -                          | -                                                            |
| <span style="color: #ff6666;">小部件数据刷新</span>          | ✔️（部分设备需要） | -                          | **请参考[后台保活文章](guide/background_running)进行配置；**<br/>如果未配置可能出现一直显示“正在加载中”或“已经完成了所有任务”或无法刷新等现象<br/>设置后，需要创建新的小部件以生效 |
| （非小米手机）小部件完成计数任务、跳转应用内                 | -                 | -                          | -                                                            |
| （小米手机）小部件完成计数任务、跳转应用内                   | -                 | 需要“允许后台显示界面”权限 | 该问题为 MIUI/澎拜 OS 系统独有，需要在系统的APP设置页面进行配置 |
| （小米手机）隐藏了安卓小部件添加入口<br/>![image-20230826171710670](_media/compatibility/image-20230826171710670.png) | -                 | -                          | 该问题为一部分系统系统（MIUI/澎拜 OS）独有<br/>- 「MIUI/澎拜 OS」设置方法请查看[视频教程](https://www.bilibili.com/video/BV17W4y1s7dL)<br/>- 其他系统可检索一下相关教程 |
| （李跳跳等广告跳过工具）会帮你自动点击通知栏跳过番茄钟、ATM 弹窗等 | -                 | -                          | 请在相应工具设置内，关闭对《人升》和《系统用户界面》（主要影响番茄钟的通知按钮）的处理。 |
| 番茄设置中没法创建快捷方式                                   | -                 | -                          | 部分厂商的手机需要先前往应用管理页面，开启“创建快捷方式”权限 |



## 非常见问题

| 现象                                   | 设备 | 可能/已知原因                                                | 解决方案                                                     |
| -------------------------------------- | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ATM弹窗打不开                          | 任何 | 跳过广告的工具可能错误认为部分弹窗为广告，自动关闭了弹窗     | 使用相关工具时，将《人升》加入白名单                         |
| 界面异常文本无法显示                   | ？   | 系统异常，导致官方控件的渲染异常                             | 建议更换稳定版系统，或等待系统更新                           |
| 系统渲染UI崩溃                         | ？   | 系统异常，崩溃堆栈皆为系统堆栈                               | 建议更换稳定版系统，或等待系统更新                           |
| 无法调整小部件尺寸                     | ?    | 一般是用户操作问题                                           | [查看视频教程](https://www.bilibili.com/video/BV17W4y1s7dL/?share_source=copy_web&vd_source=141b0b80de90aedb6b7f25458fa6b5d1&t=70) |
| 极少数用户遇到了部分按钮无法展示的问题 | ？   | 似乎与设备关系不大，可能跟第三方工具、主题、系统bug相关<br/>并且信息有限，如果你遇到了该问题，或者发现了解决该问题的相关线索，欢迎向我们提供更多信息（如设备机型、系统版本等） | ![image-20240218235551125](_media/compatibility/image-20240218235551125.png) |



## 问题反馈

?> 遇到你遇到了更多的兼容性问题，建议入群反馈，查看是否有其他人也遇到了类似的问题。如果排查到并非`人升`自身的问题后，你需要向系统工程师反馈。

兼容性问题属于系统与应用间，或者应用与应用间相关的问题；

开发者一般也只能提供简单的思路，具体可能需要手动排查问题原因，由我们登记在上述表格里。

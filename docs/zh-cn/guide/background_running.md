# 后台保活

## 为什么需要设置后台保活？

- 部分手机厂商为了省电等参数指标，对除白名单外（QQ、微信、支付宝）的绝大多数应用的后台执行了一刀切方案，使得应用内的一些需要后台运行的功能无法正确执行。**将用户指引成本转嫁到了各个应用，操作成本转嫁到了各位用户。**

  **一般会导致番茄钟、倒计时，甚至是桌面小部件后台刷新不正常等现象。**

- EMUI、MagicUI（华为、荣耀）设备会优化掉番茄钟的提醒功能

- 如果你使用的是默认的应用通知提醒方式，在不设置后台运行的情况下，很大概率会接收不到通知

- 桌面小部件刷新也可能会被系统优化掉，导致小部件加载异常

- **（推荐）在遇到以上问题后，再进行配置后台运行，否则可能会影响耗电量**



## 如何设置后台运行

### 通用设置

1. 在系统的多任务管理界面，锁定应用
2. 在系统中查找应用的后台管理设置（或者电源优化设置），将人升设置为「允许后台运行」
3. （试验性，可能导致耗电增加）在《人升》中的事项设置界面，开启「快速创建常驻通知」
3. 在使用《人升》相关功能期间，避免开启超级省电、免打扰之类的功能；或者将《人升》加入白名单。



### 各个设备设置方式

**或者直接参考飞书整理的各种设备的设置方式：**

> 因为我们实在缺少相关手机和测试验证的时间，直接外链下飞书的设置文档。
> 飞书也不像微信支付宝那样，不属于大部分厂商的后台白名单应用，也需要设置后台权限才能正常接收信息

[安卓设备收不到新消息通知怎么办？ (feishu.cn)](https://www.feishu.cn/hc/zh-CN/articles/360025451293)

1. [华为手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-RNpJyL)

2. [OPPO 手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-rqfhmK)

3. [Vivo 手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-xi6S8F)

4. [小米手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-uoxEk6)

5. [锤子手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-ylGl04)

6. [魅族手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-5zC9BG)

7. [三星手机](https://www.feishu.cn/hc/zh-CN/articles/360025451293#lineguid-e1tk3a)

除了文中的提醒外，各个厂商的OS也可能持续加入一些省电相关的功能。

如果开启这类功能，也可能会影响《人升》中相关功能的使用。



---



以下是我们用仅有的几台设备整理的操作方式，可能存在时效性：

### 华为/荣耀

1. 打开设置
2. 搜索`“应用启动管理”`并点击
4. 找到“人升”，设置手动管理，允许自启动



**操作截图如下：**

![](_media/background_running/emui_01.jpg ':size=50%')

![](_media/background_running/emui_02.jpg ':size=50%')

![](_media/background_running/emui_03.jpg ':size=50%')


### 魅族

1. 打开`手机管家`应用
2. 点击`权限管理`
3. 点击`后台管理`
4. 找到《人升》，选择`允许后台运行`
5. （可选）多任务界面中，长按锁定《人升》



**操作截图如下：**


![](_media/background_running/flyme_01.jpg ':size=50%')

![](_media/background_running/flyme_02.jpg ':size=50%')

![](_media/background_running/flyme_03.jpg ':size=50%')

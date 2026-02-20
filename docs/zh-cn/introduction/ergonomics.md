## 性能表现

尽管《人升》是一款小众软件，但我们致力于提供出众的质量与性能体验。

以下是一些线上相关数据：

> 数据源自 Google Play 控制台统计，应用版本为 v1.90.7-rc02，覆盖用户群体为全球、用户设备 Android 版本为 5 ~ 13。

<br/>

### 崩溃率

![](_media/ergonomics/crash.png)

《人升》近 60 天的崩溃率仅为 0.01%，远低于 Google Play 定义的不良行为阈值 1.09%。

而类似群组应用的中间值为 0.14% 左右。

<br/>

### ANR 率（应用未响应）

![](_media/ergonomics/anr.png)

ANR（Application Not Responding）指应用无响应，即应用在一段时间内（通常为 5 秒）无法处理用户输入。

《人升》的 ANR 率为 0.10% 左右浮动，远低于 Google Play 定义的不良行为阈值 0.47%。

但类似群组应用的中间值为 0.05% 左右。

<br/>

由于《人升》前期留下了一些技术债务，这方面还有不少的改进空间。

<br/>

## 电池耗电相关指标

![](_media/ergonomics/battery.png)

后台运行几乎不消耗电量。

《人升》的后台服务几乎不执行任何逻辑，只包含任务提醒、小部件刷新等必要逻辑。

此处统计可能不包含番茄钟**倒**计时场景，目前番茄钟倒计时是基于手机运行和 CPU 调度的，而非类似任务提醒的定时任务。

<br/>

此前也曾经出现过部分系统（MIUI）在部分系统版本下，出现耗电异常的情况。这可能是由于系统调度、第三方库或兼容性问题导致的。

目前没有类似反馈。

<br/>

以下是实测一加 8T + ColorOS 后台运行 24 小时以上的真实耗电情况。

![](_media/ergonomics/battery_coloros.png)

<br/>

## 包体积

![](_media/ergonomics/download_size.png)

即便《人升》已经持续更新了 4 年。

得益于 Google Play 的 App Bundle 分发特性，下载体积也保持在了 10.7 MB 左右。

相比同类应用的中间值（15.7 MB），体积减少了近 1/3。

![](_media/ergonomics/download_size_increase.png)

《人升》接近 4 年的应用体积“膨胀”。

![](_media/ergonomics/size.png)

《人升》的体积构成，大部分都是被代码逻辑所占用（含第三方库）：

- 资源文件（图片、音效等）：0.207 MB + 1.55 MB
- 底层库：0.5 MB
- 代码：7.73 MB

<br/>

## 启动速度

![](_media/ergonomics/launch_time_90.png)

《人升》90 分位的**冷启动**速度为 841 ms。

意味着 90% 的用户都能体验到秒开。

![](_media/ergonomics/launch_time_50.png)

《人升》50 分位的**冷启动**速度为 329 ms。

意味着 50% 的用户仅需约 300 毫秒即可启动。

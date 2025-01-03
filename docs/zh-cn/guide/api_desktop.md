<h1 align="center" padding="100">局域网（API） 桌面端</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>


我们使用《人升》的API能力开发了一款简易的局域网电脑端的《人升》，它支持 Windows、Linux、MacOS 等多端。

**但请注意，它并非一款可独立运行的程序。它需要通过 API 读取到你手机上《人升》里的离线数据。**

<br/>

## 特性

!> 当前版本仅作为 API 接口的技术演示和预览，主要提供一部分基础的信息浏览功能，并未覆盖所有应用内功能。

- 完全开源，你可以随意更改它的 UI 并实现自己想要的功能
- 基础功能：
  - 查询任务列表、完成任务
  - 查询属性列表、等级
  - 查询商品列表、购买商品
  - 查询感想列表，并能够通过电脑图片浏览器查看大图
  - 导出感想
  - 添加任务（未完全覆盖应用内的选项）
  - ...



<br/>

---



## 下载

> 2025/01/03: v1.2.0 发布遇到一些问题，我们修复并发布了 v1.2.1 版本，请下载新版本。

- **[Windows 版本](https://lifeupcdnpic.cdn.dfyun.com.cn/download/windows/stable/LifeUp-Desktop-1.2.1-windows.zip)**
- Linux
  - 请前往 Github Release 下载：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)
- **MacOS**
  - 请前往 Github Release 下载：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)
  - 自 v1.2.0 开始，现在会提供 x64 和 arm64 版本。如果你的是 Intel 架构的 Mac，请下载 x64 版本，如果是 Apple Silicon 架构的 Mac，请下载 arm64 版本。
  - MacOS 版本目前未签名，安装时需要允许操作：[打开来自身份不明开发者的 Mac App - 官方 Apple 支持 (中国)](https://support.apple.com/zh-cn/guide/mac-help/mh40616/mac)
  - MacOS 版本未经过详细测试，目前发现`自动连接`等部分功能可能没法使用。



!> 1. 你需要搭配《云人升》v2.0.0 版本或以上进行使用。如果你使用的是中国内应用市场分发的版本/GitHub Release版本，可以在软件-`设置`-`实验`页面找到《云人升》一栏并更新。如果你使用的是来自 Google Play 的版本，可以在直接在 [Google Play 页面](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)下载或者 [GitHub release 页面](https://github.com/Ayagikei/LifeUp-SDK/releases/latest)下载。

!> 2. 你的浏览器的安全策略可能会阻止下载。你可能需要手动允许浏览器下载可执行文件，或者右键复制链接到其他下载器中下载。

<br/>



---



## 如何使用

视频教程后续补充。

为了使用桌面端，会需要一点点操作步骤：

### 初次使用

#### 前置措施

- 你的手机和电脑处于同一局域网（比如连接同一WIFI）。
- <del>⚠如果你的组网情况很复杂，请先尝试能否在电脑上 ping 通手机的 IP 地址再做尝试。</del>
  - 新版本桌面端支持自动检测手机 IP，可以跳过这一步。


<br/>

#### 手机端

1. 更新你的《人升》至最新版本

2. 在《人升》-`设置`-`实验`中，找到《云人升》并下载安装。

   我们的桌面版需要它来读取数据和执行操作。

3. 运行《云人升》，给予悬浮窗权限、人升数据读取权限。

4. 在《云人升》中点击`开启服务`。



**额外步骤**

- 我们建议你为《人升》、《云人升》都进行`兼容性配置`，关闭电池优化，避免系统错误杀死应用、**以及支持手机锁屏后使用**。
- **如果你的手机是 MIUI 系统（小米、红米），请确保你为《人升》、《云人升》都允许了「后台显示界面」权限。**
- 请确保《人升》、《云人升》都在运行。

<br/>


#### 电脑端

1. 通过上文中的下载链接，下载并安装电脑端应用。
2. 在桌面版的设置页面填上你的《云人升》中的显示的服务 IP 地址。
   - **v1.1.0 版本后的桌面端，你可以尝试点击“自动连接”按钮。**
3. 大功告成~如果正常的话，你应该能够在桌面版查看到你的人升数据。
   - **如果失败的话，你可能要上述的额外步骤。**



<br/>

### 非初次使用

1. 手机上打开《人升》、《云人升》
2. 在《云人升》中点击`开启服务`
3. 运行桌面端


---



<br/>

## 常见问题

**🔶桌面端能否添加任务？**

暂时不能，目前的预览版本主要提供的是数据查询能力，该功能会在后续版本开发。

但当前阶段，你也能够通过《云人升》调用 API 来添加任务。

**🔶《云人升》点击“读取「人升」数据权限”后无反应，或者显示 API 不存在？**

1. 如果是无反应，那么应该你之前已经授权过，当作成功即可。
2. 如果显示 API 不存在，请加入会员内测，然后更新《人升》最新版本。

**🔶手机锁屏一段时间后，桌面端没法读取数据和使用？**

请为《人升》-《云人升》进行兼容性配置。

**🔶《人升》、《云人升》处于后台时，部分接口没法正常调用？**

> 这一点理论上不影响桌面端使用，但可能会影响自定义调用 API。

请确保了你授权了《云人升》的悬浮窗权限。

如果你是 MIUI 系统（小米、红米），你还需要额外为这两个应用，在系统设置中，配置`后台显示界面`权限。

**🔶Windows 安装失败？显示 Failed  to launch JVM**

同：https://github.com/Ayagikei/LifeUp-Desktop/issues/2

这可能是由于系统 JVM 环境有异常。



参考网上的做法是将 `~/.accessibility.properties` 文件的以下两行注释即可：

```
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```



修改后，程序可以正常运行。

> ~ 指的是用户文件夹路径

---



<br/>

## 贡献

SDK、《云人升》、《桌面端》皆为开源项目。

你可以在以下链接获取到源码并使用 IDEA 运行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

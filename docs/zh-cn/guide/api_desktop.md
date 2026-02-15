<h1 align="center" padding="100">局域网（API） 桌面端</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>


我们基于《人升》API 开发了一款简易的局域网桌面端，支持 Windows、Linux、macOS。

**请注意：它不是独立运行的完整客户端，需要通过 API 读取你手机中《人升》的离线数据。**

<br/>

## 特性

> [!NOTE]
> 当前版本主要用于 API 能力演示与预览，仅覆盖部分基础信息浏览功能，尚未覆盖全部应用能力。<br/>

- 完全开源，你可以自由修改 UI 并实现自己需要的功能
- 基础功能：
  - 查询任务列表、完成任务
  - 查询属性列表、等级
  - 查询商品列表、购买商品
  - 查询感想列表，并可通过电脑图片浏览器查看大图
  - 导出感想（Markdown）
  - 添加任务（暂未覆盖应用内全部选项）
  - ...



<br/>

---



## 下载

### 安装平台

> [!WARNING]
> 使用桌面端前，请确认《云人升》版本为 v2.0.0 及以上。<br/>
> 如果你使用的是中国大陆应用市场分发版本或 GitHub Releases 版本，可在软件 `设置` → `实验` 中更新《云人升》。<br/>
> 如果你使用的是 Google Play 版本，也可直接前往 [Google Play 页面](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) 或 [GitHub Releases 页面](https://github.com/Ayagikei/LifeUp-SDK/releases/latest) 下载。<br/>
> 浏览器安全策略可能会阻止下载。你可能需要手动允许下载可执行文件，或复制链接到其他下载器。

<!-- tabs:start -->

#### **Windows**

- **[Windows 版本](https://lifeupcdnpic.cdn.dfyun.com.cn/download/windows/stable/LifeUp-Desktop-1.2.1-windows.zip)**

> [!TIP]
> Windows SmartScreen 可能提示“无法识别的应用”。<br/>
> 请先确认文件来自官方发布，再点击“更多信息”→“仍要运行”。

#### **Linux**

- 请前往 GitHub Releases 下载：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)

#### **macOS**

- 请前往 GitHub Releases 下载：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)
- 自 v1.2.0 开始，现在会提供 x64 和 arm64 版本。如果你的是 Intel 架构的 Mac，请下载 x64 版本，如果是 Apple Silicon 架构的 Mac，请下载 arm64 版本。
- macOS 版本尚未完整测试，`自动连接`等部分功能可能不可用。

> [!TIP]
> macOS 版本目前未签名，安装时可能提示“身份不明开发者”。<br/>
> 你可以在系统设置中手动允许打开，详见：[打开来自身份不明开发者的 Mac App - 官方 Apple 支持 (中国)](https://support.apple.com/zh-cn/guide/mac-help/mh40616/mac)

<!-- tabs:end -->

如果某个平台安装包暂时缺失，请稍后刷新。Release 资产可能仍在上传中。

<br/>



---



## 如何使用

视频教程后续补充。

使用桌面端前，需要完成以下步骤：

### 初次使用

#### 前置条件

- 手机和电脑需处于同一局域网（例如连接同一 Wi-Fi）。
- <del>⚠如果你的组网情况很复杂，请先尝试能否在电脑上 ping 通手机的 IP 地址再做尝试。</del>
  - 新版本桌面端支持自动检测手机 IP，可以跳过这一步。


<br/>

#### 手机端

1. 更新你的《人升》至最新版本

2. 在《人升》`设置` → `实验`中，找到《云人升》并下载安装。

   我们的桌面版需要它来读取数据和执行操作。

3. 运行《云人升》，授予悬浮窗权限和人升数据读取权限。

4. 在《云人升》中点击`开启服务`。



**额外步骤**

- 建议为《人升》和《云人升》都进行`兼容性配置`，关闭电池优化，减少被系统误杀，并确保锁屏后可用。
- **如果你的手机是 MIUI 系统（小米、红米），请确保你为《人升》、《云人升》都允许了「后台显示界面」权限。**
- 请确保《人升》、《云人升》都在运行。

<br/>


#### 电脑端

1. 通过上文中的下载链接，下载并安装电脑端应用。
2. 在桌面版设置页面填写《云人升》显示的服务 IP 地址。
   - **v1.1.0 版本后的桌面端，你可以尝试点击“自动连接”按钮。**
3. 配置完成后，如一切正常，你就可以在桌面版查看《人升》数据。
   - **如果失败，请回到上面的额外步骤逐项排查。**



<br/>

### 非初次使用

1. 手机上打开《人升》、《云人升》
2. 在《云人升》中点击`开启服务`
3. 运行桌面端


---



<br/>

## 常见问题

<details>
<summary>桌面端能否添加任务？</summary>

暂时不能，目前的预览版本主要提供的是数据查询能力，该功能会在后续版本开发。

但当前阶段，你也能够通过《云人升》调用 API 来添加任务。

</details>

<details>
<summary>《云人升》点击“读取「人升」数据权限”后无反应，或显示 API 不存在？</summary>

1. 如果无反应，通常是因为你之前已授权，可视为成功。
2. 如果提示 API 不存在，请加入会员内测并更新《人升》到最新版本。

</details>

<details>
<summary>手机锁屏一段时间后，桌面端无法读取数据？</summary>

请为《人升》-《云人升》进行兼容性配置。

</details>

<details>
<summary>《人升》《云人升》处于后台时，部分接口无法正常调用？</summary>

> 这通常不影响桌面端基础使用，但可能影响自定义 API 调用。

请确认你已授权《云人升》悬浮窗权限。

如果你是 MIUI 系统（小米、红米），你还需要额外为这两个应用，在系统设置中，配置`后台显示界面`权限。

</details>

<details>
<summary>Windows 安装失败，显示 `Failed to launch JVM`？</summary>

同：https://github.com/Ayagikei/LifeUp-Desktop/issues/2

这通常与系统 JVM 环境配置异常有关。



常见处理方式是将 `~/.accessibility.properties` 中以下两行注释：

```
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```



修改后，程序通常可恢复正常运行。

> `~` 指用户目录路径。

</details>

---



<br/>

## 贡献

SDK、《云人升》、《桌面端》皆为开源项目。

你可以在以下链接获取到源码并使用 IDEA 运行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

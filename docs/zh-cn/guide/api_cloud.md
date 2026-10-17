<h1 align="center" padding="100">云人升 ☁️ </h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> 我们正在发布《人升》v1.106.0 以及《云人升》v3.0.0。由于各平台审核时间不一，文档可能已提前更新，App 实际上线时间可能会有所延误。

《云人升》是《人升》API 开发的基础套件之一。它把手机变成 **API 桥梁**：你可以从**电脑或其他设备**控制人升、做**二次扩展开发**（桌面端、网页、自动化脚本），也可以搭配 **AI Agent** 使用。

### 典型使用场景

| 场景 | 适合谁 | 一句话 | 了解更多 |
| --- | --- | --- | --- |
| **HTTP 服务 + 自研** | 开发者、自动化爱好者 | 用 Python、网页、脚本跨设备调 API、查数据，无需 Android 开发经验 | [HTTP 接口参考](/guide/api-reference)、[桌面端](guide/api_desktop.md) |
| **二维码扫描** | 想与现实行为联动的人 | 打印二维码，扫码完成任务打卡、计时、弹窗，或打开网页 / 其他 App | [二维码扫描](#二维码扫描) |
| **启动 / 暂停快捷方式** | 自动化、NFC、Tasker | `lifeupcloud://start` / `lifeupcloud://stop` 打开云人升并启动或暂停 HTTP 服务 | [启动与暂停](#cloud-scheme) |
| **AI Agent + MCP** | Cursor、Claude 等 AI 用户 | 一句话让 Agent 搭建任务 / 商店 / 成就等完整主题体系 | [MCP & Skills](guide/api_mcp.md) |
> **AI 示例话术：** 清理示例任务和商品，然后以「独立游戏开发者」为主题，创建完整的任务清单、属性、商店商品和成就体系。

<br/>

## 下载

- 如果你是中国大陆版本的会员的话，可以在`侧边栏`-`设置`-`实验`页面找到《云人升》的下载按钮。
- [Google Play 商店地址](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## 启动 / 暂停云人升服务 :id=cloud-scheme

不用点应用里的「启动服务」开关，也可以用下面的 URL Scheme 启动或暂停 HTTP 服务：

```txt
lifeupcloud://start
lifeupcloud://stop
```

打开其中任意链接都会拉起《云人升》并执行对应操作。可以做成桌面快捷方式、NFC 标签、Tasker 等自动化，或：

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

同一组链接也显示在云人升状态卡片上，点按即可复制。

> [!NOTE]
> `lifeupcloud://` 控制的是云人升自己的 HTTP 服务，不是 `lifeup://api/…` 游戏 API。

<br/>

## 二维码扫描

云人升首页右上角的 **扫码** 按钮，可读取二维码中的链接并立即打开——无需手动输入。

扫码**不限于人升 API**：`lifeup://api/…`、网页 `https://…`、以及其他 App 的 URL Scheme（如 `weixin://`）均可识别，由 Android 系统打开对应目标。

### 怎么用

1. 在《人升》或 Wiki [API 列表](guide/api.md) 中找到需要的 URL（例如完成任务、开始番茄钟、弹出购买/使用商品对话框，或打开外部网页）。

2. 用任意二维码生成器把完整 URL 转成二维码（可打印贴在桌面、墙面、设备旁）。

3. 打开《云人升》，点 **扫码**（旁边的 **?** 可查看简要说明），对准二维码即可。

### 可以做什么

| 场景 | 示例（示意） |
| --- | --- |
| 番茄钟打卡 | `lifeup://api/pomodoro?...` 开始/结束计时 |
| 任务打卡 | `lifeup://api/complete?name=...` 完成任务 |
| 商店互动 | `lifeup://api/goto?page=shop` 或购买/使用弹窗 |
| 奖励/惩罚 | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| 打开网页小游戏 | `https://wiki.lifeupapp.fun/zh-cn/example/wordle/index.html` |
| 跳转其他 App | `weixin://`、`intent://` 等已安装 App 的 Scheme |
| 自定义流程 | 任意可扫描 URL 组合 |

### 与现实互动

二维码可以把**现实位置或实体动作**映射到 App 里的游戏化行为，例如：

- 在**健身房器械**旁贴码 → 扫码完成「力量训练」任务

- 在**书桌**贴码 → 扫码开始专注番茄钟

- 在**工位**贴码 → 扫码记录 stand-up 或 Code Review

- 在**活动展板**贴码 → 扫码领取奖励或打开成就详情

本质是：**把 URL Scheme 变成可扫描的物理入口**，让云人升充当 App 与现实世界之间的执行器。

延伸阅读：[扫码也能购买「人升」商品、接受任务、完成任务…？](https://mp.weixin.qq.com/s/PafJnyce32ipZN52GxUj8w)

<br/>

> [!NOTE]
> 云人升仅在局域网内提供 HTTP 桥梁服务。如何访问手机（IP、路由器、防火墙、同网段、VPN 或 AP 隔离等）取决于各家的网络环境。若无法连接，我们无法帮你排查个人局域网。请自行检查网络、使用常规网络工具，或向 AI Agent 寻求帮助。

## 连接云人升 :id=connect

1. 安装兼容版本的人升和云人升。打开云人升，并在提示时授予人升数据/API 权限。
2. 启动 HTTP 服务。从网络中能够访问手机的设备，使用云人升显示的地址和端口作为基础 URL。
3. 如果配置了云人升令牌，将原始令牌放入 `Authorization` 请求头。查询 `/info` 检查连接与已安装版本，同时检查 HTTP 状态和 JSON `code`。

## HTTP 接口参考 :id=http-api-definition

[完整接口与参数参考](/guide/api-reference)集中提供接口索引、通用响应/分页规则、完整数据模型、请求参数和 JSON 示例。开发集成时可直接查阅。[URL Scheme 方法](/guide/api)说明具体业务动作，[MCP 与 Skills](/guide/api_mcp)说明 AI Agent 工具。

### 任务与历史时间戳 :id=task-history-timestamps

见[任务时间模型](/guide/api-reference?id=task-times)：`startTime` 是计划开始时间，`deadline` 是截止时间，历史中的 `endTime` 是记录的完成/逾期/放弃时间，需结合 `status` 判断。

#### 日报与历史完整性 :id=history-daily-reports

见[历史分页与日报](/guide/api-reference?id=daily-report)。实际奖励变化见[经验/金币流水](/guide/api-reference?id=reward-journals)。

## 贡献

SDK、《云人升》、《桌面端》皆为开源项目。

你可以在以下链接获取到源码并使用 IDEA 运行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

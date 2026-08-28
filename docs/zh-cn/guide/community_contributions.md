# 社区贡献 🤝

我们非常感谢社区为扩展人升的能力开发了多种工具。以下是官方套件与社区精选项目。

## 官方开发套件

| 项目 | 说明 |
| --- | --- |
| [云人升 (LifeUp Cloud)](guide/api_cloud.md) | 手机端 HTTP API 桥梁；支持局域网调用与**二维码扫描**（含 `lifeup://`、网页、其他 App Scheme） |
| [@lifeup/mcp](guide/api_mcp.md) | 官方 MCP 服务器 + Skills，供 Cursor、Claude Desktop 等 AI Agent 通过局域网操作人升 |
| [人升-桌面端](guide/api_desktop.md) | 官方桌面客户端，基于云人升 HTTP 接口 |
| [Wordle 联动示例](example/wordle/index.html) | 猜词小游戏；猜中后自动调用 `lifeup://api/reward` 发放金币 |

**Wordle 用法：** 在商店新建商品 → 使用效果（type 9 链接）填入 Wordle 页面地址 → 使用商品即在浏览器打开游戏；猜中得 10 金币，未猜中也有安慰奖。也可把 Wordle 链接生成二维码，用云人升扫码打开。详见 [API · 外部网页（Wordle）](guide/api.md#外部网页wordle)。

<br/>

## 社区项目

| 项目 | 描述 | 作者 |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | 早期社区 MCP 服务器实现（现已有官方 `@lifeup/mcp`）。 | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Obsidian 与人升联动插件：待办同步、感想同步、在 Obsidian 查看人升数据面板等。 | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **开发了很酷的东西？** 如果你为人升开发了工具、脚本或集成，请通过 GitHub Issues 或者邮件告知我们吧！

# 社羣貢獻 🤝

我們非常感謝社羣為擴充套件人升的能力開發了多種工具。以下是官方套件與社羣精選專案。

## 官方開發套件

| 專案 | 說明 |
| --- | --- |
| [雲人升 (LifeUp Cloud)](guide/api_cloud.md) | 手機端 HTTP API 橋樑；支援區域網呼叫與**二維碼掃描**（含 `lifeup://`、網頁、其他 App Scheme） |
| [@lifeup/mcp](guide/api_mcp.md) | 官方 MCP 伺服器 + Skills，供 Cursor、Claude Desktop 等 AI Agent 透過區域網操作人升 |
| [人升-桌面端](guide/api_desktop.md) | 官方桌面客戶端，基於雲人升 HTTP 介面 |
| [Wordle 聯動示例](example/wordle/index.html) | 猜詞小遊戲；猜中後自動呼叫 `lifeup://api/reward` 發放金幣 |

**Wordle 用法：** 在商店新建商品 → 使用效果（type 9 連結）填入 Wordle 頁面地址 → 使用商品即在瀏覽器開啟遊戲；猜中得 10 金幣，未猜中也有安慰獎。也可把 Wordle 連結生成二維碼，用雲人升掃碼開啟。詳見 [API · 外部網頁（Wordle）](guide/api.md#外部網頁wordle)。

<br/>

## 社羣專案

| 專案 | 描述 | 作者 |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | 早期社羣 MCP 伺服器實現（現已有官方 `@lifeup/mcp`）。 | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Obsidian 與人升聯動外掛：待辦同步、感想同步、在 Obsidian 檢視人升資料面板等。 | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **開發了很酷的東西？** 如果你為人升開發了工具、指令碼或整合，請透過 GitHub Issues 或者郵件告知我們吧！

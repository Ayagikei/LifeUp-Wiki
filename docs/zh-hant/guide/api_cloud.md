<h1 align="center" padding="100">雲人升 ☁️ </h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> 我們正在釋出《人升》v1.106.0 以及《雲人升》v3.0.0。由於各平臺稽覈時間不一，文件可能已提前更新，App 實際上線時間可能會有所延誤。

《雲人升》是《人升》API 開發的基礎套件之一。它把手機變成 **API 橋樑**：你可以從**電腦或其他裝置**控制人升、做**二次擴充套件開發**（桌面端、網頁、自動化指令碼），也可以搭配 **AI Agent** 使用。

### 典型使用場景

| 場景 | 適合誰 | 一句話 | 瞭解更多 |
| --- | --- | --- | --- |
| **HTTP 服務 + 自研** | 開發者、自動化愛好者 | 用 Python、網頁、指令碼跨裝置調 API、查資料，無需 Android 開發經驗 | [HTTP 介面](#http-介面定義)、[桌面端](guide/api_desktop.md) |
| **二維碼掃描** | 想與現實行為聯動的人 | 列印二維碼，掃碼完成任務打卡、計時、彈窗，或開啟網頁 / 其他 App | [二維碼掃描](#二維碼掃描) |
| **啟動 / 暫停快捷方式** | 自動化、NFC、Tasker | `lifeupcloud://start` / `lifeupcloud://stop` 開啟雲人升並啟動或暫停 HTTP 服務 | [啟動與暫停](#cloud-scheme) |
| **AI Agent + MCP** | Cursor、Claude 等 AI 使用者 | 一句話讓 Agent 搭建任務 / 商店 / 成就等完整主題體系 | [MCP & Skills](guide/api_mcp.md) |
> **AI 示例話術：** 清理示例任務和商品，然後以「獨立遊戲開發者」為主題，建立完整的任務清單、屬性、商店商品和成就體系。

<br/>

## 下載

- 如果你是中國大陸版本的會員的話，可以在`側邊欄`-`設定`-`實驗`頁面找到《雲人升》的下載按鈕。
- [Google Play 商店地址](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## 啟動 / 暫停雲人升服務 :id=cloud-scheme

不用點應用裡的「啟動服務」開關，也可以用下面的 URL Scheme 啟動或暫停 HTTP 服務：

```txt
lifeupcloud://start
lifeupcloud://stop
```

開啟其中任意連結都會拉起《雲人升》並執行對應操作。可以做成桌面快捷方式、NFC 標籤、Tasker 等自動化，或：

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

同一組連結也顯示在雲人升狀態卡片上，點按即可複製。

> [!NOTE]
> `lifeupcloud://` 控制的是雲人升自己的 HTTP 服務，不是 `lifeup://api/…` 遊戲 API。

<br/>

## 二維碼掃描

雲人升首頁右上角的 **掃碼** 按鈕，可讀取二維碼中的連結並立即開啟——無需手動輸入。

掃碼**不限於人升 API**：`lifeup://api/…`、網頁 `https://…`、以及其他 App 的 URL Scheme（如 `weixin://`）均可識別，由 Android 系統開啟對應目標。

### 怎麼用

1. 在《人升》或 Wiki [API 列表](guide/api.md) 中找到需要的 URL（例如完成任務、開始番茄鍾、彈出購買/使用商品對話方塊，或開啟外部網頁）。

2. 用任意二維碼生成器把完整 URL 轉成二維碼（可列印貼在桌面、牆面、裝置旁）。

3. 開啟《雲人升》，點 **掃碼**（旁邊的 **?** 可檢視簡要說明），對準二維碼即可。

### 可以做什麼

| 場景 | 示例（示意） |
| --- | --- |
| 番茄鍾打卡 | `lifeup://api/pomodoro?...` 開始/結束計時 |
| 任務打卡 | `lifeup://api/complete?name=...` 完成任務 |
| 商店互動 | `lifeup://api/goto?page=shop` 或購買/使用彈窗 |
| 獎勵/懲罰 | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| 開啟網頁小遊戲 | `https://wiki.lifeupapp.fun/zh-cn/example/wordle/index.html` |
| 跳轉其他 App | `weixin://`、`intent://` 等已安裝 App 的 Scheme |
| 自定義流程 | 任意可掃描 URL 組合 |

### 與現實互動

二維碼可以把**現實位置或實體動作**對映到 App 裡的遊戲化行為，例如：

- 在**健身房器械**旁貼碼 → 掃碼完成「力量訓練」任務

- 在**書桌**貼碼 → 掃碼開始專注番茄鍾

- 在**工位**貼碼 → 掃碼記錄 stand-up 或 Code Review

- 在**活動展板**貼碼 → 掃碼領取獎勵或開啟成就詳情

本質是：**把 URL Scheme 變成可掃描的物理入口**，讓雲人升充當 App 與現實世界之間的執行器。

延伸閱讀：[掃碼也能購買「人升」商品、接受任務、完成任務…？](https://mp.weixin.qq.com/s/PafJnyce32ipZN52GxUj8w)

<br/>

> [!NOTE]
> 雲人升僅在區域網內提供 HTTP 橋樑服務。如何訪問手機（IP、路由器、防火牆、同網段、VPN 或 AP 隔離等）取決於各家的網路環境。若無法連線，我們無法幫你排查個人區域網。請自行檢查網路、使用常規網路工具，或向 AI Agent 尋求幫助。

## 連線雲人升 :id=connect

1. 安裝相容的人升與雲人升版本。開啟雲人升，並依提示授予人升資料／API 權限。
2. 啟動 HTTP 服務。在網路上可連到手機的裝置，以雲人升顯示的位址與連接埠作為基底 URL。
3. 若已設定 Cloud token，在 `Authorization` 標頭傳送原始 token。查詢 `/info` 確認連線與安裝版本，並同時檢查 HTTP 狀態及 JSON `code`。

## HTTP API 參考 :id=http-api-definition

[完整介面與參數參考](/guide/api-reference)提供路徑索引、共用回應／分頁規則、完整資料模型、請求參數及 JSON 範例。建立整合時請閱讀該文件。[URL Scheme 方法](/guide/api)描述個別動作；[MCP 與 Skills](/guide/api_mcp)描述 AI Agent 工具。

### 任務與歷史時間戳記 :id=task-history-timestamps

見[任務時間模型](/guide/api-reference?id=task-times)：`startTime` 為計畫開始時間，`deadline` 為期限，歷史的 `endTime` 為紀錄的完成／逾期／放棄時間，需搭配 `status` 解讀。

#### 日報與歷史完整性 :id=history-daily-reports

見[歷史分頁與日報](/guide/api-reference?id=daily-report)；實際獎勵變動請查閱[經驗值／金幣流水](/guide/api-reference?id=reward-journals)。

## 貢獻

SDK、《雲人升》、《桌面端》皆為開源專案。

你可以在以下連結獲取到原始碼並使用 IDEA 執行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

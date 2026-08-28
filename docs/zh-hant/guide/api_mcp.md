<h1 align="center" padding="100">MCP & Skills</h1>

想讓 AI 幫你操作《人升》？這裏有兩層能力：

| | 做什麼 | 適合誰 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 發現雲人升、傳送 HTTP 請求、編碼引數、解析返回值 | Cursor、Claude Desktop、WorkBuddy，以及任意 MCP 客戶端 |
| **Skills** `lifeup-cloud/` | 連線方式、查詢思路、API 呼叫方法與引數說明 | 已內建於 MCP 的 `help`；Claude Code / Pi 也可當作磁碟技能使用 |

你電腦上的 Agent 會透過區域網連線手機裡的《雲人升》，再間接操作《人升》App。HTTP 介面細節仍以 [雲人升 API](guide/api_cloud.md) 爲準；MCP 原始碼見 [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0**+ 與 **雲人升 3.0.0**+。更早的版本或許能連上，但流水、統計、等級曲線等能力不完整；可透過 `status.update` 提示升級。

MCP 提供 Agent **讀寫 API** 的能力；AI 在此基礎上做**理解與決策**——例如按優先順序整理今日待辦、從流水/統計中歸納本週資料、根據屬性等級設計練級任務；也可以**一句話搭建完整主題體系**（獨立遊戲開發者、魔法學院等），而不只是拉取原始列表。

## 可以這樣問

裝好 MCP 後，不必記 API，直接跟 AI 說話即可。

**規劃今天**

- 「今天還剩什麼任務？按優先順序幫我整理，並建議先做哪幾件。」
- 「從還沒做完的任務裡抽一個，最好 25 分鐘能做完。」

**分析資料**

- 「拉取本週番茄、專注、金幣、經驗資料，分析主要來源並寫一段彙報。」
- 「這個月金幣都從哪來的？最大的幾筆，有沒有意外收穫。」

**教練與設計**

- 「看看我各屬性的等級，幫我設計一批日常任務，專門提升偏弱的屬性。」

**一句話搭建主題體系**

- 「清理示例，然後以獨立遊戲開發者為主題，搭建完整的清單、商店、成就與屬性體系。」
- 「以魔法學院為主題，幫我設計一整套 RPG 日常：任務、屬性、商店道具和成就。」

**回顧與創作**

- 「看看我今天完成了什麼，幫我寫一段感想：做了什麼、哪裏還能改進。」
- 「幫我建一個『早起自律』成就清單，再加 8 個帶 emoji 的成就，完成時給點金幣。」
<br/>

## 快速使用

把下面這句話發給 Agent，讓它按文件完成 MCP 安裝與首次連線即可：

```
按這份文件幫我安裝 LifeUp MCP 並完成首次連線：https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/zh-cn/guide/api_mcp.md
```

<br/>

## Skills

技能檔案位於 [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud)（倉庫內僅此一份，沒有單獨的 npm 包）。

- **Cursor / Claude Desktop / WorkBuddy**：只安裝 MCP 即可；`help` 讀的就是這份技能，無需重複安裝。
- **Claude Code / Pi / 自定義流程**：把整個目錄複製到 agent 的 skills 路徑，或直接指向倉庫中的資料夾。

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 連線與常用操作（建議先讀）
  references/
    basics.md              錯誤處理、編碼、JSON、超時
    discovery.md           mDNS / Token
    query.md               list_data 資源
    tasks.md / economy.md
    api-index.md           全部方法的一行說明
    methods/*.md           單個方法的完整參數列（用到再讀）
    broadcasts.md / gaps.md
```

Agent 會按「漸進披露」的方式查閱文件：

1. `help`（或磁碟上的 `SKILL.md`）— 瞭解整體工作流
2. `help api-index` — 檢視有哪些方法
3. `help add_task` — 檢視某個方法的引數
4. `call_api` / `list_data` — 真正發起呼叫

若要自定義技能：複製該目錄，修改 `SKILL.md` 和 `references/` 即可。MCP 的 `help` 預設仍讀取安裝包內的版本；只有在你修改 MCP 原始碼並重新構建後，纔會生效。

<br/>

## 使用前準備

1. 手機與電腦在同一區域網
2. 《人升》正在執行，且已向《雲人升》授權 **讀取人升資料**
3. 《雲人升》已啟動（預設埠 `13276`）
4. 電腦上已安裝 [Node.js 20+](https://nodejs.org/)

Token 可選；若填寫，請求頭裏寫**原始 Token**，不要加 `Bearer` 字首。

<br/>

## 安裝 MCP

包尚未上架 npm 時，可直接從 GitHub 安裝：

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx` 會自動 clone 倉庫並編譯 `mcp/`。合入 `main` 分支後，可去掉 `#feat/mcp`。

本地已 clone [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) 時，推薦用安裝指令碼（編譯 MCP，寫入已檢測到的客戶端；重複執行會更新，不會再註冊一份）：

```bash
./scripts/install-mcp.sh
```

預設覆蓋 Codex、Cursor、Claude Code、Claude Desktop、Pi。Pi 若已 `imports: ["codex"]`，會沿用 Codex 的配置，避免重複。

macOS 上的圖形界面客戶端往往找不到 `npx`，可改用 `npx`/`node` 的絕對路徑，或手動 clone 後執行 `cd mcp && npm install && npm run build`。

| 變數 | 作用 |
|---|---|
| `LIFEUP_HOST` | 如 `192.168.1.8:13276`，跳過 mDNS 發現 |
| `LIFEUP_TOKEN` | 僅儲存在程序內，不會寫入磁碟 |
| `LIFEUP_MCP_CONFIG` | 自定義配置檔案路徑 |

上架後可用 `npx -y @lifeup/mcp`（國內可用 npmmirror）。
<br/>

## Agent 流程

1. `discover`：透過 mDNS `_lifeup._tcp` 發現裝置；TXT 裡的 `port` 纔是 HTTP 埠。若只有一臺雲人升，會自動連線。
2. `connect`：發現 0 臺或多臺時，需傳入 `host`。
3. `status`：檢視版本；若低於 1.106.0 / 3.0.0，留意 `update` 提示。
4. 讀取列表：用 `list_data`（預設返回精簡欄位）。
5. 寫入操作：`complete_task` / `add_task` / `reward` / `purchase_item`；其餘走 `call_api`。需要彈出 App 介面時，加 `via=launch`。

刪除類介面需要 `confirm: true`。引數值不要預先做 URL 編碼。

## 事件

《人升》需開啟「實驗 → 廣播事件」（預設關；雲人升高級設定可檢視並一鍵開啟）；《雲人升》的 **WebSocket 事件推送預設開啟**（3.0.0+），只控制推送通道。

- `list_events` — `GET /events`，始終可用
- `subscribe_events` — `WS /events`，預設能連；若在雲人升中關閉開關會報錯，HTTP 介面仍可用

更多細節見 MCP `help broadcasts`。

<br/>

---

## 示例：獨立遊戲開發者體系

下面是一次真實 MCP 會話的成果：使用者讓 AI **清理人升自帶的開發者示例**，再以**獨立遊戲開發者**為主題，搭建完整的 RPG 體系（任務清單、屬性、商店、成就）。

你可以用類似的話術啟動：

> 幫我清理示例任務和商品，然後以「獨立遊戲開發者」為主題，建立完整的任務清單、屬性、商店商品和成就體系。

### 體系概覽

| 模組 | 內容 |
| --- | --- |
| 任務清單 | 晨間儀式、編碼日常、遊戲製作、深度學習、學習充電、收工儀式 |
| 屬性 | 執行力 / 技術力 / 協作力 / 專注力 / 健康值 / 創造力，以及「🎮 開發者屬性」（遊戲設計、除錯術、架構力） |
| 商店 | 「開發者補給」（消耗品）+「趣味收藏」（彩蛋道具） |
| 成就 | 「獨立開發者之路」清單（Hello World、首殺 Bug、Ship It! …） |

> [!TIP]
> 點選圖片可放大檢視。下方標籤頁可橫向切換，避免長頁滾動。

<!-- tabs:start -->

#### **1 · 編碼日常**

工作日迴圈：stand-up、Code Review、專注編碼 2 小時、每日修 Bug。任務帶經驗/金幣獎勵與週期標籤。

![編碼日常任務列表](_media/mcp/game-dev-example/01-tasks-coding-daily.jpg ':size=45%')

#### **2 · 學習充電與收工**

「全部」檢視下的另兩類清單：學習新技術 / 讀 GDC 文章；收工時的 Git 推送、寫開發日誌、備份專案。

![任務總覽](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **3 · 屬性**

基礎六維 + 「🎮 開發者屬性」分組。完成任務時，經驗可寫入對應屬性。

![屬性面板](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **4 · 趣味收藏**

彩蛋向商品：靈感骰子、RGB 鍵帽、桌寵貓、樂高磚、復古手柄、橡皮鴨等；部分帶隨機金幣或屬性加成。

![商店 · 趣味收藏](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **5 · 開發者補給**

日常消耗品：手衝咖啡、深夜拉麪、功能飲料、除錯餅乾、白噪音耳罩；描述與使用效果對應專注力 / 除錯術 / 協作力等。

![商店 · 開發者補給](_media/mcp/game-dev-example/05-shop-developer-supplies.jpg ':size=45%')

#### **6 · 成就清單**

里程碑式成就：首個任務、首殺 Bug、釋出 Demo、連續打卡、番茄鍾、小金庫、連擊等；可配 emoji 圖示與解鎖條件。

![成就清單](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **7 · 成就詳情**

帶進度條的複合條件示例：當前金幣達到 500。

![成就詳情 · 小金庫](_media/mcp/game-dev-example/07-achievement-detail.jpg ':size=45%')

<!-- tabs:end -->

### AI 大致會怎麼做

1. 用 `list_tasks` / `list_items` 摸清現有示例，按需刪除舊資料（刪除類操作需 `confirm: true`）。
2. 建立任務 / 商店 / 成就清單（`category`）。
3. 建立屬性與分組（`skill` / `skill_group`）。
4. 批次寫入任務、商品、成就（`add_task` / `add_item` / `achievement`）。
5. 在 App 內重新整理對應頁面驗收。

具體 API 引數見上文 [Skills](#skills) 與 [Agent 流程](#agent-流程)；單個方法的完整參數列可透過 MCP `help add_task` 等命令查閱。

<h1 align="center" padding="100">MCP & Skills</h1>

想讓 AI 幫你操作《人升》？這裏有兩層能力：

| | 做什麼 | 適合誰 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 發現雲人升、傳送 HTTP 請求、編碼引數、解析返回值 | Cursor、Claude Desktop、WorkBuddy，以及任意 MCP 客戶端 |
| **Skills** `lifeup-cloud/` | 連線方式、查詢思路、API 呼叫方法與引數說明 | 已內建於 MCP 的 `help`；Claude Code / Pi 也可當作磁碟技能使用 |

你電腦上的 Agent 會透過區域網連線手機裡的《雲人升》，再間接操作《人升》App。HTTP 介面細節仍以 [雲人升 API](guide/api_cloud.md) 爲準；MCP 原始碼見 [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0**+ 與 **雲人升 3.0.0**+。更早的版本或許能連上，但流水、統計、等級曲線等能力不完整；可透過 `status.update` 提示升級。

## 可以這樣問

裝好 MCP 後，不必記 API，直接跟 AI 說話即可，例如：

- 「幫我建一個『早起自律』成就清單，再加 8 個帶 emoji 的成就，完成時給點金幣。」
- 「看看我今天完成了什麼，幫我寫一段感想：做了什麼、哪裏還能改進。」
- 「從還沒做完的任務裡抽一個，最好 25 分鐘能做完。」
- 「這個月金幣都從哪來的？最大的幾筆，有沒有意外收穫。」
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

《人升》需開啟「實驗 → 廣播事件」；《雲人升》的 **WebSocket 事件推送預設開啟**（3.0.0+）。

- `list_events` — `GET /events`，始終可用
- `subscribe_events` — `WS /events`，預設能連；若在雲人升中關閉開關會報錯，HTTP 介面仍可用

更多細節見 MCP `help broadcasts`。

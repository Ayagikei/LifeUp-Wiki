<h1 align="center" padding="100">MCP & Skills</h1>

給 AI 用的兩層：

| | 做什麼 | 給誰 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 發現雲人升、發 HTTP、編碼、解析返回值 | Cursor / Claude Desktop / WorkBuddy / 任何 MCP 客戶端 |
| **Skills** `lifeup-cloud/` | 怎麼連、查什麼、怎麼調 API、參數列 | 打進 MCP 的 `help`；Claude Code / Pi 也可以當磁碟技能 |

電腦上的 Agent 經區域網連手機裡的《雲人升》，再操作《人升》。HTTP 仍以 [雲人升](guide/api_cloud.md) 爲準。原始碼：[LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0+** 和 **雲人升 3.0.0+**。更舊也能連，但流水、統計、等級曲線等沒有。`status.update` 會提示升級。

## 可以這樣問

裝好 MCP 之後，直接跟 AI 說話就行，例如：

- 「幫我建一個『早起自律』成就清單，再加 8 個帶 emoji 的成就，完成給金幣。」
- 「看看我今天完成了什麼，寫一段感想：做了什麼、哪裡可以改進。」
- 「從還沒做完的任務裡抽一個，最好 25 分鐘能做完。」
- 「這個月金幣都從哪來的？最大的幾筆，有沒有意外收穫。」
<br/>

## Skills

原始檔：[`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud)。沒有第二份 npm 包。

- **Cursor / Claude Desktop / WorkBuddy：** 只裝 MCP。`help` 讀的就是這份技能，不要再裝一次。
- **Claude Code / Pi / 自己改流程：** 把該目錄拷到 agent 的 skills 路徑，或直接指向倉庫裡的資料夾。

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 連線 + 常用操作（先讀這個）
  references/
    basics.md              錯誤、編碼、JSON、超時
    discovery.md           mDNS / Token
    query.md               list_data 資源
    tasks.md / economy.md
    api-index.md           全部方法一行說明
    methods/*.md           單個方法的完整參數列（用到再讀）
    broadcasts.md / gaps.md
```

Agent 漸進披露：

1. `help`（或磁碟 `SKILL.md`）— 工作流
2. `help api-index` — 有哪些方法
3. `help add_task` — 這個方法的引數
4. `call_api` / `list_data`

改技能：拷走目錄，改 `SKILL.md` 和 `references/`。MCP 的 `help` 仍讀安裝包裡那份，除非你改的是 MCP 原始碼再構建。

<br/>

## 準備

1. 手機和電腦同一區域網
2. 人升執行中，雲人升已授權 **讀取人升資料**
3. 雲人升已啟動（預設 `13276`）
4. 電腦 [Node.js 20+](https://nodejs.org/)

Token 可選。請求頭是 **原始 Token**，不要 `Bearer`。

<br/>

## 安裝 MCP

尚未上架 npm 時，GitHub 即可：

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

`npx` 會 clone 倉庫並編譯 `mcp/`。合進 `main` 後去掉 `#feat/mcp`。

macOS 圖形介面客戶端往往找不到 `npx`，用 `npx`/`node` 絕對路徑，或 clone 後 `cd mcp && npm install && npm run build`。

| 變數 | 作用 |
|---|---|
| `LIFEUP_HOST` | `192.168.1.8:13276`，跳過 mDNS |
| `LIFEUP_TOKEN` | 只在程序內，不寫磁碟 |
| `LIFEUP_MCP_CONFIG` | 自定義配置路徑 |

上架後可用 `npx -y @lifeup/mcp`（中國大陸 npmmirror）。
<br/>

## Agent 流程

1. `discover`：mDNS `_lifeup._tcp`，TXT `port` 纔是 HTTP 埠。只有一臺會自動連。
2. `connect`：0 臺或多臺時傳 `host`。
3. `status`：版本。低於 1.106.0 / 3.0.0 看 `update`。
4. 列表：`list_data`（預設精簡欄位）。
5. 寫入：`complete_task` / `add_task` / `reward` / `purchase_item`，其餘 `call_api`。要彈介面用 `via=launch`。

刪除類介面要 `confirm: true`。引數不要預先 URL 編碼。

## 事件

人升要開「實驗 → 廣播事件」。雲人升 **WebSocket 事件推送預設開**（3.0.0+）。

- `list_events` — `GET /events`，一直可用
- `subscribe_events` — `WS /events`，預設能連；關了雲人升開關會報錯，HTTP 仍可用

細節：MCP `help broadcasts`。

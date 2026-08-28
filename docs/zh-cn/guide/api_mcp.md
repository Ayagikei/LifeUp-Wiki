<h1 align="center" padding="100">MCP & Skills</h1>

想让 AI 帮你操作《人升》？这里有两层能力：

| | 做什么 | 适合谁 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 发现云人升、发送 HTTP 请求、编码参数、解析返回值 | Cursor、Claude Desktop、WorkBuddy，以及任意 MCP 客户端 |
| **Skills** `lifeup-cloud/` | 连接方式、查询思路、API 调用方法与参数说明 | 已内置于 MCP 的 `help`；Claude Code / Pi 也可当作磁盘技能使用 |

你电脑上的 Agent 会通过局域网连接手机里的《云人升》，再间接操作《人升》App。HTTP 接口细节仍以 [云人升 API](guide/api_cloud.md) 为准；MCP 源码见 [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0**+ 与 **云人升 3.0.0**+。更早的版本或许能连上，但流水、统计、等级曲线等能力不完整；可通过 `status.update` 提示升级。

## 可以这样问

装好 MCP 后，不必记 API，直接跟 AI 说话即可，例如：

- 「帮我建一个『早起自律』成就清单，再加 8 个带 emoji 的成就，完成时给点金币。」
- 「看看我今天完成了什么，帮我写一段感想：做了什么、哪里还能改进。」
- 「从还没做完的任务里抽一个，最好 25 分钟能做完。」
- 「这个月金币都从哪来的？最大的几笔，有没有意外收获。」
<br/>

## Skills

技能文件位于 [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud)（仓库内仅此一份，没有单独的 npm 包）。

- **Cursor / Claude Desktop / WorkBuddy**：只安装 MCP 即可；`help` 读的就是这份技能，无需重复安装。
- **Claude Code / Pi / 自定义流程**：把整个目录复制到 agent 的 skills 路径，或直接指向仓库中的文件夹。

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 连接与常用操作（建议先读）
  references/
    basics.md              错误处理、编码、JSON、超时
    discovery.md           mDNS / Token
    query.md               list_data 资源
    tasks.md / economy.md
    api-index.md           全部方法的一行说明
    methods/*.md           单个方法的完整参数表（用到再读）
    broadcasts.md / gaps.md
```

Agent 会按「渐进披露」的方式查阅文档：

1. `help`（或磁盘上的 `SKILL.md`）— 了解整体工作流
2. `help api-index` — 查看有哪些方法
3. `help add_task` — 查看某个方法的参数
4. `call_api` / `list_data` — 真正发起调用

若要自定义技能：复制该目录，修改 `SKILL.md` 和 `references/` 即可。MCP 的 `help` 默认仍读取安装包内的版本；只有在你修改 MCP 源码并重新构建后，才会生效。

<br/>

## 使用前准备

1. 手机与电脑在同一局域网
2. 《人升》正在运行，且已向《云人升》授权 **读取人升数据**
3. 《云人升》已启动（默认端口 `13276`）
4. 电脑上已安装 [Node.js 20+](https://nodejs.org/)

Token 可选；若填写，请求头里写**原始 Token**，不要加 `Bearer` 前缀。

<br/>

## 安装 MCP

包尚未上架 npm 时，可直接从 GitHub 安装：

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

`npx` 会自动 clone 仓库并编译 `mcp/`。合入 `main` 分支后，可去掉 `#feat/mcp`。

macOS 上的图形界面客户端往往找不到 `npx`，可改用 `npx`/`node` 的绝对路径，或手动 clone 后执行 `cd mcp && npm install && npm run build`。

| 变量 | 作用 |
|---|---|
| `LIFEUP_HOST` | 如 `192.168.1.8:13276`，跳过 mDNS 发现 |
| `LIFEUP_TOKEN` | 仅保存在进程内，不会写入磁盘 |
| `LIFEUP_MCP_CONFIG` | 自定义配置文件路径 |

上架后可用 `npx -y @lifeup/mcp`（国内可用 npmmirror）。
<br/>

## Agent 流程

1. `discover`：通过 mDNS `_lifeup._tcp` 发现设备；TXT 里的 `port` 才是 HTTP 端口。若只有一台云人升，会自动连接。
2. `connect`：发现 0 台或多台时，需传入 `host`。
3. `status`：查看版本；若低于 1.106.0 / 3.0.0，留意 `update` 提示。
4. 读取列表：用 `list_data`（默认返回精简字段）。
5. 写入操作：`complete_task` / `add_task` / `reward` / `purchase_item`；其余走 `call_api`。需要弹出 App 界面时，加 `via=launch`。

删除类接口需要 `confirm: true`。参数值不要预先做 URL 编码。

## 事件

《人升》需开启「实验 → 广播事件」；《云人升》的 **WebSocket 事件推送默认开启**（3.0.0+）。

- `list_events` — `GET /events`，始终可用
- `subscribe_events` — `WS /events`，默认能连；若在云人升中关闭开关会报错，HTTP 接口仍可用

更多细节见 MCP `help broadcasts`。

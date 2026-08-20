<h1 align="center" padding="100">MCP & Skills</h1>

给 AI 用的两层：

| | 做什么 | 给谁 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 发现云人升、发 HTTP、编码、解析返回值 | Cursor / Claude Desktop / WorkBuddy / 任何 MCP 客户端 |
| **Skills** `lifeup-cloud/` | 怎么连、查什么、怎么调 API、参数表 | 打进 MCP 的 `help`；Claude Code / Pi 也可以当磁盘技能 |

电脑上的 Agent 经局域网连手机里的《云人升》，再操作《人升》。HTTP 仍以 [云人升](guide/api_cloud.md) 为准。源码：[LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0+** 和 **云人升 3.0.0+**。更旧也能连，但流水、统计、等级曲线等没有。`status.update` 会提示升级。

<br/>

## Skills

源文件：[`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud)。没有第二份 npm 包。

- **Cursor / Claude Desktop / WorkBuddy：** 只装 MCP。`help` 读的就是这份技能，不要再装一次。
- **Claude Code / Pi / 自己改流程：** 把该目录拷到 agent 的 skills 路径，或直接指向仓库里的文件夹。

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 连接 + 常用操作（先读这个）
  references/
    basics.md              错误、编码、JSON、超时
    discovery.md           mDNS / Token
    query.md               list_data 资源
    tasks.md / economy.md
    api-index.md           全部方法一行说明
    methods/*.md           单个方法的完整参数表（用到再读）
    broadcasts.md / gaps.md
```

Agent 渐进披露：

1. `help`（或磁盘 `SKILL.md`）— 工作流
2. `help api-index` — 有哪些方法
3. `help add_task` — 这个方法的参数
4. `call_api` / `list_data`

改技能：拷走目录，改 `SKILL.md` 和 `references/`。MCP 的 `help` 仍读安装包里那份，除非你改的是 MCP 源码再构建。

<br/>

## 准备

1. 手机和电脑同一局域网
2. 人升运行中，云人升已授权 **读取人升数据**
3. 云人升已启动（默认 `13276`）
4. 电脑 [Node.js 20+](https://nodejs.org/)

Token 可选。请求头是 **原始 Token**，不要 `Bearer`。

<br/>

## 安装 MCP

尚未上架 npm 时从仓库构建：

```bash
git clone https://github.com/Ayagikei/LifeUp-SDK.git
cd LifeUp-SDK/mcp
npm install
npm run build
```

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "node",
      "args": ["/绝对路径/LifeUp-SDK/mcp/dist/index.js"]
    }
  }
}
```

macOS 图形界面客户端往往找不到 `npx`，用 `node` 绝对路径。

| 变量 | 作用 |
|---|---|
| `LIFEUP_HOST` | `192.168.1.8:13276`，跳过 mDNS |
| `LIFEUP_TOKEN` | 只在进程内，不写磁盘 |
| `LIFEUP_MCP_CONFIG` | 自定义配置路径 |

上架后可用 `npx -y @lifeup/mcp`（国内 npmmirror）。

<br/>

## Agent 流程

1. `discover`：mDNS `_lifeup._tcp`，TXT `port` 才是 HTTP 端口。只有一台会自动连。
2. `connect`：0 台或多台时传 `host`。
3. `status`：版本。低于 1.106.0 / 3.0.0 看 `update`。
4. 列表：`list_data`（默认精简字段）。
5. 写入：`complete_task` / `add_task` / `reward` / `purchase_item`，其余 `call_api`。要弹界面用 `via=launch`。

删除类接口要 `confirm: true`。参数不要预先 URL 编码。

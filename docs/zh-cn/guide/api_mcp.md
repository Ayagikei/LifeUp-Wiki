<h1 align="center" padding="100">MCP & Skills</h1>

想让 AI 帮你操作《人升》？这里有两层能力：

| | 做什么 | 适合谁 |
|---|---|---|
| **MCP** `@lifeup/mcp` | 发现云人升、发送 HTTP 请求、编码参数、解析返回值 | Cursor、Claude Desktop、WorkBuddy，以及任意 MCP 客户端 |
| **Skills** `lifeup-cloud/` | 连接方式、查询思路、API 调用方法与参数说明 | 已内置于 MCP 的 `help`；Claude Code / Pi 也可当作磁盘技能使用 |

你电脑上的 Agent 会通过局域网连接手机里的《云人升》，再间接操作《人升》App。HTTP 接口细节仍以 [云人升 API](guide/api_cloud.md) 为准；MCP 源码见 [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> 需要 **人升 1.106.0**+ 与 **云人升 3.0.0**+。更早的版本或许能连上，但流水、统计、等级曲线等能力不完整；可通过 `status.update` 提示升级。

MCP 提供 Agent **读写 API** 的能力；AI 在此基础上做**理解与决策**——例如按优先级整理今日待办、从流水/统计中归纳本周数据、根据属性等级设计练级任务；也可以**一句话搭建完整主题体系**（独立游戏开发者、魔法学院等），而不只是拉取原始列表。

## 可以这样问

装好 MCP 后，不必记 API，直接跟 AI 说话即可。

**规划今天**

- 「今天还剩什么任务？按优先级帮我整理，并建议先做哪几件。」
- 「从还没做完的任务里抽一个，最好 25 分钟能做完。」

**分析数据**

- 「拉取本周番茄、专注、金币、经验数据，分析主要来源并写一段汇报。」
- 「这个月金币都从哪来的？最大的几笔，有没有意外收获。」

**教练与设计**

- 「看看我各属性的等级，帮我设计一批日常任务，专门提升偏弱的属性。」

**一句话搭建主题体系**

- 「清理示例，然后以独立游戏开发者为主题，搭建完整的清单、商店、成就与属性体系。」
- 「以魔法学院为主题，帮我设计一整套 RPG 日常：任务、属性、商店道具和成就。」

**回顾与创作**

- 「看看我今天完成了什么，帮我写一段感想：做了什么、哪里还能改进。」
- 「帮我建一个『早起自律』成就清单，再加 8 个带 emoji 的成就，完成时给点金币。」
<br/>

## 快速使用

把下面这句话发给 Agent，让它按文档完成 MCP 安装与首次连接即可：

```
按这份文档帮我安装 LifeUp MCP 并完成首次连接：https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/zh-cn/guide/api_mcp.md
```

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

本地已 clone [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) 时，推荐用安装脚本（编译 MCP，写入已检测到的客户端；重复运行会更新，不会再注册一份）：

```bash
./scripts/install-mcp.sh
```

默认覆盖 Codex、Cursor、Claude Code、Claude Desktop、Pi。Pi 若已 `imports: ["codex"]`，会沿用 Codex 的配置，避免重复。

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

<br/>

---

## 示例：独立游戏开发者体系

下面是一次真实 MCP 会话的成果：用户让 AI **清理人升自带的开发者示例**，再以**独立游戏开发者**为主题，搭建完整的 RPG 体系（任务清单、属性、商店、成就）。

你可以用类似的话术启动：

> 帮我清理示例任务和商品，然后以「独立游戏开发者」为主题，创建完整的任务清单、属性、商店商品和成就体系。

### 体系概览

| 模块 | 内容 |
| --- | --- |
| 任务清单 | 晨间仪式、编码日常、游戏制作、深度学习、学习充电、收工仪式 |
| 属性 | 执行力 / 技术力 / 协作力 / 专注力 / 健康值 / 创造力，以及「🎮 开发者属性」（游戏设计、调试术、架构力） |
| 商店 | 「开发者补给」（消耗品）+「趣味收藏」（彩蛋道具） |
| 成就 | 「独立开发者之路」清单（Hello World、首杀 Bug、Ship It! …） |

> [!TIP]
> 点击图片可放大查看。下方标签页可横向切换，避免长页滚动。

<!-- tabs:start -->

#### **1 · 编码日常**

工作日循环：stand-up、Code Review、专注编码 2 小时、每日修 Bug。任务带经验/金币奖励与周期标签。

![编码日常任务列表](_media/mcp/game-dev-example/01-tasks-coding-daily.jpg ':size=45%')

#### **2 · 学习充电与收工**

「全部」视图下的另两类清单：学习新技术 / 读 GDC 文章；收工时的 Git 推送、写开发日志、备份项目。

![任务总览](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **3 · 属性**

基础六维 + 「🎮 开发者属性」分组。完成任务时，经验可写入对应属性。

![属性面板](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **4 · 趣味收藏**

彩蛋向商品：灵感骰子、RGB 键帽、桌宠猫、乐高砖、复古手柄、橡皮鸭等；部分带随机金币或属性加成。

![商店 · 趣味收藏](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **5 · 开发者补给**

日常消耗品：手冲咖啡、深夜拉面、功能饮料、调试饼干、白噪音耳罩；描述与使用效果对应专注力 / 调试术 / 协作力等。

![商店 · 开发者补给](_media/mcp/game-dev-example/05-shop-developer-supplies.jpg ':size=45%')

#### **6 · 成就清单**

里程碑式成就：首个任务、首杀 Bug、发布 Demo、连续打卡、番茄钟、小金库、连击等；可配 emoji 图标与解锁条件。

![成就清单](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **7 · 成就详情**

带进度条的复合条件示例：当前金币达到 500。

![成就详情 · 小金库](_media/mcp/game-dev-example/07-achievement-detail.jpg ':size=45%')

<!-- tabs:end -->

### AI 大致会怎么做

1. 用 `list_tasks` / `list_items` 摸清现有示例，按需删除旧数据（删除类操作需 `confirm: true`）。
2. 创建任务 / 商店 / 成就清单（`category`）。
3. 创建属性与分组（`skill` / `skill_group`）。
4. 批量写入任务、商品、成就（`add_task` / `add_item` / `achievement`）。
5. 在 App 内刷新对应页面验收。

具体 API 参数见上文 [Skills](#skills) 与 [Agent 流程](#agent-流程)；单个方法的完整参数表可通过 MCP `help add_task` 等命令查阅。

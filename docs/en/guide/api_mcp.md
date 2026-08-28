<h1 align="center" padding="100">MCP & Skills</h1>

Want AI to work with LifeUp? There are two layers:

| | What it does | Who uses it |
|---|---|---|
| **MCP** `@lifeup/mcp` | Discover LifeUp Cloud, send HTTP requests, encode params, parse responses | Cursor, Claude Desktop, WorkBuddy, and any MCP client |
| **Skills** `lifeup-cloud/` | How to connect, what to query, and how to call each API | Bundled as MCP `help`; Claude Code / Pi can also load the folder as a disk skill |

The agent on your computer reaches LifeUp Cloud on your phone over the LAN, then talks to LifeUp. HTTP details stay in the [LifeUp Cloud API](guide/api_cloud.md). MCP source: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Requires **LifeUp 1.106.0**+ and **LifeUp Cloud 3.0.0**+. Older builds may still connect, but journals, stats, and the level curve are incomplete. `status.update` can prompt the user to upgrade.

MCP gives the agent **read/write APIs**; the AI layer adds **reasoning**—prioritizing today's backlog, summarizing weekly stats from journals, designing tasks from your attribute levels, or **building a full themed gamification setup in one prompt** (indie game dev, magic academy, and more)—not just fetching raw lists.

## Try asking

Once MCP is installed, you do not need to memorize APIs—just talk to the AI.

**Plan your day**

- “What's left today? Sort by priority and tell me what to tackle first.”
- “Pick one unfinished task I can finish in about 25 minutes.”

**Analyze your data**

- “Pull this week's pomodoro, focus, coin, and XP stats—break down where they came from and summarize the patterns.”
- “Where did my coins come from this month? Show the biggest sources and anything surprising.”

**Coach & design**

- “Look at my attribute levels and design a set of daily tasks to level up my weaker skills.”

**One-shot themed setup**

- “Clear the samples, then build a full indie game developer setup: lists, shop, achievements, and attributes.”
- “Design a complete magic-academy RPG routine—tasks, attributes, shop items, and achievements.”

**Reflect**

- “Look at what I finished today and write a short journal: what I did, and what I could improve tomorrow.”
- “Make an achievement list called Morning Routine, then add 8 achievements with emoji icons and coin rewards.”
<br/>

## Quick start

Send this one-liner to your agent to install MCP and connect for the first time:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Skill files live in [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (one copy in the repo—no separate npm package).

- **Cursor / Claude Desktop / WorkBuddy:** install the MCP only. `help` reads this skill; do not install it twice.
- **Claude Code / Pi / custom workflow:** copy the folder into the agent's skills path, or point directly at the repo.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connect + common ops (read this first)
  references/
    basics.md              errors, encoding, JSON, timeouts
    discovery.md           mDNS / token
    query.md               list_data resources
    tasks.md / economy.md
    api-index.md           one line per method
    methods/*.md           full param table (load when calling)
    broadcasts.md / gaps.md
```

The agent reads docs progressively:

1. `help` (or disk `SKILL.md`) — overall workflow
2. `help api-index` — which methods exist
3. `help add_task` — params for one method
4. `call_api` / `list_data` — make the call

To customize: copy the folder and edit `SKILL.md` and `references/`. MCP `help` still reads the packaged copy unless you rebuild MCP from your fork.

<br/>

## Setup

1. Phone and computer on the same LAN
2. LifeUp running, with Cloud granted **Read LifeUp Data**
3. LifeUp Cloud started (default port `13276`)
4. [Node.js 20+](https://nodejs.org/) on the computer

Token is optional. If set, send the **raw** token in the header—not `Bearer`.

<br/>

## Install MCP

Until the package is on npm, install from GitHub:

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

`npx` clones the repo and builds `mcp/`. After this lands on `main`, drop `#feat/mcp`.

If you already cloned [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), use the installer (builds MCP and upserts detected clients; re-runs do not register a second copy):

```bash
./scripts/install-mcp.sh
```

Default clients: Codex, Cursor, Claude Code, Claude Desktop, Pi. Pi configs that `imports: ["codex"]` inherit Codex and are not duplicated.

GUI apps on macOS often lack `npx` on `PATH`—use an absolute `npx`/`node` path, or clone and run `cd mcp && npm install && npm run build`.

| Variable | Role |
|---|---|
| `LIFEUP_HOST` | e.g. `192.168.1.8:13276`, skip mDNS |
| `LIFEUP_TOKEN` | Process-only, never written to disk |
| `LIFEUP_MCP_CONFIG` | Custom config path |

After publish: `npx -y @lifeup/mcp` (npmmirror in China).
<br/>

## Agent workflow

1. `discover` — mDNS `_lifeup._tcp`; the TXT `port` is the HTTP port. Auto-connects if exactly one Cloud instance is found.
2. `connect` — pass `host` when zero or several instances are found.
3. `status` — check versions; if below 1.106.0 / 3.0.0, watch for `update`.
4. Lists: `list_data` (compact fields by default).
5. Writes: `complete_task` / `add_task` / `reward` / `purchase_item`; everything else via `call_api`. Use `via=launch` to open the App UI.

Destructive calls need `confirm: true`. Do not pre-encode parameter values.

## Events

LifeUp: enable Labs → Broadcast events (off by default; Cloud Advanced can show status and enable it). Cloud **WebSocket event push is on by default** (3.0.0+) and is transport only.

- `list_events` — `GET /events`, always available
- `subscribe_events` — `WS /events`; errors if the Cloud toggle is off, HTTP still works

Details: MCP `help broadcasts`.

<br/>

---

## Example: Indie game developer setup

Below is the outcome of a real MCP session: the user asked AI to **clear LifeUp's built-in developer samples**, then build a full RPG-style setup around **indie game development** (task lists, attributes, shop, achievements).

You can start with prompts like:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### What was built

| Area | Content |
| --- | --- |
| Task lists | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Attributes | Execution / Technical / Collaboration / Focus / Wellness / Creativity, plus **Developer Stats** (Game Design, Debugging, Architecture) |
| Shop | **Dev Supplies** (consumables) + **Fun Collectibles** (easter-egg items) |
| Achievements | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Click any image to zoom. Use the tabs below to switch horizontally instead of scrolling a long page.

<!-- tabs:start -->

#### **1 · Tasks overview**

Morning Ritual recurring tasks in the **All** view, with category chips for Coding Daily, Game Dev, and more.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Attributes**

Core six attributes plus the **Developer Stats** group. Completing tasks grants EXP to the matching skills.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Easter-egg shop items: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — some with random coins or attribute bonuses.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Achievements**

Milestone achievements: first task, first bug fix, ship a demo, streaks, pomodoros, Piggy Bank, Daily Pentakill, and more — with emoji icons and unlock conditions.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Piggy Bank detail**

Progress-style condition example: reach **500 coins** current balance.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Daily Pentakill detail**

Counter condition example: complete **5 different tasks in one day**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### What the AI typically does

1. `list_tasks` / `list_items` — inspect existing samples; delete old rows when needed (`confirm: true` for destructive calls).
2. Create task / shop / achievement lists (`category`).
3. Create attributes and groups (`skill` / `skill_group`).
4. Batch-write tasks, items, and achievements (`add_task` / `add_item` / `achievement`).
5. Refresh the matching screens in the App to verify.

For API params see [Skills](#skills) and [Agent workflow](#agent-workflow) above; per-method tables via MCP `help add_task`, etc.

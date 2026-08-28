<h1 align="center" padding="100">MCP & Skills</h1>

Want AI to work with LifeUp? There are two layers:

| | What it does | Who uses it |
|---|---|---|
| **MCP** `@lifeup/mcp` | Discover LifeUp Cloud, send HTTP requests, encode params, parse responses | Cursor, Claude Desktop, WorkBuddy, and any MCP client |
| **Skills** `lifeup-cloud/` | How to connect, what to query, and how to call each API | Bundled as MCP `help`; Claude Code / Pi can also load the folder as a disk skill |

The agent on your computer reaches LifeUp Cloud on your phone over the LAN, then talks to LifeUp. HTTP details stay in the [LifeUp Cloud API](guide/api_cloud.md). MCP source: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Requires **LifeUp 1.106.0**+ and **LifeUp Cloud 3.0.0**+. Older builds may still connect, but journals, stats, and the level curve are incomplete. `status.update` can prompt the user to upgrade.

## Try asking

Once MCP is installed, you do not need to memorize APIs—just talk to the AI, for example:

- “Make an achievement list called Morning Routine, then add 8 achievements with emoji icons and coin rewards.”
- “Look at what I finished today and write a short journal: what I did, and what I could improve tomorrow.”
- “Pick a random unfinished task I can finish in about 25 minutes.”
- “Where did my coins come from this month? Show the biggest sources, and anything surprising.”
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

LifeUp: enable Labs → Broadcast events. Cloud **WebSocket event push is on by default** (3.0.0+).

- `list_events` — `GET /events`, always available
- `subscribe_events` — `WS /events`; errors if the Cloud toggle is off, HTTP still works

Details: MCP `help broadcasts`.

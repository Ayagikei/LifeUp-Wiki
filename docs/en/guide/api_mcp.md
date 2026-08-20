<h1 align="center" padding="100">MCP & Skills</h1>

Two layers for AI:

| | Job | Who uses it |
|---|---|---|
| **MCP** `@lifeup/mcp` | Discover Cloud, HTTP, encoding, return values | Cursor / Claude Desktop / WorkBuddy / any MCP client |
| **Skills** `lifeup-cloud/` | How to connect, what to query, how to call APIs | Bundled as MCP `help`; Claude Code / Pi can also load the folder |

The agent on your computer talks to LifeUp Cloud on the phone, then to LifeUp. HTTP stays on [LifeUp Cloud](guide/api_cloud.md). Source: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Needs **LifeUp 1.106.0+** and **LifeUp Cloud 3.0.0+**. Older builds may connect, but journals, stats, and the level curve are missing. `status.update` asks the user to upgrade.

<br/>

## Skills

Canonical files: [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud). No second npm package.

- **Cursor / Claude Desktop / WorkBuddy:** install the MCP only. `help` is this skill. Do not install it twice.
- **Claude Code / Pi / custom workflow:** copy the folder into the agent's skills path, or point at the repo.

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

Progressive disclosure:

1. `help` (or disk `SKILL.md`) — workflow
2. `help api-index` — which methods exist
3. `help add_task` — that method's params
4. `call_api` / `list_data`

To customize: copy the folder, edit `SKILL.md` and `references/`. MCP `help` still reads the packaged copy unless you rebuild MCP from your fork.

<br/>

## Setup

1. Phone and computer on the same LAN
2. LifeUp running, Cloud granted **Read LifeUp Data**
3. LifeUp Cloud started (default `13276`)
4. [Node.js 20+](https://nodejs.org/)

Token optional. Header is the **raw** token, not `Bearer`.

<br/>

## Install MCP

Until npm publish, build from the repo:

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
      "args": ["/ABS/PATH/LifeUp-SDK/mcp/dist/index.js"]
    }
  }
}
```

GUI apps on macOS often lack `npx` on `PATH` — use an absolute `node` path.

| Variable | Role |
|---|---|
| `LIFEUP_HOST` | `192.168.1.8:13276`, skip mDNS |
| `LIFEUP_TOKEN` | Process-only, never written to disk |
| `LIFEUP_MCP_CONFIG` | Custom config path |

After publish: `npx -y @lifeup/mcp` (npmmirror in China).

<br/>

## Agent workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT `port` is HTTP. Auto-connects if exactly one Cloud.
2. `connect` — pass `host` if zero or several instances.
3. `status` — versions. Below 1.106.0 / 3.0.0 → `update`.
4. Lists: `list_data` (compact by default).
5. Writes: `complete_task` / `add_task` / `reward` / `purchase_item`; else `call_api`. UI needs `via=launch`.

Destructive calls need `confirm: true`. Do not pre-encode params.

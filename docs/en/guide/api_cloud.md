<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud is one of the core API toolkits for LifeUp. It turns your phone into an **API bridge**: control LifeUp from your **computer or other devices**, build **custom integrations** (desktop, web, automation scripts), or pair it with **AI agents**.

### Typical scenarios

| Scenario | Who it's for | In one sentence | Learn more |
| --- | --- | --- | --- |
| **HTTP + build your own** | Developers, automation users | Call APIs and query data from Python, web apps, or scripts over LAN — no Android experience required | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **QR scanning** | Real-world check-in fans | Print QR codes to complete tasks, start timers, open dialogs, or launch web pages / other apps | [QR code scanning](#qr-code-scanning) |
| **Start / stop shortcuts** | Automation, NFC, Tasker | `lifeupcloud://start` and `lifeupcloud://stop` open Cloud and start or stop the HTTP server | [Start and stop](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude, etc. | One prompt to build task lists, shop items, achievements, and more | [MCP & Skills](guide/api_mcp.md) |
> **Example AI prompt:** Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

<br/>

## Download

- If you use the Mainland China membership version, you can find the LifeUp Cloud download entry in `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Start and stop the Cloud service :id=cloud-scheme

You can start or stop the HTTP server without tapping **Start Service**, using these URL schemes:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Opening either URL launches LifeUp Cloud and applies the action. Use them as a home-screen shortcut, NFC tag, Tasker/automation action, or:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

The same URLs are listed on the Cloud status card — tap to copy.

> [!NOTE]
> `lifeupcloud://` controls the Cloud HTTP server itself. It is not a `lifeup://api/…` game API.

<br/>

## QR code scanning

The **Scan** button at the top of LifeUp Cloud reads the URL encoded in a QR code and opens it immediately — no manual entry.

Scanning is **not limited to LifeUp APIs**: `lifeup://api/…`, web pages `https://…`, and other app URL schemes (e.g. `weixin://`) all work — Android opens the matching target.

### How to use

1. Pick a URL from LifeUp or the wiki [API list](guide/api.md) (complete a task, start a pomodoro, open purchase/use dialogs, or open an external web page).

2. Generate a QR code from the full URL (print and stick it on a desk, wall, or device).

3. Open LifeUp Cloud, tap **Scan** (tap **?** next to it for a short in-app guide), and point at the code.

### What you can do

| Scenario | Example (illustrative) |
| --- | --- |
| Pomodoro check-in | `lifeup://api/pomodoro?...` start/stop timer |
| Task check-in | `lifeup://api/complete?name=...` complete a task |
| Shop interaction | `lifeup://api/goto?page=shop` or purchase/use dialogs |
| Reward / penalty | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web mini-game | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Other apps | `weixin://`, `intent://`, or any installed app's scheme |
| Custom flows | Any scannable URL combination |

### Real-world interaction

QR codes map **physical places or actions** to in-app gamification:

- **Gym equipment** sticker → scan to complete a strength-training task

- **Study desk** sticker → scan to start a focus pomodoro

- **Workstation** sticker → scan to log stand-up or code review

- **Event board** sticker → scan to claim a reward or open an achievement

In short: **turn URL Schemes into scannable physical triggers**, with LifeUp Cloud as the executor between the app and the real world.

<br/>

> [!NOTE]
> LifeUp Cloud is a LAN-only HTTP bridge. How you reach your phone—IP address, router, firewall, same subnet, VPN, or AP isolation—depends on your home network. If you cannot connect, we cannot debug your personal LAN. Check your own networking, use standard network tools, or ask an AI agent for help.

## HTTP API Definition

> [!WARNING]
> API docs on this page may lag behind implementation updates. Please use source code as the final reference: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme Invocation API

#### GET

Function:

> Invoke APIs that start with `lifeup://api`.

Request URL:

```txt
// Recommended: content provider mode (better compatibility)
http://{host:port}/api/contentprovider

// startActivity mode (some devices may block background UI)
http://{host:port}/api
```

**Method: `GET`**

**Query parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| url | API URL starting with `lifeup://api` | Query | string | Yes | URL-encode when constructing manually. Multiple `url` params are supported. |

**Request examples:**

```txt
// Single call (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Batch call
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Single call (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Function:

> Invoke APIs that start with `lifeup://api`.

Request URL:

```txt
// Recommended: content provider mode (better compatibility)
http://{host:port}/api/contentprovider

// startActivity mode (some devices may block background UI)
http://{host:port}/api
```

**Method: `POST`**

**JSON body parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| urls | Array of URLs starting with `lifeup://api` | Body | List<string> | Yes | No extra URL encoding needed in JSON body. |

**Request example:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. Data Query APIs

> [!NOTE]
> Requirements:
> 1. LifeUp v1.91+ and the latest LifeUp Cloud.
> 2. Grant **Read LifeUp Data** permission in LifeUp Cloud.

Function:

> Query full LifeUp data sets, such as tasks and items.

**Task endpoints**

```txt
// All tasks
http://{host:port}/tasks

// Tasks in category/list ${id}
http://{host:port}/tasks/${id}

// History (supports pagination)
// gid is optional and can be used to filter all history records of a repeating task
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Task categories
http://{host:port}/tasks_categories
```

**Item endpoints**

```txt
// All items
http://{host:port}/items

// Items in category/list ${id}
http://{host:port}/items/${id}

// Item categories
http://{host:port}/items_categories

// Include hidden lists
http://{host:port}/items_categories?include_hidden=true
```

**Achievement endpoints**

```txt
// All achievements
http://{host:port}/achievements

// Achievements in category/list ${id}
http://{host:port}/achievements/${id}

// Achievement categories
http://{host:port}/achievement_categories
```

**Feeling endpoints**

```txt
// All feelings (supports pagination)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Synthesis category endpoints**

```txt
// All synthesis categories
http://{host:port}/synthesis_categories

// Synthesis categories in list ${id}
http://{host:port}/synthesis_categories/${id}
```

**Synthesis recipe endpoints**

```txt
// All synthesis recipes
http://{host:port}/synthesis

// Synthesis recipes in category ${id}
http://{host:port}/synthesis/${id}
```

**Attribute endpoints**

```txt
// All attributes
http://{host:port}/skills
```


**Other**

```txt
// Coin balance
http://{host:port}/coin

// LifeUp / Cloud versions
http://{host:port}/info

// Pomodoro records (paged; optional time range)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Journals (paged; optional time range). Soft-deleted rows omitted.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// All achievements (implemented; category id optional)
http://{host:port}/achievements

// Broadcast events (LifeUp Labs → Broadcast events must be on)
http://{host:port}/events?after=${id}&limit=50

// WebSocket push (on by default; Cloud setting WebSocket event push)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` is transport OK only. `10001` LifeUp not running or Read Data not granted. `10002` ContentProvider query failed.

### List field values

| Endpoint | Field | Values |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` unfinished · `1` done · `2` overdue · `3` given up |
| `/tasks` | `frequency` | `0` once · `1` daily · `N>1` every N days · `-1` unlimited · `-3` Ebbinghaus · `-4` monthly · `-5` yearly |
| `/tasks` | `weekdays` | `1,3,5` (Mon=1 … Sun=7). Empty when not weekday mode. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` archived |
| `/tasks_categories` | `type` | `<10` normal · `10` daily · `11` weekly · `12` monthly · `20` doing |
| `/achievements` | `status` | `0` locked · `1` unlocked, reward unclaimed · `2` unlocked, claimed |
| `/achievements` | `type` | `0` normal · `1` subcategory |
| `/achievement_categories` | `type` | `0` user · `1` system |
| `/feelings` | `type` | `0` task · `1` achievement · `2` raw · `3` item use |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` user · `1` strength · `2` learning · `3` charm · `4` endurance · `5` vitality · `6` creative |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` visible · `1` hidden (independent flags) |
| `/synthesis_categories` | `hidden` | `0` visible · `1` hidden |
| `/pomodoro_records` | `reward` | `0` abandoned · `0.5×n` half · else full multiple |
| `/coin_records` `/inventory_records` | `resCode` | Shop: `0` buy · `1` use · `2` finish task · `3` undo finish · `4` clear · `5` give up · `6` overdue · `7` unlock achievement · `8` revoke give up · `9` revoke overdue · `10` return · `11` finish subtask · `12` undo subtask · `13` unlock user achievement · `14` undo user achievement · `15` deposit · `16` withdraw · `17` sell tomatoes · `20` reward item · `21` undo reward item · `23` synthesis · `24` loot box · `25` ATM interest · `26` tomato exchange · `27` credit interest · `28` API · `29` effect stock |
| `/exp_records` | `resCode` | Exp (not shop `28`): `0` unknown · `1` finish · `2` achievement · `3` like exchange · `4` day streak · `5` steps · `6` set finished · `7` revoke give up · `8` revoke overdue · `9` eat tomato · `10` used item · `11` unlock user achievement · `12` finish subtask · `200` API · `101` undo finish · `102` give up · `103` overdue · `104` used item debit · `105` lock user achievement · `106` undo subtask |

`GET /items_categories`, `GET /synthesis_categories`, and `GET /skill_groups` accept `include_hidden=true` (hidden lists omitted by default). Achievement unlock conditions: `GET /achievement_conditions/{id}`. Skill `status` (0 normal / 1 hidden) is only on `query`/`query_skill`, **not** `GET /skills`.

**Method: `GET`**

**Parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| id | Data ID | Path/Query | Number | Yes (for ID-specific endpoints) | - |
| offset | Query offset | Query | Number | No | Required only for some paged endpoints |
| limit | Page size | Query | Number | No | Required only for some paged endpoints |
| gid | Filter repeating-task history | Query | Number | No | Optional for history query |
| include_hidden | Include hidden lists | Query | Boolean | No | Default false. Used by `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Range start (ms) | Query | Number | No* | Must be paired with `time_range_end`. Partial/invalid range returns `invalid_parameter` |
| time_range_end | Range end (ms) | Query | Number | No* | Must be greater than `time_range_start` |

**Request examples**

**Tasks**

```txt
// All tasks
http://{host:port}/tasks

// Tasks in list ID 1
http://{host:port}/tasks/1

// History (100 records from index 0)
http://{host:port}/history?offset=0&limit=100

// Task categories
http://{host:port}/tasks_categories
```

**Items**

```txt
// All items
http://{host:port}/items

// Query specific item IDs 1 and 4
http://{host:port}/items?id=1&id=4

// Items in list ID 1
http://{host:port}/items/1

// Item categories
http://{host:port}/items_categories
```

**Achievements**

```txt
// Achievements in list/category ${id}
http://{host:port}/achievements/${id}

// Achievement categories
http://{host:port}/achievement_categories
```

**Feelings**

```txt
// 100 records from index 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attributes**

```txt
http://{host:port}/skills
```

**Synthesis categories**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Synthesis recipes**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. Image/File API

> [!NOTE]
> Due to Android storage restrictions, LifeUp Cloud may need to create a copied file when serving image content from LifeUp.

Function:

> Load image/file resources returned by data APIs (typically `content://...`).

Request URL:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Path parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| url | File URL | Path | String | Yes | - |

**Request example:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Skill ContentProvider Queries

> [!NOTE]
> Requires v1.103.0+

For list or structured queries, you can read the following ContentProvider URIs via the `http://{host:port}/api/contentprovider` endpoint.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Returns visible skills only.

| Column | Meaning | Type | Notes |
| ------ | ------- | ---- | ----- |
| _ID | Skill ID | number | - |
| name | Skill name | string | - |
| desc | Description | string | May be empty |
| icon | Icon URI | string | May be empty |
| order | Raw sort order | number | `orderInCategory` |
| group_id | Skill group ID | number / null | May be empty when the skill is not in a group |
| color | Color | number / null | May be empty |
| exp | Experience points | number | - |
| level | Current level | number | - |
| until_next_level_exp | EXP to next level | number | - |
| current_level_exp | EXP gained in current level | number | - |
| type | Skill type | number | - |
| status | Skill status | number | `0` = normal, `1` = hidden |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Returns visible skill groups only.

| Column | Meaning | Type | Notes |
| ------ | ------- | ---- | ----- |
| _ID | Skill group ID | number | - |
| content | Group name | string | - |
| order | Raw sort order | number | `orderInCategory` |
| collapsed | Collapse state | string | Returned as `true` / `false` text |

<br/>

## Contribution

The SDK, LifeUp Cloud, and LifeUp Desktop are all open-source projects.

You can get the source code at:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

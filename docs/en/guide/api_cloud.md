<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud is one of the core API toolkits for LifeUp.

It exposes LifeUp APIs as HTTP services, so you can call APIs or query data from other tools (such as Python scripts or web apps) **across devices, without Android development experience**.

LifeUp Desktop is a reference app built on top of LifeUp Cloud.

<br/>

## Download

- If you use the Mainland China membership version, you can find the LifeUp Cloud download entry in `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>

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

// All achievements (implemented; category id optional)
http://{host:port}/achievements

// Broadcast events (LifeUp Labs → Broadcast events must be on)
http://{host:port}/events?after=${id}&limit=50

// WebSocket push (Cloud advanced: WebSocket event push; can run with GET)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` is transport OK only. `10001` LifeUp not running or Read Data not granted. `10002` ContentProvider query failed.

### List field values

| Endpoint | Field | Values |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` unfinished · `1` done · `2` overdue · `3` given up |
| `/tasks` | `frequency` | `0` once · `1` daily · `N>1` every N days · `-1` unlimited · `-3` Ebbinghaus · `-4` monthly · `-5` yearly |
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

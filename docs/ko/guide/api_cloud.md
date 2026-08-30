<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> 현재 **LifeUp v1.106.0**과 **LifeUp Cloud v3.0.0**을 순차 배포 중입니다. 플랫폼 심사 일정은 지역·스토어에 따라 달라, 문서가 App이 널리 제공되기 전에 먼저 업데이트될 수 있습니다. 여기에 표시된 날짜보다 실제 출시일이 늦어질 수 있습니다.

LifeUp Cloud는 LifeUp의 핵심 API 툴킷 중 하나입니다. 휴대폰을 **API 브리지**로 바꿔 **컴퓨터나 다른 기기**에서 LifeUp을 제어하고, **커스텀 연동**(데스크톱, 웹, 자동화 스크립트)을 만들거나 **AI 에이전트**와 함께 쓸 수 있습니다.

### 일반적인 시나리오

| 시나리오 | 대상 | 한 줄 요약 | 더 알아보기 |
| --- | --- | --- | --- |
| **HTTP + 직접 구축** | 개발자, 자동화 사용자 | LAN에서 Python, 웹 App, 스크립트로 API 호출 및 데이터 조회 — Android 경험 불필요 | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **QR 스캔** | 현실 체크인 애호가 | QR 코드를 인쇄해 작업 완료, 타이머 시작, 대화상자 열기, 웹 페이지 / 다른 App 실행 | [QR code scanning](#qr-code-scanning) |
| **시작 / 중지 단축** | 자동화, NFC, Tasker | `lifeupcloud://start`와 `lifeupcloud://stop`으로 Cloud를 열고 HTTP 서버 시작 또는 중지 | [Start and stop](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude 등 | 한 번의 프롬프트로 작업 목록, 상점 아이템, 업적 등 전체 구성 | [MCP & Skills](guide/api_mcp.md) |
> **AI 프롬프트 예시:** 샘플 작업과 상점 아이템을 지우고, 인디 게임 개발자 전체 세트를 만들어줘: 작업 목록, 속성, 상점 아이템, 업적.

<br/>

## 다운로드

- 중국 본토 멤버십 버전을 사용하는 경우 `Sidebar` → `Settings` → `Experiments`에서 LifeUp Cloud 다운로드 항목을 찾을 수 있습니다.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud 서비스 시작 및 중지 :id=cloud-scheme

**Start Service**를 누르지 않고도 아래 URL 스킴으로 HTTP 서버를 시작하거나 중지할 수 있습니다:

```txt
lifeupcloud://start
lifeupcloud://stop
```

URL을 열면 LifeUp Cloud가 실행되고 해당 동작이 적용됩니다. 홈 화면 단축키, NFC 태그, Tasker/자동화 동작 등으로 사용하거나:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

같은 URL은 Cloud 상태 카드에도 나열되어 있으며 — 탭하여 복사할 수 있습니다.

> [!NOTE]
> `lifeupcloud://`는 Cloud HTTP 서버 자체를 제어합니다. `lifeup://api/…` 게임 API가 아닙니다.

<br/>

## QR code scanning

LifeUp Cloud 상단의 **Scan** 버튼은 QR 코드에 인코딩된 URL을 읽어 즉시 엽니다 — 수동 입력 불필요.

스캔은 **LifeUp API에만 한정되지 않습니다**: `lifeup://api/…`, 웹 페이지 `https://…`, 다른 App URL 스킴(예: `weixin://`) 모두 동작합니다 — Android가 해당 대상을 엽니다.

### 사용 방법

1. LifeUp 또는 wiki [API list](guide/api.md)에서 URL을 고릅니다(작업 완료, 포모도로 시작, 구매/사용 대화상자 열기, 외부 웹 페이지 열기).

2. 전체 URL로 QR 코드를 생성합니다(책상, 벽, 기기에 인쇄해 부착).

3. LifeUp Cloud를 열고 **Scan**을 탭합니다(**?**를 탭하면 App 내 짧은 가이드), 코드를 비춥니다.

### 할 수 있는 것

| 시나리오 | 예시(설명용) |
| --- | --- |
| 포모도로 체크인 | `lifeup://api/pomodoro?...` 타이머 시작/중지 |
| 작업 체크인 | `lifeup://api/complete?name=...` 작업 완료 |
| 상점 상호작용 | `lifeup://api/goto?page=shop` 또는 구매/사용 대화상자 |
| 보상 / 페널티 | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| 웹 미니 게임 | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| 다른 App | `weixin://`, `intent://`, 또는 설치된 App의 스킴 |
| 커스텀 플로 | 스캔 가능한 URL 조합 |

### 현실 세계 상호작용

QR 코드는 **물리적 장소나 행동**을 App 내 게이미피케이션에 연결합니다:

- **헬스장 기구** 스티커 → 스캔하여 근력 운동 작업 완료

- **공부 책상** 스티커 → 스캔하여 집중 포모도로 시작

- **워크스테이션** 스티커 → 스캔하여 스탠드업 또는 코드 리뷰 기록

- **이벤트 게시판** 스티커 → 스캔하여 보상 수령 또는 업적 열기

요약: **URL Scheme을 스캔 가능한 물리적 트리거로 바꾸고**, LifeUp Cloud가 App과 현실 사이의 실행자 역할을 합니다.

<br/>

> [!NOTE]
> LifeUp Cloud는 LAN 전용 HTTP 브리지입니다. 휴대폰에 접근하는 방법 — IP 주소, 라우터, 방화벽, 같은 서브넷, VPN, AP 격리 — 은 가정용 네트워크에 따라 다릅니다. 연결되지 않으면 개인 LAN은 디버깅해 드릴 수 없습니다. 네트워크를 직접 확인하거나 표준 네트워크 도구를 사용하거나 AI 에이전트에 도움을 요청하세요.

## HTTP API Definition

> [!WARNING]
> 이 페이지의 API 문서는 구현 업데이트보다 늦을 수 있습니다. 최종 기준은 소스 코드를 사용하세요: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme Invocation API

#### GET

Function:

> `lifeup://api`로 시작하는 API를 호출합니다.

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

> `lifeup://api`로 시작하는 API를 호출합니다.

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

> 작업, 아이템 등 LifeUp 전체 데이터 세트를 조회합니다.

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

// Broadcast events. LifeUp Labs → Broadcast events is off by default; Cloud Advanced can show status and enable it. GET data.broadcasts is that switch (omitted if unread). The Cloud WebSocket setting is transport only.
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

> 데이터 API가 반환하는 이미지/파일 리소스를 로드합니다(일반적으로 `content://...`).

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

## 기여

SDK, LifeUp Cloud, LifeUp Desktop은 모두 오픈 소스 프로젝트입니다.

소스 코드:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

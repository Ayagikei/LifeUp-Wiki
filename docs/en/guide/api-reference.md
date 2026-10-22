# HTTP API reference :id=http-query-reference

Use this reference for LifeUp Cloud request parameters and complete HTTP response models. For installation, authorization and connection steps, start with [LifeUp Cloud](/guide/api_cloud). Newer journal endpoints require LifeUp **1.106.0+** and LifeUp Cloud **3.0.0+**; use `/info` to identify installed versions. This reference describes current source contracts, not proof of a particular release's availability.

## Interface index :id=interface-index

| Resource | Methods and paths | Parameters and model |
| --- | --- | --- |
| Common rules | JSON responses, authorization, cache conditions, pagination | [Conventions](#representations), [cache and auth](#auth-cache), [pagination](#pagination) |
| Tasks | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Queries](#get-tasks), [task model](#task-fields), [categories](#get-tasks-categories) |
| Task history | `GET /history` | [Parameters](#get-history), [timestamps](#task-times), [daily reports](#daily-report) |
| Items | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [Item IDs, category IDs and full models](#get-items) |
| Skills | `GET /skills`, `GET /skill_groups` | [Skills and groups](#get-skills) |
| Achievements | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Achievements and conditions](#get-achievements) |
| Synthesis | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Recipes and categories](#get-synthesis) |
| Feelings | `GET /feelings` | [Paged feelings](#get-feelings) |
| EXP / coins | `GET /exp_records`, `GET /coin_records` | [Journal parameters and models](#reward-journals) |
| Other records | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventory](#get-inventory-records), [steps](#get-step-records) |
| Levels / statistics | `GET /level_defines`, `GET /statistics` | [Levels](#get-level-defines), [statistics](#get-statistics) |
| App / balance | `GET /info`, `GET /coin` | [Version information](#get-info), [coin result](#get-coin) |
| Invoke actions | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Invocation bridge](#invoke-api); business methods remain in the [URL Scheme catalog](/guide/api) |
| Files / backups | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Files](#files-download), [backup transfer](#files-backup) |
| Events | `GET /events`, WebSocket `/events` | [Polling and live events](#get-events) |
| Landing page | `GET /` | HTML introduction, not a JSON resource. |

MCP uses a separate client/tool representation; see [MCP differences](#mcp-differences) and the [MCP guide](/guide/api_mcp).

## Transport and representation :id=representations

| Interface | Representation | Important difference |
| --- | --- | --- |
| Cloud HTTP queries | JSON wrapped as `{code, message, data}` | The endpoint references below describe this public JSON. |
| Android ContentProvider | Cursor columns, such as `_ID` / `_GID`, sometimes containing JSON text | SDK parsing converts these into HTTP fields such as `id` / `gid` and nested arrays. Do not use Cursor column definitions as the HTTP schema. |
| URL Scheme actions | `lifeup://api/{method}` and method-specific parameters/results | Write parameters can use snake_case even when HTTP read fields use camelCase. |
| MCP list tools | Tool-specific envelope and compact or detailed records | MCP pagination and output fields are additional client behavior, not HTTP response fields. |

## Response and errors :id=response-errors

The common HTTP JSON wrapper is `HttpResponse<T>`:

| Field | Type | Meaning |
| --- | --- | --- |
| `code` | integer | `200` for a successful query; a non-`200` value indicates an error. This is a body field, separate from HTTP status. |
| `message` | string | Usually `success` on success; an error description otherwise. |
| `data` | `T` or `null` | An endpoint-specific value (array, object or string) on success; `null` on error. |

Example of a successful empty list:

```json
{"code":200,"message":"success","data":[]}
```

Illustrative permission/provider-access error:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Signal | How to handle it |
| --- | --- |
| HTTP `401` | Supply the configured Cloud token as the raw `Authorization` header value. Do not add `Bearer`. |
| Body `code = 10001` | Check that LifeUp is installed/running and Cloud has Read LifeUp Data permission. |
| Body `code = 10002` | ContentProvider query failed; inspect the error message. |
| Other non-success status/code | Treat the query as failed, not as an empty result. |

Check **both** HTTP status and body `code`. Some route failures still use HTTP `200` with an error code in the body. Actions through `/api/contentprovider` additionally require checking each `data[].result.api_result`; the wrapper's `code=200` does not prove that every action succeeded.

## Authorization and conditional reads :id=auth-cache

When a Cloud token is configured, send its exact raw value in `Authorization`; do not prepend `Bearer`. The server also accepts the `token` query parameter, including for clients that cannot set a WebSocket header. A missing or incorrect token produces HTTP `401` and body `code=401`. This check covers the landing page, resources, bridge, files, backup transfer and events.

Successful JSON resource reads attach a strong SHA-256 `ETag` and `Cache-Control: private, no-cache`. This applies to task/history, item/category, skill/group, achievement/condition, feelings, synthesis/category, journal, levels, statistics, info and coin resources. It does not apply to the invocation bridge, file transfer, backup transfer or event streams/polling.

| Request header | Current response behavior |
| --- | --- |
| `If-Match` | A nonmatching version fails with HTTP `412`; evaluated before `If-None-Match`. |
| `If-None-Match` | A matching version returns HTTP `304`, with no JSON body to parse. Reuse the cached successful representation. |

Error envelopes have no resource-version header. Conditional reads are per resource request, not a snapshot or transaction spanning pages or routes.

Cross-origin browser requests can use `If-None-Match`. The current CORS configuration does not allow `If-Match` in preflight, so do not depend on cross-origin browser `If-Match` requests without changing that implementation. Native clients are not subject to browser CORS.

## Shared data conventions :id=data-conventions

| Convention | Rule |
| --- | --- |
| Time | Timestamp fields use Unix milliseconds. Calendar-day boundaries depend on the intended time zone. Individual fields still have resource-specific meanings. |
| Identity | Task `id` identifies one task/cycle; task `gid` identifies its group across repeating cycles. A category/list ID identifies a separate resource. |
| Empty values | Missing, `null`, `0`, `""` and `[]` are distinct. Each model documents its actual fallback or omission behavior. |
| Numeric IDs | IDs can be signed 64-bit integers; a JavaScript Number cannot exactly represent every value. Preserve large IDs with a suitable JSON parser. |
| Arrays and objects | HTTP nested values such as `items` and `subTasks` are arrays, not JSON-encoded strings. |
| Status and reason codes | Use the enum documented for that resource. Task status, achievement status and journal reason codes are different domains. |

See the [task timestamp definitions](/guide/api-reference?id=task-times) for `startTime`, `deadline` and `endTime`.

## Pagination and filtering :id=pagination

Pagination is an endpoint capability, not a property of every list. Raw HTTP list responses contain `data: [...]`; they do **not** add `total`, `count` or `hasMore`.

| HTTP endpoint | Pagination | Date range | Other filtering |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | No; full array | No | Optional category in the path |
| `/history` | Server-side `offset` / `limit` | No | Optional `gid` |
| `/feelings` | Server-side `offset` / `limit` | No | See [feelings](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | Server-side `offset` / `limit` | `time_range_start` / `time_range_end` | See the specific endpoint sections below |
| `/statistics` | No; one object | `time_range_start` / `time_range_end` | Aggregate query |
| `/coin`, `/info` | No; one object | No | Singleton query |

For the paged endpoints, HTTP defaults are `offset=0` and `limit=100`. Use non-negative offsets and page sizes in `1..100` for a shared paging loop. The HTTP bridge does not apply MCP's `1..100` clamp, and downstream providers may enforce other limits; consult each endpoint's effective page size and validation notes.

Except for the [time-filtered Pomodoro limitation](#get-pomodoro-records), after each successful page, advance `offset` by the number of records returned. Stop when that number is smaller than the effective page size (the requested `limit` when using `1..100`, excluding time-filtered Pomodoro). Do not mistake a provider-clamped page for the last page. An empty page beyond the end is normal. Fetching multiple pages does not create a snapshot: records can change while the query is in progress.

For the current HTTP SDK, date bounds are forwarded only when **both** parse as integers and `start < end`. A single, unparseable or reversed bound results in an unfiltered query; do not rely on an error to catch this. Validate both bounds before sending. The journal reference states the inclusive boundary behavior of its endpoints.

## MCP differences :id=mcp-differences

MCP list tools default to `limit=20`, clamp it to `1..100`, and clamp `offset` to at least `0`. They send pagination to server-paged resources such as history/journals, but fetch full HTTP arrays and slice locally for resources such as tasks. Their `items`, `count`, `hasMore` and optional `total` belong to the MCP envelope. `detail=false` also removes fields from each record; use `detail=true` when the full HTTP model is needed.

## Sources and version scope :id=api-common-sources

These references describe the current public SDK and the corresponding LifeUp provider behavior. Examples use invented data. Source links are implementation references, not proof that a particular installed version contains every field: [HTTP routes](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [HTTP wrapper](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [MCP query mapping](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).


## Task and history data models :id=task-history-models

This page defines the **HTTP JSON** returned by [task/history queries](/guide/api-reference?id=task-queries). Android Cursor columns and URL Scheme action parameters can have different names and representations; see [common conventions](/guide/api-reference?id=representations).

The SDK uses one serialized `Task` class for two views. Here, `Task` names the `/tasks` view and `HistoryRecord` names the `/history` view. These names describe existing output; they do not introduce another API. Current Cloud serialization includes default values and `null` fields.

### Task / HistoryRecord fields :id=task-fields

All fields below appear in the current HTTP object. Missing provider values are often converted into the listed fallbacks; a fallback does not prove that the source data contained that value.

| Field | JSON type | Meaning / fallback |
| --- | --- | --- |
| `id` | integer or `null` | ID of this task/cycle. |
| `gid` | integer or `null` | Task-group ID shared across repeating cycles. |
| `name` | string | Task name. A missing provider name becomes `ERROR: name is null`. |
| `notes` | string | Notes; empty string if absent. |
| `status` | integer | Task status; missing value defaults to `0`. See the status table below. |
| `startTime` | integer | Configured start time in milliseconds; SDK fallback `0`. |
| `deadline` | integer | Due time in milliseconds; SDK fallback `0` if absent. |
| `remindTime` | integer | Reminder time in milliseconds; SDK fallback `0` if absent. |
| `frequency` | integer | Recurrence code; `0` once, `1` daily, `-1` unlimited. Other recurrence modes are described in [task actions](/guide/api). SDK fallback `0`. |
| `weekdays` | string | Weekday selection, e.g. `1,3,5` (Monday `1`, Sunday `7`); empty when not supplied, and a fixed empty placeholder in history. |
| `importance` | integer or `null` | Importance level `1`–`4` (ascending); corresponds to the App task urgency degree (`taskUrgencyDegree`). Returned on `GET /tasks` and `GET /tasks/{categoryId}` when the task-list ContentProvider exposes the column; SDK parses a missing or NULL column as `null`. The history ContentProvider does not return this column, so `/history` uses `null` here without implying the App lacks stored urgency on the record. |
| `difficulty` | integer or `null` | Difficulty level `1`–`4` (ascending); corresponds to the App task difficulty degree (`taskDifficultyDegree`). Same `/tasks` versus `/history` ContentProvider behavior as `importance`. |
| `exp` | integer | Configured EXP reward, not a transaction amount; default `0`. |
| `skillIds` | integer array | Attributes associated with the reward; empty array if unavailable. |
| `coin` | integer | Configured coin reward; default `0`. |
| `coinVariable` | integer | Random-coin reward setting; default `0`. |
| `itemId` | integer | Legacy first reward-item ID; default `0`. Use `items` for the full list. |
| `itemAmount` | integer | Legacy first reward-item quantity; default `0`. This HTTP name differs from the provider's `itemCount` column. |
| `words` | string | Completion incentive text; empty if absent. |
| `categoryId` | integer | Task category/list ID; default `0` if absent. |
| `order` | integer | Task-list ordering value; fixed `0` placeholder in history because that provider does not return the column. |
| `nameExtended` | string | Extended display name; fixed empty placeholder in history because that provider does not return the column. |
| `endTime` | integer | Recorded end time for history. `/tasks` fills this with `0`; see [time semantics](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Item rewards; empty array if unavailable. |
| `subTasks` | `SubTask[]` | Nested subtasks; empty array if unavailable. |
| `countProgress` | `TaskCountProgress` or `null` | Count-progress snapshot when available; can appear in both views. |
| `repeatEndCondition` | `TaskRepeatEndCondition` or `null` | Repetition end rule in `/tasks`; always `null` in `/history`. |

### Task status and timestamps :id=task-times

| `status` | Meaning | History `endTime` meaning |
| --- | --- | --- |
| `0` | Unfinished | Not a completion time; `/history` selects ended records instead. |
| `1` | Completed | Recorded completion time. |
| `2` | Overdue | Recorded overdue time. |
| `3` | Given up | Recorded give-up time. |

| Time field | Definition |
| --- | --- |
| `startTime` | The task's configured/scheduled start time, not when the user actually started working. |
| `deadline` | The scheduled due time, separate from the recorded end time. |
| `endTime` | The recorded time the history task ended; interpret with `status` as above. |

All three use Unix milliseconds. For normal completion, the app records the current time. `history_operation` with `operation=edit_completed_time` takes a `completed_time` input and edits this same saved completion time; reading history still returns the field name `endTime`.

Saved times can be edited. If an ended record has no saved end date, the app falls back to the current time. Consequently, `endTime` is the currently recorded time, not an immutable audit timestamp. `0` on `/tasks` is only the SDK placeholder, not a real event at the Unix epoch.

### RewardItem :id=reward-item

| Field | JSON type | Meaning |
| --- | --- | --- |
| `itemId` | integer | Reward item ID. |
| `itemCount` | integer | Reward quantity. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Field | JSON type | Meaning / default |
| --- | --- | --- |
| `id` | integer | Subtask ID. |
| `gid` | integer | Subtask-group ID. |
| `todo` | string | Subtask text. |
| `status` | integer | `0` unfinished, `1` completed. |
| `remindTime` | integer or `null` | Reminder timestamp in milliseconds; `null` if unavailable. |
| `endTime` | integer or `null` | Subtask completion timestamp in milliseconds; `null` if unavailable. |
| `exp` | integer | Configured EXP reward. |
| `coin` | integer or `null` | Configured coin reward. |
| `coinVariable` | integer or `null` | Random-coin reward setting. |
| `items` | `RewardItem[]` | Item rewards; default empty array. |
| `order` | integer or `null` | Ordering value; model default `0`. |
| `autoUseItem` | boolean or `null` | Whether rewards are automatically used; model default `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Field | JSON type | Meaning |
| --- | --- | --- |
| `currentCount` | integer | Current count for this task/cycle. |
| `targetCount` | integer | Target count for this task/cycle. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Field | JSON type | Meaning / default |
| --- | --- | --- |
| `mode` | string | `COUNT` or `DATE`. These are read-side strings, not the numeric action parameters. |
| `behavior` | string | `TERMINATE` or `FREEZE`. |
| `targetCycleCount` | integer or `null` | Cycle-count target for `COUNT`; default `null`. |
| `endDateMillis` | integer or `null` | End-date timestamp in milliseconds for `DATE`; default `null`. |
| `inclusive` | boolean | Inclusive end-date flag; default `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Reward amounts :id=reward-amounts

These task and subtask fields describe configured rewards. Multipliers, random coins and settlement rules can change the actual award. Use the [EXP and coin journals](/guide/api-reference?id=reward-journals) for transaction amounts, and distinguish positive rewards from net changes that include reversals or penalties.

### Implementation references :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Parser](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Count progress](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Repeat rule](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).


## Task and history queries :id=task-queries

Read [common conventions](/guide/api-reference?id=http-query-reference) and the [complete Task/History model](/guide/api-reference?id=task-history-models). These endpoints require Cloud's Read LifeUp Data permission. Basic list queries are documented for LifeUp v1.91+ with the latest Cloud; examples describe the current SDK fields. Check `/info` when integrating with older installations.

### GET /tasks and /tasks/{categoryId} :id=get-tasks

Query the current **unfinished** task list, optionally restricted to a category/list. The result is a full array, not a server-paged response. Completed, overdue and given-up records belong to `/history`.

| Parameter | Location | Type | Required | Default / behavior |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | Only for `/tasks/{categoryId}` | Omit the entire path segment for the unrestricted task list. |

There are no supported `offset`, `limit`, `gid` or date-range query parameters on these routes. A non-integer category segment currently parses as an absent category; validate it before requesting so you do not accidentally query all tasks.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Response:** `HttpResponse<Task[]>`. All record fields and nested structures are defined in [Task/History fields](/guide/api-reference?id=task-fields). The following invented record shows the complete top-level HTTP shape; `endTime=0` is a placeholder for this route, not a completion timestamp.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": 3, "difficulty": 2,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Behavior and errors:** list selection/order follows LifeUp's task-list logic; this endpoint does not promise ordering by completion time. A successful `data: []` means the selected task list returned no records. Permission/provider failures use the [common error wrapper](/guide/api-reference?id=response-errors); they are not empty arrays. For completion reporting, use `/history` below rather than this route's `endTime`.

### GET /history :id=get-history

Query visible ended task records, including completed, overdue and given-up tasks. Deleted history is excluded.

| Parameter | Location | Type | Required | Default / behavior |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | `0`; zero-based number of records to skip. |
| `limit` | Query | integer | No | `100`; request a positive page size, preferably `1..100`. |
| `gid` | Query | integer | No | No group filter; if present, selects that task group across cycles. |

The HTTP parser falls back to `0` / `100` for unparseable `offset` / `limit`, and drops an unparseable `gid`. This route does not clamp parsed numbers. Validate non-negative offsets and positive limits yourself. `time_range_start` / `time_range_end` are **not supported**; supplying them does not filter history.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Response:** `HttpResponse<HistoryRecord[]>`, using the [Task/History wire fields](/guide/api-reference?id=task-fields). `HistoryRecord` is a documentation name for the history view of the SDK's `Task` model. `repeatEndCondition` is `null` in this view; `countProgress` may be present. The saved `endTime` is interpreted with `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": null, "difficulty": null,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Ordering:** saved end date descending, newest first. There is no documented tie-breaker for equal end dates. Pagination is not a snapshot; avoid editing the data while collecting a report, and deduplicate records by `id` when combining pages.

**Pagination and empty results:** use the [shared paging procedure](/guide/api-reference?id=pagination). A successful empty array means no visible records matched this page/group, including when `offset` is past the end. It does not certify that no activity ever occurred: deleted records are excluded, and there is no completeness flag. If any request fails, report unavailable/incomplete data instead of zero tasks. [Common errors](/guide/api-reference?id=response-errors) apply.

### Build a daily report :id=daily-report

1. Choose the report's time zone. Calculate the start of the calendar day (`dayStart`) and the start of the following calendar day (`nextDayStart`). Do not assume every local day is exactly 24 hours.
2. Read `/history` with `offset=0&limit=100`, check each response, and collect all pages. Keep any intended `gid` filter consistent.
3. Select `status == 1` and `dayStart <= endTime < nextDayStart`. Use the [recorded-time limitations](/guide/api-reference?id=task-times) when describing results.
4. For actual EXP and coin changes, read the [reward journals](/guide/api-reference?id=reward-journals) for the same day. Their date filters include both ends, so use `time_range_start=dayStart` and `time_range_end=nextDayStart-1`.
5. Distinguish “no records found in the available data” from a failed/unfinished read. Decide whether the report shows positive rewards only or net changes including reversals, and apply that choice consistently.

Task/history `exp` and `coin` are configured rewards; they are not a reliable substitute for journaled amounts. A completion time edited to another day does not imply that the reward journal's transaction time moved with it.

### Implementation references :id=api-task-queries-sources

[HTTP routes](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Task and history parsing](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).


## EXP and coin journal queries :id=reward-journals

These read-only HTTP endpoints require Read LifeUp Data permission, LifeUp **1.106.0+** and LifeUp Cloud **3.0.0+**. They return recorded changes, including decreases and reversals, rather than task reward configuration. Read [common conventions](/guide/api-reference?id=http-query-reference) first.

### Request parameters for both endpoints :id=journal-parameters

The following contract applies specifically to **both** `GET /exp_records` and `GET /coin_records`.

| Parameter | Location | Type | Required | Default / actual behavior |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | HTTP default `0`; provider clamps negative values to `0`. |
| `limit` | Query | integer | No | HTTP default `100`; provider clamps to `1..200`. Use `1..100` for the shared paging procedure. |
| `time_range_start` | Query | integer (Unix milliseconds) | No, or paired | Inclusive lower bound of the transaction's recorded time. |
| `time_range_end` | Query | integer (Unix milliseconds) | No, or paired | Inclusive upper bound; valid filtering requires `start < end`. |

Unparseable or out-of-range pagination values use HTTP defaults. Unparseable date values become absent. The current SDK forwards a date range only when both bounds exist and `start < end`; otherwise it queries **without a date filter**. Direct raw ContentProvider calls have different invalid-range validation. Validate bounds in the HTTP caller.

Both endpoints sort by recorded transaction time descending, newest first, and exclude deleted journal entries. They do not promise an ID tie-breaker or a multi-page snapshot. Follow [pagination](/guide/api-reference?id=pagination), taking the provider's effective limit into account. A successful empty array means no entries matched the selected range/page; a failed read is not zero activity. Neither endpoint provides a completeness flag for deleted or unavailable data.

### GET /exp_records :id=get-exp-records

Query EXP changes. Parameters are exactly the [four journal parameters above](/guide/api-reference?id=journal-parameters); there is no `gid` filter.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Response:** `HttpResponse<ExpRecord[]>`. Current serialization includes all listed fields, including nullable values.

| Field | JSON type | Meaning / parser fallback |
| --- | --- | --- |
| `id` | integer or `null` | Journal entry ID. |
| `time` | integer or `null` | Transaction time in Unix milliseconds, distinct from an editable task completion time. |
| `value` | integer | EXP change per associated attribute; fallback `0`. Use `isDecrease` for direction. |
| `isDecrease` | boolean | `true` for a decrease, `false` for an increase; parser treats provider integer `1` as true. |
| `totalValue` | integer | Recorded aggregate EXP change, **not an EXP balance**; fallback `0`. Multi-attribute batches can overlap in this stored total; see [report totals](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | EXP-specific reason code; fallback `0`. |
| `relatedId` | integer or `null` | Related source-object ID. For normal task completion this is the task record `id`, not its `gid`. Other reasons can refer to other resources. |
| `content` | string or `null` | Change description. |
| `skillIds` | integer array | Associated attribute/skill IDs; fallback empty array. |
| `relatedAttributes` | string array | Associated legacy attribute strings; fallback empty array. |

Invented example: 10 EXP applied to each of two attributes, 20 EXP in aggregate.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Errors:** [common HTTP/provider errors](/guide/api-reference?id=response-errors). Invalid HTTP date bounds may silently remove filtering as explained above, rather than produce an error.

### GET /coin_records :id=get-coin-records

Query coin changes. Parameters are exactly the [four journal parameters above](/guide/api-reference?id=journal-parameters); there is no `gid` filter.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Response:** `HttpResponse<CoinRecord[]>`. Current serialization includes all listed fields, including nullable values.

| Field | JSON type | Meaning / parser fallback |
| --- | --- | --- |
| `id` | integer or `null` | Journal entry ID. |
| `time` | integer or `null` | Transaction time in Unix milliseconds. |
| `value` | integer | Coin change amount; fallback `0`. Use `isDecrease` for direction. |
| `isDecrease` | boolean | `true` for a decrease, `false` for an increase; parser treats provider integer `1` as true. |
| `totalValue` | integer | Coin balance after the operation; fallback `0`. Unlike EXP `totalValue`, this is a balance. |
| `resCode` | integer | Coin-specific reason code; fallback `0`. |
| `relatedId` | integer or `null` | Related source-object ID; normal task completion uses the task record `id`. Interpret other sources using their reason code. |
| `content` | string or `null` | Change description. |
| `savingBalance` | integer or `null` | Savings balance recorded for the operation. |

Invented example: a decrease of 5 coins, leaving a coin balance of 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Errors:** [common HTTP/provider errors](/guide/api-reference?id=response-errors). Invalid HTTP date bounds may silently remove filtering as explained above, rather than produce an error.

### Reason codes and report totals :id=journal-totals

Reason-code domains differ. Selected examples:

| Reason | EXP `resCode` | Coin `resCode` |
| --- | --- | --- |
| Finish task | `1` | `2` |
| Undo finish task | `101` | `3` |
| Finish subtask | `12` | `11` |
| Undo subtask | `106` | `12` |
| API change | `200` | `28` |

Full EXP codes: `0` unknown; `1` task completion; `2` achievement; `3` like exchange; `4` usage-day streak; `5` step exchange; `6` set to completed; `7` undo give-up; `8` undo overdue; `9` eat tomato; `10` use item; `11` user achievement unlock; `12` subtask completion; `200` API; `101` undo completion; `102` give-up; `103` overdue; `104` item use decreases EXP; `105` user achievement relock; `106` undo subtask completion. Coin reason codes use the same domain as [inventory records](#get-inventory-records). Preserve unknown future codes. For a net change, apply direction with `isDecrease` (`true` subtracts the recorded amount). Do not assume a decrease is encoded as a negative `value`; the numeric types are signed and no unsigned/absolute-value guarantee is declared.

EXP `value` is per attribute. Do not blindly sum EXP `totalValue` across records: the current multi-attribute batching logic can store overlapping totals when more than three attributes are involved. For example, a four-attribute change of 10 EXP each can produce stored totals of 40 and 10, rather than a safe sum of 40. Reconcile per-attribute `value` with the attributes listed on each record for precise reporting; missing associations limit what can be established. Do not add `value` and `totalValue` together, and do not describe EXP `totalValue` as a balance.

For one calendar day, calculate local `dayStart` and `nextDayStart`, then request `[dayStart, nextDayStart - 1]` because both bounds are inclusive. Select reason codes when reporting task rewards only; leave them unfiltered when reporting all recorded changes. [Daily-report procedure](/guide/api-reference?id=daily-report).

### Implementation references :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Date-parameter forwarding](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Items and categories :id=get-items

`GET /items` returns `ShopItem[]`. Optional repeated query parameter `id` selects item IDs: `/items?id=1&id=2`. Non-integer values are discarded. Missing IDs are skipped; valid IDs retain request order, including duplicates. If every supplied ID is invalid, the SDK sends no ID filter and the result is the normal item list. There is no pagination.

`GET /items/{listId}` returns `ShopItem[]` in a **category**, not a single item. `listId` is a signed 64-bit category ID; `-1` means all. An invalid path value falls back to all. The normal list excludes unlisted/deleted items (`isDel=0`) and follows the configured shop/category sorting. ID selection can retrieve an item independently of that normal list filter.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Item ID. |
| `name` | string | Item name. |
| `desc` | string | Description. |
| `icon` | string | Readable image URI, or empty string. Download through `/files/{url}`. |
| `categoryId` | integer | Shop category ID. |
| `stockNumber` | integer | Available stock; negative stock is treated as unlimited when calculating `maxPurchaseNumber`. |
| `ownNumber` | integer | Owned inventory quantity. |
| `price` | integer | Coin price. |
| `order` | integer | Stored order within its category. |
| `disablePurchase` | boolean | Purchase disabled flag. |
| `maxPurchaseNumber` | integer or null | Calculated from available coins plus credit and finite stock; disabled purchases yield 0, free unlimited stock can yield 2147483647. This calculation does not evaluate all purchase-limit rules. |
| `titleColorString` | string or null | Custom title color. |
| `actionText` | string or null | Custom use-button text. |
| `unlist` | boolean | Unlisted/deleted flag; normally false for list results. |
| `disableUse` | boolean | Whether the item has an unusable effect. |
| `purchaseLimit` | string or null | **JSON encoded string**, not a nested array; the item's purchase-limit configuration. |
| `limitScope` | string or null | `purchase`, `use`, or `both`. |

### GET /items_categories :id=get-items-categories

Returns `ShopCategory[]`. Optional `include_hidden` defaults to `false`; only the exact lowercase strings `true` and `false` are parsed, and any other value falls back to false. Includes the virtual all category. The HTTP server does not expose `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Category ID. |
| `name` | string | Category name. |
| `isAsc` | boolean | Configured ascending sort flag. |
| `sort` | string | Stored sort preference. |
| `order` | integer | Category order. |
| `hidden` | boolean | Hidden in shop. |
| `inventoryHidden` | boolean | Hidden in inventory. |

### GET /tasks_categories :id=get-tasks-categories

Returns `TaskCategory[]`, including the all category and archived categories. No query parameters or pagination. The HTTP server does not expose `/tasks_categories/{id}`. Category sort/filter values are stored app preferences; this endpoint does not apply them as request filters.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Category ID. |
| `name` | string | Name. |
| `isAsc` | boolean | Stored ascending sort flag. |
| `sort` | string | Stored sort preference. |
| `filter` | string | Stored grouping/filter preference. |
| `order` | integer | Category order. |
| `status` | integer | 0 normal; 1 archived. |
| `type` | integer | 0 normal; smart lists use 10 daily, 11 weekly, 12 monthly, 20 doing. |

## Skills and skill groups :id=get-skills

`GET /skills` returns `Skill[]`, with no parameters or pagination. Hidden/deleted skills are excluded and stored order is used. `group_id` and `status` from the underlying ContentProvider are **not** fields of the HTTP model.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Skill ID. |
| `name` | string | Localized skill name. |
| `desc` | string | Description. |
| `icon` | string | Readable icon URI, or empty. |
| `order` | integer | Stored order. |
| `color` | integer | Android packed color integer. |
| `exp` | integer | Current total EXP. |
| `level` | integer | Current level. |
| `untilNextLevelExp` | integer | EXP remaining before the next level. |
| `currentLevelExp` | integer | EXP earned since the current level began. |
| `type` | integer | 0 user; 1 strength; 2 learning; 3 charm; 4 endurance; 5 vitality; 6 creativity. |

### GET /skill_groups :id=get-skill-groups

Returns `SkillGroup[]`. `include_hidden` has the same strict Boolean parsing as `/items_categories`, default false. The current app repository ignores this flag for groups and always excludes deleted groups. Stored order is ascending. No pagination.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Group ID. |
| `content` | string | Group title. |
| `order` | integer | Stored group order. |
| `collapsed` | boolean | Collapsed state. |

## Achievements :id=get-achievements

`GET /achievements` returns `Achievement[]` by loading each category in category order and concatenating its achievements. `GET /achievements/{id}` returns achievements **in category `id`**, not an achievement detail. Invalid path IDs behave like the unfiltered route. Sorting inside each category follows the category's app sort preference. Neither endpoint is paginated.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Achievement ID. |
| `name` | string | Title. |
| `desc` | string | Description. |
| `iconUri` | string | Icon URI or empty. |
| `categoryId` | integer | Category ID. |
| `status` | integer | 0 incomplete; 1 completed with unclaimed reward; 2 reward claimed/other completed state. |
| `exp` | integer | EXP reward. |
| `coin` | integer | Coin reward. |
| `coinVariable` | integer | Variable coin reward. |
| `type` | integer | 0 achievement; 1 subcategory heading. |
| `progress` | integer | Stored progress. |
| `order` | integer | Order within category. |
| `itemId` | integer or null | First reward item ID (legacy convenience field). |
| `itemAmount` | integer or null | First reward item quantity. |
| `unlockedTime` | integer or null | Unlock Unix time in milliseconds. |
| `items` | RewardItem[] or null | Complete reward item list; current parser supplies an empty array for absent/malformed item JSON. |
| `color` | string or null | Custom title color. |

Reward items use the shared [RewardItem](#reward-item) model.

### GET /achievement_categories :id=get-achievement-categories

Returns `AchievementCategory[]`, without parameters or pagination. The HTTP server does not expose `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Category ID. |
| `name` | string | Name. |
| `desc` | string | Description. |
| `iconUri` | string | Icon URI/string. |
| `isAsc` | boolean | Ascending sort flag. |
| `sort` | string | Stored sort preference. |
| `filter` | string | Stored grouping/filter preference. |
| `order` | integer | Category order. |
| `type` | integer | 0 user achievements; 1 system achievements. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Returns `AchievementCondition[]` for **achievement** ID `id`. A non-integer ID returns an error envelope with code 500. Missing matching conditions produce an empty array. There is no `/achievement_conditions` collection route.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Condition ID. |
| `type` | integer | Condition code; see below. |
| `relatedId` | integer | Related task/item/skill identifier according to the condition. |
| `target` | integer | Target value. |
| `current` | integer | Current accumulated value. |
| `progress` | integer | Stored progress. |

Condition codes are: 0 task completions; 1 current task streak; 2 legacy attribute level; 3 tomatoes; 4 app usage days; 5 likes; 6 consecutive completion days; 7 current coins; 8 coins gained in one day; 9 task tomatoes; 10 item purchases; 11 item uses; 12 loot-box item gains; 13 skill level; 14 life level; 15 cumulative item gains; 16 synthesis item gains; 17 currently owned item quantity; 18 task focus time; 19 ATM savings; 20 external API. Repeating conditions: 500 task completions; 501 skill level increases; 502 tomatoes; 503 coins; 504 item gains; 505 item purchases; 506 loot-box gains; 507 synthesis gains; 508 item uses; 509 task focus minutes; 510 task tomatoes; 511 likes; 512 ATM savings increases; 513 external API calls; 514 usage days; 515 life level increases; 516 daily coins; 517 consecutive task completions; 518 daily tomatoes; 519 daily focus minutes; 520 daily distinct task groups; 521 daily item uses; 522 daily item purchases; 523 daily completions of a specified task; 524 daily total task completion records. These are raw integer codes, not serialized enum names.

## Synthesis :id=get-synthesis

`GET /synthesis` returns `Synthesis[]` across visible categories. `GET /synthesis/{id}` returns recipes **in category `id`**, including that category's hidden content. Nonnegative IDs select a category; negative IDs mean all visible categories. Invalid IDs fall back to the collection route. Results follow stored recipe order ascending; deleted recipes are excluded. No pagination.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Recipe ID. |
| `name` | string | Name. |
| `desc` | string | Description. |
| `input` | SynthesisItemInfo[] | Required items. |
| `output` | SynthesisItemInfo[] | Produced items. |
| `categoryId` | integer or null | Category ID. |
| `canSynthesisTimes` | integer | Currently available synthesis count. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Field | JSON type | Meaning |
| --- | --- | --- |
| `itemId` | integer | Item ID. |
| `itemName` | string | Item name. |
| `amount` | integer | Input/output quantity per synthesis. |
| `ownedNumber` | integer | Owned quantity. |
| `icon` | string | Readable icon URI or empty. |

### GET /synthesis_categories and /synthesis_categories/{id} :id=get-synthesis-categories

Both return `SynthesisCategory[]`. The optional path `id` filters category ID; it does not change the array shape. Invalid IDs fall back to all categories. Optional `include_hidden` uses strict lowercase Boolean parsing and defaults to false, including when a category ID is supplied. No pagination.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Category ID. |
| `name` | string | Name. |
| `isAsc` | boolean | Stored ascending sort flag. |
| `sort` | string | Stored sort preference. |
| `order` | integer | Category order. |
| `hidden` | boolean | Hidden flag. |

## Feelings :id=get-feelings

`GET /feelings` returns `Feelings[]`. Query `offset` defaults to 0 and `limit` to 100; missing or non-integer values use those defaults. This endpoint has no explicit clamp. Use nonnegative offsets and positive limits. Deleted feelings are excluded. Sorting follows the app's feelings order preference (`createTime` ascending or descending), not a request parameter. No time filter is exposed.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Feeling ID. |
| `content` | string | Text. |
| `isFav` | boolean | Favorite flag. |
| `title` | string | Related title. |
| `time` | integer | Creation Unix time in milliseconds. |
| `attachments` | string[] | Readable attachment URIs for existing nonempty files. |
| `type` | integer | 0 task; 1 achievement; 2 independent entry. |

## Pomodoro records :id=get-pomodoro-records

`GET /pomodoro_records` returns `PomodoroRecord[]`. `offset` defaults to 0, `limit` to 100; no explicit clamp. Optional `time_range_start` and `time_range_end` are Unix milliseconds. The SDK forwards the range only when both parse as 64-bit integers and start is less than end; otherwise the range is silently omitted.

Without a range, completed, nondeleted records with `startTime != endTime` and positive `endTime` are returned in `endTime DESC, startTime DESC, id DESC` order. A valid range selects `start < endTime <= end` and excludes deleted rows.

> [!WARNING]
> Earlier implementations passed `limit` and `offset` to the DAO in reversed positions for date-range queries and omitted ordering. The local LifeUp source has been corrected to pass named arguments and sort paginated results by `endTime DESC, startTime DESC, id DESC`; this local fix has not been released. Until you confirm that your installed LifeUp build includes it, omit the range and filter returned rows in the client for reliable pagination.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Record ID. |
| `startTime` | integer or null | Start Unix time in milliseconds. |
| `endTime` | integer or null | End Unix time in milliseconds. |
| `duration` | integer | Milliseconds: stored nonzero `lastTime`, otherwise end minus start. |
| `reward` | number | Earned tomato amount: abandoned = 0; half = 0.5 × multiplier; otherwise multiplier. |

## Inventory records :id=get-inventory-records

`GET /inventory_records` returns `InventoryRecord[]`. `offset` defaults to 0 and is clamped to at least 0; `limit` defaults to 100 and is clamped to 1–200. Optional `time_range_start` and `time_range_end` are forwarded only if both parse as 64-bit integers and start < end; invalid/incomplete ranges are silently omitted by the SDK. Valid ranges use inclusive `time >= start AND time <= end`. Deleted records are excluded (`isDel` null or 0); sorting is `time DESC, id DESC`. No item-ID filter is exposed.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Record ID. |
| `time` | integer or null | Creation Unix time in milliseconds. |
| `itemId` | integer or null | Related item ID. |
| `itemName` | string or null | Related item name when available. |
| `changeNumber` | integer | Recorded quantity change. |
| `isDecrease` | boolean | Whether the change decreases inventory. |
| `resCode` | integer | Source reason code; see below. |
| `desc` | string or null | Record description. |

Reason codes: 0 purchase; 1 use; 2 task completion; 3 undo completion; 4 clear data; 5 give up task; 6 overdue task; 7 built-in achievement unlock; 8 undo give-up; 9 undo overdue; 10 return item; 11 subtask completion; 12 undo subtask completion; 13 user achievement unlock; 14 undo user achievement unlock; 15 deposit; 16 withdrawal; 17 tomato sale; 20 reward item; 21 undo reward; 23 synthesis; 24 loot box; 25 ATM interest; 26 tomato exchange item; 27 credit interest; 28 API; 29 item-effect stock change. Clients should preserve unknown future codes.

## Step records :id=get-step-records

`GET /step_records` returns `StepRecord[]`. Pagination defaults/clamps and SDK range omission rules match `/inventory_records`. The valid time filter is inclusive on `date`; sorting is `date DESC` without an explicit secondary key.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Record ID. |
| `date` | integer or null | Recorded date as Unix milliseconds. |
| `dailyStepCount` | integer | Daily step count. |
| `totalStepCount` | integer | Stored cumulative step count. |
| `isGotReward` | boolean | Reward claimed flag. |
| `isUserInput` | boolean | User-entered flag. |
| `rewardLevel` | integer or null | Stored reward level. |

## Level definitions :id=get-level-defines

`GET /level_defines` returns a single `LevelDefines` object. No parameters. Uses custom definitions when custom level mode is enabled, otherwise built-in definitions.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Field | JSON type | Meaning |
| --- | --- | --- |
| `custom` | boolean | Custom level mode. |
| `levels` | LevelDefine[] | Level ranges. |

### LevelDefine :id=model-level-define

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer or null | Definition ID. |
| `levelStart` | integer | Starting level. |
| `levelEnd` | integer | Ending level. |
| `perLevelExp` | integer | EXP required per level in the range. |

Malformed level JSON currently becomes an empty `levels` array rather than failing the complete request.

## Statistics :id=get-statistics

`GET /statistics` returns one `Statistics` object. Optional `time_range_start` and `time_range_end` use Unix milliseconds and the same SDK forwarding rule: both valid and start < end, otherwise no range is sent. Without a range, the app uses its first recorded timestamp through now; if none exists, it uses the last 30 days. `usingDays` and `companionDays` are lifetime values even when a range is provided. The other metrics are computed by their respective app statistics methods; do not assume that all underlying metric queries share identical endpoint inclusion rules.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Field | JSON type | Meaning |
| --- | --- | --- |
| `start` | integer or null | Effective range start in Unix milliseconds. |
| `end` | integer or null | Effective range end in Unix milliseconds. |
| `tomatoes` | integer | Earned tomato statistic. |
| `pomodoroMinutes` | integer | Focus duration in minutes. |
| `focusCount` | integer | Focus session count. |
| `tasksCompleted` | integer | Completed task count used by the completion statistic. |
| `tasksTotal` | integer | Total task count used by that statistic. |
| `taskCompleteRate` | number | Completion ratio. |
| `feelingsCount` | integer | Feeling count. |
| `usingDays` | integer | Lifetime usage days. |
| `companionDays` | integer | Lifetime companion days. |
| `interestChanged` | integer | Interest coin change statistic. |
| `coinPurchaseConsumed` | integer | Purchase coin consumption statistic. |

## App information and coin balance :id=get-info

`GET /info` returns `Info`. LifeUp Cloud adds its own installed version to the app/provider information. No parameters.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Field | JSON type | Meaning |
| --- | --- | --- |
| `appVersion` | integer | Installed LifeUp version code. |
| `appVersionName` | string | Installed LifeUp version name. |
| `apiVersion` | integer | LifeUp API version. |
| `cloudVersion` | integer | Installed LifeUp Cloud version code. |
| `cloudVersionName` | string | Installed LifeUp Cloud version name. |

### GET /coin :id=get-coin

Invokes `lifeup://api/query?key=coin` through the ContentProvider and returns its result object. No parameters. A null provider result becomes an empty object. Fields are provider-defined, rather than a typed `CoinData` response. A successful query supplies `value` (signed 64-bit integer coin balance) and `api_result: true`; failures can supply the provider status/error fields described below.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Invoke a URL Scheme API :id=invoke-api

The [URL Scheme API catalog](/guide/api) defines method names, method parameters, and method-specific results. The HTTP bridge accepts the full `lifeup://api/...` URL.

| `Transport` | Input | Execution and response |
| --- | --- | --- |
| `GET /api` | Repeated URL-encoded query `url` | Starts an Android activity for each URL, in supplied order. Returns the string `success`. Missing URLs also return success. |
| `POST /api` | JSON `RawQueryVo` | Starts every `urls` entry first, then `url` if present. Returns the string `success`. Empty input object also succeeds. |
| `GET /api/contentprovider` | Repeated URL-encoded query `url` | Calls the provider synchronously and returns `CallUrlResult[]` in supplied order. Missing URLs return an error envelope (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Calls every `urls` entry first, then `url`; returns `CallUrlResult[]`. Empty object returns an empty array. |

Set `Content-Type: application/json` for JSON POSTs. URL-encode the whole URL when embedding it in a GET query, preserving internal `&`, `?`, `+`, and percent encoding. A successful activity bridge response confirms dispatch, not completion of the LifeUp action. ContentProvider methods require Cloud's permission in LifeUp and support depends on the URL Scheme method. Calls are sequential; if a later call throws, earlier effects are not rolled back.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity bridge response:

```json
{"code":200,"message":"success","data":"success"}
```

Provider bridge response (illustrative provider result):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Field | JSON type | Meaning |
| --- | --- | --- |
| `url` | string or null | Optional single URL. |
| `urls` | string[] or null | Optional URL list; processed before `url`. |

### CallUrlResult :id=model-call-url-result

| Field | JSON type | Meaning |
| --- | --- | --- |
| `url` | string | Submitted URL. |
| `result` | object or null | Converted provider Bundle; null does not itself make the HTTP envelope fail. |

The Bundle conversion preserves Int/Long/Double/String/Boolean values and nested Bundles. Arrays become arrays of strings. Other value types become their `toString()` string (including a Bundle null value becoming the string `"null"`). Method failure fields inside `result` must be checked even when the outer envelope has code 200.

The current LifeUp method handler adds `api_result` (boolean) to completed calls. A caught method failure returns `api_result: false`, `error_code` (string), and `error_message` (string). Error codes include `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled`, and `internal_error`; individual methods can supply additional codes. During backup restoration the provider can return `error_code: "503"` and `error_message` without `api_result`. Missing API handlers can throw before this method error conversion, producing an outer bridge error instead.

## Read and upload files :id=files-download

### GET /files/{url} :id=files-get

URL-encode the complete readable URI as one path segment. This reads bytes through Android's content resolver, typically for icons, feeling attachments, backup exports, or uploaded files. The result is a byte stream, not a JSON success envelope. The route does not specify a filename or MIME type. Empty/unreadable resolver streams are not converted into a structured not-found result; thrown failures use the global HTTP 500 handler. A blank matched parameter produces an error envelope (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Send `multipart/form-data`. Every file part is accepted regardless of field name; nonfile form parts are ignored. Each original filename is used for a cache file; without one Cloud chooses `uploaded_image_<time>.jpg`. Returns an array of readable content URI strings. Uploading supplies a file URI for later API calls; it does not attach it to an item or task automatically. No files returns an error envelope with `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Backup export and import :id=files-backup

### GET /data/export :id=files-export

Triggers backup creation through the provider. Optional query `withMedia` defaults to `true`; when present, case-insensitive `true` means true and any other value means false. Returns the converted provider Bundle, currently containing `backup_file_uri`; use `/files/{url}` to download that URI. This endpoint creates an export even though its HTTP method is GET. Provider API status/error fields can also be present and must be checked. An empty `backup_file_uri` indicates export did not produce a usable file. A null result becomes an error.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Send `multipart/form-data` with a backup file. The last file part wins if multiple are supplied; its field name is not checked. Filename defaults to `backup.lfbak`. Optional form field `description` is read but has no effect. Cloud caches the file and launches LifeUp's backup activity; the response confirms upload and activity launch, **not completed restoration**. No file returns `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Events :id=get-events

### GET /events :id=get-events-poll

Returns `EventsPage`. `after` is an exclusive event ID cursor (64-bit integer, default 0). `limit` is an integer defaulting to 50 and clamped to 1–200. Non-integer values use defaults. Events are oldest first within the retained buffer, with `id > after`. At most 200 events are retained in memory; older events are dropped and process restarts reset IDs. `latestId` is the latest available global ID, not necessarily the last event in a limited page. Continue from the last event actually processed to avoid skipping a backlog. No durable history or delivery acknowledgement is provided.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Field | JSON type | Meaning |
| --- | --- | --- |
| `latestId` | integer | Current latest event ID. |
| `eventWs` | boolean | Cloud's WebSocket setting. |
| `events` | CloudEvent[] | Retained events after the cursor. |
| `broadcasts` | boolean or null | Whether LifeUp broadcasts are enabled; null means unknown or unsupported. Query status is cached for five seconds. |

### CloudEvent :id=model-cloud-event

| Field | JSON type | Meaning |
| --- | --- | --- |
| `id` | integer | In-memory event sequence ID. |
| `time` | integer | Cloud reception Unix time in milliseconds. |
| `action` | string | Android broadcast action. |
| `extras` | object of string values | Broadcast extras converted with `toString()`; null becomes an empty string. Keys depend on the action. |

### WebSocket /events :id=get-events-websocket

When `eventWs` is true, connect to `ws://HOST:PORT/events?after=ID` (and supply the configured token). The server replays retained events after `after` and then sends live events as individual JSON `CloudEvent` text frames, **without** the HTTP response envelope. The replay is limited by the 200-event memory buffer; there is no `limit` WebSocket parameter. The server sends Ping frames every 30 seconds. Reconnect with the last event ID actually processed. When disabled, the WebSocket route is not registered; HTTP polling remains available.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Supported action subscriptions are `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, and `app.lifeup.timing.abandon`. Event collection requires LifeUp broadcasts to be enabled. Polling `/events` checks that setting; it does not enable it automatically.

# HTTP 接口与参数参考 :id=http-query-reference

本参考集中说明云人升的请求参数和完整 HTTP 响应模型。安装、授权和连接步骤见[云人升介绍](/guide/api_cloud)。新增流水接口需要人升 **1.106.0+** 和云人升 **3.0.0+**，可通过 `/info` 确认已安装版本。本参考描述当前源码契约，不代表某个版本已在所有渠道发布。

## 接口索引 :id=interface-index

| 资源 | 方法与路径 | 参数与模型 |
| --- | --- | --- |
| 通用规则 | JSON 响应、授权、缓存条件、分页 | [约定](#representations)、[缓存与授权](#auth-cache)、[分页](#pagination) |
| 任务 | `GET /tasks`、`GET /tasks/{categoryId}`、`GET /tasks_categories` | [查询](#get-tasks)、[任务模型](#task-fields)、[分类](#get-tasks-categories) |
| 任务历史 | `GET /history` | [参数](#get-history)、[三个时间](#task-times)、[日报](#daily-report) |
| 商品 | `GET /items`、`GET /items/{listId}`、`GET /items_categories` | [商品 ID、分类 ID 与完整模型](#get-items) |
| 属性 | `GET /skills`、`GET /skill_groups` | [属性与分组](#get-skills) |
| 成就 | `GET /achievements`、`GET /achievements/{id}`、`GET /achievement_categories`、`GET /achievement_conditions/{id}` | [成就与条件](#get-achievements) |
| 合成 | `GET /synthesis`、`GET /synthesis/{id}`、`GET /synthesis_categories`、`GET /synthesis_categories/{id}` | [配方与分类](#get-synthesis) |
| 感想 | `GET /feelings` | [分页感想](#get-feelings) |
| 经验/金币 | `GET /exp_records`、`GET /coin_records` | [流水参数与模型](#reward-journals) |
| 其他记录 | `GET /pomodoro_records`、`GET /inventory_records`、`GET /step_records` | [番茄](#get-pomodoro-records)、[仓库](#get-inventory-records)、[步数](#get-step-records) |
| 等级/统计 | `GET /level_defines`、`GET /statistics` | [等级](#get-level-defines)、[统计](#get-statistics) |
| 应用/余额 | `GET /info`、`GET /coin` | [版本信息](#get-info)、[金币结果](#get-coin) |
| 调用动作 | `GET` / `POST /api`、`GET` / `POST /api/contentprovider` | [调用桥接](#invoke-api)；业务方法仍见 [URL Scheme 清单](/guide/api) |
| 文件/备份 | `GET /files/{url}`、`POST /files/upload`、`GET /data/export`、`POST /data/import` | [文件](#files-download)、[备份传输](#files-backup) |
| 事件 | `GET /events`、WebSocket `/events` | [轮询与实时事件](#get-events) |
| 入口页 | `GET /` | HTML 介绍页，不是 JSON 资源。 |

MCP 使用独立的客户端/工具表示，见 [MCP 区别](#mcp-differences)和 [MCP 指南](/guide/api_mcp)。

## 接入方式与数据表示 :id=representations

| 接口 | 数据表示 | 注意事项 |
| --- | --- | --- |
| Cloud HTTP 查询 | `{code, message, data}` 包装的 JSON | 下述接口参考描述的是这层对外 JSON。 |
| Android ContentProvider | Cursor 列，如 `_ID` / `_GID`；部分列包含 JSON 文本 | SDK 将其转换为 `id` / `gid` 等 HTTP 字段和嵌套数组。Cursor 列定义不等同于 HTTP 结构。 |
| URL Scheme 动作 | `lifeup://api/{method}` 和各方法的参数/结果 | 即使 HTTP 读取字段采用 camelCase，写入参数也可能采用 snake_case。 |
| MCP 列表工具 | 工具自己的包装，以及精简或完整记录 | MCP 分页及输出字段是客户端额外行为，不属于 HTTP 响应字段。 |

## 响应与错误 :id=response-errors

HTTP JSON 共用 `HttpResponse<T>` 包装：

| 字段 | 类型 | 含义 |
| --- | --- | --- |
| `code` | 整数 | 查询成功为 `200`，其他值表示错误。这是正文中的字段，与 HTTP 状态分开。 |
| `message` | 字符串 | 成功时通常为 `success`，错误时为错误说明。 |
| `data` | `T` 或 `null` | 成功时为接口定义的值（数组、对象或字符串），错误时为 `null`。 |

成功返回空列表的示例：

```json
{"code":200,"message":"success","data":[]}
```

权限或 Provider 访问错误的示例：

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| 信号 | 如何处理 |
| --- | --- |
| HTTP `401` | 将 Cloud 设置的 token 原样放入 `Authorization` 请求头，不添加 `Bearer`。 |
| 正文 `code = 10001` | 检查人升是否已安装并运行，以及云人升是否获得“读取人升数据”权限。 |
| 正文 `code = 10002` | ContentProvider 查询失败，查看错误说明。 |
| 其他非成功状态或代码 | 视为查询失败，而非空结果。 |

需要**同时**检查 HTTP 状态和正文 `code`。部分路由失败时仍返回 HTTP `200`，错误体现在正文代码中。通过 `/api/contentprovider` 执行动作时，还需检查每一项的 `data[].result.api_result`；外层 `code=200` 不能证明每个动作都成功。

## 授权与条件读取 :id=auth-cache

配置了云人升令牌时，将其原始值放入 `Authorization`，不添加 `Bearer`。服务也接受查询参数 `token`，适用于无法设置 WebSocket 请求头的客户端等情况。缺少或错误令牌会返回 HTTP `401` 和正文 `code=401`。入口页、资源、调用桥接、文件、备份和事件均受此检查约束。

成功的 JSON 资源读取会返回强 SHA-256 `ETag` 和 `Cache-Control: private, no-cache`。适用于任务/历史、商品/分类、属性/分组、成就/条件、感想、合成/分类、流水、等级、统计、应用信息和金币资源；不适用于调用桥接、文件传输、备份传输、事件流或事件轮询。

| 请求头 | 当前响应行为 |
| --- | --- |
| `If-Match` | 版本不匹配时返回 HTTP `412`；先于 `If-None-Match` 判断。 |
| `If-None-Match` | 版本匹配时返回 HTTP `304`，没有可解析的 JSON 正文，应复用已缓存的成功结果。 |

错误封装不包含资源版本头。条件读取以单次资源请求为单位，不构成跨页或跨接口的快照/事务。

跨域浏览器请求可以使用 `If-None-Match`。当前 CORS 配置未在预检中允许 `If-Match`，因此在修改该实现前，不应依赖跨域浏览器的 `If-Match` 请求。原生客户端不受浏览器 CORS 限制。

## 通用数据约定 :id=data-conventions

| 约定 | 规则 |
| --- | --- |
| 时间 | 时间戳字段使用 Unix 毫秒时间戳。自然日边界取决于目标时区，各字段仍有各自的资源含义。 |
| 标识 | 任务 `id` 标识某个任务/周期，任务 `gid` 标识跨重复周期的任务组。分类/清单 ID 标识另一类资源。 |
| 空值 | 字段缺失、`null`、`0`、`""` 和 `[]` 含义不同。各模型分别说明实际回退或省略行为。 |
| 数值 ID | ID 可为有符号 64 位整数，JavaScript Number 不能精确表示所有值；较大 ID 应使用合适的 JSON 解析器保留精度。 |
| 数组与对象 | HTTP 中 `items`、`subTasks` 等嵌套值是数组，不是编码后的 JSON 字符串。 |
| 状态与原因代码 | 使用对应资源的枚举。任务状态、成就状态和流水原因代码属于不同范围。 |

`startTime`、`deadline` 和 `endTime` 的定义见[任务时间字段](/guide/api-reference?id=task-times)。

## 分页与筛选 :id=pagination

分页是一项接口能力，并非所有列表都支持。原始 HTTP 列表响应使用 `data: [...]`，**不会**额外返回 `total`、`count` 或 `hasMore`。

| HTTP 接口 | 分页 | 日期范围 | 其他筛选 |
| --- | --- | --- | --- |
| `/tasks`、`/tasks/{categoryId}` | 不分页，返回完整数组 | 不支持 | 路径中的可选分类 |
| `/history` | 服务端 `offset` / `limit` | 不支持 | 可选 `gid` |
| `/feelings` | 服务端 `offset` / `limit` | 不支持 | 见[感想](#get-feelings) |
| `/pomodoro_records`、`/coin_records`、`/inventory_records`、`/exp_records`、`/step_records` | 服务端 `offset` / `limit` | `time_range_start` / `time_range_end` | 见各接口 |
| `/statistics` | 不分页，返回单个对象 | `time_range_start` / `time_range_end` | 聚合查询 |
| `/coin`、`/info` | 不分页，返回单个对象 | 不支持 | 单对象查询 |

支持分页的接口在 HTTP 层默认 `offset=0`、`limit=100`。通用分页循环请使用非负偏移量及 `1..100` 的页大小。HTTP 桥接不会应用 MCP 的 `1..100` 限制，而下游 Provider 可能施加其他限制；请查阅各接口的实际页大小和校验说明。

除[带时间过滤的番茄记录限制](#get-pomodoro-records)外，每页成功后，将 `offset` 增加本页返回的记录数。当记录数小于实际生效的页大小时结束（使用 `1..100` 时就是请求的 `limit`，但不包括带时间过滤的番茄记录）。不要把 Provider 限制后的页误认为末页。超出末尾的空页属于正常结果。多次分页请求不会建立快照：查询过程中记录仍可能变化。

当前 HTTP SDK 仅在日期边界**均可解析为整数且 `start < end`** 时向下传递筛选条件。单边、无法解析或逆序的边界会导致不带日期过滤的查询，不能依赖报错来发现此类问题。发送前应自行校验两个边界。流水参考页说明对应接口的边界包含规则。

## MCP 的区别 :id=mcp-differences

MCP 列表工具默认 `limit=20`，将其限制在 `1..100`，并将 `offset` 限制为至少 `0`。历史、流水等资源由服务端分页；任务等资源则先读取完整 HTTP 数组，再在客户端截取。`items`、`count`、`hasMore` 和可选 `total` 属于 MCP 包装。`detail=false` 还会移除每条记录中的部分字段；需要完整 HTTP 模型时使用 `detail=true`。

## 来源与版本范围 :id=api-common-sources

本参考描述当前公开 SDK 及对应的人升 Provider 行为，示例使用虚构数据。源码链接用于核对实现，不能证明某个已安装版本具备全部字段：[HTTP 路由](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)、[HTTP 包装](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt)、[MCP 查询映射](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts)。


## 任务与历史数据模型 :id=task-history-models

本页定义[任务与历史查询](/guide/api-reference?id=task-queries)返回的 **HTTP JSON**。Android Cursor 列和 URL Scheme 动作参数可能采用不同的名称和表示方式，见[通用约定](/guide/api-reference?id=representations)。

SDK 使用同一个序列化 `Task` 类提供两种视图。本页用 `Task` 表示 `/tasks` 视图，用 `HistoryRecord` 表示 `/history` 视图。这些名称只是描述现有输出，并未引入新 API。当前 Cloud 序列化会包含默认值和 `null` 字段。

### Task / HistoryRecord 字段 :id=task-fields

下列所有字段都会出现在当前 HTTP 对象中。Provider 缺失的值通常会转换为表中的回退值；出现回退值不能证明源数据原本包含该值。

| 字段 | JSON 类型 | 含义 / 回退值 |
| --- | --- | --- |
| `id` | 整数或 `null` | 此任务/周期的 ID。 |
| `gid` | 整数或 `null` | 重复周期共用的任务组 ID。 |
| `name` | 字符串 | 任务名称。Provider 缺失名称时变为 `ERROR: name is null`。 |
| `notes` | 字符串 | 备注；缺失时为空字符串。 |
| `status` | 整数 | 任务状态；缺失时默认为 `0`。见下方状态表。 |
| `startTime` | 整数 | 配置的开始时间，单位为毫秒；SDK 回退值为 `0`。 |
| `deadline` | 整数 | 截止时间，单位为毫秒；缺失时 SDK 回退值为 `0`。 |
| `remindTime` | 整数 | 提醒时间，单位为毫秒；缺失时 SDK 回退值为 `0`。 |
| `frequency` | 整数 | 重复代码；`0` 为单次，`1` 为每天，`-1` 为无限。其他重复模式见[任务动作](/guide/api)。SDK 回退值为 `0`。 |
| `weekdays` | 字符串 | 选择的星期，如 `1,3,5`（周一为 `1`，周日为 `7`）；未提供时为空，历史视图固定为空占位值。 |
| `importance` | 整数或 `null` | 重要程度，取值 `1`–`4`（数值越大越重要），对应 App 的任务紧急度（`taskUrgencyDegree`）。在 `GET /tasks` 与 `GET /tasks/{categoryId}` 中，当任务列表 Provider 提供该列时有值；列缺失或为 NULL 时 SDK 解析为 `null`。历史 Provider 不返回该列，故 `/history` 此处为 `null`，并不表示 App 未保存该紧急度。 |
| `difficulty` | 整数或 `null` | 困难程度，取值 `1`–`4`（数值越大越难），对应 App 的任务难度（`taskDifficultyDegree`）。与 `importance` 相同的 `/tasks` 与 `/history` Provider 行为。 |
| `exp` | 整数 | 配置的经验奖励，并非流水金额；默认为 `0`。 |
| `skillIds` | 整数数组 | 奖励关联的属性；不可用时为空数组。 |
| `coin` | 整数 | 配置的金币奖励；默认为 `0`。 |
| `coinVariable` | 整数 | 随机金币奖励设置；默认为 `0`。 |
| `itemId` | 整数 | 旧版的首个奖励物品 ID；默认为 `0`。完整列表请使用 `items`。 |
| `itemAmount` | 整数 | 旧版的首个奖励物品数量；默认为 `0`。此 HTTP 字段名与 Provider 的 `itemCount` 列不同。 |
| `words` | 字符串 | 完成激励语；缺失时为空。 |
| `categoryId` | 整数 | 任务分类/清单 ID；缺失时默认为 `0`。 |
| `order` | 整数 | 任务列表排序值；历史 Provider 不返回该列，因此历史视图固定以 `0` 占位。 |
| `nameExtended` | 字符串 | 扩展显示名称；历史 Provider 不返回该列，因此历史视图固定以空字符串占位。 |
| `endTime` | 整数 | 历史记录中保存的结束时间。`/tasks` 将此字段填为 `0`，见[时间语义](/guide/api-reference?id=task-times)。 |
| `items` | `RewardItem[]` | 物品奖励；不可用时为空数组。 |
| `subTasks` | `SubTask[]` | 嵌套子任务；不可用时为空数组。 |
| `countProgress` | `TaskCountProgress` 或 `null` | 可用时的计数进度快照；两种视图均可能包含。 |
| `repeatEndCondition` | `TaskRepeatEndCondition` 或 `null` | `/tasks` 中的重复结束规则；`/history` 中始终为 `null`。 |

### 任务状态与时间戳 :id=task-times

| `status` | 含义 | 历史 `endTime` 的含义 |
| --- | --- | --- |
| `0` | 未完成 | 不代表完成时间；`/history` 查询的是已结束记录。 |
| `1` | 已完成 | 记录的完成时间。 |
| `2` | 已逾期 | 记录的逾期时间。 |
| `3` | 已放弃 | 记录的放弃时间。 |

| 时间字段 | 定义 |
| --- | --- |
| `startTime` | 任务配置/计划的开始时间，并非用户实际开始做任务的时间。 |
| `deadline` | 计划截止时间，与记录的结束时间不同。 |
| `endTime` | 历史任务记录的结束时间；按上表结合 `status` 解读。 |

三者均使用 Unix 毫秒时间戳。正常完成任务时，App 记录当前时间。`history_operation` 的 `operation=edit_completed_time` 接受 `completed_time` 输入，修改同一个已保存的完成时间；读取历史时字段名仍为 `endTime`。

已保存的时间可以编辑。已结束记录未保存结束日期时，App 会回退为当前时间。因此，`endTime` 表示当前记录的时间，并非不可变的审计时间戳。`/tasks` 中的 `0` 只是 SDK 占位值，并非真的在 Unix 纪元发生了事件。

### RewardItem :id=reward-item

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `itemId` | 整数 | 奖励物品 ID。 |
| `itemCount` | 整数 | 奖励数量。 |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| 字段 | JSON 类型 | 含义 / 默认值 |
| --- | --- | --- |
| `id` | 整数 | 子任务 ID。 |
| `gid` | 整数 | 子任务组 ID。 |
| `todo` | 字符串 | 子任务文本。 |
| `status` | 整数 | `0` 未完成，`1` 已完成。 |
| `remindTime` | 整数或 `null` | 提醒时间戳，单位为毫秒；不可用时为 `null`。 |
| `endTime` | 整数或 `null` | 子任务完成时间戳，单位为毫秒；不可用时为 `null`。 |
| `exp` | 整数 | 配置的经验奖励。 |
| `coin` | 整数或 `null` | 配置的金币奖励。 |
| `coinVariable` | 整数或 `null` | 随机金币奖励设置。 |
| `items` | `RewardItem[]` | 物品奖励；默认为空数组。 |
| `order` | 整数或 `null` | 排序值；模型默认值为 `0`。 |
| `autoUseItem` | 布尔值或 `null` | 是否自动使用奖励；模型默认值为 `false`。 |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `currentCount` | 整数 | 此任务/周期的当前计数。 |
| `targetCount` | 整数 | 此任务/周期的目标计数。 |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| 字段 | JSON 类型 | 含义 / 默认值 |
| --- | --- | --- |
| `mode` | 字符串 | `COUNT` 或 `DATE`。这些是读取结果中的字符串，不是动作参数中的数值。 |
| `behavior` | 字符串 | `TERMINATE` 或 `FREEZE`。 |
| `targetCycleCount` | 整数或 `null` | `COUNT` 模式的周期次数目标；默认为 `null`。 |
| `endDateMillis` | 整数或 `null` | `DATE` 模式的结束日期毫秒时间戳；默认为 `null`。 |
| `inclusive` | 布尔值 | 是否包含结束日期；默认为 `false`。 |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### 奖励数额 :id=reward-amounts

这些任务和子任务字段描述配置的奖励。倍率、随机金币及结算规则可能改变实际发放数额。实际变动请查询[经验与金币流水](/guide/api-reference?id=reward-journals)，并区分正向奖励与包含撤销、惩罚的净变动。

### 实现参考 :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [解析器](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [计数进度](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [重复规则](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt)。


## 任务与历史查询 :id=task-queries

请先阅读[通用约定](/guide/api-reference?id=http-query-reference)和[完整的 Task/History 模型](/guide/api-reference?id=task-history-models)。这些接口需要云人升的“读取人升数据”权限。基础列表查询要求人升 v1.91+ 和最新版云人升；示例描述当前 SDK 字段。接入旧版安装时请检查 `/info`。

### GET /tasks 与 /tasks/{categoryId} :id=get-tasks

查询当前的**未完成**任务列表，可选按分类/清单限制范围。结果为完整数组，并非服务端分页响应。已完成、已逾期和已放弃记录归入 `/history`。

| 参数 | 位置 | 类型 | 必需 | 默认值 / 行为 |
| --- | --- | --- | --- | --- |
| `categoryId` | 路径 | 整数 | 仅 `/tasks/{categoryId}` 需要 | 查询不限分类的任务列表时，省略整个路径段。 |

这些路由不支持 `offset`、`limit`、`gid` 或日期范围查询参数。当前实现会将非整数分类路径段解析为未指定分类；请在请求前校验，避免意外查询全部任务。

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**响应：** `HttpResponse<Task[]>`。全部记录字段及嵌套结构见 [Task/History 字段](/guide/api-reference?id=task-fields)。下面的虚构记录展示完整的 HTTP 顶层结构；此路由的 `endTime=0` 是占位值，并非完成时间戳。

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

**行为与错误：** 列表选择和排序遵循人升任务列表逻辑；此接口不保证按完成时间排序。成功的 `data: []` 表示选定任务列表未返回记录。权限/Provider 失败采用[通用错误包装](/guide/api-reference?id=response-errors)，不属于空数组。统计完成情况时应使用下面的 `/history`，而不是此路由的 `endTime`。

### GET /history :id=get-history

查询可见的已结束任务记录，包含已完成、已逾期和已放弃任务，排除已删除的历史记录。

| 参数 | 位置 | 类型 | 必需 | 默认值 / 行为 |
| --- | --- | --- | --- | --- |
| `offset` | 查询 | 整数 | 否 | `0`；跳过的记录数，从零开始。 |
| `limit` | 查询 | 整数 | 否 | `100`；请请求正数页大小，建议 `1..100`。 |
| `gid` | 查询 | 整数 | 否 | 默认不按组筛选；提供时选择该任务组跨周期的记录。 |

HTTP 解析器会将无法解析的 `offset` / `limit` 回退为 `0` / `100`，忽略无法解析的 `gid`。此路由不会限制已解析数值的范围。请自行校验偏移量非负、页大小为正。**不支持** `time_range_start` / `time_range_end`，提供它们不会筛选历史记录。

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**响应：** `HttpResponse<HistoryRecord[]>`，采用 [Task/History 传输字段](/guide/api-reference?id=task-fields)。`HistoryRecord` 是本说明对 SDK `Task` 模型历史视图的称呼。此视图中 `repeatEndCondition` 为 `null`，`countProgress` 可能有值。保存的 `endTime` 需结合 `status` 解读。

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

**排序：** 按保存的结束日期降序，最新记录在前。结束日期相同时，没有文档约定的次级排序。分页不是快照；收集报表期间应避免编辑数据，合并多页时按 `id` 去重。

**分页与空结果：** 采用[通用分页流程](/guide/api-reference?id=pagination)。成功的空数组表示当前页/组没有匹配的可见记录，也包括 `offset` 超出末尾的情况。这不能证明从未发生活动：已删除记录被排除，接口也没有完整性标志。任何请求失败时，应报告数据不可用/不完整，而不是零任务。适用[通用错误说明](/guide/api-reference?id=response-errors)。

### 生成日报 :id=daily-report

1. 确定报表时区。计算自然日开始时间（`dayStart`）和下一个自然日开始时间（`nextDayStart`）。不要假定每个本地自然日都恰好为 24 小时。
2. 以 `offset=0&limit=100` 读取 `/history`，检查每次响应并收集所有分页。如需 `gid` 筛选，应保持各页一致。
3. 筛选 `status == 1` 且 `dayStart <= endTime < nextDayStart` 的记录。描述结果时遵守[记录时间的限制](/guide/api-reference?id=task-times)。
4. 实际经验与金币变动应读取同一天的[奖励流水](/guide/api-reference?id=reward-journals)。流水日期筛选包含两端，因此使用 `time_range_start=dayStart` 和 `time_range_end=nextDayStart-1`。
5. 区分“可用数据中未找到记录”与读取失败/未完成。确定报表只统计正向奖励，还是包含撤销的净变动，并始终保持一致。

任务/历史中的 `exp` 和 `coin` 是配置奖励，不能可靠地替代流水数额。将完成时间修改到另一天，不代表奖励流水的交易时间也随之移动。

### 实现参考 :id=api-task-queries-sources

[HTTP 路由](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [任务与历史解析](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt)。


## 经验与金币流水查询 :id=reward-journals

这些只读 HTTP 接口需要“读取人升数据”权限、人升 **1.106.0+** 和云人升 **3.0.0+**。返回的是记录的变动，包括减少和撤销，而非任务奖励配置。请先阅读[通用约定](/guide/api-reference?id=http-query-reference)。

### 两个接口的请求参数 :id=journal-parameters

以下约定同时适用于 `GET /exp_records` 和 `GET /coin_records`。

| 参数 | 位置 | 类型 | 必需 | 默认值 / 实际行为 |
| --- | --- | --- | --- | --- |
| `offset` | 查询 | 整数 | 否 | HTTP 默认值为 `0`；Provider 将负值限制为 `0`。 |
| `limit` | 查询 | 整数 | 否 | HTTP 默认值为 `100`；Provider 限制为 `1..200`。通用分页流程使用 `1..100`。 |
| `time_range_start` | 查询 | 整数（Unix 毫秒时间戳） | 否，或成对提供 | 交易记录时间的下界，包含边界。 |
| `time_range_end` | 查询 | 整数（Unix 毫秒时间戳） | 否，或成对提供 | 上界，包含边界；有效筛选要求 `start < end`。 |

无法解析或超出数值范围的分页参数采用 HTTP 默认值。无法解析的日期值视为缺失。当前 SDK 仅在两个边界均存在且 `start < end` 时传递日期范围，否则**不带日期筛选**查询。直接调用原始 ContentProvider 时，无效范围的校验行为不同。HTTP 调用方应自行校验边界。

两个接口均按记录的交易时间降序，最新记录在前，并排除已删除的流水条目。不保证以 ID 作为次级排序，也不提供跨页快照。按[分页流程](/guide/api-reference?id=pagination)读取，并考虑 Provider 实际生效的页大小。成功的空数组表示选定范围/页无匹配条目；读取失败不等于零活动。两个接口都不提供针对已删除或不可用数据的完整性标志。

### GET /exp_records :id=get-exp-records

查询经验变动。参数就是[上述四个流水参数](/guide/api-reference?id=journal-parameters)，没有 `gid` 筛选。

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**响应：** `HttpResponse<ExpRecord[]>`。当前序列化包含下列所有字段，包括可空值。

| 字段 | JSON 类型 | 含义 / 解析回退值 |
| --- | --- | --- |
| `id` | 整数或 `null` | 流水条目 ID。 |
| `time` | 整数或 `null` | 交易的 Unix 毫秒时间戳，与可编辑的任务完成时间不同。 |
| `value` | 整数 | 每个关联属性的经验变动；回退值为 `0`。使用 `isDecrease` 判断方向。 |
| `isDecrease` | 布尔值 | `true` 为减少，`false` 为增加；解析器将 Provider 整数 `1` 视为 true。 |
| `totalValue` | 整数 | 记录的经验变动合计，**并非经验余额**；回退值为 `0`。多属性分批记录时，保存的合计可能重叠，见[报表合计](/guide/api-reference?id=journal-totals)。 |
| `resCode` | 整数 | 经验专用原因代码；回退值为 `0`。 |
| `relatedId` | 整数或 `null` | 关联来源对象 ID。正常完成任务时为任务记录的 `id`，不是 `gid`。其他原因可能关联其他资源。 |
| `content` | 字符串或 `null` | 变动说明。 |
| `skillIds` | 整数数组 | 关联的属性/技能 ID；回退值为空数组。 |
| `relatedAttributes` | 字符串数组 | 关联的旧版属性字符串；回退值为空数组。 |

虚构示例：两个属性各增加 10 经验，合计 20 经验。

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**错误：** 见[通用 HTTP/Provider 错误](/guide/api-reference?id=response-errors)。如上所述，无效 HTTP 日期边界可能静默取消筛选，而非返回错误。

### GET /coin_records :id=get-coin-records

查询金币变动。参数就是[上述四个流水参数](/guide/api-reference?id=journal-parameters)，没有 `gid` 筛选。

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**响应：** `HttpResponse<CoinRecord[]>`。当前序列化包含下列所有字段，包括可空值。

| 字段 | JSON 类型 | 含义 / 解析回退值 |
| --- | --- | --- |
| `id` | 整数或 `null` | 流水条目 ID。 |
| `time` | 整数或 `null` | 交易的 Unix 毫秒时间戳。 |
| `value` | 整数 | 金币变动数额；回退值为 `0`。使用 `isDecrease` 判断方向。 |
| `isDecrease` | 布尔值 | `true` 为减少，`false` 为增加；解析器将 Provider 整数 `1` 视为 true。 |
| `totalValue` | 整数 | 操作后的金币余额；回退值为 `0`。与经验 `totalValue` 不同，此字段表示余额。 |
| `resCode` | 整数 | 金币专用原因代码；回退值为 `0`。 |
| `relatedId` | 整数或 `null` | 关联来源对象 ID；正常完成任务时为任务记录的 `id`。其他来源应结合原因代码解读。 |
| `content` | 字符串或 `null` | 变动说明。 |
| `savingBalance` | 整数或 `null` | 此操作记录的存款余额。 |

虚构示例：减少 5 金币，剩余金币余额为 95。

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**错误：** 见[通用 HTTP/Provider 错误](/guide/api-reference?id=response-errors)。如上所述，无效 HTTP 日期边界可能静默取消筛选，而非返回错误。

### 原因代码与报表合计 :id=journal-totals

原因代码的取值范围不同。部分示例：

| 原因 | 经验 `resCode` | 金币 `resCode` |
| --- | --- | --- |
| 完成任务 | `1` | `2` |
| 撤销完成任务 | `101` | `3` |
| 完成子任务 | `12` | `11` |
| 撤销子任务 | `106` | `12` |
| API 变动 | `200` | `28` |

经验原因代码全集：`0` 未知；`1` 完成任务；`2` 成就；`3` 点赞兑换；`4` 连续使用；`5` 步数兑换；`6` 设为完成；`7` 撤销放弃；`8` 撤销逾期；`9` 吃番茄；`10` 使用商品；`11` 解锁自定义成就；`12` 完成子任务；`200` API；`101` 撤销完成；`102` 放弃；`103` 逾期；`104` 使用商品扣除经验；`105` 重新锁定自定义成就；`106` 撤销子任务完成。金币原因代码与[仓库流水](#get-inventory-records)使用相同范围。保留未来未知代码。计算净变动时通过 `isDecrease` 应用方向（`true` 时减去记录数额）。不要假定减少一定表现为负数 `value`；数值类型是有符号类型，接口未声明无符号/绝对值保证。

经验 `value` 是每个属性的数额。不要盲目跨记录累计经验 `totalValue`：当前多属性分批逻辑在涉及超过三个属性时，可能保存重叠的合计。例如，四个属性各变动 10 经验，保存的合计可能分别为 40 和 10；实际合计应为 40，不能直接累加这些存储值。精确报表应结合每条记录列出的属性，核对各属性的 `value`；关联信息缺失会限制可确认的结果。不要将 `value` 与 `totalValue` 相加，也不要将经验 `totalValue` 描述为余额。

统计一个自然日时，计算本地 `dayStart` 和 `nextDayStart`，然后请求 `[dayStart, nextDayStart - 1]`，因为两个边界均包含在内。仅统计任务奖励时筛选原因代码；统计全部已记录变动时不按原因筛选。见[日报流程](/guide/api-reference?id=daily-report)。

### 实现参考 :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [日期参数传递](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt)。

## 商品与分类 :id=get-items

`GET /items` 返回 `ShopItem[]`。可重复提供查询参数 `id` 选择商品，例如 `/items?id=1&id=2`。非整数值会被丢弃；不存在的 ID 会被跳过，有效 ID 按请求顺序返回，重复 ID 也可能产生重复结果。如果提供的 ID 全部无效，SDK 不发送 ID 过滤，返回普通商品列表。本接口不分页。

`GET /items/{listId}` 返回某个**分类**下的 `ShopItem[]`，并非单件商品。`listId` 是有符号 64 位分类 ID，`-1` 表示全部；路径值无效时回退为全部。普通列表排除下架/删除商品（`isDel=0`），并按 App 配置的商店/分类排序。按商品 ID 查询可独立于普通列表过滤取得商品。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 商品 ID。 |
| `name` | 字符串 | 商品名称。 |
| `desc` | 字符串 | 描述。 |
| `icon` | 字符串 | 可读取的图片 URI，或空字符串。通过 `/files/{url}` 下载。 |
| `categoryId` | 整数 | 商店分类 ID。 |
| `stockNumber` | 整数 | 可售库存；计算 `maxPurchaseNumber` 时，负库存表示不限量。 |
| `ownNumber` | 整数 | 仓库中拥有的数量。 |
| `price` | 整数 | 金币价格。 |
| `order` | 整数 | 分类内保存的排序值。 |
| `disablePurchase` | 布尔值 | 是否禁止购买。 |
| `maxPurchaseNumber` | 整数或 null | 根据可用金币、信用额度及有限库存计算；禁止购买时为 0，免费且不限库存时可为 2147483647。此计算不检查所有购买限制规则。 |
| `titleColorString` | 字符串或 null | 自定义标题颜色。 |
| `actionText` | 字符串或 null | 自定义使用按钮文字。 |
| `unlist` | 布尔值 | 下架/删除标记；普通列表结果通常为 false。 |
| `disableUse` | 布尔值 | 是否有不可使用的效果。 |
| `purchaseLimit` | 字符串或 null | 商品购买限制配置，属于 **JSON 编码字符串**，并非嵌套数组。 |
| `limitScope` | 字符串或 null | `purchase`、`use` 或 `both`。 |

### GET /items_categories :id=get-items-categories

返回 `ShopCategory[]`。可选参数 `include_hidden` 默认为 `false`；只解析严格小写的 `true`、`false`，其他值回退为 false。结果包括虚拟的“全部”分类。HTTP 服务没有暴露 `/items_categories/{id}`。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 分类 ID。 |
| `name` | 字符串 | 分类名称。 |
| `isAsc` | 布尔值 | 配置的升序标记。 |
| `sort` | 字符串 | 保存的排序偏好。 |
| `order` | 整数 | 分类排序值。 |
| `hidden` | 布尔值 | 是否在商店中隐藏。 |
| `inventoryHidden` | 布尔值 | 是否在仓库中隐藏。 |

### GET /tasks_categories :id=get-tasks-categories

返回 `TaskCategory[]`，包括“全部”分类和已归档分类。不接受查询参数，不分页。HTTP 没有暴露 `/tasks_categories/{id}`。分类的排序/过滤值是 App 保存的偏好；本接口不会把它们作为请求过滤条件执行。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 分类 ID。 |
| `name` | 字符串 | 名称。 |
| `isAsc` | 布尔值 | 保存的升序标记。 |
| `sort` | 字符串 | 保存的排序偏好。 |
| `filter` | 字符串 | 保存的分组/过滤偏好。 |
| `order` | 整数 | 分类排序值。 |
| `status` | 整数 | 0 正常；1 已归档。 |
| `type` | 整数 | 0 普通；智能清单为 10 每日、11 每周、12 每月、20 进行中。 |

## 属性与属性分组 :id=get-skills

`GET /skills` 返回 `Skill[]`，无参数，不分页。排除隐藏/删除的属性，使用保存的排序。底层 ContentProvider 中的 `group_id`、`status` **不是** HTTP 模型字段。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 属性 ID。 |
| `name` | 字符串 | 本地化的属性名称。 |
| `desc` | 字符串 | 描述。 |
| `icon` | 字符串 | 可读取的图标 URI，或空字符串。 |
| `order` | 整数 | 保存的排序值。 |
| `color` | 整数 | Android 打包颜色整数。 |
| `exp` | 整数 | 当前总经验值。 |
| `level` | 整数 | 当前等级。 |
| `untilNextLevelExp` | 整数 | 距下一级还需的经验。 |
| `currentLevelExp` | 整数 | 从当前等级起点已获得的经验。 |
| `type` | 整数 | 0 自定义；1 力量；2 学识；3 魅力；4 耐力；5 活力；6 创造力。 |

### GET /skill_groups :id=get-skill-groups

返回 `SkillGroup[]`。`include_hidden` 与 `/items_categories` 使用相同的严格布尔解析，默认为 false。但当前 App 仓库实现忽略该分组参数，始终排除已删除的分组。按保存的排序值升序返回，不分页。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 分组 ID。 |
| `content` | 字符串 | 分组标题。 |
| `order` | 整数 | 保存的分组排序。 |
| `collapsed` | 布尔值 | 是否折叠。 |

## 成就 :id=get-achievements

`GET /achievements` 按分类顺序加载各分类成就，再拼接为 `Achievement[]`。`GET /achievements/{id}` 返回**分类 `id` 下的成就**，并非某个成就详情。路径 ID 无效时等同未过滤的集合接口。分类内部遵循 App 中该分类的排序偏好。两个接口均不分页。

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 成就 ID。 |
| `name` | 字符串 | 标题。 |
| `desc` | 字符串 | 描述。 |
| `iconUri` | 字符串 | 图标 URI，或空字符串。 |
| `categoryId` | 整数 | 分类 ID。 |
| `status` | 整数 | 0 未完成；1 已完成但未领取奖励；2 已领取奖励/其他完成状态。 |
| `exp` | 整数 | 经验奖励。 |
| `coin` | 整数 | 金币奖励。 |
| `coinVariable` | 整数 | 随机金币奖励。 |
| `type` | 整数 | 0 成就；1 子分类标题。 |
| `progress` | 整数 | 保存的进度。 |
| `order` | 整数 | 分类内排序。 |
| `itemId` | 整数或 null | 首个奖励商品 ID（旧版便捷字段）。 |
| `itemAmount` | 整数或 null | 首个奖励商品数量。 |
| `unlockedTime` | 整数或 null | 解锁时间，Unix 毫秒时间戳。 |
| `items` | RewardItem[] 或 null | 完整商品奖励列表；当前解析器在商品 JSON 缺失/无效时返回空数组。 |
| `color` | 字符串或 null | 自定义标题颜色。 |

商品奖励复用公共 [RewardItem](#reward-item) 模型。

### GET /achievement_categories :id=get-achievement-categories

返回 `AchievementCategory[]`，无参数，不分页。HTTP 服务没有暴露 `/achievement_categories/{id}`。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 分类 ID。 |
| `name` | 字符串 | 名称。 |
| `desc` | 字符串 | 描述。 |
| `iconUri` | 字符串 | 图标 URI/字符串。 |
| `isAsc` | 布尔值 | 升序标记。 |
| `sort` | 字符串 | 保存的排序偏好。 |
| `filter` | 字符串 | 保存的分组/过滤偏好。 |
| `order` | 整数 | 分类排序值。 |
| `type` | 整数 | 0 自定义成就；1 系统成就。 |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

返回**成就** ID `id` 的 `AchievementCondition[]`。ID 不是整数时返回 `code=500` 的错误封装。没有匹配条件时返回空数组。没有不带 ID 的 `/achievement_conditions` 集合接口。

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 条件 ID。 |
| `type` | 整数 | 条件代码，见下文。 |
| `relatedId` | 整数 | 按条件指向关联任务/商品/属性。 |
| `target` | 整数 | 目标值。 |
| `current` | 整数 | 当前累计值。 |
| `progress` | 整数 | 保存的进度。 |

条件代码：0 任务完成次数；1 当前任务连续完成次数；2 旧版属性等级；3 番茄数；4 App 使用天数；5 点赞数；6 连续完成天数；7 当前金币；8 单日获得金币；9 任务番茄数；10 商品购买；11 商品使用；12 开箱获得商品；13 属性等级；14 人生等级；15 累计获得商品；16 合成获得商品；17 当前拥有商品数量；18 任务专注时间；19 ATM 存款；20 外部 API。重复条件：500 任务完成；501 属性升级；502 番茄；503 金币；504 获得商品；505 购买商品；506 开箱获得商品；507 合成获得商品；508 使用商品；509 任务专注分钟数；510 任务番茄；511 点赞；512 ATM 存款增加；513 外部 API 调用；514 使用天数；515 人生升级；516 单日金币；517 连续任务完成；518 单日番茄；519 单日专注分钟数；520 单日不同任务组数量；521 单日商品使用；522 单日商品购买；523 指定任务的单日完成次数；524 单日总任务完成记录数。HTTP 返回这些整数代码，不返回枚举名称。

## 合成 :id=get-synthesis

`GET /synthesis` 返回可见分类中的 `Synthesis[]`。`GET /synthesis/{id}` 返回**分类 `id` 中的配方**，可包含该分类隐藏的内容。非负 ID 选择分类，负 ID 表示所有可见分类；无效 ID 回退为集合接口。按配方保存的排序值升序返回，排除已删除配方，不分页。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 配方 ID。 |
| `name` | 字符串 | 名称。 |
| `desc` | 字符串 | 描述。 |
| `input` | SynthesisItemInfo[] | 所需商品。 |
| `output` | SynthesisItemInfo[] | 产出商品。 |
| `categoryId` | 整数或 null | 分类 ID。 |
| `canSynthesisTimes` | 整数 | 当前可合成次数。 |

### SynthesisItemInfo :id=model-synthesis-item-info

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `itemId` | 整数 | 商品 ID。 |
| `itemName` | 字符串 | 商品名称。 |
| `amount` | 整数 | 单次合成所需/产出的数量。 |
| `ownedNumber` | 整数 | 当前拥有数量。 |
| `icon` | 字符串 | 可读取的图标 URI，或空字符串。 |

### GET /synthesis_categories 和 /synthesis_categories/{id} :id=get-synthesis-categories

两者都返回 `SynthesisCategory[]`。可选路径 `id` 按分类 ID 过滤，不改变数组结构；无效 ID 回退为全部分类。可选 `include_hidden` 使用严格小写布尔解析，默认 false，即便指定分类 ID 也同样生效。不分页。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 分类 ID。 |
| `name` | 字符串 | 名称。 |
| `isAsc` | 布尔值 | 保存的升序标记。 |
| `sort` | 字符串 | 保存的排序偏好。 |
| `order` | 整数 | 分类排序值。 |
| `hidden` | 布尔值 | 是否隐藏。 |

## 感想 :id=get-feelings

`GET /feelings` 返回 `Feelings[]`。查询参数 `offset` 默认 0，`limit` 默认 100，缺失/非整数值使用默认值；本接口没有显式钳制，请使用非负偏移和正数页大小。排除已删除感想，按 App 保存的感想排序偏好（`createTime` 升序或降序）返回，排序不能通过请求参数改变。没有时间过滤参数。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 感想 ID。 |
| `content` | 字符串 | 正文。 |
| `isFav` | 布尔值 | 是否收藏。 |
| `title` | 字符串 | 关联标题。 |
| `time` | 整数 | 创建时间，Unix 毫秒时间戳。 |
| `attachments` | 字符串数组 | 存在且非空的附件文件的可读取 URI。 |
| `type` | 整数 | 0 任务；1 成就；2 独立感想。 |

## 番茄记录 :id=get-pomodoro-records

`GET /pomodoro_records` 返回 `PomodoroRecord[]`。`offset` 默认 0、`limit` 默认 100，没有显式钳制。可选的 `time_range_start`、`time_range_end` 使用 Unix 毫秒；仅当两者都能解析为 64 位整数且开始小于结束时，SDK 才转发范围，否则静默忽略范围。

不指定范围时，返回未删除、已结束、`startTime != endTime` 且 `endTime` 为正的记录，按 `endTime DESC, startTime DESC, id DESC` 排序。有效范围查询使用 `start < endTime <= end`，并排除已删除记录。

> [!WARNING]
> 旧实现中，日期范围分支传给 DAO 的 `limit`、`offset` 位置颠倒，且没有指定排序。本地人升源码已改为具名传参，并将分页结果按 `endTime DESC, startTime DESC, id DESC` 排序；此本地修复尚未发布。在确认已安装的人升版本包含修复前，需要可靠分页时请不传范围，取得记录后在客户端按时间过滤。

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 记录 ID。 |
| `startTime` | 整数或 null | 开始时间，Unix 毫秒。 |
| `endTime` | 整数或 null | 结束时间，Unix 毫秒。 |
| `duration` | 整数 | 毫秒时长：使用保存的非零 `lastTime`，否则为结束减开始。 |
| `reward` | 数值 | 获得番茄数：放弃为 0；半个为 0.5 × 倍率；其他为倍率。 |

## 仓库流水 :id=get-inventory-records

`GET /inventory_records` 返回 `InventoryRecord[]`。`offset` 默认 0，钳制为至少 0；`limit` 默认 100，钳制为 1–200。可选 `time_range_start`、`time_range_end` 仅在都可解析为 64 位整数且开始小于结束时转发，无效/不完整范围被 SDK 静默忽略。有效范围包含两端：`time >= start AND time <= end`。排除已删除记录（`isDel` 为 null 或 0），按 `time DESC, id DESC` 排序。没有按商品 ID 过滤的参数。

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 记录 ID。 |
| `time` | 整数或 null | 创建时间，Unix 毫秒。 |
| `itemId` | 整数或 null | 关联商品 ID。 |
| `itemName` | 字符串或 null | 可用时的关联商品名称。 |
| `changeNumber` | 整数 | 记录的数量变化。 |
| `isDecrease` | 布尔值 | 此次变化是否减少仓库数量。 |
| `resCode` | 整数 | 来源原因代码，见下文。 |
| `desc` | 字符串或 null | 记录描述。 |

原因代码：0 购买；1 使用；2 完成任务；3 撤销完成；4 清除数据；5 放弃任务；6 任务逾期；7 解锁内置成就；8 撤销放弃；9 撤销逾期；10 退货；11 完成子任务；12 撤销子任务完成；13 解锁自定义成就；14 撤销自定义成就解锁；15 存款；16 取款；17 出售番茄；20 奖励商品；21 撤销奖励；23 合成；24 开箱；25 ATM 利息；26 番茄兑换商品；27 信用利息；28 API；29 商品效果变更库存。客户端应保留未来未知代码。

## 步数记录 :id=get-step-records

`GET /step_records` 返回 `StepRecord[]`。分页默认值/钳制和 SDK 忽略无效范围的规则与 `/inventory_records` 相同。有效时间范围按 `date` 过滤，包含两端；按 `date DESC` 排序，没有显式的第二排序键。

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 记录 ID。 |
| `date` | 整数或 null | 记录日期，Unix 毫秒。 |
| `dailyStepCount` | 整数 | 当日步数。 |
| `totalStepCount` | 整数 | 保存的累计步数。 |
| `isGotReward` | 布尔值 | 是否已领取奖励。 |
| `isUserInput` | 布尔值 | 是否由用户输入。 |
| `rewardLevel` | 整数或 null | 保存的奖励等级。 |

## 等级定义 :id=get-level-defines

`GET /level_defines` 返回单个 `LevelDefines` 对象，无参数。启用自定义等级模式时使用自定义定义，否则使用内置定义。

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `custom` | 布尔值 | 是否为自定义等级模式。 |
| `levels` | LevelDefine[] | 等级区间列表。 |

### LevelDefine :id=model-level-define

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数或 null | 定义 ID。 |
| `levelStart` | 整数 | 起始等级。 |
| `levelEnd` | 整数 | 结束等级。 |
| `perLevelExp` | 整数 | 区间内每一级所需经验。 |

等级 JSON 格式错误时，当前实现返回空的 `levels` 数组，不会使整个请求失败。

## 统计 :id=get-statistics

`GET /statistics` 返回单个 `Statistics` 对象。可选 `time_range_start`、`time_range_end` 使用 Unix 毫秒，遵循相同的 SDK 转发规则：两者都有效且开始小于结束，否则不传范围。未指定范围时，App 使用首次记录时间至今；没有首次记录时使用最近 30 天。即使指定范围，`usingDays`、`companionDays` 仍为整个使用期间的累计值。其他指标由各自的 App 统计方法计算，不应假设所有底层指标查询都使用相同的边界包含规则。

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `start` | 整数或 null | 实际范围起点，Unix 毫秒。 |
| `end` | 整数或 null | 实际范围终点，Unix 毫秒。 |
| `tomatoes` | 整数 | 获得番茄数统计。 |
| `pomodoroMinutes` | 整数 | 专注分钟数。 |
| `focusCount` | 整数 | 专注会话次数。 |
| `tasksCompleted` | 整数 | 完成率统计所使用的已完成任务数。 |
| `tasksTotal` | 整数 | 该统计所使用的总任务数。 |
| `taskCompleteRate` | 数值 | 完成比例。 |
| `feelingsCount` | 整数 | 感想数量。 |
| `usingDays` | 整数 | 累计使用天数。 |
| `companionDays` | 整数 | 累计陪伴天数。 |
| `interestChanged` | 整数 | 利息金币变化统计。 |
| `coinPurchaseConsumed` | 整数 | 购买消耗金币统计。 |

## 应用信息与金币余额 :id=get-info

`GET /info` 返回 `Info`。云人升在 App/Provider 信息上补充自身已安装版本，无参数。

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `appVersion` | 整数 | 已安装人升的版本代码。 |
| `appVersionName` | 字符串 | 已安装人升的版本名称。 |
| `apiVersion` | 整数 | 人升 API 版本。 |
| `cloudVersion` | 整数 | 已安装云人升的版本代码。 |
| `cloudVersionName` | 字符串 | 已安装云人升的版本名称。 |

### GET /coin :id=get-coin

通过 ContentProvider 调用 `lifeup://api/query?key=coin` 并返回其结果对象，无参数。Provider 返回 null 时转换为空对象。字段由 Provider 定义，并非类型固定的 `CoinData` 响应。成功查询包含 `value`（有符号 64 位整数金币余额）、`api_result: true`；失败可返回下述 Provider 状态/错误字段。

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## 调用 URL Scheme API :id=invoke-api

[URL Scheme API 清单](/guide/api) 定义各业务方法的名称、参数和具体结果。HTTP 桥接接口接受完整的 `lifeup://api/...` URL。

| 调用方式 | 输入 | 执行与响应 |
| --- | --- | --- |
| `GET /api` | 重复的 URL 编码查询参数 `url` | 按给定顺序为每个 URL 启动 Android Activity；返回字符串 `success`。没有 URL 时也返回成功。 |
| `POST /api` | JSON `RawQueryVo` | 先处理所有 `urls`，再处理存在的 `url`；返回字符串 `success`。空输入对象也成功。 |
| `GET /api/contentprovider` | 重复的 URL 编码查询参数 `url` | 同步调用 Provider，按给定顺序返回 `CallUrlResult[]`。缺少 URL 返回错误封装（`No url found`）。 |
| `POST /api/contentprovider` | JSON `RawQueryVo` | 先调用所有 `urls`，再调用 `url`；返回 `CallUrlResult[]`。空对象返回空数组。 |

JSON POST 请求设置 `Content-Type: application/json`。URL 嵌入 GET 查询时，应对整个 URL 编码，保留其内部 `&`、`?`、`+` 和百分号编码的含义。Activity 桥接成功只表示已派发，不表示业务动作已完成。ContentProvider 方法需要云人升获得人升中的权限，支持情况取决于具体 URL Scheme 方法。调用按顺序执行；后续调用抛错时，之前的效果不会回滚。

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity 桥接响应：

```json
{"code":200,"message":"success","data":"success"}
```

Provider 桥接响应（结果示例）：

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `url` | 字符串或 null | 可选的单个 URL。 |
| `urls` | 字符串数组或 null | 可选的 URL 列表；先于 `url` 处理。 |

### CallUrlResult :id=model-call-url-result

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `url` | 字符串 | 提交的 URL。 |
| `result` | 对象或 null | 转换后的 Provider Bundle；null 本身不会使 HTTP 封装失败。 |

Bundle 转换保留 Int/Long/Double/String/Boolean 值和嵌套 Bundle。数组转换为字符串数组，其他类型转换为其 `toString()` 字符串（包括 Bundle 中的 null 值变为字符串 `"null"`）。即使外层 `code=200`，也必须检查 `result` 内的方法失败字段。

当前人升方法处理器会为完成的调用加入 `api_result`（布尔值）。捕获的方法失败包含 `api_result: false`、`error_code`（字符串）、`error_message`（字符串）。错误代码包括 `missing_required_parameter`、`invalid_parameter`、`entity_not_found`、`invalid_format`、`unsupported_api`、`cancelled`、`internal_error`；具体方法还可能有其他代码。备份恢复期间，Provider 可以返回 `error_code: "503"` 和 `error_message`，却没有 `api_result`。缺少方法处理器时，异常可能在这种方法错误转换前抛出，转而产生外层桥接错误。

## 文件读取与上传 :id=files-download

### GET /files/{url} :id=files-get

将完整的可读取 URI 编码为单个路径片段。接口通过 Android 内容解析器读取字节，通常用于图标、感想附件、导出备份或上传文件。成功结果是字节流，不是 JSON 封装；接口没有指定文件名或 MIME 类型。解析器返回空/不可读的流时，不会转换为结构化的“未找到”结果；抛出的错误由全局 HTTP 500 处理。匹配到空参数时返回错误封装（`url is required`）。

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

发送 `multipart/form-data`。接受所有文件部分，不检查字段名；忽略非文件表单部分。每个原始文件名用于缓存文件，没有名称时使用 `uploaded_image_<time>.jpg`。返回可读取的 content URI 字符串数组。上传只是为后续 API 调用提供文件 URI，不会自动附加到任务或商品。没有文件时返回包含 `No files received` 的错误封装。

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## 备份导出与导入 :id=files-backup

### GET /data/export :id=files-export

通过 Provider 创建备份。可选查询参数 `withMedia` 默认 `true`；提供参数时，不区分大小写的 `true` 表示 true，其他值均为 false。返回转换后的 Provider Bundle，目前包含 `backup_file_uri`，可用 `/files/{url}` 下载该 URI。**虽然 HTTP 方法为 GET，调用仍会创建导出文件。** 结果还可能包含 Provider API 状态/错误字段，必须检查。空的 `backup_file_uri` 表示没有产生可用文件；null 结果转换为错误。

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

通过 `multipart/form-data` 发送备份文件。存在多个文件部分时，最后一个生效，不检查字段名。默认文件名为 `backup.lfbak`。可选表单字段 `description` 会被读取，但不产生效果。云人升缓存文件后启动人升的备份 Activity；响应仅确认上传及 Activity 启动，**不表示恢复完成**。没有文件时返回 `No file received`。

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## 事件 :id=get-events

### GET /events :id=get-events-poll

返回 `EventsPage`。`after` 是排他的事件 ID 游标（64 位整数，默认 0）；`limit` 为整数，默认 50，钳制到 1–200；非整数使用默认值。从保留的缓冲区返回 `id > after` 的事件，按最早在前排列。内存最多保留 200 条事件，旧事件会丢弃，进程重启后 ID 重置。`latestId` 是全局最新可用 ID，不一定等于受页大小限制后本页的最后一条。继续读取时应使用最后实际处理的事件 ID，避免跳过积压事件。不提供持久历史或投递确认。

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `latestId` | 整数 | 当前最新事件 ID。 |
| `eventWs` | 布尔值 | 云人升的 WebSocket 设置。 |
| `events` | CloudEvent[] | 游标之后仍被保留的事件。 |
| `broadcasts` | 布尔值或 null | 人升是否启用了广播；null 表示未知或不支持。查询状态缓存五秒。 |

### CloudEvent :id=model-cloud-event

| 字段 | JSON 类型 | 含义 |
| --- | --- | --- |
| `id` | 整数 | 内存事件序号。 |
| `time` | 整数 | 云人升收到事件时的 Unix 毫秒时间。 |
| `action` | 字符串 | Android 广播 action。 |
| `extras` | 值为字符串的对象 | 广播附加值经 `toString()` 转换；null 变为空字符串。键由具体 action 决定。 |

### WebSocket /events :id=get-events-websocket

`eventWs` 为 true 时，可连接 `ws://HOST:PORT/events?after=ID`，并提供配置的令牌。服务端先重放 `after` 后仍被保留的事件，再逐条推送实时事件；每个文本帧是 JSON `CloudEvent`，**没有 HTTP 响应封装**。重放受内存中 200 条记录限制；WebSocket 没有 `limit` 参数。服务端每 30 秒发送 Ping 帧。重连使用最后实际处理的事件 ID。关闭该设置时，不注册 WebSocket 路由，但 HTTP 轮询仍可用。

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

支持订阅的 action：`app.lifeup.task.complete`、`app.lifeup.task.overdue`、`app.lifeup.task.giveup`、`app.lifeup.achievement.unlock`、`app.lifeup.achievement.condition.unlock`、`app.lifeup.item.purchase`、`app.lifeup.item.reward`、`app.lifeup.item.use`、`app.lifeup.synthesis.complete`、`app.lifeup.pomodoro.start`、`app.lifeup.pomodoro.pause`、`app.lifeup.pomodoro.complete`、`app.lifeup.pomodoro.stop`、`app.lifeup.feelings.add`、`app.lifeup.level.up`、`app.lifeup.level.down`、`app.lifeup.item.countdown.start`、`app.lifeup.item.countdown.complete`、`app.lifeup.item.countdown.stop`、`app.lifeup.timing.start`、`app.lifeup.timing.complete`、`app.lifeup.timing.pause`、`app.lifeup.timing.abandon`。采集事件需要人升启用广播。轮询 `/events` 会查询该设置，不会自动启用广播。

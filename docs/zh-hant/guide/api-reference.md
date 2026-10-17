# HTTP API 參考 :id=http-query-reference

本頁列出雲人升的請求參數與完整 HTTP 回應模型。安裝、授權及連線方式請先閱讀[雲人升](/guide/api_cloud)。較新的流水介面需要人升 **1.106.0+** 與雲人升 **3.0.0+**，可用 `/info` 確認已安裝版本。本參考描述目前原始碼契約，不代表特定版本已可取得。

## 介面索引 :id=interface-index

| 資源 | 方法與路徑 | 參數與模型 |
| --- | --- | --- |
| 共用規則 | JSON 回應、授權、快取條件、分頁 | [規則](#representations)、[快取與授權](#auth-cache)、[分頁](#pagination) |
| 任務 | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [查詢](#get-tasks)、[任務模型](#task-fields)、[分類](#get-tasks-categories) |
| 任務歷史 | `GET /history` | [參數](#get-history)、[時間戳記](#task-times)、[日報](#daily-report) |
| 商品 | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [商品 ID、分類 ID 與完整模型](#get-items) |
| 屬性 | `GET /skills`, `GET /skill_groups` | [屬性與群組](#get-skills) |
| 成就 | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [成就與條件](#get-achievements) |
| 合成 | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [配方與分類](#get-synthesis) |
| 感想 | `GET /feelings` | [感想分頁](#get-feelings) |
| 經驗值／金幣 | `GET /exp_records`, `GET /coin_records` | [流水參數與模型](#reward-journals) |
| 其他紀錄 | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [番茄鐘](#get-pomodoro-records)、[倉庫](#get-inventory-records)、[步數](#get-step-records) |
| 等級／統計 | `GET /level_defines`, `GET /statistics` | [等級](#get-level-defines)、[統計](#get-statistics) |
| App／餘額 | `GET /info`, `GET /coin` | [版本資訊](#get-info)、[金幣結果](#get-coin) |
| 呼叫動作 | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [呼叫橋接](#invoke-api)；業務方法見 [URL Scheme 目錄](/guide/api) |
| 檔案／備份 | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [檔案](#files-download)、[備份傳輸](#files-backup) |
| 事件 | `GET /events`, WebSocket `/events` | [輪詢與即時事件](#get-events) |
| 首頁 | `GET /` | HTML 簡介，非 JSON 資源。 |

MCP 使用獨立的用戶端／工具表示方式，見 [MCP 差異](#mcp-differences)與 [MCP 指南](/guide/api_mcp)。

## 傳輸方式與資料表示 :id=representations

| 介面 | 資料表示 | 注意事項 |
| --- | --- | --- |
| Cloud HTTP 查詢 | 以 `{code, message, data}` 包裝的 JSON | 下列介面參考描述的是這一層公開 JSON。 |
| Android ContentProvider | Cursor 欄位，如 `_ID` / `_GID`；部分欄位包含 JSON 文字 | SDK 將其轉為 `id` / `gid` 等 HTTP 欄位及巢狀陣列。不可將 Cursor 欄位定義當成 HTTP 結構。 |
| URL Scheme 動作 | `lifeup://api/{method}` 及各方法的參數/結果 | 即使 HTTP 讀取欄位使用 camelCase，寫入參數也可能使用 snake_case。 |
| MCP 列表工具 | 工具專用的包裝，以及精簡或完整紀錄 | MCP 分頁及輸出欄位屬於額外的用戶端行為，不是 HTTP 回應欄位。 |

## 回應與錯誤 :id=response-errors

HTTP JSON 共用 `HttpResponse<T>` 包裝：

| 欄位 | 型別 | 含義 |
| --- | --- | --- |
| `code` | 整數 | 查詢成功時為 `200`，其他值表示錯誤。這是本文欄位，與 HTTP 狀態分開。 |
| `message` | 字串 | 成功時通常為 `success`，錯誤時為錯誤說明。 |
| `data` | `T` 或 `null` | 成功時為各介面指定的值（陣列、物件或字串），錯誤時為 `null`。 |

成功回傳空列表的範例：

```json
{"code":200,"message":"success","data":[]}
```

權限或 Provider 存取錯誤的示例：

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| 訊號 | 處理方式 |
| --- | --- |
| HTTP `401` | 將 Cloud 設定的 token 原樣放入 `Authorization` 標頭，不加上 `Bearer`。 |
| 本文 `code = 10001` | 檢查人升是否已安裝並執行，以及雲人升是否取得「讀取人升資料」權限。 |
| 本文 `code = 10002` | ContentProvider 查詢失敗，請查看錯誤說明。 |
| 其他非成功狀態或代碼 | 視為查詢失敗，而非空結果。 |

需要**同時**檢查 HTTP 狀態及本文 `code`。部分路由失敗時仍回傳 HTTP `200`，錯誤會出現在本文代碼中。透過 `/api/contentprovider` 執行動作時，還需檢查每一項的 `data[].result.api_result`；外層 `code=200` 不能證明每個動作都成功。

## 授權與條件式讀取 :id=auth-cache

設定 Cloud token 後，請在 `Authorization` 傳送完全相符的原始值，不要加 `Bearer`。伺服器也接受 `token` 查詢參數，可供無法設定 WebSocket 標頭的用戶端使用。缺漏或錯誤 token 會回傳 HTTP `401` 與本文 `code=401`。此檢查涵蓋首頁、資源、橋接、檔案、備份傳輸及事件。

成功的 JSON 資源讀取會附上強式 SHA-256 `ETag` 及 `Cache-Control: private, no-cache`，適用任務／歷史、商品／分類、屬性／群組、成就／條件、感想、合成／分類、流水、等級、統計、資訊及金幣資源；不適用呼叫橋接、檔案傳輸、備份傳輸或事件串流／輪詢。

| 請求標頭 | 目前回應行為 |
| --- | --- |
| `If-Match` | 版本不符合時回傳 HTTP `412`；先於 `If-None-Match` 評估。 |
| `If-None-Match` | 版本符合時回傳 HTTP `304`，沒有可解析的 JSON 本文；請重用已快取的成功表示。 |

錯誤包裝沒有資源版本標頭。條件式讀取只適用單次資源請求，不代表跨分頁或路徑的快照／交易。

跨來源瀏覽器請求可使用 `If-None-Match`。目前 CORS 預檢未允許 `If-Match`，未修改實作前請勿依賴跨來源瀏覽器 `If-Match`。原生用戶端不受瀏覽器 CORS 限制。

## 共用資料約定 :id=data-conventions

| 約定 | 規則 |
| --- | --- |
| 時間 | 時間戳記欄位使用 Unix 毫秒時間戳記。曆日邊界取決於目標時區，各欄位仍有各自的資源含義。 |
| 識別 | 任務 `id` 識別單一任務/週期，任務 `gid` 識別跨重複週期的任務群組。分類/清單 ID 識別另一種資源。 |
| 空值 | 欄位缺失、`null`、`0`、`""` 及 `[]` 含義不同。各模型分別說明實際的預設或省略行為。 |
| 數值 ID | ID 可以是帶正負號的 64 位元整數，JavaScript Number 無法精確表示所有值；請用合適的 JSON 解析器保留大型 ID。 |
| 陣列與物件 | HTTP 中的 `items`、`subTasks` 等巢狀值是陣列，不是編碼後的 JSON 字串。 |
| 狀態與原因代碼 | 使用對應資源的列舉值。任務狀態、成就狀態及流水原因代碼屬於不同範圍。 |

`startTime`、`deadline` 及 `endTime` 的定義見[任務時間欄位](/guide/api-reference?id=task-times)。

## 分頁與篩選 :id=pagination

分頁是介面能力，並非所有列表都支援。原始 HTTP 列表回應使用 `data: [...]`，**不會**額外回傳 `total`、`count` 或 `hasMore`。

| HTTP 介面 | 分頁 | 日期範圍 | 其他篩選 |
| --- | --- | --- | --- |
| `/tasks`、`/tasks/{categoryId}` | 不分頁，回傳完整陣列 | 不支援 | 路徑中的選填分類 |
| `/history` | 伺服器端 `offset` / `limit` | 不支援 | 選填 `gid` |
| `/feelings` | 伺服器端 `offset` / `limit` | 不支援 | 見[感想](#get-feelings) |
| `/pomodoro_records`、`/coin_records`、`/inventory_records`、`/exp_records`、`/step_records` | 伺服器端 `offset` / `limit` | `time_range_start` / `time_range_end` | 見各介面 |
| `/statistics` | 不分頁，回傳單一物件 | `time_range_start` / `time_range_end` | 彙總查詢 |
| `/coin`、`/info` | 不分頁，回傳單一物件 | 不支援 | 單一物件查詢 |

支援分頁的介面在 HTTP 層預設 `offset=0`、`limit=100`。共用分頁迴圈請使用非負偏移量，以及 `1..100` 的每頁筆數。HTTP 橋接不會套用 MCP 的 `1..100` 限制，而下游 Provider 可能施加其他限制；請查閱各介面的實際每頁筆數及驗證說明。

除了[時間篩選的番茄鐘限制](#get-pomodoro-records)，每頁成功後，將 `offset` 增加實際回傳筆數。筆數小於有效頁面大小時停止（使用 `1..100` 時為要求的 `limit`，但不含時間篩選番茄鐘）。不要把 Provider 限制後的頁面誤認為最後一頁。超出末端的空頁是正常結果。多頁查詢不會建立快照，查詢期間紀錄可能改變。

目前 HTTP SDK 僅在日期邊界**皆可解析為整數且 `start < end`** 時向下傳遞篩選條件。只提供單邊、無法解析或順序顛倒的邊界，會導致不帶日期篩選的查詢，不能依賴錯誤回應來發現問題。傳送前應自行驗證兩個邊界。流水參考頁說明對應介面的邊界包含規則。

## MCP 的差異 :id=mcp-differences

MCP 列表工具預設 `limit=20`，將其限制在 `1..100`，並將 `offset` 限制為至少 `0`。歷史、流水等資源由伺服器分頁；任務等資源則先讀取完整 HTTP 陣列，再於用戶端擷取。`items`、`count`、`hasMore` 及選填的 `total` 屬於 MCP 包裝。`detail=false` 也會移除每筆紀錄中的部分欄位；需要完整 HTTP 模型時使用 `detail=true`。

## 來源與版本範圍 :id=api-common-sources

本參考描述目前公開 SDK 及對應的人升 Provider 行為，範例使用虛構資料。原始碼連結用於核對實作，不能證明某個已安裝版本具備全部欄位：[HTTP 路由](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)、[HTTP 包裝](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt)、[MCP 查詢對應](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts)。

## 任務與歷史資料模型 :id=task-history-models

本頁定義[任務與歷史查詢](/guide/api-reference?id=task-queries)回傳的 **HTTP JSON**。Android Cursor 欄位和 URL Scheme 動作參數可能採用不同名稱及表示方式，見[共用約定](/guide/api-reference?id=representations)。

SDK 使用同一個序列化 `Task` 類別提供兩種檢視。本頁以 `Task` 表示 `/tasks` 檢視，以 `HistoryRecord` 表示 `/history` 檢視。這些名稱僅描述現有輸出，並未引入新 API。目前 Cloud 序列化會包含預設值和 `null` 欄位。

### Task / HistoryRecord 欄位 :id=task-fields

下列所有欄位都會出現在目前的 HTTP 物件中。Provider 缺失的值通常會轉為表中的替代值；出現替代值並不能證明來源資料原本包含該值。

| 欄位 | JSON 型別 | 含義 / 替代值 |
| --- | --- | --- |
| `id` | 整數或 `null` | 此任務/週期的 ID。 |
| `gid` | 整數或 `null` | 重複週期共用的任務群組 ID。 |
| `name` | 字串 | 任務名稱。Provider 缺少名稱時改為 `ERROR: name is null`。 |
| `notes` | 字串 | 備註；缺失時為空字串。 |
| `status` | 整數 | 任務狀態；缺失時預設為 `0`。見下方狀態表。 |
| `startTime` | 整數 | 設定的開始時間，單位為毫秒；SDK 替代值為 `0`。 |
| `deadline` | 整數 | 截止時間，單位為毫秒；缺失時 SDK 替代值為 `0`。 |
| `remindTime` | 整數 | 提醒時間，單位為毫秒；缺失時 SDK 替代值為 `0`。 |
| `frequency` | 整數 | 重複代碼；`0` 為單次，`1` 為每天，`-1` 為無限。其他重複模式見[任務動作](/guide/api)。SDK 替代值為 `0`。 |
| `weekdays` | 字串 | 選取的星期，如 `1,3,5`（週一為 `1`，週日為 `7`）；未提供時為空，歷史檢視固定以空值佔位。 |
| `exp` | 整數 | 設定的經驗獎勵，並非流水數額；預設為 `0`。 |
| `skillIds` | 整數陣列 | 獎勵關聯的屬性；無法取得時為空陣列。 |
| `coin` | 整數 | 設定的金幣獎勵；預設為 `0`。 |
| `coinVariable` | 整數 | 隨機金幣獎勵設定；預設為 `0`。 |
| `itemId` | 整數 | 舊版的第一個獎勵物品 ID；預設為 `0`。完整列表請使用 `items`。 |
| `itemAmount` | 整數 | 舊版的第一個獎勵物品數量；預設為 `0`。此 HTTP 欄位名稱與 Provider 的 `itemCount` 欄位不同。 |
| `words` | 字串 | 完成激勵語；缺失時為空。 |
| `categoryId` | 整數 | 任務分類/清單 ID；缺失時預設為 `0`。 |
| `order` | 整數 | 任務列表排序值；歷史 Provider 不回傳此欄，因此歷史檢視固定以 `0` 佔位。 |
| `nameExtended` | 字串 | 延伸顯示名稱；歷史 Provider 不回傳此欄，因此歷史檢視固定以空字串佔位。 |
| `endTime` | 整數 | 歷史紀錄中儲存的結束時間。`/tasks` 將此欄位填為 `0`，見[時間語義](/guide/api-reference?id=task-times)。 |
| `items` | `RewardItem[]` | 物品獎勵；無法取得時為空陣列。 |
| `subTasks` | `SubTask[]` | 巢狀子任務；無法取得時為空陣列。 |
| `countProgress` | `TaskCountProgress` 或 `null` | 可取得時的計數進度快照；兩種檢視均可能包含。 |
| `repeatEndCondition` | `TaskRepeatEndCondition` 或 `null` | `/tasks` 中的重複結束規則；`/history` 中一律為 `null`。 |

### 任務狀態與時間戳記 :id=task-times

| `status` | 含義 | 歷史 `endTime` 的含義 |
| --- | --- | --- |
| `0` | 未完成 | 不代表完成時間；`/history` 查詢的是已結束紀錄。 |
| `1` | 已完成 | 記錄的完成時間。 |
| `2` | 已逾期 | 記錄的逾期時間。 |
| `3` | 已放棄 | 記錄的放棄時間。 |

| 時間欄位 | 定義 |
| --- | --- |
| `startTime` | 任務設定/排定的開始時間，並非使用者實際開始進行任務的時間。 |
| `deadline` | 排定的截止時間，與記錄的結束時間不同。 |
| `endTime` | 歷史任務記錄的結束時間；依上表搭配 `status` 解讀。 |

三者均使用 Unix 毫秒時間戳記。正常完成任務時，App 記錄當下時間。`history_operation` 的 `operation=edit_completed_time` 接受 `completed_time` 輸入，修改同一個已儲存的完成時間；讀取歷史時欄位名稱仍為 `endTime`。

已儲存的時間可以編輯。已結束紀錄若未儲存結束日期，App 會改用當下時間。因此，`endTime` 表示目前記錄的時間，並非不可變的稽核時間戳記。`/tasks` 中的 `0` 僅為 SDK 佔位值，並非真的在 Unix 紀元發生事件。

### RewardItem :id=reward-item

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `itemId` | 整數 | 獎勵物品 ID。 |
| `itemCount` | 整數 | 獎勵數量。 |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| 欄位 | JSON 型別 | 含義 / 預設值 |
| --- | --- | --- |
| `id` | 整數 | 子任務 ID。 |
| `gid` | 整數 | 子任務群組 ID。 |
| `todo` | 字串 | 子任務文字。 |
| `status` | 整數 | `0` 未完成，`1` 已完成。 |
| `remindTime` | 整數或 `null` | 提醒時間戳記，單位為毫秒；無法取得時為 `null`。 |
| `endTime` | 整數或 `null` | 子任務完成時間戳記，單位為毫秒；無法取得時為 `null`。 |
| `exp` | 整數 | 設定的經驗獎勵。 |
| `coin` | 整數或 `null` | 設定的金幣獎勵。 |
| `coinVariable` | 整數或 `null` | 隨機金幣獎勵設定。 |
| `items` | `RewardItem[]` | 物品獎勵；預設為空陣列。 |
| `order` | 整數或 `null` | 排序值；模型預設值為 `0`。 |
| `autoUseItem` | 布林值或 `null` | 是否自動使用獎勵；模型預設值為 `false`。 |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `currentCount` | 整數 | 此任務/週期的目前計數。 |
| `targetCount` | 整數 | 此任務/週期的目標計數。 |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| 欄位 | JSON 型別 | 含義 / 預設值 |
| --- | --- | --- |
| `mode` | 字串 | `COUNT` 或 `DATE`。這些是讀取結果中的字串，不是動作參數中的數值。 |
| `behavior` | 字串 | `TERMINATE` 或 `FREEZE`。 |
| `targetCycleCount` | 整數或 `null` | `COUNT` 模式的週期次數目標；預設為 `null`。 |
| `endDateMillis` | 整數或 `null` | `DATE` 模式的結束日期毫秒時間戳記；預設為 `null`。 |
| `inclusive` | 布林值 | 是否包含結束日期；預設為 `false`。 |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### 獎勵數額 :id=reward-amounts

這些任務及子任務欄位描述設定的獎勵。倍率、隨機金幣及結算規則可能改變實際發放數額。實際變動請查詢[經驗與金幣流水](/guide/api-reference?id=reward-journals)，並區分正向獎勵與包含撤銷、懲罰的淨變動。

### 實作參考 :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [解析器](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [計數進度](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [重複規則](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt)。

## 任務與歷史查詢 :id=task-queries

請先閱讀[共用約定](/guide/api-reference?id=http-query-reference)和[完整的 Task/History 模型](/guide/api-reference?id=task-history-models)。這些介面需要雲人升的「讀取人升資料」權限。基礎列表查詢要求人升 v1.91+ 和最新版雲人升；範例描述目前 SDK 的欄位。串接較舊的安裝版本時請檢查 `/info`。

### GET /tasks 與 /tasks/{categoryId} :id=get-tasks

查詢目前的**未完成**任務列表，可選擇依分類/清單限制範圍。結果為完整陣列，並非伺服器分頁回應。已完成、已逾期和已放棄紀錄歸入 `/history`。

| 參數 | 位置 | 型別 | 必填 | 預設值 / 行為 |
| --- | --- | --- | --- | --- |
| `categoryId` | 路徑 | 整數 | 僅 `/tasks/{categoryId}` 需要 | 查詢不限分類的任務列表時，省略整個路徑區段。 |

這些路由不支援 `offset`、`limit`、`gid` 或日期範圍查詢參數。目前實作會將非整數的分類路徑區段解析為未指定分類；請在請求前驗證，以免意外查詢全部任務。

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**回應：** `HttpResponse<Task[]>`。所有紀錄欄位及巢狀結構見 [Task/History 欄位](/guide/api-reference?id=task-fields)。下列虛構紀錄展示完整的 HTTP 頂層結構；此路由的 `endTime=0` 是佔位值，並非完成時間戳記。

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**行為與錯誤：** 列表選取及排序遵循人升任務列表邏輯；此介面不保證依完成時間排序。成功的 `data: []` 表示選定的任務列表未回傳紀錄。權限/Provider 失敗採用[共用錯誤包裝](/guide/api-reference?id=response-errors)，不屬於空陣列。統計完成情況時應使用下方的 `/history`，而非此路由的 `endTime`。

### GET /history :id=get-history

查詢可見的已結束任務紀錄，包含已完成、已逾期和已放棄的任務，排除已刪除的歷史紀錄。

| 參數 | 位置 | 型別 | 必填 | 預設值 / 行為 |
| --- | --- | --- | --- | --- |
| `offset` | 查詢 | 整數 | 否 | `0`；略過的紀錄數，從零開始。 |
| `limit` | 查詢 | 整數 | 否 | `100`；請求的每頁筆數應為正數，建議 `1..100`。 |
| `gid` | 查詢 | 整數 | 否 | 預設不依群組篩選；提供時選取該任務群組跨週期的紀錄。 |

HTTP 解析器會將無法解析的 `offset` / `limit` 改用 `0` / `100`，忽略無法解析的 `gid`。此路由不會限制已解析數值的範圍。請自行驗證偏移量非負、每頁筆數為正。**不支援** `time_range_start` / `time_range_end`，提供它們不會篩選歷史紀錄。

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**回應：** `HttpResponse<HistoryRecord[]>`，採用 [Task/History 傳輸欄位](/guide/api-reference?id=task-fields)。`HistoryRecord` 是本說明對 SDK `Task` 模型歷史檢視的稱呼。此檢視中 `repeatEndCondition` 為 `null`，`countProgress` 可能有值。儲存的 `endTime` 需搭配 `status` 解讀。

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**排序：** 依儲存的結束日期降序，最新紀錄在前。結束日期相同時，沒有文件約定的次級排序。分頁並非快照；收集報表期間應避免編輯資料，合併多頁時依 `id` 去除重複紀錄。

**分頁與空結果：** 採用[共用分頁流程](/guide/api-reference?id=pagination)。成功的空陣列表示目前頁面/群組沒有符合條件的可見紀錄，也包括 `offset` 超過末尾的情況。這不能證明從未發生活動：已刪除紀錄會被排除，介面也沒有完整性旗標。任何請求失敗時，應回報資料無法取得/不完整，而非零任務。適用[共用錯誤說明](/guide/api-reference?id=response-errors)。

### 產生日報 :id=daily-report

1. 決定報表時區。計算該曆日的開始時間（`dayStart`）和下一個曆日的開始時間（`nextDayStart`）。不要假設每個本地曆日都恰好為 24 小時。
2. 以 `offset=0&limit=100` 讀取 `/history`，檢查每次回應並收集所有分頁。若需要 `gid` 篩選，應在各頁保持一致。
3. 篩選 `status == 1` 且 `dayStart <= endTime < nextDayStart` 的紀錄。描述結果時遵守[記錄時間的限制](/guide/api-reference?id=task-times)。
4. 實際經驗與金幣變動應讀取同一天的[獎勵流水](/guide/api-reference?id=reward-journals)。流水日期篩選包含兩端，因此使用 `time_range_start=dayStart` 和 `time_range_end=nextDayStart-1`。
5. 區分「可用資料中未找到紀錄」與讀取失敗/未完成。決定報表僅統計正向獎勵，或包含撤銷的淨變動，並一律保持一致。

任務/歷史中的 `exp` 和 `coin` 是設定的獎勵，無法可靠地替代流水數額。將完成時間改為另一天，不代表獎勵流水的交易時間也隨之移動。

### 實作參考 :id=api-task-queries-sources

[HTTP 路由](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [任務與歷史解析](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt)。

## 經驗與金幣流水查詢 :id=reward-journals

這些唯讀 HTTP 介面需要「讀取人升資料」權限、人升 **1.106.0+** 和雲人升 **3.0.0+**。回傳的是已記錄的變動，包括減少及撤銷，而非任務獎勵設定。請先閱讀[共用約定](/guide/api-reference?id=http-query-reference)。

### 兩個介面的請求參數 :id=journal-parameters

以下約定同時適用於 `GET /exp_records` 和 `GET /coin_records`。

| 參數 | 位置 | 型別 | 必填 | 預設值 / 實際行為 |
| --- | --- | --- | --- | --- |
| `offset` | 查詢 | 整數 | 否 | HTTP 預設值為 `0`；Provider 將負值限制為 `0`。 |
| `limit` | 查詢 | 整數 | 否 | HTTP 預設值為 `100`；Provider 限制為 `1..200`。共用分頁流程使用 `1..100`。 |
| `time_range_start` | 查詢 | 整數（Unix 毫秒時間戳記） | 否，或成對提供 | 交易記錄時間的下界，包含邊界。 |
| `time_range_end` | 查詢 | 整數（Unix 毫秒時間戳記） | 否，或成對提供 | 上界，包含邊界；有效篩選要求 `start < end`。 |

無法解析或超過數值範圍的分頁參數使用 HTTP 預設值。無法解析的日期值視為缺失。目前 SDK 僅在兩個邊界都存在且 `start < end` 時傳遞日期範圍，否則以**不帶日期篩選**的方式查詢。直接呼叫原始 ContentProvider 時，無效範圍的驗證行為不同。HTTP 呼叫端應自行驗證邊界。

兩個介面皆依記錄的交易時間降序排列，最新紀錄在前，並排除已刪除的流水項目。不保證以 ID 作為次級排序，也不提供跨頁快照。請依[分頁流程](/guide/api-reference?id=pagination)讀取，並考慮 Provider 實際生效的每頁筆數。成功的空陣列表示選定範圍/頁面沒有符合條件的項目；讀取失敗不等於零活動。兩個介面均不提供針對已刪除或無法取得資料的完整性旗標。

### GET /exp_records :id=get-exp-records

查詢經驗變動。參數就是[上述四個流水參數](/guide/api-reference?id=journal-parameters)，沒有 `gid` 篩選。

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**回應：** `HttpResponse<ExpRecord[]>`。目前序列化包含下列所有欄位，包括可空值。

| 欄位 | JSON 型別 | 含義 / 解析替代值 |
| --- | --- | --- |
| `id` | 整數或 `null` | 流水項目 ID。 |
| `time` | 整數或 `null` | 交易的 Unix 毫秒時間戳記，與可編輯的任務完成時間不同。 |
| `value` | 整數 | 每個關聯屬性的經驗變動；替代值為 `0`。使用 `isDecrease` 判斷方向。 |
| `isDecrease` | 布林值 | `true` 為減少，`false` 為增加；解析器將 Provider 整數 `1` 視為 true。 |
| `totalValue` | 整數 | 記錄的經驗變動合計，**並非經驗餘額**；替代值為 `0`。多屬性分批記錄時，儲存的合計可能重疊，見[報表合計](/guide/api-reference?id=journal-totals)。 |
| `resCode` | 整數 | 經驗專用原因代碼；替代值為 `0`。 |
| `relatedId` | 整數或 `null` | 關聯來源物件 ID。正常完成任務時為任務紀錄的 `id`，不是 `gid`。其他原因可能關聯其他資源。 |
| `content` | 字串或 `null` | 變動說明。 |
| `skillIds` | 整數陣列 | 關聯的屬性/技能 ID；替代值為空陣列。 |
| `relatedAttributes` | 字串陣列 | 關聯的舊版屬性字串；替代值為空陣列。 |

虛構範例：兩個屬性各增加 10 經驗，合計 20 經驗。

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**錯誤：** 見[共用 HTTP/Provider 錯誤](/guide/api-reference?id=response-errors)。如上所述，無效的 HTTP 日期邊界可能無提示地取消篩選，而非回傳錯誤。

### GET /coin_records :id=get-coin-records

查詢金幣變動。參數就是[上述四個流水參數](/guide/api-reference?id=journal-parameters)，沒有 `gid` 篩選。

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**回應：** `HttpResponse<CoinRecord[]>`。目前序列化包含下列所有欄位，包括可空值。

| 欄位 | JSON 型別 | 含義 / 解析替代值 |
| --- | --- | --- |
| `id` | 整數或 `null` | 流水項目 ID。 |
| `time` | 整數或 `null` | 交易的 Unix 毫秒時間戳記。 |
| `value` | 整數 | 金幣變動數額；替代值為 `0`。使用 `isDecrease` 判斷方向。 |
| `isDecrease` | 布林值 | `true` 為減少，`false` 為增加；解析器將 Provider 整數 `1` 視為 true。 |
| `totalValue` | 整數 | 操作後的金幣餘額；替代值為 `0`。與經驗 `totalValue` 不同，此欄位表示餘額。 |
| `resCode` | 整數 | 金幣專用原因代碼；替代值為 `0`。 |
| `relatedId` | 整數或 `null` | 關聯來源物件 ID；正常完成任務時為任務紀錄的 `id`。其他來源應搭配原因代碼解讀。 |
| `content` | 字串或 `null` | 變動說明。 |
| `savingBalance` | 整數或 `null` | 此操作記錄的存款餘額。 |

虛構範例：減少 5 金幣，剩餘金幣餘額為 95。

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**錯誤：** 見[共用 HTTP/Provider 錯誤](/guide/api-reference?id=response-errors)。如上所述，無效的 HTTP 日期邊界可能無提示地取消篩選，而非回傳錯誤。

### 原因代碼與報表合計 :id=journal-totals

原因代碼的取值範圍不同。部分範例：

| 原因 | 經驗 `resCode` | 金幣 `resCode` |
| --- | --- | --- |
| 完成任務 | `1` | `2` |
| 撤銷完成任務 | `101` | `3` |
| 完成子任務 | `12` | `11` |
| 撤銷子任務 | `106` | `12` |
| API 變動 | `200` | `28` |

完整經驗值代碼：`0` 未知；`1` 完成任務；`2` 成就；`3` 按讚兌換；`4` 連續使用天數；`5` 步數兌換；`6` 設為完成；`7` 撤銷放棄；`8` 撤銷逾期；`9` 吃番茄；`10` 使用商品；`11` 解鎖使用者成就；`12` 完成子任務；`200` API；`101` 撤銷完成；`102` 放棄；`103` 逾期；`104` 使用商品減少經驗值；`105` 重新鎖定使用者成就；`106` 撤銷子任務完成。金幣原因代碼與[倉庫紀錄](#get-inventory-records)共用取值範圍。請保留未來未知代碼。計算淨變動時透過 `isDecrease` 套用方向（`true` 時減去記錄的數額）。不要假設減少一定表示為負數 `value`；數值型別為有號型別，介面未聲明無號/絕對值保證。

經驗 `value` 是每個屬性的數額。不要直接跨紀錄累加經驗 `totalValue`：目前多屬性分批邏輯在涉及超過三個屬性時，可能儲存重疊的合計。例如，四個屬性各變動 10 經驗，儲存的合計可能分別為 40 和 10；實際合計應為 40，不能直接累加這些儲存值。精確報表應搭配每筆紀錄列出的屬性，核對各屬性的 `value`；關聯資訊缺失會限制可確認的結果。不要將 `value` 與 `totalValue` 相加，也不要將經驗 `totalValue` 描述為餘額。

統計一個曆日時，計算本地 `dayStart` 和 `nextDayStart`，然後請求 `[dayStart, nextDayStart - 1]`，因為兩個邊界皆包含在內。僅統計任務獎勵時篩選原因代碼；統計全部已記錄變動時不依原因篩選。見[日報流程](/guide/api-reference?id=daily-report)。

### 實作參考 :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [日期參數傳遞](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt)。

## 商品與分類 :id=get-items

`GET /items` 回傳 `ShopItem[]`。可重複的查詢參數 `id` 選取商品，例如 `/items?id=1&id=2`。非整數值會被捨棄，不存在的 ID 會略過；有效 ID 保留請求順序及重複值。若所有 ID 都無效，SDK 不會傳送 ID 篩選，將回傳一般商品列表。不支援分頁。

`GET /items/{listId}` 回傳**分類內**的 `ShopItem[]`，並非單一商品。`listId` 是帶正負號的 64 位元分類 ID；`-1` 代表全部，無效路徑值也回退為全部。一般列表排除下架／刪除商品（`isDel=0`），並遵循商店／分類的排序設定。依 ID 選取商品不受該一般列表篩選限制。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 商品 ID。 |
| `name` | string | 商品名稱。 |
| `desc` | string | 描述。 |
| `icon` | string | 可讀取的圖片 URI，或空字串。透過 `/files/{url}` 下載。 |
| `categoryId` | integer | 商店分類 ID。 |
| `stockNumber` | integer | 可用庫存；計算 `maxPurchaseNumber` 時，負數視為無限庫存。 |
| `ownNumber` | integer | 已持有的庫存數量。 |
| `price` | integer | 金幣價格。 |
| `order` | integer | 儲存的分類內排序值。 |
| `disablePurchase` | boolean | 是否禁止購買。 |
| `maxPurchaseNumber` | integer or null | 依可用金幣、信用額度及有限庫存計算；禁止購買時為 0，免費且無限庫存時可為 2147483647。此計算不會檢查所有購買限制規則。 |
| `titleColorString` | string or null | 自訂標題顏色。 |
| `actionText` | string or null | 自訂使用按鈕文字。 |
| `unlist` | boolean | 是否下架／刪除；一般列表結果通常為 false。 |
| `disableUse` | boolean | 商品是否含有不可使用效果。 |
| `purchaseLimit` | string or null | 商品的購買限制設定，為 **JSON 編碼字串**，不是巢狀陣列。 |
| `limitScope` | string or null | `purchase`、`use` 或 `both`。 |

### GET /items_categories :id=get-items-categories

回傳 `ShopCategory[]`。選用的 `include_hidden` 預設為 `false`；只解析完全相符的小寫 `true`／`false`，其他值視為 false。包含虛擬的「全部」分類。HTTP 伺服器未提供 `/items_categories/{id}`。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 分類 ID。 |
| `name` | string | 分類名稱。 |
| `isAsc` | boolean | 設定的遞增排序旗標。 |
| `sort` | string | 儲存的排序偏好。 |
| `order` | integer | 分類排序值。 |
| `hidden` | boolean | 是否在商店隱藏。 |
| `inventoryHidden` | boolean | 是否在倉庫隱藏。 |

### GET /tasks_categories :id=get-tasks-categories

回傳 `TaskCategory[]`，包含「全部」及已封存分類。沒有查詢參數或分頁。HTTP 伺服器未提供 `/tasks_categories/{id}`。分類的排序／篩選值為 App 儲存的偏好，本介面不將其作為請求篩選條件。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 分類 ID。 |
| `name` | string | 名稱。 |
| `isAsc` | boolean | 儲存的遞增排序旗標。 |
| `sort` | string | 儲存的排序偏好。 |
| `filter` | string | 儲存的分組／篩選偏好。 |
| `order` | integer | 分類排序值。 |
| `status` | integer | 0 一般；1 已封存。 |
| `type` | integer | 0 一般；智慧清單：10 每日、11 每週、12 每月、20 進行中。 |

## 屬性與屬性群組 :id=get-skills

`GET /skills` 回傳 `Skill[]`，沒有參數或分頁。排除隱藏／刪除的屬性，依儲存的排序值排列。底層 ContentProvider 的 `group_id`、`status` **不是** HTTP 模型欄位。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 屬性 ID。 |
| `name` | string | 本地化的屬性名稱。 |
| `desc` | string | 描述。 |
| `icon` | string | 可讀取的圖示 URI，或空字串。 |
| `order` | integer | 儲存的排序值。 |
| `color` | integer | Android 封裝的色彩整數。 |
| `exp` | integer | 目前總經驗值。 |
| `level` | integer | 目前等級。 |
| `untilNextLevelExp` | integer | 距離下一級所需的經驗值。 |
| `currentLevelExp` | integer | 進入目前等級後獲得的經驗值。 |
| `type` | integer | 0 使用者自訂；1 力量；2 學習；3 魅力；4 耐力；5 活力；6 創造力。 |

### GET /skill_groups :id=get-skill-groups

回傳 `SkillGroup[]`。`include_hidden` 與 `/items_categories` 一樣嚴格解析布林值，預設 false。目前 App 的群組資料庫存取層忽略此旗標，一律排除已刪除群組。依儲存的排序值遞增排列，沒有分頁。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 群組 ID。 |
| `content` | string | 群組標題。 |
| `order` | integer | 儲存的群組排序值。 |
| `collapsed` | boolean | 摺疊狀態。 |

## 成就 :id=get-achievements

`GET /achievements` 依分類順序載入各分類並合併成 `Achievement[]`。`GET /achievements/{id}` 回傳**分類 `id` 內**的成就，不是成就詳情。無效路徑 ID 視同未篩選。分類內依 App 中該分類的排序偏好排列；兩個介面都沒有分頁。

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 成就 ID。 |
| `name` | string | 標題。 |
| `desc` | string | 描述。 |
| `iconUri` | string | 圖示 URI，或空字串。 |
| `categoryId` | integer | 分類 ID。 |
| `status` | integer | 0 未完成；1 已完成但尚未領獎；2 已領獎／其他完成狀態。 |
| `exp` | integer | 經驗值獎勵。 |
| `coin` | integer | 金幣獎勵。 |
| `coinVariable` | integer | 浮動金幣獎勵。 |
| `type` | integer | 0 成就；1 子分類標題。 |
| `progress` | integer | 儲存的進度。 |
| `order` | integer | 分類內排序值。 |
| `itemId` | integer or null | 第一個獎勵商品 ID（舊版便利欄位）。 |
| `itemAmount` | integer or null | 第一個獎勵商品的數量。 |
| `unlockedTime` | integer or null | 解鎖時間，Unix 毫秒。 |
| `items` | RewardItem[] or null | 完整獎勵商品清單；目前解析器在商品 JSON 缺漏／格式錯誤時回傳空陣列。 |
| `color` | string or null | 自訂標題顏色。 |

獎勵商品使用共用的 [RewardItem](#reward-item) 模型。

### GET /achievement_categories :id=get-achievement-categories

回傳 `AchievementCategory[]`，沒有參數或分頁。HTTP 伺服器未提供 `/achievement_categories/{id}`。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 分類 ID。 |
| `name` | string | 名稱。 |
| `desc` | string | 描述。 |
| `iconUri` | string | 圖示 URI／字串。 |
| `isAsc` | boolean | 遞增排序旗標。 |
| `sort` | string | 儲存的排序偏好。 |
| `filter` | string | 儲存的分組／篩選偏好。 |
| `order` | integer | 分類排序值。 |
| `type` | integer | 0 使用者成就；1 系統成就。 |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

回傳**成就** ID `id` 的 `AchievementCondition[]`。非整數 ID 回傳 code 500 的錯誤包裝；沒有符合條件時回傳空陣列。沒有 `/achievement_conditions` 列表路徑。

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 條件 ID。 |
| `type` | integer | 條件代碼，見下文。 |
| `relatedId` | integer | 依條件而定的關聯任務／商品／屬性 ID。 |
| `target` | integer | 目標值。 |
| `current` | integer | 目前累計值。 |
| `progress` | integer | 儲存的進度。 |

條件代碼：0 任務完成次數；1 目前連續完成次數；2 舊屬性等級；3 番茄數；4 使用天數；5 按讚數；6 連續完成天數；7 目前金幣；8 單日獲得金幣；9 任務番茄數；10 商品購買次數；11 使用次數；12 開箱獲得商品數；13 屬性等級；14 人生等級；15 累計獲得商品數；16 合成獲得商品數；17 目前持有量；18 任務專注時間；19 ATM 存款；20 外部 API。重複條件：500 任務完成次數；501 屬性升級次數；502 番茄數；503 金幣；504 商品獲得數；505 商品購買次數；506 開箱獲得數；507 合成獲得數；508 商品使用次數；509 任務專注分鐘；510 任務番茄數；511 按讚數；512 ATM 存款增加；513 外部 API 呼叫次數；514 使用天數；515 人生等級提升；516 每日金幣；517 連續完成次數；518 每日番茄數；519 每日專注分鐘；520 每日不同任務群組數；521 每日商品使用次數；522 每日購買次數；523 每日指定任務完成次數；524 每日完成紀錄總筆數。這些都是整數代碼，不是序列化的列舉名稱。

## 合成 :id=get-synthesis

`GET /synthesis` 回傳可見分類中的 `Synthesis[]`。`GET /synthesis/{id}` 回傳**分類 `id` 內**的配方，包含該分類隱藏的內容。非負數 ID 選取分類，負數代表所有可見分類；無效 ID 回退為列表路徑。排除已刪除配方，依儲存的配方順序遞增排列，沒有分頁。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 配方 ID。 |
| `name` | string | 名稱。 |
| `desc` | string | 描述。 |
| `input` | SynthesisItemInfo[] | 所需商品。 |
| `output` | SynthesisItemInfo[] | 產出商品。 |
| `categoryId` | integer or null | 分類 ID。 |
| `canSynthesisTimes` | integer | 目前可合成的次數。 |

### SynthesisItemInfo :id=model-synthesis-item-info

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `itemId` | integer | 商品 ID。 |
| `itemName` | string | 商品名稱。 |
| `amount` | integer | 每次合成的投入／產出數量。 |
| `ownedNumber` | integer | 持有數量。 |
| `icon` | string | 可讀取的圖示 URI，或空字串。 |

### GET /synthesis_categories 與 /synthesis_categories/{id} :id=get-synthesis-categories

兩者皆回傳 `SynthesisCategory[]`。選用路徑 `id` 篩選分類 ID，仍維持陣列形狀；無效 ID 回退為全部分類。`include_hidden` 嚴格解析小寫布林值，預設 false；即使指定分類 ID 也適用。沒有分頁。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 分類 ID。 |
| `name` | string | 名稱。 |
| `isAsc` | boolean | 儲存的遞增排序旗標。 |
| `sort` | string | 儲存的排序偏好。 |
| `order` | integer | 分類排序值。 |
| `hidden` | boolean | 是否隱藏。 |

## 感想 :id=get-feelings

`GET /feelings` 回傳 `Feelings[]`。`offset` 預設 0、`limit` 預設 100；缺漏或非整數值使用預設值。沒有明確的上下限調整，請使用非負位移與正數筆數。排除已刪除感想，依 App 的感想排序偏好（`createTime` 遞增／遞減）排列，不能透過請求指定排序或時間範圍。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 感想 ID。 |
| `content` | string | 文字內容。 |
| `isFav` | boolean | 是否收藏。 |
| `title` | string | 關聯標題。 |
| `time` | integer | 建立時間，Unix 毫秒。 |
| `attachments` | string[] | 可讀取的附件 URI；僅包含存在且非空的檔案。 |
| `type` | integer | 0 任務；1 成就；2 獨立感想。 |

## 番茄鐘紀錄 :id=get-pomodoro-records

`GET /pomodoro_records` 回傳 `PomodoroRecord[]`。`offset` 預設 0、`limit` 預設 100，沒有明確上下限。選用的 `time_range_start`／`time_range_end` 為 Unix 毫秒；只有兩者都能解析為 64 位元整數且起點小於終點時，SDK 才轉送範圍，否則會靜默忽略。

無範圍時，回傳已結束、未刪除、`startTime != endTime` 且 `endTime` 為正數的紀錄，依 `endTime DESC, startTime DESC, id DESC` 排序。有效範圍選取 `start < endTime <= end` 並排除已刪除紀錄。

> [!WARNING]
> 舊版實作的日期範圍分支將 `limit`、`offset` 反向傳給 DAO，也未指定排序。本機人升原始碼已改用具名參數，分頁結果依 `endTime DESC, startTime DESC, id DESC` 排序；此本機修正尚未發布。在確認已安裝的人升版本包含修正前，若需要可靠分頁，請省略範圍並在用戶端篩選回傳紀錄。

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 紀錄 ID。 |
| `startTime` | integer or null | 開始時間，Unix 毫秒。 |
| `endTime` | integer or null | 結束時間，Unix 毫秒。 |
| `duration` | integer | 毫秒：若儲存的 `lastTime` 非零則使用該值，否則為結束減開始時間。 |
| `reward` | number | 番茄獎勵數：放棄為 0；半個番茄為 0.5 × 倍率；其他為倍率。 |

## 倉庫紀錄 :id=get-inventory-records

`GET /inventory_records` 回傳 `InventoryRecord[]`。`offset` 預設 0 並調整為至少 0；`limit` 預設 100 並限制在 1–200。只有 `time_range_start`、`time_range_end` 都能解析為 64 位元整數且 start < end，SDK 才轉送；無效或不完整範圍會被靜默忽略。有效範圍包含兩端（`time >= start AND time <= end`）。排除已刪除紀錄（`isDel` 為 null 或 0），依 `time DESC, id DESC` 排序；不支援商品 ID 篩選。

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 紀錄 ID。 |
| `time` | integer or null | 建立時間，Unix 毫秒。 |
| `itemId` | integer or null | 關聯商品 ID。 |
| `itemName` | string or null | 可取得時的關聯商品名稱。 |
| `changeNumber` | integer | 紀錄的數量變化。 |
| `isDecrease` | boolean | 此變化是否減少庫存。 |
| `resCode` | integer | 來源原因代碼，見下文。 |
| `desc` | string or null | 紀錄描述。 |

原因代碼：0 購買；1 使用；2 完成任務；3 撤銷完成；4 清除資料；5 放棄任務；6 任務逾期；7 解鎖內建成就；8 撤銷放棄；9 撤銷逾期；10 退貨；11 完成子任務；12 撤銷子任務完成；13 解鎖使用者成就；14 撤銷該解鎖；15 存款；16 提款；17 賣出番茄；20 獎勵商品；21 撤銷商品獎勵；23 合成；24 開箱；25 ATM 利息；26 番茄兌換商品；27 信用利息；28 API；29 商品效果改變庫存。用戶端應保留未來未知的代碼。

## 步數紀錄 :id=get-step-records

`GET /step_records` 回傳 `StepRecord[]`。分頁預設、限制與 SDK 範圍省略規則皆同 `/inventory_records`。有效時間篩選包含 `date` 兩端，依 `date DESC` 排序，沒有明確的第二排序鍵。

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 紀錄 ID。 |
| `date` | integer or null | 紀錄日期，Unix 毫秒。 |
| `dailyStepCount` | integer | 每日步數。 |
| `totalStepCount` | integer | 儲存的累計步數。 |
| `isGotReward` | boolean | 是否已領獎。 |
| `isUserInput` | boolean | 是否由使用者輸入。 |
| `rewardLevel` | integer or null | 儲存的獎勵等級。 |

## 等級定義 :id=get-level-defines

`GET /level_defines` 回傳單一 `LevelDefines` 物件，沒有參數。自訂等級模式啟用時使用自訂定義，否則使用內建定義。

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `custom` | boolean | 自訂等級模式。 |
| `levels` | LevelDefine[] | 等級範圍。 |

### LevelDefine :id=model-level-define

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer or null | 定義 ID。 |
| `levelStart` | integer | 起始等級。 |
| `levelEnd` | integer | 結束等級。 |
| `perLevelExp` | integer | 該範圍內每級所需的經驗值。 |

目前格式錯誤的等級 JSON 會轉為空的 `levels` 陣列，不會令整個請求失敗。

## 統計 :id=get-statistics

`GET /statistics` 回傳單一 `Statistics` 物件。選用的 `time_range_start`／`time_range_end` 為 Unix 毫秒；兩者有效且 start < end 才由 SDK 轉送，否則不傳範圍。未指定時，使用第一筆紀錄至今；沒有紀錄則使用最近 30 天。即使指定範圍，`usingDays`、`companionDays` 仍是累計值。其他指標由各自的 App 統計方法計算，不應假設所有查詢的邊界包含規則都相同。

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `start` | integer or null | 實際範圍起點，Unix 毫秒。 |
| `end` | integer or null | 實際範圍終點，Unix 毫秒。 |
| `tomatoes` | integer | 番茄獲得數統計。 |
| `pomodoroMinutes` | integer | 專注時間，單位為分鐘。 |
| `focusCount` | integer | 專注次數。 |
| `tasksCompleted` | integer | 完成率統計使用的已完成任務數。 |
| `tasksTotal` | integer | 該統計使用的任務總數。 |
| `taskCompleteRate` | number | 完成率。 |
| `feelingsCount` | integer | 感想數。 |
| `usingDays` | integer | 累計使用天數。 |
| `companionDays` | integer | 累計陪伴天數。 |
| `interestChanged` | integer | 利息金幣變化統計。 |
| `coinPurchaseConsumed` | integer | 購買消耗金幣統計。 |

## App 資訊與金幣餘額 :id=get-info

`GET /info` 回傳 `Info`。雲人升會在 App／Provider 資訊中加入自身已安裝的版本；沒有參數。

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `appVersion` | integer | 已安裝人升的版本代碼。 |
| `appVersionName` | string | 已安裝人升的版本名稱。 |
| `apiVersion` | integer | 人升 API 版本。 |
| `cloudVersion` | integer | 已安裝雲人升的版本代碼。 |
| `cloudVersionName` | string | 已安裝雲人升的版本名稱。 |

### GET /coin :id=get-coin

透過 ContentProvider 呼叫 `lifeup://api/query?key=coin` 並回傳結果物件，沒有參數。null 結果轉為空物件。欄位由 Provider 定義，並非型別化的 `CoinData` 回應。成功時提供 `value`（帶正負號的 64 位元金幣餘額）及 `api_result: true`；失敗可包含下文的 Provider 狀態／錯誤欄位。

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## 呼叫 URL Scheme API :id=invoke-api

[URL Scheme API 目錄](/guide/api)定義方法名稱、參數及各方法的結果。HTTP 橋接接受完整的 `lifeup://api/...` URL。

| 傳輸方式 | 輸入 | 執行與回應 |
| --- | --- | --- |
| `GET /api` | 可重複且經 URL 編碼的查詢參數 `url` | 依序為每個 URL 啟動 Android Activity，回傳字串 `success`；未提供 URL 也成功。 |
| `POST /api` | JSON `RawQueryVo` | 先處理所有 `urls`，再處理存在的 `url`，回傳字串 `success`；空物件也成功。 |
| `GET /api/contentprovider` | 可重複且經 URL 編碼的查詢參數 `url` | 同步呼叫 Provider，依序回傳 `CallUrlResult[]`；沒有 URL 時回傳錯誤包裝（`No url found`）。 |
| `POST /api/contentprovider` | JSON `RawQueryVo` | 先呼叫所有 `urls`，再呼叫 `url`，回傳 `CallUrlResult[]`；空物件回傳空陣列。 |

JSON POST 請設定 `Content-Type: application/json`。GET 查詢內須將完整 URL 編碼，保留內部 `&`、`?`、`+` 及百分比編碼。Activity 橋接成功只表示已派送，不代表人升動作已完成。ContentProvider 方法需要在人升授予雲人升權限，支援情況依 URL Scheme 方法而定。呼叫依序執行；後續呼叫拋錯不會回復先前效果。

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity 橋接回應：

```json
{"code":200,"message":"success","data":"success"}
```

Provider 橋接回應（示意結果）：

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `url` | string or null | 選用的單一 URL。 |
| `urls` | string[] or null | 選用的 URL 清單，先於 `url` 處理。 |

### CallUrlResult :id=model-call-url-result

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `url` | string | 提交的 URL。 |
| `result` | object or null | 轉換後的 Provider Bundle；null 本身不會讓 HTTP 包裝失敗。 |

Bundle 轉換保留 Int／Long／Double／String／Boolean 與巢狀 Bundle。陣列會轉成字串陣列；其他型別轉為 `toString()` 字串（包含 Bundle 的 null 變成字串 `"null"`）。即使外層 code 200，也須檢查 `result` 內的方法失敗欄位。

目前人升方法處理器會為完成的呼叫加入布林值 `api_result`。捕捉到的方法失敗會回傳 `api_result: false`、字串 `error_code`、字串 `error_message`。代碼包括 `missing_required_parameter`、`invalid_parameter`、`entity_not_found`、`invalid_format`、`unsupported_api`、`cancelled`、`internal_error`；各方法也可提供其他代碼。還原備份期間，Provider 可回傳 `error_code: "503"` 與 `error_message`，而沒有 `api_result`。找不到 API 處理器可能在此轉換之前拋錯，變成外層橋接錯誤。

## 讀取與上傳檔案 :id=files-download

### GET /files/{url} :id=files-get

將完整可讀取 URI 以 URL 編碼成單一路徑區段。此介面透過 Android 內容解析器讀取圖示、感想附件、匯出備份或上傳檔案等位元組，回傳位元組串流而非 JSON 成功包裝。路徑未指定檔名或 MIME 型別。空／無法讀取的串流不會轉成結構化的找不到結果；拋錯由全域 HTTP 500 處理器處理。空白匹配參數回傳錯誤包裝（`url is required`）。

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

傳送 `multipart/form-data`。不論欄位名稱為何，所有檔案部分都會接受；其他表單部分忽略。快取檔案使用原始檔名，缺漏時使用 `uploaded_image_<time>.jpg`。回傳可讀取 content URI 字串陣列。上傳僅提供後續 API 使用的 URI，不會自動附加至商品或任務。沒有檔案回傳 `No files received` 錯誤包裝。

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## 備份匯出與匯入 :id=files-backup

### GET /data/export :id=files-export

透過 Provider 建立備份。`withMedia` 預設 `true`；提供時，不分大小寫的 `true` 視為真，其他值為假。回傳轉換後的 Bundle，目前包含 `backup_file_uri`，可透過 `/files/{url}` 下載。雖然方法為 GET，此介面仍會建立匯出檔。必須檢查可能存在的 Provider API 狀態／錯誤欄位；空 URI 表示未產生可用檔案，null 結果則轉為錯誤。

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

以 `multipart/form-data` 傳送備份檔；若有多個檔案，以最後一個為準，不檢查欄位名稱。預設檔名為 `backup.lfbak`。選用的 `description` 會被讀取但不生效。雲人升快取檔案後啟動人升備份畫面；回應僅確認上傳及畫面啟動，**不代表還原完成**。沒有檔案回傳 `No file received`。

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## 事件 :id=get-events

### GET /events :id=get-events-poll

回傳 `EventsPage`。`after` 為不含本身的事件 ID 游標（64 位元整數，預設 0）；`limit` 預設 50 並限制在 1–200，非整數使用預設值。緩衝區內依舊到新回傳 `id > after` 的事件。記憶體最多保留 200 筆，舊事件會捨棄，程序重啟後 ID 重設。`latestId` 是全域最新 ID，不一定是本頁最後一筆；請從實際處理的最後事件繼續，避免跳過積壓事件。沒有持久歷史或送達確認。

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `latestId` | integer | 目前最新的事件 ID。 |
| `eventWs` | boolean | 雲人升的 WebSocket 設定。 |
| `events` | CloudEvent[] | 游標之後保留的事件。 |
| `broadcasts` | boolean or null | 人升是否啟用廣播；null 表示未知或不支援。查詢狀態快取五秒。 |

### CloudEvent :id=model-cloud-event

| 欄位 | JSON 型別 | 含義 |
| --- | --- | --- |
| `id` | integer | 記憶體中的事件序號。 |
| `time` | integer | 雲人升接收事件的時間，Unix 毫秒。 |
| `action` | string | Android 廣播動作。 |
| `extras` | 字串值物件 | 廣播附加資料經 `toString()` 轉換；null 變成空字串。索引鍵依動作而定。 |

### WebSocket /events :id=get-events-websocket

`eventWs` 為 true 時，連線 `ws://HOST:PORT/events?after=ID` 並提供設定的 token。伺服器先重播保留事件，再以個別 JSON `CloudEvent` 文字框架傳送即時事件，**沒有** HTTP 回應包裝。重播限於記憶體中的 200 筆，WebSocket 不支援 `limit`。每 30 秒傳送 Ping；重新連線時使用實際處理的最後事件 ID。停用時不註冊 WebSocket 路徑，但仍可 HTTP 輪詢。

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

支援的動作訂閱包括 `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, `app.lifeup.timing.abandon`。收集事件需要在人升啟用廣播。輪詢 `/events` 只會檢查設定，不會自動啟用。

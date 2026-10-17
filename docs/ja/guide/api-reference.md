# HTTP API リファレンス :id=http-query-reference

LifeUp Cloud の要求パラメーターと完全な HTTP 応答モデルを記載します。インストール・権限・接続は [LifeUp Cloud](/guide/api_cloud)から確認してください。新しい記録台帳 API には LifeUp **1.106.0+** と LifeUp Cloud **3.0.0+** が必要です。`/info` で導入済みバージョンを確認できます。本書は現行ソースの契約を説明し、特定リリースの提供状況を保証するものではありません。

## インターフェース一覧 :id=interface-index

| リソース | メソッドとパス | パラメーターとモデル |
| --- | --- | --- |
| 共通規則 | JSON 応答、権限、キャッシュ条件、ページ取得 | [規則](#representations)、[キャッシュと認証](#auth-cache)、[ページ取得](#pagination) |
| タスク | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [クエリ](#get-tasks)、[タスクモデル](#task-fields)、[カテゴリ](#get-tasks-categories) |
| タスク履歴 | `GET /history` | [パラメーター](#get-history)、[時刻](#task-times)、[日次レポート](#daily-report) |
| アイテム | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [アイテム・カテゴリ ID と完全なモデル](#get-items) |
| 属性 | `GET /skills`, `GET /skill_groups` | [属性とグループ](#get-skills) |
| 実績 | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [実績と条件](#get-achievements) |
| 合成 | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [レシピとカテゴリ](#get-synthesis) |
| 感想 | `GET /feelings` | [感想のページ取得](#get-feelings) |
| EXP / コイン | `GET /exp_records`, `GET /coin_records` | [台帳パラメーターとモデル](#reward-journals) |
| その他の記録 | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [ポモドーロ](#get-pomodoro-records)、[インベントリ](#get-inventory-records)、[歩数](#get-step-records) |
| レベル / 統計 | `GET /level_defines`, `GET /statistics` | [レベル](#get-level-defines)、[統計](#get-statistics) |
| アプリ / 残高 | `GET /info`, `GET /coin` | [バージョン情報](#get-info)、[コイン結果](#get-coin) |
| アクション呼び出し | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [呼び出しブリッジ](#invoke-api)。業務メソッドは [URL Scheme 一覧](/guide/api) |
| ファイル / バックアップ | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [ファイル](#files-download)、[バックアップ転送](#files-backup) |
| イベント | `GET /events`, WebSocket `/events` | [ポーリングとライブイベント](#get-events) |
| 開始ページ | `GET /` | JSON リソースではない HTML の紹介ページ。 |

MCP は別のクライアント・ツール表現を使います。[MCP との違い](#mcp-differences)と [MCP ガイド](/guide/api_mcp)を参照してください。

## 転送と表現 :id=representations

| インターフェース | 表現 | 主な違い |
| --- | --- | --- |
| Cloud HTTP クエリ | `{code, message, data}` でラップされた JSON | 以下のエンドポイント仕様は、この公開 JSON を説明します。 |
| Android ContentProvider | `_ID` / `_GID` などの Cursor 列。JSON テキストを含む場合があります | SDK の解析で `id` / `gid` などの HTTP フィールドやネストした配列に変換されます。Cursor 列定義を HTTP スキーマとして使わないでください。 |
| URL Scheme アクション | `lifeup://api/{method}` とメソッド固有のパラメーター/結果 | HTTP 読み取りフィールドが camelCase でも、書き込みパラメーターは snake_case の場合があります。 |
| MCP リストツール | ツール固有のエンベロープと簡潔または詳細なレコード | MCP のページネーションと出力フィールドはクライアント側の追加動作であり、HTTP 応答フィールドではありません。 |

## 応答とエラー :id=response-errors

共通の HTTP JSON ラッパーは `HttpResponse<T>` です。

| フィールド | 型 | 意味 |
| --- | --- | --- |
| `code` | integer | クエリ成功時は `200`。それ以外はエラーを示します。HTTP ステータスとは別の本文フィールドです。 |
| `message` | string | 成功時は通常 `success`、それ以外はエラーの説明です。 |
| `data` | `T` または `null` | 成功時はエンドポイント固有の値（配列・オブジェクト・文字列）、エラー時は `null`。 |

成功した空リストの例:

```json
{"code":200,"message":"success","data":[]}
```

権限/プロバイダーアクセスエラーの例:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| シグナル | 対処 |
| --- | --- |
| HTTP `401` | 設定済み Cloud トークンを `Authorization` ヘッダーの値としてそのまま指定します。`Bearer` は付けません。 |
| 本文 `code = 10001` | LifeUp がインストールされ実行中であること、および Cloud に Read LifeUp Data 権限があることを確認します。 |
| 本文 `code = 10002` | ContentProvider クエリに失敗しています。エラーメッセージを確認します。 |
| その他の失敗ステータス/コード | 空の結果ではなく、クエリ失敗として扱います。 |

HTTP ステータスと本文の `code` の**両方**を確認してください。ルートによっては HTTP `200` のまま本文にエラーコードが入ります。`/api/contentprovider` 経由のアクションでは、各 `data[].result.api_result` も確認してください。ラッパーの `code=200` はすべてのアクションの成功を意味しません。

## 認証と条件付き読み取り :id=auth-cache

Cloud トークン設定時は完全に一致する生の値を `Authorization` に送り、`Bearer` は付けません。サーバーは `token` クエリも受け付けるため、WebSocket ヘッダーを設定できないクライアントも利用できます。欠落・誤りは HTTP `401` と本文 `code=401`。開始ページ、リソース、ブリッジ、ファイル、バックアップ転送、イベントすべてが対象です。

JSON リソースの読み取り成功には強い SHA-256 `ETag` と `Cache-Control: private, no-cache` が付きます。タスク・履歴、アイテム・カテゴリ、属性・グループ、実績・条件、感想、合成・カテゴリ、台帳、レベル、統計、情報、コインが対象です。呼び出しブリッジ、ファイル・バックアップ転送、イベント配信・ポーリングは対象外です。

| 要求ヘッダー | 現在の応答動作 |
| --- | --- |
| `If-Match` | バージョン不一致は HTTP `412`。`If-None-Match` より先に評価。 |
| `If-None-Match` | 一致すれば HTTP `304` で JSON 本文はありません。キャッシュ済みの成功表現を再利用。 |

エラーエンベロープにはリソースバージョンのヘッダーはありません。条件付き読み取りは個々の要求単位で、複数ページやルートをまたぐスナップショット・トランザクションではありません。

ブラウザーのクロスオリジン要求には `If-None-Match` を使えます。現行 CORS 設定ではプリフライトに `If-Match` を許可しないため、実装修正前にクロスオリジンの `If-Match` には依存しないでください。ネイティブクライアントはブラウザー CORS の対象外です。

## 共通データ規則 :id=data-conventions

| 規則 | 内容 |
| --- | --- |
| 時刻 | タイムスタンプは Unix ミリ秒です。暦日の境界は対象のタイムゾーンによって異なります。各フィールドの意味はリソースごとに確認してください。 |
| 識別子 | タスク `id` は個々のタスク/サイクルを識別し、`gid` は繰り返しサイクルを通じたグループを識別します。カテゴリ/リスト ID は別のリソースを指します。 |
| 空の値 | 欠落、`null`、`0`、`""`、`[]` はそれぞれ異なります。実際の代替値や省略の動作は各モデルを確認してください。 |
| 数値 ID | ID は符号付き 64 ビット整数の場合があり、JavaScript Number ではすべての値を正確に表現できません。適切な JSON パーサーで大きな ID を保持してください。 |
| 配列とオブジェクト | HTTP の `items` や `subTasks` などのネスト値は配列であり、JSON 文字列ではありません。 |
| 状態と理由コード | リソースごとに記載された列挙値を使います。タスク状態、実績状態、履歴の理由コードは別の体系です。 |

`startTime`、`deadline`、`endTime` の定義は[タスク時刻](/guide/api-reference?id=task-times)を参照してください。

## ページネーションとフィルター :id=pagination

ページネーションはエンドポイントごとの機能であり、すべてのリストに備わるものではありません。HTTP の生リスト応答は `data: [...]` を返し、`total`、`count`、`hasMore` は追加しません。

| HTTP エンドポイント | ページネーション | 日付範囲 | その他のフィルター |
| --- | --- | --- | --- |
| `/tasks`、`/tasks/{categoryId}` | なし。全配列 | なし | パスでカテゴリを指定可能 |
| `/history` | サーバー側 `offset` / `limit` | なし | 任意の `gid` |
| `/feelings` | サーバー側 `offset` / `limit` | なし | [感想](#get-feelings)を参照 |
| `/pomodoro_records`、`/coin_records`、`/inventory_records`、`/exp_records`、`/step_records` | サーバー側 `offset` / `limit` | `time_range_start` / `time_range_end` | 各エンドポイントを参照 |
| `/statistics` | なし。単一オブジェクト | `time_range_start` / `time_range_end` | 集計クエリ |
| `/coin`、`/info` | なし。単一オブジェクト | なし | 単一項目クエリ |

ページ分割されるエンドポイントの HTTP デフォルトは `offset=0`、`limit=100` です。共通のページ取得ループでは offset を 0 以上、ページサイズを `1..100` にします。HTTP ブリッジは MCP の `1..100` 制限を適用せず、下流プロバイダーが別の制限を課す場合があります。各エンドポイントの有効ページサイズと検証規則を確認してください。

[時間指定ポモドーロの制限](#get-pomodoro-records)を除き、各ページの成功後は返された件数だけ `offset` を進めます。件数が有効ページサイズ（`1..100` 使用時は要求した `limit`。時間指定ポモドーロを除く）より小さければ終了します。プロバイダー上限で小さくなったページを末尾と誤認しないでください。末尾を超えた空ページは正常です。複数ページはスナップショットではなく、途中で記録が変わる場合があります。

現行 HTTP SDK は、両方の日付境界が整数として解析でき、かつ `start < end` の場合に限り範囲を転送します。片方のみ、不正な値、または逆転した範囲では、フィルターなしでクエリされます。エラー検出に頼らず、送信前に両方の境界を検証してください。履歴の仕様では、各エンドポイントの日付範囲の両端を含むか説明しています。

## MCP との違い :id=mcp-differences

MCP リストツールは既定で `limit=20` を使い、`1..100` に制限し、`offset` は 0 以上に調整します。履歴や履歴台帳のようにサーバー側でページ分割されるリソースにはページ指定を渡しますが、タスクのような全件 HTTP 配列は取得後にローカルで分割します。`items`、`count`、`hasMore`、任意の `total` は MCP エンベロープの項目です。`detail=false` では各レコードのフィールドも削られます。HTTP モデル全体が必要な場合は `detail=true` を使ってください。

## 情報源とバージョン範囲 :id=api-common-sources

このリファレンスは現行の公開 SDK と対応する LifeUp プロバイダーの動作を説明します。例のデータは架空です。ソースリンクは実装の参照先であり、インストール済みの特定バージョンが全フィールドを備えることの証明ではありません。[HTTP ルート](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)、[HTTP ラッパー](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt)、[MCP クエリ変換](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts)。

## タスクと履歴のデータモデル :id=task-history-models

このページでは[タスク/履歴クエリ](/guide/api-reference?id=task-queries)が返す **HTTP JSON** を定義します。Android Cursor 列や URL Scheme アクションのパラメーターは名称や表現が異なる場合があります。[共通規則](/guide/api-reference?id=representations)を参照してください。

SDK はシリアライズに同じ `Task` クラスを使います。このページでは `/tasks` のビューを `Task`、`/history` のビューを `HistoryRecord` と呼びます。これは既存の出力を説明する名前で、新しい API を導入するものではありません。現行 Cloud のシリアライズではデフォルト値と `null` フィールドも含まれます。

### Task / HistoryRecord のフィールド :id=task-fields

以下のフィールドはすべて現行 HTTP オブジェクトに含まれます。プロバイダー値がない場合、多くは記載した代替値に変換されます。代替値があるからといって、元データに値があったとは限りません。

| フィールド | JSON 型 | 意味 / 代替値 |
| --- | --- | --- |
| `id` | integer または `null` | このタスク/サイクルの ID。 |
| `gid` | integer または `null` | 繰り返すサイクルで共有されるタスクグループ ID。 |
| `name` | string | タスク名。プロバイダーに名前がない場合は `ERROR: name is null` になります。 |
| `notes` | string | メモ。未設定の場合は空文字列。 |
| `status` | integer | タスクの状態。未設定時の既定値は `0`。下の状態表を参照。 |
| `startTime` | integer | 設定された開始時刻 (ミリ秒)。SDK の代替値は `0`。 |
| `deadline` | integer | 期限 (ミリ秒)。未設定時の SDK 代替値は `0`。 |
| `remindTime` | integer | リマインダー時刻 (ミリ秒)。未設定時の SDK 代替値は `0`。 |
| `frequency` | integer | 繰り返しコード。`0` は 1 回、`1` は毎日、`-1` は無制限。ほかの繰り返しモードは[タスクアクション](/guide/api)を参照。SDK の代替値は `0`。 |
| `weekdays` | string | 曜日の選択。例: `1,3,5` (月曜 `1`、日曜 `7`)。未指定なら空、履歴では固定の空プレースホルダー。 |
| `exp` | integer | 設定 EXP 報酬。取引額ではありません。既定値 `0`。 |
| `skillIds` | integer array | 報酬に関連する属性。利用できない場合は空配列。 |
| `coin` | integer | 設定コイン報酬。既定値 `0`。 |
| `coinVariable` | integer | ランダムコイン報酬の設定。既定値 `0`。 |
| `itemId` | integer | 旧形式の先頭報酬アイテム ID。既定値 `0`。全件には `items` を使用。 |
| `itemAmount` | integer | 旧形式の先頭報酬アイテム数量。既定値 `0`。HTTP 名はプロバイダー列 `itemCount` と異なります。 |
| `words` | string | 完了時のインセンティブ文。未設定なら空。 |
| `categoryId` | integer | タスクカテゴリ/リスト ID。未設定時は `0`。 |
| `order` | integer | タスクリスト内の順序値。プロバイダーが列を返さないため、履歴では固定 `0` のプレースホルダー。 |
| `nameExtended` | string | 拡張表示名。プロバイダーが列を返さないため、履歴では固定の空プレースホルダー。 |
| `endTime` | integer | 履歴の記録終了時刻。`/tasks` では `0` が入り、[時刻の意味](/guide/api-reference?id=task-times)を参照。 |
| `items` | `RewardItem[]` | アイテム報酬。利用できない場合は空配列。 |
| `subTasks` | `SubTask[]` | ネストしたサブタスク。利用できない場合は空配列。 |
| `countProgress` | `TaskCountProgress` または `null` | 利用可能な場合の進捗スナップショット。どちらのビューにも現れる場合があります。 |
| `repeatEndCondition` | `TaskRepeatEndCondition` または `null` | `/tasks` の繰り返し終了規則。`/history` では常に `null`。 |

### タスクの状態と時刻 :id=task-times

| `status` | 意味 | 履歴の `endTime` の意味 |
| --- | --- | --- |
| `0` | 未完了 | 完了時刻ではありません。`/history` は終了済みレコードを選択します。 |
| `1` | 完了 | 記録された完了時刻。 |
| `2` | 期限超過 | 記録された期限超過時刻。 |
| `3` | 放棄 | 記録された放棄時刻。 |

| 時刻フィールド | 定義 |
| --- | --- |
| `startTime` | 設定/予定されたタスク開始時刻。ユーザーが実際に作業を始めた時刻ではありません。 |
| `deadline` | 予定された期限。記録終了時刻とは別です。 |
| `endTime` | 履歴タスクの記録終了時刻。上記のように `status` と合わせて解釈します。 |

3 つとも Unix ミリ秒です。通常の完了ではアプリが現在時刻を記録します。`history_operation` の `operation=edit_completed_time` は `completed_time` 入力を受け取り、この保存済み完了時刻を編集します。履歴を読むときのフィールド名は引き続き `endTime` です。

保存時刻は編集できます。終了済みレコードに保存済み終了日がなければ、アプリは現在時刻を代わりに使います。そのため `endTime` は現在記録されている時刻であり、変更不能な監査タイムスタンプではありません。`/tasks` の `0` は SDK のプレースホルダーで、Unix エポックの実イベントではありません。

### RewardItem :id=reward-item

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `itemId` | integer | 報酬アイテム ID。 |
| `itemCount` | integer | 報酬数量。 |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| フィールド | JSON 型 | 意味 / 既定値 |
| --- | --- | --- |
| `id` | integer | サブタスク ID。 |
| `gid` | integer | サブタスクグループ ID。 |
| `todo` | string | サブタスクのテキスト。 |
| `status` | integer | `0` 未完了、`1` 完了。 |
| `remindTime` | integer または `null` | リマインダー時刻 (ミリ秒)。利用できない場合は `null`。 |
| `endTime` | integer または `null` | サブタスク完了時刻 (ミリ秒)。利用できない場合は `null`。 |
| `exp` | integer | 設定 EXP 報酬。 |
| `coin` | integer または `null` | 設定コイン報酬。 |
| `coinVariable` | integer または `null` | ランダムコイン報酬の設定。 |
| `items` | `RewardItem[]` | アイテム報酬。既定は空配列。 |
| `order` | integer または `null` | 順序値。モデルの既定値は `0`。 |
| `autoUseItem` | boolean または `null` | 報酬を自動使用するか。モデルの既定値は `false`。 |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `currentCount` | integer | このタスク/サイクルの現在数。 |
| `targetCount` | integer | このタスク/サイクルの目標数。 |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| フィールド | JSON 型 | 意味 / 既定値 |
| --- | --- | --- |
| `mode` | string | `COUNT` または `DATE`。読み取り側の文字列で、数値のアクションパラメーターではありません。 |
| `behavior` | string | `TERMINATE` または `FREEZE`。 |
| `targetCycleCount` | integer または `null` | `COUNT` のサイクル数目標。既定値 `null`。 |
| `endDateMillis` | integer または `null` | `DATE` の終了日タイムスタンプ (ミリ秒)。既定値 `null`。 |
| `inclusive` | boolean | 終了日を含むか。既定値 `false`。 |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### 報酬額 :id=reward-amounts

タスクとサブタスクのこれらのフィールドは設定された報酬を表します。倍率、ランダムコイン、精算規則によって実際の付与額は変わります。取引額には[EXP とコインの履歴](/guide/api-reference?id=reward-journals)を使い、正の報酬と、取消やペナルティを含む純変動を区別してください。

### 実装の参照先 :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [パーサー](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [回数進捗](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [繰り返し終了条件](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## タスクと履歴のクエリ :id=task-queries

[共通規則](/guide/api-reference?id=http-query-reference)と[Task/History の完全なモデル](/guide/api-reference?id=task-history-models)を参照してください。これらのエンドポイントには Cloud の Read LifeUp Data 権限が必要です。基本リストクエリは最新 Cloud を使う LifeUp v1.91+ を対象としています。例は現在の SDK フィールドを示します。古いインストールとの連携では `/info` を確認してください。

### GET /tasks と /tasks/{categoryId} :id=get-tasks

現在の**未完了**タスクリストを取得します。カテゴリ/リストで絞り込むこともできます。結果は全件配列で、サーバー側のページ分割はありません。完了、期限超過、放棄済みのレコードは `/history` で取得します。

| パラメーター | 場所 | 型 | 必須 | 既定値 / 動作 |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | `/tasks/{categoryId}` の場合のみ | 全未完了タスクを取得する場合はパス部分を省略します。 |

これらのルートでは `offset`、`limit`、`gid`、日付範囲のクエリパラメーターはサポートされません。整数でないカテゴリーパスは現在カテゴリなしとして解析されます。誤って全タスクを取得しないよう、リクエスト前に検証してください。

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**応答:** `HttpResponse<Task[]>`。レコードの全フィールドとネスト構造は[Task/History フィールド](/guide/api-reference?id=task-fields)を参照してください。以下の架空のレコードは HTTP のトップレベル形状全体を示します。`endTime=0` はこのルートのプレースホルダーであり、完了時刻ではありません。

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

**動作とエラー:** リストの選択と順序は LifeUp のタスクリスト規則に従います。このエンドポイントは完了時刻による並べ替えを保証しません。成功応答の `data: []` は選択したタスクリストにレコードがないことを示します。権限/プロバイダーの失敗は[共通エラーラッパー](/guide/api-reference?id=response-errors)で返り、空配列ではありません。完了を報告する場合は、このルートの `endTime` ではなく下記 `/history` を使ってください。

### GET /history :id=get-history

完了、期限超過、放棄を含む、表示可能な終了済みタスクレコードを取得します。削除された履歴は除外されます。

| パラメーター | 場所 | 型 | 必須 | 既定値 / 動作 |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | いいえ | `0`。読み飛ばすレコード数。0 始まり。 |
| `limit` | Query | integer | いいえ | `100`。正のページサイズを指定します。`1..100` を推奨。 |
| `gid` | Query | integer | いいえ | グループで絞り込まない。指定すると複数サイクルにまたがるタスクグループを選択。 |

HTTP パーサーは解析できない `offset` / `limit` に `0` / `100` を使い、解析できない `gid` を破棄します。解析できた数値はこのルートでは上限調整されません。offset が 0 以上、limit が正であることを呼び出し側で検証してください。`time_range_start` / `time_range_end` は**サポートされません**。指定しても履歴は絞り込まれません。

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**応答:** `HttpResponse<HistoryRecord[]>`。[Task/History のワイヤーフィールド](/guide/api-reference?id=task-fields)を使用します。`HistoryRecord` は SDK の `Task` モデルの履歴ビューを説明する名前です。このビューで `repeatEndCondition` は `null`、`countProgress` は含まれる場合があります。保存された `endTime` は `status` と合わせて解釈します。

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

**並び順:** 保存された終了日が新しい順です。同じ終了日のタイブレーク順は定義されていません。ページネーション中にデータが変わると一貫したスナップショットにならないため、レポート取得中の編集を避け、ページを結合するときは `id` で重複排除してください。

**ページネーションと空の結果:** [共通のページ取得手順](/guide/api-reference?id=pagination)を使ってください。成功した空配列は、そのページ/グループに表示可能なレコードがなかったことを示します。`offset` が末尾を越えた場合も同様です。活動が一度もなかったことを証明するものではありません。削除済みレコードは除外され、完全性フラグもありません。リクエストが失敗した場合はタスク数をゼロとせず、データを取得できない/不完全と報告してください。[共通エラー](/guide/api-reference?id=response-errors)も適用されます。

### 日次レポートを作成 :id=daily-report

1. レポートのタイムゾーンを選びます。暦日の開始 (`dayStart`) と翌日の開始 (`nextDayStart`) を計算します。現地の一日が常に 24 時間とは限りません。
2. `/history` を `offset=0&limit=100` で読み、各応答を確認しながら全ページを収集します。`gid` で絞り込む場合は全ページで一貫させます。
3. `status == 1` と `dayStart <= endTime < nextDayStart` を選びます。結果を説明する際は[記録時刻の制約](/guide/api-reference?id=task-times)を考慮します。
4. 実際の EXP とコイン変動には、同じ日の[報酬履歴](/guide/api-reference?id=reward-journals)を読みます。日付範囲の両端を含むため、`time_range_start=dayStart`、`time_range_end=nextDayStart-1` を指定します。
5. 「利用可能なデータに記録がない」と読み取り失敗/未完了を区別します。正の報酬だけを表示するか、取消を含む純変動を表示するか決め、一貫して適用します。

タスク/履歴の `exp` と `coin` は設定報酬であり、履歴に記録された金額の代わりにはなりません。別の日付に完了時刻を編集しても、報酬履歴の取引時刻が移動するわけではありません。

### 実装の参照先 :id=api-task-queries-sources

[HTTP ルート](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [タスクと履歴の解析](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## EXP とコインの履歴クエリ :id=reward-journals

これらの読み取り専用 HTTP エンドポイントには Read LifeUp Data 権限、LifeUp **1.106.0+**、LifeUp Cloud **3.0.0+** が必要です。タスクに設定された報酬ではなく、減少や取消を含む記録済みの変動を返します。まず[共通規則](/guide/api-reference?id=http-query-reference)を参照してください。

### 両エンドポイントのリクエストパラメーター :id=journal-parameters

以下の仕様は `GET /exp_records` と `GET /coin_records` の**両方**に適用されます。

| パラメーター | 場所 | 型 | 必須 | 既定値 / 実際の動作 |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | いいえ | HTTP 既定値 `0`。プロバイダーは負数を `0` に調整。 |
| `limit` | Query | integer | いいえ | HTTP 既定値 `100`。プロバイダーは `1..200` に調整。共通のページ取得手順では `1..100` を使用。 |
| `time_range_start` | Query | integer (Unix milliseconds) | いいえ、または対で指定 | 取引の記録時刻の下限。境界を含みます。 |
| `time_range_end` | Query | integer (Unix milliseconds) | いいえ、または対で指定 | 上限。境界を含みます。有効な絞り込みには `start < end` が必要です。 |

解析できない、または範囲外のページネーション値は HTTP の既定値になります。解析できない日付値は未指定として扱われます。現行 SDK は両境界が存在し `start < end` の場合にのみ日付範囲を渡し、それ以外は**日付フィルターなし**でクエリします。生の ContentProvider に直接指定した場合は、不正範囲の検証が異なります。HTTP 呼び出し側で境界を検証してください。

両エンドポイントは記録された取引時刻の降順 (新しい順) で並べ、削除済み履歴項目を除外します。ID による同時刻の順序や複数ページのスナップショットは保証しません。プロバイダーの有効な上限を考慮し、[ページネーション](/guide/api-reference?id=pagination)に従ってください。成功した空配列は選択範囲/ページに項目がなかったことを示し、読み取り失敗は活動ゼロを意味しません。削除または取得不能データについての完全性フラグはありません。

### GET /exp_records :id=get-exp-records

EXP の変動を取得します。パラメーターは上記の[4 項目](/guide/api-reference?id=journal-parameters)のみで、`gid` フィルターはありません。

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**応答:** `HttpResponse<ExpRecord[]>`。現行シリアライズでは null 許容値も含め、記載した全フィールドが含まれます。

| フィールド | JSON 型 | 意味 / パーサーの代替値 |
| --- | --- | --- |
| `id` | integer または `null` | 履歴項目 ID。 |
| `time` | integer または `null` | Unix ミリ秒の取引時刻。編集可能なタスク完了時刻とは異なります。 |
| `value` | integer | 関連する各属性の EXP 変動。代替値 `0`。増減方向は `isDecrease` を使用。 |
| `isDecrease` | boolean | 減少なら `true`、増加なら `false`。パーサーはプロバイダー整数 `1` を true として扱います。 |
| `totalValue` | integer | 記録された EXP の集計変動で、**EXP 残高ではありません**。代替値 `0`。複数属性のバッチでは保存合計が重複する場合があります。[レポート合計](/guide/api-reference?id=journal-totals)を参照。 |
| `resCode` | integer | EXP 固有の理由コード。代替値 `0`。 |
| `relatedId` | integer または `null` | 関連する元オブジェクト ID。通常のタスク完了では `gid` でなくタスクレコードの `id`。ほかの理由では別リソースを参照する場合があります。 |
| `content` | string または `null` | 変動の説明。 |
| `skillIds` | integer array | 関連属性/スキル ID。代替値は空配列。 |
| `relatedAttributes` | string array | 関連する旧形式の属性文字列。代替値は空配列。 |

架空の例: 2 つの属性それぞれに 10 EXP を適用し、集計で 20 EXP。

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**エラー:** [共通 HTTP/プロバイダーエラー](/guide/api-reference?id=response-errors)。不正な HTTP 日付境界はエラーにならず、上記のとおり日付フィルターが外れる場合があります。

### GET /coin_records :id=get-coin-records

コイン変動を取得します。パラメーターは上記の[4 項目](/guide/api-reference?id=journal-parameters)のみで、`gid` フィルターはありません。

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**応答:** `HttpResponse<CoinRecord[]>`。現行シリアライズでは null 許容値も含め、記載した全フィールドが含まれます。

| フィールド | JSON 型 | 意味 / パーサーの代替値 |
| --- | --- | --- |
| `id` | integer または `null` | 履歴項目 ID。 |
| `time` | integer または `null` | Unix ミリ秒の取引時刻。 |
| `value` | integer | コイン変動額。代替値 `0`。増減方向は `isDecrease` を使用。 |
| `isDecrease` | boolean | 減少なら `true`、増加なら `false`。パーサーはプロバイダー整数 `1` を true として扱います。 |
| `totalValue` | integer | 操作後のコイン残高。代替値 `0`。EXP の `totalValue` と異なり残高です。 |
| `resCode` | integer | コイン固有の理由コード。代替値 `0`。 |
| `relatedId` | integer または `null` | 関連元オブジェクト ID。通常のタスク完了ではタスクレコードの `id`。ほかの参照元は理由コードで解釈します。 |
| `content` | string または `null` | 変動の説明。 |
| `savingBalance` | integer または `null` | 操作時に記録された貯金残高。 |

架空の例: 5 コインを減らし、残高が 95 コインになった場合。

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**エラー:** [共通 HTTP/プロバイダーエラー](/guide/api-reference?id=response-errors)。不正な HTTP 日付境界はエラーにならず、上記のとおり日付フィルターが外れる場合があります。

### 理由コードとレポート合計 :id=journal-totals

理由コードの体系は異なります。選択例:

| 理由 | EXP `resCode` | コイン `resCode` |
| --- | --- | --- |
| タスク完了 | `1` | `2` |
| タスク完了の取消 | `101` | `3` |
| サブタスク完了 | `12` | `11` |
| サブタスクの取消 | `106` | `12` |
| API による変更 | `200` | `28` |

EXP の全コード：`0` 不明、`1` タスク完了、`2` 実績、`3` いいね交換、`4` 連続使用日数、`5` 歩数交換、`6` 完了に設定、`7` 放棄取消、`8` 期限超過取消、`9` トマトを食べる、`10` アイテム使用、`11` ユーザー実績解除、`12` サブタスク完了、`200` API、`101` 完了取消、`102` 放棄、`103` 期限超過、`104` アイテム使用で EXP 減少、`105` ユーザー実績再ロック、`106` サブタスク完了取消。コインの理由コードは[インベントリ記録](#get-inventory-records)と同じ体系です。将来の未知コードも保持してください。純変動では `isDecrease` で方向を適用し (`true` は記録量を減算)、減少が負の `value` で表されると仮定しないでください。数値型は符号付きであり、符号なし/絶対値の保証はありません。

EXP の `value` は属性ごとの量です。EXP の `totalValue` を記録間で無条件に合計しないでください。現行の複数属性バッチ処理では、3 属性を超える場合に保存合計が重複することがあります。たとえば属性 4 つに各 10 EXP の変更では、安全な合計 40 ではなく、保存値が 40 と 10 になる場合があります。正確な集計では各レコードの属性情報と `value` を照合してください。関連情報が欠ける場合に確認できる内容には限界があります。`value` と `totalValue` を加算せず、EXP の `totalValue` を残高とも説明しないでください。

暦日については現地の `dayStart` と `nextDayStart` を計算し、両端を含むため `[dayStart, nextDayStart - 1]` をリクエストします。タスク報酬だけを報告する場合は理由コードで絞り、全記録変動を報告する場合は絞りません。[日次レポート手順](/guide/api-reference?id=daily-report)。

### 実装の参照先 :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [日付パラメーター転送](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## アイテムとカテゴリ :id=get-items

`GET /items` は `ShopItem[]` を返します。繰り返し指定できる `id` クエリでアイテムを選択します（例：`/items?id=1&id=2`）。整数以外と存在しない ID は除外され、有効な ID は重複も含め指定順を保ちます。すべて無効なら SDK は ID フィルターを送らず、通常の一覧になります。ページネーションはありません。

`GET /items/{listId}` は**カテゴリ内**の `ShopItem[]` を返し、単一アイテムの取得ではありません。`listId` は符号付き 64 ビットのカテゴリ ID で、`-1` や無効な値は全件扱いです。通常一覧は非表示・削除済みアイテムを除外（`isDel=0`）し、ショップ・カテゴリの設定順に並びます。ID 指定取得はこの通常一覧のフィルターから独立しています。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | アイテム ID。 |
| `name` | string | アイテム名。 |
| `desc` | string | 説明。 |
| `icon` | string | 読み取り可能な画像 URI、または空文字列。`/files/{url}` でダウンロードします。 |
| `categoryId` | integer | ショップカテゴリ ID。 |
| `stockNumber` | integer | 在庫数。`maxPurchaseNumber` の計算では負数を無制限として扱います。 |
| `ownNumber` | integer | 所持数。 |
| `price` | integer | コイン価格。 |
| `order` | integer | カテゴリ内に保存された並び順。 |
| `disablePurchase` | boolean | 購入無効フラグ。 |
| `maxPurchaseNumber` | integer or null | 利用可能なコイン、信用枠、有限在庫から算出します。購入無効なら 0、無料かつ無限在庫なら 2147483647 になる場合があります。すべての購入制限規則を評価する計算ではありません。 |
| `titleColorString` | string or null | カスタムタイトル色。 |
| `actionText` | string or null | カスタム使用ボタンの文字列。 |
| `unlist` | boolean | 非表示・削除フラグ。通常の一覧では通常 false です。 |
| `disableUse` | boolean | 使用不可の効果を持つかどうか。 |
| `purchaseLimit` | string or null | 購入制限の設定。ネストした配列ではなく **JSON エンコード済み文字列**です。 |
| `limitScope` | string or null | `purchase`、`use`、`both` のいずれか。 |

### GET /items_categories :id=get-items-categories

`ShopCategory[]` を返します。任意の `include_hidden` は既定で `false`。小文字の `true`・`false` に完全一致する場合のみ解析し、他は false になります。仮想の「すべて」カテゴリを含みます。HTTP には `/items_categories/{id}` はありません。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | カテゴリ ID。 |
| `name` | string | カテゴリ名。 |
| `isAsc` | boolean | 設定された昇順フラグ。 |
| `sort` | string | 保存された並べ替え設定。 |
| `order` | integer | カテゴリの並び順。 |
| `hidden` | boolean | ショップで非表示かどうか。 |
| `inventoryHidden` | boolean | インベントリで非表示かどうか。 |

### GET /tasks_categories :id=get-tasks-categories

「すべて」とアーカイブ済みカテゴリを含む `TaskCategory[]` を返します。クエリパラメーター、ページネーション、`/tasks_categories/{id}` はありません。カテゴリの並べ替え・フィルター値はアプリの保存設定であり、この要求に適用されるフィルターではありません。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | カテゴリ ID。 |
| `name` | string | 名前。 |
| `isAsc` | boolean | 保存された昇順フラグ。 |
| `sort` | string | 保存された並べ替え設定。 |
| `filter` | string | 保存されたグループ分け・フィルター設定。 |
| `order` | integer | カテゴリの並び順。 |
| `status` | integer | 0 通常、1 アーカイブ済み。 |
| `type` | integer | 0 通常。スマートリストは 10 毎日、11 毎週、12 毎月、20 進行中。 |

## 属性と属性グループ :id=get-skills

`GET /skills` は `Skill[]` を返し、パラメーターやページネーションはありません。非表示・削除済み属性を除外し、保存された順序を使います。ContentProvider の `group_id` と `status` は HTTP モデルのフィールドに**含まれません**。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | 属性 ID。 |
| `name` | string | ローカライズされた属性名。 |
| `desc` | string | 説明。 |
| `icon` | string | 読み取り可能なアイコン URI、または空文字列。 |
| `order` | integer | 保存された並び順。 |
| `color` | integer | Android のパック形式の色整数値。 |
| `exp` | integer | 現在の合計 EXP。 |
| `level` | integer | 現在のレベル。 |
| `untilNextLevelExp` | integer | 次のレベルまでに必要な EXP。 |
| `currentLevelExp` | integer | 現在のレベルに到達してから獲得した EXP。 |
| `type` | integer | 0 ユーザー作成、1 筋力、2 学習、3 魅力、4 持久力、5 活力、6 創造性。 |

### GET /skill_groups :id=get-skill-groups

`SkillGroup[]` を返します。`include_hidden` は `/items_categories` と同じ厳密な真偽値解析で、既定は false です。現行アプリのリポジトリはグループではこの指定を無視し、常に削除済みを除外します。保存順の昇順で、ページネーションはありません。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | グループ ID。 |
| `content` | string | グループ名。 |
| `order` | integer | 保存されたグループの並び順。 |
| `collapsed` | boolean | 折りたたみ状態。 |

## 実績 :id=get-achievements

`GET /achievements` はカテゴリ順に各カテゴリを読み込み、実績を結合した `Achievement[]` を返します。`GET /achievements/{id}` は**カテゴリ `id` 内**の実績であり、実績の詳細取得ではありません。無効な ID は未指定と同じ扱いです。各カテゴリ内はその並べ替え設定に従い、どちらもページネーションはありません。

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | 実績 ID。 |
| `name` | string | タイトル。 |
| `desc` | string | 説明。 |
| `iconUri` | string | アイコン URI、または空文字列。 |
| `categoryId` | integer | カテゴリ ID。 |
| `status` | integer | 0 未完了、1 完了して報酬未受領、2 報酬受領済み・その他の完了状態。 |
| `exp` | integer | EXP 報酬。 |
| `coin` | integer | コイン報酬。 |
| `coinVariable` | integer | 変動コイン報酬。 |
| `type` | integer | 0 実績、1 サブカテゴリ見出し。 |
| `progress` | integer | 保存された進捗。 |
| `order` | integer | カテゴリ内の並び順。 |
| `itemId` | integer or null | 最初の報酬アイテム ID（旧形式の補助フィールド）。 |
| `itemAmount` | integer or null | 最初の報酬アイテム数。 |
| `unlockedTime` | integer or null | 解除時刻（Unix ミリ秒）。 |
| `items` | RewardItem[] or null | 報酬アイテムの全一覧。現在のパーサーではアイテム JSON が欠落・不正なら空配列になります。 |
| `color` | string or null | カスタムタイトル色。 |

報酬アイテムには共通の [RewardItem](#reward-item) モデルを使います。

### GET /achievement_categories :id=get-achievement-categories

パラメーターやページネーションなしで `AchievementCategory[]` を返します。HTTP に `/achievement_categories/{id}` はありません。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | カテゴリ ID。 |
| `name` | string | 名前。 |
| `desc` | string | 説明。 |
| `iconUri` | string | アイコンの URI・文字列。 |
| `isAsc` | boolean | 昇順フラグ。 |
| `sort` | string | 保存された並べ替え設定。 |
| `filter` | string | 保存されたグループ分け・フィルター設定。 |
| `order` | integer | カテゴリの並び順。 |
| `type` | integer | 0 ユーザー実績、1 システム実績。 |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

**実績** ID `id` の `AchievementCondition[]` を返します。整数以外の ID は code 500 のエラーエンベロープになります。条件がなければ空配列です。`/achievement_conditions` の一覧ルートはありません。

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | 条件 ID。 |
| `type` | integer | 条件コード。下記を参照。 |
| `relatedId` | integer | 条件に応じた関連タスク・アイテム・属性の ID。 |
| `target` | integer | 目標値。 |
| `current` | integer | 現在の累積値。 |
| `progress` | integer | 保存された進捗。 |

条件コード：0 タスク完了回数、1 現在の連続完了、2 旧属性レベル、3 トマト数、4 使用日数、5 いいね数、6 連続完了日数、7 現在のコイン、8 1 日の獲得コイン、9 タスクのトマト、10 アイテム購入、11 使用、12 箱からの獲得、13 属性レベル、14 人生レベル、15 累積アイテム獲得、16 合成での獲得、17 現在の所持数、18 タスク集中時間、19 ATM 貯金、20 外部 API。繰り返し条件：500 タスク完了、501 属性レベル上昇、502 トマト、503 コイン、504 アイテム獲得、505 購入、506 箱からの獲得、507 合成獲得、508 使用、509 タスク集中分数、510 タスクのトマト、511 いいね、512 ATM 貯金増加、513 外部 API 呼び出し、514 使用日数、515 人生レベル上昇、516 日次コイン、517 連続完了、518 日次トマト、519 日次集中分数、520 日次の異なるタスクグループ数、521 日次使用、522 日次購入、523 指定タスクの日次完了、524 日次完了レコード総数。これらは整数コードであり、シリアライズされた列挙名ではありません。

## 合成 :id=get-synthesis

`GET /synthesis` は表示カテゴリ全体の `Synthesis[]` を返します。`GET /synthesis/{id}` は**カテゴリ `id` 内**のレシピを、そのカテゴリの非表示内容も含め返します。0 以上の ID はカテゴリ、負数は表示カテゴリ全件、無効値は一覧ルート扱いです。削除済みを除外し、保存されたレシピ順の昇順で返します。ページネーションはありません。

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | レシピ ID。 |
| `name` | string | 名前。 |
| `desc` | string | 説明。 |
| `input` | SynthesisItemInfo[] | 必要なアイテム。 |
| `output` | SynthesisItemInfo[] | 生成されるアイテム。 |
| `categoryId` | integer or null | カテゴリ ID。 |
| `canSynthesisTimes` | integer | 現在合成可能な回数。 |

### SynthesisItemInfo :id=model-synthesis-item-info

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `itemId` | integer | アイテム ID。 |
| `itemName` | string | アイテム名。 |
| `amount` | integer | 合成 1 回あたりの入力・出力数量。 |
| `ownedNumber` | integer | 所持数。 |
| `icon` | string | 読み取り可能なアイコン URI、または空文字列。 |

### GET /synthesis_categories と /synthesis_categories/{id} :id=get-synthesis-categories

どちらも `SynthesisCategory[]` を返します。任意のパス `id` はカテゴリ ID の絞り込みで、配列形式は変わりません。無効値なら全カテゴリです。`include_hidden` は小文字の真偽値を厳密に解析し、カテゴリ ID 指定時も既定は false。ページネーションはありません。

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | カテゴリ ID。 |
| `name` | string | 名前。 |
| `isAsc` | boolean | 保存された昇順フラグ。 |
| `sort` | string | 保存された並べ替え設定。 |
| `order` | integer | カテゴリの並び順。 |
| `hidden` | boolean | 非表示フラグ。 |

## 感想 :id=get-feelings

`GET /feelings` は `Feelings[]` を返します。`offset` は既定 0、`limit` は 100。未指定・整数以外も既定値になります。明示的な範囲制限はなく、0 以上の offset と正の limit を使ってください。削除済みを除外し、アプリの感想設定に従って `createTime` の昇順・降順で並びます。要求で並べ替えや時間フィルターは指定できません。

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | 感想 ID。 |
| `content` | string | テキスト。 |
| `isFav` | boolean | お気に入りフラグ。 |
| `title` | string | 関連タイトル。 |
| `time` | integer | 作成時刻（Unix ミリ秒）。 |
| `attachments` | string[] | 存在する空でないファイルの、読み取り可能な添付 URI。 |
| `type` | integer | 0 タスク、1 実績、2 独立した感想。 |

## ポモドーロ記録 :id=get-pomodoro-records

`GET /pomodoro_records` は `PomodoroRecord[]` を返します。`offset` は既定 0、`limit` は 100 で、明示的な範囲制限はありません。任意の `time_range_start`・`time_range_end` は Unix ミリ秒です。両方が 64 ビット整数として解析でき、開始が終了より小さい場合だけ SDK が転送し、それ以外は通知なく範囲を省略します。

範囲なしでは、終了済み・未削除で `startTime != endTime` かつ `endTime` が正のレコードを `endTime DESC, startTime DESC, id DESC` 順で返します。有効な範囲は `start < endTime <= end` を選択し、削除済みを除外します。

> [!WARNING]
> 以前の実装では、日付範囲を指定すると `limit` と `offset` を逆の位置で DAO に渡し、並べ替えも指定していませんでした。ローカルの人升ソースでは名前付き引数に修正し、ページ取得結果を `endTime DESC, startTime DESC, id DESC` で並べ替えています。このローカル修正はまだリリースしていません。インストール済みの人升に修正が含まれることを確認するまでは、確実なページ取得のため範囲を省略し、クライアントでレコードを絞り込んでください。

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | レコード ID。 |
| `startTime` | integer or null | 開始時刻（Unix ミリ秒）。 |
| `endTime` | integer or null | 終了時刻（Unix ミリ秒）。 |
| `duration` | integer | ミリ秒。保存された `lastTime` が 0 以外ならその値、それ以外は終了時刻から開始時刻を引いた値。 |
| `reward` | number | 獲得トマト数。放棄は 0、半分は 0.5 × 倍率、それ以外は倍率。 |

## インベントリ記録 :id=get-inventory-records

`GET /inventory_records` は `InventoryRecord[]` を返します。`offset` は既定 0 で 0 以上に、`limit` は既定 100 で 1–200 に制限されます。`time_range_start`・`time_range_end` は両方が 64 ビット整数で start < end の場合のみ転送し、不正・不完全な範囲は通知なく省略します。有効範囲は両端を含む `time >= start AND time <= end`。削除済みを除外（`isDel` が null または 0）し、`time DESC, id DESC` 順で返します。アイテム ID フィルターはありません。

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | レコード ID。 |
| `time` | integer or null | 作成時刻（Unix ミリ秒）。 |
| `itemId` | integer or null | 関連アイテム ID。 |
| `itemName` | string or null | 取得可能な場合の関連アイテム名。 |
| `changeNumber` | integer | 記録された数量の変化。 |
| `isDecrease` | boolean | 在庫を減らす変更かどうか。 |
| `resCode` | integer | 変更元の理由コード。下記を参照。 |
| `desc` | string or null | レコードの説明。 |

理由コード：0 購入、1 使用、2 タスク完了、3 完了取消、4 データ消去、5 タスク放棄、6 期限超過、7 組み込み実績解除、8 放棄取消、9 期限超過取消、10 返品、11 サブタスク完了、12 その取消、13 ユーザー実績解除、14 その取消、15 預金、16 引出、17 トマト売却、20 アイテム報酬、21 その取消、23 合成、24 箱、25 ATM 利息、26 トマトとアイテムの交換、27 信用利息、28 API、29 アイテム効果による在庫変更。クライアントは将来の未知コードも保持してください。

## 歩数記録 :id=get-step-records

`GET /step_records` は `StepRecord[]` を返します。ページ取得の既定値・制限と SDK の範囲省略規則は `/inventory_records` と同じです。有効な時間範囲は `date` の両端を含み、`date DESC` 順で、明示的な第 2 ソートキーはありません。

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | レコード ID。 |
| `date` | integer or null | 記録された日付（Unix ミリ秒）。 |
| `dailyStepCount` | integer | 1 日の歩数。 |
| `totalStepCount` | integer | 保存された累積歩数。 |
| `isGotReward` | boolean | 報酬受領済みフラグ。 |
| `isUserInput` | boolean | ユーザー入力フラグ。 |
| `rewardLevel` | integer or null | 保存された報酬レベル。 |

## レベル定義 :id=get-level-defines

`GET /level_defines` は単一の `LevelDefines` オブジェクトを返し、パラメーターはありません。カスタムレベルモードならカスタム定義、それ以外は組み込み定義を使います。

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `custom` | boolean | カスタムレベルモード。 |
| `levels` | LevelDefine[] | レベル範囲。 |

### LevelDefine :id=model-level-define

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer or null | 定義 ID。 |
| `levelStart` | integer | 開始レベル。 |
| `levelEnd` | integer | 終了レベル。 |
| `perLevelExp` | integer | 範囲内の各レベルで必要な EXP。 |

不正なレベル JSON は現在、要求全体の失敗ではなく空の `levels` 配列になります。

## 統計 :id=get-statistics

`GET /statistics` は単一の `Statistics` を返します。任意の `time_range_start`・`time_range_end` は Unix ミリ秒で、両方が有効かつ start < end の場合のみ SDK が転送します。範囲なしでは最初の記録から現在まで、記録がなければ過去 30 日です。範囲指定時も `usingDays` と `companionDays` は累計値です。他の指標は各統計メソッドが計算するため、すべての検索で境界の扱いが同じとは限りません。

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `start` | integer or null | 実際の範囲開始（Unix ミリ秒）。 |
| `end` | integer or null | 実際の範囲終了（Unix ミリ秒）。 |
| `tomatoes` | integer | 獲得トマト数の統計。 |
| `pomodoroMinutes` | integer | 集中時間（分）。 |
| `focusCount` | integer | 集中セッション数。 |
| `tasksCompleted` | integer | 完了率の統計に使われる完了タスク数。 |
| `tasksTotal` | integer | 同じ統計に使われるタスク総数。 |
| `taskCompleteRate` | number | 完了率。 |
| `feelingsCount` | integer | 感想数。 |
| `usingDays` | integer | 累計使用日数。 |
| `companionDays` | integer | 累計経過日数。 |
| `interestChanged` | integer | 利息によるコイン変化の統計。 |
| `coinPurchaseConsumed` | integer | 購入で消費したコインの統計。 |

## アプリ情報とコイン残高 :id=get-info

`GET /info` は `Info` を返します。LifeUp Cloud はアプリ・プロバイダー情報に自身のインストール済みバージョンを追加します。パラメーターはありません。

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `appVersion` | integer | インストール済み LifeUp のバージョンコード。 |
| `appVersionName` | string | インストール済み LifeUp のバージョン名。 |
| `apiVersion` | integer | LifeUp API バージョン。 |
| `cloudVersion` | integer | インストール済み LifeUp Cloud のバージョンコード。 |
| `cloudVersionName` | string | インストール済み LifeUp Cloud のバージョン名。 |

### GET /coin :id=get-coin

ContentProvider で `lifeup://api/query?key=coin` を呼び、結果オブジェクトを返します。パラメーターはなく、null は空オブジェクトになります。型付き `CoinData` 応答ではなく、フィールドはプロバイダーが定義します。成功時は `value`（符号付き 64 ビットのコイン残高）と `api_result: true`、失敗時は下記の状態・エラーフィールドを含む場合があります。

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## URL Scheme API の呼び出し :id=invoke-api

[URL Scheme API 一覧](/guide/api)にメソッド名、パラメーター、結果を記載しています。HTTP ブリッジには完全な `lifeup://api/...` URL を渡します。

| 転送方式 | 入力 | 実行と応答 |
| --- | --- | --- |
| `GET /api` | URL エンコード済みの繰り返しクエリ `url` | URL ごとに指定順で Android Activity を起動し、文字列 `success` を返します。URL がなくても成功します。 |
| `POST /api` | JSON `RawQueryVo` | すべての `urls` を先に、その後 `url` があれば起動し、`success` を返します。空オブジェクトでも成功します。 |
| `GET /api/contentprovider` | URL エンコード済みの繰り返しクエリ `url` | プロバイダーを同期呼び出しし、指定順の `CallUrlResult[]` を返します。URL がなければエラーエンベロープ（`No url found`）。 |
| `POST /api/contentprovider` | JSON `RawQueryVo` | すべての `urls`、次に `url` を呼び、`CallUrlResult[]` を返します。空オブジェクトなら空配列です。 |

JSON POST では `Content-Type: application/json` を指定します。GET クエリに埋め込む URL 全体をエンコードし、内部の `&`・`?`・`+`・パーセントエンコードを保ってください。Activity ブリッジの成功は起動要求の送信を示し、LifeUp の処理完了ではありません。ContentProvider は LifeUp 内で Cloud への権限付与が必要で、対応は各メソッドによります。順次実行され、後の呼び出しが失敗しても先の効果は取り消されません。

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity ブリッジの応答：

```json
{"code":200,"message":"success","data":"success"}
```

プロバイダーブリッジの応答例：

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `url` | string or null | 任意の単一 URL。 |
| `urls` | string[] or null | 任意の URL 一覧。`url` より先に処理。 |

### CallUrlResult :id=model-call-url-result

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `url` | string | 送信した URL。 |
| `result` | object or null | 変換後のプロバイダー Bundle。null だけでは HTTP エンベロープは失敗しません。 |

Bundle 変換では Int・Long・Double・String・Boolean とネストした Bundle を保持します。配列は文字列配列、それ以外は `toString()` の文字列になります（Bundle 内の null も文字列 `"null"`）。外側が code 200 でも `result` 内のメソッド失敗フィールドを確認してください。

現行 LifeUp のハンドラーは完了した呼び出しに真偽値 `api_result` を追加します。捕捉した失敗は `api_result: false` と文字列の `error_code`・`error_message` を返します。コードは `missing_required_parameter`、`invalid_parameter`、`entity_not_found`、`invalid_format`、`unsupported_api`、`cancelled`、`internal_error` などで、メソッド独自のコードもあります。バックアップ復元中は `api_result` なしで `error_code: "503"` と `error_message` を返す場合があります。API ハンドラー未登録は変換前に例外となり、外側のブリッジエラーになる場合があります。

## ファイルの読み取りとアップロード :id=files-download

### GET /files/{url} :id=files-get

読み取り可能な URI 全体を 1 つのパス要素として URL エンコードします。Android のコンテンツリゾルバー経由でアイコン、感想添付、バックアップ、アップロードファイルなどを読みます。応答は JSON 成功エンベロープではなくバイトストリームで、ファイル名や MIME 型は指定しません。空・読み取り不可のストリームを構造化した未検出結果には変換せず、例外は共通 HTTP 500 処理になります。空白の一致パラメーターは `url is required` エラーです。

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

`multipart/form-data` を送ります。フィールド名に関係なく全ファイルパートを受け付け、他のパートは無視します。キャッシュファイルには元の名前を使い、なければ `uploaded_image_<time>.jpg`。読み取り可能な content URI の文字列配列を返します。後続 API 用の URI を提供するだけで、アイテムやタスクに自動添付しません。ファイルがなければ `No files received` エラーです。

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## バックアップのエクスポートとインポート :id=files-backup

### GET /data/export :id=files-export

プロバイダー経由でバックアップを作成します。`withMedia` は既定 `true`。指定時は大文字小文字を問わず `true` だけが真、他は偽です。変換済み Bundle に現在 `backup_file_uri` が含まれ、`/files/{url}` で取得できます。GET でもエクスポートを作成します。プロバイダーの状態・エラーフィールドも確認してください。空 URI は使用可能なファイルがないことを示し、null 結果はエラーになります。

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

バックアップを `multipart/form-data` で送ります。複数なら最後のファイルを使い、フィールド名は確認しません。既定名は `backup.lfbak`。任意の `description` は読みますが効果はありません。Cloud はキャッシュ後に LifeUp のバックアップ画面を起動します。応答はアップロードと画面起動の確認で、**復元完了ではありません**。ファイルがなければ `No file received`。

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## イベント :id=get-events

### GET /events :id=get-events-poll

`EventsPage` を返します。`after` はその ID 自体を含まないカーソル（64 ビット整数、既定 0）。`limit` は既定 50、1–200 に制限され、整数以外は既定値です。保持中の `id > after` を古い順で返します。メモリには最大 200 件で、古いものは破棄され、プロセス再起動で ID はリセットされます。`latestId` は全体の最新 ID で、制限されたページの末尾とは限りません。未処理分を飛ばさないよう実際に処理した最後の ID から続けてください。永続履歴や配信確認はありません。

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `latestId` | integer | 現在の最新イベント ID。 |
| `eventWs` | boolean | Cloud の WebSocket 設定。 |
| `events` | CloudEvent[] | カーソル以降の保持イベント。 |
| `broadcasts` | boolean or null | LifeUp のブロードキャスト有効状態。null は不明・未対応。確認結果は 5 秒間キャッシュされます。 |

### CloudEvent :id=model-cloud-event

| フィールド | JSON 型 | 意味 |
| --- | --- | --- |
| `id` | integer | メモリ上のイベント連番。 |
| `time` | integer | Cloud が受信した時刻（Unix ミリ秒）。 |
| `action` | string | Android ブロードキャストアクション。 |
| `extras` | 値が文字列のオブジェクト | ブロードキャスト追加情報を `toString()` で変換。null は空文字列になります。キーはアクションごとに異なります。 |

### WebSocket /events :id=get-events-websocket

`eventWs` が true なら設定したトークン付きで `ws://HOST:PORT/events?after=ID` に接続します。サーバーは保持イベントを再送し、続いて個別の JSON `CloudEvent` テキストフレームでライブ配信します。HTTP エンベロープは**ありません**。再送はメモリ内 200 件までで、WebSocket の `limit` 指定はありません。30 秒ごとに Ping を送ります。再接続は実際に処理した最後の ID を指定してください。無効時はルート未登録ですが HTTP ポーリングは利用できます。

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

購読するアクション：`app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, `app.lifeup.timing.abandon`。イベント収集には LifeUp のブロードキャスト有効化が必要です。`/events` のポーリングは設定を確認するだけで、自動で有効化しません。

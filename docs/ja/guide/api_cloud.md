<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> 現在 **LifeUp v1.106.0** と **LifeUp Cloud v3.0.0** を段階的にリリースしています。プラットフォームの審査スケジュールは地域やストアによって異なるため、ドキュメントが App の一般公開より先に更新される場合があります。ここに記載の内容より実際のリリース日が遅れることがあります。

LifeUp Cloud は LifeUp のコア API ツールキットの一つです。端末を **API ブリッジ** に変え、**PC や他デバイス** から LifeUp を操作したり、**カスタム連携**（デスクトップ、Web、自動化スクリプト）を構築したり、**AI エージェント** と組み合わせたりできます。

### 典型的なシナリオ

| シナリオ | 対象 | 一言で | 詳細 |
| --- | --- | --- | --- |
| **HTTP + 自作** | 開発者、自動化ユーザー | Python、Web App、スクリプトから LAN 経由で API 呼び出しとデータ照会——Android 経験不要 | [HTTP API](#http-api-definition)、[Desktop](guide/api_desktop.md) |
| **QR スキャン** | リアルチェックイン派 | QR を印刷してタスク完了、タイマー開始、ダイアログ表示、Web ページ／他 App 起動 | [QR コードスキャン](#qr-code-scanning) |
| **起動／停止ショートカット** | 自動化、NFC、Tasker | `lifeupcloud://start` と `lifeupcloud://stop` で Cloud を開き HTTP サーバーを起動／停止 | [起動と停止](#cloud-scheme) |
| **AI Agent + MCP** | Cursor、Claude など | 1 プロンプトでタスクリスト、ショップアイテム、実績などを構築 | [MCP & Skills](guide/api_mcp.md) |
> **AI プロンプト例：** サンプルタスクとショップアイテムを消し、インディーゲーム開発者向けの一式——タスクリスト、属性、ショップアイテム、実績——を作成する。

<br/>

## ダウンロード

- 中国本土メンバーシップ版をお使いの場合、`サイドバー` → `設定` → `実験` から LifeUp Cloud のダウンロード入口があります。
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud サービスの起動と停止 :id=cloud-scheme

**Start Service** をタップせず、次の URL スキームで HTTP サーバーを起動／停止できます：

```txt
lifeupcloud://start
lifeupcloud://stop
```

いずれかの URL を開くと LifeUp Cloud が起動し、アクションが適用されます。ホーム画面ショートカット、NFC タグ、Tasker／自動化アクション、または次のように使えます：

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

同じ URL は Cloud ステータスカードにも表示——タップでコピー。

> [!NOTE]
> `lifeupcloud://` は Cloud HTTP サーバー自体を制御します。`lifeup://api/…` のゲーム API ではありません。

<br/>

## QR コードスキャン :id=qr-code-scanning

LifeUp Cloud 上部の **Scan** ボタンは、QR コードにエンコードされた URL を読み取り、すぐに開きます——手入力不要。

スキャンは **LifeUp API に限定されません**：`lifeup://api/…`、Web ページ `https://…`、他 App の URL スキーム（例：`weixin://`）も動作——Android が対応ターゲットを開きます。

### 使い方

1. LifeUp または Wiki の [API 一覧](guide/api.md) から URL を選ぶ（タスク完了、ポモドーロ開始、購入／使用ダイアログ、外部 Web ページを開くなど）。

2. 完全な URL から QR コードを生成（印刷して机、壁、デバイスに貼る）。

3. LifeUp Cloud を開き **Scan** をタップ（横の **?** で App 内の短いガイド）、コードに向ける。

### できること

| シナリオ | 例（参考） |
| --- | --- |
| ポモドーロチェックイン | `lifeup://api/pomodoro?...` でタイマー開始／停止 |
| タスクチェックイン | `lifeup://api/complete?name=...` でタスク完了 |
| ショップ操作 | `lifeup://api/goto?page=shop` または購入／使用ダイアログ |
| 報酬／ペナルティ | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web ミニゲーム | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| 他 App | `weixin://`、`intent://`、インストール済み App の任意スキーム |
| カスタムフロー | スキャン可能な URL の任意組み合わせ |

### リアルワールド連携

QR コードは **物理的な場所やアクション** を App 内ゲーミフィケーションにマッピングします：

- **ジム機器** ステッカー → スキャンで筋トレタスク完了

- **勉強机** ステッカー → スキャンで集中ポモドーロ開始

- **ワークステーション** ステッカー → スキャンでスタンドアップやコードレビューを記録

- **イベントボード** ステッカー → スキャンで報酬受取や実績を開く

要するに：**URL スキームをスキャン可能な物理トリガーに変え**、LifeUp Cloud が App と現実世界の間の実行役になります。

<br/>

> [!NOTE]
> LifeUp Cloud は LAN 専用 HTTP ブリッジです。端末への到達方法——IP アドレス、ルーター、ファイアウォール、同一サブネット、VPN、AP 分離——は自宅ネットワーク次第です。接続できない場合、個人 LAN のデバッグはこちらではできません。ネットワーク設定を確認し、標準的なネットワークツールを使うか、AI エージェントに助けを求めてください。

## HTTP API Definition :id=http-api-definition

> [!WARNING]
> 本ページの API ドキュメントは実装更新に遅れる場合があります。最終参照はソースコード：[KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme Invocation API

#### GET

Function:

> `lifeup://api` で始まる API を呼び出す。

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
| url | `lifeup://api` で始まる API URL | Query | string | Yes | 手動構築時は URL エンコード。複数 `url` パラメータ対応。 |

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

> `lifeup://api` で始まる API を呼び出す。

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
| urls | `lifeup://api` で始まる URL の配列 | Body | List<string> | Yes | JSON 本文では追加 URL エンコード不要。 |

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
> 1. LifeUp v1.91+ と最新 LifeUp Cloud。
> 2. LifeUp Cloud で **Read LifeUp Data** 権限を付与。

Function:

> タスクやアイテムなど LifeUp データセット全体を照会。

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

Envelope: `{ code, message, data }`。`200` はトランスポート OK のみ。`10001` LifeUp 未起動または Read Data 未付与。`10002` ContentProvider 照会失敗。

### List field values

| Endpoint | Field | Values |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` 未完了 · `1` 完了 · `2` 期限切れ · `3` 放棄 |
| `/tasks` | `frequency` | `0` 1 回 · `1` 毎日 · `N>1` N 日ごと · `-1` 無制限 · `-3` エビングハウス · `-4` 毎月 · `-5` 毎年 |
| `/tasks` | `weekdays` | `1,3,5`（月=1 … 日=7）。曜日モード以外は空。v1.106.0+ |
| `/tasks_categories` | `status` | `0` 通常 · `1` アーカイブ |
| `/tasks_categories` | `type` | `<10` 通常 · `10` 毎日 · `11` 毎週 · `12` 毎月 · `20` 進行中 |
| `/achievements` | `status` | `0` ロック · `1` 解除済み、報酬未受取 · `2` 解除済み、受取済み |
| `/achievements` | `type` | `0` 通常 · `1` サブカテゴリ |
| `/achievement_categories` | `type` | `0` ユーザー · `1` システム |
| `/feelings` | `type` | `0` タスク · `1` 実績 · `2` raw · `3` アイテム使用 |
| `/feelings` | `isFav` | bool（CP 0/1） |
| `/skills` | `type` | `0` ユーザー · `1` strength · `2` learning · `3` charm · `4` endurance · `5` vitality · `6` creative |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` 表示 · `1` 非表示（独立フラグ） |
| `/synthesis_categories` | `hidden` | `0` 表示 · `1` 非表示 |
| `/pomodoro_records` | `reward` | `0` 放棄 · `0.5×n` 半分 · それ以外は満額倍数 |
| `/coin_records` `/inventory_records` | `resCode` | Shop: `0` buy · `1` use · `2` finish task · `3` undo finish · `4` clear · `5` give up · `6` overdue · `7` unlock achievement · `8` revoke give up · `9` revoke overdue · `10` return · `11` finish subtask · `12` undo subtask · `13` unlock user achievement · `14` undo user achievement · `15` deposit · `16` withdraw · `17` sell tomatoes · `20` reward item · `21` undo reward item · `23` synthesis · `24` loot box · `25` ATM interest · `26` tomato exchange · `27` credit interest · `28` API · `29` effect stock |
| `/exp_records` | `resCode` | Exp（shop `28` 以外）: `0` unknown · `1` finish · `2` achievement · `3` like exchange · `4` day streak · `5` steps · `6` set finished · `7` revoke give up · `8` revoke overdue · `9` eat tomato · `10` used item · `11` unlock user achievement · `12` finish subtask · `200` API · `101` undo finish · `102` give up · `103` overdue · `104` used item debit · `105` lock user achievement · `106` undo subtask |

`GET /items_categories`、`GET /synthesis_categories`、`GET /skill_groups` は `include_hidden=true` を受け付け（デフォルトでは非表示リスト省略）。実績解除条件：`GET /achievement_conditions/{id}`。スキル `status`（0 通常 / 1 非表示）は `query`/`query_skill` のみ、**`GET /skills` には含まれません**。

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
> Android のストレージ制限により、LifeUp の画像コンテンツを提供する際、LifeUp Cloud がコピーファイルを作成する必要がある場合があります。

Function:

> データ API が返す画像／ファイルリソース（通常 `content://...`）を読み込む。

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

一覧または構造化照会では、`http://{host:port}/api/contentprovider` エンドポイント経由で次の ContentProvider URI を読み取れます。

#### `content://net.sarasarasa.lifeup.provider.api/skills`

表示中のスキルのみ返却。

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

表示中のスキルグループのみ返却。

| Column | Meaning | Type | Notes |
| ------ | ------- | ---- | ----- |
| _ID | Skill group ID | number | - |
| content | Group name | string | - |
| order | Raw sort order | number | `orderInCategory` |
| collapsed | Collapse state | string | Returned as `true` / `false` text |

<br/>

## 貢献

SDK、LifeUp Cloud、LifeUp Desktop はすべてオープンソースプロジェクトです。

ソースコード：

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

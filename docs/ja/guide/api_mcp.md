<h1 align="center" padding="100">MCP & Skills</h1>

AI に LifeUp を扱わせたい場合、2 つのレイヤーがあります：

| | 役割 | 利用者 |
|---|---|---|
| **MCP** `@lifeup/mcp` | LifeUp Cloud の検出、HTTP リクエスト送信、パラメータエンコード、レスポンス解析 | Cursor、Claude Desktop、WorkBuddy、その他 MCP クライアント |
| **Skills** `lifeup-cloud/` | 接続方法、照会内容、各 API の呼び方 | MCP の `help` として同梱；Claude Code / Pi ではフォルダをディスクスキルとして読み込み可能 |

PC 上のエージェントは LAN 経由で端末の LifeUp Cloud に到達し、LifeUp と通信します。HTTP の詳細は [LifeUp Cloud API](guide/api_cloud.md) を参照。MCP ソース：[LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp)。

> [!NOTE]
> **LifeUp 1.106.0** 以降と **LifeUp Cloud 3.0.0** 以降が必要です。古いビルドでも接続できる場合がありますが、ジャーナル、統計、レベル曲線は不完全です。`status.update` でユーザーにアップグレードを促せます。

MCP はエージェントに **読み書き API** を提供し、AI レイヤーが **推論** を担います——今日の未完了タスクの優先順位付け、ジャーナルからの週次統計の要約、属性レベルに基づくタスク設計、または **1 プロンプトでテーマ別ゲーミフィケーション一式を構築**（インディーゲーム開発、魔法学院など）——生データの取得だけにとどまりません。

## こんなふうに聞いてみる

MCP をインストールすれば、API を暗記する必要はありません——AI に話しかけるだけです。

**1 日の計画**

- 「今日残っているタスクは？優先度順に並べて、最初に何から手を付けるべきか教えて。」
- 「約 25 分で終わる未完了タスクを 1 つ選んで。」

**データ分析**

- 「今週のポモドーロ、集中、コイン、経験値の統計を取得して——内訳と傾向を要約して。」
- 「今月コインはどこから入った？最大のソースと意外な点を教えて。」

**コーチングと設計**

- 「属性レベルを見て、弱いスキルを伸ばすための毎日タスク一式を設計して。」

**テーマ一式をワンショット**

- 「サンプルを消してから、インディーゲーム開発者向けの一式を構築して：リスト、ショップ、実績、属性。」
- 「魔法学院 RPG ルーティンを一式設計して——タスク、属性、ショップアイテム、実績。」

**振り返り**

- 「今日完了したことを見て、短いジャーナルを書いて：何をしたか、明日改善できる点。」
- 「Morning Routine という実績リストを作り、絵文字アイコンとコイン報酬付きの実績を 8 件追加して。」
<br/>

## クイックスタート

エージェントに次の 1 行を送ると、MCP のインストールと初回接続ができます：

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills :id=skills

スキルファイルは [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) にあります（リポジトリ内に 1 コピー——別 npm パッケージはありません）。

- **Cursor / Claude Desktop / WorkBuddy：** MCP のみインストール。`help` がこのスキルを読みます；二重インストール不要。
- **Claude Code / Pi / カスタムワークフロー：** フォルダをエージェントの skills パスにコピーするか、リポジトリを直接指定。

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

エージェントは段階的にドキュメントを読みます：

1. `help`（またはディスク上の `SKILL.md`）——全体ワークフロー
2. `help api-index`——利用可能なメソッド
3. `help add_task`——1 メソッドのパラメータ
4. `call_api` / `list_data`——実際の呼び出し

カスタマイズする場合：フォルダをコピーして `SKILL.md` と `references/` を編集。MCP の `help` はフォークから MCP を再ビルドしない限り、同梱コピーを読み続けます。

<br/>

## セットアップ

1. 端末と PC が同一 LAN 上
2. LifeUp 起動中、Cloud に **Read LifeUp Data** を付与済み
3. LifeUp Cloud 起動（デフォルトポート `13276`）
4. PC に [Node.js 20+](https://nodejs.org/)

トークンは任意。設定する場合はヘッダーに **生** トークンを送る——`Bearer` は付けません。

<br/>

## MCP のインストール

npm 公開前は GitHub からインストール：

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

`npx` がリポジトリをクローンし `mcp/` をビルドします。`main` にマージされたら `#feat/mcp` は外してください。

すでに [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) をクローンしている場合はインストーラーを使用（MCP をビルドし検出クライアントを upsert；再実行しても二重登録されません）：

```bash
./scripts/install-mcp.sh
```

デフォルトクライアント：Codex、Cursor、Claude Code、Claude Desktop、Pi。`imports: ["codex"]` の Pi 設定は Codex を継承し重複しません。

macOS の GUI App は `PATH` に `npx` がないことが多い——`npx`/`node` の絶対パスを使うか、クローンして `cd mcp && npm install && npm run build` を実行。

| 変数 | 役割 |
|---|---|
| `LIFEUP_HOST` | 例 `192.168.1.8:13276`、mDNS をスキップ |
| `LIFEUP_TOKEN` | プロセス内のみ、ディスクに書き込まない |
| `LIFEUP_MCP_CONFIG` | カスタム設定パス |

公開後：`npx -y @lifeup/mcp`（中国では npmmirror）。
<br/>

## エージェントワークフロー :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`；TXT の `port` が HTTP ポート。Cloud インスタンスが 1 つだけ見つかれば自動接続。
2. `connect` — 0 件または複数件のとき `host` を渡す。
3. `status` — バージョン確認；1.106.0 / 3.0.0 未満なら `update` に注意。
4. 一覧：`list_data`（デフォルトはコンパクトフィールド）。
5. 書き込み：`complete_task` / `add_task` / `reward` / `purchase_item`；その他は `call_api`。App UI を開くには `via=launch`。

破壊的操作には `confirm: true` が必要。パラメータ値を事前エンコードしないでください。

## イベント

LifeUp：ラボ → Broadcast events を有効化（デフォルトオフ；Cloud Advanced で状態表示と有効化可能）。Cloud の **WebSocket event push はデフォルトオン**（3.0.0+）で、トランスポートのみ。

- `list_events` — `GET /events`、常に利用可能
- `subscribe_events` — `WS /events`；Cloud トグルがオフだとエラー、HTTP は引き続き動作

詳細：MCP `help broadcasts`。

<br/>

---

## 例：インディーゲーム開発者セットアップ

以下は実際の MCP セッションの成果です：ユーザーが AI に **LifeUp 組み込みの開発者サンプルを消去** し、**インディーゲーム開発** をテーマに RPG 風の一式（タスクリスト、属性、ショップ、実績）を構築させました。

次のようなプロンプトから始められます：

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### 構築された内容

| 領域 | 内容 |
| --- | --- |
| タスクリスト | Morning Ritual、Coding Daily、Game Dev、Deep Learning、Learning & Recharge、Wrap-up |
| 属性 | Execution / Technical / Collaboration / Focus / Wellness / Creativity、および **Developer Stats**（Game Design、Debugging、Architecture） |
| ショップ | **Dev Supplies**（消耗品）+ **Fun Collectibles**（イースエッグアイテム） |
| 実績 | **Indie Dev Journey**（Hello World、First Bug Kill、Ship It!、…） |

> [!TIP]
> 画像をクリックすると拡大できます。下のタブで横方向に切り替え、長いページをスクロールせずに閲覧できます。

<!-- tabs:start -->

#### **1 · タスク概要**

**All** ビューでの Morning Ritual 繰り返しタスク。Coding Daily、Game Dev などのカテゴリチップ付き。

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · 属性**

コア 6 属性に **Developer Stats** グループを追加。タスク完了で対応スキルに経験値。

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

イースエッグショップアイテム：Inspiration Dice、RGB Keycap、Desk Cat、LEGO Brick、Retro Gamepad、Rubber Duck——ランダムコインや属性ボーナス付きも。

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · 実績**

マイルストーン実績：初タスク、初バグ修正、デモ公開、連続記録、ポモドーロ、Piggy Bank、Daily Pentakill など——絵文字アイコンと解除条件付き。

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Piggy Bank 詳細**

進捗型条件の例：現在残高 **500 コイン** に到達。

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Daily Pentakill 詳細**

カウンター型条件の例：**1 日で 5 種類のタスク** を完了。

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### AI が通常行うこと

1. `list_tasks` / `list_items` — 既存サンプルを確認；必要なら古い行を削除（破壊的操作は `confirm: true`）。
2. タスク／ショップ／実績リスト（`category`）を作成。
3. 属性とグループ（`skill` / `skill_group`）を作成。
4. タスク、アイテム、実績を一括書き込み（`add_task` / `add_item` / `achievement`）。
5. App の該当画面を更新して確認。

API パラメータは上記 [Skills](#skills) と [エージェントワークフロー](#agent-workflow) を参照；メソッド別テーブルは MCP `help add_task` など。

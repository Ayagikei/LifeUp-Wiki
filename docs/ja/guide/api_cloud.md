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

## LifeUp Cloud に接続する :id=connect

1. 互換性のある LifeUp と LifeUp Cloud をインストールします。Cloud を開き、求められた LifeUp データ・API の権限を付与します。
2. HTTP サービスを開始します。同じネットワークで端末に到達できる機器から、Cloud が表示するアドレスとポートをベース URL に使います。
3. Cloud トークンを設定している場合、`Authorization` ヘッダーに生の値を送ります。`/info` で接続と導入済みバージョンを確認し、HTTP ステータスと JSON `code` の両方を確認します。

## HTTP API リファレンス :id=http-api-definition

[完全なインターフェース・パラメーターリファレンス](/guide/api-reference)に、ルート一覧、共通応答・ページ取得規則、完全なデータモデル、要求パラメーター、JSON 例を記載しています。連携の構築時に参照してください。[URL Scheme メソッド](/guide/api)は個々のアクション、[MCP と Skills](/guide/api_mcp)は AI エージェントのツールを説明します。

### タスクと履歴のタイムスタンプ :id=task-history-timestamps

[タスク時刻モデル](/guide/api-reference?id=task-times)を参照してください。`startTime` は予定開始、`deadline` は期限、履歴の `endTime` は記録された完了・期限超過・放棄の時刻で、`status` と合わせて解釈します。

#### 日次レポートと履歴の完全性 :id=history-daily-reports

[履歴ページ取得と日次レポート](/guide/api-reference?id=daily-report)、および実際の報酬変化を示す [EXP・コイン台帳](/guide/api-reference?id=reward-journals)を参照してください。

## 貢献

SDK、LifeUp Cloud、LifeUp Desktop はすべてオープンソースプロジェクトです。

ソースコード：

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

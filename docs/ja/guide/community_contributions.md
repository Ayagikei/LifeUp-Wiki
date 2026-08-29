## コミュニティ貢献 🤝

LifeUp の機能を拡張するツールを作ってくれたコミュニティに、心から感謝しています。以下は公式ツールキットと注目のコミュニティプロジェクトです。

## 公式ツールキット

| プロジェクト | 説明 |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | 端末側 HTTP API ブリッジ；LAN アクセスと **QR スキャン**（`lifeup://`、Web URL、その他 App スキーム） |
| [@lifeup/mcp](guide/api_mcp.md) | Cursor、Claude Desktop などの AI エージェント向け公式 MCP サーバー + Skills（LAN 経由） |
| [LifeUp Desktop](guide/api_desktop.md) | LifeUp Cloud HTTP 上に構築された公式デスクトップクライアント |
| [Wordle 連携デモ](example/wordle/index.html) | 単語当てミニゲーム；勝利時に `lifeup://api/reward` を呼び出し |

**Wordle の設定：** ショップアイテムを作成 → タイプ 9 のリンク効果で Wordle ページを指定 → **使用** でブラウザでゲームを開く；勝利で 10 コイン、敗北でも参加賞コイン。Wordle URL を QR コードにエンコードして LifeUp Cloud でスキャンすることもできます。詳細は [API · 外部 Web（Wordle）](guide/api.md) を参照。

<br/>

## コミュニティプロジェクト

| プロジェクト | 説明 | 作者 |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | 初期のコミュニティ MCP サーバー（公式 `@lifeup/mcp` により置き換え）。 | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Obsidian ↔ LifeUp プラグイン：To-do 同期、振り返り同期、Obsidian 内 LifeUp データダッシュボード。*注：中国語のみのリポジトリ。* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **何か面白いものを作りましたか？** LifeUp 向けのツール、スクリプト、連携を開発した場合は、GitHub Issues またはメールでお知らせください！

<h1 align="center" padding="100">オープンインターフェース</h1>

<p align="center">無限の可能性を創り出そう！</p>

> [!NOTE]
> 現在 **LifeUp v1.106.0** と **LifeUp Cloud v3.0.0** を段階的にリリースしています。プラットフォームの審査スケジュールは地域やストアによって異なるため、ドキュメントが App の一般公開より先に更新される場合があります。ここに記載の内容より実際のリリース日が遅れることがあります。

?> v1.90 バージョンより、`LifeUp` はさまざまな機能インターフェースを公開しており、外部アプリケーションとの連携を歓迎しています。<br/>ショップアイテムの「URL」効果も提供されており、ユーザーは商品を使って直接外部アプリや `LifeUp` のインターフェースを呼び出せます。<br/>これらの機能により `LifeUp` に無限の可能性を持たせられますが、少し学習と実践が必要です。

**最終更新: 2026/08/28**

本ドキュメントの API パラメータと定義は、バージョン **v1.106.0** に基づいています。

最新 API を使用する前に、アプリが **v1.106.0** に更新されていることを確認してください。

更新は Google Play 経由で段階的に配信されています。まだ届いていない場合は、しばらくお待ちください。

## シナリオ例

| 呼び出し元 | シナリオ | 備考 |
| ------ | -------- | ----- |
|**LifeUp → 他アプリ**<br/>ショップアイテムの「URL」効果で実装| **ショップアイテム使用後:**<br/>1. ブラウザで Web ページを開く<br/>2. WeChat にジャンプしてスキャン、または特定のミニプログラムを指定<br/>3. 記帳レコードを自動追加（[「Qianji」は記帳インターフェースに対応](http://docs.qianjiapp.com/plugin/auto_tasker.html)）<br/>4. 自動化ツール Tasker の設定を保存（マーケットで共有も可能）し、使用後に Tasker へ設定を自動インポート<br/>5. Tasker を起動して壁紙を変更<br/>6. …（外部アプリがこの呼び出し方式に対応していれば可能） | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) は自動化ツールで、設定を Uri としてエクスポートできます |
|**LifeUp → LifeUp**<br/>ショップアイテムの「URL」効果で実装| **ショップアイテム使用後:**<br/>1. 特定ページを開く<br/>2. ATM 金利を引き上げる<br/>3. ポップアップで商品を選ばせ、商品価格を下げる（値引きクーポン）<br/>4. タスク完了をトリガー<br/>5. カスタムモチベーションメッセージをポップアップ<br/>6. タスク報酬テンプレートを作成：名前を入力するだけでタスクを自動作成<br/>7. ポップアップで分岐選択をユーザーに求め、小さな文脈インタラクションを作成<br/>8. その他のアプリ内操作… |  |
|**外部アプリ / Web ページ → LifeUp** | **自動化ツールの設定:**<br/>1. 毎日初めてスマホの電源を入れたタイミングを検知し、早起きタスクを完了、または「遅起き」ペナルティを直接トリガー<br/>2. 25 語ごとに特定 NFC カードをスワイプし、タスクを自動完了<br/>3. GPS で新しい場所に到達したことを判定し、「新しい場所」実績をアンロック<br/>4. 毎日職場 Wi-Fi に接続したとき、アンロック条件の進捗を増やす。20 日累積で「Worker」実績をアンロック<br/>5. 毎日初めて自宅 Wi-Fi に接続したとき、「帰宅」コインを報酬<br/>6. 他のポモドーロや集中 App からの通知をキャプチャし、計測記録を `LifeUp` に自動記録<br/>7. 運動・学習ソフトの完了または終了通知をキャプチャし、「strength」「knowledge」の経験値を自動付与<br/>8. 自分で設定した時間帯内で、スマホを開くたびにペナルティをトリガー<br/>9. …<br/>**外部アプリ連携 / 自作アプリ:**<br/>1. `LifeUp` のポモドーロに不満がある場合：独自の計測ソフト（Web アプリや Android アプリ）を開発し、インターフェース経由で「LifeUp」と連携して計測記録や報酬を追加<br/>2. 一部の知恵ミニゲーム（下記 Wordle 例など）を改造し、ゲーム成功時に `LifeUp` で報酬を送信<br/>3. … |  |

<br/>言い換えると、上記のシナリオはすべて「イベント」が「アクション」をトリガーする形です。

今回の `LifeUp` 更新では「アイテム使用」というイベントトリガーを提供し、さまざまな「アクション」（報酬、タスク完了など）を提供します。

次のようなイベントが必要な場合：

- Web ボタンのクリック
- NFC カードのスワイプ
- 毎朝、初めて画面ロックを解除

外部アプリの介入が必要です。例えば自作の二次開発、または `Tasker` や `MacroDroid` などの自動化ツールを使用します。

**LifeUp 1.90.2 更新では一連の「イベント」が追加されますが、これらは自動化ツールや外部アプリが受信できます。**

次のような実現が可能です：

アイテム使用後、Tasker などの自動化ツールをトリガーしてランチャーの壁紙を切り替える。

タスク完了後、Tasker などの自動化ツールをトリガーしてアプリを開く。

**1.90.2 バージョンでは、「LifeUp イベント」が「Tasker の操作」をトリガーできます。**

Tasker は非常に高い権限を持ち、壁紙変更、アプリのアンインストール、音量上げ、指定アプリの起動などが可能です。プログラミングの基礎がなくても UI インタラクションロジックを書けます。

---

## おすすめ

**プログラミングに不慣れな場合**、[World] → [Market] → [Link] / [API] / [Automate] タグで専用ショップアイテムを検索してインポートできます。パラメータを編集してニーズに合わせることも試せます。

**コンピュータの知識がある場合**、以下のインターフェースドキュメントを読み、希望する効果を自分で編集してみてください。[*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm) などの自動化ソフトと組み合わせて使えます。Tasker の設定を編集できなくても、Tasker のインストールに成功すれば、Market や他コミュニティで共有された自動化設定をインポートできます。

**プログラミングの基礎がある場合**、Web ページや Android アプリを開発して LifeUp と統合してみてください。この Web ページやカスタム版 Wordle が例です。自動化ツールの設定を作成して共有することも歓迎します。

---

## 他アプリの呼び出し

*LifeUp* 内で外部アプリを呼び出すには、ショップアイテムに「Link」効果を追加し、**Web ページまたはアプリ固有のリンク**を入力して、ショップアイテムを使用して呼び出しをトリガーするだけです。

**以下はいくつかの例です（「World」→「Market」→「Link」でインターフェース呼び出し効果のある公開アイテムも確認できます）:**

- ブラウザで Google を開く: https://www.google.com
- Facebook: [fb://](fb://)
- パッケージ名 / アプリ ID でアプリを開く: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- …

理論上、外部 APP が URL を提供していれば、ショップアイテムでジャンプできます。

**Google で `URL Schemes` を検索すると、必要なアプリリンクを探せます。**

**これらのリンクは `LifeUp` とは無関係で、`LifeUp` はジャンプ URL 機能のみを提供します。**

**そのため URL 一覧は提供・保守していません。ただし [World] → [Market] → [Link] ページでリンク効果を含む公開ショップアイテムは確認できます。**

アプリのパッケージ名（ID）の確認方法：

- Play Store の URL: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- アプリ管理 App を使用
- Tasker の App Info アクションを使用
- Macrodroid の Launch App アクションを使用

---

## LifeUp API の呼び出し

次の場合：

- `LifeUp` 内で `LifeUp` インターフェースを呼び出す：ショップアイテムに「link」効果を追加し、API ドキュメントに従って **特定の URL** を入力し、ショップアイテムを使用して呼び出しを完了します。
- Web ページから呼び出す：ハイパーリンクで LifeUp API にジャンプするだけです。
- 自作 APP から呼び出す：Intent で対応するインターフェースリンクにジャンプするだけです。
- 自動化ツール（Tasker など）から呼び出す：Tasker の Browser URL に対応する API リンクを入力します。

**いくつかの例:**

下のリンクをクリックすると、「LifeUp」に「API の呼び出し方を覚えました！」と表示されます。

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

下のリンクをクリックすると、「LifeUp」でコイン 1 枚を獲得し、理由は「Learn API Calls」になります。

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

リンクをアイテムの「link」効果にコピーすれば、アイテム使用でも同じ効果をトリガーできます。

**外部アプリ連携の例:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle は 5 文字の単語を当てる小さな言葉当てゲームです。オレンジは答えにその文字が含まれることを示し、緑は含まれていて正しい位置にあることを示します。

**この版 Wordle は「LifeUp」と連携できます:**

1. 単語を正しく当てると 10 コインを獲得。カスタム理由も設定できます。
2. 最終的に当てられなかった場合、1 コインの参加賞があります。

![](_media/api/wordle.png ':size=30%')

<br/>

**Tasker との連携例:**

> Tasker は `Action Category` → `Program` → `Shortcut` を選択して呼び出します。ショートカット欄に lifeup:// で始まるリンクを入力します。

毎日 5 時以降、初めて画面ロックを解除すると、指定したタスク（早起きなど）の完了をトリガーできます。

**注: この設定をインポートするには Task Group Id が必要です。[Settings] → [Labs] で [Developer Mode] をオンにし、タスク詳細ページで gid を確認してください。**

Tasker がインストールされている場合、[ここをクリックして設定済みタスクをインポート](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)できます。

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**MacroDroid で LifeUp API を呼び出す方法:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) も自動化ツールで、無料ダウンロードでき UI も使いやすいです。

1. マクロを追加し、必要な条件を設定（後から設定も可）
2. `Actions` を追加
3. `Applications` を選択
4. `Open Website` を選択
5. `Enter URL` 欄に `lifeup://` で始まる URL を入力
6. 下の `URL encode parameters` などのオプションは **すべてオフ**
7. 保存後、アクションをクリックし `Test action` で検証

<br/>

**この機能により、プログラミングの有無にかかわらず LifeUp の可能性を無限に広げられます！**

具体的な呼び出しルールは以下を参照してください。

---

## インターフェースドキュメント

### Basics - Examples

| 種類             | 説明   |
| ---------------- | ------------- |
| 例          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| インターフェース形式 | 固定プレフィックス/メソッド名?parameter1=value1&parameter2=value2 |
| 固定プレフィックス     | lifeup://api/ |
| メソッド名      | toast         |
| パラメータ       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

パラメータ値に +、スペース、=、%、&、# などの特殊記号が含まれる場合、エスケープが必要です：

| 特殊文字 | 意味                                         | 置換後 |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | URL 内の + はスペースを表す        | +          |
| spaces             | URL 内のスペースは + またはエンコード              | %20        |
| /                  | ディレクトリとサブディレクトリの区切り            | %2F        |
| ?                  | 実際の URL とパラメータの区切り         | %3F        |
| %                  | 特殊文字の指定                      | %          |
| #                  | ブックマークを意味する                                  | %23        |
| &                  | URL で指定するパラメータ間の区切り   | %26        |
| =                  | URL でパラメータ値を指定する記号 | %3D        |

上記ポップアップメッセージのインターフェースを例に、最終表示テキストを `You have learned to call APIs!` にしたい場合、スペースを + に置換し、最終的に次のようになります：

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Javascript で実装した簡易エンコードツール:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

LifeUp 内のほぼすべてのデータ保存には一意の id があります。

以下のインターフェースの一部は、**指定した**ショップアイテムの変更や **指定した**タスクの完了をサポートします。

`LifeUp` が対応データを見つけるには id の提供が必要です。

**「Settings」→「Labs」→「Developer Mode」を有効にすると、アプリ内の各詳細ページでデータの元 id を確認できます。**

例えば「strength (1)」のように表示される属性名の属性 id は 1 です。

#### Task id

イベント詳細ページで確認できます。

id: 繰り返しタスクの場合、繰り返すたびに id が更新されます。

gid: アイテムグループの id。同じ繰り返しタスクでは gid は変わりません。

#### List id

「Developer Mode」を有効にしたうえで、「Select List」ポップアップで確認します。

#### Attribute id

「Developer Mode」を有効にしたうえで、「Custom Attributes」ページで確認します。

#### Shop item id

「Developer Mode」を有効にしたうえで、ショップアイテムをクリックして詳細を表示します。

#### Achievement condition id

実績の「外部 API 呼び出しでアンロックが必要」というカスタムアンロック条件を設定した後、詳細ページで条件 id を確認できます。

<br/>

### Basics - Name Matching

API が名前でタスク、ショップアイテム、サブタスクを検索する場合、LifeUp はまず大文字小文字を無視した完全一致を試みます。完全一致がなければ、あいまいな部分一致にフォールバックします。

例えば「Coin」と「Coin Box」の両方がある場合、`name=Coin` を渡すと、先に現れたあいまい一致ではなく「Coin」に一致します。

重複や類似名で曖昧になる可能性がある場合は、対応する id を渡すことを推奨します。

<br/>

### Basics - Return Values

一部のインターフェースには戻り値があります。

**Android アプリを開発している場合**、`onActivityResult` メソッドで戻り値を受け取れます。

**Tasker などの自動化アプリを使用している場合:**

一般に、この種のアプリは Activity 型の戻り値を受け取れません。`broadcast` パラメータを追加し、`received intent` イベントで戻り値を受け取る必要があります。

詳細は下記の broadcast パラメータを参照してください。

<br/>

### Basics - JSON Data Structure

?> v1.98.0 以降が必要

本セクションでは API でよく使う JSON データ構造を説明します。

#### 1. Item Reward Structure

アイテム報酬を指定する JSON 配列。各要素に ID と数量を含みます。

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Achievement Unlock Condition Structure

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Purchase Limit Structure

`purchase_limit` は JSON 配列です。各オブジェクトが 1 つの制限ルールを表します。

| Field | Meaning | Type | Required | Notes |
| ----- | ------- | ---- | -------- | ----- |
| limitType | 制限タイプ | number | Yes | 下記タイプ表を参照 |
| limitNumber | 主な数値 | number | No* | 数量 / 範囲ベースのルールで使用 |
| maxNumber | 範囲の上限 | number | No | 属性レベル範囲 / 所持アイテム数量範囲で使用 |
| limitId | 関連対象 ID | number | No* | 属性 / アイテム / タスク / タスク周期 / 実績ベースのルールで必須 |
| extendInfo | 追加ペイロード | string | No | 時間ベースのルールで使用；値自体は JSON 文字列 |

**タイプ定義**

| limitType | Meaning | Required fields / notes |
| --------- | ------- | ----------------------- |
| 0 | 1 日の数量制限 | `limitNumber`: 1 日あたりの最大回数 |
| 1 | 週間数量制限 | `limitNumber`: 週あたりの最大回数 |
| 2 | 月間数量制限 | `limitNumber`: 月あたりの最大回数 |
| 3 | 年間数量制限 | `limitNumber`: 年あたりの最大回数 |
| 10 | 属性レベルルール | `limitId`: attribute ID<br/>`limitNumber`: 最小レベル<br/>`maxNumber`: 任意の最大レベル |
| 20 | 1 日の時間帯 | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | 曜日選択 | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>月曜 = 1、日曜 = 7 |
| 22 | 絶対時間範囲 | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | 月選択 | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | 日付（月内）選択 | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | 所持アイテム数量ルール | `limitId`: target item ID<br/>`limitNumber`: 最小所持数<br/>`maxNumber`: 任意の最大所持数 |
| 31 | タスク完了ルール | `limitId`: task ID |
| 32 | 実績アンロックルール | `limitId`: achievement ID |
| 33 | タスク周期完了ルール | `limitId`: repeat task group ID (`groupId`)<br/>そのグループで最新に開始された周期に対して検証 |

**Notes**

- `limitType=33` の場合、`limitId` はタスク ID ではありません。繰り返しタスクの `groupId` を指定する必要があります。

- 後方互換ペイロードでは `maxNumber` と `extendInfo` を省略できます。
- `extendInfo` は文字列フィールドのため、URL 経由で API を呼ぶ場合、内部の JSON 文字列は通常さらにエスケープ / エンコードが必要です。

**Example:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Item Effect Structure

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Effect Type Description

?> タイプ 10–16 は v1.102.0 以降でサポート

| Type Code | Meaning | Parameter Description |
| ------- | ---- | ------- |
| 0 | 特殊効果なし | パラメータなし |
| 1 | 使用不可 | パラメータなし |
| 2 | コイン追加 | min: Minimum coins<br/>max: Maximum coins (optional, defaults to min)<br/>using_limit: Whether to apply system limits (optional) |
| 3 | コイン削除 | min: Minimum coins<br/>max: Maximum coins (optional, defaults to min)<br/>using_limit: Whether to apply system limits (optional) |
| 4 | 経験値追加 | ids: Skill ID array<br/>value: Experience value (legacy, same as min)<br/>min: Minimum experience (optional, if value is not provided)<br/>max: Maximum experience (optional, defaults to min/value)<br/>using_limit: Whether to use limit (optional, default false) |
| 5 | 経験値削除 | ids: Skill ID array<br/>value: Experience value (legacy, same as min)<br/>min: Minimum experience (optional, if value is not provided)<br/>max: Maximum experience (optional, defaults to min/value)<br/>using_limit: Whether to use limit (optional, default false) |
| 6 | 簡易合成 | require_number: Required quantity<br/>item_id: Item ID |
| 7 | 戦利品箱を開く | items: Item array, each item contains:<br/>- item_id: Item ID<br/>- amount: Quantity<br/>- probability: Probability<br/>- is_fixed_reward: Whether it is a fixed reward |
| 8 | Countdown | seconds: Countdown seconds |
| 9 | Web link | url: Link address<br/>use_web_view: Whether to use the built-in browser (optional, default false) |
| 10 | 気分を記録 | パラメータなし |
| 11 | コイン変更（増減） | min: Minimum coins (can be negative)<br/>max: Maximum coins (optional, defaults to min)<br/>using_limit: Whether to apply system limits (optional) |
| 12 | 経験値変更（増減） | ids: Skill ID array<br/>value: Experience value (legacy, same as min)<br/>min: Minimum experience (can be negative)<br/>max: Maximum experience (optional, defaults to min/value)<br/>using_limit: Whether to use limit (optional, default false) |
| 13 | アイテム在庫追加 | item_id: Target item ID<br/>min: Minimum stock change<br/>max: Maximum stock change (optional, defaults to min)<br/>using_limit: Whether to apply stock limits (optional) |
| 14 | アイテム在庫削除 | item_id: Target item ID<br/>min: Minimum stock change<br/>max: Maximum stock change (optional, defaults to min)<br/>using_limit: Whether to apply stock limits (optional) |
| 15 | アイテム在庫変更（増減） | item_id: Target item ID<br/>min: Minimum stock change (can be negative)<br/>max: Maximum stock change (optional, defaults to min)<br/>using_limit: Whether to apply stock limits (optional) |
| 16 | サウンド再生 | file_name: Local sound file name (preferred)<br/>uri: Sound URI to import (alternative to file_name)<br/>display_name: Display name (optional) |

**効果の例:**

ランダムにコインを増加:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

経験値を増加:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

コインを変更（ランダム +/-）:

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

アイテム在庫を変更（ランダム +/-）:

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

サウンド再生:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

戦利品箱効果:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>
### ポップアップメッセージ

**Method name:** toast

**Description:** さまざまなスタイルのメッセージがポップアップ表示されます

**Example:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Explanation:** 「Live well, eat well!」というメッセージが報酬スタイルでポップアップし、長めに表示されます。

> 例のリンクをクリックして効果をテストできます

| Parameter | Meaning                | Type               | Example              | Required | Notes |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | 表示するテキストメッセージ | Any text           | You learned to call! | yes      |       |
| type      | テキストスタイルの種類        | Number from 0 to 6 | 1                    | no       | 0 - 通常スタイル<br/>1 - 報酬スタイル<br/>2 - トマトスタイル<br/>3 - 成功スタイル<br/>4 - プロンプトスタイル<br/>5 - 警告スタイル<br/>6 - エラースタイル |
| isLong    | 表示時間       | true or false      | true                 | no       | true - 長<br/>false - 短 |

<br/>

### 報酬

**Method name:** reward

**Description:** 報酬を直接付与します。報酬の理由はカスタマイズできます。

**Example:**

- コイン 1 枚を獲得し、理由は「Learn API Calls」。理由はコイン詳細ページに表示されます：

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- 「Learning, Creativity」の経験値 300 点を獲得し、理由は「Learn API Calls」。理由は経験値詳細ページに表示されます：

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- あいまい一致で「treasure」アイテムを 1 個獲得し、理由は「Learn API Calls」。理由はインベントリ履歴ページに表示されます：

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parameter | Meaning                       | Type                            | Example            | Required | Notes                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | 報酬タイプ                   | currently only supported following values: <br/>coin<br/>exp<br/>item | coin | yes | coin - コイン<br/>exp - 経験値<br/>item - ショップアイテム |
| content   | 報酬理由                 | any text                        | Learning API Calls | Yes      |                                  |
| skills    | スキル（属性）           | array of numbers greater than 0 | 1                  | No       | type が exp の場合のみ利用可能<br/>配列に対応（例 &skills=1&skills=2&skills=3）<br/>取得方法は上記「Basics - LifeUp Data ID」を参照 |
| number    | 報酬数量             | a number greater than 0         | 1                  | Yes      | コインの場合、最大値は 999999<br/>経験値の場合、最大値は 99999<br/>アイテムの場合、最大値は 999 |
| item_id   | item id                       | number greater than 0           | 1                  | no*      | type が item の場合のみ利用可能 |
| item_name | アイテム名                     | any text                        | treasure           | no*      | type が item の場合のみ利用可能。アイテム名とあいまい一致 |
| silent    | UI プロンプトを無効にするか | true or false                   | false              | no       | デフォルトは false                 |

<br/>

### ペナルティ

**Method name:** penalty

**Description:** ペナルティを直接適用します。ペナルティの理由はカスタマイズできます。

**Example:** *基本的に報酬インターフェースと同じ

- コイン 1 枚をペナルティとし、理由は「sleep in」。理由はコイン詳細ページに表示されます：

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- 「Strength」の経験値 300 点をペナルティとし、理由は「sleep in」。理由は経験値詳細ページに表示されます：

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- あいまい一致で「treasure」アイテム 1 個をペナルティとし、理由は「sleep in」。理由はインベントリ履歴ページに表示されます：

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parameter | Meaning                       | Type                                                 | Example  | Required | Notes            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | ペナルティタイプ                  | Currently only supported: <br/>coin<br/>exp<br/>item | coin     | yes      | coin - コイン<br/>exp - 経験値<br/>item - ショップアイテム |
| content   | ペナルティ理由            | any text                                             | Sleep In | Yes      |                  |
| skills    | スキル（属性）           | array of numbers greater than 0                      | 1        | No       | type が exp の場合のみ利用可能<br/>配列に対応（例 &skills=1&skills=2&skills=3）<br/>取得方法は上記「Basics - LifeUp Data ID」を参照 |
| number    | ペナルティ数量             | a number greater than 0                              | 1        | Yes      | コインの場合、最大値は 999999<br/>経験値の場合、最大値は 99999<br/>アイテムの場合、最大値は 999 |
| item_id   | item id                       | number greater than 0                                | 1        | no*      | type が item の場合のみ利用可能 |
| item_name | アイテム名                     | any text                                             | treasure | no*      | type が item の場合のみ利用可能。アイテム名とあいまい一致 |
| silent    | UI プロンプトを無効にするか | true or false                                        | false    | no       | デフォルトは false |

<br/>

### コイン編集

**Method name:** edit_coin

**Description:** ユーザーのコイン残高を直接編集します。現在のコイン数は指定値に設定されます。変更理由はカスタマイズでき、コイン履歴に表示されます。

**Example:**

- コインを 1000 に設定し、理由は「API adjustment」：<a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- サイレントでコインを 500 に設定：<a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | 目標コイン数 | number >= 0 | 1000 | Yes | 操作後の最終コイン残高。最大値は 999999 |
| content | 変更理由 | any text | API adjustment | No | 未指定時はシステムデフォルトの理由を使用 |
| reason | 変更理由（別名） | any text | API adjustment | No | content パラメータの別名 |
| silent | UI 通知を無効化 | true or false | false | No | デフォルトは false。true にすると toast メッセージを抑制 |

<br/>

### タスク

#### タスクを追加

?> `pin` など一部フィールドは v1.98.0 以降が必要

**Method name:** add_task

**Description:** タスクを直接作成します

**Example:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parameter         | Meaning             | Values                | Example   | Required | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | タスク内容        | any text             | Write diary | Yes     |                                |
| notes            | 備考               | any text             | Notes      | No       | デフォルトは空               |
| coin             | コイン報酬         | number >= 0         | 10         | No       | デフォルトは 0。システム上限の対象                   |
| coin_var         | コイン報酬の変動幅| number >= 0          | 1          | No       | デフォルトは 0；>0 の場合、[coin, coin+coin_var] の範囲でランダム報酬 |
| exp              | 経験値報酬   | number >= 0          | 100        | No       | デフォルトは 0。システム上限の対象                   |
| skills           | スキル ID           | array of numbers > 0 | 1          | No       | 配列に対応（例 &skills=1&skills=2） |
| category         | リスト ID             | number >= 0          | 0          | No       | デフォルトは 0（デフォルトリスト）。スマートリストは不可 |
| frequency        | 繰り返し頻度    | integer              | 0          | No       | デフォルトは 0（1 回）<br/>0 - 1 回<br/>1 - 毎日<br/>N (N>1) - N 日ごと<br/>-1 - 無制限<br/>-3 - エビングハウス（v1.99.1 以降）<br/>-4 - 毎月<br/>-5 - 毎年 |
| weekdays         | 曜日            | `1,3,5` or `none`    | 1,3,5      | No       | v1.106.0+；1=月曜 … 7=日曜、**繰り返す**曜日。指定時は frequency を省略するか 1 にする必要あり。add では `none` は拒否；edit では `none` で毎日に戻す。7 日すべて指定時は毎日として扱う |
| importance       | 重要度    | [1, 4]              | 1          | No       | デフォルトは 1                   |
| difficulty       | 難易度    | [1, 4]              | 1          | No       | デフォルトは 1                   |
| deadline         | 期限            | timestamp (milliseconds) | 1640995200000 | No |                               |
| no_deadline      | 期限なし         | true/false         | true      | No       | v1.104.0+；繰り返しタスクのみ有効。`&no_deadline=true` を渡すと具体的な期限をクリア |
| color            | タグ色           | color string         | #66CCFF    | No       | # は %23 にエスケープ        |
| background_url   | 背景画像 URL| web URL             | http://example.com/bg.jpg | No | アクセス可能な Web 画像である必要あり |
| background_alpha | 背景の不透明度  | float between [0, 1] | 0.5        | No       | デフォルトは 1.0                |
| enable_outline   | テキスト輪郭を有効化 | true or false       | false      | No       | background_url 指定時のみ有効。可読性向上のためテキストに輪郭を追加 |
| use_light_remark_text_color | 備考を明るい色で表示 | true or false | false | No | background_url 指定時のみ有効。備考テキストを明るい色で表示 |
| start_time       | 開始時刻          | timestamp (milliseconds) | 1640995200000 | No | タスク開始時刻              |
| auto_use_item    | 報酬アイテムを自動使用| true or false      | false      | No       | 完了時に報酬を自動使用 |
| remind_time      | リマインダー時刻       | timestamp (milliseconds) | 1640995200000 | No | タスクリマインダー時刻          |
| pin              | タスクをピン留め            | true or false       | false      | No       | タスクを上部に固定                |
| words            | 完了報酬テキスト | any text         | Great job! | No       | タスク完了時に表示するモチベーションテキスト |
| frozen           | 凍結状態       | true or false       | false      | No       | デフォルトは false              |
| freeze_until     | 凍結期限        | timestamp (milliseconds) | 1640995200000 | No | frozen が true の場合のみ有効 |
| coin_penalty_factor | コインペナルティ係数| float between [0, 100) | 0.5    | No       |                               |
| exp_penalty_factor | 経験値ペナルティ係数| float between [0, 100) | 0.5 | No    |                               |
| write_feelings   | 気分を有効化     | true or false       | false      | No       | デフォルトは false              |
| item_id          | アイテム ID             | number > 0          | 1          | No*      | item_id または item_name のいずれか必須 |
| item_name        | アイテム名           | any text            | Treasure   | No*      | item_id または item_name のいずれか必須 |
| item_amount      | アイテム数量       | [1, 99]             | 1          | No       | デフォルトは 1                  |
| items            | アイテム報酬        | JSON text           | See [Item Rewards Structure](#1-item-rewards-structure) | No | 複数アイテム報酬を設定 |
| task_type        | タスクタイプ           | [0, 4]              | 0          | No       | v1.99.1 以降<br/>0 - 通常タスク<br/>1 - カウントタスク<br/>2 - ネガティブタスク<br/>3 - API タスク<br/>4 - タイマータスク（v1.102.0+） |
| target_times     | 目標回数        | number > 0          | 1          | No       | task_type が 1（カウントタスク）の場合のみ有効 |
| is_affect_shop_reward | ショップ報酬に影響 | true/false      | false    | No       | task_type が 1（カウントタスク）の場合のみ有効。アイテムの報酬計算に影響するか |
| enable_proportional_settlement | 比例精算を有効化 | true/false | false | No | v1.104.0+；task_type が 1（カウントタスク）の場合のみ有効。有効時、カウント進捗の精算で比例して報酬を付与し、最終完了時に既に精算済みの報酬は再付与しない |
| expected_focus_minutes | 予想集中時間（分） | number > 0 | 25 | No | task_type が 4（タイマータスク）の場合のみ有効；デフォルト 25（v1.102.0+） |
| repeat_end_mode | 繰り返し終了モード | 0 or 1 | 0 | No | 繰り返しタスクのみ有効（frequency が 0 / -1 以外）<br/>0 - 回数で終了<br/>1 - 日付で終了（v1.102.0+） |
| repeat_target_times | 繰り返し終了回数 | number > 0 | 3 | No | repeat_end_mode=0 の場合（またはこのフィールドの存在で推論）；target_times と混同しないこと（v1.102.0+） |
| repeat_end_date | 繰り返し終了日 | timestamp (milliseconds) | 1640995200000 | No | repeat_end_mode=1 の場合（またはこのフィールドの存在で推論）（v1.102.0+） |
| repeat_end_behavior | 繰り返し終了後の動作 | 0 or 1 | 0 | No | 0 - 終了条件到達後にタスクを終了<br/>1 - 終了条件到達後にタスクを凍結（v1.102.0+） |

**Response:**

| Field    | Type    | Description      | Example | Notes                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | タスク ID          | 1000    |                          |
| task_gid | Number  | タスクグループ ID    | 1000    |                          |

<br/>

#### タスクを完了

**Method name:** complete

**Description:** タスク完了をトリガーします。未完了タスクのみ検索されます。

**Example:**

- id が 1 のタスクを完了：[lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- 「タスクグループ id」が 1 のタスクを完了：[lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- 名前でタスクを検索して完了：<a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Explanation:**

各タスクには id があります。

繰り返しタスクでは、繰り返すたびに id は更新されますが、「タスクグループ id」は変わりません。

id の取得方法：「Labs」ページで「Developer Mode」をオンにし、「Task Details」ページで確認します。

| Parameter | Meaning                         | Type                  | Example | Required | Notes |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | task id                         | number greater than 0 | 1       | no*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| gid       | task group id                   | number greater than 0 | 1       | no*      | タスクグループ id |
| name      | 名前                            | any text              | get up  | no*      | あいまい検索。見つかったタスクのうち 1 件のみ |
| ui        | ポップアップ UI を表示するか | true or false         | true    | no       | デフォルトは false。バックグラウンドでメッセージのみ表示 |
| count                    | カウント値                        | Number                                                 | 1         | No       | カウントタスクのみ。`count_set_type` パラメータと併用     |
| count_set_type           | カウント値の設定方法         | One of the following:<br/>absolute<br/>relative        | absolute  | No       | デフォルトは relative<br/>absolute - 値を直接設定<br/>relative - 元の値に加算または減算 |
| count_force_sum_up       | カウントタスク報酬の強制集計  | true or false                                          | true      | No       |                                                                                                    |
| reward_factor            | 報酬係数                      | Floating point number greater than 0                   | 1.1       | No       | カウントタスクには非適用<br/>報酬係数は経験値とコインの量に影響（商品数量には影響しない） |

**Notice:**

1. タスクに一致させるには、id、gid、name のいずれか 1 つを指定する必要があります。
2. タイマータスクはこの API では手動完了できません（v1.102.0+）。

<br/>

#### タスクを放棄

**Method name:** give_up

**Description:** タスク放棄をトリガーします。

**Example:**

- 名前でタスクを検索して放棄：[lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| gid       | task group id | number greater than 0 | 1       | no*      | タスクグループ id |
| name      | 名前          | any text              | get up  | no*      | あいまい検索。一致した 1 件のタスクのみ操作 |

**Notice:**

1. タスクに一致させるには、id、gid、name のいずれか 1 つを指定する必要があります。

<br/>

#### タスクを凍結

**Method name:** freeze

**Description:** タスク凍結をトリガーします。繰り返しタスクのみ対象。

**Example:**

- 名前でタスクを検索して凍結：[lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| gid       | task group id | number greater than 0 | 1       | no*      | タスクグループ id |
| name      | 名前          | any text              | get up  | no*      | あいまい検索。一致した 1 件のタスクのみ操作 |
| time      | 凍結期限  | timestamp             | 1661688800682 | no | - |

**Notice:**

1. タスクに一致させるには、id、gid、name のいずれか 1 つを指定する必要があります。

<br/>

#### タスクの凍結を解除

**Method name:** unfreeze

**Description:** タスクの凍結解除をトリガーします。

**Example:**

- 名前でタスクを検索して凍結解除：[lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| gid       | task group id | number greater than 0 | 1       | no*      | タスクグループ id |
| name      | 名前          | any text              | get up  | no*      | あいまい検索。一致した 1 件のタスクのみ操作 |

**Notice:**

1. タスクに一致させるには、id、gid、name のいずれか 1 つを指定する必要があります。

<br/>

#### タスクを削除

**Method name:** delete_task

**Description:** タスクを削除します。

**Example:**

- 名前でタスクを検索して削除：[lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Explanation:**

| Parameter | Meaning       | Type                  | Example | Required | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | number greater than 0 | 1       | no*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| gid       | task group id | number greater than 0 | 1       | no*      | タスクグループ id |
| name      | 名前          | any text              | get up  | no*      | あいまい検索。一致した 1 件のタスクのみ操作 |

**Notice:**

1. タスクに一致させるには、id、gid、name のいずれか 1 つを指定する必要があります。

<br/>

### タスクを編集

?> v1.98.0 以降が必要

**Method name:** edit_task

**Description:** 既存タスクの内容と属性を編集します

**Example:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parameter           | Meaning              | Values                | Example   | Required | Notes                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | タスク ID              | number greater than 0 | 1        | No*      | id、gid、name のいずれか必須 |
| gid                | タスクグループ ID        | number greater than 0 | 1        | No*      | id、gid、name のいずれか必須 |
| name               | タスク名            | any text             | Write diary| No*      | id、gid、name のいずれか必須 |
| todo               | タスク内容         | any text             | Write weekly| No      |                                |
| notes              | 備考                | any text             | Note content| No      |                                |
| coin               | コイン報酬          | number >= 0         | 10        | No       | 完了時に獲得するコイン。システム上限の対象    |
| coin_var           | コイン変動幅        | number greater than 0 | 1        | No       | [coin, coin+coin_var] の範囲でランダム報酬 |
| exp                | 経験値報酬    | number >= 0          | 20        | No       | 獲得する経験値。システム上限の対象        |
| skills             | スキル ID            | array of numbers greater than 0 | 1 | No    | 配列に対応（例 &skills=1&skills=2） |
| category           | リスト ID              | number greater than or equal to 0 | 0 | No  | 0 はデフォルトリスト。スマートリスト非対応 |
| frequency          | 繰り返し頻度     | integer              | 0         | No       | デフォルトは 0（1 回）<br/>0 - 1 回<br/>1 - 毎日<br/>N (N>1) - N 日ごと<br/>-1 - 無制限<br/>-3 - エビングハウス（v1.99.1 以降）<br/>-4 - 毎月<br/>-5 - 毎年 |
| weekdays           | 曜日             | `1,3,5` or `none`    | 1,3,5     | No       | v1.106.0+；add_task と同じ。省略時は変更なし；`none` で毎日に戻す；frequency を 1 以外に設定すると weekdays もクリア |
| importance         | 重要度     | [1, 4]              | 1         | No       | デフォルトは 1                   |
| difficulty         | 難易度     | [1, 4]              | 2         | No       | デフォルトは 1                   |
| deadline           | 期限             | timestamp (milliseconds) | 1640995200000 | No |                               |
| no_deadline        | 期限なし          | true/false         | true     | No       | v1.104.0+；繰り返しタスクのみ有効。`&no_deadline=true` を渡すと具体的な期限をクリア |
| remind_time        | リマインダー時刻        | timestamp (milliseconds) | 1640995200000 | No |                               |
| start_time         | 開始時刻           | timestamp (milliseconds) | 1640995200000 | No |                               |
| color              | タグ色            | color string         | #66CCFF   | No       | # は %23 にエスケープ        |
| background_url     | 背景画像 URL | web URL address      | http://example.com/bg.jpg | No |                         |
| background_alpha   | 背景の不透明度   | floating point between [0, 1] | 0.5 | No   |                                |
| enable_outline     | テキスト輪郭を有効化  | true or false       | false      | No       | background_url 指定時のみ有効。可読性向上のためテキストに輪郭を追加 |
| use_light_remark_text_color | 備考を明るい色で表示 | true or false | false | No | background_url 指定時のみ有効。備考テキストを明るい色で表示 |
| item_id            | アイテム ID              | number greater than 0 | 1        | No*      | item_id または item_name のいずれか必須 |
| item_name          | アイテム名            | any text             | Treasure  | No*      | item_id または item_name のいずれか必須 |
| item_amount        | アイテム数量          | [1, 99]             | 1         | No       | デフォルトは 1                   |
| items              | アイテム報酬 JSON    | JSON text           | [{"itemId":1,"amount":1}] | No | 複数アイテム報酬を設定 |
| auto_use_item      | アイテムを自動使用        | true or false        | false     | No       |                                |
| frozen             | 凍結状態        | true or false        | false     | No       | デフォルトは false              |
| freeze_until       | 凍結期限         | timestamp (milliseconds) | 1640995200000 | No | frozen が true の場合のみ有効 |
| coin_penalty_factor| コインペナルティ係数  | floating point between [0, 100) | 0.5 | No |                                |
| exp_penalty_factor | 経験値ペナルティ係数 | floating point between [0, 100) | 0.5 | No |                             |
| write_feelings     | 気分を有効化      | true or false        | false     | No       |                                |
| pin                | タスクをピン留め             | true or false        | false     | No       |                                |
| words              | 完了報酬テキスト | any text           | Great job!| No       | タスク完了時に表示するモチベーションテキスト |
| task_type        | タスクタイプ           | [0, 4]              | 0          | No       | v1.99.1 以降<br/>0 - 通常タスク<br/>1 - カウントタスク<br/>2 - ネガティブタスク<br/>3 - API タスク<br/>4 - タイマータスク（v1.102.0+） |
| target_times     | 目標回数        | number > 0          | 1          | No       | task_type が 1（カウントタスク）の場合のみ有効 |
| is_affect_shop_reward | ショップ報酬に影響 | true/false      | false    | No       | task_type が 1（カウントタスク）の場合のみ有効。アイテムの報酬計算に影響するか |
| enable_proportional_settlement | 比例精算を有効化 | true/false | false | No | v1.104.0+；task_type が 1（カウントタスク）の場合のみ有効。既存カウントタスクでは、このパラメータのみ渡して比例精算のオン/オフを切り替え可能；設定や報酬構成の変更により、アプリ内ルールに従い精算済み進捗がリセット/ロールバックされる場合あり |
| expected_focus_minutes | 予想集中時間（分） | number > 0 | 25 | No | task_type が 4（タイマータスク）の場合のみ有効；デフォルト 25（v1.102.0+） |
| repeat_target_times | 繰り返し終了回数 | number > 0 | 3 | No | 繰り返しタスクのみ有効（frequency が 0 / -1 以外）；repeat_target_times と repeat_end_date を同時指定時は repeat_target_times が優先（v1.102.0+） |
| repeat_end_date | 繰り返し終了日 | timestamp (milliseconds) | 1640995200000 | No | 繰り返しタスクのみ有効（frequency が 0 / -1 以外）（v1.102.0+） |
| repeat_end_behavior | 繰り返し終了後の動作 | 0 or 1 | 0 | No | 0 - 終了条件到達後にタスクを終了<br/>1 - 終了条件到達後にタスクを凍結（v1.102.0+） |
| coin_set_type     | コイン値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - コインを value に直接設定<br/>relative - 元のコイン値に加算/減算 |
| exp_set_type      | 経験値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - 経験値を value に直接設定<br/>relative - 元の経験値に加算/減算 |

**Response:**

| Field     | Type    | Description      | Example | Notes             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | タスク ID          | 1000    |                  |
| task_gid  | Number  | タスクグループ ID    | 1000    |                  |

<br/>

### タスクテンプレート

?> v1.102.0 以降で導入

**Method name:** task_template

**Description:** タスクテンプレートの CRUD。

**Examples:**

- テンプレート一覧：`lifeup://api/task_template?method=list`
- パラメータから作成：`lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- 既存タスクから作成：`lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- テンプレート取得：`lifeup://api/task_template?method=get&id=1`
- テンプレート名更新：`lifeup://api/task_template?method=update&id=1&name=NewName`
- タスクからテンプレート内容を更新：`lifeup://api/task_template?method=update&id=1&from_task_id=1`
- テンプレート削除：`lifeup://api/task_template?method=delete&id=1`

| Parameter | Meaning | Value | Example | Required | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | 操作 | list / get / create / update / delete | list | Yes | - |
| id | テンプレート id | number > 0 | 1 | No* | get/update/delete で必須；別名：template_id |
| template_id | テンプレート id | number > 0 | 1 | No* | id の別名 |
| name | テンプレート名 | text | MyTemplate | No* | create で必須；update では from_task_id/from_task_gid を使わない場合必須 |
| from_task_id | タスク id から構築 | number > 0 | 1 | No | create/update 用 |
| from_task_gid | タスクグループ id から構築 | number > 0 | 1 | No | create/update 用 |
| todo | タスク内容 | text | Write diary | No* | from_task_id/from_task_gid を使わない create 時は必須 |
| notes | 備考 | text | Notes | No | デフォルトは空 |
| category | リスト ID | number >= 0 | 0 | No | 別名：category_id |
| category_id | リスト ID | number >= 0 | 0 | No | category の別名 |
| frequency | 繰り返し頻度 | integer | 0 | No | add_task と同じ |
| weekdays | 曜日 | `1,3,5` | 1,3,5 | No | v1.106.0+；add_task と同じ；create では `none` は拒否 |
| importance | 重要度 | [1, 4] | 1 | No | - |
| difficulty | 難易度 | [1, 4] | 1 | No | - |
| coin | コイン報酬 | number | 10 | No | - |
| coin_var | コイン報酬の変動幅 | number | 1 | No | - |
| exp | 経験値報酬 | number | 100 | No | - |
| skills | スキル ID | array params | 1 | No | 配列に対応（例 &skills=1&skills=2） |
| skill_ids | スキル ID | JSON array or comma list | [1,2] | No | skills の代替 |
| deadline | 期限 | timestamp (milliseconds) | 1640995200000 | No | - |
| start_time | 開始時刻 | timestamp (milliseconds) | 1640995200000 | No | - |
| remind_time | リマインダー時刻 | timestamp (milliseconds) | 1640995200000 | No | - |
| words | 完了報酬テキスト | text | Great job! | No | - |
| task_type | タスクタイプ | [0, 4] | 0 | No | 0 - 通常<br/>1 - カウント<br/>2 - ネガティブ<br/>3 - API<br/>4 - タイマー |
| target_times | 目標回数 | number > 0 | 10 | No | task_type が 1（カウントタスク）の場合のみ有効 |
| is_affect_shop_reward | ショップ報酬に影響 | true / false | false | No | task_type が 1（カウントタスク）の場合のみ有効 |
| enable_proportional_settlement | 比例精算を有効化 | true / false | false | No | v1.104.0+；task_type が 1（カウントタスク）の場合のみ有効。テンプレートから作成したタスクはこのカウントタスク精算設定を保持 |
| expected_focus_minutes | 予想集中時間（分） | number > 0 | 25 | No | task_type が 4（タイマータスク）の場合のみ有効 |
| repeat_end_mode | 繰り返し終了モード | 0 or 1 | 0 | No | 繰り返しタスクのみ有効（frequency が 0 / -1 以外）<br/>0 - 回数で終了<br/>1 - 日付で終了 |
| repeat_target_times | 繰り返し終了回数 | number > 0 | 3 | No | repeat_end_mode=0 の場合（またはこのフィールドの存在で推論） |
| repeat_end_date | 繰り返し終了日 | timestamp (milliseconds) | 1640995200000 | No | repeat_end_mode=1 の場合（またはこのフィールドの存在で推論） |
| repeat_end_behavior | 繰り返し終了後の動作 | 0 or 1 | 0 | No | 0 - 終了<br/>1 - 凍結 |

**Return:**

| Field | Meaning | Type | Notes |
| ----- | ------- | ---- | ----- |
| templates | テンプレート一覧（JSON 文字列） | text | method=list のみ |
| count | テンプレート数 | number | method=list のみ |
| template | テンプレート詳細（JSON 文字列） | text | method=get のみ |
| id | テンプレート id | number | get/create/update/delete 用 |
| name | テンプレート名 | text | get/create/update 用 |
| success | 成功したか | true / false | create/update/delete 用 |

<br/>

### 履歴タスク操作

?> v1.98.0 以降が必要

**Method name:** history_operation

**Description:** 完了/放棄/期限切れタスクを操作します

**Examples:**

- 履歴タスクを削除：[lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- タスクを放棄としてマーク：[lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- タスクを再開：[lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> この API は未完了以外のタスク（完了、放棄、期限切れ）にのみ適用されます

| Parameter      | Meaning           | Values               | Example    | Required | Notes                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | タスク ID           | number greater than 0 | 1         | Yes      | 履歴タスクの ID          |
| operation     | 操作タイプ    | One of:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Yes | delete - タスク削除<br/>complete - 完了としてマーク<br/>undo_complete - 完了を取り消し<br/>set_to_give_up - 放棄としてマーク<br/>set_to_overdue - 期限切れとしてマーク<br/>edit_completed_time - 完了時刻を変更<br/>restart - タスクを再開 |
| completed_time | 完了時刻   | timestamp (milliseconds) | 1640995200000 | No* | operation が edit_completed_time の場合のみ必須 |

**Response:**

| Field    | Type    | Description    | Example | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | タスク ID        | 1000    | 操作対象タスクの ID  |

<br/>

### ショップ設定

**Method name:** shop_settings

**Instructions:** 各種ショップ設定を調整します

**Example:**

- ATM 金利を 0.01% に設定：[lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- クリックごとに金利を 0.01% 引き上げ：[lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Meaning              | Type | Example | Required | Notes |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | タイプ                 | Currently only following values  supported: <br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | yes | atm_interest - ATM 日利率<br/>credit_interest - ローン日利率<br/>line_of_credit - 借入可能額<br/>discount_rate_for_returning - 返品割引率<br/>atm_balance - ATM 残高を設定 |
| value     | 数値        | decimal number or integer | 0.01 | yes | key ごとに値の範囲が異なる<br/>例：ATM 残高は小数点非対応 |
| set_type  | 値の設定方法 | One of the following values:<br/>absolute<br/>relative | absolute | no |absolute - 絶対値、つまり目標を value に直接設定<br/>relative - 相対値、元の値に加算または減算|
| silent    | サイレント実行（UI 非表示）するか | Boolean | false | No | v1.93.0-beta01 (502) 以降でサポート<br/>デフォルトは false（UI プロンプトを表示） |

<br/>
### ページ遷移

**Method name:** goto

**Description:** `LifeUp` 内のページへ遷移します

**Example:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explanation:** Labs ページへ遷移

| Parameter | Meaning | Value | Example | Required | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | ページ | One of the following values:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | yes | `purchase_dialog` は購入ポップアップを指します<br/> `use_item_dialog` はアイテム使用ポップアップを指します<br/>その他の値は各主要ページを指します |

#### 1. アイテム購入/使用ポップアップへ遷移

`page` パラメータが `purchase_dialog` または `use_item_dialog` の場合、アイテム ID を指定できます：

例：`lifeup://api/goto?page=purchase_dialog&id=1`

| Parameter | Meaning | Value            | Example | Required | Notes   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | アイテム ID | Positive integer | 1       | Yes      | アイテム ID |

<br/>

#### 2. ホーム画面のサブページへ遷移

`page` パラメータが `main` の場合、遷移先サブページを追加指定できます：

例、ショップページへ遷移：`lifeup://api/goto?page=main&sub_page=shop`

| Parameter   | Meaning       | Value | Example | Required | Notes  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | サブページ名 | One of:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | no       |      |
| category_id | リスト ID       | number | 0      | no       | `sub_page` がリストページの場合、遷移先リスト ID を指定できます。<br/>ショップアイテムリスト、インベントリリスト、タスクリストなど。 |

<br/>

#### 3. タスク詳細へ遷移

`page` パラメータが `task_detail` の場合、遷移先タスク id を追加指定できます：

例、タスク id 53 の詳細ページへ遷移：`lifeup://api/goto?page=task_detail&task_id=53`

| Parameter | Meaning       | Value         | Example      | Required | Notes |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | タスク id       | task id       | 53           | No*      | タスク id；繰り返しタスクの場合、繰り返すたびに id が更新される |
| task_gid  | タスクグループ id | task group id | 3            | No*      | タスクグループ id |
| task_name | タスク名     | string        | get up early | No*      | タスク名、あいまい検索で 1 件 |

**Notice:**

1. 3 つのパラメータのうち 1 つだけ指定すれば十分です。
    - 複数同時に指定した場合、内部優先順位が適用されます。これは未定義の動作であり、App は順序を保証しません。

<br/>

#### 4. 新規実績ページへ遷移

`page` パラメータが `add_achievement` の場合、カテゴリ id を**必ず**追加指定する必要があります：

例、カテゴリ id 1 の新規実績ページへ遷移：`lifeup://api/goto?page=add_achievement&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | 実績カテゴリ id | Achievement category id | 1       | Yes      |        |

#### 5. 指定実績カテゴリページへ遷移

`page` パラメータが `user_achievement` の場合、カテゴリ id を**必ず**追加指定する必要があります：

例、id 1 の実績カテゴリページへ遷移：`lifeup://api/goto?page=user_achievement&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | 実績カテゴリ id | Achievement category id | 1       | Yes      |        |

#### 6. 指定合成カテゴリページへ遷移

`page` パラメータが `synthesis` の場合、カテゴリ id を任意で指定できます：

例、id 1 の合成カテゴリページへ遷移：`lifeup://api/goto?page=synthesis&category_id=1`

| Parameter    | Meaning         | Value         | Example | Required | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | 合成カテゴリ id | Synthesis category id | 1       | No       |        |

フィルター付きで合成ページを開くこともできます（v1.102.0+）：

例、製品アイテム id 1 でフィルター：`lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parameter        | Meaning           | Value | Example | Required | Notes |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | フィルタータイプ       | product / ingredient / related | product | No* | filter_item_id が必要 |
| filter_item_id  | フィルターアイテム id    | number > 0 | 1 | No* | filter_type が必要 |
| filter_item_name| フィルターアイテム名  | text | Gem | No | 任意、表示用 |

### ショップ

#### アイテムを追加

?> `effects` など一部フィールドは v1.98.0+ が必要

**Method name:** add_item

**Description:** 購入制限や使用効果を含む、カスタマイズ可能なプロパティでショップアイテムを作成します。

**Example:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parameter        | Meaning                | Values               | Example       | Required | Notes                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | アイテム名             | any text             | 10 minute break | Yes    |                                 |
| desc            | 説明           | any text             | Take a break  | No       |                                 |
| icon            | アイコン                  | emoji, http(s) URL, or built-in sample name | ☕ | No | `emoji_*.webp`、`lifeup_sample_*`、または URL として保存。名前の emoji はアイコンを設定しない |
| price           | 価格                 | [0, 999999]         | 10            | No       | デフォルトは 0                    |
| stock_number    | 在庫数        | [-1, 99999]         | -1            | No       | -1 は無制限              |
| action_text     | アクションボタンテキスト    | any text             | rest          | No       |                                 |
| disable_purchase| 購入を無効化      | true or false        | false         | No       | デフォルトは false                |
| disable_use     | 使用を無効化           | true or false        | false         | No       | デフォルトは false                |
| category        | カテゴリ ID           | number greater than or equal to 0 | 0 | No    | 0 はデフォルトカテゴリ          |
| order           | 表示順         | integer              | 1             | No       | カテゴリ内の位置            |
| purchase_limit  | 制限ルール     | JSON text            | [Purchase Limit Structure](#3-purchase-limit-structure) を参照 | No | 購入/使用制限を設定可能 |
| limit_scope     | 制限の適用範囲     | purchase / use / both | purchase | No | `purchase_limit` が空でない場合のみ有効；デフォルトは `purchase` |
| effects         | 使用効果           | JSON text            | [Item Effects Structure](#4-item-effects-structure) を参照 | No | アイテム使用効果 |
| own_number      | 初期所持数 | integer             | 0             | No       | 初期インベントリ数量を設定  |
| unlist          | ショップから非表示        | true or false        | false         | No       | デフォルトは false                |

**Return Data:**

| Field    | Type    | Description    | Example | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | アイテム ID        | 1000    | 作成されたアイテムの ID   |

!> effects パラメータは disable_use を上書きします。effects で使用不可アイテムを示した場合、disable_use は無視されます。

<br/>

#### アイテムを編集

?> v1.98.0+ が必要

**Method name:** item

**Description:** 価格、在庫、効果など、既存アイテムのプロパティを変更します

**Examples:**

- 価格を調整：[lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- 効果を変更：[lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - effects パラメータのデコード内容：`[{"type":2,"info":{"min":100,"max":200}}]`

| Parameter         | Meaning             | Values               | Example   | Required | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | アイテム ID             | number greater than 0| 1         | No*      | id または name のいずれか必須      |
| name             | アイテム名           | any text             | Treasure  | No*      | あいまい検索用、名前変更ではない  |
| set_name         | 名前を設定            | any text             | Treasure  | No       | 空にできない                 |
| set_desc         | 説明を設定     | any text             | Get gift  | No       |                                |
| set_icon         | アイコンを設定            | emoji, http(s) URL, or built-in sample name | ☕ | No | `icon` と同じ。未対応の値は `unsupported_parameter` を返す |
| set_price        | 価格を調整        | integer              | 1         | No       |                                |
| set_price_type   | 価格調整方法 | absolute or relative | relative  | No       | absolute - 直接設定<br/>relative - 加算/減算 |
| own_number       | 所持数を調整| integer             | 1         | No       | relative では負の値も可 |
| own_number_type  | 所持数調整方法| absolute or relative| relative  | No       | absolute - 直接設定<br/>relative - 加算/減算 |
| stock_number     | 在庫を調整        | [-1, 99999]         | 1         | No       | -1 は無制限在庫        |
| stock_number_type| 在庫調整方法 | absolute or relative | relative  | No       | absolute - 直接設定<br/>relative - 加算/減算 |
| disable_purchase | 購入を無効化    | true or false        | false     | No       | デフォルトは false              |
| disable_use      | 使用を無効化         | true or false        | false     | No       | デフォルトは false              |
| action_text      | 使用ボタンテキスト     | any text             | Use       | No       |                                |
| title_color_string| タイトル色        | color string         | #66CCFF   | No       | # は %23 にエスケープ<br/>空値でデフォルトに復元 |
| effects          | 使用効果         | JSON text            | [Item Effects Structure](#4-item-effects-structure) を参照 | No | アイテム使用効果を設定 |
| purchase_limit   | 制限ルール   | JSON text            | [Purchase Limit Structure](#3-purchase-limit-structure) を参照 | No | `null` で全制限をクリア |
| limit_scope      | 制限の適用範囲   | purchase / use / both | purchase | No | このフィールド指定時のみ更新；`purchase_limit` が空になると自動クリア |
| category_id      | カテゴリ ID         | number >= 0          | 1         | No       | 0 はデフォルトカテゴリ         |
| order            | 表示順       | integer              | 1         | No       | カテゴリ内の位置           |
| unlist           | ショップから削除    | true or false        | false     | No       | デフォルトは false              |

!> 変更対象アイテムの特定には id または name パラメータのいずれかが必須です

<br/>

#### 戦利品箱効果を調整

**Method name:** loot_box

**Description:** 指定ボックスアイテムの戦利品箱効果を変更します。確率、報酬数、内容の追加に対応します。（現時点では削除は非対応）

**Example:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Explanation:** コイン箱内の [大] 袋コインの割合を 1 ポイント増加

| Parameter   | Meaning                               | Type                                                    | Example        | Required | Notes                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | アイテム id                               | a number greater than 0                                 | 1              | no*      | 取得方法は上記「基礎知識 - LifeUp Data ID」を参照 |
| name        | アイテム名                             | any text                                                | Treasure chest | no*      | id 不明時のあいまい検索用、名前変更ではない |
| sub_id      | 内容アイテム id                       | a number greater than 0                                 | 1              | no*      | 箱の内容物 id                                         |
| sub_name    | 内容アイテム名                     | any text                                                | Get a gift     | no*      | 箱の内容物 id が不明な場合のあいまい検索用 |
| set_type    | 調整方法（absolute/relative） | one of the following values: <br/>absolute<br/>relative | relative       | no       | absolute - 絶対値、つまり目標を value に直接設定<br/>relative - 相対値、元の値に加算または減算 |
| amount      | 内容アイテム数                | number                                                  | 1              | no       | 単一アイテムの報酬数                          |
| probability | 内容アイテムの確率       | number                                                  | 1              | no       | -                                                            |
| fixed       | 固定報酬か          | boolean                                                 | true/false     | no       | -                                                            |

**Notice:**

1. 商品を検索するには、id または name のいずれかが必要です。
1. 内容を検索するには、sub_id または sub_name のいずれかが必要です。
1. `name` と `sub_name` は完全一致を試み、失敗時はあいまい検索にフォールバックします。
1. レガシー `loot_box` API は互換動作を維持します：同一内容アイテムが異なる数量で複数存在する場合、最初に一致したエントリを編集し、`sub_amount` による区別は行いません。数量指定の編集、削除、マージが必要な場合は `loot_box/v2` を使用してください。

<br/>

#### 戦利品箱効果を調整（v2）

?> この API は v1.104.2 で導入されました。

**Method name:** loot_box/v2

**Description:** loot_box API の改良版。指定ボックスアイテムの戦利品箱効果を変更し、確率、報酬数、内容の追加、**内容の削除**に対応します。

**v1 からの改善点：**
- **`sub_amount` による精密マッチング**：箱内に同一アイテムが異なる数量で複数存在する場合（例：A x1 50%、A x2 30%）、`sub_amount` で特定エントリを指定。デフォルトは `1`。一致するエントリがない場合、LifeUp は `sub_id` / `sub_name` でアイテムを検索して新規追加；`amount=0` 削除リクエストの場合は新規追加しない。
- **独立した `set_type`**：`amount_set_type` と `probability_set_type` を独立制御可能。グローバル `set_type` はフォールバックのデフォルト。
- **削除対応**：`amount_set_type=absolute` で `amount=0` を設定（または `relative` で `<=0` に計算）すると一致エントリを削除。
- **重複マージ**：`amount` 変更により同一アイテム・同一数量の既存エントリと重複する場合、LifeUp は既存エントリにマージし、リクエストの `probability` / `fixed` を適用し続けます。

**Example:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Explanation:** コイン箱内の [大] 袋コイン（x2）の確率を 10 ポイント増加

| Parameter              | Meaning                               | Type                                                    | Example        | Required | Notes                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | アイテム id                               | a number greater than 0                                 | 1              | no*      | 取得方法は上記「基礎知識 - LifeUp Data ID」を参照 |
| name                   | アイテム名                             | any text                                                | Treasure chest | no*      | id 不明時のあいまい検索用、名前変更ではない |
| sub_id                 | 内容アイテム id                       | a number greater than 0                                 | 1              | no*      | 箱の内容物 id。sub_id と sub_name の両方指定時は sub_id が優先 |
| sub_name               | 内容アイテム名                     | any text                                                | Get a gift     | no*      | 箱の内容物 id が不明な場合のあいまい検索用 |
| sub_amount             | マッチング用内容数量      | number                                                  | 2              | no       | この数量のエントリを精密マッチ。最小 `1`、デフォルト `1`。一致なしかつ削除リクエストでない場合、新規エントリを追加 |
| set_type               | グローバル調整方法              | one of: `absolute` / `relative`                         | relative       | no       | 未指定時の `amount_set_type` と `probability_set_type` のデフォルト |
| amount_set_type        | 数量の調整方法          | one of: `absolute` / `relative`                         | relative       | no       | 数量フィールドの `set_type` を上書き                    |
| probability_set_type   | 確率の調整方法     | one of: `absolute` / `relative`                         | absolute       | no       | 確率フィールドの `set_type` を上書き               |
| amount                 | 内容アイテム数                | number                                                  | 1              | no       | 単一アイテムの報酬数。`0`（absolute）または計算結果 `<=0`（relative）でエントリ削除 |
| probability            | 内容アイテムの確率       | number                                                  | 1              | no       | -                                                            |
| fixed                  | 固定報酬か          | boolean                                                 | true/false     | no       | -                                                            |
| query                  | 箱の内容を一覧                     | true or false                                           | true           | no       | v1.105.1+。アイテム JSON のみ返却；sub_id / sub_name 不要 |

**Notice:**

1. 商品を検索するには、id または name のいずれかが必要です。
1. 内容を検索するには、sub_id または sub_name のいずれかが必要です。sub_id / sub_name なしで一覧するには `query=true` を使用。
1. `sub_id` と `sub_name` の両方指定時は `sub_id` が優先。有効な `sub_id` がない場合のみ `sub_name` を使用。
1. `name` と `sub_name` は完全一致を試み、失敗時はあいまい検索にフォールバックします。
1. `sub_amount` のデフォルトは `1`。同一アイテムが異なる数量で複数存在する場合、`sub_amount` で特定エントリを指定。一致なしかつ削除リクエストでない場合、`amount=sub_amount` の新規エントリを追加。
1. エントリ削除：`amount_set_type=absolute` で `amount=0`、または `amount_set_type=relative` で合計が `<=0` になる負の値。削除は一致エントリにのみ適用；既存エントリに一致しない場合、`amount=0` では新規追加しない。
1. エントリの `amount` 変更により同一アイテム・同一数量の既存エントリと重複する場合、LifeUp は既存エントリにマージし、リクエストの `probability` / `fixed` を適用し続けます。
1. 削除により箱が空になると、戦利品箱効果全体がソフト削除されます（アイテム自体は保持され、後から戦利品箱エントリを再追加可能）。

<br/>

#### アイテムを使用

?> この API は v1.93.0-beta01 (502) で導入されました。

**Method name:** use_item

**Description:** 指定アイテムを使用します。

**Example:**

- コイン箱を開く：[lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parameter | Meaning     | Type                    | Example  | Required | Notes                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | アイテム ID     | a number greater than 0 | 1        | No*      | アイテム ID の取得方法は「基礎知識 - LifeUp Data ID」を参照 |
| name      | アイテム名   | Any text                | coin_box | No*      | id 不明時；アイテムのあいまい検索      |
| use_times | 使用回数 | a number greater than 0 | 1        | No       | デフォルトは 1 回<br/>通常アイテムまたは箱を開く場合、アイテム数量に対応<br/>単純合成アイテムの場合、「合成数量」に対応し、消費アイテム数ではない |

**Return:**

!> この API は理由により失敗する場合があり、戻り値に具体的な失敗理由が含まれることがあります。

| Parameter | Meaning            | Type     | Example          | Required | Notes                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | 結果コード        | a number | 0                | Yes      | 0 - 使用成功<br/>1 - データベース例外<br/>2 - 経験値不足制限<br/>3 - アイテムが見つからない<br/>4 - 実行中カウントダウン競合<br/>5 - インベントリ不足<br/>6 - 使用不可アイテム<br/>7 - コイン上限<br/>8 - 対象在庫上限<br/>9 - 属性レベル制限<br/>10 - 時間制限<br/>11 - 所持アイテム数量制限<br/>12 - タスク完了制限<br/>13 - 実績解除制限<br/>14 - 期間数量制限<br/>15 - タスクサイクル完了制限 |
| desc      | 結果の説明 | Text     | RunningCountDown | Yes      |                                                              |

<br/>

### ATM

**⚠ v1.91+ のみ利用可能**

> ここでの入金・出金操作は検証されます。
>
> ATM 残高を直接調整する必要がある場合は、上記「ショップ設定」インターフェースを参照してください。

#### 入金

**Method name:** deposit

**Description:** 入金の合法性（コイン残高が十分か）がチェックされます。

**Example:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Explanation:** 500 コインを入金。

| Parameter | Meaning        | Type                    | Example | Required | Notes |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | 入金額 | a number greater than 0 | 100     | yes      | -     |

**Return:**

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | 操作が成功したか | `true` or `false` | true    | yes      | -     |

<br/>

#### 出金

**Method name:** withdraw

**Description:** 出金の合法性（ATM 残高が十分か）がチェックされます。

**Example:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Explanation:** 500 コインを出金。

| Parameter | Meaning           | Type                    | Example | Required | Notes |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | 出金額 | a number greater than 0 | 100     | yes      | -     |

**Return:**

| Parameter | Meaning                              | Type              | Example | Required | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | 操作が成功したか | `true` or `false` | true    | yes      | -     |

<br/>

### ポモドーロタイマー

**Method name:** pomodoro_timer

**Description:** LifeUp の実ポモドーロカウントダウンまたはカウントアップタイマーを制御します。この API は App UI と同じタイマーセッションを開始します；ポモドーロ記録やトマトを直接追加するものではありません。

**Examples:**

- デフォルト作業カウントダウンを開始または再開：
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- カウントアップタイマーを開始しタスク 101 を選択：
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- アクティブなカウントダウンを一時停止：
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- ポモドーロライフサイクルを放棄してリセット：
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- 現在のポモドーロステージをスキップ：
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- トマト報酬なしでカウントアップタイマーを精算：
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- 両タイマーモードを照会：
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parameters:**

| Parameter | Meaning | Type / values | Required | Notes |
| --------- | ------- | ------------- | -------- | ----- |
| action | 操作 | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | yes | - |
| mode | タイマーモード | `countdown`, `count_up` | `start`、`pause`、`abandon`、`complete` で必要 | `skip` は常にカウントダウンを対象 |
| stage | カウントダウンステージ | `work`, `short_break`, `long_break` | no | `mode=countdown` の場合のみ有効。省略時はアクティブ、一時停止、または次ステージの正規ステージを使用；新ライフサイクルは `work` で開始 |
| receive_reward | トマト報酬を受け取るか | `true` or `false` | `complete` で必要 | 厳密な boolean。`complete` は `mode=count_up` のみサポート |
| task_id | タスク ID | positive integer | no | `task_gid` または `task_name` と併用不可 |
| task_gid | タスクグループ ID | positive integer | no | `task_name` と併用してマッチを絞り込み可能 |
| task_name | タスク名 | text | no | 完全一致を優先、あいまい検索にフォールバック |
| clear_task | タイマータスクをクリア | `true` or `false` | no | `true` はタスク指定子と併用不可 |

`select_task` にはタスク指定子または `clear_task=true` が必要です。`start` には同じタスク選択パラメータを含められます。カスタム時間パラメータは非対応：カウントダウンは現在のデフォルト時間または選択タスクのポモドーロ時間を使用します。

`abandon&mode=countdown` は App の左アクションと同等：現在ステージを放棄し、ポモドーロライフサイクルをリセットし、停止した作業ステージに戻ります。`skip` は右アクションと同等：作業から短/長休憩へ、または休憩から作業へ進み、次ステージを自動開始しません。各 `skip` 呼び出しは実際の非べき等アクションです；呼び出し側は自動リトライしないでください。

`complete&mode=count_up` は実カウントアップセッションを精算します。30 秒未満のセッションは記録を作成せず消費されます。`receive_reward=false` の場合、閾値を満たす記録は放棄として保存されますがトマトは付与されません。

**タスク切り替えルール：**

- 実行中の作業カウントダウンはタスク変更を拒否します。
- 実行中のカウントアップタイマーはタスク変更を許可し、通知を更新します。
- 一時停止中のカウントダウンはタスク変更を許可し、経過時間を保持しつつ新タスク設定から合計時間を再計算します。

**成功時の戻り値：**

| Parameter | Meaning | Type |
| --------- | ------- | ---- |
| api_result | API 呼び出しが成功したか | boolean |
| applied | この呼び出しがタイマー状態を変更したか | boolean |
| mode | 対象または現在選択中のタイマーモード | `countdown` or `count_up` |
| state | `mode` の状態 | `running`, `paused`, or `stopped` |
| selected_task_id | 現在のタイマータスク ID、または `0` | number |
| can_start_in_background | Android が現在バックグラウンドタイマー開始を許可するか | boolean |
| countdown_state | 正規カウントダウン状態 | `running`, `paused`, or `stopped` |
| countdown_phase | カウントダウンライフサイクルフェーズ | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | 正規カウントダウンステージ | `work`, `short_break`, or `long_break` |
| countdown_session_id | 正規カウントダウンセッション ID | text or null |
| countdown_total_millis | カウントダウン合計時間 | milliseconds |
| countdown_remaining_millis | カウントダウン残り時間 | milliseconds |
| count_up_state | 正規カウントアップ状態 | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | カウントアップ経過時間 | milliseconds |
| battery_optimization_ignored | LifeUp がバッテリー最適化から除外されているか | boolean |

成功した `complete` レスポンスには追加で `record_created`、`reward_tomatoes`、
`settled_elapsed_millis` が含まれます。

要求状態と既に一致する `start`、`pause`、`abandon` の繰り返し呼び出しは
`applied=false` で成功します。変更系呼び出しはプロセス間リトライの重複排除を提供しません。

**エラー：**

失敗時は `api_result=false`、`error_code`、`error_message` を返します。タイマー固有の安定エラーコード：

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

On Android 12 以降、バックグラウンド ContentProvider 呼び出しでタイマーを開始できるのは、LifeUp がバッテリー最適化の除外を許可されている場合のみです。それ以外はタイマー状態を変更する前に `background_start_not_allowed` を返します。Activity 経由で URL Scheme を開くと、開始前に LifeUp がフォアグラウンドに移ります。Android はバックグラウンドから第三者 App がその Activity を起動することをブロックする場合があり、その場合 LifeUp は API 呼び出しを受信せずエラーを返せません。

<br/>

### ポモドーロ記録

#### ポモドーロ記録を追加

**Method name:** add_pomodoro

**Description:** トマトタイミング記録を追加

**Example:**

- 25 分（1500000 ms）のタイミング記録を追加し、名前に learning を含むタスクを指定：[lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- `2022-08-01 11:00:00` - `2022-08-01 12:00:00` のタイミング記録を追加：[lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Explanation:**

| Parameter        | Meaning                    | Type                    | Example       | Required | Notes |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | タイミング開始時刻          | timestamp               | 1659322800000 | no*      | Timestamp が分からない場合は検索してください |
| duration         | 集中時間             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | no* | |
| end_time         | タイミング終了時刻            | timestamp               | 1659326400000 | no*      |       |
| reward_tomatoes  | トマトを報酬として付与するか | true or false           | true          | no       | デフォルトは false |
| task_id          | タスク id                    | a number greater than 0 | 1             | no       |       |
| task_gid         | タスクグループ id              | a number greater than 0 | 1             | no       |       |
| task_name        | 名前                       | any text                | learning      | no       | あいまい検索、見つかったタスクのうち 1 件のみ |
| ui               | 報酬トマト UI を表示 | true or false         | true          | no       | v1.94.0 で導入、デフォルトは true |

**Notice:**

1. start_time、duration、end_time のいずれか 1 つは必須です。
2. duration のみの場合、デフォルト end_time は現在時刻です。
3. end_time は start_time より大きい必要があります。
4. duration は最低 30000 ミリ秒（30 秒）です。
5. start_time、duration、end_time をすべて指定する場合、duration は (end_time - start_time) 以下である必要があります。

<br/>

#### ポモドーロ記録を編集

> v1.94.0 で導入
> **Method name:** edit_pomodoro

**Description:** 既存のポモドーロタイミング記録を編集するか、有効な `edit_item_id` が指定されている場合は新規記録を追加します。

**Example:**

- 指定 ID の記録を編集し、時間を 45 分（2700000 ms）に設定してトマトを報酬：[lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- 開始・終了時刻で記録を編集：[lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parameters:**

| Parameter       | Meaning                    | Type                  | Example       | Required | Notes                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | タスク ID                    | Number greater than 0 | 101           | No       | タスクの一意識別子                   |
| task_gid        | タスクグループ ID              | Number greater than 0 | 5             | No       | 指定時は task_id を上書き                |
| task_name       | タスク名                  | Any text              | Study         | No       | task_id または task_gid がない場合は必須   |
| start_time      | タイミング開始時刻          | Timestamp             | 1659322800000 | No*      | Timestamp については検索を参照     |
| end_time        | タイミング終了時刻            | Timestamp             | 1659326400000 | No*      | -                                                |
| duration        | 集中時間             | Number (milliseconds) | 2700000       | No*      | 最低 30000 ミリ秒（30 秒） |
| reward_tomatoes | トマトを報酬として付与するか | true or false         | true          | No       | デフォルトは false                                 |
| edit_item_id    | 編集対象アイテム ID     | Number greater than 0 | 123           | Yes      | 編集する記録 ID を指定                  |
| ui              | 報酬トマト UI を表示 | true or false         | true          | No       |                                                  |
| delete          | 記録を削除          | true or false         | true          | No       | v1.105.1+。ポモドーロ記録をソフト削除（`isDel`）、App と同じ |

**Return values:**

| Parameter | Meaning                          | Type   | Example | Required | Notes                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | この操作で獲得したトマト | Number | 2       | No       | `ui` が true の場合に返却 |

**Notes:**

1. `start_time`、`duration`、`end_time` のいずれか 1 つは必須です。
2. `end_time` は `start_time` より大きい必要があります。
3. `duration` は (`end_time` - `start_time`) 以下である必要があります。
4. `edit_item_id` が指定され対応する記録が見つかった場合は編集；それ以外は他パラメータに基づき新規記録を作成します。

<br/>

### 実績解除条件をアンロック

**Method name:** unlock_condition

**Description:** 実績解除条件をアンロックします。外部 API 呼び出しによる解除が必要です。

**Example:**

- unlock id 2 の解除条件を呼び出す：[lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Meaning      | Type                  | Example | Required | Notes |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | 条件 id | number greater than 0 | 2       | yes      |       |

<br/>

### 実績を完了 / 報酬を受け取る

?> この API は v1.105.1 で導入されました。

**Method name:** complete_achievement

**Description:** 手動実績を完了して報酬を受け取るか、すでに解除済みの自動実績の報酬を受け取ります。App 内で完了チェックボックス / 報酬受け取りボタンをタップしたのと同じ動作です。

**Example:**

- id 1 の実績を完了または報酬を受け取る：[lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parameter | Meaning        | Type                  | Example | Required | Notes |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | 実績 id | number greater than 0 | 1       | yes      |       |

**Return value:**

| Field  | Type   | Description | Example | Notes |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | 実績 ID | 1 | |
| status | number | 呼び出し後のステータス | 2 | `0` ロック中 · `1` 解除済み、報酬未受け取り · `2` 解除済み、報酬受け取り済み |

**Notes:**

1. 手動実績（解除条件なし）：まだロック中の場合、この呼び出しで実績を完了し報酬を付与します。
2. 自動実績（解除条件あり）：すでに解除済みで未受け取りの報酬がある場合のみ報酬を受け取ります。条件を満たしていない場合、呼び出しは `error_code=achievement_not_unlocked` で失敗します。
3. 報酬受け取り済みのあと再度呼び出しても `status=2` で成功し、報酬は二重付与されません。
4. これは `achievement?unlocked=true` とは異なり、解除状態のみを書き込み報酬は付与しません。

<br/>

### 歩数を設定

**Method name:** step

**Description:** 指定日の歩数を設定します。例えばリストバンド + 自動化ツールで歩数を入力する用途や、履歴記録の修正に使えます。

**Example:**

- GMT+8 タイムゾーンの 2022-10-21 の歩数を 9999 歩に調整：[lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parameter | Meaning                         | Type                                | Example       | Required | Notes |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | 歩数                 | a number greater than or equal to 0 | 9999          | yes      |       |
| time      | 対象日の任意タイムスタンプ | timestamp (ms)                      | 1666282995643 | yes      |       |

<br/>

### 経験値を編集

?> この API は v1.93.0-beta01 (502) で導入されました。

**Method name:** edit_exp

**Description:** 属性の現在の経験値を一括設定できます。特定の経験値または特定のレベルを直接設定できます。

**Example:**

> この API はデータに影響するため、誤操作防止のためここでは直接クリック可能なリンクを提供していません。

- 属性 [Strength] と [Knowledge] の経験値を 0 にリセット：lifeup://api/edit_exp?skills=1&skills=2&exp=0
- [Charm] の経験値をレベル 50 に直接調整：lifeup://api/edit_exp?skills=3&level=50

| Parameter | Meaning              | Type                                      | Example | Required | Notes |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | 属性（スキル）ID | Array of numbers greater than 0           | 1       | No       | 配列対応（例：&skills=1&skills=2&skills=3）<br/>属性 ID の取得方法は「基礎知識 - LifeUp Data ID」節を参照 |
| exp       | 経験値を設定 | Number greater than or equal to 0 (int32) | 9999    | No, but either exp or level must be provided |                                                               |
| level     | レベルを設定            | Number greater than or equal to 0 (int32) | 50      | No, but either exp or level must be provided | 特定レベルの開始経験値を表します<br/>カスタムレベル勾配の影響を受けます。 |

<br/>

### 気分を追加または編集

?> この API は v1.93.4 (536) 以降で利用できます。

**Method name:** feeling

**Description:** 気分の記録を作成または更新するために使用します。

**Example:**

- 新しい気分記録を作成：[lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- 既存の気分記録を更新してお気に入りに設定：[lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- 気分を削除：[lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parameter            | Meaning           | Type                               | Example           | Required | Notes                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | 気分記録 ID | Number greater than 0              | 1                 | No       | 指定時は特定の記録を更新しようとします。削除時は必須。                                                                                                                                                           |
| content              | 内容           | Any text                           | Happy             | No       | 新規記録の作成または既存記録の内容更新に使用                                                                                                                                                                    |
| time                 | タイムスタンプ         | Unix timestamp                     | 1633036800        | No       | 記録の時刻。デフォルトは現在時刻                                                                                                                                                                                             |
| is_favorite          | お気に入りフラグ     | true or false                      | true              | No       | 記録をお気に入りにするかどうか                                                                                                                                                                                                        |
| delete               | 削除            | true or false                      | true              | No       | v1.105.1+。App と同じ方法で気分をソフト削除（添付ファイルは削除されます）。                                                                                                                                                       |
| relate_type          | 関連タイプ     | Number between 0 and 3             | 1                 | No       | 記録に関連付けるタイプを指定：<br/>0: タスク<br/>1: カスタム実績<br/>2: 関連なし<br/>3: アイテム使用                                                                                                        |
| relate_id            | 関連 ID        | Number greater than 0              | 2                 | No       | 関連項目の ID を指定：<br/>relate_type が 0 のとき：タスク ID<br/>relate_type が 1 のとき：実績 ID<br/>relate_type が 3 のとき：アイテム ID<br/>relate_type が 2 のとき：ID 不要                |
| usage_count          | 使用回数       | Integer greater than 1             | 1                 | No       | relate_type が 3（アイテム使用）のときのみ有効。アイテムの使用回数を記録します。                                                                                                                                                          |
| image_uris           | 画像 URI        | List of URI strings                |                   | No       | ローカルファイル URI（file://）またはリモート Web 画像（http/https）に対応。配列対応（例：&image_uris=uri1&image_uris=uri2）。 |
| image_uris_update_mode | 更新モード       | APPEND or REPLACE | REPLACE           | No       | 既存記録の更新かつ image_uris 指定時のみ有効。<br/>APPEND：既存画像に追加。<br/>REPLACE：既存画像を置換（デフォルト）。                                                               |
    
**Note:**

1. `id` パラメータが指定されている場合、対応する気分記録を更新しようとします。一致する記録がない場合は例外がスローされます。
2. `id` が未指定で `content` がある場合、新しい気分記録を作成します。

<br/>

### トマト数

?> v1.98.0+ が必要

**Method name:** tomato

**Description:** トマト数を調整します（増加、減少、または特定の数に設定）

**Examples:**

- トマトを 1 個追加：[lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- トマトを 2 個減らす：[lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- ポモドーロ数を 10 に設定：[lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parameter | Meaning        | Values                                        | Example   | Required | Notes                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | 操作タイプ | One of:<br/>increase<br/>decrease<br/>set     | increase  | No       | increase - ポモドーロを追加（デフォルト）<br/>decrease - ポモドーロを減らす<br/>set - ポモドーロ数を指定値に設定 |
| number    | 数量         | Integer                                       | 1         | Yes      | action により意味が異なります：<br/>increase/decrease - 増減する数量<br/>set - 設定する目標数量 |

**Response:**

| Field    | Type    | Description              | Example |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | 現在のポモドーロ数   | 10      |

<br/>

### アイテムを購入

?> v1.98.0+ が必要

**Method name:** purchase_item

**Description:** 特定のアイテムを購入します

**Examples:**

- アイテム ID 1 を購入：[lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- 「Health Potion」という名前のアイテムを購入：[lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- アイテム ID 1 を 5 個購入：[lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

アイテムに `purchase_limit` が設定され、`limit_scope` に `purchase` が含まれる場合、この API でもそれらの制限を適用します。

| Parameter         | Meaning          | Values                | Example       | Required | Notes                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | アイテム ID          | number greater than 0 | 1             | No*      | id または name のいずれか必須 |
| name              | アイテム名        | any text              | Health Potion | No*      | id または name のいずれか必須 |
| purchase_quantity | 購入数量| number greater than 0 | 5             | No       | デフォルトは 1              |

**Response:**

| Field  | Type    | Description        | Example         | Notes                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | アイテム ID            | 1               | 購入成功時に返却  |
| result | Integer | 結果コード        | 0               | 下記の結果コードを参照      |
| desc   | Text    | 結果の説明 | PurchaseSuccess | 下記の結果コードを参照      |

**Result Codes:**

| Code | Description               | Notes                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | 購入成功            |
| 1    | DatabaseError             | データベースエラー                |
| 2    | NotEnoughCoin             | コイン不足              |
| 3    | ItemNotFound              | アイテムが見つからない                |
| 4    | PurchaseAndUseSuccess     | 購入と使用が成功    |
| 5    | PurchaseSuccessAndUseFailure | 購入は成功したが使用に失敗 |
| 6    | NotPurchaseable           | アイテム設定または制限により購入がブロックされた |
| 7    | OutOfStock                | ショップ在庫不足      |

<br/>

### 合成

?> v1.98.0+ が必要

**Method name:** synthesize

**Description:** 既存のレシピを使ってアイテムを合成します

**Examples:**

- レシピ ID 1 で 1 回合成：[lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- レシピ ID 1 で 5 回合成：[lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Broadcast behavior:**

- この API は**レシピ合成**用です。
- `Broadcast events` が有効で合成が成功した場合、LifeUp はブロードキャストイベント `app.lifeup.synthesis.complete` も送信します。
- このイベントは `use_item` 内の単純合成では**送信されません**。その経路は引き続き `app.lifeup.item.use` に属します。

| Parameter | Meaning            | Values                | Example | Required | Notes                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | レシピ ID        | number greater than 0 | 1       | Yes      | 合成レシピの ID  |
| times     | 回数   | number greater than 0 | 5       | No       | デフォルトは 1           |

**Response:**

| Field           | Type    | Description     | Example          | Notes                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | レシピ ID      | 1                |                          |
| result         | Integer | 結果コード     | 0                | 下記の結果コードを参照   |
| desc           | Text    | 結果の説明 | SynthesisSuccess | 下記の結果コードを参照 |
| synthesisResults| Text   | 合成結果 | {...}           | 成功時のみ返却 |

**Result Codes:**

| Code | Description          | Notes                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | 合成成功  |
| 1    | FormulaNotFound     | レシピが見つからない     |
| 2    | InsufficientMaterials| 素材不足 |
| 3    | DatabaseError       | データベースエラー        |
| 4    | UnknownError        | その他のエラー         |

<br/>

### 合成レシピ管理

?> v1.98.0+ が必要

**Method name:** synthesis_formula

**Description:** 合成レシピの作成、変更、削除

**Examples:**

- 新しいレシピを作成：[lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - ここでの inputItems は `[{"item_id": 296, "amount": 88}]`
  - ここでの outputItems は `[{"item_id": 295, "amount": 1}]`
- レシピを削除：[lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parameter   | Meaning        | Values                | Example                        | Required | Notes                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | レシピ ID     | number greater than 0 | 1                             | No       | 変更または削除時に必須  |
| delete      | 削除フラグ    | true or false        | true                          | No       | 削除時のみ使用         |
| inputItems  | 入力アイテム    | Item array, see below | [{"item_id":1,"amount":2}]     | Yes      | 作成または変更時に必須  |
| outputItems | 出力アイテム   | Item array, see below | [{"item_id":3,"amount":1}]     | Yes      | 作成または変更時に必須  |
| category    | カテゴリ ID    | number greater than 0 | 1                             | No       | デフォルトは共通カテゴリ    |

!> inputItems と outputItems は JSON 配列で、各要素に item_id と amount フィールドを含みます。すべてのアイテム ID が存在し、amount は 0 より大きい必要があります

**Response:**

| Field     | Type    | Description      | Example     | Notes                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | レシピ ID       | 1           | 成功時に返却      |
| result    | Integer | 結果コード      | 0           | 下記の結果コードを参照   |
| desc      | Text    | 結果の説明 | AddSuccess | 下記の結果コードを参照   |

**Result Codes:**

| Code | Description     | Notes             |
| ---- | -------------- | ----------------- |
| 0    | Success        | 操作成功 |
| 1    | Failed         | 操作失敗  |

<br/>

### サブタスク管理

?> v1.98.0+ が必要

**Method name:** subtask

**Description:** サブタスクの作成または編集

**Examples:**

- メインタスク ID 1 にサブタスクを追加：[lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- サブタスクを編集して報酬を設定：[lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parameter     | Meaning            | Values                | Example    | Required | Notes                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | メインタスク ID       | number greater than 0 | 1         | No*      | main_id、main_gid、main_name のいずれか必須 |
| main_gid     | メインタスクグループ ID | number greater than 0 | 1         | No*      | main_id、main_gid、main_name のいずれか必須 |
| main_name    | メインタスク名     | any text             | Study task | No*      | main_id、main_gid、main_name のいずれか必須 |
| edit_id      | 編集対象サブタスク ID | number greater than 0 | 2         | No*      | 編集時は edit_id、edit_gid、edit_name のいずれか必須；作成時は不要 |
| edit_gid     | サブタスクグループ ID   | number greater than 0 | 2         | No*      | 編集時は edit_id、edit_gid、edit_name のいずれか必須；作成時は不要 |
| edit_name    | サブタスク名       | any text             | Do homework| No*      | 編集時は edit_id、edit_gid、edit_name のいずれか必須；作成時は不要 |
| todo         | タスク内容       | any text             | Do homework| No       | 新規サブタスク作成時に必須 |
| remind_time  | リマインダー時刻      | timestamp (milliseconds)| 1640995200000 | No | null を渡すとリマインダーをクリア    |
| order        | 順序              | integer              | 1          | No       | タスクリスト内の位置           |
| coin         | コイン報酬        | [0, 999999]         | 10         | No       | 完了時に獲得するコイン    |
| coin_var     | コイン変動幅      | integer              | 5          | No       | コイン報酬のランダム変動幅  |
| exp          | 経験値報酬  | [0, 99999]          | 5          | No       | 獲得する経験値        |
| auto_use_item| 自動使用アイテム      | true or false        | true       | No       | 完了時にアイテムを自動使用するか |
| item_id      | アイテム ID            | number greater than 0 | 1         | No*      | item_id または item_name のいずれか必須 |
| item_name    | アイテム名          | any text             | Health Potion| No*    | item_id または item_name のいずれか必須 |
| item_amount  | アイテム数量        | number greater than 0 | 1         | No       | アイテム報酬設定時のみ有効 |
| items        | アイテム JSON         | JSON text            | [{"item_id":1,"amount":1}] | No | 複数のアイテム報酬を一度に設定 |
| coin_set_type     | コイン値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - コイン値を直接設定<br/>relative - 元のコイン値に加算/減算 |
| exp_set_type      | 経験値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - 経験値を直接設定<br/>relative - 元の経験値に加算/減算 |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | メインタスク ID     | 1       |                  |
| subtask_id   | Number  | サブタスク ID       | 2       |                  |
| subtask_gid  | Number  | サブタスクグループ ID | 3       | 空の場合あり     |

<br/>

### カテゴリ管理

?> v1.98.0+ が必要

**Method name:** category

**Description:** カテゴリの追加または編集（タスクリスト、実績リスト、ショップリスト、合成リスト）

**Examples:**

- タスクリストを作成：[lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- ショップリストを編集：[lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parameter        | Meaning           | Values               | Example    | Required | Notes                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | カテゴリタイプ     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Yes | tasks - タスクリスト<br/>achievements - 実績リスト<br/>shop - ショップリスト<br/>synthesis - 合成リスト |
| edit_id         | 編集対象カテゴリ ID| number greater than 0| 1         | No       | 編集時に必須           |
| name            | カテゴリ名     | any text             | Study List | No       | 新規作成時に必須；編集時は任意 |
| order           | 並び順        | integer              | 1         | No       | リスト内の位置            |
| hidden          | カテゴリを非表示     | true or false        | false     | No       | tasks=アーカイブ；shop=ショップ非表示；synthesis=非表示。実績リストと合成 ALL リストは `unsupported_parameter` で拒否。`false` で再表示 |
| inventory_hidden| インベントリで非表示 | true or false        | false     | No       | ショップリストのみ対応   |
| icon_uri        | アイコン URI          | emoji, http(s) URL, content URI, or empty | 🏆 | No | 実績リストのみ対応。絵文字は `emoji_*.webp` として保存。空でクリア。 |
| desc            | 説明       | any text             | This is a description | No | 実績リストのみ対応 |
| color           | タグ色         | color string         | #66CCFF   | No       | タスクリストのみ対応；# は %23 にエスケープ |

**Response:**

| Field | Type    | Description    | Example | Notes                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | カテゴリ ID    | 1000    | 新規または編集したカテゴリの ID |

<br/>

### バックアップをエクスポート

?> v1.98.0+ が必要

**Method name:** export_backup

**Description:** バックアップファイルを作成して URI を返します（Content Provider 呼び出し専用）

!> この API は Content Provider 経由でのみ呼び出せます。URL Scheme からの直接呼び出しは非対応です

| Parameter      | Meaning        | Values          | Example | Required | Notes                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | メディアファイルを含める | true or false | true    | No       | バックアップにメディアファイル（画像、効果音など）を含めるか<br/>デフォルトは true |
| callingPackage| 呼び出し元パッケージ名 | any text      | com.example.app | No | Content Provider 呼び出し用のパッケージ識別子 |

**Response:**

| Field          | Type   | Description          | Example                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | バックアップファイル URI      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### サブタスク操作

?> v1.98.0+ が必要

**Method name:** subtask_operation

**Description:** サブタスクの完了、完了取り消し、削除

**Examples:**

- サブタスクを完了：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- サブタスクを削除：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- サブタスク完了を取り消し：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parameter     | Meaning          | Values               | Example    | Required | Notes                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | メインタスク ID     | number greater than 0| 1         | No*      | main_id、main_gid、main_name のいずれか必須 |
| main_gid     | メインタスクグループ ID| number greater than 0| 1        | No*      | main_id、main_gid、main_name のいずれか必須 |
| main_name    | メインタスク名   | any text            | Study task | No*      | main_id、main_gid、main_name のいずれか必須 |
| edit_id      | サブタスク ID       | number greater than 0| 2         | No*      | edit_id、edit_gid、edit_name のいずれか必須 |
| edit_gid     | サブタスクグループ ID | number greater than 0| 2         | No*      | edit_id、edit_gid、edit_name のいずれか必須 |
| edit_name    | サブタスク名     | any text            | Do homework| No*      | edit_id、edit_gid、edit_name のいずれか必須 |
| operation    | 操作タイプ   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Yes | complete - タスクを完了<br/>undo_complete - 完了を取り消し<br/>delete - タスクを削除 |

**Response:**

| Field        | Type    | Description      | Example | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | メインタスク ID     | 1       |                  |
| subtask_id   | Number  | サブタスク ID       | 2       |                  |
| subtask_gid  | Number  | サブタスクグループ ID | 3       | 空の場合あり     |

<br/>

### 実績管理

?> v1.98.0+ が必要

**Method name:** achievement

**Description:** カスタム実績と実績サブカテゴリの追加または編集

**Examples:**

- 実績を作成：[lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - この例を試す際は `category_id` を実際に利用可能な実績リスト id に置き換える必要がある場合があります
- 解除条件付きの実績を作成：[lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - この例を試す際は `category_id` を実際に利用可能な実績リスト id に置き換える必要がある場合があります
  - `conditions_json` のデコード内容は `[{"type":7,"target":1000000}]`
- 既存の実績を編集：[lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. 実績パラメータ

| Parameter      | Meaning           | Values               | Example   | Required | Notes                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | 編集対象実績 ID | number greater than 0 | 1      | No       | 編集時に必須          |
| is_subcategory| サブカテゴリか    | true or false        | false     | No       | デフォルトは false               |
| name          | 実績名   | any text             | Collector | No*      | 新規実績作成時に必須   |
| desc          | 説明       | any text             | Collect 100 items | No |                               |
| icon_uri      | アイコン              | emoji, http(s) URL, content URI, or empty | 🏆 | No | `icon` ではありません。絵文字は `emoji_` ファイルとして保存されます。空でクリア。 |
| order         | 並び順        | integer              | 1         | No       | リスト内の位置                |
| category_id   | カテゴリ ID       | number greater than 0 | 1        | No*      | サブカテゴリ作成時に必須 |
| unlocked      | 解除状態     | true or false        | true      | No       | true - 即時解除<br/>false - ロック状態にリセット |
| unlock_time   | 解除時刻       | timestamp (milliseconds) | 1640995200000 | No | すでに解除済みの場合のみ有効 |
| delete        | 削除フラグ       | true or false        | false     | No       |                                |
| secret        | 非表示実績| true or false        | false     | No       |                                |
| write_feeling | 気分を記録   | true or false        | false     | No       |                                |
| color         | タイトル色       | color string         | #66CCFF   | No       | # は %23 にエスケープ        |
| auto_use_item | 自動使用アイテム     | true or false        | false     | No       |                                |
| skills        | スキル ID         | array of numbers greater than 0 | 1 | No    | 配列対応（例：&skills=1&skills=2） |
| exp           | 経験値報酬 | integer              | 100       | No       |                                |
| item_id       | アイテム ID           | number greater than 0 | 1        | No*      | item_id または item_name のいずれか必須 |
| item_name     | アイテム名         | any text             | Treasure  | No*      | item_id または item_name のいずれか必須 |
| item_amount   | アイテム数量     | [1, 99]             | 1         | No       | デフォルトは 1                   |
| items         | アイテム報酬 JSON | JSON text            | [{"item_id":1,"amount":2}] | No | 複数のアイテム報酬を設定。形式は下記参照 |
| conditions_json| 解除条件 JSON | JSON text      | [{"type":7,"target":1000000}] | No | 解除条件を設定。形式は下記参照 |
| coin         | コイン報酬       | [0, 999999]      | 10         | No       | 実績解除時に獲得するコイン数 |
| coin_var     | コイン報酬変動幅 | integer              | 5          | No       | コイン報酬の変動範囲 |
| coin_set_type| コイン値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - コイン値を直接設定<br/>relative - 元のコイン値に加算/減算 |
| exp_set_type | 経験値の設定方法 | One of:<br/>absolute<br/>relative | absolute | No | absolute - 経験値を直接設定<br/>relative - 元の経験値に加算/減算 |

**Response:**

| Field  | Type    | Description      | Example | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | 実績 ID   | 1000    | 新規または編集した実績の ID |

#### 2. サブカテゴリパラメータ

| Parameter     | Meaning           | Values               | Example   | Required | Notes                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | 折りたたみ状態   | true or false        | false     | No       | サブカテゴリにのみ適用   |

サブカテゴリは `icon_uri`（絵文字を含む）を `unsupported_parameter` で拒否します。`is_subcategory=true` なしでサブカテゴリを編集すると `is_subcategory_required` が返ります。
**Response:**

| Field  | Type    | Description      | Example | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | 実績 ID   | 1000    | 新規または編集した実績（サブカテゴリ）の ID |

#### 3. 解除条件タイプ

| Type Code | Description             | Requires related_id | related_id Type | target Description  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | タスク完了回数   | Yes                | タスク ID         | 完了回数 |
| 1         | タスク連続完了  | Yes                | タスク ID         | 連続回数       |
| 3         | ポモドーロ数         | No                 | -               | ポモドーロ数 |
| 4         | LifeUp 使用日数      | No                 | -               | 日数     |
| 5         | いいね数             | No                 | -               | いいね数    |
| 6         | 日次連続完了 | No                 | -               | 連続日数        |
| 7         | 現在のコイン数          | No                 | -               | コイン数    |
| 8         | 1 日で獲得したコイン| No                 | -               | コイン数    |
| 9         | タスクのポモドーロ数    | Yes                | タスク ID         | ポモドーロ数 |
| 10        | アイテム購入回数    | Yes                | アイテム ID         | 購入回数     |
| 11        | アイテム使用回数       | Yes                | アイテム ID         | 使用回数        |
| 12        | 戦利品箱アイテム数    | Yes                | アイテム ID         | 獲得数     |
| 13        | スキルレベル到達    | Yes                | スキル ID        | レベル値        |
| 14        | 人生レベル            | No                 | -               | レベル値        |
| 15        | アイテム累計獲得数   | Yes                | アイテム ID         | 累計獲得数 |
| 16        | 合成で得たアイテム   | Yes                | アイテム ID         | 合成回数    |
| 17        | 現在のアイテム所持数  | Yes                | アイテム ID         | 所持数          |
| 18        | タスク集中時間    | Yes                | タスク ID         | 時間（分） |
| 19        | ATM 貯金           | No                 | -               | 貯金額     |
| 20        | 外部 API          | No                 | -               | API 定義        |
| 520       | 1 日に N 種類のタスクを完了 | No         | -               | 異なるタスク数（グループ ID で重複排除；既存タイプ） |
| 524       | 1 日に N 回タスクを完了 | No       | -               | 1 日の有効完了回数合計（v1.104.4+） |

> v1.104.4 以降、タイプ `520` と `524` は次の意味を持ちます：
>
> - 両方とも同じ完了定義とローカル暦日の境界（`TimeRange.today()`）を共有します。
> - 通常タスクは `COMPLETED` をカウント；負のタスクは `GIVE_UP` をカウントします。
> - タイプ `520` は有効な `groupId` で重複排除します（グループ id がない場合はタスクレコード id にフォールバック）。同じ無制限タスクを 1 日に複数回完了しても、異なるタスク 1 件としてカウントされます。
> - タイプ `524` は各有効完了行をカウントします。同じ無制限タスクを 5 回完了すると `completionCount = 5` になります。
> - 既存の `type=520` 実績は異なるタスクの意味を維持します。移行は不要です。

#### 4. JSON 形式仕様

##### 解除条件（conditions_json）

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### アイテム報酬（items）

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### スキル管理

?> v1.98.0+ が必要

**Method name:** skill

**Description:** カスタムスキル（属性）の作成または編集

**Examples:**

- スキルを作成：[lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- スキルの経験値を編集：[lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- スキルを削除：[lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parameter    | Meaning           | Values               | Example    | Required | Notes                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | スキル ID          | number greater than 0 | 1         | No       | 編集時に必須           |
| content     | スキル名        | any text             | Programming| No*      | 新規スキル作成時に必須         |
| desc        | 説明       | any text             | Coding ability | No    |                                |
| icon        | アイコン              | any text             | 💻         | No       | 絵文字を使用可能                   |
| color       | 色             | color string         | #FF6B6B    | No       | # は %23 にエスケープ        |
| type        | タイプ              | integer              | 0          | No       |                                |
| order       | 並び順        | integer              | 1          | No       | 生の混合リスト位置。単独使用時、スキルはその位置に配置され、最終グループはレイアウトから推定されます；`group_id` と併用時は、対象グループ内の最も近い合法位置にスナップされます |
| group_id    | スキルグループ ID    | integer              | 10         | No       | v1.103.0+ が必要；`0` 未満にはできず、`0` のみがスキルを未グループ化エリアに移動します。単独使用時、新規スキルは対象グループ末尾に追加され、編集時はすでにそのグループ内なら現在位置を維持、そうでなければグループ末尾に移動します；`order` と併用時は `group_id` が優先されます |
| status      | ステータス            | integer              | 0          | No       |                                |
| exp         | 経験値 | number greater than or equal to 0 | 100 | No | 現在のスキル経験値        |
| delete      | 削除フラグ       | true or false        | false      | No       | 編集時のみ有効         |

**Response:**

| Field  | Type    | Description    | Example | Notes                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | スキル ID       | 1000    | 新規または編集したスキルの ID |

<br/>

### スキルグループ管理 :id=skill_group_management

v1.103.0+ が必要

**Method name:** skill_group

**Description:** スキルグループの作成、編集、削除、並べ替え。並べ替え API はグループとスキルの混合順序にも対応します。

**Examples:**

- グループを作成：[lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- グループを編集：[lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- グループを削除：[lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- グループとスキルをまとめて並べ替え：

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parameter | Meaning | Values | Example | Required | Notes |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | スキルグループ ID | number greater than 0 | 10 | No* | 編集または削除時に必須 |
| content | グループ名 | any text | Combat | No* | 作成時に必須 |
| order | 並び順 | integer | 20 | No | 生の `orderInCategory` 値；スキル/グループ混合リスト内で一意である必要があります |
| collapsed | 折りたたみ状態 | true or false | true | No | グループが折りたたまれているか |
| delete | 削除フラグ | true or false | false | No | 編集時のみ有効 |
| sort_json | 混合ソートノード | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | No* | 指定時は CRUD パラメータを無視し、混合ソート計画を適用します。部分ソート対応：未指定ノードは相対順序を維持 |

`sort_json` ノード形式：

| Field | Meaning | Values |
| ----- | ------- | ------ |
| type | ノードタイプ | `skill` / `group` |
| id | エンティティ ID | number greater than 0 |

**Response:**

| Field | Type | Description | Example | Notes |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | スキルグループ ID | 10 | 作成 / 編集 / 削除時に返却 |
| count | Number | ソートしたノード数 | 3 | `sort_json` リクエスト時に返却 |

<br/>

### アプリ設定

?> v1.98.0+ が必要

**Method name:** app_settings

**Description:** App のインターフェース設定を調整

**Examples:**

- コンパクトモードを有効化：[lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Material You テーマを有効化：[lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- 設定を変更して UI を即座に再起動：[lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parameter              | Meaning           | Values          | Example | Required | Notes                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| コンパクトモードを有効化| true or false  | true    | No       | インターフェース要素を簡素化     |
| is_enable_material_you| Material You を有効化| true or false  | true    | No       | Material You テーマを有効化       |
| restart_activities    | インターフェースを再起動 | true or false   | true    | No       | インターフェース変更を即座に反映 |
| broadcast_event | LifeUp Labs ブロードキャストイベント | true or false | true | No | デフォルトはオフ。設定 → Labs と同じスイッチ |

**Response:**

| Field  | Type    | Description  | Example | Notes                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | 結果コード  | 0       | 0 は成功を示す      |

<br/>

### シンプルクエリ

!> ここにある機能は自動化ツール / 二次開発向けです。データの完全な一覧をクエリする必要がある場合は、[`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) および [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop) を参照してください。

**Method name:** query

**Description:** クエリパラメータ

**Example:** - 現在のコイン数をクエリ：[lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- ブロードキャストイベントスイッチをクエリ：[lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parameter   | Meaning              | Type                                                         | Example | Required                                    | Notes                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | クエリの種類        | 次のいずれか 1 つのみ：<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | yes                                         | coin - 現在のコイン数<br/>atm - 現在の ATM 残高<br/>item - 指定 `itemId` のアイテム情報<br/>item_id_list - `categoryId` で指定したアイテム ID 一覧<br/>tomato - トマトデータ<br/>task - タスク情報（v1.101.0+）<br/>broadcast - Labs ブロードキャストイベントスイッチ（`{enabled}`） |
| item_id     | アイテム id   | 0 より大きい数値                                      | 1       | key が `item` の場合は必須 |                                                              |
| category_id | ショップカテゴリ id | 0 以上の数値                            | 0       | no*                                         | key が `item_id_list` の場合のみ必須。クエリ対象リストの ID を表す。 |
| task_id / taskId | タスク ID          | 0 より大きい数値                                        | 1       | key が `task` の場合、3 つのうち 1 つ*が必須 | クエリ対象タスク ID |
| task_gid / taskGid / task_group_id / taskGroupId | タスクグループ ID | 0 より大きい数値 | 1 | key が `task` の場合、3 つのうち 1 つ*が必須 | クエリ対象タスクグループ ID |
| task_name / taskName | タスク名      | 任意のテキスト                                                     | Study   | key が `task` の場合、3 つのうち 1 つ*が必須 | あいまい一致するタスク名 |
| withSubTasks | サブタスクを含める   | true or false                                                | true    | No                                          | key が `task` の場合のみ利用可能。デフォルトは true |

**Return Value:**

バージョン 1.90.2 以降のみサポート

coin / atm をクエリする場合：

| Parameter | Meaning                             | Type               | Example | Required | Notes |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | クエリで返される数値 | number             | 1000    | yes      |       |

アイテムをクエリする場合：

| Parameter        | Meaning                         | Type     | Example   | Required | Notes |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | アイテム id              | number   | 1         | yes      |       |
| name             | アイテム名            | any text | Coffee    | yes      |       |
| desc             | 説明                     | any text |           | no       |       |
| icon             | アイコン URL                        | any text | icon.webp | no       | ローカルファイルの場合、ファイル名のみ返却 |
| category_id      | カテゴリデータ id                | number   | 1         | yes      |       |
| stock_number     | ショップ在庫数量             | number   | -1        | yes      | `-1` は無限在庫を表す |
| own_number       | インベントリ内の所持数 | number   | 10        | yes      |       |
| price            | 価格                       | number   | 100       | yes      |       |
| order            | 並び順                         | number   | 100       | yes      | カスタムソート時の重み値 |
| disable_purchase | 購入を無効化するか     | true or false | true | yes |       |
| purchase_limit   | 制限ルール               | JSON text | [{"limitType":0,"limitNumber":5}] | yes | 現在の制限一覧 |
| limit_scope      | 制限範囲               | purchase / use / both | use | yes | API テキスト値として返却 |

item_id_list をクエリする場合：

| Parameter | Meaning                           | Type   | Example | Required | Notes |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | カンマ区切りのアイテム ID 配列     | string | 1,2,3,4 | yes      |       |

tomato をクエリする場合：

| Parameter | Meaning                  | Type   | Example | Required | Notes |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | トマト合計数       | number | 100     | yes      |       |
| available | 利用可能なトマト数   | number | 50      | yes      |       |
| exchanged | 交換済みトマト数   | number | 50      | yes      |       |

task をクエリする場合（v1.101.0+）：

| Parameter   | Meaning                      | Type        | Example | Required | Notes                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | タスク ID                      | number      | 1       | yes      | -                               |
| _GID        | タスクグループ ID                | number      | 1       | yes      | -                               |
| name        | タスク名                    | text        | Study   | yes      | -                               |
| notes       | メモ                        | text        | -       | no       | 空の場合あり                    |
| status      | タスクステータス                  | number      | 0       | yes      | 0=未完了、1=完了       |
| startTime   | 開始時刻                   | number      | -       | yes      | Unix タイムスタンプ（ミリ秒）   |
| deadline    | 期限時刻                | number      | -       | no       | Unix タイムスタンプ（ミリ秒）、空の場合あり |
| remindTime  | リマインド時刻                  | number      | -       | no       | Unix タイムスタンプ（ミリ秒）、空の場合あり |
| frequency   | 繰り返し頻度         | number      | -       | yes      | -                               |
| weekdays    | 曜日                     | text        | 1,3,5   | no       | v1.106.0+；曜日モードでない場合は空。1=月曜 … 7=日曜 |
| exp         | 経験値報酬                   | number      | -       | yes      | -                               |
| skillIds    | スキル ID 一覧                | JSON text   | -       | yes      | JSON 配列形式               |
| coin        | コイン報酬                  | number      | -       | no       | 空の場合あり                    |
| coinVariable| ランダムコイン報酬           | number      | -       | no       | 空の場合あり                    |
| itemId      | 最初の報酬アイテム ID         | number      | -       | no       | 空の場合あり                    |
| itemCount   | 最初の報酬アイテム数量      | number      | -       | no       | itemId がある場合に返却     |
| items       | アイテム報酬一覧             | JSON text   | -       | yes      | JSON 配列形式               |
| words       | 完了激励メッセージ   | text        | -       | no       | 空の場合あり                    |
| categoryId  | カテゴリ ID                  | number      | -       | no       | 空の場合あり                    |
| order       | 並び順                        | number      | -       | yes      | -                               |
| name_extended | 拡張名              | text        | -       | yes      | name と同じ                    |
| subTasks    | サブタスク一覧                | JSON text   | -       | yes      | JSON 配列形式、下記参照    |

**サブタスク（subTasks）フィールドの説明：**

`subTasks` フィールドは JSON 配列で、各要素に次のフィールドが含まれます：

- `id`: サブタスク ID
- `gid`: サブタスクグループ ID
- `todo`: サブタスク内容
- `status`: サブタスクステータス（0=未完了、1=完了）
- `remindTime`: リマインド時刻（Unix タイムスタンプ、ミリ秒）
- `exp`: 経験値報酬
- `coin`: コイン報酬
- `coinVariable`: ランダムコイン報酬
- `items`: アイテム報酬一覧
- `order`: 並び順
- `autoUseItem`: アイテムを自動使用するか

<br/>

### 属性をクエリ :id=query_skill

!> ここにある機能は自動化ツール / 二次開発向けです。

**Method name:** query_skill

**Description:** 指定スキルの基本情報、生のソートフィールド、レベル / 経験値データをクエリします。

この API を使って属性ウィジェットをカスタマイズできます。

**Example:**

- 筋力属性をクエリ：[lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parameter | Meaning              | Type                    | Example | Required | Notes |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | 属性（スキル）id | 0 より大きい数値 | 1       | yes      | 取得方法は上記「Basics - LifeUp Data ID」を参照 |

**Return Value:**

バージョン 1.90.6 以降のみサポート

| Parameter            | Meaning                              | Type   | Example  | Required | Notes |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | スキル id                             | number | 1        | yes      | v1.103.0+ で `query_skill` に追加 |
| name                 | 属性名                       | string | strength | yes      |       |
| order                | 生のソート順                       | number | 20       | yes      | v1.103.0+ で追加；`orderInCategory` |
| group_id             | スキルグループ ID                       | number | 10       | yes      | v1.103.0+ で追加；スキルがグループにない場合は `0` を返却 |
| status               | ステータス                               | number | 0        | yes      | v1.103.0+ で追加；`0` = 通常、`1` = 非表示 |
| level                | レベル                                | number | 10       | yes      |       |
| total_exp            | 合計経験値              | number | 10000    | yes      |       |
| until_next_level_exp | 次レベルまでに必要な経験値 | number | 99       | yes      |       |
| current_level_exp    | 現在レベル以上で獲得した経験値       | Number | 1000     | Yes      |       |

<br/>

### スキルグループをクエリ :id=query_skill_group

v1.103.0+ が必要

**Method name:** query_skill_group

**Description:** 単一のスキルグループをクエリし、生のソート順と折りたたみ状態を返します。

**Example:**

- スキルグループをクエリ：[lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | スキルグループ ID | 0 より大きい数値 | 10 | yes | - |

**Return Value:**

| Parameter | Meaning | Type | Example | Required | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | スキルグループ ID | number | 10 | yes | - |
| content | グループ名 | string | Combat | yes | - |
| order | 生のソート順 | number | 20 | yes | `orderInCategory` |
| collapsed | 折りたたみ状態 | string | true | yes | `true` / `false` テキストとして返却 |

<br/>

<br/>

### 特殊インターフェース

#### Random

?> この API は v1.93.0 で公開されました。

**Method name:** random

**Description:** 複数の API のうち 1 つをランダムにトリガーするシンプルなランダムインターフェース。

**Example:**

- `scissors`、`rock`、`paper` を等確率でランダム表示：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- `rock` を 90%、`scissors` を 5%、`paper` を 5% の確率で表示：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parameter | Meaning    | Values                 | Example                                | Required | Notes |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | ランダム API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Yes      | 配列形式での呼び出しに対応（上記例のように複数 api パラメータ） |
| weight    | 重み     | 0 より大きい数値 | 1                                      | No       | 配列形式での呼び出しに対応。<br/><br/>weight を指定しない場合、すべて等重み（等確率）。<br/>weight を指定した場合、順番に割り当て：例えば最初の weight は最初の api パラメータに対応。<br/><br/>**weight パラメータ数と api パラメータ数を一致させてください。一致しないと効かない場合があります。** |

<br/>

#### Confirm Dialog

**Method name:** confirm_dialog

**Description:** ポップアップ選択ウィンドウが表示されます。タイトル、テキスト、肯定ボタン、否定ボタンをカスタマイズできます。ボタンクリック時に他のインターフェースも呼び出せます。

**Example:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- その他の利用シーン：
  - 報酬の選択
  - イベント分岐の選択

| Parameter       | Meaning              | Type     | Example  | Required | Notes |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | ポップアップタイトル          | any text | Title    | yes      |       |
| message         | ポップアップの詳細説明 | any text | This is the content of the popup window | no |  |
| positive_text   | 肯定ボタンテキスト | any text | YES      | no       |       |
| negative_text   | 否定ボタンテキスト | any text | NO       | no       |       |
| neutral_text    | 中立ボタンテキスト  | any text | QUESTION | no       |       |
| positive_action | 肯定ボタンのリンク応答 | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | 実際にはポップアップメッセージインターフェースのエスケープ済みテキスト。エスケープ規則は `Basics - Escaping (URL Encode)` を参照。 |
| negative_action | 否定ボタンのリンク応答 | URL (other interface) | 上記と同じ | no |  |
| neutral_action  | 中立ボタンのリンク応答  | URL (other interface) | 上記と同じ | no |  |
| cancel_action   | キャンセル操作のリンク応答   | URL (other interface) | 上記と同じ | no |  |

<br/>

#### No Action

**Method name:** placeholder

**Note:** このインターフェース自体はロジックを処理しませんが、callback と broadcast と組み合わせて使用できます。

**Example:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Variable Placeholder

`LifeUp` はパラメータに対するユーザー介入処理方式を提供します。

| Placeholder                          | Meaning                                                      | Example                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | テキストプレースホルダー                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | 数値プレースホルダー（小数点なし）                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | 数値プレースホルダー（小数点なし）、符号表示        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | 数値プレースホルダー（小数点あり）                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | 数値プレースホルダー（小数点あり）、符号表示           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | アイテムを選択し、アイテム id に置換              | [$item]                                                      |
| [$task_category]                     | タスクリストを選択し、タスクリスト id に置換    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | 時間プレースホルダー<br/><br/>Anchor Time の取りうる値：<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>ミリ秒オフセットは整数、デフォルトは 0 ミリ秒 | 今日の深夜：[$time\|today]<br/>明日の深夜：[$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | ランダム数値プレースホルダー（小数点なし）             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | ランダム数値プレースホルダー（小数点あり）                | [$random_decimal\|1.0\|2.0]                                  |

**例 1：使用時にアイテムを選択して価格を 1 コイン下げる**

例えば、特定のショップアイテムの値下げ API を設定した後、id を事前設定する代わりに呼び出し時にユーザーにアイテムを選ばせたい場合があります。

次の API は id 1 のショップアイテムの価格を 1 コインだけ下げられます：

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

アイテム id をプレースホルダ [$item] に変更するだけで、呼び出し時にユーザーが値下げしたいアイテムを能動的に選択できます：

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**例 2：タスクテンプレート — タスク名と選択リストを入力するだけで、事前設定された報酬テンプレートを作成**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### End Callback

すべてのインターフェースに callback パラメータを追加し、呼び出し後に URL をコールバックする処理を実装できます。

複数インターフェースを連結する用途にも使えます。例えばジャンプ後にプロンプトを表示したい場合：

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

callback パラメータを使用できます。上記 **Basics - Escaping (URL Encode)** も参照してください。次のような処理を記述できます：

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

もちろん、ショップアイテムに複数リンクを追加して同じ効果を得られます。

また、この callback は次の用途でより多く使われます：

X アプリ → LifeUp → X アプリ

または

X アプリ → LifeUp → Y アプリ

<br/>

#### Broadcast return value

!> ここにある機能は自動化ツール / 二次開発向けで、一定のハードルがあります。

このパラメータを追加すると、API の元の戻り値をブロードキャストで送信できます。Tasker などの自動化ツールが受信できます。

broadcast の値は、Tasker の「Intent Received」の操作列の値と同等です。対応していれば任意のテキストを入力できます。

**例：Tasker でコイン数クエリ API を使用する場合（[MacroDroid を使用している場合はこのリンクを確認してください。](https://github.com/Ayagikei/LifeUp/issues/43)）：**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. broadcast パラメータを追加し、戻り値を Tasker にブロードキャストします。`app.lifeup.query.coin` など任意のテキストで構いません。

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Tasker でイベントを追加 → 「Intent Received」、操作列に `app.lifeup.query.coin` を入力

3. Tasker のタスクは `%value` 変数として `value` の戻り値を受け取れます。

4. Tasker でコイン数を判定し、さまざまな効果を実現できます。（例：コイン数に応じてデスクトップ壁紙を変更？）

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## ブロードキャストイベント通知

!> ここにある機能は自動化ツール / 二次開発向けです。

> バージョン 1.90.2 では、さまざまなイベントを外部にブロードキャストします。Tasker などの自動化ツールでこれらのイベントを受信し、Tasker アクションをトリガーできます。
>
### 有効化

**デフォルトではブロードキャストイベントはオフです。**

`Settings` → `Labs` → `Developer mode` → `Broadcast events` で有効化できます。

### 例：アイテムで壁紙を変更

1. 「Change Wallpaper」という新しいアイテムを作成。
2. Tasker で `Configuration file` → `Event` → `System` → `Intent Received` に移動し、操作列に `app.lifeup.item.use` を入力して戻る。
3. New Task をクリックし、任意の名前を入力（例：change wallpaper）。
4. 右下の + をクリックしてタスクを追加、`Task` → `If` を選択
5. 条件列を `%name eq change wallpaper` に調整。
6. 戻り、`Insert Action` で `If` を選択。
7. 再度右下の + をクリックしてタスクを追加、`Display` → `Set Wallpaper` を選択
8. （任意）`Type` を `All` に変更
9. 画像列で 🔍 アイコンをクリックし、希望の壁紙ファイルを選択
10. 終了し、この設定が有効か確認。
11. `LifeUp` で「Wallpaper Change」アイテムを使用すると、壁紙が正常に変更されるはずです

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

`No Action` + `Broadcast return value` でより簡潔に同じ効果を実現できます。試してみてください。

<br/>

### タスク完了

**Name:** app.lifeup.task.complete

**Return value:**

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | タスク id          | 1               |
| task_gid    | タスクグループ id    | 1               |
| name        | タスク名        | Getting started |
| category_id | タスクカテゴリ id | 1               |

### タスク放棄

**Name:** app.lifeup.task.giveup

**Return value:**

| Parameters  | Meaning          | Examples        |
| ----------- | ---------------- | --------------- |
| task_id     | タスク id          | 1               |
| task_gid    | タスクグループ id    | 1               |
| name        | タスク名        | Getting started |
| category_id | タスクカテゴリ id | 1               |

### タスク期限切れ

**Name:** app.lifeup.task.overdue

**Return value:**

| Parameters | Meaning                 | Examples                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | タスク id **配列**       | [1, 2, 3]                       |
| task_gids  | タスクグループ id **配列** | [1, 2, 3]                       |
| names      | タスク名 **配列**     | [Getting started, Drink Waters] |
| task_ids_json  | タスク id **Json 配列**   | [1, 2, 3]                       |
| task_gids_json | タスクグループ id **Json 配列** | [1, 2, 3]                       |
| names_json     | タスク名 **Json 配列** | ["Getting started", "Drink Waters"]                      |

### 実績アンロック

**Name:** app.lifeup.achievement.unlock

**Return value:**

| Parameters     | Meaning          | Examples                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | 実績 id   | 1                        |
| name           | 実績名 | Using LifeUp for 30 days |

### アイテム購入

**Name:** app.lifeup.item.purchase

**Return value:**

| Parameters | Meaning           | Examples          |
| ---------- | ----------------- | ----------------- |
| item_id    | アイテム id           | 1                 |
| name       | アイテム名         | Break 10 branches |
| amount     | 購入数量 | 1                 |

### アイテム使用

**Name:** app.lifeup.item.use

**Description:** 通常のアイテム使用またはシンプルな合成使用フローが成功したときに送信されます。

**Return value:**

| Parameters | Meaning      | Examples          |
| ---------- | ------------ | ----------------- |
| item_id    | アイテム id      | 1                 |
| name       | アイテム名    | Break 10 branches |
| amount     | 使用数量 | 1                 |

### 合成完了

> [!NOTE]
> このブロードキャストイベントは v1.102.8 で公開されました。

**Name:** app.lifeup.synthesis.complete

**Description:** レシピ合成が正常に完了したときに送信されます。

**Return value:**

| Parameters   | Meaning                            | Examples                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | レシピ id                         | 1                                                     |
| formula_name | レシピ名                       | Toolbox Recipe                                        |
| times        | 実行回数                    | 3                                                     |
| input_count  | 入力アイテムエントリ数       | 2                                                     |
| output_count | 出力アイテムエントリ数      | 1                                                     |
| inputs_json  | 消費したすべての入力の JSON 配列  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | 生成したすべての出力の JSON 配列 | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notes:**

- このイベントは合成成功後にのみ送信されます。
- 材料不足、レシピ不存在、保存失敗、または `Broadcast events` が無効の場合、このイベントは送信されません。
- `times > 1` でも、1 回の API 呼び出しで送信されるイベントは 1 つのみです。
- `inputs_json` と `outputs_json` の各アイテムは次の構造を使用します：

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` はレシピあたりの数量ではなく、**この実行での合計消費 / 合計生成**です。

### 気分の追加 / 更新

**Name:** app.lifeup.feelings.add

**Return value:**

| Parameters | Meaning | Examples |
| --- | --- | --- |
| feelings_id | 気分 id | 1 |
| action_type | `add` または `update` | add |
| content | 気分テキスト | Feeling good today! |
| create_time | 作成時タイムスタンプ（ms） | 1642060800000 |
| relate_type | 関連オブジェクトタイプ | 0 |
| related_id | 関連オブジェクト id | 1 |
| attachments_count | 添付数 | 2 |
| attachments | 添付パス配列 | ["/path/1", "/path/2"] |

### レベルアップ

**Name:** app.lifeup.level.up

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | タスク id       | 1        |
| name       | 名前          | strength |
| level      | 現在のレベル | 2        |

### レベルダウン

**Name:** app.lifeup.level.down

**Return value:**

| Parameters | Meaning       | Examples |
| ---------- | ------------- | -------- |
| skill_id   | タスク id       | 1        |
| name       | 名前          | strength |
| level      | 現在のレベル | 2        |

### ショップアイテムカウントダウン

**Name:**

- 開始: app.lifeup.item.countdown.start
- 停止: app.lifeup.item.countdown.stop
- 完了: app.lifeup.item.countdown.complete

**Return value:**

| Parameters | Meaning                       | Examples                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | アイテム id                       | 1                         |
| name       | アイテム名                     | play games for 30 minutes |
| time_left  | 残り時間（ミリ秒） | 30000                     |

### ポモドーロライフサイクル

?> このブロードキャストイベントは v1.101.0 で公開され、より豊富なイベントデータを提供します。

**Name:**

- 開始: app.lifeup.pomodoro.start
- 一時停止: app.lifeup.pomodoro.pause（v1.101.0 で新規）
- 停止: app.lifeup.pomodoro.stop
- 完了: app.lifeup.pomodoro.complete

**Description:** ポモドーロタイマーが開始、一時停止、停止、完了すると、タスク情報、タイミングステータスなどの詳細データを含む対応するブロードキャストイベントが送信されます。

**Return value:**

| Parameter          | Meaning                       | Example        | Notes                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | タスク ID                       | 1              | 任意。ポモドーロがタスクに関連付けられている場合のみ存在 |
| task_gid           | タスクグループ ID                 | 1              | 任意。ポモドーロがタスクに関連付けられている場合のみ存在 |
| name               | タスク名                     | Study English  | ポモドーロに関連付けられたタスク名またはカスタム名         |
| service_type       | サービスタイプ                  | 0              | 0=集中、1=短休憩、2=長休憩                      |
| service_type_label | サービスタイプラベル            | Focus          | ローカライズされたサービスタイプテキスト                                |
| duration           | 合計時間（ミリ秒） | 1500000        | 集中または休憩の合計時間                           |
| remaining          | 残り時間（ミリ秒） | 900000     | 現在の残り時間                                 |
| elapsed            | 経過時間（ミリ秒） | 600000       | 経過した時間                                           |
| start              | 開始時刻                    | 1639123456789  | Unix タイムスタンプ（ミリ秒）                              |
| event_time         | イベント発火時刻            | 1639123456789  | Unix タイムスタンプ（ミリ秒）                              |
| reason             | 停止理由                   | user           | 停止イベントのみ。取りうる値：manual、cancel、complete、auto |

**停止理由の説明：**

`reason` パラメータは `app.lifeup.pomodoro.stop` イベントにのみ存在し、ポモドーロ停止の理由を示します：

- `manual`: ユーザーが手動で停止
- `cancel`: ユーザーがキャンセル
- `complete`: 正常完了（注：完了時は `app.lifeup.pomodoro.complete` イベントもトリガーされます）
- `auto`: 自動停止（例：タスク削除）

### 正タイマーライフサイクル :id=broadcast_positive_timing

> [!NOTE]
> これらのイベントは正タイマー機能向けであり、上記のポモドーロカウントダウンイベントではありません。使用前に `Settings` → `Labs` → `Developer mode` → `Broadcast events` が有効であることを確認してください。

**Name:**

- 開始: app.lifeup.timing.start
- 一時停止: app.lifeup.timing.pause
- 完了: app.lifeup.timing.complete
- 放棄: app.lifeup.timing.abandon

**Description:** 正タイマーが開始、一時停止、完了、または手動で放棄されると、LifeUp は対応するブロードキャストを送信します。`complete` はセッションが正常に終了し記録されたことを意味します。`abandon` は現在のセッションが手動で停止または破棄されたことを意味します。

**Return value:**

| Parameters | Meaning                        | Examples      | Notes                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | タスク ID                        | 1             | 任意。タイマーがタスクにリンクされている場合のみ存在 |
| name       | タスク名                      | Study English | リンクされたタスク名またはカスタムタイマー名          |
| time       | 累積時間（ms）      | 600000        | 現在の正タイマーの合計経過時間 |
| start      | 開始時刻                     | 1639123456789 | Unix タイムスタンプ（ミリ秒）                    |
| end        | 終了時刻                       | 1639127056789 | `complete` / `abandon` イベントにのみ存在    |

---

## 統合

他の開発者からのあらゆる形式の統合を歓迎します。

> 詳細は近日公開予定...

### さらに API が必要ですか？

API 機能は現在 1 バージョンの反復段階にあります。

今後、より多くの利用シーンに対応するため、API を継続的に追加していきます。

さらに API が必要な場合は、[Github](https://github.com/Ayagikei/LifeUp/issues/new/choose) で Issue を残してください。

<br/>

### 呼び出し方法

#### Android

##### SDK を使用

https://github.com/Ayagikei/LifeUp-SDK の `core` モジュールを参照してください。

##### SDK を使用しない

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Web ページ

Web ページから呼び出す場合、トリガーできるかはブラウザに依存します。Quark、Chrome、Edge などの一般的なブラウザは問題ありません。ただし、システム内蔵の一部ブラウザでは、ポップアップのたびにユーザーに「人生を開くか」を確認する場合があります。

組み込み WebView アプリを開発している場合、WebView が lifeup スキームを処理できることを確認する必要があります。

一貫した体験のため、`LifeUp` の商品リンク効果で「組み込みブラウザを使用」にチェックして開くこともできます。ただしセキュリティ設定により、この方法は HTTPS リンクのみサポートします（HTTP は不可）

**HTML**

ハイパーリンクで直接ジャンプ

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

実際にはハイパーリンク呼び出しと同じ

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### アプリ / Web / 自動化開発者

LifeUp 関連の開発物があればぜひお知らせください！

<br/>

### HTTP プロトコルをサポートする任意のプログラミング言語 / プラットフォーム

詳細は https://github.com/Ayagikei/LifeUp-SDK および [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) を参照してください。

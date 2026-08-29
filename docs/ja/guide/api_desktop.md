<h1 align="center" padding="100">ローカルネットワーク（API）デスクトップクライアント 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

LifeUp API をベースに、軽量なデスクトップクライアントを用意しました。Windows、Linux、macOS に対応しています。

**スタンドアロン App ではありません。** API 経由で端末内の LifeUp オフラインデータを読み取ります。

<br/>

## 機能

> [!NOTE]
> 現行版は主に API 機能の技術プレビューです。コアの閲覧操作に重点を置いており、App 内のすべての機能をカバーしているわけではありません。

- 完全オープンソース。UI のカスタマイズや独自機能の実装が可能です。
- 現在の基本機能：
  - タスク一覧の照会とタスクの完了
  - 属性一覧とレベルの照会
  - アイテム一覧の照会とアイテムの購入
  - 気分の照会とデスクトップでのフルサイズ画像表示
  - 気分の Markdown ファイルへのエクスポート
  - タスクの追加（App 内のすべてのオプションには未対応）

<br/>

## ダウンロード

デスクトップ向けパッケージはすべて [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) で公開しています。

> [!WARNING]
> デスクトップを使う前に、LifeUp Cloud が v2.0.0 以上であることを確認してください。<br/>
> GitHub Releases 版を使う場合は、`設定` → `ラボ` で LifeUp Cloud を更新してください。<br/>
> Google Play 版を使う場合は、[Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) または [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest) から更新できます。<br/>
> ブラウザのセキュリティポリシーによりインストーラーのダウンロードがブロックされる場合があります。**保持／許可**（表記はブラウザにより異なります）を選ぶか、別のダウンローダーをご利用ください。

### インストールプラットフォーム

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> MSI は現在 EV 署名されていないため、Windows が「認識されていない App」の警告を表示する場合があります。<br/>
> ファイルが公式 GitHub リリース由来であることを確認したうえで、**詳細情報 → とにかく実行** をクリックしてください。

#### **Linux**

- [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) から `lifeup-desktop.deb` をダウンロードして使用します。

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- macOS 版は十分にテストされていません。**Auto Connect** など一部機能が利用できない場合があります。

> [!TIP]
> **macOS Gatekeeper / 署名**<br/>
> 現在の macOS ビルドは公証（notarize）されていません。「開発元を確認できない」警告が表示される場合があります。<br/>
> `.dmg` を開き App をアプリケーションフォルダへ移動したあと、App を右クリックして **開く** を選ぶか、<br/>
> **システム設定 → プライバシーとセキュリティ** で **このまま開く** をクリックしてください。<br/>
> 詳細は [Apple 公式ガイド](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) を参照してください。

<!-- tabs:end -->

パッケージが一時的に欠けている場合は、後でページを更新してください。リリースアセットのアップロード中の可能性があります。

<br/>

## 使い方

### 初回セットアップ

#### 前提条件

- 端末とデスクトップは同一 LAN 上にある必要があります（例：同じ Wi-Fi）。
- <del>ネットワーク構成が複雑な場合は、まずデスクトップから端末 IP へ ping できるか試してください。</del>
  - 新しいデスクトップ版は端末 IP の自動検出に対応しているため、多くの場合は不要です。

#### 端末側

1. LifeUp を最新版に更新します。
2. LifeUp で `設定` → `ラボ` を開き、**LifeUp Cloud** をインストールします。
3. LifeUp Cloud を開き、必要な権限を付与します：
   - フローティングウィンドウ／他のアプリの上に重ねて表示する権限
   - LifeUp データ読み取り権限
4. LifeUp Cloud で **Start Service** をタップします。

**推奨する追加設定**

- LifeUp と LifeUp Cloud の両方で互換性設定を行い、バッテリー最適化を無効にしてバックグラウンド終了を減らします。
- MIUI（Xiaomi/Redmi）を使う場合は、両 App で **Display UI in background** を許可してください。
- LifeUp と LifeUp Cloud の両方を起動したままにします。

#### デスクトップ側

1. リリースパッケージからデスクトップ App をインストールします。
2. デスクトップ設定で、LifeUp Cloud に表示されるサービス IP を入力します。
   - デスクトップ v1.1.0 以降では **Auto Connect** を試せます。
3. 設定が正しければ、デスクトップで LifeUp データを閲覧できるはずです。
   - 失敗する場合は、上記の追加設定を見直してください。

### 2 回目以降

1. 端末で LifeUp と LifeUp Cloud を開きます。
2. LifeUp Cloud で **Start Service** をタップします。
3. デスクトップクライアントを起動します。

<br/>

## FAQ

<details>
<summary>デスクトップからタスクを追加できますか？</summary>

はい。現在のデスクトップ版は基本的なタスク作成に対応しています。

ただし、App 内の高度なタスクオプションのすべてがデスクトップで使えるわけではありません。複雑な設定はモバイル App を使うか、LifeUp Cloud 経由で API を呼び出してください。

</details>

<details>
<summary>LifeUp Cloud で「Request LifeUp Permission」をタップしたが反応がない／API not found と表示される</summary>

1. 反応がない場合、すでに権限を付与済みの可能性があります。
2. API not found と表示される場合は、メンバーベータに参加し、LifeUp を最新ベータ版に更新してください。

</details>

<details>
<summary>端末をロックしたあとしばらくすると、デスクトップからデータを読めなくなる</summary>

LifeUp と LifeUp Cloud の両方で互換性設定を行ってください。

</details>

<details>
<summary>LifeUp と LifeUp Cloud がバックグラウンドにあるとき、一部 API の実行に失敗する</summary>

> 基本的なデスクトップ利用には通常影響しませんが、カスタム API 呼び出しには影響する場合があります。

LifeUp Cloud にフローティングウィンドウ／他のアプリの上に重ねて表示する権限があることを確認してください。

MIUI（Xiaomi/Redmi）の場合は、両 App で **Display UI in background** 権限も有効にしてください。

</details>

<details>
<summary>Windows のインストールが `Failed to launch JVM` で失敗する</summary>

参考：[Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

ローカルの JVM アクセシビリティ設定に関連することが多いです。

一般的な回避策は、`~/.accessibility.properties` の次の行をコメントアウトすることです：

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

編集後、App を再起動して再度お試しください。

> `~` はユーザーのホームディレクトリを意味します。

</details>

<br/>

## 貢献

SDK、LifeUp Cloud、LifeUp Desktop はすべてオープンソースです。

ソースコード：

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

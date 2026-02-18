# 備份與恢復

【在 B 站檢視：《人升》2 分鐘配置堅果雲實現雲備份】 https://www.bilibili.com/video/BV1Yg411i7uM/?share_source=copy_web&vd_source=141b0b80de90aedb6b7f25458fa6b5d1

【在 B 站檢視：《人升》一鍵匯入存檔資料（恢復）】 https://www.bilibili.com/video/BV1xP411u7dV/?share_source=copy_web&vd_source=141b0b80de90aedb6b7f25458fa6b5d1

[在微信公眾號檢視本文（含堅果雲備份的設定影片教程）](https://mp.weixin.qq.com/s?__biz=MzI0OTQ4OTAxMQ==&mid=2247483867&idx=1&sn=d24068b74810d5b91b37c1abda436eca&chksm=e991f2c7dee67bd1ed49e74b3131bf7812c22f2a58a82cdac3c30182665296262a3c86a77b1d&mpshare=1&scene=23&srcid=1205mlIjJmwwyVugMJ7P25jM&sharer_sharetime=1639901809270&sharer_shareid=aefb2cf8bbd4980bf3f827f86feb6b04#rd)

## 快速導航

- [為什麼需要備份](#why-backup)
- [怎麼配置備份方式](#configure-backup)
- [怎麼備份](#how-to-backup)
- [怎麼恢復](#how-to-restore)
- [換新手機怎麼遷移](#new-phone-migration)

## 為什麼需要備份 :id=why-backup

### 1) 是否支援同步？

- ❌ 服務端直接同步資料（《人升》是離線儲存應用）
- ❌ 增量同步
- ✔️ 使用自選 WebDAV 雲服務 / Dropbox / Google Drive 進行雲儲存和同步
- ✔️ 跨裝置**手動全量**同步

### 2) 為什麼一定要配置備份？

《人升》是離線優先應用，你的大部分個人資料預設儲存在本地裝置。

這意味著如果沒有備份，在這些場景下容易丟失資料：

- 解除安裝應用
- 更換手機
- 手機損壞或丟失

**這跟你解除安裝微信會丟聊天記錄，本質上是同一類問題。**

**也跟你換手機後，微信需要遷移資料才能保留聊天記錄一樣。**

> 只有團隊、公開動態、會員等部分資料在雲端。你的本地事項、屬性、獎勵配置等核心個人資料，仍依賴你主動備份。

> [!TIP]
> 如果你在中國大陸使用，建議優先用堅果雲 WebDAV。<br/>如果你有穩定海外網路，也可以直接授權 Google Drive / Dropbox。

### 3) 備份包含哪些內容？

備份會匯出你的本地資料到壓縮檔案，包含但不限於：

- 待辦事項內容和歷史記錄
- 商品、倉庫、金幣等記錄
- 成就解鎖記錄、自定義成就
- 感想、合成、自定義屬性、番茄記錄
- 媒體檔案（事項附件、商品圖示、自定義背景、音效等）
- 選項配置

> [!NOTE]
> 勾選「忽略媒體檔案」後，媒體資源不會被匯出。

### 4) 方式對比（按簡體中文使用者習慣）

| 方法 | 解除安裝 | 手機損壞 | 自動備份 | 備註 |
| --- | --- | --- | --- | --- |
| 預設路徑備份 | ❌ | ❌ | ❌ | 僅用於臨時恢復 |
| 自定義路徑備份 | ✔️ | ✔️（匯出到外部介質時） | ❌ | 推薦作為手動備份方案 |
| 自動備份到“下載”資料夾（Android 10+） | ✔️ | ❌ | ✔️ | 可防誤解除安裝，不防裝置損壞 |
| WebDAV（推薦堅果雲） | ✔️ | ✔️ | ✔️ | 大陸使用者最實用 |
| Dropbox | ✔️ | ✔️ | ✔️ | 需要可訪問 Dropbox 的網路 |
| Google Drive | ✔️ | ✔️ | ✔️ | 需要可訪問 Google 服務的網路 |

## 怎麼配置備份方式 :id=configure-backup

> [!IMPORTANT]
> 簡體中文使用者建議優先順序：**堅果雲 WebDAV > 本地自定義路徑匯出 > 其他雲盤方案**。

<details>
<summary>配置堅果雲 WebDAV（推薦，自動雲備份）</summary>

![](_media/backup/01.jpg ': size=30%')

#### 1. 獲取 WebDAV 地址、賬號、密碼

理論上任意支援 WebDAV 協議的服務都可以。國內主流推薦堅果雲。

<details>
<summary>手機端獲取 WebDAV 資訊（含截圖）</summary>

1. 安裝並登入堅果雲 App。
   ![](_media/backup/04.png ': size=50%')

2. 在堅果雲 `設定` - `第三方應用管理` 中新增應用密碼，應用名稱可填 `人升`。
   ![](_media/backup/05.png ': size=50%')

   <br/>

   ![](_media/backup/06.png ': size=50%')

   <br/>

   ![](_media/backup/07.png ': size=50%')

3. 新增成功後，記錄 `伺服器地址`、`賬號`、`應用密碼`。
   ![](_media/backup/08.png ': size=50%')

</details>

<details>
<summary>網頁端獲取 WebDAV 資訊（含截圖）</summary>

1. 登入堅果雲官網。
2. 點右上角使用者名稱 -> `賬號資訊`。
3. 切換到安全選項。
   ![](_media/backup/02.png ': size=50%')
4. 在 `第三方應用管理` 新增應用（如：人升）。
5. 點選 `生成密碼`，儲存 `伺服器地址`、`賬號`、`密碼`。
   ![](_media/backup/03.png ': size=50%')

</details>

#### 2. 在人升內填寫配置

進入：`側邊欄 -> 設定 -> 資料備份/恢復/清除 -> WebDAV 配置`
填入三項資訊並測試連線，成功後即可使用 `備份至 WebDAV` 和 `自動雲同步`。

![](_media/backup/09.png ': size=30%')

#### 3. 配置建議

- 備份檔案大於 10 MB 時，建議開啟 `忽略媒體檔案`。
- 同時可適當拉長 `自動備份間隔`，提升成功率並減少流量消耗。

</details>

<details>
<summary>匯出到自定義路徑（手動備份底線）</summary>

這個方案是最穩妥的手動備份底線，建議長期保留：

1. 在備份頁點選 `備份`。
2. 選擇 `自定義路徑`。
3. 匯出後把備份檔案複製到電腦、U 盤、NAS 或網盤。

> [!WARNING]
> 不建議只把備份檔案留在當前手機內，否則裝置損壞時會和資料一起丟失。

</details>

<details>
<summary>授權 Google Drive / Dropbox（可選）</summary>

如果你有穩定海外網路，可以直接在備份頁授權 Google Drive 或 Dropbox，並啟用自動雲備份。

</details>

## 怎麼備份 :id=how-to-backup

### 日常推薦流程

1. 完成一次 WebDAV（堅果雲）或 Google Drive / Dropbox 配置。
2. 啟用 `自動雲備份`，設定 `自動備份間隔`。
3. 手動執行一次備份，確認流程正常。
4. 定期檢視“最近備份時間”提示。

### 關鍵節點再做一份本地匯出

在以下場景，建議再額外匯出一份到外部裝置：

- 大版本更新前
- 刷機/恢復出廠前
- 換機前

## 怎麼恢復 :id=how-to-restore

![](_media/backup/10.png ': size=30%')

<details>
<summary>從雲端恢復資料（WebDAV / Dropbox / Google Drive）</summary>

- WebDAV：在新裝置填回原來的 WebDAV 配置後，即可在恢復入口下載並恢復。
- Dropbox / Google Drive：在應用內重新授權後，直接恢復。

</details>

<details>
<summary>從本地備份檔案恢復（自定義路徑）</summary>

> [!TIP]
> 如果你安裝了堅果雲、Google Drive 等雲盤 App，也可以先把備份檔案下載到本機，再走自定義路徑恢復。

1. 將備份檔案傳到目標手機。
2. 在應用內 `恢復 -> 自定義路徑` 選擇該檔案。
3. 確認恢復（會覆蓋當前本地資料）。

> [!WARNING]
> Android 10 / 11 對儲存許可權限制更嚴格。透過 QQ、微信、部分檔案管理器選檔案時，可能出現路徑不可讀導致恢復失敗。

推薦：使用電腦整理檔案後再匯入，並優先放在易授權目錄。

以下路徑有機率因許可權問題恢復失敗：

- `檔案儲存根目錄/Android` 下任意子路徑
- `檔案儲存根目錄/Download（下載）`
- `檔案儲存根目錄/Download（下載）` 下任意子路徑

</details>

<details>
<summary>遷移到新手機（系統遷移 / 備份遷移）</summary>

#### 方案 A：系統自帶“手機遷移”（優先嚐試）

部分品牌手機支援應用資料直遷（如同品牌遷移工具、系統克隆等）。

1. 先用系統遷移工具把應用和資料遷移到新手機。
2. 遷移後開啟《人升》，檢查事項、屬性、商品等核心資料是否完整。
3. 即使遷移成功，也建議再立即做一次雲備份或本地匯出，作為新裝置的第一份備份。

> [!TIP]
> 如果你使用的是同品牌裝置，系統遷移通常是最快、最省事的方式。

#### 方案 B：透過備份檔案或雲備份遷移（通用）

1. 在舊手機先執行一次完整備份（推薦 WebDAV 雲備份 + 本地自定義路徑各一份）。
2. 新手機下載並登入《人升》。
3. 如果走雲備份：先配置同一個 WebDAV / Dropbox / Google Drive 賬號，再執行恢復。
4. 如果走檔案備份：把備份檔案傳到新手機，在 `恢復 -> 自定義路徑` 匯入。
5. 恢復完成後，建議手動觸發一次備份，確認新裝置備份鏈路也正常。

> [!WARNING]
> 恢復會覆蓋當前本地資料。新手機上如果已經錄入了新內容，建議先匯出一份再恢復。

</details>

<details>
<summary>從 QQ / 檔案系統匯入（影片教程）</summary>

<!-- tabs:start -->

#### **一鍵從 QQ 或者檔案系統匯入資料（推薦）**

需要《人升》v1.90.6 及以上。

<iframe src="//player.bilibili.com/player.html?aid=305504686&bvid=BV1xP411u7dV&cid=904969278&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

#### **Android 10 及更低版本**

<iframe src="//player.bilibili.com/player.html?aid=380415695&bvid=BV1PZ4y1S7ah&cid=479527125&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

#### **Android 11 及以上**

<iframe src="//player.bilibili.com/player.html?aid=250882869&bvid=BV1gv411g7ys&cid=419591550&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

<!-- tabs:end -->

</details>

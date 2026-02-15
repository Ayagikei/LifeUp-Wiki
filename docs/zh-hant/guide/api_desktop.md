<h1 align="center" padding="100">區域網（API） 桌面端</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>


我們基於《人升》API 開發了一款簡易的區域網桌面端，支援 Windows、Linux、macOS。

**請注意：它不是獨立執行的完整客戶端，需要透過 API 讀取你手機中《人升》的離線資料。**

<br/>

## 特性

> [!NOTE]
> 當前版本主要用於 API 能力演示與預覽，僅覆蓋部分基礎資訊瀏覽功能，尚未覆蓋全部應用能力。<br/>

- 完全開源，你可以自由修改 UI 並實現自己需要的功能
- 基礎功能：
  - 查詢任務列表、完成任務
  - 查詢屬性列表、等級
  - 查詢商品列表、購買商品
  - 查詢感想列表，並可透過電腦圖片瀏覽器檢視大圖
  - 匯出感想（Markdown）
  - 新增任務（暫未覆蓋應用內全部選項）
  - ...



<br/>

---



## 下載

### 安裝平臺

> [!WARNING]
> 使用桌面端前，請確認《雲人升》版本為 v2.0.0 及以上。<br/>
> 如果你使用的是中國大陸應用市場分發版本或 GitHub Releases 版本，可在軟體 `設定` → `實驗` 中更新《雲人升》。<br/>
> 如果你使用的是 Google Play 版本，也可直接前往 [Google Play 頁面](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) 或 [GitHub Releases 頁面](https://github.com/Ayagikei/LifeUp-SDK/releases/latest) 下載。<br/>
> 瀏覽器安全策略可能會阻止下載。你可能需要手動允許下載可執行檔案，或複製連結到其他下載器。

<!-- tabs:start -->

#### **Windows**

- **[Windows 版本](https://lifeupcdnpic.cdn.dfyun.com.cn/download/windows/stable/LifeUp-Desktop-1.2.1-windows.zip)**

> [!TIP]
> Windows SmartScreen 可能提示“無法識別的應用”。<br/>
> 請先確認檔案來自官方釋出，再點選“更多資訊”→“仍要執行”。

#### **Linux**

- 請前往 GitHub Releases 下載：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)

#### **macOS**

- 請前往 GitHub Releases 下載：[https://github.com/Ayagikei/LifeUp-Desktop/releases](https://github.com/Ayagikei/LifeUp-Desktop/releases)
- 自 v1.2.0 開始，現在會提供 x64 和 arm64 版本。如果你的是 Intel 架構的 Mac，請下載 x64 版本，如果是 Apple Silicon 架構的 Mac，請下載 arm64 版本。
- macOS 版本尚未完整測試，`自動連線`等部分功能可能不可用。

> [!TIP]
> macOS 版本目前未簽名，安裝時可能提示“身份不明開發者”。<br/>
> 你可以在系統設定中手動允許開啟，詳見：[開啟來自身份不明開發者的 Mac App - 官方 Apple 支援 (中國)](https://support.apple.com/zh-cn/guide/mac-help/mh40616/mac)

<!-- tabs:end -->

如果某個平臺安裝包暫時缺失，請稍後重新整理。Release 資產可能仍在上傳中。

<br/>



---



## 如何使用

影片教程後續補充。

使用桌面端前，需要完成以下步驟：

### 初次使用

#### 前置條件

- 手機和電腦需處於同一區域網（例如連線同一 Wi-Fi）。
- <del>⚠如果你的組網情況很複雜，請先嚐試能否在電腦上 ping 通手機的 IP 地址再做嘗試。</del>
  - 新版本桌面端支援自動檢測手機 IP，可以跳過這一步。


<br/>

#### 手機端

1. 更新你的《人升》至最新版本

2. 在《人升》`設定` → `實驗`中，找到《雲人升》並下載安裝。

   我們的桌面版需要它來讀取資料和執行操作。

3. 執行《雲人升》，授予懸浮窗許可權和人升資料讀取許可權。

4. 在《雲人升》中點選`開啟服務`。



**額外步驟**

- 建議為《人升》和《雲人升》都進行`相容性配置`，關閉電池最佳化，減少被系統誤殺，並確保鎖屏後可用。
- **如果你的手機是 MIUI 系統（小米、紅米），請確保你為《人升》、《雲人升》都允許了「後臺顯示介面」許可權。**
- 請確保《人升》、《雲人升》都在執行。

<br/>


#### 電腦端

1. 透過上文中的下載連結，下載並安裝電腦端應用。
2. 在桌面版設定頁面填寫《雲人升》顯示的服務 IP 地址。
   - **v1.1.0 版本後的桌面端，你可以嘗試點選“自動連線”按鈕。**
3. 配置完成後，如一切正常，你就可以在桌面版檢視《人升》資料。
   - **如果失敗，請回到上面的額外步驟逐項排查。**



<br/>

### 非初次使用

1. 手機上開啟《人升》、《雲人升》
2. 在《雲人升》中點選`開啟服務`
3. 執行桌面端


---



<br/>

## 常見問題

<details>
<summary>桌面端能否新增任務？</summary>

暫時不能，目前的預覽版本主要提供的是資料查詢能力，該功能會在後續版本開發。

但當前階段，你也能夠透過《雲人升》呼叫 API 來新增任務。

</details>

<details>
<summary>《雲人升》點選“讀取「人升」資料許可權”後無反應，或顯示 API 不存在？</summary>

1. 如果無反應，通常是因為你之前已授權，可視為成功。
2. 如果提示 API 不存在，請加入會員內測並更新《人升》到最新版本。

</details>

<details>
<summary>手機鎖屏一段時間後，桌面端無法讀取資料？</summary>

請為《人升》-《雲人升》進行相容性配置。

</details>

<details>
<summary>《人升》《雲人升》處於後臺時，部分介面無法正常呼叫？</summary>

> 這通常不影響桌面端基礎使用，但可能影響自定義 API 呼叫。

請確認你已授權《雲人升》懸浮窗許可權。

如果你是 MIUI 系統（小米、紅米），你還需要額外為這兩個應用，在系統設定中，配置`後臺顯示介面`許可權。

</details>

<details>
<summary>Windows 安裝失敗，顯示 `Failed to launch JVM`？</summary>

同：https://github.com/Ayagikei/LifeUp-Desktop/issues/2

這通常與系統 JVM 環境配置異常有關。



常見處理方式是將 `~/.accessibility.properties` 中以下兩行註釋：

```
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```



修改後，程式通常可恢復正常執行。

> `~` 指使用者目錄路徑。

</details>

---



<br/>

## 貢獻

SDK、《雲人升》、《桌面端》皆為開源專案。

你可以在以下連結獲取到原始碼並使用 IDEA 執行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

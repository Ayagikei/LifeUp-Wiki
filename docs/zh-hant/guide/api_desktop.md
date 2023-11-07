<h1 align="center" padding="100">區域網（API） 桌面端</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>


我們使用《人升》的API能力開發了一款簡易的區域網電腦端的《人升》，它支援 Windows、Linux、MacOS 等多端。

**但請注意，它並非一款可獨立執行的程式。它需要透過 API 讀取到你手機上《人升》裡的離線資料。**

<br/>

## 特性

!> 當前版本僅作為 API 介面的技術演示和預覽，主要提供一部分基礎的資訊瀏覽功能，並未覆蓋所有應用內功能。

- 完全開源，你可以隨意更改它的 UI 並實現自己想要的功能
- 基礎功能：
  - 查詢任務列表、完成任務
  - 查詢屬性列表、等級
  - 查詢商品列表、購買商品
  - 查詢感想列表，並能夠透過電腦圖片瀏覽器檢視大圖
  - 匯出感想
  - 新增任務（未完全覆蓋應用內的選項）
  - ...



<br/>

---



## 下載

- **[Windows 版本](http://lifeupcdnpic.cdn.dfyun.com.cn/download/release/desktop/LifeUp%20Desktop-1.1.1-windows.zip)**
- Linux（未經測試，後續釋出）
- **MacOS**
  - 請前往 Github Release 下載：[Release LifeUp Desktop v1.1.0 · Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop/releases/tag/1.1.0-macos)
  - MacOS 版本目前未簽名，安裝時需要允許操作：[開啟來自身份不明開發者的 Mac App - 官方 Apple 支援 (中國)](https://support.apple.com/zh-cn/guide/mac-help/mh40616/mac)
  - MacOS 版本未經過詳細測試，目前發現`自動連線`等部分功能可能沒法使用。
  - MacOS 的釋出版本目前僅支援 Apple 晶片（M系列晶片）。如需支援 Intel 晶片，可能需要自行編譯。


!> 1. 你需要搭配《雲人升》v1.3.0 版本或以上進行使用。如果你使用的是中國內應用市場分發的版本/GitHub Release版本，可以在軟體-`設定`-`實驗`頁面找到《雲人升》一欄並更新。如果你使用的是來自 Google Play 的版本，可以在直接在 [Google Play 頁面](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)下載或者 [GitHub release 頁面](https://github.com/Ayagikei/LifeUp-SDK/releases/latest)下載。

!> 2. 你的瀏覽器的安全策略可能會阻止下載。你可能需要手動允許瀏覽器下載可執行檔案，或者右鍵複製連結到其他下載器中下載。

<br/>



---



## 如何使用

影片教程後續補充。

爲了使用桌面端，會需要一點點操作步驟：

### 初次使用

#### 前置措施

- 你的手機和電腦處於同一區域網（比如連線同一WIFI）。
- <del>⚠如果你的組網情況很複雜，請先嚐試能否在電腦上 ping 通手機的 IP 地址再做嘗試。</del>
  - 新版本桌面端支援自動檢測手機 IP，可以跳過這一步。


<br/>

#### 手機端

1. 更新你的《人升》至最新版本

2. 在《人升》-`設定`-`實驗`中，找到《雲人升》並下載安裝。

   我們的桌面版需要它來讀取資料和執行操作。

3. 執行《雲人升》，給予懸浮窗許可權、人升資料讀取許可權。

4. 在《雲人升》中點選`開啟服務`。



**額外步驟**

- 我們建議你為《人升》、《雲人升》都進行`相容性配置`，關閉電池最佳化，避免系統錯誤殺死應用、**以及支援手機鎖屏後使用**。
- **如果你的手機是 MIUI 系統（小米、紅米），請確保你為《人升》、《雲人升》都允許了「後臺顯示介面」許可權。**
- 請確保《人升》、《雲人升》都在執行。

<br/>


#### 電腦端

1. 透過上文中的下載連結，下載並安裝電腦端應用。
2. 在桌面版的設定頁面填上你的《雲人升》中的顯示的服務 IP 地址。
   - **v1.1.0 版本後的桌面端，你可以嘗試點選“自動連線”按鈕。**
3. 大功告成~如果正常的話，你應該能夠在桌面版檢視到你的人升資料。
   - **如果失敗的話，你可能要上述的額外步驟。**



<br/>

### 非初次使用

1. 手機上開啟《人升》、《雲人升》
2. 在《雲人升》中點選`開啟服務`
3. 執行桌面端


---



<br/>

## 常見問題

**🔶桌面端能否新增任務？**

暫時不能，目前的預覽版本主要提供的是資料查詢能力，該功能會在後續版本開發。

但當前階段，你也能夠透過《雲人升》呼叫 API 來新增任務。

**🔶《雲人升》點選“讀取「人升」資料許可權”後無反應，或者顯示 API 不存在？**

1. 如果是無反應，那麼應該你之前已經授權過，當作成功即可。
2. 如果顯示 API 不存在，請加入會員內測，然後更新《人升》最新版本。

**🔶手機鎖屏一段時間後，桌面端沒法讀取資料和使用？**

請為《人升》-《雲人升》進行相容性配置。

**🔶《人升》、《雲人升》處於後臺時，部分介面沒法正常呼叫？**

> 這一點理論上不影響桌面端使用，但可能會影響自定義呼叫 API。

請確保了你授權了《雲人升》的懸浮窗許可權。

如果你是 MIUI 系統（小米、紅米），你還需要額外為這兩個應用，在系統設定中，配置`後臺顯示介面`許可權。

**🔶Windows 安裝失敗？顯示 Failed  to launch JVM**

同：https://github.com/Ayagikei/LifeUp-Desktop/issues/2

這可能是由於系統 JVM 環境有異常。



參考網上的做法是將 `~/.accessibility.properties` 檔案的以下兩行註釋即可：

```
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```



修改後，程式可以正常執行。

> ~ 指的是使用者資料夾路徑

---



<br/>

## 貢獻

SDK、《雲人升》、《桌面端》皆為開源專案。

你可以在以下連結獲取到原始碼並使用 IDEA 執行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

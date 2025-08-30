<h1 align="center" padding="100">開放介面與呼叫</h1>

<p align="center">動手創造無限可能性！</p>





?> 在 v1.90 版本中，`人升`既開放了多種功能介面，歡迎任意外部應用聯動。<br/>亦提供了商品的“連結”效果，使用者可以直接使用商品來呼叫外部應用或者《人升》的介面。<br/>這可以使你的`人升`獲得無限的可能性，但也需要你有一定的學習理解和動手能力。



**2025/08/30**

本文的 API 引數和定義基於 v1.100.0 版本編寫。

使用 API 前，建議將應用升級到 v1.100.0 版本，如果沒法檢測到更新，請切換更新渠道到【會員內測-嚐鮮版】。



## 場景示例

| 呼叫方                                    | 場景                                                         | 備註     |
| ----------------------------------------- | ------------------------------------------------------------ | -------- |
|**人升 ->外部應用**<br/>商品的“連結”效果 | **使用商品後：**<br/>1. 使用瀏覽器訪問某個網頁<br/>2. 跳轉微信掃一掃，或指定小程式<br/>3. 自動新增記賬記錄（[如《錢跡》支援記賬介面](http://docs.qianjiapp.com/plugin/auto_tasker.html)）<br/>4. 儲存自動化工具 Tasker 配置（甚至分享到櫥窗），使用後自動將配置匯入 Tasker<br/>5. 使用 Tasker 隨機切換桌面桌布<br/>6. 觸發 Tasker 顯示自己編寫的互動 UI 邏輯<br/>7. ... （只要外部應用支援該方法呼叫）<br/> | 任意使用者都可呼叫<br/>Tasker 是一款自動化工具，並且它支援將配置匯出成 Uri |
|**人升 ->人升**<br/>商品的“連結”效果     | **使用商品後：**<br/>1. 開啟人升某個頁面<br/>2. 提升 ATM 利率<br/>3. 彈窗讓使用者選擇商品，降低商品價格（降價券）<br/>4. 觸發某個任務完成<br/>5. 彈出自定義的激勵語訊息<br/>6. 創造任務獎勵模板，只需要輸入名稱即可自動建立任務<br/>7. 彈窗詢問使用者的分支選擇，創造情景化的小互動<br/>8. 更多應用內的操作... | 👑僅限會員使用 |
|**外部應用/網頁 ->人升**                 | **配置自動化工具：**<br/>1. 判斷每天第一次開啟手機的時間，完成早起任務，或者直接觸發“晚起”懲罰<br/>2. 每背完 25 個單詞，刷一次特定的 NFC 卡片，自動打卡任務<br/>3. GPS 判斷到達某個新地方，解鎖“新地點”成就<br/>4. 每天連線打工 WIFI 時，觸發解鎖條件進度增長。累計 20 天的時候，解鎖「打工人」成就<br/>5. 每天首次連線家裏 WIFI 時，獎勵自己“到家”金幣<br/>6. 捕獲其他番茄或專注軟體的通知，自動將計時記錄到人升中<br/>7. 捕獲運動類、背單詞類軟體的完成或結束通知，自動發放「力量」、「學識」經驗值<br/>8. 在自己設定的時間段內，每開一次手機，觸發一次懲罰<br/>9. ...<br>**外部應用聯動/自己開發應用：**<br/>1. 若不滿意「人升」的番茄鍾：可以自己開發計時軟體，可以是網頁應用或安卓應用，透過介面與「人升」聯動，以新增計時記錄或新增獎勵<br/>2. 改動一些智力小遊戲（如下文中有個 Wordle 例子），成功完成遊戲時，觸發「人升」傳送獎勵<br/>3. 開發應用與「人升」聯動實現應用鎖功能 | 👑僅限會員使用 |

<br/>換種說法，上述所有場景其實都是「事件」觸發了「操作」。

而`人升`本次更新是提供了「使用商品」這個事件觸發點，然後是提供了各式各樣的「操作」（獎勵、完成任務等等）。

如果你需要

- 點選網頁按鈕
- 刷 NFC 卡片
- 每天起床第一次解鎖螢幕

這種觸發事件，就需要使用到外部的自動化工具，或者透過程式設計實現。



如果是應用內的指標事件，你可以透過搭配成就來實現。

**如果你想實現，力量達到5級後，提升 ATM 利率0.01%。就可以透過功能組合實現：**

> 成就跟蹤力量等級 -> 達到5級後，自動解鎖成就 -> 獲取特殊商品獎勵 -> 使用後提升 ATM 利率。

諸如番茄鍾專注時長之類的場景也能舉一反三。



**人升1.90.2更新將會增加一系列「廣播事件通知」，但這些事件需要由自動化工具或者外部應用接收。**

可以用來實現：

使用商品後，觸發 Tasker 等自動化工具切換桌面桌布。

完成任務後，觸發 Tasker 等自動化工具開啟某個 App。

**換種說法，就是 1.90.2 版本之前，只能由「Tasker的事件」觸發「人升的操作」。**

**而在 1.90.2 版本，可以實現「人升的事件」觸發「Tasker的操作」。**

Tasker 擁有著極高的許可權，可以實現操作更換桌布、解除安裝應用、提升音量、選擇開啟指定 app 等等操作。甚至可以自己無程式設計基礎編寫 UI 互動邏輯。



---

## 使用建議

**如果你不熟悉網路或計算機基礎知識，**你可以直接在櫥窗搜尋、進貨相關的商品；也可以嘗試根據示例或者其他人的商品，編輯引數。

**如果你熟悉相關基礎知識，**可以嘗試閱讀下述的介面文件，自己編輯出所需的效果。並且搭配自動化軟體（如 Tasker）使用，即便不會編輯 Tasker 的配置，只要你能成功安裝 Tasker，也能在櫥窗或者其他社羣匯入其他人分享的自動化配置。

**如果你有程式設計基礎，**可以嘗試開發網頁、安卓應用與人升聯動。這個網頁就是個超簡單的例子。或者編寫自動化工具的配置，分享給大家！

<br/>
如果你在使用途中遇到了任何關於 API 自身的問題，歡迎隨時反饋~

但如果你是使用外部工具如 Tasker、獲取外部應用的 API，或者學習程式設計遇到了困難，**我們僅提供有限支援**。因為這並非我們職責，我們需要將有限的時間投入到《人升》的維護開發中。如需長時間支援，請走付費諮詢流程~感謝理解。

---

## 呼叫外部 APP

如果你想要在「人升」中呼叫外部應用，只需要為商品新增“連結”效果，並**輸入網頁或應用專屬連結**，再使用該商品即可完成呼叫。


### 示例

**以下是一些示例，你可以把這些連結新增到「人升」中任意商品的「連結」使用效果裡觸發，也可以直接在這裏點選確認效果：**

- 瀏覽器開啟百度：https://www.baidu.com
- 微信：[weixin://](weixin://)
- <del>微信掃一掃（可能失效了）：[weixin://scanqrcode](weixin://scanqrcode)</del>
- 支付寶掃一掃：[alipayqr://platformapi/startapp?saId=10000007](alipayqr://platformapi/startapp?saId=10000007)
- 支付寶螞蟻森林：[alipays://platformapi/startapp?appId=60000002](alipays://platformapi/startapp?appId=60000002)
- 支付寶高德地圖：[alipays://platformapi/startapp?appId=2018070960585195](alipays://platformapi/startapp?appId=2018070960585195)
- 支付寶記賬：[alipay://platformapi/startapp?appId=20000168](alipay://platformapi/startapp?appId=20000168)
- QQ：[mqq://](mqq://)
- 網易雲：[orpheuswidget://](orpheuswidget://)
- 網易雲聽歌識曲：[orpheuswidget://recognize](orpheuswidget://recognize)
- 錢跡的自動化記賬介面：[自動化記賬介面 · 錢跡使用者指南 (qianjiapp.com)](http://docs.qianjiapp.com/plugin/auto_tasker.html)
- ...

理論上，只要外部 APP 開放了對應的連結，你就可以透過使用商品的方式進行跳轉。

**這些連結與「人升」無關，「人升」只提供跳轉功能。**

**因此我們不會也沒人力維護連結列表。**

**但由於「世界」-「櫥窗」已支援上傳連結類商品，你可以搜尋櫥窗是否有你想要的商品。**

<br/>

### 如何獲取上述 URL 連結

> 獲取其他應用的 URL 連結並不屬於**人升**的功能、會員的權益或者開發者的職責，此處僅為簡單介紹。

**常規方式**

- 使用網路搜尋`URL Schemes`的方式搜尋你需要的應用連結。
- 在「人升」`世界`-`櫥窗`搜尋應用，檢視是否有人已經分享過連結。
- 查詢對應的應用使用文件，查閱或諮詢開發者有沒有提供。
- 諮詢對應的開發者。

<br/>

**非常規方式**

> 透過這種方式獲取的 URL 不一定能夠正常或穩定使用。

- 檢視對應的 H5 網頁跳轉應用的網頁原始碼。
- 使用技術手段檢視 AndroidManifest 檔案。

<br/>

**透過第三方高許可權 APP 做跳板**

比如 Anywhere（方法由使用者 @喵喵喵 貢獻），可以在**酷安**下載。

\>>需要的app：***Anywhere-***，*當前Activity*

\>>>方法：使用 Anywhere- 的 活動列表——選擇需要開啟的活動——點選即可自動製作卡片——然後長按卡片——自動生成了卡片的URL——長按複製入人升商品使用中即可(不需要鎖定Anywhere-在後臺) 

\>>>> *Anywhere-*：一般用app(Launcher)就可以直接開啟選中的app，還可以直接制卡快捷搜尋看看 **捷徑社羣** 裡有沒有app的直接URL，有的話就直接把appURL直接輸入人升連結中就行。(一個一個活動試也是有用的)

\>>>>> *當前Activity*：使用 *當前Activity* 可以檢視當前活動的名稱，以便在Anywhere- 中選擇活動。





---

## 呼叫人升

如果你：

- 需要在「人升」中呼叫「人升」的介面，也是隻需要為商品新增“連結”效果，並**輸入網頁或應用專屬連結**，再使用該商品即可完成呼叫。
- 透過網頁呼叫，則只需要超鏈接跳轉我們的介面連結即可。
- 透過自己開發的 APP 呼叫，只需要使用 Intent 跳轉對應的介面連結即可。
- 透過自動化工具（如 Tasker）呼叫，在合適的地方填入對應的介面連結即可。



### 連結🔗

**一些例子：**

當你點選下面這個連結，「人升」會彈出提示“你學會了呼叫！”。

[lifeup://api/toast?text=你學會了呼叫！&type=1&isLong=true](lifeup://api/toast?text=你學會了呼叫！&type=1&isLong=true)

當你點選下面這個連結，「人升」中會獲得一個金幣，並且獲得原因為“學習API呼叫”。

[lifeup://api/reward?type=coin&content=學習API呼叫&number=1](lifeup://api/reward?type=coin&content=學習API呼叫&number=1)

當你把連結複製到商品的“連結”效果中，使用商品也能夠觸發類似的效果。



### 外部網頁🌐（Wordle）

**一個外部應用聯動的例子：**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/zh-cn/example/wordle/index.html)

Wordle 是猜單詞的小遊戲：猜長度為 5 的單詞。橙黃色代表答案的單詞中包含該字母。綠色代表包含且位置正確。

**該版本的 Wordle 支援與「人升」聯動：**

1. 當你猜中了單詞，能夠獲得 10 點金幣。並且有對應的獲得原因。
2. 當你最終也沒猜中單詞，會有安慰獎 1 點金幣。

![](_media/api/wordle.png ':size=30%')

<br/>

### 自動化工具-Tasker

**與 Tasker 聯動的例子：**

?> Tasker 是一款付費的自動化工具，需要從 Google Play 或官網付費獲取正版。如果你沒有對應的渠道，也可以試試下方的 MacroDroid。

> Tasker 呼叫的方式是，選擇`操作類別`-`程式`-`快捷方式`。在快捷方式一欄輸入 lifeup:// 開頭的連結即可。

每天 5 點後第一次解鎖螢幕，能觸發完成一個名稱包含“起床”的任務。

**注意：你需要先自己建立這個名字包含“起床”的每日任務。**

如果你已經安裝了 Tasker，[點選這裏可以匯入已經配置好的任務。](taskerproject://H4sIAAAAAAAAAKVWTW/TQBA9p78iskRPxV7biZNQxyiFHCpFCLVVLxzQKt6kWxzHsrdBvRWEVFS1KkgIIW6IigKqWi6IEvFv2qThxF9g1rv5atyKlEs8nje7fjtv3ir2Co6ekPA+ZjgdhUVFSbstWlR0Jc1aRcVSkaojxZlJ2Q/DZo16JC4KIDYNJd0iRcXgaMquupgRR7cslLFMlMnqRt7WRJLDZBQ2MlnTMG2NDOCah+uRAytEwFPUdUzD1uDB3xrURY4OBXHAM36DON2T/c7Bl4ujo/PTre7Rh97hx99vnv35tds7/NTZf9053u2+fHW2tdv7/qPT3jnb2rM1voqvLreIz+KzVJs+Gj0JHKXpAlWEEByAh7xeixfE4TID1v2letJSKztcmbLvNX2XMtr0KzQSn6Q1UT6Cif0kEVPCKdtbi5xbPnnq4k1b4y8y3wwcHZoDD5kIAbO1sF9ha4OdBQltjIU4UnwQLq0mtU2U2ZxG5qoXOCzcIJDzgknhdTNv5tE/CG9eEr6QKHz24vnP3vHB+Wm7++6k+/bbxfsXMAgADHVeoQ0ylFn0orbmgEDwK94aDjCC3/iNxRiTGIsx1hD94nsltGudVFm/Xevoym4ZOSOHCmPd8jFseN5ud/a2e9tfOzufxcQCeyzpB9SNwAZzvCFxzJOMB3p+jneFiWTMiRPhMXd0TIhBoOfHqQCJjJWxcnrBmsKfIAY3n9QkCCn3B1CCgCdK1cEM4yqTPciNeiKbKYx6YpmFojqsD2d+MOiAirJF6VEo40bDXlFBijaBGddg5jhma4JrAm09gbaZQ6O0I+LUsBfBeEcys7Dhu9It8Vmk/VahKk7Ctwdm9glTXerXPRpV11Tsu2GTuiqL7191qVwpr5YerDxeLS0tlhYq5WVn1mPz0ApYUQpDvCmuZ222zuZhQqbc62YUbrPNgDiPKuu4hVUP+3VV8JmegNhJ3k28O/JaEv2bGAp9MBQerZGN4I6m4YCCEo3AI4zc5QYpimt9MC4j0oJXgcikFwpJXkAoa6IrvYAsM1/IXfZC4f+8kLuBFxK7oyebZQpDjGGZa7CsxMwEzJKYPmGyvhLiKf5nODN/AQAzsyt1CAAA)



![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

### 自動化工具-MacroDroid

**MacroDroid 的呼叫方式：**

> MacroDroid 也是一款自動化工具，它可以免費下載，UI也更加易用。

1. 增加宏，然後設定你所需要的條件（或者稍後設定）
2. 新增`動作`
3. 選擇`應用程式`
4. 選擇`開啟網站`
5. 在`輸入網址`一欄輸入 `lifeup://` 開頭的 URL 地址
6. 【取消勾選】下面的所有可選項，比如不要勾選`URL引數編碼`...
7. 儲存即可，可以點選該動作，然後選擇`測試`動作進行驗證

<br/>


> 你可以透過新建`觸發器 - 裝置事件 - 收到 Intent`，向「動作框」中填入下方`廣播事件通知`對應的名稱，來呼叫人升中功能多樣的傳入廣播觸發功能。(intent Extra 中，Extra 名稱對應`返回值引數`)
> 對於引數取值為「JSON文字」的複合型資料型別，你可以透過新建`動作 - 網路互動 - HTTP 請求`，參考開放介面中「雲人升」文件中的配置資訊進行配置

**透過該功能，無論你是否會開發，你都可以無限擴充套件人升的可能性！**

具體呼叫規則請看下文。

---

## 基礎知識

### 基礎知識 - 示例

人升的 API 是以 URL Scheme 的方式提供的。

URL（Uniform Resource Locator，統一資源定位符）是用於定位網際網路上資源的地址。它的結構通常包括以下部分：

```
scheme://host/path?query
```

- scheme: 指定協議，例如 http、https 或應用自定義的 Scheme（如 lifeup://）。
- host: 資源所在的伺服器地址（在自定義 URL Scheme 中可以省略）。
- path: 資源在伺服器上的路徑。
- query: 查詢引數，通常用於傳遞資料。

<br/>

URL 並不算是程式語言，它只是一個描述資源的地址。跟網址其實是類似的，它也能實現跳轉到 app 內的某一個頁面。

在人升的 API 中，一個 URL 基本可以代表一個應用內的操作，比如以下這個示例就是讓「人升」彈出一個提示：

| 型別     | 說明                                                         |
| -------- | ------------------------------------------------------------ |
| 示例     | [lifeup://api/toast?text=你學會了呼叫！&type=1&isLong=true](lifeup://api/toast?text=你學會了呼叫！&type=1&isLong=true) |
| 介面格式 | 固定字首/方法名?引數1=數值1&引數2=數值2                      |
| 固定字首 | lifeup://api/                                                |
| 方法名   | toast                                                        |
| 引數     | ?text=你學會了呼叫！&type=1&isLong=true                      |


<br/>

### 基礎知識 - URL 轉義（編碼）

URL 中的某些字元，如空格或特殊符號，不能直接在 URL 中使用。又或者是一些符號有特殊含義：比如`&`一般作為引數的拼接，`:`、`/`是URL的基本組成成分，它們作為一個引數的值時，就需要進行轉義（編碼）操作，以便程式將它們認為是一個值。

爲了確保 URL 可以正確傳輸和解析，需要對這些字元進行編碼。URL 編碼將這些字元轉換為百分號 % 開頭的編碼值。


| 特殊字元 | 代表含義                     | 替換內容 |
| :------- | :--------------------------- | :------- |
| +        | URL 中+號表示空格            | +        |
| 空格     | URL中的空格可以用+號或者編碼 | %20      |
| /        | 分隔目錄和子目錄             | %2F      |
| ?        | 分隔實際的URL和引數          | %3F      |
| %        | 指定特殊字元                 | %        |
| #        | 表示書籤                     | %23      |
| &        | URL 中指定的引數間的分隔符   | %26      |
| =        | URL 中指定引數的值           | %3D      |

比如上述例子中的文字內容，如果要最終提示的文字是：`?text=你學會了呼叫！`

則需要替換文字中的特殊符號`?`和`=`為，最終效果為：

[lifeup://api/toast?text=%3Ftext%3D你學會了呼叫！&type=1&isLong=true](lifeup://api/toast?text=%3Ftext%3D你學會了呼叫！&type=1&isLong=true)

<br/>

!> 手動處理編碼問題十分容易出錯，僅適用於簡單場景。複雜場景請考慮使用對應的開發工具或者庫，它們將自動為你處理編碼。🧑‍💻

大多數現代開發工具和庫都會自動處理 URL 編碼和解碼，因此開發者只需確保傳遞的資料格式正確。

<br/>

**這是一個用 JS 實現的簡單編碼工具：**

這個工具會將中文、空格、各種符號編碼。

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

2024/10/04更新：

由於編碼方面太容易出現問題， 市面上也很少面向普通使用者的URL Builder（構造工具），我們嘗試使用 AI 協助開發了一款 URL 構造器。

在其中，你只需要按照 API 定義填入 API 名稱、引數名稱（鍵）和引數數值即可。

[點選這裏跳轉到工具](https://wiki.lifeupapp.fun/zh-cn/guide/html/url-builder-parser.html)

<br/>

### 基礎知識 - URL 巢狀

有些 API 支援將 完整的 URL 作為查詢引數傳遞，這被稱為巢狀 URL。巢狀 URL 必須經過額外的**兩次**URL 編碼，以確保它們在整個 URL 中正確解析。具體來說，巢狀的 URL 中的特殊字元不僅需要進行常規編碼，還需要對包含的 URL 本身進行額外的編碼。

在這個例子中，我們希望透過 lifeup://api/random 介面，隨機呼叫顯示“石頭”、“剪刀”或“布”的 toast 介面。爲了實現這一目標，

1. **原始URL**

其實這是由一層巢狀實現的 API。其中作為引數的三個原始 API 為三個 `toast` API 呼叫，它們分別用於顯示“石頭”、“剪刀”和“布”：

- lifeup://api/toast?text=石頭
- lifeup://api/toast?text=剪刀
- lifeup://api/toast?text=布

2. **第一次 URL 編碼**

因為我們將這些 API 呼叫作為引數傳遞給 lifeup://api/random，所以需要對巢狀的 URL 進行第一次編碼。主要是對特殊字元（如 :、/、? 和 =）進行編碼。

- lifeup://api/toast?text=石頭 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭
- lifeup://api/toast?text=剪刀 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀
- lifeup://api/toast?text=布 -> lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布

3. **組合巢狀 URL**

接下來，將這三個編碼後的 URL 作為 lifeup://api/random 的查詢引數傳遞

```
lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布
```

<br/>

### 基礎知識 - 複雜場景下 URL 應如何編寫？

我們設計這套 API 的初衷是爲了讓社羣開發者能夠利用《人升》作為基礎平臺，進行二次開發和擴充套件更多的功能。例如，開發者可以獲取《人升》的資料，來設計個性化的小部件、人物形象等擴充套件內容。

隨著開發的推進，我們發現《人升》的商品和效果可以很好地與 API 融合。爲了降低使用門檻，讓更多使用者輕鬆體驗 API 的功能並參與開發的樂趣，我們增加了一些簡化的 API 機制。這些機制讓使用者即便對 URL 概念瞭解不深，也能輕鬆實現一些簡單的 API 呼叫：

- 商品呼叫 API（無需外部呼叫）
- 應用內顯示資料 ID（無需透過介面獲取 ID）
- 模糊搜尋商品名稱（ID 可選）
- 輸入、隨機佔位符，彈窗 API（無需外部開發或自動化工具即可實現簡單互動）

這些機制的目的是幫助使用者「快速體驗 API」，它們適用於簡單的場景，而不適合複雜的條件控制或邏輯操作。如果我們在《人升》中加入過多的基礎控制邏輯，它就會逐漸變成一個“自動化工具”或“程式設計軟體”，這並非我們 API 的設計初衷。

API 的核心價值在於開放介面，主要面向外部開發，而非僅限於內部使用。它的主要應用場景包括：

- 無需程式設計門檻的快速體驗：使用者可以輕鬆呼叫商品的使用效果
- 無需程式設計門檻的自動化應用：透過 Tasker、Macrodroid 等自動化工具整合
- Android 開發：提供 SDK 支援
- 跨裝置開發（桌面端）：支援雲人昇平臺

<br/>

雖然這些簡化機制讓更多使用者體驗到了 API 的便利，但也帶來了某些誤解。爲了避免錯誤的理解和資訊傳播，我們在這裏做一些澄清：

> 1. URL 機制設計不合理，一會需要編碼，一會又不需要編碼。

URL 和編碼標準是由網際網路標準規定的，並非《人升》的獨特設計。具體細節請參考：[https://en.wikipedia.org/wiki/Percent-encoding](https://en.wikipedia.org/wiki/Percent-encoding)

編碼的需求非常明確：在 URL 中，每一個查詢引數的“值”都需要進行編碼。這是標準化的要求，不是偶然現象。

> 2. URL 引數順序影響執行邏輯。

絕大多數情況下，URL 引數的順序是無關緊要的，不會影響 API 的執行邏輯。解析是基於引數名稱，而不是順序。

目前只有隨機（`random`） API 的比重引數與順序有關。

> 3. URL 不能巢狀超過兩層。

實際上，URL 可以根據需要進行多層巢狀，巢狀層級沒有限制。錯誤的巢狀通常是因為沒有正確理解 URL 規範。

> 4. URL 中的中文千萬不要編碼，否則會出錯。

根據規範，URL 中的中文字符是需要編碼的。然而，由於 Android 的 API 容錯機制，即使未編碼的中文也能正確解析，但爲了相容性和標準化，建議始終進行編碼。

---

**建議：** 對於複雜的 URL 場景，請使用程式或工具來協助生成正確的 URL，以避免不必要的錯誤。如果希望更好地利用 API，建議多瞭解一些 URL 規範，這樣能夠更準確地編寫和除錯 API。


<br/>

### 基礎知識 - 人升資料 ID

「人升」中的資料儲存基本都會有一個唯一 id。

下述的部分介面支援修改**指定**的商品、完成**指定**的任務。

爲了讓「人升」能找到對應的資料，你需要為其提供 id。

**你可以啟用「設定」-「實驗」-「開發者模式」，即可在應用內的各個詳情頁面檢視到資料的原始id。**

比如力量（1），它的屬性id就是1。

#### 事項 id

可以在事項詳情頁面檢視。

id：如果是重複任務，每次重複，id都會更新。

gid: 事項組id，針對同一個重複任務，其 gid 都不會發生變化。

#### 清單 id

開啟「開發者模式」後，在「選擇清單」彈窗檢視。

#### 屬性 id

開啟「開發者模式」後，在「自定義屬性」頁面檢視。

#### 商品 id

「開發者模式」，然後點選商品檢視詳情檢視。

#### 成就條件 id

為成就自定義解鎖條件「需要外部API呼叫以解鎖」後，可以在詳情頁面看到條件id

<br/>

### 基礎知識 - 返回值

有一部分介面可能會有返回值。

**如果你是在開發 Android 應用，**可以用`onActivityResult`方法接收返回值。

**如果你是用 Tasker 等自動化應用：**

一般這類應用沒法接收 Activity 型別的返回值。所以你需要增加一個 broadcast 引數，然後使用`收到的意圖`事件來接收返回值。

詳情可以檢視下文的 broadcast 廣播引數。

<br/>

### 基礎知識 - 排序依據（order）

部分 API 介面提供了排序依據（`order`）的設定欄位：

`order` 欄位用於確定專案在列表中的相對排序。

**注意：`order` 的數值本身並無獨立意義，只有在與其他專案進行對比時才發揮作用**。

因此，更新 `order` 欄位時，建議您 **同時對多個專案的 `order` 值進行交換或對整個列表的 `order` 值進行重新排序**，以確保排序結果的可預測性。

**請勿僅更新單個專案的 `order` 值**，因為這將導致排序結果不可預期。

此外，App 的內部排序邏輯可能會根據不同版本隨時進行調整，單次更新 `order` 值無法保證在未來版本中的一致性或預期效果。

### 基礎知識 - JSON 數據結構

?> 需要 v1.98.0+

本節介紹 API 中常用的 JSON 數據結構。

#### 1. 物品獎勵結構

用於指定物品獎勵的 JSON 陣列，每個物品包含 ID 和數量。

```json
[
    {
        "item_id": 1,    // 物品ID
        "amount": 2      // 數量
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. 成就解鎖條件結構

```json
[
    {
        "type": 7,           // 條件型別
        "related_id": null,  // 關聯ID（部分型別必須提供）
        "target": 1000000    // 目標數值
    }
]
```

#### 3. 購買限制結構

```json
[
    {
        "type": "daily",     // 限制類型：daily（每日）、total（總計）
        "value": 5           // 限制數量
    }
]
```

#### 4. 商品效果結構

```json
[
    {
        "type": 2,           // 效果型別
        "info": {            // 效果引數，根據type不同而不同
            "min": 100,      // 最小值（用於金幣獎勵等）
            "max": 200       // 最大值（用於金幣獎勵等）
        }
    }
]
```

#### 效果型別說明

| 型別程式碼 | 含義 | 引數說明 |
| ------- | ---- | ------- |
| 0 | 無特殊效果 | 無需引數 |
| 1 | 不可使用 | 無需引數 |
| 2 | 增加金幣 | min: 最小金幣數<br/>max: 最大金幣數（可選，不填則等於min） |
| 3 | 減少金幣 | min: 最小金幣數<br/>max: 最大金幣數（可選，不填則等於min） |
| 4 | 增加經驗值 | ids: 技能ID陣列<br/>value: 經驗值<br/>using_limit: 是否使用限制（可選，預設false） |
| 5 | 減少經驗值 | ids: 技能ID陣列<br/>value: 經驗值<br/>using_limit: 是否使用限制（可選，預設false） |
| 6 | 簡易合成 | require_number: 需求數量<br/>item_id: 物品ID |
| 7 | 開箱 | items: 物品陣列，每個物品包含：<br/>- item_id: 物品ID<br/>- amount: 數量<br/>- probability: 機率<br/>- is_fixed_reward: 是否固定獎勵 |
| 8 | 倒計時 | seconds: 倒計時秒數 |
| 9 | 網頁連結 | url: 連結地址<br/>use_web_view: 是否使用內建瀏覽器（可選，預設false） |

**效果示例：**

增加隨機金幣：
```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

增加經驗值：
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

開箱效果：
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

## 介面文件

### 彈出訊息

**方法名：**toast

**說明：**彈出各種樣式的訊息

**示例：**[[lifeup://api/toast?text=好好生活，好好吃飯！&type=1&isLong=true](lifeup://api/toast?text=好好生活，好好吃飯！&type=1&isLong=true)](lifeup://api/goto?page=lab)

**解釋：**以獎勵樣式彈出提示“好好生活，好好吃飯！”，並且顯示較長時間。

> 點選示例的連結可以測試效果

| 引數   | 含義             | 取值            | 示例           | 是否必須 | 備註                                                         |
| ------ | ---------------- | --------------- | -------------- | -------- | ------------------------------------------------------------ |
| text   | 要提示的文字訊息 | 任意文字        | 你學會了呼叫！ | 是       |                                                              |
| type   | 文字樣式型別     | 數字從0到6其一  | 1              | 否       | 0 - 普通樣式<br/>1 - 獎勵樣式<br/>2 - 番茄樣式<br/>3 - 成功樣式<br/>4 - 提示樣式<br/>5 - 警告樣式<br/>6 - 錯誤樣式 |
| isLong | 顯示時長         | true 或者 false | true           | 否       | true - 長<br/>false - 短                                     |

<br/>

### 獎勵

**方法名：**reward

**說明：**直接提供獎勵，可定製獎勵理由

**示例：**

- 獲得 1 點金幣，獲得原因為「學習API呼叫」。且原因會在金幣詳情頁面展示：

  [lifeup://api/reward?type=coin&content=學習API呼叫&number=1](lifeup://api/reward?type=coin&content=學習API呼叫&number=1)

- 獲得 300 點「學識、創造力」經驗值，獲得原因為「學習API呼叫」。且原因會在經驗值詳情頁面展示：

  [lifeup://api/reward?type=exp&content=學習API呼叫&number=300&skills=2&skills=6](lifeup://api/reward?type=exp&content=學習API呼叫&number=300&skills=2&skills=6)

- 獲得 1 個模糊匹配「金幣」商品，獲得原因為「學習API呼叫」。且原因會在倉庫歷史頁面展示：

  [lifeup://api/reward?type=item&content=學習API呼叫&number=1&item_name=金幣](lifeup://api/reward?type=item&content=學習API呼叫&number=1&item_name=金幣)

| 引數      | 含義             | 取值                                   | 示例        | 是否必須 | 備註                                                         |
| --------- | ---------------- | -------------------------------------- | ----------- | -------- | ------------------------------------------------------------ |
| type      | 獎勵型別         | 目前僅支援：<br/>coin<br/>exp<br/>item | coin        | 是       | coin - 金幣<br/>exp - 經驗值<br/>item - 商品                 |
| content   | 獎勵原因         | 任意文字                               | 學習API呼叫 | 是       | -                                                            |
| skills    | 技能（屬性）     | 大於 0 的數字陣列                      | 1           | 否       | 僅當 type 為 exp 時可用<br/>支援陣列（如&skills=1&skills=2&skills=3）<br/>獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |
| number    | 獎勵數量         | 大於 0 的數字                          | 1           | 是       | 如果是金幣，取值最大為999999<br/>如果是經驗值，取值最大為99999<br/>如果是商品，取值最大為99 |
| item_id   | 商品id           | 大於 0 的數字                          | 1           | 否*      | 僅當 type 為 item 時可用                                     |
| item_name | 商品名稱         | 任意文字                               | 金幣        | 否*      | 僅當 type 為 item 時可用，模糊匹配                           |
| silent    | 是否要禁用UI提示 | true 或者 false                        | false       | 否       | 預設為 false                                                 |

<br/>

### 懲罰

**方法名：**penalty

**說明：**直接提供懲罰，可定製懲罰理由

**示例：** *基本同獎勵介面

- 懲罰 1 點金幣，獲得原因為「睡了懶覺」。且原因會在金幣詳情頁面展示：

  [lifeup://api/penalty?type=coin&content=睡了懶覺&number=1](lifeup://api/penalty?type=coin&content=睡了懶覺&number=1)

- 懲罰 300 點「力量」經驗值，原因為「睡了懶覺」。且原因會在經驗值詳情頁面展示：

  [lifeup://api/penalty?type=exp&content=睡了懶覺&number=300&skills=1](lifeup://api/penalty?type=exp&content=睡了懶覺&number=300&skills=1)

- 懲罰 1 個模糊匹配「金幣」商品，原因為「睡了懶覺」。且原因會在倉庫歷史頁面展示：

  [lifeup://api/penalty?type=item&content=睡了懶覺&number=1&item_name=金幣](lifeup://api/penalty?type=item&content=睡了懶覺&number=1&item_name=金幣)

| 引數      | 含義             | 取值                                   | 示例     | 是否必須 | 備註                                                         |
| --------- | ---------------- | -------------------------------------- | -------- | -------- | ------------------------------------------------------------ |
| type      | 懲罰型別         | 目前僅支援：<br/>coin<br/>exp<br/>item | coin     | 是       | coin - 金幣<br/>exp - 經驗值<br/>item - 商品                 |
| content   | 懲罰原因         | 任意文字                               | 睡了懶覺 | 是       | -                                                            |
| skills    | 技能（屬性）     | 大於 0 的數字陣列                      | 1        | 否       | 僅當 type 為 exp 時可用<br/>支援陣列（如&skills=1&skills=2&skills=3）<br/>獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |
| number    | 獎勵數量         | 大於 0 的數字                          | 1        | 是       | 如果是金幣，取值最大為999999<br/>如果是經驗值，取值最大為99999<br/>如果是商品，取值最大為99 |
| item_id   | 商品id           | 大於 0 的數字                          | 1        | 否*      | 僅當 type 為 item 時可用                                     |
| item_name | 商品名稱         | 任意文字                               | 金幣     | 否*      | 僅當 type 為 item 時可用，模糊匹配                           |
| silent    | 是否要禁用UI提示 | true 或者 false                        | false    | 否       | 預設為 false                                                 |

<br/>

### 編輯金幣

**方法名：**edit_coin

**說明：**直接編輯使用者的金幣餘額。金幣數量將被設定為指定的值。變更原因可自定義，並將顯示在金幣歷史記錄中。

**示例：**

- 將金幣設定為1000，原因為"API調整"：<a href="lifeup://api/edit_coin?coin=1000&content=API調整">lifeup://api/edit_coin?coin=1000&content=API調整</a>
- 靜默將金幣設定為500：<a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| 引數 | 含義 | 取值 | 示例 | 是否必須 | 備註 |
| ---- | ---- | ---- | ---- | -------- | ---- |
| coin | 目標金幣數量 | 大於等於0的數字 | 1000 | 是 | 操作後的最終金幣餘額，最大值為999999 |
| content | 變更原因 | 任意文字 | API調整 | 否 | 如未提供則使用系統預設原因 |
| reason | 變更原因（別名） | 任意文字 | API調整 | 否 | content引數的別名 |
| silent | 禁用UI通知 | true或false | false | 否 | 預設為false，設定為true時不顯示提示訊息 |


<br/>

### 任務

#### 新增任務

?> 部分引數需要 v1.98.0+

**方法名：**add_task

**說明：**直接新增一個任務

**示例：**
[lifeup://api/add_task?todo=這是自動新增的任務&notes=備註&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金幣](lifeup://api/add_task?todo=這是自動新增的任務&notes=備註&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=金幣)

| 引數             | 含義           | 取值                | 示例       | 是否必須 | 備註                           |
| --------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| todo            | 任務內容       | 任意文字           | 寫日記     | 是       |                               |
| notes           | 備註           | 任意文字           | 備註       | 否       | 預設為空                       |
| coin            | 金幣獎勵       | 大於等於0的數字    | 10        | 否       | 預設為 0，受系統限制約束        |
| coin_var        | 金幣獎勵浮動值  | 大於等於 0 的數字  | 1         | 否       | 預設為 0；如大於 0，則在 [coin, coin+coin_var] 範圍內隨機 |
| exp             | 經驗值獎勵     | 大於等於0的數字    | 100       | 否       | 預設為 0，受系統限制約束        |
| skills          | 技能ID         | 大於 0 的數字陣列   | 1         | 否       | 支援陣列（如 &skills=1&skills=2）|
| category        | 清單ID         | 大於等於 0 的數字   | 0         | 否       | 預設為 0（預設清單）；不能選擇智慧清單 |
| frequency       | 重複頻次       | 整數               | 0         | 否       | 預設為 0（單次）<br/>0 - 單次<br/>1 - 每日<br/>N (N>1) - 每 N 日<br/>-1 - 無限<br/>-3 - 艾賓浩斯（需v1.99.1）<br/>-4 - 每月<br/>-5 - 每年 |
| importance      | 重要程度       | [1, 4]            | 1         | 否       | 預設為 1                       |
| difficulty      | 困難程度       | [1, 4]            | 1         | 否       | 預設為 1                       |
| deadline        | 截止時間       | 時間戳（毫秒）     | 1640995200000 | 否    |                               |
| color           | 標籤顏色       | 顏色字串         | #66CCFF    | 否       | #需要轉義為%23                 |
| background_url  | 背景圖片URL    | 網路地址URL        | http://example.com/bg.jpg | 否 | 必須是可訪問的網路圖片地址    |
| background_alpha| 背景透明度     | [0, 1] 之間的浮點數 | 0.5        | 否      | 預設為 1.0                    |
| start_time      | 開始時間       | 時間戳（毫秒）     | 1640995200000 | 否     | 任務開始時間                  |
| auto_use_item   | 自動使用獎勵物品| true 或者 false   | false      | 否       | 完成任務時自動使用獎勵物品      |
| remind_time     | 提醒時間       | 時間戳（毫秒）     | 1640995200000 | 否    | 任務提醒時間                  |
| pin             | 置頂           | true 或者 false    | false     | 否       | 將任務置頂顯示                 |
| words           | 完成激勵語     | 任意文字           | 太棒了！   | 否       | 任務完成時顯示的激勵文字       |
| frozen          | 是否凍結       | true 或者 false    | false     | 否       | 預設為 false                   |
| freeze_until    | 凍結截止時間   | 時間戳（毫秒）     | 1640995200000 | 否    | 僅當 frozen 為 true 時生效     |
| coin_penalty_factor | 金幣懲罰係數| [0, 100) 之間的浮點數 | 0.5    | 否       |                               |
| exp_penalty_factor | 經驗懲罰係數 | [0, 100) 之間的浮點數 | 0.5    | 否       |                               |
| write_feelings  | 是否啟用感想   | true 或者 false    | false     | 否       | 預設為 false                   |
| item_id         | 物品ID         | 大於 0 的數字      | 1         | 否*      | 與 item_name 必須提供其中一個   |
| item_name       | 物品名稱       | 任意文字           | 寶箱      | 否*      | 與 item_id 必須提供其中一個     |
| item_amount     | 物品數量       | [1, 99]           | 1         | 否       | 預設為 1                       |
| items           | 物品獎勵       | JSON文字           | 參見[物品獎勵結構](#1-物品獎勵結構) | 否 | 可一次性設定多個物品獎勵 |
| task_type       | 任務型別       | [0, 3]            | 0         | 否       | 需v1.99.1, 0 - 普通任務<br/>1 - 計數任務<br/>2 - 負面任務<br/>3 - API任務 |
| target_times    | 目標次數       | 大於0的整數        | 1         | 否       | 僅當 task_type 為1(計數任務)時有效 |
| is_affect_shop_reward | 是否影響商店獎勵 | true/false      | false    | 否       | 當 task_type 為1(計數任務)時有效，是否影響商品的獎勵計算         |


**返回資料：**

| 欄位名   | 型別   | 說明       | 示例 | 備註             |
| -------- | ------ | ---------- | ---- | ---------------- |
| task_id  | 數字   | 任務ID     | 1000 |                  |
| task_gid | 數字   | 任務組ID   | 1000 |                  |

<br/>


#### 完成任務

**方法名：**complete

**說明：**觸發任務完成，只會搜索到未完成的任務

**示例：**

- 完成id為1的任務：[lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- 完成「任務組id」為1的任務：[lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- 根據名字搜尋任務並完成：[lifeup://api/complete?name=開始使用&ui=true](lifeup://api/complete?name=開始使用&ui=true)

**解釋：**

每個任務都有一個 id。

對於重複任務而言，每次重複id都會重新整理，但「任務組id」會保持不變。

id 的獲取方法為「實驗」頁面開啟「開發者模式」，然後在「任務詳情」頁面即可檢視。

| 引數                      | 含義                     | 取值                                     | 示例     | 是否必須 | 備註                                                         |
| ------------------------- | ------------------------ | ---------------------------------------- | -------- | -------- | ------------------------------------------------------------ |
| id                        | 任務id                   | 大於 0 的數字                            | 1        | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。               |
| gid                       | 任務組id                 | 大於 0 的數字                            | 1        | 否*      | 任務組id；                                                   |
| name                      | 名稱                     | 任意文字                                 | 睡覺     | 否*      | 模糊搜尋，只會完成搜索到的其中一個任務                       |
| ui                        | 是否展示彈窗UI           | true 或 false                            | true     | 否       | 預設為 false，只在後臺顯示一條訊息                           |
| 以下引數引入自v1.94.0版本 |                          |                                          |          |          |                                                              |
| count                     | 計數值                   | 數字                                     | 1        | 否       | 僅適用於計數任務，請搭配`count_set_type`引數使用             |
| count_set_type            | 如何設定計數值           | 以下數值其一：<br/>absolute<br/>relative | absolute | 否       | 預設值為relative<br/>absolute - 絕對取值，即直接將目標設定為 value<br/>relative - 相對取值，在原數值的基礎上增加或減少 |
| count_force_sum_up        | 是否強制結算計數任務獎勵 | true 或 false                            | true     | 否       |                                                              |
| reward_factor             | 獎勵係數                 | 大於0的浮點數                            | 1.1      | 否       | 不適用於計數任務<br/>獎勵係數會影響獎勵的經驗值、金幣數值（暫不影響商品數量） |

**注意：**

1. 爲了能夠匹配到任務，id、gid、name 必須提供其一。

<br/>

#### 放棄任務

**方法名：**give_up

**說明：**觸發任務放棄

**示例：**

- 根據名字搜尋任務並放棄：[lifeup://api/give_up?name=早起](lifeup://api/give_up?name=早起)

**解釋：**

| 引數 | 含義     | 取值          | 示例 | 是否必須 | 備註                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任務id   | 大於 0 的數字 | 1    | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。 |
| gid  | 任務組id | 大於 0 的數字 | 1    | 否*      | 任務組id；                                     |
| name | 名稱     | 任意文字      | 早起 | 否*      | 模糊搜尋，只會完成搜索到的其中一個任務         |

**注意：**

1. 爲了能夠匹配到任務，id、gid、name 必須提供其一。
2. 已經完成的任務不可刪除。

<br/>

#### 凍結任務

**方法名：**freeze

**說明：**觸發任務凍結，只適用於重複任務

**示例：**

- 根據名字搜尋任務並凍結：[lifeup://api/freeze?name=早起](lifeup://api/freeze?name=早起)

**解釋：**

| 引數 | 含義        | 取值          | 示例          | 是否必須 | 備註                                           |
| ---- | ----------- | ------------- | ------------- | -------- | ---------------------------------------------- |
| id   | 任務id      | 大於 0 的數字 | 1             | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。 |
| gid  | 任務組id    | 大於 0 的數字 | 1             | 否*      | 任務組id；                                     |
| name | 名稱        | 任意文字      | 早起          | 否*      | 模糊搜尋，只會完成搜索到的其中一個任務         |
| time | 凍結直至... | 時間戳        | 1661688800682 | 否       | -                                              |

**注意：**

1. 爲了能夠匹配到任務，id、gid、name 必須提供其一。

<br/>

#### 解凍任務

**方法名：**unfreeze

**說明：**觸發任務解凍

**示例：**

- 根據名字搜尋任務並解凍：[lifeup://api/unfreeze?name=早起](lifeup://api/unfreeze?name=早起)

**解釋：**

| 引數 | 含義     | 取值          | 示例 | 是否必須 | 備註                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任務id   | 大於 0 的數字 | 1    | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。 |
| gid  | 任務組id | 大於 0 的數字 | 1    | 否*      | 任務組id；                                     |
| name | 名稱     | 任意文字      | 早起 | 否*      | 模糊搜尋，只會完成搜索到的其中一個任務         |

**注意：**

1. 爲了能夠匹配到任務，id、gid、name 必須提供其一。

<br/>

#### 刪除任務

**方法名：**delete_task

**說明：**觸發任務刪除

**示例：**

- 根據名字搜尋任務並刪除：[lifeup://api/delete_task?name=早起](lifeup://api/delete_task?name=早起)

**解釋：**

| 引數 | 含義     | 取值          | 示例 | 是否必須 | 備註                                           |
| ---- | -------- | ------------- | ---- | -------- | ---------------------------------------------- |
| id   | 任務id   | 大於 0 的數字 | 1    | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。 |
| gid  | 任務組id | 大於 0 的數字 | 1    | 否*      | 任務組id；                                     |
| name | 名稱     | 任意文字      | 早起 | 否*      | 模糊搜尋，只會完成搜索到的其中一個任務         |

**注意：**

1. 爲了能夠匹配到任務，id、gid、name 必須提供其一。

<br/>

### 編輯任務

?> 需要 v1.98.0+

**方法名：**edit_task

**說明：**編輯已有任務的內容和屬性

**示例：**
[lifeup://api/edit_task?id=1&todo=修改後的任務內容&notes=備註&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=修改後的任務內容&notes=備註&coin=10&exp=20&skills=1&skills=2&category=0)

| 引數                | 含義           | 取值                | 示例     | 是否必須 | 備註                           |
| ------------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| id                 | 任務ID         | 大於 0 的數字      | 1        | 否*      | id、gid、name 必須提供其中一個  |
| gid                | 任務組ID       | 大於 0 的數字      | 1        | 否*      | id、gid、name 必須提供其中一個  |
| name               | 任務名稱       | 任意文字           | 寫日記    | 否*      | id、gid、name 必須提供其中一個  |
| todo               | 任務內容       | 任意文字           | 寫週記    | 否       |                               |
| notes              | 備註           | 任意文字           | 備註內容  | 否       |                               |
| coin               | 金幣獎勵       | 大於等於0的數字     | 10       | 否       | 完成任務獲得的金幣數量，受系統限制約束         |
| coin_var           | 金幣浮動值     | 大於 0 的數字      | 1        | 否       | 獎勵將在 [coin, coin+coin_var] 範圍內隨機 |
| exp                | 經驗值獎勵     | 大於等於0的數字     | 20       | 否       | 完成任務獲得的經驗值，受系統限制約束           |
| skills             | 技能ID         | 大於 0 的數字陣列   | 1        | 否       | 支援陣列（如 &skills=1&skills=2）|
| category           | 列表ID         | 大於或等於 0 的數字 | 0        | 否       | 0 表示預設列表，不能選擇智慧列表 |
| frequency       | 重複頻次       | 整數               | 0         | 否       | 預設為 0（單次）<br/>0 - 單次<br/>1 - 每日<br/>N (N>1) - 每 N 日<br/>-1 - 無限<br/>-3 - 艾賓浩斯（需v1.99.1）<br/>-4 - 每月<br/>-5 - 每年 |
| importance         | 重要程度       | [1, 4]            | 1        | 否       | 預設為 1                       |
| difficulty         | 難度等級       | [1, 4]            | 2        | 否       | 預設為 1                       |
| deadline           | 截止時間       | 時間戳（毫秒）     | 1640995200000 | 否 |                               |
| remind_time        | 提醒時間       | 時間戳（毫秒）     | 1640995200000 | 否 |                               |
| start_time         | 開始時間       | 時間戳（毫秒）     | 1640995200000 | 否 |                               |
| color              | 標籤顏色       | 顏色字串         | #66CCFF  | 否       | #需要轉義為%23                 |
| background_url     | 背景圖片URL    | 網路地址URL        | http://example.com/bg.jpg | 否 |                    |
| background_alpha   | 背景透明度     | [0, 1] 之間的浮點數 | 0.5      | 否       |                               |
| item_id            | 物品ID         | 大於 0 的數字      | 1        | 否*      | 與 item_name 必須提供其中一個  |
| item_name          | 物品名稱       | 任意文字           | 寶箱      | 否*      | 與 item_id 必須提供其中一個    |
| item_amount        | 物品數量       | [1, 99]           | 1        | 否       | 預設為 1                       |
| items              | 物品獎勵JSON   | JSON文字           | [{"item_id":1,"amount":1}] | 否 | 可一次設定多個物品獎勵 |
| auto_use_item      | 自動使用物品   | true 或者 false    | false    | 否       |                               |
| frozen             | 是否凍結       | true 或者 false    | false    | 否       | 預設為 false                  |
| freeze_until       | 凍結截止時間   | 時間戳（毫秒）     | 1640995200000 | 否 | 僅當 frozen 為 true 時生效    |
| coin_penalty_factor| 金幣懲罰係數   | [0, 100) 之間的浮點數 | 0.5    | 否       |                               |
| exp_penalty_factor | 經驗懲罰係數   | [0, 100) 之間的浮點數 | 0.5    | 否       |                               |
| write_feelings     | 是否啟用感想   | true 或者 false    | false    | 否       |                               |
| pin                | 是否置頂       | true 或者 false    | false    | 否       |                               |
| words              | 完成激勵語     | 任意文字           | 太棒了！  | 否       | 任務完成時顯示的激勵文字       |
| task_type       | 任務型別       | [0, 3]            | 0         | 否       | 需v1.99.1, 0 - 普通任務<br/>1 - 計數任務<br/>2 - 負面任務<br/>3 - API任務 |
| target_times    | 目標次數       | 大於0的整數        | 1         | 否       | 僅當 task_type 為1(計數任務)時有效 |
| is_affect_shop_reward | 是否影響商店獎勵 | true/false      | false    | 否       | 當 task_type 為1(計數任務)時有效，是否影響商品的獎勵計算         |
| coin_set_type     | 如何設定金幣值 | One of:<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定金幣為 value<br/>relative - 在原金幣值的基礎上增加或減少 |
| exp_set_type      | 如何設定經驗值 | One of:<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定經驗值為 value<br/>relative - 在原經驗值的基礎上增加或減少 |

**返回資料：**

| 欄位名    | 型別   | 說明       | 示例 | 備註             |
| --------- | ------ | ---------- | ---- | ---------------- |
| task_id   | 數字   | 任務ID     | 1000 |                  |
| task_gid  | 數字   | 任務組ID   | 1000 |                  |

<br/>

### 歷史任務操作

?> 需要 v1.98.0+

**方法名：**history_operation

**說明：**對已完成/已放棄/已過期的任務進行操作

**示例：**
- 刪除歷史任務：[lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- 將任務標記為放棄：[lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- 重新開始任務：[lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> 此 API 僅適用於非未完成狀態的任務（已完成、已放棄或已過期）

| 引數           | 含義           | 取值                | 示例     | 是否必須 | 備註                           |
| ------------- | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| id            | 任務ID         | 大於 0 的數字      | 1        | 是       | 歷史任務的ID                   |
| operation     | 操作型別       | 以下數值其一：<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | 是 | delete - 刪除任務<br/>complete - 標記為已完成<br/>undo_complete - 撤銷完成<br/>set_to_give_up - 標記為放棄<br/>set_to_overdue - 標記為過期<br/>edit_completed_time - 修改完成時間<br/>restart - 重新開始任務 |
| completed_time | 完成時間       | 時間戳（毫秒）     | 1640995200000 | 否* | 僅當 operation 為 edit_completed_time 時必須提供 |

**返回資料：**

| 欄位名   | 型別   | 說明     | 示例 | 備註             |
| -------- | ------ | -------- | ---- | ---------------- |
| task_id  | 數字   | 任務ID   | 1000 | 操作的任務ID     |

<br/>

### 商店設定

**方法名：**shop_settings

**說明：**調整各種商店設定

**示例：**

- 將ATM利率設定為0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- 每次點選將利率提升0.01%：[lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| 引數     | 含義                     | 取值                                                         | 示例         | 是否必須 | 備註                                                         |
| -------- | ------------------------ | ------------------------------------------------------------ | ------------ | -------- | ------------------------------------------------------------ |
| key      | 型別                     | 目前僅支援：<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | 是       | atm_interest - ATM日利率<br/>credit_interest - 貸款日利率<br/>line_of_credit - 可貸款金額<br/>discount_rate_for_returning - 退貨打折比例<br/>atm_balance - ATM 餘額 |
| value    | 數值                     | 浮點數（小數點）                                             | 0.01         | 是       | 不同的 key 對應不同的數值範圍<br/>比如 ATM 餘額不支援小數點  |
| set_type | 如何設定數值             | 以下數值其一：<br/>absolute<br/>relative                     | absolute     | 否       | absolute - 絕對取值，即直接將目標設定為 value<br/>relative - 相對取值，在原數值的基礎上增加或減少 |
| silent   | 是否沉默執行（不顯示UI） | 布林值                                                       | false        | 否       | 僅 v1.93.0-beta01（502）+ 支援<br/>預設為 false，即會顯示 UI 提示 |

<br/>

### 跳轉

**方法名：**goto

**說明：**跳轉「人升」中的某個頁面

**示例：**[lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**解釋：**跳轉到實驗頁面

| 引數 | 含義 | 取值                                                         | 示例 | 是否必須 | 備註                                                         |
| ---- | ---- | ------------------------------------------------------------ | ---- | -------- | ------------------------------------------------------------ |
| page | 頁面 | 固定以下數值其一：<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>dlc<br/>pomodoro_record<br/>synthesis - 合成<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>new_default<br/>achievement_list - 成就清單<br/>user_achievement - 具體某個成就清單，見下文<br/> | lab  | 是       | `purchase_dialog`指購買彈窗<br/>`use_item_dialog`指使用商品彈窗<br/>其他的都是具體的大頁面 |


#### 1. 跳轉商品購買/使用彈窗

> `use_item_dialog`引數引入自v1.94.0版本

當 `page` 引數為 `purchase_dialog`或`use_item_dialog`時，你可以指定商品id：

示例如：`lifeup://api/goto?page=purchase_dialog&id=1`

| 引數 | 含義   | 取值          | 示例 | 是否必須 | 備註   |
| ---- | ------ | ------------- | ---- | -------- | ------ |
| id   | 商品id | 大於 0 的數字 | 1    | 是       | 商品id |

<br/>

#### 2. 跳轉首頁的子頁面

當 `page` 引數為 `main`時，你還可以額外指定跳轉的子頁面：

示例如，跳轉到商店頁面：`lifeup://api/goto?page=main&sub_page=shop`

| 引數        | 含義       | 取值                                                         | 示例 | 是否必須 | 備註                                                         |
| ----------- | ---------- | ------------------------------------------------------------ | ---- | -------- | ------------------------------------------------------------ |
| sub_page    | 子頁面名稱 | 固定以下數值其一：<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop | 否       |                                                              |
| category_id | 清單id     | 數字                                                         | 0    | 否       | 如果`sub_page`為含清單列表的頁面，則可以指定跳轉的清單id。<br/>如商店清單、倉庫清單、任務清單。 |

#### 3. 跳轉任務詳情

當 `page` 引數為 `task_detail`時，你還可以額外指定跳轉的任務 id：

示例如，跳轉到指定任務 id 為 53 的詳情頁面：`lifeup://api/goto?page=task_detail&task_id=53`

| 引數      | 含義     | 取值     | 示例 | 是否必須 | 備註                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| task_id   | 任務id   | 任務id   | 53   | 否*      | 任務id；如果是重複任務，每次重複，id都會更新。 |
| task_gid  | 任務組id | 任務組id | 3    | 否*      | 任務組id                                       |
| task_name | 任務名稱 | 字串   | 早起 | 否*      | 任務名稱，模糊匹配一個。                       |

**注意：**

1. 三個引數只需要提供其中之一。
   - 如果同時提供多個，會有內部的優先順序順序。但這屬於未定義行為，APP 不會保證順序。


#### 4. 跳轉新建成就頁面

當 `page` 引數為 `add_achievement`時，你還**需要**額外指定跳轉的清單 id：

示例如，跳轉到指定清單 id 為 1 的新建成就頁面：`lifeup://api/goto?page=add_achievement&category_id=1`

| 引數      | 含義     | 取值     | 示例 | 是否必須 | 備註                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 成就清單id   | 成就清單id   | 1   | 是      |  |

#### 5. 跳轉具體的成就清單頁面

當 `page` 引數為 `user_achievement`時，你還**需要**額外指定跳轉的清單 id：

示例如，跳轉到指定清單 id 為 1 的成就清單頁面：`lifeup://api/goto?page=user_achievement&category_id=1`

| 引數      | 含義     | 取值     | 示例 | 是否必須 | 備註                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 成就清單id   | 成就清單id   | 1   | 是      |  |

#### 6. 跳轉具體的合成清單頁面

當 `page` 引數為 `synthesis`時，你還**可選**額外指定跳轉的清單 id：

示例如，跳轉到指定清單 id 為 1 的合成清單頁面：`lifeup://api/goto?page=synthesis&category_id=1`

| 引數      | 含義     | 取值     | 示例 | 是否必須 | 備註                                           |
| --------- | -------- | -------- | ---- | -------- | ---------------------------------------------- |
| category_id   | 合成清單id   | 合成清單id   | 1   | 否      |  |




<br/>

### 商品

#### 新增商品

?> 部分引數需要 v1.98.0+，比如`effects`、`purchase_limit`

**方法名：**add_item

**說明：**建立商品，包含自定義購買限制和使用效果等功能

**示例：**[lifeup://api/add_item?name=休息10分鐘&desc=去好好休息一小段時間吧！&price=10&action_text=休息](lifeup://api/add_item?name=休息10分鐘&desc=去好好休息一小段時間吧！&price=10&action_text=休息)

| 引數             | 含義           | 取值                | 示例         | 是否必須 | 備註                           |
| --------------- | -------------- | ------------------ | ------------ | -------- | ------------------------------ |
| name            | 商品名稱       | 任意文字           | 休息10分鐘    | 是      |                                |
| desc            | 描述           | 任意文字           | 休息一下      | 否       |                               |
| icon            | 圖示           | 網路地址URL        | http://...    | 否      | 必須是網路URL地址              |
| price           | 價格           | [0, 999999]       | 10            | 否      | 預設為 0                       |
| stock_number    | 庫存數量       | [-1, 99999]       | -1            | 否      | -1 表示無限                    |
| action_text     | 使用按鈕文案   | 任意文字           | 休息          | 否      |                                |
| disable_purchase| 禁止購買       | true 或者 false    | false         | 否      | 預設為 false                   |
| disable_use     | 禁止使用       | true 或者 false    | false         | 否      | 預設為 false                   |
| category        | 分類ID         | 大於或等於 0 的數字 | 0             | 否      | 0 表示預設分類                 |
| order           | 顯示順序       | 整數              | 1             | 否       | 在分類中的排序位置              |
| purchase_limit  | 購買限制       | JSON文字          | 參見[購買限制結構](#3-購買限制結構) | 否 | 限制購買頻率 |
| effects         | 使用效果       | JSON文字          | 參見[商品效果結構](#4-商品效果結構) | 否 | 使用商品時的效果 |
| own_number      | 初始擁有數量   | 整數              | 0             | 否       | 設定初始庫存數量               |
| unlist          | 從商店隱藏     | true 或者 false   | false         | 否       | 預設為 false                   |

**返回資料：**

| 欄位名   | 型別   | 說明       | 示例  | 備註             |
| -------- | ------ | ---------- | ----- | ---------------- |
| item_id  | 數字   | 商品ID     | 1000  | 建立的商品ID     |

!> effects 引數會覆蓋 disable_use 的設定。如果您設定了 effects 指定商品不可使用，disable_use 將被忽略。

<br/>


#### 調整商品

?> 需要 v1.98.0+

**方法名：**item

**說明：**對現有商品進行修改，包括價格、庫存、效果等各項屬性

**示例：**
- 調整價格：[lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- 修改效果：[lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
    - effect 引數的編碼前內容為：`[{"type":2,"info":{"min":100,"max":200}}]`

| 引數              | 含義           | 取值                | 示例       | 是否必須 | 備註                           |
| ---------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| id               | 商品ID         | 大於 0 的數字      | 1          | 否*      | id 和 name 必須提供其中一個    |
| name             | 商品名稱       | 任意文字           | 寶箱       | 否*      | 用於模糊搜尋商品，不是用於改名 |
| set_name         | 修改名稱       | 任意文字           | 寶箱       | 否       | 不可為空                       |
| set_desc         | 修改描述       | 任意文字           | 獲得禮物   | 否       |                               |
| set_icon         | 修改圖示       | URL文字            | http://... | 否       | 必須是網路URL地址              |
| set_price        | 調整價格       | 整數               | 1          | 否       |                               |
| set_price_type   | 價格調整方式   | absolute 或 relative | relative | 否       | absolute-直接設定<br/>relative-增減值 |
| own_number       | 調整擁有數量   | 整數               | 1          | 否       | 使用relative時支援負數         |
| own_number_type  | 擁有數調整方式 | absolute 或 relative | relative | 否       | absolute-直接設定<br/>relative-增減值 |
| stock_number     | 調整庫存數量   | [-1, 99999]       | 1          | 否       | -1表示無限庫存                 |
| stock_number_type| 庫存調整方式   | absolute 或 relative | relative | 否       | absolute-直接設定<br/>relative-增減值 |
| disable_purchase | 禁止購買       | true 或者 false    | false      | 否       | 預設為 false                   |
| disable_use      | 禁止使用       | true 或者 false    | false      | 否       | 預設為 false                   |
| action_text      | 使用按鈕文案   | 任意文字           | 使用       | 否       |                               |
| title_color_string| 標題顏色      | 顏色字串         | #66CCFF    | 否       | #需要轉義為%23<br/>傳空值可恢復預設 |
| effects          | 使用效果       | JSON文字           | 參見[商品效果結構](#4-商品效果結構) | 否 | 設定商品使用效果 |
| purchase_limit   | 購買限制       | JSON文字           | 參見[購買限制結構](#3-購買限制結構) | 否 | 限制購買頻率 |
| category_id      | 所屬分類ID     | 大於等於 0 的數字  | 1          | 否       | 0表示預設分類                  |
| order            | 顯示順序       | 整數               | 1          | 否       | 在分類中的排序位置             |
| unlist           | 下架商品       | true 或者 false    | false      | 否       | 預設為 false                   |

!> id 和 name 引數必須提供其中一個，用於定位要修改的商品

<br/>

#### 調整開箱效果

**方法名：**loot_box

**說明：**修改指定箱子的開箱效果，支援調整機率、獎勵數和增加內容物。（暫不支援刪除）

**示例：**[lifeup://api/loot_box?name=金幣箱&sub_name=【大】袋金幣&set_type=relative&probability=1&fixed=false](lifeup://api/loot_box?name=金幣箱&sub_name=【大】袋金幣&set_type=relative&amount=1&probability=1&fixed=false)

**解釋：**增加金幣箱中的【大】袋金幣的比重 1 點。

| 引數        | 含義                  | 取值                                     | 示例         | 是否必須 | 備註                                                         |
| ----------- | --------------------- | ---------------------------------------- | ------------ | -------- | ------------------------------------------------------------ |
| id          | 商品id                | 大於0的數字                              | 1            | 否*      | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」                |
| name        | 商品名稱              | 任意文字                                 | 金幣箱       | 否*      | 用於未知 id 時，模糊搜尋商品，並非修改名稱                   |
| sub_id      | 箱子內容物的 id       | 大於0的數字                              | 1            | 否*      | 箱子內容物的 id                                              |
| sub_name    | 箱子內容物的名稱      | 任意文字                                 | 【大】袋金幣 | 否*      | 用於箱子內容物未知 id 時，模糊搜尋商品                       |
| set_type    | 調整方式（絕對/相對） | 以下數值其一：<br/>absolute<br/>relative | relative     | 否       | absolute - 絕對取值，即直接將目標設定為 value<br/>relative - 相對取值，比如在原數值的基礎上增加或減少<br/>**同時作用於[amount]、[probability]兩個欄位** |
| amount      | 獎勵數                | 數字                                     | 1            | 否       | 某個單一物品的獎勵個數                                       |
| probability | 獎勵比重              | 數字                                     | 1            | 否       | -                                                            |
| fixed       | 是否是固定獎勵        | 布林值                                   | true/false   | 否       | -                                                            |

**注意：**

1. 爲了搜索到商品，必須提供 id 或 name 其一。
1. 爲了搜索到內容物，必須提供 sub_id 或 sub_name 其一。

<br/>

#### 使用商品

?> 該 API 於 v1.93.0-beta01（502）版本更新引入。

**方法名：**use_item

**說明：**建立商品，圖示僅支援網路地址，暫不支援自定義使用效果。

**示例：**

- 開啟一個金幣箱：[lifeup://api/use_item?name=金幣箱&use_times=1](lifeup://api/use_item?name=金幣箱&use_times=1)

| 引數      | 含義       | 取值          | 示例   | 是否必須 | 備註                                                         |
| --------- | ---------- | ------------- | ------ | -------- | ------------------------------------------------------------ |
| id        | 商品id     | 大於 0 的數字 | 1      | 否*      | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」                |
| name      | 商品名稱   | 任意文字      | 金幣箱 | 否*      | 用於未知 id 時，模糊搜尋商品，並非修改名稱                   |
| use_times | 使用的次數 | 大於 0 的數字 | 1      | 否       | 預設為 1 次<br/>對於普通商品、開箱而言，對應商品的數量<br/>對於簡易合成商品，該值對應的是【合成數量】，而非消耗的商品數量 |

**返回值：**

!> 該 API 可能會由於部分原因失敗，部分特殊失敗原因會以返回值的形式提供。

| 引數   | 含義     | 取值 | 示例             | 是否必須 | 備註                                                         |
| ------ | -------- | ---- | ---------------- | -------- | ------------------------------------------------------------ |
| result | 結果碼   | 數字 | 0                | 是       | 0 - 使用成功<br/>1- 資料庫異常<br/>2 - 經驗值不足限制<br/>3 - 找不到商品<br/>4 - 執行倒計時衝突<br/>5 - 庫存不足 |
| desc   | 結果描述 | 文字 | RunningCountDown | 是       |                                                              |



<br/>

### ATM

?> 該 API 於 v1.91 +版本更新引入。

> 這裏的存取款操作會進行合法校驗。
>
> 如果你需要直接調整 ATM 數值，可檢視上文中的「商店設定」介面。

#### 存款

**方法名：**deposit

**說明：**存款，會進行合法性校驗（金幣餘額是否充足）。

**示例：**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**解釋：**存款 500 金幣。

| 引數   | 含義     | 取值          | 示例 | 是否必須 | 備註 |
| ------ | -------- | ------------- | ---- | -------- | ---- |
| amount | 存款數量 | 大於 0 的數字 | 100  | 是       | -    |

**返回值：**

| 引數   | 含義         | 取值   | 示例 | 是否必須 | 備註 |
| ------ | ------------ | ------ | ---- | -------- | ---- |
| result | 操作是否成功 | 布林值 | true | 是       | -    |

<br/>

#### 取款

**方法名：**withdraw

**說明：**取款，會進行合法性校驗（ATM 餘額是否充足）。

**示例：**[lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**解釋：**取款 500 金幣。

| 引數   | 含義     | 取值          | 示例 | 是否必須 | 備註 |
| ------ | -------- | ------------- | ---- | -------- | ---- |
| amount | 取款數量 | 大於 0 的數字 | 100  | 是       | -    |

**返回值：**

| 引數   | 含義         | 取值   | 示例 | 是否必須 | 備註 |
| ------ | ------------ | ------ | ---- | -------- | ---- |
| result | 操作是否成功 | 布林值 | true | 是       | -    |

<br/>

### 番茄記錄

#### 新增番茄記錄

**方法名：**add_pomodoro

**說明：**新增番茄計時記錄

**示例：**

- 新增時長為 25 分鐘（1500000 毫秒）的計時記錄，並指向名稱包含學習的任務：[lifeup://api/add_pomodoro?task_name=學習&duration=1500000](lifeup://api/add_pomodoro?task_name=學習&duration=1500000)
- 新增2022-08-01 11:00:00 - 2022-08-01 12:00:00 的計時記錄：[lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**解釋：**

任務id/任務組id的解釋可以檢視上文的「完成任務」介面。



| 引數            | 含義                   | 取值                          | 示例          | 是否必須 | 備註                                          |
| --------------- | ---------------------- | ----------------------------- | ------------- | -------- | --------------------------------------------- |
| start_time      | 計時開始時間           | 時間戳                        | 1659322800000 | 否*      | 可以百度瞭解時間戳的定義                      |
| duration        | 專注時長               | 數字（毫秒）<br/>需大於 30000 | 1500000       | 否*      | -                                             |
| end_time        | 計時結束時間           | 時間戳                        | 1659326400000 | 否*      | -                                             |
| reward_tomatoes | 是否獎勵番茄           | true 或者 false               | true          | 否       | 預設為 false                                  |
| task_id         | 任務id                 | 大於 0 的數字                 | coin          | 否       | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |
| task_gid        | 任務組id               | 大於 0 的數字                 | 備註          | 否       | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |
| task_name       | 名稱                   | 任意文字                      | 10            | 否       | 模糊搜尋，只會搜索到的其中一個任務            |
| ui              | 是否展示獎勵番茄數的UI | true 或者 false               | true          | 否       | v1.94.0 引入，預設為 true                     |

**注意：**

1. start_time, duration, end_time 必須提供其一。
2. 在只有 duration 的情況下，會預設 end_time 為當前時間。
3. end_time 需要大於  start_time。
4. duration 至少為 30000 毫秒（30秒）。
5. 如果同時提供了 start_time, duration, end_time，duration 應該比 (end_time - start_time) 小或相等。

<br/>

#### 編輯番茄記錄

> 該方法引入自v1.94.0

**方法名：**edit_pomodoro

**說明：**編輯現有的番茄計時記錄或新增新的記錄，如果提供有效的 `edit_item_id`。

**示例：**

- 編輯指定 ID 的記錄，設定時長為 45 分鐘（2700000 毫秒），並獎勵番茄：[lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- 根據開始和結束時間編輯記錄：[lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**引數：**

| 引數            | 含義                   | 取值            | 示例          | 是否必須 | 備註                                        |
| --------------- | ---------------------- | --------------- | ------------- | -------- | ------------------------------------------- |
| task_id         | 任務 ID                | 大於 0 的數字   | 101           | 否       | 任務的唯一標識                              |
| task_gid        | 任務組 ID              | 大於 0 的數字   | 5             | 否       | 如果提供，會覆蓋 task_id                    |
| task_name       | 任務名稱               | 任意文字        | 學習          | 否       | 如果 task_id 或 task_gid 不提供，則必須提供 |
| start_time      | 計時開始時間           | 時間戳          | 1659322800000 | 否*      | 可以百度瞭解時間戳的定義                    |
| end_time        | 計時結束時間           | 時間戳          | 1659326400000 | 否*      | -                                           |
| duration        | 專注時長               | 數字（毫秒）    | 2700000       | 否*      | 至少為 30000 毫秒（30秒）                   |
| reward_tomatoes | 是否獎勵番茄           | true 或者 false | true          | 否       | 預設為 false                                |
| edit_item_id    | 編輯項的 ID            | 大於 0 的數字   | 123           | 是       | 指定編輯的記錄 ID                           |
| ui              | 是否展示獎勵番茄數的UI | true 或者 false | true          | 否       |                                             |

**返回值：**

| 引數     | 含義                 | 取值 | 示例 | 是否必須 | 備註                     |
| -------- | -------------------- | ---- | ---- | -------- | ------------------------ |
| tomatoes | 此次操作獲得的番茄數 | 數字 | 2    | 否       | 如果 `ui` 為 true 時返回 |

**注意：**

1. `start_time`, `end_time`, `duration` 必須至少提供一個。
2. `end_time` 需要大於 `start_time`。
3. `duration` 應該小於或等於 (`end_time` - `start_time`)。
4. 如果提供 `edit_item_id` 且找到對應記錄進行編輯；否則根據其他引數建立新記錄。

<br/>

### 解鎖成就條件

**方法名：**unlock_condition

**說明：**解鎖成就條件：需要外部API呼叫以解鎖

**示例：**

- 呼叫解鎖 id 為 2 的解鎖條件：[lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| 引數 | 含義   | 取值          | 示例 | 是否必須 | 備註                                          |
| ---- | ------ | ------------- | ---- | -------- | --------------------------------------------- |
| id   | 條件id | 大於 0 的數字 | 2    | 是       | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |

<br/>

### 設定步數

**方法名：**step

**說明：**設定指定日期的步數，比如可以用於搭配手環+自動化工具錄入步數。並且可以用於修改歷史紀錄。

**示例：**

- 調整GMT+8時區下的2022-10-21的步數為9999步：[lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| 引數  | 含義                 | 取值                | 示例          | 是否必須 | 備註 |
| ----- | -------------------- | ------------------- | ------------- | -------- | ---- |
| count | 步數                 | 大於或等於 0 的數字 | 9999          | 是       | -    |
| time  | 所屬日期的任意時間戳 | 時間戳（ms）        | 1666282995643 | 是       | -    |

<br/>

### 編輯經驗值

?> 該 API 於 v1.93.0-beta01（502）版本更新引入。

**方法名：**edit_exp

**說明：**該 API 能批次設定屬性的當前經驗值，能直接設定某個經驗值或者某個等級。

**示例：**

> 該 API 會影響資料，為避免誤觸，此處不提供點選跳轉。

- 將【力量】、【學識】屬性的經驗值重置為0：[lifeup://api/edit_exp?skills=1&skills=2&exp=0](lifeup://api/edit_exp?skills=1&skills=2&exp=0)
- 將【魅力】經驗值直接調整為50級：[lifeup://api/edit_exp?skills=3&level=50](lifeup://api/edit_exp?skills=3&level=50)

| 引數   | 含義           | 取值                         | 示例 | 是否必須                               | 備註                                                         |
| ------ | -------------- | ---------------------------- | ---- | -------------------------------------- | ------------------------------------------------------------ |
| skills | 屬性（技能）id | 大於 0 的數字陣列            | 1    | 否                                     | 支援陣列（即&skills=1&skills=2&skills=3）<br/>獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |
| exp    | 設定的經驗值   | 大於或等於 0 的數字（int32） | 9999 | 否<br/>但 exp和 level 必須提供其中一個 |                                                              |
| level  | 設定的等級     | 大於或等於 0 的數字（int32） | 50   | 否<br/>但 exp和 level 必須提供其中一個 | 代表某個等級起始的經驗值<br/>並且會受自定義等級梯度的影響    |

<br/>

### 感想

?> 該 API 於 v1.93.4（536）版本更新引入。

**方法名：**feeling

**說明：**建立或更新感想。

**示例：**

- 建立一個新的感想：[lifeup://api/feeling?content=開心&time=1633036800](lifeup://api/feeling?content=開心&time=1633036800)
- 更新特定 id 的感想，並標記為收藏狀態：[lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)


| 引數        | 含義       | 取值          | 示例       | 是否必須 | 備註                                                                                                   |
| ----------- | ---------- | ------------- | ---------- | -------- |------------------------------------------------------------------------------------------------------|
| id          | 感想記錄id | 大於 0 的數字 | 1          | 否       | 如果提供，則用於更新特定記錄                                                                                       |
| content     | 內容       | 任意文字      | 快樂       | 否       | 用於建立記錄或更新記錄的內容                                                                                       |
| time        | 時間戳     | Unix 時間戳   | 1633036800 | 否       | 記錄的時間，預設為當前時間                                                                                        |
| is_favorite | 是否收藏   | true 或 false | true       | 否       | 標記記錄是否為收藏                                                                                            |
| relate_type | 關聯型別   | 數字 0-2      | 1          | 否       | 指定記錄的關聯型別<br/>0：任務<br/>1：自定義成就<br/>2：無關聯                                                             |
| relate_id   | 關聯id     | 大於 0 的數字 | 2          | 否       | 指定記錄的關聯id<br/>當 relate_type 為 0 時，代表任務 id<br/>當 relate_type 為 1 時，代表成就 id<br/>當 relate_type 為 2，無需提供 |

**注意：**

1. 如果提供 `id` 引數，則方法會嘗試更新對應的感想記錄。如果沒有找到相應的記錄，將丟擲異常。
2. 如果不提供 `id`，但提供了 `content`，則方法會建立一個新的感想記錄。

<br/>

### 番茄數量

?> 需要 v1.98.0+

**方法名：**tomato

**說明：**調整番茄數量（增加、減少或設定指定數量）

**示例：**
- 增加1個番茄：[lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- 減少2個番茄：[lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- 設定番茄數為10：[lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| 引數   | 含義     | 取值                                           | 示例     | 是否必須 | 備註                                                    |
| ------ | -------- | ---------------------------------------------- | -------- | -------- | ------------------------------------------------------- |
| action | 操作型別 | 以下值之一：<br/>increase<br/>decrease<br/>set | increase | 否       | increase - 增加番茄數（預設）<br/>decrease - 減少番茄數<br/>set - 設定番茄數為指定值 |
| number | 數量     | 整數                                           | 1        | 是       | 根據 action 不同含義不同：<br/>increase/decrease - 增加/減少的數量<br/>set - 設定的目標數量 |

**返回資料：**

| 欄位名   | 型別 | 說明         | 示例 |
| -------- | ---- | ------------ | ---- |
| tomatoes | 整數 | 當前番茄總數 | 10   |


<br/>

### 購買物品

?> 需要 v1.98.0+

**方法名：**purchase_item

**說明：**購買指定的商品

**示例：**
- 購買ID為1的商品：[lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- 購買名稱為"生命藥水"的商品：[lifeup://api/purchase_item?name=生命藥水](lifeup://api/purchase_item?name=生命藥水)
- 購買5個ID為1的商品：[lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

| 引數              | 含義     | 取值              | 示例       | 是否必須 | 備註                            |
| ---------------- | -------- | ----------------- | ---------- | -------- | ------------------------------- |
| id               | 商品ID   | 大於 0 的數字      | 1         | 否*      | id 和 name 必須提供其中一個     |
| name             | 商品名稱 | 任意文字           | 生命藥水   | 否*      | id 和 name 必須提供其中一個     |
| purchase_quantity| 購買數量 | 大於 0 的數字      | 5         | 否       | 預設值為 1                      |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例            | 備註                    |
| ------ | ------ | -------- | --------------- | ---------------------- |
| itemId | 數字   | 商品ID   | 1               | 僅購買成功時返回        |
| result | 整數   | 結果程式碼 | 0               | 見下方結果程式碼說明      |
| desc   | 文字   | 結果描述 | PurchaseSuccess | 見下方結果程式碼說明      |

**結果程式碼說明：**

| 程式碼 | 描述                        | 說明                          |
| ---- | -------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | 購買成功                       |
| 1    | DatabaseError             | 資料庫錯誤                     |
| 2    | NotEnoughCoin             | 金幣不足                       |
| 3    | ItemNotFound              | 商品未找到                     |
| 4    | PurchaseAndUseSuccess     | 購買並使用成功                 |
| 5    | PurchaseSuccessAndUseFailure | 購買成功但使用失敗           |

<br/>

### 物品合成

?> 需要 v1.98.0+

**方法名：**synthesize

**說明：**使用已有的合成配方合成物品

**示例：**
- 使用ID為1的配方合成一次：[lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- 使用ID為1的配方合成5次：[lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

| 引數  | 含義     | 取值            | 示例 | 是否必須 | 備註          |
| ----- | -------- | --------------- | ---- | -------- | ------------- |
| id    | 配方ID   | 大於 0 的數字    | 1    | 是       | 合成配方的ID  |
| times | 合成次數 | 大於 0 的數字    | 5    | 否       | 預設值為 1    |

**返回資料：**

| 欄位名           | 型別   | 說明         | 示例            | 備註                |
| --------------- | ------ | ------------ | --------------- | ------------------ |
| formulaId       | 數字   | 配方ID       | 1               |                    |
| result          | 整數   | 結果程式碼     | 0               | 見下方結果程式碼說明  |
| desc            | 文字   | 結果描述     | SynthesisSuccess| 見下方結果程式碼說明  |
| synthesisResults| 文字   | 合成結果列表 | {...}           | 僅合成成功時返回    |

**結果程式碼說明：**

| 程式碼 | 描述                 | 說明         |
| ---- | ------------------- | ------------ |
| 0    | SynthesisSuccess    | 合成成功     |
| 1    | FormulaNotFound     | 配方不存在   |
| 2    | InsufficientMaterials| 材料不足     |
| 3    | DatabaseError       | 資料庫錯誤   |
| 4    | UnknownError        | 其他錯誤     |

<br/>

### 合成配方管理

?> 需要 v1.98.0+

**方法名：**synthesis_formula

**說明：**新建、修改或刪除合成配方

**示例：**
- 建立新配方：[lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
    - 這裏的 inputItems 為 `[{"item_id": 296, "amount": 88}]`
    - 這裏的 outputItems 為 `[{"item_id": 295, "amount": 1}]`
- 刪除配方：[lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| 引數        | 含義       | 取值                | 示例                               | 是否必須 | 備註                   |
| ----------- | ---------- | ------------------- | ---------------------------------- | -------- | ---------------------- |
| id          | 配方ID     | 大於 0 的數字       | 1                                  | 否       | 修改或刪除時必須提供   |
| delete      | 是否刪除   | true 或者 false     | true                               | 否       | 僅刪除配方時使用       |
| inputItems  | 材料列表   | 商品陣列，格式見下文 | [{"item_id":1,"amount":2}]          | 是       | 新建或修改時必須提供   |
| outputItems | 產物列表   | 商品陣列，格式見下文 | [{"item_id":3,"amount":1}]          | 是       | 新建或修改時必須提供   |
| category    | 分類ID     | 大於 0 的數字       | 1                                  | 否       | 如不提供，預設為預設清單         |

!> inputItems 和 outputItems 的格式為 JSON 陣列，每個商品包含 item_id（商品ID）和 amount（數量）兩個欄位，所有商品ID必須存在且數量必須大於0

**返回資料：**

| 欄位名    | 型別   | 說明       | 示例        | 備註               |
| --------- | ------ | ---------- | ----------- | ------------------ |
| formulaId | 數字   | 配方ID     | 1           | 操作成功時返回     |
| result    | 整數   | 結果程式碼   | 0           | 見下方結果程式碼說明 |
| desc      | 文字   | 結果描述   | AddSuccess  | 見下方結果程式碼說明 |

**結果程式碼說明：**

| 程式碼 | 描述         | 說明       |
| ---- | ------------ | ---------- |
| 0    | Success      | 操作成功   |
| 1    | Failed       | 操作失敗   |

<br/>

### 子任務管理

?> 需要 v1.98.0+

**方法名：**subtask

**說明：**新建或編輯子任務

**示例：**
- 為任務ID為1的主任務新增子任務：[lifeup://api/subtask?main_id=1&todo=完成作業](lifeup://api/subtask?main_id=1&todo=完成作業)
- 編輯子任務並設定獎勵：[lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| 引數          | 含義           | 取值                | 示例      | 是否必須 | 備註                           |
| ------------ | -------------- | ------------------ | --------- | -------- | ------------------------------ |
| main_id      | 主任務ID       | 大於 0 的數字      | 1         | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| main_gid     | 主任務組ID     | 大於 0 的數字      | 1         | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| main_name    | 主任務名稱     | 任意文字           | 學習任務   | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| edit_id      | 編輯的子任務ID | 大於 0 的數字      | 2         | 否*      | 編輯時與 edit_gid、edit_name 必須提供其中一個；新建時無需提供 |
| edit_gid     | 編輯的子任務組ID| 大於 0 的數字     | 2         | 否*      | 編輯時與 edit_id、edit_name 必須提供其中一個；新建時無需提供 |
| edit_name    | 編輯的子任務名稱| 任意文字          | 完成作業   | 否*      | 編輯時與 edit_id、edit_gid 必須提供其中一個；新建時無需提供 |
| todo         | 任務內容       | 任意文字           | 完成作業   | 否       | 新建時必須提供                 |
| remind_time  | 提醒時間       | 時間戳（毫秒）     | 1640995200000 | 否    | 傳入 null 可清除提醒時間       |
| order        | 排序           | 整數              | 1          | 否       | 任務在列表中的排序位置          |
| coin         | 金幣獎勵       | [0, 999999]      | 10         | 否       | 完成任務獲得的金幣數量          |
| coin_var     | 金幣獎勵浮動值 | 整數              | 5          | 否       | 金幣獎勵的浮動範圍             |
| exp          | 經驗值獎勵     | [0, 99999]       | 5          | 否       | 完成任務獲得的經驗值            |
| auto_use_item| 自動使用物品   | true 或者 false   | true       | 否       | 完成任務時是否自動使用物品      |
| item_id      | 物品ID         | 大於 0 的數字     | 1          | 否*      | 與 item_name 必須提供其中一個   |
| item_name    | 物品名稱       | 任意文字          | 生命藥水    | 否*      | 與 item_id 必須提供其中一個     |
| item_amount  | 物品數量       | 大於 0 的數字     | 1          | 否       | 僅在設定物品獎勵時有效          |
| items        | 物品獎勵JSON   | JSON文字          | [{"item_id":1,"amount":1}] | 否 | 可一次性設定多個物品獎勵      |
| coin_set_type| 金幣獎勵型別   | 以下數值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定金幣為 value<br/>relative - 在原金幣值的基礎上增加或減少 |
| exp_set_type | 經驗值獎勵型別 | 以下數值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定經驗值為 value<br/>relative - 在原經驗值的基礎上增加或減少 |

**返回資料：**

| 欄位名        | 型別   | 說明         | 示例 | 備註             |
| ------------ | ------ | ------------ | ---- | ---------------- |
| main_task_id | 數字   | 主任務ID     | 1    |                  |
| subtask_id   | 數字   | 子任務ID     | 2    |                  |
| subtask_gid  | 數字   | 子任務組ID   | 3    | 可能為空         |

<br/>

### 子任務操作

?> 需要 v1.98.0+

**方法名：**subtask_operation

**說明：**對子任務進行完成、撤銷完成或刪除操作

**示例：**
- 完成子任務：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- 刪除子任務：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- 撤銷完成子任務：[lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| 引數          | 含義           | 取值                | 示例      | 是否必須 | 備註                           |
| ------------ | -------------- | ------------------ | --------- | -------- | ------------------------------ |
| main_id      | 主任務ID       | 大於 0 的數字      | 1         | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| main_gid     | 主任務組ID     | 大於 0 的數字      | 1         | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| main_name    | 主任務名稱     | 任意文字           | 學習任務   | 否*      | main_id、main_gid、main_name 必須提供其中一個 |
| edit_id      | 子任務ID       | 大於 0 的數字      | 2         | 否*      | edit_id、edit_gid、edit_name 必須提供其中一個 |
| edit_gid     | 子任務組ID     | 大於 0 的數字      | 2         | 否*      | edit_id、edit_gid、edit_name 必須提供其中一個 |
| edit_name    | 子任務名稱     | 任意文字           | 完成作業   | 否*      | edit_id、edit_gid、edit_name 必須提供其中一個 |
| operation    | 操作型別       | 以下數值其一：<br/>complete<br/>undo_complete<br/>delete | complete | 是 | complete - 完成任務<br/>undo_complete - 撤銷完成<br/>delete - 刪除任務 |

**返回資料：**

| 欄位名        | 型別   | 說明         | 示例 | 備註             |
| ------------ | ------ | ------------ | ---- | ---------------- |
| main_task_id | 數字   | 主任務ID     | 1    |                  |
| subtask_id   | 數字   | 子任務ID     | 2    |                  |
| subtask_gid  | 數字   | 子任務組ID   | 3    | 可能為空         |

<br/>

### 清單管理

?> 需要 v1.98.0+

**方法名：**category

**說明：**新增或編輯各類清單（任務清單、成就清單、商店清單、合成清單）

**示例：**
- 建立任務清單：[lifeup://api/category?type=tasks&name=學習清單](lifeup://api/category?type=tasks&name=學習清單)
- 編輯商店清單：[lifeup://api/category?type=shop&edit_id=1&name=裝備商店&order=1](lifeup://api/category?type=shop&edit_id=1&name=裝備商店&order=1)

| 引數             | 含義           | 取值                | 示例       | 是否必須 | 備註                           |
| --------------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| type            | 清單型別       | 以下數值其一：<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | 是 | tasks - 任務清單<br/>achievements - 成就清單<br/>shop - 商店清單<br/>synthesis - 合成清單 |
| edit_id         | 編輯的清單ID   | 大於 0 的數字      | 1          | 否       | 編輯時必須提供                 |
| name            | 清單名稱       | 任意文字           | 學習清單    | 否       | 新建時必須提供；編輯時可選      |
| order           | 排序           | 整數               | 1          | 否       | 清單在列表中的排序位置          |
| hidden          | 是否隱藏       | true 或者 false    | false      | 否       | 僅任務清單和商店清單支援        |
| inventory_hidden| 是否在倉庫隱藏 | true 或者 false    | false      | 否       | 僅商店清單支援                 |
| icon_uri        | 圖示URI        | URI文字            | content://... | 否    | 僅成就清單支援                 |
| desc            | 描述           | 任意文字           | 這是描述     | 否      | 僅成就清單支援                 |
| color           | 標籤顏色       | 顏色字串         | #66CCFF     | 否      | 僅任務清單支援；#需要轉義為%23  |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例 | 備註             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 數字   | 清單ID   | 1000 | 新建或編輯的清單ID |

<br/>

### 成就管理

?> 需要 v1.98.0+

**方法名：**achievement

**說明：**新增或編輯自定義成就和成就子分類

**示例：**
- 建立一個成就：[lifeup://api/achievement?name=收藏家&desc=收集100個物品&category_id=1](lifeup://api/achievement?name=收藏家&desc=收集100個物品&category_id=1)
  - 你可能需要將`category_id`替換成你實際可用的成就清單 id 以測試該示例
- 建立需要解鎖條件的成就：[lifeup://api/achievement?name=百萬富翁&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=百萬富翁&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - 你可能需要將`category_id`替換成你實際可用的成就清單 id 以測試該示例
  - `conditions_json`編碼前內容為`[{"type":7,"target":1000000}]`
- 編輯現有成就：[lifeup://api/achievement?edit_id=1&name=新成就名稱&exp=100](lifeup://api/achievement?edit_id=1&name=新成就名稱&exp=100)

#### 1. 成就引數

| 引數          | 含義           | 取值                | 示例     | 是否必須 | 備註                           |
| ------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| edit_id      | 編輯的成就ID   | 大於 0 的數字      | 1        | 否       | 編輯時必須提供                 |
| is_subcategory| 是否為子分類   | true 或者 false    | false    | 否       | 預設為 false                   |
| name         | 成就名稱       | 任意文字           | 收藏家    | 否*      | 新建時必須提供                 |
| desc         | 成就描述       | 任意文字           | 收集100個物品 | 否    |                               |
| order        | 排序           | 整數              | 1         | 否       | 在列表中的排序位置              |
| category_id  | 所屬分類ID     | 大於 0 的數字      | 1         | 否*      | 建立子分類時必須提供            |
| unlocked     | 是否解鎖       | true 或者 false    | true      | 否       | true-立即解鎖<br/>false-重置為未解鎖 |
| unlock_time  | 解鎖時間       | 時間戳（毫秒）     | 1640995200000 | 否   | 僅當成就已解鎖時有效           |
| delete       | 是否刪除       | true 或者 false    | false     | 否       |                                |
| secret       | 是否為隱藏成就 | true 或者 false    | false     | 否       |                                |
| write_feeling| 是否記錄感想   | true 或者 false    | false     | 否       |                                |
| color        | 標題顏色       | 顏色字串         | #66CCFF   | 否       | #需要轉義為%23                  |
| auto_use_item| 自動使用物品   | true 或者 false    | false     | 否       |                                |
| skills       | 技能ID         | 大於 0 的數字陣列   | 1         | 否       | 支援陣列（如 &skills=1&skills=2）|
| exp          | 經驗值獎勵     | 整數              | 100       | 否       |                                |
| item_id      | 物品ID         | 大於 0 的數字      | 1         | 否*      | 與 item_name 必須提供其中一個   |
| item_name    | 物品名稱       | 任意文字           | 寶箱      | 否*      | 與 item_id 必須提供其中一個     |
| item_amount  | 物品數量       | [1, 99]           | 1         | 否       | 預設為 1                       |
| items        | 物品獎勵JSON   | JSON文字           | [{"item_id":1,"amount":2}] | 否 | 可一次設定多個物品獎勵，格式見下文 |
| conditions_json | 解鎖條件JSON | JSON文字          | [{"type":7,"target":1000000}] | 否 | 設定解鎖條件，格式見下文 |
| coin         | 金幣獎勵       | [0, 999999]      | 10         | 否       | 完成任務獲得的金幣數量          |
| coin_var     | 金幣獎勵浮動值 | 整數              | 5          | 否       | 金幣獎勵的浮動範圍             |
| coin_set_type| 金幣獎勵型別   | 以下數值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定金幣為 value<br/>relative - 在原金幣值的基礎上增加或減少 |
| exp_set_type | 經驗值獎勵型別 | 以下數值其一：<br/>absolute<br/>relative | absolute | 否 | absolute - 直接設定經驗值為 value<br/>relative - 在原經驗值的基礎上增加或減少 |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例 | 備註             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 數字   | 成就ID   | 1000 | 新建或編輯的成就ID |


#### 2. 子分類專用引數

| 引數          | 含義           | 取值                | 示例     | 是否必須 | 備註                           |
| ------------ | -------------- | ------------------ | -------- | -------- | ------------------------------ |
| is_collapsed | 是否摺疊       | true 或者 false    | false    | 否       | 僅適用於子分類                  |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例 | 備註             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 數字   | 成就ID   | 1000 | 新建或編輯的成就ID (子分類) |

#### 3. 解鎖條件型別說明

| 型別程式碼 | 含義               | 是否需要related_id | related_id型別 | target說明        |
| ------- | ------------------ | ---------------- | -------------- | ----------------- |
| 0       | 完成任務次數        | 是              | 任務ID         | 完成次數           |
| 1       | 連續完成任務次數     | 是              | 任務ID         | 連續次數           |
| 3       | 番茄數量           | 否              | -              | 番茄數量           |
| 4       | 使用人昇天數        | 否              | -              | 使用天數           |
| 5       | 被點贊數           | 否              | -              | 點贊數量           |
| 6       | 連續完成天數        | 否              | -              | 連續天數           |
| 7       | 當前金幣數         | 否              | -              | 金幣數量           |
| 8       | 一天內金幣獲得數     | 否              | -              | 金幣數量           |
| 9       | 任務的番茄數        | 是              | 任務ID         | 番茄數量           |
| 10      | 物品購買數         | 是              | 物品ID         | 購買次數           |
| 11      | 物品使用數         | 是              | 物品ID         | 使用次數           |
| 12      | 物品開箱獲得數      | 是              | 物品ID         | 獲得次數           |
| 13      | 技能達到指定等級     | 是              | 技能ID         | 等級數值           |
| 14      | 人生等級           | 否              | -              | 等級數值           |
| 15      | 物品累計獲得數      | 是              | 物品ID         | 獲得總次數         |
| 16      | 物品合成獲得數      | 是              | 物品ID         | 合成獲得次數        |
| 17      | 物品當前擁有數量     | 是              | 物品ID         | 擁有數量           |
| 18      | 任務番茄鍾專注時長   | 是              | 任務ID         | 專注時長(分鐘)      |
| 19      | ATM存款           | 否              | -              | 存款數量           |
| 20      | 外部API           | 否              | -              | 根據API定義        |

#### 4. JSON格式說明

##### 解鎖條件 (conditions_json)
```json
[
   {
       "type": 7,           // 條件型別（參考上表）
       "related_id": null,  // 關聯ID（部分型別必須提供）
       "target": 1000000    // 目標數值
   },
   {
       "type": 10,          // 示例：購買指定物品
       "related_id": 1,     // 物品ID
       "target": 5          // 購買5次
   }
]
```

##### 物品獎勵 (items)
```
[
    {
        "item_id": 1,    // 物品ID
        "amount": 2      // 數量
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### 技能管理

?> 需要 v1.98.0+

**方法名：**skill

**說明：**新建或編輯自定義技能（屬性）

**示例：**
- 建立一個技能：[lifeup://api/skill?content=程式設計&desc=程式碼能力&color=%23FF6B6B](lifeup://api/skill?content=程式設計&desc=程式碼能力&color=%23FF6B6B)
- 編輯技能經驗值：[lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- 刪除技能：[lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| 引數         | 含義           | 取值                | 示例       | 是否必須 | 備註                           |
| ----------- | -------------- | ------------------ | ---------- | -------- | ------------------------------ |
| id          | 技能ID         | 大於 0 的數字      | 1          | 否       | 編輯時必須提供                 |
| content     | 技能名稱       | 任意文字           | 程式設計        | 否*      | 新建時必須提供                 |
| desc        | 技能描述       | 任意文字           | 程式碼能力    | 否       |                               |
| icon        | 圖示           | 任意文字           | 💻         | 否       | 可以使用 emoji                 |
| color       | 顏色           | 顏色字串         | #FF6B6B    | 否       | #需要轉義為%23                 |
| type        | 型別           | 整數               | 0          | 否       |                               |
| order       | 排序           | 整數               | 1          | 否       | 在列表中的排序位置             |
| status      | 狀態           | 整數               | 0          | 否       |                               |
| exp         | 經驗值         | 大於或等於 0 的數字 | 100        | 否       | 技能當前經驗值                 |
| delete      | 是否刪除       | true 或者 false    | false      | 否       | 僅在編輯模式下有效             |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例 | 備註             |
| ------ | ------ | -------- | ---- | ---------------- |
| id     | 數字   | 技能ID   | 1000 | 新建或編輯的技能ID |

<br/>

### 匯出備份

?> 需要 v1.98.0+

**方法名：**export_backup

**說明：**建立一個備份檔案並返回其 URI（僅支援透過 Content Provider 呼叫）

!> 此 API 只能透過 Content Provider 方式呼叫，不支援直接使用 URL Scheme 呼叫

| 引數          | 含義           | 取值            | 示例  | 是否必須 | 備註                                           |
| ------------- | -------------- | --------------- | ----- | -------- | ---------------------------------------------- |
| withMedia     | 是否包含媒體檔案 | true 或者 false | true  | 否       | 是否在備份中包含媒體檔案（圖片、音效等）<br/>預設為 true |
| callingPackage| 呼叫方包名     | 任意文字        | com.example.app | 否 | Content Provider 呼叫時的包名標識 |

**返回資料：**

| 欄位名          | 型別   | 說明                 | 示例                                          |
| --------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | 文字   | 備份檔案的 URI 地址  | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### 應用設定

?> 需要 v1.98.0+

**方法名：**app_settings

**說明：**調整應用的介面設定

**示例：**
- 啟用簡潔模式：[lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- 啟用 Material You 主題：[lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- 更改設定並立即重啟介面：[lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| 引數                    | 含義              | 取值            | 示例  | 是否必須 | 備註                           |
| ---------------------- | ----------------- | --------------- | ----- | -------- | ------------------------------ |
| is_enable_compact_mode | 是否啟用簡潔模式   | true 或者 false | true  | 否       | 精簡介面元素                    |
| is_enable_material_you | 是否啟用Material You| true 或者 false | true  | 否       | 啟用 Material You 主題          |
| restart_activities     | 是否重啟介面       | true 或者 false | true  | 否       | 立即應用介面更改                |

**返回資料：**

| 欄位名 | 型別   | 說明     | 示例 | 備註             |
| ------ | ------ | -------- | ---- | ---------------- |
| result | 整數   | 結果程式碼 | 0    | 0 表示設定成功   |

<br/>

### 簡單查詢

!> 此處的功能是用於搭配自動化工具/二次開發的。如果你需要查詢完整的資料列表，可以參考我們的 LifeUp SDK、《雲人升》、《人升桌面端》。

**方法名：**query

**說明：**查詢引數

**版本：**需要 v1.90.2

**示例：**

- 查詢當前金幣數：[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

| 引數        | 含義       | 取值                                                         | 示例 | 是否必須                        | 備註                                                         |
| ----------- | ---------- | ------------------------------------------------------------ | ---- | ------------------------------- | ------------------------------------------------------------ |
| key         | 查詢的型別 | 僅限以下數值其一：<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato | coin | 是                              | coin - 當前金幣數<br/>atm - 當前 ATM 存款<br/>item - 指定 `itemId` 的商品資訊<br/>item_id_list - 指定`categoryId`的商品id列表<br/>tomato - 番茄資料 |
| item_id     | 商品id     | 大於 0 的數字                                                | 1    | 當 key 為 item 時，必須         | 查詢的商品 id                                                |
| category_id | 清單id     | 大於或者等於 0 的數字                                        | 1    | 當 key 為 item_id_list 時，必須 | 只有當key為`item_id_list`時需要，代表查詢的清單 id           |

**返回值：**

當查詢 coin/atm 時：

| 引數  | 含義           | 取值 | 示例 | 是否必須 | 備註 |
| ----- | -------------- | ---- | ---- | -------- | ---- |
| value | 查詢返回的數值 | 數字 | 1000 | 是       |      |

當查詢 item 時：

| 引數             | 含義         | 取值     | 示例      | 是否必須 | 備註                           |
| ---------------- | ------------ | -------- | --------- | -------- | ------------------------------ |
| item_id          | 商品id       | 數字     | 1         | 是       | -                              |
| name             | 名稱         | 任意文字 | 商品      | 是       | -                              |
| desc             | 描述         | 任意文字 |           | 否       | -                              |
| icon             | 圖示地址     | 任意文字 | icon.webp | 否       | 如果是本地檔案時，只返回檔名 |
| category_id      | 清單 id      | 數字     | 1         | 是       | -                              |
| stock_number     | 商店庫存數量 | 數字     | -1        | 是       | -1 代表無限商店庫存            |
| own_number       | 倉庫擁有數   | 數字     | 10        | 是       | -                              |
| price            | 價格         | 數字     | 100       | 是       | -                              |
| order            | 排序依據     | 數字     | 100       | 是       | 自定義排序時的權重值           |
| disable_purchase | 是否禁止購買 |          | true      | 是       | -                              |

當查詢 item_id_list 時：

| 引數     | 含義                            | 取值   | 示例    | 是否必須 | 備註 |
| -------- | ------------------------------- | ------ | ------- | -------- | ---- |
| item_ids | 查詢返回的商品id陣列，以`,`分隔 | 字串 | 1,2,3,4 | 是       |      |

當查詢 tomato 時：

| 引數      | 含義         | 取值 | 示例 | 是否必須 | 備註 |
| --------- | ------------ | ---- | ---- | -------- | ---- |
| total     | 總番茄數量   | 數字 | 100  | 是       |      |
| available | 可用番茄數量 | 數字 | 50   | 是       |      |
| exchanged | 已兌換番茄數量 | 數字 | 50   | 是       |      |



<br/>

### 查詢屬性狀態

!> 此處的功能是用於搭配自動化工具/二次開發的

**方法名：**query_skill

**說明：**查詢指定屬性的名稱、等級、總經驗值、直至下一級等級所需經驗值、目前等級經驗值。

可以由於自動化工具獲取等級，自定義開發屬性小部件等。

**版本：**需要 v1.90.6

**示例：**

- 查詢力量屬性：[lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| 引數 | 含義             | 取值        | 示例 | 是否必須 | 備註                                          |
| ---- | ---------------- | ----------- | ---- | -------- | --------------------------------------------- |
| id   | 技能（屬性）的id | 大於0的數字 | 1    | 是       | 獲取方式請檢視上文 「基礎知識 - 人升資料 ID」 |

**返回值：**

| 引數                 | 含義                         | 取值   | 示例  | 是否必須 | 備註 |
| -------------------- | ---------------------------- | ------ | ----- | -------- | ---- |
| name                 | 屬性名稱                     | 字串 | 力量  | 是       | -    |
| level                | 等級                         | 數字   | 10    | 是       | -    |
| total_exp            | 總經驗值                     | 數字   | 10000 | 是       | -    |
| until_next_level_exp | 升到下一級所需的經驗值       | 數字   | 99    | 是       | -    |
| current_level_exp    | 超過當前等級的已獲得的經驗值 | 數字   | 1000  | 是       | -    |

<br/>

### 特殊介面

#### 隨機

?> 該 API 於 v1.93.0-beta02 釋出。

**方法名：**random

**說明：**簡單的隨機介面，可以隨機觸發多個 API 中的其中一個。

**示例：**

- 同等機率隨機顯示`石頭`、`剪刀`、`布`：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布)

- 90%機率顯示`石頭`、5%機率`剪刀`、5%機率`布`，：[lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D剪刀&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D布&weight=90&weight=5&weight=5)

| 引數   | 含義       | 取值        | 示例                                   | 是否必須 | 備註                                                         |
| ------ | ---------- | ----------- | -------------------------------------- | -------- | ------------------------------------------------------------ |
| api    | 隨機的 API | 任意文字    | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D石頭 | 是       | 支援陣列形式呼叫（即可以存在多個api引數，見上述例子）        |
| weight | 比重       | 大於0的數字 | 1                                      | 否       | 支援陣列形式呼叫<br/><br/>如果不指定比重，預設比重都一樣（機率同等均等）。<br/>如果指定比重，會按順序分配：如第一個weight分配到第一個api引數。<br/><br/>**請確保weight引數的數量與 api 引數的數量一致，否則可能會不生效。** |

<br/>

#### 彈窗

**方法名：**confirm_dialog

**說明：**彈出一個選擇彈窗，可以自定義標題、文字、積極按鈕、消極按鈕。點選按鈕時也可以呼叫其他介面。

**示例：**

- [lifeup://api/confirm_dialog?title=你相信愛嗎&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D相信&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D不相信](lifeup://api/confirm_dialog?title=你相信愛嗎&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D相信&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D不相信)

- 其他使用場景：

  獎勵二選一

  分支選擇

| 引數            | 含義               | 取值            | 示例                                         | 是否必須 | 備註                                                         |
| --------------- | ------------------ | --------------- | -------------------------------------------- | -------- | ------------------------------------------------------------ |
| title           | 彈窗標題           | 任意文字        | 標題                                         | 是       | -                                                            |
| message         | 彈窗詳細描述       | 任意文字        | 這是彈窗內容                                 | 否       | -                                                            |
| positive_text   | 積極按鈕文案       | 任意文字        | 確定                                         | 否       | -                                                            |
| negative_text   | 消極按鈕文案       | 任意文字        | 拒絕                                         | 否       | -                                                            |
| neutral_text    | 中性按鈕文案       | 任意文字        | 說明                                         | 否       | -                                                            |
| positive_action | 積極按鈕的連結響應 | URL（其他介面） | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D你點了確定 | 否       | 實際上就是彈出訊息介面經過轉義的文字。轉義規則可參考`基礎知識-轉義`。 |
| negative_action | 消極按鈕的連結響應 | URL（其他介面） | 同上                                         | 否       | 同上                                                         |
| neutral_action  | 中性按鈕的連結響應 | URL（其他介面） | 同上                                         | 否       | 同上                                                         |
| cancel_action   | 取消彈窗的連結響應 | URL（其他介面） | 同上                                         | 否       | 「取消」指的是                                               |

<br/>

#### 空介面

**方法名：**placeholder

**說明：**該介面自身不處理任何邏輯，但你可以搭配 callback、broadcast 使用。

**示例：**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)


#### 變數佔位符

「人升」提供了對引數的使用者介入處理手段。

| 佔位符                              | 含義                                                         | 示例                                                         |
| ----------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| [$text\|標題]                       | 文字佔位符                                                   | [$text\|輸入任務名稱]                                        |
| [$number\|標題]                     | 數字佔位符（不含小數點）                                     | [$number\|輸入價格]                                          |
| [$number\|標題\|signed]            | 數字佔位符（不含小數點），並顯示正負符號                     | [$number\|輸入價格\|signed]                                  |
| [$decimal\|標題]                    | 數字佔位符（含小數點）                                       | [$decimal\|輸入ATM利率]                                       |
| [$decimal\|標題\|signed]           | 數字佔位符（含小數點），並顯示正負符號                       | [$decimal\|輸入ATM利率\|signed]                                |
| [$item]                             | 選擇商品，將被替換為商品id                                   | [$item]                                                      |
| [$task_category]                    | 選擇任務清單，將被替換為任務清單id                           | [$task_category]                                             |
| [$time\|錨定時間\|偏移毫秒（可選）] | 時間佔位符<br/><br/>其中錨定時間的取值有：<br/>`current`、`today`、`this_monday`、`last_monday`、`this_month`、`last_month`、`this_year`、`last_year`<br/><br/>偏移毫秒應該為整數，預設為 0 毫秒 | 今天0點：[$time\|today]<br/>明天0點：[$time\|today\|86400000] |
| [$random_number\|最小值\|最大值]    | 隨機數字佔位符（不含小數點）                                 | [$random_number\|0\|3000]                                    |
| [$random_decimal\|最小值\|最大值]   | 隨機數字佔位符（含小數點）                                   | [$random_decimal\|1.0\|2.0]                                  |

**示例1：使用時，選擇物品降價1金幣**

比如當你設定為某個商品降價的 api 後，**可能希望在呼叫的時候，再允許使用者選擇指定商品。**而非呼叫時就指定 id。

以下 api 只能讓 id 為 1 的商品降價 1 金幣：

```url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
```

只需要將商品 id 修改爲佔位符`[$item]`，就可以實現呼叫的時候，使用者能主動選擇想要降價的商品：

[lifeup://api/item?id=[$item|請選擇你想要降價1金幣的商品]&set_price=-1&set_price_type=relative](lifeup://api/item?id=[$item|請選擇你想要降價1金幣的商品]&set_price=-1&set_price_type=relative)



**示例2：任務模板，只需要輸入任務名稱和選擇清單，即可建立提前設定好的獎勵模板**

[lifeup://api/add_task?todo=[$text|輸入任務名稱]&notes=這是個任務的獎勵模板&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]](lifeup://api/add_task?todo=[$text|輸入任務名稱]&notes=這是個任務的獎勵模板&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category])


<br/>

#### 結束回撥

所有介面你都可以加上`callback`引數，實現呼叫後回撥該`URL`的處理。

這也可以用於拼接多個介面，比如想要實現跳轉後提示激勵語：

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

可以使用`callback`引數，參考上文**基礎知識-轉義**，就可以寫出這種的處理：

[lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D測試callback](lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D測試callback)



當然，你也完全可以為一個商品新增多個連結來實現該效果。

該回調更多是用於：

A應用 -> 人升 -> A應用

或

A應用 -> 人升 -> B應用

<br/>

#### Broadcast 廣播返回值

!> 此處的功能是用於搭配自動化工具/二次開發的，有一定門檻。

增加這個引數，可以將 API 原本的返回值也透過廣播發送出去。以便 Tasker 等自動化工具能夠接收到。

broadcast 的數值相當於 Tasker 中的「收到的意圖」的操作一欄的數值，你可以填寫任意文字，只要這兩者對應上即可。

**比如 Tasker 使用查詢金幣的 API（[如果你在使用MacroDroid，請檢視這篇教程](https://github.com/Ayagikei/LifeUp/issues/43)）：**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. 新增 broadcast 引數，讓它能夠廣播返回值到 Tasker，可以是任意文字，比如`app.lifeup.query.coin`。

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. 在 Tasker 中新增事件->「收到的意圖」，在操作一欄填寫「app.lifeup.query.coin」

3. 然後可以在 Tasker 中的任務以`%value`變數的方式接收到`value`的返回值。

4. 然後你可以在 Tasker 中判斷金幣數實現各種效果了。（比如根據金幣數更換桌面桌布？）

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## 廣播事件通知

!> 此處的功能是用於搭配自動化工具/二次開發的，有一定使用知識和使用門檻。

> 1.90.2 版本我們會以廣播的形式向外部發送人升的各種事件。你可以使用 Tasker 等自動化工具接收這些事件來觸發 Tasker 的動作。

### 啟用

預設廣播事件是關閉的。

你可以在`設定`-`實驗`-`開發者模式`-`廣播事件`啟用它。

### 示例：使用商品更換桌布

1. 新建一個商品，名稱叫做「更換桌布」。
2. 在 Tasker 中，`配置檔案`->`事件`->`系統`->`收到的意圖`，在操作一欄輸入`app.lifeup.item.use`，返回。
3. 點選新建任務，輸入任意名稱（比如更換桌布）。
4. 點選右下角+號新增任務，選擇`任務`->`If`
5. 將條件一欄調整為 `%name = 更換桌布`。
6. 返回，`插入操作`選擇`If`。
7. 再次點選右下角+號新增任務，選擇`顯示`->`設定桌布`
8. （可選）`型別`更換為`全部`
9. 影象一欄，點選🔍圖示，選擇你想要的桌布檔案
10. 退出，檢查是否已經啟用了這個配置。
11. 在`人升`中使用「更換桌布」商品，你應該能成功見到桌布更換了

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

使用`空介面`+`Broadcast 廣播返回值`可以以更簡潔的方式實現這個效果，可以摸索下。

<br/>

### 完成任務

**名稱：**app.lifeup.task.complete

**返回值：**

| 引數        | 含義           | 示例         |
| ----------- | -------------- | ------------ |
| task_id     | 任務id         | 1            |
| task_gid    | 任務組id       | 1            |
| name        | 任務名稱       | 開始使用人升 |
| category_id | 任務所屬清單id | 1            |

### 放棄任務

**名稱：**app.lifeup.task.giveup

**返回值：**

| 引數        | 含義           | 示例            |
| ----------- | -------------- | --------------- |
| task_id     | 任務id         | 1               |
| task_gid    | 任務組id       | 1               |
| name        | 事項名稱       | Getting started |
| category_id | 任務所屬清單id | 1               |

### 逾期任務

**名稱：**app.lifeup.task.overdue

**返回值：**


| 引數      | 含義             | 示例                            |
| --------- | ---------------- | ------------------------------- |
| task_ids  | 任務id**陣列**   | [1, 2, 3]                       |
| task_gids | 任務組id**陣列** | [1, 2, 3]                       |
| names     | 事項名稱**陣列** | [Getting started, Drink Waters] |
| task_ids_json  | 任務id**Json陣列**   | [1, 2, 3]                       |
| task_gids_json | 任務組id**Json陣列** | [1, 2, 3]                       |
| names_json     | 事項名稱**Json陣列** | ["Getting started", "Drink Waters"]                      |



### 解鎖成就

**名稱：**app.lifeup.achievement.unlock

**返回值：**

| 引數           | 含義     | 示例             |
| -------------- | -------- | ---------------- |
| achievement_id | 成就id   | 1                |
| name           | 成就名稱 | 連續使用人升30天 |

### 購買商品

**名稱：**app.lifeup.item.purchase

**返回值：**

| 引數    | 含義     | 示例       |
| ------- | -------- | ---------- |
| item_id | 商品id   | 1          |
| name    | 商品名稱 | 休息10分支 |
| amount  | 購買數量 | 1          |

### 使用商品

**名稱：**app.lifeup.item.use

**返回值：**

| 引數    | 含義     | 示例       |
| ------- | -------- | ---------- |
| item_id | 商品id   | 1          |
| name    | 商品名稱 | 休息10分支 |
| amount  | 使用數量 | 1          |

### 新增感想

**名稱：**app.lifeup.feelings.add

**返回值：**

| 引數              | 含義                     | 示例                  |
| ----------------- | ------------------------ | --------------------- |
| feelings_id       | 感想id                   | 1                     |
| action_type       | 操作型別                 | add 或 update         |
| content           | 感想內容                 | 今天心情不錯！         |
| create_time       | 建立時間戳               | 1642060800000         |
| relate_type       | 關聯型別                 | 0                     |
| related_id        | 關聯物件id               | 1                     |
| attachments_count | 附件數量                 | 2                     |
| attachments       | 附件陣列                 | ["/path/1", "/path/2"] |

### 等級提升

**名稱：**app.lifeup.level.up

**返回值：**

| 引數     | 含義     | 示例 |
| -------- | -------- | ---- |
| skill_id | 任務id   | 1    |
| name     | 名稱     | 力量 |
| level    | 當前等級 | 2    |

### 等級降低

**名稱：**app.lifeup.level.down

**返回值：**

| 引數     | 含義     | 示例 |
| -------- | -------- | ---- |
| skill_id | 任務id   | 1    |
| name     | 名稱     | 力量 |
| level    | 當前等級 | 2    |

### 商品倒計時

**名稱：**

- 開始：app.lifeup.item.countdown.start
- 停止：app.lifeup.item.countdown.stop
- 完成（正常結束）：app.lifeup.item.countdown.complete

**返回值：**



| 引數      | 含義             | 示例       |
| --------- | ---------------- | ---------- |
| item_id   | 商品id           | 1          |
| name      | 商品名稱         | 學習30分鐘 |
| time_left | 剩餘時間（毫秒） | 30000      |



---

## 聯動

我們非常歡迎其他開發者任何形式的聯動。

### 需要更多 API？

API 功能目前僅經過了一個版本的迭代。

未來我們會持續加入更多的 API，以滿足更多的使用場景。

如果你有需要的 API 場景，可以在 [Github 留下 Issues](https://github.com/Ayagikei/LifeUp/issues/new/choose) 或者我們的 [QQ 頻道](https://ti.qq.com/open_qq/index.html?url=https%3A%2F%2Fqun.qq.com%2Fqqweb%2Fqunpro%2Fshare%3F_wv%3D3%26_wwv%3D128%26appChannel%3Dshare%26inviteCode%3D1W7IRQv%26businessType%3D9%26from%3D246610%26biz%3Dka%23%2Fout)進行留言。

<br/>


### 如何呼叫

#### Android

##### 使用 SDK

請參考：https://github.com/Ayagikei/LifeUp-SDK 的 `core` 模組。

##### 不使用 SDK

```kotlin
    /**
    * 定義一個方法處理 uri
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
        // 然後在合適的地方呼叫即可
        call(context, "lifeup://api/toast?text=你學會了呼叫！&type=1&isLong=true")
        ...
    }
```

<br/>

#### 網頁

網頁呼叫的話，能否觸發也依賴於瀏覽器。常規的瀏覽器如夸克、Chrome、Edge都是可以的。但一些其他的系統內建的瀏覽器，可能會每次彈出時提醒使用者“是否開啟人升”。

如果你是自己開發的內嵌 WebView 應用，需要確保 WebView 能夠處理 lifeup scheme。

如果你想要保證體驗一致的話，可以使用「人升」裡的商品連結效果，並勾選“使用內建瀏覽器”開啟。但由於安全設定，這種方式僅支援 HTTPS 連結（不支援 HTTP）

**HTML**

直接超鏈接跳轉即可

```htm
<a href="lifeup://api/toast?text=你學會了呼叫！&amp;type=1&amp;isLong=true" target="_blank" rel="noopener">點選這裏呼叫</a>
```

**Javascript**

其實也是呼叫超鏈接

```javascript
location.href='lifeup://api/reward?type=coin&content=Wordle沒猜對，安慰獎&number=1'
```

<br/>


### 應用開發者

如果你是應用開發者，且支援與「人升」聯動，實現了有趣的功能和機制。

可以聯絡我們在應用內互相推薦應用。

> 如需 Google Play 上架等也可聯絡協助。

<br/>


### 網頁開發者

如果你是網頁開發者，開發了呼叫「人升」API 的網頁作品，歡迎在應用內透過商品的形式分享你的作品。

也可以聯絡我們進行互相推薦。

如果你的是靜態網頁，且不熟悉託管，也可以聯絡我們協助託管網頁。

<br/>

### 任意支援 HTTP 協議的程式語言/平臺

詳情請查閱應用內-側邊欄-設定-實驗-《雲人升》。

<h1 align="center" padding="100">雲人升 ☁️ </h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

《雲人升》是 API 開發的基礎套件之一。

它能夠將所有 API 以 HTTP 服務的形式提供出來，使得你**無需任何安卓開發知識，就能以跨裝置地以任何其他程式設計工具或者軟體（比如 Python、網頁）呼叫《人升》的 API 呼叫或者查詢資料**。

《人升-桌面端》就是一個基於《雲人升》實現的例項應用。

<br/>

## 下載

- 如果你是中國大陸版本的會員的話，可以在`側邊欄`-`設定`-`實驗`頁面找到《雲人升》的下載按鈕。
- [Google Play 商店地址](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>

## HTTP 介面定義

⚠ 這裏的介面定義更新可能會有滯後性，以我們的原始碼爲準：[LifeUp-SDK/KtorService.kt at main · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme 呼叫介面

#### GET 形式

介面功能：

> 用於呼叫 lifeup://api 開頭的 API。

介面請求地址：

```awk
// 【推薦】content provider 機制，相容性更好
http://{host:port}/api/contentprovder

// start activity 機制，部分裝置可能會限制後臺顯示介面許可權，導致無法執行
http://{host:port}/api
```

**請求方式：GET**

**請求引數說明：**

| 欄位名 | 欄位說明                    | 位置  | 欄位型別 | 是否必填 | 備註                                                 |
| ------ | --------------------------- | ----- | -------- | -------- | ---------------------------------------------------- |
| url    | lifeup://api 開頭的 API URL | Query | string   | 是       | 如果是手動拼接的話，URL 注意轉義。支援拼接多個 url。 |

**請求例項：**

```url
// 單一呼叫（content 
http://{host:port}/api/contentprovder?url=YOUR_ENCODED_API_URL

// 批次呼叫
http://{host:port}/api/contentprovder?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// 單一呼叫（start activity形式）
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST 形式

介面功能：

> 用於呼叫 lifeup://api 開頭的 API。

介面請求地址：

```awk
// 【推薦】content provider 機制，相容性更好
http://{host:port}/api

// start activity 機制，部分裝置可能會限制後臺顯示介面許可權，導致無法執行
http://{host:port}/api/contentprovder
```

**請求方式：POST**

**JSON BODY 請求引數說明：**

| 欄位名 | 欄位說明                         | 位置 | 欄位型別     | 是否必填 | 備註       |
| ------ | -------------------------------- | ---- | ------------ | -------- | ---------- |
| urls   | lifeup://api 開頭的 API URL 陣列 | Body | List<string> | 是       | 不需要轉義 |

**請求例項：**

```
// POST
http://{host:port}/api/contentprovider

// BODY 引數
{
	"urls": ["lifeup://api/goto?page=lab"]
}
```

### 2. 資料列表查詢介面

**⚠注意：**

1. 你需要 v1.91 版本的《人升》和最新版的《雲人升》。
2. 你需要先在《雲人升》中申請“讀取人升資料”許可權。

介面功能：

> 查詢《人升》中的完整資料，如任務列表、商品列表

介面請求地址：

**任務相關**

```awk
// 所有任務
http://{host:port}/tasks

// 指定清單${id}裡面的任務
http://{host:port}/tasks/${id}

// 歷史記錄（支援分頁查詢）
http://{host:port}/history?offset=${offset}&limit=${limit}

// 任務清單
http://{host:port}/tasks_categories
```

**商品相關**

```awk
// 所有商品
http://{host:port}/items

// 指定清單${id}裡面的商品
http://{host:port}/items/${id}

// 商品清單
http://{host:port}/items_categories
```

**成就相關**

```awk
// 所有商品
http://{host:port}/achievements

// 指定清單${id}裡面的商品
http://{host:port}/achievements/${id}

// 成就清單
http://{host:port}/achievement_categories
```

**感想**

```awk
// 所有感想（分頁查詢）
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**屬性**

```awk
// 所有屬性
http://{host:port}/skills
```

**請求方式：GET**

**請求引數說明：**

| 欄位名 | 欄位說明     | 位置  | 欄位型別 | 是否必填 | 備註               |
| ------ | ------------ | ----- | -------- | -------- | ------------------ |
| id     | 對應的資料id | Query | 數字     | 是       | -                  |
| offset | 查詢偏移量   | Query | 數字     | 否       | 目前僅部分介面需要 |
| limit  | 限制數量     | Query | 數字     | 否       | 目前僅部分介面需要 |

**請求例項：**


**任務相關**

```awk
// 所有任務
http://{host:port}/tasks

// 指定清單id 1 裡面的任務
http://{host:port}/tasks/1

// 歷史記錄（支援分頁查詢），查詢第0位開始的 100 條
http://{host:port}/history?offset=0&limit=100

// 任務清單
http://{host:port}/tasks_categories
```

**商品相關**

```awk
// 所有商品
http://{host:port}/items

// 指定清單id 1 裡面的商品
http://{host:port}/items/1

// 商品清單
http://{host:port}/items_categories
```

**成就相關**

```awk
// 所有商品
http://{host:port}/achievements

// 指定清單${id}裡面的商品
http://{host:port}/achievements/${id}

// 成就清單
http://{host:port}/achievement_categories
```

**感想**

```awk
// 所有感想（分頁查詢），查詢第0位開始的 100 條
http://{host:port}/feelings?offset=0&limit=100
```

**屬性**

```awk
// 所有屬性
http://{host:port}/skills
```

<br/>

### 3. 獲取圖片介面

**⚠注意：**

1. 由於安卓的儲存限制，呼叫該介面會需要《雲人升》從《人升》複製一份圖片副本。

介面功能：

> 載入上述介面中返回的圖片（一般為 content:// 樣式）

介面請求地址：

```awk
http://{host:port}/files/${url}
```

**請求方式：GET**

**請求引數說明：**

| 欄位名 | 欄位說明 | 位置 | 欄位型別 | 是否必填 | 備註 |
| ------ | -------- | ---- | -------- | -------- | ---- |
| url    | 檔案URL  | Path | 字串   | 是       | -    |

**請求例項：**

```awk
http://{host:port}/files/xxx
```

<br/>

## 貢獻

SDK、《雲人升》、《桌面端》皆為開源專案。

你可以在以下連結獲取到原始碼並使用 IDEA 執行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud is one of the core API toolkits for LifeUp.

It exposes LifeUp APIs as HTTP services, so you can call APIs or query data from other tools (such as Python scripts or web apps) **across devices, without Android development experience**.

LifeUp Desktop is a reference app built on top of LifeUp Cloud.

<br/>

## Download

- If you use the Mainland China membership version, you can find the LifeUp Cloud download entry in `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>

## HTTP API Definition

> [!WARNING]
> API docs on this page may lag behind implementation updates. Please use source code as the final reference: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme Invocation API

#### GET

Function:

> Invoke APIs that start with `lifeup://api`.

Request URL:

```txt
// Recommended: content provider mode (better compatibility)
http://{host:port}/api/contentprovider

// startActivity mode (some devices may block background UI)
http://{host:port}/api
```

**Method: `GET`**

**Query parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| url | API URL starting with `lifeup://api` | Query | string | Yes | URL-encode when constructing manually. Multiple `url` params are supported. |

**Request examples:**

```txt
// Single call (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Batch call
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Single call (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Function:

> Invoke APIs that start with `lifeup://api`.

Request URL:

```txt
// Recommended: content provider mode (better compatibility)
http://{host:port}/api/contentprovider

// startActivity mode (some devices may block background UI)
http://{host:port}/api
```

**Method: `POST`**

**JSON body parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| urls | Array of URLs starting with `lifeup://api` | Body | List<string> | Yes | No extra URL encoding needed in JSON body. |

**Request example:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. Data Query APIs

> [!NOTE]
> Requirements:
> 1. LifeUp v1.91+ and the latest LifeUp Cloud.
> 2. Grant **Read LifeUp Data** permission in LifeUp Cloud.

Function:

> Query full LifeUp data sets, such as tasks and items.

**Task endpoints**

```txt
// All tasks
http://{host:port}/tasks

// Tasks in category/list ${id}
http://{host:port}/tasks/${id}

// History (supports pagination)
// filterGid is optional and can be used to filter all history records of a repeating task
http://{host:port}/history?offset=${offset}&limit=${limit}&filterGid=${filterGid}

// Task categories
http://{host:port}/tasks_categories
```

**Item endpoints**

```txt
// All items
http://{host:port}/items

// Items in category/list ${id}
http://{host:port}/items/${id}

// Item categories
http://{host:port}/items_categories
```

**Achievement endpoints**

```txt
// ~~All achievements (not currently implemented in app, as of v1.100.4)~~
// ~~http://{host:port}/achievements~~

// Achievements in category/list ${id}
http://{host:port}/achievements/${id}

// Achievement categories
http://{host:port}/achievement_categories
```

**Feeling endpoints**

```txt
// All feelings (supports pagination)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Synthesis category endpoints**

```txt
// All synthesis categories
http://{host:port}/synthesis_categories

// Synthesis categories in list ${id}
http://{host:port}/synthesis_categories/${id}
```

**Synthesis recipe endpoints**

```txt
// All synthesis recipes
http://{host:port}/synthesis

// Synthesis recipes in category ${id}
http://{host:port}/synthesis/${id}
```

**Attribute endpoints**

```txt
// All attributes
http://{host:port}/skills
```

**Method: `GET`**

**Parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| id | Data ID | Path/Query | Number | Yes (for ID-specific endpoints) | - |
| offset | Query offset | Query | Number | No | Required only for some paged endpoints |
| limit | Page size | Query | Number | No | Required only for some paged endpoints |
| filterGid | Filter repeating-task history | Query | Number | No | Optional for history query |

**Request examples**

**Tasks**

```txt
// All tasks
http://{host:port}/tasks

// Tasks in list ID 1
http://{host:port}/tasks/1

// History (100 records from index 0)
http://{host:port}/history?offset=0&limit=100

// Task categories
http://{host:port}/tasks_categories
```

**Items**

```txt
// All items
http://{host:port}/items

// Query specific item IDs 1 and 4
http://{host:port}/items?id=1&id=4

// Items in list ID 1
http://{host:port}/items/1

// Item categories
http://{host:port}/items_categories
```

**Achievements**

```txt
// Achievements in list/category ${id}
http://{host:port}/achievements/${id}

// Achievement categories
http://{host:port}/achievement_categories
```

**Feelings**

```txt
// 100 records from index 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attributes**

```txt
http://{host:port}/skills
```

**Synthesis categories**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Synthesis recipes**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. Image/File API

> [!NOTE]
> Due to Android storage restrictions, LifeUp Cloud may need to create a copied file when serving image content from LifeUp.

Function:

> Load image/file resources returned by data APIs (typically `content://...`).

Request URL:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Path parameters:**

| Field | Description | Location | Type | Required | Notes |
| --- | --- | --- | --- | --- | --- |
| url | File URL | Path | String | Yes | - |

**Request example:**

```txt
http://{host:port}/files/xxx
```

<br/>

## Contribution

The SDK, LifeUp Cloud, and LifeUp Desktop are all open-source projects.

You can get the source code at:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

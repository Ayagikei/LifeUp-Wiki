<h1 align="center" padding="100">LifeUp Cloud ☁️ </h1>
<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>
LifeUp Cloud is one of the fundamental API development kits.

It provides all the APIs as HTTP services, allowing you to call LifeUp's APIs or query data with any other programming tools or software (such as Python, web pages) **across devices without any Android development knowledge**.

LifeUp Desktop is an example application implemented based on LifeUp Cloud.

<br/>

## Download

- If you are a member of the mainland China version, you can find the download button of LifeUp Cloud on the `Sidebar` - `Settings` - `Experiments` page.
- [Google Play Store link](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>

## HTTP Interface Definition

⚠ The API definitions here may be out of date, please refer to our source code: [LifeUp-SDK/KtorService.kt at main · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)



### 1. URL Scheme API Calls

#### GET Method

Function:

> Used to call API starting with lifeup://api and communicate using Content Provider for better compatibility.

Request URL:

```
// Recommended content provider mechanism, better compatibility.
http://{host:port}/api

// Start activity mechanism, some devices may restrict the permission to display background UI, leading to failure to execute.
http://{host:port}/api/contentprovider
```

**Request method: GET**

**Request parameter:**

| Field | Description                        | Param | Field Type | Required | Notes                                                        |
| ----- | ---------------------------------- | ----- | ---------- | -------- | ------------------------------------------------------------ |
| url   | API URL starting with lifeup://api | Query | string     | Yes      | If manually concatenated, note to escape the URL. Multiple URLs are supported. |

**Request example:**

```
// Single call (content provider mechanism)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Batch call
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Single call (start activity mechanism)
http://{host:port}/ap
```

<br/>

#### POST Method

Function:

> Used to call the API starting with `lifeup://api`.

Request URL:

```
// Content provider mechanism, recommended for better compatibility
http://{host:port}/api

// start activity mechanism, may be limited by some devices in displaying background interfaces, causing execution failure.
http://{host:port}/api/contentprovider
```

**Request Method: POST**

**JSON BODY Request Parameters:**

| Field | Description                                   | Param | Field Type   | Required | Notes |
| ----- | --------------------------------------------- | ----- | ------------ | -------- | ----- |
| urls  | Array of API URL starting with `lifeup://api` | Body  | List<string> | Yes      | -     |

**Request Example:**

```
// POST
http://{host:port}/api/contentprovider

// json request body param:
{
	"urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. Data list query interface

**⚠Note:**

1. You need version v1.91 of  LifeUp and the latest version of "LifeUp Cloud".
2. You need to apply for "Read LifeUp Data" permission in "LifeUp Cloud" first.

Function:

> Query the complete data in "LifeUp", such as task list, item list.

Request URL:

**Tasks**

```
// All tasks
http://{host:port}/tasks

// Tasks in the specified list ${id}
http://{host:port}/tasks/${id}

// History (supports pagination)
http://{host:port}/history?offset=${offset}&limit=${limit}

// Task list
http://{host:port}/tasks_categories
```

**Items**

```
// All items
http://{host:port}/items

// Items in the specified list ${id}
http://{host:port}/items/${id}

// Item list
http://{host:port}/items_categories
```

**Achievements**

```
// All achievements
http://{host:port}/achievements

// Achievements in the specified list ${id}
http://{host:port}/achievements/${id}

// Achievement list
http://{host:port}/achievement_categories
```

**Feelings**

```
// All feelings (supports pagination)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Synthesis Categories**

```
// All synthesis categories
http://{host:port}/synthesis_categories

// Synthesis categories in the specified list ${id}
http://{host:port}/synthesis_categories/${id}
```

**Synthesis Recipes**

```
// All synthesis recipes
http://{host:port}/synthesis

// Synthesis recipes in the specified category ${id}
http://{host:port}/synthesis/${id}
```

**Attributes**

```
// All attributes
http://{host:port}/skills
```

**Request method: GET**

**Request parameter description:**

| Field  | Description           | Param | Field Type | Required | Notes                                       |
| ------ | --------------------- | ----- | ---------- | -------- | ------------------------------------------- |
| id     | Corresponding data ID | Query | Number     | Yes      | -                                           |
| offset | Query offset          | Query | Number     | No       | Currently required only for some interfaces |
| limit  | Limit number          | Query | Number     | No       | Currently required only for some interfaces |
| filterGid | Filter for repeating task history            | Query | Number     | No       | Optional parameter for history query        |

**Request example:**

**Task**

```
// All tasks
http://{host:port}/tasks

// Tasks in list id 1
http://{host:port}/tasks/1

// History (supports pagination), query 100 records starting from index 0
http://{host:port}/history?offset=0&limit=100

// Task list
http://{host:port}/tasks_categories
```

**Item**

```
// All items
http://{host:port}/items

// Items in list id 1
http://{host:port}/items/1

// Item list
http://{host:port}/items_categories
```

**Achievement**

```
// All achievements
http://{host:port}/achievements

// Achievements in the specified list ${id}
http://{host:port}/achievements/${id}

// Achievement list
http://{host:port}/achievement_categories
```

**Feeling**

```
// All feelings (supports pagination), query 100 records starting from index 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attributes**

```
// All attributes
http://{host:port}/skills
```


**Synthesis Categories**

```
// All synthesis categories
http://{host:port}/synthesis_categories

// Synthesis categories in list 1
http://{host:port}/synthesis_categories/1
```

**Synthesis Recipes**

```
// All synthesis recipes
http://{host:port}/synthesis

// Synthesis recipes in category 1
http://{host:port}/synthesis/1
```

<br/>

### 3. Get Image API

**⚠ Note:**

1. Due to Android's storage restrictions, calling this interface will require "LifeUp Cloud" to make a copy of the image from "LifeUp".

Function:

> Load the image returned by the above interface (usually in the form of content://)

Request URL:

```
http://{host:port}/files/${url}
```

**Request method: GET**

**Request parameter description:**

| Field | Description | Param | Field Type | Required | Notes |
| ----- | ----------- | ----- | ---------- | -------- | ----- |
| url   | File URL    | Path  | String     | Yes      | -     |

**Request Example:**

```
http://{host:port}/files/xxx
```

<br/>

## Contribution

The SDK, "LifeUp Cloud", and "Desktop" are all open-source projects.

You can obtain the source code and run it using IDEA at the following links:

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

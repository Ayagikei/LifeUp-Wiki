<h1 align="center" padding="100">云人升 ☁️ </h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

《云人升》是 API 开发的基础套件之一。

它能够：

- **支持解析二维码 API 并跳转**

  比如实现通过二维码完成任务、添加任务、跳转购买商品弹窗等。

  示例：[扫码也能购买「人升」商品、接受任务、完成任务、获取惩罚等等...？ (qq.com)](https://mp.weixin.qq.com/s/PafJnyce32ipZN52GxUj8w)

- **提供 HTTP 服务**

  所有 API 以 HTTP 服务的形式提供出来，使得你**无需任何安卓开发知识，就能以跨设备地以任何其他编程工具或者软件（比如 Python、网页）调用《人升》的 API 调用或者查询数据**。

  示例：

  - 《人升-桌面端》就是一个基于《云人升》实现的实例应用。
  - [使用《云人升》实现跨设备联动：根据记笔记行为奖励经验值（用户分享） (qq.com)](https://mp.weixin.qq.com/s/ylJEwZbr9QUuQ7e5z-sBLQ)

<br/>

## 下载

- 如果你是中国大陆版本的会员的话，可以在`侧边栏`-`设置`-`实验`页面找到《云人升》的下载按钮。
- [Google Play 商店地址](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>

## 二维码扫描

你只需将`lifeup://api/`开头的 URL 生成为二维码图片即可扫码使用。

<br/>

## HTTP 接口定义

⚠ 这里的接口定义更新可能会有滞后性，以我们的源码为准：[LifeUp-SDK/KtorService.kt at main · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme 调用接口

#### GET 形式

接口功能：

> 用于调用 lifeup://api 开头的 API。

接口请求地址：

```
// 【推荐】content provider 机制，兼容性更好
http://{host:port}/api/contentprovider

// start activity 机制，部分设备可能会限制后台显示界面权限，导致无法执行
http://{host:port}/api
```

**请求方式：GET**

**请求参数说明：**

| 字段名 | 字段说明                    | 位置  | 字段类型 | 是否必填 | 备注                                                 |
| ------ | --------------------------- | ----- | -------- | -------- | ---------------------------------------------------- |
| url    | lifeup://api 开头的 API URL | Query | string   | 是       | 如果是手动拼接的话，URL 注意转义。支持拼接多个 url。 |

**请求实例：**

```url
// 单一调用（content 
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// 批量调用
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// 单一调用（start activity形式）
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST 形式

接口功能：

> 用于调用 lifeup://api 开头的 API。

接口请求地址：

```
// 【推荐】content provider 机制，兼容性更好
http://{host:port}/api/contentprovider

// start activity 机制，部分设备可能会限制后台显示界面权限，导致无法执行
http://{host:port}/api
```

**请求方式：POST**

**JSON BODY 请求参数说明：**

| 字段名 | 字段说明                         | 位置 | 字段类型     | 是否必填 | 备注       |
| ------ | -------------------------------- | ---- | ------------ | -------- | ---------- |
| urls   | lifeup://api 开头的 API URL 数组 | Body | List<string> | 是       | 不需要转义 |

**请求实例：**

```
// POST
http://{host:port}/api/contentprovider

// BODY 参数
{
	"urls": ["lifeup://api/goto?page=lab"]
}
```

### 2. 数据列表查询接口

**⚠注意：**

1. 你需要 v1.91 版本的《人升》和最新版的《云人升》。
2. 你需要先在《云人升》中申请“读取人升数据”权限。

接口功能：

> 查询《人升》中的完整数据，如任务列表、商品列表

接口请求地址：

**任务相关**

```
// 所有任务
http://{host:port}/tasks

// 指定清单${id}里面的任务
http://{host:port}/tasks/${id}

// 历史记录（支持分页查询）
// filterGid 可选，可用于过滤某个重复任务的所有历史记录
http://{host:port}/history?offset=${offset}&limit=${limit}&filterGid=${filterGid}


// 任务清单
http://{host:port}/tasks_categories
```

**商品相关**

```
// 所有商品
http://{host:port}/items

// 查询指定 id 为 1、4 的商品
http://{host:port}/items?id=1&id=4

// 指定清单${id}里面的商品
http://{host:port}/items/${id}

// 商品清单
http://{host:port}/items_categories
```

**成就相关**

```
// ~~所有成就（app 实际上尚未实现该路径，我们会评估后续版本增加或者移除，截止 v1.100.4）~~
// ~~http://{host:port}/achievements~~

// 指定清单${id}里面的成就（只支持指定清单 id 进行查询，建议搭配查询成就清单 api 使用）
http://{host:port}/achievements/${id}

// 成就清单
http://{host:port}/achievement_categories
```

**感想**

```
// 所有感想（分页查询）
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**合成清单**

```
// 所有合成清单
http://{host:port}/synthesis_categories

// 指定清单${id}里面的合成清单
http://{host:port}/synthesis_categories/${id}
```

**合成配方**

```
// 所有合成配方
http://{host:port}/synthesis

// 指定清单${id}里面的合成配方
http://{host:port}/synthesis/${id}
```

**属性**

```
// 所有属性
http://{host:port}/skills
```

**请求方式：GET**

**请求参数说明：**

| 字段名 | 字段说明     | 位置  | 字段类型 | 是否必填 | 备注               |
| ------ | ------------ | ----- | -------- | -------- | ------------------ |
| id     | 对应的数据id | Query | 数字     | 是       | -                  |
| offset | 查询偏移量   | Query | 数字     | 否       | 目前仅部分接口需要 |
| limit  | 限制数量     | Query | 数字     | 否       | 目前仅部分接口需要 |
| filterGid  | 筛选重复任务历史记录         | Query  | 数字     | 否       | 历史记录查询的可选参数 |

**请求实例：**


**任务相关**

```
// 所有任务
http://{host:port}/tasks

// 指定清单id 1 里面的任务
http://{host:port}/tasks/1

// 历史记录（支持分页查询），查询第0位开始的 100 条
http://{host:port}/history?offset=0&limit=100

// 任务清单
http://{host:port}/tasks_categories
```

**商品相关**

```
// 所有商品
http://{host:port}/items

// 指定清单id 1 里面的商品
http://{host:port}/items/1

// 商品清单
http://{host:port}/items_categories
```

**成就相关**

```
// ~~所有成就（app 实际上尚未实现该路径，我们会评估后续版本增加或者移除，截止 v1.100.4）~~
// ~~http://{host:port}/achievements~~

// 指定清单${id}里面的成就（只支持指定清单 id 进行查询，建议搭配查询成就清单 api 使用）
http://{host:port}/achievements/${id}

// 成就清单
http://{host:port}/achievement_categories
```

**感想**

```
// 所有感想（分页查询），查询第0位开始的 100 条
http://{host:port}/feelings?offset=0&limit=100
```

**属性**

```
// 所有属性
http://{host:port}/skills
```

**合成清单**

```awk
// 所有合成清单
http://{host:port}/synthesis_categories

// 指定清单id 1 里面的合成清单
http://{host:port}/synthesis_categories/1
```

**合成配方**

```awk
// 所有合成配方
http://{host:port}/synthesis

// 指定清单id 1 里面的合成配方
http://{host:port}/synthesis/1
```

<br/>

### 3. 获取图片接口

**⚠注意：**

1. 由于安卓的存储限制，调用该接口会需要《云人升》从《人升》复制一份图片副本。

接口功能：

> 加载上述接口中返回的图片（一般为 content:// 样式）

接口请求地址：

```
http://{host:port}/files/${url}
```

**请求方式：GET**

**请求参数说明：**

| 字段名 | 字段说明 | 位置 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | ---- | -------- | -------- | ---- |
| url    | 文件URL  | Path | 字符串   | 是       | -    |

**请求实例：**

```
http://{host:port}/files/xxx
```

<br/>

## 贡献

SDK、《云人升》、《桌面端》皆为开源项目。

你可以在以下链接获取到源码并使用 IDEA 运行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

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

  所有 API 都以 HTTP 服务形式提供，使你**无需 Android 开发知识，也能跨设备使用其他编程工具或软件（如 Python、网页）调用《人升》API 或查询数据**。

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

⚠ 本页接口定义可能滞后，最终请以源码为准：[LifeUp-SDK/KtorService.kt at main · Ayagikei/LifeUp-SDK (github.com)](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

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
| url    | `lifeup://api` 开头的 API URL | Query | string   | 是       | 手动拼接时请注意 URL 转义。支持多个 `url` 参数。 |

**请求实例：**

```url
// 单一调用（content provider 形式）
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

**⚠ 注意：**

1. 你需要 v1.91 版本的《人升》和最新版的《云人升》。
2. 你需要先在《云人升》中申请“读取人升数据”权限。

接口功能：

> 查询《人升》中的完整数据，例如任务列表、商品列表。

接口请求地址：

**任务相关**

```
// 所有任务
http://{host:port}/tasks

// 指定清单${id}里面的任务
http://{host:port}/tasks/${id}

// 历史记录（支持分页查询）
// gid 可选，可用于过滤某个重复任务的所有历史记录
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}


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

// 包含隐藏清单
http://{host:port}/items_categories?include_hidden=true
```

**成就相关**

```
// 所有成就
http://{host:port}/achievements

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

**其它**

```
// 金币余额
http://{host:port}/coin

// 人升 / 云人升版本
http://{host:port}/info

// 番茄钟记录（分页；可选时间范围）
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Journals (paged; optional time range). Soft-deleted rows omitted.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}

// 全部成就（Cloud 已实现，不再需要清单 id）
http://{host:port}/achievements

// 广播事件（人升需打开「实验 / 广播事件」）
http://{host:port}/events?after=${id}&limit=50

// WebSocket 推送（云人升高级设置打开「WebSocket 事件推送」；可与 GET 同时用）
ws://{host:port}/events?after=${id}
```

统一响应：`{ code, message, data }`。`code=200` 只表示传输成功。`10001` 人升未开或未授读取；`10002` ContentProvider 查询失败。

### 列表字段取值

ContentProvider / Cloud JSON 字段名与下表一致。

| 接口 | 字段 | 取值 |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` 未完成 · `1` 已完成 · `2` 逾期 · `3` 放弃 |
| `/tasks` | `frequency` | `0` 一次 · `1` 每日 · `N>1` 每 N 天 · `-1` 无限制 · `-3` 艾宾浩斯 · `-4` 每月 · `-5` 每年 |
| `/tasks_categories` | `status` | `0` 正常 · `1` 已归档 |
| `/tasks_categories` | `type` | `<10` 普通清单 · `10` 每日 · `11` 每周 · `12` 每月 · `20` 进行中 |
| `/achievements` | `status` | `0` 未解锁 · `1` 已解锁未领奖 · `2` 已解锁已领奖 |
| `/achievements` | `type` | `0` 普通 · `1` 子分类 |
| `/achievement_categories` | `type` | `0` 用户 · `1` 系统 |
| `/feelings` | `type` | `0` 任务 · `1` 成就 · `2` 纯文本 · `3` 使用物品 |
| `/feelings` | `isFav` | `true`/`false`（Provider 里是 0/1） |
| `/skills` | `type` | `0` 用户属性 · `1` 力量 · `2` 学识 · `3` 魅力 · `4` 耐力 · `5` 活力 · `6` 创造 |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` 显示 · `1` 隐藏（两列独立） |
| `/synthesis_categories` | `hidden` | `0` 显示 · `1` 隐藏 |
| `/pomodoro_records` | `reward` | `0` 放弃 · `0.5×倍数` 半程 · 否则为倍数 |
| `/coin_records` `/inventory_records` | `resCode` | 商店：`0` 买 · `1` 用 · `2` 完成任务 · `3` 撤销完成 · `4` 清数据 · `5` 放弃 · `6` 过期 · `7` 解锁成就 · `8` 撤销放弃 · `9` 撤销过期 · `10` 退货 · `11` 完成子任务 · `12` 撤销子任务 · `13` 解锁用户成就 · `14` 撤销用户成就 · `15` 存款 · `16` 取款 · `17` 卖番茄 · `20` 奖励物品 · `21` 撤销奖励物品 · `23` 合成 · `24` 开箱 · `25` ATM 利息 · `26` 番茄换物品 · `27` 贷款利息 · `28` API · `29` 效果改库存 |
| `/exp_records` | `resCode` | 经验（不是商店 `28`）：`0` 未知 · `1` 完成 · `2` 成就 · `3` 点赞兑换 · `4` 连续使用 · `5` 步数 · `6` 设为完成 · `7` 撤销放弃 · `8` 撤销过期 · `9` 吃番茄 · `10` 用物品 · `11` 解锁用户成就 · `12` 完成子任务 · `200` API · `101` 撤销完成 · `102` 放弃 · `103` 过期 · `104` 用物品扣经验 · `105` 锁定用户成就 · `106` 撤销子任务 |

`GET /items_categories`、`GET /synthesis_categories`、`GET /skill_groups` 支持 `include_hidden=true`（默认不列出隐藏项）。解锁条件：`GET /achievement_conditions/{id}`。技能 `status`（0 正常 / 1 隐藏）只出现在 `query`/`query_skill`，**不在** `GET /skills`。

**请求方式：GET**

**请求参数说明：**

| 字段名 | 字段说明     | 位置  | 字段类型 | 是否必填 | 备注               |
| ------ | ------------ | ----- | -------- | -------- | ------------------ |
| id     | 对应的数据 ID | Query | 数字     | 是       | -                  |
| offset | 查询偏移量   | Query | 数字     | 否       | 目前仅部分接口需要 |
| limit  | 限制数量     | Query | 数字     | 否       | 目前仅部分接口需要 |
| gid | 筛选重复任务历史记录 | Query | 数字 | 否 | 历史记录查询可选参数 |
| include_hidden | 是否包含隐藏清单 | Query | 布尔 | 否 | 默认 false。用于 `/items_categories`、`/synthesis_categories`、`/skill_groups` |

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
// 所有成就
http://{host:port}/achievements

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

**⚠ 注意：**

1. 由于安卓的存储限制，调用该接口会需要《云人升》从《人升》复制一份图片副本。

接口功能：

> 加载上述接口返回的图片（通常为 `content://` 形式）。

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

### 4. 技能 ContentProvider 查询

**⚠ 注意：**
需要 v1.103.0+

如果需要列表或结构化查询，可以通过 `http://{host:port}/api/contentprovider` 接口读取以下 ContentProvider URI：

#### `content://net.sarasarasa.lifeup.provider.api/skills`

仅返回当前可见的技能。

| 列名 | 含义 | 取值 | 备注 |
| ---- | ---- | ---- | ---- |
| _ID | 技能ID | 数字 | - |
| name | 技能名称 | 字符串 | - |
| desc | 描述 | 字符串 | 可能为空 |
| icon | 图标 URI | 字符串 | 可能为空 |
| order | 原始排序值 | 数字 | `orderInCategory` |
| group_id | 技能组ID | 数字 / null | 未分组时可能为空 |
| color | 颜色 | 数字 / null | 可能为空 |
| exp | 经验值 | 数字 | - |
| level | 当前等级 | 数字 | - |
| until_next_level_exp | 升到下一级所需经验值 | 数字 | - |
| current_level_exp | 当前等级内已获得经验值 | 数字 | - |
| type | 技能类型 | 数字 | - |
| status | 技能状态 | 数字 | `0` = 正常，`1` = 隐藏 |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

仅返回当前可见的技能组。

| 列名 | 含义 | 取值 | 备注 |
| ---- | ---- | ---- | ---- |
| _ID | 技能组ID | 数字 | - |
| content | 技能组名称 | 字符串 | - |
| order | 原始排序值 | 数字 | `orderInCategory` |
| collapsed | 折叠状态 | 字符串 | 以 `true` / `false` 文本返回 |

<br/>

## 贡献

SDK、《云人升》、《桌面端》皆为开源项目。

你可以在以下链接获取到源码并使用 IDEA 运行：

- [Ayagikei/LifeUp-SDK: Provide LifeUp SDK, and expose LifeUp APIs as HTTP services! (github.com)](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop (github.com)](https://github.com/Ayagikei/LifeUp-Desktop)

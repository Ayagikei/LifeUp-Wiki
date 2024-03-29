# 2021 年 6 月- 2022 年 10 月开发计划

!> 这是一份过期的开发计划，仅作为归档和参考资料。环境持续变化，我们的计划也会随之调整。该计划大体上指明了我们的发展方向，但我们并不承诺完全按照计划执行，同时也可能进行计划之外的开发。

> 本文更新于2021年6月23号

## 功能完善级别

**待办事项 Level 5**

现有功能：

> **Level 1:** 提醒（通知）、重复、期限、目标次数、无限重复、历史
>
> **Level 2:** 清单管理、艾宾浩斯、计数、桌面小部件
>
> **Level 3:** 子任务、附件、日历
>
> **Level 4:** 详情、统计、列表操作（复制、冻结）
>
> **Level 5:** 简洁模式、智能清单

目标：

> **Level 6所需:** 重新设计桌面小部件、闹钟提醒（待定）、UI代码重构

<br />

**属性机制 Level 2**

现有功能：

> **Level 1:** 6种属性定义、图标、经验值奖励、等级体现
>
> **Level 2:** 与成就联动（达到指定等级解锁成就）、 统一图标风格

目标：

> **Level 3:** 初版技能系统实现增删功能、称号系统

<br />

**商品机制 Level 5**

现有功能：

> **Level 1:** 商品、仓库、与事项联动（完成奖励商品）
>
> **Level 2:** 商店清单管理、库存数量、自定义文案（会员）
>
> **Level 3:** ATM、仓库清单管理、统计
>
> **Level 4:** 第一版使用效果、购买限制；与成就联动（购买、使用达到次数）
>
> **Level 5:** 合成系统

目标：

> **Level 6:** 打折（待定）

<br />

**成就机制 Level 4**

现有功能：

> **Level 1:** 粗糙的成就设定、解锁动画效果
>
> **Level 2:** 内置56种精心设计的系统成就
>
> **Level 3:** 初版自定义成就
>
> **Level 4:** 自定义成就可定义解锁条件，实现自动解锁。且支持设置各种奖励。

目标：

> **Level 5:** 支持多种条件设置；完善更多类型的条件

<br />

**世界模块 Level 3**

现有功能：

> **Level 1:** 初版团队、时刻、排行榜；用户关注系统
>
> **Level 2:** 团队支持多时区；团队支持金币等设置；时刻支持筛选；团队搜索等。
>
> **Level 3:** 橱窗功能；橱窗搜索；用户搜索；因资源问题砍掉排行榜。

目标：

> **Level 4:** 世界Tag
>
> **Level 5:** 团队2.0

<br />

**感想 Level 2**

现有功能：

> **Level 1:** 初版感想，支持发表文本和图片
>
> **Level 2:** 支持筛选、收藏、过滤等功能；支持从事项详情跳转过滤列表

目标：

> **Level 3:** 待定

<br/>

**番茄钟 Level 2**

现有功能：

> **Level 1:** 初版番茄钟，带有游戏化卖出、吃掉功能，且支持自定义时长和间隔
>
> **Level 2:** 计时统计、奖励设置、振动设置、快捷方式、无提醒文档等

目标：

> **Level 3:** 更完善的统计；支持正计时；支持自动继续下一次休息或番茄（待定）；支持横屏显示。

<br />

**系统机制 Level 3**

现有功能：

> **Level 1:** 事项设置、桌面小部件及设置
>
> **Level 2:** 主题色、备份与恢复机制（文件）、多语言、日期格式、24小时制、相对时间、夜间模式
>
> **Level 3:** WebDAV备份、DropBox备份、备份忽略媒体文件、底部导航栏配置、本地自动备份、数据清除、应用内指引、关于页面重新设计

目标：

> **Level 4:** 媒体文件管理、Google Drive备份、数据清除完善、指引完善

<br />

---


## 开发计划

### 超短期（接下来的几个版本）

1. <del>优化选择图片时的图片加载效果，卡顿优化</del>
2. <del>自定义成就的奖励可以设置经验值</del>
3. 本地自动备份（与云自动备份有一定区别）
4. <del>普通奖励商品的使用效果</del>
5. <del>按清单显示</del>
6. <del>详情显示感想列表</del>（支持筛选，算是完成一半）

---



### 短期（1.8x系列版本）

#### <del>1. 专门的合成系统</del>（v1.83.x版本发布）

目前的商品使用效果中的「合成」功能仅支持多件A合成一件B，支持范围有限。

并且作为“使用效果”的方式进行呈现，在此基础上已经不能扩展实现。



**所以，计划推出专门的合成系统。自由设置合成配方，任意实现多对多的合成功能。**

**并且，基于该功能，用户可以实现自己的多货币体系。**



#### <del>2. 世界TAG功能</del>（已发布）

团队、商品实现TAG分类效果。

如团队可以按属性筛选，按运动、学习等等类型进行筛选。



#### 3. 每日/周/月总结，统计优化迭代（UI设计搁置，延后处理）

完善应用内部各种统计功能



#### <del>4. 自定义底部模块</del>（v1.83.x版本发布）



#### <del>5. 技能系统</del>（已发布）

为了弥补当前属性不能增删的缺点，开发另一套完全支持自定义的体系。



#### <del>6. 称号系统</del>（需求不明确，UI设计搁置）



#### <del>7. 时间监测（待命名）</del>

用户自定义将应用划分为「积极」、「消极」两类，使用积极应用达到一定时间获得奖励，使用消极应用达到一定时间进行惩罚。



#### 8. 老代码重构和设计（部分完成，持续进行中）

- <del>新建事项页面</del>
- 桌面小部件
- 状态顶部卡片
- 详情页面



---




### 中期

#### 1. 体系分享

> 前提条件：开发文件上传功能

支持用户分享事项清单，与之关联的自定义成就清单、商品清单，以及自定义属性等。

分享方式支持直接导出压缩文件，或者直接分享到世界模块。

**已完成文件上传功能，但体系文件可能过大，存放在 OSS 可能需要占用大量开支，难以运营，搁置...**

---



### 长期

> 待补充

#### 1. 跨平台开发计划

使用Flutter实现多端开发，需要大量的技术知识储备。

代码迁移也有很大的工作量。

并且只有跨平台很难满足需求，一般还需要配合增量同步支持。



#### 2. 增量同步支持

受限于技术能力和服务器资源限制，目前看来在资本介入之前难以实现。



---



### 目前来看不可能的计划

>  待补充

#### 1. 与智能设备合作，实现AR效果

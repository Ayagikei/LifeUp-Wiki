# 备份与恢复

【在B站查看：《人升》2分钟配置坚果云实现云备份】 https://www.bilibili.com/video/BV1Yg411i7uM/?share_source=copy_web&vd_source=141b0b80de90aedb6b7f25458fa6b5d1

【在B站查看：《人升》一键导入存档数据（恢复）】 https://www.bilibili.com/video/BV1xP411u7dV/?share_source=copy_web&vd_source=141b0b80de90aedb6b7f25458fa6b5d1

[在微信公众号查看本文（含坚果云备份的设置视频教程）](https://mp.weixin.qq.com/s?__biz=MzI0OTQ4OTAxMQ==&mid=2247483867&idx=1&sn=d24068b74810d5b91b37c1abda436eca&chksm=e991f2c7dee67bd1ed49e74b3131bf7812c22f2a58a82cdac3c30182665296262a3c86a77b1d&mpshare=1&scene=23&srcid=1205mlIjJmwwyVugMJ7P25jM&sharer_sharetime=1639901809270&sharer_shareid=aefb2cf8bbd4980bf3f827f86feb6b04#rd)

## 快速导航

- [为什么需要备份](#why-backup)
- [怎么配置备份方式](#configure-backup)
- [怎么备份](#how-to-backup)
- [怎么恢复](#how-to-restore)
- [换新手机怎么迁移](#new-phone-migration)

## 为什么需要备份 :id=why-backup

### 1) 是否支持同步？

- ❌ 服务端直接同步数据（`人升`是离线存储应用）
- ❌ 增量同步
- ✔️ 使用自选 WebDAV 云服务 / Dropbox / Google Drive 进行云存储和同步
- ✔️ 跨设备**手动全量**同步

### 2) 为什么一定要配备份？

`人升`是离线优先应用，你的大部分个人数据默认保存在本地设备。

这意味着如果没有备份，在这些场景下容易丢失数据：

- 卸载应用
- 更换手机
- 手机损坏或丢失

**这跟你卸载微信会丢聊天记录，本质上是同一类问题。**

**也跟你换手机后，微信需要迁移数据才能保留聊天记录一样。**

> 只有团队、公开动态、会员等部分数据在云端。你的本地事项、属性、奖励配置等核心个人数据，仍依赖你主动备份。

> [!TIP]
> 如果你在中国大陆使用，建议优先用坚果云 WebDAV。<br/>如果你有稳定海外网络，也可以直接授权 Google Drive / Dropbox。

### 3) 备份包含哪些内容

备份会导出你的本地数据到压缩文件，包含但不限于：

- 待办事项内容和历史记录
- 商品、仓库、金币等记录
- 成就解锁记录、自定义成就
- 感想、合成、自定义属性、番茄记录
- 媒体文件（事项附件、商品图标、自定义背景、音效等）
- 选项配置

> [!NOTE]
> 勾选「忽略媒体文件」后，媒体资源不会被导出。

### 4) 方式对比（按简体中文用户习惯）

| 方法 | 卸载 | 手机损坏 | 自动备份 | 备注 |
| --- | --- | --- | --- | --- |
| 默认路径备份 | ❌ | ❌ | ❌ | 仅用于临时恢复 |
| 自定义路径备份 | ✔️ | ✔️（导出到外部介质时） | ❌ | 推荐作为手动备份方案 |
| 自动备份到“下载”文件夹（Android 10+） | ✔️ | ❌ | ✔️ | 可防误卸载，不防设备损坏 |
| WebDAV（推荐坚果云） | ✔️ | ✔️ | ✔️ | 大陆用户最实用 |
| Dropbox | ✔️ | ✔️ | ✔️ | 需要可访问 Dropbox 的网络 |
| Google Drive | ✔️ | ✔️ | ✔️ | 需要可访问 Google 服务的网络 |

## 怎么配置备份方式 :id=configure-backup

> [!IMPORTANT]
> 简体中文用户建议优先顺序：**坚果云 WebDAV > 本地自定义路径导出 > 其他云盘方案**。

<details>
<summary>配置坚果云 WebDAV（推荐，自动云备份）</summary>

![](_media/backup/01.jpg ': size=30%')

#### 1. 获取 WebDAV 地址、账号、密码

理论上任意支持 WebDAV 协议的服务都可以。国内主流推荐坚果云。

<details>
<summary>手机端获取 WebDAV 信息（含截图）</summary>

1. 安装并登录坚果云 APP。  
   ![](_media/backup/04.png ': size=50%')

2. 在坚果云 `设置` - `第三方应用管理` 中添加应用密码，应用名称可填 `人升`。  
   ![](_media/backup/05.png ': size=50%')

   <br/>

   ![](_media/backup/06.png ': size=50%')

   <br/>

   ![](_media/backup/07.png ': size=50%')

3. 添加成功后，记录 `服务器地址`、`账号`、`应用密码`。  
   ![](_media/backup/08.png ': size=50%')

</details>

<details>
<summary>网页端获取 WebDAV 信息（含截图）</summary>

1. 登录坚果云官网。
2. 点右上角用户名 -> `账号信息`。
3. 切换到安全选项。  
   ![](_media/backup/02.png ': size=50%')
4. 在 `第三方应用管理` 新增应用（如：人升）。
5. 点击 `生成密码`，保存 `服务器地址`、`账号`、`密码`。  
   ![](_media/backup/03.png ': size=50%')

</details>

#### 2. 在人升内填写配置

进入：`侧边栏 -> 设置 -> 数据备份/恢复/清除 -> WebDAV 配置`  
填入三项信息并测试连接，成功后即可使用 `备份至 WebDAV` 和 `自动云同步`。

![](_media/backup/09.png ': size=30%')

#### 3. 配置建议

- 备份文件大于 10MB 时，建议开启 `忽略媒体文件`。
- 同时可适当拉长 `自动备份间隔`，提升成功率并减少流量消耗。

</details>

<details>
<summary>导出到自定义路径（手动备份底线）</summary>

这个方案是最稳妥的手动备份底线，建议长期保留：

1. 在备份页点击 `备份`。
2. 选择 `自定义路径`。
3. 导出后把备份文件复制到电脑、U 盘、NAS 或网盘。

> [!WARNING]
> 不建议只把备份文件留在当前手机内，否则设备损坏时会和数据一起丢失。

</details>

<details>
<summary>授权 Google Drive / Dropbox（可选）</summary>

如果你有稳定海外网络，可以直接在备份页授权 Google Drive 或 Dropbox，并启用自动云备份。

</details>

## 怎么备份 :id=how-to-backup

### 日常推荐流程

1. 完成一次 WebDAV（坚果云）或 Google Drive / Dropbox 配置。
2. 启用 `自动云备份`，设置 `自动备份间隔`。
3. 手动执行一次备份，确认流程正常。
4. 定期查看“最近备份时间”提示。

### 关键节点再做一份本地导出

在以下场景，建议再额外导出一份到外部设备：

- 大版本更新前
- 刷机/恢复出厂前
- 换机前

## 怎么恢复 :id=how-to-restore

![](_media/backup/10.png ': size=30%')

<details>
<summary>从云端恢复数据（WebDAV / Dropbox / Google Drive）</summary>

- WebDAV：在新设备填回原来的 WebDAV 配置后，即可在恢复入口下载并恢复。
- Dropbox / Google Drive：在应用内重新授权后，直接恢复。

</details>

<details>
<summary>从本地备份文件恢复（自定义路径）</summary>

> [!TIP]
> 如果你安装了坚果云、Google Drive 等云盘 App，也可以先把备份文件下载到本机，再走自定义路径恢复。

1. 将备份文件传到目标手机。
2. 在应用内 `恢复 -> 自定义路径` 选择该文件。
3. 确认恢复（会覆盖当前本地数据）。

> [!WARNING]
> Android 10/11 对存储权限限制更严格。通过 QQ、微信、部分文件管理器选文件时，可能出现路径不可读导致恢复失败。

推荐：使用电脑整理文件后再导入，并优先放在易授权目录。

以下路径有概率因权限问题恢复失败：

- `文件存储根目录/Android` 下任意子路径
- `文件存储根目录/Download（下载）`
- `文件存储根目录/Download（下载）` 下任意子路径

</details>

<details>
<summary>迁移到新手机（系统迁移 / 备份迁移）</summary>

#### 方案 A：系统自带“手机迁移”（优先尝试）

部分品牌手机支持应用数据直迁（如同品牌迁移工具、系统克隆等）。

1. 先用系统迁移工具把应用和数据迁移到新手机。
2. 迁移后打开《人升》，检查事项、属性、商品等核心数据是否完整。
3. 即使迁移成功，也建议再立即做一次云备份或本地导出，作为新设备的第一份备份。

> [!TIP]
> 如果你使用的是同品牌设备，系统迁移通常是最快、最省事的方式。

#### 方案 B：通过备份文件或云备份迁移（通用）

1. 在旧手机先执行一次完整备份（推荐 WebDAV 云备份 + 本地自定义路径各一份）。
2. 新手机下载并登录《人升》。
3. 如果走云备份：先配置同一个 WebDAV / Dropbox / Google Drive 账号，再执行恢复。
4. 如果走文件备份：把备份文件传到新手机，在 `恢复 -> 自定义路径` 导入。
5. 恢复完成后，建议手动触发一次备份，确认新设备备份链路也正常。

> [!WARNING]
> 恢复会覆盖当前本地数据。新手机上如果已经录入了新内容，建议先导出一份再恢复。

</details>

<details>
<summary>从 QQ / 文件系统导入（视频教程）</summary>

<!-- tabs:start -->

#### **一键从 QQ 或者文件系统导入数据（推荐）**

需要《人升》v1.90.6 及以上。

<iframe src="//player.bilibili.com/player.html?aid=305504686&bvid=BV1xP411u7dV&cid=904969278&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

#### **Android 10 及更低版本**

<iframe src="//player.bilibili.com/player.html?aid=380415695&bvid=BV1PZ4y1S7ah&cid=479527125&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

#### **Android 11 及以上**

<iframe src="//player.bilibili.com/player.html?aid=250882869&bvid=BV1gv411g7ys&cid=419591550&page=1&autoplay=0" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" width="80%" height="600"> </iframe>

<!-- tabs:end -->

</details>

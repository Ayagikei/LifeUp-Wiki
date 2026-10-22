# HTTP API başvurusu :id=http-query-reference

LifeUp Cloud istek parametreleri ve tam HTTP yanıt modelleri için bu başvuruyu kullanın. Kurulum, yetkilendirme ve bağlantı adımları için [LifeUp Cloud](/guide/api_cloud) ile başlayın. Yeni işlem günlüğü uç noktaları LifeUp **1.106.0+** ve LifeUp Cloud **3.0.0+** gerektirir; yüklü sürümleri `/info` ile belirleyin. Bu başvuru geçerli kaynak kodu sözleşmelerini açıklar; belirli bir sürümde kullanılabilirliği kanıtlamaz.

## Arayüz dizini :id=interface-index

| Kaynak | Yöntemler ve yollar | Parametreler ve model |
| --- | --- | --- |
| Ortak kurallar | JSON yanıtları, yetkilendirme, önbellek koşulları, sayfalama | [Kurallar](#representations), [önbellek ve yetkilendirme](#auth-cache), [sayfalama](#pagination) |
| Görevler | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Sorgular](#get-tasks), [görev modeli](#task-fields), [kategoriler](#get-tasks-categories) |
| Görev geçmişi | `GET /history` | [Parametreler](#get-history), [zaman damgaları](#task-times), [günlük raporlar](#daily-report) |
| Eşyalar | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [Eşya ID'leri, kategori ID'leri ve tam modeller](#get-items) |
| Özellikler | `GET /skills`, `GET /skill_groups` | [Özellikler ve gruplar](#get-skills) |
| Başarılar | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Başarılar ve koşullar](#get-achievements) |
| Sentez | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Tarifler ve kategoriler](#get-synthesis) |
| Duygular | `GET /feelings` | [Sayfalı duygular](#get-feelings) |
| EXP / para | `GET /exp_records`, `GET /coin_records` | [İşlem günlüğü parametreleri ve modelleri](#reward-journals) |
| Diğer kayıtlar | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [envanter](#get-inventory-records), [adımlar](#get-step-records) |
| Seviyeler / istatistikler | `GET /level_defines`, `GET /statistics` | [Seviyeler](#get-level-defines), [istatistikler](#get-statistics) |
| Uygulama / bakiye | `GET /info`, `GET /coin` | [Sürüm bilgisi](#get-info), [para sonucu](#get-coin) |
| Eylem çağırma | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Çağrı köprüsü](#invoke-api); iş yöntemleri [URL Scheme kataloğunda](/guide/api) bulunur |
| Dosyalar / yedekler | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Dosyalar](#files-download), [yedek aktarımı](#files-backup) |
| Olaylar | `GET /events`, WebSocket `/events` | [Yoklama ve canlı olaylar](#get-events) |
| Açılış sayfası | `GET /` | JSON kaynağı değil, HTML tanıtımı. |

MCP ayrı bir istemci/araç gösterimi kullanır; [MCP farklarına](#mcp-differences) ve [MCP kılavuzuna](/guide/api_mcp) bakın.

## Aktarım ve gösterim :id=representations

| Arayüz | Gösterim | Önemli fark |
| --- | --- | --- |
| Cloud HTTP sorguları | `{code, message, data}` içinde sarmalanmış JSON | Aşağıdaki uç nokta başvuruları bu herkese açık JSON biçimini açıklar. |
| Android ContentProvider | `_ID` / `_GID` gibi, bazen JSON metni içeren Cursor sütunları | SDK ayrıştırıcısı bunları `id` / `gid` gibi HTTP alanlarına ve iç içe dizilere dönüştürür. Cursor sütun tanımlarını HTTP şeması olarak kullanmayın. |
| URL Scheme eylemleri | `lifeup://api/{method}` ve yönteme özgü parametreler/sonuçlar | HTTP okuma alanları camelCase kullanırken bile yazma parametreleri snake_case kullanabilir. |
| MCP liste araçları | Araca özgü zarf ve kompakt veya ayrıntılı kayıtlar | MCP sayfalaması ve çıktı alanları HTTP yanıt alanları değil, ek istemci davranışlarıdır. |

## Yanıt ve hatalar :id=response-errors

Ortak HTTP JSON sarmalayıcısı `HttpResponse<T>` biçimindedir:

| Alan | Tür | Anlamı |
| --- | --- | --- |
| `code` | integer | Başarılı sorguda `200`; `200` dışındaki değerler hata belirtir. Bu, HTTP durumundan ayrı bir gövde alanıdır. |
| `message` | string | Başarı durumunda genellikle `success`; aksi durumda hata açıklaması. |
| `data` | `T` or `null` | Başarıda uç noktaya özgü değer (dizi, nesne veya dize); hatada `null`. |

Başarıyla dönen boş liste örneği:

```json
{"code":200,"message":"success","data":[]}
```

İzin/sağlayıcı erişim hatasını gösteren örnek:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Sinyal | Nasıl ele alınır |
| --- | --- |
| HTTP `401` | Yapılandırılan Cloud token'ını doğrudan `Authorization` başlık değeri olarak gönderin. `Bearer` eklemeyin. |
| Gövde `code = 10001` | LifeUp'ın yüklü/çalışır durumda olduğunu ve Cloud'a Read LifeUp Data izni verildiğini kontrol edin. |
| Gövde `code = 10002` | ContentProvider sorgusu başarısız oldu; hata mesajını inceleyin. |
| Başarı belirtmeyen diğer durum/kod | Sorguyu boş sonuç olarak değil, başarısız olarak değerlendirin. |

**Hem** HTTP durumunu hem de gövdedeki `code` değerini kontrol edin. Bazı rota hataları yine HTTP `200` ile gövdede bir hata kodu kullanır. `/api/contentprovider` üzerinden yapılan eylemlerde ayrıca her `data[].result.api_result` kontrol edilmelidir; sarmalayıcının `code=200` değeri her eylemin başarılı olduğunu kanıtlamaz.

## Yetkilendirme ve koşullu okumalar :id=auth-cache

Cloud belirteci yapılandırıldığında tam ham değerini `Authorization` içinde gönderin; başına `Bearer` eklemeyin. Sunucu, WebSocket başlığı ayarlayamayan istemciler için de `token` sorgu parametresini kabul eder. Eksik veya yanlış belirteç HTTP `401` ve gövdede `code=401` üretir. Denetim; açılış sayfası, kaynaklar, köprü, dosyalar, yedek aktarımı ve olayları kapsar.

Başarılı JSON kaynak okumaları güçlü bir SHA-256 `ETag` ve `Cache-Control: private, no-cache` ekler. Bu; görev/geçmiş, eşya/kategori, özellik/grup, başarı/koşul, duygu, sentez/kategori, işlem günlüğü, seviye, istatistik, bilgi ve para kaynaklarına uygulanır. Çağrı köprüsüne, dosya aktarımına, yedek aktarımına veya olay akışları/yoklamasına uygulanmaz.

| İstek başlığı | Geçerli yanıt davranışı |
| --- | --- |
| `If-Match` | Eşleşmeyen sürüm HTTP `412` ile başarısız olur; `If-None-Match` öncesinde değerlendirilir. |
| `If-None-Match` | Eşleşen sürüm, ayrıştırılacak JSON gövdesi olmadan HTTP `304` döndürür. Önbellekteki başarılı gösterimi yeniden kullanın. |

Hata zarflarında kaynak sürümü başlığı yoktur. Koşullu okumalar kaynak isteği başınadır; sayfalar veya yollar arasında anlık görüntü ya da işlem oluşturmaz.

Tarayıcının çapraz kaynak istekleri `If-None-Match` kullanabilir. Geçerli CORS yapılandırması ön kontrolde `If-Match` izni vermez; uygulama değiştirilmeden tarayıcıdaki çapraz kaynak `If-Match` isteklerine güvenmeyin. Yerel istemciler tarayıcı CORS kurallarına tabi değildir.

## Ortak veri kuralları :id=data-conventions

| Kural | Açıklama |
| --- | --- |
| Zaman | Zaman damgası alanları Unix milisaniyesi kullanır. Takvim günü sınırları amaçlanan saat dilimine bağlıdır. Her alanın ayrıca kaynağa özgü anlamı vardır. |
| Kimlik | Görev `id` değeri bir görevi/döngüyü; görev `gid` değeri yinelenen döngüler boyunca grubu tanımlar. Kategori/liste kimliği ayrı bir kaynağı tanımlar. |
| Boş değerler | Eksik alan, `null`, `0`, `""` ve `[]` farklıdır. Her model gerçek varsayılan değer veya alan atlama davranışını belgeler. |
| Sayısal ID'ler | ID'ler işaretli 64 bit tamsayı olabilir; JavaScript Number her değeri tam olarak gösteremez. Büyük ID'leri uygun bir JSON ayrıştırıcısıyla koruyun. |
| Diziler ve nesneler | `items` ve `subTasks` gibi iç içe HTTP değerleri, JSON kodlanmış metin değil dizidir. |
| Durum ve neden kodları | İlgili kaynak için belgelenen enum'u kullanın. Görev durumu, başarı durumu ve işlem günlüğü neden kodları farklı alanlara aittir. |

`startTime`, `deadline` ve `endTime` için [görev zaman damgası tanımlarına](/guide/api-reference?id=task-times) bakın.

## Sayfalama ve filtreleme :id=pagination

Sayfalama her listenin özelliği değil, uç noktanın sunduğu bir yetenektir. Ham HTTP liste yanıtları `data: [...]` içerir; `total`, `count` veya `hasMore` **eklemez**.

| HTTP uç noktası | Sayfalama | Tarih aralığı | Diğer filtreler |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | Yok; tam dizi | Yok | Yolda isteğe bağlı kategori |
| `/history` | Sunucu tarafında `offset` / `limit` | Yok | İsteğe bağlı `gid` |
| `/feelings` | Sunucu tarafında `offset` / `limit` | Hayır | [Duygulara](#get-feelings) bakın |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | Sunucu tarafında `offset` / `limit` | `time_range_start` / `time_range_end` | Aşağıdaki ilgili uç nokta bölümlerine bakın |
| `/statistics` | Yok; tek nesne | `time_range_start` / `time_range_end` | Toplu sorgu |
| `/coin`, `/info` | Yok; tek nesne | Yok | Tekil kaynak sorgusu |

Sayfalı uç noktaların HTTP varsayılanları `offset=0` ve `limit=100` değerleridir. Ortak bir sayfalama döngüsü için negatif olmayan offset ve `1..100` aralığında sayfa boyutları kullanın. HTTP köprüsü MCP'nin `1..100` sınırını uygulamaz; alttaki sağlayıcılar başka sınırlar uygulayabilir. Her uç noktanın etkili sayfa boyutu ve doğrulama notlarına bakın.

[Zamana göre filtrelenmiş Pomodoro sınırlaması](#get-pomodoro-records) dışında, her başarılı sayfadan sonra `offset` değerini dönen kayıt sayısı kadar artırın. Bu sayı etkin sayfa boyutundan küçük olduğunda durun (`1..100` kullanıldığında istenen `limit`; zaman filtreli Pomodoro hariç). Sağlayıcının sınırladığı bir sayfayı son sayfa sanmayın. Sondan sonraki boş sayfa normaldir. Birden çok sayfa almak anlık görüntü oluşturmaz: sorgu sürerken kayıtlar değişebilir.

Güncel HTTP SDK, tarih sınırlarını yalnızca **ikisi de** tam sayı olarak ayrıştırılabildiğinde ve `start < end` olduğunda iletir. Tek, ayrıştırılamayan veya ters sıralı sınır, filtresiz sorguya yol açar; bunu yakalamak için hata dönmesine güvenmeyin. Göndermeden önce iki sınırı da doğrulayın. İşlem günlüğü başvurusu, uç noktalarının sınırları dahil etme davranışını açıklar.

## MCP farkları :id=mcp-differences

MCP liste araçları varsayılan olarak `limit=20` kullanır, bunu `1..100` aralığıyla sınırlar ve `offset` için en az `0` uygular. Geçmiş/işlem günlükleri gibi sunucuda sayfalanan kaynaklara sayfalama gönderir; görevler gibi kaynaklarda ise tam HTTP dizisini alıp yerel olarak dilimler. `items`, `count`, `hasMore` ve isteğe bağlı `total`, MCP zarfına aittir. `detail=false` ayrıca her kayıttan alanları kaldırır; tam HTTP modeli gerektiğinde `detail=true` kullanın.

## Kaynaklar ve sürüm kapsamı :id=api-common-sources

Bu başvurular güncel herkese açık SDK'yı ve karşılık gelen LifeUp sağlayıcısının davranışını açıklar. Örneklerde uydurma veriler kullanılır. Kaynak bağlantıları uygulama başvurusudur; yüklü belirli bir sürümün tüm alanları içerdiğinin kanıtı değildir: [HTTP rotaları](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [HTTP sarmalayıcısı](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [MCP sorgu eşlemesi](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).


## Görev ve geçmiş veri modelleri :id=task-history-models

Bu sayfa [görev/geçmiş sorgularının](/guide/api-reference?id=task-queries) döndürdüğü **HTTP JSON** biçimini tanımlar. Android Cursor sütunları ve URL Scheme eylem parametreleri farklı adlar ve gösterimler kullanabilir; [ortak kurallara](/guide/api-reference?id=representations) bakın.

SDK iki görünüm için tek bir serileştirilmiş `Task` sınıfı kullanır. Burada `Task`, `/tasks` görünümünü; `HistoryRecord`, `/history` görünümünü adlandırır. Bu adlar mevcut çıktıyı açıklar; başka bir API getirmez. Güncel Cloud serileştirmesi varsayılan değerleri ve `null` alanları içerir.

### Task / HistoryRecord alanları :id=task-fields

Aşağıdaki tüm alanlar güncel HTTP nesnesinde bulunur. Eksik sağlayıcı değerleri çoğunlukla listelenen varsayılanlara dönüştürülür; böyle bir değer kaynak verinin gerçekten o değeri içerdiğini kanıtlamaz.

| Alan | JSON türü | Anlamı / varsayılan değer |
| --- | --- | --- |
| `id` | integer or `null` | Bu görevin/döngünün kimliği. |
| `gid` | integer or `null` | Yinelenen döngüler arasında paylaşılan görev grubu kimliği. |
| `name` | string | Görev adı. Sağlayıcıda ad yoksa `ERROR: name is null` olur. |
| `notes` | string | Notlar; yoksa boş metin. |
| `status` | integer | Görev durumu; eksik değer varsayılan olarak `0` olur. Aşağıdaki durum tablosuna bakın. |
| `startTime` | integer | Milisaniye cinsinden yapılandırılmış başlangıç zamanı; SDK varsayılanı `0`. |
| `deadline` | integer | Milisaniye cinsinden son tarih; yoksa SDK varsayılanı `0`. |
| `remindTime` | integer | Milisaniye cinsinden hatırlatma zamanı; yoksa SDK varsayılanı `0`. |
| `frequency` | integer | Yineleme kodu; `0` bir kez, `1` günlük, `-1` sınırsız. Diğer yineleme modları [görev eylemlerinde](/guide/api) açıklanır. SDK varsayılanı `0`. |
| `weekdays` | string | Haftanın günleri seçimi; ör. `1,3,5` (pazartesi `1`, pazar `7`); verilmediğinde boştur ve geçmişte daima sabit boş yer tutucudur. |
| `importance` | integer veya `null` | Önem düzeyi `1`–`4` (artan); App görev aciliyet derecesine (`taskUrgencyDegree`) karşılık gelir. `GET /tasks` ve `GET /tasks/{categoryId}` üzerinde görev listesi ContentProvider sütunu sağladığında dolu; eksik veya NULL sütun SDK tarafından `null` okunur. Geçmiş ContentProvider bu sütunu döndürmez, bu yüzden `/history` burada `null` kullanır; App'in kayıtta aciliyet saklamadığı anlamına gelmez. |
| `difficulty` | integer veya `null` | Zorluk düzeyi `1`–`4` (artan); App görev zorluk derecesine (`taskDifficultyDegree`) karşılık gelir. `importance` ile aynı `/tasks` ve `/history` ContentProvider davranışı. |
| `exp` | integer | Yapılandırılmış EXP ödülü, işlem tutarı değil; varsayılan `0`. |
| `skillIds` | integer array | Ödülle ilişkili özellikler; kullanılamıyorsa boş dizi. |
| `coin` | integer | Yapılandırılmış coin ödülü; varsayılan `0`. |
| `coinVariable` | integer | Rastgele coin ödülü ayarı; varsayılan `0`. |
| `itemId` | integer | Eski biçimde ilk ödül öğesi kimliği; varsayılan `0`. Tam liste için `items` kullanın. |
| `itemAmount` | integer | Eski biçimde ilk ödül öğesi miktarı; varsayılan `0`. Bu HTTP adı sağlayıcının `itemCount` sütunundan farklıdır. |
| `words` | string | Tamamlama teşvik metni; yoksa boş. |
| `categoryId` | integer | Görev kategorisi/listesi kimliği; yoksa varsayılan `0`. |
| `order` | integer | Görev listesi sıralama değeri; sağlayıcı bu sütunu döndürmediğinden geçmişte sabit `0` yer tutucusudur. |
| `nameExtended` | string | Genişletilmiş görünen ad; sağlayıcı bu sütunu döndürmediğinden geçmişte sabit boş yer tutucudur. |
| `endTime` | integer | Geçmiş için kaydedilen bitiş zamanı. `/tasks` bunu `0` ile doldurur; [zaman anlamlarına](/guide/api-reference?id=task-times) bakın. |
| `items` | `RewardItem[]` | Öğe ödülleri; kullanılamıyorsa boş dizi. |
| `subTasks` | `SubTask[]` | İç içe alt görevler; kullanılamıyorsa boş dizi. |
| `countProgress` | `TaskCountProgress` or `null` | Varsa sayaç ilerlemesinin anlık görüntüsü; her iki görünümde de bulunabilir. |
| `repeatEndCondition` | `TaskRepeatEndCondition` or `null` | `/tasks` için yineleme bitiş kuralı; `/history` içinde daima `null`. |

### Görev durumu ve zaman damgaları :id=task-times

| `status` | Anlamı | Geçmişte `endTime` anlamı |
| --- | --- | --- |
| `0` | Tamamlanmamış | Tamamlama zamanı değildir; `/history` bunun yerine bitmiş kayıtları seçer. |
| `1` | Tamamlanmış | Kaydedilen tamamlama zamanı. |
| `2` | Gecikmiş | Kaydedilen gecikme zamanı. |
| `3` | Vazgeçilmiş | Kaydedilen vazgeçme zamanı. |

| Zaman alanı | Tanım |
| --- | --- |
| `startTime` | Görevin yapılandırılmış/planlanmış başlangıç zamanı; kullanıcının gerçekten çalışmaya başladığı zaman değil. |
| `deadline` | Planlanmış son tarih; kaydedilen bitiş zamanından ayrıdır. |
| `endTime` | Geçmişteki görevin bittiği kaydedilmiş zaman; yukarıdaki gibi `status` ile birlikte yorumlayın. |

Üçü de Unix milisaniyesi kullanır. Normal tamamlamada uygulama geçerli zamanı kaydeder. `operation=edit_completed_time` olan `history_operation`, `completed_time` girdisi alır ve aynı kaydedilmiş tamamlama zamanını düzenler; geçmiş okunurken alan adı yine `endTime` olarak döner.

Kaydedilmiş zamanlar düzenlenebilir. Bitmiş bir kaydın kaydedilmiş bitiş tarihi yoksa uygulama geçerli zamanı kullanır. Bu nedenle `endTime`, değiştirilemez bir denetim zaman damgası değil, şu anda kaydedilmiş zamandır. `/tasks` içindeki `0` yalnızca SDK yer tutucusudur; Unix başlangıcında gerçekleşmiş gerçek bir olay değildir.

### RewardItem :id=reward-item

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `itemId` | integer | Ödül öğesi kimliği. |
| `itemCount` | integer | Ödül miktarı. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Alan | JSON türü | Anlamı / varsayılan |
| --- | --- | --- |
| `id` | integer | Alt görev kimliği. |
| `gid` | integer | Alt görev grubu kimliği. |
| `todo` | string | Alt görev metni. |
| `status` | integer | `0` tamamlanmamış, `1` tamamlanmış. |
| `remindTime` | integer or `null` | Milisaniye cinsinden hatırlatma zaman damgası; kullanılamıyorsa `null`. |
| `endTime` | integer or `null` | Milisaniye cinsinden alt görev tamamlama zaman damgası; kullanılamıyorsa `null`. |
| `exp` | integer | Yapılandırılmış EXP ödülü. |
| `coin` | integer or `null` | Yapılandırılmış coin ödülü. |
| `coinVariable` | integer or `null` | Rastgele coin ödülü ayarı. |
| `items` | `RewardItem[]` | Öğe ödülleri; varsayılan boş dizi. |
| `order` | integer or `null` | Sıralama değeri; model varsayılanı `0`. |
| `autoUseItem` | boolean or `null` | Ödüllerin otomatik kullanılıp kullanılmayacağı; model varsayılanı `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `currentCount` | integer | Bu görev/döngü için geçerli sayaç değeri. |
| `targetCount` | integer | Bu görev/döngü için hedef sayaç değeri. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Alan | JSON türü | Anlamı / varsayılan |
| --- | --- | --- |
| `mode` | string | `COUNT` veya `DATE`. Bunlar okuma tarafındaki metinlerdir, sayısal eylem parametreleri değildir. |
| `behavior` | string | `TERMINATE` veya `FREEZE`. |
| `targetCycleCount` | integer or `null` | `COUNT` için hedef döngü sayısı; varsayılan `null`. |
| `endDateMillis` | integer or `null` | `DATE` için milisaniye cinsinden bitiş tarihi zaman damgası; varsayılan `null`. |
| `inclusive` | boolean | Bitiş tarihinin dahil edilme bayrağı; varsayılan `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Ödül tutarları :id=reward-amounts

Bu görev ve alt görev alanları yapılandırılmış ödülleri açıklar. Çarpanlar, rastgele coin miktarları ve hesaplaşma kuralları gerçek ödülü değiştirebilir. İşlem tutarları için [EXP ve coin işlem günlüklerini](/guide/api-reference?id=reward-journals) kullanın; pozitif ödüller ile geri almaları veya cezaları içeren net değişiklikleri ayırın.

### Uygulama kaynakları :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Ayrıştırıcı](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Sayaç ilerlemesi](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Yineleme kuralı](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).


## Görev ve geçmiş sorguları :id=task-queries

[Ortak kuralları](/guide/api-reference?id=http-query-reference) ve [tam Task/History modelini](/guide/api-reference?id=task-history-models) okuyun. Bu uç noktalar Cloud'un Read LifeUp Data iznini gerektirir. Temel liste sorguları, en güncel Cloud ile LifeUp v1.91+ için belgelenmiştir; örnekler güncel SDK alanlarını açıklar. Eski kurulumlarla entegrasyon yaparken `/info` kontrol edin.

### GET /tasks ve /tasks/{categoryId} :id=get-tasks

İsteğe bağlı olarak bir kategori/listeyle sınırlayarak geçerli **tamamlanmamış** görev listesini sorgulayın. Sonuç, sunucuda sayfalanmış yanıt değil, tam dizidir. Tamamlanmış, gecikmiş ve vazgeçilmiş kayıtlar `/history` içinde bulunur.

| Parametre | Konum | Tür | Zorunlu | Varsayılan / davranış |
| --- | --- | --- | --- | --- |
| `categoryId` | Yol | integer | Yalnızca `/tasks/{categoryId}` için | Sınırsız görev listesi için yolun bu bölümünü tamamen atlayın. |

Bu rotalarda `offset`, `limit`, `gid` veya tarih aralığı sorgu parametreleri desteklenmez. Tam sayı olmayan kategori bölümü şu anda kategori yokmuş gibi ayrıştırılır; yanlışlıkla tüm görevleri sorgulamamak için istekte bulunmadan önce doğrulayın.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Yanıt:** `HttpResponse<Task[]>`. Tüm kayıt alanları ve iç içe yapılar [Task/History alanlarında](/guide/api-reference?id=task-fields) tanımlanır. Aşağıdaki uydurma kayıt, HTTP'nin tam üst düzey yapısını gösterir; `endTime=0` bu rota için bir yer tutucudur, tamamlama zaman damgası değildir.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": 3, "difficulty": 2,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Davranış ve hatalar:** liste seçimi/sıralaması LifeUp'ın görev listesi mantığını izler; bu uç nokta tamamlama zamanına göre sıralama sözü vermez. Başarılı bir `data: []`, seçilen görev listesinin kayıt döndürmediği anlamına gelir. İzin/sağlayıcı hataları [ortak hata sarmalayıcısını](/guide/api-reference?id=response-errors) kullanır; boş dizi değildir. Tamamlama raporları için bu rotanın `endTime` alanı yerine aşağıdaki `/history` kullanın.

### GET /history :id=get-history

Tamamlanmış, gecikmiş ve vazgeçilmiş görevler dahil, görünür bitmiş görev kayıtlarını sorgulayın. Silinmiş geçmiş dahil edilmez.

| Parametre | Konum | Tür | Zorunlu | Varsayılan / davranış |
| --- | --- | --- | --- | --- |
| `offset` | Sorgu | integer | Hayır | `0`; sıfır tabanlı olarak atlanacak kayıt sayısı. |
| `limit` | Sorgu | integer | Hayır | `100`; tercihen `1..100` aralığında pozitif sayfa boyutu isteyin. |
| `gid` | Sorgu | integer | Hayır | Grup filtresi yok; verilirse döngüler boyunca o görev grubunu seçer. |

HTTP ayrıştırıcısı, ayrıştırılamayan `offset` / `limit` için `0` / `100` kullanır; ayrıştırılamayan `gid` değerini atar. Bu rota ayrıştırılan sayıları sınırlandırmaz. Negatif olmayan offset ve pozitif limit değerlerini kendiniz doğrulayın. `time_range_start` / `time_range_end` **desteklenmez**; bunları göndermek geçmişi filtrelemez.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Yanıt:** [Task/History aktarım alanlarını](/guide/api-reference?id=task-fields) kullanan `HttpResponse<HistoryRecord[]>`. `HistoryRecord`, SDK'nın `Task` modelinin geçmiş görünümü için belgede kullanılan addır. Bu görünümde `repeatEndCondition`, `null` olur; `countProgress` bulunabilir. Kaydedilmiş `endTime`, `status` ile birlikte yorumlanır.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": null, "difficulty": null,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Sıralama:** kaydedilmiş bitiş tarihine göre azalan, en yeni önce. Eşit bitiş tarihleri için belgelenmiş bir eşitlik bozma kuralı yoktur. Sayfalama sabit bir anlık görüntü değildir; rapor toplarken verileri düzenlemekten kaçının ve sayfaları birleştirirken kayıtları `id` ile tekilleştirin.

**Sayfalama ve boş sonuçlar:** [ortak sayfalama yöntemini](/guide/api-reference?id=pagination) kullanın. Başarılı boş dizi, `offset` sonu geçtiğinde de dahil olmak üzere bu sayfa/grupla eşleşen görünür kayıt olmadığı anlamına gelir. Hiç etkinlik yaşanmadığını kanıtlamaz: silinen kayıtlar dahil edilmez ve eksiksizlik bayrağı yoktur. Bir istek başarısız olursa sıfır görev yerine kullanılamayan/eksik veri bildirin. [Ortak hatalar](/guide/api-reference?id=response-errors) geçerlidir.

### Günlük rapor oluşturma :id=daily-report

1. Raporun saat dilimini seçin. Takvim gününün başlangıcını (`dayStart`) ve sonraki takvim gününün başlangıcını (`nextDayStart`) hesaplayın. Her yerel günün tam 24 saat olduğunu varsaymayın.
2. `/history` verisini `offset=0&limit=100` ile okuyun, her yanıtı kontrol edin ve tüm sayfaları toplayın. İstenen `gid` filtresini tutarlı tutun.
3. `status == 1` ve `dayStart <= endTime < nextDayStart` koşullarını seçin. Sonuçları açıklarken [kaydedilmiş zamanın sınırlamalarını](/guide/api-reference?id=task-times) dikkate alın.
4. Gerçek EXP ve coin değişiklikleri için aynı günün [ödül işlem günlüklerini](/guide/api-reference?id=reward-journals) okuyun. Tarih filtreleri iki ucu da dahil eder; bu nedenle `time_range_start=dayStart` ve `time_range_end=nextDayStart-1` kullanın.
5. “Kullanılabilir verilerde kayıt bulunamadı” ile başarısız/bitmemiş okumayı ayırın. Raporun yalnızca pozitif ödülleri mi yoksa geri almalar dahil net değişiklikleri mi göstereceğine karar verin ve bu seçimi tutarlı uygulayın.

Görev/geçmiş `exp` ve `coin` değerleri yapılandırılmış ödüllerdir; işlem günlüğündeki tutarların güvenilir bir karşılığı değildir. Tamamlama zamanının başka bir güne düzenlenmesi, ödül işlem günlüğünün işlem zamanının da değiştiği anlamına gelmez.

### Uygulama kaynakları :id=api-task-queries-sources

[HTTP rotaları](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Görev ve geçmiş ayrıştırması](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).


## EXP ve coin işlem günlüğü sorguları :id=reward-journals

Bu salt okunur HTTP uç noktaları Read LifeUp Data izni, LifeUp **1.106.0+** ve LifeUp Cloud **3.0.0+** gerektirir. Görev ödülü yapılandırması yerine azalmalar ve geri almalar dahil kaydedilmiş değişiklikleri döndürürler. Önce [ortak kuralları](/guide/api-reference?id=http-query-reference) okuyun.

### Her iki uç noktanın istek parametreleri :id=journal-parameters

Aşağıdaki sözleşme özellikle **hem** `GET /exp_records` **hem de** `GET /coin_records` için geçerlidir.

| Parametre | Konum | Tür | Zorunlu | Varsayılan / gerçek davranış |
| --- | --- | --- | --- | --- |
| `offset` | Sorgu | integer | Hayır | HTTP varsayılanı `0`; sağlayıcı negatif değerleri `0` yapar. |
| `limit` | Sorgu | integer | Hayır | HTTP varsayılanı `100`; sağlayıcı `1..200` aralığıyla sınırlar. Ortak sayfalama yöntemi için `1..100` kullanın. |
| `time_range_start` | Sorgu | integer (Unix milliseconds) | Hayır veya çift olarak | İşlemin kaydedilmiş zamanının dahil edilen alt sınırı. |
| `time_range_end` | Sorgu | integer (Unix milliseconds) | Hayır veya çift olarak | Dahil edilen üst sınır; geçerli filtreleme için `start < end` gerekir. |

Ayrıştırılamayan veya aralık dışındaki sayfalama değerleri HTTP varsayılanlarını kullanır. Ayrıştırılamayan tarih değerleri yok sayılır. Güncel SDK tarih aralığını yalnızca iki sınır da varsa ve `start < end` ise iletir; aksi halde **tarih filtresi olmadan** sorgular. Doğrudan ham ContentProvider çağrıları geçersiz aralıkları farklı doğrular. Sınırları HTTP çağrısını yapan tarafta doğrulayın.

Her iki uç nokta kaydedilmiş işlem zamanına göre azalan sırada, en yeni önce sıralar ve silinen işlem günlüğü girdilerini dahil etmez. Kimlikle eşitlik bozma veya birden fazla sayfada sabit anlık görüntü sözü vermez. Sağlayıcının etkili limitini dikkate alarak [sayfalamayı](/guide/api-reference?id=pagination) izleyin. Başarılı boş dizi seçilen aralık/sayfayla eşleşen girdi olmadığı anlamına gelir; başarısız okuma sıfır etkinlik değildir. Hiçbir uç nokta silinmiş veya kullanılamayan veriler için eksiksizlik bayrağı sağlamaz.

### GET /exp_records :id=get-exp-records

EXP değişikliklerini sorgulayın. Parametreler tam olarak [yukarıdaki dört işlem günlüğü parametresidir](/guide/api-reference?id=journal-parameters); `gid` filtresi yoktur.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Yanıt:** `HttpResponse<ExpRecord[]>`. Güncel serileştirme, null olabilen değerler dahil tüm listelenen alanları içerir.

| Alan | JSON türü | Anlamı / ayrıştırıcı varsayılanı |
| --- | --- | --- |
| `id` | integer or `null` | İşlem günlüğü girdisi kimliği. |
| `time` | integer or `null` | Unix milisaniyesi cinsinden işlem zamanı; düzenlenebilir görev tamamlama zamanından ayrıdır. |
| `value` | integer | İlişkili özellik başına EXP değişikliği; varsayılan `0`. Yön için `isDecrease` kullanın. |
| `isDecrease` | boolean | Azalma için `true`, artış için `false`; ayrıştırıcı sağlayıcının tam sayı `1` değerini true kabul eder. |
| `totalValue` | integer | Kaydedilmiş toplam EXP değişikliği, **EXP bakiyesi değildir**; varsayılan `0`. Birden fazla özellik içeren gruplar bu saklanan toplamda örtüşebilir; [rapor toplamlarına](/guide/api-reference?id=journal-totals) bakın. |
| `resCode` | integer | EXP'ye özgü neden kodu; varsayılan `0`. |
| `relatedId` | integer or `null` | İlişkili kaynak nesnenin kimliği. Normal görev tamamlamada görev kaydının `id` değeridir, `gid` değildir. Diğer nedenler başka kaynaklara başvurabilir. |
| `content` | string or `null` | Değişiklik açıklaması. |
| `skillIds` | integer array | İlişkili özellik/beceri kimlikleri; varsayılan boş dizi. |
| `relatedAttributes` | string array | Eski biçimde ilişkili özellik metinleri; varsayılan boş dizi. |

Uydurma örnek: iki özelliğin her birine 10 EXP, toplamda 20 EXP uygulanır.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Hatalar:** [ortak HTTP/sağlayıcı hataları](/guide/api-reference?id=response-errors). Yukarıda açıklandığı gibi geçersiz HTTP tarih sınırları hata üretmek yerine filtrelemeyi sessizce kaldırabilir.

### GET /coin_records :id=get-coin-records

Coin değişikliklerini sorgulayın. Parametreler tam olarak [yukarıdaki dört işlem günlüğü parametresidir](/guide/api-reference?id=journal-parameters); `gid` filtresi yoktur.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Yanıt:** `HttpResponse<CoinRecord[]>`. Güncel serileştirme, null olabilen değerler dahil tüm listelenen alanları içerir.

| Alan | JSON türü | Anlamı / ayrıştırıcı varsayılanı |
| --- | --- | --- |
| `id` | integer or `null` | İşlem günlüğü girdisi kimliği. |
| `time` | integer or `null` | Unix milisaniyesi cinsinden işlem zamanı. |
| `value` | integer | Coin değişiklik tutarı; varsayılan `0`. Yön için `isDecrease` kullanın. |
| `isDecrease` | boolean | Azalma için `true`, artış için `false`; ayrıştırıcı sağlayıcının tam sayı `1` değerini true kabul eder. |
| `totalValue` | integer | İşlem sonrası coin bakiyesi; varsayılan `0`. EXP `totalValue` değerinden farklı olarak bu bir bakiyedir. |
| `resCode` | integer | Coin'e özgü neden kodu; varsayılan `0`. |
| `relatedId` | integer or `null` | İlişkili kaynak nesnenin kimliği; normal görev tamamlama, görev kaydının `id` değerini kullanır. Diğer kaynakları neden koduyla yorumlayın. |
| `content` | string or `null` | Değişiklik açıklaması. |
| `savingBalance` | integer or `null` | İşlem için kaydedilmiş birikim bakiyesi. |

Uydurma örnek: 5 coin azalma, kalan coin bakiyesi 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Hatalar:** [ortak HTTP/sağlayıcı hataları](/guide/api-reference?id=response-errors). Yukarıda açıklandığı gibi geçersiz HTTP tarih sınırları hata üretmek yerine filtrelemeyi sessizce kaldırabilir.

### Neden kodları ve rapor toplamları :id=journal-totals

Neden kodlarının alanları farklıdır. Seçilmiş örnekler:

| Neden | EXP `resCode` | Coin `resCode` |
| --- | --- | --- |
| Görev tamamlama | `1` | `2` |
| Görev tamamlamayı geri alma | `101` | `3` |
| Alt görev tamamlama | `12` | `11` |
| Alt görevi geri alma | `106` | `12` |
| API değişikliği | `200` | `28` |

Tam EXP kodları: `0` bilinmiyor; `1` görev tamamlama; `2` başarı; `3` beğeni takası; `4` kullanım günü serisi; `5` adım takası; `6` tamamlandı olarak ayarlama; `7` bırakmayı geri alma; `8` süre aşımını geri alma; `9` domates yeme; `10` eşya kullanma; `11` kullanıcı başarısı kilidi açma; `12` alt görev tamamlama; `200` API; `101` tamamlamayı geri alma; `102` bırakma; `103` süre aşımı; `104` eşya kullanımı EXP azaltır; `105` kullanıcı başarısını yeniden kilitleme; `106` alt görev tamamlamayı geri alma. Para neden kodları [envanter kayıtlarıyla](#get-inventory-records) aynı alanı kullanır. Gelecekteki bilinmeyen kodları koruyun. Net değişim için yönü `isDecrease` ile uygulayın (`true` kayıtlı miktarı çıkarır). Azalmanın negatif `value` olarak kodlandığını varsaymayın; sayısal türler işaretlidir ve işaretsiz/mutlak değer garantisi yoktur.

EXP `value` değeri özellik başınadır. Kayıtlar arasında EXP `totalValue` değerlerini körü körüne toplamayın: güncel çok özellikli gruplama mantığı, üçten fazla özellik olduğunda örtüşen toplamlar saklayabilir. Örneğin dört özelliğin her birine 10 EXP değişikliği, güvenle toplanabilecek 40 yerine 40 ve 10 toplamlarını saklayabilir. Kesin raporlama için özellik başına `value` değerini her kayıtta listelenen özelliklerle uzlaştırın; eksik ilişkiler belirlenebilecekleri sınırlar. `value` ve `totalValue` değerlerini birbirine eklemeyin ve EXP `totalValue` değerini bakiye olarak tanımlamayın.

Bir takvim günü için yerel `dayStart` ve `nextDayStart` hesaplayıp `[dayStart, nextDayStart - 1]` aralığını isteyin; çünkü iki sınır da dahildir. Yalnızca görev ödüllerini raporlarken neden kodlarını seçin; kaydedilmiş tüm değişiklikleri raporlarken bu kodları filtrelemeyin. [Günlük rapor yöntemi](/guide/api-reference?id=daily-report).

### Uygulama kaynakları :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Tarih parametrelerinin iletilmesi](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Eşyalar ve kategoriler :id=get-items

`GET /items`, `ShopItem[]` döndürür. İsteğe bağlı, yinelenebilir `id` sorgu parametresi eşya ID'lerini seçer: `/items?id=1&id=2`. Tamsayı olmayan değerler atılır. Bulunamayan ID'ler atlanır; geçerli ID'ler tekrarlar dahil istek sırasını korur. Verilen tüm ID'ler geçersizse SDK ID filtresi göndermez ve normal eşya listesi döner. Sayfalama yoktur.

`GET /items/{listId}`, tek bir eşya yerine bir **kategorideki** `ShopItem[]` değerini döndürür. `listId` işaretli 64 bit kategori ID'sidir; `-1` tümü demektir. Geçersiz yol değeri tümüne döner. Normal liste, listeden kaldırılmış/silinmiş eşyaları dışlar (`isDel=0`) ve yapılandırılmış mağaza/kategori sıralamasını izler. ID seçimi bu normal liste filtresinden bağımsız eşya getirebilir.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Eşya ID'si. |
| `name` | string | Eşya adı. |
| `desc` | string | Açıklama. |
| `icon` | string | Okunabilir resim URI'si veya boş dize. `/files/{url}` üzerinden indirin. |
| `categoryId` | integer | Mağaza kategorisi ID'si. |
| `stockNumber` | integer | Mevcut stok; `maxPurchaseNumber` hesaplanırken negatif stok sınırsız kabul edilir. |
| `ownNumber` | integer | Envanterde sahip olunan miktar. |
| `price` | integer | Para fiyatı. |
| `order` | integer | Kategorisi içindeki kayıtlı sıra. |
| `disablePurchase` | boolean | Satın alma devre dışı bayrağı. |
| `maxPurchaseNumber` | tamsayı veya null | Kullanılabilir para, kredi ve sınırlı stoktan hesaplanır; satın alma kapalıysa 0, ücretsiz ve sınırsız stokta 2147483647 olabilir. Bu hesaplama tüm satın alma sınırı kurallarını değerlendirmez. |
| `titleColorString` | dize veya null | Özel başlık rengi. |
| `actionText` | dize veya null | Özel kullanma düğmesi metni. |
| `unlist` | boolean | Listeden kaldırılmış/silinmiş bayrağı; liste sonuçlarında genellikle false. |
| `disableUse` | boolean | Eşyanın kullanılamaz etkisinin olup olmadığı. |
| `purchaseLimit` | dize veya null | İç içe dizi değil, **JSON kodlu dize**; eşyanın satın alma sınırı yapılandırması. |
| `limitScope` | dize veya null | `purchase`, `use` veya `both`. |

### GET /items_categories :id=get-items-categories

`ShopCategory[]` döndürür. İsteğe bağlı `include_hidden` varsayılanı `false`; yalnızca tam küçük harfli `true` ve `false` dizeleri ayrıştırılır, diğer değerler false olur. Sanal tümü kategorisini içerir. HTTP sunucusu `/items_categories/{id}` sunmaz.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kategori ID'si. |
| `name` | string | Kategori adı. |
| `isAsc` | boolean | Yapılandırılmış artan sıralama bayrağı. |
| `sort` | string | Kayıtlı sıralama tercihi. |
| `order` | integer | Kategori sırası. |
| `hidden` | boolean | Mağazada gizli. |
| `inventoryHidden` | boolean | Envanterde gizli. |

### GET /tasks_categories :id=get-tasks-categories

Tümü kategorisi ve arşivlenmiş kategoriler dahil `TaskCategory[]` döndürür. Sorgu parametresi veya sayfalama yoktur. HTTP sunucusu `/tasks_categories/{id}` sunmaz. Kategori sıralama/filtre değerleri kayıtlı uygulama tercihleridir; bu uç nokta bunları istek filtresi olarak uygulamaz.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kategori ID'si. |
| `name` | string | Ad. |
| `isAsc` | boolean | Kayıtlı artan sıralama bayrağı. |
| `sort` | string | Kayıtlı sıralama tercihi. |
| `filter` | string | Kayıtlı gruplama/filtreleme tercihi. |
| `order` | integer | Kategori sırası. |
| `status` | integer | 0 normal; 1 arşivlenmiş. |
| `type` | integer | 0 normal; akıllı listelerde 10 günlük, 11 haftalık, 12 aylık, 20 yapılıyor. |

## Özellikler ve özellik grupları :id=get-skills

`GET /skills`, parametre veya sayfalama olmadan `Skill[]` döndürür. Gizli/silinmiş özellikler dışlanır ve kayıtlı sıra kullanılır. Alttaki ContentProvider'ın `group_id` ve `status` alanları HTTP modelinin alanları **değildir**.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Özellik ID'si. |
| `name` | string | Yerelleştirilmiş özellik adı. |
| `desc` | string | Açıklama. |
| `icon` | string | Okunabilir simge URI'si veya boş. |
| `order` | integer | Kayıtlı sıra. |
| `color` | integer | Android paketlenmiş renk tamsayısı. |
| `exp` | integer | Geçerli toplam EXP. |
| `level` | integer | Geçerli seviye. |
| `untilNextLevelExp` | integer | Sonraki seviyeye kalan EXP. |
| `currentLevelExp` | integer | Geçerli seviyenin başlangıcından beri kazanılan EXP. |
| `type` | integer | 0 kullanıcı; 1 güç; 2 öğrenme; 3 çekicilik; 4 dayanıklılık; 5 canlılık; 6 yaratıcılık. |

### GET /skill_groups :id=get-skill-groups

`SkillGroup[]` döndürür. `include_hidden`, `/items_categories` ile aynı katı Boolean ayrıştırmasını kullanır; varsayılan false. Uygulamanın mevcut deposu gruplarda bu bayrağı yok sayar ve silinmiş grupları daima dışlar. Kayıtlı sıra artandır. Sayfalama yoktur.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Grup ID'si. |
| `content` | string | Grup başlığı. |
| `order` | integer | Kayıtlı grup sırası. |
| `collapsed` | boolean | Daraltılmış durum. |

## Başarılar :id=get-achievements

`GET /achievements`, her kategoriyi kategori sırasıyla yükleyip başarılarını birleştirerek `Achievement[]` döndürür. `GET /achievements/{id}`, başarı ayrıntısı yerine **`id` kategorisindeki** başarıları döndürür. Geçersiz yol ID'leri filtresiz yol gibi davranır. Her kategori içindeki sıralama, kategorinin uygulamadaki sıralama tercihini izler. İki uç nokta da sayfalı değildir.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Başarı ID'si. |
| `name` | string | Başlık. |
| `desc` | string | Açıklama. |
| `iconUri` | string | Simge URI'si veya boş. |
| `categoryId` | integer | Kategori ID'si. |
| `status` | integer | 0 tamamlanmamış; 1 tamamlanmış, ödülü alınmamış; 2 ödül alınmış/diğer tamamlanmış durum. |
| `exp` | integer | EXP ödülü. |
| `coin` | integer | Para ödülü. |
| `coinVariable` | integer | Değişken para ödülü. |
| `type` | integer | 0 başarı; 1 alt kategori başlığı. |
| `progress` | integer | Kayıtlı ilerleme. |
| `order` | integer | Kategori içindeki sıra. |
| `itemId` | tamsayı veya null | İlk ödül eşyası ID'si (eski yardımcı alan). |
| `itemAmount` | tamsayı veya null | İlk ödül eşyasının miktarı. |
| `unlockedTime` | tamsayı veya null | Milisaniye cinsinden kilit açma Unix zamanı. |
| `items` | RewardItem[] veya null | Tam ödül eşyası listesi; geçerli ayrıştırıcı, eksik/bozuk eşya JSON'u için boş dizi verir. |
| `color` | dize veya null | Özel başlık rengi. |

Ödül eşyaları ortak [RewardItem](#reward-item) modelini kullanır.

### GET /achievement_categories :id=get-achievement-categories

Parametre veya sayfalama olmadan `AchievementCategory[]` döndürür. HTTP sunucusu `/achievement_categories/{id}` sunmaz.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kategori ID'si. |
| `name` | string | Ad. |
| `desc` | string | Açıklama. |
| `iconUri` | string | Simge URI'si/dizesi. |
| `isAsc` | boolean | Artan sıralama bayrağı. |
| `sort` | string | Kayıtlı sıralama tercihi. |
| `filter` | string | Kayıtlı gruplama/filtreleme tercihi. |
| `order` | integer | Kategori sırası. |
| `type` | integer | 0 kullanıcı başarıları; 1 sistem başarıları. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

**Başarı** ID'si `id` için `AchievementCondition[]` döndürür. Tamsayı olmayan ID, 500 kodlu hata zarfı döndürür. Eşleşen koşul yoksa boş dizi üretilir. `/achievement_conditions` koleksiyon yolu yoktur.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Koşul ID'si. |
| `type` | integer | Koşul kodu; aşağıya bakın. |
| `relatedId` | integer | Koşula göre ilgili görev/eşya/özellik kimliği. |
| `target` | integer | Hedef değer. |
| `current` | integer | Geçerli birikmiş değer. |
| `progress` | integer | Kayıtlı ilerleme. |

Koşul kodları: 0 görev tamamlamaları; 1 geçerli görev serisi; 2 eski özellik seviyesi; 3 domatesler; 4 uygulama kullanım günleri; 5 beğeniler; 6 art arda tamamlama günleri; 7 geçerli para; 8 bir günde kazanılan para; 9 görev domatesleri; 10 eşya satın almaları; 11 eşya kullanımları; 12 ganimet kutusundan eşya kazanımları; 13 özellik seviyesi; 14 yaşam seviyesi; 15 birikimli eşya kazanımları; 16 sentezden eşya kazanımları; 17 şu anda sahip olunan eşya miktarı; 18 görev odaklanma süresi; 19 ATM birikimi; 20 harici API. Yinelenen koşullar: 500 görev tamamlamaları; 501 özellik seviyesi artışları; 502 domatesler; 503 para; 504 eşya kazanımları; 505 eşya satın almaları; 506 ganimet kutusu kazanımları; 507 sentez kazanımları; 508 eşya kullanımları; 509 görev odaklanma dakikaları; 510 görev domatesleri; 511 beğeniler; 512 ATM birikimi artışları; 513 harici API çağrıları; 514 kullanım günleri; 515 yaşam seviyesi artışları; 516 günlük para; 517 art arda görev tamamlamaları; 518 günlük domatesler; 519 günlük odaklanma dakikaları; 520 günlük farklı görev grupları; 521 günlük eşya kullanımları; 522 günlük eşya satın almaları; 523 belirli bir görevin günlük tamamlamaları; 524 günlük toplam görev tamamlama kayıtları. Bunlar serileştirilmiş enum adları değil, ham tamsayı kodlarıdır.

## Sentez :id=get-synthesis

`GET /synthesis`, görünür kategorilerden `Synthesis[]` döndürür. `GET /synthesis/{id}`, kategorinin gizli içeriği dahil **`id` kategorisindeki** tarifleri döndürür. Negatif olmayan ID'ler bir kategori seçer; negatifler tüm görünür kategorileri belirtir. Geçersiz ID'ler koleksiyon yoluna döner. Sonuçlar kayıtlı tarif sırasını artan izler; silinmiş tarifler dışlanır. Sayfalama yoktur.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Tarif ID'si. |
| `name` | string | Ad. |
| `desc` | string | Açıklama. |
| `input` | SynthesisItemInfo[] | Gerekli eşyalar. |
| `output` | SynthesisItemInfo[] | Üretilen eşyalar. |
| `categoryId` | tamsayı veya null | Kategori ID'si. |
| `canSynthesisTimes` | integer | Şu anda yapılabilen sentez sayısı. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `itemId` | integer | Eşya ID'si. |
| `itemName` | string | Eşya adı. |
| `amount` | integer | Sentez başına giriş/çıkış miktarı. |
| `ownedNumber` | integer | Sahip olunan miktar. |
| `icon` | string | Okunabilir simge URI'si veya boş. |

### GET /synthesis_categories ve /synthesis_categories/{id} :id=get-synthesis-categories

İkisi de `SynthesisCategory[]` döndürür. İsteğe bağlı yol `id` değeri kategori ID'sini filtreler; dizi biçimini değiştirmez. Geçersiz ID'ler tüm kategorilere döner. İsteğe bağlı `include_hidden`, kategori ID'si verildiğinde de katı küçük harf Boolean ayrıştırması kullanır ve false varsayılır. Sayfalama yoktur.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kategori ID'si. |
| `name` | string | Ad. |
| `isAsc` | boolean | Kayıtlı artan sıralama bayrağı. |
| `sort` | string | Kayıtlı sıralama tercihi. |
| `order` | integer | Kategori sırası. |
| `hidden` | boolean | Gizli bayrağı. |

## Duygular :id=get-feelings

`GET /feelings`, `Feelings[]` döndürür. `offset` varsayılanı 0, `limit` 100'dür; eksik veya tamsayı olmayan değerlerde bunlar kullanılır. Bu uç noktada açık bir sınırlandırma yoktur. Negatif olmayan ofsetler ve pozitif limitler kullanın. Silinmiş duygular dışlanır. Sıralama istek parametresini değil, uygulamanın duygu sıralama tercihini (`createTime` artan veya azalan) izler. Zaman filtresi sunulmaz.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Duygu ID'si. |
| `content` | string | Metin. |
| `isFav` | boolean | Favori bayrağı. |
| `title` | string | İlgili başlık. |
| `time` | integer | Milisaniye cinsinden oluşturma Unix zamanı. |
| `attachments` | dize[] | Var olan, boş olmayan dosyaların okunabilir ek URI'leri. |
| `type` | integer | 0 görev; 1 başarı; 2 bağımsız kayıt. |

## Pomodoro kayıtları :id=get-pomodoro-records

`GET /pomodoro_records`, `PomodoroRecord[]` döndürür. `offset` varsayılanı 0, `limit` 100'dür; açık sınırlandırma yoktur. İsteğe bağlı `time_range_start` ve `time_range_end` Unix milisaniyesidir. SDK yalnızca ikisi de 64 bit tamsayı olarak ayrıştırıldığında ve başlangıç bitişten küçük olduğunda aralığı iletir; aksi halde sessizce atlar.

Aralık yoksa `startTime != endTime` ve pozitif `endTime` koşullu, tamamlanmış ve silinmemiş kayıtlar `endTime DESC, startTime DESC, id DESC` sırasıyla döner. Geçerli aralık `start < endTime <= end` seçer ve silinmiş satırları dışlar.

> [!WARNING]
> Önceki uygulamalar tarih aralığı sorgularında `limit` ve `offset` değerlerini DAO’ya ters konumlarda iletiyor ve sıralama belirtmiyordu. Yerel LifeUp kaynağı artık adlandırılmış bağımsız değişkenler kullanıyor ve sayfalanan sonuçları `endTime DESC, startTime DESC, id DESC` ile sıralıyor; bu yerel düzeltme henüz yayımlanmadı. Yüklü LifeUp sürümünüzün düzeltmeyi içerdiğini doğrulayana kadar güvenilir sayfalama için aralığı atlayıp dönen satırları istemcide filtreleyin.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kayıt ID'si. |
| `startTime` | tamsayı veya null | Milisaniye cinsinden başlangıç Unix zamanı. |
| `endTime` | tamsayı veya null | Milisaniye cinsinden bitiş Unix zamanı. |
| `duration` | integer | Milisaniye: kayıtlı sıfır olmayan `lastTime`, aksi halde bitiş eksi başlangıç. |
| `reward` | sayı | Kazanılan domates miktarı: bırakılan = 0; yarım = 0.5 × çarpan; aksi halde çarpan. |

## Envanter kayıtları :id=get-inventory-records

`GET /inventory_records`, `InventoryRecord[]` döndürür. `offset` varsayılanı 0 ve en az 0'a sınırlıdır; `limit` varsayılanı 100 ve 1–200'e sınırlıdır. İsteğe bağlı `time_range_start` ve `time_range_end` yalnızca ikisi de 64 bit tamsayıysa ve başlangıç < bitiş ise iletilir; SDK geçersiz/eksik aralıkları sessizce atlar. Geçerli aralıklar kapsayıcı `time >= start AND time <= end` kullanır. Silinmiş kayıtlar dışlanır (`isDel` null veya 0); sıra `time DESC, id DESC`. Eşya ID filtresi sunulmaz.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kayıt ID'si. |
| `time` | tamsayı veya null | Milisaniye cinsinden oluşturma Unix zamanı. |
| `itemId` | tamsayı veya null | İlgili eşya ID'si. |
| `itemName` | dize veya null | Varsa ilgili eşyanın adı. |
| `changeNumber` | integer | Kaydedilen miktar değişimi. |
| `isDecrease` | boolean | Değişimin envanteri azaltıp azaltmadığı. |
| `resCode` | integer | Kaynak neden kodu; aşağıya bakın. |
| `desc` | dize veya null | Kayıt açıklaması. |

Neden kodları: 0 satın alma; 1 kullanım; 2 görev tamamlama; 3 tamamlamayı geri alma; 4 verileri temizleme; 5 görevi bırakma; 6 görevin süresinin dolması; 7 yerleşik başarı kilidi açma; 8 bırakmayı geri alma; 9 süre aşımını geri alma; 10 eşya iadesi; 11 alt görev tamamlama; 12 alt görev tamamlamayı geri alma; 13 kullanıcı başarısı kilidi açma; 14 kullanıcı başarısı kilit açmayı geri alma; 15 yatırma; 16 çekme; 17 domates satışı; 20 eşya ödülü; 21 ödülü geri alma; 23 sentez; 24 ganimet kutusu; 25 ATM faizi; 26 domatesle eşya takası; 27 kredi faizi; 28 API; 29 eşya etkisi stok değişimi. İstemciler gelecekteki bilinmeyen kodları korumalıdır.

## Adım kayıtları :id=get-step-records

`GET /step_records`, `StepRecord[]` döndürür. Sayfalama varsayılanları/sınırları ve SDK aralık atlama kuralları `/inventory_records` ile aynıdır. Geçerli zaman filtresi `date` üzerinde kapsayıcıdır; sıralama açık ikincil anahtar olmadan `date DESC` şeklindedir.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Kayıt ID'si. |
| `date` | tamsayı veya null | Unix milisaniyesi olarak kayıt tarihi. |
| `dailyStepCount` | integer | Günlük adım sayısı. |
| `totalStepCount` | integer | Kayıtlı toplam adım sayısı. |
| `isGotReward` | boolean | Ödül alınmış bayrağı. |
| `isUserInput` | boolean | Kullanıcı girişi bayrağı. |
| `rewardLevel` | tamsayı veya null | Kayıtlı ödül seviyesi. |

## Seviye tanımları :id=get-level-defines

`GET /level_defines`, tek bir `LevelDefines` nesnesi döndürür. Parametre yoktur. Özel seviye modu açıksa özel tanımları, aksi halde yerleşik tanımları kullanır.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `custom` | boolean | Özel seviye modu. |
| `levels` | LevelDefine[] | Seviye aralıkları. |

### LevelDefine :id=model-level-define

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | tamsayı veya null | Tanım ID'si. |
| `levelStart` | integer | Başlangıç seviyesi. |
| `levelEnd` | integer | Bitiş seviyesi. |
| `perLevelExp` | integer | Aralıktaki her seviye için gereken EXP. |

Bozuk seviye JSON'u şu anda tüm isteği başarısız kılmak yerine boş `levels` dizisine dönüşür.

## İstatistikler :id=get-statistics

`GET /statistics`, bir `Statistics` nesnesi döndürür. İsteğe bağlı `time_range_start` ve `time_range_end` Unix milisaniyesi ve aynı SDK iletim kuralını kullanır: ikisi de geçerli ve başlangıç < bitiş olmalı, aksi halde aralık gönderilmez. Aralık yoksa uygulama ilk kayıtlı zaman damgasından şimdiye kadar kullanır; yoksa son 30 günü kullanır. Aralık verilse bile `usingDays` ve `companionDays` tüm süreye ait değerlerdir. Diğer ölçütler uygulamanın ilgili istatistik yöntemleriyle hesaplanır; tüm alt sorguların aynı sınır dahil etme kurallarını paylaştığını varsaymayın.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `start` | tamsayı veya null | Unix milisaniyesi olarak etkin aralık başlangıcı. |
| `end` | tamsayı veya null | Unix milisaniyesi olarak etkin aralık sonu. |
| `tomatoes` | integer | Kazanılan domates istatistiği. |
| `pomodoroMinutes` | integer | Dakika cinsinden odaklanma süresi. |
| `focusCount` | integer | Odaklanma oturumu sayısı. |
| `tasksCompleted` | integer | Tamamlama istatistiğinde kullanılan tamamlanmış görev sayısı. |
| `tasksTotal` | integer | Bu istatistikte kullanılan toplam görev sayısı. |
| `taskCompleteRate` | sayı | Tamamlama oranı. |
| `feelingsCount` | integer | Duygu sayısı. |
| `usingDays` | integer | Tüm kullanım süresindeki günler. |
| `companionDays` | integer | Tüm süre içindeki eşlik günleri. |
| `interestChanged` | integer | Faiz para değişimi istatistiği. |
| `coinPurchaseConsumed` | integer | Satın almada harcanan para istatistiği. |

## Uygulama bilgisi ve para bakiyesi :id=get-info

`GET /info`, `Info` döndürür. LifeUp Cloud kendi yüklü sürümünü uygulama/sağlayıcı bilgisine ekler. Parametre yoktur.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `appVersion` | integer | Yüklü LifeUp sürüm kodu. |
| `appVersionName` | string | Yüklü LifeUp sürüm adı. |
| `apiVersion` | integer | LifeUp API sürümü. |
| `cloudVersion` | integer | Yüklü LifeUp Cloud sürüm kodu. |
| `cloudVersionName` | string | Yüklü LifeUp Cloud sürüm adı. |

### GET /coin :id=get-coin

ContentProvider üzerinden `lifeup://api/query?key=coin` çağırır ve sonuç nesnesini döndürür. Parametre yoktur. null sağlayıcı sonucu boş nesneye dönüşür. Alanlar, türlenmiş `CoinData` yanıtı yerine sağlayıcı tarafından tanımlanır. Başarılı sorgu `value` (işaretli 64 bit tamsayı para bakiyesi) ve `api_result: true` sağlar; hatalar aşağıdaki sağlayıcı durum/hata alanlarını sağlayabilir.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## URL Scheme API'si çağırma :id=invoke-api

[URL Scheme API kataloğu](/guide/api) yöntem adlarını, parametrelerini ve yönteme özgü sonuçları tanımlar. HTTP köprüsü tam `lifeup://api/...` URL'sini kabul eder.

| Taşıma | Girdi | Yürütme ve yanıt |
| --- | --- | --- |
| `GET /api` | Yinelenen URL kodlu sorgu `url` | Verilen sırayla her URL için Android activity başlatır. `success` dizesini döndürür. Eksik URL'ler de başarı döndürür. |
| `POST /api` | JSON `RawQueryVo` | Önce tüm `urls` girdilerini, sonra varsa `url` başlatır. `success` dizesini döndürür. Boş giriş nesnesi de başarılıdır. |
| `GET /api/contentprovider` | Yinelenen URL kodlu sorgu `url` | Sağlayıcıyı eşzamanlı çağırır ve verilen sırayla `CallUrlResult[]` döndürür. Eksik URL'ler hata zarfı döndürür (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Önce tüm `urls` girdilerini, sonra `url` çağırır; `CallUrlResult[]` döndürür. Boş nesne boş dizi döndürür. |

JSON POST istekleri için `Content-Type: application/json` ayarlayın. GET sorgusuna eklerken URL'nin tamamını kodlayın; iç `&`, `?`, `+` ve yüzde kodlamasını koruyun. Başarılı activity köprüsü yanıtı LifeUp eyleminin tamamlanmasını değil, gönderimi doğrular. ContentProvider yöntemleri LifeUp'ta Cloud izni gerektirir ve destek URL Scheme yöntemine bağlıdır. Çağrılar sıralıdır; sonraki çağrı hata fırlatırsa önceki etkiler geri alınmaz.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Activity köprüsü yanıtı:

```json
{"code":200,"message":"success","data":"success"}
```

Sağlayıcı köprüsü yanıtı (temsili sağlayıcı sonucu):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `url` | dize veya null | İsteğe bağlı tek URL. |
| `urls` | dize[] veya null | İsteğe bağlı URL listesi; `url` öncesinde işlenir. |

### CallUrlResult :id=model-call-url-result

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `url` | string | Gönderilen URL. |
| `result` | nesne veya null | Dönüştürülmüş sağlayıcı Bundle'ı; null tek başına HTTP zarfını başarısız kılmaz. |

Bundle dönüşümü Int/Long/Double/String/Boolean değerlerini ve iç içe Bundle'ları korur. Diziler dize dizilerine dönüşür. Diğer değer türleri `toString()` dizesine dönüşür (Bundle null değeri de `"null"` dizesine dönüşür). Dış zarfın kodu 200 olsa bile `result` içindeki yöntem hata alanları denetlenmelidir.

LifeUp'ın geçerli yöntem işleyicisi tamamlanan çağrılara `api_result` (Boolean) ekler. Yakalanan yöntem hatası `api_result: false`, `error_code` (dize) ve `error_message` (dize) döndürür. Kodlar arasında `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` ve `internal_error` bulunur; yöntemler ek kodlar verebilir. Yedek geri yüklenirken sağlayıcı `api_result` olmadan `error_code: "503"` ve `error_message` döndürebilir. Eksik API işleyicileri bu hata dönüşümünden önce hata fırlatıp dış köprü hatası üretebilir.

## Dosya okuma ve yükleme :id=files-download

### GET /files/{url} :id=files-get

Okunabilir URI'nin tamamını tek yol parçası olarak URL kodlayın. Genellikle simgeler, duygu ekleri, dışa aktarılan yedekler veya yüklenen dosyalar için Android içerik çözümleyicisi üzerinden bayt okur. Sonuç JSON başarı zarfı değil, bayt akışıdır. Yol dosya adı veya MIME türü belirtmez. Boş/okunamayan çözümleyici akışları yapılandırılmış bulunamadı sonucuna dönüştürülmez; fırlatılan hatalar genel HTTP 500 işleyicisini kullanır. Eşleşen boş parametre hata zarfı üretir (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

`multipart/form-data` gönderin. Alan adına bakılmaksızın her dosya bölümü kabul edilir; dosya olmayan form bölümleri yok sayılır. Önbellek dosyası için özgün dosya adı kullanılır; yoksa Cloud `uploaded_image_<time>.jpg` seçer. Okunabilir içerik URI dizelerinden oluşan dizi döndürür. Yükleme sonraki API çağrıları için dosya URI'si sağlar; dosyayı eşya veya göreve otomatik eklemez. Dosya yoksa `No files received` hata zarfı döner.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Yedek dışa ve içe aktarma :id=files-backup

### GET /data/export :id=files-export

Sağlayıcı üzerinden yedek oluşturur. İsteğe bağlı `withMedia` varsayılanı `true`; varsa büyük/küçük harf duyarsız `true` doğru, diğer tüm değerler yanlış demektir. Şu anda `backup_file_uri` içeren dönüştürülmüş sağlayıcı Bundle'ını döndürür; URI'yi indirmek için `/files/{url}` kullanın. HTTP yöntemi GET olsa da dışa aktarma oluşturur. Sağlayıcı API durum/hata alanları da bulunabilir ve denetlenmelidir. Boş `backup_file_uri`, kullanılabilir dosya üretilmediğini belirtir. null sonuç hata olur.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Yedek dosyasıyla `multipart/form-data` gönderin. Birden çok dosya verilirse son dosya bölümü kullanılır; alan adı denetlenmez. Varsayılan dosya adı `backup.lfbak`. İsteğe bağlı `description` form alanı okunur ama etkisi yoktur. Cloud dosyayı önbelleğe alır ve LifeUp yedek activity'sini başlatır; yanıt yüklemeyi ve activity başlangıcını doğrular, **geri yüklemenin tamamlanmasını değil**. Dosya yoksa `No file received` döner.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Olaylar :id=get-events

### GET /events :id=get-events-poll

`EventsPage` döndürür. `after`, hariç tutulan olay ID imlecidir (64 bit tamsayı, varsayılan 0). `limit` varsayılanı 50 olan ve 1–200'e sınırlanan tamsayıdır. Tamsayı olmayan değerler varsayılanı kullanır. Olaylar tutulan tamponda eskiden yeniye, `id > after` ile sıralanır. Bellekte en fazla 200 olay tutulur; eskiler atılır ve süreç yeniden başlayınca ID'ler sıfırlanır. `latestId` en son mevcut genel ID'dir, sınırlı sayfadaki son olay olmayabilir. Birikmiş olayları atlamamak için gerçekten işlenen son olaydan devam edin. Kalıcı geçmiş veya teslim onayı sağlanmaz.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `latestId` | integer | Geçerli en son olay ID'si. |
| `eventWs` | boolean | Cloud'un WebSocket ayarı. |
| `events` | CloudEvent[] | İmleçten sonra tutulan olaylar. |
| `broadcasts` | Boolean veya null | LifeUp yayınlarının açık olup olmadığı; null bilinmiyor veya desteklenmiyor demektir. Sorgu durumu beş saniye önbelleğe alınır. |

### CloudEvent :id=model-cloud-event

| Alan | JSON türü | Anlamı |
| --- | --- | --- |
| `id` | integer | Bellek içi olay sıra ID'si. |
| `time` | integer | Milisaniye cinsinden Cloud alım Unix zamanı. |
| `action` | string | Android yayın eylemi. |
| `extras` | dize değerlerinden oluşan nesne | `toString()` ile dönüştürülen yayın ekleri; null boş dize olur. Anahtarlar eyleme bağlıdır. |

### WebSocket /events :id=get-events-websocket

`eventWs` true olduğunda `ws://HOST:PORT/events?after=ID` adresine bağlanın (ve yapılandırılmış belirteci sağlayın). Sunucu `after` sonrasındaki tutulan olayları yeniden oynatır, sonra canlı olayları HTTP yanıt zarfı **olmadan** ayrı JSON `CloudEvent` metin çerçeveleri olarak gönderir. Yeniden oynatma 200 olaylık bellek tamponuyla sınırlıdır; WebSocket `limit` parametresi yoktur. Sunucu her 30 saniyede Ping çerçevesi gönderir. Gerçekten işlenen son olay ID'siyle yeniden bağlanın. Kapalıysa WebSocket yolu kaydedilmez; HTTP yoklaması kullanılabilir kalır.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Desteklenen eylem abonelikleri: `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause` ve `app.lifeup.timing.abandon`. Olay toplama, LifeUp yayınlarının açık olmasını gerektirir. `/events` yoklaması bu ayarı denetler; otomatik olarak açmaz.

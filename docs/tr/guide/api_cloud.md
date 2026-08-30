<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> **LifeUp v1.106.0** ve **LifeUp Cloud v3.0.0** sürümlerini kademeli olarak yayınlıyoruz. Platform inceleme süreleri değişkenlik gösterdiğinden, bu belge App'ler genel kullanıma sunulmadan önce güncellenmiş olabilir; gerçek yayın tarihi burada gördüğünüzden daha geç olabilir.

LifeUp Cloud, LifeUp'ın temel API araç setlerinden biridir. Telefonunuzu bir **API köprüsüne** dönüştürür: LifeUp'ı **bilgisayarınızdan veya diğer cihazlardan** kontrol edin, **özel entegrasyonlar** (masaüstü, web, otomasyon betikleri) oluşturun veya **yapay zekâ ajanları** ile eşleştirin.

### Tipik senaryolar

| Senaryo | Kimler için | Tek cümlede | Daha fazla |
| --- | --- | --- | --- |
| **HTTP + kendiniz kurun** | Geliştiriciler, otomasyon kullanıcıları | LAN üzerinden Python, web App'leri veya betiklerle API çağırın ve veri sorgulayın — Android deneyimi gerekmez | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **QR tarama** | Gerçek dünya check-in meraklıları | Görevleri tamamlamak, zamanlayıcı başlatmak, iletişim kutuları açmak veya web sayfaları / diğer App'leri başlatmak için QR kodları yazdırın | [QR kod tarama](#qr-code-scanning) |
| **Başlat / durdur kısayolları** | Otomasyon, NFC, Tasker | `lifeupcloud://start` ve `lifeupcloud://stop` Cloud'u açar ve HTTP sunucusunu başlatır veya durdurur | [Başlatma ve durdurma](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude vb. | Tek prompt ile Görev listeleri, Mağaza eşyaları, Başarımlar ve daha fazlasını oluşturun | [MCP & Skills](guide/api_mcp.md) |
> **Örnek AI promptu:** Örnek Görevleri ve Mağaza eşyalarını temizle, ardından tam bir indie oyun geliştirici kurulumu oluştur: Görev listeleri, Özellikler, Mağaza eşyaları ve Başarımlar.

<br/>

## İndirme

- Anakara Çin üyelik sürümünü kullanıyorsanız LifeUp Cloud indirme girişini `Sidebar` → `Settings` → `Experiments` altında bulabilirsiniz.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud hizmetini başlatma ve durdurma :id=cloud-scheme

**Start Service**'e dokunmadan HTTP sunucusunu aşağıdaki URL şemalarıyla başlatabilir veya durdurabilirsiniz:

```txt
lifeupcloud://start
lifeupcloud://stop
```

URL'lerden birini açmak LifeUp Cloud'u başlatır ve eylemi uygular. Ana ekran kısayolu, NFC etiketi, Tasker/otomasyon eylemi olarak kullanın veya:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Aynı URL'ler Cloud durum kartında da listelenir — kopyalamak için dokunun.

> [!NOTE]
> `lifeupcloud://` Cloud HTTP sunucusunun kendisini kontrol eder. `lifeup://api/…` oyun API'si değildir.

<br/>

## QR kod tarama :id=qr-code-scanning

LifeUp Cloud'un üstündeki **Scan** düğmesi QR kodda kodlanmış URL'yi okur ve hemen açar — elle giriş gerekmez.

Tarama **yalnızca LifeUp API'leriyle sınırlı değildir**: `lifeup://api/…`, web sayfaları `https://…` ve diğer App URL şemaları (ör. `weixin://`) de çalışır — Android eşleşen hedefi açar.

### Nasıl kullanılır

1. LifeUp veya wiki [API listesinden](guide/api.md) bir URL seçin (Görev tamamlama, pomodoro başlatma, satın alma/kullanma iletişim kutuları açma veya harici web sayfası açma).

2. Tam URL'den QR kod oluşturun (yazdırıp masaya, duvara veya cihaza yapıştırın).

3. LifeUp Cloud'u açın, **Scan**'e dokunun (yanındaki **?** kısa App içi kılavuz için), kodu okutun.

### Neler yapabilirsiniz

| Senaryo | Örnek (açıklayıcı) |
| --- | --- |
| Pomodoro check-in | `lifeup://api/pomodoro?...` zamanlayıcı başlat/durdur |
| Görev check-in | `lifeup://api/complete?name=...` Görev tamamla |
| Mağaza etkileşimi | `lifeup://api/goto?page=shop` veya satın alma/kullanma iletişim kutuları |
| Ödül / ceza | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web mini oyun | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Diğer App'ler | `weixin://`, `intent://` veya kurulu herhangi bir App şeması |
| Özel akışlar | Herhangi bir taranabilir URL kombinasyonu |

### Gerçek dünya etkileşimi

QR kodları **fiziksel yerleri veya eylemleri** App içi oyunlaştırmaya bağlar:

- **Spor salonu ekipmanı** etiketi → tara, güç antrenmanı Görevini tamamla

- **Çalışma masası** etiketi → tara, Odak pomodoro'su başlat

- **İş istasyonu** etiketi → tara, stand-up veya kod incelemesi kaydet

- **Etkinlik panosu** etiketi → tara, Ödül al veya Başarım aç

Kısaca: **URL Scheme'leri taranabilir fiziksel tetikleyicilere dönüştürün**; LifeUp Cloud App ile gerçek dünya arasında yürütücü olarak çalışır.

<br/>

> [!NOTE]
> LifeUp Cloud yalnızca LAN HTTP köprüsüdür. Telefonunuza nasıl ulaşacağınız — IP adresi, yönlendirici, güvenlik duvarı, aynı alt ağ, VPN veya AP izolasyonu — ev ağınıza bağlıdır. Bağlanamazsanız kişisel LAN'ınızı biz debug edemeyiz. Ağınızı kendiniz kontrol edin, standart ağ araçlarını kullanın veya bir AI ajanından yardım isteyin.

## HTTP API tanımı :id=http-api-definition

> [!WARNING]
> Bu sayfadaki API belgeleri uygulama güncellemelerinin gerisinde kalabilir. Nihai referans olarak kaynak kodu kullanın: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL Scheme çağırma API'si

#### GET

İşlev:

> `lifeup://api` ile başlayan API'leri çağırır.

İstek URL'si:

```txt
// Önerilen: content provider modu (daha iyi uyumluluk)
http://{host:port}/api/contentprovider

// startActivity modu (bazı cihazlar arka plan UI'ını engelleyebilir)
http://{host:port}/api
```

**Method: `GET`**

**Sorgu parametreleri:**

| Alan | Açıklama | Konum | Tür | Zorunlu | Notlar |
| --- | --- | --- | --- | --- | --- |
| url | `lifeup://api` ile başlayan API URL'si | Query | string | Evet | Elle oluştururken URL-encode edin. Birden fazla `url` parametresi desteklenir. |

**İstek örnekleri:**

```txt
// Tek çağrı (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Toplu çağrı
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Tek çağrı (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

İşlev:

> `lifeup://api` ile başlayan API'leri çağırır.

İstek URL'si:

```txt
// Önerilen: content provider modu (daha iyi uyumluluk)
http://{host:port}/api/contentprovider

// startActivity modu (bazı cihazlar arka plan UI'ını engelleyebilir)
http://{host:port}/api
```

**Method: `POST`**

**JSON gövde parametreleri:**

| Alan | Açıklama | Konum | Tür | Zorunlu | Notlar |
| --- | --- | --- | --- | --- | --- |
| urls | `lifeup://api` ile başlayan URL dizisi | Body | List<string> | Evet | JSON gövdesinde ek URL kodlaması gerekmez. |

**İstek örneği:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. Veri sorgulama API'leri

> [!NOTE]
> Gereksinimler:
> 1. LifeUp v1.91+ ve en güncel LifeUp Cloud.
> 2. LifeUp Cloud'da **Read LifeUp Data** iznini verin.

İşlev:

> Görevler ve Eşyalar gibi tam LifeUp veri kümelerini sorgular.

**Görev uç noktaları**

```txt
// Tüm Görevler
http://{host:port}/tasks

// Kategori/liste ${id} içindeki Görevler
http://{host:port}/tasks/${id}

// Geçmiş (sayfalama desteklenir)
// gid isteğe bağlıdır; tekrarlayan bir Görevin tüm geçmiş kayıtlarını filtrelemek için kullanılabilir
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Görev kategorileri
http://{host:port}/tasks_categories
```

**Eşya uç noktaları**

```txt
// Tüm Eşyalar
http://{host:port}/items

// Kategori/liste ${id} içindeki Eşyalar
http://{host:port}/items/${id}

// Eşya kategorileri
http://{host:port}/items_categories

// Gizli listeleri dahil et
http://{host:port}/items_categories?include_hidden=true
```

**Başarım uç noktaları**

```txt
// Tüm Başarımlar
http://{host:port}/achievements

// Kategori/liste ${id} içindeki Başarımlar
http://{host:port}/achievements/${id}

// Başarım kategorileri
http://{host:port}/achievement_categories
```

**Duygu uç noktaları**

```txt
// Tüm Duygular (sayfalama desteklenir)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Sentez kategori uç noktaları**

```txt
// Tüm Sentez kategorileri
http://{host:port}/synthesis_categories

// Liste ${id} içindeki Sentez kategorileri
http://{host:port}/synthesis_categories/${id}
```

**Sentez tarifi uç noktaları**

```txt
// Tüm Sentez tarifleri
http://{host:port}/synthesis

// Kategori ${id} içindeki Sentez tarifleri
http://{host:port}/synthesis/${id}
```

**Özellik uç noktaları**

```txt
// Tüm Özellikler
http://{host:port}/skills
```


**Diğer**

```txt
// Jeton bakiyesi
http://{host:port}/coin

// LifeUp / Cloud sürümleri
http://{host:port}/info

// Pomodoro kayıtları (sayfalı; isteğe bağlı zaman aralığı)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Günlükler (sayfalı; isteğe bağlı zaman aralığı). Yumuşak silinen satırlar hariç tutulur.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Tüm Başarımlar (uygulandı; kategori id isteğe bağlı)
http://{host:port}/achievements

// Broadcast olayları. LifeUp Labs → Broadcast events varsayılan kapalı; Cloud Advanced durumu gösterebilir ve etkinleştirebilir. GET data.broadcasts bu anahtardır (okunmamışsa atlanır). Cloud WebSocket ayarı yalnızca taşımadır.
http://{host:port}/events?after=${id}&limit=50

// WebSocket push (varsayılan açık; Cloud ayarı WebSocket event push)
ws://{host:port}/events?after=${id}
```

Zarf: `{ code, message, data }`. `200` yalnızca taşıma OK anlamına gelir. `10001` LifeUp çalışmıyor veya Read Data verilmemiş. `10002` ContentProvider sorgusu başarısız.

### Liste alan değerleri

| Endpoint | Alan | Değerler |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` bitmemiş · `1` tamamlandı · `2` gecikmiş · `3` vazgeçildi |
| `/tasks` | `frequency` | `0` bir kez · `1` günlük · `N>1` her N günde · `-1` sınırsız · `-3` Ebbinghaus · `-4` aylık · `-5` yıllık |
| `/tasks` | `weekdays` | `1,3,5` (Pzt=1 … Paz=7). Hafta günü modu değilken boş. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` arşivlendi |
| `/tasks_categories` | `type` | `<10` normal · `10` günlük · `11` haftalık · `12` aylık · `20` devam eden |
| `/achievements` | `status` | `0` kilitli · `1` açıldı, Ödül alınmadı · `2` açıldı, alındı |
| `/achievements` | `type` | `0` normal · `1` alt kategori |
| `/achievement_categories` | `type` | `0` kullanıcı · `1` sistem |
| `/feelings` | `type` | `0` Görev · `1` Başarım · `2` ham · `3` Eşya kullanımı |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` kullanıcı · `1` güç · `2` öğrenme · `3` cazibe · `4` dayanıklılık · `5` canlılık · `6` yaratıcı |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` görünür · `1` gizli (bağımsız bayraklar) |
| `/synthesis_categories` | `hidden` | `0` görünür · `1` gizli |
| `/pomodoro_records` | `reward` | `0` bırakıldı · `0.5×n` yarım · aksi halde tam kat |
| `/coin_records` `/inventory_records` | `resCode` | Mağaza: `0` satın al · `1` kullan · `2` Görev bitir · `3` bitirmeyi geri al · `4` temizle · `5` vazgeç · `6` gecikmiş · `7` Başarım kilidini aç · `8` vazgeçmeyi iptal · `9` gecikmeyi iptal · `10` iade · `11` alt Görev bitir · `12` alt Görev geri al · `13` kullanıcı Başarımı aç · `14` kullanıcı Başarımını geri al · `15` yatır · `16` çek · `17` domates sat · `20` Eşya Ödülü · `21` Eşya Ödülünü geri al · `23` Sentez · `24` Ganimet Kutusu · `25` ATM faizi · `26` domates takası · `27` kredi faizi · `28` API · `29` efekt stoğu |
| `/exp_records` | `resCode` | Deneyim Puanı (Mağaza `28` değil): `0` bilinmeyen · `1` bitir · `2` Başarım · `3` beğeni takası · `4` gün serisi · `5` adım · `6` bitmiş işaretle · `7` vazgeçmeyi iptal · `8` gecikmeyi iptal · `9` domates ye · `10` Eşya kullanıldı · `11` kullanıcı Başarımı aç · `12` alt Görev bitir · `200` API · `101` bitirmeyi geri al · `102` vazgeç · `103` gecikmiş · `104` kullanılan Eşya borcu · `105` kullanıcı Başarımını kilitle · `106` alt Görev geri al |

`GET /items_categories`, `GET /synthesis_categories` ve `GET /skill_groups` `include_hidden=true` kabul eder (gizli listeler varsayılan olarak hariç tutulur). Başarım kilidini açma koşulları: `GET /achievement_conditions/{id}`. Yetenek `status` (0 normal / 1 gizli) yalnızca `query`/`query_skill` üzerinde, **`GET /skills` üzerinde değil**.

**Method: `GET`**

**Parametreler:**

| Alan | Açıklama | Konum | Tür | Zorunlu | Notlar |
| --- | --- | --- | --- | --- | --- |
| id | Veri ID'si | Path/Query | Number | Evet (ID'ye özel uç noktalar için) | - |
| offset | Sorgu kaydırması | Query | Number | Hayır | Yalnızca bazı sayfalı uç noktalar için gerekli |
| limit | Sayfa boyutu | Query | Number | Hayır | Yalnızca bazı sayfalı uç noktalar için gerekli |
| gid | Tekrarlayan Görev geçmişini filtrele | Query | Number | Hayır | Geçmiş sorgusu için isteğe bağlı |
| include_hidden | Gizli listeleri dahil et | Query | Boolean | Hayır | Varsayılan false. `/items_categories`, `/synthesis_categories`, `/skill_groups` tarafından kullanılır |
| time_range_start | Aralık başlangıcı (ms) | Query | Number | Hayır* | `time_range_end` ile eşleştirilmelidir. Kısmi/geçersiz aralık `invalid_parameter` döndürür |
| time_range_end | Aralık sonu (ms) | Query | Number | Hayır* | `time_range_start`'tan büyük olmalıdır |

**İstek örnekleri**

**Görevler**

```txt
// Tüm Görevler
http://{host:port}/tasks

// Liste ID 1 içindeki Görevler
http://{host:port}/tasks/1

// Geçmiş (indeks 0'dan 100 kayıt)
http://{host:port}/history?offset=0&limit=100

// Görev kategorileri
http://{host:port}/tasks_categories
```

**Eşyalar**

```txt
// Tüm Eşyalar
http://{host:port}/items

// Belirli Eşya ID'leri 1 ve 4'ü sorgula
http://{host:port}/items?id=1&id=4

// Liste ID 1 içindeki Eşyalar
http://{host:port}/items/1

// Eşya kategorileri
http://{host:port}/items_categories
```

**Başarımlar**

```txt
// Liste/kategori ${id} içindeki Başarımlar
http://{host:port}/achievements/${id}

// Başarım kategorileri
http://{host:port}/achievement_categories
```

**Duygular**

```txt
// İndeks 0'dan 100 kayıt
http://{host:port}/feelings?offset=0&limit=100
```

**Özellikler**

```txt
http://{host:port}/skills
```

**Sentez kategorileri**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Sentez tarifleri**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. Görüntü/Dosya API'si

> [!NOTE]
> Android depolama kısıtlamaları nedeniyle LifeUp Cloud, LifeUp'tan görüntü içeriği sunarken kopyalanmış bir dosya oluşturması gerekebilir.

İşlev:

> Veri API'lerinin döndürdüğü görüntü/dosya kaynaklarını yükler (genellikle `content://...`).

İstek URL'si:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Yol parametreleri:**

| Alan | Açıklama | Konum | Tür | Zorunlu | Notlar |
| --- | --- | --- | --- | --- | --- |
| url | Dosya URL'si | Path | String | Evet | - |

**İstek örneği:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Yetenek ContentProvider sorguları

> [!NOTE]
> v1.103.0+ gerektirir

Liste veya yapılandırılmış sorgular için aşağıdaki ContentProvider URI'lerini `http://{host:port}/api/contentprovider` uç noktası üzerinden okuyabilirsiniz.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Yalnızca görünür Yetenekleri döndürür.

| Sütun | Anlam | Tür | Notlar |
| ------ | ------- | ---- | ----- |
| _ID | Yetenek ID'si | number | - |
| name | Yetenek adı | string | - |
| desc | Açıklama | string | Boş olabilir |
| icon | Simge URI'si | string | Boş olabilir |
| order | Ham sıralama | number | `orderInCategory` |
| group_id | Yetenek grubu ID'si | number / null | Yetenek grupta değilse boş olabilir |
| color | Renk | number / null | Boş olabilir |
| exp | Deneyim puanları | number | - |
| level | Mevcut Seviye | number | - |
| until_next_level_exp | Sonraki Seviyeye Deneyim Puanı | number | - |
| current_level_exp | Mevcut Seviyede kazanılan Deneyim Puanı | number | - |
| type | Yetenek türü | number | - |
| status | Yetenek durumu | number | `0` = normal, `1` = gizli |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Yalnızca görünür Yetenek gruplarını döndürür.

| Sütun | Anlam | Tür | Notlar |
| ------ | ------- | ---- | ----- |
| _ID | Yetenek grubu ID'si | number | - |
| content | Grup adı | string | - |
| order | Ham sıralama | number | `orderInCategory` |
| collapsed | Daraltma durumu | string | `true` / `false` metni olarak döndürülür |

<br/>

## Katkı

SDK, LifeUp Cloud ve LifeUp Desktop açık kaynak projelerdir.

Kaynak kodu:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

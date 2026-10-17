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
| **HTTP + kendiniz kurun** | Geliştiriciler, otomasyon kullanıcıları | LAN üzerinden Python, web App'leri veya betiklerle API çağırın ve veri sorgulayın — Android deneyimi gerekmez | [HTTP API başvurusu](/guide/api-reference), [Desktop](guide/api_desktop.md) |
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

## LifeUp Cloud'a bağlanma :id=connect

1. Uyumlu LifeUp ve LifeUp Cloud sürümlerini yükleyin. LifeUp Cloud'u açın ve istendiğinde LifeUp veri/API iznini verin.
2. HTTP hizmetini başlatın. Ağınızda telefona ulaşabilen bir cihazdan, Cloud'un gösterdiği adres ve bağlantı noktasını temel URL olarak kullanın.
3. Cloud belirteci yapılandırdıysanız ham belirteci `Authorization` başlığında gönderin. Bağlantıyı ve yüklü sürümleri denetlemek için `/info` sorgulayın; hem HTTP durumunu hem JSON `code` değerini kontrol edin.

## HTTP API başvurusu :id=http-api-definition

[Tam arayüz ve parametre başvurusu](/guide/api-reference); yol dizini, ortak yanıt/sayfalama kuralları, tam veri modelleri, istek parametreleri ve JSON örneklerini içerir. Entegrasyon oluştururken okuyun. [URL Scheme yöntemleri](/guide/api) tek tek eylemleri, [MCP & Skills](/guide/api_mcp) yapay zekâ ajanı araçlarını açıklar.

### Görev ve geçmiş zaman damgaları :id=task-history-timestamps

[Görev zaman modeline](/guide/api-reference?id=task-times) bakın: `startTime` planlanan başlangıç, `deadline` son tarih, geçmişteki `endTime` ise `status` ile yorumlanan kayıtlı tamamlama/süre aşımı/bırakma zamanıdır.

#### Günlük raporlar ve geçmişin eksiksizliği :id=history-daily-reports

[Geçmiş sayfalaması ve günlük raporlara](/guide/api-reference?id=daily-report), gerçek ödül değişimleri için [EXP/para işlem günlüklerine](/guide/api-reference?id=reward-journals) bakın.

## Katkı

SDK, LifeUp Cloud ve LifeUp Desktop açık kaynak projelerdir.

Kaynak kodu:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

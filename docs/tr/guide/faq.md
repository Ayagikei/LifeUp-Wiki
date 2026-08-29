# SSS

LifeUp, boş zamanlarımızda iki bağımsız geliştirici tarafından sürdürülür:

- Bir geliştirici esas olarak App'i yönetir.
- Bir ekip arkadaşı arka uç hizmetleri ve operasyonlara odaklanır.

## Bağımsız App'in Arkasında

LifeUp'ı 2020'de ilk piyasaya sürdüğümüzde bağımsız App'ler hâlâ nispeten nadirdi. 2026'da bağımsız geliştiriciler ve bağımsız App'ler her yerde — bu harika.

Ancak pek hoş olmayan birçok eğilim de gördük: her bir veya iki ayda bir yeni App çıkarıp lansmandan sonra terk etmek; tamamen yapay zekâ üretimi kodla, gerçek mühendislik olmadan, hatalarla dolu, kötü performanslı ve bakımı imkânsız App'ler; App bitmeden önce onlarca dolardan yüzlere fırlayan agresif hype odaklı fiyatlandırma ve kullanıcıları «ömür boyu» üyelik almaya zorlayan acil forum gönderileri; ya da v1 ömür boyu üyelikle para kazanıp neredeyse hiç bakmayan, sonra aniden v2.0 ile «dirilerek» yeniden ömür boyu üyelik satan App'ler — yalnızca App'in bakımsız kalması, bozulması veya listeden kaldırılması ve ömür boyu üyeliklerin fiilen değersiz kalması.

Buna karşılık LifeUp, uzun vadeli bakımı önemseyen geliştiriciler tarafından inşa edilir: 400'den fazla sürümle ~6 yıllık kesintisiz yineleme. Tek seferlik satın alma modelinde kaldık ve yıllar içindeki mütevazı ayarlamalardan sonra bile fiyatlarımız çoğu benzer App'in çok altında kaldı. LifeUp ayrıca benzersiz şekilde bir [API](/guide/api.md) ve [açık kaynak masaüstü istemcisi](/guide/api_desktop.md) sunar; böylece LifeUp'ı yapay zekâ ve kendi geliştirme becerilerinizle kendi iş akışlarınıza entegre edebilir — hatta üzerine inşa edebilirsiniz. LifeUp ayrıca orijinal medya dosyalarınız ve bir SQLite veritabanını içeren tam veri dışa aktarma yedeklemelerini destekler — verileriniz her zaman size aittir ve siz kontrol edersiniz. Diğer App'lerle uyumlu biçimlere dönüştürebilir, yapay zekâ ile analiz ettirip grafikler üretebilir ve daha fazlasını yapabilirsiniz (bunların hepsi API ile de — ve genelde daha doğrudan — mümkündür). Yedeğinizi doğrudan yeni iOS App'imiz [ulives](https://app.ulives.io/) içine de aktarabilirsiniz.

Bazı özellikler ve arayüz ayrıntıları hâlâ cilalanıyor; bunları adım adım iyileştiriyoruz.

LifeUp size yardımcı oluyorsa, başkalarıyla paylaşmanız bizim için de büyük bir destek olur.

Geliştirmeyi desteklemek isterseniz App'in **About** sayfasından bize kahve de ısmarlayabilirsiniz.

## ⚙️ Uyumluluk Yapılandırması

Şu gibi sorunlarla karşılaşırsanız:

- hatırlatıcıların tetiklenmemesi
- Pomodoro hatırlatıcılarının veya Eşya geri sayımlarının arka planda çalışmaması
- widget eylemlerinin başarısız olması (örneğin sayım Görevlerini işaretleyememe)
- widget yenileme sorunları

lütfen uyumluluk kılavuzunu okuyun:

> [!WARNING]
> [Uyumluluk yapılandırması](/guide/compatibility.md)

## 🌍 Genel

<details>
<summary>İade politikası</summary>

LifeUp, tarihsel nedenlerle şu anda Google Play'de ücretli App olarak listelenir; bu da indirme sonrası ödeme modeline geçişi zorlaştırır.

Satın aldıktan kısa süre sonra kaldırırsanız Google Play siparişinizi otomatik olarak iade edebilir.

Bu otomatik iade gerçekleşmezse, **7 gün** içinde [lifeup@ulives.io](mailto:lifeup@ulives.io) adresinden bize ulaşın.
Lütfen GPA sipariş numaranızı ekleyin ve e-postayı satın almada kullandığınız Google hesabından gönderin.

Kötüye kullanımı önlemek için kullanıcı başına yalnızca **bir kez** manuel iade desteği sağlayabiliriz.
Satın alma tarihinden 7 gün sonra iade taleplerini işleyemeyiz.

Not: Google Play yorumları iade işlemi için yeterli sipariş ayrıntısını içermez.

</details>

<details>
<summary>Verilerim gizli ve güvende mi?</summary>

Evet. Gizliliği ciddiye alıyoruz.

Verilerin çoğu cihazınızda kalır ve sunucularımızdan geçmez.

Ana istisna, kullanıcıların tasarım ve şablonları herkese açık paylaşabildiği Dünya modülüdür.
Oradaki tüm paylaşım isteğe bağlıdır: paylaşmayı seçmediğiniz sürece hiçbir şey yayınlanmaz ve paylaşılan içeriği istediğiniz zaman silebilirsiniz.

Daha fazlasını [Gizlilik Politikamızda](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms) okuyabilirsiniz.

</details>

<details>
<summary>Sunucular veri saklamıyorsa verilerimi nasıl yedeklerim?</summary>

LifeUp hem dışa/içe aktarma yedeklemelerini hem de bulut tarzı yedekleme hedeflerini destekler.

Şunları kullanabilirsiniz:
- Dışa aktarılmış yedek dosyaları
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Neden XX dili yok? Ya da çeviri neden eksik ve İngilizce görünüyor?</summary>

*LifeUp*'taki dillerin çoğu topluluk tarafından sürdürülür.

2026'dan itibaren temel kaliteyi artırmak ve güncellemeleri hızlandırmak için büyük dillerde yapay zekâ çevirisi kullanacağız.

Topluluk düzeltmeleri ve proofreading hâlâ çok memnuniyetle karşılanır.

Buradan katkıda bulunabilirsiniz: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Dünya modülüne ihtiyacım yoksa gizleyebilir miyim?</summary>

Evet.

Alt gezinme çubuğunu şuradan özelleştirebilirsiniz:
`kenar çubuğu` → `Ayarlar` → `Görüntüle` → `Modül Yapılandırması`.

Oradan Dünya modülünü gizleyebilir veya başka bir modülle değiştirebilirsiniz.

</details>

<details>
<summary>Adım sayacı hatalı veya bu modüle ihtiyacım yok?</summary>

> Nasıl çalıştığını görmek için App'te adım sayacının yanındaki küçük soru işareti simgesine dokunun.

- Daha iyi doğruluk için App'i sabah ve akşam açın ve sık cihaz yeniden başlatmalarından kaçının.
- Adım sayısını manuel de girebilirsiniz.
- İhtiyacınız yoksa adım sayacını `Ayarlar` → `Görüntüle` altında gizleyin.

</details>

## ✅ Görevler

<details>
<summary>Bir Görevi tamamlarken ödül iletişim kutusunu gizleyebilir miyim?</summary>

Evet. Normal tamamlama akışında ödül iletişim kutusu yalnızca Deneyim Puanı veya Eşyalar gibi ödüller yapılandırılmışsa görünür. Ödülleri boş bırakırsanız Görevi tamamlarken bu iletişim kutusu görünmez.

Ayrıca bir etkinliği birçok küçük Göreve bölmek yerine mantıklı bir tamamlama aralığı seçmenizi öneririz. Bu hem kurulum işini hem de tamamlama eylemlerinin sayısını azaltır.

Ödülleri tutup tamamlama iletişim kutularını atlamak isterseniz şu seçeneklerden birini kullanabilirsiniz:

- **Quick Complete:** Görev listesinin sağ üst köşesinde `Hızlı Tamamlama`'i etkinleştirin. Etkinleştirildikten sonra daireye dokunmak Görevi ödül iletişim kutusu göstermeden doğrudan tamamlar.
- **Kaydırarak tamamla:** `kenar çubuğu` → `Ayarlar` → `Görev` → `Swipe` → `Kart Kaydırma Eylemi` yolunu izleyin. `Sola Kaydır` veya `Sağa Kaydır` seçin, ardından eylemi `Bitir (Diyalog Yok)` olarak ayarlayın.

Her iki iletişim kutusu olmayan seçenek de yapılandırılmış ödülleri verir; ancak Duygular girişi ve otomatik Eşya kullanımı dahil diğer tamamlama iletişim kutularını da atlar.

</details>

<details>
<summary>Tamamlanan bir Görevi nasıl geri alırım?</summary>

Tamamlamayı birkaç yerde geri alabilirsiniz:

1. Tamamladıktan hemen sonra alttaki istemde **Undo**'ya dokunun.
2. `kenar çubuğu` → `Geçmiş` altında `Geri al`'ya dokunun.
3. `Takvim` → `Sona Erdi` altında `Geri al`'ya dokunun.

Görev son tarihi geçtiyse doğrudan geri alma kullanılamaz.
Bu durumda kayıt durumunu düzenleyin (örneğin gecikmiş veya bırakılmış olarak ayarlayın).

</details>

<details>
<summary>Gecikmiş bir Görevi tamamlandı olarak nasıl işaretlerim?</summary>

Bir Görev geciktiğinde gecikme iletişim kutusu görünür ve tamamlandı olarak işaretlemenize izin verir.

İletişim kutusunu kapattıktan sonra Görev durumunu şuradan güncelleyebilirsiniz:
- `kenar çubuğu` → `Geçmiş`
- `Takvim` → `Sona Erdi`

</details>

<details>
<summary>Görev başarısızlığı için Deneyim Puanı/coin cezası var mı?</summary>

Evet.

- Deneyim Puanı cezası varsayılan olarak etkindir (faktör: `0.2x`).
- Coin cezası varsayılan olarak devre dışıdır (faktör: `0`).

Genel ayarları şuradan değiştirebilirsiniz:
`kenar çubuğu` → `Ayarlar` → `Gelişmiş`

Görev düzenleyicide Görev başına ceza da ayarlayabilirsiniz.

</details>

<details>
<summary>Tekrar mekanizması nasıl çalışır?</summary>

Yalnızca **ilk** döngünün `Başlangıç Zamanı`, `deadline`, tekrar sıklığı ve isteğe bağlı hatırlatma saatini ayarlayın.

LifeUp sonraki döngüleri otomatik hesaplar.

</details>

<details>
<summary>Bir dönem içinde düzensiz olarak N kez tamamlanması gereken bir Görevi nasıl kurarım?</summary>

LifeUp'ta henüz «döngü başına en az/en fazla N kez» için doğrudan bir ayar yok. Ancak bunu birkaç yolla başarabilirsiniz:

| Yöntem | Kurulum | Artılar | Eksiler |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Sıklığı `Haftalık` yapın, `Sayım Görevi`'i etkinleştirin, sayıyı ayarlayın (ör. 3). | Basit kurulum; ilerleme net (ör. 1/3). | **Ödüller yalnızca son sayım tamamlandıktan sonra verilir.** Bireysel tamamlamalar için ödül yok. |
| **Infinite Task + Target** | Sıklığı `Sınırsız`, hedef sayıyı 3, son tarihi Pazar yapın. | **Her tamamlamada ödül verilir.** | **Her hafta manuel yeniden oluşturulmalıdır** (Görev tamamlandıktan sonra sona erer). |
| **Alt Görevler** | Sıklığı `Haftalık` yapın, içine 3 alt görev ekleyin. | Her tamamlama için ayrı ödül ve hatırlatıcı ayarlanabilir. | Alt görevleri işaretlemek için ayrıntı sayfasına girmek gerekir; tek tek manuel oluşturulmalıdır (yalnızca küçük sayılar için uygun). |
| **Infinite Task (Yalnızca İstatistik)** | Sıklığı `Sınırsız` yapın. | En kolay kurulum; her tamamlamada ödül ve istatistik. | **Zorunlu kısıt yok.** Haftalık hedefe ulaşıp ulaşmadığınızı manuel kontrol etmelisiniz. |

> [!NOTE]
> **Counting Task**'ler için «Gerçek Zamanlı Ödül» özelliğini (her sayımda anında ödül) değerlendiriyoruz; şu anda değerlendirme aşamasındadır.

</details>

<details>
<summary>Tamamlanan veya başlamamış Görevleri nasıl gizlerim?</summary>

Bu genelde şu durumlardan birinde olur:

1. Görev `xx deadline` gösteriyorsa, o Görev zaten başlamıştır.
   - Görevi düzenleyin ve gerekirse `Başlangıç Zamanı`'ı ayarlayın.

2. Görev `xx starts` gösteriyor ve tarih bugün değilse:
   - Alttaki katlama düğmesinin kapalı olup olmadığını kontrol edin.
   - Sağ üst menüyü (`...`) açın → `Filtre`.
   - `Bugünü Göster`'in etkin olduğunu doğrulayın.

> Not:
> - Akıllı listeler (hafta/ay) katlamayı desteklemez.
> - Tekrarlayan Görevlerde varsayılan olarak bir tam döngü geçerlidir. Örneğin 21 günlük bir döngü o 21 günün herhangi birinde tamamlanabilir. Yalnızca sona yakın görünmesini istiyorsanız başlangıç saatini bir kez ayarlayın; LifeUp sonraki döngüleri otomatik hesaplasın.

</details>

<details>
<summary>Görevlerin gece yarısı gecikmiş sayılmasını nasıl önlerim?</summary>

Gecikme zamanlaması Görev son tarihi saatiyle kontrol edilir.

Son tarih gününü ayarladıktan sonra `time` düğmesine dokunun ve daha geç bir saat seçin.

Örneğin bir Eşyanın `00:00`'da süresinin dolmasını istemiyorsanız son tarih saatini `02:00` (ertesi gün) gibi bir değere ayarlayın.

Genel varsayılanları şuradan da değiştirebilirsiniz:
`Ayarlar` → `Item` → `Yeni Görevler İçin Varsayılan Ayarlar`

(Varsayılanları değiştirmek mevcut Eşyaları etkilemez.)

</details>

<details>
<summary>Hedef tekrar sayısı neden 1/N'den başlıyor?</summary>

Sayım Görevlerinden farklı olarak, (1/N) **burada toplam ilerlemeyi temsil etmez.**

Bunun yerine **mevcut tekrar sayısını gösterir. Bu tekrarın tamamlanıp tamamlanmadığı ⚪ veya ✅ ile belirtilir.**

<br/>

Örneğin ⚪1/10 şu anlama gelir:
Bu Görev toplam 10 kez tekrarlanacak (toplam 10 kart oluşturulacak) ve şu anda 1. tekrardadır, tamamlanmamıştır.

Ve ✅1/10 şu anlama gelir:
Mevcut kart 1. tekrara aittir ve tamamlanmıştır.

Toplam ilerleme kullanılsaydı, tamamlanan kartlar ⚪1/10 ve ✅1/10 gibi kafa karıştırıcı durumlar gösterirdi. Ayrıca hedefe ulaşıldığında kartlar kaybolabilirdi (ör. ✅9/10), bu da sezgisel değildir.

</details>

<details>
<summary>Bir Görev için birden fazla hatırlatıcı nasıl ayarlarım?</summary>

Alt görevler oluşturun ve her birine farklı hatırlatıcı açıklaması/saati atayın.

Ana Görev için birden fazla hatırlatıcıyı simüle etmenin önerilen yolu budur.

</details>

<details>
<summary>Alt görevler doğrudan Görev listesinde gösterilebilir mi?</summary>

Şu an değil. Gelecek güncellemelerde değerlendirebiliriz.

</details>

## 🎁 Ödüller (Deneyim Puanı, Eşyalar)

<details>
<summary>Bir Görev için farklı Özelliklere farklı Deneyim Puanı değerleri atayabilir miyim?</summary>

Mevcut sürümde doğrudan değil.

Hızlı kurulum için bir Görev şu anda Özellik başına bir Deneyim Puanı değeri kullanır. Özelliğe göre farklı Deneyim Puanı değerleri gerekiyorsa şu geçici çözümü kullanın:

1. Bir Eşya oluşturun.
2. O Eşyada farklı Özellikler için farklı Deneyim Puanı etkileri yapılandırın.
3. Eşyayı Görev tamamlandıktan sonra otomatik kullanılacak şekilde ayarlayın.

Bu, Görev tamamlama + Eşya etkisini birleşik bir ödül hattı olarak sunar.

Gelecek sürümlerde yerel desteği iyileştirmeyi planlıyoruz.

</details>

<details>
<summary>Deneyim Puanı ve coin otomatik nasıl hesaplanır?</summary>

Deneyim Puanı esas olarak şunlara bağlıdır:
- `Zorluk`
- `Önem`
- `number of selected attributes`

Coin esas olarak şunlara bağlıdır:
- `Zorluk`
- `Önem`

</details>

<details>
<summary>Yaşam Seviyesi nasıl hesaplanır?</summary>

Yaşam Seviyesi Deneyim Puanı, herhangi bir Özellikten kazanılan Deneyim Puanıyla pozitif ilişkilidir.

Ceza uygulandığında Yaşam Seviyesi Deneyim Puanı da orantılı azalır.

Yaşam Seviyesi geniş, birleştirilmiş bir gösterge olarak tasarlanmıştır; formüle aşırı odaklanmanızı önermeyiz.

En önemlisi genel uzun vadeli ilerlemenizi yansıtmasıdır.

Formül referansı: Deneyim Puanı kazanma/kaybetme eyleminin her biri, o eylemde kaç Özellik ödüllendirilirse ödüllendirilsin Yaşam Seviyesi Deneyim Puanına 1/5 katkıda bulunur.

</details>

<details>
<summary>Görevler için özel Deneyim Puanı ve coin ödülleri ayarlayabilir miyim?</summary>

Evet.

Görev veya Başarım oluştururken ilgili ödül düğmesine dokunun ve değerleri manuel yapılandırın.

</details>

<details>
<summary>Eşya görselleri neden eksik veya görüntülenmiyor?</summary>

LifeUp çevrimdışı önceliklidir; Eşya görselleri cihazınızda yerel olarak saklanır.

Görseller eksikse son zamanlarda ne olduğunu kontrol edin:

**Yedek içe aktardıktan sonra:**
- Yedek görsel dosyalarını içermeyebilir.
- Görselleri içeren tam bir yedeği yeniden içe aktarın.

**Temizlik/dosya yönetimi işlemlerinden sonra:**
- LifeUp görsel dosyalarını aktif olarak silmez.
- Geniş izinlere sahip üçüncü taraf temizleyici/dosya araçları bunları yanlışlıkla silebilir.
- Bu tür araçları dikkatli kullanın.

**Dünya'dan içe aktarılan Eşyalar için:**
- Geçici bir ağ yükleme sorunu olabilir.
- Daha sonra tekrar deneyin veya yerel görsellerle değiştirin.

Görselleri içeren eski bir yedeğiniz hâlâ varsa, önce o yedeği geri yükleyerek medyayı kurtarabilir, ardından en son veri yedeğinizi geri yükleyebilirsiniz.

</details>

<details>
<summary>Mağaza Eşyasını nasıl silerim?</summary>

`Dükkan` sayfasında Eşyaya uzun basın, ardından üstteki `Sil` düğmesine dokunun.

</details>

<details>
<summary>Deneyim Puanı ve coin'i nasıl temizlerim?</summary>

Şuraya gidin:
`kenar çubuğu` → `Ayarlar` → `Veri Yedekle/Geri Getir/Sil`

Deneyim Puanı ve coin değerlerini orada temizleyebilirsiniz.

Not: çevrimiçi özellikler kullanıyorsanız ilgili sunucu tarafı görüntüleri kısa sürede yenilenmeyebilir.

</details>

<details>
<summary>Özellikler için Seviye üst sınırları ve Deneyim Puanı gradyanları nelerdir?</summary>

Sınırsız Seviyeler olarak kabul edilebilir (şu anda 2000+, normal yollarla ulaşılması zor).

Her Seviye için gereken Deneyim Puanı artar; mevcut gradyan dik olsa da. (Bu nedenle ödüller yalnızca Seviye üst sınırlarına göre değerlendirilmemeli; Deneyim Puanı üst sınırı yaklaşık 2^63'tür).

Aslında birçok kullanıcı uzun süre 2500 Deneyim Puanı gradyanında kalır. Gelecekte Seviye sistemini optimize edebilir veya özelleştirmeye izin verebiliriz. (Toplam Deneyim Puanı etkilenmez).

| Seviye    | Her Seviye İçin Gerekli Deneyim Puanı |
| -------- | ----------------------------------------- |
| 1 → 2     | 300                                       |
| 2 → 3     | 700                                       |
| 3 → 4     | 1500                                      |
| 4 → 99    | 2500                                      |
| 99 → 150  | 5000                                      |
| 150 → 200 | 7500                                      |
| 200 → 250 | 15000                                     |
| 250 → 300 | 30000                                     |
| 300 → 325 | 50000                                     |
| 325 → 350 | 100000                                    |
| >350     | 500000                                    |

</details>

<details>
<summary>Kredi, ATM faizi ve kredi faizini nasıl yapılandırırım?</summary>

`Dükkan` sayfasında sağ üst menüyü (`...`) açın ve `Ayarlar`'i seçin.

</details>

<details>
<summary>Özellikleri veya Yetenekleri nasıl özelleştiririm?</summary>

Şuraya gidin:
`kenar çubuğu` → `Ayarlar` → `Özel Ayarlar` → `Nitelikleri Özelleştir`

Mevcut Özellikleri özelleştirebilir, Yetenekler için yeni Özellikler oluşturabilir ve gerektiğinde Özellikleri silebilirsiniz.

Yetenekleri takip etmek istiyorsanız Yetenek adında Özellikler oluşturun (örneğin `Fishing` veya `Programming`).

</details>

<details>
<summary>Spor ödülleri veya Dünya beğeni ödülleri tarafından kullanılan Özellikleri değiştirebilir miyim?</summary>

Mevcut sürümde değil.

Bu yerleşik ödül eşlemeleri şimdilik sabittir.

</details>

<details>
<summary>Ganimet Kutusu ödüllerini nasıl kurarım?</summary>

Mağaza Eşyası oluştururken o Eşyaya `Ganimet Kutusu` etkisi ekleyin.

Ardından o etkide ödül havuzu, olasılık ve ilgili ayarları yapılandırın.

</details>

<details>
<summary>Ganimet Kutusu olasılığını %1'in altına ayarlayabilir miyim?</summary>

Evet.

Ganimet Kutusu etkisini yapılandırdıktan sonra olasılık ayrıntıları ve kurulum rehberi için App içindeki `?` yardım düğmesine dokunun.

</details>

<details>
<summary>Daha fazla simgeyi nasıl edinebilirim?</summary>

Küçük bir bağımsız ekibiz ve şu anda büyük yerleşik bir simge setini sürdüremiyoruz.

Daha fazla simgeyi şu yollarla edinebilirsiniz:

1. `Dünya` → `Pazar`'ten Eşyalar içe aktarın ve simgelerini yeniden kullanın.
2. Harici simge kaynaklarını kullanın (kullanım haklarının geçerli olduğundan emin olun):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Mümkünse App içinde daha iyi görüntüleme için şeffaf arka planlı simgeleri tercih edin.

</details>

<details>
<summary>Ürün görselleri görüntülenemiyorsa veya eksikse ne yapmalıyım?</summary>

LifeUp çevrimdışı bir App'tir. Ürün görselleri cihazınıza kaydedilir ve App'in özel dizininde güvenle saklanır. Cihazınızdaki dosya değişikliklerini doğrudan inceleyemeyiz.

Ürün görselleri kaybolduysa veya görüntülenemiyorsa, son zamanlarda hangi işlemleri yaptığınızı düşünün:

**Yedek geri yükledikten sonra görseller eksikse:**
- Bu genelde yedek dosyasının görsel dosyalarını içermemesinden kaynaklanır
- Görsel dosyalarını içeren tam bir yedeği yeniden içe aktarmanız gerekir

**Görseller yanlışlıkla silindiyse:**
- LifeUp görsel dosyalarını proaktif olarak silmez
- Son zamanlarda görsel yönetimi özelliğini kullandıysanız görselleri yanlışlıkla silmiş olabilirsiniz; yedekten geri yüklemeyi deneyin
- Ayrıca yüksek izinlere sahip bazı sistem temizleme App'leri görsel dosyalarını da silebilir; bu App'leri dikkatli kullanın
- Görselleri içeren eski bir yedeğiniz varsa önce mevcut veriyi yedekleyin, ardından görselleri almak için eski yedeği geri yükleyin, sonra mevcut verinizi geri yükleyin

**Dünya modülünden içe aktarılan ürün görselleri görüntülenemiyorsa:**
- Bu ağ sorunlarından kaynaklanabilir
- Daha sonra tekrar deneyin veya ürün görselini yerel bir görselle değiştirin

**Nadir durumlarda sistem kusurları görsel kaybına yol açabilir:**
- Bildiğimiz kadarıyla bazı üreticilerin özelleştirilmiş sistem sürümlerinde kusurlar vardı: App tekrar tekrar çöktüğünde App verilerini yanlışlıkla temizleyebilir ve veri ile görsel dosyaları kaybolabilir. Sisteminizi güncel tutun. Ayrıca App'in kontrolü dışında anormal sorunlara yol açabilecek sistem kusurlarının hâlâ olabileceğini dışlayamayız. Sık yedekleme öneririz
- Aşırı durumlarda kararsız cihaz depolaması veya donanım sorunları da görsel dosyası kaybına yol açabilir. Düzenli bulut yedeklemesi veya cihaz değişimi düşünün

</details>

## ⏰ Hatırlatıcı / Pomodoro / Geri Sayım

<details>
<summary>Mağaza Eşyası geri sayım etkisini nasıl kullanırım?</summary>

Geri sayım etkileri App bildirimleri olarak iletilir.

Önce LifeUp için bildirim izninin etkin olduğunu doğrulayın.

</details>

<details>
<summary>Pomodoro otomatik sonrakini destekliyor mu?</summary>

Şu an değil.

Yukarı sayım zamanlayıcı modunu deneyebilirsiniz.

Pomodoro modunda bir çalışma oturumu bittiğinde zamanlayıcı yukarı saymaya devam eder. Ardından Odak kayıtlarına ek süre ekleyip eklemeyeceğinize karar verebilirsiniz. Otomatik sonraki, bu iş akışıyla çakışır.

</details>

<details>
<summary>Pomodoro'yu Görev listesinden hızlıca nasıl başlatırım?</summary>

Şunları yapabilirsiniz:
1. Bir Göreve uzun basın ve eylem menüsünde `Zamanlayıcı`'a dokunun.
2. Ya da `Görevler` ayarlarında kaydırma eylemini `Zamanlayıcı` olarak yapılandırın.

</details>

<details>
<summary>Pomodoro, özel Pomodoro App'leri gibi özet istatistikler sunuyor mu?</summary>

Henüz değil.

LifeUp'ın Pomodoro'su hâlâ erken aşamada geliştirilen hafif bir modüldür.

Şu an mevcut olanlar:
- Oturum başına ayrıntılı kayıtlar
- `Durum` sayfasında temel günlük özet istatistikleri

</details>

## 💾 Yedekleme ve Geri Yükleme

<details>
<summary>Verileri nasıl yedeklerim?</summary>

Lütfen önce [Yedekleme ve Geri Yükleme Kılavuzunu](/guide/backup.md) okuyun.

Kısaca, desteklenen yedekleme yöntemleri:
- Google Drive (önerilen)
- Dropbox
- Yedek dosyalarını dışa aktarma
- WebDAV sunucuları

</details>

<details>
<summary>LifeUp neden çevrimdışı öncelikli bir App olarak tasarlandı?</summary>

LifeUp tasarım gereği çevrimdışı öncelikli bir mimari izler.

Bu şu anlama gelir:
- Verileriniz size aittir ve siz kontrol edersiniz.
- Açıkça yedekleme/senkronizasyon seçeneği seçmediğiniz sürece veriler yerelde kalır.
- Çoğu temel özellik ağ erişimi olmadan da çalışır.

İstemci temel mantığı yerelde işlediği için ağ veya sunucu kullanılabilirliği sınırlı olsa bile (Dünya modülü gibi çevrimiçi özellikler hariç) LifeUp'ı kullanmaya devam edebilirsiniz.

</details>

## 🧭 Planlama

<details>
<summary>Yapay zekâ özellikleri ekleyecek misiniz?</summary>

LifeUp, küçük bir ekip tarafından sürdürülen düşük maliyetli, tek seferlik satın alma bir App'tir. Hazır yapay zekâ özelliklerini doğrudan App'e gömmek (API maliyetlerini biz karşılayarak) fiyatlandırma modelimizle gerçekçi değil — abonelik modeline geçmeden veya modern yapay zekâ App işletme maliyetlerine uyacak şekilde tek seferlik fiyatı birkaç kat artırmadan. Bunu yapmayacağız.

Buna rağmen LifeUp doğası gereği yapay zekâ dostudur:

1. [API](/guide/api.md) ve çoğu temel işlevi erken açığa çıkardık; bu da onu yapay zekâ ajanları ve üçüncü taraf araçlarla doğal olarak uyumlu kılar. Ajan yeteneklerine sahip yapay zekâ araçları LifeUp özelliklerini doğrudan çağırabilir — Görev, Eşya oluşturma ve daha fazlası. Aslında birçok kullanıcının yapay zekâyı API'mizle birleştiren iş akışlarını paylaştığını gördük; özel LifeUp API MCP sunucuları, yapay zekâ üretimli günlük kayıtları için otomasyon araçları ve daha fazlası dahil.

2. Gelecekte BYOK (Bring Your Own API Key) yapay zekâ yetenekleri sunmayı planlıyoruz. Böylece sürekli API maliyetlerini biz karşılamadan kendi anahtarınızla yapay zekâ özelliklerini kullanabilirsiniz.

3. Sonuçta yapay zekâ sihir değildir — aksi halde yapay zekâyı API'mizle eşleştirerek tam entegrasyonu kendiniz de kolayca sağlayabilirsiniz.

</details>

<details>
<summary>LifeUp'ın iOS sürümü olacak mı?</summary>

**2025**'te iOS kullanıcıları için (iPadOS ve Apple Silicon Mac'te de) yeni çapraz platform verimlilik App'i [ulives](https://app.ulives.io/)'ı piyasaya sürdük.

LifeUp'ın doğrudan iOS'a port edilmesi gerçekçi değil:

- LifeUp yerel Android teknolojisiyle inşa edilmiştir.
- Çevrimdışı öncelikli mimarisi arayüzü, yerel veri modelini ve iş mantığını Android uygulamasına sıkı bağlar.
- Doğrudan port, veri ve mantığı tutarlı tutmak için yine de büyük yeniden yazımlar gerektirir.

Bu yüzden ulives ile çapraz platform yönünde yeniden organize edip yeniden inşa ettik.

ulives, LifeUp'ın temel ruhunu korurken önceki nesillerden gelen birçok uzun süredir devam eden tasarım ve ürün sorununu da ele alır. Bunu bire bir klon değil, taze bir evrim olarak düşünebilirsiniz.

**LifeUp üyeliği ulives'ı açmaz**, ancak LifeUp yedeği içe aktarabilirsiniz (tek yönlü, kayıplı olabilir). Bkz. [ulives nedir?](/guide/faq?id=ulives_overview). Daha ayrıntılı nedenler için karşılaştırma belgesine bakın: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>ulives nedir? LifeUp üyeliği veya verisi paylaşılıyor mu?</summary>


[ulives](https://app.ulives.io/) çapraz platform (KMP) teknolojisi üzerinde **sıfırdan bir yeniden yazımdır**. LifeUp'ın oyunlaştırma felsefesini devralır; ancak kod tabanı, ekip, fiyatlandırma ve uzun vadeli planlar ayrıdır — ruhani bir devam, LifeUp'ın iOS portu **değildir**.

**Üyelikler neden ayrı?**

- **LifeUp fiyatlandırması yalnızca Android kapsamını yansıtır:** LifeUp her zaman saf Android yerel teknolojisiyle inşa edilmiştir. Çok düşük ömür boyu üyelik fiyatı **yalnızca bir Android istemcisi olması** etrafında tanımlandı — gelecekte inşa edebileceğimiz her App için bakımı satın almak anlamına gelmiyordu.
- **ulives fiyatlandırması çapraz platform maliyetini ve uzun vadeli sürdürülebilirliği yansıtır:** ulives tam bir yeniden yazımdır; çapraz platform kod tabanı, tam birleşmemiş bir ekip ve iOS ile gelecekteki Android ve HarmonyOS hedefleri için süregelen çalışma vardır. Premium, LifeUp'ın tarihsel ücretsiz/ücretli ayrımını kopyalamakla değil, **sürdürülebilir geliştirme ve uzun vadeli sürdürülebilirlik** ile tanımlanır.
- **Farklı geliştirme ekipleri:** LifeUp iOS portu çeşitli nedenlerle yavaş ilerledi. ulives için özel bir ekip yeniden organize ettik (bugün hâlâ küçük) ve çapraz platform ürünü daha hızlı ve esnek şekilde sunmak için.
- **Ayrı mağaza ekosistemleri:** App Store ve Google Play bağımsız ödeme ve yetkilendirme sistemleridir. Lisanslar iki App arasında doğrudan aktarılamaz.

**Kısaca:**

- **LifeUp üyeliği ↔ ulives üyeliği aktarılmaz:** Google Play'deki LifeUp satın alımı App Store'da ulives'ı **açmaz** ve tersi de geçerlidir. Her App kendi satın alımını gerektirir.
- **Tek yönlü veri içe aktarma:** ulives 1.7.22'den itibaren LifeUp yedeğini (`.lfbak`) ulives'a aktarabilirsiniz. Dönüşüm kayıplı olabilir ve içe aktarma LifeUp'a **geri aktarılmaz**.
- **İçe aktarma lisansınızı aktarmaz:** Yedekler kullanım verilerini (Görevler, Eşyalar vb.) taşır; LifeUp üyelik haklarını taşımaz.

**ulives platformları arasında ulives Premium:**

ulives kendi **Android** istemcisini (ve HarmonyOS yerel desteği vb.) de sunacak. **ulives için satın alınan Premium, sunucu tarafı hesap yönetimi hazır olduğunda tüm ulives platformlarında** — iOS, Android, HarmonyOS — çalışması amaçlanır. Erken çapraz platform durumlarında bizimle iletişime geçmeniz gerekebilir.

**Her iki App de ömür boyu üyeliği çoğu benzer ürünün çok altında sunar** — ancak başlık fiyatları bağlamında okunmalıdır: tek platform vs çapraz platform kapsamı, geliştirme maliyeti ve uzun vadeli bakım farklıdır.

Daha ayrıntılı nedenler (fiyatlandırma modeli, sürdürülebilirlik, geliştirme yatırımı ve her iki App için gelecek planları) için karşılaştırma belgesine bakın: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup). ulives SSS: [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 Hâlâ Yardıma mı İhtiyacınız Var?

<details>
<summary>Bize ulaşın</summary>

[lifeup@ulives.io](mailto:lifeup@ulives.io) adresinden bize ulaşabilirsiniz.

GitHub'da issue da açabilirsiniz:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Bizi desteklemek ister misiniz?</summary>

LifeUp'ı desteklediğiniz için teşekkürler.

LifeUp size yardımcı olduysa bizi iki basit yolla destekleyebilirsiniz:

1. App'in **Google Play sürümündeki** **About** sayfasından bize kahve ısmarlayın.
2. Deneyiminizi paylaşarak daha fazla kişinin LifeUp'ı keşfetmesine yardımcı olun:
   - LifeUp'ı arkadaşlarınıza önerin
   - Kullanım hikayelerinizi ve iş akışlarınızı paylaşın
   - İpuçları, kılavuzlar veya eğitimler paylaşın

</details>

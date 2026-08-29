# 2024-2025 Geliştirme Planı

!> Bu güncel geliştirme planımızdır. Ürün iyileştirmelerini ve yükseltmelerini bu plana göre yönlendirmek için elimizden geleni yapacağız. Ancak sürekli değişen ortam nedeniyle geliştirme planındaki içerik değiştirilebilir veya eklenebilir/çıkarılabilir. Kesin ürün sürümü esas alınır.

### I. Geliştirme Planı

> Güncelleme: 2025/09/14

| Modül | Alt işlev | Gereksinim Nedeni | Öncelik | Sonuç |
| ---- | ------ | -------- | ------ | ---- |
| Temel Yetenekler (1) | Çoklu seçim Eşyalar ve edinildiğinde otomatik kullanma | ~ | P0 | ✅ v1.94'te çoklu seçim yayınlandı<br/>✅ v1.96'da otomatik kullanma yayınlandı |
| Temel Yetenekler (2) | Genelleştirilmiş Ödül açılır penceresi (herhangi sayıda Özellik ve Eşya desteği) | ~ | P0 | ✅ v1.96'da yayınlandı; ayarlar gelecek sürümlerde gevşetilecek |
| Temel Yetenekler (3) | Ses kaynağı yönetimi ve Eşya ses efektleri | ~ | P0 | ✅ Yayınlandı |
| Temel Yetenekler (4) | Bildirim optimizasyonu | ~ | P0 | ✅ Yayınlandı |
| Büyük Ekran Uyarlaması (tablet/katlanabilir) | Activity embedding'e dayalı tablet ve katlanabilir uyarlama | ~ | P1 | ✅ v1.95'te bekleniyor |
| Widget'lar | Widget genişletmesi (Envanter widget'ı) | ~ | | ✅ v1.94'te yayınlandı |
| Takvim Entegrasyonu | - Google Takvim Çift Yönlü Senkronizasyon<br/>- Sistem Takvimi Çift Yönlü Senkronizasyon | - Yurt dışından çok geri bildirim.<br/>- LifeUp, program (takvim) App'leriyle örtüşen ancak tutarsız işlevlere sahip bir yapılacaklar aracıdır. | P1 | 🚧 |
| API | - Tüm temel işlevleri kapsayacak şekilde API yeteneklerini genişletme<br/>- Masaüstü istemci özellik tamamlama, yedekleme/geri yükleme vb. desteği | - Düzenleme gibi birçok API hâlâ eksik.<br/>- LifeUp her şeyi kapsayamaz, ancak API özelleştirme ve genişletmeye olanak tanır. | P1 | 🚧 v1.98.x'te bekleniyor |
| Başarımlar | - Tekrar türü Başarımlar | ~ | P2 | ✅ Yayınlandı |
| Veri Sistemi | - Veri ve görsellerin ayrı yedeklenmesi<br/>- Kısmi veri dışa/içe aktarma desteği<br/>- Yerleşik çoklu dosya geçişi desteği | - WebDAV büyük dosya yüklemelerinde kolayca başarısız olur.<br/>- Kısmi dışa/içe aktarma Ödül sistemlerini paylaşmak için kullanılabilir.<br/>- Yerleşik çoklu dosyalar veriyi temizlemeden kolay test için. | P1 | 🚧 |
| Çoklu platform (Flutter yönü) | - Flutter ile çapraz platform sürümü geliştirmeyi öğrenmeye ve kullanmaya devam | - iOS sürümü prototip geliştirme | P2 | 🚧 Duraklatıldı |
| Çoklu platform (KMP yönü) | - KMP kullanarak daha fazla olasılık keşfetme | - Gelecek için KMP teknolojisini keşfetme ve öğrenme | P0 | ✅ ulives yayınlandı - iOS yeni App |

Özetle:

1. Daha önce belirlenen yönü uygulayacağız: kararlılık ve mevcut özellikleri optimize etme, keyfi olarak yeni işlev modülleri eklememe.
2. Bazı temel işlev eksikliklerini ve sorunlu noktalarını çözmek için bir veya iki büyük sürüm kullanacağız.
3. Ardından takvim entegrasyonu ve tekrar türü Başarımlarla devam edeceğiz.
4. API ve diğer yönleri sürekli iyileştireceğiz.

Çoklu platform 2024'teki önemli hedeflerimizden biri olacak.

---

### II. 2023 Değerlendirmesi

LifeUp'ın yarı amatör yarı boş zamanlı geliştirme yolculuğu beşinci yılını geçerek altıncı yıla girdi. Yüzlerce sürüm yayınladık; yalnızca Android deposunda yaklaşık 5000 kod commit'i var.

<br/>

Ekim 2022'de önerilen geliştirme planı LifeUp'ın işlev sistemini derinleştirmeye odaklanmış olsa da ortam değişiklikleri nedeniyle yol boyunca birçok engel ve sorunla karşılaştık.

#### 1.1 Ortam

Tipik örnekler:

- Bazı illerde "dolandırıcılıkla mücadele" yanlış bildirimlerinden etkilenme, itiraz kanalı olmadan bazı sorunları çözmek için birkaç tur gerekti. Ancak yakın zamanda Shandong'da yine yanlış bildirim sorunları oldu ve henüz itiraz veya yeniden oluşturma yolu bulamadık.
- Çin içi Android App pazarı inceleme standartları katman katman artıyor; pazarlar ve personel arasında tutarsız standartlar ve profesyonel olmayan incelemeciler var.
  - Bazı App pazarları değişmeyen bölümlerde sık sık incelemeyi reddediyor.
  - Bir V App pazarı neredeyse LifeUp App'imizi "gizlilik uyumluluğu" gerekçesiyle reddetti. Pazar, App'imizin albümden görsel seçebilmesi için [tüm dosya izinlerini okuma] veya [tüm fotoğraf izinlerini okuma] başvurusu ve karşılık gelen açıklamalar talep etti. Ancak LifeUp daha gizlilik koruyucu bir yaklaşım kullanır, böyle izinlere ihtiyaç duymaz ve kullanıcı dosyalarını doğrudan okumaz. Bunun yerine App sistem yerleşik albüm App'ine atlar ve yalnızca kullanıcının seçtiği görseli alır, maksimum gizlilik koruması sağlar.
    Ancak incelemeciler bu en iyi uygulamaya aşina değildi ve onay almak birkaç iş günü müşteri hizmetleri iletişimi gerektirdi.

<br/>

Çevresel etkiyi azaltmak için:

App içi güncelleme mekanizmasını güçlendirdik ve pazar incelemesine gönderme sıklığını azalttık.

İç pazar sürümü artık App içi güncellemeleri destekliyor ve kararlı veya beta kanalları arasında geçiş yapabiliyor.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Resmi web sitesini (https://lifeupapp.fun/en/index.html) alternatif indirme kanalı olarak da güncelledik.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Herkesin web sitesi üzerinden App'i indirip kurmasını kolaylaştırmak, pazar incelemesi risklerini ve gecikmelerini önlemek için.

App içi ağ isteklerine de yedek kanallar eklendi; bazı illerdeki yanlış bildirimlerden kaynaklanan erişim sorunlarını hafifletmek ve önlemek için.

<br/>

İnceleme standartları giderek sıkılaşırken ve iç pazar Android'de diğer bağımsız geliştiricilerin karşılaştığı çeşitli engellere tanık olurken,

bağımsız geliştiriciler için iç pazar Android platformunun artık ideal ilk tercih lansman hedefi olmadığı söylenebilir.

Sonuçta iç pazar Android en katı nitelik gereksinimlerine ve en karmaşık ve **değişken** inceleme standartlarına sahiptir.

> Ancak ironik biçimde aynı zamanda bazı düşük kaliteli kopya App'ler kolayca raflara çıkabiliyor ve "manuel yeniden inceleme geçti" işaretliyor.

Bu, Xiaohongshu'da görülen birçok bağımsız geliştirici eserinin yalnızca iOS sürümüne sahip olmasının nedeni olabilir.

Google Play ve App Store birinci tercih olmaya devam ediyor.

?> İç pazar Android platformuna hâlâ bağlı kalan bağımsız geliştiricilere ve küçük ekiplere daha fazla dikkat edip destek olabilirsiniz~

<br/>

Bu nedenle 2024'te:

- Önceki plandan tamamlanmamış kısımları bu döneme taşıyacağız: takvim entegrasyonu, tekrar türü Başarımlar, temel yetenekler, veri sistemi vb.
- Çoklu platform geliştirme bizim için önemli bir hedef olacak; muhtemelen iki yön içerecek:
  - Flutter ile LifeUp'ı kopyalama (sınırlı insan gücü nedeniyle backend meslektaşımız Xiao Xiao tarafından ilerletilecek)
  - KMP (Kotlin Multiplatform) kullanarak daha fazla olasılık keşfetme

#### 1.2 İç Pazar Kullanıcı Büyümesi

Ayrıca LifeUp 2023'te Çin App pazarında önemli kullanıcı büyümesi yaşadı. Herkesin desteği için teşekkürler!

- Manuel olarak kullanım kodu vermeye harcanan süreyi azaltmak ve geliştirmeye daha fazla odaklanmak için: 2023'te ek olarak otomatik ödeme yöntemlerini (WeChat, Alipay) bağladık ve WeChat girişini destekledik.
  - Bu bize çok zaman kazandırdı.

- 2023'te Qzone'da bir kullanıcı yayılımı sunucumuzu birkaç gün daha çökertti.
- LifeUp güncellemelerini ve yaratıcı kullanımlarını tanıtmak için WeChat resmi hesabı, Xiaohongshu, Bilibili vb. işletmeyi de denedik.

- Diğer bağımsız geliştiricilerle yapılan görüşmelerde çoğunun benzer zorluklar yaşadığını, sonunda belirli anlık mesajlaşma ve sosyal medya kanallarını kapattığını gördük. Derinden empati kuruyoruz.
  - Büyük şirketlerde genellikle çok sayıda sorguyu ele almak için özel müşteri hizmetleri ekipleri veya botlar vardır; bunlar etkili biçimde geliştiriciler için belirli ihtiyaçlara veya sorun geri bildirimlerine dönüşür.
  - **Ancak bağımsız geliştiriciler genellikle müşteri hizmetleri ve operasyon işlerini üstlenmek zorundadır; mantıksız kullanıcılarla uğraşmak bu bağımsız geliştiricinin geliştirme süresinin %100'ünü tüketir, sonuçta geliştiriciyi, ürünü ve ürünün çekirdek kullanıcılarını etkiler.**
  - Bu nedenle kullanıcılara e-posta vb. yoluyla geri bildirim vermelerini giderek daha çok öneriyoruz.

<br/>

Bu nedenle 2024'te:

- Tekrarlayan danışmanlık işlerine insan yatırımını azaltmaya devam edecek, bunun yerine belgeleri ve SSS'yi iyileştireceğiz. Danışmanlık olsa bile e-posta, QQ kanalı vb. yoluyla tek tip ele alınacak.
- Az miktarda sosyal medya operasyonu deneyeceğiz.

#### 1.3 Yurt Dışı Kullanıcı Büyümesi

2022'nin başında Google Play Pass'e katıldık ve bir dalga kullanıcı büyümesi gördük.

Ancak bu büyüme uzun sürmedi; 2022 ortasına gelindiğinde kullanıcı büyümesi giderek önemli ölçüde azaldı, iyileşme belirtisi yoktu.

LifeUp tek seferlik satın alma bir App olduğu için kullanıcı büyümesi bizim için çok önemli ve gelecekte tam zamanlı geliştirme şansına sahip olmamızın temel taşıdır.

Büyümeyi iyileştirmek için birçok yöntem denedik:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Profesyonel bir tasarımcı tutarak mağaza tanıtım görsellerini yeniden tasarladık
- App ve tanıtım görseli çoklu dil desteğini iyileştirdik
- App açıklamasını iyileştirdik
- Başlangıç belgelerini iyileştirdik
- Güncelleme sıklığını artırdık
- ...

Birçok yöntemi uyguladık ve bazı göstergeleri iyileştirdik. Yine de kararlı bir büyüme dönemine dönemedik.

Yapacak bir şey kalmadı, olduğu gibi bıraktık.

<br/>

İyi haber şu ki 2023 sonunda bir miktar iyileşme var gibi görünüyor.

<br/>

Bu nedenle 2024'te:

- Uluslararasılaştırma altyapısını iyileştireceğiz (belgeler, App içi dil desteği vb.).

#### 1.4 Kalite Yönetimi

LifeUp yalnızca benim tarafımdan geliştirilen ve test edilen çevrimdışı bir araç App'i olduğu için ciddi çökme sorunlarından kaçınmak özellikle önemlidir.

2023'teki sürüm yineleme süreci öncekinden daha uzun sürdü ve kapsamlı hazırlık sağlamak için beta testine yeterli süre ayırdık.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Bu önlemler büyük ölçekli ciddi çökmeleri etkili biçimde önlemiş gibi görünüyor.

Ancak her sürüm güncellemesi kaçınılmaz olarak bazı sorunlar getiriyor; kritik yollardakiler de dahil.

Bu nedenle LifeUp kalite yönetimini iyileştirmeye devam edeceğiz; kararlılık en önemli gösterge olacak (giderek zorlaşan ortam ve inceleme zorlukları altında özellikle).

<br/>

Bu nedenle 2024'te:

- Kalite yönetimini güçlendireceğiz.

#### 1.5 İşlevleri Derinleştirme

Üçüncü yıl makalesinde belirtildiği gibi LifeUp kademeli olarak keşfedilip büyüyen bir App'tir.

Mağaza, özel Başarımlar, API gibi özellikler başlangıç planında yoktu; güncellemeler ve geri bildirimlerle kademeli olarak geliştirilip eklendi.

Ancak bu bazı sorunları da beraberinde getirdi:

- Bazı modüllerin kaba planlama ayrıntıları var.
  - Örneğin Eşya Ödülleri başlangıçta yalnızca tek Ödül düşünüldü.
  - Özellikler ve diğer sistemler başlangıçta özelleştirmeyi düşünmedi; yalnızca kademeli yeniden düzenleme ekleme/çıkarma ve özel Seviyeler vb. destekleyebildi.
  - Özellik Ödül/ceza açılır pencereleri ve geçmiş gösterimi en fazla 3 destekler gibi birçok benzer sorun var.
- Bu yeni eklenen modüller App için genel analiz ve planlamadan yoksun.

Üçüncü yıl makalesinde belirtilen yönde devam edeceğiz: App'in mevcut işlev modüllerini derinleştirme ve bazı sorunlu noktaları çözme; yeni işlev modüllerini kovalamak yerine.

Örneğin doğrudan çoklu seçim Eşya Ödüllerini destekleyecek, yedekleme mekanizmasını, bildirim optimizasyonunu, widget tamamlamayı vb. iyileştireceğiz.

#### 1.6 API ve Genişletilebilirlik

Yukarıda belirtildiği gibi artık yeni işlev modülleri tanıtmayı planlamıyoruz.

Ancak App'i genişletme talepleri kesinlikle olacak.

Bu nedenle 2023'te API işlevini tanıttık.

LifeUp'ın çekirdeğini temel yetenek olarak sunuyoruz.

Kullanıcılar programlama bilmese bile Tasker/MacroDroid gibi otomasyon araçlarıyla işlevleri genişletebilir, otomasyon yetenekleri elde edebilir.

Tipik örnekler:

- NFC, QR kod ile Görev tamamlama
- Uyanınca otomatik check-in
- Özel widget'lar
- Ve benzeri...

Kullanıcılar programlama biliyorsa bundan daha da fazla oynanış ve hatta App'ler genişletebilir.

![img](_media/development_plan_2024/desktop.png)

API'ye dayalı basit bir masaüstü sürümü de geliştirdik (ve açık kaynak yaptık).

Birkaç sürüm API genişlemesinden sonra bile birçok yetenekten yoksunuz.

Örneğin "düşünce" ile ilgili işlemleri desteklememe, Content Provider ile veri güncellemeyi desteklememe vb.

2024'te API'yi App'in her yönünü mümkün olduğunca kapsayacak şekilde genişletmeye devam edeceğiz.

> Şu an birçok kullanıcının API'yi kişisel kullanım için kullandığını görsek de paylaşılan çalıştırılabilir ürünler hâlâ az. API ekosistemi kurmak için daha güçlü API yetenekleri sunmaya devam etmemiz gerekiyor.

#### 1.7 Gelecek Hakkında

Yukarıdaki sorunlar ve ortam değişiklikleriyle LifeUp'ın ömür boyu üyelik fiyatını da kademeli olarak ayarladık (buna rağmen LifeUp üyelik fiyatlandırması çoğu diğer App'ten çok daha düşük) ve güncellemeler giderek üyelik özellikleri olarak özellik sunmaya yönelecek.

App'lerin nihayetinde çekirdek kullanıcılara hizmet ettiğini kademeli olarak fark ediyoruz.

Çekirdek kullanıcıların geri bildirimi ve desteği nihayet App iyileştirmelerine yansıyabilir; geliştirici ve kullanıcılar arasında ortak yaratım ve olumlu döngü sağlanır.

Herkesi memnun etmeye çalışırsak App kod karmaşasına dönüşür, çekirdek kullanıcı taleplerinden sapar ve geliştirici kazancını ve motivasyonunu azaltır.

<br/>

Yukarıda KMP (Kotlin Multiplatform) bahsettik; nispeten yeni bir çapraz platform teknolojisi. Yerel yetenekleri karışık kullanabilir.

LifeUp geliştirme sürecinde kademeli olarak yeni fikirlerimiz oldu. Ancak tüm fikirler LifeUp'a inşa edilemez veya uygun değildir.

Örneğin tüm arayüzü değiştirme, Mağaza mantığında büyük değişiklikler vb.; bunlar kaçınılmaz olarak mevcut kullanıcı deneyimini ciddi şekilde etkiler. Büyük App değişikliklerinin başarısızlığa yol açtığı birçok vaka da gördük.

<br/>

Ayrıca LifeUp ilk geliştirildiğinde resmi veritabanı çerçevesi "Room" henüz mevcut değildi; bu nedenle yerli niş bir veritabanı çerçevesi seçtik.

Şimdi bazı performans sorunları belirginleşti ve değiştirmek zor.

Ek olarak LifeUp artık hem Material 3 hem eski Material Design'ı, artı karanlık mod, çoklu dil, iç pazar telefon sistemi parçalanması (uyumluluk yapılandırma belgeleri yalnızca uzuyor, yerel sistemler ve yurt dışı sürümler genellikle tek sayfa yapılandırma gerektirir) ve diğer sorunları destekliyor. Her sayfa birçok karmaşık şeyi düşünmek zorunda.

<br/>

Bu nedenle KMP ile bazı teknolojileri kullanıp kullanamayacağımızı görmek için KMP'yi keşfetmeyi planladık.

Ayrıca gelecekte daha fazla fikir ve yeni proje gerçekleştirme şansına sahip olmak için — fazla beceri zarar vermez.

# 2026-2027 Geliştirme Planı

!> Bu güncel geliştirme planımızdır. Ürün iyileştirmelerini ve yükseltmelerini bu plana göre yönlendirmek için elimizden geleni yapacağız. Ancak sürekli değişen ortam nedeniyle geliştirme planındaki içerik değiştirilebilir veya eklenebilir/çıkarılabilir. Gerçek ürün sürümü esas alınır.

### I. Geliştirme Planı

> Güncelleme: 2026/04

2024-2025'ten farklı olarak 2026-2027'de LifeUp ve **ulives**'ın mevcut modüllerini iyileştirmeye devam etmeyi, yepyeni işlev modülleri eklememeyi bekliyoruz.

| Modül | Alt işlev | Gereksinim Nedeni | Öncelik | Sonuç |
| ---- | ------ | -------- | ------ | ---- |
| Takvim Entegrasyonu | - Google Takvim Çift Yönlü Senkronizasyon<br/>- Sistem Takvimi Çift Yönlü Senkronizasyon | - Yurt dışından çok geri bildirim.<br/>- LifeUp, program (takvim) App'leriyle örtüşen ancak tutarsız işlevlere sahip bir yapılacaklar aracıdır. Tüm takvim özelliklerini LifeUp'ta geliştirmek çok büyük olurdu. Harici entegrasyon daha iyi bir çözüm olabilir. | P0 | 🚧 |
| Üretim Özelliği Optimizasyonu | - Mağaza ile entegrasyon<br/>- Gelişmiş filtreleme | - Üretim LifeUp'ın çekirdek özelliklerinden biridir. Mağaza ile entegrasyonunu ve filtreleme verimliliğini sürekli optimize ederek kullanıcı kolaylığını artırıyoruz. | P0 | ✅ Yayınlandı |
| Eşya Özelliği Optimizasyonu | - Daha zengin kullanım efektleri (diğer Eşya miktarlarını değiştirme)<br/>- Ses efektlerini tetikleme<br/>- Kullanım limitlerini destekleme<br/>- Genişletilmiş limit koşulları | - Eşya sistemi LifeUp oyunlaştırmasının çekirdeğidir. v1.103'te ayarlanıyor; Eşya esnekliği ve oynanışı sürekli güçlendiriliyor. | P0 | 🚧 v1.103 ayarlama |
| Özellik Optimizasyonu | - Özellik alt kategorileri (gruplama)<br/>- Unvan sistemi desteği<br/>- [Durum] türünü destekleme<br/>- Durum sayfası optimizasyonu<br/>- Yaşam Seviyesi widget'ı | - Özellik sistemi oyunlaştırmanın bir diğer çekirdeğidir. Özellik sistemini daha fazla boyut özelleştirmesi ve görüntüleme ile iyileştirmeye devam edeceğiz. | P0 | 🚧 Alt kategoriler yayınlandı, diğerleri planlamada |
| Görev Özelliği Optimizasyonu | - Açık etiket düzenleme ve filtreleme<br/>- Alt Görev düzenleme etkileşimi optimizasyonu<br/>- Özel alt Görev zorunlu tamamlama davranışı<br/>- Özel gecikmiş veya erteleme davranışı | - Görev LifeUp'ın çekirdek özelliğidir; Görev düzenleme ve etkileşim deneyimini sürekli optimize ediyoruz. | P1 | 🚧 |
| Sayım Görevi Toplu Ödüller | - Sayım Görevleri için toplu Ödül talebini destekleme | - Mevcut sayım Görevi Ödül mekanizması nispeten basittir; toplu Ödüller daha esnek hedef teşvikleri sağlayabilir. | P1 | 🚧 |
| Düşünce/Yansıma Özelliği Optimizasyonu | - Daha fazla gezinme stilini destekleme | - Düşünce özelliği LifeUp'ın ayırt edici özelliğidir; görüntüleme ve etkileşimini sürekli optimize ediyoruz. | P2 | 🚧 |
| Başarım Genişletmesi | - Haftalık/aylık/yıllık tür istatistikleri<br/>- Diğer Başarım koşullarının kilidini açma | - Başarım sistemi daha zengin Başarım deneyimi için daha çeşitli kilidi açma koşullarına ihtiyaç duyuyor. | P2 | 🚧 |
| Veri Sistemi | - Veri ve görsellerin ayrı yedeklenmesi<br/>- Kısmi veri dışa/içe aktarma desteği<br/>- Yerleşik çoklu dosya geçişi desteği | - WebDAV büyük dosya yüklemelerinde kolayca başarısız olur, ücretsiz bulut hizmetlerinin trafik limitleri vardır, görsellerle tam yedekleme çok büyüktür.<br/>- Kısmi dışa/içe aktarma kullanıcıların Ödül sistemlerini paylaşması için kullanılabilir.<br/>- Yerleşik çoklu dosyalar kullanıcıların veriyi tekrar tekrar temizlemeden sistemler arasında doğrudan geçiş yapmasına olanak tanır. | P1 | 🚧 |
| API | - Tüm temel işlevleri kapsayacak şekilde API yeteneklerini ve kapsamını genişletme | - Düşünce ile ilgili bazı işlemler gibi bazı API'ler hâlâ eksik.<br/>- LifeUp her şeyi kapsayamaz, ancak API herkesin LifeUp'ını özelleştirmesine ve genişletmesine ve açık kaynak topluluğunu gerçekleştirmesine olanak tanır. | P1 | 🚧 |
| **ulives** Geliştirme | - **ulives** özelliklerini iyileştirmeye devam<br/>- Çoklu platform desteğini keşfetme (iOS/iPadOS/macOS/diğerleri) | - **ulives** LifeUp'ın yeni nesil ürünüdür, modern çapraz platform teknolojisiyle geliştirilmiştir.<br/>- Gelecekte Android veya diğer platformlara geçiş mümkün olabilir. | P0 | 🚧 |

Özetle:

1. Belirlenen yöne devam edeceğiz: kararlılık ve mevcut özellikleri optimize etmeye odaklanma.
2. Kullanıcı deneyimini artırmak için her modülün işlev derinliğini sürekli iyileştireceğiz.
3. **ulives** geliştirmesini ilerletip daha fazla platform desteğini keşfedeceğiz.
4. API ve diğer yönleri iyileştirmeye devam edeceğiz.

---

### II. Değerlendirme ve Görünüm

#### 2.1 **ulives** Hakkında

2025'te **ulives**'ı iOS'ta LifeUp'ın yeni nesil ürünü olarak piyasaya sürdük. Bazı kullanıcılar merak edebilir: neden yeni bir App? Neden tekrar ödeme?

İşte düşüncelerimiz ve açıklamalarımız:

**Teknoloji ve Mimari Kısıtlamalar**

LifeUp Android teknolojisine dayalı geliştirilmiştir ve geliştirme sürecinde çok sayıda mantık ve tarihsel uyumluluk sorunu biriktirmiştir. Teknik mimari kısıtlamalar göz önüne alındığında veri uyumluluğunu koruyarak iOS veya HarmonyOS'ta özdeş bir sürümü kopyalamak neredeyse imkansızdır.

Ayrıca LifeUp kademeli geliştirildi; bazı ürün tasarımları uyumluluk ve erken tasarım kararları nedeniyle ödün verildi; bunları kolayca değiştiremeyebiliriz. Örneğin:

- **Özel Para Birimi**: LifeUp'ın altyapısı bir tür para birimidir; büyük mimari değişiklikler zordur.
- **World Modülü**: LifeUp geliştirmesinin erken döneminde sunucu tarafı iş birliği nedeniyle bu modülü eklemeyi planladık, ancak çoğu özellik kapsamlı düşünülmedi; sonuçta ekip özellikleri eksik kaldı.

Yeni bir şey yaratmak bu konulara modern kavramlarla yeni bir ürün perspektifinden bakmamıza olanak tanır.

**Teknik Borç**

Teknolojik olarak LifeUp bazı mayınlara da bastı:

- Erken hızlı geliştirme için uygun ancak temelde bakımsız bir veritabanı ORM çerçevesi kullanıldı; geçiş zor.
- Altyapı bile bileşik indeksleri desteklemiyor; performans darboğazlarına yol açıyor.
- Büyük veri hacimlerinde App performansını sürekli optimize etmek için önemli çaba harcadık.

**ulives** için bu yönleri modern çapraz platform teknolojisi (Kotlin Multiplatform) ile yeniden inceleyip geliştirdik. Gelecekteki olasılıklar Android veya diğer platformlara geçişi içerebilir (şu an yalnızca iOS, iPadOS ve macOS destekleniyor).

**Maliyet ve Fiyatlandırma**

LifeUp'ın erken dönem düşük tek seferlik fiyatlandırması ve tek platform konumlandırması, yatırım gerektiren özellikler (World Modülü veya AI özellikleri gibi) için sınırlı maliyet kontrolü bıraktı.

LifeUp (Android)'in düşük fiyatlandırması tek platform bakım maliyetlerine dayanır. **ulives**'da bazı ayarlamalar ve daha fazla planlama olabilir.

Geliştirme ekipleri farklı olduğu için tamamen yeniden geliştirmedir ve **ulives** şu an tamamen çevrimdışıdır. Üyelikleri paylaşamayız veya ek indirim veremeyiz; ücretli kullanıcıları incitmemek için gelecekte de böyle indirimler sunmayabiliriz.

---

#### 2.2 AI Verimliliği

Son yıllarda AI destekli geliştirmenin patlamasına tanık olduk; birçok geliştirici kısa sürede bir App'ten sonra App geliştirmek için AI kullanabiliyor.

Gerçekten geliştirme sürecimizde AI kullanmayı deniyoruz; işlev ana çerçevelerini ve kod iskeletini hızlı uygulamak için. Ancak AI her şeye güç yetiremez — teknik çözüm rotalarını belirleme, nihai kabul ve her şeyin çalıştığından emin olma hâlâ önemli insan çabası gerektirir.

Gerçekten zaman alan ayrıntıları cilalamaktır. Özellikle iOS platformu animasyon optimizasyonu, etkileşim akıcılığı ayarı, uç durum işleme — buraya yatırılan süre genellikle işlev mantığının birkaç katıdır.

---

#### 2.3 Kullanıcı Genişletmeleri ve AI Entegrasyonu

Birçok kullanıcının AI'yı LifeUp API'siyle birleştirerek ilginç işlevler uyguladığını da gördük:

- Bazıları MCP (Model Context Protocol) ile LifeUp'ı çeşitli AI araç zincirlerine bağlıyor
- Bazıları LifeUp'ı Obsidian gibi not App'leriyle iş akışı otomasyonu için birleştiriyor
- Bazıları API'ler aracılığıyla kendi web araçlarını ve otomasyon betiklerini uyguluyor

Kullanıcıların AI tabanlı genişletme yöntemlerini paylaşmaya devam etmelerini memnuniyetle karşılıyoruz ve daha fazla ilginç fikir görmeyi umuyoruz!

---

#### 2.4 Geliştirme Ritmi ve Kalite

LifeUp, **ulives** ve diğer App'lerimizin uzun vadeli bakımında ısrar ediyoruz. LifeUp için çok yıllık geliştirme planlarımız ve hedeflerimiz var ve ilerlemeye devam edeceğiz.

Kalite ve kararlılığı göz ardı ederek hızla yeni özellikler piyasaya sürmeyeceğiz. Her özellik dikkatli tasarım, geliştirme, test ve optimizasyondan geçer; nihai ürünün zamanın testine dayanmasını sağlar.

Bu nedenle sürekli yeni işlev modülleri piyasaya sürmek yerine mevcut özellikleri derinleştirmeye ve optimize etmeye daha fazla zaman yatırmayı seçiyoruz.

---

#### 2.5 Topluluk Öne Çıkanları

Birçok harika kullanıcıyla karşılaşma şansına sahip olduk:

- Bir kullanıcı garip bir LifeUp çökme sorunuyla karşılaştı. Birkaç tur bilgi alışverişinden sonra sistem günlüğünü (bugreport) dışa aktardı ve AI ile analiz ederek bunun sistem takvimi veri bozulmasından kaynaklandığını tespit etti. LifeUp takvim bildirimleri kullandığı için sistem tarafından yanlışlıkla sonlandırıldı. Bu, bu son derece gizemli sistem düzeyi uyumluluk sorununu tespit etmemize yardımcı oldu.
- Birçok kullanıcı ilginç Görev sistemleri, Eşya tasarımları, Başarım paylaşımları ve diğer topluluk içerikleri dahil yaratımlarını paylaştı.

Kullanıcılarımızdan gelen ezici destek, ürünlerimizi sürdürmeye ve güncellemeye devam etmemizi sağlayan güçtür.

---

> Önizleme: 2025'te Kotlin Multiplatform ile geliştirilen **ulives**'ı da piyasaya sürdük; şu an yalnızca iOS, iPadOS ve macOS destekleniyor, gelecekte daha fazla platform desteği planlanıyor.

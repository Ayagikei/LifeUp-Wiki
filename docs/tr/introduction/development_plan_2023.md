# 2022/10 - 2023/12 Geliştirme Planı

!> Bu süresi dolmuş bir geliştirme planıdır; yalnızca arşiv ve referans amaçlı tutulmuştur. Ortam sürekli değişmektedir ve planlarımız buna göre ayarlanacaktır. Bu plan genel geliştirme yönümüzü gösterir ancak tamamen uygulanacağını taahhüt etmiyoruz; planın ötesinde de geliştirme yapabiliriz.

<br/>

LifeUp'ın önceki yıllardaki geliştirmesi her zaman yeni işlev modülleri geliştirmeye veya mevcut modüllere yeni özellikler eklemeye odaklanmıştır.

Bugün LifeUp'ın işlev modüllerinin kendi içinde yeterli genişliğe sahip olduğuna ancak derinlikte yetersiz kaldığına inanıyoruz.

Bu nedenle aşağıdaki geliştirme hedefleri işlev derinliğine yöneliktir; mevcut kullanılabilir modülleri sürekli iyileştirir, pratikliği artırır (takvim entegrasyonu, widget'lar, istatistikler);

Ve API işlevselliğini sürekli genişleterek API'lerin çeşitli harici işlevler için tam olarak genişletilebilmesini sağlar.
Ayrıca veri sistemimizi iyileştirmeyi ve Flutter ile çapraz platform sürümleri geliştirmeyi keşfetmeyi deneyeceğiz.

<br/>

- **2023/01/26**
  - "Çoklu platform"a "LAN PC tarafı" maddesi eklendi, "API'ler"e de karşılık gelen açıklama eklendi.
  - "Takvim Entegrasyonu" tahmini sürümü ayarlandı, ilerleme gecikebilir.
  - "Özel Gerekli Deneyim" tahmini sürümü ayarlandı, ilerleme erkene alınabilir.
- **2022/10/16**
  - **Özellikler, Başarımlar ve Temel Yetenekler için yol haritası eklendi**

| Modül | Alt işlev | Tahmini Sürüm | Gereksinim Nedeni | Öncelik | Sonuç |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Takvim Entegrasyonu | - Google Takvim Çift Yönlü Senkronizasyon<br/>- Sistem Takvimi Çift Yönlü Senkronizasyon | v1.91~1.93 | - Yurt dışından çok geri bildirim.<br/>- LifeUp, program (takvim) App'leriyle örtüşen ancak tutarsız işlevlere sahip bir yapılacaklar aracıdır. Tüm takvim özelliklerini LifeUp'ta geliştirmek çok büyük olurdu. Harici entegrasyon daha iyi bir çözüm olabilir. | P0 | ~ |
| Widget'lar | - Özellikler Widget'ı<br/>- Eşyalar Widget'ı<br/>- vb... | v1.92~1.95 | - Kullanılabilirlik.<br/>- Güzel widget'lar aynı zamanda oyunlaştırma ve motivasyon sağlar. | P1 | ~ |
| İstatistikler | - Çeşitli gösterge istatistikleri<br/>- Ayrıntılı Pomodoro istatistikleri<br/>- Paylaşım kartları oluşturma | v1.92~1.95 | - Pomodoro istatistikleri yetersiz.<br/>- İstatistik modülü uzun süredir iyileştirilmedi, tasarım ve veriler güncelliğini yitirdi.<br/>- Paylaşım kartları kullanıcıların dış paylaşımına uygundur, teşvik getirebilir ve belirli ölçüde daha fazla kullanıcı çekebilir (zarif arayüz tasarımı gerektirir). | P1 | - v1.91'de bazı istatistik kartları geliştirilmesi bekleniyor |
| API'ler | - SDK geliştirme<br/>- Liste sorgularını destekleme<br/>- Daha fazla ortak API | v1.91~1.95 | - Liste veri arayüzü eksik. Liste sorgusu desteklendikten sonra üçüncü taraflar özel arayüz (Görev listesi gibi) geliştirebilir, genişletilebilirlik büyük ölçüde artar.<br/>- Yukarıdaki arayüzlere dayanarak ilgili SDK'lar ve LAN PC tarafı geliştirilir.<br/>- LifeUp her şeyi kapsayamaz, ancak API herkesin LifeUp'ını özelleştirmesine ve genişletmesine ve açık kaynak topluluğunu gerçekleştirmesine olanak tanır. | P1 | - v1.91'de ilk sürüm sorgu API'si sunulması bekleniyor |
| Özellikler | - Özel gerekli Deneyim Puanı | v1.91~1.92 | ~ | P2 | - v1.91'de geliştirmenin tamamlanması bekleniyor |
| Başarımlar | - Tekrar türü Başarımlar | v1.94~1.97 | ~ | P2 | ~ |
| Temel Yetenekler | - Toplu düzenleme (Görevler, Başarımlar vb.)<br/>- Çoklu seçim Eşyalar, otomatik kutuya paketleme vb. | v1.94~1.97 | ~ | P1 | ~ |
| Veri Sistemi | - Veri ve görsellerin ayrı yedeklenmesi<br/>- Kısmi veri dışa/içe aktarma desteği<br/>- Yerleşik çoklu dosya geçişi desteği | ~ | - WebDAV büyük dosya yüklemelerinde kolayca başarısız olur, ücretsiz bulut hizmetlerinin trafik limitleri vardır, görsellerle tam yedekleme çok büyüktür.<br/>- Kısmi dışa/içe aktarma kullanıcıların Ödül sistemlerini paylaşması için kullanılabilir.<br/>- Yerleşik çoklu dosyalar kullanıcıların veriyi tekrar tekrar temizlemeden sistemler arasında doğrudan geçiş yapmasına olanak tanır. | P1 | ~ |
| Çoklu platform | - Flutter ile çapraz platform sürümü geliştirmeyi öğrenmeye ve kullanmaya devam | LAN PC tarafı: v1.91-1.92<br/>Flutter: v2.0 | - iOS sürümü prototip geliştirme.<br/>- Android sürümünü bire bir kopyalamaktan çok yeni uygulamalar keşfetmeye daha yatkınız.<br/>- Windows/macOS ve diğer platformlar için uygun olabilir, araştırılması gerekir.<br/>- API'lere dayalı LAN PC tarafı geliştirme (telefon verisini okuyan sürüm). | P1 | - v1.91'de ilk sürüm PC tarafının sunulması bekleniyor |

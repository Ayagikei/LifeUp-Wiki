# LifeUp'ı Arka Planda Çalışır Tutma

## Neden gerekli

Bazı telefon üreticileri pil kıyaslama sonuçlarını iyileştirmek için arka plan App'lerini agresif biçimde kısıtlar. Sonuç olarak arka plan çalışmasına dayanan özellikler başarısız olabilir.

### Uyumluluk etki matrisi

| Özellik | Arka plan canlı tutma gerekir mi? | Ek izinler | Notlar |
| --- | --- | --- | --- |
| Görev hatırlatıcısı (sistem bildirimi) | ✔️ | Bildirim izni | Bu varsayılan hatırlatma yöntemidir. Hatırlatıcılar gecikirse veya gelmezse arka plan canlı tutmayı yapılandırın ve LifeUp için bildirimlerin etkin olduğundan emin olun. |
| Görev hatırlatıcısı (takvim etkinliği) | ✖️ | Takvim okuma/yazma izni | Bunu `Ayarlar` → `Görevler` → `Hatırlatma Sistemini Değiştir` bölümünden bu moda geçirebilirsiniz. |
| Pomodoro bitiş hatırlatıcısı | ✔️ | - | Canlı tutma yapılandırılmamışsa hatırlatıcılar kaçırılabilir ve geri sayım arka planda duraklayabilir veya donabilir. |
| Yukarı sayım zamanlayıcısı | ✖️ | - | - |
| App widget otomatik yenileme | Genellikle evet (cihaz/işletim sistemine bağlı) | - | Uygun canlı tutma olmadan widget'lar "Yükleniyor"da kalabilir veya "Tüm Görevler tamamlandı" gibi eski durumları gösterebilir. |
| Widget eylemi: sayım Görevini tamamla / Görev ayrıntısını aç (MIUI dışı) | ✖️ | - | - |
| Widget eylemi: sayım Görevini tamamla / Görev ayrıntısını aç (MIUI) | Duruma bağlı | MIUI'ye özel arka plan açılır pencere/görüntüleme izni gerekebilir | MIUI, widget tetiklemeli arayüz eylemlerini arka planda engelleyebilir. |

- Bazı sistemler ekran kapalıyken arka plan Görevlerini dondurur veya sonlandırır.
- Widget'lar farklı başlatıcılar ve işletim sistemi sürümlerinde farklı davranabilir.
- Yalnızca hatırlatıcılarla ilgileniyorsanız arka plan bağımlılığını azaltmak için takvim hatırlatıcılarına geçebilirsiniz.

## Nasıl yapılandırılır

> [!WARNING]
> Bu ayarlar pil tüketimini biraz artırabilir.

OnePlus 8T üzerindeki testlerimize göre 24 saatlik arka plan kullanımı yaklaşık **30 mAh** tüketti. Çoğu kullanıcı için bu küçük bir etkidir.

LifeUp yalnızca hatırlatıcılar, widget güncellemeleri ve Pomodoro zamanlaması gibi sınırlı pasif arka plan işlemleri yapar.

---

### Ortak kurulum adımları

#### Genel ayarlar

> Her adımı tamamlamanız gerekmez. Her adım arka plan önceliğini ve kararlılığını artırabilir.

**Android sistem ayarları**

1. LifeUp'ta `Kenar çubuğu` → `Ayarlar` → `Uyumluluk Sorunları`'nı açın, ardından `Pil Optimizasyonu Ayarlarına Git`'e dokunun. LifeUp'ı bulun ve **Optimize Etme** olarak ayarlayın.

   a. Bazı cihazlarda bu sayfaya atladıktan sonra LifeUp görünmeyebilir. Öyleyse bu adımı atlayın.

2. Hatırlatıcıya ihtiyacınız varsa LifeUp'a bildirim izninin verildiğinden emin olun.

3. (İsteğe bağlı) Görev ayarlarında `Hızlı Ekle bildirimi`ni etkinleştirin.

<br/>

**Üretici arka plan yöneticisi (Telefon Yöneticisi)**

Birçok üretici ek arka plan kısıtlamaları ekler. Pixel/AOSP benzeri bir cihaz kullanmıyorsanız genellikle ek yapılandırma gerekir.

1. LifeUp'ı sistem çoklu görev/son uygulamalar ekranında kilitleyin.

2. Sistem App yönetimi / pil yönetimi / telefon yöneticisinde LifeUp için arka planda çalışmaya izin verin (kısıtlama yok) ve otomatik başlatmaya izin verin.

   a. Üreticiye özel kılavuzlar için [dontkillmyapp.com](https://dontkillmyapp.com/) adresine bakın.

3. LifeUp özelliklerini kullanırken süper güç tasarrufu veya katı rahatsız etmeyin politikaları gibi agresif modlardan kaçının veya LifeUp'ı ilgili izin listelerine ekleyin.

<br/>

**Hâlâ çalışmıyor mu?**

Kullanıcı raporlarına ve testlerimize göre LifeUp doğru kurulumdan sonra ana akım cihazlarda normal çalışır. Ancak sistem güncellemeleri ayarları taşıyabilir veya yeniden adlandırabilir.

1. Yukarıdaki tüm adımları yeniden kontrol edin ve atlanan ayarları tamamlayın.

   a. Telefon yöneticisi kısıtlamaları genellikle birden fazla sayfaya dağılmıştır ve standart App izinleri olarak listelenmez.

   b. İsteğe bağlı adımları deneyin (örneğin kalıcı bildirimi etkinleştirme) ve tekrar test edin.

   c. Sistem ayarlarında pil optimizasyonu, arka plan kısıtlamaları, otomatik başlatma ve açılır pencere/arka plan görüntüleme seçeneklerini arayın.

   d. Yalnızca hatırlatıcılarla ilgileniyorsanız `Takvim Hatırlatıcısı` modunu deneyin.

2. Toplulukta aynı cihaz marka/modeline sahip diğer kullanıcılara sorun ve işletim sistemi sürümünüzü belirtin.

3. Telefon üreticisi desteğine başvurun ve belirli bir App'in arka planda sonlandırılmasını nasıl önleyeceğinizi sorun.

---

### App widget'ları çalışmıyor

1. Önce LifeUp'ı açın ve bir süre ön planda çalışır tutun.
2. Widget'ı yeniden ekleyin (gerekirse birden fazla kez deneyin).
3. Daha sonra tekrar başarısız olursa bu kılavuzu gözden geçirin ve canlı tutma ayarlarını yeniden kontrol edin.
4. Üçüncü taraf bir başlatıcı kullanıyorsanız sistem başlatıcısına geçin ve tekrar test edin.
5. Özel tema kullanıyorsanız varsayılan sistem temasına geçin ve tekrar test edin.
6. Telefonunuzu yeniden başlatın.
7. Başlatıcıya özel sorunları elemek için başka bir başlatıcı deneyin.

# Sürüm Notları

## Zaman Çizelgesi

![timeline](_media/release_log/timeline.png)

## Notlar

| Platform          | Sürüm                  | Güncelleme Tarihi           |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.3              | 2026/08/26                  |
| LifeUp-iOS        | check [feature/ulives] | 🎉Alternatif uygulama mevcut |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Çevirinin bir kısmı makine/AI çeviri ile sağlanmıştır ve doğru olmayabilir)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.3 (2026/08/26)**

**🐛 Hata Düzeltmeleri**

1. **Bir ekip Görevinin yerel olarak zamanlı bir Göreve dönüştürülmesinden sonra anormal Görev tamamlama davranışı düzeltildi.**

**v1.105.2 (2026/08/24)**

**🐛 Hata Düzeltmeleri**

1. **Akıllı liste seçildiğinde Görev seçicisinin boş liste göstermesi düzeltildi.**
2. **Akıllı listede aramanın, o listeye ait olmayan Görevleri de göstermesi düzeltildi.**

**v1.105.1 (2026/08/19)**

**✨ Yeni Özellikler**

1. **Özel ses efektleri sahne bazında devre dışı bırakılabilir**: Bir ipucunu diğerlerini etkilemeden sessize alın; önizleme yine çalar, sesi kontrol edebilirsiniz.

**♻️ Optimizasyon**

1. **Google Play hizmetleri kullanılamadığında daha net yedekleme yönlendirmesi**: Google Drive kullanılamıyorsa App nedenini açıklar ve yerel dosya, Dropbox veya WebDAV önerir.

**🐛 Hata Düzeltmeleri**

1. **Takvim Tamamlanan sayfasında Geri Al'a dokunmanın hiçbir şey yapmaması düzeltildi.**
2. **Bir Eşya düzenlenirken satın alma/kullanım limitlerinin geri yüklenmemesi (veya boş kaydedilmesi) düzeltildi.**

**v1.105.0 (2026/08/04)**

**ℹ️ Önemli Not**

1. **Android 6.0 artık desteklenen minimum sürüm**: Daha yeni Android sürümlerinin özellik ve davranış gereksinimlerini proaktif desteklemek için minimum desteklenen sürüm Android 5.0'dan Android 6.0'a yükseltildi. Android 5.x kullanıcıları bu sürümü yükleyemez veya güncelleyemez.

**✨ Yeni Özellikler**

1. **Pomodoro kontrol URL Scheme API'si eklendi**: Kullanıcılar durumu sorgulayabilir, Görev seçebilir ve Pomodoro/süre sayımı oturumlarını başlatabilir, duraklatabilir, atlayabilir, bırakabilir veya tamamlayabilir.
2. **Özel Görev sıralama mekanizması iyileştirildi**: Kopyalama, tamamlama, geri alma ve diğer uç durumlarda özel sıranın stabil kalması için yeni bir sıralama mekanizması getirildi.

**♻️ Optimizasyon**

1. **Android predictive-back desteği eklendi**: Görev, Mağaza, Sentez ve Başarım düzenleyicileri artık sistem predictive-back hareketini destekler.
2. **Facebook giriş başlatma iyileştirildi**: SDK, giriş istendiğinde başlatılır; hata durumu işleme geliştirildi.

**🐛 Hata Düzeltmeleri**

1. **Düzenleme URL Scheme isteklerinin mevcut alanları beklenmedik şekilde üzerine yazması düzeltildi**: Atlanan alanlar önceki değerlerini korur; geçersiz Ödül veya ilişki parametreleri artık mevcut verileri temizlemez.
2. **Belirli uç durumlarda pozitif zamanlayıcı bildirim başlıklarının seçili Görevi takip etmemesi düzeltildi.**
3. **İlk yapıştırılan onaltılık renk değerinden sonra RGB önizlemenin yenilenmemesi düzeltildi.**
4. **Sentez ve Başarım ayrıntı sayfalarındaki seçim araç çubuğunda eksik gölgeler düzeltildi.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Hata Düzeltmeleri**

1. **App veya zamanlayıcı hizmeti beklenmedik şekilde durduktan sonra Pomodoro oturumlarının doğru geri yüklenmemesi düzeltildi**: Geçerli oturumlar artık doğru geri yüklenir; geçersiz eski durum temizlenir.
2. **Sistem saat dilimi değişikliğinden sonra tekrarlayan uyarılar düzeltildi**: Ayarlama onaylandıktan sonra Görev saatleri doğru güncellenir ve aynı uyarı tekrar gösterilmez.

**v1.104.5 (2026/07/17)**

**🐛 Hata Düzeltmeleri**

1. **v1.104.4 sürüm derlemesinde Pomodoro sayfasını açmanın App'in çökmesine neden olabileceği sorun düzeltildi.**

**v1.104.4 (2026/07/17)**

**✨ Yeni Özellikler**

1. **Eşyalar artık Özellik Deneyim Puanı aralıklarına göre satın alma/kullanım kısıtlamalarını destekler**: Bir Eşyanın satın alınıp alınamayacağını, kullanılıp kullanılamayacağını veya her ikisini de kontrol etmek için minimum ve maksimum Deneyim Puanı koşulları ayarlayın.
2. **Bir günde toplam N kez Görev tamamlama için yeni Başarım koşulu**: Mevcut farklı Görev koşulunun aksine, bu koşul o gün geçerli her Görev tamamlamasını sayar; aynı Görevin tekrarlanan tamamlamaları dahil.

**♻️ Optimizasyon**

1. **Pomodoro hesaplama ve kurtarma akışı yeniden oluşturuldu**: Zamanlayıcı durumu, Odak kayıtları ve Ödül hesaplaması artık birleşik bir süreci izler. App işlemi sonlandırılırsa kurtarma da daha güvenilir; eksik Odak süresi gibi uç durumlar azalır. Beklenmedik davranış değişiklikleri fark ederseniz lifeup@ulives.io adresinden bize ulaşın.
2. **Sentez tariflerinde daha akıcı miktar düzenleme**: Mevcut bir malzeme veya sonuca dokunarak aynı Eşyayı yeniden seçmeden miktarını doğrudan düzenleyin. Gerektiğinde Eşyayı yeniden seçebilirsiniz.
3. **Pomodoro artık ana sayfadan yatay modda doğrudan açılabilir**: Zamanlayıcıyı yatay düzende daha rahat görüntüleyip kullanın.

**v1.104.3 (2026/07/09)**

**✨ Yeni Özellikler**

1. **Karşılama ekranında yeni "Hızlı Kurulum" rehberi**: Tanıtım kartlarından sonraki iki yeni sayfa (5 ve 6), onboarding sırasında bildirim izinleri, hatırlatma yöntemi, arayüz stili (Material 2/3) ve çok pencere görüntüsünü akordeon kartlarıyla yapılandırmanıza olanak tanır. Tüm seçenekler daha sonra Ayarlar'dan düzenlenebilir.

**♻️ Optimizasyon**

1. **Karşılama sayfası tanıtım metni güncellendi**: 1–4. sayfalar, App'in temel değerini daha iyi aktarmak için yeniden yazıldı: özel Görevler → istatistik büyümesi → Ödül sistemi → dünyayla bağlantı.
2. **Sentez iletişim kutusu alt sayfa olarak yeniden tasarlandı**: Malzemeler ve sonuçlar artık dikey ızgarada gösterilir; düzen daha sade ve sezgisel.
3. **Yapılacaklar listeleri arasında geçiş, sıralama değiştirme veya gruplama ayarlarını açıp kapatırken daha hızlı veri yükleme**.

**🐛 Hata Düzeltmeleri**

1. **Belirli sistem Başarımları için yinelenen "Başarım Açıldı" bildirimleri düzeltildi.**
2. **"Günde N Farklı Görev Tamamla" Başarımının hatalı sayımı düzeltildi**: Sınırsız Görevler artık hariç tutulmaz; aynı Görevin aynı gün birden fazla tamamlanması bir kez sayılır.
3. **Görev listesindeki ekle (+) düğmesinin ara sıra doğru konumundan kayması düzeltildi.**
4. **"Listeye Göre Grupla" devre dışıyken akıllı listelerin arşivlenmiş Görevleri filtrelememesi düzeltildi.**

**v1.104.2 (2026/07/03)**

**✨ Yeni Özellikler**

1. **İstatistik sayfasında "Kullanım Günleri" "Yoldaşlık Günleri" olarak yeniden adlandırıldı**: Kartına dokunarak başlangıç tarihini özelleştirin ve kendi yıldönümünüzü tanımlayın. İlgili Başarım koşulu açıklamaları da "yoldaşlık" ifadesini kullanacak şekilde güncellendi.
2. **Yedekleme menüsüne "Yedekle ve Paylaş" seçeneği eklendi**: Yedek dosyalarını sistem paylaşım paneliyle doğrudan diğer uygulamalara paylaşın.
3. **Ganimet Kutusu efekt API v2**: Yeni `loot_box/v2` rotası `sub_amount` ile hassas Eşya eşleştirmesini, Eşya ekleme/çıkarmayı ve miktar ile olasılık modlarının bağımsız kontrolünü destekler.

**♻️ Optimizasyon**

1. **Mağaza Eşyaları, Ganimet Kutuları veya alt görevler düzenlenirken URL Scheme artık tam ad eşleşmesine öncelik verir**; tam eşleşme bulunamazsa bulanık eşleşmeye düşer — istenmeyen düzenlemeleri önler.
2. **Kenar çubuğunda İngilizce "FAQ" "Notice" olarak yeniden adlandırıldı**: Çince sürüm zaten "公告" idi ve değişmedi.
3. **Düğme dalgalanma efektleri artık her yerde köşe yarıçapıyla uyumlu**: Yuvarlatılmış kontrollerdeki dalgalanma animasyonları artık köşe sınırlarının dışına taşmaz; dokunuşlar App genelinde daha rafine hissedilir.

**🐛 Hata Düzeltmeleri**

1. **Kayıt ekleme veya düzenlemeden sonra Pomodoro sayfasının domates sayısını otomatik yenilememesi düzeltildi.**
2. **Pomodoro kaydı eklendikten sonra kazanılan domatesleri gösteren toast'ın ara sıra görünmemesi düzeltildi.**
3. **Manuel eklenen Pomodoro kayıtlarının domatesleri kayıttaki Görev yerine o an seçili Göreve göre hesaplaması düzeltildi**: Hesaplama artık kayıtta gerçekten seçilen Görevin Göreve özel Odak süresini kullanır. Farklı Görevler için farklı Odak süreleri ayarladıysanız, manuel kaydedilen domatesler artık daha doğru olur.
4. **Geçmişte sınırsız Görevler için hatalı "tamamlama sayısı" gösterimi düzeltildi**: Artık günlük sıra numarası olarak gösterilir (ör. "o gün N. kez").
5. **Ceza Görevi motivasyon metninin görünmemesi düzeltildi** — ceza tamamlandıktan sonra görünür.

**v1.104.1 (2026/06/17)**

**✨ Yeni Özellikler**

1. **Geliştirilmiş yedekleme dışa aktarma seçenekleri**: Manuel yedek oluştururken yeni bir alt sayfa, medya dosyaları, hesap hassas bilgileri (giriş durumu, WebDAV kimlik bilgileri vb.) ve emoji görsellerinin dahil edilip edilmeyeceğini seçmenizi sağlar — temizlenmiş bir yedeği paylaşmayı kolaylaştırır. Otomatik yedekleme bölümüne de üç karşılık gelen kalıcı anahtar eklendi.
2. **İyileştirilmiş Pomodoro Görev seçicisi**: Zamanlı Görevler artık Görev seçicide mevcut Odak ilerlemesiyle (Odaklanılan süre / hedef süre / yüzde) birlikte önce görünür. Hızlı erişim için zamanlı Görevlere öncelik vermeyi açıp kapatan bir anahtar vardır.
3. **Hakkında sayfası yeniden tasarlandı**: Hakkında sayfası Bağlantılar, Geri Bildirim, Topluluk ve Geliştirici bölümlerine ayrıldı; web sitesi, sürüm günlüğü, SSS ve API belgeleri için yeni girişler eklendi. Basitleştirilmiş Çince kullanıcıları Tencent Channel girişi alır; yurtdışı kullanıcılar GitHub Issues/Discussions topluluk erişimi kazanır.
4. **Takipçileri kaldırma**: Artık ekip üyeleri sayfasından takipçileri kaldırabilirsiniz.
5. **Mağaza Özellik seçici geliştirmesi**: Mağaza exp/efekt giriş iletişim kutusuna bir Özellik seçici düğmesi eklendi; Yetenek grubuna göre hızlı filtreleme ve toplu çoklu seçim desteklenir — çok sayıda Özellikle uğraşırken çok daha kolay.

**♻️ Optimizasyon**

1. **Pomodoro istatistikleri artık zaman görüntüleme biçimini değiştirmeyi destekler**: Görev ayrıntı sayfasındaki Pomodoro istatistik alanına dokunarak "saat/dakika", "gün/saat/dakika" ve "toplam dakika" arasında geçiş yapın.
2. **Daha net alt görev tamamlama durumu**: Tamamlanan alt görevler artık üstü çizili gösterilir; tamamlanan ile bekleyen arasındaki ayrım çok daha net.
3. **Pomodoro kaydı sıralaması düzeltildi**: Pomodoro kayıtları artık bitiş zamanına göre azalan sırada sıralanır.

**🐛 Hata Düzeltmeleri**

1. **Birden fazla dilde ATM para çekme düğmesi metni düzeltildi**: Bazı yerel ayarlarda ATM para çekme düğmesi metnindeki gerund kullanım hatası giderildi.
2. **Giriş yapılmadan Mağaza Eşyası paylaşma davranışı düzeltildi**: Giriş yapılmadan Mağaza Eşyaları paylaşılırken oluşan anormal davranış giderildi.
3. **Renk seçici yankı durumu düzeltildi**: Renk seçici iletişim kutusunun hatalı seçili durum göstermesi düzeltildi.

**v1.104.0 (2026/05/23)**

**✨ Yeni Özellikler**

1. **Sayım Görevleri artık orantılı gerçek zamanlı Ödül hesaplamasını destekler**: Bir döngü içinde esnek anlarda birden fazla ilerleyebileceğiniz Görevler için kullanışlıdır; örneğin haftada birkaç kez tamamlanan alışkanlıklar. Sayım ilerlemesi değiştiğinde LifeUp, nihai tamamlamayı beklemeden mevcut ilerlemeye göre Exp, jeton ve Eşya Ödüllerini verebilir veya geri alabilir.
2. **Görev ayrıntı geçmiş araçları daha güçlü**: Geçmiş takviminde bir tarih seçildiğinde o günün sayımı gösterilir; geçmiş kayıtları ekleyebilir, düzenleyebilir veya toplu oluşturabilirsiniz.
3. **Duygular ve Eşyalar daha iyi bağlandı**: Eşya ayrıntıları artık ilgili Duygulara doğrudan atlayabilir; Duygular sayfası Mağaza Eşyasına göre filtrelemeyi destekler.
4. **Alt görev tamamlama zamanları artık kaydediliyor**: LifeUp artık her alt görevin ne zaman tamamlandığını kaydeder; gelecekteki API ve LifeUp Cloud desteği için veriyi hazırlar.

**♻️ Optimizasyon**

1. **Daha hassas Mağaza Eşyası görünürlük filtreleri**: Tükenen Eşyalara ek olarak artık satın alma devre dışı, satın alma sınırlı veya şu an karşılanamayan Eşyaları gizleyebilirsiniz. Mağaza widget'ları aynı kuralları izler.
2. **Görev listesi arama ve yenileme daha stabil**: Normal liste araması, ayarlara göre şu an görünür olan tamamlanmış Görevleri dahil edebilir; Tümü listesinde tekrarlayan Görev yenileme ve özel sıralama çok sayıda Görevle daha stabil.
3. **Görev ayrıntı geçmiş istatistikleri artık seçili tarihi izler**: Sayım ve sınırsız Görevler, her günün tamamlama sayısına göre farklı katkı haritası renk seviyeleri kullanır. Geçmiş görünümünün altındaki aylık, yıllık, tüm zamanlar ve seri istatistikleri artık her zaman bugünün verisini kullanmak yerine seçili tarihten hesaplanır.
4. **Daha sezgisel alfabetik sıralama**: Modüller genelinde alfabetik sıralama artık doğal sayısal sıralamayı izler; sayı içeren adlar karakter karakter karşılaştırma yerine sayısal değere göre sıralanır.
5. **Mağaza ayarları giriş davranışı iyileştirildi**: Mağaza ayarları artık odaklanan girişleri yumuşak klavyenin üstüne kaydırır.
6. **Daha güvenilir sistem karanlık modu işleme**: Sistem temasını izleme ile manuel gece modu anahtarları arasındaki durum yarışları düzeltildi.
7. **Genişletilmiş URL Scheme API desteği**: Görev Ekle/Düzenle artık `no_deadline` anlambilimini destekler; sayım Görevi API'leri gerçek zamanlı hesaplama bayrağını destekler.
8. **Daha net faiz geçmiş kayıtları**: ATM ve kredi faiz kayıtları artık anapara ve faiz günlerini gösterir; faiz kaynağını doğrulamayı kolaylaştırır.

**🐛 Hata Düzeltmeleri**

1. **Sayfam'daki Başarım istatistikleri düzeltildi**: Sistem Başarımları gizliyken Başarım sayıları artık aynı görünürlük kuralını izler.
2. **Geçmiş kaydı ifadesi düzeltildi**: Vazgeçme geçmiş kayıtları artık gecikme cezası ifadesiyle gösterilmez.
3. **URL Scheme API'lerinde uzun metin işleme düzeltildi**: Yetenekler ve Başarımlar için uzun açıklamalar artık çok erken kesilmez.

**v1.103.6 (2026/05/10)**

**🐛 Hata Düzeltmeleri**

1. **Vazgeç'e dokunulduktan sonra uzun mola aralığı ipucunun ilk Odak oturumu durumuna sıfırlanmaması düzeltildi.**
2. **Vazgeç'e dokunulduktan sonra ek Odak zamanlayıcısının görünür kalıp saymaya devam edebilmesi düzeltildi.**

**v1.103.5 (2026/05/10)**

**🐛 Hata Düzeltmeleri**

1. **Çalışma oturumu doğal olarak bittikten sonra Pomodoro zamanlayıcı uzun mola ipucunun hemen yenilenmemesi düzeltildi.**
2. **Pomodoro ayarları açılmadan önce Pomodoro zamanlayıcısının varsayılan 4 oturum yerine eski 2 oturumlu uzun mola aralığını gösterebilmesi düzeltildi.**

**v1.103.4 (2026/05/05)**

**🐛 Hata Düzeltmeleri**

1. **Bazı uç senaryolarda dondurulmuşken anormal kesinti nedeniyle Görevlerin kaybolabilmesi düzeltildi.**

**v1.103.3 (2026/05/05)**

**ℹ️ Sürüm Notu**

1. **Bu sürüm atlandı ve halka açık olarak yayınlanmadı.**

**v1.103.2 (2026/04/30)**

**🐛 Hata Düzeltmeleri**

1. **Belirli dillerde veya daha küçük ekran boyutlarında Eşya satın alma veya kullanım kısıtlamaları düzenlenirken giriş alanlarının görünmeyebileceği uyumluluk sorunu düzeltildi.**
2. **Bir Eşya kullanıldığında hatalı şekilde ceza iletişim kutusunun tetiklenebilmesi düzeltildi.**

**v1.103.1 (2026/04/25)**

**🐛 Hata Düzeltmeleri**

1. **Bir Eşyanın kullanım efektinin kendi miktarını değiştirmesi durumundaki anormal davranış düzeltildi**
2. **Üretimden yakalanan bazı çökme ve gecikme sorunları düzeltildi**
3. **Bir Eşyanın "Eşya Miktarını Değiştir" efekti düzenlenirken hatalı miktar değerlerinin geri doldurulması düzeltildi**

**v1.103.0 (2026/04/12)**

**✨ Yeni Özellikler**

1. **Özellikler artık alt kategorileri ve hızlı taşımayı destekler**: Özellikleri daha net gruplayabilir ve bir Özelliği hedef gruba daha hızlı taşıyabilirsiniz.
2. **Daha akıcı Özellik seçimi etkileşimleri**: Görev düzenleme, Ödülle ilgili akışlar ve diğer Özellik seçicileri çok sayıda Özelliğiniz varken gezinmeyi kolaylaştırır.
3. **Eşyalar artık satın alma/kullanım kısıtlamalarını destekler**: Limitler satın alma, kullanım veya her ikisine uygulanabilir; zaman, açılan Başarımlar, tamamlanan Görevler, sahip olunan Eşya sayıları ve Özellik seviye aralıkları gibi daha zengin koşullar desteklenir.
4. **Başarımlara daha fazla yerleşik sıralama seçeneği eklendi**: Özel sıraya ek olarak Başarım listeleri artık alfabetik sıra, tamamlanma zamanı ve oluşturulma zamanına göre yerleşik sıralamayı destekler.
5. **Başarımlar alt kategorilere hızlı taşımayı destekler**: Bir veya birden fazla Başarımı hedef alt kategoriye daha verimli taşıyın.
6. **Gecikme işleme artık bir yardım girişi içerir**: Gecikme iletişim kutusu artık bir yardım girişi içerir ve gecikmiş bir Görevi tekrar tamamlandı olarak işaretlerken Ödül değişikliklerini daha net sunar.

**♻️ Optimizasyon**

1. **Gruplanmış Özellik görüntüsü daha net**: Durum sayfası ve Özellik açıklama iletişim kutuları gruplanmış Özellikleri artık daha yapılandırılmış biçimde sunar.
2. **Özellikle ilgili etkileşimler daha tutarlı**: Özellik iletişim kutuları ve ilgili düzenleme akışları genelinde gruplu görüntüleme ve seçim davranışları daha birleşik.
3. **Eşya kısıtlama düzenleme daha anlaşılır**: Daha zengin kısıtlama türleri yapılandırmayı ve incelemeyi kolaylaştırır.
4. **Birden fazla sayfada durum çubuğu ve üst çubuk oluşturma daha stabil**: Mağaza, Dünya, Arama, Durum, Başarımlar, Sayfam ve WebDAV gibi sayfalardaki üst alanlar kaydırma, karanlık mod ve Material You altında daha tutarlı davranır.
5. **Durum sayfası Özellik düzeni daha uzun metinleri daha iyi karşılar**: Daha uzun Özellik adları ve Seviye etiketleri dar ekranlarda veya daha büyük metinle daha güvenilir şekilde sığar.

**🐛 Hata Düzeltmeleri**

1. **Kopya oluşturma gid varyasyon sorunu düzeltildi**: Tek seferlik veya sınırsız gecikmiş Görevlerden oluşturulan kopya Görevlerin tutarsız gid'lere sahip olması düzeltildi.
2. **Özellik seçiminde işlevsiz "Rastgele" onay kutusu düzeltildi**: Bazı Özellik seçim kutularının işlevsiz "Rastgele" onay kutusu göstermesi düzeltildi.
3. **Ödül afişi konumlandırma sorunları düzeltildi**: Ödül afişlerinin belirli senaryolarda (özellikle Görev tamamlama tetiklendiğinde) hatalı konumlanması, gizlenmesi veya sıçraması düzeltildi.
4. **Bazı durumlarda hatalı gecikme Ödül önizlemesi/animasyon verisi düzeltildi**: Gecikmiş bir Görev tekrar tamamlandı olarak işaretlendiğinde Deneyim Puanı, jeton ve Eşya değişiklikleri artık kafa karıştırıcı değerler karıştırmadan daha doğru sunulur.
5. **Bazı durumlarda durum sayfası Seviye düzeni kaydırma/hizalama hatası düzeltildi**: Uzun Özellik adları veya daha uzun Seviye etiketleriyle düzen artık daha stabil.
6. **Sentez listesinde yalnızca birkaç Eşya varken sayfa geçişi düzeltildi**: Liste içeriği kısa olduğunda boş alanlardan yatay kaydırma artık daha güvenilir.
7. **Özel durumlarda Başarım Ödüllerini alırken çökme düzeltildi**: Belirli uç durumlarda Başarım Ödüllerini alırken oluşabilecek çökme giderildi.

**v1.102.11 (2026/04/02)**

**🐛 Hata Düzeltmeleri**

1. **Ana sayfadaki sayım Görevlerinde ara sıra oluşan hesaplama hataları ve yenileme anomalileri düzeltildi.**

**v1.102.10 (2026/03/24)**

**🐛 Hata Düzeltmeleri**

1. **Gizli Sentez tarifi listelerinde formülleri düzenlemek veya silmek için uzun basılamaması düzeltildi.**

**v1.102.9 (2026/03/23)**

**♻️ Optimizasyon**

1. **Alt gezinme devre dışı bırakma kuralı güncellendi**: Etkileşim düzeyinde kullanıcıların artık tüm alt gezinme modüllerini devre dışı bırakmasına izin verilmez.

**🐛 Hata Düzeltmeleri**

1. **Başlangıç çökmesi düzeltildi**: Tüm alt gezinme modülleri devre dışı bırakıldıktan sonra App'in açılışta çökebilmesi düzeltildi.

**v1.102.8 (2026/03/23)**

**✨ Yeni Özellikler**

1. **Varsayılan modül düzenini sıfırlama**: Modül yapılandırma sayfasına "Varsayılan Düzeni Geri Yükle" düğmesi eklendi.
2. **Yeni Sentez tarifi yayın olayı**: Bir Sentez tarifi başarıyla tamamlandığında gönderilen `app.lifeup.synthesis.complete` API yayın olayı eklendi.
3. **Dünya araması kaynak etiketi filtrelemesini destekler**: Dünya bölümü artık kaynak etiketlerine göre arama yapabilir; örneğin Vitrin'de aramadan önce API Eşyalarını filtreleme.

**♻️ Optimizasyon**

1. **Başarım açılış popup tipografi iyileştirmeleri**: Büyük sistem yazı tipi boyutları kullanıldığında yazı tipi oluşturma iyileştirildi ve düzen sorunları azaltıldı.
2. **Modül gizleme mantığı iyileştirmeleri**: Dünya modülüyle ilgili Başarımların doğru gösterilip gizlenmesi için modül gizleme davranışı rafine edildi.
3. **Rastgele Görev varsayılan atama davranışı ayarlandı**: Yeni oluşturulan rastgele Görevler artık otomatik olarak varsayılan listeye atanmaz; sessiz atama önlendi.

**🐛 Hata Düzeltmeleri**

1. **Görev listesi yenilenirken nadir bir çökme düzeltildi**.
2. **Duygular API başlık sorunu düzeltildi**: API'nin Duygular başlığını doğru sağlayamaması düzeltildi; bu Eşya başlıklarını da etkileyebilirdi.
3. **Pomodoro yatay düzen sorunları düzeltildi**.
4. **Görev geçmişi API'sinde bitiş zamanı damga türü düzeltildi**.
5. **Eksik API yanıt alanları eklendi**: Görev ilerlemesi, tamamlama durumu, tekrar bitiş koşulları ve ilgili alanlar artık doğru döndürülür.
6. **Sayım Görevi ayrıntı sayfasındaki eski değerler düzeltildi**: Sayım Görevi güncellendikten sonra değerler artık hemen yenilenir.
7. **Anormal Pomodoro kayıt sürelerine neden olabilecek sorun düzeltildi**.
8. **Çevrimdışı moda girdikten sonra ana sayfanın hemen yeniden oluşturulmaması düzeltildi**: Bu daha önce Dünya bölümünün beklenmedik şekilde görünür kalmasına yol açabilirdi.
9. **Rastgele Görev sayfası yükleme sorunu düzeltildi**: Bazı durumlarda sayfa yükleme durumunda takılı kalabilirdi.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Optimizasyon**

1. **Widget ekleme eğitimi + metin iyileştirmeleri**: Widget ekleme rehberi eklendi; ilgili metin ve ipuçları rafine edildi.

**🐛 Hata Düzeltmeleri**

1. **Anormal veriyle Pomodoro kilitlenmesi düzeltildi**: Anormal veri varken Pomodoro sayfası artık takılı/kilitli kalmaz.
2. **Ekran kapandıktan sonra eklenti zamanlayıcı senkronizasyonu düzeltildi**: "Süre ekle" zamanlayıcısı ekran kapandıktan veya cihaz uyuduktan sonra senkron kalır.
3. **Yeni Görevler için varsayılan liste seçimi düzeltildi**: Akıllı listelerden Görev oluştururken işleme iyileştirildi; varsayılan liste arşivlenmişse artık düzgün geri düşer.

**v1.102.1 (2026/01/27)**

**✨ Yeni Özellikler**

1. **Görsel Önizleme Yakınlaştırma**: Sayfa yeniden düzenlemesi sırasında kaybedilen görsel yakınlaştırma işlevi geri getirildi; görsel ayrıntılarını daha kolay inceleyebilirsiniz.

**🐛 Hata Düzeltmeleri**

1. **WebDAV Bellek Optimizasyonu**: WebDAV'dan indirmenin aşırı bellek tüketerek çökmelere veya performans sorunlarına yol açabilmesi düzeltildi.
2. **Yansımalar Görsel Yenileme**: Yansımalar sayfasında düzenlenen görsellerin hemen yenilenmemesi hatası giderildi.

**v1.102.0 (2026/01/25, replaced by v1.102.1 during rolling release)**

**✨ Yeni Özellikler**

1. **Ses Yöneticisi**: Ses efektlerini içe aktarın, önizleyin, silin ve yeniden kullanın; Eşya kullanım efektleri olarak kullanın.
2. **Mağaza: yeni Eşya kullanım efektleri**: Rastgele Deneyim Puanı, stok değişiklikleri, ses oynatma eklendi; yapılandırma akışı iyileştirildi.
3. **Zamanlı Görevler**: Beklenen Odak süresi olan yeni bir Görev türü; zamanlayıcı hedefine ulaştıktan sonra Görevi tamamlayın.
4. **Hafta Başlangıç Günü Seçenekleri**: Pazartesi / Cumartesi / Pazar seçin; takvim ve istatistikler buna göre ayarlanır.
5. **Onboarding'i atla**: İlk açılışta eğitimi atlama seçeneği.
6. **Simge için emoji girişi**: Hızlı simge oluşturmak için emoji (birleşik emojiler dahil) girin.
7. **Takvim: gelecekteki tekrarlayan Görev ayrıntılarını açma**: Gelecek bir tarihteki tekrarlayan Göreve dokunmak artık ayrıntılarını doğru açar.
8. **İleri düzey kullanıcılar: API geliştirmeleri**: URL Scheme API'si Görev şablonu CRUD, tekrar bitiş koşulları, Sentez filtre gezinmesi ve daha fazlasını ekler/genişletir.

**♻️ Optimizasyon**

1. **Performans ve akıcılık iyileştirmeleri**: Veri erişimi ve dizinleme stratejileri optimize edildi; büyük veri kümelerinde Görev listeleri, Envanter geçmişi ve istatistikler daha akıcı.
2. **Daha iyi Eşya efekt yapılandırma UX'i**: Efekt seçimi ve görüntüleme etkileşimleri iyileştirildi; iletişim kutuları ve simge görselleri rafine edildi.
3. **Yerelleştirme iyileştirmeleri**: Birden fazla dilde eksik çeviriler tamamlandı.

**🐛 Hata Düzeltmeleri**

1. **Düzenlemede geri sayım efektinin sıfırlanması düzeltildi**: Düzenlenen geri sayım efektini onaylamanın değeri 1'e sıfırlayabilmesi düzeltildi.
2. **Ekip Görevi Eşya Ödülü otomatik kullanımının tetiklenmemesi düzeltildi**: Ekip Görevleri için Eşya Ödüllerini aldıktan sonra otomatik kullanımın tetiklenmemesi düzeltildi.
3. **Ganimet Kutusu / Sentez sonrası eksik "duygu kaydet" istemi düzeltildi**: Eşyada "duygu kaydet" efekti varken Ganimet Kutularını açtıktan veya basit Sentez kullandıktan sonra Duygular iletişim kutusunun görünmeyebilmesi düzeltildi.
4. **Pomodoro manuel tamamlamada eksik hesaplama iletişim kutuları düzeltildi**: Pomodoro sayfasında Görevi manuel tamamlamanın Ödül/Duygular hesaplama iletişim kutularını atlayabilmesi düzeltildi; Görev başlığında uzun basarak tamamlama geri getirildi.
5. **Widget katlama filtresinin çalışmaması düzeltildi**: Akıllı liste widget filtresi "Henüz başlamamış Görevleri katla" etkisiz kalıyordu.
6. **Nadir bir çökme düzeltildi**: Belirli durumlarda çok fazla durum kaydedilmesinin neden olduğu çökme giderildi.
7. **Gelecek Görevler için takvimden ayrıntıya gezinme düzeltildi**: Takvim görünümünden gelecekteki tekrarlayan Görevlerin ayrıntılarını açma hataları giderildi.
8. **Ebbinghaus tekrarlayan Görev sorunları düzeltildi**: Nadir durumlarda anormal aşamalar ve istenmeyen tekrarlı oluşturma düzeltildi; üst sınır koruması eklendi.

**v1.101.8 (2026/01/12)**

**🐛 Hata Düzeltmeleri**

1. **Tekrar bitiş koşulu ayarları düzeltildi**: "Her 2 günde bir" veya özel "Her N günde bir" sıklıkları için bitiş koşulunun ayarlanamaması giderildi.
2. **Anormal Pomodoro zamanlayıcı süresi düzeltildi**: Pil optimizasyonu düzgün devre dışı bırakılmadığında sistem uykusu veya işlem donması nedeniyle zamanlayıcının beklenenden çok daha uzun çalışabilmesi düzeltildi.

**v1.101.7 (2026/01/11)**

**🐛 Hata Düzeltmeleri**

1. **Pomodoro zamanlayıcı süresinin anormal şekilde kısalmasına neden olabilecek sorun düzeltildi**.

**v1.101.6 (2026/01/10)**

**🐛 Hata Düzeltmeleri**

1. **Sistem karanlık modu geçişiyle ilgili anomaliler düzeltildi**.

**v1.101.5 (2026/01/08)**

**♻️ Optimizasyon**

1. **Sistem karanlık modu geçişi optimize edildi**: App'in sistem ayarlarıyla birlikte temayı otomatik değiştirememesi sorunları düzeltildi.
2. **Ödüller için Özellik seçimi optimize edildi**: "Süreklilik Ödülleri", "Adım Ödülleri" ve "Beğeni Ödülleri"nde Özellik seçilmediği durumların işlenmesi iyileştirildi. Özellik seçiminin kaldırılması desteklendi; Deneyim Puanı Ödüllerinin doğru verilmemesi sorunları düzeltildi.
3. **Performans yapılandırma optimizasyonu**: App performansını potansiyel olarak iyileştirmek için dahili yapılandırmalar optimize edildi.

**🐛 Hata Düzeltmeleri**

1. **İstatistik sorguları ve grafik görüntüleme düzeltildi**: Görev tamamlama süresi istatistikleri için sorgu koşulları düzeltildi; hatalı grafik verisi görüntüleme sorunları giderildi.
2. **Widget ayarları iletişim kutusu etkileşimi düzeltildi**: Widget Görev filtresi ayarları iletişim kutusunda "Onayla" düğmesinin eksik olması hatası giderildi.
3. **Görev sayısı senkronizasyonu düzeltildi**: Görev ayrıntı sayfasından güncellendikten sonra ana ekrandaki Görev sayısının doğru yenilenmemesi düzeltildi.
4. **Duygular API Eşya kullanım işleme düzeltildi**: Duygular API'sinde "Eşya Kullanımı" türlerinin hatalı işlenmesi düzeltildi.
5. **Takvimden ayrıntıya gezinme düzeltildi**: Takvim görünümünden Görev ayrıntılarına geçerken oluşan birkaç sorun giderildi.

**v1.101.4 (2025/12/30)**

**♻️ Optimizasyon**

1. **Üye güncelleme algılama mantığı optimize edildi**: Üyeler, en stabil işlev deneyimini sağlamak için güncellemeler için "Üye Kararlı Kanalı"na geçmeye yönlendirilir.
2. **Gereksiz ağ istekleri azaltıldı**: Kullanıcı verisi daha fazla tasarruf edilir ve sunucu maliyetleri düşer.

**🐛 Hata Düzeltmeleri**

1. **Başarım ilerlemesi güncelleme sorunu düzeltildi (Öncelikli)**: Pomodoro kayıtları tamamlandığında Başarım ilerlemesinin doğru tetiklenmemesi hatası giderildi.

**v1.101.3 (2025/12/14)**

**🐛 Hata Düzeltmeleri**

1. **"Bugün vadesi dolan" seçeneğinin ertesi gün son tarihi kaydırmasını hatalı şekilde yok sayması düzeltildi.**

**v1.101.2 (2025/12/13)**

**🐛 Hata Düzeltmeleri**

1. **Mağaza, Envanter veya Görev sayfalarına dönüldüğünde arama durumunun sıfırlanması düzeltildi.**
2. **`AlarmManager` limitleriyle ilgili çökme düzeltildi** (yaklaşık 500 eşzamanlı alarm).
3. **Dinamik renkler, saat dilimi iletişim kutuları ve açılır menülerle ilgili çökmeler düzeltildi.**
4. **Çökme raporlaması optimize edildi**; yaygın ağ hataları yok sayılır.

**v1.101.1 (2025/12/01)**

**🐛 Hata Düzeltmeleri**

1. **Çeviri biçimlendirme hatalarının potansiyel çökmelere yol açması düzeltildi.**

**v1.101.0 (2025/11/29)**

**✨ Yeni Özellikler**

1. **Sentez Eşya filtresi**: Daha hızlı arama ve yönetim için Sentez'i Eşyalara göre filtreleyin.
2. **Eşya ayrıntıları → Sentez tarifi**: Bir Eşyanın Sentez tarifini doğrudan Eşya ayrıntıları sayfasında görüntüleyin.
3. **Mağaza → Sentez girişi**: Bir Eşya Sentez'de kullanılabiliyorsa Satın Al düğmesinin yanında artık bir Sentez düğmesi görünür.
4. **Envanter geçmişi filtreleri**: Tarih, Eşya ve açıklamaya göre filtreler eklendi.
5. **"Yenilikler" iletişim kutusu**: Güncellemeden sonraki ilk açılışta yeni sürüm öne çıkanları iletişim kutusu.
6. **Görev başına Pomodoro Odak süresi**: Pomodoro mantığı yeniden düzenlendi; Görev başına özel Odak süresi desteklenir.
7. **Eşya kullanım efekti: "Kullanımdan sonra duygu kaydet"**; Duygular sayfası Eşyaya göre filtrelemeyi de destekler.
8. **Pomodoro yaşam döngüsü yayınları (API)**: Yaşam döngüsü yayın olayları eklendi.
9. **Basit sorgu API'si**: Artık tek bir Görevin ayrıntılarını getirmeyi destekler.
10. **Sayım Görevleri otomatik artış**: Otomatik artış desteklenir.
11. **Tarihe göre tekrar bitişi**: Görevler artık tekrarı belirli bir tarihte sonlandırmayı destekler.
12. **Masaüstü widget ayarları yükseltmesi**: App içi masaüstü widget ayarları sayfası iyileştirildi — desteklenen her widget önizlenebilir ve sistem izin verdiğinde hızlıca ana ekrana eklenebilir.

**♻️ Optimizasyon**

1. **Liste yönetimi UX + karanlık mod**: Etkileşimler ve karanlık mod rafine edildi; "Tümü" listesi artık silinemez bir eylem yerine devre dışı silme durumu gösterir.
2. **Mağaza ayarları sayfası**: Bağımsız bir sayfaya taşındı ve ana Ayarlar'dan erişilebilir.
3. **Görev varsayılan arka planı**: Yardım iletişim kutusundaki ifade netleştirildi.
4. **Hızlı Tamamla göstergesi**: Etkinleştirildiğinde Görevler sayfası üstte Hızlı Tamamla durumunu gösterir.
5. **Liste başına katlama hafızası**: "Tümü"nün gün listesini etkilememesi için katlama/açma durumu liste başına kaydedilir.
6. **Gecikmiş Görev iletişim kutusu (karanlık mod)**: Gecikmiş Görevleri işlerken karanlık mod stilleri iyileştirildi.
7. **Duygular filtre düğmesi mantığı**: Yalnızca filtrelemeyi destekleyen türler için gösterilir (Eşyalar/Görevler).
8. **Yalnızca yerel Görevler ekip akışı**: Yalnızca yerel Görevler toplanırken etkileşim iyileştirildi.
9. **Sentez sayfası arayüz iyileştirmesi**: Daha akıcı sunum için Sentez sayfasındaki düzen ve görsel geri bildirim rafine edildi.
10. **Eşya etkileşimi iyileştirmesi**: Eşyalarla ilgili etkileşimler daha duyarlı bir his için sadeleştirildi.

**🐛 Hata Düzeltmeleri**

1. **Geçmiş sayfasında filtrelemeden sonra üst filtre çubuğunun doğru görüntülenmemesi düzeltildi.**
2. **Belirli durumlarda ceza Görevlerinin doğru 1× ceza sayısıyla ceza hesaplamaması düzeltildi.**
3. **Belirli koşullarda Pomodoro zamanlayıcısının Görev seçicisinin "Seçimi iptal et" seçeneğini kaybedebilmesi düzeltildi.**
4. **Sistem karanlık modu ayarlarını izlemeyle ilgili birkaç sorun düzeltildi.**
5. **Bir widget sayım Görevini tamamladığında eksik Ödül açılır penceresi düzeltildi.**

**v1.100.6 (2025/11/08)**

**🐛 Hata Düzeltmeleri**

1. **Harici klavye/oyun kumandası nedeniyle giriş odağı taştığında Eşya seçerken oluşan çökme düzeltildi**; düzeltmenin etkinliği doğrulanıyor.
2. **Akıllı saat dilimi yönetimi iletişim kutusunun alt içeriği ve düğmeleri göstermek için kaydırılabilmesi düzeltildi.**

**v1.100.5 (2025/09/28)**

**✨ Yeni Özellikler**

1. **Özel ses efektleri artık yerleşik ses seçimini destekler**: Daha kolay özelleştirme için yerleşik ses efektleri kütüphanesine erişin.
2. **Geliştirilmiş Sentez filtreleme**: Daha iyi Eşya yönetimi için Sentez sayfasına "Yalnızca sentezlenebilirleri göster" filtre seçeneği eklendi.
3. **API emoji desteği**: Eşya, Özellik ve Başarım API'leri artık gelişmiş özelleştirme için doğrudan emoji girişini destekler.
4. **Ekip oluşturma iyileştirmeleri**: Daha iyi organizasyon için ekip oluştururken hedef listeleri seçme eklendi.
5. **Ekip Görevi kopyalama**: Ekip üyeliği gerektirmeden ekip Görevlerini yerel Görev olarak kopyalama desteklenir.
6. **Görev API geliştirmesi**: Görevle ilgili API'lerde "açık not yazı tipi" durumunu ayarlama parametre desteği eklendi.

**♻️ Optimizasyon**

1. **"Değişiklikleri at" mantığı iyileştirildi**: Eşya düzenleme, Sentez, Başarımlar ve Başarım listeleri için değişiklikleri at onay iletişim kutusu optimize edildi — artık yalnızca gerçek değişiklik yapıldığında görünür.
2. **Başarım açılış koşulları**: Başarım açılış koşulları artık daha iyi görünürlük için varsayılan olarak genişletilir.
3. **Geliştirilmiş Sentez performansı**: Sentez ayrıntıları sayfası sorgu performansı optimize edildi.
4. **Toast API kararlılığı**: Toast API çağrılarının kararlılığı ve güvenilirliği iyileştirildi.
5. **Ekip Görevi tamamlama akışı**: Daha iyi hata işleme ve kullanıcı yönlendirmesiyle ekip Görevi tamamlama süreci geliştirildi.
6. **Sentez sürükleme davranışı**: Sentez sayfasında özel sıralama yaparken kenara sürükleyerek kaydırma davranışı iyileştirildi.
7. **Ekip Görevi toplama akışı**: Ekip Görevleri toplandıktan sonra ilgili listelere atlama desteğiyle iş akışı geliştirildi.
8. **Takvim hatırlatıcı optimizasyonu**: Daha iyi güvenilirlik için takvim hatırlatıcı mantığı iyileştirildi.

**🐛 Hata Düzeltmeleri**

1. **Eski sürümlerdeki özel arka planların hatalı şekilde genel varsayılan "açık not yazı tipi" durumunu kullanması düzeltildi.**
2. **Özel ses efektleri sayfasında durum çubuğu uyumluluk sorunları düzeltildi.**
3. **Başarım açıklamasının açılış düğmeleriyle çakışabilmesi düzeltildi.**
4. **Sentez ayrıntıları sayfasında sürükleyerek sıralarken kaydırma sorunları düzeltildi.**
5. **Dünya modülü kenar çubuğuna yerleştirildiğinde arama düğmesinin ara sıra kaybolması düzeltildi.**
6. **Gece modu sistem izleme anomalilerini düzeltmeye çalışıldı.**
7. **Ardışık ekip Görevi tamamlamalarının Görev çoğaltmasına yol açabilmesi sorununu düzeltmeye çalışıldı.**
8. **Başarımlar açılırken "Duygular" işlevinin çalışmaması düzeltildi.**

**v1.100.4 (2025/09/07)**

**♻️ Optimizasyon**

1. **Çökme raporlama iyileştirmeleri**: Daha iyi sorun analizi ve hata ayıklama için çökme toplama ve raporlama geliştirildi.

**🐛 Hata Düzeltmeleri**

1. **Facebook SDK kaynaklı çökme sorunu düzeltildi.**

**v1.100.3 (2025/09/06)**

**🐛 Hata Düzeltmeleri**

1. **Eşya seçerken aramanın çalışmaması düzeltildi.**

**v1.100.2 (2025/09/05)**

**🐛 Hata Düzeltmeleri**

1. **Mağazada Eşya oluştururken veya düzenlerken belirli durumlarda varsayılan listenin seçilememesi düzeltildi.**

**v1.100.1 (2025/09/03)**

**✨ Yeni Özellikler**

1. **Özel arka plan yazı rengi seçenekleri**: Özel not yazı rengi seçenekleri desteği eklendi; arayüz deneyimi daha da kişiselleştirildi.
2. **Geliştirilmiş Eşya kullanım efektleri**: Rastgele jeton azaltma efektleri artık "Kullanımı Sınırla" işlevini etkinleştirmeyi de destekler.

**♻️ Optimizasyon**

1. **Takvim hatırlatıcı işlevi optimizasyonu**: Eklenen takvim hatırlatıcı etkinliklerinin süresini ayarlama seçenekleri eklendi.
2. **Görev düzenleme etkileşimi optimizasyonu**: Görev düzenlerken "değişiklikleri at" açılır penceresinin mantığı iyileştirildi — düzen yapılmadan çıkıldığında artık gösterilmez.
3. **Çok dilli yerelleştirme güncellemeleri**: Kullanıcı deneyimini iyileştirmek için yerelleştirilmiş çok dilli metinler güncellendi.

**🐛 Hata Düzeltmeleri**

1. **Uyumluluk yapılandırma sayfası ve hatırlatıcı ayarları sayfasının karanlık moda uyum sağlamaması düzeltildi.**
2. **Birden fazla sayfada açılır pencere ve giriş yöntemi odağıyla ilgili çökme sorunlarını düzeltmeye çalışıldı**; App kararlılığı iyileştirildi.
3. **Başarımları düzenlerken Eşyaların otomatik kullanılıp kullanılmayacağının değiştirilememesi düzeltildi.**

**v1.100.0-alpha (2025/07/29)**

**✨ Yeni Özellikler**

1. **Pomodoro zamanlayıcı, Deneyim Puanı değerleri, depo geçmişi, jeton ayrıntıları** ilgili istatistik sayfasına tek tıkla atlama işlevi eklendi.
2. Daha esnek hatırlatıcı etkinliği ayarları desteği (başlangıçtan veya son tarihten X dakika önce).
3. Sentez listelerini gizleme desteği.
4. Adım sayıları ve süreklilik Ödülleri için Özellik değiştirme desteği.
5. Kenar çubuğu işlev modüllerini özelleştirme desteği (Mağaza, topluluk gibi modülleri kenar çubuğuna koyma veya gereksiz modülleri gizleme).
6. Deneysel **"Düşük Kısıtlama Modu"** seçeneği eklendi: App içindeki sayısal limitleri gevşetir (Deneyim Puanı değerleri, jeton basamakları, Görevler için seçilebilir Özellik sayısı gibi).
7. Gecikmiş işleme açılır penceresinin arayüzü ve etkileşim mantığı optimize edildi.
8. Otomatik Eşya kullan seçenekleri için açıklama eklendi.
9. Daha fazla tekrarlanabilir açılış koşulu desteği:
   - Günlük Pomodoro ağacı kazanımı.
   - Günlük Pomodoro Odak süresi.
   - Günde N farklı Görev tamamlama.
   - Günde belirli bir Eşyayı N kez kullanma.
   - Günde belirli bir Görevi N kez tamamlama.
10. Akıllı liste seçenekleri liste yönetimi açılır penceresine taşındı (Görev listesi sayfasının üstündeki liste düğmesine tıklayın).
11. **"Hızlı Tamamla"** seçeneği eklendi: etkinleştirildiğinde Görev tamamlama tüm açılır pencereleri atlar.
12. Özel jeton simgelerinin etki alanı genişletildi; artık tek renkli simgeler desteklenir (Mağaza üstündeki jeton simgeleri gibi).
13. Eşya ayrıntıları artık Eşyanın hangi listeye ait olduğunu gösterir; depodan Eşya sahipliğini doğrulamayı kolaylaştırır.
14. Sentez tariflerini düzenlerken sürükleyerek sıralama ve tıklayarak düzenleme desteklenir.
15. Jeton sayılarını doğrudan düzenlemek için API eklendi.
16. Sorgu API'si Pomodoro bilgilerini sorgulamayı destekler (Pomodoro sayısı).
17. Bazı API'ler için sayısal limitler gevşetildi (varsayılan API düşük kısıtlamalı).
18. **Başarım koşulu ilerleme hesaplama mekanizması yeniden tasarlandı ve optimize edildi**: Hesaplama performansı ve ilerleme güncelleme hızı iyileştirildi.

**♻️ Optimizasyon**

1. **"Sayfam" sayfasındaki süreklilik günleri optimize edildi**; manuel tıklamayla yeniden hesaplama desteklenir.
2. Takvim sayfasındaki RTL düzen sorunları düzeltildi; hafta başlangıç günü **"Pazartesi"** olarak ayarlandı (önceden Pazar).
3. Görev ve Mağaza akıllı listelerindeki grup görüntüsü grup etiketlerine göre katlama/açmayı destekler.
4. Görev listesi altta tamamlanan, başlamamış, dondurulmuş bölümleri genişlettiğinde ilgili etiketler üstte de görünür.
5. Dünya modülünden içe aktarılan Eşya simgeleri yerel olarak kalıcı kaydedilir; çevrimdışıyken yüklenememe önlenir.
6. Liste seçimi açılır penceresi artık akıllı listeleri tanımlar.
7. Ekip Görevleri ve rastgele Görevler için varsayılan liste mantığı optimize edildi: varsayılan liste arşivlenmişse ilk listeyi seçmeye geri düşer.
8. Sayım Görevleri için gecikmiş işleme mantığı optimize edildi: sayım hedefe ulaştıysa varsayılan olarak **"Tamamlandı"** durumu.

**🐛 Hata Düzeltmeleri**

1. **Başarımları düzenlerken "otomatik Eşya kullan" onay kutusu durumunun doğru geri yüklenememesi düzeltildi.**
2. **Akıllı liste üst kartı sayım sorunu düzeltildi**: arşivlenmiş listelere ait Görevler hariç tutulamıyordu.
3. **Eşya satın alma "otomatik kullan" onay kutusu durumu için genel hafıza sorunu düzeltildi**; Eşya başına bağımsız hafızaya geçildi.
4. **Başarım açma API'sinin belirli durumlarda ilerlemeyi doğru güncelleyememesi düzeltildi.**
5. **Ekip Görevleri ve rastgele Görevler için varsayılan liste mantığı sorunları düzeltildi.**
6. Teknik bağımlılık kütüphaneleri yükseltildi; hedef API sürümü 35'e (Android 15) ayarlandı.

**Alpha/Beta Yama Düzeltmeleri**

1. Gereksiz bağımlılıklar kaldırıldı ve 16K sayfa boyutuna uyarlandı; **App paket boyutu küçültüldü**.
2. **Otomatik Eşya kullan** işlev mantığı düzeltildi: URL Eşyaları için artık yalnızca 1 Eşya kullanılır, geri kalanı depoda saklanır. (Önceden yalnızca 1 etkili olurdu ancak depoda saklanmıyordu; kullanım efekti kaybına yol açıyordu)
3. **Tekrarlanabilir Başarım koşullarının** ilerlemeyi yeniden hesaplayamaması düzeltildi.
4. **Yedek dosyalarının** Görev şablonlarını içermemesi düzeltildi.
5. **Yedek geri yüklemeden sonra çoğu emojinin anormal simgeleri yeniden oluşturması** düzeltildi.
6. App içi geri bildirim için **QQ kanal bağlantısı** güncellendi.
7. **Duygular yayınlama yayını** özelliği eklendi.
8. Uyumluluk yapılandırması ve hatırlatma yöntemi ayarları arayüzü **yeniden tasarlandı**.
9. **Jeton azaltma efektleri** için "Eşya kullanımını kısıtla" seçeneği eklendi.
10. **API ile ilgili güncellemeler**: Görev API'sine motivasyon mesajı parametreleri desteği eklendi.
11. Yeni Eşya varsayılan ayarları sayfasındaki anormal üst boşluk sorunu düzeltildi.

**v1.99.5 (2025/07/29)**

**🐛 Hata Düzeltmeleri**

1. **Belirli durumlarda özel arka planların doğru görüntülenmemesi sorununu düzeltmeye çalışıldı.**

**v1.99.3 (2025/06/30)**

**✨ Yeni Özellikler**

1. Alt görev API'si göreli ayarlamayı destekler (`set_type`).
2. Süresi dolmuş takvim hatırlatıcı etkinliklerinin otomatik temizlenmesi desteklenir.
3. Arşivlenmiş listeler için işleme mantığı optimize edildi:

* Akıllı listeler artık arşivlenmiş Görevleri göstermez.
- Arşivlenmiş listelerdeki Görevler varsayılan olarak otomatik ilerlemez (dondurulmuş duruma benzer).

**♻️ Optimizasyon**

1. Görev/Başarım sürekli eklenirken üste otomatik kaydırma ve giriş alanına odaklanma desteklenir.
2. Negatif Görevleri tamamlamayla ilgili ifade optimize edildi.
3. Görev düzenleme sayfasındaki "Değişiklikleri At" açılır penceresinin görüntüleme mantığı optimize edildi.
4. Bazı cihazlardaki potansiyel sorunları önlemek için takvim hatırlatıcıları etkinlik süresi optimize edildi.

**🐛 Hata Düzeltmeleri**

1. **Widget'ların özel jeton simgelerini göstermemesi düzeltildi.**
2. **Görev ayrıntı sayfasının çoklu Eşya Ödüllerini göstermemesi düzeltildi.**
3. **Belirli senaryolarda (ör. widget'lar) liste sıralama kurallarına uyulmaması düzeltildi.**

**v1.99.1-rc02 (2025/06/20)**

**✨ Yeni Özellikler**

1. "Ardışık N Görev tamamla" için tekrarlanabilir Başarım açılış koşulları desteklenir.
2. Görev Oluştur/Düzenle API'si artık Görev türünü ve jeton/Deneyim Puanı değerlerinin göreli ayarlamasını destekler.
3. Başarım API'si jeton ayarlamayı ve jeton/Deneyim Puanı değerlerinin göreli ayarlamasını destekler.
4. API'ler belirli Başarım listelerine ve Sentez listelerine atlamayı destekler.

**♻️ Optimizasyon**

1. Kutular açılırken oluşturulan depo Eşya geçmişi kayıtlarının sırası optimize edildi.
2. İstatistik sayfası filtre seçenekleri artık hafızayı destekler.
3. Filtre sayfası seçenekleri "Tümünü Seç" işlemini destekler.
4. Görev oluşturma yinelenen kayıt engelleme mantığı güçlendirildi.
5. Görev ayrıntı sayfası işlemleri tamamlandı: dondur, son tarihi ayarla.
6. Sentez listesi kimliğini gösterme desteklenir.

**🐛 Hata Düzeltmeleri**

1. **Önceki Görev API'sinin Ebbinghaus Görevlerini oluşturamaması/düzenleyememesi düzeltildi.**
2. **Görev listesi widget'ından App başlatıldığında Görev listesi görüntüsü ile üst çubuktaki liste adının tutarsız olabilmesi düzeltildi.**
3. **Basit mod kartındaki metnin tam görüntülenmemesi düzeltildi.**

**v1.99.0 (2025/05/17)**

**✨ Yeni Özellikler**

1. Tekrarlanabilir Başarım türleri desteği eklendi
2. Bildirim hatırlatıcı eylemleri eklendi: Görevi tamamla, daha sonra hatırlat
3. Özel arka plan: metin okunabilirliğini artırma seçeneği eklendi
4. Başarım simgesi kırpma stilini ayarlama desteği eklendi
5. Aylık/yıllık Görev çapa tarihlerini ayarlama desteği eklendi

**♻️ Optimizasyon**

1. Başarım açılış ilerlemesi hesaplama mantığı optimize edildi
2. Eşya seçimi etkileşimleri iyileştirildi
3. Görev oluşturma/düzenleme ekranlarında hatırlatıcı izni düğmesi konumu ayarlandı
4. Göreli hatırlatma zamanı depolama mantığı optimize edildi
5. Tekrarlanmayan ve sonsuz tekrarlayan Görevlerin dondurulmasına izin verildi

**🐛 Hata Düzeltmeleri**

> Bazı düzeltmeler kademeli olarak [Üye Kararlı Sürüm] ve [Resmi Sürüm]'e dağıtılacaktır

1. **Başarımları düzenlemenin API açılış koşulu ilerlemesini yanlışlıkla sıfırlayabilmesi düzeltildi**
2. **Stok 0 olan Eşyaların API ile hâlâ satın alınabilmesi düzeltildi**
3. **Yeni Eşya sayfasında belirli koşullarda silinmiş listelerin seçilebilmesi düzeltildi**
4. **Görev şablonlarının otomatik hesaplanan jeton Ödül durumunu kaydedememesi düzeltildi**
5. **Uzun basma etkileşim hatalarını gidermek için ayrıntı sayfası geçiş animasyonları kaldırıldı**
6. **Dondurulmuş Görevlerin Pomodoro Görev seçiminde görünmesi düzeltildi**
7. **Belirli yöntemlerle Görev düzenlemenin durumu hatalı şekilde tamamlanmamış olarak sıfırlaması düzeltildi**
8. **Duygu açılır pencereleriyle etkileşim sorunları düzeltildi**

**v1.98.5 (2025/05/01)**

**✨ Yeni Özellikler**

1. Aylık ve yıllık tekrarlayan Görevler için çapa tarihi ayarlama desteği eklendi (ör. ay sonu).
2. Eşyalar için çoklu seçim etkileşimi iyileştirildi: varsayılan çoklu seçim modu; yeniden seçerken önceki seçimler geri yüklenir.

**♻️ Optimizasyon**

1. Göreli hatırlatma zamanı ayarlarını hatırlama desteği eklendi.
2. Küçük arayüz optimizasyonları.

**🐛 Hata Düzeltmeleri**

1. **Mağaza stoğu yetersizken Eşyaların API ile hâlâ satın alınabilmesi düzeltildi.**
2. **Görev şablonlarının otomatik jeton Ödüllerini geri yükleyememesi düzeltildi.**
3. **Görev başlıklarında uzun basmanın ara sıra çalışmaması düzeltildi.**
4. **Yeni Eşyaların belirli koşullarda silinmiş listeleri seçebilmesi düzeltildi.**
5. **Görev düzenlerken hatırlatma zamanı alanındaki temizle düğmesinin eksik olması düzeltildi.**

**v1.98.4 (2025/04/14)**

**🐛 Hata Düzeltmeleri**

1. **Görev ayrıntıları sayfasında alt görevler tamamlandıktan sonra ilerleme çubuğunun hemen güncellenmemesi düzeltildi.**
2. **Tamamlanmış bir Görevi düzenlemenin durumu hatalı şekilde "tamamlanmamış"a geri alabilmesi düzeltildi.**
3. **Gecikmiş Görevlerin durumunu değiştirmenin hedef tamamlama sayısını hatalı şekilde etkileyebilmesi düzeltildi.**
4. **Pomodoro Görev seçimi mantığının dondurulmuş Görevleri ve arşivlenmiş listeleri hatalı göstermesi düzeltildi.**

**v1.98.3 (2025/02/16)**

**♻️ Optimizasyon**

1. Varsayılan bildirim hatırlatma yöntemi kullanılırken "kesin alarm" izni yoksa uyarı eklendi.

**🐛 Hata Düzeltmeleri**

1. **UI alanı true olduğunda "Görevi tamamla" API'sinin çalışmaması düzeltildi.**
2. **Belirli Eşya miktarlarının satın alınması ve kullanılmasının doğru çalışmaması düzeltildi** (ör. 10).
3. **Belirli senaryolarda Duygular sayfasının süresiz "yükleniyor" gösterebilmesi düzeltildi.**

**v1.98.2 (2025/02/06)**

**🐛 Hata Düzeltmeleri**

1. **Deneyim Puanı düşüren bir Eşya kullanılırken yeterli Deneyim Puanı varken yetersiz görünmesi düzeltildi.**
2. **Kopyalandıktan sonra bir Eşyayı düzenlemenin anormal yinelenen kullanım efektlerine yol açabilmesi düzeltildi.**
3. **"adjust item" API'sini çağırmanın anormal satın alma limitlerine yol açabilmesi düzeltildi.**
4. **Belirli domates kayıtlarını düzenlemenin domates sayısını anormal şekilde azaltabilmesi düzeltildi.**

**v1.98.1 (2025/01/14)**

**🐛 Hata Düzeltmeleri**

1. **Google giriş yetkilendirmesinde, sınırlı sayıda hesabın verilerinin doğru yetkilendirilememesi ve ayrıştırılamaması sorununu düzeltmeye çalışıldı.**

**v1.98.0 (2025/01/01)**

**✨ Yeni Özellikler**

1. Credential Manager kullanarak Google giriş ve Drive yetkilendirmesi entegre edildi.
2. Simge olarak Emoji seçme desteği.
3. ContentProvider Query API eklendi: Sentez işlevi.
4. ContentProvider Query API eklendi: Domates kaydı işlevi.
5. ContentProvider Query API eklendi: Birden fazla Eşya dönüşü desteği.
6. tomato API eklendi (domates sayısını ayarla).
7. export_backup API eklendi (yedek dışa aktar).
8. purchase_item API eklendi (Eşya satın al).
9. synthesize API eklendi (Sentez tetikle).
10. subtask API eklendi (alt görev oluştur veya ayarla).
11. subtask_operation API eklendi (alt görevleri işlet, örn. tamamla).
12. synthesis_formula API eklendi (Sentez formülü).
13. edit_task API eklendi (Görev düzenle).
14. category API eklendi (liste oluştur veya ayarla).
15. history_operation API eklendi (geçmişi ayarla).
16. AppSettingsScheme API eklendi (bazı App ayarlarını ayarla).
17. achievement API eklendi (Başarım oluştur veya düzenle).
18. skill API eklendi (Özellik oluştur veya düzenle).
19. Alt görev id ve gid gösterme desteği eklendi.
20. Sentez id gösterme desteği eklendi.
21. creditLimit sorgulama desteği eklendi.
22. ContentProvider API alt görev sorgulamayı destekler (id, gid).
23. ContentProvider API Eşya sorgusu: "maksimum satın alınabilir miktar" alanı dönüşü eklendi.
24. ContentProvider Mağaza API'si belirtilen id listesine göre Eşya sorgulamayı destekler.
25. Hatalı ContentProvider URL sorgulandığında dönüş değeri optimize edildi.
26. Sorgu arayüzü tek Başarım sorgulamayı destekler.

**♻️ Optimizasyon**

1. Yeni eklenen Eşyalar için varsayılan özel sıralama optimize edildi.
2. Yeni eklenen Özellikler için varsayılan özel sıralama optimize edildi.
3. "add_item" API'sine `purchase_limit`, `disable_use` ve `effects` parametreleri eklendi.
4. "add_task" API'sine `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` ve `pin` parametreleri eklendi.
5. "add_task" API'sine daha fazla Görev sıklığı desteği eklendi.
6. "item" API'sine `effects` ve `purchase_limit` parametre desteği eklendi.
7. Önceki API işlemlerini sonlandırma desteği eklendi (ör. giriş).
8. Sayısal yer tutucular için `signed` parametresi belirtme desteği eklendi.
9. Rastgele sayı ve rastgele ondalık yer tutucular eklendi.


**v1.97.3 (2024/12/16)**

**✨ Yeni Özellikler**

1. "Ekip açıklamasını Görev notları olarak kullan" anahtarının son seçimini hatırlama desteği eklendi.

**♻️ Optimizasyon**

1. Ürünlerin kullanım efektleriyle ilgili performans optimize edildi.

**🐛 Hata Düzeltmeleri**

1. **Belirli API çağrılarının başarısız olması düzeltildi**: Ürün API'si belirli bir geri çağırma işleviyle çağrıldığında paket açma işlevi normal çalışıyordu, ancak Eşya ekleme için dahili API işlemi yürütülemiyordu.

**1.97.2 (2024/12/08)**

**✨ Yeni Özellikler**

1. Widget kullanılmadığında ve App bir günden uzun süre açılmadığında Görev oluşturmanın atlanmasını önlemek için sistemin WorkManager mekanizmasıyla otomatik Görev oluşturma eklendi.
2. API istisna işleme iyileştirildi: birleşik `success` alanı döndürülür ve istisna bilgisi content provider arayüzüne aktarılır.

**♻️ Optimizasyon**

1. Aylık ve yıllık zaman üretiminin doğruluğunu artırmak için varsayılan zaman üretme mantığı optimize edildi.
2. Kullanılmayan görsel dosyalarını silme mantığı optimize edildi: yanlışlıkla silmeyi önlemek için veritabanından ikinci bir doğrulama adımı eklendi.

**🐛 Hata Düzeltmeleri**

1. Varlık bulunamadığında API hata mesajları iyileştirildi.
2. Yerleşik indiricideki eşzamanlılık sorunları düzeltildi.
3. Gün aşan senaryolarda Pomodoro istatistik mantığı düzeltildi: kayıt ataması bitiş zamanının dönemine birleştirildi (önceden gün aşan kayıtlar günün dönemine doğru atanamıyordu).
4. **Belirli senaryolarda Görev sürekliliği ve dönem tamamlama sayılarının hatalı olması düzeltildi.**

**1.97.1 (2024/11/20)**

**✨ Yeni Özellikler**

1. Çeviriler güncellendi.
2. Notlarda birden fazla Eşya Ödülünün otomatik gösterimi desteklendi.

**♻️ Optimizasyon**

1. Gereksiz HTTP isteklerini azaltmak ve performansı artırmak için ağ isteği işleme optimize edildi.
2. Durum sayfasındaki Seviye gösterimi optimize edildi: görsel deneyim ve bilgi aktarımı iyileştirildi.

**🐛 Hata Düzeltmeleri**

1. Alt Görev sayısı metninin rengi düzeltildi.
2. Aylık ve yıllık Görevlerde zaman hesaplama hataları düzeltildi; Görev tetikleme zamanları doğru hale getirildi.
3. Aylık ve yıllık alt Görevlerde zaman hesaplama sorunları düzeltildi; tüm alt Görevler doğru planlanır.
4. **Görev şablonundan geri yüklerken Görev arka planının doğru geri yüklenememesi düzeltildi**; arka plan ayarları artık doğru uygulanır.

**1.97.0 (2024/10/21)**

**♻️ Optimizasyon**

1. Başlamamış Görevler için Görev kartı gösterimi optimize edildi.
2. Bazı performans sorunları giderildi.
3. Görev ayrıntı sayfası optimize edildi: Görev adına tıklamanın ara sıra etkileşim tetiklememesi sorunu çözüldü.

**✨ Yeni Özellikler**

1. Görev gecikmesi için API yayınına JSON biçim alanları eklendi.

**🐛 Hata Düzeltmeleri**

1. **Material 3 etkinleştirildiğinde belirli UI ile ilgili API'lerin çalıştırılmasının çökmeye yol açması düzeltildi.**
2. Duygular anahtarı ve yeni Özellik anahtarı gibi bazı eski deneysel seçenekler kaldırıldı.

**🎉1.97.0-rc (2024/09/11)**

**✨ Yeni Özellikler**

**Temel Güncellemeler**

- Bu güncelleme ağırlıklı olarak performans optimizasyonlarına ve hata düzeltmelerine odaklanır.
- App genel performansı belirgin şekilde optimize edildi: Görev listelerini almak ve çeşitli işlemler artık daha akıcı. Hedef Android API sürümü Android 14'e güncellendi.

**Diğer**

1. Jeton yetersiz olduğunda Eşya satın alma düğmesi devre dışı görünür.
2. Başarım listesinde Başarımları ada göre arama desteği eklendi 🔍.
3. App içi yazı tipi boyutu ayarları desteklendi.
4. World → Rastgele Görevler rastgele mantığı optimize edildi: en yeni Görev grubunun görünme sıklığı azaltıldı, daha rastgele hale getirildi.
5. Bildirim gruplama mantığı optimize edildi: Özellik ve Başarım kilidi açma bildirimleri artık doğru gruplanmalı.
6. İstatistik → Paylaş QR kodu gösterimini açıp kapatmayı destekler.

**♻️ Optimizasyonlar**

1. Ağ erişim mantığı optimize edildi.
2. Açılır pencerelere arka plan bulanıklaştırma efekti eklendi.
3. Mağaza, depo ve vitrin sayfalarındaki düğmeler optimize edildi; resmi Material düğme stilleri kullanılıyor.
4. Görev geçmişi kayıtlarını sorgulayan Content Provider API artık Görevin bitiş zamanını döndürür.
5. Görev geçmişi kayıtlarını sorgulayan Content Provider API Görev Group Id'ye göre filtrelemeyi destekler.
6. Birçok bağımlılık sürümü güncellendi.
7. Goto API "Yeni Eşya Varsayılan Ayarları" sayfasına gezinmeyi destekler.
8. Goto API ile "Başarım Oluştur" sayfasına gidildiğinde `category_id` parametresi artık zorunludur.
9. API'de Görev, sayaç Görevi ve Eşya bağlantı efektleri için App içi rehberlik eklendi.
10. Yeni kullanıcıların güncelleme kontrolü mantığı ve hata mesajları optimize edildi.
11. Hesap silme işlemleri için yükleme ve hata mesajları eklendi.
12. Görev ayrıntı sayfasında ana Görevi tamamlama tıklama alanı optimize edildi.
13. Yedek içe aktarma hata mesajı iyileştirildi; geçersiz yedek dosyalarının içe aktarılması daha sıkı engellenir.

**🐛 Hata Düzeltmeleri**

1. **Yeni Görev oluşturulurken boş Görev içeriği hata mesajı önce tetiklendiyse, metin girildikten sonra hata mesajının otomatik kaybolmaması düzeltildi.**
2. **Alt gezinme modunda İstatistik sayfasında filtre düğmesinin görünmemesi düzeltildi.**
3. Dar en-boy oranına sahip belirli küçük ekran cihazlardaki düzen sorunları düzeltildi.
4. **Görev kopyalanırken alt Görev Ödüllerinin anormal bağlanması düzeltildi** (1.96.0 sürümünden beri).
5. Otomatik Dropbox yedeklemesi sırasında anormal Dropbox bağlantısından kaynaklanan hata mesajları düzeltildi.
6. Çok büyük görselleri önizlerken bellek tüketimi ve çökme sorunlarını gidermeye çalışıldı.
7. **Eşya satın alınıp kullanım için işaretlendikten sonra kullanım başarısız olursa widget verilerinin doğru yenilenmemesi düzeltildi.**
8. **Başarım düzenlemenin Başarım tamamlama zamanını değiştirmesi ve yanlışlıkla Başarım kilidi açma bildirimlerini tetiklemesi düzeltildi.**
9. **Büyük ekranlarda bölünmüş ekran modunda Görev listesi ve ayrıntı sayfası birlikte gösterilirken Görev, alt Görev veya sayaç güncellemelerinin iki sayfayı senkronize etmemesi düzeltildi.**
10. **Görev listesi sayfasında gecikmiş tek Görevlere uzun basmanın son tarih gösterimini temizlemeye izin vermemesi düzeltildi.**

**1.96.1(2024/07/11)**

**🐛 Hata Düzeltmeleri**

1. **Alt Görevler tamamlanırken gösterilen Ödül Eşyası sayısının hatalı olması düzeltildi** (gerçek Ödüller etkilenmedi).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Yeni Özellikler**

**Temel Güncellemeler**

1. Görev tamamlarken veya Başarım kilidi açarken Eşyalar doğrudan kullanılarak Eşya efektleri tetiklenebilir.
2. Aynı anda kullanılabilecek Eşya sayısı sınırı 1000'e yükseltildi.
3. Ganimet Kutusu veya Sentez Eşyası satın alma artık doğrudan kullanımı (açma/sentez) destekler.
4. Ekip Görevleri artık yerel Duygulara Duygu göndermeyi destekler.
5. Görev notlarındaki üçüncü taraf URL Scheme'leri doğrudan ayrıştırılıp açılabilir.
6. Geçmiş sayfası Görev notlarına göre geçmiş kayıtları aramayı destekler.
7. Geçmiş Görevler için zamanlama desteği eklendi.
8. İstatistik sayfası ana kategorilere göre filtrelemeyi destekler.
9. Özellik Deneyim Puanı Ödül ve ceza açılır pencereleri yeniden düzenlendi: Eşya kullanımında Özellik seçim sınırı mantığı optimize edildi; gecikmiş Deneyim Puanı düşürme açılır pencereleri ayrıldı.

**♻️ Optimizasyonlar**

1. Eşya seçerken tek seçim UI efekti çoklu seçimle tutarlı hale getirildi.
2. Görev listesi yükleme hızı optimize edildi.
3. Görev eklerken veya düzenlerken son tarih artık geçerli zamandan sonra olmak zorunda değil; geçmiş kayıtlar için esneklik sağlandı.
4. Veri ID'leri gösteriliyorsa Duygular açılır penceresi ilgili ID'yi de gösterir.
5. Gecikme işleme açılır penceresiyle ilgili performans sorunları optimize edildi.
6. Geri sayım zamanlaması ve duraklatma durumları için düğme sırası birleştirildi.
7. World Modülü → Kişisel Profil sayfasında gönderi silme etkileşimi daha sezgisel hale getirildi.
8. Duygular ve Başarımlar sayfalarının yükleme efektleri optimize edildi.

**🐛 Hata Düzeltmeleri**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Yeni Özellikler**

**Büyük Güncellemeler**

1. Tablet ve katlanabilir ekran gibi büyük ekranlı cihazlarda App içi bölünmüş ekran desteği

**♻️ Optimizasyonlar**

1. Mağaza ve depo widget'ları görseller için tutarlı App içi kırpma efektlerini destekler
2. İstatistik sayfasında yalnızca bir gün seçildiğinde çizgi grafikler desteklenir

**🐛 Hata Düzeltmeleri**

1. **API Görevleri düzenlenirken Görev türünün hatalı görünmesi düzeltildi**
2. **İstatistik sayfasında Görev tamamlama, bırakma ve gecikme istatistiklerinin anormal olması düzeltildi**

**1.94.3 (2024/05/10)**

**♻️ Optimizasyonlar**

1. Widget'lar sistem karanlık modu değiştiğinde temayı uyarlamaya çalışır
2. "World" modülü gizliyken sistem Başarımları kırmızı nokta bildirimi artık "World" modülüyle ilgili verileri saymaz

**🐛 Hata Düzeltmeleri**

1. Eşyaları çoklu seçerken düşük olasılıklı çökme sorunu düzeltildi
2. Açılır pencerelerle ilgili düşük olasılıklı çökme sorunu düzeltildi
3. **Eşya değiştirme API'si çağrıldığında depo widget'ının yenilenmemesi düzeltildi**
4. **Depo widget'ının "kullanılamaz" Eşyaları kullanabilmesi düzeltildi**

**1.94.2 (2024/04/26)**

**🐛 Hata Düzeltmeleri**

1. **Görev mevcut sayısının anormal hesaplanması düzeltildi** (hedef tekrar sayısı ayarlı Görevlerde ilerlemenin hatalı olmasına yol açıyordu)
   - Bu düzeltme, Görev geri alma performansıyla ilgili önceki bir optimizasyonu geri alır; daha uygun bir çözüm için bekleniyor

**1.94.1 (2024/04/22)**

**🐛 Hata Düzeltmeleri**

1. **Kronometre, API ile süre ekleme veya manuel süre kaydı kullanıldığında Pomodoro sayısının bir eksik hesaplanması düzeltildi.**
2. **Mağaza/Envanter sayfalarında Eşya seçip kaydırdıktan sonra seçim çubuğunun titreyip kaybolması düzeltildi.**

**🎉1.94.0 (2024/04/22)**

**Temel Güncellemeler**

1. Birden fazla Eşya Ödülü desteği
2. Envanter widget'ları

**UI Temaları**

1. Özel (Görev, Eşya metni) renkleri daha fazla ön ayar değeri içerir
2. Android 14'ün tek renkli uyarlanabilir simge özelliğine uyumlandı
3. Birçok dil uyarlaması eklendi (Google Play sürümü)

**Başarımlar**

1. Alınmamış Ödülleri olan Başarımlar varsa Başarım listesinde küçük kırmızı nokta gösterilir.

**Görevler**

1. Ceza Görevlerinin alt Görevleri artık ceza mantığını doğru uygular
2. "Akıllı Saat Dilimi Yönetimi" eklendi; saat dilimi değişikliklerini otomatik algılar ve genel zaman ayarlarını destekler
3. Ayrıntı sayfasındaki istatistik temeli son seçimi hatırlar; belirli senaryolarda bazı varsayılan değerler optimize edildi
4. "Benim" sayfasında ardışık Görev tamamlama günlerinin tolerans işleme optimize edildi: bir günü unutursanız telafi etmek seriyi sürdürebilir

**Özellikler**

1. Deneyim Puanı kayıtlarını silme desteği
2. Tek bir Özelliğin Deneyim Puanını sıfırlama desteği

**Widget'lar**

1. Mağaza veya Envanter widget'larında boş alana tıklamak artık son listeye değil, widget'ın işaret ettiği listeye girer
2. Görev widget'ları sayaç Görevlerinin ilerlemesini gösterir

**API**

1. Pomodoro kayıtlarını düzenleme API'si eklendi
2. Görev tamamlama API'si artık ceza Görevlerini doğru işler
3. Görev tamamlama API'si sayaç Görevlerini işlemeyi destekler (`count` parametresi eklendi)
4. Görev tamamlama API'si Ödül katsayısı parametresini destekler
5. Eşya ayarlama API'si Eşya listesi id'sini değiştirmeyi destekler
6. Eşya oluşturma ve ayarlama API'si sıralama ölçütü parametresini destekler
7. Jump API Eşya kullan açılır penceresine atlamayı destekler
8. Bazı parametre tanımları birleştirildi, örn. `itemId` → `item_id`
9. Kronometre başlatma, duraklatma ve bitirme için yayın bildirimleri eklendi
10. Eşya ayarlama API'sinin `title_color_string` parametresi varsayılan değeri geri yüklemek için boş dize geçirmeyi destekler
11. Görev tamamlama yayını artık liste id'sini içerir
12. Kutu açma ve üretim de Eşya kullan yayınını tetikler

**♻️ Optimizasyonlar**

1. Görev eklerken veya düzenlerken Özellik seçilmeden Deneyim Puanı girilirse uyarı gösterilir
2. Yükleme yeniden deneme kayıtları optimize edildi
3. Özel Seviye sayfasında başlık gösterimi ve giriş kısıtlamaları optimize edildi
4. Yoğun tekrarlanmış Görevleri geri alma performansı ve zamanlama sorunları optimize edildi
5. Eşya kullan açılır penceresi, takvim arayüzü mantığı vb. yeniden düzenlendi
6. Görev hatırlatıcı mantığı optimize edildi; silinmiş veya eski verilerden hatırlatıcılar tekrar gönderilmez
7. Yedekleme arayüzündeki bekleme metni optimize edildi
8. Özel Özellik sayfasında seçilen görseller geçmiş seçime de eklenir
9. Pomodoro kayıtları düzenlenirken doğru Pomodoro sayısını düzeltmeye çalışılır (artırma veya azaltma)

**🐛 Hata Düzeltmeleri**

1. Yeniden yapılandırmadan sonra istatistik ve yedeklemelerle ilgili sistem Başarımının normal tetiklenmemesi düzeltildi
2. Random API ve toast API widget'larının varsayılan toast ile olası çakışmaları düzeltildi
3. **Widget'tan girildiğinde bazı senaryolarda Görev ayrıntılarının yenilenmemesi düzeltildi**
4. Bazı özel durumlarda birden fazla kutu açmada hata olasılığı düzeltildi (Eşya Envanterinin önceden tüketilmesi)
5. **Alt Görevsiz Görev düzenlenip yeni alt Görevler eklendikten sonra ayrıntı sayfasında alt Görevlerin görünmemesi düzeltildi**
6. Jeton Ödüllerinin düzenlenemediği bazı özel durumlar düzeltildi
7. Ekip Eşyalarının alınamadığı bazı durumlar düzeltildi
8. Bazı alt açılır pencerelerde MD2 stil anomalileri düzeltildi
9. Pomodoro zamanlayıcılarında olası hatalı ek süre değerleri düzeltildi
10. **Deneyim Puanı değişim widget'ındaki renk çubuğunun görünmemesi düzeltildi**
11. Takvim devam edenlerde bazı Görevlerin düzgün görünmemesi düzeltildi
12. Geçmiş ve Duygular sayfalarında bazı liste yükleme sorunları düzeltildi
13. **Görev tamamlama API'sinin art arda hızlı iki kez çağrılmasının iki ardışık tamamlamaya izin vermemesi düzeltildi**

**1.93.3 (2024/01/09)**

**✨ Yeni Özellikler**

1. [Duygular] API'si eklendi.

**♻️ Optimizasyon**

1. İstatistik sayfasındaki ortalama değer göstergelerinin hesaplanması artık gelecek tarihleri hariç tutar.
2. Sistem Başarımları listesi gizlendikten sonra sistem Başarımı kilidi açma uyarıları artık gösterilmez.
3. `goto` API "satın alınamaz" Eşyalar için satın alma açılır pencerelerini artık desteklemez.
4. Görev düzenleme optimize edildi: hedef tekrar sayısı girişinin gizlenmesi sorunu çözüldü.

**🐛 Hata Düzeltmeleri**

1. Özel Özellik sayfasındaki edge-to-edge UI efekti düzeltildi.
2. **Geçmiş/takvim sayfasında bırakılmış bir Görev tamamlandığında cezanın iptal edilmemesi düzeltildi.**
3. Material2 modunda alt açılır pencere ve alt sistem gezinme çubuğunun görünüm stili sorunu düzeltildi.
4. Gece modunda yapılacaklar giriş kutusunun hatalı kenarlık rengi düzeltildi.
5. Üç düğmeli gezinme sistem modunda ekran döndürüldükten sonra oluşabilecek görüntüleme sorunu düzeltildi.

**1.93.3 (2023/12/02)**

**♻️ Optimizasyon**

1. Kolay hata ayıklama için API'lere birleşik debug parametresi eklendi

**🐛 Hata Düzeltmeleri**

1. **"Hatırlatıcı açılır penceresini yoksay" seçiminin etkisiz olması düzeltildi**
2. **Duygular sayfasında doğrudan oluşturulan Duyguların düzenlenememesi düzeltildi**
3. **Ekip dinamik fotoğrafları yüklerken 9 görsele kadar seçilebilmesi, oysa gerçek sınırın 3 olması düzeltildi**
4. **`use_item` API'sinin ui false olduğunda geri sayım veya URL efektlerini tetiklememesi düzeltildi**
5. **Mağaza widget'ında Eşya kullanımının efekti iki kez tetikleyebilmesi düzeltildi**

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Optimizasyon**

1. Veritabanı yükseltme gecikmelerini önlemek için veritabanı yükseltme mantığı optimize edildi
2. Görev düzenlerken "Başlangıç Zamanı" varsayılan değeri optimize edildi

**🐛 Hata Düzeltmeleri**

1. **Ürün API'lerini düzenlemenin ürün kullanım efektlerini kaybetmesine yol açması düzeltildi**
2. **Gecikmiş ve bırakılmış Görevlerin tamamlandı durumuna alındığında Ödüllerin geri yüklenmemesi düzeltildi**
3. Özel Görev sıralamasının beklentileri karşılamaması sorunu düzeltildi
4. Gecikmiş tek Görevlerle ilgili görüntüleme ve sıralama sorunları düzeltildi
5. Geçmiş sayfası filtrelenirken SQL istisnası sorunu düzeltildi
6. **Basitleştirilmiş modda Görev başlığına tekrar tıklamanın yanıt vermemesi düzeltildi**
7. **Görev şablonlarını yeniden adlandırmanın etkili olmaması düzeltildi**

**🎉1.93.0 (2023/10/24)**

**✨ Yeni Özellikler**

**UI Teması**

1. Material Design 3'e tam uyum.
2. Material Design 3 tema renklerini özelleştirme desteği; özel renkler, duvar kağıdı renkleri ve görsel renkleri dahil.
3. Açılır pencereler gibi bazı animasyon efektleri iyileştirildi.
4. Edge-to-edge (immersive) uyarlama efektleri optimize edildi.

**Görevler**

1. Görev şablonları desteği.
2. Ayrıntı sayfası istatistikleri zaman ölçütüne göre geçişi destekler; varsayılan seçenekler optimize edildi.
3. Geçmiş sayfası Görev adlarına göre aramayı destekler; ilgili UI ve etkileşimler ayarlandı.

**Başarımlar**

1. Gizli Başarımlar desteği.
2. Başarım eklerken "Sonraki Başarımı Eklemeye Devam Et" desteği.

**Özellikler**

1. Özellikleri gizleme desteği.

**Pomodoro Zamanlayıcı**

1. Süre kayıtlarını düzenleme desteği.
2. Pomodoro sayfasında Görev tamamlama (duraklatma modunda seçili Göreve uzun basma).

**Duygular**

1. Duygular sayfasında doğrudan Duygu ekleme desteği.

**API**

1. "use_item" API'si eklendi.
2. "random" API'si eklendi.
3. "edit_exp" API'si eklendi.
4. "item" API'si "action_text", "disable_use" ve "title_color_string" gibi parametreleri ayarlamayı destekler.
5. "shop_settings" API'si "silent" parametresini destekler.
6. "time" yer tutucusu desteği: otomasyon araçları olmadan "yarın son tarih" veya "gelecek ay son tarih" gibi tarihli Görevler ayarlanabilir.

**♻️ Optimizasyon**

1. Veri ID'lerinin gösterildiği bazı yerlere önek eklendi.
2. Ekip etkinliklerinin gösterimi optimize edildi.
3. Bazı Toast bildirimlerinin tam görüntülenemeyecek kadar uzun olması sorununa çözüm denendi.
4. Ekiplerde widget tamamlama mantığı iyileştirildi; App içi davranışla tutarlı.
5. İstatistik sayfası: "Özel" zaman aralığı seçildikten sonra "Özel"e tekrar tıklamak tarihleri yeniden seçtirir.
6. Harmony OS 4 ile ilerleme çubuğu bildirimlerinde eylem düğmelerinin görünmesi sağlandı.
7. Bildirim isteği etkileşim mantığı geliştirildi.
8. Giriş yönteminin "Tekrar Sayısı" girişini engellemesi sorunu giderildi.
9. Görev oluşturulurken belirsiz başlangıç zamanları (otomatik veya bugün son tarih gibi) kaydedilir; düzenlerken belirli zamanlar yerine seçenekler geri yüklenir.
10. Görev oluşturulurken beklenmedik yinelenen uyarıları "Yinelenenleri Kontrol Et" açılır penceresinde de gösterilir.
11. Endonezce dil desteği eklendi.
12. Çeviriler güncellendi.

**🐛 Hata Düzeltmeleri**

1. **Belirli durumlarda world modülünün süresiz yüklenmesi düzeltildi.**
2. **Belirli durumlarda Mağaza/depo sürekli "yükleniyor" göstermesi düzeltildi.**
3. Content provider üzerinden UI içerikli API çağrılarında oluşabilecek sorunlar düzeltildi.
4. Görev sıralamasının beklentileri karşılamaması sorunları düzeltildi.
5. **"Özel" zaman aralığı seçildikten sonra istatistik sayfası verilerinin hatalı olması düzeltildi.**
6. Bildirim isteği açılır pencerelerinin kaydırma desteklememesi düzeltildi.
7. **Belirli durumlarda world modülü aramasının tüm içeriği göstermesi düzeltildi.**
8. **"Tamamlananları Göster" seçeneğinin dondurulmuş Görevleri de göstermesi düzeltildi.**
9. İstatistik sayfasında ortalama değer hesaplama sorunları düzeltildi.

**1.92.2 (2023/08/29)**

**✨ Yeni Özellikler**

1. Adım istatistik grafiği (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Optimizasyon**

1. Yeni ekip sayfasına mevcut kelime sayısı ve üst sınır kelime sayısı hatırlatması eklendi

**🐛 Hata Düzeltmeleri**

1. **Belirli özel koşullarda "LifeUp"ın takvim hatırlatıcı hesaplarını tekrar tekrar oluşturabilmesi düzeltildi**
2. **Ekip düzenleme menü düğmesinin doğru görünmemesi düzeltildi**
3. **Otomatik başlangıç zamanlama modunda Pomodoro'nun titreşim hatırlatıcısını tetiklemeyebilmesi düzeltildi**
4. **Odak Eşyası seçilmediğinde Pomodoro bildiriminin yanlışlıkla odaklanılan Eşyaları gösterebilmesi düzeltildi**

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimizasyon**

1. Durum ve istatistik sayfalarındaki süre artık "XX gün XX saat XX dakika" biçiminde gösterilebilir.

**🐛 Hata Düzeltmeleri**

1. Android 12 ve sonrasında bildirim izni açılır penceresini kapatma etkileşiminin beklendiği gibi olmaması düzeltildi.
2. Özellik pasta grafiğinin şeffaf renkte görünüp görünmemesine yol açabilmesi düzeltildi.

**1.92.1-rc01 (2023/08/13)**

> Üyelik kapalı beta yayın tarihi

**✨ Yeni Özellikler**

1. Yeni istatistik sürümü eski sürümdeki istatistik kartlarını birleştirir; tek sayfada birleştirildi ve alt gezinme çubuğu moduna uyarlandı.

2. App içi güncelleme mekanizması ve hatırlatma işlevi yükseltildi.

   Artık üç güncelleme kanalı desteklenir: Kararlı Sürüm, Üyelik Kapalı Beta Kararlı Sürümü ve Üyelik Kapalı Beta Deneysel Sürümü; kapalı beta üyeleri için sonraki güncellemelere odaklanır.

3. TargetSdkVersion Android 13'e uyarlandı ve dinamik bildirim izni istekleri eklendi.

4. Profil düzenleme sayfası yeniden tasarlandı.

5. GP sürümünde giriş/çevrimdışı mod seçim süreci ve talimatları optimize edildi.

**♻️ Optimizasyon**

1. İlgili teknik bağımlılıkların bakımı ve güncellemeleri.
2. WSA uyumu ve giriş talimatları iyileştirildi.
3. Yedekleme başarısız olduğunda artık başarısızlık nedenini açıklayan bir açılır pencere gösterilir; toast mesajlarının eksik görünmesi sorunu önlenir.

**🐛 Hata Düzeltmeleri**

1. Jeton geçmiş kaydı sayfasında olası hesaplama taşması çökme sorunu düzeltildi.
2. Ekip ayrıntıları sayfasında menünün beklenen izinlerle uyumsuz olabilmesi düzeltildi.
3. Geri sayım zamanlayıcısındaki zaman sapması sorununu gidermeye çalışıldı.
4. Ekran döndürmenin Görev tamamlama sürecini kesmesi ve yansıma yazma açılır penceresinin kaybolması düzeltildi.

**1.92.0-rc02 (2023/07/16)**

**🐛 Düzeltme**

1. **Mağaza widget'ının diğer App'lere atlayınca (API yürütürken) çalışmaması düzeltildi**
2. **Mağaza widget'ında listeler arasında geçişte ara sıra oluşan anormallik düzeltildi**
3. **Mağaza widget'ının App ayarlarına göre tükenmiş veya satın alınamaz Eşyaları gizlememesi düzeltildi**
4. **Belirli bir Eşyaya tıklanınca mağaza widget'ının yanıt vermemesi düzeltildi**
5. Bazı nadir çökme sorunları düzeltildi

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Yeni Özellikler**

1. İstatistik 2.0
2. Paylaşım kartı

**♻️ Optimizasyon**

1. Artık "satın alınamaz" Eşyalar için fiyat ayarlanabilir; iade gibi senaryolarda kullanılabilir
2. Ayarlarda "Görev cezasını ayrı ayarla" kapatıldığında ceza düğmesi artık gösterilmez
3. Ekip ayrıntılarındaki alt Görevlerin UI'si optimize edildi
4. İzlenimlerin UI'si optimize edildi

**🐛 Düzeltme**

1. **Özellik kırpma stili "yuvarlatılmış dikdörtgen"e değiştirildiğinde düzenleme simgesinin uzun süre eski simgeyi gösterebilmesi düzeltildi**

**1.91.3-rc04 (2023/06/07)**

**♻️ Optimizasyon**

1. Görev ayrıntılarına atlama API'si artık task_gid ve task_name parametrelerini destekler
2. Content Provider ürünün uzak simge URL'sini destekler
   - Gelecekte bazı ürün simgelerinin masaüstünde doğru görüntülenememesi sorununu gidermek için

**🐛 Hata Düzeltmeleri**

1. **Mağaza listesi widget'ının mevcut jetonları doğru göstermemesi düzeltildi**

**1.91.3 (2023/06/03)**

**✨ Yeni Özellikler**

1. Mağaza Eşya listesi widget'ı (büyük ve küçük sürüm)
2. Deneyim Puanı günlük değişim widget'ı
3. Görev ayrıntılarına atlama API'si eklendi
4. Duygular: zamana göre artan sıralama desteği ve yıl gösterimi eklendi

**♻️ Optimizasyon**

1. "Satın alınamaz" Eşyalar için fiyat ayarlama ve iade gibi senaryolarda kullanma desteği
2. Ayarlarda "Görev cezasını bağımsız ayarla" kapatıldığında ceza düğmesi artık gösterilmez
3. Ekip ayrıntılarındaki alt Görevlerin görüntüleme UI'si optimize edildi
4. İzlenimlerin görüntüleme UI'si optimize edildi

**🐛 Hata Düzeltmeleri**

1. **Görev düzenlerken motivasyon sözleri temizlendiğinde "Onayla" ile açılır pencerenin kapatılamaması düzeltildi**
2. **Dondurulmuş Görevin API ile aranamaması düzeltildi**
3. **Mağaza ve deponun varsayılan listeyi gizleyememesi düzeltildi**

**1.91.2 (2023/05/09)**

**✨ Yeni Özellikler**

1. Mağaza ve Envanter listeleri gizlemeyi ayrı ayrı ayarlamayı destekler
2. `Goto` API ana sayfanın alt sayfalarına (Görevler, durum, Mağaza, Envanter gibi) atlamayı destekler
3. İstatistiklerdeki jeton istatistikleri artık satın alma tüketimini hariç tutmayı destekler

**♻️ Optimizasyonlar**

1. Yeni Başarım oluşturulurken veya kilitli Başarım düzenlenirken "Sıfırla" düğmesi artık gösterilmez
2. Jeton widget'ı Mağazaya atlamak için tıklamayı destekler
3. Ses efekti oynatılamadığında net bir hata mesajı gösterilir

**🐛 Hata Düzeltmeleri**

1. Domates kaydı eklerken bitiş zamanı doğrudan ayarlandığında beklenen sürenin karşılanmaması sorunu düzeltildi
2. Görev filtre etiketi onarıldıktan sonra giriş yöntemi sorununun açılması düzeltildi
3. **ATM faizinin API ile mutlak değer ayarlanmasını desteklememesi düzeltildi**
4. Geçmiş sayfasının anormal veri yükleme sorunu düzeltildi
5. **Widget sayaç Görevini tamamlarken "İptal"e tıklamanın şeffaf sayfada takılmasına yol açması düzeltildi**
6. **Alt gezinme çubuğu modunda istatistik sayfasının otomatik yenilenememesi düzeltildi**
7. **GMT +-x.5 saat diliminde ekip Görev toplamanın anormal olması düzeltildi**

**1.91.1 (2023/03/27)**

**✨ Yeni Özellikler**

1. Ayarlara "Bildirim Yönetimi" seçeneği eklendi.
2. Yeni Görev API'si arka plan ayarlamayı destekler.
3. Ürün geri sayımlarıyla ilgili API yayın olayları eklendi ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Optimizasyonlar**

1. Geri bildirim açılır penceresi dışarı tıklanınca artık otomatik kapanmaz.
2. Widget'lar başlamamış Görevleri zorla tamamlamaz.
3. Görev tamamlama API'si "ui" parametresi true olduğunda başlamamış Görevleri zorla tamamlamaz.
4. Bireysel Görev ceza katsayıları ayarı kapatıldığında önceden ayarlanmış ceza katsayıları yok sayılır ve genel değer kullanılır.
5. Kullanıcıların girdiği URL'lerden boşluklar otomatik kaldırılır.
6. "Satın Alınamaz Eşyaları Gizle" etkin ve satın alınamaz Eşya oluşturulduğunda bir istem gösterilir.
7. Kullanıcı özel Seviyeleri etkinleştirip tanımlamazsa yerleşik Seviye tablosuna sıfırlanır.
8. Widget önizleme görselleri iyileştirildi.
9. Adım girişleri artık yalnızca sayılara kısıtlanır. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Ürün bağlantıları için yerleşik tarayıcı kullanılırken "https" öneki artık gerekmez.
11. Ürün geri sayım özelliği için "Uyumluluk Yapılandırması" talimatları eklendi.

**🐛 Hata Düzeltmeleri**

1. Mağaza ve depoda ürün seçerken beklenmedik tıklama işleme davranışı düzeltildi.
2. **API ile eklenirken tekrarlanmayan Görevlere son tarih ayarlanamaması düzeltildi.**
3. **Belirli cihazlarda özel Özellik görsellerinin güncellenmemesi düzeltildi.**
4. **Özel ses efektlerinin App'in çökmesine yol açabilmesi düzeltildi.** Yeni bir yöntem uygulandı; arka plan ses efektleri daha kararlı ve daha az bellek kullanmalı, ancak oynatma hızı daha yavaş olabilir.
5. **"Pil Optimizasyonunu Yoksay" yapılandırması olmayan Android 12 ve üzeri cihazlarda otomatik Pomodoro zamanlayıcısı veya mola süresini etkinleştirmenin arka planda çökmeye yol açabilmesi düzeltildi.**
6. **Ürün geri sayım ses efektlerinin Pomodoro ses efektleri ayarından etkilenmesi düzeltildi.**
7. **API'de ATM günlük faiz oranları ayarlanırken kayan nokta hesaplama hataları düzeltildi.**
8. **Android 6'da bazı görsellerin yüklenememesi düzeltildi.**
9. **Daha yüksek sürümden daha düşük sürüme yedeklenmiş App verisi geri yüklenirken hata istemlerinin doğru gösterilmemesi düzeltildi.**
10. **Bazı cihazlarda Pomodoro sayfasında düzen örtüşmesi düzeltildi.**

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Yeni Özellikler**

1. Özel Seviye gradyanları desteği.
2. İlk widget grubu eklendi:
   - Jetonlar (küçük, büyük, hedef)
   - Özellikler (küçük, büyük)
3. LifeUp'taki verilerin çoğunu Content Provider API ile sorgulama desteği, şunlar dahil:
   - "LifeUp Cloud"un yeni sürümü sunulur.
   - Yerel ağ kullanımı için masaüstü sürümünün (Windows, Linux, macOS) ilk basit sürümü sağlanır.
4. Domates zamanlayıcı kayıtlarının çoklu seçimle silinmesi desteği.
5. Domates saati için dinlenme ve çalışmanın otomatik başlatılması ayarlanabilir.
6. API iyileştirmeleri ve ek alanlar, şunlar dahil:
   - ATM yatırma ve çekme.
   - Ürünler için satın almayı yasaklama ayarı.
   - Görevler için etiket renkleri ayarı.
   - ATM bakiyesini doğrudan ayarlama.
   - Belirtilen ürün ayrıntıları için basit sorgu.
   - Açılır arayüze üçüncü düğme ve işlem seçeneği ekleme.

**♻️ Optimizasyonlar**

1. Büyük veri miktarlarıyla çalışırken sorgu, işleme hızı ve performans iyileştirildi.
2. Uyarlanabilir simgeler için hatalı kenar boşlukları düzeltildi.
3. Domates zamanlayıcı kayıtlarının gösterim efekti optimize edildi.
4. Yedek geri yükleme etkileşimi iyileştirildi.
5. Google Play üzerinden üyelik lisansı alma için UI gösterimi eklendi.
6. Dosya sisteminden doğrudan içe aktarırken seçilen yedek dosyası LifeUp'tan değilse tek tıkla içe aktarma özelliğini devre dışı bırakma istemi gösterilir.
7. Ürün seçim açılır penceresinde arama yapılırken giriş yöntemi otomatik kapatılır.
8. API davranış değişiklikleri, şunlar dahil:
   - Confirm_dialog açılır API'si. Belirli düğme metni veya işlem sağlanmazsa düğme gösterilmez. Örneğin metin ve motivasyon dili göstermek için düğmesiz yalnızca metin açılır penceresi ayarlanabilir.
   - Ceza API'si. Önceki sürümlerde en fazla 100 Eşya düşürülebilirdi; sınır 9 haneye çıkarıldı.

**🐛 Hata Düzeltmeleri**

1. **Belirli durumlarda domates zamanlayıcı sayfasının sonunda "yükleniyor" göstermesi düzeltildi.**
2. Belirli üçüncü taraf kütüphanelerden kaynaklanan çökmeler düzeltildi.
3. **Domates saatinin alt gezinme çubuğuna konması nedeniyle istem açılır penceresinin App'i çökertmesi düzeltildi.**
4. **Diğer kullanıcıların profillerine göz atarken Özellik değerlerinin anormal görünmesi düzeltildi.**
5. **Özellik Seviye düşürme API olayları ve bildirimlerinin doğru gönderilmemesi düzeltildi.**
6. Uzun basma düzenleme sayfalarındaki bazı etkileşim sorunları düzeltildi.
7. Görsel yönetimi ve Sentez sayfalarındaki bazı anormal kenar boşlukları düzeltildi.
8. **Kaydırılamayan bazı açılır pencerelerin yatay modda anormal kullanıma yol açması düzeltildi.**

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Content Provider bilgileri için okuma ve yetkilendirme işlemleri desteklenir.
2. Hizmet başlatılırken ekran kilitliyken bile yanıt verebilmek için wake lock istenir.
3. Content Provider'lar için bir dizi arayüz eklendi.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

İlk sürüm; "LifeUp Cloud" ve mobil App ile birlikte kullanılmak üzere tasarlandı.

Şu işlemleri destekler:

- Görevler, listeler, Eşyalar, Başarımlar ve Duygular listelerini sorgulama.
- Eşya satın alma, Görev tamamlama.
- Masaüstü görsel tarayıcısıyla Duygular görsellerini büyütülmüş görüntüleme.

**1.90.7 (2022/11/07)**

**✨ Yeni Özellikler**

1. Eklendi: Vietnamca çeviri ve çevirmen imzası (Google sürümü)
2. Eklendi: GIF animasyonları seçmek için uygun "Kırpmayı atla" görsel seçim yöntemi (üye işlevi)
3. Eklendi: Görev silme API'si
4. Eklendi: Görev tamamlama ses efektini devre dışı bırakma ayarı
5. Eklendi: Basit Sentez MAX miktar işlemi
6. Kilidi açılmış Başarımları yeniden kilitleme desteği
7. "Ürün ekleme API'si" liste kimliği belirtmeyi destekler

**♻️ Optimizasyon**

1. Geçmiş silme açıklaması iyileştirildi
2. Deneyim Puanı sınırı (3/4 basamak) → (4/5 basamak) olarak değiştirildi
3. Ayrıntılar sayfasına ceza katsayısı gösterimi eklendi
4. Tarih-saat seçim kutusunun etkileşim tasarımı genel olarak iyileştirildi
5. Başarım ayrıntıları açılır penceresi, koşullar tamamlanmış mı değil mi diye simge rengini ayırır
6. Domates kısayol simgesi değiştirildi
7. Akıllı listeden Görev oluşturulurken seçilebilir liste 0 veya 1 ise otomatik seçilir
8. Geliştirici modu Eşya listesi kimliğini gösterir
9. Çökmeleri önlemek için bazı yaygın alanların giriş uzunluğu sınırlandı

**🐛 Hata Düzeltmeleri**

1. Eşya geçmiş kaydı değiştirildiğinde Ödül hesaplamasının bazı senaryolarda anormal olması düzeltildi
2. "Arşivlenenleri göster" anahtarının bazı senaryolarda görüntüyle uyuşmaması düzeltildi
3. Widget veri yükleme mantığı iyileştirildi (bazı anomaliler giderilebilir)
4. Zaman kaydı manuel eklerken otomatik hesaplama mantığı onarıldı; artık herhangi bir alanı doldurmak yeterli
5. Domates zaman kaydı sayfasının anormal yenilenmesi düzeltildi
6. Alt Görevlerin Eşya Ödüllerini temizleyememesi düzeltildi
7. Tüm Eşyalar seçildikten sonra bazılarını yeniden seçmenin etkisiz kalması düzeltildi
8. Önizleme görselleri için gereken bellek optimize edildi
9. Liste sırası ayarlandıktan sonra widget yenilemesi tetiklenir
10. Bazı yedekleme yöntemlerinin arayüzde takılması optimize edildi

**1.90.6 (2022/10/21)**

**✨ Yeni Özellikler**

1. Belirli bir tarihte adım sayısını ayarlama API'si eklendi
2. Belirtilen Özelliklerin durumunu (Deneyim Puanı, Seviye) sorgulama API'si eklendi
3. Dosya yöneticisinden yedek verilerini doğrudan içe aktarma desteği
4. Ödül Eşyalarıyla ilgili API'ler artık 99 ile sınırlı değil

**♻️ Optimizasyon**

1. Etkinlik ayrıntıları sayfasına geçiş animasyon efekti optimize edildi
2. Görev düzenleme sayfası optimize edildi; ceza etkinleştirme UI efekti artırıldı ve rehberlik iyileştirildi
3. Zamanlama sayfasındaki işlem simgeleri değiştirildi
4. Satın alma açılır penceresinde negatif sahip sayısına sahip Eşyalar için uyarı ve açıklamalar eklendi
5. Ana sayfa sürükleyici durum çubuğu efekti optimize edildi
6. Pomodoro sayfasına uyumluluk yapılandırması hatırlatması eklendi
7. Yedek dışa aktarma ve geri yükleme hızı iyileştirildi
8. Stok sayısı ayarı için açıklamalar
9. [Ürün stoğu 0 olduğunda ilgili Görev Ödülü otomatik kaldırılır] ayarı geçici olarak kaldırıldı
10. Ücretsiz deneme sürümüyle lisans kontrol mekanizması optimize edildi
11. "Sabitle" Görevi seçildiğinde işlem artık "Sabitlemeyi kaldır" olarak gösterilir
12. Pozitif zamanlamaya geçerken *deneysel* uyarı artık her seferinde açılmaz

**🐛 Hata Düzeltmeleri**

1. Bazı sayfaların veya tabletlerde anormal sistem sınırları düzeltildi
2. Envantere ilk girişte bazı durumlarda yanlış veri gösterilmesi düzeltildi
3. Hasarlı yedek dosyaları geri yüklenirken iç hasar (ör. görsel hasarı) nedeniyle verilerin hiç kurtarılamaması düzeltildi
4. Tükenen Eşyaya uzun basıldıktan sonra "Satın al" düğmesinin beklenmedik şekilde görünmesi düzeltildi
5. Yeni ekip sayfasındaki Özellik tanıtımının eski sürüm olması düzeltildi

**1.90.5 (2022/09/22)**

**♻️ Optimizasyon**

1. Anormal webp dönüşümü olan bazı cihazlara uyum (bu cihazlarda kırpılmış görsel orijinalden büyük olabilir). Görsel seçildikten sonra boyut belirlenir ve ikincil sıkıştırma yapılır.
2. Ayrıntılar sayfasında hedef tekrar açıklaması iyileştirildi
3. Geri sayım sırasında aynı ürünün süre biriktirmesi desteklenir
4. Daha fazla acemi rehber Görevi eklendi
5. Çeviriler güncellendi

**🐛 Hata Düzeltmeleri**

1. Sentez sayfasının anormal UI sorunu düzeltildi
2. Bilinen birkaç çökme sorunu düzeltildi
3. Uzun süreli geri sayımda Eşya geri sayımının anormal kesilip süre biriktirmesi sorunu iyileştirildi
4. Widget Görevi tamamlarken Duygu giriş açılır penceresinin UI istisnası düzeltildi

**1.90.4 (2022/09/15)**

1. Widget Görevi tamamlarken anormal sorun düzeltildi (şeffaf sayfa görünebilir ve işlem sürdürülemez)
2. Widget'ın izlenimlerden görsel seçme yeteneği devre dışı bırakıldı

**1.90.3 (2022/09/14)**

1. Alt Görevleri sıralarken odak sorunu düzeltildi
2. Dondurulmuş/başlamamış Görevlerde Özellik renkleri iyileştirildi
3. Vazgeçilen Görevler olay yayını eklendi
4. Olasılık metin rengi düzeltildi
5. Başlangıç Görevleri (önceden ayarlı Görevler) iyileştirildi
6. Eşya içe aktarma iletişim kutusunun varsayılan olarak "Tümü" listesini seçmesi düzeltildi
7. Mağaza Eşya grubu sorunları düzeltildi
8. Olağandışı saat ayarlanırken uyarı verilir (saat tekrar sıklığıyla uyuşmuyor).
9. Takvimde Görev hesaplama kuralları iyileştirildi; gelecek Görevlerin son tarihleri artık doğru tahmin edilmeli.
10. Dondurulmuş Görevler için takvim tamamlanmasının hesaplanması düzeltildi.
11. Görev düzenlerken varsayılan başlangıç saati ayarları iyileştirildi.
12. Lisans algılama mekanizması iyileştirildi.
13. Eşya geri sayımı işleme optimize edildi. Beklenmeyen süre birikimini azaltmak için tekrarlı yürütme yasaklandı.
14. Bazı sayfalarda sanal tuşlarla edge-to-edge sorunu düzeltildi.
15. Masaüstü widget'ı Görevi tamamlarken Duygu görseli seçilememesi düzeltildi.

**1.90.2 (2022/08/31)**

**✨ Yeni Özellikler**

1. Yayın olayları eklendi.
   Artık Tasker/MacroDroid ile Eşya kullanma, Görev tamamlama vb. olayları alıp Tasker eylemlerini tetikleyebilirsiniz.

   Örneğin: Eşya kullanıldığında rastgele duvar kağıdı değiştirme tetiklenir.
   Teoride uygulama kilidi ve oyun etkileşim senaryoları gibi işlevler uygulanabilir.

2. Yeni API'ler:

- Görevlerden vazgeçme
- Görevleri dondurma
- Görevlerin dondurmasını kaldırma
- Boş arayüz
- Sorgulama

3. Yeni Eşya ve Görev ekleme API'si için dönüş değeri eklendi
4. Pazardan Eşya içe aktarırken artık hedef liste seçilebilir
5. Material 3 ikincil rengine uyum
6. Dil çevirileri güncellendi; Korece desteği eklendi

**♻️ İyileştirmeler**

1. Toplu Ganimet Kutusu açılışında tek ürünün olasılığı da gösterilir
2. Gece modunda bazı UI görüntü efektleri optimize edildi
3. Tarih-saat seçim açılır penceresinin etkileşim mantığı optimize edildi. Güncel gün seçildiğinde otomatik olarak saat seçim sayfasına geçilir.
4. API Eşya ve liste seçimi çağırdığında açılır pencere doğrudan kapatılamaz (API çağrılarının kaybolmasını önler)
5. Tablet yatay ekranda alttaki bazı açılır pencerelerin varsayılan yüksekliği optimize edildi
6. Açılır pencerenin otomatik kapanma zamanlaması optimize edildi

**🐛 Hata Düzeltmeleri**

1. API Görev aramasının bazı durumlarda başarısız olması düzeltildi
2. Görev listesi sayfasındaki ara sıra çökme düzeltildi
3. Kilidi açılmamış normal Başarımlara uzun basıldığında "Geri al" işlem düğmesinin görünmesi düzeltildi
4. Başarım ayrıntıları açılır penceresinin eksik görüntülenmesi düzeltildi
5. Anormal büyük görsel nedeniyle yükleme penceresinde başarısızlık düzeltildi
6. Eşya API'sinde own_number ve stock_number negatif sayıları desteklemiyordu — düzeltildi
7. "Ben" sayfasında süreklilik gün sayısının bazen anormal 1 görünmesi düzeltildi
8. Bazen "-x gün önce" görüntülenmesi düzeltildi
9. API'ler toplu çağrıldığında sonraki API'lerin anormal iptal edilmesi düzeltildi
10. Yeni ekip doldurulan içeriğin sayfa yok edildiğinde kaybolması düzeltildi

**1.90.1 (2022/08/22)**

**🐛 Hata Düzeltmeleri**

1. API çağrı eşzamanlılık sorunu düzeltildi
2. Çok sayıda ürün (binlerce) seçildiğinde çoklu seçimin donması düzeltildi
3. Widget ekip Görevini tamamlarken anormal sorun düzeltildi
4. Alt Görev Deneyim Puanı düzenlemesinin geri doldurulmaması düzeltildi

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Yeni Özellikler**

1. Görev Ödül ayarları optimizasyonu:
   - Ödül ayarları UI düzenlemesi
   - Alt Görev Deneyim Puanı ve Eşya Ödülleri ayarlamayı destekler
   - Orijinal "yalnızca metin" Ödülü bağımsız "sözler" Ödülüne dönüştürüldü
   - Varsayılan Deneyim Puanı değeri ayarlama desteği

2. Eşyalar Özellik Seviye satın alma kısıtlaması ayarlamayı destekler.

3. Eşya "URL" efektini destekler.
   Yalnızca web sayfalarına değil, diğer uygulamalara veya LifeUp API'sine de çağrı yapılabilir. Eşya kullanıldıktan sonra fiyat artırma gibi etkiler sağlanır.

4. **Açık API'ler.**
   Artık otomasyon yazılımlarıyla eşleştirebilir veya ikincil geliştirme yapabilirsiniz.

   [Daha fazla ayrıntı için API belgelerine bakın.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. Mağaza rafine edilmemiş sayma efektini görüntülemeyi destekler

6. Bildirim optimizasyonu:

   - Özellik Seviye değişikliği bildirimi eklendi
   - Kilidi açılmış Başarım bildirimi eklendi
   - Bildirim grubu optimizasyonu

7. Zaman kayıtlarını manuel ekleme desteği.

8. Pomodoro sayfasını alt gezinme çubuğuna yerleştirme desteği

9. [Sistem Başarımı] listesini gizleme desteği

10. Hedef API sürümü Android 12L'ye uyarlandı

11. Sürükleyici efekt optimizasyonu

12. App Widget'ları Görev tamamlama açılır penceresini göstermeyi destekler

13. Artık konu ayrıntıları sayfasında Görev tamamlanabilir

14. Gecikmiş açılır pencerede sayaç Görevlerinin sayısı ayarlanabilir

15. Ekip Görevi adı artık düzenlenebilir

16. Dünya modülü ağ isteği zamanlaması optimize edildi; trafik tüketimi ve sunucu yükü azaltıldı

**♻️ İyileştirmeler**

1. Gece modu artık tüm tema renklerini destekler; her tema rengi için ayrı gece rengi özelleştirmesi, Material 3'e uyarlandı
1. Uyumluluk yapılandırması iletişim kutusuna "pil optimizasyonu" bağlantısı eklendi
1. Pomodoro Ayarlarına "Ekranı açık tut" anahtarı eklendi
1. Duraklatılmış Eşya geri sayımı için "Bitir" ve "Topla" seçenekleri sunuldu
1. Düzenleme hedefi mevcut sayıdan büyük olduğunda hata istemi gösterilir
1. Negatif konular ceza katsayısı ayarlarında gösterilmez
1. Geçmiş sayfasındaki yenileme efekti optimize edildi
1. Alt Görev tamamlandıktan sonra ana Görevi otomatik tetikleme mantığı optimize edildi; doğrudan ayrıntılar sayfasında işlenir
1.

**🐛 Hata Düzeltmeleri**

1. Anlar sayfasında + düğmesinin bazen görünmesi düzeltildi
2. Negatif Görevlerin Duygular iletişim kutusunu açmaması düzeltildi
3. Negatif Görevlerin hedefinin etkisiz kalması düzeltildi
4. Ekip Görevleri için "... tarihine kadar dondur" ayarının etkisi onarılmaya çalışıldı
5. Duygu sayfasındaki görselin yanlış görüntülenmesi düzeltildi

**1.89.5 (2022/8/5)**

1. Ağ bağlantı sorunu optimize edildi
2. Çeviri güncellendi

**1.89.4 (2022/7/13)**

1. Xiaohong Dot Soruları hakkındaki bilgi düzeltildi
2. Tekrarlayan Görevin tekrar tekrar oluşturulması sorunu düzeltildi (bu sefer gerçekten onarıldı .jpg)

**1.89.3 (2022/7/05)**

**♻️ İyileştirmeler**

1. Kaydırmalı anahtar listesinin değerlendirilmesi optimize edildi

**🐛 Hata Düzeltmeleri**

1. Çok sayıda Başarım koşulu varken hesaplamanın tamamlanmaması düzeltildi
2. Belirsiz Görev bildirim hatırlatıcısının anormal son tarih göstermesi düzeltildi
3. Eşya kopyalandıktan sonra arka plan düzenlemesinin kopyalanan Eşyayı etkilemesi düzeltildi
4. Ekip Görevlerini düzenlerken Yetenek devralınmaması düzeltildi

**1.89.2 (2022/6/23)**

**♻️ İyileştirmeler**

1. Gereksiz CAMERA izni kaldırıldı
2. Çeviriler güncellendi

**🐛 Hata Düzeltmeleri**

1. Bazı çökmeler düzeltildi

**1.89.0-1.89.1 (2022/6/09)**

**✨ Yeni Özellikler**

1. Çoklu kilitleme koşullu Başarımlar desteği
2. Başarım ayrıntıları koşul ayrıntılarını ve ilerlemeyi görüntülemeyi destekler
3. Görev etiketi
4. Son tarihsiz tekrarlayan Görevler
5. Tükenen veya satın alması devre dışı Eşyaları gizleme
6. Eşya için Deneyim Puanı azaltma efekti ayarlanırken kullanımı sınırlama isteğe bağlı
7. Envanter sayfası çoklu seçim, tümünü seç ve toplu iade destekler
8. Varsayılan Görev listesi arşivleme işlemini destekler
9. Ayarlar, S&C, Mağaza araç çubuğu ve liste ekleme sayfası gibi bazı sayfalar yeniden tasarlandı
10. Bazı uygulama içi simgeler yeniden tasarlandı (varsayılan Görev kart simgeleri, jetonlar, Deneyim Puanı, Başarım simgeleri)
11. Görsel depolama yanlışlıkla silinmeyi önlemek için harici uygulama özel yoluna taşındı

**♻️ İyileştirmeler**

1. Ayarlar sayfasına [Uyumluluk Yapılandırması] makale bağlantısı eklendi
2. Pomodoro geri sayımı — sıfırlama işlemine onay iletişim kutusu eklendi
3. Görev dondurma açıklaması eklendi
4. Başarım alt kategorileri açıklaması eklendi
5. Çevrimdışı modda profil düzenleme sayfasına çevrimdışı moddan çıkış düğmesi eklendi
6. Negatif Görev istatistikleri optimize edildi; günün vazgeçilme sayısı gösterimi ve Başarım takibi desteklenir
7. Uygulama başlatma hızı optimize edildi
8. Başarım simgesi büyük görsel görüntülemeyi destekler
9. Rastgele Görevler için beğeni (alınan) istatistikleri eklendi
10. Arama etkileşimi birleşik olarak optimize edildi
11. Eşya seçerken boş listeye geçildiğinde yükleme yerine boş düzen gösterilir
12. Büyük görsel sayfası mevcut tema rengi ayarlarına uyarlanır
13. Seçilen Eşya ve Görev açılır penceresinin yüksekliği değişirken animasyon efekti optimize edildi
14. Yedekleme ayarlarında "Yerel verileri sil" medya dosyalarını da siler
15. Fotoğraf çekme geçici dosyalarının depolama ve silme mantığı birleştirildi
16. Varsayılan Eşya simgesi ile yüklenemeyen simge ayrımı
17. Görevler için bağımsız ceza ayarı artık varsayılan olarak etkin
18. Duygular sayfasının yenileme, animasyon mantığı ve yükleme hızı optimize edildi
19. Bazı ayrıntı açılır pencerelerine kısayol "seç" düğmesi eklendi
20. Gelişmiş ayarlar sayfasındaki "ses efektleri" ve "titreşim" ana anahtarları kapatıldığında domates ayarlarında da karşılık gelen açıklamalar verilir
21. Yeni Başarımlar ve alt kategori sıralama optimizasyonu
22. Temel kütüphane ve bağımlılık yükseltmesi
23. Başarım ilerlemesi hesaplama yöntemi ve hızı optimize edildi
24. "Hedef (tekrar) sayısı" hesaplama yöntemi geçmiş kayıtları istatistik iyileştirmesini takip eder; ayrıntılardaki sayıyla tutarlı
25. Jeton sayısı ve hedef tekrar sayısı girilirken tüm mevcut değerler otomatik seçilir
26. WebDAV yapılandırması anormal olduğunda hata istemi optimize edildi
27. Google Drive yedeklemesi anormal olduğunda hata istemi optimize edildi
28. Ayrıntılar sayfasında Görev adı seçilebilir

**🐛 Hata Düzeltmeleri**

1. Görev tekrar mantığı çalıştıktan sonra ayarlanan sayının Görev Ödülünü geçersiz kılması düzeltildi
2. Mağaza sayfası sıralama ve gruplama sorunu düzeltildi
3. Rastgele Görevlerde bazı durumlarda sayfa yukarı-aşağı anormalliği düzeltildi
4. Pozitif zamanlama kullanıldıktan sonra durum sayfasındaki pomodoro istatistiğinin yanlış olması düzeltildi
5. Ekip Görevlerinin tekrar mantığının sayaç Görev türü ayarını kaybetmesi düzeltildi
6. Başarım koşullarıyla ilgili Görevler seçilirken Domates tarafından seçilen Görevin vurgulanması düzeltildi
7. Duygu görselinin bağımsız depolanmaması ve görüntü sorunları düzeltildi
8. Giriş başarısız olduğunda hata isteminin sık açılması düzeltildi
9. Yeni Görevler, ekipler ve alt Görevler için bazı özel giriş kutuları klavye girişine izin vermemeli (çökme riski) — düzeltildi
10. App widget'larında sınırsız Eşya tamamlanma sayısı sayma yöntemi optimize edildi; uygulama içiyle tutarlı
11. ATM faiz oranını ayarladıktan sonra birikmiş süre ve ayarlanmış faiz oranına göre faiz hesaplanması düzeltildi
12. Dondurulmuş Görevlerin akıllı listede görüntülenmesi düzeltildi
13. Belirli nesneler (Görevler, Mağaza Eşyaları) seçildiğinde seçim çubuğu tarafından engellenen eylem düğmesinin hâlâ tıklanabilir olması optimize edildi
14. Eşya rengi değiştirildiğinde UI'nin hemen yenilenmemesi düzeltildi
15. Düşük faiz oranından sonra aniden yüksek faiz ayarlandığında (1 jeton alınamadı) büyük faiz alınması düzeltildi
16. Arama çubuğu açıkken ürün kullanıldıktan sonra Görev tamamlandığında arama kutusunun açılması düzeltildi
17. Sınırsız Görev adı değiştirildikten sonra uygulama içi günlük tamamlanma sayısının widget ile uyuşmaması düzeltildi
18. Sınırsız Görevler tamamlanırken garip animasyonlar düzeltildi
19. Görev kopyalandığında arka planın kopyalanmaması düzeltildi
20. Başarım koşulları tamamlandığı hâlde Başarımın kilidi açılamaması düzeltildi
21. Tarih aralığı hesaplama istisnası (birden fazla mantığı etkileyebilir) düzeltildi
22. Görev ayrıntıları sayfasından Duyguların otomatik filtrelenmemesi düzeltildi

**1.88.4 (2022/4/21)**

1. Depo aramasının çökmeye yol açması düzeltildi
2. Özel arka plan ve geçmiş sayfası görüntü bozukluğu düzeltildi
3. Düzenlerken UI üst üste binme sorunu düzeltildi
4. Başarım Eşya ile Ödüllendirildiğinde miktarın anormal görüntülenmesi düzeltildi
5. Başarım hesaplama Eşyalarının tamamlanma sayılarının bazı özel durumlarda gerçek sayılarla uyuşmaması düzeltildi
6. Geçmiş sayfasına hızlı tıklandığında başlığın kaybolması düzeltildi
7. Görev oluştururken veya düzenlerken özelliğe tıklandıktan sonra odaktaki giriş kutusuna tekrar tıklanınca yumuşak klavyenin açılamaması düzeltildi
8. Fransızca dilinde aylık satın alma limiti ayarlanırken çökme düzeltildi

**1.88.3 (2022/4/09)**

1. Yedek geri yüklendikten sonra bulut yedeklemenin çakışma uyarısı vermesi düzeltildi
2. Düzenlenen Görev başlangıç saati ve alt Görev hatırlatma saatinin varsayılan olarak doldurulan saati seçmemesi düzeltildi
3. Toplu basit Sentez sırasında diğer efektlerin yalnızca bir kez hesaplanması düzeltildi
4. Sistem Başarımının herhangi bir Özelliğinin 10. Seviyeye ulaşmasının özel Özelliğe sayılmaması düzeltildi
5. Üye olmayanlar için "Ben" sayfasındaki metin UI'sinin anormal görüntülenmesi düzeltildi

**1.88.2(-)**

> 1.88.3'te yer alan güncellemeler

**1.88.1 (2022/4/02)**

1. Yedekleme hatırlatıcısının neden olduğu çökme düzeltildi

**1.88.0 (2022/3/30)**

✨ Yeni Özellikler

1. Dünya modülünde "rastgele Görevler" paylaşma işlevi eklendi
2. Sayma Eşyaları isteğe bağlı olarak Eşya sayısını etkileyen katsayı ayarlayabilir
3. Kredi faiz oranı ayarlama desteği
4. Görsel yönetimi kullanılmayan görselleri tek tıkla filtreleme + tümünü seçme işlemlerini destekler
5. Özel görsel kırpma boyutu desteği (daha yüksek çözünürlüklü simgeler, üyelik işlevleri)
6. Başarım içinde "Duygular" anahtarı açıkça gösterilir
7. "Tümü" listesinin sıralama algoritması optimize edildi

⚡️ Optimize edildi

1. Bazı açılır pencerelerin görsel efektleri optimize edildi
2. Yedekleme/geri yükleme işlevlerinin etkileşimi optimize edildi
3. Delegasyon sayfasının yükleme hızı optimize edildi
4. Ürün seçim açılır penceresinin yükleme hızı büyük ölçüde optimize edildi

🐛 Hata Düzeltmeleri

1. Özel arka plan bozukluğu düzeltildi
2. Görevin silinmiş listeye oluşturulabilmesi düzeltildi
3. Bazı çökme hataları düzeltildi

**1.87.1（2022/3/07）**

1. Mağaza ve Envanter sıralama menüsü "özel" sıralamayı açıkça gösterir
2. Envanterde anormal sıralama oluşması düzeltildi
3. Geri bildirim sayfasına e-posta geri bildirimine atlama düğmesi eklendi
4. Veritabanı sürüm sorunlarından kaynaklanan geri yükleme hatası istemi optimize edildi
5. Kompakt mod kartında jeton sayısının gösterilmemesi düzeltildi

**1.87.0 official version (2022/3/04)**

1. Özel kart arka planının bazı durumlarda anormal yakınlaştırılması düzeltildi
2. Görev hatırlatma bildirimine sürekli tıklandığında yanlış Görev ayrıntılarına atlama düzeltildi
3. Sayaç Görev sayısını artırmak için kaydırıldığında karttaki sayıların normal yenilenmemesi düzeltildi
4. Bazı diller için yeni rehber Görevi eklendi

**1.87.0-rc02（2022/2/25）**

1. Kurtarma işlemleri için hata işleme ve istemler iyileştirildi
2. "Haftanın günü" ayarlama etkileşimi optimize edildi; anormal ayar uyarısı artırıldı (başlangıç-dönem aynı günde değil)
3. Bazı sayfaların gece modu renk eşleşmesi optimize edildi
4. Görsel seçim kutusu ve görsel yönetiminde önbelleğin yanlış görüntülenmesi düzeltildi
5. Yedek çakışması açılır penceresindeki "İndir" işleminin Google Drive/Dropbox desteklememesi düzeltildi
6. Mağaza aramasının yanlış sonuç göstermesi düzeltildi
7. Görevin üste sabitlenmesinin başarısız olması düzeltildi
8. Bazı UI istisnaları ve metin sorunları düzeltildi

**1.87.0-rc01（2022/2/23）**

**✨ Yeni Özellikler**

1. Başarım alt kategorisi katlama işlemini destekler
2. Material You tasarım stili anahtarı tanıtıldı (deneysel)
3. Envanter Mağazaya göre sıralamayı destekler
4. Envanter Eşya "yıldız" işlemini destekler
5. Mağaza tümünü seçme işlemlerini destekler
6. Mağaza ve Envanter ilgili işlemleri MAX miktar seçmeyi destekler
7. Görevler sürekli oluşturmayı destekler
8. Görev yapılandırması: Ürün Ödülü açıklaması otomatik olarak kart notlarına eklenir ("Ödül: [bir ürün] x1" otomatik gösterilir)
9. Görev belirtilen dondurma süresini destekler

**⚡️ İyileştirmeler**

1. Yedek çakışması açılır penceresine "Atla" düğmesi eklendi
2. Google Play sürümü Fransızca/Lehçe destekler
3. Görev tıklama bildirim hatırlatıcısı artık Görev ayrıntılarına atlamayı destekler
4. Görevle ilgili zaman düzenlenirken varsayılan açılır pencere geçerli zaman yerine düzenleme öncesi zamana işaret eder
5. Mağazanın her liste seçim girişi "Yeniden adlandır", "Sil", "Yeni" işlemlerini destekler
6. Uzantı sayfası UI yeniden tasarımı
7. "Takvim hesabını sil" için ikinci onay açılır penceresi eklendi
8. Ürün tükendiğinde artık otomatik olarak raftan kaldırılmaz
9. Örnek Görevdeki "Erken kalk" Görevi 0 cezaya değiştirildi
10. Eşya Ödülü alınırken Eşya miktarı negatifse ilgili uyarı görünür
11. Eşya kullanma efektinde jeton rastgele algoritması optimize edildi
12. "Tamamlandı olarak ayarla" işlemine tamamlama ses efekti eklendi
13. Gece modunda bazı UI görüntüleri optimize edildi
14. Görev listesi performansı optimize edildi

**🐛 Hata Düzeltmeleri**

1. Bazı dillerde "ilgisiz" metin anormalliği düzeltildi
2. "İade" açılır penceresindeki ürün simgesinin anormal görüntülenmesi düzeltildi
3. Görev hızlı tamamlandığında tekrar tekrar oluşturulması düzeltildi
4. "Sentez" sisteminde mevcut listenin belleğinin geçersiz olması düzeltildi
5. Yatay ekran durumunda QQ girişinin mümkün olmaması düzeltildi
6. "Sentez" sisteminde [Tümü] listesinde tarif düzenlenirken tarifin orijinal listeden kaybolması düzeltildi
7. Sınırsız Göreve art arda tıklayarak tamamlamak tamamlanma sayısı gösteriminin sıfıra dönmesine yol açabilirdi — düzeltildi
8. Yedekleme aralığının "Aylık" olarak ayarlanamaması düzeltildi
9. Basit modda Deneyim Puanı simgesinin gösterilmemesi düzeltildi
10. Görsel yönetiminde "Başarımlar" ve "Başarım Listesi" sütunlarının eksik olması düzeltildi
11. Görev ayrıntıları sayfasının ekip Görevlerinden vazgeçmeyi desteklememesi düzeltildi
12. Dünya modülü rehberinin doğru görüntülenmemesi düzeltildi
13. Görsel yükleme başarısız olsa bile ürünün başarıyla paylaşılabilmesi ancak yerel görselin üzerine yazılması düzeltildi
14. Bazı nadir çökmeler ve istisnalar düzeltildi

**1.86.0（2022/1/20）**

**Yeni Özellikler**

1. Başarım alt kategorisi: kategorileri ayırma, kategori sayılarını otomatik sayma
2. Google Drive yedekleme
3. Görsel yönetimi işlevi (yedekleme sayfasında)
4. Ürün rastgele jeton efekti
5. Başarımların toplu kopyalanması
6. Adım sayma birden fazla adım girişi ve birden fazla Ödül destekler
7. Pomodoro Eşya değişimi kurmayı destekler
8. Özel iade indirim oranı desteği
9. Yedekleme için özel format (bazı sistemler yedeği doğrudan açıp içe aktarabilir)
10. Basit Sentez toplu işlem destekler
11. Yeni özel ses efekti seçeneği: Eşya kullanma
12. Yeni Başarım kilidi açma koşulu: mevcut ATM mevduatı
13. Negatif konuların kaç kez gerçekleştiği istatistiği ayrıntı sayfasını destekler
14. "Tümü" listesi yeniden adlandırmayı destekler
15. Uygulama bildirim kanallarının adlandırması ve açıklaması birleştirildi

**İyileştirmeler**

1. Kilidi açılmış ancak Ödül alınmamış Başarımlar önceliklendirilir
2. Durum sayfasındaki Pomodoro bugünkü Odak süresi zamana göre saat olarak gösterilir
3. Depo Eşya açıklaması gösterimi ekler
4. Yeni hesap kaydında onay iletişim kutusu açılır
5. Bakım duyurularını gösterme desteği
6. Pomodoro ekstra süre için "Atla" onay iletişim kutusu eklendi
7. Uygulama kaldırılırken veri kaydetme desteği (sistem desteği gerekir)
8. Yedekleme ve kurtarma mantığı optimize edildi
9. Tekil ve sınırsız Eşyaların gecikme mantığı optimize edildi; düzenleme desteklenir
10. Sınırsız etkinliklerin grafik istatistik zaman temeli tamamlanma zamanına dayanır, son tarihe değil
11. Kompakt mod kartı tekil ve sınırsız Eşyaların gecikme süresini de gösterir
12. Arka planda geri sayım işlevinin hayatta kalma oranı iyileştirilmeye çalışıldı
13. İzlenim işlevi optimize edildi:
    -Varsayılan olarak açık
    -Ekip Görevi ayar sayfası gerçekte etkisiz "İzlenimler" anahtarını göstermez
    -Kafa karıştırıcı Duygu anahtarı bellek işlevi kaldırıldı
14. Eşya ve depo listesi açılır penceresi gösterilen Eşya sayısını artırır
15. Bildirim çubuğu zamanlamaya devam ederken devam eden titreşim efekti de iptal edilir
16. Dünya modülündeki dinamik metin seçili kopyayı destekler
17. Özel Başarım sayfası veri yenileme animasyon efekti optimize edildi
18. Kurtarma mantığı optimize edildi; doğrudan takılan arayüz yerine "Yükleniyor" iletişim kutusu gösterilir
19. "Çökme açılır penceresinde" alt düğmenin görülememesi optimize edildi
20. Görev bildirim hatırlatıcısına tıklamak artık Görevin bulunduğu liste sayfasına atlar
21. Özel Özellik simgesi artık uygulama yerleşik simge kitaplığından seçim destekler
22. "Sonra oku" paylaşım işlemi adı doğrudan uygulama adı yerine optimize edildi
23. Başarım kilidi açma bildirimi optimize edildi; Başarım açıklaması artık gösterilir
24. Masaüstü widget'ı ana sayfaya girdiğinde otomatik olarak "delegasyon" modülüne atlar
25. Gün listesi tamamlandıktan sonraki metin gösterimi optimize edildi
26. Ürün geri sayım efektinin işlem metni ve sırası optimize edildi
27. Tüm Özellikler gizlendiğinde durum sayfası "Özellik" kartını artık göstermez

**Hata Düzeltmeleri**

1. Başarım kilidi açma açılır pencerelerinde nadir çökme düzeltildi
2. Yetersiz genişlikte masaüstü widget'ları boşaltılırken bir Görevin birden fazla satır sıkıştırması düzeltildi
3. Adım sayma için ilk hareket yetkilendirmesinin sensörün biriken toplam adım sayısını göstermeyi desteklemesi düzeltildi
4. Geri sayım duraklatılıp başka bir geri sayım başlatıldığında çökme veya kurtarma karışıklığı düzeltildi
5. Ürünün 0 dakikalık geri sayım efektine girilebilmesi ve çökmesine yol açması düzeltildi
6. Eşya ekleme veya düzenleme sayfasında seçili liste yeniden adlandırıldığında mevcut liste adının zamanında yenilenmemesi düzeltildi
7. "Yıllık" tekrar sıklığına sahip kartların anormal görüntülenmesi düzeltildi
8. Özel jetonların bazı durumlarda zamanında etkili olmaması düzeltildi
9. Widget'ların dondurulmuş Eşyaları göstermesi düzeltildi
10. Özel Başarımın "uzun basma işlemi" istemini göstermemesi düzeltildi
11. "Ben" sayfasındaki toplam Deneyim Puanının özel Özelliğin Deneyim Puanını saymaması düzeltildi
12. "İzlenimler" sayfasının görsel önizlemeden sonra anormal şekilde en üste dönmesi düzeltildi
13. "Domates" statik kısayolunun MIUI sisteminde uygulama başlatıldıktan sonra yalnızca ana sayfaya atlaması düzeltildi
14. Üye olmayanların da özel arka plan yükleyebilmesi düzeltildi
15. Mağaza sayfasındaki jeton sayısının zamanında yenilenmemesi düzeltildi
16. Takvimin bir sonraki yıla geçirilememesi düzeltildi
17. Liste adı değiştirildikten sonra widget'taki liste adının zamanında yenilenmemesi düzeltildi

**Release Candidate → Resmi Sürüm**

1. Google Drive'da büyük dosya yükleme başarı oranı optimize edildi; yeniden deneme artırıldı ve blok stratejisi iyileştirildi
2. Üyelerin Çince olmayan ortamda bireysel özel Görev arka planı düğmesini görememesi düzeltildi
3. Google Drive/DropBox yedeklemesi başarısız olduğunda WebDAV yapılandırma sayfası yerine yedekleme sayfasına atlama
4. Google Play doğrulama hatası açılır penceresi açıklaması eklendi ve veri dışa aktarma yolu sağlandı
5. "Ben" sayfası takma adı üyelik durumuna göre renk değiştirir
6. Çoğu senaryoda ATM faiz oranı kayan nokta hatası giderildi
7. Yerel veriler silinirken özel arka plan, Özellik görseli ve ses efekti dosyaları da eşzamanlı silinir
8. Adım sayısı grafiği anormal sorunu düzeltildi
9. Yeni yapılacak sayfasından Özellik soru işaretine tıklayıp Özellik özelleştirme sayfasında düzenleyip geri dönüldüğünde Özelliklerin yenilenmemesi düzeltildi
10. Ürün efektini özelleştirirken açılır pencerenin dışına tıklamak artık otomatik iptal etmez; düzenleme içeriği kaybı önlenir
11. Ürün ayar sayfasının yabancı dil UI sorunu optimize edildi (Rusça metin çok uzun)
12. Bazı modellerde renk toast çökmesi düzeltilmeye çalışıldı
13. Depo sayfası seçiliyken kullan düğmesinin hâlâ tıklanabilir olması düzeltildi
14. Akıllı listede gecikmiş tekil Görevlerin gösterim mantığı düzeltildi; yeni gecikme süresi depolama yöntemine uyarlandı
15. Depo seçiliyken geçiş listesi seçimi kaldırılmalı

**1.85.4 (2021/12/08)**

Düzenli hata düzeltme sürümü, bir sonraki özellik sürümü hâlâ geliştiriliyor~

1. Karanlık mod olmayan widget jeton varsayılan simgesinin doğru görüntülenmemesi düzeltildi
2. Sürekli yükseltme/düşürmede ilerleme çubuğu animasyonunun normal oynamaması düzeltildi
3. Depo sayfası jeton sayısının zamanında güncellenmemesi düzeltildi
4. "Haftanın günü" öğesi düzenlenirken son tarihin zorla değiştirilebilmesi düzeltildi
5. Eşya düzenlerken ekran döndürmenin değiştirilen alt Görev bilgilerinin kaybolmasına yol açması düzeltildi
6. Yeni ürün oluştururken veya düzenlerken jeton sayısının gerçekte etkili olmaması düzeltildi
7. Düzeltme ayrıntıları sayfasında yıllık tamamlanma sayısı gösterim koşulları
8. Uygulamadaki görsel depolama optimize edildi; sistem fotoğraf albümü tarafından taranmamalı
9. Duygu anahtarı açıklaması optimize edildi
10. Bazı çökmeler düzeltildi

**1.85.3 (2021/11/18)**

1. Zamanlama zaman hesaplama yöntemi optimize edildi; CPU uyku süresini telafi eder
2. Ürün kopyalanırken simge düzenlemenin orijinal ürün simgesinin kaybolmasına yol açması düzeltildi
3. Diğer küçük hata düzeltmeleri (ör. ekip etiketi)

**1.85.2 (2021/11/07)**

1. Zamanlama askıya alındıktan sonra hesaplaşmada kayıt ve Ödül oluşturulamaması düzeltildi
2. Akıllı liste altında "taşı" işleminin listenin yanlış görüntülenmesine yol açması düzeltildi
3. "Mevcut jeton sayısı" mevcut değer gösteriminin gerçek hesaplamayla uyuşmaması düzeltildi (mevcut değer ATM mevduatını içermez)
4. Pomodoro çalışması bittikten sonra atla düğmesine art arda iki kez tıklanınca kayıt ve Ödülün tekrarlanması düzeltildi

**1.85.1 (2021/11/02)**

0. Duygular listesi yükleme sorunu düzeltildi

**1.85.0 2021/10/20)**
*Özellikler*

1. Pomodoro pozitif zamanlama modunu destekler
2. Hızlı alt Görev oluşturmak için birden fazla satır metin yapıştırma
3. Eşya kopyalama işlemini destekler
4. Eşya listesi kaydırma yönü değiştirilebilir; ters desteklenir (ayarlar-Eşyalar)
5. Pomodoro kaydını temizleme desteği
6. Pomodoro zorunlu yatay/dikey ekran geçiş düğmesi eklendi
7. Başarım kilidi açma koşulları genişletildi:
   ● Sentezle elde edilen ürün sayısı
   ● Eşyaların birikimli edinim miktarı
   ● Ürünün mevcut miktarı
   ● Yaşam Seviyesi
   ● (Tekrarlayan) Görevin Odak süresi
8. Yetenek simgesi de birden fazla kırpma ayarını destekler
9. Statik kısayol:
   ● Yeni Görev
   ● Pomodoro sayfasına gir
10. Ses efekti özelleştirmesi genişletildi:
    ● Başarım Ödülleri alma (sistem ve özel Başarımlar dahil)
    ● Ganimet Kutusu açma
    ● Sentez (basit Sentez ve Sentez dahil)
    ● Bildirim ses efekti
11. Jeton simgesi özelleştirme
12. Eşya kullanma efekti birden fazla Deneyim Puanı değişim efekti ayarlamayı destekler
13. Deneyim Puanı pasta grafiği Yeteneklere uyarlama değişiklikleri
14. Geçmiş sayfası durum filtrelemesini destekler
15. Ekip etiketi işlevi

*İyileştirmeler*

1. Alt Görev jeton Ödülü 0 olduğunda ayrıntılarda jeton Ödülü gösterilmez
2. Yeni Başarım listesi sayfası oluşturuldu ve "Başarım Oluştur" rehberi eklendi
3. Widget simge gösterimi optimize edildi
4. Alt Görev tamamlamaya ses efektleri eklendi (ayrıntılar, yeni sayfalar)
5. Yeni veya düzenleme (Görevler, Eşyalar, Başarımlar, Sentez) sayfasında içerik girildikten sonra geri düğmesine tıklanınca değişiklikleri atma onay kutusu açılmalı
6. Ürün oluşturma sıralama optimizasyonu (özel sıralamada yeni eklenen ürünler en üstte olmalı)
7. Görev/Eşya düzenlerken giriş yöntemi otomatik açılmamalı
8. Yeni Görev sayfası yatay ekranı ve veri kaybını desteklemeli
9. Masaüstü widget'ları için üye tema rengi uyumu
10. Ürün seçim kutusu optimize edildi; önce gösterim, sonra veri asenkron yüklenir
11. Depo sekmesine "Sentez" ve "ATM" girişleri de eklendi
12. Geçmiş durum değişikliğindeki [Tamamlandı olarak ayarla] ve [Geri al] işlemleri birinci seviye menüye geri alındı
13. Etkinlik ayrıntıları için Pomodoro hızlı girişi eklendi
14. Mağazanın "Tümü" listesi sıralama optimizasyonu (listeye göre gruplama seçeneği eklendi, yalnızca mağazalar)
15. Haftanın günleri tekrarı seçildikten sonra son tarih yeniden hesaplanmalı. (Kullanıcının iş günü tekrarı seçip son tarihin cumartesi-pazar kalmasını önler.)
16. "Delegasyon" sayfasına dönüldüğünde "+" düğmesi görünmüyorsa gösterim tetiklenir.

*Hata Düzeltmeleri*

1. Başarım sayfası alt gezinme çubuğuna yapılandırıldığında listedeki ilerlemenin zamanında yenilenmemesi düzeltildi
2. Geçmiş Eşyaların durum geçiş sorunu düzeltildi
3. Negatif geri sayım gecikme gösterimi onarıldı
4. Jeton Başarımı ATM mevduatına dahil edilmeli
5. Pomodoro duraklatıldığında Pomodoro'ya iki kez yeniden girilince sürenin sıfırlanması düzeltildi
6. Satın alma kısıtlamasının belirli durumlarda geçersiz olması düzeltildi
7. Geri sayım kayıtlarının nadir durumlarda tekrarlanması düzeltildi
8. Farklı Görev kartlarına hızlı art arda tıklamanın sayfaya dönüldüğünde kartlardan birinin içeriğinin boş kalmasına yol açması düzeltildi
9. Jeton ve Deneyim Puanı otomatik hesaplama mantığı ayarlandı
10. Bazı çökmeler düzeltildi


**1.84.4 (2021/10/09)**

1. Yerleşik simgenin görüntülenmemesi sorunu düzeltildi

2. Q grubu güncellendi

**1.84.3 (2021/10)**

1. Yurtdışı metinleri güncellendi

**1.84.2 (2021/09/26)**

1. Sentezin neden olabileceği kilitlenme sorunu düzeltildi

2. Kullanılamayan ürünlerin ayrıntılarında anormal kullanım efektlerinin gösterilmesi sorunu düzeltildi

3. Widget'ların yuvarlatılmış köşe görsel efekti optimize edildi

**1.84.1 (2021/09/20)**

1. Düzenleme sırasında hedef tekrar sayısının temizlenememesi sorunu düzeltildi

**1.84.0 (2021/09/19)**

***Özellikler***

1. Yetenek sistemi (Özellik özelleştirme)

   Tüm özgün mekanizmalar Özellik özelleştirme sistemine uyarlandı; örneğin Başarım Özelliklerinin kilidi açma koşullarına ulaşması, ürün Deneyim Puanı Ödülleri vb.

2. Pomodoro'nun yenilebilir etkisi özelleştirilebilir; Deneyim Puanı değeri ve Özellik türleri değiştirilebilir

3. Mağaza simgesi kırpma stilini değiştirmeyi destekler (Mağaza ayarları)

4. Ürün ayrıntıları artık kullanım efektleri listesini gösterir

5. Üye tema rengi #6bab8b eklendi

6. Hatırlatıcı takvim hesabını silme desteği

***İyileştirmeler***

1. Pomodoro sayfası yatay görüntülemeyi destekler

2. Ürün ayarlarına "Ödünç Verilebilir Tutar" açıklaması eklendi

3. Bulut eşitlemesinin dosya boyutu hatırlatıcısı eklendi

4. Facebook ve Dropbox bağımlılıkları güncellendi

5. Sayfa UI görüntüsü ve metinlerin bir kısmı optimize edildi

6. Yeni alt Görevlerin etkileşimi optimize edildi

***Hata Düzeltmeleri***

1. Özelliğin varsayılan simge sürümünün tutarsız olması sorunu düzeltildi

2. Kutuyu hızlı açmaya tıklamanın tekrarlı kutu açmaya veya çökmeye yol açması sorunu düzeltildi

3. Hatırlatılmış takvim etkinliklerinin Eşyalar silinirken eşzamanlı kaldırılmaması sorunu düzeltildi

4. Geçmiş sayfasında Eşyanın "Tamamlandı"dan "Gecikmiş"e ayarlanmasından sonraki anormal durum düzeltildi; geçmiş veriler yeni sürüme yükseltildiğinde otomatik onarılır

5. Yeni ürün oluşturulurken liste seçim iletişim kutusunda seçili listenin yanlış işaretlenmesi sorunu düzeltildi; "tümü" listesinin gösterimi kaldırıldı

6. Diğer içerik + hedef tekrar sayısı düzenlenirken düzenlemenin tekrar başarısız olması sorunu düzeltildi

7. Yeni Başarım sayfası oluşturuldu; Özellik seçiminin düzenlenememesi ve boş bırakılması sorunu düzeltildi

8. Diğer küçük hata düzeltmeleri ve optimizasyonlar

**1.83.16 (2021/08/20)**

1. Çevrimdışı modda avatar değişikliğinin çökmesi ve etkisiz kalması düzeltildi
2. Ürün kutu açma efekti seçiminin etkileşimi optimize edildi
3. Bazı uzun metin giriş kutularının odak sorunu düzeltildi
4. Hatırlatıcı son tarih ve saatinin bazı durumlarda yanlış gösterilmesi sorunu düzeltildi
5. Kompakt modun ilgili yapılandırma değişikliklerinin hemen etkili olmaması sorunu düzeltildi

**1.83.15**

1. App widget'larında ceza Görevlerini işaretleme desteği
2. "Yedi gün dışındaki konuları katlama"nın anormal davranışı düzeltildi
3. Duygu resimlerinin üst sınırı 9 resme çıkarıldı
4. Giriş sayfası son giriş yöntemini gösterir
5. Ceza iptal edildiğinde (tamamlandı olarak işaretlendiğinde) ek Ödül verilmez
6. Akıllı liste artık tamamlanan Eşyaları göstermeyi destekler
7. Bazı durumlarda download klasörüne otomatik yedeklemenin anormal olması düzeltildi
8. Bazı UI görüntü sorunları düzeltildi

**1.83.14**

1. Pomodoro "atla" yürütülürken süre kaydı yapılmaması sorunu düzeltildi
2. Ceza Eşyalarının gecikme ve ceza mantığını yürütmesi sorunu düzeltildi
3. Ceza düzenlemeyle ilgili sorunlar düzeltildi
4. Yatay modda resim seçmeyle ilgili sorunlar düzeltildi
5. Özel yoldan yedek geri yüklerken ara sıra geri yükleme başarısızlığı düzeltildi

**1.83.8-1.83.13**
Özellikler

1. Kart arka planının bağımsız ayarlanması desteği
2. Kayıt silme işlevi artık Duygular, depolar ve zamanlama kayıtlarını silmeyi destekler
3. Sistem Başarımları Deneyim Puanı veya jeton Ödülü almayı seçebilir
4. Etkinlik arama işlevi
5. "download" klasörüne yerel otomatik yedekleme desteği (Android 10 ve üzeri)

İyileştirmeler

1. Varsayılan bildirim hatırlatıcı çağrı yöntemi iyileştirildi; Android 6 üzerinde bildirim başarı oranını teorik olarak artırabilir
2. Pomodoro zamanlayıcısının bildirim önceliği [Yüksek] yapıldı; arka plan zamanlayıcısının hayatta kalma olasılığı ve bildirim görüntüsü iyileştirildi
3. Sayfaya QQ grubu ve resmi web sitesi bağlantıları eklendi, UI optimize edildi; QQ tek tıkla gruba katılmayı destekler
4. Başarım bildirimlerinin tetiklenme zamanlaması iyileştirildi; ana sayfada tetiklendikten hemen sonra hatırlatılmalı
5. Eşya listesinin "Filtre" seçeneğine "Yalnızca geçerli listeye uygula" onay kutusu eklendi; varsayılan ve tüm liste seçenekleri ayrıldı
6. Sentez sırasında animasyon efektleri eklendi
7. Geri bildirim: Rabbit Xiaochao topluluğu geri bildirim kanalı genişletildi; resim yükleme ve sorun takibi kolaylaştı
8. Sayım Eşyası giriş kutusuna göreli değer gösterimi eklendi
9. Seçili olmayan Sekme görüntü efekti optimize edildi
10. Avatara tıklayınca rastgele istem kaldırıldı; bunun yerine tıklayınca kişisel ana sayfaya girilir
11. Jeton Ödülü ayarlanmadığında "0" yerine "ayarlanmadı" gösterilir
12. Kutu açma olasılığı %0,01'in altındaysa artık "0,00%" yerine "<0,01%" gösterilir
13. Duygular anahtarı artık hatırlanmaz ve varsayılan olarak kapalıdır
14. Takvim ve kamera izinlerinin uygulama süreci optimize edildi
15. Bazı sayfaların tıklama ve görüntü efektleri optimize edildi
16. Takvim hatırlatma yöntemi optimize edildi; bazı cihazların takvim hesabını silebilmesi sorunu çözülmeye çalışıldı

Hata Düzeltmeleri

1. Duygular sayfasında sürekli filtrelemenin çökme sorunu düzeltildi
2. Hazır ayarlı iletişim kutusunun nadir çökmesi düzeltilmeye çalışıldı
3. Giriş kutusu uzunken metne tıklamanın otomatik olarak alta atlaması sorunu düzeltildi
4. Ekip oluşturulurken rastgele jeton Ödülü ayarlanamaması sorunu düzeltildi
5. Yurtiçi dağıtım sürümü Firebase bağımlılıklarını tamamen kaldırdı
6. Başarım listesi sayfası yenilenirken ara sıra oluşan istisna düzeltildi
7. Yerleşik simge seçilirken ara sıra oluşan anormal çökme düzeltildi
8. Tüm alt Görevler silindikten sonra ayrıntı sayfasına dönüldüğünde alt Görevlerin hâlâ görünmesi sorunu düzeltildi
9. Sentez varsayılan listesinin adının düzenlenememesi sorunu düzeltildi
10. Profil sayfasında filtre kutusunun görüntülenmesi sorunu düzeltildi
11. Ürün Ödülü ayarlandıktan sonra ekip Eşyasının devralınamaması sorunu düzeltildi

**1.83.7 (2021/06/24)**

1. Liste eklenen jetona göre sıralanır
2. Rehber sayfasına dil seçimi eklendi
3. Başarım sayfasının yükleme hızı optimize edildi
4. QQ grubu tek tıkla katılım bilgisine değiştirildi
5. Kutu açma sırasında sürekli tıklamanın Envanter değişikliğini birden fazla kez tetiklemesi sorunu düzeltildi
6. Günlük Eşya listesinde tek gecikmiş Eşyanın yanlış gösterilmesi düzeltildi

**1.83.6 (2021/06/22)**

Özellikler

1. (Üyeler) Kart arka planının bağımsız ayarlanması desteği
2. Kayıt silme işlevi artık Duygular, depolar ve zamanlama kayıtlarını silmeyi destekler
3. Sistem Başarımları Deneyim Puanı veya jeton Ödülü almayı seçebilir
4. Etkinlik arama işlevi
5. "download" klasörüne yerel otomatik yedekleme desteği (Android 10 ve üzeri)

Optimizasyon

1. Varsayılan bildirim hatırlatıcı çağrı yöntemi iyileştirildi; Android 6 üzerinde bildirim başarı oranını teorik olarak artırabilir
2. Pomodoro zamanlayıcısının bildirim önceliği [Yüksek] yapıldı; arka plan zamanlayıcısının hayatta kalma olasılığı ve bildirim görüntüsü iyileştirildi
3. Sayfaya QQ grubu ve resmi web sitesi bağlantıları eklendi, UI optimize edildi; QQ tek tıkla gruba katılmayı destekler
4. Başarım bildirimlerinin tetiklenme zamanlaması iyileştirildi; ana sayfada tetiklendikten hemen sonra hatırlatılmalı
5. Eşya listesinin "Filtre" seçeneğine "Yalnızca geçerli listeye uygula" onay kutusu eklendi; varsayılan ve tüm liste seçenekleri ayrıldı
6. Sentez sırasında animasyon efektleri eklendi
7. Geri bildirim: Rabbit Xiaochao topluluğu geri bildirim kanalı genişletildi; resim yükleme ve sorun takibi kolaylaştı
8. Sayım Eşyası giriş kutusuna göreli değer gösterimi eklendi
9. Seçili olmayan Sekme görüntü efekti optimize edildi
10. Avatara tıklayınca rastgele istem kaldırıldı; bunun yerine tıklayınca kişisel ana sayfaya girilir
11. Jeton Ödülü ayarlanmadığında "0" yerine "ayarlanmadı" gösterilir
12. Kutu açma olasılığı %0,01'in altındaysa artık "0,00%" yerine "<0,01%" gösterilir

**1.83.0-alpha04 (2021/05/23)**

1. Alt modülün serbest yapılandırması, sıralaması ve devre dışı bırakılması desteği
   Modüller gelecekte kademeli olarak uyarlanacak; şu an yalnızca bazı işlev modülleri desteklenir (ör. Pomodoro; geçmiş henüz uyarlanmadı)
2. Ürün geri sayım efektine ikinci duraklatma modu eklendi; bildirim çubuğunda kalır ve istediğiniz zaman devam ettirilebilir
    Ve "deneysel" logosu eklendi
3. Pomodoro atlanırken Pomodoro alınamayacağına dair hatırlatıcı eklendi
4. Örnek Görevi genişletme/daraltma ipucu eklendi
5. Bazı sayfalarda listenin üst düzeninin neden olabileceği çökme düzeltildi
6. Ağ bağlantısı kesildiğinde ağ hatası istemi optimize edildi
7. Alt Görevler tamamlanırken jeton Ödülü hatırlatıcısı optimize edildi; engellemeyen Toast hatırlatıcısına değiştirildi

**1.83.0-alpha03 (2021/05)**

1. Sentez sayfasının boş düzen görüntüsünün ekranı aşması sorunu düzeltildi
2. Yeni oluşturma sayfasında "Cazibe" Özellik adının yanlış gösterilmesi sorunu düzeltildi
3. Jeton ayarlarıyla ilgili bazı sorunlar düzeltildi
4. Başarım sayfasının animasyon efekti alt gezinme çubuğu sahnesine uyarlanacak şekilde optimize edildi
    (Uyarlandı ancak arayüz henüz hazır değil; lütfen sonraki güncellemeleri bekleyin)
5. Hedef SDK sürümü Android 11'e yükseltildi
6. "An" sayfasının boş düzen görüntü sorunu düzeltildi
7. Anormal faiz hesaplama sorunu düzeltildi

**1.83.0-alpha02 (2021/05/16)**

1. "Tümü" listesinde sentez tariflerinin oluşturulabilmesi sorunu düzeltildi
2. Sentez sistemi arayüzüne girildikten sonra hangi listede olursanız olun gerçek görüntülenen içerik "Tümü" listesidir.
3. ATM faiz hesaplama yönteminin basit onarımı

**1.83.0-alpha01 (2021/05/16)**

1. Herhangi bir N-N sentez uygulamasını destekleyen eksiksiz sentez sistemi
   - Kontrol listesi
   - Yeni/Düzenle
   - Sentez iletişim kutusu
   - Karanlık mod ve çoklu dil desteği
   - "Giriş" Mağaza sayfasının üstünde
2. Yeni Eşya sayfasının dahili kodu yeniden düzenlendi
    Uygulamanın ölçeklenebilirliği için yeni oluşturulan Eşyaların kodunu neredeyse tamamen düzenledik; gelecekte UI yeniden tasarlanabilir.
    Sonraki alpha güncellemeleri "hedef tekrar tarihi", "göreli hatırlatma zamanı", "ceza türü Eşyalar (belirlenecek)" ve diğer işlevleri de ekleyecek.
    Sorun yaşarsanız istediğiniz zaman eski sayfa sürümüne geçebilirsiniz.

3. Mağazanın üstüne ATM girişi eklendi
4. Eşya eki en fazla 9 resim destekler; depolama yolu ayarlandı
5. Ekip TAG işlevi
    Uygulama dahili ancak belirli TAG içeriği henüz yapılandırılmadı; şimdilik gösterilmez

**1.82.16 (2021/05)**

1. Örnek Eşyaların gecikme mantığını doğru yürütememesi sorunu düzeltildi (yalnızca yeni kullanıcılar için geçerli)
2. Belirli senaryolarda sınırsız Eşyaların tamamlanma sayısının 1 eksik kalması sorunu düzeltildi

**1.82.15 (2021/05)**

1. Arka plan ses efekti oynatma sorunu düzeltildi

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Sınırsız Eşyaların listeyi yavaş yüklemesine ve iptal sayısının hatalı olmasına yol açması sorunu düzeltildi
2. Masaüstü widget'ında Görev tamamlanırken tamamlama ses efektinin birden fazla kez oynatılması sorunu düzeltildi
3. Akıllı listedeki üst Eşyaların toplam sayısının hatalı olması sorunu düzeltildi
4. Tüm yerel verileri silme ve hesabı silme işlevleri desteği
5. Ekip Eşyalarının alt Görev düzenlemesinin devralınamaması sorunu düzeltildi

**1.82.12 (2021/05)**

1. Sınırsız Eşyaların tamamlanmasını geri alma sayım sorunu düzeltildi
2. Dondurulmuş Eşyaların hâlâ hatırlatılması sorunu düzeltildi
3. Liste geçişine bazı optimizasyonlar yapıldı; eski cihazlarda geçiş hızını artırabilir ve yükleme animasyonları eklendi
4. Özel dinlenme bitiş ses efektinin etkisiz kalması sorunu düzeltildi; ürün zamanlama bitiş ses efekti ayarlanabilir
5. Pomodoro "atla" işlemi kullanıldığında Odak süresini sayamaması sorunu düzeltildi
6. Ürün geri sayım duraklat düğmesinin etkisiz kalması sorunu düzeltildi

**1.82.11 (2021/05)**

1. Sınırsız Eşyaların tamamlanmasını geri alma sayım sorunu düzeltildi
2. Dondurulmuş Eşyaların hâlâ hatırlatılması sorunu düzeltildi
3. Liste geçişine bazı optimizasyonlar yapıldı; eski cihazlarda geçiş hızını artırabilir ve yükleme animasyonları eklendi
4. Özel dinlenme bitiş ses efektinin etkisiz kalması sorunu düzeltildi; ürün zamanlama bitiş ses efekti ayarlanabilir
5. Rusça dil desteği

**1.82.10 (2021/05)**

1. Pomodoro "atla" işlemi kullanıldığında Odak süresini sayamaması sorunu düzeltildi
2. Ürün geri sayım duraklat düğmesinin etkisiz kalması sorunu düzeltildi
3. Takvim hatırlatıcısı oluşturulamamasından kaynaklanan çökme yakalandı

**1.82.9 (2021/05)**

1. Kopyalanan Eşyanın zaman sınırının boşaltılabilmesi ve tekrarlandığında çökmeye yol açması sorunu düzeltildi
2. Sınırsız Eşyalar tamamlandıktan sonra yenileme hızı optimize edildi
2. Ekip Görevlerinin hatırlatma zamanı hesaplama sorunu düzeltildi
3. Kaydırarak tamamlamanın animasyonun doğru bitmemesine ve boş kalmasına yol açması sorunu düzeltildi
4. Ekip Görevleri kaydırarak vazgeçmeyi desteklemeli
5. Satın alma penceresindeki ürün tanıtımı kaydırarak gezinmeyi destekler

**1.82.8 (2021/04/28)**

**özellikler**

1. Mevcut tamamlama serisi gösterimi eklendi
2. Mağaza Eşyası geri sayım efekti optimize edildi; bitirme ve duraklatma olmak üzere iki işlem eklendi; anormal sonlandırmada mutlak zamana göre hesaplanır
3. Pomodoro titreşim modu ve zil anahtarının ayrı ayarlanması desteği
4. Takvimde devam eden etkinliklerin gelecek son tarihlerinin kısmi önizlemesi desteği
5. Tekil ve sınırsız etkinlikleri yeniden başlatma desteği
6. "Ben" sayfasındaki veri gösterimi değiştirildi: "Gecikmiş" ve "Vazgeç" → "Başarım (Kilit Açıldı)" ve "Duygular"; istatistik sayfası artık "Gecikmiş" ve "Vazgeçilmiş" sayısını gösterir
7. "Masaüstü widget'ları" ayar sayfasından doğrudan widget oluşturma başvurusu desteği (yalnızca Android 8 ve üzeri)

**iyileştirmeler**

1. Mağaza Eşyalarının büyük resimlerini görüntüleme desteği
2. Adım sayımının neden olabileceği güç tüketimi sorunu optimize edildi
3. Yazı tipi çok büyükken bazı görüntü sorunları düzeltildi
4. Sınırsız Eşyaların iptali optimize edildi
5. Pomodoro bildirimlerinin görüntüsü optimize edildi ve ilerleme çubuğu eklendi
6. Etkinlik tamamlandıktan sonra o anda gösterilen bildirim hatırlatıcısı kaldırılır
7. Jeton gelir-gider istatistikleri optimize edildi
8. Bazı kullanıcı rehberleri ve ipuçları eklendi
9. Eşya düzenlerken ürün Ödülü seçimini temizleme desteği
10. Sürekli çökmelerde "Bilinen Sorunlar" bildirimi eklendi
11. Özellik seçilmediğinde görüntü efekti optimize edildi

【düzeltme】

1. Ana sayfada liste sıralandıktan sonra durum hemen yenilenmeli
2. Ayrıntı sayfasının alt Görev listesini hemen yenilememesi sorunu düzeltildi
3. Weibo yetkili girişinin çökme sorunu zorla düzeltildi
4. Pomodoro bildiriminde gösterilen Eşya adının hatalı olması sorunu düzeltildi
5. Pomodoro bildirim geri sayımının hatalı gösterilmesi sorunu düzeltildi
6. Eşya ve Başarım yalnızca ürün Ödüllerine sahipken Ödül kutusunun açılmaması sorunu düzeltildi
7. Belirli durumlarda 0 jetonluk satın alınamaması sorunu düzeltildi
8. Ebbinghaus Eşyalarının onarım hesaplama yöntemi optimize edildi
9. Sınırsız etkinliklerin bugünkü tamamlanma sayısı hesaplama yöntemi optimize edildi

**1.82.7 (2021/04/10)**

1. [Anlar] ekranında boş veri UI görüntüsü düzeltildi
2. Yazı boyutu tekrar sistem ayarlarını izler
3. İngilizce ve Portekizce çeviri güncellendi

**1.82.5 (2021/04/02)**

1. Pomodoro kaydıyla ilgili bazı sorunlar düzeltildi
2. Yeni rehberler eklendi

**1.82.4-alpha01/beta (2021/03/25)**

1. Ganimet Kutusu Ödülleri düzeltildi
2. Seçili Görevlerin Duygularını görüntüleme
3. Özel Başarım için Deneyim Puanı/rastgele jeton Ödülleri
4. Akıllı listedeki Görevler artık listeye göre gruplanır
5. Yıllık tekrar
6. Daha fazla iyileştirme ve hata düzeltmesi

**1.82.1 (2021/03/12)**

1. Akıllı listelerle ilgili bazı sorunlar düzeltildi
2. Görev tamamlandıktan sonra ilerleme çubuğunun değişmemesi sorunu düzeltildi
3. Sayım Görevini zorla tamamlamayla ilgili sorun düzeltildi
4. Gecikme alt iletişim kutusunda "NULL" gösterilmesi sorunu düzeltildi

**1.82.0 (2021/03/11)**

1. Akıllı listeler
2. Özellik simgeleri yeniden tasarlandı
3. Yeni Eşya efekti "Geri sayım"
4. Pomodoro zamanlayıcısı süre bittikten sonra ekstra süreyi kaydetmeye devam eder; Odak süresini güncellemeyi ve ekstra Ödül almayı seçebilirsiniz.
5. Sayım Görevleri hedef sayıya ulaşılmadan zorla tamamlanabilir.
6. Artık başlamamış Görevleri tamamlamayı ve süreyi ertelemeyi seçebilirsiniz
7. Daha fazla hata düzeltmesi ve iyileştirme

**1.81.6**

1. Pomodoro hatırlatıcı ipucuyla ilgili sorunlar düzeltildi

**1.81.5 (2021/03/02)**

1. İtalyanca çeviri (kısmi)
2. Bildirim simgesi düzeltildi
3. Haftanın günü tekrarıyla hatırlatıcının düzgün çalışmaması düzeltildi
4. "Fotoğraf çek" seçiminin çalışmaması düzeltildi
5. Daha fazla küçük düzeltme

**1.81.0~1.81.4**

1. Bazı UI ve animasyonlar yeniden tasarlandı
2. Tüm alt Görevler tamamlandığında Görev otomatik tamamlanır
3. Çoklu Deneyim Puanı değişikliği hatası düzeltildi
4. Dropbox geri yükleme hatası düzeltildi
5. Artık jeton almadan Eşya iade edilebilir
6. 12 saatlik saat görüntüleme ayarı
7. Birden fazla Görevi dondur/çöz

**1.80.7（2021/01/26)**

1. Mağaza Eşyası istatistiği eklendi
2. Özellik açıklama iletişim kutusu yeniden tasarlandı
3. Özel Özellik açıklaması
4. Kompakt mod için yapılandırma ayarı: tüm ekstra bilgileri gizle
5. Yedek dosyasından geri yükleme hatası düzeltildi
6. Daha fazla düzeltme ve iyileştirme...

**1.80.6（2021/01/22)**

1. Ganimet Kutusu efektli Eşya artık pazarda paylaşılabilir
2. Yeni arama sayfası: takma ada göre kullanıcı arama
3. Ekip/pazar Eşyalarını zaman aralığına göre filtreleme
4. Hızlı Görev ekleme bildirimi
5. Yedekleme sırasında medya dosyaları yok sayılabilir.
6. Daha fazla düzeltme ve iyileştirme...

**1.80.5（2021/01/14)**

1. Tek tıkla 10/50 Ganimet Kutusu açma
2. Kilidi açma koşulu eklendi [Ganimet Kutularından belirli sayıda seçili Eşyayı al]
3. ATM faiz oranı ayarları
4. Domates satma/yeme için sayı girişi
5. Özel dinlenme zamanlayıcısı bitiş ses efekti
6. Bazı kullanıcı rehberleri eklendi
7. Bazı sorunlar düzeltildi ve iyileştirmeler yapıldı

**1.80.4（2021/01/04)**

1. Android 6'da çökme düzeltildi

**1.80.3（2021/01/04)**

1. Serbest biçimde resim kırpma
2. Pazardaki Eşyaların simgesini görüntüleme/ekleme
3. Görev/Eşya seçerken artık doğrudan yeni oluşturulabilir
4. Kullanıcı Başarımları için COPY eylemi desteği
5. Çok sayıda düzeltme ve iyileştirme

**1.80.0（2020/12/24)**

1. Ganimet Kutusu Mağaza Eşyası efekti!
2. Dropbox yedeklemesi entegrasyonu
3. Kompakt mod yapılandırmaları
4. Fotoğraf seçim geçmişi çubuğu eklendi
5. Çok sayıda düzeltme ve iyileştirme

**1.79.x（2020/12)**

1. 3 ek kilidi açma koşulu ayarı
2. Özel ses efekti ayarları
3. Başarımlar için Eşya Ödülü ayarlama
4. Pomodoro zamanlayıcı kayıt sayfası
5. Takvim sayfasından Görev oluşturma
6. 5 yeni tema rengi.
7. Çok sayıda iyileştirme ve düzeltme

**1.78.x（2020/11)**

1. Özel Başarım kilidi açma koşulu
2. Özel Görev Deneyim Puanları
3. Çok sayıda iyileştirme ve düzeltme

**1.77.1（2020/11/05)**

1. Liste geçiş araç çubuğu
2. Tamamlanan Görevleri göster anahtarı
3. Liste artık arşivlenebilir
4. Jeton durum kartı eklendi
5. Artık kullanıcı Başarımları için Duygular oluşturulabilir
6. Sistem karanlık modunu izleme ayarı eklendi

**1.77.0（2020/10/28)**

1. Topluluk için Pazar modülü eklendi; Mağaza Eşyası tasarımını paylaşabilir veya Eşya içe aktarabilirsiniz
2. Ay tekrarı mantığı düzeltildi
3. En az bir kez yedekleme yapılmadığında WebDAV otomatik yedeklemenin çalışmaması düzeltildi

**1.76.0（2020/10/13)**

1. Alt Görev varsayılan jetonu
2. Mağaza Eşyası ve Başarım oluşturmak için uygulama içi simgeler eklendi
3. Özel domates fiyatı
4. Genel ses efekti etkinleştirme ayarları
5. Artık Duygular Görev içeriğine göre aranabilir

**1.75.2（Released at 2020/10/05）**

1. Alt Görev varsayılan jeton sayısı ayarı
2. Mağaza Eşyası/Başarım simgesi olarak seçilebilecek 100'den fazla simge eklendi
3. "Ses efektini etkinleştir" ayarı eklendi
4. Duyguları Görev içeriğine göre filtreleme ve daha iyi filtre UI'si
5. Pomodoro kısayolları oluşturma
6. Özel domates satış fiyatları
7. Pomodoro sayfası geri sayım sırasında ekranı açık tutar
8. Bazı sorunlar düzeltildi

**1.75.1（Released at 2020/09/20）**

1. 1.75.0'daki birçok hata düzeltildi

**1.75.0（Released at 2020/09/16）**

1. Pomodoro zamanlayıcısı oyunlaştırıldı
2. Özel Görev/liste etiket rengi
3. WebDAV otomatik yedekleme
4. Modülleri gizleme ayarları
5. Çok sayıda iyileştirme ve düzeltme

**1.74.2（Released at 2020/08/23）**

1. Portekizce dil

**1.74.0（Released at 2020/08/13）**

1. ATM: Jeton yatırma ve çekme
2. Mağaza Eşyalarını Görev Ödülü olarak seçme desteği
3. Mağaza Eşyası stok miktarı ayarı
4. Animasyon iyileştirildi ve bazı hatalar düzeltildi
5. Tekrar Sıklığı ayarı için ipucu eklendi
6. Daha fazlası... (açıklama daha sonra güncellenecek)

**1.73.0（Released at 2020/07/26）**

**Özellikler:**

- Kullanıcı Başarımları
- Deneyim Puanı azaltma animasyonu
- Geçmiş kaydının tamamlanma zamanını düzenleme
- Ekip alt Görev jeton ayarı

**İyileştirmeler:**

- Jeton ses efekti eklendi

**Düzeltmeler:**

- Görev tekrarlandıktan sonra alt Görev jeton ayarının kaybolması sorunu

**1.72.1（Released at 2020/06/14）**

**Özellikler:**

- Başarım verilerini temizleme

**İyileştirmeler:**

- Mağaza Eşyası açıklamasının daha iyi görüntülenmesi

**Düzeltmeler:**

- Mağaza Eşyası resimlerini düzenleme sorunu
- Duygular metnini düzenleme sorunu

**1.72.0（Released at 2020/06/11）**

**Özellikler:**

- Alt Görev hatırlatıcısı
- Alt Görev jetonu
- App Widget
  1. Opaklık ayarı
  2. Jeton sayısını gösterme
  3. Sayım Görevi giriş iletişim kutusunu gösterme
- İstatistik sayfası zaman seçimi
- Envanter: Eşya iade
- Ekip için alt Görev desteği

**İyileştirmeler:**

- Sayım Görevinde kaydırma artık tamamlandı olarak işaretlemek yerine 1 tamamlanma ekler
- Çeviriye Yardım Et düğmesi eklendi
- Sayım Görevi için çoklu Deneyim Puanı Ödülü ayarı eklendi

**Düzeltmeler:**

- PNG resmin kırpıldıktan sonra şeffaf kısmının siyah görünmesi düzeltildi.
- App Widget'ın bazı cihazlarda düzgün çalışmaması düzeltildi.
- 0 olarak ayarlandığında ayrıntı sayfasında jeton sayısının gösterilmesi düzeltildi.
- Kaydırarak Bitir (iletişim kutusu olmadan) modunun sayfayı hatalı göstermesi düzeltildi
- Bazı cihazlarda ENTER düğmesine basıldığında alt Görev oluşturulamaması düzeltildi

**1.71.3/1.71.4（Released at 2020/04/16）**

**Simge ve çökme raporuyla ilgili küçük düzeltmeler**

**1.71.2（Released at 2020/04/14）**

**Özellikler:**

- Türkçe dil (çeviriye yardım ettiği için **İbrahim DOĞAN**'a teşekkürler)

- Görev kartı arka planı ve opaklığını özelleştirme
- Envanter Eşyası eylem düğmesi metnini özelleştirme
- Duygular favorileri
- Duygular arama

**İyileştirmeler:**

- Yeni simge

- Rapor türü çoklu dil desteği
- Ayarlar sayfası UI'si iyileştirildi
- Tema rengi ve dil değiştirme yöntemi iyileştirildi. Artık çalışması için uygulamayı yeniden başlatmaya gerek yok.
- Resim kırpma sayfası iyileştirildi
- Liste seçim UI'si iyileştirildi
- Mağaza Eşyası listesi sayfasında Mağaza Eşyası açıklaması gösterimi eklendi

**Düzeltmeler:**

- Başarım kilidi açma tarihinin hatalı gösterilmesi hatası düzeltildi
- Dosya silindiğinde Mağaza Eşyası resminin boş görünmesi hatası düzeltildi.
- Tekil Görev gecikince alt Görevlerin durumu temizlenmiyordu — düzeltildi.
- Görev ayrıntı sayfasında Zorluk Derecesi için yeterli alan olmaması hatası düzeltildi.
- Gecikmiş Görev tamamlandı olarak ayarlandıktan sonra sonraki Görevin tamamlanma sayısının artmaması hatası düzeltildi.
- Görev varsayılan ayarlarında maksimum jeton sayısının hatalı gösterilmesi hatası düzeltildi.
- Veri yedekleme/geri yükleme sayfası kaydırılabilir yapıldı.
- Birden fazla Görevi hızlı kaydırarak tamamlarken kaydırarak tamamlamanın düzgün çalışmaması düzeltildi.
- App widget'ları artık Dondurulmuş durumunu gösterir
- Görev sayfasındaki ilerleme çubuğunun bazen hatalı ilerleme göstermesi hatası düzeltildi

**Sunucu düzeltmeleri（2020/4/13）**

- Rapor işlevinin çalışmaması düzeltildi

**v1.71.1 (Released at 2020/03/17)**

**İyileştirmeler:**

- Görev sayfasında daha iyi ilerleme çubuğu animasyonu

**Düzeltmeler:**

- Bazı cihazlarda uygulama başlatılırken çökmeye yol açabilecek hata düzeltildi
- Fotoğraf seçmeyle ilgili hata düzeltildi

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Özellikler:**

- Duygular işlevi

- Kaydırma eylemi eklendi: Görevi Bitir (İletişim Kutusu Yok)

**Düzeltmeler:**

- Görev kartı durumunun hatalı gösterilmesi hatası düzeltildi

- Geri alınan Görevin gecikince kaybolması hatası düzeltildi

- Seçili sıralamanın hatalı gösterilmesi düzeltildi

**v1.70.6 (Released at 2020/03/09)**

**İyileştirmeler:**

- Başarım kilidi açıldı ipucunun renkleri tema rengiyle aynı yapıldı

**Düzeltmeler:**

- Düğmeye tıklandıktan sonra gecikme iletişim kutusu durumunun hatalı gösterilmemesi düzeltildi

- COPY'nin alt Görevleri kopyalamaması hatası düzeltildi
- "Taşı..." kullanılırken oluşan çökme düzeltildi
- Seçim kartının bazı cihazlarda hatalı gösterilmesi düzeltildi

**v1.70.5 (Released at 2020/03/06)**

**Düzeltmeler:**

- Tema rengi değiştirilirken veya karanlık mod açılıp kapatılırken Yapılacaklar kartının sürekli yüklenmesi düzeltildi

**v1.70.4 (Released at 2020/03/05)**

**İyileştirmeler:**

- Mağaza sayfası Eşya yokken jeton sayısını gösterir
- Mağaza sayfasındaki jeton sayısına tıklayarak Jeton ayrıntı sayfasına erişilebilir
- App widget'ında İngilizce metin biçimi iyileştirildi
- App Widget'taki Göreve tıklayarak Görev ayrıntı sayfasına erişilebilir

**Düzeltmeler:**

- Ekip etkinliğinin hatalı görüntü stili

**v1.70.3 (Released at 2020/03/05)**

**İyileştirmeler:**

- Mağaza sayfası artık Eşya yokken jeton sayısını gösterir
- Mağaza sayfasındaki jeton sayısına tıklayarak Jeton ayrıntı sayfasına girilir
- App Widget'ta İngilizce metin biçimi iyileştirildi
- App Widget öğesine tıklayarak Görev ayrıntı sayfasına girilir

**Düzeltmeler:**

- Bugün filtrelendiğinde Görev tamamlandıktan sonra alt bilgi "xx Görev henüz başlamadı"nın gösterilmemesi düzeltildi

**v1.70.3 (Released at 2020/03/05)**

**Önemli düzeltmeler:**

- Jeton sayısı girişiyle ilgili hatalar düzeltildi
- Alt Görevlerin doğru yenilenmemesiyle ilgili hatalar düzeltildi
- Başkalarının etkinliğini beğenememe hataları düzeltildi
- App Widget'ın Görevleri tamamlayamaması hataları düzeltildi

**v1.70.2 (Released at 2020/03/04)**

**Özellikler:**

- Topluluk artık tüm saat dilimlerinde kullanılabilir

- Görevleri kopyalama
- Yeni Görev varsayılan ayarlarını düzenleme desteği
- Mağaza listesi

- App Widget eylemleri iyileştirildi
- Takvim sayfasında sona eren Görevler için menü eklendi

**İyileştirmeler:**

- Görev kartı animasyonları iyileştirildi

- Gereksiz bir izin kaldırıldı
- Tamamlama sesi eklendi
- Geçmiş sayfası UI stili iyileştirildi
- Sistem takvimi hatırlatıcısı etkinleştirilirken izin verilmemişse "Takvim Yazma/Okuma İzni Kayboldu" iletişim kutusu eklendi

**Düzeltmeler:**

- Kompakt modda Sayım Görevi hataları düzeltildi
- Tekrarlayan Görev hataları düzeltildi
- Alt Görevler silinirken oluşabilecek çökme düzeltildi
- Hatalı WebDAV URL'si girildiğinde oluşan çökme düzeltildi
- Yedek geri yüklendikten sonra oluşabilecek hatalı tema rengi gösterimi düzeltildi


### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**🚀Özellikler**

1. Arşiv yönetimi desteği

- Bilgisayara yedekleme
- Bilgisayardan geri yükleme
- Sürükle-bırak desteği

2. Yeni Duygular oluşturma desteği

- Görsel seçimi desteği
- Görselleri mobile senkronize etme desteği

3. Görev ayrıntı görünümü desteği
4. Satın alma sistemi iyileştirmeleri

- Yeni "Purchase Items" API'sini kullanma
- Satın alma limitlerini App ile tutarlı tutma

5. İsteğe bağlı API Token doğrulaması desteği
6. Çoklu platform desteği

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Hata işleme ve bildirimler iyileştirildi

**v1.1.1 (2023/08/29)**

**🔧Optimizasyon ve hata düzeltmeleri**

1. Jeton sayısı girildiğinde beklenmeyen davranış düzeltildi
2. Güncelleme kontrolünün App'in çökmesine neden olabileceği sorun düzeltildi

**v1.1.0 (2023/06/25)**

**🚀Özellikler**

1. "LifeUp Cloud" IP adresi ve bağlantısının otomatik kontrolü desteği (LifeUp Cloud v1.3.0 gerekir)
2. Görev ekleme desteği, ancak şu anda desteklenen seçenekler sınırlı ([#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6) düzeltildi)
3. Duyguları markdown formatında dışa aktarma desteği ([#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5) düzeltildi)
4. Geleneksel Çince dil metni eklendi
5. macOS sürümü eklendi
6. Güncelleme kontrolü desteği

**🔧Optimizasyon ve hata düzeltmeleri**

1. Başarım alt kategorilerinin doğru görüntülenememesi sorunu düzeltildi
2. Bazı simgelerin doğru görüntülenememesi sorunu düzeltildi (LifeUp v1.91.3 sürümü gerekir)
3. Başlık uyuşmazlığı sorunu düzeltildi ([#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8) düzeltildi)
4. Windows yükleyicisi için kısayol seçeneği eklendi ([#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13) düzeltildi)
5. Pencere boyutu alma yöntemi iyileştirildi, 1080p'den düşük çözünürlüklere uyarlandı

**v1.0.2 (2023/02/20)**

1. Daha ayrıntılı hata raporu açılır penceresi eklendi [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Paketleme yapılandırması iyileştirildi

**v1.0.1 (2023/02/12)**

1. İlk sürüm

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**🚀 Özellikler**

1. SDK veri modeli ve HTTP API yanıtlarında alt Görev tamamlama zamanı (`endTime`) gösterildi.

**v2.1.0 (2026/03/22)**

**🚀 Özellikler**

1. Yerel ayar yapılandırması desteği ve Top-14 yerelleştirme güncellemeleri eklendi.
2. API Görevleri için sayım ilerlemesi ve tekrar bitiş koşulu alanları gösterildi.

**🐛 Hata Düzeltmeleri**

1. ContentProvider uyumluluk sorunları düzeltildi.
2. Android 15 UI ve hizmet başlatma davranışına uyarlandı.

**v2.0.0 (2025/01/01)**

**🚀Özellikler**

1. Hizmet optimizasyonu

- Hizmet keşif mantığı ve uyumluluğu geliştirildi
- Daha fazla cihaz otomatik IP algılamayı destekler
- Hizmet başlat/duraklat durum geçişleri optimize edildi
- Hata işleme ve bildirimler iyileştirildi

2. Güvenlik ve performans

- İsteğe bağlı API Token doğrulaması eklendi
- CORS yapılandırma seçenekleri eklendi
- Özel port ayarları desteği
- Özel wake lock süresi desteği

3. UI iyileştirmesi

- Yepyeni arayüz tasarımı
- Genel görsel deneyim iyileştirildi

**v1.3.0 (2023/06/25)**

**🚀Özellikler**

1. Masaüstünün IP'sini otomatik keşfedebilmesi için mDNS hizmeti kaydı desteği (masaüstü v1.1.0 gerekir)
2. ContentProvider aracılığıyla çağrılan API'ler için sonuç değerleri eklendi.

**🔧İyileştirmeler**

1. QR kod tarama düğmesinin tıklama alanı genişletildi
2. ActivityNotFound çökmesi düzeltildi

**v1.2.0 (2023/03/10)**

1. API çağırmak için QR kod tarama desteği
2. IP listesi görüntüleme iyileştirildi

**v1.1.2 (2023/02/12)**

1. Masaüstü işlevlerini desteklemek için Content Provider aracılığıyla tam veri sorgulama desteği
2. HTTP yanıt içeriği standartlaştırıldı

**v1.0.3-preview (2022/11/22)**

1. İlk sürüm (artı bazı ilk sürüm hata düzeltmeleri)

<!-- tabs:end -->

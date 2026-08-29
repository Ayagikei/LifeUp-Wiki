# *LifeUp* App Gizlilik Şartları ve Politikası

?> Aşağıdaki uygulama sunucusu açıklaması Lite sürümü için geçerli değildir. Lite sürümünün uygulama sunucusuyla herhangi bir etkileşimi yoktur.

LifeUp hayatınızı iyileştirmenize yardımcı olan bir App'tir. Gizliliğinize saygı duyuyoruz ve kişisel bilgilerinizi korumayı taahhüt ediyoruz. Bu gizlilik politikası, App'imizi kullandığınızda kişisel bilgilerinizi nasıl topladığımızı, kullandığımızı, paylaştığımızı ve sildiğimizi açıklar.

### 1. Kişisel Bilgiler

LifeUp çevrimdışı öncelikli bir App'tir. Adınız, e-posta adresiniz gibi kullanıcı verilerini aktif olarak toplamıyoruz. Dünya modülüne erişmek için oturum açmayı yetkilendirmek, Google Drive veya Dropbox'ı yetkilendirerek bulut yedekleme yetenekleri elde etmek vb. için isteğe bağlı olarak bazı veriler sağlayabilirsiniz.

Yalnızca analitik amaçlarla sorun raporları ve performans verileri toplamak için Google Firebase ve Sentry kullanıyoruz.

İşte bazı veri özetleri:

- **Takma Ad, Avatar, Cinsiyet**
  İsteğe bağlı; "Dünya" modülüne erişmek için oturum açma işlevi için kullanılır, depolama için sunucuya aktarılır ancak değiştirilebilir ve silinebilir
- **E-posta**
  İsteğe bağlı; Google Drive senkronizasyonu için, yerel depolama, sunucuya iletilmez
- **WebDAV URL'si, Hesap ve Parola**
  İsteğe bağlı; WebDAV senkronizasyonu için, yerel şifreli depolama, sunucuya iletilmez
- **Çökme bilgisi, performans verileri**
  Sorun ve performans analizi için hizmet sağlayıcılara (Google Firebase, Sentry) iletilir, ancak kullanıcı veya cihaz tanımlayıcılarına asla bağlanmaz ve kullanıcı verisi içermez

Her işlev için ayrıntılı veri toplama ve işleme yöntemleri aşağıda gösterilmiştir.

#### 1.1 Kullanıcı bilgileri (üçüncü taraf yetkilendirmesi)

##### Google/Facebook ile Giriş

**Yalnızca oturum açma yetkilendirmesini onayladıktan sonra** yetkilendirdiğiniz takma ad ve profil fotoğrafıyla (e-posta hesapları gibi bilgileri içermez) bir hesap oluştururuz.

##### Google Drive

Google Drive yedeklemeleri e-posta adreslerine bağlı olduğundan, Google Drive'ı yetkilendirdiğinizde *LifeUp* e-posta adresi izni ister. **Ancak bu adres yalnızca yerel olarak kullanılır; *LifeUp* bunu uygulama sunucusuna iletmez ve depolamaz.**

Ve *LifeUp* yalnızca uygulamaya özel depolama izni ister; yani özel dosyalarınıza erişim iznimiz yoktur.

##### Dropbox

Dropbox'ı yetkilendirdikten sonra **ilgili bilgiler yalnızca yedekleme için cihazınızda tutulur ve uygulama sunucusuna iletilmez.**

Ve *LifeUp* yalnızca **uygulamaya özel depolama izni ister; yani özel dosyalarınıza erişim iznimiz yoktur.**

##### WebDAV Sunucusu

**WebDAV URL'niz, hesabınız ve parola bilgileriniz yalnızca yerel olarak saklanır ve uygulama sunucusuna gönderilmez.** Parola veritabanında şifreli olarak saklanır.

##### Çevrimdışı Mod

***LifeUp* çevrimdışı modda da tamamen kullanılabilir; yalnızca "Dünya" modülüne erişemez.**

Çevrimdışı modda **uygulama sunucumuza herhangi bir bilgi göndermeniz gerekmez.**
**Takma adınız, avatarınız ve diğer bilgileriniz yerel olarak saklanır ve kullanılabilir.**

Yalnızca en son duyurular ve güncellemeler için uygulama sunucusundan istekte bulunabiliriz; bunlar bilgi gönderimini içermez.

Dropbox, Google Drive, Facebook gibi diğer SDK'larla etkileşimleriniz. Bu istekler sizin aktif kullanımınız altında normal şekilde yanıt verir.

Çevrimdışı kullanımda yine de Google Firebase, Sentry ile çökme ve sorun raporları toplayabiliriz; ancak aşağıda açıklandığı gibi **bu bilgiler kullanıcı verisi içermez ve kullanıcı bilgilerine bağlanmaz. Yalnızca performans analizi ve çökme çözümü için ve yalnızca geçici olarak saklanır.**

Google Play'in isteğine göre lisansınızı doğrulamak için Google Play Services ile de iletişim kurabiliriz.

Yukarıdaki tüm iletişimi reddetmek isterseniz LifeUp'ın ağ isteği iznini doğrudan devre dışı bırakabilirsiniz. Bu, LifeUp'ın kendisinin kullanımını etkilemez; ancak Google Drive gibi SDK'ların işlevselliğini etkileyebilir.


#### 1.2 İzinler

#### Depolama

Uygulama **depolama alanı okuma izni istemez**, dolayısıyla sizin yetkilendirmediğiniz dosyaları okumaz.

Uygulama, kullanıcının görsel ekleri, avatar yükleme ve diğer işlevleri kullanmasını kolaylaştırmak için kamera izni istemiştir ve **yalnızca kullanıcı izin verdikten sonra kamerayı çağırabilir.**

Örneğin, ekli bir görsel seçtiğinizde erişmek için doğrudan sistemin dosya depolama çerçevesini çağırırız.

Yalnızca seçtiğiniz tek dosyayı yetkilendirirsiniz; diğer dosyaları okuma iznimiz olmaz.

Aynı zamanda, Dünya modülü dışında dosyaları aktif olarak paylaşmadığınız sürece yalnızca yerel olarak saklanır ve sunucudan geçmez.

#### Ağ

Ağ erişimi izni "DÜNYA" modülüne erişim, yetkilendirilmiş oturum açma ve isteğe bağlı Dropbox/WebDAV senkronizasyonu ve diğer işlevler içindir.

#### Takvim

Uygulama ayrıca sizi hatırlatmak için sistem takvim uygulamasına etkinlik yazma işlevi sunar.

**Bu işlev takvim okuma ve yazma izinleri gerektirir ve bu izin yalnızca kullanıcı ilgili işlevi kullandığında yetkilendirme ister. Ve *LifeUp* yalnızca uygulamanın kendisinin yazdığı etkinlikleri okur.**

#### 1.3 Veri Depolama

**Uygulama çevrimdışı öncelikli bir uygulamadır ve yerleşik çevrimiçi senkronizasyon işlevi yoktur; bu nedenle verilerin büyük çoğunluğu kullanıcının cep telefonunda yerel olarak saklanır.**

Örneğin, oluşturduğunuz tüm yerel Görevler, kaydettiğiniz tüm Duygular, tasarladığınız Başarımlar ve Mağaza Eşyaları.

**Yalnızca "Dünya" modülünde aktif olarak herkese açık paylaştığınız içerik sunucuda saklanır.
Ve bu içeriklerin tümü silme ve yok etme işlemlerini destekler.**

Örneğin, "Dünya" modülünde oluşturduğunuz ekip, ekip Görevlerini tamamladıktan sonra yayınladığınız etkinlikler, aktif olarak paylaşılan Mağaza Eşyaları vb.

Aynı zamanda uygulama içindeki isteklerin büyük çoğunluğu şifreli biçimde iletilir.

#### 1.4 Performans verileri ve çökme raporları

Sorunları izlemek ve düzeltmek için kullanıcı performans verileri ve çökme raporları toplamak amacıyla [Google Firebase](https://firebase.google.com/) ve [Sentry](https://sentry.io/) kullanıyoruz.

Bu performans verileri cihaz modelinizi, ağ durumunuzu, örnek kimliğinizi, sorunun ne zaman oluştuğunu ve ilgili sayfaları içerebilir; **ancak bu veriler kullanıcı verilerinizle ilişkilendirilmez** (takma adınızı, kullanıcı kimliğinizi, e-posta adresinizi ve herhangi bir iletişim bilgisini içermez ve girdiğiniz ve oluşturduğunuz içeriği toplamaz) ve yalnızca sorunu analiz etmek ve performansı iyileştirmek için kullanılır.

Ve bu veriler yalnızca Firebase ve Sentry tarafından belirli bir süre geçici olarak saklanır; **ve biz bunu üçüncü taraflarla paylaşmayız / satmayız / kiralamayız.**

#### 1.5 *LifeUp Lite* için Veri Silme Talebi

##### 1. Veri Depolama ve Silme

LifeUp Lite, LifeUp'ın ücretsiz sürümüdür ve verileri öncelikle kullanıcının cihazında saklar. Gizliliğinize ve özerkliğinize değer veriyoruz. LifeUp Lite'da kullanıcı hesapları oluşturulmadığından tüm kişisel veriler cihazınızda yerel olarak saklanır.

**Bu verileri silmek için LifeUp Lite uygulamasını cihazınızdan kaldırmanız yeterlidir. Kaldırma işlemiyle yerel olarak saklanan tüm veriler kalıcı olarak silinir.**

##### 2. Üçüncü Taraf Hizmetler

LifeUp Lite, işlevsellik ve reklam amaçlarıyla Firebase ve Admob gibi üçüncü taraf hizmetlerle entegre olur. Bu hizmetlerin topladığı veriler kimliğinizle bağlantılı kişisel bilgileri içermez ve ilgili gizlilik politikalarına uygun olarak kullanılır. Bu veriler, söz konusu hizmetlerin politikalarına göre belirli bir süre sonra otomatik olarak silinir.

##### 3. Veri Silme Konusunda Yardım

Veri silme konusunda yardıma ihtiyacınız varsa veya sorularınız varsa lifeup@ulives.io adresinden bizimle iletişime geçebilirsiniz. Ekibimiz veri gizliliğinizle ilgili soru ve endişelerinizde size yardımcı olmaya kararlıdır ve gerekirse süreç boyunca rehberlik eder.

##### 4. Uyumluluk ve Güncellemeler

En son düzenlemelere ve sektör standartlarına uyumu sağlamak için uygulamalarımızı sürekli gözden geçirir ve güncelleriz. Gizlilik Politikasının bu bölümü, veri yönetimi ve silme süreçlerindeki değişiklikleri yansıtmak için gerektiğinde güncellenecektir.


#### 1.6 *LifeUp Pro* için Veri Silme Talebi

##### 1. LifeUp Pro'da Veri Silme

LifeUp Pro kullanıcıları App içinde verilerini bağımsız olarak silebilir.

LifeUp Pro öncelikle çevrimdışı bir uygulama olduğundan verilerinizi doğrudan cihazınızda yönetebilirsiniz.

Verilerinizi silmek için şu adımları izleyin:

1. LifeUp Pro App'inde 'Ayarlar - Veri Yedekleme/Geri Yükleme/Temizleme' sayfasına gidin.
2. Görevler, Eşya Ödülleri, yerel düşünceler ve çevrimdışı mod verileri gibi silmek istediğiniz belirli verileri seçin.
3. Seçili verileri kalıcı olarak silmek için işleminizi onaylayın.

**Alternatif olarak, LifeUp Pro App'ini cihazınızdan kaldırmak da yerel olarak saklanan tüm verilerin silinmesine yol açar.**



##### 2. LifeUp Pro'da Hesap Silme

LifeUp Pro'da hesabınızı silmek, veri silmeden ayrı bir süreçtir.

Hesabınızı sildiğinizde şunlar kaldırılır:

- Sunucularımızda yayınlanan ekipler ve güncellemeler gibi herkese açık gönderileriniz.
- Hesabınızla ilişkili takma adınız ve diğer kişisel bilgileriniz.
- Hesabınıza bağlı OAuth ilişkilendirmeleri.

**LifeUp Pro hesabınızı silmek için daha önce belirtilen adımları izleyin:**

1. 'Ayarlar - Veri Yedekleme/Geri Yükleme/Temizleme' sayfasına gidin.
2. Sayfanın altındaki 'Hesabı Sil' düğmesine dokunun.
3. Hesabınızı ve ilişkili tüm bilgileri kalıcı olarak silmek için işleminizi onaylayın.

<br/>

**LifeUp Pro App'ini artık kullanmıyorsanız ancak hesabınızı ve kişisel verilerinizi silmek istiyorsanız lütfen [lifeup@ulives.io](mailto:lifeup@ulives.io) adresinden bizimle iletişime geçin.**

Hesabınızla ilgili gerekli ayrıntıları bize iletin; ekibimiz silme sürecinde size yardımcı olacaktır.

Gizliliğinizi sağlamaya kararlıyız ve talebinizi en büyük özen ve gizlilikle ele alacağız.



##### 3. Üçüncü Taraf Hizmetler

LifeUp Lite'a benzer şekilde LifeUp Pro, gelişmiş işlevsellik için Firebase gibi üçüncü taraf hizmetlerle entegre olur. Bu hizmetlerin topladığı veriler kişisel olarak tanımlanabilir değildir ve gizlilik politikalarına uygun olarak yönetilir. Bu veriler, üçüncü taraf hizmet politikalarına göre belirli bir süre sonra otomatik silinmek üzere planlanır.



##### 4. Güncellemeler ve Uyumluluk

En son gizlilik yasalarına ve sektör standartlarına uyum sağlamak için uygulamalarımızı sürekli izler ve güncelleriz. Gizlilik Politikasının bu bölümü, LifeUp Pro kullanıcıları için veri yönetimi ve silme süreçlerimizi doğru yansıtmak amacıyla gerektiğinde değiştirilecektir.


### 2. Sözleşme

Bu uygulamayı kullanarak bu gizlilik politikasının şartlarını kabul etmiş olursunuz.

Kendi verilerinizden siz sorumlusunuz.

Bu çevrimdışı öncelikli bir uygulama olduğundan, bu App'in kullanımından kaynaklanan veya bununla bağlantılı herhangi bir veri kaybından hiçbir şekilde sorumlu değiliz.

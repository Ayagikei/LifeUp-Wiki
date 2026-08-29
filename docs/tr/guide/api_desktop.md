<h1 align="center" padding="100">Yerel Ağ (API) Masaüstü İstemcisi 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

LifeUp API'lerine dayalı hafif bir masaüstü istemcisi geliştirdik. Windows, Linux ve macOS desteklenir.

**Bağımsız bir App değildir.** API erişimiyle telefonunuzdaki LifeUp çevrimdışı verilerini okur.

<br/>

## İşlevler

> [!NOTE]
> Mevcut sürüm esas olarak API yeteneklerinin teknik önizlemesidir. Temel gezinme işlemlerine odaklanır ve App içindeki her özelliği kapsamaz.

- Tamamen açık kaynak. Arayüzü özelleştirebilir ve kendi özelliklerinizi uygulayabilirsiniz.
- Mevcut temel yetenekler:
  - Görev listesini sorgulama ve Görevleri tamamlama
  - Özellik listesini ve Seviyeleri sorgulama
  - Eşya listesini sorgulama ve Eşya satın alma
  - Duyguları sorgulama ve masaüstünde tam boyutlu görselleri görüntüleme
  - Duyguları Markdown dosyalarına dışa aktarma
  - Görev ekleme (App içindeki tüm seçenekler henüz kapsanmıyor)

<br/>

## İndirme

Tüm masaüstü paketleri [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) üzerinde yayınlanır.

> [!WARNING]
> Masaüstünü kullanmadan önce LifeUp Cloud'un v2.0.0 veya üzeri olduğundan emin olun.<br/>
> GitHub Releases derlemesini kullanıyorsanız LifeUp Cloud'u `Settings` → `Labs` altında güncelleyin.<br/>
> Google Play derlemesini kullanıyorsanız [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) veya [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest) üzerinden güncelleyebilirsiniz.<br/>
> Bazı tarayıcılar güvenlik politikası nedeniyle yükleyici indirmelerini engelleyebilir. **Sakla/İzin ver** (tarayıcıya göre ifade değişir) seçin veya başka bir indirici kullanın.

### Kurulum platformları

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> MSI şu anda EV imzalı değil; Windows «tanınmayan App» uyarısı gösterebilir.<br/>
> Dosyanın resmi GitHub release'inden geldiğini doğruladıktan sonra **Daha fazla bilgi → Yine de çalıştır**'a tıklayın.

#### **Linux**

- [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) üzerinden `lifeup-desktop.deb` indirip kullanın.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- macOS derlemeleri henüz tam test edilmedi; **Auto Connect** gibi bazı özellikler kullanılamayabilir.

> [!TIP]
> **macOS Gatekeeper / imza**<br/>
> Mevcut macOS derlemeleri notarize edilmemiştir. «Tanınmayan geliştirici» uyarısı görebilirsiniz.<br/>
> `.dmg`'yi açıp App'i Applications'a taşıyabilir, ardından App'e sağ tıklayıp **Aç**'ı seçebilirsiniz,<br/>
> veya **System Settings → Privacy & Security** altında **Open Anyway**'e tıklayın.<br/>
> Ayrıntılar için [Apple resmi kılavuzuna](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) bakın.

<!-- tabs:end -->

Paket geçici olarak eksikse daha sonra yenileyin. Release varlıkları hâlâ yükleniyor olabilir.

<br/>

## Nasıl kullanılır

### İlk kurulum

#### Ön koşullar

- Telefonunuz ve masaüstü aynı LAN'da olmalıdır (örneğin aynı Wi-Fi).
- <del>Ağınız karmaşıksa önce masaüstünün telefon IP'sine ping atıp atamadığını test edin.</del>
  - Yeni masaüstü sürümleri otomatik telefon IP algılamasını destekler; bu adım genellikle gerekmez.

#### Telefonda

1. LifeUp'ı en son sürüme güncelleyin.
2. LifeUp'ta `Settings` → `Labs` açın, ardından **LifeUp Cloud**'u kurun.
3. LifeUp Cloud'u açın ve gerekli izinleri verin:
   - Yüzen pencere / diğer App'lerin üzerinde gösterme izni
   - LifeUp veri okuma izni
4. LifeUp Cloud'da **Start Service**'e dokunun.

**Önerilen ek kurulum**

- LifeUp ve LifeUp Cloud için uyumluluk yapılandırması yapın ve arka planda sonlandırma sorunlarını azaltmak için pil optimizasyonunu devre dışı bırakın.
- MIUI (Xiaomi/Redmi) kullanıyorsanız her iki App için de **Display UI in background** iznini verin.
- LifeUp ve LifeUp Cloud'u çalışır durumda tutun.

#### Masaüstünde

1. Release paketinden masaüstü App'ini kurun.
2. Masaüstü ayarlarında LifeUp Cloud'da gösterilen hizmet IP'sini girin.
   - Masaüstü v1.1.0+'da **Auto Connect** deneyebilirsiniz.
3. Her şey doğru yapılandırıldıysa masaüstünde LifeUp verilerini görebilmelisiniz.
   - Başarısız olursa yukarıdaki ek kurulumu tekrar gözden geçirin.

### Sonraki kullanımlar

1. Telefonda LifeUp ve LifeUp Cloud'u açın.
2. LifeUp Cloud'da **Start Service**'e dokunun.
3. Masaüstü istemcisini başlatın.

<br/>

## SSS

<details>
<summary>Masaüstünden Görev ekleyebilir miyim?</summary>

Evet. Mevcut masaüstü derlemesi temel Görev oluşturmayı destekler.

Ancak App içindeki gelişmiş Görev seçeneklerinin tümü henüz masaüstünde yok. Karmaşık yapılandırmalar için mobil App'i kullanın veya LifeUp Cloud üzerinden API çağırın.

</details>

<details>
<summary>LifeUp Cloud'da «Request LifeUp Permission»'a tıkladım ama hiçbir şey olmadı / API not found.</summary>

1. Hiçbir şey olmazsa izni zaten vermiş olabilirsiniz.
2. API not found görünürse üye betasına katılın ve LifeUp'ı en son beta sürümüne güncelleyin.

</details>

<details>
<summary>Telefon bir süre kilitli kaldıktan sonra masaüstü artık veri okuyamıyor.</summary>

LifeUp ve LifeUp Cloud için uyumluluk yapılandırması yapın.

</details>

<details>
<summary>LifeUp ve LifeUp Cloud arka plandayken bazı API'ler çalışmıyor.</summary>

> Bu genellikle temel masaüstü kullanımını etkilemez, ancak özel API çağrılarını etkileyebilir.

LifeUp Cloud'un yüzen pencere/diğer App'lerin üzerinde gösterme izni olduğundan emin olun.

MIUI (Xiaomi/Redmi) kullanıyorsanız her iki App için de **Display UI in background** iznini de etkinleştirin.

</details>

<details>
<summary>Windows kurulumu `Failed to launch JVM` ile başarısız oluyor.</summary>

Referans: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Bu genellikle yerel JVM erişilebilirlik yapılandırmasıyla ilgilidir.

Yaygın geçici çözüm, `~/.accessibility.properties` içinde şu satırları yorum satırı yapmak:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Düzenledikten sonra App'i yeniden başlatıp tekrar test edin.

> `~` kullanıcı ana dizininizi ifade eder.

</details>

<br/>

## Katkı

SDK, LifeUp Cloud ve LifeUp Desktop açık kaynaktır.

Kaynak kodu:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

<h1 align="center" padding="100">Açık arayüz</h1>

<p align="center">Sonsuz olasılıklar yaratın!</p>

?> v1.90 sürümünde `LifeUp`, çeşitli işlev arayüzlerini açtı; harici uygulama entegrasyonlarına açıktır. <br/>Mağaza eşyaları için "URL" efektini de sunar; kullanıcılar eşyaları doğrudan harici uygulamaları veya `LifeUp` arayüzünü çağırmak için kullanabilir. <br/>Bu özellikler `LifeUp`'ınıza sınırsız olasılıklar kazandırır; ancak biraz öğrenme, anlama ve uygulama pratiği gerektirir.

**Son güncelleme: 2026/08/28**

Bu belgedeki API parametreleri ve tanımları **v1.106.0** sürümüne dayanır.

En yeni API'yi kullanmadan önce uygulamanızın **v1.106.0** sürümüne güncellendiğinden emin olun.

Güncelleme Google Play üzerinden kademeli olarak yayınlanmaktadır; henüz almadıysanız lütfen bekleyin — yakında gelecektir.

## Senaryo örneği

| Çağıran | Senaryo | Notlar |
| ------ | -------- | ----- |
|**LifeUp→Diğer Uygulamalar**<br/>Mağaza eşyasının "URL" efektiyle uygulanır| **Mağaza eşyasını kullandıktan sonra:**<br/>1. Tarayıcıyla bir web sayfasını ziyaret etme<br/>2. WeChat'e geçip tarama yapma veya belirli bir mini program belirtme<br/>3. Muhasebe kayıtlarını otomatik ekleme ([örneğin "Qianji" muhasebe arayüzünü destekler](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Tasker otomasyon aracı yapılandırmasını saklama (Market'te paylaşılabilir) ve kullanımdan sonra yapılandırmayı Tasker'a otomatik içe aktarma<br/>5. Tasker'ı tetikleyerek duvar kağıdını değiştirme<br/>6. ... (harici uygulama bu çağrı yöntemini desteklediği sürece) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) bir otomasyon aracıdır ve yapılandırmayı Uri olarak dışa aktarmayı destekler |
|**LifeUp→LifeUp**<br/>Mağaza eşyasının "URL" efektiyle uygulanır| **Mağaza eşyasını kullandıktan sonra:**<br/>1. Belirli bir sayfayı açma<br/>2. ATM faiz oranını artırma<br/>3. Kullanıcının ürün seçmesine ve fiyatın düşürülmesine izin veren açılır pencere (indirim kuponu)<br/>4. Bir Görevi tamamlamayı tetikleme<br/>5. Özel motivasyon mesajı gösterme<br/>6. Görev Ödül şablonu oluşturma: yalnızca adı girerek otomatik Görev oluşturma<br/>7. Kullanıcıdan dal seçimi isteyen açılır pencere — küçük bir bağlamsal etkileşim<br/>8. Daha fazla uygulama içi işlem... |  |
|**Harici uygulamalar/web sayfaları→LifeUp** | **Otomasyon araçlarını yapılandırma:**<br/>1. Telefonun her gün ilk açıldığı anı belirleyerek erken kalkma Görevini tamamlama veya doğrudan "geç kalkma" cezasını tetikleme<br/>2. Her 25 kelimede belirli bir NFC kartını okutarak Görevi otomatik tamamlama<br/>3. GPS ile yeni bir yere ulaşıldığını belirleyerek "yeni yer" Başarımının kilidini açma<br/>4. Her gün iş Wi-Fi'sine bağlanıldığında kilidi açma koşulu ilerlemesini artırma; 20 gün birikince "Worker" Başarımının kilidini açma<br/>5. Her gün ev Wi-Fi'sine ilk bağlanıldığında "eve varış" jetonu Ödülü alma<br/>6. Diğer Pomodoro veya Odak uygulamalarından bildirimleri yakalayıp zamanlamayı otomatik olarak `LifeUp`'a kaydetme<br/>7. Spor ve öğrenme yazılımlarının tamamlanma veya bitiş bildirimlerini yakalayıp otomatik olarak "strength" ve "knowledge" Deneyim Puanı verme<br/>8. Kendinizin belirlediği zaman aralığında telefonu her açtığınızda ceza tetikleme<br/>9. ...<br/>**Harici uygulama bağlantısı/kendi geliştirdiğiniz uygulama:**<br/>1. `LifeUp` Pomodoro'sundan memnun değilseniz: kendi zamanlama yazılımınızı geliştirebilirsiniz (web veya Android uygulaması) ve arayüz üzerinden "LifeUp" ile bağlayarak zamanlama kaydı veya Ödül ekleyebilirsiniz<br/>2. Bazı zeka mini oyunlarını (aşağıdaki Wordle örneği gibi) değiştirme. Oyun başarıyla tamamlandığında `LifeUp`'ın Ödül göndermesini tetikleme<br/>3. ... |  |

<br/>Başka bir deyişle, yukarıdaki tüm senaryolar aslında "eylem"leri tetikleyen "olay"lardır.

Bu `LifeUp` güncellemesi "eşya kullanımı" olay tetik noktasını ve ardından çeşitli "eylemleri" (Ödüller, Görev tamamlama vb.) sunar.

Şu tür olaylar için

- Web düğmesine tıklama
- NFC kart okutma
- Her gün uyandıktan sonra ekranın ilk kilidini açma

harici uygulamaların müdahalesi gerekir. Örneğin kendiniz ikinci geliştirme yapın veya `Tasker` ve `MacroDroid` gibi otomasyon araçlarını kullanın.

**LifeUp 1.90.2 güncellemesi bir dizi "olay" ekleyecek; bu olaylar otomasyon araçları veya harici uygulamalar tarafından alınabilir.**

Şunları gerçekleştirmek için kullanılabilir:

Eşyayı kullandıktan sonra Tasker gibi otomasyon araçlarını tetikleyerek launcher duvar kağıdını değiştirme.

Görevi tamamladıktan sonra Tasker gibi bir otomasyon aracını tetikleyerek bir uygulama açma.

**1.90.2 sürümünde "LifeUp olayı"nın "Tasker işlemi"ni tetiklemesi mümkündür.**

Tasker'ın duvar kağıdı değiştirme, uygulama kaldırma, ses seviyesini artırma, belirli uygulamaları açma ve daha fazlası gibi çok geniş izinleri vardır. Programlama bilgisi olmadan bile UI etkileşim mantığı yazabilirsiniz.

---

## Öneriler

**Programlamaya aşina değilseniz,** [World] - [Market] - [Link]/[API]/[Automate] etiketlerinde özel Mağaza eşyalarını doğrudan arayıp içe aktarabilirsiniz. İhtiyaçlarınıza uyması için parametreleri düzenlemeyi de deneyebilirsiniz.

**Bilgisayar bilgisine aşina iseniz,** aşağıdaki arayüz belgelerini okuyup istediğiniz efekti kendiniz düzenlemeyi deneyin. [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm) gibi otomasyon yazılımlarıyla birlikte kullanın. Tasker yapılandırmasını düzenlemeseniz bile Tasker'ı başarıyla kurduğunuz sürece Market veya diğer topluluklarda paylaşılan otomasyon yapılandırmalarını içe aktarabilirsiniz.

**Programlama temeliniz varsa,** LifeUp ile entegre web sayfaları veya Android uygulamaları geliştirmeyi deneyin. Bu wiki sayfası ve özelleştirilmiş Wordle sürümleri örneklerdendir. Otomasyon aracı yapılandırmaları oluşturup paylaşmanız da memnuniyetle karşılanır.

---

## Başka uygulama çağırma

*LifeUp* içinde harici bir uygulama çağırmak istiyorsanız, Mağaza eşyasına bir "Link" efekti eklemeniz, **bir web sayfası veya uygulamaya özel bağlantı girmeniz** ve ardından Mağaza eşyasını kullanarak çağrıyı tetiklemeniz yeterlidir.

**Aşağıda bazı örnekler var ("World"-"Market"-"Link" bölümünde arayüz çağrı efektli herkese açık eşyalara da bakabilirsiniz):**

- Tarayıcı Google'ı açar: https://www.google.com
- Facebook: [fb://](fb://)
- Paket adı/uygulama kimliğiyle uygulama açma: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

Teorik olarak harici uygulama URL sağladığı sürece Mağaza eşyasını kullanarak yönlenebilirsiniz.

**İhtiyacınız olan uygulama bağlantısını Google'da `URL Schemes` arayarak bulabilirsiniz.**

**Bu bağlantıların `LifeUp` ile ilgisi yoktur; `LifeUp` yalnızca URL yönlendirme işlevini sağlar.**

**Bu nedenle URL listesi tutmuyor ve bakımını yapmıyoruz. Ancak [World]-[Market]-[Link] sayfasında bağlantı efektli herkese açık Mağaza eşyalarını görebilirsiniz.**

Bir uygulamanın paket adını (kimliğini) şu yollarla bulabilirsiniz:

- Google Play URL'sinde: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- Bir uygulama yöneticisi uygulaması kullanarak
- Tasker'daki App Info eylemini kullanarak
- MacroDroid'daki Launch App eylemini kullanarak

---

## LifeUp API'lerini çağırma

Eğer:

- `LifeUp` içinde `LifeUp` arayüzünü çağırmanız gerekiyorsa: Mağaza eşyasına bir "link" efekti ekleyin, API belgelerine göre **belirli bir URL** girin ve ardından Mağaza eşyasını kullanarak çağrıyı tamamlayın.
- Web sayfası üzerinden çağırıyorsanız: Hyperlink ile LifeUp API'lerine yönlendirmeniz yeterlidir.
- Kendi geliştirdiğiniz uygulama üzerinden çağırıyorsanız: İlgili arayüz bağlantısına gitmek için Intent kullanın.
- Otomasyon aracı (Tasker gibi) ile çağırıyorsanız: Tasker'ın Browser URL alanına ilgili API bağlantısını girin.

**Bazı örnekler:**

Aşağıdaki bağlantıya tıkladığınızda "LifeUp" "You have learned to call APIs!" mesajını gösterir.

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Aşağıdaki bağlantıya tıkladığınızda "LifeUp" içinde bir jeton alırsınız; nedeni "Learn API Calls" olur.

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Bağlantıyı eşyanın "link" efektine kopyalarsanız, eşyayı kullanmak da aynı efekti tetikler.

**Harici uygulama bağlantısı örneği:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle, 5 harfli kelimeleri tahmin ettiğiniz küçük bir kelime oyunudur. Turuncu, cevapta harfin bulunduğunu gösterir. Yeşil, harfin doğru konumda da olduğunu gösterir.

**Bu Wordle sürümü "LifeUp" ile bağlantıyı destekler:**

1. Kelimeyi doğru tahmin ederseniz 10 jeton alırsınız. Kazanma nedeni özelleştirilebilir.
2. Sonunda kelimeyi tahmin edemezseniz 1 jetonluk teselli Ödülü verilir.

![](_media/api/wordle.png ':size=30%')

<br/>

**Tasker ile bağlantı örneği:**

> Tasker, `Action Category`-`Program`-`Shortcut` seçilerek çağrılır. Kısayol sütununa lifeup:// ile başlayan bağlantıyı girin.

Her gün saat 5'ten sonra ekranın ilk kilidini açmak, belirlediğiniz Görevin (örneğin erken kalkma) tamamlanmasını tetikleyebilir.

**Not: Bu yapılandırmayı içe aktarmak için bir Task Group Id gerekir. [Settings]-[Labs] bölümünde [Developer Mode]'u açabilir ve Görev ayrıntı sayfasında gid değerini kontrol edebilirsiniz.**

Tasker yüklüyse [yapılandırılmış Görevleri içe aktarmak için buraya tıklayın.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**MacroDroid ile LifeUp API'lerini çağırma:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) de bir otomasyon aracıdır; ücretsiz indirilebilir ve arayüzü daha kolay kullanılır.

1. Makro ekleyin, ardından ihtiyacınız olan koşulları ayarlayın (veya sonra ayarlayın)
2. `Actions` ekleyin
3. `Applications` seçin
4. `Open Website` seçin
5. `Enter URL` alanına `lifeup://` ile başlayan bir URL girin
6. Aşağıdaki tüm seçeneklerin **[işaretini kaldırın]**, örneğin `URL encode parameters`...
7. Kaydedin; eyleme tıklayıp doğrulamak için `Test action` seçebilirsiniz

<br/>

**Bu işlevle LifeUp'ın olasılıklarını programlama bilip bilmemenize bakılmaksızın sınırsız genişletebilirsiniz!**

Belirli çağrı kuralları için aşağıya bakın.

---

## Arayüz belgeleri

### Temel bilgiler - Örnekler

| Tür             | Açıklama   |
| ---------------- | ------------- |
| Örnek          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Arayüz biçimi | sabit önek/method adı?parameter1=value1&parameter2=value2 |
| Sabit önek     | lifeup://api/ |
| Method adı      | toast         |
| Parametreler       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Temel bilgiler - Kaçış (URL Encode)

Parametre değeriniz +, boşluk, =, %, &, # gibi özel semboller içeriyorsa kaçış gerekir:

| Özel karakterler | Anlam                                         | Şununla değiştir |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | URL'deki + işareti boşluğu temsil eder        | +          |
| boşluklar             | URL'deki boşluklar + olabilir veya kodlanabilir              | %20        |
| /                  | dizin ile alt dizini ayırır            | %2F        |
| ?                  | gerçek URL ile parametreleri ayırır         | %3F        |
| %                  | özel karakter belirtir                      | %          |
| #                  | yer imi anlamına gelir                                  | %23        |
| &                  | URL'de belirtilen parametreler arası ayırıcı   | %26        |
| =                  | URL'de belirtilen parametrenin değeri | %3D        |

Yukarıdaki açılır mesaj arayüzünü örnek alalım. Son gösterilen metnin `You have learned to call APIs!` olmasını istiyorsanız
boşlukları + ile değiştirmeniz gerekir; sonuç:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Javascript ile uygulanmış basit bir kodlama aracı:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Temel bilgiler - LifeUp Veri Kimliği

LifeUp'taki neredeyse tüm veri depolama benzersiz bir kimliğe sahiptir.

Aşağıdaki arayüzlerin bir kısmı **belirtilen** Mağaza eşyalarını değiştirmeyi ve **belirtilen** Görevleri tamamlamayı destekler.

`LifeUp`'ın ilgili veriyi bulabilmesi için bir kimlik sağlamanız gerekir.

**Uygulamadaki her ayrıntı sayfasında verinin orijinal kimliğini görmek için "Settings" - "Labs" - "Developer Mode"u açabilirsiniz.**

Örneğin "strength (1)" olarak görünen Özellik adının Özellik kimliği 1'dir.

#### Görev kimliği

Etkinlik ayrıntı sayfasında görüntülenebilir.

id: Tekrarlayan bir Görev ise, her tekrarda kimlik güncellenir.

gid: Öğe grubunun kimliği. Aynı tekrarlayan Görev için gid değişmez.

#### Liste kimliği

"Developer Mode" açıldıktan sonra "Select List" açılır penceresinde görüntülenir.

#### Özellik kimliği

"Developer Mode" açıldıktan sonra "Custom Attributes" sayfasında görüntülenir.

#### Mağaza eşyası kimliği

"Developer Mode" açıldıktan sonra Mağaza eşyasına tıklayarak ayrıntıları görüntüleyin.

#### Başarım koşulu kimliği

"Harici API çağrısı gerektirir" kilidini açma koşulunu Başarım için özelleştirdikten sonra koşul kimliğini ayrıntı sayfasında görebilirsiniz.

<br/>

### Temel bilgiler - Ad eşleştirme

Bir API Görevleri, Mağaza eşyalarını veya alt görevleri ada göre aramayı desteklediğinde LifeUp önce büyük/küçük harfi yok sayarak tam ad eşleşmesi dener. Tam eşleşme bulunamazsa bulanık içerme eşleşmesine geçer.

Örneğin hem "Coin" hem "Coin Box" varsa `name=Coin` geçildiğinde bulanık sonuçlardan hangisi önce gelirse onun yerine önce "Coin" eşleşir.

Yinelenen veya benzer adlar belirsiz olabilirse ilgili kimliği geçmeyi tercih edin.

<br/>

### Temel bilgiler - Dönüş değerleri

Bazı arayüzlerin dönüş değerleri olabilir.

**Android uygulaması geliştiriyorsanız,** dönüş değerini almak için `onActivityResult` yöntemini kullanabilirsiniz.

**Tasker gibi bir otomasyon uygulaması kullanıyorsanız:**

Genellikle bu tür uygulamalar Activity türündeki dönüş değerlerini alamaz. Bu nedenle `broadcast` parametresi eklemeniz ve ardından dönüş değerini almak için `received intent` olayını kullanmanız gerekir.

Ayrıntılar için aşağıdaki broadcast parametrelerine bakın.

<br/>

### Temel bilgiler - JSON Veri Yapısı

?> v1.98.0+ gerektirir

Bu bölüm API'de yaygın kullanılan JSON veri yapılarını tanıtır.

#### 1. Eşya Ödül Yapısı

Eşya Ödüllerini belirten bir JSON dizisi; her öğe bir kimlik ve miktar içerir.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Başarım Kilidi Açma Koşulu Yapısı

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Satın Alma Limiti Yapısı

`purchase_limit` bir JSON dizisidir. Her nesne bir kısıtlama kuralını temsil eder.

| Alan | Anlam | Tür | Gerekli | Notlar |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Kısıtlama türü | number | Evet | Aşağıdaki tür tablosuna bakın |
| limitNumber | Birincil sayısal değer | number | Hayır* | Miktar/aralık tabanlı kurallarda kullanılır |
| maxNumber | Aralığın üst sınırı | number | Hayır | Özellik seviye aralığı / sahip olunan eşya miktar aralığında kullanılır |
| limitId | İlgili hedef kimliği | number | Hayır* | Özellik / eşya / Görev / Görev döngüsü / Başarım tabanlı kurallarda gerekli |
| extendInfo | Ek yük | string | Hayır | Zaman tabanlı kurallarda kullanılır; değerin kendisi bir JSON dizesidir |

**Tür tanımları**

| limitType | Anlam | Gerekli alanlar / notlar |
| --------- | ------- | ----------------------- |
| 0 | Günlük miktar limiti | `limitNumber`: günde en fazla kez |
| 1 | Haftalık miktar limiti | `limitNumber`: haftada en fazla kez |
| 2 | Aylık miktar limiti | `limitNumber`: ayda en fazla kez |
| 3 | Yıllık miktar limiti | `limitNumber`: yılda en fazla kez |
| 10 | Özellik seviye kuralı | `limitId`: Özellik kimliği<br/>`limitNumber`: minimum seviye<br/>`maxNumber`: isteğe bağlı maksimum seviye |
| 20 | Günlük zaman aralığı | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Hafta içi gün seçimi | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Pazartesi = 1, Pazar = 7 |
| 22 | Mutlak zaman aralığı | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Ay seçimi | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Ayın günü seçimi | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Sahip olunan eşya miktarı kuralı | `limitId`: hedef eşya kimliği<br/>`limitNumber`: minimum sahip olunan sayı<br/>`maxNumber`: isteğe bağlı maksimum sahip olunan sayı |
| 31 | Görev tamamlandı kuralı | `limitId`: Görev kimliği |
| 32 | Başarım kilidi açıldı kuralı | `limitId`: Başarım kimliği |
| 33 | Görev döngüsü tamamlandı kuralı | `limitId`: tekrarlayan Görev grup kimliği (`groupId`)<br/>O gruptaki en son başlatılan döngüye karşı doğrulanır |

**Notlar**

- `limitType=33` olduğunda `limitId` bir Görev kimliği değildir. Tekrarlayan Görev `groupId` olmalıdır.

- Eski uyumlu yükler `maxNumber` ve `extendInfo` alanlarını atlayabilir.
- `extendInfo` bir dize alanıdır; API URL üzerinden çağrılırken içindeki JSON dizesi genellikle bir kat daha kaçış/kodlama gerektirir.

**Örnek:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Eşya Efekti Yapısı

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Efekt Türü Açıklaması

?> 10-16 türleri v1.102.0+ sürümünden itibaren desteklenir.

| Tür Kodu | Anlam | Parametre Açıklaması |
| ------- | ---- | ------- |
| 0 | Özel efekt yok | Parametre yok |
| 1 | Kullanılamaz | Parametre yok |
| 2 | Jeton ekle | min: Minimum jeton<br/>max: Maksimum jeton (isteğe bağlı, varsayılan min)<br/>using_limit: Sistem limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 3 | Jeton kaldır | min: Minimum jeton<br/>max: Maksimum jeton (isteğe bağlı, varsayılan min)<br/>using_limit: Sistem limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 4 | Deneyim ekle | ids: Yetenek kimliği dizisi<br/>value: Deneyim değeri (eski, min ile aynı)<br/>min: Minimum deneyim (isteğe bağlı, value verilmemişse)<br/>max: Maksimum deneyim (isteğe bağlı, varsayılan min/value)<br/>using_limit: Limit kullanılıp kullanılmayacağı (isteğe bağlı, varsayılan false) |
| 5 | Deneyim kaldır | ids: Yetenek kimliği dizisi<br/>value: Deneyim değeri (eski, min ile aynı)<br/>min: Minimum deneyim (isteğe bağlı, value verilmemişse)<br/>max: Maksimum deneyim (isteğe bağlı, varsayılan min/value)<br/>using_limit: Limit kullanılıp kullanılmayacağı (isteğe bağlı, varsayılan false) |
| 6 | Basit Sentez | require_number: Gerekli miktar<br/>item_id: Eşya kimliği |
| 7 | Kutu aç | items: Eşya dizisi, her öğe şunları içerir:<br/>- item_id: Eşya kimliği<br/>- amount: Miktar<br/>- probability: Olasılık<br/>- is_fixed_reward: Sabit Ödül olup olmadığı |
| 8 | Geri sayım | seconds: Geri sayım saniyesi |
| 9 | Web bağlantısı | url: Bağlantı adresi<br/>use_web_view: Yerleşik tarayıcı kullanılıp kullanılmayacağı (isteğe bağlı, varsayılan false) |
| 10 | Duygu kaydet | Parametre yok |
| 11 | Jeton değiştir (artır veya azalt) | min: Minimum jeton (negatif olabilir)<br/>max: Maksimum jeton (isteğe bağlı, varsayılan min)<br/>using_limit: Sistem limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 12 | Deneyim değiştir (artır veya azalt) | ids: Yetenek kimliği dizisi<br/>value: Deneyim değeri (eski, min ile aynı)<br/>min: Minimum deneyim (negatif olabilir)<br/>max: Maksimum deneyim (isteğe bağlı, varsayılan min/value)<br/>using_limit: Limit kullanılıp kullanılmayacağı (isteğe bağlı, varsayılan false) |
| 13 | Eşya stoku ekle | item_id: Hedef eşya kimliği<br/>min: Minimum stok değişimi<br/>max: Maksimum stok değişimi (isteğe bağlı, varsayılan min)<br/>using_limit: Stok limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 14 | Eşya stoku kaldır | item_id: Hedef eşya kimliği<br/>min: Minimum stok değişimi<br/>max: Maksimum stok değişimi (isteğe bağlı, varsayılan min)<br/>using_limit: Stok limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 15 | Eşya stokunu değiştir (artır veya azalt) | item_id: Hedef eşya kimliği<br/>min: Minimum stok değişimi (negatif olabilir)<br/>max: Maksimum stok değişimi (isteğe bağlı, varsayılan min)<br/>using_limit: Stok limitlerini uygulayıp uygulamama (isteğe bağlı) |
| 16 | Ses çal | file_name: Yerel ses dosyası adı (tercih edilen)<br/>uri: İçe aktarılacak ses URI'si (file_name alternatifi)<br/>display_name: Görünen ad (isteğe bağlı) |

**Efekt Örneği:**

Rastgele altın artırma:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Deneyim Puanı artırma:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Jeton değiştirme (rastgele +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Eşya stokunu değiştirme (rastgele +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Ses çalma:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Kutu açma efekti:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**Yöntem adı:** toast

**Açıklama:** Çeşitli stillerde mesajlar açılır pencere olarak gösterilir

**Örnek:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Detay:** "Live well, eat well!" istemi bonus stiliyle açılır ve daha uzun süre gösterilir.

> Etkiyi test etmek için örnek bağlantıya tıklayın

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text | Gösterilecek metin mesajı | Herhangi bir metin | You learned to call! | evet | |
| type | Metin stili türü | 0 ile 6 arası sayı | 1 | hayır | 0 - Normal stil<br/>1 - Bonus stili<br/>2 - Domates stili<br/>3 - Başarı stili<br/>4 - Bilgi stili<br/>5 - Uyarı stili<br/>6 - Hata stili |
| isLong | Gösterim süresi | true veya false | true | hayır | true - uzun<br/>false - kısa |

<br/>

### Reward

**Yöntem adı:** reward

**Açıklama:** Ödülü doğrudan verir. Ödül nedeni özelleştirilebilir.

**Örnek:**

- 1 jeton alın; alma nedeni "Learn API Calls"tır. Neden jeton ayrıntı sayfasında gösterilir:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- "Learning, Creativity" için 300 Deneyim Puanı alın; alma nedeni "Learn API Calls"tır. Neden Deneyim Puanı ayrıntı sayfasında gösterilir:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- "treasure" ile bulanık eşleşen 1 Eşya alın; alma nedeni "Learn API Calls"tır. Neden Envanter geçmişi sayfasında gösterilir:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type | Ödül türü | şu anda yalnızca şunlar desteklenir:<br/>coin<br/>exp<br/>item | coin | evet | coin - jeton<br/>exp - Deneyim Puanı<br/>item - Mağaza eşyaları |
| content | Ödül nedeni | herhangi bir metin | Learning API Calls | Evet | |
| skills | Yetenekler (Özellikler) | 0'dan büyük sayı dizisi | 1 | Hayır | Yalnızca type exp olduğunda kullanılabilir<br/>Dizi desteklenir (ör. &skills=1&skills=2&skills=3)<br/>Nasıl alınacağı için yukarıdaki "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| number | Ödül miktarı | 0'dan büyük bir sayı | 1 | Evet | Jetonsa en fazla 999999<br/>Deneyim Puanıysa en fazla 99999<br/>Eşyaysa en fazla 999 |
| item_id | item id | 0'dan büyük sayı | 1 | hayır* | yalnızca type item olduğunda kullanılabilir |
| item_name | item name | herhangi bir metin | treasure | hayır* | yalnızca type item olduğunda kullanılabilir; Eşya adlarıyla bulanık eşleştirme |
| silent | Arayüz bildirimlerini devre dışı bırak | true veya false | false | hayır | varsayılan false |

<br/>

### Penalty

**Yöntem adı:** penalty

**Açıklama:** Cezayı doğrudan uygular. Ceza nedeni özelleştirilebilir.

**Örnek:** *Temelde reward arayüzüyle aynı

- 1 jeton cezalandırılır; neden "sleep in"tir. Neden jeton ayrıntı sayfasında gösterilir:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- "sleep in" için 300 "Strength" Deneyim Puanı cezalandırılır. Neden Deneyim Puanı ayrıntı sayfasında gösterilir:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- "sleep in" için "treasure" ile bulanık eşleşen 1 Eşya cezalandırılır. Neden Envanter geçmişi sayfasında gösterilir:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type | Ceza türü | Şu anda yalnızca desteklenenler:<br/>coin<br/>exp<br/>item | coin | evet | coin - jeton<br/>exp - Deneyim Puanı<br/>item - Mağaza eşyaları |
| content | Ceza nedeni | herhangi bir metin | Sleep In | Evet | |
| skills | Yetenekler (Özellikler) | 0'dan büyük sayı dizisi | 1 | Hayır | Yalnızca type exp olduğunda kullanılabilir<br/>Dizi desteklenir (ör. &skills=1&skills=2&skills=3)<br/>Nasıl alınacağı için yukarıdaki "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| number | Ceza miktarı | 0'dan büyük bir sayı | 1 | Evet | Jetonsa en fazla 999999<br/>Deneyim Puanıysa en fazla 99999<br/>Eşyaysa en fazla 999 |
| item_id | item id | 0'dan büyük sayı | 1 | hayır* | yalnızca type item olduğunda kullanılabilir |
| item_name | item name | herhangi bir metin | treasure | hayır* | yalnızca type item olduğunda kullanılabilir; Eşya adlarıyla bulanık eşleştirme |
| silent | Arayüz bildirimlerini devre dışı bırak | true veya false | false | hayır | varsayılan false |

<br/>

### Edit Coin

**Yöntem adı:** edit_coin

**Açıklama:** Kullanıcının jeton bakiyesini doğrudan düzenler. Mevcut jeton miktarı belirtilen değere ayarlanır. Değişiklik nedeni özelleştirilebilir ve jeton geçmişinde gösterilir.

**Örnek:**

- Nedeni "API adjustment" ile jetonları 1000'e ayarla: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Sessizce jetonları 500'e ayarla: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Hedef jeton miktarı | number >= 0 | 1000 | Evet | İşlem sonrası nihai jeton bakiyesi; en fazla 999999 |
| content | Değişiklik nedeni | herhangi bir metin | API adjustment | Hayır | Belirtilmezse sistem varsayılan nedeni kullanılır |
| reason | Değişiklik nedeni (takma ad) | herhangi bir metin | API adjustment | Hayır | content parametresine alternatif |
| silent | Arayüz bildirimini devre dışı bırak | true veya false | false | Hayır | Varsayılan false; true yapılırsa toast mesajı bastırılır |

<br/>

### Tasks

#### Add a Task

?> `pin` gibi bazı alanlar v1.98.0+ gerektirir

**Yöntem adı:** add_task

**Açıklama:** Doğrudan bir Görev oluşturur

**Örnek:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parametre | Anlam | Değer | Örnek | Gerekli | Notlar |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo | Görev içeriği | herhangi bir metin | Write diary | Evet | |
| notes | Notlar | herhangi bir metin | Notes | Hayır | Varsayılan boş |
| coin | Jeton Ödülü | number >= 0 | 10 | Hayır | Varsayılan 0; sistem limitlerine tabidir |
| coin_var | Jeton Ödülü varyansı | number >= 0 | 1 | Hayır | Varsayılan 0; >0 ise [coin, coin+coin_var] arasında rastgele Ödül |
| exp | Deneyim Puanı Ödülü | number >= 0 | 100 | Hayır | Varsayılan 0; sistem limitlerine tabidir |
| skills | Yetenek kimlikleri | 0'dan büyük sayı dizisi | 1 | Hayır | Dizi desteklenir (ör. &skills=1&skills=2) |
| category | Liste kimliği | number >= 0 | 0 | Hayır | Varsayılan 0 (varsayılan liste); akıllı listelere izin verilmez |
| frequency | Tekrar sıklığı | integer | 0 | Hayır | Varsayılan 0 (bir kez)<br/>0 - Bir kez<br/>1 - Günlük<br/>N (N>1) - Her N günde bir<br/>-1 - Sınırsız<br/>-3 - Ebbinghaus (v1.99.1 gerektirir)<br/>-4 - Aylık<br/>-5 - Yıllık |
| weekdays | Hafta içi günler | `1,3,5` veya `none` | 1,3,5 | Hayır | v1.106.0+; 1=Pazartesi … 7=Pazar, **tekrarlanacak** günler. Belirtilirse frequency atlanmalı veya 1 olmalıdır. Eklemede `none` reddedilir; düzenlemede `none` günlüğe döndürür. 7 günün tamamı günlük sayılır |
| importance | Önem düzeyi | [1, 4] | 1 | Hayır | Varsayılan 1 |
| difficulty | Zorluk düzeyi | [1, 4] | 1 | Hayır | Varsayılan 1 |
| deadline | Bitiş zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | |
| no_deadline | Bitiş tarihi yok | true/false | true | Hayır | v1.104.0+; yalnızca tekrarlayan Görevler için geçerli. `&no_deadline=true` geçmek belirli bitiş zamanını temizler |
| color | Etiket rengi | renk dizesi | #66CCFF | Hayır | #, %23 olarak kaçırılmalıdır |
| background_url | Arka plan görseli URL'si | web URL'si | http://example.com/bg.jpg | Hayır | Erişilebilir bir web görseli olmalıdır |
| background_alpha | Arka plan opaklığı | [0, 1] arası float | 0.5 | Hayır | Varsayılan 1.0 |
| enable_outline | Metin dış çizgisi | true veya false | false | Hayır | Yalnızca background_url ile geçerli; okunabilirlik için metne dış çizgi ekler |
| use_light_remark_text_color | Notlar için açık metin | true veya false | false | Hayır | Yalnızca background_url ile geçerli; not metni için açık renk kullanır |
| start_time | Başlangıç zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | Görev başlangıç zamanı |
| auto_use_item | Ödül Eşyalarını otomatik kullan | true veya false | false | Hayır | Tamamlandığında Ödülleri otomatik kullanır |
| remind_time | Hatırlatma zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | Görev hatırlatma zamanı |
| pin | Görevi sabitle | true veya false | false | Hayır | Görevi üste sabitler |
| words | Tamamlama Ödül metni | herhangi bir metin | Great job! | Hayır | Görev tamamlandığında gösterilen motivasyon metni |
| frozen | Dondurma durumu | true veya false | false | Hayır | Varsayılan false |
| freeze_until | Dondurma bitişi | timestamp (milisaniye) | 1640995200000 | Hayır | Yalnızca frozen true iken geçerlidir |
| coin_penalty_factor | Jeton ceza faktörü | [0, 100) arası float | 0.5 | Hayır | |
| exp_penalty_factor | Deneyim Puanı ceza faktörü | [0, 100) arası float | 0.5 | Hayır | |
| write_feelings | Duyguları etkinleştir | true veya false | false | Hayır | Varsayılan false |
| item_id | Eşya kimliği | number > 0 | 1 | Hayır* | item_id veya item_name gerekli |
| item_name | Eşya adı | herhangi bir metin | Treasure | Hayır* | item_id veya item_name gerekli |
| item_amount | Eşya miktarı | [1, 99] | 1 | Hayır | Varsayılan 1 |
| items | Eşya Ödülleri | JSON metni | [Eşya Ödül Yapısı](#1-item-rewards-structure) bölümüne bakın | Hayır | Birden fazla Eşya Ödülü ayarlar |
| task_type | Görev türü | [0, 4] | 0 | Hayır | v1.99.1 gerektirir<br/>0 - Normal Görev<br/>1 - Sayım Görevi<br/>2 - Negatif Görev<br/>3 - API Görevi<br/>4 - Zamanlı Görev (v1.102.0+) |
| target_times | Hedef sayısı | number > 0 | 1 | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli |
| is_affect_shop_reward | Mağaza Ödülünü etkiler | true/false | false | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli; Eşya Ödül hesaplamasını etkileyip etkilemeyeceği |
| enable_proportional_settlement | Orantılı hesaplamayı etkinleştir | true/false | false | Hayır | v1.104.0+; yalnızca task_type 1 (sayım Görevi) iken geçerli. Etkinleştirildiğinde sayım ilerlemesi hesaplaması Ödülleri orantılı verir; nihai tamamlama zaten hesaplanmış Ödülleri tekrar vermez |
| expected_focus_minutes | Beklenen Odak dakikası | number > 0 | 25 | Hayır | Yalnızca task_type 4 (zamanlı Görev) iken geçerli; varsayılan 25 (v1.102.0+) |
| repeat_end_mode | Tekrar bitiş modu | 0 veya 1 | 0 | Hayır | Yalnızca tekrarlayan Görevler için geçerli (frequency 0 / -1 değil)<br/>0 - Sayıya göre bitir<br/>1 - Tarihe göre bitir (v1.102.0+) |
| repeat_target_times | Tekrar bitiş sayısı | number > 0 | 3 | Hayır | repeat_end_mode=0 olduğunda (veya bu alanın varlığından çıkarıldığında) kullanılır; target_times ile karıştırmayın (v1.102.0+) |
| repeat_end_date | Tekrar bitiş tarihi | timestamp (milisaniye) | 1640995200000 | Hayır | repeat_end_mode=1 olduğunda (veya bu alanın varlığından çıkarıldığında) kullanılır (v1.102.0+) |
| repeat_end_behavior | Tekrar bitiş davranışı | 0 veya 1 | 0 | Hayır | 0 - Bitiş koşuluna ulaşınca Görevi sonlandır<br/>1 - Bitiş koşuluna ulaşınca Görevi dondur (v1.102.0+) |

**Yanıt:**

| Alan | Tür | Açıklama | Örnek | Notlar |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id | Number | Görev kimliği | 1000 | |
| task_gid | Number | Görev grup kimliği | 1000 | |

<br/>

#### Complete a Task

**Yöntem adı:** complete

**Açıklama:** Görev tamamlamayı tetikler. Yalnızca tamamlanmamış Görevler aranır.

**Örnek:**

- Kimliği 1 olan Görevi tamamla: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- "task group id"si 1 olan Görevi tamamla: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Ada göre Görev ara ve tamamla: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Detay:**

Her Görevin bir kimliği vardır.

Tekrarlayan Görevlerde kimlik her seferinde yenilenir, ancak "task group id" aynı kalır.

Kimliği almak için "Labs" sayfasında "Developer Mode"u açın ve ardından "Task Details" sayfasında görüntüleyin.

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | hayır* | Görev kimliği; tekrarlayan Görevde her tekrarda güncellenir |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | hayır* | Görev grup kimliği |
| name | ad | herhangi bir metin | get up | hayır* | bulanık arama; bulunan Görevlerden yalnızca biri |
| ui | Açılır arayüzü göster | true veya false | true | hayır | varsayılan false; yalnızca arka planda mesaj gösterilir |
| count | Sayım değeri | Number | 1 | Hayır | Yalnızca sayım Görevleri için geçerli; `count_set_type` parametresiyle birlikte kullanın |
| count_set_type | Sayım değerini ayarlama yöntemi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | Varsayılan relative<br/>absolute - Hedefi doğrudan değere ayarla<br/>relative - Orijinal değere göre ekle veya çıkar |
| count_force_sum_up | Sayım Görevi Ödüllerini zorla topla | true veya false | true | Hayır | |
| reward_factor | Ödül faktörü | 0'dan büyük ondalık sayı | 1.1 | Hayır | Sayım Görevlerine uygulanmaz<br/>Ödül faktörü Deneyim Puanı ve jeton miktarını etkiler (Eşya miktarını değil) |

**Not:**

1. Görevi eşleştirebilmek için id, gid ve name'den biri verilmelidir.
2. Zamanlı Görevler bu API ile manuel tamamlanamaz (v1.102.0+).

<br/>

#### Give up a Task

**Yöntem adı:** give_up

**Açıklama:** Görevden vazgeçmeyi tetikler.

**Örnek:**

- Ada göre Görev ara ve vazgeç: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Detay:**

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | hayır* | Görev kimliği; tekrarlayan Görevde her tekrarda güncellenir |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | hayır* | Görev grup kimliği |
| name | ad | herhangi bir metin | get up | hayır* | bulanık arama; yalnızca eşleşen bir Görev üzerinde işlem yapar |

**Not:**

1. Görevi eşleştirebilmek için id, gid ve name'den biri verilmelidir.

<br/>

#### Freeze a task

**Yöntem adı:** freeze

**Açıklama:** Görev dondurmayı tetikler; yalnızca tekrarlayan Görevler için.

**Örnek:**

- Ada göre Görev ara ve dondur: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Detay:**

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | hayır* | Görev kimliği; tekrarlayan Görevde her tekrarda güncellenir |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | hayır* | Görev grup kimliği |
| name | ad | herhangi bir metin | get up | hayır* | bulanık arama; yalnızca eşleşen bir Görev üzerinde işlem yapar |
| time | Dondurma bitişi | timestamp | 1661688800682 | hayır | - |

**Not:**

1. Görevi eşleştirebilmek için id, gid ve name'den biri verilmelidir.

<br/>

#### Unfreeze a task

**Yöntem adı:** unfreeze

**Açıklama:** Görev dondurmasını kaldırmayı tetikler.

**Örnek:**

- Ada göre Görev ara ve dondurmayı kaldır: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Detay:**

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | hayır* | Görev kimliği; tekrarlayan Görevde her tekrarda güncellenir |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | hayır* | Görev grup kimliği |
| name | ad | herhangi bir metin | get up | hayır* | bulanık arama; yalnızca eşleşen bir Görev üzerinde işlem yapar |

**Not:**

1. Görevi eşleştirebilmek için id, gid ve name'den biri verilmelidir.

<br/>

#### Delete a task

**Yöntem adı:** delete_task

**Açıklama:** Bir Görevi siler.

**Örnek:**

- Ada göre Görev ara ve sil: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Detay:**

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | hayır* | Görev kimliği; tekrarlayan Görevde her tekrarda güncellenir |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | hayır* | Görev grup kimliği |
| name | ad | herhangi bir metin | get up | hayır* | bulanık arama; yalnızca eşleşen bir Görev üzerinde işlem yapar |

**Not:**

1. Görevi eşleştirebilmek için id, gid ve name'den biri verilmelidir.

<br/>

### Edit Task

?> v1.98.0+ gerektirir

**Yöntem adı:** edit_task

**Açıklama:** Mevcut bir Görevin içeriğini ve özelliklerini düzenler

**Örnek:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parametre | Anlam | Değer | Örnek | Gerekli | Notlar |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | Hayır* | id, gid veya name'den biri gerekli |
| gid | Görev grup kimliği | 0'dan büyük sayı | 1 | Hayır* | id, gid veya name'den biri gerekli |
| name | Görev adı | herhangi bir metin | Write diary | Hayır* | id, gid veya name'den biri gerekli |
| todo | Görev içeriği | herhangi bir metin | Write weekly | Hayır | |
| notes | Notlar | herhangi bir metin | Note content | Hayır | |
| coin | Jeton Ödülü | number >= 0 | 10 | Hayır | Tamamlandığında kazanılan jeton; sistem limitlerine tabidir |
| coin_var | Jeton varyansı | 0'dan büyük sayı | 1 | Hayır | [coin, coin+coin_var] arasında rastgele Ödül |
| exp | Deneyim Puanı Ödülü | number >= 0 | 20 | Hayır | Kazanılan Deneyim Puanı; sistem limitlerine tabidir |
| skills | Yetenek kimlikleri | 0'dan büyük sayı dizisi | 1 | Hayır | Dizi desteklenir (ör. &skills=1&skills=2) |
| category | Liste kimliği | 0 veya daha büyük sayı | 0 | Hayır | Varsayılan liste için 0; akıllı listeler desteklenmez |
| frequency | Tekrar sıklığı | integer | 0 | Hayır | Varsayılan 0 (bir kez)<br/>0 - Bir kez<br/>1 - Günlük<br/>N (N>1) - Her N günde bir<br/>-1 - Sınırsız<br/>-3 - Ebbinghaus (v1.99.1 gerektirir)<br/>-4 - Aylık<br/>-5 - Yıllık |
| weekdays | Hafta içi günler | `1,3,5` veya `none` | 1,3,5 | Hayır | v1.106.0+; add_task ile aynı. Atlanırsa değişmez; `none` günlüğe döndürür; frequency 1 dışında bir değere ayarlanırsa weekdays de temizlenir |
| importance | Önem düzeyi | [1, 4] | 1 | Hayır | Varsayılan 1 |
| difficulty | Zorluk düzeyi | [1, 4] | 2 | Hayır | Varsayılan 1 |
| deadline | Bitiş tarihi | timestamp (milisaniye) | 1640995200000 | Hayır | |
| no_deadline | Bitiş tarihi yok | true/false | true | Hayır | v1.104.0+; yalnızca tekrarlayan Görevler için geçerli. `&no_deadline=true` geçmek belirli bitiş zamanını temizler |
| remind_time | Hatırlatma zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | |
| start_time | Başlangıç zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | |
| color | Etiket rengi | renk dizesi | #66CCFF | Hayır | #, %23 olarak kaçırılmalıdır |
| background_url | Arka plan görseli URL'si | web URL adresi | http://example.com/bg.jpg | Hayır | |
| background_alpha | Arka plan opaklığı | [0, 1] arası ondalık | 0.5 | Hayır | |
| enable_outline | Metin dış çizgisi | true veya false | false | Hayır | Yalnızca background_url ile geçerli; okunabilirlik için metne dış çizgi ekler |
| use_light_remark_text_color | Notlar için açık metin | true veya false | false | Hayır | Yalnızca background_url ile geçerli; not metni için açık renk kullanır |
| item_id | Eşya kimliği | 0'dan büyük sayı | 1 | Hayır* | item_id veya item_name gerekli |
| item_name | Eşya adı | herhangi bir metin | Treasure | Hayır* | item_id veya item_name gerekli |
| item_amount | Eşya miktarı | [1, 99] | 1 | Hayır | Varsayılan 1 |
| items | Eşya Ödül JSON'u | JSON metni | [{"itemId":1,"amount":1}] | Hayır | Birden fazla Eşya Ödülü ayarlar |
| auto_use_item | Eşyayı otomatik kullan | true veya false | false | Hayır | |
| frozen | Dondurma durumu | true veya false | false | Hayır | Varsayılan false |
| freeze_until | Dondurma bitişi | timestamp (milisaniye) | 1640995200000 | Hayır | Yalnızca frozen true iken geçerlidir |
| coin_penalty_factor | Jeton ceza faktörü | [0, 100) arası ondalık | 0.5 | Hayır | |
| exp_penalty_factor | Deneyim Puanı ceza faktörü | [0, 100) arası ondalık | 0.5 | Hayır | |
| write_feelings | Duyguları etkinleştir | true veya false | false | Hayır | |
| pin | Görevi sabitle | true veya false | false | Hayır | |
| words | Tamamlama Ödül metni | herhangi bir metin | Great job! | Hayır | Görev tamamlandığında gösterilen motivasyon metni |
| task_type | Görev türü | [0, 4] | 0 | Hayır | v1.99.1 gerektirir<br/>0 - Normal Görev<br/>1 - Sayım Görevi<br/>2 - Negatif Görev<br/>3 - API Görevi<br/>4 - Zamanlı Görev (v1.102.0+) |
| target_times | Hedef sayısı | number > 0 | 1 | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli |
| is_affect_shop_reward | Mağaza Ödülünü etkiler | true/false | false | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli; Eşya Ödül hesaplamasını etkileyip etkilemeyeceği |
| enable_proportional_settlement | Orantılı hesaplamayı etkinleştir | true/false | false | Hayır | v1.104.0+; yalnızca task_type 1 (sayım Görevi) iken geçerli. Mevcut sayım Görevlerinde bu parametre yalnız başına geçirilerek orantılı hesaplama açılıp kapatılabilir; bu ayar veya Ödül yapılandırması değiştirildiğinde uygulama kurallarına göre hesaplanmış ilerleme sıfırlanabilir veya geri alınabilir |
| expected_focus_minutes | Beklenen Odak dakikası | number > 0 | 25 | Hayır | Yalnızca task_type 4 (zamanlı Görev) iken geçerli; varsayılan 25 (v1.102.0+) |
| repeat_target_times | Tekrar bitiş sayısı | number > 0 | 3 | Hayır | Yalnızca tekrarlayan Görevler için geçerli (frequency 0 / -1 değil); repeat_target_times ve repeat_end_date birlikte verilirse repeat_target_times önceliklidir (v1.102.0+) |
| repeat_end_date | Tekrar bitiş tarihi | timestamp (milisaniye) | 1640995200000 | Hayır | Yalnızca tekrarlayan Görevler için geçerli (frequency 0 / -1 değil) (v1.102.0+) |
| repeat_end_behavior | Tekrar bitiş davranışı | 0 veya 1 | 0 | Hayır | 0 - Bitiş koşuluna ulaşınca Görevi sonlandır<br/>1 - Bitiş koşuluna ulaşınca Görevi dondur (v1.102.0+) |
| coin_set_type | Jeton değerini ayarlama yöntemi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - jetonu doğrudan değere ayarla<br/>relative - orijinal jeton değerine ekle/çıkar |
| exp_set_type | Deneyim Puanı değerini ayarlama yöntemi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - Deneyim Puanını doğrudan değere ayarla<br/>relative - orijinal Deneyim Puanı değerine ekle/çıkar |

**Yanıt:**

| Alan | Tür | Açıklama | Örnek | Notlar |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id | Number | Görev kimliği | 1000 | |
| task_gid | Number | Görev grup kimliği | 1000 | |

<br/>

### Task Templates

?> v1.102.0+ sürümünde eklendi

**Yöntem adı:** task_template

**Açıklama:** Görev şablonları için CRUD.

**Örnekler:**

- Şablonları listele: `lifeup://api/task_template?method=list`
- Parametrelerden oluştur: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Mevcut bir Görevden oluştur: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Şablon al: `lifeup://api/task_template?method=get&id=1`
- Şablon adını güncelle: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Bir Görevden şablon içeriğini güncelle: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Şablon sil: `lifeup://api/task_template?method=delete&id=1`

| Parametre | Anlam | Değer | Örnek | Gerekli | Notlar |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | İşlem | list / get / create / update / delete | list | Evet | - |
| id | Şablon kimliği | number > 0 | 1 | Hayır* | get/update/delete için gerekli; takma ad: template_id |
| template_id | Şablon kimliği | number > 0 | 1 | Hayır* | id takma adı |
| name | Şablon adı | metin | MyTemplate | Hayır* | create için gerekli; from_task_id/from_task_gid kullanılmıyorsa update için de gerekli |
| from_task_id | Görev kimliğinden oluştur | number > 0 | 1 | Hayır | create/update için |
| from_task_gid | Görev grup kimliğinden oluştur | number > 0 | 1 | Hayır | create/update için |
| todo | Görev içeriği | metin | Write diary | Hayır* | from_task_id/from_task_gid kullanılmadan create yapılırken gerekli |
| notes | Notlar | metin | Notes | Hayır | Varsayılan boş |
| category | Liste kimliği | number >= 0 | 0 | Hayır | Takma ad: category_id |
| category_id | Liste kimliği | number >= 0 | 0 | Hayır | category takma adı |
| frequency | Tekrar sıklığı | integer | 0 | Hayır | add_task ile aynı |
| weekdays | Hafta içi günler | `1,3,5` | 1,3,5 | Hayır | v1.106.0+; add_task ile aynı; create `none` reddeder |
| importance | Önem düzeyi | [1, 4] | 1 | Hayır | - |
| difficulty | Zorluk düzeyi | [1, 4] | 1 | Hayır | - |
| coin | Jeton Ödülü | number | 10 | Hayır | - |
| coin_var | Jeton Ödülü varyansı | number | 1 | Hayır | - |
| exp | Deneyim Puanı Ödülü | number | 100 | Hayır | - |
| skills | Yetenek kimlikleri | dizi parametreleri | 1 | Hayır | Dizi desteklenir (ör. &skills=1&skills=2) |
| skill_ids | Yetenek kimlikleri | JSON dizisi veya virgülle ayrılmış liste | [1,2] | Hayır | skills alternatifi |
| deadline | Bitiş zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | - |
| start_time | Başlangıç zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | - |
| remind_time | Hatırlatma zamanı | timestamp (milisaniye) | 1640995200000 | Hayır | - |
| words | Tamamlama Ödül metni | metin | Great job! | Hayır | - |
| task_type | Görev türü | [0, 4] | 0 | Hayır | 0 - Normal<br/>1 - Sayım<br/>2 - Negatif<br/>3 - API<br/>4 - Zamanlı |
| target_times | Hedef sayısı | number > 0 | 10 | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli |
| is_affect_shop_reward | Mağaza Ödülünü etkiler | true / false | false | Hayır | Yalnızca task_type 1 (sayım Görevi) iken geçerli |
| enable_proportional_settlement | Orantılı hesaplamayı etkinleştir | true / false | false | Hayır | v1.104.0+; yalnızca task_type 1 (sayım Görevi) iken geçerli. Şablondan oluşturulan Görevler bu sayım Görevi hesaplama ayarını korur |
| expected_focus_minutes | Beklenen Odak dakikası | number > 0 | 25 | Hayır | Yalnızca task_type 4 (zamanlı Görev) iken geçerli |
| repeat_end_mode | Tekrar bitiş modu | 0 veya 1 | 0 | Hayır | Yalnızca tekrarlayan Görevler için geçerli (frequency 0 / -1 değil)<br/>0 - Sayıya göre bitir<br/>1 - Tarihe göre bitir |
| repeat_target_times | Tekrar bitiş sayısı | number > 0 | 3 | Hayır | repeat_end_mode=0 olduğunda (veya bu alanın varlığından çıkarıldığında) kullanılır |
| repeat_end_date | Tekrar bitiş tarihi | timestamp (milisaniye) | 1640995200000 | Hayır | repeat_end_mode=1 olduğunda (veya bu alanın varlığından çıkarıldığında) kullanılır |
| repeat_end_behavior | Tekrar bitiş davranışı | 0 veya 1 | 0 | Hayır | 0 - Sonlandır<br/>1 - Dondur |

**Dönüş:**

| Alan | Anlam | Tür | Notlar |
| ----- | ------- | ---- | ----- |
| templates | şablon listesi (JSON dizesi) | text | Yalnızca method=list için |
| count | şablon sayısı | number | Yalnızca method=list için |
| template | şablon ayrıntısı (JSON dizesi) | text | Yalnızca method=get için |
| id | şablon kimliği | number | get/create/update/delete için |
| name | şablon adı | text | get/create/update için |
| success | başarılı olup olmadığı | true / false | create/update/delete için |

<br/>

### History Task Operation

?> v1.98.0+ gerektirir

**Yöntem adı:** history_operation

**Açıklama:** Tamamlanmış/vazgeçilmiş/süresi dolmuş Görevler üzerinde işlem yapar

**Örnekler:**

- Geçmiş Görevi sil: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Görevi vazgeçilmiş olarak işaretle: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Görevi yeniden başlat: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Bu API yalnızca tamamlanmamış olmayan Görevler için geçerlidir (tamamlanmış, vazgeçilmiş veya süresi dolmuş)

| Parametre | Anlam | Değer | Örnek | Gerekli | Notlar |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id | Görev kimliği | 0'dan büyük sayı | 1 | Evet | Geçmiş Görevin kimliği |
| operation | İşlem türü | Şunlardan biri:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Evet | delete - Görevi sil<br/>complete - Tamamlandı olarak işaretle<br/>undo_complete - Tamamlamayı geri al<br/>set_to_give_up - Vazgeçilmiş olarak işaretle<br/>set_to_overdue - Süresi dolmuş olarak işaretle<br/>edit_completed_time - Tamamlanma zamanını değiştir<br/>restart - Görevi yeniden başlat |
| completed_time | Tamamlanma zamanı | timestamp (milisaniye) | 1640995200000 | Hayır* | Yalnızca operation edit_completed_time olduğunda gerekli |

**Yanıt:**

| Alan | Tür | Açıklama | Örnek | Notlar |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id | Number | Görev kimliği | 1000 | İşlem yapılan Görevin kimliği |

<br/>

### Shop Settings

**Yöntem adı:** shop_settings

**Talimatlar:** Çeşitli Mağaza ayarlarını düzenler

**Örnek:**

- ATM faiz oranını %0,01 olarak ayarla: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Her tıklamada faiz oranını %0,01 artır: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key | tür | Şu anda yalnızca şu değerler desteklenir:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | evet | atm_interest - ATM günlük oranı<br/>credit_interest - kredi günlük oranı<br/>line_of_credit - borç alınabilir tutar<br/>discount_rate_for_returning - iade indirim oranı<br/>atm_balance - ATM bakiyesini ayarla |
| value | sayısal değer | ondalık veya tam sayı | 0.01 | evet | farklı key'ler farklı değer aralıklarına karşılık gelir<br/>Örneğin ATM bakiyeleri ondalık noktayı desteklemez |
| set_type | Değeri ayarlama yöntemi | Şu değerlerden biri:<br/>absolute<br/>relative | absolute | hayır | absolute - mutlak değer, yani hedefi doğrudan değere ayarla<br/>relative - göreli değer, orijinal değere ekleme veya çıkarma |
| silent | Sessizce çalıştır (arayüz göstermeden) | Boolean | false | Hayır | v1.93.0-beta01 (502) ve sonrasından itibaren desteklenir<br/>Varsayılan false; yani arayüz bildirimleri gösterilir |

<br/>

### Jump

**Yöntem adı:** goto

**Açıklama:** `LifeUp` içinde bir sayfaya git

**Örnek:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Açıklama:** Laboratuvar sayfasına git

| Parametre | Anlam | Değer | Örnek | Gerekli | Notlar |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | sayfa | Şu değerlerden biri:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | evet | `purchase_dialog` satın alma açılır penceresini ifade eder<br/> `use_item_dialog` eşya kullanma açılır penceresini ifade eder<br/>Diğer girişler belirli ana sayfalara karşılık gelir |

#### 1. Eşya satın alma/kullanma açılır penceresine git

`page` parametresi `purchase_dialog` veya `use_item_dialog` olarak ayarlandığında eşya kimliğini belirtebilirsiniz:

Örnek: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parametre | Anlam | Değer            | Örnek | Gerekli | Notlar   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | Eşya kimliği | Pozitif tam sayı | 1       | Evet      | Eşya kimliği |

<br/>

#### 2. Ana sayfanın alt sayfasına git

`page` parametresi `main` olduğunda gidilecek alt sayfayı ek olarak belirtebilirsiniz:

Örnek, Mağaza sayfasına git: `lifeup://api/goto?page=main&sub_page=shop`

| Parametre   | Anlam       | Değer | Örnek | Gerekli | Notlar  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | alt sayfa adı | Şunlardan biri:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | hayır       |      |
| category_id | liste kimliği       | sayı | 0      | hayır       | `sub_page` bir liste sayfasıysa gidilecek liste kimliğini belirtebilirsiniz. <br/>Örneğin Mağaza eşya listesi, Envanter listesi, Görev listesi. |

<br/>

#### 3. Görev ayrıntılarına git

`page` parametresi `task_detail` olduğunda gidilecek görev kimliğini ek olarak belirtebilirsiniz:

Örnek, görev kimliği 53 olan belirtilen Görevin ayrıntı sayfasına git: `lifeup://api/goto?page=task_detail&task_id=53`

| Parametre | Anlam       | Değer         | Örnek      | Gerekli | Notlar |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | görev kimliği       | görev kimliği       | 53           | Hayır*      | görev kimliği; tekrarlayan bir Görev ise her tekrarda kimlik güncellenir. |
| task_gid  | görev grup kimliği | görev grup kimliği | 3            | Hayır*      | görev grup kimliği |
| task_name | görev adı     | string        | get up early | Hayır*      | görev adı, bulanık eşleşme ile biri. |

**Not:**

1. Üç parametreden yalnızca biri sağlanmalıdır.
    - Birden fazlası aynı anda sağlanırsa dahili bir öncelik sırası uygulanır. Ancak bu tanımsız davranıştır; App sırayı garanti etmez.

<br/>

#### 4. Yeni Başarım sayfasına git

`page` parametresi `add_achievement` olduğunda kategori kimliğini **mutlaka** ek olarak belirtmelisiniz:

Örnek, kategori kimliği 1 ile yeni Başarım sayfasına git: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parametre    | Anlam         | Değer         | Örnek | Gerekli | Notlar  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Başarım kategori kimliği | Başarım kategori kimliği | 1       | Evet      |        |

#### 5. Belirli Başarım kategori sayfasına git

`page` parametresi `user_achievement` olduğunda kategori kimliğini **mutlaka** ek olarak belirtmelisiniz:

Örnek, kimliği 1 olan Başarım kategori sayfasına git: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parametre    | Anlam         | Değer         | Örnek | Gerekli | Notlar  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Başarım kategori kimliği | Başarım kategori kimliği | 1       | Evet      |        |

#### 6. Belirli Sentez kategori sayfasına git

`page` parametresi `synthesis` olduğunda isteğe bağlı olarak kategori kimliğini belirtebilirsiniz:

Örnek, kimliği 1 olan Sentez kategori sayfasına git: `lifeup://api/goto?page=synthesis&category_id=1`

| Parametre    | Anlam         | Değer         | Örnek | Gerekli | Notlar  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Sentez kategori kimliği | Sentez kategori kimliği | 1       | Hayır       |        |

Sentez sayfasını bir filtreyle de açabilirsiniz (v1.102.0+):

Örnek, ürün eşya kimliği 1 ile filtrele: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parametre        | Anlam           | Değer | Örnek | Gerekli | Notlar |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Filtre türü       | product / ingredient / related | product | Hayır* | filter_item_id gerektirir |
| filter_item_id  | Filtre eşya kimliği    | number > 0 | 1 | Hayır* | filter_type gerektirir |
| filter_item_name| Filtre eşya adı  | text | Gem | Hayır | İsteğe bağlı, görüntüleme için kullanılır |

### Shop

#### Eşya Ekleme

?> `effects` gibi bazı alanlar v1.98.0+ gerektirir

**Yöntem adı:** add_item

**Açıklama:** Satın alma limitleri ve kullanım efektleri dahil özelleştirilebilir özelliklerle Mağaza eşyası oluşturur.

**Örnek:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parametre        | Anlam                | Değerler               | Örnek       | Gerekli | Notlar                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Eşya adı             | herhangi bir metin             | 10 minute break | Evet    |                                 |
| desc            | Açıklama           | herhangi bir metin             | Take a break  | Hayır       |                                 |
| icon            | Simge                  | emoji, http(s) URL veya yerleşik örnek adı | ☕ | Hayır | `emoji_*.webp`, `lifeup_sample_*` veya URL olarak saklanır. Ad emojisi simgeyi ayarlamaz. |
| price           | Fiyat                 | [0, 999999]         | 10            | Hayır       | Varsayılan 0                    |
| stock_number    | Stok miktarı        | [-1, 99999]         | -1            | Hayır       | -1 sınırsız anlamına gelir              |
| action_text     | Eylem düğmesi metni    | herhangi bir metin             | rest          | Hayır       |                                 |
| disable_purchase| Satın almayı devre dışı bırak      | true veya false        | false         | Hayır       | Varsayılan false                |
| disable_use     | Kullanımı devre dışı bırak           | true veya false        | false         | Hayır       | Varsayılan false                |
| category        | Kategori kimliği           | 0'dan büyük veya eşit sayı | 0 | Hayır    | 0 varsayılan kategori          |
| order           | Görüntüleme sırası         | tam sayı              | 1             | Hayır       | Kategori içindeki konum            |
| purchase_limit  | Kısıtlama kuralları     | JSON metni            | Bkz. [Satın Alma Limiti Yapısı](#3-satin-alma-limiti-yapisi) | Hayır | Yapılandırılabilir satın alma/kullanım kısıtlamaları |
| limit_scope     | Kısıtlama kapsamı     | purchase / use / both | purchase | Hayır | Yalnızca `purchase_limit` boş değilken geçerlidir; varsayılan `purchase` |
| effects         | Kullanım efektleri           | JSON metni            | Bkz. [Eşya Efekti Yapısı](#4-esya-efekti-yapisi) | Hayır | Eşya kullanım efektleri |
| own_number      | Başlangıç sahip olunan miktar | tam sayı             | 0             | Hayır       | Başlangıç Envanter miktarını ayarlar  |
| unlist          | Mağazadan gizle        | true veya false        | false         | Hayır       | Varsayılan false                |

**Dönüş Verileri:**

| Alan    | Tür    | Açıklama    | Örnek | Notlar                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | Eşya kimliği        | 1000    | Oluşturulan eşyanın kimliği   |

!> `effects` parametresi `disable_use` değerini geçersiz kılar. Kullanılamaz bir eşyayı belirtmek için `effects` ayarlarsanız `disable_use` yok sayılır.

<br/>

#### Eşyayı Düzenle

?> v1.98.0+ gerektirir

**Yöntem adı:** item

**Açıklama:** Fiyat, stok, efektler ve diğer özellikler dahil mevcut eşyaları değiştirir

**Örnekler:**

- Fiyatı ayarla: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Efektleri değiştir: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - `effects` parametresinin çözümlenmiş içeriği: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parametre         | Anlam             | Değerler               | Örnek   | Gerekli | Notlar                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | Eşya kimliği             | 0'dan büyük sayı| 1         | Hayır*      | id veya name gerekli      |
| name             | Eşya adı           | herhangi bir metin             | Treasure  | Hayır*      | Bulanık arama için, yeniden adlandırma değil  |
| set_name         | Adı ayarla            | herhangi bir metin             | Treasure  | Hayır       | Boş olamaz                 |
| set_desc         | Açıklamayı ayarla     | herhangi bir metin             | Get gift  | Hayır       |                                |
| set_icon         | Simgeyi ayarla            | emoji, http(s) URL veya yerleşik örnek adı | ☕ | Hayır | `icon` ile aynı. Desteklenmeyen değerler `unsupported_parameter` döndürür. |
| set_price        | Fiyatı ayarla        | tam sayı              | 1         | Hayır       |                                |
| set_price_type   | Fiyat ayarlama yöntemi | absolute veya relative | relative  | Hayır       | absolute-doğrudan ayarla<br/>relative-ekle/çıkar |
| own_number       | Sahip olunan miktarı ayarla| tam sayı             | 1         | Hayır       | relative ile negatif değerler desteklenir |
| own_number_type  | Sahip olunan miktar ayarı| absolute veya relative| relative  | Hayır       | absolute-doğrudan ayarla<br/>relative-ekle/çıkar |
| stock_number     | Stoku ayarla        | [-1, 99999]         | 1         | Hayır       | -1 sınırsız stok anlamına gelir        |
| stock_number_type| Stok ayarlama yöntemi | absolute veya relative | relative  | Hayır       | absolute-doğrudan ayarla<br/>relative-ekle/çıkar |
| disable_purchase | Satın almayı devre dışı bırak    | true veya false        | false     | Hayır       | Varsayılan false              |
| disable_use      | Kullanımı devre dışı bırak         | true veya false        | false     | Hayır       | Varsayılan false              |
| action_text      | Kullan düğmesi metni     | herhangi bir metin             | Use       | Hayır       |                                |
| title_color_string| Başlık rengi        | renk dizesi         | #66CCFF   | Hayır       | # karakteri %23 olarak kaçırılmalıdır<br/>Boş değer varsayılanı geri yükler |
| effects          | Kullanım efektleri         | JSON metni            | Bkz. [Eşya Efekti Yapısı](#4-esya-efekti-yapisi) | Hayır | Eşya kullanım efektlerini ayarla |
| purchase_limit   | Kısıtlama kuralları   | JSON metni            | Bkz. [Satın Alma Limiti Yapısı](#3-satin-alma-limiti-yapisi) | Hayır | Tüm kısıtlamaları temizlemek için `null` geçin |
| limit_scope      | Kısıtlama kapsamı   | purchase / use / both | purchase | Hayır | Yalnızca bu alan sağlandığında güncellenir; `purchase_limit` boş olduğunda otomatik temizlenir |
| category_id      | Kategori kimliği         | sayı >= 0          | 1         | Hayır       | 0 varsayılan kategori         |
| order            | Görüntüleme sırası       | tam sayı              | 1         | Hayır       | Kategori içindeki konum           |
| unlist           | Mağazadan kaldır    | true veya false        | false     | Hayır       | Varsayılan false              |

!> Değiştirilecek eşyayı bulmak için id veya name parametresinden biri sağlanmalıdır

<br/>

#### Ganimet Kutusu efektini ayarla

**Yöntem adı:** loot_box

**Açıklama:** Belirtilen kutu eşyasının Ganimet Kutusu efektini değiştirir; olasılık, Ödül sayısı ayarlama ve içerik ekleme desteklenir. (Silme şimdilik desteklenmez)

**Örnek:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Açıklama:** Altın para kutusundaki [büyük] altın torbasının oranını 1 puan artır.

| Parametre   | Anlam                               | Tür                                                    | Örnek        | Gerekli | Notlar                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | eşya kimliği                               | 0'dan büyük sayı                                 | 1              | hayır*      | Nasıl alınacağı için yukarıdaki "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| name        | eşya adı                             | herhangi bir metin                                                | Treasure chest | hayır*      | Bilinmeyen kimlik için bulanık arama; ad değiştirme değil |
| sub_id      | içerik eşya kimliği                       | 0'dan büyük sayı                                 | 1              | hayır*      | kutu içeriğinin kimliği                                         |
| sub_name    | içerik eşya adı                     | herhangi bir metin                                                | Get a gift     | hayır*      | Kutu içeriğinin kimliği bilinmiyorsa bulanık arama için |
| set_type    | ayarlama yöntemi (absolute/relative) | şu değerlerden biri: <br/>absolute<br/>relative | relative       | hayır       | absolute - mutlak değer, yani hedefi doğrudan değere ayarla<br/>relative - göreli değer, orijinal değere ekleme veya çıkarma |
| amount      | içerik eşyası sayısı                | sayı                                                  | 1              | hayır       | tek bir eşya için Ödül sayısı                          |
| probability | içerik eşyası olasılığı       | sayı                                                  | 1              | hayır       | -                                                            |
| fixed       | sabit Ödül olup olmadığı          | boolean                                                 | true/false     | hayır       | -                                                            |

**Not:**

1. Bir ürünü aramak için id veya name sağlanmalıdır.
1. İçerik aramak için sub_id veya sub_name sağlanmalıdır.
1. `name` ve `sub_name` önce tam eşleşmeyi dener, ardından bulanık eşleşmeye geçer.
1. Eski `loot_box` API'si uyumluluk davranışını korur: aynı içerik eşyası farklı miktarlarla birden fazla kez görünürse ilk eşleşen giriş düzenlenir ve ayırt etmek için `sub_amount` kullanılmaz. Miktar bazlı düzenleme, silme veya birleştirme gerekiyorsa `loot_box/v2` kullanın.

<br/>

#### Ganimet Kutusu efektini ayarla (v2)

?> Bu API v1.104.2 sürümünde eklendi.

**Yöntem adı:** loot_box/v2

**Açıklama:** loot_box API'sinin geliştirilmiş sürümü. Belirtilen kutu eşyasının Ganimet Kutusu efektini değiştirir; olasılık, Ödül sayısı ayarlama, içerik ekleme ve **içerik silme** desteklenir.

**v1'e göre iyileştirmeler:**
- **Hassas eşleşme için `sub_amount`**: Kutu aynı eşyanın farklı miktarlarla birden fazla girişini içeriyorsa (ör. A x1 %50, A x2 %30) belirli bir girişi hedeflemek için `sub_amount` kullanın. Varsayılan değer `1`. Eşleşen giriş bulunamazsa LifeUp eşyayı `sub_id` / `sub_name` ile arar ve yeni giriş ekler; istek `amount=0` silme ise yeni giriş eklenmez.
- **Bağımsız `set_type`**: `amount_set_type` ve `probability_set_type` bağımsız olarak kontrol edilebilir. Genel `set_type` yedek varsayılan görevi görür.
- **Silme desteği**: `amount_set_type=absolute` ile `amount=0` ayarlamak (veya `relative` ile `<=0` hesaplamak) eşleşen girişi siler.
- **Yinelenen birleştirme**: `amount` değiştirmek aynı kutuda aynı eşya ve miktarla mevcut bir girişi yineleyecekse LifeUp mevcut girişe birleştirir ve isteğin `probability` / `fixed` değerlerini uygulamaya devam eder.

**Örnek:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Açıklama:** Altın para kutusundaki [büyük] altın torbasının (x2) olasılığını 10 puan artır.

| Parametre              | Anlam                               | Tür                                                    | Örnek        | Gerekli | Notlar                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | eşya kimliği                               | 0'dan büyük sayı                                 | 1              | hayır*      | Nasıl alınacağı için yukarıdaki "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| name                   | eşya adı                             | herhangi bir metin                                                | Treasure chest | hayır*      | Bilinmeyen kimlik için bulanık arama; ad değiştirme değil |
| sub_id                 | içerik eşya kimliği                       | 0'dan büyük sayı                                 | 1              | hayır*      | kutu içeriğinin kimliği. Hem sub_id hem sub_name sağlanırsa sub_id önceliklidir |
| sub_name               | içerik eşya adı                     | herhangi bir metin                                                | Get a gift     | hayır*      | Kutu içeriğinin kimliği bilinmiyorsa bulanık arama için |
| sub_amount             | eşleşme için içerik eşyası miktarı      | sayı                                                  | 2              | hayır       | Bu miktardaki bir girişi hassas eşleştirmek için kullanılır. Minimum `1`, varsayılan `1`. Eşleşme bulunamaz ve silme isteği değilse yeni giriş eklenir. |
| set_type               | genel ayarlama yöntemi              | şunlardan biri: `absolute` / `relative`                         | relative       | hayır       | Belirtilmezse `amount_set_type` ve `probability_set_type` için varsayılan |
| amount_set_type        | amount için ayarlama yöntemi          | şunlardan biri: `absolute` / `relative`                         | relative       | hayır       | amount alanı için `set_type` değerini geçersiz kılar                    |
| probability_set_type   | probability için ayarlama yöntemi     | şunlardan biri: `absolute` / `relative`                         | absolute       | hayır       | probability alanı için `set_type` değerini geçersiz kılar               |
| amount                 | içerik eşyası sayısı                | sayı                                                  | 1              | hayır       | tek bir eşya için Ödül sayısı. `0` (absolute) veya hesaplanan `<=0` (relative) girişi siler |
| probability            | içerik eşyası olasılığı       | sayı                                                  | 1              | hayır       | -                                                            |
| fixed                  | sabit Ödül olup olmadığı          | boolean                                                 | true/false     | hayır       | -                                                            |
| query                  | kutu içeriğini listele                     | true veya false                                           | true           | hayır       | v1.105.1+. Yalnızca eşya JSON döndürür; sub_id / sub_name gerekmez |

**Not:**

1. Bir ürünü aramak için id veya name sağlanmalıdır.
1. İçerik aramak için sub_id veya sub_name sağlanmalıdır. sub_id / sub_name olmadan içerikleri listelemek için `query=true` kullanın.
1. Hem `sub_id` hem `sub_name` sağlanırsa `sub_id` önceliklidir. `sub_name` yalnızca geçerli `sub_id` sağlanmadığında kullanılır.
1. `name` ve `sub_name` önce tam eşleşmeyi dener, ardından bulanık eşleşmeye geçer.
1. `sub_amount` varsayılan olarak `1`. Kutuda aynı eşyanın farklı miktarlarla birden fazla girişi varsa belirli bir girişi hedeflemek için `sub_amount` sağlayın. Eşleşme bulunamaz ve silme isteği değilse `amount=sub_amount` ile yeni giriş eklenir.
1. Bir girişi silmek için `amount_set_type=absolute` ile `amount=0` ayarlayın veya toplamı `<=0` yapan negatif değerle `amount_set_type=relative` kullanın. Silme yalnızca eşleşen girişler için geçerlidir; mevcut giriş eşleşmezse `amount=0` yeni giriş eklemez.
1. Bir girişin `amount` değerini değiştirmek aynı kutuda aynı eşya ve miktarla mevcut bir girişi yineleyecekse LifeUp mevcut girişe birleştirir ve isteğin `probability` / `fixed` değerlerini uygulamaya devam eder.
1. Silme kutuyu boş bıraktığında tüm Ganimet Kutusu efekti yumuşak silinir (eşyanın kendisi korunur ve Ganimet Kutusu girişlerini daha sonra yeniden ekleyebilirsiniz).

<br/>

#### Eşyaları kullan

?> Bu API v1.93.0-beta01 (502) sürümünde eklendi.

**Yöntem adı:** use_item

**Açıklama:** Belirtilen bir eşyayı kullanır.

**Örnek:**

- Bir jeton kutusu aç: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parametre | Anlam     | Tür                    | Örnek  | Gerekli | Notlar                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | Eşya kimliği     | 0'dan büyük sayı | 1        | Hayır*      | Eşya kimliğinin nasıl alınacağı için "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| name      | Eşya adı   | Herhangi bir metin                | coin_box | Hayır*      | Bilinmeyen kimlikler için; eşyalar üzerinde bulanık arama yapar      |
| use_times | Kullanım sayısı | 0'dan büyük sayı | 1        | Hayır       | Varsayılan 1 kez<br/>Normal eşyalar veya kutu açma için eşya miktarına karşılık gelir<br/>Basit Sentez eşyaları için bu değer tüketilen eşya sayısı yerine "sentez miktarına" karşılık gelir |

**Dönüş:**

!> Bu API çeşitli nedenlerle başarısız olabilir; belirli hata nedenleri dönüş değerlerinde sağlanabilir.

| Parametre | Anlam            | Tür     | Örnek          | Gerekli | Notlar                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Sonuç kodu        | sayı | 0                | Evet      | 0 - Başarılı kullanım<br/>1 - Veritabanı istisnası<br/>2 - Yetersiz Deneyim Puanı kısıtlaması<br/>3 - Eşya bulunamadı<br/>4 - Çalışan geri sayım çakışması<br/>5 - Yetersiz Envanter<br/>6 - Kullanılamaz eşya<br/>7 - Jeton limiti<br/>8 - Hedef stok limiti<br/>9 - Özellik seviye kısıtlaması<br/>10 - Zaman kısıtlaması<br/>11 - Sahip olunan eşya miktarı kısıtlaması<br/>12 - Görev tamamlama kısıtlaması<br/>13 - Başarım kilidi açma kısıtlaması<br/>14 - Dönem miktarı kısıtlaması<br/>15 - Görev döngüsü tamamlandı kısıtlaması |
| desc      | Sonuç açıklaması | Metin     | RunningCountDown | Evet      |                                                              |

<br/>

### ATM

**⚠ Yalnızca v1.91+ sürümünde kullanılabilir**

> Buradaki yatırma ve çekme işlemleri doğrulanır.
>
> ATM bakiyesini doğrudan ayarlamanız gerekiyorsa yukarıdaki "Shop Settings" arayüzüne bakın.

#### Yatırma

**Yöntem adı:** deposit

**Açıklama:** Yatırma işlemi geçerlilik açısından kontrol edilir (jeton bakiyesinin yeterli olup olmadığı).

**Örnek:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Açıklama:** 500 jeton yatır.

| Parametre | Anlam        | Tür                    | Örnek | Gerekli | Notlar |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | yatırma tutarı | 0'dan büyük sayı | 100     | evet      | -     |

**Dönüş:**

| Parametre | Anlam                              | Tür              | Örnek | Gerekli | Notlar |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | İşlemin başarılı olup olmadığı | `true` veya `false` | true    | evet      | -     |

<br/>

#### Çekme

**Yöntem adı:** withdraw

**Açıklama:** Çekme işlemleri geçerlilik açısından kontrol edilir (ATM bakiyesinin yeterli olup olmadığı).

**Örnek:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Açıklama:** 500 jeton çek.

| Parametre | Anlam           | Tür                    | Örnek | Gerekli | Notlar |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | çekme tutarı | 0'dan büyük sayı | 100     | evet      | -     |

**Dönüş:**

| Parametre | Anlam                              | Tür              | Örnek | Gerekli | Notlar |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | İşlemin başarılı olup olmadığı | `true` veya `false` | true    | evet      | -     |

<br/>

### Pomodoro Timer

**Yöntem adı:** pomodoro_timer

**Açıklama:** LifeUp'taki gerçek Pomodoro geri sayım veya yukarı sayım zamanlayıcısını kontrol eder. Bu API, App arayüzüyle aynı zamanlayıcı oturumunu başlatır; doğrudan Pomodoro kaydı veya domates eklemez.

**Örnekler:**

- Varsayılan çalışma geri sayımını başlat veya devam ettir:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Yukarı sayım zamanlayıcısını başlat ve Görev 101'i seç:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Etkin geri sayımı duraklat:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Pomodoro yaşam döngüsünü bırak ve sıfırla:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Geçerli Pomodoro aşamasını atla:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Domates Ödülü almadan yukarı sayım zamanlayıcısını sonlandır:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Her iki zamanlayıcı modunu sorgula:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parametreler:**

| Parametre | Anlam | Tür / değerler | Gerekli | Notlar |
| --------- | ------- | ------------- | -------- | ----- |
| action | İşlem | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | evet | - |
| mode | Zamanlayıcı modu | `countdown`, `count_up` | `start`, `pause`, `abandon` ve `complete` için | `skip` her zaman geri sayımı hedefler. |
| stage | Geri sayım aşaması | `work`, `short_break`, `long_break` | hayır | Yalnızca `mode=countdown` ile geçerlidir. Atlanırsa etkin, duraklatılmış veya sıradaki kanonik aşama kullanılır; yeni yaşam döngüsü `work` ile başlar. |
| receive_reward | Domates Ödülü alınıp alınmayacağı | `true` veya `false` | `complete` için | Katı boolean. `complete` yalnızca `mode=count_up` destekler. |
| task_id | Görev kimliği | pozitif tam sayı | hayır | `task_gid` veya `task_name` ile birleştirilemez. |
| task_gid | Görev grup kimliği | pozitif tam sayı | hayır | Eşleşmeyi daraltmak için `task_name` ile birleştirilebilir. |
| task_name | Görev adı | metin | hayır | Tam eşleşme tercih edilir, yedek olarak bulanık eşleşme. |
| clear_task | Zamanlayıcı Görevini temizle | `true` veya `false` | hayır | `true`, bir Görev bulucu ile birleştirilemez. |

`select_task` bir Görev bulucu veya `clear_task=true` gerektirir. `start` aynı Görev seçim parametrelerini içerebilir. Özel süre parametreleri desteklenmez: geri sayımlar geçerli varsayılan süreyi veya seçilen Görevin Pomodoro süresini kullanır.

`abandon&mode=countdown`, App'teki sol eyleme eşdeğerdir: geçerli aşamadan vazgeçer, Pomodoro yaşam döngüsünü sıfırlar ve durdurulmuş bir çalışma aşamasına döner. `skip` sağ eyleme eşdeğerdir: çalışmayı kısa/uzun molaya veya molayı çalışmaya ilerletir, sonraki aşamayı otomatik başlatmaz. Her `skip` çağrısı gerçek, idempotent olmayan bir eylemdir; çağıranlar bunu otomatik olarak yeniden denememelidir.

`complete&mode=count_up` gerçek yukarı sayım oturumunu sonlandırır. 30 saniyeden kısa oturumlar kayıt oluşturmadan tüketilir. `receive_reward=false` ile eşiği karşılayan bir kayıt yine de terk edilmiş olarak kaydedilir ancak domates verilmez.

**Görev değiştirme kuralları:**

- Çalışan bir çalışma geri sayımı Görev değişikliklerini reddeder.
- Çalışan bir yukarı sayım zamanlayıcısı Görev değişikliklerine izin verir ve bildirimini günceller.
- Duraklatılmış bir geri sayım Görev değişikliklerine izin verir, geçen süreyi korur ve toplam süreyi yeni Görev ayarlarından yeniden hesaplar.

**Başarılı dönüş değerleri:**

| Parametre | Anlam | Tür |
| --------- | ------- | ---- |
| api_result | API çağrısının başarılı olup olmadığı | boolean |
| applied | Bu çağrının zamanlayıcı durumunu değiştirip değiştirmediği | boolean |
| mode | Hedef veya şu an seçili zamanlayıcı modu | `countdown` veya `count_up` |
| state | `mode` durumu | `running`, `paused` veya `stopped` |
| selected_task_id | Geçerli zamanlayıcı Görev kimliği veya `0` | number |
| can_start_in_background | Android'in şu anda arka planda zamanlayıcı başlatmaya izin verip vermediği | boolean |
| countdown_state | Kanonik geri sayım durumu | `running`, `paused` veya `stopped` |
| countdown_phase | Geri sayım yaşam döngüsü aşaması | `idle`, `running`, `paused`, `completing`, `completed` veya `cancelled` |
| countdown_stage | Kanonik geri sayım aşaması | `work`, `short_break` veya `long_break` |
| countdown_session_id | Kanonik geri sayım oturum kimliği | text veya null |
| countdown_total_millis | Geri sayım toplam süresi | milisaniye |
| countdown_remaining_millis | Geri sayım kalan süresi | milisaniye |
| count_up_state | Kanonik yukarı sayım durumu | `running`, `paused` veya `stopped` |
| count_up_elapsed_millis | Yukarı sayım geçen süresi | milisaniye |
| battery_optimization_ignored | LifeUp'ın pil optimizasyonundan muaf olup olmadığı | boolean |

Başarılı `complete` yanıtları ek olarak `record_created`, `reward_tomatoes` ve `settled_elapsed_millis` içerir.

İstenen durumla zaten eşleşen tekrarlanan `start`, `pause` veya `abandon` çağrıları `applied=false` ile başarılı olur. Değiştiren çağrılar süreçler arası yeniden deneme tekilleştirmesi sağlamaz.

**Hatalar:**

Başarısızlıklar `api_result=false`, `error_code` ve `error_message` döndürür. Zamanlayıcıya özgü kararlı hata kodları:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

Android 12 ve sonrasında arka plandaki bir ContentProvider çağrısı yalnızca LifeUp'ın pil optimizasyonunu yok saymasına izin verildiğinde zamanlayıcı başlatabilir. Aksi halde zamanlayıcı durumu değiştirilmeden önce `background_start_not_allowed` döndürülür. URL Scheme'i Activity üzerinden açmak, başlatmadan önce LifeUp'ı ön plana getirir. Android, üçüncü taraf bir App'in bu Activity'yi arka plandan başlatmasını engelleyebilir; bu durumda LifeUp hiçbir API çağrısı almaz ve hata döndüremez.

<br/>

### Pomodoro Record

#### Pomodoro Kaydı Ekle

**Yöntem adı:** add_pomodoro

**Açıklama:** Domates zamanlama kaydı ekler

**Örnek:**

- 25 dakika (1500000 ms) süreli bir zamanlama kaydı ekle ve adında learning geçen bir Göreve bağla: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- `2022-08-01 11:00:00` - `2022-08-01 12:00:00` için zamanlama kaydı ekle: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Açıklama:**

| Parametre        | Anlam                    | Tür                    | Örnek       | Gerekli | Notlar |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | zamanlama başlangıç zamanı          | timestamp               | 1659322800000 | hayır*      | Timestamp hakkında bilginiz yoksa google'da arayın! |
| duration         | Odak süresi             | sayı (milisaniye cinsinden) <br/>30000'den büyük olmalı | 1500000 | hayır* | |
| end_time         | zamanlama bitiş zamanı            | timestamp               | 1659326400000 | hayır*      |       |
| reward_tomatoes  | domates Ödülü verilip verilmeyeceği | true veya false           | true          | hayır       | varsayılan false |
| task_id          | görev kimliği                    | 0'dan büyük sayı | 1             | hayır       |       |
| task_gid         | görev grup kimliği              | 0'dan büyük sayı | 1             | hayır       |       |
| task_name        | ad                       | herhangi bir metin                | learning      | hayır       | bulanık arama, bulunan Görevlerden yalnızca biri |
| ui               | Ödüllendirilen domates arayüzünü göster | true veya false         | true          | hayır       | v1.94.0'da eklendi, varsayılan true |

**Not:**

1. start_time, duration, end_time parametrelerinden biri sağlanmalıdır.
2. Yalnızca duration verildiğinde varsayılan end_time geçerli zamandır.
3. end_time, start_time'dan büyük olmalıdır.
4. duration en az 30000 milisaniye (30 saniye) olmalıdır.
5. start_time, duration ve end_time birlikte sağlanırsa duration, (end_time - start_time) değerinden küçük veya ona eşit olmalıdır.

<br/>

#### Pomodoro Kaydını Düzenle

> v1.94.0'da eklendi
> **Yöntem adı:** edit_pomodoro

**Açıklama:** Mevcut bir Pomodoro zamanlama kaydını düzenler veya geçerli bir `edit_item_id` sağlandığında yeni kayıt ekler.

**Örnek:**

- Belirtilen kimlikli bir kaydı düzenle, süreyi 45 dakika (2700000 ms) yap ve domates Ödülü ver: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Başlangıç ve bitiş zamanına göre kayıt düzenle: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parametreler:**

| Parametre       | Anlam                    | Tür                  | Örnek       | Gerekli | Notlar                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | Görev kimliği                    | 0'dan büyük sayı | 101           | Hayır       | Görevin benzersiz tanımlayıcısı                   |
| task_gid        | Görev grup kimliği              | 0'dan büyük sayı | 5             | Hayır       | Sağlanırsa task_id değerini geçersiz kılar                |
| task_name       | Görev adı                  | Herhangi bir metin              | Study         | Hayır       | task_id veya task_gid sağlanmadıysa gerekli   |
| start_time      | Zamanlama başlangıç zamanı          | Timestamp             | 1659322800000 | Hayır*      | Timestamp nedir anlamak için google'da arayabilirsiniz     |
| end_time        | Zamanlama bitiş zamanı            | Timestamp             | 1659326400000 | Hayır*      | -                                                |
| duration        | Odak süresi             | Sayı (milisaniye) | 2700000       | Hayır*      | En az 30000 milisaniye (30 saniye) olmalı |
| reward_tomatoes | Domates Ödülü verilip verilmeyeceği | true veya false         | true          | Hayır       | Varsayılan false                                 |
| edit_item_id    | Düzenlenecek öğenin kimliği     | 0'dan büyük sayı | 123           | Evet      | Düzenlenecek kayıt kimliğini belirtir                  |
| ui              | Domates Ödülü arayüzünü göster | true veya false         | true          | Hayır       |                                                  |
| delete          | Kaydı sil          | true veya false         | true          | Hayır       | v1.105.1+. Pomodoro kaydını yumuşak siler (`isDel`), App ile aynı |

**Dönüş değerleri:**

| Parametre | Anlam                          | Tür   | Örnek | Gerekli | Notlar                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Bu eylemden kazanılan domatesler | Number | 2       | Hayır       | `ui` true ise döndürülür |

**Notlar:**

1. `start_time`, `duration`, `end_time` parametrelerinden en az biri sağlanmalıdır.
2. `end_time`, `start_time` değerinden büyük olmalıdır.
3. `duration`, (`end_time` - `start_time`) değerinden küçük veya ona eşit olmalıdır.
4. `edit_item_id` sağlanır ve ilgili kayıt bulunursa düzenlenir; aksi halde diğer parametrelere göre yeni kayıt oluşturulur.

<br/>


### Başarım Kilidi Açma Koşulları

**Yöntem adı:** unlock_condition

**Açıklama:** Başarım kilidi açma koşulu: kilidin açılması için harici bir API çağrısı gerekir

**Örnek:**

- Kilidi açma koşulu kimliği 2 olan koşulu çağır: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parametre | Anlam      | Tür                  | Örnek | Gerekli | Notlar |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | koşul kimliği | 0'dan büyük sayı | 2       | evet      |       |

<br/>

### Başarımı Tamamla / Ödülü Al

?> Bu API v1.105.1 sürümünde eklendi.

**Yöntem adı:** complete_achievement

**Açıklama:** Manuel bir Başarımı tamamlar ve Ödülünü alır veya kilidi zaten açılmış otomatik bir Başarımın Ödülünü alır. App'te tamamlama onay kutusuna / Ödül al düğmesine dokunmakla aynı davranış.

**Örnek:**

- Kimliği 1 olan Başarımı tamamla veya Ödülünü al: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parametre | Anlam        | Tür                  | Örnek | Gerekli | Notlar |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | Başarım kimliği | 0'dan büyük sayı | 1       | evet      |       |

**Dönüş değeri:**

| Alan  | Tür   | Açıklama | Örnek | Notlar |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | Başarım kimliği | 1 | |
| status | number | çağrı sonrası durum | 2 | `0` kilitli · `1` kilidi açık, Ödül alınmadı · `2` kilidi açık, Ödül alındı |

**Notlar:**

1. Manuel Başarımlar (kilidi açma koşulu yok): hâlâ kilitliyse bu çağrı Başarımı tamamlar ve Ödülleri verir.
2. Otomatik Başarımlar (kilidi açma koşulu var): yalnızca kilidi zaten açılmış ve bekleyen bir Ödül varken Ödül alır. Koşullar karşılanmazsa çağrı `error_code=achievement_not_unlocked` ile başarısız olur.
3. Ödül zaten alındıktan sonra tekrar çağrıldığında `status=2` ile başarılı olur ve Ödüller iki kez verilmez.
4. Bu, yalnızca kilidi açma durumunu yazar ve Ödül vermeyen `achievement?unlocked=true` çağrısından farklıdır.

<br/>

### Adım Sayısını Ayarla

**Yöntem adı:** step

**Açıklama:** Belirtilen tarihteki adım sayısını ayarlar; örneğin bileklik + otomasyon aracıyla adım sayısını girmek için kullanılabilir. Geçmiş kayıtları değiştirmek için de kullanılabilir.

**Örnek:**

- GMT+8 saat diliminde 2022-10-21 için adım sayısını 9999 olarak ayarla: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parametre | Anlam                         | Tür                                | Örnek       | Gerekli | Notlar |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | adım sayısı                 | 0 veya daha büyük sayı | 9999          | evet      |       |
| time      | tarihin rastgele zaman damgası | timestamp (ms)                      | 1666282995643 | evet      |       |

<br/>

### Deneyim Puanını Düzenle

?> Bu API v1.93.0-beta01 (502) sürümünde eklendi.

**Yöntem adı:** edit_exp

**Açıklama:** Bu API, Özellikler için mevcut Deneyim Puanı değerlerini toplu olarak ayarlayabilir. Belirli bir Deneyim Puanı değerini veya belirli bir Seviyeyi doğrudan ayarlayabilir.

**Örnek:**

> Bu API verileri etkiler; yanlışlıkla kullanımı önlemek için burada doğrudan tıklanabilir bağlantılar verilmemiştir.

- [Strength] ve [Knowledge] Özelliklerinin Deneyim Puanı değerlerini 0'a sıfırla: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- [Charm] Özelliğinin Deneyim Puanını doğrudan 50. Seviyeye ayarla: lifeup://api/edit_exp?skills=3&level=50

| Parametre | Anlam              | Tür                                      | Örnek | Gerekli | Notlar |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | Özellik (Yetenek) kimliği | 0'dan büyük sayı dizisi           | 1       | Hayır       | Dizi desteklenir (ör. &skills=1&skills=2&skills=3)<br/>Özellik kimliğini almak için "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |
| exp       | Deneyim Puanı değerini ayarla | 0 veya daha büyük sayı (int32) | 9999    | Hayır, ancak exp veya level sağlanmalıdır |                                                               |
| level     | Seviyeyi ayarla            | 0 veya daha büyük sayı (int32) | 50      | Hayır, ancak exp veya level sağlanmalıdır | Belirli bir Seviyenin başlangıç Deneyim Puanı değerini temsil eder<br/>ve özel seviye eğrilerinden etkilenir. |

<br/>

### Duygu Ekle veya Düzenle

?> Bu API v1.93.4 (536) sürümünden itibaren kullanılabilir.

**Yöntem adı:** feeling

**Açıklama:** Duygu kayıtlarını oluşturmak veya güncellemek için kullanılır.

**Örnek:**

- Yeni bir Duygu kaydı oluştur: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Mevcut bir Duygu kaydını güncelle ve favori olarak işaretle: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Bir Duyguyu sil: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parametre            | Anlam           | Tür                               | Örnek           | Gerekli | Notlar                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | Duygu kaydı kimliği | 0'dan büyük sayı              | 1                 | Hayır       | Sağlanırsa yöntem belirli bir kaydı güncellemeye çalışır. Silme sırasında gerekli.                                                                                                                                                           |
| content              | İçerik           | Herhangi bir metin                           | Happy             | Hayır       | Yeni kayıt oluşturmak veya mevcut kaydın içeriğini güncellemek için kullanılır                                                                                                                                                                    |
| time                 | Zaman damgası         | Unix timestamp                     | 1633036800        | Hayır       | Kaydın zamanı; varsayılan geçerli zaman                                                                                                                                                                                             |
| is_favorite          | Favori bayrağı     | true veya false                      | true              | Hayır       | Kaydı favori olarak işaretler veya işaretlemez                                                                                                                                                                                                        |
| delete               | Sil            | true veya false                      | true              | Hayır       | v1.105.1+. Duyguyu App ile aynı şekilde yumuşak siler (ekler kaldırılır).                                                                                                                                                       |
| relate_type          | İlişki türü     | 0 ile 3 arasında sayı             | 1                 | Hayır       | Kayıtla ilişkili ilişki türünü belirtir:<br/>0: Görev<br/>1: Özel Başarım<br/>2: İlişki yok<br/>3: Eşya kullanımı                                                                                                        |
| relate_id            | İlişkili kimlik        | 0'dan büyük sayı              | 2                 | Hayır       | İlişkili öğenin kimliğini belirtir:<br/>relate_type 0 iken: Görev kimliğini temsil eder<br/>relate_type 1 iken: Başarım kimliğini temsil eder<br/>relate_type 3 iken: Eşya kimliğini temsil eder<br/>relate_type 2 iken: kimlik gerekmez                |
| usage_count          | Kullanım sayısı       | 1'den büyük tamsayı             | 1                 | Hayır       | Yalnızca relate_type 3 (Eşya kullanımı) iken geçerli; Eşyanın kullanım sayısını kaydeder.                                                                                                                                                          |
| image_uris           | Görsel URI'leri        | URI dizesi listesi                |                   | Hayır       | Yerel dosya URI'lerini (file://) veya uzak web görsellerini (http/https) destekler. Dizi desteklenir (ör. &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Güncelleme modu       | APPEND veya REPLACE | REPLACE           | Hayır       | Yalnızca mevcut bir kaydı güncellerken ve image_uris sağlarken geçerli.<br/>APPEND: Mevcut görsellere ekler.<br/>REPLACE: Mevcut görsellerin yerine geçer (varsayılan).                                                               |
    
**Not:**

1. `id` parametresi sağlanırsa yöntem ilgili Duygu kaydını güncellemeye çalışır. Eşleşen kayıt bulunamazsa istisna fırlatılır.
2. `id` sağlanmaz ancak `content` sağlanırsa yöntem yeni bir Duygu kaydı oluşturur.

<br/>

### Domates Sayısı

?> v1.98.0+ gerekir

**Yöntem adı:** tomato

**Açıklama:** Domates sayısını ayarlar (artır, azalt veya belirli bir miktara ayarla)

**Örnekler:**

- 1 domates ekle: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- 2 domates çıkar: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Pomodoro sayısını 10'a ayarla: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parametre | Anlam        | Değerler                                        | Örnek   | Gerekli | Notlar                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | İşlem türü | Şunlardan biri:<br/>increase<br/>decrease<br/>set     | increase  | Hayır       | increase - Pomodoro ekle (varsayılan)<br/>decrease - Pomodoro çıkar<br/>set - Pomodoro sayısını belirtilen değere ayarla |
| number    | Miktar         | Tamsayı                                       | 1         | Evet      | action'a göre farklı anlamlar:<br/>increase/decrease - Eklenecek/çıkarılacak miktar<br/>set - Hedef miktar |

**Yanıt:**

| Alan    | Tür    | Açıklama              | Örnek |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Geçerli pomodoro sayısı   | 10      |

<br/>

### Eşya Satın Al

?> v1.98.0+ gerekir

**Yöntem adı:** purchase_item

**Açıklama:** Belirli bir Eşyayı satın alır

**Örnekler:**

- Kimliği 1 olan Eşyayı satın al: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- "Health Potion" adlı Eşyayı satın al: [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Kimliği 1 olan Eşyadan 5 adet satın al: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Eşyada `purchase_limit` yapılandırılmış ve `limit_scope` `purchase` içeriyorsa bu API bu kısıtlamaları da uygular.

| Parametre         | Anlam          | Değerler                | Örnek       | Gerekli | Notlar                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | Eşya kimliği          | 0'dan büyük sayı | 1             | Hayır*      | id veya name gerekli |
| name              | Eşya adı        | herhangi bir metin              | Health Potion | Hayır*      | id veya name gerekli |
| purchase_quantity | Satın alma miktarı| 0'dan büyük sayı | 5             | Hayır       | Varsayılan 1              |

**Yanıt:**

| Alan  | Tür    | Açıklama        | Örnek         | Notlar                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | Eşya kimliği            | 1               | Başarılı satın almada döndürülür  |
| result | Integer | Sonuç kodu        | 0               | Aşağıdaki sonuç kodlarına bakın      |
| desc   | Text    | Sonuç açıklaması | PurchaseSuccess | Aşağıdaki sonuç kodlarına bakın      |

**Sonuç Kodları:**

| Kod | Açıklama               | Notlar                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Satın alma başarılı            |
| 1    | DatabaseError             | Veritabanı hatası                |
| 2    | NotEnoughCoin             | Yeterli jeton yok              |
| 3    | ItemNotFound              | Eşya bulunamadı                |
| 4    | PurchaseAndUseSuccess     | Satın alma ve kullanma başarılı    |
| 5    | PurchaseSuccessAndUseFailure | Satın alma başarılı ancak kullanma başarısız |
| 6    | NotPurchaseable           | Satın alma Eşya ayarları veya kısıtlamalar tarafından engellendi |
| 7    | OutOfStock                | Mağaza stoğu yetersiz      |

<br/>

### Sentez

?> v1.98.0+ gerekir

**Yöntem adı:** synthesize

**Açıklama:** Mevcut bir formül kullanarak Eşyaları sentezler

**Örnekler:**

- Kimliği 1 olan formülle bir kez sentezle: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Kimliği 1 olan formülle 5 kez sentezle: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Yayın davranışı:**

- Bu API **tarif sentezi** içindir.
- `Broadcast events` etkin ve sentez başarılı olduğunda LifeUp ayrıca `app.lifeup.synthesis.complete` yayın olayını gönderir.
- Bu olay `use_item` içindeki basit sentez için **gönderilmez**; o yol hâlâ `app.lifeup.item.use` kapsamındadır.

| Parametre | Anlam            | Değerler                | Örnek | Gerekli | Notlar                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formül kimliği        | 0'dan büyük sayı | 1       | Evet      | Sentez formülünün kimliği  |
| times     | Tekrar sayısı   | 0'dan büyük sayı | 5       | Hayır       | Varsayılan 1           |

**Yanıt:**

| Alan           | Tür    | Açıklama     | Örnek          | Notlar                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formül kimliği      | 1                |                          |
| result         | Integer | Sonuç kodu     | 0                | Aşağıdaki sonuç kodlarına bakın   |
| desc           | Text    | Sonuç açıklaması | SynthesisSuccess | Aşağıdaki sonuç kodlarına bakın |
| synthesisResults| Text   | Sentez sonuçları | {...}           | Yalnızca başarıda döndürülür |

**Sonuç Kodları:**

| Kod | Açıklama          | Notlar                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Sentez başarılı  |
| 1    | FormulaNotFound     | Formül bulunamadı     |
| 2    | InsufficientMaterials| Yeterli malzeme yok |
| 3    | DatabaseError       | Veritabanı hatası        |
| 4    | UnknownError        | Diğer hatalar         |

<br/>

### Sentez Formülü Yönetimi

?> v1.98.0+ gerekir

**Yöntem adı:** synthesis_formula

**Açıklama:** Sentez formüllerini oluşturur, değiştirir veya siler

**Örnekler:**

- Yeni bir formül oluştur: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Burada inputItems: `[{"item_id": 296, "amount": 88}]`
  - Burada outputItems: `[{"item_id": 295, "amount": 1}]`
- Formülü sil: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parametre   | Anlam        | Değerler                | Örnek                        | Gerekli | Notlar                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formül kimliği     | 0'dan büyük sayı | 1                             | Hayır       | Değiştirme veya silme için gerekli  |
| delete      | Silme bayrağı    | true veya false        | true                          | Hayır       | Yalnızca silme için kullanılır         |
| inputItems  | Girdi Eşyaları    | Eşya dizisi, aşağıya bakın | [{"item_id":1,"amount":2}]     | Evet      | Oluşturma veya değiştirme için gerekli  |
| outputItems | Çıktı Eşyaları   | Eşya dizisi, aşağıya bakın | [{"item_id":3,"amount":1}]     | Evet      | Oluşturma veya değiştirme için gerekli  |
| category    | Kategori kimliği    | 0'dan büyük sayı | 1                             | Hayır       | Varsayılan ortak kategori    |

!> inputItems ve outputItems, her öğede item_id ve amount alanlarını içeren JSON dizileridir. Tüm Eşya kimlikleri mevcut olmalı ve miktarlar 0'dan büyük olmalıdır

**Yanıt:**

| Alan     | Tür    | Açıklama      | Örnek     | Notlar                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formül kimliği       | 1           | Başarıda döndürülür      |
| result    | Integer | Sonuç kodu      | 0           | Aşağıdaki sonuç kodlarına bakın   |
| desc      | Text    | Sonuç açıklaması | AddSuccess | Aşağıdaki sonuç kodlarına bakın   |

**Sonuç Kodları:**

| Kod | Açıklama     | Notlar             |
| ---- | -------------- | ----------------- |
| 0    | Success        | İşlem başarılı |
| 1    | Failed         | İşlem başarısız  |

<br/>

### Alt Görev Yönetimi

?> v1.98.0+ gerekir

**Yöntem adı:** subtask

**Açıklama:** Alt görevleri oluşturur veya düzenler

**Örnekler:**

- Ana Görev kimliği 1'e alt görev ekle: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Alt görevi düzenle ve Ödülleri ayarla: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parametre     | Anlam            | Değerler                | Örnek    | Gerekli | Notlar                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | Ana Görev kimliği       | 0'dan büyük sayı | 1         | Hayır*      | main_id, main_gid veya main_name gerekli |
| main_gid     | Ana Görev grup kimliği | 0'dan büyük sayı | 1         | Hayır*      | main_id, main_gid veya main_name gerekli |
| main_name    | Ana Görev adı     | herhangi bir metin             | Study task | Hayır*      | main_id, main_gid veya main_name gerekli |
| edit_id      | Düzenlenecek alt görev kimliği | 0'dan büyük sayı | 2         | Hayır*      | Düzenlerken edit_id, edit_gid veya edit_name gerekli; oluşturmada gerekmez |
| edit_gid     | Alt görev grup kimliği   | 0'dan büyük sayı | 2         | Hayır*      | Düzenlerken edit_id, edit_gid veya edit_name gerekli; oluşturmada gerekmez |
| edit_name    | Alt görev adı       | herhangi bir metin             | Do homework| Hayır*      | Düzenlerken edit_id, edit_gid veya edit_name gerekli; oluşturmada gerekmez |
| todo         | Görev içeriği       | herhangi bir metin             | Do homework| Hayır       | Yeni alt görev oluştururken gerekli |
| remind_time  | Hatırlatma zamanı      | timestamp (milisaniye)| 1640995200000 | Hayır | Hatırlatmayı temizlemek için null geçin    |
| order        | Sıra              | tamsayı              | 1          | Hayır       | Görev listesindeki konum           |
| coin         | Jeton Ödülü        | [0, 999999]         | 10         | Hayır       | Tamamlandığında kazanılan jetonlar    |
| coin_var     | Jeton varyansı      | tamsayı              | 5          | Hayır       | Jeton Ödülünde rastgele varyans  |
| exp          | Deneyim Puanı Ödülü  | [0, 99999]          | 5          | Hayır       | Kazanılan Deneyim Puanı        |
| auto_use_item| Eşyayı otomatik kullan      | true veya false        | true       | Hayır       | Tamamlandığında Eşyayı otomatik kullanılıp kullanılmayacağı |
| item_id      | Eşya kimliği            | 0'dan büyük sayı | 1         | Hayır*      | item_id veya item_name gerekli |
| item_name    | Eşya adı          | herhangi bir metin             | Health Potion| Hayır*    | item_id veya item_name gerekli |
| item_amount  | Eşya miktarı        | 0'dan büyük sayı | 1         | Hayır       | Yalnızca Eşya Ödülü ayarlarken geçerli |
| items        | Eşyalar JSON         | JSON metni            | [{"item_id":1,"amount":1}] | Hayır | Birden fazla Eşya Ödülünü aynı anda ayarlar |
| coin_set_type     | Jeton değerini ayarlama biçimi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - jetonu doğrudan değere ayarlar<br/>relative - orijinal jeton değerine ekler/çıkarır |
| exp_set_type      | exp değerini ayarlama biçimi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - exp'yi doğrudan değere ayarlar<br/>relative - orijinal exp değerine ekler/çıkarır |

**Yanıt:**

| Alan        | Tür    | Açıklama      | Örnek | Notlar            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Ana Görev kimliği     | 1       |                  |
| subtask_id   | Number  | Alt görev kimliği       | 2       |                  |
| subtask_gid  | Number  | Alt görev grup kimliği | 3       | Boş olabilir     |

<br/>

### Kategori Yönetimi

?> v1.98.0+ gerekir

**Yöntem adı:** category

**Açıklama:** Kategorileri ekler veya düzenler (Görev listeleri, Başarım listeleri, Mağaza listeleri, Sentez listeleri)

**Örnekler:**

- Görev listesi oluştur: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Mağaza listesini düzenle: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parametre        | Anlam           | Değerler               | Örnek    | Gerekli | Notlar                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Kategori türü     | Şunlardan biri:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Evet | tasks - Görev listeleri<br/>achievements - Başarım listeleri<br/>shop - Mağaza listeleri<br/>synthesis - Sentez listeleri |
| edit_id         | Düzenlenecek kategori kimliği| 0'dan büyük sayı| 1         | Hayır       | Düzenlerken gerekli           |
| name            | Kategori adı     | herhangi bir metin             | Study List | Hayır       | Yeni kategoriler için gerekli; düzenlerken isteğe bağlı |
| order           | Sıralama düzeni        | tamsayı              | 1         | Hayır       | Listedeki konum            |
| hidden          | Kategoriyi gizle     | true veya false        | false     | Hayır       | tasks=arşiv; shop=Mağazada gizle; synthesis=gizle. Başarım listeleri ve Sentez ALL listesi `unsupported_parameter` ile reddeder. `false` gizlemeyi kaldırır |
| inventory_hidden| Envanterde gizle | true veya false        | false     | Hayır       | Yalnızca Mağaza listeleri için desteklenir   |
| icon_uri        | Simge URI'si          | emoji, http(s) URL, content URI veya boş | 🏆 | Hayır | Yalnızca Başarım listeleri için desteklenir. Emoji `emoji_*.webp` olarak saklanır. Boş değer temizler. |
| desc            | Açıklama       | herhangi bir metin             | This is a description | Hayır | Yalnızca Başarım listeleri için desteklenir |
| color           | Etiket rengi         | renk dizesi         | #66CCFF   | Hayır       | Yalnızca Görev listeleri için desteklenir; # %23 olarak kaçırılmalıdır |

**Yanıt:**

| Alan | Tür    | Açıklama    | Örnek | Notlar                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Kategori kimliği    | 1000    | Yeni veya düzenlenen kategorinin kimliği |

<br/>

### Yedek Dışa Aktar

?> v1.98.0+ gerekir

**Yöntem adı:** export_backup

**Açıklama:** Yedek dosyası oluşturur ve URI'sini döndürür (yalnızca Content Provider çağrıları)

!> Bu API yalnızca Content Provider üzerinden çağrılabilir; doğrudan URL Scheme çağrıları desteklenmez

| Parametre      | Anlam        | Değerler          | Örnek | Gerekli | Notlar                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Medya dosyalarını dahil et | true veya false | true    | Hayır       | Yedekte medya dosyalarının (görseller, ses efektleri vb.) dahil edilip edilmeyeceği<br/>Varsayılan true |
| callingPackage| Çağıran paket adı | herhangi bir metin      | com.example.app | Hayır | Content Provider çağrıları için paket tanımlayıcısı |

**Yanıt:**

| Alan          | Tür   | Açıklama          | Örnek                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | Yedek dosyası URI'si      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Alt Görev İşlemi

?> v1.98.0+ gerekir

**Yöntem adı:** subtask_operation

**Açıklama:** Alt görevleri tamamlar, tamamlamayı geri alır veya siler

**Örnekler:**

- Alt görevi tamamla: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Alt görevi sil: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Alt görev tamamlamasını geri al: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parametre     | Anlam          | Değerler               | Örnek    | Gerekli | Notlar                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | Ana Görev kimliği     | 0'dan büyük sayı| 1         | Hayır*      | main_id, main_gid veya main_name gerekli |
| main_gid     | Ana Görev grup kimliği| 0'dan büyük sayı| 1        | Hayır*      | main_id, main_gid veya main_name gerekli |
| main_name    | Ana Görev adı   | herhangi bir metin            | Study task | Hayır*      | main_id, main_gid veya main_name gerekli |
| edit_id      | Alt görev kimliği       | 0'dan büyük sayı| 2         | Hayır*      | edit_id, edit_gid veya edit_name gerekli |
| edit_gid     | Alt görev grup kimliği | 0'dan büyük sayı| 2         | Hayır*      | edit_id, edit_gid veya edit_name gerekli |
| edit_name    | Alt görev adı     | herhangi bir metin            | Do homework| Hayır*      | edit_id, edit_gid veya edit_name gerekli |
| operation    | İşlem türü   | Şunlardan biri:<br/>complete<br/>undo_complete<br/>delete | complete | Evet | complete - Görevi tamamla<br/>undo_complete - Tamamlamayı geri al<br/>delete - Görevi sil |

**Yanıt:**

| Alan        | Tür    | Açıklama      | Örnek | Notlar            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Ana Görev kimliği     | 1       |                  |
| subtask_id   | Number  | Alt görev kimliği       | 2       |                  |
| subtask_gid  | Number  | Alt görev grup kimliği | 3       | Boş olabilir     |

<br/>

### Başarım Yönetimi

?> v1.98.0+ gerekir

**Yöntem adı:** achievement

**Açıklama:** Özel Başarımları ve Başarım alt kategorilerini ekler veya düzenler

**Örnekler:**

- Başarım oluştur: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Bu örneği test etmek için `category_id` değerini gerçek Başarım listeniz kimliğiyle değiştirmeniz gerekebilir
- Kilidi açma koşullu Başarım oluştur: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Bu örneği test etmek için `category_id` değerini gerçek Başarım listeniz kimliğiyle değiştirmeniz gerekebilir
  - `conditions_json` çözümlenmiş içeriği: `[{"type":7,"target":1000000}]`
- Mevcut Başarımı düzenle: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Başarım Parametreleri

| Parametre      | Anlam           | Değerler               | Örnek   | Gerekli | Notlar                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | Düzenlenecek Başarım kimliği | 0'dan büyük sayı | 1      | Hayır       | Düzenlerken gerekli          |
| is_subcategory| Alt kategori mi    | true veya false        | false     | Hayır       | Varsayılan false               |
| name          | Başarım adı   | herhangi bir metin             | Collector | Hayır*      | Yeni Başarımlar için gerekli   |
| desc          | Açıklama       | herhangi bir metin             | Collect 100 items | Hayır |                               |
| icon_uri      | Simge              | emoji, http(s) URL, content URI veya boş | 🏆 | Hayır | `icon` değil. Emoji `emoji_` dosyası olarak saklanır. Boş değer temizler. |
| order         | Sıralama düzeni        | tamsayı              | 1         | Hayır       | Listedeki konum                |
| category_id   | Kategori kimliği       | 0'dan büyük sayı | 1        | Hayır*      | Alt kategori oluştururken gerekli |
| unlocked      | Kilidi açma durumu     | true veya false        | true      | Hayır       | true - hemen kilidi aç<br/>false - kilitliye sıfırla |
| unlock_time   | Kilidi açma zamanı       | timestamp (milisaniye) | 1640995200000 | Hayır | Yalnızca zaten kilidi açıkken geçerli |
| delete        | Silme bayrağı       | true veya false        | false     | Hayır       |                                |
| secret        | Gizli Başarım| true veya false        | false     | Hayır       |                                |
| write_feeling | Duyguları kaydet   | true veya false        | false     | Hayır       |                                |
| color         | Başlık rengi       | renk dizesi         | #66CCFF   | Hayır       | # %23 olarak kaçırılmalıdır        |
| auto_use_item | Eşyayı otomatik kullan     | true veya false        | false     | Hayır       |                                |
| skills        | Yetenek kimlikleri         | 0'dan büyük sayı dizisi | 1 | Hayır    | Dizi desteklenir (ör. &skills=1&skills=2) |
| exp           | Deneyim Puanı Ödülü | tamsayı              | 100       | Hayır       |                                |
| item_id       | Eşya kimliği           | 0'dan büyük sayı | 1        | Hayır*      | item_id veya item_name gerekli |
| item_name     | Eşya adı         | herhangi bir metin             | Treasure  | Hayır*      | item_id veya item_name gerekli |
| item_amount   | Eşya miktarı     | [1, 99]             | 1         | Hayır       | Varsayılan 1                   |
| items         | Eşya Ödülleri JSON | JSON metni            | [{"item_id":1,"amount":2}] | Hayır | Birden fazla Eşya Ödülü ayarlar; biçim aşağıda |
| conditions_json| Kilidi açma koşulları JSON | JSON metni      | [{"type":7,"target":1000000}] | Hayır | Kilidi açma koşullarını ayarlar; biçim aşağıda |
| coin         | Jeton Ödülü       | [0, 999999]      | 10         | Hayır       | Başarımın kilidi açıldığında kazanılan jeton miktarı |
| coin_var     | Jeton Ödülü varyasyonu | tamsayı              | 5          | Hayır       | Jeton Ödülleri için varyasyon aralığı |
| coin_set_type| Jeton değerini ayarlama biçimi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - jetonu doğrudan değere ayarlar<br/>relative - orijinal jeton değerine ekler/çıkarır |
| exp_set_type | exp değerini ayarlama biçimi | Şunlardan biri:<br/>absolute<br/>relative | absolute | Hayır | absolute - exp'yi doğrudan değere ayarlar<br/>relative - orijinal exp değerine ekler/çıkarır |

**Yanıt:**

| Alan  | Tür    | Açıklama      | Örnek | Notlar                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Başarım kimliği   | 1000    | Yeni veya düzenlenen Başarımın kimliği |

#### 2. Alt Kategori Parametreleri

| Parametre     | Anlam           | Değerler               | Örnek   | Gerekli | Notlar                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Daraltma durumu   | true veya false        | false     | Hayır       | Yalnızca alt kategoriler için geçerli   |

Alt kategoriler `icon_uri` (emoji dahil) için `unsupported_parameter` döndürür. `is_subcategory=true` olmadan alt kategori düzenlemek `is_subcategory_required` döndürür.
**Yanıt:**

| Alan  | Tür    | Açıklama      | Örnek | Notlar                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Başarım kimliği   | 1000    | Yeni veya düzenlenen Başarımın kimliği (alt kategori) |

#### 3. Kilidi Açma Koşulu Türleri

| Tür Kodu | Açıklama             | related_id gerekir | related_id Türü | target Açıklaması  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Görev tamamlama sayısı   | Evet                | Görev kimliği         | Tamamlama sayısı |
| 1         | Görev tamamlama serisi  | Evet                | Görev kimliği         | Seri sayısı       |
| 3         | Pomodoro sayısı         | Hayır                 | -               | Pomodoro sayısı |
| 4         | LifeUp kullanım günleri      | Hayır                 | -               | Gün sayısı     |
| 5         | Beğeni sayısı             | Hayır                 | -               | Beğeni sayısı    |
| 6         | Günlük tamamlama serisi | Hayır                 | -               | Seri günleri        |
| 7         | Mevcut jetonlar          | Hayır                 | -               | Jeton miktarı    |
| 8         | Bir günde kazanılan jetonlar| Hayır                 | -               | Jeton miktarı    |
| 9         | Görev pomodoro sayısı    | Evet                | Görev kimliği         | Pomodoro sayısı |
| 10        | Eşya satın alma sayısı    | Evet                | Eşya kimliği         | Satın alma sayısı     |
| 11        | Eşya kullanım sayısı       | Evet                | Eşya kimliği         | Kullanım sayısı        |
| 12        | Ganimet Kutusu Eşya sayısı    | Evet                | Eşya kimliği         | Elde edilen sayı     |
| 13        | Yetenek seviyesine ulaşma    | Evet                | Yetenek kimliği        | Seviye değeri        |
| 14        | Yaşam seviyesi            | Hayır                 | -               | Seviye değeri        |
| 15        | Toplam elde edilen Eşya   | Evet                | Eşya kimliği         | Toplam elde etme sayısı |
| 16        | Sentezden elde edilen Eşyalar   | Evet                | Eşya kimliği         | Sentez sayısı    |
| 17        | Mevcut Eşya miktarı  | Evet                | Eşya kimliği         | Sahip olunan sayı          |
| 18        | Görev Odak süresi    | Evet                | Görev kimliği         | Süre (dakika) |
| 19        | ATM birikimi           | Hayır                 | -               | Birikim miktarı     |
| 20        | Harici API          | Hayır                 | -               | API tanımlı        |
| 520       | Günlük N farklı Görev tamamla | Hayır         | -               | Farklı Görev sayısı (grup kimliğine göre tekilleştirilir; mevcut tür) |
| 524       | Günlük N Görev tamamlaması | Hayır       | -               | Bir gündeki toplam geçerli tamamlama sayısı (v1.104.4+) |

> v1.104.4'ten itibaren `520` ve `524` türleri şu anlamları kullanır:
>
> - İkisi de aynı tamamlama tanımını ve yerel takvim günü sınırını (`TimeRange.today()`) paylaşır.
> - Normal Görevler `COMPLETED` sayılır; negatif Görevler `GIVE_UP` sayılır.
> - `520` türü etkin `groupId`'ye göre tekilleştirir (grup kimliği yoksa Görev kayıt kimliğine düşer). Aynı sınırsız Görevi bir günde birden çok kez tamamlamak yine 1 farklı Görev sayılır.
> - `524` türü her geçerli tamamlama satırını sayar. Aynı sınırsız Görevi 5 kez tamamlamak `completionCount = 5` verir.
> - `type=520` olan mevcut Başarımlar farklı Görev anlamını korur; geçiş gerekmez.

#### 4. JSON Biçim Spesifikasyonları

##### Kilidi Açma Koşulları (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Eşya Ödülleri (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Yetenek Yönetimi

?> v1.98.0+ gerekir

**Yöntem adı:** skill

**Açıklama:** Özel Yetenekleri (Özellikler) oluşturur veya düzenler

**Örnekler:**

- Yetenek oluştur: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Yetenek Deneyim Puanını düzenle: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Yeteneği sil: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parametre    | Anlam           | Değerler               | Örnek    | Gerekli | Notlar                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Yetenek kimliği          | 0'dan büyük sayı | 1         | Hayır       | Düzenlerken gerekli           |
| content     | Yetenek adı        | herhangi bir metin             | Programming| Hayır*      | Yeni Yetenekler için gerekli         |
| desc        | Açıklama       | herhangi bir metin             | Coding ability | Hayır    |                                |
| icon        | Simge              | herhangi bir metin             | 💻         | Hayır       | Emoji kullanılabilir                   |
| color       | Renk             | renk dizesi         | #FF6B6B    | Hayır       | # %23 olarak kaçırılmalıdır        |
| type        | Tür              | tamsayı              | 0          | Hayır       |                                |
| order       | Sıralama düzeni        | tamsayı              | 1          | Hayır       | Ham karışık liste konumu. Yalnız kullanıldığında Yetenek bu konuma yerleştirilir ve son grup düzenden çıkarılır; `group_id` ile birlikte kullanıldığında hedef gruptaki en yakın yasal konuma oturtulur |
| group_id    | Yetenek grup kimliği    | tamsayı              | 10         | Hayır       | v1.103.0+ gerekir; `0`'dan küçük olamaz ve yalnızca `0` Yeteneği gruplanmamış alana taşır. Yalnız kullanıldığında yeni Yetenekler hedef grubun sonuna eklenir; düzenlenen Yetenekler zaten o gruptaysa mevcut konumlarını korur, aksi halde grubun sonuna taşınır; `order` ile birlikte kullanıldığında `group_id` önceliklidir |
| status      | Durum            | tamsayı              | 0          | Hayır       |                                |
| exp         | Deneyim Puanı | 0 veya daha büyük sayı | 100 | Hayır | Geçerli Yetenek Deneyim Puanı        |
| delete      | Silme bayrağı       | true veya false        | false      | Hayır       | Yalnızca düzenlerken geçerli         |

**Yanıt:**

| Alan  | Tür    | Açıklama    | Örnek | Notlar                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Yetenek kimliği       | 1000    | Yeni veya düzenlenen Yeteneğin kimliği |

<br/>

### Skill Group Management :id=skill_group_management

v1.103.0+ gerekir

**Yöntem adı:** skill_group

**Açıklama:** Yetenek gruplarını oluşturur, düzenler, siler veya yeniden sıralar. Sıralama API'si gruplar ile Yeteneklerin karışık sıralamasını da destekler.

**Örnekler:**

- Grup oluştur: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Grubu düzenle: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Grubu sil: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Grupları ve Yetenekleri birlikte sırala:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parametre | Anlam | Değerler | Örnek | Gerekli | Notlar |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | Yetenek grup kimliği | 0'dan büyük sayı | 10 | Hayır* | Düzenlerken veya silerken gerekli |
| content | Grup adı | herhangi bir metin | Combat | Hayır* | Oluştururken gerekli |
| order | Sıralama düzeni | tamsayı | 20 | Hayır | Ham `orderInCategory` değeri; karışık Yetenek/grup listesinde benzersiz olmalıdır |
| collapsed | Daraltma durumu | true veya false | true | Hayır | Grubun daraltılıp daraltılmadığı |
| delete | Silme bayrağı | true veya false | false | Hayır | Yalnızca düzenlerken geçerli |
| sort_json | Karışık sıralama düğümleri | JSON dizisi | `[{"type":"skill","id":2},{"type":"group","id":10}]` | Hayır* | Sağlandığında CRUD parametreleri yok sayılır ve karışık sıralama planı uygulanır. Kısmi sıralama desteklenir: belirtilmeyen düğümler göreli sıralarını korur |

`sort_json` düğüm biçimi:

| Alan | Anlam | Değerler |
| ----- | ------- | ------ |
| type | Düğüm türü | `skill` / `group` |
| id | Varlık kimliği | 0'dan büyük sayı |

**Yanıt:**

| Alan | Tür | Açıklama | Örnek | Notlar |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | Yetenek grup kimliği | 10 | oluştur / düzenle / sil için döndürülür |
| count | Number | Sıralanan düğüm sayısı | 3 | `sort_json` istekleri için döndürülür |

<br/>

### Uygulama Ayarları

?> v1.98.0+ gerekir

**Yöntem adı:** app_settings

**Açıklama:** Uygulama arayüz ayarlarını düzenler

**Örnekler:**

- Kompakt modu etkinleştir: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Material You temasını etkinleştir: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Ayarları değiştir ve arayüzü hemen yeniden başlat: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parametre              | Anlam           | Değerler          | Örnek | Gerekli | Notlar                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Kompakt modu etkinleştir| true or false  | true    | Hayır       | Arayüz öğelerini sadeleştirir     |
| is_enable_material_you| Material You'u etkinleştir| true or false  | true    | Hayır       | Material You temasını etkinleştirir       |
| restart_activities    | Arayüzü yeniden başlat | true or false   | true    | Hayır       | Arayüz değişikliklerini hemen uygular |
| broadcast_event | LifeUp Labs yayın olayları | true or false | true | Hayır | Varsayılan kapalı. Ayarlar → Labs ile aynı anahtar |

**Yanıt:**

| Alan  | Tür    | Açıklama  | Örnek | Notlar                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Sonuç kodu  | 0       | 0 başarıyı gösterir      |

<br/>

### Basit Sorgu

!> Buradaki işlevler otomasyon araçları/ikinci geliştirme ile kullanılır. Tam bir veri listesi sorgulamanız gerekiyorsa [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) ve [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop) belgelerine bakın

**Yöntem adı:** query

**Açıklama:** sorgu parametreleri

**Örnek:** - Güncel jeton sayısını sorgula: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Yayın olayları anahtarını sorgula: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parametre   | Anlam              | Tür                                                         | Örnek | Gerekli                                    | Notlar                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | sorgu türü        | Yalnızca şu değerlerden biri:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | evet                                         | coin - güncel jeton miktarı<br/>atm - güncel ATM bakiyesi<br/>item - Belirtilen `itemId` için Eşya bilgisi<br/>item_id_list - `categoryId` ile belirtilen Eşya kimliği listesi<br/>tomato - Domates verileri<br/>task - Görev bilgisi (v1.101.0+)<br/>broadcast - Labs yayın olayları anahtarı (`{enabled}`) |
| item_id     | eşyanın kimliği   | 0'dan büyük sayı                                      | 1       | key `item` olduğunda sağlanmalıdır |                                                              |
| category_id | Mağaza kategori kimliği | 0 veya daha büyük sayı                            | 0       | hayır*                                         | Yalnızca key `item_id_list` olduğunda gerekli; sorgulanacak listenin kimliğini temsil eder. |
| task_id / taskId | Görev kimliği          | 0'dan büyük sayı                                        | 1       | key `task` olduğunda üçünden biri* gerekli | Sorgulanan Görev kimliği |
| task_gid / taskGid / task_group_id / taskGroupId | Görev grup kimliği | 0'dan büyük sayı | 1 | key `task` olduğunda üçünden biri* gerekli | Sorgulanan Görev grup kimliği |
| task_name / taskName | Görev adı      | Herhangi bir metin                                                     | Study   | key `task` olduğunda üçünden biri* gerekli | Bulanık eşleşen Görev adı |
| withSubTasks | Alt görevleri dahil et   | true or false                                                | true    | Hayır                                          | Yalnızca key `task` olduğunda kullanılabilir; varsayılan true |

**Dönüş değeri:**

Yalnızca 1.90.2 sürümünden itibaren desteklenir

coin/atm sorgulanırken:

| Parametre | Anlam                             | Tür               | Örnek | Gerekli | Notlar |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Sorgunun döndürdüğü sayısal değer | number             | 1000    | evet      |       |

Eşya sorgulanırken:

| Parametre        | Anlam                         | Tür     | Örnek   | Gerekli | Notlar |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | eşyanın kimliği              | number   | 1         | evet      |       |
| name             | eşyanın adı            | any text | Coffee    | evet      |       |
| desc             | açıklama                     | any text |           | hayır       |       |
| icon             | simge URL'si                        | any text | icon.webp | hayır       | Yerel dosyaysa yalnızca dosya adı döndürülür |
| category_id      | kategori veri kimliği                | number   | 1         | evet      |       |
| stock_number     | Mağaza stok miktarı             | number   | -1        | evet      | `-1` sınırsız Mağaza envanterini temsil eder |
| own_number       | Envanterdeki sahip olunan miktar | number   | 10        | evet      |       |
| price            | fiyat                       | number   | 100       | evet      |       |
| order            | sıralama                         | number   | 100       | evet      | Özel sıralamada ağırlık değeri |
| disable_purchase | Satın almayı devre dışı bırak     | true or false | true | evet |       |
| purchase_limit   | Kısıtlama kuralları               | JSON text | [{"limitType":0,"limitNumber":5}] | evet | Güncel kısıtlama listesi |
| limit_scope      | Kısıtlama kapsamı               | purchase / use / both | use | evet | API metin değeri olarak döndürülür |

item_id_list sorgulanırken:

| Parametre | Anlam                           | Tür   | Örnek | Gerekli | Notlar |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Virgülle ayrılmış Eşya kimliği dizisi     | string | 1,2,3,4 | evet      |       |

tomato sorgulanırken:

| Parametre | Anlam                  | Tür   | Örnek | Gerekli | Notlar |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Toplam domates sayısı       | number | 100     | evet      |       |
| available | Kullanılabilir domates sayısı   | number | 50      | evet      |       |
| exchanged | Takas edilen domates sayısı   | number | 50      | evet      |       |

Görev sorgulanırken (v1.101.0+):

| Parametre   | Anlam                      | Tür        | Örnek | Gerekli | Notlar                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | Görev kimliği                      | number      | 1       | evet      | -                               |
| _GID        | Görev grup kimliği                | number      | 1       | evet      | -                               |
| name        | Görev adı                    | text        | Study   | evet      | -                               |
| notes       | Notlar                        | text        | -       | hayır       | Boş olabilir                    |
| status      | Görev durumu                  | number      | 0       | evet      | 0=tamamlanmadı, 1=tamamlandı       |
| startTime   | Başlangıç zamanı                   | number      | -       | evet      | Unix zaman damgası (milisaniye)   |
| deadline    | Son tarih zamanı                | number      | -       | hayır       | Unix zaman damgası (milisaniye), boş olabilir |
| remindTime  | Hatırlatma zamanı                  | number      | -       | hayır       | Unix zaman damgası (milisaniye), boş olabilir |
| frequency   | Tekrar sıklığı         | number      | -       | evet      | -                               |
| weekdays    | Haftanın günleri                     | text        | 1,3,5   | hayır       | v1.106.0+; hafta günü modu değilse boş. 1=Pazartesi … 7=Pazar |
| exp         | Deneyim Puanı Ödülü                   | number      | -       | evet      | -                               |
| skillIds    | Yetenek kimliği listesi                | JSON text   | -       | evet      | JSON dizi biçimi               |
| coin        | Jeton Ödülü                  | number      | -       | hayır       | Boş olabilir                    |
| coinVariable| Rastgele jeton Ödülü           | number      | -       | hayır       | Boş olabilir                    |
| itemId      | İlk Ödül Eşya kimliği         | number      | -       | hayır       | Boş olabilir                    |
| itemCount   | İlk Ödül Eşya miktarı      | number      | -       | hayır       | itemId varsa döndürülür     |
| items       | Eşya Ödül listesi             | JSON text   | -       | evet      | JSON dizi biçimi               |
| words       | Tamamlama teşvik sözleri   | text        | -       | hayır       | Boş olabilir                    |
| categoryId  | Kategori kimliği                  | number      | -       | hayır       | Boş olabilir                    |
| order       | Sıra                        | number      | -       | evet      | -                               |
| name_extended | Genişletilmiş ad              | text        | -       | evet      | name ile aynı                    |
| subTasks    | Alt görev listesi                | JSON text   | -       | evet      | JSON dizi biçimi, aşağıya bakın    |

**Alt görevler (subTasks) alan açıklaması:**

`subTasks` alanı bir JSON dizisidir; her öğe şu alanları içerir:

- `id`: Alt görev kimliği
- `gid`: Alt görev grup kimliği
- `todo`: Alt görev içeriği
- `status`: Alt görev durumu (0=tamamlanmadı, 1=tamamlandı)
- `remindTime`: Hatırlatma zamanı (Unix zaman damgası, milisaniye)
- `exp`: Deneyim Puanı Ödülü
- `coin`: Jeton Ödülü
- `coinVariable`: Rastgele jeton Ödülü
- `items`: Eşya Ödül listesi
- `order`: Sıra
- `autoUseItem`: Eşyayı otomatik kullanıp kullanmadığı

<br/>

### Özellikleri Sorgula :id=query_skill

!> Buradaki işlevler otomasyon araçları/ikinci geliştirme ile kullanılır.

**Yöntem adı:** query_skill

**Açıklama:** Belirtilen bir Yeteneğin temel bilgilerini, ham sıralama alanlarını ve seviye/deneyim verilerini sorgular.

Bu API ile Özellik widget'larınızı özelleştirebilirsiniz.

**Örnek:**

- Güç Özelliğini sorgula: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parametre | Anlam              | Tür                    | Örnek | Gerekli | Notlar |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | Özellik (Yetenek) kimliği | 0'dan büyük sayı | 1       | evet      | Nasıl alınacağı için yukarıdaki "Temel bilgiler - LifeUp Veri Kimliği" bölümüne bakın |

**Dönüş değeri:**

Yalnızca 1.90.6 sürümünden itibaren desteklenir

| Parametre            | Anlam                              | Tür   | Örnek  | Gerekli | Notlar |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | Yetenek kimliği                             | number | 1        | evet      | v1.103.0+ ile `query_skill`'e eklendi |
| name                 | Özellik adı                       | string | strength | evet      |       |
| order                | ham sıralama düzeni                       | number | 20       | evet      | v1.103.0+ ile eklendi; `orderInCategory` |
| group_id             | Yetenek grup kimliği                       | number | 10       | evet      | v1.103.0+ ile eklendi; Yetenek bir grupta değilse `0` döndürür |
| status               | durum                               | number | 0        | evet      | v1.103.0+ ile eklendi; `0` = normal, `1` = gizli |
| level                | seviye                                | number | 10       | evet      |       |
| total_exp            | toplam Deneyim Puanı              | number | 10000    | evet      |       |
| until_next_level_exp | bir sonraki seviyeye ulaşmak için gereken Deneyim Puanı | number | 99       | evet      |       |
| current_level_exp    | geçerli seviyenin üzerindeki kazanılan Deneyim Puanı       | Number | 1000     | Evet      |       |

<br/>

### Yetenek Grubunu Sorgula :id=query_skill_group

v1.103.0+ gerekir

**Yöntem adı:** query_skill_group

**Açıklama:** Tek bir Yetenek grubunu sorgular ve ham sıralama ile daraltma durumunu döndürür.

**Örnek:**

- Yetenek grubunu sorgula: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Yetenek grup kimliği | 0'dan büyük sayı | 10 | evet | - |

**Dönüş değeri:**

| Parametre | Anlam | Tür | Örnek | Gerekli | Notlar |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Yetenek grup kimliği | number | 10 | evet | - |
| content | Grup adı | string | Combat | evet | - |
| order | Ham sıralama düzeni | number | 20 | evet | `orderInCategory` |
| collapsed | Daraltma durumu | string | true | evet | `true` / `false` metni olarak döndürülür |

<br/>

<br/>

### Özel arayüz

#### Rastgele

?> Bu API v1.93.0 sürümünde yayınlandı.

**Yöntem adı:** random

**Açıklama:** Birden fazla API'den birini rastgele tetikleyebilen basit bir rastgele arayüz.

**Örnek:**

- Eşit olasılıkla rastgele `scissors`, `rock` veya `paper` göster: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- %90 olasılıkla `rock`, %5 `scissors` ve %5 `paper` göster: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parametre | Anlam    | Değerler                 | Örnek                                | Gerekli | Notlar |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | Rastgele API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Evet      | Dizi biçiminde çağrıyı destekler (yukarıdaki örneklerdeki gibi birden fazla api parametresi) |
| weight    | Ağırlık     | 0'dan büyük sayılar | 1                                      | Hayır       | Dizi biçiminde çağrıyı destekler.<br/><br/>weight belirtilmezse tüm ağırlıklar eşittir (eşit olasılık).<br/>weight belirtilirse sırayla atanır: örneğin ilk weight ilk api parametresine karşılık gelir.<br/><br/>**weight parametre sayısının api parametre sayısıyla eşleştiğinden emin olun; aksi halde etkili olmayabilir.** |

<br/>

#### Onay Diyaloğu

**Yöntem adı:** confirm_dialog

**Açıklama:** Bir açılır seçim penceresi gösterir. Başlık, metin, olumlu ve olumsuz düğmeleri özelleştirebilirsiniz. Düğmeye tıklandığında diğer arayüzler de çağrılabilir.

**Örnek:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Diğer kullanım senaryoları:
  - Ödül seçimi
  - Olay dal seçimi

| Parametre       | Anlam              | Tür     | Örnek  | Gerekli | Notlar |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | açılır pencere başlığı          | any text | Title    | evet      |       |
| message         | açılır pencerenin ayrıntılı açıklaması | any text | This is the content of the popup window | hayır |  |
| positive_text   | olumlu düğme metni | any text | YES      | hayır       |       |
| negative_text   | olumsuz düğme metni | any text | NO       | hayır       |       |
| neutral_text    | nötr düğme metni  | any text | QUESTION | hayır       |       |
| positive_action | olumlu düğmenin bağlantı yanıtı | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | hayır | Aslında açılır mesaj arayüzünün kaçırılmış metnidir. Kaçış kuralları için `Temel bilgiler - Kaçış (URL Encode)` bölümüne bakın. |
| negative_action | olumsuz düğmenin bağlantı yanıtı | URL (other interface) | Yukarıdakiyle aynı | hayır |  |
| neutral_action  | nötr düğmenin bağlantı yanıtı  | URL (other interface) | Yukarıdakiyle aynı | hayır |  |
| cancel_action   | iptal eyleminin bağlantı yanıtı   | URL (other interface) | Yukarıdakiyle aynı | hayır |  |

<br/>

#### İşlem Yok

**Yöntem adı:** placeholder

**Not:** Bu arayüz kendi başına herhangi bir mantık işlemez; ancak callback ve broadcast ile birlikte kullanılabilir.

**Örnek:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Değişken Yer Tutucu

`LifeUp`, parametreler için kullanıcı müdahale işleme yöntemleri sunar.

| Yer tutucu                          | Anlam                                                      | Örnek                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Metin yer tutucu                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Sayı yer tutucu (ondalık noktasız)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Sayı yer tutucu (ondalık noktasız), işaret göster        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Sayı yer tutucu (ondalık noktalı)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Sayı yer tutucu (ondalık noktalı), işaret göster           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Bir Eşya seç; Eşya kimliği ile değiştirilir              | [$item]                                                      |
| [$task_category]                     | Görev listesi seç; Görev listesi kimliği ile değiştirilir    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Zaman yer tutucu<br/><br/>Anchor Time için olası değerler:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Milisaniye cinsinden ofset bir tam sayı olmalıdır; varsayılan 0 milisaniyedir | Bugün gece yarısı: [$time\|today]<br/>Yarın gece yarısı: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Rastgele sayı yer tutucu (ondalık noktasız)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Rastgele sayı yer tutucu (ondalık noktalı)                | [$random_decimal\|1.0\|2.0]                                  |

**Örnek 1: Kullanırken fiyatı 1 jeton düşürmek için bir Eşya seçin**

Örneğin belirli bir Mağaza Eşyasının fiyatını düşürmek için API ayarladıktan sonra, kimliği önceden belirlemek yerine çağrı sırasında kullanıcının Eşyayı seçmesine izin vermek isteyebilirsiniz.

Aşağıdaki API yalnızca kimliği 1 olan Mağaza Eşyasının fiyatını 1 jeton düşürebilir:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Eşya kimliğini [$item] yer tutucusu ile değiştirmeniz yeterlidir; çağrı yapıldığında kullanıcı fiyatını düşürmek istediği Eşyayı aktif olarak seçebilir:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Örnek 2: Görev şablonu — yalnızca Görev adını ve seçim listesini girerek önceden ayarlanmış Ödül şablonu oluşturun**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Bitiş Geri Çağrısı

Tüm arayüzlere callback parametresi ekleyerek çağrıdan sonra URL'ye geri dönüş işlemini uygulayabilirsiniz.

Bu, birden fazla arayüzü birleştirmek için de kullanılabilir; örneğin atlama sonrası bir istem göstermek istiyorsanız:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

callback parametresini kullanabilirsiniz. Yukarıdaki **Temel bilgiler - Kaçış (URL Encode)** bölümüne de bakın. Bu tür bir işlem yazabilirsiniz:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Elbette bu etkiyi elde etmek için bir Mağaza eşyasına birden fazla bağlantı ekleyebilirsiniz.

Ayrıca bu geri çağrı daha çok şunlar için kullanılır:

X uygulaması → LifeUp → X uygulaması

veya

X uygulaması → LifeUp → Y uygulaması

<br/>

#### Yayın dönüş değeri

!> Buradaki işlevler otomasyon araçları/ikinci geliştirme ile kullanılır ve belirli bir eşik gerektirir.

Bu parametreyi ekleyerek API'nin orijinal dönüş değeri yayın yoluyla da gönderilebilir; böylece Tasker gibi otomasyon araçları alabilir.

broadcast değeri, Tasker'daki "Intent Received" (Alınan Intent) eyleminin işlem sütunundaki değere eşdeğerdir. İkisi eşleştiği sürece istediğiniz metni girebilirsiniz.

**Örneğin, Tasker ile jeton sorgulama API'sini kullanma ([MacroDroid kullanıyorsanız bu bağlantıya bakın.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Dönüş değerini Tasker'a yayınlamak için broadcast parametresini ekleyin; istediğiniz metin olabilir, örneğin `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Tasker'da olay ekleyin → "Intent Received", işlem sütununa `app.lifeup.query.coin` yazın

3. Tasker'daki görev, `value` dönüş değerini `%value` değişkeni biçiminde alabilir.

4. Ardından Tasker'da jeton sayısını değerlendirerek çeşitli efektler elde edebilirsiniz. (Örneğin jeton sayısına göre masaüstü duvar kağıdını değiştirmek?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Yayın Olayı Bildirimi

!> Buradaki işlevler otomasyon araçları/ikinci geliştirme ile kullanılır.

> 1.90.2 sürümünde çeşitli olayları dışarıya yayınlayacağız. Tasker gibi otomasyon araçlarıyla bu olayları alarak Tasker eylemlerini tetikleyebilirsiniz.
>
### Etkinleştir

**Varsayılan olarak yayın olayları kapalıdır.**

`Settings` → `Labs` → `Developer mode` → `Broadcast events` bölümünden etkinleştirebilirsiniz.

### Örnek: Bir Eşya ile duvar kağıdını değiştirme

1. "Change Wallpaper" adında yeni bir Eşya oluşturun.
2. Tasker'da `Configuration file` → `Event` → `System` → `Intent Received` bölümüne gidin, işlem sütununa `app.lifeup.item.use` yazın ve geri dönün.
3. New Task'a tıklayın ve herhangi bir ad girin (örneğin change wallpaper).
4. Sağ alt köşedeki + işaretine tıklayarak bir görev ekleyin, `Task` → `If` seçin
5. Koşul sütununu `%name eq change wallpaper` olarak ayarlayın.
6. Geri dönün, `Insert Action` ile `If` seçin.
7. Sağ alt köşedeki + işaretine tekrar tıklayarak bir görev ekleyin, `Display` → `Set Wallpaper` seçin
8. (İsteğe bağlı) `Type` değerini `All` ile değiştirin
9. Görsel sütununda 🔍 simgesine tıklayın ve istediğiniz duvar kağıdı dosyasını seçin
10. Çıkın ve bu yapılandırmanın etkin olup olmadığını kontrol edin.
11. `LifeUp`'ta "Wallpaper Change" Eşyasını kullanın — duvar kağıdının başarıyla değiştiğini görmelisiniz

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

`İşlem Yok` + `Yayın dönüş değeri` ile bu etki daha özlü biçimde elde edilebilir; keşfedebilirsiniz.

<br/>

### Görev tamamlandı

**Ad:** app.lifeup.task.complete

**Dönüş değeri:**

| Parametre  | Anlam          | Örnekler        |
| ----------- | ---------------- | --------------- |
| task_id     | Görev kimliği          | 1               |
| task_gid    | Görev grup kimliği    | 1               |
| name        | Görev adı        | Getting started |
| category_id | Görev kategori kimliği | 1               |

### Görevden vazgeçildi

**Ad:** app.lifeup.task.giveup

**Dönüş değeri:**

| Parametre  | Anlam          | Örnekler        |
| ----------- | ---------------- | --------------- |
| task_id     | Görev kimliği          | 1               |
| task_gid    | Görev grup kimliği    | 1               |
| name        | Görev adı        | Getting started |
| category_id | Görev kategori kimliği | 1               |

### Görev gecikti

**Ad:** app.lifeup.task.overdue

**Dönüş değeri:**

| Parametre | Anlam                 | Örnekler                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | Görev kimliği **dizisi**       | [1, 2, 3]                       |
| task_gids  | Görev grup kimliği **dizisi** | [1, 2, 3]                       |
| names      | Görev adı **dizisi**     | [Getting started, Drink Waters] |
| task_ids_json  | Görev kimliği **Json dizisi**   | [1, 2, 3]                       |
| task_gids_json | Görev grup kimliği **Json dizisi** | [1, 2, 3]                       |
| names_json     | Görev adı **Json dizisi** | ["Getting started", "Drink Waters"]                      |

### Başarım kilidi açıldı

**Ad:** app.lifeup.achievement.unlock

**Dönüş değeri:**

| Parametre     | Anlam          | Örnekler                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | Başarım kimliği   | 1                        |
| name           | Başarım adı | Using LifeUp for 30 days |

### Eşya satın alındı

**Ad:** app.lifeup.item.purchase

**Dönüş değeri:**

| Parametre | Anlam           | Örnekler          |
| ---------- | ----------------- | ----------------- |
| item_id    | Eşya kimliği           | 1                 |
| name       | Eşya adı         | Break 10 branches |
| amount     | satın alma miktarı | 1                 |

### Eşya kullanıldı

**Ad:** app.lifeup.item.use

**Açıklama:** Normal Eşya kullanımı veya basit Sentez kullanım akışı başarılı olduğunda gönderilir.

**Dönüş değeri:**

| Parametre | Anlam      | Örnekler          |
| ---------- | ------------ | ----------------- |
| item_id    | Eşya kimliği      | 1                 |
| name       | Eşya adı    | Break 10 branches |
| amount     | kullanım miktarı | 1                 |

### Sentez tamamlandı

> [!NOTE]
> Bu yayın olayı v1.102.8 sürümünde yayınlandı.

**Ad:** app.lifeup.synthesis.complete

**Açıklama:** Bir tarif Sentezi başarıyla tamamlandığında gönderilir.

**Dönüş değeri:**

| Parametre   | Anlam                            | Örnekler                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | tarif kimliği                         | 1                                                     |
| formula_name | tarif adı                       | Toolbox Recipe                                        |
| times        | yürütme sayısı                    | 3                                                     |
| input_count  | girdi Eşya girişi sayısı       | 2                                                     |
| output_count | çıktı Eşya girişi sayısı      | 1                                                     |
| inputs_json  | tüketilen tüm girdilerin JSON dizisi  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | üretilen tüm çıktıların JSON dizisi | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notlar:**

- Bu olay yalnızca Sentez başarılı olduktan sonra gönderilir.
- Malzeme yetersizse, tarif mevcut değilse, kaydetme başarısız olursa veya `Broadcast events` devre dışıysa bu olay gönderilmez.
- Tek bir API çağrısı, `times > 1` olsa bile yalnızca bir olay gönderir.
- `inputs_json` ve `outputs_json` içinde her öğe şu yapıyı kullanır:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount`, tarif başına miktar değil; bu yürütmede **toplam tüketilen / toplam üretilen** miktardır.

### Duygu eklendi / güncellendi

**Ad:** app.lifeup.feelings.add

**Dönüş değeri:**

| Parametre | Anlam | Örnekler |
| --- | --- | --- |
| feelings_id | Duygu kimliği | 1 |
| action_type | `add` or `update` | add |
| content | Duygu metni | Feeling good today! |
| create_time | oluşturulma zaman damgası (ms) | 1642060800000 |
| relate_type | ilişkili nesne türü | 0 |
| related_id | ilişkili nesne kimliği | 1 |
| attachments_count | ek sayısı | 2 |
| attachments | ek yolu dizisi | ["/path/1", "/path/2"] |

### Seviye yükseldi

**Ad:** app.lifeup.level.up

**Dönüş değeri:**

| Parametre | Anlam       | Örnekler |
| ---------- | ------------- | -------- |
| skill_id   | Görev kimliği       | 1        |
| name       | ad          | strength |
| level      | geçerli seviye | 2        |

### Seviye düştü

**Ad:** app.lifeup.level.down

**Dönüş değeri:**

| Parametre | Anlam       | Örnekler |
| ---------- | ------------- | -------- |
| skill_id   | Görev kimliği       | 1        |
| name       | ad          | strength |
| level      | geçerli seviye | 2        |

### Mağaza eşyası geri sayımı

**Ad:**

- Başlangıç: app.lifeup.item.countdown.start
- Durdur: app.lifeup.item.countdown.stop
- Tamamla: app.lifeup.item.countdown.complete

**Dönüş değeri:**

| Parametre | Anlam                       | Örnekler                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | Eşya kimliği                       | 1                         |
| name       | Eşya adı                     | play games for 30 minutes |
| time_left  | kalan süre (milisaniye) | 30000                     |

### Pomodoro Yaşam Döngüsü

?> Bu yayın olayı v1.101.0 sürümünde yayınlandı ve daha zengin olay verileri sağlar.

**Ad:**

- Başlangıç: app.lifeup.pomodoro.start
- Duraklat: app.lifeup.pomodoro.pause (v1.101.0'da yeni)
- Durdur: app.lifeup.pomodoro.stop
- Tamamla: app.lifeup.pomodoro.complete

**Açıklama:** Pomodoro zamanlayıcısı başladığında, duraklatıldığında, durdurulduğunda veya tamamlandığında sistem, Görev bilgisi, zamanlama durumu ve diğer ayrıntılı verileri taşıyan ilgili yayın olaylarını gönderir.

**Dönüş değeri:**

| Parametre          | Anlam                       | Örnek        | Notlar                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | Görev kimliği                       | 1              | İsteğe bağlı; yalnızca Pomodoro bir Görevle ilişkilendirildiğinde vardır |
| task_gid           | Görev grup kimliği                 | 1              | İsteğe bağlı; yalnızca Pomodoro bir Görevle ilişkilendirildiğinde vardır |
| name               | Görev adı                     | Study English  | Pomodoro ile ilişkili Görev adı veya özel ad         |
| service_type       | Hizmet türü                  | 0              | 0=Odak, 1=kısa mola, 2=uzun mola                      |
| service_type_label | Hizmet türü etiketi            | Focus          | Yerelleştirilmiş hizmet türü metni                                |
| duration           | Toplam süre (milisaniye) | 1500000        | Odak veya molanın toplam süresi                           |
| remaining          | Kalan süre (milisaniye) | 900000     | Geçerli kalan süre                                 |
| elapsed            | Geçen süre (milisaniye) | 600000       | Geçen süre                                           |
| start              | Başlangıç zamanı                    | 1639123456789  | Unix zaman damgası (milisaniye)                              |
| event_time         | Olay tetikleme zamanı            | 1639123456789  | Unix zaman damgası (milisaniye)                              |
| reason             | Durdurma nedeni                   | user           | Yalnızca stop olayı için; olası değerler: manual, cancel, complete, auto |

**Durdurma nedeni açıklaması:**

`reason` parametresi yalnızca `app.lifeup.pomodoro.stop` olayında vardır ve Pomodoro durdurma nedenini belirtir:

- `manual`: Kullanıcı manuel olarak durdurdu
- `cancel`: Kullanıcı iptal etti
- `complete`: Normal tamamlandı (Not: Tamamlandığında `app.lifeup.pomodoro.complete` olayı da tetiklenir)
- `auto`: Otomatik durduruldu (ör. Görev silindi)

### Pozitif Zamanlayıcı Yaşam Döngüsü :id=broadcast_positive_timing

> [!NOTE]
> Bu olaylar pozitif zamanlayıcı özelliği içindir; yukarıdaki Pomodoro geri sayım olayları değildir. Kullanmadan önce `Settings` → `Labs` → `Developer mode` → `Broadcast events` seçeneğinin etkin olduğundan emin olun.

**Ad:**

- Başlangıç: app.lifeup.timing.start
- Duraklat: app.lifeup.timing.pause
- Tamamla: app.lifeup.timing.complete
- Vazgeç: app.lifeup.timing.abandon

**Açıklama:** Pozitif zamanlayıcı başladığında, duraklatıldığında, tamamlandığında veya manuel olarak vazgeçildiğinde LifeUp ilgili yayını gönderir. `complete`, oturumun normal şekilde bittiği ve kaydedildiği anlamına gelir. `abandon`, geçerli oturumun manuel olarak durdurulduğu veya atıldığı anlamına gelir.

**Dönüş değeri:**

| Parametre | Anlam                        | Örnekler      | Notlar                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | Görev kimliği                        | 1             | İsteğe bağlı; yalnızca zamanlayıcı bir Görevle bağlantılıysa vardır |
| name       | Görev adı                      | Study English | Bağlantılı Görev adı veya özel zamanlayıcı adı          |
| time       | Birikmiş süre (ms)      | 600000        | Geçerli pozitif zamanlayıcının toplam geçen süresi |
| start      | Başlangıç zamanı                     | 1639123456789 | Unix zaman damgası (milisaniye)                    |
| end        | Bitiş zamanı                       | 1639127056789 | Yalnızca `complete` / `abandon` olaylarında vardır    |

---

## Entegrasyon

Diğer geliştiricilerden her türlü entegrasyonu memnuniyetle karşılıyoruz.

> Daha fazla ayrıntı yakında...

### Daha fazla API mi gerekiyor?

API işlevselliği şu anda yalnızca bir sürüm yinelemesindedir.

Gelecekte daha fazla kullanım senaryosunu karşılamak için daha fazla API eklemeye devam edeceğiz.

Daha fazla API'ye ihtiyacınız varsa [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose) üzerinde Issue açabilirsiniz.

<br/>

### Nasıl çağrılır

#### Android

##### SDK kullanarak

Şu adresteki `core` modülüne bakın: https://github.com/Ayagikei/LifeUp-SDK.

##### SDK kullanmadan

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Web sayfası

Web sayfasından çağrılırsa tetiklenip tetiklenmeyeceği tarayıcıya bağlıdır. Quark, Chrome ve Edge gibi normal tarayıcılarda sorun yoktur. Ancak sistemdeki bazı yerleşik tarayıcılar her açılışta kullanıcıya "Rensheng açılsın mı" diye sorabilir.

Kendi gömülü WebView uygulamanızı geliştiriyorsanız, WebView'ın lifeup şemasını işleyebildiğinden emin olmalısınız.

Tutarlı bir deneyim için `LifeUp`'ta ürün bağlantı efektini kullanabilir ve açmak için "Use built-in browser" seçeneğini işaretleyebilirsiniz. Ancak güvenlik ayarları nedeniyle bu yöntem yalnızca HTTPS bağlantılarını destekler (HTTP değil)

**HTML**

Doğrudan köprü bağlantısına atla

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

Aslında bu da bir köprü bağlantısı çağrısıdır

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Uygulama/Web/Otomasyon Geliştiricisi

LifeUp ile ilgili bir şey geliştirdiyseniz bize bildirin!

<br/>

### HTTP protokolünü destekleyen herhangi bir programlama dili/platform

Ayrıntılar için https://github.com/Ayagikei/LifeUp-SDK ve [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) adreslerine bakın.

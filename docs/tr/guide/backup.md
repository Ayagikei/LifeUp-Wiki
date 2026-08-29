# Yedekleme ve Geri Yükleme

> [!IMPORTANT]
> LifeUp çevrimdışı öncelikli bir App'tir. Kişisel verilerinizin çoğu cihazınızda kalır. Yedekleme yapılandırılmamışsa App'i kaldırmak, telefon değiştirmek veya cihaz hasarı kalıcı veri kaybına yol açabilir.

## Hızlı Gezinme

- [Yedeklemenin Neden Önemli Olduğu](#why-backup)
- [Yedekleme Yöntemlerini Yapılandırma](#configure-methods)
- [Nasıl Yedeklenir](#how-to-backup)
- [Nasıl Geri Yüklenir](#how-to-restore)
- [Yeni Telefona Geçiş](#phone-migration)
- [Sık Karşılaşılan Sorunlar](#common-issues)

## 1) Yedeklemenin Neden Önemli Olduğu :id=why-backup

### Hangi risklere karşı korunuyorsunuz?

Çoğu kullanıcı verilerini şu durumlardan birinde kaybeder:

1. App kaldırma (varsayılan yedekleme yolundaki dosyalar sistem temizliği tarafından silinebilir)
2. Yedekleme dosyalarını taşımadan telefon değiştirme
3. Cihaz hasarı/kaybı

Güvenilir bir yedekleme, verilerinizin yalnızca aynı telefonda değil, başka bir cihazda veya depolama ortamında da bulunması anlamına gelir.

### Yedeklemede neler yer alır?

Yedeklemeler Görevler, Özellikler, Mağaza verileri, Başarımlar, Duygular, Pomodoro kayıtları ve ayarlar gibi yerel temel verilerinizi içerir. Medya dosyaları (ekler, simgeler, arka planlar, ses) de dahil edilebilir.

> [!TIP]
> Yedekleme boyutu 10 MB'ı aşarsa, daha iyi kararlılık için "Medya/resim dosyalarını yoksay" seçeneğini etkinleştirin veya yedekleme aralığını artırın.

## 2) Yedekleme Yöntemlerini Yapılandırma :id=configure-methods

Çoğu kullanıcı için şu öncelik en iyi sonucu verir:

| Yöntem | Önerilen | En uygun | Otomatik yedekleme | Notlar |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Günlük kullanım, kolay bulut senkronizasyonu | Evet | App'te tek dokunuşla yetkilendirme |
| Dropbox | ⭐⭐⭐⭐ | Günlük kullanım, cihazlar arası senkronizasyon | Evet | App içi yetkilendirme de desteklenir |
| Yerel dışa aktarma (Özel Yol) | ⭐⭐⭐⭐ | PC / NAS'a manuel kopyalama | Hayır (manuel) | Güvenilir yedek ve sürümlü arşivler |
| WebDAV | ⭐⭐⭐ | Kendi barındırma / mevcut WebDAV hizmeti | Evet | Zaten WebDAV kullanıyorsanız iyi bir alternatif |
| İndirme klasörüne otomatik yedekleme (Android 10+) | ⭐⭐⭐ | Kaldırma riskini azaltma | Evet | Cihaz hasarına karşı korumaz |

<details>
<summary>Google Drive / Dropbox otomatik yedeklemesini ayarlama (önerilen)</summary>

App'te şuraya gidin:
`Kenar çubuğu → Ayarlar → Veri Yedekleme/Geri Yükleme/Temizleme`

Ardından:

1. Google Drive veya Dropbox'ı yetkilendirin
2. "Bulut Yedekleme Yapılandırması"nda yönteminizi seçin
3. "Otomatik bulut yedeklemesini etkinleştir" seçeneğini açın
4. "Otomatik yedekleme aralığını" ayarlayın
5. İsteğe bağlı olarak "Medya/resim dosyalarını yoksay" seçeneğini etkinleştirin

</details>

<details>
<summary>WebDAV bulut yedeklemesini ayarlama (isteğe bağlı)</summary>

WebDAV uyumlu bir hizmet kullanıyorsanız:

1. `WebDAV Yapılandırması`'nı açın
2. URL, hesap ve parolayı doldurun
3. Bağlantı testini çalıştırın
4. WebDAV'ı bulut yedekleme yönteminiz olarak kullanın

</details>

<details>
<summary>Özel yola dışa aktarma (manuel yedek)</summary>

Manuel, taşınabilir yedeklemeler istediğinizde bunu kullanın:

1. `Yedekleme`'ye dokunun
2. `Özel Yol`'u seçin
3. Oluşturulan dosyayı kaydedin (genellikle `.lfbak`)
4. PC / NAS / bulut depolamaya kopyalayın

> [!WARNING]
> Tek yedeğinizi aynı telefonda tutmayın.

</details>

## 3) Nasıl Yedeklenir :id=how-to-backup

<details>
<summary>Günlük otomatik yedekleme akışını çalıştırma</summary>

1. Bir bulut kurulumunu tamamlayın (Google Drive veya Dropbox)
2. Otomatik bulut yedeklemesini ve aralığını etkinleştirin
3. Her şeyin çalıştığını doğrulamak için bir kez manuel yedekleme tetikleyin
4. "Son yedekleme" ipucunu periyodik olarak kontrol edin

</details>

<details>
<summary>Kritik değişikliklerden önce manuel yedekleme</summary>

Şunlardan önce ek bir yerel dışa aktarma oluşturun:

- büyük App güncellemeleri
- sistem sıfırlama/yeniden flaşlama
- telefon değiştirme

Kullanın: `Yedekleme → Özel Yol`, ardından dosyayı harici depolamaya kopyalayın.

</details>

## 4) Nasıl Geri Yüklenir :id=how-to-restore

<details>
<summary>Bulut yedeklemesinden geri yükleme (Google Drive / Dropbox / WebDAV)</summary>

1. Hedef cihazda aynı bulut hesabını/yöntemini yapılandırın
2. `Geri Yükleme`'ye dokunun ve o yöntemi seçin
3. Geri yüklemeyi onaylayın (App yeniden başlar)

> [!WARNING]
> Geri yükleme mevcut yerel verilerin üzerine yazar. Mevcut veriler önemliyse önce yerel bir yedek dışa aktarın.

</details>

<details>
<summary>Yerel yedekleme dosyasından geri yükleme</summary>

1. Yedekleme dosyasını hedef cihaza taşıyın
2. `Geri Yükleme → Özel Yol`'a dokunun
3. Yedekleme dosyasını seçin ve onaylayın

Doğrudan dosya yöneticisi veya paylaşım App'lerinden içe aktarmak için "Yedekleme dosyalarını açmak için dosya sistemini destekle" seçeneğini de etkinleştirebilirsiniz.

> [!TIP]
> Geri yükleme okuma/yazma hatasıyla başarısız olursa başka bir dosya yolu deneyin ve dosyayı yeniden seçin.

</details>

### Yeni Telefona Geçiş :id=phone-migration

<details>
<summary>Yeni telefona geçiş (sistem veya yedekleme yolu)</summary>

#### Seçenek A: Önce yerleşik telefon taşımayı kullanın

Bazı telefonlar tam App verisi taşımayı destekler (marka taşıma araçları / sistem klonlama).

1. Eski telefondan yeni telefona sistem taşımasını çalıştırın.
2. LifeUp'ı açın ve temel verileri doğrulayın (Görevler, Özellikler, Mağaza verileri, Başarımlar).
3. Taşıma sorunsuz görünse bile yeni telefonda bir taze yedekleme oluşturun.

#### Seçenek B: Bulut yedeklemesi veya yedekleme dosyasıyla taşıma (evrensel)

1. Eski telefonda önce taze bir yedekleme oluşturun.
2. Yeni telefonda LifeUp'ı yükleyin.
3. Bulut taşıması için: aynı bulut yöntemini/hesabını yapılandırın, ardından geri yükleyin.
4. Dosya taşıması için: yedekleme dosyasını aktarın, ardından `Geri Yükleme → Özel Yol` kullanın.
5. Geri yükledikten sonra yeni telefondaki yedekleme zincirini doğrulamak için bir manuel yedekleme tetikleyin.

> [!WARNING]
> Geri yükleme yerel verilerin üzerine yazar. Yeni telefonda zaten önemli yeni kayıtlar varsa önce dışa aktarın.

</details>

## 5) Sık Karşılaşılan Sorunlar :id=common-issues

<details>
<summary>Geri yükleme hatasını düzeltme: geçersiz yedekleme dosyası</summary>

- Dosyanın LifeUp tarafından oluşturulduğunu doğrulayın.
- `.lfbak` önerilen formattır.

</details>

<details>
<summary>Geri yükleme hatasını düzeltme: daha yüksek yedekleme sürümü dosyası</summary>

LifeUp'ı en son sürüme güncelleyin, ardından tekrar geri yükleyin.

</details>

<details>
<summary>Yavaş veya kararsız bulut yedeklemesini iyileştirme</summary>

- "Medya/resim dosyalarını yoksay" seçeneğini etkinleştirin.
- Otomatik yedekleme aralığını artırın.
- Yedeklemeden önce kullanılmayan medya dosyalarını temizleyin.

</details>

<details>
<summary>İndirme klasörü otomatik yedeklemesinin yeterli olup olmadığına karar verme</summary>

- Kaldırmayla ilgili kayba karşı yardımcı olur.
- Cihaz hasarı/kaybını kapsamaz.
- Daha güvenli strateji: bulut yedeklemesi + periyodik yerel dışa aktarma birleştirin.

</details>

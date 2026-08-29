<h1 align="center" padding="100">MCP & Skills</h1>

Yapay zekânın LifeUp ile çalışmasını mı istiyorsunuz? İki katman vardır:

| | Ne yapar | Kim kullanır |
|---|---|---|
| **MCP** `@lifeup/mcp` | LifeUp Cloud'u keşfeder, HTTP istekleri gönderir, parametreleri kodlar, yanıtları ayrıştırır | Cursor, Claude Desktop, WorkBuddy ve herhangi bir MCP istemcisi |
| **Skills** `lifeup-cloud/` | Nasıl bağlanılır, ne sorgulanır ve her API nasıl çağrılır | MCP `help` olarak paketlenir; Claude Code / Pi klasörü disk skill'i olarak da yükleyebilir |

Bilgisayarınızdaki ajan LAN üzerinden telefonunuzdaki LifeUp Cloud'a ulaşır, ardından LifeUp ile konuşur. HTTP ayrıntıları [LifeUp Cloud API](guide/api_cloud.md) belgesindedir. MCP kaynağı: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> **LifeUp 1.106.0**+ ve **LifeUp Cloud 3.0.0**+ gerektirir. Eski derlemeler hâlâ bağlanabilir, ancak günlükler, istatistikler ve Seviye eğrisi eksiktir. `status.update` kullanıcıyı yükseltmeye yönlendirebilir.

MCP ajana **okuma/yazma API'leri** verir; AI katmanı **akıl yürütme** ekler — bugünün birikimini önceliklendirme, günlüklerden haftalık istatistikleri özetleme, Özellik Seviyelerinize göre Görevler tasarlamak veya **tek prompt ile tam temalı oyunlaştırma kurulumu** (indie oyun geliştirme, büyü akademisi ve daha fazlası) — yalnızca ham listeleri çekmekten fazlası.

## Şöyle sorun

MCP kurulduktan sonra API'leri ezberlemenize gerek yok — yapay zekâ ile konuşmanız yeterli.

**Gününüzü planlayın**

- «Bugün ne kaldı? Önceliğe göre sırala ve önce neye başlayacağımı söyle.»
- «Yaklaşık 25 dakikada bitirebileceğim bitmemiş bir Görev seç.»

**Verilerinizi analiz edin**

- «Bu haftanın pomodoro, Odak, jeton ve Deneyim Puanı istatistiklerini çek — nereden geldiklerini ayır ve örüntüleri özetle.»
- «Bu ay jetonlarım nereden geldi? En büyük kaynakları ve şaşırtıcı olanları göster.»

**Koçluk ve tasarım**

- «Özellik Seviyelerime bak ve zayıf Yeteneklerimi yükseltecek günlük Görev seti tasarla.»

**Tek seferde temalı kurulum**

- «Örnekleri temizle ve tam indie oyun geliştirici kurulumu oluştur: listeler, Mağaza, Başarımlar ve Özellikler.»
- «Tam bir büyü akademisi RPG rutini tasarla — Görevler, Özellikler, Mağaza eşyaları ve Başarımlar.»

**Yansıtma**

- «Bugün bitirdiklerime bak ve kısa bir günlük yaz: ne yaptım ve yarın neyi geliştirebilirim.»
- «Morning Routine adında bir Başarım listesi oluştur, ardından emoji simgeli ve jeton Ödüllü 8 Başarım ekle.»
<br/>

## Hızlı başlangıç

MCP'yi kurmak ve ilk bağlantıyı tamamlamak için ajana şu tek satırı gönderin:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Skill dosyaları [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) içindedir (depoda tek kopya — ayrı npm paketi yok).

- **Cursor / Claude Desktop / WorkBuddy:** yalnızca MCP'yi kurun. `help` bu skill'i okur; iki kez kurmayın.
- **Claude Code / Pi / özel iş akışı:** klasörü ajanın skills yoluna kopyalayın veya doğrudan depoyu gösterin.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 bağlantı + yaygın işlemler (önce bunu okuyun)
  references/
    basics.md              hatalar, kodlama, JSON, zaman aşımları
    discovery.md           mDNS / token
    query.md               list_data kaynakları
    tasks.md / economy.md
    api-index.md           yöntem başına bir satır
    methods/*.md           tam parametre tablosu (çağırırken yükle)
    broadcasts.md / gaps.md
```

Ajan belgeleri aşamalı okur:

1. `help` (veya disk `SKILL.md`) — genel iş akışı
2. `help api-index` — hangi yöntemler var
3. `help add_task` — bir yöntemin parametreleri
4. `call_api` / `list_data` — çağrıyı yap

Özelleştirmek için: klasörü kopyalayıp `SKILL.md` ve `references/` dosyalarını düzenleyin. Fork'unuzdan MCP'yi yeniden derlemediğiniz sürece MCP `help` paketlenmiş kopyayı okumaya devam eder.

<br/>

## Kurulum

1. Telefon ve bilgisayar aynı LAN'da
2. LifeUp çalışıyor, Cloud'a **Read LifeUp Data** verilmiş
3. LifeUp Cloud başlatıldı (varsayılan port `13276`)
4. Bilgisayarda [Node.js 20+](https://nodejs.org/)

Token isteğe bağlıdır. Ayarlandıysa başlıkta **ham** token gönderin — `Bearer` değil.

<br/>

## MCP kurulumu

Paket npm'de yayınlanana kadar GitHub'dan kurun:

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx` depoyu klonlar ve `mcp/` derler. `main`'e geçince `#feat/mcp` kaldırın.

[LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)'yı zaten klonladıysanız kurulum betiğini kullanın (MCP derler ve algılanan istemcileri günceller; yeniden çalıştırmak ikinci kopya kaydetmez):

```bash
./scripts/install-mcp.sh
```

Varsayılan istemciler: Codex, Cursor, Claude Code, Claude Desktop, Pi. `imports: ["codex"]` olan Pi yapılandırmaları Codex'i devralır ve çoğaltılmaz.

macOS GUI App'lerinde genellikle `PATH`'te `npx` yoktur — mutlak `npx`/`node` yolu kullanın veya klonlayıp `cd mcp && npm install && npm run build` çalıştırın.

| Variable | Rol |
|---|---|
| `LIFEUP_HOST` | örn. `192.168.1.8:13276`, mDNS atla |
| `LIFEUP_TOKEN` | Yalnızca süreç içi, diske yazılmaz |
| `LIFEUP_MCP_CONFIG` | Özel yapılandırma yolu |

Yayından sonra: `npx -y @lifeup/mcp` (Çin'de npmmirror).
<br/>

## Ajan iş akışı :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT `port` HTTP portudur. Tam olarak bir Cloud örneği bulunursa otomatik bağlanır.
2. `connect` — sıfır veya birden fazla örnek bulunduğunda `host` geçirin.
3. `status` — sürümleri kontrol edin; 1.106.0 / 3.0.0 altındaysa `update`'e dikkat edin.
4. Listeler: `list_data` (varsayılan olarak kompakt alanlar).
5. Yazma: `complete_task` / `add_task` / `reward` / `purchase_item`; geri kalanı `call_api` ile. App UI'ını açmak için `via=launch` kullanın.

Yıkıcı çağrılar `confirm: true` gerektirir. Parametre değerlerini önceden kodlamayın.

## Events

LifeUp: Labs → Broadcast events etkinleştirin (varsayılan kapalı; Cloud Advanced durumu gösterebilir ve etkinleştirebilir). Cloud **WebSocket event push varsayılan açık** (3.0.0+) ve yalnızca taşımadır.

- `list_events` — `GET /events`, her zaman kullanılabilir
- `subscribe_events` — `WS /events`; Cloud anahtarı kapalıysa hata, HTTP hâlâ çalışır

Ayrıntılar: MCP `help broadcasts`.

<br/>

---

## Örnek: Indie oyun geliştirici kurulumu

Aşağıda gerçek bir MCP oturumunun sonucu var: kullanıcı yapay zekâdan **LifeUp'ın yerleşik geliştirici örneklerini temizlemesini**, ardından **indie oyun geliştirme** etrafında tam RPG tarzı kurulum (Görev listeleri, Özellikler, Mağaza, Başarımlar) oluşturmasını istedi.

Şu gibi promptlarla başlayabilirsiniz:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Oluşturulanlar

| Alan | İçerik |
| --- | --- |
| Görev listeleri | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Özellikler | Execution / Technical / Collaboration / Focus / Wellness / Creativity, artı **Developer Stats** (Game Design, Debugging, Architecture) |
| Mağaza | **Dev Supplies** (sarf malzemeleri) + **Fun Collectibles** (easter egg eşyaları) |
| Başarımlar | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Yakınlaştırmak için herhangi bir görsele tıklayın. Uzun sayfayı kaydırmak yerine yatay geçiş için aşağıdaki sekmeleri kullanın.

<!-- tabs:start -->

#### **1 · Görevlere genel bakış**

**All** görünümünde Morning Ritual tekrarlayan Görevler; Coding Daily, Game Dev ve daha fazlası için kategori etiketleri.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Özellikler**

Altı temel Özellik ve **Developer Stats** grubu. Görevleri tamamlamak eşleşen Yeteneklere Deneyim Puanı verir.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Easter egg Mağaza eşyaları: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — bazıları rastgele jeton veya Özellik bonusu içerir.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Başarımlar**

Kilometre taşı Başarımları: ilk Görev, ilk hata düzeltme, demo yayınlama, seriler, pomodorolar, Piggy Bank, Daily Pentakill ve daha fazlası — emoji simgeleri ve kilidini açma koşullarıyla.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Piggy Bank ayrıntısı**

İlerleme tarzı koşul örneği: **500 jeton** mevcut bakiyeye ulaş.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Daily Pentakill ayrıntısı**

Sayaç koşulu örneği: **bir günde 5 farklı Görev** tamamla.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Yapay zekâ genellikle ne yapar

1. `list_tasks` / `list_items` — mevcut örnekleri inceler; gerekirse eski satırları siler (yıkıcı çağrılar için `confirm: true`).
2. Görev / Mağaza / Başarım listeleri oluşturur (`category`).
3. Özellikler ve gruplar oluşturur (`skill` / `skill_group`).
4. Görevleri, Eşyaları ve Başarımları toplu yazar (`add_task` / `add_item` / `achievement`).
5. Doğrulamak için App'te ilgili ekranları yeniler.

API parametreleri için yukarıdaki [Skills](#skills) ve [Ajan iş akışı](#agent-workflow) bölümlerine bakın; yöntem tabloları MCP `help add_task` vb. ile.

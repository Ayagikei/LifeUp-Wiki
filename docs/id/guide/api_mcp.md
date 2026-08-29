<h1 align="center" padding="100">MCP & Skills</h1>

Ingin AI bekerja dengan LifeUp? Ada dua lapisan:

| | Fungsi | Siapa yang memakai |
|---|---|---|
| **MCP** `@lifeup/mcp` | Menemukan LifeUp Cloud, mengirim permintaan HTTP, mengodekan param, mengurai respons | Cursor, Claude Desktop, WorkBuddy, dan klien MCP apa pun |
| **Skills** `lifeup-cloud/` | Cara terhubung, apa yang dikueri, dan cara memanggil setiap API | Dibundel sebagai MCP `help`; Claude Code / Pi juga dapat memuat folder sebagai disk skill |

Agen di komputer Anda menjangkau LifeUp Cloud di ponsel lewat LAN, lalu berkomunikasi dengan LifeUp. Detail HTTP ada di [API LifeUp Cloud](guide/api_cloud.md). Sumber MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Memerlukan **LifeUp 1.106.0**+ dan **LifeUp Cloud 3.0.0**+. Build lama mungkin masih terhubung, tapi jurnal, statistik, dan kurva Level belum lengkap. `status.update` dapat meminta pengguna untuk memperbarui.

MCP memberi agen **API baca/tulis**; lapisan AI menambahkan **penalaran** — memprioritaskan backlog hari ini, merangkum statistik mingguan dari jurnal, merancang Tugas dari Level Atribut Anda, atau **membangun penyiapan gamifikasi tematik lengkap dalam satu prompt** (pengembang game indie, akademi sihir, dan lain-lain) — bukan hanya mengambil daftar mentah.

## Coba tanyakan

Setelah MCP terpasang, Anda tidak perlu menghafal API — cukup bicara dengan AI.

**Rencanakan hari Anda**

- «Apa yang tersisa hari ini? Urutkan menurut prioritas dan beri tahu apa yang harus dikerjakan dulu.»
- «Pilih satu Tugas belum selesai yang bisa saya selesaikan dalam sekitar 25 menit.»

**Analisis data Anda**

- «Ambil statistik pomodoro, Fokus, koin, dan Poin Pengalaman minggu ini — uraikan asalnya dan rangkum polanya.»
- «Dari mana koin saya bulan ini? Tampilkan sumber terbesar dan hal yang mengejutkan.»

**Pelatih & desain**

- «Lihat Level Atribut saya dan rancang serangkaian Tugas harian untuk meningkatkan Keterampilan yang lebih lemah.»

**Penyiapan tematik sekali jalan**

- «Hapus sampel, lalu buat penyiapan pengembang game indie lengkap: daftar, Toko, Pencapaian, dan Atribut.»
- «Rancang rutinitas RPG akademi sihir lengkap — Tugas, Atribut, Item Toko, dan Pencapaian.»

**Refleksi**

- «Lihat apa yang saya selesaikan hari ini dan tulis jurnal singkat: apa yang saya lakukan, dan apa yang bisa diperbaiki besok.»
- «Buat daftar Pencapaian bernama Morning Routine, lalu tambahkan 8 Pencapaian dengan ikon emoji dan Hadiah koin.»
<br/>

## Mulai cepat

Kirim satu baris ini ke agen Anda untuk memasang MCP dan terhubung pertama kali:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

File skill ada di [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (satu salinan di repo — tanpa paket npm terpisah).

- **Cursor / Claude Desktop / WorkBuddy:** pasang MCP saja. `help` membaca skill ini; jangan pasang dua kali.
- **Claude Code / Pi / alur kustom:** salin folder ke path skills agen, atau arahkan langsung ke repo.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connect + common ops (read this first)
  references/
    basics.md              errors, encoding, JSON, timeouts
    discovery.md           mDNS / token
    query.md               list_data resources
    tasks.md / economy.md
    api-index.md           one line per method
    methods/*.md           full param table (load when calling)
    broadcasts.md / gaps.md
```

Agen membaca dokumen secara progresif:

1. `help` (atau disk `SKILL.md`) — alur kerja keseluruhan
2. `help api-index` — metode apa saja yang ada
3. `help add_task` — param untuk satu metode
4. `call_api` / `list_data` — lakukan panggilan

Untuk kustomisasi: salin folder dan edit `SKILL.md` serta `references/`. MCP `help` tetap membaca salinan yang dibundel kecuali Anda membang ulang MCP dari fork Anda.

<br/>

## Penyiapan

1. Ponsel dan komputer di LAN yang sama
2. LifeUp berjalan, dengan Cloud diberi izin **Read LifeUp Data**
3. LifeUp Cloud dijalankan (port default `13276`)
4. [Node.js 20+](https://nodejs.org/) di komputer

Token opsional. Jika diset, kirim token **mentah** di header — bukan `Bearer`.

<br/>

## Pasang MCP

Sampai paket ada di npm, pasang dari GitHub:

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

`npx` meng-clone repo dan membangun `mcp/`. Setelah ini masuk `main`, hapus `#feat/mcp`.

Jika Anda sudah meng-clone [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), gunakan installer (membangun MCP dan meng-upsert klien terdeteksi; menjalankan ulang tidak mendaftarkan salinan kedua):

```bash
./scripts/install-mcp.sh
```

Klien default: Codex, Cursor, Claude Code, Claude Desktop, Pi. Konfig Pi yang `imports: ["codex"]` mewarisi Codex dan tidak diduplikasi.

App GUI di macOS sering tidak punya `npx` di `PATH` — gunakan path absolut `npx`/`node`, atau clone dan jalankan `cd mcp && npm install && npm run build`.

| Variabel | Peran |
|---|---|
| `LIFEUP_HOST` | mis. `192.168.1.8:13276`, lewati mDNS |
| `LIFEUP_TOKEN` | Hanya proses, tidak pernah ditulis ke disk |
| `LIFEUP_MCP_CONFIG` | Path konfig kustom |

Setelah diterbitkan: `npx -y @lifeup/mcp` (npmmirror di Tiongkok).
<br/>

## Alur kerja agen :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT `port` adalah port HTTP. Terhubung otomatis jika tepat satu instance Cloud ditemukan.
2. `connect` — berikan `host` jika nol atau beberapa instance ditemukan.
3. `status` — periksa versi; jika di bawah 1.106.0 / 3.0.0, perhatikan `update`.
4. Daftar: `list_data` (field ringkas secara default).
5. Tulis: `complete_task` / `add_task` / `reward` / `purchase_item`; sisanya lewat `call_api`. Gunakan `via=launch` untuk membuka UI App.

Panggilan destruktif memerlukan `confirm: true`. Jangan pre-encode nilai parameter.

## Events

LifeUp: aktifkan Labs → Broadcast events (mati secara default; Cloud Advanced dapat menampilkan status dan mengaktifkannya). **WebSocket event push Cloud aktif secara default** (3.0.0+) dan hanya transport.

- `list_events` — `GET /events`, selalu tersedia
- `subscribe_events` — `WS /events`; error jika toggle Cloud mati, HTTP tetap berfungsi

Detail: MCP `help broadcasts`.

<br/>

---

## Contoh: Penyiapan pengembang game indie

Di bawah ini hasil sesi MCP nyata: pengguna meminta AI **menghapus sampel developer bawaan LifeUp**, lalu membangun penyiapan gaya RPG lengkap seputar **pengembangan game indie** (daftar Tugas, Atribut, Toko, Pencapaian).

Anda dapat memulai dengan prompt seperti:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Apa yang dibangun

| Area | Konten |
| --- | --- |
| Daftar Tugas | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Atribut | Execution / Technical / Collaboration / Focus / Wellness / Creativity, plus **Developer Stats** (Game Design, Debugging, Architecture) |
| Toko | **Dev Supplies** (consumables) + **Fun Collectibles** (Item easter egg) |
| Pencapaian | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Klik gambar apa pun untuk memperbesar. Gunakan tab di bawah untuk beralih horizontal alih-alih menggulir halaman panjang.

<!-- tabs:start -->

#### **1 · Ringkasan Tugas**

Tugas berulang Morning Ritual di tampilan **All**, dengan chip kategori untuk Coding Daily, Game Dev, dan lain-lain.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Atribut**

Enam Atribut inti plus grup **Developer Stats**. Menyelesaikan Tugas memberi Poin Pengalaman ke Keterampilan yang sesuai.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Item Toko easter egg: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — sebagian dengan koin acak atau bonus Atribut.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Pencapaian**

Pencapaian milestone: Tugas pertama, perbaikan bug pertama, rilis demo, streak, pomodoro, Piggy Bank, Daily Pentakill, dan lain-lain — dengan ikon emoji dan kondisi buka kunci.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Detail Piggy Bank**

Contoh kondisi gaya progres: capai saldo koin **500** saat ini.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Detail Daily Pentakill**

Contoh kondisi penghitung: selesaikan **5 Tugas berbeda dalam satu hari**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Apa yang biasanya dilakukan AI

1. `list_tasks` / `list_items` — periksa sampel yang ada; hapus baris lama jika perlu (`confirm: true` untuk panggilan destruktif).
2. Buat daftar Tugas / Toko / Pencapaian (`category`).
3. Buat Atribut dan grup (`skill` / `skill_group`).
4. Tulis batch Tugas, Item, dan Pencapaian (`add_task` / `add_item` / `achievement`).
5. Segarkan layar yang sesuai di App untuk verifikasi.

Untuk param API lihat [Skills](#skills) dan [Alur kerja agen](#agent-workflow) di atas; tabel per-metode lewat MCP `help add_task`, dll.

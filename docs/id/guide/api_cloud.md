<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud adalah salah satu toolkit API inti untuk LifeUp. Cloud mengubah ponsel Anda menjadi **jembatan API**: kendalikan LifeUp dari **komputer atau perangkat lain**, bangun **integrasi kustom** (desktop, web, skrip otomatis), atau pasangkan dengan **agen AI**.

### Skenario umum

| Skenario | Untuk siapa | Satu kalimat | Pelajari lebih lanjut |
| --- | --- | --- | --- |
| **HTTP + bangun sendiri** | Developer, pengguna otomatisasi | Panggil API dan kueri data dari Python, web app, atau skrip lewat LAN — tidak perlu pengalaman Android | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **Pemindaian QR** | Penggemar check-in di dunia nyata | Cetak kode QR untuk menyelesaikan Tugas, memulai timer, membuka dialog, atau meluncurkan halaman web / app lain | [Pemindaian kode QR](#qr-code-scanning) |
| **Pintasan start / stop** | Otomatisasi, NFC, Tasker | `lifeupcloud://start` dan `lifeupcloud://stop` membuka Cloud dan memulai atau menghentikan server HTTP | [Start dan stop](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude, dll. | Satu prompt untuk membangun daftar Tugas, Item Toko, Pencapaian, dan lain-lain | [MCP & Skills](guide/api_mcp.md) |
> **Contoh prompt AI:** Hapus Tugas dan Item Toko sampel, lalu buat penyiapan pengembang game indie lengkap: daftar Tugas, Atribut, Item Toko, dan Pencapaian.

<br/>

## Unduh

- Jika memakai versi keanggotaan Tiongkok daratan, Anda dapat menemukan entri unduhan LifeUp Cloud di `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Memulai dan menghentikan layanan Cloud :id=cloud-scheme

Anda dapat memulai atau menghentikan server HTTP tanpa mengetuk **Start Service**, menggunakan skema URL berikut:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Membuka salah satu URL meluncurkan LifeUp Cloud dan menerapkan aksi. Gunakan sebagai pintasan layar utama, tag NFC, aksi Tasker/otomatisasi, atau:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

URL yang sama tercantum di kartu status Cloud — ketuk untuk menyalin.

> [!NOTE]
> `lifeupcloud://` mengontrol server HTTP Cloud itu sendiri. Bukan API game `lifeup://api/…`.

<br/>

## Pemindaian kode QR :id=qr-code-scanning

Tombol **Scan** di bagian atas LifeUp Cloud membaca URL yang dikodekan dalam kode QR dan segera membukanya — tanpa entri manual.

Pemindaian **tidak terbatas pada API LifeUp**: `lifeup://api/…`, halaman web `https://…`, dan skema URL app lain (mis. `weixin://`) semuanya berfungsi — Android membuka target yang cocok.

### Cara memakai

1. Pilih URL dari LifeUp atau [daftar API](guide/api.md) wiki (menyelesaikan Tugas, memulai pomodoro, membuka dialog beli/gunakan, atau membuka halaman web eksternal).

2. Buat kode QR dari URL lengkap (cetak dan tempel di meja, dinding, atau perangkat).

3. Buka LifeUp Cloud, ketuk **Scan** (ketuk **?** di sampingnya untuk panduan singkat in-app), dan arahkan ke kode.

### Apa yang bisa dilakukan

| Skenario | Contoh (ilustratif) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` mulai/hentikan timer |
| Check-in Tugas | `lifeup://api/complete?name=...` selesaikan Tugas |
| Interaksi Toko | `lifeup://api/goto?page=shop` atau dialog beli/gunakan |
| Hadiah / penalti | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Mini-game web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| App lain | `weixin://`, `intent://`, atau skema app terpasang apa pun |
| Alur kustom | Kombinasi URL yang dapat dipindai |

### Interaksi dunia nyata

Kode QR memetakan **tempat atau aksi fisik** ke gamifikasi in-app:

- Stiker **peralatan gym** → pindai untuk menyelesaikan Tugas latihan kekuatan

- Stiker **meja belajar** → pindai untuk memulai pomodoro Fokus

- Stiker **workstation** → pindai untuk mencatat stand-up atau code review

- Stiker **papan acara** → pindai untuk mengklaim Hadiah atau membuka Pencapaian

Singkatnya: **ubah URL Scheme menjadi pemicu fisik yang dapat dipindai**, dengan LifeUp Cloud sebagai eksekutor antara app dan dunia nyata.

<br/>

> [!NOTE]
> LifeUp Cloud adalah jembatan HTTP khusus LAN. Cara Anda menjangkau ponsel — alamat IP, router, firewall, subnet yang sama, VPN, atau isolasi AP — tergantung jaringan rumah Anda. Jika tidak dapat terhubung, kami tidak dapat mendebug LAN pribadi Anda. Periksa jaringan sendiri, gunakan alat jaringan standar, atau minta bantuan agen AI.

## Definisi HTTP API :id=http-api-definition

> [!WARNING]
> Dokumen API di halaman ini mungkin tertinggal dari pembaruan implementasi. Gunakan kode sumber sebagai referensi akhir: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API Pemanggilan URL Scheme

#### GET

Fungsi:

> Memanggil API yang diawali `lifeup://api`.

URL permintaan:

```txt
// Direkomendasikan: mode content provider (kompatibilitas lebih baik)
http://{host:port}/api/contentprovider

// mode startActivity (beberapa perangkat dapat memblokir UI latar belakang)
http://{host:port}/api
```

**Method: `GET`**

**Parameter query:**

| Field | Deskripsi | Lokasi | Tipe | Wajib | Catatan |
| --- | --- | --- | --- | --- | --- |
| url | URL API yang diawali `lifeup://api` | Query | string | Ya | URL-encode saat membangun manual. Beberapa param `url` didukung. |

**Contoh permintaan:**

```txt
// Panggilan tunggal (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Panggilan batch
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Panggilan tunggal (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Fungsi:

> Memanggil API yang diawali `lifeup://api`.

URL permintaan:

```txt
// Direkomendasikan: mode content provider (kompatibilitas lebih baik)
http://{host:port}/api/contentprovider

// mode startActivity (beberapa perangkat dapat memblokir UI latar belakang)
http://{host:port}/api
```

**Method: `POST`**

**Parameter body JSON:**

| Field | Deskripsi | Lokasi | Tipe | Wajib | Catatan |
| --- | --- | --- | --- | --- | --- |
| urls | Array URL yang diawali `lifeup://api` | Body | List<string> | Ya | Tidak perlu URL encoding ekstra di body JSON. |

**Contoh permintaan:**

```txt
// POST
http://{host:port}/api/contentprovider

// Body JSON
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. API Kueri Data

> [!NOTE]
> Persyaratan:
> 1. LifeUp v1.91+ dan LifeUp Cloud terbaru.
> 2. Berikan izin **Read LifeUp Data** di LifeUp Cloud.

Fungsi:

> Kueri set data LifeUp lengkap, seperti Tugas dan Item.

**Endpoint Tugas**

```txt
// Semua Tugas
http://{host:port}/tasks

// Tugas di kategori/daftar ${id}
http://{host:port}/tasks/${id}

// Riwayat (mendukung paginasi)
// gid opsional dan dapat memfilter semua catatan riwayat Tugas berulang
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Kategori Tugas
http://{host:port}/tasks_categories
```

**Endpoint Item**

```txt
// Semua Item
http://{host:port}/items

// Item di kategori/daftar ${id}
http://{host:port}/items/${id}

// Kategori Item
http://{host:port}/items_categories

// Sertakan daftar tersembunyi
http://{host:port}/items_categories?include_hidden=true
```

**Endpoint Pencapaian**

```txt
// Semua Pencapaian
http://{host:port}/achievements

// Pencapaian di kategori/daftar ${id}
http://{host:port}/achievements/${id}

// Kategori Pencapaian
http://{host:port}/achievement_categories
```

**Endpoint Perasaan**

```txt
// Semua Perasaan (mendukung paginasi)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Endpoint kategori Sintesis**

```txt
// Semua kategori Sintesis
http://{host:port}/synthesis_categories

// Kategori Sintesis di daftar ${id}
http://{host:port}/synthesis_categories/${id}
```

**Endpoint resep Sintesis**

```txt
// Semua resep Sintesis
http://{host:port}/synthesis

// Resep Sintesis di kategori ${id}
http://{host:port}/synthesis/${id}
```

**Endpoint Atribut**

```txt
// Semua Atribut
http://{host:port}/skills
```


**Lainnya**

```txt
// Saldo koin
http://{host:port}/coin

// Versi LifeUp / Cloud
http://{host:port}/info

// Catatan Pomodoro (berhalaman; rentang waktu opsional)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Jurnal (berhalaman; rentang waktu opsional). Baris soft-deleted diabaikan.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Semua Pencapaian (diimplementasikan; id kategori opsional)
http://{host:port}/achievements

// Event broadcast. LifeUp Labs → Broadcast events mati secara default; Cloud Advanced dapat menampilkan status dan mengaktifkannya. GET data.broadcasts adalah switch itu (diabaikan jika belum dibaca). Pengaturan WebSocket Cloud hanya transport.
http://{host:port}/events?after=${id}&limit=50

// Push WebSocket (aktif secara default; pengaturan Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` hanya OK transport. `10001` LifeUp tidak berjalan atau Read Data tidak diberikan. `10002` kueri ContentProvider gagal.

### Nilai field daftar

| Endpoint | Field | Nilai |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` belum selesai · `1` selesai · `2` terlambat · `3` menyerah |
| `/tasks` | `frequency` | `0` sekali · `1` harian · `N>1` setiap N hari · `-1` tak terbatas · `-3` Ebbinghaus · `-4` bulanan · `-5` tahunan |
| `/tasks` | `weekdays` | `1,3,5` (Sen=1 … Min=7). Kosong jika bukan mode weekday. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` diarsipkan |
| `/tasks_categories` | `type` | `<10` normal · `10` harian · `11` mingguan · `12` bulanan · `20` doing |
| `/achievements` | `status` | `0` terkunci · `1` terbuka, Hadiah belum diklaim · `2` terbuka, diklaim |
| `/achievements` | `type` | `0` normal · `1` subkategori |
| `/achievement_categories` | `type` | `0` pengguna · `1` sistem |
| `/feelings` | `type` | `0` Tugas · `1` Pencapaian · `2` raw · `3` penggunaan Item |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` pengguna · `1` strength · `2` learning · `3` charm · `4` endurance · `5` vitality · `6` creative |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` terlihat · `1` tersembunyi (flag independen) |
| `/synthesis_categories` | `hidden` | `0` terlihat · `1` tersembunyi |
| `/pomodoro_records` | `reward` | `0` ditinggalkan · `0.5×n` setengah · selain itu kelipatan penuh |
| `/coin_records` `/inventory_records` | `resCode` | Toko: `0` beli · `1` gunakan · `2` selesai Tugas · `3` batalkan selesai · `4` clear · `5` menyerah · `6` terlambat · `7` buka kunci Pencapaian · `8` cabut menyerah · `9` cabut terlambat · `10` return · `11` selesai subtugas · `12` batalkan subtugas · `13` buka kunci Pencapaian pengguna · `14` batalkan Pencapaian pengguna · `15` deposit · `16` withdraw · `17` jual tomat · `20` Hadiah Item · `21` batalkan Hadiah Item · `23` Sintesis · `24` Kotak Jarahan · `25` bunga ATM · `26` tukar tomat · `27` bunga kredit · `28` API · `29` effect stock |
| `/exp_records` | `resCode` | Exp (bukan Toko `28`): `0` unknown · `1` selesai · `2` Pencapaian · `3` like exchange · `4` day streak · `5` langkah · `6` set finished · `7` cabut menyerah · `8` cabut terlambat · `9` eat tomato · `10` used item · `11` buka kunci Pencapaian pengguna · `12` selesai subtugas · `200` API · `101` batalkan selesai · `102` menyerah · `103` terlambat · `104` used item debit · `105` kunci Pencapaian pengguna · `106` batalkan subtugas |

`GET /items_categories`, `GET /synthesis_categories`, dan `GET /skill_groups` menerima `include_hidden=true` (daftar tersembunyi diabaikan secara default). Kondisi buka kunci Pencapaian: `GET /achievement_conditions/{id}`. `status` Keterampilan (0 normal / 1 tersembunyi) hanya di `query`/`query_skill`, **bukan** `GET /skills`.

**Method: `GET`**

**Parameter:**

| Field | Deskripsi | Lokasi | Tipe | Wajib | Catatan |
| --- | --- | --- | --- | --- | --- |
| id | ID data | Path/Query | Number | Ya (untuk endpoint spesifik ID) | - |
| offset | Offset kueri | Query | Number | Tidak | Hanya diperlukan untuk beberapa endpoint berhalaman |
| limit | Ukuran halaman | Query | Number | Tidak | Hanya diperlukan untuk beberapa endpoint berhalaman |
| gid | Filter riwayat Tugas berulang | Query | Number | Tidak | Opsional untuk kueri riwayat |
| include_hidden | Sertakan daftar tersembunyi | Query | Boolean | Tidak | Default false. Dipakai oleh `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Awal rentang (ms) | Query | Number | Tidak* | Harus dipasangkan dengan `time_range_end`. Rentang parsial/tidak valid mengembalikan `invalid_parameter` |
| time_range_end | Akhir rentang (ms) | Query | Number | Tidak* | Harus lebih besar dari `time_range_start` |

**Contoh permintaan**

**Tugas**

```txt
// Semua Tugas
http://{host:port}/tasks

// Tugas di daftar ID 1
http://{host:port}/tasks/1

// Riwayat (100 catatan dari indeks 0)
http://{host:port}/history?offset=0&limit=100

// Kategori Tugas
http://{host:port}/tasks_categories
```

**Item**

```txt
// Semua Item
http://{host:port}/items

// Kueri ID Item spesifik 1 dan 4
http://{host:port}/items?id=1&id=4

// Item di daftar ID 1
http://{host:port}/items/1

// Kategori Item
http://{host:port}/items_categories
```

**Pencapaian**

```txt
// Pencapaian di daftar/kategori ${id}
http://{host:port}/achievements/${id}

// Kategori Pencapaian
http://{host:port}/achievement_categories
```

**Perasaan**

```txt
// 100 catatan dari indeks 0
http://{host:port}/feelings?offset=0&limit=100
```

**Atribut**

```txt
http://{host:port}/skills
```

**Kategori Sintesis**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Resep Sintesis**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API Gambar/File

> [!NOTE]
> Karena pembatasan penyimpanan Android, LifeUp Cloud mungkin perlu membuat salinan file saat menyajikan konten gambar dari LifeUp.

Fungsi:

> Memuat sumber gambar/file yang dikembalikan oleh API data (biasanya `content://...`).

URL permintaan:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Parameter path:**

| Field | Deskripsi | Lokasi | Tipe | Wajib | Catatan |
| --- | --- | --- | --- | --- | --- |
| url | URL file | Path | String | Ya | - |

**Contoh permintaan:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Kueri ContentProvider Keterampilan

> [!NOTE]
> Memerlukan v1.103.0+

Untuk kueri daftar atau terstruktur, Anda dapat membaca URI ContentProvider berikut lewat endpoint `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Hanya mengembalikan Keterampilan yang terlihat.

| Column | Arti | Tipe | Catatan |
| ------ | ------- | ---- | ----- |
| _ID | ID Keterampilan | number | - |
| name | Nama Keterampilan | string | - |
| desc | Deskripsi | string | Mungkin kosong |
| icon | URI ikon | string | Mungkin kosong |
| order | Urutan sort mentah | number | `orderInCategory` |
| group_id | ID grup Keterampilan | number / null | Mungkin kosong jika Keterampilan tidak dalam grup |
| color | Warna | number / null | Mungkin kosong |
| exp | Poin Pengalaman | number | - |
| level | Level saat ini | number | - |
| until_next_level_exp | EXP ke Level berikutnya | number | - |
| current_level_exp | EXP diperoleh di Level saat ini | number | - |
| type | Tipe Keterampilan | number | - |
| status | Status Keterampilan | number | `0` = normal, `1` = tersembunyi |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Hanya mengembalikan grup Keterampilan yang terlihat.

| Column | Arti | Tipe | Catatan |
| ------ | ------- | ---- | ----- |
| _ID | ID grup Keterampilan | number | - |
| content | Nama grup | string | - |
| order | Urutan sort mentah | number | `orderInCategory` |
| collapsed | Status collapse | string | Dikembalikan sebagai teks `true` / `false` |

<br/>

## Kontribusi

SDK, LifeUp Cloud, dan LifeUp Desktop semuanya proyek open source.

Anda dapat mendapatkan kode sumber di:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

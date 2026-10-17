<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Kami sedang meluncurkan **LifeUp v1.106.0** dan **LifeUp Cloud v3.0.0** secara bertahap. Karena jadwal tinjauan platform bervariasi, dokumentasi ini mungkin diperbarui sebelum App tersedia secara luas; tanggal rilis aktual bisa lebih lambat dari yang tampil di sini.

LifeUp Cloud adalah salah satu toolkit API inti untuk LifeUp. Cloud mengubah ponsel Anda menjadi **jembatan API**: kendalikan LifeUp dari **komputer atau perangkat lain**, bangun **integrasi kustom** (desktop, web, skrip otomatis), atau pasangkan dengan **agen AI**.

### Skenario umum

| Skenario | Untuk siapa | Satu kalimat | Pelajari lebih lanjut |
| --- | --- | --- | --- |
| **HTTP + bangun sendiri** | Developer, pengguna otomatisasi | Panggil API dan kueri data dari Python, web app, atau skrip lewat LAN — tidak perlu pengalaman Android | [Referensi API HTTP](/guide/api-reference), [Desktop](guide/api_desktop.md) |
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

## Menghubungkan ke LifeUp Cloud :id=connect

1. Instal versi LifeUp dan LifeUp Cloud yang kompatibel. Buka LifeUp Cloud dan berikan izin data/API LifeUp saat diminta.
2. Mulai layanan HTTP. Dari perangkat yang dapat menjangkau ponsel di jaringan Anda, gunakan alamat dan port yang ditampilkan Cloud sebagai URL dasar.
3. Jika Anda mengonfigurasi token Cloud, kirim token mentah dalam header `Authorization`. Kueri `/info` untuk memeriksa konektivitas dan versi terpasang; periksa status HTTP serta `code` JSON.

## Referensi API HTTP :id=http-api-definition

[Referensi antarmuka dan parameter lengkap](/guide/api-reference) berisi indeks rute, aturan respons/paginasi bersama, model data lengkap, parameter permintaan, dan contoh JSON. Bacalah saat membangun integrasi. [Metode URL Scheme](/guide/api) menjelaskan tiap aksi; [MCP & Skills](/guide/api_mcp) menjelaskan alat agen AI.

### Stempel waktu tugas dan riwayat :id=task-history-timestamps

Lihat [model waktu tugas](/guide/api-reference?id=task-times): `startTime` adalah awal terencana, `deadline` adalah tenggat, dan `endTime` riwayat adalah waktu selesai/lewat tenggat/ditinggalkan yang tercatat, ditafsirkan bersama `status`.

#### Laporan harian dan kelengkapan riwayat :id=history-daily-reports

Lihat [paginasi riwayat dan laporan harian](/guide/api-reference?id=daily-report), serta [jurnal EXP/koin](/guide/api-reference?id=reward-journals) untuk perubahan hadiah aktual.

## Kontribusi

SDK, LifeUp Cloud, dan LifeUp Desktop semuanya proyek open source.

Anda dapat mendapatkan kode sumber di:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

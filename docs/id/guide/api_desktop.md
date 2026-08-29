<h1 align="center" padding="100">Klien Desktop Jaringan Lokal (API) 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Kami membangun klien desktop ringan untuk LifeUp berbasis API LifeUp. Mendukung Windows, Linux, dan macOS.

**Ini bukan app mandiri.** Klien ini membaca data offline LifeUp dari ponsel Anda melalui akses API.

<br/>

## Fitur

> [!NOTE]
> Versi saat ini terutama pratinjau teknis kemampuan API. Fokus pada operasi inti penelusuran dan belum mencakup setiap fitur in-app.

- Sepenuhnya open source. Anda dapat menyesuaikan UI dan mengimplementasikan fitur sendiri.
- Kemampuan dasar saat ini:
  - Kueri daftar Tugas dan menyelesaikan Tugas
  - Kueri daftar Atribut dan Level
  - Kueri daftar Item dan membeli Item
  - Kueri Perasaan dan melihat gambar ukuran penuh di desktop
  - Mengekspor Perasaan ke file Markdown
  - Menambah Tugas (belum semua opsi in-app tercakup)

<br/>

## Unduh

Semua paket desktop diterbitkan di [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Sebelum memakai desktop, pastikan LifeUp Cloud v2.0.0 atau lebih baru.<br/>
> Jika memakai build GitHub Releases, perbarui LifeUp Cloud di `Settings` → `Labs`.<br/>
> Jika memakai build Google Play, Anda dapat memperbarui dari [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) atau [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Beberapa browser dapat memblokir unduhan installer karena kebijakan keamanan. Pilih **Keep/Allow** (redaksi bervariasi menurut browser), atau gunakan pengunduh lain.

### Platform Instalasi

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> MSI saat ini belum ditandatangani EV, sehingga Windows dapat menampilkan peringatan «app tidak dikenali».<br/>
> Setelah memastikan file berasal dari rilis GitHub resmi, klik **More info → Run anyway**.

#### **Linux**

- Unduh dari [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) dan gunakan `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- Build macOS belum sepenuhnya diuji, dan beberapa fitur seperti **Auto Connect** mungkin tidak tersedia.

> [!TIP]
> **macOS Gatekeeper / signature**<br/>
> Build macOS saat ini belum dinotarisasi. Anda mungkin melihat peringatan «developer tidak teridentifikasi».<br/>
> Anda dapat membuka `.dmg`, memindahkan app ke Applications, lalu klik kanan app dan pilih **Open**,<br/>
> atau buka **System Settings → Privacy & Security** dan klik **Open Anyway**.<br/>
> Lihat [panduan resmi Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) untuk detail.

<!-- tabs:end -->

Jika paket sementara belum tersedia, segarkan nanti. Aset rilis mungkin masih diunggah.

<br/>

## Cara memakai

### Penyiapan pertama kali

#### Prasyarat

- Ponsel dan desktop harus berada di LAN yang sama (misalnya, Wi-Fi yang sama).
- <del>Jika jaringan Anda kompleks, uji dulu apakah desktop dapat ping IP ponsel.</del>
  - Versi desktop baru mendukung deteksi IP ponsel otomatis, sehingga langkah ini sering tidak diperlukan.

#### Di ponsel

1. Perbarui LifeUp ke versi terbaru.
2. Di LifeUp, buka `Settings` → `Labs`, lalu pasang **LifeUp Cloud**.
3. Buka LifeUp Cloud dan berikan izin yang diperlukan:
   - Izin jendela mengambang / draw-over-apps
   - Izin baca data LifeUp
4. Ketuk **Start Service** di LifeUp Cloud.

**Penyiapan tambahan yang direkomendasikan**

- Lakukan penyiapan kompatibilitas untuk LifeUp dan LifeUp Cloud, dan nonaktifkan optimisasi baterai untuk mengurangi masalah pembunuhan latar belakang.
- Jika memakai MIUI (Xiaomi/Redmi), izinkan **Display UI in background** untuk kedua app.
- Biarkan LifeUp dan LifeUp Cloud tetap berjalan.

#### Di desktop

1. Pasang app desktop dari paket rilis.
2. Di pengaturan desktop, masukkan IP layanan yang ditampilkan di LifeUp Cloud.
   - Di desktop v1.1.0+, Anda dapat mencoba **Auto Connect**.
3. Jika semuanya dikonfigurasi dengan benar, Anda seharusnya dapat melihat data LifeUp di desktop.
   - Jika gagal, tinjau kembali penyiapan tambahan di atas.

### Penggunaan berikutnya

1. Buka LifeUp dan LifeUp Cloud di ponsel.
2. Ketuk **Start Service** di LifeUp Cloud.
3. Jalankan klien desktop.

<br/>

## FAQ

<details>
<summary>Apakah saya bisa menambah Tugas dari desktop?</summary>

Ya. Build desktop saat ini mendukung pembuatan Tugas dasar.

Namun, belum semua opsi Tugas in-app lanjutan tersedia di desktop. Untuk konfigurasi kompleks, gunakan app seluler atau panggil API lewat LifeUp Cloud.

</details>

<details>
<summary>Saya mengetuk «Request LifeUp Permission» di LifeUp Cloud, tapi tidak terjadi apa-apa / API not found.</summary>

1. Jika tidak terjadi apa-apa, Anda mungkin sudah memberikan izin.
2. Jika muncul API not found, gabung beta anggota dan perbarui LifeUp ke versi beta terbaru.

</details>

<details>
<summary>Setelah ponsel terkunci beberapa saat, desktop tidak lagi bisa membaca data.</summary>

Lakukan penyiapan kompatibilitas untuk LifeUp dan LifeUp Cloud.

</details>

<details>
<summary>Saat LifeUp dan LifeUp Cloud di latar belakang, beberapa API gagal dieksekusi.</summary>

> Ini biasanya tidak memengaruhi penggunaan desktop dasar, tapi dapat memengaruhi panggilan API kustom.

Pastikan LifeUp Cloud memiliki izin jendela mengambang/draw-over-apps.

Jika Anda memakai MIUI (Xiaomi/Redmi), aktifkan juga izin **Display UI in background** untuk kedua app.

</details>

<details>
<summary>Instalasi Windows gagal dengan `Failed to launch JVM`.</summary>

Referensi: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Ini biasanya terkait konfigurasi aksesibilitas JVM lokal.

Solusi umum adalah mengomentari baris berikut di `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Setelah mengedit, mulai ulang app dan uji lagi.

> `~` berarti direktori home pengguna Anda.

</details>

<br/>

## Kontribusi

SDK, LifeUp Cloud, dan LifeUp Desktop semuanya open source.

Kode sumber:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

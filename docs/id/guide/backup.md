# Backup dan Pemulihan

> [!IMPORTANT]
> LifeUp adalah aplikasi offline-first. Sebagian besar data pribadi Anda tetap di perangkat. Jika backup belum dikonfigurasi, mencopot App, ganti ponsel, atau kerusakan perangkat dapat menyebabkan kehilangan data permanen.

## Navigasi Cepat

- [Mengapa Backup Penting](#why-backup)
- [Cara Mengonfigurasi Metode Backup](#configure-methods)
- [Cara Backup](#how-to-backup)
- [Cara Pemulihan](#how-to-restore)
- [Migrasi ke Ponsel Baru](#phone-migration)
- [Masalah Umum](#common-issues)

## 1) Mengapa Backup Penting :id=why-backup

### Risiko apa yang Anda lindungi?

Kebanyakan pengguna kehilangan data dalam salah satu situasi berikut:

1. Pencopotan App (file di jalur backup default dapat dihapus oleh pembersihan sistem)
2. Migrasi ponsel tanpa memindahkan file backup
3. Kerusakan/kehilangan perangkat

Backup yang andal berarti data Anda ada di perangkat atau media penyimpanan lain, bukan hanya di ponsel yang sama.

### Apa saja yang termasuk dalam backup?

Backup mencakup data inti lokal Anda, seperti Tugas, Atribut, data Toko, Pencapaian, Perasaan, catatan Pomodoro, dan pengaturan. File media (lampiran, ikon, latar belakang, audio) juga dapat disertakan.

> [!TIP]
> Jika ukuran backup lebih dari 10 MB, aktifkan "Abaikan file media/gambar" atau perpanjang interval backup agar lebih stabil.

## 2) Cara Mengonfigurasi Metode Backup :id=configure-methods

Untuk sebagian besar pengguna, prioritas berikut paling cocok:

| Metode | Direkomendasikan | Terbaik untuk | Backup otomatis | Catatan |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Penggunaan harian, sinkronisasi cloud mudah | Ya | Otorisasi satu ketuk di App |
| Dropbox | ⭐⭐⭐⭐ | Penggunaan harian, sinkronisasi antar-perangkat | Ya | Juga mendukung otorisasi di App |
| Ekspor lokal (Custom Path) | ⭐⭐⭐⭐ | Salin manual ke PC / NAS | Tidak (manual) | Cadangan andal dan arsip berversi |
| WebDAV | ⭐⭐⭐ | Self-hosting / layanan WebDAV yang sudah ada | Ya | Alternatif bagus jika Anda sudah memakai WebDAV |
| Backup otomatis ke folder Download (Android 10+) | ⭐⭐⭐ | Mengurangi risiko pencopotan | Ya | Tidak melindungi dari kerusakan perangkat |

<details>
<summary>Siapkan backup otomatis Google Drive / Dropbox (direkomendasikan)</summary>

Di App, buka:
`Sidebar → Settings → Data Backup/Restore/Clear`

Lalu:

1. Otorisasi Google Drive atau Dropbox
2. Di "Cloud Backup Config", pilih metode Anda
3. Aktifkan "Enable auto cloud backup"
4. Atur "Auto backup interval"
5. Opsional: aktifkan "Ignore media/picture files"

</details>

<details>
<summary>Siapkan backup cloud WebDAV (opsional)</summary>

Jika Anda memakai layanan yang kompatibel WebDAV:

1. Buka `WebDAV Configuration`
2. Isi URL, akun, dan kata sandi
3. Jalankan tes koneksi
4. Gunakan WebDAV sebagai metode backup cloud Anda

</details>

<details>
<summary>Ekspor ke custom path (cadangan manual)</summary>

Gunakan ini jika Anda ingin backup manual yang portabel:

1. Ketuk `Backup`
2. Pilih `Custom Path`
3. Simpan file yang dihasilkan (biasanya `.lfbak`)
4. Salin ke PC / NAS / penyimpanan cloud

> [!WARNING]
> Jangan menyimpan satu-satunya backup di ponsel yang sama.

</details>

## 3) Cara Backup :id=how-to-backup

<details>
<summary>Jalankan alur backup otomatis harian</summary>

1. Selesaikan satu pengaturan cloud (Google Drive atau Dropbox)
2. Aktifkan backup cloud otomatis dan intervalnya
3. Picu satu backup manual untuk memverifikasi semuanya berjalan
4. Periksa petunjuk "last backup" secara berkala

</details>

<details>
<summary>Jalankan backup manual sebelum perubahan penting</summary>

Buat ekspor lokal tambahan sebelum:

- pembaruan App besar
- reset/reflash sistem
- migrasi ponsel

Gunakan: `Backup → Custom Path`, lalu salin file ke penyimpanan eksternal.

</details>

## 4) Cara Pemulihan :id=how-to-restore

<details>
<summary>Pulihkan dari backup cloud (Google Drive / Dropbox / WebDAV)</summary>

1. Konfigurasi akun/metode cloud yang sama di perangkat target
2. Ketuk `Restore` dan pilih metode tersebut
3. Konfirmasi pemulihan (App akan restart)

> [!WARNING]
> Pemulihan menimpa data lokal saat ini. Jika data saat ini penting, ekspor backup lokal terlebih dahulu.

</details>

<details>
<summary>Pulihkan dari file backup lokal</summary>

1. Pindahkan file backup ke perangkat target
2. Ketuk `Restore → Custom Path`
3. Pilih file backup dan konfirmasi

Anda juga dapat mengaktifkan "Support file system to open backup files" untuk mengimpor langsung dari file manager atau app berbagi.

> [!TIP]
> Jika pemulihan gagal dengan error baca/tulis, coba jalur file lain dan pilih ulang file.

</details>

### Migrasi ke Ponsel Baru :id=phone-migration

<details>
<summary>Migrasi ke ponsel baru (sistem atau jalur backup)</summary>

#### Opsi A: Gunakan migrasi ponsel bawaan terlebih dahulu

Beberapa ponsel mendukung migrasi data App penuh (alat migrasi merek / klon sistem).

1. Jalankan migrasi sistem dari ponsel lama ke ponsel baru.
2. Buka LifeUp dan verifikasi data utama (Tugas, Atribut, data Toko, Pencapaian).
3. Meski migrasi terlihat baik, buat satu backup baru di ponsel baru.

#### Opsi B: Migrasi via backup cloud atau file backup (universal)

1. Di ponsel lama, buat backup baru terlebih dahulu.
2. Di ponsel baru, pasang LifeUp.
3. Untuk migrasi cloud: konfigurasi metode/akun cloud yang sama, lalu pulihkan.
4. Untuk migrasi file: transfer file backup, lalu gunakan `Restore → Custom Path`.
5. Setelah pemulihan, picu satu backup manual untuk memverifikasi rantai backup di ponsel baru.

> [!WARNING]
> Pemulihan menimpa data lokal. Jika ponsel baru sudah punya entri penting, ekspor terlebih dahulu.

</details>

## 5) Masalah Umum :id=common-issues

<details>
<summary>Perbaiki error pemulihan: file backup tidak valid</summary>

- Pastikan file dihasilkan oleh LifeUp.
- `.lfbak` adalah format yang direkomendasikan.

</details>

<details>
<summary>Perbaiki error pemulihan: file backup versi lebih tinggi</summary>

Perbarui LifeUp ke versi terbaru, lalu pulihkan lagi.

</details>

<details>
<summary>Perbaiki backup cloud lambat atau tidak stabil</summary>

- Aktifkan "Ignore media/picture files".
- Perpanjang interval backup otomatis.
- Bersihkan file media yang tidak terpakai sebelum backup.

</details>

<details>
<summary>Tentukan apakah backup otomatis ke folder Download sudah cukup</summary>

- Membantu melawan kehilangan terkait pencopotan.
- Tidak melindungi dari kerusakan/kehilangan perangkat.
- Strategi lebih aman: gabungkan backup cloud + ekspor lokal berkala.

</details>

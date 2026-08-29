# FAQ

LifeUp dikelola oleh dua rekan indie di waktu luang kami:

- Satu developer terutama mengurus App.
- Satu rekan fokus pada layanan backend dan operasional.

## Di Balik App Indie

Saat pertama kali meluncurkan LifeUp pada 2020, app indie masih relatif jarang. Pada 2026, developer indie dan app indie ada di mana-mana — dan itu bagus.

Namun kami juga melihat banyak tren yang kurang baik: merilis app baru setiap satu atau dua bulan lalu mengabaikannya setelah peluncuran; app yang dibangun sepenuhnya dari kode hasil AI tanpa rekayasa nyata di baliknya, penuh bug, performa buruk, dan sulit dirawat; harga agresif yang didorong hype, melonjak dari puluhan ke ratusan dolar sebelum app selesai, dengan posting forum mendesak pengguna membeli keanggotaan seumur hidup «sebelum terlambat»; atau app yang meraup keanggotaan seumur hidup v1, hampir tidak merawatnya, lalu tiba-tiba «hidup kembali» dengan v2.0 untuk menjual keanggotaan seumur hidup lagi — hanya agar app tetap tidak dirawat, rusak, atau dihapus dari toko, sehingga keanggotaan seumur hidup itu praktis tidak bernilai.

Sebaliknya, LifeUp dibangun oleh developer yang peduli pada pemeliharaan jangka panjang: ~6 tahun iterasi berkelanjutan dengan 400+ rilis. Kami tetap pada model beli sekali, dan harga kami jauh di bawah sebagian besar app sejenis bahkan setelah penyesuaian kecil selama bertahun-tahun. LifeUp juga secara unik menawarkan [API](/guide/api.md) dan [klien desktop open-source](/guide/api_desktop.md), sehingga Anda dapat mengintegrasikan LifeUp ke alur kerja Anda sendiri dengan AI dan keterampilan pengembangan Anda — atau bahkan membangun di atasnya. LifeUp juga mendukung backup ekspor data lengkap, termasuk file media asli dan database SQLite — sehingga Anda selalu memiliki dan mengendalikan data Anda. Anda dapat mengonversinya ke format yang kompatibel dengan app lain, meminta AI menganalisisnya untuk membuat grafik, dan lain-lain (semua itu juga bisa — dan lebih langsung — lewat API). Anda bahkan dapat mengimpor backup langsung ke [ulives](https://app.ulives.io/), app iOS baru kami.

Beberapa fitur dan detail UI masih disempurnakan, dan kami memperbaikinya langkah demi langkah.

Jika LifeUp membantu Anda, membagikannya kepada orang lain juga sangat membantu kami.

Jika ingin mendukung pengembangan, Anda juga dapat traktir kami kopi di halaman **About** di App.

## ⚙️ Konfigurasi Kompatibilitas

Jika Anda mengalami masalah seperti:

- pengingat tidak muncul
- pengingat Pomodoro atau hitung mundur Item tidak berfungsi di latar belakang
- aksi widget gagal (misalnya, tidak bisa mencentang Tugas hitung)
- masalah refresh widget

silakan baca panduan kompatibilitas:

> [!WARNING]
> [Konfigurasi kompatibilitas](/guide/compatibility.md)

## 🌍 Umum

<details>
<summary>Kebijakan refund</summary>

LifeUp saat ini terdaftar sebagai app berbayar di Google Play karena alasan historis, sehingga sulit beralih ke model bayar setelah unduh.

Google Play dapat otomatis mengembalikan dana pesanan Anda jika Anda mencopot pemasangan tak lama setelah pembelian.

Jika refund otomatis itu tidak terjadi, hubungi kami dalam **7 hari** di [lifeup@ulives.io](mailto:lifeup@ulives.io).
Sertakan nomor pesanan GPA Anda dan kirim email dari akun Google yang sama dengan pembelian.

Untuk alasan anti-penyalahgunaan, kami hanya dapat memberikan dukungan refund manual **sekali per pengguna**.
Kami tidak dapat memproses permintaan refund setelah 7 hari sejak tanggal pembelian.

Catatan: ulasan Google Play tidak menyertakan detail pesanan yang cukup untuk penanganan refund.

</details>

<details>
<summary>Apakah data saya pribadi dan aman?</summary>

Ya. Kami serius soal privasi.

Sebagian besar data tetap di perangkat Anda dan tidak melewati server kami.

Pengecualian utama adalah modul Dunia, di mana pengguna dapat membagikan desain dan template secara publik.
Semua berbagi di sana bersifat opt-in: tidak ada yang dipublikasikan kecuali Anda memilih untuk membagikannya, dan Anda dapat menghapus konten yang dibagikan kapan saja.

Baca selengkapnya di [Kebijakan Privasi](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms) kami.

</details>

<details>
<summary>Bagaimana cara backup data jika server tidak menyimpannya?</summary>

LifeUp mendukung backup ekspor/impor dan target backup bergaya cloud.

Anda dapat menggunakan:
- File backup ekspor
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Mengapa tidak ada bahasa XX? Atau mengapa terjemahannya tidak lengkap dan ditampilkan dalam bahasa Inggris?</summary>

Sebagian besar bahasa di *LifeUp* dirawat oleh komunitas.

Mulai 2026, kami akan menggunakan terjemahan AI untuk bahasa utama guna meningkatkan kualitas dasar dan mempercepat pembaruan.

Proofread dan koreksi dari komunitas tetap sangat kami sambut.

Anda dapat berkontribusi di sini: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Bisakah saya menyembunyikan modul Dunia jika tidak membutuhkannya?</summary>

Ya.

Anda dapat menyesuaikan bilah navigasi bawah di:
`bilah sisi` → `Pengaturan` → `Tampilan` → `Konfigurasi Modul`.

Dari sana, Anda dapat menyembunyikan modul Dunia atau menggantinya dengan modul lain.

</details>

<details>
<summary>Langkah kaki tidak akurat, atau saya tidak membutuhkan modul ini?</summary>

> Anda dapat mengetuk ikon tanda tanya kecil di samping langkah kaki di App untuk melihat cara kerjanya.

- Untuk akurasi lebih baik, buka App di pagi dan sore hari, dan hindari restart perangkat yang sering.
- Anda juga dapat memasukkan jumlah langkah secara manual.
- Jika tidak membutuhkannya, sembunyikan langkah kaki di `Pengaturan` → `Tampilan`.

</details>

## ✅ Tugas

<details>
<summary>Bisakah saya menyembunyikan dialog Hadiah saat menyelesaikan Tugas?</summary>

Ya. Dalam alur penyelesaian normal, dialog Hadiah hanya muncul jika Tugas memiliki Hadiah yang dikonfigurasi, seperti Poin Pengalaman (XP) atau Item. Jika Hadiah tidak diatur, menyelesaikan Tugas tidak akan menampilkan dialog ini.

Kami juga menyarankan memilih interval penyelesaian yang masuk akal alih-alih memecah satu aktivitas menjadi banyak Tugas kecil. Ini mengurangi pekerjaan pengaturan dan jumlah aksi penyelesaian.

Jika ingin mempertahankan Hadiah tetapi melewati dialog penyelesaian, Anda dapat menggunakan salah satu opsi berikut:

- **Quick Complete:** Aktifkan `Selesaikan Cepat` di sudut kanan atas daftar Tugas. Setelah aktif, mengetuk lingkaran menyelesaikan Tugas langsung tanpa menampilkan dialog Hadiah.
- **Geser untuk menyelesaikan:** Buka `bilah sisi` → `Pengaturan` → `Tugas` → `Swipe` → `Tindakan menggesek kartu`. Pilih `Geser ke Kiri` atau `Geser ke Kanan`, lalu atur aksi ke `Selesai (Tanpa Dialog)`.

Kedua opsi tanpa dialog tetap memberikan Hadiah yang dikonfigurasi, tetapi juga melewati dialog penyelesaian lain, termasuk input Perasaan dan penggunaan Item otomatis.

</details>

<details>
<summary>Bagaimana cara membatalkan Tugas yang sudah diselesaikan?</summary>

Anda dapat membatalkan penyelesaian di beberapa tempat:

1. Segera setelah menyelesaikan, ketuk **Undo** di prompt bawah.
2. Di `bilah sisi` → `Sejarah`, ketuk `Batalkan`.
3. Di `Kalender` → `Berakhir`, ketuk `Batalkan`.

Jika tenggat Tugas sudah lewat, pembatalan langsung tidak tersedia.
Dalam hal itu, edit status catatan (misalnya, atur ke terlambat atau ditinggalkan).

</details>

<details>
<summary>Bagaimana cara menandai Tugas terlambat sebagai selesai?</summary>

Saat Tugas menjadi terlambat, dialog terlambat muncul dan memungkinkan Anda menandainya selesai.

Setelah menutup dialog, Anda masih dapat memperbarui status Tugas nanti dari:
- `bilah sisi` → `Sejarah`
- `Kalender` → `Berakhir`

</details>

<details>
<summary>Apakah ada penalti EXP/koin jika Tugas gagal?</summary>

Ya.

- Penalti EXP aktif secara default (faktor: `0.2x`).
- Penalti koin nonaktif secara default (faktor: `0`).

Anda dapat mengubah pengaturan global di:
`bilah sisi` → `Pengaturan` → `Lanjutan`

Anda juga dapat mengatur penalti per Tugas di editor Tugas.

</details>

<details>
<summary>Bagaimana mekanisme pengulangan bekerja?</summary>

Atur hanya `Waktu Mulai`, `deadline`, frekuensi ulang, dan waktu pengingat opsional untuk **siklus pertama**.

LifeUp kemudian akan menghitung siklus berikutnya secara otomatis.

</details>

<details>
<summary>Bagaimana mengatur Tugas yang perlu diselesaikan N kali secara tidak teratur dalam satu periode?</summary>

LifeUp belum memiliki pengaturan langsung untuk «minimal/maksimal N kali per siklus». Namun, Anda dapat mencapainya dengan beberapa cara:

| Metode | Pengaturan | Kelebihan | Kekurangan |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Atur frekuensi ke `Mingguan`, aktifkan `Hitung Tugas`, atur jumlah (mis. 3). | Pengaturan sederhana; progres jelas (mis. 1/3). | **Hadiah hanya diberikan setelah hitungan terakhir selesai.** Tidak ada Hadiah untuk setiap penyelesaian. |
| **Infinite Task + Target** | Atur frekuensi ke `Tidak terbatas`, target count ke 3, deadline ke Minggu. | **Hadiah diberikan untuk setiap penyelesaian.** | **Harus dibuat ulang manual setiap minggu** (karena Tugas berakhir setelah selesai). |
| **Subtasks** | Atur frekuensi ke `Mingguan`, tambahkan 3 subtask di dalamnya. | Dapat mengatur Hadiah dan pengingat individual untuk setiap penyelesaian. | Perlu masuk halaman detail untuk mencentang subtask; harus dibuat satu per satu (cocok hanya untuk jumlah kecil). |
| **Infinite Task (Stats Only)** | Atur frekuensi ke `Tidak terbatas`. | Pengaturan paling mudah; Hadiah dan statistik untuk setiap penyelesaian. | **Tidak ada paksaan batas.** Anda harus memeriksa statistik manual untuk melihat apakah target mingguan tercapai. |

> [!NOTE]
> Kami mempertimbangkan menambahkan fitur «Real-time Reward» untuk **Counting Tasks** (memberi Hadiah setiap hitungan segera), yang saat ini sedang dievaluasi.

</details>

<details>
<summary>Bagaimana menyembunyikan Tugas yang sudah selesai atau belum dimulai?</summary>

Ini biasanya terjadi dalam salah satu kasus berikut:

1. Jika Tugas menampilkan `xx deadline`, Tugas itu sudah dimulai.
   - Edit Tugas dan sesuaikan `Waktu Mulai` jika perlu.

2. Jika Tugas menampilkan `xx starts` dan tanggalnya bukan hari ini:
   - Periksa apakah tombol lipat bawah dalam keadaan collapsed.
   - Buka menu kanan atas (`...`) → `Filter`.
   - Pastikan `Tampilkan Hari Ini` aktif.

> Catatan:
> - Smart list (minggu/bulan) tidak mendukung pelipatan.
> - Untuk Tugas berulang, satu siklus penuh valid secara default. Misalnya, siklus 21 hari dapat diselesaikan kapan saja dalam 21 hari itu. Jika ingin hanya terlihat mendekati akhir, sesuaikan start time sekali dan biarkan LifeUp menghitung siklus berikutnya secara otomatis.

</details>

<details>
<summary>Bagaimana agar Tugas tidak menjadi terlambat di tengah malam?</summary>

Waktu terlambat dikontrol oleh waktu deadline Tugas.

Setelah mengatur tanggal deadline, ketuk tombol `time` dan pilih waktu yang lebih lambat.

Misalnya, jika tidak ingin Item kedaluwarsa pada `00:00`, atur waktu deadline ke sekitar `02:00` (hari berikutnya).

Anda juga dapat mengubah default global di:
`Pengaturan` → `Item` → `Setelan default tugas baru`

(Mengubah default tidak memengaruhi Item yang sudah ada.)

</details>

<details>
<summary>Mengapa jumlah target kali dimulai dari 1/N?</summary>

Berbeda dari counting task, (1/N) **di sini tidak mewakili progres total.**

Sebaliknya, **ini menunjukkan hitungan pengulangan saat ini. Apakah pengulangan ini selesai ditunjukkan oleh ⚪ atau ✅.**

<br/>

Misalnya, ⚪1/10 berarti:
Tugas ini akan diulang 10 kali total (total 10 kartu akan dibuat), dan saat ini berada di kali ke-1 dan belum selesai.

Dan ✅1/10 berarti:
Kartu saat ini termasuk kali ke-1 dan sudah selesai.

Jika progres total digunakan, kartu yang selesai akan menampilkan status membingungkan seperti (⚪1/10 dan ✅1/10 bersamaan). Selain itu, kartu mungkin hilang saat target tercapai (mis. ✅9/10), yang counterintuitive.

</details>

<details>
<summary>Bagaimana mengatur beberapa pengingat untuk satu Tugas?</summary>

Buat subtask dan tetapkan deskripsi/waktu pengingat berbeda untuk masing-masing.

Ini cara yang disarankan untuk mensimulasikan beberapa pengingat untuk satu Tugas utama.

</details>

<details>
<summary>Bisakah subtask ditampilkan langsung di daftar Tugas?</summary>

Belum saat ini. Kami mungkin mempertimbangkannya di pembaruan mendatang.

</details>

## 🎁 Hadiah (Poin Pengalaman, Barang)

<details>
<summary>Bisakah saya menetapkan nilai EXP berbeda ke Atribut berbeda untuk satu Tugas?</summary>

Tidak langsung di versi saat ini.

Untuk pengaturan cepat, satu Tugas saat ini menggunakan satu nilai EXP per Atribut. Jika Anda membutuhkan nilai EXP berbeda per Atribut, gunakan workaround ini:

1. Buat Item.
2. Konfigurasi efek EXP berbeda untuk Atribut berbeda pada Item itu.
3. Atur Item agar otomatis digunakan setelah penyelesaian Tugas.

Ini memberi Anda penyelesaian Tugas + efek Item sebagai pipeline Hadiah gabungan.

Kami berencana meningkatkan dukungan native untuk ini di versi mendatang.

</details>

<details>
<summary>Bagaimana EXP dan koin dihitung otomatis?</summary>

EXP terutama bergantung pada:
- `Kesulitan`
- `Pentingnya`
- `number of selected attributes`

Koin terutama bergantung pada:
- `Kesulitan`
- `Pentingnya`

</details>

<details>
<summary>Bagaimana Life Level dihitung?</summary>

EXP Life Level berkorelasi positif dengan EXP yang diperoleh dari Atribut mana pun.

Saat penalti diterapkan, EXP Life Level juga berkurang proporsional.

Life Level dirancang sebagai indikator agregat yang luas, jadi kami tidak menyarankan terlalu fokus pada rumusnya.

Yang paling penting adalah bahwa ini mencerminkan progres jangka panjang Anda secara keseluruhan.

Referensi rumus: setiap aksi perolehan/kehilangan EXP memberi kontribusi 1/5 ke EXP Life Level, terlepas dari berapa banyak Atribut yang diberi Hadiah dalam aksi itu.

</details>

<details>
<summary>Bisakah saya mengatur Hadiah EXP dan koin kustom untuk Tugas?</summary>

Ya.

Saat membuat Tugas atau Pencapaian, ketuk tombol Hadiah yang sesuai dan konfigurasi nilai secara manual.

</details>

<details>
<summary>Mengapa gambar Item hilang atau tidak tampil?</summary>

LifeUp bersifat offline-first, jadi gambar Item disimpan lokal di perangkat Anda.

Jika gambar hilang, periksa apa yang baru-baru ini terjadi:

**Setelah mengimpor backup:**
- Backup mungkin tidak menyertakan file gambar.
- Impor ulang backup lengkap yang menyertakan gambar.

**Setelah operasi pembersihan/manajemen file:**
- LifeUp tidak secara aktif menghapus file gambar.
- Alat pembersih/file pihak ketiga dengan izin luas mungkin menghapusnya secara tidak sengaja.
- Gunakan alat semacam itu dengan hati-hati.

**Untuk Item yang diimpor dari Dunia:**
- Mungkin masalah pemuatan jaringan sementara.
- Coba lagi nanti, atau ganti dengan gambar lokal.

Jika Anda masih memiliki backup lama dengan gambar, Anda dapat memulihkan backup itu terlebih dahulu untuk mendapatkan media kembali, lalu memulihkan backup data terbaru.

</details>

<details>
<summary>Bagaimana cara menghapus Item di Toko?</summary>

Di halaman `Belanja`, tekan lama Item, lalu ketuk tombol `Hapus` di atas.

</details>

<details>
<summary>Bagaimana cara menghapus EXP dan koin?</summary>

Buka:
`bilah sisi` → `Pengaturan` → `Pencadangan/Pemulihan/Hapus Data`

Anda dapat menghapus nilai EXP dan koin di sana.

Catatan: jika Anda menggunakan fitur online, tampilan terkait di sisi server mungkin butuh waktu singkat untuk refresh.

</details>

<details>
<summary>Apa batas Level dan gradien pengalaman untuk Atribut?</summary>

Dapat dianggap memiliki Level tanpa batas (saat ini 2000+, sulit dicapai dengan cara normal).

Pengalaman yang dibutuhkan untuk setiap Level meningkat, meski gradien saat ini curam. (Jadi, Hadiah tidak sebaiknya dinilai hanya dari batas Level; batas pengalaman kira-kira 2^63).

Faktanya, banyak pengguna akan lama berada di gradien 2500 EXP. Kami mungkin mengoptimalkan sistem Level atau mengizinkan kustomisasi di masa depan. (Total Poin Pengalaman tidak akan terpengaruh).

| Level    | Poin Pengalaman yang Dibutuhkan untuk Setiap Level |
| -------- | -------------------------------------------------- |
| 1 → 2     | 300                                                |
| 2 → 3     | 700                                                |
| 3 → 4     | 1500                                               |
| 4 → 99    | 2500                                               |
| 99 → 150  | 5000                                               |
| 150 → 200 | 7500                                               |
| 200 → 250 | 15000                                              |
| 250 → 300 | 30000                                              |
| 300 → 325 | 50000                                              |
| 325 → 350 | 100000                                             |
| >350     | 500000                                             |

</details>

<details>
<summary>Bagaimana mengonfigurasi pinjaman, bunga ATM, dan bunga pinjaman?</summary>

Di halaman `Belanja`, buka menu kanan atas (`...`) dan pilih `Pengaturan`.

</details>

<details>
<summary>Bagaimana menyesuaikan Atribut atau Keterampilan?</summary>

Buka:
`bilah sisi` → `Pengaturan` → `Maju` → `Sesuaikan atribut`

Anda dapat menyesuaikan Atribut yang ada, membuat Atribut baru untuk Keterampilan, dan menghapus Atribut sesuai kebutuhan.

Jika ingin melacak Keterampilan, buat Atribut dengan nama Keterampilan (misalnya, `Fishing` atau `Programming`).

</details>

<details>
<summary>Bisakah saya mengubah Atribut yang digunakan Hadiah olahraga atau Hadiah like-count Dunia?</summary>

Tidak di versi saat ini.

Pemetaan Hadiah bawaan ini masih tetap untuk saat ini.

</details>

<details>
<summary>Bagaimana mengatur Hadiah Kotak Jarahan?</summary>

Saat membuat Item di Toko, tambahkan efek `Kotak Jarahan` ke Item itu.

Lalu konfigurasi pool Hadiah, probabilitas, dan pengaturan terkait di efek tersebut.

</details>

<details>
<summary>Bisakah saya mengatur probabilitas Kotak Jarahan di bawah 1%?</summary>

Ya.

Setelah mengonfigurasi efek Kotak Jarahan, ketuk tombol bantuan `?` di App untuk detail probabilitas dan panduan pengaturan.

</details>

<details>
<summary>Bagaimana mendapatkan lebih banyak ikon?</summary>

Kami tim indie kecil dan saat ini tidak dapat merawat set ikon bawaan yang besar.

Anda dapat mendapatkan lebih banyak ikon dengan cara berikut:

1. Impor Item dari `Dunia` → `Pasar` dan gunakan ulang ikonnya.
2. Gunakan sumber ikon eksternal (pastikan hak penggunaan valid):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Jika memungkinkan, utamakan ikon dengan latar transparan untuk tampilan lebih baik di App.

</details>

<details>
<summary>Apa yang harus dilakukan jika gambar produk tidak dapat ditampilkan atau hilang?</summary>

LifeUp adalah app offline. Gambar produk disimpan ke perangkat Anda dan disimpan aman di direktori privat App. Kami tidak dapat langsung menyelidiki perubahan file di perangkat Anda.

Jika gambar produk hilang atau tidak dapat ditampilkan, pikirkan operasi apa yang baru-baru ini Anda lakukan:

**Jika gambar hilang setelah memulihkan backup:**
- Biasanya karena file backup tidak berisi file gambar
- Anda perlu mengimpor ulang backup lengkap yang menyertakan file gambar

**Jika gambar terhapus tidak sengaja:**
- LifeUp sendiri tidak secara proaktif menghapus file gambar
- Jika baru-baru ini menggunakan fitur manajemen gambar, Anda mungkin menghapus gambar tidak sengaja dan dapat mencoba memulihkannya dari backup
- Selain itu, beberapa app pembersih sistem dengan izin tinggi juga dapat menghapus file gambar; gunakan app semacam itu dengan hati-hati
- Jika Anda memiliki backup lama yang berisi gambar, backup data saat ini terlebih dahulu, lalu pulihkan backup lama untuk mengambil gambar, lalu pulihkan data saat ini

**Jika gambar produk yang diimpor dari modul Dunia tidak dapat ditampilkan:**
- Mungkin disebabkan masalah jaringan
- Coba lagi nanti, atau ganti gambar produk dengan gambar lokal

**Dalam kasus langka, cacat sistem dapat menyebabkan kehilangan gambar:**
- Sejauh pengetahuan kami, versi sistem kustom dari beberapa produsen pernah memiliki cacat: saat App crash berulang, data App dapat terhapus secara tidak benar, sehingga data dan file gambar hilang. Jaga sistem tetap terbaru. Selain itu, kami tidak menutup kemungkinan masih ada cacat sistem yang dapat menyebabkan masalah abnormal, karena ini di luar kendali App. Kami menyarankan backup secara rutin
- Dalam kasus ekstrem, penyimpanan perangkat tidak stabil atau masalah perangkat keras juga dapat menyebabkan kehilangan file gambar. Pertimbangkan backup ke cloud secara rutin atau ganti perangkat

</details>

## ⏰ Pengingat / Pomodoro / Hitung Mundur

<details>
<summary>Bagaimana menggunakan efek hitung mundur Item di Toko?</summary>

Efek hitung mundur dikirim sebagai notifikasi App.

Pertama, pastikan izin notifikasi untuk LifeUp aktif.

</details>

<details>
<summary>Apakah Pomodoro mendukung auto-next?</summary>

Belum saat ini.

Anda dapat mencoba mode timer count-up.

Dalam mode Pomodoro, saat satu sesi kerja berakhir, timer terus menghitung naik. Anda lalu dapat memutuskan apakah menambah waktu ekstra ke catatan Fokus. Auto-next akan bentrok dengan alur kerja ini.

</details>

<details>
<summary>Bagaimana memulai Pomodoro dengan cepat dari daftar Tugas?</summary>

Anda dapat:
1. Tekan lama Tugas dan ketuk `Pengatur waktu` di menu aksi.
2. Atau konfigurasi aksi geser ke `Pengatur waktu` di pengaturan `Tugas`.

</details>

<details>
<summary>Apakah Pomodoro menyediakan statistik ringkasan seperti app Pomodoro khusus?</summary>

Belum.

Pomodoro LifeUp masih modul ringan dalam tahap pengembangan awal.

Saat ini tersedia:
- Catatan detail per sesi
- Statistik ringkasan harian dasar di halaman `Status`

</details>

## 💾 Backup dan Restore

<details>
<summary>Bagaimana cara backup data?</summary>

Silakan baca [Panduan Backup dan Restore](/guide/backup.md) terlebih dahulu.

Singkatnya, metode backup yang didukung meliputi:
- Google Drive (disarankan)
- Dropbox
- Ekspor file backup
- Server WebDAV

</details>

<details>
<summary>Mengapa LifeUp dirancang sebagai app offline-first?</summary>

LifeUp mengikuti arsitektur offline-first by design.

Ini berarti:
- Data Anda dimiliki dan dikendalikan oleh Anda.
- Data tetap lokal kecuali Anda secara eksplisit memilih opsi backup/sinkronisasi.
- Sebagian besar fitur inti tetap berfungsi tanpa akses jaringan.

Karena klien menangani logika inti secara lokal, Anda tetap dapat menggunakan LifeUp saat jaringan atau ketersediaan server terbatas (kecuali fitur online seperti modul Dunia).

</details>

## 🧭 Perencanaan

<details>
<summary>Apakah Anda akan menambahkan fitur AI?</summary>

LifeUp adalah app beli sekali berbiaya rendah yang dirawat tim kecil. Membangun fitur AI siap pakai langsung (di mana kami menanggung biaya API) tidak realistis dengan model harga kami — kecuali kami beralih ke model langganan atau mengalikan harga sekali bayar beberapa kali lipat agar sejajar dengan biaya operasional app AI modern. Kami tidak akan melakukan itu.

Namun, LifeUp secara inheren ramah AI:

1. Kami membuka sebagian besar [API](/guide/api.md) dan fungsionalitas inti sejak awal, sehingga secara alami kompatibel dengan agen AI dan alat pihak ketiga. Alat AI dengan kemampuan agen sudah dapat memanggil fitur LifeUp secara langsung — membuat Tugas, Item, dan lain-lain. Faktanya, kami melihat banyak pengguna membagikan alur kerja yang menggabungkan AI dengan API kami, termasuk server MCP API LifeUp kustom, alat otomasi untuk entri jurnal harian hasil AI, dan lain-lain.

2. Kami berencana memperkenalkan kemampuan AI BYOK (Bring Your Own API Key) di masa depan. Dengan begitu Anda dapat menggunakan kunci sendiri untuk fitur AI tanpa kami menanggung biaya API berkelanjutan.

3. Pada akhirnya, AI bukan sihir — jika tidak, Anda juga bisa dengan mudah memasangkan AI dengan API kami untuk integrasi penuh sendiri.

</details>

<details>
<summary>Apakah akan ada versi iOS LifeUp?</summary>

Pada **2025**, kami meluncurkan [ulives](https://app.ulives.io/), app produktivitas cross-platform baru untuk pengguna iOS (juga di iPadOS dan Apple Silicon Mac).

Port langsung LifeUp ke iOS tidak realistis:

- LifeUp dibangun dengan teknologi Android native.
- Arsitektur offline-first-nya mengikat UI, model data lokal, dan logika bisnis erat ke implementasi Android.
- Port langsung tetap membutuhkan penulisan ulang besar untuk menjaga data dan logika konsisten.

Jadi kami reorganisasi dan membangun ulang dengan arah cross-platform lewat ulives.

ulives mempertahankan semangat inti LifeUp sambil juga menangani beberapa masalah desain dan produk lama dari generasi sebelumnya. Anda dapat menganggapnya sebagai evolusi segar, bukan sekadar klon satu-ke-satu.

**Keanggotaan LifeUp tidak membuka ulives**, tetapi Anda dapat mengimpor backup LifeUp (satu arah, berpotensi lossy). Lihat [Apa itu ulives?](/guide/faq?id=ulives_overview). Untuk alasan lebih detail, lihat dokumen perbandingan: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>Apa itu ulives? Apakah berbagi keanggotaan atau data LifeUp?</summary>


[ulives](https://app.ulives.io/) adalah **penulisan ulang greenfield** pada teknologi cross-platform (KMP). Mewarisi filosofi gamifikasi LifeUp, tetapi codebase, tim, harga, dan rencana jangka panjang terpisah — penerus spiritual, **bukan** port iOS LifeUp.

**Mengapa keanggotaan terpisah?**

- **Harga LifeUp mencerminkan cakupan Android saja:** LifeUp selalu dibangun dengan teknologi Android native murni. Harga keanggotaan seumur hidup yang sangat rendah ditetapkan sekitar **hanya memiliki klien Android** — tidak pernah dimaksudkan untuk membeli pemeliharaan setiap app masa depan yang mungkin kami bangun.
- **Harga ulives mencerminkan biaya cross-platform dan maintainability jangka panjang:** ulives adalah penulisan ulang penuh dengan codebase cross-platform, tim yang belum sepenuhnya terpadu, dan pekerjaan berkelanjutan untuk iOS plus target Android dan HarmonyOS mendatang. Premium ditetapkan oleh **pengembangan berkelanjutan dan maintainability jangka panjang**, bukan dengan menyalin pembagian gratis/berbayar historis LifeUp.
- **Tim pengembangan berbeda:** Port iOS LifeUp berjalan lambat karena berbagai alasan. Kami reorganisasi tim khusus untuk ulives (masih kecil saat ini) agar dapat mengirim produk cross-platform lebih cepat dan fleksibel.
- **Ekosistem toko terpisah:** App Store dan Google Play adalah sistem pembayaran dan hak terpisah. Lisensi tidak dapat ditransfer langsung antar kedua app.

**Singkatnya:**

- **Keanggotaan LifeUp ↔ keanggotaan ulives tidak saling transfer:** Pembelian LifeUp di Google Play **tidak** membuka ulives di App Store, dan sebaliknya. Setiap app memerlukan pembelian sendiri.
- **Impor data satu arah:** Sejak ulives 1.7.22, Anda dapat mengimpor backup LifeUp (`.lfbak`) ke ulives. Konversi mungkin lossy, dan impor **tidak** transfer kembali ke LifeUp.
- **Impor tidak transfer lisensi Anda:** Backup memindahkan data penggunaan (Tugas, Item, dll.), bukan hak keanggotaan LifeUp.

**ulives Premium di semua platform ulives:**

ulives juga akan mengirim **klien Android**-nya sendiri (dan dukungan native HarmonyOS, dll.). **Premium yang dibeli untuk ulives dimaksudkan berfungsi di semua platform ulives** — iOS, Android, HarmonyOS — setelah manajemen akun sisi server siap. Kasus cross-platform awal mungkin memerlukan menghubungi kami.

**Kedua app menawarkan keanggotaan seumur hidup jauh di bawah sebagian besar produk sejenis** — tetapi harga headline harus dibaca dalam konteks: cakupan single-platform vs cross-platform, biaya pengembangan, dan pemeliharaan jangka panjang berbeda.

Untuk alasan lebih detail (model harga, sustainability, investasi pengembangan, dan rencana masa depan kedua app), lihat dokumen perbandingan: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup). FAQ ulives: [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 Masih Butuh Bantuan?

<details>
<summary>Hubungi kami</summary>

Anda dapat menghubungi kami di [lifeup@ulives.io](mailto:lifeup@ulives.io).

Anda juga dapat membuka issue di GitHub:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Ingin mendukung kami?</summary>

Terima kasih telah mendukung LifeUp.

Jika LifeUp bermanfaat bagi Anda, Anda dapat mendukung kami dengan dua cara sederhana:

1. Traktir kami kopi dari halaman **About** di versi **Google Play** App.
2. Bantu lebih banyak orang menemukan LifeUp dengan membagikan pengalaman Anda:
   - Rekomendasikan LifeUp ke teman
   - Posting cerita penggunaan dan alur kerja Anda
   - Bagikan tips, panduan, atau tutorial

</details>

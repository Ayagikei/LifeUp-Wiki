# Rencana Pengembangan 2024-2025

> [!IMPORTANT]
> Ini adalah rencana pengembangan kami saat ini. Kami akan berusaha sebaik mungkin memandu peningkatan dan pembaruan produk sesuai rencana ini. Namun, karena lingkungan yang terus berubah, isi rencana pengembangan dapat dimodifikasi atau ditambah/dikurangi. Rilis produk aktual yang berlaku.

### I. Rencana Pengembangan

> Diperbarui: 2025/09/14

| Modul | Subfungsi | Alasan Kebutuhan | Prioritas | Hasil |
| ---- | ------ | -------- | ------ | ---- |
| Kemampuan Dasar (1) | Multi-pilih Item & auto-use Item saat diperoleh | ~ | P0 | ✅ Multi-pilih dirilis di v1.94<br/>✅ Auto-use Item dirilis di v1.96 |
| Kemampuan Dasar (2) | Popup Hadiah digeneralisasi (dukung jumlah Atribut dan Item berapa pun) | ~ | P0 | ✅ Dirilis di v1.96; pengaturan akan dilonggarkan di versi mendatang |
| Kemampuan Dasar (3) | Manajemen sumber suara & efek suara Item | ~ | P0 | ✅ Dirilis |
| Kemampuan Dasar (4) | Optimasi notifikasi | ~ | P0 | ✅ Dirilis |
| Adaptasi Layar Besar (tablet/lipat) | Adaptasi tablet dan lipat berbasis Activity embedding | ~ | P1 | ✅ Diperkirakan di v1.95 |
| Widget | Perluasan widget (widget Inventaris) | ~ | | ✅ Dirilis di v1.94 |
| Integrasi Kalender | - Sinkronisasi Dua Arah Google Calendar<br/>- Sinkronisasi Dua Arah Kalender Sistem | - Banyak umpan balik dari luar negeri.<br/>- LifeUp adalah alat to-do dengan fungsi yang tumpang tindih tetapi tidak konsisten dengan app jadwal (kalender). | P1 | 🚧 |
| API | - Perluas kemampuan API untuk mencakup semua fungsi dasar<br/>- Penyelesaian fitur klien desktop, dukung backup/restore, dll. | - Masih kurang banyak API seperti editing.<br/>- LifeUp tidak bisa all-in-one, tetapi API memungkinkan kustomisasi dan perluasan. | P1 | 🚧 Diperkirakan di v1.98.x |
| Pencapaian | - Pencapaian tipe ulang | ~ | P2 | ✅ Dirilis |
| Sistem Data | - Backup terpisah data dan gambar<br/>- Dukung ekspor/impor data sebagian<br/>- Dukung pergantian multi-file bawaan | - Upload WebDAV file besar mudah gagal.<br/>- Ekspor/impor sebagian dapat dipakai untuk berbagi sistem Hadiah.<br/>- Multi-file bawaan untuk pengujian mudah tanpa menghapus data. | P1 | 🚧 |
| Multi-platform (arah Flutter) | - Terus belajar dan memakai Flutter untuk versi lintas platform | - Pengembangan prototipe versi iOS | P2 | 🚧 Dijeda |
| Multi-platform (arah KMP) | - Eksplorasi lebih banyak kemungkinan memakai KMP | - Eksplorasi dan belajar teknologi KMP untuk masa depan | P0 | ✅ Dirilis ulives - app iOS baru |

Ringkasnya:

1. Kami akan menerapkan arah yang sudah ditetapkan: stabilitas dan mengoptimalkan fitur yang ada, tidak menambah modul fungsional baru secara sembarangan.
2. Kami akan memakai satu atau dua versi besar untuk menyelesaikan beberapa cacat fungsional dasar dan pain point.
3. Lalu lanjut dengan integrasi kalender dan Pencapaian tipe ulang.
4. Terus meningkatkan API dan aspek lainnya.

Multi-platform akan menjadi salah satu tujuan kunci kami di 2024.

---

### II. Tinjauan 2023

Perjalanan pengembangan LifeUp setengah amatir-setengah santai telah melewati ulang tahun kelima, melangkah ke tahun keenam. Kami merilis ratusan versi, dengan hampir 5000 commit kode hanya di repositori Android.

<br/>

Meski rencana pengembangan yang diajukan Oktober 2022 fokus pada pendalaman sistem fungsional LifeUp, karena perubahan lingkungan, kami tetap menghadapi banyak hambatan dan masalah di sepanjang jalan.

#### 1.1 Lingkungan

Contoh khas meliputi:

- Terpengaruh laporan palsu "anti-penipuan" di beberapa provinsi tanpa saluran banding, butuh beberapa putaran untuk menyelesaikan beberapa masalah. Tapi baru-baru ini ada lagi masalah laporan palsu di Shandong, dan kami belum menemukan jalur banding atau reproduksi.
- Standar review pasar Android domestik Tionghoa semakin berlapis, standar antar pasar dan personel tidak konsisten, dan reviewer tidak profesional.
  - Beberapa pasar app sering menolak review pada bagian yang tidak berubah.
  - Satu pasar app V hampir menolak app LifeUp kami dengan alasan "kepatuhan privasi". Pasar mewajibkan app kami mengajukan [read all file permissions] atau [read all photo permissions] dengan penjelasan terkait, agar pengguna bisa memilih gambar dari album. Namun, LifeUp memakai pendekatan lebih melindungi privasi, tidak butuh izin semacam itu, dan tidak langsung membaca file pengguna. Sebaliknya, app kami melompat ke app album bawaan sistem dan hanya menerima gambar yang dipilih pengguna, memastikan perlindungan privasi maksimal.
    Tapi reviewer tidak familiar dengan best practice ini, dan butuh beberapa hari kerja komunikasi customer service untuk disetujui.

<br/>

Untuk mengurangi dampak lingkungan pada kami:

Kami memperkuat mekanisme pembaruan in-app dan mengurangi frekuensi submit untuk review pasar.

Versi domestik sekarang mendukung pembaruan in-app dan dapat beralih antara saluran stable atau beta.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Kami juga memperbarui situs resmi (https://lifeupapp.fun/en/index.html) sebagai saluran unduh alternatif.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Agar lebih mudah bagi semua orang mengunduh dan memasang app via situs web, menghindari risiko dan penundaan review pasar.

Permintaan jaringan in-app juga menambahkan saluran cadangan untuk meringankan dan mencegah masalah akses akibat laporan palsu di beberapa provinsi.

<br/>

Seiring standar review semakin ketat, dan menyaksikan berbagai hambatan yang dialami developer indie lain di pasar Android domestik,

bisa dikatakan bagi developer indie, platform Android domestik bukan lagi target peluncuran pertama yang ideal.

Lagi pula, Android domestik punya persyaratan kualifikasi paling ketat dan standar review paling kompleks serta **berubah-ubah**.

> Tapi ironisnya, di saat yang sama, beberapa app copycat berkualitas rendah bisa mudah masuk rak dan menandai "manual re-inspection passed".

Mungkin inilah mengapa banyak karya developer indie di Xiaohongshu hanya punya versi iOS.

Google Play dan App Store tetap pilihan pertama.

> [!TIP]
> Semua orang dapat lebih memperhatikan dan mendukung developer indie dan tim kecil yang masih bertahan di platform Android domestik~

<br/>

Jadi, di 2024:

- Kami akan memindahkan bagian yang belum selesai dari rencana sebelumnya ke periode ini, seperti integrasi kalender, Pencapaian tipe ulang, kemampuan dasar, sistem data, dll.
- Pengembangan multi-platform akan jadi tujuan penting bagi kami, mungkin termasuk dua arah:
  - Memakai Flutter untuk mereplikasi LifeUp (karena SDM terbatas, ini akan dimajukan oleh rekan backend kami - Xiao Xiao)
  - Eksplorasi lebih banyak kemungkinan memakai KMP (Kotlin Multiplatform)

#### 1.2 Pertumbuhan Pengguna Domestik

Selain itu, LifeUp juga mengalami pertumbuhan pengguna signifikan di pasar app Tionghoa pada 2023. Terima kasih atas dukungan semua orang!

- Untuk mengurangi waktu mengeluarkan kode redeem manual dan lebih fokus pada pengembangan: Pada 2023 kami juga menghubungkan metode pembayaran otomatis (WeChat, Alipay) dan mendukung login WeChat.
  - Ini membebaskan banyak waktu kami.

- Pada 2023, ada penyebaran pengguna di Qzone yang kembali membuat server kami down beberapa hari.
- Kami juga mencoba mengoperasikan akun publik WeChat, Xiaohongshu, Bilibili, dll., untuk mempromosikan dan memperkenalkan pembaruan LifeUp dan penggunaan kreatif.

- Melalui diskusi dengan developer indie lain, kami menemukan kebanyakan pernah mengalami kesulitan serupa, akhirnya memilih menutup saluran pesan instan dan media sosial tertentu. Kami sangat relate.
  - Di perusahaan besar, biasanya ada tim customer service khusus atau bot untuk menangani banyak pertanyaan, secara efektif mengubahnya jadi kebutuhan spesifik atau umpan balik masalah untuk developer.
  - **Tapi developer indie umumnya harus menanggung customer service dan operasional; menghadapi pengguna tidak wajar memakan 100% waktu pengembangan developer indie ini, pada akhirnya memengaruhi developer, produk, dan pengguna inti produk.**
  - Oleh karena itu, kami semakin condong merekomendasikan pengguna memberi umpan balik via email, dll.

<br/>

Jadi, di 2024:

- Kami akan terus mengurangi investasi manusia pada pekerjaan konsultasi repetitif, dan sebagai gantinya memperbaiki dokumentasi dan FAQ. Meski konsultasi ada, akan ditangani seragam via email, saluran QQ, dll.
- Coba operasi media sosial dalam jumlah kecil.

#### 1.3 Pertumbuhan Pengguna Luar Negeri

Awal 2022, kami bergabung Google Play Pass dan melihat gelombang pertumbuhan pengguna.

Tapi pertumbuhan itu tidak bertahan lama; pertengahan 2022, pertumbuhan pengguna perlahan turun signifikan, tanpa tanda perbaikan.

Karena LifeUp adalah app pembelian sekali, pertumbuhan pengguna sangat penting bagi kami, dan menjadi landasan agar kami terus beroperasi dan punya kesempatan develop full-time di masa depan.

Kami mencoba banyak metode untuk meningkatkan pertumbuhan:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Menyewa desainer profesional untuk mendesain ulang gambar promosi toko
- Meningkatkan dukungan multi-bahasa app dan gambar promosi
- Meningkatkan deskripsi app
- Meningkatkan dokumentasi getting started
- Meningkatkan frekuensi pembaruan
- ...

Meski kami menerapkan banyak metode dan memperbaiki beberapa indikator. Kami tetap tidak bisa kembali ke periode pertumbuhan stabil.

Kami hanya bisa membiarkannya.

<br/>

Kabar baiknya, akhir 2023 tampaknya ada perbaikan.

<br/>

Jadi, di 2024:

- Perbaiki konstruksi internasionalisasi (dokumentasi, dukungan bahasa in-app, dll.).

#### 1.4 Manajemen Kualitas

Karena LifeUp adalah app alat offline yang dikembangkan dan diuji hanya oleh saya, menghindari crash serius sangat penting.

Proses iterasi versi di 2023 lebih lama dari sebelumnya, dan kami menyisihkan waktu cukup untuk beta testing agar persiapan menyeluruh.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Langkah-langkah ini tampak efektif mencegah crash serius skala besar.

Namun, setiap pembaruan versi tetap tak terhindar membawa beberapa masalah, termasuk di jalur kritis.

Oleh karena itu, kami akan terus meningkatkan manajemen kualitas LifeUp, dengan stabilitas sebagai indikator paling penting (terutama di bawah lingkungan semakin berat dan tantangan review).

<br/>

Jadi, di 2024:

- Perkuat manajemen kualitas.

#### 1.5 Pendalaman Fungsi

Seperti disebutkan di artikel ulang tahun ketiga, LifeUp adalah app yang dieksplorasi dan tumbuh secara bertahap.

Jadi hal seperti Toko, Pencapaian kustom, API bukan rencana awal, tapi berkembang dan ditambahkan seiring pembaruan dan umpan balik.

Tapi ini juga memperkenalkan beberapa masalah:

- Beberapa modul punya detail perencanaan kasar.
  - Misalnya, Hadiah Item awalnya hanya mempertimbangkan Hadiah tunggal.
  - Atribut dan sistem lain juga awalnya tidak mempertimbangkan kustomisasi, dan hanya refactoring bertahap yang bisa mendukung penambahan/penghapusan dan Level kustom, dll.
  - Banyak masalah semacam ini, seperti popup Hadiah/hukuman Atribut dan tampilan riwayat paling banyak mendukung 3.
- Modul yang baru ditambahkan kurang analisis dan perencanaan keseluruhan untuk app.

Kami akan terus mengikuti arah di artikel ulang tahun ketiga, mendalami modul fungsional app yang ada dan menyelesaikan beberapa pain point, alih-alih mengejar modul fungsional baru.

Misalnya, kami akan mendukung Hadiah Item multi-pilih langsung, memperbaiki mekanisme backup, optimasi notifikasi, penyelesaian widget, dll.

#### 1.6 API dan Ekstensibilitas

Seperti di atas, kami tidak lagi berencana memperkenalkan modul fungsional baru.

Tapi pasti ada permintaan untuk memperluas app.

Jadi kami memperkenalkan fungsi API di 2023.

Kami menyediakan inti LifeUp sebagai kemampuan dasar.

Meski pengguna tidak paham pemrograman, mereka dapat memakai alat otomasi seperti Tasker/MacroDroid untuk memperluas fungsi, mencapai kemampuan otomasi.

Contoh khas meliputi:

- NFC, QR code untuk menyelesaikan Tugas
- Auto check-in saat bangun
- Widget kustom
- Dan seterusnya...

Jika pengguna paham pemrograman, mereka dapat memperluas gameplay bahkan App dari sini.

![img](_media/development_plan_2024/desktop.png)

Kami juga mengembangkan versi desktop sederhana berbasis API (dan open-source).

Meski setelah beberapa versi perluasan API, kami masih kurang banyak kemampuan.

Misalnya, tidak mendukung operasi terkait "thought", tidak mendukung memperbarui data via Content Provider, dll.

Kami akan terus memperluas API di 2024 untuk mencakup setiap aspek app sebisa mungkin.

> Meski saat ini kami melihat banyak pengguna memakai API untuk pribadi, masih sedikit produk runnable yang dibagikan. Kami perlu terus memberikan kemampuan API lebih kuat untuk membangun ekosistem API.

#### 1.7 Tentang Masa Depan

Dengan masalah di atas dan perubahan lingkungan, kami juga secara bertahap menyesuaikan harga keanggotaan seumur hidup LifeUp (meski begitu, harga keanggotaan LifeUp jauh lebih rendah dari kebanyakan app lain), dan pembaruan akan cenderung menyediakan fitur sebagai fitur keanggotaan.

Kami perlahan sadar bahwa app pada akhirnya melayani pengguna inti.

Umpan balik dan dukungan pengguna inti pada akhirnya dapat tercermin dalam peningkatan app, mencapai co-creation dan siklus positif antara developer dan pengguna.

Jika kita coba menyenangkan semua orang, app akan jadi campur aduk kode, menyimpang dari permintaan pengguna inti, dan mengurangi penghasilan serta motivasi developer.

<br/>

Kami menyebut KMP (Kotlin Multiplatform) di atas, teknologi lintas platform yang relatif baru. Ini juga bisa memakai kemampuan native secara campuran.

Selama pengembangan LifeUp, kami perlahan punya ide-ide baru. Tapi tidak semua ide bisa atau cocok dilandaskan di LifeUp.

Misalnya, mengganti seluruh UI, perubahan besar logika Toko, dll., yang pasti seriously memengaruhi pengalaman pengguna yang ada. Kami juga melihat banyak kasus perubahan besar app yang mengarah ke kegagalan.

<br/>

Juga, saat LifeUp awal dikembangkan, framework database resmi "Room" belum tersedia, jadi kami memilih framework database domestik niche.

Sekarang beberapa masalah performa jadi menonjol, dan sulit diganti.

Selain itu, LifeUp sekarang mendukung Material 3 dan Material Design legacy, plus dark mode, multi-bahasa, fragmentasi sistem ponsel domestik (dokumentasi konfigurasi kompatibilitas hanya makin panjang, sistem native dan versi luar negeri umumnya hanya butuh konfigurasi satu halaman) dan masalah lain. Setiap halaman perlu mempertimbangkan banyak hal kompleks.

<br/>

Jadi kami merencanakan eksplorasi KMP untuk melihat apakah bisa memakai teknologi dengan KMP.

Juga agar punya kesempatan mewujudkan lebih banyak ide dan proyek baru di masa depan — lebih banyak keterampilan tidak rugi.

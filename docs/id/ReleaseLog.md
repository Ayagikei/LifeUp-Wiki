# Catatan Rilis

## Linimasa

![timeline](_media/release_log/timeline.png)

## Catatan

| Platform          | Versi                  | Tanggal Pembaruan           |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.5              | 2026/09/01                  |
| LifeUp-iOS        | lihat [feature/ulives] | 🎉App alternatif tersedia   |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Sebagian terjemahan disediakan oleh mesin/AI dan mungkin tidak akurat)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.5 (2026/09/01)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah akumulasi data Tugas yang tidak normal dalam kondisi tertentu**: Hal ini dapat membuat operasi Tugas seperti pengurutan atau penghapusan menjadi lambat atau tidak responsif. Pembaruan secara otomatis membersihkan data tidak valid yang terpengaruh dan meningkatkan kinerja pada riwayat Tugas yang besar.

**v1.105.3 (2026/08/26)**

**🐛 Perbaikan Bug**

1. **Memperbaiki penyelesaian Tugas yang tidak normal setelah mengonversi tugas tim menjadi tugas berwaktu secara lokal.**

**v1.105.2 (2026/08/24)**

**🐛 Perbaikan Bug**

1. **Memperbaiki pemilih Tugas yang menampilkan daftar kosong saat daftar pintar dipilih.**
2. **Memperbaiki pencarian di daftar pintar yang juga menampilkan Tugas yang bukan bagian dari daftar tersebut.**

**v1.105.1 (2026/08/19)**

**✨ Fitur**

1. **Efek suara kustom dapat dinonaktifkan per adegan**: Bisukan satu isyarat tanpa memengaruhi yang lain; pratinjau tetap diputar agar Anda dapat memeriksa suaranya.

**♻️ Optimisasi**

1. **Panduan cadangan lebih jelas saat layanan Google Play tidak tersedia**: Jika Google Drive tidak dapat digunakan, App menjelaskan alasannya dan menyarankan file lokal, Dropbox, atau WebDAV.

**🐛 Perbaikan Bug**

1. **Memperbaiki ketukan Batalkan di halaman Selesai kalender yang tidak bereaksi.**
2. **Memperbaiki batas pembelian/penggunaan yang tidak dipulihkan (atau tersimpan kosong) saat mengedit Item.**

**v1.105.0 (2026/08/04)**

**ℹ️ Catatan Penting**

1. **Android 6.0 kini menjadi versi minimum yang didukung**: Untuk secara proaktif mendukung fitur dan persyaratan perilaku dari versi Android yang lebih baru, versi minimum yang didukung dinaikkan dari Android 5.0 ke Android 6.0. Pengguna Android 5.x tidak dapat menginstal atau memperbarui ke versi ini.

**✨ Fitur**

1. **Menambahkan URL Scheme API kontrol Pomodoro**: Pengguna dapat memeriksa status, memilih Tugas, serta memulai, menjeda, melewati, menghentikan, atau menyelesaikan sesi Pomodoro/count-up.
2. **Meningkatkan mekanisme urutan Tugas kustom**: Memperkenalkan mekanisme urutan baru agar urutan kustom tetap stabil saat menyalin, menyelesaikan, membatalkan, dan menangani Tugas dalam kasus tepi lainnya.

**♻️ Optimisasi**

1. **Menambahkan dukungan predictive-back Android**: Editor Tugas, Toko, Sintesis, dan Pencapaian kini mendukung gestur predictive-back sistem.
2. **Meningkatkan inisialisasi login Facebook**: SDK diinisialisasi saat login diminta, dengan penanganan status error yang lebih baik.

**🐛 Perbaikan Bug**

1. **Memperbaiki permintaan edit URL Scheme yang secara tidak terduga menimpa field yang ada**: Field yang dihilangkan kini mempertahankan nilai sebelumnya, dan parameter Hadiah atau relasi yang tidak valid tidak lagi menghapus data yang ada.
2. **Memperbaiki judul notifikasi timer positif yang tidak mengikuti Tugas yang dipilih dalam kasus tepi tertentu.**
3. **Memperbaiki pratinjau RGB yang tidak diperbarui setelah nilai warna heksadesimal pertama ditempel.**
4. **Memperbaiki bayangan yang hilang pada toolbar seleksi di halaman detail Sintesis dan Pencapaian.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Perbaikan Bug**

1. **Memperbaiki sesi Pomodoro yang tidak dipulihkan dengan benar setelah App atau layanan timer berhenti secara tidak terduga**: Sesi yang valid kini dapat dipulihkan dengan benar, sementara status usang yang tidak valid dibersihkan.
2. **Memperbaiki prompt berulang setelah perubahan zona waktu sistem**: Setelah mengonfirmasi penyesuaian, waktu Tugas diperbarui dengan benar tanpa menampilkan prompt yang sama lagi.

**v1.104.5 (2026/07/17)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah pada build rilis v1.104.4 di mana membuka halaman Pomodoro dapat menyebabkan App crash.**

**v1.104.4 (2026/07/17)**

**✨ Fitur**

1. **Item kini mendukung pembatasan pembelian/penggunaan berdasarkan rentang Poin Pengalaman Atribut**: Atur kondisi Poin Pengalaman minimum dan maksimum untuk mengontrol apakah Item dapat dibeli, digunakan, atau keduanya.
2. **Kondisi Pencapaian baru untuk menyelesaikan Tugas sebanyak N kali total dalam sehari**: Berbeda dengan kondisi Tugas berbeda yang sudah ada, kondisi ini menghitung setiap penyelesaian Tugas yang valid hari itu, termasuk penyelesaian berulang Tugas yang sama.

**♻️ Optimisasi**

1. **Alur penyelesaian dan pemulihan Pomodoro dibangun ulang**: Status timer, catatan Fokus, dan penyelesaian Hadiah kini mengikuti proses terpadu. Pemulihan juga lebih andal jika proses App dihentikan, mengurangi kasus tepi seperti waktu Fokus yang hilang. Jika Anda melihat perubahan perilaku yang tidak terduga, hubungi kami di lifeup@ulives.io.
2. **Pengeditan jumlah resep Sintesis lebih mulus**: Ketuk bahan atau hasil yang ada untuk mengedit jumlahnya langsung, tanpa memilih Item yang sama lagi. Anda tetap dapat memilih ulang Item jika diperlukan.
3. **Pomodoro kini dapat dibuka dalam mode lanskap langsung dari halaman utama**: Lihat dan operasikan timer dengan lebih nyaman dalam tata letak horizontal.

**v1.104.3 (2026/07/09)**

**✨ Fitur**

1. **Panduan "Pengaturan Cepat" baru di layar sambutan**: Dua halaman baru (5 dan 6) setelah kartu intro memungkinkan Anda mengonfigurasi izin notifikasi, metode pengingat, gaya UI (Material 2/3), dan tampilan multi-jendela langsung dari onboarding — dengan kartu gaya akordeon. Semua opsi dapat disesuaikan nanti di Pengaturan.

**♻️ Optimisasi**

1. **Memperbarui teks intro halaman sambutan**: Halaman 1–4 ditulis ulang untuk lebih jelas menyampaikan nilai inti App: Tugas kustom → pertumbuhan stat → sistem Hadiah → terhubung dengan dunia.
2. **Dialog Sintesis dirancang ulang sebagai bottom sheet**: Bahan dan hasil kini ditampilkan dalam grid vertikal, membuat tata letak lebih bersih dan intuitif.
3. **Pemuatan data lebih cepat saat beralih antar daftar tugas, mengubah urutan sortir, atau mengalihkan pengaturan pengelompokan**.

**🐛 Perbaikan Bug**

1. **Memperbaiki notifikasi "Pencapaian Terbuka" ganda** untuk Pencapaian sistem tertentu.
2. **Memperbaiki penghitungan yang tidak akurat untuk Pencapaian "Selesaikan N Tugas Berbeda Setiap Hari"**: Tugas tak terbatas tidak lagi dikecualikan, dan menyelesaikan Tugas yang sama beberapa kali pada hari yang sama kini dihitung sebagai satu.
3. **Memperbaiki tombol tambah (+) pada daftar Tugas yang sesekali bergeser dari posisi yang benar**.
4. **Memperbaiki daftar pintar yang tidak menyaring Tugas yang diarsipkan saat "Kelompokkan menurut Daftar" dinonaktifkan**.

**v1.104.2 (2026/07/03)**

**✨ Fitur**

1. **"Hari Menggunakan" diganti menjadi "Hari Pendamping" di halaman statistik**: Ketuk kartu untuk menyesuaikan tanggal mulai dan menetapkan hari jadi Anda sendiri. Deskripsi kondisi Pencapaian terkait juga diperbarui menggunakan istilah "pendamping".
2. **Opsi "Cadangkan & Bagikan" ditambahkan ke menu cadangan**: Bagikan file cadangan langsung ke App lain melalui panel berbagi sistem.
3. **API efek Kotak Jarahan v2**: Rute `loot_box/v2` baru mendukung pencocokan Item presisi via `sub_amount`, menambah/menghapus Item, dan kontrol independen mode jumlah dan probabilitas.

**♻️ Optimisasi**

1. **URL Scheme kini memprioritaskan pencocokan nama persis** saat mengedit Item Toko, Kotak Jarahan, atau subtugas, beralih ke pencocokan fuzzy hanya jika tidak ada kecocokan persis — mencegah edit yang tidak diinginkan.
2. **"FAQ" di sidebar diganti menjadi "Notice" dalam bahasa Inggris**: Versi Tionghoa sudah "公告" dan tetap tidak berubah.
3. **Efek ripple tombol kini sesuai radius sudut di semua tempat**: Animasi ripple pada kontrol membulat tidak lagi meluap melewati batas sudut, membuat ketukan terasa lebih halus di seluruh App.

**🐛 Perbaikan Bug**

1. **Memperbaiki halaman pomodoro yang tidak memperbarui otomatis jumlah tomat setelah menambah atau mengedit catatan.**
2. **Memperbaiki toast yang menampilkan tomat yang diperoleh sesekali tidak muncul setelah menambah catatan pomodoro.**
3. **Memperbaiki catatan pomodoro yang ditambahkan manual menghitung tomat berdasarkan Tugas yang sedang dipilih alih-alih Tugas yang dipilih dalam catatan**: Perhitungan kini menggunakan durasi Fokus spesifik Tugas yang benar-benar dipilih dalam catatan. Jika Anda menetapkan durasi Fokus berbeda untuk Tugas berbeda, tomat yang dicatat manual kini lebih akurat.
4. **Memperbaiki tampilan "jumlah penyelesaian" yang salah untuk Tugas tak terbatas di riwayat**: Kini ditampilkan sebagai urutan harian (mis., "kali ke-N hari itu").
5. **Memperbaiki teks motivasi Tugas penalti yang tidak muncul** — kini muncul setelah menyelesaikan penalti.

**v1.104.1 (2026/06/17)**

**✨ Fitur**

1. **Opsi ekspor cadangan ditingkatkan**: Saat membuat cadangan manual, bottom sheet baru memungkinkan Anda memilih apakah akan menyertakan file media, info sensitif akun (status login, kredensial WebDAV, dll.), dan gambar emoji — memudahkan berbagi cadangan yang disanitasi. Bagian cadangan otomatis juga mendapat tiga toggle persisten yang sesuai.
2. **Pemilih Tugas pomodoro ditingkatkan**: Tugas berwaktu kini muncul pertama di pemilih Tugas dengan progres Fokus saat ini (durasi fokus / durasi target / persentase). Toggle memungkinkan Anda mengaktifkan atau menonaktifkan prioritas Tugas berwaktu untuk akses cepat.
3. **Desain ulang halaman Tentang**: Halaman Tentang direstruktur menjadi bagian Tautan, Umpan Balik, Komunitas, dan Pengembang dengan entri baru untuk situs web, catatan rilis, FAQ, dan dokumentasi API. Pengguna Tionghoa Sederhana mendapat entri Tencent Channel, sementara pengguna luar negeri mendapat akses komunitas GitHub Issues/Discussions.
4. **Hapus pengikut**: Anda kini dapat menghapus pengikut dari halaman anggota tim.
5. **Peningkatan pemilih Atribut Toko**: Tombol pemilih Atribut ditambahkan ke dialog input exp/efek Toko, mendukung filter cepat menurut grup Keterampilan dan multi-seleksi batch — jauh lebih mudah saat menangani banyak Atribut.

**♻️ Optimisasi**

1. **Statistik Pomodoro kini mendukung pengalihan format tampilan waktu**: Ketuk area statistik pomodoro di halaman detail Tugas untuk beralih antara "jam/menit", "hari/jam/menit", dan "total menit".
2. **Status penyelesaian subtugas lebih jelas**: Subtugas yang selesai kini menampilkan coret, membuat perbedaan antara selesai dan tertunda jauh lebih jelas.
3. **Memperbaiki pengurutan catatan pomodoro**: Catatan Pomodoro kini diurutkan berdasarkan waktu selesai secara menurun.

**🐛 Perbaikan Bug**

1. **Memperbaiki teks tombol penarikan ATM di berbagai bahasa**: Memperbaiki penggunaan gerund yang salah pada teks tombol penarikan ATM di beberapa locale.
2. **Memperbaiki perilaku berbagi Item Toko saat belum login**: Menyelesaikan perilaku abnormal saat membagikan Item Toko tanpa login.
3. **Memperbaiki status echo pemilih warna**: Memperbaiki masalah di mana dialog pemilih warna menampilkan status terpilih yang salah.

**v1.104.0 (2026/05/23)**

**✨ Fitur**

1. **Tugas hitungan kini mendukung penyelesaian Hadiah real-time proporsional**: Berguna untuk Tugas yang mungkin Anda progres beberapa kali pada momen fleksibel dalam satu siklus, seperti kebiasaan yang diselesaikan beberapa kali per minggu. Saat progres hitungan berubah, LifeUp dapat memberikan atau membatalkan Exp, koin, dan Hadiah Item sesuai progres saat ini alih-alih menunggu hingga penyelesaian akhir.
2. **Alat riwayat detail Tugas lebih andal**: Memilih tanggal di kalender riwayat kini menampilkan hitungan hari itu, dan Anda dapat menambah, mengedit, atau membuat catatan riwayat secara batch.
3. **Perasaan dan Item lebih terhubung**: Detail Item kini dapat langsung melompat ke Perasaan terkait, dan halaman Perasaan mendukung filter menurut Item Toko.
4. **Waktu penyelesaian subtugas kini dicatat**: LifeUp kini mencatat kapan setiap subtugas diselesaikan, menyiapkan data untuk dukungan API dan LifeUp Cloud di masa depan.

**♻️ Optimisasi**

1. **Filter visibilitas Item Toko lebih presisi**: Selain Item habis terjual, Anda kini dapat menyembunyikan Item yang dinonaktifkan pembeliannya, dibatasi pembeliannya, atau saat ini tidak terjangkau. Widget Toko mengikuti aturan yang sama.
2. **Pencarian dan refresh daftar Tugas lebih stabil**: Pencarian daftar reguler dapat menyertakan Tugas selesai yang saat ini terlihat menurut pengaturan, dan refresh Tugas berulang plus sortir kustom di daftar Semua lebih stabil dengan banyak Tugas.
3. **Statistik riwayat detail Tugas kini mengikuti tanggal yang dipilih**: Tugas hitungan dan Tugas tak terbatas kini menggunakan level warna peta kontribusi berbeda berdasarkan jumlah penyelesaian setiap hari. Statistik bulanan, tahunan, sepanjang waktu, dan streak di bawah tampilan riwayat juga dihitung dari tanggal yang dipilih saat ini alih-alih selalu menggunakan data hari ini.
4. **Sortir alfabetis lebih intuitif**: Sortir alfabetis di seluruh modul kini mengikuti urutan numerik alami, sehingga nama yang berisi angka diurutkan menurut nilai numerik alih-alih perbandingan karakter demi karakter.
5. **Perilaku input pengaturan Toko ditingkatkan**: Pengaturan Toko kini menggulir input yang difokuskan di atas keyboard lunak.
6. **Penanganan mode gelap sistem lebih andal**: Memperbaiki race condition antara mengikuti tema sistem dan toggle mode malam manual.
7. **Dukungan URL Scheme API diperluas**: Tambah/Edit Tugas kini mendukung semantik `no_deadline`, dan API Tugas hitungan mendukung flag penyelesaian real-time.
8. **Catatan riwayat bunga lebih jelas**: Catatan bunga ATM dan kredit kini menampilkan pokok dan hari bunga, memudahkan verifikasi sumber bunga.

**🐛 Perbaikan Bug**

1. **Memperbaiki statistik Pencapaian di Halaman Saya**: Saat Pencapaian sistem disembunyikan, jumlah Pencapaian kini mengikuti aturan visibilitas yang sama.
2. **Memperbaiki wording catatan riwayat**: Catatan riwayat menyerah tidak lagi ditampilkan dengan wording penalti terlambat.
3. **Memperbaiki penanganan teks panjang di URL Scheme API**: Deskripsi panjang untuk Keterampilan dan Pencapaian tidak lagi terpotong terlalu dini.

**v1.103.6 (2026/05/10)**

**🐛 Perbaikan Bug**

1. **Memperbaiki petunjuk interval istirahat panjang yang tidak kembali ke status sesi Fokus awal setelah mengetuk Menyerah.**
2. **Memperbaiki masalah di mana timer Fokus tambahan dapat tetap terlihat dan terus menghitung setelah mengetuk Menyerah.**

**v1.103.5 (2026/05/10)**

**🐛 Perbaikan Bug**

1. **Memperbaiki petunjuk istirahat panjang timer Pomodoro yang tidak diperbarui segera setelah sesi kerja selesai secara alami.**
2. **Memperbaiki masalah di mana timer Pomodoro dapat menampilkan interval istirahat panjang 2 sesi lama sebelum pengaturan Pomodoro dibuka, alih-alih default 4 sesi.**

**v1.103.4 (2026/05/05)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah di mana Tugas dapat hilang akibat interupsi abnormal saat dibekukan dalam beberapa skenario tepi.**

**v1.103.3 (2026/05/05)**

**ℹ️ Catatan Rilis**

1. **Versi ini dilewati dan tidak dirilis secara publik.**

**v1.103.2 (2026/04/30)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah kompatibilitas di mana field input mungkin tidak muncul saat mengedit pembatasan pembelian atau penggunaan Item dalam bahasa tertentu atau ukuran layar lebih kecil.**
2. **Memperbaiki masalah di mana menggunakan Item dapat secara tidak benar memicu dialog penalti.**

**v1.103.1 (2026/04/25)**

**🐛 Perbaikan Bug**

1. **Memperbaiki perilaku abnormal saat efek penggunaan Item mengubah jumlah Item itu sendiri**
2. **Memperbaiki beberapa crash dan masalah lag yang tercatat dari produksi**
3. **Memperbaiki nilai jumlah yang salah terisi kembali saat mengedit efek "Ubah Jumlah Item" pada Item**

**v1.103.0 (2026/04/12)**

**✨ Fitur**

1. **Atribut kini mendukung subkategori dan pemindahan cepat**: Anda dapat mengelompokkan Atribut lebih jelas dan memindahkan Atribut ke grup target lebih cepat.
2. **Interaksi pemilihan Atribut lebih mulus**: Pengeditan Tugas, alur terkait Hadiah, dan pemilih Atribut lainnya kini lebih mudah dinavigasi saat Anda memiliki banyak Atribut.
3. **Item kini mendukung pembatasan pembelian/penggunaan**: Batas dapat berlaku untuk pembelian, penggunaan, atau keduanya, dengan kondisi yang lebih kaya seperti waktu, Pencapaian terbuka, Tugas selesai, jumlah Item dimiliki, dan rentang Level Atribut.
4. **Pencapaian menambahkan lebih banyak opsi sortir bawaan**: Selain urutan kustom, daftar Pencapaian kini mendukung sortir bawaan menurut urutan alfabetis, waktu penyelesaian, dan waktu pembuatan.
5. **Pencapaian mendukung pemindahan cepat ke subkategori**: Pindahkan satu atau beberapa Pencapaian ke subkategori target lebih efisien.
6. **Penanganan terlambat kini menyertakan entri bantuan**: Dialog terlambat kini menyertakan entri bantuan dan menyajikan perubahan Hadiah lebih jelas saat Anda mengalihkan Tugas terlambat kembali ke selesai.

**♻️ Optimisasi**

1. **Tampilan Atribut terkelompok lebih jelas**: Halaman status dan dialog deskripsi Atribut kini menyajikan Atribut terkelompok dengan cara yang lebih terstruktur.
2. **Interaksi terkait Atribut lebih konsisten**: Tampilan terkelompok dan perilaku seleksi lebih terpadu di dialog Atribut dan alur pengeditan terkait.
3. **Pengeditan pembatasan Item lebih mudah dipahami**: Jenis pembatasan yang lebih kaya lebih mudah dikonfigurasi dan ditinjau.
4. **Rendering status bar dan top bar lebih stabil di berbagai halaman**: Area atas pada halaman seperti Toko, Dunia, Pencarian, Status, Pencapaian, Halaman Saya, dan WebDAV kini berperilaku lebih konsisten saat menggulir, dalam mode gelap, dan di bawah Material You.
5. **Tata letak Atribut halaman status menangani teks lebih panjang dengan lebih baik**: Nama Atribut dan label Level yang lebih panjang kini muat lebih andal, termasuk di layar sempit atau dengan teks lebih besar.

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah variasi gid generasi salinan**: Memperbaiki masalah di mana Tugas salinan yang dihasilkan dari Tugas terlambat sekali atau tak terbatas memiliki gid yang tidak konsisten.
2. **Memperbaiki checkbox "Acak" yang tidak berfungsi dalam seleksi Atribut**: Memperbaiki masalah di mana beberapa kotak seleksi Atribut menampilkan checkbox "Acak" yang tidak berfungsi.
3. **Memperbaiki masalah posisi banner Hadiah**: Memperbaiki masalah di mana banner Hadiah diposisikan salah, tertutup, atau melompat dalam skenario tertentu (terutama saat dipicu oleh penyelesaian Tugas).
4. **Memperbaiki pratinjau/animasi Hadiah terlambat yang tidak akurat dalam beberapa kasus**: Saat Tugas terlambat dialihkan kembali ke selesai, perubahan Poin Pengalaman, koin, dan Item kini disajikan lebih akurat tanpa mencampur nilai yang membingungkan.
5. **Memperbaiki wrap/misalignment tata letak Level halaman status dalam beberapa kasus**: Tata letak kini lebih stabil dengan nama Atribut panjang atau label Level lebih panjang.
6. **Memperbaiki pergantian halaman saat daftar Sintesis hanya memiliki beberapa Item**: Anda kini dapat menggeser horizontal dari area kosong lebih andal saat konten daftar pendek.
7. **Memperbaiki crash saat mengklaim Hadiah Pencapaian dalam kasus khusus**: Memperbaiki potensi crash saat mengklaim Hadiah Pencapaian dalam kasus tepi tertentu.

**v1.102.11 (2026/04/02)**

**🐛 Perbaikan Bug**

1. **Memperbaiki kegagalan penyelesaian sesekali dan anomali refresh pada Tugas hitungan di halaman utama.**

**v1.102.10 (2026/03/24)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah di mana daftar formula Sintesis tersembunyi tidak dapat ditekan lama untuk mengedit atau menghapus formula.**

**v1.102.9 (2026/03/23)**

**♻️ Optimisasi**

1. **Aturan penonaktifan navigasi bawah diperbarui**: Di tingkat interaksi, pengguna tidak lagi diizinkan menonaktifkan semua modul navigasi bawah.

**🐛 Perbaikan Bug**

1. **Memperbaiki crash saat startup**: Memperbaiki masalah di mana App dapat crash saat diluncurkan setelah semua modul navigasi bawah dinonaktifkan.

**v1.102.8 (2026/03/23)**

**✨ Fitur**

1. **Atur ulang tata letak modul default**: Menambahkan tombol "Pulihkan Tata Letak Default" ke halaman konfigurasi modul.
2. **Event broadcast formula Sintesis baru**: Menambahkan event broadcast API `app.lifeup.synthesis.complete`, dikirim saat formula Sintesis berhasil diselesaikan.
3. **Pencarian Dunia mendukung filter tag sumber**: Bagian Dunia kini dapat mencari menurut tag sumber, seperti memfilter Item API di Showcase sebelum mencari.

**♻️ Optimisasi**

1. **Peningkatan tipografi popup pembukaan Pencapaian**: Meningkatkan rendering font dan mengurangi masalah tata letak saat ukuran font sistem besar digunakan.
2. **Peningkatan logika penyembunyian modul**: Menyempurnakan perilaku penyembunyian modul sehingga Pencapaian terkait modul Dunia ditampilkan atau disembunyikan dengan benar.
3. **Menyesuaikan perilaku penugasan default Tugas acak**: Tugas acak yang baru dibuat tidak lagi otomatis ditugaskan ke daftar default, menghindari penugasan diam-diam.

**🐛 Perbaikan Bug**

1. **Memperbaiki crash langka saat refresh daftar Tugas**.
2. **Memperbaiki masalah judul API Perasaan**: Memperbaiki masalah di mana API gagal menyediakan judul Perasaan dengan benar, yang juga dapat memengaruhi judul Item.
3. **Memperbaiki masalah tata letak lanskap Pomodoro**.
4. **Memperbaiki tipe timestamp waktu selesai di API riwayat Tugas**.
5. **Menambahkan field respons API yang hilang**: Progres Tugas, status penyelesaian, kondisi akhir pengulangan, dan field terkait kini dikembalikan dengan benar.
6. **Memperbaiki nilai usang di halaman detail Tugas hitungan**: Nilai kini diperbarui segera setelah memperbarui Tugas hitungan.
7. **Memperbaiki masalah yang dapat menyebabkan durasi catatan Pomodoro abnormal**.
8. **Memperbaiki halaman utama yang tidak dibangun ulang segera setelah masuk mode offline**: Sebelumnya ini dapat membuat bagian Dunia tetap terlihat secara tidak terduga.
9. **Memperbaiki masalah pemuatan di halaman Tugas acak**: Dalam beberapa kasus, halaman dapat macet dalam status pemuatan.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Optimisasi**

1. **Tutorial tambah widget + peningkatan teks**: Menambahkan panduan untuk menambah widget dan menyempurnakan teks serta petunjuk terkait.

**🐛 Perbaikan Bug**

1. **Memperbaiki deadlock Pomodoro dengan data abnormal**: Halaman Pomodoro tidak lagi macet/beku saat data abnormal ada.
2. **Memperbaiki desinkronisasi timer tambahan setelah layar mati**: Timer "tambah waktu" kini tetap sinkron setelah layar mati atau perangkat tidur.
3. **Memperbaiki pemilihan daftar default untuk Tugas baru**: Meningkatkan penanganan saat membuat Tugas dari daftar pintar, terutama jika daftar default diarsipkan (kini fallback dengan benar).

**v1.102.1 (2026/01/27)**

**✨ Fitur**

1. **Pratinjau Gambar Zoom**: Memulihkan fungsi zoom gambar yang hilang selama refactoring halaman, memungkinkan melihat detail gambar lebih mudah.

**🐛 Perbaikan Bug**

1. **Optimisasi Memori WebDAV**: Memperbaiki masalah di mana mengunduh dari WebDAV dapat mengonsumsi memori berlebihan, berpotensi menyebabkan crash atau masalah performa.
2. **Refresh Gambar Refleksi**: Menyelesaikan bug di mana gambar yang diedit di halaman Refleksi tidak diperbarui segera.

**v1.102.0 (2026/01/25, diganti oleh v1.102.1 selama rilis bergulir)**

**✨ Fitur**

1. **Manajer Suara**: Impor, pratinjau, hapus, dan gunakan ulang efek suara, serta gunakan sebagai efek penggunaan Item.
2. **Toko: efek penggunaan Item baru**: Menambahkan Poin Pengalaman acak, perubahan stok, pemutaran suara, dan meningkatkan alur konfigurasi.
3. **Tugas Berwaktu**: Jenis Tugas baru dengan durasi Fokus yang diharapkan; selesaikan Tugas setelah mencapai target timer.
4. **Opsi Hari Awal Minggu**: Pilih Senin / Sabtu / Minggu, dan kalender & statistik akan mengikuti.
5. **Lewati onboarding**: Opsi untuk melewati tutorial saat peluncuran pertama.
6. **Input emoji untuk ikon**: Masukkan emoji (termasuk emoji kombinasi) untuk membuat ikon dengan cepat.
7. **Kalender: buka detail Tugas berulang di masa depan**: Mengetuk Tugas berulang pada tanggal mendatang kini membuka detailnya dengan benar.
8. **Pengguna mahir: peningkatan API**: URL Scheme API menambah/memperluas CRUD template Tugas, kondisi akhir pengulangan, navigasi filter Sintesis, dan lainnya.

**♻️ Optimisasi**

1. **Peningkatan performa & kelancaran**: Mengoptimalkan akses data dan strategi pengindeksan agar daftar Tugas, riwayat Inventaris, dan statistik lebih mulus dengan dataset besar.
2. **UX konfigurasi efek Item lebih baik**: Meningkatkan interaksi seleksi dan tampilan efek, dengan dialog dan visual ikon yang disempurnakan.
3. **Peningkatan lokalisasi**: Melengkapi terjemahan yang hilang di berbagai bahasa.

**🐛 Perbaikan Bug**

1. **Memperbaiki reset efek hitung mundur saat edit**: Memperbaiki masalah di mana mengonfirmasi efek hitung mundur yang diedit dapat mereset nilai ke 1.
2. **Memperbaiki auto-use Hadiah Item Tugas tim yang tidak terpicu**: Memperbaiki masalah di mana auto-use tidak terpicu setelah mengklaim Hadiah Item untuk Tugas tim.
3. **Memperbaiki prompt "catat Perasaan" yang hilang setelah Kotak Jarahan / Sintesis**: Memperbaiki masalah di mana dialog Perasaan mungkin tidak muncul setelah membuka Kotak Jarahan atau menggunakan Sintesis sederhana saat Item memiliki efek "catat Perasaan".
4. **Memperbaiki dialog penyelesaian Hadiah/Perasaan yang hilang saat penyelesaian manual Pomodoro**: Memperbaiki masalah di mana menyelesaikan Tugas secara manual di halaman Pomodoro dapat melewati dialog penyelesaian Hadiah/Perasaan, dan memulihkan tekan-lama-untuk-selesai pada judul Tugas.
5. **Memperbaiki filter lipat widget yang tidak berfungsi**: Memperbaiki filter widget daftar pintar "Lipat Tugas yang belum dimulai" yang tidak berlaku.
6. **Memperbaiki crash langka**: Memperbaiki crash yang disebabkan oleh menyimpan terlalu banyak state dalam situasi tertentu.
7. **Memperbaiki navigasi kalender-ke-detail untuk Tugas mendatang**: Memperbaiki kegagalan saat membuka detail Tugas berulang mendatang dari tampilan kalender.
8. **Memperbaiki masalah Tugas berulang Ebbinghaus**: Memperbaiki tahap abnormal dan generasi berulang yang tidak diinginkan dalam kasus langka, dengan pengaman batas atas ditambahkan.

**v1.101.8 (2026/01/12)**

**🐛 Perbaikan Bug**

1. **Memperbaiki pengaturan kondisi akhir pengulangan**: Menyelesaikan masalah di mana kondisi akhir tidak dapat ditetapkan untuk frekuensi "Setiap 2 hari" atau kustom "Setiap N hari".
2. **Memperbaiki durasi timer Pomodoro abnormal**: Memperbaiki masalah di mana timer dapat berjalan jauh lebih lama dari yang diharapkan akibat tidur sistem atau proses beku saat optimisasi baterai tidak dinonaktifkan dengan benar.

**v1.101.7 (2026/01/11)**

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah yang dapat menyebabkan durasi timer Pomodoro dipersingkat secara abnormal**.

**v1.101.6 (2026/01/10)**

**🐛 Perbaikan Bug**

1. **Memperbaiki anomali terkait pengalihan mode gelap sistem**.

**v1.101.5 (2026/01/08)**

**♻️ Optimisasi**

1. **Mengoptimalkan pengalihan mode gelap sistem**: Memperbaiki masalah di mana App mungkin gagal beralih tema secara otomatis mengikuti pengaturan sistem.
2. **Mengoptimalkan seleksi Atribut untuk Hadiah**: Meningkatkan penanganan kasus di mana tidak ada Atribut yang dipilih dalam "Hadiah Ketekunan", "Hadiah Langkah", dan "Hadiah Suka". Mendukung membatalkan pilihan Atribut dan memperbaiki masalah di mana Hadiah pengalaman tidak diberikan dengan benar.
3. **Optimisasi konfigurasi performa**: Mengoptimalkan konfigurasi internal untuk berpotensi meningkatkan performa App.

**🐛 Perbaikan Bug**

1. **Memperbaiki kueri statistik dan tampilan grafik**: Memperbaiki kondisi kueri untuk statistik waktu penyelesaian Tugas dan menyelesaikan masalah tampilan data grafik yang tidak akurat.
2. **Memperbaiki interaksi dialog pengaturan widget**: Memperbaiki bug di mana tombol "Konfirmasi" hilang di dialog pengaturan filter Tugas widget.
3. **Memperbaiki sinkronisasi jumlah Tugas**: Memperbaiki masalah di mana jumlah Tugas di layar utama tidak diperbarui dengan benar setelah diperbarui dari halaman detail Tugas.
4. **Memperbaiki penanganan penggunaan Item API Perasaan**: Memperbaiki penanganan yang salah untuk tipe "Penggunaan Item" di API Perasaan.
5. **Memperbaiki navigasi kalender-ke-detail**: Menyelesaikan beberapa masalah saat menavigasi dari tampilan kalender ke detail Tugas.

**v1.101.4 (2025/12/30)**

**♻️ Optimisasi**

1. **Mengoptimalkan logika deteksi pembaruan anggota**: Mengingatkan anggota untuk beralih ke "Member Stable Channel" agar mendapatkan pengalaman fungsional yang paling stabil.
2. **Mengurangi permintaan jaringan yang tidak perlu**: Lebih menghemat data pengguna dan mengurangi biaya server.

**🐛 Perbaikan Bug**

1. **Memperbaiki masalah pembaruan progres Pencapaian (Prioritas)**: Memperbaiki bug di mana progres Pencapaian gagal terpicu dengan benar setelah menyelesaikan catatan Pomodoro.

**v1.101.3 (2025/12/14)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana opsi "Jatuh Tempo Hari Ini" secara keliru mengabaikan offset batas waktu hari berikutnya.

**v1.101.2 (2025/12/13)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana status pencarian direset saat kembali ke halaman Toko, Inventaris, atau Tugas.
2. Memperbaiki crash terkait batas `AlarmManager` (sekitar 500 alarm bersamaan).
3. Memperbaiki crash terkait warna dinamis, dialog zona waktu, dan menu pop-up.
4. Mengoptimalkan pelaporan crash agar mengabaikan kesalahan jaringan umum.

**v1.101.1 (2025/12/01)**

**🐛 Perbaikan Bug**

1. Memperbaiki potensi crash yang disebabkan oleh kesalahan format terjemahan.

**v1.101.0 (2025/11/29)**

**✨ Fitur**

1. **Filter Item Sintesis**: Memfilter Sintesis berdasarkan Item untuk pencarian dan pengelolaan yang lebih cepat.
2. **Detail Item → Resep Sintesis**: Melihat resep Sintesis Item langsung di halaman detail Item.
3. **Toko → entri Sintesis**: Jika Item dapat digunakan dalam Sintesis, tombol Sintesis kini muncul di samping tombol Beli.
4. **Filter riwayat Inventaris**: Menambahkan filter berdasarkan tanggal, Item, dan deskripsi.
5. **Dialog What's New**: Dialog sorotan versi baru saat peluncuran pertama setelah pembaruan.
6. **Waktu Fokus Pomodoro per Tugas**: Logika Pomodoro direfaktor; mendukung durasi Fokus kustom per Tugas.
7. **Efek penggunaan Item: "Catat Perasaan setelah digunakan"**; halaman Perasaan juga mendukung filter berdasarkan Item.
8. **Broadcast siklus hidup Pomodoro (API)**: Menambahkan event broadcast siklus hidup.
9. **API kueri sederhana**: Kini mendukung pengambilan detail satu Tugas.
10. **Auto-increment Tugas hitungan**: Mendukung penambahan otomatis.
11. **Akhir pengulangan berdasarkan tanggal**: Tugas kini mendukung mengakhiri pengulangan pada tanggal tertentu.
12. **Peningkatan pengaturan widget desktop**: Meningkatkan halaman pengaturan widget desktop di App sehingga setiap widget yang didukung dapat dipratinjau dan, jika sistem mengizinkan, dengan cepat ditambahkan ke layar utama.

**♻️ Optimisasi**

1. **UX manajemen daftar + mode gelap**: Menyempurnakan interaksi dan mode gelap; daftar "Semua" kini menampilkan status hapus yang dinonaktifkan alih-alih aksi yang tidak dapat dihapus.
2. **Halaman pengaturan Toko**: Dipindahkan ke halaman independen dan dapat diakses dari Pengaturan utama.
3. **Latar belakang default Tugas**: Memperjelas wording di dialog bantuan.
4. **Indikator Quick Complete**: Saat diaktifkan, halaman Tugas menampilkan indikator atas status Quick Complete.
5. **Memori lipat per daftar**: Status lipat/buka dicatat per daftar agar "Semua" tidak memengaruhi daftar harian.
6. **Dialog jatuh tempo (mode gelap)**: Meningkatkan gaya mode gelap saat memproses Tugas yang jatuh tempo.
7. **Logika tombol filter Perasaan**: Hanya ditampilkan untuk tipe yang mendukung filter (Item/Tugas).
8. **Alur tim hanya Tugas lokal**: Meningkatkan interaksi saat mengumpulkan hanya Tugas lokal.
9. **Penyempurnaan UI halaman Sintesis**: Menyempurnakan tata letak dan umpan balik visual di halaman Sintesis.
10. **Penyempurnaan interaksi Item**: Menyederhanakan interaksi terkait Item agar lebih responsif.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana bilah filter atas tidak ditampilkan dengan benar setelah memfilter di halaman Riwayat.
2. Memperbaiki masalah di mana Tugas negatif mungkin tidak menghitung denda dengan jumlah denda 1× yang benar dalam kasus tertentu.
3. Memperbaiki masalah di mana pemilih Tugas timer Pomodoro dapat kehilangan opsi "Batalkan pilihan" dalam kondisi tertentu.
4. Memperbaiki beberapa masalah terkait mengikuti pengaturan mode gelap sistem.
5. Memperbaiki popup Hadiah yang hilang saat widget menyelesaikan Tugas hitungan.

**v1.100.6 (2025/11/08)**

**🐛 Perbaikan Bug**

1. Memperbaiki crash saat memilih Item jika fokus input meluap karena keyboard/gamepad eksternal; efektivitas perbaikan sedang diverifikasi.
2. Memperbaiki dialog manajemen zona waktu pintar agar dapat digulir untuk menampilkan konten dan tombol bagian bawah.

**v1.100.5 (2025/09/28)**

**✨ Fitur**

1. **Efek suara kustom kini mendukung pemilihan suara bawaan**: Mengakses perpustakaan efek audio bawaan untuk pengalaman kustomisasi yang lebih nyaman.
2. **Filter Sintesis yang ditingkatkan**: Menambahkan opsi filter "Tampilkan hanya yang dapat disintesis" di halaman Sintesis untuk pengelolaan Item yang lebih baik.
3. **Dukungan emoji API**: API Item, Atribut, dan Pencapaian kini mendukung input emoji langsung untuk kustomisasi yang lebih baik.
4. **Peningkatan pembuatan tim**: Menambahkan kemampuan memilih daftar target saat membuat tim untuk organisasi yang lebih baik.
5. **Penyalinan Tugas tim**: Mendukung menyalin Tugas tim sebagai Tugas lokal tanpa memerlukan keanggotaan tim.
6. **Peningkatan API Tugas**: Menambahkan dukungan parameter untuk mengatur status "font catatan ringan" di API terkait Tugas.

**♻️ Optimisasi**

1. **Logika "buang perubahan" yang ditingkatkan**: Mengoptimalkan dialog konfirmasi buang perubahan untuk pengeditan Item, Sintesis, Pencapaian, dan daftar Pencapaian — kini hanya muncul saat ada perubahan aktual.
2. **Kondisi buka kunci Pencapaian**: Kondisi buka kunci Pencapaian kini diperluas secara default untuk visibilitas yang lebih baik.
3. **Performa Sintesis yang ditingkatkan**: Mengoptimalkan performa kueri untuk halaman detail Sintesis.
4. **Stabilitas API Toast**: Meningkatkan stabilitas dan keandalan panggilan API Toast.
5. **Alur penyelesaian Tugas tim**: Meningkatkan proses penyelesaian Tugas tim dengan penanganan error dan panduan pengguna yang lebih baik.
6. **Perilaku drag Sintesis**: Meningkatkan perilaku scroll drag-ke-tepi saat mengurutkan Item kustom di halaman Sintesis.
7. **Alur pengumpulan Tugas tim**: Meningkatkan alur kerja setelah mengumpulkan Tugas tim dengan dukungan lompat ke daftar terkait.
8. **Optimisasi pengingat kalender**: Meningkatkan logika terkait pengingat kalender untuk keandalan yang lebih baik.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana latar belakang kustom dari versi lama secara keliru menggunakan status default global "font catatan ringan".
2. Memperbaiki masalah adaptasi status bar di halaman efek suara kustom.
3. Memperbaiki deskripsi Pencapaian yang mungkin tumpang tindih dengan tombol buka kunci.
4. Memperbaiki masalah scroll saat drag-sort di halaman detail Sintesis.
5. Memperbaiki hilangnya sesekali tombol pencarian saat modul World ditempatkan di sidebar.
6. Mencoba memperbaiki kelainan mengikuti sistem mode malam.
7. Mencoba memperbaiki masalah di mana penyelesaian Tugas tim berturut-turut dapat menyebabkan duplikasi Tugas.
8. Memperbaiki kegagalan fungsi "Perasaan" saat membuka kunci Pencapaian.

**v1.100.4 (2025/09/07)**

**♻️ Optimisasi**

1. **Peningkatan pelaporan crash**: Meningkatkan pengumpulan dan pelaporan crash untuk analisis masalah dan debugging yang lebih baik.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah crash yang disebabkan oleh Facebook SDK.

**v1.100.3 (2025/09/06)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana pencarian tidak berfungsi saat memilih Item.

**v1.100.2 (2025/09/05)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana **daftar default tidak dapat dipilih** dalam situasi tertentu saat membuat atau mengedit Item di toko.

**v1.100.1 (2025/09/03)**

**✨ Fitur**

1. **Opsi warna font latar belakang kustom**: Menambahkan dukungan opsi warna font catatan kustom, semakin mempersonalisasi pengalaman antarmuka.
2. **Efek penggunaan Item yang ditingkatkan**: Efek pengurangan koin acak kini juga mendukung mengaktifkan fungsi "Batasi Penggunaan".

**♻️ Optimisasi**

1. **Optimisasi fungsi pengingat kalender**: Menambahkan opsi untuk menyesuaikan durasi event pengingat kalender yang disisipkan.
2. **Optimisasi interaksi pengeditan Tugas**: Meningkatkan logika popup "buang perubahan" saat mengedit Tugas — tidak lagi muncul saat keluar tanpa edit.
3. **Pembaruan lokalisasi multi-bahasa**: Memperbarui teks multi-bahasa yang dilokalisasi untuk meningkatkan pengalaman pengguna.

**🐛 Perbaikan Bug**

1. Memperbaiki **halaman konfigurasi kompatibilitas dan halaman pengaturan pengingat** yang tidak beradaptasi ke mode gelap.
2. Mencoba memperbaiki **masalah crash terkait popup dan fokus metode input** di beberapa halaman, meningkatkan stabilitas App.
3. Memperbaiki masalah di mana **mengedit Pencapaian tidak dapat mengubah apakah akan otomatis menggunakan Item**.

**v1.100.0-alpha (2025/07/29)**

**✨ Fitur**

1. **Timer Pomodoro, nilai Poin Pengalaman, riwayat gudang, detail koin** menambahkan fungsi lompat satu ketuk ke halaman statistik terkait.
2. Mendukung pengaturan event pengingat yang lebih fleksibel (X menit sebelum mulai atau batas waktu).
3. Mendukung menyembunyikan daftar Sintesis.
4. Mendukung mengubah Atribut untuk jumlah langkah dan Hadiah ketekunan.
5. Mendukung menyesuaikan modul fungsional sidebar (seperti menempatkan toko, komunitas di sidebar atau menyembunyikan modul yang tidak perlu).
6. Menambahkan opsi eksperimental **"Low Restriction Mode"**: melonggarkan batas numerik dalam App (seperti nilai Poin Pengalaman, digit koin, jumlah Atribut yang dapat dipilih untuk Tugas).
7. Mengoptimalkan UI dan logika interaksi popup pemrosesan jatuh tempo.
8. Menambahkan deskripsi untuk opsi auto-use Item.
9. Dukungan kondisi buka kunci yang lebih dapat diulang:
   - Perolehan pohon pomodoro harian.
   - Waktu Fokus pomodoro harian.
   - Penyelesaian N Tugas berbeda setiap hari.
   - Penggunaan Item tertentu N kali setiap hari.
   - Penyelesaian Tugas tertentu N kali setiap hari.
10. Opsi daftar pintar dipindahkan ke popup manajemen daftar (klik tombol daftar di atas halaman daftar Tugas).
11. Menambahkan opsi **"Quick Complete"**: saat diaktifkan, menyelesaikan Tugas akan melewati semua popup.
12. Memperluas cakupan pengaruh ikon koin kustom, kini mendukung ikon monokrom (seperti ikon koin di atas toko).
13. Detail Item kini mengidentifikasi daftar mana Item tersebut, memudahkan konfirmasi kepemilikan Item dari gudang.
14. Saat mengedit resep Sintesis, mendukung drag-to-sort dan klik-untuk-edit Item.
15. Menambahkan API untuk mengedit angka koin secara langsung.
16. API kueri mendukung kueri informasi pomodoro (jumlah pomodoro).
17. Batas numerik untuk beberapa API dilonggarkan (API default adalah low restriction).
18. **Mendesain ulang dan mengoptimalkan mekanisme perhitungan progres kondisi Pencapaian**: Meningkatkan performa perhitungan dan kecepatan pembaruan progres.

**♻️ Optimisasi**

1. Mengoptimalkan hari ketekunan di halaman **"Saya"**, mendukung klik manual untuk menghitung ulang.
2. Memperbaiki masalah tata letak RTL di halaman kalender, hari awal minggu diatur ke **"Senin"** (sebelumnya Minggu).
3. Tampilan grup dalam daftar pintar Tugas dan toko mendukung lipat/buka berdasarkan label grup.
4. Saat daftar Tugas memperluas selesai, belum dimulai, dibekukan di bawah, label terkait juga muncul di atas.
5. Ikon Item yang diimpor dari modul World disimpan secara persisten secara lokal, menghindari ketidakmampuan memuat saat offline.
6. Popup pemilihan daftar kini mengidentifikasi daftar pintar.
7. Mengoptimalkan logika daftar default untuk Tugas tim dan Tugas acak: saat daftar default diarsipkan, default memilih daftar pertama.
8. Mengoptimalkan logika pemrosesan jatuh tempo untuk Tugas hitungan: jika hitungan tercapai, default ke status **"Selesai"**.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana status checkbox **"auto-use Item"** tidak dapat dipulihkan dengan benar saat mengedit Pencapaian.
2. Memperbaiki masalah penghitungan kartu atas daftar pintar: gagal mengecualikan Tugas yang termasuk daftar yang diarsipkan.
3. Memperbaiki masalah memori global untuk status checkbox **"auto-use"** pembelian Item, diubah menjadi memori independen per Item.
4. Memperbaiki masalah di mana API buka kunci Pencapaian tidak dapat memperbarui progres dengan benar dalam situasi tertentu.
5. Memperbaiki masalah logika daftar default untuk Tugas tim dan Tugas acak.
6. Peningkatan pustaka dependensi teknis, versi API target disesuaikan ke 35 (Android 15).

**Perbaikan Patch Alpha/Beta**

1. Menghapus dependensi yang tidak perlu dan beradaptasi ke ukuran halaman 16K, **mengurangi ukuran paket App**.
2. Memperbaiki logika fungsi **auto-use Item**: Untuk Item URL, kini hanya 1 Item yang akan digunakan dengan sisanya disimpan di gudang. (Sebelumnya hanya 1 yang berlaku tetapi tidak disimpan di gudang, menyebabkan kehilangan efek penggunaan)
3. Memperbaiki masalah di mana **kondisi Pencapaian yang dapat diulang** tidak dapat menghitung ulang progres.
4. Memperbaiki masalah di mana **file cadangan** tidak menyertakan template Tugas.
5. Memperbaiki masalah di mana sebagian besar emoji akan menghasilkan ulang ikon abnormal setelah pemulihan cadangan.
6. Memperbarui **tautan saluran QQ** untuk umpan balik dalam App.
7. Menambahkan fitur **broadcast publikasi Perasaan**.
8. **Mendesain ulang** antarmuka konfigurasi kompatibilitas dan pengaturan metode pengingat.
9. Menambahkan opsi "Batasi penggunaan Item" untuk **efek pengurangan koin**.
10. **Pembaruan terkait API**: Menambahkan dukungan API Tugas untuk parameter pesan motivasi.
11. Memperbaiki masalah spasi atas abnormal di halaman pengaturan default Item baru.

**v1.99.5 (2025/07/29)**

**🐛 Perbaikan Bug**

1. Mencoba memperbaiki masalah di mana latar belakang kustom mungkin tidak ditampilkan dengan benar dalam situasi tertentu.

**v1.99.3 (2025/06/30)**

**✨ Fitur**

1. API subtugas mendukung penyesuaian relatif (set_type).
2. Mendukung pembersihan otomatis event pengingat kalender yang kedaluwarsa.
3. Mengoptimalkan logika pemrosesan daftar yang diarsipkan:

* Daftar pintar tidak lagi menampilkan Tugas yang diarsipkan.
- Tugas dalam daftar yang diarsipkan secara default tidak maju otomatis (mirip status dibekukan).

**♻️ Optimisasi**

1. Saat menambahkan Tugas/Pencapaian secara berkelanjutan, mendukung scroll otomatis ke atas dan fokus ke field input.
2. Mengoptimalkan wording terkait menyelesaikan Tugas negatif.
3. Mengoptimalkan logika tampilan pop-up "Buang Perubahan" di halaman edit Tugas.
4. Mengoptimalkan durasi event untuk pengingat kalender agar menghindari potensi masalah di beberapa perangkat.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana widget tidak mendukung menampilkan ikon koin kustom.
2. Memperbaiki masalah di mana halaman detail Tugas tidak mendukung menampilkan Hadiah multi-Item.
3. Memperbaiki masalah di mana skenario tertentu (mis. widget) mungkin tidak mematuhi aturan pengurutan daftar.

**v1.99.1-rc02 (2025/06/20)**

**✨ Fitur**

1. Mendukung kondisi buka kunci Pencapaian yang dapat diulang untuk "Selesaikan N Tugas berturut-turut".
2. API Buat/Edit Tugas kini mendukung tipe Tugas, dan penyesuaian relatif nilai emas/Poin Pengalaman.
3. API Pencapaian mendukung pengaturan emas, dan penyesuaian relatif emas/Poin Pengalaman.
4. API mendukung lompat ke daftar Pencapaian dan daftar Sintesis tertentu.

**♻️ Optimisasi**

1. Mengoptimalkan urutan catatan riwayat Item gudang yang dihasilkan saat membuka kotak.
2. Opsi filter halaman statistik kini mendukung memori.
3. Opsi halaman filter kini mendukung operasi "Pilih Semua".
4. Memperkuat logika intersepsi deduplikasi untuk pembuatan Tugas.
5. Operasi halaman detail Tugas ditambahkan: bekukan, sesuaikan batas waktu.
6. Mendukung menampilkan ID daftar Sintesis.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana API Tugas sebelumnya tidak dapat membuat/mengedit Tugas Ebbinghaus.
2. Memperbaiki masalah di mana tampilan daftar Tugas dan nama daftar di bilah atas mungkin tidak konsisten saat meluncurkan App dari widget daftar Tugas.
3. Memperbaiki masalah di mana teks di kartu mode sederhana mungkin tidak ditampilkan sepenuhnya.

**v1.99.0 (2025/05/17)**

**✨ Fitur**

1. Menambahkan dukungan untuk tipe Pencapaian yang dapat diulang
2. Menambahkan aksi pengingat notifikasi: selesaikan Tugas, ingatkan nanti  
3. Latar belakang kustom: menambahkan opsi untuk meningkatkan keterbacaan teks
4. Menambahkan dukungan untuk menyesuaikan gaya crop ikon Pencapaian
5. Menambahkan dukungan untuk menyesuaikan tanggal jangkar Tugas bulanan/tahunan

**♻️ Optimisasi**

1. Mengoptimalkan logika perhitungan progres buka kunci Pencapaian
2. Meningkatkan interaksi pemilihan produk
3. Menyesuaikan posisi tombol izin pengingat di layar buat/edit Tugas
4. Mengoptimalkan logika penyimpanan waktu pengingat relatif
5. Mengizinkan membekukan Tugas non-berulang dan berulang tanpa batas

**🐛 Perbaikan Bug**

> Beberapa perbaikan akan diluncurkan secara bertahap ke [Member Stable Version] dan [Official Version]

1. Memperbaiki masalah di mana mengedit Pencapaian mungkin secara tidak sengaja mereset progres kondisi buka kunci API
2. Memperbaiki masalah di mana produk dengan stok 0 masih dapat dibeli via API
3. Memperbaiki masalah di mana daftar yang dihapus dapat dipilih di halaman produk baru dalam kondisi tertentu
4. Memperbaiki masalah di mana template Tugas tidak dapat menyimpan status Hadiah koin otomatis
5. Menghapus animasi transisi halaman detail untuk memperbaiki kegagalan interaksi tekan-lama
6. Memperbaiki masalah di mana Tugas yang dibekukan muncul di pemilihan Tugas Pomodoro
7. Memperbaiki masalah di mana mengedit Tugas melalui metode tertentu akan secara keliru mereset status ke belum selesai
8. Memperbaiki masalah interaksi dengan popup Perasaan

**v1.98.5 (2025/05/01)**

**✨ Fitur**

1. Menambahkan dukungan untuk mengatur tanggal jangkar (mis. akhir bulan) untuk Tugas berulang bulanan dan tahunan.
2. Meningkatkan interaksi multi-pilih untuk produk: default ke mode multi-pilih, dan memulihkan pilihan sebelumnya saat memilih ulang.

**♻️ Optimisasi**

1. Menambahkan dukungan untuk mengingat pengaturan waktu pengingat relatif.
2. Optimisasi UI minor.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana produk masih dapat dibeli via API saat stok toko tidak cukup.
2. Memperbaiki masalah di mana template Tugas gagal memulihkan Hadiah koin otomatis.
3. Memperbaiki kegagalan sesekali tekan-lama pada judul Tugas.
4. Memperbaiki masalah di mana produk baru dapat memilih daftar yang dihapus dalam kondisi tertentu.
5. Memperbaiki tombol hapus yang hilang di field waktu pengingat saat mengedit Tugas.

**v1.98.4 (2025/04/14)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana bilah progres mungkin tidak diperbarui segera setelah menyelesaikan subtugas di halaman detail Tugas.  
2. Memperbaiki masalah di mana mengedit Tugas yang selesai dapat secara keliru mengembalikan statusnya ke "belum selesai."  
3. Memperbaiki masalah di mana mengubah status Tugas yang jatuh tempo mungkin secara keliru memengaruhi jumlah penyelesaian target.  
4. Memperbaiki masalah di mana logika pemilihan Tugas Pomodoro secara keliru menampilkan Tugas yang dibekukan dan daftar yang diarsipkan.  

**v1.98.3 (2025/02/16)**

**♻️ Optimisasi**

1. Menambahkan peringatan saat menggunakan metode pengingat notifikasi default dan tidak memiliki izin "exact alarm".

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana API "selesaikan Tugas" tidak berfungsi saat field UI bernilai true.
2. Memperbaiki masalah di mana pembelian dan penggunaan jumlah tertentu Item mungkin tidak berfungsi dengan benar (mis. 10).
3. Memperbaiki masalah di mana halaman Perasaan mungkin menampilkan "loading" tanpa batas dalam skenario tertentu.

**v1.98.2 (2025/02/06)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana, saat menggunakan Item yang mengurangi Poin Pengalaman, mungkin Poin Pengalaman tidak cukup meskipun sebenarnya cukup.
2. Memperbaiki masalah di mana mengedit Item setelah menyalinnya dapat menghasilkan efek penggunaan duplikat abnormal.
3. Memperbaiki masalah di mana memanggil API "adjust item" dapat menghasilkan batas pembelian abnormal.
4. Memperbaiki masalah di mana memodifikasi catatan tomato tertentu dapat menghasilkan pengurangan jumlah tomato abnormal.

**v1.98.1 (2025/01/14)**

**Perbaikan Bug**

1. Mencoba memperbaiki masalah otorisasi login Google, di mana data untuk sejumlah akun terbatas tidak dapat diotorisasi dan diurai dengan benar.

**v1.98.0 (2025/01/01)**

**✨ Fitur**

1. Mengintegrasikan login Google dan otorisasi Drive menggunakan Credential Manager.
2. Mendukung memilih Emoji sebagai ikon.
3. Menambahkan ContentProvider Query API: fungsionalitas Sintesis.
4. Menambahkan ContentProvider Query API: fungsionalitas catatan Tomato.
5. Menambahkan ContentProvider Query API: Dukungan pengembalian multi-Item.
6. Menambahkan API tomato (sesuaikan jumlah tomato).
7. Menambahkan API export_backup (ekspor cadangan).
8. Menambahkan API purchase_item (beli Item).
9. Menambahkan API synthesize (picu Sintesis).
10. Menambahkan API subtask (buat atau sesuaikan subtugas).
11. Menambahkan API subtask_operation (operasikan subtugas, mis. selesaikan).
12. Menambahkan API synthesis_formula (formula Sintesis).
13. Menambahkan API edit_task (edit Tugas).
14. Menambahkan API category (buat atau sesuaikan daftar).
15. Menambahkan API history_operation (sesuaikan riwayat).
16. Menambahkan API AppSettingsScheme (sesuaikan beberapa pengaturan App).
17. Menambahkan API achievement (buat atau edit Pencapaian).
18. Menambahkan API skill (buat atau edit Atribut).
19. Menambahkan dukungan menampilkan subtask id dan gid.
20. Menambahkan dukungan menampilkan synthesis id.
21. Menambahkan dukungan kueri creditLimit.
22. API ContentProvider mendukung kueri subtugas (id, gid).
23. API ContentProvider kueri Item: Menambahkan pengembalian field "jumlah maksimum yang dapat dibeli".
24. API ContentProvider Shop mendukung kueri Item berdasarkan daftar id tertentu.
25. Mengoptimalkan nilai kembalian saat mengkueri URL ContentProvider yang salah.
26. Antarmuka kueri mendukung kueri Pencapaian tunggal.

**♻️ Optimisasi**

1. Mengoptimalkan pengurutan kustom default untuk Item yang baru ditambahkan.
2. Mengoptimalkan pengurutan kustom default untuk Atribut yang baru ditambahkan.
3. Menambahkan parameter `purchase_limit`, `disable_use`, dan `effects` ke API "add_item".
4. Menambahkan parameter `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time`, dan `pin` ke API "add_task".
5. Menambahkan dukungan frekuensi Tugas lebih banyak ke API "add_task".
6. Menambahkan dukungan parameter `effects` dan `purchase_limit` ke API "item".
7. Menambahkan dukungan menghentikan operasi di API sebelumnya (mis. input).
8. Menambahkan dukungan menentukan parameter `signed` untuk placeholder numerik.
9. Menambahkan placeholder angka acak dan desimal acak.

**v1.97.3 (2024/12/16)**

**✨ Fitur**

1. Mendukung mengingat pilihan terakhir sakelar "Gunakan deskripsi tim sebagai catatan Tugas".

**♻️ Optimisasi**

1. Mengoptimalkan performa terkait efek penggunaan produk.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah kegagalan pemanggilan API tertentu. Saat menggunakan fungsi callback tertentu untuk memanggil API produk, fungsi unpacking berjalan normal, tetapi operasi API internal untuk menambahkan Item tidak dapat dieksekusi.

**1.97.2 (2024/12/08)**

**✨ Fitur**

1. Menambahkan pembuatan Tugas otomatis menggunakan mekanisme WorkManager sistem untuk mencegah Tugas tidak terbuat saat widget tidak digunakan dan App belum dibuka lebih dari sehari.
2. Meningkatkan penanganan pengecualian API dengan mengembalikan field success terpadu dan meneruskan informasi pengecualian ke antarmuka content provider.

**♻️ Optimisasi**

1. Mengoptimalkan logika pembuatan waktu default untuk meningkatkan akurasi pembuatan waktu bulanan dan tahunan.
2. Mengoptimalkan logika penghapusan file gambar yang tidak digunakan dengan menambahkan langkah verifikasi sekunder dari database untuk mencegah penghapusan file secara tidak sengaja.

**🐛 Perbaikan Bug**

1. Meningkatkan pesan error API saat entitas tidak ditemukan.
2. Memperbaiki masalah konkurensi pada downloader bawaan.
3. Memperbaiki logika statistik Pomodoro untuk skenario lintas hari, menyatukan atribusi catatan ke periode waktu waktu selesai (sebelumnya catatan lintas hari tidak dapat diatribusikan dengan benar ke periode waktu hari tersebut).
4. Memperbaiki masalah di mana kontinuitas Tugas dan jumlah penyelesaian periode waktu dapat salah dalam skenario tertentu.

**1.97.1 (2024/11/20)**

**✨ Fitur**

1. Memperbarui terjemahan.
2. Mendukung tampilan otomatis Hadiah multi-Item di catatan.

**♻️ Optimisasi**

1. Mengoptimalkan penanganan permintaan jaringan untuk mengurangi permintaan HTTP yang tidak perlu dan meningkatkan performa.
2. Mengoptimalkan tampilan Level di halaman status, meningkatkan pengalaman visual dan efisiensi penyampaian informasi.

**🐛 Perbaikan Bug**

1. Memperbaiki warna teks jumlah subtugas.
2. Memperbaiki kesalahan perhitungan waktu untuk Tugas bulanan dan tahunan, memastikan waktu pemicu Tugas akurat.
3. Memperbaiki masalah perhitungan waktu untuk subtugas bulanan dan tahunan, memastikan semua subtugas dijadwalkan dengan akurat.
4. Memperbaiki masalah di mana latar belakang Tugas tidak dapat dipulihkan dengan benar saat memulihkan dari template Tugas, memastikan pengaturan latar belakang Tugas diterapkan dengan benar.

**1.97.0 (2024/10/21)**

**♻️ Optimisasi**

1. Mengoptimalkan efek tampilan kartu Tugas untuk Tugas yang belum dimulai.
2. Menangani beberapa masalah performa.
3. Mengoptimalkan halaman detail Tugas, menyelesaikan masalah di mana mengetuk nama Tugas sesekali gagal memicu interaksi.

**✨ Fitur**

1. Menambahkan field format JSON ke broadcast API untuk Tugas jatuh tempo.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana mengaktifkan Material 3 menyebabkan crash saat mengeksekusi API terkait UI tertentu.
2. Menghapus beberapa opsi eksperimental usang, seperti sakelar Perasaan dan sakelar Atribut baru.

**🎉1.97.0-rc (2024/09/11)**

**✨ Fitur**

**Pembaruan Utama**

- Pembaruan ini terutama berfokus pada optimisasi performa dan perbaikan bug.
- Mengoptimalkan performa App secara signifikan. Mengambil daftar Tugas dan melakukan berbagai operasi kini lebih mulus. Target versi Android API diperbarui ke Android 14.

**Lainnya**

1. Saat koin tidak cukup, tombol pembelian Item kini tampil dinonaktifkan.
2. Menambahkan kemampuan mencari Pencapaian berdasarkan nama di daftar Pencapaian 🔍.
3. Menambahkan dukungan pengaturan ukuran font di dalam App.
4. Mengoptimalkan logika acak untuk Dunia - Tugas Acak, kini mengurangi frekuensi batch Tugas terbaru muncul, sehingga lebih acak.
5. Mengoptimalkan logika pengelompokan notifikasi, kini notifikasi seperti buka kunci Atribut dan Pencapaian seharusnya terkelompok dengan benar.
6. Statistik - Bagikan kini mendukung mengalihkan tampilan kode QR.

**♻️ Optimisasi**

1. Mengoptimalkan logika akses jaringan.
2. Menambahkan efek blur latar belakang pada popup.
3. Mengoptimalkan tombol di halaman Toko, gudang, dan etalase, kini menggunakan gaya tombol Material resmi.
4. Content Provider API untuk mengkueri catatan riwayat Tugas kini mengembalikan waktu selesai Tugas.
5. Content Provider API untuk mengkueri catatan riwayat Tugas kini mendukung filter berdasarkan Group Id Tugas.
6. Memperbarui versi banyak dependensi.
7. Goto API kini mendukung navigasi ke halaman "Pengaturan Default Item Baru".
8. Saat menavigasi ke halaman "Buat Pencapaian" via Goto API, parameter category_id kini wajib.
9. Menambahkan panduan dalam App untuk efek tautan Tugas, Tugas penghitung, dan Item di API.
10. Mengoptimalkan logika dan pesan error untuk pengguna baru memeriksa pembaruan.
11. Menambahkan pesan loading dan error untuk operasi penghapusan akun.
12. Mengoptimalkan area dapat diklik untuk menyelesaikan Tugas utama di halaman detail Tugas.
13. Meningkatkan pesan error saat mengimpor cadangan, kini lebih ketat mencegah impor file cadangan tidak valid.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana, saat membuat Tugas baru, jika pesan error untuk konten Tugas kosong dipicu terlebih dahulu, pesan error tidak hilang otomatis meskipun teks sudah dimasukkan.
2. Memperbaiki masalah di mana tombol filter tidak ditampilkan di halaman Statistik saat menggunakan mode navigasi bawah.
3. Memperbaiki masalah tata letak pada perangkat layar kecil tertentu dengan rasio aspek sempit.
4. Memperbaiki masalah di mana Hadiah subtugas mungkin terhubung secara abnormal saat menyalin Tugas (masalah ini terjadi sejak versi 1.96.0).
5. Memperbaiki pesan error yang disebabkan koneksi Dropbox abnormal saat cadangan Dropbox otomatis.
6. Mencoba memperbaiki konsumsi memori dan masalah crash saat pratinjau gambar sangat besar.
7. Memperbaiki masalah di mana, setelah membeli Item dan menandai untuk digunakan, data widget tidak diperbarui dengan benar jika penggunaan gagal.
8. Memperbaiki masalah di mana mengedit Pencapaian mengubah waktu penyelesaian Pencapaian dan dapat secara keliru memicu notifikasi buka kunci Pencapaian.
9. Memperbaiki masalah di mana, dalam mode split-screen di layar besar, saat menampilkan halaman daftar Tugas dan detail bersamaan, menyelesaikan Tugas, subtugas, atau memperbarui penghitung tidak menyinkronkan kedua halaman.
10. Memperbaiki masalah di mana menekan lama Tugas tunggal jatuh tempo di halaman daftar Tugas tidak memungkinkan menghapus tampilan batas waktu.

**1.96.1(2024/07/11)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana jumlah Item Hadiah yang ditampilkan salah saat menyelesaikan subtugas (Hadiah aktual tidak terpengaruh).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Fitur**

**Pembaruan Utama**

1. Saat menyelesaikan Tugas atau membuka kunci Pencapaian, Item kini dapat digunakan langsung untuk memicu efek Item.
2. Batas jumlah Item yang digunakan sekaligus kini dilonggarkan menjadi 1000.
3. Pembelian Kotak Jarahan atau Item Sintesis kini juga mendukung penggunaan langsung (buka/sintesis).
4. Tugas tim kini mendukung memposting Perasaan ke Perasaan lokal.
5. URL Scheme pihak ketiga di catatan Tugas kini didukung untuk parsing dan navigasi langsung.
6. Halaman Riwayat kini mendukung pencarian catatan historis berdasarkan catatan Tugas.
7. Menambahkan dukungan penghitungan waktu untuk Tugas historis.
8. Halaman Statistik kini mendukung filter berdasarkan kategori utama.
9. Merefaktor popup Hadiah dan penalti Poin Pengalaman Atribut: mengoptimalkan logika batas seleksi Atribut penggunaan Item, dan memisahkan popup pengurangan Poin Pengalaman Atribut jatuh tempo.

**♻️ Optimisasi**

1. Efek UI seleksi tunggal saat memilih Item kini konsisten dengan multi-seleksi.
2. Mengoptimalkan kecepatan loading daftar Tugas.
3. Saat menambah atau mengedit Tugas, waktu jatuh tempo tidak lagi wajib setelah waktu saat ini, memberikan fleksibilitas untuk membuat catatan historis.
4. Jika menampilkan ID data diaktifkan, popup Perasaan kini juga menampilkan ID terkait.
5. Mengoptimalkan masalah performa terkait popup pemrosesan jatuh tempo.
6. Menyatukan urutan tombol untuk penghitungan waktu mundur dan status jeda.
7. Interaksi menghapus posting di halaman Modul Dunia - Profil Pribadi kini lebih intuitif.
8. Mengoptimalkan efek loading untuk halaman Perasaan dan Pencapaian.

**🐛 Perbaikan Bug**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Fitur**

**Pembaruan Utama**

1. Mendukung tampilan split-screen dalam App di perangkat layar besar seperti tablet dan layar lipat

**♻️ Optimisasi**

1. Widget Toko dan Gudang kini mendukung efek crop gambar dalam App yang konsisten
2. Di halaman statistik, saat hanya satu hari dipilih, grafik garis kini didukung

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana tipe Tugas ditampilkan salah saat mengedit Tugas API
2. Memperbaiki masalah statistik penyelesaian, pengabaian, dan jatuh tempo Tugas yang abnormal di halaman statistik

**1.94.3 (2024/05/10)**

**♻️ Optimisasi**

1. Widget kini mencoba memperbarui tema untuk beradaptasi saat mode gelap sistem berubah
2. Saat modul "Dunia" disembunyikan, notifikasi titik merah untuk Pencapaian sistem tidak lagi menghitung data terkait modul "Dunia"

**🐛 Perbaikan Bug**

1. Memperbaiki masalah crash probabilitas rendah saat multi-seleksi Item
2. Memperbaiki masalah crash probabilitas rendah terkait jendela pop-up
3. Memperbaiki masalah di mana widget gudang mungkin tidak diperbarui saat memanggil API modifikasi Item
4. Memperbaiki masalah di mana widget gudang dapat menggunakan Item "tidak dapat digunakan"

**1.94.2 (2024/04/26)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah perhitungan jumlah saat ini Tugas yang abnormal (yang menyebabkan progres tidak akurat untuk Tugas dengan target jumlah pengulangan)
   - Perbaikan ini mengembalikan optimisasi sebelumnya terkait performa membatalkan Tugas, menunggu solusi yang lebih masuk akal di masa depan

**1.94.1 (2024/04/22)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana jumlah Pomodoro dihitung satu kurang dari aktual saat menggunakan stopwatch, menambah waktu via API, atau menambahkan catatan waktu secara manual.
2. Memperbaiki glitch di mana bilah seleksi mungkin berkedip dan hilang setelah memilih Item di halaman toko/Inventaris lalu menggulir.

**🎉1.94.0 (2024/04/22)**

**Pembaruan Utama**

1. Mendukung Hadiah multi-Item
2. Widget Inventaris

**Tema UI**

1. Warna kustom (teks Tugas, Item) kini mencakup lebih banyak nilai preset
2. Diadaptasi untuk fitur ikon adaptif monokrom Android 14
3. Menambahkan banyak adaptasi bahasa (versi Google Play)

**Pencapaian**

1. Jika ada Pencapaian dengan Hadiah belum diklaim, titik merah kecil kini ditampilkan di daftar Pencapaian.

**Tugas**

1. Subtugas untuk Tugas penalti kini mengeksekusi logika penalti dengan benar
2. Menambahkan "Manajemen Zona Waktu Cerdas"; jika Anda terlibat pekerjaan lintas zona waktu, LifeUp juga mendukung deteksi otomatis perubahan zona waktu dan penyesuaian waktu global
3. Dasar statistik di halaman detail kini mengingat pilihan terakhir, dan kami mengoptimalkan beberapa nilai default dalam skenario tertentu
4. Mengoptimalkan penanganan grace untuk hari penyelesaian Tugas berkelanjutan di halaman "Saya", kini jika Anda lupa menyelesaikan Tugas satu hari, mengejar tetap dapat melanjutkan streak

**Atribut**

1. Mendukung menghapus catatan Poin Pengalaman
2. Mendukung mereset Poin Pengalaman Atribut individual

**Widget**

1. Kini, mengetuk ruang kosong di widget toko atau Inventaris langsung masuk ke daftar yang ditunjuk widget, bukan daftar terakhir
2. Widget Tugas kini menampilkan progres Tugas penghitung

**API**

1. Menambahkan API untuk mengedit catatan Pomodoro
2. API menyelesaikan Tugas kini juga menangani Tugas penalti dengan benar
3. API menyelesaikan Tugas kini juga mendukung pemrosesan Tugas penghitung (menambahkan parameter `count`)
4. API menyelesaikan Tugas kini mendukung parameter koefisien Hadiah
5. API menyesuaikan Item kini mendukung mengubah id daftar Item
6. API membuat dan menyesuaikan Item mendukung parameter kriteria pengurutan
7. Jump API kini mendukung lompat ke popup gunakan Item
8. Menyatukan beberapa definisi parameter, seperti `itemId` → `item_id`
9. Menambahkan broadcast notifikasi untuk memulai, menjeda, dan mengakhiri stopwatch
10. API menyesuaikan Item `title_color_string` kini mendukung meneruskan string kosong untuk memulihkan nilai default
11. Broadcast menyelesaikan Tugas kini mencakup id daftar
12. Membuka kotak, crafting kini juga memicu broadcast gunakan Item

**♻️ Optimisasi**

1. Menambah atau mengedit Tugas kini menyertakan peringatan jika tidak ada Atribut dipilih dan Poin Pengalaman dimasukkan
2. Mengoptimalkan catatan unggah ulang
3. Mengoptimalkan tampilan judul dan batasan input di halaman Level kustom
4. Mengoptimalkan performa dan masalah waktu membatalkan Tugas yang telah diulang secara ekstensif
5. Merefaktor popup gunakan Item, logika antarmuka kalender, dll.
6. Mengoptimalkan logika terkait pengingat Tugas, memastikan pengingat dari data yang dihapus atau sebelumnya tidak dikirim lagi
7. Mengoptimalkan teks menunggu di antarmuka cadangan
8. Gambar yang dipilih di halaman Atribut kustom kini juga ditambahkan ke seleksi riwayat
9. Mengedit catatan Pomodoro kini mencoba mengoreksi (menambah atau mengurangi) jumlah Pomodoro yang tepat

**🐛 Perbaikan Bug**

1. Memperbaiki Pencapaian sistem terkait statistik dan cadangan yang tidak terpicu normal setelah restrukturisasi
2. Memperbaiki potensi konflik antara API random dan widget API toast dengan toast default
3. Memperbaiki detail Tugas tidak diperbarui dalam beberapa skenario saat masuk dari widget
4. Memperbaiki potensi error dalam pembukaan kotak ganda dalam situasi khusus tertentu (menggunakan persediaan Item lebih dulu)
5. Memperbaiki masalah tidak menampilkan subtugas di halaman detail setelah mengedit Tugas tanpa subtugas dan menambahkan yang baru
6. Memperbaiki beberapa kasus khusus di mana mengedit Hadiah koin tidak memungkinkan
7. Memperbaiki beberapa kasus di mana klaim Item tim mungkin tidak berfungsi
8. Memperbaiki anomali gaya MD2 di beberapa popup bawah
9. Memperbaiki potensi nilai waktu tambahan yang salah pada timer Pomodoro
10. Memperbaiki masalah di mana bilah warna di widget perubahan Poin Pengalaman mungkin tidak ditampilkan
11. Memperbaiki beberapa Tugas tidak ditampilkan dengan benar di kalender-dalam-proses
12. Memperbaiki beberapa masalah loading daftar di halaman riwayat, Perasaan
13. Memperbaiki masalah di mana memanggil API selesaikan Tugas dua kali berturut-turut dengan cepat tidak memungkinkan dua penyelesaian berurutan

**1.93.3 (2024/01/09)**

**✨ Fitur**

1. Menambahkan API [Perasaan].

**♻️ Optimisasi**

1. Perhitungan indikator nilai rata-rata di halaman statistik kini mengecualikan tanggal mendatang.
2. Setelah menyembunyikan daftar Pencapaian sistem, tidak ada lagi peringatan untuk buka kunci Pencapaian sistem.
3. Memperbarui API `goto` agar tidak lagi mendukung pop-up untuk membeli Item "tidak dapat dibeli".
4. Mengoptimalkan pengeditan Tugas untuk menyelesaikan masalah input jumlah pengulangan target tertutup.

**🐛 Perbaikan Bug**

1. Memperbaiki efek UI edge-to-edge di halaman Atribut kustom.
2. Memperbaiki masalah di mana penalti tidak dicabut jika Tugas disetel dibatalkan lalu diselesaikan di halaman riwayat/kalender.
3. Memperbaiki masalah gaya tampilan popup bawah dan bilah navigasi sistem bawah dalam mode Material2.
4. Memperbaiki warna border kotak input to-do yang salah dalam mode malam.
5. Memperbaiki masalah tampilan yang dapat terjadi setelah rotasi layar saat menggunakan mode navigasi sistem tiga tombol.

**1.93.3 (2023/12/02)**

**♻️ Optimisasi**

1. Menambahkan parameter debug secara terpadu ke API untuk memudahkan debugging

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana memilih "Abaikan pop-up pengingat" tidak efektif
2. Memperbaiki masalah mengedit Perasaan yang dibuat langsung di halaman Perasaan
3. Memperbaiki masalah di mana mengunggah foto dinamis tim mengizinkan memilih hingga 9 gambar, padahal batas sebenarnya 3
4. Memperbaiki masalah di mana API use_item tidak memicu efek countdown atau URL saat ui disetel false
5. Memperbaiki masalah di mana menggunakan Item di widget toko mungkin memicu efek dua kali

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Optimisasi**

1. Mengoptimalkan logika upgrade database untuk menghindari penundaan proses upgrade database
2. Mengoptimalkan nilai default "Waktu Mulai" saat mengedit Tugas

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana mengedit API produk menyebabkan hilangnya efek penggunaan produk
2. Memperbaiki masalah di mana Tugas jatuh tempo dan dibatalkan yang disetel status selesai tidak memulihkan Hadiah
3. Memperbaiki masalah pengurutan Tugas kustom yang tidak sesuai harapan
4. Memperbaiki masalah tampilan dan pengurutan terkait Tugas tunggal jatuh tempo
5. Memperbaiki masalah pengecualian SQL saat memfilter halaman riwayat
6. Memperbaiki masalah dalam mode sederhana di mana mengetuk judul Tugas lagi tidak merespons
7. Memperbaiki masalah di mana mengganti nama template Tugas tidak berlaku

**🎉1.93.0 (2023/10/24)**

**✨ Fitur**

**Tema UI**

1. Sepenuhnya diadaptasi ke Material Design 3.
2. Mendukung kustomisasi warna tema Material Design 3, termasuk warna kustom, warna dari wallpaper, dan warna dari gambar.
3. Meningkatkan beberapa efek animasi, seperti pop-up.
4. Mengoptimalkan efek adaptasi edge-to-edge (immersive).

**Tugas**

1. Mendukung template Tugas.
2. Statistik di halaman detail mendukung beralih berdasarkan kriteria waktu dan mengoptimalkan opsi default.
3. Halaman riwayat mendukung pencarian nama Tugas dan menyesuaikan UI serta interaksi terkait.

**Pencapaian**

1. Mendukung Pencapaian rahasia.
2. Saat menambahkan Pencapaian, mendukung "Lanjutkan Menambahkan Pencapaian Berikutnya."

**Atribut**

1. Mendukung menyembunyikan Atribut.

**Timer Pomodoro**

1. Mendukung mengedit catatan waktu.
2. Di halaman Pomodoro, mendukung penyelesaian Tugas (tekan lama pada Tugas terpilih saat mode jeda).

**Perasaan**

1. Mendukung menambahkan Perasaan langsung di halaman Perasaan.

**API**

1. Menambahkan API "use_item".
2. Menambahkan API "random".
3. Menambahkan API "edit_exp".
4. API "item" kini mendukung menyesuaikan parameter seperti "action_text," "disable_use," dan "title_color_string."
5. API "shop_settings" mendukung parameter "silent".
6. Mendukung placeholder "time". Kini Anda dapat mengatur Tugas dengan tanggal seperti "jatuh tempo besok" atau "jatuh tempo bulan depan" tanpa alat otomatisasi.

**♻️ Optimisasi**

1. Menambahkan awalan ke beberapa tempat yang menampilkan ID data.
2. Mengoptimalkan tampilan aktivitas tim.
3. Mencoba menangani masalah di mana beberapa notifikasi Toast terlalu panjang untuk ditampilkan sepenuhnya.
4. Meningkatkan logika penyelesaian widget di tim, memastikan konsistensi dengan perilaku dalam App.
5. Halaman statistik: Setelah memilih rentang waktu "Kustom", mengetuk "Kustom" lagi kini memicu pemilihan ulang tanggal.
6. Memastikan kompatibilitas dengan Harmony OS 4 agar notifikasi progress bar menampilkan tombol aksi.
7. Meningkatkan logika interaksi permintaan notifikasi.
8. Menangani masalah di mana metode input dapat menghalangi input "Jumlah Pengulangan."
9. Kini, saat membuat Tugas, pilihan pengguna untuk waktu mulai non-spesifik (seperti otomatis atau jatuh tempo hari ini) dicatat. Saat mengedit, opsi ini dipulihkan, bukan waktu spesifik, untuk menghindari perbedaan waktu yang diedit.
10. Saat membuat Tugas, jika peringatan duplikat tak terduga terjadi, kini juga ditampilkan di pop-up "Periksa Duplikat."
11. Menambahkan dukungan bahasa Indonesia.
12. Memperbarui terjemahan.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana, dalam kasus tertentu, modul dunia dapat macet loading (berputar tanpa batas).
2. Memperbaiki masalah di mana, dalam kasus tertentu, toko/gudang terus menampilkan loading (berputar tanpa batas).
3. Memperbaiki masalah yang dapat terjadi saat memanggil API dengan konten UI via content provider.
4. Memperbaiki masalah pengurutan Tugas yang tidak sesuai harapan.
5. Memperbaiki masalah di mana data di halaman statistik salah setelah memilih rentang waktu "Kustom".
6. Memperbaiki masalah di mana pop-up permintaan notifikasi tidak mendukung scroll.
7. Memperbaiki masalah di mana, dalam kasus tertentu, pencarian modul dunia menampilkan semua konten.
8. Memperbaiki masalah di mana opsi "Tampilkan Selesai" juga menampilkan Tugas dibekukan.
9. Memperbaiki masalah perhitungan nilai rata-rata di halaman statistik.

**1.92.2 (2023/08/29)**

**✨ Fitur**

1. Grafik statistik langkah (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Optimisasi**

1. Halaman tim baru kini menambahkan pengingat jumlah kata saat ini dan batas maksimum kata

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana "LifeUp" mungkin berulang kali membuat akun pengingat kalender dalam kondisi khusus tertentu
2. Memperbaiki masalah di mana tombol menu tim yang diedit tidak ditampilkan dengan benar
3. Memperbaiki masalah di mana Pomodoro mungkin tidak memicu pengingat getar dalam mode mulai penghitungan waktu otomatis
4. Memperbaiki masalah di mana notifikasi Pomodoro mungkin secara keliru menampilkan Item Fokus saat tidak ada Item Fokus yang dipilih

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimisasi**

1. Durasi di halaman status dan halaman statistik kini dapat ditampilkan dalam format "XX hari XX jam XX menit."

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana interaksi menutup popup izin notifikasi tidak sesuai harapan di Android 12 dan versi lebih baru.
2. Memperbaiki masalah di mana grafik pai Atribut mungkin ditampilkan sebagai warna transparan, sehingga tidak muncul.

**1.92.1-rc01 (2023/08/13)**

> Tanggal rilis closed beta keanggotaan

**✨ Fitur**

1. Versi statistik baru mengintegrasikan kartu statistik dari versi lama, kini digabung ke satu halaman dan diadaptasi ke mode bilah navigasi bawah.

2. Meningkatkan mekanisme pembaruan dalam App dan fungsi pengingat.

   Kini mendukung tiga saluran pembaruan: Stable Release, Stable Version of Membership Closed Beta, dan Experimental Version of Membership Closed Beta, untuk fokus pada pembaruan berikutnya bagi anggota closed beta.

3. TargetSdkVersion kini diadaptasi untuk Android 13 dan permintaan izin notifikasi dinamis.

4. Mendesain ulang halaman edit profil.

5. Versi GP mengoptimalkan proses dan instruksi pemilihan mode login/offline.

**♻️ Optimisasi**

1. Pemeliharaan dan pembaruan dependensi teknis terkait.
2. Meningkatkan adaptasi WSA dan instruksi login.
3. Saat cadangan gagal, kini akan menampilkan popup yang menjelaskan alasan kegagalan, menghindari masalah tampilan toast yang tidak lengkap.

**🐛 Perbaikan Bug**

1. Memperbaiki potensi masalah crash overflow perhitungan di halaman catatan riwayat koin.
2. Memperbaiki kemungkinan masalah menu di halaman detail tim yang tidak selaras dengan izin yang diharapkan.
3. Mencoba memperbaiki masalah deviasi waktu pada timer countdown.
4. Memperbaiki interupsi proses penyelesaian Tugas dan hilangnya popup penulisan refleksi yang disebabkan rotasi layar.

**1.92.0-rc02 (2023/07/16)**

**🐛 Perbaikan**

1. Memperbaiki masalah di mana widget toko mungkin tidak berfungsi saat melompat ke App lain (mengeksekusi API)
2. Memperbaiki kelainan sesekali saat beralih daftar di widget toko
3. Memperbaiki masalah di mana widget toko tidak menyembunyikan Item habis terjual atau tidak dapat dibeli sesuai pengaturan App
4. Memperbaiki masalah di mana widget toko mungkin tidak merespons saat mengetuk Item tertentu
5. Memperbaiki beberapa masalah crash langka

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Fitur**

1. Statistik 2.0
2. Kartu bagikan

**♻️ Optimisasi**

1. Kini Anda dapat mengatur harga untuk Item "tidak dapat dibeli" dan menggunakannya untuk skenario seperti retur
2. Saat Anda mematikan "Atur penalti Tugas secara terpisah" di pengaturan, tombol penalti tidak lagi ditampilkan
3. Mengoptimalkan UI subtugas di detail tim
4. Mengoptimalkan UI kesan

**🐛 Perbaikan**

1. Memperbaiki masalah di mana saat gaya crop Atribut diubah ke "rounded rectangle", ikon edit mungkin menampilkan ikon lama dalam waktu lama

**1.91.3-rc04 (2023/06/07)**

**♻️ Optimisasi**

1. API untuk lompat ke detail Tugas kini mendukung parameter task_gid dan task_name
2. Content Provider mendukung URL ikon remote produk
   - Untuk memperbaiki masalah di mana beberapa ikon produk tidak dapat ditampilkan dengan benar di desktop di masa depan

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana widget daftar toko tidak menampilkan koin saat ini dengan benar

**1.91.3 (2023/06/03)**

**✨ Fitur**

1. Widget daftar Item toko (versi besar dan kecil)
2. Widget perubahan hari ini untuk Poin Pengalaman
3. Menambahkan API untuk lompat ke detail Tugas
4. Perasaan: kini mendukung pengurutan urutan positif waktu, dan menambahkan tampilan tahun

**♻️ Optimisasi**

1. Kini didukung mengatur harga untuk Item "tidak dapat dibeli" dan menggunakannya dalam skenario seperti retur
2. Saat "pengaturan penalti Tugas independen" dimatikan di pengaturan, tombol penalti tidak lagi ditampilkan
3. Mengoptimalkan UI tampilan subtugas di detail tim
4. Mengoptimalkan UI tampilan kesan

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana jika Anda menghapus kata motivasi saat mengedit Tugas, Anda tidak dapat mengetuk "Konfirmasi" untuk menutup jendela pop-up
2. Memperbaiki masalah di mana Tugas dibekukan tidak dapat dicari menggunakan API
3. Memperbaiki masalah di mana toko dan gudang tidak dapat menyembunyikan daftar default

**1.91.2 (2023/05/09)**

**✨ Fitur**

1. Daftar toko dan Inventaris mendukung pengaturan sembunyikan secara terpisah
2. API `Goto` kini mendukung lompat ke subhalaman halaman utama (seperti Tugas, status, toko, Inventaris)
3. Statistik koin di statistik kini mendukung pengecualian konsumsi pembelian

**♻️ Optimisasi**

1. Saat membuat Pencapaian baru atau mengedit Pencapaian terkunci, tombol "Reset" tidak lagi ditampilkan
2. Widget koin kini mendukung ketukan untuk lompat ke toko
3. Saat efek suara gagal diputar, pesan error yang jelas akan ditampilkan

**🐛 Perbaikan Bug**

1. Saat menambahkan catatan Tomato, jika waktu selesai disetel langsung, durasi yang diharapkan mungkin tidak terpenuhi
2. Setelah memperbaiki label filter Tugas, masalah metode input akan muncul
3. Memperbaiki masalah di mana bunga ATM tidak mendukung pengaturan nilai absolut melalui API
4. Memperbaiki masalah loading data abnormal di halaman riwayat
5. Memperbaiki masalah di mana saat widget menyelesaikan Tugas penghitung, mengetuk "Batal" akan macet di halaman transparan
6. Memperbaiki masalah di mana halaman statistik tidak dapat diperbarui otomatis saat dalam mode bilah navigasi bawah
7. Memperbaiki masalah di mana pengumpulan Tugas tim abnormal saat berada di zona waktu GMT +-x.5

**1.91.1 (2023/03/27)**

**✨ Fitur**

1. Menambahkan opsi "Manajemen Notifikasi" ke Pengaturan.
2. API Tugas Baru kini mendukung pengaturan latar belakang.
3. Menambahkan event broadcast API terkait countdown produk ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Optimisasi**

1. Pop-up umpan balik tidak lagi menutup otomatis saat diklik di luar.
2. Widget tidak lagi memaksa penyelesaian Tugas yang belum dimulai.
3. API penyelesaian Tugas tidak lagi memaksa penyelesaian Tugas yang belum dimulai saat parameter "ui" disetel true.
4. Saat pengaturan koefisien penalti Tugas individual dimatikan, koefisien penalti Tugas yang sebelumnya disetel diabaikan dan nilai global digunakan.
5. Secara otomatis menghapus spasi dari URL yang dimasukkan pengguna.
6. Saat opsi "Sembunyikan Item Tidak Dapat Dibeli" diaktifkan dan Item tidak dapat dibeli dibuat, prompt akan ditampilkan.
7. Saat pengguna mengaktifkan Level kustom tetapi tidak mendefinisikan Level apa pun, kini akan reset ke tabel Level bawaan.
8. Meningkatkan gambar pratinjau widget.
9. Input langkah kini dibatasi ke angka. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Saat menggunakan browser bawaan untuk tautan produk, awalan "https" tidak lagi diperlukan.
11. Menambahkan instruksi "Konfigurasi Kompatibilitas" untuk fitur countdown produk.

**🐛 Perbaikan Bug**

1. Memperbaiki perilaku penanganan klik tak terduga saat memilih produk di toko dan gudang.
2. Memperbaiki masalah di mana Tugas non-berulang tidak dapat disetel batas waktu saat menambahkannya via API.
3. Memperbaiki masalah di mana gambar Atribut kustom mungkin tidak diperbarui di perangkat tertentu.
4. Memperbaiki masalah di mana efek suara kustom dapat menyebabkan App crash. Metode baru telah diimplementasikan, yang seharusnya membuat efek suara latar belakang lebih stabil dan menggunakan lebih sedikit memori, tetapi kecepatan pemutaran mungkin lebih lambat.
5. Memperbaiki masalah di mana di perangkat Android 12 ke atas tanpa konfigurasi "Abaikan Optimisasi Baterai", mengaktifkan timer pomodoro otomatis atau waktu istirahat dapat menyebabkan crash di latar belakang.
6. Memperbaiki masalah di mana efek suara countdown produk terpengaruh oleh pengaturan efek suara pomodoro.
7. Memperbaiki masalah di mana error perhitungan floating-point terjadi saat mengatur suku bunga harian ATM di API.
8. Memperbaiki masalah di mana beberapa gambar tidak dapat dimuat di Android 6.
9. Memperbaiki masalah di mana, saat memulihkan data App cadangan dari versi lebih tinggi ke versi lebih rendah, prompt error tidak ditampilkan dengan benar.
10. Memperbaiki masalah di mana beberapa perangkat mengalami tumpang tindih tata letak di halaman pomodoro.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Fitur**

1. Mendukung gradien Level kustom.
2. Menambahkan batch widget awal:
   - Koin (kecil, besar, target)
   - Atribut (kecil, besar)
3. Mendukung kueri sebagian besar detail data di LifeUp melalui Content Provider API, termasuk:
   - Menawarkan versi baru "LifeUp Cloud".
   - Menyediakan versi desktop awal yang sederhana (Windows, Linux, macOS) untuk penggunaan jaringan lokal.
4. Mendukung penghapusan multi-seleksi untuk catatan timer tomato.
5. Mendukung pengaturan mulai otomatis istirahat dan kerja untuk jam tomato.
6. Peningkatan API dan field tambahan, termasuk:
   - Setoran dan penarikan ATM.
   - Mengatur apakah pembelian barang dilarang.
   - Mengatur warna label untuk Tugas.
   - Mengatur saldo ATM langsung.
   - Kueri sederhana untuk detail produk tertentu.
   - Menambahkan tombol ketiga dan opsi operasi ke antarmuka popup.

**♻️ Optimisasi**

1. Meningkatkan kecepatan kueri, pemrosesan, dan performa saat menangani data dalam jumlah besar.
2. Memperbaiki margin yang salah untuk ikon adaptif.
3. Mengoptimalkan efek tampilan catatan timer tomato.
4. Meningkatkan interaksi saat memulihkan cadangan.
5. Menambahkan tampilan UI untuk mendapatkan lisensi keanggotaan melalui Google Play.
6. Menyediakan prompt untuk menonaktifkan fitur impor satu klik jika file cadangan yang dipilih bukan dari LifeUp saat mengimpor langsung dari sistem file.
7. Menutup metode input otomatis saat mencari barang di popup pemilihan produk.
8. Perubahan perilaku API, termasuk:
   - Popup API confirm_dialog. Jika teks tombol atau operasi tertentu tidak disediakan, tombol tidak akan ditampilkan. Ini memberikan fleksibilitas lebih besar dalam kontrol popup, misalnya Anda dapat menyiapkan popup hanya teks tanpa tombol untuk menampilkan teks dan bahasa motivasi.
   - API Penalti. Di versi sebelumnya, hanya dapat mengurangi hingga 100 Item, kini batas diperluas menjadi 9 digit.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana halaman timer tomato akan menampilkan "loading" di akhir dalam keadaan tertentu.
2. Memperbaiki crash yang disebabkan pustaka pihak ketiga tertentu.
3. Memperbaiki masalah di mana App akan crash saat menempatkan jam tomato di bilah navigasi bawah karena popup prompt.
4. Memperbaiki tampilan abnormal nilai Atribut saat menelusuri profil pengguna lain.
5. Memperbaiki masalah di mana event API dan notifikasi untuk pengurangan Level Atribut tidak dikirim dengan benar.
6. Memperbaiki beberapa masalah interaksi dengan halaman edit tekan lama.
7. Memperbaiki beberapa margin abnormal di halaman manajemen gambar dan Sintesis.
8. Memperbaiki beberapa jendela pop-up yang tidak dapat digulir, sehingga penggunaan abnormal dalam mode lanskap.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Mendukung operasi membaca dan mengotorisasi informasi Content Provider.
2. Saat layanan dimulai, meminta wake lock agar tetap dapat merespons meski layar terkunci.
3. Menambahkan serangkaian antarmuka untuk Content Provider.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Rilis awal, dirancang untuk digunakan bersama "LifeUp Cloud" dan App seluler.

Mendukung operasi berikut:

- Kueri Tugas, daftar, barang, Pencapaian, daftar Perasaan.
- Membeli barang, menyelesaikan Tugas.
- Mendukung penjelajah gambar desktop untuk melihat gambar Perasaan dalam ukuran diperbesar.

**1.90.7 (2022/11/07)**

**✨ Fitur**

1. Ditambahkan: terjemahan Vietnam dan tanda tangan penerjemah (versi Google)
2. Ditambahkan: metode pemilihan gambar "Lewati pemotongan", cocok untuk memilih animasi gif (fitur anggota)
3. Ditambahkan: API hapus Tugas
4. Ditambahkan: Mendukung pengaturan untuk menonaktifkan efek suara Tugas
5. Ditambahkan: operasi kuantitas MAX Sintesis sederhana
6. Mendukung mengunci kembali Pencapaian yang sudah dibuka
7. "Add Product API" mendukung penentuan id daftar

**♻️ Optimisasi**

1. Meningkatkan deskripsi penghapusan riwayat
2. Batas Poin Pengalaman diubah dari (3/4 digit) menjadi (4/5 digit)
3. Menambahkan tampilan koefisien penalti di halaman detail
4. Meningkatkan desain interaksi kotak pemilihan tanggal-waktu secara global
5. Jendela pop-up detail Pencapaian kini membedakan warna ikon sesuai apakah kondisi sudah selesai atau belum
6. Mengubah ikon pintasan tomato
7. Saat membuat Item dari daftar pintar, jika daftar yang dapat dipilih 0 atau 1, otomatis dipilih
8. Mode pengembang menampilkan ID daftar Item
9. Membatasi panjang input beberapa field umum untuk mencegah crash

**🐛 Perbaikan Bug**

1. Memperbaiki perhitungan Hadiah yang abnormal saat mengubah catatan riwayat Item dalam beberapa skenario
2. Memperbaiki masalah di mana saklar "Tampilkan Diarsipkan" tidak sesuai dengan tampilan dalam beberapa skenario
3. Meningkatkan logika pemuatan data widget (dapat memperbaiki beberapa masalah abnormal)
4. Memperbaiki logika perhitungan otomatis penambahan catatan waktu manual, kini cukup mengisi satu Item
5. Memperbaiki masalah refresh abnormal halaman catatan waktu tomato
6. Memperbaiki masalah subtugas yang tidak dapat menghapus Hadiah barang
7. Memperbaiki masalah di mana setelah memilih semua Item, memilih ulang sebagian Item tidak berlaku
8. Mengoptimalkan memori yang dibutuhkan untuk pratinjau gambar
9. Refresh widget kini dipicu setelah menyesuaikan urutan daftar
10. Mengoptimalkan masalah di mana beberapa metode cadangan macet di antarmuka

**1.90.6 (2022/10/21)**

**✨ Fitur**

1. Menambahkan API untuk mengatur jumlah langkah pada tanggal tertentu
2. Menambahkan API untuk mengkueri status Atribut tertentu (Poin Pengalaman, Level)
3. Mendukung impor langsung data cadangan dari pengelola file
4. API terkait Item Hadiah tidak lagi dibatasi 99

**♻️ Optimisasi**

1. Mengoptimalkan efek animasi transisi saat memasuki halaman detail acara
2. Mengoptimalkan halaman edit Item, meningkatkan efek UI pengaktifan penalti, dan memperbaiki panduannya
3. Mengubah ikon operasi di halaman waktu
4. Di jendela pop-up pembelian, menambahkan peringatan dan instruksi untuk Item dengan own_number negatif
5. Mengoptimalkan efek status bar imersif halaman utama
6. Menambahkan pengingat konfigurasi kompatibilitas ke halaman Pomodoro
7. Meningkatkan kecepatan ekspor cadangan dan pemulihan file cadangan
8. Instruksi untuk pengaturan stock_number
9. Sementara menghapus pengaturan [Ketika inventaris produk 0, Hadiah Tugas terkait akan otomatis dihapus].
10. Mengoptimalkan mekanisme pemeriksaan lisensi versi uji coba gratis.
11. Saat Tugas yang "Pin" dipilih, tindakan kini ditampilkan sebagai "Unpin"
12. Saat beralih ke waktu positif, peringatan *eksperimental* tidak lagi muncul setiap kali

**🐛 Perbaikan Bug**

1. Memperbaiki batas sistem abnormal beberapa halaman atau pada tablet
2. Memperbaiki masalah di mana data salah ditampilkan saat memasuki Inventaris untuk pertama kali dalam beberapa kasus
3. Memperbaiki masalah di mana data tidak dapat dipulihkan sama sekali karena kerusakan internal (seperti kerusakan gambar) saat memulihkan file cadangan yang rusak
4. Memperbaiki masalah di mana tombol "Beli" ditampilkan secara tidak terduga setelah menekan lama Item yang habis terjual
5. Memperbaiki masalah di mana pengenalan Atribut halaman tim baru masih versi lama

**1.90.5 (2022/09/22)**

**♻️ Optimisasi**

1. Menyesuaikan beberapa perangkat dengan konversi webp abnormal (gambar yang dipotong mungkin lebih besar dari gambar asli di perangkat ini). Setelah memilih gambar, tentukan ukurannya dan lakukan kompresi sekunder.
2. Meningkatkan deskripsi repetisi target di halaman detail
3. Mendukung penggunaan produk yang sama untuk mengakumulasi waktu selama hitung mundur
4. Menambahkan lebih banyak Tugas panduan pemula
5. Memperbarui terjemahan

**🐛 Perbaikan Bug**

1. Memperbaiki masalah UI abnormal halaman Sintesis
2. Memperbaiki beberapa masalah crash yang diketahui
3. Meningkatkan masalah di mana hitung mundur barang dapat terputus secara abnormal dan waktu terakumulasi pada hitung mundur jangka panjang
4. Memperbaiki pengecualian UI jendela pop-up input Perasaan saat widget menyelesaikan Tugas

**1.90.4 (2022/09/15)**

1. Memperbaiki masalah abnormal saat widget menyelesaikan Tugas (dapat menyebabkan halaman transparan muncul dan operasi tidak dapat dilanjutkan)
2. Menonaktifkan kemampuan widget untuk memilih gambar dari kesan

**1.90.3 (2022/09/14)**

1. Memperbaiki masalah fokus saat mengurutkan subtugas
2. Meningkatkan warna Atribut pada Tugas beku/belum dimulai
3. Menambahkan siaran event Tugas yang ditinggalkan
4. Memperbaiki warna teks probabilitas
5. Meningkatkan Tugas starter (Tugas preset)
6. Memperbaiki masalah di mana dialog impor Item mungkin memilih daftar "Semua" secara default
7. Memperbaiki masalah grup Item Toko
8. Peringatan kini diberikan saat mengatur waktu yang tidak biasa (waktu tidak sesuai frekuensi pengulangan).
9. Meningkatkan aturan perhitungan Tugas di kalender, yang kini seharusnya memprediksi tenggat Tugas mendatang secara akurat.
10. Memperbaiki masalah di mana penyelesaian kalender dapat dihitung untuk Tugas beku.
11. Meningkatkan pengaturan waktu mulai default saat mengedit Tugas.
12. Meningkatkan mekanisme deteksi lisensi.
13. Mengoptimalkan pemrosesan hitung mundur Item. Eksekusi berulang dilarang untuk mengurangi masalah akumulasi waktu yang tidak sesuai harapan.
14. Memperbaiki masalah edge-to-edge saat menggunakan tombol virtual di beberapa halaman.
15. Memperbaiki masalah di mana Anda tidak dapat memilih gambar pikiran saat widget desktop menyelesaikan Tugas.

**1.90.2 (2022/08/31)**

**✨ Fitur**

1. Menambahkan event siaran.
   Kini Anda dapat menggunakan Tasker/MacroDroid untuk menerima event seperti menggunakan Item, menyelesaikan Tugas, dll., dan memicu tindakan Tasker.

   Contoh: Jika Item digunakan, akan memicu penggantian wallpaper acak.
   Secara teori, jika Anda mau, Anda dapat mengimplementasikan fungsi seperti kunci aplikasi dan skenario interaksi game.

2. API baru:

- Menyerah pada Tugas
- Membekukan Tugas
- Mencairkan Tugas
- Antarmuka kosong
- Kueri

3. Menambahkan nilai balik untuk API tambah Item dan Tugas baru
4. Saat mengimpor Item dari pasar, kini Anda dapat memilih daftar target
5. Menyesuaikan warna sekunder Material 3
6. Memperbarui terjemahan bahasa, menambahkan dukungan bahasa Korea

**♻️ Optimisasi**

1. Saat membuka kotak secara batch, juga menampilkan probabilitas produk tunggal
2. Mengoptimalkan beberapa efek tampilan UI dalam mode malam
3. Mengoptimalkan logika interaktif jendela pop-up pemilihan tanggal-waktu. Saat memilih hari ini, otomatis beralih ke halaman pemilihan waktu.
4. Saat API memanggil pemilihan Item dan pemilihan daftar, jendela pop-up tidak lagi mendukung penutupan langsung (untuk mencegah panggilan API hilang)
5. Mengoptimalkan tinggi default beberapa jendela pop-up di bagian bawah layar horizontal tablet
6. Mengoptimalkan waktu penutupan otomatis jendela pop-up

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana pencarian Tugas API mungkin gagal dalam beberapa kasus
2. Memperbaiki crash sesekali di halaman daftar Tugas
3. Memperbaiki masalah di mana tombol operasi "Undo" muncul saat menekan lama Pencapaian normal yang belum dibuka.
4. Memperbaiki masalah di mana jendela pop-up detail Pencapaian mungkin ditampilkan tidak lengkap
5. Memperbaiki masalah di mana saat mengunggah jendela, mungkin gagal karena gambar yang sangat besar
6. Memperbaiki masalah di mana own_number dan stock_number API Item tidak mendukung angka negatif
7. Memperbaiki masalah di mana jumlah hari ketekunan di halaman "Saya" kadang ditampilkan abnormal sebagai 1
8. Memperbaiki masalah di mana kadang ditampilkan -x hari lalu
9. Memperbaiki masalah di mana API berikutnya mungkin dibatalkan secara abnormal saat memanggil API secara batch
10. Memperbaiki masalah di mana konten yang diisi tim baru mungkin hilang saat halaman dihancurkan

**1.90.1 (2022/08/22)**

**🐛 Perbaikan Bug**

1. Memperbaiki masalah konkurensi panggilan API
2. Memperbaiki masalah di mana saat sejumlah besar produk (ribuan) dipilih, pemilihan ganda produk dapat menyebabkan freeze
3. Memperbaiki masalah abnormal saat widget menyelesaikan Tugas tim
4. Memperbaiki masalah di mana pengeditan Poin Pengalaman subtugas tidak diisi kembali

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Fitur**

1. Optimisasi pengaturan Hadiah Tugas:
   - Penyesuaian UI pengaturan Hadiah
   - Subtugas mendukung pengaturan Hadiah Poin Pengalaman dan Item
   - Mengubah Hadiah "hanya teks" asli menjadi Hadiah "words" independen
   - Mendukung pengaturan nilai Poin Pengalaman default

2. Item mendukung pengaturan batas pembelian Level Atribut.

3. Item mendukung efek "URL".
   Tidak hanya dapat melompat ke halaman web, tetapi juga memanggil aplikasi lain atau API LifeUp. Mewujudkan efek kenaikan harga setelah menggunakan Item.

4. **API Terbuka.**
   Kini Anda dapat mencocokkan perangkat lunak otomatisasi atau melakukan pengembangan sekunder.

   [Untuk detail lebih lanjut, silakan periksa dokumen API.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. Toko mendukung melihat efek penghitungan yang belum disaring

6. Optimisasi notifikasi:

   - Menambahkan notifikasi perubahan Level Atribut
   - Menambahkan notifikasi Pencapaian terbuka
   - Optimisasi grup notifikasi

7. Mendukung penambahan catatan waktu secara manual.

8. Kini mendukung pengaturan halaman Pomodoro ke bilah navigasi

9. Mendukung menyembunyikan daftar [Pencapaian Sistem]

10. Versi API target disesuaikan dengan Android 12L

11. Optimisasi efek imersi

12. App Widgets mendukung menampilkan jendela pop-up penyelesaian Tugas

13. Kini Anda dapat menyelesaikan Tugas di halaman detail matter

14. Di jendela pop-up terlambat, Anda dapat mengatur jumlah Tugas hitungan

15. Kini Anda dapat mengedit nama Tugas tim

16. Mengoptimalkan waktu permintaan jaringan modul dunia, mengurangi konsumsi lalu lintas dan tekanan server

**♻️ Optimisasi**

1. Mode malam kini mendukung semua warna tema, dan membuat kustomisasi warna malam terpisah untuk setiap warna tema, yang disesuaikan dengan Material 3
1. Menambahkan tautan "optimisasi baterai" di dialog konfigurasi Kompatibilitas
1. Menambahkan saklar "Layar tetap menyala" di Pengaturan Pomodoro
1. Menyediakan dua opsi: "Selesai" dan "Tambahkan" untuk hitung mundur Item dalam keadaan dijeda
1. Saat jumlah target pengeditan lebih besar dari jumlah saat ini, prompt error disediakan
1. Matter negatif tidak boleh ditampilkan di pengaturan koefisien penalti
1. Mengoptimalkan efek refresh di halaman Riwayat
1. Mengoptimalkan logika pemicu otomatis Tugas utama setelah menyelesaikan subtugas, dan mengubahnya menjadi pemrosesan langsung di halaman detail
1.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana tombol + akan muncul di halaman Moments kadang-kadang
2. Memperbaiki masalah di mana Tugas negatif tidak akan memunculkan dialog Perasaan
3. Memperbaiki masalah target Tugas negatif yang tidak berlaku.
4. Mencoba memperbaiki efek pengaturan "membekukan hingga ..." untuk Tugas tim
5. Memperbaiki masalah di mana gambar halaman Perasaan mungkin ditampilkan salah

**1.89.5 (2022/8/5)**

1. Mengoptimalkan masalah koneksi jaringan
2. Memperbarui terjemahan

**1.89.4 (2022/7/13)**

1. Memperbaiki informasi tentang Xiaohong Dot Questions
2. Masalah Tugas berulang yang berulang kali dihasilkan (kali ini seharusnya benar-benar diperbaiki .jpg)

**1.89.3 (2022/7/05)**

**♻️ Optimisasi**

1. Mengoptimalkan penilaian daftar saklar geser

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana perhitungan mungkin tidak selesai saat ada banyak kondisi
   Pencapaian
2. Memperbaiki masalah di mana pengingat notifikasi Tugas tanpa batas akan menampilkan tenggat
   abnormal
3. Memperbaiki masalah di mana mengedit latar belakang Item akan memengaruhi Item yang disalin setelah menyalin
   Item
4. Memperbaiki masalah di mana Keterampilan mengedit Tugas tim mungkin tidak diwarisi

**1.89.2 (2022/6/23)**

**♻️ Optimisasi**

1. Menghapus izin CARMRA yang tidak perlu
2. Memperbarui terjemahan

**🐛 Perbaikan Bug**

1. Memperbaiki beberapa crash

**1.89.0-1.89.1 (2022/6/09)**

**✨ Fitur**

1. Mendukung Pencapaian kondisional multi-pembukaan
2. Detail Pencapaian mendukung melihat detail kondisi dan progres
3. Tag Tugas
4. Tugas berulang tanpa tenggat
5. Menyembunyikan Item yang habis terjual atau pembelian dinonaktifkan
6. Saat mengatur efek pengurangan Poin Pengalaman untuk Item, opsional untuk membatasi penggunaan
7. Halaman Inventaris mendukung multi-seleksi, pilih-semua, dan pengembalian batch
8. Daftar Tugas default mendukung operasi arsip
9. Mendesain ulang beberapa halaman seperti pengaturan, Tanya Jawab, bilah alat Toko, dan halaman tambah daftar
10. Mendesain ulang beberapa ikon dalam App (ikon kartu Tugas default, koin, Poin Pengalaman, ikon
    Pencapaian)
11. Penyimpanan gambar dipindahkan ke jalur privat eksternal App untuk mencegah penghapusan file tidak sengaja

**♻️ Optimisasi**

1. Menambahkan tautan artikel [Konfigurasi Kompatibilitas] ke halaman pengaturan
2. Hitung mundur Pomodoro — operasi reset menambahkan dialog konfirmasi
3. Menambahkan deskripsi untuk pembekuan Tugas
4. Menambahkan deskripsi untuk sub-kategori Pencapaian
5. Dalam mode offline, menambahkan tombol untuk keluar mode offline di halaman edit profil
6. Mengoptimalkan statistik Tugas plenty (negatif), mendukung tampilan jumlah penyerahan
   hari ini dan mendukung pelacakan Pencapaian
7. Mengoptimalkan kecepatan startup aplikasi
8. Ikon Pencapaian mendukung melihat gambar lebih besar
9. Menambahkan statistik suka (diterima) untuk Tugas acak
10. Optimisasi interaksi pencarian terpadu
11. Saat memilih Item, beralih ke daftar kosong menampilkan tata letak kosong (bukan loading)
12. Halaman lihat gambar besar menyesuaikan pengaturan warna tema saat ini
13. Mengoptimalkan efek animasi saat tinggi jendela pop-up Item dan Tugas terpilih
    berubah
14. Di pengaturan cadangan, "Hapus data lokal" juga mendukung menghapus file media
15. Menyatukan logika penyimpanan dan penghapusan file sementara untuk mengambil foto
16. Membedakan ikon Item default dan ikon yang gagal dimuat
17. Mengaktifkan pengaturan plenty independen untuk Tugas secara default kini
18. Mengoptimalkan refresh, logika animasi, dan kecepatan loading halaman Perasaan
19. Beberapa jendela pop-up detail menambahkan tombol pintasan "pilih"
20. Saat saklar utama "efek suara" dan "getaran" di halaman pengaturan lanjutan
    dimatikan, instruksi terkait juga disediakan di pengaturan tomato.
21. Optimisasi pengurutan Pencapaian baru dan sub-kategori
22. Peningkatan pustaka dasar dan dependensi
23. Mengoptimalkan metode dan kecepatan perhitungan progres Pencapaian
24. Meningkatkan metode perhitungan "target (repetisi) kali" agar mengikuti peningkatan statistik
    catatan riwayat, konsisten dengan jumlah kali di detail
25. Saat memasukkan jumlah koin dan jumlah repetisi target, semua nilai saat ini akan
    otomatis dipilih
26. Mengoptimalkan prompt error saat konfigurasi WebDAV abnormal
27. Mengoptimalkan prompt error saat cadangan Google Drive abnormal
28. Kini mendukung memilih nama Tugas di halaman detail

**🐛 Perbaikan Bug**

1. Memperbaiki masalah di mana hitungan yang ditetapkan memengaruhi Hadiah Tugas menjadi tidak valid setelah Tugas menjalankan
   logika pengulangan
2. Memperbaiki masalah pengurutan dan pengelompokan halaman Toko
3. Memperbaiki masalah abnormal halaman atas bawah Tugas acak dalam beberapa kasus
4. Memperbaiki masalah di mana statistik Pomodoro di halaman status tidak akurat setelah menggunakan
   waktu positif dalam beberapa kasus
5. Memperbaiki masalah di mana logika pengulangan Tugas tim akan kehilangan pengaturan tipe Tugas hitungan
6. Memperbaiki masalah di mana Tugas yang dipilih Tomato akan disorot saat memilih Tugas
   terkait kondisi Pencapaian
7. Memperbaiki masalah di mana gambar Perasaan tidak disimpan secara independen dan masalah tampilan
8. Memperbaiki masalah di mana prompt kegagalan mungkin muncul sering saat login gagal
9. Beberapa kotak input khusus untuk Tugas, tim, dan subtugas baru tidak boleh mengizinkan input keyboard,
   yang dapat menyebabkan App crash
10. Mengoptimalkan cara menghitung jumlah penyelesaian Item tak terbatas di App widget,
    konsisten dengan dalam App
11. Memperbaiki masalah di mana setelah ATM menyesuaikan suku bunga, bunga mungkin dihitung
    berdasarkan waktu terakumulasi dan suku bunga yang disesuaikan
12. Memperbaiki masalah di mana Tugas beku mungkin masih ditampilkan di daftar pintar
13. Mengoptimalkan masalah di mana tombol tindakan yang diblokir bilah seleksi masih dapat diklik
    saat objek tertentu (Tugas, Item Toko) dipilih
14. Memperbaiki masalah di mana mengubah warna Item tidak akan segera me-refresh UI 15.Memperbaiki
    masalah di mana tiba-tiba mengatur suku bunga tinggi setelah mempertahankan suku bunga rendah (gagal
    mendapat 1 emas) mungkin mendapat bunga besar
15. Memperbaiki masalah di mana kotak pencarian muncul setelah menyelesaikan Tugas setelah membuka bilah
    pencarian dan menggunakan produk
16. Memperbaiki masalah di mana jumlah penyelesaian dalam App hari ini mungkin tidak cocok dengan widget
    setelah mengubah nama Tugas tak terhingga
17. Memperbaiki animasi aneh saat menyelesaikan Tugas tak terbatas
18. Memperbaiki masalah di mana menyalin Tugas tidak akan menyalin latar belakang Tugas
19. Memperbaiki masalah di mana dalam beberapa kasus, kondisi Pencapaian selesai, tetapi
    Pencapaian tidak dapat dibuka
20. Memperbaiki masalah pengecualian perhitungan interval tanggal (dapat berpotensi memengaruhi beberapa logika)
21. Memperbaiki masalah di mana Perasaan tidak difilter otomatis dari halaman detail Tugas

**1.88.4 (2022/4/21)**

1. Memperbaiki masalah di mana pencarian gudang akan menyebabkan crash
2. Memperbaiki gangguan tampilan latar belakang kustom dan halaman riwayat
3. Memperbaiki masalah tumpang tindih UI saat mengedit
4. Memperbaiki masalah di mana kuantitas mungkin ditampilkan abnormal saat Pencapaian diberi Hadiah
   barang
5. Memperbaiki masalah di mana jumlah penyelesaian Item perhitungan Pencapaian mungkin tidak cocok dengan
   jumlah aktual dalam beberapa kasus khusus
6. Memperbaiki masalah di mana judul mungkin hilang saat halaman riwayat diklik dengan cepat
7. Saat membuat atau mengedit Item, setelah mengklik properti, keyboard lunak tidak dapat
   muncul dengan mengklik kotak input yang sedang fokus lagi.
8. Memperbaiki masalah crash saat mengatur batas pembelian bulanan dalam bahasa Prancis

**1.88.3 (2022/4/09)**

1. Memperbaiki bahwa setelah memulihkan cadangan, cadangan cloud akan memprompt masalah konflik
2. Memperbaiki masalah di mana waktu mulai Tugas yang diedit dan waktu pengingat subtugas tidak memilih waktu yang diisi secara default
3. Memperbaiki masalah di mana efek lain hanya dihitung sekali selama Sintesis sederhana batch
4. Memperbaiki masalah di mana Atribut Pencapaian sistem mana pun yang mencapai Level 10 tidak dihitung ke Atribut kustom
5. Memperbaiki tampilan abnormal UI teks di halaman "Saya" untuk non-anggota

**1.88.2(-)**

> Pembaruan termasuk dalam 1.88.3

**1.88.1 (2022/4/02)**

1. Memperbaiki crash yang disebabkan pengingat cadangan

**1.88.0 (2022/3/30)**

**✨ Fitur**

1. Menambahkan fungsi berbagi "Tugas acak" di modul dunia
2. Item penghitungan dapat secara opsional mengatur koefisien untuk memengaruhi jumlah Item
3. Mendukung pengaturan suku bunga pinjaman
4. Manajemen gambar mendukung filter gambar tidak terpakai satu klik + operasi pilih semua
5. Mendukung ukuran pemotongan gambar kustom (yaitu, gunakan ikon resolusi lebih tinggi, fungsi keanggotaan)
6. Menampilkan secara eksplisit saklar "Perasaan" dalam Pencapaian
7. Mengoptimalkan algoritma pengurutan daftar "Semua"

**⚡️ Optimisasi**

1. Mengoptimalkan efek visual beberapa jendela pop-up
2. Mengoptimalkan interaksi fungsi cadangan/pemulihan
3. Mengoptimalkan kecepatan loading halaman delegasi
4. Sangat mengoptimalkan kecepatan loading jendela pop-up pemilihan produk

**🐛 Perbaikan Bug**

1. Memperbaiki masalah gangguan latar belakang kustom
2. Memperbaiki masalah di mana Tugas mungkin dibuat ke daftar yang dihapus
3. Beberapa perbaikan bug crash

**1.87.1（2022/3/07）**

1. Menu pengurutan Toko dan Inventaris secara eksplisit menampilkan pengurutan "kustom"
2. Memperbaiki masalah di mana pengurutan abnormal mungkin terjadi di Inventaris
3. Menambahkan tombol untuk melompat ke umpan balik email di halaman umpan balik
4. Mengoptimalkan prompt kegagalan pemulihan karena masalah versi database
5. Memperbaiki masalah di mana jumlah koin di kartu mode kompak tidak ditampilkan

**1.87.0 official version (2022/3/04)**

1. Memperbaiki masalah di mana latar belakang kartu kustom akan zoom abnormal dalam beberapa kasus
2. Memperbaiki masalah di mana mengklik notifikasi pengingat Tugas mungkin melompat ke detail Tugas yang salah saat menerima pengingat Tugas secara terus-menerus
3. Memperbaiki masalah di mana angka di kartu tidak di-refresh normal saat menggeser untuk menambah hitungan Tugas hitungan
4. Menambahkan Tugas panduan baru untuk beberapa bahasa

**1.87.0-rc02（2022/2/25）**

1. Meningkatkan penanganan error dan prompt untuk operasi pemulihan
2. Mengoptimalkan interaksi pengaturan "hari dalam seminggu", dan menambah peringatan pengaturan abnormal (periode mulai tidak pada hari yang sama)
3. Mengoptimalkan pencocokan warna mode malam beberapa halaman
4. Memperbaiki masalah di mana cache mungkin ditampilkan salah di kotak pemilihan gambar dan manajemen gambar
5. Memperbaiki masalah di mana operasi "Unduh" di jendela pop-up konflik cadangan tidak mendukung Google Drive/Dropbox
6. Memperbaiki masalah di mana pencarian toko mungkin menampilkan hasil salah
7. Memperbaiki masalah di mana pin Tugas mungkin gagal
8. Memperbaiki beberapa pengecualian UI dan masalah teks

**1.87.0-rc01（2022/2/23）**

**✨ Fitur**

1. Sub-kategori Pencapaian mendukung operasi lipat
2. Memperkenalkan saklar gaya desain Material You (eksperimental)
3. Inventaris mendukung pengurutan berdasarkan Toko
4. Inventaris mendukung operasi "bintang" barang
5. Toko mendukung operasi pilih semua
6. Operasi terkait Toko dan Inventaris mendukung pemilihan kuantitas MAX
7. Tugas mendukung pembuatan berkelanjutan
8. Dukungan konfigurasi Tugas: Deskripsi Hadiah produk akan otomatis ditambahkan ke catatan kartu (yaitu, "Hadiah: [produk] x1" akan ditampilkan otomatis)
9. Tugas mendukung durasi pembekuan yang ditentukan

**⚡️ Optimisasi**

1. Menambahkan tombol "Lewati" ke jendela pop-up konflik cadangan
2. Versi Play mendukung Prancis/Polandia
3. Pengingat notifikasi klik Tugas kini mendukung lompat ke detail Tugas
4. Saat mengedit waktu terkait Tugas, jendela pop-up default akan menunjuk ke waktu sebelum pengeditan alih-alih waktu saat ini
5. Setiap entri pemilihan daftar toko mendukung operasi "Ganti Nama", "Hapus", "Baru"
6. Redesain UI halaman ekstensi
7. Menambahkan jendela pop-up konfirmasi kedua untuk "Hapus Akun Kalender"
8. Produk tidak lagi otomatis dihapus dari rak jika habis terjual
9. Tugas "Bangun pagi" dalam Tugas contoh diubah menjadi penalti 0
10. Saat mendapat Hadiah Item, jika kuantitas Item negatif, peringatan terkait kini akan muncul
11. Mengoptimalkan algoritma acak koin emas dalam efek penggunaan barang
12. Operasi "Tetapkan sebagai selesai" menambahkan efek suara selesai
13. Mengoptimalkan beberapa tampilan UI dalam mode malam
14. Mengoptimalkan performa daftar Tugas

**🐛 Perbaikan Bug**

1. Memperbaiki abnormalitas salinan "tidak peduli" dalam beberapa bahasa
2. Memperbaiki masalah di mana ikon produk di jendela pop-up "Kembalikan" mungkin ditampilkan abnormal
3. Memperbaiki masalah di mana Tugas mungkin dihasilkan berulang saat Tugas diselesaikan dengan cepat
4. Memperbaiki masalah di mana memori daftar saat ini sistem "Sintesis" mungkin tidak valid
5. Memperbaiki masalah di mana login QQ mungkin tidak memungkinkan dalam keadaan layar horizontal
6. Memperbaiki masalah di mana saat mengedit resep di daftar [Semua] dalam sistem "Sintesis", resep mungkin hilang dari daftar asli
7. Memperbaiki masalah di mana mengklik menyelesaikan Tugas tak terhingga beberapa kali berturut-turut dapat menyebabkan tampilan jumlah penyelesaian kembali ke nol
8. Memperbaiki masalah di mana interval cadangan tidak dapat diatur ke "Bulanan"
9. Memperbaiki masalah di mana ikon Poin Pengalaman tidak ditampilkan dalam mode sederhana
10. Memperbaiki masalah di mana kolom "Pencapaian" dan "Daftar Pencapaian" hilang di manajemen gambar
11. Memperbaiki masalah di mana halaman detail Tugas tidak mendukung menyerah pada Tugas tim
12. Memperbaiki masalah di mana panduan modul dunia tidak ditampilkan dengan benar
13. Memperbaiki masalah di mana produk dapat berhasil dibagikan saat unggah gambar gagal, tetapi gambar lokal akan ditimpa
14. Memperbaiki beberapa crash dan pengecualian langka

**1.86.0（2022/1/20）**

**Fitur**

1. Sub-kategori Pencapaian: Membagi kategori, otomatis menghitung jumlah kategori
2. Cadangan Google Drive
3. Fungsi manajemen gambar (di halaman cadangan)
4. Efek koin emas acak produk
5. Salin batch Pencapaian
6. Penghitungan langkah mendukung input langkah ganda dan Hadiah ganda
7. Pomodoro mendukung pengaturan pertukaran barang
8. Mendukung rasio diskon pengembalian kustom
9. Gunakan format eksklusif untuk cadangan (beberapa sistem mendukung pembukaan langsung dan impor cadangan)
10. Sintesis sederhana mendukung operasi batch
11. Opsi efek suara kustom baru: penggunaan barang
12. Kondisi pembukaan Pencapaian baru: setoran ATM saat ini
13. Statistik jumlah kali matter negatif mendukung halaman detail
14. Daftar "Semua" mendukung penggantian nama
15. Penamaan dan deskripsi saluran notifikasi untuk aplikasi terpadu

**Optimisasi**

1. Memprioritaskan Pencapaian yang sudah dibuka tetapi belum menerima Hadiah
2. Waktu Fokus Pomodoro hari ini di halaman status akan ditampilkan dalam jam sesuai waktu.
3. Gudang menambahkan tampilan deskripsi barang
4. Pendaftaran akun baru akan memunculkan dialog konfirmasi
5. Dukungan menampilkan pengumuman pemeliharaan
6. Menambahkan dialog konfirmasi "Lewati" untuk Waktu Ekstra Pomodoro
7. Mendukung menyimpan data saat uninstall aplikasi (diperlukan dukungan sistem)
8. Mengoptimalkan logika cadangan dan pemulihan
9. Mengoptimalkan logika terlambat Item tunggal dan Item tak terbatas, dan mendukung pengeditan
10. Mengoptimalkan basis waktu statistik grafik acara tak terbatas, berdasarkan waktu penyelesaian alih-alih waktu tenggat
11. Kartu mode kompak juga akan menampilkan waktu terlambat Item tunggal dan tak terbatas
12. Mencoba meningkatkan tingkat kelangsungan fungsi hitung mundur di latar belakang
13. Mengoptimalkan fungsi kesan:
    -Aktif secara default
    -Halaman pengaturan Tugas tim tidak menampilkan saklar "Kesan" yang sebenarnya tidak berlaku
    -Menghapus fungsi memori saklar Perasaan yang membingungkan
14. Pilih jendela pop-up untuk daftar barang dan gudang untuk meningkatkan jumlah barang yang ditampilkan
15. Saat bilah notifikasi terus menghitung waktu, efek getaran yang sedang berlangsung juga akan dibatalkan
16. Teks dinamis di modul dunia mendukung salinan terpilih
17. Mengoptimalkan efek animasi refresh data halaman Pencapaian kustom
18. Mengoptimalkan logika pemulihan, menampilkan dialog "Loading" alih-alih antarmuka langsung macet
19. Mengoptimalkan masalah di mana tombol bawah mungkin tidak terlihat di "Jendela pop-up Crash"
20. Klik pengingat notifikasi Tugas, kini akan melompat ke halaman daftar tempat Tugas berada
21. Ikon Atribut kustom, kini mendukung memilih pustaka ikon bawaan aplikasi
22. Mengoptimalkan nama operasi berbagi "Baca Nanti" alih-alih langsung menampilkan nama aplikasi
23. Mengoptimalkan notifikasi pembukaan Pencapaian, deskripsi Pencapaian kini akan ditampilkan
24. Saat widget desktop memasuki halaman utama, otomatis melompat ke modul "delegasi"
25. Mengoptimalkan tampilan teks setelah penyelesaian daftar hari
26. Mengoptimalkan teks operasi dan urutan efek hitung mundur produk
27. Saat semua Atribut disembunyikan, halaman status tidak lagi menampilkan kartu "Atribut"

**Perbaikan Bug**

1. Memperbaiki masalah crash langka saat jendela pop-up pembukaan Pencapaian
2. Memperbaiki masalah tampilan di mana satu Tugas mungkin menekan beberapa baris saat widget desktop kosong dengan lebar tidak cukup
3. Memperbaiki masalah di mana otorisasi latihan pertama untuk penghitungan langkah mungkin mendukung tampilan jumlah total langkah yang terakumulasi oleh sensor
4. Memperbaiki crash atau kebingungan pemulihan saat menjeda hitung mundur lalu memulai hitung mundur lain
5. Memperbaiki masalah di mana efek hitung mundur 0 menit produk dapat dimasukkan dan akan crash
6. Memperbaiki masalah di mana nama daftar yang sedang dipilih tidak di-refresh tepat waktu saat mengganti nama daftar yang sedang dipilih di halaman menambah atau mengedit Item
7. Memperbaiki tampilan abnormal kartu dengan frekuensi pengulangan "tahunan"
8. Memperbaiki masalah di mana koin emas kustom tidak akan berlaku tepat waktu dalam beberapa kasus
9. Memperbaiki masalah di mana widget akan menampilkan Item beku
10. Memperbaiki masalah di mana Pencapaian kustom tidak menampilkan prompt "operasi tekan lama"
11. Memperbaiki masalah di mana total Poin Pengalaman halaman "Saya" tidak menghitung Poin Pengalaman Atribut kustom
12. Memperbaiki masalah di mana halaman "Kesan" refresh kembali ke atas setelah pratinjau gambar abnormal
13. Memperbaiki masalah di mana pintasan statis "Tomato" hanya akan melompat ke halaman utama saat aplikasi sudah dimulai di bawah sistem MIUI
14. Memperbaiki masalah di mana non-anggota mungkin juga memuat latar belakang kustom
15. Memperbaiki masalah di mana jumlah koin emas di halaman toko tidak di-refresh tepat waktu
16. Memperbaiki masalah di mana kalender tidak dapat diputar ke tahun berikutnya
17. Memperbaiki masalah di mana nama daftar di widget tidak di-refresh tepat waktu setelah nama daftar dimodifikasi

**Release Candidate -> Official Version**

1. Mengoptimalkan tingkat keberhasilan unggah file besar di Google Drive, meningkatkan retry dan mengoptimalkan strategi blok
2. Memperbaiki masalah di mana anggota mungkin tidak menampilkan tombol latar belakang Tugas kustom individual dalam lingkungan non-Tionghoa
3. Cadangan Google Drive/DropBox gagal dan melompat ke halaman cadangan alih-alih halaman konfigurasi WebDAV
4. Menambahkan deskripsi jendela pop-up kegagalan verifikasi Google Play, dan menyediakan jalur ekspor data
5. Nama panggilan halaman "Saya" berubah warna sesuai status keanggotaan
6. Menghilangkan masalah error floating point suku bunga ATM di sebagian besar skenario
7. Saat menghapus data lokal, latar belakang kustom, gambar Atribut, dan file efek suara juga akan dihapus secara sinkron
8. Memperbaiki masalah abnormal grafik jumlah langkah
9. Memperbaiki masalah di mana properti halaman to-do baru tidak di-refresh setelah mengklik tombol tanda tanya properti dari halaman to-do baru, melompat ke halaman kustomisasi properti untuk mengedit, dan kembali ke halaman to-do baru
10. Saat menyesuaikan efek produk, mengklik di luar jendela pop-up tidak lagi otomatis membatalkan jendela pop-up, menghindari kehilangan konten pengeditan
11. Mengoptimalkan masalah UI bahasa asing halaman pengaturan produk (teks Rusia terlalu panjang)
12. Mencoba memperbaiki crash color toast di beberapa model
13. Memperbaiki masalah di mana tombol gunakan masih dapat diklik saat halaman gudang dipilih
14. Memperbaiki logika menampilkan Tugas tunggal terlambat di daftar pintar, dan menyesuaikan metode penyimpanan waktu terlambat baru
15. Saat gudang dipilih, daftar toggle harus dibatalkan pilihannya

**1.85.4 (2021/12/08)**

Versi perbaikan bug rutin, versi fitur berikutnya masih dalam pengembangan~

1. Memperbaiki masalah di mana ikon default koin emas widget dalam mode non-gelap tidak ditampilkan dengan benar
2. Memperbaiki masalah di mana animasi bilah progres tidak diputar normal dalam kasus peningkatan/penurunan Level berkelanjutan
3. Memperbaiki masalah di mana jumlah koin emas di halaman gudang tidak diperbarui tepat waktu
4. Memperbaiki masalah di mana tenggat mungkin dipaksa diubah saat mengedit Item "hari dalam seminggu"
5. Memperbaiki masalah di mana rotasi layar dapat menyebabkan informasi subtugas yang diubah hilang saat mengedit Item
6. Memperbaiki masalah di mana jumlah koin emas sebenarnya tidak berlaku saat membuat atau mengedit produk baru
7. Kondisi tampilan jumlah penyelesaian tahunan di halaman detail amandemen
8. Mengoptimalkan penyimpanan gambar di App, dan seharusnya tidak dipindai oleh album foto sistem
9. Mengoptimalkan deskripsi saklar Perasaan
10. Memperbaiki beberapa crash

**1.85.3 (2021/11/18)**

1. Mengoptimalkan metode perhitungan waktu waktu, akan mengompensasi waktu tidur CPU
2. Memperbaiki masalah di mana mengedit ikon saat menyalin produk akan menyebabkan ikon produk asli hilang
3. Perbaikan bug minor lainnya (seperti tag tim)

**1.85.2 (2021/11/07)**

1. Memperbaiki masalah di mana catatan dan Hadiah tidak dapat dihasilkan selama penyelesaian setelah waktu dijeda
2. Memperbaiki bahwa menggunakan operasi "pindah ke" di bawah daftar pintar akan menyebabkan daftar ditampilkan tidak akurat
3. Memperbaiki masalah di mana tampilan nilai saat ini "Jumlah koin emas saat ini" tidak cocok dengan perhitungan aktual (tampilan nilai saat ini tidak termasuk setoran ATM)
4. Memperbaiki masalah di mana catatan dan Hadiah akan diulang setelah kerja Pomodoro selesai, lalu tombol lewati diklik dua kali berturut-turut

**1.85.1 (2021/11/02)**

0. Memperbaiki masalah loading daftar Perasaan

**1.85.0 2021/10/20)**
*Fitur*

1. Pomodoro mendukung mode waktu positif
2. Tempel beberapa baris teks untuk membuat subtugas dengan cepat
3. Barang mendukung operasi salin
4. Geser untuk mengganti arah daftar Item, mendukung terbalik (pengaturan-Item)
5. Mendukung menghapus catatan Pomodoro yang diperoleh
6. Pomodoro menambahkan tombol paksa beralih layar horizontal dan vertikal
7. Kondisi pembukaan Pencapaian telah ditambahkan:
   ● Jumlah produk yang diperoleh melalui Sintesis
   ● Kuantitas akuisisi kumulatif barang
   ● Kuantitas saat ini produk
   ● Level kehidupan
   ● (Berulang) waktu Fokus Tugas
8. Ikon Keterampilan juga mendukung beberapa pengaturan pemotongan
9. Pintasan statis:
   ● Tugas baru
   ● Masuk halaman Pomodoro
10. Kustomisasi efek suara ditambahkan:
    ● Mendapatkan Hadiah Pencapaian (termasuk Pencapaian sistem dan Pencapaian kustom)
    ● Membuka kotak
    ● Sintesis (termasuk Sintesis sederhana dan Sintesis)
    ● Efek suara notifikasi
11. Kustomisasi ikon koin emas
12. Efek penggunaan produk mendukung pengaturan beberapa efek perubahan Poin Pengalaman
13. Perubahan pada adaptasi Keterampilan grafik pai Poin Pengalaman
14. Halaman riwayat mendukung filter status
15. Fungsi tag tim

*Optimisasi*

1. Saat Hadiah koin emas subtugas 0, Hadiah koin emas tidak akan ditampilkan di detail
2. Buat halaman daftar Pencapaian baru dan tambahkan panduan "Buat Pencapaian"
3. Mengoptimalkan tampilan ikon widget
4. Menyelesaikan subtugas menambahkan efek suara (detail, halaman baru)
5. Setelah memasukkan konten di halaman baru atau edit (Item, produk, Pencapaian, Sintesis), klik tombol kembali, dan kotak konfirmasi untuk membuang perubahan harus muncul
6. Optimisasi pengurutan pembuatan produk (dalam kasus pengurutan kustom, produk yang baru ditambahkan harus prioritas teratas)
7. Saat mengedit Item/produk, metode input tidak boleh muncul otomatis
8. Halaman Item baru harus mendukung layar horizontal dan tidak ada kehilangan data
9. Adaptasi warna tema anggota untuk widget desktop
10. Mengoptimalkan kotak pemilihan produk, ubah tampilan lalu muat data secara asinkron
11. Label gudang juga menambahkan pintu masuk "Sintesis" dan "ATM"
12. Menempatkan operasi [Tetapkan sebagai selesai] dan [Undo] dalam perubahan status riwayat kembali ke menu tingkat pertama
13. Menambahkan pintu masuk cepat Pomodoro untuk detail acara
14. Optimisasi pengurutan daftar "Semua" toko (penambahan opsi pengelompokan berdasarkan daftar, hanya toko)
15. Setelah memilih hari dalam seminggu untuk diulang, waktu tenggat harus dihitung ulang. (Mencegah pengguna memilih hari kerja untuk diulang, dan tenggat masih tetap di Sabtu dan Minggu.)
16. Saat kembali ke halaman "Delegasi", jika tombol "+" tidak ditampilkan, tampilan akan dipicu.

*Perbaikan Bug*

1. Memperbaiki masalah di mana progres di daftar tidak di-refresh tepat waktu saat halaman Pencapaian dikonfigurasi ke bilah navigasi bawah
2. Masalah pergantian status Item riwayat diperbaiki
3. Perbaikan tampilan terlambat hitung mundur negatif
4. Pencapaian koin emas harus dimasukkan ke setoran di ATM
5. Memperbaiki masalah di mana saat Pomodoro dijeda, memasuki Pomodoro dua kali akan menyebabkan waktu dihapus
6. Memperbaiki batas pembelian mungkin menjadi tidak valid dalam keadaan tertentu
7. Memperbaiki masalah di mana catatan hitung mundur akan berulang dalam kasus langka
8. Memperbaiki masalah di mana mengklik kartu Tugas berbeda dengan cepat berturut-turut dapat menyebabkan konten Tugas salah satu kartu kosong setelah kembali ke halaman
9. Penyesuaian logika perhitungan otomatis koin emas dan Poin Pengalaman
10. Memperbaiki beberapa crash

**1.84.4 (2021/10/09)**

1. Memperbaiki masalah di mana ikon bawaan mungkin tidak ditampilkan

2. Memperbarui grup Q

**1.84.3 (2021/10)**

1. Memperbarui teks luar negeri

**1.84.2 (2021/09/26)**

1. Memperbaiki masalah deadlock yang mungkin disebabkan oleh Sintesis

2. Memperbaiki masalah efek penggunaan abnormal yang ditampilkan di detail produk yang tidak tersedia

3. Mengoptimalkan efek visual sudut membulat widget

**1.84.1 (2021/09/20)**

1. Memperbaiki masalah di mana jumlah pengulangan target tidak dapat dihapus saat mengedit

**1.84.0 (2021/09/19)**

***Fitur***

1. Sistem Keterampilan (kustomisasi Atribut)

   Semua mekanisme asli diadaptasi ke sistem kustomisasi Atribut, seperti Atribut Pencapaian mencapai kondisi buka kunci, Hadiah Poin Pengalaman produk, dll.

2. Kustomisasi efek yang dapat dimakan Pomodoro, memungkinkan Anda mengubah nilai Poin Pengalaman dan jenis Atribut

3. Ikon Toko mendukung perubahan gaya pemotongan (pengaturan Toko)

4. Detail produk sekarang menampilkan daftar efek penggunaan

5. Menambahkan warna tema anggota #6bab8b

6. Mendukung penghapusan akun kalender pengingat

***Peningkatan***

1. Halaman Pomodoro mendukung tampilan horizontal

2. Menambahkan deskripsi "Jumlah yang Dapat Dipinjam" di pengaturan produk

3. Menambahkan pengingat ukuran file sinkronisasi cloud

4. Memperbarui dependensi terkait Facebook dan Dropbox

5. Optimisasi sebagian tampilan UI halaman dan teks

6. Mengoptimalkan interaksi subtugas baru

***Perbaikan***

1. Memperbaiki masalah di mana versi ikon default Atribut tidak konsisten

2. Memperbaiki masalah di mana klik cepat untuk membuka kotak dapat menyebabkan pembukaan berulang atau crash

3. Memperbaiki masalah di mana acara kalender yang sudah diingatkan tidak dihapus secara sinkron saat menghapus Item

4. Memperbaiki status abnormal setelah mengatur Item dari "Selesai" ke "Terlambat" di halaman riwayat. Data historis seharusnya diperbaiki otomatis saat upgrade ke versi baru

5. Memperbaiki masalah di mana daftar yang dipilih saat ini salah ditandai di dialog pemilihan daftar saat membuat produk baru; dan tampilan daftar "semua" dihapus

6. Memperbaiki masalah mengedit konten lain + waktu pengulangan target, pengeditan akan gagal lagi

7. Halaman Pencapaian baru, memperbaiki masalah di mana pemilihan Atribut tidak dapat diedit dan dibiarkan kosong

8. Perbaikan bug minor dan optimisasi lainnya

**1.83.16 (2021/08/20)**

1. Memperbaiki crash dan ketidakefektifan modifikasi avatar dalam mode offline
2. Mengoptimalkan interaksi pemilihan efek pembukaan produk
3. Memperbaiki masalah fokus pada beberapa kotak input teks panjang
4. Memperbaiki masalah di mana batas waktu dan waktu pengingat ditampilkan salah dalam beberapa kasus
5. Memperbaiki masalah di mana perubahan konfigurasi mode ringkas tidak langsung berlaku

**1.83.15**

1. Mendukung penandaan Tugas penalti di widget App
2. Memperbaiki perilaku abnormal "melipat urusan non-tujuh hari"
3. Batas atas jumlah gambar Perasaan dinaikkan menjadi 9 gambar
4. Halaman login akan menampilkan metode login terakhir
5. Saat penalti dibatalkan (ditandai selesai), tidak ada Hadiah tambahan yang diberikan
6. Daftar pintar sekarang mendukung menampilkan Item yang selesai
7. Memperbaiki situasi abnormal pencadangan otomatis ke folder "download" dalam beberapa kasus
8. Memperbaiki beberapa masalah tampilan UI

**1.83.14**

1. Memperbaiki masalah di mana Pomodoro mungkin tidak merekam durasi saat menjalankan "lewati"
2. Memperbaiki masalah di mana Item penalti akan menjalankan logika terlambat dan penalti
3. Memperbaiki masalah terkait pengeditan penalti
4. Memperbaiki masalah terkait pemilihan gambar dalam mode lanskap
5. Memperbaiki kegagalan pemulihan sesekali saat memulihkan cadangan dari jalur kustom

**1.83.8-1.83.13**
Fitur

1. Mendukung pengaturan latar belakang kartu secara independen
2. Fungsi hapus catatan sekarang mendukung menghapus Perasaan, gudang, dan catatan penghitungan waktu
3. Pencapaian sistem dapat memilih apakah mendapat Hadiah Poin Pengalaman atau koin emas
4. Fungsi pencarian acara
5. Mendukung pencadangan otomatis lokal ke folder "download" (Android 10 ke atas)

Peningkatan

1. Meningkatkan metode pemanggilan pengingat notifikasi default, yang secara teori dapat meningkatkan tingkat keberhasilan notifikasi di atas Android 6
2. Menaikkan prioritas notifikasi timer Pomodoro ke [Tinggi], meningkatkan probabilitas kelangsungan timer latar belakang dan tampilan notifikasi
3. Di halaman, menambahkan tautan grup QQ dan situs web resmi, mengoptimalkan UI, QQ mendukung penambahan grup sekali klik
4. Meningkatkan waktu pemicu notifikasi Pencapaian, yang seharusnya diingatkan segera setelah dipicu di beranda
5. Menambahkan kotak centang "Terapkan hanya ke daftar saat ini" di opsi "Filter" daftar Item, dan memisahkan opsi default dan semua daftar
6. Menambahkan efek animasi saat komposit
7. Umpan balik: menambah saluran umpan balik komunitas Rabbit Xiaochao, memudahkan unggah gambar dan pelacakan masalah
8. Menambahkan tampilan nilai relatif di kotak input Item penghitungan
9. Mengoptimalkan efek tampilan Tab yang tidak dipilih
10. Menghapus prompt acak saat mengklik avatar, dan klik untuk masuk ke halaman pribadi
11. Saat Hadiah koin emas tidak diatur, akan ditampilkan sebagai "belum diatur" alih-alih "0"
12. Saat probabilitas pengaturan unboxing lebih rendah dari 0,01%, tidak lagi menampilkan "0,00%" melainkan "<0,01%"
13. Saklar Perasaan tidak lagi diingat, dan dimatikan secara default
14. Mengoptimalkan proses permohonan izin kalender dan kamera
15. Mengoptimalkan efek klik dan efek tampilan beberapa halaman
16. Mengoptimalkan metode pengingat kalender, mencoba menyelesaikan masalah di mana beberapa perangkat mungkin menghapus akun kalender

Perbaikan

1. Memperbaiki masalah crash pemfilteran berkelanjutan di halaman Perasaan
2. Mencoba memperbaiki crash langka kotak dialog yang diatur out of the box
3. Memperbaiki masalah di mana saat kotak input panjang, mengklik teks akan otomatis melompat ke bawah
4. Memperbaiki masalah di mana Hadiah koin emas acak tidak dapat diatur saat membuat tim
5. Versi distribusi domestik sepenuhnya menghapus dependensi terkait Firebase
6. Memperbaiki pengecualian sesekali saat menyegarkan halaman daftar Pencapaian
7. Memperbaiki crash abnormal sesekali saat memilih ikon bawaan
8. Memperbaiki masalah di mana subtugas masih terlihat saat kembali ke halaman detail setelah menghapus semua subtugas
9. Memperbaiki masalah di mana nama daftar default Sintesis tidak dapat diedit
10. Memperbaiki masalah di mana kotak filter akan ditampilkan di halaman profil
11. Memperbaiki masalah di mana Item tim tidak dapat diwarisi setelah mengatur Hadiah produk

**1.83.7 (2021/06/24)**

1. Daftar diurutkan berdasarkan koin emas yang ditambahkan
2. Menambahkan pemilihan bahasa di halaman panduan
3. Mengoptimalkan kecepatan pemuatan halaman Pencapaian
4. Mengubah grup QQ menjadi informasi bergabung sekali klik
5. Memperbaiki masalah di mana klik berkelanjutan saat unboxing dapat memicu perubahan Inventaris berkali-kali
6. Memperbaiki tampilan salah Item terlambat tunggal di daftar Item harian

**1.83.6 (2021/06/22)**

Fitur

1. (Anggota) Mendukung pengaturan latar belakang kartu secara independen
2. Fungsi hapus catatan sekarang mendukung menghapus Perasaan, gudang, dan catatan penghitungan waktu
3. Pencapaian sistem dapat memilih apakah mendapat Hadiah Poin Pengalaman atau koin emas
4. Fungsi pencarian acara
5. Mendukung pencadangan otomatis lokal ke folder "download" (Android 10 ke atas)

Optimisasi

1. Meningkatkan metode pemanggilan pengingat notifikasi default, yang secara teori dapat meningkatkan tingkat keberhasilan notifikasi di atas Android 6
2. Menaikkan prioritas notifikasi timer Pomodoro ke [Tinggi], meningkatkan probabilitas kelangsungan timer latar belakang dan tampilan notifikasi
3. Di halaman, menambahkan tautan grup QQ dan situs web resmi, mengoptimalkan UI, QQ mendukung penambahan grup sekali klik
4. Meningkatkan waktu pemicu notifikasi Pencapaian, yang seharusnya diingatkan segera setelah dipicu di beranda
5. Menambahkan kotak centang "Terapkan hanya ke daftar saat ini" di opsi "Filter" daftar Item, dan memisahkan opsi default dan semua daftar
6. Menambahkan efek animasi saat komposit
7. Umpan balik: menambah saluran umpan balik komunitas Rabbit Xiaochao, memudahkan unggah gambar dan pelacakan masalah
8. Menambahkan tampilan nilai relatif di kotak input Item penghitungan
9. Mengoptimalkan efek tampilan Tab yang tidak dipilih
10. Menghapus prompt acak saat mengklik avatar, dan klik untuk masuk ke halaman pribadi
11. Saat Hadiah koin emas tidak diatur, akan ditampilkan sebagai "belum diatur" alih-alih "0"
12. Saat probabilitas pengaturan unboxing lebih rendah dari 0,01%, tidak lagi menampilkan "0,00%" melainkan "<0,01%"

**1.83.0-alpha04 (2021/05/23)**

1. Mendukung konfigurasi bebas, pengurutan, dan penonaktifan modul bawah
   Modul perlu diadaptasi secara bertahap di masa depan, dan saat ini hanya mendukung beberapa modul fungsional (seperti Pomodoro, riwayat belum diadaptasi)
2. Mode jeda kedua ditambahkan ke efek hitung mundur produk, yang akan tetap di bilah notifikasi dan dapat dilanjutkan kapan saja
    Dan menambahkan logo "experimental"
3. Saat memilih melewati Pomodoro, menambahkan pengingat bahwa Anda tidak dapat mendapatkan Pomodoro
4. Menambahkan petunjuk untuk memperluas dan menutup Tugas contoh
5. Memperbaiki crash yang mungkin disebabkan oleh tata letak di bagian atas daftar di beberapa halaman
6. Mengoptimalkan prompt error jaringan saat jaringan terputus
7. Mengoptimalkan pengingat Hadiah koin emas saat menyelesaikan subtugas, diubah menjadi pengingat Toast non-obstruktif

**1.83.0-alpha03 (2021/05)**

1. Memperbaiki masalah di mana tampilan tata letak kosong halaman komposit mungkin melebihi layar
2. Memperbaiki masalah di mana nama Atribut "Charm" pada halaman yang baru dibuat ditampilkan salah
3. Memperbaiki beberapa masalah pengaturan koin emas
4. Mengoptimalkan efek animasi halaman Pencapaian untuk menyesuaikan skenario di bilah navigasi bawah
    (Sudah diadaptasi tetapi antarmuka belum siap, harap tunggu pembaruan selanjutnya)
5. Meningkatkan versi SDK target ke Android 11
6. Memperbaiki masalah tampilan tata letak kosong halaman "Moment"
7. Memperbaiki masalah perhitungan bunga abnormal

**1.83.0-alpha02 (2021/05/16)**

1. Memperbaiki masalah di mana resep Sintesis dapat dibuat di daftar "Semua"
2. Setelah memasuki antarmuka sistem Sintesis, tidak peduli daftar mana Anda berada, konten tampilan aktual adalah daftar "Semua".
3. Perbaikan sederhana metode perhitungan bunga ATM

**1.83.0-alpha01 (2021/05/16)**

1. Sistem Sintesis lengkap, mendukung implementasi Sintesis N-ke-N apa pun
   - Daftar periksa
   - Baru/Edit
   - Dialog Sintesis
   - Mode malam dan dukungan multi-bahasa
   - "Pintu masuk" ada di bagian atas halaman Toko
2. Refaktor kode internal halaman Item baru
    Untuk skalabilitas App, kami hampir sepenuhnya merapikan kode Item yang baru dibuat, dan mungkin juga mendesain ulang UI di masa depan.
    Pembaruan alpha selanjutnya juga akan menambahkan "tanggal pengulangan target", "waktu pengingat relatif", "Item tipe penalti (akan ditentukan)" dan fungsi lainnya.
    Jika Anda mengalami masalah, Anda dapat beralih ke versi lama halaman kapan saja.

3. Menambahkan pintu masuk ATM di bagian atas Toko
4. Lampiran Item mendukung hingga 9 gambar, dan jalur penyimpanan telah disesuaikan
5. Fungsi TAG tim
    Implementasinya sudah built-in, tetapi konten TAG spesifik belum dikonfigurasi, sehingga sementara tidak ditampilkan

**1.82.16 (2021/05)**

1. Memperbaiki masalah di mana Item contoh tidak dapat menjalankan logika terlambat dengan benar (hanya berlaku untuk pengguna baru)
2. Memperbaiki masalah di mana jumlah penyelesaian Item tak terbatas dalam skenario tertentu akan kurang 1 kali

**1.82.15 (2021/05)**

1. Memperbaiki masalah pemutaran efek suara latar belakang

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Memperbaiki masalah di mana Item tak terbatas dapat menyebabkan daftar memuat lambat dan jumlah pembatalan tidak akurat
2. Memperbaiki masalah di mana penyelesaian Tugas di widget desktop mungkin memutar efek suara selesai berkali-kali
3. Memperbaiki masalah di mana jumlah total Item teratas di daftar pintar tidak akurat
4. Mendukung hapus semua data lokal dan fungsi hapus akun
5. Memperbaiki masalah di mana pengeditan subtugas Item tim tidak dapat diwarisi

**1.82.12 (2021/05)**

1. Memperbaiki masalah penghitungan undo selesai Item tak terbatas
2. Memperbaiki masalah di mana Item beku masih diingatkan
3. Beberapa optimisasi dilakukan pada pergantian daftar, yang mungkin meningkatkan kecepatan pergantian perangkat lama dan menambahkan animasi pemuatan
4. Memperbaiki masalah di mana efek suara akhir istirahat kustom tidak berlaku, dan mendukung pengaturan efek suara akhir penghitungan waktu produk
5. Memperbaiki masalah di mana Pomodoro tidak dapat menghitung waktu Fokus saat menggunakan operasi "lewati"
6. Memperbaiki masalah di mana tombol jeda hitung mundur produk tidak berlaku

**1.82.11 (2021/05)**

1. Memperbaiki masalah penghitungan undo selesai Item tak terbatas
2. Memperbaiki masalah di mana Item beku masih diingatkan
3. Beberapa optimisasi dilakukan pada pergantian daftar, yang mungkin meningkatkan kecepatan pergantian perangkat lama dan menambahkan animasi pemuatan
4. Memperbaiki masalah di mana efek suara akhir istirahat kustom tidak berlaku, dan mendukung pengaturan efek suara akhir penghitungan waktu produk
5. Mendukung bahasa Rusia

**1.82.10 (2021/05)**

1. Memperbaiki masalah di mana Pomodoro tidak dapat menghitung waktu Fokus saat menggunakan operasi "lewati"
2. Memperbaiki masalah di mana tombol jeda hitung mundur produk tidak berlaku
3. Menangkap crash yang disebabkan oleh kegagalan membuat pengingat kalender

**1.82.9 (2021/05)**

1. Memperbaiki masalah di mana batas waktu Item yang disalin mungkin dikosongkan, dan dapat menyebabkan crash saat diulang
2. Mengoptimalkan kecepatan refresh setelah menyelesaikan Item tak terbatas
2. Memperbaiki masalah perhitungan waktu pengingat untuk Tugas tim
3. Memperbaiki masalah di mana penyelesaian geser dapat menyebabkan animasi tidak berakhir dengan benar dan tetap kosong
4. Tugas tim seharusnya mendukung pengabaian dengan geser
5. Pengenalan produk di jendela pembelian mendukung browsing geser

**1.82.8 (2021/04/28)**

**fitur**

1. Menambahkan tampilan streak selesai saat ini
2. Efek hitung mundur Item Toko dioptimalkan, dan dua operasi akhir dan jeda ditambahkan; dihitung dalam waktu absolut saat dihentikan secara abnormal
3. Mendukung pengaturan mode getar dan saklar bel Pomodoro secara terpisah
4. Sebagian mendukung pratinjau tenggat waktu mendatang acara yang sedang berlangsung di kalender
5. Mendukung memulai ulang acara tunggal dan tak terbatas
6. Memodifikasi tampilan data di halaman "Saya", dan mengubah "Terlambat" dan "Menyerah" menjadi "Pencapaian (Terbuka)" dan "Perasaan"; sekarang halaman statistik menampilkan jumlah "Terlambat" dan "Ditinggalkan"
7. Mendukung langsung mendaftar membuat widget dari halaman pengaturan "widget desktop" (hanya di Android 8 ke atas)

**peningkatan**

1. Mendukung melihat gambar besar Item Toko
2. Mengoptimalkan masalah konsumsi daya yang mungkin disebabkan oleh penghitungan langkah
3. Memperbaiki beberapa masalah tampilan saat font terlalu besar
4. Mengoptimalkan pembatalan Item tak terbatas
5. Mengoptimalkan tampilan notifikasi Pomodoro dan menambahkan tampilan bilah progres
6. Setelah acara selesai, hapus pengingat notifikasi yang sedang ditampilkan
7. Mengoptimalkan statistik pemasukan dan pengeluaran koin emas
8. Menambahkan beberapa panduan dan tips pengguna
9. Saat mengedit Item, mendukung menghapus pilihan Hadiah produk
10. Saat menangani crash berkelanjutan, menambahkan pemberitahuan "Masalah Diketahui"
11. Mengoptimalkan efek tampilan saat Atribut tidak dipilih

【perbaikan】

1. Setelah beranda mengurutkan daftar, status harus segera di-refresh
2. Memperbaiki masalah di mana halaman detail tidak segera me-refresh daftar subtugas
3. Memperbaiki paksa masalah crash login otorisasi Weibo
4. Memperbaiki masalah di mana nama Item yang mungkin ditampilkan di notifikasi Pomodoro salah
5. Memperbaiki masalah di mana tampilan hitung mundur notifikasi Pomodoro tidak akurat
6. Memperbaiki masalah di mana kotak Hadiah tidak muncul saat Item dan Pencapaian hanya memiliki Hadiah merchandise
7. Memperbaiki masalah tidak dapat membeli 0 koin emas dalam keadaan tertentu
8. Mengoptimalkan metode perhitungan perbaikan Item Ebbinghaus
9. Mengoptimalkan metode perhitungan jumlah penyelesaian hari ini untuk acara tak terbatas

**1.82.7 (2021/04/10)**

1. Memperbaiki tampilan UI saat data kosong di layar [Moments]
2. Ukuran font akan mengikuti pengaturan sistem lagi
3. Memperbarui terjemahan Inggris dan Portugis

**1.82.5 (2021/04/02)**

1. Memperbaiki beberapa masalah catatan Pomodoro
2. Menambahkan beberapa panduan baru

**1.82.4-alpha01/beta (2021/03/25)**

1. Memperbaiki Hadiah Kotak Jarahan
2. Lihat Perasaan Tugas yang dipilih
3. Hadiah Poin Pengalaman/koin emas acak untuk Pencapaian kustom
4. Tugas di daftar pintar sekarang akan dikelompokkan berdasarkan daftar
5. Pengulangan tahunan
6. Lebih banyak peningkatan dan perbaikan bug

**1.82.1 (2021/03/12)**

1. Memperbaiki beberapa masalah daftar pintar
2. Memperbaiki masalah di mana bilah progres mungkin tidak berubah setelah menyelesaikan Tugas
3. Memperbaiki masalah paksa selesai Tugas penghitungan
4. Memperbaiki masalah di mana menampilkan "NULL" di dialog bawah terlambat

**1.82.0 (2021/03/11)**

1. Daftar pintar
2. Mendesain ulang ikon Atribut
3. Efek Item baru "Hitung mundur"
4. Timer Pomodoro akan terus merekam waktu ekstra setelah timer selesai, dan Anda dapat memilih memperbarui waktu Fokus dan mendapat Hadiah ekstra.
5. Tugas penghitungan sekarang dapat dipaksa selesai saat belum mencapai target.
6. Sekarang Anda dapat memilih menyelesaikan Tugas yang belum dimulai, dan memutuskan apakah menunda waktu
7. Lebih banyak perbaikan masalah dan peningkatan

**1.81.6**

1. Memperbaiki masalah petunjuk pengingat Pomodoro

**1.81.5 (2021/03/02)**

1. Terjemahan Italia (sebagian)
2. Memperbaiki ikon notifikasi
3. Memperbaiki pengingat yang tidak berfungsi baik dengan pengulangan hari kerja
4. Memperbaiki pilihan "ambil foto" yang tidak berfungsi
5. Lebih banyak perbaikan minor

**1.81.0~1.81.4**

1. Mendesain ulang sebagian UI dan animasi
2. Tugas akan otomatis selesai saat semua subtugas-nya selesai
3. Memperbaiki bug perubahan multi Poin Pengalaman
4. Memperbaiki bug pemulihan Dropbox
5. Sekarang Anda dapat mengembalikan Item tanpa mendapat koin
6. Pengaturan tampilan jam 12 jam
7. Bekukan/Cairkan beberapa Tugas

**1.80.7（2021/01/26)**

1. Menambahkan statistik Item Toko
2. Mendesain ulang dialog deskripsi Atribut
3. Deskripsi Atribut kustom
4. Menambahkan pengaturan konfigurasi untuk mode ringkas: sembunyikan semua info ekstra
5. Memperbaiki bug pemulihan dari file cadangan
6. Lebih banyak perbaikan dan peningkatan...

**1.80.6（2021/01/22)**

1. Sekarang Item dengan efek Kotak Jarahan dapat dibagikan ke pasar
2. Halaman pencarian baru: sekarang Anda dapat mencari pengguna berdasarkan nama panggilan
3. Filter Item tim/pasar dengan rentang waktu
4. Notifikasi tambah Tugas cepat
5. File media dapat diabaikan saat melakukan pencadangan.
6. Lebih banyak perbaikan dan peningkatan...

**1.80.5（2021/01/14)**

1. Buka 10/50 Kotak Jarahan sekali klik
2. Menambahkan kondisi buka kunci [Dapatkan Item terpilih sejumlah kali dari Kotak Jarahan]
3. Pengaturan suku bunga ATM
4. Input angka untuk menjual/makan tomat
5. Efek suara akhir timer istirahat kustom
6. Menambahkan beberapa panduan pengguna
7. Memperbaiki beberapa masalah dan melakukan beberapa peningkatan

**1.80.4（2021/01/04)**

1. Memperbaiki crash di Android 6

**1.80.3（2021/01/04)**

1. Pemotongan gambar gaya bebas
2. Lihat/Tambah ikon Item di pasar
3. Saat memilih Tugas/Item, sekarang Anda dapat langsung membuat yang baru
4. Mendukung aksi COPY untuk Pencapaian pengguna
5. Banyak perbaikan dan peningkatan

**1.80.0（2020/12/24)**

1. Efek Item Kotak Jarahan!
2. Terintegrasi dengan pencadangan Dropbox
3. Konfigurasi untuk mode ringkas
4. Menambahkan bilah riwayat pilihan foto
5. Banyak perbaikan dan peningkatan

**1.79.x（2020/12)**

1. 3 pengaturan kondisi buka kunci lagi
2. Pengaturan efek suara kustom
3. Atur Hadiah Item untuk Pencapaian
4. Halaman catatan timer Pomodoro
5. Buat Tugas dari halaman Kalender
6. 5 warna tema baru.
7. Banyak peningkatan dan perbaikan

**1.78.x（2020/11)**

1. Kondisi buka kunci Pencapaian kustom
2. Poin Pengalaman Tugas kustom
3. Banyak peningkatan dan perbaikan

**1.77.1（2020/11/05)**

1. Toolbar pergantian daftar
2. Saklar tampilkan Tugas selesai
3. Daftar sekarang dapat diarsipkan
4. Menambahkan kartu status koin
5. Sekarang Anda dapat membuat Perasaan untuk Pencapaian pengguna
6. Menambahkan pengaturan untuk mengikuti mode malam sistem

**1.77.0（2020/10/28)**

1. Menambahkan modul Pasar untuk komunitas, di mana Anda dapat membagikan desain Item Toko atau mengimpor Item
2. Memperbaiki logika pengulangan bulan
3. Memperbaiki pencadangan otomatis WebDAV tidak berfungsi saat belum pernah mencadangkan setidaknya sekali

**1.76.0（2020/10/13)**

1. Koin default subtugas
2. Menambahkan ikon in-app untuk membuat Item Toko dan Pencapaian
3. Harga tomat kustom
4. Pengaturan aktifkan efek suara global
5. Sekarang Perasaan dapat dicari berdasarkan konten Tugas

**1.75.2（Released at 2020/10/05）**

1. Pengaturan jumlah koin default subtugas
2. Menambahkan 100+ ikon yang dapat dipilih sebagai ikon Item Toko/Pencapaian
3. Menambahkan pengaturan "Aktifkan efek suara"
4. Filter Perasaan berdasarkan konten Tugas dan UI filter yang lebih baik
5. Buat pintasan Pomodoro
6. Harga jual tomat kustom
7. Halaman Pomodoro akan menjaga layar tetap hidup saat hitung mundur
8. Memperbaiki beberapa masalah

**1.75.1（Released at 2020/09/20）**

1. Memperbaiki banyak bug 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Pomodoro gamifikasi
2. Warna tag Tugas/daftar kustom
3. Pencadangan otomatis WebDAV
4. Pengaturan sembunyikan modul
5. Banyak peningkatan dan perbaikan

**1.74.2（Released at 2020/08/23）**

1. Bahasa Portugis

**1.74.0（Released at 2020/08/13）**

1. ATM: Setor & tarik koin
2. Sekarang mendukung memilih Item Toko sebagai Hadiah Tugas
3. Pengaturan kuantitas stok Item Toko
4. Meningkatkan animasi dan memperbaiki beberapa bug
5. Menambahkan petunjuk untuk pengaturan Frekuensi Pengulangan
6. Lainnya.. (deskripsi pembaruan nanti)

**1.73.0（Released at 2020/07/26）**

**Fitur:**

- Pencapaian pengguna
- Animasi penurunan Poin Pengalaman
- Edit waktu selesai catatan riwayat
- Pengaturan koin subtugas tim

**Peningkatan:**

- Menambahkan efek suara koin

**Perbaikan:**

- Masalah kehilangan pengaturan koin subtugas setelah mengulang Tugas

**1.72.1（Released at 2020/06/14）**

**Fitur:**

- Hapus data Pencapaian

**Peningkatan:**

- Tampilan deskripsi Item Toko yang lebih baik

**Perbaikan:**

- Masalah mengedit gambar Item Toko
- Masalah mengedit teks Perasaan

**1.72.0（Released at 2020/06/11）**

**Fitur:**

- Pengingat subtugas
- Koin subtugas
- Widget App
  1. Pengaturan Opacity
  2. Tampilkan Jumlah Koin
  3. Tampilkan Dialog Input Tugas Penghitungan
- Pilihan Waktu Halaman Statistik
- Inventaris: Kembalikan Item
- Tambah dukungan subtugas untuk tim

**Peningkatan:**

- Geser Tugas penghitungan sekarang akan menambah 1 waktu selesai alih-alih menandainya selesai
- Menambahkan Tombol Bantu Terjemahkan
- Menambahkan Pengaturan Hadiah Multi Poin Pengalaman untuk Tugas penghitungan

**Perbaikan:**

- Memperbaiki bagian transparan gambar png yang tampil hitam setelah pemotongan.
- Memperbaiki Widget App yang tidak berfungsi baik di beberapa perangkat.
- Memperbaiki Jumlah Koin yang tampil di Halaman Detail saat diatur ke 0.
- Memperbaiki Geser untuk Selesai (mode tanpa dialog) yang membuat halaman ditampilkan salah
- Memperbaiki subtugas tidak dapat dibuat saat mengklik tombol ENTER di beberapa perangkat

**1.71.3/1.71.4（Released at 2020/04/16）**

**Perbaikan minor tentang ikon dan laporan crash**

**1.71.2（Released at 2020/04/14）**

**Fitur:**

- Bahasa Turki (terima kasih **İbrahim DOĞAN** telah membantu terjemahan)

- Kustomisasi latar belakang dan opacity kartu Tugas
- Kustomisasi teks tombol aksi Item Inventaris
- Favorit Perasaan
- Pencarian Perasaan

**Peningkatan:**

- Ikon Baru

- Tipe laporan mendukung beberapa bahasa
- Meningkatkan UI Halaman Pengaturan
- Meningkatkan metode pergantian warna tema dan bahasa. Tidak perlu restart App agar berlaku.
- Meningkatkan halaman potong gambar
- Meningkatkan UI daftar pilihan
- Menambahkan deskripsi Item Toko yang ditampilkan di halaman daftar Toko

**Perbaikan:**

- Memperbaiki bug tanggal buka kunci Pencapaian ditampilkan salah
- Memperbaiki bug gambar Item Toko tampil kosong saat file dihapus.
- Tidak menghapus status subtugas setelah Tugas tunggal menjadi terlambat.
- Memperbaiki bug ruang tidak cukup untuk Tingkat Kesulitan tampil di Halaman Detail Tugas.
- Memperbaiki bug setelah mengatur Tugas terlambat ke selesai, jumlah selesai Tugas berikutnya tidak ditambah satu.
- Memperbaiki bug jumlah koin maksimum tidak ditampilkan dengan benar di pengaturan default Tugas.
- Membuat halaman cadangan/pemulihan data dapat di-scroll.
- Memperbaiki geser untuk menyelesaikan Tugas tidak berfungsi baik saat geser cepat beberapa Tugas.
- Widget App sekarang akan menampilkan status Beku
- Memperbaiki bug bilah progres di halaman Tugas kadang menampilkan progres salah

**Perbaikan Server（2020/4/13）**

- Memperbaiki fungsi laporan yang tidak berfungsi

**v1.71.1 (Released at 2020/03/17)**

**Peningkatan:**

- Animasi bilah progres yang lebih baik di halaman Tugas

**Perbaikan:**

- Memperbaiki bug yang dapat menyebabkan crash saat meluncurkan App di beberapa perangkat
- Memperbaiki bug tentang memilih foto

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Fitur:**

- Fitur Perasaan

- Menambahkan Aksi Geser: Selesaikan Tugas (Tanpa Dialog)

**Perbaikan:**

- Memperbaiki bug status kartu Tugas ditampilkan salah

- Memperbaiki bug Tugas yang di-undo mungkin hilang saat terlambat

- Memperbaiki pengurutan terpilih tidak ditampilkan dengan benar

**v1.70.6 (Released at 2020/03/09)**

**Peningkatan:**

- Membuat warna petunjuk Pencapaian terbuka sama dengan warna tema

**Perbaikan：**

- Memperbaiki status dialog terlambat tidak ditampilkan dengan benar setelah mengklik tombol

- Memperbaiki bug COPY tidak dapat menyalin subtugas
- Memperbaiki crash saat menggunakan "Pindah Ke..."
- Memperbaiki Kartu Pilihan tidak ditampilkan dengan benar di beberapa perangkat

**v1.70.5 (Released at 2020/03/06)**

**Perbaikan：**

- Kartu To-Do terus loading saat mengubah warna tema atau mengaktifkan/menonaktifkan mode malam

**v1.70.4 (Released at 2020/03/05)**

**Peningkatan：**

- Halaman Toko akan menampilkan jumlah koin saat tidak ada Item
- Dapat mengakses Halaman Detail Koin dengan mengklik jumlah koin di Halaman Toko
- Meningkatkan format teks widget App dalam bahasa Inggris
- Dapat mengakses Halaman Detail Tugas dengan mengklik Tugas di Widget App

**Perbaikan：**

- Gaya tampilan aktivitas tim salah

**v1.70.3 (Released at 2020/03/05)**

**Peningkatan:**

- Halaman Toko sekarang akan menampilkan jumlah koin saat tidak ada Item
- Klik jumlah koin di Halaman Toko untuk masuk Halaman Detail Koin
- Meningkatkan format teks Inggris di Widget App
- Klik Item Widget App untuk masuk Halaman Detail Tugas

**Perbaikan：**

- Memperbaiki saat Filter Hari Ini, petunjuk footer "xx Tugas belum dimulai" tidak tampil setelah menyelesaikan Tugas

**v1.70.3 (Released at 2020/03/05)**

**Perbaikan Penting:**

- Memperbaiki bug tentang input jumlah koin
- Memperbaiki bug subtugas tidak di-refresh dengan benar
- Memperbaiki bug tidak dapat menyukai aktivitas orang lain
- Memperbaiki bug Widget App tidak dapat menyelesaikan Tugas

**v1.70.2 (Released at 2020/03/04)**

**Fitur：**

- Komunitas sekarang tersedia untuk semua zona waktu

- Salin Tugas
- Mendukung edit pengaturan default Tugas baru
- Daftar Toko

- Meningkatkan aksi Widget App
- Menambahkan menu untuk Tugas berakhir di Halaman Kalender

**Peningkatan**：

- Meningkatkan animasi kartu Tugas

- Menghapus izin yang tidak diperlukan
- Menambahkan suara selesai
- Meningkatkan gaya UI Halaman Riwayat
- Menambahkan Dialog "Izin Baca/Tulis Kalender Hilang" saat mengaktifkan Pengingat Kalender Sistem dan izin belum diberikan

**Perbaikan：**

- Memperbaiki bug tentang Tugas Penghitungan dalam mode ringkas
- Memperbaiki bug tentang Tugas berulang
- Memperbaiki crash yang mungkin terjadi saat menghapus subtugas
- Memperbaiki crash saat memasukkan URL WebDAV salah
- Memperbaiki warna tema salah ditampilkan, yang mungkin terjadi setelah memulihkan cadangan


### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**✨ Fitur**

1. Mendukung Manajemen Arsip

- Cadangan ke komputer
- Pulihkan dari komputer
- Mendukung drag-and-drop

2. Mendukung Membuat Perasaan Baru

- Mendukung pemilihan gambar
- Mendukung sinkronisasi gambar ke ponsel

3. Mendukung Tampilan Detail Tugas
4. Peningkatan Sistem Pembelian

- Menggunakan API "Purchase Items" baru
- Menjaga batas pembelian konsisten dengan App

5. Mendukung Validasi API Token Opsional
6. Dukungan Multi-platform

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Meningkatkan penanganan error dan notifikasi

**v1.1.1 (2023/08/29)**

**🔧 Optimisasi dan perbaikan bug**

1. Memperbaiki perilaku tak terduga saat memasukkan koin
2. Memperbaiki masalah pemeriksaan pembaruan yang dapat menyebabkan App crash

**v1.1.0 (2023/06/25)**

**✨ Fitur**

1. Mendukung pemeriksaan otomatis alamat IP dan koneksi "LifeUp Cloud" (memerlukan LifeUp Cloud v1.3.0)
2. Mendukung menambahkan Tugas, meskipun opsi yang saat ini didukung masih terbatas (Diperbaiki [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Mendukung mengekspor Perasaan ke format markdown (Diperbaiki [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Menambahkan teks bahasa Tionghoa Tradisional
5. Menambahkan versi rilis macOS
6. Mendukung pemeriksaan pembaruan

**🔧 Optimisasi dan perbaikan bug**

1. Memperbaiki masalah subkategori Pencapaian tidak dapat ditampilkan dengan benar
2. Memperbaiki masalah beberapa ikon tidak dapat ditampilkan dengan benar (memerlukan LifeUp v1.91.3)
3. Memperbaiki masalah ketidakcocokan judul (Diperbaiki [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Menambahkan opsi pintasan untuk installer Windows (Diperbaiki [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Meningkatkan cara mendapatkan ukuran jendela, menyesuaikan resolusi di bawah 1080p

**v1.0.2 (2023/02/20)**

1. Menambahkan pop-up laporan error yang lebih detail [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Meningkatkan konfigurasi pengemasan

**v1.0.1 (2023/02/12)**

1. Rilis pertama

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**✨ Fitur**

1. Mengekspos waktu penyelesaian subtugas (`endTime`) di model data SDK dan respons HTTP API.

**v2.1.0 (2026/03/22)**

**✨ Fitur**

1. Menambahkan dukungan konfigurasi locale dan pembaruan lokalisasi Top-14.
2. Mengekspos field progres hitungan dan kondisi akhir pengulangan untuk Tugas API.

**🐛 Perbaikan Bug**

1. Memperbaiki masalah kompatibilitas ContentProvider.
2. Menyesuaikan UI Android 15 dan perilaku startup layanan.

**v2.0.0 (2025/01/01)**

**✨ Fitur**

1. Optimisasi Layanan

- Meningkatkan logika penemuan layanan dan kompatibilitas
- Lebih banyak perangkat mendukung deteksi IP otomatis
- Mengoptimalkan transisi status mulai/jeda layanan
- Meningkatkan penanganan error dan notifikasi

2. Keamanan & Performa

- Menambahkan validasi API Token opsional
- Menambahkan opsi konfigurasi CORS
- Mendukung pengaturan port kustom
- Mendukung durasi wake lock kustom

3. Peningkatan UI

- Desain antarmuka yang sepenuhnya baru
- Meningkatkan pengalaman visual secara keseluruhan

**v1.3.0 (2023/06/25)**

**✨ Fitur**

1. Mendukung pendaftaran layanan mDNS agar desktop dapat menemukan IP secara otomatis (memerlukan desktop v1.1.0)
2. Menambahkan nilai hasil untuk API yang dipanggil melalui ContentProvider.

**♻️ Peningkatan**

1. Memperluas area klik tombol pemindaian kode QR
2. Memperbaiki crash ActivityNotFound

**v1.2.0 (2023/03/10)**

1. Mendukung pemindaian kode QR untuk memanggil API
2. Meningkatkan tampilan daftar IP

**v1.1.2 (2023/02/12)**

1. Mendukung kueri data lengkap melalui Content Provider, digunakan untuk mendukung fungsi desktop
2. Menstandarkan konten respons HTTP

**v1.0.3-preview (2022/11/22)**

1. Rilis pertama (ditambah beberapa perbaikan bug rilis pertama)

<!-- tabs:end -->

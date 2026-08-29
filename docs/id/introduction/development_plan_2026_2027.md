# Rencana Pengembangan 2026-2027

> [!IMPORTANT]
> Ini adalah rencana pengembangan kami saat ini. Kami akan berusaha sebaik mungkin memandu peningkatan dan pembaruan produk sesuai rencana ini. Namun, karena lingkungan yang terus berubah, isi rencana pengembangan dapat dimodifikasi atau ditambah/dikurangi. Rilis produk aktual yang berlaku.

### I. Rencana Pengembangan

> Diperbarui: 2026/04

Berbeda dari 2024-2025, kami berharap terus meningkatkan modul yang ada di LifeUp dan **ulives** pada 2026-2027, alih-alih menambah modul fungsional baru.

| Modul | Subfunksi | Alasan Kebutuhan | Prioritas | Hasil |
| ---- | ------ | -------- | ------ | ---- |
| Integrasi Kalender | - Sinkronisasi Dua Arah Google Calendar<br/>- Sinkronisasi Dua Arah Kalender Sistem | - Banyak umpan balik dari luar negeri.<br/>- LifeUp adalah alat to-do dengan fungsi yang tumpang tindih tetapi tidak konsisten dengan app jadwal (kalender). Mengembangkan semua fitur kalender di LifeUp akan sangat besar. Integrasi eksternal mungkin solusi yang lebih baik. | P0 | 🚧 |
| Optimasi Fitur Crafting | - Integrasi dengan Toko<br/>- Filtering yang ditingkatkan | - Crafting adalah salah satu fitur inti LifeUp. Terus mengoptimalkan integrasinya dengan Toko dan efisiensi filtering untuk meningkatkan kenyamanan pengguna. | P0 | ✅ Dirilis |
| Optimasi Fitur Item | - Efek penggunaan lebih kaya (ubah jumlah Item lain)<br/>- Efek suara pemicu<br/>- Dukung batas penggunaan<br/>- Kondisi batas diperluas | - Sistem Item inti gamifikasi LifeUp. Sedang disetel di v1.103, terus meningkatkan fleksibilitas dan gameplay Item. | P0 | 🚧 Penyetelan v1.103 |
| Optimasi Fitur Atribut | - Sub-kategori Atribut (pengelompokan)<br/>- Dukung sistem Title<br/>- Dukung tipe [Status]<br/>- Optimasi halaman Status<br/>- Widget Life Level | - Sistem Atribut inti gamifikasi lainnya. Kami akan terus meningkatkan sistem Atribut dengan kustomisasi dimensi dan tampilan lebih banyak. | P0 | 🚧 Sub-kategori dirilis, lainnya dalam perencanaan |
| Optimasi Fitur Tugas | - Edit tag eksplisit dan filtering<br/>- Optimasi interaksi edit sub-Tugas<br/>- Perilaku penyelesaian paksa sub-Tugas kustom<br/>- Perilaku overdue atau push kustom | - Tugas adalah fitur inti LifeUp, terus mengoptimalkan pengalaman edit dan interaksi Tugas. | P1 | 🚧 |
| Hadiah Batch Tugas Hitung | - Dukung klaim Hadiah batch untuk Tugas hitung | - Mekanisme Hadiah Tugas hitung saat ini relatif sederhana, Hadiah batch dapat memberi insentif tujuan lebih fleksibel. | P1 | 🚧 |
| Optimasi Fitur Thought/Reflection | - Dukung lebih banyak gaya browsing | - Fitur Thought ciri khas LifeUp, terus mengoptimalkan tampilan dan interaksinya. | P2 | 🚧 |
| Perluasan Pencapaian | - Statistik tipe mingguan/bulanan/tahunan<br/>- Kondisi buka Pencapaian lain | - Sistem Pencapaian butuh kondisi buka lebih beragam untuk pengalaman Pencapaian lebih kaya. | P2 | 🚧 |
| Sistem Data | - Backup terpisah data dan gambar<br/>- Dukung ekspor/impor data sebagian<br/>- Dukung pergantian multi-file bawaan | - Upload WebDAV file besar mudah gagal, layanan cloud gratis punya batas trafik, backup penuh dengan gambar terlalu besar.<br/>- Ekspor/impor sebagian dapat dipakai pengguna untuk berbagi sistem Hadiah.<br/>- Multi-file bawaan memungkinkan pengguna langsung beralih antar sistem untuk debugging tanpa menghapus data berulang. | P1 | 🚧 |
| API | - Perluas kemampuan dan cakupan API ke semua fungsi dasar | - Masih kurang beberapa API seperti operasi terkait thought.<br/>- LifeUp tidak bisa all-in-one, tetapi API memungkinkan semua orang menyesuaikan dan memperluas LifeUp mereka, serta mewujudkan komunitas open source. | P1 | 🚧 |
| Pengembangan **ulives** | - Terus meningkatkan fitur **ulives**<br/>- Eksplorasi dukungan multi-platform (iOS/iPadOS/macOS/lainnya) | - **ulives** adalah produk generasi berikutnya LifeUp, dikembangkan dengan teknologi lintas platform modern.<br/>- Di masa depan berpotensi melintasi Android atau platform lain. | P0 | 🚧 |

Ringkasnya:

1. Kami akan terus mengikuti arah yang ditetapkan, fokus pada stabilitas dan mengoptimalkan fitur yang ada.
2. Terus meningkatkan kedalaman fungsional setiap modul untuk meningkatkan pengalaman pengguna.
3. Majukan pengembangan **ulives** dan eksplorasi dukungan platform lebih banyak.
4. Terus meningkatkan API dan aspek lainnya.

---

### II. Tinjauan dan Prospek

#### 2.1 Tentang **ulives**

Pada 2025, kami meluncurkan **ulives** di iOS sebagai produk generasi berikutnya LifeUp. Beberapa pengguna mungkin bertanya: mengapa meluncurkan app baru? Mengapa bayar lagi?

Berikut pemikiran dan penjelasan kami:

**Kendala Teknologi dan Arsitektur**

LifeUp dikembangkan berbasis teknologi Android dan mengakumulasi banyak logika serta masalah kompatibilitas historis selama pengembangan. Mengingat kendala arsitektur teknis, hampir mustahil mereplikasi versi identik di iOS atau HarmonyOS sambil menjaga kompatibilitas data.

Selain itu, LifeUp berkembang secara bertahap, dengan beberapa desain produk dikompromikan oleh kompatibilitas dan keputusan desain awal, yang mungkin sulit kami ubah. Misalnya:

- **Custom Currency**: Dasar LifeUp adalah jenis mata uang, membuat perubahan arsitektur besar sulit.
- **Modul World**: Awal pengembangan LifeUp, karena kerja sama sisi server, kami merencanakan menambah modul ini, tapi sebagian besar fitur tidak dipertimbangkan menyeluruh, sehingga fitur tim kurang sekarang.

Membuat sesuatu yang baru memungkinkan kami melihat ini dari perspektif produk baru dengan konsep modern.

**Technical Debt**

Secara teknologi, LifeUp juga menginjak beberapa ranjau:

- Memakai framework ORM database yang cocok untuk pengembangan cepat awal tapi pada dasarnya tidak dirawat, membuat migrasi sulit.
- Dasar bahkan tidak mendukung composite index, menyebabkan bottleneck performa.
- Kami habiskan effort cukup besar terus mengoptimalkan performa app di volume data besar.

Untuk **ulives**, kami memakai teknologi lintas platform modern (Kotlin Multiplatform) untuk meninjau ulang dan mengembangkan aspek-aspek ini. Kemungkinan masa depan meliputi melintasi Android atau platform lain (saat ini hanya mendukung iOS, iPadOS, dan macOS).

**Biaya dan Harga**

Harga sekali bayar rendah awal LifeUp dan posisi single-platform membuat kami punya kontrol biaya terbatas untuk fitur yang butuh investasi (seperti Modul World atau fitur AI).

Harga rendah LifeUp (Android) berdasarkan biaya pemeliharaan single-platform. **ulives** mungkin punya beberapa penyesuaian dan perencanaan lebih banyak.

Karena tim pengembangan berbeda, ini pengembangan ulang penuh, dan **ulives** saat ini sepenuhnya offline. Kami memang tidak bisa berbagi keanggotaan atau memberi diskon ekstra, dan mungkin tidak memberi diskon semacam itu di masa depan agar tidak menyakiti pengguna berbayar.

---

#### 2.2 Efisiensi AI

Beberapa tahun terakhir, kami menyaksikan perkembangan pesat pengembangan berbantuan AI, di mana banyak developer dapat memakai AI untuk mengembangkan app demi app dalam waktu singkat.

Memang, kami juga mencoba memakai AI dalam proses pengembangan untuk cepat mewujudkan kerangka fungsional utama dan scaffolding kode. Namun, AI bukan segalanya — menentukan rute solusi teknis, penerimaan akhir, dan memastikan semuanya berjalan masih butuh effort manusia signifikan.

Yang benar-benar memakan waktu adalah polesan detail. Terutama untuk optimasi animasi platform iOS, penyetelan kelancaran interaksi, penanganan edge case — waktu yang diinvestasikan di sini sering beberapa kali lipat dari logika fungsional itu sendiri.

---

#### 2.3 Ekstensi Pengguna dan Integrasi AI

Kami juga melihat banyak pengguna mewujudkan fungsi menarik memakai AI dikombinasikan dengan API LifeUp:

- Beberapa memakai MCP (Model Context Protocol) untuk menghubungkan LifeUp dengan berbagai toolchain AI
- Beberapa menggabungkan LifeUp dengan app catatan seperti Obsidian untuk otomasi alur kerja
- Beberapa mewujudkan alat web dan skrip otomasi sendiri via API

Kami terus menyambut pengguna berbagi metode ekstensi berbasis AI, dan menantikan ide-ide menarik lebih banyak!

---

#### 2.4 Ritme Pengembangan dan Kualitas

Kami teguh pada pemeliharaan jangka panjang LifeUp, **ulives**, dan app kami lainnya. Kami sudah punya rencana dan tujuan pengembangan multi-tahun untuk LifeUp, dan akan terus maju.

Kami tidak akan mengejar peluncuran fitur baru cepat sambil mengabaikan kualitas dan stabilitas. Setiap fitur melalui desain, pengembangan, pengujian, dan optimasi cermat untuk memastikan produk akhir yang diserahkan tahan uji waktu.

Inilah mengapa kami memilih menginvestasikan lebih banyak waktu mendalami dan mengoptimalkan fitur yang ada alih-alih terus meluncurkan modul fungsional baru.

---

#### 2.5 Sorotan Komunitas

Kami beruntung bertemu banyak pengguna luar biasa:

- Satu pengguna mengalami crash LifeUp aneh. Setelah beberapa putaran pertukaran informasi, mereka mengekspor log sistem (bugreport) dan memakai AI untuk menganalisis bahwa penyebabnya korupsi data kalender sistem. Karena LifeUp memakai notifikasi kalender, app salah dibunuh sistem. Ini membantu kami mengidentifikasi masalah kompatibilitas tingkat sistem yang sangat jarang.
- Banyak pengguna telah berbagi kreasi mereka, termasuk sistem Tugas menarik, desain Item, berbagi Pencapaian, dan konten komunitas lainnya.

Dukungan luar biasa dari pengguna kami yang mendorong kami terus memelihara dan memperbarui produk.

---

> Pratinjau: Pada 2025 kami juga meluncurkan **ulives**, dikembangkan memakai Kotlin Multiplatform, saat ini hanya mendukung iOS, iPadOS, dan macOS, dengan rencana mendukung lebih banyak platform di masa depan.

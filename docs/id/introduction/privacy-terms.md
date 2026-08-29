# *LifeUp* App Privacy Terms & Policy

?> Deskripsi server aplikasi berikut tidak berlaku untuk versi Lite. Versi Lite tidak memiliki interaksi dengan server aplikasi.

LifeUp adalah App yang membantu Anda meningkatkan hidup. Kami menghormati privasi Anda dan berkomitmen melindungi informasi pribadi Anda. Kebijakan privasi ini menjelaskan bagaimana kami mengumpulkan, menggunakan, membagikan, dan menghapus informasi pribadi Anda saat menggunakan App kami.

### 1. Informasi Pribadi

LifeUp adalah App offline-first. Kami tidak secara aktif mengumpulkan data pengguna, misalnya nama atau alamat email Anda. Anda dapat secara opsional memberikan beberapa data untuk mengotorisasi login guna mengakses modul world, mengotorisasi Google Drive atau Dropbox untuk mendapatkan kemampuan cadangan cloud, dan sebagainya.

Kami menggunakan Google Firebase dan Sentry untuk mengumpulkan laporan masalah dan data performa hanya untuk tujuan analitis.

Berikut ringkasan beberapa data:

- **Nama panggilan, Avatar, Jenis kelamin**
  Opsional, digunakan untuk fungsi login guna mengakses modul "World", akan ditransfer ke server untuk disimpan, tetapi dapat diubah dan dihapus
- **Email**
  Opsional, untuk sinkronisasi Google Drive, disimpan lokal, tidak ditransmisikan ke server
- **URL WebDAV, Akun, dan Kata sandi**
  Opsional, untuk sinkronisasi WebDAV, disimpan terenkripsi lokal, tidak ditransmisikan ke server
- **Informasi crash, data performa**
  Ditransmisikan ke penyedia layanan (Google Firebase, Sentry) untuk analisis masalah dan performa, tetapi tidak pernah diikat ke pengenal pengguna atau perangkat, juga tidak berisi data pengguna

Metode pengumpulan dan pemrosesan data detail untuk setiap fungsi ditampilkan di bawah.

#### 1.1 Informasi pengguna (otorisasi pihak ketiga)

##### Google/Facebook Sign In

**Hanya setelah Anda mengonfirmasi otorisasi untuk login,** kami akan membuat akun dengan nama panggilan
dan foto profil yang Anda otorisasi untuk diberikan (dan tidak akan menyertakan informasi seperti akun email).

##### Google Drive

Karena cadangan Google Drive bergantung pada alamat email, *LifeUp* akan meminta izin alamat email
saat Anda mengotorisasi Google Drive. **Namun alamat ini hanya digunakan secara lokal, *LifeUp*
tidak akan meneruskannya ke server aplikasi dan penyimpanan.**

Dan *LifeUp* hanya meminta penyimpanan khusus App, yang berarti kami tidak memiliki izin untuk mengakses
file pribadi Anda.

##### Dropbox

Setelah Anda mengotorisasi Dropbox, **informasi terkait hanya disimpan di perangkat Anda untuk cadangan
dan tidak diteruskan ke server aplikasi.**

Dan *LifeUp* hanya meminta **penyimpanan khusus App, yang berarti kami tidak memiliki izin untuk mengakses
file pribadi Anda.**

##### WebDAV Server

**URL WebDAV, akun, dan kata sandi Anda hanya disimpan secara lokal dan tidak
dikirim ke server aplikasi.** Kata sandi disimpan terenkripsi di database.

##### Offline Mode

***LifeUp* juga sepenuhnya diizinkan dalam mode offline, hanya saja tidak dapat mengakses modul "world".**

Dalam mode offline, **Anda tidak perlu mengirimkan informasi apa pun ke server aplikasi kami.**
**Nama panggilan, avatar, dan informasi lain akan disimpan dan tersedia secara lokal.**

Kami mungkin hanya meminta server aplikasi untuk pengumuman dan pembaruan terbaru, yang tidak melibatkan pengiriman informasi.

Interaksi Anda dengan SDK lain seperti Dropbox, Google Drive, Facebook. Permintaan ini akan merespons normal di bawah penggunaan aktif Anda.

Dalam penggunaan offline, kami mungkin masih menggunakan Google Firebase, Sentry untuk mengumpulkan crash dan laporan masalah, tetapi sebagaimana dijelaskan di bawah, **informasi ini tidak berisi data pengguna dan tidak terikat dengan informasi pengguna. Hanya untuk analisis performa dan penyelesaian crash, dan hanya disimpan sementara.**

Kami juga akan berkomunikasi dengan Google Play Services untuk memverifikasi lisensi Anda berdasarkan permintaan Google Play.

Jika Anda ingin menolak semua komunikasi di atas, Anda dapat langsung menonaktifkan izin permintaan jaringan LifeUp. Ini tidak memengaruhi penggunaan LifeUp itu sendiri, tetapi dapat memengaruhi fungsionalitas SDK seperti Google Drive.


#### 1.2 Permissions

#### Storage

App **tidak akan meminta izin baca ruang penyimpanan**, sehingga tidak akan membaca file apa pun yang tidak Anda otorisasi.

App telah meminta izin kamera untuk memudahkan pengguna menggunakan lampiran gambar, mengunggah avatar, dan fungsi lainnya, dan **hanya dapat memanggil kamera setelah pengguna memberikan izin.**

Misalnya, saat Anda memilih gambar lampiran, kami langsung memanggil kerangka kerja penyimpanan file sistem untuk mengaksesnya.

Hanya file tunggal yang Anda pilih yang diotorisasi untuk *LifeUp*, kami tidak akan memiliki izin untuk membaca file lain.

Pada saat yang sama, kecuali Anda secara aktif membagikan file di luar modul world, file hanya disimpan secara lokal dan tidak melewati server.

#### Network

Izin akses jaringan untuk mengakses modul "WORLD", login terotorisasi, dan sinkronisasi Dropbox/WebDAV opsional serta fungsi lainnya.

#### Calendar

App juga menyediakan fungsi menulis acara ke App kalender sistem untuk mengingatkan Anda.

**Fungsi ini memerlukan izin baca dan tulis kalender, dan izin ini hanya memerlukan otorisasi pengguna saat pengguna menggunakan fungsi terkait. Dan *LifeUp* hanya akan membaca acara yang ditulis oleh App itu sendiri.**

#### 1.3 Data Storage

**App adalah App offline-first dan tidak memiliki fungsi
sinkronisasi online bawaan, sehingga sebagian besar data disimpan secara lokal di ponsel pengguna.**

Misalnya, semua Tugas lokal yang Anda buat, semua Perasaan yang dicatat, Pencapaian yang
Anda rancang, dan Item Toko.

**Hanya konten yang Anda bagikan secara publik di modul "World" yang akan disimpan di server.
Dan semua konten ini mendukung operasi penghapusan dan pemusnahan.**

Misalnya, tim yang Anda buat di modul "World", aktivitas yang Anda publikasikan setelah
menyelesaikan Tugas tim, Item Toko yang dibagikan secara aktif, dan sebagainya.

Pada saat yang sama, sebagian besar permintaan dalam App akan ditransmisikan dalam
bentuk terenkripsi.

#### 1.4 Performance data and crash reports

Kami menggunakan [Google Firebase](https://firebase.google.com/) dan [Sentry](https://sentry.io/) untuk mengumpulkan data performa pengguna dan laporan crash guna melacak dan memperbaiki masalah.

Data performa ini dapat mencakup model perangkat, status jaringan, instance ID, kapan masalah terjadi, dan halaman terkait, **tetapi data ini tidak akan dikaitkan dengan data pengguna Anda** (Tidak termasuk nama panggilan, id pengguna, alamat email, dan informasi kontak apa pun, serta tidak akan mengumpulkan konten yang Anda masukkan dan buat) dan hanya digunakan untuk menganalisis masalah dan meningkatkan performa.

Dan data ini hanya disimpan sementara oleh Firebase dan Sentry selama periode tertentu, **dan kami**
**tidak akan membagikan/menjual/menyewakannya kepada pihak ketiga.**

#### 1.5 Data Deletion Request for *LifeUp Lite*

##### 1. Data Storage and Deletion

LifeUp Lite, versi gratis LifeUp, terutama menyimpan data di perangkat pengguna. Kami menghargai privasi dan otonomi Anda. Di LifeUp Lite, karena akun pengguna tidak dibuat, semua data pribadi disimpan secara lokal di perangkat Anda.

**Untuk menghapus data ini, cukup hapus instalasi App LifeUp Lite dari perangkat Anda. Setelah dihapus, semua data yang disimpan secara lokal akan dihapus permanen.**

##### 2. Third-Party Services

LifeUp Lite terintegrasi dengan layanan pihak ketiga seperti Firebase dan Admob untuk fungsionalitas dan periklanan. Perhatikan bahwa data yang dikumpulkan layanan ini tidak mencakup informasi pribadi yang terkait dengan identitas Anda dan digunakan sesuai kebijakan privasi masing-masing. Data ini dihapus otomatis setelah periode tertentu sesuai kebijakan layanan tersebut.

##### 3. Assistance with Data Deletion

Jika Anda memerlukan bantuan atau memiliki pertanyaan tentang penghapusan data, hubungi kami di lifeup@ulives.io. Tim kami siap membantu pertanyaan atau kekhawatiran terkait privasi data Anda dan akan memandu prosesnya jika diperlukan.

##### 4. Compliance and Updates

Kami terus meninjau dan memperbarui praktik kami agar mematuhi peraturan dan standar industri terbaru. Bagian Kebijakan Privasi ini akan diperbarui seperlunya untuk mencerminkan perubahan proses pengelolaan dan penghapusan data kami.


#### 1.6 Data Deletion Request for *LifeUp Pro*

##### 1. Data Deletion in LifeUp Pro

Pengguna LifeUp Pro dapat menghapus data mereka secara mandiri di dalam App.

Karena LifeUp Pro terutama adalah App offline, Anda dapat mengelola data langsung di perangkat Anda.

Untuk menghapus data, ikuti langkah-langkah berikut:

1. Buka halaman 'Settings - Data Backup/Restore/Clear' di App LifeUp Pro.
2. Pilih data spesifik yang ingin dihapus, seperti Tugas, Hadiah Item, catatan lokal, dan data mode offline.
3. Konfirmasi tindakan Anda untuk menghapus data yang dipilih secara permanen.

**Alternatifnya, menghapus instalasi App LifeUp Pro dari perangkat Anda juga akan menghapus semua data yang disimpan secara lokal.**



##### 2. Account Deletion in LifeUp Pro

Menghapus akun di LifeUp Pro adalah proses terpisah dari penghapusan data.

Saat Anda menghapus akun, hal berikut akan dihapus:

- Posting publik Anda, seperti tim dan pembaruan, yang dipublikasikan di server kami.
- Nama panggilan dan informasi pribadi lain yang terkait dengan akun Anda.
- Asosiasi OAuth yang terhubung dengan akun Anda.

**Untuk menghapus akun LifeUp Pro, ikuti langkah-langkah yang diuraikan sebelumnya:**

1. Buka halaman 'Settings - Data Backup/Restore/Clear'.
2. Ketuk tombol 'Delete Account' di bagian bawah halaman.
3. Konfirmasi tindakan Anda untuk menghapus akun dan semua informasi terkait secara permanen.

<br/>

**Jika Anda tidak lagi menggunakan App LifeUp Pro tetapi ingin menghapus akun dan data pribadi, hubungi kami di [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Berikan detail yang diperlukan terkait akun Anda, dan tim kami akan membantu proses penghapusan.

Kami berkomitmen menjaga privasi Anda dan akan menangani permintaan dengan sangat hati-hati dan kerahasiaan.



##### 3. Third-Party Services

Mirip LifeUp Lite, LifeUp Pro terintegrasi dengan layanan pihak ketiga seperti Firebase untuk fungsionalitas yang ditingkatkan. Data yang dikumpulkan layanan ini tidak dapat diidentifikasi secara pribadi dan dikelola sesuai kebijakan privasi mereka. Data ini dijadwalkan untuk dihapus otomatis setelah periode tertentu sesuai kebijakan layanan pihak ketiga.



##### 4. Updates and Compliance

Kami terus memantau dan memperbarui praktik kami agar selaras dengan undang-undang privasi dan standar industri terbaru. Bagian Kebijakan Privasi ini akan diubah seperlunya untuk secara akurat mencerminkan proses pengelolaan dan penghapusan data untuk pengguna LifeUp Pro.


### 2. Agreement

Dengan menggunakan App ini, Anda setuju dengan ketentuan kebijakan privasi ini.

Anda setuju bahwa Anda bertanggung jawab atas data Anda sendiri.

Kami tidak bertanggung jawab dalam hal apa pun atas kehilangan data yang disebabkan oleh atau terkait dengan penggunaan App ini karena ini adalah App offline-first.

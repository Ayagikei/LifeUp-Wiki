# Rencana Pengembangan 2022/10 - 2023/12

> [!IMPORTANT]
> Ini adalah rencana pengembangan yang sudah kedaluwarsa, disimpan hanya untuk arsip dan referensi. Lingkungan terus berubah, dan rencana kami akan disesuaikan. Rencana ini secara luas menunjukkan arah pengembangan kami, tetapi kami tidak menjanjikan pelaksanaannya sepenuhnya, dan kami juga dapat berkembang di luar rencana.

<br/>

Pengembangan LifeUp di tahun-tahun sebelumnya selalu fokus pada modul fungsional baru atau menambahkan fitur baru ke modul yang sudah ada.

Saat ini, kami percaya modul fungsional LifeUp sudah cukup lebar secara konsisten internal, tetapi kurang dalam kedalaman.

Oleh karena itu, tujuan pengembangan berikut mengarah pada kedalaman fungsional, terus meningkatkan modul yang sudah tersedia, menambah kepraktisan (integrasi kalender, widget, statistik);

Dan terus memperluas fungsi API agar API dapat diperluas sepenuhnya untuk berbagai fungsi eksternal.
Selain itu, coba perbaiki sistem data kami dan eksplorasi penggunaan Flutter untuk mengembangkan versi lintas platform.

<br/>

- **2023/01/26**
  - Menambahkan Item "LAN PC side" ke "Multi-platform", juga menambahkan penjelasan terkait ke "APIs".
  - Menyesuaikan versi perkiraan "Calendar Integration", kemajuan mungkin tertunda.
  - Menyesuaikan versi perkiraan "Custom Required Experience", kemajuan mungkin dimajukan.
- **2022/10/16**
  - **Menambahkan roadmap untuk Atribut, Pencapaian, dan Kemampuan Dasar**

| Modul | Subfungsi | Versi Perkiraan | Alasan Kebutuhan | Prioritas | Hasil |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Integrasi Kalender | - Sinkronisasi Dua Arah Google Calendar<br/>- Sinkronisasi Dua Arah Kalender Sistem | v1.91~1.93 | - Banyak umpan balik dari luar negeri.<br/>- LifeUp adalah alat to-do dengan fungsi yang tumpang tindih tetapi tidak konsisten dengan app jadwal (kalender). Mengembangkan semua fitur kalender di LifeUp akan sangat besar. Integrasi eksternal mungkin solusi yang lebih baik. | P0 | ~ |
| Widget | - Widget Atribut<br/>- Widget Item<br/>- dll... | v1.92~1.95 | - Kegunaan.<br/>- Widget yang indah juga memberikan tingkat gamifikasi dan motivasi. | P1 | ~ |
| Statistik | - Statistik berbagai indikator<br/>- Statistik Pomodoro detail<br/>- Buat kartu berbagi | v1.92~1.95 | - Statistik Pomodoro kurang.<br/>- Modul statistik lama tidak diperbaiki, desain dan data sudah usang.<br/>- Kartu berbagi cocok untuk berbagi eksternal pengguna, dapat memberi insentif dan menarik lebih banyak pengguna sampai batas tertentu (membutuhkan desain UI yang rapi). | P1 | - Diperkirakan mengembangkan beberapa kartu statistik di v1.91 |
| API | - Kembangkan SDK<br/>- Dukung kueri daftar<br/>- API umum lainnya | v1.91~1.95 | - Antarmuka data daftar kurang. Setelah mendukung kueri daftar, pihak ketiga dapat mengembangkan UI kustom (seperti daftar Tugas), ekstensibilitas dapat ditingkatkan besar.<br/>- Berdasarkan antarmuka di atas, kembangkan SDK terkait dan LAN PC side.<br/>- LifeUp tidak bisa all-in-one, tetapi API memungkinkan semua orang menyesuaikan dan memperluas LifeUp mereka, serta mewujudkan komunitas open source. | P1 | - Diperkirakan menyediakan API kueri versi pertama di v1.91 |
| Atribut | - Pengalaman wajib kustom | v1.91~1.92 | ~ | P2 | - Diperkirakan menyelesaikan pengembangan di v1.91 |
| Pencapaian | - Pencapaian tipe ulang | v1.94~1.97 | ~ | P2 | ~ |
| Kemampuan Dasar | - Edit batch (Tugas, Pencapaian, dll.)<br/>- Multi-pilih Item, auto-pack ke kotak, dll. | v1.94~1.97 | ~ | P1 | ~ |
| Sistem Data | - Backup terpisah data dan gambar<br/>- Dukung ekspor/impor data sebagian<br/>- Dukung pergantian multi-file bawaan | ~ | - Upload WebDAV file besar mudah gagal, layanan cloud gratis punya batas trafik, backup penuh dengan gambar terlalu besar.<br/>- Ekspor/impor sebagian dapat dipakai pengguna untuk berbagi sistem Hadiah.<br/>- Multi-file bawaan memungkinkan pengguna langsung beralih antar sistem untuk debugging tanpa menghapus data berulang. | P1 | ~ |
| Multi-platform | - Terus belajar dan memakai Flutter untuk versi lintas platform | LAN PC side: v1.91-1.92<br/>Flutter: v2.0 | - Pengembangan prototipe versi iOS.<br/>- Lebih condong mengeksplorasi implementasi baru daripada mereplikasi versi Android satu-ke-satu.<br/>- Mungkin cocok untuk Windows/macOS dan platform lain, perlu investigasi.<br/>- Kembangkan LAN PC side berbasis API (versi membaca data ponsel). | P1 | - Diperkirakan menyediakan PC side versi pertama di v1.91 |

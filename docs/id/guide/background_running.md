# Menjalankan LifeUp di Latar Belakang

## Mengapa ini diperlukan

Beberapa produsen ponsel secara agresif membatasi app latar belakang untuk meningkatkan skor benchmark baterai. Akibatnya, fitur yang bergantung pada eksekusi latar belakang dapat gagal.

### Matriks dampak kompatibilitas

| Fitur | Perlu keep-alive latar belakang? | Izin tambahan | Catatan |
| --- | --- | --- | --- |
| Pengingat Tugas (notifikasi sistem) | ✔️ | Izin notifikasi | Ini metode pengingat default. Jika pengingat tertunda atau hilang, konfigurasi keep-alive latar belakang dan pastikan notifikasi LifeUp aktif. |
| Pengingat Tugas (acara kalender) | ✖️ | Izin baca/tulis kalender | Anda dapat beralih ke mode ini di `Settings` → `Tasks` → `Change Reminder System`. |
| Pengingat akhir Pomodoro | ✔️ | - | Jika keep-alive belum dikonfigurasi, pengingat dapat terlewat, dan hitung mundur dapat berhenti atau membeku di latar belakang. |
| Timer hitung maju | ✖️ | - | - |
| Refresh otomatis widget App | Biasanya ya (tergantung perangkat/OS) | - | Tanpa keep-alive yang benar, widget dapat tetap di "Loading" atau menampilkan status usang seperti "All tasks completed". |
| Aksi widget: selesaikan Tugas hitung / buka detail Tugas (non-MIUI) | ✖️ | - | - |
| Aksi widget: selesaikan Tugas hitung / buka detail Tugas (MIUI) | Tergantung | Mungkin perlu izin popup/tampilan latar belakang khusus MIUI | MIUI dapat memblokir aksi UI yang dipicu widget di latar belakang. |

- Beberapa sistem membekukan atau menghentikan tugas latar belakang saat layar mati.
- Widget dapat berperilaku berbeda di berbagai launcher dan varian OS.
- Jika Anda hanya peduli pada pengingat, Anda dapat beralih ke pengingat kalender untuk mengurangi ketergantungan latar belakang.

## Cara mengonfigurasi

> [!WARNING]
> Pengaturan ini dapat sedikit meningkatkan penggunaan baterai.

Berdasarkan pengujian kami di OnePlus 8T, penggunaan latar belakang 24 jam memakai sekitar **30 mAh**. Untuk sebagian besar pengguna, dampaknya kecil.

LifeUp hanya menjalankan operasi latar belakang pasif terbatas, seperti pengingat, pembaruan widget, dan penghitungan Pomodoro.

---

### Langkah pengaturan umum

#### Pengaturan umum

> Anda tidak perlu menyelesaikan setiap langkah. Setiap langkah dapat meningkatkan prioritas dan stabilitas latar belakang.

**Pengaturan sistem Android**

1. Di LifeUp, buka `Sidebar` → `Settings` → `Compatibility Issues`, lalu ketuk `Jump to Battery Optimization Settings`. Temukan LifeUp dan atur ke **Do Not Optimize**.

   a. Di beberapa perangkat, LifeUp mungkin tidak muncul setelah lompat ke halaman ini. Jika begitu, lewati langkah ini.

2. Jika Anda butuh pengingat, pastikan izin notifikasi diberikan ke LifeUp.

3. (Opsional) Di pengaturan Tugas, aktifkan `Quick Add notification`.

<br/>

**Manajer latar belakang produsen (Phone Manager)**

Banyak produsen menambahkan pembatasan latar belakang ekstra. Jika Anda bukan di perangkat ala Pixel/AOSP, biasanya perlu konfigurasi tambahan.

1. Kunci LifeUp di layar multitasking/recent apps sistem.

2. Di manajemen app sistem / manajemen baterai / phone manager, atur LifeUp agar diizinkan berjalan di latar belakang (tanpa pembatasan) dan diizinkan auto-start.

   a. Untuk panduan khusus produsen, lihat [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Saat memakai fitur LifeUp, hindari mode agresif seperti super power saving atau kebijakan do-not-disturb ketat, atau tambahkan LifeUp ke allowlist yang relevan.

<br/>

**Masih tidak berfungsi?**

Berdasarkan laporan pengguna dan pengujian kami, LifeUp berjalan normal di perangkat mainstream setelah pengaturan benar. Namun, pembaruan sistem dapat memindahkan atau mengganti nama pengaturan.

1. Periksa ulang semua langkah di atas dan lengkapi pengaturan yang terlewat.

   a. Pembatasan phone manager sering tersebar di beberapa halaman dan tidak tercantum sebagai izin app standar.

   b. Coba langkah opsional (misalnya, aktifkan persistent notification) dan uji lagi.

   c. Cari di pengaturan sistem untuk optimasi baterai, pembatasan latar belakang, auto-start, dan opsi popup/tampilan latar belakang.

   d. Jika Anda hanya peduli pengingat, coba mode `Calendar Reminder`.

2. Tanyakan ke pengguna lain dengan merek/model perangkat yang sama di komunitas, sertakan versi OS Anda.

3. Hubungi dukungan produsen ponsel dan tanyakan cara mencegah app tertentu dihentikan di latar belakang.

---

### Widget App tidak berfungsi

1. Buka LifeUp terlebih dahulu dan biarkan berjalan di foreground sebentar.
2. Tambahkan ulang widget (jika perlu, coba lebih dari sekali).
3. Jika gagal lagi nanti, tinjau panduan ini dan periksa ulang pengaturan keep-alive.
4. Jika Anda memakai launcher pihak ketiga, beralih ke launcher sistem dan uji lagi.
5. Jika Anda memakai tema kustom, beralih ke tema sistem default dan uji lagi.
6. Restart ponsel.
7. Coba launcher lain untuk menyingkirkan masalah khusus launcher.

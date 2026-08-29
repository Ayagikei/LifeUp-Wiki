# Rencana Pengembangan

Karena *LifeUp* saat ini dikelola di waktu luang dan memiliki sumber daya terbatas, kami tidak menjamin rencana pengembangan dapat dijalankan secara akurat, dan kami tidak akan menjanjikan waktu peluncuran tertentu.

<br/>

## Strategi pembaruan

Siklus pembaruan fitur lokal akan tetap dalam 14–21 hari.

Dan setelah setiap pembaruan fitur, kami mungkin merilis beberapa perbaikan.

Karena fungsi modul "World" melibatkan berbagai faktor seperti pengembangan bersama di dua platform, sinkronisasi kebutuhan, deployment server, keterbatasan performa server, dan kompatibilitas.

Siklus pengembangannya akan lebih lama daripada fungsi lokal dan terutama berupa pemeliharaan alih-alih memperkenalkan fitur baru.



**Prioritas pembaruan (perkiraan):**

Perbaikan crash >> Perbaikan bug pengalaman yang memengaruhi pengguna baru >> Pembaruan fitur > Perbaikan bug UI dan detail.

<br/>

## Strategi nomor versi

Menggunakan nomor versi tiga digit, seperti `1.80.3`.

**Digit pertama** (misalnya **1**.80.3) adalah nomor versi untuk revisi besar App, dan 1 adalah versi resmi awal. Akan ada banyak refactoring kode/perubahan desain UI jika diperlukan.


**Digit tengah** (misalnya 1.**80**.3) adalah nomor versi fitur (feature). Nomor versi akan naik saat fitur tingkat menengah dirilis atau saat sejumlah fitur kecil terakumulasi.

Seperti:

> Versi 64 meluncurkan sistem Shop&Store&Warehouse.
>
> Versi 70 meluncurkan Simple Mode.
>
> Versi 80 meluncurkan sistem unboxing.



**Digit ketiga** (misalnya 1.80.**3**) adalah nomor revisi untuk memperbaiki beberapa masalah/crash pada setiap rilis fitur. Pada saat yang sama, mungkin juga membawa beberapa fitur kecil.


> Versi lama juga menggunakan nomor versi tiga digit yang direpresentasikan huruf Inggris, seperti 1.58c.
>
> Strategi dasarnya sama seperti di atas, kecuali bagian ketiga menjadi huruf Inggris dan dimulai dari `a`.
>
> Namun, karena beberapa pasar App tidak mendukung strategi nomor versi ini, strategi tersebut sekarang ditinggalkan.

<br/>

Lihat [Rencana Pengembangan 2026-2027](introduction/development_plan_2026_2027.md) untuk roadmap saat ini.

Lihat [Rencana Pengembangan 2024-2025](introduction/development_plan_2024.md) untuk roadmap sebelumnya.

Lihat [Rencana Pengembangan 2022/10 - 2023/12](introduction/development_plan_2023.md) untuk arsip historis.

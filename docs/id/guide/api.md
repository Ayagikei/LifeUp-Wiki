<h1 align="center" padding="100">Antarmuka terbuka</h1>

<p align="center">Ciptakan kemungkinan tanpa batas! </p>

> [!NOTE]
> Kami sedang meluncurkan **LifeUp v1.106.0** dan **LifeUp Cloud v3.0.0** secara bertahap. Karena jadwal tinjauan platform bervariasi, dokumentasi ini mungkin diperbarui sebelum App tersedia secara luas; tanggal rilis aktual bisa lebih lambat dari yang tampil di sini.

?> Pada versi v1.90, `LifeUp` telah membuka berbagai antarmuka fungsional, dan integrasi aplikasi eksternal apa pun disambut baik. <br/>App ini juga menyediakan efek "URL" untuk Item Toko, sehingga pengguna dapat langsung menggunakan komoditas untuk memanggil aplikasi eksternal atau antarmuka `LifeUp`. <br/>Fitur-fitur ini memberi `LifeUp` Anda kemungkinan tanpa batas, tetapi juga memerlukan sedikit pemahaman belajar dan kemampuan praktik.

**Terakhir diperbarui: 2026/08/28**

Parameter dan definisi API dalam dokumen ini berdasarkan versi **v1.106.0**.

Pastikan aplikasi Anda telah diperbarui ke **v1.106.0** sebelum menggunakan API terbaru.

Pembaruan dirilis secara bertahap melalui Google Play; jika Anda belum menerimanya, harap bersabar — pembaruan akan segera tiba.

## Contoh skenario

| Pemanggil | Skenario | Catatan |
| ------ | -------- | ----- |
|**LifeUp→Aplikasi Lain**<br/>Diimplementasikan melalui efek "URL" Item Toko| **Setelah menggunakan Item Toko:**<br/>1. Gunakan browser untuk mengunjungi halaman web<br/>2. Lompat ke WeChat dan pindai, atau tentukan program mini<br/>3. Tambahkan catatan akuntansi secara otomatis ([misalnya "Qianji" mendukung antarmuka akuntansi](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Simpan konfigurasi alat otomatisasi Tasker (bahkan bagikan di Market), dan impor konfigurasi ke Tasker secara otomatis setelah digunakan<br/>5. Picu Tasker untuk mengganti wallpaper<br/>6. ... (selama aplikasi eksternal mendukung metode pemanggilan ini) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) adalah alat otomatisasi dan mendukung mengekspor konfigurasi sebagai Uri |
|**LifeUp→LifeUp**<br/>Diimplementasikan melalui efek "URL" Item Toko| **Setelah menggunakan Item Toko:**<br/>1. Buka halaman tertentu<br/>2. Tingkatkan suku bunga ATM<br/>3. Jendela pop-up memungkinkan pengguna memilih produk dan menurunkan harga produk (kupon diskon)<br/>4. Picu penyelesaian Tugas<br/>5. Tampilkan pesan motivasi kustom<br/>6. Buat templat Hadiah Tugas: cukup masukkan nama untuk membuat Tugas secara otomatis<br/>7. Jendela pop-up meminta pengguna memilih cabang, menciptakan interaksi kontekstual kecil<br/>8. Operasi dalam App lainnya... |  |
|**Aplikasi eksternal/halaman web→LifeUp** | **Konfigurasi alat otomatisasi:**<br/>1. Deteksi saat ponsel dinyalakan pertama kali setiap hari, selesaikan Tugas bangun pagi, atau langsung picu penalti "bangun terlambat"<br/>2. Setelah setiap 25 kata, gesek kartu NFC tertentu dan selesaikan Tugas secara otomatis<br/>3. GPS mendeteksi tempat baru tercapai, dan membuka Pencapaian "tempat baru"<br/>4. Saat terhubung ke Wi-Fi kantor setiap hari, picu peningkatan progres kondisi pembukaan. Setelah 20 hari terkumpul, buka Pencapaian "Worker"<br/>5. Hadiahi diri Anda dengan koin "pulang ke rumah" saat terhubung ke Wi-Fi rumah pertama kali setiap hari<br/>6. Tangkap notifikasi dari aplikasi Pomodoro atau Fokus lain, dan catat waktu secara otomatis ke `LifeUp`<br/>7. Tangkap notifikasi selesai atau berakhir dari perangkat lunak olahraga dan belajar, dan berikan Poin Pengalaman "strength" dan "knowledge" secara otomatis<br/>8. Dalam periode waktu yang Anda tentukan sendiri, setiap kali membuka ponsel akan memicu penalti<br/>9. ...<br/>**Keterkaitan aplikasi eksternal/aplikasi buatan sendiri:**<br/>1. Jika Anda tidak puas dengan Pomodoro `LifeUp`: Anda dapat mengembangkan perangkat lunak penghitung waktu sendiri, bisa berupa aplikasi web atau Android, dan terhubung dengan "LifeUp" melalui antarmuka untuk menambahkan catatan waktu atau Hadiah<br/>2. Modifikasi beberapa mini-game kecerdasan (seperti contoh Wordle di bawah). Saat permainan berhasil diselesaikan, picu `LifeUp` untuk mengirim Hadiah<br/>3. ... |  |

<br/>Dengan kata lain, semua skenario di atas sebenarnya adalah "peristiwa" yang memicu "tindakan".

Pembaruan `LifeUp` ini menyediakan titik pemicu peristiwa "penggunaan Item", lalu menyediakan berbagai "tindakan" (Hadiah, penyelesaian Tugas, dll.).

Jika Anda membutuhkan

- Mengklik tombol web
- Menggesek kartu NFC
- Setiap hari bangun dan membuka kunci layar untuk pertama kali

Peristiwa semacam ini memerlukan intervensi aplikasi eksternal. Misalnya, lakukan pengembangan sekunder sendiri atau gunakan alat otomatisasi seperti `Tasker` dan `MacroDroid`.

**Pembaruan LifeUp 1.90.2 akan menambahkan serangkaian "peristiwa", tetapi peristiwa ini dapat diterima oleh alat otomatisasi atau aplikasi eksternal.**

Dapat digunakan untuk mencapai:

Setelah menggunakan Item, picu alat otomatisasi seperti Tasker untuk mengganti wallpaper launcher.

Setelah menyelesaikan Tugas, picu alat otomatisasi seperti Tasker untuk membuka aplikasi.

**Pada versi 1.90.2, memungkinkan "peristiwa LifeUp" memicu "operasi Tasker".**

Tasker memiliki izin yang sangat tinggi, dapat digunakan untuk mengganti wallpaper, mencopot pemasangan aplikasi, menaikkan volume, memilih membuka aplikasi tertentu, dan lain-lain. Anda bahkan dapat menulis logika interaksi UI tanpa dasar pemrograman.

---

## Rekomendasi

**Jika Anda tidak familiar dengan pemrograman,** Anda dapat mencari dan mengimpor Item Toko khusus langsung di [World] - [Market] - tag [Link]/[API]/[Automate]. Anda juga dapat mencoba mengedit parameter untuk memenuhi kebutuhan Anda.

**Jika Anda familiar dengan pengetahuan komputer,** Anda dapat mencoba membaca dokumentasi antarmuka berikut dan mengedit efek yang diinginkan sendiri. Dan gunakan bersama perangkat lunak otomatisasi seperti [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Meskipun Anda tidak mengedit konfigurasi Tasker, selama Anda berhasil menginstal Tasker, Anda dapat mengimpor konfigurasi otomatisasi yang dibagikan orang lain di Market atau komunitas lain.

**Jika Anda memiliki dasar pemrograman,** Anda dapat mencoba mengembangkan halaman web atau aplikasi Android agar terintegrasi dengan LifeUp. Halaman web ini dan versi Wordle kustom adalah beberapa contoh. Anda juga dipersilakan membuat dan membagikan konfigurasi alat otomatisasi.

---

## Memanggil aplikasi lain

Jika Anda ingin memanggil aplikasi eksternal di *LifeUp*, cukup tambahkan efek "Link" ke Item Toko, **masukkan halaman web atau tautan khusus aplikasi**, lalu gunakan Item Toko untuk memicu pemanggilan.

**Berikut beberapa contoh (Anda juga dapat pergi ke "World"-"Market"-"Link" untuk melihat Item publik dengan efek pemanggilan antarmuka):**

- Browser membuka Google: https://www.google.com
- Facebook: [fb://](fb://)
- Buka aplikasi menggunakan nama paket/ID App: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

Secara teori, selama APP eksternal menyediakan URL, Anda dapat melompat dengan menggunakan Item Toko.

**Anda dapat mencari tautan aplikasi yang Anda butuhkan dengan mencari `URL Schemes` di Google.**

**Tautan-tautan ini tidak ada hubungannya dengan `LifeUp`; `LifeUp` hanya menyediakan fungsi lompat URL.**

**Oleh karena itu kami tidak dan tidak memelihara daftar URL. Namun Anda dapat melihat Item Toko publik yang berisi efek link di halaman [World]-[Market]-[Link].**

Anda dapat menemukan nama paket aplikasi (alias ID):

- di URL Play Store: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- dengan menggunakan aplikasi pengelola App
- dengan menggunakan aksi App Info di Tasker
- dengan menggunakan aksi Launch App di Macrodroid

---

## Memanggil API LifeUp

Jika Anda:

- Perlu memanggil antarmuka `LifeUp` di `LifeUp`. Cukup tambahkan efek "link" ke Item Toko, masukkan **URL tertentu** sesuai dokumentasi API, lalu gunakan Item Toko untuk menyelesaikan pemanggilan.
- Memanggil melalui halaman web, cukup lompat ke API LifeUp melalui hyperlink.
- Memanggil melalui APP yang Anda kembangkan sendiri, cukup gunakan Intent untuk melompat ke tautan antarmuka yang sesuai.
- Dipanggil oleh alat otomatisasi (seperti Tasker), isi tautan API yang sesuai di Browser URL Tasker.

**Beberapa contoh:**

Saat Anda mengklik tautan di bawah, "LifeUp" akan menampilkan "You have learned to call APIs!".

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Saat Anda mengklik tautan di bawah, Anda akan mendapatkan koin di "LifeUp", dengan alasan "Learn API Calls".

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Jika Anda menyalin tautan ke efek "link" Item, menggunakan Item juga dapat memicu efek yang sama.

**Contoh keterkaitan aplikasi eksternal:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle adalah permainan tebak kata kecil: tebak kata dengan panjang 5 huruf. Oranye menandakan huruf ada dalam jawaban. Hijau menandakan huruf ada dan berada di posisi yang benar.

**Versi Wordle ini mendukung keterkaitan dengan "LifeUp":**

1. Jika Anda menebak kata dengan benar, Anda bisa mendapatkan 10 koin. Dan ada alasan kustom untuk memperolehnya.
2. Jika Anda gagal menebak kata pada akhirnya, akan ada hadiah hiburan 1 koin.

![](_media/api/wordle.png ':size=30%')

<br/>

**Contoh keterkaitan dengan Tasker:**

> Tasker dipanggil dengan memilih `Action Category`-`Program`-`Shortcut`. Masukkan tautan yang diawali lifeup:// di kolom shortcut.

Membuka kunci layar untuk pertama kali setelah pukul 5 setiap hari dapat memicu penyelesaian Tugas yang Anda tentukan (seperti bangun pagi).

**Catatan: Task Group Id diperlukan untuk mengimpor konfigurasi ini. Anda dapat mengaktifkan [Developer Mode] di [Settings]-[Labs], lalu periksa gid di halaman detail Tugas.**

Jika Tasker terinstal, [klik di sini untuk mengimpor Tugas yang dikonfigurasi.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**Cara menggunakan MacroDroid untuk memanggil API LifeUp:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) juga alat otomatisasi, gratis diunduh dan UI-nya lebih mudah digunakan.

1. Tambahkan makro, lalu atur kondisi yang Anda butuhkan (atau atur nanti)
2. Tambahkan `Actions`
3. Pilih `Applications`
4. Pilih `Open Website`
5. Masukkan URL yang diawali `lifeup://` di kolom `Enter URL`
6. **[Hapus centang]** semua opsi di bawah, seperti `URL encode parameters`...
7. Simpan, Anda dapat mengklik aksi, lalu pilih `Test action` untuk memverifikasi

<br/>

**Melalui fungsi ini, Anda dapat memperluas kemungkinan LifeUp tanpa batas, baik Anda paham pemrograman maupun tidak!**

Lihat di bawah untuk aturan pemanggilan spesifik.

---

## Dokumentasi antarmuka

### Basics - Examples

| Jenis             | Deskripsi   |
| ---------------- | ------------- |
| Contoh          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Format antarmuka | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Awalan tetap     | lifeup://api/ |
| Nama metode      | toast         |
| Parameter       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

Jika nilai parameter Anda berisi simbol khusus seperti +, spasi, =, %, &, #, dll., perlu di-escape:

| Karakter khusus | Arti                                         | Ganti menjadi |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | Tanda + di URL mewakili spasi        | +          |
| spaces             | spasi di URL dapat berupa + atau di-encode              | %20        |
| /                  | memisahkan direktori dan subdirektori            | %2F        |
| ?                  | memisahkan URL aktual dan parameter         | %3F        |
| %                  | menentukan karakter khusus                      | %          |
| #                  | menandakan bookmark                                  | %23        |
| &                  | pemisah antar parameter yang ditentukan di URL   | %26        |
| =                  | nilai parameter yang ditentukan di URL | %3D        |

Ambil antarmuka pesan pop-up di atas sebagai contoh. Jika Anda ingin teks akhir yang ditampilkan: `You have learned to call APIs!`
Maka Anda perlu mengganti spasi menjadi +, efek akhirnya:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Ini alat pengodean sederhana yang diimplementasikan dalam Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Hampir semua penyimpanan data di LifeUp memiliki id unik.

Beberapa antarmuka berikut mendukung mengubah Item Toko **tertentu** dan menyelesaikan Tugas **tertentu**.

Agar `LifeUp` menemukan data yang sesuai, Anda perlu memberikan id.

**Anda dapat mengaktifkan "Settings" - "Labs" - "Developer Mode" untuk melihat id asli data di setiap halaman detail di App.**

Misalnya, nama Atribut yang ditampilkan seperti "strength (1)", id Atribut-nya adalah 1.

#### Task id

Dapat dilihat di halaman detail peristiwa.

id: Jika ini Tugas berulang, id akan diperbarui setiap kali diulang.

gid: id grup Item. Untuk Tugas berulang yang sama, gid tidak akan berubah.

#### List id

Setelah mengaktifkan "Developer Mode", lihat di jendela pop-up "Select List".

#### Attribute id

Setelah mengaktifkan "Developer Mode", lihat di halaman "Custom Attributes".

#### Shop item id

Setelah mengaktifkan "Developer Mode", klik Item Toko untuk melihat detail.

#### Achievement condition id

Setelah menyesuaikan kondisi pembukaan untuk Pencapaian "requires an external API call to unlock", Anda dapat melihat condition id di halaman detail.

<br/>

### Basics - Name Matching

Saat API mendukung pencarian Tugas, Item Toko, atau subtugas berdasarkan nama, LifeUp terlebih dahulu mencoba pencocokan nama persis tanpa membedakan huruf besar/kecil. Jika tidak ada kecocokan persis, akan fallback ke pencocokan fuzzy berisi.

Misalnya, jika "Coin" dan "Coin Box" keduanya ada, meneruskan `name=Coin` akan cocok dengan "Coin" terlebih dahulu, bukan hasil fuzzy mana pun yang muncul lebih dulu.

Jika nama duplikat atau serupa mungkin ambigu, lebih baik meneruskan id yang sesuai.

<br/>

### Basics - Return Values

Beberapa antarmuka mungkin memiliki nilai balik.

**Jika Anda mengembangkan aplikasi Android,** Anda dapat menggunakan metode `onActivityResult` untuk menerima nilai balik.

**Jika Anda menggunakan aplikasi otomatisasi seperti Tasker:**

Umumnya, aplikasi semacam ini tidak dapat menerima nilai balik tipe Activity. Jadi Anda perlu menambahkan parameter `broadcast`, lalu menggunakan peristiwa `received intent` untuk menerima nilai balik.

Untuk detail, lihat parameter broadcast di bawah.

<br/>

### Basics - JSON Data Structure

?> Memerlukan v1.98.0+

Bagian ini memperkenalkan struktur data JSON yang umum digunakan di API.

#### 1. Item Reward Structure

Array JSON yang menentukan Hadiah Item, setiap Item berisi ID dan jumlah.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Achievement Unlock Condition Structure

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Purchase Limit Structure

`purchase_limit` adalah array JSON. Setiap objek mewakili satu aturan pembatasan.

| Field | Meaning | Type | Required | Notes |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Jenis pembatasan | number | Yes | Lihat tabel jenis di bawah |
| limitNumber | Nilai numerik utama | number | No* | Digunakan oleh aturan berbasis jumlah/rentang |
| maxNumber | Batas atas rentang | number | No | Digunakan oleh rentang Level Atribut / rentang jumlah Item dimiliki |
| limitId | ID target terkait | number | No* | Wajib untuk aturan berbasis Atribut / Item / Tugas / siklus Tugas / Pencapaian |
| extendInfo | Payload tambahan | string | No | Digunakan oleh aturan berbasis waktu; nilainya sendiri berupa string JSON |

**Definisi jenis**

| limitType | Meaning | Required fields / notes |
| --------- | ------- | ----------------------- |
| 0 | Batas jumlah harian | `limitNumber`: maks. kali per hari |
| 1 | Batas jumlah mingguan | `limitNumber`: maks. kali per minggu |
| 2 | Batas jumlah bulanan | `limitNumber`: maks. kali per bulan |
| 3 | Batas jumlah tahunan | `limitNumber`: maks. kali per tahun |
| 10 | Aturan Level Atribut | `limitId`: attribute ID<br/>`limitNumber`: Level minimum<br/>`maxNumber`: Level maksimum opsional |
| 20 | Rentang waktu harian | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Pemilihan hari kerja | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Senin = 1, Minggu = 7 |
| 22 | Rentang waktu absolut | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Pemilihan bulan | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Pemilihan hari dalam bulan | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Aturan jumlah Item dimiliki | `limitId`: target item ID<br/>`limitNumber`: jumlah minimum dimiliki<br/>`maxNumber`: jumlah maksimum dimiliki opsional |
| 31 | Aturan Tugas selesai | `limitId`: task ID |
| 32 | Aturan Pencapaian terbuka | `limitId`: achievement ID |
| 33 | Aturan siklus Tugas selesai | `limitId`: repeat task group ID (`groupId`)<br/>Divalidasi terhadap siklus terbaru yang dimulai dalam grup tersebut |

**Catatan**

- Saat `limitType=33`, `limitId` bukan task ID. Harus berupa `groupId` Tugas berulang.

- Payload kompatibel legacy dapat menghilangkan `maxNumber` dan `extendInfo`.
- `extendInfo` adalah field string, jadi saat memanggil API melalui URL, string JSON di dalamnya biasanya memerlukan lapisan escape/encode tambahan.

**Example:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Item Effect Structure

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Effect Type Description

?> Tipe 10-16 didukung sejak v1.102.0+.

| Type Code | Meaning | Parameter Description |
| ------- | ---- | ------- |
| 0 | Tidak ada efek khusus | Tidak ada parameter |
| 1 | Tidak dapat digunakan | Tidak ada parameter |
| 2 | Tambah koin | min: Koin minimum<br/>max: Koin maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas sistem (opsional) |
| 3 | Kurangi koin | min: Koin minimum<br/>max: Koin maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas sistem (opsional) |
| 4 | Tambah Poin Pengalaman | ids: Array Skill ID<br/>value: Nilai Poin Pengalaman (legacy, sama dengan min)<br/>min: Poin Pengalaman minimum (opsional, jika value tidak disediakan)<br/>max: Poin Pengalaman maksimum (opsional, default ke min/value)<br/>using_limit: Apakah menggunakan batas (opsional, default false) |
| 5 | Kurangi Poin Pengalaman | ids: Array Skill ID<br/>value: Nilai Poin Pengalaman (legacy, sama dengan min)<br/>min: Poin Pengalaman minimum (opsional, jika value tidak disediakan)<br/>max: Poin Pengalaman maksimum (opsional, default ke min/value)<br/>using_limit: Apakah menggunakan batas (opsional, default false) |
| 6 | Sintesis sederhana | require_number: Jumlah yang diperlukan<br/>item_id: Item ID |
| 7 | Buka Kotak Jarahan | items: Array Item, setiap Item berisi:<br/>- item_id: Item ID<br/>- amount: Jumlah<br/>- probability: Probabilitas<br/>- is_fixed_reward: Apakah Hadiah tetap |
| 8 | Hitung mundur | seconds: Detik hitung mundur |
| 9 | Tautan web | url: Alamat tautan<br/>use_web_view: Apakah menggunakan browser bawaan (opsional, default false) |
| 10 | Catat Perasaan | Tidak ada parameter |
| 11 | Ubah koin (tambah atau kurangi) | min: Koin minimum (dapat negatif)<br/>max: Koin maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas sistem (opsional) |
| 12 | Ubah Poin Pengalaman (tambah atau kurangi) | ids: Array Skill ID<br/>value: Nilai Poin Pengalaman (legacy, sama dengan min)<br/>min: Poin Pengalaman minimum (dapat negatif)<br/>max: Poin Pengalaman maksimum (opsional, default ke min/value)<br/>using_limit: Apakah menggunakan batas (opsional, default false) |
| 13 | Tambah stok Item | item_id: Target item ID<br/>min: Perubahan stok minimum<br/>max: Perubahan stok maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas stok (opsional) |
| 14 | Kurangi stok Item | item_id: Target item ID<br/>min: Perubahan stok minimum<br/>max: Perubahan stok maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas stok (opsional) |
| 15 | Ubah stok Item (tambah atau kurangi) | item_id: Target item ID<br/>min: Perubahan stok minimum (dapat negatif)<br/>max: Perubahan stok maksimum (opsional, default ke min)<br/>using_limit: Apakah menerapkan batas stok (opsional) |
| 16 | Putar suara | file_name: Nama file suara lokal (disarankan)<br/>uri: URI suara untuk diimpor (alternatif file_name)<br/>display_name: Nama tampilan (opsional) |

**Effect Example:**

Tambah koin acak:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Tambah Poin Pengalaman:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Ubah koin (acak +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Ubah stok Item (acak +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Putar suara:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Efek buka Kotak Jarahan:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Pesan pop-up

**Nama metode:** toast

**Deskripsi:** Menampilkan pesan pop-up dengan berbagai gaya

**Contoh:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Penjelasan:** Pesan "Live well, eat well!" muncul dengan gaya bonus dan ditampilkan lebih lama.

> Klik tautan contoh untuk menguji efeknya

| Parameter | Arti                | Tipe               | Contoh              | Wajib | Catatan |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Teks pesan yang ditampilkan | Teks apa pun           | You learned to call! | ya      |       |
| type      | Jenis gaya teks        | Angka 0 hingga 6 | 1                    | tidak       | 0 - Gaya normal<br/>1 - Gaya bonus<br/>2 - Gaya tomat<br/>3 - Gaya sukses<br/>4 - Gaya prompt<br/>5 - Gaya peringatan<br/>6 - Gaya error |
| isLong    | Durasi tampilan       | true atau false      | true                 | tidak       | true - lama<br/>false - pendek |

<br/>

### Hadiah

**Nama metode:** reward

**Deskripsi:** Memberikan Hadiah langsung. Alasan Hadiah dapat disesuaikan.

**Contoh:**

- Dapatkan 1 koin, alasan perolehannya adalah "Learn API Calls". Alasan akan ditampilkan di halaman detail koin:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Dapatkan 300 Poin Pengalaman untuk "Learning, Creativity", alasan perolehannya adalah "Learn API Calls". Alasan akan ditampilkan di halaman detail EXP:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Memperoleh 1 Item dengan pencocokan fuzzy "treasure", alasan perolehannya adalah "Learn API Calls". Alasan akan ditampilkan di halaman riwayat Inventaris:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parameter | Arti                       | Tipe                            | Contoh            | Wajib | Catatan                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | jenis Hadiah                   | saat ini hanya mendukung nilai berikut: <br/>coin<br/>exp<br/>item | coin | ya | coin - koin<br/>exp - Poin Pengalaman<br/>item - Item Toko |
| content   | alasan Hadiah                 | teks apa pun                        | Learning API Calls | Ya      |                                  |
| skills    | Keterampilan (Atribut)           | array angka lebih besar dari 0 | 1                  | Tidak       | Hanya tersedia jika type adalah exp<br/>Mendukung array (mis. &skills=1&skills=2&skills=3)<br/>Cara memperolehnya, lihat bagian "Basics - LifeUp Data ID" di atas |
| number    | jumlah Hadiah             | angka lebih besar dari 0         | 1                  | Ya      | Jika koin, nilai maksimum 999999<br/>Jika Poin Pengalaman, nilai maksimum 99999<br/>Jika Item, nilai maksimum 999 |
| item_id   | item id                       | angka lebih besar dari 0           | 1                  | tidak*      | hanya tersedia jika type adalah item |
| item_name | item name                     | teks apa pun                        | treasure           | tidak*      | hanya tersedia jika type adalah item, pencocokan fuzzy dengan nama Item |
| silent    | nonaktifkan prompt UI | true atau false                   | false              | tidak       | default false                 |

<br/>

### Penalti

**Nama metode:** penalty

**Deskripsi:** Memberikan penalti langsung. Alasan penalti dapat disesuaikan.

**Contoh:** *Pada dasarnya sama dengan antarmuka reward

- Penalti 1 koin, alasan perolehannya adalah "sleep in". Alasan akan ditampilkan di halaman detail koin:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Penalti 300 Poin Pengalaman "Strength" untuk "sleep in". Alasan akan ditampilkan di halaman detail EXP:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Penalti 1 Item dengan pencocokan fuzzy "treasure" untuk "sleep in". Alasan akan ditampilkan di halaman riwayat Inventaris:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parameter | Arti                       | Tipe                                                 | Contoh  | Wajib | Catatan            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | jenis penalti                  | Saat ini hanya mendukung: <br/>coin<br/>exp<br/>item | coin     | ya      | coin - koin<br/>exp - Poin Pengalaman<br/>item - Item Toko |
| content   | alasan penalti            | teks apa pun                                             | Sleep In | Ya      |                  |
| skills    | Keterampilan (Atribut)           | array angka lebih besar dari 0                      | 1        | Tidak       | Hanya tersedia jika type adalah exp<br/>Mendukung array (mis. &skills=1&skills=2&skills=3)<br/>Cara memperolehnya, lihat bagian "Basics - LifeUp Data ID" di atas |
| number    | jumlah penalti             | angka lebih besar dari 0                              | 1        | Ya      | Jika koin, nilai maksimum 999999<br/>Jika Poin Pengalaman, nilai maksimum 99999<br/>Jika Item, nilai maksimum 999 |
| item_id   | item id                       | angka lebih besar dari 0                                | 1        | tidak*      | hanya tersedia jika type adalah item |
| item_name | item name                     | teks apa pun                                             | treasure | tidak*      | hanya tersedia jika type adalah item, pencocokan fuzzy dengan nama Item |
| silent    | nonaktifkan prompt UI | true atau false                                        | false    | tidak       | default false |

<br/>

### Edit Koin

**Nama metode:** edit_coin

**Deskripsi:** Mengedit saldo koin pengguna secara langsung. Jumlah koin saat ini akan disetel ke nilai yang ditentukan. Alasan perubahan dapat disesuaikan dan akan ditampilkan di riwayat koin.

**Contoh:**

- Setel koin ke 1000 dengan alasan "API adjustment": <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Setel koin ke 500 secara diam-diam: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parameter | Arti | Tipe | Contoh | Wajib | Catatan |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Jumlah koin target | number >= 0 | 1000 | Ya | Saldo koin akhir setelah operasi, nilai maksimum 999999 |
| content | Alasan perubahan | teks apa pun | API adjustment | Tidak | Default ke alasan bawaan sistem jika tidak disediakan |
| reason | Alasan perubahan (alias) | teks apa pun | API adjustment | Tidak | Alternatif parameter content |
| silent | Nonaktifkan notifikasi UI | true atau false | false | Tidak | Default false, set true untuk menekan pesan toast |

<br/>

### Tugas

#### Tambah Tugas

?> Beberapa field seperti `pin` memerlukan v1.98.0+

**Nama metode:** add_task

**Deskripsi:** Membuat Tugas secara langsung

**Contoh:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parameter         | Arti             | Nilai                | Contoh   | Wajib | Catatan                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Konten Tugas        | teks apa pun             | Write diary | Ya     |                                |
| notes            | Catatan               | teks apa pun             | Notes      | Tidak       | Default kosong               |
| coin             | Hadiah koin         | number >= 0         | 10         | Tidak       | Default 0, tunduk pada batas sistem                   |
| coin_var         | Varians Hadiah koin| number >= 0          | 1          | Tidak       | Default 0; jika >0, Hadiah acak antara [coin, coin+coin_var] |
| exp              | Hadiah Poin Pengalaman   | number >= 0          | 100        | Tidak       | Default 0, tunduk pada batas sistem                   |
| skills           | Skill ID           | array angka > 0 | 1          | Tidak       | Mendukung array (mis., &skills=1&skills=2) |
| category         | List ID             | number >= 0          | 0          | Tidak       | Default 0 (daftar default); smart list tidak diizinkan |
| frequency        | Frekuensi pengulangan    | integer              | 0          | Tidak       | Default 0 (sekali)<br/>0 - Sekali<br/>1 - Harian<br/>N (N>1) - Setiap N hari<br/>-1 - Tanpa batas<br/>-3 - Ebbinghaus (memerlukan v1.99.1)<br/>-4 - Bulanan<br/>-5 - Tahunan |
| weekdays         | Hari kerja            | `1,3,5` atau `none`    | 1,3,5      | Tidak       | v1.106.0+; 1=Senin … 7=Minggu, hari **yang diulang**. Jika ada, frequency harus dihilangkan atau 1. `none` ditolak saat menambah; saat edit, `none` mengembalikan ke harian. Semua 7 hari diperlakukan sebagai harian |
| importance       | Tingkat kepentingan    | [1, 4]              | 1          | Tidak       | Default 1                   |
| difficulty       | Tingkat kesulitan    | [1, 4]              | 1          | Tidak       | Default 1                   |
| deadline         | Waktu jatuh tempo            | timestamp (milidetik) | 1640995200000 | Tidak |                               |
| no_deadline      | Tanpa jatuh tempo         | true/false         | true      | Tidak       | v1.104.0+; hanya valid untuk Tugas berulang. Meneruskan `&no_deadline=true` menghapus waktu jatuh tempo spesifik |
| color            | Warna tag           | string warna         | #66CCFF    | Tidak       | # harus di-escape sebagai %23        |
| background_url   | URL gambar latar| URL web             | http://example.com/bg.jpg | Tidak | Harus gambar web yang dapat diakses |
| background_alpha | Opasitas latar  | float antara [0, 1] | 0.5        | Tidak       | Default 1.0                |
| enable_outline   | Aktifkan outline teks | true atau false       | false      | Tidak       | Hanya valid dengan background_url, menambahkan outline pada teks agar lebih mudah dibaca |
| use_light_remark_text_color | Gunakan teks terang untuk catatan | true atau false | false | Tidak | Hanya valid dengan background_url, menggunakan warna terang untuk teks catatan |
| start_time       | Waktu mulai          | timestamp (milidetik) | 1640995200000 | Tidak | Waktu mulai Tugas              |
| auto_use_item    | Otomatis gunakan Item Hadiah| true atau false      | false      | Tidak       | Otomatis menggunakan Hadiah saat selesai |
| remind_time      | Waktu pengingat       | timestamp (milidetik) | 1640995200000 | Tidak | Waktu pengingat Tugas          |
| pin              | Sematkan Tugas            | true atau false       | false      | Tidak       | Menyematkan Tugas di atas                |
| words            | Teks Hadiah penyelesaian | teks apa pun         | Great job! | Tidak       | Teks motivasi yang ditampilkan saat Tugas selesai |
| frozen           | Status bekukan       | true atau false       | false      | Tidak       | Default false              |
| freeze_until     | Bekukan hingga        | timestamp (milidetik) | 1640995200000 | Tidak | Hanya efektif jika frozen true |
| coin_penalty_factor | Faktor penalti koin| float antara [0, 100) | 0.5    | Tidak       |                               |
| exp_penalty_factor | Faktor penalti Poin Pengalaman| float antara [0, 100) | 0.5 | Tidak    |                               |
| write_feelings   | Aktifkan Perasaan     | true atau false       | false      | Tidak       | Default false              |
| item_id          | Item ID             | number > 0          | 1          | Tidak*      | Diperlukan item_id atau item_name |
| item_name        | Item name           | teks apa pun            | Treasure   | Tidak*      | Diperlukan item_id atau item_name |
| item_amount      | Jumlah Item       | [1, 99]             | 1          | Tidak       | Default 1                  |
| items            | Hadiah Item        | teks JSON           | Lihat [Struktur Hadiah Item](#1-item-rewards-structure) | Tidak | Setel beberapa Hadiah Item |
| task_type        | Jenis Tugas           | [0, 4]              | 0          | Tidak       | Memerlukan v1.99.1<br/>0 - Tugas normal<br/>1 - Tugas hitung<br/>2 - Tugas negatif<br/>3 - Tugas API<br/>4 - Tugas berwaktu (v1.102.0+) |
| target_times     | Target hitungan        | number > 0          | 1          | Tidak       | Hanya valid jika task_type adalah 1 (Tugas hitung) |
| is_affect_shop_reward | Memengaruhi Hadiah Toko | true/false      | false    | Tidak       | Hanya valid jika task_type adalah 1 (Tugas hitung), apakah memengaruhi perhitungan Hadiah Item |
| enable_proportional_settlement | Aktifkan penyelesaian proporsional | true/false | false | Tidak | v1.104.0+; hanya valid jika task_type adalah 1 (Tugas hitung). Jika diaktifkan, penyelesaian progres hitung memberikan Hadiah secara proporsional, dan penyelesaian akhir tidak akan memberikan Hadiah yang sudah diselesaikan lagi |
| expected_focus_minutes | Menit Fokus yang diharapkan | number > 0 | 25 | Tidak | Hanya valid jika task_type adalah 4 (Tugas berwaktu); default 25 (v1.102.0+) |
| repeat_end_mode | Mode akhir pengulangan | 0 atau 1 | 0 | Tidak | Hanya valid untuk Tugas berulang (frequency bukan 0 / -1)<br/>0 - Berakhir menurut hitungan<br/>1 - Berakhir menurut tanggal (v1.102.0+) |
| repeat_target_times | Hitungan akhir pengulangan | number > 0 | 3 | Tidak | Digunakan jika repeat_end_mode=0 (atau disimpulkan dari keberadaan field ini); jangan bingung dengan target_times (v1.102.0+) |
| repeat_end_date | Tanggal akhir pengulangan | timestamp (milidetik) | 1640995200000 | Tidak | Digunakan jika repeat_end_mode=1 (atau disimpulkan dari keberadaan field ini) (v1.102.0+) |
| repeat_end_behavior | Perilaku akhir pengulangan | 0 atau 1 | 0 | Tidak | 0 - Mengakhiri Tugas setelah kondisi akhir tercapai<br/>1 - Membekukan Tugas setelah kondisi akhir tercapai (v1.102.0+) |

**Respons:**

| Field    | Tipe    | Deskripsi      | Contoh | Catatan                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | Task ID          | 1000    |                          |
| task_gid | Number  | Task group ID    | 1000    |                          |

<br/>

#### Selesaikan Tugas

**Nama metode:** complete

**Deskripsi:** Memicu penyelesaian Tugas. Hanya Tugas yang belum selesai yang akan dicari.

**Contoh:**

- Selesaikan Tugas dengan id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Selesaikan Tugas dengan "task group id" 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Cari Tugas berdasarkan nama dan selesaikan: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Penjelasan:**

Setiap Tugas memiliki id.

Untuk Tugas berulang, id akan diperbarui setiap kali, tetapi "task group id" tetap sama.

Cara memperoleh id adalah membuka "Developer Mode" di halaman "Labs", lalu melihatnya di halaman "Task Details".

| Parameter | Arti                         | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | task id                         | angka lebih besar dari 0 | 1       | tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| gid       | task group id                   | angka lebih besar dari 0 | 1       | tidak*      | task group id; |
| name      | name                            | teks apa pun              | get up  | tidak*      | pencarian fuzzy, hanya satu Tugas yang ditemukan |
| ui        | Tampilkan UI pop-up | true atau false         | true    | tidak       | default false, hanya menampilkan pesan di latar belakang |
| count                    | Nilai hitungan                        | Number                                                 | 1         | Tidak       | Hanya berlaku untuk Tugas hitung, gunakan bersama parameter `count_set_type`     |
| count_set_type           | Cara menetapkan nilai hitungan         | Salah satu dari berikut:<br/>absolute<br/>relative        | absolute  | Tidak       | Default relative<br/>absolute - Setel target langsung ke nilai<br/>relative - Tambah atau kurangi berdasarkan nilai asli |
| count_force_sum_up       | Paksa penjumlahan Hadiah Tugas hitung  | true atau false                                          | true      | Tidak       |                                                                                                    |
| reward_factor            | Faktor Hadiah                      | Angka floating point lebih besar dari 0                   | 1.1       | Tidak       | Tidak berlaku untuk Tugas hitung<br/>Faktor Hadiah memengaruhi jumlah Poin Pengalaman dan koin (bukan jumlah barang) |

**Perhatian:**

1. Agar dapat mencocokkan Tugas, salah satu id, gid, dan name harus disediakan.
2. Tugas berwaktu tidak dapat diselesaikan secara manual melalui API ini (v1.102.0+).

<br/>

#### Menyerah pada Tugas

**Nama metode:** give_up

**Deskripsi:** Memicu Tugas untuk menyerah.

**Contoh:**

- Cari Tugas berdasarkan nama dan menyerah: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Penjelasan:**

| Parameter | Arti       | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | angka lebih besar dari 0 | 1       | tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| gid       | task group id | angka lebih besar dari 0 | 1       | tidak*      | task group id; |
| name      | name          | teks apa pun              | get up  | tidak*      | pencarian fuzzy, operasi pada satu Tugas yang cocok |

**Perhatian:**

1. Agar dapat mencocokkan Tugas, salah satu id, gid, dan name harus disediakan.

<br/>

#### Bekukan Tugas

**Nama metode:** freeze

**Deskripsi:** Memicu pembekuan Tugas, hanya untuk Tugas berulang.

**Contoh:**

- Cari Tugas berdasarkan nama dan bekukan: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Penjelasan:**

| Parameter | Arti       | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | angka lebih besar dari 0 | 1       | tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| gid       | task group id | angka lebih besar dari 0 | 1       | tidak*      | task group id; |
| name      | name          | teks apa pun              | get up  | tidak*      | pencarian fuzzy, operasi pada satu Tugas yang cocok |
| time      | Bekukan hingga  | timestamp             | 1661688800682 | tidak | - |

**Perhatian:**

1. Agar dapat mencocokkan Tugas, salah satu id, gid, dan name harus disediakan.

<br/>

#### Batalkan pembekuan Tugas

**Nama metode:** unfreeze

**Deskripsi:** Memicu pembatalan pembekuan Tugas.

**Contoh:**

- Cari Tugas berdasarkan nama dan batalkan pembekuan: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Penjelasan:**

| Parameter | Arti       | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | angka lebih besar dari 0 | 1       | tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| gid       | task group id | angka lebih besar dari 0 | 1       | tidak*      | task group id; |
| name      | name          | teks apa pun              | get up  | tidak*      | pencarian fuzzy, operasi pada satu Tugas yang cocok |

**Perhatian:**

1. Agar dapat mencocokkan Tugas, salah satu id, gid, dan name harus disediakan.

<br/>

#### Hapus Tugas

**Nama metode:** delete_task

**Deskripsi:** Menghapus Tugas.

**Contoh:**

- Cari Tugas berdasarkan nama dan hapus: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Penjelasan:**

| Parameter | Arti       | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | task id       | angka lebih besar dari 0 | 1       | tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| gid       | task group id | angka lebih besar dari 0 | 1       | tidak*      | task group id; |
| name      | name          | teks apa pun              | get up  | tidak*      | pencarian fuzzy, operasi pada satu Tugas yang cocok |

**Perhatian:**

1. Agar dapat mencocokkan Tugas, salah satu id, gid, dan name harus disediakan.

<br/>

### Edit Tugas

?> Memerlukan v1.98.0+

**Nama metode:** edit_task

**Deskripsi:** Mengedit konten dan properti Tugas yang ada

**Contoh:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parameter           | Arti              | Nilai                | Contoh   | Wajib | Catatan                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | Task ID              | angka lebih besar dari 0 | 1        | Tidak*      | Salah satu id, gid, atau name wajib |
| gid                | Task group ID        | angka lebih besar dari 0 | 1        | Tidak*      | Salah satu id, gid, atau name wajib |
| name               | Nama Tugas            | teks apa pun             | Write diary| Tidak*      | Salah satu id, gid, atau name wajib |
| todo               | Konten Tugas         | teks apa pun             | Write weekly| Tidak      |                                |
| notes              | Catatan                | teks apa pun             | Note content| Tidak      |                                |
| coin               | Hadiah koin          | number >= 0         | 10        | Tidak       | Koin diperoleh saat selesai, tunduk pada batas sistem    |
| coin_var           | Varians koin        | angka lebih besar dari 0 | 1        | Tidak       | Hadiah acak antara [coin, coin+coin_var] |
| exp                | Hadiah Poin Pengalaman    | number >= 0          | 20        | Tidak       | Poin Pengalaman diperoleh, tunduk pada batas sistem        |
| skills             | Skill ID            | array angka lebih besar dari 0 | 1 | Tidak    | Mendukung array (mis., &skills=1&skills=2) |
| category           | List ID              | angka lebih besar dari atau sama dengan 0 | 0 | Tidak  | 0 untuk daftar default, smart list tidak didukung |
| frequency          | Frekuensi pengulangan     | integer              | 0         | Tidak       | Default 0 (sekali)<br/>0 - Sekali<br/>1 - Harian<br/>N (N>1) - Setiap N hari<br/>-1 - Tanpa batas<br/>-3 - Ebbinghaus (memerlukan v1.99.1)<br/>-4 - Bulanan<br/>-5 - Tahunan |
| weekdays           | Hari kerja             | `1,3,5` atau `none`    | 1,3,5     | Tidak       | v1.106.0+; sama seperti add_task. Abaikan untuk tidak mengubah; `none` mengembalikan ke harian; menetapkan frequency ke nilai selain 1 juga menghapus weekdays |
| importance         | Tingkat kepentingan     | [1, 4]              | 1         | Tidak       | Default 1                   |
| difficulty         | Tingkat kesulitan     | [1, 4]              | 2         | Tidak       | Default 1                   |
| deadline           | Tanggal jatuh tempo             | timestamp (milidetik) | 1640995200000 | Tidak |                               |
| no_deadline        | Tanpa jatuh tempo          | true/false         | true     | Tidak       | v1.104.0+; hanya valid untuk Tugas berulang. Meneruskan `&no_deadline=true` menghapus waktu jatuh tempo spesifik |
| remind_time        | Waktu pengingat        | timestamp (milidetik) | 1640995200000 | Tidak |                               |
| start_time         | Waktu mulai           | timestamp (milidetik) | 1640995200000 | Tidak |                               |
| color              | Warna tag            | string warna         | #66CCFF   | Tidak       | # harus di-escape sebagai %23        |
| background_url     | URL gambar latar | alamat URL web      | http://example.com/bg.jpg | Tidak |                         |
| background_alpha   | Opasitas latar   | floating point antara [0, 1] | 0.5 | Tidak   |                                |
| enable_outline     | Aktifkan outline teks  | true atau false       | false      | Tidak       | Hanya valid dengan background_url, menambahkan outline pada teks agar lebih mudah dibaca |
| use_light_remark_text_color | Gunakan teks terang untuk catatan | true atau false | false | Tidak | Hanya valid dengan background_url, menggunakan warna terang untuk teks catatan |
| item_id            | Item ID              | angka lebih besar dari 0 | 1        | Tidak*      | Diperlukan item_id atau item_name |
| item_name          | Item name            | teks apa pun             | Treasure  | Tidak*      | Diperlukan item_id atau item_name |
| item_amount        | Jumlah Item          | [1, 99]             | 1         | Tidak       | Default 1                   |
| items              | JSON Hadiah Item    | teks JSON           | [{"itemId":1,"amount":1}] | Tidak | Setel beberapa Hadiah Item |
| auto_use_item      | Otomatis gunakan Item        | true atau false        | false     | Tidak       |                                |
| frozen             | Status bekukan        | true atau false        | false     | Tidak       | Default false              |
| freeze_until       | Bekukan hingga         | timestamp (milidetik) | 1640995200000 | Tidak | Hanya efektif jika frozen true |
| coin_penalty_factor| Faktor penalti koin  | floating point antara [0, 100) | 0.5 | Tidak |                                |
| exp_penalty_factor | Faktor penalti Poin Pengalaman | floating point antara [0, 100) | 0.5 | Tidak |                             |
| write_feelings     | Aktifkan Perasaan      | true atau false        | false     | Tidak       |                                |
| pin                | Sematkan Tugas             | true atau false        | false     | Tidak       |                                |
| words              | Teks Hadiah penyelesaian | teks apa pun           | Great job!| Tidak       | Teks motivasi yang ditampilkan saat Tugas selesai |
| task_type        | Jenis Tugas           | [0, 4]              | 0          | Tidak       | Memerlukan v1.99.1<br/>0 - Tugas normal<br/>1 - Tugas hitung<br/>2 - Tugas negatif<br/>3 - Tugas API<br/>4 - Tugas berwaktu (v1.102.0+) |
| target_times     | Target hitungan        | number > 0          | 1          | Tidak       | Hanya valid jika task_type adalah 1 (Tugas hitung) |
| is_affect_shop_reward | Memengaruhi Hadiah Toko | true/false      | false    | Tidak       | Hanya valid jika task_type adalah 1 (Tugas hitung), apakah memengaruhi perhitungan Hadiah Item |
| enable_proportional_settlement | Aktifkan penyelesaian proporsional | true/false | false | Tidak | v1.104.0+; hanya valid jika task_type adalah 1 (Tugas hitung). Untuk Tugas hitung yang ada, parameter ini dapat diteruskan saja untuk mengaktifkan atau menonaktifkan penyelesaian proporsional; mengubah pengaturan ini atau konfigurasi Hadiah dapat mereset atau memutar balik progres yang sudah diselesaikan menurut aturan App |
| expected_focus_minutes | Menit Fokus yang diharapkan | number > 0 | 25 | Tidak | Hanya valid jika task_type adalah 4 (Tugas berwaktu); default 25 (v1.102.0+) |
| repeat_target_times | Hitungan akhir pengulangan | number > 0 | 3 | Tidak | Hanya valid untuk Tugas berulang (frequency bukan 0 / -1); jika repeat_target_times dan repeat_end_date keduanya disediakan, repeat_target_times diutamakan (v1.102.0+) |
| repeat_end_date | Tanggal akhir pengulangan | timestamp (milidetik) | 1640995200000 | Tidak | Hanya valid untuk Tugas berulang (frequency bukan 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Perilaku akhir pengulangan | 0 atau 1 | 0 | Tidak | 0 - Mengakhiri Tugas setelah kondisi akhir tercapai<br/>1 - Membekukan Tugas setelah kondisi akhir tercapai (v1.102.0+) |
| coin_set_type     | Cara menetapkan nilai koin | Salah satu dari:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel koin langsung ke nilai<br/>relative - tambah/kurangi dari nilai koin asli |
| exp_set_type      | Cara menetapkan nilai exp | Salah satu dari:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel exp langsung ke nilai<br/>relative - tambah/kurangi dari nilai exp asli |

**Respons:**

| Field     | Tipe    | Deskripsi      | Contoh | Catatan             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | Task ID          | 1000    |                  |
| task_gid  | Number  | Task group ID    | 1000    |                  |

<br/>

### Templat Tugas

?> Diperkenalkan di v1.102.0+

**Nama metode:** task_template

**Deskripsi:** CRUD untuk templat Tugas.

**Contoh:**

- Daftar templat: `lifeup://api/task_template?method=list`
- Buat dari parameter: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Buat dari Tugas yang ada: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Ambil templat: `lifeup://api/task_template?method=get&id=1`
- Perbarui nama templat: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Perbarui konten templat dari Tugas: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Hapus templat: `lifeup://api/task_template?method=delete&id=1`

| Parameter | Arti | Nilai | Contoh | Wajib | Catatan |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Operasi | list / get / create / update / delete | list | Ya | - |
| id | Template id | number > 0 | 1 | Tidak* | Wajib untuk get/update/delete; alias: template_id |
| template_id | Template id | number > 0 | 1 | Tidak* | Alias id |
| name | Nama templat | text | MyTemplate | Tidak* | Wajib untuk create; wajib untuk update jika tidak menggunakan from_task_id/from_task_gid |
| from_task_id | Buat dari task id | number > 0 | 1 | Tidak | Untuk create/update |
| from_task_gid | Buat dari task group id | number > 0 | 1 | Tidak | Untuk create/update |
| todo | Konten Tugas | text | Write diary | Tidak* | Wajib untuk create jika tidak menggunakan from_task_id/from_task_gid |
| notes | Catatan | text | Notes | Tidak | Default kosong |
| category | List ID | number >= 0 | 0 | Tidak | Alias: category_id |
| category_id | List ID | number >= 0 | 0 | Tidak | Alias category |
| frequency | Frekuensi pengulangan | integer | 0 | Tidak | Sama seperti add_task |
| weekdays | Hari kerja | `1,3,5` | 1,3,5 | Tidak | v1.106.0+; sama seperti add_task; create menolak `none` |
| importance | Tingkat kepentingan | [1, 4] | 1 | Tidak | - |
| difficulty | Tingkat kesulitan | [1, 4] | 1 | Tidak | - |
| coin | Hadiah koin | number | 10 | Tidak | - |
| coin_var | Varians Hadiah koin | number | 1 | Tidak | - |
| exp | Hadiah Poin Pengalaman | number | 100 | Tidak | - |
| skills | Skill ID | array params | 1 | Tidak | Mendukung array (mis., &skills=1&skills=2) |
| skill_ids | Skill ID | JSON array atau daftar koma | [1,2] | Tidak | Alternatif skills |
| deadline | Waktu jatuh tempo | timestamp (milidetik) | 1640995200000 | Tidak | - |
| start_time | Waktu mulai | timestamp (milidetik) | 1640995200000 | Tidak | - |
| remind_time | Waktu pengingat | timestamp (milidetik) | 1640995200000 | Tidak | - |
| words | Teks Hadiah penyelesaian | text | Great job! | Tidak | - |
| task_type | Jenis Tugas | [0, 4] | 0 | Tidak | 0 - Normal<br/>1 - Hitung<br/>2 - Negatif<br/>3 - API<br/>4 - Berwaktu |
| target_times | Target hitungan | number > 0 | 10 | Tidak | Hanya valid jika task_type adalah 1 (Tugas hitung) |
| is_affect_shop_reward | Memengaruhi Hadiah Toko | true / false | false | Tidak | Hanya valid jika task_type adalah 1 (Tugas hitung) |
| enable_proportional_settlement | Aktifkan penyelesaian proporsional | true / false | false | Tidak | v1.104.0+; hanya valid jika task_type adalah 1 (Tugas hitung). Tugas yang dibuat dari templat mempertahankan pengaturan penyelesaian Tugas hitung ini |
| expected_focus_minutes | Menit Fokus yang diharapkan | number > 0 | 25 | Tidak | Hanya valid jika task_type adalah 4 (Tugas berwaktu) |
| repeat_end_mode | Mode akhir pengulangan | 0 atau 1 | 0 | Tidak | Hanya valid untuk Tugas berulang (frequency bukan 0 / -1)<br/>0 - Berakhir menurut hitungan<br/>1 - Berakhir menurut tanggal |
| repeat_target_times | Hitungan akhir pengulangan | number > 0 | 3 | Tidak | Digunakan jika repeat_end_mode=0 (atau disimpulkan dari keberadaan field ini) |
| repeat_end_date | Tanggal akhir pengulangan | timestamp (milidetik) | 1640995200000 | Tidak | Digunakan jika repeat_end_mode=1 (atau disimpulkan dari keberadaan field ini) |
| repeat_end_behavior | Perilaku akhir pengulangan | 0 atau 1 | 0 | Tidak | 0 - Akhiri<br/>1 - Bekukan |

**Nilai balik:**

| Field | Arti | Tipe | Catatan |
| ----- | ------- | ---- | ----- |
| templates | daftar templat (string JSON) | text | Hanya untuk method=list |
| count | jumlah templat | number | Hanya untuk method=list |
| template | detail templat (string JSON) | text | Hanya untuk method=get |
| id | template id | number | Untuk get/create/update/delete |
| name | nama templat | text | Untuk get/create/update |
| success | apakah berhasil | true / false | Untuk create/update/delete |

<br/>

### Operasi Tugas Riwayat

?> Memerlukan v1.98.0+

**Nama metode:** history_operation

**Deskripsi:** Mengoperasikan Tugas yang selesai/menyerah/kedaluwarsa

**Contoh:**

- Hapus Tugas riwayat: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Tandai Tugas sebagai menyerah: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Mulai ulang Tugas: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> API ini hanya berlaku untuk Tugas yang bukan belum selesai (selesai, menyerah, atau kedaluwarsa)

| Parameter      | Arti           | Nilai               | Contoh    | Wajib | Catatan                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | Task ID           | angka lebih besar dari 0 | 1         | Ya      | ID Tugas riwayat          |
| operation     | Jenis operasi    | Salah satu dari:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Ya | delete - Hapus Tugas<br/>complete - Tandai selesai<br/>undo_complete - Batalkan penyelesaian<br/>set_to_give_up - Tandai menyerah<br/>set_to_overdue - Tandai kedaluwarsa<br/>edit_completed_time - Ubah waktu penyelesaian<br/>restart - Mulai ulang Tugas |
| completed_time | Waktu penyelesaian   | timestamp (milidetik) | 1640995200000 | Tidak* | Wajib hanya jika operation adalah edit_completed_time |

**Respons:**

| Field    | Tipe    | Deskripsi    | Contoh | Catatan                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | Task ID        | 1000    | ID Tugas yang dioperasikan  |

<br/>

### Pengaturan Toko

**Nama metode:** shop_settings

**Petunjuk:** Menyesuaikan berbagai pengaturan Toko

**Contoh:**

- Setel suku bunga ATM ke 0,01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Tingkatkan suku bunga 0,01% per klik: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Arti              | Tipe | Contoh | Wajib | Catatan |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | jenis                 | Saat ini hanya mendukung nilai berikut: <br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | ya | atm_interest - suku bunga harian ATM<br/>credit_interest - suku bunga harian pinjaman<br/>line_of_credit - jumlah yang dapat dipinjam<br/>discount_rate_for_returning - skala diskon pengembalian<br/>atm_balance - Setel saldo ATM |
| value     | nilai numerik        | angka desimal atau integer | 0.01 | ya | key berbeda sesuai rentang nilai berbeda<br/>Misalnya, saldo ATM tidak mendukung titik desimal |
| set_type  | Cara menetapkan nilai | Salah satu dari nilai berikut:<br/>absolute<br/>relative | absolute | tidak | absolute - nilai absolut, yaitu langsung setel target ke value<br/>relative - nilai relatif, menambah atau mengurangi dari nilai asli |
| silent    | Eksekusi diam-diam (tanpa menampilkan UI) | Boolean | false | Tidak | Didukung dari v1.93.0-beta01 (502) dan seterusnya<br/>Default false, artinya akan menampilkan prompt UI |

<br/>

### Lompat

**Nama metode:** goto

**Deskripsi:** Lompat ke halaman di `LifeUp`

**Contoh:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Penjelasan:** Lompat ke halaman Labs

| Parameter | Arti | Nilai | Contoh | Wajib | Catatan |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | halaman | Salah satu dari nilai berikut:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | ya | `purchase_dialog` merujuk ke popup pembelian<br/> `use_item_dialog` merujuk ke popup penggunaan Item<br/>Entri lainnya merujuk ke halaman utama tertentu |

#### 1. Lompat ke popup pembelian/penggunaan Item

Saat parameter `page` disetel ke `purchase_dialog` atau `use_item_dialog`, Anda dapat menentukan ID Item:

Contoh: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parameter | Arti | Nilai            | Contoh | Wajib | Catatan   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | ID Item | Positive integer | 1       | Ya      | ID Item |

<br/>

#### 2. Lompat ke subhalaman beranda

Saat parameter `page` adalah `main`, Anda dapat menentukan subhalaman tujuan:

Contoh, lompat ke halaman Toko: `lifeup://api/goto?page=main&sub_page=shop`

| Parameter   | Arti       | Nilai | Contoh | Wajib | Catatan  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | nama subhalaman | One of:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | tidak       |      |
| category_id | id daftar       | number | 0      | tidak       | Jika `sub_page` adalah halaman daftar, Anda dapat menentukan id daftar tujuan. <br/>Misalnya daftar Item Toko, daftar Inventaris, daftar Tugas. |

<br/>

#### 3. Lompat ke detail Tugas

Saat parameter `page` adalah `task_detail`, Anda dapat menentukan task id tujuan:

Contoh, lompat ke halaman detail Tugas dengan id 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parameter | Arti       | Nilai         | Contoh      | Wajib | Catatan |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | task id       | task id       | 53           | Tidak*      | task id; jika Tugas berulang, id diperbarui setiap kali diulang. |
| task_gid  | task group id | task group id | 3            | Tidak*      | task group id |
| task_name | task name     | string        | get up early | Tidak*      | task name, pencocokan fuzzy satu. |

**Perhatian:**

1. Hanya satu dari tiga parameter yang perlu disediakan.
    - Jika beberapa disediakan sekaligus, akan ada urutan prioritas internal. Namun ini adalah perilaku tak terdefinisi; App tidak menjamin urutannya.

<br/>

#### 4. Lompat ke halaman Pencapaian baru

Saat parameter `page` adalah `add_achievement`, Anda **harus** menentukan category id:

Contoh, lompat ke halaman Pencapaian baru dengan category id 1: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parameter    | Arti         | Nilai         | Contoh | Wajib | Catatan  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID kategori Pencapaian | Achievement category id | 1       | Ya      |        |

#### 5. Lompat ke halaman kategori Pencapaian tertentu

Saat parameter `page` adalah `user_achievement`, Anda **harus** menentukan category id:

Contoh, lompat ke halaman kategori Pencapaian dengan id 1: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parameter    | Arti         | Nilai         | Contoh | Wajib | Catatan  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID kategori Pencapaian | Achievement category id | 1       | Ya      |        |

#### 6. Lompat ke halaman kategori Sintesis tertentu

Saat parameter `page` adalah `synthesis`, Anda dapat menentukan category id secara opsional:

Contoh, lompat ke halaman kategori Sintesis dengan id 1: `lifeup://api/goto?page=synthesis&category_id=1`

| Parameter    | Arti         | Nilai         | Contoh | Wajib | Catatan  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID kategori Sintesis | Synthesis category id | 1       | Tidak       |        |

Anda juga dapat membuka halaman Sintesis dengan filter (v1.102.0+):

Contoh, filter berdasarkan product item id 1: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parameter        | Arti           | Nilai | Contoh | Wajib | Catatan |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Jenis filter       | product / ingredient / related | product | Tidak* | Memerlukan filter_item_id |
| filter_item_id  | ID Item filter    | number > 0 | 1 | Tidak* | Memerlukan filter_type |
| filter_item_name| Nama Item filter  | text | Gem | Tidak | Opsional, untuk tampilan |

### Toko

#### Menambahkan Item

?> Beberapa field seperti `effects` memerlukan v1.98.0+

**Nama metode:** add_item

**Deskripsi:** Buat Item Toko dengan properti yang dapat disesuaikan, termasuk batas pembelian dan efek penggunaan.

**Contoh:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parameter        | Arti                | Nilai               | Contoh       | Wajib | Catatan                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Nama Item             | any text             | 10 minute break | Ya    |                                 |
| desc            | Deskripsi           | any text             | Take a break  | Tidak       |                                 |
| icon            | Ikon                  | emoji, http(s) URL, or built-in sample name | ☕ | Tidak | Disimpan sebagai `emoji_*.webp`, `lifeup_sample_*`, atau URL. Emoji pada nama tidak mengatur ikon. |
| price           | Harga                 | [0, 999999]         | 10            | Tidak       | Default 0                    |
| stock_number    | Jumlah stok        | [-1, 99999]         | -1            | Tidak       | -1 berarti tak terbatas              |
| action_text     | Teks tombol aksi    | any text             | rest          | Tidak       |                                 |
| disable_purchase| Nonaktifkan pembelian      | true or false        | false         | Tidak       | Default false                |
| disable_use     | Nonaktifkan penggunaan           | true or false        | false         | Tidak       | Default false                |
| category        | ID Kategori           | number greater than or equal to 0 | 0 | Tidak    | 0 untuk kategori default          |
| order           | Urutan tampilan         | integer              | 1             | Tidak       | Posisi dalam kategori            |
| purchase_limit  | Aturan pembatasan     | JSON text            | Lihat [Purchase Limit Structure](#3-purchase-limit-structure) | Tidak | Pembatasan pembelian/penggunaan yang dapat dikonfigurasi |
| limit_scope     | Cakupan pembatasan     | purchase / use / both | purchase | Tidak | Hanya efektif saat `purchase_limit` tidak kosong; default `purchase` |
| effects         | Efek penggunaan           | JSON text            | Lihat [Item Effects Structure](#4-item-effects-structure) | Tidak | Efek penggunaan Item |
| own_number      | Jumlah kepemilikan awal | integer             | 0             | Tidak       | Setel jumlah Inventaris awal  |
| unlist          | Sembunyikan dari Toko        | true or false        | false         | Tidak       | Default false                |

**Data balik:**

| Field    | Tipe    | Deskripsi    | Contoh | Catatan                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | ID Item        | 1000    | ID Item yang dibuat   |

!> Parameter effects akan menimpa disable_use. Jika Anda set effects untuk menandai Item tidak dapat digunakan, disable_use diabaikan.

<br/>

#### Edit Item

?> Memerlukan v1.98.0+

**Nama metode:** item

**Deskripsi:** Ubah Item yang ada, termasuk harga, stok, efek, dan properti lainnya

**Contoh:**

- Sesuaikan harga: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Ubah effects: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - Konten terdekode parameter effects: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parameter         | Arti             | Nilai               | Contoh   | Wajib | Catatan                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | ID Item             | number greater than 0| 1         | Tidak*      | id atau name wajib disediakan      |
| name             | Nama Item           | any text             | Treasure  | Tidak*      | Untuk pencarian fuzzy, bukan penggantian nama  |
| set_name         | Setel nama            | any text             | Treasure  | Tidak       | Tidak boleh kosong                 |
| set_desc         | Setel deskripsi     | any text             | Get gift  | Tidak       |                                |
| set_icon         | Setel ikon            | emoji, http(s) URL, or built-in sample name | ☕ | Tidak | Sama seperti `icon`. Nilai tidak didukung mengembalikan `unsupported_parameter`. |
| set_price        | Sesuaikan harga        | integer              | 1         | Tidak       |                                |
| set_price_type   | Metode penyesuaian harga | absolute or relative | relative  | Tidak       | absolute-set langsung<br/>relative-tambah/kurang |
| own_number       | Sesuaikan jumlah kepemilikan| integer             | 1         | Tidak       | Mendukung negatif dengan relative |
| own_number_type  | Penyesuaian own number| absolute or relative| relative  | Tidak       | absolute-set langsung<br/>relative-tambah/kurang |
| stock_number     | Sesuaikan stok        | [-1, 99999]         | 1         | Tidak       | -1 berarti stok tak terbatas        |
| stock_number_type| Metode penyesuaian stok | absolute or relative | relative  | Tidak       | absolute-set langsung<br/>relative-tambah/kurang |
| disable_purchase | Nonaktifkan pembelian    | true or false        | false     | Tidak       | Default false              |
| disable_use      | Nonaktifkan penggunaan         | true or false        | false     | Tidak       | Default false              |
| action_text      | Teks tombol gunakan     | any text             | Use       | Tidak       |                                |
| title_color_string| Warna judul        | color string         | #66CCFF   | Tidak       | # harus di-escape sebagai %23<br/>Nilai kosong mengembalikan default |
| effects          | Efek penggunaan         | JSON text            | Lihat [Item Effects Structure](#4-item-effects-structure) | Tidak | Setel efek penggunaan Item |
| purchase_limit   | Aturan pembatasan   | JSON text            | Lihat [Purchase Limit Structure](#3-purchase-limit-structure) | Tidak | Kirim `null` untuk menghapus semua pembatasan |
| limit_scope      | Cakupan pembatasan   | purchase / use / both | purchase | Tidak | Hanya diperbarui saat field ini disediakan; dihapus otomatis saat `purchase_limit` kosong |
| category_id      | ID Kategori         | number >= 0          | 1         | Tidak       | 0 untuk kategori default         |
| order            | Urutan tampilan       | integer              | 1         | Tidak       | Posisi dalam kategori           |
| unlist           | Hapus dari Toko    | true or false        | false     | Tidak       | Default false              |

!> Parameter id atau name harus disediakan untuk menemukan Item yang akan diubah

<br/>

#### Sesuaikan efek Kotak Jarahan

**Nama metode:** loot_box

**Deskripsi:** Ubah efek Kotak Jarahan Item kotak tertentu; mendukung penyesuaian probabilitas, jumlah Hadiah, dan penambahan konten. (Penghapusan belum didukung)

**Contoh:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Penjelasan:** Tingkatkan proporsi tas koin emas [besar] dalam kotak koin emas sebesar 1 poin.

| Parameter   | Arti                               | Tipe                                                    | Contoh        | Wajib | Catatan                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | item id                               | a number greater than 0                                 | 1              | tidak*      | Lihat "Basic Knowledge - LifeUp Data ID" di atas untuk cara mendapatkannya |
| name        | item name                             | any text                                                | Treasure chest | tidak*      | Saat id tidak diketahui, pencarian fuzzy produk, bukan penggantian nama |
| sub_id      | content item id                       | a number greater than 0                                 | 1              | tidak*      | id isi kotak                                         |
| sub_name    | content item name                     | any text                                                | Get a gift     | tidak*      | Pencarian fuzzy Item saat id isi kotak tidak diketahui |
| set_type    | metode penyesuaian (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | tidak       | absolute - nilai absolut, yaitu langsung setel target ke value<br/>relative - nilai relatif, menambah atau mengurangi dari nilai asli |
| amount      | jumlah content item                | number                                                  | 1              | tidak       | jumlah Hadiah untuk satu Item                          |
| probability | probabilitas content item       | number                                                  | 1              | tidak       | -                                                            |
| fixed       | apakah Hadiah tetap          | boolean                                                 | true/false     | tidak       | -                                                            |

**Perhatian:**

1. Agar dapat mencari produk, id atau name harus disediakan.
1. Agar dapat mencari konten, sub_id atau sub_name harus disediakan.
1. `name` dan `sub_name` mencoba pencocokan exact terlebih dahulu, lalu fallback ke fuzzy matching.
1. API `loot_box` legacy mempertahankan perilaku kompatibilitasnya: jika Item konten yang sama muncul beberapa kali dengan amount berbeda, entri pertama yang cocok diedit dan tidak menggunakan `sub_amount` untuk disambiguasi. Gunakan `loot_box/v2` jika Anda perlu pengeditan, penghapusan, atau merge spesifik amount.

<br/>

#### Sesuaikan efek Kotak Jarahan (v2)

?> API ini diperkenalkan di v1.104.2.

**Nama metode:** loot_box/v2

**Deskripsi:** Versi yang ditingkatkan dari API loot_box. Ubah efek Kotak Jarahan Item kotak tertentu; mendukung penyesuaian probabilitas, jumlah Hadiah, penambahan konten, dan **penghapusan konten**.

**Peningkatan dibanding v1:**
- **`sub_amount` untuk pencocokan presisi**: Saat kotak berisi beberapa entri Item yang sama dengan amount berbeda (mis. A x1 50%, A x2 30%), gunakan `sub_amount` untuk menarget entri tertentu. Nilai default `1`. Jika entri yang cocok tidak ditemukan, LifeUp mencari Item berdasarkan `sub_id` / `sub_name` dan menambahkan entri baru; jika permintaan adalah penghapusan `amount=0`, entri baru tidak ditambahkan.
- **`set_type` independen**: `amount_set_type` dan `probability_set_type` dapat dikontrol secara independen. `set_type` global berfungsi sebagai default fallback.
- **Dukungan penghapusan**: Setel `amount=0` dengan `amount_set_type=absolute` (atau dihitung `<=0` dengan `relative`) menghapus entri yang cocok.
- **Merge duplikat**: Jika mengubah `amount` akan menduplikasi entri yang ada dengan Item dan amount yang sama dalam kotak yang sama, LifeUp menggabungkannya ke entri yang ada dan melanjutkan menerapkan nilai `probability` / `fixed` dari permintaan.

**Contoh:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Penjelasan:** Tingkatkan probabilitas tas koin emas [besar] (x2) dalam kotak koin emas sebesar 10 poin.

| Parameter              | Arti                               | Tipe                                                    | Contoh        | Wajib | Catatan                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | item id                               | a number greater than 0                                 | 1              | tidak*      | Lihat "Basic Knowledge - LifeUp Data ID" di atas untuk cara mendapatkannya |
| name                   | item name                             | any text                                                | Treasure chest | tidak*      | Saat id tidak diketahui, pencarian fuzzy produk, bukan penggantian nama |
| sub_id                 | content item id                       | a number greater than 0                                 | 1              | tidak*      | id isi kotak. Jika sub_id dan sub_name keduanya disediakan, sub_id diutamakan |
| sub_name               | content item name                     | any text                                                | Get a gift     | tidak*      | Pencarian fuzzy Item saat id isi kotak tidak diketahui |
| sub_amount             | amount content item untuk pencocokan      | number                                                  | 2              | tidak       | Digunakan untuk mencocokkan entri dengan amount ini secara presisi. Minimum `1`, default `1`. Jika tidak ada yang cocok dan ini bukan permintaan penghapusan, entri baru ditambahkan. |
| set_type               | metode penyesuaian global              | one of: `absolute` / `relative`                         | relative       | tidak       | Default untuk `amount_set_type` dan `probability_set_type` jika tidak ditentukan |
| amount_set_type        | metode penyesuaian untuk amount          | one of: `absolute` / `relative`                         | relative       | tidak       | Menimpa `set_type` untuk field amount                    |
| probability_set_type   | metode penyesuaian untuk probability     | one of: `absolute` / `relative`                         | absolute       | tidak       | Menimpa `set_type` untuk field probability               |
| amount                 | jumlah content item                | number                                                  | 1              | tidak       | jumlah Hadiah untuk satu Item. `0` (absolute) atau dihitung `<=0` (relative) menghapus entri |
| probability            | probabilitas content item       | number                                                  | 1              | tidak       | -                                                            |
| fixed                  | apakah Hadiah tetap          | boolean                                                 | true/false     | tidak       | -                                                            |
| query                  | daftar isi kotak                     | true or false                                           | true           | tidak       | v1.105.1+. Hanya mengembalikan JSON Item; sub_id / sub_name tidak wajib |

**Perhatian:**

1. Agar dapat mencari produk, id atau name harus disediakan.
1. Agar dapat mencari konten, sub_id atau sub_name harus disediakan. Gunakan `query=true` untuk mendaftar isi tanpa sub_id / sub_name.
1. Jika `sub_id` dan `sub_name` keduanya disediakan, `sub_id` diutamakan. `sub_name` hanya digunakan saat tidak ada `sub_id` yang valid.
1. `name` dan `sub_name` mencoba pencocokan exact terlebih dahulu, lalu fallback ke fuzzy matching.
1. `sub_amount` default `1`. Saat kotak memiliki beberapa entri Item yang sama dengan amount berbeda, sediakan `sub_amount` untuk menarget entri tertentu. Jika tidak ada yang cocok dan ini bukan permintaan penghapusan, entri baru dengan `amount=sub_amount` ditambahkan.
1. Untuk menghapus entri, setel `amount=0` dengan `amount_set_type=absolute`, atau gunakan `amount_set_type=relative` dengan nilai negatif yang membawa total ke `<=0`. Penghapusan hanya berlaku untuk entri yang cocok; jika tidak ada entri yang cocok, `amount=0` tidak menambahkan entri baru.
1. Jika mengubah `amount` entri akan menduplikasi entri yang ada dengan Item dan amount yang sama dalam kotak yang sama, LifeUp menggabungkannya ke entri yang ada dan melanjutkan menerapkan nilai `probability` / `fixed` dari permintaan.
1. Saat penghapusan membuat kotak kosong, seluruh efek Kotak Jarahan di-soft-delete (Item itu sendiri tetap ada dan Anda dapat menambahkan entri Kotak Jarahan lagi nanti).

<br/>

#### Gunakan Item

?> API ini diperkenalkan di v1.93.0-beta01 (502).

**Nama metode:** use_item

**Deskripsi:** Gunakan Item tertentu.

**Contoh:**

- Buka kotak koin: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parameter | Arti     | Tipe                    | Contoh  | Wajib | Catatan                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | ID Item     | a number greater than 0 | 1        | Tidak*      | Untuk mendapatkan ID Item, lihat bagian "Basic Knowledge - LifeUp Data ID" |
| name      | Nama Item   | Any text                | coin_box | Tidak*      | Untuk ID tidak diketahui; melakukan pencarian fuzzy Item      |
| use_times | Jumlah penggunaan | a number greater than 0 | 1        | Tidak       | Default 1 kali<br/>Untuk Item biasa atau membuka kotak, sesuai dengan jumlah Item<br/>Untuk Item Sintesis sederhana, nilai ini sesuai dengan "jumlah sintesis" bukan jumlah Item yang dikonsumsi |

**Balik:**

!> API ini dapat gagal karena beberapa alasan, dan alasan kegagalan spesifik dapat disediakan dalam nilai balik.

| Parameter | Arti            | Tipe     | Contoh          | Wajib | Catatan                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Kode hasil        | a number | 0                | Ya      | 0 - Penggunaan berhasil<br/>1 - Pengecualian database<br/>2 - Pembatasan Poin Pengalaman tidak cukup<br/>3 - Item tidak ditemukan<br/>4 - Konflik countdown berjalan<br/>5 - Inventaris tidak cukup<br/>6 - Item tidak dapat digunakan<br/>7 - Batas koin<br/>8 - Batas stok target<br/>9 - Pembatasan level Atribut<br/>10 - Pembatasan waktu<br/>11 - Pembatasan jumlah Item dimiliki<br/>12 - Pembatasan penyelesaian Tugas<br/>13 - Pembatasan pembukaan Pencapaian<br/>14 - Pembatasan jumlah periode<br/>15 - Pembatasan siklus Tugas selesai |
| desc      | Deskripsi hasil | Text     | RunningCountDown | Ya      |                                                              |

<br/>

### ATM

**⚠ Hanya tersedia di v1.91+**

> Operasi setor dan tarik di sini akan diverifikasi.
>
> Jika Anda perlu menyesuaikan nilai saldo ATM secara langsung, lihat antarmuka "Pengaturan Toko" di atas.

#### Setor

**Nama metode:** deposit

**Deskripsi:** Setoran akan diperiksa legalitasnya (apakah saldo koin cukup).

**Contoh:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Penjelasan:** Setor 500 koin.

| Parameter | Arti        | Tipe                    | Contoh | Wajib | Catatan |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | jumlah setor | a number greater than 0 | 100     | ya      | -     |

**Balik:**

| Parameter | Arti                              | Tipe              | Contoh | Wajib | Catatan |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Apakah operasi berhasil | `true` or `false` | true    | ya      | -     |

<br/>

#### Tarik

**Nama metode:** withdraw

**Deskripsi:** Penarikan akan diperiksa legalitasnya (apakah saldo ATM cukup).

**Contoh:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Penjelasan:** Tarik 500 koin.

| Parameter | Arti           | Tipe                    | Contoh | Wajib | Catatan |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | jumlah penarikan | a number greater than 0 | 100     | ya      | -     |

**Balik:**

| Parameter | Arti                              | Tipe              | Contoh | Wajib | Catatan |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Apakah operasi berhasil | `true` or `false` | true    | ya      | -     |

<br/>

### Pomodoro Timer

**Nama metode:** pomodoro_timer

**Deskripsi:** Kontrol timer hitung mundur atau hitung maju Pomodoro nyata di LifeUp. API ini memulai
sesi timer yang sama dengan UI App; tidak langsung menambahkan catatan Pomodoro atau tomat.

**Contoh:**

- Mulai atau lanjutkan hitung mundur kerja default:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Mulai timer hitung maju dan pilih Tugas 101:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Jeda hitung mundur aktif:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Batalkan dan reset siklus Pomodoro:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Lewati tahap Pomodoro saat ini:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Selesaikan timer hitung maju tanpa menerima Hadiah tomat:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Kueri kedua mode timer:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parameter:**

| Parameter | Arti | Tipe / nilai | Wajib | Catatan |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operasi | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | ya | - |
| mode | Mode timer | `countdown`, `count_up` | untuk `start`, `pause`, `abandon`, dan `complete` | `skip` selalu menarget hitung mundur. |
| stage | Tahap hitung mundur | `work`, `short_break`, `long_break` | tidak | Hanya valid dengan `mode=countdown`. Jika diabaikan, tahap kanonik aktif, dijeda, atau staged-next digunakan; siklus baru dimulai dengan `work`. |
| receive_reward | Apakah menerima Hadiah tomat | `true` or `false` | untuk `complete` | Boolean ketat. `complete` hanya mendukung `mode=count_up`. |
| task_id | ID Tugas | positive integer | tidak | Tidak dapat digabung dengan `task_gid` atau `task_name`. |
| task_gid | ID grup Tugas | positive integer | tidak | Dapat digabung dengan `task_name` untuk mempersempit pencocokan. |
| task_name | Nama Tugas | text | tidak | Pencocokan exact diutamakan, dengan fuzzy matching sebagai fallback. |
| clear_task | Hapus Tugas timer | `true` or `false` | tidak | `true` tidak dapat digabung dengan locator Tugas. |

`select_task` memerlukan locator Tugas atau `clear_task=true`. `start` dapat menyertakan parameter
pemilihan Tugas yang sama. Parameter durasi kustom tidak didukung: hitung mundur menggunakan
durasi default saat ini atau durasi Pomodoro Tugas yang dipilih.

`abandon&mode=countdown` setara dengan aksi kiri App: menyerahkan tahap saat ini,
mereset siklus Pomodoro, dan kembali ke tahap kerja berhenti. `skip` setara dengan aksi
kanan: maju dari kerja ke istirahat pendek/panjang, atau istirahat ke kerja, tanpa otomatis
memulai tahap berikutnya. Setiap panggilan `skip` adalah aksi nyata, non-idempotent; pemanggil tidak boleh retry
secara otomatis.

`complete&mode=count_up` menyelesaikan sesi hitung maju nyata. Sesi lebih pendek dari 30 detik
dikonsumsi tanpa membuat catatan. Dengan `receive_reward=false`, catatan yang memenuhi ambang batas
tetap disimpan sebagai ditinggalkan tetapi tidak memberikan tomat.

**Aturan pergantian Tugas:**

- Hitung mundur kerja yang berjalan menolak perubahan Tugas.
- Timer hitung maju yang berjalan mengizinkan perubahan Tugas dan memperbarui notifikasinya.
- Hitung mundur yang dijeda mengizinkan perubahan Tugas dan mempertahankan waktu yang telah berlalu sambil menghitung ulang total
  durasinya dari pengaturan Tugas baru.

**Nilai balik sukses:**

| Parameter | Arti | Tipe |
| --------- | ------- | ---- |
| api_result | Apakah panggilan API berhasil | boolean |
| applied | Apakah panggilan ini mengubah status timer | boolean |
| mode | Mode timer target atau yang dipilih saat ini | `countdown` or `count_up` |
| state | Status `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | ID Tugas timer saat ini, atau `0` | number |
| can_start_in_background | Apakah Android saat ini mengizinkan memulai timer di latar belakang | boolean |
| countdown_state | Status hitung mundur kanonik | `running`, `paused`, or `stopped` |
| countdown_phase | Fase siklus hitung mundur | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Tahap hitung mundur kanonik | `work`, `short_break`, or `long_break` |
| countdown_session_id | ID sesi hitung mundur kanonik | text or null |
| countdown_total_millis | Total durasi hitung mundur | milliseconds |
| countdown_remaining_millis | Sisa durasi hitung mundur | milliseconds |
| count_up_state | Status hitung maju kanonik | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Durasi hitung maju yang telah berlalu | milliseconds |
| battery_optimization_ignored | Apakah LifeUp dikecualikan dari optimasi baterai | boolean |

Respons `complete` yang berhasil juga berisi `record_created`, `reward_tomatoes`, dan
`settled_elapsed_millis`.

Panggilan `start`, `pause`, atau `abandon` berulang yang sudah cocok dengan status yang diminta berhasil dengan
`applied=false`. Panggilan mutasi tidak menyediakan deduplikasi retry lintas proses.

**Kesalahan:**

Kegagalan mengembalikan `api_result=false`, `error_code`, dan `error_message`. Kode error stabil
khusus timer:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

Di Android 12 dan seterusnya, panggilan ContentProvider latar belakang dapat memulai timer hanya saat LifeUp
diizinkan mengabaikan optimasi baterai. Jika tidak, mengembalikan `background_start_not_allowed`
sebelum mengubah status timer. Membuka URL Scheme melalui Activity-nya membawa LifeUp ke
foreground sebelum memulai. Android dapat memblokir aplikasi pihak ketiga meluncurkan Activity tersebut dari
latar belakang; saat itu terjadi, LifeUp tidak menerima panggilan API dan tidak dapat mengembalikan error.

<br/>

### Catatan Pomodoro

#### Tambah Catatan Pomodoro

**Nama metode:** add_pomodoro

**Deskripsi:** Tambahkan catatan waktu tomat

**Contoh:**

- Tambahkan catatan waktu dengan durasi 25 menit (1500000 ms) dan arahkan ke Tugas yang namanya mengandung learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Tambahkan catatan waktu untuk `2022-08-01 11:00:00` - `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Penjelasan:**

| Parameter        | Arti                    | Tipe                    | Contoh       | Wajib | Catatan |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | waktu mulai waktu          | timestamp               | 1659322800000 | tidak*      | Jika Anda tidak tahu apa itu Timestamp, cari di Google! |
| duration         | durasi Fokus             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | tidak* | |
| end_time         | waktu akhir waktu            | timestamp               | 1659326400000 | tidak*      |       |
| reward_tomatoes  | apakah memberi Hadiah tomat | true or false           | true          | tidak       | default false |
| task_id          | task id                    | a number greater than 0 | 1             | tidak       |       |
| task_gid         | task group id              | a number greater than 0 | 1             | tidak       |       |
| task_name        | name                       | any text                | learning      | tidak       | pencarian fuzzy, hanya satu dari Tugas yang ditemukan |
| ui               | Tampilkan UI tomat Hadiah | true or false         | true          | tidak       | Diperkenalkan di v1.94.0, default true |

**Perhatian:**

1. Salah satu dari start_time, duration, end_time harus disediakan.
2. Jika hanya duration, default end_time adalah waktu saat ini.
3. end_time harus lebih besar dari start_time.
4. duration minimal 30000 milidetik (30 detik).
5. Jika start_time, duration, end_time semuanya disediakan, duration harus kurang dari atau sama dengan (end_time - start_time).

<br/>

#### Edit Catatan Pomodoro

> Diperkenalkan di v1.94.0
> **Nama metode:** edit_pomodoro

**Deskripsi:** Edit catatan waktu Pomodoro yang ada atau tambahkan catatan baru jika `edit_item_id` yang valid disediakan.

**Contoh:**

- Edit catatan dengan ID tertentu, setel durasi 45 menit (2700000 ms), dan beri Hadiah tomat: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Edit catatan berdasarkan waktu mulai dan akhir: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parameter:**

| Parameter       | Arti                    | Tipe                  | Contoh       | Wajib | Catatan                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | ID Tugas                    | Number greater than 0 | 101           | Tidak       | Pengenal unik untuk Tugas                   |
| task_gid        | ID grup Tugas              | Number greater than 0 | 5             | Tidak       | Jika disediakan, menimpa task_id                |
| task_name       | Nama Tugas                  | Any text              | Study         | Tidak       | Harus disediakan jika task_id atau task_gid tidak ada   |
| start_time      | Waktu mulai waktu          | Timestamp             | 1659322800000 | Tidak*      | Cari di Google untuk memahami apa itu timestamp     |
| end_time        | Waktu akhir waktu            | Timestamp             | 1659326400000 | Tidak*      | -                                                |
| duration        | Durasi Fokus             | Number (milliseconds) | 2700000       | Tidak*      | Minimal 30000 milidetik (30 detik) |
| reward_tomatoes | Apakah memberi Hadiah tomat | true or false         | true          | Tidak       | Default false                                 |
| edit_item_id    | ID item yang diedit     | Number greater than 0 | 123           | Ya      | Menentukan ID catatan yang diedit                  |
| ui              | Tampilkan UI Hadiah tomat | true or false         | true          | Tidak       |                                                  |
| delete          | Hapus catatan          | true or false         | true          | Tidak       | v1.105.1+. Soft-delete catatan pomodoro (`isDel`), sama seperti App |

**Nilai balik:**

| Parameter | Arti                          | Tipe   | Contoh | Wajib | Catatan                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomat diperoleh dari aksi ini | Number | 2       | Tidak       | Dikembalikan jika `ui` true |

**Catatan:**

1. Minimal satu dari `start_time`, `duration`, `end_time` harus disediakan.
2. `end_time` harus lebih besar dari `start_time`.
3. `duration` harus kurang dari atau sama dengan (`end_time` - `start_time`).
4. Jika `edit_item_id` disediakan dan catatan yang sesuai ditemukan, catatan akan diedit; jika tidak, catatan baru dibuat berdasarkan parameter lain.

<br/>

### Kondisi Buka Pencapaian

**Nama metode:** unlock_condition

**Deskripsi:** Kondisi buka Pencapaian: memerlukan panggilan API eksternal untuk membuka

**Contoh:**

- Panggil kondisi buka dengan unlock id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Arti      | Tipe                  | Contoh | Wajib | Catatan |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | condition id | number greater than 0 | 2       | ya      |       |

<br/>

### Selesaikan / Klaim Pencapaian

?> API ini diperkenalkan di v1.105.1.

**Nama metode:** complete_achievement

**Deskripsi:** Menyelesaikan Pencapaian manual dan mengklaim Hadiahnya, atau mengklaim Hadiah Pencapaian otomatis yang sudah terbuka. Perilaku sama dengan mengetuk kotak centang selesai / tombol klaim Hadiah di App.

**Contoh:**

- Selesaikan atau klaim Pencapaian dengan id 1: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parameter | Arti        | Tipe                  | Contoh | Wajib | Catatan |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | achievement id | number greater than 0 | 1       | ya      |       |

**Nilai kembali:**

| Field  | Tipe   | Deskripsi | Contoh | Catatan |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | achievement ID | 1 | |
| status | number | status setelah panggilan | 2 | `0` terkunci · `1` terbuka, Hadiah belum diklaim · `2` terbuka, Hadiah sudah diklaim |

**Catatan:**

1. Pencapaian manual (tanpa kondisi buka): jika masih terkunci, panggilan ini menyelesaikan Pencapaian dan memberikan Hadiah.
2. Pencapaian otomatis (dengan kondisi buka): hanya mengklaim Hadiah jika sudah terbuka dan masih ada Hadiah yang menunggu. Jika kondisi belum terpenuhi, panggilan gagal dengan `error_code=achievement_not_unlocked`.
3. Memanggil lagi setelah Hadiah sudah diklaim berhasil dengan `status=2` dan tidak memberikan Hadiah dua kali.
4. Ini berbeda dari `achievement?unlocked=true`, yang hanya menulis status buka dan tidak memberikan Hadiah.

<br/>

### Setel jumlah langkah

**Nama metode:** step

**Deskripsi:** Menetapkan jumlah langkah pada tanggal tertentu; misalnya dapat dipakai untuk memasukkan jumlah langkah dengan gelang + alat otomatisasi. Juga dapat dipakai untuk mengubah catatan historis.

**Contoh:**

- Sesuaikan jumlah langkah untuk 2022-10-21 di zona waktu GMT+8 menjadi 9999 langkah: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parameter | Arti                         | Tipe                                | Contoh       | Wajib | Catatan |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | jumlah langkah                 | a number greater than or equal to 0 | 9999          | ya      |       |
| time      | timestamp sembarang dari tanggal | timestamp (ms)                      | 1666282995643 | ya      |       |

<br/>

### Edit Poin Pengalaman

?> API ini diperkenalkan di versi v1.93.0-beta01 (502).

**Nama metode:** edit_exp

**Deskripsi:** API ini dapat menetapkan nilai Poin Pengalaman saat ini untuk Atribut secara batch. Dapat langsung menetapkan nilai pengalaman tertentu atau Level tertentu.

**Contoh:**

> API ini memengaruhi data, dan untuk mencegah penggunaan tidak sengaja, tautan yang dapat diklik langsung tidak disediakan di sini.

- Reset nilai Poin Pengalaman untuk Atribut [Strength] dan [Knowledge] ke 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Sesuaikan langsung nilai Poin Pengalaman untuk [Charm] ke Level 50: lifeup://api/edit_exp?skills=3&level=50

| Parameter | Arti              | Tipe                                      | Contoh | Wajib | Catatan |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | ID Atribut (Keterampilan) | Array of numbers greater than 0           | 1       | Tidak       | Mendukung array (mis., &skills=1&skills=2&skills=3)<br/>Untuk memperoleh ID Atribut, lihat bagian "Basic Knowledge - LifeUp Data ID" |
| exp       | Setel nilai pengalaman | Number greater than or equal to 0 (int32) | 9999    | Tidak, tetapi exp atau level harus disediakan |                                                               |
| level     | Setel Level            | Number greater than or equal to 0 (int32) | 50      | Tidak, tetapi exp atau level harus disediakan | Mewakili nilai pengalaman awal untuk Level tertentu<br/>dan akan dipengaruhi oleh gradien Level kustom. |

<br/>

### Tambah atau edit Perasaan

?> API ini tersedia sejak versi v1.93.4 (536).

**Nama metode:** feeling

**Deskripsi:** Digunakan untuk membuat atau memperbarui catatan Perasaan.

**Contoh:**

- Buat catatan Perasaan baru: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Perbarui catatan Perasaan yang ada dan tandai sebagai favorit: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Hapus Perasaan: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parameter            | Arti           | Tipe                               | Contoh           | Wajib | Catatan                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | ID Catatan Perasaan | Number greater than 0              | 1                 | Tidak       | Jika disediakan, metode mencoba memperbarui catatan tertentu. Wajib saat menghapus.                                                                                                                                                           |
| content              | Konten           | Any text                           | Happy             | Tidak       | Digunakan untuk membuat catatan baru atau memperbarui konten catatan yang ada                                                                                                                                                                    |
| time                 | Timestamp         | Unix timestamp                     | 1633036800        | Tidak       | Waktu catatan; default waktu saat ini                                                                                                                                                                                             |
| is_favorite          | Tanda favorit     | true or false                      | true              | Tidak       | Menandai catatan sebagai favorit atau tidak                                                                                                                                                                                                        |
| delete               | Hapus            | true or false                      | true              | Tidak       | v1.105.1+. Menghapus Perasaan secara soft seperti di App (lampiran dihapus).                                                                                                                                                       |
| relate_type          | Tipe relasi     | Number between 0 and 3             | 1                 | Tidak       | Menentukan tipe relasi yang terkait dengan catatan:<br/>0: Tugas<br/>1: Pencapaian kustom<br/>2: Tanpa relasi<br/>3: Penggunaan Item                                                                                                        |
| relate_id            | ID terkait        | Number greater than 0              | 2                 | Tidak       | Menentukan ID elemen terkait:<br/>Saat relate_type adalah 0: mewakili task ID<br/>Saat relate_type adalah 1: mewakili achievement ID<br/>Saat relate_type adalah 3: mewakili item ID<br/>Saat relate_type adalah 2: tidak perlu ID                |
| usage_count          | Jumlah penggunaan       | Integer greater than 1             | 1                 | Tidak       | Hanya valid saat relate_type adalah 3 (penggunaan Item); mencatat jumlah penggunaan Item.                                                                                                                                                          |
| image_uris           | Image URIs        | List of URI strings                |                   | Tidak       | Mendukung URI file lokal (file://) atau gambar web jarak jauh (http/https). Mendukung array (mis., &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Mode pembaruan       | APPEND or REPLACE | REPLACE           | Tidak       | Hanya valid saat memperbarui catatan yang ada dan menyediakan image_uris.<br/>APPEND: Menambahkan ke gambar yang ada.<br/>REPLACE: Mengganti gambar yang ada (default).                                                               |
    
**Catatan:**

1. Jika parameter `id` disediakan, metode mencoba memperbarui catatan Perasaan yang sesuai. Exception dilempar jika tidak ditemukan catatan yang cocok.
2. Jika `id` tidak disediakan, tetapi `content` ada, metode akan membuat catatan Perasaan baru.

<br/>

### Jumlah Tomat

?> Memerlukan v1.98.0+

**Nama metode:** tomato

**Deskripsi:** Menyesuaikan jumlah tomat (menambah, mengurangi, atau menetapkan jumlah tertentu)

**Contoh:**

- Tambah 1 tomat: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Kurangi 2 tomat: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Setel jumlah pomodoro ke 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parameter | Arti        | Nilai                                        | Contoh   | Wajib | Catatan                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Tipe operasi | One of:<br/>increase<br/>decrease<br/>set     | increase  | Tidak       | increase - Tambah pomodoro (default)<br/>decrease - Kurangi pomodoro<br/>set - Setel jumlah pomodoro ke nilai yang ditentukan |
| number    | Jumlah         | Integer                                       | 1         | Ya      | Arti berbeda menurut action:<br/>increase/decrease - Jumlah untuk ditambah/dikurangi<br/>set - Jumlah target |

**Respons:**

| Field    | Tipe    | Deskripsi              | Contoh |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Jumlah pomodoro saat ini   | 10      |

<br/>

### Beli Item

?> Memerlukan v1.98.0+

**Nama metode:** purchase_item

**Deskripsi:** Membeli Item tertentu

**Contoh:**

- Beli Item dengan ID 1: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Beli Item bernama "Health Potion": [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Beli 5 salinan Item dengan ID 1: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Jika Item memiliki `purchase_limit` yang dikonfigurasi dan `limit_scope` mencakup `purchase`, API ini juga akan menerapkan pembatasan tersebut.

| Parameter         | Arti          | Nilai                | Contoh       | Wajib | Catatan                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | Item ID          | number greater than 0 | 1             | Tidak*      | Salah satu id atau name wajib |
| name              | Nama Item        | any text              | Health Potion | Tidak*      | Salah satu id atau name wajib |
| purchase_quantity | Jumlah pembelian| number greater than 0 | 5             | Tidak       | Default 1              |

**Respons:**

| Field  | Tipe    | Deskripsi        | Contoh         | Catatan                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | Item ID            | 1               | Dikembalikan saat pembelian berhasil  |
| result | Integer | Kode hasil        | 0               | Lihat kode hasil di bawah      |
| desc   | Text    | Deskripsi hasil | PurchaseSuccess | Lihat kode hasil di bawah      |

**Kode Hasil:**

| Code | Deskripsi               | Catatan                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Pembelian berhasil            |
| 1    | DatabaseError             | Error database                |
| 2    | NotEnoughCoin             | Koin tidak cukup              |
| 3    | ItemNotFound              | Item tidak ditemukan                |
| 4    | PurchaseAndUseSuccess     | Pembelian dan penggunaan berhasil    |
| 5    | PurchaseSuccessAndUseFailure | Pembelian berhasil tetapi penggunaan gagal |
| 6    | NotPurchaseable           | Pembelian diblokir oleh pengaturan atau pembatasan Item |
| 7    | OutOfStock                | Stok Toko tidak cukup      |

<br/>

### Sintesis

?> Memerlukan v1.98.0+

**Nama metode:** synthesize

**Deskripsi:** Mensintesis Item menggunakan formula yang ada

**Contoh:**

- Sintesis sekali menggunakan formula ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Sintesis 5 kali menggunakan formula ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Perilaku siaran:**

- API ini untuk **Sintesis resep**.
- Saat `Broadcast events` diaktifkan dan Sintesis berhasil, LifeUp juga mengirim event siaran `app.lifeup.synthesis.complete`.
- Event ini **tidak** dikirim untuk Sintesis sederhana di dalam `use_item`; jalur itu tetap termasuk `app.lifeup.item.use`.

| Parameter | Arti            | Nilai                | Contoh | Wajib | Catatan                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formula ID        | number greater than 0 | 1       | Ya      | ID formula Sintesis  |
| times     | Jumlah kali   | number greater than 0 | 5       | Tidak       | Default 1           |

**Respons:**

| Field           | Tipe    | Deskripsi     | Contoh          | Catatan                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formula ID      | 1                |                          |
| result         | Integer | Kode hasil     | 0                | Lihat kode hasil di bawah   |
| desc           | Text    | Deskripsi hasil | SynthesisSuccess | Lihat kode hasil di bawah |
| synthesisResults| Text   | Hasil Sintesis | {...}           | Hanya dikembalikan saat berhasil |

**Kode Hasil:**

| Code | Deskripsi          | Catatan                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Sintesis berhasil  |
| 1    | FormulaNotFound     | Formula tidak ditemukan     |
| 2    | InsufficientMaterials| Bahan tidak cukup |
| 3    | DatabaseError       | Error database        |
| 4    | UnknownError        | Error lain         |

<br/>

### Manajemen Formula Sintesis

?> Memerlukan v1.98.0+

**Nama metode:** synthesis_formula

**Deskripsi:** Membuat, mengubah, atau menghapus formula Sintesis

**Contoh:**

- Buat formula baru: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Di sini, inputItems adalah `[{"item_id": 296, "amount": 88}]`
  - Di sini, outputItems adalah `[{"item_id": 295, "amount": 1}]`
- Hapus formula: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parameter   | Arti        | Nilai                | Contoh                        | Wajib | Catatan                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formula ID     | number greater than 0 | 1                             | Tidak       | Wajib untuk mengubah atau menghapus  |
| delete      | Tanda hapus    | true or false        | true                          | Tidak       | Hanya digunakan untuk penghapusan         |
| inputItems  | Item masukan    | Item array, see below | [{"item_id":1,"amount":2}]     | Ya      | Wajib untuk membuat atau mengubah  |
| outputItems | Item keluaran   | Item array, see below | [{"item_id":3,"amount":1}]     | Ya      | Wajib untuk membuat atau mengubah  |
| category    | Category ID    | number greater than 0 | 1                             | Tidak       | Default kategori umum    |

!> inputItems dan outputItems adalah array JSON yang setiap elemennya berisi field item_id dan amount. Semua item ID harus ada dan amount harus lebih besar dari 0

**Respons:**

| Field     | Tipe    | Deskripsi      | Contoh     | Catatan                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formula ID       | 1           | Dikembalikan saat berhasil      |
| result    | Integer | Kode hasil      | 0           | Lihat kode hasil di bawah   |
| desc      | Text    | Deskripsi hasil | AddSuccess | Lihat kode hasil di bawah   |

**Kode Hasil:**

| Code | Deskripsi     | Catatan             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operasi berhasil |
| 1    | Failed         | Operasi gagal  |

<br/>

### Manajemen Subtugas

?> Memerlukan v1.98.0+

**Nama metode:** subtask

**Deskripsi:** Membuat atau mengedit subtugas

**Contoh:**

- Tambah subtugas ke Tugas utama ID 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Edit subtugas dan setel Hadiah: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parameter     | Arti            | Nilai                | Contoh    | Wajib | Catatan                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | Main task ID       | number greater than 0 | 1         | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| main_gid     | Main task group ID | number greater than 0 | 1         | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| main_name    | Nama Tugas utama     | any text             | Study task | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| edit_id      | Subtask ID untuk diedit | number greater than 0 | 2         | Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib saat mengedit; tidak diperlukan saat membuat |
| edit_gid     | Subtask group ID   | number greater than 0 | 2         | Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib saat mengedit; tidak diperlukan saat membuat |
| edit_name    | Nama subtugas       | any text             | Do homework| Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib saat mengedit; tidak diperlukan saat membuat |
| todo         | Konten Tugas       | any text             | Do homework| Tidak       | Wajib saat membuat subtugas baru |
| remind_time  | Waktu pengingat      | timestamp (milliseconds)| 1640995200000 | Tidak | Kirim null untuk menghapus pengingat    |
| order        | Urutan              | integer              | 1          | Tidak       | Posisi dalam daftar Tugas           |
| coin         | Hadiah koin        | [0, 999999]         | 10         | Tidak       | Koin diperoleh saat selesai    |
| coin_var     | Varians koin      | integer              | 5          | Tidak       | Varians acak dalam Hadiah koin  |
| exp          | Hadiah Poin Pengalaman  | [0, 99999]          | 5          | Tidak       | Poin Pengalaman diperoleh        |
| auto_use_item| Otomatis gunakan Item      | true or false        | true       | Tidak       | Apakah Item digunakan otomatis saat selesai |
| item_id      | Item ID            | number greater than 0 | 1         | Tidak*      | Salah satu item_id atau item_name wajib |
| item_name    | Nama Item          | any text             | Health Potion| Tidak*    | Salah satu item_id atau item_name wajib |
| item_amount  | Jumlah Item        | number greater than 0 | 1         | Tidak       | Hanya valid saat menetapkan Hadiah Item |
| items        | JSON Item         | JSON text            | [{"item_id":1,"amount":1}] | Tidak | Setel beberapa Hadiah Item sekaligus |
| coin_set_type     | Cara menetapkan nilai koin | One of:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel koin langsung ke nilai<br/>relative - tambah/kurangi dari nilai koin asli |
| exp_set_type      | Cara menetapkan nilai exp | One of:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel exp langsung ke nilai<br/>relative - tambah/kurangi dari nilai exp asli |

**Respons:**

| Field        | Tipe    | Deskripsi      | Contoh | Catatan            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | Dapat kosong     |

<br/>

### Manajemen Kategori

?> Memerlukan v1.98.0+

**Nama metode:** category

**Deskripsi:** Menambah atau mengedit kategori (daftar Tugas, daftar Pencapaian, daftar Toko, daftar Sintesis)

**Contoh:**

- Buat daftar Tugas: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Edit daftar Toko: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parameter        | Arti           | Nilai               | Contoh    | Wajib | Catatan                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Tipe kategori     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Ya | tasks - Daftar Tugas<br/>achievements - Daftar Pencapaian<br/>shop - Daftar Toko<br/>synthesis - Daftar Sintesis |
| edit_id         | Category ID untuk diedit| number greater than 0| 1         | Tidak       | Wajib saat mengedit           |
| name            | Nama kategori     | any text             | Study List | Tidak       | Wajib untuk kategori baru; opsional saat mengedit |
| order           | Urutan sort        | integer              | 1         | Tidak       | Posisi dalam daftar            |
| hidden          | Sembunyikan kategori     | true or false        | false     | Tidak       | tasks=arsip; shop=sembunyikan Toko; synthesis=sembunyikan. Daftar Pencapaian dan daftar ALL Sintesis ditolak dengan `unsupported_parameter`. `false` menampilkan kembali |
| inventory_hidden| Sembunyikan di Inventaris | true or false        | false     | Tidak       | Hanya didukung untuk daftar Toko   |
| icon_uri        | Icon URI          | emoji, http(s) URL, content URI, or empty | 🏆 | Tidak | Hanya didukung untuk daftar Pencapaian. Emoji disimpan sebagai `emoji_*.webp`. Kosong menghapus. |
| desc            | Deskripsi       | any text             | This is a description | Tidak | Hanya didukung untuk daftar Pencapaian |
| color           | Warna tag         | color string         | #66CCFF   | Tidak       | Hanya didukung untuk daftar Tugas; # harus di-escape sebagai %23 |

**Respons:**

| Field | Tipe    | Deskripsi    | Contoh | Catatan                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Category ID    | 1000    | ID kategori baru atau yang diedit |

<br/>

### Ekspor Cadangan

?> Memerlukan v1.98.0+

**Nama metode:** export_backup

**Deskripsi:** Membuat file cadangan dan mengembalikan URI-nya (hanya panggilan Content Provider)

!> API ini hanya dapat dipanggil melalui Content Provider; panggilan URL Scheme langsung tidak didukung

| Parameter      | Arti        | Nilai          | Contoh | Wajib | Catatan                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Sertakan file media | true or false | true    | Tidak       | Apakah menyertakan file media (gambar, efek suara, dll.) dalam cadangan<br/>Default true |
| callingPackage| Nama paket pemanggil | any text      | com.example.app | Tidak | Pengenal paket untuk panggilan Content Provider |

**Respons:**

| Field          | Tipe   | Deskripsi          | Contoh                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI file cadangan      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Operasi Subtugas

?> Memerlukan v1.98.0+

**Nama metode:** subtask_operation

**Deskripsi:** Menyelesaikan, membatalkan penyelesaian, atau menghapus subtugas

**Contoh:**

- Selesaikan subtugas: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Hapus subtugas: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Batalkan penyelesaian subtugas: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parameter     | Arti          | Nilai               | Contoh    | Wajib | Catatan                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | Main task ID     | number greater than 0| 1         | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| main_gid     | Main task group ID| number greater than 0| 1        | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| main_name    | Nama Tugas utama   | any text            | Study task | Tidak*      | Salah satu main_id, main_gid, atau main_name wajib |
| edit_id      | Subtask ID       | number greater than 0| 2         | Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib |
| edit_gid     | Subtask group ID | number greater than 0| 2         | Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib |
| edit_name    | Nama subtugas     | any text            | Do homework| Tidak*      | Salah satu edit_id, edit_gid, atau edit_name wajib |
| operation    | Tipe operasi   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Ya | complete - Selesaikan Tugas<br/>undo_complete - Batalkan penyelesaian<br/>delete - Hapus Tugas |

**Respons:**

| Field        | Tipe    | Deskripsi      | Contoh | Catatan            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Main task ID     | 1       |                  |
| subtask_id   | Number  | Subtask ID       | 2       |                  |
| subtask_gid  | Number  | Subtask group ID | 3       | Dapat kosong     |

<br/>

### Manajemen Pencapaian

?> Memerlukan v1.98.0+

**Nama metode:** achievement

**Deskripsi:** Menambah atau mengedit Pencapaian kustom dan subkategori Pencapaian

**Contoh:**

- Buat Pencapaian: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Anda mungkin perlu mengganti `category_id` dengan id daftar Pencapaian yang tersedia untuk menguji contoh ini
- Buat Pencapaian dengan kondisi buka: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Anda mungkin perlu mengganti `category_id` dengan id daftar Pencapaian yang tersedia untuk menguji contoh ini
  - Konten terdekode dari `conditions_json` adalah `[{"type":7,"target":1000000}]`
- Edit Pencapaian yang ada: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Parameter Pencapaian

| Parameter      | Arti           | Nilai               | Contoh   | Wajib | Catatan                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | Achievement ID untuk diedit | number greater than 0 | 1      | Tidak       | Wajib saat mengedit          |
| is_subcategory| Apakah subkategori    | true or false        | false     | Tidak       | Default false               |
| name          | Nama Pencapaian   | any text             | Collector | Tidak*      | Wajib untuk Pencapaian baru   |
| desc          | Deskripsi       | any text             | Collect 100 items | Tidak |                               |
| icon_uri      | Icon              | emoji, http(s) URL, content URI, or empty | 🏆 | Tidak | Bukan `icon`. Emoji disimpan sebagai file `emoji_`. Kosong menghapus. |
| order         | Urutan sort        | integer              | 1         | Tidak       | Posisi dalam daftar                |
| category_id   | Category ID       | number greater than 0 | 1        | Tidak*      | Wajib saat membuat subkategori |
| unlocked      | Status buka     | true or false        | true      | Tidak       | true - buka segera<br/>false - reset ke terkunci |
| unlock_time   | Waktu buka       | timestamp (milliseconds) | 1640995200000 | Tidak | Hanya efektif jika sudah terbuka |
| delete        | Tanda hapus       | true or false        | false     | Tidak       |                                |
| secret        | Pencapaian tersembunyi| true or false        | false     | Tidak       |                                |
| write_feeling | Catat Perasaan   | true or false        | false     | Tidak       |                                |
| color         | Warna judul       | color string         | #66CCFF   | Tidak       | # harus di-escape sebagai %23        |
| auto_use_item | Otomatis gunakan Item     | true or false        | false     | Tidak       |                                |
| skills        | Skill IDs         | array of numbers greater than 0 | 1 | Tidak    | Mendukung array (mis., &skills=1&skills=2) |
| exp           | Hadiah Poin Pengalaman | integer              | 100       | Tidak       |                                |
| item_id       | Item ID           | number greater than 0 | 1        | Tidak*      | Salah satu item_id atau item_name wajib |
| item_name     | Nama Item         | any text             | Treasure  | Tidak*      | Salah satu item_id atau item_name wajib |
| item_amount   | Jumlah Item     | [1, 99]             | 1         | Tidak       | Default 1                   |
| items         | JSON Hadiah Item | JSON text            | [{"item_id":1,"amount":2}] | Tidak | Setel beberapa Hadiah Item, lihat format di bawah |
| conditions_json| JSON kondisi buka | JSON text      | [{"type":7,"target":1000000}] | Tidak | Setel kondisi buka, lihat format di bawah |
| coin         | Hadiah koin       | [0, 999999]      | 10         | Tidak       | Jumlah koin diperoleh saat membuka Pencapaian |
| coin_var     | Variasi Hadiah koin | integer              | 5          | Tidak       | Rentang variasi untuk Hadiah koin |
| coin_set_type| Cara menetapkan nilai koin | One of:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel koin langsung ke nilai<br/>relative - tambah/kurangi dari nilai koin asli |
| exp_set_type | Cara menetapkan nilai exp | One of:<br/>absolute<br/>relative | absolute | Tidak | absolute - setel exp langsung ke nilai<br/>relative - tambah/kurangi dari nilai exp asli |

**Respons:**

| Field  | Tipe    | Deskripsi      | Contoh | Catatan                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID   | 1000    | ID Pencapaian baru atau yang diedit |

#### 2. Parameter Subkategori

| Parameter     | Arti           | Nilai               | Contoh   | Wajib | Catatan                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Status collapse   | true or false        | false     | Tidak       | Hanya berlaku untuk subkategori   |

Subkategori menolak `icon_uri` (termasuk emoji) dengan `unsupported_parameter`. Mengedit subkategori tanpa `is_subcategory=true` mengembalikan `is_subcategory_required`.
**Respons:**

| Field  | Tipe    | Deskripsi      | Contoh | Catatan                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Achievement ID   | 1000    | ID Pencapaian baru atau yang diedit (subkategori) |

#### 3. Tipe Kondisi Buka

| Type Code | Deskripsi             | Memerlukan related_id | Tipe related_id | Deskripsi target  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Jumlah penyelesaian Tugas   | Ya                | Task ID         | Jumlah penyelesaian |
| 1         | Streak penyelesaian Tugas  | Ya                | Task ID         | Jumlah streak       |
| 3         | Jumlah Pomodoro         | Tidak                 | -               | Jumlah pomodoro |
| 4         | Hari menggunakan LifeUp      | Tidak                 | -               | Jumlah hari     |
| 5         | Jumlah suka             | Tidak                 | -               | Jumlah suka    |
| 6         | Streak penyelesaian harian | Tidak                 | -               | Hari streak        |
| 7         | Koin saat ini          | Tidak                 | -               | Jumlah koin    |
| 8         | Koin diperoleh dalam satu hari| Tidak                 | -               | Jumlah koin    |
| 9         | Jumlah pomodoro Tugas    | Ya                | Task ID         | Jumlah pomodoro |
| 10        | Jumlah pembelian Item    | Ya                | Item ID         | Jumlah pembelian     |
| 11        | Jumlah penggunaan Item       | Ya                | Item ID         | Jumlah penggunaan        |
| 12        | Jumlah Item Kotak Jarahan    | Ya                | Item ID         | Jumlah diperoleh     |
| 13        | Level Keterampilan tercapai    | Ya                | Skill ID        | Nilai Level        |
| 14        | Level kehidupan            | Tidak                 | -               | Nilai Level        |
| 15        | Total Item diperoleh   | Ya                | Item ID         | Total jumlah diperoleh |
| 16        | Item dari Sintesis   | Ya                | Item ID         | Jumlah Sintesis    |
| 17        | Jumlah Item saat ini  | Ya                | Item ID         | Jumlah dimiliki          |
| 18        | Durasi Fokus Tugas    | Ya                | Task ID         | Durasi (menit) |
| 19        | Tabungan ATM           | Tidak                 | -               | Jumlah tabungan     |
| 20        | API eksternal          | Tidak                 | -               | Didefinisikan API        |
| 520       | Selesaikan N Tugas berbeda per hari | Tidak         | -               | Jumlah Tugas berbeda (deduplikasi berdasarkan group ID; tipe yang sudah ada) |
| 524       | Selesaikan N penyelesaian Tugas per hari | Tidak       | -               | Total jumlah penyelesaian valid dalam satu hari (v1.104.4+) |

> Sejak v1.104.4, tipe `520` dan `524` menggunakan semantik berikut:
>
> - Keduanya berbagi definisi penyelesaian yang sama dan batas hari kalender lokal (`TimeRange.today()`).
> - Tugas biasa dihitung `COMPLETED`; Tugas negatif dihitung `GIVE_UP`.
> - Tipe `520` melakukan deduplikasi berdasarkan `groupId` efektif (fallback ke task record id jika group id tidak ada). Menyelesaikan Tugas tanpa batas yang sama beberapa kali dalam sehari tetap dihitung 1 Tugas berbeda.
> - Tipe `524` menghitung setiap baris penyelesaian valid. Menyelesaikan Tugas tanpa batas yang sama 5 kali menghasilkan `completionCount = 5`.
> - Pencapaian yang sudah ada dengan `type=520` mempertahankan semantik Tugas berbeda; tidak perlu migrasi.

#### 4. Spesifikasi Format JSON

##### Kondisi Buka (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Hadiah Item (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Manajemen Keterampilan

?> Memerlukan v1.98.0+

**Nama metode:** skill

**Deskripsi:** Membuat atau mengedit Keterampilan kustom (Atribut)

**Contoh:**

- Buat Keterampilan: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Edit pengalaman Keterampilan: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Hapus Keterampilan: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parameter    | Arti           | Nilai               | Contoh    | Wajib | Catatan                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Skill ID          | number greater than 0 | 1         | Tidak       | Wajib saat mengedit           |
| content     | Nama Keterampilan        | any text             | Programming| Tidak*      | Wajib untuk Keterampilan baru         |
| desc        | Deskripsi       | any text             | Coding ability | Tidak    |                                |
| icon        | Icon              | any text             | 💻         | Tidak       | Dapat menggunakan emoji                   |
| color       | Warna             | color string         | #FF6B6B    | Tidak       | # harus di-escape sebagai %23        |
| type        | Tipe              | integer              | 0          | Tidak       |                                |
| order       | Urutan sort        | integer              | 1          | Tidak       | Posisi daftar campuran mentah. Jika digunakan sendiri, Keterampilan ditempatkan pada posisi tersebut dan grup akhir disimpulkan dari tata letak; jika digunakan dengan `group_id`, disesuaikan ke posisi legal terdekat di dalam grup target |
| group_id    | Skill group ID    | integer              | 10         | Tidak       | Memerlukan v1.103.0+; tidak boleh kurang dari `0`, dan hanya `0` yang memindahkan Keterampilan ke area tanpa grup. Jika digunakan sendiri, Keterampilan baru ditambahkan ke ujung grup target, sedangkan Keterampilan yang diedit mempertahankan posisi saat ini jika sudah berada di grup tersebut, jika tidak dipindahkan ke ujung grup; jika digunakan dengan `order`, `group_id` diutamakan |
| status      | Status            | integer              | 0          | Tidak       |                                |
| exp         | Poin pengalaman | number greater than or equal to 0 | 100 | Tidak | Pengalaman Keterampilan saat ini        |
| delete      | Tanda hapus       | true or false        | false      | Tidak       | Hanya valid saat mengedit         |

**Respons:**

| Field  | Tipe    | Deskripsi    | Contoh | Catatan                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Skill ID       | 1000    | ID Keterampilan baru atau yang diedit |

<br/>

### Manajemen Grup Keterampilan :id=skill_group_management

Memerlukan v1.103.0+

**Nama metode:** skill_group

**Deskripsi:** Membuat, mengedit, menghapus, atau mengurutkan ulang grup Keterampilan. API sort juga mendukung pengurutan campuran grup dan Keterampilan.

**Contoh:**

- Buat grup: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Edit grup: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Hapus grup: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Urutkan grup dan Keterampilan bersama:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parameter | Arti | Nilai | Contoh | Wajib | Catatan |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | Skill group ID | number greater than 0 | 10 | Tidak* | Wajib saat mengedit atau menghapus |
| content | Nama grup | any text | Combat | Tidak* | Wajib saat membuat |
| order | Urutan sort | integer | 20 | Tidak | Nilai `orderInCategory` mentah; harus unik dalam daftar campuran Keterampilan/grup |
| collapsed | Status collapse | true or false | true | Tidak | Apakah grup di-collapse |
| delete | Tanda hapus | true or false | false | Tidak | Hanya valid saat mengedit |
| sort_json | Node sort campuran | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | Tidak* | Jika disediakan, parameter CRUD diabaikan dan rencana sort campuran diterapkan. Sort sebagian didukung: node yang tidak ditentukan mempertahankan urutan relatifnya |

Format node `sort_json`:

| Field | Arti | Nilai |
| ----- | ------- | ------ |
| type | Tipe node | `skill` / `group` |
| id | Entity ID | number greater than 0 |

**Respons:**

| Field | Tipe | Deskripsi | Contoh | Catatan |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | Skill group ID | 10 | Dikembalikan untuk create / edit / delete |
| count | Number | Jumlah node yang diurutkan | 3 | Dikembalikan untuk permintaan `sort_json` |

<br/>

### Pengaturan App

?> Memerlukan v1.98.0+

**Nama metode:** app_settings

**Deskripsi:** Menyesuaikan pengaturan antarmuka App

**Contoh:**

- Aktifkan mode compact: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Aktifkan tema Material You: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Ubah pengaturan dan restart UI segera: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parameter              | Arti           | Nilai          | Contoh | Wajib | Catatan                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Aktifkan mode compact| true or false  | true    | Tidak       | Menyederhanakan elemen antarmuka     |
| is_enable_material_you| Aktifkan Material You| true or false  | true    | Tidak       | Aktifkan tema Material You       |
| restart_activities    | Restart antarmuka | true or false   | true    | Tidak       | Terapkan perubahan antarmuka segera |
| broadcast_event | Peristiwa broadcast LifeUp Labs | true or false | true | Tidak | Default mati. Switch yang sama dengan Pengaturan → Labs |

**Respons:**

| Field  | Tipe    | Deskripsi  | Contoh | Catatan                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Kode hasil  | 0       | 0 menandakan berhasil      |

<br/>

### Kueri Sederhana

!> Fungsi di sini digunakan bersama alat otomatisasi/pengembangan sekunder. Jika Anda perlu mengkueri daftar data lengkap, lihat [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) dan [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Nama metode:** query

**Deskripsi:** mengkueri parameter

**Contoh:** - Kueri jumlah koin saat ini: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Kueri switch peristiwa broadcast: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parameter   | Arti              | Tipe                                                         | Contoh | Wajib                                    | Catatan                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | jenis kueri        | Hanya salah satu nilai berikut:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | ya                                         | coin - jumlah koin saat ini<br/>atm - saldo ATM saat ini<br/>item - Informasi Item untuk `itemId` yang ditentukan<br/>item_id_list - Daftar ID Item yang ditentukan oleh `categoryId`<br/>tomato - Data tomato<br/>task - Informasi Tugas (v1.101.0+)<br/>broadcast - Switch peristiwa broadcast Labs (`{enabled}`) |
| item_id     | id Item   | a number greater than 0                                      | 1       | Wajib jika key adalah `item` |                                                              |
| category_id | id kategori Toko | Number greater than or equal to 0                            | 0       | tidak*                                         | Wajib hanya jika key adalah `item_id_list`, mewakili ID daftar yang akan dikueri. |
| task_id / taskId | Task ID          | Number greater than 0                                        | 1       | Jika key adalah `task`, salah satu dari tiga* wajib | ID Tugas yang dikueri |
| task_gid / taskGid / task_group_id / taskGroupId | Task group ID | Number greater than 0 | 1 | Jika key adalah `task`, salah satu dari tiga* wajib | ID grup Tugas yang dikueri |
| task_name / taskName | Nama Tugas      | Any text                                                     | Study   | Jika key adalah `task`, salah satu dari tiga* wajib | Nama Tugas fuzzy-matched |
| withSubTasks | Sertakan sub-tugas   | true or false                                                | true    | Tidak                                          | Hanya tersedia jika key adalah `task`; default true |

**Nilai balik:**

Hanya didukung sejak versi 1.90.2

Saat mengkueri coin/atm:

| Parameter | Arti                             | Tipe               | Contoh | Wajib | Catatan |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Nilai numerik yang dikembalikan kueri | number             | 1000    | ya      |       |

Saat mengkueri Item:

| Parameter        | Arti                         | Tipe     | Contoh   | Wajib | Catatan |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | id Item              | number   | 1         | ya      |       |
| name             | nama Item            | any text | Coffee    | ya      |       |
| desc             | deskripsi                     | any text |           | tidak       |       |
| icon             | URL icon                        | any text | icon.webp | tidak       | Jika file lokal, hanya nama file yang dikembalikan |
| category_id      | id data kategori                | number   | 1         | ya      |       |
| stock_number     | stok Toko             | number   | -1        | ya      | `-1` mewakili stok Toko tak terbatas |
| own_number       | jumlah milik di Inventaris | number   | 10        | ya      |       |
| price            | harga                       | number   | 100       | ya      |       |
| order            | urutan sort                         | number   | 100       | ya      | Nilai bobot saat sort kustom |
| disable_purchase | Apakah menonaktifkan pembelian     | true or false | true | ya |       |
| purchase_limit   | Aturan pembatasan               | JSON text | [{"limitType":0,"limitNumber":5}] | ya | Daftar pembatasan saat ini |
| limit_scope      | Cakupan pembatasan               | purchase / use / both | use | ya | Dikembalikan sebagai nilai teks API |

Saat mengkueri item_id_list:

| Parameter | Arti                           | Tipe   | Contoh | Wajib | Catatan |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Array ID Item dipisah koma     | string | 1,2,3,4 | ya      |       |

Saat mengkueri tomato:

| Parameter | Arti                  | Tipe   | Contoh | Wajib | Catatan |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Total jumlah tomato       | number | 100     | ya      |       |
| available | Jumlah tomato tersedia   | number | 50      | ya      |       |
| exchanged | Jumlah tomato ditukar   | number | 50      | ya      |       |

Saat mengkueri Tugas (v1.101.0+):

| Parameter   | Arti                      | Tipe        | Contoh | Wajib | Catatan                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | Task ID                      | number      | 1       | ya      | -                               |
| _GID        | Task group ID                | number      | 1       | ya      | -                               |
| name        | Nama Tugas                    | text        | Study   | ya      | -                               |
| notes       | Catatan                        | text        | -       | tidak       | Dapat kosong                    |
| status      | Status Tugas                  | number      | 0       | ya      | 0=belum selesai, 1=selesai       |
| startTime   | Waktu mulai                   | number      | -       | ya      | Unix timestamp (milidetik)   |
| deadline    | Waktu tenggat                | number      | -       | tidak       | Unix timestamp (milidetik), dapat kosong |
| remindTime  | Waktu pengingat                  | number      | -       | tidak       | Unix timestamp (milidetik), dapat kosong |
| frequency   | Frekuensi pengulangan         | number      | -       | ya      | -                               |
| weekdays    | Hari kerja                     | text        | 1,3,5   | tidak       | v1.106.0+; kosong jika bukan mode weekday. 1=Senin … 7=Minggu |
| exp         | Hadiah Poin Pengalaman                   | number      | -       | ya      | -                               |
| skillIds    | Daftar Skill ID                | JSON text   | -       | ya      | Format array JSON               |
| coin        | Hadiah koin                  | number      | -       | tidak       | Dapat kosong                    |
| coinVariable| Hadiah koin acak           | number      | -       | tidak       | Dapat kosong                    |
| itemId      | ID Item Hadiah pertama         | number      | -       | tidak       | Dapat kosong                    |
| itemCount   | Jumlah Item Hadiah pertama      | number      | -       | tidak       | Dikembalikan jika itemId ada     |
| items       | Daftar Hadiah Item             | JSON text   | -       | ya      | Format array JSON               |
| words       | Kata insentif penyelesaian   | text        | -       | tidak       | Dapat kosong                    |
| categoryId  | Category ID                  | number      | -       | tidak       | Dapat kosong                    |
| order       | Urutan                        | number      | -       | ya      | -                               |
| name_extended | Nama diperluas              | text        | -       | ya      | Sama dengan name                    |
| subTasks    | Daftar sub-tugas                | JSON text   | -       | ya      | Format array JSON, lihat di bawah    |

**Deskripsi field sub-tugas (subTasks):**

Field `subTasks` adalah array JSON, setiap elemen berisi field berikut:

- `id`: Sub-task ID
- `gid`: Sub-task group ID
- `todo`: Konten sub-tugas
- `status`: Status sub-tugas (0=belum selesai, 1=selesai)
- `remindTime`: Waktu pengingat (Unix timestamp, milidetik)
- `exp`: Hadiah Poin Pengalaman
- `coin`: Hadiah koin
- `coinVariable`: Hadiah koin acak
- `items`: Daftar Hadiah Item
- `order`: Urutan
- `autoUseItem`: Apakah otomatis menggunakan Item

<br/>

### Kueri Atribut :id=query_skill

!> Fungsi di sini digunakan bersama alat otomatisasi/pengembangan sekunder.

**Nama metode:** query_skill

**Deskripsi:** Mengkueri informasi dasar, field sort mentah, dan data level/pengalaman Keterampilan (Atribut) yang ditentukan.

Anda dapat menggunakan API ini untuk menyesuaikan widget Atribut.

**Contoh:**

- Kueri Atribut strength: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parameter | Arti              | Tipe                    | Contoh | Wajib | Catatan |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | id Atribut (Keterampilan) | a number greater than 0 | 1       | ya      | Cara memperolehnya, lihat bagian "Basics - LifeUp Data ID" di atas |

**Nilai balik:**

Hanya didukung sejak versi 1.90.6

| Parameter            | Arti                              | Tipe   | Contoh  | Wajib | Catatan |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | skill id                             | number | 1        | ya      | Ditambahkan ke `query_skill` di v1.103.0+ |
| name                 | nama Atribut                       | string | strength | ya      |       |
| order                | urutan sort mentah                       | number | 20       | ya      | Ditambahkan di v1.103.0+; `orderInCategory` |
| group_id             | Skill group ID                       | number | 10       | ya      | Ditambahkan di v1.103.0+; mengembalikan `0` jika Keterampilan tidak dalam grup |
| status               | status                               | number | 0        | ya      | Ditambahkan di v1.103.0+; `0` = normal, `1` = tersembunyi |
| level                | level                                | number | 10       | ya      |       |
| total_exp            | total Poin Pengalaman              | number | 10000    | ya      |       |
| until_next_level_exp | Poin Pengalaman untuk mencapai level berikutnya | number | 99       | ya      |       |
| current_level_exp    | Poin Pengalaman di atas level saat ini       | Number | 1000     | Ya      |       |

<br/>

### Kueri Grup Keterampilan :id=query_skill_group

Memerlukan v1.103.0+

**Nama metode:** query_skill_group

**Deskripsi:** Mengkueri satu grup Keterampilan dan mengembalikan sort mentah serta status collapse.

**Contoh:**

- Kueri grup Keterampilan: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parameter | Arti | Tipe | Contoh | Wajib | Catatan |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Skill group ID | number greater than 0 | 10 | ya | - |

**Nilai balik:**

| Parameter | Arti | Tipe | Contoh | Wajib | Catatan |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Skill group ID | number | 10 | ya | - |
| content | Nama grup | string | Combat | ya | - |
| order | Urutan sort mentah | number | 20 | ya | `orderInCategory` |
| collapsed | Status collapse | string | true | ya | Dikembalikan sebagai teks `true` / `false` |

<br/>

<br/>

### Antarmuka khusus

#### Acak

?> API ini dirilis di v1.93.0.

**Nama metode:** random

**Deskripsi:** Antarmuka acak sederhana yang dapat memicu salah satu dari beberapa API secara acak.

**Contoh:**

- Kemungkinan sama untuk menampilkan `scissors`, `rock`, atau `paper` secara acak: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- Probabilitas 90% menampilkan `rock`, 5% untuk `scissors`, dan 5% untuk `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parameter | Arti    | Nilai                 | Contoh                                | Wajib | Catatan |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | API acak | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Ya      | Mendukung pemanggilan dalam bentuk array (yaitu, beberapa parameter api, seperti contoh di atas) |
| weight    | Bobot     | Numbers greater than 0 | 1                                      | Tidak       | Mendukung pemanggilan dalam bentuk array.<br/><br/>Jika weight tidak ditentukan, semua bobot sama (probabilitas setara).<br/>Jika bobot ditentukan, ditetapkan secara berurutan: misalnya, bobot pertama sesuai dengan parameter api pertama.<br/><br/>**Pastikan jumlah parameter weight sesuai dengan jumlah parameter api, atau mungkin tidak berlaku.** |

<br/>

#### Dialog Konfirmasi

**Nama metode:** confirm_dialog

**Deskripsi:** Jendela pop-up pilihan muncul. Anda dapat menyesuaikan judul, teks, tombol positif, dan tombol negatif. Antarmuka lain juga dapat dipanggil saat tombol diklik.

**Contoh:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Skenario penggunaan lain:
  - Pilihan Hadiah
  - Pemilihan cabang peristiwa

| Parameter       | Arti              | Tipe     | Contoh  | Wajib | Catatan |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | judul popup          | any text | Title    | ya      |       |
| message         | deskripsi detail jendela popup | any text | This is the content of the popup window | tidak |  |
| positive_text   | teks tombol positif | any text | YES      | tidak       |       |
| negative_text   | teks tombol negatif | any text | NO       | tidak       |       |
| neutral_text    | teks tombol netral  | any text | QUESTION | tidak       |       |
| positive_action | respons tautan tombol positif | URL (antarmuka lain) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | tidak | Sebenarnya teks escaped dari antarmuka pesan popup. Aturan escape, lihat `Basics - Escaping`. |
| negative_action | respons tautan tombol negatif | URL (antarmuka lain) | Sama seperti di atas | tidak |  |
| neutral_action  | respons tautan tombol netral  | URL (antarmuka lain) | Sama seperti di atas | tidak |  |
| cancel_action   | respons tautan tindakan batal   | URL (antarmuka lain) | Sama seperti di atas | tidak |  |

<br/>

#### Tanpa Tindakan

**Nama metode:** placeholder

**Catatan:** Antarmuka ini sendiri tidak menangani logika apa pun, tetapi Anda dapat menggunakannya dengan callback dan broadcast.

**Contoh:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Placeholder Variabel

`LifeUp` menyediakan metode pemrosesan intervensi pengguna untuk parameter.

| Placeholder                          | Arti                                                      | Contoh                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Placeholder teks                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Placeholder angka (tanpa titik desimal)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Placeholder angka (tanpa titik desimal), tampilkan tanda        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Placeholder angka (dengan titik desimal)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Placeholder angka (dengan titik desimal), tampilkan tanda           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Pilih Item, akan diganti dengan item id              | [$item]                                                      |
| [$task_category]                     | Pilih daftar Tugas, akan diganti dengan id daftar Tugas    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Placeholder waktu<br/><br/>Nilai yang mungkin untuk Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset dalam milidetik harus integer, default 0 milidetik | Tengah malam hari ini: [$time\|today]<br/>Tengah malam besok: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Placeholder angka acak (tanpa titik desimal)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Placeholder angka acak (dengan titik desimal)                | [$random_decimal\|1.0\|2.0]                                  |

**Contoh 1: Saat digunakan, pilih Item untuk menurunkan harga 1 koin**

Misalnya, setelah mengatur API untuk pengurangan harga Item Toko tertentu, Anda mungkin ingin memungkinkan pengguna memilih Item saat pemanggilan alih-alih preset id.

API berikut hanya dapat menurunkan harga Item Toko dengan id 1 sebesar 1 koin:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Anda hanya perlu mengubah item id menjadi placeholder [$item], dan saat pemanggilan, pengguna dapat memilih Item yang ingin diturunkan harganya:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Contoh 2: Templat Tugas, cukup masukkan nama Tugas dan daftar pilihan untuk membuat templat Hadiah preset**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Callback Akhir

Anda dapat menambahkan parameter callback ke semua antarmuka untuk mengimplementasikan pemrosesan memanggil kembali URL setelah pemanggilan.

Ini juga dapat digunakan untuk menggabungkan beberapa antarmuka, misalnya jika Anda ingin menampilkan prompt setelah lompat:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Anda dapat menggunakan parameter callback. Lihat juga **Basics - Escaping** di atas. Anda dapat menulis pemrosesan seperti ini:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Tentu saja, Anda dapat menambahkan beberapa tautan ke Item Toko untuk mencapai efek ini.

Selain itu, callback ini lebih sering digunakan untuk:

Aplikasi X → LifeUp → Aplikasi X

atau

Aplikasi X → LifeUp → Aplikasi Y

<br/>

#### Nilai balik Broadcast

!> Fungsi di sini digunakan bersama alat otomatisasi/pengembangan sekunder, dan ada ambang batas tertentu.

Dengan menambahkan parameter ini, nilai balik asli API juga dapat dikirim melalui broadcast, sehingga alat otomatisasi seperti Tasker dapat menerimanya.

Nilai broadcast setara dengan nilai kolom operasi "Intent Received" di Tasker. Anda dapat mengisi teks apa pun, selama keduanya sesuai.

**Contoh, menggunakan API kueri koin emas dengan Tasker ([Jika Anda menggunakan MacroDroid, lihat tautan ini.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Tambahkan parameter broadcast agar dapat menyiarkan nilai balik ke Tasker, dapat berupa teks apa pun, seperti `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Tambahkan event di Tasker → "Intent Received", isi "app.lifeup.query.coin" di kolom action

3. Tugas di Tasker kemudian dapat menerima nilai balik `value` dalam bentuk variabel `%value`.

4. Kemudian Anda dapat menilai jumlah koin emas di Tasker untuk mencapai berbagai efek. (Misalnya, ubah wallpaper desktop sesuai jumlah koin emas?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Notifikasi Peristiwa Broadcast

!> Fungsi di sini digunakan bersama alat otomatisasi/pengembangan sekunder.

> Di versi 1.90.2, kami akan menyiarkan berbagai peristiwa ke luar. Anda dapat menggunakan alat otomatisasi seperti Tasker untuk menerima peristiwa ini guna memicu tindakan Tasker.
>
### Aktifkan

**Secara default, peristiwa broadcast dimatikan.**

Anda dapat mengaktifkannya di `Settings`-`Labs`-`Developer mode`-`Broadcast events`.

### Contoh: Ganti wallpaper dengan Item

1. Buat Item baru bernama "Change Wallpaper".
2. Di Tasker, buka `Configuration file`→`Event`→`System`→`Intent Received`, masukkan `app.lifeup.item.use` di kolom operasi, lalu kembali.
3. Klik New Task dan masukkan nama apa pun (misalnya, change wallpaper).
4. Klik tanda + di sudut kanan bawah untuk menambahkan tugas, pilih `Task`→`If`
5. Sesuaikan kolom kondisi menjadi `%name eq change wallpaper`.
6. Kembali, `Insert Action` pilih `If`.
7. Klik tanda + di sudut kanan bawah lagi untuk menambahkan tugas, pilih `Display` → `Set Wallpaper`
8. (Opsional) Ganti `Type` dengan `All`
9. Di kolom gambar, klik ikon 🔍 dan pilih file wallpaper yang diinginkan
10. Keluar dan periksa apakah konfigurasi ini diaktifkan.
11. Gunakan Item "Wallpaper Change" di `LifeUp`, Anda seharusnya dapat melihat wallpaper berhasil berubah

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Menggunakan `No Action`+`Broadcast return value` dapat mencapai efek ini dengan cara yang lebih ringkas, Anda dapat mengeksplorasinya.

<br/>

### Tugas selesai

**Nama:** app.lifeup.task.complete

**Nilai balik:**

| Parameters  | Arti          | Contoh        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | nama Tugas        | Getting started |
| category_id | task category id | 1               |

### Tugas menyerah

**Nama:** app.lifeup.task.giveup

**Nilai balik:**

| Parameters  | Arti          | Contoh        |
| ----------- | ---------------- | --------------- |
| task_id     | task id          | 1               |
| task_gid    | task group id    | 1               |
| name        | nama Tugas        | Getting started |
| category_id | task category id | 1               |

### Tugas kedaluwarsa

**Nama:** app.lifeup.task.overdue

**Nilai balik:**

| Parameters | Arti                 | Contoh                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | task id **array**       | [1, 2, 3]                       |
| task_gids  | task group id **array** | [1, 2, 3]                       |
| names      | nama Tugas **array**     | [Getting started, Drink Waters] |
| task_ids_json  | task id **Json array**   | [1, 2, 3]                       |
| task_gids_json | task group id **Json array** | [1, 2, 3]                       |
| names_json     | nama Tugas **Json array** | ["Getting started", "Drink Waters"]                      |

### Pencapaian terbuka

**Nama:** app.lifeup.achievement.unlock

**Nilai balik:**

| Parameters     | Arti          | Contoh                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | achievement id   | 1                        |
| name           | nama Pencapaian | Using LifeUp for 30 days |

### Item dibeli

**Nama:** app.lifeup.item.purchase

**Nilai balik:**

| Parameters | Arti           | Contoh          |
| ---------- | ----------------- | ----------------- |
| item_id    | item id           | 1                 |
| name       | nama Item         | Break 10 branches |
| amount     | jumlah pembelian | 1                 |

### Item digunakan

**Nama:** app.lifeup.item.use

**Deskripsi:** Dikirim saat penggunaan Item normal atau alur penggunaan Sintesis sederhana berhasil.

**Nilai balik:**

| Parameters | Arti      | Contoh          |
| ---------- | ------------ | ----------------- |
| item_id    | item id      | 1                 |
| name       | nama Item    | Break 10 branches |
| amount     | jumlah penggunaan | 1                 |

### Sintesis selesai

> [!NOTE]
> Peristiwa broadcast ini dirilis di v1.102.8.

**Nama:** app.lifeup.synthesis.complete

**Deskripsi:** Dikirim saat Sintesis resep selesai dengan sukses.

**Nilai balik:**

| Parameters   | Arti                            | Contoh                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | formula id                         | 1                                                     |
| formula_name | nama formula                       | Toolbox Recipe                                        |
| times        | jumlah eksekusi                    | 3                                                     |
| input_count  | jumlah entri Item input       | 2                                                     |
| output_count | jumlah entri Item output      | 1                                                     |
| inputs_json  | JSON array semua input yang dikonsumsi  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | JSON array semua output yang dihasilkan | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Catatan:**

- Peristiwa ini hanya dikirim setelah Sintesis berhasil.
- Jika material tidak cukup, formula tidak ada, penyimpanan gagal, atau `Broadcast events` dinonaktifkan, peristiwa ini tidak dikirim.
- Satu pemanggilan API hanya mengirim satu peristiwa meskipun `times > 1`.
- Di `inputs_json` dan `outputs_json`, setiap item menggunakan struktur berikut:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` adalah **total dikonsumsi / total dihasilkan** dalam eksekusi ini, bukan jumlah per-formula.

### Perasaan ditambahkan / diperbarui

**Nama:** app.lifeup.feelings.add

**Nilai balik:**

| Parameters | Arti | Contoh |
| --- | --- | --- |
| feelings_id | feeling id | 1 |
| action_type | `add` or `update` | add |
| content | teks Perasaan | Feeling good today! |
| create_time | timestamp dibuat (ms) | 1642060800000 |
| relate_type | tipe objek terkait | 0 |
| related_id | id objek terkait | 1 |
| attachments_count | jumlah lampiran | 2 |
| attachments | array path lampiran | ["/path/1", "/path/2"] |

### Level naik

**Nama:** app.lifeup.level.up

**Nilai balik:**

| Parameters | Arti       | Contoh |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | nama          | strength |
| level      | level saat ini | 2        |

### Level turun

**Nama:** app.lifeup.level.down

**Nilai balik:**

| Parameters | Arti       | Contoh |
| ---------- | ------------- | -------- |
| skill_id   | task id       | 1        |
| name       | nama          | strength |
| level      | level saat ini | 2        |

### Hitung mundur Item Toko

**Nama:**

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**Nilai balik:**

| Parameters | Arti                       | Contoh                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | item id                       | 1                         |
| name       | nama Item                     | play games for 30 minutes |
| time_left  | waktu tersisa (milidetik) | 30000                     |

### Siklus Pomodoro

?> Peristiwa broadcast ini dirilis di v1.101.0, menyediakan data peristiwa yang lebih kaya.

**Nama:**

- Start: app.lifeup.pomodoro.start
- Pause: app.lifeup.pomodoro.pause (baru di v1.101.0)
- Stop: app.lifeup.pomodoro.stop
- Complete: app.lifeup.pomodoro.complete

**Deskripsi:** Saat timer Pomodoro mulai, dijeda, dihentikan, atau selesai, sistem mengirim peristiwa broadcast yang sesuai dengan informasi Tugas, status waktu, dan data detail lainnya.

**Nilai balik:**

| Parameter          | Arti                       | Contoh        | Catatan                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | Task ID                       | 1              | Opsional, hanya ada jika Pomodoro terkait dengan Tugas |
| task_gid           | Task group ID                 | 1              | Opsional, hanya ada jika Pomodoro terkait dengan Tugas |
| name               | Nama Tugas                     | Study English  | Nama Tugas terkait Pomodoro atau nama kustom         |
| service_type       | Tipe layanan                  | 0              | 0=Fokus, 1=istirahat pendek, 2=istirahat panjang                      |
| service_type_label | Label tipe layanan            | Focus          | Teks tipe layanan terlokalisasi                                |
| duration           | Total durasi (milidetik) | 1500000        | Total durasi Fokus atau istirahat                           |
| remaining          | Durasi tersisa (milidetik) | 900000     | Durasi tersisa saat ini                                 |
| elapsed            | Durasi berlalu (milidetik) | 600000       | Durasi yang telah berlalu                                           |
| start              | Waktu mulai                    | 1639123456789  | Unix timestamp (milidetik)                              |
| event_time         | Waktu pemicu peristiwa            | 1639123456789  | Unix timestamp (milidetik)                              |
| reason             | Alasan berhenti                   | user           | Hanya untuk event stop, nilai yang mungkin: manual, cancel, complete, auto |

**Deskripsi alasan berhenti:**

Parameter `reason` hanya ada di event `app.lifeup.pomodoro.stop`, menunjukkan alasan Pomodoro berhenti:

- `manual`: Pengguna menghentikan secara manual
- `cancel`: Pengguna membatalkan
- `complete`: Selesai normal (Catatan: Saat selesai, event `app.lifeup.pomodoro.complete` juga dipicu)
- `auto`: Berhenti otomatis (mis., Tugas dihapus)

### Siklus Timer Positif :id=broadcast_positive_timing

> [!NOTE]
> Peristiwa ini untuk fitur timer positif, bukan peristiwa hitung mundur Pomodoro di atas. Sebelum menggunakannya, pastikan `Settings` → `Labs` → `Developer mode` → `Broadcast events` diaktifkan.

**Nama:**

- Start: app.lifeup.timing.start
- Pause: app.lifeup.timing.pause
- Complete: app.lifeup.timing.complete
- Abandon: app.lifeup.timing.abandon

**Deskripsi:** Saat timer positif mulai, dijeda, selesai, atau ditinggalkan secara manual, LifeUp mengirim broadcast yang sesuai. `complete` berarti sesi selesai normal dan dicatat. `abandon` berarti sesi saat ini dihentikan atau dibuang secara manual.

**Nilai balik:**

| Parameters | Arti                        | Contoh      | Catatan                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | Task ID                        | 1             | Opsional, hanya ada jika timer terkait dengan Tugas |
| name       | Nama Tugas                      | Study English | Nama Tugas terkait atau nama timer kustom          |
| time       | Durasi akumulasi (ms)      | 600000        | Total durasi berlalu timer positif saat ini |
| start      | Waktu mulai                     | 1639123456789 | Unix timestamp (milidetik)                    |
| end        | Waktu akhir                       | 1639127056789 | Hanya ada di event `complete` / `abandon`    |

---

## Integrasi

Kami sangat menyambut integrasi dalam bentuk apa pun dari pengembang lain.

> Detail lebih lanjut akan segera disediakan...

### Butuh API lebih banyak?

Fungsionalitas API saat ini masih dalam satu iterasi versi.

Ke depannya, kami akan terus menambahkan API lebih banyak untuk memenuhi lebih banyak skenario penggunaan.

Jika Anda membutuhkan API lebih banyak, Anda dapat membuat Issues di [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### Cara memanggil

#### Android

##### Menggunakan SDK

Lihat modul `core` di: https://github.com/Ayagikei/LifeUp-SDK.

##### Tanpa Menggunakan SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Halaman web

Jika halaman web dipanggil, apakah dapat dipicu tergantung browser. Browser reguler seperti Quark, Chrome, dan Edge baik-baik saja. Tetapi beberapa browser bawaan sistem lain mungkin mengingatkan pengguna "apakah akan membuka Rensheng" setiap kali muncul.

Jika Anda mengembangkan aplikasi WebView embedded sendiri, Anda harus memastikan WebView dapat menangani skema lifeup.

Untuk memastikan pengalaman konsisten, Anda dapat menggunakan efek tautan produk di `LifeUp` dan centang "Use built-in browser" untuk membukanya. Tetapi karena pengaturan keamanan, cara ini hanya mendukung tautan HTTPS (bukan HTTP)

**HTML**

Langsung lompat ke hyperlink

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

Sebenarnya, ini juga dipanggil sebagai hyperlink

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Pengembang Aplikasi/Web/Otomatisasi

Beritahu kami jika Anda telah mengembangkan apa pun terkait LifeUp!

<br/>

### Bahasa pemrograman/platform apa pun yang mendukung protokol HTTP

Untuk detail, lihat https://github.com/Ayagikei/LifeUp-SDK dan [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).

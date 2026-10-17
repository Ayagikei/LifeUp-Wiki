# Referensi API HTTP :id=http-query-reference

Gunakan referensi ini untuk parameter permintaan LifeUp Cloud dan model respons HTTP lengkap. Untuk instalasi, otorisasi, dan koneksi, mulai dari [LifeUp Cloud](/guide/api_cloud). Endpoint jurnal terbaru memerlukan LifeUp **1.106.0+** dan LifeUp Cloud **3.0.0+**; gunakan `/info` untuk mengenali versi terpasang. Referensi ini menjelaskan kontrak kode sumber saat ini, bukan bukti ketersediaan rilis tertentu.

## Indeks antarmuka :id=interface-index

| Sumber daya | Metode dan jalur | Parameter dan model |
| --- | --- | --- |
| Aturan umum | Respons JSON, otorisasi, kondisi cache, paginasi | [Konvensi](#representations), [cache dan otorisasi](#auth-cache), [paginasi](#pagination) |
| Tugas | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Kueri](#get-tasks), [model tugas](#task-fields), [kategori](#get-tasks-categories) |
| Riwayat tugas | `GET /history` | [Parameter](#get-history), [stempel waktu](#task-times), [laporan harian](#daily-report) |
| Item | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [ID item, ID kategori, dan model lengkap](#get-items) |
| Atribut | `GET /skills`, `GET /skill_groups` | [Atribut dan grup](#get-skills) |
| Pencapaian | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Pencapaian dan kondisi](#get-achievements) |
| Sintesis | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Resep dan kategori](#get-synthesis) |
| Perasaan | `GET /feelings` | [Perasaan berhalaman](#get-feelings) |
| EXP / koin | `GET /exp_records`, `GET /coin_records` | [Parameter dan model jurnal](#reward-journals) |
| Catatan lain | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventaris](#get-inventory-records), [langkah](#get-step-records) |
| Level / statistik | `GET /level_defines`, `GET /statistics` | [Level](#get-level-defines), [statistik](#get-statistics) |
| App / saldo | `GET /info`, `GET /coin` | [Informasi versi](#get-info), [hasil koin](#get-coin) |
| Memanggil aksi | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Jembatan pemanggilan](#invoke-api); metode bisnis tetap berada dalam [katalog URL Scheme](/guide/api) |
| File / cadangan | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [File](#files-download), [transfer cadangan](#files-backup) |
| Peristiwa | `GET /events`, WebSocket `/events` | [Polling dan peristiwa langsung](#get-events) |
| Halaman awal | `GET /` | Pengantar HTML, bukan sumber daya JSON. |

MCP menggunakan representasi klien/alat tersendiri; lihat [perbedaan MCP](#mcp-differences) dan [panduan MCP](/guide/api_mcp).

## Transportasi dan representasi :id=representations

| Antarmuka | Representasi | Perbedaan penting |
| --- | --- | --- |
| Kueri HTTP Cloud | JSON yang dibungkus sebagai `{code, message, data}` | Referensi endpoint di bawah menjelaskan JSON publik ini. |
| ContentProvider Android | Kolom Cursor seperti `_ID` / `_GID`, terkadang berisi teks JSON | Pengurai SDK mengubahnya menjadi kolom HTTP seperti `id` / `gid` dan larik bertingkat. Jangan gunakan definisi kolom Cursor sebagai skema HTTP. |
| Tindakan URL Scheme | `lifeup://api/{method}` beserta parameter/hasil khusus metode | Parameter penulisan dapat memakai snake_case meskipun kolom baca HTTP memakai camelCase. |
| Alat daftar MCP | Pembungkus khusus alat dan rekaman ringkas atau terperinci | Paginasi MCP dan kolom keluarannya merupakan perilaku tambahan klien, bukan kolom respons HTTP. |

## Respons dan kesalahan :id=response-errors

Pembungkus JSON HTTP bersama adalah `HttpResponse<T>`:

| Kolom | Tipe | Arti |
| --- | --- | --- |
| `code` | integer | `200` untuk kueri yang berhasil; nilai selain `200` menunjukkan kesalahan. Ini kolom badan respons, terpisah dari status HTTP. |
| `message` | string | Biasanya `success` jika berhasil; deskripsi kesalahan jika gagal. |
| `data` | `T` atau `null` | Nilai khusus endpoint (array, objek, atau string) saat berhasil; `null` saat gagal. |

Contoh daftar kosong yang berhasil:

```json
{"code":200,"message":"success","data":[]}
```

Ilustrasi kesalahan izin/akses penyedia:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Sinyal | Penanganan |
| --- | --- |
| HTTP `401` | Kirim token Cloud yang dikonfigurasi sebagai nilai mentah header `Authorization`. Jangan tambahkan `Bearer`. |
| Badan `code = 10001` | Pastikan LifeUp terpasang/berjalan dan Cloud memiliki izin membaca data LifeUp. |
| Badan `code = 10002` | Kueri ContentProvider gagal; periksa pesan kesalahan. |
| Status/kode lain yang tidak berhasil | Anggap kueri gagal, bukan hasil kosong. |

Periksa **keduanya**, status HTTP dan `code` dalam badan. Beberapa kegagalan rute tetap memakai HTTP `200` dengan kode kesalahan dalam badan. Tindakan melalui `/api/contentprovider` juga memerlukan pemeriksaan setiap `data[].result.api_result`; `code=200` pada pembungkus tidak membuktikan semua tindakan berhasil.

## Otorisasi dan pembacaan bersyarat :id=auth-cache

Jika token Cloud dikonfigurasi, kirim nilai mentah persisnya dalam `Authorization`; jangan tambahkan `Bearer`. Server juga menerima parameter kueri `token`, termasuk untuk klien yang tidak dapat mengatur header WebSocket. Token hilang atau salah menghasilkan HTTP `401` dan `code=401` pada badan. Pemeriksaan ini mencakup halaman awal, sumber daya, jembatan, file, transfer cadangan, dan peristiwa.

Pembacaan sumber daya JSON yang berhasil menyertakan `ETag` SHA-256 kuat dan `Cache-Control: private, no-cache`. Ini berlaku pada tugas/riwayat, item/kategori, atribut/grup, pencapaian/kondisi, perasaan, sintesis/kategori, jurnal, level, statistik, info, dan koin. Ini tidak berlaku pada jembatan pemanggilan, transfer file, transfer cadangan, atau aliran/polling peristiwa.

| Header permintaan | Perilaku respons saat ini |
| --- | --- |
| `If-Match` | Versi tidak cocok gagal dengan HTTP `412`; dievaluasi sebelum `If-None-Match`. |
| `If-None-Match` | Versi cocok mengembalikan HTTP `304`, tanpa badan JSON untuk diparsing. Gunakan kembali representasi berhasil yang di-cache. |

Pembungkus kesalahan tidak memiliki header versi sumber daya. Pembacaan bersyarat berlaku per permintaan sumber daya, bukan snapshot atau transaksi lintas halaman atau rute.

Permintaan browser lintas asal dapat menggunakan `If-None-Match`. Konfigurasi CORS saat ini tidak mengizinkan `If-Match` dalam preflight, jadi jangan bergantung pada permintaan browser lintas asal `If-Match` tanpa mengubah implementasi tersebut. Klien native tidak tunduk pada CORS browser.

## Konvensi data bersama :id=data-conventions

| Konvensi | Aturan |
| --- | --- |
| Waktu | Kolom stempel waktu memakai milidetik Unix. Batas hari kalender bergantung pada zona waktu yang dipilih. Setiap kolom tetap memiliki makna khusus sumber dayanya. |
| Identitas | `id` tugas mengidentifikasi satu tugas/siklus; `gid` tugas mengidentifikasi kelompoknya lintas siklus berulang. ID kategori/daftar mengidentifikasi sumber daya terpisah. |
| Nilai kosong | Tidak ada, `null`, `0`, `""`, dan `[]` adalah nilai berbeda. Setiap model mendokumentasikan perilaku nilai pengganti atau penghilangan yang sebenarnya. |
| ID numerik | ID dapat berupa bilangan bulat bertanda 64-bit; Number JavaScript tidak dapat merepresentasikan setiap nilai secara tepat. Pertahankan ID besar dengan parser JSON yang sesuai. |
| Larik dan objek | Nilai HTTP bertingkat seperti `items` dan `subTasks` adalah larik, bukan string JSON. |
| Kode status dan alasan | Gunakan enum yang didokumentasikan untuk sumber daya tersebut. Status tugas, status prestasi, dan kode alasan jurnal memiliki domain berbeda. |

Lihat [definisi stempel waktu tugas](/guide/api-reference?id=task-times) untuk `startTime`, `deadline`, dan `endTime`.

## Paginasi dan penyaringan :id=pagination

Paginasi adalah kemampuan endpoint, bukan sifat setiap daftar. Respons daftar HTTP mentah berisi `data: [...]`; respons tersebut **tidak** menambahkan `total`, `count`, atau `hasMore`.

| Endpoint HTTP | Paginasi | Rentang tanggal | Penyaringan lain |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | Tidak; larik penuh | Tidak | Kategori opsional di jalur |
| `/history` | `offset` / `limit` di server | Tidak | `gid` opsional |
| `/feelings` | `offset` / `limit` di server | Tidak | Lihat [perasaan](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` di server | `time_range_start` / `time_range_end` | Lihat bagian endpoint terkait di bawah |
| `/statistics` | Tidak; satu objek | `time_range_start` / `time_range_end` | Kueri agregat |
| `/coin`, `/info` | Tidak; satu objek | Tidak | Kueri objek tunggal |

Untuk endpoint berpaginasi, nilai bawaan HTTP adalah `offset=0` dan `limit=100`. Gunakan offset nonnegatif dan ukuran halaman `1..100` dalam perulangan paginasi bersama. Penghubung HTTP tidak menerapkan pembatasan MCP `1..100`, dan penyedia di bawahnya mungkin memberlakukan batas lain; baca catatan ukuran halaman efektif dan validasi setiap endpoint.

Selain [batasan Pomodoro dengan filter waktu](#get-pomodoro-records), setelah setiap halaman berhasil, tambah `offset` sebanyak catatan yang dikembalikan. Berhenti saat jumlah tersebut lebih kecil dari ukuran halaman efektif (`limit` yang diminta saat menggunakan `1..100`, kecuali Pomodoro dengan filter waktu). Jangan menganggap halaman yang dibatasi penyedia sebagai halaman terakhir. Halaman kosong setelah akhir adalah normal. Mengambil beberapa halaman tidak membuat snapshot: catatan dapat berubah selama kueri berlangsung.

Pada SDK HTTP saat ini, batas tanggal diteruskan hanya jika **keduanya** dapat diurai sebagai integer dan `start < end`. Satu batas saja, batas yang tidak dapat diurai, atau urutan terbalik menghasilkan kueri tanpa penyaringan; jangan mengandalkan kesalahan untuk mendeteksinya. Validasi kedua batas sebelum mengirim. Referensi jurnal menjelaskan bahwa kedua batas endpoint tersebut bersifat inklusif.

## Perbedaan MCP :id=mcp-differences

Alat daftar MCP memakai nilai bawaan `limit=20`, membatasinya ke `1..100`, dan membatasi `offset` agar setidaknya `0`. Alat ini mengirim paginasi ke sumber daya yang dipaginasi server seperti riwayat/jurnal, tetapi mengambil seluruh larik HTTP dan memotongnya secara lokal untuk sumber daya seperti tugas. `items`, `count`, `hasMore`, dan `total` opsionalnya termasuk pembungkus MCP. `detail=false` juga menghapus kolom dari setiap rekaman; gunakan `detail=true` saat memerlukan model HTTP lengkap.

## Sumber dan cakupan versi :id=api-common-sources

Referensi ini menjelaskan SDK publik saat ini dan perilaku penyedia LifeUp yang terkait. Contoh memakai data rekaan. Tautan sumber adalah referensi implementasi, bukan bukti bahwa versi tertentu yang terpasang memuat semua kolom: [rute HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [pembungkus HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [pemetaan kueri MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).


## Model data tugas dan riwayat :id=task-history-models

Halaman ini mendefinisikan **JSON HTTP** yang dikembalikan oleh [kueri tugas/riwayat](/guide/api-reference?id=task-queries). Kolom Cursor Android dan parameter tindakan URL Scheme dapat memiliki nama dan representasi berbeda; lihat [konvensi bersama](/guide/api-reference?id=representations).

SDK memakai satu kelas `Task` terserialisasi untuk dua tampilan. Di sini, `Task` menamai tampilan `/tasks` dan `HistoryRecord` menamai tampilan `/history`. Nama ini menjelaskan keluaran yang sudah ada; tidak memperkenalkan API lain. Serialisasi Cloud saat ini menyertakan nilai bawaan dan kolom `null`.

### Kolom Task / HistoryRecord :id=task-fields

Semua kolom di bawah muncul dalam objek HTTP saat ini. Nilai penyedia yang tidak ada sering diubah menjadi nilai pengganti yang tercantum; nilai pengganti tidak membuktikan bahwa data sumber berisi nilai tersebut.

| Kolom | Tipe JSON | Arti / nilai pengganti |
| --- | --- | --- |
| `id` | integer atau `null` | ID tugas/siklus ini. |
| `gid` | integer atau `null` | ID kelompok tugas yang sama lintas siklus berulang. |
| `name` | string | Nama tugas. Nama penyedia yang tidak ada menjadi `ERROR: name is null`. |
| `notes` | string | Catatan; string kosong jika tidak ada. |
| `status` | integer | Status tugas; nilai yang tidak ada menjadi `0`. Lihat tabel status di bawah. |
| `startTime` | integer | Waktu mulai yang dikonfigurasi dalam milidetik; nilai pengganti SDK `0`. |
| `deadline` | integer | Tenggat dalam milidetik; nilai pengganti SDK `0` jika tidak ada. |
| `remindTime` | integer | Waktu pengingat dalam milidetik; nilai pengganti SDK `0` jika tidak ada. |
| `frequency` | integer | Kode pengulangan; `0` sekali, `1` harian, `-1` tanpa batas. Mode pengulangan lain dijelaskan dalam [tindakan tugas](/guide/api). Nilai pengganti SDK `0`. |
| `weekdays` | string | Pilihan hari, misalnya `1,3,5` (Senin `1`, Minggu `7`); kosong jika tidak diberikan, dan selalu menjadi placeholder kosong pada riwayat. |
| `exp` | integer | Hadiah EXP yang dikonfigurasi, bukan jumlah transaksi; bawaan `0`. |
| `skillIds` | larik integer | Atribut yang terkait dengan hadiah; larik kosong jika tidak tersedia. |
| `coin` | integer | Hadiah koin yang dikonfigurasi; bawaan `0`. |
| `coinVariable` | integer | Pengaturan hadiah koin acak; bawaan `0`. |
| `itemId` | integer | ID item hadiah pertama dari format lama; bawaan `0`. Gunakan `items` untuk daftar lengkap. |
| `itemAmount` | integer | Jumlah item hadiah pertama dari format lama; bawaan `0`. Nama HTTP ini berbeda dari kolom penyedia `itemCount`. |
| `words` | string | Teks motivasi penyelesaian; kosong jika tidak ada. |
| `categoryId` | integer | ID kategori/daftar tugas; bawaan `0` jika tidak ada. |
| `order` | integer | Nilai urutan daftar tugas; selalu placeholder `0` pada riwayat karena penyedia tersebut tidak mengembalikan kolom ini. |
| `nameExtended` | string | Nama tampilan yang diperluas; selalu placeholder kosong pada riwayat karena penyedia tersebut tidak mengembalikan kolom ini. |
| `endTime` | integer | Waktu akhir yang tercatat untuk riwayat. `/tasks` mengisinya dengan `0`; lihat [makna waktu](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Hadiah item; larik kosong jika tidak tersedia. |
| `subTasks` | `SubTask[]` | Subtugas bertingkat; larik kosong jika tidak tersedia. |
| `countProgress` | `TaskCountProgress` atau `null` | Snapshot progres hitungan jika tersedia; dapat muncul pada kedua tampilan. |
| `repeatEndCondition` | `TaskRepeatEndCondition` atau `null` | Aturan akhir pengulangan pada `/tasks`; selalu `null` pada `/history`. |

### Status dan stempel waktu tugas :id=task-times

| `status` | Arti | Arti `endTime` pada riwayat |
| --- | --- | --- |
| `0` | Belum selesai | Bukan waktu penyelesaian; `/history` memilih rekaman yang telah berakhir. |
| `1` | Selesai | Waktu penyelesaian yang tercatat. |
| `2` | Terlambat | Waktu keterlambatan yang tercatat. |
| `3` | Ditinggalkan | Waktu ditinggalkan yang tercatat. |

| Kolom waktu | Definisi |
| --- | --- |
| `startTime` | Waktu mulai tugas yang dikonfigurasi/dijadwalkan, bukan saat pengguna benar-benar mulai bekerja. |
| `deadline` | Tenggat terjadwal, terpisah dari waktu akhir yang tercatat. |
| `endTime` | Waktu akhir tugas riwayat yang tercatat; tafsirkan bersama `status` seperti di atas. |

Ketiganya memakai milidetik Unix. Untuk penyelesaian normal, App mencatat waktu saat ini. `history_operation` dengan `operation=edit_completed_time` menerima masukan `completed_time` dan mengedit waktu penyelesaian tersimpan yang sama; pembacaan riwayat tetap mengembalikan nama kolom `endTime`.

Waktu tersimpan dapat diedit. Jika rekaman yang telah berakhir tidak memiliki tanggal akhir tersimpan, App memakai waktu saat ini. Karena itu, `endTime` adalah waktu yang tercatat saat ini, bukan stempel waktu audit yang tidak dapat diubah. `0` pada `/tasks` hanya placeholder SDK, bukan peristiwa nyata pada awal epoch Unix.

### RewardItem :id=reward-item

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `itemId` | integer | ID item hadiah. |
| `itemCount` | integer | Jumlah hadiah. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Kolom | Tipe JSON | Arti / bawaan |
| --- | --- | --- |
| `id` | integer | ID subtugas. |
| `gid` | integer | ID kelompok subtugas. |
| `todo` | string | Teks subtugas. |
| `status` | integer | `0` belum selesai, `1` selesai. |
| `remindTime` | integer atau `null` | Stempel waktu pengingat dalam milidetik; `null` jika tidak tersedia. |
| `endTime` | integer atau `null` | Stempel waktu penyelesaian subtugas dalam milidetik; `null` jika tidak tersedia. |
| `exp` | integer | Hadiah EXP yang dikonfigurasi. |
| `coin` | integer atau `null` | Hadiah koin yang dikonfigurasi. |
| `coinVariable` | integer atau `null` | Pengaturan hadiah koin acak. |
| `items` | `RewardItem[]` | Hadiah item; bawaan larik kosong. |
| `order` | integer atau `null` | Nilai urutan; bawaan model `0`. |
| `autoUseItem` | boolean atau `null` | Apakah hadiah otomatis digunakan; bawaan model `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `currentCount` | integer | Hitungan saat ini untuk tugas/siklus ini. |
| `targetCount` | integer | Target hitungan untuk tugas/siklus ini. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Kolom | Tipe JSON | Arti / bawaan |
| --- | --- | --- |
| `mode` | string | `COUNT` atau `DATE`. Ini string pada sisi baca, bukan parameter tindakan numerik. |
| `behavior` | string | `TERMINATE` atau `FREEZE`. |
| `targetCycleCount` | integer atau `null` | Target jumlah siklus untuk `COUNT`; bawaan `null`. |
| `endDateMillis` | integer atau `null` | Stempel waktu tanggal akhir dalam milidetik untuk `DATE`; bawaan `null`. |
| `inclusive` | boolean | Penanda tanggal akhir inklusif; bawaan `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Jumlah hadiah :id=reward-amounts

Kolom tugas dan subtugas ini menjelaskan hadiah yang dikonfigurasi. Pengali, koin acak, dan aturan penyelesaian dapat mengubah hadiah aktual. Gunakan [jurnal EXP dan koin](/guide/api-reference?id=reward-journals) untuk jumlah transaksi, serta bedakan hadiah positif dari perubahan bersih yang mencakup pembalikan atau penalti.

### Referensi implementasi :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Pengurai](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Progres hitungan](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Aturan pengulangan](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).


## Kueri tugas dan riwayat :id=task-queries

Baca [konvensi bersama](/guide/api-reference?id=http-query-reference) dan [model Task/History lengkap](/guide/api-reference?id=task-history-models). Endpoint ini memerlukan izin membaca data LifeUp pada Cloud. Kueri daftar dasar didokumentasikan untuk LifeUp v1.91+ dengan Cloud terbaru; contoh menjelaskan kolom SDK saat ini. Periksa `/info` saat berintegrasi dengan instalasi lama.

### GET /tasks dan /tasks/{categoryId} :id=get-tasks

Kueri daftar tugas saat ini yang **belum selesai**, dengan pembatasan kategori/daftar opsional. Hasilnya berupa larik penuh, bukan respons yang dipaginasi server. Rekaman yang selesai, terlambat, dan ditinggalkan berada di `/history`.

| Parameter | Lokasi | Tipe | Wajib | Bawaan / perilaku |
| --- | --- | --- | --- | --- |
| `categoryId` | Jalur | integer | Hanya untuk `/tasks/{categoryId}` | Hilangkan seluruh segmen jalur untuk daftar tugas tanpa pembatasan. |

Rute ini tidak mendukung parameter kueri `offset`, `limit`, `gid`, atau rentang tanggal. Segmen kategori yang bukan integer saat ini diurai sebagai kategori yang tidak diberikan; validasi sebelum meminta agar tidak tanpa sengaja mengueri semua tugas.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Respons:** `HttpResponse<Task[]>`. Semua kolom rekaman dan struktur bertingkat didefinisikan pada [kolom Task/History](/guide/api-reference?id=task-fields). Rekaman rekaan berikut menunjukkan bentuk HTTP tingkat teratas yang lengkap; `endTime=0` adalah placeholder untuk rute ini, bukan stempel waktu penyelesaian.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Perilaku dan kesalahan:** pemilihan/urutan daftar mengikuti logika daftar tugas LifeUp; endpoint ini tidak menjanjikan urutan berdasarkan waktu penyelesaian. `data: []` yang berhasil berarti daftar tugas terpilih tidak mengembalikan rekaman. Kegagalan izin/penyedia memakai [pembungkus kesalahan bersama](/guide/api-reference?id=response-errors); hasilnya bukan larik kosong. Untuk laporan penyelesaian, gunakan `/history` di bawah, bukan `endTime` rute ini.

### GET /history :id=get-history

Kueri rekaman tugas berakhir yang terlihat, termasuk tugas selesai, terlambat, dan ditinggalkan. Riwayat yang dihapus tidak disertakan.

| Parameter | Lokasi | Tipe | Wajib | Bawaan / perilaku |
| --- | --- | --- | --- | --- |
| `offset` | Kueri | integer | Tidak | `0`; jumlah rekaman yang dilewati, dihitung dari nol. |
| `limit` | Kueri | integer | Tidak | `100`; minta ukuran halaman positif, sebaiknya `1..100`. |
| `gid` | Kueri | integer | Tidak | Tanpa filter kelompok; jika diberikan, memilih kelompok tugas tersebut lintas siklus. |

Pengurai HTTP memakai nilai pengganti `0` / `100` untuk `offset` / `limit` yang tidak dapat diurai, dan membuang `gid` yang tidak dapat diurai. Rute ini tidak membatasi angka yang berhasil diurai. Validasi sendiri offset nonnegatif dan limit positif. `time_range_start` / `time_range_end` **tidak didukung**; memberikannya tidak menyaring riwayat.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Respons:** `HttpResponse<HistoryRecord[]>`, memakai [kolom transmisi Task/History](/guide/api-reference?id=task-fields). `HistoryRecord` adalah nama dokumentasi untuk tampilan riwayat model `Task` SDK. `repeatEndCondition` bernilai `null` dalam tampilan ini; `countProgress` mungkin tersedia. `endTime` tersimpan ditafsirkan bersama `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Urutan:** tanggal akhir tersimpan menurun, terbaru dahulu. Tidak ada aturan pembeda yang didokumentasikan untuk tanggal akhir yang sama. Paginasi bukan snapshot; hindari mengedit data saat mengumpulkan laporan, dan hapus duplikasi berdasarkan `id` saat menggabungkan halaman.

**Paginasi dan hasil kosong:** gunakan [prosedur paginasi bersama](/guide/api-reference?id=pagination). Larik kosong yang berhasil berarti tidak ada rekaman terlihat yang cocok dengan halaman/kelompok ini, termasuk saat `offset` melewati akhir daftar. Ini tidak membuktikan bahwa aktivitas tidak pernah terjadi: rekaman yang dihapus tidak disertakan dan tidak ada penanda kelengkapan. Jika ada permintaan yang gagal, laporkan data tidak tersedia/tidak lengkap, bukan nol tugas. [Kesalahan bersama](/guide/api-reference?id=response-errors) berlaku.

### Membuat laporan harian :id=daily-report

1. Pilih zona waktu laporan. Hitung awal hari kalender (`dayStart`) dan awal hari kalender berikutnya (`nextDayStart`). Jangan berasumsi setiap hari lokal tepat 24 jam.
2. Baca `/history` dengan `offset=0&limit=100`, periksa setiap respons, dan kumpulkan seluruh halaman. Pertahankan filter `gid` yang diinginkan secara konsisten.
3. Pilih `status == 1` dan `dayStart <= endTime < nextDayStart`. Gunakan [batasan waktu tercatat](/guide/api-reference?id=task-times) saat menjelaskan hasil.
4. Untuk perubahan EXP dan koin aktual, baca [jurnal hadiah](/guide/api-reference?id=reward-journals) untuk hari yang sama. Filter tanggalnya mencakup kedua ujung, jadi gunakan `time_range_start=dayStart` dan `time_range_end=nextDayStart-1`.
5. Bedakan “tidak ditemukan rekaman dalam data yang tersedia” dari pembacaan gagal/belum selesai. Tentukan apakah laporan menampilkan hanya hadiah positif atau perubahan bersih termasuk pembalikan, lalu terapkan pilihan itu secara konsisten.

`exp` dan `coin` tugas/riwayat adalah hadiah yang dikonfigurasi; keduanya bukan pengganti yang andal untuk jumlah yang dicatat dalam jurnal. Waktu penyelesaian yang diedit ke hari lain tidak berarti waktu transaksi jurnal hadiah ikut berpindah.

### Referensi implementasi :id=api-task-queries-sources

[Rute HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Penguraian tugas dan riwayat](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).


## Kueri jurnal EXP dan koin :id=reward-journals

Endpoint HTTP hanya baca ini memerlukan izin membaca data LifeUp, LifeUp **1.106.0+**, dan LifeUp Cloud **3.0.0+**. Endpoint mengembalikan perubahan yang tercatat, termasuk pengurangan dan pembalikan, bukan konfigurasi hadiah tugas. Baca [konvensi bersama](/guide/api-reference?id=http-query-reference) terlebih dahulu.

### Parameter permintaan untuk kedua endpoint :id=journal-parameters

Kontrak berikut berlaku khusus untuk **kedua** endpoint `GET /exp_records` dan `GET /coin_records`.

| Parameter | Lokasi | Tipe | Wajib | Bawaan / perilaku sebenarnya |
| --- | --- | --- | --- | --- |
| `offset` | Kueri | integer | Tidak | Bawaan HTTP `0`; penyedia membatasi nilai negatif menjadi `0`. |
| `limit` | Kueri | integer | Tidak | Bawaan HTTP `100`; penyedia membatasi ke `1..200`. Gunakan `1..100` untuk prosedur paginasi bersama. |
| `time_range_start` | Kueri | integer (milidetik Unix) | Tidak, atau berpasangan | Batas bawah inklusif waktu transaksi yang tercatat. |
| `time_range_end` | Kueri | integer (milidetik Unix) | Tidak, atau berpasangan | Batas atas inklusif; penyaringan yang valid memerlukan `start < end`. |

Nilai paginasi yang tidak dapat diurai atau di luar rentang memakai bawaan HTTP. Nilai tanggal yang tidak dapat diurai dianggap tidak ada. SDK saat ini meneruskan rentang tanggal hanya jika kedua batas ada dan `start < end`; jika tidak, kueri berjalan **tanpa filter tanggal**. Pemanggilan ContentProvider mentah langsung memiliki validasi rentang tidak valid yang berbeda. Validasi batas pada pemanggil HTTP.

Kedua endpoint mengurutkan waktu transaksi tercatat secara menurun, terbaru dahulu, dan mengecualikan entri jurnal yang dihapus. Tidak ada jaminan aturan pembeda ID atau snapshot beberapa halaman. Ikuti [paginasi](/guide/api-reference?id=pagination) dengan memperhitungkan limit efektif penyedia. Larik kosong yang berhasil berarti tidak ada entri yang cocok dengan rentang/halaman terpilih; pembacaan gagal bukan nol aktivitas. Kedua endpoint tidak menyediakan penanda kelengkapan untuk data yang dihapus atau tidak tersedia.

### GET /exp_records :id=get-exp-records

Kueri perubahan EXP. Parameternya tepat [empat parameter jurnal di atas](/guide/api-reference?id=journal-parameters); tidak ada filter `gid`.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Respons:** `HttpResponse<ExpRecord[]>`. Serialisasi saat ini menyertakan semua kolom yang tercantum, termasuk nilai yang dapat berupa null.

| Kolom | Tipe JSON | Arti / nilai pengganti pengurai |
| --- | --- | --- |
| `id` | integer atau `null` | ID entri jurnal. |
| `time` | integer atau `null` | Waktu transaksi dalam milidetik Unix, berbeda dari waktu penyelesaian tugas yang dapat diedit. |
| `value` | integer | Perubahan EXP per atribut terkait; nilai pengganti `0`. Gunakan `isDecrease` untuk arah perubahan. |
| `isDecrease` | boolean | `true` untuk pengurangan, `false` untuk penambahan; pengurai menganggap integer penyedia `1` sebagai true. |
| `totalValue` | integer | Perubahan EXP agregat yang tercatat, **bukan saldo EXP**; nilai pengganti `0`. Batch beberapa atribut dapat tumpang tindih dalam total tersimpan ini; lihat [total laporan](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | Kode alasan khusus EXP; nilai pengganti `0`. |
| `relatedId` | integer atau `null` | ID objek sumber terkait. Untuk penyelesaian tugas normal, ini adalah `id` rekaman tugas, bukan `gid`-nya. Alasan lain dapat merujuk ke sumber daya lain. |
| `content` | string atau `null` | Deskripsi perubahan. |
| `skillIds` | larik integer | ID atribut/keterampilan terkait; nilai pengganti larik kosong. |
| `relatedAttributes` | larik string | String atribut lama yang terkait; nilai pengganti larik kosong. |

Contoh rekaan: 10 EXP diterapkan ke masing-masing dari dua atribut, dengan agregat 20 EXP.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Kesalahan:** [kesalahan HTTP/penyedia bersama](/guide/api-reference?id=response-errors). Batas tanggal HTTP yang tidak valid dapat menghilangkan penyaringan tanpa pemberitahuan seperti dijelaskan di atas, alih-alih menghasilkan kesalahan.

### GET /coin_records :id=get-coin-records

Kueri perubahan koin. Parameternya tepat [empat parameter jurnal di atas](/guide/api-reference?id=journal-parameters); tidak ada filter `gid`.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Respons:** `HttpResponse<CoinRecord[]>`. Serialisasi saat ini menyertakan semua kolom yang tercantum, termasuk nilai yang dapat berupa null.

| Kolom | Tipe JSON | Arti / nilai pengganti pengurai |
| --- | --- | --- |
| `id` | integer atau `null` | ID entri jurnal. |
| `time` | integer atau `null` | Waktu transaksi dalam milidetik Unix. |
| `value` | integer | Jumlah perubahan koin; nilai pengganti `0`. Gunakan `isDecrease` untuk arah perubahan. |
| `isDecrease` | boolean | `true` untuk pengurangan, `false` untuk penambahan; pengurai menganggap integer penyedia `1` sebagai true. |
| `totalValue` | integer | Saldo koin setelah operasi; nilai pengganti `0`. Berbeda dari `totalValue` EXP, ini adalah saldo. |
| `resCode` | integer | Kode alasan khusus koin; nilai pengganti `0`. |
| `relatedId` | integer atau `null` | ID objek sumber terkait; penyelesaian tugas normal memakai `id` rekaman tugas. Tafsirkan sumber lain dengan kode alasannya. |
| `content` | string atau `null` | Deskripsi perubahan. |
| `savingBalance` | integer atau `null` | Saldo tabungan yang dicatat untuk operasi. |

Contoh rekaan: pengurangan 5 koin, menyisakan saldo 95 koin.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Kesalahan:** [kesalahan HTTP/penyedia bersama](/guide/api-reference?id=response-errors). Batas tanggal HTTP yang tidak valid dapat menghilangkan penyaringan tanpa pemberitahuan seperti dijelaskan di atas, alih-alih menghasilkan kesalahan.

### Kode alasan dan total laporan :id=journal-totals

Domain kode alasan berbeda. Beberapa contoh:

| Alasan | EXP `resCode` | Koin `resCode` |
| --- | --- | --- |
| Menyelesaikan tugas | `1` | `2` |
| Membatalkan penyelesaian tugas | `101` | `3` |
| Menyelesaikan subtugas | `12` | `11` |
| Membatalkan subtugas | `106` | `12` |
| Perubahan API | `200` | `28` |

Kode EXP lengkap: `0` tidak diketahui; `1` penyelesaian tugas; `2` pencapaian; `3` penukaran suka; `4` rentetan hari penggunaan; `5` penukaran langkah; `6` atur selesai; `7` batalkan penyerahan tugas; `8` batalkan lewat tenggat; `9` makan tomat; `10` gunakan item; `11` buka pencapaian pengguna; `12` penyelesaian subtugas; `200` API; `101` batalkan penyelesaian; `102` menyerah; `103` lewat tenggat; `104` penggunaan item mengurangi EXP; `105` kunci kembali pencapaian pengguna; `106` batalkan penyelesaian subtugas. Kode alasan koin menggunakan domain yang sama dengan [catatan inventaris](#get-inventory-records). Pertahankan kode masa depan yang belum dikenal. Untuk perubahan bersih, terapkan arah dengan `isDecrease` (`true` mengurangi jumlah tercatat). Jangan menganggap penurunan dikodekan sebagai `value` negatif; tipe numerik bertanda dan tidak ada jaminan nilai tak bertanda/absolut.

`value` EXP berlaku per atribut. Jangan menjumlahkan `totalValue` EXP antarrekaman begitu saja: logika batch beberapa atribut saat ini dapat menyimpan total yang tumpang tindih ketika melibatkan lebih dari tiga atribut. Misalnya, perubahan 10 EXP masing-masing untuk empat atribut dapat menghasilkan total tersimpan 40 dan 10, sehingga tidak aman menjumlahkannya sebagai total 40. Cocokkan `value` per atribut dengan atribut yang tercantum pada setiap rekaman untuk laporan presisi; keterkaitan yang hilang membatasi apa yang dapat dipastikan. Jangan menjumlahkan `value` dan `totalValue`, dan jangan menyebut `totalValue` EXP sebagai saldo.

Untuk satu hari kalender, hitung `dayStart` dan `nextDayStart` lokal, lalu minta `[dayStart, nextDayStart - 1]` karena kedua batas inklusif. Pilih kode alasan jika melaporkan hanya hadiah tugas; biarkan tanpa filter alasan jika melaporkan semua perubahan tercatat. [Prosedur laporan harian](/guide/api-reference?id=daily-report).

### Referensi implementasi :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Penerusan parameter tanggal](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Item dan kategori :id=get-items

`GET /items` mengembalikan `ShopItem[]`. Parameter kueri opsional berulang `id` memilih ID item: `/items?id=1&id=2`. Nilai bukan bilangan bulat dibuang. ID yang tidak ditemukan dilewati; ID valid mempertahankan urutan permintaan, termasuk duplikat. Jika semua ID yang diberikan tidak valid, SDK tidak mengirim filter ID dan hasilnya adalah daftar item normal. Tidak ada paginasi.

`GET /items/{listId}` mengembalikan `ShopItem[]` dalam **kategori**, bukan satu item. `listId` adalah ID kategori bertanda 64-bit; `-1` berarti semua. Nilai jalur tidak valid kembali ke semua. Daftar normal mengecualikan item tidak ditampilkan/dihapus (`isDel=0`) dan mengikuti pengurutan toko/kategori yang dikonfigurasi. Pemilihan ID dapat mengambil item secara terpisah dari filter daftar normal tersebut.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID item. |
| `name` | string | Nama item. |
| `desc` | string | Deskripsi. |
| `icon` | string | URI gambar yang dapat dibaca, atau string kosong. Unduh melalui `/files/{url}`. |
| `categoryId` | integer | ID kategori toko. |
| `stockNumber` | integer | Stok tersedia; stok negatif dianggap tak terbatas saat menghitung `maxPurchaseNumber`. |
| `ownNumber` | integer | Jumlah yang dimiliki dalam inventaris. |
| `price` | integer | Harga koin. |
| `order` | integer | Urutan tersimpan dalam kategorinya. |
| `disablePurchase` | boolean | Penanda pembelian dinonaktifkan. |
| `maxPurchaseNumber` | bilangan bulat atau null | Dihitung dari koin tersedia ditambah kredit dan stok terbatas; pembelian nonaktif menghasilkan 0, stok gratis tak terbatas dapat menghasilkan 2147483647. Perhitungan ini tidak mengevaluasi semua aturan batas pembelian. |
| `titleColorString` | string atau null | Warna judul kustom. |
| `actionText` | string atau null | Teks tombol penggunaan kustom. |
| `unlist` | boolean | Penanda tidak ditampilkan/dihapus; biasanya false pada hasil daftar. |
| `disableUse` | boolean | Apakah item memiliki efek tidak dapat digunakan. |
| `purchaseLimit` | string atau null | **String berformat JSON**, bukan array bertingkat; konfigurasi batas pembelian item. |
| `limitScope` | string atau null | `purchase`, `use`, atau `both`. |

### GET /items_categories :id=get-items-categories

Mengembalikan `ShopCategory[]`. `include_hidden` opsional bernilai awal `false`; hanya string huruf kecil persis `true` dan `false` yang diparsing, nilai lain menjadi false. Mencakup kategori virtual semua. Server HTTP tidak menyediakan `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID kategori. |
| `name` | string | Nama kategori. |
| `isAsc` | boolean | Penanda pengurutan menaik yang dikonfigurasi. |
| `sort` | string | Preferensi pengurutan tersimpan. |
| `order` | integer | Urutan kategori. |
| `hidden` | boolean | Tersembunyi di toko. |
| `inventoryHidden` | boolean | Tersembunyi dalam inventaris. |

### GET /tasks_categories :id=get-tasks-categories

Mengembalikan `TaskCategory[]`, termasuk kategori semua dan kategori arsip. Tanpa parameter kueri atau paginasi. Server HTTP tidak menyediakan `/tasks_categories/{id}`. Nilai pengurutan/filter kategori adalah preferensi app tersimpan; endpoint ini tidak menerapkannya sebagai filter permintaan.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID kategori. |
| `name` | string | Nama. |
| `isAsc` | boolean | Penanda pengurutan menaik tersimpan. |
| `sort` | string | Preferensi pengurutan tersimpan. |
| `filter` | string | Preferensi pengelompokan/filter tersimpan. |
| `order` | integer | Urutan kategori. |
| `status` | integer | 0 normal; 1 diarsipkan. |
| `type` | integer | 0 normal; daftar pintar menggunakan 10 harian, 11 mingguan, 12 bulanan, 20 sedang dikerjakan. |

## Atribut dan grup atribut :id=get-skills

`GET /skills` mengembalikan `Skill[]`, tanpa parameter atau paginasi. Atribut tersembunyi/dihapus dikecualikan dan urutan tersimpan digunakan. `group_id` dan `status` dari ContentProvider dasar **bukan** kolom model HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID atribut. |
| `name` | string | Nama atribut yang dilokalkan. |
| `desc` | string | Deskripsi. |
| `icon` | string | URI ikon yang dapat dibaca, atau kosong. |
| `order` | integer | Urutan tersimpan. |
| `color` | integer | Bilangan bulat warna terkemas Android. |
| `exp` | integer | Total EXP saat ini. |
| `level` | integer | Level saat ini. |
| `untilNextLevelExp` | integer | EXP tersisa menuju level berikutnya. |
| `currentLevelExp` | integer | EXP yang diperoleh sejak level saat ini dimulai. |
| `type` | integer | 0 pengguna; 1 kekuatan; 2 pembelajaran; 3 pesona; 4 ketahanan; 5 vitalitas; 6 kreativitas. |

### GET /skill_groups :id=get-skill-groups

Mengembalikan `SkillGroup[]`. `include_hidden` menggunakan parsing Boolean ketat yang sama dengan `/items_categories`, nilai awal false. Repositori app saat ini mengabaikan penanda ini untuk grup dan selalu mengecualikan grup yang dihapus. Urutan tersimpan menaik. Tanpa paginasi.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID grup. |
| `content` | string | Judul grup. |
| `order` | integer | Urutan grup tersimpan. |
| `collapsed` | boolean | Status diciutkan. |

## Pencapaian :id=get-achievements

`GET /achievements` mengembalikan `Achievement[]` dengan memuat setiap kategori menurut urutan kategori dan menggabungkan pencapaiannya. `GET /achievements/{id}` mengembalikan pencapaian **dalam kategori `id`**, bukan detail satu pencapaian. ID jalur tidak valid berperilaku seperti rute tanpa filter. Pengurutan dalam tiap kategori mengikuti preferensi pengurutan kategori dalam app. Kedua endpoint tidak berhalaman.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID pencapaian. |
| `name` | string | Judul. |
| `desc` | string | Deskripsi. |
| `iconUri` | string | URI ikon atau kosong. |
| `categoryId` | integer | ID kategori. |
| `status` | integer | 0 belum selesai; 1 selesai dengan hadiah belum diklaim; 2 hadiah diklaim/status selesai lainnya. |
| `exp` | integer | Hadiah EXP. |
| `coin` | integer | Hadiah koin. |
| `coinVariable` | integer | Hadiah koin variabel. |
| `type` | integer | 0 pencapaian; 1 judul subkategori. |
| `progress` | integer | Progres tersimpan. |
| `order` | integer | Urutan dalam kategori. |
| `itemId` | bilangan bulat atau null | ID item hadiah pertama (kolom kemudahan lama). |
| `itemAmount` | bilangan bulat atau null | Jumlah item hadiah pertama. |
| `unlockedTime` | bilangan bulat atau null | Waktu Unix pembukaan dalam milidetik. |
| `items` | RewardItem[] atau null | Daftar lengkap item hadiah; parser saat ini menyediakan array kosong untuk JSON item yang tidak ada/rusak. |
| `color` | string atau null | Warna judul kustom. |

Item hadiah menggunakan model bersama [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Mengembalikan `AchievementCategory[]`, tanpa parameter atau paginasi. Server HTTP tidak menyediakan `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID kategori. |
| `name` | string | Nama. |
| `desc` | string | Deskripsi. |
| `iconUri` | string | URI/string ikon. |
| `isAsc` | boolean | Penanda pengurutan menaik. |
| `sort` | string | Preferensi pengurutan tersimpan. |
| `filter` | string | Preferensi pengelompokan/filter tersimpan. |
| `order` | integer | Urutan kategori. |
| `type` | integer | 0 pencapaian pengguna; 1 pencapaian sistem. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Mengembalikan `AchievementCondition[]` untuk ID **pencapaian** `id`. ID bukan bilangan bulat mengembalikan pembungkus kesalahan berkode 500. Jika tidak ada kondisi cocok, hasilnya array kosong. Tidak ada rute koleksi `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID kondisi. |
| `type` | integer | Kode kondisi; lihat di bawah. |
| `relatedId` | integer | Pengenal tugas/item/atribut terkait sesuai kondisi. |
| `target` | integer | Nilai target. |
| `current` | integer | Nilai akumulasi saat ini. |
| `progress` | integer | Progres tersimpan. |

Kode kondisi: 0 penyelesaian tugas; 1 rentetan tugas saat ini; 2 level atribut lama; 3 tomat; 4 hari penggunaan app; 5 suka; 6 hari penyelesaian berturut-turut; 7 koin saat ini; 8 koin diperoleh dalam sehari; 9 tomat tugas; 10 pembelian item; 11 penggunaan item; 12 item diperoleh dari kotak hadiah; 13 level atribut; 14 level kehidupan; 15 akumulasi item diperoleh; 16 item diperoleh dari sintesis; 17 jumlah item yang dimiliki saat ini; 18 waktu fokus tugas; 19 tabungan ATM; 20 API eksternal. Kondisi berulang: 500 penyelesaian tugas; 501 kenaikan level atribut; 502 tomat; 503 koin; 504 item diperoleh; 505 pembelian item; 506 perolehan kotak hadiah; 507 perolehan sintesis; 508 penggunaan item; 509 menit fokus tugas; 510 tomat tugas; 511 suka; 512 kenaikan tabungan ATM; 513 panggilan API eksternal; 514 hari penggunaan; 515 kenaikan level kehidupan; 516 koin harian; 517 penyelesaian tugas berturut-turut; 518 tomat harian; 519 menit fokus harian; 520 grup tugas berbeda per hari; 521 penggunaan item harian; 522 pembelian item harian; 523 penyelesaian harian tugas tertentu; 524 total catatan penyelesaian tugas harian. Ini adalah kode bilangan bulat mentah, bukan nama enum terserialisasi.

## Sintesis :id=get-synthesis

`GET /synthesis` mengembalikan `Synthesis[]` dari kategori terlihat. `GET /synthesis/{id}` mengembalikan resep **dalam kategori `id`**, termasuk konten tersembunyi kategori itu. ID nonnegatif memilih kategori; ID negatif berarti semua kategori terlihat. ID tidak valid kembali ke rute koleksi. Hasil mengikuti urutan resep tersimpan secara menaik; resep dihapus dikecualikan. Tanpa paginasi.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID resep. |
| `name` | string | Nama. |
| `desc` | string | Deskripsi. |
| `input` | SynthesisItemInfo[] | Item yang diperlukan. |
| `output` | SynthesisItemInfo[] | Item yang dihasilkan. |
| `categoryId` | bilangan bulat atau null | ID kategori. |
| `canSynthesisTimes` | integer | Jumlah sintesis yang tersedia saat ini. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `itemId` | integer | ID item. |
| `itemName` | string | Nama item. |
| `amount` | integer | Jumlah masukan/keluaran per sintesis. |
| `ownedNumber` | integer | Jumlah yang dimiliki. |
| `icon` | string | URI ikon yang dapat dibaca atau kosong. |

### GET /synthesis_categories dan /synthesis_categories/{id} :id=get-synthesis-categories

Keduanya mengembalikan `SynthesisCategory[]`. `id` jalur opsional memfilter ID kategori; tidak mengubah bentuk array. ID tidak valid kembali ke semua kategori. `include_hidden` opsional menggunakan parsing Boolean huruf kecil ketat dan nilai awal false, termasuk jika ID kategori diberikan. Tanpa paginasi.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID kategori. |
| `name` | string | Nama. |
| `isAsc` | boolean | Penanda pengurutan menaik tersimpan. |
| `sort` | string | Preferensi pengurutan tersimpan. |
| `order` | integer | Urutan kategori. |
| `hidden` | boolean | Penanda tersembunyi. |

## Perasaan :id=get-feelings

`GET /feelings` mengembalikan `Feelings[]`. Kueri `offset` bernilai awal 0 dan `limit` 100; nilai hilang atau bukan bilangan bulat menggunakan nilai awal tersebut. Endpoint ini tidak memiliki pembatasan eksplisit. Gunakan offset nonnegatif dan limit positif. Perasaan dihapus dikecualikan. Pengurutan mengikuti preferensi urutan perasaan app (`createTime` menaik atau menurun), bukan parameter permintaan. Tidak tersedia filter waktu.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID perasaan. |
| `content` | string | Teks. |
| `isFav` | boolean | Penanda favorit. |
| `title` | string | Judul terkait. |
| `time` | integer | Waktu Unix pembuatan dalam milidetik. |
| `attachments` | string[] | URI lampiran yang dapat dibaca untuk file yang ada dan tidak kosong. |
| `type` | integer | 0 tugas; 1 pencapaian; 2 entri mandiri. |

## Catatan Pomodoro :id=get-pomodoro-records

`GET /pomodoro_records` mengembalikan `PomodoroRecord[]`. Nilai awal `offset` 0 dan `limit` 100; tanpa pembatasan eksplisit. `time_range_start` dan `time_range_end` opsional menggunakan milidetik Unix. SDK hanya meneruskan rentang jika keduanya dapat diparsing sebagai bilangan bulat 64-bit dan awal lebih kecil dari akhir; jika tidak, rentang diabaikan tanpa pesan.

Tanpa rentang, catatan selesai dan tidak dihapus dengan `startTime != endTime` serta `endTime` positif dikembalikan menurut `endTime DESC, startTime DESC, id DESC`. Rentang valid memilih `start < endTime <= end` dan mengecualikan baris dihapus.

> [!WARNING]
> Implementasi sebelumnya meneruskan `limit` dan `offset` ke DAO dalam posisi terbalik untuk kueri rentang tanggal dan tidak menentukan urutan. Sumber LifeUp lokal kini memakai argumen bernama dan mengurutkan hasil berhalaman menurut `endTime DESC, startTime DESC, id DESC`; perbaikan lokal ini belum dirilis. Sampai Anda memastikan versi LifeUp yang terpasang sudah memuatnya, hilangkan rentang dan filter hasil di klien agar paginasi andal.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID catatan. |
| `startTime` | bilangan bulat atau null | Waktu Unix mulai dalam milidetik. |
| `endTime` | bilangan bulat atau null | Waktu Unix akhir dalam milidetik. |
| `duration` | integer | Milidetik: `lastTime` tersimpan yang bukan nol, jika tidak akhir dikurangi mulai. |
| `reward` | angka | Jumlah tomat diperoleh: ditinggalkan = 0; setengah = 0.5 × pengali; selain itu pengali. |

## Catatan inventaris :id=get-inventory-records

`GET /inventory_records` mengembalikan `InventoryRecord[]`. Nilai awal `offset` 0 dan dibatasi minimal 0; nilai awal `limit` 100 dan dibatasi 1–200. `time_range_start` dan `time_range_end` opsional hanya diteruskan jika keduanya bilangan bulat 64-bit dan awal < akhir; rentang tidak valid/tidak lengkap diabaikan SDK tanpa pesan. Rentang valid memakai batas inklusif `time >= start AND time <= end`. Catatan dihapus dikecualikan (`isDel` null atau 0); urutan `time DESC, id DESC`. Tidak tersedia filter ID item.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID catatan. |
| `time` | bilangan bulat atau null | Waktu Unix pembuatan dalam milidetik. |
| `itemId` | bilangan bulat atau null | ID item terkait. |
| `itemName` | string atau null | Nama item terkait jika tersedia. |
| `changeNumber` | integer | Perubahan jumlah tercatat. |
| `isDecrease` | boolean | Apakah perubahan mengurangi inventaris. |
| `resCode` | integer | Kode alasan sumber; lihat di bawah. |
| `desc` | string atau null | Deskripsi catatan. |

Kode alasan: 0 pembelian; 1 penggunaan; 2 penyelesaian tugas; 3 batalkan penyelesaian; 4 hapus data; 5 tinggalkan tugas; 6 tugas lewat tenggat; 7 buka pencapaian bawaan; 8 batalkan penyerahan tugas; 9 batalkan lewat tenggat; 10 kembalikan item; 11 penyelesaian subtugas; 12 batalkan penyelesaian subtugas; 13 buka pencapaian pengguna; 14 batalkan pembukaan pencapaian pengguna; 15 setoran; 16 penarikan; 17 penjualan tomat; 20 hadiah item; 21 batalkan hadiah; 23 sintesis; 24 kotak hadiah; 25 bunga ATM; 26 tukar tomat dengan item; 27 bunga kredit; 28 API; 29 perubahan stok efek item. Klien harus mempertahankan kode masa depan yang belum dikenal.

## Catatan langkah :id=get-step-records

`GET /step_records` mengembalikan `StepRecord[]`. Nilai awal/batas paginasi dan aturan pengabaian rentang SDK sama dengan `/inventory_records`. Filter waktu valid bersifat inklusif pada `date`; urutan `date DESC` tanpa kunci sekunder eksplisit.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID catatan. |
| `date` | bilangan bulat atau null | Tanggal tercatat dalam milidetik Unix. |
| `dailyStepCount` | integer | Jumlah langkah harian. |
| `totalStepCount` | integer | Jumlah langkah kumulatif tersimpan. |
| `isGotReward` | boolean | Penanda hadiah diklaim. |
| `isUserInput` | boolean | Penanda dimasukkan pengguna. |
| `rewardLevel` | bilangan bulat atau null | Level hadiah tersimpan. |

## Definisi level :id=get-level-defines

`GET /level_defines` mengembalikan satu objek `LevelDefines`. Tanpa parameter. Menggunakan definisi kustom jika mode level kustom aktif, jika tidak definisi bawaan.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `custom` | boolean | Mode level kustom. |
| `levels` | LevelDefine[] | Rentang level. |

### LevelDefine :id=model-level-define

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | bilangan bulat atau null | ID definisi. |
| `levelStart` | integer | Level awal. |
| `levelEnd` | integer | Level akhir. |
| `perLevelExp` | integer | EXP yang diperlukan per level dalam rentang. |

JSON level yang rusak saat ini menjadi array `levels` kosong, alih-alih menggagalkan seluruh permintaan.

## Statistik :id=get-statistics

`GET /statistics` mengembalikan satu objek `Statistics`. `time_range_start` dan `time_range_end` opsional memakai milidetik Unix dan aturan penerusan SDK yang sama: keduanya valid dan awal < akhir, jika tidak rentang tidak dikirim. Tanpa rentang, app memakai stempel waktu pertama yang tercatat hingga sekarang; jika tidak ada, memakai 30 hari terakhir. `usingDays` dan `companionDays` adalah nilai sepanjang waktu meskipun rentang diberikan. Metrik lain dihitung oleh metode statistik app masing-masing; jangan menganggap semua kueri metrik dasar memiliki aturan inklusi batas endpoint yang sama.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `start` | bilangan bulat atau null | Awal rentang efektif dalam milidetik Unix. |
| `end` | bilangan bulat atau null | Akhir rentang efektif dalam milidetik Unix. |
| `tomatoes` | integer | Statistik tomat diperoleh. |
| `pomodoroMinutes` | integer | Durasi fokus dalam menit. |
| `focusCount` | integer | Jumlah sesi fokus. |
| `tasksCompleted` | integer | Jumlah tugas selesai yang digunakan statistik penyelesaian. |
| `tasksTotal` | integer | Jumlah total tugas yang digunakan statistik tersebut. |
| `taskCompleteRate` | angka | Rasio penyelesaian. |
| `feelingsCount` | integer | Jumlah perasaan. |
| `usingDays` | integer | Hari penggunaan sepanjang waktu. |
| `companionDays` | integer | Hari pendampingan sepanjang waktu. |
| `interestChanged` | integer | Statistik perubahan koin bunga. |
| `coinPurchaseConsumed` | integer | Statistik konsumsi koin pembelian. |

## Informasi app dan saldo koin :id=get-info

`GET /info` mengembalikan `Info`. LifeUp Cloud menambahkan versi terpasangnya sendiri ke informasi app/penyedia. Tanpa parameter.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `appVersion` | integer | Kode versi LifeUp terpasang. |
| `appVersionName` | string | Nama versi LifeUp terpasang. |
| `apiVersion` | integer | Versi API LifeUp. |
| `cloudVersion` | integer | Kode versi LifeUp Cloud terpasang. |
| `cloudVersionName` | string | Nama versi LifeUp Cloud terpasang. |

### GET /coin :id=get-coin

Memanggil `lifeup://api/query?key=coin` melalui ContentProvider dan mengembalikan objek hasilnya. Tanpa parameter. Hasil penyedia null menjadi objek kosong. Kolom ditentukan penyedia, bukan respons bertipe `CoinData`. Kueri berhasil menyediakan `value` (saldo koin bilangan bulat bertanda 64-bit) dan `api_result: true`; kegagalan dapat menyediakan kolom status/kesalahan penyedia yang dijelaskan di bawah.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Memanggil API URL Scheme :id=invoke-api

[Katalog API URL Scheme](/guide/api) menentukan nama metode, parameter metode, dan hasil khusus metode. Jembatan HTTP menerima URL lengkap `lifeup://api/...`.

| Transportasi | Masukan | Eksekusi dan respons |
| --- | --- | --- |
| `GET /api` | Kueri `url` berulang yang dikodekan URL | Memulai activity Android untuk setiap URL sesuai urutan. Mengembalikan string `success`. URL yang tidak diberikan juga mengembalikan sukses. |
| `POST /api` | JSON `RawQueryVo` | Memulai semua entri `urls` dahulu, lalu `url` jika ada. Mengembalikan string `success`. Objek masukan kosong juga berhasil. |
| `GET /api/contentprovider` | Kueri `url` berulang yang dikodekan URL | Memanggil penyedia secara sinkron dan mengembalikan `CallUrlResult[]` sesuai urutan. URL yang tidak diberikan mengembalikan pembungkus kesalahan (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Memanggil semua entri `urls` dahulu, lalu `url`; mengembalikan `CallUrlResult[]`. Objek kosong mengembalikan array kosong. |

Atur `Content-Type: application/json` untuk POST JSON. Kodekan seluruh URL saat menyematkannya dalam kueri GET, dengan mempertahankan `&`, `?`, `+` internal dan pengodean persen. Respons jembatan activity yang berhasil mengonfirmasi pengiriman, bukan penyelesaian aksi LifeUp. Metode ContentProvider memerlukan izin Cloud dalam LifeUp dan dukungan bergantung pada metode URL Scheme. Panggilan berurutan; jika panggilan berikutnya melempar kesalahan, efek sebelumnya tidak dibatalkan.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Respons jembatan activity:

```json
{"code":200,"message":"success","data":"success"}
```

Respons jembatan penyedia (contoh hasil penyedia):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `url` | string atau null | Satu URL opsional. |
| `urls` | string[] atau null | Daftar URL opsional; diproses sebelum `url`. |

### CallUrlResult :id=model-call-url-result

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `url` | string | URL yang dikirim. |
| `result` | objek atau null | Bundle penyedia yang dikonversi; null sendiri tidak menyebabkan pembungkus HTTP gagal. |

Konversi Bundle mempertahankan nilai Int/Long/Double/String/Boolean dan Bundle bertingkat. Array menjadi array string. Tipe nilai lain menjadi string `toString()` (termasuk nilai null Bundle menjadi string `"null"`). Kolom kegagalan metode dalam `result` harus diperiksa meskipun pembungkus luar berkode 200.

Penangan metode LifeUp saat ini menambahkan `api_result` (boolean) pada panggilan selesai. Kegagalan metode yang tertangkap mengembalikan `api_result: false`, `error_code` (string), dan `error_message` (string). Kode mencakup `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled`, dan `internal_error`; metode tertentu dapat menyediakan kode tambahan. Saat pemulihan cadangan, penyedia dapat mengembalikan `error_code: "503"` dan `error_message` tanpa `api_result`. Penangan API yang tidak ada dapat melempar sebelum konversi kesalahan metode ini sehingga menghasilkan kesalahan jembatan luar.

## Membaca dan mengunggah file :id=files-download

### GET /files/{url} :id=files-get

Kodekan URI lengkap yang dapat dibaca sebagai satu segmen jalur. Ini membaca byte melalui content resolver Android, biasanya untuk ikon, lampiran perasaan, ekspor cadangan, atau file unggahan. Hasilnya aliran byte, bukan pembungkus JSON sukses. Rute tidak menentukan nama file atau tipe MIME. Aliran resolver kosong/tidak terbaca tidak dikonversi menjadi hasil tidak ditemukan terstruktur; kegagalan yang dilempar menggunakan penangan HTTP 500 global. Parameter cocok yang kosong menghasilkan pembungkus kesalahan (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Kirim `multipart/form-data`. Setiap bagian file diterima tanpa melihat nama kolom; bagian form bukan file diabaikan. Nama file asli digunakan untuk file cache; jika tidak ada, Cloud memilih `uploaded_image_<time>.jpg`. Mengembalikan array string URI konten yang dapat dibaca. Unggahan menyediakan URI file untuk panggilan API berikutnya; tidak otomatis melampirkannya ke item atau tugas. Tanpa file, hasilnya pembungkus kesalahan `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Ekspor dan impor cadangan :id=files-backup

### GET /data/export :id=files-export

Memicu pembuatan cadangan melalui penyedia. Kueri `withMedia` opsional bernilai awal `true`; jika ada, `true` tanpa membedakan kapital berarti benar, nilai lain berarti salah. Mengembalikan Bundle penyedia yang dikonversi, saat ini berisi `backup_file_uri`; gunakan `/files/{url}` untuk mengunduh URI itu. Endpoint ini membuat ekspor meskipun metodenya GET. Kolom status/kesalahan API penyedia mungkin ada dan harus diperiksa. `backup_file_uri` kosong berarti ekspor tidak menghasilkan file yang dapat digunakan. Hasil null menjadi kesalahan.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Kirim `multipart/form-data` dengan file cadangan. Jika beberapa file diberikan, bagian file terakhir digunakan; nama kolomnya tidak diperiksa. Nama file awal `backup.lfbak`. Kolom form opsional `description` dibaca tetapi tidak berpengaruh. Cloud menyimpan file dalam cache dan meluncurkan activity cadangan LifeUp; respons mengonfirmasi unggahan dan peluncuran activity, **bukan pemulihan selesai**. Tanpa file mengembalikan `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Peristiwa :id=get-events

### GET /events :id=get-events-poll

Mengembalikan `EventsPage`. `after` adalah kursor ID peristiwa eksklusif (bilangan bulat 64-bit, nilai awal 0). `limit` bilangan bulat dengan nilai awal 50, dibatasi 1–200. Nilai bukan bilangan bulat memakai nilai awal. Peristiwa diurutkan dari terlama dalam buffer tersimpan, dengan `id > after`. Maksimal 200 peristiwa disimpan dalam memori; yang lama dibuang dan restart proses mereset ID. `latestId` adalah ID global terbaru tersedia, belum tentu peristiwa terakhir pada halaman terbatas. Lanjutkan dari peristiwa terakhir yang benar-benar diproses agar tidak melewati antrean. Tidak tersedia riwayat persisten atau konfirmasi pengiriman.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `latestId` | integer | ID peristiwa terbaru saat ini. |
| `eventWs` | boolean | Pengaturan WebSocket Cloud. |
| `events` | CloudEvent[] | Peristiwa tersimpan setelah kursor. |
| `broadcasts` | boolean atau null | Apakah siaran LifeUp diaktifkan; null berarti tidak diketahui atau tidak didukung. Status kueri di-cache selama lima detik. |

### CloudEvent :id=model-cloud-event

| Kolom | Tipe JSON | Arti |
| --- | --- | --- |
| `id` | integer | ID urutan peristiwa dalam memori. |
| `time` | integer | Waktu Unix penerimaan Cloud dalam milidetik. |
| `action` | string | Aksi siaran Android. |
| `extras` | objek dengan nilai string | Ekstra siaran dikonversi dengan `toString()`; null menjadi string kosong. Kunci bergantung pada aksi. |

### WebSocket /events :id=get-events-websocket

Saat `eventWs` true, hubungkan ke `ws://HOST:PORT/events?after=ID` (dan berikan token terkonfigurasi). Server memutar ulang peristiwa tersimpan setelah `after`, lalu mengirim peristiwa langsung sebagai frame teks JSON `CloudEvent` satu per satu, **tanpa** pembungkus respons HTTP. Pemutaran ulang dibatasi buffer memori 200 peristiwa; tidak ada parameter WebSocket `limit`. Server mengirim frame Ping setiap 30 detik. Hubungkan kembali dengan ID peristiwa terakhir yang benar-benar diproses. Jika nonaktif, rute WebSocket tidak didaftarkan; polling HTTP tetap tersedia.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Langganan aksi yang didukung adalah `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause` dan `app.lifeup.timing.abandon`. Pengumpulan peristiwa memerlukan siaran LifeUp aktif. Polling `/events` memeriksa pengaturan tersebut; tidak mengaktifkannya secara otomatis.

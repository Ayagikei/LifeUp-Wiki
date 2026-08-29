## Kontribusi Komunitas 🤝

Kami sangat berterima kasih kepada komunitas yang membangun alat untuk memperluas kemampuan LifeUp. Di bawah ini adalah toolkit resmi dan proyek komunitas unggulan.

## Toolkit resmi

| Proyek | Deskripsi |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Jembatan HTTP API di sisi ponsel; akses LAN dan **pemindaian QR** (`lifeup://`, URL web, skema app lain) |
| [@lifeup/mcp](guide/api_mcp.md) | Server MCP resmi + Skills untuk Cursor, Claude Desktop, dan agent AI lain via LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Klien desktop resmi yang dibangun di atas HTTP LifeUp Cloud |
| [Demo integrasi Wordle](example/wordle/index.html) | Mini-game tebak kata; memanggil `lifeup://api/reward` saat menang |

**Pengaturan Wordle:** Buat Item di Toko → tambahkan efek tautan tipe-9 yang mengarah ke halaman Wordle → **Use** membuka game di browser; menang memberi 10 koin, kalah tetap dapat koin hiburan. Anda juga dapat mengodekan URL Wordle sebagai kode QR dan memindainya dengan LifeUp Cloud. Lihat [API · Web eksternal (Wordle)](guide/api.md).

<br/>

## Proyek komunitas

| Proyek | Deskripsi | Penulis |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Server MCP komunitas awal (digantikan oleh `@lifeup/mcp` resmi). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Plugin Obsidian ↔ LifeUp: sinkronisasi to-do, sinkronisasi refleksi, dashboard data LifeUp di Obsidian. *Catatan: repo hanya bahasa Tionghoa.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Membuat sesuatu yang menarik?** Jika Anda mengembangkan alat, skrip, atau integrasi untuk LifeUp, beri tahu kami via GitHub Issues atau email!

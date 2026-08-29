<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud ist eines der zentralen API-Toolkits für LifeUp. Es macht dein Telefon zu einer **API-Brücke**: LifeUp vom **Computer oder anderen Geräten** steuern, **eigene Integrationen** bauen (Desktop, Web, Automatisierungsskripte) oder mit **KI-Agenten** koppeln.

### Typische Szenarien

| Szenario | Zielgruppe | In einem Satz | Mehr erfahren |
| --- | --- | --- | --- |
| **HTTP + selbst bauen** | Entwickler, Automatisierungsnutzer | APIs und Daten per Python, Web-Apps oder Skripten über LAN abfragen — keine Android-Erfahrung nötig | [HTTP API](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **QR-Scan** | Real-World-Check-in-Fans | QR-Codes drucken, um Aufgaben zu erledigen, Timer zu starten, Dialoge zu öffnen oder Webseiten / andere Apps zu starten | [QR-Code-Scan](#qr-code-scanning) |
| **Start-/Stopp-Kürzel** | Automatisierung, NFC, Tasker | `lifeupcloud://start` und `lifeupcloud://stop` öffnen Cloud und starten oder stoppen den HTTP-Server | [Start und Stopp](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude usw. | Ein Prompt für Aufgabenlisten, Shop-Gegenstände, Erfolge und mehr | [MCP & Skills](guide/api_mcp.md) |
> **Beispiel-KI-Prompt:** Lösche die Beispiel-Aufgaben und Shop-Gegenstände, dann erstelle ein vollständiges Indie-Game-Developer-Setup: Aufgabenlisten, Attribute, Shop-Gegenstände und Erfolge.

<br/>

## Download

- Bei der Festland-China-Mitgliedschaft findest du den LifeUp-Cloud-Download unter `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud-Dienst starten und stoppen :id=cloud-scheme

Du kannst den HTTP-Server starten oder stoppen, ohne **Start Service** zu tippen — mit diesen URL-Schemes:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Beide URLs starten LifeUp Cloud und führen die Aktion aus. Nutze sie als Homescreen-Kürzel, NFC-Tag, Tasker-/Automatisierungsaktion oder:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Die gleichen URLs stehen auf der Cloud-Statuskarte — tippen zum Kopieren.

> [!NOTE]
> `lifeupcloud://` steuert den Cloud-HTTP-Server selbst. Es ist keine `lifeup://api/…`-Spiel-API.

<br/>

## QR-Code-Scan :id=qr-code-scanning

Der **Scan**-Button oben in LifeUp Cloud liest die im QR-Code kodierte URL und öffnet sie sofort — ohne manuelle Eingabe.

Scannen ist **nicht auf LifeUp-APIs beschränkt**: `lifeup://api/…`, Webseiten `https://…` und andere App-URL-Schemes (z. B. `weixin://`) funktionieren — Android öffnet das passende Ziel.

### Nutzung

1. Wähle eine URL aus LifeUp oder der Wiki-[API-Liste](guide/api.md) (Aufgabe erledigen, Pomodoro starten, Kauf-/Nutzungsdialoge öffnen oder externe Webseite öffnen).

2. Erzeuge einen QR-Code aus der vollen URL (drucken und an Schreibtisch, Wand oder Gerät kleben).

3. LifeUp Cloud öffnen, **Scan** tippen (**?** daneben für kurze In-App-Anleitung), auf den Code richten.

### Mögliche Aktionen

| Szenario | Beispiel (illustrativ) |
| --- | --- |
| Pomodoro-Check-in | `lifeup://api/pomodoro?...` Timer starten/stoppen |
| Aufgaben-Check-in | `lifeup://api/complete?name=...` Aufgabe erledigen |
| Shop-Interaktion | `lifeup://api/goto?page=shop` oder Kauf-/Nutzungsdialoge |
| Belohnung / Strafe | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web-Minispiel | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Andere Apps | `weixin://`, `intent://` oder Scheme einer installierten App |
| Eigene Abläufe | Jede scannbare URL-Kombination |

### Interaktion in der realen Welt

QR-Codes verknüpfen **physische Orte oder Handlungen** mit In-App-Gamification:

- **Fitnessgerät**-Aufkleber → scannen, um Krafttraining-Aufgabe zu erledigen

- **Lernschreibtisch**-Aufkleber → scannen, um Fokus-Pomodoro zu starten

- **Arbeitsplatz**-Aufkleber → scannen, um Stand-up oder Code-Review zu protokollieren

- **Event-Board**-Aufkleber → scannen, um Belohnung abzuholen oder Erfolg zu öffnen

Kurz: **URL Schemes in scannbare physische Trigger verwandeln**, LifeUp Cloud als Ausführer zwischen App und Realität.

<br/>

> [!NOTE]
> LifeUp Cloud ist eine rein LAN-basierte HTTP-Brücke. Wie du dein Telefon erreichst — IP-Adresse, Router, Firewall, gleiches Subnetz, VPN oder AP-Isolation — hängt von deinem Heimnetz ab. Bei Verbindungsproblemen können wir dein persönliches LAN nicht debuggen. Prüfe dein Netzwerk selbst, nutze Standard-Netzwerk-Tools oder bitte einen KI-Agenten um Hilfe.

## HTTP-API-Definition :id=http-api-definition

> [!WARNING]
> API-Docs auf dieser Seite können hinter Implementierungs-Updates zurückliegen. Maßgeblich ist der Quellcode: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. URL-Scheme-Aufruf-API

#### GET

Funktion:

> APIs aufrufen, die mit `lifeup://api` beginnen.

Request-URL:

```txt
// Empfohlen: Content-Provider-Modus (bessere Kompatibilität)
http://{host:port}/api/contentprovider

// startActivity-Modus (manche Geräte blockieren Hintergrund-UI)
http://{host:port}/api
```

**Method: `GET`**

**Query-Parameter:**

| Feld | Beschreibung | Ort | Typ | Pflicht | Hinweise |
| --- | --- | --- | --- | --- | --- |
| url | API-URL, beginnt mit `lifeup://api` | Query | string | Ja | Bei manueller Erstellung URL-kodieren. Mehrere `url`-Parameter möglich. |

**Request-Beispiele:**

```txt
// Einzelaufruf (Content Provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Batch-Aufruf
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Einzelaufruf (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Funktion:

> APIs aufrufen, die mit `lifeup://api` beginnen.

Request-URL:

```txt
// Empfohlen: Content-Provider-Modus (bessere Kompatibilität)
http://{host:port}/api/contentprovider

// startActivity-Modus (manche Geräte blockieren Hintergrund-UI)
http://{host:port}/api
```

**Method: `POST`**

**JSON-Body-Parameter:**

| Feld | Beschreibung | Ort | Typ | Pflicht | Hinweise |
| --- | --- | --- | --- | --- | --- |
| urls | Array von URLs, beginnend mit `lifeup://api` | Body | List<string> | Ja | Im JSON-Body keine extra URL-Kodierung nötig. |

**Request-Beispiel:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. Datenabfrage-APIs

> [!NOTE]
> Voraussetzungen:
> 1. LifeUp v1.91+ und neuestes LifeUp Cloud.
> 2. Berechtigung **Read LifeUp Data** in LifeUp Cloud erteilen.

Funktion:

> Vollständige LifeUp-Datensätze abfragen, z. B. Aufgaben und Gegenstände.

**Aufgaben-Endpunkte**

```txt
// Alle Aufgaben
http://{host:port}/tasks

// Aufgaben in Kategorie/Liste ${id}
http://{host:port}/tasks/${id}

// Verlauf (paginiert)
// gid optional, filtert alle Verlaufseinträge einer wiederholenden Aufgabe
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Aufgaben-Kategorien
http://{host:port}/tasks_categories
```

**Gegenstands-Endpunkte**

```txt
// Alle Gegenstände
http://{host:port}/items

// Gegenstände in Kategorie/Liste ${id}
http://{host:port}/items/${id}

// Gegenstands-Kategorien
http://{host:port}/items_categories

// Versteckte Listen einschließen
http://{host:port}/items_categories?include_hidden=true
```

**Erfolgs-Endpunkte**

```txt
// Alle Erfolge
http://{host:port}/achievements

// Erfolge in Kategorie/Liste ${id}
http://{host:port}/achievements/${id}

// Erfolgs-Kategorien
http://{host:port}/achievement_categories
```

**Gefühle-Endpunkte**

```txt
// Alle Gefühle (paginiert)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Synthese-Kategorie-Endpunkte**

```txt
// Alle Synthese-Kategorien
http://{host:port}/synthesis_categories

// Synthese-Kategorien in Liste ${id}
http://{host:port}/synthesis_categories/${id}
```

**Synthese-Rezept-Endpunkte**

```txt
// Alle Synthese-Rezepte
http://{host:port}/synthesis

// Synthese-Rezepte in Kategorie ${id}
http://{host:port}/synthesis/${id}
```

**Attribut-Endpunkte**

```txt
// Alle Attribute
http://{host:port}/skills
```


**Sonstiges**

```txt
// Münzstand
http://{host:port}/coin

// LifeUp / Cloud Versionen
http://{host:port}/info

// Pomodoro-Einträge (paginiert; optionaler Zeitraum)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Journale (paginiert; optionaler Zeitraum). Soft-gelöschte Zeilen ausgelassen.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Alle Erfolge (implementiert; Kategorie-ID optional)
http://{host:port}/achievements

// Broadcast-Events. LifeUp Labs → Broadcast events standardmäßig aus; Cloud Advanced kann Status anzeigen und aktivieren. GET data.broadcasts ist dieser Schalter (ausgelassen wenn ungelesen). Cloud-WebSocket-Einstellung ist nur Transport.
http://{host:port}/events?after=${id}&limit=50

// WebSocket-Push (standardmäßig an; Cloud-Einstellung WebSocket event push)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` nur Transport OK. `10001` LifeUp läuft nicht oder Read Data nicht erteilt. `10002` ContentProvider-Abfrage fehlgeschlagen.

### Listen-Feldwerte

| Endpunkt | Feld | Werte |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` offen · `1` erledigt · `2` überfällig · `3` aufgegeben |
| `/tasks` | `frequency` | `0` einmal · `1` täglich · `N>1` alle N Tage · `-1` unbegrenzt · `-3` Ebbinghaus · `-4` monatlich · `-5` jährlich |
| `/tasks` | `weekdays` | `1,3,5` (Mo=1 … So=7). Leer wenn kein Wochentagsmodus. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` archiviert |
| `/tasks_categories` | `type` | `<10` normal · `10` täglich · `11` wöchentlich · `12` monatlich · `20` in Bearbeitung |
| `/achievements` | `status` | `0` gesperrt · `1` freigeschaltet, Belohnung ungeholt · `2` freigeschaltet, geholt |
| `/achievements` | `type` | `0` normal · `1` Unterkategorie |
| `/achievement_categories` | `type` | `0` Nutzer · `1` System |
| `/feelings` | `type` | `0` Aufgabe · `1` Erfolg · `2` roh · `3` Gegenstandsnutzung |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` Nutzer · `1` Stärke · `2` Lernen · `3` Charme · `4` Ausdauer · `5` Vitalität · `6` Kreativität |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` sichtbar · `1` versteckt (unabhängige Flags) |
| `/synthesis_categories` | `hidden` | `0` sichtbar · `1` versteckt |
| `/pomodoro_records` | `reward` | `0` abgebrochen · `0.5×n` halb · sonst volles Vielfaches |
| `/coin_records` `/inventory_records` | `resCode` | Shop: `0` kaufen · `1` nutzen · `2` Aufgabe erledigen · `3` Erledigung rückgängig · `4` leeren · `5` aufgeben · `6` überfällig · `7` Erfolg freischalten · `8` Aufgeben widerrufen · `9` Überfälligkeit widerrufen · `10` zurückgeben · `11` Unteraufgabe erledigen · `12` Unteraufgabe rückgängig · `13` Nutzer-Erfolg freischalten · `14` Nutzer-Erfolg rückgängig · `15` einzahlen · `16` abheben · `17` Tomaten verkaufen · `20` Gegenstand belohnen · `21` Gegenstandsbelohnung rückgängig · `23` Synthese · `24` Lootbox · `25` ATM-Zinsen · `26` Tomaten-Tausch · `27` Kreditzinsen · `28` API · `29` Effekt-Bestand |
| `/exp_records` | `resCode` | Exp (nicht Shop `28`): `0` unbekannt · `1` erledigen · `2` Erfolg · `3` Like-Tausch · `4` Tagesstreak · `5` Schritte · `6` als erledigt setzen · `7` Aufgeben widerrufen · `8` Überfälligkeit widerrufen · `9` Tomate essen · `10` Gegenstand genutzt · `11` Nutzer-Erfolg freischalten · `12` Unteraufgabe erledigen · `200` API · `101` Erledigung rückgängig · `102` aufgeben · `103` überfällig · `104` Gegenstandsnutzung abbuchen · `105` Nutzer-Erfolg sperren · `106` Unteraufgabe rückgängig |

`GET /items_categories`, `GET /synthesis_categories` und `GET /skill_groups` akzeptieren `include_hidden=true` (versteckte Listen standardmäßig ausgelassen). Erfolgs-Freischaltbedingungen: `GET /achievement_conditions/{id}`. Fähigkeit-`status` (0 normal / 1 versteckt) nur bei `query`/`query_skill`, **nicht** bei `GET /skills`.

**Method: `GET`**

**Parameter:**

| Feld | Beschreibung | Ort | Typ | Pflicht | Hinweise |
| --- | --- | --- | --- | --- | --- |
| id | Datensatz-ID | Path/Query | Number | Ja (für ID-spezifische Endpunkte) | - |
| offset | Abfrage-Offset | Query | Number | Nein | Nur bei manchen paginierten Endpunkten nötig |
| limit | Seitengröße | Query | Number | Nein | Nur bei manchen paginierten Endpunkten nötig |
| gid | Verlauf wiederholender Aufgabe filtern | Query | Number | Nein | Optional für Verlaufsabfrage |
| include_hidden | Versteckte Listen einschließen | Query | Boolean | Nein | Standard false. Für `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Bereichsstart (ms) | Query | Number | Nein* | Muss mit `time_range_end` gepaart sein. Teilweiser/ungültiger Bereich liefert `invalid_parameter` |
| time_range_end | Bereichsende (ms) | Query | Number | Nein* | Muss größer als `time_range_start` sein |

**Request-Beispiele**

**Aufgaben**

```txt
// Alle Aufgaben
http://{host:port}/tasks

// Aufgaben in Liste ID 1
http://{host:port}/tasks/1

// Verlauf (100 Einträge ab Index 0)
http://{host:port}/history?offset=0&limit=100

// Aufgaben-Kategorien
http://{host:port}/tasks_categories
```

**Gegenstände**

```txt
// Alle Gegenstände
http://{host:port}/items

// Bestimmte Gegenstands-IDs 1 und 4 abfragen
http://{host:port}/items?id=1&id=4

// Gegenstände in Liste ID 1
http://{host:port}/items/1

// Gegenstands-Kategorien
http://{host:port}/items_categories
```

**Erfolge**

```txt
// Erfolge in Liste/Kategorie ${id}
http://{host:port}/achievements/${id}

// Erfolgs-Kategorien
http://{host:port}/achievement_categories
```

**Gefühle**

```txt
// 100 Einträge ab Index 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attribute**

```txt
http://{host:port}/skills
```

**Synthese-Kategorien**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Synthese-Rezepte**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. Bild-/Datei-API

> [!NOTE]
> Wegen Android-Speicherbeschränkungen kann LifeUp Cloud beim Ausliefern von Bildinhalten aus LifeUp eine kopierte Datei anlegen müssen.

Funktion:

> Bild-/Datei-Ressourcen laden, die von Daten-APIs zurückgegeben werden (typisch `content://...`).

Request-URL:

```txt
http://{host:port}/files/${url}
```

**Method: `GET`**

**Path-Parameter:**

| Feld | Beschreibung | Ort | Typ | Pflicht | Hinweise |
| --- | --- | --- | --- | --- | --- |
| url | Datei-URL | Path | String | Ja | - |

**Request-Beispiel:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Fähigkeiten-ContentProvider-Abfragen

> [!NOTE]
> Erfordert v1.103.0+

Für Listen- oder strukturierte Abfragen kannst du folgende ContentProvider-URIs über `http://{host:port}/api/contentprovider` lesen.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Gibt nur sichtbare Fähigkeiten zurück.

| Spalte | Bedeutung | Typ | Hinweise |
| ------ | ------- | ---- | ----- |
| _ID | Fähigkeits-ID | number | - |
| name | Fähigkeitsname | string | - |
| desc | Beschreibung | string | Kann leer sein |
| icon | Icon-URI | string | Kann leer sein |
| order | Rohe Sortierreihenfolge | number | `orderInCategory` |
| group_id | Fähigkeitsgruppen-ID | number / null | Leer wenn Fähigkeit in keiner Gruppe |
| color | Farbe | number / null | Kann leer sein |
| exp | Erfahrungspunkte | number | - |
| level | Aktuelle Stufe | number | - |
| until_next_level_exp | EXP bis nächste Stufe | number | - |
| current_level_exp | EXP in aktueller Stufe | number | - |
| type | Fähigkeitstyp | number | - |
| status | Fähigkeitsstatus | number | `0` = normal, `1` = versteckt |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Gibt nur sichtbare Fähigkeitsgruppen zurück.

| Spalte | Bedeutung | Typ | Hinweise |
| ------ | ------- | ---- | ----- |
| _ID | Fähigkeitsgruppen-ID | number | - |
| content | Gruppenname | string | - |
| order | Rohe Sortierreihenfolge | number | `orderInCategory` |
| collapsed | Einklapp-Status | string | Als `true` / `false`-Text zurückgegeben |

<br/>

## Mitwirken

SDK, LifeUp Cloud und LifeUp Desktop sind Open-Source-Projekte.

Quellcode:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

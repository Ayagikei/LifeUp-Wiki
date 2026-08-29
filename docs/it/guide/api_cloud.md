<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud è uno dei toolkit API principali di LifeUp. Trasforma il telefono in un **ponte API**: controlla LifeUp dal **computer o da altri dispositivi**, crea **integrazioni personalizzate** (desktop, web, script di automazione) o abbinalo ad **agenti IA**.

### Scenari tipici

| Scenario | Per chi | In una frase | Approfondimenti |
| --- | --- | --- | --- |
| **HTTP + costruisci il tuo** | Sviluppatori, utenti automazione | Chiama le API e interroga i dati da Python, app web o script in LAN — non serve esperienza Android | [API HTTP](#http-api-definition), [Desktop](guide/api_desktop.md) |
| **Scansione QR** | Fan del check-in nel mondo reale | Stampa codici QR per completare Compiti, avviare timer, aprire dialoghi o lanciare pagine web / altre app | [Scansione codici QR](#qr-code-scanning) |
| **Scorciatoie avvio / stop** | Automazione, NFC, Tasker | `lifeupcloud://start` e `lifeupcloud://stop` aprono Cloud e avviano o arrestano il server HTTP | [Avvio e stop](#cloud-scheme) |
| **Agente IA + MCP** | Cursor, Claude, ecc. | Un prompt per creare liste di Compiti, Oggetti del Negozio, Obiettivi e altro | [MCP & Skills](guide/api_mcp.md) |
> **Esempio di prompt IA:** Cancella i Compiti e gli Oggetti di esempio del Negozio, poi crea una configurazione completa da sviluppatore indie: liste di Compiti, Attributi, Oggetti del Negozio e Obiettivi.

<br/>

## Download

- Se usi la versione membership della Cina continentale, trovi l'ingresso di download di LifeUp Cloud in `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Avviare e arrestare il servizio Cloud :id=cloud-scheme

Puoi avviare o arrestare il server HTTP senza toccare **Start Service**, usando questi URL scheme:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Aprire una delle URL avvia LifeUp Cloud e applica l'azione. Usale come scorciatoia sulla schermata Home, tag NFC, azione Tasker/automazione, oppure:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Le stesse URL sono elencate sulla scheda di stato di Cloud — tocca per copiare.

> [!NOTE]
> `lifeupcloud://` controlla il server HTTP di Cloud. Non è un'API di gioco `lifeup://api/…`.

<br/>

## Scansione codici QR

Il pulsante **Scan** in alto in LifeUp Cloud legge l'URL codificato in un codice QR e lo apre subito — senza digitazione manuale.

La scansione **non è limitata alle API LifeUp**: `lifeup://api/…`, pagine web `https://…` e URL scheme di altre app (es. `weixin://`) funzionano ugualmente — Android apre la destinazione corrispondente.

### Come usarla

1. Scegli un URL da LifeUp o dall'[elenco API](guide/api.md) del wiki (completare un Compito, avviare un pomodoro, aprire dialoghi acquisto/uso o aprire una pagina web esterna).

2. Genera un codice QR dall'URL completa (stampalo e attaccalo a scrivania, parete o dispositivo).

3. Apri LifeUp Cloud, tocca **Scan** (tocca **?** accanto per una breve guida in-app) e inquadra il codice.

### Cosa puoi fare

| Scenario | Esempio (illustrativo) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` avvia/arresta timer |
| Check-in Compito | `lifeup://api/complete?name=...` completa un Compito |
| Interazione Negozio | `lifeup://api/goto?page=shop` o dialoghi acquisto/uso |
| Ricompensa / penalità | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Minigioco web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Altre app | `weixin://`, `intent://` o lo scheme di qualsiasi app installata |
| Flussi personalizzati | Qualsiasi combinazione di URL scansionabile |

### Interazione nel mondo reale

I codici QR collegano **luoghi o azioni fisiche** alla gamification in-app:

- Adesivo su **attrezzatura da palestra** → scansiona per completare un Compito di allenamento di forza

- Adesivo su **scrivania studio** → scansiona per avviare un pomodoro Concentrazione

- Adesivo su **postazione di lavoro** → scansiona per registrare stand-up o revisione codice

- Adesivo su **bacheca eventi** → scansiona per riscuotere una Ricompensa o aprire un Obiettivo

In sintesi: **trasforma gli URL Scheme in trigger fisici scansionabili**, con LifeUp Cloud come esecutore tra l'App e il mondo reale.

<br/>

> [!NOTE]
> LifeUp Cloud è un ponte HTTP solo LAN. Come raggiungere il telefono — indirizzo IP, router, firewall, stessa subnet, VPN o isolamento AP — dipende dalla rete domestica. Se non riesci a connetterti, non possiamo fare debug della tua LAN personale. Controlla la rete, usa strumenti standard o chiedi aiuto a un agente IA.

## Definizione API HTTP

> [!WARNING]
> La documentazione API di questa pagina può restare indietro rispetto agli aggiornamenti dell'implementazione. Usa il codice sorgente come riferimento finale: [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API di invocazione URL Scheme

#### GET

Funzione:

> Invoca API che iniziano con `lifeup://api`.

URL richiesta:

```txt
// Consigliato: modalità content provider (migliore compatibilità)
http://{host:port}/api/contentprovider

// modalità startActivity (alcuni dispositivi possono bloccare la UI in background)
http://{host:port}/api
```

**Metodo: `GET`**

**Parametri query:**

| Campo | Descrizione | Posizione | Tipo | Obbligatorio | Note |
| --- | --- | --- | --- | --- | --- |
| url | URL API che inizia con `lifeup://api` | Query | string | Sì | Codifica l'URL se costruisci manualmente. Sono supportati più parametri `url`. |

**Esempi di richiesta:**

```txt
// Chiamata singola (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Chiamata batch
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Chiamata singola (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Funzione:

> Invoca API che iniziano con `lifeup://api`.

URL richiesta:

```txt
// Consigliato: modalità content provider (migliore compatibilità)
http://{host:port}/api/contentprovider

// modalità startActivity (alcuni dispositivi possono bloccare la UI in background)
http://{host:port}/api
```

**Metodo: `POST`**

**Parametri body JSON:**

| Campo | Descrizione | Posizione | Tipo | Obbligatorio | Note |
| --- | --- | --- | --- | --- | --- |
| urls | Array di URL che iniziano con `lifeup://api` | Body | List<string> | Sì | Nessuna codifica URL extra nel body JSON. |

**Esempio di richiesta:**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. API di interrogazione dati

> [!NOTE]
> Requisiti:
> 1. LifeUp v1.91+ e l'ultima versione di LifeUp Cloud.
> 2. Concedi il permesso **Read LifeUp Data** in LifeUp Cloud.

Funzione:

> Interroga set completi di dati LifeUp, come Compiti e Oggetti.

**Endpoint Compiti**

```txt
// Tutti i Compiti
http://{host:port}/tasks

// Compiti in categoria/lista ${id}
http://{host:port}/tasks/${id}

// Cronologia (supporta paginazione)
// gid è opzionale e può filtrare tutta la cronologia di un Compito ripetuto
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Categorie Compiti
http://{host:port}/tasks_categories
```

**Endpoint Oggetti**

```txt
// Tutti gli Oggetti
http://{host:port}/items

// Oggetti in categoria/lista ${id}
http://{host:port}/items/${id}

// Categorie Oggetti
http://{host:port}/items_categories

// Includi liste nascoste
http://{host:port}/items_categories?include_hidden=true
```

**Endpoint Obiettivi**

```txt
// Tutti gli Obiettivi
http://{host:port}/achievements

// Obiettivi in categoria/lista ${id}
http://{host:port}/achievements/${id}

// Categorie Obiettivi
http://{host:port}/achievement_categories
```

**Endpoint Riflessioni**

```txt
// Tutte le Riflessioni (supporta paginazione)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Endpoint categorie Sintesi**

```txt
// Tutte le categorie Sintesi
http://{host:port}/synthesis_categories

// Categorie Sintesi in lista ${id}
http://{host:port}/synthesis_categories/${id}
```

**Endpoint ricette Sintesi**

```txt
// Tutte le ricette Sintesi
http://{host:port}/synthesis

// Ricette Sintesi in categoria ${id}
http://{host:port}/synthesis/${id}
```

**Endpoint Attributi**

```txt
// Tutti gli Attributi
http://{host:port}/skills
```


**Altro**

```txt
// Saldo monete
http://{host:port}/coin

// Versioni LifeUp / Cloud
http://{host:port}/info

// Registri Pomodoro (paginati; intervallo temporale opzionale)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Diari (paginati; intervallo temporale opzionale). Righe eliminate soft omesse.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Tutti gli Obiettivi (implementato; id categoria opzionale)
http://{host:port}/achievements

// Eventi broadcast. LifeUp Labs → Broadcast events è disattivato di default; Cloud Advanced può mostrare lo stato e abilitarlo. GET data.broadcasts è quell'interruttore (omesso se non letto). L'impostazione WebSocket di Cloud è solo trasporto.
http://{host:port}/events?after=${id}&limit=50

// Push WebSocket (attivo di default; impostazione Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

Envelope: `{ code, message, data }`. `200` indica solo OK di trasporto. `10001` LifeUp non in esecuzione o Read Data non concesso. `10002` query ContentProvider fallita.

### Valori dei campi elenco

| Endpoint | Campo | Valori |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` non completato · `1` completato · `2` scaduto · `3` abbandonato |
| `/tasks` | `frequency` | `0` una volta · `1` giornaliero · `N>1` ogni N giorni · `-1` illimitato · `-3` Ebbinghaus · `-4` mensile · `-5` annuale |
| `/tasks` | `weekdays` | `1,3,5` (Lun=1 … Dom=7). Vuoto se non in modalità giorni settimana. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normale · `1` archiviato |
| `/tasks_categories` | `type` | `<10` normale · `10` giornaliero · `11` settimanale · `12` mensile · `20` in corso |
| `/achievements` | `status` | `0` bloccato · `1` sbloccato, Ricompensa non riscossa · `2` sbloccato, riscosso |
| `/achievements` | `type` | `0` normale · `1` sottocategoria |
| `/achievement_categories` | `type` | `0` utente · `1` sistema |
| `/feelings` | `type` | `0` Compito · `1` Obiettivo · `2` grezzo · `3` uso Oggetto |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` utente · `1` forza · `2` apprendimento · `3` fascino · `4` resistenza · `5` vitalità · `6` creativo |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` visibile · `1` nascosto (flag indipendenti) |
| `/synthesis_categories` | `hidden` | `0` visibile · `1` nascosto |
| `/pomodoro_records` | `reward` | `0` abbandonato · `0.5×n` metà · altrimenti multiplo intero |
| `/coin_records` `/inventory_records` | `resCode` | Negozio: `0` acquista · `1` usa · `2` completa Compito · `3` annulla completamento · `4` cancella · `5` abbandona · `6` scaduto · `7` sblocca Obiettivo · `8` revoca abbandono · `9` revoca scaduto · `10` restituisci · `11` completa sotto-compito · `12` annulla sotto-compito · `13` sblocca Obiettivo utente · `14` annulla Obiettivo utente · `15` deposita · `16` preleva · `17` vendi pomodori · `20` Ricompensa Oggetto · `21` annulla Ricompensa Oggetto · `23` Sintesi · `24` Bottino · `25` interesse ATM · `26` scambio pomodoro · `27` interesse credito · `28` API · `29` effetto azione |
| `/exp_records` | `resCode` | Exp (non Negozio `28`): `0` sconosciuto · `1` completa · `2` Obiettivo · `3` scambio like · `4` serie giornaliera · `5` passi · `6` imposta completato · `7` revoca abbandono · `8` revoca scaduto · `9` mangia pomodoro · `10` Oggetto usato · `11` sblocca Obiettivo utente · `12` completa sotto-compito · `200` API · `101` annulla completamento · `102` abbandona · `103` scaduto · `104` addebito Oggetto usato · `105` blocca Obiettivo utente · `106` annulla sotto-compito |

`GET /items_categories`, `GET /synthesis_categories` e `GET /skill_groups` accettano `include_hidden=true` (liste nascoste omesse di default). Condizioni di sblocco Obiettivo: `GET /achievement_conditions/{id}`. `status` Abilità (0 normale / 1 nascosto) solo su `query`/`query_skill`, **non** su `GET /skills`.

**Metodo: `GET`**

**Parametri:**

| Campo | Descrizione | Posizione | Tipo | Obbligatorio | Note |
| --- | --- | --- | --- | --- | --- |
| id | ID dati | Path/Query | Number | Sì (per endpoint specifici per ID) | - |
| offset | Offset query | Query | Number | No | Obbligatorio solo per alcuni endpoint paginati |
| limit | Dimensione pagina | Query | Number | No | Obbligatorio solo per alcuni endpoint paginati |
| gid | Filtra cronologia Compito ripetuto | Query | Number | No | Opzionale per query cronologia |
| include_hidden | Includi liste nascoste | Query | Boolean | No | Default false. Usato da `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Inizio intervallo (ms) | Query | Number | No* | Deve essere abbinato a `time_range_end`. Intervallo parziale/non valido restituisce `invalid_parameter` |
| time_range_end | Fine intervallo (ms) | Query | Number | No* | Deve essere maggiore di `time_range_start` |

**Esempi di richiesta**

**Compiti**

```txt
// Tutti i Compiti
http://{host:port}/tasks

// Compiti in lista ID 1
http://{host:port}/tasks/1

// Cronologia (100 record dall'indice 0)
http://{host:port}/history?offset=0&limit=100

// Categorie Compiti
http://{host:port}/tasks_categories
```

**Oggetti**

```txt
// Tutti gli Oggetti
http://{host:port}/items

// Interroga ID Oggetto specifici 1 e 4
http://{host:port}/items?id=1&id=4

// Oggetti in lista ID 1
http://{host:port}/items/1

// Categorie Oggetti
http://{host:port}/items_categories
```

**Obiettivi**

```txt
// Obiettivi in lista/categoria ${id}
http://{host:port}/achievements/${id}

// Categorie Obiettivi
http://{host:port}/achievement_categories
```

**Riflessioni**

```txt
// 100 record dall'indice 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attributi**

```txt
http://{host:port}/skills
```

**Categorie Sintesi**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Ricette Sintesi**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API immagine/file

> [!NOTE]
> Per restrizioni di archiviazione Android, LifeUp Cloud può dover creare un file copiato quando serve contenuto immagine da LifeUp.

Funzione:

> Carica risorse immagine/file restituite dalle API dati (tipicamente `content://...`).

URL richiesta:

```txt
http://{host:port}/files/${url}
```

**Metodo: `GET`**

**Parametri path:**

| Campo | Descrizione | Posizione | Tipo | Obbligatorio | Note |
| --- | --- | --- | --- | --- | --- |
| url | URL file | Path | String | Sì | - |

**Esempio di richiesta:**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Query ContentProvider Abilità

> [!NOTE]
> Richiede v1.103.0+

Per query elenco o strutturate, puoi leggere le seguenti URI ContentProvider tramite l'endpoint `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Restituisce solo Abilità visibili.

| Colonna | Significato | Tipo | Note |
| ------ | ------- | ---- | ----- |
| _ID | ID Abilità | number | - |
| name | Nome Abilità | string | - |
| desc | Descrizione | string | Può essere vuota |
| icon | URI icona | string | Può essere vuota |
| order | Ordine grezzo | number | `orderInCategory` |
| group_id | ID gruppo Abilità | number / null | Può essere vuoto se l'Abilità non è in un gruppo |
| color | Colore | number / null | Può essere vuoto |
| exp | Punti Esperienza | number | - |
| level | Livello attuale | number | - |
| until_next_level_exp | EXP al Livello successivo | number | - |
| current_level_exp | EXP guadagnati nel Livello attuale | number | - |
| type | Tipo Abilità | number | - |
| status | Stato Abilità | number | `0` = normale, `1` = nascosto |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Restituisce solo gruppi Abilità visibili.

| Colonna | Significato | Tipo | Note |
| ------ | ------- | ---- | ----- |
| _ID | ID gruppo Abilità | number | - |
| content | Nome gruppo | string | - |
| order | Ordine grezzo | number | `orderInCategory` |
| collapsed | Stato collasso | string | Restituito come testo `true` / `false` |

<br/>

## Contributo

SDK, LifeUp Cloud e LifeUp Desktop sono tutti progetti open source.

Puoi ottenere il codice sorgente su:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

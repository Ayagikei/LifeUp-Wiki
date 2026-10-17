<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Stiamo distribuendo gradualmente **LifeUp v1.106.0** e **LifeUp Cloud v3.0.0**. I tempi di revisione variano a seconda della piattaforma, quindi questa documentazione potrebbe essere aggiornata prima che le app siano ampiamente disponibili; la data di rilascio effettiva potrebbe essere successiva a quanto indicato qui.

LifeUp Cloud è uno dei toolkit API principali di LifeUp. Trasforma il telefono in un **ponte API**: controlla LifeUp dal **computer o da altri dispositivi**, crea **integrazioni personalizzate** (desktop, web, script di automazione) o abbinalo ad **agenti IA**.

### Scenari tipici

| Scenario | Per chi | In una frase | Approfondimenti |
| --- | --- | --- | --- |
| **HTTP + costruisci il tuo** | Sviluppatori, utenti automazione | Chiama le API e interroga i dati da Python, app web o script in LAN — non serve esperienza Android | [Riferimento API HTTP](/guide/api-reference), [Desktop](guide/api_desktop.md) |
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

## Connettersi a LifeUp Cloud :id=connect

1. Installare versioni compatibili di LifeUp e LifeUp Cloud. Aprire LifeUp Cloud e concedere l’autorizzazione ai dati/API LifeUp quando richiesto.
2. Avviare il servizio HTTP. Da un dispositivo che può raggiungere il telefono in rete, usare l’indirizzo e la porta mostrati da Cloud come URL di base.
3. Se è configurato un token Cloud, inviarne il valore grezzo nell’intestazione `Authorization`. Interrogare `/info` per verificare connessione e versioni installate; controllare sia lo stato HTTP sia il `code` JSON.

## Riferimento API HTTP :id=http-api-definition

Il [riferimento completo di interfacce e parametri](/guide/api-reference) contiene un indice delle route, regole comuni di risposta/paginazione, modelli completi, parametri delle richieste ed esempi JSON. Consultarlo per creare un’integrazione. I [metodi degli schemi URL](/guide/api) descrivono le singole azioni; [MCP & Skills](/guide/api_mcp) descrive gli strumenti degli agenti IA.

### Timestamp dei compiti e della cronologia :id=task-history-timestamps

Vedere il [modello temporale dei compiti](/guide/api-reference?id=task-times): `startTime` è l’inizio previsto, `deadline` la scadenza e `endTime` della cronologia l’ora registrata di completamento/scadenza/abbandono, da interpretare con `status`.

#### Rapporti giornalieri e completezza della cronologia :id=history-daily-reports

Vedere [paginazione della cronologia e rapporti giornalieri](/guide/api-reference?id=daily-report) e i [registri EXP/monete](/guide/api-reference?id=reward-journals) per le variazioni effettive delle ricompense.

## Contributo

SDK, LifeUp Cloud e LifeUp Desktop sono tutti progetti open source.

Puoi ottenere il codice sorgente su:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

<h1 align="center" padding="100">Client desktop (API) rete locale 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Abbiamo creato un client desktop leggero per LifeUp basato sulle API LifeUp. Supporta Windows, Linux e macOS.

**Non è un'app autonoma.** Legge i dati offline di LifeUp dal telefono tramite accesso API.

<br/>

## Funzionalità

> [!NOTE]
> La versione attuale è soprattutto un'anteprima tecnica delle capacità API. Si concentra sulle operazioni di consultazione principali e non copre ogni funzione in-app.

- Completamente open source. Puoi personalizzare l'interfaccia e implementare funzioni tue.
- Capacità base attuali:
  - Consultare l'elenco Compiti e completarli
  - Consultare l'elenco Attributi e Livelli
  - Consultare l'elenco Oggetti e acquistarli
  - Consultare Riflessioni e vedere immagini a dimensione piena sul desktop
  - Esportare Riflessioni in file Markdown
  - Aggiungere Compiti (non copre ancora tutte le opzioni in-app)

<br/>

## Download

Tutti i pacchetti desktop sono pubblicati su [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Prima di usare il desktop, assicurati che LifeUp Cloud sia v2.0.0 o superiore.<br/>
> Se usi la build GitHub Releases, aggiorna LifeUp Cloud in `Settings` → `Labs`.<br/>
> Se usi la build Google Play, puoi aggiornare da [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) o [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Alcuni browser possono bloccare il download dell'installer per policy di sicurezza. Scegli **Mantieni/Consenti** (il testo varia per browser) o usa un altro downloader.

### Piattaforme di installazione

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> L'MSI non è attualmente firmato EV, quindi Windows può mostrare un avviso «app non riconosciuta».<br/>
> Dopo aver confermato che il file proviene dal release ufficiale GitHub, clicca **Altre informazioni → Esegui comunque**.

#### **Linux**

- Scarica da [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) e usa `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- Le build macOS non sono ancora completamente testate; alcune funzioni come **Auto Connect** possono non essere disponibili.

> [!TIP]
> **Gatekeeper / firma macOS**<br/>
> Le build macOS attuali non sono notarizzate. Può comparire un avviso «sviluppatore non identificato».<br/>
> Puoi aprire il `.dmg`, spostare l'app in Applicazioni, poi fare clic destro sull'app e scegliere **Apri**,<br/>
> oppure andare in **Impostazioni di sistema → Privacy e sicurezza** e cliccare **Apri comunque**.<br/>
> Vedi la [guida ufficiale Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) per i dettagli.

<!-- tabs:end -->

Se un pacchetto manca temporaneamente, riprova più tardi. Gli asset del release possono essere ancora in upload.

<br/>

## Come usare

### Configurazione iniziale

#### Prerequisiti

- Telefono e desktop devono essere sulla stessa LAN (ad esempio, la stessa Wi-Fi).
- <del>Se la rete è complessa, verifica prima se il desktop riesce a fare ping all'IP del telefono.</del>
  - Le versioni recenti del desktop supportano il rilevamento automatico dell'IP del telefono, quindi spesso non serve.

#### Sul telefono

1. Aggiorna LifeUp all'ultima versione.
2. In LifeUp, apri `Settings` → `Labs`, poi installa **LifeUp Cloud**.
3. Apri LifeUp Cloud e concedi i permessi richiesti:
   - Permesso finestra flottante / disegna sopra altre app
   - Permesso lettura dati LifeUp
4. Tocca **Start Service** in LifeUp Cloud.

**Configurazione aggiuntiva consigliata**

- Esegui la configurazione di compatibilità sia per LifeUp che per LifeUp Cloud, e disabilita l'ottimizzazione batteria per ridurre chiusure in background.
- Se usi MIUI (Xiaomi/Redmi), consenti **Display UI in background** per entrambe le app.
- Mantieni LifeUp e LifeUp Cloud in esecuzione.

#### Sul desktop

1. Installa l'app desktop dal pacchetto release.
2. Nelle impostazioni desktop, inserisci l'IP del servizio mostrato in LifeUp Cloud.
   - Nel desktop v1.1.0+, puoi provare **Auto Connect**.
3. Se tutto è configurato correttamente, dovresti vedere i dati LifeUp sul desktop.
   - Se fallisce, rivedi la configurazione aggiuntiva sopra.

### Uso successivo

1. Apri LifeUp e LifeUp Cloud sul telefono.
2. Tocca **Start Service** in LifeUp Cloud.
3. Avvia il client desktop.

<br/>

## FAQ

<details>
<summary>Posso aggiungere Compiti dal desktop?</summary>

Sì. La build desktop attuale supporta la creazione base di Compiti.

Tuttavia, non tutte le opzioni avanzate Compiti in-app sono ancora disponibili sul desktop. Per configurazioni complesse, usa l'App mobile o chiama le API tramite LifeUp Cloud.

</details>

<details>
<summary>Ho cliccato «Request LifeUp Permission» in LifeUp Cloud, ma non è successo nulla / API not found.</summary>

1. Se non succede nulla, potresti averlo già concesso.
2. Se compare API not found, unisciti alla beta membri e aggiorna LifeUp all'ultima versione beta.

</details>

<details>
<summary>Dopo il blocco del telefono per un po', il desktop non legge più i dati.</summary>

Esegui la configurazione di compatibilità sia per LifeUp che per LifeUp Cloud.

</details>

<details>
<summary>Quando LifeUp e LifeUp Cloud sono in background, alcune API non si eseguono.</summary>

> Di solito non influisce sull'uso base del desktop, ma può influire sulle chiamate API personalizzate.

Assicurati che LifeUp Cloud abbia il permesso finestra flottante/disegna sopra altre app.

Se usi MIUI (Xiaomi/Redmi), abilita anche il permesso **Display UI in background** per entrambe le app.

</details>

<details>
<summary>L'installazione Windows fallisce con `Failed to launch JVM`.</summary>

Riferimento: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Di solito è legato alla configurazione locale di accessibilità JVM.

Un workaround comune è commentare queste righe in `~/.accessibility.properties`:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Dopo la modifica, riavvia l'app e riprova.

> `~` indica la home directory dell'utente.

</details>

<br/>

## Contributo

SDK, LifeUp Cloud e LifeUp Desktop sono tutti open source.

Codice sorgente:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

# Backup e ripristino

> [!IMPORTANT]
> LifeUp è un'applicazione offline-first. La maggior parte dei tuoi dati personali resta sul dispositivo. Se non configuri il backup, disinstallare l'App, cambiare telefono o danneggiare il dispositivo può causare una perdita permanente dei dati.

## Navigazione rapida

- [Perché il backup è importante](#why-backup)
- [Come configurare i metodi di backup](#configure-methods)
- [Come eseguire il backup](#how-to-backup)
- [Come ripristinare](#how-to-restore)
- [Migrazione su un nuovo telefono](#phone-migration)
- [Problemi comuni](#common-issues)

## 1) Perché il backup è importante :id=why-backup

### Da quali rischi ti proteggi?

La maggior parte degli utenti perde dati in una di queste situazioni:

1. Disinstallazione dell'App (i file nel percorso di backup predefinito possono essere rimossi dalla pulizia di sistema)
2. Migrazione del telefono senza spostare i file di backup
3. Danno o smarrimento del dispositivo

Un backup affidabile significa che i tuoi dati esistono su un altro dispositivo o supporto di archiviazione, non solo sullo stesso telefono.

### Cosa include un backup?

I backup includono i dati locali principali, come Compiti, Attributi, dati del Negozio, Obiettivi, Riflessioni, registri Pomodoro e impostazioni. I file multimediali (allegati, icone, sfondi, audio) possono essere inclusi.

> [!TIP]
> Se la dimensione del backup supera i 10 MB, abilita «Ignore media/picture files» o aumenta l'intervallo di backup per una maggiore stabilità.

## 2) Come configurare i metodi di backup :id=configure-methods

Per la maggior parte degli utenti, questa priorità funziona meglio:

| Metodo | Consigliato | Ideale per | Backup automatico | Note |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Uso quotidiano, sincronizzazione cloud semplice | Sì | Autorizzazione con un tocco nell'App |
| Dropbox | ⭐⭐⭐⭐ | Uso quotidiano, sincronizzazione tra dispositivi | Sì | Supporta anche l'autorizzazione in-app |
| Esportazione locale (Custom Path) | ⭐⭐⭐⭐ | Copia manuale su PC / NAS | No (manuale) | Fallback affidabile e archivi versionati |
| WebDAV | ⭐⭐⭐ | Self-hosting / servizio WebDAV esistente | Sì | Buona alternativa se usi già WebDAV |
| Backup automatico nella cartella Download (Android 10+) | ⭐⭐⭐ | Ridurre il rischio di disinstallazione | Sì | Non protegge da danni al dispositivo |

<details>
<summary>Configurare il backup automatico Google Drive / Dropbox (consigliato)</summary>

Nell'App, vai a:
`Sidebar → Settings → Data Backup/Restore/Clear`

Poi:

1. Autorizza Google Drive o Dropbox
2. In «Cloud Backup Config», seleziona il metodo
3. Abilita «Enable auto cloud backup»
4. Imposta «Auto backup interval»
5. Opzionalmente abilita «Ignore media/picture files»

</details>

<details>
<summary>Configurare il backup cloud WebDAV (opzionale)</summary>

Se usi un servizio compatibile con WebDAV:

1. Apri `WebDAV Configuration`
2. Inserisci URL, account e password
3. Esegui un test di connessione
4. Usa WebDAV come metodo di backup cloud

</details>

<details>
<summary>Esportare su percorso personalizzato (fallback manuale)</summary>

Usa questa opzione quando vuoi backup manuali e portabili:

1. Tocca `Backup`
2. Scegli `Custom Path`
3. Salva il file generato (di solito `.lfbak`)
4. Copialo su PC / NAS / cloud storage

> [!WARNING]
> Non tenere l'unico backup sullo stesso telefono.

</details>

## 3) Come eseguire il backup :id=how-to-backup

<details>
<summary>Flusso di backup automatico quotidiano</summary>

1. Completa una configurazione cloud (Google Drive o Dropbox)
2. Abilita il backup cloud automatico e l'intervallo
3. Avvia un backup manuale per verificare che tutto funzioni
4. Controlla periodicamente l'indicazione «last backup»

</details>

<details>
<summary>Backup manuale prima di modifiche critiche</summary>

Crea un'esportazione locale aggiuntiva prima di:

- aggiornamenti importanti dell'App
- reset/reflash di sistema
- migrazione del telefono

Usa: `Backup → Custom Path`, poi copia il file su archivio esterno.

</details>

## 4) Come ripristinare :id=how-to-restore

<details>
<summary>Ripristino da backup cloud (Google Drive / Dropbox / WebDAV)</summary>

1. Configura lo stesso account/metodo cloud sul dispositivo di destinazione
2. Tocca `Restore` e scegli quel metodo
3. Conferma il ripristino (l'App si riavvierà)

> [!WARNING]
> Il ripristino sovrascrive i dati locali attuali. Se i dati attuali sono importanti, esporta prima un backup locale.

</details>

<details>
<summary>Ripristino da file di backup locale</summary>

1. Sposta il file di backup sul dispositivo di destinazione
2. Tocca `Restore → Custom Path`
3. Seleziona il file di backup e conferma

Puoi anche abilitare «Support file system to open backup files» per importare direttamente dal file manager o dalle app di condivisione.

> [!TIP]
> Se il ripristino fallisce con errore di lettura/scrittura, prova un altro percorso del file e riselezionalo.

</details>

### Migrazione su un nuovo telefono :id=phone-migration

<details>
<summary>Migrare su un nuovo telefono (sistema o percorso di backup)</summary>

#### Opzione A: usa prima la migrazione integrata del telefono

Alcuni telefoni supportano la migrazione completa dei dati dell'App (strumenti di migrazione del produttore / clone di sistema).

1. Esegui la migrazione di sistema dal telefono vecchio al nuovo.
2. Apri LifeUp e verifica i dati principali (Compiti, Attributi, dati del Negozio, Obiettivi).
3. Anche se la migrazione sembra a posto, crea un backup aggiornato sul nuovo telefono.

#### Opzione B: migrazione tramite backup cloud o file (universale)

1. Sul telefono vecchio, crea prima un backup aggiornato.
2. Sul nuovo telefono, installa LifeUp.
3. Per migrazione cloud: configura lo stesso metodo/account cloud, poi ripristina.
4. Per migrazione tramite file: trasferisci il file di backup, poi usa `Restore → Custom Path`.
5. Dopo il ripristino, avvia un backup manuale per verificare la catena di backup sul nuovo telefono.

> [!WARNING]
> Il ripristino sovrascrive i dati locali. Se il nuovo telefono ha già voci importanti, esporta prima.

</details>

## 5) Problemi comuni :id=common-issues

<details>
<summary>Risolvere l'errore di ripristino: file di backup non valido</summary>

- Conferma che il file sia generato da LifeUp.
- `.lfbak` è il formato consigliato.

</details>

<details>
<summary>Risolvere l'errore di ripristino: file di backup con versione più recente</summary>

Aggiorna LifeUp all'ultima versione, poi ripristina di nuovo.

</details>

<details>
<summary>Migliorare un backup cloud lento o instabile</summary>

- Abilita «Ignore media/picture files».
- Aumenta l'intervallo di backup automatico.
- Pulisci i file multimediali non usati prima del backup.

</details>

<details>
<summary>Valutare se il backup automatico nella cartella Download è sufficiente</summary>

- Aiuta contro la perdita legata alla disinstallazione.
- Non copre danni o smarrimento del dispositivo.
- Strategia più sicura: combina backup cloud + export locale periodico.

</details>

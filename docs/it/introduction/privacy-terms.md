# Privacy e termini dell'App *LifeUp*

?> La descrizione seguente del server dell'applicazione non si applica alla versione Lite. La versione Lite non ha alcuna interazione con il server dell'applicazione.

LifeUp è un'App che ti aiuta a migliorare la tua vita. Rispettiamo la tua privacy e ci impegniamo a proteggere le tue informazioni personali. Questa informativa sulla privacy spiega come raccogliamo, usiamo, condividiamo ed eliminiamo le tue informazioni personali quando usi la nostra App.

### 1. Informazioni personali

LifeUp è un'App offline-first. Non raccogliamo attivamente dati utente, ad esempio nome o indirizzo email. Puoi fornire facoltativamente alcuni dati per autorizzare l'accesso al modulo Mondo, autorizzare Google Drive o Dropbox per ottenere funzionalità di backup cloud, ecc.

Usiamo Google Firebase e Sentry per raccogliere segnalazioni di problemi e dati sulle prestazioni solo a scopo analitico.

Ecco un riepilogo di alcuni dati:

- **Nickname, avatar, genere**
  Facoltativi, usati per la funzione di accesso al modulo "Mondo", verranno trasferiti al server per l'archiviazione, ma possono essere modificati ed eliminati
- **Email**
  Facoltativa, per la sincronizzazione Google Drive, archiviazione locale, non trasmessa al server
- **URL WebDAV, account e password**
  Facoltativi, per la sincronizzazione WebDAV, archiviazione locale crittografata, non trasmessi al server
- **Informazioni sui crash, dati sulle prestazioni**
  Trasmessi ai fornitori di servizi (Google Firebase, Sentry) per l'analisi di problemi e prestazioni, ma mai associati a identificatori utente o dispositivo, né contenenti dati utente

I metodi dettagliati di raccolta e trattamento dei dati per ogni funzione sono indicati di seguito.

#### 1.1 Informazioni utente (autorizzazione di terze parti)

##### Accesso con Google/Facebook

**Solo dopo aver confermato l'autorizzazione per l'accesso,** creeremo un account con il nickname e l'immagine del profilo che hai autorizzato a fornire (e non includerà informazioni come account email).

##### Google Drive

Poiché i backup Google Drive dipendono dagli indirizzi email, *LifeUp* richiederà l'autorizzazione all'indirizzo email quando autorizzi Google Drive. **Ma questo indirizzo verrà usato solo localmente; *LifeUp* non lo trasmetterà al server dell'applicazione né lo archivierà.**

E *LifeUp* richiede solo l'archiviazione specifica dell'App, il che significa che non abbiamo il permesso di accedere ai tuoi file privati.

##### Dropbox

Dopo aver autorizzato Dropbox, **le informazioni pertinenti resteranno solo sul tuo dispositivo per il backup e non verranno trasmesse al server dell'applicazione.**

E *LifeUp* richiede solo **l'archiviazione specifica dell'App, il che significa che non abbiamo il permesso di accedere ai tuoi file privati.**

##### Server WebDAV

**L'URL WebDAV, l'account e la password verranno archiviati solo localmente e non verranno inviati al server dell'applicazione.** E la password è archiviata in forma crittografata nel database.

##### Modalità offline

***LifeUp* può essere usato anche completamente in modalità offline; semplicemente non potrà accedere al modulo "Mondo".**

In modalità offline, **non devi inviare alcuna informazione al nostro server dell'applicazione.**
**Il tuo nickname, avatar e altre informazioni verranno archiviati e resi disponibili localmente.**

Potremmo richiedere al server dell'applicazione solo gli ultimi annunci e aggiornamenti, che non comportano l'invio di informazioni.

Le tue interazioni con altri SDK come Dropbox, Google Drive e Facebook risponderanno normalmente sotto il tuo uso attivo.

In uso offline, potremmo comunque usare Google Firebase e Sentry per raccogliere crash e segnalazioni di problemi, ma come spiegato di seguito, **queste informazioni non contengono dati utente e non sono collegate alle informazioni utente. Solo per l'analisi delle prestazioni e la risoluzione dei crash, e archiviate solo temporaneamente.**

Comunicheremo anche con Google Play Services per verificare la tua licenza in base alla richiesta di Google Play.

Se vuoi negare tutte le comunicazioni sopra indicate, puoi disabilitare direttamente il permesso di richiesta di rete di LifeUp. Questo non influisce sull'uso di LifeUp stesso, ma può influire sulle funzionalità di SDK come Google Drive.


#### 1.2 Permessi

#### Archiviazione

L'applicazione **non richiederà il permesso di lettura dello spazio di archiviazione**, quindi non leggerà alcun file non autorizzato da te.

L'applicazione ha richiesto il permesso della fotocamera per facilitare l'uso di allegati immagine, caricamento avatar e altre funzioni, e **potrà chiamare la fotocamera solo dopo che l'utente ha concesso i permessi.**

Ad esempio, quando selezioni un'immagine allegata, chiamiamo direttamente il framework di archiviazione file del sistema per accedervi.

Autorizzerà *LifeUp* solo per il singolo file che selezioni; non avremo il permesso di leggere altri file.

Allo stesso tempo, a meno che tu non condivida attivamente file al di fuori del modulo Mondo, verranno archiviati solo localmente e non passeranno attraverso il server.

#### Rete

Il permesso di accesso alla rete serve per accedere al modulo "MONDO", accesso autorizzato e funzioni facoltative di sincronizzazione Dropbox/WebDAV e altro.

#### Calendario

L'applicazione offre anche la funzione di scrivere eventi nell'applicazione calendario di sistema per ricordarti. 

**Questa funzione richiederà permessi di lettura e scrittura del calendario, e questo permesso richiederà l'autorizzazione dell'utente solo quando usa la funzione corrispondente. E *LifeUp* leggerà solo gli eventi scritti dall'applicazione stessa.**

#### 1.3 Archiviazione dei dati

**L'applicazione è offline-first e non ha una funzione di sincronizzazione online integrata, quindi la maggior parte dei dati è archiviata localmente sul telefono dell'utente.**

Ad esempio, tutti i Compiti locali che hai creato, tutte le Riflessioni registrate, gli Obiettivi che hai progettato e gli Oggetti del Negozio.

**Solo i contenuti che condividi attivamente in pubblico nel modulo "Mondo" verranno archiviati sul server.
E questi contenuti supportano tutti operazioni di eliminazione e distruzione.**

Ad esempio, il team che hai creato nel modulo "Mondo", le attività che hai pubblicato dopo aver completato i Compiti del team, gli Oggetti del Negozio condivisi attivamente e così via.

Allo stesso tempo, la stragrande maggioranza delle richieste all'interno dell'applicazione verrà trasmessa in forma crittografata.

#### 1.4 Dati sulle prestazioni e segnalazioni di crash

Usiamo [Google Firebase](https://firebase.google.com/) e [Sentry](https://sentry.io/) per raccogliere dati sulle prestazioni degli utenti e segnalazioni di crash per tracciare e correggere i problemi.

Questi dati sulle prestazioni possono includere il modello del dispositivo, lo stato della rete, l'ID istanza, quando si è verificato il problema e le pagine correlate, **ma questi dati non saranno associati ai tuoi dati utente** (non include nickname, ID utente, indirizzo email o informazioni di contatto, e non raccoglierà i contenuti che inserisci e crei) e saranno usati solo per analizzare il problema e migliorare le prestazioni.

E questi dati sono archiviati temporaneamente solo da Firebase e Sentry per un certo periodo, **e noi**
**non li condivideremo/venderemo/affitteremo a terze parti.**

#### 1.5 Richiesta di eliminazione dati per *LifeUp Lite*

##### 1. Archiviazione ed eliminazione dei dati

LifeUp Lite, la versione gratuita di LifeUp, archivia principalmente i dati sul dispositivo dell'utente. Teniamo alla tua privacy e autonomia. In LifeUp Lite, poiché non vengono creati account utente, tutti i dati personali sono archiviati localmente sul tuo dispositivo.

**Per eliminare questi dati, disinstalla semplicemente l'applicazione LifeUp Lite dal tuo dispositivo. Alla disinstallazione, tutti i dati archiviati localmente verranno rimossi in modo permanente.**

##### 2. Servizi di terze parti

LifeUp Lite si integra con servizi di terze parti come Firebase e Admob per funzionalità e pubblicità. Tieni presente che i dati raccolti da questi servizi non includono informazioni personali collegate alla tua identità e sono usati in conformità con le rispettive informative sulla privacy. Questi dati vengono eliminati automaticamente dopo un certo periodo secondo le politiche di questi servizi.

##### 3. Assistenza per l'eliminazione dei dati

Se hai bisogno di assistenza o hai domande sull'eliminazione dei tuoi dati, contattaci a lifeup@ulives.io. Il nostro team è impegnato ad assisterti con qualsiasi domanda o preoccupazione relativa alla privacy dei tuoi dati e ti guiderà nel processo se necessario.

##### 4. Conformità e aggiornamenti

Rivediamo e aggiorniamo continuamente le nostre pratiche per garantire la conformità alle ultime normative e standard del settore. Questa sezione dell'Informativa sulla privacy verrà aggiornata se necessario per riflettere eventuali modifiche nei nostri processi di gestione ed eliminazione dei dati.


#### 1.6 Richiesta di eliminazione dati per *LifeUp Pro*

##### 1. Eliminazione dei dati in LifeUp Pro

Gli utenti LifeUp Pro possono eliminare i propri dati in modo indipendente all'interno dell'App.

Poiché LifeUp Pro è principalmente un'applicazione offline, puoi gestire i tuoi dati direttamente sul tuo dispositivo.

Per eliminare i tuoi dati, segui questi passaggi:

1. Vai alla pagina 'Impostazioni - Backup/Ripristino/Cancellazione dati' nell'App LifeUp Pro.
2. Scegli i dati specifici che desideri eliminare, come Compiti, Ricompense in Oggetti, pensieri locali e dati in modalità offline.
3. Conferma l'azione per eliminare permanentemente i dati selezionati.

**In alternativa, disinstallare l'App LifeUp Pro dal dispositivo comporterà anche l'eliminazione di tutti i dati archiviati localmente.**



##### 2. Eliminazione account in LifeUp Pro

L'eliminazione del tuo account in LifeUp Pro è un processo separato dall'eliminazione dei dati.

Quando elimini il tuo account, verranno rimossi:

- I tuoi post pubblici, come team e aggiornamenti, pubblicati sui nostri server.
- Il tuo nickname e altre informazioni personali associate al tuo account.
- Le associazioni OAuth collegate al tuo account.

**Per eliminare il tuo account LifeUp Pro, segui i passaggi indicati in precedenza:**

1. Vai alla pagina 'Impostazioni - Backup/Ripristino/Cancellazione dati'.
2. Tocca il pulsante 'Elimina account' in fondo alla pagina.
3. Conferma l'azione per eliminare permanentemente il tuo account e tutte le informazioni associate.

<br/>

**Se non usi più l'App LifeUp Pro ma desideri eliminare il tuo account e i dati personali, contattaci a [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Forniscici i dettagli necessari relativi al tuo account e il nostro team ti assisterà nel processo di eliminazione.

Ci impegniamo a garantire la tua privacy e gestiremo la tua richiesta con la massima cura e riservatezza.



##### 3. Servizi di terze parti

Analogamente a LifeUp Lite, LifeUp Pro si integra con servizi di terze parti come Firebase per funzionalità avanzate. I dati raccolti da questi servizi non sono personalmente identificabili e sono gestiti in conformità con le loro informative sulla privacy. Questi dati sono programmati per l'eliminazione automatica dopo un certo periodo secondo le politiche dei servizi di terze parti.



##### 4. Aggiornamenti e conformità

Monitoriamo e aggiorniamo continuamente le nostre pratiche per allinearle alle ultime leggi sulla privacy e agli standard del settore. Questa sezione dell'Informativa sulla privacy verrà modificata se necessario per riflettere accuratamente i nostri processi di gestione ed eliminazione dei dati per gli utenti LifeUp Pro.


### 2. Accordo

Usando questa applicazione accetti i termini di questa informativa sulla privacy.

Accetti di essere responsabile dei tuoi dati.

Non siamo responsabili in alcun modo per qualsiasi perdita di dati causata da o in connessione con l'uso di questa App, poiché si tratta di un'applicazione offline-first.

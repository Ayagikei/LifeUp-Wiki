# Piano di sviluppo 2026-2027

!> Questo è il nostro piano di sviluppo attuale. Faremo del nostro meglio per guidare miglioramenti e aggiornamenti del prodotto secondo questo piano. Tuttavia, a causa dell'ambiente in continuo cambiamento, il contenuto del piano di sviluppo può essere modificato o aggiunto/sottratto. Fa fede il rilascio prodotto effettivo.

### I. Piano di sviluppo

> Aggiornato: 2026/04

A differenza del 2024-2025, nel 2026-2027 prevediamo di continuare a migliorare i moduli esistenti di LifeUp e **ulives**, piuttosto che aggiungere moduli funzionali completamente nuovi.

| Modulo | Sottofunzione | Motivo del requisito | Priorità | Risultato |
| ---- | ------ | -------- | ------ | ---- |
| Integrazione calendario | - Sincronizzazione bidirezionale Google Calendar<br/>- Sincronizzazione bidirezionale calendario di sistema | - Molti feedback dall'estero.<br/>- LifeUp è uno strumento to-do con funzioni sovrapposte ma incoerenti rispetto alle app di agenda (calendario). Sviluppare tutte le funzioni calendario in LifeUp sarebbe enorme. L'integrazione esterna potrebbe essere una soluzione migliore. | P0 | 🚧 |
| Ottimizzazione funzione Sintesi | - Integrazione con Negozio<br/>- Filtri migliorati | - La Sintesi è una delle funzioni core di LifeUp. Ottimizzare continuamente l'integrazione con il Negozio e l'efficienza dei filtri per migliorare la comodità dell'utente. | P0 | ✅ Rilasciato |
| Ottimizzazione funzione Oggetti | - Effetti d'uso più ricchi (modifica quantità altri Oggetti)<br/>- Attivazione effetti sonori<br/>- Supporto limiti d'uso<br/>- Condizioni limite ampliate | - Il sistema Oggetti è core per la gamification di LifeUp. Attualmente in tuning in v1.103, migliorando continuamente flessibilità e gameplay degli Oggetti. | P0 | 🚧 Tuning v1.103 |
| Ottimizzazione funzione Attributi | - Sotto-categorie Attributi (raggruppamento)<br/>- Supporto sistema titoli<br/>- Supporto tipo [Status]<br/>- Ottimizzazione pagina Status<br/>- Widget Life Level | - Il sistema Attributi è un altro core della gamification. Continueremo a migliorare il sistema Attributi con più personalizzazione dimensionale e visualizzazione. | P0 | 🚧 Sotto-categorie rilasciate, altri in pianificazione |
| Ottimizzazione funzione Compiti | - Modifica tag esplicita e filtri<br/>- Ottimizzazione interazione modifica sotto-Compiti<br/>- Comportamento completamento forzato sotto-Compiti personalizzato<br/>- Comportamento scadenza o push personalizzato | - I Compiti sono la funzione core di LifeUp, ottimizzando continuamente modifica e esperienza di interazione. | P1 | 🚧 |
| Ricompense batch Compiti conteggio | - Supporto richiesta Ricompense batch per Compiti conteggio | - L'attuale meccanismo Ricompense Compiti conteggio è relativamente semplice, Ricompense batch possono fornire incentivi obiettivo più flessibili. | P1 | 🚧 |
| Ottimizzazione funzione Thought/Reflection | - Supporto più stili di navigazione | - La funzione Thought è caratteristica di LifeUp, ottimizzando continuamente visualizzazione e interazione. | P2 | 🚧 |
| Espansione Obiettivi | - Statistiche tipo settimanale/mensile/annuale<br/>- Sblocco altre condizioni Obiettivi | - Il sistema Obiettivi necessita condizioni di sblocco più diverse per un'esperienza Obiettivi più ricca. | P2 | 🚧 |
| Sistema dati | - Backup separato di dati e immagini<br/>- Supporto export/import parziale dati<br/>- Supporto cambio multi-file integrato | - Upload WebDAV di file grandi fallisce facilmente, i servizi cloud gratuiti hanno limiti di traffico, backup completo con immagini troppo grande.<br/>- Export/import parziale può essere usato dagli utenti per condividere sistemi di Ricompense.<br/>- Multi-file integrati permettono agli utenti di passare direttamente tra sistemi per debug senza cancellare ripetutamente i dati. | P1 | 🚧 |
| API | - Espandere capacità e copertura API a tutte le funzioni di base | - Mancano ancora alcune API come alcune operazioni relative a thought.<br/>- LifeUp non può essere all-in-one, ma l'API permette a tutti di personalizzare ed espandere il proprio LifeUp e realizzare una community open source. | P1 | 🚧 |
| Sviluppo **ulives** | - Continuare a migliorare funzioni **ulives**<br/>- Esplorare supporto multi-platform (iOS/iPadOS/macOS/altri) | - **ulives** è il prodotto di nuova generazione di LifeUp, sviluppato con tecnologia cross-platform moderna.<br/>- In futuro potrebbe espandersi ad Android o altre piattaforme. | P0 | 🚧 |

In sintesi:

1. Continueremo a seguire la direzione stabilita, concentrandoci su stabilità e ottimizzazione delle funzioni esistenti.
2. Miglioreremo continuamente la profondità funzionale di ogni modulo per migliorare l'esperienza utente.
3. Avanzeremo lo sviluppo **ulives** ed esploreremo più supporto piattaforma.
4. Continueremo a migliorare API e altri aspetti.

---

### II. Revisione e prospettive

#### 2.1 Su **ulives**

Nel 2025, abbiamo lanciato **ulives** su iOS come prodotto di nuova generazione di LifeUp. Alcuni utenti potrebbero chiedersi: perché lanciare una nuova app? Perché pagare di nuovo?

Ecco i nostri pensieri e spiegazioni:

**Vincoli tecnologici e architetturali**

LifeUp è sviluppata basandosi su tecnologia Android e ha accumulato molta logica e problemi di compatibilità storica durante lo sviluppo. Date le limitazioni architetturali tecniche, è quasi impossibile replicare una versione identica su iOS o HarmonyOS mantenendo compatibilità dati.

Inoltre, LifeUp si è sviluppata gradualmente, con alcuni design prodotto compromessi da compatibilità e decisioni di design iniziali, che potremmo non poter cambiare facilmente. Ad esempio:

- **Valuta personalizzata**: Il sottostante di LifeUp è un tipo di valuta, rendendo difficili cambiamenti architetturali maggiori.
- **Modulo World**: All'inizio dello sviluppo di LifeUp, a causa della cooperazione lato server, avevamo pianificato di aggiungere questo modulo, ma la maggior parte delle funzioni non erano state considerate a fondo, risultando in funzioni team carenti ora.

Creare qualcosa di nuovo ci permette di vedere questi da una nuova prospettiva prodotto con concetti moderni.

**Debito tecnico**

Tecnologicamente, LifeUp ha anche calciato alcune mine:

- Usare un framework ORM database adatto allo sviluppo rapido iniziale ma praticamente non mantenuto, rendendo difficile la migrazione.
- Il sottostante non supporta nemmeno indici compositi, causando colli di bottiglia performance.
- Abbiamo speso considerevole sforzo ottimizzando continuamente le performance app sotto grandi volumi di dati.

Per **ulives**, abbiamo usato tecnologia cross-platform moderna (Kotlin Multiplatform) per riesaminare e sviluppare questi aspetti. Possibilità future includono espansione ad Android o altre piattaforme (attualmente supporta solo iOS, iPadOS e macOS).

**Costi e pricing**

Il basso pricing una tantum iniziale di LifeUp e il posizionamento single-platform ci hanno lasciato controllo costi limitato per funzioni che richiedono investimento (come Modulo World o funzioni AI).

Il basso pricing di LifeUp (Android) si basa su costi di manutenzione single-platform. **ulives** potrebbe avere alcuni aggiustamenti e più pianificazione.

Poiché i team di sviluppo sono diversi, è uno sviluppo completamente nuovo, e **ulives** è attualmente completamente offline. Non possiamo infatti condividere membership o dare sconti extra, e potremmo non fornire tali sconti in futuro per evitare di danneggiare utenti paganti.

---

#### 2.2 Efficienza AI

Negli ultimi anni, abbiamo assistito allo sviluppo in boom dello sviluppo assistito da AI, dove molti sviluppatori possono usare AI per sviluppare app dopo app in breve tempo.

Infatti, proviamo anche a usare AI nel nostro processo di sviluppo per implementare rapidamente framework funzionali principali e scaffolding codice. Tuttavia, AI non è onnipotente — determinare percorsi soluzione tecnica, accettazione finale e garantire che tutto funzioni richiede ancora sforzo umano significativo.

Ciò che richiede davvero tempo è rifinire i dettagli. Specialmente per ottimizzazione animazioni piattaforma iOS, tuning fluidità interazione, gestione edge case — il tempo investito qui è spesso diverse volte quello della logica funzionale stessa.

---

#### 2.3 Estensioni utente e integrazione AI

Abbiamo anche visto molti utenti implementare funzioni interessanti usando AI combinata con l'API di LifeUp:

- Alcuni usano MCP (Model Context Protocol) per connettere LifeUp con varie toolchain AI
- Alcuni combinano LifeUp con app note come Obsidian per automazione workflow
- Alcuni implementano propri strumenti web e script automazione tramite API

Continuiamo a dare il benvenuto agli utenti che condividono metodi di estensione basati su AI, e non vediamo l'ora di vedere più idee interessanti!

---

#### 2.4 Ritmo di sviluppo e qualità

Insistiamo sulla manutenzione a lungo termine di LifeUp, **ulives** e le nostre altre app. Abbiamo già piani e obiettivi di sviluppo pluriennali per LifeUp, e continueremo ad avanzare.

Non perseguiremo il lancio rapido di nuove funzioni ignorando qualità e stabilità. Ogni funzione passa attraverso design attento, sviluppo, test e ottimizzazione per garantire che il prodotto finale consegnato possa resistere alla prova del tempo.

Ecco perché scegliamo di investire più tempo nell'approfondire e ottimizzare funzioni esistenti piuttosto che lanciare continuamente nuovi moduli funzionali.

---

#### 2.5 Highlights community

Abbiamo avuto la fortuna di incontrare molti utenti straordinari:

- Un utente ha riscontrato un problema crash strano di LifeUp. Dopo diversi round di scambio informazioni, ha esportato il log di sistema (bugreport) e usato AI per analizzare che era causato da corruzione dati calendario di sistema. Poiché LifeUp usa notifiche calendario, veniva erroneamente terminata dal sistema. Questo ci ha aiutato a identificare questo problema di compatibilità a livello di sistema estremamente oscuro.
- Molti utenti hanno condiviso le loro creazioni, inclusi sistemi Compiti interessanti, design Oggetti, condivisione Obiettivi e altro contenuto community.

Il supporto travolgente dei nostri utenti è ciò che ci spinge a continuare a mantenere e aggiornare i nostri prodotti.

---

> Anteprima: Nel 2025 abbiamo anche lanciato **ulives**, sviluppato usando Kotlin Multiplatform, attualmente supporta solo iOS, iPadOS e macOS, con piani di supportare più piattaforme in futuro.

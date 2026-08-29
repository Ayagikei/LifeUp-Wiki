# Piano di sviluppo 2024-2025

!> Questo è il nostro piano di sviluppo attuale. Faremo del nostro meglio per guidare miglioramenti e aggiornamenti del prodotto secondo questo piano. Tuttavia, a causa dell'ambiente in continuo cambiamento, il contenuto del piano di sviluppo può essere modificato o aggiunto/sottratto. Fa fede il rilascio prodotto effettivo.

### I. Piano di sviluppo

> Aggiornato: 2025/09/14

| Modulo | Sottofunzione | Motivo del requisito | Priorità | Risultato |
| ---- | ------ | -------- | ------ | ---- |
| Capacità di base (1) | Selezione multipla Oggetti e auto-uso Oggetti all'acquisizione | ~ | P0 | ✅ Selezione multipla rilasciata in v1.94<br/>✅ Auto-uso Oggetti rilasciato in v1.96 |
| Capacità di base (2) | Popup Ricompense generalizzato (supporto qualsiasi numero di Attributi e Oggetti) | ~ | P0 | ✅ Rilasciato in v1.96; impostazioni da allentare in versioni future |
| Capacità di base (3) | Gestione risorse audio ed effetti sonori Oggetti | ~ | P0 | ✅ Rilasciato |
| Capacità di base (4) | Ottimizzazione notifiche | ~ | P0 | ✅ Rilasciato |
| Adattamento schermo grande (tablet/pieghevole) | Adattamento tablet e pieghevoli basato su Activity embedding | ~ | P1 | ✅ Previsto in v1.95 |
| Widget | Espansione widget (widget Inventario) | ~ | | ✅ Rilasciato in v1.94 |
| Integrazione calendario | - Sincronizzazione bidirezionale Google Calendar<br/>- Sincronizzazione bidirezionale calendario di sistema | - Molti feedback dall'estero.<br/>- LifeUp è uno strumento to-do con funzioni sovrapposte ma incoerenti rispetto alle app di agenda (calendario). | P1 | 🚧 |
| API | - Espandere capacità API per coprire tutte le funzioni di base<br/>- Completamento funzioni client desktop, supporto backup/ripristino, ecc. | - Mancano ancora molte API come la modifica.<br/>- LifeUp non può essere all-in-one, ma l'API permette personalizzazione ed espansione. | P1 | 🚧 Previsto in v1.98.x |
| Obiettivi | - Obiettivi ripetibili | ~ | P2 | ✅ Rilasciato |
| Sistema dati | - Backup separato di dati e immagini<br/>- Supporto export/import parziale dati<br/>- Supporto cambio multi-file integrato | - Upload WebDAV di file grandi fallisce facilmente.<br/>- Export/import parziale può essere usato per condividere sistemi di Ricompense.<br/>- Multi-file integrati per test facili senza cancellare dati. | P1 | 🚧 |
| Multi-platform (direzione Flutter) | - Continuare a imparare e usare Flutter per versione cross-platform | - Sviluppo prototipo versione iOS | P2 | 🚧 In pausa |
| Multi-platform (direzione KMP) | - Esplorare più possibilità usando KMP | - Esplorare e imparare tecnologia KMP per il futuro | P0 | ✅ Rilasciato ulives - nuova app iOS |

In sintesi:

1. Implementeremo la direzione stabilita in precedenza: stabilità e ottimizzazione delle funzioni esistenti, senza aggiungere arbitrariamente nuovi moduli funzionali.
2. Useremo una o due versioni principali per risolvere alcuni difetti funzionali di base e pain point.
3. Poi procederemo con integrazione calendario e Obiettivi ripetibili.
4. Continueremo a migliorare API e altri aspetti.

Multi-platform sarà uno dei nostri obiettivi chiave per il 2024.

---

### II. Revisione 2023

Il percorso di sviluppo semi-amatoriale e semi-hobby di LifeUp ha superato il quinto anniversario, entrando nel sesto anno. Abbiamo rilasciato centinaia di versioni, con quasi 5000 commit di codice solo sul repository Android.

<br/>

Sebbene il piano di sviluppo proposto nell'ottobre 2022 si concentrasse sull'approfondimento del sistema funzionale di LifeUp, a causa dei cambiamenti ambientali abbiamo comunque incontrato molti ostacoli e problemi lungo la strada.

#### 1.1 Ambiente

Esempi tipici includono:

- Essere colpiti da false segnalazioni «anti-frode» in alcune province senza canale di ricorso, richiedendo diversi round per risolvere alcuni problemi. Ma di recente ci sono state di nuovo false segnalazioni nello Shandong, e non abbiamo ancora trovato un percorso di ricorso o riproduzione.
- Gli standard di revisione del mercato Android domestico cinese aumentano strato dopo strato, con standard incoerenti tra mercati e personale, e revisori non professionali.
  - Alcuni mercato app rifiutano spesso revisioni su parti invariate.
  - Un mercato app V ha quasi rifiutato la nostra app LifeUp usando «conformità privacy» come motivo. Il mercato richiedeva alla nostra app di richiedere [permesso lettura tutti i file] o [permesso lettura tutte le foto] con spiegazioni corrispondenti, così gli utenti potevano selezionare immagini dall'album. Tuttavia, LifeUp usa un approccio più protettivo della privacy, non ha bisogno di tali permessi e non legge direttamente i file dell'utente. Invece, la nostra app salta all'app album integrata di sistema e riceve solo l'immagine selezionata dall'utente, garantendo la massima protezione della privacy.
    Ma i revisori non conoscevano questa best practice, e ci sono voluti diversi giorni lavorativi di comunicazione con il servizio clienti per ottenere l'approvazione.

<br/>

Per ridurre l'impatto ambientale su di noi:

Abbiamo rafforzato il meccanismo di aggiornamento in-app e ridotto la frequenza di invio per revisione di mercato.

La versione domestica ora supporta aggiornamenti in-app e può passare tra canali stable o beta.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Abbiamo anche aggiornato il sito ufficiale (https://lifeupapp.fun/en/index.html) come canale di download alternativo.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Per rendere più conveniente per tutti scaricare e installare l'app tramite il sito, evitando rischi e ritardi di revisione di mercato.

Le richieste di rete in-app hanno anche aggiunto canali di backup per alleviare e prevenire problemi di accesso causati da false segnalazioni in alcune province.

<br/>

Con standard di revisione sempre più rigorosi, e avendo assistito a vari ostacoli incontrati da altri sviluppatori indipendenti nel mercato Android domestico,

si può dire che per gli sviluppatori indipendenti, la piattaforma Android domestica non è più il target di lancio ideale in prima scelta.

Dopotutto, Android domestico ha i requisiti di qualifica più rigorosi e gli standard di revisione più complessi e **mutevoli**.

> Ma ironicamente, allo stesso tempo, alcune app copia di bassa qualità possono salire facilmente sugli scaffali e segnare «ispezione manuale superata».

Questo potrebbe spiegare perché molte opere di sviluppatori indipendenti viste su Xiaohongshu hanno solo versioni iOS.

Google Play e App Store restano la prima scelta.

?> Tutti possono prestare più attenzione e supporto agli sviluppatori indipendenti e ai piccoli team che continuano ad aderire alla piattaforma Android domestica~

<br/>

Quindi, nel 2024:

- Sposteremo le parti non completate del piano precedente in questo periodo, come integrazione calendario, Obiettivi ripetibili, capacità di base, sistema dati, ecc.
- Lo sviluppo multi-platform sarà un obiettivo importante per noi, possibilmente includendo due direzioni:
  - Usare Flutter per replicare LifeUp (a causa di personale limitato, questo sarà avanzato dal nostro collega backend - Xiao Xiao)
  - Esplorare più possibilità usando KMP (Kotlin Multiplatform)

#### 1.2 Crescita utenti domestica

Inoltre, LifeUp ha avuto una crescita significativa di utenti nel mercato app cinese nel 2023. Grazie a tutti per il supporto!

- Per ridurre il tempo speso nell'emissione manuale di codici di riscatto e concentrarsi di più sullo sviluppo: nel 2023 abbiamo collegato inoltre metodi di pagamento automatizzati (WeChat, Alipay) e supportato login WeChat.
  - Questo ci ha liberato molto tempo.

- Nel 2023, c'è stata una diffusione utenti su Qzone che ha di nuovo mandato in crash il nostro server per diversi giorni.
- Abbiamo anche provato a gestire account pubblico WeChat, Xiaohongshu, Bilibili, ecc., per promuovere e presentare aggiornamenti LifeUp e utilizzi creativi.

- Attraverso discussioni con altri sviluppatori indipendenti, abbiamo scoperto che la maggior parte ha vissuto difficoltà simili, scegliendo infine di chiudere certi canali di messaggistica istantanea e social media. Ci identifichiamo profondamente.
  - Nelle grandi aziende, di solito ci sono team di assistenza clienti dedicati o bot per gestire numerose richieste, trasformandole efficacemente in esigenze specifiche o feedback problemi per gli sviluppatori.
  - **Ma gli sviluppatori indipendenti generalmente devono sopportare lavoro di assistenza clienti e operazioni; gestire utenti irragionevoli consuma il 100% del tempo di sviluppo di questo sviluppatore indipendente, influenzando infine lo sviluppatore, il prodotto e gli utenti core del prodotto.**
  - Pertanto, tendiamo sempre più a raccomandare agli utenti di fornire feedback via email, ecc.

<br/>

Quindi, nel 2024:

- Continueremo a ridurre l'investimento umano in lavoro di consulenza ripetitivo, e invece miglioreremo documentazione e FAQ. Anche se esiste consulenza, sarà gestita uniformemente tramite email, canale QQ, ecc.
- Provare una piccola quantità di operazione social media.

#### 1.3 Crescita utenti estero

All'inizio del 2022, siamo entrati in Google Play Pass e abbiamo visto un'ondata di crescita utenti.

Ma questa crescita non è durata a lungo; a metà 2022, la crescita utenti è diminuita gradualmente in modo significativo, senza segni di miglioramento.

Poiché LifeUp è un'app ad acquisto una tantum, la crescita utenti è molto importante per noi, ed è la base per continuare a operare e avere la possibilità di sviluppare a tempo pieno in futuro.

Abbiamo provato molti metodi per migliorare la crescita:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Assunto un designer professionista per ridisegnare le immagini promozionali dello store
- Migliorato supporto multilingua app e immagini promozionali
- Migliorata descrizione app
- Migliorata documentazione getting started
- Aumentata frequenza aggiornamenti
- ...

Sebbene abbiamo implementato molti metodi e migliorato alcuni indicatori. Non siamo riusciti a tornare a un periodo di crescita stabile.

Abbiamo potuto solo lasciar correre.

<br/>

La buona notizia è che alla fine del 2023, sembra esserci qualche miglioramento.

<br/>

Quindi, nel 2024:

- Migliorare la costruzione internazionalizzazione (documentazione, supporto lingua in-app, ecc.).

#### 1.4 Gestione qualità

Poiché LifeUp è un'app strumento offline sviluppata e testata solo da me, evitare problemi crash gravi è particolarmente importante.

Il processo di iterazione versione nel 2023 ha richiesto più tempo rispetto a prima, e abbiamo riservato tempo sufficiente per beta testing per garantire preparazione approfondita.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Queste misure sembrano prevenire efficacemente crash gravi su larga scala.

Tuttavia, ogni aggiornamento versione porta inevitabilmente alcuni problemi, inclusi alcuni su percorsi critici.

Pertanto, continueremo a migliorare la gestione qualità di LifeUp, con stabilità come indicatore più importante (specialmente sotto l'ambiente sempre più severo e le sfide di revisione).

<br/>

Quindi, nel 2024:

- Rafforzare la gestione qualità.

#### 1.5 Approfondimento funzioni

Come menzionato nell'articolo del terzo anniversario, LifeUp è un'app che ha esplorato e cresciuto gradualmente.

Quindi cose come Negozio, Obiettivi personalizzati, API tali funzioni non erano nel piano iniziale, ma sono state sviluppate e aggiunte gradualmente con aggiornamenti e feedback.

Ma questo ha anche introdotto alcuni problemi:

- Alcuni moduli hanno dettagli di pianificazione approssimativi.
  - Ad esempio, le Ricompense Oggetti inizialmente consideravano solo Ricompense singole.
  - Attributi e altri sistemi non consideravano inizialmente la personalizzazione, e solo refactoring graduale poteva supportare aggiunte/rimozioni e Livelli personalizzati, ecc.
  - Ci sono molti problemi simili, come popup Ricompense/penalità Attributi e visualizzazione cronologia supportano al massimo 3.
- Questi moduli appena aggiunti mancano di analisi e pianificazione complessiva per l'app.

Continueremo nella direzione indicata nell'articolo del terzo anniversario, approfondendo i moduli funzionali esistenti dell'app e risolvendo alcuni pain point, piuttosto che perseguire nuovi moduli funzionali.

Ad esempio, supporteremo Ricompense Oggetti multi-selezione dirette, miglioreremo meccanismo backup, ottimizzazione notifiche, completamento widget, ecc.

#### 1.6 API ed estensibilità

Come menzionato sopra, non pianifichiamo più di introdurre nuovi moduli funzionali.

Ma ci saranno sicuramente richieste di estendere l'app.

Quindi abbiamo introdotto la funzione API nel 2023.

Forniamo il nucleo di LifeUp come capacità di base.

Anche se gli utenti non capiscono programmazione, possono usare strumenti di automazione come Tasker/MacroDroid per estendere funzioni, ottenendo capacità di automazione.

Esempi tipici includono:

- NFC, QR code per completare Compiti
- Auto check-in al risveglio
- Widget personalizzati
- E così via...

Se gli utenti capiscono programmazione, possono estendere ancora più gameplay o persino App da questo.

![img](_media/development_plan_2024/desktop.png)

Abbiamo anche sviluppato una semplice versione desktop basata su API (e open-sourced).

Anche dopo diverse versioni di espansione API, ci mancano ancora molte capacità.

Ad esempio, non supportare operazioni relative a «thought», non supportare aggiornamento dati tramite Content Provider, ecc.

Continueremo ad espandere API nel 2024 per coprire ogni aspetto dell'app il più possibile.

> Sebbene attualmente vediamo molti utenti che usano API per uso personale, ci sono ancora pochi prodotti condivisi eseguibili. Dobbiamo continuare a fornire capacità API più forti per costruire un ecosistema API.

#### 1.7 Sul futuro

Con i problemi sopra e i cambiamenti ambientali, abbiamo anche gradualmente regolato il prezzo membership a vita di LifeUp (anche così, il pricing membership di LifeUp è di gran lunga inferiore alla maggior parte delle altre app), e gli aggiornamenti tenderanno gradualmente a fornire funzioni come funzioni membership.

Realizziamo gradualmente che le app servono in ultima analisi gli utenti core.

Il feedback e il supporto degli utenti core possono essere riflessi infine nei miglioramenti app, realizzando co-creazione e ciclo positivo tra sviluppatore e utenti.

Se proviamo a compiacere tutti, l'app diventerà un pasticcio di codice, devierà dalle richieste degli utenti core e ridurrà guadagni e motivazione dello sviluppatore.

<br/>

Abbiamo menzionato KMP (Kotlin Multiplatform) sopra, che è una tecnologia cross-platform relativamente emergente. Può anche usare capacità native miste.

Durante lo sviluppo di LifeUp, abbiamo gradualmente avuto alcune nuove idee. Ma non tutte le idee possono o sono adatte ad atterrare su LifeUp.

Ad esempio, sostituire l'intera UI, cambiamenti maggiori alla logica Negozio, ecc., che impatterebbero inevitabilmente seriamente l'esperienza degli utenti esistenti. Abbiamo anche visto molti casi di cambiamenti maggiori app che portano al fallimento.

<br/>

Inoltre, quando LifeUp è stata sviluppata inizialmente, il framework database ufficiale «Room» non era ancora disponibile, quindi abbiamo scelto un framework database di nicchia domestico.

Ora alcuni problemi di performance sono diventati evidenti, ed è difficile sostituirlo.

Inoltre, LifeUp ora supporta sia Material 3 che Material Design legacy, più dark mode, multilingua, frammentazione sistema telefono domestico (documentazione configurazione compatibilità diventa solo più lunga, sistemi nativi e versioni estero generalmente necessitano solo configurazione pagina singola) e altri problemi. Ogni pagina deve considerare molte cose complesse.

<br/>

Quindi abbiamo pianificato di esplorare KMP per vedere se possiamo usare qualche tecnologia con KMP.

Anche per avere la possibilità di implementare più idee e nuovi progetti in futuro - più competenze non fanno male.

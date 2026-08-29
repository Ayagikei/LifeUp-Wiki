# Domande frequenti

LifeUp è mantenuta da due compagni indie nel tempo libre:

- Uno sviluppatore si occupa principalmente dell'App.
- Un compagno si concentra sui servizi backend e sulle operazioni.

## Dietro l'App indie

Quando abbiamo lanciato LifeUp nel 2020, le app indie erano ancora relativamente rare. Nel 2026, sviluppatori e app indie sono ovunque — ed è una bella cosa.

Ma abbiamo anche visto molte tendenze poco salutari: pubblicare una nuova app ogni mese o due e abbandonarla dopo il lancio; app costruite interamente con codice generato dall'IA senza vera ingegneria dietro, piene di bug, con prestazioni scarse e impossibili da mantenere; prezzi aggressivi spinti dall'hype che passano da decine a centinaia di dollari prima che l'App sia finita, con post urgenti sui forum che spingono a comprare un abbonamento a vita «prima che sia troppo tardi»; oppure app che incassano un abbonamento a vita sulla v1, la mantengono appena, poi «rinascono» improvvisamente con una v2.0 per rivendere abbonamenti a vita — solo perché l'App resti non mantenuta, si rompa o venga rimossa dallo store, rendendo quegli abbonamenti a vita di fatto inutili.

Al contrario, LifeUp è costruita da sviluppatori che tengono al mantenimento a lungo termine: ~6 anni di iterazione continua con oltre 400 release. Abbiamo mantenuto il modello di acquisto una tantum, e i nostri prezzi sono rimasti molto al di sotto della maggior parte delle app comparabili, anche dopo modesti aggiustamenti nel corso degli anni. LifeUp offre in modo unico anche un'[API](/guide/api.md) e un [client desktop open source](/guide/api_desktop.md), così puoi integrare LifeUp nei tuoi flussi di lavoro con l'IA e le tue competenze di sviluppo — o persino costruirci sopra. LifeUp supporta anche backup con esportazione completa dei dati, che includono i file multimediali originali e un database SQLite — così possiedi e controlli sempre i tuoi dati. Puoi convertirli in formati compatibili con altre app, farli analizzare dall'IA per generare grafici e altro (tutto ciò è possibile anche — e in modo più diretto — tramite l'API). Puoi persino importare il backup direttamente in [ulives](https://app.ulives.io/), la nostra nuova App per iOS.

Alcune funzioni e dettagli dell'interfaccia sono ancora in fase di rifinitura, e le stiamo migliorando passo dopo passo.

Se LifeUp ti aiuta, condividerla con altri è un grande aiuto anche per noi.

Se vuoi sostenere lo sviluppo, puoi anche offrirci un caffè nella pagina **About** dell'App.

## ⚙️ Configurazione di compatibilità

Se riscontri problemi come:

- promemoria che non scattano
- promemoria Pomodoro o countdown degli Oggetti che non funzionano in background
- azioni del widget che falliscono (ad esempio, impossibilità di spuntare Compiti a conteggio)
- problemi di aggiornamento del widget

leggi la guida alla compatibilità:

> [!WARNING]
> [Configurazione di compatibilità](/guide/compatibility.md)

## 🌍 Generale

<details>
<summary>Politica di rimborso</summary>

LifeUp è attualmente pubblicata come App a pagamento su Google Play per ragioni storiche, il che rende difficile migrare a un modello di pagamento post-download.

Google Play può rimborsare automaticamente il tuo ordine se disinstalli poco dopo l'acquisto.

Se quel rimborso automatico non avviene, contattaci entro **7 giorni** a [lifeup@ulives.io](mailto:lifeup@ulives.io).
Includi il numero d'ordine GPA e invia l'email dallo stesso account Google usato per l'acquisto.

Per motivi anti-abuso, possiamo offrire supporto al rimborso manuale solo **una volta per utente**.
Non possiamo elaborare richieste di rimborso dopo 7 giorni dalla data di acquisto.

Nota: le recensioni su Google Play non includono abbastanza dettagli sull'ordine per gestire i rimborsi.

</details>

<details>
<summary>I miei dati sono privati e sicuri?</summary>

Sì. Prendiamo sul serio la privacy.

La maggior parte dei dati resta sul tuo dispositivo e non passa dai nostri server.

L'eccezione principale è il modulo Comunità, dove gli utenti possono condividere pubblicamente design e modelli.
Tutta la condivisione lì è opt-in: nulla viene pubblicato a meno che tu scelga di condividere, e puoi eliminare i contenuti condivisi in qualsiasi momento.

Puoi leggere di più nella nostra [Informativa sulla privacy](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms).

</details>

<details>
<summary>Come posso fare il backup dei miei dati se i server non li archiviano?</summary>

LifeUp supporta backup di esportazione/importazione e destinazioni di backup in stile cloud.

Puoi usare:
- File di backup esportati
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Perché non c'è la lingua XX? O perché la traduzione è incompleta e viene mostrata in inglese?</summary>

La maggior parte delle lingue in *LifeUp* è mantenuta dalla community.

A partire dal 2026, useremo la traduzione IA per le lingue principali, per migliorare la qualità di base e accelerare gli aggiornamenti.

Revisioni e correzioni da parte della community sono sempre benvenute.

Puoi contribuire qui: [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Posso nascondere il modulo Comunità se non mi serve?</summary>

Sì.

Puoi personalizzare la barra di navigazione inferiore in:
`barra laterale` → `Impostazioni` → `Visualizzazione` → `Configurazione Del Modulo`.

Da lì, puoi nascondere il modulo Comunità o sostituirlo con un altro modulo.

</details>

<details>
<summary>Il pedometro è impreciso, o non ho bisogno di questo modulo?</summary>

> Puoi toccare la piccola icona del punto interrogativo accanto al pedometro nell'App per vedere come funziona.

- Per una maggiore precisione, apri l'App al mattino e alla sera, ed evita riavvii frequenti del dispositivo.
- Puoi anche inserire manualmente il conteggio dei passi.
- Se non ti serve, nascondi il pedometro in `Impostazioni` → `Visualizzazione`.

</details>

## ✅ Compiti

<details>
<summary>Posso nascondere la finestra di dialogo delle Ricompense al completamento di un Compito?</summary>

Sì. Nel flusso di completamento normale, la finestra di dialogo delle Ricompense appare solo quando un Compito ha Ricompense configurate, come Punti Esperienza (XP) o Oggetti. Se lasci le Ricompense non impostate, completare il Compito non mostrerà questa finestra.

Consigliamo anche di scegliere un intervallo di completamento sensato invece di dividere un'attività in molti Compiti piccoli. Questo riduce sia il lavoro di configurazione sia il numero di azioni di completamento.

Se vuoi mantenere le Ricompense ma saltare le finestre di completamento, puoi usare una di queste opzioni:

- **Quick Complete:** Attiva `Completamento rapido` nell'angolo in alto a destra dell'elenco Compiti. Una volta attivato, toccare il cerchio completa un Compito direttamente senza mostrare la finestra delle Ricompense.
- **Scorri per completare:** Vai a `barra laterale` → `Impostazioni` → `Compito` → `Swipe` → `Modifica azioni di swipe`. Seleziona `Swipe a Sinistra` o `Swipe a Destra`, poi imposta l'azione su `Termina (nessuna Finestra)`.

Entrambe le opzioni senza finestra concedono comunque le Ricompense configurate, ma saltano anche altre finestre di completamento, incluso l'inserimento delle Sensazioni e l'uso automatico degli Oggetti.

</details>

<details>
<summary>Come annullo un Compito completato?</summary>

Puoi annullare il completamento in diversi punti:

1. Subito dopo il completamento, tocca **Undo** nel prompt in basso.
2. In `barra laterale` → `Cronologia`, tocca `Annulla`.
3. In `Calendario` → `Concluso`, tocca `Annulla`.

Se la scadenza del Compito è già passata, l'annullamento diretto non è disponibile.
In tal caso, modifica lo stato del record (ad esempio, impostalo come scaduto o abbandonato).

</details>

<details>
<summary>Come segno un Compito scaduto come completato?</summary>

Quando un Compito scade, appare una finestra di scadenza che ti permette di segnarlo come completato.

Dopo aver chiuso la finestra, puoi comunque aggiornare lo stato del Compito in seguito da:
- `barra laterale` → `Cronologia`
- `Calendario` → `Concluso`

</details>

<details>
<summary>C'è una penalità di EXP/monete per il fallimento di un Compito?</summary>

Sì.

- La penalità EXP è attiva per impostazione predefinita (fattore: `0.2x`).
- La penalità monete è disattivata per impostazione predefinita (fattore: `0`).

Puoi modificare le impostazioni globali in:
`barra laterale` → `Impostazioni` → `Avanzate`

Puoi anche impostare penalità per Compito nell'editor dei Compiti.

</details>

<details>
<summary>Come funziona il meccanismo di ripetizione?</summary>

Imposta solo la `Inizio`, la `deadline`, la frequenza di ripetizione e l'ora del promemoria opzionale del **primo** ciclo.

LifeUp calcolerà poi i cicli successivi automaticamente.

</details>

<details>
<summary>Come configuro un Compito che deve essere completato N volte in modo irregolare entro un periodo?</summary>

LifeUp non ha ancora un'impostazione diretta per «almeno/al massimo N volte per ciclo». Tuttavia, puoi ottenere questo risultato in diversi modi:

| Metodo | Configurazione | Pro | Contro |
| :--- | :--- | :--- | :--- |
| **Counting Task** | Imposta la frequenza su `Settimanale`, attiva `Contare Attività`, imposta il conteggio (es. 3). | Configurazione semplice; il progresso è chiaro (es. 1/3). | **Le Ricompense vengono concesse solo dopo il completamento del conteggio finale.** Nessuna Ricompensa per i singoli completamenti. |
| **Infinite Task + Target** | Imposta la frequenza su `Illimitato`, il conteggio obiettivo su 3, la scadenza su domenica. | **Le Ricompense vengono concesse a ogni completamento.** | **Deve essere ricreato manualmente ogni settimana** (poiché il Compito termina dopo il completamento). |
| **Subtasks** | Imposta la frequenza su `Settimanale`, aggiungi 3 sottocompiti all'interno. | Puoi impostare Ricompense e promemoria individuali per ogni completamento. | Richiede di entrare nella pagina di dettaglio per spuntare i sottocompiti; devono essere creati manualmente uno per uno (adatto solo a conteggi piccoli). |
| **Infinite Task (Stats Only)** | Imposta la frequenza su `Illimitato`. | Configurazione più semplice; Ricompense e statistiche a ogni completamento. | **Nessun vincolo forzato.** Devi controllare manualmente le statistiche per vedere se hai raggiunto l'obiettivo settimanale. |

> [!NOTE]
> Stiamo valutando l'aggiunta di una funzione «Ricompensa in tempo reale» per i **Counting Task** (Ricompensa immediata a ogni conteggio), attualmente in fase di valutazione.

</details>

<details>
<summary>Come nascondo Compiti completati o non ancora iniziati?</summary>

Di solito succede in uno di questi casi:

1. Se un Compito mostra `xx deadline`, quel Compito è già iniziato.
   - Modifica il Compito e regola la `Inizio` se necessario.

2. Se un Compito mostra `xx starts` e la data non è oggi:
   - Controlla se il pulsante pieghevole in basso è collassato.
   - Apri il menu in alto a destra (`...`) → `Filtro`.
   - Conferma che `Mostra Oggi` sia attivato.

> Nota:
> - Le liste intelligenti (settimana/mese) non supportano la piegatura.
> - Per i Compiti ripetitivi, un ciclo completo è valido per impostazione predefinita. Ad esempio, un ciclo di 21 giorni può essere completato in qualsiasi di quei 21 giorni. Se vuoi che sia visibile solo verso la fine, regola la start time una volta e lascia che LifeUp calcoli automaticamente i cicli successivi.

</details>

<details>
<summary>Come evito che i Compiti scadano a mezzanotte?</summary>

Il momento della scadenza è controllato dall'ora di deadline del Compito.

Dopo aver impostato la data di scadenza, tocca il pulsante `time` e scegli un'ora più tarda.

Ad esempio, se non vuoi che un Oggetto scada alle `00:00`, imposta l'ora di scadenza su qualcosa come `02:00` (giorno successivo).

Puoi anche modificare i valori predefiniti globali in:
`Impostazioni` → `Item` → `Nuova impostazione predefinita dell'attività`

(Le modifiche ai valori predefiniti non influiscono sugli Oggetti esistenti.)

</details>

<details>
<summary>Perché il numero obiettivo di volte parte da 1/N?</summary>

A differenza dei Compiti a conteggio, (1/N) **qui non rappresenta il progresso totale.**

Invece, **indica il conteggio di ripetizione corrente. Se questa ripetizione è completata si mostra con ⚪ o ✅.**

<br/>

Ad esempio, ⚪1/10 significa:
Questo Compito sarà ripetuto 10 volte in totale (verranno generate 10 schede in totale), ed è attualmente alla 1ª volta e non è stato completato.

E ✅1/10 significa:
La scheda corrente appartiene alla 1ª volta ed è completata.

Se si usasse il progresso totale, le schede completate mostrerebbero stati confusi come (⚪1/10 e ✅1/10 che coesistono). Inoltre, le schede potrebbero scomparire al raggiungimento dell'obiettivo (es. ✅9/10), il che è controintuitivo.

</details>

<details>
<summary>Come imposto più promemoria per un Compito?</summary>

Crea sottocompiti e assegna descrizioni/ore di promemoria diverse a ciascuno.

Questo è il modo consigliato per simulare più promemoria per un Compito principale.

</details>

<details>
<summary>I sottocompiti possono essere mostrati direttamente nell'elenco Compiti?</summary>

Al momento no. Potremmo valutarlo in futuri aggiornamenti.

</details>

## 🎁 Ricompense (Punti Esperienza, beni)

<details>
<summary>Posso assegnare valori EXP diversi a Attributi diversi per un Compito?</summary>

Non direttamente nella versione attuale.

Per una configurazione rapida, un Compito usa attualmente un valore EXP per Attributo. Se ti servono valori EXP diversi per Attributo, usa questo workaround:

1. Crea un Oggetto.
2. Configura effetti EXP diversi per Attributi diversi su quell'Oggetto.
3. Imposta l'Oggetto per l'uso automatico dopo il completamento del Compito.

Questo ti dà il completamento del Compito + effetto dell'Oggetto come flusso di Ricompensa combinato.

Pianifichiamo di migliorare il supporto nativo per questo nelle versioni future.

</details>

<details>
<summary>Come vengono calcolati automaticamente EXP e monete?</summary>

EXP dipende principalmente da:
- `Difficoltà`
- `Importanza`
- `number of selected attributes`

Le monete dipendono principalmente da:
- `Difficoltà`
- `Importanza`

</details>

<details>
<summary>Come viene calcolato il Livello di vita?</summary>

L'EXP del Livello di vita è correlato positivamente all'EXP guadagnato da qualsiasi Attributo.

Quando si applicano penalità, l'EXP del Livello di vita viene ridotto proporzionalmente.

Il Livello di vita è progettato come indicatore ampio e aggregato, quindi non consigliamo di concentrarsi eccessivamente sulla formula.

Ciò che conta di più è che rifletta il tuo progresso complessivo a lungo termine.

Riferimento formula: ogni azione di guadagno/perdita EXP contribuisce per 1/5 all'EXP del Livello di vita, indipendentemente da quanti Attributi vengono ricompensati in quell'azione.

</details>

<details>
<summary>Posso impostare Ricompense personalizzate di EXP e monete per i Compiti?</summary>

Sì.

Quando crei un Compito o un Obiettivo, tocca il pulsante Ricompensa corrispondente e configura i valori manualmente.

</details>

<details>
<summary>Perché le immagini degli Oggetti mancano o non vengono visualizzate?</summary>

LifeUp è offline-first, quindi le immagini degli Oggetti sono archiviate localmente sul tuo dispositivo.

Se mancano immagini, controlla cosa è successo di recente:

**Dopo l'importazione di un backup:**
- Il backup potrebbe non includere i file immagine.
- Reimporta un backup completo che includa le immagini.

**Dopo operazioni di pulizia/gestione file:**
- LifeUp non elimina attivamente i file immagine.
- Strumenti di pulizia/gestione file di terze parti con permessi ampi possono eliminarli per errore.
- Usa tali strumenti con cautela.

**Per Oggetti importati da Comunità:**
- Potrebbe trattarsi di un problema temporaneo di caricamento di rete.
- Riprova più tardi, o sostituisci con immagini locali.

Se hai ancora un vecchio backup con immagini, puoi ripristinare prima quel backup per recuperare i media, poi ripristinare il backup dati più recente.

</details>

<details>
<summary>Come elimino un Oggetto dal Negozio?</summary>

Nella pagina `Negozio`, tieni premuto l'Oggetto, poi tocca il pulsante `Cancella` in alto.

</details>

<details>
<summary>Come azzero EXP e monete?</summary>

Vai a:
`barra laterale` → `Impostazioni` → `Backup Dati/Ripristino/Pulizia`

Puoi azzerare i valori di EXP e monete lì.

Nota: se usi funzioni online, le visualizzazioni correlate lato server possono richiedere un breve periodo per aggiornarsi.

</details>

<details>
<summary>Quali sono i limiti di Livello e i gradienti di esperienza per gli Attributi?</summary>

Può essere considerato come Livelli illimitati (attualmente 2000+, difficili da raggiungere con mezzi normali).

L'esperienza richiesta per ogni Livello aumenta, anche se il gradiente attuale è ripido. (Quindi, le Ricompense non dovrebbero essere valutate solo in base ai limiti di Livello; il limite di esperienza è circa 2^63).

In effetti, molti utenti rimarranno a lungo nel gradiente da 2500 EXP. Potremmo ottimizzare il sistema di Livelli o consentire la personalizzazione in futuro. (I Punti Esperienza totali non saranno influenzati).

| Livello    | Punti Esperienza richiesti per ogni Livello |
| -------- | ----------------------------------------- |
| 1 → 2     | 300                                       |
| 2 → 3     | 700                                       |
| 3 → 4     | 1500                                      |
| 4 → 99    | 2500                                      |
| 99 → 150  | 5000                                      |
| 150 → 200 | 7500                                      |
| 200 → 250 | 15000                                     |
| 250 → 300 | 30000                                     |
| 300 → 325 | 50000                                     |
| 325 → 350 | 100000                                    |
| >350     | 500000                                    |

</details>

<details>
<summary>Come configuro prestiti, interessi ATM e interessi sui prestiti?</summary>

Nella pagina `Negozio`, apri il menu in alto a destra (`...`) e seleziona `Impostazioni`.

</details>

<details>
<summary>Come personalizzo Attributi o Abilità?</summary>

Vai a:
`barra laterale` → `Impostazioni` → `Avanzate` → `Personalizza gli attributi`

Puoi personalizzare Attributi esistenti, creare nuovi Attributi per Abilità ed eliminare Attributi secondo necessità.

Se vuoi tracciare Abilità, crea Attributi con il nome dell'Abilità (ad esempio, `Fishing` o `Programming`).

</details>

<details>
<summary>Posso modificare gli Attributi usati dalle Ricompense sportive o dalle Ricompense like-count di Comunità?</summary>

Non nella versione attuale.

Queste mappature di Ricompensa integrate sono fisse per ora.

</details>

<details>
<summary>Come configuro Ricompense Bottino?</summary>

Quando crei un Oggetto del Negozio, aggiungi un effetto `Bottino` a quell'Oggetto.

Poi configura pool di Ricompense, probabilità e impostazioni correlate in quell'effetto.

</details>

<details>
<summary>Posso impostare una probabilità Bottino inferiore all'1%?</summary>

Sì.

Dopo aver configurato l'effetto Bottino, tocca il pulsante di aiuto `?` nell'App per dettagli sulla probabilità e guida alla configurazione.

</details>

<details>
<summary>Come posso ottenere più icone?</summary>

Siamo un piccolo team indie e al momento non possiamo mantenere un ampio set di icone integrate.

Puoi ottenere più icone in questi modi:

1. Importa Oggetti da `Comunità` → `Mercato` e riutilizza le loro icone.
2. Usa risorse di icone esterne (assicurati che i diritti d'uso siano validi):
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Se possibile, preferisci icone con sfondo trasparente per una migliore visualizzazione nell'App.

</details>

<details>
<summary>Cosa fare se le immagini dei prodotti non possono essere visualizzate o mancano?</summary>

LifeUp è un'App offline. Le immagini dei prodotti vengono salvate sul tuo dispositivo e archiviate in modo sicuro nella directory privata dell'App. Non possiamo investigare direttamente le modifiche ai file sul tuo dispositivo.

Se le immagini dei prodotti sono perse o non possono essere visualizzate, pensa a quali operazioni hai eseguito di recente:

**Se mancano immagini dopo il ripristino di un backup:**
- Di solito è perché il file di backup non contiene file immagine
- Devi reimportare un backup completo che includa file immagine

**Se le immagini sono state eliminate accidentalmente:**
- LifeUp di per sé non elimina proattivamente file immagine
- Se hai usato di recente la funzione di gestione immagini, potresti aver eliminato immagini per errore e puoi provare a ripristinarle da un backup
- Inoltre, alcune app di pulizia di sistema con permessi elevati possono eliminare file immagine; usa tali app con cautela
- Se hai un backup più vecchio con immagini, fai prima il backup dei dati attuali, poi ripristina il backup vecchio per recuperare le immagini, quindi ripristina i dati attuali

**Se le immagini dei prodotti importate dal modulo Comunità non possono essere visualizzate:**
- Potrebbe essere causato da problemi di rete
- Riprova più tardi, o sostituisci l'immagine del prodotto con un'immagine locale

**In casi rari, difetti di sistema possono causare la perdita di immagini:**
- Per quanto ne sappiamo, alcune versioni di sistema personalizzate di alcuni produttori hanno avuto difetti: quando l'App crasha ripetutamente, può cancellare erroneamente i dati dell'App, causando la perdita di dati e file immagine. Mantieni il sistema aggiornato. Inoltre, non possiamo escludere che esistano ancora difetti di sistema che possano causare problemi anomali, poiché sono al di fuori del controllo dell'App. Consigliamo di fare backup frequenti
- In casi estremi, archiviazione instabile del dispositivo o problemi hardware possono anche causare la perdita di file immagine. Considera backup regolari sul cloud o la sostituzione del dispositivo

</details>

## ⏰ Promemoria / Pomodoro / Countdown

<details>
<summary>Come uso l'effetto countdown di un Oggetto del Negozio?</summary>

Gli effetti countdown vengono consegnati come notifiche dell'App.

Per prima cosa, conferma che il permesso di notifica per LifeUp sia attivato.

</details>

<details>
<summary>Il Pomodoro supporta l'auto-avanzamento?</summary>

Al momento no.

Puoi provare la modalità timer crescente.

In modalità Pomodoro, quando termina una sessione di lavoro, il timer continua a contare verso l'alto. Puoi poi decidere se aggiungere tempo extra ai record di Concentrazione. L'auto-avanzamento entrerebbe in conflitto con questo flusso di lavoro.

</details>

<details>
<summary>Come avvio rapidamente il Pomodoro dall'elenco Compiti?</summary>

Puoi:
1. Tenere premuto un Compito e toccare `Timer` nel menu azioni.
2. Oppure configurare un'azione di scorrimento su `Timer` nelle impostazioni `Compiti`.

</details>

<details>
<summary>Il Pomodoro fornisce statistiche riassuntive come le app Pomodoro dedicate?</summary>

Non ancora.

Il Pomodoro di LifeUp è ancora un modulo leggero in fase di sviluppo iniziale.

Attualmente disponibile:
- Record dettagliati per sessione
- Statistiche riassuntive giornaliere di base nella pagina `Stato`

</details>

## 💾 Backup e ripristino

<details>
<summary>Come faccio il backup dei dati?</summary>

Leggi prima la [Guida al backup e ripristino](/guide/backup.md).

In breve, i metodi di backup supportati includono:
- Google Drive (consigliato)
- Dropbox
- Esportazione file di backup
- Server WebDAV

</details>

<details>
<summary>Perché LifeUp è progettata come App offline-first?</summary>

LifeUp segue un'architettura offline-first per design.

Ciò significa:
- I tuoi dati ti appartengono e li controlli tu.
- I dati restano locali a meno che tu scelga esplicitamente opzioni di backup/sincronizzazione.
- La maggior parte delle funzioni principali funziona ancora senza accesso alla rete.

Poiché il client gestisce la logica principale localmente, puoi continuare a usare LifeUp anche quando la rete o la disponibilità del server sono limitate (eccetto funzioni online come il modulo Comunità).

</details>

## 🧭 Pianificazione

<details>
<summary>Aggiungerete funzioni IA?</summary>

LifeUp è un'App a basso costo, acquisto una tantum, mantenuta da un piccolo team. Integrare funzioni IA pronte all'uso direttamente (dove copriamo noi i costi API) non è realistico dato il nostro modello di prezzo — a meno di passare a un modello in abbonamento o moltiplicare diverse volte il prezzo una tantum per eguagliare i costi operativi delle app IA moderne. Non lo faremo.

Detto questo, LifeUp è intrinsecamente compatibile con l'IA:

1. Abbiamo esposto gran parte dell'[API](/guide/api.md) e delle funzionalità principali fin dall'inizio, rendendola naturalmente compatibile con agenti IA e strumenti di terze parti. Gli strumenti IA con capacità di agente possono già invocare direttamente le funzioni di LifeUp — creare Compiti, Oggetti e altro. Infatti, abbiamo visto molti utenti condividere flussi di lavoro che combinano l'IA con la nostra API, inclusi server MCP personalizzati per l'API di LifeUp, strumenti di automazione per voci di diario generate dall'IA e altro.

2. Pianifichiamo di introdurre capacità IA BYOK (Bring Your Own API Key) in futuro. Così potrai usare la tua chiave per alimentare funzioni IA senza che noi sosteniamo i costi API continui.

3. Alla fine, l'IA non è magia — altrimenti potresti altrettanto facilmente abbinare l'IA alla nostra API per ottenere l'integrazione completa da solo.

</details>

<details>
<summary>Ci sarà una versione iOS di LifeUp?</summary>

Nel **2025**, abbiamo lanciato [ulives](https://app.ulives.io/), una nuova App di produttività multipiattaforma per utenti iOS (anche su iPadOS e Mac con Apple Silicon).

Un port diretto di LifeUp su iOS non è realistico:

- LifeUp è costruita con tecnologia nativa Android.
- La sua architettura offline-first lega strettamente interfaccia, modello dati locale e logica di business all'implementazione Android.
- Un port diretto richiederebbe comunque riscritture importanti per mantenere dati e logica coerenti.

Quindi ci siamo riorganizzati e ricostruiti con una direzione multipiattaforma tramite ulives.

ulives mantiene lo spirito centrale di LifeUp e affronta anche diversi problemi di design e prodotto di lunga data delle generazioni precedenti. Puoi pensarla come un'evoluzione fresca, non solo un clone uno a uno.

**L'abbonamento LifeUp non sblocca ulives**, ma puoi importare un backup LifeUp (unidirezionale, potenzialmente con perdite). Vedi [Cos'è ulives?](/guide/faq?id=ulives_overview). Per motivi più dettagliati, consulta il documento di confronto: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>Cos'è ulives? Condivide abbonamento o dati con LifeUp?</summary>


[ulives](https://app.ulives.io/) è una **riscrittura da zero** con tecnologia multipiattaforma (KMP). Eredita la filosofia di gamificazione di LifeUp, ma codice, team, prezzi e piani a lungo termine sono separati — una successora spirituale, **non** un port iOS di LifeUp.

**Perché gli abbonamenti sono separati?**

- **Il prezzo di LifeUp riflette l'ambito solo Android:** LifeUp è sempre stata costruita con tecnologia puramente nativa Android. Il suo prezzo di abbonamento a vita molto basso era definito intorno al **fatto di avere solo un client Android** — non era mai pensato per coprire il mantenimento di ogni futura App che potremmo costruire.
- **Il prezzo di ulives riflette il costo multipiattaforma e la manutenibilità a lungo termine:** ulives è una riscrittura completa con codice multipiattaforma, un team ancora non del tutto unificato e lavoro continuo per iOS più futuri target Android e HarmonyOS. Premium è definito da **sviluppo sostenibile e manutenibilità a lungo termine**, non dal copiare la divisione storica gratis/a pagamento di LifeUp.
- **Team di sviluppo distinti:** Un port iOS di LifeUp è progredito lentamente per vari motivi. Ci siamo riorganizzati con un team dedicato per ulives (ancora piccolo oggi) per rilasciare un prodotto multipiattaforma più velocemente e con più flessibilità.
- **Ecosistemi store separati:** App Store e Google Play sono sistemi di pagamento e diritti indipendenti. Le licenze non possono essere trasferite direttamente tra le due app.

**In breve:**

- **Abbonamento LifeUp ↔ abbonamento ulives non si trasferiscono:** Un acquisto LifeUp su Google Play **non** sblocca ulives su App Store, e viceversa. Ogni App richiede il proprio acquisto.
- **Importazione dati unidirezionale:** Da ulives 1.7.22, puoi importare un backup LifeUp (`.lfbak`) in ulives. La conversione può essere con perdite, e l'importazione **non** si trasferisce indietro a LifeUp.
- **L'importazione non trasferisce la licenza:** I backup spostano dati d'uso (Compiti, Oggetti, ecc.), non i diritti di abbonamento LifeUp.

**ulives Premium su tutte le piattaforme ulives:**

ulives rilascerà anche il proprio client **Android** (e supporto nativo HarmonyOS, ecc.). **Premium acquistato per ulives è pensato per funzionare su tutte le piattaforme ulives** — iOS, Android, HarmonyOS — una volta pronta la gestione account lato server. I casi multipiattaforma iniziali potrebbero richiedere di contattarci.

**Entrambe le app offrono abbonamento a vita molto al di sotto della maggior parte dei prodotti comparabili** — ma i prezzi di riferimento vanno letti nel contesto: ambito mono-piattaforma vs multipiattaforma, costo di sviluppo e manutenzione a lungo termine differiscono.

Per motivi più dettagliati (modello di prezzo, sostenibilità, investimento nello sviluppo e piani futuri di entrambe le app), consulta il documento di confronto: [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup). FAQ ulives: [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 Serve ancora aiuto?

<details>
<summary>Contattaci</summary>

Puoi scriverci a [lifeup@ulives.io](mailto:lifeup@ulives.io).

Puoi anche aprire un issue su GitHub:
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Vuoi sostenerci?</summary>

Grazie per il supporto a LifeUp.

Se LifeUp ti è stata utile, puoi sostenerci in due modi semplici:

1. Offrici un caffè dalla pagina **About** nella **versione Google Play** dell'App.
2. Aiuta più persone a scoprire LifeUp condividendo la tua esperienza:
   - Consiglia LifeUp agli amici
   - Pubblica le tue storie d'uso e i flussi di lavoro
   - Condividi consigli, guide o tutorial

</details>

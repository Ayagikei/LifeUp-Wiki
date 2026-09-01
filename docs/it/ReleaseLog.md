# Note di rilascio

## Cronologia

![timeline](_media/release_log/timeline.png)

## Note

| Piattaforma       | Versione               | Data aggiornamento          |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.5              | 2026/09/01                  |
| LifeUp-iOS        | consulta [feature/ulives] | 🎉App alternativa disponibile |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Parte della traduzione è fornita da traduzione automatica/IA e potrebbe non essere accurata)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.5 (2026/09/01)**

**🐛 Correzioni bug**

1. **Corretto un problema per cui dati anomali dei Compiti potevano accumularsi in certi casi**: Ciò poteva rendere lente o non reattive operazioni sui Compiti come ordinamento o eliminazione. L'aggiornamento pulisce automaticamente i dati non validi interessati e migliora le prestazioni con cronologie estese di Compiti.

**v1.105.3 (2026/08/26)**

**🐛 Correzioni bug**

1. **Corretta la finalizzazione anomala di un Compito dopo la conversione locale di un Compito di squadra in Compito a tempo.**

**v1.105.2 (2026/08/24)**

**🐛 Correzioni bug**

1. **Corretto il selettore Compiti che mostrava un elenco vuoto quando era selezionata una lista intelligente.**
2. **Corretta la ricerca in una lista intelligente che mostrava anche Compiti non appartenenti a quell'elenco.**

**v1.105.1 (2026/08/19)**

**✨ Novità**

1. **Gli effetti sonori personalizzati possono essere disattivati per scena**: silenzia un segnale senza influire sugli altri; l'anteprima continua a riprodursi per verificare il suono.

**♻️ Ottimizzazione**

1. **Guida al backup più chiara quando i servizi Google Play non sono disponibili**: se Google Drive non può essere usato, l'App spiega il motivo e suggerisce un file locale, Dropbox o WebDAV.

**🐛 Correzioni bug**

1. **Corretto il pulsante Annulla nella pagina Completati del calendario che non rispondeva al tocco.**
2. **Corretti i limiti di acquisto/uso che non venivano ripristinati (o venivano salvati vuoti) durante la modifica di un Oggetto.**

**v1.105.0 (2026/08/04)**

**ℹ️ Nota importante**

1. **Android 6.0 è ora la versione minima supportata**: per supportare in modo proattivo funzioni e requisiti di comportamento delle versioni Android più recenti, la versione minima supportata è passata da Android 5.0 ad Android 6.0. Gli utenti Android 5.x non possono installare o aggiornare a questa versione.

**✨ Novità**

1. **Aggiunta un'API URL Scheme per il controllo Pomodoro**: gli utenti possono consultare lo stato, selezionare un Compito e avviare, mettere in pausa, saltare, abbandonare o completare sessioni Pomodoro o a conteggio crescente.
2. **Migliorato il meccanismo di ordinamento personalizzato dei Compiti**: introdotto un nuovo meccanismo di ordinamento per mantenere stabile l'ordine personalizzato durante copia, completamento, annullamento e gestione dei Compiti in altri casi limite.

**♻️ Ottimizzazione**

1. **Aggiunto il supporto al back predittivo di Android**: gli editor di Compiti, Negozio, Sintesi e Obiettivi supportano ora il gesto di back predittivo di sistema.
2. **Migliorata l'inizializzazione dell'accesso Facebook**: l'SDK viene inizializzato quando viene richiesto l'accesso, con una gestione migliorata degli stati di errore.

**🐛 Correzioni bug**

1. **Corrette le richieste URL Scheme di modifica che sovrascrivevano in modo imprevisto i campi esistenti**: i campi omessi mantengono ora i valori precedenti e parametri di Ricompensa o relazione non validi non cancellano più i dati esistenti.
2. **Corretti i titoli delle notifiche del timer positivo che non seguivano il Compito selezionato in alcuni casi limite.**
3. **Corretta l'anteprima RGB che non si aggiornava dopo il primo valore colore esadecimale incollato.**
4. **Corrette le ombre mancanti nella barra degli strumenti di selezione nelle pagine di dettaglio Sintesi e Obiettivi.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Correzioni bug**

1. **Corretto il ripristino errato delle sessioni Pomodoro dopo l'arresto imprevisto dell'App o del servizio timer**: le sessioni valide possono ora essere ripristinate correttamente, mentre lo stato obsoleto non valido viene ripulito.
2. **Corretti i prompt ripetuti dopo un cambio di fuso orario di sistema**: dopo la conferma della regolazione, gli orari dei Compiti vengono aggiornati correttamente senza mostrare di nuovo lo stesso prompt.

**v1.104.5 (2026/07/17)**

**🐛 Correzioni bug**

1. **Corretto un problema nella build v1.104.4 in cui aprire la pagina Pomodoro poteva causare un crash dell'App.**

**v1.104.4 (2026/07/17)**

**✨ Novità**

1. **Gli Oggetti supportano ora restrizioni di acquisto/uso basate su intervalli di Punti Esperienza degli Attributi**: imposta condizioni minime e massime di XP per controllare se un Oggetto può essere acquistato, usato o entrambi.
2. **Nuova condizione Obiettivo per completare Compiti un totale di N volte in un giorno**: a differenza della condizione esistente su Compiti distinti, questa condizione conta ogni completamento valido di Compito in quel giorno, incluse ripetizioni dello stesso Compito.

**♻️ Ottimizzazione**

1. **Ricostruito il flusso di liquidazione e recupero Pomodoro**: stato del timer, registri di Concentrazione e liquidazione delle Ricompense seguono ora un processo unificato. Il recupero è anche più affidabile se il processo dell'App viene terminato, riducendo casi limite come la perdita di tempo di Concentrazione. Se noti cambiamenti di comportamento imprevisti, contattaci a lifeup@ulives.io.
2. **Modifica delle quantità più fluida per le ricette di Sintesi**: tocca un ingrediente o risultato esistente per modificarne direttamente la quantità, senza selezionare di nuovo lo stesso Oggetto. Puoi comunque riselezionare l'Oggetto quando serve.
3. **Il Pomodoro può ora essere aperto in orizzontale direttamente dalla home**: visualizza e usa il timer più comodamente in layout orizzontale.

**v1.104.3 (2026/07/09)**

**✨ Novità**

1. **Nuova guida «Configurazione rapida» nella schermata di benvenuto**: due nuove pagine (5 e 6) dopo le schede introduttive permettono di configurare permessi di notifica, metodo di promemoria, stile UI (Material 2/3) e visualizzazione multi-finestra già durante l'onboarding, con schede a fisarmonica. Tutte le opzioni possono essere regolate in seguito in Impostazioni.

**♻️ Ottimizzazione**

1. **Testo introduttivo della pagina di benvenuto aggiornato**: le pagine 1–4 sono state riscritte per comunicare meglio il valore principale dell'App: Compiti personalizzati → crescita statistiche → sistema Ricompense → connessione con il mondo.
2. **Dialogo Sintesi ridisegnato come bottom sheet**: materiali e risultati sono ora mostrati in una griglia verticale, con un layout più pulito e intuitivo.
3. **Caricamento dati più rapido quando si passa tra liste di cose da fare, si cambia l'ordinamento o si attiva/disattiva il raggruppamento**.

**🐛 Correzioni bug**

1. **Corrette le notifiche duplicate «Obiettivo sbloccato»** per alcuni Obiettivi di sistema.
2. **Corretto il conteggio impreciso dell'Obiettivo «Completa N Compiti distinti al giorno»**: i Compiti infiniti non sono più esclusi e completare lo stesso Compito più volte nello stesso giorno conta come uno.
3. **Corretto il pulsante Aggiungi (+) nell'elenco Compiti che occasionalmente si spostava dalla posizione corretta**.
4. **Corrette le liste intelligenti che non filtravano i Compiti archiviati quando «Raggruppa per elenco» era disattivato**.

**v1.104.2 (2026/07/03)**

**✨ Novità**

1. **«Giorni di utilizzo» rinominato in «Giorni di compagnia» nella pagina statistiche**: tocca la scheda per personalizzare la data di inizio e definire il tuo anniversario. Anche le descrizioni delle condizioni Obiettivo correlate usano la terminologia «compagnia».
2. **Opzione «Backup e condividi» aggiunta al menu backup**: condividi i file di backup direttamente con altre app tramite il pannello di condivisione di sistema.
3. **API effetti Bottino v2**: una nuova route `loot_box/v2` supporta la corrispondenza precisa degli Oggetti tramite `sub_amount`, aggiunta/rimozione di Oggetti e controllo indipendente delle modalità quantità e probabilità.

**♻️ Ottimizzazione**

1. **URL Scheme ora dà priorità alla corrispondenza esatta per nome** durante la modifica di Oggetti del Negozio, Bottini o sottocompiti, passando alla corrispondenza fuzzy solo se non viene trovata una corrispondenza esatta, evitando modifiche indesiderate.
2. **«FAQ» nella barra laterale rinominato in «Notice» in inglese**: la versione cinese era già «公告» e resta invariata.
3. **Effetti ripple dei pulsanti allineati al raggio degli angoli ovunque**: le animazioni ripple sui controlli arrotondati non fuoriescono più oltre gli angoli, rendendo i tocchi più curati in tutta l'App.

**🐛 Correzioni bug**

1. **Corretta la pagina Pomodoro che non aggiornava automaticamente il conteggio pomodori dopo l'aggiunta o la modifica di un registro.**
2. **Corretto il toast dei pomodori guadagnati che occasionalmente non compariva dopo l'aggiunta di un registro Pomodoro.**
3. **Corretti i registri Pomodoro aggiunti manualmente che calcolavano i pomodori in base al Compito attualmente selezionato invece che al Compito scelto nel registro**: il calcolo usa ora la durata di Concentrazione specifica del Compito effettivamente selezionato nel registro. Se hai impostato durate di Concentrazione diverse per Compiti diversi, i pomodori registrati manualmente saranno più accurati.
4. **Corretta la visualizzazione errata del «conteggio completamenti» per Compiti illimitati nella cronologia**: ora mostrato come ordinale giornaliero (es. «la N-esima volta quel giorno»).
5. **Corretto il testo motivazionale dei Compiti penalità che non compariva**: ora compare dopo il completamento della penalità.

**v1.104.1 (2026/06/17)**

**✨ Novità**

1. **Opzioni di esportazione backup migliorate**: durante la creazione di un backup manuale, un nuovo bottom sheet permette di scegliere se includere file multimediali, informazioni sensibili dell'account (stato accesso, credenziali WebDAV, ecc.) e immagini emoji, facilitando la condivisione di un backup depurato. Anche la sezione backup automatico include tre interruttori persistenti corrispondenti.
2. **Selettore Compiti Pomodoro migliorato**: i Compiti a tempo compaiono per primi nel selettore con il progresso di Concentrazione attuale (durata concentrata / durata obiettivo / percentuale). Un interruttore permette di attivare o disattivare la priorità dei Compiti a tempo per un accesso rapido.
3. **Ridisegno pagina Informazioni**: la pagina Informazioni è riorganizzata in sezioni Link, Feedback, Community e Sviluppatore, con nuove voci per sito web, registro modifiche, FAQ e documentazione API. Gli utenti cinese semplificato ottengono una voce Tencent Channel; gli utenti internazionali accedono a GitHub Issues/Discussions.
4. **Rimozione follower**: ora puoi rimuovere i follower dalla pagina membri del team.
5. **Miglioramento selettore Attributi nel Negozio**: aggiunto un pulsante selettore Attributi al dialogo di input exp/effetto del Negozio, con filtro rapido per gruppo Abilità e selezione multipla in batch, molto più comodo con molti Attributi.

**♻️ Ottimizzazione**

1. **Statistiche Pomodoro con formato orario commutabile**: tocca l'area statistiche Pomodoro nella pagina dettaglio Compito per alternare tra «ore/minuti», «giorni/ore/minuti» e «minuti totali».
2. **Stato completamento sottocompiti più chiaro**: i sottocompiti completati mostrano ora il barrato, distinguendo meglio ciò che è fatto da ciò che è in sospeso.
3. **Ordinamento registri Pomodoro corretto**: i registri Pomodoro sono ora ordinati per ora di fine in ordine decrescente.

**🐛 Correzioni bug**

1. **Corretto il testo del pulsante prelievo ATM in più lingue**: corretto l'uso errato del gerundio in alcune lingue.
2. **Corretto il comportamento di condivisione Oggetti del Negozio senza accesso**: risolto il comportamento anomalo durante la condivisione di Oggetti del Negozio senza essere connessi.
3. **Corretto lo stato di selezione del selettore colore**: il dialogo selettore colore mostrava uno stato di selezione errato.

**v1.104.0 (2026/05/23)**

**✨ Novità**

1. **I Compiti a conteggio supportano ora la liquidazione Ricompense proporzionale in tempo reale**: utile per Compiti su cui puoi avanzare più volte in momenti flessibili all'interno di un ciclo, come abitudini completate poche volte a settimana. Quando cambia il progresso del conteggio, LifeUp può concedere o annullare Exp, monete e Ricompense Oggetti in base al progresso attuale invece di attendere il completamento finale.
2. **Strumenti cronologia nel dettaglio Compito più potenti**: selezionando una data nel calendario cronologia viene mostrato il conteggio di quel giorno e puoi aggiungere, modificare o creare registri cronologia in batch.
3. **Riflessioni e Oggetti meglio collegati**: i dettagli Oggetto possono ora passare direttamente alle Riflessioni correlate e la pagina Riflessioni supporta il filtro per Oggetto del Negozio.
4. **Registrate le ore di completamento dei sottocompiti**: LifeUp registra ora quando ogni sottocompito viene completato, preparando i dati per futuro supporto API e LifeUp Cloud.

**♻️ Ottimizzazione**

1. **Filtri visibilità Oggetti del Negozio più precisi**: oltre agli Oggetti esauriti, puoi nascondere quelli con acquisto disabilitato, acquisto limitato o attualmente non acquistabili. Anche i widget del Negozio seguono le stesse regole.
2. **Ricerca e aggiornamento elenco Compiti più stabili**: la ricerca negli elenchi normali può includere Compiti completati attualmente visibili secondo le impostazioni; l'aggiornamento Compiti ripetuti più ordinamento personalizzato nell'elenco Tutti è più stabile con molti Compiti.
3. **Statistiche cronologia nel dettaglio Compito seguono la data selezionata**: Compiti a conteggio e illimitati usano livelli colore diversi nella mappa contributi in base al conteggio completamenti giornaliero. Anche le statistiche mensili, annuali, totali e serie sotto la vista cronologia sono calcolate dalla data selezionata invece di usare sempre i dati di oggi.
4. **Ordinamento alfabetico più intuitivo**: l'ordinamento alfabetico nei moduli segue ora l'ordine numerico naturale, così i nomi con numeri sono ordinati per valore numerico invece che carattere per carattere.
5. **Comportamento input impostazioni Negozio migliorato**: le impostazioni Negozio scorrono gli input focalizzati sopra la tastiera virtuale.
6. **Gestione modalità scura di sistema più affidabile**: corrette race condition tra seguire il tema di sistema e attivare manualmente la modalità notturna.
7. **Supporto API URL Scheme ampliato**: Aggiungi/Modifica Compito supporta ora la semantica `no_deadline` e le API Compiti a conteggio supportano il flag di liquidazione in tempo reale.
8. **Registri cronologia interessi più chiari**: i registri interessi ATM e credito mostrano capitale e giorni di interesse, rendendo più facile verificare l'origine degli interessi.

**🐛 Correzioni bug**

1. **Corrette le statistiche Obiettivi in La mia pagina**: quando gli Obiettivi di sistema sono nascosti, i conteggi seguono la stessa regola di visibilità.
2. **Corretta la formulazione dei registri cronologia**: i registri di abbandono non vengono più mostrati con formulazione di penalità per scadenza.
3. **Corretta la gestione testi lunghi nelle API URL Scheme**: le descrizioni lunghe di Abilità e Obiettivi non vengono più troncate troppo presto.

**v1.103.6 (2026/05/10)**

**🐛 Correzioni bug**

1. **Corretto il suggerimento intervallo pausa lunga che non tornava allo stato iniziale della sessione di Concentrazione dopo aver toccato Abbandona.**
2. **Corretto il timer di Concentrazione aggiuntivo che poteva restare visibile e continuare a contare dopo aver toccato Abbandona.**

**v1.103.5 (2026/05/10)**

**🐛 Correzioni bug**

1. **Corretto il suggerimento pausa lunga del timer Pomodoro che non si aggiornava prontamente al termine naturale di una sessione di lavoro.**
2. **Corretto il timer Pomodoro che poteva mostrare il vecchio intervallo pausa lunga a 2 sessioni prima di aprire le impostazioni Pomodoro, invece del valore predefinito di 4 sessioni.**

**v1.103.4 (2026/05/05)**

**🐛 Correzioni bug**

1. **Corretto un problema per cui i Compiti potevano scomparire a causa di un'interruzione anomala mentre erano congelati in alcuni scenari limite.**

**v1.103.3 (2026/05/05)**

**ℹ️ Nota di rilascio**

1. **Questa versione è stata saltata e non è stata rilasciata pubblicamente.**

**v1.103.2 (2026/04/30)**

**🐛 Correzioni bug**

1. **Corretto un problema di compatibilità per cui i campi di input potevano non comparire durante la modifica delle restrizioni di acquisto o uso degli Oggetti in alcune lingue o su schermi più piccoli.**
2. **Corretto un problema per cui l'uso di un Oggetto poteva attivare erroneamente un dialogo di penalità.**

**v1.103.1 (2026/04/25)**

**🐛 Correzioni bug**

1. **Corretto comportamento anomalo quando l'effetto di uso di un Oggetto modifica la propria quantità**
2. **Corretti alcuni crash e problemi di lag rilevati in produzione**
3. **Corretti valori quantità errati ripristinati durante la modifica dell'effetto «Modifica quantità Oggetto» di un Oggetto**

**v1.103.0 (2026/04/12)**

**✨ Novità**

1. **Gli Attributi supportano ora sottocategorie e spostamento rapido**: puoi raggruppare gli Attributi in modo più chiaro e spostare un Attributo in un gruppo target più rapidamente.
2. **Interazioni selezione Attributi più fluide**: modifica Compiti, flussi legati alle Ricompense e altri selettori Attributi sono ora più facili da consultare con molti Attributi.
3. **Gli Oggetti supportano ora restrizioni di acquisto/uso**: i limiti possono applicarsi ad acquisto, uso o entrambi, con condizioni più ricche come ora, Obiettivi sbloccati, Compiti completati, conteggi Oggetti posseduti e intervalli Livello Attributi.
4. **Obiettivi con più opzioni di ordinamento integrate**: oltre all'ordine personalizzato, gli elenchi Obiettivi supportano ordinamento alfabetico, per ora di completamento e per data di creazione.
5. **Obiettivi con spostamento rapido in sottocategorie**: sposta uno o più Obiettivi in una sottocategoria target in modo più efficiente.
6. **Gestione scadenze con voce di aiuto**: il dialogo scadenza include ora una voce di aiuto e presenta più chiaramente le modifiche Ricompensa quando riporti un Compito scaduto a completato.

**♻️ Ottimizzazione**

1. **Visualizzazione Attributi raggruppati più chiara**: la pagina stato e i dialoghi descrizione Attributi presentano gli Attributi raggruppati in modo più strutturato.
2. **Interazioni legate agli Attributi più coerenti**: visualizzazione raggruppata e selezione più uniformi nei dialoghi Attributi e nei flussi di modifica correlati.
3. **Modifica restrizioni Oggetti più facile da capire**: tipi di restrizione più ricchi sono più facili da configurare e rivedere.
4. **Rendering barra di stato e barra superiore più stabile su più pagine**: le aree superiori in pagine come Negozio, Mondo, Ricerca, Stato, Obiettivi, La mia pagina e WebDAV si comportano in modo più coerente durante lo scorrimento, in modalità scura e con Material You.
5. **Layout Attributi pagina stato gestisce meglio testi lunghi**: nomi Attributi ed etichette Livello più lunghi si adattano in modo più affidabile, anche su schermi stretti o con testo grande.

**🐛 Correzioni bug**

1. **Corretto problema variazione gid nella generazione copie**: i Compiti copiati generati da Compiti scaduti una tantum o infiniti avevano gid incoerenti.
2. **Corretta casella «Casuale» non funzionante nella selezione Attributi**: alcune caselle selezione Attributi mostravano una casella «Casuale» non funzionante.
3. **Corretto posizionamento banner Ricompensa**: in alcuni scenari (soprattutto al completamento Compiti) i banner erano posizionati in modo errato, occlusi o instabili.
4. **Corretta anteprima/animazione Ricompense scadenza in alcuni casi**: quando un Compito scaduto viene riportato a completato, le modifiche XP, monete e Oggetti sono presentate in modo più accurato senza mescolare valori confusi.
5. **Corretto a capo/disallineamento layout Livello pagina stato in alcuni casi**: layout più stabile con nomi Attributi lunghi o etichette Livello estese.
6. **Corretto cambio pagina quando l'elenco Sintesi ha pochi elementi**: ora puoi scorrere orizzontalmente dalle aree vuote in modo più affidabile quando il contenuto dell'elenco è breve.
7. **Corretto crash durante il riscatto Ricompense Obiettivo in casi speciali**: possibile crash durante il riscatto Ricompense Obiettivo in alcuni casi limite.

**v1.102.11 (2026/04/02)**

**🐛 Correzioni bug**

1. **Corretti occasionali fallimenti di liquidazione e anomalie di aggiornamento sui Compiti a conteggio della home.**

**v1.102.10 (2026/03/24)**

**🐛 Correzioni bug**

1. **Corretto un problema per cui gli elenchi formule Sintesi nascosti non potevano essere premuti a lungo per modificare o eliminare formule.**

**v1.102.9 (2026/03/23)**

**♻️ Ottimizzazione**

1. **Regola disabilitazione navigazione inferiore aggiornata**: a livello di interazione, non è più consentito disabilitare tutti i moduli della navigazione inferiore.

**🐛 Correzioni bug**

1. **Corretto crash all'avvio**: l'App poteva crashare all'apertura dopo che tutti i moduli della navigazione inferiore erano stati disabilitati.

**v1.102.8 (2026/03/23)**

**✨ Novità**

1. **Ripristino layout moduli predefinito**: aggiunto pulsante «Ripristina layout predefinito» alla pagina configurazione moduli.
2. **Nuovo evento broadcast formula Sintesi**: aggiunto evento API broadcast `app.lifeup.synthesis.complete`, inviato al completamento con successo di una formula Sintesi.
3. **Ricerca Mondo supporta filtro tag origine**: la sezione Mondo può cercare per tag origine, ad esempio filtrare Oggetti API in Vetrina prima della ricerca.

**♻️ Ottimizzazione**

1. **Miglioramenti tipografici popup sblocco Obiettivo**: rendering font migliorato e meno problemi di layout con dimensioni font di sistema grandi.
2. **Miglioramenti logica nascondimento moduli**: comportamento nascondimento moduli per mostrare o nascondere correttamente Obiettivi legati al modulo Mondo.
3. **Regolato comportamento predefinito assegnazione Compiti casuali**: i Compiti casuali appena creati non vengono più assegnati automaticamente all'elenco predefinito, evitando assegnazioni silenziose.

**🐛 Correzioni bug**

1. **Corretto raro crash durante l'aggiornamento dell'elenco Compiti**.
2. **Corretto problema titolo API Riflessioni**: l'API non forniva correttamente il titolo Riflessioni, con possibile impatto anche sui titoli Oggetto.
3. **Corretti problemi layout orizzontale Pomodoro**.
4. **Corretto tipo timestamp ora fine nell'API cronologia Compiti**.
5. **Aggiunti campi risposta API mancanti**: progresso Compito, stato completamento, condizioni fine ricorrenza e campi correlati vengono ora restituiti correttamente.
6. **Corretti valori obsoleti nella pagina dettaglio Compiti a conteggio**: i valori si aggiornano subito dopo la modifica del Compito a conteggio.
7. **Corretto un problema che poteva causare durate anomale nei registri Pomodoro**.
8. **Corretta home che non si ricostruiva subito entrando in modalità offline**: poteva lasciare visibile in modo imprevisto la sezione Mondo.
9. **Corretto problema caricamento pagina Compiti casuali**: in alcuni casi la pagina poteva restare bloccata in stato di caricamento.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Ottimizzazione**

1. **Tutorial widget + miglioramenti testo**: aggiunta guida per aggiungere widget e perfezionamento testo e suggerimenti correlati.

**🐛 Correzioni bug**

1. **Corretto deadlock Pomodoro con dati anomali**: la pagina Pomodoro non resta più bloccata/congelata in presenza di dati anomali.
2. **Corretta desincronizzazione timer aggiunta tempo dopo spegnimento schermo**: il timer «aggiungi tempo» resta sincronizzato dopo lo spegnimento dello schermo o la sospensione del dispositivo.
3. **Corretta selezione elenco predefinito per nuovi Compiti**: gestione migliorata durante la creazione Compiti da liste intelligenti, soprattutto se l'elenco predefinito è archiviato (ora ricade correttamente).

**v1.102.1 (2026/01/27)**

**✨ Novità**

1. **Zoom anteprima immagini**: ripristinata la funzione zoom immagini persa durante il refactoring delle pagine, per visualizzare i dettagli più facilmente.

**🐛 Correzioni bug**

1. **Ottimizzazione memoria WebDAV**: corretto un problema per cui il download da WebDAV consumava memoria eccessiva, con possibili crash o problemi di prestazioni.
2. **Aggiornamento immagini Riflessioni**: risolto un bug per cui le immagini modificate nella pagina Riflessioni non si aggiornavano subito.

**v1.102.0 (2026/01/25, sostituita da v1.102.1 durante il rilascio progressivo)**

**✨ Novità**

1. **Gestore suoni**: importa, anteprima, elimina e riutilizza effetti sonori e usali come effetti di uso Oggetti.
2. **Negozio: nuovi effetti uso Oggetti**: aggiunti EXP casuale, modifiche stock, riproduzione suono e flusso configurazione migliorato.
3. **Compiti a tempo**: nuovo tipo di Compito con durata di Concentrazione prevista; completa il Compito dopo aver raggiunto l'obiettivo del timer.
4. **Opzioni inizio settimana**: scegli lunedì / sabato / domenica e calendario e statistiche si adattano.
5. **Salta onboarding**: opzione per saltare il tutorial al primo avvio.
6. **Input emoji per icone**: inserisci un'emoji (incluse emoji combinate) per creare rapidamente un'icona.
7. **Calendario: apri dettagli Compiti ricorrenti futuri**: toccando un Compito ricorrente in una data futura ne apre correttamente i dettagli.
8. **Utenti avanzati: miglioramenti API**: l'API URL Scheme aggiunge/estende CRUD template Compiti, condizioni fine ricorrenza, navigazione filtri Sintesi e altro.

**♻️ Ottimizzazione**

1. **Miglioramenti prestazioni e fluidità**: ottimizzati accesso dati e strategie di indicizzazione per elenchi Compiti, cronologia Inventario e statistiche più fluide con grandi volumi di dati.
2. **UX configurazione effetti Oggetti migliorata**: interazioni selezione e visualizzazione effetti migliorate, con dialoghi e icone perfezionati.
3. **Miglioramenti localizzazione**: completate traduzioni mancanti in più lingue.

**🐛 Correzioni bug**

1. **Corretto reset effetto countdown in modifica**: confermare un effetto countdown modificato poteva reimpostare il valore a 1.
2. **Corretto uso automatico Ricompense Oggetti Compiti squadra che non si attivava**: l'uso automatico non partiva dopo il riscatto Ricompense Oggetti per Compiti squadra.
3. **Corretto prompt «registra Riflessioni» assente dopo Bottino / Sintesi**: il dialogo Riflessioni poteva non comparire dopo l'apertura Bottini o l'uso Sintesi semplice quando l'Oggetto ha effetto «registra Riflessioni».
4. **Corretti dialoghi liquidazione assenti al completamento manuale Pomodoro**: completare manualmente un Compito nella pagina Pomodoro poteva saltare dialoghi liquidazione Ricompense/Riflessioni; ripristinato completamento con pressione prolungata sul titolo Compito.
5. **Corretto filtro piega widget non funzionante**: il filtro widget lista intelligente «Piega Compiti non ancora iniziati» non aveva effetto.
6. **Corretto raro crash**: crash causato dal salvataggio di troppo stato in alcune situazioni.
7. **Corretta navigazione calendario-dettaglio per Compiti futuri**: errori aprendo dettagli Compiti ricorrenti futuri dal calendario.
8. **Corretti problemi Compiti ricorrenti Ebbinghaus**: fasi anomale e generazione ripetuta indesiderata in casi rari, con salvaguardia limite superiore aggiunta.

**v1.101.8 (2026/01/12)**

**🐛 Correzioni bug**

1. **Corrette impostazioni condizione fine ricorrenza**: risolto un problema per cui la condizione di fine non poteva essere impostata per frequenze «Ogni 2 giorni» o personalizzate «Ogni N giorni».
2. **Corretta durata anomala timer Pomodoro**: il timer poteva durare molto più del previsto a causa di sospensione di sistema o congelamento processo quando l'ottimizzazione batteria non era disabilitata correttamente.

**v1.101.7 (2026/01/11)**

**🐛 Correzioni bug**

1. **Corretto un problema che poteva accorciare anormalmente la durata del timer Pomodoro**.

**v1.101.6 (2026/01/10)**

**🐛 Correzioni bug**

1. **Corrette anomalie legate al cambio modalità scura di sistema**.

**v1.101.5 (2026/01/08)**

**♻️ Ottimizzazione**

1. **Ottimizzato cambio modalità scura di sistema**: corretti problemi per cui l'App poteva non passare automaticamente al tema insieme alle impostazioni di sistema.
2. **Ottimizzata selezione Attributi per Ricompense**: gestione migliorata quando nessun Attributo è selezionato in «Ricompense persistenza», «Ricompense passi» e «Ricompense mi piace». Supporta deselezione Attributi e corregge problemi per cui Ricompense esperienza non venivano concesse correttamente.
3. **Ottimizzazione configurazione prestazioni**: configurazioni interne che possono migliorare le prestazioni dell'App.

**🐛 Correzioni bug**

1. **Corrette query statistiche e visualizzazione grafici**: corrette condizioni query per statistiche ora completamento Compiti e risolti dati grafico imprecisi.
2. **Corretta interazione dialogo impostazioni widget**: mancava il pulsante «Conferma» nel dialogo filtro Compiti del widget.
3. **Corretta sincronizzazione conteggio Compiti**: il conteggio Compiti nella home non si aggiornava correttamente dopo la modifica dalla pagina dettaglio Compito.
4. **Corretta gestione uso Oggetti API Riflessioni**: gestione errata tipi «Uso Oggetto» nell'API Riflessioni.
5. **Corretta navigazione calendario-dettaglio**: risolti diversi problemi passando dal calendario al dettaglio Compito.

**v1.101.4 (2025/12/30)**

**♻️ Ottimizzazione**

1. **Ottimizzata logica rilevamento aggiornamenti membri**: invito ai membri a passare al «Canale stabile membri» per gli aggiornamenti e garantire l'esperienza funzionale più stabile.
2. **Ridotte richieste di rete non necessarie**: ulteriore risparmio dati utente e riduzione costi server.

**🐛 Correzioni bug**

1. **Corretto aggiornamento progresso Obiettivi (priorità)**: risolto un bug per cui il progresso Obiettivo non si attivava correttamente al completamento dei registri Pomodoro.

**v1.101.3 (2025/12/14)**

**🐛 Correzioni bug**

1. Corretto un problema per cui l'opzione «Scadenza oggi» ignorava erroneamente l'offset scadenza del giorno successivo.

**v1.101.2 (2025/12/13)**

**🐛 Correzioni bug**

1. Corretto un problema per cui lo stato di ricerca veniva reimpostato tornando alle pagine Negozio, Inventario o Compiti.
2. Corretto un crash legato ai limiti di `AlarmManager` (circa 500 allarmi simultanei).
3. Corretti crash legati a colori dinamici, dialoghi fuso orario e menu a comparsa.
4. Ottimizzato il reporting crash per ignorare errori di rete comuni.

**v1.101.1 (2025/12/01)**

**🐛 Correzioni bug**

1. Corretti possibili crash causati da errori di formattazione traduzioni.

**v1.101.0 (2025/11/29)**

**✨ Novità**

1. **Filtro Oggetti Sintesi**: filtra la Sintesi per Oggetti per ricerca e gestione più rapide.
2. **Dettaglio Oggetto → ricetta Sintesi**: visualizza la ricetta Sintesi di un Oggetto direttamente nella pagina dettaglio.
3. **Negozio → voce Sintesi**: se un Oggetto è utilizzabile in Sintesi, accanto al pulsante Acquista compare ora un pulsante Sintesi.
4. **Filtri cronologia Inventario**: aggiunti filtri per data, Oggetti e descrizione.
5. **Dialogo Novità**: dialogo evidenze nuova versione al primo avvio dopo l'aggiornamento.
6. **Tempo Concentrazione Pomodoro per Compito**: logica Pomodoro rifattorizzata; supporta durata Concentrazione personalizzata per Compito.
7. **Effetto uso Oggetto: «Registra Riflessioni dopo l'uso»**; la pagina Riflessioni supporta anche il filtro per Oggetto.
8. **Broadcast ciclo di vita Pomodoro (API)**: aggiunti eventi broadcast del ciclo di vita.
9. **API query semplice**: ora supporta il recupero dei dettagli di un singolo Compito.
10. **Incremento automatico Compiti a conteggio**: supporta l'incremento automatico.
11. **Fine ricorrenza per data**: i Compiti supportano ora la fine ricorrenza in una data specifica.
12. **Miglioramento impostazioni widget desktop**: migliorata la pagina impostazioni widget desktop in-App così ogni widget supportato può essere anteprima e, se il sistema lo consente, aggiunto rapidamente alla schermata home.

**♻️ Ottimizzazione**

1. **UX gestione elenchi + modalità scura**: interazioni e modalità scura perfezionate; l'elenco «Tutti» mostra ora uno stato eliminazione disabilitato invece di un'azione non eliminabile.
2. **Pagina impostazioni Negozio**: spostata in una pagina indipendente e accessibile dalle Impostazioni principali.
3. **Sfondo predefinito Compiti**: chiarita la formulazione nel dialogo di aiuto.
4. **Indicatore Completamento rapido**: se attivo, la pagina Compiti mostra un indicatore in alto dello stato Completamento rapido.
5. **Memoria piega per elenco**: lo stato piega/espandi è registrato per elenco per evitare che «Tutti» influisca sull'elenco del giorno.
6. **Dialogo scaduti (modalità scura)**: migliorati gli stili modalità scura durante la gestione Compiti scaduti.
7. **Logica pulsante filtro Riflessioni**: mostrato solo per i tipi che supportano il filtro (Oggetti/Compiti).
8. **Flusso squadra solo Compiti locali**: interazione migliorata raccogliendo solo Compiti locali.
9. **Perfezionamento UI pagina Sintesi**: layout e feedback visivo della pagina Sintesi per una presentazione più fluida.
10. **Perfezionamento interazioni Oggetti**: interazioni relative agli Oggetti semplificate per una risposta più reattiva.

**🐛 Correzioni bug**

1. Corretto un problema per cui la barra filtri superiore non si visualizzava correttamente dopo il filtro nella pagina Cronologia.
2. Corretto un problema per cui i Compiti negativi potevano non calcolare le penalità con il conteggio penalità 1× corretto in certi casi.
3. Corretto un problema per cui il selettore Compiti del timer Pomodoro poteva perdere l'opzione «Annulla selezione» in certe condizioni.
4. Corretti diversi problemi legati al seguire le impostazioni modalità scura di sistema.
5. Corretto un popup Ricompensa mancante quando un widget completava un Compito a conteggio.

**v1.100.6 (2025/11/08)**

**🐛 Correzioni bug**

1. Corretto un crash selezionando Oggetti se il focus input traboccava per tastiere/gamepad esterni; efficacia correzione in verifica.
2. Corretto il dialogo gestione fuso orario intelligente così può scorrere per mostrare contenuto e pulsanti inferiori.

**v1.100.5 (2025/09/28)**

**✨ Novità**

1. **Effetti sonori personalizzati supportano selezione suoni integrati**: accesso a una libreria di effetti audio integrati per personalizzazione più comoda.
2. **Filtro Sintesi migliorato**: aggiunta opzione filtro «Mostra solo sintetizzabili» nella pagina Sintesi per migliore gestione Oggetti.
3. **Supporto emoji API**: le API Oggetti, Attributi e Obiettivi supportano ora input emoji diretto per personalizzazione migliorata.
4. **Miglioramenti creazione squadra**: aggiunta possibilità di selezionare elenchi destinazione creando squadre per organizzazione migliore.
5. **Copia Compiti squadra**: supporto copia Compiti squadra come Compiti locali senza richiedere appartenenza alla squadra.
6. **Miglioramento API Compiti**: aggiunto supporto parametro per impostare stato «font nota chiara» nelle API relative ai Compiti.

**♻️ Ottimizzazione**

1. **Migliorata logica «annulla modifiche»**: ottimizzato dialogo conferma annulla modifiche per modifica Oggetti, Sintesi, Obiettivi ed elenchi Obiettivi — compare ora solo se sono state effettuate modifiche reali.
2. **Condizioni sblocco Obiettivo**: le condizioni sblocco Obiettivo sono ora espanse per impostazione predefinita per migliore visibilità.
3. **Prestazioni Sintesi migliorate**: ottimizzate prestazioni query pagina dettaglio Sintesi.
4. **Stabilità API toast**: migliorata stabilità e affidabilità chiamate API toast.
5. **Flusso completamento Compiti squadra**: processo completamento Compiti squadra migliorato con gestione errori e guida utente migliori.
6. **Comportamento trascinamento Sintesi**: migliorato scorrimento trascinando al bordo durante ordinamento personalizzato Oggetti nella pagina Sintesi.
7. **Flusso raccolta Compiti squadra**: flusso di lavoro migliorato dopo raccolta Compiti squadra con supporto salto agli elenchi corrispondenti.
8. **Ottimizzazione promemoria calendario**: logica promemoria calendario migliorata per maggiore affidabilità.

**🐛 Correzioni bug**

1. Corretto problema per cui sfondi personalizzati di versioni precedenti usavano erroneamente lo stato predefinito globale «font nota chiara».
2. Corretti problemi adattamento barra di stato nella pagina effetti sonori personalizzati.
3. Corretto possibile sovrapposizione descrizione Obiettivo con pulsanti sblocco.
4. Corretti problemi scorrimento durante ordinamento trascinamento nella pagina dettaglio Sintesi.
5. Corretta scomparsa occasionale pulsante ricerca quando il modulo Mondo è nella barra laterale.
6. Tentativo di correzione anomalie seguito modalità notte di sistema.
7. Tentativo di correzione problema per cui completamenti consecutivi Compiti squadra potevano duplicare Compiti.
8. Corretto malfunzionamento «Riflessioni» durante sblocco Obiettivi.

**v1.100.4 (2025/09/07)**

**♻️ Ottimizzazione**

1. **Miglioramenti reporting crash**: raccolta e segnalazione crash migliorate per analisi e debug più efficaci.

**🐛 Correzioni bug**

1. Corretto un crash causato da Facebook SDK.

**v1.100.3 (2025/09/06)**

**🐛 Correzioni bug**

1. Corretto un problema per cui la ricerca non funzionava selezionando Oggetti.

**v1.100.2 (2025/09/05)**

**🐛 Correzioni bug**

1. Corretto un problema per cui **l'elenco predefinito non poteva essere selezionato** in certe situazioni creando o modificando Oggetti nel Negozio.

**v1.100.1 (2025/09/03)**

**✨ Novità**

1. **Opzioni colore font sfondo personalizzato**: aggiunto supporto opzioni colore font nota personalizzate, per personalizzare ulteriormente l'interfaccia.
2. **Effetti uso Oggetti migliorati**: gli effetti riduzione monete casuali supportano ora anche l'attivazione della funzione «Limita utilizzo».

**♻️ Ottimizzazione**

1. **Ottimizzazione promemoria calendario**: aggiunte opzioni per regolare la durata degli eventi promemoria calendario inseriti.
2. **Ottimizzazione interazione modifica Compiti**: migliorata logica popup «annulla modifiche» in modifica Compiti — non compare più uscendo senza modifiche.
3. **Aggiornamenti localizzazione multilingue**: aggiornati testi multilingue localizzati per migliorare l'esperienza utente.

**🐛 Correzioni bug**

1. Corretto **adattamento modalità scura pagina configurazione compatibilità e pagina impostazioni promemoria**.
2. Tentativo di correzione **crash legati a popup e focus metodo di input** su più pagine, migliorando stabilità App.
3. Corretto problema per cui **modificando Obiettivi non era possibile cambiare se usare automaticamente gli Oggetti**.

**v1.100.0-alpha (2025/07/29)**

**✨ Novità**

1. **Timer Pomodoro, Punti Esperienza, cronologia Inventario, dettagli monete**: aggiunto salto con un clic alla pagina statistiche corrispondente.
2. Supporto impostazioni eventi promemoria più flessibili (X minuti prima di inizio o scadenza).
3. Supporto nascondere elenchi Sintesi.
4. Supporto modifica Attributi per conteggi passi e Ricompense persistenza.
5. Supporto personalizzazione moduli funzionali barra laterale (ad es. Negozio, community nella barra laterale o nascondere moduli non necessari).
6. Aggiunta opzione sperimentale **«Modalità bassa restrizione»**: allenta limiti numerici nell'App (Punti Esperienza, cifre monete, numero Attributi selezionabili per Compiti).
7. Ottimizzati UI e logica interazione popup gestione scaduti.
8. Aggiunta descrizione opzioni uso automatico Oggetti.
9. Supporto ulteriori condizioni sblocco ripetibili:
   - Acquisizione albero Pomodoro giornaliera.
   - Tempo Concentrazione Pomodoro giornaliero.
   - Completamento giornaliero di N Compiti diversi.
   - Uso giornaliero di un Oggetto specifico N volte.
   - Completamento giornaliero di un Compito specifico N volte.
10. Opzioni elenco intelligente migrate al popup gestione elenchi (tocca pulsante elenco in alto nella pagina elenco Compiti).
11. Aggiunta opzione **«Completamento rapido»**: se attiva, completare Compiti salta tutti i popup.
12. Esteso ambito icone monete personalizzate, ora supporta icone monocromatiche (ad es. icone monete in alto nel Negozio).
13. I dettagli Oggetto identificano ora a quale elenco appartiene l'Oggetto, facilitando conferma proprietà da Inventario.
14. Modificando ricette Sintesi, supporto trascina-per-ordinare e clic-per-modificare Oggetti.
15. Aggiunta API per modificare direttamente il numero di monete.
16. API query supporta interrogazione informazioni Pomodoro (conteggio Pomodoro).
17. Limiti numerici di alcune API allentati (API predefinita a bassa restrizione).
18. **Riprogettato e ottimizzato meccanismo calcolo progresso condizioni Obiettivo**: migliorate prestazioni calcolo e velocità aggiornamento progresso.

**♻️ Ottimizzazione**

1. Ottimizzati giorni persistenza nella pagina **«Io»**, supporto clic manuale per ricalcolare.
2. Corretti problemi layout RTL pagina calendario, inizio settimana impostato a **«Lunedì»** (prima domenica).
3. Visualizzazione gruppi negli elenchi intelligenti Compiti e Negozio supporta piega/espandi per etichette gruppo.
4. Quando l'elenco Compiti espande completati, non iniziati, congelati in basso, le etichette corrispondenti compaiono anche in alto.
5. Icone Oggetti importate dal modulo Mondo salvate localmente in modo persistente, evitando impossibilità di caricamento offline.
6. Popup selezione elenco identifica ora elenchi intelligenti.
7. Ottimizzata logica elenco predefinito per Compiti squadra e Compiti casuali: se l'elenco predefinito è archiviato, seleziona per impostazione predefinita il primo elenco.
8. Ottimizzata logica gestione scaduti Compiti a conteggio: se il conteggio è raggiunto, stato predefinito **«Completato»**.

**🐛 Correzioni bug**

1. Corretto problema per cui lo stato casella **«uso automatico Oggetto»** non veniva ripristinato correttamente modificando Obiettivi.
2. Corretto conteggio scheda superiore elenco intelligente: non escludeva Compiti appartenenti a elenchi archiviati.
3. Corretto problema memoria globale stato casella **«uso automatico»** acquisto Oggetti, cambiato in memoria indipendente per Oggetto.
4. Corretto problema per cui l'API sblocco Obiettivo non aggiornava correttamente il progresso in certe situazioni.
5. Corretti problemi logica elenco predefinito per Compiti squadra e Compiti casuali.
6. Aggiornamenti librerie dipendenze tecniche, versione API target regolata a 35 (Android 15).

**Correzioni patch Alpha/Beta**

1. Rimosse dipendenze non necessarie e adattamento a page size 16K, **riducendo dimensione pacchetto App**.
2. Corretta logica funzionalità **uso automatico Oggetto**: per Oggetti URL, ora viene usato solo 1 Oggetto e il resto va in Inventario. (Prima ne aveva effetto solo 1 ma non veniva salvato in Inventario, causando perdita effetto uso)
3. Corretto problema per cui **condizioni Obiettivo ripetibili** non potevano ricalcolare il progresso.
4. Corretto problema per cui **file backup** non includevano template Compiti.
5. Corretto problema per cui la maggior parte delle emoji rigenerava icone anomale dopo ripristino backup.
6. Aggiornato **link canale QQ** per feedback in-App.
7. Aggiunta funzione **broadcast pubblicazione Riflessioni**.
8. **Riprogettata** interfaccia configurazione compatibilità e impostazioni metodo promemoria.
9. Aggiunta opzione «Limita utilizzo Oggetto» per **effetti riduzione monete**.
10. **Aggiornamenti API**: aggiunto supporto API Compiti per parametri messaggio motivazionale.
11. Corretto anomalo spazio superiore pagina impostazioni predefinite nuovo Oggetto.

**v1.99.5 (2025/07/29)**

**🐛 Correzioni bug**

1. Tentativo di correzione problema per cui sfondi personalizzati potevano non visualizzarsi correttamente in certe situazioni.

**v1.99.3 (2025/06/30)**

**✨ Novità**

1. API sottocompiti supporta regolazione relativa (set_type).
2. Supporto pulizia automatica eventi promemoria calendario scaduti.
3. Ottimizzata logica elaborazione elenchi archiviati:

* Gli elenchi intelligenti non mostrano più Compiti archiviati.
- I Compiti negli elenchi archiviati non avanzano automaticamente per impostazione predefinita (simile a stato congelato).

**♻️ Ottimizzazione**

1. Aggiungendo continuamente Compiti/Obiettivi, supporto scorrimento automatico in alto e focus sul campo input.
2. Ottimizzata formulazione relativa al completamento Compiti negativi.
3. Ottimizzata logica visualizzazione popup «Annulla modifiche» nella pagina modifica Compito.
4. Ottimizzata durata eventi promemoria calendario per evitare potenziali problemi su alcuni dispositivi.

**🐛 Correzioni bug**

1. Corretto problema per cui i widget non supportavano visualizzazione icone monete personalizzate.
2. Corretto problema per cui la pagina dettaglio Compito non supportava visualizzazione Ricompense multi-Oggetto.
3. Corretti problemi per cui certi scenari (ad es. widget) potevano non rispettare regole ordinamento elenchi.

**v1.99.1-rc02 (2025/06/20)**

**✨ Novità**

1. Supporto condizioni sblocco Obiettivo ripetibili per «Completa N Compiti consecutivi».
2. API Nuovo/Modifica Compito supporta ora tipo Compito e regolazione relativa valori oro/esperienza.
3. API Obiettivo supporta impostazione oro e regolazione relativa valori oro/esperienza.
4. Le API supportano salto a elenchi Obiettivi e elenchi Sintesi specifici.

**♻️ Ottimizzazione**

1. Ottimizzato ordine record cronologia Oggetti Inventario generati aprendo Bottini.
2. Opzioni filtro pagina statistiche supportano ora memoria.
3. Opzioni pagina filtro supportano operazione «Seleziona tutto».
4. Rafforzata logica intercettazione deduplicazione creazione Compiti.
5. Operazioni pagina dettaglio Compito integrate: congela, regola scadenza.
6. Supporto visualizzazione ID elenco Sintesi.

**🐛 Correzioni bug**

1. Corretto problema per cui la precedente API Compiti non poteva creare/modificare Compiti Ebbinghaus.
2. Corretto problema per cui visualizzazione elenco Compiti e nome elenco nella barra superiore potevano essere incoerenti avviando l'App dal widget elenco Compiti.
3. Corretto problema per cui il testo nella scheda modalità semplice poteva non essere visualizzato per intero.

**v1.99.0 (2025/05/17)**

**✨ Novità**

1. Aggiunto supporto tipi Obiettivo ripetibili
2. Aggiunte azioni promemoria notifica: completa Compito, ricorda più tardi
3. Sfondo personalizzato: aggiunta opzione per migliorare leggibilità testo
4. Aggiunto supporto regolazione stili ritaglio icona Obiettivo
5. Aggiunto supporto regolazione date ancoraggio Compiti mensili/annuali

**♻️ Ottimizzazione**

1. Ottimizzata logica calcolo progresso sblocco Obiettivo
2. Migliorate interazioni selezione prodotti
3. Regolata posizione pulsante permesso promemoria nelle schermate nuovo/modifica Compito
4. Ottimizzata logica archiviazione ora promemoria relativa
5. Consentito congelamento Compiti non ricorrenti e ricorrenti all'infinito

**🐛 Correzioni bug**

> Alcune correzioni verranno distribuite gradualmente a [Versione stabile membri] e [Versione ufficiale]

1. Corretto problema per cui modificare Obiettivi poteva reimpostare accidentalmente progresso condizioni sblocco API
2. Corretto problema per cui prodotti con stock 0 potevano ancora essere acquistati via API
3. Corretto problema per cui elenchi eliminati potevano essere selezionati nella pagina nuovo prodotto in certe condizioni
4. Corretto problema per cui i template Compiti non potevano salvare stato Ricompensa monete calcolata automaticamente
5. Rimosse animazioni transizione pagina dettaglio per correggere malfunzionamenti interazione pressione prolungata
6. Corretto problema per cui Compiti congelati comparivano nella selezione Compiti Pomodoro
7. Corretto problema per cui modificare Compiti con certi metodi reimpostava erroneamente lo stato a incompleto
8. Corretti problemi interazione popup Riflessioni

**v1.98.5 (2025/05/01)**

**✨ Novità**

1. Aggiunto supporto impostazione date ancoraggio (ad es. fine mese) per Compiti ricorrenti mensili e annuali.
2. Migliorata interazione selezione multipla prodotti: modalità selezione multipla predefinita e ripristino selezioni precedenti riselezionando.

**♻️ Ottimizzazione**

1. Aggiunto supporto memorizzazione impostazioni ora promemoria relativa.
2. Piccole ottimizzazioni UI.

**🐛 Correzioni bug**

1. Corretto problema per cui i prodotti potevano ancora essere acquistati via API con stock Negozio insufficiente.
2. Corretto problema per cui i template Compiti non ripristinavano Ricompense monete automatiche.
3. Corretto occasionali malfunzionamenti pressione prolungata sui titoli Compiti.
4. Corretto problema per cui nuovi prodotti potevano selezionare elenchi eliminati in certe condizioni.
5. Corretto pulsante cancella mancante nel campo ora promemoria modificando Compiti.

**v1.98.4 (2025/04/14)**

**🐛 Correzioni bug**

1. Corretto un problema per cui la barra progresso poteva non aggiornarsi prontamente dopo completamento sottocompiti nella pagina dettaglio Compito.
2. Corretto un problema per cui modificare un Compito completato poteva reimpostare erroneamente lo stato a «incompleto».
3. Corretto un problema per cui modificare lo stato di Compiti scaduti poteva influire erroneamente sul conteggio completamento obiettivo.
4. Corretto un problema per cui la logica selezione Compiti Pomodoro mostrava erroneamente Compiti congelati ed elenchi archiviati.

**v1.98.3 (2025/02/16)**

**♻️ Ottimizzazione**

1. Aggiunto avviso usando il metodo promemoria notifica predefinito senza permesso «allarme esatto».

**🐛 Correzioni bug**

1. Corretto un problema per cui l'API «completa Compito» non funzionava quando il campo UI era true.
2. Corretto un problema per cui acquisto e uso di certe quantità di Oggetti potevano non funzionare correttamente (ad es. 10).
3. Corretto un problema per cui la pagina Riflessioni poteva mostrare «caricamento» indefinitamente in certi scenari.

**v1.98.2 (2025/02/06)**

**🐛 Correzioni bug**

1. Corretto un problema per cui, usando un Oggetto che deduce esperienza, poteva risultare esperienza insufficiente anche quando ce n'era abbastanza.
2. Corretto un problema per cui modificare un Oggetto dopo averlo copiato poteva generare effetti uso duplicati anomali.
3. Corretto un problema per cui chiamare l'API «regola Oggetto» poteva generare limiti acquisto anomali.
4. Corretto un problema per cui modificare certi registri Pomodoro poteva ridurre anormalmente i conteggi Pomodoro.

**v1.98.1 (2025/01/14)**

**🐛 Correzioni bug**

1. Tentativo di correzione problema autorizzazione accesso Google, per cui i dati di un numero limitato di account non potevano essere autorizzati e analizzati correttamente.

**v1.98.0 (2025/01/01)**

**✨ Novità**

1. Integrati accesso Google e autorizzazione Drive tramite Credential Manager.
2. Supporto selezione Emoji come icone.
3. Aggiunta API query ContentProvider: funzionalità Sintesi.
4. Aggiunta API query ContentProvider: funzionalità registro Pomodoro.
5. Aggiunta API query ContentProvider: supporto restituzione multipli Oggetti.
6. Aggiunta API Pomodoro (regola conteggio Pomodoro).
7. Aggiunta API export_backup (esporta backup).
8. Aggiunta API purchase_item (acquista Oggetto).
9. Aggiunta API synthesize (attiva Sintesi).
10. Aggiunta API subtask (crea o regola sottocompiti).
11. Aggiunta API subtask_operation (opera sottocompiti, ad es. completa).
12. Aggiunta API synthesis_formula (formula Sintesi).
13. Aggiunta API edit_task (modifica Compito).
14. Aggiunta API category (crea o regola elenco).
15. Aggiunta API history_operation (regola cronologia).
16. Aggiunta API AppSettingsScheme (regola alcune impostazioni App).
17. Aggiunta API achievement (crea o modifica Obiettivo).
18. Aggiunta API skill (crea o modifica Attributo).
19. Aggiunto supporto visualizzazione id e gid sottocompiti.
20. Aggiunto supporto visualizzazione id Sintesi.
21. Aggiunto supporto interrogazione creditLimit.
22. API ContentProvider supporta interrogazione sottocompiti (id, gid).
23. API ContentProvider query Oggetti: aggiunta restituzione campo «quantità massima acquistabile».
24. API ContentProvider Negozio supporta interrogazione Oggetti per elenco id specificato.
25. Ottimizzato valore restituito interrogando URL ContentProvider errato.
26. Interfaccia query supporta interrogazione singolo Obiettivo.

**♻️ Ottimizzazione**

1. Ottimizzato ordinamento personalizzato predefinito per nuovi Oggetti aggiunti.
2. Ottimizzato ordinamento personalizzato predefinito per nuovi Attributi aggiunti.
3. Aggiunti parametri `purchase_limit`, `disable_use` ed `effects` all'API «add_item».
4. Aggiunti parametri `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` e `pin` all'API «add_task».
5. Aggiunto supporto ulteriori frequenze Compito all'API «add_task».
6. Aggiunto supporto parametri `effects` e `purchase_limit` all'API «item».
7. Aggiunto supporto terminazione operazioni nelle API precedenti (ad es. input).
8. Aggiunto supporto specifica parametro `signed` per segnaposto numerici.
9. Aggiunti segnaposto numero casuale e decimale casuale.

**v1.97.3 (2024/12/16)**

**✨ Novità**

1. Consente di memorizzare l'ultima selezione dell'interruttore «Usa la descrizione della squadra come note del Compito».

**♻️ Ottimizzazione**

1. Ottimizzate le prestazioni relative all'effetto d'uso dei prodotti.

**🐛 Correzioni bug**

1. Corretto il problema di fallimento di specifiche chiamate API. Usando una specifica funzione di callback per chiamare l'API prodotto, la funzione di decompressione funziona normalmente, ma l'operazione API interna per aggiungere Oggetti non può essere eseguita.

**1.97.2 (2024/12/08)**

**✨ Novità**

1. Aggiunta generazione automatica Compiti tramite il meccanismo WorkManager di sistema, per evitare Compiti mancanti quando i widget non sono usati e l'App non è stata avviata da oltre un giorno.
2. Migliorata la gestione eccezioni API restituendo un campo success unificato e passando le informazioni sull'eccezione all'interfaccia content provider.

**♻️ Ottimizzazione**

1. Ottimizzata la logica predefinita di generazione orari per migliorare l'accuratezza della generazione oraria mensile e annuale.
2. Ottimizzata la logica di eliminazione file immagine inutilizzati aggiungendo un passaggio di verifica secondaria dal database per evitare cancellazioni accidentali.

**🐛 Correzioni bug**

1. Migliorati i messaggi di errore API quando le entità non vengono trovate.
2. Corretti problemi di concorrenza nel downloader integrato.
3. Corretta la logica statistiche Pomodoro per scenari a cavallo di giorni, unificando l'attribuzione dei registri al periodo temporale dell'ora di fine (in precedenza i registri a cavallo di giorni non potevano essere attribuiti correttamente al periodo del giorno).
4. Corretti problemi per cui continuità Compiti e conteggi completamento per periodo potevano essere errati in certi scenari.

**1.97.1 (2024/11/20)**

**✨ Novità**

1. Aggiornate le traduzioni.
2. Supportata la visualizzazione automatica di più Ricompense Oggetto nelle note.

**♻️ Ottimizzazione**

1. Ottimizzata la gestione richieste di rete per ridurre richieste HTTP non necessarie e migliorare le prestazioni.
2. Ottimizzata la visualizzazione del Livello nella pagina stato, migliorando l'esperienza visiva e l'efficienza nel trasmettere informazioni.

**🐛 Correzioni bug**

1. Corretto il colore del testo conteggio sottocompiti.
2. Corretti errori calcolo orario per Compiti mensili e annuali, garantendo orari di attivazione accurati.
3. Corretti problemi calcolo orario per sottocompiti mensili e annuali, garantendo pianificazione accurata di tutti i sottocompiti.
4. Corretto il problema per cui lo sfondo Compito non poteva essere ripristinato correttamente dal template Compito, garantendo l'applicazione corretta delle impostazioni sfondo.

**1.97.0 (2024/10/21)**

**♻️ Ottimizzazione**

1. Ottimizzato l'effetto visivo delle schede Compito per Compiti non avviati.
2. Risolti alcuni problemi di prestazioni.
3. Ottimizzata la pagina dettaglio Compito, risolvendo il problema per cui cliccare il nome Compito occasionalmente non attivava le interazioni.

**✨ Novità**

1. Aggiunti campi formato JSON al broadcast API per Compito scaduto.

**🐛 Correzioni bug**

1. Corretto un problema per cui abilitare Material 3 causava crash eseguendo certe API relative all'UI.
2. Rimossi alcuni obsoleti opzioni sperimentali, come l'interruttore Riflessioni e il nuovo interruttore Attributi.

**🎉1.97.0-rc (2024/09/11)**

**✨ Novità**

**Aggiornamenti principali**

- Questo aggiornamento si concentra principalmente su ottimizzazioni prestazioni e correzioni bug.
- Prestazioni generali dell'App significativamente ottimizzate. Recupero elenchi Compiti e varie operazioni sono ora più fluidi. La versione API Android di destinazione è aggiornata ad Android 14.

**Altro**

1. Quando le monete non sono sufficienti, il pulsante acquisto Oggetto ora appare disabilitato.
2. Aggiunta la possibilità di cercare Obiettivi per nome nell'elenco Obiettivi 🔍.
3. Aggiunto supporto impostazioni dimensione carattere nell'App.
4. Ottimizzata la logica casuale per Mondo → Compiti casuali, riducendo la frequenza con cui compare l'ultimo lotto di Compiti per una randomizzazione maggiore.
5. Ottimizzata la logica raggruppamento notifiche; notifiche come sblocco Attributi e Obiettivi dovrebbero ora raggrupparsi correttamente.
6. Statistiche → Condividi supporta ora l'attivazione/disattivazione della visualizzazione codici QR.

**♻️ Ottimizzazioni**

1. Ottimizzata la logica accesso di rete.
2. Aggiunto effetto sfocatura sfondo ai popup.
3. Ottimizzati i pulsanti nelle pagine Negozio, Inventario e vetrina, ora con stili pulsante Material ufficiali.
4. L'API Content Provider per interrogare i registri cronologia Compiti restituisce ora l'ora di fine del Compito.
5. L'API Content Provider per interrogare i registri cronologia Compiti supporta ora il filtro per Group Id del Compito.
6. Aggiornate le versioni di molte dipendenze.
7. L'API Goto supporta ora la navigazione alla pagina «Impostazioni predefinite nuovo Oggetto».
8. Navigando alla pagina «Crea Obiettivo» tramite l'API Goto, il parametro category_id è ora obbligatorio.
9. Aggiunta guida in-App per effetti link Compito, Compito contatore e Oggetto nell'API.
10. Ottimizzata logica e messaggi di errore per nuovi utenti che controllano aggiornamenti.
11. Aggiunti messaggi caricamento ed errore per operazioni eliminazione account.
12. Ottimizzata l'area cliccabile per completare il Compito principale nella pagina dettaglio Compito.
13. Migliorato il messaggio di errore importando backup, impedendo ora più rigorosamente l'importazione di file backup non validi.

**🐛 Correzioni bug**

1. Corretto un problema per cui, creando un nuovo Compito, se il messaggio di errore per contenuto Compito vuoto veniva attivato per primo, il messaggio non scompariva automaticamente anche dopo l'inserimento del testo.
2. Corretto un problema per cui il pulsante filtro non veniva visualizzato nella pagina Statistiche in modalità barra navigazione inferiore.
3. Corretti problemi layout su certi dispositivi a schermo piccolo con rapporto d'aspetto stretto.
4. Corretto un problema per cui le Ricompense sottocompiti potevano collegarsi in modo anomalo copiando Compiti (problema presente dalla versione 1.96.0).
5. Corretti messaggi di errore causati da connessione Dropbox anomala durante backup automatico Dropbox.
6. Tentativo di correzione consumo memoria e crash durante anteprima immagini estremamente grandi.
7. Corretto un problema per cui, dopo acquisto Oggetto e marcatura per uso, i dati widget non si aggiornavano correttamente se l'uso falliva.
8. Corretto un problema per cui modificare un Obiettivo cambiava l'ora completamento e poteva attivare erroneamente notifiche sblocco Obiettivo.
9. Corretto un problema per cui, in modalità schermo diviso su schermi grandi con pagina elenco Compiti e dettaglio entrambe visibili, completare Compiti, sottocompiti o aggiornare contatori non sincronizzava le due pagine.
10. Corretto un problema per cui pressione prolungata su Compiti singoli scaduti nell'elenco Compiti non consentiva di cancellare la visualizzazione scadenza.

**1.96.1(2024/07/11)**

**🐛 Correzioni bug**

1. Corretto un problema per cui il conteggio Oggetti Ricompensa visualizzato era errato completando sottocompiti (le Ricompense effettive non erano interessate).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Novità**

**Aggiornamenti principali**

1. Completando Compiti o sbloccando Obiettivi, gli Oggetti possono ora essere usati direttamente per attivare effetti Oggetto.
2. Il limite al numero di Oggetti usati contemporaneamente è ora rilassato a 1000.
3. L'acquisto di Bottini o Oggetti Sintesi supporta ora anche l'uso diretto (apri/sintetizza).
4. I Compiti di squadra supportano ora la pubblicazione di Riflessioni nelle Riflessioni locali.
5. Gli URL Scheme di terze parti nelle note Compito sono ora supportati per parsing e navigazione diretti.
6. La pagina Cronologia supporta ora la ricerca registri storici per note Compito.
7. Aggiunto supporto cronometraggio Compiti storici.
8. La pagina Statistiche supporta ora il filtro per categorie principali.
9. Refactoring popup Ricompense e penalità esperienza Attributi: ottimizzata la logica limiti selezione Attributi uso Oggetti e separati i popup riduzione esperienza Attributi per scadenza.

**♻️ Ottimizzazioni**

1. L'effetto UI selezione singola scegliendo Oggetti è ora coerente con la selezione multipla.
2. Ottimizzata la velocità caricamento elenco Compiti.
3. Aggiungendo o modificando Compiti, l'ora scadenza non deve più essere successiva all'ora corrente, offrendo flessibilità per creare registri storici.
4. Se la visualizzazione id dati è abilitata, il popup Riflessioni visualizza ora anche l'id corrispondente.
5. Ottimizzati problemi prestazioni relativi al popup elaborazione scadenza.
6. Unificato l'ordine pulsanti per stati cronometro countdown e pausa.
7. L'interazione per eliminare post nella pagina Mondo → Profilo personale è ora più intuitiva.
8. Ottimizzati effetti caricamento pagine Riflessioni e Obiettivi.

**🐛 Correzioni bug**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Novità**

**Aggiornamenti principali**

1. Supporto visualizzazione schermo diviso in-App su dispositivi a schermo grande come tablet e schermi pieghevoli

**♻️ Ottimizzazioni**

1. I widget Negozio e Inventario supportano ora effetti ritaglio immagine coerenti in-App
2. Nella pagina statistiche, quando è selezionato un solo giorno, sono ora supportati i grafici a linee

**🐛 Correzioni bug**

1. Corretto un problema per cui il tipo Compito veniva visualizzato in modo errato modificando Compiti API
2. Corretto un problema con statistiche anomale completamento, abbandono e scadenza Compiti nella pagina statistiche

**1.94.3 (2024/05/10)**

**♻️ Ottimizzazioni**

1. I widget tentano ora di aggiornare il tema ad adattarsi quando cambia la modalità scura di sistema
2. Quando il modulo «Mondo» è nascosto, la notifica punto rosso per Obiettivi di sistema non conta più dati relativi al modulo «Mondo»

**🐛 Correzioni bug**

1. Corretto un problema crash a bassa probabilità selezionando più Oggetti
2. Corretto un problema crash a bassa probabilità relativo a finestre popup
3. Corretto un problema per cui il widget Inventario poteva non aggiornarsi chiamando l'API modifica Oggetto
4. Corretto un problema per cui il widget Inventario poteva usare Oggetti «non utilizzabili»

**1.94.2 (2024/04/26)**

**🐛 Correzioni bug**

1. Corretto un problema con calcoli anomali conteggio corrente Compito (che causava progresso impreciso per Compiti con conteggio ripetizioni obiettivo impostato)
   - Questa correzione annulla un'ottimizzazione precedente relativa alle prestazioni annullamento Compiti, in attesa di una soluzione più ragionevole in futuro

**1.94.1 (2024/04/22)**

**🐛 Correzioni bug**

1. Corretto un problema per cui il conteggio Pomodoro risultava uno in meno del reale usando cronometro, aggiungendo tempo via API o aggiungendo manualmente registri tempo.
2. Corretto un glitch per cui la barra selezione poteva lampeggiare e scomparire dopo aver selezionato Oggetti nelle pagine Negozio/Inventario e poi scorrendo.

**🎉1.94.0 (2024/04/22)**

**Aggiornamenti principali**

1. Supporto Ricompense multiple Oggetto
2. Widget Inventario

**Temi UI**

1. I colori personalizzati (testo Compito, Oggetto) includono ora più valori preimpostati
2. Adattamento alla funzione icona adattiva monocromatica di Android 14
3. Aggiunte molte adattamenti linguistici (versione Google Play)

**Obiettivi**

1. Se ci sono Obiettivi con Ricompense non riscattate, un piccolo punto rosso viene ora mostrato sull'elenco Obiettivi.

**Compiti**

1. I sottocompiti per Compiti penalità eseguono ora correttamente la logica penalità
2. Aggiunta «Gestione intelligente fuso orario»; se lavori attraverso fusi orari, LifeUp supporta anche il rilevamento automatico cambi fuso orario e regolazioni orarie globali
3. La base statistiche nella pagina dettagli ricorda ora l'ultima selezione; ottimizzati alcuni valori predefiniti in certi scenari
4. Ottimizzata la gestione tolleranza giorni completamento Compiti consecutivi nella pagina «La mia pagina»: se dimentichi di completare un Compito un giorno, recuperare può ancora continuare la serie

**Attributi**

1. Supporta eliminazione registri esperienza
2. Supporta reimpostazione esperienza di un singolo Attributo

**Widget**

1. Cliccando lo spazio vuoto nei widget Negozio o Inventario si entra ora direttamente nell'elenco a cui punta il widget, invece dell'ultimo elenco
2. I widget Compiti visualizzano ora il progresso dei Compiti contatore

**API**

1. Aggiunta API modifica registri Pomodoro
2. L'API completa Compiti gestisce ora correttamente anche Compiti penalità
3. L'API completa Compiti supporta ora anche Compiti contatore (aggiunge parametro `count`)
4. L'API completa Compiti supporta ora un parametro coefficiente Ricompensa
5. L'API regola Oggetti supporta ora modifica id elenco Oggetti
6. Le API crea/regola Oggetti supportano parametro criteri ordinamento
7. L'API Jump supporta ora salto al popup usa Oggetto
8. Unificate alcune definizioni parametri, ad es. `itemId` → `item_id`
9. Aggiunte notifiche broadcast avvio, pausa e fine cronometro
10. `title_color_string` dell'API regola Oggetti supporta ora stringa vuota per ripristinare valore predefinito
11. Il broadcast completa Compiti include ora id elenco
12. Apertura scatole e crafting attivano ora anche il broadcast usa Oggetto

**♻️ Ottimizzazioni**

1. Aggiungendo o modificando Compiti compare ora un avviso se nessun Attributo è selezionato ma è inserita esperienza
2. Ottimizzati registri tentativi upload
3. Ottimizzata visualizzazione titolo e restrizioni input nella pagina Livelli personalizzati
4. Ottimizzate prestazioni e problemi temporizzazione annullamento Compiti ripetuti molte volte
5. Refactoring popup usa Oggetto, logica interfaccia calendario, ecc.
6. Ottimizzata logica promemoria Compiti, garantendo che promemoria da dati eliminati o precedenti non vengano emessi di nuovo
7. Ottimizzato testo attesa nell'interfaccia backup
8. Le immagini selezionate nella pagina Attributo personalizzato vengono ora aggiunte anche alla cronologia selezione
9. Modificando registri Pomodoro si tenta ora di correggere (aumentare o diminuire) il numero corretto di Pomodoro

**🐛 Correzioni bug**

1. Corretto un Obiettivo di sistema relativo a statistiche e backup non attivato normalmente dopo ristrutturazione
2. Corretti potenziali conflitti tra widget API random e toast con toast predefinito
3. Corretto il dettaglio Compito che non si aggiornava in alcuni scenari entrando da un widget
4. Corretto potenziale errore in aperture multiple scatole in situazioni speciali (consumo preventivo Inventario Oggetti)
5. Corretto il problema di sottocompiti non visualizzati nella pagina dettagli dopo modifica Compito senza sottocompiti e aggiunta di nuovi
6. Corretti alcuni casi speciali in cui non era possibile modificare Ricompense monete
7. Corretti alcuni casi in cui il riscatto Oggetti squadra poteva non funzionare
8. Corrette anomalie stile MD2 in alcuni popup inferiori
9. Corretti potenziali valori tempo aggiuntivo errati nei timer Pomodoro
10. Corretto il problema per cui la barra colore nel widget variazione esperienza poteva non visualizzarsi
11. Corretti alcuni Compiti non visualizzati correttamente nel calendario in corso
12. Corretti alcuni problemi caricamento elenco nelle pagine cronologia e Riflessioni
13. Corretto un problema per cui chiamare l'API completa Compito due volte in rapida successione non consentiva due completamenti consecutivi

**1.93.3 (2024/01/09)**

**✨ Novità**

1. Aggiunta API [Riflessioni].

**♻️ Ottimizzazione**

1. Il calcolo indicatori valore medio nella pagina statistiche esclude ora date future.
2. Dopo aver nascosto l'elenco Obiettivi di sistema, niente più avvisi per sblocco Obiettivi di sistema.
3. Aggiornata l'API `goto` per non supportare più popup acquisto Oggetti «non acquistabili».
4. Ottimizzata modifica Compiti per risolvere il problema per cui l'input conteggio ripetizioni obiettivo veniva oscurato.

**🐛 Correzioni bug**

1. Corretto l'effetto UI edge-to-edge nella pagina Attributo personalizzato.
2. Corretto un problema per cui la penalità non veniva revocata se un Compito era impostato come abbandonato e poi completato nella pagina cronologia/calendario.
3. Corretto il problema stile visualizzazione popup inferiore e barra navigazione sistema inferiore in modalità Material2.
4. Corretto il colore bordo errato della casella input voce da fare in modalità notte.
5. Corretto un problema visualizzazione che poteva verificarsi dopo rotazione schermo in modalità navigazione sistema a tre pulsanti.

**1.93.3 (2023/12/02)**

**♻️ Ottimizzazione**

1. Aggiunta unificata parametro debug alle API per debug più semplice

**🐛 Correzioni bug**

1. Corretto il problema per cui selezionare «Ignora popup promemoria» non era efficace
2. Corretto il problema modifica Riflessioni create direttamente nella pagina Riflessioni
3. Corretto il problema per cui caricare foto dinamiche squadra consentiva selezionare fino a 9 immagini, mentre il limite reale è 3
4. Corretto il problema per cui l'API use_item non attivava effetti countdown o URL quando ui era impostato su false
5. Corretto il problema per cui usare Oggetti nel widget Negozio poteva attivare l'effetto due volte

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Ottimizzazione**

1. Ottimizzata logica upgrade database per evitare ritardi nei processi di upgrade
2. Ottimizzato valore predefinito «Ora inizio» modificando Compiti

**🐛 Correzioni bug**

1. Corretto un problema per cui modificare API prodotto causava perdita effetti uso prodotto
2. Corretto il problema per cui Compiti scaduti e abbandonati impostati come completati non ripristinavano Ricompense
3. Corretto un problema ordinamento Compiti personalizzato non conforme alle aspettative
4. Corretti problemi visualizzazione e ordinamento relativi a Compiti singoli scaduti
5. Corretto un problema eccezione SQL filtrando la pagina cronologia
6. Corretto un problema in modalità semplificata per cui cliccare di nuovo il titolo Compito non aveva risposta
7. Corretto un problema per cui rinominare template Compiti non aveva effetto

**🎉1.93.0 (2023/10/24)**

**✨ Novità**

**Tema UI**

1. Adattamento completo a Material Design 3.
2. Supporto personalizzazione colori tema Material Design 3, inclusi colori personalizzati, colori da sfondo e colori da immagini.
3. Migliorati alcuni effetti animazione, come i popup.
4. Ottimizzati effetti adattamento edge-to-edge (immersivo).

**Compiti**

1. Supporto template Compiti.
2. Le statistiche nella pagina dettagli supportano commutazione per criteri temporali e ottimizzano opzioni predefinite.
3. La pagina cronologia supporta ricerca nomi Compiti e regola UI e interazioni correlate.

**Obiettivi**

1. Supporto Obiettivi segreti.
2. Aggiungendo Obiettivi, supporto «Continua ad aggiungere Obiettivo successivo».

**Attributi**

1. Supporto nascondere Attributi.

**Timer Pomodoro**

1. Supporto modifica registri tempo.
2. Nella pagina Pomodoro, supporto completamento Compito (pressione prolungata sul Compito selezionato in modalità pausa).

**Riflessioni**

1. Supporto aggiunta Riflessioni direttamente nella pagina Riflessioni.

**API**

1. Aggiunta API «use_item».
2. Aggiunta API «random».
3. Aggiunta API «edit_exp».
4. L'API «item» supporta ora regolazione parametri come «action_text», «disable_use» e «title_color_string».
5. L'API «shop_settings» supporta parametro «silent».
6. Supporto segnaposto «time». Ora puoi impostare Compiti con date come «scade domani» o «scade il mese prossimo» senza strumenti di automazione.

**♻️ Ottimizzazione**

1. Aggiunti prefissi ad alcune visualizzazioni id dati.
2. Ottimizzata visualizzazione attività squadra.
3. Tentativo di risolvere il problema per cui alcune notifiche Toast erano troppo lunghe per essere visualizzate per intero.
4. Migliorata logica completamento widget nelle squadre, garantendo coerenza con comportamento in-App.
5. Pagina statistiche: dopo aver selezionato intervallo «Personalizzato», cliccare di nuovo «Personalizzato» attiva ora una nuova selezione date.
6. Garantita compatibilità Harmony OS 4 per notifiche barra progresso con pulsanti azione.
7. Migliorata logica interazione richieste notifica.
8. Risolto il problema per cui il metodo input poteva ostruire l'input «Conteggio ripetizioni».
9. Creando Compiti, la scelta utente di orari inizio non specifici (come automatico o scade oggi) viene registrata. Modificando, queste opzioni vengono ripristinate anziché orari specifici, per evitare discrepanze negli orari modificati.
10. Creando Compiti, se compaiono avvisi duplicati imprevisti, vengono ora mostrati anche nel popup «Controlla duplicati».
11. Aggiunto supporto lingua indonesiana.
12. Aggiornate traduzioni.

**🐛 Correzioni bug**

1. Corretto il problema per cui, in certi casi, il modulo mondo restava bloccato in caricamento (rotazione indefinita).
2. Corretto il problema per cui, in certi casi, Negozio/Inventario continuava a mostrare caricamento (rotazione indefinita).
3. Corretti problemi che potevano verificarsi chiamando API con contenuto UI tramite content provider.
4. Corretti problemi ordinamento Compiti non conformi alle aspettative.
5. Corretto il problema per cui i dati nella pagina statistiche erano errati dopo selezione intervallo «Personalizzato».
6. Corretto il problema per cui i popup richiesta notifica non supportavano scorrimento.
7. Corretto il problema per cui, in certi casi, la ricerca modulo mondo mostrava tutti i contenuti.
8. Corretto il problema per cui l'opzione «Mostra completati» mostrava anche Compiti congelati.
9. Corretti problemi calcolo valori medi nella pagina statistiche.

**1.92.2 (2023/08/29)**

**✨ Novità**

1. Grafico statistiche passi (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Ottimizzazione**

1. La nuova pagina squadra aggiunge ora un promemoria del conteggio parole corrente e del limite massimo

**🐛 Correzioni bug**

1. Corretto il problema per cui «LifeUp» poteva creare ripetutamente account promemoria calendario in certe condizioni speciali
2. Corretto il problema per cui il pulsante menu modifica squadra non veniva visualizzato correttamente
3. Corretto il problema per cui il Pomodoro poteva non attivare il promemoria vibrazione in modalità avvio automatico cronometraggio
4. Corretto il problema per cui la notifica Pomodoro poteva visualizzare erroneamente Oggetti in Concentrazione quando nessun Oggetto in Concentrazione era selezionato

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Ottimizzazione**

1. La durata nella pagina stato e pagina statistiche può ora essere visualizzata nel formato «XX giorni XX ore XX minuti».

**🐛 Correzioni bug**

1. Corretto il problema per cui l'interazione chiusura popup permesso notifica non era quella attesa su Android 12 e versioni successive.
2. Corretto il problema per cui il grafico a torta Attributi poteva visualizzarsi con colore trasparente, rendendolo invisibile.

**1.92.1-rc01 (2023/08/13)**

> Data rilascio beta chiusa membership

**✨ Novità**

1. La nuova versione statistiche integra le schede statistiche della versione precedente, ora unite in una singola pagina e adattate alla modalità barra navigazione inferiore.

2. Aggiornato meccanismo aggiornamento in-App e funzione promemoria.

   Ora supporta tre canali aggiornamento: Rilascio stabile, Versione stabile beta chiusa membership e Versione sperimentale beta chiusa membership, per concentrare gli aggiornamenti successivi sui membri beta chiusa.

3. TargetSdkVersion ora adattato ad Android 13 e richieste permesso notifica dinamiche.

4. Ridisegnata la pagina modifica profilo.

5. Versione GP: ottimizzato processo e istruzioni selezione accesso/modalità offline.

**♻️ Ottimizzazione**

1. Manutenzione e aggiornamenti dipendenze tecniche correlate.
2. Migliorato adattamento WSA e istruzioni accesso.
3. Quando il backup fallisce, compare ora un popup che spiega il motivo, evitando visualizzazione incompleta messaggi toast.

**🐛 Correzioni bug**

1. Corretto potenziale crash overflow calcolo nella pagina cronologia monete.
2. Corretta possibilità problemi menu nella pagina dettagli squadra non allineati ai permessi attesi.
3. Tentativo correzione deviazione tempo nel timer countdown.
4. Corretta interruzione processo completamento Compito e scomparsa popup scrittura riflessione causata da rotazione schermo.

**1.92.0-rc02 (2023/07/16)**

**🐛 Correzioni bug**

1. Corretto il problema per cui il widget Negozio poteva non funzionare saltando ad altre app (esecuzione API)
2. Corretta anomalia occasionale cambiando elenchi nel widget Negozio
3. Corretto il problema per cui il widget Negozio non nascondeva Oggetti esauriti o non acquistabili secondo impostazioni App
4. Corretto il problema per cui il widget Negozio poteva non rispondere cliccando un certo Oggetto
5. Corretti alcuni rari problemi crash

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Novità**

1. Statistiche 2.0
2. Scheda condividi

**♻️ Ottimizzazione**

1. Ora puoi impostare prezzi per Oggetti «non acquistabili» e usarli per scenari come resi
2. Disattivando «Imposta penalità Compito separatamente» nelle impostazioni, il pulsante penalità non viene più visualizzato
3. Ottimizzata UI sottocompiti nei dettagli squadra
4. Ottimizzata UI impressioni

**🐛 Correzioni bug**

1. Corretto il problema per cui, cambiando lo stile ritaglio Attributo in «rettangolo arrotondato», l'icona modifica poteva mostrare a lungo l'icona precedente

**1.91.3-rc04 (2023/06/07)**

**♻️ Ottimizzazione**

1. L'API salto dettagli Compito supporta ora parametri task_gid e task_name
2. Il Content Provider supporta l'URL dell'icona remota del prodotto
   - Per correggere in futuro il problema per cui alcune icone prodotto non possono essere visualizzate correttamente sul desktop

**🐛 Correzioni bug**

1. Corretto il problema per cui il widget elenco Negozio non visualizzava correttamente le monete correnti

**1.91.3 (2023/06/03)**

**✨ Novità**

1. Widget elenco Oggetti Negozio (versione grande e piccola)
2. Widget variazione giornaliera Punti Esperienza
3. Aggiunta API salto dettagli Compito
4. Riflessioni: supporto ordinamento cronologico crescente e visualizzazione anno

**♻️ Ottimizzazione**

1. Ora è supportato impostare prezzi per Oggetti «non acquistabili» e usarli in scenari come resi
2. Disattivando «Impostazione penalità Compito indipendente» nelle impostazioni, il pulsante penalità non viene più visualizzato
3. Ottimizzata UI visualizzazione sottocompiti nei dettagli squadra
4. Ottimizzata UI visualizzazione impressioni

**🐛 Correzioni bug**

1. Corretto il problema per cui, cancellando le parole motivazionali modificando un Compito, non si poteva cliccare «Conferma» per chiudere il popup
2. Corretto il problema per cui il Compito congelato non poteva essere cercato tramite API
3. Corretto il problema per cui Negozio e Inventario non potevano nascondere l'elenco predefinito

**1.91.2 (2023/05/09)**

**✨ Novità**

1. Elenchi Negozio e Inventario supportano nascondere separatamente
2. L'API `Goto` supporta ora salto a sottopagine pagina principale (ad es. Compiti, stato, Negozio, Inventario)
3. Le statistiche monete nelle statistiche supportano ora l'esclusione del consumo acquisti

**♻️ Ottimizzazioni**

1. Creando un nuovo Obiettivo o modificando un Obiettivo bloccato, il pulsante «Reimposta» non viene più visualizzato
2. Il widget monete supporta ora clic per saltare al Negozio
3. Quando l'effetto sonoro non riesce a riprodursi, viene visualizzato un messaggio di errore chiaro

**🐛 Correzioni bug**

1. Corretto il problema per cui, aggiungendo registri Pomodoro, se l'ora fine veniva impostata direttamente, la durata attesa poteva non corrispondere
2. Corretto il problema per cui, dopo riparazione etichetta filtro Compiti, compariva il metodo input
3. Corretto il problema per cui gli interessi ATM non supportavano impostazione valore assoluto tramite API
4. Corretto il problema caricamento dati anomalo della pagina cronologia
5. Corretto il problema per cui, quando il widget completa un Compito contatore, cliccare «Annulla» bloccava la pagina trasparente
6. Corretto il problema per cui la pagina statistiche non poteva aggiornarsi automaticamente in modalità barra navigazione inferiore
7. Corretto il problema per cui la raccolta Compiti squadra era anomala nel fuso orario GMT ±x,5

**1.91.1 (2023/03/27)**

**✨ Novità**

1. Aggiunta opzione «Gestione notifiche» nelle Impostazioni.
2. L'API Nuovo Compito supporta ora impostazione sfondi.
3. Aggiunti eventi broadcast API relativi a countdown prodotti ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Ottimizzazioni**

1. Il popup feedback non si chiude più automaticamente cliccando fuori.
2. I widget non forzano più il completamento di Compiti non avviati.
3. L'API completamento Compito non forza più il completamento di Compiti non avviati quando il parametro «ui» è true.
4. Disattivando l'impostazione coefficienti penalità Compito individuali, i coefficienti penalità Compito impostati in precedenza vengono ignorati e si usa il valore globale.
5. Rimozione automatica spazi bianchi dagli URL inseriti dagli utenti.
6. Quando l'opzione «Nascondi Oggetti non acquistabili» è abilitata e viene creato un Oggetto non acquistabile, viene visualizzato un prompt.
7. Quando l'utente abilita Livelli personalizzati ma non ne definisce alcuno, viene reimpostata la tabella Livelli integrata.
8. Migliorate immagini anteprima widget.
9. Gli input passi sono ora limitati a numeri. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Usando il browser integrato per link prodotti, il prefisso «https» non è più obbligatorio.
11. Aggiunte istruzioni «Configurazione compatibilità» per la funzione countdown prodotti.

**🐛 Correzioni bug**

1. Corretto comportamento gestione clic imprevisto selezionando prodotti in Negozio e Inventario.
2. Corretto il problema per cui Compiti non ripetuti non potevano avere scadenza aggiungendoli via API.
3. Corretto il problema per cui immagini Attributo personalizzate potevano non aggiornarsi su certi dispositivi.
4. Corretto il problema per cui effetti sonoro personalizzati potevano causare crash dell'App. Implementato un nuovo metodo che dovrebbe rendere gli effetti sonoro in background più stabili e usare meno memoria, ma la velocità riproduzione può essere più lenta.
5. Corretto il problema per cui su dispositivi Android 12 e superiori senza configurazione «Ignora ottimizzazione batteria», abilitare timer Pomodoro automatico o pausa poteva causare crash in background.
6. Corretto il problema per cui effetti sonoro countdown prodotti erano influenzati dall'impostazione effetti sonoro Pomodoro.
7. Corretto il problema per cui errori calcolo virgola mobile si verificavano impostando tassi interesse giornaliero ATM nell'API.
8. Corretto il problema per cui alcune immagini non potevano essere caricate su Android 6.
9. Corretto il problema per cui, ripristinando dati App da backup versione superiore a versione inferiore, i prompt errore non venivano visualizzati correttamente.
10. Corretto il problema per cui alcuni dispositivi avevano sovrapposizione layout nella pagina Pomodoro.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Novità**

1. Supporto gradienti Livello personalizzati.
2. Aggiunto primo lotto widget:
   - Monete (piccolo, grande, obiettivo)
   - Attributi (piccolo, grande)
3. Supporto interrogazione della maggior parte dei dettagli dati in LifeUp tramite API Content Provider, inclusi:
   - Offerta di una nuova versione di «LifeUp Cloud».
   - Fornitura di una prima versione rudimentale desktop (Windows, Linux, macOS) per uso rete locale.
4. Supporto eliminazione selezione multipla registri timer Pomodoro.
5. Supporto impostazione avvio automatico pausa e lavoro per il timer Pomodoro.
6. Miglioramenti API e campi aggiunti, inclusi:
   - Depositi e prelievi ATM.
   - Impostazione divieto acquisto per beni.
   - Impostazione colori etichette per Compiti.
   - Impostazione diretta saldo ATM.
   - Query semplice dettagli prodotto specificato.
   - Aggiunta terzo pulsante e opzione operazione all'interfaccia popup.

**♻️ Ottimizzazioni**

1. Migliorate velocità query, elaborazione e prestazioni con grandi volumi di dati.
2. Corretti margini errati per icone adattive.
3. Ottimizzato effetto visualizzazione registri timer Pomodoro.
4. Migliorata interazione ripristino backup.
5. Aggiunta visualizzazione UI ottenimento licenza membership tramite Google Play.
6. Prompt per disabilitare importazione con un clic se il file backup selezionato non proviene da LifeUp importando direttamente dal file system.
7. Chiusura automatica metodo input cercando beni nel popup selezione prodotto.
8. Modifiche comportamento API, inclusi:
   - API popup confirm_dialog. Se testo pulsante o operazione non sono forniti, il pulsante non viene visualizzato. Maggiore flessibilità controllo popup, ad es. popup solo testo senza pulsanti per testo e frasi motivazionali.
   - API penalità. Nelle versioni precedenti poteva dedurre al massimo 100 Oggetti; ora il limite è esteso a 9 cifre.

**🐛 Correzioni bug**

1. Corretto il problema per cui la pagina timer Pomodoro mostrava «caricamento» alla fine in certe circostanze.
2. Corretti crash causati da certe librerie di terze parti.
3. Corretto il problema per cui l'App crashava posizionando il timer Pomodoro nella barra navigazione inferiore a causa di un popup prompt.
4. Corretta visualizzazione anomala valori Attributo navigando profili altri utenti.
5. Corretto il problema per cui eventi API e notifiche riduzione Livello Attributo non venivano inviati correttamente.
6. Corretti alcuni problemi interazione pagine modifica pressione prolungata.
7. Corretti alcuni margini anomali nelle pagine gestione immagini e Sintesi.
8. Corrette alcune finestre popup non scorrevoli, con uso anomalo in modalità orizzontale.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Supporto per operazioni di lettura e autorizzazione delle informazioni Content Provider.
2. Durante l'avvio del servizio, richiede un wake lock per consentire la risposta anche con schermo bloccato.
3. Aggiunge una serie di interfacce per Content Provider.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Versione iniziale, progettata per essere usata insieme a «LifeUp Cloud» e all'App mobile.

Supporta le seguenti operazioni:

- Consultare Compiti, elenchi, Oggetti, Obiettivi ed elenchi Riflessioni.
- Acquistare Oggetti e completare Compiti.
- Usare il browser immagini desktop per visualizzare immagini ingrandite delle Riflessioni.

**1.90.7 (2022/11/07)**

**✨ Novità**

1. Aggiunto: traduzione vietnamita e firma del traduttore (versione Google)
2. Aggiunto: metodo di selezione immagine «Salta ritaglio», adatto alla selezione di animazioni gif (funzione membership)
3. Aggiunta: API eliminazione Compiti
4. Aggiunto: supporto per impostare l'abbandono dell'effetto sonoro al completamento Compiti
5. Aggiunta: operazione quantità MAX in Sintesi semplice
6. Supporto per ribloccare Obiettivi sbloccati
7. L'API «Aggiungi prodotto» supporta la specifica dell'id elenco

**♻️ Ottimizzazione**

1. Migliorata la descrizione dell'eliminazione cronologia
2. Il limite Punti Esperienza passa da (3/4 decimali) a (4/5 decimali)
3. Aggiunta visualizzazione coefficiente penalità nella pagina dettagli
4. Migliorato globalmente il design di interazione del selettore data e ora
5. La finestra popup dettagli Obiettivo differenzia ora il colore dell'icona in base al completamento delle condizioni
6. Modificata l'icona scorciatoia tomato
7. Creando un Oggetto da un elenco intelligente, se l'elenco selezionabile è 0 o 1, viene selezionato automaticamente
8. La modalità sviluppatore mostra l'ID elenco Oggetti
9. Limitata la lunghezza di input di alcuni campi comuni per evitare crash

**🐛 Correzioni bug**

1. Corretto il calcolo anomalo delle Ricompense modificando i registri cronologia Oggetti in alcuni scenari
2. Corretto il disallineamento tra l'interruttore «Mostra archiviate» e la visualizzazione in alcuni scenari
3. Migliorata la logica di caricamento dati del widget (può correggere alcuni problemi anomali)
4. Riparata la logica di calcolo automatico aggiungendo manualmente registri temporizzazione; ora basta compilare un qualsiasi campo
5. Corretto il problema di aggiornamento anomalo nella pagina registri temporizzazione tomato
6. Corretto il problema per cui le sottocompiti non potevano cancellare Ricompense Oggetti
7. Corretto il problema per cui, dopo aver selezionato tutti gli Oggetti, riselezionarne alcuni non aveva effetto
8. Ottimizzata la memoria necessaria per l'anteprima immagini
9. Il widget si aggiorna ora dopo la modifica dell'ordine degli elenchi
10. Ottimizzato il blocco dell'interfaccia in alcuni metodi di backup

**1.90.6 (2022/10/21)**

**✨ Novità**

1. Aggiunta API per impostare il numero di passi in una data specificata
2. Aggiunta API per consultare lo stato di Attributi specificati (Punti Esperienza, Livello)
3. Supporto importazione diretta dati backup dal gestore file
4. Le API relative agli Oggetti Ricompensa non sono più limitate a 99

**♻️ Ottimizzazione**

1. Ottimizzato l'effetto animazione di transizione entrando nella pagina dettagli evento
2. Ottimizzata la pagina modifica Compiti, con maggiore effetto visivo all'attivazione penalità e guida migliorata
3. Modificate le icone operazione nella pagina temporizzazione
4. Nella finestra popup acquisto, aggiunti avvisi e istruzioni per Oggetti con quantità propria negativa
5. Ottimizzato l'effetto barra di stato immersiva nella pagina principale
6. Aggiunto promemoria configurazione compatibilità nella pagina Pomodoro
7. Migliorata la velocità di esportazione e ripristino backup
8. Istruzioni per l'impostazione del numero di stock
9. Rimossa temporaneamente l'impostazione [Quando l'inventario prodotto è 0, la Ricompensa Compito corrispondente viene rimossa automaticamente].
10. Ottimizzato il meccanismo di verifica licenza con versione di prova gratuita
11. Quando un Compito «Fissato» è selezionato, l'azione viene ora mostrata come «Rimuovi fissaggio»
12. Passando alla temporizzazione positiva, l'avviso *sperimentale* non compare più ogni volta

**🐛 Correzioni bug**

1. Corretto il limite anomalo di sistema in alcune pagine o con tablet
2. Corretto il problema per cui venivano mostrati dati errati entrando per la prima volta nell'Inventario in alcuni casi
3. Corretto il problema per cui i dati non potevano essere recuperati per danni interni (come immagini danneggiate) ripristinando backup danneggiati
4. Corretto il problema per cui il pulsante «Acquista» appariva inaspettatamente dopo pressione prolungata su un Oggetto esaurito
5. Corretto il problema per cui l'introduzione Attributi nella nuova pagina squadra era la versione precedente

**1.90.5 (2022/09/22)**

**♻️ Ottimizzazione**

1. Adattamento a dispositivi con conversione webp anomala (l'immagine ritagliata può essere più grande dell'originale). Dopo la selezione, ne viene determinata la dimensione e applicata compressione secondaria.
2. Migliorata la descrizione delle ripetizioni obiettivo nella pagina dettagli
3. Supporto uso dello stesso Oggetto per accumulare tempo durante il countdown
4. Aggiunti altri Compiti guida per principianti
5. Aggiornamento traduzioni

**🐛 Correzioni bug**

1. Corretto il problema UI anomalo nella pagina composizione
2. Corretti diversi crash noti
3. Migliorato il problema per cui il countdown degli Oggetti poteva interrompersi anormalmente e accumulare tempo in countdown prolungati
4. Corretta l'eccezione UI nella finestra popup Riflessioni quando il widget completa un Compito

**1.90.4 (2022/09/15)**

1. Corretto il problema anomalo quando il widget completa un Compito (può causare una pagina trasparente e impedire di continuare)
2. Disabilitata la capacità del widget di selezionare immagini dalle Riflessioni

**1.90.3 (2022/09/14)**

1. Corretto il problema di focus ordinando le sottocompiti
2. Migliorato il colore Attributi nei Compiti congelati o non avviati
3. Aggiunta diffusione eventi Compiti abbandonati
4. Corretto il colore del testo probabilità
5. Migliorati i Compiti iniziali (Compiti predefiniti)
6. Corretto il problema per cui la finestra importazione Oggetti poteva selezionare l'elenco «Tutti» per impostazione predefinita
7. Corretti problemi raggruppamento Oggetti nel Negozio
8. Viene ora mostrato un avviso impostando un'ora insolita (l'ora non corrisponde alla frequenza di ripetizione).
9. Migliorate le regole di calcolo Compiti nel calendario; ora dovrebbero prevedere con precisione le scadenze dei Compiti futuri.
10. Corretto il problema per cui il calendario calcolava il completamento dei Compiti congelati.
11. Migliorate le impostazioni predefinite ora di inizio modificando i Compiti.
12. Migliorato il meccanismo rilevamento licenza.
13. Ottimizzata l'elaborazione countdown Oggetti. È vietata l'esecuzione ripetuta per ridurre l'accumulo di tempo indesiderato.
14. Corretto il problema edge-to-edge usando tasti virtuali in alcune pagine.
15. Corretto il problema per cui non si poteva selezionare un'immagine Riflessione quando il widget desktop completava un Compito.

**1.90.2 (2022/08/31)**

**✨ Novità**

1. Aggiunti eventi broadcast.
   Ora puoi usare Tasker/MacroDroid per ricevere eventi come uso Oggetti, completamento Compiti, ecc., e attivare azioni Tasker.

   Ad esempio: se un Oggetto viene usato, si attiva la sostituzione di sfondi casuali.
   In teoria, se vuoi, puoi implementare funzioni come blocco applicazioni e scenari di interazione con giochi.

2. Nuove API:

- Abbandonare Compiti
- Congelare Compiti
- Scongelare Compiti
- Interfaccia vuota
- Query

3. Aggiunto valore di ritorno per le API aggiungi Oggetto e Compito
4. Importando Oggetti dal mercato, ora puoi selezionare l'elenco di destinazione
5. Adattamento al colore secondario di Material 3
6. Aggiornamento traduzioni; aggiunto supporto coreano

**♻️ Miglioramenti**

1. Aprendo Bottini in batch, viene mostrata anche la probabilità del singolo prodotto
2. Ottimizzati alcuni effetti visualizzazione UI in modalità notturna
3. Ottimizzata la logica interattiva della finestra popup selezione data e ora. Selezionando il giorno corrente, passa automaticamente alla pagina selezione ora.
4. Quando l'API invoca selezione Oggetti e selezione elenchi, la finestra popup non supporta più la chiusura diretta (per evitare perdita chiamate API)
5. Ottimizzata l'altezza predefinita di alcune finestre popup in basso in schermo orizzontale su tablet
6. Ottimizzata la chiusura automatica delle finestre popup

**🐛 Correzioni bug**

1. Corretto il problema per cui la ricerca Compiti via API poteva fallire in alcuni casi
2. Corretto crash occasionale nella pagina elenco Compiti
3. Corretto il problema per cui compariva il pulsante «Annulla» con pressione prolungata su Obiettivi normali non sbloccati
4. Corretto il problema per cui la finestra popup dettagli Obiettivo poteva essere mostrata incompleta
5. Corretto il problema per cui il caricamento poteva fallire per immagini anormalmente grandi
6. Corretto il problema per cui own_number e stock_number dell'API Oggetti non supportavano numeri negativi
7. Corretto il problema per cui i giorni di persistenza nella pagina «Io» a volte venivano mostrati anormalmente come 1
8. Corretto il problema per cui a volte veniva mostrato «-x giorni fa»
9. Corretto il problema per cui le API successive potevano essere annullate anormalmente chiamando API in batch
10. Corretto il problema per cui il contenuto compilato creando una nuova squadra poteva perdersi alla distruzione della pagina

**1.90.1 (2022/08/22)**

**🐛 Correzioni bug**

1. Corretto il problema di concorrenza nelle chiamate API
2. Corretto il problema per cui, selezionando un gran numero di prodotti (migliaia), la selezione multipla poteva causare blocco
3. Corretto il problema anomalo quando il widget completa un Compito di squadra
4. Corretto il problema per cui la modifica Punti Esperienza sottocompiti non veniva ripristinata

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Novità**

1. Ottimizzazione impostazioni Ricompense Compiti:
   - Adeguamento UI impostazioni Ricompense
   - Le sottocompiti supportano Ricompense Punti Esperienza e Oggetti
   - La Ricompensa originale «solo testo» diventa una Ricompensa indipendente «parole»
   - Supporto impostazione valore predefinito Punti Esperienza

2. Gli Oggetti supportano restrizioni acquisto per Livello Attributo.

3. L'Oggetto supporta l'effetto «URL».
   Non solo puoi aprire pagine web, ma anche richiamare altre applicazioni o l'API di LifeUp. Consente effetti come aumentare il prezzo dopo l'uso dell'Oggetto.

4. **API aperte.**
   Ora puoi integrare software di automazione o fare sviluppo secondario.

   [Per maggiori dettagli, consulta la documentazione API.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. Il Negozio supporta la visualizzazione dell'effetto conteggio non raffinato

6. Ottimizzazione notifiche:

   - Aggiunta notifica cambio Livello Attributo
   - Aggiunta notifica Obiettivo sbloccato
   - Ottimizzazione gruppi notifiche

7. Supporto aggiunta manuale registri temporizzazione.

8. Ora puoi impostare la pagina Pomodoro nella barra di navigazione

9. Supporto per nascondere l'elenco [Obiettivo di sistema]

10. La versione API target è adattata ad Android 12L

11. Ottimizzazione effetti immersivi

12. I widget App supportano la visualizzazione della finestra popup completamento Compito

13. Ora puoi completare il Compito nella pagina dettagli questione

14. Nella finestra popup scadenza, puoi impostare il numero di Compiti contatore

15. Ora puoi modificare il nome del Compito di squadra

16. Ottimizzato il timing delle richieste di rete del modulo mondo, riducendo traffico e pressione sul server

**♻️ Miglioramenti**

1. La modalità notturna supporta ora tutti i colori tema, con personalizzazione notturna separata per ciascun colore, adattata a Material 3
1. Aggiunto il link «Ottimizzazione batteria» nella finestra configurazione compatibilità
1. Aggiunto l'interruttore «Mantieni schermo acceso» nelle impostazioni Pomodoro
1. Offerte le due opzioni «Termina» e «Accumula» per il countdown dell'Oggetto in stato pausa
1. Quando il numero di obiettivi modificati supera quello attuale, viene mostrato un messaggio di errore
1. Le questioni negative non devono essere mostrate nelle impostazioni coefficiente penalità
1. Ottimizzato l'effetto aggiornamento nella pagina cronologia
1. Ottimizzata la logica di attivazione automatica del Compito principale dopo il completamento sottocompito; ora viene gestita direttamente nella pagina dettagli
1.

**🐛 Correzioni bug**

1. Corretto il problema per cui il pulsante + compariva a volte nella pagina Momenti
2. Corretto il problema per cui i Compiti negativi non mostravano la finestra Riflessioni
3. Corretto il problema per cui l'obiettivo dei Compiti negativi non aveva effetto
4. Tentativo di riparare l'effetto dell'impostazione «congela fino a...» per Compiti di squadra
5. Corretto il problema per cui l'immagine della pagina Riflessioni poteva essere mostrata in modo errato

**1.89.5 (2022/8/5)**

1. Ottimizzato il problema di connessione di rete
2. Aggiornamento traduzioni

**1.89.4 (2022/7/13)**

1. Corrette informazioni sulle domande Xiaohong Dot
2. Corretto il problema di generazione ripetuta di Compiti ripetitivi (questa volta dovrebbe essere davvero riparato .jpg)

**1.89.3 (2022/7/05)**

**♻️ Miglioramenti**

1. Ottimizzato il criterio dell'elenco interruttori scorrevoli

**🐛 Correzioni bug**

1. Corretto il problema per cui il calcolo poteva non completarsi con molte condizioni Obiettivo
2. Corretto il problema per cui il promemoria notifica dei Compiti a tempo indeterminato mostrava una scadenza anomala
3. Corretto il problema per cui modificare lo sfondo di un Oggetto influenzava l'Oggetto copiato dopo la copia
4. Corretto il problema per cui l'Abilità modificando Compiti di squadra poteva non essere ereditata

**1.89.2 (2022/6/23)**

**♻️ Miglioramenti**

1. Rimosso permesso CARMRA non necessario
2. Aggiornamento traduzioni

**🐛 Correzioni bug**

1. Corretti alcuni crash

**1.89.0-1.89.1 (2022/6/09)**

**✨ Novità**

1. Supporto sblocco multiplo Obiettivi condizionali
2. I dettagli Obiettivo supportano visualizzazione dettagli e progresso condizioni
3. Tag Compiti
4. Compiti ripetitivi senza scadenza
5. Nascondere Oggetti esauriti o con acquisto disabilitato
6. Impostando l'effetto riduzione Punti Esperienza di un Oggetto, è opzionale limitarne l'uso
7. La pagina Inventario supporta selezione multipla, seleziona tutto e resi in batch
8. L'elenco Compiti predefinito supporta operazione archiviazione
9. Ridisegnate alcune pagine come impostazioni, domande e risposte, barra strumenti Negozio e pagina aggiungi elenchi
10. Ridisegnate alcune icone in-App (icone schede Compiti predefinite, monete, Punti Esperienza, icone Obiettivi)
11. Archiviazione immagini spostata nel percorso privato esterno dell'App per evitare eliminazione accidentale file

**♻️ Miglioramenti**

1. Aggiunto link articolo [Configurazione compatibilità] nella pagina impostazioni
2. Countdown Pomodoro — l'operazione reset aggiunge finestra di conferma
3. Aggiunta descrizione per congelamento Compiti
4. Aggiunta descrizione per sottocategorie Obiettivi
5. In modalità offline, aggiunto pulsante per uscire dalla modalità offline nella pagina modifica profilo
6. Ottimizzate statistiche Compiti negativi; supporta visualizzazione numero abbandoni del giorno e tracciamento Obiettivi
7. Ottimizzata velocità avvio App
8. Le icone Obiettivo supportano visualizzazione immagine ingrandita
9. Aggiunte statistiche «mi piace» (ricevuti) per Compiti casuali
10. Ottimizzazione unificata interazione ricerca
11. Selezionando un Oggetto, passare a un elenco vuoto mostra un layout vuoto (invece di caricamento)
12. La pagina immagine ingrandita si adatta alle impostazioni colore tema corrente
13. Ottimizzato l'effetto animazione quando cambia l'altezza della finestra popup Oggetti e Compiti selezionati
14. Nelle impostazioni backup, «Elimina dati locali» supporta anche l'eliminazione file multimediali
15. Unificata logica archiviazione ed eliminazione file temporanei per scattare foto
16. Distinzione tra icona Oggetto predefinita e icona che non carica
17. Attivata per impostazione predefinita l'impostazione penalità indipendente per Compiti
18. Ottimizzati aggiornamento, logica animazione e velocità caricamento pagina Riflessioni
19. Alcune finestre popup dettagli aggiungono pulsante scorciatoia «Seleziona»
20. Quando gli interruttori principali «effetti sonoro» e «vibrazione» nelle impostazioni avanzate sono disattivati, vengono mostrate istruzioni corrispondenti anche nelle impostazioni tomato
21. Ottimizzazione ordinamento Obiettivi nuovi e sottocategorie
22. Aggiornamento libreria base e dipendenze
23. Ottimizzati metodo e velocità calcolo progresso Obiettivi
24. Migliorato il metodo di calcolo «volte obiettivo (ripetizioni)» seguendo il miglioramento statistico dei registri cronologia, coerente con il numero di volte nei dettagli
25. Inserendo numero monete e ripetizioni obiettivo, tutti i valori attuali vengono selezionati automaticamente
26. Ottimizzato messaggio errore quando la configurazione WebDAV è anomala
27. Ottimizzato messaggio errore quando il backup Google Drive è anomalo
28. Ora puoi selezionare il nome Compito nella pagina dettagli

**🐛 Correzioni bug**

1. Corretto il problema per cui il conteggio impostato invalidava la Ricompensa Compiti dopo l'esecuzione logica ripetizione
2. Corretto il problema di ordinamento e raggruppamento nella pagina Negozio
3. Corretto il problema anomalo scorrimento su/giù nei Compiti casuali in alcuni casi
4. Corretto il problema per cui la statistica Pomodoro nella pagina stato era imprecisa dopo temporizzazione positiva in alcuni casi
5. Corretto il problema per cui la logica ripetizione Compiti di squadra perdeva l'impostazione tipo contatore
6. Corretto il problema per cui il Compito selezionato da Tomato restava evidenziato selezionando Compiti legati a condizioni Obiettivo
7. Corretto il problema per cui l'immagine Riflessione non veniva archiviata in modo indipendente e problemi di visualizzazione
8. Corretto il problema per cui l'avviso fallimento accesso poteva comparire frequentemente
9. Alcuni campi input speciali per Compiti, squadre e sottocompiti nuovi non devono consentire input da tastiera, il che poteva causare crash dell'App
10. Ottimizzato il conteggio completamenti Oggetti illimitati nei widget, coerente con l'in-App
11. Corretto il problema per cui, dopo la regolazione tasso interesse ATM, l'interesse poteva essere calcolato in base al tempo accumulato e al tasso regolato
12. Corretto il problema per cui i Compiti congelati potevano ancora comparire nell'elenco intelligente
13. Ottimizzato il problema per cui il pulsante azione bloccato dalla barra selezione restava cliccabile selezionando certi oggetti (Compiti, Oggetti Negozio)
14. Corretto il problema per cui cambiare il colore di un Oggetto non aggiornava immediatamente l'UI
15. Corretto il problema per cui impostare improvvisamente un tasso di interesse alto dopo averlo mantenuto basso (senza ottenere 1 moneta) poteva generare interessi enormi
16. Corretto il problema per cui la casella ricerca compariva dopo completare un Compito aprendo la barra ricerca e usando il prodotto
17. Corretto il problema per cui il numero completamenti del giorno in-App poteva non corrispondere al widget dopo aver cambiato il nome di un Compito infinito
18. Corrette animazioni anomale completando Compiti illimitati
19. Corretto il problema per cui copiare un Compito non copiava lo sfondo
20. Corretto il problema per cui, in alcuni casi, le condizioni Obiettivo erano soddisfatte ma l'Obiettivo non poteva essere sbloccato
21. Corretta eccezione calcolo intervallo date (può influenzare più logiche)
22. Corretto il problema per cui le Riflessioni non venivano filtrate automaticamente dalla pagina dettagli Compiti

**1.88.4 (2022/4/21)**

1. Corretto il crash nella ricerca Inventario
2. Corretto il disordine visualizzazione sfondo personalizzato e pagina cronologia
3. Corretto il sovrapporsi UI in modifica
4. Corretto il problema per cui la quantità poteva essere mostrata anormalmente quando l'Obiettivo ricompensava con Oggetti
5. Corretto il problema per cui le volte completamento nel calcolo Obiettivi potevano non corrispondere a quelle reali in alcuni casi speciali
6. Corretto il problema per cui il titolo poteva scomparire cliccando rapidamente la pagina cronologia
7. Creando o modificando un Oggetto, dopo aver cliccato la proprietà, la tastiera virtuale non poteva riaprirsi cliccando di nuovo il campo input con focus
8. Corretto il crash impostando il limite acquisto mensile in francese

**1.88.3 (2022/4/09)**

1. Corretto il problema per cui, dopo ripristino backup, il backup cloud segnalava conflitto
2. Corretto il problema per cui ora inizio Compito modificata e promemoria sottocompiti non selezionavano per impostazione predefinita l'ora compilata
3. Corretto il problema per cui altri effetti venivano calcolati una sola volta durante Sintesi semplice in batch
4. Corretto il problema per cui qualsiasi Attributo Obiettivo di sistema al Livello 10 non veniva conteggiato nell'Attributo personalizzato
5. Corretta visualizzazione anomala UI testo nella pagina «Io» per non membri

**1.88.2(-)**

> Aggiornamenti inclusi in 1.88.3

**1.88.1 (2022/4/02)**

1. Corretto un crash causato dal promemoria backup

**1.88.0 (2022/3/30)**

✨ Novità

1. Aggiunta funzione condivisione «Compiti casuali» nel modulo mondo
2. Gli Oggetti contatore possono impostare opzionalmente un coefficiente che influisce sul numero di Oggetti
3. Supporto impostazione tasso interesse prestiti
4. La gestione immagini supporta filtraggio con un clic delle immagini non usate + seleziona tutto
5. Supporto dimensione ritaglio immagine personalizzata (icone ad alta definizione, funzione membership)
6. Visualizzazione esplicita dell'interruttore «Riflessioni» nell'Obiettivo
7. Ottimizzato algoritmo ordinamento elenco «Tutti»

⚡️ Ottimizzato

1. Ottimizzati effetti visivi di alcune finestre popup
2. Ottimizzata interazione funzioni backup/ripristino
3. Ottimizzata velocità caricamento pagina delega
4. Ottimizzata in larga misura velocità caricamento finestra popup selezione prodotti

🐛 Correzioni bug

1. Corretto disordine sfondo personalizzato
2. Corretto il problema per cui il Compito poteva essere creato in un elenco eliminato
3. Corretti alcuni bug crash

**1.87.1（2022/3/07）**

1. Il menu ordinamento Negozio e Inventario mostra esplicitamente ordinamento «personalizzato»
2. Corretto il problema per cui poteva verificarsi ordinamento anomalo nell'Inventario
3. Aggiunto pulsante per andare al feedback email nella pagina feedback
4. Ottimizzato messaggio fallimento ripristino per problemi versione database
5. Corretto il problema per cui il numero monete non veniva mostrato nella scheda modalità compatta

**1.87.0 official version (2022/3/04)**

1. Corretto il problema per cui lo sfondo scheda personalizzato poteva ingrandirsi anormalmente in alcuni casi
2. Corretto il problema per cui cliccare la notifica promemoria Compito poteva aprire dettagli errati ricevendo promemoria continui
3. Corretto il problema per cui i numeri sulla scheda non si aggiornavano scorrendo per aumentare il conteggio Compiti contatore
4. Aggiunto nuovo Compito guida per alcune lingue

**1.87.0-rc02（2022/2/25）**

1. Migliorata gestione errori e messaggi nelle operazioni di recupero
2. Ottimizzata interazione impostazione «giorno della settimana»; aggiunto avviso configurazione anomala (inizio e periodo non nello stesso giorno)
3. Ottimizzata combinazione colori modalità notturna di alcune pagine
4. Corretto il problema per cui la cache poteva essere mostrata in modo errato nel selettore immagini e nella gestione immagini
5. Corretto il problema per cui l'operazione «Download» nella finestra popup conflitto backup non supportava Google Drive/Dropbox
6. Corretto il problema per cui la ricerca nel Negozio poteva mostrare risultati errati
7. Corretto il problema per cui il fissaggio Compito poteva fallire
8. Corrette alcune eccezioni UI e problemi testo

**1.87.0-rc01（2022/2/23）**

**✨ Novità**

1. Le sottocategorie Obiettivo supportano operazione piegatura
2. Introdotto interruttore stile Material You (sperimentale)
3. L'Inventario supporta ordinamento per Negozio
4. L'Inventario supporta operazione «preferito» su Oggetti
5. Il Negozio supporta operazione seleziona tutto
6. Operazioni Negozio e Inventario supportano selezione quantità MAX
7. I Compiti supportano creazione continua
8. Configurazione Compiti: la descrizione Ricompensa Oggetto viene aggiunta automaticamente alle note scheda (viene mostrato automaticamente «Ricompensa: [un prodotto] x1»)
9. I Compiti supportano durata congelamento specificata

**⚡️ Miglioramenti**

1. Aggiunto pulsante «Salta» nella finestra popup conflitto backup
2. La versione Google Play supporta francese/polacco
3. Il promemoria notifica al clic Compito supporta ora il salto ai dettagli Compito
4. Modificando l'ora relativa al Compito, la finestra popup predefinita punta all'ora precedente alla modifica invece che all'ora corrente
5. Ogni voce selezione elenco del Negozio supporta operazioni «Rinomina», «Elimina», «Nuovo»
6. Ridisegno UI pagina estensioni
7. Aggiunta seconda finestra popup conferma per «Elimina account calendario»
8. Il prodotto non viene più rimosso automaticamente dagli scaffali se esaurito
9. Il Compito «Alzarsi presto» nell'esempio passa a penalità 0
10. Ottenendo una Ricompensa Oggetto, se la quantità è negativa, compare ora un avviso correlato
11. Ottimizzato algoritmo casuale monete nell'effetto uso Oggetti
12. L'operazione «Imposta come completato» aggiunge effetto sonoro completamento
13. Ottimizzata parte visualizzazione UI in modalità notturna
14. Ottimizzate prestazioni elenco Compiti

**🐛 Correzioni bug**

1. Corretta anomalia testo «unconcerned» in alcune lingue
2. Corretto il problema per cui l'icona prodotto nella finestra popup «Restituisci» poteva essere mostrata in modo anomalo
3. Corretto il problema per cui il Compito poteva essere generato ripetutamente completandolo rapidamente
4. Corretto il problema per cui la memoria elenco corrente del sistema «Sintesi» poteva invalidarsi
5. Corretto il problema per cui l'accesso QQ poteva non essere possibile in schermo orizzontale
6. Corretto il problema per cui, modificando una ricetta nell'elenco [Tutti] del sistema «Sintesi», la ricetta poteva scomparire dall'elenco originale
7. Corretto il problema per cui cliccare più volte di seguito per completare un Compito infinito poteva far tornare a zero il numero completamenti
8. Corretto il problema per cui l'intervallo backup non poteva essere impostato su «Mensile»
9. Corretto il problema per cui l'icona Punti Esperienza non veniva mostrata in modalità semplice
10. Corretto il problema per cui mancavano le colonne «Obiettivi» e «Elenco Obiettivi» nella gestione immagini
11. Corretto il problema per cui la pagina dettagli Compito non supportava l'abbandono Compiti di squadra
12. Corretto il problema per cui la guida del modulo mondo non veniva mostrata correttamente
13. Corretto il problema per cui il prodotto poteva essere condiviso con successo quando il caricamento immagine falliva, ma l'immagine locale veniva sovrascritta
14. Corretti alcuni crash ed eccezioni rare

**1.86.0（2022/1/20）**

**Novità**

1. Sottocategoria Obiettivo: divide categorie e conta automaticamente per categoria
2. Backup Google Drive
3. Funzione gestione immagini (nella pagina backup)
4. Effetto monete casuali su Oggetti
5. Copia in batch Obiettivi
6. Conteggio passi supporta input multiplo passi e Ricompense multiple
7. Pomodoro supporta configurazione scambio Oggetti
8. Supporto rapporto sconto reso personalizzato
9. Formato esclusivo per backup (alcuni sistemi supportano apertura e importazione diretta)
10. Sintesi semplice supporta operazione batch
11. Nuova opzione effetto sonoro personalizzato: uso Oggetti
12. Nuova condizione sblocco Obiettivo: deposito ATM corrente
13. Statistiche volte questioni negative supportano pagina dettagli
14. L'elenco «Tutti» supporta rinomina
15. Nome e descrizione unificati canali notifica App

**Miglioramenti**

1. Priorità agli Obiettivi sbloccati ma senza Ricompensa ricevuta
2. Il tempo Concentrazione di oggi Pomodoro nella pagina stato viene mostrato in ore in base alla durata
3. L'Inventario aggiunge visualizzazione descrizione Oggetti
4. La registrazione nuovo account mostra una finestra di conferma
5. Supporto visualizzazione annunci manutenzione
6. Aggiunta finestra conferma «Salta» per tempo extra Pomodoro
7. Supporto salvataggio dati alla disinstallazione App (richiede supporto sistema)
8. Ottimizzata logica backup e recupero
9. Ottimizzata logica scadenza Oggetti singoli e illimitati, con supporto modifica
10. Ottimizzata base temporale statistiche grafico eventi illimitati, basata su ora completamento invece che scadenza
11. La scheda modalità compatta mostra anche il tempo scadenza Oggetti singoli e illimitati
12. Tentativo miglioramento sopravvivenza funzione countdown in background
13. Ottimizzata funzione Riflessioni:
    -Attiva per impostazione predefinita
    -La pagina impostazioni Compiti squadra non mostra l'interruttore «Riflessioni» che in realtà non ha effetto
    -Rimossa la confusa funzione memoria interruttore Riflessioni
14. Aumentato numero Oggetti mostrati nella finestra popup selezione elenchi Oggetti e Inventario
15. Quando la barra notifiche continua a temporizzare, viene annullato anche l'effetto vibrazione in corso
16. Il testo dinamico nel modulo mondo supporta copia parziale
17. Ottimizzato effetto animazione aggiornamento dati pagina Obiettivi personalizzati
18. Ottimizzata logica recupero; mostra finestra «Caricamento» invece di bloccare l'interfaccia
19. Ottimizzato il problema per cui il pulsante inferiore poteva non essere visibile nella «finestra popup crash»
20. Cliccando promemoria notifica Compito, ora salta alla pagina elenco dove si trova il Compito
21. Icona Attributo personalizzato supporta selezione libreria icone integrata App
22. Ottimizzato nome operazione condividi «Leggi più tardi» invece di mostrare direttamente il nome App
23. Ottimizzata notifica sblocco Obiettivo; ora viene mostrata la descrizione Obiettivo
24. Quando il widget desktop entra nella homepage, salta automaticamente al modulo «delega»
25. Ottimizzata visualizzazione testo dopo completamento elenco del giorno
26. Ottimizzati testo e sequenza operazione effetto countdown Oggetti
27. Quando tutti gli Attributi sono nascosti, la pagina stato non mostra più la scheda «Attributo»

**Correzioni bug**

1. Corretto raro crash nelle finestre popup sblocco Obiettivi
2. Corretto il problema per cui un Compito poteva occupare più righe su widget desktop con larghezza insufficiente
3. Corretto il problema per cui la prima autorizzazione esercizio per conteggio passi poteva mostrare il totale accumulato dal sensore
4. Corretto crash o confusione recupero pausando un countdown e avviandone un altro
5. Corretto crash inserendo effetto countdown 0 minuti su Oggetti
6. Corretto il problema per cui il nome elenco selezionato non si aggiornava rinominando l'elenco corrente nella pagina aggiungi o modifica Oggetti
7. Corretta visualizzazione anomala schede con frequenza ripetizione «annuale»
8. Corretto il problema per cui monete personalizzate non avevano effetto tempestivo in alcuni casi
9. Corretto il problema per cui i widget mostravano Oggetti congelati
10. Corretto il problema per cui l'Obiettivo personalizzato non mostrava l'avviso «operazione pressione prolungata»
11. Corretto il problema per cui il totale Punti Esperienza nella pagina «Io» non conteggiava quelli degli Attributi personalizzati
12. Corretto il problema per cui la pagina «Riflessioni» tornava in cima dopo anteprima immagine anomala
13. Corretto il problema per cui la scorciatoia statica «Tomato» saltava alla homepage solo se l'App era già avviata su MIUI
14. Corretto il problema per cui anche i non membri potevano caricare sfondi personalizzati
15. Corretto il problema per cui il numero monete nella pagina Negozio non si aggiornava tempestivamente
16. Corretto il problema per cui il calendario non poteva passare all'anno successivo
17. Corretto il problema per cui il nome elenco sul widget non si aggiornava dopo modifica nome elenco

**Release Candidate → Versione ufficiale**

1. Ottimizzato tasso successo caricamento file grandi su Google Drive; più tentativi e strategia blocchi ottimizzata
2. Corretto il problema per cui i membri potevano non vedere il pulsante sfondo Compito personalizzato individuale in ambienti non cinesi
3. Se il backup Google Drive/DropBox falliva, saltava alla pagina backup invece che alla configurazione WebDAV
4. Aggiunta descrizione finestra popup fallimento verifica Google Play, con percorso esportazione dati
5. Il nickname nella pagina «Io» cambia colore in base allo stato membership
6. Eliminato errore virgola mobile tasso interesse ATM nella maggior parte degli scenari
7. Eliminando dati locali, vengono eliminati anche sfondo personalizzato, immagini Attributi e file effetti sonoro
8. Corretto problema anomalo grafico conteggio passi
9. Corretto il problema per cui gli Attributi della pagina nuova attività non si aggiornavano dopo clic sul pulsante aiuto Attributo, salto alla personalizzazione Attributi e ritorno
10. Personalizzando l'effetto di un Oggetto, clic fuori dalla finestra popup non la chiude più automaticamente, evitando perdita contenuto modificato
11. Ottimizzato problema UI lingue straniere nella pagina impostazioni Oggetti (testo russo troppo lungo)
12. Tentativo correzione crash toast colore su alcuni modelli
13. Corretto il problema per cui il pulsante uso restava cliccabile con pagina Inventario selezionata
14. Corretta logica visualizzazione Compiti singoli scaduti nell'elenco intelligente, adattata al nuovo metodo archiviazione ora scadenza
15. Con Inventario selezionato, l'elenco commutato deve essere deselezionato

**1.85.4 (2021/12/08)**

Versione abituale correzione bug; la prossima versione con novità è ancora in sviluppo~

1. Corretto il problema per cui l'icona predefinita monete del widget non veniva mostrata correttamente fuori modalità scura
2. Corretto il problema per cui l'animazione barra progresso non veniva riprodotta normalmente con salite/discese Livello continue
3. Corretto il problema per cui il numero monete nella pagina Inventario non si aggiornava tempestivamente
4. Corretto il problema per cui la scadenza poteva essere modificata forzatamente modificando l'elemento «giorno della settimana»
5. Corretto il problema per cui la rotazione schermo poteva far perdere informazioni sottocompiti modificate editando Compiti
6. Corretto il problema per cui il numero monete non aveva effetto creando o modificando prodotti
7. Condizioni visualizzazione volte completamento annuale nella pagina dettagli emendamento
8. Ottimizzata archiviazione immagini in App; non dovrebbero essere indicizzate nell'album di sistema
9. Ottimizzata descrizione interruttore Riflessioni
10. Corretti alcuni crash

**1.85.3 (2021/11/18)**

1. Ottimizzato metodo calcolo tempo temporizzazione; compensa tempo sospensione CPU
2. Corretto il problema per cui modificare l'icona copiando il prodotto faceva perdere l'icona prodotto originale
3. Altre correzioni minori (come tag squadra)

**1.85.2 (2021/11/07)**

1. Corretto il problema per cui non venivano generati registri e Ricompense in liquidazione dopo sospensione temporizzazione
2. Corretto il problema per cui l'operazione «sposta in» sotto elenco intelligente faceva visualizzare l'elenco in modo impreciso
3. Corretto il problema per cui il valore attuale di «Numero monete attuale» non corrispondeva al calcolo reale (il valore mostrato non includeva depositi ATM)
4. Corretto il problema per cui registro e Ricompensa si ripetevano dopo fine lavoro Pomodoro e doppio clic consecutivo sul pulsante salta

**1.85.1 (2021/11/02)**

0. Corretto problema caricamento elenco Riflessioni

**1.85.0 2021/10/20)**
*Novità*

1. Pomodoro supporta modalità temporizzazione positiva
2. Incolla più righe di testo per creare rapidamente sottocompiti
3. Gli Oggetti supportano operazione copia
4. Scorri per cambiare direzione elenco Oggetti; supporta inverso (impostazioni-Oggetti)
5. Supporto cancellazione registro ottenuto Pomodoro
6. Pomodoro aggiunge pulsante forzato cambio schermo orizzontale/verticale
7. Aumentate condizioni sblocco Obiettivi:
   ● Numero prodotti ottenuti con Sintesi
   ● Quantità accumulata Oggetti ottenuti
   ● Quantità attuale del prodotto
   ● Livello vita
   ● (Ripetitivo) tempo Concentrazione del Compito
8. Anche l'icona Abilità supporta più impostazioni ritaglio
9. Scorciatoia statica:
   ● Nuovo Compito
   ● Entra nella pagina Pomodoro
10. Aumentata personalizzazione effetti sonoro:
    ● Ottenere Ricompense Obiettivo (inclusi Obiettivi di sistema e personalizzati)
    ● Apertura Bottino
    ● Sintesi (inclusa Sintesi semplice e Sintesi)
    ● Effetto sonoro notifica
11. Personalizzazione icona monete
12. L'effetto uso Oggetto supporta impostazione multipli effetti modifica Punti Esperienza
13. Modifiche adattamento Abilità grafico a torta Punti Esperienza
14. La pagina cronologia supporta filtraggio per stato
15. Funzione tag squadra

*Miglioramenti*

1. Quando la Ricompensa monete sottocompito è 0, non viene mostrata nei dettagli
2. Nuova pagina elenco Obiettivi e guida «Crea Obiettivo»
3. Ottimizzata visualizzazione icone widget
4. Aggiunti effetti sonoro al completamento sottocompiti (dettagli, pagine nuove)
5. Dopo aver inserito contenuto nelle pagine crea o modifica (Compiti, Oggetti, Obiettivi, Sintesi), cliccando indietro compare finestra conferma per scartare modifiche
6. Ottimizzata ordinazione creazione prodotti (con ordinamento personalizzato, i prodotti nuovi hanno priorità massima)
7. Modificando Compiti/Oggetti, il metodo input non deve aprirsi automaticamente
8. La pagina nuovo Compito supporta schermo orizzontale senza perdita dati
9. Adattamento colore tema membership per widget desktop
10. Ottimizzato selettore Oggetti; mostra prima e carica dati in modo asincrono
11. L'etichetta Inventario aggiunge anche ingressi «Sintesi» e «ATM»
12. Le operazioni [Imposta come completato] e [Annulla] nel cambio stato cronologia tornano al menu di primo livello
13. Aggiunto ingresso rapido Pomodoro nei dettagli evento
14. Ottimizzata ordinazione elenco «Tutti» del Negozio (aggiunta opzione raggruppamento per elenco, solo Negozio)
15. Dopo aver selezionato giorni settimana per ripetizione, l'ora scadenza viene ricalcolata. (Evita che, ripetendo nei giorni lavorativi, la scadenza resti sabato o domenica.)
16. Tornando alla pagina «Delega», se il pulsante «+» non è mostrato, ne viene attivata la visualizzazione.

*Correzioni bug*

1. Corretto il problema per cui il progresso elenco non si aggiornava tempestivamente con pagina Obiettivi nella barra navigazione inferiore
2. Corretto problema cambio stato Oggetti storici
3. Riparata visualizzazione scadenza countdown negativo
4. Gli Obiettivi monete devono essere inclusi nel deposito ATM
5. Corretto il problema per cui, con Pomodoro in pausa, rientrare due volte cancellava il tempo
6. Corretto il problema per cui la restrizione acquisto poteva invalidarsi in certe circostanze
7. Corretto il problema per cui i registri countdown potevano ripetersi in casi rari
8. Corretto il problema per cui cliccare rapidamente schede Compito diverse poteva lasciare il contenuto di una scheda vuoto tornando alla pagina
9. Adeguamento logica calcolo automatico monete e Punti Esperienza
10. Corretti alcuni crash

**1.84.4 (2021/10/09)**

1. Corretto il problema per cui l'icona integrata poteva non essere mostrata

2. Aggiornato gruppo Q

**1.84.3 (2021/10)**

1. Aggiornato testo per l'estero

**1.84.2 (2021/09/26)**

1. Corretto il deadlock che poteva essere causato dalla Sintesi

2. Corretto il problema degli effetti d'uso anomali mostrati nei dettagli prodotto non disponibili

3. Ottimizzato l'effetto visivo degli angoli arrotondati dei widget

**1.84.1 (2021/09/20)**

1. Corretto il problema per cui il conteggio ripetizioni obiettivo non poteva essere azzerato durante la modifica

**1.84.0 (2021/09/19)**

***Novità***

1. Sistema Abilità (personalizzazione Attributi)

   Tutti i meccanismi originali sono adattati al sistema di personalizzazione Attributi, ad esempio Attributi Obiettivo che raggiungono le condizioni di sblocco, Ricompense Punti Esperienza prodotto, ecc.

2. Personalizzare l'effetto consumabile del Pomodoro, consentendo di modificare Punti Esperienza e tipi di Attributo

3. L'icona del Negozio supporta la modifica dello stile di ritaglio (impostazioni Negozio)

4. I dettagli prodotto mostrano ora un elenco degli effetti d'uso

5. Aggiunto colore tema membership #6bab8b

6. Supporto eliminazione account calendario promemoria

***Miglioramenti***

1. La pagina Pomodoro supporta la visualizzazione orizzontale

2. Aggiunta la descrizione di «Importo prestabile» nelle impostazioni prodotto

3. Aggiunto avviso sulla dimensione file della sincronizzazione cloud

4. Aggiornati i componenti correlati a Facebook e Dropbox

5. Ottimizzazione parziale di visualizzazione UI e testo di alcune pagine

6. Ottimizzata l'interazione dei nuovi sottocompiti

***Correzioni bug***

1. Corretto il problema per cui la versione icona predefinita dell'Attributo era incoerente

2. Corretto il problema per cui clic rapidi per aprire il Bottino potevano causare aperture ripetute o crash

3. Corretto il problema per cui gli eventi calendario già promemorizzati non venivano rimossi in sincrono eliminando Oggetti

4. Corretto lo stato anomalo dopo aver impostato l'Oggetto da «Completato» a «Scaduto» nella pagina cronologia. I dati storici dovrebbero essere riparati automaticamente aggiornando alla nuova versione

5. Corretto il problema per cui l'elenco attualmente selezionato era contrassegnato in modo errato nella finestra di selezione elenco creando un nuovo prodotto; rimossa anche la visualizzazione dell'elenco «tutti»

6. Corretto il problema per cui modificando altro contenuto + ripetizioni obiettivo, la modifica falliva di nuovo

7. Nella pagina nuovo Obiettivo, corretto il problema per cui la selezione Attributo non poteva essere modificata e lasciata vuota

8. Altre correzioni bug minori e ottimizzazioni

**1.83.16 (2021/08/20)**

1. Corretto crash e inefficacia modifica avatar in modalità offline
2. Ottimizzata l'interazione di selezione effetto apertura prodotto
3. Corretto il problema di focus di alcune caselle di input testo lungo
4. Corretto il problema per cui scadenza e ora promemoria venivano mostrate in modo errato in alcuni casi
5. Corretto il problema per cui le modifiche di configurazione correlate alla modalità compatta non avevano effetto immediato

**1.83.15**

1. Supporto contrassegno Compiti penalità nei widget App
2. Corretto il comportamento anomalo di «piega questioni non dei sette giorni»
3. Il limite superiore del numero di immagini Riflessioni è stato aumentato a 9
4. La pagina di accesso mostra l'ultimo metodo di login
5. Quando la penalità viene annullata (contrassegnata come completata), non viene data alcuna Ricompensa aggiuntiva
6. L'elenco intelligente supporta ora la visualizzazione degli Oggetti completati
7. Corretta la situazione anomala di backup automatico nella cartella download in alcuni casi
8. Corretti alcuni problemi di visualizzazione UI

**1.83.14**

1. Corretto il problema per cui il Pomodoro poteva non registrare la durata eseguendo «Salta»
2. Corretto il problema per cui gli Oggetti penalità venivano eseguiti in ritardo con logica penalità
3. Corretti problemi correlati alla modifica delle penalità
4. Corretti problemi correlati alla selezione immagini in modalità orizzontale
5. Corretto l'occasionale fallimento ripristino da percorso personalizzato

**1.83.8-1.83.13**
Novità

1. Supporto impostazione indipendente sfondo scheda
2. La funzione elimina registro supporta ora l'eliminazione di pensieri, magazzini e registri temporizzazione
3. Gli Obiettivi di sistema possono scegliere se ottenere Punti Esperienza o Ricompense monete
4. Funzione ricerca eventi
5. Supporto backup automatico locale nella cartella «download» (Android 10 e superiori)

Miglioramenti

1. Migliorato il metodo predefinito di chiamata promemoria notifica, che teoricamente può aumentare il tasso di successo delle notifiche su Android 6 e superiori
2. Aumentata la priorità notifica del timer Pomodoro a [Alta], migliorando la sopravvivenza del timer in background e la visualizzazione notifica
3. Nella pagina, aggiunti link gruppo QQ e sito ufficiale, ottimizzata l'UI; QQ supporta l'aggiunta al gruppo con un clic
4. Migliorato il timing di attivazione delle notifiche Obiettivo, che dovrebbero comparire subito dopo l'attivazione nella homepage
5. Aggiunta casella «Applica solo all'elenco corrente» nell'opzione «Filtro» dell'elenco Oggetti, separando le opzioni predefinito e tutti gli elenchi
6. Aggiunti effetti animazione durante la composizione
7. Feedback: aggiunto canale feedback della community Rabbit Xiaochao, comodo per caricare immagini e tracciare i problemi
8. Aggiunta visualizzazione valore relativo nella casella di input Oggetti contatore
9. Ottimizzato l'effetto visualizzazione Tab non selezionati
10. Rimosso il prompt casuale cliccando sull'avatar; ora si accede alla homepage personale
11. Quando la Ricompensa monete non è impostata, viene mostrato «non impostato» invece di «0»
12. Quando la probabilità di apertura Bottino è inferiore allo 0,01%, non viene più mostrato «0,00%» ma «<0,01%»
13. L'interruttore Riflessioni non viene più memorizzato ed è disattivato per impostazione predefinita
14. Ottimizzato il processo di richiesta autorizzazioni calendario e fotocamera
15. Ottimizzati effetto clic e visualizzazione di alcune pagine
16. Ottimizzato il metodo promemoria calendario, tentando di risolvere il problema per cui alcuni dispositivi possono eliminare l'account calendario

Correzioni bug

1. Corretto il crash con filtraggio continuo nella pagina Riflessioni
2. Tentativo di correzione del raro crash della finestra popup impostazione apertura Bottino
3. Corretto il problema per cui, con casella di input lunga, cliccare sul testo saltava automaticamente in fondo
4. Corretto il problema per cui non era possibile impostare Ricompense monete casuali creando una squadra
5. La versione distribuzione domestica rimuove completamente i componenti correlati a Firebase
6. Corretta l'eccezione occasionale aggiornando la pagina elenco Obiettivi
7. Corretto un crash anomalo occasionale selezionando l'icona integrata
8. Corretto il problema per cui i sottocompiti restavano visibili tornando alla pagina dettagli dopo aver eliminato tutti i sottocompiti
9. Corretto il problema per cui il nome dell'elenco predefinito Sintesi non poteva essere modificato
10. Corretto il problema per cui la casella filtro veniva mostrata nella pagina profilo
11. Corretto il problema per cui l'Oggetto di squadra non poteva essere ereditato dopo aver impostato la Ricompensa prodotto

**1.83.7 (2021/06/24)**

1. Aggiunto ordinamento elenco per monete
2. Aggiunta selezione lingua nella pagina guida
3. Ottimizzata la velocità di caricamento della pagina Obiettivi
4. Modificate le informazioni di adesione al gruppo QQ con un clic
5. Corretto il problema per cui clic continui durante l'apertura potevano attivare più volte le modifiche Inventario
6. Corretta la visualizzazione errata di singoli Oggetti scaduti nell'elenco Compiti del giorno

**1.83.6 (2021/06/22)**

Novità

1. (Membri) Supporto impostazione indipendente sfondo scheda
2. La funzione elimina registro supporta ora l'eliminazione di pensieri, magazzini e registri temporizzazione
3. Gli Obiettivi di sistema possono scegliere se ottenere Punti Esperienza o Ricompense monete
4. Funzione ricerca eventi
5. Supporto backup automatico locale nella cartella «download» (Android 10 e superiori)

Ottimizzazioni

1. Migliorato il metodo predefinito di chiamata promemoria notifica, che teoricamente può aumentare il tasso di successo delle notifiche su Android 6 e superiori
2. Aumentata la priorità notifica del timer Pomodoro a [Alta], migliorando la sopravvivenza del timer in background e la visualizzazione notifica
3. Nella pagina, aggiunti link gruppo QQ e sito ufficiale, ottimizzata l'UI; QQ supporta l'aggiunta al gruppo con un clic
4. Migliorato il timing di attivazione delle notifiche Obiettivo, che dovrebbero comparire subito dopo l'attivazione nella homepage
5. Aggiunta casella «Applica solo all'elenco corrente» nell'opzione «Filtro» dell'elenco Oggetti, separando le opzioni predefinito e tutti gli elenchi
6. Aggiunti effetti animazione durante la composizione
7. Feedback: aggiunto canale feedback della community Rabbit Xiaochao, comodo per caricare immagini e tracciare i problemi
8. Aggiunta visualizzazione valore relativo nella casella di input Oggetti contatore
9. Ottimizzato l'effetto visualizzazione Tab non selezionati
10. Rimosso il prompt casuale cliccando sull'avatar; ora si accede alla homepage personale
11. Quando la Ricompensa monete non è impostata, viene mostrato «non impostato» invece di «0»
12. Quando la probabilità di apertura Bottino è inferiore allo 0,01%, non viene più mostrato «0,00%» ma «<0,01%»

**1.83.0-alpha04 (2021/05/23)**

1. Supporto configurazione libera, ordinamento e disabilitazione del modulo inferiore
   I moduli dovranno essere adattati gradualmente in futuro; attualmente sono supportati solo alcuni moduli funzionali (ad esempio Pomodoro, cronologia non ancora adattata)
2. Aggiunta la seconda modalità pausa all'effetto countdown del prodotto, che resta nella barra notifiche e può essere ripresa in qualsiasi momento
    Aggiunto anche il logo «sperimentale»
3. Scegliendo di saltare il Pomodoro, aggiunto avviso che non è possibile ottenere un Pomodoro
4. Aggiunto suggerimento per espandere e comprimere il Compito di esempio
5. Corretto il crash che poteva essere causato dal layout in cima all'elenco in alcune pagine
6. Ottimizzato il messaggio errore di rete quando la connessione è assente
7. Ottimizzato l'avviso Ricompensa monete al completamento dei sottocompiti, cambiato in promemoria Toast non invasivo

**1.83.0-alpha03 (2021/05)**

1. Corretto il problema per cui il layout vuoto della pagina composizione poteva superare lo schermo
2. Corretto il problema per cui il nome Attributo «Fascino» nella pagina nuova creazione veniva mostrato in modo errato
3. Corretti alcuni problemi con le impostazioni monete
4. Ottimizzato l'effetto animazione della pagina Obiettivi per adattarsi alla barra navigazione inferiore
    (Adattato ma l'interfaccia non è ancora pronta; attendere aggiornamenti successivi)
5. Aggiornata la versione SDK target ad Android 11
6. Corretto il problema di visualizzazione layout vuoto della pagina «Momenti»
7. Corretto il problema di calcolo interessi anomalo

**1.83.0-alpha02 (2021/05/16)**

1. Corretto il problema per cui potevano essere create ricette Sintesi nell'elenco «Tutti»
2. Dopo essere entrati nell'interfaccia sistema Sintesi, indipendentemente dall'elenco in cui ci si trova, il contenuto effettivamente mostrato è l'elenco «Tutti».
3. Riparazione semplice del metodo di calcolo interessi ATM

**1.83.0-alpha01 (2021/05/16)**

1. Sistema Sintesi completo, con supporto implementazione sintesi N-a-N
   - Checklist
   - Nuovo/Modifica
   - Finestra dialogo Sintesi
   - Modalità notturna e supporto multilingua
   - L'«ingresso» è in cima alla pagina Negozio
2. Refactoring del codice interno della pagina nuovo Oggetto
    Per la scalabilità dell'App, abbiamo quasi completamente riorganizzato il codice degli Oggetti appena creati e potremmo anche ridisegnare l'UI in futuro.
    I successivi aggiornamenti alpha aggiungeranno anche «data ripetizione obiettivo», «ora promemoria relativa», «Oggetti tipo penalità (da definire)» e altre funzioni.
    In caso di problemi, è possibile passare alla versione precedente della pagina in qualsiasi momento.

3. Aggiunto ingresso ATM in cima al Negozio
4. L'allegato Oggetto supporta fino a 9 immagini; percorso di archiviazione regolato
5. Funzione TAG squadra
    L'implementazione è integrata, ma il contenuto TAG specifico non è ancora configurato, quindi per ora non viene mostrato

**1.82.16 (2021/05)**

1. Corretto il problema per cui gli Oggetti di esempio non potevano eseguire correttamente la logica scadenza (valido solo per i nuovi utenti)
2. Corretto il problema per cui il numero di completamenti di Oggetti infiniti in certi scenari mancava di 1 volta

**1.82.15 (2021/05)**

1. Corretto il problema di riproduzione effetto sonoro di sottofondo

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Corretto il problema per cui Oggetti illimitati potevano rallentare il caricamento elenco e rendere impreciso il conteggio annullamenti
2. Corretto il problema per cui il completamento del Compito nel widget desktop poteva riprodurre più volte l'effetto sonoro di completamento
3. Corretto il problema per cui il conteggio totale degli Oggetti in cima nell'elenco intelligente non era preciso
4. Supporto eliminazione di tutti i dati locali e funzione elimina account
5. Corretto il problema per cui la modifica dei sottocompiti di Compiti di squadra non poteva essere ereditata

**1.82.12 (2021/05)**

1. Corretto il problema di conteggio annullando il completamento di Oggetti infiniti
2. Corretto il problema per cui gli Oggetti congelati venivano comunque promemorizzati
3. Ottimizzazioni allo scambio elenco, che possono aumentare la velocità di commutazione su dispositivi datati e aggiungere animazioni di caricamento
4. Corretto il problema per cui l'effetto sonoro personalizzato fine pausa non aveva effetto; supporto impostazione effetto sonoro fine temporizzazione prodotto
5. Corretto il problema per cui il Pomodoro non poteva conteggiare il tempo Concentrazione usando l'operazione «Salta»
6. Corretto il problema per cui il pulsante pausa del countdown prodotto non aveva effetto

**1.82.11 (2021/05)**

1. Corretto il problema di conteggio annullando il completamento di Oggetti infiniti
2. Corretto il problema per cui gli Oggetti congelati venivano comunque promemorizzati
3. Ottimizzazioni allo scambio elenco, che possono aumentare la velocità di commutazione su dispositivi datati e aggiungere animazioni di caricamento
4. Corretto il problema per cui l'effetto sonoro personalizzato fine pausa non aveva effetto; supporto impostazione effetto sonoro fine temporizzazione prodotto
5. Supporto lingua russa

**1.82.10 (2021/05)**

1. Corretto il problema per cui il Pomodoro non poteva conteggiare il tempo Concentrazione usando l'operazione «Salta»
2. Corretto il problema per cui il pulsante pausa del countdown prodotto non aveva effetto
3. Intercettato un crash causato dal fallimento creazione promemoria calendario

**1.82.9 (2021/05)**

1. Corretto il problema per cui il limite temporale dell'Oggetto copiato poteva essere svuotato e causare crash se ripetuto
2. Ottimizzata la velocità di aggiornamento dopo il completamento di Oggetti illimitati
2. Corretto il problema di calcolo ora promemoria per Compiti di squadra
3. Corretto il problema per cui il completamento con scorrimento poteva impedire la chiusura corretta dell'animazione lasciando lo schermo vuoto
4. I Compiti di squadra supportano l'abbandono con scorrimento
5. L'introduzione prodotto nella finestra acquisto supporta la navigazione con scorrimento

**1.82.8 (2021/04/28)**

**novità**

1. Aggiunta visualizzazione serie completamenti attuale
2. Ottimizzato l'effetto countdown Oggetti Negozio, con aggiunta delle operazioni termina e pausa; in caso di interruzione anomala il calcolo usa tempo assoluto
3. Supporto impostazione separata modalità vibrazione e interruttore campanello del Pomodoro
4. Supporto parziale anteprima scadenze future di eventi in corso nel calendario
5. Supporto riavvio eventi singoli e illimitati
6. Modificata la visualizzazione dati nella pagina «Io»: «Scaduto» e «Abbandona» sostituiti da «Obiettivo (sbloccato)» e «Riflessioni»; la pagina statistiche mostra ora il numero di «Scaduti» e «Abbandonati»
7. Supporto creazione diretta widget dalla pagina impostazioni «widget desktop» (solo Android 8 o superiore)

**miglioramenti**

1. Supporto visualizzazione immagini grandi degli Oggetti Negozio
2. Ottimizzato il consumo energetico che poteva essere causato dal conteggio passi
3. Corretti alcuni problemi di visualizzazione con font troppo grande
4. Ottimizzata la cancellazione di Oggetti illimitati
5. Ottimizzata la visualizzazione notifiche Pomodoro e aggiunta barra progresso
6. Dopo il completamento dell'evento, rimosso il promemoria notifica attualmente mostrato
7. Ottimizzate le statistiche entrate e uscite monete
8. Aggiunte alcune guide utente e suggerimenti
9. Modificando Oggetti, supporto cancellazione selezione Ricompensa prodotto
10. Gestendo crash continui, aggiunto avviso «Problemi noti»
11. Ottimizzato l'effetto visualizzazione quando l'Attributo non è selezionato

【Correzioni】

1. Dopo l'ordinamento elenco nella homepage, lo stato deve aggiornarsi immediatamente
2. Corretto il problema per cui la pagina dettagli non aggiornava subito l'elenco sottocompiti
3. Corretto forzatamente il crash dell'accesso autorizzato Weibo
4. Corretto il problema per cui il nome Oggetto mostrato nella notifica Pomodoro poteva essere errato
5. Corretto il problema per cui il countdown notifica Pomodoro era impreciso
6. Corretto il problema per cui la finestra Ricompensa non compariva quando Compito e Obiettivo avevano solo Ricompense prodotto
7. Corretto il problema per cui non era possibile acquistare prodotti a 0 monete in certe circostanze
8. Ottimizzato il metodo di calcolo riparazione Oggetti Ebbinghaus
9. Ottimizzato il metodo di calcolo del numero completamenti odierni per eventi illimitati

**1.82.7 (2021/04/10)**

1. Corretta la visualizzazione UI con dati vuoti nella schermata [Momenti]
2. La dimensione font segue di nuovo le impostazioni di sistema
3. Aggiornata traduzione inglese e portoghese

**1.82.5 (2021/04/02)**

1. Corretti alcuni problemi relativi al registro Pomodoro
2. Aggiunta nuova guida

**1.82.4-alpha01/beta (2021/03/25)**

1. Corrette Ricompense dei Bottini
2. Visualizza Riflessioni dei Compiti selezionati
3. Punti Esperienza/Ricompense monete casuali per Obiettivo personalizzato
4. I Compiti nell'elenco intelligente sono ora raggruppati per elenco
5. Ripetizione annuale
6. Ulteriori miglioramenti e correzioni bug

**1.82.1 (2021/03/12)**

1. Corretti alcuni problemi relativi agli elenchi intelligenti
2. Corretto il problema per cui la barra progresso poteva non cambiare dopo il completamento di un Compito
3. Corretto un problema con il completamento forzato di un Compito contatore
4. Corretto il problema per cui compariva «NULL» nella finestra inferiore scaduti

**1.82.0 (2021/03/11)**

1. Elenchi intelligenti
2. Ridisegnate le icone Attributi
3. Nuovo effetto Oggetto «Countdown»
4. Il timer Pomodoro continua a registrare tempo extra dopo il completamento del timer; è possibile aggiornare il tempo Concentrazione e ottenere Ricompensa extra.
5. I Compiti contatore possono ora essere completati forzatamente senza aver raggiunto le volte obiettivo.
6. Ora è possibile completare Compiti non ancora avviati e decidere se posticipare l'ora
7. Ulteriori correzioni e miglioramenti

**1.81.6**

1. Corretti problemi relativi al suggerimento promemoria Pomodoro

**1.81.5 (2021/03/02)**

1. Traduzione italiana (parziale)
2. Corretta icona notifica
3. Corretto il promemoria che non funzionava bene con ripetizione giorni della settimana
4. Corretta selezione «scatta foto» non funzionante
5. Altre correzioni minori

**1.81.0~1.81.4**

1. Ridisegnate alcune UI e animazioni
2. Il Compito viene completato automaticamente quando tutti i sottocompiti sono completati
3. Corretto bug relativo a modifiche multiple Punti Esperienza
4. Corretto bug relativo al ripristino Dropbox
5. Ora è possibile restituire l'Oggetto senza ottenere monete
6. Impostazione visualizzazione orologio 12 ore
7. Congela/Scongela Compiti multipli

**1.80.7（2021/01/26)**

1. Aggiunta statistica Oggetti Negozio
2. Ridisegnata finestra dialogo descrizione Attributi
3. Descrizione Attributi personalizzata
4. Aggiunta impostazione modalità compatta: nascondi tutte le informazioni extra
5. Corretto un bug di ripristino da file backup
6. Altre correzioni e miglioramenti...

**1.80.6（2021/01/22)**

1. Gli Oggetti con effetto Bottino possono ora essere condivisi sul Mercato
2. Nuova pagina ricerca: ora è possibile cercare utenti per nickname
3. Filtra Oggetti squadra/Mercato per intervallo temporale
4. Notifica aggiunta rapida Compiti
5. I file multimediali possono essere ignorati durante il backup.
6. Altre correzioni e miglioramenti...

**1.80.5（2021/01/14)**

1. Apri 10/50 Bottini con un clic
2. Aggiunta condizione sblocco [Ottieni l'Oggetto selezionato per un numero specificato di volte dai Bottini]
3. Impostazioni tasso interesse ATM
4. Inserimento numero per vendita/consumo pomodori
5. Effetto sonoro personalizzato fine timer pausa
6. Aggiunta guida utente
7. Corretti alcuni problemi e apportati miglioramenti

**1.80.4（2021/01/04)**

1. Corretto un crash su Android 6

**1.80.3（2021/01/04)**

1. Ritaglio immagine libero
2. Visualizza/Aggiungi l'icona degli Oggetti nel Mercato
3. Selezionando Compito/Oggetto, ora è possibile crearne uno nuovo direttamente
4. Supporto azione COPIA per Obiettivi utente
5. Molte correzioni e miglioramenti

**1.80.0（2020/12/24)**

1. Effetto Oggetto Negozio Bottino!
2. Integrazione backup Dropbox
3. Configurazioni modalità compatta
4. Aggiunta barra cronologia selezione foto
5. Molte correzioni e miglioramenti

**1.79.x（2020/12)**

1. 3 impostazioni condizione sblocco aggiuntive
2. Impostazioni effetti sonoro personalizzati
3. Imposta Ricompensa Oggetto per Obiettivi
4. Pagina registro timer Pomodoro
5. Crea Compito dalla pagina Calendario
6. 5 nuovi colori tema.
7. Molti miglioramenti e correzioni

**1.78.x（2020/11)**

1. Condizione sblocco Obiettivi personalizzati
2. Punti Esperienza Compito personalizzati
3. Molti miglioramenti e correzioni

**1.77.1（2020/11/05)**

1. Barra strumenti cambio elenco
2. Interruttore mostra Compiti completati
3. Gli elenchi possono ora essere archiviati
4. Aggiunta scheda stato monete
5. Ora è possibile creare Riflessioni per Obiettivi utente
6. Aggiunta impostazione per seguire la modalità notturna di sistema

**1.77.0（2020/10/28)**

1. Aggiunto modulo Mercato per la community, dove condividere il design Oggetti Negozio o importare l'Oggetto
2. Corretta la logica della ripetizione mensile
3. Corretto backup automatico WebDAV che non funzionava senza almeno un backup precedente

**1.76.0（2020/10/13)**

1. Monete predefinite sottocompito
2. Aggiunte icone in-App per creare Oggetti Negozio e Obiettivi
3. Prezzo pomodoro personalizzato
4. Impostazioni globali abilitazione effetti sonoro
5. Ora le Riflessioni possono essere cercate per contenuto Compito

**1.75.2（Released at 2020/10/05）**

1. Impostazione numero monete predefinite sottocompito
2. Aggiunte oltre 100+ icone selezionabili come icone Oggetti Negozio/Obiettivi
3. Aggiunta impostazione «Abilita effetto sonoro»
4. Filtra Riflessioni per contenuto Compito e UI filtri migliorata
5. Crea scorciatoie Pomodoro
6. Prezzi vendita pomodori personalizzati
7. La pagina Pomodoro mantiene lo schermo acceso durante il countdown
8. Corretti alcuni problemi

**1.75.1（Released at 2020/09/20）**

1. Corretti molti bug della 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Pomodoro gamificato
2. Colore tag Compito/elenco personalizzato
3. Backup automatico WebDAV
4. Impostazioni nascondi moduli
5. Molti miglioramenti e correzioni

**1.74.2（Released at 2020/08/23）**

1. Lingua portoghese

**1.74.0（Released at 2020/08/13）**

1. ATM: deposito e prelievo monete
2. Supporto selezione Oggetti Negozio come Ricompensa Compito
3. Impostazione quantità stock Oggetti Negozio
4. Migliorate animazioni e corretti alcuni bug
5. Aggiunto suggerimento per impostazione Frequenza ripetizione
6. Altro... (descrizione aggiornata in seguito)

**1.73.0（Released at 2020/07/26）**

**Novità:**

- Obiettivi utente
- Animazione diminuzione Punti Esperienza
- Modifica ora completamento registro cronologia
- Impostazione monete sottocompito squadra

**Miglioramenti:**

- Aggiunto effetto sonoro monete

**Correzioni:**

- Il problema della perdita impostazione monete sottocompito dopo ripetizione Compito

**1.72.1（Released at 2020/06/14）**

**Novità:**

- Cancella dati Obiettivi

**Miglioramenti:**

- Migliore visualizzazione descrizione Oggetti Negozio

**Correzioni:**

- Il problema della modifica immagini Oggetti Negozio
- Il problema della modifica testo Riflessioni

**1.72.0（Released at 2020/06/11）**

**Novità:**

- Promemoria sottocompito
- Monete sottocompito
- Widget App
  1. Impostazione opacità
  2. Mostra numero monete
  3. Mostra finestra input Compito contatore
- Selezione tempo pagina Statistiche
- Inventario: restituisci Oggetto
- Aggiunto supporto sottocompiti per squadra

**Miglioramenti:**

- Scorrere un Compito contatore aggiunge ora 1 completamento invece di contrassegnarlo come completato
- Aggiunto pulsante Aiuta a tradurre
- Aggiunta impostazione Ricompensa Punti Esperienza multipli abilitata per Compiti contatore

**Correzioni:**

- Corretto che la parte trasparente delle immagini PNG diventava nera dopo il ritaglio.
- Corretto che il widget App non funzionava bene su alcuni dispositivi.
- Corretto che il numero monete compariva nella pagina Dettagli quando impostato a 0.
- Corretto che Scorrimento per completare (modalità senza dialogo) rendeva la pagina visualizzata in modo errato
- Corretto che il sottocompito non poteva essere creato premendo INVIO su alcuni dispositivi

**1.71.3/1.71.4（Released at 2020/04/16）**

**Correzioni minori su icona e segnalazione crash**

**1.71.2（Released at 2020/04/14）**

**Novità:**

- Lingua turca (grazie a **İbrahim DOĞAN** per l'aiuto alla traduzione)

- Personalizza sfondo e opacità scheda Compito
- Personalizza testo pulsante azione Oggetto Inventario
- Preferiti Riflessioni
- Ricerca Riflessioni

**Miglioramenti:**

- Nuova icona

- Tipo segnalazione supporta più lingue
- Migliorata UI pagina Impostazioni
- Migliorato metodo cambio colore tema e lingua. Non serve più riavviare l'App perché abbia effetto.
- Migliorata pagina ritaglio immagine
- Migliorata UI selezione elenco
- Aggiunta descrizione Oggetti Negozio nella pagina elenco Negozio

**Correzioni:**

- Corretto bug data sblocco Obiettivo mostrata in modo errato
- Corretto bug immagine Oggetto Negozio vuota quando il file era eliminato.
- Non cancellare lo stato dei sottocompiti dopo che un Compito singolo diventa scaduto.
- Corretto bug spazio insufficiente per Grado difficoltà nella pagina Dettagli Compito.
- Corretto bug per cui, impostando Compito scaduto come completato, i completamenti del Compito successivo non aumentavano di uno.
- Corretto bug numero monete massimo mostrato in modo errato nelle impostazioni predefinite Compito.
- Resa scorrevole la pagina backup/ripristino dati.
- Corretto che scorrimento per completare Compito non funzionava bene con scorrimenti rapidi multipli.
- I widget App mostrano ora lo stato Congelato
- Corretto bug barra progresso pagina Compiti che a volte mostrava progresso errato

**Correzioni server（2020/4/13）**

- Corretta funzione segnalazione non funzionante

**v1.71.1 (Released at 2020/03/17)**

**Miglioramenti:**

- Migliore animazione barra progresso nella pagina Compiti

**Correzioni:**

- Corretto un bug che poteva causare crash all'avvio dell'App su alcuni dispositivi
- Corretto un bug relativo alla selezione foto

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Novità:**

- Funzione Riflessioni

- Aggiunta azione scorrimento: Completa Compito (senza dialogo)

**Correzioni:**

- Corretto bug stato scheda Compito mostrato in modo errato

- Corretto bug per cui Compito annullato poteva scomparire alla scadenza

- Corretto ordinamento selezionato mostrato in modo errato

**v1.70.6 (Released at 2020/03/09)**

**Miglioramenti:**

- Colori suggerimento Obiettivo sbloccato allineati al colore tema

**Correzioni:**

- Corretto stato finestra scaduti non mostrato correttamente dopo clic sul pulsante

- Corretto bug per cui COPIA non copiava i sottocompiti
- Corretto crash usando «Sposta in...»
- Corretto scheda selezione non mostrata correttamente su alcuni dispositivi

**v1.70.5 (Released at 2020/03/06)**

**Correzioni:**

- Scheda To-Do restava in caricamento cambiando colore tema o attivando/disattivando modalità notturna

**v1.70.4 (Released at 2020/03/05)**

**Miglioramenti:**

- La pagina Negozio mostra il numero monete quando non ci sono Oggetti
- Accesso alla pagina Dettagli monete cliccando il numero monete nella pagina Negozio
- Migliorato formato testo widget App in inglese
- Accesso alla pagina Dettagli Compito cliccando il Compito nel widget App

**Correzioni:**

- Stile visualizzazione errato attività squadra

**v1.70.3 (Released at 2020/03/05)**

**Miglioramenti:**

- La pagina Negozio mostra ora il numero monete quando non ci sono Oggetti
- Clic sul numero monete nella pagina Negozio per entrare nella pagina Dettagli monete
- Migliorato formato testo inglese sul widget App
- Clic sull'elemento widget App per entrare nella pagina Dettagli Compito

**Correzioni:**

- Corretto che, filtrando Oggi, il suggerimento piè di pagina «xx Compito/i non ancora avviato/i» non compariva dopo il completamento Compito

**v1.70.3 (Released at 2020/03/05)**

**Correzioni importanti:**

- Corretti bug inserimento numero monete
- Corretti bug aggiornamento sottocompiti
- Corretti bug impossibilità di mettere mi piace alle attività altrui
- Corretti bug impossibilità completare Compiti dal widget App

**v1.70.2 (Released at 2020/03/04)**

**Novità:**

- La community è ora disponibile per tutti i fusi orari

- Copia Compiti
- Supporto modifica impostazioni predefinite nuovo Compito
- Elenco Negozio

- Migliorate azioni widget App
- Aggiunto menu Compiti terminati nella pagina Calendario

**Miglioramenti:**

- Migliorate animazioni scheda Compito

- Rimossa un'autorizzazione non necessaria
- Aggiunto suono completamento
- Migliorato stile UI pagina Cronologia
- Aggiunta finestra «Autorizzazione scrittura/lettura calendario persa» abilitando promemoria Calendario di sistema senza autorizzazioni concesse

**Correzioni:**

- Corretti bug Compiti contatore in modalità compatta
- Corretti bug Compiti ripetuti
- Corretto crash che poteva verificarsi eliminando sottocompiti
- Corretto crash inserendo URL WebDAV errato
- Corretto colore tema mostrato in modo errato, che poteva verificarsi dopo ripristino backup

### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**🚀 Novità**

1. Supporto gestione archivi

- Backup sul computer
- Ripristino dal computer
- Supporto trascinamento

2. Supporto creazione nuove Riflessioni

- Supporto selezione immagini
- Supporto sincronizzazione immagini con dispositivo mobile

3. Supporto visualizzazione dettagli Compito
4. Miglioramenti sistema acquisto

- Usa la nuova API «Acquista Oggetti»
- Mantiene i limiti di acquisto coerenti con l'App

5. Supporto validazione API Token opzionale
6. Supporto multipiattaforma

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Migliorata gestione errori e notifiche

**v1.1.1 (2023/08/29)**

**🔧 Ottimizzazioni e correzioni bug**

1. Corretto comportamento imprevisto inserendo monete d'oro
2. Corretto il problema per cui il controllo aggiornamenti poteva causare crash dell'App

**v1.1.0 (2023/06/25)**

**🚀 Novità**

1. Supporto controllo automatico indirizzo IP e connessione di «LifeUp Cloud» (richiede LifeUp Cloud v1.3.0)
2. Supporto aggiunta Compiti, ma le opzioni attualmente supportate sono limitate (Risolto [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Supporto esportazione Riflessioni in formato markdown (Risolto [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Aggiunto testo in cinese tradizionale
5. Aggiunta versione per macOS
6. Supporto controllo aggiornamenti

**🔧 Ottimizzazioni e correzioni bug**

1. Corretto il problema per cui le sottocategorie Obiettivi non potevano essere visualizzate correttamente
2. Corretto il problema per cui alcune icone non potevano essere visualizzate correttamente (richiede LifeUp v1.91.3)
3. Corretto il problema di mancata corrispondenza del titolo (Risolto [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Aggiunta opzione collegamenti per l'installer Windows (Risolto [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Migliorato il metodo di rilevamento dimensioni finestra, adattato a risoluzioni inferiori a 1080p

**v1.0.2 (2023/02/20)**

1. Aggiunta finestra popup segnalazione errori più dettagliata [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Migliorata configurazione pacchetto

**v1.0.1 (2023/02/12)**

1. Prima versione

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**🚀 Novità**

1. Esposto il tempo di completamento dei sottocompiti (`endTime`) nel modello dati SDK e nelle risposte HTTP API.

**v2.1.0 (2026/03/22)**

**🚀 Novità**

1. Aggiunto supporto configurazione locale e aggiornamenti localizzazione Top-14.
2. Esposti campi progresso conteggio e condizione fine ripetizione per Compiti API.

**🐛 Correzioni bug**

1. Corretti problemi di compatibilità ContentProvider.
2. Adattata UI Android 15 e comportamento avvio servizio.

**v2.0.0 (2025/01/01)**

**🚀 Novità**

1. Ottimizzazione servizio

- Migliorata logica e compatibilità rilevamento servizio
- Più dispositivi supportano il rilevamento automatico IP
- Ottimizzate transizioni stato avvio/pausa servizio
- Migliorata gestione errori e notifiche

2. Sicurezza e prestazioni

- Aggiunta validazione API Token opzionale
- Aggiunte opzioni configurazione CORS
- Supporto impostazioni porta personalizzate
- Supporto durata wake lock personalizzata

3. Miglioramento UI

- Design interfaccia completamente nuovo
- Migliorata esperienza visiva complessiva

**v1.3.0 (2023/06/25)**

**🚀 Novità**

1. Supporto registrazione servizio mDNS per consentire al desktop di rilevare automaticamente il suo IP (richiede desktop v1.1.0)
2. Aggiunti valori risultato per API invocate tramite ContentProvider.

**🔧 Miglioramenti**

1. Aumentato l'area cliccabile del pulsante scansione codice QR
2. Corretto crash ActivityNotFound

**v1.2.0 (2023/03/10)**

1. Supporto scansione codice QR per invocare API
2. Migliorata visualizzazione elenco IP

**v1.1.2 (2023/02/12)**

1. Supporto interrogazione dati completi tramite Content Provider, usato per supportare funzioni desktop
2. Standardizzato contenuto risposta HTTP

**v1.0.3-preview (2022/11/22)**

1. Prima versione (più alcune correzioni bug della prima versione)

<!-- tabs:end -->

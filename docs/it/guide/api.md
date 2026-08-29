<h1 align="center" padding="100">Interfaccia aperta</h1>

<p align="center">Crea possibilità infinite!</p>

?> Nella versione v1.90, `LifeUp` ha aperto diverse interfacce funzionali; è benvenuta qualsiasi integrazione con applicazioni esterne. <br/>Offre anche l'effetto «URL» per gli Oggetti del Negozio, così gli utenti possono usarli direttamente per chiamare applicazioni esterne o l'interfaccia di `LifeUp`. <br/>Queste funzioni possono dare al tuo `LifeUp` possibilità illimitate, ma richiedono anche un po' di comprensione e pratica.

**Ultimo aggiornamento: 2026/08/28**

I parametri e le definizioni delle API in questo documento si basano sulla versione **v1.106.0**.

Assicurati che la tua App sia aggiornata alla **v1.106.0** prima di usare le API più recenti.

L'aggiornamento viene distribuito gradualmente tramite Google Play; se non l'hai ancora ricevuto, abbi pazienza, arriverà presto.

## Esempio di scenario

| Chiamante | Scenario | Note |
| ------ | -------- | ----- |
|**LifeUp→Altre applicazioni**<br/>Implementato tramite l'effetto «URL» dell'Oggetto del Negozio| **Dopo aver usato l'Oggetto del Negozio:**<br/>1. Usare un browser per visitare una pagina web<br/>2. Passare a WeChat e scansionare, o aprire un miniprogramma specifico<br/>3. Aggiungere automaticamente registri contabili ([ad esempio, «Qianji» supporta un'interfaccia contabile](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Salvare la configurazione dell'automazione Tasker (anche condividerla nel Market) e importarla automaticamente in Tasker dopo l'uso<br/>5. Attivare Tasker per cambiare lo sfondo<br/>6. ... (purché l'applicazione esterna supporti questo metodo di chiamata) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) è uno strumento di automazione e supporta l'esportazione della configurazione come Uri |
|**LifeUp→LifeUp**<br/>Implementato tramite l'effetto «URL» dell'Oggetto del Negozio| **Dopo aver usato l'Oggetto del Negozio:**<br/>1. Aprire una pagina specifica<br/>2. Aumentare il tasso di interesse del bancomat<br/>3. Mostrare una finestra popup per far selezionare all'utente il prodotto e ridurne il prezzo (buono sconto)<br/>4. Attivare il completamento di un Compito<br/>5. Mostrare un messaggio motivazionale personalizzato<br/>6. Creare un modello di Ricompensa Compito: basta inserire il nome per creare automaticamente un Compito<br/>7. Mostrare una finestra che chiede all'utente di scegliere un ramo, creando una piccola interazione contestuale<br/>8. Altre operazioni nell'App... |  |
|**Applicazioni esterne/pagine web→LifeUp** | **Configurare strumenti di automazione:**<br/>1. Rilevare quando il telefono si accende per la prima volta ogni giorno, completare il Compito di svegliarsi presto o attivare direttamente la penalità per «svegliarsi tardi»<br/>2. Dopo ogni 25 parole, passare una carta NFC specifica e completare automaticamente il Compito<br/>3. Il GPS rileva l'arrivo in un nuovo luogo e sblocca l'Obiettivo «nuovo luogo»<br/>4. Connettendosi ogni giorno al Wi-Fi del lavoro, aumenta il progresso della condizione di sblocco; dopo 20 giorni accumulati, si sblocca l'Obiettivo «Lavoratore»<br/>5. Ricompensarsi con monete d'oro per «arrivare a casa» alla prima connessione giornaliera al Wi-Fi di casa<br/>6. Catturare le notifiche di altre app Pomodoro o Concentrazione e registrare automaticamente il tempo in `LifeUp`<br/>7. Catturare la notifica di completamento o fine di software sportivi o di studio e assegnare automaticamente Punti Esperienza di «forza» e «conoscenza»<br/>8. Nel periodo che imposti, ogni volta che apri il telefono si attiva una penalità<br/>9. ...<br/>**Collegamenti con applicazioni esterne/app propria:**<br/>1. Se il Pomodoro di `LifeUp` non ti convince: puoi sviluppare il tuo software di cronometraggio, web o Android, e collegarlo a «LifeUp» tramite l'interfaccia per aggiungere registri di tempo o Ricompense<br/>2. Modificare alcuni minigiochi di intelligenza (come l'esempio Wordle più sotto). Al completamento con successo, attivare l'invio di Ricompense da parte di `LifeUp`<br/>3. ... |  |

<br/>In altre parole, tutti gli scenari sopra sono in realtà «eventi» che attivano «azioni».

Questo aggiornamento di `LifeUp` fornisce il punto di attivazione dell'evento «uso degli Oggetti» e, a seguire, varie «azioni» (Ricompense, completamento Compiti, ecc.).

Se ti serve

- Fare clic su un pulsante web
- Passare una carta NFC
- Sbloccare lo schermo per la prima volta ogni mattina

Questo tipo di eventi richiede l'intervento di applicazioni esterne. Ad esempio, fare uno sviluppo secondario da solo o usare strumenti di automazione come `Tasker` e `MacroDroid`.

**L'aggiornamento LifeUp 1.90.2 aggiungerà una serie di «eventi», ricevibili da strumenti di automazione o applicazioni esterne.**

Si può usare per ottenere:

Dopo aver usato l'Oggetto, attivare strumenti di automazione come Tasker per cambiare lo sfondo del launcher.

Dopo aver completato il Compito, attivare uno strumento di automazione come Tasker per aprire un'app.

**Nella versione 1.90.2, è possibile realizzare l'«evento LifeUp» che attiva l'«operazione di Tasker».**

Tasker ha permessi molto ampi: può cambiare sfondi, disinstallare app, alzare il volume, scegliere quale app aprire e molto altro. Puoi persino scrivere logica di interazione UI senza basi di programmazione.

---

## Consigli

**Se non hai familiarità con la programmazione,** puoi cercare e importare Oggetti speciali del Negozio direttamente in [Mondo] → [Market] → tag [Link]/[API]/[Automate]. Puoi anche provare a modificare i parametri per adattarli alle tue esigenze.

**Se conosci l'informatica,** puoi leggere la documentazione delle interfacce che segue e modificare tu stesso l'effetto desiderato. Usala insieme a software di automazione come [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Anche senza modificare la configurazione di Tasker, se riesci a installarlo, puoi importare configurazioni di automazione condivise da altri nel Market o in altre community.

**Se hai basi di programmazione,** puoi sviluppare pagine web o applicazioni Android per integrarle con LifeUp. Questa pagina e versioni personalizzate di Wordle ne sono alcuni esempi. Puoi anche creare e condividere configurazioni di strumenti di automazione.

---

## Chiamare un'altra applicazione

Se vuoi chiamare un'applicazione esterna in *LifeUp*, basta aggiungere un effetto «Link» all'Oggetto del Negozio, **inserire un collegamento web o specifico dell'applicazione** e usare l'Oggetto per attivare la chiamata.

**Alcuni esempi (puoi anche andare in «Mondo»→«Market»→«Link» per vedere Oggetti pubblici con effetto di chiamata interfaccia):**

- Aprire Google nel browser: https://www.google.com
- Facebook: [fb://](fb://)
- Aprire un'app con il nome del pacchetto/ID: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

In teoria, finché l'app esterna fornisce l'URL, puoi saltare usandola come Oggetto del Negozio.

**Puoi cercare il collegamento dell'applicazione che ti serve cercando `URL Schemes` su Google.**

**Questi collegamenti non hanno nulla a che fare con `LifeUp`; `LifeUp` offre solo la funzione di salto URL.**

**Quindi non manteniamo (e non manterremo) un elenco di URL. Ma puoi vedere gli Oggetti pubblici del Negozio con effetto link nella pagina [Mondo]→[Market]→[Link].**

Puoi trovare il nome del pacchetto di un'app (detto anche ID):

- nell'URL Play Store: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- con un'app gestore applicazioni
- con l'azione App Info in Tasker
- con l'azione Launch App in Macrodroid

---

## Chiamare le API di LifeUp

Se:

- Devi chiamare l'interfaccia di `LifeUp` dentro `LifeUp`. Aggiungi solo un effetto «link» all'Oggetto del Negozio, inserisci **un URL specifico** secondo la documentazione delle API e usa l'Oggetto per completare la chiamata.
- Chiami da una pagina web, basta saltare alle API di LifeUp tramite un collegamento ipertestuale.
- Chiami da un'app che sviluppi tu, usa Intent per saltare al collegamento interfaccia corrispondente.
- Chiami da uno strumento di automazione (come Tasker), inserisci il collegamento API corrispondente in Browser URL di Tasker.

**Alcuni esempi:**

Facendo clic sul collegamento seguente, «LifeUp» mostrerà «You have learned to call APIs!».

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Facendo clic sul collegamento seguente, otterrai una moneta in «LifeUp», e il motivo sarà «Learn API Calls».

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Se copi il collegamento nell'effetto «link» dell'Oggetto, usarlo attiverà lo stesso effetto.

**Esempio di collegamento con applicazione esterna:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle è un piccolo gioco di parole: indovina parole di 5 lettere. L'arancione indica che la lettera è nella risposta; il verde, che è nella posizione corretta.

**Questa versione di Wordle supporta il collegamento con «LifeUp»:**

1. Se indovini la parola, ottieni 10 monete, con un motivo personalizzato.
2. Se non indovini alla fine, c'è un premio di consolazione di 1 moneta.

![](_media/api/wordle.png ':size=30%')

<br/>

**Esempio di collegamento con Tasker:**

> Tasker si invoca selezionando `Action Category`→`Program`→`Shortcut`. Inserisci nella colonna scorciatoia il collegamento che inizia con lifeup://.

Sbloccare lo schermo per la prima volta dopo le 5 ogni giorno può attivare il completamento del Compito che indichi (ad esempio, svegliarsi).

**Nota: per importare questa configurazione serve un Task Group Id. Puoi attivare [Developer Mode] in [Settings]→[Labs] e controllare il gid nella pagina dettagli del Compito.**

Se hai Tasker installato, [clicca qui per importare i Compiti configurati.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**Come usare MacroDroid per chiamare le API di LifeUp:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) è anche uno strumento di automazione; è gratuito e l'interfaccia è più semplice.

1. Aggiungi macro, poi imposta le condizioni che ti servono (o fallo più tardi)
2. Aggiungi `Actions`
3. Seleziona `Applications`
4. Seleziona `Open Website`
5. Inserisci un URL che inizia con `lifeup://` nel campo `Enter URL`
6. **[Deseleziona]** tutte le opzioni sotto, come `URL encode parameters`...
7. Salva; puoi cliccare l'azione e scegliere `Test action` per verificare

<br/>

**Con questa funzione puoi ampliare all'infinito le possibilità di LifeUp, che tu conosca o meno la programmazione!**

Consulta sotto le regole specifiche di chiamata.

---

## Documentazione delle interfacce

### Basics - Examples

| Tipo             | Descrizione   |
| ---------------- | ------------- |
| Esempio          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Formato interfaccia | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Prefisso fisso     | lifeup://api/ |
| Nome metodo      | toast         |
| Parametri       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

Se il valore del parametro contiene simboli speciali come +, spazio, =, %, &, #, ecc., va escapato:

| Caratteri speciali | Significato                                         | Sostituire con |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | Il segno + nell'URL rappresenta uno spazio        | +          |
| spazi             | Gli spazi negli URL possono essere + o codificati              | %20        |
| /                  | Separa directory e sottodirectory            | %2F        |
| ?                  | Separa l'URL effettivo e i parametri         | %3F        |
| %                  | Specifica caratteri speciali                      | %          |
| #                  | Indica un segnalibro                                  | %23        |
| &                  | Separatore tra parametri specificati nell'URL   | %26        |
| =                  | Valore del parametro specificato nell'URL | %3D        |

Prendendo come esempio l'interfaccia del messaggio popup sopra: se vuoi che il testo finale mostrato sia `You have learned to call APIs!`,
devi sostituire gli spazi con +; il risultato finale è:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Questo è un semplice strumento di codifica implementato in Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Quasi tutti i dati memorizzati in LifeUp hanno un id univoco.

Alcune delle interfacce seguenti supportano la modifica di Oggetti del Negozio **specifici** e il completamento di Compiti **specifici**.

Per far trovare a `LifeUp` i dati corrispondenti, devi fornirgli un id.

**Puoi attivare «Settings» → «Labs» → «Developer Mode» per vedere l'id originale dei dati in ogni pagina dettagli nell'App.**

Ad esempio, se il nome dell'Attributo è mostrato come «strength (1)», il suo id Attributo è 1.

#### Task id

Si può vedere nella pagina dettagli dell'evento.

id: Se è un Compito ripetitivo, l'id si aggiorna a ogni ripetizione.

gid: L'id del gruppo di elementi. Per lo stesso Compito ripetitivo, il gid non cambia.

#### List id

Dopo aver attivato «Developer Mode», consultalo nella finestra popup «Select List».

#### Attribute id

Dopo aver attivato «Developer Mode», consultalo nella pagina «Custom Attributes».

#### Shop item id

Dopo aver attivato «Developer Mode», clicca sull'Oggetto del Negozio per vedere i dettagli.

#### Achievement condition id

Dopo aver personalizzato la condizione di sblocco dell'Obiettivo «requires an external API call to unlock», puoi vedere l'id della condizione nella pagina dettagli.

<br/>

### Basics - Name Matching

Quando un'API supporta la ricerca di Compiti, Oggetti del Negozio o sottocompiti per nome, LifeUp prova prima una corrispondenza esatta ignorando maiuscole e minuscole. Se non c'è corrispondenza esatta, passa alla corrispondenza fuzzy per contenimento.

Ad esempio, se esistono «Coin» e «Coin Box», passare `name=Coin` corrisponde prima a «Coin» invece del primo risultato fuzzy che compare.

Se nomi duplicati o simili possono essere ambigui, preferisci passare l'id corrispondente.

<br/>

### Basics - Return Values

Alcune interfacce possono restituire valori.

**Se sviluppi un'applicazione Android,** puoi usare il metodo `onActivityResult` per ricevere il valore restituito.

**Se usi un'applicazione di automazione come Tasker:**

In genere, queste applicazioni non possono ricevere valori restituiti di tipo Activity. Devi aggiungere un parametro `broadcast` e usare l'evento `received intent` per ricevere il valore restituito.

Per i dettagli, consulta i parametri broadcast più sotto.

<br/>

### Basics - JSON Data Structure

?> Richiede v1.98.0+

Questa sezione presenta le strutture JSON usate di frequente nelle API.

#### 1. Struttura Ricompensa Oggetti

Un array JSON che specifica Ricompense Oggetti; ogni elemento contiene un ID e una quantità.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Struttura condizione di sblocco Obiettivi

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Struttura limite di acquisto

`purchase_limit` è un array JSON. Ogni oggetto rappresenta una regola di restrizione.

| Campo | Significato | Tipo | Obbligatorio | Note |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Tipo di restrizione | number | Sì | Vedi la tabella tipi sotto |
| limitNumber | Valore numerico principale | number | No* | Usato da regole basate su quantità/intervallo |
| maxNumber | Limite superiore di un intervallo | number | No | Usato per intervallo Livello Attributo / quantità Oggetti posseduti |
| limitId | ID obiettivo correlato | number | No* | Obbligatorio per regole basate su Attributo / Oggetto / Compito / ciclo Compito / Obiettivo |
| extendInfo | Payload aggiuntivo | string | No | Usato da regole basate sul tempo; il valore è una stringa JSON |

**Definizione tipi**

| limitType | Significato | Campi obbligatori / note |
| --------- | ------- | ----------------------- |
| 0 | Limite quantità giornaliero | `limitNumber`: massimo volte al giorno |
| 1 | Limite quantità settimanale | `limitNumber`: massimo volte a settimana |
| 2 | Limite quantità mensile | `limitNumber`: massimo volte al mese |
| 3 | Limite quantità annuale | `limitNumber`: massimo volte all'anno |
| 10 | Regola Livello Attributo | `limitId`: ID Attributo<br/>`limitNumber`: livello minimo<br/>`maxNumber`: livello massimo opzionale |
| 20 | Intervallo orario giornaliero | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Selezione giorni lavorativi | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Lunedì = 1, domenica = 7 |
| 22 | Intervallo orario assoluto | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Selezione mesi | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Selezione giorno del mese | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Regola quantità Oggetti posseduti | `limitId`: ID Oggetto target<br/>`limitNumber`: quantità minima posseduta<br/>`maxNumber`: quantità massima posseduta opzionale |
| 31 | Regola Compito completato | `limitId`: ID Compito |
| 32 | Regola Obiettivo sbloccato | `limitId`: ID Obiettivo |
| 33 | Regola ciclo Compito completato | `limitId`: ID gruppo Compiti ripetitivi (`groupId`)<br/>Validato rispetto all'ultimo ciclo avviato in quel gruppo |

**Note**

- Quando `limitType=33`, `limitId` non è un ID Compito. Deve essere il `groupId` del Compito ripetitivo.

- I payload compatibili con versioni precedenti possono omettere `maxNumber` e `extendInfo`.
- `extendInfo` è un campo stringa; chiamando l'API tramite URL, la stringa JSON interna di solito richiede un ulteriore livello di escape/codifica.

**Esempio:**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Struttura effetto Oggetto

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Descrizione tipi di effetto

?> I tipi 10-16 sono supportati da v1.102.0+.

| Codice tipo | Significato | Descrizione parametri |
| ------- | ---- | ------- |
| 0 | Nessun effetto speciale | Nessun parametro |
| 1 | Non utilizzabile | Nessun parametro |
| 2 | Aggiungi monete | min: Monete minime<br/>max: Monete massime (opzionale, predefinito min)<br/>using_limit: Se applicare limiti di sistema (opzionale) |
| 3 | Rimuovi monete | min: Monete minime<br/>max: Monete massime (opzionale, predefinito min)<br/>using_limit: Se applicare limiti di sistema (opzionale) |
| 4 | Aggiungi esperienza | ids: Array ID Abilità<br/>value: Valore esperienza (legacy, uguale a min)<br/>min: Esperienza minima (opzionale, se value non è indicato)<br/>max: Esperienza massima (opzionale, predefinito min/value)<br/>using_limit: Se usare limite (opzionale, false predefinito) |
| 5 | Rimuovi esperienza | ids: Array ID Abilità<br/>value: Valore esperienza (legacy, uguale a min)<br/>min: Esperienza minima (opzionale, se value non è indicato)<br/>max: Esperienza massima (opzionale, predefinito min/value)<br/>using_limit: Se usare limite (opzionale, false predefinito) |
| 6 | Sintesi semplice | require_number: Quantità richiesta<br/>item_id: ID Oggetto |
| 7 | Apri Bottino | items: Array Oggetti; ogni elemento contiene:<br/>- item_id: ID Oggetto<br/>- amount: Quantità<br/>- probability: Probabilità<br/>- is_fixed_reward: Se è Ricompensa fissa |
| 8 | Conto alla rovescia | seconds: Secondi del conto alla rovescia |
| 9 | Collegamento web | url: Indirizzo collegamento<br/>use_web_view: Se usare il browser integrato (opzionale, false predefinito) |
| 10 | Registra Riflessione | Nessun parametro |
| 11 | Modifica monete (aumenta o diminuisce) | min: Monete minime (può essere negativo)<br/>max: Monete massime (opzionale, predefinito min)<br/>using_limit: Se applicare limiti di sistema (opzionale) |
| 12 | Modifica esperienza (aumenta o diminuisce) | ids: Array ID Abilità<br/>value: Valore esperienza (legacy, uguale a min)<br/>min: Esperienza minima (può essere negativa)<br/>max: Esperienza massima (opzionale, predefinito min/value)<br/>using_limit: Se usare limite (opzionale, false predefinito) |
| 13 | Aggiungi stock Oggetto | item_id: ID Oggetto target<br/>min: Variazione stock minima<br/>max: Variazione stock massima (opzionale, predefinito min)<br/>using_limit: Se applicare limiti stock (opzionale) |
| 14 | Rimuovi stock Oggetto | item_id: ID Oggetto target<br/>min: Variazione stock minima<br/>max: Variazione stock massima (opzionale, predefinito min)<br/>using_limit: Se applicare limiti stock (opzionale) |
| 15 | Modifica stock Oggetto (aumenta o diminuisce) | item_id: ID Oggetto target<br/>min: Variazione stock minima (può essere negativa)<br/>max: Variazione stock massima (opzionale, predefinito min)<br/>using_limit: Se applicare limiti stock (opzionale) |
| 16 | Riproduci suono | file_name: Nome file audio locale (preferito)<br/>uri: URI suono da importare (alternativa a file_name)<br/>display_name: Nome visualizzato (opzionale) |

**Esempi di effetto:**

Aumenta oro casuale:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Aumenta Punti Esperienza:

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Modifica monete (casuale +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Modifica stock Oggetto (casuale +/-):

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Riproduci suono:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Effetto apri Bottino:

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>
### Popup message

**Nome metodo:** toast

**Descrizione:** Compaiono messaggi popup di vari stili

**Esempio:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Spiegazione:** Il messaggio «Live well, eat well!» compare con stile bonus e resta visibile più a lungo.

> Clicca sul collegamento dell'esempio per provare l'effetto

| Parametro | Significato                | Tipo               | Esempio              | Obbligatorio | Note |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Testo del messaggio | Qualsiasi testo           | You learned to call! | sì      |       |
| type      | Stile del testo        | Numero da 0 a 6 | 1                    | no       | 0 - Stile normale<br/>1 - Stile bonus<br/>2 - Stile pomodoro<br/>3 - Stile successo<br/>4 - Stile avviso<br/>5 - Stile avvertimento<br/>6 - Stile errore |
| isLong    | Durata di visualizzazione       | true o false      | true                 | no       | true - lungo<br/>false - corto |

<br/>

### Reward

**Nome metodo:** reward

**Descrizione:** Assegna la Ricompensa direttamente. Puoi personalizzare il motivo.

**Esempio:**

- Ottieni 1 moneta; il motivo è «Learn API Calls». Il motivo verrà mostrato nella pagina dettagli monete:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Ottieni 300 Punti Esperienza per «Learning, Creativity»; il motivo è «Learn API Calls». Il motivo verrà mostrato nella pagina dettagli EXP:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Ottieni 1 Oggetto con corrispondenza fuzzy «treasure»; il motivo è «Learn API Calls». Il motivo verrà mostrato nella cronologia Inventario:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parametro | Significato                       | Tipo                            | Esempio            | Obbligatorio | Note                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | Tipo di Ricompensa                   | attualmente supporta solo:<br/>coin<br/>exp<br/>item | coin | sì | coin - monete<br/>exp - Punti Esperienza<br/>item - Oggetti del Negozio |
| content   | Motivo della Ricompensa                 | qualsiasi testo                        | Learning API Calls | Sì      |                                  |
| skills    | Abilità (Attributi)           | array di numeri maggiori di 0 | 1                  | No       | Solo quando type è exp<br/>Supporta array (es. &skills=1&skills=2&skills=3)<br/>Per sapere come ottenerli, consulta l'articolo «Basics - LifeUp Data ID» più sopra |
| number    | Quantità di Ricompense             | numero maggiore di 0         | 1                  | Sì      | Se sono monete, il massimo è 999999<br/>Se sono Punti Esperienza, il massimo è 99999<br/>Se è un Oggetto, il massimo è 999 |
| item_id   | ID Oggetto                       | numero maggiore di 0           | 1                  | no*      | solo quando type è item |
| item_name | Nome Oggetto                     | qualsiasi testo                        | treasure           | no*      | solo quando type è item; corrispondenza fuzzy con i nomi Oggetto |
| silent    | Disattiva avvisi interfaccia | true o false                   | false              | no       | false per impostazione predefinita                 |

<br/>

### Penalty

**Nome metodo:** penalty

**Descrizione:** Applica una penalità direttamente. Puoi personalizzare il motivo.

**Esempio:** *Sostanzialmente uguale all'interfaccia reward

- Penalizza 1 moneta; il motivo è «sleep in». Il motivo verrà mostrato nella pagina dettagli monete:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Penalizza 300 Punti Esperienza di «Strength» per «sleep in». Il motivo verrà mostrato nella pagina dettagli EXP:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Penalizza 1 Oggetto con corrispondenza fuzzy «treasure» per «sleep in». Il motivo verrà mostrato nella cronologia Inventario:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parametro | Significato                       | Tipo                                                 | Esempio  | Obbligatorio | Note            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | Tipo di penalità                  | Attualmente supporta solo:<br/>coin<br/>exp<br/>item | coin     | sì      | coin - monete<br/>exp - Punti Esperienza<br/>item - Oggetti del Negozio |
| content   | Motivo della penalità            | qualsiasi testo                                             | Sleep In | Sì      |                  |
| skills    | Abilità (Attributi)           | array di numeri maggiori di 0                      | 1        | No       | Solo quando type è exp<br/>Supporta array (es. &skills=1&skills=2&skills=3)<br/>Per sapere come ottenerli, consulta l'articolo «Basics - LifeUp Data ID» più sopra |
| number    | Quantità penalizzata             | numero maggiore di 0                              | 1        | Sì      | Se sono monete, il massimo è 999999<br/>Se sono Punti Esperienza, il massimo è 99999<br/>Se è un Oggetto, il massimo è 999 |
| item_id   | ID Oggetto                       | numero maggiore di 0                                | 1        | no*      | solo quando type è item |
| item_name | Nome Oggetto                     | qualsiasi testo                                             | treasure | no*      | solo quando type è item; corrispondenza fuzzy con i nomi Oggetto |
| silent    | Disattiva avvisi interfaccia | true o false                                        | false    | no       | false per impostazione predefinita |

<br/>

### Edit Coin

**Nome metodo:** edit_coin

**Descrizione:** Modifica direttamente il saldo monete dell'utente. Il saldo attuale verrà impostato al valore indicato. Puoi personalizzare il motivo della modifica; verrà mostrato nella cronologia monete.

**Esempio:**

- Imposta le monete a 1000 con motivo «API adjustment»: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Imposta le monete a 500 in silenzio: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parametro | Significato | Tipo | Esempio | Obbligatorio | Note |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Saldo monete target | number >= 0 | 1000 | Sì | Saldo finale dopo l'operazione; massimo 999999 |
| content | Motivo della modifica | qualsiasi testo | API adjustment | No | Se non indicato, usa il motivo predefinito di sistema |
| reason | Motivo della modifica (alias) | qualsiasi testo | API adjustment | No | Alternativa al parametro content |
| silent | Disattiva notifica interfaccia | true o false | false | No | false per impostazione predefinita; true sopprime il messaggio toast |

<br/>

### Tasks

#### Add a Task

?> Alcuni campi come `pin` richiedono v1.98.0+

**Nome metodo:** add_task

**Descrizione:** Crea un Compito direttamente

**Esempio:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parametro         | Significato             | Valori                | Esempio   | Obbligatorio | Note                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Contenuto Compito        | qualsiasi testo             | Write diary | Sì     |                                |
| notes            | Note               | qualsiasi testo             | Notes      | No       | Vuoto per impostazione predefinita               |
| coin             | Ricompensa in monete         | number >= 0         | 10         | No       | 0 per impostazione predefinita; soggetto ai limiti di sistema                   |
| coin_var         | Variazione monete| number >= 0          | 1          | No       | 0 per impostazione predefinita; se >0, Ricompensa casuale tra [coin, coin+coin_var] |
| exp              | Ricompensa Punti Esperienza   | number >= 0          | 100        | No       | 0 per impostazione predefinita; soggetto ai limiti di sistema                   |
| skills           | ID Abilità           | array di numeri > 0 | 1          | No       | Supporta array (es. &skills=1&skills=2) |
| category         | ID elenco             | number >= 0          | 0          | No       | 0 per impostazione predefinita (elenco predefinito); elenchi intelligenti non consentiti |
| frequency        | Frequenza di ripetizione    | integer              | 0          | No       | 0 per impostazione predefinita (una volta)<br/>0 - Una volta<br/>1 - Giornaliera<br/>N (N>1) - Ogni N giorni<br/>-1 - Illimitata<br/>-3 - Ebbinghaus (richiede v1.99.1)<br/>-4 - Mensile<br/>-5 - Annuale |
| weekdays         | Giorni lavorativi            | `1,3,5` o `none`    | 1,3,5      | No       | v1.106.0+; 1=lunedì … 7=domenica, giorni **in cui ripetere**. Se presente, frequency deve essere omesso o 1. `none` viene rifiutato in add; in edit, `none` ripristina giornaliera. Tutti e 7 i giorni sono trattati come giornaliera |
| importance       | Livello importanza    | [1, 4]              | 1          | No       | 1 per impostazione predefinita                   |
| difficulty       | Livello difficoltà    | [1, 4]              | 1          | No       | 1 per impostazione predefinita                   |
| deadline         | Scadenza            | timestamp (millisecondi) | 1640995200000 | No |                               |
| no_deadline      | Nessuna scadenza         | true/false         | true      | No       | v1.104.0+; valido solo per Compiti ripetitivi. Passare `&no_deadline=true` cancella la scadenza specifica |
| color            | Colore etichetta           | stringa colore         | #66CCFF    | No       | # va escapato come %23        |
| background_url   | URL immagine di sfondo| URL web             | http://example.com/bg.jpg | No | Deve essere un'immagine web accessibile |
| background_alpha | Opacità sfondo  | float tra [0, 1] | 0.5        | No       | 1.0 per impostazione predefinita                |
| enable_outline   | Contorno testo | true o false       | false      | No       | Valido solo con background_url; aggiunge contorno al testo per migliorare la leggibilità |
| use_light_remark_text_color | Testo chiaro per le note | true o false | false | No | Valido solo con background_url; usa colore chiaro per le note |
| start_time       | Ora di inizio          | timestamp (millisecondi) | 1640995200000 | No | Ora di inizio Compito              |
| auto_use_item    | Usa automaticamente Oggetti Ricompensa| true o false      | false      | No       | Usa le Ricompense automaticamente al completamento |
| remind_time      | Ora promemoria       | timestamp (millisecondi) | 1640995200000 | No | Ora promemoria Compito          |
| pin              | Fissa Compito            | true o false       | false      | No       | Fissa il Compito in alto                |
| words            | Testo Ricompensa al completamento | qualsiasi testo         | Great job! | No       | Testo motivazionale al completamento del Compito |
| frozen           | Stato congelamento       | true o false       | false      | No       | false per impostazione predefinita              |
| freeze_until     | Congela fino a        | timestamp (millisecondi) | 1640995200000 | No | Efficace solo quando frozen è true |
| coin_penalty_factor | Fattore penalità monete| float tra [0, 100) | 0.5    | No       |                               |
| exp_penalty_factor | Fattore penalità esperienza| float tra [0, 100) | 0.5 | No    |                               |
| write_feelings   | Attiva Riflessioni     | true o false       | false      | No       | false per impostazione predefinita              |
| item_id          | ID Oggetto             | number > 0          | 1          | No*      | Richiesto item_id o item_name |
| item_name        | Nome Oggetto           | qualsiasi testo            | Treasure   | No*      | Richiesto item_id o item_name |
| item_amount      | Quantità Oggetto       | [1, 99]             | 1          | No       | 1 per impostazione predefinita                  |
| items            | Ricompense Oggetti        | testo JSON           | Vedi [Struttura Ricompensa Oggetti](#1-item-rewards-structure) | No | Imposta più Ricompense Oggetti |
| task_type        | Tipo Compito           | [0, 4]              | 0          | No       | Richiede v1.99.1<br/>0 - Compito normale<br/>1 - Compito conteggio<br/>2 - Compito negativo<br/>3 - Compito API<br/>4 - Compito a tempo (v1.102.0+) |
| target_times     | Volte target        | number > 0          | 1          | No       | Valido solo quando task_type è 1 (compito conteggio) |
| is_affect_shop_reward | Influenza Ricompensa Negozio | true/false      | false    | No       | Valido solo quando task_type è 1 (compito conteggio); se influisce sul calcolo Ricompensa Oggetti |
| enable_proportional_settlement | Liquidazione proporzionale | true/false | false | No | v1.104.0+; valido solo quando task_type è 1 (compito conteggio). Se attivato, la liquidazione del progresso conteggio assegna Ricompense proporzionalmente e il completamento finale non riassegna quanto già liquidato |
| expected_focus_minutes | Minuti Concentrazione attesi | number > 0 | 25 | No | Valido solo quando task_type è 4 (compito a tempo); 25 per impostazione predefinita (v1.102.0+) |
| repeat_end_mode | Modalità fine ripetizione | 0 o 1 | 0 | No | Valido solo per Compiti ripetitivi (frequency non è 0 / -1)<br/>0 - Termina per conteggio<br/>1 - Termina per data (v1.102.0+) |
| repeat_target_times | Conteggio fine ripetizione | number > 0 | 3 | No | Usato quando repeat_end_mode=0 (o inferito da questo campo); non confondere con target_times (v1.102.0+) |
| repeat_end_date | Data fine ripetizione | timestamp (millisecondi) | 1640995200000 | No | Usato quando repeat_end_mode=1 (o inferito da questo campo) (v1.102.0+) |
| repeat_end_behavior | Comportamento fine ripetizione | 0 o 1 | 0 | No | 0 - Termina Compito al raggiungimento della condizione<br/>1 - Congela Compito al raggiungimento della condizione (v1.102.0+) |

**Risposta:**

| Campo    | Tipo    | Descrizione      | Esempio | Note                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | ID Compito          | 1000    |                          |
| task_gid | Number  | ID gruppo Compiti    | 1000    |                          |

<br/>

#### Complete a Task

**Nome metodo:** complete

**Descrizione:** Attiva il completamento di un Compito. Cerca solo Compiti non completati.

**Esempio:**

- Completa il Compito con id 1: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Completa il Compito con «task group id» 1: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Cerca Compiti per nome e completali: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Spiegazione:**

Ogni Compito ha un id.

Nei Compiti ripetitivi, l'id si rinnova a ogni ripetizione, ma il «task group id» resta invariato.

Per ottenere l'id, attiva «Developer Mode» nella pagina «Labs» e consultalo nella pagina «Task Details».

| Parametro | Significato                         | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | ID Compito                         | numero maggiore di 0 | 1       | no*      | ID Compito; nei Compiti ripetitivi, l'id si aggiorna a ogni ripetizione. |
| gid       | ID gruppo Compiti                   | numero maggiore di 0 | 1       | no*      | ID gruppo Compiti; |
| name      | nome                            | qualsiasi testo              | get up  | no*      | ricerca fuzzy; solo uno dei Compiti trovati |
| ui        | Mostra interfaccia popup | true o false         | true    | no       | false per impostazione predefinita; mostra solo un messaggio in background |
| count                    | Valore conteggio                        | Number                                                 | 1         | No       | Applicabile solo ai compiti conteggio; usare insieme al parametro `count_set_type`     |
| count_set_type           | Come impostare il conteggio         | Uno dei seguenti:<br/>absolute<br/>relative        | absolute  | No       | relative per impostazione predefinita<br/>absolute - Imposta il target direttamente al valore<br/>relative - Aggiunge o sottrae rispetto al valore originale |
| count_force_sum_up       | Forza somma Ricompense compito conteggio  | true o false                                          | true      | No       |                                                                                                    |
| reward_factor            | Fattore Ricompensa                      | Numero decimale maggiore di 0                   | 1.1       | No       | Non applicabile ai compiti conteggio<br/>Il fattore influisce su esperienza e monete (non sulla quantità di Oggetti) |

**Avviso:**

1. Per individuare il Compito, va indicato id, gid o name.
2. I compiti a tempo non possono essere completati manualmente con questa API (v1.102.0+).

<br/>

#### Give up a Task

**Nome metodo:** give_up

**Descrizione:** Attiva l'abbandono di un Compito.

**Esempio:**

- Cerca Compiti per nome e abbandonali: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Spiegazione:**

| Parametro | Significato       | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID Compito       | numero maggiore di 0 | 1       | no*      | ID Compito; nei Compiti ripetitivi, l'id si aggiorna a ogni ripetizione. |
| gid       | ID gruppo Compiti | numero maggiore di 0 | 1       | no*      | ID gruppo Compiti; |
| name      | nome          | qualsiasi testo              | get up  | no*      | ricerca fuzzy; opera su un solo Compito corrispondente |

**Avviso:**

1. Per individuare il Compito, va indicato id, gid o name.

<br/>

#### Freeze a task

**Nome metodo:** freeze

**Descrizione:** Congela un Compito; solo per Compiti ripetitivi.

**Esempio:**

- Cerca Compiti per nome e congelali: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Spiegazione:**

| Parametro | Significato       | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID Compito       | numero maggiore di 0 | 1       | no*      | ID Compito; nei Compiti ripetitivi, l'id si aggiorna a ogni ripetizione. |
| gid       | ID gruppo Compiti | numero maggiore di 0 | 1       | no*      | ID gruppo Compiti; |
| name      | nome          | qualsiasi testo              | get up  | no*      | ricerca fuzzy; opera su un solo Compito corrispondente |
| time      | Congela fino a  | timestamp             | 1661688800682 | no | - |

**Avviso:**

1. Per individuare il Compito, va indicato id, gid o name.

<br/>

#### Unfreeze a task

**Nome metodo:** unfreeze

**Descrizione:** Scongela un Compito.

**Esempio:**

- Cerca Compiti per nome e scongelali: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Spiegazione:**

| Parametro | Significato       | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID Compito       | numero maggiore di 0 | 1       | no*      | ID Compito; nei Compiti ripetitivi, l'id si aggiorna a ogni ripetizione. |
| gid       | ID gruppo Compiti | numero maggiore di 0 | 1       | no*      | ID gruppo Compiti; |
| name      | nome          | qualsiasi testo              | get up  | no*      | ricerca fuzzy; opera su un solo Compito corrispondente |

**Avviso:**

1. Per individuare il Compito, va indicato id, gid o name.

<br/>

#### Delete a task

**Nome metodo:** delete_task

**Descrizione:** Elimina un Compito.

**Esempio:**

- Cerca Compiti per nome ed eliminali: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Spiegazione:**

| Parametro | Significato       | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID Compito       | numero maggiore di 0 | 1       | no*      | ID Compito; nei Compiti ripetitivi, l'id si aggiorna a ogni ripetizione. |
| gid       | ID gruppo Compiti | numero maggiore di 0 | 1       | no*      | ID gruppo Compiti; |
| name      | nome          | qualsiasi testo              | get up  | no*      | ricerca fuzzy; opera su un solo Compito corrispondente |

**Avviso:**

1. Per individuare il Compito, va indicato id, gid o name.

<br/>

### Edit Task

?> Richiede v1.98.0+

**Nome metodo:** edit_task

**Descrizione:** Modifica contenuto e proprietà di un Compito esistente

**Esempio:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parametro           | Significato              | Valori                | Esempio   | Obbligatorio | Note                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | ID Compito              | numero maggiore di 0 | 1        | No*      | Richiesto id, gid o name |
| gid                | ID gruppo Compiti        | numero maggiore di 0 | 1        | No*      | Richiesto id, gid o name |
| name               | Nome Compito            | qualsiasi testo             | Write diary| No*      | Richiesto id, gid o name |
| todo               | Contenuto Compito         | qualsiasi testo             | Write weekly| No      |                                |
| notes              | Note                | qualsiasi testo             | Note content| No      |                                |
| coin               | Ricompensa in monete          | number >= 0         | 10        | No       | Monete al completamento; soggetto ai limiti di sistema    |
| coin_var           | Variazione monete        | numero maggiore di 0 | 1        | No       | Ricompensa casuale tra [coin, coin+coin_var] |
| exp                | Ricompensa Punti Esperienza    | number >= 0          | 20        | No       | Punti Esperienza al completamento; soggetto ai limiti di sistema        |
| skills             | ID Abilità            | array di numeri maggiori di 0 | 1 | No    | Supporta array (es. &skills=1&skills=2) |
| category           | ID elenco              | numero maggiore o uguale a 0 | 0 | No  | 0 per elenco predefinito; elenchi intelligenti non supportati |
| frequency          | Frequenza di ripetizione     | integer              | 0         | No       | 0 per impostazione predefinita (una volta)<br/>0 - Una volta<br/>1 - Giornaliera<br/>N (N>1) - Ogni N giorni<br/>-1 - Illimitata<br/>-3 - Ebbinghaus (richiede v1.99.1)<br/>-4 - Mensile<br/>-5 - Annuale |
| weekdays           | Giorni lavorativi             | `1,3,5` o `none`    | 1,3,5     | No       | v1.106.0+; uguale ad add_task. Omettere per non modificare; `none` ripristina giornaliera; impostare frequency diversa da 1 cancella anche weekdays |
| importance         | Livello importanza     | [1, 4]              | 1         | No       | 1 per impostazione predefinita                   |
| difficulty         | Livello difficoltà     | [1, 4]              | 2         | No       | 1 per impostazione predefinita                   |
| deadline           | Scadenza             | timestamp (millisecondi) | 1640995200000 | No |                               |
| no_deadline        | Nessuna scadenza          | true/false         | true     | No       | v1.104.0+; valido solo per Compiti ripetitivi. Passare `&no_deadline=true` cancella la scadenza specifica |
| remind_time        | Ora promemoria        | timestamp (millisecondi) | 1640995200000 | No |                               |
| start_time         | Ora di inizio           | timestamp (millisecondi) | 1640995200000 | No |                               |
| color              | Colore etichetta            | stringa colore         | #66CCFF   | No       | # va escapato come %23        |
| background_url     | URL immagine di sfondo | indirizzo URL web      | http://example.com/bg.jpg | No |                         |
| background_alpha   | Opacità sfondo   | decimale tra [0, 1] | 0.5 | No   |                                |
| enable_outline     | Contorno testo  | true o false       | false      | No       | Valido solo con background_url; aggiunge contorno al testo per migliorare la leggibilità |
| use_light_remark_text_color | Testo chiaro per le note | true o false | false | No | Valido solo con background_url; usa colore chiaro per le note |
| item_id            | ID Oggetto              | numero maggiore di 0 | 1        | No*      | Richiesto item_id o item_name |
| item_name          | Nome Oggetto            | qualsiasi testo             | Treasure  | No*      | Richiesto item_id o item_name |
| item_amount        | Quantità Oggetto          | [1, 99]             | 1         | No       | 1 per impostazione predefinita                   |
| items              | JSON Ricompense Oggetti    | testo JSON           | [{"itemId":1,"amount":1}] | No | Imposta più Ricompense Oggetti |
| auto_use_item      | Usa Oggetto automaticamente        | true o false        | false     | No       |                                |
| frozen             | Stato congelamento        | true o false        | false     | No       | false per impostazione predefinita              |
| freeze_until       | Congela fino a         | timestamp (millisecondi) | 1640995200000 | No | Efficace solo quando frozen è true |
| coin_penalty_factor| Fattore penalità monete  | decimale tra [0, 100) | 0.5 | No |                                |
| exp_penalty_factor | Fattore penalità esperienza | decimale tra [0, 100) | 0.5 | No |                             |
| write_feelings     | Attiva Riflessioni      | true o false        | false     | No       |                                |
| pin                | Fissa Compito             | true o false        | false     | No       |                                |
| words              | Testo Ricompensa al completamento | qualsiasi testo           | Great job!| No       | Testo motivazionale al completamento del Compito |
| task_type        | Tipo Compito           | [0, 4]              | 0          | No       | Richiede v1.99.1<br/>0 - Compito normale<br/>1 - Compito conteggio<br/>2 - Compito negativo<br/>3 - Compito API<br/>4 - Compito a tempo (v1.102.0+) |
| target_times     | Volte target        | number > 0          | 1          | No       | Valido solo quando task_type è 1 (compito conteggio) |
| is_affect_shop_reward | Influenza Ricompensa Negozio | true/false      | false    | No       | Valido solo quando task_type è 1 (compito conteggio); se influisce sul calcolo Ricompensa Oggetti |
| enable_proportional_settlement | Liquidazione proporzionale | true/false | false | No | v1.104.0+; valido solo quando task_type è 1 (compito conteggio). Nei compiti conteggio esistenti, questo parametro può essere passato da solo per attivare o disattivare la liquidazione proporzionale; modificare questa impostazione o la configurazione Ricompensa può reimpostare o annullare il progresso liquidato secondo le regole dell'App |
| expected_focus_minutes | Minuti Concentrazione attesi | number > 0 | 25 | No | Valido solo quando task_type è 4 (compito a tempo); 25 per impostazione predefinita (v1.102.0+) |
| repeat_target_times | Conteggio fine ripetizione | number > 0 | 3 | No | Valido solo per Compiti ripetitivi (frequency non è 0 / -1); se sono indicati repeat_target_times e repeat_end_date, repeat_target_times ha priorità (v1.102.0+) |
| repeat_end_date | Data fine ripetizione | timestamp (millisecondi) | 1640995200000 | No | Valido solo per Compiti ripetitivi (frequency non è 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Comportamento fine ripetizione | 0 o 1 | 0 | No | 0 - Termina Compito al raggiungimento della condizione<br/>1 - Congela Compito al raggiungimento della condizione (v1.102.0+) |
| coin_set_type     | Come impostare il valore monete | Uno di:<br/>absolute<br/>relative | absolute | No | absolute - imposta coin direttamente al valore<br/>relative - aggiunge o sottrae rispetto al valore originale di coin |
| exp_set_type      | Come impostare il valore exp | Uno di:<br/>absolute<br/>relative | absolute | No | absolute - imposta exp direttamente al valore<br/>relative - aggiunge o sottrae rispetto al valore originale di exp |

**Risposta:**

| Campo     | Tipo    | Descrizione      | Esempio | Note             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | ID Compito          | 1000    |                  |
| task_gid  | Number  | ID gruppo Compiti    | 1000    |                  |

<br/>

### Task Templates

?> Introdotto in v1.102.0+

**Nome metodo:** task_template

**Descrizione:** CRUD per modelli di Compiti.

**Esempi:**

- Elenca modelli: `lifeup://api/task_template?method=list`
- Crea da parametri: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Crea da un Compito esistente: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Ottieni modello: `lifeup://api/task_template?method=get&id=1`
- Aggiorna nome modello: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Aggiorna contenuto modello da un Compito: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Elimina modello: `lifeup://api/task_template?method=delete&id=1`

| Parametro | Significato | Valore | Esempio | Obbligatorio | Note |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Operazione | list / get / create / update / delete | list | Sì | - |
| id | ID modello | number > 0 | 1 | No* | Obbligatorio per get/update/delete; alias: template_id |
| template_id | ID modello | number > 0 | 1 | No* | Alias di id |
| name | Nome modello | text | MyTemplate | No* | Obbligatorio per create; obbligatorio per update se non si usa from_task_id/from_task_gid |
| from_task_id | Crea da ID Compito | number > 0 | 1 | No | Per create/update |
| from_task_gid | Crea da ID gruppo Compiti | number > 0 | 1 | No | Per create/update |
| todo | Contenuto Compito | text | Write diary | No* | Obbligatorio in create se non si usa from_task_id/from_task_gid |
| notes | Note | text | Notes | No | Vuoto per impostazione predefinita |
| category | ID elenco | number >= 0 | 0 | No | Alias: category_id |
| category_id | ID elenco | number >= 0 | 0 | No | Alias di category |
| frequency | Frequenza di ripetizione | integer | 0 | No | Uguale ad add_task |
| weekdays | Giorni lavorativi | `1,3,5` | 1,3,5 | No | v1.106.0+; uguale ad add_task; create rifiuta `none` |
| importance | Livello importanza | [1, 4] | 1 | No | - |
| difficulty | Livello difficoltà | [1, 4] | 1 | No | - |
| coin | Ricompensa in monete | number | 10 | No | - |
| coin_var | Variazione monete | number | 1 | No | - |
| exp | Ricompensa Punti Esperienza | number | 100 | No | - |
| skills | ID Abilità | array params | 1 | No | Supporta array (es. &skills=1&skills=2) |
| skill_ids | ID Abilità | JSON array o elenco separato da virgole | [1,2] | No | Alternativa a skills |
| deadline | Scadenza | timestamp (millisecondi) | 1640995200000 | No | - |
| start_time | Ora di inizio | timestamp (millisecondi) | 1640995200000 | No | - |
| remind_time | Ora promemoria | timestamp (millisecondi) | 1640995200000 | No | - |
| words | Testo Ricompensa al completamento | text | Great job! | No | - |
| task_type | Tipo Compito | [0, 4] | 0 | No | 0 - Normale<br/>1 - Conteggio<br/>2 - Negativo<br/>3 - API<br/>4 - A tempo |
| target_times | Volte target | number > 0 | 10 | No | Valido solo quando task_type è 1 (compito conteggio) |
| is_affect_shop_reward | Influenza Ricompensa Negozio | true / false | false | No | Valido solo quando task_type è 1 (compito conteggio) |
| enable_proportional_settlement | Liquidazione proporzionale | true / false | false | No | v1.104.0+; valido solo quando task_type è 1 (compito conteggio). I Compiti creati dal modello mantengono questa impostazione di liquidazione conteggio |
| expected_focus_minutes | Minuti Concentrazione attesi | number > 0 | 25 | No | Valido solo quando task_type è 4 (compito a tempo) |
| repeat_end_mode | Modalità fine ripetizione | 0 o 1 | 0 | No | Valido solo per Compiti ripetitivi (frequency non è 0 / -1)<br/>0 - Termina per conteggio<br/>1 - Termina per data |
| repeat_target_times | Conteggio fine ripetizione | number > 0 | 3 | No | Usato quando repeat_end_mode=0 (o inferito da questo campo) |
| repeat_end_date | Data fine ripetizione | timestamp (millisecondi) | 1640995200000 | No | Usato quando repeat_end_mode=1 (o inferito da questo campo) |
| repeat_end_behavior | Comportamento fine ripetizione | 0 o 1 | 0 | No | 0 - Termina<br/>1 - Congela |

**Ritorno:**

| Campo | Significato | Tipo | Note |
| ----- | ------- | ---- | ----- |
| templates | elenco modelli (stringa JSON) | text | Solo per method=list |
| count | conteggio modelli | number | Solo per method=list |
| template | dettaglio modello (stringa JSON) | text | Solo per method=get |
| id | ID modello | number | Per get/create/update/delete |
| name | nome modello | text | Per get/create/update |
| success | esito positivo | true / false | Per create/update/delete |

<br/>

### History Task Operation

?> Richiede v1.98.0+

**Nome metodo:** history_operation

**Descrizione:** Opera su Compiti completati, abbandonati o scaduti

**Esempi:**

- Elimina Compito dalla cronologia: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Segna Compito come abbandonato: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Riavvia Compito: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Questa API si applica solo a Compiti non in sospeso (completati, abbandonati o scaduti)

| Parametro      | Significato           | Valori               | Esempio    | Obbligatorio | Note                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | ID Compito           | numero maggiore di 0 | 1         | Sì      | ID del Compito nella cronologia          |
| operation     | Tipo operazione    | Uno di:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Sì | delete - Elimina Compito<br/>complete - Segna come completato<br/>undo_complete - Annulla completamento<br/>set_to_give_up - Segna come abbandonato<br/>set_to_overdue - Segna come scaduto<br/>edit_completed_time - Modifica ora completamento<br/>restart - Riavvia Compito |
| completed_time | Ora completamento   | timestamp (millisecondi) | 1640995200000 | No* | Obbligatorio solo quando operation è edit_completed_time |

**Risposta:**

| Campo    | Tipo    | Descrizione    | Esempio | Note                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | ID Compito        | 1000    | ID del Compito operato  |

<br/>

### Shop Settings

**Nome metodo:** shop_settings

**Istruzioni:** Regola vari parametri del Negozio

**Esempio:**

- Imposta il tasso di interesse ATM al 0,01%: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Aumenta il tasso di interesse dello 0,01% a ogni clic: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parametro | Significato              | Tipo | Esempio | Obbligatorio | Note |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | tipo                 | Attualmente supporta solo:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | sì | atm_interest - tasso giornaliero ATM<br/>credit_interest - tasso giornaliero prestito<br/>line_of_credit - importo prestabile<br/>discount_rate_for_returning - scala sconto reso<br/>atm_balance - imposta saldo ATM |
| value     | valore numerico        | numero decimale o intero | 0.01 | sì | ogni key ammette intervalli diversi<br/>Ad esempio, i saldi ATM non supportano decimali |
| set_type  | Come impostare il valore | Uno dei seguenti:<br/>absolute<br/>relative | absolute | no | absolute - valore assoluto, cioè imposta il target direttamente al valore<br/>relative - valore relativo, aggiunge o sottrae rispetto al valore originale |
| silent    | Esegui in silenzio (senza mostrare interfaccia) | Boolean | false | No | Supportato da v1.93.0-beta01 (502) e versioni successive<br/>false per impostazione predefinita, mostra avvisi interfaccia |

<br/>
### Jump

**Nome metodo:** goto

**Descrizione:** Salta a una pagina in `LifeUp`

**Esempio:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Spiegazione:** Salta alla pagina Laboratori

| Parametro | Significato | Valore | Esempio | Obbligatorio | Note |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | pagina | Uno dei seguenti valori:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | sì | `purchase_dialog` si riferisce al popup di acquisto<br/> `use_item_dialog` si riferisce al popup di uso Oggetto<br/>Le altre voci corrispondono a pagine principali specifiche |

#### 1. Salta alla finestra popup di acquisto/uso Oggetto

Quando il parametro `page` è impostato su `purchase_dialog` o `use_item_dialog`, puoi specificare l'ID dell'Oggetto:

Ad esempio: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parametro | Significato | Valore            | Esempio | Obbligatorio | Note   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | ID Oggetto | Intero positivo | 1       | Sì      | ID Oggetto |

<br/>

#### 2. Salta alla sottopagina della home

Quando il parametro `page` è `main`, puoi specificare inoltre la sottopagina di destinazione:

Ad esempio, salta alla pagina del Negozio: `lifeup://api/goto?page=main&sub_page=shop`

| Parametro   | Significato       | Valore | Esempio | Obbligatorio | Note  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | nome sottopagina | Uno di:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | no       |      |
| category_id | id elenco       | number | 0      | no       | Se `sub_page` è una pagina elenco, puoi indicare l'id dell'elenco a cui saltare. <br/>Ad esempio, elenco Oggetti del Negozio, elenco Inventario, elenco Compiti. |

<br/>

#### 3. Salta ai dettagli del Compito

Quando il parametro `page` è `task_detail`, puoi specificare inoltre l'id del Compito a cui saltare:

Ad esempio, salta alla pagina dei dettagli del Compito con id 53: `lifeup://api/goto?page=task_detail&task_id=53`

| Parametro | Significato       | Valore         | Esempio      | Obbligatorio | Note |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | id Compito       | id Compito       | 53           | No*      | id Compito; se è un Compito ripetitivo, l'id viene aggiornato a ogni ripetizione. |
| task_gid  | id gruppo Compiti | id gruppo Compiti | 3            | No*      | id gruppo Compiti |
| task_name | nome Compito     | string        | get up early | No*      | nome Compito; corrispondenza fuzzy di una sola voce. |

**Avviso:**

1. Basta fornire uno solo dei tre parametri.
    - Se se ne forniscono più di uno contemporaneamente, esiste un ordine di priorità interno. Questo è comportamento indefinito; l'App non garantisce l'ordine.

<br/>

#### 4. Salta alla pagina nuovo Obiettivo

Quando il parametro `page` è `add_achievement`, **devi** specificare inoltre l'id categoria:

Ad esempio, salta alla pagina nuovo Obiettivo con id categoria 1: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parametro    | Significato         | Valore         | Esempio | Obbligatorio | Note  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id categoria Obiettivo | id categoria Obiettivo | 1       | Sì      |        |

#### 5. Salta alla pagina categoria Obiettivo specifica

Quando il parametro `page` è `user_achievement`, **devi** specificare inoltre l'id categoria:

Ad esempio, salta alla pagina categoria Obiettivo con id 1: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parametro    | Significato         | Valore         | Esempio | Obbligatorio | Note  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id categoria Obiettivo | id categoria Obiettivo | 1       | Sì      |        |

#### 6. Salta alla pagina categoria Sintesi specifica

Quando il parametro `page` è `synthesis`, puoi specificare facoltativamente l'id categoria:

Ad esempio, salta alla pagina categoria Sintesi con id 1: `lifeup://api/goto?page=synthesis&category_id=1`

| Parametro    | Significato         | Valore         | Esempio | Obbligatorio | Note  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | id categoria Sintesi | id categoria Sintesi | 1       | No       |        |

Puoi anche aprire la pagina Sintesi con un filtro (v1.102.0+):

Ad esempio, filtra per id Oggetto prodotto 1: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parametro        | Significato           | Valore | Esempio | Obbligatorio | Note |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Tipo filtro       | product / ingredient / related | product | No* | Richiede filter_item_id |
| filter_item_id  | id Oggetto filtro    | number > 0 | 1 | No* | Richiede filter_type |
| filter_item_name| Nome Oggetto filtro  | text | Gem | No | Facoltativo; usato per la visualizzazione |

### Shop

#### Aggiungere Oggetti

?> Alcuni campi come `effects` richiedono v1.98.0+

**Nome metodo:** add_item

**Descrizione:** Crea un Oggetto del Negozio con proprietà personalizzabili, inclusi limiti di acquisto ed effetti d'uso.

**Esempio:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parametro        | Significato                | Valori               | Esempio       | Obbligatorio | Note                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Nome Oggetto             | any text             | 10 minute break | Sì    |                                 |
| desc            | Descrizione           | any text             | Take a break  | No       |                                 |
| icon            | Icona                  | emoji, http(s) URL, or built-in sample name | ☕ | No | Salvato come `emoji_*.webp`, `lifeup_sample_*` o URL. Un emoji nel nome non imposta l'icona. |
| price           | Prezzo                 | [0, 999999]         | 10            | No       | Predefinito 0                    |
| stock_number    | Quantità in stock        | [-1, 99999]         | -1            | No       | -1 significa illimitato              |
| action_text     | Testo pulsante azione    | any text             | rest          | No       |                                 |
| disable_purchase| Disabilita acquisto      | true or false        | false         | No       | Predefinito false                |
| disable_use     | Disabilita uso           | true or false        | false         | No       | Predefinito false                |
| category        | ID categoria           | number greater than or equal to 0 | 0 | No    | 0 per categoria predefinita          |
| order           | Ordine di visualizzazione         | integer              | 1             | No       | Posizione nella categoria            |
| purchase_limit  | Regole di restrizione     | JSON text            | Vedi [Struttura limite di acquisto](#3-purchase-limit-structure) | No | Restrizioni acquisto/uso configurabili |
| limit_scope     | Ambito restrizione     | purchase / use / both | purchase | No | Efficace solo quando `purchase_limit` non è vuoto; predefinito `purchase` |
| effects         | Effetti d'uso           | JSON text            | Vedi [Struttura effetto Oggetto](#4-item-effects-structure) | No | Effetti di utilizzo Oggetto |
| own_number      | Quantità posseduta iniziale | integer             | 0             | No       | Imposta la quantità iniziale nell'Inventario  |
| unlist          | Nascondi dal Negozio        | true or false        | false         | No       | Predefinito false                |

**Dati di ritorno:**

| Campo    | Tipo    | Descrizione    | Esempio | Note                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | ID Oggetto        | 1000    | ID dell'Oggetto creato   |

!> Il parametro effects sovrascrive disable_use. Se imposti effects per indicare un Oggetto non utilizzabile, disable_use viene ignorato.

<br/>

#### Modifica Oggetto

?> Richiede v1.98.0+

**Nome metodo:** item

**Descrizione:** Modifica Oggetti esistenti, inclusi prezzo, scorte, effetti e altre proprietà

**Esempi:**

- Regola prezzo: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Modifica effetti: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - Il contenuto decodificato del parametro effects è: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parametro         | Significato             | Valori               | Esempio   | Obbligatorio | Note                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | ID Oggetto             | number greater than 0| 1         | No*      | Obbligatorio id o name      |
| name             | Nome Oggetto           | any text             | Treasure  | No*      | Per ricerca fuzzy, non per rinominare  |
| set_name         | Imposta nome            | any text             | Treasure  | No       | Non può essere vuoto                 |
| set_desc         | Imposta descrizione     | any text             | Get gift  | No       |                                |
| set_icon         | Imposta icona            | emoji, http(s) URL, or built-in sample name | ☕ | No | Come `icon`. Valori non supportati restituiscono `unsupported_parameter`. |
| set_price        | Regola prezzo        | integer              | 1         | No       |                                |
| set_price_type   | Metodo regolazione prezzo | absolute or relative | relative  | No       | absolute-imposta direttamente<br/>relative-aggiunge/sottrae |
| own_number       | Regola quantità posseduta| integer             | 1         | No       | Supporta valori negativi con relative |
| own_number_type  | Regolazione quantità posseduta| absolute or relative| relative  | No       | absolute-imposta direttamente<br/>relative-aggiunge/sottrae |
| stock_number     | Regola scorte        | [-1, 99999]         | 1         | No       | -1 significa scorte illimitate        |
| stock_number_type| Metodo regolazione scorte | absolute or relative | relative  | No       | absolute-imposta direttamente<br/>relative-aggiunge/sottrae |
| disable_purchase | Disabilita acquisto    | true or false        | false     | No       | Predefinito false              |
| disable_use      | Disabilita uso         | true or false        | false     | No       | Predefinito false              |
| action_text      | Testo pulsante uso     | any text             | Use       | No       |                                |
| title_color_string| Colore titolo        | color string         | #66CCFF   | No       | # deve essere escapato come %23<br/>Valore vuoto ripristina il predefinito |
| effects          | Effetti d'uso         | JSON text            | Vedi [Struttura effetto Oggetto](#4-item-effects-structure) | No | Imposta effetti di utilizzo Oggetto |
| purchase_limit   | Regole di restrizione   | JSON text            | Vedi [Struttura limite di acquisto](#3-purchase-limit-structure) | No | Passa `null` per cancellare tutte le restrizioni |
| limit_scope      | Ambito restrizione   | purchase / use / both | purchase | No | Si aggiorna solo quando questo campo è fornito; cancellato automaticamente quando `purchase_limit` diventa vuoto |
| category_id      | ID categoria         | number >= 0          | 1         | No       | 0 per categoria predefinita         |
| order            | Ordine di visualizzazione       | integer              | 1         | No       | Posizione nella categoria           |
| unlist           | Rimuovi dal Negozio    | true or false        | false     | No       | Predefinito false              |

!> Deve essere fornito il parametro id o name per individuare l'Oggetto da modificare

<br/>

#### Regolare l'effetto Bottino

**Nome metodo:** loot_box

**Descrizione:** Modifica l'effetto Bottino dell'Oggetto scatola specificato; supporta la regolazione di probabilità, numero di Ricompense e aggiunta di contenuti. (L'eliminazione non è supportata per ora)

**Esempio:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Spiegazione:** Aumenta di 1 punto la proporzione del [grande] sacchetto di monete d'oro nella scatola di monete.

| Parametro   | Significato                               | Tipo                                                    | Esempio        | Obbligatorio | Note                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | id Oggetto                               | a number greater than 0                                 | 1              | no*      | Per sapere come ottenerlo, consulta «Basics - LifeUp Data ID» più sopra |
| name        | nome Oggetto                             | any text                                                | Treasure chest | no*      | Se l'id è sconosciuto, ricerca fuzzy del prodotto, non modifica del nome |
| sub_id      | id Oggetto contenuto                       | a number greater than 0                                 | 1              | no*      | id del contenuto della scatola                                         |
| sub_name    | nome Oggetto contenuto                     | any text                                                | Get a gift     | no*      | Ricerca fuzzy Oggetti quando l'id del contenuto della scatola è sconosciuto |
| set_type    | metodo di regolazione (absolute/relative) | one of the following values: <br/>absolute<br/>relative | relative       | no       | absolute - valore assoluto, cioè imposta direttamente il valore target<br/>relative - valori relativi, aggiunge o sottrae rispetto al valore originale |
| amount      | numero di Oggetti contenuto                | number                                                  | 1              | no       | numero di Ricompense per un singolo Oggetto                          |
| probability | probabilità dell'Oggetto contenuto       | number                                                  | 1              | no       | -                                                            |
| fixed       | se è una Ricompensa fissa          | boolean                                                 | true/false     | no       | -                                                            |

**Avviso:**

1. Per cercare un prodotto, devi fornire id o name.
1. Per cercare un contenuto, devi fornire sub_id o sub_name.
1. `name` e `sub_name` provano prima la corrispondenza esatta, poi quella fuzzy.
1. L'API legacy `loot_box` mantiene il comportamento di compatibilità: se lo stesso Oggetto contenuto compare più volte con quantità diverse, modifica la prima voce corrispondente e non usa `sub_amount` per disambiguare. Usa `loot_box/v2` quando servono modifica, eliminazione o merge specifici per quantità.

<br/>

#### Regolare l'effetto Bottino (v2)

?> Questa API è stata introdotta nella versione v1.104.2.

**Nome metodo:** loot_box/v2

**Descrizione:** Versione migliorata dell'API loot_box. Modifica l'effetto Bottino dell'Oggetto scatola specificato; supporta la regolazione di probabilità, numero di Ricompense, aggiunta di contenuti e **eliminazione di contenuti**.

**Miglioramenti rispetto a v1:**
- **`sub_amount` per corrispondenza precisa**: Quando la scatola contiene più voci dello stesso Oggetto con quantità diverse (es. A x1 50%, A x2 30%), usa `sub_amount` per puntare a una voce specifica. Valore predefinito `1`. Se non si trova una voce corrispondente, LifeUp cerca l'Oggetto tramite `sub_id` / `sub_name` e aggiunge una nuova voce; se la richiesta è un'eliminazione con `amount=0`, non viene aggiunta alcuna voce.
- **`set_type` indipendente**: `amount_set_type` e `probability_set_type` possono essere controllati in modo indipendente. Il `set_type` globale funge da predefinito di fallback.
- **Supporto eliminazione**: Impostare `amount=0` con `amount_set_type=absolute` (o calcolando `<=0` con `relative`) elimina la voce corrispondente.
- **Merge duplicati**: Se cambiare `amount` duplicherebbe una voce esistente con lo stesso Oggetto e la stessa quantità nella stessa scatola, LifeUp unisce alla voce esistente e continua ad applicare i valori `probability` / `fixed` della richiesta.

**Esempio:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Spiegazione:** Aumenta di 10 punti la probabilità del [grande] sacchetto di monete d'oro (x2) nella scatola di monete.

| Parametro              | Significato                               | Tipo                                                    | Esempio        | Obbligatorio | Note                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | id Oggetto                               | a number greater than 0                                 | 1              | no*      | Per sapere come ottenerlo, consulta «Basics - LifeUp Data ID» più sopra |
| name                   | nome Oggetto                             | any text                                                | Treasure chest | no*      | Se l'id è sconosciuto, ricerca fuzzy del prodotto, non modifica del nome |
| sub_id                 | id Oggetto contenuto                       | a number greater than 0                                 | 1              | no*      | id del contenuto della scatola. Se sono forniti sia sub_id sia sub_name, sub_id ha la precedenza |
| sub_name               | nome Oggetto contenuto                     | any text                                                | Get a gift     | no*      | Ricerca fuzzy Oggetti quando l'id del contenuto della scatola è sconosciuto |
| sub_amount             | quantità Oggetto contenuto per corrispondenza      | number                                                  | 2              | no       | Usato per corrispondere con precisione a una voce con questa quantità. Minimo `1`, predefinito `1`. Se non si trova corrispondenza e non è una richiesta di eliminazione, viene aggiunta una nuova voce. |
| set_type               | metodo di regolazione globale              | one of: `absolute` / `relative`                         | relative       | no       | Predefinito per `amount_set_type` e `probability_set_type` se non specificati |
| amount_set_type        | metodo di regolazione per amount          | one of: `absolute` / `relative`                         | relative       | no       | Sovrascrive `set_type` per il campo amount                    |
| probability_set_type   | metodo di regolazione per probability     | one of: `absolute` / `relative`                         | absolute       | no       | Sovrascrive `set_type` per il campo probability               |
| amount                 | numero di Oggetti contenuto                | number                                                  | 1              | no       | numero di Ricompense per un singolo Oggetto. `0` (absolute) o calcolato `<=0` (relative) elimina la voce |
| probability            | probabilità dell'Oggetto contenuto       | number                                                  | 1              | no       | -                                                            |
| fixed                  | se è una Ricompensa fissa          | boolean                                                 | true/false     | no       | -                                                            |
| query                  | elenca contenuti scatola                     | true or false                                           | true           | no       | v1.105.1+. Restituisce solo JSON Oggetto; sub_id / sub_name non obbligatori |

**Avviso:**

1. Per cercare un prodotto, devi fornire id o name.
1. Per cercare un contenuto, devi fornire sub_id o sub_name. Usa `query=true` per elencare i contenuti senza sub_id / sub_name.
1. Se sono forniti sia `sub_id` sia `sub_name`, `sub_id` ha la precedenza. `sub_name` viene usato solo quando non è fornito un `sub_id` valido.
1. `name` e `sub_name` provano prima la corrispondenza esatta, poi quella fuzzy.
1. `sub_amount` ha predefinito `1`. Quando la scatola ha più voci dello stesso Oggetto con quantità diverse, fornisci `sub_amount` per puntare a una voce specifica. Se non si trova corrispondenza e non è una richiesta di eliminazione, viene aggiunta una nuova voce con `amount=sub_amount`.
1. Per eliminare una voce, imposta `amount=0` con `amount_set_type=absolute`, oppure usa `amount_set_type=relative` con un valore negativo che porti il totale a `<=0`. L'eliminazione si applica solo alle voci corrispondenti; se non c'è una voce esistente corrispondente, `amount=0` non aggiunge una nuova voce.
1. Se cambiare la `amount` di una voce duplicherebbe una voce esistente con lo stesso Oggetto e la stessa quantità nella stessa scatola, LifeUp unisce alla voce esistente e continua ad applicare i valori `probability` / `fixed` della richiesta.
1. Quando l'eliminazione lascia la scatola vuota, l'intero effetto Bottino viene soft-deleted (l'Oggetto stesso è preservato e puoi aggiungere di nuovo voci Bottino in seguito).

<br/>

#### Usare Oggetti

?> Questa API è stata introdotta nella versione v1.93.0-beta01 (502).

**Nome metodo:** use_item

**Descrizione:** Usa un Oggetto specificato.

**Esempio:**

- Apri una scatola di monete: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parametro | Significato     | Tipo                    | Esempio  | Obbligatorio | Note                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | ID Oggetto     | a number greater than 0 | 1        | No*      | Per ottenere l'ID Oggetto, consulta la sezione «Basics - LifeUp Data ID» |
| name      | Nome Oggetto   | Any text                | coin_box | No*      | Per ID sconosciuti; esegue una ricerca fuzzy degli Oggetti      |
| use_times | Volte di utilizzo | a number greater than 0 | 1        | No       | Predefinito 1 volta<br/>Per Oggetti normali o apertura scatole, corrisponde alla quantità dell'Oggetto<br/>Per Oggetti di Sintesi semplice, questo valore corrisponde alla «quantità di sintesi» e non al numero di Oggetti consumati |

**Ritorno:**

!> Questa API può fallire per vari motivi; i motivi specifici del fallimento possono essere forniti nei valori di ritorno.

| Parametro | Significato            | Tipo     | Esempio          | Obbligatorio | Note                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Codice risultato        | a number | 0                | Sì      | 0 - Utilizzo riuscito<br/>1 - Eccezione database<br/>2 - Restrizione Punti Esperienza insufficienti<br/>3 - Oggetto non trovato<br/>4 - Conflitto conto alla rovescia in esecuzione<br/>5 - Inventario insufficiente<br/>6 - Oggetto non utilizzabile<br/>7 - Limite monete<br/>8 - Limite scorte target<br/>9 - Restrizione livello Attributo<br/>10 - Restrizione oraria<br/>11 - Restrizione quantità Oggetti posseduti<br/>12 - Restrizione completamento Compito<br/>13 - Restrizione sblocco Obiettivo<br/>14 - Restrizione quantità periodo<br/>15 - Restrizione ciclo Compito completato |
| desc      | Descrizione risultato | Text     | RunningCountDown | Sì      |                                                              |

<br/>

### ATM

**⚠ Disponibile solo da v1.91+**

> Le operazioni di deposito e prelievo qui verranno verificate.
>
> Se devi regolare direttamente il saldo ATM, consulta l'interfaccia «Shop Settings» più sopra.

#### Deposito

**Nome metodo:** deposit

**Descrizione:** Il deposito verrà controllato per legittimità (se il saldo monete è sufficiente).

**Esempio:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Spiegazione:** Deposita 500 monete.

| Parametro | Significato        | Tipo                    | Esempio | Obbligatorio | Note |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | importo deposito | a number greater than 0 | 100     | sì      | -     |

**Ritorno:**

| Parametro | Significato                              | Tipo              | Esempio | Obbligatorio | Note |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Se l'operazione è riuscita | `true` or `false` | true    | sì      | -     |

<br/>

#### Prelievo

**Nome metodo:** withdraw

**Descrizione:** I prelievi verranno controllati per legittimità (se il saldo ATM è sufficiente).

**Esempio:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Spiegazione:** Preleva 500 monete.

| Parametro | Significato           | Tipo                    | Esempio | Obbligatorio | Note |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | importo prelievo | a number greater than 0 | 100     | sì      | -     |

**Ritorno:**

| Parametro | Significato                              | Tipo              | Esempio | Obbligatorio | Note |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Se l'operazione è riuscita | `true` or `false` | true    | sì      | -     |

<br/>

### Pomodoro Timer

**Nome metodo:** pomodoro_timer

**Descrizione:** Controlla il conto alla rovescia o il cronometro ascendente Pomodoro reale in LifeUp. Questa API avvia
la stessa sessione timer dell'interfaccia dell'App; non aggiunge direttamente registri Pomodoro o pomodori.

**Esempi:**

- Avvia o riprendi il conto alla rovescia di lavoro predefinito:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Avvia il cronometro ascendente e seleziona il Compito 101:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Metti in pausa il conto alla rovescia attivo:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Abbandona e reimposta il ciclo di vita Pomodoro:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Salta la fase Pomodoro corrente:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Liquida un cronometro ascendente senza ricevere Ricompense pomodoro:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Interroga entrambe le modalità timer:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parametri:**

| Parametro | Significato | Tipo / valori | Obbligatorio | Note |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operazione | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | sì | - |
| mode | Modalità timer | `countdown`, `count_up` | per `start`, `pause`, `abandon` e `complete` | `skip` punta sempre al conto alla rovescia. |
| stage | Fase conto alla rovescia | `work`, `short_break`, `long_break` | no | Valido solo con `mode=countdown`. Se omesso, viene usata la fase canonica attiva, in pausa o successiva per fasi; un nuovo ciclo di vita inizia con `work`. |
| receive_reward | Se ricevere Ricompense pomodoro | `true` or `false` | per `complete` | Booleano rigoroso. `complete` supporta solo `mode=count_up`. |
| task_id | ID Compito | positive integer | no | Non può essere combinato con `task_gid` o `task_name`. |
| task_gid | ID gruppo Compiti | positive integer | no | Può essere combinato con `task_name` per restringere la corrispondenza. |
| task_name | Nome Compito | text | no | Si preferisce la corrispondenza esatta, con fallback fuzzy. |
| clear_task | Cancella il Compito del timer | `true` or `false` | no | `true` non può essere combinato con un localizzatore Compito. |

`select_task` richiede un localizzatore Compito o `clear_task=true`. `start` può includere gli stessi
parametri di selezione Compito. I parametri di durata personalizzata non sono supportati: i conti alla rovescia usano
la durata predefinita corrente o la durata Pomodoro del Compito selezionato.

`abandon&mode=countdown` equivale all'azione sinistra dell'App: abbandona la fase corrente,
reimposta il ciclo di vita Pomodoro e torna a una fase di lavoro fermata. `skip` equivale all'
azione destra: avanza da lavoro a pausa breve/lunga, o da pausa a lavoro, senza avviare automaticamente
la fase successiva. Ogni chiamata a `skip` è un'azione reale non idempotente; i chiamanti non devono riprovare
automaticamente.

`complete&mode=count_up` liquida la sessione ascendente reale. Le sessioni più brevi di 30 secondi vengono
consumate senza creare un registro. Con `receive_reward=false`, un registro che raggiunge la soglia
viene comunque salvato come abbandonato ma non assegna pomodori.

**Regole di cambio Compito:**

- Un conto alla rovescia di lavoro in esecuzione rifiuta i cambi di Compito.
- Un cronometro ascendente in esecuzione consente i cambi di Compito e aggiorna la sua notifica.
- Un conto alla rovescia in pausa consente i cambi di Compito e conserva il tempo trascorso mentre ricalcola la durata totale
  dalle impostazioni del nuovo Compito.

**Valori di ritorno in caso di successo:**

| Parametro | Significato | Tipo |
| --------- | ------- | ---- |
| api_result | Se la chiamata API è riuscita | boolean |
| applied | Se questa chiamata ha modificato lo stato del timer | boolean |
| mode | Modalità timer target o attualmente selezionata | `countdown` or `count_up` |
| state | Stato di `mode` | `running`, `paused`, or `stopped` |
| selected_task_id | ID Compito timer corrente, o `0` | number |
| can_start_in_background | Se Android consente attualmente l'avvio del timer in background | boolean |
| countdown_state | Stato canonico conto alla rovescia | `running`, `paused`, or `stopped` |
| countdown_phase | Fase ciclo di vita conto alla rovescia | `idle`, `running`, `paused`, `completing`, `completed`, or `cancelled` |
| countdown_stage | Fase canonica conto alla rovescia | `work`, `short_break`, or `long_break` |
| countdown_session_id | ID sessione canonica conto alla rovescia | text or null |
| countdown_total_millis | Durata totale conto alla rovescia | milliseconds |
| countdown_remaining_millis | Durata rimanente conto alla rovescia | milliseconds |
| count_up_state | Stato canonico cronometro ascendente | `running`, `paused`, or `stopped` |
| count_up_elapsed_millis | Durata trascorsa cronometro ascendente | milliseconds |
| battery_optimization_ignored | Se LifeUp è esente dall'ottimizzazione batteria | boolean |

Le risposte `complete` riuscite contengono inoltre `record_created`, `reward_tomatoes` e
`settled_elapsed_millis`.

Chiamate ripetute a `start`, `pause` o `abandon` che corrispondono già allo stato richiesto riescono con
`applied=false`. Le chiamate mutanti non forniscono deduplicazione dei retry cross-process.

**Errori:**

I fallimenti restituiscono `api_result=false`, `error_code` e `error_message`. I codici errore stabili specifici del timer sono:

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

Su Android 12 e versioni successive, una chiamata ContentProvider in background può avviare un timer solo quando a LifeUp è
consentito ignorare l'ottimizzazione batteria. Altrimenti restituisce `background_start_not_allowed`
prima di modificare lo stato del timer. Aprire lo URL Scheme tramite la sua Activity porta LifeUp in
primo piano prima dell'avvio. Android può impedire a un'app di terze parti di avviare quell'Activity dal
background; in tal caso LifeUp non riceve alcuna chiamata API e non può restituire un errore.

<br/>

### Pomodoro Record

#### Aggiungere registro Pomodoro

**Nome metodo:** add_pomodoro

**Descrizione:** Aggiunge un registro di cronometraggio pomodoro

**Esempio:**

- Aggiungi un registro con durata di 25 minuti (1500000 ms) collegato a un Compito il cui nome contiene learning: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Aggiungi registro per `2022-08-01 11:00:00` - `2022-08-01 12:00:00`: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Spiegazione:**

| Parametro        | Significato                    | Tipo                    | Esempio       | Obbligatorio | Note |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | ora inizio cronometraggio          | timestamp               | 1659322800000 | no*      | Se non sai cos'è un Timestamp, cerca su Google! |
| duration         | durata Concentrazione             | number (in milliseconds) <br/>must be greater than 30000 | 1500000 | no* | |
| end_time         | ora fine cronometraggio            | timestamp               | 1659326400000 | no*      |       |
| reward_tomatoes  | se assegnare pomodori | true or false           | true          | no       | predefinito false |
| task_id          | id Compito                    | a number greater than 0 | 1             | no       |       |
| task_gid         | id gruppo Compiti              | a number greater than 0 | 1             | no       |       |
| task_name        | nome                       | any text                | learning      | no       | ricerca fuzzy; solo uno dei Compiti trovati |
| ui               | Mostra UI pomodori assegnati | true or false         | true          | no       | Introdotto in v1.94.0, predefinito true |

**Avviso:**

1. Deve essere fornito uno tra start_time, duration, end_time.
2. Se viene fornito solo duration, end_time predefinito è l'ora corrente.
3. end_time deve essere maggiore di start_time.
4. duration è almeno 30000 millisecondi (30 secondi).
5. Se sono forniti start_time, duration ed end_time, duration deve essere minore o uguale a (end_time - start_time).

<br/>

#### Modifica registro Pomodoro

> Introdotto in v1.94.0
> **Nome metodo:** edit_pomodoro

**Descrizione:** Modifica un registro di cronometraggio Pomodoro esistente o aggiunge un nuovo registro se viene fornito un `edit_item_id` valido.

**Esempio:**

- Modifica un registro con ID specificato, imposta la durata a 45 minuti (2700000 ms) e assegna pomodori: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Modifica un registro per ora di inizio e fine: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parametri:**

| Parametro       | Significato                    | Tipo                  | Esempio       | Obbligatorio | Note                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | ID Compito                    | Number greater than 0 | 101           | No       | Identificatore univoco del Compito                   |
| task_gid        | ID gruppo Compiti              | Number greater than 0 | 5             | No       | Se fornito, sovrascrive task_id                |
| task_name       | Nome Compito                  | Any text              | Study         | No       | Obbligatorio se task_id o task_gid non sono forniti   |
| start_time      | Ora inizio cronometraggio          | Timestamp             | 1659322800000 | No*      | Puoi cercare su Google cos'è un timestamp     |
| end_time        | Ora fine cronometraggio            | Timestamp             | 1659326400000 | No*      | -                                                |
| duration        | Durata Concentrazione             | Number (milliseconds) | 2700000       | No*      | Deve essere almeno 30000 millisecondi (30 secondi) |
| reward_tomatoes | Se assegnare pomodori | true or false         | true          | No       | Predefinito false                                 |
| edit_item_id    | ID della voce da modificare     | Number greater than 0 | 123           | Sì      | Specifica l'ID del registro da modificare                  |
| ui              | Mostra UI Ricompense pomodoro | true or false         | true          | No       |                                                  |
| delete          | Elimina il registro          | true or false         | true          | No       | v1.105.1+. Soft-delete del registro pomodoro (`isDel`), come nell'App |

**Valori di ritorno:**

| Parametro | Significato                          | Tipo   | Esempio | Obbligatorio | Note                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Pomodori ottenuti da questa azione | Number | 2       | No       | Restituito se `ui` è true |

**Note:**

1. Almeno uno tra `start_time`, `duration`, `end_time` deve essere fornito.
2. `end_time` deve essere maggiore di `start_time`.
3. `duration` deve essere minore o uguale a (`end_time` - `start_time`).
4. Se `edit_item_id` è fornito e il registro corrispondente viene trovato, verrà modificato; altrimenti verrà creato un nuovo registro in base agli altri parametri.

<br/>

### Condizioni di sblocco Obiettivo

**Nome metodo:** unlock_condition

**Descrizione:** Condizione di sblocco Obiettivo: richiede una chiamata API esterna per lo sblocco

**Esempio:**

- Invoca la condizione di sblocco con id 2: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parametro | Significato      | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ---------------- | --------------------- | ------- | -------- |------ |
| id        | id condizione | number greater than 0 | 2       | sì      |       |

<br/>

### Completa / reclama Obiettivo

?> Questa API è stata introdotta in v1.105.1.

**Nome metodo:** complete_achievement

**Descrizione:** Completa un Obiettivo manuale e reclama la sua Ricompensa, oppure reclama la Ricompensa di un Obiettivo automatico già sbloccato. Stesso comportamento del tocco sulla casella di completamento / pulsante reclama Ricompensa nell'App.

**Esempio:**

- Completa o reclama l'Obiettivo con id 1: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parametro | Significato        | Tipo                  | Esempio | Obbligatorio | Note |
| --------- | ------------------ | --------------------- | ------- | -------- | ----- |
| id        | id Obiettivo | number greater than 0 | 1       | sì      |       |

**Valori di ritorno:**

| Campo  | Tipo   | Descrizione | Esempio | Note |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | ID Obiettivo | 1 | |
| status | number | stato dopo la chiamata | 2 | `0` bloccato · `1` sbloccato, Ricompensa non reclamata · `2` sbloccato, Ricompensa reclamata |

**Note:**

1. Obiettivi manuali (senza condizioni di sblocco): se ancora bloccati, questa chiamata completa l'Obiettivo e assegna Ricompense.
2. Obiettivi automatici (con condizioni di sblocco): reclama Ricompense solo quando già sbloccato e resta una Ricompensa in sospeso. Se le condizioni non sono soddisfatte, la chiamata fallisce con `error_code=achievement_not_unlocked`.
3. Richiamare dopo aver già reclamato la Ricompensa ha successo con `status=2` e non assegna Ricompense due volte.
4. Questo differisce da `achievement?unlocked=true`, che scrive solo lo stato di sblocco e non assegna Ricompense.

<br/>

### Imposta il numero di passi

**Nome metodo:** step

**Descrizione:** Imposta il numero di passi nella data indicata; ad esempio, può servire per registrare i passi con un braccialetto + strumento di automazione. Può anche modificare i registri storici.

**Esempio:**

- Regola il numero di passi del 2022-10-21 nel fuso orario GMT+8 a 9999 passi: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parametro | Significato                         | Tipo                                | Esempio       | Obbligatorio | Note |
| --------- | ----------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | numero di passi                 | a number greater than or equal to 0 | 9999          | sì      |       |
| time      | timestamp arbitrario della data | timestamp (ms)                      | 1666282995643 | sì      |       |

<br/>

### Modifica Punti Esperienza

?> Questa API è stata introdotta nella versione v1.93.0-beta01 (502).

**Nome metodo:** edit_exp

**Descrizione:** Questa API può impostare in batch i valori attuali di Punti Esperienza degli Attributi. Può impostare direttamente un valore di esperienza specifico o un Livello particolare.

**Esempio:**

> Questa API modifica i dati e, per evitare un uso accidentale, qui non sono forniti link cliccabili diretti.

- Reimposta i Punti Esperienza degli Attributi [Strength] e [Knowledge] a 0: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Regola direttamente i Punti Esperienza di [Charm] al Livello 50: lifeup://api/edit_exp?skills=3&level=50

| Parametro | Significato              | Tipo                                      | Esempio | Obbligatorio | Note |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | ID Attributo (Abilità) | Array of numbers greater than 0           | 1       | No       | Supporta array (es. &skills=1&skills=2&skills=3)<br/>Per ottenere l'ID Attributo, consulta la sezione «Basics - LifeUp Data ID» |
| exp       | Imposta Punti Esperienza | Number greater than or equal to 0 (int32) | 9999    | No, ma deve essere fornito exp o level |                                                               |
| level     | Imposta Livello            | Number greater than or equal to 0 (int32) | 50      | No, ma deve essere fornito exp o level | Rappresenta i Punti Esperienza iniziali di un Livello particolare<br/>e sarà influenzato da gradienti di Livello personalizzati. |

<br/>

### Aggiungi o modifica Riflessioni

?> Questa API è disponibile dalla versione v1.93.4 (536).

**Nome metodo:** feeling

**Descrizione:** Serve per creare o aggiornare registri di Riflessioni.

**Esempio:**

- Crea un nuovo registro di Riflessione: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Aggiorna un registro di Riflessione esistente e contrassegnalo come preferito: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Elimina una Riflessione: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parametro            | Significato           | Tipo                               | Esempio           | Obbligatorio | Note                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | ID registro Riflessione | Number greater than 0              | 1                 | No       | Se fornito, il metodo tenta di aggiornare un registro specifico. Obbligatorio per l'eliminazione.                                                                                                                                                           |
| content              | Contenuto           | Any text                           | Happy             | No       | Usato per creare un nuovo registro o aggiornare il contenuto di uno esistente                                                                                                                                                                    |
| time                 | Timestamp         | Unix timestamp                     | 1633036800        | No       | Ora del registro; predefinita: ora corrente                                                                                                                                                                                             |
| is_favorite          | Flag preferito     | true or false                      | true              | No       | Contrassegna il registro come preferito o meno                                                                                                                                                                                                        |
| delete               | Elimina            | true or false                      | true              | No       | v1.105.1+. Soft-delete della Riflessione come nell'App (gli allegati vengono rimossi).                                                                                                                                                       |
| relate_type          | Tipo di relazione     | Number between 0 and 3             | 1                 | No       | Specifica il tipo di relazione associato al registro:<br/>0: Compito<br/>1: Obiettivo personalizzato<br/>2: Nessuna relazione<br/>3: Uso Oggetto                                                                                                        |
| relate_id            | ID correlato        | Number greater than 0              | 2                 | No       | Specifica l'ID dell'elemento correlato:<br/>Quando relate_type è 0: rappresenta l'ID Compito<br/>Quando relate_type è 1: rappresenta l'ID Obiettivo<br/>Quando relate_type è 3: rappresenta l'ID Oggetto<br/>Quando relate_type è 2: non serve ID                |
| usage_count          | Conteggio utilizzi       | Integer greater than 1             | 1                 | No       | Valido solo quando relate_type è 3 (uso Oggetto); registra il conteggio di utilizzo dell'Oggetto.                                                                                                                                                          |
| image_uris           | URI immagini        | List of URI strings                |                   | No       | Supporta URI file locali (file://) o immagini web remote (http/https). Supporta array (es. &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Modalità aggiornamento       | APPEND or REPLACE | REPLACE           | No       | Valido solo quando si aggiorna un registro esistente e si fornisce image_uris.<br/>APPEND: Aggiunge alle immagini esistenti.<br/>REPLACE: Sostituisce le immagini esistenti (predefinito).                                                               |
    
**Avviso:**

1. Se è fornito il parametro `id`, il metodo tenta di aggiornare il registro di Riflessione corrispondente. Viene lanciata un'eccezione se non si trova un registro corrispondente.
2. Se `id` non è fornito, ma lo è `content`, il metodo creerà un nuovo registro di Riflessione.

<br/>

### Conteggio pomodori

?> Richiede v1.98.0+

**Nome metodo:** tomato

**Descrizione:** Regola il numero di pomodori (aumentare, diminuire o impostare una quantità specifica)

**Esempi:**

- Aggiungi 1 pomodoro: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Rimuovi 2 pomodori: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Imposta il conteggio Pomodoro a 10: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parametro | Significato        | Valori                                        | Esempio   | Obbligatorio | Note                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Tipo operazione | One of:<br/>increase<br/>decrease<br/>set     | increase  | No       | increase - Aggiungi pomodori (predefinito)<br/>decrease - Rimuovi pomodori<br/>set - Imposta il conteggio Pomodoro al valore indicato |
| number    | Quantità         | Integer                                       | 1         | Sì      | Significato in base ad action:<br/>increase/decrease - Quantità da aggiungere/rimuovere<br/>set - Quantità obiettivo |

**Risposta:**

| Campo    | Tipo    | Descrizione              | Esempio |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Conteggio Pomodoro attuale   | 10      |

<br/>

### Acquista Oggetto

?> Richiede v1.98.0+

**Nome metodo:** purchase_item

**Descrizione:** Acquista un Oggetto specifico

**Esempi:**

- Acquista Oggetto con ID 1: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Acquista Oggetto chiamato "Health Potion": [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Acquista 5 unità dell'Oggetto con ID 1: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Se l'Oggetto ha configurato `purchase_limit` e `limit_scope` include `purchase`, questa API applicherà anche tali restrizioni.

| Parametro         | Significato          | Valori                | Esempio       | Obbligatorio | Note                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | ID Oggetto          | number greater than 0 | 1             | No*      | È richiesto id o name |
| name              | Nome Oggetto        | any text              | Health Potion | No*      | È richiesto id o name |
| purchase_quantity | Quantità acquisto| number greater than 0 | 5             | No       | Predefinito 1              |

**Risposta:**

| Campo  | Tipo    | Descrizione        | Esempio         | Note                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | ID Oggetto            | 1               | Restituito in caso di acquisto riuscito  |
| result | Integer | Codice risultato        | 0               | Vedi codici risultato sotto      |
| desc   | Text    | Descrizione risultato | PurchaseSuccess | Vedi codici risultato sotto      |

**Codici risultato:**

| Codice | Descrizione               | Note                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Acquisto riuscito            |
| 1    | DatabaseError             | Errore database                |
| 2    | NotEnoughCoin             | Monete insufficienti              |
| 3    | ItemNotFound              | Oggetto non trovato                |
| 4    | PurchaseAndUseSuccess     | Acquisto e uso riusciti    |
| 5    | PurchaseSuccessAndUseFailure | Acquisto riuscito ma uso fallito |
| 6    | NotPurchaseable           | Acquisto bloccato da impostazioni o restrizioni dell'Oggetto |
| 7    | OutOfStock                | Scorte del Negozio insufficienti      |

<br/>

### Sintesi

?> Richiede v1.98.0+

**Nome metodo:** synthesize

**Descrizione:** Sintetizza Oggetti usando una formula esistente

**Esempi:**

- Sintetizza una volta con la formula con ID 1: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Sintetizza 5 volte con la formula con ID 1: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Comportamento broadcast:**

- Questa API è per la **Sintesi da ricetta**.
- Quando `Broadcast events` è attivo e la Sintesi riesce, LifeUp invia anche l'evento broadcast `app.lifeup.synthesis.complete`.
- Questo evento **non** viene inviato per la Sintesi semplice dentro `use_item`; quel percorso appartiene ancora a `app.lifeup.item.use`.

| Parametro | Significato            | Valori                | Esempio | Obbligatorio | Note                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | ID formula        | number greater than 0 | 1       | Sì      | ID della formula di Sintesi  |
| times     | Numero di volte   | number greater than 0 | 5       | No       | Predefinito 1           |

**Risposta:**

| Campo           | Tipo    | Descrizione     | Esempio          | Note                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | ID formula      | 1                |                          |
| result         | Integer | Codice risultato     | 0                | Vedi codici risultato sotto   |
| desc           | Text    | Descrizione risultato | SynthesisSuccess | Vedi codici risultato sotto |
| synthesisResults| Text   | Risultati Sintesi | {...}           | Restituito solo in caso di successo |

**Codici risultato:**

| Codice | Descrizione          | Note                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Sintesi riuscita  |
| 1    | FormulaNotFound     | Formula non trovata     |
| 2    | InsufficientMaterials| Materiali insufficienti |
| 3    | DatabaseError       | Errore database        |
| 4    | UnknownError        | Altri errori         |

<br/>

### Gestione formule di Sintesi

?> Richiede v1.98.0+

**Nome metodo:** synthesis_formula

**Descrizione:** Crea, modifica o elimina formule di Sintesi

**Esempi:**

- Crea una formula nuova: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Qui, inputItems è `[{"item_id": 296, "amount": 88}]`
  - Qui, outputItems è `[{"item_id": 295, "amount": 1}]`
- Elimina formula: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parametro   | Significato        | Valori                | Esempio                        | Obbligatorio | Note                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | ID formula     | number greater than 0 | 1                             | No       | Obbligatorio per modificare o eliminare  |
| delete      | Flag eliminazione    | true or false        | true                          | No       | Usato solo per l'eliminazione         |
| inputItems  | Oggetti in ingresso    | Item array, see below | [{"item_id":1,"amount":2}]     | Sì      | Obbligatorio per creare o modificare  |
| outputItems | Oggetti in uscita   | Item array, see below | [{"item_id":3,"amount":1}]     | Sì      | Obbligatorio per creare o modificare  |
| category    | ID categoria    | number greater than 0 | 1                             | No       | Predefinito: categoria comune    |

!> inputItems e outputItems sono array JSON in cui ogni elemento contiene i campi item_id e amount. Tutti gli ID Oggetto devono esistere e le quantità devono essere maggiori di 0

**Risposta:**

| Campo     | Tipo    | Descrizione      | Esempio     | Note                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | ID formula       | 1           | Restituito in caso di successo      |
| result    | Integer | Codice risultato      | 0           | Vedi codici risultato sotto   |
| desc      | Text    | Descrizione risultato | AddSuccess | Vedi codici risultato sotto   |

**Codici risultato:**

| Codice | Descrizione     | Note             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operazione riuscita |
| 1    | Failed         | Operazione fallita  |

<br/>

### Gestione sottocompiti

?> Richiede v1.98.0+

**Nome metodo:** subtask

**Descrizione:** Crea o modifica sottocompiti

**Esempi:**

- Aggiungi un sottocompito al Compito principale con ID 1: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Modifica sottocompito e imposta Ricompense: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parametro     | Significato            | Valori                | Esempio    | Obbligatorio | Note                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | ID Compito principale       | number greater than 0 | 1         | No*      | È richiesto uno tra main_id, main_gid o main_name |
| main_gid     | ID gruppo Compiti principale | number greater than 0 | 1         | No*      | È richiesto uno tra main_id, main_gid o main_name |
| main_name    | Nome Compito principale     | any text             | Study task | No*      | È richiesto uno tra main_id, main_gid o main_name |
| edit_id      | ID sottocompito da modificare | number greater than 0 | 2         | No*      | È richiesto uno tra edit_id, edit_gid o edit_name in modifica; non serve in creazione |
| edit_gid     | ID gruppo sottocompito   | number greater than 0 | 2         | No*      | È richiesto uno tra edit_id, edit_gid o edit_name in modifica; non serve in creazione |
| edit_name    | Nome sottocompito       | any text             | Do homework| No*      | È richiesto uno tra edit_id, edit_gid o edit_name in modifica; non serve in creazione |
| todo         | Contenuto Compito       | any text             | Do homework| No       | Obbligatorio quando si crea un nuovo sottocompito |
| remind_time  | Ora promemoria      | timestamp (milliseconds)| 1640995200000 | No | Passa null per cancellare il promemoria    |
| order        | Ordine              | integer              | 1          | No       | Posizione nell'elenco Compiti           |
| coin         | Ricompensa monete        | [0, 999999]         | 10         | No       | Monete ottenute al completamento    |
| coin_var     | Variazione monete      | integer              | 5          | No       | Variazione casuale della Ricompensa in monete  |
| exp          | Ricompensa Punti Esperienza  | [0, 99999]          | 5          | No       | Punti Esperienza ottenuti        |
| auto_use_item| Usa Oggetto automaticamente      | true or false        | true       | No       | Se usare l'Oggetto automaticamente al completamento |
| item_id      | ID Oggetto            | number greater than 0 | 1         | No*      | È richiesto item_id o item_name |
| item_name    | Nome Oggetto          | any text             | Health Potion| No*    | È richiesto item_id o item_name |
| item_amount  | Quantità Oggetto        | number greater than 0 | 1         | No       | Valido solo quando si imposta Ricompensa Oggetto |
| items        | JSON Oggetti         | JSON text            | [{"item_id":1,"amount":1}] | No | Imposta più Ricompense Oggetto in una volta |
| coin_set_type     | Come impostare il valore monete | One of:<br/>absolute<br/>relative | absolute | No | absolute - imposta le monete direttamente al valore<br/>relative - aggiunge o sottrae dal valore originale delle monete |
| exp_set_type      | Come impostare il valore exp | One of:<br/>absolute<br/>relative | absolute | No | absolute - imposta exp direttamente al valore<br/>relative - aggiunge o sottrae dal valore originale di exp |

**Risposta:**

| Campo        | Tipo    | Descrizione      | Esempio | Note            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID Compito principale     | 1       |                  |
| subtask_id   | Number  | ID sottocompito       | 2       |                  |
| subtask_gid  | Number  | ID gruppo sottocompito | 3       | Può essere vuoto     |

<br/>

### Gestione categorie

?> Richiede v1.98.0+

**Nome metodo:** category

**Descrizione:** Aggiungi o modifica categorie (elenchi Compiti, elenchi Obiettivi, elenchi Negozio, elenchi Sintesi)

**Esempi:**

- Crea un elenco Compiti: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Modifica un elenco Negozio: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parametro        | Significato           | Valori               | Esempio    | Obbligatorio | Note                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Tipo categoria     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Sì | tasks - Elenchi Compiti<br/>achievements - Elenchi Obiettivi<br/>shop - Elenchi Negozio<br/>synthesis - Elenchi Sintesi |
| edit_id         | ID categoria da modificare| number greater than 0| 1         | No       | Obbligatorio in modifica           |
| name            | Nome categoria     | any text             | Study List | No       | Obbligatorio per categorie nuove; opzionale in modifica |
| order           | Ordine        | integer              | 1         | No       | Posizione nell'elenco            |
| hidden          | Nascondi categoria     | true or false        | false     | No       | tasks=archivio; shop=nascondi nel Negozio; synthesis=nascondi. Gli elenchi Obiettivi e l'elenco ALL di Sintesi rifiutano con `unsupported_parameter`. `false` ripristina la visibilità |
| inventory_hidden| Nascondi in Inventario | true or false        | false     | No       | Supportato solo per elenchi Negozio   |
| icon_uri        | URI icona          | emoji, http(s) URL, content URI, or empty | 🏆 | No | Supportato solo per elenchi Obiettivi. L'emoji viene salvata come `emoji_*.webp`. Vuoto la cancella. |
| desc            | Descrizione       | any text             | This is a description | No | Supportato solo per elenchi Obiettivi |
| color           | Colore tag         | color string         | #66CCFF   | No       | Supportato solo per elenchi Compiti; # deve essere escapato come %23 |

**Risposta:**

| Campo | Tipo    | Descrizione    | Esempio | Note                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | ID categoria    | 1000    | ID della categoria nuova o modificata |

<br/>

### Esporta backup

?> Richiede v1.98.0+

**Nome metodo:** export_backup

**Descrizione:** Crea un file di backup e ne restituisce l'URI (solo chiamate Content Provider)

!> Questa API può essere invocata solo tramite Content Provider; le chiamate dirette via URL Scheme non sono supportate

| Parametro      | Significato        | Valori          | Esempio | Obbligatorio | Note                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Includi file multimediali | true or false | true    | No       | Se includere file multimediali (immagini, effetti sonori, ecc.) nel backup<br/>Predefinito true |
| callingPackage| Nome pacchetto chiamante | any text      | com.example.app | No | Identificatore pacchetto per chiamate Content Provider |

**Risposta:**

| Campo          | Tipo   | Descrizione          | Esempio                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI file backup      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Operazione sottocompiti

?> Richiede v1.98.0+

**Nome metodo:** subtask_operation

**Descrizione:** Completa, annulla il completamento o elimina sottocompiti

**Esempi:**

- Completa un sottocompito: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Elimina un sottocompito: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Annulla completamento sottocompito: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parametro     | Significato          | Valori               | Esempio    | Obbligatorio | Note                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | ID Compito principale     | number greater than 0| 1         | No*      | È richiesto uno tra main_id, main_gid o main_name |
| main_gid     | ID gruppo Compiti principale| number greater than 0| 1        | No*      | È richiesto uno tra main_id, main_gid o main_name |
| main_name    | Nome Compito principale   | any text            | Study task | No*      | È richiesto uno tra main_id, main_gid o main_name |
| edit_id      | ID sottocompito       | number greater than 0| 2         | No*      | È richiesto uno tra edit_id, edit_gid o edit_name |
| edit_gid     | ID gruppo sottocompito | number greater than 0| 2         | No*      | È richiesto uno tra edit_id, edit_gid o edit_name |
| edit_name    | Nome sottocompito     | any text            | Do homework| No*      | È richiesto uno tra edit_id, edit_gid o edit_name |
| operation    | Tipo operazione   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Sì | complete - Completa Compito<br/>undo_complete - Annulla completamento<br/>delete - Elimina Compito |

**Risposta:**

| Campo        | Tipo    | Descrizione      | Esempio | Note            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID Compito principale     | 1       |                  |
| subtask_id   | Number  | ID sottocompito       | 2       |                  |
| subtask_gid  | Number  | ID gruppo sottocompito | 3       | Può essere vuoto     |

<br/>

### Gestione Obiettivi

?> Richiede v1.98.0+

**Nome metodo:** achievement

**Descrizione:** Aggiungi o modifica Obiettivi personalizzati e sottocategorie Obiettivi

**Esempi:**

- Crea un Obiettivo: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Potrebbe essere necessario sostituire `category_id` con l'id reale del tuo elenco Obiettivi disponibile per provare questo esempio
- Crea un Obiettivo con condizioni di sblocco: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Potrebbe essere necessario sostituire `category_id` con l'id reale del tuo elenco Obiettivi disponibile per provare questo esempio
  - Il contenuto decodificato di `conditions_json` è `[{"type":7,"target":1000000}]`
- Modifica Obiettivo esistente: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Parametri Obiettivo

| Parametro      | Significato           | Valori               | Esempio   | Obbligatorio | Note                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | ID Obiettivo da modificare | number greater than 0 | 1      | No       | Obbligatorio in modifica          |
| is_subcategory| È sottocategoria    | true or false        | false     | No       | Predefinito false               |
| name          | Nome Obiettivo   | any text             | Collector | No*      | Obbligatorio per Obiettivi nuovi   |
| desc          | Descrizione       | any text             | Collect 100 items | No |                               |
| icon_uri      | Icona              | emoji, http(s) URL, content URI, or empty | 🏆 | No | Non è `icon`. L'emoji viene salvata come file `emoji_`. Vuoto la cancella. |
| order         | Ordine        | integer              | 1         | No       | Posizione nell'elenco                |
| category_id   | ID categoria       | number greater than 0 | 1        | No*      | Obbligatorio quando si crea una sottocategoria |
| unlocked      | Stato sblocco     | true or false        | true      | No       | true - sblocca immediatamente<br/>false - reimposta a bloccato |
| unlock_time   | Ora sblocco       | timestamp (milliseconds) | 1640995200000 | No | Efficace solo quando già sbloccato |
| delete        | Flag eliminazione       | true or false        | false     | No       |                                |
| secret        | Obiettivo nascosto| true or false        | false     | No       |                                |
| write_feeling | Registra Riflessioni   | true or false        | false     | No       |                                |
| color         | Colore titolo       | color string         | #66CCFF   | No       | # deve essere escapato come %23        |
| auto_use_item | Usa Oggetto automaticamente     | true or false        | false     | No       |                                |
| skills        | ID Abilità         | array of numbers greater than 0 | 1 | No    | Supporta array (es. &skills=1&skills=2) |
| exp           | Ricompensa Punti Esperienza | integer              | 100       | No       |                                |
| item_id       | ID Oggetto           | number greater than 0 | 1        | No*      | È richiesto item_id o item_name |
| item_name     | Nome Oggetto         | any text             | Treasure  | No*      | È richiesto item_id o item_name |
| item_amount   | Quantità Oggetto     | [1, 99]             | 1         | No       | Predefinito 1                   |
| items         | JSON Ricompense Oggetto | JSON text            | [{"item_id":1,"amount":2}] | No | Imposta più Ricompense Oggetto; vedi formato sotto |
| conditions_json| JSON condizioni di sblocco | JSON text      | [{"type":7,"target":1000000}] | No | Imposta condizioni di sblocco; vedi formato sotto |
| coin         | Ricompensa monete       | [0, 999999]      | 10         | No       | Quantità di monete ottenute allo sblocco dell'Obiettivo |
| coin_var     | Variazione Ricompensa monete | integer              | 5          | No       | Intervallo di variazione delle Ricompense in monete |
| coin_set_type| Come impostare il valore monete | One of:<br/>absolute<br/>relative | absolute | No | absolute - imposta le monete direttamente al valore<br/>relative - aggiunge o sottrae dal valore originale delle monete |
| exp_set_type | Come impostare il valore exp | One of:<br/>absolute<br/>relative | absolute | No | absolute - imposta exp direttamente al valore<br/>relative - aggiunge o sottrae dal valore originale di exp |

**Risposta:**

| Campo  | Tipo    | Descrizione      | Esempio | Note                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID Obiettivo   | 1000    | ID dell'Obiettivo nuovo o modificato |

#### 2. Parametri sottocategoria

| Parametro     | Significato           | Valori               | Esempio   | Obbligatorio | Note                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Stato collasso   | true or false        | false     | No       | Si applica solo alle sottocategorie   |

Le sottocategorie rifiutano `icon_uri` (incluso emoji) con `unsupported_parameter`. Modificare una sottocategoria senza `is_subcategory=true` restituisce `is_subcategory_required`.
**Risposta:**

| Campo  | Tipo    | Descrizione      | Esempio | Note                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID Obiettivo   | 1000    | ID dell'Obiettivo nuovo o modificato (sottocategoria) |

#### 3. Tipi di condizione di sblocco

| Codice tipo | Descrizione             | Richiede related_id | Tipo related_id | Descrizione target  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Conteggio completamenti Compito   | Sì                | ID Compito         | Numero di completamenti |
| 1         | Serie completamenti Compito  | Sì                | ID Compito         | Conteggio serie       |
| 3         | Conteggio Pomodoro         | No                 | -               | Numero di pomodori |
| 4         | Giorni usando LifeUp      | No                 | -               | Numero di giorni     |
| 5         | Conteggio mi piace             | No                 | -               | Numero di mi piace    |
| 6         | Serie completamenti giornaliera | No                 | -               | Giorni di serie        |
| 7         | Monete attuali          | No                 | -               | Quantità di monete    |
| 8         | Monete guadagnate in un giorno| No                 | -               | Quantità di monete    |
| 9         | Conteggio Pomodoro Compito    | Sì                | ID Compito         | Numero di pomodori |
| 10        | Conteggio acquisti Oggetto    | Sì                | ID Oggetto         | Conteggio acquisti     |
| 11        | Conteggio utilizzi Oggetto       | Sì                | ID Oggetto         | Conteggio utilizzi        |
| 12        | Conteggio Oggetti Bottino    | Sì                | ID Oggetto         | Conteggio ottenuti     |
| 13        | Livello Abilità raggiunto    | Sì                | ID Abilità        | Valore Livello        |
| 14        | Livello vita            | No                 | -               | Valore Livello        |
| 15        | Totale Oggetti ottenuti   | Sì                | ID Oggetto         | Conteggio totale ottenuti |
| 16        | Oggetti da Sintesi   | Sì                | ID Oggetto         | Conteggio Sintesi    |
| 17        | Quantità attuale Oggetto  | Sì                | ID Oggetto         | Conteggio posseduti          |
| 18        | Durata Concentrazione Compito    | Sì                | ID Compito         | Durata (minuti) |
| 19        | Risparmi ATM           | No                 | -               | Importo risparmi     |
| 20        | API esterna          | No                 | -               | Definito dall'API        |
| 520       | Completa N Compiti distinti al giorno | No         | -               | Conteggio Compiti distinti (deduplicato per ID gruppo; tipo esistente) |
| 524       | Completa N completamenti Compito al giorno | No       | -               | Conteggio totale completamenti validi in un giorno (v1.104.4+) |

> A partire da v1.104.4, i tipi `520` e `524` usano la seguente semantica:
>
> - Entrambi condividono la stessa definizione di completamento e il confine del giorno del calendario locale (`TimeRange.today()`).
> - I Compiti ordinari contano `COMPLETED`; i Compiti negativi contano `GIVE_UP`.
> - Il tipo `520` deduplica per `groupId` effettivo (ricade sull'id del record Compito se manca l'id gruppo). Completare lo stesso Compito illimitato più volte in un giorno conta ancora come 1 Compito distinto.
> - Il tipo `524` conta ogni riga di completamento valida. Completare lo stesso Compito illimitato 5 volte produce `completionCount = 5`.
> - Gli Obiettivi esistenti con `type=520` mantengono la semantica Compiti distinti; non serve migrazione.

#### 4. Specifiche formato JSON

##### Condizioni di sblocco (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Ricompense Oggetto (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Gestione Abilità

?> Richiede v1.98.0+

**Nome metodo:** skill

**Descrizione:** Crea o modifica Abilità personalizzate (Attributi)

**Esempi:**

- Crea un'Abilità: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Modifica Punti Esperienza Abilità: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Elimina Abilità: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parametro    | Significato           | Valori               | Esempio    | Obbligatorio | Note                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | ID Abilità          | number greater than 0 | 1         | No       | Obbligatorio in modifica           |
| content     | Nome Abilità        | any text             | Programming| No*      | Obbligatorio per Abilità nuove         |
| desc        | Descrizione       | any text             | Coding ability | No    |                                |
| icon        | Icona              | any text             | 💻         | No       | Può usare emoji                   |
| color       | Colore             | color string         | #FF6B6B    | No       | # deve essere escapato come %23        |
| type        | Tipo              | integer              | 0          | No       |                                |
| order       | Ordine        | integer              | 1          | No       | Posizione grezza nell'elenco misto. Usato da solo, l'Abilità viene posizionata in quella posizione e il gruppo finale si deduce dal layout; usato con `group_id`, si aggancia alla posizione legale più vicina dentro il gruppo target |
| group_id    | ID gruppo Abilità    | integer              | 10         | No       | Richiede v1.103.0+; non può essere minore di `0`, e solo `0` sposta l'Abilità nell'area non raggruppata. Usato da solo, le Abilità nuove vengono aggiunte in coda al gruppo target, mentre quelle modificate mantengono la posizione attuale se già in quel gruppo; altrimenti si spostano in coda al gruppo; usato con `order`, `group_id` ha priorità |
| status      | Stato            | integer              | 0          | No       |                                |
| exp         | Punti Esperienza | number greater than or equal to 0 | 100 | No | Punti Esperienza attuali dell'Abilità        |
| delete      | Flag eliminazione       | true or false        | false      | No       | Valido solo in modifica         |

**Risposta:**

| Campo  | Tipo    | Descrizione    | Esempio | Note                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | ID Abilità       | 1000    | ID dell'Abilità nuova o modificata |

<br/>

### Gestione gruppi Abilità :id=skill_group_management

Richiede v1.103.0+

**Nome metodo:** skill_group

**Descrizione:** Crea, modifica, elimina o riordina gruppi Abilità. L'API di ordinamento supporta anche l'ordinamento misto di gruppi e Abilità.

**Esempi:**

- Crea un gruppo: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Modifica un gruppo: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Elimina un gruppo: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Ordina gruppi e Abilità insieme:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parametro | Significato | Valori | Esempio | Obbligatorio | Note |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | ID gruppo Abilità | number greater than 0 | 10 | No* | Obbligatorio in modifica o eliminazione |
| content | Nome gruppo | any text | Combat | No* | Obbligatorio in creazione |
| order | Ordine | integer | 20 | No | Valore grezzo `orderInCategory`; deve essere unico nell'elenco misto Abilità/gruppo |
| collapsed | Stato collasso | true or false | true | No | Se il gruppo è collassato |
| delete | Flag eliminazione | true or false | false | No | Valido solo in modifica |
| sort_json | Nodi ordinamento misto | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | No* | Se fornito, i parametri CRUD vengono ignorati e viene applicato il piano di ordinamento misto. È supportato l'ordinamento parziale: i nodi non specificati mantengono l'ordine relativo |

Formato nodo `sort_json`:

| Campo | Significato | Valori |
| ----- | ------- | ------ |
| type | Tipo nodo | `skill` / `group` |
| id | ID entità | number greater than 0 |

**Risposta:**

| Campo | Tipo | Descrizione | Esempio | Note |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | ID gruppo Abilità | 10 | Restituito per creazione / modifica / eliminazione |
| count | Number | Numero nodi ordinati | 3 | Restituito per richieste `sort_json` |

<br/>

### Impostazioni App

?> Richiede v1.98.0+

**Nome metodo:** app_settings

**Descrizione:** Regola le impostazioni dell'interfaccia dell'App

**Esempi:**

- Abilita modalità compatta: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Abilita tema Material You: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Modifica impostazioni e riavvia subito l'interfaccia: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parametro              | Significato           | Valori          | Esempio | Obbligatorio | Note                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Abilita modalità compatta| true or false  | true    | No       | Semplifica gli elementi dell'interfaccia     |
| is_enable_material_you| Abilita Material You| true or false  | true    | No       | Abilita il tema Material You       |
| restart_activities    | Riavvia interfaccia | true or false   | true    | No       | Applica subito le modifiche all'interfaccia |
| broadcast_event | Eventi broadcast LifeUp Labs | true or false | true | No | Predefinito disattivato. Stesso interruttore di Impostazioni → Labs |

**Risposta:**

| Campo  | Tipo    | Descrizione  | Esempio | Note                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Codice risultato  | 0       | 0 indica successo      |

<br/>

### Query semplice

!> Le funzioni qui servono con strumenti di automazione/sviluppo secondario. Se ti serve interrogare un elenco completo di dati, consulta [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) e [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Nome metodo:** query

**Descrizione:** parametri di query

**Esempio:** - Interroga il numero attuale di monete: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Interroga l'interruttore eventi broadcast: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parametro   | Significato              | Tipo                                                         | Esempio | Obbligatorio                                    | Note                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | tipo di query        | Solo uno dei seguenti valori:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | sì                                         | coin - importo attuale monete<br/>atm - saldo ATM attuale<br/>item - Informazioni Oggetto per l'`itemId` specificato<br/>item_id_list - Elenco ID Oggetto specificati da `categoryId`<br/>tomato - Dati pomodoro<br/>task - Informazioni Compito (v1.101.0+)<br/>broadcast - Interruttore eventi broadcast Labs (`{enabled}`) |
| item_id     | id dell'Oggetto   | a number greater than 0                                      | 1       | Quando key è `item`, è obbligatorio |                                                              |
| category_id | id categoria Negozio | Number greater than or equal to 0                            | 0       | no*                                         | Obbligatorio solo quando key è `item_id_list`; rappresenta l'ID dell'elenco da interrogare. |
| task_id / taskId | ID Compito          | Number greater than 0                                        | 1       | Quando key è `task`, uno dei tre* è obbligatorio | ID Compito interrogato |
| task_gid / taskGid / task_group_id / taskGroupId | ID gruppo Compito | Number greater than 0 | 1 | Quando key è `task`, uno dei tre* è obbligatorio | ID gruppo Compito interrogato |
| task_name / taskName | Nome Compito      | Any text                                                     | Study   | Quando key è `task`, uno dei tre* è obbligatorio | Nome Compito con corrispondenza fuzzy |
| withSubTasks | Includi sottocompiti   | true or false                                                | true    | No                                          | Disponibile solo quando key è `task`; predefinito true |

**Valore restituito:**

Supportato solo dalla versione 1.90.2

Quando si interroga coin/atm:

| Parametro | Significato                             | Tipo               | Esempio | Obbligatorio | Note |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Valore numerico restituito dalla query | number             | 1000    | sì      |       |

Quando si interroga un Oggetto:

| Parametro        | Significato                         | Tipo     | Esempio   | Obbligatorio | Note |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | id dell'Oggetto              | number   | 1         | sì      |       |
| name             | nome dell'Oggetto            | any text | Coffee    | sì      |       |
| desc             | descrizione                     | any text |           | no       |       |
| icon             | URL icona                        | any text | icon.webp | no       | Se è un file locale, viene restituito solo il nome file |
| category_id      | id dati categoria                | number   | 1         | sì      |       |
| stock_number     | quantità scorte Negozio             | number   | -1        | sì      | `-1` rappresenta scorte infinite nel Negozio |
| own_number       | quantità posseduta nell'Inventario | number   | 10        | sì      |       |
| price            | prezzo                       | number   | 100       | sì      |       |
| order            | ordinamento                         | number   | 100       | sì      | Valore peso con ordinamento personalizzato |
| disable_purchase | Disabilita acquisto     | true or false | true | sì |       |
| purchase_limit   | Regole di restrizione               | JSON text | [{"limitType":0,"limitNumber":5}] | sì | Elenco restrizioni attuale |
| limit_scope      | Ambito restrizione               | purchase / use / both | use | sì | Restituito come valore testuale API |

Quando si interroga item_id_list:

| Parametro | Significato                           | Tipo   | Esempio | Obbligatorio | Note |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Array ID Oggetto separati da virgola     | string | 1,2,3,4 | sì      |       |

Quando si interroga tomato:

| Parametro | Significato                  | Tipo   | Esempio | Obbligatorio | Note |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Conteggio totale pomodori       | number | 100     | sì      |       |
| available | Conteggio pomodori disponibili   | number | 50      | sì      |       |
| exchanged | Conteggio pomodori scambiati   | number | 50      | sì      |       |

Quando si interroga task (v1.101.0+):

| Parametro   | Significato                      | Tipo        | Esempio | Obbligatorio | Note                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | ID Compito                      | number      | 1       | sì      | -                               |
| _GID        | ID gruppo Compito                | number      | 1       | sì      | -                               |
| name        | Nome Compito                    | text        | Study   | sì      | -                               |
| notes       | Note                        | text        | -       | no       | Può essere vuoto                    |
| status      | Stato Compito                  | number      | 0       | sì      | 0=incompleto, 1=completato       |
| startTime   | Ora inizio                   | number      | -       | sì      | Timestamp Unix (millisecondi)   |
| deadline    | Scadenza                | number      | -       | no       | Timestamp Unix (millisecondi), può essere vuoto |
| remindTime  | Ora promemoria                  | number      | -       | no       | Timestamp Unix (millisecondi), può essere vuoto |
| frequency   | Frequenza ripetizione         | number      | -       | sì      | -                               |
| weekdays    | Giorni della settimana                     | text        | 1,3,5   | no       | v1.106.0+; vuoto quando non in modalità giorni feriali. 1=lunedì … 7=domenica |
| exp         | Ricompensa Punti Esperienza                   | number      | -       | sì      | -                               |
| skillIds    | Elenco ID Abilità                | JSON text   | -       | sì      | Formato array JSON               |
| coin        | Ricompensa monete                  | number      | -       | no       | Può essere vuoto                    |
| coinVariable| Ricompensa monete casuale           | number      | -       | no       | Può essere vuoto                    |
| itemId      | ID primo Oggetto Ricompensa         | number      | -       | no       | Può essere vuoto                    |
| itemCount   | Quantità primo Oggetto Ricompensa      | number      | -       | no       | Restituito quando itemId esiste     |
| items       | Elenco Ricompense Oggetto             | JSON text   | -       | sì      | Formato array JSON               |
| words       | Frasi motivazionali al completamento   | text        | -       | no       | Può essere vuoto                    |
| categoryId  | ID categoria                  | number      | -       | no       | Può essere vuoto                    |
| order       | Ordine                        | number      | -       | sì      | -                               |
| name_extended | Nome esteso              | text        | -       | sì      | Uguale a name                    |
| subTasks    | Elenco sottocompiti                | JSON text   | -       | sì      | Formato array JSON, vedi sotto    |

**Descrizione campo sottocompiti (subTasks):**

Il campo `subTasks` è un array JSON; ogni elemento contiene i seguenti campi:

- `id`: ID sottocompito
- `gid`: ID gruppo sottocompito
- `todo`: Contenuto sottocompito
- `status`: Stato sottocompito (0=incompleto, 1=completato)
- `remindTime`: Ora promemoria (timestamp Unix, millisecondi)
- `exp`: Ricompensa Punti Esperienza
- `coin`: Ricompensa monete
- `coinVariable`: Ricompensa monete casuale
- `items`: Elenco Ricompense Oggetto
- `order`: Ordine
- `autoUseItem`: Usa Oggetto automaticamente

<br/>

### Query Attributi :id=query_skill

!> Le funzioni qui servono con strumenti di automazione/sviluppo secondario.

**Nome metodo:** query_skill

**Descrizione:** Interroga le informazioni di base, i campi di ordinamento grezzi e i dati Livello/esperienza di un'Abilità specificata.

È possibile usare questa API per personalizzare i widget Attributi.

**Esempio:**

- Interroga l'Attributo forza: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parametro | Significato              | Tipo                    | Esempio | Obbligatorio | Note |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | id Attributo (Abilità) | a number greater than 0 | 1       | sì      | Per ottenere l'ID, consulta la sezione «Basics - LifeUp Data ID» più sopra |

**Valore restituito:**

Supportato solo dalla versione 1.90.6

| Parametro            | Significato                              | Tipo   | Esempio  | Obbligatorio | Note |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | id Abilità                             | number | 1        | sì      | Aggiunto a `query_skill` in v1.103.0+ |
| name                 | nome Attributo                       | string | strength | sì      |       |
| order                | ordine grezzo                       | number | 20       | sì      | Aggiunto in v1.103.0+; `orderInCategory` |
| group_id             | ID gruppo Abilità                       | number | 10       | sì      | Aggiunto in v1.103.0+; restituisce `0` quando l'Abilità non è in un gruppo |
| status               | stato                               | number | 0        | sì      | Aggiunto in v1.103.0+; `0` = normale, `1` = nascosto |
| level                | Livello                                | number | 10       | sì      |       |
| total_exp            | Punti Esperienza totali              | number | 10000    | sì      |       |
| until_next_level_exp | Punti Esperienza per raggiungere il Livello successivo | number | 99       | sì      |       |
| current_level_exp    | Punti Esperienza oltre il Livello attuale       | Number | 1000     | Sì      |       |

<br/>

### Query gruppo Abilità :id=query_skill_group

Richiede v1.103.0+

**Nome metodo:** query_skill_group

**Descrizione:** Interroga un singolo gruppo Abilità e restituisce l'ordinamento grezzo e lo stato collassato.

**Esempio:**

- Interroga un gruppo Abilità: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parametro | Significato | Tipo | Esempio | Obbligatorio | Note |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID gruppo Abilità | number greater than 0 | 10 | sì | - |

**Valore restituito:**

| Parametro | Significato | Tipo | Esempio | Obbligatorio | Note |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID gruppo Abilità | number | 10 | sì | - |
| content | Nome gruppo | string | Combat | sì | - |
| order | Ordine grezzo | number | 20 | sì | `orderInCategory` |
| collapsed | Stato collasso | string | true | sì | Restituito come testo `true` / `false` |

<br/>

<br/>

### Interfaccia speciale

#### Random

?> Questa API è stata rilasciata in v1.93.0.

**Nome metodo:** random

**Descrizione:** Interfaccia random semplice che può attivare a caso una tra più API.

**Esempio:**

- Probabilità uguale di mostrare a caso `scissors`, `rock` o `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- Probabilità 90% di mostrare `rock`, 5% per `scissors` e 5% per `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parametro | Significato    | Valori                 | Esempio                                | Obbligatorio | Note |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | API random | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Sì      | Supporta chiamata in forma array (cioè più parametri api, come negli esempi sopra) |
| weight    | Peso     | Numbers greater than 0 | 1                                      | No       | Supporta chiamata in forma array.<br/><br/>Se weight non è specificato, tutti i pesi sono uguali (probabilità uguale).<br/>Se i pesi sono specificati, vengono assegnati in sequenza: ad esempio, il primo peso corrisponde al primo parametro api.<br/><br/>**Assicurati che il numero di parametri weight corrisponda al numero di parametri api, altrimenti potrebbe non avere effetto.** |

<br/>

#### Finestra di conferma

**Nome metodo:** confirm_dialog

**Descrizione:** Compare una finestra di selezione popup. Puoi personalizzare titolo, testo, pulsante positivo e pulsante negativo. Al clic sui pulsanti è possibile chiamare anche altre interfacce.

**Esempio:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Altri scenari d'uso:
  - Scelta delle Ricompense
  - Selezione ramo evento

| Parametro       | Significato              | Tipo     | Esempio  | Obbligatorio | Note |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | titolo popup          | any text | Title    | sì      |       |
| message         | descrizione dettagliata della finestra popup | any text | This is the content of the popup window | no |  |
| positive_text   | testo pulsante positivo | any text | YES      | no       |       |
| negative_text   | testo pulsante negativo | any text | NO       | no       |       |
| neutral_text    | testo pulsante neutro  | any text | QUESTION | no       |       |
| positive_action | risposta link del pulsante positivo | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | no | In realtà è il testo escapato dell'interfaccia messaggio popup. Per le regole di escape, consulta «Basics - Escaping». |
| negative_action | risposta link del pulsante negativo | URL (other interface) | Come sopra | no |  |
| neutral_action  | risposta link del pulsante neutro  | URL (other interface) | Come sopra | no |  |
| cancel_action   | risposta link dell'azione annulla   | URL (other interface) | Come sopra | no |  |

<br/>

#### Nessuna azione

**Nome metodo:** placeholder

**Nota:** Questa interfaccia di per sé non gestisce alcuna logica, ma puoi usarla con callback e broadcast.

**Esempio:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Segnaposto variabile

`LifeUp` fornisce metodi di intervento utente per i parametri.

| Placeholder                          | Significato                                                      | Esempio                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Segnaposto testo                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Segnaposto numero (senza decimali)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Segnaposto numero (senza decimali), mostra segno        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Segnaposto numero (con decimali)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Segnaposto numero (con decimali), mostra segno           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Seleziona un Oggetto; verrà sostituito con l'id Oggetto              | [$item]                                                      |
| [$task_category]                     | Seleziona elenco Compiti; verrà sostituito con l'id elenco Compiti    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Segnaposto tempo<br/><br/>Valori possibili per Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>L'offset in millisecondi deve essere un intero, predefinito 0 millisecondi | Mezzanotte di oggi: [$time\|today]<br/>Mezzanotte di domani: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Segnaposto numero casuale (senza decimali)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Segnaposto numero casuale (con decimali)                | [$random_decimal\|1.0\|2.0]                                  |

**Esempio 1: In uso, seleziona un Oggetto per ridurre il prezzo di 1 moneta**

Ad esempio, dopo aver impostato l'API per la riduzione del prezzo di un Oggetto specifico del Negozio, potresti voler permettere all'utente di selezionare l'Oggetto desiderato al momento della chiamata invece di preimpostare l'id.

La seguente API può ridurre di 1 moneta solo il prezzo dell'Oggetto del Negozio con id 1:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Basta sostituire l'id Oggetto con il segnaposto [$item]; alla chiamata, l'utente può selezionare attivamente l'Oggetto di cui ridurre il prezzo:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Esempio 2: Modello Compito, basta inserire il nome del Compito e l'elenco di selezione per creare un modello Ricompensa preimpostato**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Callback finale

Puoi aggiungere il parametro callback a tutte le interfacce per richiamare l'URL dopo la chiamata.

Serve anche per concatenare più interfacce; ad esempio, se vuoi mostrare un prompt dopo il salto:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Puoi usare il parametro callback. Consulta anche **Basics - Escaping** più sopra. Puoi scrivere questo tipo di elaborazione:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Naturalmente, puoi aggiungere più link a un Oggetto del Negozio per ottenere questo effetto.

Inoltre, questo callback è usato soprattutto per:

Applicazione X → LifeUp → Applicazione X

oppure

Applicazione X → LifeUp → Applicazione Y

<br/>

#### Valore restituito broadcast

!> Le funzioni qui servono con strumenti di automazione/sviluppo secondario e hanno una certa soglia di difficoltà.

Aggiungendo questo parametro, il valore restituito originale dell'API può essere inviato anche tramite broadcast, così strumenti di automazione come Tasker possono riceverlo.

Il valore di broadcast equivale al valore della colonna operazione di «Intent Received» in Tasker. Puoi inserire qualsiasi testo, purché i due corrispondano.

**Ad esempio, usando l'API per interrogare le monete d'oro con Tasker ([Se usi MacroDroid, consulta questo link.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Aggiungi il parametro broadcast per inviare il valore restituito a Tasker; può essere qualsiasi testo, ad esempio `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Aggiungi l'evento in Tasker → «Intent Received» e inserisci «app.lifeup.query.coin» nella colonna azione

3. Il Compito in Tasker può quindi ricevere il valore restituito di `value` come variabile `%value`.

4. Poi puoi valutare il numero di monete d'oro in Tasker per ottenere vari effetti. (Ad esempio, cambiare lo sfondo del desktop in base al numero di monete?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Notifica eventi broadcast

!> Le funzioni qui servono con strumenti di automazione/sviluppo secondario.

> Nella versione 1.90.2, trasmetteremo vari eventi all'esterno. Puoi usare strumenti di automazione come Tasker per ricevere questi eventi e attivare azioni Tasker.
>
### Abilitazione

**Per impostazione predefinita, gli eventi broadcast sono disattivati.**

Puoi abilitarli in `Impostazioni` → `Labs` → `Modalità sviluppatore` → `Eventi broadcast`.

### Esempio: Cambiare sfondo con un Oggetto

1. Crea un nuovo Oggetto chiamato «Change Wallpaper».
2. In Tasker, vai a `Configuration file` → `Event` → `System` → `Intent Received`, inserisci `app.lifeup.item.use` nella colonna operazione e torna indietro.
3. Clicca New Task e inserisci un nome qualsiasi (ad esempio, change wallpaper).
4. Clicca il segno + in basso a destra per aggiungere un Compito, seleziona `Task` → `If`
5. Imposta la colonna condizione su `%name eq change wallpaper`.
6. Torna indietro, `Insert Action` seleziona `If`.
7. Clicca di nuovo il segno + in basso a destra per aggiungere un Compito, seleziona `Display` → `Set Wallpaper`
8. (Opzionale) Sostituisci `Type` con `All`
9. Nella colonna immagine, clicca l'icona 🔍 e seleziona il file sfondo desiderato
10. Esci e verifica che questa configurazione sia abilitata.
11. Usa l'Oggetto «Wallpaper Change» in `LifeUp`; dovresti vedere lo sfondo cambiare con successo

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Usando `Nessuna azione` + `Valore restituito broadcast` puoi ottenere questo effetto in modo più conciso; puoi esplorarlo.

<br/>

### Compito completato

**Nome:** app.lifeup.task.complete

**Valore restituito:**

| Parametro  | Significato          | Esempi        |
| ----------- | ---------------- | --------------- |
| task_id     | id Compito          | 1               |
| task_gid    | id gruppo Compito    | 1               |
| name        | nome Compito        | Getting started |
| category_id | id categoria Compito | 1               |

### Compito abbandonato

**Nome:** app.lifeup.task.giveup

**Valore restituito:**

| Parametro  | Significato          | Esempi        |
| ----------- | ---------------- | --------------- |
| task_id     | id Compito          | 1               |
| task_gid    | id gruppo Compito    | 1               |
| name        | nome Compito        | Getting started |
| category_id | id categoria Compito | 1               |

### Compito scaduto

**Nome:** app.lifeup.task.overdue

**Valore restituito:**

| Parametro | Significato                 | Esempi                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | **array** id Compito       | [1, 2, 3]                       |
| task_gids  | **array** id gruppo Compito | [1, 2, 3]                       |
| names      | **array** nome Compito     | [Getting started, Drink Waters] |
| task_ids_json  | **array Json** id Compito   | [1, 2, 3]                       |
| task_gids_json | **array Json** id gruppo Compito | [1, 2, 3]                       |
| names_json     | **array Json** nome Compito | ["Getting started", "Drink Waters"]                      |

### Obiettivo sbloccato

**Nome:** app.lifeup.achievement.unlock

**Valore restituito:**

| Parametro     | Significato          | Esempi                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | id Obiettivo   | 1                        |
| name           | nome Obiettivo | Using LifeUp for 30 days |

### Oggetti acquistati

**Nome:** app.lifeup.item.purchase

**Valore restituito:**

| Parametro | Significato           | Esempi          |
| ---------- | ----------------- | ----------------- |
| item_id    | id Oggetto           | 1                 |
| name       | nome Oggetto         | Break 10 branches |
| amount     | quantità acquisto | 1                 |

### Oggetto usato

**Nome:** app.lifeup.item.use

**Descrizione:** Inviato quando l'uso normale di un Oggetto o il flusso di uso Sintesi semplice riesce.

**Valore restituito:**

| Parametro | Significato      | Esempi          |
| ---------- | ------------ | ----------------- |
| item_id    | id Oggetto      | 1                 |
| name       | nome Oggetto    | Break 10 branches |
| amount     | quantità uso | 1                 |

### Sintesi completata

> [!NOTE]
> Questo evento broadcast è stato rilasciato in v1.102.8.

**Nome:** app.lifeup.synthesis.complete

**Descrizione:** Inviato quando una Sintesi ricetta si completa con successo.

**Valore restituito:**

| Parametro   | Significato                            | Esempi                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | id formula                         | 1                                                     |
| formula_name | nome formula                       | Toolbox Recipe                                        |
| times        | volte di esecuzione                    | 3                                                     |
| input_count  | numero voci Oggetto in input       | 2                                                     |
| output_count | numero voci Oggetto in output      | 1                                                     |
| inputs_json  | array JSON di tutti gli input consumati  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | array JSON di tutti gli output prodotti | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Note:**

- Questo evento viene inviato solo dopo il successo della Sintesi.
- Se i materiali sono insufficienti, la formula non esiste, il salvataggio fallisce o `Broadcast events` è disabilitato, questo evento non viene inviato.
- Una singola chiamata API invia un solo evento anche se `times > 1`.
- In `inputs_json` e `outputs_json`, ogni voce usa la seguente struttura:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` è il **totale consumato / totale prodotto** in questa esecuzione, non la quantità per formula.

### Riflessioni aggiunte / aggiornate

**Nome:** app.lifeup.feelings.add

**Valore restituito:**

| Parametro | Significato | Esempi |
| --- | --- | --- |
| feelings_id | id Riflessione | 1 |
| action_type | `add` o `update` | add |
| content | testo Riflessione | Feeling good today! |
| create_time | timestamp creazione (ms) | 1642060800000 |
| relate_type | tipo oggetto correlato | 0 |
| related_id | id oggetto correlato | 1 |
| attachments_count | conteggio allegati | 2 |
| attachments | array percorsi allegati | ["/path/1", "/path/2"] |

### Salita di Livello

**Nome:** app.lifeup.level.up

**Valore restituito:**

| Parametro | Significato       | Esempi |
| ---------- | ------------- | -------- |
| skill_id   | id Abilità       | 1        |
| name       | nome          | strength |
| level      | Livello attuale | 2        |

### Discesa di Livello

**Nome:** app.lifeup.level.down

**Valore restituito:**

| Parametro | Significato       | Esempi |
| ---------- | ------------- | -------- |
| skill_id   | id Abilità       | 1        |
| name       | nome          | strength |
| level      | Livello attuale | 2        |

### Conto alla rovescia Oggetto Negozio

**Nome:**

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**Valore restituito:**

| Parametro | Significato                       | Esempi                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | id Oggetto                       | 1                         |
| name       | nome Oggetto                     | play games for 30 minutes |
| time_left  | tempo rimanente (millisecondi) | 30000                     |

### Ciclo di vita Pomodoro

?> Questo evento broadcast è stato rilasciato in v1.101.0, con dati evento più ricchi.

**Nome:**

- Start: app.lifeup.pomodoro.start
- Pause: app.lifeup.pomodoro.pause (novità in v1.101.0)
- Stop: app.lifeup.pomodoro.stop
- Complete: app.lifeup.pomodoro.complete

**Descrizione:** Quando il timer Pomodoro parte, mette in pausa, si ferma o si completa, il sistema invia gli eventi broadcast corrispondenti con informazioni Compito, stato temporizzazione e altri dati dettagliati.

**Valore restituito:**

| Parametro          | Significato                       | Esempio        | Note                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | ID Compito                       | 1              | Opzionale; esiste solo quando il Pomodoro è associato a un Compito |
| task_gid           | ID gruppo Compito                 | 1              | Opzionale; esiste solo quando il Pomodoro è associato a un Compito |
| name               | Nome Compito                     | Study English  | Nome Compito associato al Pomodoro o nome personalizzato         |
| service_type       | Tipo servizio                  | 0              | 0=Concentrazione, 1=pausa breve, 2=pausa lunga                      |
| service_type_label | Etichetta tipo servizio            | Focus          | Testo tipo servizio localizzato                                |
| duration           | Durata totale (millisecondi) | 1500000        | Durata totale di Concentrazione o pausa                           |
| remaining          | Durata rimanente (millisecondi) | 900000     | Durata rimanente attuale                                 |
| elapsed            | Durata trascorsa (millisecondi) | 600000       | Durata trascorsa                                           |
| start              | Ora inizio                    | 1639123456789  | Timestamp Unix (millisecondi)                              |
| event_time         | Ora attivazione evento            | 1639123456789  | Timestamp Unix (millisecondi)                              |
| reason             | Motivo stop                   | user           | Solo per l'evento stop; valori possibili: manual, cancel, complete, auto |

**Descrizione motivo stop:**

Il parametro `reason` esiste solo nell'evento `app.lifeup.pomodoro.stop` e indica il motivo dell'arresto del Pomodoro:

- `manual`: Arresto manuale dall'utente
- `cancel`: Annullato dall'utente
- `complete`: Completato normalmente (Nota: al completamento viene attivato anche l'evento `app.lifeup.pomodoro.complete`)
- `auto`: Arresto automatico (ad es. Compito eliminato)

### Ciclo di vita timer positivo :id=broadcast_positive_timing

> [!NOTE]
> Questi eventi riguardano la funzione timer positivo, non gli eventi countdown Pomodoro sopra. Prima di usarli, assicurati che `Impostazioni` → `Labs` → `Modalità sviluppatore` → `Eventi broadcast` sia abilitato.

**Nome:**

- Start: app.lifeup.timing.start
- Pause: app.lifeup.timing.pause
- Complete: app.lifeup.timing.complete
- Abandon: app.lifeup.timing.abandon

**Descrizione:** Quando un timer positivo parte, mette in pausa, si completa o viene abbandonato manualmente, LifeUp invia il broadcast corrispondente. `complete` significa che la sessione è terminata normalmente ed è stata registrata. `abandon` significa che la sessione corrente è stata interrotta o scartata manualmente.

**Valore restituito:**

| Parametro | Significato                        | Esempi      | Note                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | ID Compito                        | 1             | Opzionale; presente solo quando il timer è collegato a un Compito |
| name       | Nome Compito                      | Study English | Nome Compito collegato o nome timer personalizzato          |
| time       | Durata accumulata (ms)      | 600000        | Durata totale trascorsa del timer positivo corrente |
| start      | Ora inizio                     | 1639123456789 | Timestamp Unix (millisecondi)                    |
| end        | Ora fine                       | 1639127056789 | Presente solo negli eventi `complete` / `abandon`    |

---

## Integrazione

Accogliamo con piacere qualsiasi forma di integrazione da altri sviluppatori.

> Presto verranno forniti altri dettagli...

### Servono altre API?

La funzionalità API è attualmente in una sola iterazione di versione.

In futuro continueremo ad aggiungere altre API per coprire più scenari d'uso.

Se ti servono altre API, puoi aprire Issue su [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### Come chiamare

#### Android

##### Usando l'SDK

Consulta il modulo `core` su: https://github.com/Ayagikei/LifeUp-SDK.

##### Senza usare l'SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Pagina web

Se la pagina web viene chiamata, se l'attivazione riesce dipende dal browser. Browser comuni come Quark, Chrome ed Edge vanno bene. Altri browser integrati di sistema possono chiedere all'utente «se aprire Rensheng» a ogni popup.

Se sviluppi la tua App WebView incorporata, devi assicurarti che la WebView gestisca lo schema lifeup.

Per un'esperienza coerente, puoi usare l'effetto link prodotto in `LifeUp` e selezionare «Use built-in browser» per aprirlo. Per le impostazioni di sicurezza, questo metodo supporta solo link HTTPS (non HTTP)

**HTML**

Salto diretto al collegamento ipertestuale

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

In realtà è anch'esso una chiamata tramite collegamento ipertestuale

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Sviluppatore App/Web/Automazione

Facci sapere se hai sviluppato qualcosa relativo a LifeUp!

<br/>

### Qualsiasi linguaggio/piattaforma che supporta il protocollo HTTP

Per i dettagli, consulta https://github.com/Ayagikei/LifeUp-SDK e [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).

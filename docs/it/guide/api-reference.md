# Riferimento API HTTP :id=http-query-reference

Questo riferimento descrive i parametri delle richieste LifeUp Cloud e i modelli completi di risposta HTTP. Per installazione, autorizzazione e connessione, iniziare da [LifeUp Cloud](/guide/api_cloud). I nuovi endpoint dei registri richiedono LifeUp **1.106.0+** e LifeUp Cloud **3.0.0+**; usare `/info` per identificare le versioni installate. Descrive i contratti del codice attuale, senza dimostrarne la disponibilità in una specifica versione.

## Indice delle interfacce :id=interface-index

| Risorsa | Metodi e percorsi | Parametri e modello |
| --- | --- | --- |
| Regole comuni | Risposte JSON, autorizzazione, condizioni della cache, paginazione | [Convenzioni](#representations), [cache e autenticazione](#auth-cache), [paginazione](#pagination) |
| Attività | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Query](#get-tasks), [modello attività](#task-fields), [categorie](#get-tasks-categories) |
| Cronologia attività | `GET /history` | [Parametri](#get-history), [timestamp](#task-times), [rapporti giornalieri](#daily-report) |
| Oggetti | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [ID degli oggetti, ID delle categorie e modelli completi](#get-items) |
| Attributi | `GET /skills`, `GET /skill_groups` | [Attributi e gruppi](#get-skills) |
| Obiettivi | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Obiettivi e condizioni](#get-achievements) |
| Sintesi | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Ricette e categorie](#get-synthesis) |
| Sensazioni | `GET /feelings` | [Sensazioni paginate](#get-feelings) |
| EXP / monete | `GET /exp_records`, `GET /coin_records` | [Parametri e modelli dei registri](#reward-journals) |
| Altri record | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventario](#get-inventory-records), [passi](#get-step-records) |
| Livelli / statistiche | `GET /level_defines`, `GET /statistics` | [Livelli](#get-level-defines), [statistiche](#get-statistics) |
| App / saldo | `GET /info`, `GET /coin` | [Informazioni versione](#get-info), [risultato monete](#get-coin) |
| Invocare azioni | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Ponte di invocazione](#invoke-api); i metodi funzionali restano nel [catalogo degli schemi URL](/guide/api) |
| File / backup | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [File](#files-download), [trasferimento backup](#files-backup) |
| Eventi | `GET /events`, WebSocket `/events` | [Polling ed eventi in tempo reale](#get-events) |
| Pagina iniziale | `GET /` | Introduzione HTML, non una risorsa JSON. |

MCP usa una rappresentazione separata per client/strumenti; vedere [differenze MCP](#mcp-differences) e la [guida MCP](/guide/api_mcp).

## Trasporto e rappresentazione :id=representations

| Interfaccia | Rappresentazione | Differenza importante |
| --- | --- | --- |
| Query HTTP di Cloud | JSON racchiuso in `{code, message, data}` | I riferimenti agli endpoint qui sotto descrivono questo JSON pubblico. |
| ContentProvider Android | Colonne Cursor, ad esempio `_ID` / `_GID`, talvolta contenenti testo JSON | Il parsing dell'SDK le converte in campi HTTP come `id` / `gid` e array annidati. Non usare le definizioni delle colonne Cursor come schema HTTP. |
| Azioni URL Scheme | `lifeup://api/{method}` e parametri/risultati specifici del metodo | I parametri di scrittura possono usare snake_case anche quando i campi HTTP in lettura usano camelCase. |
| Strumenti elenco MCP | Involucro specifico dello strumento e record compatti o dettagliati | La paginazione e i campi di output MCP sono comportamenti aggiuntivi del client, non campi della risposta HTTP. |

## Risposta ed errori :id=response-errors

L'involucro JSON HTTP comune è `HttpResponse<T>`:

| Campo | Tipo | Significato |
| --- | --- | --- |
| `code` | integer | `200` per una query riuscita; un valore diverso da `200` indica un errore. È un campo del corpo, distinto dallo stato HTTP. |
| `message` | string | Di solito `success` in caso di successo; altrimenti una descrizione dell'errore. |
| `data` | `T` o `null` | Valore specifico dell’endpoint (array, oggetto o stringa) in caso di successo; `null` in caso di errore. |

Esempio di elenco vuoto restituito correttamente:

```json
{"code":200,"message":"success","data":[]}
```

Esempio illustrativo di errore di autorizzazione/accesso al provider:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Segnale | Come gestirlo |
| --- | --- |
| HTTP `401` | Fornisci il token Cloud configurato come valore diretto dell'header `Authorization`. Non aggiungere `Bearer`. |
| Corpo `code = 10001` | Verifica che LifeUp sia installato/in esecuzione e che Cloud disponga del permesso Read LifeUp Data. |
| Corpo `code = 10002` | La query ContentProvider non è riuscita; esamina il messaggio di errore. |
| Altro stato/codice di mancato successo | Considera la query non riuscita, non un risultato vuoto. |

Controlla **sia** lo stato HTTP sia il `code` nel corpo. Alcuni errori delle route usano comunque HTTP `200` con un codice di errore nel corpo. Le azioni tramite `/api/contentprovider` richiedono anche di controllare ogni `data[].result.api_result`; il `code=200` dell'involucro non dimostra che tutte le azioni siano riuscite.

## Autorizzazione e letture condizionali :id=auth-cache

Se è configurato un token Cloud, inviarne il valore grezzo esatto in `Authorization`, senza anteporre `Bearer`. Il server accetta anche il parametro di query `token`, anche per client che non possono impostare un’intestazione WebSocket. Un token assente o errato produce HTTP `401` e `code=401` nel corpo. Il controllo copre pagina iniziale, risorse, ponte, file, trasferimento backup ed eventi.

Le letture riuscite di risorse JSON includono un `ETag` forte SHA-256 e `Cache-Control: private, no-cache`. Si applica a attività/cronologia, oggetti/categorie, attributi/gruppi, obiettivi/condizioni, sensazioni, sintesi/categorie, registri, livelli, statistiche, informazioni e monete. Non si applica al ponte di invocazione, ai trasferimenti di file/backup o ai flussi/polling degli eventi.

| Intestazione richiesta | Comportamento attuale |
| --- | --- |
| `If-Match` | Una versione diversa fallisce con HTTP `412`; valutato prima di `If-None-Match`. |
| `If-None-Match` | Una versione corrispondente restituisce HTTP `304` senza corpo JSON. Riutilizzare la rappresentazione riuscita nella cache. |

Gli involucri di errore non hanno intestazioni di versione della risorsa. Le letture condizionali valgono per singola richiesta, senza snapshot o transazioni tra pagine o route.

Le richieste del browser tra origini diverse possono usare `If-None-Match`. La configurazione CORS attuale non consente `If-Match` nella verifica preliminare; non fare affidamento su queste richieste senza modificare l’implementazione. I client nativi non sono soggetti al CORS del browser.

## Convenzioni comuni sui dati :id=data-conventions

| Convenzione | Regola |
| --- | --- |
| Tempo | I timestamp usano millisecondi Unix. I confini dei giorni di calendario dipendono dal fuso orario previsto. I singoli campi mantengono significati specifici della risorsa. |
| Identità | Il campo `id` del compito identifica un compito/ciclo; `gid` identifica il gruppo attraverso i cicli ripetuti. L'ID di una categoria/lista identifica una risorsa separata. |
| Valori vuoti | Assenza, `null`, `0`, `""` e `[]` sono distinti. Ogni modello documenta il proprio comportamento effettivo di ripiego o omissione. |
| ID numerici | Gli ID possono essere interi con segno a 64 bit; Number di JavaScript non rappresenta esattamente tutti i valori. Conservare gli ID grandi con un parser JSON adatto. |
| Array e oggetti | I valori HTTP annidati come `items` e `subTasks` sono array, non stringhe contenenti JSON. |
| Codici di stato e causale | Usa l'enumerazione documentata per quella risorsa. Stati dei compiti, stati degli obiettivi e causali dei registri appartengono a domini diversi. |

Vedi le [definizioni dei timestamp dei compiti](/guide/api-reference?id=task-times) per `startTime`, `deadline` ed `endTime`.

## Paginazione e filtri :id=pagination

La paginazione è una capacità dell'endpoint, non una proprietà di ogni elenco. Le risposte HTTP grezze degli elenchi contengono `data: [...]`; **non** aggiungono `total`, `count` o `hasMore`.

| Endpoint HTTP | Paginazione | Intervallo di date | Altri filtri |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | No; array completo | No | Categoria facoltativa nel percorso |
| `/history` | `offset` / `limit` lato server | No | `gid` facoltativo |
| `/feelings` | `offset` / `limit` lato server | No | Vedi il [sensazioni](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` lato server | `time_range_start` / `time_range_end` | Vedi l'endpoint specifico |
| `/statistics` | No; un oggetto | `time_range_start` / `time_range_end` | Query aggregata |
| `/coin`, `/info` | No; un oggetto | No | Query di risorsa singola |

Per gli endpoint paginati, i valori HTTP predefiniti sono `offset=0` e `limit=100`. Usa offset non negativi e dimensioni di pagina in `1..100` per un ciclo di paginazione condiviso. Il bridge HTTP non applica il limite MCP `1..100` e i provider a valle possono imporre altri limiti; consulta le note sulla dimensione effettiva della pagina e sulla validazione di ogni endpoint.

Salvo il [limite del pomodoro filtrato per tempo](#get-pomodoro-records), dopo ogni pagina riuscita aumentare `offset` del numero di record restituiti. Fermarsi quando è inferiore alla dimensione effettiva della pagina (il `limit` richiesto con `1..100`, escluso il pomodoro filtrato per tempo). Non confondere una pagina limitata dal provider con l’ultima pagina. Una pagina vuota oltre la fine è normale. Più pagine non formano uno snapshot: i record possono cambiare durante la query.

Nell'SDK HTTP attuale, i limiti temporali vengono inoltrati solo se **entrambi** sono interpretabili come interi e `start < end`. Un limite singolo, non interpretabile o invertito produce una query senza filtro; non affidarti a un errore per rilevarlo. Valida entrambi i limiti prima dell'invio. Il riferimento dei registri specifica il comportamento inclusivo dei limiti dei relativi endpoint.

## Differenze MCP :id=mcp-differences

Gli strumenti elenco MCP usano `limit=20` come predefinito, lo limitano a `1..100` e impongono a `offset` un minimo di `0`. Inviano la paginazione alle risorse paginate dal server, come cronologia/registri, ma recuperano gli array HTTP completi e li suddividono localmente per risorse come i compiti. I loro `items`, `count`, `hasMore` e `total` facoltativo appartengono all'involucro MCP. Anche `detail=false` rimuove campi da ogni record; usa `detail=true` quando serve il modello HTTP completo.

## Fonti e ambito delle versioni :id=api-common-sources

Questi riferimenti descrivono l'SDK pubblico attuale e il comportamento corrispondente del provider LifeUp. Gli esempi usano dati inventati. I collegamenti al codice sono riferimenti all'implementazione, non una prova che una specifica versione installata contenga ogni campo: [route HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [involucro HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [mappatura delle query MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## Modelli dei dati di compiti e cronologia :id=task-history-models

Questa pagina definisce il **JSON HTTP** restituito dalle [query su compiti e cronologia](/guide/api-reference?id=task-queries). Le colonne Cursor Android e i parametri delle azioni URL Scheme possono avere nomi e rappresentazioni diversi; vedi le [convenzioni comuni](/guide/api-reference?id=representations).

L'SDK usa un'unica classe serializzata `Task` per due viste. Qui `Task` indica la vista `/tasks` e `HistoryRecord` la vista `/history`. Questi nomi descrivono l'output esistente; non introducono un'altra API. La serializzazione attuale di Cloud include i valori predefiniti e i campi `null`.

### Campi di Task / HistoryRecord :id=task-fields

Tutti i campi seguenti compaiono nell'oggetto HTTP attuale. I valori mancanti del provider vengono spesso convertiti nei valori di ripiego elencati; un valore di ripiego non dimostra che il dato originale contenesse quel valore.

| Campo | Tipo JSON | Significato / valore di ripiego |
| --- | --- | --- |
| `id` | integer o `null` | ID di questo compito/ciclo. |
| `gid` | integer o `null` | ID del gruppo di compiti condiviso tra i cicli ripetuti. |
| `name` | string | Nome del compito. Se manca nel provider, diventa `ERROR: name is null`. |
| `notes` | string | Note; stringa vuota se assenti. |
| `status` | integer | Stato del compito; se manca, il valore predefinito è `0`. Vedi la tabella degli stati sotto. |
| `startTime` | integer | Ora di inizio configurata in millisecondi; valore di ripiego SDK `0`. |
| `deadline` | integer | Scadenza in millisecondi; valore di ripiego SDK `0` se assente. |
| `remindTime` | integer | Ora del promemoria in millisecondi; valore di ripiego SDK `0` se assente. |
| `frequency` | integer | Codice di ripetizione: `0` una volta, `1` ogni giorno, `-1` illimitato. Le altre modalità sono descritte nelle [azioni sui compiti](/guide/api). Valore di ripiego SDK `0`. |
| `weekdays` | string | Selezione dei giorni della settimana, ad es. `1,3,5` (lunedì `1`, domenica `7`); vuota se non fornita e segnaposto sempre vuoto nella cronologia. |
| `exp` | integer | Ricompensa EXP configurata, non importo di una transazione; predefinito `0`. |
| `skillIds` | integer array | Attributi associati alla ricompensa; array vuoto se non disponibili. |
| `coin` | integer | Ricompensa in monete configurata; predefinito `0`. |
| `coinVariable` | integer | Impostazione della ricompensa in monete casuali; predefinito `0`. |
| `itemId` | integer | ID del primo oggetto ricompensa, campo storico; predefinito `0`. Usa `items` per l'elenco completo. |
| `itemAmount` | integer | Quantità del primo oggetto ricompensa, campo storico; predefinito `0`. Questo nome HTTP differisce dalla colonna `itemCount` del provider. |
| `words` | string | Testo di incentivo al completamento; vuoto se assente. |
| `categoryId` | integer | ID della categoria/lista del compito; predefinito `0` se assente. |
| `order` | integer | Valore di ordinamento nella lista; segnaposto fisso `0` nella cronologia perché quel provider non restituisce la colonna. |
| `nameExtended` | string | Nome visualizzato esteso; segnaposto sempre vuoto nella cronologia perché quel provider non restituisce la colonna. |
| `endTime` | integer | Ora di fine registrata per la cronologia. `/tasks` la imposta a `0`; vedi la [semantica temporale](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Ricompense in oggetti; array vuoto se non disponibili. |
| `subTasks` | `SubTask[]` | Sottocompiti annidati; array vuoto se non disponibili. |
| `countProgress` | `TaskCountProgress` o `null` | Istantanea del progresso del conteggio quando disponibile; può comparire in entrambe le viste. |
| `repeatEndCondition` | `TaskRepeatEndCondition` o `null` | Regola di fine ripetizione in `/tasks`; sempre `null` in `/history`. |

### Stato e timestamp dei compiti :id=task-times

| `status` | Significato | Significato di `endTime` nella cronologia |
| --- | --- | --- |
| `0` | Non completato | Non è un'ora di completamento; `/history` seleziona invece i record terminati. |
| `1` | Completato | Ora di completamento registrata. |
| `2` | Scaduto | Ora di scadenza registrata. |
| `3` | Abbandonato | Ora di abbandono registrata. |

| Campo temporale | Definizione |
| --- | --- |
| `startTime` | Ora di inizio configurata/pianificata del compito, non il momento in cui l'utente ha effettivamente iniziato a lavorare. |
| `deadline` | Scadenza pianificata, distinta dall'ora di fine registrata. |
| `endTime` | Ora registrata in cui il compito nella cronologia è terminato; interpretala insieme a `status` come sopra. |

Tutti e tre usano millisecondi Unix. Per un completamento normale, l'app registra l'ora corrente. `history_operation` con `operation=edit_completed_time` accetta un valore `completed_time` e modifica questa stessa ora di completamento salvata; la lettura della cronologia restituisce comunque il campo `endTime`.

Le ore salvate possono essere modificate. Se un record terminato non ha una data di fine salvata, l'app usa l'ora corrente. Di conseguenza, `endTime` è l'ora attualmente registrata, non un timestamp di audit immutabile. Il valore `0` in `/tasks` è solo un segnaposto dell'SDK, non un evento reale all'epoca Unix.

### RewardItem :id=reward-item

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `itemId` | integer | ID dell'oggetto ricompensa. |
| `itemCount` | integer | Quantità della ricompensa. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Campo | Tipo JSON | Significato / predefinito |
| --- | --- | --- |
| `id` | integer | ID del sottocompito. |
| `gid` | integer | ID del gruppo di sottocompiti. |
| `todo` | string | Testo del sottocompito. |
| `status` | integer | `0` non completato, `1` completato. |
| `remindTime` | integer o `null` | Timestamp del promemoria in millisecondi; `null` se non disponibile. |
| `endTime` | integer o `null` | Timestamp di completamento del sottocompito in millisecondi; `null` se non disponibile. |
| `exp` | integer | Ricompensa EXP configurata. |
| `coin` | integer o `null` | Ricompensa in monete configurata. |
| `coinVariable` | integer o `null` | Impostazione della ricompensa in monete casuali. |
| `items` | `RewardItem[]` | Ricompense in oggetti; array vuoto predefinito. |
| `order` | integer o `null` | Valore di ordinamento; predefinito del modello `0`. |
| `autoUseItem` | boolean o `null` | Se le ricompense vengono usate automaticamente; predefinito del modello `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `currentCount` | integer | Conteggio attuale per questo compito/ciclo. |
| `targetCount` | integer | Conteggio obiettivo per questo compito/ciclo. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Campo | Tipo JSON | Significato / predefinito |
| --- | --- | --- |
| `mode` | string | `COUNT` o `DATE`. Sono stringhe di lettura, non i parametri numerici delle azioni. |
| `behavior` | string | `TERMINATE` o `FREEZE`. |
| `targetCycleCount` | integer o `null` | Numero di cicli obiettivo per `COUNT`; predefinito `null`. |
| `endDateMillis` | integer o `null` | Timestamp della data di fine in millisecondi per `DATE`; predefinito `null`. |
| `inclusive` | boolean | Indicatore di inclusione della data di fine; predefinito `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Importi delle ricompense :id=reward-amounts

Questi campi dei compiti e sottocompiti descrivono ricompense configurate. Moltiplicatori, monete casuali e regole di liquidazione possono modificare la ricompensa effettiva. Usa i [registri EXP e monete](/guide/api-reference?id=reward-journals) per gli importi delle transazioni e distingui le ricompense positive dalle variazioni nette che includono storni o penalità.

### Riferimenti all'implementazione :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Parser dei dati](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Progresso del conteggio](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Regola di ripetizione](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## Query su compiti e cronologia :id=task-queries

Leggi le [convenzioni comuni](/guide/api-reference?id=http-query-reference) e il [modello completo di Task/History](/guide/api-reference?id=task-history-models). Questi endpoint richiedono il permesso Read LifeUp Data di Cloud. Le query di base sugli elenchi sono documentate per LifeUp v1.91+ con l'ultima versione di Cloud; gli esempi descrivono i campi dell'SDK attuale. Controlla `/info` per le integrazioni con installazioni precedenti.

### GET /tasks e /tasks/{categoryId} :id=get-tasks

Interroga l'elenco attuale dei compiti **non completati**, eventualmente limitato a una categoria/lista. Il risultato è un array completo, non una risposta paginata dal server. I record completati, scaduti e abbandonati appartengono a `/history`.

| Parametro | Posizione | Tipo | Obbligatorio | Predefinito / comportamento |
| --- | --- | --- | --- | --- |
| `categoryId` | Percorso | integer | Solo per `/tasks/{categoryId}` | Ometti l'intero segmento del percorso per l'elenco dei compiti senza restrizioni. |

Queste route non supportano parametri di query `offset`, `limit`, `gid` o intervalli di date. Un segmento di categoria non intero viene attualmente interpretato come categoria assente; validalo prima della richiesta per evitare di interrogare involontariamente tutti i compiti.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Risposta:** `HttpResponse<Task[]>`. Tutti i campi e le strutture annidate sono definiti nei [campi Task/History](/guide/api-reference?id=task-fields). Il seguente record inventato mostra la struttura HTTP completa al livello principale; `endTime=0` è un segnaposto per questa route, non un timestamp di completamento.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Comportamento ed errori:** selezione e ordinamento seguono la logica delle liste di LifeUp; questo endpoint non garantisce un ordinamento per ora di completamento. Un `data: []` restituito correttamente indica che la lista selezionata non ha restituito record. Gli errori di autorizzazione/provider usano l'[involucro comune degli errori](/guide/api-reference?id=response-errors); non sono array vuoti. Per i rapporti sui completamenti usa `/history` qui sotto, anziché `endTime` di questa route.

### GET /history :id=get-history

Interroga i record visibili dei compiti terminati, inclusi compiti completati, scaduti e abbandonati. La cronologia eliminata è esclusa.

| Parametro | Posizione | Tipo | Obbligatorio | Predefinito / comportamento |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | `0`; numero di record da saltare, con indice iniziale zero. |
| `limit` | Query | integer | No | `100`; richiedi una dimensione di pagina positiva, preferibilmente `1..100`. |
| `gid` | Query | integer | No | Nessun filtro di gruppo; se presente, seleziona quel gruppo di compiti attraverso i cicli. |

Il parser HTTP usa `0` / `100` per `offset` / `limit` non interpretabili e ignora un `gid` non interpretabile. Questa route non limita i numeri analizzati. Valida tu stesso offset non negativi e limiti positivi. `time_range_start` / `time_range_end` **non sono supportati**; fornirli non filtra la cronologia.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Risposta:** `HttpResponse<HistoryRecord[]>`, con i [campi di trasporto Task/History](/guide/api-reference?id=task-fields). `HistoryRecord` è il nome documentale della vista cronologia del modello `Task` dell'SDK. In questa vista `repeatEndCondition` è `null`; `countProgress` può essere presente. L'`endTime` salvato va interpretato con `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Ordinamento:** data di fine salvata decrescente, dalla più recente. Non è documentato un criterio di spareggio per date uguali. La paginazione non è un'istantanea; evita di modificare i dati durante la raccolta di un rapporto e deduplica i record per `id` quando unisci le pagine.

**Paginazione e risultati vuoti:** usa la [procedura di paginazione condivisa](/guide/api-reference?id=pagination). Un array vuoto restituito correttamente indica che nessun record visibile corrisponde alla pagina/gruppo, anche quando `offset` supera la fine. Non certifica che non sia mai avvenuta alcuna attività: i record eliminati sono esclusi e manca un indicatore di completezza. Se una richiesta fallisce, segnala dati non disponibili/incompleti anziché zero compiti. Si applicano gli [errori comuni](/guide/api-reference?id=response-errors).

### Creare un rapporto giornaliero :id=daily-report

1. Scegli il fuso orario del rapporto. Calcola l'inizio del giorno di calendario (`dayStart`) e l'inizio del giorno successivo (`nextDayStart`). Non presumere che ogni giorno locale duri esattamente 24 ore.
2. Leggi `/history` con `offset=0&limit=100`, controlla ogni risposta e raccogli tutte le pagine. Mantieni coerente l'eventuale filtro `gid` previsto.
3. Seleziona `status == 1` e `dayStart <= endTime < nextDayStart`. Tieni conto dei [limiti delle ore registrate](/guide/api-reference?id=task-times) nel descrivere i risultati.
4. Per le variazioni effettive di EXP e monete, leggi i [registri delle ricompense](/guide/api-reference?id=reward-journals) per lo stesso giorno. I filtri di data includono entrambi gli estremi, quindi usa `time_range_start=dayStart` e `time_range_end=nextDayStart-1`.
5. Distingui «nessun record trovato nei dati disponibili» da una lettura fallita/incompleta. Decidi se il rapporto mostra solo ricompense positive o variazioni nette inclusi gli storni e applica la scelta in modo coerente.

I valori `exp` e `coin` di compiti/cronologia sono ricompense configurate; non sostituiscono in modo affidabile gli importi dei registri. Spostare l'ora di completamento a un altro giorno non implica che anche l'ora della transazione nel registro delle ricompense si sia spostata.

### Riferimenti all'implementazione :id=api-task-queries-sources

[Route HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Parsing di compiti e cronologia](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## Query sui registri EXP e monete :id=reward-journals

Questi endpoint HTTP di sola lettura richiedono il permesso Read LifeUp Data, LifeUp **1.106.0+** e LifeUp Cloud **3.0.0+**. Restituiscono le variazioni registrate, incluse diminuzioni e storni, anziché la configurazione delle ricompense dei compiti. Leggi prima le [convenzioni comuni](/guide/api-reference?id=http-query-reference).

### Parametri di richiesta per entrambi gli endpoint :id=journal-parameters

Il seguente contratto si applica specificamente a **entrambi** `GET /exp_records` e `GET /coin_records`.

| Parametro | Posizione | Tipo | Obbligatorio | Predefinito / comportamento effettivo |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | No | Predefinito HTTP `0`; il provider porta a `0` i valori negativi. |
| `limit` | Query | integer | No | Predefinito HTTP `100`; il provider limita a `1..200`. Usa `1..100` per la procedura di paginazione condivisa. |
| `time_range_start` | Query | integer (Unix milliseconds) | No, oppure in coppia | Limite inferiore incluso dell'ora registrata della transazione. |
| `time_range_end` | Query | integer (Unix milliseconds) | No, oppure in coppia | Limite superiore incluso; il filtro valido richiede `start < end`. |

I valori di paginazione non interpretabili o fuori intervallo usano i predefiniti HTTP. I valori di data non interpretabili diventano assenti. L'SDK attuale inoltra un intervallo di date solo se entrambi i limiti esistono e `start < end`; altrimenti esegue la query **senza filtro di data**. Le chiamate dirette al ContentProvider grezzo validano diversamente gli intervalli non validi. Valida i limiti nel chiamante HTTP.

Entrambi gli endpoint ordinano per ora registrata della transazione decrescente, dalla più recente, ed escludono le voci eliminate. Non garantiscono uno spareggio per ID né un'istantanea tra più pagine. Segui la [paginazione](/guide/api-reference?id=pagination), considerando il limite effettivo del provider. Un array vuoto restituito correttamente indica che nessuna voce corrisponde all'intervallo/pagina; una lettura fallita non equivale ad assenza di attività. Nessun endpoint fornisce un indicatore di completezza per dati eliminati o non disponibili.

### GET /exp_records :id=get-exp-records

Interroga le variazioni EXP. I parametri sono esattamente i [quattro parametri dei registri sopra](/guide/api-reference?id=journal-parameters); non esiste un filtro `gid`.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Risposta:** `HttpResponse<ExpRecord[]>`. La serializzazione attuale include tutti i campi elencati, compresi i valori nullable.

| Campo | Tipo JSON | Significato / valore di ripiego del parser |
| --- | --- | --- |
| `id` | integer o `null` | ID della voce del registro. |
| `time` | integer o `null` | Ora della transazione in millisecondi Unix, distinta dall'ora di completamento modificabile di un compito. |
| `value` | integer | Variazione EXP per ogni attributo associato; ripiego `0`. Usa `isDecrease` per la direzione. |
| `isDecrease` | boolean | `true` per una diminuzione, `false` per un aumento; il parser interpreta l'intero `1` del provider come true. |
| `totalValue` | integer | Variazione EXP aggregata registrata, **non un saldo EXP**; ripiego `0`. I gruppi con più attributi possono sovrapporsi in questo totale memorizzato; vedi i [totali dei rapporti](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | Codice causale specifico per EXP; ripiego `0`. |
| `relatedId` | integer o `null` | ID dell'oggetto sorgente correlato. Nel normale completamento di un compito è l'`id` del record del compito, non il suo `gid`. Altre causali possono riferirsi ad altre risorse. |
| `content` | string o `null` | Descrizione della variazione. |
| `skillIds` | integer array | ID degli attributi/abilità associati; ripiego array vuoto. |
| `relatedAttributes` | string array | Stringhe degli attributi associati nel formato storico; ripiego array vuoto. |

Esempio inventato: 10 EXP applicati a ciascuno di due attributi, 20 EXP complessivi.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Errori:** [errori comuni HTTP/provider](/guide/api-reference?id=response-errors). Come spiegato sopra, limiti di data HTTP non validi possono rimuovere silenziosamente il filtro, anziché produrre un errore.

### GET /coin_records :id=get-coin-records

Interroga le variazioni di monete. I parametri sono esattamente i [quattro parametri dei registri sopra](/guide/api-reference?id=journal-parameters); non esiste un filtro `gid`.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Risposta:** `HttpResponse<CoinRecord[]>`. La serializzazione attuale include tutti i campi elencati, compresi i valori nullable.

| Campo | Tipo JSON | Significato / valore di ripiego del parser |
| --- | --- | --- |
| `id` | integer o `null` | ID della voce del registro. |
| `time` | integer o `null` | Ora della transazione in millisecondi Unix. |
| `value` | integer | Importo della variazione di monete; ripiego `0`. Usa `isDecrease` per la direzione. |
| `isDecrease` | boolean | `true` per una diminuzione, `false` per un aumento; il parser interpreta l'intero `1` del provider come true. |
| `totalValue` | integer | Saldo monete dopo l'operazione; ripiego `0`. A differenza del `totalValue` EXP, questo è un saldo. |
| `resCode` | integer | Codice causale specifico per monete; ripiego `0`. |
| `relatedId` | integer o `null` | ID dell'oggetto sorgente correlato; il normale completamento usa l'`id` del record del compito. Interpreta le altre sorgenti tramite il relativo codice causale. |
| `content` | string o `null` | Descrizione della variazione. |
| `savingBalance` | integer o `null` | Saldo risparmi registrato per l'operazione. |

Esempio inventato: una diminuzione di 5 monete, con un saldo monete risultante di 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Errori:** [errori comuni HTTP/provider](/guide/api-reference?id=response-errors). Come spiegato sopra, limiti di data HTTP non validi possono rimuovere silenziosamente il filtro, anziché produrre un errore.

### Codici causali e totali dei rapporti :id=journal-totals

I domini dei codici causali sono diversi. Alcuni esempi:

| Causale | EXP `resCode` | Monete `resCode` |
| --- | --- | --- |
| Completa compito | `1` | `2` |
| Annulla completamento compito | `101` | `3` |
| Completa sottocompito | `12` | `11` |
| Annulla sottocompito | `106` | `12` |
| Modifica tramite API | `200` | `28` |

Codici EXP completi: `0` sconosciuto; `1` compito completato; `2` obiettivo; `3` scambio di mi piace; `4` serie di giorni di utilizzo; `5` scambio di passi; `6` imposta come completato; `7` annulla abbandono; `8` annulla scadenza; `9` mangia pomodoro; `10` usa oggetto; `11` sblocco obiettivo utente; `12` sottocompito completato; `200` API; `101` annulla completamento; `102` abbandono; `103` scadenza; `104` utilizzo oggetto che riduce EXP; `105` blocco rinnovato obiettivo utente; `106` annulla completamento sottocompito. I codici motivo delle monete usano lo stesso dominio dei [record dell’inventario](#get-inventory-records). Conservare i futuri codici sconosciuti. Per una variazione netta, applica la direzione con `isDecrease` (`true` sottrae l'importo registrato). Non presumere che una diminuzione sia codificata come `value` negativo; i tipi numerici sono con segno e non è dichiarata alcuna garanzia di valori senza segno/assoluti.

Il `value` EXP è per attributo. Non sommare indiscriminatamente il `totalValue` EXP tra record: la logica attuale di raggruppamento di più attributi può memorizzare totali sovrapposti quando sono coinvolti più di tre attributi. Ad esempio, una variazione di 10 EXP per ciascuno di quattro attributi può produrre totali memorizzati di 40 e 10, anziché una somma affidabile di 40. Per rapporti precisi, riconcilia il `value` per attributo con gli attributi elencati su ogni record; associazioni mancanti limitano ciò che si può stabilire. Non sommare `value` e `totalValue` e non descrivere il `totalValue` EXP come un saldo.

Per un giorno di calendario, calcola `dayStart` e `nextDayStart` locali, poi richiedi `[dayStart, nextDayStart - 1]` perché entrambi i limiti sono inclusivi. Seleziona i codici causali per rapporti limitati alle ricompense dei compiti; non filtrarli per rapporti su tutte le variazioni registrate. [Procedura per i rapporti giornalieri](/guide/api-reference?id=daily-report).

### Riferimenti all'implementazione :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Inoltro dei parametri di data](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Oggetti e categorie :id=get-items

`GET /items` restituisce `ShopItem[]`. Il parametro facoltativo ripetuto `id` seleziona gli ID degli oggetti: `/items?id=1&id=2`. I valori non interi vengono scartati. Gli ID inesistenti vengono saltati; quelli validi mantengono l’ordine richiesto, inclusi i duplicati. Se sono tutti non validi, l’SDK non invia il filtro e restituisce l’elenco normale. Nessuna paginazione.

`GET /items/{listId}` restituisce `ShopItem[]` di una **categoria**, non un singolo oggetto. `listId` è un ID di categoria intero con segno a 64 bit; `-1` indica tutte. Un valore non valido seleziona tutte. L’elenco normale esclude oggetti rimossi/eliminati (`isDel=0`) e segue l’ordinamento configurato di negozio/categoria. La selezione per ID può recuperare un oggetto indipendentemente da tale filtro.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID dell’oggetto. |
| `name` | string | Nome dell’oggetto. |
| `desc` | string | Descrizione. |
| `icon` | string | URI dell’immagine leggibile o stringa vuota. Scaricare tramite `/files/{url}`. |
| `categoryId` | integer | ID della categoria del negozio. |
| `stockNumber` | integer | Scorte disponibili; le scorte negative sono considerate illimitate nel calcolo di `maxPurchaseNumber`. |
| `ownNumber` | integer | Quantità posseduta nell’inventario. |
| `price` | integer | Prezzo in monete. |
| `order` | integer | Ordine memorizzato nella categoria. |
| `disablePurchase` | boolean | Indicatore di acquisto disabilitato. |
| `maxPurchaseNumber` | integer o null | Calcolato da monete disponibili più credito e scorte finite; gli acquisti disabilitati danno 0, le scorte gratuite illimitate possono dare 2147483647. Non valuta tutte le regole sui limiti di acquisto. |
| `titleColorString` | string o null | Colore personalizzato del titolo. |
| `actionText` | string o null | Testo personalizzato del pulsante di utilizzo. |
| `unlist` | boolean | Indicatore di rimozione/eliminazione; normalmente false negli elenchi. |
| `disableUse` | boolean | Se l’oggetto ha un effetto che ne impedisce l’utilizzo. |
| `purchaseLimit` | string o null | **Stringa codificata in JSON**, non un array annidato; configurazione dei limiti di acquisto dell’oggetto. |
| `limitScope` | string o null | `purchase`, `use` o `both`. |

### GET /items_categories :id=get-items-categories

Restituisce `ShopCategory[]`. `include_hidden` è facoltativo, predefinito `false`; vengono riconosciute solo le stringhe esatte minuscole `true` e `false`, gli altri valori danno false. Include la categoria virtuale «Tutte». Il server HTTP non espone `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della categoria. |
| `name` | string | Nome della categoria. |
| `isAsc` | boolean | Indicatore configurato di ordinamento crescente. |
| `sort` | string | Preferenza di ordinamento memorizzata. |
| `order` | integer | Ordine della categoria. |
| `hidden` | boolean | Nascosta nel negozio. |
| `inventoryHidden` | boolean | Nascosta nell’inventario. |

### GET /tasks_categories :id=get-tasks-categories

Restituisce `TaskCategory[]`, inclusa la categoria «Tutte» e quelle archiviate. Nessun parametro o paginazione. Il server HTTP non espone `/tasks_categories/{id}`. I valori di ordinamento/filtro sono preferenze memorizzate dell’App; questo endpoint non li applica come filtri della richiesta.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della categoria. |
| `name` | string | Nome. |
| `isAsc` | boolean | Indicatore memorizzato di ordinamento crescente. |
| `sort` | string | Preferenza di ordinamento memorizzata. |
| `filter` | string | Preferenza memorizzata di raggruppamento/filtro. |
| `order` | integer | Ordine della categoria. |
| `status` | integer | 0 normale; 1 archiviata. |
| `type` | integer | 0 normale; elenchi intelligenti: 10 giornaliero, 11 settimanale, 12 mensile, 20 in corso. |

## Attributi e gruppi di attributi :id=get-skills

`GET /skills` restituisce `Skill[]`, senza parametri o paginazione. Esclude gli attributi nascosti/eliminati e usa l’ordine memorizzato. `group_id` e `status` del ContentProvider sottostante **non** sono campi del modello HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID dell’attributo. |
| `name` | string | Nome localizzato dell’attributo. |
| `desc` | string | Descrizione. |
| `icon` | string | URI dell’icona leggibile o vuota. |
| `order` | integer | Ordine memorizzato. |
| `color` | integer | Intero del colore compattato Android. |
| `exp` | integer | EXP totale attuale. |
| `level` | integer | Livello attuale. |
| `untilNextLevelExp` | integer | EXP rimanente prima del livello successivo. |
| `currentLevelExp` | integer | EXP guadagnata dall’inizio del livello attuale. |
| `type` | integer | 0 utente; 1 forza; 2 apprendimento; 3 fascino; 4 resistenza; 5 vitalità; 6 creatività. |

### GET /skill_groups :id=get-skill-groups

Restituisce `SkillGroup[]`. `include_hidden` usa la stessa analisi booleana rigorosa di `/items_categories`, predefinita false. Il repository attuale dell’App ignora questo indicatore per i gruppi ed esclude sempre quelli eliminati. Ordine memorizzato crescente. Nessuna paginazione.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID del gruppo. |
| `content` | string | Titolo del gruppo. |
| `order` | integer | Ordine memorizzato del gruppo. |
| `collapsed` | boolean | Stato compresso. |

## Obiettivi :id=get-achievements

`GET /achievements` restituisce `Achievement[]` caricando ogni categoria nel relativo ordine e concatenandone gli obiettivi. `GET /achievements/{id}` restituisce gli obiettivi **della categoria `id`**, non il dettaglio di un obiettivo. Gli ID di percorso non validi equivalgono alla route senza filtro. L’ordine interno segue la preferenza della categoria nell’App. Nessuno dei due endpoint è paginato.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID dell’obiettivo raggiunto. |
| `name` | string | Titolo. |
| `desc` | string | Descrizione. |
| `iconUri` | string | URI dell’icona o vuota. |
| `categoryId` | integer | ID della categoria. |
| `status` | integer | 0 incompleto; 1 completato con ricompensa non riscossa; 2 ricompensa riscossa/altro stato completato. |
| `exp` | integer | Ricompensa in EXP. |
| `coin` | integer | Ricompensa in monete. |
| `coinVariable` | integer | Ricompensa variabile in monete. |
| `type` | integer | 0 obiettivo; 1 intestazione di sottocategoria. |
| `progress` | integer | Avanzamento memorizzato. |
| `order` | integer | Ordine nella categoria. |
| `itemId` | integer o null | ID del primo oggetto ricompensa (campo ausiliario precedente). |
| `itemAmount` | integer o null | Quantità del primo oggetto ricompensa. |
| `unlockedTime` | integer o null | Ora di sblocco in millisecondi Unix. |
| `items` | RewardItem[] o null | Elenco completo degli oggetti ricompensa; il parser attuale restituisce un array vuoto se il JSON è assente o malformato. |
| `color` | string o null | Colore personalizzato del titolo. |

Gli oggetti ricompensa usano il modello condiviso [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Restituisce `AchievementCategory[]`, senza parametri o paginazione. Il server HTTP non espone `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della categoria. |
| `name` | string | Nome. |
| `desc` | string | Descrizione. |
| `iconUri` | string | URI/stringa dell’icona. |
| `isAsc` | boolean | Indicatore di ordinamento crescente. |
| `sort` | string | Preferenza di ordinamento memorizzata. |
| `filter` | string | Preferenza memorizzata di raggruppamento/filtro. |
| `order` | integer | Ordine della categoria. |
| `type` | integer | 0 obiettivi utente; 1 obiettivi di sistema. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Restituisce `AchievementCondition[]` per l’ID di **obiettivo** `id`. Un ID non intero produce un involucro di errore con codice 500. Se non vi sono condizioni corrispondenti restituisce un array vuoto. Non esiste una route di raccolta `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della condizione. |
| `type` | integer | Codice della condizione; vedere sotto. |
| `relatedId` | integer | Identificatore di attività/oggetto/attributo correlato secondo la condizione. |
| `target` | integer | Valore obiettivo. |
| `current` | integer | Valore cumulativo attuale. |
| `progress` | integer | Avanzamento memorizzato. |

Codici condizione: 0 attività completate; 1 serie attuale dell’attività; 2 precedente livello attributo; 3 pomodori; 4 giorni di utilizzo dell’App; 5 mi piace; 6 giorni consecutivi di completamento; 7 monete attuali; 8 monete guadagnate in un giorno; 9 pomodori dell’attività; 10 acquisti di oggetti; 11 utilizzi di oggetti; 12 oggetti ottenuti da forzieri; 13 livello attributo; 14 livello vita; 15 oggetti ottenuti cumulativi; 16 oggetti ottenuti per sintesi; 17 quantità attualmente posseduta; 18 tempo di concentrazione dell’attività; 19 risparmi ATM; 20 API esterna. Condizioni ripetute: 500 attività completate; 501 aumenti livello attributo; 502 pomodori; 503 monete; 504 oggetti ottenuti; 505 acquisti di oggetti; 506 ricavi da forzieri; 507 ricavi da sintesi; 508 utilizzi di oggetti; 509 minuti di concentrazione attività; 510 pomodori attività; 511 mi piace; 512 aumenti risparmi ATM; 513 chiamate API esterne; 514 giorni di utilizzo; 515 aumenti livello vita; 516 monete giornaliere; 517 attività completate consecutivamente; 518 pomodori giornalieri; 519 minuti giornalieri di concentrazione; 520 gruppi di attività distinti giornalieri; 521 utilizzi giornalieri di oggetti; 522 acquisti giornalieri di oggetti; 523 completamenti giornalieri di un’attività specifica; 524 record totali giornalieri di attività completate. Sono codici interi grezzi, non nomi di enumerazioni serializzati.

## Sintesi :id=get-synthesis

`GET /synthesis` restituisce `Synthesis[]` dalle categorie visibili. `GET /synthesis/{id}` restituisce le ricette **della categoria `id`**, inclusi i contenuti nascosti. Gli ID non negativi selezionano una categoria; quelli negativi tutte le categorie visibili. Gli ID non validi usano la route di raccolta. I risultati seguono l’ordine memorizzato crescente delle ricette; quelle eliminate sono escluse. Nessuna paginazione.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della ricetta. |
| `name` | string | Nome. |
| `desc` | string | Descrizione. |
| `input` | SynthesisItemInfo[] | Oggetti richiesti. |
| `output` | SynthesisItemInfo[] | Oggetti prodotti. |
| `categoryId` | integer o null | ID della categoria. |
| `canSynthesisTimes` | integer | Numero di sintesi attualmente disponibili. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `itemId` | integer | ID dell’oggetto. |
| `itemName` | string | Nome dell’oggetto. |
| `amount` | integer | Quantità in ingresso/uscita per sintesi. |
| `ownedNumber` | integer | Quantità posseduta. |
| `icon` | string | URI dell’icona leggibile o vuota. |

### GET /synthesis_categories e /synthesis_categories/{id} :id=get-synthesis-categories

Entrambi restituiscono `SynthesisCategory[]`. Il parametro di percorso facoltativo `id` filtra l’ID categoria senza cambiare la forma dell’array. Gli ID non validi selezionano tutte le categorie. `include_hidden` è facoltativo, usa booleani minuscoli rigorosi e vale false per impostazione predefinita anche quando è specificata una categoria. Nessuna paginazione.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della categoria. |
| `name` | string | Nome. |
| `isAsc` | boolean | Indicatore memorizzato di ordinamento crescente. |
| `sort` | string | Preferenza di ordinamento memorizzata. |
| `order` | integer | Ordine della categoria. |
| `hidden` | boolean | Indicatore nascosto. |

## Sensazioni :id=get-feelings

`GET /feelings` restituisce `Feelings[]`. `offset` vale 0 e `limit` 100 per impostazione predefinita; valori assenti o non interi usano tali valori. Nessun limite esplicito. Usare offset non negativi e limiti positivi. Le sensazioni eliminate sono escluse. L’ordine segue la preferenza dell’App (`createTime` crescente o decrescente), non un parametro. Nessun filtro temporale disponibile.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della sensazione. |
| `content` | string | Testo. |
| `isFav` | boolean | Indicatore preferito. |
| `title` | string | Titolo correlato. |
| `time` | integer | Ora di creazione in millisecondi Unix. |
| `attachments` | string[] | URI leggibili degli allegati per file esistenti non vuoti. |
| `type` | integer | 0 attività; 1 obiettivo; 2 voce indipendente. |

## Record del pomodoro :id=get-pomodoro-records

`GET /pomodoro_records` restituisce `PomodoroRecord[]`. Valori predefiniti: `offset` 0, `limit` 100; nessun limite esplicito. `time_range_start` e `time_range_end` facoltativi sono millisecondi Unix. L’SDK inoltra l’intervallo solo se entrambi sono interi a 64 bit e l’inizio è minore della fine; altrimenti lo omette silenziosamente.

Senza intervallo, restituisce i record completati non eliminati con `startTime != endTime` e `endTime` positivo, ordinati per `endTime DESC, startTime DESC, id DESC`. Un intervallo valido seleziona `start < endTime <= end` ed esclude le righe eliminate.

> [!WARNING]
> Le implementazioni precedenti passavano `limit` e `offset` al DAO in posizioni invertite nelle query per intervallo, senza specificare l’ordine. Il codice locale di LifeUp ora usa argomenti con nome e ordina i risultati paginati per `endTime DESC, startTime DESC, id DESC`; questa correzione locale non è ancora stata pubblicata. Finché non si conferma che la versione installata di LifeUp la include, omettere l’intervallo e filtrare le righe nel client per una paginazione affidabile.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID del record. |
| `startTime` | integer o null | Inizio in millisecondi Unix. |
| `endTime` | integer o null | Fine in millisecondi Unix. |
| `duration` | integer | Millisecondi: `lastTime` memorizzato se diverso da zero, altrimenti fine meno inizio. |
| `reward` | number | Pomodori guadagnati: abbandonato = 0; metà = 0,5 × moltiplicatore; altrimenti moltiplicatore. |

## Record dell’inventario :id=get-inventory-records

`GET /inventory_records` restituisce `InventoryRecord[]`. `offset` vale 0 per impostazione predefinita ed è limitato a un minimo di 0; `limit` vale 100 ed è limitato a 1–200. `time_range_start` e `time_range_end` facoltativi vengono inoltrati solo se sono interi a 64 bit e inizio < fine; l’SDK omette silenziosamente intervalli non validi/incompleti. Gli intervalli validi usano estremi inclusivi `time >= start AND time <= end`. I record eliminati sono esclusi (`isDel` null o 0); ordine `time DESC, id DESC`. Nessun filtro per ID oggetto.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID del record. |
| `time` | integer o null | Ora di creazione in millisecondi Unix. |
| `itemId` | integer o null | ID dell’oggetto correlato. |
| `itemName` | string o null | Nome dell’oggetto correlato, se disponibile. |
| `changeNumber` | integer | Variazione di quantità registrata. |
| `isDecrease` | boolean | Se la variazione riduce l’inventario. |
| `resCode` | integer | Codice del motivo di origine; vedere sotto. |
| `desc` | string o null | Descrizione del record. |

Codici motivo: 0 acquisto; 1 utilizzo; 2 attività completata; 3 annulla completamento; 4 cancella dati; 5 abbandona attività; 6 attività scaduta; 7 sblocco obiettivo integrato; 8 annulla abbandono; 9 annulla scadenza; 10 restituzione oggetto; 11 sottoattività completata; 12 annulla sottoattività; 13 sblocco obiettivo utente; 14 annulla obiettivo utente; 15 deposito; 16 prelievo; 17 vendita pomodori; 20 oggetto ricompensa; 21 annulla ricompensa; 23 sintesi; 24 forziere; 25 interessi ATM; 26 scambio pomodori con oggetto; 27 interessi credito; 28 API; 29 variazione scorte da effetto oggetto. I client dovrebbero conservare i futuri codici sconosciuti.

## Record dei passi :id=get-step-records

`GET /step_records` restituisce `StepRecord[]`. Valori e limiti di paginazione e regole SDK di omissione degli intervalli corrispondono a `/inventory_records`. Il filtro temporale valido è inclusivo su `date`; ordine `date DESC` senza chiave secondaria esplicita.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID del record. |
| `date` | integer o null | Data registrata in millisecondi Unix. |
| `dailyStepCount` | integer | Numero di passi giornalieri. |
| `totalStepCount` | integer | Numero cumulativo di passi memorizzato. |
| `isGotReward` | boolean | Indicatore di ricompensa riscossa. |
| `isUserInput` | boolean | Indicatore di inserimento utente. |
| `rewardLevel` | integer o null | Livello di ricompensa memorizzato. |

## Definizioni dei livelli :id=get-level-defines

`GET /level_defines` restituisce un singolo oggetto `LevelDefines`. Nessun parametro. Usa definizioni personalizzate quando la relativa modalità livelli è attiva, altrimenti quelle integrate.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `custom` | boolean | Modalità livelli personalizzati. |
| `levels` | LevelDefine[] | Intervalli di livelli. |

### LevelDefine :id=model-level-define

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer o null | ID della definizione. |
| `levelStart` | integer | Livello iniziale. |
| `levelEnd` | integer | Livello finale. |
| `perLevelExp` | integer | EXP richiesta per livello nell’intervallo. |

Il JSON dei livelli malformato diventa attualmente un array `levels` vuoto senza far fallire l’intera richiesta.

## Statistiche :id=get-statistics

`GET /statistics` restituisce un oggetto `Statistics`. `time_range_start` e `time_range_end` facoltativi usano millisecondi Unix e la stessa regola SDK: entrambi validi e inizio < fine, altrimenti nessun intervallo. Senza intervallo l’App usa dal primo timestamp registrato a oggi; se assente, gli ultimi 30 giorni. `usingDays` e `companionDays` restano valori complessivi anche con un intervallo. Le altre metriche sono calcolate dai rispettivi metodi statistici; non presumere che tutte le query sottostanti abbiano identiche regole di inclusione degli estremi.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `start` | integer o null | Inizio effettivo dell’intervallo in millisecondi Unix. |
| `end` | integer o null | Fine effettiva dell’intervallo in millisecondi Unix. |
| `tomatoes` | integer | Statistica dei pomodori guadagnati. |
| `pomodoroMinutes` | integer | Durata della concentrazione in minuti. |
| `focusCount` | integer | Numero di sessioni di concentrazione. |
| `tasksCompleted` | integer | Numero di attività completate usato nella statistica di completamento. |
| `tasksTotal` | integer | Numero totale di attività usato per tale statistica. |
| `taskCompleteRate` | number | Rapporto di completamento. |
| `feelingsCount` | integer | Numero di sensazioni. |
| `usingDays` | integer | Giorni di utilizzo complessivi. |
| `companionDays` | integer | Giorni di compagnia complessivi. |
| `interestChanged` | integer | Statistica della variazione di monete per interessi. |
| `coinPurchaseConsumed` | integer | Statistica del consumo di monete per acquisti. |

## Informazioni dell’App e saldo monete :id=get-info

`GET /info` restituisce `Info`. LifeUp Cloud aggiunge la propria versione installata alle informazioni dell’App/provider. Nessun parametro.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `appVersion` | integer | Codice della versione LifeUp installata. |
| `appVersionName` | string | Nome della versione LifeUp installata. |
| `apiVersion` | integer | Versione API LifeUp. |
| `cloudVersion` | integer | Codice della versione LifeUp Cloud installata. |
| `cloudVersionName` | string | Nome della versione LifeUp Cloud installata. |

### GET /coin :id=get-coin

Invoca `lifeup://api/query?key=coin` tramite ContentProvider e ne restituisce l’oggetto risultato. Nessun parametro. Un risultato null diventa un oggetto vuoto. I campi sono definiti dal provider, non da una risposta tipizzata `CoinData`. Una query riuscita fornisce `value` (saldo monete intero con segno a 64 bit) e `api_result: true`; gli errori possono includere i campi di stato/errore descritti sotto.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Invocare un’API con schema URL :id=invoke-api

Il [catalogo API degli schemi URL](/guide/api) definisce nomi dei metodi, parametri e risultati specifici. Il ponte HTTP accetta l’URL completo `lifeup://api/...`.

| Trasporto | Input | Esecuzione e risposta |
| --- | --- | --- |
| `GET /api` | Parametro ripetuto `url` con codifica URL | Avvia un’Activity Android per ogni URL nell’ordine fornito. Restituisce la stringa `success`. Anche l’assenza di URL dà successo. |
| `POST /api` | JSON `RawQueryVo` | Avvia prima tutte le voci `urls`, poi `url` se presente. Restituisce la stringa `success`. Anche un oggetto vuoto dà successo. |
| `GET /api/contentprovider` | Parametro ripetuto `url` con codifica URL | Chiama il provider in modo sincrono e restituisce `CallUrlResult[]` nell’ordine fornito. L’assenza di URL dà un involucro di errore (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Chiama prima tutte le voci `urls`, poi `url`; restituisce `CallUrlResult[]`. Un oggetto vuoto restituisce un array vuoto. |

Impostare `Content-Type: application/json` per i POST JSON. Codificare l’intero URL quando viene inserito in una query GET, conservando `&`, `?`, `+` e codifiche percentuali interne. Una risposta riuscita del ponte Activity conferma l’invio, non il completamento dell’azione LifeUp. I metodi ContentProvider richiedono l’autorizzazione di Cloud in LifeUp e il supporto dipende dal metodo dello schema URL. Le chiamate sono sequenziali; se una successiva genera un’eccezione, gli effetti precedenti non vengono annullati.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Risposta del ponte Activity:

```json
{"code":200,"message":"success","data":"success"}
```

Risposta del ponte provider (risultato illustrativo):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `url` | string o null | Singolo URL facoltativo. |
| `urls` | string[] o null | Elenco facoltativo di URL; elaborato prima di `url`. |

### CallUrlResult :id=model-call-url-result

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `url` | string | URL inviato. |
| `result` | object o null | Bundle del provider convertito; null da solo non provoca il fallimento dell’involucro HTTP. |

La conversione Bundle conserva valori Int/Long/Double/String/Boolean e Bundle annidati. Gli array diventano array di stringhe. Gli altri tipi diventano la relativa stringa `toString()` (incluso null di Bundle, che diventa la stringa `"null"`). Controllare i campi di errore dentro `result` anche quando il codice esterno è 200.

Il gestore attuale di LifeUp aggiunge `api_result` (boolean) alle chiamate completate. Un errore del metodo intercettato restituisce `api_result: false`, `error_code` (string) ed `error_message` (string). I codici includono `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` e `internal_error`; i singoli metodi possono aggiungerne altri. Durante il ripristino il provider può restituire `error_code: "503"` ed `error_message` senza `api_result`. I gestori API mancanti possono generare un’eccezione prima di questa conversione, producendo un errore esterno del ponte.

## Leggere e caricare file :id=files-download

### GET /files/{url} :id=files-get

Codificare l’URI leggibile completo come singolo segmento di percorso. Legge byte tramite il content resolver Android, tipicamente per icone, allegati delle sensazioni, esportazioni backup o file caricati. Il risultato è un flusso di byte, non un involucro JSON di successo. Non specifica nome file o tipo MIME. I flussi vuoti/illeggibili non vengono convertiti in un risultato strutturato di file non trovato; le eccezioni usano il gestore globale HTTP 500. Un parametro corrispondente vuoto produce un involucro di errore (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Inviare `multipart/form-data`. Ogni parte file è accettata indipendentemente dal nome del campo; le altre parti vengono ignorate. Il nome originale viene usato per il file nella cache; se assente Cloud sceglie `uploaded_image_<time>.jpg`. Restituisce un array di stringhe URI di contenuto leggibili. Il caricamento fornisce un URI per chiamate successive, senza allegare automaticamente il file a un oggetto o attività. Senza file restituisce un involucro di errore con `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Esportare e importare backup :id=files-backup

### GET /data/export :id=files-export

Avvia la creazione di un backup tramite provider. `withMedia` è facoltativo, predefinito `true`; se presente, `true` senza distinzione tra maiuscole/minuscole significa vero, ogni altro valore falso. Restituisce il Bundle convertito, attualmente con `backup_file_uri`; scaricare tale URI tramite `/files/{url}`. Crea un’esportazione pur usando GET. Possono essere presenti campi di stato/errore del provider da controllare. Un `backup_file_uri` vuoto indica che non è stato prodotto un file utilizzabile. Un risultato null diventa un errore.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Inviare `multipart/form-data` con un file di backup. Se vi sono più parti file, prevale l’ultima; il nome del campo non viene controllato. Il nome predefinito è `backup.lfbak`. Il campo facoltativo `description` viene letto ma non ha effetto. Cloud memorizza il file nella cache e avvia l’Activity di backup LifeUp; la risposta conferma caricamento e avvio, **non il ripristino completato**. Senza file restituisce `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Eventi :id=get-events

### GET /events :id=get-events-poll

Restituisce `EventsPage`. `after` è un cursore esclusivo dell’ID evento (intero a 64 bit, predefinito 0). `limit` è intero, predefinito 50, limitato a 1–200. I valori non interi usano i predefiniti. Gli eventi con `id > after` vengono restituiti dal più vecchio nel buffer conservato. Al massimo 200 eventi restano in memoria; quelli precedenti vengono eliminati e il riavvio del processo azzera gli ID. `latestId` è l’ultimo ID globale disponibile, non necessariamente l’ultimo evento della pagina limitata. Continuare dall’ultimo evento realmente elaborato per evitare salti nell’arretrato. Nessuna cronologia persistente o conferma di consegna.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `latestId` | integer | ID dell’evento attualmente più recente. |
| `eventWs` | boolean | Impostazione WebSocket di Cloud. |
| `events` | CloudEvent[] | Eventi conservati dopo il cursore. |
| `broadcasts` | boolean o null | Se i broadcast LifeUp sono abilitati; null indica sconosciuto o non supportato. Lo stato è memorizzato nella cache per cinque secondi. |

### CloudEvent :id=model-cloud-event

| Campo | Tipo JSON | Significato |
| --- | --- | --- |
| `id` | integer | ID di sequenza dell’evento in memoria. |
| `time` | integer | Ora di ricezione Cloud in millisecondi Unix. |
| `action` | string | Azione broadcast Android. |
| `extras` | oggetto di valori stringa | Extra del broadcast convertiti con `toString()`; null diventa una stringa vuota. Le chiavi dipendono dall’azione. |

### WebSocket /events :id=get-events-websocket

Quando `eventWs` è true, connettersi a `ws://HOST:PORT/events?after=ID` fornendo il token configurato. Il server riproduce gli eventi conservati dopo `after`, poi invia eventi in tempo reale come singoli frame di testo JSON `CloudEvent`, **senza** involucro HTTP. La riproduzione è limitata al buffer in memoria di 200 eventi; non esiste un parametro WebSocket `limit`. Il server invia frame Ping ogni 30 secondi. Riconnettersi con l’ultimo ID realmente elaborato. Se disabilitata, la route WebSocket non è registrata; il polling HTTP rimane disponibile.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Le sottoscrizioni di azioni supportate sono `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, e `app.lifeup.timing.abandon`. La raccolta richiede i broadcast LifeUp abilitati. Il polling `/events` controlla l’impostazione senza abilitarla automaticamente.

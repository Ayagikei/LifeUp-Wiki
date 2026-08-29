# Piano di sviluppo

Poiché *LifeUp* è attualmente mantenuto nel tempo libero e ha risorse limitate, non garantiamo che il piano di sviluppo possa essere eseguito con precisione e non promettiamo una data di rilascio specifica.

<br/>

## Strategia di aggiornamento

Il ciclo di aggiornamento delle funzionalità locali resterà entro 14-21 giorni.

E dopo ogni aggiornamento di funzionalità, potremmo rilasciare diverse correzioni.

Poiché la funzione del modulo "Mondo" coinvolge diversi fattori come lo sviluppo congiunto su entrambe le piattaforme, la sincronizzazione dei requisiti, il deployment del server, i limiti di prestazioni del server e la compatibilità.

Il ciclo di sviluppo sarà più lungo rispetto alle funzioni locali e sarà principalmente di manutenzione invece di introdurre nuove funzionalità.



**Priorità di aggiornamento (approssimativa):**

Correzioni di crash >> Correzioni di bug sull'esperienza che influenzano i nuovi utenti >> Aggiornamenti di funzionalità > Correzioni di bug UI e dettagli.

<br/>

## Strategia di numerazione delle versioni

Usa un numero di versione a tre cifre, come `1.80.3`.

**La prima** (ad esempio **1**.80.3) è il numero di versione usato per la revisione maggiore dell'applicazione, e 1 è la versione ufficiale iniziale. Ci saranno molti refactoring del codice/ridisegni UI se migliora.


**La cifra centrale** (ad esempio 1.**80**.3) è il numero di versione delle funzionalità (feature). Il numero di versione aumenterà quando viene rilasciata una funzione di livello medio o quando si accumula un numero relativamente elevato di funzioni minori.

Ad esempio:

> La versione 64 ha lanciato il sistema Negozio&Store&Magazzino.
>
> La versione 70 ha lanciato la Modalità semplice.
>
> La versione 80 ha lanciato il sistema di apertura Bottini.



**La terza cifra** (ad esempio 1.80.**3**) è il numero di revisione per correggere alcuni problemi/crash con ogni rilascio di funzionalità. Allo stesso tempo, può anche portare alcune funzionalità minori.


> La vecchia versione usava anche il numero di versione a tre cifre rappresentato da lettere inglesi, come 1.58c.
>
> La strategia di base è la stessa di sopra, tranne che la terza sezione diventa una lettera inglese e inizia da `a`.
>
> Tuttavia, poiché alcuni mercati delle applicazioni non supportano questa strategia di numerazione delle versioni, ora è stata abbandonata.

<br/>

Consulta il [Piano di sviluppo 2026-2027](introduction/development_plan_2026_2027.md) per la nostra roadmap attuale.

Consulta il [Piano di sviluppo 2024-2025](introduction/development_plan_2024.md) per la roadmap precedente.

Consulta il [Piano di sviluppo 2022/10 - 2023/12](introduction/development_plan_2023.md) per l'archivio storico.

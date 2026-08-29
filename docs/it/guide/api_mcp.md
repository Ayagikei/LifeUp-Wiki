<h1 align="center" padding="100">MCP & Skills</h1>

Vuoi far lavorare l'IA con LifeUp? Ci sono due livelli:

| | Cosa fa | Chi lo usa |
|---|---|---|
| **MCP** `@lifeup/mcp` | Scopre LifeUp Cloud, invia richieste HTTP, codifica parametri e analizza risposte | Cursor, Claude Desktop, WorkBuddy e qualsiasi client MCP |
| **Skills** `lifeup-cloud/` | Come connettersi, cosa interrogare e come chiamare ogni API | Incluso in MCP come `help`; Claude Code / Pi possono anche caricare la cartella come skill su disco |

L'agente sul computer raggiunge LifeUp Cloud sul telefono via LAN, poi comunica con LifeUp. I dettagli HTTP restano nell'[API LifeUp Cloud](guide/api_cloud.md). Codice sorgente MCP: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Richiede **LifeUp 1.106.0**+ e **LifeUp Cloud 3.0.0**+. Versioni precedenti possono ancora connettersi, ma diari, statistiche e curva dei Livelli sono incompleti. `status.update` può chiedere all'utente di aggiornare.

MCP offre all'agente **API lettura/scrittura**; il livello IA aggiunge **ragionamento** — prioritizzare il backlog di oggi, riassumere statistiche settimanali dai diari, progettare Compiti in base ai Livelli Attributi, o **costruire una gamification tematica completa in un prompt** (sviluppo indie, accademia di magia e altro) — non solo recuperare elenchi grezzi.

## Prova a chiedere

Una volta installato MCP, non serve memorizzare le API — parla con l'IA.

**Pianifica la giornata**

- «Cosa resta oggi? Ordina per priorità e dimmi da dove iniziare.»
- «Scegli un Compito non completato che posso finire in circa 25 minuti.»

**Analizza i dati**

- «Estrai statistiche pomodoro, Concentrazione, monete e Punti Esperienza di questa settimana — suddividi le fonti e riassumi i pattern.»
- «Da dove sono arrivate le mie monete questo mese? Mostra le fonti principali e qualcosa di sorprendente.»

**Coach e progettazione**

- «Guarda i miei Livelli Attributi e progetta un set di Compiti giornalieri per far salire le Abilità più deboli.»

**Setup tematico one-shot**

- «Cancella gli esempi e costruisci una configurazione completa da sviluppatore indie: liste, Negozio, Obiettivi e Attributi.»
- «Progetta una routine RPG completa da accademia di magia — Compiti, Attributi, Oggetti del Negozio e Obiettivi.»

**Rifletti**

- «Guarda cosa ho completato oggi e scrivi un breve diario: cosa ho fatto e cosa potrei migliorare domani.»
- «Crea un elenco Obiettivi chiamato Morning Routine e aggiungi 8 Obiettivi con icone emoji e Ricompense in monete.»
<br/>

## Avvio rapido

Invia questa riga al tuo agente per installare MCP e completare la prima connessione:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

I file Skill sono in [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (una copia nel repo — nessun pacchetto npm separato).

- **Cursor / Claude Desktop / WorkBuddy:** installa solo MCP. `help` legge questo skill; non installarlo due volte.
- **Claude Code / Pi / flusso personalizzato:** copia la cartella nel percorso skill dell'agente, oppure punta direttamente al repo.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connessione + operazioni comuni (leggi per primo)
  references/
    basics.md              errori, codifica, JSON, timeout
    discovery.md           mDNS / token
    query.md               risorse list_data
    tasks.md / economy.md
    api-index.md           una riga per metodo
    methods/*.md           tabella parametri completa (carica alla chiamata)
    broadcasts.md / gaps.md
```

L'agente legge la documentazione in modo progressivo:

1. `help` (o `SKILL.md` su disco) — flusso generale
2. `help api-index` — quali metodi esistono
3. `help add_task` — parametri di un metodo
4. `call_api` / `list_data` — esegui la chiamata

Per personalizzare: copia la cartella e modifica `SKILL.md` e `references/`. MCP `help` legge ancora la copia impacchettata salvo ricompilazione MCP dal tuo fork.

<br/>

## Configurazione

1. Telefono e computer sulla stessa LAN
2. LifeUp in esecuzione, con Cloud autorizzato per **Read LifeUp Data**
3. LifeUp Cloud avviato (porta predefinita `13276`)
4. [Node.js 20+](https://nodejs.org/) sul computer

Il token è opzionale. Se impostato, invia il token **grezzo** nell'header — non `Bearer`.

<br/>

## Installa MCP

Finché il pacchetto non è su npm, installa da GitHub:

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx` clona il repo e compila `mcp/`. Quando arriva su `main`, rimuovi `#feat/mcp`.

Se hai già clonato [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), usa l'installer (compila MCP e aggiorna i client rilevati; riesecuzioni non registrano una seconda copia):

```bash
./scripts/install-mcp.sh
```

Client predefiniti: Codex, Cursor, Claude Code, Claude Desktop, Pi. Le config Pi con `imports: ["codex"]` ereditano Codex e non vengono duplicate.

Le app GUI su macOS spesso non hanno `npx` nel `PATH` — usa un percorso assoluto a `npx`/`node`, oppure clona ed esegui `cd mcp && npm install && npm run build`.

| Variabile | Ruolo |
|---|---|
| `LIFEUP_HOST` | es. `192.168.1.8:13276`, salta mDNS |
| `LIFEUP_TOKEN` | Solo processo, mai scritto su disco |
| `LIFEUP_MCP_CONFIG` | Percorso config personalizzato |

Dopo la pubblicazione: `npx -y @lifeup/mcp` (npmmirror in Cina).
<br/>

## Flusso agente

1. `discover` — mDNS `_lifeup._tcp`; il `port` nel TXT è la porta HTTP. Connessione automatica se trova esattamente un'istanza Cloud.
2. `connect` — passa `host` quando ci sono zero o più istanze.
3. `status` — controlla versioni; se sotto 1.106.0 / 3.0.0, attendi `update`.
4. Elenchi: `list_data` (campi compatti di default).
5. Scritture: `complete_task` / `add_task` / `reward` / `purchase_item`; tutto il resto via `call_api`. Usa `via=launch` per aprire l'interfaccia dell'App.

Le chiamate distruttive richiedono `confirm: true`. Non pre-codificare i valori dei parametri.

## Eventi

LifeUp: abilita Labs → Broadcast events (disattivato di default; Cloud Advanced può mostrare lo stato e abilitarlo). **WebSocket event push** di Cloud è attivo di default (3.0.0+) ed è solo trasporto.

- `list_events` — `GET /events`, sempre disponibile
- `subscribe_events` — `WS /events`; errore se l'interruttore Cloud è spento; HTTP funziona ancora

Dettagli: MCP `help broadcasts`.

<br/>

---

## Esempio: setup sviluppatore indie

Di seguito l'esito di una sessione MCP reale: l'utente ha chiesto all'IA di **cancellare gli esempi sviluppatore integrati in LifeUp**, poi costruire un setup RPG completo attorno allo **sviluppo di giochi indie** (liste Compiti, Attributi, Negozio, Obiettivi).

Puoi iniziare con prompt come:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Cosa è stato creato

| Area | Contenuto |
| --- | --- |
| Liste Compiti | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Attributi | Execution / Technical / Collaboration / Focus / Wellness / Creativity, più **Developer Stats** (Game Design, Debugging, Architecture) |
| Negozio | **Dev Supplies** (consumabili) + **Fun Collectibles** (Oggetti easter egg) |
| Obiettivi | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Clicca un'immagine per ingrandire. Usa le schede sotto per passare in orizzontale invece di scorrere una pagina lunga.

<!-- tabs:start -->

#### **1 · Panoramica Compiti**

Compiti ricorrenti Morning Ritual nella vista **All**, con chip categoria per Coding Daily, Game Dev e altro.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Attributi**

Sei Attributi principali più il gruppo **Developer Stats**. Completare Compiti assegna EXP alle Abilità corrispondenti.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Oggetti easter egg del Negozio: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — alcuni con monete casuali o bonus Attributi.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Obiettivi**

Obiettivi traguardo: primo Compito, primo bug risolto, pubblicare demo, serie, pomodori, Piggy Bank, Daily Pentakill e altro — con icone emoji e condizioni di sblocco.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Dettaglio Piggy Bank**

Esempio condizione a progresso: raggiungere **500 monete** di saldo attuale.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Dettaglio Daily Pentakill**

Esempio condizione contatore: completare **5 Compiti diversi in un giorno**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Cosa fa tipicamente l'IA

1. `list_tasks` / `list_items` — ispeziona esempi esistenti; elimina righe obsolete se serve (`confirm: true` per chiamate distruttive).
2. Crea liste Compiti / Negozio / Obiettivi (`category`).
3. Crea Attributi e gruppi (`skill` / `skill_group`).
4. Scrive Compiti, Oggetti e Obiettivi in batch (`add_task` / `add_item` / `achievement`).
5. Aggiorna le schermate corrispondenti nell'App per verificare.

Per i parametri API vedi [Skills](#skills) e [Flusso agente](#agent-workflow) sopra; tabelle per metodo via MCP `help add_task`, ecc.

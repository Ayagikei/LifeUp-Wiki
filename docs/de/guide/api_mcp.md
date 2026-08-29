<h1 align="center" padding="100">MCP & Skills</h1>

Soll KI mit LifeUp arbeiten? Es gibt zwei Ebenen:

| | Was es tut | Wer es nutzt |
|---|---|---|
| **MCP** `@lifeup/mcp` | LifeUp Cloud entdecken, HTTP-Anfragen senden, Parameter kodieren, Antworten parsen | Cursor, Claude Desktop, WorkBuddy und jeder MCP-Client |
| **Skills** `lifeup-cloud/` | Verbinden, Abfragen, Aufruf jeder API | Als MCP-`help` gebündelt; Claude Code / Pi können den Ordner auch als Disk-Skill laden |

Der Agent auf dem Computer erreicht LifeUp Cloud auf dem Telefon über das LAN und spricht dann mit LifeUp. HTTP-Details stehen in der [LifeUp Cloud API](guide/api_cloud.md). MCP-Quellcode: [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Erfordert **LifeUp 1.106.0**+ und **LifeUp Cloud 3.0.0**+. Ältere Builds verbinden ggf. noch, aber Journale, Statistiken und die Stufenkurve sind unvollständig. `status.update` kann den Nutzer zum Upgrade auffordern.

MCP liefert dem Agenten **Lese-/Schreib-APIs**; die KI-Schicht ergänzt **Schlussfolgerungen** — heutiges Backlog priorisieren, Wochenstatistiken aus Journals zusammenfassen, Aufgaben aus deinen Attribut-Stufen entwerfen oder **ein komplettes thematisches Gamification-Setup in einem Prompt** (Indie-Game-Dev, Magie-Akademie und mehr) — nicht nur rohe Listen abrufen.

## Beispiel-Prompts

Nach MCP-Installation musst du dir keine APIs merken — sprich einfach mit der KI.

**Tag planen**

- „Was steht heute noch an? Nach Priorität sortieren und sagen, womit ich anfangen soll.“
- „Wähle eine offene Aufgabe, die ich in etwa 25 Minuten schaffen kann.“

**Daten analysieren**

- „Hol Pomodoro-, Fokus-, Münz- und Erfahrungspunkte-Statistik dieser Woche — aufschlüsseln, woher sie kommen, und Muster zusammenfassen.“
- „Woher kamen meine Münzen diesen Monat? Größte Quellen und Überraschungen zeigen.“

**Coaching & Design**

- „Sieh dir meine Attribut-Stufen an und entwirf tägliche Aufgaben, um schwächere Fähigkeiten zu leveln.“

**Themen-Setup in einem Schritt**

- „Lösche die Beispiele und baue ein vollständiges Indie-Game-Developer-Setup: Listen, Shop, Erfolge und Attribute.“
- „Entwirf eine komplette Magie-Akademie-RPG-Routine — Aufgaben, Attribute, Shop-Gegenstände und Erfolge.“

**Reflektieren**

- „Sieh dir an, was ich heute erledigt habe, und schreib ein kurzes Journal: was ich tat und was ich morgen verbessern könnte.“
- „Erstelle eine Erfolgsliste Morning Routine mit 8 Erfolgen, Emoji-Icons und Münz-Belohnungen.“
<br/>

## Schnellstart

Sende diese Einzeiler an deinen Agenten, um MCP zu installieren und die erste Verbindung herzustellen:

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Skill-Dateien liegen in [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (eine Kopie im Repo — kein separates npm-Paket).

- **Cursor / Claude Desktop / WorkBuddy:** nur MCP installieren. `help` liest diesen Skill; nicht doppelt installieren.
- **Claude Code / Pi / eigener Workflow:** Ordner in den Skills-Pfad kopieren oder direkt aufs Repo zeigen.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connect + common ops (read this first)
  references/
    basics.md              errors, encoding, JSON, timeouts
    discovery.md           mDNS / token
    query.md               list_data resources
    tasks.md / economy.md
    api-index.md           one line per method
    methods/*.md           full param table (load when calling)
    broadcasts.md / gaps.md
```

Der Agent liest Docs schrittweise:

1. `help` (oder Disk-`SKILL.md`) — Gesamtworkflow
2. `help api-index` — welche Methoden existieren
3. `help add_task` — Parameter einer Methode
4. `call_api` / `list_data` — Aufruf ausführen

Anpassen: Ordner kopieren und `SKILL.md` sowie `references/` bearbeiten. MCP-`help` liest weiter die gebündelte Kopie, außer du baust MCP aus deinem Fork neu.

<br/>

## Einrichtung

1. Telefon und Computer im selben LAN
2. LifeUp läuft, Cloud hat **Read LifeUp Data** erhalten
3. LifeUp Cloud gestartet (Standardport `13276`)
4. [Node.js 20+](https://nodejs.org/) am Computer

Token optional. Falls gesetzt, **rohes** Token im Header senden — nicht `Bearer`.

<br/>

## MCP installieren

Bis das Paket auf npm liegt, von GitHub installieren:

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

`npx` klont das Repo und baut `mcp/`. Nach Merge auf `main` `#feat/mcp` entfernen.

Wenn du [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK) schon geklont hast, Installer nutzen (baut MCP, upsertet erkannte Clients; erneute Läufe registrieren keine zweite Kopie):

```bash
./scripts/install-mcp.sh
```

Standard-Clients: Codex, Cursor, Claude Code, Claude Desktop, Pi. Pi-Configs mit `imports: ["codex"]` erben Codex und werden nicht dupliziert.

GUI-Apps unter macOS haben oft kein `npx` im `PATH` — absoluten `npx`-/`node`-Pfad nutzen oder klonen und `cd mcp && npm install && npm run build` ausführen.

| Variable | Rolle |
|---|---|
| `LIFEUP_HOST` | z. B. `192.168.1.8:13276`, mDNS überspringen |
| `LIFEUP_TOKEN` | nur im Prozess, nie auf Disk |
| `LIFEUP_MCP_CONFIG` | eigener Config-Pfad |

Nach Veröffentlichung: `npx -y @lifeup/mcp` (npmmirror in China).
<br/>

## Agent-Workflow :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp`; TXT-`port` ist der HTTP-Port. Auto-Connect bei genau einer Cloud-Instanz.
2. `connect` — `host` übergeben bei null oder mehreren Instanzen.
3. `status` — Versionen prüfen; unter 1.106.0 / 3.0.0 auf `update` achten.
4. Listen: `list_data` (kompakte Felder standardmäßig).
5. Schreiben: `complete_task` / `add_task` / `reward` / `purchase_item`; alles andere via `call_api`. Mit `via=launch` App-UI öffnen.

Destruktive Aufrufe brauchen `confirm: true`. Parameterwerte nicht vor-kodieren.

## Events

LifeUp: Labs → Broadcast events aktivieren (standardmäßig aus; Cloud Advanced kann Status anzeigen und aktivieren). Cloud **WebSocket event push ist standardmäßig an** (3.0.0+) und ist nur Transport.

- `list_events` — `GET /events`, immer verfügbar
- `subscribe_events` — `WS /events`; Fehler wenn Cloud-Toggle aus, HTTP funktioniert weiter

Details: MCP `help broadcasts`.

<br/>

---

## Beispiel: Indie-Game-Developer-Setup

Unten das Ergebnis einer echten MCP-Sitzung: Der Nutzer bat die KI, **LifeUps eingebaute Developer-Beispiele zu löschen** und ein vollständiges RPG-Setup rund um **Indie-Game-Entwicklung** zu bauen (Aufgabenlisten, Attribute, Shop, Erfolge).

Start-Prompts z. B.:

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Was gebaut wurde

| Bereich | Inhalt |
| --- | --- |
| Aufgabenlisten | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Attribute | Execution / Technical / Collaboration / Focus / Wellness / Creativity plus **Developer Stats** (Game Design, Debugging, Architecture) |
| Shop | **Dev Supplies** (Verbrauchsgüter) + **Fun Collectibles** (Easter-Egg-Gegenstände) |
| Erfolge | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Bild anklicken zum Zoomen. Mit den Tabs unten horizontal wechseln statt lange Seite scrollen.

<!-- tabs:start -->

#### **1 · Aufgaben-Überblick**

Wiederkehrende Morning-Ritual-Aufgaben in der **All**-Ansicht, mit Kategorie-Chips für Coding Daily, Game Dev und mehr.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Attribute**

Kern-Attribute plus **Developer Stats**. Erledigte Aufgaben geben EXP an passende Fähigkeiten.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Easter-Egg-Shop-Gegenstände: Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — teils mit zufälligen Münzen oder Attribut-Boni.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Erfolge**

Meilenstein-Erfolge: erste Aufgabe, erster Bugfix, Demo shippen, Streaks, Pomodoros, Piggy Bank, Daily Pentakill und mehr — mit Emoji-Icons und Freischaltbedingungen.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Piggy Bank Detail**

Fortschritts-Bedingung: **500 Münzen** aktuelles Guthaben erreichen.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Daily Pentakill Detail**

Zähler-Bedingung: **5 verschiedene Aufgaben an einem Tag** erledigen.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Was die KI typischerweise tut

1. `list_tasks` / `list_items` — vorhandene Beispiele prüfen; alte Zeilen bei Bedarf löschen (`confirm: true` bei destruktiven Aufrufen).
2. Aufgaben-/Shop-/Erfolgslisten anlegen (`category`).
3. Attribute und Gruppen erstellen (`skill` / `skill_group`).
4. Aufgaben, Gegenstände und Erfolge batch-schreiben (`add_task` / `add_item` / `achievement`).
5. Passende App-Screens zur Kontrolle aktualisieren.

API-Parameter siehe [Skills](#skills) und [Agent-Workflow](#agent-workflow) oben; Methoden-Tabellen via MCP `help add_task` usw.

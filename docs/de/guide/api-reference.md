# HTTP-API-Referenz :id=http-query-reference

Diese Referenz beschreibt LifeUp-Cloud-Anfrageparameter und vollständige HTTP-Antwortmodelle. Installation, Autorisierung und Verbindung erklärt [LifeUp Cloud](/guide/api_cloud). Neuere Journal-Endpunkte erfordern LifeUp **1.106.0+** und LifeUp Cloud **3.0.0+**; ermittle die installierten Versionen mit `/info`. Beschrieben werden aktuelle Quellcode-Verträge, nicht die Verfügbarkeit in einer bestimmten Veröffentlichung.

## Schnittstellenindex :id=interface-index

| Ressource | Methoden und Pfade | Parameter und Modell |
| --- | --- | --- |
| Gemeinsame Regeln | JSON-Antworten, Autorisierung, Cache-Bedingungen, Seitennavigation | [Konventionen](#representations), [Cache und Authentifizierung](#auth-cache), [Seitennavigation](#pagination) |
| Aufgaben | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Abfragen](#get-tasks), [Aufgabenmodell](#task-fields), [Kategorien](#get-tasks-categories) |
| Aufgabenverlauf | `GET /history` | [Parameter](#get-history), [Zeitstempel](#task-times), [Tagesberichte](#daily-report) |
| Gegenstände | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [Gegenstands-IDs, Kategorie-IDs und vollständige Modelle](#get-items) |
| Attribute | `GET /skills`, `GET /skill_groups` | [Attribute und Gruppen](#get-skills) |
| Erfolge | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Erfolge und Bedingungen](#get-achievements) |
| Synthese | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Rezepte und Kategorien](#get-synthesis) |
| Gefühle | `GET /feelings` | [Gefühle mit Seitennavigation](#get-feelings) |
| EXP / Münzen | `GET /exp_records`, `GET /coin_records` | [Journalparameter und Modelle](#reward-journals) |
| Weitere Datensätze | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [Inventar](#get-inventory-records), [Schritte](#get-step-records) |
| Stufen / Statistiken | `GET /level_defines`, `GET /statistics` | [Stufen](#get-level-defines), [Statistiken](#get-statistics) |
| App / Kontostand | `GET /info`, `GET /coin` | [Versionsinformationen](#get-info), [Münzergebnis](#get-coin) |
| Aktionen aufrufen | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Aufrufbrücke](#invoke-api); fachliche Methoden stehen im [URL-Scheme-Katalog](/guide/api) |
| Dateien / Backups | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Dateien](#files-download), [Backup-Übertragung](#files-backup) |
| Ereignisse | `GET /events`, WebSocket `/events` | [Abfragen und Live-Ereignisse](#get-events) |
| Startseite | `GET /` | HTML-Einführung, keine JSON-Ressource. |

MCP verwendet eine separate Client-/Werkzeugdarstellung; siehe [MCP-Unterschiede](#mcp-differences) und [MCP-Anleitung](/guide/api_mcp).

## Übertragung und Darstellung :id=representations

| Schnittstelle | Darstellung | Wichtiger Unterschied |
| --- | --- | --- |
| Cloud-HTTP-Abfragen | JSON in `{code, message, data}` | Die folgenden Endpunktreferenzen beschreiben dieses öffentliche JSON. |
| Android ContentProvider | Cursor-Spalten wie `_ID` / `_GID`, teilweise mit JSON-Text | Der SDK-Parser wandelt sie in HTTP-Felder wie `id` / `gid` und verschachtelte Arrays um. Verwende Cursor-Spaltendefinitionen nicht als HTTP-Schema. |
| URL-Scheme-Aktionen | `lifeup://api/{method}` und methodenspezifische Parameter/Ergebnisse | Schreibparameter können snake_case verwenden, während HTTP-Lesefelder camelCase verwenden. |
| MCP-Listenwerkzeuge | Werkzeugspezifische Hülle und kompakte oder detaillierte Einträge | MCP-Seitennavigation und Ausgabefelder sind zusätzliches Client-Verhalten, keine HTTP-Antwortfelder. |

## Antworten und Fehler :id=response-errors

Die gemeinsame HTTP-JSON-Hülle ist `HttpResponse<T>`:

| Feld | Typ | Bedeutung |
| --- | --- | --- |
| `code` | integer | `200` bei erfolgreicher Abfrage; ein Wert ungleich `200` zeigt einen Fehler an. Dies ist ein Feld im Antwortkörper, getrennt vom HTTP-Status. |
| `message` | string | Bei Erfolg normalerweise `success`, sonst eine Fehlerbeschreibung. |
| `data` | `T` oder `null` | Bei Erfolg ein endpunktspezifischer Wert (Array, Objekt oder Zeichenfolge); bei Fehler `null`. |

Beispiel einer erfolgreichen leeren Liste:

```json
{"code":200,"message":"success","data":[]}
```

Beispiel eines Berechtigungs-/Provider-Zugriffsfehlers:

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Signal | Behandlung |
| --- | --- |
| HTTP `401` | Übergib das konfigurierte Cloud-Token direkt als Wert des Headers `Authorization`. Füge kein `Bearer` hinzu. |
| Antwortkörper `code = 10001` | Prüfe, ob LifeUp installiert und gestartet ist und Cloud die Berechtigung zum Lesen von LifeUp-Daten besitzt. |
| Antwortkörper `code = 10002` | Die ContentProvider-Abfrage ist fehlgeschlagen; prüfe die Fehlermeldung. |
| Anderer Fehlerstatus/-code | Behandle die Abfrage als fehlgeschlagen, nicht als leeres Ergebnis. |

Prüfe **sowohl** den HTTP-Status als auch `code` im Antwortkörper. Manche Routenfehler liefern weiterhin HTTP `200` mit einem Fehlercode im Körper. Bei Aktionen über `/api/contentprovider` muss zusätzlich jedes `data[].result.api_result` geprüft werden; `code=200` in der Hülle beweist nicht den Erfolg aller Aktionen.

## Autorisierung und bedingtes Lesen :id=auth-cache

Wenn ein Cloud-Token konfiguriert ist, sende seinen exakten Rohwert in `Authorization`, ohne `Bearer` voranzustellen. Der Server akzeptiert auch den Abfrageparameter `token`, etwa für Clients ohne WebSocket-Header-Unterstützung. Ein fehlendes oder falsches Token ergibt HTTP `401` und `code=401` im Antwortkörper. Geprüft werden Startseite, Ressourcen, Brücke, Dateien, Backup-Übertragung und Ereignisse.

Erfolgreiche JSON-Ressourcenabfragen liefern einen starken SHA-256-`ETag` und `Cache-Control: private, no-cache`. Dies gilt für Aufgaben/Verlauf, Gegenstände/Kategorien, Attribute/Gruppen, Erfolge/Bedingungen, Gefühle, Synthesen/Kategorien, Journale, Stufen, Statistiken, Informationen und Münzen. Ausgenommen sind Aufrufbrücke, Datei- und Backup-Übertragung sowie Ereignisstreams/-abfragen.

| Anfrageheader | Aktuelles Antwortverhalten |
| --- | --- |
| `If-Match` | Eine abweichende Version führt zu HTTP `412`; Auswertung vor `If-None-Match`. |
| `If-None-Match` | Eine passende Version ergibt HTTP `304` ohne JSON-Antwortkörper. Verwende die erfolgreiche zwischengespeicherte Darstellung. |

Fehlerhüllen enthalten keinen Ressourcenversionsheader. Bedingte Abfragen gelten je Ressourcenanfrage und bilden keinen Snapshot und keine Transaktion über Seiten oder Routen hinweg.

Browser-Anfragen über Ursprungsgrenzen können `If-None-Match` verwenden. Die aktuelle CORS-Konfiguration erlaubt `If-Match` bei der Preflight-Prüfung nicht. Verlasse dich daher ohne Änderung dieser Implementierung nicht auf ursprungsübergreifende Browser-Anfragen mit `If-Match`. Native Clients unterliegen nicht dem Browser-CORS.

## Gemeinsame Datenkonventionen :id=data-conventions

| Konvention | Regel |
| --- | --- |
| Zeit | Zeitstempel verwenden Unix-Millisekunden. Kalendertagesgrenzen hängen von der vorgesehenen Zeitzone ab. Einzelne Felder behalten ihre ressourcenspezifische Bedeutung. |
| Identität | Aufgaben-`id` identifiziert eine Aufgabe/einen Zyklus; Aufgaben-`gid` identifiziert ihre Gruppe über Wiederholungszyklen hinweg. Eine Kategorie-/Listen-ID bezeichnet eine separate Ressource. |
| Leere Werte | Fehlend, `null`, `0`, `""` und `[]` sind verschieden. Jedes Modell dokumentiert seine tatsächlichen Ersatzwerte oder Auslassungen. |
| Numerische IDs | IDs können vorzeichenbehaftete 64-Bit-Ganzzahlen sein; JavaScript Number kann nicht jeden Wert exakt darstellen. Erhalte große IDs mit einem geeigneten JSON-Parser. |
| Arrays und Objekte | Verschachtelte HTTP-Werte wie `items` und `subTasks` sind Arrays, keine JSON-kodierten Zeichenketten. |
| Status- und Ursachencodes | Verwende die für die Ressource dokumentierte Aufzählung. Aufgabenstatus, Erfolgsstatus und Journal-Ursachencodes gehören zu verschiedenen Wertebereichen. |

Siehe die [Definitionen der Aufgabenzeitstempel](/guide/api-reference?id=task-times) für `startTime`, `deadline` und `endTime`.

## Seitennavigation und Filter :id=pagination

Seitennavigation ist eine Fähigkeit einzelner Endpunkte, keine Eigenschaft jeder Liste. Rohe HTTP-Listenantworten enthalten `data: [...]`; sie ergänzen **kein** `total`, `count` oder `hasMore`.

| HTTP-Endpunkt | Seitennavigation | Datumsbereich | Weitere Filter |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | Nein; vollständiges Array | Nein | Optionale Kategorie im Pfad |
| `/history` | Serverseitiges `offset` / `limit` | Nein | Optionales `gid` |
| `/feelings` | Serverseitiges `offset` / `limit` | Nein | Siehe [Gefühle](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | Serverseitiges `offset` / `limit` | `time_range_start` / `time_range_end` | Siehe den jeweiligen Endpunkt |
| `/statistics` | Nein; ein Objekt | `time_range_start` / `time_range_end` | Aggregatabfrage |
| `/coin`, `/info` | Nein; ein Objekt | Nein | Abfrage eines Einzelobjekts |

Für paginierte Endpunkte sind die HTTP-Standardwerte `offset=0` und `limit=100`. Verwende nichtnegative Offsets und Seitengrößen von `1..100` für eine gemeinsame Seitenschleife. Die HTTP-Bridge begrenzt nicht wie MCP auf `1..100`; nachgelagerte Provider können andere Grenzen erzwingen. Beachte die effektive Seitengröße und Validierungshinweise des jeweiligen Endpunkts.

Abgesehen von der [Einschränkung bei zeitgefilterten Pomodoros](#get-pomodoro-records) erhöhe nach jeder erfolgreichen Seite `offset` um die Anzahl der gelieferten Datensätze. Stoppe, wenn diese kleiner als die wirksame Seitengröße ist (bei `1..100` das angeforderte `limit`, ausgenommen zeitgefilterte Pomodoros). Verwechsle eine vom Provider begrenzte Seite nicht mit der letzten Seite. Eine leere Seite hinter dem Ende ist normal. Mehrere Seiten bilden keinen Snapshot: Datensätze können sich während der Abfrage ändern.

Das aktuelle HTTP-SDK leitet Datumsgrenzen nur weiter, wenn **beide** als Ganzzahlen lesbar sind und `start < end` gilt. Eine einzelne, unlesbare oder vertauschte Grenze führt zu einer ungefilterten Abfrage; verlasse dich hierfür nicht auf eine Fehlermeldung. Validiere beide Grenzen vor dem Senden. Die Journalreferenz beschreibt die inklusiven Grenzen ihrer Endpunkte.

## Unterschiede zu MCP :id=mcp-differences

MCP-Listenwerkzeuge verwenden standardmäßig `limit=20`, begrenzen es auf `1..100` und `offset` auf mindestens `0`. Bei serverseitig paginierten Ressourcen wie Verlauf/Journalen senden sie die Seitennavigation an den Server; bei Aufgaben holen sie vollständige HTTP-Arrays und schneiden sie lokal zu. Ihre Felder `items`, `count`, `hasMore` und optional `total` gehören zur MCP-Hülle. `detail=false` entfernt zudem Felder aus jedem Eintrag; verwende `detail=true`, wenn das vollständige HTTP-Modell benötigt wird.

## Quellen und Versionsumfang :id=api-common-sources

Diese Referenzen beschreiben das aktuelle öffentliche SDK und das entsprechende Verhalten des LifeUp-Providers. Beispiele verwenden erfundene Daten. Quelllinks dienen als Implementierungsreferenzen und beweisen nicht, dass eine bestimmte installierte Version jedes Feld enthält: [HTTP-Routen](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [HTTP-Hülle](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [MCP-Abfragezuordnung](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## Datenmodelle für Aufgaben und Verlauf :id=task-history-models

Diese Seite definiert das **HTTP-JSON** der [Aufgaben-/Verlaufsabfragen](/guide/api-reference?id=task-queries). Android-Cursor-Spalten und URL-Scheme-Aktionsparameter können andere Namen und Darstellungen verwenden; siehe [gemeinsame Konventionen](/guide/api-reference?id=representations).

Das SDK verwendet eine serialisierte Klasse `Task` für zwei Ansichten. Hier bezeichnet `Task` die `/tasks`-Ansicht und `HistoryRecord` die `/history`-Ansicht. Diese Namen beschreiben die bestehende Ausgabe und führen keine weitere API ein. Die aktuelle Cloud-Serialisierung enthält Standardwerte und `null`-Felder.

### Felder von Task / HistoryRecord :id=task-fields

Alle folgenden Felder erscheinen im aktuellen HTTP-Objekt. Fehlende Provider-Werte werden oft in die aufgeführten Ersatzwerte umgewandelt; ein Ersatzwert beweist nicht, dass dieser Wert in den Quelldaten vorhanden war.

| Feld | JSON-Typ | Bedeutung / Ersatzwert |
| --- | --- | --- |
| `id` | integer oder `null` | ID dieser Aufgabe/dieses Zyklus. |
| `gid` | integer oder `null` | Gemeinsame Aufgabengruppen-ID über Wiederholungszyklen hinweg. |
| `name` | string | Aufgabenname. Ein fehlender Provider-Name wird zu `ERROR: name is null`. |
| `notes` | string | Notizen; leere Zeichenkette, falls nicht vorhanden. |
| `status` | integer | Aufgabenstatus; fehlende Werte werden zu `0`. Siehe Statustabelle unten. |
| `startTime` | integer | Konfigurierte Startzeit in Millisekunden; SDK-Ersatzwert `0`. |
| `deadline` | integer | Fälligkeit in Millisekunden; SDK-Ersatzwert `0`, falls nicht vorhanden. |
| `remindTime` | integer | Erinnerungszeit in Millisekunden; SDK-Ersatzwert `0`, falls nicht vorhanden. |
| `frequency` | integer | Wiederholungscode; `0` einmalig, `1` täglich, `-1` unbegrenzt. Weitere Modi unter [Aufgabenaktionen](/guide/api). SDK-Ersatzwert `0`. |
| `weekdays` | string | Wochentagsauswahl, z. B. `1,3,5` (Montag `1`, Sonntag `7`); leer, falls nicht angegeben, und im Verlauf ein fester leerer Platzhalter. |
| `importance` | integer oder `null` | Wichtigkeitsstufe `1`–`4` (aufsteigend); entspricht dem App-Aufgaben-Dringlichkeitsgrad (`taskUrgencyDegree`). In `GET /tasks` und `GET /tasks/{categoryId}` gesetzt, wenn der Aufgabenlisten-ContentProvider die Spalte liefert; fehlende oder NULL-Spalte wird vom SDK als `null` gelesen. Der Historien-ContentProvider liefert die Spalte nicht, daher `/history` hier `null`, ohne dass die App die Dringlichkeit am Datensatz nicht speichert. |
| `difficulty` | integer oder `null` | Schwierigkeitsstufe `1`–`4` (aufsteigend); entspricht dem App-Aufgaben-Schwierigkeitsgrad (`taskDifficultyDegree`). Gleiches `/tasks`- versus `/history`-ContentProvider-Verhalten wie bei `importance`. |
| `exp` | integer | Konfigurierte EXP-Belohnung, kein Transaktionsbetrag; Standard `0`. |
| `skillIds` | integer array | Mit der Belohnung verknüpfte Attribute; leeres Array, falls nicht verfügbar. |
| `coin` | integer | Konfigurierte Münzbelohnung; Standard `0`. |
| `coinVariable` | integer | Einstellung für zufällige Münzbelohnungen; Standard `0`. |
| `itemId` | integer | Veraltete ID des ersten Belohnungsgegenstands; Standard `0`. Verwende `items` für die vollständige Liste. |
| `itemAmount` | integer | Veraltete Menge des ersten Belohnungsgegenstands; Standard `0`. Dieser HTTP-Name unterscheidet sich von der Provider-Spalte `itemCount`. |
| `words` | string | Motivationstext beim Abschluss; leer, falls nicht vorhanden. |
| `categoryId` | integer | Aufgaben-Kategorie-/Listen-ID; Standard `0`, falls nicht vorhanden. |
| `order` | integer | Sortierwert der Aufgabenliste; im Verlauf fester Platzhalter `0`, da dessen Provider die Spalte nicht zurückgibt. |
| `nameExtended` | string | Erweiterter Anzeigename; im Verlauf fester leerer Platzhalter, da dessen Provider die Spalte nicht zurückgibt. |
| `endTime` | integer | Gespeicherte Endzeit im Verlauf. `/tasks` setzt `0`; siehe [Zeitbedeutung](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Gegenstandsbelohnungen; leeres Array, falls nicht verfügbar. |
| `subTasks` | `SubTask[]` | Verschachtelte Teilaufgaben; leeres Array, falls nicht verfügbar. |
| `countProgress` | `TaskCountProgress` oder `null` | Momentaufnahme des Zählfortschritts, falls verfügbar; kann in beiden Ansichten erscheinen. |
| `repeatEndCondition` | `TaskRepeatEndCondition` oder `null` | Wiederholungs-Endregel in `/tasks`; in `/history` immer `null`. |

### Aufgabenstatus und Zeitstempel :id=task-times

| `status` | Bedeutung | Bedeutung von `endTime` im Verlauf |
| --- | --- | --- |
| `0` | Unerledigt | Keine Abschlusszeit; `/history` wählt stattdessen beendete Einträge. |
| `1` | Erledigt | Gespeicherter Abschlusszeitpunkt. |
| `2` | Überfällig | Gespeicherter Zeitpunkt der Verspätung. |
| `3` | Aufgegeben | Gespeicherter Zeitpunkt des Aufgebens. |

| Zeitfeld | Definition |
| --- | --- |
| `startTime` | Konfigurierte/geplante Startzeit der Aufgabe, nicht der tatsächliche Arbeitsbeginn. |
| `deadline` | Geplante Fälligkeit, getrennt von der gespeicherten Endzeit. |
| `endTime` | Gespeicherte Endzeit der Verlaufsaufgabe; wie oben zusammen mit `status` interpretieren. |

Alle drei verwenden Unix-Millisekunden. Beim normalen Abschluss speichert die App die aktuelle Zeit. `history_operation` mit `operation=edit_completed_time` nimmt `completed_time` entgegen und bearbeitet dieselbe gespeicherte Abschlusszeit; beim Lesen heißt das Feld weiterhin `endTime`.

Gespeicherte Zeiten lassen sich bearbeiten. Fehlt einem beendeten Eintrag das gespeicherte Enddatum, verwendet die App die aktuelle Zeit. `endTime` ist daher die aktuell gespeicherte Zeit, kein unveränderlicher Audit-Zeitstempel. `0` in `/tasks` ist nur ein SDK-Platzhalter, kein tatsächliches Ereignis an der Unix-Epoche.

### RewardItem :id=reward-item

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `itemId` | integer | ID des Belohnungsgegenstands. |
| `itemCount` | integer | Belohnungsmenge. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Feld | JSON-Typ | Bedeutung / Standard |
| --- | --- | --- |
| `id` | integer | Teilaufgaben-ID. |
| `gid` | integer | Teilaufgabengruppen-ID. |
| `todo` | string | Text der Teilaufgabe. |
| `status` | integer | `0` unerledigt, `1` erledigt. |
| `remindTime` | integer oder `null` | Erinnerungszeitstempel in Millisekunden; `null`, falls nicht verfügbar. |
| `endTime` | integer oder `null` | Abschlusszeitstempel der Teilaufgabe in Millisekunden; `null`, falls nicht verfügbar. |
| `exp` | integer | Konfigurierte EXP-Belohnung. |
| `coin` | integer oder `null` | Konfigurierte Münzbelohnung. |
| `coinVariable` | integer oder `null` | Einstellung für zufällige Münzbelohnungen. |
| `items` | `RewardItem[]` | Gegenstandsbelohnungen; standardmäßig leeres Array. |
| `order` | integer oder `null` | Sortierwert; Modellstandard `0`. |
| `autoUseItem` | boolean oder `null` | Ob Belohnungen automatisch verwendet werden; Modellstandard `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `currentCount` | integer | Aktueller Zählstand dieser Aufgabe/dieses Zyklus. |
| `targetCount` | integer | Zielzählstand dieser Aufgabe/dieses Zyklus. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Feld | JSON-Typ | Bedeutung / Standard |
| --- | --- | --- |
| `mode` | string | `COUNT` oder `DATE`. Dies sind Zeichenketten beim Lesen, nicht die numerischen Aktionsparameter. |
| `behavior` | string | `TERMINATE` oder `FREEZE`. |
| `targetCycleCount` | integer oder `null` | Zielanzahl der Zyklen für `COUNT`; Standard `null`. |
| `endDateMillis` | integer oder `null` | Enddatumszeitstempel in Millisekunden für `DATE`; Standard `null`. |
| `inclusive` | boolean | Kennzeichen für ein inklusives Enddatum; Standard `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Belohnungsbeträge :id=reward-amounts

Diese Aufgaben- und Teilaufgabenfelder beschreiben konfigurierte Belohnungen. Multiplikatoren, zufällige Münzen und Abrechnungsregeln können die tatsächliche Vergabe ändern. Verwende die [EXP- und Münzjournale](/guide/api-reference?id=reward-journals) für Transaktionsbeträge und unterscheide positive Belohnungen von Nettoänderungen einschließlich Rücknahmen oder Strafen.

### Implementierungsreferenzen :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Parser](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Zählfortschritt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Wiederholungsregel](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## Aufgaben- und Verlaufsabfragen :id=task-queries

Lies die [gemeinsamen Konventionen](/guide/api-reference?id=http-query-reference) und das [vollständige Aufgaben-/Verlaufsmodell](/guide/api-reference?id=task-history-models). Diese Endpunkte erfordern Clouds Berechtigung zum Lesen von LifeUp-Daten. Einfache Listenabfragen sind für LifeUp v1.91+ mit aktueller Cloud dokumentiert; die Beispiele beschreiben aktuelle SDK-Felder. Prüfe `/info` bei älteren Installationen.

### GET /tasks und /tasks/{categoryId} :id=get-tasks

Frage die aktuelle Liste **unerledigter** Aufgaben ab, optional auf eine Kategorie/Liste beschränkt. Das Ergebnis ist ein vollständiges Array ohne serverseitige Seitennavigation. Erledigte, überfällige und aufgegebene Einträge gehören zu `/history`.

| Parameter | Ort | Typ | Erforderlich | Standard / Verhalten |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | Nur für `/tasks/{categoryId}` | Lasse das gesamte Pfadsegment für die uneingeschränkte Aufgabenliste weg. |

Diese Routen unterstützen keine Abfrageparameter `offset`, `limit`, `gid` oder Datumsbereiche. Ein nicht ganzzahliges Kategoriesegment wird derzeit als fehlende Kategorie gelesen; validiere es vor der Anfrage, um nicht versehentlich alle Aufgaben abzufragen.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Antwort:** `HttpResponse<Task[]>`. Alle Felder und verschachtelten Strukturen stehen unter [Aufgaben-/Verlaufsfelder](/guide/api-reference?id=task-fields). Dieser erfundene Eintrag zeigt die vollständige HTTP-Struktur auf oberster Ebene; `endTime=0` ist hier ein Platzhalter, kein Abschlusszeitstempel.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": 3, "difficulty": 2,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Verhalten und Fehler:** Auswahl und Reihenfolge folgen LifeUps Aufgabenlistenlogik; der Endpunkt garantiert keine Sortierung nach Abschlusszeit. Ein erfolgreiches `data: []` bedeutet, dass die gewählte Aufgabenliste keine Einträge lieferte. Berechtigungs-/Provider-Fehler verwenden die [gemeinsame Fehlerhülle](/guide/api-reference?id=response-errors), keine leeren Arrays. Verwende für Abschlussberichte `/history` statt `endTime` dieser Route.

### GET /history :id=get-history

Frage sichtbare beendete Aufgaben ab, einschließlich erledigter, überfälliger und aufgegebener Aufgaben. Gelöschter Verlauf ist ausgeschlossen.

| Parameter | Ort | Typ | Erforderlich | Standard / Verhalten |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | Nein | `0`; Anzahl zu überspringender Einträge ab Index null. |
| `limit` | Query | integer | Nein | `100`; fordere eine positive Seitengröße an, vorzugsweise `1..100`. |
| `gid` | Query | integer | Nein | Kein Gruppenfilter; falls vorhanden, Auswahl dieser Aufgabengruppe über Zyklen hinweg. |

Der HTTP-Parser verwendet bei unlesbarem `offset` / `limit` die Ersatzwerte `0` / `100` und lässt ein unlesbares `gid` weg. Geparste Zahlen werden hier nicht begrenzt. Validiere nichtnegative Offsets und positive Limits selbst. `time_range_start` / `time_range_end` werden **nicht unterstützt**; ihre Angabe filtert den Verlauf nicht.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Antwort:** `HttpResponse<HistoryRecord[]>` mit den [HTTP-Feldern für Aufgaben/Verlauf](/guide/api-reference?id=task-fields). `HistoryRecord` bezeichnet in dieser Dokumentation die Verlaufsansicht des SDK-Modells `Task`. `repeatEndCondition` ist hier `null`; `countProgress` kann vorhanden sein. Die gespeicherte `endTime` ist zusammen mit `status` zu interpretieren.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "", "importance": null, "difficulty": null,
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Reihenfolge:** gespeichertes Enddatum absteigend, neueste zuerst. Für gleiche Enddaten ist kein zusätzliches Sortierkriterium dokumentiert. Die Seitennavigation bildet keinen Snapshot; vermeide Datenänderungen während der Berichtserfassung und entferne beim Zusammenführen doppelte Einträge anhand von `id`.

**Seitennavigation und leere Ergebnisse:** Verwende das [gemeinsame Verfahren](/guide/api-reference?id=pagination). Ein erfolgreiches leeres Array bedeutet, dass für diese Seite/Gruppe keine sichtbaren Einträge gefunden wurden, auch wenn `offset` hinter dem Ende liegt. Es beweist nicht, dass nie Aktivitäten stattfanden: Gelöschte Einträge fehlen und es gibt kein Vollständigkeitskennzeichen. Schlägt eine Anfrage fehl, melde nicht verfügbare/unvollständige Daten statt null Aufgaben. Es gelten die [gemeinsamen Fehler](/guide/api-reference?id=response-errors).

### Tagesbericht erstellen :id=daily-report

1. Wähle die Zeitzone des Berichts. Berechne den Beginn des Kalendertags (`dayStart`) und des Folgetags (`nextDayStart`). Nimm nicht an, dass jeder lokale Tag genau 24 Stunden dauert.
2. Lies `/history` mit `offset=0&limit=100`, prüfe jede Antwort und erfasse alle Seiten. Behalte einen vorgesehenen `gid`-Filter durchgehend bei.
3. Wähle `status == 1` und `dayStart <= endTime < nextDayStart`. Beachte bei der Ergebnisbeschreibung die [Grenzen gespeicherter Zeiten](/guide/api-reference?id=task-times).
4. Lies für tatsächliche EXP- und Münzänderungen die [Belohnungsjournale](/guide/api-reference?id=reward-journals) desselben Tages. Ihre Datumsfilter schließen beide Grenzen ein; verwende daher `time_range_start=dayStart` und `time_range_end=nextDayStart-1`.
5. Unterscheide „keine Einträge in den verfügbaren Daten gefunden“ von fehlgeschlagenem/unvollständigem Lesen. Entscheide, ob der Bericht nur positive Belohnungen oder Nettoänderungen einschließlich Rücknahmen zeigt, und wende dies konsistent an.

`exp` und `coin` von Aufgaben/Verlauf sind konfigurierte Belohnungen und kein zuverlässiger Ersatz für Journalbeträge. Wird eine Abschlusszeit auf einen anderen Tag geändert, bedeutet das nicht, dass die Transaktionszeit im Belohnungsjournal mitverschoben wurde.

### Implementierungsreferenzen :id=api-task-queries-sources

[HTTP-Routen](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Aufgaben- und Verlaufsparser](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## EXP- und Münzjournal-Abfragen :id=reward-journals

Diese nur lesenden HTTP-Endpunkte erfordern die Berechtigung zum Lesen von LifeUp-Daten, LifeUp **1.106.0+** und LifeUp Cloud **3.0.0+**. Sie liefern gespeicherte Änderungen einschließlich Abzügen und Rücknahmen statt der konfigurierten Aufgabenbelohnungen. Lies zuerst die [gemeinsamen Konventionen](/guide/api-reference?id=http-query-reference).

### Anfrageparameter beider Endpunkte :id=journal-parameters

Der folgende Vertrag gilt ausdrücklich für **beide** Endpunkte `GET /exp_records` und `GET /coin_records`.

| Parameter | Ort | Typ | Erforderlich | Standard / tatsächliches Verhalten |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | Nein | HTTP-Standard `0`; der Provider begrenzt negative Werte auf `0`. |
| `limit` | Query | integer | Nein | HTTP-Standard `100`; der Provider begrenzt auf `1..200`. Verwende `1..100` für das gemeinsame Seitenverfahren. |
| `time_range_start` | Query | integer (Unix-Millisekunden) | Nein oder paarweise | Inklusive Untergrenze der gespeicherten Transaktionszeit. |
| `time_range_end` | Query | integer (Unix-Millisekunden) | Nein oder paarweise | Inklusive Obergrenze; gültige Filterung erfordert `start < end`. |

Unlesbare oder außerhalb des Wertebereichs liegende Seitenparameter verwenden HTTP-Standardwerte. Unlesbare Datumswerte gelten als fehlend. Das aktuelle SDK leitet einen Datumsbereich nur weiter, wenn beide Grenzen vorhanden sind und `start < end` gilt; andernfalls fragt es **ohne Datumsfilter** ab. Direkte rohe ContentProvider-Aufrufe validieren ungültige Bereiche anders. Validiere die Grenzen im HTTP-Aufrufer.

Beide Endpunkte sortieren absteigend nach gespeicherter Transaktionszeit, neueste zuerst, und schließen gelöschte Journaleinträge aus. Sie garantieren weder ein zusätzliches ID-Sortierkriterium noch einen Snapshot über mehrere Seiten. Folge der [Seitennavigation](/guide/api-reference?id=pagination) und beachte das effektive Provider-Limit. Ein erfolgreiches leeres Array bedeutet, dass keine Einträge zum gewählten Bereich/zur Seite passen; fehlgeschlagenes Lesen bedeutet nicht keine Aktivität. Kein Endpunkt bietet ein Vollständigkeitskennzeichen für gelöschte oder nicht verfügbare Daten.

### GET /exp_records :id=get-exp-records

Frage EXP-Änderungen ab. Es gelten genau die [vier Journalparameter oben](/guide/api-reference?id=journal-parameters); einen `gid`-Filter gibt es nicht.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Antwort:** `HttpResponse<ExpRecord[]>`. Die aktuelle Serialisierung enthält alle aufgeführten Felder einschließlich der Felder, die Nullwerte zulassen.

| Feld | JSON-Typ | Bedeutung / Parser-Ersatzwert |
| --- | --- | --- |
| `id` | integer oder `null` | ID des Journaleintrags. |
| `time` | integer oder `null` | Transaktionszeit in Unix-Millisekunden, unabhängig von einer bearbeitbaren Aufgabenabschlusszeit. |
| `value` | integer | EXP-Änderung je zugeordnetem Attribut; Ersatzwert `0`. Verwende `isDecrease` für die Richtung. |
| `isDecrease` | boolean | `true` bei Abzug, `false` bei Zuwachs; der Parser behandelt die Provider-Ganzzahl `1` als wahr. |
| `totalValue` | integer | Gespeicherte gesamte EXP-Änderung, **kein EXP-Kontostand**; Ersatzwert `0`. Bei Stapeln mehrerer Attribute können sich gespeicherte Gesamtsummen überschneiden; siehe [Berichtssummen](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | EXP-spezifischer Ursachencode; Ersatzwert `0`. |
| `relatedId` | integer oder `null` | ID des zugehörigen Quellobjekts. Beim normalen Aufgabenabschluss die Aufgaben-`id`, nicht deren `gid`. Andere Ursachen können andere Ressourcen betreffen. |
| `content` | string oder `null` | Beschreibung der Änderung. |
| `skillIds` | integer array | IDs zugeordneter Attribute/Fähigkeiten; Ersatzwert leeres Array. |
| `relatedAttributes` | string array | Zugeordnete veraltete Attributzeichenketten; Ersatzwert leeres Array. |

Erfundenes Beispiel: je 10 EXP für zwei Attribute, insgesamt 20 EXP.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Fehler:** [Gemeinsame HTTP-/Provider-Fehler](/guide/api-reference?id=response-errors). Ungültige HTTP-Datumsgrenzen können wie oben beschrieben die Filterung stillschweigend entfernen, statt einen Fehler auszulösen.

### GET /coin_records :id=get-coin-records

Frage Münzänderungen ab. Es gelten genau die [vier Journalparameter oben](/guide/api-reference?id=journal-parameters); einen `gid`-Filter gibt es nicht.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Antwort:** `HttpResponse<CoinRecord[]>`. Die aktuelle Serialisierung enthält alle aufgeführten Felder einschließlich der Felder, die Nullwerte zulassen.

| Feld | JSON-Typ | Bedeutung / Parser-Ersatzwert |
| --- | --- | --- |
| `id` | integer oder `null` | ID des Journaleintrags. |
| `time` | integer oder `null` | Transaktionszeit in Unix-Millisekunden. |
| `value` | integer | Betrag der Münzänderung; Ersatzwert `0`. Verwende `isDecrease` für die Richtung. |
| `isDecrease` | boolean | `true` bei Abzug, `false` bei Zuwachs; der Parser behandelt die Provider-Ganzzahl `1` als wahr. |
| `totalValue` | integer | Münzkontostand nach der Operation; Ersatzwert `0`. Anders als EXP-`totalValue` ist dies ein Kontostand. |
| `resCode` | integer | Münzspezifischer Ursachencode; Ersatzwert `0`. |
| `relatedId` | integer oder `null` | ID des zugehörigen Quellobjekts; beim normalen Aufgabenabschluss die Aufgaben-`id`. Andere Quellen anhand des Ursachencodes interpretieren. |
| `content` | string oder `null` | Beschreibung der Änderung. |
| `savingBalance` | integer oder `null` | Für die Operation gespeichertes Sparguthaben. |

Erfundenes Beispiel: Abzug von 5 Münzen, verbleibender Münzkontostand 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Fehler:** [Gemeinsame HTTP-/Provider-Fehler](/guide/api-reference?id=response-errors). Ungültige HTTP-Datumsgrenzen können wie oben beschrieben die Filterung stillschweigend entfernen, statt einen Fehler auszulösen.

### Ursachencodes und Berichtssummen :id=journal-totals

Die Wertebereiche der Ursachencodes unterscheiden sich. Ausgewählte Beispiele:

| Ursache | EXP-`resCode` | Münz-`resCode` |
| --- | --- | --- |
| Aufgabe abschließen | `1` | `2` |
| Aufgabenabschluss rückgängig machen | `101` | `3` |
| Teilaufgabe abschließen | `12` | `11` |
| Teilaufgabenabschluss rückgängig machen | `106` | `12` |
| API-Änderung | `200` | `28` |

Vollständige EXP-Codes: `0` unbekannt; `1` Aufgabenabschluss; `2` Erfolg; `3` Like-Tausch; `4` Nutzungstage-Serie; `5` Schrittetausch; `6` als abgeschlossen markieren; `7` Aufgeben rückgängig; `8` Überfälligkeit rückgängig; `9` Tomate essen; `10` Gegenstand verwenden; `11` Benutzererfolg freischalten; `12` Teilaufgabenabschluss; `200` API; `101` Abschluss rückgängig; `102` Aufgeben; `103` Überfälligkeit; `104` Gegenstandsverwendung verringert EXP; `105` Benutzererfolg erneut sperren; `106` Teilaufgabenabschluss rückgängig. Münz-Ursachencodes verwenden denselben Wertebereich wie [Inventar-Datensätze](#get-inventory-records). Erhalte unbekannte künftige Codes. Berechne Nettoänderungen mit der Richtung aus `isDecrease` (`true` zieht den gespeicherten Betrag ab). Nimm nicht an, dass ein Abzug als negatives `value` kodiert ist; die Zahlentypen sind vorzeichenbehaftet und es gibt keine Zusicherung vorzeichenloser Werte oder Absolutbeträge.

EXP-`value` gilt je Attribut. Summiere EXP-`totalValue` nicht blind über Einträge hinweg: Die aktuelle Stapellogik kann bei mehr als drei Attributen überlappende Gesamtsummen speichern. Eine Änderung von je 10 EXP für vier Attribute kann beispielsweise gespeicherte Summen von 40 und 10 erzeugen, deren Summe nicht verlässlich 40 ergibt. Gleiche für genaue Berichte das attributbezogene `value` mit den in jedem Eintrag aufgeführten Attributen ab; fehlende Zuordnungen begrenzen mögliche Aussagen. Addiere `value` und `totalValue` nicht und bezeichne EXP-`totalValue` nicht als Kontostand.

Berechne für einen Kalendertag das lokale `dayStart` und `nextDayStart` und fordere `[dayStart, nextDayStart - 1]` an, da beide Grenzen inklusiv sind. Wähle Ursachencodes für reine Aufgabenbelohnungsberichte; lasse sie ungefiltert, wenn alle gespeicherten Änderungen berichtet werden. [Tagesberichtsverfahren](/guide/api-reference?id=daily-report).

### Implementierungsreferenzen :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Weiterleitung von Datumsparametern](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Gegenstände und Kategorien :id=get-items

`GET /items` liefert `ShopItem[]`. Der optionale wiederholte Parameter `id` wählt Gegenstands-IDs: `/items?id=1&id=2`. Nichtganzzahlige Werte werden verworfen. Nicht vorhandene IDs werden übersprungen; gültige IDs behalten einschließlich Duplikaten die Anfragereihenfolge. Sind alle angegebenen IDs ungültig, sendet das SDK keinen ID-Filter und die normale Gegenstandsliste wird geliefert. Keine Seitennavigation.

`GET /items/{listId}` liefert `ShopItem[]` einer **Kategorie**, keinen einzelnen Gegenstand. `listId` ist eine vorzeichenbehaftete 64-Bit-Kategorie-ID; `-1` bedeutet alle. Ein ungültiger Pfadwert fällt auf alle zurück. Die normale Liste schließt ausgelistete/gelöschte Gegenstände aus (`isDel=0`) und verwendet die konfigurierte Shop-/Kategoriesortierung. Eine ID-Auswahl kann Gegenstände unabhängig von diesem normalen Listenfilter abrufen.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Gegenstands-ID. |
| `name` | string | Name des Gegenstands. |
| `desc` | string | Beschreibung. |
| `icon` | string | Lesbare Bild-URI oder leere Zeichenfolge. Download über `/files/{url}`. |
| `categoryId` | integer | ID der Shop-Kategorie. |
| `stockNumber` | integer | Verfügbarer Bestand; negativer Bestand gilt bei der Berechnung von `maxPurchaseNumber` als unbegrenzt. |
| `ownNumber` | integer | Eigene Menge im Inventar. |
| `price` | integer | Preis in Münzen. |
| `order` | integer | Gespeicherte Reihenfolge innerhalb der Kategorie. |
| `disablePurchase` | boolean | Kennzeichen für deaktivierten Kauf. |
| `maxPurchaseNumber` | integer oder null | Berechnet aus verfügbaren Münzen plus Kredit und begrenztem Bestand; deaktivierter Kauf ergibt 0, kostenloser unbegrenzter Bestand kann 2147483647 ergeben. Nicht alle Kaufbeschränkungen werden ausgewertet. |
| `titleColorString` | string oder null | Benutzerdefinierte Titelfarbe. |
| `actionText` | string oder null | Benutzerdefinierter Text der Verwenden-Schaltfläche. |
| `unlist` | boolean | Kennzeichen für ausgelistet/gelöscht; bei Listen normalerweise false. |
| `disableUse` | boolean | Ob der Gegenstand einen nicht verwendbaren Effekt hat. |
| `purchaseLimit` | string oder null | **JSON-kodierte Zeichenfolge**, kein verschachteltes Array; Kaufbeschränkungen des Gegenstands. |
| `limitScope` | string oder null | `purchase`, `use` oder `both`. |

### GET /items_categories :id=get-items-categories

Liefert `ShopCategory[]`. Optionales `include_hidden` hat den Standard `false`; nur die exakten Kleinbuchstabenwerte `true` und `false` werden erkannt, alle anderen ergeben false. Enthält die virtuelle Kategorie „Alle“. Der HTTP-Server stellt `/items_categories/{id}` nicht bereit.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Kategorie-ID. |
| `name` | string | Name der Kategorie. |
| `isAsc` | boolean | Konfiguriertes Kennzeichen für aufsteigende Sortierung. |
| `sort` | string | Gespeicherte Sortiereinstellung. |
| `order` | integer | Reihenfolge der Kategorie. |
| `hidden` | boolean | Im Shop verborgen. |
| `inventoryHidden` | boolean | Im Inventar verborgen. |

### GET /tasks_categories :id=get-tasks-categories

Liefert `TaskCategory[]`, einschließlich der Kategorie „Alle“ und archivierter Kategorien. Keine Abfrageparameter oder Seitennavigation. Der HTTP-Server stellt `/tasks_categories/{id}` nicht bereit. Sortier-/Filterwerte der Kategorien sind gespeicherte App-Einstellungen und werden hier nicht als Anfragefilter angewendet.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Kategorie-ID. |
| `name` | string | Name. |
| `isAsc` | boolean | Gespeichertes Kennzeichen für aufsteigende Sortierung. |
| `sort` | string | Gespeicherte Sortiereinstellung. |
| `filter` | string | Gespeicherte Gruppierungs-/Filtereinstellung. |
| `order` | integer | Reihenfolge der Kategorie. |
| `status` | integer | 0 normal; 1 archiviert. |
| `type` | integer | 0 normal; intelligente Listen: 10 täglich, 11 wöchentlich, 12 monatlich, 20 in Bearbeitung. |

## Attribute und Attributgruppen :id=get-skills

`GET /skills` liefert `Skill[]`, ohne Parameter oder Seitennavigation. Verborgene/gelöschte Attribute sind ausgeschlossen; die gespeicherte Reihenfolge gilt. `group_id` und `status` des zugrunde liegenden ContentProvider sind **keine** HTTP-Modellfelder.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Attribut-ID. |
| `name` | string | Lokalisierter Attributname. |
| `desc` | string | Beschreibung. |
| `icon` | string | Lesbare Symbol-URI oder leer. |
| `order` | integer | Gespeicherte Reihenfolge. |
| `color` | integer | Gepackter Android-Farbwert als Ganzzahl. |
| `exp` | integer | Aktuelle Gesamt-EXP. |
| `level` | integer | Aktuelle Stufe. |
| `untilNextLevelExp` | integer | Verbleibende EXP bis zur nächsten Stufe. |
| `currentLevelExp` | integer | Seit Beginn der aktuellen Stufe erhaltene EXP. |
| `type` | integer | 0 benutzerdefiniert; 1 Stärke; 2 Lernen; 3 Charme; 4 Ausdauer; 5 Vitalität; 6 Kreativität. |

### GET /skill_groups :id=get-skill-groups

Liefert `SkillGroup[]`. `include_hidden` verwendet dieselbe strikte Boolean-Auswertung wie `/items_categories`, Standard false. Das aktuelle App-Repository ignoriert dieses Kennzeichen für Gruppen und schließt gelöschte Gruppen immer aus. Gespeicherte Reihenfolge aufsteigend. Keine Seitennavigation.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Gruppen-ID. |
| `content` | string | Gruppentitel. |
| `order` | integer | Gespeicherte Gruppenreihenfolge. |
| `collapsed` | boolean | Eingeklappter Zustand. |

## Erfolge :id=get-achievements

`GET /achievements` liefert `Achievement[]`, indem jede Kategorie in Kategoriereihenfolge geladen und ihre Erfolge angehängt werden. `GET /achievements/{id}` liefert Erfolge **in Kategorie `id`**, keine Erfolgsdetails. Ungültige Pfad-IDs verhalten sich wie die ungefilterte Route. Die Sortierung innerhalb einer Kategorie folgt deren App-Einstellung. Beide Endpunkte sind nicht paginiert.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Erfolgs-ID. |
| `name` | string | Titel. |
| `desc` | string | Beschreibung. |
| `iconUri` | string | Symbol-URI oder leer. |
| `categoryId` | integer | Kategorie-ID. |
| `status` | integer | 0 unvollständig; 1 abgeschlossen mit nicht abgeholter Belohnung; 2 Belohnung abgeholt/anderer abgeschlossener Zustand. |
| `exp` | integer | EXP-Belohnung. |
| `coin` | integer | Münzbelohnung. |
| `coinVariable` | integer | Variable Münzbelohnung. |
| `type` | integer | 0 Erfolg; 1 Unterkategorieüberschrift. |
| `progress` | integer | Gespeicherter Fortschritt. |
| `order` | integer | Reihenfolge innerhalb der Kategorie. |
| `itemId` | integer oder null | ID des ersten Belohnungsgegenstands (älteres Hilfsfeld). |
| `itemAmount` | integer oder null | Menge des ersten Belohnungsgegenstands. |
| `unlockedTime` | integer oder null | Freischaltzeit als Unix-Millisekunden. |
| `items` | RewardItem[] oder null | Vollständige Belohnungsgegenstandsliste; der aktuelle Parser liefert bei fehlendem/fehlerhaftem Gegenstands-JSON ein leeres Array. |
| `color` | string oder null | Benutzerdefinierte Titelfarbe. |

Belohnungsgegenstände verwenden das gemeinsame Modell [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Liefert `AchievementCategory[]`, ohne Parameter oder Seitennavigation. Der HTTP-Server stellt `/achievement_categories/{id}` nicht bereit.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Kategorie-ID. |
| `name` | string | Name. |
| `desc` | string | Beschreibung. |
| `iconUri` | string | Symbol-URI/Zeichenfolge. |
| `isAsc` | boolean | Kennzeichen für aufsteigende Sortierung. |
| `sort` | string | Gespeicherte Sortiereinstellung. |
| `filter` | string | Gespeicherte Gruppierungs-/Filtereinstellung. |
| `order` | integer | Reihenfolge der Kategorie. |
| `type` | integer | 0 Benutzererfolge; 1 Systemerfolge. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Liefert `AchievementCondition[]` für die **Erfolgs-ID** `id`. Eine nichtganzzahlige ID ergibt eine Fehlerhülle mit Code 500. Ohne passende Bedingungen wird ein leeres Array geliefert. Es gibt keine Sammlungsroute `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Bedingungs-ID. |
| `type` | integer | Bedingungscode; siehe unten. |
| `relatedId` | integer | Je nach Bedingung die zugehörige Aufgaben-/Gegenstands-/Attribut-ID. |
| `target` | integer | Zielwert. |
| `current` | integer | Aktueller kumulierter Wert. |
| `progress` | integer | Gespeicherter Fortschritt. |

Bedingungscodes: 0 Aufgabenabschlüsse; 1 aktuelle Aufgabenserie; 2 älteres Attributlevel; 3 Tomaten; 4 App-Nutzungstage; 5 Likes; 6 aufeinanderfolgende Abschlusstage; 7 aktuelle Münzen; 8 Münzen an einem Tag erhalten; 9 Aufgabentomaten; 10 Gegenstandskäufe; 11 Gegenstandsverwendungen; 12 Lootbox-Gegenstandsgewinne; 13 Attributlevel; 14 Lebenslevel; 15 kumulierte Gegenstandsgewinne; 16 Synthesegewinne; 17 aktuell eigene Gegenstandsmenge; 18 Aufgabenfokuszeit; 19 ATM-Ersparnisse; 20 externe API. Wiederholte Bedingungen: 500 Aufgabenabschlüsse; 501 Attributlevelanstiege; 502 Tomaten; 503 Münzen; 504 Gegenstandsgewinne; 505 Gegenstandskäufe; 506 Lootbox-Gewinne; 507 Synthesegewinne; 508 Gegenstandsverwendungen; 509 Aufgabenfokusminuten; 510 Aufgabentomaten; 511 Likes; 512 ATM-Sparzuwächse; 513 externe API-Aufrufe; 514 Nutzungstage; 515 Lebenslevelanstiege; 516 tägliche Münzen; 517 aufeinanderfolgende Aufgabenabschlüsse; 518 tägliche Tomaten; 519 tägliche Fokusminuten; 520 tägliche unterschiedliche Aufgabengruppen; 521 tägliche Gegenstandsverwendungen; 522 tägliche Gegenstandskäufe; 523 tägliche Abschlüsse einer bestimmten Aufgabe; 524 gesamte tägliche Aufgabenabschlussdatensätze. Dies sind rohe Ganzzahlcodes, keine serialisierten Enum-Namen.

## Synthese :id=get-synthesis

`GET /synthesis` liefert `Synthesis[]` aus sichtbaren Kategorien. `GET /synthesis/{id}` liefert Rezepte **in Kategorie `id`**, einschließlich ihrer verborgenen Inhalte. Nichtnegative IDs wählen eine Kategorie; negative bedeuten alle sichtbaren Kategorien. Ungültige IDs fallen auf die Sammlungsroute zurück. Ergebnisse folgen der gespeicherten Rezeptreihenfolge aufsteigend; gelöschte Rezepte sind ausgeschlossen. Keine Seitennavigation.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Rezept-ID. |
| `name` | string | Name. |
| `desc` | string | Beschreibung. |
| `input` | SynthesisItemInfo[] | Benötigte Gegenstände. |
| `output` | SynthesisItemInfo[] | Erzeugte Gegenstände. |
| `categoryId` | integer oder null | Kategorie-ID. |
| `canSynthesisTimes` | integer | Aktuell mögliche Anzahl von Synthesen. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `itemId` | integer | Gegenstands-ID. |
| `itemName` | string | Name des Gegenstands. |
| `amount` | integer | Eingabe-/Ausgabemenge pro Synthese. |
| `ownedNumber` | integer | Eigene Menge. |
| `icon` | string | Lesbare Symbol-URI oder leer. |

### GET /synthesis_categories und /synthesis_categories/{id} :id=get-synthesis-categories

Beide liefern `SynthesisCategory[]`. Die optionale Pfad-ID `id` filtert die Kategorie-ID, ändert aber nicht die Array-Form. Ungültige IDs wählen alle Kategorien. Optionales `include_hidden` verwendet strikte kleingeschriebene Boolean-Werte und standardmäßig false, auch bei angegebener Kategorie-ID. Keine Seitennavigation.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Kategorie-ID. |
| `name` | string | Name. |
| `isAsc` | boolean | Gespeichertes Kennzeichen für aufsteigende Sortierung. |
| `sort` | string | Gespeicherte Sortiereinstellung. |
| `order` | integer | Reihenfolge der Kategorie. |
| `hidden` | boolean | Verborgen-Kennzeichen. |

## Gefühle :id=get-feelings

`GET /feelings` liefert `Feelings[]`. `offset` hat den Standard 0 und `limit` 100; fehlende oder nichtganzzahlige Werte verwenden diese Standards. Keine explizite Begrenzung. Verwende nichtnegative Offsets und positive Limits. Gelöschte Gefühle sind ausgeschlossen. Die Sortierung folgt der App-Einstellung (`createTime` auf- oder absteigend), keinem Anfrageparameter. Kein Zeitfilter verfügbar.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Gefühls-ID. |
| `content` | string | Text. |
| `isFav` | boolean | Favoritenkennzeichen. |
| `title` | string | Zugehöriger Titel. |
| `time` | integer | Erstellzeit als Unix-Millisekunden. |
| `attachments` | string[] | Lesbare Anhang-URIs für vorhandene, nicht leere Dateien. |
| `type` | integer | 0 Aufgabe; 1 Erfolg; 2 unabhängiger Eintrag. |

## Pomodoro-Datensätze :id=get-pomodoro-records

`GET /pomodoro_records` liefert `PomodoroRecord[]`. Standard: `offset` 0, `limit` 100; keine explizite Begrenzung. Optionales `time_range_start` und `time_range_end` sind Unix-Millisekunden. Das SDK leitet den Bereich nur weiter, wenn beide als 64-Bit-Ganzzahlen lesbar sind und Start kleiner als Ende ist; sonst entfällt der Bereich stillschweigend.

Ohne Bereich werden abgeschlossene, nicht gelöschte Datensätze mit `startTime != endTime` und positivem `endTime` nach `endTime DESC, startTime DESC, id DESC` geliefert. Ein gültiger Bereich wählt `start < endTime <= end` und schließt gelöschte Zeilen aus.

> [!WARNING]
> Frühere Implementierungen übergaben bei Datumsbereichsabfragen `limit` und `offset` vertauscht an das DAO und legten keine Sortierung fest. Der lokale LifeUp-Quellcode verwendet nun benannte Argumente und sortiert paginierte Ergebnisse nach `endTime DESC, startTime DESC, id DESC`; diese lokale Korrektur wurde noch nicht veröffentlicht. Bis du bestätigt hast, dass deine installierte LifeUp-Version sie enthält, lasse den Bereich weg und filtere die Ergebnisse im Client, um zuverlässig zu paginieren.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Datensatz-ID. |
| `startTime` | integer oder null | Startzeit als Unix-Millisekunden. |
| `endTime` | integer oder null | Endzeit als Unix-Millisekunden. |
| `duration` | integer | Millisekunden: gespeichertes `lastTime`, sofern ungleich 0, sonst Ende minus Start. |
| `reward` | number | Verdiente Tomaten: abgebrochen = 0; halb = 0,5 × Multiplikator; sonst Multiplikator. |

## Inventar-Datensätze :id=get-inventory-records

`GET /inventory_records` liefert `InventoryRecord[]`. `offset` hat den Standard 0 und wird auf mindestens 0 begrenzt; `limit` hat den Standard 100 und wird auf 1–200 begrenzt. Optionales `time_range_start` und `time_range_end` werden nur als gültige 64-Bit-Ganzzahlen mit Start < Ende weitergeleitet; ungültige/unvollständige Bereiche lässt das SDK stillschweigend weg. Gültige Bereiche verwenden inklusives `time >= start AND time <= end`. Gelöschte Datensätze sind ausgeschlossen (`isDel` null oder 0); Sortierung `time DESC, id DESC`. Kein Gegenstands-ID-Filter.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Datensatz-ID. |
| `time` | integer oder null | Erstellzeit als Unix-Millisekunden. |
| `itemId` | integer oder null | Zugehörige Gegenstands-ID. |
| `itemName` | string oder null | Name des zugehörigen Gegenstands, sofern verfügbar. |
| `changeNumber` | integer | Gespeicherte Mengenänderung. |
| `isDecrease` | boolean | Ob die Änderung das Inventar verringert. |
| `resCode` | integer | Ursachencode der Quelle; siehe unten. |
| `desc` | string oder null | Beschreibung des Datensatzes. |

Ursachencodes: 0 Kauf; 1 Verwendung; 2 Aufgabenabschluss; 3 Abschluss rückgängig; 4 Daten löschen; 5 Aufgabe aufgeben; 6 Aufgabe überfällig; 7 eingebauten Erfolg freischalten; 8 Aufgeben rückgängig; 9 Überfälligkeit rückgängig; 10 Gegenstand zurückgeben; 11 Teilaufgabenabschluss; 12 Teilaufgabenabschluss rückgängig; 13 Benutzererfolg freischalten; 14 Benutzererfolg rückgängig; 15 Einzahlung; 16 Auszahlung; 17 Tomatenverkauf; 20 Gegenstandsbelohnung; 21 Belohnung rückgängig; 23 Synthese; 24 Lootbox; 25 ATM-Zinsen; 26 Tomaten gegen Gegenstand tauschen; 27 Kreditzinsen; 28 API; 29 Bestandsänderung durch Gegenstandseffekt. Clients sollten unbekannte künftige Codes erhalten.

## Schritt-Datensätze :id=get-step-records

`GET /step_records` liefert `StepRecord[]`. Standards/Begrenzungen der Seitennavigation und SDK-Regeln zum Weglassen von Bereichen entsprechen `/inventory_records`. Der gültige Zeitfilter ist auf `date` inklusiv; Sortierung `date DESC` ohne expliziten Zweitschlüssel.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Datensatz-ID. |
| `date` | integer oder null | Gespeichertes Datum als Unix-Millisekunden. |
| `dailyStepCount` | integer | Tägliche Schrittzahl. |
| `totalStepCount` | integer | Gespeicherte kumulierte Schrittzahl. |
| `isGotReward` | boolean | Kennzeichen für abgeholte Belohnung. |
| `isUserInput` | boolean | Kennzeichen für Benutzereingabe. |
| `rewardLevel` | integer oder null | Gespeicherte Belohnungsstufe. |

## Stufendefinitionen :id=get-level-defines

`GET /level_defines` liefert ein einzelnes `LevelDefines`-Objekt. Keine Parameter. Verwendet im benutzerdefinierten Stufenmodus eigene Definitionen, sonst eingebaute.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `custom` | boolean | Modus für benutzerdefinierte Stufen. |
| `levels` | LevelDefine[] | Stufenbereiche. |

### LevelDefine :id=model-level-define

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer oder null | Definitions-ID. |
| `levelStart` | integer | Anfangsstufe. |
| `levelEnd` | integer | Endstufe. |
| `perLevelExp` | integer | Erforderliche EXP je Stufe im Bereich. |

Fehlerhaftes Stufen-JSON wird derzeit zu einem leeren `levels`-Array, ohne die gesamte Anfrage fehlschlagen zu lassen.

## Statistiken :id=get-statistics

`GET /statistics` liefert ein `Statistics`-Objekt. Optionales `time_range_start` und `time_range_end` sind Unix-Millisekunden mit derselben SDK-Weiterleitungsregel: beide gültig und Start < Ende, sonst kein Bereich. Ohne Bereich verwendet die App ihren ersten gespeicherten Zeitstempel bis jetzt; fehlt dieser, die letzten 30 Tage. `usingDays` und `companionDays` gelten auch bei angegebenem Bereich für die gesamte Nutzungszeit. Weitere Kennzahlen berechnen die jeweiligen App-Statistikmethoden; identische Ein-/Ausschlussregeln aller zugrunde liegenden Abfragen dürfen nicht angenommen werden.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `start` | integer oder null | Wirksamer Bereichsanfang als Unix-Millisekunden. |
| `end` | integer oder null | Wirksames Bereichsende als Unix-Millisekunden. |
| `tomatoes` | integer | Statistik verdienter Tomaten. |
| `pomodoroMinutes` | integer | Fokusdauer in Minuten. |
| `focusCount` | integer | Anzahl der Fokussitzungen. |
| `tasksCompleted` | integer | Für die Abschlussstatistik verwendete Anzahl abgeschlossener Aufgaben. |
| `tasksTotal` | integer | Für diese Statistik verwendete Gesamtzahl der Aufgaben. |
| `taskCompleteRate` | number | Abschlussquote. |
| `feelingsCount` | integer | Anzahl der Gefühle. |
| `usingDays` | integer | Nutzungstage seit Beginn. |
| `companionDays` | integer | Begleitungstage seit Beginn. |
| `interestChanged` | integer | Statistik der Münzänderung durch Zinsen. |
| `coinPurchaseConsumed` | integer | Statistik des Münzverbrauchs durch Käufe. |

## App-Informationen und Münzstand :id=get-info

`GET /info` liefert `Info`. LifeUp Cloud ergänzt die App-/Provider-Informationen um seine eigene installierte Version. Keine Parameter.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `appVersion` | integer | Installierter LifeUp-Versionscode. |
| `appVersionName` | string | Installierter LifeUp-Versionsname. |
| `apiVersion` | integer | LifeUp-API-Version. |
| `cloudVersion` | integer | Installierter LifeUp-Cloud-Versionscode. |
| `cloudVersionName` | string | Installierter LifeUp-Cloud-Versionsname. |

### GET /coin :id=get-coin

Ruft `lifeup://api/query?key=coin` über den ContentProvider auf und liefert dessen Ergebnisobjekt. Keine Parameter. Ein null-Ergebnis wird zum leeren Objekt. Die Felder legt der Provider fest; es gibt keine typisierte `CoinData`-Antwort. Eine erfolgreiche Abfrage liefert `value` (Münzstand als vorzeichenbehaftete 64-Bit-Ganzzahl) und `api_result: true`; Fehler können die unten beschriebenen Provider-Status-/Fehlerfelder enthalten.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Eine URL-Scheme-API aufrufen :id=invoke-api

Der [URL-Scheme-API-Katalog](/guide/api) definiert Methodennamen, Parameter und methodenspezifische Ergebnisse. Die HTTP-Brücke akzeptiert die vollständige URL `lifeup://api/...`.

| Übertragung | Eingabe | Ausführung und Antwort |
| --- | --- | --- |
| `GET /api` | Wiederholter URL-kodierter Parameter `url` | Startet je URL eine Android-Activity in angegebener Reihenfolge. Liefert die Zeichenfolge `success`. Fehlende URLs ergeben ebenfalls Erfolg. |
| `POST /api` | JSON `RawQueryVo` | Startet zuerst alle `urls`-Einträge, danach `url`, falls vorhanden. Liefert die Zeichenfolge `success`. Ein leeres Eingabeobjekt gelingt ebenfalls. |
| `GET /api/contentprovider` | Wiederholter URL-kodierter Parameter `url` | Ruft den Provider synchron auf und liefert `CallUrlResult[]` in angegebener Reihenfolge. Fehlende URLs ergeben eine Fehlerhülle (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Ruft zuerst alle `urls`-Einträge auf, dann `url`; liefert `CallUrlResult[]`. Ein leeres Objekt ergibt ein leeres Array. |

Setze bei JSON-POSTs `Content-Type: application/json`. Kodiere beim Einbetten in eine GET-Abfrage die gesamte URL, einschließlich interner `&`, `?`, `+` und Prozentkodierungen. Eine erfolgreiche Activity-Brückenantwort bestätigt die Übergabe, nicht den Abschluss der LifeUp-Aktion. ContentProvider-Methoden benötigen Clouds Berechtigung in LifeUp; die Unterstützung hängt von der URL-Scheme-Methode ab. Aufrufe erfolgen nacheinander; wirft ein späterer Aufruf einen Fehler, werden frühere Wirkungen nicht zurückgesetzt.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Antwort der Activity-Brücke:

```json
{"code":200,"message":"success","data":"success"}
```

Antwort der Provider-Brücke (beispielhaftes Provider-Ergebnis):

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `url` | string oder null | Optionale einzelne URL. |
| `urls` | string[] oder null | Optionale URL-Liste; wird vor `url` verarbeitet. |

### CallUrlResult :id=model-call-url-result

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `url` | string | Übermittelte URL. |
| `result` | object oder null | Konvertiertes Provider-Bundle; null lässt die HTTP-Hülle nicht allein fehlschlagen. |

Die Bundle-Konvertierung erhält Int/Long/Double/String/Boolean-Werte und verschachtelte Bundles. Arrays werden zu Zeichenfolgenarrays. Andere Werttypen werden zu ihrer `toString()`-Zeichenfolge (einschließlich eines Bundle-null-Werts, der zur Zeichenfolge `"null"` wird). Prüfe Methodenfehlerfelder in `result` auch bei äußerem Code 200.

Der aktuelle LifeUp-Methodenhandler ergänzt abgeschlossene Aufrufe um `api_result` (boolean). Ein abgefangener Methodenfehler liefert `api_result: false`, `error_code` (string) und `error_message` (string). Fehlercodes sind unter anderem `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` und `internal_error`; einzelne Methoden können weitere liefern. Bei Backup-Wiederherstellung kann der Provider `error_code: "503"` und `error_message` ohne `api_result` liefern. Fehlende API-Handler können vor dieser Fehlerkonvertierung werfen und stattdessen einen äußeren Brückenfehler erzeugen.

## Dateien lesen und hochladen :id=files-download

### GET /files/{url} :id=files-get

Kodiere die vollständige lesbare URI als ein Pfadsegment. Die Bytes werden über Androids Content Resolver gelesen, typischerweise für Symbole, Gefühlsanhänge, Backup-Exporte oder hochgeladene Dateien. Ergebnis ist ein Bytestrom, keine JSON-Erfolgshülle. Dateiname oder MIME-Typ werden nicht festgelegt. Leere/unlesbare Resolver-Streams werden nicht in ein strukturiertes Nicht-gefunden-Ergebnis umgewandelt; geworfene Fehler behandelt der globale HTTP-500-Handler. Ein leerer erfasster Parameter ergibt eine Fehlerhülle (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Sende `multipart/form-data`. Jeder Dateiteil wird unabhängig vom Feldnamen akzeptiert; andere Formularteile werden ignoriert. Der Originaldateiname wird für eine Cache-Datei verwendet; fehlt er, wählt Cloud `uploaded_image_<time>.jpg`. Liefert ein Array lesbarer Content-URI-Zeichenfolgen. Der Upload stellt eine Datei-URI für spätere API-Aufrufe bereit und hängt die Datei nicht automatisch an Gegenstände oder Aufgaben an. Ohne Dateien folgt eine Fehlerhülle mit `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Backup exportieren und importieren :id=files-backup

### GET /data/export :id=files-export

Löst die Backup-Erstellung über den Provider aus. Optionales `withMedia` hat den Standard `true`; bei Angabe bedeutet `true` unabhängig von Groß-/Kleinschreibung wahr, jeder andere Wert falsch. Liefert das konvertierte Provider-Bundle, aktuell mit `backup_file_uri`; lade diese URI über `/files/{url}` herunter. Trotz GET erzeugt der Endpunkt einen Export. Provider-Status-/Fehlerfelder können enthalten sein und müssen geprüft werden. Leeres `backup_file_uri` bedeutet, dass keine nutzbare Exportdatei entstand. Ein null-Ergebnis wird zum Fehler.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Sende `multipart/form-data` mit einer Backup-Datei. Bei mehreren Dateiteilen gilt der letzte; der Feldname wird nicht geprüft. Standarddateiname ist `backup.lfbak`. Das optionale Formularfeld `description` wird gelesen, hat aber keine Wirkung. Cloud speichert die Datei im Cache und startet LifeUps Backup-Activity; die Antwort bestätigt Upload und Activity-Start, **keine abgeschlossene Wiederherstellung**. Ohne Datei folgt `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Ereignisse :id=get-events

### GET /events :id=get-events-poll

Liefert `EventsPage`. `after` ist ein exklusiver Ereignis-ID-Cursor (64-Bit-Ganzzahl, Standard 0). `limit` ist eine Ganzzahl mit Standard 50, begrenzt auf 1–200. Nichtganzzahlige Werte verwenden Standards. Ereignisse mit `id > after` werden im aufbewahrten Puffer vom ältesten zuerst geliefert. Höchstens 200 Ereignisse bleiben im Speicher; ältere werden verworfen, Prozessneustarts setzen IDs zurück. `latestId` ist die neueste globale ID, nicht zwingend das letzte Ereignis einer begrenzten Seite. Fahre mit dem letzten tatsächlich verarbeiteten Ereignis fort, um Rückstände nicht zu überspringen. Keine dauerhafte Historie oder Empfangsbestätigung.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `latestId` | integer | Aktuell neueste Ereignis-ID. |
| `eventWs` | boolean | WebSocket-Einstellung von Cloud. |
| `events` | CloudEvent[] | Aufbewahrte Ereignisse nach dem Cursor. |
| `broadcasts` | boolean oder null | Ob LifeUp-Broadcasts aktiviert sind; null bedeutet unbekannt oder nicht unterstützt. Der Abfragestatus wird fünf Sekunden zwischengespeichert. |

### CloudEvent :id=model-cloud-event

| Feld | JSON-Typ | Bedeutung |
| --- | --- | --- |
| `id` | integer | Ereignisfolgen-ID im Arbeitsspeicher. |
| `time` | integer | Cloud-Empfangszeit als Unix-Millisekunden. |
| `action` | string | Android-Broadcast-Aktion. |
| `extras` | Objekt mit Zeichenfolgenwerten | Broadcast-Extras mit `toString()` konvertiert; null wird zur leeren Zeichenfolge. Schlüssel hängen von der Aktion ab. |

### WebSocket /events :id=get-events-websocket

Wenn `eventWs` true ist, verbinde dich mit `ws://HOST:PORT/events?after=ID` und sende das konfigurierte Token. Der Server spielt aufbewahrte Ereignisse nach `after` erneut ab und sendet dann Live-Ereignisse als einzelne JSON-`CloudEvent`-Textframes, **ohne** HTTP-Antworthülle. Die Wiedergabe ist durch den 200-Ereignis-Speicherpuffer begrenzt; es gibt keinen WebSocket-Parameter `limit`. Alle 30 Sekunden sendet der Server Ping-Frames. Verbinde dich mit der zuletzt tatsächlich verarbeiteten Ereignis-ID neu. Bei Deaktivierung ist die WebSocket-Route nicht registriert; HTTP-Abfragen bleiben verfügbar.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Unterstützte Aktionsabonnements sind `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, und `app.lifeup.timing.abandon`. Die Ereigniserfassung erfordert aktivierte LifeUp-Broadcasts. Die Abfrage `/events` prüft diese Einstellung, aktiviert sie aber nicht automatisch.

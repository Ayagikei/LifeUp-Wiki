<h1 align="center" padding="100">Offene Schnittstelle</h1>

<p align="center">Unendliche Möglichkeiten erschaffen!</p>

> [!NOTE]
> Wir rollen **LifeUp v1.106.0** und **LifeUp Cloud v3.0.0** schrittweise aus. Da sich die Prüfzeiten je Plattform unterscheiden, kann diese Dokumentation aktualisiert werden, bevor die Apps breit verfügbar sind; das tatsächliche Veröffentlichungsdatum kann später liegen als hier angegeben.

?> Ab Version v1.90 hat `LifeUp` verschiedene Funktionsschnittstellen geöffnet; Integrationen mit externen Anwendungen sind willkommen. <br/>Außerdem gibt es den „URL“-Effekt für Shop-Gegenstände: Nutzer können Gegenstände direkt verwenden, um externe Apps oder Schnittstellen von `LifeUp` aufzurufen. <br/>Diese Funktionen eröffnen deinem `LifeUp` unbegrenzte Möglichkeiten — erfordern aber etwas Lernaufwand und praktisches Ausprobieren.

**Zuletzt aktualisiert: 2026/08/28**

Die API-Parameter und Definitionen in diesem Dokument basieren auf Version **v1.106.0**.

Stelle sicher, dass deine App auf **v1.106.0** aktualisiert ist, bevor du die neueste API nutzt.

Das Update wird schrittweise über Google Play ausgerollt. Wenn du es noch nicht erhalten hast, warte bitte — es kommt bald.

## Szenariobeispiel

| Aufrufer | Szenario | Hinweise |
| ------ | -------- | ----- |
|**LifeUp → andere Apps**<br/>Umgesetzt über den „URL“-Effekt des Shop-Gegenstands| **Nach Verwendung des Shop-Gegenstands:**<br/>1. Mit dem Browser eine Webseite öffnen<br/>2. Zu WeChat wechseln und scannen oder ein Mini-Programm angeben<br/>3. Buchführungseinträge automatisch hinzufügen ([z. B. unterstützt „Qianji“ eine Buchführungsschnittstelle](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Tasker-Konfiguration speichern (auch im Markt teilen) und nach der Verwendung automatisch in Tasker importieren<br/>5. Tasker auslösen, um den Hintergrund zu wechseln<br/>6. … (solange die externe App diesen Aufruf unterstützt) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) ist ein Automatisierungstool und unterstützt den Export von Konfigurationen als Uri |
|**LifeUp → LifeUp**<br/>Umgesetzt über den „URL“-Effekt des Shop-Gegenstands| **Nach Verwendung des Shop-Gegenstands:**<br/>1. Eine bestimmte Seite öffnen<br/>2. Den ATM-Zinssatz erhöhen<br/>3. Ein Pop-up-Fenster, in dem der Nutzer ein Produkt wählt und der Preis reduziert wird (Rabattgutschein)<br/>4. Das Abschließen einer Aufgabe auslösen<br/>5. Eine benutzerdefinierte Motivationsnachricht anzeigen<br/>6. Eine Aufgaben-Belohnungsvorlage erstellen: Nur den Namen eingeben, um automatisch eine Aufgabe anzulegen<br/>7. Ein Fenster mit Verzweigungsauswahl anzeigen — eine kleine kontextuelle Interaktion<br/>8. Weitere In-App-Aktionen … |  |
|**Externe Apps / Webseiten → LifeUp** | **Automatisierungstools konfigurieren:**<br/>1. Erkennen, wann das Telefon täglich zum ersten Mal eingeschaltet wird — frühes-Aufstehen-Aufgabe abschließen oder direkt die Strafe für „spätes Aufstehen“ auslösen<br/>2. Nach jeweils 25 Wörtern eine bestimmte NFC-Karte wischen und die Aufgabe automatisch abschließen<br/>3. Per GPS erkennen, dass ein neuer Ort erreicht wurde, und den Erfolg „neuer Ort“ freischalten<br/>4. Bei täglicher Verbindung mit dem Arbeits-Wi-Fi den Fortschritt der Freischaltbedingung erhöhen; nach 20 Tagen den Erfolg „Worker“ freischalten<br/>5. Beim ersten Verbinden mit dem Heim-Wi-Fi täglich „Zuhause angekommen“-Münzen als Belohnung erhalten<br/>6. Benachrichtigungen anderer Pomodoro- oder Fokus-Apps erfassen und Zeiterfassungen automatisch in `LifeUp` protokollieren<br/>7. Abschluss- oder Endbenachrichtigungen von Sport- und Lern-Apps erfassen und automatisch Erfahrungspunkte für „strength“ und „knowledge“ vergeben<br/>8. In einem selbst festgelegten Zeitraum bei jedem Öffnen des Telefons eine Strafe auslösen<br/>9. …<br/>**Externe App-Anbindung / eigene App:**<br/>1. Wenn du mit dem Pomodoro von `LifeUp` unzufrieden bist: eigene Zeiterfassungssoftware entwickeln (Web- oder Android-App) und über die Schnittstelle mit „LifeUp“ verknüpfen, um Zeiterfassungen oder Belohnungen hinzuzufügen<br/>2. Einige Denk-Minispiele anpassen (Wordle-Beispiel unten). Bei erfolgreichem Abschluss `LifeUp` Belohnungen senden lassen<br/>3. … |  |

<br/>Kurz gesagt: Alle obigen Szenarien sind „Ereignisse“, die „Aktionen“ auslösen.

Dieses `LifeUp`-Update bietet den Ereignisauslöser „Gegenstand verwenden“ und verschiedene „Aktionen“ (Belohnungen, Aufgaben abschließen usw.).

Wenn du Ereignisse wie

- Klick auf einen Web-Button
- NFC-Karte wischen
- Täglich beim ersten Entsperren des Bildschirms nach dem Aufwachen

brauchst, sind externe Apps nötig — eigene Entwicklung oder Automatisierungstools wie `Tasker` und `MacroDroid`.

**Das LifeUp-1.90.2-Update fügt eine Reihe von „Ereignissen“ hinzu; diese können von Automatisierungstools oder externen Apps empfangen werden.**

Damit lassen sich u. a. folgende Dinge umsetzen:

Nach Verwendung eines Gegenstands Automatisierungstools wie Tasker auslösen, um den Launcher-Hintergrund zu wechseln.

Nach Abschluss einer Aufgabe ein Automatisierungstool wie Tasker auslösen, um eine App zu öffnen.

**Ab Version 1.90.2 kann ein „LifeUp-Ereignis“ eine „Tasker-Aktion“ auslösen.**

Tasker hat sehr weitreichende Berechtigungen: Hintergrund wechseln, Apps deinstallieren, Lautstärke erhöhen, bestimmte Apps öffnen und mehr. Sogar UI-Interaktionslogik ist ohne Programmierkenntnisse möglich.

---

## Empfehlungen

**Wenn du mit Programmieren unvertraut bist,** kannst du unter [World] → [Market] → Tags [Link]/[API]/[Automate] spezielle Shop-Gegenstände suchen und importieren. Du kannst auch Parameter anpassen, um deine Bedürfnisse zu erfüllen.

**Wenn du Computergrundlagen kennst,** lies die folgende Schnittstellen-Dokumentation und passe die gewünschten Effekte selbst an. Kombiniere sie mit Automatisierungssoftware wie [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Auch ohne Tasker-Konfiguration reicht die erfolgreiche Tasker-Installation, um geteilte Automatisierungskonfigurationen aus dem Markt oder anderen Communities zu importieren.

**Wenn du Programmiergrundlagen hast,** entwickle Webseiten oder Android-Apps zur Integration mit LifeUp. Diese Wiki-Seite und angepasste Wordle-Versionen sind Beispiele. Automatisierungskonfigurationen erstellen und teilen ist ebenfalls willkommen.

---

## Andere Anwendungen aufrufen

Um in *LifeUp* eine externe App aufzurufen, füge einem Shop-Gegenstand einen „Link“-Effekt hinzu, **gib einen Webseiten- oder app-spezifischen Link ein** und verwende den Gegenstand, um den Aufruf auszulösen.

**Beispiele (öffentliche Gegenstände mit Schnittstellenaufruf findest du auch unter „World“ → „Market“ → „Link“):**

- Browser öffnet Google: https://www.google.com
- Facebook: [fb://](fb://)
- App per Paketname/App-ID öffnen: [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- …

Theoretisch reicht es, wenn die externe App eine URL bereitstellt — dann kann der Shop-Gegenstand zum Sprung dienen.

**Suche bei Google nach `URL Schemes`, um den benötigten App-Link zu finden.**

**Diese Links haben nichts mit `LifeUp` zu tun; `LifeUp` stellt nur die Sprung-URL-Funktion bereit.**

**Wir führen daher keine URL-Liste und pflegen keine. Öffentliche Shop-Gegenstände mit Link-Effekt findest du unter [World] → [Market] → [Link].**

Den Paketnamen (ID) einer App findest du:

- in der Google-Play-URL: https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- mit einer App-Manager-App
- über die Aktion App Info in Tasker
- über die Aktion Launch App in MacroDroid

---

## LifeUp-APIs aufrufen

Wenn du:

- die `LifeUp`-Schnittstelle in `LifeUp` aufrufen willst: Füge einem Shop-Gegenstand einen „link“-Effekt hinzu, gib gemäß der API-Dokumentation **eine bestimmte URL** ein und verwende den Gegenstand zum Aufruf.
- über eine Webseite aufrufst: Springe per Hyperlink zu den LifeUp-APIs.
- über eine selbst entwickelte App aufrufst: Nutze Intent, um zum entsprechenden Schnittstellenlink zu springen.
- über ein Automatisierungstool (z. B. Tasker) aufrufst: Trage den API-Link in Taskers Browser-URL ein.

**Beispiele:**

Beim Klick auf den Link unten zeigt „LifeUp“ die Meldung „You have learned to call APIs!“.

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Beim Klick auf den Link unten erhältst du in „LifeUp“ eine Münze; der Grund lautet „Learn API Calls“.

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Kopierst du den Link in den „link“-Effekt eines Gegenstands, löst die Verwendung denselben Effekt aus.

**Beispiel für externe App-Anbindung:**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle ist ein kleines Wortratespiel: Wörter mit fünf Buchstaben erraten. Orange bedeutet, der Buchstabe ist in der Antwort enthalten. Grün bedeutet enthalten und an der richtigen Position.

**Diese Wordle-Version unterstützt die Anbindung an „LifeUp“:**

1. Bei richtigem Wort erhältst du 10 Münzen — mit anpassbarem Erhaltungsgrund.
2. Wenn du das Wort am Ende nicht errätst, gibt es einen Trostpreis von 1 Münze.

![](_media/api/wordle.png ':size=30%')

<br/>

**Beispiel für Tasker-Anbindung:**

> Tasker wird über `Action Category` → `Program` → `Shortcut` aufgerufen. In die Shortcut-Spalte einen Link eintragen, der mit lifeup:// beginnt.

Das erste Entsperren des Bildschirms nach 5 Uhr morgens kann täglich das Abschließen einer von dir festgelegten Aufgabe auslösen (z. B. Aufstehen).

**Hinweis: Zum Import dieser Konfiguration ist eine Task-Group-ID nötig. Aktiviere [Developer Mode] unter [Settings] → [Labs] und prüfe die gid auf der Aufgabendetailseite.**

Ist Tasker installiert, [klicke hier, um die konfigurierten Aufgaben zu importieren.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**LifeUp-APIs mit MacroDroid aufrufen:**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) ist ebenfalls ein Automatisierungstool — kostenlos und mit einfacherer Oberfläche.

1. Makros hinzufügen und benötigte Bedingungen festlegen (oder später)
2. `Actions` hinzufügen
3. `Applications` wählen
4. `Open Website` wählen
5. Im Feld `Enter URL` eine URL eingeben, die mit `lifeup://` beginnt
6. **Alle** Optionen darunter deaktivieren, z. B. `URL encode parameters` …
7. Speichern, Aktion anklicken und `Test action` zur Prüfung wählen

<br/>

**Mit dieser Funktion kannst du die Möglichkeiten von LifeUp nahezu unbegrenzt erweitern — mit oder ohne Programmierkenntnisse!**

Die konkreten Aufrufregeln findest du unten.

---

## Schnittstellen-Dokumentation
### Grundlagen – Beispiele

| Typ             | Beschreibung   |
| ---------------- | ------------- |
| Beispiel          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Schnittstellenformat | fester Präfix/Methodenname?parameter1=value1&parameter2=value2 |
| Fester Präfix     | lifeup://api/ |
| Methodenname      | toast         |
| Parameter       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Grundlagen – Escaping (URL Encode)

Enthält ein Parameterwert Sonderzeichen wie +, Leerzeichen, =, %, &, # usw., muss er escaped werden:

| Sonderzeichen | Bedeutung                                         | Ersetzen durch |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | Das +-Zeichen in der URL steht für ein Leerzeichen        | +          |
| Leerzeichen             | Leerzeichen in URLs können + sein oder encodiert werden              | %20        |
| /                  | trennt Verzeichnis und Unterverzeichnis            | %2F        |
| ?                  | trennt eigentliche URL und Parameter         | %3F        |
| %                  | Kennzeichnet Sonderzeichen                      | %          |
| #                  | bedeutet Lesezeichen                                  | %23        |
| &                  | Trenner zwischen in der URL angegebenen Parametern   | %26        |
| =                  | gibt den Parameterwert in der URL an | %3D        |

Am Beispiel der Pop-up-Nachrichten-Schnittstelle oben: Soll der angezeigte Text `You have learned to call APIs!` lauten,
ersetze Leerzeichen durch + — das Ergebnis:

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Ein einfaches Kodierungstool in Javascript:**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Grundlagen – LifeUp-Daten-ID

Fast alle Datenspeicher in LifeUp haben eine eindeutige id.

Einige der folgenden Schnittstellen unterstützen das Ändern **bestimmter** Shop-Gegenstände und das Abschließen **bestimmter** Aufgaben.

Damit `LifeUp` die passenden Daten findet, musst du eine id angeben.

**Aktiviere „Settings“ → „Labs“ → „Developer Mode“, um auf jeder Detailseite in der App die Original-id der Daten zu sehen.**

Beispiel: Wird ein Attribut als „strength (1)“ angezeigt, ist die Attribut-id 1.

#### Aufgaben-id

Auf der Ereignisdetailseite einsehbar.

id: Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert.

gid: Die id der Aufgabengruppe. Bei derselben wiederholenden Aufgabe bleibt die gid unverändert.

#### Listen-id

Nach Aktivierung von „Developer Mode“ im Pop-up „Select List“ einsehbar.

#### Attribut-id

Nach Aktivierung von „Developer Mode“ auf der Seite „Custom Attributes“ einsehbar.

#### Shop-Gegenstands-id

Nach Aktivierung von „Developer Mode“ den Shop-Gegenstand antippen, um die Details zu sehen.

#### Erfolgsbedingungs-id

Nach Anpassen der Freischaltbedingung „requires an external API call to unlock“ für einen Erfolg ist die Bedingungs-id auf der Detailseite sichtbar.

<br/>

### Grundlagen – Namensabgleich

Unterstützt eine API die Suche nach Aufgaben, Shop-Gegenständen oder Unteraufgaben per Name, versucht LifeUp zuerst einen exakten Namensabgleich ohne Beachtung der Groß-/Kleinschreibung. Gibt es keine exakte Übereinstimmung, folgt eine unscharfe Teilstring-Suche.

Existieren z. B. „Coin“ und „Coin Box“, trifft `name=Coin` zuerst „Coin“ — nicht das unscharfe Ergebnis, das früher in der Liste steht.

Bei doppelten oder ähnlichen Namen, die mehrdeutig sein können, lieber die entsprechende id übergeben.

<br/>

### Grundlagen – Rückgabewerte

Einige Schnittstellen können Rückgabewerte liefern.

**Bei Entwicklung einer Android-App** kannst du die Methode `onActivityResult` nutzen, um den Rückgabewert zu empfangen.

**Bei Automatisierungs-Apps wie Tasker:**

Solche Apps können in der Regel keine Rückgabewerte vom Typ Activity empfangen. Füge einen `broadcast`-Parameter hinzu und empfange den Rückgabewert über das Ereignis `received intent`.

Details siehe die broadcast-Parameter unten.

<br/>

### Grundlagen – JSON-Datenstruktur

?> Erfordert v1.98.0+

Dieser Abschnitt stellt häufig genutzte JSON-Datenstrukturen in der API vor.

#### 1. Gegenstands-Belohnungsstruktur

Ein JSON-Array für Gegenstands-Belohnungen; jedes Element enthält eine ID und eine Menge.

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

#### 2. Erfolgs-Freischaltbedingungsstruktur

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Kauflimit-Struktur

`purchase_limit` ist ein JSON-Array. Jedes Objekt steht für eine Einschränkungsregel.

| Feld | Bedeutung | Typ | Erforderlich | Hinweise |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Art der Einschränkung | number | Ja | Siehe Typ-Tabelle unten |
| limitNumber | Primärer numerischer Wert | number | Nein* | Für mengen-/bereichsbasierte Regeln |
| maxNumber | Obergrenze eines Bereichs | number | Nein | Für Attributstufen-Bereich / Besitzmenge eines Gegenstands |
| limitId | Zugehörige Ziel-ID | number | Nein* | Erforderlich für attribut-, gegenstands-, aufgaben-, aufgabenzyklus- oder erfolgsbasierte Regeln |
| extendInfo | Zusatzdaten | string | Nein | Für zeitbasierte Regeln; der Wert selbst ist ein JSON-String |

**Typdefinitionen**

| limitType | Bedeutung | Erforderliche Felder / Hinweise |
| --------- | ------- | ----------------------- |
| 0 | Tägliches Mengenlimit | `limitNumber`: max. Anzahl pro Tag |
| 1 | Wöchentliches Mengenlimit | `limitNumber`: max. Anzahl pro Woche |
| 2 | Monatliches Mengenlimit | `limitNumber`: max. Anzahl pro Monat |
| 3 | Jährliches Mengenlimit | `limitNumber`: max. Anzahl pro Jahr |
| 10 | Attributstufen-Regel | `limitId`: Attribut-ID<br/>`limitNumber`: Mindeststufe<br/>`maxNumber`: optionale Maximalstufe |
| 20 | Täglicher Zeitbereich | `extendInfo`: `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Wochentagsauswahl | `extendInfo`: `{"weekdays":[1,2,3,4,5]}`<br/>Montag = 1, Sonntag = 7 |
| 22 | Absoluter Zeitbereich | `extendInfo`: `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Monatsauswahl | `extendInfo`: `{"months":[1,6,12]}` |
| 24 | Tag-im-Monat-Auswahl | `extendInfo`: `{"daysOfMonth":[1,15,31]}` |
| 30 | Besitzmengen-Regel für Gegenstände | `limitId`: Ziel-Gegenstands-ID<br/>`limitNumber`: Mindestbesitz<br/>`maxNumber`: optionaler Maximalbesitz |
| 31 | Aufgabe-abgeschlossen-Regel | `limitId`: Aufgaben-ID |
| 32 | Erfolg-freigeschaltet-Regel | `limitId`: Erfolgs-ID |
| 33 | Aufgabenzyklus-abgeschlossen-Regel | `limitId`: Wiederholungs-Aufgabengruppen-ID (`groupId`)<br/>Prüfung gegen den zuletzt gestarteten Zyklus in dieser Gruppe |

**Hinweise**

- Bei `limitType=33` ist `limitId` keine Aufgaben-ID. Es muss die Wiederholungs-`groupId` sein.

- Legacy-kompatible Payloads können `maxNumber` und `extendInfo` weglassen.
- `extendInfo` ist ein String-Feld; beim API-Aufruf über eine URL braucht der JSON-String darin meist eine weitere Escaping-/Encoding-Ebene.

**Beispiel:**

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

#### 4. Gegenstandseffekt-Struktur

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

#### Effekttyp-Beschreibung

?> Typen 10–16 ab v1.102.0+ unterstützt.

| Typcode | Bedeutung | Parameterbeschreibung |
| ------- | ---- | ------- |
| 0 | Kein Spezialeffekt | Keine Parameter |
| 1 | Nicht verwendbar | Keine Parameter |
| 2 | Münzen hinzufügen | min: Mindestmünzen<br/>max: Maximalmünzen (optional, Standard min)<br/>using_limit: Systemlimits anwenden (optional) |
| 3 | Münzen entfernen | min: Mindestmünzen<br/>max: Maximalmünzen (optional, Standard min)<br/>using_limit: Systemlimits anwenden (optional) |
| 4 | Erfahrung hinzufügen | ids: Fähigkeiten-ID-Array<br/>value: Erfahrungswert (Legacy, gleich min)<br/>min: Mindesterfahrung (optional, wenn value fehlt)<br/>max: Maximalerfahrung (optional, Standard min/value)<br/>using_limit: Limit nutzen (optional, Standard false) |
| 5 | Erfahrung entfernen | ids: Fähigkeiten-ID-Array<br/>value: Erfahrungswert (Legacy, gleich min)<br/>min: Mindesterfahrung (optional, wenn value fehlt)<br/>max: Maximalerfahrung (optional, Standard min/value)<br/>using_limit: Limit nutzen (optional, Standard false) |
| 6 | Einfache Synthese | require_number: Benötigte Menge<br/>item_id: Gegenstands-ID |
| 7 | Lootbox öffnen | items: Gegenstands-Array, jedes Element enthält:<br/>- item_id: Gegenstands-ID<br/>- amount: Menge<br/>- probability: Wahrscheinlichkeit<br/>- is_fixed_reward: Ob feste Belohnung |
| 8 | Countdown | seconds: Countdown-Sekunden |
| 9 | Weblink | url: Linkadresse<br/>use_web_view: Integrierten Browser nutzen (optional, Standard false) |
| 10 | Gefühl erfassen | Keine Parameter |
| 11 | Münzen ändern (erhöhen oder verringern) | min: Mindestmünzen (kann negativ sein)<br/>max: Maximalmünzen (optional, Standard min)<br/>using_limit: Systemlimits anwenden (optional) |
| 12 | Erfahrung ändern (erhöhen oder verringern) | ids: Fähigkeiten-ID-Array<br/>value: Erfahrungswert (Legacy, gleich min)<br/>min: Mindesterfahrung (kann negativ sein)<br/>max: Maximalerfahrung (optional, Standard min/value)<br/>using_limit: Limit nutzen (optional, Standard false) |
| 13 | Gegenstandsbestand hinzufügen | item_id: Ziel-Gegenstands-ID<br/>min: Mindestbestandsänderung<br/>max: Maximalbestandsänderung (optional, Standard min)<br/>using_limit: Bestandslimits anwenden (optional) |
| 14 | Gegenstandsbestand entfernen | item_id: Ziel-Gegenstands-ID<br/>min: Mindestbestandsänderung<br/>max: Maximalbestandsänderung (optional, Standard min)<br/>using_limit: Bestandslimits anwenden (optional) |
| 15 | Gegenstandsbestand ändern (erhöhen oder verringern) | item_id: Ziel-Gegenstands-ID<br/>min: Mindestbestandsänderung (kann negativ sein)<br/>max: Maximalbestandsänderung (optional, Standard min)<br/>using_limit: Bestandslimits anwenden (optional) |
| 16 | Ton abspielen | file_name: Lokaler Sounddateiname (bevorzugt)<br/>uri: Sound-URI zum Import (Alternative zu file_name)<br/>display_name: Anzeigename (optional) |

**Effektbeispiele:**

Zufällige Münzen erhöhen:

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Erfahrungspunkte erhöhen:

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

Münzen ändern (zufällig +/-):

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Gegenstandsbestand ändern (zufällig +/-):

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

Ton abspielen:

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Lootbox-Effekt:

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

### Pop-up-Nachricht

**Methodenname:** toast

**Beschreibung:** Es erscheinen Meldungen in verschiedenen Stilen.

**Beispiel:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Erklärung:** Die Meldung „Live well, eat well!“ erscheint im Bonus-Stil und wird länger angezeigt.

> Klicke auf den Beispiellink, um den Effekt zu testen.

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Anzuzeigender Text | Beliebiger Text | You learned to call! | Ja | |
| type      | Textstil | Zahl von 0 bis 6 | 1 | Nein | 0 - Normaler Stil<br/>1 - Bonus-Stil<br/>2 - Tomaten-Stil<br/>3 - Erfolgs-Stil<br/>4 - Hinweis-Stil<br/>5 - Warn-Stil<br/>6 - Fehler-Stil |
| isLong    | Anzeigedauer | true oder false | true | Nein | true - lang<br/>false - kurz |

<br/>

### Belohnung

**Methodenname:** reward

**Beschreibung:** Belohnung direkt vergeben. Der Grund für die Belohnung kann angepasst werden.

**Beispiel:**

- 1 Münze erhalten; Grund: „Learn API Calls“. Der Grund wird auf der Münz-Detailseite angezeigt:

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- 300 Erfahrungspunkte für „Learning, Creativity“ erhalten; Grund: „Learn API Calls“. Der Grund wird auf der Erfahrungspunkte-Detailseite angezeigt:

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- 1 Gegenstand per unscharfer Suche zu „treasure“ erhalten; Grund: „Learn API Calls“. Der Grund wird auf der Inventar-Verlaufsseite angezeigt:

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | Belohnungstyp | Derzeit nur folgende Werte:<br/>coin<br/>exp<br/>item | coin | Ja | coin - Münzen<br/>exp - Erfahrungspunkte<br/>item - Shop-Gegenstände |
| content   | Belohnungsgrund | Beliebiger Text | Learning API Calls | Ja | |
| skills    | Fähigkeiten (Attribute) | Array von Zahlen größer als 0 | 1 | Nein | Nur wenn type exp ist<br/>Arrays unterstützt (z. B. &skills=1&skills=2&skills=3)<br/>Zum Ermitteln siehe oben „Grundlagen – LifeUp-Daten-ID“ |
| number    | Anzahl der Belohnungen | Zahl größer als 0 | 1 | Ja | Bei Münzen maximal 999999<br/>Bei Erfahrungspunkten maximal 99999<br/>Bei Gegenständen maximal 999 |
| item_id   | Gegenstands-ID | Zahl größer als 0 | 1 | Nein* | Nur wenn type item ist |
| item_name | Gegenstandsname | Beliebiger Text | treasure | Nein* | Nur wenn type item ist; unscharfer Abgleich mit Gegenstandsnamen |
| silent    | UI-Hinweise deaktivieren | true oder false | false | Nein | Standard ist false |

<br/>

### Strafe

**Methodenname:** penalty

**Beschreibung:** Strafe direkt anwenden. Der Grund für die Strafe kann angepasst werden.

**Beispiel:** *Im Wesentlichen wie die Belohnungs-Schnittstelle

- 1 Münze abziehen; Grund: „sleep in“. Der Grund wird auf der Münz-Detailseite angezeigt:

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- 300 Erfahrungspunkte für „Strength“ abziehen; Grund: „sleep in“. Der Grund wird auf der Erfahrungspunkte-Detailseite angezeigt:

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- 1 Gegenstand per unscharfer Suche zu „treasure“ abziehen; Grund: „sleep in“. Der Grund wird auf der Inventar-Verlaufsseite angezeigt:

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | Strafentyp | Derzeit nur:<br/>coin<br/>exp<br/>item | coin | Ja | coin - Münzen<br/>exp - Erfahrungspunkte<br/>item - Shop-Gegenstände |
| content   | Strafengrund | Beliebiger Text | Sleep In | Ja | |
| skills    | Fähigkeiten (Attribute) | Array von Zahlen größer als 0 | 1 | Nein | Nur wenn type exp ist<br/>Arrays unterstützt (z. B. &skills=1&skills=2&skills=3)<br/>Zum Ermitteln siehe oben „Grundlagen – LifeUp-Daten-ID“ |
| number    | Anzahl der Strafen | Zahl größer als 0 | 1 | Ja | Bei Münzen maximal 999999<br/>Bei Erfahrungspunkten maximal 99999<br/>Bei Gegenständen maximal 999 |
| item_id   | Gegenstands-ID | Zahl größer als 0 | 1 | Nein* | Nur wenn type item ist |
| item_name | Gegenstandsname | Beliebiger Text | treasure | Nein* | Nur wenn type item ist; unscharfer Abgleich mit Gegenstandsnamen |
| silent    | UI-Hinweise deaktivieren | true oder false | false | Nein | Standard ist false |

<br/>

### Münzen bearbeiten

**Methodenname:** edit_coin

**Beschreibung:** Münzstand des Nutzers direkt bearbeiten. Der aktuelle Münzstand wird auf den angegebenen Wert gesetzt. Der Änderungsgrund kann angepasst werden und erscheint im Münz-Verlauf.

**Beispiel:**

- Münzen auf 1000 setzen mit Grund „API adjustment“: <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Münzen still auf 500 setzen: <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Ziel-Münzstand | number >= 0 | 1000 | Ja | Endstand nach der Operation, maximal 999999 |
| content | Änderungsgrund | Beliebiger Text | API adjustment | Nein | Ohne Angabe Standard-Systemgrund |
| reason | Änderungsgrund (Alias) | Beliebiger Text | API adjustment | Nein | Alternative zu content |
| silent | UI-Benachrichtigung deaktivieren | true oder false | false | Nein | Standard false; true unterdrückt die Pop-up-Meldung |

<br/>

### Aufgaben

#### Aufgabe hinzufügen

?> Einige Felder wie `pin` erfordern v1.98.0+

**Methodenname:** add_task

**Beschreibung:** Aufgabe direkt erstellen

**Beispiel:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Parameter         | Bedeutung | Werte | Beispiel | Erforderlich | Hinweise |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Aufgabeninhalt | Beliebiger Text | Write diary | Ja | |
| notes            | Notizen | Beliebiger Text | Notes | Nein | Standard leer |
| coin             | Münz-Belohnung | number >= 0 | 10 | Nein | Standard 0, Systemlimits beachten |
| coin_var         | Münz-Belohnungsvarianz | number >= 0 | 1 | Nein | Standard 0; bei >0 zufällige Belohnung zwischen [coin, coin+coin_var] |
| exp              | Erfahrungs-Belohnung | number >= 0 | 100 | Nein | Standard 0, Systemlimits beachten |
| skills           | Fähigkeiten-IDs | Array von Zahlen > 0 | 1 | Nein | Arrays unterstützt (z. B. &skills=1&skills=2) |
| category         | Listen-ID | number >= 0 | 0 | Nein | Standard 0 (Standardliste); Smart Lists nicht erlaubt |
| frequency        | Wiederholungsfrequenz | Ganzzahl | 0 | Nein | Standard 0 (einmalig)<br/>0 - Einmalig<br/>1 - Täglich<br/>N (N>1) - Alle N Tage<br/>-1 - Unbegrenzt<br/>-3 - Ebbinghaus (v1.99.1+)<br/>-4 - Monatlich<br/>-5 - Jährlich |
| weekdays         | Wochentage | `1,3,5` oder `none` | 1,3,5 | Nein | v1.106.0+; 1=Montag … 7=Sonntag, Tage **zur Wiederholung**. Wenn gesetzt, frequency weglassen oder 1. `none` beim Hinzufügen abgelehnt; beim Bearbeiten setzt `none` zurück auf täglich. Alle 7 Tage gelten als täglich |
| importance       | Wichtigkeitsstufe | [1, 4] | 1 | Nein | Standard 1 |
| difficulty       | Schwierigkeitsstufe | [1, 4] | 1 | Nein | Standard 1 |
| deadline         | Fälligkeitszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | |
| no_deadline      | Keine Frist | true/false | true | Nein | v1.104.0+; nur für wiederholende Aufgaben. `&no_deadline=true` löscht die konkrete Fälligkeitszeit |
| color            | Tag-Farbe | Farbstring | #66CCFF | Nein | # als %23 escapen |
| background_url   | Hintergrundbild-URL | Web-URL | http://example.com/bg.jpg | Nein | Erreichbares Web-Bild |
| background_alpha | Hintergrund-Deckkraft | Float zwischen [0, 1] | 0.5 | Nein | Standard 1.0 |
| enable_outline   | Textumriss aktivieren | true oder false | false | Nein | Nur mit background_url; Umriss für bessere Lesbarkeit |
| use_light_remark_text_color | Helle Notiz-Schrift | true oder false | false | Nein | Nur mit background_url; helle Farbe für Notiztext |
| start_time       | Startzeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Aufgaben-Startzeit |
| auto_use_item    | Belohnungsgegenstände auto verwenden | true oder false | false | Nein | Belohnungen beim Abschluss automatisch nutzen |
| remind_time      | Erinnerungszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Aufgaben-Erinnerung |
| pin              | Aufgabe anheften | true oder false | false | Nein | Aufgabe oben anheften |
| words            | Abschluss-Belohnungstext | Beliebiger Text | Great job! | Nein | Motivationstext beim Abschluss |
| frozen           | Einfrier-Status | true oder false | false | Nein | Standard false |
| freeze_until     | Einfrieren bis | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Nur wirksam wenn frozen true |
| coin_penalty_factor | Münz-Straffaktor | Float zwischen [0, 100) | 0.5 | Nein | |
| exp_penalty_factor | Erfahrungs-Straffaktor | Float zwischen [0, 100) | 0.5 | Nein | |
| write_feelings   | Gefühle aktivieren | true oder false | false | Nein | Standard false |
| item_id          | Gegenstands-ID | number > 0 | 1 | Nein* | item_id oder item_name erforderlich |
| item_name        | Gegenstandsname | Beliebiger Text | Treasure | Nein* | item_id oder item_name erforderlich |
| item_amount      | Gegenstandsmenge | [1, 99] | 1 | Nein | Standard 1 |
| items            | Gegenstands-Belohnungen | JSON-Text | Siehe [Gegenstands-Belohnungsstruktur](#1-gegenstands-belohnungsstruktur) | Nein | Mehrere Gegenstands-Belohnungen setzen |
| task_type        | Aufgabentyp | [0, 4] | 0 | Nein | v1.99.1+<br/>0 - Normale Aufgabe<br/>1 - Zähl-Aufgabe<br/>2 - Negative Aufgabe<br/>3 - API-Aufgabe<br/>4 - Zeit-Aufgabe (v1.102.0+) |
| target_times     | Zielanzahl | number > 0 | 1 | Nein | Nur wenn task_type 1 (Zähl-Aufgabe) |
| is_affect_shop_reward | Shop-Belohnung beeinflussen | true/false | false | Nein | Nur wenn task_type 1; ob Gegenstands-Belohnungsberechnung beeinflusst wird |
| enable_proportional_settlement | Proportionale Abrechnung | true/false | false | Nein | v1.104.0+; nur wenn task_type 1. Bei Aktivierung werden Belohnungen proportional zum Zählfortschritt vergeben; beim endgültigen Abschluss keine erneute Vergabe bereits abgerechneter Belohnungen |
| expected_focus_minutes | Erwartete Fokus-Minuten | number > 0 | 25 | Nein | Nur wenn task_type 4 (Zeit-Aufgabe); Standard 25 (v1.102.0+) |
| repeat_end_mode | Wiederholungs-Endmodus | 0 oder 1 | 0 | Nein | Nur für wiederholende Aufgaben (frequency nicht 0 / -1)<br/>0 - Nach Anzahl beenden<br/>1 - Nach Datum beenden (v1.102.0+) |
| repeat_target_times | Wiederholungs-Endanzahl | number > 0 | 3 | Nein | Bei repeat_end_mode=0 (oder wenn Feld gesetzt); nicht mit target_times verwechseln (v1.102.0+) |
| repeat_end_date | Wiederholungs-Enddatum | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Bei repeat_end_mode=1 (oder wenn Feld gesetzt) (v1.102.0+) |
| repeat_end_behavior | Verhalten bei Wiederholungs-Ende | 0 oder 1 | 0 | Nein | 0 - Aufgabe nach Endbedingung beenden<br/>1 - Aufgabe nach Endbedingung einfrieren (v1.102.0+) |

**Antwort:**

| Feld | Typ | Beschreibung | Beispiel | Hinweise |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | Aufgaben-ID | 1000 | |
| task_gid | Number  | Aufgabengruppen-ID | 1000 | |

<br/>

#### Aufgabe abschließen

**Methodenname:** complete

**Beschreibung:** Aufgabenabschluss auslösen. Es werden nur offene Aufgaben gesucht.

**Beispiel:**

- Aufgabe mit id 1 abschließen: [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Aufgabe mit Aufgabengruppen-ID 1 abschließen: [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Aufgaben per Name suchen und abschließen: <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Erklärung:**

Jede Aufgabe hat eine id.

Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung erneuert, die Aufgabengruppen-ID bleibt gleich.

Die id findest du unter „Developer Mode“ auf der Seite „Labs“ und dann auf der Aufgabendetailseite.

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert |
| gid       | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Aufgabengruppen-ID |
| name      | Name | Beliebiger Text | get up | Nein* | Unscharfe Suche; nur eine gefundene Aufgabe |
| ui        | Pop-up-UI anzeigen | true oder false | true | Nein | Standard false; nur Hintergrundmeldung |
| count | Zählwert | Number | 1 | Nein | Nur für Zähl-Aufgaben; mit `count_set_type` kombinieren |
| count_set_type | Zählwert setzen | Einer von:<br/>absolute<br/>relative | absolute | Nein | Standard relative<br/>absolute - Ziel direkt setzen<br/>relative - zum Ausgangswert addieren/subtrahieren |
| count_force_sum_up | Zähl-Belohnungen erzwingen | true oder false | true | Nein | |
| reward_factor | Belohnungsfaktor | Gleitkommazahl größer als 0 | 1.1 | Nein | Nicht für Zähl-Aufgaben<br/>Beeinflusst Erfahrungspunkte und Münzen (nicht Gegenstandsmengen) |

**Hinweis:**

1. Zum Abgleich muss eine von id, gid und name angegeben werden.
2. Zeit-Aufgaben können über diese API nicht manuell abgeschlossen werden (v1.102.0+).

<br/>

#### Aufgabe aufgeben

**Methodenname:** give_up

**Beschreibung:** Aufgabe aufgeben auslösen.

**Beispiel:**

- Aufgabe per Name suchen und aufgeben: [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Erklärung:**

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert |
| gid       | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Aufgabengruppen-ID |
| name      | Name | Beliebiger Text | get up | Nein* | Unscharfe Suche; nur eine passende Aufgabe |

**Hinweis:**

1. Zum Abgleich muss eine von id, gid und name angegeben werden.

<br/>

#### Aufgabe einfrieren

**Methodenname:** freeze

**Beschreibung:** Aufgabe einfrieren; nur für wiederholende Aufgaben.

**Beispiel:**

- Aufgabe per Name suchen und einfrieren: [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Erklärung:**

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert |
| gid       | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Aufgabengruppen-ID |
| name      | Name | Beliebiger Text | get up | Nein* | Unscharfe Suche; nur eine passende Aufgabe |
| time      | Einfrieren bis | Zeitstempel | 1661688800682 | Nein | - |

**Hinweis:**

1. Zum Abgleich muss eine von id, gid und name angegeben werden.

<br/>

#### Aufgabe auftauen

**Methodenname:** unfreeze

**Beschreibung:** Aufgabe auftauen auslösen.

**Beispiel:**

- Aufgabe per Name suchen und auftauen: [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Erklärung:**

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert |
| gid       | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Aufgabengruppen-ID |
| name      | Name | Beliebiger Text | get up | Nein* | Unscharfe Suche; nur eine passende Aufgabe |

**Hinweis:**

1. Zum Abgleich muss eine von id, gid und name angegeben werden.

<br/>

#### Aufgabe löschen

**Methodenname:** delete_task

**Beschreibung:** Aufgabe löschen.

**Beispiel:**

- Aufgabe per Name suchen und löschen: [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Erklärung:**

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Bei wiederholenden Aufgaben wird die id bei jeder Wiederholung aktualisiert |
| gid       | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Aufgabengruppen-ID |
| name      | Name | Beliebiger Text | get up | Nein* | Unscharfe Suche; nur eine passende Aufgabe |

**Hinweis:**

1. Zum Abgleich muss eine von id, gid und name angegeben werden.

<br/>

### Aufgabe bearbeiten

?> Erfordert v1.98.0+

**Methodenname:** edit_task

**Beschreibung:** Inhalt und Eigenschaften einer bestehenden Aufgabe bearbeiten

**Beispiel:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Parameter           | Bedeutung | Werte | Beispiel | Erforderlich | Hinweise |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | Aufgaben-ID | Zahl größer als 0 | 1 | Nein* | Eine von id, gid oder name erforderlich |
| gid                | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Nein* | Eine von id, gid oder name erforderlich |
| name               | Aufgabenname | Beliebiger Text | Write diary | Nein* | Eine von id, gid oder name erforderlich |
| todo               | Aufgabeninhalt | Beliebiger Text | Write weekly | Nein | |
| notes              | Notizen | Beliebiger Text | Note content | Nein | |
| coin               | Münz-Belohnung | number >= 0 | 10 | Nein | Münzen beim Abschluss; Systemlimits beachten |
| coin_var           | Münz-Varianz | Zahl größer als 0 | 1 | Nein | Zufällige Belohnung zwischen [coin, coin+coin_var] |
| exp                | Erfahrungs-Belohnung | number >= 0 | 20 | Nein | Erfahrungspunkte beim Abschluss; Systemlimits beachten |
| skills             | Fähigkeiten-IDs | Array von Zahlen größer als 0 | 1 | Nein | Arrays unterstützt (z. B. &skills=1&skills=2) |
| category           | Listen-ID | Zahl größer oder gleich 0 | 0 | Nein | 0 für Standardliste; Smart Lists nicht unterstützt |
| frequency          | Wiederholungsfrequenz | Ganzzahl | 0 | Nein | Standard 0 (einmalig)<br/>0 - Einmalig<br/>1 - Täglich<br/>N (N>1) - Alle N Tage<br/>-1 - Unbegrenzt<br/>-3 - Ebbinghaus (v1.99.1+)<br/>-4 - Monatlich<br/>-5 - Jährlich |
| weekdays           | Wochentage | `1,3,5` oder `none` | 1,3,5 | Nein | v1.106.0+; wie add_task. Weglassen = unverändert; `none` setzt auf täglich; frequency ≠ 1 löscht weekdays |
| importance         | Wichtigkeitsstufe | [1, 4] | 1 | Nein | Standard 1 |
| difficulty         | Schwierigkeitsstufe | [1, 4] | 2 | Nein | Standard 1 |
| deadline           | Fälligkeitsdatum | Zeitstempel (Millisekunden) | 1640995200000 | Nein | |
| no_deadline        | Keine Frist | true/false | true | Nein | v1.104.0+; nur für wiederholende Aufgaben. `&no_deadline=true` löscht die konkrete Fälligkeitszeit |
| remind_time        | Erinnerungszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | |
| start_time         | Startzeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | |
| color              | Tag-Farbe | Farbstring | #66CCFF | Nein | # als %23 escapen |
| background_url     | Hintergrundbild-URL | Web-URL | http://example.com/bg.jpg | Nein | |
| background_alpha   | Hintergrund-Deckkraft | Gleitkomma zwischen [0, 1] | 0.5 | Nein | |
| enable_outline     | Textumriss aktivieren | true oder false | false | Nein | Nur mit background_url; Umriss für bessere Lesbarkeit |
| use_light_remark_text_color | Helle Notiz-Schrift | true oder false | false | Nein | Nur mit background_url; helle Farbe für Notiztext |
| item_id            | Gegenstands-ID | Zahl größer als 0 | 1 | Nein* | item_id oder item_name erforderlich |
| item_name          | Gegenstandsname | Beliebiger Text | Treasure | Nein* | item_id oder item_name erforderlich |
| item_amount        | Gegenstandsmenge | [1, 99] | 1 | Nein | Standard 1 |
| items              | Gegenstands-Belohnungen JSON | JSON-Text | [{"itemId":1,"amount":1}] | Nein | Mehrere Gegenstands-Belohnungen setzen |
| auto_use_item      | Gegenstand auto verwenden | true oder false | false | Nein | |
| frozen             | Einfrier-Status | true oder false | false | Nein | Standard false |
| freeze_until       | Einfrieren bis | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Nur wirksam wenn frozen true |
| coin_penalty_factor| Münz-Straffaktor | Gleitkomma zwischen [0, 100) | 0.5 | Nein | |
| exp_penalty_factor | Erfahrungs-Straffaktor | Gleitkomma zwischen [0, 100) | 0.5 | Nein | |
| write_feelings     | Gefühle aktivieren | true oder false | false | Nein | |
| pin                | Aufgabe anheften | true oder false | false | Nein | |
| words              | Abschluss-Belohnungstext | Beliebiger Text | Great job! | Nein | Motivationstext beim Abschluss |
| task_type        | Aufgabentyp | [0, 4] | 0 | Nein | v1.99.1+<br/>0 - Normale Aufgabe<br/>1 - Zähl-Aufgabe<br/>2 - Negative Aufgabe<br/>3 - API-Aufgabe<br/>4 - Zeit-Aufgabe (v1.102.0+) |
| target_times     | Zielanzahl | number > 0 | 1 | Nein | Nur wenn task_type 1 (Zähl-Aufgabe) |
| is_affect_shop_reward | Shop-Belohnung beeinflussen | true/false | false | Nein | Nur wenn task_type 1; ob Gegenstands-Belohnungsberechnung beeinflusst wird |
| enable_proportional_settlement | Proportionale Abrechnung | true/false | false | Nein | v1.104.0+; nur wenn task_type 1. Bei bestehenden Zähl-Aufgaben allein zum Ein-/Ausschalten. Änderung an Einstellung oder Belohnung kann abgerechneten Fortschritt zurücksetzen |
| expected_focus_minutes | Erwartete Fokus-Minuten | number > 0 | 25 | Nein | Nur wenn task_type 4 (Zeit-Aufgabe); Standard 25 (v1.102.0+) |
| repeat_target_times | Wiederholungs-Endanzahl | number > 0 | 3 | Nein | Nur für wiederholende Aufgaben (frequency nicht 0 / -1); bei beiden Feldern hat repeat_target_times Vorrang (v1.102.0+) |
| repeat_end_date | Wiederholungs-Enddatum | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Nur für wiederholende Aufgaben (frequency nicht 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Verhalten bei Wiederholungs-Ende | 0 oder 1 | 0 | Nein | 0 - Aufgabe nach Endbedingung beenden<br/>1 - Aufgabe nach Endbedingung einfrieren (v1.102.0+) |
| coin_set_type     | Münzwert setzen | Einer von:<br/>absolute<br/>relative | absolute | Nein | absolute - Münzen direkt setzen<br/>relative - zum Ausgangswert addieren/subtrahieren |
| exp_set_type      | Erfahrungswert setzen | Einer von:<br/>absolute<br/>relative | absolute | Nein | absolute - Erfahrung direkt setzen<br/>relative - zum Ausgangswert addieren/subtrahieren |

**Antwort:**

| Feld | Typ | Beschreibung | Beispiel | Hinweise |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | Aufgaben-ID | 1000 | |
| task_gid  | Number  | Aufgabengruppen-ID | 1000 | |

<br/>

### Aufgabenvorlagen

?> Eingeführt in v1.102.0+

**Methodenname:** task_template

**Beschreibung:** CRUD für Aufgabenvorlagen.

**Beispiele:**

- Vorlagen auflisten: `lifeup://api/task_template?method=list`
- Aus Parametern erstellen: `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Aus bestehender Aufgabe erstellen: `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Vorlage abrufen: `lifeup://api/task_template?method=get&id=1`
- Vorlagennamen aktualisieren: `lifeup://api/task_template?method=update&id=1&name=NewName`
- Vorlageninhalt aus Aufgabe aktualisieren: `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Vorlage löschen: `lifeup://api/task_template?method=delete&id=1`

| Parameter | Bedeutung | Wert | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Operation | list / get / create / update / delete | list | Ja | - |
| id | Vorlagen-ID | number > 0 | 1 | Nein* | Erforderlich für get/update/delete; Alias: template_id |
| template_id | Vorlagen-ID | number > 0 | 1 | Nein* | Alias von id |
| name | Vorlagenname | Text | MyTemplate | Nein* | Erforderlich für create; für update wenn nicht from_task_id/from_task_gid |
| from_task_id | Aus Aufgaben-ID erstellen | number > 0 | 1 | Nein | Für create/update |
| from_task_gid | Aus Aufgabengruppen-ID erstellen | number > 0 | 1 | Nein | Für create/update |
| todo | Aufgabeninhalt | Text | Write diary | Nein* | Erforderlich für create ohne from_task_id/from_task_gid |
| notes | Notizen | Text | Notes | Nein | Standard leer |
| category | Listen-ID | number >= 0 | 0 | Nein | Alias: category_id |
| category_id | Listen-ID | number >= 0 | 0 | Nein | Alias von category |
| frequency | Wiederholungsfrequenz | Ganzzahl | 0 | Nein | Wie add_task |
| weekdays | Wochentage | `1,3,5` | 1,3,5 | Nein | v1.106.0+; wie add_task; create lehnt `none` ab |
| importance | Wichtigkeitsstufe | [1, 4] | 1 | Nein | - |
| difficulty | Schwierigkeitsstufe | [1, 4] | 1 | Nein | - |
| coin | Münz-Belohnung | number | 10 | Nein | - |
| coin_var | Münz-Belohnungsvarianz | number | 1 | Nein | - |
| exp | Erfahrungs-Belohnung | number | 100 | Nein | - |
| skills | Fähigkeiten-IDs | Array-Parameter | 1 | Nein | Arrays unterstützt (z. B. &skills=1&skills=2) |
| skill_ids | Fähigkeiten-IDs | JSON-Array oder Kommaliste | [1,2] | Nein | Alternative zu skills |
| deadline | Fälligkeitszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | - |
| start_time | Startzeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | - |
| remind_time | Erinnerungszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein | - |
| words | Abschluss-Belohnungstext | Text | Great job! | Nein | - |
| task_type | Aufgabentyp | [0, 4] | 0 | Nein | 0 - Normal<br/>1 - Zähl<br/>2 - Negativ<br/>3 - API<br/>4 - Zeit |
| target_times | Zielanzahl | number > 0 | 10 | Nein | Nur wenn task_type 1 (Zähl-Aufgabe) |
| is_affect_shop_reward | Shop-Belohnung beeinflussen | true / false | false | Nein | Nur wenn task_type 1 (Zähl-Aufgabe) |
| enable_proportional_settlement | Proportionale Abrechnung | true / false | false | Nein | v1.104.0+; nur wenn task_type 1. Aus Vorlage erstellte Aufgaben behalten diese Zähl-Abrechnung |
| expected_focus_minutes | Erwartete Fokus-Minuten | number > 0 | 25 | Nein | Nur wenn task_type 4 (Zeit-Aufgabe) |
| repeat_end_mode | Wiederholungs-Endmodus | 0 oder 1 | 0 | Nein | Nur für wiederholende Aufgaben (frequency nicht 0 / -1)<br/>0 - Nach Anzahl beenden<br/>1 - Nach Datum beenden |
| repeat_target_times | Wiederholungs-Endanzahl | number > 0 | 3 | Nein | Bei repeat_end_mode=0 (oder wenn Feld gesetzt) |
| repeat_end_date | Wiederholungs-Enddatum | Zeitstempel (Millisekunden) | 1640995200000 | Nein | Bei repeat_end_mode=1 (oder wenn Feld gesetzt) |
| repeat_end_behavior | Verhalten bei Wiederholungs-Ende | 0 oder 1 | 0 | Nein | 0 - Beenden<br/>1 - Einfrieren |

**Rückgabe:**

| Feld | Bedeutung | Typ | Hinweise |
| ----- | ------- | ---- | ----- |
| templates | Vorlagenliste (JSON-String) | text | Nur bei method=list |
| count | Anzahl Vorlagen | number | Nur bei method=list |
| template | Vorlagendetail (JSON-String) | text | Nur bei method=get |
| id | Vorlagen-ID | number | Für get/create/update/delete |
| name | Vorlagenname | text | Für get/create/update |
| success | Erfolg | true / false | Für create/update/delete |

<br/>

### Verlaufs-Aufgabenoperation

?> Erfordert v1.98.0+

**Methodenname:** history_operation

**Beschreibung:** Abgeschlossene/aufgegebene/abgelaufene Aufgaben bearbeiten

**Beispiele:**

- Verlaufs-Aufgabe löschen: [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Als aufgegeben markieren: [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Aufgabe neu starten: [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Diese API gilt nur für nicht-offene Aufgaben (abgeschlossen, aufgegeben oder abgelaufen)

| Parameter      | Bedeutung | Werte | Beispiel | Erforderlich | Hinweise |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | Aufgaben-ID | Zahl größer als 0 | 1 | Ja | ID der Verlaufs-Aufgabe |
| operation     | Operationstyp | Einer von:<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Ja | delete - Aufgabe löschen<br/>complete - Als abgeschlossen markieren<br/>undo_complete - Abschluss rückgängig<br/>set_to_give_up - Als aufgegeben markieren<br/>set_to_overdue - Als abgelaufen markieren<br/>edit_completed_time - Abschlusszeit ändern<br/>restart - Aufgabe neu starten |
| completed_time | Abschlusszeit | Zeitstempel (Millisekunden) | 1640995200000 | Nein* | Nur wenn operation edit_completed_time |

**Antwort:**

| Feld | Typ | Beschreibung | Beispiel | Hinweise |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | Aufgaben-ID | 1000 | ID der bearbeiteten Aufgabe |

<br/>

### Shop-Einstellungen

**Methodenname:** shop_settings

**Anleitung:** Verschiedene Shop-Einstellungen anpassen

**Beispiel:**

- ATM-Zinssatz auf 0,01 % setzen: [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Zinssatz pro Klick um 0,01 % erhöhen: [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | Typ | Derzeit nur folgende Werte:<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | Ja | atm_interest - ATM-Tageszinssatz<br/>credit_interest - Kredit-Tageszinssatz<br/>line_of_credit - Kreditrahmen<br/>discount_rate_for_returning - Rückgabe-Rabattfaktor<br/>atm_balance - ATM-Guthaben setzen |
| value     | Numerischer Wert | Dezimal- oder Ganzzahl | 0.01 | Ja | Unterschiedliche Wertebereiche je nach key<br/>ATM-Guthaben unterstützt keine Dezimalstellen |
| set_type  | Wert setzen | Einer von:<br/>absolute<br/>relative | absolute | Nein | absolute - absoluter Wert, Ziel direkt setzen<br/>relative - relativ zum Ausgangswert addieren/subtrahieren |
| silent    | Still ausführen (ohne UI) | Boolean | false | Nein | Ab v1.93.0-beta01 (502)<br/>Standard false = UI-Hinweise anzeigen |

<br/>

### Springen

**Methodenname:** goto

**Beschreibung:** Zu einer Seite in `LifeUp` springen

**Beispiel:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Erklärung:** Zur Labs-Seite springen

| Parameter | Bedeutung | Wert | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | Seite | Einer der folgenden Werte:<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | Ja | `purchase_dialog` bezieht sich auf das Kauf-Popup<br/> `use_item_dialog` bezieht sich auf das Gegenstand-nutzen-Popup<br/>Andere Einträge beziehen sich auf bestimmte Hauptseiten |

#### 1. Zum Kauf-/Nutzungs-Popup für Gegenstände springen

Wenn der Parameter `page` auf `purchase_dialog` oder `use_item_dialog` gesetzt ist, kann die Gegenstands-ID angegeben werden:

Beispiel: `lifeup://api/goto?page=purchase_dialog&id=1`

| Parameter | Bedeutung | Wert            | Beispiel | Erforderlich | Hinweise   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | Gegenstands-ID | Positive Ganzzahl | 1       | Ja      | Gegenstands-ID |

<br/>

#### 2. Zur Unterseite der Startseite springen

Wenn der Parameter `page` `main` ist, kann zusätzlich die Ziel-Unterseite angegeben werden:

Beispiel, zum Shop springen: `lifeup://api/goto?page=main&sub_page=shop`

| Parameter   | Bedeutung       | Wert | Beispiel | Erforderlich | Hinweise  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | Name der Unterseite | Einer von:<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | Nein       |      |
| category_id | Listen-ID       | Zahl | 0      | Nein       | Wenn `sub_page` eine Listenseite ist, kann die Listen-ID zum Springen angegeben werden. <br/>Z. B. Shop-Gegenstandsliste, Inventarliste, Aufgabenliste. |

<br/>

#### 3. Zu Aufgabendetails springen

Wenn der Parameter `page` `task_detail` ist, kann zusätzlich die Aufgaben-ID zum Springen angegeben werden:

Beispiel, zur Detailseite der Aufgabe mit ID 53 springen: `lifeup://api/goto?page=task_detail&task_id=53`

| Parameter | Bedeutung       | Wert         | Beispiel      | Erforderlich | Hinweise |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | Aufgaben-ID       | Aufgaben-ID       | 53           | Nein*      | Aufgaben-ID; bei wiederholenden Aufgaben wird die ID bei jeder Wiederholung aktualisiert. |
| task_gid  | Aufgabengruppen-ID | Aufgabengruppen-ID | 3            | Nein*      | Aufgabengruppen-ID |
| task_name | Aufgabenname     | string        | get up early | Nein*      | Aufgabenname, unscharfer Abgleich mit einer Aufgabe. |

**Hinweis:**

1. Es muss genau einer der drei Parameter angegeben werden.
    - Werden mehrere gleichzeitig angegeben, gilt intern eine Prioritätsreihenfolge. Das ist jedoch undefiniertes Verhalten; die App garantiert die Reihenfolge nicht.

<br/>

#### 4. Zur Seite „Neuer Erfolg“ springen

Wenn der Parameter `page` `add_achievement` ist, **muss** zusätzlich die Kategorie-ID angegeben werden:

Beispiel, zur Seite „Neuer Erfolg“ mit Kategorie-ID 1 springen: `lifeup://api/goto?page=add_achievement&category_id=1`

| Parameter    | Bedeutung         | Wert         | Beispiel | Erforderlich | Hinweise  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Erfolgs-Kategorie-ID | Erfolgs-Kategorie-ID | 1       | Ja      |        |

#### 5. Zur Erfolgskategorie-Seite springen

Wenn der Parameter `page` `user_achievement` ist, **muss** zusätzlich die Kategorie-ID angegeben werden:

Beispiel, zur Erfolgskategorie-Seite mit ID 1 springen: `lifeup://api/goto?page=user_achievement&category_id=1`

| Parameter    | Bedeutung         | Wert         | Beispiel | Erforderlich | Hinweise  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Erfolgs-Kategorie-ID | Erfolgs-Kategorie-ID | 1       | Ja      |        |

#### 6. Zur Synthese-Kategorie-Seite springen

Wenn der Parameter `page` `synthesis` ist, kann optional die Kategorie-ID angegeben werden:

Beispiel, zur Synthese-Kategorie-Seite mit ID 1 springen: `lifeup://api/goto?page=synthesis&category_id=1`

| Parameter    | Bedeutung         | Wert         | Beispiel | Erforderlich | Hinweise  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | Synthese-Kategorie-ID | Synthese-Kategorie-ID | 1       | Nein       |        |

Die Synthese-Seite kann auch mit einem Filter geöffnet werden (v1.102.0+):

Beispiel, nach Produkt-Gegenstands-ID 1 filtern: `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Parameter        | Bedeutung           | Wert | Beispiel | Erforderlich | Hinweise |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Filtertyp       | product / ingredient / related | product | Nein* | Erfordert filter_item_id |
| filter_item_id  | Filter-Gegenstands-ID    | Zahl > 0 | 1 | Nein* | Erfordert filter_type |
| filter_item_name| Filter-Gegenstandsname  | Text | Gem | Nein | Optional, nur für die Anzeige |

### Shop

#### Gegenstände hinzufügen

?> Einige Felder wie `effects` erfordern v1.98.0+

**Methodenname:** add_item

**Beschreibung:** Shop-Gegenstand mit anpassbaren Eigenschaften erstellen, einschließlich Kauflimits und Nutzungseffekten.

**Beispiel:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Parameter        | Bedeutung                | Werte               | Beispiel       | Erforderlich | Hinweise                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Gegenstandsname             | Beliebiger Text             | 10 minute break | Ja    |                                 |
| desc            | Beschreibung           | Beliebiger Text             | Take a break  | Nein       |                                 |
| icon            | Symbol                  | Emoji, http(s)-URL oder integrierter Beispielname | ☕ | Nein | Gespeichert als `emoji_*.webp`, `lifeup_sample_*` oder URL. Name-Emoji setzt das Symbol nicht. |
| price           | Preis                 | [0, 999999]         | 10            | Nein       | Standard ist 0                    |
| stock_number    | Lagerbestand        | [-1, 99999]         | -1            | Nein       | -1 bedeutet unbegrenzt              |
| action_text     | Text der Aktionsschaltfläche    | Beliebiger Text             | rest          | Nein       |                                 |
| disable_purchase| Kauf deaktivieren      | true oder false        | false         | Nein       | Standard ist false                |
| disable_use     | Nutzung deaktivieren           | true oder false        | false         | Nein       | Standard ist false                |
| category        | Kategorie-ID           | Zahl größer als oder gleich 0 | 0 | Nein    | 0 für Standardkategorie          |
| order           | Anzeigereihenfolge         | Ganzzahl              | 1             | Nein       | Position in der Kategorie            |
| purchase_limit  | Einschränkungsregeln     | JSON-Text            | Siehe [Kauflimit-Struktur](#3-kauflimit-struktur) | Nein | Konfigurierbare Kauf-/Nutzungseinschränkungen |
| limit_scope     | Geltungsbereich der Einschränkung     | purchase / use / both | purchase | Nein | Nur wirksam, wenn `purchase_limit` nicht leer ist; Standard ist `purchase` |
| effects         | Nutzungseffekte           | JSON-Text            | Siehe [Gegenstandseffekt-Struktur](#4-gegenstandseffekt-struktur) | Nein | Effekte bei Gegenstandsnutzung |
| own_number      | Anfangsbesitzmenge | Ganzzahl             | 0             | Nein       | Anfangsbestand im Inventar setzen  |
| unlist          | Im Shop ausblenden        | true oder false        | false         | Nein       | Standard ist false                |

**Rückgabedaten:**

| Feld    | Typ    | Beschreibung    | Beispiel | Hinweise                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | Gegenstands-ID        | 1000    | ID des erstellten Gegenstands   |

!> Der Parameter `effects` überschreibt `disable_use`. Wird `effects` so gesetzt, dass der Gegenstand nicht nutzbar ist, wird `disable_use` ignoriert.

<br/>

#### Gegenstand bearbeiten

?> Erfordert v1.98.0+

**Methodenname:** item

**Beschreibung:** Bestehende Gegenstände bearbeiten, einschließlich Preis, Bestand, Effekte und weiterer Eigenschaften

**Beispiele:**

- Preis anpassen: [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Effekte ändern: [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - Der dekodierte Inhalt des Parameters `effects` ist: `[{"type":2,"info":{"min":100,"max":200}}]`

| Parameter         | Bedeutung             | Werte               | Beispiel   | Erforderlich | Hinweise                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | Gegenstands-ID             | Zahl größer als 0| 1         | Nein*      | Entweder id oder name erforderlich      |
| name             | Gegenstandsname           | Beliebiger Text             | Treasure  | Nein*      | Für unscharfen Abgleich, nicht zum Umbenennen  |
| set_name         | Name setzen            | Beliebiger Text             | Treasure  | Nein       | Darf nicht leer sein                 |
| set_desc         | Beschreibung setzen     | Beliebiger Text             | Get gift  | Nein       |                                |
| set_icon         | Symbol setzen            | Emoji, http(s)-URL oder integrierter Beispielname | ☕ | Nein | Wie `icon`. Nicht unterstützte Werte liefern `unsupported_parameter`. |
| set_price        | Preis anpassen        | Ganzzahl              | 1         | Nein       |                                |
| set_price_type   | Preisanpassungsmethode | absolute oder relative | relative  | Nein       | absolute – direkt setzen<br/>relative – addieren/subtrahieren |
| own_number       | Besitzmenge anpassen| Ganzzahl             | 1         | Nein       | Negative Werte bei relative möglich |
| own_number_type  | Anpassung der Besitzmenge| absolute oder relative| relative  | Nein       | absolute – direkt setzen<br/>relative – addieren/subtrahieren |
| stock_number     | Bestand anpassen        | [-1, 99999]         | 1         | Nein       | -1 bedeutet unbegrenzter Bestand        |
| stock_number_type| Bestandsanpassungsmethode | absolute oder relative | relative  | Nein       | absolute – direkt setzen<br/>relative – addieren/subtrahieren |
| disable_purchase | Kauf deaktivieren    | true oder false        | false     | Nein       | Standard ist false              |
| disable_use      | Nutzung deaktivieren         | true oder false        | false     | Nein       | Standard ist false              |
| action_text      | Text der Nutzen-Schaltfläche     | Beliebiger Text             | Use       | Nein       |                                |
| title_color_string| Titelfarbe        | Farbstring         | #66CCFF   | Nein       | # muss als %23 escaped werden<br/>Leerer Wert stellt Standard wieder her |
| effects          | Nutzungseffekte         | JSON-Text            | Siehe [Gegenstandseffekt-Struktur](#4-gegenstandseffekt-struktur) | Nein | Nutzungseffekte des Gegenstands setzen |
| purchase_limit   | Einschränkungsregeln   | JSON-Text            | Siehe [Kauflimit-Struktur](#3-kauflimit-struktur) | Nein | `null` übergeben, um alle Einschränkungen zu löschen |
| limit_scope      | Geltungsbereich der Einschränkung   | purchase / use / both | purchase | Nein | Wird nur aktualisiert, wenn dieses Feld angegeben ist; wird automatisch gelöscht, wenn `purchase_limit` leer wird |
| category_id      | Kategorie-ID         | Zahl >= 0          | 1         | Nein       | 0 für Standardkategorie         |
| order            | Anzeigereihenfolge       | Ganzzahl              | 1         | Nein       | Position in der Kategorie           |
| unlist           | Aus dem Shop entfernen    | true oder false        | false     | Nein       | Standard ist false              |

!> Zum Auffinden des zu bearbeitenden Gegenstands muss entweder der Parameter id oder name angegeben werden

<br/>

#### Lootbox-Effekt anpassen

**Methodenname:** loot_box

**Beschreibung:** Lootbox-Effekt des angegebenen Kisten-Gegenstands ändern; Anpassung von Wahrscheinlichkeit, Belohnungsanzahl und Hinzufügen von Inhalten unterstützt. (Löschen derzeit nicht unterstützt)

**Beispiel:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Erklärung:** Anteil der [großen] Münztüte in der Münzkiste um 1 Punkt erhöhen.

| Parameter   | Bedeutung                               | Typ                                                    | Beispiel        | Erforderlich | Hinweise                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | Gegenstands-ID                               | Zahl größer als 0                                 | 1              | Nein*      | Zum Ermitteln siehe oben „Grundlagen – LifeUp-Daten-ID“ |
| name        | Gegenstandsname                             | Beliebiger Text                                                | Treasure chest | Nein*      | Bei unbekannter ID unscharfer Abgleich; keine Namensänderung |
| sub_id      | Inhalts-Gegenstands-ID                       | Zahl größer als 0                                 | 1              | Nein*      | ID des Kisteninhalts                                         |
| sub_name    | Inhalts-Gegenstandsname                     | Beliebiger Text                                                | Get a gift     | Nein*      | Unscharfer Abgleich, wenn die ID des Kisteninhalts unbekannt ist |
| set_type    | Anpassungsmethode (absolute/relative) | Einer der folgenden Werte: <br/>absolute<br/>relative | relative       | Nein       | absolute – absoluter Wert, Ziel direkt setzen<br/>relative – relativ zum Ausgangswert addieren/subtrahieren |
| amount      | Anzahl des Inhaltsgegenstands                | Zahl                                                  | 1              | Nein       | Belohnungsanzahl für einen einzelnen Gegenstand                          |
| probability | Wahrscheinlichkeit des Inhaltsgegenstands       | Zahl                                                  | 1              | Nein       | -                                                            |
| fixed       | Ob feste Belohnung          | boolean                                                 | true/false     | Nein       | -                                                            |

**Hinweis:**

1. Zum Auffinden eines Produkts muss entweder id oder name angegeben werden.
1. Zum Auffinden eines Inhalts muss entweder sub_id oder sub_name angegeben werden.
1. `name` und `sub_name` versuchen zuerst exakten Abgleich, dann unscharfen Abgleich.
1. Die Legacy-API `loot_box` behält ihr Kompatibilitätsverhalten: Erscheint derselbe Inhaltsgegenstand mehrfach mit unterschiedlichen Mengen, wird der erste passende Eintrag bearbeitet; `sub_amount` dient nicht zur Unterscheidung. Für mengenspezifisches Bearbeiten, Löschen oder Zusammenführen `loot_box/v2` verwenden.

<br/>

#### Lootbox-Effekt anpassen (v2)

?> Diese API wurde in Version v1.104.2 eingeführt.

**Methodenname:** loot_box/v2

**Beschreibung:** Verbesserte Version der loot_box-API. Lootbox-Effekt des angegebenen Kisten-Gegenstands ändern; Anpassung von Wahrscheinlichkeit, Belohnungsanzahl, Hinzufügen von Inhalten und **Löschen von Inhalten** unterstützt.

**Verbesserungen gegenüber v1:**
- **`sub_amount` für präzisen Abgleich**: Enthält die Kiste mehrere Einträge desselben Gegenstands mit unterschiedlichen Mengen (z. B. A x1 50 %, A x2 30 %), mit `sub_amount` einen bestimmten Eintrag ansprechen. Standardwert ist `1`. Wird kein passender Eintrag gefunden, sucht LifeUp den Gegenstand über `sub_id` / `sub_name` und fügt einen neuen Eintrag hinzu; bei einer Löschanfrage mit `amount=0` wird kein neuer Eintrag hinzugefügt.
- **Unabhängiges `set_type`**: `amount_set_type` und `probability_set_type` lassen sich unabhängig steuern. Das globale `set_type` dient als Fallback-Standard.
- **Löschen unterstützt**: `amount=0` mit `amount_set_type=absolute` (oder berechnet `<=0` bei `relative`) löscht den passenden Eintrag.
- **Duplikat-Zusammenführung**: Würde eine Änderung von `amount` einen bestehenden Eintrag mit demselben Gegenstand und derselben Menge in derselben Kiste duplizieren, führt LifeUp eine Zusammenführung in den bestehenden Eintrag durch und wendet weiterhin die `probability`-/`fixed`-Werte der Anfrage an.

**Beispiel:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Erklärung:** Wahrscheinlichkeit der [großen] Münztüte (x2) in der Münzkiste um 10 Punkte erhöhen.

| Parameter              | Bedeutung                               | Typ                                                    | Beispiel        | Erforderlich | Hinweise                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | Gegenstands-ID                               | Zahl größer als 0                                 | 1              | Nein*      | Zum Ermitteln siehe oben „Grundlagen – LifeUp-Daten-ID“ |
| name                   | Gegenstandsname                             | Beliebiger Text                                                | Treasure chest | Nein*      | Bei unbekannter ID unscharfer Abgleich; keine Namensänderung |
| sub_id                 | Inhalts-Gegenstands-ID                       | Zahl größer als 0                                 | 1              | Nein*      | ID des Kisteninhalts. Sind sub_id und sub_name gesetzt, hat sub_id Vorrang |
| sub_name               | Inhalts-Gegenstandsname                     | Beliebiger Text                                                | Get a gift     | Nein*      | Unscharfer Abgleich, wenn die ID des Kisteninhalts unbekannt ist |
| sub_amount             | Inhaltsmenge für Abgleich      | Zahl                                                  | 2              | Nein       | Zum präzisen Abgleich eines Eintrags mit dieser Menge. Minimum `1`, Standard `1`. Wird kein Treffer gefunden und es ist keine Löschanfrage, wird ein neuer Eintrag hinzugefügt. |
| set_type               | Globale Anpassungsmethode              | Einer von: `absolute` / `relative`                         | relative       | Nein       | Standard für `amount_set_type` und `probability_set_type`, falls nicht angegeben |
| amount_set_type        | Anpassungsmethode für amount          | Einer von: `absolute` / `relative`                         | relative       | Nein       | Überschreibt `set_type` für das Feld amount                    |
| probability_set_type   | Anpassungsmethode für probability     | Einer von: `absolute` / `relative`                         | absolute       | Nein       | Überschreibt `set_type` für das Feld probability               |
| amount                 | Anzahl des Inhaltsgegenstands                | Zahl                                                  | 1              | Nein       | Belohnungsanzahl für einen einzelnen Gegenstand. `0` (absolute) oder berechnet `<=0` (relative) löscht den Eintrag |
| probability            | Wahrscheinlichkeit des Inhaltsgegenstands       | Zahl                                                  | 1              | Nein       | -                                                            |
| fixed                  | Ob feste Belohnung          | boolean                                                 | true/false     | Nein       | -                                                            |
| query                  | Kisteninhalte auflisten                     | true oder false                                           | true           | Nein       | v1.105.1+. Gibt nur Gegenstands-JSON zurück; sub_id / sub_name nicht erforderlich |

**Hinweis:**

1. Zum Auffinden eines Produkts muss entweder id oder name angegeben werden.
1. Zum Auffinden eines Inhalts muss entweder sub_id oder sub_name angegeben werden. Mit `query=true` Inhalte auflisten, ohne sub_id / sub_name.
1. Sind `sub_id` und `sub_name` gesetzt, hat `sub_id` Vorrang. `sub_name` wird nur verwendet, wenn keine gültige `sub_id` angegeben ist.
1. `name` und `sub_name` versuchen zuerst exakten Abgleich, dann unscharfen Abgleich.
1. `sub_amount` ist standardmäßig `1`. Hat die Kiste mehrere Einträge desselben Gegenstands mit unterschiedlichen Mengen, `sub_amount` angeben, um einen bestimmten Eintrag anzusprechen. Wird kein Treffer gefunden und es ist keine Löschanfrage, wird ein neuer Eintrag mit `amount=sub_amount` hinzugefügt.
1. Zum Löschen eines Eintrags `amount=0` mit `amount_set_type=absolute` setzen oder `amount_set_type=relative` mit negativem Wert, der die Summe auf `<=0` bringt. Löschen gilt nur für passende Einträge; wird kein bestehender Eintrag getroffen, fügt `amount=0` keinen neuen Eintrag hinzu.
1. Würde eine Änderung von `amount` einen bestehenden Eintrag mit demselben Gegenstand und derselben Menge in derselben Kiste duplizieren, führt LifeUp eine Zusammenführung in den bestehenden Eintrag durch und wendet weiterhin die `probability`-/`fixed`-Werte der Anfrage an.
1. Bleibt die Kiste nach dem Löschen leer, wird der gesamte Lootbox-Effekt soft-gelöscht (der Gegenstand selbst bleibt erhalten; Lootbox-Einträge können später erneut hinzugefügt werden).

<br/>

#### Gegenstände nutzen

?> Diese API wurde in Version v1.93.0-beta01 (502) eingeführt.

**Methodenname:** use_item

**Beschreibung:** Angegebenen Gegenstand nutzen.

**Beispiel:**

- Münzkiste öffnen: [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Parameter | Bedeutung     | Typ                    | Beispiel  | Erforderlich | Hinweise                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | Gegenstands-ID     | Zahl größer als 0 | 1        | Nein*      | Zum Ermitteln der Gegenstands-ID siehe „Grundlagen – LifeUp-Daten-ID“ |
| name      | Gegenstandsname   | Beliebiger Text                | coin_box | Nein*      | Bei unbekannter ID; unscharfer Abgleich für Gegenstände      |
| use_times | Nutzungsanzahl | Zahl größer als 0 | 1        | Nein       | Standard ist 1<br/>Bei normalen Gegenständen oder Kistenöffnung entspricht dies der Gegenstandsmenge<br/>Bei einfacher Synthese entspricht der Wert der „Synthesemenge“, nicht der verbrauchten Gegenstandsanzahl |

**Rückgabe:**

!> Diese API kann aus verschiedenen Gründen fehlschlagen; konkrete Fehlerursachen können in den Rückgabewerten stehen.

| Parameter | Bedeutung            | Typ     | Beispiel          | Erforderlich | Hinweise                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Ergebniscode        | Zahl | 0                | Ja      | 0 – Erfolgreiche Nutzung<br/>1 – Datenbankausnahme<br/>2 – Einschränkung: unzureichende Erfahrungspunkte<br/>3 – Gegenstand nicht gefunden<br/>4 – Konflikt mit laufendem Countdown<br/>5 – Unzureichender Bestand<br/>6 – Nicht nutzbarer Gegenstand<br/>7 – Münzlimit<br/>8 – Ziel-Bestandslimit<br/>9 – Einschränkung: Attributstufe<br/>10 – Zeiteinschränkung<br/>11 – Einschränkung: Besitzmenge<br/>12 – Einschränkung: Aufgabe abgeschlossen<br/>13 – Einschränkung: Erfolg freigeschaltet<br/>14 – Einschränkung: Periodenmenge<br/>15 – Einschränkung: Aufgabenzyklus abgeschlossen |
| desc      | Ergebnisbeschreibung | Text     | RunningCountDown | Ja      |                                                              |

<br/>

### ATM

**⚠ Nur verfügbar ab v1.91+**

> Ein- und Auszahlungen werden hier geprüft.
>
> Zum direkten Anpassen des ATM-Guthabens siehe oben die Oberfläche „Shop-Einstellungen“.

#### Einzahlung

**Methodenname:** deposit

**Beschreibung:** Die Einzahlung wird auf Gültigkeit geprüft (ob das Münzguthaben ausreicht).

**Beispiel:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Erklärung:** 500 Münzen einzahlen.

| Parameter | Bedeutung        | Typ                    | Beispiel | Erforderlich | Hinweise |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | Einzahlungsbetrag | Zahl größer als 0 | 100     | Ja      | -     |

**Rückgabe:**

| Parameter | Bedeutung                              | Typ              | Beispiel | Erforderlich | Hinweise |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Ob die Operation erfolgreich war | `true` oder `false` | true    | Ja      | -     |

<br/>

#### Auszahlung

**Methodenname:** withdraw

**Beschreibung:** Auszahlungen werden auf Gültigkeit geprüft (ob das ATM-Guthaben ausreicht).

**Beispiel:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Erklärung:** 500 Münzen abheben.

| Parameter | Bedeutung           | Typ                    | Beispiel | Erforderlich | Hinweise |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | Auszahlungsbetrag | Zahl größer als 0 | 100     | Ja      | -     |

**Rückgabe:**

| Parameter | Bedeutung                              | Typ              | Beispiel | Erforderlich | Hinweise |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Ob die Operation erfolgreich war | `true` oder `false` | true    | Ja      | -     |

<br/>

### Pomodoro-Timer

**Methodenname:** pomodoro_timer

**Beschreibung:** Steuert den echten Pomodoro-Countdown oder Hochzähler in LifeUp. Diese API startet
dieselbe Timer-Sitzung wie die App-Oberfläche; sie fügt keine Pomodoro-Aufzeichnungen oder Tomaten direkt hinzu.

**Beispiele:**

- Standard-Arbeits-Countdown starten oder fortsetzen:
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Hochzähler starten und Aufgabe 101 auswählen:
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Aktiven Countdown pausieren:
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Pomodoro-Lebenszyklus abbrechen und zurücksetzen:
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Aktuelle Pomodoro-Phase überspringen:
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Hochzähler ohne Tomaten-Belohnung abschließen:
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Beide Timer-Modi abfragen:
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Parameter:**

| Parameter | Bedeutung | Typ / Werte | Erforderlich | Hinweise |
| --------- | ------- | ------------- | -------- | ----- |
| action | Operation | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | Ja | - |
| mode | Timer-Modus | `countdown`, `count_up` | für `start`, `pause`, `abandon` und `complete` | `skip` betrifft immer den Countdown. |
| stage | Countdown-Phase | `work`, `short_break`, `long_break` | Nein | Nur gültig mit `mode=countdown`. Wenn weggelassen, wird die aktive, pausierte oder als Nächstes vorgesehene kanonische Phase verwendet; ein neuer Lebenszyklus startet mit `work`. |
| receive_reward | Tomaten-Belohnung erhalten | `true` oder `false` | für `complete` | Striktes Boolean. `complete` unterstützt nur `mode=count_up`. |
| task_id | Aufgaben-ID | positive Ganzzahl | Nein | Nicht kombinierbar mit `task_gid` oder `task_name`. |
| task_gid | Aufgabengruppen-ID | positive Ganzzahl | Nein | Kann mit `task_name` kombiniert werden, um den Treffer einzugrenzen. |
| task_name | Aufgabenname | Text | Nein | Exakter Abgleich bevorzugt, unscharfer Abgleich als Fallback. |
| clear_task | Timer-Aufgabe löschen | `true` oder `false` | Nein | `true` nicht kombinierbar mit einem Aufgaben-Locator. |

`select_task` erfordert entweder einen Aufgaben-Locator oder `clear_task=true`. `start` kann dieselben
Aufgabenauswahl-Parameter enthalten. Benutzerdefinierte Dauer-Parameter werden nicht unterstützt: Countdowns nutzen die
aktuelle Standarddauer oder die Pomodoro-Dauer der ausgewählten Aufgabe.

`abandon&mode=countdown` entspricht der linken Aktion in der App: Sie bricht die aktuelle Phase ab,
setzt den Pomodoro-Lebenszyklus zurück und kehrt zu einer gestoppten Arbeits-Phase zurück. `skip` entspricht der
rechten Aktion: Sie wechselt von Arbeit zu kurzer/langer Pause oder von Pause zu Arbeit, ohne die
nächste Phase automatisch zu starten. Jeder `skip`-Aufruf ist eine echte, nicht idempotente Aktion; Aufrufer dürfen ihn nicht
automatisch wiederholen.

`complete&mode=count_up` schließt die echte Hochzähler-Sitzung ab. Sitzungen kürzer als 30 Sekunden werden
verbraucht, ohne einen Eintrag zu erstellen. Mit `receive_reward=false` wird ein Eintrag, der den Schwellenwert
erreicht, trotzdem als abgebrochen gespeichert, vergibt aber keine Tomaten.

**Regeln für Aufgabenwechsel:**

- Ein laufender Arbeits-Countdown lehnt Aufgabenwechsel ab.
- Ein laufender Hochzähler erlaubt Aufgabenwechsel und aktualisiert die Benachrichtigung.
- Ein pausierter Countdown erlaubt Aufgabenwechsel, behält die verstrichene Zeit bei und berechnet die Gesamtdauer
  anhand der Einstellungen der neuen Aufgabe neu.

**Erfolgreiche Rückgabewerte:**

| Parameter | Bedeutung | Typ |
| --------- | ------- | ---- |
| api_result | Ob der API-Aufruf erfolgreich war | boolean |
| applied | Ob dieser Aufruf den Timer-Zustand geändert hat | boolean |
| mode | Ziel- oder aktuell ausgewählter Timer-Modus | `countdown` oder `count_up` |
| state | Zustand von `mode` | `running`, `paused` oder `stopped` |
| selected_task_id | Aktuelle Timer-Aufgaben-ID oder `0` | number |
| can_start_in_background | Ob Android derzeit einen Timer-Start im Hintergrund erlaubt | boolean |
| countdown_state | Kanonischer Countdown-Zustand | `running`, `paused` oder `stopped` |
| countdown_phase | Countdown-Lebenszyklusphase | `idle`, `running`, `paused`, `completing`, `completed` oder `cancelled` |
| countdown_stage | Kanonische Countdown-Phase | `work`, `short_break` oder `long_break` |
| countdown_session_id | Kanonische Countdown-Sitzungs-ID | text oder null |
| countdown_total_millis | Gesamtdauer des Countdowns | Millisekunden |
| countdown_remaining_millis | Verbleibende Countdown-Dauer | Millisekunden |
| count_up_state | Kanonischer Hochzähler-Zustand | `running`, `paused` oder `stopped` |
| count_up_elapsed_millis | Verstrichene Hochzähler-Dauer | Millisekunden |
| battery_optimization_ignored | Ob LifeUp von der Akku-Optimierung ausgenommen ist | boolean |

Erfolgreiche `complete`-Antworten enthalten zusätzlich `record_created`, `reward_tomatoes` und
`settled_elapsed_millis`.

Wiederholte `start`-, `pause`- oder `abandon`-Aufrufe, die bereits dem gewünschten Zustand entsprechen, sind erfolgreich mit
`applied=false`. Mutierende Aufrufe bieten keine prozessübergreifende Retry-Deduplizierung.

**Fehler:**

Fehlschläge liefern `api_result=false`, `error_code` und `error_message`. Stabile timer-spezifische Fehlercodes
sind:

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

Ab Android 12 kann ein ContentProvider-Aufruf im Hintergrund einen Timer nur starten, wenn LifeUp
die Akku-Optimierung ignorieren darf. Andernfalls wird `background_start_not_allowed`
zurückgegeben, bevor der Timer-Zustand geändert wird. Das Öffnen des URL-Schemas über die zugehörige Activity bringt LifeUp in den
Vordergrund, bevor gestartet wird. Android kann verhindern, dass eine Drittanbieter-App diese Activity aus dem
Hintergrund startet; in diesem Fall erhält LifeUp keinen API-Aufruf und kann keinen Fehler zurückgeben.

<br/>

### Pomodoro-Aufzeichnung

#### Pomodoro-Aufzeichnung hinzufügen

**Methodenname:** add_pomodoro

**Beschreibung:** Tomaten-Zeitaufzeichnung hinzufügen

**Beispiel:**

- Zeitaufzeichnung mit 25 Minuten Dauer (1.500.000 ms) und Verknüpfung mit einer Aufgabe, deren Name „learning“ enthält: [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Zeitaufzeichnung für `2022-08-01 11:00:00` – `2022-08-01 12:00:00` hinzufügen: [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Erklärung:**

| Parameter        | Bedeutung                    | Typ                    | Beispiel       | Erforderlich | Hinweise |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | Startzeit der Aufzeichnung          | Zeitstempel               | 1659322800000 | Nein*      | Bei Unklarheit über Zeitstempel einfach googeln! |
| duration         | Fokus-Dauer             | Zahl (in Millisekunden) <br/>muss größer als 30000 sein | 1500000 | Nein* | |
| end_time         | Endzeit der Aufzeichnung            | Zeitstempel               | 1659326400000 | Nein*      |       |
| reward_tomatoes  | Tomaten belohnen | true oder false           | true          | Nein       | Standard ist false |
| task_id          | Aufgaben-ID                    | Zahl größer als 0 | 1             | Nein       |       |
| task_gid         | Aufgabengruppen-ID              | Zahl größer als 0 | 1             | Nein       |       |
| task_name        | Name                       | Beliebiger Text                | learning      | Nein       | Unscharfe Suche; nur eine der gefundenen Aufgaben |
| ui               | UI für belohnte Tomaten anzeigen | true oder false         | true          | Nein       | Eingeführt in v1.94.0, Standard ist true |

**Hinweis:**

1. Einer von start_time, duration, end_time muss angegeben werden.
2. Bei nur duration ist die Standard-end_time die aktuelle Zeit.
3. end_time muss größer als start_time sein.
4. duration beträgt mindestens 30.000 Millisekunden (30 Sekunden).
5. Sind start_time, duration und end_time gesetzt, sollte duration kleiner oder gleich (end_time - start_time) sein.

<br/>

#### Pomodoro-Aufzeichnung bearbeiten

> Eingeführt in v1.94.0
> **Methodenname:** edit_pomodoro

**Beschreibung:** Bestehende Pomodoro-Zeitaufzeichnung bearbeiten oder bei gültiger `edit_item_id` einen neuen Eintrag hinzufügen.

**Beispiel:**

- Eintrag mit angegebener ID bearbeiten, Dauer auf 45 Minuten (2.700.000 ms) setzen und Tomaten belohnen: [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Eintrag nach Start- und Endzeit bearbeiten: [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Parameter:**

| Parameter       | Bedeutung                    | Typ                  | Beispiel       | Erforderlich | Hinweise                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | Aufgaben-ID                    | Zahl größer als 0 | 101           | Nein       | Eindeutige Kennung der Aufgabe                   |
| task_gid        | Aufgabengruppen-ID              | Zahl größer als 0 | 5             | Nein       | Wenn gesetzt, überschreibt task_id                |
| task_name       | Aufgabenname                  | Beliebiger Text              | Study         | Nein       | Erforderlich, wenn weder task_id noch task_gid gesetzt sind   |
| start_time      | Startzeit der Aufzeichnung          | Zeitstempel             | 1659322800000 | Nein*      | Bei Unklarheit über Zeitstempel googeln     |
| end_time        | Endzeit der Aufzeichnung            | Zeitstempel             | 1659326400000 | Nein*      | -                                                |
| duration        | Fokus-Dauer             | Zahl (Millisekunden) | 2700000       | Nein*      | Mindestens 30.000 Millisekunden (30 Sekunden) |
| reward_tomatoes | Tomaten belohnen | true oder false         | true          | Nein       | Standard ist false                                 |
| edit_item_id    | ID des zu bearbeitenden Eintrags     | Zahl größer als 0 | 123           | Ja      | Gibt die zu bearbeitende Aufzeichnungs-ID an                  |
| ui              | UI für Tomaten-Belohnung anzeigen | true oder false         | true          | Nein       |                                                  |
| delete          | Aufzeichnung löschen          | true oder false         | true          | Nein       | v1.105.1+. Soft-Delete der Pomodoro-Aufzeichnung (`isDel`), wie in der App |

**Rückgabewerte:**

| Parameter | Bedeutung                          | Typ   | Beispiel | Erforderlich | Hinweise                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Durch diese Aktion erhaltene Tomaten | Number | 2       | Nein       | Wird zurückgegeben, wenn `ui` true ist |

**Hinweise:**

1. Mindestens einer von `start_time`, `duration`, `end_time` muss angegeben werden.
2. `end_time` muss größer als `start_time` sein.
3. `duration` sollte kleiner oder gleich (`end_time` - `start_time`) sein.
4. Ist `edit_item_id` gesetzt und der entsprechende Eintrag wird gefunden, wird er bearbeitet; andernfalls wird anhand der anderen Parameter ein neuer Eintrag erstellt.

<br/>

### Freischaltbedingungen für Erfolge

**Methodenname:** unlock_condition

**Beschreibung:** Freischaltbedingung für Erfolge: erfordert einen externen API-Aufruf zum Freischalten

**Beispiel:**

- Freischaltbedingung mit Freischalt-ID 2 aufrufen: [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Parameter | Bedeutung      | Typ                  | Beispiel | Erforderlich | Hinweise |
| --------- | ------------ | --------------------- | ------- | -------- |------ |
| id        | Bedingungs-ID | number greater than 0 | 2       | ja      |       |

<br/>

### Erfolg abschließen / Belohnung abholen

?> Diese API wurde in v1.105.1 eingeführt.

**Methodenname:** complete_achievement

**Beschreibung:** Schließt einen manuellen Erfolg ab und holt die Belohnung ab, oder holt die Belohnung eines bereits freigeschalteten automatischen Erfolgs ab. Entspricht dem Tippen auf das Abschluss-Kontrollkästchen bzw. den Button „Belohnung abholen“ in der App.

**Beispiel:**

- Erfolg mit ID 1 abschließen oder Belohnung abholen: [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Parameter | Bedeutung        | Typ                  | Beispiel | Erforderlich | Hinweise |
| --------- | -------------- | --------------------- | ------- | -------- | ----- |
| id        | Erfolgs-ID | number greater than 0 | 1       | ja      |       |

**Rückgabewert:**

| Feld  | Typ   | Beschreibung | Beispiel | Hinweise |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | Erfolgs-ID | 1 | |
| status | number | Status nach dem Aufruf | 2 | `0` gesperrt · `1` freigeschaltet, Belohnung nicht abgeholt · `2` freigeschaltet, Belohnung abgeholt |

**Hinweise:**

1. Manuelle Erfolge (ohne Freischaltbedingungen): Wenn noch gesperrt, schließt dieser Aufruf den Erfolg ab und gewährt Belohnungen.
2. Automatische Erfolge (mit Freischaltbedingungen): Holt Belohnungen nur ab, wenn bereits freigeschaltet und noch eine Belohnung aussteht. Sind die Bedingungen nicht erfüllt, schlägt der Aufruf mit `error_code=achievement_not_unlocked` fehl.
3. Ein erneuter Aufruf nach bereits abgeholter Belohnung gelingt mit `status=2` und gewährt Belohnungen nicht erneut.
4. Das unterscheidet sich von `achievement?unlocked=true`, das nur den Freischaltstatus schreibt und keine Belohnungen gewährt.

<br/>

### Schrittzahl setzen

**Methodenname:** step

**Beschreibung:** Setzt die Schrittzahl für das angegebene Datum — z. B. zum Eintragen von Schritten per Fitnessarmband + Automatisierungstool. Eignet sich auch zum Ändern historischer Einträge.

**Beispiel:**

- Schrittzahl für den 2022-10-21 in Zeitzone GMT+8 auf 9999 setzen: [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Parameter | Bedeutung                         | Typ                                | Beispiel       | Erforderlich | Hinweise |
| --------- | ------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | Schrittzahl                 | a number greater than or equal to 0 | 9999          | ja      |       |
| time      | Beliebiger Zeitstempel des Datums | timestamp (ms)                      | 1666282995643 | ja      |       |

<br/>

### Erfahrung bearbeiten

?> Diese API wurde in Version v1.93.0-beta01 (502) eingeführt.

**Methodenname:** edit_exp

**Beschreibung:** Diese API kann die aktuellen Erfahrungswerte für Attribute stapelweise setzen. Sie kann einen konkreten Erfahrungswert oder eine bestimmte Stufe direkt setzen.

**Beispiel:**

> Diese API verändert Daten; um versehentliche Nutzung zu vermeiden, gibt es hier keine direkt klickbaren Links.

- Erfahrungswerte der Attribute [Strength] und [Knowledge] auf 0 zurücksetzen: lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Erfahrungswert von [Charm] direkt auf Stufe 50 setzen: lifeup://api/edit_exp?skills=3&level=50

| Parameter | Bedeutung              | Typ                                      | Beispiel | Erforderlich | Hinweise |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | Attribut- (Fähigkeiten-)ID | Array of numbers greater than 0           | 1       | Nein       | Unterstützt Arrays (z. B. &skills=1&skills=2&skills=3)<br/>Zur Attribut-ID siehe „Grundlagen – LifeUp-Daten-ID“ |
| exp       | Erfahrungswert setzen | Number greater than or equal to 0 (int32) | 9999    | Nein, aber exp oder level erforderlich |                                                               |
| level     | Stufe setzen            | Number greater than or equal to 0 (int32) | 50      | Nein, aber exp oder level erforderlich | Entspricht dem Start-Erfahrungswert einer Stufe<br/>und wird von benutzerdefinierten Stufenverläufen beeinflusst. |

<br/>

### Gefühle hinzufügen oder bearbeiten

?> Diese API ist ab Version v1.93.4 (536) verfügbar.

**Methodenname:** feeling

**Beschreibung:** Dient zum Erstellen oder Aktualisieren von Gefühls-Einträgen.

**Beispiel:**

- Neuen Gefühls-Eintrag erstellen: [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Bestehenden Gefühls-Eintrag aktualisieren und als Favorit markieren: [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Gefühl löschen: [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Parameter            | Bedeutung           | Typ                               | Beispiel           | Erforderlich | Hinweise                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | Gefühls-Eintrags-ID | Number greater than 0              | 1                 | Nein       | Wenn gesetzt, versucht die Methode, einen bestimmten Eintrag zu aktualisieren. Beim Löschen erforderlich.                                                                                                                                                           |
| content              | Inhalt           | Any text                           | Happy             | Nein       | Zum Erstellen eines neuen Eintrags oder Aktualisieren des Inhalts eines bestehenden                                                                                                                                                                    |
| time                 | Zeitstempel         | Unix timestamp                     | 1633036800        | Nein       | Zeit des Eintrags; Standard ist die aktuelle Zeit                                                                                                                                                                                             |
| is_favorite          | Favoriten-Markierung     | true or false                      | true              | Nein       | Markiert den Eintrag als Favorit oder nicht                                                                                                                                                                                                        |
| delete               | Löschen            | true or false                      | true              | Nein       | v1.105.1+. Soft-Delete des Gefühls wie in der App (Anhänge werden entfernt).                                                                                                                                                       |
| relate_type          | Verknüpfungstyp     | Number between 0 and 3             | 1                 | Nein       | Typ der mit dem Eintrag verknüpften Beziehung:<br/>0: Aufgabe<br/>1: Benutzerdefinierter Erfolg<br/>2: Keine Verknüpfung<br/>3: Gegenstands-Nutzung                                                                                                        |
| relate_id            | Verknüpfte ID        | Number greater than 0              | 2                 | Nein       | ID des verknüpften Elements:<br/>Bei relate_type 0: Aufgaben-ID<br/>Bei relate_type 1: Erfolgs-ID<br/>Bei relate_type 3: Gegenstands-ID<br/>Bei relate_type 2: keine ID nötig                |
| usage_count          | Nutzungsanzahl       | Integer greater than 1             | 1                 | Nein       | Nur gültig bei relate_type 3 (Gegenstands-Nutzung); speichert die Nutzungsanzahl des Gegenstands.                                                                                                                                                          |
| image_uris           | Bild-URIs        | List of URI strings                |                   | Nein       | Unterstützt lokale Datei-URIs (file://) oder Remote-Web-Bilder (http/https). Unterstützt Arrays (z. B. &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Aktualisierungsmodus       | APPEND or REPLACE | REPLACE           | Nein       | Nur gültig beim Aktualisieren eines bestehenden Eintrags mit image_uris.<br/>APPEND: An bestehende Bilder anhängen.<br/>REPLACE: Bestehende Bilder ersetzen (Standard).                                                               |
    
**Hinweis:**

1. Wenn der Parameter `id` gesetzt ist, versucht die Methode, den entsprechenden Gefühls-Eintrag zu aktualisieren. Wird kein passender Eintrag gefunden, wird eine Ausnahme ausgelöst.
2. Ist `id` nicht gesetzt, aber `content` schon, erstellt die Methode einen neuen Gefühls-Eintrag.

<br/>

### Tomaten-Anzahl

?> Erfordert v1.98.0+

**Methodenname:** tomato

**Beschreibung:** Passt die Anzahl der Tomaten an (erhöhen, verringern oder auf einen bestimmten Wert setzen)

**Beispiele:**

- 1 Tomate hinzufügen: [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- 2 Tomaten entfernen: [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Pomodoro-Anzahl auf 10 setzen: [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Parameter | Bedeutung        | Werte                                        | Beispiel   | Erforderlich | Hinweise                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Operationstyp | One of:<br/>increase<br/>decrease<br/>set     | increase  | Nein       | increase - Pomodoros hinzufügen (Standard)<br/>decrease - Pomodoros entfernen<br/>set - Pomodoro-Anzahl auf Zielwert setzen |
| number    | Menge         | Integer                                       | 1         | Ja      | Bedeutung je nach action:<br/>increase/decrease - Hinzuzufügende/entfernte Menge<br/>set - Zielmenge |

**Antwort:**

| Feld    | Typ    | Beschreibung              | Beispiel |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Aktuelle Pomodoro-Anzahl   | 10      |

<br/>

### Gegenstand kaufen

?> Erfordert v1.98.0+

**Methodenname:** purchase_item

**Beschreibung:** Kauft einen bestimmten Gegenstand

**Beispiele:**

- Gegenstand mit ID 1 kaufen: [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Gegenstand „Health Potion“ kaufen: [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- 5 Exemplare des Gegenstands mit ID 1 kaufen: [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Hat der Gegenstand `purchase_limit` konfiguriert und `limit_scope` enthält `purchase`, wendet diese API diese Beschränkungen ebenfalls an.

| Parameter         | Bedeutung          | Werte                | Beispiel       | Erforderlich | Hinweise                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | Gegenstands-ID          | number greater than 0 | 1             | Nein*      | id oder name erforderlich |
| name              | Gegenstandsname        | any text              | Health Potion | Nein*      | id oder name erforderlich |
| purchase_quantity | Kaufmenge| number greater than 0 | 5             | Nein       | Standard 1              |

**Antwort:**

| Feld  | Typ    | Beschreibung        | Beispiel         | Hinweise                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | Gegenstands-ID            | 1               | Bei erfolgreichem Kauf zurückgegeben  |
| result | Integer | Ergebniscode        | 0               | Siehe Ergebniscodes unten      |
| desc   | Text    | Ergebnisbeschreibung | PurchaseSuccess | Siehe Ergebniscodes unten      |

**Ergebniscodes:**

| Code | Beschreibung               | Hinweise                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Kauf erfolgreich            |
| 1    | DatabaseError             | Datenbankfehler                |
| 2    | NotEnoughCoin             | Nicht genug Münzen              |
| 3    | ItemNotFound              | Gegenstand nicht gefunden                |
| 4    | PurchaseAndUseSuccess     | Kauf und Nutzung erfolgreich    |
| 5    | PurchaseSuccessAndUseFailure | Kauf erfolgreich, Nutzung fehlgeschlagen |
| 6    | NotPurchaseable           | Kauf durch Gegenstands-Einstellungen oder Beschränkungen blockiert |
| 7    | OutOfStock                | Shop-Bestand nicht ausreichend      |

<br/>

### Synthese

?> Erfordert v1.98.0+

**Methodenname:** synthesize

**Beschreibung:** Synthetisiert Gegenstände mit einer bestehenden Formel

**Beispiele:**

- Einmal mit Formel-ID 1 synthetisieren: [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- 5-mal mit Formel-ID 1 synthetisieren: [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Broadcast-Verhalten:**

- Diese API dient der **Rezept-Synthese**.
- Ist `Broadcast events` aktiviert und die Synthese gelingt, sendet LifeUp zusätzlich das Broadcast-Ereignis `app.lifeup.synthesis.complete`.
- Dieses Ereignis wird **nicht** für einfache Synthese innerhalb von `use_item` gesendet; dieser Pfad gehört weiterhin zu `app.lifeup.item.use`.

| Parameter | Bedeutung            | Werte                | Beispiel | Erforderlich | Hinweise                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | Formel-ID        | number greater than 0 | 1       | Ja      | ID der Synthese-Formel  |
| times     | Anzahl Durchläufe   | number greater than 0 | 5       | Nein       | Standard 1           |

**Antwort:**

| Feld           | Typ    | Beschreibung     | Beispiel          | Hinweise                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | Formel-ID      | 1                |                          |
| result         | Integer | Ergebniscode     | 0                | Siehe Ergebniscodes unten   |
| desc           | Text    | Ergebnisbeschreibung | SynthesisSuccess | Siehe Ergebniscodes unten |
| synthesisResults| Text   | Synthese-Ergebnisse | {...}           | Nur bei Erfolg zurückgegeben |

**Ergebniscodes:**

| Code | Beschreibung          | Hinweise                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Synthese erfolgreich  |
| 1    | FormulaNotFound     | Formel nicht gefunden     |
| 2    | InsufficientMaterials| Material nicht ausreichend |
| 3    | DatabaseError       | Datenbankfehler        |
| 4    | UnknownError        | Sonstige Fehler         |

<br/>

### Synthese-Formeln verwalten

?> Erfordert v1.98.0+

**Methodenname:** synthesis_formula

**Beschreibung:** Synthese-Formeln erstellen, ändern oder löschen

**Beispiele:**

- Neue Formel erstellen: [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Hier sind die inputItems `[{"item_id": 296, "amount": 88}]`
  - Hier sind die outputItems `[{"item_id": 295, "amount": 1}]`
- Formel löschen: [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Parameter   | Bedeutung        | Werte                | Beispiel                        | Erforderlich | Hinweise                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | Formel-ID     | number greater than 0 | 1                             | Nein       | Erforderlich zum Ändern oder Löschen  |
| delete      | Lösch-Flag    | true or false        | true                          | Nein       | Nur zum Löschen         |
| inputItems  | Eingabe-Gegenstände    | Item array, see below | [{"item_id":1,"amount":2}]     | Ja      | Erforderlich zum Erstellen oder Ändern  |
| outputItems | Ausgabe-Gegenstände   | Item array, see below | [{"item_id":3,"amount":1}]     | Ja      | Erforderlich zum Erstellen oder Ändern  |
| category    | Kategorie-ID    | number greater than 0 | 1                             | Nein       | Standard: allgemeine Kategorie    |

!> inputItems und outputItems sind JSON-Arrays, deren Elemente die Felder item_id und amount enthalten. Alle Gegenstands-IDs müssen existieren und amount muss größer als 0 sein

**Antwort:**

| Feld     | Typ    | Beschreibung      | Beispiel     | Hinweise                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | Formel-ID       | 1           | Bei Erfolg zurückgegeben      |
| result    | Integer | Ergebniscode      | 0           | Siehe Ergebniscodes unten   |
| desc      | Text    | Ergebnisbeschreibung | AddSuccess | Siehe Ergebniscodes unten   |

**Ergebniscodes:**

| Code | Beschreibung     | Hinweise             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Operation erfolgreich |
| 1    | Failed         | Operation fehlgeschlagen  |

<br/>

### Unteraufgaben-Verwaltung

?> Erfordert v1.98.0+

**Methodenname:** subtask

**Beschreibung:** Unteraufgaben erstellen oder bearbeiten

**Beispiele:**

- Unteraufgabe zur Hauptaufgabe mit ID 1 hinzufügen: [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Unteraufgabe bearbeiten und Belohnungen setzen: [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Parameter     | Bedeutung            | Werte                | Beispiel    | Erforderlich | Hinweise                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | Hauptaufgaben-ID       | number greater than 0 | 1         | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| main_gid     | Hauptaufgaben-Gruppen-ID | number greater than 0 | 1         | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| main_name    | Name der Hauptaufgabe     | any text             | Study task | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| edit_id      | Zu bearbeitende Unteraufgaben-ID | number greater than 0 | 2         | Nein*      | Beim Bearbeiten einer von edit_id, edit_gid oder edit_name erforderlich; beim Erstellen nicht nötig |
| edit_gid     | Unteraufgaben-Gruppen-ID   | number greater than 0 | 2         | Nein*      | Beim Bearbeiten einer von edit_id, edit_gid oder edit_name erforderlich; beim Erstellen nicht nötig |
| edit_name    | Name der Unteraufgabe       | any text             | Do homework| Nein*      | Beim Bearbeiten einer von edit_id, edit_gid oder edit_name erforderlich; beim Erstellen nicht nötig |
| todo         | Aufgabeninhalt       | any text             | Do homework| Nein       | Erforderlich beim Erstellen einer neuen Unteraufgabe |
| remind_time  | Erinnerungszeit      | timestamp (milliseconds)| 1640995200000 | Nein | null übergeben, um Erinnerung zu löschen    |
| order        | Reihenfolge              | integer              | 1          | Nein       | Position in der Aufgabenliste           |
| coin         | Münz-Belohnung        | [0, 999999]         | 10         | Nein       | Münzen bei Abschluss    |
| coin_var     | Münz-Varianz      | integer              | 5          | Nein       | Zufällige Schwankung der Münz-Belohnung  |
| exp          | Erfahrungs-Belohnung  | [0, 99999]          | 5          | Nein       | Gewährte Erfahrungspunkte        |
| auto_use_item| Gegenstand automatisch nutzen      | true or false        | true       | Nein       | Gegenstand bei Abschluss automatisch nutzen |
| item_id      | Gegenstands-ID            | number greater than 0 | 1         | Nein*      | item_id oder item_name erforderlich |
| item_name    | Gegenstandsname          | any text             | Health Potion| Nein*    | item_id oder item_name erforderlich |
| item_amount  | Gegenstandsmenge        | number greater than 0 | 1         | Nein       | Nur gültig beim Setzen einer Gegenstands-Belohnung |
| items        | Gegenstände-JSON         | JSON text            | [{"item_id":1,"amount":1}] | Nein | Mehrere Gegenstands-Belohnungen auf einmal setzen |
| coin_set_type     | Münzwert setzen | One of:<br/>absolute<br/>relative | absolute | Nein | absolute - Münzen direkt auf Wert setzen<br/>relative - vom ursprünglichen Münzwert addieren/subtrahieren |
| exp_set_type      | exp-Wert setzen | One of:<br/>absolute<br/>relative | absolute | Nein | absolute - exp direkt auf Wert setzen<br/>relative - vom ursprünglichen exp-Wert addieren/subtrahieren |

**Antwort:**

| Feld        | Typ    | Beschreibung      | Beispiel | Hinweise            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Hauptaufgaben-ID     | 1       |                  |
| subtask_id   | Number  | Unteraufgaben-ID       | 2       |                  |
| subtask_gid  | Number  | Unteraufgaben-Gruppen-ID | 3       | Kann leer sein     |

<br/>

### Kategorieverwaltung

?> Erfordert v1.98.0+

**Methodenname:** category

**Beschreibung:** Kategorien hinzufügen oder bearbeiten (Aufgabenlisten, Erfolgslisten, Shop-Listen, Synthese-Listen)

**Beispiele:**

- Aufgabenliste erstellen: [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Shop-Liste bearbeiten: [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Parameter        | Bedeutung           | Werte               | Beispiel    | Erforderlich | Hinweise                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Kategorietyp     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Ja | tasks - Aufgabenlisten<br/>achievements - Erfolgslisten<br/>shop - Shop-Listen<br/>synthesis - Synthese-Listen |
| edit_id         | Zu bearbeitende Kategorie-ID| number greater than 0| 1         | Nein       | Beim Bearbeiten erforderlich           |
| name            | Kategoriename     | any text             | Study List | Nein       | Für neue Kategorien erforderlich; beim Bearbeiten optional |
| order           | Sortierreihenfolge        | integer              | 1         | Nein       | Position in der Liste            |
| hidden          | Kategorie ausblenden     | true or false        | false     | Nein       | tasks=Archiv; shop=Shop ausblenden; synthesis=ausblenden. Erfolgslisten und die Synthese-ALL-Liste lehnen mit `unsupported_parameter` ab. `false` blendet wieder ein |
| inventory_hidden| Im Inventar ausblenden | true or false        | false     | Nein       | Nur für Shop-Listen   |
| icon_uri        | Icon-URI          | emoji, http(s) URL, content URI, or empty | 🏆 | Nein | Nur für Erfolgslisten. Emoji wird als `emoji_*.webp` gespeichert. Leer löscht. |
| desc            | Beschreibung       | any text             | This is a description | Nein | Nur für Erfolgslisten |
| color           | Tag-Farbe         | color string         | #66CCFF   | Nein       | Nur für Aufgabenlisten; # muss als %23 escaped werden |

**Antwort:**

| Feld | Typ    | Beschreibung    | Beispiel | Hinweise                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | Kategorie-ID    | 1000    | ID der neuen oder bearbeiteten Kategorie |

<br/>

### Backup exportieren

?> Erfordert v1.98.0+

**Methodenname:** export_backup

**Beschreibung:** Erstellt eine Backup-Datei und gibt deren URI zurück (nur Content-Provider-Aufrufe)

!> Diese API kann nur über Content Provider aufgerufen werden; direkte URL-Scheme-Aufrufe werden nicht unterstützt

| Parameter      | Bedeutung        | Werte          | Beispiel | Erforderlich | Hinweise                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Mediendateien einschließen | true or false | true    | Nein       | Ob Mediendateien (Bilder, Soundeffekte usw.) im Backup enthalten sind<br/>Standard true |
| callingPackage| Paketname des Aufrufers | any text      | com.example.app | Nein | Paketkennung für Content-Provider-Aufrufe |

**Antwort:**

| Feld          | Typ   | Beschreibung          | Beispiel                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI der Backup-Datei      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Unteraufgaben-Operation

?> Erfordert v1.98.0+

**Methodenname:** subtask_operation

**Beschreibung:** Unteraufgaben abschließen, Abschluss rückgängig machen oder löschen

**Beispiele:**

- Unteraufgabe abschließen: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Unteraufgabe löschen: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Abschluss einer Unteraufgabe rückgängig machen: [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Parameter     | Bedeutung          | Werte               | Beispiel    | Erforderlich | Hinweise                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | Hauptaufgaben-ID     | number greater than 0| 1         | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| main_gid     | Hauptaufgaben-Gruppen-ID| number greater than 0| 1        | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| main_name    | Name der Hauptaufgabe   | any text            | Study task | Nein*      | Einer von main_id, main_gid oder main_name erforderlich |
| edit_id      | Unteraufgaben-ID       | number greater than 0| 2         | Nein*      | Einer von edit_id, edit_gid oder edit_name erforderlich |
| edit_gid     | Unteraufgaben-Gruppen-ID | number greater than 0| 2         | Nein*      | Einer von edit_id, edit_gid oder edit_name erforderlich |
| edit_name    | Name der Unteraufgabe     | any text            | Do homework| Nein*      | Einer von edit_id, edit_gid oder edit_name erforderlich |
| operation    | Operationstyp   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Ja | complete - Aufgabe abschließen<br/>undo_complete - Abschluss rückgängig<br/>delete - Aufgabe löschen |

**Antwort:**

| Feld        | Typ    | Beschreibung      | Beispiel | Hinweise            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | Hauptaufgaben-ID     | 1       |                  |
| subtask_id   | Number  | Unteraufgaben-ID       | 2       |                  |
| subtask_gid  | Number  | Unteraufgaben-Gruppen-ID | 3       | Kann leer sein     |

<br/>

### Erfolgs-Verwaltung

?> Erfordert v1.98.0+

**Methodenname:** achievement

**Beschreibung:** Benutzerdefinierte Erfolge und Erfolgs-Unterkategorien hinzufügen oder bearbeiten

**Beispiele:**

- Erfolg erstellen: [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Für Tests ggf. `category_id` durch die tatsächlich verfügbare Erfolgslisten-ID ersetzen
- Erfolg mit Freischaltbedingungen erstellen: [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Für Tests ggf. `category_id` durch die tatsächlich verfügbare Erfolgslisten-ID ersetzen
  - Der dekodierte Inhalt von `conditions_json` ist `[{"type":7,"target":1000000}]`
- Bestehenden Erfolg bearbeiten: [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Erfolgs-Parameter

| Parameter      | Bedeutung           | Werte               | Beispiel   | Erforderlich | Hinweise                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | Zu bearbeitende Erfolgs-ID | number greater than 0 | 1      | Nein       | Beim Bearbeiten erforderlich          |
| is_subcategory| Ist Unterkategorie    | true or false        | false     | Nein       | Standard false               |
| name          | Erfolgsname   | any text             | Collector | Nein*      | Für neue Erfolge erforderlich   |
| desc          | Beschreibung       | any text             | Collect 100 items | Nein |                               |
| icon_uri      | Icon              | emoji, http(s) URL, content URI, or empty | 🏆 | Nein | Nicht `icon`. Emoji wird als `emoji_`-Datei gespeichert. Leer löscht. |
| order         | Sortierreihenfolge        | integer              | 1         | Nein       | Position in der Liste                |
| category_id   | Kategorie-ID       | number greater than 0 | 1        | Nein*      | Beim Erstellen einer Unterkategorie erforderlich |
| unlocked      | Freischaltstatus     | true or false        | true      | Nein       | true - sofort freischalten<br/>false - auf gesperrt zurücksetzen |
| unlock_time   | Freischaltzeit       | timestamp (milliseconds) | 1640995200000 | Nein | Nur wirksam, wenn bereits freigeschaltet |
| delete        | Lösch-Flag       | true or false        | false     | Nein       |                                |
| secret        | Versteckter Erfolg| true or false        | false     | Nein       |                                |
| write_feeling | Gefühle aufzeichnen   | true or false        | false     | Nein       |                                |
| color         | Titelfarbe       | color string         | #66CCFF   | Nein       | # muss als %23 escaped werden        |
| auto_use_item | Gegenstand automatisch nutzen     | true or false        | false     | Nein       |                                |
| skills        | Fähigkeiten-IDs         | array of numbers greater than 0 | 1 | Nein    | Unterstützt Arrays (z. B. &skills=1&skills=2) |
| exp           | Erfahrungs-Belohnung | integer              | 100       | Nein       |                                |
| item_id       | Gegenstands-ID           | number greater than 0 | 1        | Nein*      | item_id oder item_name erforderlich |
| item_name     | Gegenstandsname         | any text             | Treasure  | Nein*      | item_id oder item_name erforderlich |
| item_amount   | Gegenstandsmenge     | [1, 99]             | 1         | Nein       | Standard 1                   |
| items         | Gegenstands-Belohnungen JSON | JSON text            | [{"item_id":1,"amount":2}] | Nein | Mehrere Gegenstands-Belohnungen setzen; Format siehe unten |
| conditions_json| Freischaltbedingungen JSON | JSON text      | [{"type":7,"target":1000000}] | Nein | Freischaltbedingungen setzen; Format siehe unten |
| coin         | Münz-Belohnung       | [0, 999999]      | 10         | Nein       | Münzen beim Freischalten des Erfolgs |
| coin_var     | Schwankung der Münz-Belohnung | integer              | 5          | Nein       | Schwankungsbereich für Münz-Belohnungen |
| coin_set_type| Münzwert setzen | One of:<br/>absolute<br/>relative | absolute | Nein | absolute - Münzen direkt auf Wert setzen<br/>relative - vom ursprünglichen Münzwert addieren/subtrahieren |
| exp_set_type | exp-Wert setzen | One of:<br/>absolute<br/>relative | absolute | Nein | absolute - exp direkt auf Wert setzen<br/>relative - vom ursprünglichen exp-Wert addieren/subtrahieren |

**Antwort:**

| Feld  | Typ    | Beschreibung      | Beispiel | Hinweise                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Erfolgs-ID   | 1000    | ID des neuen oder bearbeiteten Erfolgs |

#### 2. Unterkategorie-Parameter

| Parameter     | Bedeutung           | Werte               | Beispiel   | Erforderlich | Hinweise                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | Einklapp-Status   | true or false        | false     | Nein       | Gilt nur für Unterkategorien   |

Unterkategorien lehnen `icon_uri` (einschließlich Emoji) mit `unsupported_parameter` ab. Bearbeiten einer Unterkategorie ohne `is_subcategory=true` liefert `is_subcategory_required`.
**Antwort:**

| Feld  | Typ    | Beschreibung      | Beispiel | Hinweise                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | Erfolgs-ID   | 1000    | ID des neuen oder bearbeiteten Erfolgs (Unterkategorie) |

#### 3. Freischaltbedingungs-Typen

| Typ-Code | Beschreibung             | Erfordert related_id | related_id-Typ | target-Beschreibung  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Anzahl Aufgabenabschlüsse   | Ja                | Aufgaben-ID         | Anzahl Abschlüsse |
| 1         | Aufgaben-Abschluss-Serie  | Ja                | Aufgaben-ID         | Serienlänge       |
| 3         | Pomodoro-Anzahl         | Nein                 | -               | Anzahl Pomodoros |
| 4         | Tage mit LifeUp      | Nein                 | -               | Anzahl Tage     |
| 5         | Like-Anzahl             | Nein                 | -               | Anzahl Likes    |
| 6         | Tägliche Abschluss-Serie | Nein                 | -               | Serientage        |
| 7         | Aktuelle Münzen          | Nein                 | -               | Münzmenge    |
| 8         | Münzen an einem Tag verdient| Nein                 | -               | Münzmenge    |
| 9         | Pomodoro-Anzahl einer Aufgabe    | Ja                | Aufgaben-ID         | Anzahl Pomodoros |
| 10        | Gegenstands-Kaufanzahl    | Ja                | Gegenstands-ID         | Kaufanzahl     |
| 11        | Gegenstands-Nutzungsanzahl       | Ja                | Gegenstands-ID         | Nutzungsanzahl        |
| 12        | Lootbox-Gegenstands-Anzahl    | Ja                | Gegenstands-ID         | Erhaltene Anzahl     |
| 13        | Fähigkeiten-Stufe erreicht    | Ja                | Fähigkeiten-ID        | Stufenwert        |
| 14        | Lebens-Stufe            | Nein                 | -               | Stufenwert        |
| 15        | Gegenstände insgesamt erhalten   | Ja                | Gegenstands-ID         | Gesamt-Erhaltungsanzahl |
| 16        | Gegenstände durch Synthese   | Ja                | Gegenstands-ID         | Synthese-Anzahl    |
| 17        | Aktuelle Gegenstandsmenge  | Ja                | Gegenstands-ID         | Besitzanzahl          |
| 18        | Fokus-Dauer einer Aufgabe    | Ja                | Aufgaben-ID         | Dauer (Minuten) |
| 19        | ATM-Ersparnisse           | Nein                 | -               | Sparbetrag     |
| 20        | Externe API          | Nein                 | -               | API-definiert        |
| 520       | N verschiedene Aufgaben täglich abschließen | Nein         | -               | Anzahl verschiedener Aufgaben (dedupliziert nach Gruppen-ID; bestehender Typ) |
| 524       | N Aufgabenabschlüsse täglich | Nein       | -               | Gesamtzahl gültiger Abschlüsse an einem Tag (v1.104.4+) |

> Ab v1.104.4 gelten für die Typen `520` und `524` folgende Semantik:
>
> - Beide teilen dieselbe Abschlussdefinition und die lokale Kalendertags-Grenze (`TimeRange.today()`).
> - Normale Aufgaben zählen `COMPLETED`; negative Aufgaben zählen `GIVE_UP`.
> - Typ `520` dedupliziert nach effektiver `groupId` (fällt auf Aufgaben-Datensatz-ID zurück, wenn Gruppen-ID fehlt). Mehrfaches Abschließen derselben unbegrenzten Aufgabe an einem Tag zählt weiterhin als 1 verschiedene Aufgabe.
> - Typ `524` zählt jede gültige Abschlusszeile. 5-maliges Abschließen derselben unbegrenzten Aufgabe ergibt `completionCount = 5`.
> - Bestehende Erfolge mit `type=520` behalten die Semantik „verschiedene Aufgaben“; keine Migration nötig.

#### 4. JSON-Formatspezifikationen

##### Freischaltbedingungen (conditions_json)

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

##### Gegenstands-Belohnungen (items)

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

### Fähigkeiten-Verwaltung

?> Erfordert v1.98.0+

**Methodenname:** skill

**Beschreibung:** Benutzerdefinierte Fähigkeiten (Attribute) erstellen oder bearbeiten

**Beispiele:**

- Fähigkeit erstellen: [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Fähigkeiten-Erfahrung bearbeiten: [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Fähigkeit löschen: [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Parameter    | Bedeutung           | Werte               | Beispiel    | Erforderlich | Hinweise                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | Fähigkeiten-ID          | number greater than 0 | 1         | Nein       | Beim Bearbeiten erforderlich           |
| content     | Fähigkeitenname        | any text             | Programming| Nein*      | Für neue Fähigkeiten erforderlich         |
| desc        | Beschreibung       | any text             | Coding ability | Nein    |                                |
| icon        | Icon              | any text             | 💻         | Nein       | Emoji möglich                   |
| color       | Farbe             | color string         | #FF6B6B    | Nein       | # muss als %23 escaped werden        |
| type        | Typ              | integer              | 0          | Nein       |                                |
| order       | Sortierreihenfolge        | integer              | 1          | Nein       | Rohe Position in der gemischten Liste. Allein genutzt wird die Fähigkeit an diese Position gesetzt und die finale Gruppe aus dem Layout abgeleitet; mit `group_id` wird auf die nächste gültige Position in der Zielgruppe geschnappt |
| group_id    | Fähigkeitengruppen-ID    | integer              | 10         | Nein       | Erfordert v1.103.0+; darf nicht kleiner als `0` sein; nur `0` verschiebt die Fähigkeit in den ungruppierten Bereich. Allein: neue Fähigkeiten ans Gruppenende; bearbeitete behalten ihre Position in der Gruppe, sonst ans Gruppenende; mit `order` hat `group_id` Vorrang |
| status      | Status            | integer              | 0          | Nein       |                                |
| exp         | Erfahrungspunkte | number greater than or equal to 0 | 100 | Nein | Aktuelle Fähigkeiten-Erfahrung        |
| delete      | Lösch-Flag       | true or false        | false      | Nein       | Nur beim Bearbeiten gültig         |

**Antwort:**

| Feld  | Typ    | Beschreibung    | Beispiel | Hinweise                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | Fähigkeiten-ID       | 1000    | ID der neuen oder bearbeiteten Fähigkeit |

<br/>

### Fähigkeitengruppen-Verwaltung :id=skill_group_management

Erfordert v1.103.0+

**Methodenname:** skill_group

**Beschreibung:** Fähigkeitengruppen erstellen, bearbeiten, löschen oder neu sortieren. Die Sortier-API unterstützt auch gemischte Sortierung von Gruppen und Fähigkeiten.

**Beispiele:**

- Gruppe erstellen: [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Gruppe bearbeiten: [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Gruppe löschen: [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Gruppen und Fähigkeiten gemeinsam sortieren:

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Parameter | Bedeutung | Werte | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | Fähigkeitengruppen-ID | number greater than 0 | 10 | Nein* | Beim Bearbeiten oder Löschen erforderlich |
| content | Gruppenname | any text | Combat | Nein* | Beim Erstellen erforderlich |
| order | Sortierreihenfolge | integer | 20 | Nein | Roher `orderInCategory`-Wert; muss in der gemischten Fähigkeiten-/Gruppenliste eindeutig sein |
| collapsed | Einklapp-Status | true or false | true | Nein | Ob die Gruppe eingeklappt ist |
| delete | Lösch-Flag | true or false | false | Nein | Nur beim Bearbeiten gültig |
| sort_json | Gemischte Sortierknoten | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | Nein* | Wenn gesetzt, werden CRUD-Parameter ignoriert und der gemischte Sortierplan angewendet. Teilweise Sortierung möglich: nicht angegebene Knoten behalten ihre relative Reihenfolge |

Format der `sort_json`-Knoten:

| Feld | Bedeutung | Werte |
| ----- | ------- | ------ |
| type | Knotentyp | `skill` / `group` |
| id | Entitäts-ID | number greater than 0 |

**Antwort:**

| Feld | Typ | Beschreibung | Beispiel | Hinweise |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | Fähigkeitengruppen-ID | 10 | Bei create / edit / delete zurückgegeben |
| count | Number | Anzahl sortierter Knoten | 3 | Bei `sort_json`-Anfragen zurückgegeben |

<br/>

### App-Einstellungen

?> Erfordert v1.98.0+

**Methodenname:** app_settings

**Beschreibung:** App-Oberflächeneinstellungen anpassen

**Beispiele:**

- Kompaktmodus aktivieren: [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Material-You-Thema aktivieren: [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Einstellungen ändern und UI sofort neu starten: [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Parameter              | Bedeutung           | Werte          | Beispiel | Erforderlich | Hinweise                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Kompaktmodus aktivieren| true or false  | true    | Nein       | Oberflächenelemente vereinfachen     |
| is_enable_material_you| Material You aktivieren| true or false  | true    | Nein       | Material-You-Thema aktivieren       |
| restart_activities    | Oberfläche neu starten | true or false   | true    | Nein       | Oberflächenänderungen sofort anwenden |
| broadcast_event | LifeUp-Labs-Broadcast-Ereignisse | true or false | true | Nein | Standard aus. Gleicher Schalter wie Einstellungen → Labs |

**Antwort:**

| Feld  | Typ    | Beschreibung  | Beispiel | Hinweise                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Ergebniscode  | 0       | 0 bedeutet Erfolg      |

<br/>

### Einfache Abfrage

!> Die Funktionen hier sind für Automatisierungstools und Sekundärentwicklung gedacht. Wenn du eine vollständige Datenliste abfragen musst, siehe [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) und [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Methodenname:** query

**Beschreibung:** Abfrageparameter

**Beispiel:** - Aktuelle Münzanzahl abfragen: [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Broadcast-Ereignis-Schalter abfragen: [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Parameter   | Bedeutung              | Typ                                                         | Beispiel | Erforderlich                                    | Hinweise                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | Abfragetyp        | Nur einer der folgenden Werte:<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | ja                                         | coin – aktuelle Münzanzahl<br/>atm – aktueller ATM-Saldo<br/>item – Gegenstandsinformationen für die angegebene `itemId`<br/>item_id_list – Liste der Gegenstands-IDs, angegeben durch `categoryId`<br/>tomato – Tomaten-Daten<br/>task – Aufgabeninformationen (v1.101.0+)<br/>broadcast – Labs-Broadcast-Ereignis-Schalter (`{enabled}`) |
| item_id     | Gegenstands-ID   | Zahl größer als 0                                      | 1       | Wenn key `item` ist, erforderlich |                                                              |
| category_id | Shop-Kategorie-ID | Zahl größer oder gleich 0                            | 0       | nein*                                         | Nur erforderlich, wenn key `item_id_list` ist; ID der abzufragenden Liste. |
| task_id / taskId | Aufgaben-ID          | Zahl größer als 0                                        | 1       | Wenn key `task` ist, eine von drei* erforderlich | Abgefragte Aufgaben-ID |
| task_gid / taskGid / task_group_id / taskGroupId | Aufgabengruppen-ID | Zahl größer als 0 | 1 | Wenn key `task` ist, eine von drei* erforderlich | Abgefragte Aufgabengruppen-ID |
| task_name / taskName | Aufgabenname      | Beliebiger Text                                                     | Study   | Wenn key `task` ist, eine von drei* erforderlich | Unscharf abgeglichener Aufgabenname |
| withSubTasks | Unteraufgaben einschließen   | true or false                                                | true    | Nein                                          | Nur verfügbar, wenn key `task` ist; Standard ist true |

**Rückgabewert:**

Nur ab Version 1.90.2 unterstützt

Bei Abfrage von coin/atm:

| Parameter | Bedeutung                             | Typ               | Beispiel | Erforderlich | Hinweise |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Von der Abfrage zurückgegebener numerischer Wert | number             | 1000    | ja      |       |

Bei Abfrage eines Gegenstands:

| Parameter        | Bedeutung                         | Typ     | Beispiel   | Erforderlich | Hinweise |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | Gegenstands-ID              | number   | 1         | ja      |       |
| name             | Gegenstandsname            | any text | Coffee    | ja      |       |
| desc             | Beschreibung                     | any text |           | nein       |       |
| icon             | Icon-URL                        | any text | icon.webp | nein       | Bei lokaler Datei wird nur der Dateiname zurückgegeben |
| category_id      | Kategorie-Daten-ID                | number   | 1         | ja      |       |
| stock_number     | Shop-Bestand             | number   | -1        | ja      | `-1` steht für unbegrenzten Shop-Bestand |
| own_number       | Besitz im Inventar | number   | 10        | ja      |       |
| price            | Preis                       | number   | 100       | ja      |       |
| order            | Sortierung                         | number   | 100       | ja      | Gewichtungswert bei benutzerdefinierter Sortierung |
| disable_purchase | Kauf deaktivieren     | true or false | true | ja |       |
| purchase_limit   | Einschränkungsregeln               | JSON text | [{"limitType":0,"limitNumber":5}] | ja | Aktuelle Einschränkungsliste |
| limit_scope      | Einschränkungsbereich               | purchase / use / both | use | ja | Als API-Textwert zurückgegeben |

Bei Abfrage von item_id_list:

| Parameter | Bedeutung                           | Typ   | Beispiel | Erforderlich | Hinweise |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Kommagetrenntes Gegenstands-ID-Array     | string | 1,2,3,4 | ja      |       |

Bei Abfrage von tomato:

| Parameter | Bedeutung                  | Typ   | Beispiel | Erforderlich | Hinweise |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Tomaten gesamt       | number | 100     | ja      |       |
| available | Verfügbare Tomaten   | number | 50      | ja      |       |
| exchanged | Eingetauschte Tomaten   | number | 50      | ja      |       |

Bei Abfrage von task (v1.101.0+):

| Parameter   | Bedeutung                      | Typ        | Beispiel | Erforderlich | Hinweise                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | Aufgaben-ID                      | number      | 1       | ja      | -                               |
| _GID        | Aufgabengruppen-ID                | number      | 1       | ja      | -                               |
| name        | Aufgabenname                    | text        | Study   | ja      | -                               |
| notes       | Notizen                        | text        | -       | nein       | Kann leer sein                    |
| status      | Aufgabenstatus                  | number      | 0       | ja      | 0=unvollständig, 1=abgeschlossen       |
| startTime   | Startzeit                   | number      | -       | ja      | Unix-Zeitstempel (Millisekunden)   |
| deadline    | Frist                | number      | -       | nein       | Unix-Zeitstempel (Millisekunden), kann leer sein |
| remindTime  | Erinnerungszeit                  | number      | -       | nein       | Unix-Zeitstempel (Millisekunden), kann leer sein |
| frequency   | Wiederholungsfrequenz         | number      | -       | ja      | -                               |
| weekdays    | Wochentage                     | text        | 1,3,5   | nein       | v1.106.0+; leer, wenn kein Wochentagsmodus. 1=Montag … 7=Sonntag |
| exp         | Erfahrungspunkte-Belohnung                   | number      | -       | ja      | -                               |
| skillIds    | Fähigkeiten-ID-Liste                | JSON text   | -       | ja      | JSON-Array-Format               |
| coin        | Münzbelohnung                  | number      | -       | nein       | Kann leer sein                    |
| coinVariable| Zufällige Münzbelohnung           | number      | -       | nein       | Kann leer sein                    |
| itemId      | Erste Belohnungs-Gegenstands-ID         | number      | -       | nein       | Kann leer sein                    |
| itemCount   | Anzahl der ersten Belohnungs-Gegenstände      | number      | -       | nein       | Wird zurückgegeben, wenn itemId vorhanden ist     |
| items       | Gegenstands-Belohnungsliste             | JSON text   | -       | ja      | JSON-Array-Format               |
| words       | Abschluss-Motivationsworte   | text        | -       | nein       | Kann leer sein                    |
| categoryId  | Kategorie-ID                  | number      | -       | nein       | Kann leer sein                    |
| order       | Reihenfolge                        | number      | -       | ja      | -                               |
| name_extended | Erweiterter Name              | text        | -       | ja      | Identisch mit name                    |
| subTasks    | Unteraufgaben-Liste                | JSON text   | -       | ja      | JSON-Array-Format, siehe unten    |

**Unteraufgaben (subTasks) – Feldbeschreibung:**

Das Feld `subTasks` ist ein JSON-Array; jedes Element enthält folgende Felder:

- `id`: Unteraufgaben-ID
- `gid`: Unteraufgaben-Gruppen-ID
- `todo`: Unteraufgaben-Inhalt
- `status`: Unteraufgaben-Status (0=unvollständig, 1=abgeschlossen)
- `remindTime`: Erinnerungszeit (Unix-Zeitstempel, Millisekunden)
- `exp`: Erfahrungspunkte-Belohnung
- `coin`: Münzbelohnung
- `coinVariable`: Zufällige Münzbelohnung
- `items`: Gegenstands-Belohnungsliste
- `order`: Reihenfolge
- `autoUseItem`: Gegenstand automatisch verwenden

<br/>

### Attribute abfragen :id=query_skill

!> Die Funktionen hier sind für Automatisierungstools und Sekundärentwicklung gedacht.

**Methodenname:** query_skill

**Beschreibung:** Grundinformationen, rohe Sortierfelder sowie Stufen- und Erfahrungsdaten einer angegebenen Fähigkeit abfragen.

Mit dieser API kannst du eigene Attribute-Widgets anpassen.

**Beispiel:**

- Attribut Stärke abfragen: [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Parameter | Bedeutung              | Typ                    | Beispiel | Erforderlich | Hinweise |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | Attribut- (Fähigkeiten-)ID | Zahl größer als 0 | 1       | ja      | Zur Ermittlung siehe oben „Grundlagen – LifeUp-Daten-ID“ |

**Rückgabewert:**

Nur ab Version 1.90.6 unterstützt

| Parameter            | Bedeutung                              | Typ   | Beispiel  | Erforderlich | Hinweise |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | Fähigkeiten-ID                             | number | 1        | ja      | In `query_skill` ab v1.103.0+ hinzugefügt |
| name                 | Attributname                       | string | strength | ja      |       |
| order                | Rohe Sortierreihenfolge                       | number | 20       | ja      | Ab v1.103.0+ hinzugefügt; `orderInCategory` |
| group_id             | Fähigkeitengruppen-ID                       | number | 10       | ja      | Ab v1.103.0+ hinzugefügt; gibt `0` zurück, wenn die Fähigkeit in keiner Gruppe ist |
| status               | Status                               | number | 0        | ja      | Ab v1.103.0+ hinzugefügt; `0` = normal, `1` = ausgeblendet |
| level                | Stufe                                | number | 10       | ja      |       |
| total_exp            | Erfahrungspunkte gesamt              | number | 10000    | ja      |       |
| until_next_level_exp | Erfahrungspunkte bis zur nächsten Stufe | number | 99       | ja      |       |
| current_level_exp    | Erfahrungspunkte über der aktuellen Stufe       | Number | 1000     | Ja      |       |

<br/>

### Fähigkeitengruppe abfragen :id=query_skill_group

Erfordert v1.103.0+

**Methodenname:** query_skill_group

**Beschreibung:** Eine einzelne Fähigkeitengruppe abfragen und deren rohe Sortierung sowie Einklapp-Status zurückgeben.

**Beispiel:**

- Fähigkeitengruppe abfragen: [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Fähigkeitengruppen-ID | number greater than 0 | 10 | ja | - |

**Rückgabewert:**

| Parameter | Bedeutung | Typ | Beispiel | Erforderlich | Hinweise |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | Fähigkeitengruppen-ID | number | 10 | ja | - |
| content | Gruppenname | string | Combat | ja | - |
| order | Rohe Sortierreihenfolge | number | 20 | ja | `orderInCategory` |
| collapsed | Einklapp-Status | string | true | ja | Als `true` / `false`-Text zurückgegeben |

<br/>

<br/>

### Spezielle Schnittstellen

#### Zufall

?> Diese API wurde in v1.93.0 veröffentlicht.

**Methodenname:** random

**Beschreibung:** Einfache Zufallsschnittstelle, die zufällig eine von mehreren APIs auslösen kann.

**Beispiel:**

- Gleich wahrscheinlich zufällig `scissors`, `rock` oder `paper` anzeigen: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- 90 % Wahrscheinlichkeit für `rock`, 5 % für `scissors` und 5 % für `paper`: [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Parameter | Bedeutung    | Werte                 | Beispiel                                | Erforderlich | Hinweise |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | Zufalls-API | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Ja      | Unterstützt Aufruf als Array (mehrere api-Parameter, siehe Beispiele oben) |
| weight    | Gewichtung     | Numbers greater than 0 | 1                                      | Nein       | Unterstützt Aufruf als Array.<br/><br/>Ohne weight sind alle Gewichtungen gleich (gleiche Wahrscheinlichkeit).<br/>Mit weight werden sie nacheinander zugeordnet: z. B. das erste weight zum ersten api-Parameter.<br/><br/>**Stelle sicher, dass die Anzahl der weight-Parameter der Anzahl der api-Parameter entspricht, sonst greift es möglicherweise nicht.** |

<br/>

#### Bestätigungsdialog

**Methodenname:** confirm_dialog

**Beschreibung:** Ein Pop-up-Auswahlfenster erscheint. Titel, Text, positiver und negativer Button sind anpassbar. Beim Klick auf einen Button können weitere Schnittstellen aufgerufen werden.

**Beispiel:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Weitere Anwendungsfälle:
  - Belohnungsauswahl
  - Verzweigungsauswahl bei Ereignissen

| Parameter       | Bedeutung              | Typ     | Beispiel  | Erforderlich | Hinweise |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | Pop-up-Titel          | any text | Title    | ja      |       |
| message         | Detaillierte Beschreibung des Pop-up-Fensters | any text | This is the content of the popup window | nein |  |
| positive_text   | Text des positiven Buttons | any text | YES      | nein       |       |
| negative_text   | Text des negativen Buttons | any text | NO       | nein       |       |
| neutral_text    | Text des neutralen Buttons  | any text | QUESTION | nein       |       |
| positive_action | Link-Reaktion des positiven Buttons | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | nein | Entspricht dem escaped Text der Pop-up-Nachrichtenschnittstelle. Escape-Regeln siehe `Grundlagen – Escaping`. |
| negative_action | Link-Reaktion des negativen Buttons | URL (other interface) | Wie oben | nein |  |
| neutral_action  | Link-Reaktion des neutralen Buttons  | URL (other interface) | Wie oben | nein |  |
| cancel_action   | Link-Reaktion der Abbruchaktion   | URL (other interface) | Wie oben | nein |  |

<br/>

#### Keine Aktion

**Methodenname:** placeholder

**Hinweis:** Diese Schnittstelle führt selbst keine Logik aus, kann aber mit callback und broadcast kombiniert werden.

**Beispiel:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Variable Platzhalter

`LifeUp` bietet Methoden zur Benutzerintervention bei Parametern.

| Platzhalter                          | Bedeutung                                                      | Beispiel                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Textplatzhalter                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Zahlenplatzhalter (ohne Dezimalstelle)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Zahlenplatzhalter (ohne Dezimalstelle), Vorzeichen anzeigen        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Zahlenplatzhalter (mit Dezimalstelle)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Zahlenplatzhalter (mit Dezimalstelle), Vorzeichen anzeigen           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Gegenstand auswählen, wird durch Gegenstands-ID ersetzt              | [$item]                                                      |
| [$task_category]                     | Aufgabenliste auswählen, wird durch Aufgabenlisten-ID ersetzt    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Zeitplatzhalter<br/><br/>Mögliche Werte für Anchor Time:<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Offset in Millisekunden sollte eine Ganzzahl sein, Standard ist 0 Millisekunden | Mitternacht heute: [$time\|today]<br/>Mitternacht morgen: [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Zufallszahl-Platzhalter (ohne Dezimalstelle)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Zufallszahl-Platzhalter (mit Dezimalstelle)                | [$random_decimal\|1.0\|2.0]                                  |

**Beispiel 1: Bei Verwendung einen Gegenstand wählen, um den Preis um 1 Münze zu senken**

Wenn du z. B. die API zur Preissenkung eines bestimmten Shop-Gegenstands eingerichtet hast, kannst du dem Nutzer bei Aufruf die Auswahl des Gegenstands ermöglichen, statt die ID vorab festzulegen.

Die folgende API kann nur den Preis des Shop-Gegenstands mit ID 1 um 1 Münze senken:

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Du musst nur die Gegenstands-ID in den Platzhalter [$item] ändern; beim Aufruf kann der Nutzer aktiv den Gegenstand wählen, dessen Preis gesenkt werden soll:

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Beispiel 2: Aufgabenvorlage — nur Aufgabenname und Auswahlliste eingeben, um eine voreingestellte Belohnungsvorlage zu erstellen**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Abschluss-Callback

Du kannst allen Schnittstellen den callback-Parameter hinzufügen, um nach dem Aufruf eine URL zurückzurufen.

Damit lassen sich auch mehrere Schnittstellen verketten, z. B. wenn du nach dem Sprung eine Meldung anzeigen willst:

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Nutze den callback-Parameter. Siehe auch oben **Grundlagen – Escaping**. So kannst du es schreiben:

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Natürlich kannst du einem Shop-Gegenstand mehrere Links hinzufügen, um diesen Effekt zu erzielen.

Außerdem wird dieser Callback häufiger für Folgendes genutzt:

X-App → LifeUp → X-App

oder

X-App → LifeUp → Y-App

<br/>

#### Broadcast-Rückgabewert

!> Die Funktionen hier sind für Automatisierungstools und Sekundärentwicklung gedacht und haben eine gewisse Einstiegshürde.

Mit diesem Parameter kann der ursprüngliche Rückgabewert der API per Broadcast gesendet werden, sodass Automatisierungstools wie Tasker ihn empfangen können.

Der broadcast-Wert entspricht dem Wert in der Aktionsspalte von „Intent Received“ in Tasker. Du kannst beliebigen Text eintragen, solange beide übereinstimmen.

**Beispiel: Münzen per Tasker abfragen ([Bei MacroDroid siehe diesen Link.](https://github.com/Ayagikei/LifeUp/issues/43)):**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Füge den broadcast-Parameter hinzu, damit der Rückgabewert an Tasker gesendet wird — beliebiger Text, z. B. `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Ereignis in Tasker hinzufügen → „Intent Received“, in der Aktionsspalte `app.lifeup.query.coin` eintragen

3. Die Tasker-Aufgabe empfängt den Rückgabewert von `value` als Variable `%value`.

4. Dann kannst du in Tasker die Münzanzahl auswerten und verschiedene Effekte umsetzen. (Z. B. Desktop-Hintergrund je nach Münzanzahl ändern?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Broadcast-Ereignisbenachrichtigung

!> Die Funktionen hier sind für Automatisierungstools und Sekundärentwicklung gedacht.

> Ab Version 1.90.2 senden wir verschiedene Ereignisse nach außen. Mit Automatisierungstools wie Tasker kannst du diese Ereignisse empfangen und Tasker-Aktionen auslösen.
>
### Aktivieren

**Broadcast-Ereignisse sind standardmäßig deaktiviert.**

Du kannst sie unter `Einstellungen` → `Labs` → `Entwicklermodus` → `Broadcast events` aktivieren.

### Beispiel: Hintergrund mit einem Gegenstand wechseln

1. Erstelle einen neuen Gegenstand namens „Change Wallpaper“.
2. In Tasker: `Configuration file` → `Event` → `System` → `Intent Received`, in der Aktionsspalte `app.lifeup.item.use` eintragen und zurück.
3. „New Task“ wählen und einen beliebigen Namen eingeben (z. B. change wallpaper).
4. Auf das +-Symbol unten rechts tippen, Aufgabe hinzufügen, `Task` → `If` wählen
5. Bedingungsspalte auf `%name eq change wallpaper` setzen.
6. Zurück, `Insert Action`, `If` wählen.
7. Erneut auf + tippen, Aufgabe hinzufügen, `Display` → `Set Wallpaper` wählen
8. (Optional) `Type` durch `All` ersetzen
9. In der Bildspalte auf 🔍 tippen und die gewünschte Hintergrunddatei wählen
10. Beenden und prüfen, ob diese Konfiguration aktiviert ist.
11. Den Gegenstand „Wallpaper Change“ in `LifeUp` verwenden — der Hintergrund sollte sich ändern

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Mit `Keine Aktion` + `Broadcast-Rückgabewert` lässt sich dieser Effekt kompakter umsetzen — probier es aus.

<br/>

### Aufgabe abgeschlossen

**Name:** app.lifeup.task.complete

**Rückgabewert:**

| Parameter  | Bedeutung          | Beispiele        |
| ----------- | ---------------- | --------------- |
| task_id     | Aufgaben-ID          | 1               |
| task_gid    | Aufgabengruppen-ID    | 1               |
| name        | Aufgabenname        | Getting started |
| category_id | Aufgabenkategorie-ID | 1               |

### Aufgabe aufgegeben

**Name:** app.lifeup.task.giveup

**Rückgabewert:**

| Parameter  | Bedeutung          | Beispiele        |
| ----------- | ---------------- | --------------- |
| task_id     | Aufgaben-ID          | 1               |
| task_gid    | Aufgabengruppen-ID    | 1               |
| name        | Aufgabenname        | Getting started |
| category_id | Aufgabenkategorie-ID | 1               |

### Aufgabe überfällig

**Name:** app.lifeup.task.overdue

**Rückgabewert:**

| Parameter | Bedeutung                 | Beispiele                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | Aufgaben-ID-**Array**       | [1, 2, 3]                       |
| task_gids  | Aufgabengruppen-ID-**Array** | [1, 2, 3]                       |
| names      | Aufgabenname-**Array**     | [Getting started, Drink Waters] |
| task_ids_json  | Aufgaben-ID-**Json-Array**   | [1, 2, 3]                       |
| task_gids_json | Aufgabengruppen-ID-**Json-Array** | [1, 2, 3]                       |
| names_json     | Aufgabenname-**Json-Array** | ["Getting started", "Drink Waters"]                      |

### Erfolg freigeschaltet

**Name:** app.lifeup.achievement.unlock

**Rückgabewert:**

| Parameter     | Bedeutung          | Beispiele                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | Erfolgs-ID   | 1                        |
| name           | Erfolgsname | Using LifeUp for 30 days |

### Gegenstand gekauft

**Name:** app.lifeup.item.purchase

**Rückgabewert:**

| Parameter | Bedeutung           | Beispiele          |
| ---------- | ----------------- | ----------------- |
| item_id    | Gegenstands-ID           | 1                 |
| name       | Gegenstandsname         | Break 10 branches |
| amount     | Kaufmenge | 1                 |

### Gegenstand verwendet

**Name:** app.lifeup.item.use

**Beschreibung:** Wird gesendet, wenn die normale Gegenstandsverwendung oder ein einfacher Synthese-Ablauf erfolgreich ist.

**Rückgabewert:**

| Parameter | Bedeutung      | Beispiele          |
| ---------- | ------------ | ----------------- |
| item_id    | Gegenstands-ID      | 1                 |
| name       | Gegenstandsname    | Break 10 branches |
| amount     | Verwendungsmenge | 1                 |

### Synthese abgeschlossen

> [!NOTE]
> Dieses Broadcast-Ereignis wurde in v1.102.8 veröffentlicht.

**Name:** app.lifeup.synthesis.complete

**Beschreibung:** Wird gesendet, wenn eine Rezept-Synthese erfolgreich abgeschlossen wurde.

**Rückgabewert:**

| Parameter   | Bedeutung                            | Beispiele                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | Rezept-ID                         | 1                                                     |
| formula_name | Rezeptname                       | Toolbox Recipe                                        |
| times        | Ausführungsanzahl                    | 3                                                     |
| input_count  | Anzahl der Eingabe-Gegenstandseinträge       | 2                                                     |
| output_count | Anzahl der Ausgabe-Gegenstandseinträge      | 1                                                     |
| inputs_json  | JSON-Array aller verbrauchten Eingaben  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | JSON-Array aller produzierten Ausgaben | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Hinweise:**

- Dieses Ereignis wird nur nach erfolgreicher Synthese gesendet.
- Bei unzureichenden Materialien, nicht vorhandenem Rezept, Speicherfehler oder deaktivierten `Broadcast events` wird dieses Ereignis nicht gesendet.
- Ein einzelner API-Aufruf sendet nur ein Ereignis, auch wenn `times > 1`.
- In `inputs_json` und `outputs_json` hat jeder Eintrag folgende Struktur:

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` ist die **gesamt verbrauchte / gesamt produzierte** Menge in dieser Ausführung, nicht die Menge pro Rezept.

### Gefühl hinzugefügt / aktualisiert

**Name:** app.lifeup.feelings.add

**Rückgabewert:**

| Parameter | Bedeutung | Beispiele |
| --- | --- | --- |
| feelings_id | Gefühls-ID | 1 |
| action_type | `add` or `update` | add |
| content | Gefühlstext | Feeling good today! |
| create_time | Erstellungszeitstempel (ms) | 1642060800000 |
| relate_type | Typ des verknüpften Objekts | 0 |
| related_id | ID des verknüpften Objekts | 1 |
| attachments_count | Anzahl der Anhänge | 2 |
| attachments | Array der Anhangspfade | ["/path/1", "/path/2"] |

### Stufe erhöht

**Name:** app.lifeup.level.up

**Rückgabewert:**

| Parameter | Bedeutung       | Beispiele |
| ---------- | ------------- | -------- |
| skill_id   | Aufgaben-ID       | 1        |
| name       | Name          | strength |
| level      | Aktuelle Stufe | 2        |

### Stufe verringert

**Name:** app.lifeup.level.down

**Rückgabewert:**

| Parameter | Bedeutung       | Beispiele |
| ---------- | ------------- | -------- |
| skill_id   | Aufgaben-ID       | 1        |
| name       | Name          | strength |
| level      | Aktuelle Stufe | 2        |

### Shop-Gegenstand-Countdown

**Name:**

- Start: app.lifeup.item.countdown.start
- Stop: app.lifeup.item.countdown.stop
- Complete: app.lifeup.item.countdown.complete

**Rückgabewert:**

| Parameter | Bedeutung                       | Beispiele                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | Gegenstands-ID                       | 1                         |
| name       | Gegenstandsname                     | play games for 30 minutes |
| time_left  | Verbleibende Zeit (Millisekunden) | 30000                     |

### Pomodoro-Lebenszyklus

?> Dieses Broadcast-Ereignis wurde in v1.101.0 veröffentlicht und liefert umfangreichere Ereignisdaten.

**Name:**

- Start: app.lifeup.pomodoro.start
- Pause: app.lifeup.pomodoro.pause (neu in v1.101.0)
- Stop: app.lifeup.pomodoro.stop
- Complete: app.lifeup.pomodoro.complete

**Beschreibung:** Wenn der Pomodoro-Timer startet, pausiert, stoppt oder abschließt, sendet das System entsprechende Broadcast-Ereignisse mit Aufgabeninformationen, Timing-Status und weiteren Details.

**Rückgabewert:**

| Parameter          | Bedeutung                       | Beispiel        | Hinweise                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | Aufgaben-ID                       | 1              | Optional, nur wenn Pomodoro mit einer Aufgabe verknüpft ist |
| task_gid           | Aufgabengruppen-ID                 | 1              | Optional, nur wenn Pomodoro mit einer Aufgabe verknüpft ist |
| name               | Aufgabenname                     | Study English  | Mit Pomodoro verknüpfter Aufgabenname oder benutzerdefinierter Name         |
| service_type       | Diensttyp                  | 0              | 0=Fokus, 1=kurze Pause, 2=lange Pause                      |
| service_type_label | Bezeichnung des Diensttyps            | Focus          | Lokalisierte Diensttyp-Bezeichnung                                |
| duration           | Gesamtdauer (Millisekunden) | 1500000        | Gesamtdauer von Fokus oder Pause                           |
| remaining          | Verbleibende Dauer (Millisekunden) | 900000     | Aktuell verbleibende Dauer                                 |
| elapsed            | Vergangene Dauer (Millisekunden) | 600000       | Bereits verstrichene Dauer                                           |
| start              | Startzeit                    | 1639123456789  | Unix-Zeitstempel (Millisekunden)                              |
| event_time         | Zeitpunkt des Ereignisauslösers            | 1639123456789  | Unix-Zeitstempel (Millisekunden)                              |
| reason             | Stoppgrund                   | user           | Nur beim Stop-Ereignis; mögliche Werte: manual, cancel, complete, auto |

**Beschreibung des Stoppgrunds:**

Der Parameter `reason` existiert nur im Ereignis `app.lifeup.pomodoro.stop` und gibt den Grund für den Pomodoro-Stopp an:

- `manual`: Nutzer hat manuell gestoppt
- `cancel`: Nutzer hat abgebrochen
- `complete`: Normal abgeschlossen (Hinweis: Bei Abschluss wird auch `app.lifeup.pomodoro.complete` ausgelöst)
- `auto`: Automatisch gestoppt (z. B. Aufgabe gelöscht)

### Positiver-Timer-Lebenszyklus :id=broadcast_positive_timing

> [!NOTE]
> Diese Ereignisse betreffen die Positive-Timer-Funktion, nicht die Pomodoro-Countdown-Ereignisse oben. Stelle vor der Nutzung sicher, dass `Einstellungen` → `Labs` → `Entwicklermodus` → `Broadcast events` aktiviert ist.

**Name:**

- Start: app.lifeup.timing.start
- Pause: app.lifeup.timing.pause
- Complete: app.lifeup.timing.complete
- Abandon: app.lifeup.timing.abandon

**Beschreibung:** Wenn ein positiver Timer startet, pausiert, abschließt oder manuell abgebrochen wird, sendet LifeUp den entsprechenden Broadcast. `complete` bedeutet, die Sitzung wurde normal beendet und protokolliert. `abandon` bedeutet, die aktuelle Sitzung wurde manuell gestoppt oder verworfen.

**Rückgabewert:**

| Parameter | Bedeutung                        | Beispiele      | Hinweise                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | Aufgaben-ID                        | 1             | Optional, nur wenn der Timer mit einer Aufgabe verknüpft ist |
| name       | Aufgabenname                      | Study English | Verknüpfter Aufgabenname oder benutzerdefinierter Timer-Name          |
| time       | Kumulierte Dauer (ms)      | 600000        | Gesamt verstrichene Dauer des aktuellen positiven Timers |
| start      | Startzeit                     | 1639123456789 | Unix-Zeitstempel (Millisekunden)                    |
| end        | Endzeit                       | 1639127056789 | Nur bei `complete` / `abandon`-Ereignissen    |

---

## Integration

Integrationen in jeder Form durch andere Entwickler sind sehr willkommen.

> Weitere Details folgen in Kürze …

### Weitere APIs benötigt?

Die API-Funktionalität befindet sich derzeit noch in einer Versionsiteration.

In Zukunft werden wir weitere APIs hinzufügen, um mehr Anwendungsfälle abzudecken.

Wenn du weitere APIs brauchst, kannst du Issues auf [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose) erstellen.

<br/>

### Aufruf

#### Android

##### Mit dem SDK

Siehe das `core`-Modul unter: https://github.com/Ayagikei/LifeUp-SDK.

##### Ohne SDK

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

#### Webseite

Ob ein Aufruf von einer Webseite aus funktioniert, hängt vom Browser ab. Gängige Browser wie Quark, Chrome und Edge funktionieren. Einige systemeigene Browser fragen bei jedem Pop-up erneut, ob „Rensheng“ geöffnet werden soll.

Wenn du eine eigene eingebettete WebView-App entwickelst, muss die WebView das lifeup-Schema verarbeiten können.

Für ein konsistentes Erlebnis kannst du den Produktlink-Effekt in `LifeUp` nutzen und „Eingebauten Browser verwenden“ aktivieren. Aus Sicherheitsgründen unterstützt dieser Weg nur HTTPS-Links (nicht HTTP).

**HTML**

Direkt über den Hyperlink springen

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

Eigentlich ebenfalls ein Hyperlink-Aufruf

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### App-/Web-/Automatisierungs-Entwickler

Melde dich, wenn du etwas im Zusammenhang mit LifeUp entwickelt hast!

<br/>

### Jede Programmiersprache/Plattform mit HTTP-Unterstützung

Details siehe https://github.com/Ayagikei/LifeUp-SDK und [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).

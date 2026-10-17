<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Wir rollen **LifeUp v1.106.0** und **LifeUp Cloud v3.0.0** schrittweise aus. Da sich die Prüfzeiten je Plattform unterscheiden, kann diese Dokumentation aktualisiert werden, bevor die Apps breit verfügbar sind; das tatsächliche Veröffentlichungsdatum kann später liegen als hier angegeben.

LifeUp Cloud ist eines der zentralen API-Toolkits für LifeUp. Es macht dein Telefon zu einer **API-Brücke**: LifeUp vom **Computer oder anderen Geräten** steuern, **eigene Integrationen** bauen (Desktop, Web, Automatisierungsskripte) oder mit **KI-Agenten** koppeln.

### Typische Szenarien

| Szenario | Zielgruppe | In einem Satz | Mehr erfahren |
| --- | --- | --- | --- |
| **HTTP + selbst bauen** | Entwickler, Automatisierungsnutzer | APIs und Daten per Python, Web-Apps oder Skripten über LAN abfragen — keine Android-Erfahrung nötig | [HTTP-API-Referenz](/guide/api-reference), [Desktop](guide/api_desktop.md) |
| **QR-Scan** | Real-World-Check-in-Fans | QR-Codes drucken, um Aufgaben zu erledigen, Timer zu starten, Dialoge zu öffnen oder Webseiten / andere Apps zu starten | [QR-Code-Scan](#qr-code-scanning) |
| **Start-/Stopp-Kürzel** | Automatisierung, NFC, Tasker | `lifeupcloud://start` und `lifeupcloud://stop` öffnen Cloud und starten oder stoppen den HTTP-Server | [Start und Stopp](#cloud-scheme) |
| **AI Agent + MCP** | Cursor, Claude usw. | Ein Prompt für Aufgabenlisten, Shop-Gegenstände, Erfolge und mehr | [MCP & Skills](guide/api_mcp.md) |
> **Beispiel-KI-Prompt:** Lösche die Beispiel-Aufgaben und Shop-Gegenstände, dann erstelle ein vollständiges Indie-Game-Developer-Setup: Aufgabenlisten, Attribute, Shop-Gegenstände und Erfolge.

<br/>

## Download

- Bei der Festland-China-Mitgliedschaft findest du den LifeUp-Cloud-Download unter `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Cloud-Dienst starten und stoppen :id=cloud-scheme

Du kannst den HTTP-Server starten oder stoppen, ohne **Start Service** zu tippen — mit diesen URL-Schemes:

```txt
lifeupcloud://start
lifeupcloud://stop
```

Beide URLs starten LifeUp Cloud und führen die Aktion aus. Nutze sie als Homescreen-Kürzel, NFC-Tag, Tasker-/Automatisierungsaktion oder:

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Die gleichen URLs stehen auf der Cloud-Statuskarte — tippen zum Kopieren.

> [!NOTE]
> `lifeupcloud://` steuert den Cloud-HTTP-Server selbst. Es ist keine `lifeup://api/…`-Spiel-API.

<br/>

## QR-Code-Scan :id=qr-code-scanning

Der **Scan**-Button oben in LifeUp Cloud liest die im QR-Code kodierte URL und öffnet sie sofort — ohne manuelle Eingabe.

Scannen ist **nicht auf LifeUp-APIs beschränkt**: `lifeup://api/…`, Webseiten `https://…` und andere App-URL-Schemes (z. B. `weixin://`) funktionieren — Android öffnet das passende Ziel.

### Nutzung

1. Wähle eine URL aus LifeUp oder der Wiki-[API-Liste](guide/api.md) (Aufgabe erledigen, Pomodoro starten, Kauf-/Nutzungsdialoge öffnen oder externe Webseite öffnen).

2. Erzeuge einen QR-Code aus der vollen URL (drucken und an Schreibtisch, Wand oder Gerät kleben).

3. LifeUp Cloud öffnen, **Scan** tippen (**?** daneben für kurze In-App-Anleitung), auf den Code richten.

### Mögliche Aktionen

| Szenario | Beispiel (illustrativ) |
| --- | --- |
| Pomodoro-Check-in | `lifeup://api/pomodoro?...` Timer starten/stoppen |
| Aufgaben-Check-in | `lifeup://api/complete?name=...` Aufgabe erledigen |
| Shop-Interaktion | `lifeup://api/goto?page=shop` oder Kauf-/Nutzungsdialoge |
| Belohnung / Strafe | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Web-Minispiel | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Andere Apps | `weixin://`, `intent://` oder Scheme einer installierten App |
| Eigene Abläufe | Jede scannbare URL-Kombination |

### Interaktion in der realen Welt

QR-Codes verknüpfen **physische Orte oder Handlungen** mit In-App-Gamification:

- **Fitnessgerät**-Aufkleber → scannen, um Krafttraining-Aufgabe zu erledigen

- **Lernschreibtisch**-Aufkleber → scannen, um Fokus-Pomodoro zu starten

- **Arbeitsplatz**-Aufkleber → scannen, um Stand-up oder Code-Review zu protokollieren

- **Event-Board**-Aufkleber → scannen, um Belohnung abzuholen oder Erfolg zu öffnen

Kurz: **URL Schemes in scannbare physische Trigger verwandeln**, LifeUp Cloud als Ausführer zwischen App und Realität.

<br/>

> [!NOTE]
> LifeUp Cloud ist eine rein LAN-basierte HTTP-Brücke. Wie du dein Telefon erreichst — IP-Adresse, Router, Firewall, gleiches Subnetz, VPN oder AP-Isolation — hängt von deinem Heimnetz ab. Bei Verbindungsproblemen können wir dein persönliches LAN nicht debuggen. Prüfe dein Netzwerk selbst, nutze Standard-Netzwerk-Tools oder bitte einen KI-Agenten um Hilfe.

## Mit LifeUp Cloud verbinden :id=connect

1. Installiere kompatible Versionen von LifeUp und LifeUp Cloud. Öffne LifeUp Cloud und erteile auf Anfrage die LifeUp-Daten-/API-Berechtigung.
2. Starte den HTTP-Dienst. Verwende auf einem Gerät, das das Telefon im Netzwerk erreichen kann, die von Cloud angezeigte Adresse und den Port als Basis-URL.
3. Falls ein Cloud-Token konfiguriert ist, sende dessen Rohwert im Header `Authorization`. Frage `/info` ab, um Verbindung und installierte Versionen zu prüfen; kontrolliere HTTP-Status und JSON-`code`.

## HTTP-API-Referenz :id=http-api-definition

Die [vollständige Schnittstellen- und Parameterreferenz](/guide/api-reference) enthält einen Routenindex, gemeinsame Antwort-/Seitennavigationsregeln, vollständige Datenmodelle, Anfrageparameter und JSON-Beispiele. Lies sie beim Erstellen einer Integration. [URL-Scheme-Methoden](/guide/api) beschreiben einzelne Aktionen; [MCP & Skills](/guide/api_mcp) beschreiben KI-Agentenwerkzeuge.

### Aufgaben- und Verlaufszeitstempel :id=task-history-timestamps

Siehe [Aufgabenzeitmodell](/guide/api-reference?id=task-times): `startTime` ist der geplante Start, `deadline` die Fälligkeit und Verlaufs-`endTime` die gespeicherte Abschluss-/Überfälligkeits-/Aufgabezeit, gemeinsam mit `status` auszuwerten.

#### Tagesberichte und Vollständigkeit des Verlaufs :id=history-daily-reports

Siehe [Verlaufsseitennavigation und Tagesberichte](/guide/api-reference?id=daily-report) sowie [EXP-/Münzjournale](/guide/api-reference?id=reward-journals) für tatsächliche Belohnungsänderungen.

## Mitwirken

SDK, LifeUp Cloud und LifeUp Desktop sind Open-Source-Projekte.

Quellcode:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

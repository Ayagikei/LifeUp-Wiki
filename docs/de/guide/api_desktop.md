<h1 align="center" padding="100">Local Network (API) Desktop Client 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Wir haben einen schlanken Desktop-Client für LifeUp auf Basis der LifeUp-APIs entwickelt. Er unterstützt Windows, Linux und macOS.

**Es ist keine eigenständige App.** Sie liest deine LifeUp-Offline-Daten über API-Zugriff vom Telefon.

<br/>

## Funktionen

> [!NOTE]
> Die aktuelle Version ist vor allem eine technische Vorschau der API-Fähigkeiten. Sie konzentriert sich auf zentrale Browse-Operationen und deckt nicht jede In-App-Funktion ab.

- Vollständig Open Source. Du kannst die UI anpassen und eigene Funktionen implementieren.
- Aktuelle Basisfunktionen:
  - Aufgabenliste abfragen und Aufgaben erledigen
  - Attributliste und Stufen abfragen
  - Gegenstandsliste abfragen und Gegenstände kaufen
  - Gefühle abfragen und Bilder in voller Größe am Desktop ansehen
  - Gefühle als Markdown-Dateien exportieren
  - Aufgaben hinzufügen (noch nicht alle In-App-Optionen abgedeckt)

<br/>

## Download

Alle Desktop-Pakete werden auf [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) veröffentlicht.

> [!WARNING]
> Stelle vor der Desktop-Nutzung sicher, dass LifeUp Cloud v2.0.0 oder höher ist.<br/>
> Bei der GitHub-Releases-Version aktualisiere LifeUp Cloud unter `Settings` → `Labs`.<br/>
> Bei der Google-Play-Version kannst du über [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) oder [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest) aktualisieren.<br/>
> Manche Browser blockieren Installer-Downloads aus Sicherheitsgründen. Wähle **Behalten/Zulassen** (Formulierung je nach Browser) oder nutze einen anderen Downloader.

### Installation Platforms

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> Die MSI ist derzeit nicht EV-signiert; Windows kann eine Warnung „Unbekannte App“ anzeigen.<br/>
> Nachdem du bestätigt hast, dass die Datei vom offiziellen GitHub-Release stammt, klicke **Weitere Informationen → Trotzdem ausführen**.

#### **Linux**

- Lade von [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) herunter und nutze `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64: `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64: `LifeUp-Desktop-arm64.dmg`
- macOS-Builds sind noch nicht vollständig getestet; einige Funktionen wie **Auto Connect** sind möglicherweise nicht verfügbar.

> [!TIP]
> **macOS Gatekeeper / Signatur**<br/>
> Aktuelle macOS-Builds sind nicht notarisiert. Du siehst ggf. eine Warnung „Unbekannter Entwickler“.<br/>
> Öffne die `.dmg`, verschiebe die App nach Programme, rechtsklicke die App und wähle **Öffnen**,<br/>
> oder gehe zu **Systemeinstellungen → Datenschutz & Sicherheit** und klicke **Trotzdem öffnen**.<br/>
> Details siehe [Apples offizielle Anleitung](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac).

<!-- tabs:end -->

Fehlt ein Paket vorübergehend, lade die Seite später neu. Release-Assets werden ggf. noch hochgeladen.

<br/>

## Nutzung

### Ersteinrichtung

#### Voraussetzungen

- Telefon und Desktop müssen im selben LAN sein (z. B. dasselbe Wi-Fi).
- <del>Bei komplexem Netzwerk zuerst testen, ob der Desktop die Telefon-IP pingen kann.</del>
  - Neuere Desktop-Versionen unterstützen automatische Telefon-IP-Erkennung — oft nicht mehr nötig.

#### Am Telefon

1. LifeUp auf die neueste Version aktualisieren.
2. In LifeUp `Settings` → `Labs` öffnen und **LifeUp Cloud** installieren.
3. LifeUp Cloud öffnen und erforderliche Berechtigungen erteilen:
   - Schwebendes Fenster / Über andere Apps einblenden
   - LifeUp-Daten lesen
4. In LifeUp Cloud **Start Service** tippen.

**Empfohlene Zusatzeinrichtung**

- Kompatibilitätskonfiguration für LifeUp und LifeUp Cloud; Akkuoptimierung deaktivieren, um Hintergrund-Kills zu reduzieren.
- Bei MIUI (Xiaomi/Redmi) für beide Apps **Display UI in background** erlauben.
- LifeUp und LifeUp Cloud laufen lassen.

#### Am Desktop

1. Desktop-App aus dem Release-Paket installieren.
2. In den Desktop-Einstellungen die in LifeUp Cloud angezeigte Service-IP eintragen.
   - Ab Desktop v1.1.0+: **Auto Connect** ausprobieren.
3. Bei korrekter Konfiguration solltest du LifeUp-Daten am Desktop sehen.
   - Bei Fehlern die Zusatzeinrichtung oben prüfen.

### Wiederholte Nutzung

1. LifeUp und LifeUp Cloud am Telefon öffnen.
2. In LifeUp Cloud **Start Service** tippen.
3. Desktop-Client starten.

<br/>

## FAQ

<details>
<summary>Kann ich Aufgaben vom Desktop hinzufügen?</summary>

Ja. Die aktuelle Desktop-Version unterstützt grundlegendes Anlegen von Aufgaben.

Noch nicht alle erweiterten In-App-Aufgabenoptionen sind am Desktop verfügbar. Für komplexe Konfigurationen nutze die mobile App oder rufe APIs über LifeUp Cloud auf.

</details>

<details>
<summary>Ich habe in LifeUp Cloud „Request LifeUp Permission“ getippt, aber nichts passiert / API not found.</summary>

1. Wenn nichts passiert, hast du die Berechtigung ggf. schon erteilt.
2. Bei „API not found“: Member-Beta beitreten und LifeUp auf die neueste Beta aktualisieren.

</details>

<details>
<summary>Nach längerer Telefonsperre kann der Desktop keine Daten mehr lesen.</summary>

Kompatibilitätskonfiguration für LifeUp und LifeUp Cloud durchführen.

</details>

<details>
<summary>Wenn LifeUp und LifeUp Cloud im Hintergrund sind, schlagen einige APIs fehl.</summary>

> Das betrifft meist nicht die grundlegende Desktop-Nutzung, kann aber eigene API-Aufrufe beeinträchtigen.

Stelle sicher, dass LifeUp Cloud die Berechtigung Schwebendes Fenster / Über andere Apps einblenden hat.

Bei MIUI (Xiaomi/Redmi) zusätzlich **Display UI in background** für beide Apps aktivieren.

</details>

<details>
<summary>Windows-Installation schlägt fehl mit `Failed to launch JVM`.</summary>

Referenz: [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Das hängt meist mit der lokalen JVM-Zugänglichkeitskonfiguration zusammen.

Häufiger Workaround: diese Zeilen in `~/.accessibility.properties` auskommentieren:

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Nach dem Bearbeiten App neu starten und erneut testen.

> `~` ist dein Benutzer-Home-Verzeichnis.

</details>

<br/>

## Mitwirken

SDK, LifeUp Cloud und LifeUp Desktop sind Open Source.

Quellcode:

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

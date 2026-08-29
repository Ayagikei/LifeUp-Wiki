# Backup und Wiederherstellung

> [!IMPORTANT]
> LifeUp ist eine Offline-first-App. Die meisten persönlichen Daten bleiben auf deinem Gerät. Ohne konfiguriertes Backup können Deinstallation, Gerätewechsel oder Geräteschaden zu dauerhaftem Datenverlust führen.

## Schnellnavigation

- [Warum Backup wichtig ist](#why-backup)
- [Backup-Methoden einrichten](#configure-methods)
- [Backup erstellen](#how-to-backup)
- [Wiederherstellen](#how-to-restore)
- [Migration auf ein neues Gerät](#phone-migration)
- [Häufige Probleme](#common-issues)

## 1) Warum Backup wichtig ist :id=why-backup

### Vor welchen Risiken schützt du dich?

Die meisten Nutzer verlieren Daten in einer dieser Situationen:

1. App-Deinstallation (Dateien im Standard-Backup-Pfad können durch Systembereinigung entfernt werden)
2. Gerätewechsel ohne Mitnahme der Backup-Dateien
3. Geräteschaden oder -verlust

Ein zuverlässiges Backup bedeutet, dass deine Daten auf einem anderen Gerät oder Speichermedium existieren — nicht nur auf demselben Telefon.

### Was ist in einem Backup enthalten?

Backups umfassen lokale Kerndaten wie Aufgaben, Attribute, Shop-Daten, Erfolge, Gefühle, Pomodoro-Aufzeichnungen und Einstellungen. Medien (Anhänge, Icons, Hintergründe, Audio) können ebenfalls enthalten sein.

> [!TIP]
> Liegt die Backup-Größe über 10 MB, aktiviere „Medien-/Bilddateien ignorieren“ oder verlängere das Backup-Intervall für mehr Stabilität.

## 2) Backup-Methoden einrichten :id=configure-methods

Für die meisten Nutzer funktioniert diese Priorität am besten:

| Methode | Empfehlung | Am besten für | Auto-Backup | Hinweise |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Tägliche Nutzung, einfache Cloud-Synchronisation | Ja | Ein-Tipp-Autorisierung in der App |
| Dropbox | ⭐⭐⭐⭐ | Tägliche Nutzung, geräteübergreifende Sync | Ja | Unterstützt auch In-App-Autorisierung |
| Lokaler Export (Benutzerdefinierter Pfad) | ⭐⭐⭐⭐ | Manuell auf PC / NAS kopieren | Nein (manuell) | Zuverlässiger Fallback und versionierte Archive |
| WebDAV | ⭐⭐⭐ | Self-Hosting / bestehender WebDAV-Dienst | Ja | Gute Alternative, wenn du bereits WebDAV nutzt |
| Auto-Backup in Download-Ordner (Android 10+) | ⭐⭐⭐ | Deinstallationsrisiko reduzieren | Ja | Schützt nicht vor Geräteschaden |

<details>
<summary>Google Drive / Dropbox Auto-Backup einrichten (empfohlen)</summary>

In der App:
`Seitenleiste → Einstellungen → Datensicherung/Wiederherstellung/Löschen`

Dann:

1. Google Drive oder Dropbox autorisieren
2. In „Cloud-Backup-Konfiguration“ die Methode wählen
3. „Automatisches Cloud-Backup aktivieren“ einschalten
4. „Automatisches Backup-Intervall“ festlegen
5. Optional „Medien-/Bilddateien ignorieren“ aktivieren

</details>

<details>
<summary>WebDAV-Cloud-Backup einrichten (optional)</summary>

Wenn du einen WebDAV-kompatiblen Dienst nutzt:

1. „WebDAV-Konfiguration“ öffnen
2. URL, Konto und Passwort eintragen
3. Verbindungstest ausführen
4. WebDAV als Cloud-Backup-Methode verwenden

</details>

<details>
<summary>In benutzerdefinierten Pfad exportieren (manueller Fallback)</summary>

Wenn du manuelle, portable Backups möchtest:

1. Auf `Backup` tippen
2. `Benutzerdefinierter Pfad` wählen
3. Die erzeugte Datei speichern (meist `.lfbak`)
4. Auf PC / NAS / Cloud-Speicher kopieren

> [!WARNING]
> Bewahre dein einziges Backup nicht nur auf demselben Telefon auf.

</details>

## 3) Backup erstellen :id=how-to-backup

<details>
<summary>Täglichen Auto-Backup-Workflow ausführen</summary>

1. Eine Cloud-Einrichtung abschließen (Google Drive oder Dropbox)
2. Automatisches Cloud-Backup und Intervall aktivieren
3. Einmal manuelles Backup auslösen, um alles zu prüfen
4. Den Hinweis „Letztes Backup“ regelmäßig kontrollieren

</details>

<details>
<summary>Vor wichtigen Änderungen manuelles Backup erstellen</summary>

Vor folgenden Schritten zusätzlich lokal exportieren:

- größeren App-Updates
- System-Reset / Reflash
- Gerätewechsel

Nutze: `Backup → Benutzerdefinierter Pfad`, dann Datei auf externen Speicher kopieren.

</details>

## 4) Wiederherstellen :id=how-to-restore

<details>
<summary>Aus Cloud-Backup wiederherstellen (Google Drive / Dropbox / WebDAV)</summary>

1. Auf dem Zielgerät dasselbe Cloud-Konto bzw. dieselbe Methode konfigurieren
2. Auf `Wiederherstellen` tippen und die Methode wählen
3. Wiederherstellung bestätigen (App startet neu)

> [!WARNING]
> Wiederherstellung überschreibt lokale Daten. Wenn aktuelle Daten wichtig sind, zuerst ein lokales Backup exportieren.

</details>

<details>
<summary>Aus lokaler Backup-Datei wiederherstellen</summary>

1. Backup-Datei auf das Zielgerät übertragen
2. `Wiederherstellen → Benutzerdefinierter Pfad` tippen
3. Backup-Datei auswählen und bestätigen

Du kannst auch „Dateisystem zum Öffnen von Backup-Dateien unterstützen“ aktivieren, um direkt aus dem Dateimanager oder per Teilen zu importieren.

> [!TIP]
> Schlägt die Wiederherstellung mit Lese-/Schreibfehler fehl, probiere einen anderen Dateipfad und wähle die Datei erneut.

</details>

### Migration auf ein neues Gerät :id=phone-migration

<details>
<summary>Auf neues Gerät migrieren (System oder Backup-Pfad)</summary>

#### Option A: Zuerst integrierte Gerätemigration nutzen

Manche Telefone unterstützen vollständige App-Datenmigration (Marken-Migrationstools / System-Klon).

1. Systemmigration vom alten auf das neue Gerät ausführen.
2. LifeUp öffnen und Kerndaten prüfen (Aufgaben, Attribute, Shop-Daten, Erfolge).
3. Auch wenn die Migration gut aussieht, auf dem neuen Gerät ein frisches Backup erstellen.

#### Option B: Über Cloud-Backup oder Backup-Datei migrieren (universell)

1. Auf dem alten Gerät zuerst ein frisches Backup erstellen.
2. Auf dem neuen Gerät LifeUp installieren.
3. Cloud-Migration: dieselbe Cloud-Methode/dasselbe Konto konfigurieren, dann wiederherstellen.
4. Datei-Migration: Backup-Datei übertragen, dann `Wiederherstellen → Benutzerdefinierter Pfad`.
5. Nach der Wiederherstellung ein manuelles Backup auslösen, um die Backup-Kette auf dem neuen Gerät zu prüfen.

> [!WARNING]
> Wiederherstellung überschreibt lokale Daten. Hat das neue Gerät bereits wichtige neue Einträge, zuerst exportieren.

</details>

## 5) Häufige Probleme :id=common-issues

<details>
<summary>Wiederherstellungsfehler beheben: ungültige Backup-Datei</summary>

- Prüfen, ob die Datei von LifeUp erzeugt wurde.
- `.lfbak` ist das empfohlene Format.

</details>

<details>
<summary>Wiederherstellungsfehler beheben: Backup-Datei mit höherer Version</summary>

LifeUp auf die neueste Version aktualisieren, dann erneut wiederherstellen.

</details>

<details>
<summary>Langsames oder instabiles Cloud-Backup verbessern</summary>

- „Medien-/Bilddateien ignorieren“ aktivieren.
- Automatisches Backup-Intervall verlängern.
- Ungenutzte Mediendateien vor dem Backup bereinigen.

</details>

<details>
<summary>Entscheiden, ob Auto-Backup in den Download-Ordner ausreicht</summary>

- Hilft gegen verlustbedingte Deinstallation.
- Deckt Geräteschaden/-verlust nicht ab.
- Sicherere Strategie: Cloud-Backup + regelmäßiger lokaler Export kombinieren.

</details>

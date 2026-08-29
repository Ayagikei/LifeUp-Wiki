# Entwicklungsplan 2022/10 – 2023/12

> [!WARNING]
> Dies ist ein abgelaufener Entwicklungsplan, nur für Archiv und Referenz. Die Umgebung ändert sich weiter; Pläne passen wir entsprechend an. Der Plan zeigt grob unsere Richtung, wir versprechen aber keine vollständige Umsetzung und können auch darüber hinaus entwickeln.

<br/>

LifeUps Entwicklung in früheren Jahren konzentrierte sich auf neue Funktionsmodule oder Erweiterungen bestehender Module.

Heute sehen wir genug Breite in den Modulen, aber zu wenig Tiefe.

Die folgenden Ziele zielen deshalb auf Funktionstiefe: bestehende Module verbessern, Praxisnutzen erhöhen (Kalenderintegration, Widgets, Statistiken);

API-Funktionalität kontinuierlich ausbauen, damit externe Erweiterungen möglich sind.
Außerdem das Datensystem verbessern und Flutter für plattformübergreifende Versionen erkunden.

<br/>

- **2023/01/26**
  - „LAN-PC-Seite“ zu „Multi-Plattform“ ergänzt, passende Erklärung bei „APIs“.
  - Geplante Version für „Kalenderintegration“ angepasst, Fortschritt kann sich verzögern.
  - Geplante Version für „Benutzerdefinierte erforderliche Erfahrung“ angepasst, Fortschritt kann vorgezogen werden.
- **2022/10/16**
  - **Roadmap für Attribute, Erfolge und Basisfunktionen ergänzt**

| Modul | Unterfunktion | Geplante Version | Begründung | Priorität | Ergebnis |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Kalenderintegration | - Google Kalender Zwei-Wege-Sync<br/>- Systemkalender Zwei-Wege-Sync | v1.91~1.93 | - Viel Feedback aus dem Ausland.<br/>- LifeUp ist ein To-do-Tool mit Überschneidungen, aber ohne Konsistenz zu Kalender-Apps. Alle Kalenderfunktionen in LifeUp wären enorm. Externe Integration kann die bessere Lösung sein. | P0 | ~ |
| Widgets | - Attribute-Widget<br/>- Gegenstände-Widget<br/>- usw. … | v1.92~1.95 | - Bedienbarkeit.<br/>- Schöne Widgets bieten Gamification und Motivation. | P1 | ~ |
| Statistiken | - Verschiedene Indikator-Statistiken<br/>- Detaillierte Pomodoro-Statistiken<br/>- Sharing-Karten erzeugen | v1.92~1.95 | - Pomodoro-Statistiken fehlen.<br/>- Statistikmodul lange nicht überarbeitet, Design und Daten veraltet.<br/>- Sharing-Karten für externe Nutzung, Anreize und ggf. mehr Nutzer (braucht gutes UI-Design). | P1 | - Einige Statistik-Karten voraussichtlich in v1.91 |
| APIs | - SDK entwickeln<br/>- Listenabfragen unterstützen<br/>- Mehr gängige APIs | v1.91~1.95 | - Listen-Dateninterface fehlt. Mit Listenabfrage können Dritte eigene UI (z. B. Aufgabenliste) bauen, Erweiterbarkeit steigt stark.<br/>- Darauf basierend SDKs und LAN-PC-Seite.<br/>- LifeUp kann nicht alles abdecken, aber API ermöglicht Anpassung, Erweiterung und Open-Source-Community. | P1 | - Erste Query-API voraussichtlich in v1.91 |
| Attribute | - Benutzerdefinierte erforderliche Erfahrung | v1.91~1.92 | ~ | P2 | - Entwicklung voraussichtlich in v1.91 abgeschlossen |
| Erfolge | - Wiederholungs-Erfolge | v1.94~1.97 | ~ | P2 | ~ |
| Basisfunktionen | - Stapelbearbeitung (Aufgaben, Erfolge usw.)<br/>- Mehrfachauswahl Gegenstände, Auto-Verpacken in Boxen usw. | v1.94~1.97 | ~ | P1 | ~ |
| Datensystem | - Getrenntes Backup von Daten und Bildern<br/>- Teil-Export/-Import<br/>- Integrierter Multi-Datei-Wechsel | ~ | - WebDAV-Upload großer Dateien scheitert leicht, kostenlose Clouds haben Traffic-Limits, Vollbackup mit Bildern zu groß.<br/>- Teil-Export/-Import zum Teilen von Belohnungssystemen.<br/>- Multi-Dateien zum Wechseln zwischen Systemen ohne wiederholtes Löschen. | P1 | ~ |
| Multi-Plattform | - Flutter weiter lernen und für plattformübergreifende Version nutzen | LAN-PC-Seite: v1.91-1.92<br/>Flutter: v2.0 | - iOS-Prototyp.<br/>- Eher neue Ansätze als 1:1-Kopie der Android-Version.<br/>- Ggf. für Windows/macOS und andere Plattformen, noch zu prüfen.<br/>- LAN-PC-Seite auf Basis der APIs (Telefon-Daten lesen). | P1 | - Erste PC-Version voraussichtlich in v1.91 |

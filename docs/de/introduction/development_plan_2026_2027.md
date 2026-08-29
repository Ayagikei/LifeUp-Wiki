# Entwicklungsplan 2026–2027

> [!WARNING]
> Dies ist unser aktueller Entwicklungsplan. Wir orientieren Produktverbesserungen und Upgrades danach, soweit möglich. Wegen der sich wandelnden Umgebung kann der Plan geändert, ergänzt oder gekürzt werden. Maßgeblich ist die tatsächliche Produktveröffentlichung.

### I. Entwicklungsplan

> Aktualisiert: 2026/04

Anders als 2024–2025 erwarten wir 2026–2027 Verbesserungen bestehender Module von LifeUp und **ulives**, statt völlig neuer Funktionsmodule.

| Modul | Unterfunktion | Begründung | Priorität | Ergebnis |
| ---- | ------ | -------- | ------ | ---- |
| Kalenderintegration | - Google Kalender Zwei-Wege-Sync<br/>- Systemkalender Zwei-Wege-Sync | - Viel Feedback aus dem Ausland.<br/>- LifeUp ist ein To-do-Tool mit Überschneidungen zu Kalender-Apps. Alle Kalenderfunktionen in LifeUp wären enorm. Externe Integration kann die bessere Lösung sein. | P0 | 🚧 |
| Synthese-Optimierung | - Integration mit Shop<br/>- Erweiterte Filter | - Synthese ist eine Kernfunktion. Kontinuierliche Optimierung von Shop-Integration und Filtereffizienz für mehr Bedienkomfort. | P0 | ✅ Veröffentlicht |
| Gegenstände-Optimierung | - Reichere Nutzungseffekte (Mengen anderer Gegenstände ändern)<br/>- Soundeffekte auslösen<br/>- Nutzungslimits<br/>- Erweiterte Limit-Bedingungen | - Gegenstandssystem ist Kern der Gamification. In v1.103 Feintuning, Flexibilität und Gameplay ausbauen. | P0 | 🚧 v1.103 Feintuning |
| Attribute-Optimierung | - Attribute-Unterkategorien (Gruppierung)<br/>- Titelsystem<br/>- Typ [Status] unterstützen<br/>- Statusseite optimieren<br/>- Life-Level-Widget | - Attributsystem ist weiterer Gamification-Kern. Mehr Dimensions-Anpassung und Darstellung. | P0 | 🚧 Unterkategorien veröffentlicht, Rest in Planung |
| Aufgaben-Optimierung | - Explizite Tag-Bearbeitung und Filter<br/>- Unteraufgaben-Interaktion<br/>- Erzwungenes Abschlussverhalten für Unteraufgaben<br/>- Überfällig-/Push-Verhalten anpassen | - Aufgaben sind LifeUps Kernfunktion; Bearbeitung und Interaktion kontinuierlich verbessern. | P1 | 🚧 |
| Stapel-Belohnungen für Zähler-Aufgaben | - Stapelweise Belohnungen für Zähler-Aufgaben | - Aktuelles Belohnungsmodell einfach; Stapel-Belohnungen flexiblere Ziel-Anreize. | P1 | 🚧 |
| Gedanken/Reflexion-Optimierung | - Mehr Anzeigestile | - Gedanken-Funktion ist LifeUp-Besonderheit; Darstellung und Interaktion optimieren. | P2 | 🚧 |
| Erfolge erweitern | - Wöchentliche/monatliche/jährliche Statistiken<br/>- Weitere Freischalt-Bedingungen | - Erfolgssystem braucht vielfältigere Bedingungen für reichere Erlebnisse. | P2 | 🚧 |
| Datensystem | - Getrenntes Backup von Daten und Bildern<br/>- Teil-Export/-Import<br/>- Integrierter Multi-Datei-Wechsel | - WebDAV-Upload großer Dateien scheitert leicht, kostenlose Clouds Traffic-Limits, Vollbackup mit Bildern zu groß.<br/>- Teil-Export/-Import zum Teilen von Belohnungssystemen.<br/>- Multi-Dateien zum Wechseln zwischen Systemen ohne wiederholtes Löschen. | P1 | 🚧 |
| API | - API-Fähigkeiten und Abdeckung auf alle Basisfunktionen | - Einige APIs fehlen noch, z. B. gedankenbezogene Operationen.<br/>- LifeUp muss nicht alles können; API ermöglicht Anpassung, Erweiterung und Open-Source-Community. | P1 | 🚧 |
| **ulives**-Entwicklung | - **ulives**-Features weiter ausbauen<br/>- Multi-Plattform erkunden (iOS/iPadOS/macOS/andere) | - **ulives** ist LifeUps nächste Generation, mit moderner Cross-Platform-Technologie.<br/>- Perspektivisch auch Android oder andere Plattformen. | P0 | 🚧 |

Zusammenfassung:

1. Etablierte Richtung: Stabilität und Optimierung bestehender Features.
2. Funktionstiefe jedes Moduls für bessere Nutzererfahrung.
3. **ulives** vorantreiben und mehr Plattformen erkunden.
4. APIs und andere Bereiche weiter verbessern.

---

### II. Rückblick und Ausblick

#### 2.1 Über **ulives**

2025 **ulives** auf iOS als LifeUps nächste Generation. Manche fragen: Warum eine neue App? Warum erneut zahlen?

Unsere Gedanken:

**Technologie und Architektur**

LifeUp basiert auf Android-Technologie mit viel Logik und historischer Kompatibilität. Architekturbedingt ist eine identische iOS- oder HarmonyOS-Version mit Datenkompatibilität nahezu unmöglich.

LifeUp wuchs schrittweise; manche Produktentscheidungen durch Kompatibilität und frühe Designentscheidungen — schwer änderbar. Beispiele:

- **Benutzerdefinierte Währung**: LifeUps Basis ist eine Währungsart; große Architekturänderungen schwierig.
- **Welt-Modul**: Früh wegen Server-Kooperation geplant, die meisten Features nicht durchdacht — heute fehlende Team-Features.

Neu entwickeln erlaubt moderne Konzepte aus neuer Produktperspektive.

**Technische Schulden**

Technisch auch Fallstricke:

- ORM-Framework für schnelle Frühentwicklung, praktisch nicht mehr gepflegt — Migration schwierig.
- Basis ohne zusammengesetzte Indizes — Performance-Engpässe.
- Viel Aufwand für Performance bei großen Datenmengen.

Für **ulives** moderne Cross-Platform-Technologie (Kotlin Multiplatform). Perspektivisch Android oder andere Plattformen (derzeit iOS, iPadOS, macOS).

**Kosten und Preis**

LifeUps früher niedriger Einmalpreis und Single-Platform ließen wenig Spielraum für investitionsintensive Features (Welt-Modul, KI).

LifeUp (Android) niedriger Preis basiert auf Single-Platform-Wartung. **ulives** kann Anpassungen und mehr Planung haben.

Andere Teams, komplette Neuentwicklung, **ulives** vollständig offline — Mitgliedschaften können nicht geteilt werden, keine Extra-Rabatte, künftig vermutlich auch nicht, um zahlende Nutzer nicht zu benachteiligen.

---

#### 2.2 KI-Effizienz

In den letzten Jahren boomen KI-gestützte Entwicklung; viele Apps in kurzer Zeit.

Wir nutzen KI für Funktionsgerüste und Code-Scaffolding. KI ist nicht allmächtig — Technologieentscheidungen, Abnahme und Funktionssicherheit brauchen weiter viel menschliche Arbeit.

Zeitintensiv ist Feinschliff: iOS-Animationen, Interaktionsfluss, Edge Cases — oft ein Vielfaches der Funktionslogik.

---

#### 2.3 Nutzer-Erweiterungen und KI-Integration

Viele interessante Funktionen mit KI und LifeUps API:

- MCP (Model Context Protocol) verbindet LifeUp mit KI-Toolchains
- LifeUp mit Notiz-Apps wie Obsidian für Workflow-Automatisierung
- Eigene Web-Tools und Skripte über APIs

Wir freuen uns über geteilte KI-Erweiterungen und neue Ideen!

---

#### 2.4 Entwicklungsrhythmus und Qualität

Langfristige Pflege von LifeUp, **ulives** und weiteren Apps. Mehrjährige Pläne für LifeUp; wir setzen fort.

Keine hastigen Features auf Kosten von Qualität und Stabilität. Jedes Feature durch Design, Entwicklung, Test und Optimierung — damit es Bestand hat.

Deshalb mehr Zeit in Vertiefung bestehender Features statt ständig neuer Module.

---

#### 2.5 Community-Highlights

Viele beeindruckende Nutzer:

- Ein Nutzer mit seltsamem LifeUp-Crash: nach mehreren Runden exportierte er bugreport, KI-Analyse zeigte korrupte Systemkalender-Daten. LifeUp nutzt Kalender-Benachrichtigungen, wurde fälschlich vom System beendet. So fanden wir ein obskures System-Kompatibilitätsproblem.
- Viele teilen Kreationen: Aufgabensysteme, Gegenstands-Designs, Erfolge und Community-Inhalte.

Die Unterstützung der Nutzer treibt uns an, Produkte weiter zu pflegen und zu aktualisieren.

---

> Vorschau: 2025 auch **ulives** mit Kotlin Multiplatform, derzeit iOS, iPadOS und macOS, perspektivisch mehr Plattformen.

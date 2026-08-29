# Entwicklungsplan 2024–2025

> [!WARNING]
> Dies ist unser aktueller Entwicklungsplan. Wir orientieren Produktverbesserungen und Upgrades danach, soweit möglich. Wegen der sich wandelnden Umgebung kann der Plan geändert, ergänzt oder gekürzt werden. Maßgeblich ist die tatsächliche Produktveröffentlichung.

### I. Entwicklungsplan

> Aktualisiert: 2025/09/14

| Modul | Unterfunktion | Begründung | Priorität | Ergebnis |
| ---- | ------ | -------- | ------ | ---- |
| Basisfunktionen (1) | Mehrfachauswahl Gegenstände & Auto-Verwendung bei Erhalt | ~ | P0 | ✅ Mehrfachauswahl in v1.94<br/>✅ Auto-Verwendung in v1.96 |
| Basisfunktionen (2) | Allgemeines Belohnungs-Popup (beliebig viele Attribute und Gegenstände) | ~ | P0 | ✅ In v1.96; Einstellungen in späteren Versionen lockern |
| Basisfunktionen (3) | Sound-Ressourcenverwaltung & Gegenstands-Soundeffekte | ~ | P0 | ✅ Veröffentlicht |
| Basisfunktionen (4) | Benachrichtigungs-Optimierung | ~ | P0 | ✅ Veröffentlicht |
| Großbild-Anpassung (Tablet/Faltbar) | Anpassung für Tablets und Faltgeräte via Activity Embedding | ~ | P1 | ✅ Voraussichtlich in v1.95 |
| Widgets | Widget-Erweiterung (Inventar-Widget) | ~ | | ✅ In v1.94 |
| Kalenderintegration | - Google Kalender Zwei-Wege-Sync<br/>- Systemkalender Zwei-Wege-Sync | - Viel Feedback aus dem Ausland.<br/>- LifeUp ist ein To-do-Tool mit Überschneidungen zu Kalender-Apps, aber ohne Konsistenz. | P1 | 🚧 |
| API | - API-Fähigkeiten auf alle Basisfunktionen ausweiten<br/>- Desktop-Client vervollständigen, Backup/Wiederherstellung usw. | - Viele APIs fehlen noch, z. B. Bearbeitung.<br/>- LifeUp muss nicht alles können, API ermöglicht Anpassung und Erweiterung. | P1 | 🚧 Voraussichtlich in v1.98.x |
| Erfolge | - Wiederholungs-Erfolge | ~ | P2 | ✅ Veröffentlicht |
| Datensystem | - Getrenntes Backup von Daten und Bildern<br/>- Teil-Export/-Import<br/>- Integrierter Multi-Datei-Wechsel | - WebDAV-Upload großer Dateien scheitert leicht.<br/>- Teil-Export/-Import zum Teilen von Belohnungssystemen.<br/>- Multi-Dateien für Tests ohne Datenlöschung. | P1 | 🚧 |
| Multi-Plattform (Flutter) | - Flutter weiter für plattformübergreifende Version | - iOS-Prototyp | P2 | 🚧 Pausiert |
| Multi-Plattform (KMP) | - Mehr Möglichkeiten mit KMP erkunden | - KMP-Technologie für die Zukunft lernen | P0 | ✅ ulives – neue iOS-App veröffentlicht |

Zusammenfassung:

1. Etablierte Richtung umsetzen: Stabilität und Optimierung bestehender Features, keine willkürlichen neuen Module.
2. Ein bis zwei Major-Versionen für Basisfunktions-Lücken und Pain Points.
3. Danach Kalenderintegration und Wiederholungs-Erfolge.
4. APIs und andere Bereiche kontinuierlich verbessern.

Multi-Plattform ist ein Schwerpunkt für 2024.

---

### II. Rückblick 2023

LifeUps halb-amateurhafte, halb-freizeitliche Entwicklung ist in ihr sechstes Jahr gegangen. Hunderte Versionen, allein im Android-Repo fast 5000 Commits.

<br/>

Obwohl der Plan von Oktober 2022 auf Vertiefung zielte, brachten Umgebungsänderungen viele Hindernisse.

#### 1.1 Umgebung

Typische Beispiele:

- „Anti-Betrugs“-Falschmeldungen in manchen Provinzen ohne Einspruchsweg, mehrere Runden bis zur Klärung. Kürzlich wieder Probleme in Shandong, noch ohne Einspruch oder Reproduktionsweg.
- Review-Standards im chinesischen Android-Markt schichten sich, uneinheitlich zwischen Märkten und Personal, oft unprofessionelle Prüfer.
  - Manche Märkte lehnen unveränderte Teile ab.
  - Ein V-Markt wollte LifeUp fast mit „Datenschutz-Compliance“ ablehnen: App soll [alle Dateien lesen] oder [alle Fotos lesen] mit Begründung beantragen, damit Nutzer aus dem Album wählen. LifeUp nutzt einen datenschutzfreundlicheren Weg, braucht diese Rechte nicht, liest keine Dateien direkt, sondern springt zur System-Galerie und erhält nur die gewählte Datei.
    Prüfer kannten diese Best Practice nicht; mehrere Arbeitstage Support-Kommunikation bis zur Freigabe.

<br/>

Um Umwelteinflüsse zu reduzieren:

In-App-Update-Mechanismus verstärkt, Markt-Review seltener.

Die Inlandsversion unterstützt In-App-Updates und stabile oder Beta-Kanäle.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Offizielle Website (https://lifeupapp.fun/en/index.html) als alternativer Download-Kanal aktualisiert.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Download und Installation über die Website erleichtern, Review-Risiken und Verzögerungen umgehen.

Netzwerkanfragen in der App mit Backup-Kanälen gegen Zugriffsprobleme durch Falschmeldungen in manchen Provinzen.

<br/>

Mit strengeren Reviews und Hindernissen anderer Indie-Entwickler im Inlands-Android-Markt

ist der Inlands-Android-Markt für Indie-Entwickler nicht mehr das ideale Erstziel.

Strengste Qualifikationsanforderungen und komplexeste, **wechselnde** Review-Standards.

> Ironischerweise kommen manche minderwertige Kopien leicht in den Store und tragen „manuelle Nachprüfung bestanden“.

Vielleicht deshalb sehen viele Indie-Werke auf Xiaohongshu nur iOS-Versionen.

Google Play und App Store bleiben erste Wahl.

> [!TIP]
> Unterstützt Indie-Entwickler und kleine Teams, die am Inlands-Android-Markt festhalten~

<br/>

Für 2024:

- Unvollendetes aus dem vorherigen Plan hierher verschieben: Kalenderintegration, Wiederholungs-Erfolge, Basisfunktionen, Datensystem usw.
- Multi-Plattform wichtiges Ziel, u. a. zwei Richtungen:
  - Flutter-Kopie von LifeUp (begrenzte Kapazität, Backend-Kollege Xiao Xiao)
  - Mehr mit KMP (Kotlin Multiplatform) erkunden

#### 1.2 Nutzerwachstum Inland

2023 deutliches Wachstum im chinesischen App-Markt. Danke für die Unterstützung!

- Automatisierte Zahlung (WeChat, Alipay) und WeChat-Login, um weniger manuelle Einlösecodes und mehr Entwicklungszeit.
  - Das sparte viel Zeit.

- Nutzer-Verbreitung auf Qzone legte den Server wieder tagelang lahm.
- Versuche mit WeChat-öffentlichem Konto, Xiaohongshu, Bilibili usw. für Updates und kreative Nutzung.

- Gespräche mit anderen Indie-Entwicklern: die meisten schließen Instant-Messaging- und Social-Media-Kanäle. Wir verstehen das.
  - Große Firmen haben Support-Teams oder Bots; Indie-Entwickler tragen Support und Operations selbst; unangemessene Nutzer verbrauchen 100 % der Entwicklungszeit — schadet Entwickler, Produkt und Kernnutzern.
  - Deshalb empfehlen wir Feedback per E-Mail usw.

<br/>

Für 2024:

- Weniger manueller Aufwand bei wiederholten Anfragen, stattdessen Doku und FAQ verbessern. Falls Anfragen bleiben, einheitlich per E-Mail, QQ-Kanal usw.
- Wenig Social-Media-Betrieb testen.

#### 1.3 Nutzerwachstum Ausland

Anfang 2022 Google Play Pass, Welle von Nutzerwachstum.

Hielt nicht an; Mitte 2022 Wachstum stark zurück, ohne Besserung.

LifeUp ist Einmalkauf; Wachstum ist wichtig für Fortführung und Chance auf Vollzeit-Entwicklung.

Viele Ansätze getestet:

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Professioneller Designer für Store-Grafiken
- Mehrsprachigkeit in App und Promo-Bildern
- App-Beschreibung verbessert
- Einstiegsdokumentation verbessert
- Update-Frequenz erhöht
- …

Viele Maßnahmen, einige Kennzahlen besser — aber kein stabiles Wachstum.

Mussten es laufen lassen.

<br/>

Gute Nachricht: Ende 2023 scheint es leichte Besserung zu geben.

<br/>

Für 2024:

- Internationalisierung ausbauen (Dokumentation, In-App-Sprachen usw.).

#### 1.4 Qualitätsmanagement

Als Offline-Tool, allein von mir entwickelt und getestet, sind schwere Crashes besonders zu vermeiden.

2023 längerer Iterationszyklus, mehr Beta-Zeit vor Release.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Das scheint großflächige schwere Crashes zu verhindern.

Jedes Update bringt dennoch Probleme, teils auf kritischen Pfaden.

Qualitätsmanagement weiter verbessern, Stabilität wichtigste Kennzahl (besonders bei härterer Umgebung und Review-Herausforderungen).

<br/>

Für 2024:

- Qualitätsmanagement stärken.

#### 1.5 Funktionen vertiefen

Wie im Artikel zum dritten Jahrestag: LifeUp ist schrittweise gewachsen.

Shop, benutzerdefinierte Erfolge, API standen anfangs nicht im Plan, kamen mit Updates und Feedback dazu.

Das brachte Probleme:

- Grobe Planungsdetails in manchen Modulen.
  - Gegenstands-Belohnungen anfangs nur einzelne Belohnungen.
  - Attribute und andere Systeme anfangs ohne Anpassung, nur schrittweise Refaktorierung für Hinzufügen/Löschen und benutzerdefinierte Stufen.
  - Viele ähnliche Fälle, z. B. Attribute-Belohnungs-/Straf-Popups und Verlauf maximal 3.
- Neue Module ohne Gesamtanalyse und Planung für die App.

Wir vertiefen bestehende Module und lösen Pain Points statt neuer Module.

Z. B. direkte Mehrfachauswahl bei Gegenstands-Belohnungen, Backup-Mechanismus, Benachrichtigungen, Widget-Vervollständigung usw.

#### 1.6 API und Erweiterbarkeit

Keine neuen Funktionsmodule geplant.

Erweiterungsbedarf bleibt.

API 2023 eingeführt.

LifeUp-Kern als Basis-Fähigkeit.

Auch ohne Programmierung: Automatisierung mit Tasker/MacroDroid.

Typische Beispiele:

- NFC, QR-Code zum Aufgaben-Abschluss
- Auto-Check-in beim Aufwachen
- Eigene Widgets
- usw.

Mit Programmierung noch mehr Gameplay oder sogar Apps.

![img](_media/development_plan_2024/desktop.png)

Einfache Desktop-Version auf Basis der API (Open Source).

Trotz mehrerer API-Erweiterungen fehlen noch Fähigkeiten.

Z. B. keine „Gedanken“-Operationen, kein Update per Content Provider usw.

2024 API weiter ausbauen, möglichst alle App-Bereiche abdecken.

> Viele nutzen API privat; wenige geteilte lauffähige Produkte. Stärkere API für ein Ökosystem nötig.

#### 1.7 Zur Zukunft

Mit den Problemen und Umgebungsänderungen wurde der Lifetime-Mitgliedschaftspreis schrittweise angepasst (trotzdem deutlich unter den meisten Apps); Updates tendieren zu Mitgliedschafts-Features.

Apps dienen letztlich Kernnutzern.

Feedback und Support von Kernnutzern fließen in Verbesserungen — Co-Creation und positiver Kreislauf.

Wenn man alle bedienen will, wird die App unübersichtlicher Code, entfernt sich von Kernnutzern, senkt Einnahmen und Motivation.

<br/>

KMP (Kotlin Multiplatform) oben erwähnt — relativ neue Cross-Platform-Technologie, kann nativ gemischt werden.

Während der Entwicklung neue Ideen — nicht alle passen zu LifeUp.

Z. B. kompletter UI-Ersatz, große Shop-Logik-Änderungen — schwerer Eingriff für bestehende Nutzer; viele Apps scheiterten an großen Umbauten.

<br/>

Bei Start von LifeUp war Room noch nicht verfügbar; es wurde ein inlandisches Nischen-ORM gewählt.

Jetzt Performance-Probleme, schwer zu ersetzen.

LifeUp unterstützt Material 3 und Legacy Material Design, Dark Mode, Mehrsprachigkeit, Fragmentierung chinesischer Systeme (Kompatibilitäts-Doku wird nur länger; native/overseas meist eine Seite). Jede Seite viele Komplexität.

<br/>

KMP erkunden, ob Technik mit KMP nutzbar ist.

Und Chance, künftig mehr Ideen und neue Projekte umzusetzen — mehr Skills schaden nicht.

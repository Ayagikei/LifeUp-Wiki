# Versionshinweise

## Zeitachse

![timeline](_media/release_log/timeline.png)

## Hinweise

| Plattform          | Version                | Aktualisierungsdatum                 |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.5              | 2026/09/01                  |
| LifeUp-iOS        | check [feature/ulives] | 🎉Alternative App verfügbar |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Ein Teil der Übersetzung wurde maschinell bzw. per KI erstellt und ist möglicherweise ungenau.)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.5 (2026/09/01)**

**🐛 Fehlerbehebungen**

1. **Problem behoben, bei dem sich in bestimmten Fällen abnormale Aufgabendaten ansammeln konnten**: Dadurch konnten Aufgabenoperationen wie Sortieren oder Löschen langsam oder ohne Reaktion sein. Das Update bereinigt betroffene ungültige Daten automatisch und verbessert die Leistung bei großen Aufgabenverläufen.

**v1.105.3 (2026/08/26)**

**🐛 Fehlerbehebungen**

1. **Abnormaler Aufgabenabschluss behoben, wenn eine Teamaufgabe lokal in eine zeitgesteuerte Aufgabe umgewandelt wurde.**

**v1.105.2 (2026/08/24)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Aufgabenauswahl bei ausgewählter Smart-Liste eine leere Liste anzeigt.**
2. **Behoben, dass die Suche in einer Smart-Liste auch Aufgaben anzeigt, die nicht zu dieser Liste gehören.**

**v1.105.1 (2026/08/19)**

**✨ Neue Funktionen**

1. **Benutzerdefinierte Soundeffekte können pro Szene deaktiviert werden**: Einen Hinweis stummschalten, ohne andere zu beeinträchtigen; die Vorschau spielt weiter ab, damit du den Sound prüfen kannst.

**♻️ Optimierung**

1. **Klarere Backup-Hinweise, wenn Google Play-Dienste nicht verfügbar sind**: Wenn Google Drive nicht genutzt werden kann, erklärt die App den Grund und schlägt eine lokale Datei, Dropbox oder WebDAV vor.

**🐛 Fehlerbehebungen**

1. **Behoben, dass „Rückgängig“ auf der Kalenderseite „Abgeschlossen“ keine Wirkung hatte.**
2. **Behoben, dass Kauf-/Nutzungslimits beim Bearbeiten eines Gegenstands nicht wiederhergestellt (oder leer gespeichert) wurden.**

**v1.105.0 (2026/08/04)**

**ℹ️ Wichtiger Hinweis**

1. **Android 6.0 ist jetzt die minimal unterstützte Version**: Um Funktionen und Verhaltensanforderungen neuerer Android-Versionen proaktiv zu unterstützen, wurde die minimal unterstützte Version von Android 5.0 auf Android 6.0 angehoben. Nutzer mit Android 5.x können diese Version nicht installieren oder darauf aktualisieren.

**✨ Neue Funktionen**

1. **URL-Scheme-API zur Pomodoro-Steuerung hinzugefügt**: Status abfragen, Aufgabe auswählen sowie Pomodoro-/Count-up-Sitzungen starten, pausieren, überspringen, abbrechen oder abschließen.
2. **Mechanismus für benutzerdefinierte Aufgabenreihenfolge verbessert**: Neuer Sortiermechanismus hält die benutzerdefinierte Reihenfolge beim Kopieren, Abschließen, Rückgängigmachen und in anderen Grenzfällen stabil.

**♻️ Optimierung**

1. **Android-Predictive-Back-Unterstützung hinzugefügt**: Editoren für Aufgaben, Shop, Synthese und Erfolge unterstützen jetzt die systemseitige Predictive-Back-Geste.
2. **Facebook-Login-Initialisierung verbessert**: Das SDK wird bei Login-Anfrage initialisiert, mit verbesserter Fehlerzustandsbehandlung.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Bearbeitungs-URL-Scheme-Anfragen vorhandene Felder unerwartet überschrieben**: Ausgelassene Felder behalten ihre bisherigen Werte; ungültige Belohnungs- oder Beziehungsparameter löschen vorhandene Daten nicht mehr.
2. **Behoben, dass Benachrichtigungstitel des positiven Timers in bestimmten Grenzfällen nicht der ausgewählten Aufgabe folgten.**
3. **Behoben, dass die RGB-Vorschau nach dem ersten eingefügten Hex-Farbwert nicht aktualisiert wurde.**
4. **Behoben, dass Schatten auf der Auswahl-Symbolleiste in Synthese- und Erfolgsdetailseiten fehlten.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Pomodoro-Sitzungen nach unerwartetem Stopp der App oder des Timer-Dienstes nicht korrekt wiederhergestellt wurden**: Gültige Sitzungen werden jetzt korrekt wiederhergestellt, ungültiger veralteter Zustand wird bereinigt.
2. **Behoben, dass nach einer System-Zeitzonenänderung wiederholt nachgefragt wurde**: Nach Bestätigung der Anpassung werden Aufgabenzeiten korrekt aktualisiert, ohne dieselbe Abfrage erneut anzuzeigen.

**v1.104.5 (2026/07/17)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass in der v1.104.4-Release-Version das Öffnen der Pomodoro-Seite die App zum Absturz bringen konnte.**

**v1.104.4 (2026/07/17)**

**✨ Neue Funktionen**

1. **Gegenstände unterstützen jetzt Kauf-/Nutzungsbeschränkungen basierend auf Attribut-Erfahrungspunkte-Bereichen**: Mindest- und Höchst-Erfahrungspunkte-Bedingungen festlegen, um zu steuern, ob ein Gegenstand gekauft, genutzt oder beides werden kann.
2. **Neue Erfolgsbedingung: Aufgaben an einem Tag insgesamt N-mal abschließen**: Im Gegensatz zur bestehenden Bedingung für unterschiedliche Aufgaben zählt diese jede gültige Aufgabenabschluss an dem Tag, einschließlich wiederholter Abschlüsse derselben Aufgabe.

**♻️ Optimierung**

1. **Pomodoro-Abrechnungs- und Wiederherstellungsablauf neu aufgebaut**: Timer-Zustand, Fokusaufzeichnungen und Belohnungsabrechnung folgen jetzt einem einheitlichen Prozess. Die Wiederherstellung ist auch zuverlässiger, wenn der App-Prozess beendet wird, und reduziert Grenzfälle wie fehlende Fokuszeit. Bei unerwarteten Verhaltensänderungen kontaktiere uns bitte unter lifeup@ulives.io.
2. **Mengenbearbeitung für Synthese-Rezepte flüssiger**: Tippe auf eine vorhandene Zutat oder ein Ergebnis, um die Menge direkt zu bearbeiten, ohne denselben Gegenstand erneut auszuwählen. Bei Bedarf kann der Gegenstand weiterhin neu ausgewählt werden.
3. **Pomodoro kann jetzt direkt von der Startseite im Querformat geöffnet werden**: Timer in horizontaler Ansicht bequemer ansehen und bedienen.

**v1.104.3 (2026/07/09)**

**✨ Neue Funktionen**

1. **Neue „Schnelleinrichtung“-Anleitung auf dem Willkommensbildschirm**: Zwei neue Seiten (5 und 6) nach den Intro-Karten ermöglichen die Konfiguration von Benachrichtigungsberechtigungen, Erinnerungsmethode, UI-Stil (Material 2/3) und Multi-Window-Anzeige direkt beim Onboarding — mit Akkordeon-Karten. Alle Optionen können später in den Einstellungen angepasst werden.

**♻️ Optimierung**

1. **Intro-Text der Willkommensseite aktualisiert**: Seiten 1–4 wurden überarbeitet, um den Kernwert der App besser zu vermitteln: individuelle Aufgaben → Statistikwachstum → Belohnungssystem → Verbindung mit der Welt.
2. **Synthese-Dialog als Bottom Sheet neu gestaltet**: Materialien und Ergebnisse werden jetzt in einem vertikalen Raster angezeigt — übersichtlicher und intuitiver.
3. **Schnelleres Laden beim Wechsel zwischen To-do-Listen, Ändern der Sortierung oder Umschalten der Gruppierungseinstellungen**.

**🐛 Fehlerbehebungen**

1. **Behoben, dass doppelte „Erfolg freigeschaltet“-Benachrichtigungen** für bestimmte System-Erfolge erschienen.
2. **Behoben, dass die Zählung für den Erfolg „Täglich N unterschiedliche Aufgaben abschließen“ ungenau war**: Unbegrenzte Aufgaben werden nicht mehr ausgeschlossen; mehrfaches Abschließen derselben Aufgabe am selben Tag zählt jetzt als eins.
3. **Behoben, dass der Hinzufügen-Button (+) in der Aufgabenliste gelegentlich von seiner korrekten Position abrutschte**.
4. **Behoben, dass Smart-Listen archivierte Aufgaben nicht herausfilterten, wenn „Nach Liste gruppieren“ deaktiviert war**.

**v1.104.2 (2026/07/03)**

**✨ Neue Funktionen**

1. **„Nutzungstage“ auf der Statistikseite in „Begleittage“ umbenannt**: Tippe auf die Karte, um das Startdatum anzupassen und deinen eigenen Jahrestag festzulegen. Zugehörige Erfolgsbedingungsbeschreibungen verwenden ebenfalls die „Begleit“-Formulierung.
2. **Option „Backup & Teilen“ im Backup-Menü hinzugefügt**: Backup-Dateien direkt über das System-Freigabefeld an andere Apps senden.
3. **Lootbox-Effekt-API v2**: Eine neue `loot_box/v2`-Route unterstützt präzises Gegenstands-Matching über `sub_amount`, Hinzufügen/Entfernen von Gegenständen sowie unabhängige Steuerung von Mengen- und Wahrscheinlichkeitsmodi.

**♻️ Optimierung**

1. **URL Scheme priorisiert jetzt exakte Namensübereinstimmung** beim Bearbeiten von Shop-Gegenständen, Lootboxen oder Unteraufgaben und fällt nur bei fehlender exakter Übereinstimmung auf unscharfes Matching zurück — verhindert unbeabsichtigte Bearbeitungen.
2. **Seitenleiste „FAQ“ im Englischen in „Notice“ umbenannt**: Die chinesische Version war bereits „公告“ und bleibt unverändert.
3. **Button-Ripple-Effekte passen überall zum Eckenradius**: Ripple-Animationen auf abgerundeten Steuerelementen laufen nicht mehr über die Ecken hinaus — Tippen wirkt in der gesamten App polierter.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Pomodoro-Seite die Tomatenanzahl nach Hinzufügen oder Bearbeiten eines Eintrags nicht automatisch aktualisierte.**
2. **Behoben, dass der Toast mit verdienten Tomaten nach Hinzufügen eines Pomodoro-Eintrags gelegentlich nicht erschien.**
3. **Behoben, dass manuell hinzugefügte Pomodoro-Einträge Tomaten basierend auf der aktuell ausgewählten Aufgabe statt der in dem Eintrag gewählten Aufgabe berechneten**: Die Berechnung nutzt jetzt die aufgabenspezifische Fokusdauer der tatsächlich im Eintrag ausgewählten Aufgabe. Bei unterschiedlichen Fokusdauern pro Aufgabe sind manuell erfasste Tomaten jetzt genauer.
4. **Behoben, dass die „Abschlussanzahl“ für unbegrenzte Aufgaben im Verlauf falsch angezeigt wurde**: Jetzt als Tagesordinalzahl (z. B. „das N-te Mal an dem Tag“).
5. **Behoben, dass Motivationstext bei Strafaufgaben nicht erschien** — er erscheint jetzt nach Abschluss der Strafe.

**v1.104.1 (2026/06/17)**

**✨ Neue Funktionen**

1. **Erweiterte Backup-Exportoptionen**: Beim manuellen Backup ermöglicht ein neues Bottom Sheet die Auswahl, ob Mediendateien, kontosensitive Infos (Login-Status, WebDAV-Zugangsdaten usw.) und Emoji-Bilder einbezogen werden — erleichtert das Teilen eines bereinigten Backups. Im automatischen Backup-Bereich gibt es drei entsprechende dauerhafte Schalter.
2. **Verbesserte Pomodoro-Aufgabenauswahl**: Zeitgesteuerte Aufgaben erscheinen jetzt zuerst in der Aufgabenauswahl mit ihrem aktuellen Fokusfortschritt (Fokusdauer / Zieldauer / Prozent). Ein Schalter aktiviert oder deaktiviert die Priorisierung zeitgesteuerter Aufgaben für schnellen Zugriff.
3. **About-Seite neu gestaltet**: Die About-Seite ist in Links, Feedback, Community und Entwickler unterteilt, mit neuen Einträgen für Website, Release Log, FAQ und API-Dokumentation. Nutzer vereinfachten Chinesisch erhalten einen Tencent-Channel-Eintrag, internationale Nutzer Zugang zu GitHub Issues/Discussions.
4. **Follower entfernen**: Follower können jetzt auf der Teammitglieder-Seite entfernt werden.
5. **Shop-Attributauswahl verbessert**: Ein Attributauswahl-Button wurde zum Shop-EP-/Effekt-Eingabedialog hinzugefügt, mit schnellem Filtern nach Fähigkeitsgruppe und Mehrfachauswahl im Batch — deutlich einfacher bei vielen Attributen.

**♻️ Optimierung**

1. **Pomodoro-Statistiken unterstützen jetzt Wechsel des Zeitformats**: Tippe auf den Pomodoro-Statistikbereich in der Aufgabendetailseite, um zwischen „Stunden/Minuten“, „Tage/Stunden/Minuten“ und „Gesamtminuten“ zu wechseln.
2. **Klarerer Abschlusszustand von Unteraufgaben**: Abgeschlossene Unteraufgaben werden durchgestrichen — der Unterschied zwischen erledigt und offen ist deutlicher.
3. **Pomodoro-Eintragssortierung behoben**: Pomodoro-Einträge werden jetzt nach Endzeit absteigend sortiert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass der ATM-Abhebungs-Buttontext in mehreren Sprachen fehlerhaft war**: Falsche Gerundium-Nutzung im ATM-Abhebungs-Buttontext in einigen Locales korrigiert.
2. **Behoben, dass das Teilen von Shop-Gegenständen ohne Login fehlerhaft war**: Abnormales Verhalten beim Teilen von Shop-Gegenständen ohne Anmeldung behoben.
3. **Behoben, dass der Farbwähler einen falschen Auswahlzustand anzeigte.**

**v1.104.0 (2026/05/23)**

**✨ Neue Funktionen**

1. **Zählaufgaben unterstützen jetzt proportionale Echtzeit-Belohnungsabrechnung**: Nützlich für Aufgaben, die du innerhalb eines Zyklus flexibel mehrfach vorantreibst, etwa Gewohnheiten, die ein paar Mal pro Woche erledigt werden. Bei Änderung des Zählfortschritts kann LifeUp Erfahrungspunkte, Münzen und Gegenstands-Belohnungen entsprechend dem aktuellen Fortschritt gewähren oder zurücknehmen, statt bis zum endgültigen Abschluss zu warten.
2. **Verlaufswerkzeuge in Aufgabendetails leistungsfähiger**: Die Auswahl eines Datums im Verlaufskalender zeigt jetzt die Anzahl für diesen Tag; Verlaufseinträge können hinzugefügt, bearbeitet oder im Batch erstellt werden.
3. **Gefühle und Gegenstände besser verknüpft**: Gegenstandsdetails können direkt zu zugehörigen Gefühlen springen; die Gefühle-Seite unterstützt Filtern nach Shop-Gegenstand.
4. **Abschlusszeiten von Unteraufgaben werden jetzt erfasst**: LifeUp speichert, wann jede Unteraufgabe abgeschlossen wurde — als Vorbereitung für künftige API- und LifeUp-Cloud-Unterstützung.

**♻️ Optimierung**

1. **Präzisere Sichtbarkeitsfilter für Shop-Gegenstände**: Zusätzlich zu ausverkauften Gegenständen können jetzt kauf-deaktivierte, kaufbeschränkte oder derzeit unerschwingliche Gegenstände ausgeblendet werden. Shop-Widgets folgen denselben Regeln.
2. **Aufgabenlistensuche und -aktualisierung stabiler**: Normale Listensuche kann abgeschlossene Aufgaben einschließen, die laut Einstellungen sichtbar sind; wiederholte Aufgabenaktualisierung plus benutzerdefinierte Sortierung in der Alle-Liste ist bei vielen Aufgaben stabiler.
3. **Verlaufsstatistiken in Aufgabendetails folgen jetzt dem ausgewählten Datum**: Zählaufgaben und unbegrenzte Aufgaben nutzen unterschiedliche Beitragskarten-Farbstufen je nach Tagesabschlussanzahl. Monats-, Jahres-, Gesamt- und Streak-Statistiken unter der Verlaufsansicht werden vom ausgewählten Datum berechnet, nicht mehr immer von heute.
4. **Intuitivere alphabetische Sortierung**: Alphabetische Sortierung in Modulen folgt jetzt natürlicher numerischer Ordnung — Namen mit Zahlen werden nach numerischem Wert statt Zeichen-für-Zeichen sortiert.
5. **Verbessertes Eingabeverhalten in Shop-Einstellungen**: Shop-Einstellungen scrollen fokussierte Eingaben über die Bildschirmtastatur.
6. **Zuverlässigere System-Dunkelmodus-Behandlung**: Zustands-Race-Conditions zwischen System-Theme und manuellem Nachtmodus-Schalter behoben.
7. **Erweiterte URL-Scheme-API-Unterstützung**: Aufgabe hinzufügen/bearbeiten unterstützt jetzt die `no_deadline`-Semantik; Zählaufgaben-APIs unterstützen das Echtzeit-Abrechnungsflag.
8. **Klarere Zinsverlaufseinträge**: ATM- und Kredit-Zinseinträge zeigen jetzt Kapital und Zinstage — die Zinsquelle ist leichter nachvollziehbar.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Erfolgsstatistiken auf Meine Seite falsch waren**: Wenn System-Erfolge ausgeblendet sind, folgen Erfolgszähler jetzt derselben Sichtbarkeitsregel.
2. **Behoben, dass Verlaufseinträge falsch formuliert waren**: Aufgeben-Verlaufseinträge werden nicht mehr mit Überfälligkeitsstrafe-Formulierung angezeigt.
3. **Behoben, dass lange Texte in URL-Scheme-APIs zu früh abgeschnitten wurden**: Lange Beschreibungen für Fähigkeiten und Erfolge werden nicht mehr zu früh gekürzt.

**v1.103.6 (2026/05/10)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass der Hinweis zum langen Pausenintervall nach Tippen auf Aufgeben nicht auf den anfänglichen Fokussitzungszustand zurückgesetzt wurde.**
2. **Behoben, dass der zusätzliche Fokus-Timer nach Tippen auf Aufgeben sichtbar bleiben und weiterzählen konnte.**

**v1.103.5 (2026/05/10)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass der Pomodoro-Timer-Hinweis zur langen Pause nach natürlichem Ende einer Arbeitsphase nicht umgehend aktualisiert wurde.**
2. **Behoben, dass der Pomodoro-Timer vor dem Öffnen der Pomodoro-Einstellungen das alte 2-Sitzungen-Intervall für lange Pausen anzeigen konnte, statt der Standard-4-Sitzungen.**

**v1.103.4 (2026/05/05)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Aufgaben in manchen Grenzszenarien durch abnormale Unterbrechung im eingefrorenen Zustand verschwinden konnten.**

**v1.103.3 (2026/05/05)**

**ℹ️ Versionshinweis**

1. **Diese Version wurde übersprungen und nicht öffentlich veröffentlicht.**

**v1.103.2 (2026/04/30)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Eingabefelder beim Bearbeiten von Kauf-/Nutzungsbeschränkungen für Gegenstände unter bestimmten Sprachen oder kleineren Bildschirmgrößen möglicherweise nicht erschienen.**
2. **Behoben, dass die Nutzung eines Gegenstands fälschlich einen Strafdialog auslösen konnte.**

**v1.103.1 (2026/04/25)**

**🐛 Fehlerbehebungen**

1. **Abnormales Verhalten behoben, wenn der Nutzungseffekt eines Gegenstands seine eigene Menge ändert**
2. **Einige aus dem Produktionsbetrieb erfasste Abstürze und Verzögerungen behoben**
3. **Behoben, dass beim Bearbeiten des Effekts „Gegenstandsmenge ändern“ falsche Mengenwerte zurückgefüllt wurden**

**v1.103.0 (2026/04/12)**

**✨ Neue Funktionen**

1. **Attribute unterstützen jetzt Unterkategorien und Schnellverschieben**: Attribute klarer gruppieren und ein Attribut schneller in eine Zielgruppe verschieben.
2. **Flüssigere Attributauswahl**: Aufgabenbearbeitung, belohnungsbezogene Abläufe und andere Attributauswahlen sind bei vielen Attributen leichter zu durchsuchen.
3. **Gegenstände unterstützen jetzt Kauf-/Nutzungsbeschränkungen**: Limits können für Kauf, Nutzung oder beides gelten, mit reicheren Bedingungen wie Zeit, freigeschaltete Erfolge, abgeschlossene Aufgaben, Anzahl besessener Gegenstände und Attribut-Stufen-Bereiche.
4. **Erfolge mit mehr integrierten Sortieroptionen**: Zusätzlich zur benutzerdefinierten Reihenfolge unterstützen Erfolgslisten jetzt integrierte Sortierung nach Alphabet, Abschlusszeit und Erstellungszeit.
5. **Erfolge unterstützen Schnellverschieben in Unterkategorien**: Einen oder mehrere Erfolge effizienter in eine Ziel-Unterkategorie verschieben.
6. **Überfälligkeitsbehandlung mit Hilfeeintrag**: Der Überfälligkeitsdialog enthält jetzt einen Hilfeeintrag und zeigt Belohnungsänderungen klarer an, wenn eine überfällige Aufgabe wieder auf abgeschlossen gesetzt wird.

**♻️ Optimierung**

1. **Gruppierte Attributanzeige klarer**: Statusseite und Attributbeschreibungsdialoge präsentieren gruppierte Attribute strukturierter.
2. **Attributbezogene Interaktionen konsistenter**: Gruppierte Anzeige und Auswahlverhalten sind in Attributdialogen und zugehörigen Bearbeitungsabläufen einheitlicher.
3. **Bearbeitung von Gegenstandsbeschränkungen leichter verständlich**: Reichere Beschränkungstypen sind einfacher zu konfigurieren und zu prüfen.
4. **Statusleiste und obere Leiste auf mehreren Seiten stabiler**: Obere Bereiche auf Seiten wie Shop, World, Suche, Status, Erfolge, Meine Seite und WebDAV verhalten sich beim Scrollen, im Dunkelmodus und unter Material You konsistenter.
5. **Attributlayout auf der Statusseite verarbeitet längere Texte besser**: Längere Attributnamen und Stufen-Labels passen zuverlässiger, auch auf schmalen Bildschirmen oder mit größerer Schrift.

**🐛 Fehlerbehebungen**

1. **Behoben, dass kopierte Aufgaben aus einmaligen oder unbegrenzten überfälligen Aufgaben inkonsistente gids hatten.**
2. **Behoben, dass in der Attributauswahl eine nicht funktionierende „Zufällig“-Checkbox angezeigt wurde.**
3. **Behoben, dass Belohnungsbanner falsch positioniert, verdeckt oder springend waren** (besonders bei Auslösung durch Aufgabenabschluss).
4. **Behoben, dass Überfälligkeits-Belohnungsvorschau/-Animation in manchen Fällen ungenau war**: Beim Zurücksetzen einer überfälligen Aufgabe auf abgeschlossen werden Erfahrungspunkte-, Münz- und Gegenstandsänderungen genauer dargestellt, ohne verwirrende Werte.
5. **Behoben, dass Stufenlayout auf der Statusseite in manchen Fällen umbrach oder falsch ausgerichtet war**: Layout ist bei langen Attributnamen oder längeren Stufen-Labels stabiler.
6. **Behoben, dass Seitenwechsel bei kurzer Synthese-Liste schwierig war**: Horizontal wischen aus leeren Bereichen funktioniert bei kurzem Listeninhalt zuverlässiger.
7. **Behoben, dass das Einlösen von Erfolgsbelohnungen in Sonderfällen abstürzen konnte.**

**v1.102.11 (2026/04/02)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Zählaufgaben auf der Startseite gelegentlich Abrechnungsfehler und Aktualisierungsanomalien hatten.**

**v1.102.10 (2026/03/24)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass ausgeblendete Synthese-Rezeptlisten nicht per Long-Press zum Bearbeiten oder Löschen von Rezepten genutzt werden konnten.**

**v1.102.9 (2026/03/23)**

**♻️ Optimierung**

1. **Regel zum Deaktivieren der unteren Navigation aktualisiert**: Auf Interaktionsebene können Nutzer nicht mehr alle Module der unteren Navigation deaktivieren.

**🐛 Fehlerbehebungen**

1. **Startabsturz behoben**: Behoben, dass die App nach Deaktivieren aller Module der unteren Navigation beim Start abstürzen konnte.

**v1.102.8 (2026/03/23)**

**✨ Neue Funktionen**

1. **Standard-Modullayout zurücksetzen**: Button „Standardlayout wiederherstellen“ auf der Modulkonfigurationsseite hinzugefügt.
2. **Neues Broadcast-Ereignis für Synthese-Rezepte**: API-Broadcast-Ereignis `app.lifeup.synthesis.complete` hinzugefügt, gesendet bei erfolgreichem Abschluss eines Synthese-Rezepts.
3. **World-Suche unterstützt Quell-Tags-Filterung**: Der World-Bereich kann jetzt nach Quell-Tags suchen, z. B. API-Gegenstände in Showcase vor der Suche filtern.

**♻️ Optimierung**

1. **Typografie des Erfolgs-Freischalt-Popups verbessert**: Schriftdarstellung verbessert und Layoutprobleme bei großen Systemschriftgrößen reduziert.
2. **Logik zum Ausblenden von Modulen verbessert**: Verfeinertes Verhalten, damit World-bezogene Erfolge korrekt ein- oder ausgeblendet werden.
3. **Standard-Zuweisungsverhalten für Zufallsaufgaben angepasst**: Neu erstellte Zufallsaufgaben werden nicht mehr automatisch der Standardliste zugewiesen — vermeidet stille Zuweisung.

**🐛 Fehlerbehebungen**

1. **Behoben, dass ein seltener Absturz bei Aufgabenlistenaktualisierung auftreten konnte.**
2. **Behoben, dass die Gefühle-API den Titel nicht korrekt liefern konnte**, was auch Gegenstandstitel beeinflussen konnte.
3. **Behoben, dass das Pomodoro-Querformat-Layout Probleme hatte.**
4. **Behoben, dass der Endzeit-Zeitstempeltyp in der Aufgabenverlaufs-API falsch war.**
5. **Fehlende API-Antwortfelder hinzugefügt**: Aufgabenfortschritt, Abschlussstatus, Wiederholungs-Endbedingungen und zugehörige Felder werden jetzt korrekt zurückgegeben.
6. **Behoben, dass auf der Zählaufgaben-Detailseite veraltete Werte angezeigt wurden**: Werte aktualisieren sich sofort nach Änderung der Zählaufgabe.
7. **Behoben, dass Pomodoro-Eintragsdauern abnormal sein konnten.**
8. **Behoben, dass die Startseite nach Wechsel in den Offline-Modus nicht sofort neu aufgebaut wurde**: Der World-Bereich konnte zuvor unerwartet sichtbar bleiben.
9. **Behoben, dass die Zufallsaufgaben-Seite in manchen Fällen im Ladezustand hängen blieb.**

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Optimierung**

1. **Widget-Hinzufügen-Tutorial + Textverbesserungen**: Anleitung zum Hinzufügen von Widgets ergänzt; zugehörige Texte und Hinweise verfeinert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Pomodoro bei abnormalen Daten blockierte**: Die Pomodoro-Seite friert bei abnormalen Daten nicht mehr ein.
2. **Behoben, dass der Zusatz-Timer nach Bildschirm aus desynchronisierte**: Der „Zeit hinzufügen“-Timer bleibt nach Bildschirm aus oder Geräteschlaf synchron.
3. **Behoben, dass die Standardlistenauswahl für neue Aufgaben fehlerhaft war**: Verbesserte Behandlung beim Erstellen von Aufgaben aus Smart-Listen, besonders wenn die Standardliste archiviert ist (fällt jetzt korrekt zurück).

**v1.102.1 (2026/01/27)**

**✨ Neue Funktionen**

1. **Bildvorschau-Zoom**: Die beim Seiten-Refactoring verlorene Bild-Zoom-Funktion wiederhergestellt — Bilddetails leichter ansehen.

**🐛 Fehlerbehebungen**

1. **WebDAV-Speicheroptimierung**: Behoben, dass WebDAV-Downloads übermäßig viel Speicher verbrauchen konnten und Abstürze oder Performance-Probleme verursachten.
2. **Reflections-Bildaktualisierung**: Behoben, dass bearbeitete Bilder auf der Reflections-Seite nicht sofort aktualisiert wurden.

**v1.102.0 (2026/01/25, replaced by v1.102.1 during rolling release)**

**✨ Neue Funktionen**

1. **Sound-Manager**: Soundeffekte importieren, vorhören, löschen und wiederverwenden sowie als Gegenstands-Nutzungseffekte einsetzen.
2. **Shop: neue Gegenstands-Nutzungseffekte**: Zufällige Erfahrungspunkte, Bestandsänderungen, Soundwiedergabe hinzugefügt; Konfigurationsablauf verbessert.
3. **Zeitgesteuerte Aufgaben**: Neuer Aufgabentyp mit erwarteter Fokusdauer; Aufgabe abschließen, nachdem das Timerziel erreicht ist.
4. **Optionen für Wochenstart**: Montag / Samstag / Sonntag wählen — Kalender und Statistiken folgen.
5. **Onboarding überspringen**: Option, das Tutorial beim ersten Start zu überspringen.
6. **Emoji-Eingabe für Symbole**: Emoji (einschließlich kombinierter Emojis) eingeben, um schnell ein Symbol zu erstellen.
7. **Kalender: Details zukünftiger wiederkehrender Aufgaben öffnen**: Tippen auf eine wiederkehrende Aufgabe an einem zukünftigen Datum öffnet jetzt korrekt ihre Details.
8. **Power-User: API-Erweiterungen**: Die URL-Scheme-API ergänzt/erweitert Aufgabenvorlagen-CRUD, Wiederholungs-Endbedingungen, Synthese-Filter-Navigation und mehr.

**♻️ Optimierung**

1. **Performance- und Flüssigkeitsverbesserungen**: Datenzugriff und Indexierungsstrategien optimiert — Aufgabenlisten, Inventarverlauf und Statistiken sind bei großen Datenmengen flüssiger.
2. **Bessere UX für Gegenstandseffekt-Konfiguration**: Effektauswahl und -anzeige verbessert; Dialoge und Symbol-Darstellung verfeinert.
3. **Lokalisierungsverbesserungen**: Fehlende Übersetzungen in mehreren Sprachen ergänzt.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Countdown-Effekt beim Bearbeiten auf 1 zurückgesetzt wurde**: Bestätigen eines bearbeiteten Countdown-Effekts setzte den Wert auf 1 zurück.
2. **Behoben, dass Auto-Nutzung bei Teamaufgaben-Gegenstandsbelohnungen nicht ausgelöst wurde**: Auto-Nutzung nach Einlösen von Gegenstandsbelohnungen für Teamaufgaben funktioniert jetzt.
3. **Behoben, dass „Gefühle aufzeichnen“-Aufforderung nach Lootbox/Synthese fehlte**: Gefühle-Dialog erschien nicht nach Öffnen von Lootboxen oder einfacher Synthese, wenn der Gegenstand einen „Gefühle aufzeichnen“-Effekt hat.
4. **Behoben, dass manueller Abschluss auf der Pomodoro-Seite Abrechnungsdialoge übersprang**: Belohnungs-/Gefühle-Abrechnungsdialoge werden wieder angezeigt; Long-Press-Abschluss auf dem Aufgabentitel wiederhergestellt.
5. **Behoben, dass Widget-Faltfilter nicht wirkte**: Smart-Listen-Widget-Filter „Aufgaben falten, die noch nicht begonnen haben“ wirkte nicht.
6. **Behoben, dass ein seltener Absturz durch zu viel gespeicherten Zustand in bestimmten Situationen auftrat.**
7. **Behoben, dass Kalender→Detail-Navigation für zukünftige Aufgaben fehlschlug**: Details zukünftiger wiederkehrender Aufgaben aus der Kalenderansicht öffnen funktioniert jetzt.
8. **Behoben, dass Ebbinghaus-Wiederholungsaufgaben Probleme hatten**: Abnormale Stufen und unbeabsichtigte wiederholte Generierung in seltenen Fällen behoben; Obergrenzen-Sicherung hinzugefügt.

**v1.101.8 (2026/01/12)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Endbedingungen für Wiederholungen nicht gesetzt werden konnten**: Endbedingung ließ sich nicht für „Alle 2 Tage“ oder benutzerdefinierte „Alle N Tage“-Frequenzen festlegen.
2. **Behoben, dass Pomodoro-Timer-Dauer abnormal war**: Timer konnte bei System-Schlaf oder Prozess-Freeze deutlich länger laufen als erwartet, wenn Batterieoptimierung nicht ordnungsgemäß deaktiviert war.

**v1.101.7 (2026/01/11)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Pomodoro-Timer-Dauer abnormal verkürzt werden konnte.**

**v1.101.6 (2026/01/10)**

**🐛 Fehlerbehebungen**

1. **Anomalien beim Wechsel des System-Dunkelmodus behoben.**

**v1.101.5 (2026/01/08)**

**♻️ Optimierung**

1. **System-Dunkelmodus-Wechsel optimiert**: Behoben, dass die App das Theme nicht automatisch mit den Systemeinstellungen wechseln konnte.
2. **Attributauswahl für Belohnungen optimiert**: Verbesserte Behandlung, wenn in „Ausdauer-Belohnungen“, „Stufen-Belohnungen“ und „Like-Belohnungen“ kein Attribut ausgewählt ist. Abwählen von Attributen unterstützt; Erfahrungspunkte-Belohnungen wurden nicht korrekt gewährt.
3. **Performance-Konfiguration optimiert**: Interne Konfigurationen optimiert, um die App-Performance potenziell zu verbessern.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Statistikabfragen und Diagrammanzeige fehlerhaft waren**: Abfragebedingungen für Aufgabenabschlusszeit-Statistiken korrigiert; ungenaue Diagrammdaten behoben.
2. **Behoben, dass im Widget-Einstellungsdialog der „Bestätigen“-Button fehlte**: Fehlender Button im Widget-Aufgabenfilter-Einstellungsdialog behoben.
3. **Behoben, dass Aufgabenanzahl-Synchronisation fehlerhaft war**: Aufgabenanzahl auf dem Startbildschirm aktualisierte sich nach Änderung auf der Aufgabendetailseite nicht korrekt.
4. **Behoben, dass die Gefühle-API „Gegenstand nutzen“-Typen falsch behandelte.**
5. **Behoben, dass Kalender→Detail-Navigation Probleme hatte**: Mehrere Probleme bei Navigation von der Kalenderansicht zu Aufgabendetails behoben.

**v1.101.4 (2025/12/30)**

**♻️ Optimierung**

1. **Mitglieder-Update-Erkennung optimiert**: Mitglieder werden aufgefordert, für Updates zum „Mitglieder-Stabilkanal“ zu wechseln, um die stabilste Funktionserfahrung zu gewährleisten.
2. **Unnötige Netzwerkanfragen reduziert**: Spart weiter Nutzerdaten und senkt Serverkosten.

**🐛 Fehlerbehebungen**

1. **Erfolgsfortschritt-Update behoben (Priorität)**: Behoben, dass Erfolgsfortschritt nach Abschluss von Pomodoro-Einträgen nicht korrekt ausgelöst wurde.

**v1.101.3 (2025/12/14)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Option „Heute fällig“ den Fristversatz auf den nächsten Tag fälschlich ignorierte.**

**v1.101.2 (2025/12/13)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass der Suchzustand beim Zurückkehren zu Shop-, Inventar- oder Aufgabenseiten zurückgesetzt wurde.**
2. **Absturz im Zusammenhang mit `AlarmManager`-Limits behoben** (ca. 500 gleichzeitige Alarme).
3. **Abstürze im Zusammenhang mit dynamischen Farben, Zeitzonen-Dialogen und Pop-up-Menüs behoben.**
4. **Absturzberichte optimiert**, sodass häufige Netzwerkfehler ignoriert werden.

**v1.101.1 (2025/12/01)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Formatierungsfehler in Übersetzungen potenzielle Abstürze verursachen konnten.**

**v1.101.0 (2025/11/29)**

**✨ Neue Funktionen**

1. **Synthese-Gegenstandsfilter**: Synthese nach Gegenständen filtern für schnellere Suche und Verwaltung.
2. **Gegenstandsdetails → Synthese-Rezept**: Synthese-Rezept eines Gegenstands direkt auf der Gegenstandsdetailseite ansehen.
3. **Shop → Synthese-Einstieg**: Wenn ein Gegenstand in der Synthese nutzbar ist, erscheint neben dem Kauf-Button ein Synthese-Button.
4. **Inventarverlauf-Filter**: Filter nach Datum, Gegenständen und Beschreibung hinzugefügt.
5. **„Was ist neu“-Dialog**: Highlights der neuen Version beim ersten Start nach dem Update.
6. **Pomodoro-Fokuszeit pro Aufgabe**: Pomodoro-Logik überarbeitet; unterstützt benutzerdefinierte Fokusdauer pro Aufgabe.
7. **Gegenstands-Nutzungseffekt: „Gefühle nach Nutzung aufzeichnen“**; die Gefühle-Seite unterstützt auch Filtern nach Gegenstand.
8. **Pomodoro-Lifecycle-Broadcasts (API)**: Lifecycle-Broadcast-Ereignisse hinzugefügt.
9. **Einfache Query-API**: Unterstützt jetzt das Abrufen der Details einer einzelnen Aufgabe.
10. **Zählaufgaben Auto-Inkrement**: Unterstützt automatisches Inkrementieren.
11. **Wiederholungsende per Datum**: Aufgaben unterstützen das Beenden der Wiederholung an einem bestimmten Datum.
12. **Desktop-Widget-Einstellungen verbessert**: Die App-interne Desktop-Widget-Einstellungsseite wurde verbessert — jedes unterstützte Widget kann in der Vorschau angezeigt und, wenn das System es erlaubt, schnell zum Startbildschirm hinzugefügt werden.

**♻️ Optimierung**

1. **Listenverwaltung UX + Dunkelmodus**: Interaktionen und Dunkelmodus verfeinert; die Liste „Alle“ zeigt jetzt einen deaktivierten Löschzustand statt einer nicht löschbaren Aktion.
2. **Shop-Einstellungsseite**: In eine eigene Seite verschoben und über die Haupteinstellungen erreichbar.
3. **Standard-Hintergrund für Aufgaben**: Formulierung im Hilfedialog präzisiert.
4. **„Schnell abschließen“-Indikator**: Wenn aktiviert, zeigt die Aufgabenseite oben den Status von „Schnell abschließen“ an.
5. **Einklapp-Zustand pro Liste**: Einklapp-/Ausklappzustand wird pro Liste gespeichert, damit „Alle“ die Tagesliste nicht beeinflusst.
6. **Überfälligkeitsdialog (Dunkelmodus)**: Dunkelmodus-Stile beim Bearbeiten überfälliger Aufgaben verbessert.
7. **Gefühle-Filterbutton-Logik**: Wird nur für Typen angezeigt, die Filtern unterstützen (Gegenstände/Aufgaben).
8. **Team-Flow nur lokale Aufgaben**: Interaktion verbessert, wenn nur lokale Aufgaben gesammelt werden.
9. **Synthese-Seite UI verfeinert**: Layout und visuelles Feedback auf der Synthese-Seite für flüssigere Darstellung optimiert.
10. **Gegenstands-Interaktionen verfeinert**: Gegenstandsbezogene Interaktionen für reaktionsschnelleres Gefühl optimiert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die obere Filterleiste nach dem Filtern auf der Verlaufsseite nicht korrekt angezeigt wurde.**
2. **Behoben, dass Strafaufgaben in manchen Fällen Strafen mit falscher 1×-Strafanzahl berechneten.**
3. **Behoben, dass die Aufgabenauswahl des Pomodoro-Timers unter bestimmten Bedingungen die Option „Auswahl aufheben“ verlieren konnte.**
4. **Mehrere Probleme beim Folgen der System-Dunkelmodus-Einstellungen behoben.**
5. **Behoben, dass bei Widget-Abschluss einer Zählaufgabe kein Belohnungs-Popup erschien.**

**v1.100.6 (2025/11/08)**

**🐛 Fehlerbehebungen**

1. **Absturz beim Auswählen von Gegenständen behoben**, wenn Eingabefokus durch externe Tastaturen/Gamepads überlief; Wirksamkeit der Korrektur wird noch geprüft.
2. **Behoben, dass der intelligente Zeitzonen-Verwaltungsdialog scrollen kann**, um unteren Inhalt und Buttons anzuzeigen.

**v1.100.5 (2025/09/28)**

**✨ Neue Funktionen**

1. **Benutzerdefinierte Soundeffekte unterstützen jetzt integrierte Soundauswahl**: Zugriff auf eine Bibliothek integrierter Audioeffekte für bequemere Anpassung.
2. **Synthese-Filterung erweitert**: Filteroption „Nur synthetisierbare anzeigen“ auf der Synthese-Seite für bessere Gegenstandsverwaltung.
3. **API-Emoji-Unterstützung**: Gegenstands-, Attribut- und Erfolgs-APIs unterstützen jetzt direkte Emoji-Eingabe.
4. **Team-Erstellung verbessert**: Beim Erstellen von Teams können Ziellisten ausgewählt werden.
5. **Teamaufgaben kopieren**: Teamaufgaben als lokale Aufgaben kopieren, ohne Teammitgliedschaft zu benötigen.
6. **Aufgaben-API erweitert**: Parameterunterstützung für den Zustand „helle Notizschrift“ in aufgabenbezogenen APIs.

**♻️ Optimierung**

1. **„Änderungen verwerfen“-Logik verbessert**: Bestätigungsdialog beim Bearbeiten von Gegenständen, Synthese, Erfolgen und Erfolgslisten optimiert — erscheint nur bei tatsächlichen Änderungen.
2. **Erfolgs-Freischaltbedingungen**: Freischaltbedingungen werden standardmäßig ausgeklappt angezeigt.
3. **Synthese-Performance verbessert**: Abfrageperformance auf der Synthese-Detailseite optimiert.
4. **Toast-API-Stabilität**: Stabilität und Zuverlässigkeit von Toast-API-Aufrufen verbessert.
5. **Teamaufgaben-Abschlussablauf**: Abschlussprozess mit besserer Fehlerbehandlung und Nutzerführung verbessert.
6. **Synthese-Drag-Verhalten**: Scrollen zum Rand beim benutzerdefinierten Sortieren auf der Synthese-Seite verbessert.
7. **Teamaufgaben-Sammelablauf**: Ablauf nach dem Sammeln von Teamaufgaben mit Sprung zu entsprechenden Listen verbessert.
8. **Kalender-Erinnerungen optimiert**: Kalender-Erinnerungslogik für bessere Zuverlässigkeit verbessert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass benutzerdefinierte Hintergründe älterer Versionen fälschlich den globalen Standardzustand „helle Notizschrift“ nutzten.**
2. **Statusleisten-Anpassung auf der Seite für benutzerdefinierte Soundeffekte behoben.**
3. **Behoben, dass Erfolgsbeschreibungen mit Freischalt-Buttons überlappen konnten.**
4. **Scrollprobleme beim Drag-Sortieren auf der Synthese-Detailseite behoben.**
5. **Behoben, dass der Suchbutton gelegentlich verschwand, wenn das World-Modul in der Seitenleiste platziert war.**
6. **Versuch, Anomalien beim Folgen des System-Nachtmodus zu beheben.**
7. **Versuch, ein Problem zu beheben, bei dem aufeinanderfolgende Teamaufgaben-Abschlüsse zu Aufgabenduplikaten führen konnten.**
8. **Behoben, dass die Gefühle-Funktion beim Freischalten von Erfolgen ausfiel.**

**v1.100.4 (2025/09/07)**

**♻️ Optimierung**

1. **Absturzberichte verbessert**: Absturzerfassung und -berichte für bessere Analyse und Fehlersuche erweitert.

**🐛 Fehlerbehebungen**

1. **Absturz durch Facebook SDK behoben.**

**v1.100.3 (2025/09/06)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Suche beim Auswählen von Gegenständen nicht funktionierte.**

**v1.100.2 (2025/09/05)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass beim Erstellen oder Bearbeiten von Gegenständen im Shop in bestimmten Situationen die Standardliste nicht ausgewählt werden konnte.**

**v1.100.1 (2025/09/03)**

**✨ Neue Funktionen**

1. **Schriftfarbenoptionen für benutzerdefinierte Hintergründe**: Unterstützung für benutzerdefinierte Notizschriftfarben zur weiteren Personalisierung.
2. **Gegenstands-Nutzungseffekte erweitert**: Zufällige Münzreduktionseffekte unterstützen jetzt auch die Funktion „Nutzung einschränken“.

**♻️ Optimierung**

1. **Kalender-Erinnerungen optimiert**: Optionen zum Anpassen der Dauer eingefügter Kalender-Erinnerungsereignisse hinzugefügt.
2. **Aufgabenbearbeitung optimiert**: Logik des „Änderungen verwerfen“-Popups beim Bearbeiten von Aufgaben verbessert — erscheint nicht mehr beim Beenden ohne Änderungen.
3. **Mehrsprachige Lokalisierung aktualisiert**: Lokalisierte Texte in mehreren Sprachen aktualisiert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Kompatibilitätskonfigurationsseite und die Erinnerungseinstellungsseite den Dunkelmodus nicht unterstützten.**
2. **Versuch, absturzbezogene Probleme mit Popups und Eingabemethoden-Fokus auf mehreren Seiten zu beheben** und die App-Stabilität zu verbessern.
3. **Behoben, dass beim Bearbeiten von Erfolgen nicht geändert werden konnte, ob Gegenstände automatisch genutzt werden.**

**v1.100.0-alpha (2025/07/29)**

**✨ Neue Funktionen**

1. **Pomodoro-Timer, Erfahrungspunkte, Inventarverlauf, Münzdetails**: Sprung zur entsprechenden Statistikseite mit einem Tippen.
2. **Flexiblere Erinnerungsereignis-Einstellungen** (X Minuten vor Start oder Frist).
3. **Synthese-Listen ausblenden** unterstützt.
4. **Attribute für Schrittzählungen und Ausdauer-Belohnungen ändern** unterstützt.
5. **Seitenleisten-Funktionsmodule anpassen** (z. B. Shop, Community in die Seitenleiste legen oder unnötige Module ausblenden).
6. **Experimentelle Option „Niedrig-Beschränkungs-Modus“ hinzugefügt**: Lockert numerische Limits in der App (Erfahrungspunkte, Münzstellen, auswählbare Attribute für Aufgaben usw.).
7. **UI und Interaktionslogik des Überfälligkeits-Popups optimiert.**
8. **Beschreibung für Auto-Nutzung von Gegenständen hinzugefügt.**
9. **Mehr wiederholbare Freischaltbedingungen unterstützt**:
   - Täglicher Pomodoro-Baum-Erwerb.
   - Tägliche Pomodoro-Fokuszeit.
   - Tägliches Abschließen von N verschiedenen Aufgaben.
   - Tägliche Nutzung eines bestimmten Gegenstands N-mal.
   - Tägliches Abschließen einer bestimmten Aufgabe N-mal.
10. **Smart-Listen-Optionen in Listenverwaltungs-Popup verschoben** (Listen-Button oben auf der Aufgabenlistenseite).
11. **Option „Schnell abschließen“ hinzugefügt**: Wenn aktiviert, überspringt das Abschließen von Aufgaben alle Popups.
12. **Einflussbereich benutzerdefinierter Münzsymbole erweitert**; unterstützt jetzt monochrome Symbole (z. B. Münzsymbole oben im Shop).
13. **Gegenstandsdetails zeigen die zugehörige Liste** — erleichtert die Bestätigung des Gegenstandsbesitzes aus dem Inventar.
14. **Beim Bearbeiten von Synthese-Rezepten**: Drag-Sortieren und Tippen zum Bearbeiten von Gegenständen unterstützt.
15. **API zum direkten Bearbeiten der Münzanzahl hinzugefügt.**
16. **Query-API unterstützt Pomodoro-Informationen** (Pomodoro-Anzahl).
17. **Numerische Limits einiger APIs gelockert** (Standard-API ist niedrig-beschränkt).
18. **Mechanismus zur Berechnung des Erfolgsbedingungs-Fortschritts neu gestaltet und optimiert**: Berechnungsperformance und Fortschrittsaktualisierung verbessert.

**♻️ Optimierung**

1. **Ausdauertage auf der Seite „Meine“ optimiert**; manuelles Antippen zum Neuberechnen unterstützt.
2. **RTL-Layout-Probleme auf der Kalenderseite behoben**; Wochenstart auf **„Montag“** gesetzt (zuvor Sonntag).
3. **Gruppenanzeige in Smart-Listen für Aufgaben und Shop** unterstützt Einklappen/Ausklappen nach Gruppenlabels.
4. **Wenn die Aufgabenliste abgeschlossene, nicht gestartete oder eingefrorene Aufgaben unten ausklappt**, erscheinen entsprechende Labels auch oben.
5. **Aus dem World-Modul importierte Gegenstandssymbole werden lokal persistent gespeichert** — vermeidet Ladefehler offline.
6. **Listen-Auswahl-Popup erkennt jetzt Smart-Listen.**
7. **Standardlisten-Logik für Team- und Zufallsaufgaben optimiert**: Wenn die Standardliste archiviert ist, wird standardmäßig die erste Liste gewählt.
8. **Überfälligkeitslogik für Zählaufgaben optimiert**: Bei Erreichen der Zählung standardmäßig Status **„Abgeschlossen“**.

**🐛 Fehlerbehebungen**

1. **Behoben, dass der Zustand der Checkbox „Gegenstand automatisch nutzen“ beim Bearbeiten von Erfolgen nicht korrekt wiederhergestellt wurde.**
2. **Behoben, dass die Smart-Listen-Obere-Karte Aufgaben archivierter Listen nicht ausschloss.**
3. **Behoben, dass der „Automatisch nutzen“-Checkbox-Zustand beim Gegenstandskauf global gespeichert wurde** — jetzt unabhängig pro Gegenstand.
4. **Behoben, dass die Erfolgs-Freischalt-API in bestimmten Situationen den Fortschritt nicht korrekt aktualisierte.**
5. **Standardlisten-Logik für Team- und Zufallsaufgaben behoben.**
6. **Technische Abhängigkeiten aktualisiert**; Ziel-API-Version auf 35 (Android 15) angepasst.

**Alpha/Beta-Patch-Korrekturen**

1. **Unnötige Abhängigkeiten entfernt und an 16K-Seitengröße angepasst** — **App-Paketgröße reduziert**.
2. **Auto-Nutzung von Gegenständen korrigiert**: Bei URL-Gegenständen wird nur 1 Gegenstand genutzt, der Rest im Inventar gespeichert. (Zuvor wirkte nur 1, wurde aber nicht im Inventar gespeichert — Nutzungseffekt ging verloren)
3. **Behoben, dass wiederholbare Erfolgsbedingungen den Fortschritt nicht neu berechnen konnten.**
4. **Behoben, dass Backup-Dateien keine Aufgabenvorlagen enthielten.**
5. **Behoben, dass die meisten Emojis nach Backup-Wiederherstellung abnormale Symbole neu generierten.**
6. **QQ-Kanal-Link für In-App-Feedback aktualisiert.**
7. **Broadcast für Gefühle-Veröffentlichung hinzugefügt.**
8. **Kompatibilitätskonfiguration und Erinnerungsmethoden-Einstellungen neu gestaltet.**
9. **Option „Gegenstandsnutzung einschränken“ für Münzreduktionseffekte hinzugefügt.**
10. **API-Updates**: Aufgaben-API unterstützt Parameter für Motivationsnachrichten.
11. **Abnormaler oberer Abstand auf der Seite für Standard-Einstellungen neuer Gegenstände behoben.**

**v1.99.5 (2025/07/29)**

**🐛 Fehlerbehebungen**

1. **Versuch, ein Problem zu beheben, bei dem benutzerdefinierte Hintergründe in bestimmten Situationen nicht korrekt angezeigt wurden.**

**v1.99.3 (2025/06/30)**

**✨ Neue Funktionen**

1. **Unteraufgaben-API unterstützt relative Anpassung** (`set_type`).
2. **Automatische Bereinigung abgelaufener Kalender-Erinnerungsereignisse** unterstützt.
3. **Verarbeitungslogik für archivierte Listen optimiert**:

* Smart-Listen zeigen archivierte Aufgaben nicht mehr an.
- Aufgaben in archivierten Listen rücken standardmäßig nicht automatisch vor (ähnlich eingefrorenem Status).

**♻️ Optimierung**

1. **Beim fortlaufenden Hinzufügen von Aufgaben/Erfolgen**: automatisches Scrollen nach oben und Fokus auf das Eingabefeld.
2. **Formulierung zum Abschließen negativer Aufgaben optimiert.**
3. **Anzeigelogik des „Änderungen verwerfen“-Popups auf der Aufgabenbearbeitungsseite optimiert.**
4. **Ereignisdauer für Kalender-Erinnerungen optimiert**, um potenzielle Probleme auf manchen Geräten zu vermeiden.

**🐛 Fehlerbehebungen**

1. **Behoben, dass Widgets keine benutzerdefinierten Münzsymbole anzeigen konnten.**
2. **Behoben, dass die Aufgabendetailseite keine Belohnungen mit mehreren Gegenständen anzeigte.**
3. **Behoben, dass bestimmte Szenarien (z. B. Widgets) Listen-Sortierregeln nicht einhielten.**

**v1.99.1-rc02 (2025/06/20)**

**✨ Neue Funktionen**

1. **Wiederholbare Erfolgs-Freischaltbedingung „N aufeinanderfolgende Aufgaben abschließen“ unterstützt.**
2. **Aufgabe-erstellen/-bearbeiten-API unterstützt jetzt Aufgabentyp und relative Anpassung von Münzen/Erfahrungspunkten.**
3. **Erfolgs-API unterstützt Münzen setzen und relative Anpassung von Münzen/Erfahrungspunkten.**
4. **APIs unterstützen Sprung zu bestimmten Erfolgs- und Synthese-Listen.**

**♻️ Optimierung**

1. **Reihenfolge der Inventarverlaufseinträge beim Öffnen von Boxen optimiert.**
2. **Filteroptionen auf der Statistikseite werden jetzt gemerkt.**
3. **Filterseiten-Optionen unterstützen „Alle auswählen“.**
4. **Deduplizierungslogik bei Aufgabenerstellung verstärkt.**
5. **Aufgabendetailseite ergänzt**: Einfrieren, Frist anpassen.
6. **Anzeige der Synthese-Listen-ID unterstützt.**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die vorherige Aufgaben-API Ebbinghaus-Aufgaben nicht erstellen/bearbeiten konnte.**
2. **Behoben, dass Aufgabenlistenanzeige und Listenname in der oberen Leiste beim Start aus dem Aufgabenlisten-Widget inkonsistent sein konnten.**
3. **Behoben, dass Text in der Einfachmodus-Karte möglicherweise nicht vollständig angezeigt wurde.**

**v1.99.0 (2025/05/17)**

**✨ Neue Funktionen**

1. **Unterstützung für wiederholbare Erfolgstypen**
2. **Benachrichtigungs-Erinnerungsaktionen hinzugefügt**: Aufgabe abschließen, später erinnern
3. **Benutzerdefinierter Hintergrund**: Option zur Verbesserung der Textlesbarkeit
4. **Anpassung des Erfolgs-Symbol-Zuschnittstils unterstützt**
5. **Anpassung von Ankerdaten für monatliche/jährliche Aufgaben unterstützt**

**♻️ Optimierung**

1. **Logik zur Berechnung des Erfolgs-Freischaltfortschritts optimiert**
2. **Interaktionen bei der Gegenstandsauswahl verbessert**
3. **Position des Erinnerungsberechtigungs-Buttons beim Erstellen/Bearbeiten von Aufgaben angepasst**
4. **Speicherlogik für relative Erinnerungszeit optimiert**
5. **Einfrieren nicht-wiederholender und unbegrenzt wiederholender Aufgaben erlaubt**

**🐛 Fehlerbehebungen**

> Einige Korrekturen werden schrittweise in [Mitglieder-Stabilversion] und [Offizielle Version] ausgerollt

1. **Behoben, dass das Bearbeiten von Erfolgen den API-Freischaltbedingungs-Fortschritt versehentlich zurücksetzen konnte**
2. **Behoben, dass Gegenstände mit Bestand 0 per API noch gekauft werden konnten**
3. **Behoben, dass auf der Seite für neue Gegenstände unter bestimmten Bedingungen gelöschte Listen ausgewählt werden konnten**
4. **Behoben, dass Aufgabenvorlagen den Status automatisch berechneter Münz-Belohnungen nicht speichern konnten**
5. **Detailseiten-Übergangsanimationen entfernt**, um Long-Press-Interaktionsfehler zu beheben
6. **Behoben, dass eingefrorene Aufgaben in der Pomodoro-Aufgabenauswahl erschienen**
7. **Behoben, dass das Bearbeiten von Aufgaben über bestimmte Methoden den Status fälschlich auf unvollständig zurücksetzte**
8. **Interaktionsprobleme mit Gefühle-Popups behoben**

**v1.98.5 (2025/05/01)**

**✨ Neue Funktionen**

1. **Ankerdaten für monatliche und jährliche wiederkehrende Aufgaben unterstützt** (z. B. Monatsende).
2. **Mehrfachauswahl für Gegenstände verbessert**: Standardmäßig Mehrfachauswahlmodus; vorherige Auswahl wird beim erneuten Auswählen wiederhergestellt.

**♻️ Optimierung**

1. **Speichern relativer Erinnerungszeit-Einstellungen unterstützt.**
2. **Kleinere UI-Optimierungen.**

**🐛 Fehlerbehebungen**

1. **Behoben, dass Gegenstände per API noch gekauft werden konnten, wenn der Shop-Bestand nicht ausreichte.**
2. **Behoben, dass Aufgabenvorlagen automatische Münz-Belohnungen nicht wiederherstellten.**
3. **Behoben, dass Long-Press auf Aufgabentitel gelegentlich fehlschlug.**
4. **Behoben, dass neue Gegenstände unter bestimmten Bedingungen gelöschte Listen auswählen konnten.**
5. **Behoben, dass beim Bearbeiten von Aufgaben der Löschen-Button im Erinnerungszeitfeld fehlte.**

**v1.98.4 (2025/04/14)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Fortschrittsleiste nach Abschluss von Unteraufgaben auf der Aufgabendetailseite nicht umgehend aktualisiert wurde.**
2. **Behoben, dass das Bearbeiten einer abgeschlossenen Aufgabe den Status fälschlich auf „unvollständig“ zurücksetzen konnte.**
3. **Behoben, dass das Ändern des Status überfälliger Aufgaben die Ziel-Abschlussanzahl fälschlich beeinflussen konnte.**
4. **Behoben, dass die Pomodoro-Aufgabenauswahl eingefrorene Aufgaben und archivierte Listen fälschlich anzeigte.**

**v1.98.3 (2025/02/16)**

**♻️ Optimierung**

1. **Warnung hinzugefügt**, wenn die Standard-Benachrichtigungserinnerung ohne Berechtigung für „exakte Alarme“ genutzt wird.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die API „Aufgabe abschließen“ nicht funktionierte, wenn das UI-Feld true war.**
2. **Behoben, dass Kauf und Nutzung bestimmter Gegenstandsmengen fehlerhaft sein konnten** (z. B. 10).
3. **Behoben, dass die Gefühle-Seite in bestimmten Szenarien dauerhaft „Lädt…“ anzeigen konnte.**

**v1.98.2 (2025/02/06)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass bei Nutzung eines Gegenstands, der Erfahrung abzieht, unzureichende Erfahrung angezeigt werden konnte, obwohl genug vorhanden war.**
2. **Behoben, dass das Bearbeiten eines kopierten Gegenstands abnormale doppelte Nutzungseffekte erzeugen konnte.**
3. **Behoben, dass der Aufruf der API „adjust item“ abnormale Kauflimits erzeugen konnte.**
4. **Behoben, dass das Bearbeiten bestimmter Pomodoro-Einträge die Tomatenanzahl abnormal reduzierte.**

**v1.98.1 (2025/01/14)**

**🐛 Fehlerbehebungen**

1. **Versuch, ein Problem mit der Google-Login-Autorisierung zu beheben**, bei dem Daten einer begrenzten Anzahl von Konten nicht korrekt autorisiert und geparst werden konnten.

**v1.98.0 (2025/01/01)**

**✨ Neue Funktionen**

1. Google-Login und Drive-Autorisierung mit Credential Manager integriert.
2. Emoji als Symbole auswählen unterstützt.
3. ContentProvider Query API hinzugefügt: Synthese-Funktionalität.
4. ContentProvider Query API hinzugefügt: Pomodoro-Eintrags-Funktionalität.
5. ContentProvider Query API hinzugefügt: Unterstützung für mehrere Gegenstands-Rückgaben.
6. tomato API hinzugefügt (Tomatenanzahl anpassen).
7. export_backup API hinzugefügt (Backup exportieren).
8. purchase_item API hinzugefügt (Gegenstand kaufen).
9. synthesize API hinzugefügt (Synthese auslösen).
10. subtask API hinzugefügt (Unteraufgaben erstellen oder anpassen).
11. subtask_operation API hinzugefügt (Unteraufgaben bedienen, z. B. abschließen).
12. synthesis_formula API hinzugefügt (Synthese-Formel).
13. edit_task API hinzugefügt (Aufgabe bearbeiten).
14. category API hinzugefügt (Liste erstellen oder anpassen).
15. history_operation API hinzugefügt (Verlauf anpassen).
16. AppSettingsScheme API hinzugefügt (einige App-Einstellungen anpassen).
17. achievement API hinzugefügt (Erfolg erstellen oder bearbeiten).
18. skill API hinzugefügt (Attribut erstellen oder bearbeiten).
19. Anzeige von Unteraufgaben-id und gid unterstützt.
20. Anzeige der Synthese-id unterstützt.
21. Abfrage von creditLimit unterstützt.
22. ContentProvider API unterstützt Abfrage von Unteraufgaben (id, gid).
23. ContentProvider API Gegenstandsabfrage: Rückgabe des Felds „maximal kaufbare Menge“ hinzugefügt.
24. ContentProvider Shop API unterstützt Abfrage von Gegenständen nach angegebener id-Liste.
25. Rückgabewert bei Abfrage falscher ContentProvider-URL optimiert.
26. Query-Schnittstelle unterstützt Abfrage einzelner Erfolge.

**♻️ Optimierung**

1. Standard benutzerdefinierte Sortierung für neu hinzugefügte Gegenstände optimiert.
2. Standard benutzerdefinierte Sortierung für neu hinzugefügte Attribute optimiert.
3. Parameter `purchase_limit`, `disable_use` und `effects` zur „add_item“-API hinzugefügt.
4. Parameter `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` und `pin` zur „add_task“-API hinzugefügt.
5. Unterstützung für mehr Aufgabenfrequenzen in der „add_task“-API hinzugefügt.
6. Unterstützung für Parameter `effects` und `purchase_limit` in der „item“-API hinzugefügt.
7. Unterstützung zum Beenden von Vorgänger-API-Operationen hinzugefügt (z. B. Eingabe).
8. Unterstützung für den Parameter `signed` bei numerischen Platzhaltern hinzugefügt.
9. Zufallszahl- und Zufallsdezimal-Platzhalter hinzugefügt.


**v1.97.3 (2024/12/16)**

**✨ Neue Funktionen**

1. Merkt sich die letzte Auswahl des Schalters „Teambeschreibung als Aufgabennotizen verwenden“.

**♻️ Optimierung**

1. Performance im Zusammenhang mit Nutzungseffekten von Produkten optimiert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass bestimmte API-Aufrufe fehlschlugen**: Bei Aufruf der Produkt-API über eine bestimmte Callback-Funktion funktionierte die Entpack-Funktion normal, die interne API-Operation zum Hinzufügen von Gegenständen konnte jedoch nicht ausgeführt werden.

**1.97.2 (2024/12/08)**

**✨ Neue Funktionen**

1. Automatische Aufgabenerstellung über den WorkManager des Systems hinzugefügt, um fehlende Aufgaben zu vermeiden, wenn keine Widgets genutzt werden und die App länger als einen Tag nicht gestartet wurde.
2. API-Ausnahmebehandlung verbessert: einheitliches `success`-Feld und Weitergabe von Ausnahmeinformationen an die Content-Provider-Schnittstelle.

**♻️ Optimierung**

1. Standard-Zeitgenerierungslogik optimiert, um monatliche und jährliche Zeiten genauer zu erzeugen.
2. Logik zum Löschen ungenutzter Bilddateien optimiert: sekundäre Datenbankprüfung hinzugefügt, um versehentliches Löschen zu verhindern.

**🐛 Fehlerbehebungen**

1. Fehlermeldungen der API verbessert, wenn Entitäten nicht gefunden werden.
2. Parallelitätsprobleme im integrierten Downloader behoben.
3. Pomodoro-Statistiklogik bei tagübergreifenden Szenarien behoben: Zuordnung der Einträge einheitlich zum Zeitraum der Endzeit (zuvor konnten tagübergreifende Einträge nicht korrekt dem Tageszeitraum zugeordnet werden).
4. **Behoben, dass Aufgabenkontinuität und Abschlusszähler pro Zeitraum** in bestimmten Szenarien falsch sein konnten.

**1.97.1 (2024/11/20)**

**✨ Neue Funktionen**

1. Übersetzungen aktualisiert.
2. Automatische Anzeige mehrerer Gegenstands-Belohnungen in Notizen unterstützt.

**♻️ Optimierung**

1. Netzwerkanfragen optimiert, um unnötige HTTP-Anfragen zu reduzieren und die Performance zu verbessern.
2. Stufen-Anzeige auf der Statusseite optimiert: bessere Darstellung und effizientere Informationsvermittlung.

**🐛 Fehlerbehebungen**

1. Farbe des Unteraufgaben-Zähler-Texts behoben.
2. Zeitberechnungsfehler bei monatlichen und jährlichen Aufgaben behoben; präzise Auslösezeiten sichergestellt.
3. Zeitberechnungsprobleme bei monatlichen und jährlichen Unteraufgaben behoben; alle Unteraufgaben werden korrekt geplant.
4. **Behoben, dass der Aufgabenhintergrund** beim Wiederherstellen aus einer Aufgabenvorlage nicht korrekt wiederhergestellt wurde; Hintergrundeinstellungen werden nun korrekt angewendet.

**1.97.0 (2024/10/21)**

**♻️ Optimierung**

1. Darstellung von Aufgabenkarten für nicht gestartete Aufgaben optimiert.
2. Einige Performance-Probleme behoben.
3. Aufgabendetailseite optimiert: Problem behoben, bei dem Klicks auf den Aufgabennamen gelegentlich keine Interaktion auslösten.

**✨ Neue Funktionen**

1. JSON-Formatfelder zur API-Broadcast bei überfälligen Aufgaben hinzugefügt.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die App abstürzte**, wenn Material 3 aktiviert war und bestimmte UI-bezogene APIs ausgeführt wurden.
2. Einige veraltete experimentelle Optionen entfernt, z. B. Schalter für Gefühle und neuen Attribute.

**🎉1.97.0-rc (2024/09/11)**

**✨ Neue Funktionen**

**Wichtige Updates**

- Dieses Update konzentriert sich vor allem auf Performance-Optimierungen und Fehlerbehebungen.
- Die Gesamtperformance der App deutlich optimiert: Aufgabenlisten abrufen und verschiedene Aktionen sind jetzt flüssiger. Ziel-Android-API-Version auf Android 14 aktualisiert.

**Sonstiges**

1. Bei unzureichenden Münzen erscheint der Gegenstands-Kaufbutton deaktiviert.
2. Erfolge in der Erfolgsliste nach Namen durchsuchbar 🔍.
3. Schriftgrößeneinstellungen in der App unterstützt.
4. Zufallslogik für World → Zufallsaufgaben optimiert: Häufigkeit des neuesten Aufgabenbatches reduziert, randomisierter.
5. Benachrichtigungsgruppierung optimiert: Benachrichtigungen wie Attribute- und Erfolgs-Freischaltungen gruppieren sich korrekt.
6. Statistik → Teilen unterstützt Ein-/Ausblenden von QR-Codes.

**♻️ Optimierungen**

1. Netzwerkzugriffslogik optimiert.
2. Hintergrund-Unschärfeffekt für Pop-ups hinzugefügt.
3. Buttons auf Shop-, Inventar- und Vitrinen-Seiten optimiert; offizielle Material-Button-Stile.
4. Content-Provider-API für Aufgabenverlauf liefert jetzt die Endzeit der Aufgabe.
5. Content-Provider-API für Aufgabenverlauf unterstützt Filter nach Aufgaben-Group Id.
6. Viele Abhängigkeitsversionen aktualisiert.
7. Goto-API unterstützt Navigation zur Seite „Standard-Einstellungen neuer Gegenstände“.
8. Bei Navigation zur Seite „Erfolg erstellen“ über die Goto-API ist der Parameter `category_id` jetzt erforderlich.
9. In-App-Hinweise für Aufgaben-, Zählaufgaben- und Gegenstands-Link-Effekte in der API hinzugefügt.
10. Logik und Fehlermeldungen für Update-Prüfungen neuer Nutzer optimiert.
11. Lade- und Fehlermeldungen für Kontolöschung hinzugefügt.
12. Klickbereich zum Abschließen der Hauptaufgabe auf der Aufgabendetailseite optimiert.
13. Fehlermeldung beim Importieren von Backups verbessert; ungültige Backup-Dateien werden strenger abgewiesen.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Fehlermeldung bei leerem Aufgabeninhalt** beim Erstellen einer neuen Aufgabe nicht automatisch verschwand, nachdem Text eingegeben wurde.
2. **Behoben, dass der Filterbutton auf der Statistikseite** im unteren Navigationsmodus nicht angezeigt wurde.
3. Layout-Probleme auf bestimmten schmalen Kleingeräten behoben.
4. **Behoben, dass Unteraufgaben-Belohnungen** beim Kopieren von Aufgaben abnormal verknüpft werden konnten (seit Version 1.96.0).
5. Fehlermeldungen bei abnormer Dropbox-Verbindung während automatischem Dropbox-Backup behoben.
6. Versuch, Speicherverbrauch und Abstürze bei der Vorschau extrem großer Bilder zu beheben.
7. **Behoben, dass Widget-Daten nach Gegenstandskauf und Nutzungsmarkierung** bei fehlgeschlagener Nutzung nicht korrekt aktualisiert wurden.
8. **Behoben, dass das Bearbeiten eines Erfolgs** die Abschlusszeit änderte und fälschlich Erfolgs-Freischalt-Benachrichtigungen auslösen konnte.
9. **Behoben, dass im Split-Screen auf großen Bildschirmen** Aufgabenliste und Detailseite bei Abschluss von Aufgaben, Unteraufgaben oder Zähler-Updates nicht synchronisiert wurden.
10. **Behoben, dass langes Drücken überfälliger Einzelaufgaben** in der Aufgabenliste das Löschen der Fristanzeige nicht erlaubte.

**1.96.1(2024/07/11)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die angezeigte Anzahl an Belohnungs-Gegenständen** beim Abschließen von Unteraufgaben falsch war (tatsächliche Belohnungen waren nicht betroffen).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Neue Funktionen**

**Wichtige Updates**

1. Beim Abschließen von Aufgaben oder Freischalten von Erfolgen können Gegenstände direkt genutzt werden, um Gegenstandseffekte auszulösen.
2. Limit für gleichzeitig genutzte Gegenstände auf 1000 erhöht.
3. Kauf von Lootboxen oder Synthese-Gegenständen unterstützt direkte Nutzung (Öffnen/Synthese).
4. Teamaufgaben unterstützen das Posten von Gefühlen in lokale Gefühle.
5. URL Schemes Dritter in Aufgabennotizen werden direkt geparst und geöffnet.
6. Verlaufsseite unterstützt Suche in historischen Einträgen über Aufgabennotizen.
7. Zeitmessung historischer Aufgaben unterstützt.
8. Statistikseite unterstützt Filter nach Hauptkategorien.
9. Pop-ups für Attribut-Erfahrungspunkte-Belohnungen und -Strafen überarbeitet: Logik für Attributauswahl-Limits bei Gegenstandsnutzung optimiert; Pop-ups für Erfahrungspunkte-Abzug bei Überfälligkeit getrennt.

**♻️ Optimierungen**

1. UI-Effekt bei Einzelauswahl von Gegenständen entspricht jetzt Mehrfachauswahl.
2. Ladegeschwindigkeit der Aufgabenliste optimiert.
3. Beim Hinzufügen oder Bearbeiten von Aufgaben muss die Fälligkeitszeit nicht mehr nach der aktuellen Zeit liegen; flexiblere historische Einträge.
4. Wenn Daten-IDs angezeigt werden, zeigt das Gefühle-Pop-up auch die entsprechende ID.
5. Performance-Probleme im Zusammenhang mit dem Überfälligkeits-Pop-up optimiert.
6. Button-Reihenfolge bei Countdown-Zeitmessung und Pause vereinheitlicht.
7. Interaktion zum Löschen von Beiträgen auf World-Modul → Persönliches Profil intuitiver gestaltet.
8. Ladeeffekte auf Gefühle- und Erfolgs-Seiten optimiert.

**🐛 Fehlerbehebungen**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Neue Funktionen**

**Hauptupdates**

1. In-App-Split-Screen auf großen Geräten wie Tablets und faltbaren Displays unterstützt

**♻️ Optimierungen**

1. Shop- und Inventar-Widgets unterstützen konsistente In-App-Bildzuschnitt-Effekte
2. Auf der Statistikseite werden bei Auswahl nur eines Tages Liniendiagramme unterstützt

**🐛 Fehlerbehebungen**

1. **Behoben, dass der Aufgabentyp beim Bearbeiten von API-Aufgaben** falsch angezeigt wurde
2. **Behoben, dass Statistiken zu Aufgabenabschluss, -aufgeben und -überfälligkeit** auf der Statistikseite abnormal waren

**1.94.3 (2024/05/10)**

**♻️ Optimierungen**

1. Widgets versuchen bei System-Dunkelmodus-Wechsel das Theme anzupassen
2. Wenn das Modul „World“ ausgeblendet ist, zählt die rote Punkt-Benachrichtigung für System-Erfolge keine World-bezogenen Daten mehr

**🐛 Fehlerbehebungen**

1. Seltene Abstürze bei Mehrfachauswahl von Gegenständen behoben
2. Seltene Abstürze im Zusammenhang mit Pop-up-Fenstern behoben
3. **Behoben, dass das Inventar-Widget bei Aufruf der Gegenstands-Änderungs-API** nicht aktualisiert wurde
4. **Behoben, dass das Inventar-Widget „nicht nutzbare“ Gegenstände** verwenden konnte

**1.94.2 (2024/04/26)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die aktuelle Aufgabenzählung abnormal berechnet wurde** (ungenaue Fortschrittsanzeige bei Aufgaben mit Ziel-Wiederholungsanzahl)
   - Diese Korrektur setzt eine frühere Performance-Optimierung beim Rückgängigmachen von Aufgaben zurück; eine bessere Lösung folgt später

**1.94.1 (2024/04/22)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Pomodoro-Anzahl bei Stoppuhr, API-Zeit hinzufügen oder manuellen Zeiteinträgen** um eins zu niedrig berechnet wurde.
2. **Behoben, dass die Auswahlleiste auf Shop-/Inventar-Seiten** nach Gegenstandsauswahl und Scrollen flackern und verschwinden konnte.

**🎉1.94.0 (2024/04/22)**

**Wichtige Updates**

1. Mehrere Gegenstands-Belohnungen unterstützt
2. Inventar-Widgets

**UI-Themen**

1. Benutzerdefinierte (Aufgaben-, Gegenstands-)Farben mit mehr Vorgabewerten
2. An Android-14-Feature für monochrome adaptive Icons angepasst
3. Viele Sprachanpassungen (Google-Play-Version)

**Erfolge**

1. Bei Erfolgen mit nicht abgeholten Belohnungen erscheint ein roter Punkt in der Erfolgsliste.

**Aufgaben**

1. Unteraufgaben von Strafaufgaben führen die Straf-Logik korrekt aus
2. „Intelligente Zeitzonen-Verwaltung“ hinzugefügt: LifeUp erkennt Zeitzonenwechsel und unterstützt globale Zeitanpassungen
3. Statistikbasis auf der Detailseite merkt sich die letzte Auswahl; Standardwerte in bestimmten Szenarien optimiert
4. Kulanz bei aufeinanderfolgenden Abschluss-Tagen auf der Seite „Mein“ optimiert: Nachholen eines vergessenen Tages kann die Serie fortsetzen

**Attribute**

1. Löschen von Erfahrungseinträgen unterstützt
2. Zurücksetzen der Erfahrungspunkte eines einzelnen Attributs unterstützt

**Widgets**

1. Klick auf Leerraum in Shop- oder Inventar-Widgets öffnet direkt die Zielliste des Widgets, nicht die zuletzt genutzte Liste
2. Aufgaben-Widgets zeigen Fortschritt von Zählaufgaben

**API**

1. API zum Bearbeiten von Pomodoro-Einträgen hinzugefügt
2. Aufgaben-abschließen-API behandelt Strafaufgaben korrekt
3. Aufgaben-abschließen-API unterstützt Zählaufgaben (Parameter `count`)
4. Aufgaben-abschließen-API unterstützt Belohnungskoeffizient
5. Gegenstände-anpassen-API unterstützt Änderung der Gegenstandslisten-id
6. Gegenstände-erstellen/-anpassen-API unterstützt Sortierkriterium
7. Jump-API unterstützt Sprung zum Gegenstand-nutzen-Pop-up
8. Einige Parameterdefinitionen vereinheitlicht, z. B. `itemId` → `item_id`
9. Broadcast-Benachrichtigungen für Start, Pause und Ende einer Stoppuhr hinzugefügt
10. `title_color_string` der Gegenstände-anpassen-API unterstützt leeren String zur Wiederherstellung des Standardwerts
11. Broadcast beim Aufgabenabschluss enthält jetzt Listen-id
12. Box öffnen und Herstellen lösen ebenfalls den Gegenstand-nutzen-Broadcast aus

**♻️ Optimierungen**

1. Warnung beim Hinzufügen/Bearbeiten von Aufgaben, wenn kein Attribut gewählt und Erfahrung eingegeben wurde
2. Upload-Wiederholungsprotokolle optimiert
3. Titelanzeige und Eingabebeschränkungen auf der benutzerdefinierten Stufen-Seite optimiert
4. Performance und Timing beim Rückgängigmachen häufig wiederholter Aufgaben optimiert
5. Gegenstand-nutzen-Pop-up, Kalender-Logik usw. überarbeitet
6. Erinnerungslogik für Aufgaben optimiert; gelöschte oder alte Erinnerungen werden nicht erneut ausgelöst
7. Wartetext in der Backup-Oberfläche optimiert
8. Auf der benutzerdefinierten Attribut-Seite gewählte Bilder werden auch zur Auswahlhistorie hinzugefügt
9. Beim Bearbeiten von Pomodoro-Einträgen wird versucht, die richtige Pomodoro-Anzahl zu korrigieren (erhöhen oder verringern)

**🐛 Fehlerbehebungen**

1. System-Erfolg zu Statistik und Backups nach Umstrukturierung wurde nicht normal ausgelöst — behoben
2. Mögliche Konflikte zwischen Random-API- und Toast-API-Widgets mit Standard-Toast behoben
3. **Behoben, dass Aufgabendetails in manchen Szenarien beim Öffnen über Widget** nicht aktualisiert wurden
4. Fehler bei mehrfachen Box-Öffnungen in Spezialfällen behoben (vorzeitige Aufbrauchung des Gegenstands-Inventars)
5. **Behoben, dass Unteraufgaben nach Bearbeiten einer Aufgabe ohne Unteraufgaben und Hinzufügen neuer** auf der Detailseite nicht angezeigt wurden
6. Spezialfälle behoben, in denen Münz-Belohnungen nicht bearbeitet werden konnten
7. Fälle behoben, in denen Team-Gegenstände nicht abgeholt werden konnten
8. MD2-Stil-Anomalien in manchen unteren Pop-ups behoben
9. Falsche Zusatzzeitwerte in Pomodoro-Timern behoben
10. **Behoben, dass die Farbleiste im Erfahrungspunkte-Änderungs-Widget** nicht angezeigt werden konnte
11. Einige Aufgaben im Kalender „In Bearbeitung“ wurden nicht korrekt angezeigt — behoben
12. Listenladeprobleme auf Verlaufs- und Gefühle-Seiten behoben
13. **Behoben, dass zweimal schnell hintereinander die Aufgaben-abschließen-API** keine zwei aufeinanderfolgenden Abschlüsse erlaubte

**1.93.3 (2024/01/09)**

**✨ Neue Funktionen**

1. [Gefühle]-API hinzugefügt.

**♻️ Optimierung**

1. Berechnung der Durchschnittswerte auf der Statistikseite schließt zukünftige Daten aus.
2. Nach Ausblenden der System-Erfolgsliste keine Benachrichtigungen mehr beim Freischalten von System-Erfolgen.
3. `goto`-API unterstützt keine Pop-ups mehr zum Kauf „nicht kaufbarer“ Gegenstände.
4. Aufgabenbearbeitung optimiert: Eingabe für Ziel-Wiederholungsanzahl wurde verdeckt — behoben.

**🐛 Fehlerbehebungen**

1. Edge-to-edge-UI-Effekt auf der benutzerdefinierten Attribut-Seite behoben.
2. **Behoben, dass die Strafe nicht widerrufen wurde**, wenn eine Aufgabe als aufgegeben markiert und dann auf Verlaufs-/Kalenderseite abgeschlossen wurde.
3. Darstellungsstil des unteren Pop-ups und der System-Navigationsleiste im Material2-Modus behoben.
4. Falsche Randfarbe des To-do-Eingabefelds im Nachtmodus behoben.
5. Anzeigeproblem nach Bildschirmrotation im Drei-Button-Navigationsmodus behoben.

**1.93.3 (2023/12/02)**

**♻️ Optimierung**

1. Einheitlicher Debug-Parameter für APIs zur einfacheren Fehlersuche hinzugefügt

**🐛 Fehlerbehebungen**

1. **Behoben, dass „Erinnerungs-Pop-up ignorieren“** nicht wirkte
2. **Behoben, dass direkt auf der Gefühle-Seite erstellte Gefühle** nicht bearbeitet werden konnten
3. **Behoben, dass beim Hochladen von Team-Fotos bis zu 9 Bilder** wählbar waren, obwohl das Limit 3 ist
4. **Behoben, dass die use_item-API bei ui=false** keine Countdown- oder URL-Effekte auslöste
5. **Behoben, dass Gegenstandsnutzung im Shop-Widget** den Effekt doppelt auslösen konnte

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Optimierung**

1. Datenbank-Upgrade-Logik optimiert, um Verzögerungen zu vermeiden
2. Standardwert für „Startzeit“ beim Bearbeiten von Aufgaben optimiert

**🐛 Fehlerbehebungen**

1. **Behoben, dass Bearbeiten von Produkt-APIs** Nutzungseffekte des Produkts löschte
2. **Behoben, dass überfällige und aufgegebene Aufgaben** im Status „abgeschlossen“ Belohnungen nicht wiederherstellten
3. Benutzerdefinierte Aufgaben-Sortierung entsprach nicht den Erwartungen — behoben
4. Anzeige- und Sortierprobleme bei überfälligen Einzelaufgaben behoben
5. SQL-Ausnahme beim Filtern der Verlaufsseite behoben
6. **Behoben, dass im Vereinfachten Modus erneutes Tippen auf den Aufgabentitel** keine Reaktion ergab
7. **Behoben, dass Umbenennen von Aufgabenvorlagen** nicht wirkte

**🎉1.93.0 (2023/10/24)**

**✨ Neue Funktionen**

**UI-Thema**

1. Vollständige Anpassung an Material Design 3.
2. Anpassbare Material-Design-3-Themenfarben, einschließlich benutzerdefinierter Farben, Wallpaper-Farben und Bildfarben.
3. Einige Animationseffekte verbessert, z. B. Pop-ups.
4. Edge-to-edge-(Immersiv-)Anpassung optimiert.

**Aufgaben**

1. Aufgabenvorlagen unterstützt.
2. Statistik auf der Detailseite unterstützt Wechsel nach Zeitkriterium; Standardoptionen optimiert.
3. Verlaufsseite unterstützt Suche nach Aufgabennamen; UI und Interaktionen angepasst.

**Erfolge**

1. Geheime Erfolge unterstützt.
2. Beim Hinzufügen von Erfolgen: „Nächsten Erfolg weiter hinzufügen“ unterstützt.

**Attribute**

1. Ausblenden von Attributen unterstützt.

**Pomodoro-Timer**

1. Bearbeiten von Zeiteinträgen unterstützt.
2. Auf der Pomodoro-Seite: Aufgabenabschluss (langes Drücken auf gewählte Aufgabe im Pausenmodus).

**Gefühle**

1. Gefühle direkt auf der Gefühle-Seite hinzufügen unterstützt.

**API**

1. API „use_item“ hinzugefügt.
2. API „random“ hinzugefügt.
3. API „edit_exp“ hinzugefügt.
4. API „item“ unterstützt Anpassung von Parametern wie „action_text“, „disable_use“ und „title_color_string“.
5. API „shop_settings“ unterstützt Parameter „silent“.
6. Platzhalter „time“ unterstützt: Aufgaben mit Datumsangaben wie „morgen fällig“ oder „nächsten Monat fällig“ ohne Automatisierungstools.

**♻️ Optimierung**

1. Präfixe an einigen Stellen mit Daten-IDs hinzugefügt.
2. Darstellung von Team-Aktivitäten optimiert.
3. Versuch, Toast-Benachrichtigungen vollständig anzuzeigen, die zu lang waren.
4. Widget-Abschlusslogik in Teams verbessert; konsistent mit In-App-Verhalten.
5. Statistikseite: Nach „Benutzerdefiniert“ erneutes Tippen auf „Benutzerdefiniert“ öffnet Datumsauswahl erneut.
6. Kompatibilität mit Harmony OS 4 für Aktionsbuttons in Fortschrittsbalken-Benachrichtigungen.
7. Interaktionslogik für Benachrichtigungsanfragen verbessert.
8. Problem behoben, dass die Eingabemethode die Eingabe für „Wiederholungsanzahl“ verdeckte.
9. Beim Erstellen von Aufgaben werden nicht-spezifische Startzeiten (z. B. automatisch oder heute fällig) gespeichert; beim Bearbeiten werden Optionen statt konkreter Zeiten wiederhergestellt.
10. Unerwartete Duplikat-Warnungen beim Erstellen erscheinen auch im Pop-up „Duplikate prüfen“.
11. Indonesische Sprache hinzugefügt.
12. Übersetzungen aktualisiert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass das World-Modul in manchen Fällen** endlos lud.
2. **Behoben, dass Shop/Inventar in manchen Fällen** endlos „Laden“ anzeigten.
3. Probleme beim Aufruf von APIs mit UI-Inhalt über Content Provider behoben.
4. Aufgaben-Sortierung entsprach nicht den Erwartungen — behoben.
5. **Behoben, dass Statistikdaten nach „Benutzerdefiniert“-Zeitraum** falsch waren.
6. Pop-ups für Benachrichtigungsanfragen unterstützten kein Scrollen — behoben.
7. **Behoben, dass die World-Modul-Suche in manchen Fällen** alle Inhalte anzeigte.
8. **Behoben, dass „Abgeschlossene anzeigen“ auch eingefrorene Aufgaben** zeigte.
9. Probleme bei Durchschnittswertberechnung auf der Statistikseite behoben.

**1.92.2 (2023/08/29)**

**✨ Neue Funktionen**

1. Schrittstatistik-Diagramm (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Optimierung**

1. Neue Teamseite zeigt Erinnerung an aktuelle und maximale Wortanzahl

**🐛 Fehlerbehebungen**

1. **Behoben, dass „LifeUp“ unter besonderen Bedingungen wiederholt Kalender-Erinnerungskonten** anlegte
2. **Behoben, dass der Menübutton beim Bearbeiten eines Teams** nicht korrekt angezeigt wurde
3. **Behoben, dass Pomodoro im Auto-Start-Zeitmessmodus** die Vibrationserinnerung nicht auslösen konnte
4. **Behoben, dass die Pomodoro-Benachrichtigung fälschlich Fokus-Gegenstände anzeigte**, wenn keine ausgewählt waren

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimierung**

1. Dauer auf Status- und Statistikseite kann im Format „XX Tage XX Stunden XX Minuten“ angezeigt werden.

**🐛 Fehlerbehebungen**

1. **Behoben, dass das Schließen des Benachrichtigungsberechtigungs-Pop-ups** auf Android 12+ nicht wie erwartet funktionierte.
2. **Behoben, dass das Attribut-Kreisdiagramm transparent** dargestellt werden konnte und unsichtbar war.

**1.92.1-rc01 (2023/08/13)**

> Veröffentlichungsdatum der Membership-Closed-Beta

**✨ Neue Funktionen**

1. Neue Statistikversion integriert Statistik-Karten der alten Version in einer Seite, angepasst an untere Navigationsleiste.

2. In-App-Update-Mechanismus und Erinnerungsfunktion überarbeitet.

   Drei Update-Kanäle: Stable Release, stabile Membership-Closed-Beta-Version und experimentelle Membership-Closed-Beta-Version — Fokus auf Updates für Closed-Beta-Mitglieder.

3. TargetSdkVersion für Android 13; dynamische Benachrichtigungsberechtigungsanfragen.

4. Profilbearbeitungsseite neu gestaltet.

5. GP-Version: Login-/Offline-Modus-Auswahl und Anleitung optimiert.

**♻️ Optimierung**

1. Wartung und Updates relevanter technischer Abhängigkeiten.
2. WSA-Anpassung und Login-Anleitung verbessert.
3. Bei Backup-Fehler erscheint Pop-up mit Fehlergrund; unvollständige Toast-Anzeige vermieden.

**🐛 Fehlerbehebungen**

1. Möglicher Berechnungsüberlauf-Absturz auf der Münz-Verlaufsseite behoben.
2. Menüprobleme auf der Teamdetailseite, die nicht zu erwarteten Berechtigungen passten, behoben.
3. Versuch, Zeitabweichung im Countdown-Timer zu beheben.
4. **Behoben, dass Bildschirmrotation den Aufgabenabschluss unterbrach** und das Reflexions-Pop-up verschwand.

**1.92.0-rc02 (2023/07/16)**

**🐛 Fehlerbehebungen**

1. **Behoben, dass das Shop-Widget beim Wechsel zu anderen Apps (API-Ausführung)** nicht funktionierte
2. Gelegentliche Anomalie beim Listenwechsel im Shop-Widget behoben
3. **Behoben, dass das Shop-Widget ausverkaufte oder nicht kaufbare Gegenstände** trotz App-Einstellungen nicht ausblendete
4. **Behoben, dass das Shop-Widget beim Tippen auf einen Gegenstand** nicht reagierte
5. Einige seltene Abstürze behoben

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Neue Funktionen**

1. Statistik 2.0
2. Share-Karte

**♻️ Optimierung**

1. Preise für „nicht kaufbare“ Gegenstände setzbar; z. B. für Rückgaben
2. Bei deaktiviertem „Aufgabenstrafe separat festlegen“ wird der Straf-Button nicht mehr angezeigt
3. UI der Unteraufgaben in Teamdetails optimiert
4. UI der Eindrücke optimiert

**🐛 Fehlerbehebungen**

1. **Behoben, dass beim Wechsel des Attribut-Zuschnittstils auf „abgerundetes Rechteck“** das Bearbeitungssymbol lange das alte Icon zeigte

**1.91.3-rc04 (2023/06/07)**

**♻️ Optimierung**

1. API zum Springen zu Aufgabendetails unterstützt jetzt Parameter `task_gid` und `task_name`
2. Content Provider unterstützt URL des Remote-Icons des Produkts
   - Zur künftigen Behebung, dass manche Produkticons auf dem Desktop nicht korrekt angezeigt werden

**🐛 Fehlerbehebungen**

1. **Behoben, dass das Shop-Listen-Widget die aktuellen Münzen** nicht korrekt anzeigte

**1.91.3 (2023/06/03)**

**✨ Neue Funktionen**

1. Shop-Gegenstandslisten-Widget (groß und klein)
2. Widget für heutige Erfahrungspunkte-Änderung
3. API zum Springen zu Aufgabendetails hinzugefügt
4. Gefühle: Sortierung in zeitlicher Reihenfolge; Jahresanzeige hinzugefügt

**♻️ Optimierung**

1. Preise für „nicht kaufbare“ Gegenstände setzbar; z. B. für Rückgaben
2. Bei deaktiviertem „Aufgabenstrafe separat festlegen“ wird der Straf-Button nicht mehr angezeigt
3. Anzeige-UI der Unteraufgaben in Teamdetails optimiert
4. Anzeige-UI der Eindrücke optimiert

**🐛 Fehlerbehebungen**

1. **Behoben, dass nach Löschen der Motivationsworte beim Bearbeiten einer Aufgabe „Bestätigen“** das Pop-up nicht schloss
2. **Behoben, dass eingefrorene Aufgaben per API** nicht durchsuchbar waren
3. **Behoben, dass Shop und Inventar die Standardliste** nicht ausblenden konnten

**1.91.2 (2023/05/09)**

**✨ Neue Funktionen**

1. Shop- und Inventarlisten unterstützen separates Ausblenden
2. `Goto`-API unterstützt Sprung zu Unterseiten der Hauptseite (Aufgaben, Status, Shop, Inventar)
3. Münzstatistik unterstützt Ausschluss von Kaufverbrauch

**♻️ Optimierungen**

1. Beim Erstellen eines neuen Erfolgs oder Bearbeiten eines gesperrten Erfolgs wird „Zurücksetzen“ nicht mehr angezeigt
2. Münz-Widget: Tipp springt zum Shop
3. Bei fehlgeschlagener Soundwiedergabe erscheint klare Fehlermeldung

**🐛 Fehlerbehebungen**

1. **Behoben, dass bei Pomodoro-Einträgen mit direkt gesetzter Endzeit** die erwartete Dauer nicht erfüllt sein konnte
2. **Behoben, dass nach Reparatur des Aufgabenfilter-Labels** die Eingabemethode unerwartet erschien
3. **Behoben, dass ATM-Zinsen per API** keinen absoluten Wert setzen konnten
4. Abnormales Datenladen auf der Verlaufsseite behoben
5. **Behoben, dass beim Widget-Abschluss einer Zählaufgabe „Abbrechen“** auf transparenter Seite hängen blieb
6. **Behoben, dass die Statistikseite im unteren Navigationsmodus** sich nicht automatisch aktualisierte
7. **Behoben, dass Teamaufgaben-Sammlung in GMT ±x,5-Zeitzonen** abnormal war

**1.91.1 (2023/03/27)**

**✨ Neue Funktionen**

1. Option „Benachrichtigungsverwaltung“ in den Einstellungen hinzugefügt.
2. Neue-Aufgabe-API unterstützt Hintergründe.
3. API-Broadcast-Ereignisse für Produkt-Countdowns hinzugefügt ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Optimierungen**

1. Feedback-Pop-up schließt nicht mehr automatisch bei Tipp außerhalb.
2. Widgets erzwingen keinen Abschluss nicht gestarteter Aufgaben mehr.
3. Aufgaben-abschließen-API erzwingt bei `ui=true` keinen Abschluss nicht gestarteter Aufgaben mehr.
4. Bei deaktivierten individuellen Aufgabenstraf-Koeffizienten werden frühere Koeffizienten ignoriert; globaler Wert gilt.
5. Leerzeichen in vom Nutzer eingegebenen URLs werden automatisch entfernt.
6. Bei aktiviertem „Nicht kaufbare Gegenstände ausblenden“ und neuem nicht kaufbarem Gegenstand erscheint Hinweis.
7. Bei aktivierten benutzerdefinierten Stufen ohne Definition wird die integrierte Stufen-Tabelle wiederhergestellt.
8. Widget-Vorschaubilder verbessert.
9. Schritteingaben auf Zahlen beschränkt. (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. Beim integrierten Browser für Produktlinks ist kein „https“-Präfix mehr nötig.
11. Anleitung „Kompatibilitätskonfiguration“ für Produkt-Countdown hinzugefügt.

**🐛 Fehlerbehebungen**

1. Unerwartetes Klickverhalten bei Produktauswahl in Shop und Inventar behoben.
2. **Behoben, dass nicht wiederholende Aufgaben per API** keine Frist setzen konnten.
3. **Behoben, dass benutzerdefinierte Attribut-Bilder** auf manchen Geräten nicht aktualisiert wurden.
4. **Behoben, dass benutzerdefinierte Soundeffekte abstürzen konnten**; neues Verfahren soll Hintergrund-Sounds stabiler und speichersparender machen, Wiedergabe kann langsamer sein.
5. **Behoben, dass auf Android 12+ ohne „Akkuoptimierung ignorieren“** automatischer Pomodoro-Timer oder Pausenzeit im Hintergrund abstürzen konnte.
6. **Behoben, dass Produkt-Countdown-Sounds** von Pomodoro-Sound-Einstellung beeinflusst wurden.
7. **Behoben, dass Gleitkomma-Fehler bei ATM-Tageszinsen per API** auftraten.
8. **Behoben, dass manche Bilder auf Android 6** nicht geladen wurden.
9. **Behoben, dass Fehlermeldungen beim Wiederherstellen** von höherer auf niedrigere App-Version nicht korrekt angezeigt wurden.
10. **Behoben, dass auf manchen Geräten Layout-Überlappung** auf der Pomodoro-Seite auftrat.

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Neue Funktionen**

1. Benutzerdefinierte Stufen-Verläufe unterstützt.
2. Erste Widget-Runde:
   - Münzen (klein, groß, Ziel)
   - Attribute (klein, groß)
3. Abfrage der meisten LifeUp-Daten über Content-Provider-API, u. a.:
   - Neue Version von „LifeUp Cloud“.
   - Erste rudimentäre Desktop-Version (Windows, Linux, macOS) für lokales Netzwerk.
4. Mehrfachauswahl-Löschen von Pomodoro-Einträgen unterstützt.
5. Automatischer Start von Pause und Arbeit für die Pomodoro-Uhr unterstützt.
6. API-Verbesserungen und neue Felder, u. a.:
   - ATM-Ein- und -Auszahlungen.
   - Kaufverbots-Einstellung für Waren.
   - Label-Farben für Aufgaben.
   - ATM-Saldo direkt setzen.
   - Einfache Abfrage angegebener Produktdetails.
   - Dritter Button und Aktion im Pop-up.

**♻️ Optimierungen**

1. Abfrage-, Verarbeitungsgeschwindigkeit und Performance bei großen Datenmengen verbessert.
2. Falsche Ränder adaptiver Icons behoben.
3. Darstellung der Pomodoro-Einträge optimiert.
4. Interaktion beim Backup-Wiederherstellen verbessert.
5. UI-Anzeige für Mitgliedschaftslizenz über Google Play hinzugefügt.
6. Hinweis, Ein-Klick-Import zu deaktivieren, wenn die gewählte Backup-Datei nicht von LifeUp stammt (Import direkt aus dem Dateisystem).
7. Eingabemethode schließt automatisch bei Gegenstandssuche im Produktauswahl-Pop-up.
8. API-Verhaltensänderungen, u. a.:
   - confirm_dialog-Pop-up-API: Fehlen Button-Text oder Aktion, wird der Button nicht angezeigt — flexiblere Pop-ups, z. B. nur Text ohne Buttons.
   - Penalty-API: Früher max. 100 Gegenstände abziehbar; Limit auf 9 Stellen erweitert.

**🐛 Fehlerbehebungen**

1. **Behoben, dass die Pomodoro-Seite unter Umständen am Ende „Laden“** anzeigte.
2. Abstürze durch bestimmte Drittanbieter-Bibliotheken behoben.
3. **Behoben, dass die App abstürzte**, wenn die Pomodoro-Uhr in der unteren Navigationsleiste lag und ein Hinweis-Pop-up erschien.
4. **Behoben, dass Attributwerte beim Ansehen fremder Profile** abnormal angezeigt wurden.
5. **Behoben, dass API-Ereignisse und Benachrichtigungen bei Attribut-Stufen-Reduktion** nicht korrekt gesendet wurden.
6. Interaktionsprobleme bei Langdruck-Bearbeitungsseiten behoben.
7. Abnormale Ränder auf Bildverwaltungs- und Synthese-Seiten behoben.
8. Nicht scrollbare Pop-ups im Querformat — behoben.

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. Unterstützung für Lese- und Autorisierungsvorgänge bei Content-Provider-Informationen.
2. Beim Dienststart wird ein Wake Lock angefordert, damit auch bei gesperrtem Bildschirm reagiert werden kann.
3. Reihe von Schnittstellen für Content Provider hinzugefügt.

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Erstveröffentlichung, für die Nutzung zusammen mit „LifeUp Cloud“ und der mobilen App.

Unterstützt folgende Vorgänge:

- Aufgaben, Listen, Gegenstände, Erfolge und Gefühlslisten abfragen.
- Gegenstände kaufen, Aufgaben abschließen.
- Desktop-Bildbetrachter zum Anzeigen vergrößerter Gefühlsbilder.

**1.90.7 (2022/11/07)**

**✨ Neue Funktionen**

1. Hinzugefügt: Vietnamesische Übersetzung und Signatur des Übersetzers (Google-Version)
2. Hinzugefügt: Bildauswahl „Zuschneiden überspringen“, geeignet für GIF-Animationen (Mitgliedsfunktion)
3. Hinzugefügt: API zum Löschen von Aufgaben
4. Hinzugefügt: Einstellung zum Deaktivieren des Aufgaben-Abschluss-Soundeffekts
5. Hinzugefügt: MAX-Mengen-Operation bei einfacher Synthese
6. Unterstützung für erneutes Sperren freigeschalteter Erfolge
7. „Produkt-hinzufügen-API“ unterstützt Angabe der Listen-ID

**♻️ Optimierung**

1. Beschreibung beim Löschen von Verlaufseinträgen verbessert
2. Erfahrungspunkte-Limit von (3/4 Nachkommastellen) auf (4/5 Nachkommastellen) geändert
3. Anzeige des Strafkoeffizienten auf der Detailseite hinzugefügt
4. Interaktionsdesign der Datums- und Zeitauswahl global verbessert
5. Erfolgs-Detail-Pop-up unterscheidet Icon-Farbe je nach erfüllten Bedingungen
6. Tomaten-Kurzschluss-Icon geändert
7. Beim Erstellen einer Aufgabe aus einer Smart-Liste: Bei 0 oder 1 wählbarer Liste automatische Auswahl
8. Entwicklermodus zeigt die Gegenstandslisten-ID
9. Eingabelänge einiger häufiger Felder begrenzt, um Abstürze zu vermeiden

**🐛 Fehlerbehebungen**

1. Abnormale Belohnungsberechnung beim Ändern von Gegenstands-Verlaufseinträgen in manchen Szenarien behoben
2. Schalter „Archivierte anzeigen“ stimmte in manchen Szenarien nicht mit der Anzeige überein — behoben
3. Datenlade-Logik des Widgets verbessert (behebt ggf. Anomalien)
4. Automatische Berechnungslogik beim manuellen Hinzufügen von Zeitaufzeichnungen repariert; es reicht jetzt, ein beliebiges Feld auszufüllen
5. Abnormale Aktualisierung auf der Tomaten-Zeitaufzeichnungsseite behoben
6. Unteraufgaben konnten Gegenstands-Belohnungen nicht löschen — behoben
7. Nach „Alle auswählen“ wirkte erneute Teilauswahl nicht — behoben
8. Speicherbedarf für Vorschaubilder optimiert
9. Widget-Aktualisierung wird nach Anpassen der Listenreihenfolge ausgelöst
10. Blockieren der Oberfläche bei manchen Backup-Methoden optimiert

**1.90.6 (2022/10/21)**

**✨ Neue Funktionen**

1. API zum Setzen der Schrittzahl an einem bestimmten Datum hinzugefügt
2. API zum Abfragen des Status angegebener Attribute (Erfahrungspunkte, Stufe) hinzugefügt
3. Direkter Import von Backup-Daten aus dem Dateimanager unterstützt
4. APIs für Belohnungs-Gegenstände nicht mehr auf 99 begrenzt

**♻️ Optimierung**

1. Übergangsanimation beim Öffnen der Ereignis-Detailseite optimiert
2. Bearbeitungsseite für Aufgaben optimiert; stärkerer UI-Effekt beim Aktivieren der Strafe und bessere Anleitung
3. Bedienungs-Icons auf der Zeitmessungsseite geändert
4. Im Kauf-Pop-up Warnungen und Hinweise für Gegenstände mit negativem Eigenbestand
5. Immersive Statusleiste auf der Startseite optimiert
6. Erinnerung an Kompatibilitätskonfiguration auf der Pomodoro-Seite hinzugefügt
7. Geschwindigkeit beim Exportieren und Wiederherstellen von Backups verbessert
8. Hinweise zur Lagerbestands-Einstellung
9. Einstellung [Wenn Produktbestand 0 ist, wird die entsprechende Aufgaben-Belohnung automatisch entfernt] vorübergehend entfernt
10. Lizenzprüfmechanismus mit Gratis-Testversion optimiert
11. Bei ausgewählter „Anheften“-Aufgabe wird die Aktion jetzt als „Loslösen“ angezeigt
12. Beim Wechsel zur positiven Zeitmessung erscheint die *experimentelle* Warnung nicht mehr jedes Mal

**🐛 Fehlerbehebungen**

1. Abnormale Systemgrenzen mancher Seiten oder auf Tablets behoben
2. Beim ersten Öffnen des Inventars wurden in manchen Fällen falsche Daten angezeigt — behoben
3. Bei beschädigten Backup-Dateien konnten Daten wegen interner Schäden (z. B. Bildschäden) nicht wiederhergestellt werden — behoben
4. „Kaufen“-Button erschien unerwartet nach Langdruck auf ausverkauften Gegenstand — behoben
5. Attribute-Einführung auf der neuen Teamseite war veraltet — behoben

**1.90.5 (2022/09/22)**

**♻️ Optimierung**

1. Anpassung an Geräte mit abnormalem WebP-Konvertieren (zugeschnittenes Bild kann größer als Original sein). Nach Bildauswahl Größe prüfen und sekundäre Kompression durchführen.
2. Beschreibung der Zielwiederholungen auf der Detailseite verbessert
3. Derselbe Gegenstand kann während des Countdowns Zeit akkumulieren
4. Weitere Anfänger-Leitaufgaben hinzugefügt
5. Übersetzungen aktualisiert

**🐛 Fehlerbehebungen**

1. Abnormale UI auf der Synthese-Seite behoben
2. Mehrere bekannte Absturzursachen behoben
3. Countdown von Gegenständen konnte bei langem Countdown abgebrochen und Zeit falsch akkumuliert werden — verbessert
4. UI-Ausnahme im Gefühle-Eingabe-Pop-up beim Widget-Abschluss einer Aufgabe behoben

**1.90.4 (2022/09/15)**

1. Abnormales Verhalten beim Widget-Abschluss einer Aufgabe behoben (transparente Seite, Bedienung nicht möglich)
2. Widget-Fähigkeit, Bilder aus Gefühlen auszuwählen, deaktiviert

**1.90.3 (2022/09/14)**

1. Fokusproblem beim Sortieren von Unteraufgaben behoben
2. Attributfarben bei eingefrorenen/nicht gestarteten Aufgaben verbessert
3. Broadcast-Ereignis für aufgegebene Aufgaben hinzugefügt
4. Wahrscheinlichkeitstextfarbe behoben
5. Starter-Aufgaben (Voreinstellungsaufgaben) verbessert
6. Import-Dialog für Gegenstände wählte standardmäßig ggf. die Liste „Alle“ — behoben
7. Shop-Gegenstandsgruppen-Probleme behoben
8. Warnung bei ungewöhnlicher Zeit (Zeit passt nicht zur Wiederholungsfrequenz)
9. Aufgaben-Berechnungsregeln im Kalender verbessert; Fristen künftiger Aufgaben sollten korrekt vorhergesagt werden
10. Kalender-Abschluss wurde für eingefrorene Aufgaben berechnet — behoben
11. Standard-Startzeiteinstellungen beim Bearbeiten von Aufgaben verbessert
12. Lizenzerkennungsmechanismus verbessert
13. Countdown-Verarbeitung von Gegenständen optimiert; wiederholte Ausführung verboten, um unerwünschte Zeitakkumulation zu reduzieren
14. Edge-to-Edge-Problem bei virtuellen Tasten auf manchen Seiten behoben
15. Gefühlsbild konnte beim Desktop-Widget-Abschluss einer Aufgabe nicht ausgewählt werden — behoben

**1.90.2 (2022/08/31)**

**✨ Neue Funktionen**

1. Broadcast-Ereignisse hinzugefügt.
   Tasker/MacroDroid kann jetzt Ereignisse wie Gegenstands-Nutzung, Aufgaben-Abschluss usw. empfangen und Tasker-Aktionen auslösen.

   Beispiel: Bei Gegenstands-Nutzung wird zufälliger Hintergrund gewechselt.
   Theoretisch lassen sich damit z. B. App-Sperren und Spiel-Interaktionsszenarien umsetzen.

2. Neue APIs:

- Aufgaben aufgeben
- Aufgaben einfrieren
- Aufgaben auftauen
- Leere Schnittstelle
- Abfrage

3. Rückgabewert für APIs zum Hinzufügen von Gegenständen und Aufgaben hinzugefügt
4. Beim Import von Gegenständen aus dem Markt kann jetzt die Zielliste gewählt werden
5. Anpassung an Material-3-Sekundärfarbe
6. Sprachübersetzungen aktualisiert; Koreanisch hinzugefügt

**♻️ Verbesserungen**

1. Beim Batch-Öffnen von Lootboxen wird auch die Wahrscheinlichkeit eines einzelnen Produkts angezeigt
2. UI-Darstellung im Nachtmodus an manchen Stellen optimiert
3. Interaktionslogik des Datums- und Zeit-Pop-ups optimiert; bei Auswahl des aktuellen Tages automatischer Wechsel zur Zeitauswahl
4. Bei API-Aufruf von Gegenstands- und Listenauswahl unterstützt das Pop-up kein direktes Schließen mehr (verhindert verlorene API-Aufrufe)
5. Standardhöhe mancher Pop-ups unten im Tablet-Querformat optimiert
6. Automatisches Schließen von Pop-ups optimiert

**🐛 Fehlerbehebungen**

1. API-Aufgabensuche konnte in manchen Fällen fehlschlagen — behoben
2. Gelegentlicher Absturz auf der Aufgabenlistenseite behoben
3. „Rückgängig“-Button erschien bei Langdruck auf normale, nicht freigeschaltete Erfolge — behoben
4. Erfolgs-Detail-Pop-up konnte unvollständig angezeigt werden — behoben
5. Upload konnte wegen abnormal großer Bilder fehlschlagen — behoben
6. own_number und stock_number der Gegenstands-API unterstützten keine negativen Zahlen — behoben
7. Persistenztage auf der „Ich“-Seite wurden manchmal abnormal als 1 angezeigt — behoben
8. Manchmal wurde „-x Tage her“ angezeigt — behoben
9. Folge-APIs konnten bei Batch-API-Aufrufen abnormal abgebrochen werden — behoben
10. Inhalt beim Anlegen eines neuen Teams ging beim Zerstören der Seite verloren — behoben

**1.90.1 (2022/08/22)**

**🐛 Fehlerbehebungen**

1. API-Aufruf-Konkurrenzproblem behoben
2. Bei Auswahl sehr vieler Produkte (Tausende) konnte Mehrfachauswahl einfrieren — behoben
3. Abnormales Verhalten beim Widget-Abschluss einer Teamaufgabe behoben
4. Bearbeitung der Unteraufgaben-Erfahrungspunkte wurde nicht zurückgefüllt — behoben

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Neue Funktionen**

1. Optimierung der Aufgaben-Belohnungseinstellungen:
   - UI-Anpassung der Belohnungseinstellungen
   - Unteraufgaben unterstützen Erfahrungspunkte- und Gegenstands-Belohnungen
   - Ursprüngliche „nur Text“-Belohnung wird zu unabhängiger „Worte“-Belohnung
   - Standard-Erfahrungspunkte-Wert setzbar

2. Gegenstände unterstützen Kaufrestriktionen nach Attribut-Stufe.

3. Gegenstände unterstützen den „URL“-Effekt.
   Nicht nur Webseiten, sondern auch andere Apps oder die LifeUp-API aufrufbar. Ermöglicht z. B. Preiserhöhung nach Gegenstands-Nutzung.

4. **Offene APIs.**
   Jetzt Automatisierungssoftware anbinden oder sekundäre Entwicklung betreiben.

   [Weitere Details in der API-Dokumentation.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. Shop unterstützt Anzeige des unverfeinerten Zähleffekts

6. Benachrichtigungs-Optimierung:

   - Benachrichtigung bei Attribut-Stufen-Änderung
   - Benachrichtigung bei freigeschaltetem Erfolg
   - Optimierung der Benachrichtigungsgruppen

7. Manuelles Hinzufügen von Zeitaufzeichnungen unterstützt.

8. Pomodoro-Seite kann jetzt in der Navigationsleiste platziert werden

9. Liste [System-Erfolg] ausblendbar

10. API-Zielversion an Android 12L angepasst

11. Optimierung der Immersionseffekte

12. App-Widgets unterstützen Pop-up zum Abschließen der Aufgabe

13. Aufgabe kann jetzt auf der Angelegenheits-Detailseite abgeschlossen werden

14. Im Überfällig-Pop-up kann die Anzahl von Zählaufgaben gesetzt werden

15. Name der Teamaufgabe kann jetzt bearbeitet werden

16. Netzwerk-Anfrage-Timing des Weltmoduls optimiert; weniger Traffic und Serverlast

**♻️ Verbesserungen**

1. Nachtmodus unterstützt jetzt alle Themenfarben; separate Nachtfarben-Anpassung pro Themenfarbe, Material 3
1. Link „Akkuoptimierung“ im Kompatibilitätskonfigurations-Dialog hinzugefügt
1. Schalter „Bildschirm eingeschaltet lassen“ in Pomodoro-Einstellungen hinzugefügt
1. Zwei Optionen „Beenden“ und „Aufaddieren“ für pausierten Gegenstands-Countdown
1. Fehlermeldung, wenn Bearbeitungsziel größer als aktuelle Anzahl
1. Negative Angelegenheiten werden in Strafkoeffizient-Einstellungen nicht angezeigt
1. Aktualisierungseffekt auf der Verlaufsseite optimiert
1. Logik der automatischen Hauptaufgabe nach Unteraufgaben-Abschluss optimiert; Verarbeitung direkt auf der Detailseite
1.

**🐛 Fehlerbehebungen**

1. +-Button erschien manchmal auf der Momenten-Seite — behoben
2. Negative Aufgaben zeigten kein Gefühle-Dialog — behoben
3. Ziel negativer Aufgaben wirkte nicht — behoben
4. Versuch, „Einfrieren bis …“ bei Teamaufgaben zu reparieren
5. Bild auf der Gefühle-Seite konnte falsch angezeigt werden — behoben

**1.89.5 (2022/8/5)**

1. Netzwerkverbindungsproblem optimiert
2. Übersetzungen aktualisiert

**1.89.4 (2022/7/13)**

1. Informationen zu Xiaohong-Dot-Fragen korrigiert
2. Wiederholtes Generieren wiederholter Aufgaben behoben (diesmal wirklich repariert .jpg)

**1.89.3 (2022/7/05)**

**♻️ Verbesserungen**

1. Beurteilung der Schiebeschalter-Liste optimiert

**🐛 Fehlerbehebungen**

1. Berechnung konnte bei vielen Erfolgsbedingungen unvollständig bleiben — behoben
2. Benachrichtigung unbefristeter Aufgaben zeigte abnormalen Fristtermin — behoben
3. Hintergrund-Bearbeitung eines Gegenstands wirkte nach Kopieren auf Kopie — behoben
4. Fähigkeit beim Bearbeiten von Teamaufgaben wurde ggf. nicht vererbt — behoben

**1.89.2 (2022/6/23)**

**♻️ Verbesserungen**

1. Unnötige CAMERA-Berechtigung entfernt
2. Übersetzungen aktualisiert

**🐛 Fehlerbehebungen**

1. Einige Abstürze behoben

**1.89.0-1.89.1 (2022/6/09)**

**✨ Neue Funktionen**

1. Mehrfach freischaltbare bedingte Erfolge unterstützt
2. Erfolgsdetails zeigen Bedingungsdetails und Fortschritt
3. Aufgaben-Tags
4. Wiederholende Aufgaben ohne Frist
5. Ausverkaufte oder kauf gesperrte Gegenstände ausblenden
6. Beim Setzen des Erfahrungspunkte-Reduktionseffekts optional Nutzungslimit
7. Inventarseite unterstützt Mehrfachauswahl, Alles auswählen und Batch-Rückgaben
8. Standard-Aufgabenliste unterstützt Archivierung
9. Redesign mancher Seiten wie Einstellungen, Q&A, Shop-Symbolleiste und Listen-hinzufügen-Seite
10. Redesign mancher In-App-Icons (Standard-Aufgabenkarten, Münzen, Erfahrungspunkte, Erfolgs-Icons)
11. Bildspeicher in externen App-Privatpfad verschoben, um versehentliches Löschen zu vermeiden

**♻️ Verbesserungen**

1. Link zum Artikel [Kompatibilitätskonfiguration] auf der Einstellungsseite hinzugefügt
2. Pomodoro-Countdown — Reset-Bestätigungsdialog hinzugefügt
3. Beschreibung für Aufgaben-Einfrieren hinzugefügt
4. Beschreibung für Erfolgs-Unterkategorien hinzugefügt
5. Im Offline-Modus Button zum Verlassen des Offline-Modus auf der Profilbearbeitungsseite
6. Statistik negativer Aufgaben optimiert; Anzeige der Anzahl aufgegebener Aufgaben am Tag und Erfolgs-Tracking
7. App-Startgeschwindigkeit optimiert
8. Erfolgs-Icons unterstützen Vergrößerung
9. „Gefällt mir“-Statistik (empfangen) für Zufallsaufgaben hinzugefügt
10. Suchinteraktion einheitlich optimiert
11. Bei Gegenstandsauswahl zeigt leere Liste leeres Layout statt Laden
12. Große Bildansicht passt sich aktuellen Themenfarben an
13. Animations-Effekt bei Höhenänderung des Auswahl-Pop-ups für Gegenstände und Aufgaben optimiert
14. In Backup-Einstellungen löscht „Lokale Daten löschen“ auch Mediendateien
15. Speicher- und Löschlogik temporärer Dateien beim Fotografieren vereinheitlicht
16. Unterscheidung zwischen Standard-Gegenstands-Icon und fehlgeschlagen geladenem Icon
17. Unabhängige Strafeinstellung für Aufgaben standardmäßig aktiviert
18. Aktualisierung, Animation und Ladegeschwindigkeit der Gefühle-Seite optimiert
19. Manche Detail-Pop-ups mit Schnellbutton „Auswählen“
20. Bei ausgeschalteten Hauptschaltern „Soundeffekte“ und „Vibration“ in erweiterten Einstellungen entsprechende Hinweise in Tomaten-Einstellungen
21. Sortierung neuer Erfolge und Unterkategorien optimiert
22. Basisbibliothek und Abhängigkeiten aktualisiert
23. Berechnungsmethode und -geschwindigkeit des Erfolgsfortschritts optimiert
24. Berechnung der „Ziel-(Wiederholungs-)Anzahl“ folgt verbesserter Verlaufsstatistik, konsistent mit Detailanzahl
25. Bei Eingabe von Münzen und Zielwiederholungen werden alle aktuellen Werte automatisch ausgewählt
26. Fehlermeldung bei abnormaler WebDAV-Konfiguration optimiert
27. Fehlermeldung bei abnormaler Google-Drive-Backup optimiert
28. Aufgabenname auf der Detailseite kann jetzt ausgewählt werden

**🐛 Fehlerbehebungen**

1. Gesetzte Anzahl machte Aufgaben-Belohnung nach Wiederholungslogik ungültig — behoben
2. Sortier- und Gruppierungsproblem der Shop-Seite behoben
3. Abnormales Hoch-/Runterscrollen bei Zufallsaufgaben in manchen Fällen behoben
4. Pomodoro-Statistik auf der Statusseite nach positiver Zeitmessung manchmal ungenau — behoben
5. Wiederholungslogik von Teamaufgaben verlor Zählaufgaben-Typ — behoben
6. Von Tomato ausgewählte Aufgabe blieb hervorgehoben bei Erfolgsbedingungs-Auswahl — behoben
7. Gefühlsbild wurde nicht unabhängig gespeichert; Anzeigeprobleme — behoben
8. Fehlermeldung bei Login-Fehler konnte häufig erscheinen — behoben
9. Spezielle Eingabefelder für neue Aufgaben, Teams und Unteraufgaben sollten keine Tastatureingabe erlauben (Absturzgefahr) — behoben
10. Zählweise unbegrenzter Gegenstände in Widgets optimiert, konsistent mit der App
11. Nach ATM-Zinsanpassung konnte Zins nach akkumulierter Zeit und neuem Zinssatz berechnet werden — behoben
12. Eingefrorene Aufgaben konnten in Smart-Liste erscheinen — behoben
13. Blockierter Aktionsbutton unter Auswahlleiste war bei Auswahl (Aufgaben, Shop-Gegenstände) noch klickbar — optimiert
14. Gegenstandsfarben-Änderung aktualisierte UI nicht sofort — behoben
15. Plötzlich hoher Zinssatz nach langer niedriger Rate (ohne 1 Münze) konnte riesige Zinsen ergeben — behoben
16. Suchfeld erschien nach Aufgaben-Abschluss bei geöffneter Suche und Gegenstands-Nutzung — behoben
17. Tages-Abschlusszahl in App stimmte nach Umbenennung unbegrenzter Aufgabe ggf. nicht mit Widget überein — behoben
18. Seltsame Animationen beim Abschließen unbegrenzter Aufgaben behoben
19. Kopieren einer Aufgabe kopierte Hintergrund nicht — behoben
20. Erfolgsbedingungen erfüllt, Erfolg aber nicht freischaltbar — behoben
21. Datumsintervall-Berechnungsausnahme (kann mehrere Logiken betreffen) — behoben
22. Gefühle wurden auf Aufgaben-Detailseite nicht automatisch gefiltert — behoben

**1.88.4 (2022/4/21)**

1. Absturz bei Inventarsuche behoben
2. Anzeigestörung bei benutzerdefiniertem Hintergrund und Verlaufsseite behoben
3. UI-Überlappung beim Bearbeiten behoben
4. Menge konnte abnormal angezeigt werden, wenn Erfolg Gegenstände als Belohnung vergab — behoben
5. Abschlussanzahl bei Erfolgsberechnung stimmte in Sonderfällen nicht — behoben
6. Titel konnte bei schnellem Tippen auf Verlaufsseite verschwinden — behoben
7. Beim Erstellen/Bearbeiten einer Aufgabe: Nach Tipp auf Eigenschaft ließ sich Tastatur beim erneuten Tipp auf fokussiertes Feld nicht öffnen — behoben
8. Absturz beim Setzen monatliches Kauflimit auf Französisch behoben

**1.88.3 (2022/4/09)**

1. Nach Backup-Wiederherstellung meldete Cloud-Backup Konflikt — behoben
2. Bearbeitete Aufgaben-Startzeit und Unteraufgaben-Erinnerung wählten standardmäßig nicht die eingegebene Zeit — behoben
3. Andere Effekte wurden bei Batch-einfacher Synthese nur einmal berechnet — behoben
4. System-Erfolgs-Attribut Stufe 10 zählte nicht ins benutzerdefinierte Attribut — behoben
5. Abnormale Text-UI auf „Ich“-Seite für Nicht-Mitglieder behoben

**1.88.2(-)**

> Updates in 1.88.3 enthalten

**1.88.1 (2022/4/02)**

1. Absturz durch Backup-Erinnerung behoben

**1.88.0 (2022/3/30)**

✨ Neue Funktionen

1. Teilen von „Zufallsaufgaben“ im Weltmodul hinzugefügt
2. Zähl-Gegenstände können optional Koeffizient für Gegenstandsanzahl setzen
3. Kreditzinssatz konfigurierbar
4. Bildverwaltung: Ein-Klick-Filter ungenutzter Bilder + Alles auswählen
5. Benutzerdefinierte Bildzuschnittgröße (höher aufgelöste Icons, Mitgliedsfunktion)
6. Schalter „Gefühle“ innerhalb des Erfolgs explizit angezeigt
7. Sortieralgorithmus der Liste „Alle“ optimiert

⚡️ Optimiert

1. Visuelle Effekte mancher Pop-ups optimiert
2. Interaktion Backup/Wiederherstellung optimiert
3. Ladegeschwindigkeit der Delegationsseite optimiert
4. Ladegeschwindigkeit des Produktauswahl-Pop-ups deutlich optimiert

🐛 Fehlerbehebungen

1. Unordnung benutzerdefinierter Hintergründe behoben
2. Aufgabe konnte in gelöschter Liste erstellt werden — behoben
3. Einige Absturzfehler behoben

**1.87.1（2022/3/07）**

1. Sortiermenü von Shop und Inventar zeigt „Benutzerdefiniert“ explizit
2. Abnormale Sortierung im Inventar — behoben
3. Button zum E-Mail-Feedback auf der Feedback-Seite hinzugefügt
4. Hinweis bei Wiederherstellungsfehler wegen Datenbankversion optimiert
5. Münzanzahl auf Kompaktmodus-Karte wurde nicht angezeigt — behoben

**1.87.0 official version (2022/3/04)**

1. Benutzerdefinierter Kartenhintergrund zoomte in manchen Fällen abnormal — behoben
2. Tipp auf Aufgaben-Erinnerungsbenachrichtigung sprang bei fortlaufenden Erinnerungen ggf. zu falschen Details — behoben
3. Karten-Zahlen aktualisierten sich beim Wischen zur Erhöhung der Zählaufgaben nicht — behoben
4. Neue Leitaufgabe für manche Sprachen hinzugefügt

**1.87.0-rc02（2022/2/25）**

1. Fehlerbehandlung und Hinweise bei Wiederherstellungsvorgängen verbessert
2. Interaktion bei „Wochentag“-Einstellung optimiert; Warnung bei anormaler Einstellung (Start und Periode nicht am selben Tag)
3. Nachtmodus-Farben mancher Seiten optimiert
4. Cache in Bildauswahl und Bildverwaltung konnte falsch angezeigt werden — behoben
5. „Download“ im Backup-Konflikt-Pop-up unterstützte Google Drive/Dropbox nicht — behoben
6. Shop-Suche konnte falsche Ergebnisse zeigen — behoben
7. Anheften einer Aufgabe konnte fehlschlagen — behoben
8. UI-Ausnahmen und Textprobleme behoben

**1.87.0-rc01（2022/2/23）**

**✨ Neue Funktionen**

1. Erfolgs-Unterkategorie unterstützt Einklappen
2. Material-You-Designschalter eingeführt (experimentell)
3. Inventar sortierbar nach Shop
4. Inventar unterstützt „Favorit“-Markierung für Gegenstände
5. Shop unterstützt Alles auswählen
6. Shop- und Inventar-Vorgänge unterstützen MAX-Menge
7. Aufgaben unterstützen fortlaufendes Erstellen
8. Aufgaben-Konfiguration: Gegenstands-Belohnungsbeschreibung wird automatisch in Kartennotizen eingefügt („Belohnung: [Produkt] x1“)
9. Aufgaben unterstützen festgelegte Einfrierdauer

**⚡️ Verbesserungen**

1. „Überspringen“-Button im Backup-Konflikt-Pop-up hinzugefügt
2. Google-Play-Version unterstützt Französisch/Polnisch
3. Aufgaben-Benachrichtigung unterstützt Sprung zu Aufgabendetails
4. Beim Bearbeiten aufgabenbezogener Zeit zeigt Standard-Pop-up die Zeit vor der Bearbeitung statt der aktuellen
5. Jeder Listeneintrag im Shop unterstützt „Umbenennen“, „Löschen“, „Neu“
6. UI-Redesign der Erweiterungsseite
7. Zweite Bestätigung für „Kalenderkonto löschen“ hinzugefügt
8. Ausverkauftes Produkt wird nicht mehr automatisch vom Regal genommen
9. Beispielaufgabe „Früh aufstehen“ auf Strafe 0 geändert
10. Bei negativer Gegenstandsmenge bei Belohnung erscheint Warnung
11. Zufallsalgorithmus für Münzen im Gegenstands-Nutzungseffekt optimiert
12. „Als abgeschlossen markieren“ mit Abschluss-Soundeffekt
13. UI-Darstellung im Nachtmodus an manchen Stellen optimiert
14. Performance der Aufgabenliste optimiert

**🐛 Fehlerbehebungen**

1. Anomalie des Textes „unconcerned“ in manchen Sprachen behoben
2. Produkt-Icon im „Zurückgeben“-Pop-up konnte abnormal angezeigt werden — behoben
3. Aufgabe konnte bei schnellem Abschluss wiederholt generiert werden — behoben
4. Speicher der aktuellen Liste im „Synthese“-System konnte ungültig werden — behoben
5. QQ-Login im Querformat ggf. nicht möglich — behoben
6. Rezeptbearbeitung in Liste [Alle] im „Synthese“-System: Rezept verschwand aus Ursprungsliste — behoben
7. Mehrfaches schnelles Abschließen unbegrenzter Aufgabe setzte Abschlusszahl auf null — behoben
8. Backup-Intervall konnte nicht auf „Monatlich“ gesetzt werden — behoben
9. Erfahrungspunkte-Icon im einfachen Modus nicht angezeigt — behoben
10. Spalten „Erfolge“ und „Erfolgsliste“ in Bildverwaltung fehlten — behoben
11. Aufgaben-Detailseite unterstützte kein Aufgeben von Teamaufgaben — behoben
12. Anleitung des Weltmoduls wurde nicht korrekt angezeigt — behoben
13. Produkt konnte bei fehlgeschlagenem Bild-Upload geteilt werden, lokales Bild wurde überschrieben — behoben
14. Seltene Abstürze und Ausnahmen behoben

**1.86.0（2022/1/20）**

**Neue Funktionen**

1. Erfolgs-Unterkategorie: Kategorien teilen, Kategorieanzahl automatisch zählen
2. Google-Drive-Backup
3. Bildverwaltung (auf der Backup-Seite)
4. Zufälliger Münzeffekt bei Gegenständen
5. Batch-Kopie von Erfolgen
6. Schrittzählung unterstützt mehrfache Schritteingabe und mehrere Belohnungen
7. Pomodoro unterstützt Gegenstands-Tausch
8. Benutzerdefiniertes Rückgabe-Rabattverhältnis
9. Exklusives Backup-Format (manche Systeme öffnen/importieren direkt)
10. Einfache Synthese unterstützt Batch-Betrieb
11. Neue benutzerdefinierte Soundeffekt-Option: Gegenstands-Nutzung
12. Neue Erfolgs-Freischaltbedingung: aktuelle ATM-Einlage
13. Statistik negativer Angelegenheiten unterstützt Detailseite
14. Liste „Alle“ umbenennbar
15. Benennung und Beschreibung von Benachrichtigungskanälen der App vereinheitlicht

**Verbesserungen**

1. Freigeschaltete Erfolge ohne erhaltene Belohnung priorisieren
2. Pomodoros heutige Fokuszeit auf der Statusseite wird stundenweise angezeigt
3. Inventar zeigt Gegenstandsbeschreibung
4. Neue Kontoregistrierung zeigt Bestätigungsdialog
5. Wartungsankündigungen anzeigbar
6. „Überspringen“-Bestätigung für Pomodoro-Zusatzzeit hinzugefügt
7. Datenspeicherung bei App-Deinstallation (Systemunterstützung erforderlich)
8. Backup- und Wiederherstellungslogik optimiert
9. Überfälligkeitslogik einzelner und unbegrenzter Gegenstände optimiert; Bearbeitung unterstützt
10. Diagramm-Statistik unbegrenzter Ereignisse nach Abschlusszeit statt Frist
11. Kompaktmodus-Karte zeigt Überfälligkeitszeit einzelner und unbegrenzter Gegenstände
12. Überlebensrate der Countdown-Funktion im Hintergrund verbessert
13. Gefühle-Funktion optimiert:
    -Standardmäßig an
    -Teamaufgaben-Einstellungsseite zeigt unwirksamen „Gefühle“-Schalter nicht
    -Verwirrende Speicherfunktion des Gefühle-Schalters entfernt
14. Pop-up für Gegenstands- und Inventarlisten zeigt mehr Gegenstände
15. Bei laufender Zeit in der Benachrichtigungsleiste wird Vibration abgebrochen
16. Dynamischer Text im Weltmodul unterstützt Teilauswahl
17. Datenaktualisierungs-Animation auf benutzerdefinierter Erfolgsseite optimiert
18. Wiederherstellungslogik: „Laden“-Dialog statt hängender Oberfläche
19. Unterer Button in „Absturz-Pop-up“ war ggf. nicht sichtbar — optimiert
20. Tipp auf Aufgaben-Benachrichtigung springt zur Liste der Aufgabe
21. Benutzerdefiniertes Attribut-Icon: integrierte Icon-Bibliothek wählbar
22. „Später lesen“-Freigabe zeigt Operationsname statt App-Namen
23. Erfolgs-Freischalt-Benachrichtigung zeigt jetzt Erfolgsbeschreibung
24. Desktop-Widget springt beim Öffnen der Startseite zum Modul „Delegation“
25. Textanzeige nach Abschluss der Tagesliste optimiert
26. Bedienungstext und -ablauf des Gegenstands-Countdown-Effekts optimiert
27. Wenn alle Attribute ausgeblendet sind, zeigt Statusseite keine „Attribut“-Karte

**Fehlerbehebungen**

1. Seltener Absturz bei Erfolgs-Freischalt-Pop-ups behoben
2. Eine Aufgabe konnte in schmalen Desktop-Widgets mehrere Zeilen belegen — behoben
3. Erste Bewegungsberechtigung für Schrittzählung konnte Gesamtschritte des Sensors anzeigen — behoben
4. Absturz oder Verwirrung beim Pausieren eines Countdowns und Start eines anderen — behoben
5. 0-Minuten-Countdown-Effekt bei Gegenständen verursachte Absturz — behoben
6. Name der aktuell gewählten Liste aktualisierte sich beim Umbenennen auf Hinzufügen/Bearbeiten-Seite nicht — behoben
7. Abnormale Anzeige von Karten mit „jährlicher“ Wiederholungsfrequenz — behoben
8. Benutzerdefinierte Münzen wirkten manchmal nicht rechtzeitig — behoben
9. Widgets zeigten eingefrorene Gegenstände — behoben
10. Benutzerdefinierter Erfolg zeigte keinen „Langdruck“-Hinweis — behoben
11. Gesamt-Erfahrungspunkte auf „Ich“-Seite zählten benutzerdefinierte Attribute nicht — behoben
12. „Gefühle“-Seite sprang nach Bildvorschau abnormal nach oben — behoben
13. Statischer „Tomaten“-Kurzweg sprang unter MIUI nur zur Startseite, wenn App bereits gestartet — behoben
14. Nicht-Mitglieder konnten benutzerdefinierte Hintergründe laden — behoben
15. Münzanzahl auf Shop-Seite aktualisierte sich nicht rechtzeitig — behoben
16. Kalender konnte nicht ins nächste Jahr blättern — behoben
17. Listenname im Widget aktualisierte sich nach Listenumbenennung nicht — behoben

**Release Candidate → Offizielle Version**

1. Erfolgsrate beim Upload großer Dateien auf Google Drive optimiert; mehr Wiederholungen und Blockstrategie
2. Mitglieder sahen ggf. keinen Button für individuelle Aufgaben-Hintergründe in nicht-chinesischer Umgebung — behoben
3. Bei fehlgeschlagenem Google-Drive/DropBox-Backup Sprung zur Backup-Seite statt WebDAV-Konfiguration
4. Pop-up bei Google-Play-Verifizierungsfehler mit Datenexport-Pfad
5. Spitzname auf „Ich“-Seite ändert Farbe je nach Mitgliedschaft
6. Gleitkomma-Fehler bei ATM-Zinssatz in den meisten Szenarien beseitigt
7. Beim Löschen lokaler Daten werden Hintergrund, Attributbilder und Sounddateien mitgelöscht
8. Abnormales Schrittzahl-Diagramm behoben
9. Attribute auf Neuer-Aufgabe-Seite aktualisierten sich nach Hilfe → Attribut-Anpassung → Zurück nicht — behoben
10. Beim Anpassen des Gegenstandseffekts schließt Tipp außerhalb das Pop-up nicht mehr automatisch
11. Fremdsprachige UI auf Gegenstands-Einstellungsseite optimiert (russischer Text zu lang)
12. Versuch, Farb-Toast-Absturz auf manchen Modellen zu beheben
13. Nutzen-Button war klickbar, wenn Inventarseite ausgewählt — behoben
14. Anzeige überfälliger Einzelaufgaben in Smart-Liste an neue Überfälligkeits-Speicherung angepasst
15. Bei ausgewähltem Inventar soll Umschaltliste abgewählt werden

**1.85.4 (2021/12/08)**

Reguläre Fehlerbehebungsversion; nächste Feature-Version noch in Entwicklung~

1. Standard-Münz-Icon des Widgets im Nicht-Dunkelmodus wurde nicht korrekt angezeigt — behoben
2. Fortschrittsbalken-Animation bei fortlaufendem Stufen-Auf-/Abstieg spielte nicht normal — behoben
3. Münzanzahl auf Inventarseite aktualisierte sich nicht rechtzeitig — behoben
4. Frist konnte beim Bearbeiten des „Wochentag“-Elements zwangsweise geändert werden — behoben
5. Bildschirmrotation konnte geänderte Unteraufgaben-Infos beim Bearbeiten von Aufgaben löschen — behoben
6. Münzanzahl wirkte beim Erstellen/Bearbeiten von Produkten nicht — behoben
7. Anzeigebedingungen der jährlichen Abschlussanzahl auf der Änderungs-Detailseite
8. Bildspeicher in der App optimiert; sollte nicht im System-Fotoalbum erscheinen
9. Beschreibung des Gefühle-Schalters optimiert
10. Einige Abstürze behoben

**1.85.3 (2021/11/18)**

1. Zeitberechnung der Zeitmessung optimiert; gleicht CPU-Schlafzeit aus
2. Icon-Bearbeitung beim Kopieren eines Produkts ließ Original-Icon verschwinden — behoben
3. Weitere kleine Fehlerbehebungen (z. B. Team-Tag)

**1.85.2 (2021/11/07)**

1. Nach Pausieren der Zeitmessung entstanden bei Abrechnung keine Einträge/Belohnungen — behoben
2. „Verschieben nach“ unter Smart-Liste ließ Liste falsch erscheinen — behoben
3. Anzeige „Aktuelle Münzanzahl“ stimmte nicht mit Berechnung überein (ohne ATM-Einlagen) — behoben
4. Eintrag und Belohnung wiederholten sich nach Pomodoro-Arbeit und zweimaligem Überspringen — behoben

**1.85.1 (2021/11/02)**

0. Ladeproblem der Gefühle-Liste behoben

**1.85.0 2021/10/20)**
*Neue Funktionen*

1. Pomodoro unterstützt positive Zeitmessung
2. Mehrzeiligen Text einfügen, um schnell Unteraufgaben zu erstellen
3. Gegenstände unterstützen Kopieren
4. Wischrichtung der Gegenstandsliste umschaltbar; Rückwärts unterstützt (Einstellungen → Gegenstände)
5. Pomodoro-Eintrag kann gelöscht werden
6. Pomodoro: erzwungener Quer-/Hochformat-Umschalter
7. Erfolgs-Freischaltbedingungen erweitert:
   ● Anzahl durch Synthese erhaltener Produkte
   ● Kumulierte erhaltene Gegenstandsmenge
   ● Aktuelle Produktmenge
   ● Lebensstufe
   ● (Wiederholend) Fokuszeit der Aufgabe
8. Fähigkeiten-Icon unterstützt mehrere Zuschnitt-Einstellungen
9. Statischer Kurzweg:
   ● Neue Aufgabe
   ● Pomodoro-Seite öffnen
10. Soundeffekt-Anpassung erweitert:
    ● Erfolgs-Belohnungen erhalten (System- und benutzerdefinierte Erfolge)
    ● Lootbox öffnen
    ● Synthese (einfache Synthese und Synthese)
    ● Benachrichtigungs-Soundeffekt
11. Münz-Icon anpassbar
12. Gegenstands-Nutzungseffekt unterstützt mehrere Erfahrungspunkte-Änderungseffekte
13. Anpassung der Fähigkeiten im Erfahrungspunkte-Kreisdiagramm geändert
14. Verlaufsseite unterstützt Statusfilter
15. Team-Tag-Funktion

*Verbesserungen*

1. Bei Münz-Belohnung 0 bei Unteraufgabe wird sie in Details nicht angezeigt
2. Neue Erfolgslisten-Seite mit Anleitung „Erfolg erstellen“
3. Widget-Icon-Anzeige optimiert
4. Soundeffekte beim Abschließen von Unteraufgaben (Details, neue Seiten)
5. Nach Eingabe auf Erstellen/Bearbeiten-Seiten (Aufgaben, Gegenstände, Erfolge, Synthese): Zurück zeigt Bestätigung zum Verwerfen
6. Sortierung bei Produkterstellung optimiert (bei benutzerdefinierter Sortierung neue Produkte oben)
7. Beim Bearbeiten von Aufgaben/Gegenständen öffnet sich die Tastatur nicht automatisch
8. Neue-Aufgabe-Seite unterstützt Querformat ohne Datenverlust
9. Mitglieder-Themenfarbe für Desktop-Widgets
10. Produktauswahlbox optimiert: zuerst Anzeige, dann asynchrones Laden
11. Inventar-Tab erhält Einträge „Synthese“ und „ATM“
12. [Als abgeschlossen markieren] und [Rückgängig] im Verlaufs-Statuswechsel zurück ins Hauptmenü
13. Pomodoro-Schnelleinstieg in Ereignisdetails
14. Sortierung der Shop-Liste „Alle“ optimiert (Gruppierung nach Liste, nur Shop)
15. Nach Wochentags-Wiederholung wird Frist neu berechnet (verhindert Wochenend-Frist bei Werktags-Wiederholung)
16. Beim Zurück zur „Delegation“-Seite wird „+“-Button angezeigt, falls er fehlte

*Fehlerbehebungen*

1. Listenfortschritt aktualisierte sich nicht rechtzeitig, wenn Erfolgsseite in unterer Navigation — behoben
2. Statuswechsel historischer Gegenstände behoben
3. Überfälligkeitsanzeige bei negativem Countdown repariert
4. Münz-Erfolge sollen in ATM-Einlage einfließen
5. Bei pausiertem Pomodoro löschte doppeltes Wiederbetreten die Zeit — behoben
6. Kaufrestriktion konnte unter Umständen ungültig werden — behoben
7. Countdown-Einträge konnten selten doppelt erscheinen — behoben
8. Schnelles Tippen verschiedener Aufgabenkarten ließ eine Karte leer — behoben
9. Logik der automatischen Münz- und Erfahrungspunkte-Berechnung angepasst
10. Einige Abstürze behoben

**1.84.4 (2021/10/09)**

1. Eingebautes Icon wurde ggf. nicht angezeigt — behoben

2. Q-Gruppe aktualisiert

**1.84.3 (2021/10)**

1. Texte für den Auslandsmarkt aktualisiert

**1.84.2 (2021/09/26)**

1. Durch Synthese verursachter Deadlock — behoben

2. In Produktdetails nicht verfügbarer Produkte wurden abnormale Nutzungseffekte angezeigt — behoben

3. Visueller Effekt abgerundeter Widget-Ecken optimiert

**1.84.1 (2021/09/20)**

1. Ziel-Wiederholungsanzahl ließ sich beim Bearbeiten nicht löschen — behoben

**1.84.0 (2021/09/19)**

***Neue Funktionen***

1. Fähigkeiten-System (Attribute-Anpassung)

   Alle bisherigen Mechanismen sind an das Attribute-Anpassungssystem angepasst, z. B. Erfolgs-Attribute erreichen Freischaltbedingungen, Produkte vergeben Erfahrungspunkte als Belohnung usw.

2. Essbarer Pomodoro-Effekt anpassbar; Erfahrungspunkte-Wert und Attribute-Typen änderbar

3. Shop-Icon unterstützt Änderung des Zuschnitt-Stils (Shop-Einstellungen)

4. Produktdetails zeigen nun eine Liste der Nutzungseffekte

5. Mitglieder-Themenfarbe #6bab8b hinzugefügt

6. Erinnerungs-Kalenderkonto löschen unterstützt

***Verbesserungen***

1. Pomodoro-Seite unterstützt Querformat

2. Beschreibung „Leihbarer Betrag“ in Produkteinstellungen hinzugefügt

3. Hinweis zur Dateigröße der Cloud-Synchronisation hinzugefügt

4. Facebook- und Dropbox-Abhängigkeiten aktualisiert

5. Teilweise UI-Anzeige und Texte optimiert

6. Interaktion bei neuen Unteraufgaben optimiert

***Fehlerbehebungen***

1. Standard-Icon-Version des Attributes war inkonsistent — behoben

2. Schnelles Tippen zum Öffnen der Box konnte wiederholtes Auspacken oder Absturz auslösen — behoben

3. Bereits erinnerte Kalenderereignisse wurden beim Löschen von Gegenständen nicht synchron entfernt — behoben

4. Abnormaler Status nach Änderung eines Gegenstands von „Abgeschlossen“ auf „Überfällig“ auf der Verlaufsseite — behoben; historische Daten werden beim Upgrade auf die neue Version automatisch repariert

5. Beim Erstellen eines neuen Produkts war die aktuell gewählte Liste im Listenauswahl-Dialog falsch markiert; Anzeige der Liste „Alle“ entfernt — behoben

6. Beim Bearbeiten anderer Inhalte + Ziel-Wiederholungsanzahl schlug die Bearbeitung erneut fehl — behoben

7. Auf der Seite „Neuer Erfolg“ ließ sich die Attribute-Auswahl nicht bearbeiten und blieb leer — behoben

8. Weitere kleinere Fehlerbehebungen und Optimierungen

**1.83.16 (2021/08/20)**

1. Absturz und fehlende Wirkung bei Avatar-Änderung im Offline-Modus — behoben
2. Interaktion bei Auswahl des Produkt-Auspack-Effekts optimiert
3. Fokusproblem bei einigen langen Texteingabefeldern — behoben
4. Erinnerungsfrist und -zeit wurden in manchen Fällen falsch angezeigt — behoben
5. Konfigurationsänderungen des kompakten Modus traten nicht sofort in Kraft — behoben

**1.83.15**

1. Straf-Aufgaben in App-Widgets markieren unterstützt
2. Abnormales Verhalten beim „Einklappen von Angelegenheiten außerhalb von sieben Tagen“ — behoben
3. Obergrenze für Gefühle-Bilder auf 9 erhöht
4. Anmeldeseite zeigt die letzte Anmeldemethode
5. Bei Strafaufhebung (als abgeschlossen markiert) wird keine zusätzliche Belohnung vergeben
6. Smart-Liste unterstützt nun Anzeige abgeschlossener Gegenstände
7. Abnormale automatische Sicherung in den Download-Ordner in manchen Fällen — behoben
8. Einige UI-Anzeigeprobleme — behoben

**1.83.14**

1. Pomodoro zeichnete bei „Überspringen“ ggf. keine Dauer auf — behoben
2. Straf-Gegenstände führten Überfälligkeits- und Straf-Logik aus — behoben
3. Probleme beim Bearbeiten von Strafen — behoben
4. Probleme bei Bildauswahl im Querformat — behoben
5. Gelegentlicher Wiederherstellungsfehler bei Backup aus benutzerdefiniertem Pfad — behoben

**1.83.8-1.83.13**
Neue Funktionen

1. Unabhängige Einstellung des Kartenhintergrunds unterstützt
2. Funktion „Eintrag löschen“ unterstützt nun Löschen von Gefühlen, Lagern und Zeitmess-Einträgen
3. System-Erfolge können Erfahrungspunkte oder Münzen als Belohnung wählen
4. Ereignissuche
5. Lokale automatische Sicherung in den Ordner „download“ unterstützt (Android 10 und höher)

Verbesserungen

1. Standard-Aufrufmethode für Benachrichtigungserinnerungen verbessert; sollte die Erfolgsrate ab Android 6 theoretisch erhöhen
2. Benachrichtigungspriorität des Pomodoro-Timers auf [Hoch] erhöht; Überlebenswahrscheinlichkeit des Hintergrund-Timers und Benachrichtigungsanzeige verbessert
3. Auf der Seite QQ-Gruppe und offizielle Website verlinkt, UI optimiert; QQ unterstützt Beitritt per Klick
4. Auslösezeitpunkt von Erfolgs-Benachrichtigungen verbessert; soll unmittelbar nach Auslösung auf der Startseite erinnert werden
5. Checkbox „Nur auf aktuelle Liste anwenden“ in der Option „Filtern“ der Gegenstandsliste hinzugefügt; Standard- und Alle-Listen-Optionen getrennt
6. Animationseffekte bei der Synthese hinzugefügt
7. Feedback: Kanal der Rabbit-Xiaochao-Community erweitert; erleichtert Bild-Upload und Issue-Tracking
8. Relative Wertanzeige im Eingabefeld für Zähl-Gegenstände hinzugefügt
9. Anzeige nicht ausgewählter Tabs optimiert
10. Zufälliger Hinweis beim Tippen auf Avatar entfernt; Tippen öffnet stattdessen die persönliche Startseite
11. Ist keine Münz-Belohnung gesetzt, wird „nicht gesetzt“ statt „0“ angezeigt
12. Liegt die Auspack-Wahrscheinlichkeit unter 0,01 %, wird nicht mehr „0,00 %“, sondern „<0,01 %“ angezeigt
13. Gefühle-Schalter wird nicht mehr gemerkt und ist standardmäßig aus
14. Ablauf für Kalender- und Kamera-Berechtigungen optimiert
15. Klick- und Anzeigeeffekt einiger Seiten optimiert
16. Kalender-Erinnerungsmethode optimiert; versucht, das Problem zu lösen, dass manche Geräte das Kalenderkonto löschen

Fehlerbehebungen

1. Absturz bei fortlaufendem Filtern auf der Gefühle-Seite — behoben
2. Versuch, seltenen Absturz des voreingestellten Dialogs zu beheben
3. Bei langem Eingabefeld sprang Tippen auf Text automatisch ans Ende — behoben
4. Zufällige Münz-Belohnungen ließen sich beim Erstellen eines Teams nicht setzen — behoben
5. Inland-Distributionsversion entfernt Firebase-Abhängigkeiten vollständig
6. Gelegentliche Ausnahme beim Aktualisieren der Erfolgslisten-Seite — behoben
7. Gelegentlicher Absturz bei Auswahl des eingebauten Icons — behoben
8. Nach Löschen aller Unteraufgaben blieben Unteraufgaben auf der Detailseite sichtbar — behoben
9. Name der Synthese-Standardliste ließ sich nicht bearbeiten — behoben
10. Filterfeld wurde auf der Profilseite angezeigt — behoben
11. Team-Gegenstand wurde nach Setzen der Produkt-Belohnung nicht vererbt — behoben

**1.83.7 (2021/06/24)**

1. Listen nach hinzugefügten Münzen sortiert
2. Sprachauswahl auf der Einführungsseite hinzugefügt
3. Ladegeschwindigkeit der Erfolgsseite optimiert
4. QQ-Gruppe auf Beitrittsinformation per Klick geändert
5. Fortlaufendes Tippen beim Auspacken konnte Inventar mehrfach ändern — behoben
6. Falsche Anzeige einzelner überfälliger Gegenstände in der Tages-Gegenstandsliste — behoben

**1.83.6 (2021/06/22)**

Neue Funktionen

1. (Mitglieder) Unabhängige Einstellung des Kartenhintergrunds unterstützt
2. Funktion „Eintrag löschen“ unterstützt nun Löschen von Gefühlen, Lagern und Zeitmess-Einträgen
3. System-Erfolge können Erfahrungspunkte oder Münzen als Belohnung wählen
4. Ereignissuche
5. Lokale automatische Sicherung in den Ordner „download“ unterstützt (Android 10 und höher)

Optimierung

1. Standard-Aufrufmethode für Benachrichtigungserinnerungen verbessert; sollte die Erfolgsrate ab Android 6 theoretisch erhöhen
2. Benachrichtigungspriorität des Pomodoro-Timers auf [Hoch] erhöht; Überlebenswahrscheinlichkeit des Hintergrund-Timers und Benachrichtigungsanzeige verbessert
3. Auf der Seite QQ-Gruppe und offizielle Website verlinkt, UI optimiert; QQ unterstützt Beitritt per Klick
4. Auslösezeitpunkt von Erfolgs-Benachrichtigungen verbessert; soll unmittelbar nach Auslösung auf der Startseite erinnert werden
5. Checkbox „Nur auf aktuelle Liste anwenden“ in der Option „Filtern“ der Gegenstandsliste hinzugefügt; Standard- und Alle-Listen-Optionen getrennt
6. Animationseffekte bei der Synthese hinzugefügt
7. Feedback: Kanal der Rabbit-Xiaochao-Community erweitert; erleichtert Bild-Upload und Issue-Tracking
8. Relative Wertanzeige im Eingabefeld für Zähl-Gegenstände hinzugefügt
9. Anzeige nicht ausgewählter Tabs optimiert
10. Zufälliger Hinweis beim Tippen auf Avatar entfernt; Tippen öffnet stattdessen die persönliche Startseite
11. Ist keine Münz-Belohnung gesetzt, wird „nicht gesetzt“ statt „0“ angezeigt
12. Liegt die Auspack-Wahrscheinlichkeit unter 0,01 %, wird nicht mehr „0,00 %“, sondern „<0,01 %“ angezeigt

**1.83.0-alpha04 (2021/05/23)**

1. Freie Konfiguration, Sortierung und Deaktivierung des unteren Moduls unterstützt
   Module werden schrittweise angepasst; derzeit nur einige Funktionsmodule (z. B. Pomodoro; Verlauf noch nicht angepasst)
2. Zweiter Pausenmodus zum Countdown-Effekt des Produkts hinzugefügt; bleibt in der Benachrichtigungsleiste und kann jederzeit fortgesetzt werden
    Und „experimentell“-Logo hinzugefügt
3. Beim Überspringen des Pomodoro Hinweis hinzugefügt, dass kein Pomodoro erhalten werden kann
4. Hinweis zum Ein- und Ausklappen der Beispiel-Aufgabe hinzugefügt
5. Absturz durch Layout oben in der Liste auf manchen Seiten — behoben
6. Netzwerkfehler-Hinweis bei getrennter Verbindung optimiert
7. Münz-Belohnungshinweis beim Abschließen von Unteraufgaben optimiert; geändert zu nicht-blockierendem Toast

**1.83.0-alpha03 (2021/05)**

1. Leeres Layout der Synthese-Seite konnte den Bildschirm überschreiten — behoben
2. Attribute-Name „Charme“ wurde auf der Erstellungsseite falsch angezeigt — behoben
3. Einige Probleme bei Münz-Einstellungen — behoben
4. Animation der Erfolgsseite an Szene in unterer Navigationsleiste angepasst
    (Angepasst, aber Oberfläche noch nicht bereit; bitte auf Folge-Updates warten)
5. Ziel-SDK-Version auf Android 11 aktualisiert
6. Leeres Layout der Seite „Moment“ — behoben
7. Abnormale Zinsberechnung — behoben

**1.83.0-alpha02 (2021/05/16)**

1. Synthese-Rezepte konnten in der Liste „Alle“ erstellt werden — behoben
2. Nach Betreten der Synthese-Oberfläche wird unabhängig von der aktuellen Liste immer der Inhalt der Liste „Alle“ angezeigt.
3. Einfache Reparatur der ATM-Zinsberechnungsmethode

**1.83.0-alpha01 (2021/05/16)**

1. Vollständiges Synthese-System mit beliebiger N-zu-N-Synthese
   - Checkliste
   - Neu/Bearbeiten
   - Synthese-Dialog
   - Nachtmodus und Mehrsprachigkeit
   - „Eingang“ oben auf der Shop-Seite
2. Interner Code der Seite „Neue Aufgabe“ refaktoriert
    Für Skalierbarkeit der App haben wir den Code für neu erstellte Aufgaben weitgehend neu geordnet; UI-Neugestaltung ist möglich.
    Folgende Alpha-Updates fügen u. a. „Ziel-Wiederholungsdatum“, „relative Erinnerungszeit“, „Straf-Aufgaben (noch offen)“ und weitere Funktionen hinzu.
    Bei Problemen kann jederzeit zur alten Seitenversion gewechselt werden.

3. ATM-Eingang oben im Shop hinzugefügt
4. Aufgaben-Anhänge unterstützen bis zu 9 Bilder; Speicherpfad angepasst
5. Team-TAG-Funktion
    Implementierung ist eingebaut, konkreter TAG-Inhalt ist noch nicht konfiguriert und wird vorerst nicht angezeigt

**1.82.16 (2021/05)**

1. Beispiel-Aufgaben führten Überfälligkeits-Logik nicht korrekt aus (nur für neue Nutzer) — behoben
2. Abschlussanzahl unbegrenzter Aufgaben fehlte in manchen Szenarien einmal — behoben

**1.82.15 (2021/05)**

1. Wiedergabeproblem bei Hintergrund-Soundeffekten — behoben

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Unbegrenzte Aufgaben konnten Listenladen verlangsamen und Abbruchzählung ungenau machen — behoben
2. Aufgabenabschluss im Desktop-Widget konnte Abschluss-Sound mehrfach abspielen — behoben
3. Gesamtzählung der oberen Gegenstände in der Smart-Liste war ungenau — behoben
4. Alle lokalen Daten löschen und Konto löschen unterstützt
5. Bearbeitung von Unteraufgaben bei Team-Aufgaben wurde nicht vererbt — behoben

**1.82.12 (2021/05)**

1. Zählproblem beim Rückgängigmachen abgeschlossener unbegrenzter Aufgaben — behoben
2. Eingefrorene Aufgaben wurden weiterhin erinnert — behoben
3. Listenwechsel optimiert; kann Wechselgeschwindigkeit auf älteren Geräten erhöhen und Ladeanimationen hinzufügen
4. Benutzerdefinierter Ruhe-End-Sound wirkte nicht; End-Sound der Produkt-Zeitmessung konfigurierbar — behoben
5. Pomodoro zählte bei „Überspringen“ keine Fokuszeit — behoben
6. Pausen-Button des Produkt-Countdowns wirkte nicht — behoben

**1.82.11 (2021/05)**

1. Zählproblem beim Rückgängigmachen abgeschlossener unbegrenzter Aufgaben — behoben
2. Eingefrorene Aufgaben wurden weiterhin erinnert — behoben
3. Listenwechsel optimiert; kann Wechselgeschwindigkeit auf älteren Geräten erhöhen und Ladeanimationen hinzufügen
4. Benutzerdefinierter Ruhe-End-Sound wirkte nicht; End-Sound der Produkt-Zeitmessung konfigurierbar — behoben
5. Russische Sprache unterstützt

**1.82.10 (2021/05)**

1. Pomodoro zählte bei „Überspringen“ keine Fokuszeit — behoben
2. Pausen-Button des Produkt-Countdowns wirkte nicht — behoben
3. Absturz durch fehlgeschlagenes Erstellen einer Kalendererinnerung abgefangen

**1.82.9 (2021/05)**

1. Zeitlimit der kopierten Aufgabe konnte geleert werden und bei Wiederholung abstürzen — behoben
2. Aktualisierungsgeschwindigkeit nach Abschluss unbegrenzter Aufgaben optimiert
2. Berechnung der Erinnerungszeit bei Team-Aufgaben — behoben
3. Abschluss per Wischen ließ Animation hängen und Anzeige leer — behoben
4. Team-Aufgaben unterstützen Aufgeben per Wischen
5. Produktbeschreibung im Kauf-Fenster unterstützt Scrollen

**1.82.8 (2021/04/28)**

**Neue Funktionen**

1. Anzeige der aktuellen Abschluss-Serie hinzugefügt
2. Countdown-Effekt von Shop-Gegenständen optimiert; Aktionen Beenden und Pausieren hinzugefügt; bei abnormaler Beendigung wird in absoluter Zeit berechnet
3. Vibrationsmodus und Klingel-Schalter des Pomodoro getrennt einstellbar
4. Teilweise Vorschau künftiger Fristen laufender Ereignisse im Kalender unterstützt
5. Einzel- und unbegrenzte Ereignisse neu starten unterstützt
6. Datenanzeige auf der Seite „Ich“ geändert: „Überfällig“ und „Aufgeben“ → „Erfolg (freigeschaltet)“ und „Gefühle“; Statistikseite zeigt Anzahl „Überfällig“ und „Aufgegeben“
7. Widget-Erstellung direkt von der Seite „Desktop-Widgets“ anfordern unterstützt (nur Android 8 oder höher)

**Verbesserungen**

1. Große Bilder von Shop-Gegenständen ansehen unterstützt
2. Stromverbrauch durch Schrittzählung optimiert
3. Anzeigeprobleme bei zu großer Schrift — behoben
4. Abbruch unbegrenzter Aufgaben optimiert
5. Pomodoro-Benachrichtigungen optimiert und Fortschrittsbalken hinzugefügt
6. Nach Ereignisabschluss wird die aktuell angezeigte Benachrichtigungserinnerung entfernt
7. Einnahmen- und Ausgabenstatistik der Münzen optimiert
8. Einige Nutzerhinweise und Tipps hinzugefügt
9. Beim Bearbeiten von Aufgaben Auswahl der Produkt-Belohnung löschen unterstützt
10. Bei fortlaufenden Abstürzen Hinweis „Bekannte Probleme“ hinzugefügt
11. Anzeige bei nicht ausgewähltem Attribut optimiert

【Korrekturen】

1. Nach Sortieren der Liste auf der Startseite soll Status sofort aktualisiert werden
2. Detailseite aktualisierte Unteraufgabenliste nicht sofort — behoben
3. Absturz bei Weibo-Autorisierung zwangsweise behoben
4. Aufgabenname in Pomodoro-Benachrichtigung konnte falsch sein — behoben
5. Countdown in Pomodoro-Benachrichtigung war ungenau — behoben
6. Belohnungsbox erschien nicht, wenn Aufgabe und Erfolg nur Waren-Belohnungen hatten — behoben
7. Kauf von 0-Münzen-Gegenständen war unter Umständen nicht möglich — behoben
8. Reparaturberechnung für Ebbinghaus-Gegenstände optimiert
9. Berechnung der heutigen Abschlussanzahl für unbegrenzte Ereignisse optimiert

**1.82.7 (2021/04/10)**

1. UI-Anzeige bei leeren Daten auf dem Bildschirm [Moments] — behoben
2. Schriftgröße folgt wieder Systemeinstellungen
3. Englische und portugiesische Übersetzung aktualisiert

**1.82.5 (2021/04/02)**

1. Einige Probleme beim Pomodoro-Eintrag — behoben
2. Neue Anleitungen hinzugefügt

**1.82.4-alpha01/beta (2021/03/25)**

1. Belohnungen aus Lootboxen — behoben
2. Gefühle ausgewählter Aufgaben ansehen
3. Erfahrungspunkte/zufällige Münz-Belohnungen für benutzerdefinierte Erfolge
4. Aufgaben in der Smart-Liste werden nun nach Liste gruppiert
5. Jährliche Wiederholung
6. Weitere Verbesserungen und Fehlerbehebungen

**1.82.1 (2021/03/12)**

1. Einige Probleme bei Smart-Listen — behoben
2. Fortschrittsbalken änderte sich nach Aufgabenabschluss ggf. nicht — behoben
3. Problem beim Erzwingen des Abschlusses einer Zähl-Aufgabe — behoben
4. „NULL“ im unteren Überfälligkeits-Dialog — behoben

**1.82.0 (2021/03/11)**

1. Smart-Listen
2. Attribute-Icons neu gestaltet
3. Neuer Gegenstands-Effekt „Countdown“
4. Pomodoro-Timer zeichnet nach Ablauf weiter auf; Fokuszeit aktualisieren und Extra-Belohnung wählen möglich
5. Zähl-Aufgaben können ohne Zielwert erzwungen abgeschlossen werden
6. Nicht gestartete Aufgaben abschließen und Zeit verschieben wählbar
7. Weitere Fehlerbehebungen und Verbesserungen

**1.81.6**

1. Probleme beim Pomodoro-Erinnerungshinweis — behoben

**1.81.5 (2021/03/02)**

1. Italienische Übersetzung (teilweise)
2. Benachrichtigungs-Icon — behoben
3. Erinnerung funktionierte bei Wochentags-Wiederholung nicht zuverlässig — behoben
4. Auswahl „Foto aufnehmen“ funktionierte nicht — behoben
5. Weitere kleinere Korrekturen

**1.81.0~1.81.4**

1. Teilweise UI und Animationen neu gestaltet
2. Aufgabe wird automatisch abgeschlossen, wenn alle Unteraufgaben abgeschlossen sind
3. Fehler bei mehrfacher Erfahrungspunkte-Änderung — behoben
4. Fehler bei Dropbox-Wiederherstellung — behoben
5. Gegenstand kann ohne Münzen zurückgegeben werden
6. Einstellung für 12-Stunden-Anzeige
7. Mehrere Aufgaben einfrieren/auftauen

**1.80.7（2021/01/26)**

1. Statistik für Shop-Gegenstände hinzugefügt
2. Dialog zur Attribute-Beschreibung neu gestaltet
3. Benutzerdefinierte Attribute-Beschreibung
4. Kompaktmodus-Einstellung: alle Zusatzinfos ausblenden
5. Fehler bei Wiederherstellung aus Backup-Datei — behoben
6. Weitere Korrekturen und Verbesserungen...

**1.80.6（2021/01/22)**

1. Gegenstände mit Lootbox-Effekt können im Markt geteilt werden
2. Neue Suchseite: Nutzer nach Spitznamen suchen
3. Team-/Markt-Gegenstände nach Zeitraum filtern
4. Benachrichtigung zum schnellen Hinzufügen von Aufgaben
5. Mediendateien können bei Backup ignoriert werden.
6. Weitere Korrekturen und Verbesserungen...

**1.80.5（2021/01/14)**

1. 10/50 Lootboxen per Klick öffnen
2. Freischaltbedingung hinzugefügt [Ausgewählten Gegenstand bestimmte Anzahl aus Lootboxen erhalten]
3. ATM-Zinssatz-Einstellungen
4. Anzahl beim Verkaufen/Essen von Tomaten eingeben
5. Benutzerdefinierter End-Sound des Ruhe-Timers
6. Einige Nutzeranleitungen hinzugefügt
7. Einige Probleme behoben und Verbesserungen

**1.80.4（2021/01/04)**

1. Absturz auf Android 6 — behoben

**1.80.3（2021/01/04)**

1. Freier Bildzuschnitt
2. Icon von Gegenständen im Markt ansehen/hinzufügen
3. Beim Auswählen von Aufgabe/Gegenstand kann direkt ein neuer erstellt werden
4. COPY-Aktion für Nutzer-Erfolge unterstützt
5. Viele Korrekturen und Verbesserungen

**1.80.0（2020/12/24)**

1. Lootbox-Shop-Gegenstands-Effekt!
2. Dropbox-Backup integriert
3. Kompaktmodus-Konfigurationen
4. Verlaufsleiste für Fotoauswahl hinzugefügt
5. Viele Korrekturen und Verbesserungen

**1.79.x（2020/12)**

1. 3 weitere Freischaltbedingungs-Einstellungen
2. Benutzerdefinierte Soundeffekt-Einstellungen
3. Gegenstands-Belohnung für Erfolge setzen
4. Pomodoro-Timer-Eintragsseite
5. Aufgabe von der Kalenderseite erstellen
6. 5 neue Themenfarben.
7. Viele Verbesserungen und Korrekturen

**1.78.x（2020/11)**

1. Freischaltbedingung für benutzerdefinierte Erfolge
2. Benutzerdefinierte Erfahrungspunkte für Aufgaben
3. Viele Verbesserungen und Korrekturen

**1.77.1（2020/11/05)**

1. Listenwechsel-Symbolleiste
2. Schalter „Abgeschlossene Aufgaben anzeigen“
3. Listen können archiviert werden
4. Münz-Statuskarte hinzugefügt
5. Gefühle für Nutzer-Erfolge erstellen
6. Einstellung zum Folgen des System-Nachtmodus

**1.77.0（2020/10/28)**

1. Markt-Modul für Community; Shop-Gegenstands-Designs teilen oder Gegenstände importieren
2. Logik der Monats-Wiederholung — behoben
3. WebDAV-Auto-Backup wirkte nicht ohne mindestens ein Backup — behoben

**1.76.0（2020/10/13)**

1. Standard-Münzen für Unteraufgaben
2. In-App-Icons zum Erstellen von Shop-Gegenständen und Erfolgen
3. Benutzerdefinierter Tomatenpreis
4. Globale Einstellung zum Aktivieren von Soundeffekten
5. Gefühle können nach Aufgabeninhalt durchsucht werden

**1.75.2（Released at 2020/10/05）**

1. Standard-Münzanzahl für Unteraufgaben
2. Über 100 wählbare Icons als Shop-Gegenstands-/Erfolgs-Icons
3. Einstellung „Soundeffekt aktivieren“ hinzugefügt
4. Gefühle nach Aufgabeninhalt filtern und bessere Filter-UI
5. Pomodoro-Verknüpfungen erstellen
6. Benutzerdefinierte Tomaten-Verkaufspreise
7. Pomodoro-Seite hält Bildschirm während Countdown an
8. Einige Probleme — behoben

**1.75.1（Released at 2020/09/20）**

1. Viele Fehler in 1.75.0 — behoben

**1.75.0（Released at 2020/09/16）**

1. Pomodoro-Timer gamifiziert
2. Benutzerdefinierte Aufgaben-/Listen-Tag-Farbe
3. WebDAV-Auto-Backup
4. Module ausblenden-Einstellungen
5. Viele Verbesserungen und Korrekturen

**1.74.2（Released at 2020/08/23）**

1. Portugiesische Sprache

**1.74.0（Released at 2020/08/13）**

1. ATM: Münzen einzahlen und abheben
2. Shop-Gegenstände als Aufgaben-Belohnung wählbar
3. Lagerbestand-Einstellung für Shop-Gegenstände
4. Animation verbessert und einige Fehler behoben
5. Hinweis für Wiederholungsfrequenz-Einstellung hinzugefügt
6. Mehr... (Beschreibung folgt)

**1.73.0（Released at 2020/07/26）**

**Neue Funktionen:**

- Nutzer-Erfolge
- Animation bei Erfahrungspunkte-Abnahme
- Abschlusszeit des Verlaufseintrags bearbeiten
- Münz-Einstellung für Team-Unteraufgaben

**Verbesserungen:**

- Münz-Soundeffekt hinzugefügt

**Korrekturen:**

- Verlust der Unteraufgaben-Münz-Einstellung nach Aufgaben-Wiederholung

**1.72.1（Released at 2020/06/14）**

**Neue Funktionen:**

- Erfolgsdaten löschen

**Verbesserungen:**

- Bessere Anzeige der Shop-Gegenstands-Beschreibung

**Korrekturen:**

- Problem beim Bearbeiten von Shop-Gegenstands-Bildern
- Problem beim Bearbeiten von Gefühle-Text

**1.72.0（Released at 2020/06/11）**

**Neue Funktionen:**

- Unteraufgaben-Erinnerung
- Unteraufgaben-Münzen
- App-Widget
  1. Deckkraft-Einstellung
  2. Münzanzahl anzeigen
  3. Eingabe-Dialog für Zähl-Aufgabe anzeigen
- Zeitauswahl auf Statistikseite
- Inventar: Gegenstand zurückgeben
- Unteraufgaben-Unterstützung für Teams

**Verbesserungen:**

- Wischen bei Zähl-Aufgabe addiert 1 Abschluss statt als abgeschlossen zu markieren
- Button „Übersetzung helfen“ hinzugefügt
- Einstellung für mehrfache Erfahrungspunkte-Belohnung bei Zähl-Aufgaben

**Korrekturen:**

- Transparenter PNG-Teil nach Zuschnitt schwarz — behoben
- App-Widget auf manchen Geräten unzuverlässig — behoben
- Münzanzahl auf Detailseite bei Wert 0 sichtbar — behoben
- Wischen zum Abschließen (ohne Dialog) zeigte Seite falsch — behoben
- Unteraufgabe per ENTER auf manchen Geräten nicht erstellbar — behoben

**1.71.3/1.71.4（Released at 2020/04/16）**

**Kleinere Korrekturen zu Icon und Absturzbericht**

**1.71.2（Released at 2020/04/14）**

**Neue Funktionen:**

- Türkische Sprache (Dank an **İbrahim DOĞAN** für die Übersetzung)

- Aufgabenkarten-Hintergrund und Deckkraft anpassen
- Aktionstext-Button für Inventar-Gegenstand anpassen
- Gefühle-Favoriten
- Gefühle-Suche

**Verbesserungen:**

- Neues Icon

- Meldetyp unterstützt mehrere Sprachen
- UI der Einstellungsseite verbessert
- Wechsel von Themenfarbe und Sprache verbessert; App-Neustart nicht mehr nötig
- Seite zum Bildzuschnitt verbessert
- UI der Listenauswahl verbessert
- Shop-Gegenstands-Beschreibung in Shop-Gegenstandsliste anzeigen

**Korrekturen:**

- Freischalt-Datum des Erfolgs falsch angezeigt — behoben
- Shop-Gegenstandsbild leer nach Dateilöschung — behoben
- Status von Unteraufgaben nach Überfälligkeit der Einzelaufgabe nicht gelöscht — behoben
- Zu wenig Platz für Schwierigkeitsgrad auf Aufgaben-Detailseite — behoben
- Nach Abschluss überfälliger Aufgabe wurde Abschlussanzahl der nächsten nicht erhöht — behoben
- Max. Münzanzahl in Aufgaben-Standardeinstellungen falsch — behoben
- Daten-Backup/Wiederherstellungsseite scrollbar gemacht
- Wischen zum Abschließen bei schnellem Wischen mehrerer Aufgaben unzuverlässig — behoben
- App-Widgets zeigen Eingefroren-Status
- Fortschrittsbalken auf Aufgabenseite zeigte manchmal falschen Fortschritt — behoben

**Server-Korrektur（2020/4/13）**

- Meldefunktion wirkte nicht — behoben

**v1.71.1 (Released at 2020/03/17)**

**Verbesserungen:**

- Bessere Fortschrittsbalken-Animation auf Aufgabenseite

**Korrekturen:**

- Absturz beim App-Start auf manchen Geräten — behoben
- Fehler bei Fotoauswahl — behoben

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Neue Funktionen:**

- Gefühle-Funktion

- Wischaktion hinzugefügt: Aufgabe abschließen (ohne Dialog)

**Korrekturen:**

- Aufgabenkarten-Status falsch angezeigt — behoben

- Rückgängig gemachte Aufgabe konnte bei Überfälligkeit verschwinden — behoben

- Gewählte Sortierung nicht korrekt angezeigt — behoben

**v1.70.6 (Released at 2020/03/09)**

**Verbesserungen:**

- Farben des Erfolgs-Freischalt-Hinweises entsprechen Themenfarbe

**Korrekturen：**

- Überfälligkeits-Dialog-Status nach Button-Klick falsch — behoben

- COPY kopierte Unteraufgaben nicht — behoben
- Absturz bei „Verschieben nach …“ — behoben
- Auswahlkarte auf manchen Geräten falsch — behoben

**v1.70.5 (Released at 2020/03/06)**

**Korrekturen：**

- To-do-Karte lud dauerhaft bei Themenfarben-Wechsel oder Nachtmodus ein/aus

**v1.70.4 (Released at 2020/03/05)**

**Verbesserungen：**

- Shop-Seite zeigt Münzanzahl, wenn keine Gegenstände vorhanden
- Münz-Detailseite per Tippen auf Münzanzahl in Shop-Seite erreichbar
- Textformat des App-Widgets auf Englisch verbessert
- Aufgaben-Detailseite per Tippen auf Aufgabe im App-Widget erreichbar

**Korrekturen：**

- Team-Aktivität falsch dargestellt

**v1.70.3 (Released at 2020/03/05)**

**Verbesserungen:**

- Shop-Seite zeigt Münzanzahl, wenn keine Gegenstände vorhanden
- Münz-Detailseite per Tippen auf Münzanzahl in Shop-Seite
- Englisches Textformat im App-Widget verbessert
- Aufgaben-Detailseite per Tippen auf App-Widget-Eintrag

**Korrekturen：**

- Bei Filter „Heute“ fehlte Fußzeile „xx Aufgabe(n) noch nicht gestartet“ nach Abschluss — behoben

**v1.70.3 (Released at 2020/03/05)**

**Wichtige Korrekturen:**

- Fehler bei Münz-Eingabe — behoben
- Unteraufgaben aktualisierten sich nicht korrekt — behoben
- „Gefällt mir“ bei fremder Aktivität nicht möglich — behoben
- App-Widget konnte Aufgaben nicht abschließen — behoben

**v1.70.2 (Released at 2020/03/04)**

**Neue Funktionen：**

- Community ist in allen Zeitzonen verfügbar

- Aufgaben kopieren
- Standardeinstellungen neuer Aufgaben bearbeiten unterstützt
- Shop-Liste

- App-Widget-Aktionen verbessert
- Menü für beendete Aufgaben auf Kalenderseite

**Verbesserungen**：

- Animationen der Aufgabenkarte verbessert

- Unnötige Berechtigung entfernt
- Abschluss-Sound hinzugefügt
- UI-Stil der Verlaufsseite verbessert
- Dialog „Kalender-Lese/Schreibberechtigung verloren“ bei System-Kalendererinnerung ohne Berechtigung

**Korrekturen：**

- Fehler bei Zähl-Aufgabe im Kompaktmodus — behoben
- Fehler bei wiederholenden Aufgaben — behoben
- Absturz beim Löschen von Unteraufgaben — behoben
- Absturz bei falscher WebDAV-URL — behoben
- Falsche Themenfarbe nach Backup-Wiederherstellung — behoben

### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**🚀Funktionen**

1. Archivverwaltung unterstützt

- Backup auf den Computer
- Wiederherstellung vom Computer
- Drag-and-Drop unterstützt

2. Neue Gefühle erstellen unterstützt

- Bildauswahl unterstützt
- Bilder mit dem Mobilgerät synchronisieren

3. Aufgabendetails anzeigen unterstützt
4. Kaufsystem-Verbesserungen

- Neue „Purchase Items“-API nutzen
- Kauflimits konsistent mit der App halten

5. Optionale API-Token-Validierung unterstützt
6. Multiplattform-Unterstützung

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. Fehlerbehandlung und Benachrichtigungen verbessert

**v1.1.1 (2023/08/29)**

**🔧Optimierung und Fehlerbehebungen**

1. Unerwartetes Verhalten bei Münzeneingabe behoben
2. Absturz bei Update-Prüfung behoben

**v1.1.0 (2023/06/25)**

**🚀Funktionen**

1. Automatische Prüfung der „LifeUp Cloud“-IP-Adresse und Verbindung unterstützt (LifeUp Cloud v1.3.0 erforderlich)
2. Aufgaben hinzufügen unterstützt, derzeit begrenzte Optionen (Fixed [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. Gefühle als Markdown exportieren unterstützt (Fixed [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. Traditionelles Chinesisch hinzugefügt
5. macOS-Release-Version hinzugefügt
6. Update-Prüfung unterstützt

**🔧Optimierung und Fehlerbehebungen**

1. Erfolgs-Unterkategorien werden nicht korrekt angezeigt — behoben
2. Einige Symbole werden nicht korrekt angezeigt — behoben (LifeUp v1.91.3 erforderlich)
3. Titel-Inkonsistenz behoben (Fixed [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. Verknüpfungsoption für Windows-Installer hinzugefügt (Fixed [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. Fenstergrößen-Ermittlung verbessert; Anpassung an Auflösungen unter 1080p

**v1.0.2 (2023/02/20)**

1. Ausführlicherer Fehlerbericht-Dialog hinzugefügt [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. Paketkonfiguration verbessert

**v1.0.1 (2023/02/12)**

1. Erstveröffentlichung

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**🚀 Funktionen**

1. Abschlusszeit von Unteraufgaben (`endTime`) im SDK-Datenmodell und in HTTP-API-Antworten bereitgestellt.

**v2.1.0 (2026/03/22)**

**🚀 Funktionen**

1. Locale-Konfiguration und Top-14-Lokalisierungsupdates hinzugefügt.
2. Zählfortschritt und Wiederholungs-Endbedingungsfelder für API-Aufgaben bereitgestellt.

**🐛 Fehlerbehebungen**

1. ContentProvider-Kompatibilitätsprobleme behoben.
2. Android-15-UI und Service-Startverhalten angepasst.

**v2.0.0 (2025/01/01)**

**🚀Funktionen**

1. Service-Optimierung

- Service-Erkennungslogik und Kompatibilität verbessert
- Mehr Geräte unterstützen automatische IP-Erkennung
- Start-/Pausierungs-Übergänge des Dienstes optimiert
- Fehlerbehandlung und Benachrichtigungen verbessert

2. Sicherheit & Leistung

- Optionale API-Token-Validierung hinzugefügt
- CORS-Konfigurationsoptionen hinzugefügt
- Benutzerdefinierte Port-Einstellungen unterstützt
- Benutzerdefinierte Wake-Lock-Dauer unterstützt

3. UI-Verbesserungen

- Komplett neues Interface-Design
- Gesamte visuelle Erfahrung verbessert

**v1.3.0 (2023/06/25)**

**🚀Funktionen**

1. mDNS-Service-Registrierung unterstützt, damit der Desktop die IP automatisch erkennt (Desktop v1.1.0 erforderlich)
2. Ergebniswerte für über ContentProvider aufgerufene APIs hinzugefügt.

**🔧Verbesserungen**

1. Tippbereich der QR-Code-Scan-Schaltfläche vergrößert
2. ActivityNotFound-Absturz behoben

**v1.2.0 (2023/03/10)**

1. API-Aufruf per QR-Code-Scan unterstützt
2. Anzeige der IP-Liste verbessert

**v1.1.2 (2023/02/12)**

1. Abfrage vollständiger Daten über Content Provider unterstützt — für Desktop-Funktionen
2. HTTP-Antwortinhalte standardisiert

**v1.0.3-preview (2022/11/22)**

1. Erstveröffentlichung (plus einige Fehlerbehebungen der Erstveröffentlichung)

<!-- tabs:end -->

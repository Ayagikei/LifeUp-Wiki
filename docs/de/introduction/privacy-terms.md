# Datenschutz & Nutzungsbedingungen der App *LifeUp*

?> Die folgende Beschreibung des Anwendungsservers gilt nicht für die Lite-Version. Die Lite-Version hat keine Interaktion mit dem Anwendungsserver.

LifeUp ist eine App, die dir hilft, dein Leben zu verbessern. Wir respektieren deine Privatsphäre und schützen deine personenbezogenen Daten. Diese Datenschutzrichtlinie erklärt, wie wir personenbezogene Daten erfassen, nutzen, teilen und löschen, wenn du unsere App verwendest.

### 1. Personenbezogene Daten

LifeUp ist eine Offline-First-App. Wir erfassen aktiv keine Nutzerdaten, etwa Name oder E-Mail-Adresse. Du kannst optional Daten bereitstellen, um die Anmeldung für das Welt-Modul zu autorisieren, Google Drive oder Dropbox für Cloud-Backups zu autorisieren usw.

Wir nutzen Google Firebase und Sentry, um Problem- und Leistungsdaten ausschließlich zu Analysezwecken zu erfassen.

Kurzüberblick:

- **Nickname, Avatar, Geschlecht**
  Optional, für die Anmeldung zum Zugriff auf das „Welt“-Modul; werden an den Server übertragen und gespeichert, können aber geändert und gelöscht werden
- **E-Mail**
  Optional, für Google-Drive-Sync; lokale Speicherung, nicht an den Server übertragen
- **WebDAV-URL, Konto und Passwort**
  Optional, für WebDAV-Sync; lokal verschlüsselt gespeichert, nicht an den Server übertragen
- **Absturzinformationen, Leistungsdaten**
  An Dienstleister (Google Firebase, Sentry) zur Problem- und Leistungsanalyse; nie an Nutzer- oder Gerätekennungen gebunden und enthalten keine Nutzerdaten

Die detaillierte Datenerfassung und -verarbeitung pro Funktion folgt unten.

#### 1.1 Nutzerinformationen (Autorisierung durch Dritte)

##### Google-/Facebook-Anmeldung

**Erst nach deiner Bestätigung der Anmeldung** erstellen wir ein Konto mit dem von dir autorisierten Nickname und Profilbild (ohne E-Mail-Konten o. Ä.).

##### Google Drive

Da Google-Drive-Backups E-Mail-Adressen benötigen, fordert *LifeUp* beim Autorisieren von Google Drive die E-Mail-Berechtigung an. **Diese Adresse wird nur lokal genutzt; *LifeUp* übergibt sie nicht an den Anwendungsserver und speichert sie dort nicht.**

*LifeUp* beantragt nur app-spezifischen Speicher – wir haben keinen Zugriff auf deine privaten Dateien.

##### Dropbox

Nach der Dropbox-Autorisierung **bleiben die relevanten Informationen nur auf deinem Gerät für Backups und werden nicht an den Anwendungsserver weitergegeben.**

*LifeUp* beantragt nur **app-spezifischen Speicher – wir haben keinen Zugriff auf deine privaten Dateien.**

##### WebDAV-Server

**Deine WebDAV-URL, dein Konto und dein Passwort werden nur lokal gespeichert und nicht an den Anwendungsserver gesendet.** Das Passwort ist verschlüsselt in der Datenbank gespeichert.

##### Offline-Modus

***LifeUp* funktioniert auch vollständig offline; dann ist das „Welt“-Modul nicht erreichbar.**

Im Offline-Modus **musst du keine Informationen an unseren Anwendungsserver senden.**
**Nickname, Avatar und andere Informationen werden lokal gespeichert und sind verfügbar.**

Wir können den Anwendungsserver nur für die neuesten Ankündigungen und Updates anfragen – ohne Datenübermittlung.

Deine Interaktionen mit anderen SDKs wie Dropbox, Google Drive oder Facebook laufen bei aktiver Nutzung normal.

Bei Offline-Nutzung können wir weiterhin Google Firebase und Sentry für Absturz- und Problemberichte nutzen; **diese Informationen enthalten keine Nutzerdaten und sind nicht mit Nutzerinformationen verknüpft. Nur für Leistungsanalyse und Absturzbehebung und nur temporär gespeichert.**

Wir kommunizieren auch mit Google Play Services zur Lizenzprüfung auf Anfrage von Google Play.

Wenn du die gesamte Kommunikation verweigern möchtest, kannst du die Netzwerkberechtigung von LifeUp deaktivieren. Das beeinträchtigt LifeUp selbst nicht, kann aber SDKs wie Google Drive beeinträchtigen.


#### 1.2 Berechtigungen

#### Speicher

Die App **beantragt keine Leseberechtigung für den Speicher** und liest daher keine Dateien, die du nicht autorisiert hast.

Die App hat Kameraberechtigung für Bildanhänge, Avatar-Upload und ähnliche Funktionen beantragt und **ruft die Kamera erst nach deiner Erlaubnis auf.**

Beim Auswählen eines Bildanhangs nutzen wir direkt das Dateisystem-Framework des Systems.

Es wird *LifeUp* nur die von dir gewählte einzelne Datei autorisiert; wir haben keinen Zugriff auf andere Dateien.

Sofern du Dateien außerhalb des Welt-Moduls nicht aktiv teilst, werden sie nur lokal gespeichert und nicht über den Server geleitet.

#### Netzwerk

Die Netzwerkberechtigung dient dem „WELT“-Modul, autorisierter Anmeldung und optionaler Dropbox-/WebDAV-Synchronisation sowie weiteren Funktionen.

#### Kalender

Die App kann Ereignisse in die Systemkalender-App schreiben, um dich zu erinnern.

**Dafür sind Lese- und Schreibberechtigungen für den Kalender nötig. Diese Berechtigung wird erst angefordert, wenn du die entsprechende Funktion nutzt. *LifeUp* liest nur von der App selbst geschriebene Ereignisse.**

#### 1.3 Datenspeicherung

**Die App ist offline-first und hat keine eingebaute Online-Synchronisation; die meisten Daten liegen lokal auf dem Smartphone des Nutzers.**

Beispiele: alle lokal erstellten Aufgaben, alle erfassten Gefühle, selbst gestaltete Erfolge und Shop-Gegenstände.

**Nur Inhalte, die du im „Welt“-Modul aktiv öffentlich teilst, werden auf dem Server gespeichert.
Diese Inhalte unterstützen Löschung und Vernichtung.**

Beispiele: im „Welt“-Modul erstellte Teams, nach Teamaufgaben veröffentlichte Aktivitäten, aktiv geteilte Shop-Gegenstände usw.

Die meisten Anfragen in der App werden verschlüsselt übertragen.

#### 1.4 Leistungsdaten und Absturzberichte

Wir nutzen [Google Firebase](https://firebase.google.com/) und [Sentry](https://sentry.io/), um Leistungsdaten und Absturzberichte zu erfassen, um Probleme zu verfolgen und zu beheben.

Diese Leistungsdaten können Gerätemodell, Netzwerkstatus, Instanz-ID, Zeitpunkt des Problems und zugehörige Seiten umfassen, **sind aber nicht mit deinen Nutzerdaten verknüpft** (kein Nickname, keine Nutzer-ID, keine E-Mail oder Kontaktdaten; kein Inhalt, den du eingibst oder erstellst) und dienen nur der Problem- und Leistungsanalyse.

Diese Daten werden von Firebase und Sentry nur vorübergehend gespeichert; **wir geben sie nicht an Dritte weiter, verkaufen oder vermieten sie nicht.**

#### 1.5 Datenlöschungsanfrage für *LifeUp Lite*

##### 1. Datenspeicherung und -löschung

LifeUp Lite, die kostenlose Version von LifeUp, speichert Daten vor allem auf dem Gerät des Nutzers. Wir schätzen deine Privatsphäre und Autonomie. In LifeUp Lite werden keine Nutzerkonten erstellt; alle personenbezogenen Daten liegen lokal auf deinem Gerät.

**Zum Löschen deinstalliere einfach LifeUp Lite von deinem Gerät. Bei der Deinstallation werden alle lokal gespeicherten Daten dauerhaft entfernt.**

##### 2. Drittanbieter-Dienste

LifeUp Lite integriert Drittanbieter wie Firebase und Admob für Funktionalität und Werbung. Die erfassten Daten enthalten keine mit deiner Identität verknüpften personenbezogenen Informationen und werden gemäß deren Datenschutzrichtlinien genutzt. Sie werden nach einer Frist automatisch gemäß den Richtlinien dieser Dienste gelöscht.

##### 3. Hilfe bei der Datenlöschung

Bei Fragen oder wenn du Hilfe bei der Datenlöschung brauchst, kontaktiere uns unter lifeup@ulives.io. Unser Team unterstützt dich bei Fragen zum Datenschutz und führt dich bei Bedarf durch den Prozess.

##### 4. Compliance und Updates

Wir prüfen und aktualisieren unsere Praktiken laufend, um aktuelle Vorschriften und Branchenstandards einzuhalten. Dieser Abschnitt der Datenschutzrichtlinie wird bei Änderungen unserer Datenverwaltung und -löschung angepasst.


#### 1.6 Datenlöschungsanfrage für *LifeUp Pro*

##### 1. Datenlöschung in LifeUp Pro

LifeUp-Pro-Nutzer können ihre Daten unabhängig in der App löschen.

Da LifeUp Pro vor allem offline arbeitet, verwaltest du deine Daten direkt auf dem Gerät.

So löschst du deine Daten:

1. Öffne in LifeUp Pro „Einstellungen – Datensicherung/Wiederherstellung/Löschen“.
2. Wähle die zu löschenden Daten, z. B. Aufgaben, Gegenstandsbelohnungen, lokale Gedanken und Offline-Modus-Daten.
3. Bestätige, um die ausgewählten Daten dauerhaft zu löschen.

**Alternativ löscht die Deinstallation von LifeUp Pro auf deinem Gerät ebenfalls alle lokal gespeicherten Daten.**



##### 2. Kontolöschung in LifeUp Pro

Die Kontolöschung ist von der Datenlöschung getrennt.

Beim Löschen deines Kontos werden entfernt:

- Deine öffentlichen Beiträge, z. B. Teams und Updates, auf unseren Servern.
- Dein Nickname und andere mit dem Konto verknüpfte personenbezogene Daten.
- Mit dem Konto verknüpfte OAuth-Verbindungen.

**So löschst du dein LifeUp-Pro-Konto:**

1. Gehe zu „Einstellungen – Datensicherung/Wiederherstellung/Löschen“.
2. Tippe unten auf „Konto löschen“.
3. Bestätige, um dein Konto und alle zugehörigen Informationen dauerhaft zu löschen.

<br/>

**Wenn du LifeUp Pro nicht mehr nutzt, aber Konto und personenbezogene Daten löschen möchtest, kontaktiere uns unter [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Sende uns die nötigen Kontodetails; unser Team hilft beim Löschvorgang.

Wir behandeln deine Anfrage vertraulich und mit größter Sorgfalt.



##### 3. Drittanbieter-Dienste

Wie LifeUp Lite integriert LifeUp Pro Drittanbieter wie Firebase für erweiterte Funktionen. Die erfassten Daten sind nicht personenbezogen und werden gemäß deren Datenschutzrichtlinien verwaltet. Sie werden nach einer Frist automatisch gemäß den Richtlinien der Dienste gelöscht.



##### 4. Updates und Compliance

Wir überwachen und aktualisieren unsere Praktiken, um aktuelle Datenschutzgesetze und Branchenstandards einzuhalten. Dieser Abschnitt der Datenschutzrichtlinie wird bei Bedarf angepasst, um unsere Datenverwaltung und -löschung für LifeUp-Pro-Nutzer korrekt widerzuspiegeln.


### 2. Vereinbarung

Mit der Nutzung dieser Anwendung stimmst du den Bedingungen dieser Datenschutzrichtlinie zu.

Du bist für deine eigenen Daten verantwortlich.

Wir haften in keiner Weise für Datenverluste durch oder im Zusammenhang mit der Nutzung dieser App, da es sich um eine Offline-First-Anwendung handelt.

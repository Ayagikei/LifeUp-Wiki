# LifeUp im Hintergrund ausführen

## Warum das nötig ist

Manche Hersteller schränken Hintergrund-Apps stark ein, um Akku-Benchmarks zu verbessern. Funktionen, die auf Hintergrundausführung angewiesen sind, können deshalb ausfallen.

### Kompatibilitäts-Matrix

| Funktion | Hintergrund-Keep-Alive nötig? | Zusätzliche Berechtigungen | Hinweise |
| --- | --- | --- | --- |
| Aufgaben-Erinnerung (Systembenachrichtigung) | ✔️ | Benachrichtigungsberechtigung | Standard-Erinnerungsmethode. Bei Verzögerung oder Ausbleiben Hintergrund-Keep-Alive konfigurieren und Benachrichtigungen für LifeUp aktivieren. |
| Aufgaben-Erinnerung (Kalenderereignis) | ✖️ | Kalender Lese-/Schreibberechtigung | In `Einstellungen` → `Aufgaben` → `Erinnerungssystem ändern` umschaltbar. |
| Pomodoro-End-Erinnerung | ✔️ | - | Ohne Keep-Alive können Erinnerungen fehlen; Countdown pausiert oder friert im Hintergrund ein. |
| Count-up-Timer | ✖️ | - | - |
| App-Widget Auto-Aktualisierung | Meist ja (geräte-/OS-abhängig) | - | Ohne Keep-Alive bleiben Widgets bei „Laden“ oder zeigen veraltete Zustände wie „Alle Aufgaben erledigt“. |
| Widget-Aktion: Zähler-Aufgabe abschließen / Aufgabendetail öffnen (nicht MIUI) | ✖️ | - | - |
| Widget-Aktion: Zähler-Aufgabe abschließen / Aufgabendetail öffnen (MIUI) | Abhängig | Ggf. MIUI-spezifische Hintergrund-Popup-/Anzeigeberechtigung | MIUI kann widget-ausgelöste UI-Aktionen im Hintergrund blockieren. |

- Manche Systeme frieren Hintergrundaufgaben ein oder beenden sie, wenn der Bildschirm aus ist.
- Widgets verhalten sich je nach Launcher und OS-Variante unterschiedlich.
- Wenn dir nur Erinnerungen wichtig sind, kannst du auf Kalender-Erinnerungen wechseln und die Hintergrundabhängigkeit reduzieren.

## Einrichtung

> [!WARNING]
> Diese Einstellungen können den Akkuverbrauch leicht erhöhen.

In Tests auf einem OnePlus 8T verbrauchte 24 Stunden Hintergrundnutzung etwa **30 mAh**. Für die meisten Nutzer ist das gering.

LifeUp führt nur begrenzte passive Hintergrundoperationen aus, z. B. Erinnerungen, Widget-Updates und Pomodoro-Timing.

---

### Allgemeine Schritte

#### Allgemeine Einstellungen

> Du musst nicht jeden Schritt ausführen. Jeder Schritt kann Hintergrundpriorität und Stabilität verbessern.

**Android-Systemeinstellungen**

1. In LifeUp: `Seitenleiste` → `Einstellungen` → `Kompatibilitätsprobleme`, dann `Zu Akku-Optimierungseinstellungen springen`. LifeUp finden und auf **Nicht optimieren** setzen.

   a. Auf manchen Geräten erscheint LifeUp nach dem Sprung nicht. Dann diesen Schritt überspringen.

2. Für Erinnerungen Benachrichtigungsberechtigung für LifeUp gewähren.

3. (Optional) In den Aufgabeneinstellungen `Schnell-hinzufügen-Benachrichtigung` aktivieren.

<br/>

**Hersteller-Hintergrundmanager (Phone Manager)**

Viele Hersteller setzen zusätzliche Hintergrundbeschränkungen. Ohne Pixel/AOSP-ähnliches Gerät ist meist extra Konfiguration nötig.

1. LifeUp im System-Multitasking / Recent-Apps-Bildschirm sperren.

2. In App-Verwaltung / Akkuverwaltung / Phone Manager LifeUp Hintergrundausführung erlauben (keine Einschränkungen) und Autostart erlauben.

   a. Herstellerspezifische Anleitungen: [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Bei LifeUp-Nutzung aggressive Modi wie Super-Energiesparmodus oder strikte Nicht-stören-Richtlinien vermeiden oder LifeUp auf relevante Allowlists setzen.

<br/>

**Funktioniert es immer noch nicht?**

Nach Nutzerberichten und Tests läuft LifeUp auf gängigen Geräten nach korrekter Einrichtung normal. Systemupdates können Einstellungen verschieben oder umbenennen.

1. Alle Schritte oben erneut prüfen und fehlende Einstellungen ergänzen.

   a. Phone-Manager-Beschränkungen sind oft über mehrere Seiten verteilt und nicht als Standard-App-Berechtigungen gelistet.

   b. Optionale Schritte testen (z. B. dauerhafte Benachrichtigung) und erneut prüfen.

   c. In Systemeinstellungen nach Akku-Optimierung, Hintergrundbeschränkungen, Autostart und Popup-/Hintergrundanzeige suchen.

   d. Wenn dir nur Erinnerungen wichtig sind, `Kalender-Erinnerung`-Modus probieren.

2. In der Community andere Nutzer mit derselben Marke/Modell fragen und OS-Version angeben.

3. Hersteller-Support kontaktieren und fragen, wie eine bestimmte App im Hintergrund nicht beendet wird.

---

### App-Widgets funktionieren nicht

1. LifeUp zuerst öffnen und kurz im Vordergrund laufen lassen.
2. Widget neu hinzufügen (ggf. mehrmals versuchen).
3. Tritt der Fehler später wieder auf, diese Anleitung durchgehen und Keep-Alive erneut prüfen.
4. Bei Drittanbieter-Launcher zum System-Launcher wechseln und testen.
5. Bei Custom-Theme zum Standard-Systemtheme wechseln und testen.
6. Telefon neu starten.
7. Anderen Launcher testen, um launcher-spezifische Probleme auszuschließen.

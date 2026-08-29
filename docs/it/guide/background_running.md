# Mantenere LifeUp attiva in background

## Perché è necessario

Alcuni produttori di telefoni limitano in modo aggressivo le app in background per migliorare i risultati dei benchmark della batteria. Di conseguenza, le funzioni che dipendono dall'esecuzione in background possono fallire.

### Matrice di compatibilità

| Funzione | Richiede keep-alive in background? | Permessi aggiuntivi | Note |
| --- | --- | --- | --- |
| Promemoria Compito (notifica di sistema) | ✔️ | Permesso notifiche | È il metodo di promemoria predefinito. Se i promemoria sono in ritardo o mancanti, configura il keep-alive in background e assicurati che le notifiche siano abilitate per LifeUp. |
| Promemoria Compito (evento calendario) | ✖️ | Permesso lettura/scrittura calendario | Puoi passare a questa modalità in `Settings` → `Tasks` → `Change Reminder System`. |
| Promemoria fine Pomodoro | ✔️ | - | Se il keep-alive non è configurato, i promemoria possono essere persi e il countdown può mettersi in pausa o bloccarsi in background. |
| Timer count-up | ✖️ | - | - |
| Aggiornamento automatico widget App | Di solito sì (dipende da dispositivo/OS) | - | Senza un keep-alive adeguato, i widget possono restare su «Loading» o mostrare stati obsoleti come «All tasks completed». |
| Azione widget: completa Compito conteggio / apri dettaglio Compito (non-MIUI) | ✖️ | - | - |
| Azione widget: completa Compito conteggio / apri dettaglio Compito (MIUI) | Dipende | Può richiedere permesso popup/display in background specifico MIUI | MIUI può bloccare azioni UI attivate dal widget in background. |

- Alcuni sistemi congelano o terminano i Compiti in background quando lo schermo è spento.
- I widget possono comportarsi in modo diverso tra launcher e varianti OS.
- Se ti interessano solo i promemoria, puoi passare ai promemoria calendario per ridurre la dipendenza dal background.

## Come configurare

> [!WARNING]
> Queste impostazioni possono aumentare leggermente il consumo della batteria.

In base ai nostri test su OnePlus 8T, l'uso in background per 24 ore ha consumato circa **30 mAh**. Per la maggior parte degli utenti, l'impatto è minimo.

LifeUp esegue solo operazioni passive limitate in background, come promemoria, aggiornamenti widget e timing Pomodoro.

---

### Passaggi comuni di configurazione

#### Impostazioni generali

> Non devi completare ogni passaggio. Ogni passaggio può migliorare priorità e stabilità in background.

**Impostazioni di sistema Android**

1. In LifeUp, apri `Sidebar` → `Settings` → `Compatibility Issues`, poi tocca `Jump to Battery Optimization Settings`. Trova LifeUp e impostala su **Do Not Optimize**.

   a. Su alcuni dispositivi, LifeUp potrebbe non comparire dopo il salto a questa pagina. In tal caso, salta questo passaggio.

2. Se ti servono i promemoria, assicurati che il permesso notifiche sia concesso a LifeUp.

3. (Opzionale) Nelle impostazioni Compiti, abilita `Quick Add notification`.

<br/>

**Gestore background del produttore (Phone Manager)**

Molti produttori aggiungono restrizioni extra in background. Se non usi un dispositivo tipo Pixel/AOSP, di solito serve una configurazione aggiuntiva.

1. Blocca LifeUp nella schermata multitasking/app recenti di sistema.

2. Nella gestione app di sistema / gestione batteria / phone manager, imposta LifeUp per consentire l'esecuzione in background (nessuna restrizione) e l'avvio automatico.

   a. Per guide specifiche del produttore, vedi [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Quando usi le funzioni di LifeUp, evita modalità aggressive come super risparmio energetico o policy do-not-disturb rigide, oppure aggiungi LifeUp alle liste consentite pertinenti.

<br/>

**Ancora non funziona?**

In base a segnalazioni degli utenti e ai nostri test, LifeUp funziona normalmente sui dispositivi mainstream dopo una configurazione corretta. Tuttavia, gli aggiornamenti di sistema possono spostare o rinominare le impostazioni.

1. Ricontrolla tutti i passaggi sopra e completa le impostazioni mancanti.

   a. Le restrizioni del phone manager sono spesso sparse su più pagine e non sono elencate come permessi app standard.

   b. Prova i passaggi opzionali (ad esempio, abilitare la notifica persistente) e testa di nuovo.

   c. Cerca nelle impostazioni di sistema ottimizzazione batteria, restrizioni background, avvio automatico e opzioni popup/display in background.

   d. Se ti interessano solo i promemoria, prova la modalità `Calendar Reminder`.

2. Chiedi ad altri utenti con lo stesso brand/modello di dispositivo nella community, includendo la versione OS.

3. Contatta l'assistenza del produttore del telefono e chiedi come impedire che un'app specifica venga terminata in background.

---

### Widget App non funzionanti

1. Apri prima LifeUp e tienila in primo piano per un momento.
2. Aggiungi di nuovo il widget (se necessario, prova più volte).
3. Se fallisce di nuovo in seguito, rivedi questa guida e ricontrolla le impostazioni di keep-alive.
4. Se usi un launcher di terze parti, passa al launcher di sistema e testa di nuovo.
5. Se usi un tema personalizzato, passa al tema di sistema predefinito e testa di nuovo.
6. Riavvia il telefono.
7. Prova un altro launcher per escludere problemi specifici del launcher.

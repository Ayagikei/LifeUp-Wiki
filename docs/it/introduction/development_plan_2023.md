# Piano di sviluppo 2022/10 - 2023/12

!> Questo è un piano di sviluppo scaduto, conservato solo per archivio e riferimento. L'ambiente continua a cambiare e i nostri piani si adatteranno di conseguenza. Questo piano indica in linea generale la direzione di sviluppo, ma non promettiamo di eseguirlo completamente e potremmo anche sviluppare oltre il piano.

<br/>

Lo sviluppo di LifeUp negli anni precedenti si è sempre concentrato sullo sviluppo di nuovi moduli funzionali o sull'aggiunta di nuove funzioni ai moduli esistenti.

Oggi riteniamo che i moduli funzionali di LifeUp abbiano sufficiente ampiezza autoconsistente ma siano insufficienti in profondità.

Pertanto, i seguenti obiettivi di sviluppo puntano alla profondità funzionale, migliorando continuamente i moduli esistenti disponibili, aumentando la praticità (integrazione calendario, widget, statistiche);

e ampliando continuamente le funzionalità API in modo che le API possano essere pienamente estese per varie funzioni esterne.
Inoltre, cercheremo di migliorare il nostro sistema dati ed esplorare l'uso di Flutter per sviluppare versioni cross-platform.

<br/>

- **2023/01/26**
  - Aggiunto l'elemento «LAN PC side» a «Multi-platform», aggiunta anche la spiegazione corrispondente in «APIs».
  - Regolata la versione stimata per «Calendar Integration», il progresso potrebbe essere ritardato.
  - Regolata la versione stimata per «Custom Required Experience», il progresso potrebbe essere anticipato.
- **2022/10/16**
  - **Aggiunta roadmap per Attributi, Obiettivi e capacità di base**

| Modulo | Sottofunzione | Versione stimata | Motivo del requisito | Priorità | Risultato |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Integrazione calendario | - Sincronizzazione bidirezionale Google Calendar<br/>- Sincronizzazione bidirezionale calendario di sistema | v1.91~1.93 | - Molti feedback dall'estero.<br/>- LifeUp è uno strumento to-do con funzioni sovrapposte ma incoerenti rispetto alle app di agenda (calendario). Sviluppare tutte le funzioni calendario in LifeUp sarebbe enorme. L'integrazione esterna potrebbe essere una soluzione migliore. | P0 | ~ |
| Widget | - Widget Attributi<br/>- Widget Oggetti<br/>- ecc... | v1.92~1.95 | - Usabilità.<br/>- Widget belli offrono anche un livello di gamification e motivazione. | P1 | ~ |
| Statistiche | - Statistiche di vari indicatori<br/>- Statistiche Pomodoro dettagliate<br/>- Generazione schede condivisibili | v1.92~1.95 | - Statistiche Pomodoro carenti.<br/>- Il modulo statistiche non è migliorato da molto tempo, design e dati obsoleti.<br/>- Schede condivisibili adatte alla condivisione esterna degli utenti, possono portare incentivi e attirare più utenti in parte (richiede UI design curato). | P1 | - Previsto sviluppo di alcune schede statistiche in v1.91 |
| API | - Sviluppo SDK<br/>- Supporto query elenco<br/>- Più API comuni | v1.91~1.95 | - Manca l'interfaccia dati elenco. Dopo il supporto query elenco, terze parti possono sviluppare UI personalizzate (come elenco Compiti), l'estensibilità può migliorare molto.<br/>- Sulla base delle interfacce sopra, sviluppare SDK corrispondenti e lato PC LAN.<br/>- LifeUp non può essere all-in-one, ma l'API permette a tutti di personalizzare ed espandere il proprio LifeUp e realizzare una community open source. | P1 | - Prevista prima versione query API in v1.91 |
| Attributi | - Punti Esperienza richiesti personalizzati | v1.91~1.92 | ~ | P2 | - Previsto completamento sviluppo in v1.91 |
| Obiettivi | - Obiettivi ripetibili | v1.94~1.97 | ~ | P2 | ~ |
| Capacità di base | - Modifica batch (Compiti, Obiettivi, ecc.)<br/>- Selezione multipla Oggetti, auto-confezionamento in scatole, ecc. | v1.94~1.97 | ~ | P1 | ~ |
| Sistema dati | - Backup separato di dati e immagini<br/>- Supporto export/import parziale dati<br/>- Supporto cambio multi-file integrato | ~ | - Upload WebDAV di file grandi fallisce facilmente, i servizi cloud gratuiti hanno limiti di traffico, backup completo con immagini troppo grande.<br/>- Export/import parziale può essere usato dagli utenti per condividere sistemi di Ricompense.<br/>- Multi-file integrati permettono agli utenti di passare direttamente tra sistemi per debug senza cancellare ripetutamente i dati. | P1 | ~ |
| Multi-platform | - Continuare a imparare e usare Flutter per sviluppare versione cross-platform | Lato PC LAN: v1.91-1.92<br/>Flutter: v2.0 | - Sviluppo prototipo versione iOS.<br/>- Più inclini a esplorare nuove implementazioni piuttosto che replicare uno-a-uno la versione Android.<br/>- Forse adatto a Windows/macOS e altre piattaforme, da verificare.<br/>- Sviluppare lato PC LAN basato su API (versione lettura dati telefono). | P1 | - Prevista prima versione lato PC in v1.91 |

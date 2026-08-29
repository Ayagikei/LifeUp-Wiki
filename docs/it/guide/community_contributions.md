## Contributi della community 🤝

Siamo molto grati alla nostra community per aver creato strumenti che estendono le capacità di LifeUp. Di seguito trovi i toolkit ufficiali e i progetti della community in evidenza.

## Toolkit ufficiali

| Progetto | Descrizione |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Bridge HTTP lato telefono; accesso LAN e **scansione QR** (`lifeup://`, URL web, altri scheme di app) |
| [@lifeup/mcp](guide/api_mcp.md) | Server MCP ufficiale + Skills per Cursor, Claude Desktop e altri agenti AI via LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Client desktop ufficiale basato su HTTP LifeUp Cloud |
| [Demo integrazione Wordle](example/wordle/index.html) | Mini-gioco di indovinare parole; chiama `lifeup://api/reward` in caso di vittoria |

**Setup Wordle:** Crea un Oggetto del Negozio → aggiungi un effetto link di tipo 9 che punta alla pagina Wordle → **Use** apre il gioco nel browser; la vittoria concede 10 monete, la sconfitta dà comunque una moneta di consolazione. Puoi anche codificare l'URL Wordle come codice QR e scansionarlo con LifeUp Cloud. Vedi [API · Web esterno (Wordle)](guide/api.md).

<br/>

## Progetti della community

| Progetto | Descrizione | Autore |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Primo server MCP della community (sostituito da `@lifeup/mcp` ufficiale). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Plugin Obsidian ↔ LifeUp: sync to-do, sync riflessioni, dashboard dati LifeUp in Obsidian. *Nota: repo solo in cinese.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Hai creato qualcosa di interessante?** Se hai sviluppato uno strumento, script o integrazione per LifeUp, faccelo sapere tramite GitHub Issues o email!

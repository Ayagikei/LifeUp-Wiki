## Contributions communautaires 🤝

Nous sommes profondément reconnaissants envers notre communauté pour les outils qui étendent les capacités de LifeUp. Voici les boîtes à outils officielles et les projets communautaires mis en avant.

## Boîtes à outils officielles

| Projet | Description |
| --- | --- |
| [LifeUp Cloud](guide/api_cloud.md) | Pont HTTP côté téléphone ; accès LAN et **scan QR** (`lifeup://`, URLs web, schémas d'autres apps) |
| [@lifeup/mcp](guide/api_mcp.md) | Serveur MCP officiel + Skills pour Cursor, Claude Desktop et autres agents IA via LAN |
| [LifeUp Desktop](guide/api_desktop.md) | Client bureau officiel basé sur HTTP LifeUp Cloud |
| [Démo d'intégration Wordle](example/wordle/index.html) | Mini-jeu de devinettes ; appelle `lifeup://api/reward` en cas de victoire |

**Configuration Wordle :** Créez un Objet Boutique → ajoutez un effet de lien type 9 pointant vers la page Wordle → **Utiliser** ouvre le jeu dans le navigateur ; victoire = 10 pièces, défaite = une pièce de consolation. Vous pouvez aussi encoder l'URL Wordle en QR code et la scanner avec LifeUp Cloud. Voir [API · Web externe (Wordle)](guide/api.md).

<br/>

## Projets communautaires

| Projet | Description | Auteur |
| :--- | :--- | :--- |
| [lifeup-mcp](https://github.com/derekprovance/lifeup-mcp) | Première version communautaire du serveur MCP (remplacée par `@lifeup/mcp` officiel). | [@derekprovance](https://github.com/derekprovance) |
| [lifeup_mod_coins](https://github.com/klienkross/lifeup_mod_coins) | Plugin Obsidian ↔ LifeUp : sync to-do, sync réflexions, tableau de bord des données LifeUp dans Obsidian. *Note : dépôt en chinois uniquement.* | [@klienkross](https://github.com/klienkross) |

> [!TIP]
> **Vous avez créé quelque chose d'intéressant ?** Si vous avez développé un outil, un script ou une intégration pour LifeUp, faites-le nous savoir via GitHub Issues ou par e-mail !

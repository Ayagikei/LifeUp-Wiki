<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

> [!NOTE]
> Nous déployons progressivement **LifeUp v1.106.0** et **LifeUp Cloud v3.0.0**. Les délais de validation varient selon la plateforme ; cette documentation peut être mise à jour avant que les apps soient largement disponibles, et la date de sortie réelle peut être postérieure à celle indiquée ici.

LifeUp Cloud est l'un des kits d'outils API principaux de LifeUp. Il transforme votre téléphone en **pont API** : contrôlez LifeUp depuis votre **ordinateur ou d'autres appareils**, créez des **intégrations personnalisées** (bureau, web, scripts d'automatisation) ou associez-le à des **agents IA**.

### Scénarios typiques

| Scénario | Pour qui | En une phrase | En savoir plus |
| --- | --- | --- | --- |
| **HTTP + à vous de construire** | Développeurs, utilisateurs d'automatisation | Appelez les API et interrogez les données depuis Python, des apps web ou des scripts via le LAN — aucune expérience Android requise | [Référence de l’API HTTP](/guide/api-reference), [Bureau](guide/api_desktop.md) |
| **Scan QR** | Fans du check-in dans le monde réel | Imprimez des codes QR pour terminer des Tâches, démarrer des minuteries, ouvrir des dialogues ou lancer des pages web / d'autres apps | [Scan de codes QR](#qr-code-scanning) |
| **Raccourcis démarrer / arrêter** | Automatisation, NFC, Tasker | `lifeupcloud://start` et `lifeupcloud://stop` ouvrent Cloud et démarrent ou arrêtent le serveur HTTP | [Démarrage et arrêt](#cloud-scheme) |
| **Agent IA + MCP** | Cursor, Claude, etc. | Un seul prompt pour créer des listes de Tâches, des Objets Boutique, des Succès et plus | [MCP & Skills](guide/api_mcp.md) |
> **Exemple de prompt IA :** Supprimez les Tâches et Objets Boutique d'exemple, puis créez une configuration complète de développeur de jeux indie : listes de Tâches, Attributs, Objets Boutique et Succès.

<br/>

## Téléchargement

- Si vous utilisez la version adhérent Chine continentale, vous trouverez l'entrée de téléchargement de LifeUp Cloud dans `Sidebar` → `Settings` → `Experiments`.
- [Google Play Store](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http)

<br/>


## Démarrer et arrêter le service Cloud :id=cloud-scheme

Vous pouvez démarrer ou arrêter le serveur HTTP sans appuyer sur **Start Service**, en utilisant ces schémas d'URL :

```txt
lifeupcloud://start
lifeupcloud://stop
```

Ouvrir l'une de ces URL lance LifeUp Cloud et applique l'action. Utilisez-les comme raccourci d'écran d'accueil, tag NFC, action Tasker/automatisation, ou :

```txt
adb shell am start -a android.intent.action.VIEW -d lifeupcloud://start
```

Les mêmes URL sont listées sur la carte d'état Cloud — appuyez pour copier.

> [!NOTE]
> `lifeupcloud://` contrôle le serveur HTTP Cloud lui-même. Ce n'est pas une API de jeu `lifeup://api/…`.

<br/>

## Scan de codes QR :id=qr-code-scanning

Le bouton **Scan** en haut de LifeUp Cloud lit l'URL encodée dans un code QR et l'ouvre immédiatement — sans saisie manuelle.

Le scan **n'est pas limité aux API LifeUp** : `lifeup://api/…`, les pages web `https://…` et les schémas d'URL d'autres apps (p. ex. `weixin://`) fonctionnent aussi — Android ouvre la cible correspondante.

### Mode d'emploi

1. Choisissez une URL dans LifeUp ou la [liste d'API](guide/api.md) du wiki (terminer une Tâche, démarrer un pomodoro, ouvrir des dialogues d'achat/utilisation ou ouvrir une page web externe).

2. Générez un code QR à partir de l'URL complète (imprimez-le et collez-le sur un bureau, un mur ou un appareil).

3. Ouvrez LifeUp Cloud, appuyez sur **Scan** (appuyez sur **?** à côté pour un court guide in-app) et pointez vers le code.

### Ce que vous pouvez faire

| Scénario | Exemple (illustratif) |
| --- | --- |
| Check-in Pomodoro | `lifeup://api/pomodoro?...` démarrer/arrêter la minuterie |
| Check-in Tâche | `lifeup://api/complete?name=...` terminer une Tâche |
| Interaction Boutique | `lifeup://api/goto?page=shop` ou dialogues d'achat/utilisation |
| Récompense / pénalité | `lifeup://api/reward?...` / `lifeup://api/penalty?...` |
| Mini-jeu web | `https://wiki.lifeupapp.fun/en/example/wordle/index.html` |
| Autres apps | `weixin://`, `intent://` ou le schéma de toute app installée |
| Flux personnalisés | Toute combinaison d'URL scannable |

### Interaction dans le monde réel

Les codes QR associent **des lieux ou actions physiques** à la gamification in-app :

- Autocollant **équipement de gym** → scanner pour terminer une Tâche de musculation

- Autocollant **bureau d'étude** → scanner pour démarrer un pomodoro de Concentration

- Autocollant **poste de travail** → scanner pour enregistrer un stand-up ou une revue de code

- Autocollant **tableau d'événements** → scanner pour réclamer une Récompense ou ouvrir un Succès

En bref : **transformez les URL Schemes en déclencheurs physiques scannables**, avec LifeUp Cloud comme exécuteur entre l'App et le monde réel.

<br/>

> [!NOTE]
> LifeUp Cloud est un pont HTTP uniquement en LAN. La façon d'atteindre votre téléphone — adresse IP, routeur, pare-feu, même sous-réseau, VPN ou isolation AP — dépend de votre réseau domestique. Si vous ne pouvez pas vous connecter, nous ne pouvons pas déboguer votre LAN personnel. Vérifiez votre propre réseau, utilisez des outils réseau standard ou demandez de l'aide à un agent IA.

## Se connecter à LifeUp Cloud :id=connect

1. Installez des versions compatibles de LifeUp et LifeUp Cloud. Ouvrez LifeUp Cloud et accordez l’autorisation de données/API LifeUp lorsqu’elle est demandée.
2. Démarrez le service HTTP. Depuis un appareil pouvant joindre le téléphone sur votre réseau, utilisez l’adresse et le port affichés par Cloud comme URL de base.
3. Si vous avez configuré un jeton Cloud, envoyez sa valeur brute dans l’en-tête `Authorization`. Interrogez `/info` pour vérifier la connexion et les versions installées ; contrôlez le statut HTTP et le `code` JSON.

## Référence de l’API HTTP :id=http-api-definition

La [référence complète des interfaces et paramètres](/guide/api-reference) contient un index des routes, les règles communes de réponse/pagination, les modèles complets, les paramètres de requête et les exemples JSON. Consultez-la pour créer une intégration. Les [méthodes de schémas d’URL](/guide/api) décrivent les actions individuelles ; [MCP & Skills](/guide/api_mcp) décrit les outils d’agents IA.

### Horodatages des tâches et de l’historique :id=task-history-timestamps

Voir le [modèle temporel des tâches](/guide/api-reference?id=task-times) : `startTime` est le début prévu, `deadline` l’échéance et `endTime` de l’historique l’heure enregistrée d’achèvement/retard/abandon, à interpréter avec `status`.

#### Rapports quotidiens et exhaustivité de l’historique :id=history-daily-reports

Voir [pagination de l’historique et rapports quotidiens](/guide/api-reference?id=daily-report), ainsi que les [journaux EXP/pièces](/guide/api-reference?id=reward-journals) pour les variations réelles de récompenses.

## Contribution

Le SDK, LifeUp Cloud et LifeUp Desktop sont des projets open source.

Vous pouvez obtenir le code source ici :

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

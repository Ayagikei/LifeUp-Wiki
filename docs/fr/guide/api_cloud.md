<h1 align="center" padding="100">LifeUp Cloud ☁️</h1>

<p align="center">
 <img src="guide/_media/api/cloud.png" />
</p>

LifeUp Cloud est l'un des kits d'outils API principaux de LifeUp. Il transforme votre téléphone en **pont API** : contrôlez LifeUp depuis votre **ordinateur ou d'autres appareils**, créez des **intégrations personnalisées** (bureau, web, scripts d'automatisation) ou associez-le à des **agents IA**.

### Scénarios typiques

| Scénario | Pour qui | En une phrase | En savoir plus |
| --- | --- | --- | --- |
| **HTTP + à vous de construire** | Développeurs, utilisateurs d'automatisation | Appelez les API et interrogez les données depuis Python, des apps web ou des scripts via le LAN — aucune expérience Android requise | [API HTTP](#http-api-definition), [Bureau](guide/api_desktop.md) |
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

## Définition de l'API HTTP :id=http-api-definition

> [!WARNING]
> La documentation API de cette page peut être en retard sur les mises à jour d'implémentation. Utilisez le code source comme référence finale : [KtorService.kt](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt)

### 1. API d'invocation par URL Scheme

#### GET

Fonction :

> Invoque les API qui commencent par `lifeup://api`.

URL de requête :

```txt
// Recommandé : mode content provider (meilleure compatibilité)
http://{host:port}/api/contentprovider

// mode startActivity (certains appareils peuvent bloquer l'UI en arrière-plan)
http://{host:port}/api
```

**Méthode : `GET`**

**Paramètres de requête :**

| Champ | Description | Emplacement | Type | Obligatoire | Notes |
| --- | --- | --- | --- | --- | --- |
| url | URL d'API commençant par `lifeup://api` | Query | string | Oui | Encodez l'URL lors d'une construction manuelle. Plusieurs paramètres `url` sont pris en charge. |

**Exemples de requête :**

```txt
// Appel unique (content provider)
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL

// Appel par lot
http://{host:port}/api/contentprovider?url=YOUR_ENCODED_API_URL_1&url=YOUR_ENCODED_API_URL_2

// Appel unique (startActivity)
http://{host:port}/api?url=YOUR_ENCODED_API_URL
```

<br/>

#### POST

Fonction :

> Invoque les API qui commencent par `lifeup://api`.

URL de requête :

```txt
// Recommandé : mode content provider (meilleure compatibilité)
http://{host:port}/api/contentprovider

// mode startActivity (certains appareils peuvent bloquer l'UI en arrière-plan)
http://{host:port}/api
```

**Méthode : `POST`**

**Paramètres du corps JSON :**

| Champ | Description | Emplacement | Type | Obligatoire | Notes |
| --- | --- | --- | --- | --- | --- |
| urls | Tableau d'URLs commençant par `lifeup://api` | Body | List<string> | Oui | Pas d'encodage URL supplémentaire nécessaire dans le corps JSON. |

**Exemple de requête :**

```txt
// POST
http://{host:port}/api/contentprovider

// JSON body
{
  "urls": ["lifeup://api/goto?page=lab"]
}
```

<br/>

### 2. API de requête de données

> [!NOTE]
> Prérequis :
> 1. LifeUp v1.91+ et la dernière version de LifeUp Cloud.
> 2. Accordez l'autorisation **Read LifeUp Data** dans LifeUp Cloud.

Fonction :

> Interroge les jeux de données LifeUp complets, comme les Tâches et les Objets.

**Endpoints Tâches**

```txt
// Toutes les Tâches
http://{host:port}/tasks

// Tâches dans la catégorie/liste ${id}
http://{host:port}/tasks/${id}

// Historique (pagination prise en charge)
// gid est optionnel et peut filtrer tout l'historique d'une Tâche répétitive
http://{host:port}/history?offset=${offset}&limit=${limit}&gid=${gid}

// Catégories de Tâches
http://{host:port}/tasks_categories
```

**Endpoints Objets**

```txt
// Tous les Objets
http://{host:port}/items

// Objets dans la catégorie/liste ${id}
http://{host:port}/items/${id}

// Catégories d'Objets
http://{host:port}/items_categories

// Inclure les listes masquées
http://{host:port}/items_categories?include_hidden=true
```

**Endpoints Succès**

```txt
// Tous les Succès
http://{host:port}/achievements

// Succès dans la catégorie/liste ${id}
http://{host:port}/achievements/${id}

// Catégories de Succès
http://{host:port}/achievement_categories
```

**Endpoints Émotions**

```txt
// Toutes les Émotions (pagination prise en charge)
http://{host:port}/feelings?offset=${offset}&limit=${limit}
```

**Endpoints catégories de Synthèse**

```txt
// Toutes les catégories de Synthèse
http://{host:port}/synthesis_categories

// Catégories de Synthèse dans la liste ${id}
http://{host:port}/synthesis_categories/${id}
```

**Endpoints recettes de Synthèse**

```txt
// Toutes les recettes de Synthèse
http://{host:port}/synthesis

// Recettes de Synthèse dans la catégorie ${id}
http://{host:port}/synthesis/${id}
```

**Endpoints Attributs**

```txt
// Tous les Attributs
http://{host:port}/skills
```


**Autres**

```txt
// Solde de pièces
http://{host:port}/coin

// Versions LifeUp / Cloud
http://{host:port}/info

// Enregistrements Pomodoro (paginés ; plage horaire optionnelle)
http://{host:port}/pomodoro_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}

// Journaux (paginés ; plage horaire optionnelle). Lignes supprimées doucement omises.
http://{host:port}/coin_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/inventory_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/exp_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/step_records?offset=${offset}&limit=${limit}&time_range_start=${ms}&time_range_end=${ms}
http://{host:port}/level_defines
http://{host:port}/statistics?time_range_start=${ms}&time_range_end=${ms}
// Tous les Succès (implémenté ; id de catégorie optionnel)
http://{host:port}/achievements

// Événements broadcast. LifeUp Labs → Broadcast events est désactivé par défaut ; Cloud Advanced peut afficher l'état et l'activer. GET data.broadcasts est ce commutateur (omis si non lu). Le paramètre WebSocket Cloud est transport uniquement.
http://{host:port}/events?after=${id}&limit=50

// Push WebSocket (activé par défaut ; paramètre Cloud WebSocket event push)
ws://{host:port}/events?after=${id}
```

Enveloppe : `{ code, message, data }`. `200` indique uniquement OK transport. `10001` LifeUp non lancé ou Read Data non accordé. `10002` requête ContentProvider échouée.

### Valeurs des champs de listes

| Endpoint | Champ | Valeurs |
| --- | --- | --- |
| `/tasks` `/history` | `status` | `0` non terminée · `1` terminée · `2` en retard · `3` abandonnée |
| `/tasks` | `frequency` | `0` une fois · `1` quotidienne · `N>1` tous les N jours · `-1` illimitée · `-3` Ebbinghaus · `-4` mensuelle · `-5` annuelle |
| `/tasks` | `weekdays` | `1,3,5` (Lun=1 … Dim=7). Vide hors mode jours de semaine. v1.106.0+ |
| `/tasks_categories` | `status` | `0` normal · `1` archivée |
| `/tasks_categories` | `type` | `<10` normal · `10` quotidienne · `11` hebdomadaire · `12` mensuelle · `20` en cours |
| `/achievements` | `status` | `0` verrouillé · `1` débloqué, Récompense non réclamée · `2` débloqué, réclamée |
| `/achievements` | `type` | `0` normal · `1` sous-catégorie |
| `/achievement_categories` | `type` | `0` utilisateur · `1` système |
| `/feelings` | `type` | `0` Tâche · `1` Succès · `2` brut · `3` utilisation d'Objet |
| `/feelings` | `isFav` | bool (CP 0/1) |
| `/skills` | `type` | `0` utilisateur · `1` force · `2` apprentissage · `3` charme · `4` endurance · `5` vitalité · `6` créatif |
| `/items_categories` | `hidden` / `inventoryHidden` | `0` visible · `1` masqué (indicateurs indépendants) |
| `/synthesis_categories` | `hidden` | `0` visible · `1` masqué |
| `/pomodoro_records` | `reward` | `0` abandonné · `0.5×n` moitié · sinon multiple complet |
| `/coin_records` `/inventory_records` | `resCode` | Boutique : `0` acheter · `1` utiliser · `2` terminer Tâche · `3` annuler terminer · `4` effacer · `5` abandonner · `6` en retard · `7` débloquer Succès · `8` révoquer abandon · `9` révoquer retard · `10` retour · `11` terminer sous-tâche · `12` annuler sous-tâche · `13` débloquer Succès utilisateur · `14` annuler Succès utilisateur · `15` déposer · `16` retirer · `17` vendre tomates · `20` Récompense Objet · `21` annuler Récompense Objet · `23` Synthèse · `24` Boîte de butin · `25` intérêt DAB · `26` échange tomate · `27` intérêt crédit · `28` API · `29` action effet |
| `/exp_records` | `resCode` | Exp (pas Boutique `28`) : `0` inconnu · `1` terminer · `2` Succès · `3` échange like · `4` série quotidienne · `5` pas · `6` marquer terminée · `7` révoquer abandon · `8` révoquer retard · `9` manger tomate · `10` Objet utilisé · `11` débloquer Succès utilisateur · `12` terminer sous-tâche · `200` API · `101` annuler terminer · `102` abandonner · `103` en retard · `104` débit Objet utilisé · `105` verrouiller Succès utilisateur · `106` annuler sous-tâche |

`GET /items_categories`, `GET /synthesis_categories` et `GET /skill_groups` acceptent `include_hidden=true` (listes masquées omises par défaut). Conditions de déblocage des Succès : `GET /achievement_conditions/{id}`. `status` de Compétence (0 normal / 1 masqué) uniquement sur `query`/`query_skill`, **pas** sur `GET /skills`.

**Méthode : `GET`**

**Paramètres :**

| Champ | Description | Emplacement | Type | Obligatoire | Notes |
| --- | --- | --- | --- | --- | --- |
| id | ID de données | Path/Query | Number | Oui (pour les endpoints par ID) | - |
| offset | Décalage de requête | Query | Number | Non | Requis uniquement pour certains endpoints paginés |
| limit | Taille de page | Query | Number | Non | Requis uniquement pour certains endpoints paginés |
| gid | Filtrer l'historique d'une Tâche répétitive | Query | Number | Non | Optionnel pour la requête d'historique |
| include_hidden | Inclure les listes masquées | Query | Boolean | Non | Par défaut false. Utilisé par `/items_categories`, `/synthesis_categories`, `/skill_groups` |
| time_range_start | Début de plage (ms) | Query | Number | Non* | Doit être associé à `time_range_end`. Plage partielle/invalide renvoie `invalid_parameter` |
| time_range_end | Fin de plage (ms) | Query | Number | Non* | Doit être supérieur à `time_range_start` |

**Exemples de requête**

**Tâches**

```txt
// Toutes les Tâches
http://{host:port}/tasks

// Tâches dans la liste ID 1
http://{host:port}/tasks/1

// Historique (100 enregistrements à partir de l'index 0)
http://{host:port}/history?offset=0&limit=100

// Catégories de Tâches
http://{host:port}/tasks_categories
```

**Objets**

```txt
// Tous les Objets
http://{host:port}/items

// Interroger les IDs d'Objet spécifiques 1 et 4
http://{host:port}/items?id=1&id=4

// Objets dans la liste ID 1
http://{host:port}/items/1

// Catégories d'Objets
http://{host:port}/items_categories
```

**Succès**

```txt
// Succès dans la liste/catégorie ${id}
http://{host:port}/achievements/${id}

// Catégories de Succès
http://{host:port}/achievement_categories
```

**Émotions**

```txt
// 100 enregistrements à partir de l'index 0
http://{host:port}/feelings?offset=0&limit=100
```

**Attributs**

```txt
http://{host:port}/skills
```

**Catégories de Synthèse**

```txt
http://{host:port}/synthesis_categories
http://{host:port}/synthesis_categories/1
```

**Recettes de Synthèse**

```txt
http://{host:port}/synthesis
http://{host:port}/synthesis/1
```

<br/>

### 3. API image/fichier

> [!NOTE]
> En raison des restrictions de stockage Android, LifeUp Cloud peut devoir créer un fichier copié lors de la diffusion de contenu image depuis LifeUp.

Fonction :

> Charge les ressources image/fichier renvoyées par les API de données (typiquement `content://...`).

URL de requête :

```txt
http://{host:port}/files/${url}
```

**Méthode : `GET`**

**Paramètres de chemin :**

| Champ | Description | Emplacement | Type | Obligatoire | Notes |
| --- | --- | --- | --- | --- | --- |
| url | URL de fichier | Path | String | Oui | - |

**Exemple de requête :**

```txt
http://{host:port}/files/xxx
```

<br/>

### 4. Requêtes ContentProvider des Compétences

> [!NOTE]
> Nécessite v1.103.0+

Pour les requêtes de liste ou structurées, vous pouvez lire les URI ContentProvider suivantes via l'endpoint `http://{host:port}/api/contentprovider`.

#### `content://net.sarasarasa.lifeup.provider.api/skills`

Renvoie uniquement les Compétences visibles.

| Colonne | Signification | Type | Notes |
| ------ | ------- | ---- | ----- |
| _ID | ID de Compétence | number | - |
| name | Nom de Compétence | string | - |
| desc | Description | string | Peut être vide |
| icon | URI d'icône | string | Peut être vide |
| order | Ordre brut | number | `orderInCategory` |
| group_id | ID de groupe de Compétences | number / null | Peut être vide si la Compétence n'est pas dans un groupe |
| color | Couleur | number / null | Peut être vide |
| exp | Points d'Expérience | number | - |
| level | Niveau actuel | number | - |
| until_next_level_exp | EXP jusqu'au Niveau suivant | number | - |
| current_level_exp | EXP gagnée au Niveau actuel | number | - |
| type | Type de Compétence | number | - |
| status | État de Compétence | number | `0` = normal, `1` = masqué |

#### `content://net.sarasarasa.lifeup.provider.api/skill_groups`

Renvoie uniquement les groupes de Compétences visibles.

| Colonne | Signification | Type | Notes |
| ------ | ------- | ---- | ----- |
| _ID | ID de groupe de Compétences | number | - |
| content | Nom du groupe | string | - |
| order | Ordre brut | number | `orderInCategory` |
| collapsed | État replié | string | Renvoyé comme texte `true` / `false` |

<br/>

## Contribution

Le SDK, LifeUp Cloud et LifeUp Desktop sont des projets open source.

Vous pouvez obtenir le code source ici :

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

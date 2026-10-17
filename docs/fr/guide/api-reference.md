# Référence de l’API HTTP :id=http-query-reference

Cette référence décrit les paramètres de requête LifeUp Cloud et les modèles complets de réponse HTTP. Pour l’installation, l’autorisation et la connexion, commencez par [LifeUp Cloud](/guide/api_cloud). Les nouveaux points de terminaison des journaux nécessitent LifeUp **1.106.0+** et LifeUp Cloud **3.0.0+** ; utilisez `/info` pour identifier les versions installées. Elle décrit les contrats du code actuel, sans prouver leur disponibilité dans une version donnée.

## Index des interfaces :id=interface-index

| Ressource | Méthodes et chemins | Paramètres et modèle |
| --- | --- | --- |
| Règles communes | Réponses JSON, autorisation, conditions de cache, pagination | [Conventions](#representations), [cache et authentification](#auth-cache), [pagination](#pagination) |
| Tâches | `GET /tasks`, `GET /tasks/{categoryId}`, `GET /tasks_categories` | [Requêtes](#get-tasks), [modèle de tâche](#task-fields), [catégories](#get-tasks-categories) |
| Historique des tâches | `GET /history` | [Paramètres](#get-history), [horodatages](#task-times), [rapports quotidiens](#daily-report) |
| Objets | `GET /items`, `GET /items/{listId}`, `GET /items_categories` | [Identifiants d’objets, de catégories et modèles complets](#get-items) |
| Attributs | `GET /skills`, `GET /skill_groups` | [Attributs et groupes](#get-skills) |
| Succès | `GET /achievements`, `GET /achievements/{id}`, `GET /achievement_categories`, `GET /achievement_conditions/{id}` | [Succès et conditions](#get-achievements) |
| Synthèse | `GET /synthesis`, `GET /synthesis/{id}`, `GET /synthesis_categories`, `GET /synthesis_categories/{id}` | [Recettes et catégories](#get-synthesis) |
| Ressentis | `GET /feelings` | [Ressentis paginés](#get-feelings) |
| EXP / pièces | `GET /exp_records`, `GET /coin_records` | [Paramètres et modèles des journaux](#reward-journals) |
| Autres enregistrements | `GET /pomodoro_records`, `GET /inventory_records`, `GET /step_records` | [Pomodoro](#get-pomodoro-records), [inventaire](#get-inventory-records), [pas](#get-step-records) |
| Niveaux / statistiques | `GET /level_defines`, `GET /statistics` | [Niveaux](#get-level-defines), [statistiques](#get-statistics) |
| App / solde | `GET /info`, `GET /coin` | [Informations de version](#get-info), [résultat des pièces](#get-coin) |
| Appeler des actions | `GET` / `POST /api`, `GET` / `POST /api/contentprovider` | [Passerelle d’appel](#invoke-api) ; les méthodes fonctionnelles restent dans le [catalogue des schémas d’URL](/guide/api) |
| Fichiers / sauvegardes | `GET /files/{url}`, `POST /files/upload`, `GET /data/export`, `POST /data/import` | [Fichiers](#files-download), [transfert de sauvegardes](#files-backup) |
| Événements | `GET /events`, WebSocket `/events` | [Interrogation et événements en direct](#get-events) |
| Page d’accueil | `GET /` | Présentation HTML, pas une ressource JSON. |

MCP utilise une représentation client/outil distincte ; voir les [différences MCP](#mcp-differences) et le [guide MCP](/guide/api_mcp).

## Transport et représentation :id=representations

| Interface | Représentation | Différence importante |
| --- | --- | --- |
| Requêtes HTTP Cloud | JSON enveloppé dans `{code, message, data}` | Les références ci-dessous décrivent ce JSON public. |
| ContentProvider Android | Colonnes Cursor, comme `_ID` / `_GID`, contenant parfois du texte JSON | Le SDK les convertit en champs HTTP tels que `id` / `gid` et en tableaux imbriqués. N’utilisez pas les définitions des colonnes Cursor comme schéma HTTP. |
| Actions URL Scheme | `lifeup://api/{method}` et paramètres/résultats propres à la méthode | Les paramètres d’écriture peuvent utiliser snake_case même si les champs HTTP de lecture utilisent camelCase. |
| Outils de listes MCP | Enveloppe propre à l’outil et enregistrements compacts ou détaillés | La pagination et les champs de sortie MCP relèvent du comportement supplémentaire du client, pas des champs de réponse HTTP. |

## Réponse et erreurs :id=response-errors

L’enveloppe JSON HTTP commune est `HttpResponse<T>` :

| Champ | Type | Signification |
| --- | --- | --- |
| `code` | integer | `200` pour une requête réussie ; une valeur autre que `200` indique une erreur. Ce champ du corps est distinct du statut HTTP. |
| `message` | string | Généralement `success` en cas de réussite ; sinon, une description de l’erreur. |
| `data` | `T` ou `null` | Valeur propre au point de terminaison (tableau, objet ou chaîne) en cas de succès ; `null` en cas d’erreur. |

Exemple de liste vide obtenue avec succès :

```json
{"code":200,"message":"success","data":[]}
```

Exemple illustratif d’erreur d’autorisation/d’accès au fournisseur :

```json
{"code":10001,"message":"Cursor is null, check if LifeUp is installed and running and you have granted the permission","data":null}
```

| Signal | Traitement |
| --- | --- |
| HTTP `401` | Fournissez directement le jeton Cloud configuré comme valeur de l’en-tête `Authorization`. N’ajoutez pas `Bearer`. |
| Corps `code = 10001` | Vérifiez que LifeUp est installé/en cours d’exécution et que Cloud dispose de l’autorisation de lecture des données LifeUp. |
| Corps `code = 10002` | La requête ContentProvider a échoué ; consultez le message d’erreur. |
| Autre statut/code d’échec | Traitez la requête comme un échec, pas comme un résultat vide. |

Vérifiez **à la fois** le statut HTTP et le `code` du corps. Certains échecs de route utilisent toujours HTTP `200` avec un code d’erreur dans le corps. Les actions via `/api/contentprovider` nécessitent aussi de vérifier chaque `data[].result.api_result` ; le `code=200` de l’enveloppe ne prouve pas la réussite de toutes les actions.

## Autorisation et lectures conditionnelles :id=auth-cache

Si un jeton Cloud est configuré, envoyez sa valeur brute exacte dans `Authorization`, sans préfixe `Bearer`. Le serveur accepte aussi le paramètre de requête `token`, notamment pour les clients ne pouvant définir d’en-tête WebSocket. Un jeton absent ou incorrect produit HTTP `401` et `code=401` dans le corps. Ce contrôle couvre la page d’accueil, les ressources, la passerelle, les fichiers, les sauvegardes et les événements.

Les lectures réussies de ressources JSON incluent un `ETag` fort SHA-256 et `Cache-Control: private, no-cache`. Cela concerne tâches/historique, objets/catégories, attributs/groupes, succès/conditions, ressentis, synthèses/catégories, journaux, niveaux, statistiques, informations et pièces. Cela ne concerne pas la passerelle d’appel, les transferts de fichiers/sauvegardes ni les flux/interrogations d’événements.

| En-tête de requête | Comportement actuel |
| --- | --- |
| `If-Match` | Une version différente échoue avec HTTP `412` ; évalué avant `If-None-Match`. |
| `If-None-Match` | Une version correspondante renvoie HTTP `304`, sans corps JSON. Réutilisez la représentation réussie en cache. |

Les enveloppes d’erreur n’ont pas d’en-tête de version de ressource. Les lectures conditionnelles concernent chaque requête, sans instantané ni transaction entre pages ou routes.

Les requêtes navigateur entre origines peuvent utiliser `If-None-Match`. La configuration CORS actuelle n’autorise pas `If-Match` lors du contrôle préalable ; ne dépendez donc pas de telles requêtes entre origines sans modifier l’implémentation. Les clients natifs ne sont pas soumis au CORS du navigateur.

## Conventions communes des données :id=data-conventions

| Convention | Règle |
| --- | --- |
| Temps | Les horodatages utilisent les millisecondes Unix. Les limites d’un jour calendaire dépendent du fuseau horaire prévu. Chaque champ conserve son sens propre à la ressource. |
| Identité | L’`id` d’une tâche identifie une tâche/un cycle ; son `gid` identifie son groupe entre les cycles répétés. Un ID de catégorie/liste désigne une ressource distincte. |
| Valeurs vides | Absence, `null`, `0`, `""` et `[]` sont distincts. Chaque modèle documente ses valeurs de remplacement ou omissions réelles. |
| Identifiants numériques | Les identifiants peuvent être des entiers signés sur 64 bits ; Number de JavaScript ne représente pas exactement toutes les valeurs. Préservez les grands identifiants avec un parseur JSON adapté. |
| Tableaux et objets | Les valeurs HTTP imbriquées telles que `items` et `subTasks` sont des tableaux, pas des chaînes contenant du JSON encodé. |
| Codes de statut et de motif | Utilisez l’énumération documentée pour la ressource. Les statuts des tâches, des succès et les motifs des journaux sont des domaines différents. |

Consultez les [définitions des horodatages des tâches](/guide/api-reference?id=task-times) pour `startTime`, `deadline` et `endTime`.

## Pagination et filtrage :id=pagination

La pagination est une capacité de l’endpoint, pas une propriété de chaque liste. Les réponses HTTP brutes de listes contiennent `data: [...]` ; elles n’ajoutent **ni** `total`, `count` ni `hasMore`.

| Endpoint HTTP | Pagination | Plage de dates | Autres filtres |
| --- | --- | --- | --- |
| `/tasks`, `/tasks/{categoryId}` | Non ; tableau complet | Non | Catégorie facultative dans le chemin |
| `/history` | `offset` / `limit` côté serveur | Non | `gid` facultatif |
| `/feelings` | `offset` / `limit` côté serveur | Non | Voir la [ressentis](#get-feelings) |
| `/pomodoro_records`, `/coin_records`, `/inventory_records`, `/exp_records`, `/step_records` | `offset` / `limit` côté serveur | `time_range_start` / `time_range_end` | Voir l’endpoint concerné |
| `/statistics` | Non ; un objet | `time_range_start` / `time_range_end` | Requête agrégée |
| `/coin`, `/info` | Non ; un objet | Non | Requête d’objet unique |

Pour les endpoints paginés, les valeurs HTTP par défaut sont `offset=0` et `limit=100`. Utilisez des décalages positifs ou nuls et des tailles de page de `1..100` pour une boucle commune. Le pont HTTP n’applique pas la limite MCP de `1..100` ; les fournisseurs en aval peuvent imposer d’autres limites. Consultez la taille effective et les notes de validation de chaque endpoint.

Hormis la [limitation Pomodoro avec filtre temporel](#get-pomodoro-records), après chaque page réussie, augmentez `offset` du nombre d’enregistrements reçus. Arrêtez lorsque ce nombre est inférieur à la taille effective de page (le `limit` demandé avec `1..100`, hors Pomodoro filtré dans le temps). Ne confondez pas une page bornée par le fournisseur avec la dernière page. Une page vide après la fin est normale. Plusieurs pages ne constituent pas un instantané : les enregistrements peuvent changer pendant la requête.

Le SDK HTTP actuel transmet les limites de date uniquement si **les deux** sont interprétables comme entiers et si `start < end`. Une limite isolée, illisible ou inversée produit une requête sans filtre ; ne comptez pas sur une erreur pour la détecter. Validez les deux limites avant l’envoi. La référence des journaux précise le caractère inclusif des limites de ses endpoints.

## Différences avec MCP :id=mcp-differences

Les outils de listes MCP utilisent `limit=20` par défaut, le limitent à `1..100` et fixent `offset` à au moins `0`. Ils transmettent la pagination aux ressources paginées côté serveur comme l’historique/les journaux, mais récupèrent les tableaux HTTP complets puis les découpent localement pour les tâches. Leurs `items`, `count`, `hasMore` et `total` facultatif appartiennent à l’enveloppe MCP. `detail=false` supprime aussi des champs de chaque enregistrement ; utilisez `detail=true` si le modèle HTTP complet est nécessaire.

## Sources et portée des versions :id=api-common-sources

Ces références décrivent le SDK public actuel et le comportement correspondant du fournisseur LifeUp. Les exemples utilisent des données fictives. Les liens vers le code sont des références d’implémentation, sans prouver qu’une version installée donnée contient chaque champ : [routes HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt), [enveloppe HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/vo/HttpResponse.kt), [correspondance des requêtes MCP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/mcp/src/query.ts).

## Modèles de données des tâches et de l’historique :id=task-history-models

Cette page définit le **JSON HTTP** renvoyé par les [requêtes de tâches/d’historique](/guide/api-reference?id=task-queries). Les colonnes Cursor Android et les paramètres d’action URL Scheme peuvent avoir d’autres noms et représentations ; voir les [conventions communes](/guide/api-reference?id=representations).

Le SDK utilise une seule classe sérialisée `Task` pour deux vues. Ici, `Task` désigne la vue `/tasks` et `HistoryRecord` la vue `/history`. Ces noms décrivent la sortie existante ; ils n’introduisent pas une autre API. La sérialisation Cloud actuelle inclut les valeurs par défaut et les champs `null`.

### Champs Task / HistoryRecord :id=task-fields

Tous les champs ci-dessous apparaissent dans l’objet HTTP actuel. Les valeurs absentes du fournisseur sont souvent converties en valeurs de remplacement indiquées ; une telle valeur ne prouve pas sa présence dans les données sources.

| Champ | Type JSON | Signification / remplacement |
| --- | --- | --- |
| `id` | integer ou `null` | ID de cette tâche/de ce cycle. |
| `gid` | integer ou `null` | ID du groupe de tâches partagé entre les cycles répétés. |
| `name` | string | Nom de la tâche. Un nom absent du fournisseur devient `ERROR: name is null`. |
| `notes` | string | Notes ; chaîne vide si absentes. |
| `status` | integer | Statut de la tâche ; `0` si absent. Voir le tableau des statuts. |
| `startTime` | integer | Heure de début configurée en millisecondes ; remplacement SDK `0`. |
| `deadline` | integer | Échéance en millisecondes ; remplacement SDK `0` si absente. |
| `remindTime` | integer | Heure de rappel en millisecondes ; remplacement SDK `0` si absente. |
| `frequency` | integer | Code de récurrence ; `0` une fois, `1` quotidien, `-1` illimité. Autres modes dans les [actions de tâches](/guide/api). Remplacement SDK `0`. |
| `weekdays` | string | Jours sélectionnés, p. ex. `1,3,5` (lundi `1`, dimanche `7`) ; vide si non fourni et valeur vide fixe dans l’historique. |
| `exp` | integer | Récompense EXP configurée, pas un montant de transaction ; valeur par défaut `0`. |
| `skillIds` | integer array | Attributs associés à la récompense ; tableau vide si indisponibles. |
| `coin` | integer | Récompense en pièces configurée ; valeur par défaut `0`. |
| `coinVariable` | integer | Réglage de récompense en pièces aléatoires ; valeur par défaut `0`. |
| `itemId` | integer | Ancien ID du premier objet de récompense ; valeur par défaut `0`. Utilisez `items` pour la liste complète. |
| `itemAmount` | integer | Ancienne quantité du premier objet de récompense ; valeur par défaut `0`. Ce nom HTTP diffère de la colonne `itemCount` du fournisseur. |
| `words` | string | Texte d’encouragement à l’achèvement ; vide si absent. |
| `categoryId` | integer | ID de catégorie/liste de tâches ; valeur par défaut `0` si absent. |
| `order` | integer | Valeur d’ordre dans la liste ; valeur fixe `0` dans l’historique car son fournisseur ne renvoie pas la colonne. |
| `nameExtended` | string | Nom d’affichage étendu ; valeur vide fixe dans l’historique car son fournisseur ne renvoie pas la colonne. |
| `endTime` | integer | Heure de fin enregistrée dans l’historique. `/tasks` utilise `0` ; voir la [sémantique temporelle](/guide/api-reference?id=task-times). |
| `items` | `RewardItem[]` | Objets de récompense ; tableau vide si indisponibles. |
| `subTasks` | `SubTask[]` | Sous-tâches imbriquées ; tableau vide si indisponibles. |
| `countProgress` | `TaskCountProgress` ou `null` | Instantané de progression du compteur si disponible ; peut figurer dans les deux vues. |
| `repeatEndCondition` | `TaskRepeatEndCondition` ou `null` | Règle de fin de répétition dans `/tasks` ; toujours `null` dans `/history`. |

### Statut et horodatages des tâches :id=task-times

| `status` | Signification | Sens de `endTime` dans l’historique |
| --- | --- | --- |
| `0` | Inachevée | Pas une heure d’achèvement ; `/history` sélectionne des enregistrements terminés. |
| `1` | Terminée | Heure d’achèvement enregistrée. |
| `2` | En retard | Heure du retard enregistrée. |
| `3` | Abandonnée | Heure d’abandon enregistrée. |

| Champ temporel | Définition |
| --- | --- |
| `startTime` | Heure de début configurée/planifiée de la tâche, pas le début réel du travail de l’utilisateur. |
| `deadline` | Échéance planifiée, distincte de l’heure de fin enregistrée. |
| `endTime` | Heure enregistrée de fin de la tâche d’historique ; à interpréter avec `status` comme ci-dessus. |

Les trois utilisent les millisecondes Unix. Lors d’un achèvement normal, l’App enregistre l’heure actuelle. `history_operation` avec `operation=edit_completed_time` reçoit `completed_time` et modifie cette même heure d’achèvement sauvegardée ; la lecture de l’historique renvoie toujours le nom `endTime`.

Les heures sauvegardées sont modifiables. Si un enregistrement terminé n’a pas de date de fin sauvegardée, l’App utilise l’heure actuelle. `endTime` est donc l’heure actuellement enregistrée, pas un horodatage d’audit immuable. Le `0` de `/tasks` est une simple valeur de remplacement du SDK, pas un événement réel à l’origine de l’époque Unix.

### RewardItem :id=reward-item

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `itemId` | integer | ID de l’objet de récompense. |
| `itemCount` | integer | Quantité de récompense. |

```json
{"itemId":7,"itemCount":1}
```

### SubTask :id=subtask

| Champ | Type JSON | Signification / défaut |
| --- | --- | --- |
| `id` | integer | ID de sous-tâche. |
| `gid` | integer | ID du groupe de sous-tâches. |
| `todo` | string | Texte de sous-tâche. |
| `status` | integer | `0` inachevée, `1` terminée. |
| `remindTime` | integer ou `null` | Horodatage du rappel en millisecondes ; `null` si indisponible. |
| `endTime` | integer ou `null` | Horodatage d’achèvement de la sous-tâche en millisecondes ; `null` si indisponible. |
| `exp` | integer | Récompense EXP configurée. |
| `coin` | integer ou `null` | Récompense en pièces configurée. |
| `coinVariable` | integer ou `null` | Réglage de récompense en pièces aléatoires. |
| `items` | `RewardItem[]` | Objets de récompense ; tableau vide par défaut. |
| `order` | integer ou `null` | Valeur d’ordre ; défaut du modèle `0`. |
| `autoUseItem` | boolean ou `null` | Utilisation automatique des récompenses ; défaut du modèle `false`. |

```json
{
  "id":201,"gid":20,"todo":"Read ten pages","status":1,
  "remindTime":null,"endTime":1792072800000,"exp":2,
  "coin":0,"coinVariable":0,"items":[{"itemId":7,"itemCount":1}],
  "order":0,"autoUseItem":false
}
```

### TaskCountProgress :id=count-progress

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `currentCount` | integer | Compteur actuel de cette tâche/de ce cycle. |
| `targetCount` | integer | Compteur cible de cette tâche/de ce cycle. |

```json
{"currentCount":2,"targetCount":5}
```

### TaskRepeatEndCondition :id=repeat-end-condition

| Champ | Type JSON | Signification / défaut |
| --- | --- | --- |
| `mode` | string | `COUNT` ou `DATE`. Ce sont des chaînes en lecture, pas les paramètres numériques d’action. |
| `behavior` | string | `TERMINATE` ou `FREEZE`. |
| `targetCycleCount` | integer ou `null` | Nombre de cycles cible pour `COUNT` ; défaut `null`. |
| `endDateMillis` | integer ou `null` | Horodatage de date de fin en millisecondes pour `DATE` ; défaut `null`. |
| `inclusive` | boolean | Indicateur de date de fin inclusive ; défaut `false`. |

```json
{"mode":"COUNT","behavior":"TERMINATE","targetCycleCount":10,"endDateMillis":null,"inclusive":false}
```

### Montants des récompenses :id=reward-amounts

Ces champs de tâches et sous-tâches décrivent les récompenses configurées. Les multiplicateurs, pièces aléatoires et règles de règlement peuvent modifier l’attribution réelle. Utilisez les [journaux EXP et pièces](/guide/api-reference?id=reward-journals) pour les montants de transaction, en distinguant les récompenses positives des variations nettes incluant annulations ou pénalités.

### Références d’implémentation :id=api-task-model-sources

[Task](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/Task.kt) · [Analyseur](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt) · [SubTask](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/SubTask.kt) · [RewardItem](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/common/RewardItem.kt) · [Progression du compteur](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskCountProgress.kt) · [Règle de répétition](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TaskRepeatEndCondition.kt).

## Requêtes de tâches et d’historique :id=task-queries

Lisez les [conventions communes](/guide/api-reference?id=http-query-reference) et le [modèle complet Task/History](/guide/api-reference?id=task-history-models). Ces endpoints nécessitent l’autorisation Cloud de lecture des données LifeUp. Les requêtes de listes de base sont documentées pour LifeUp v1.91+ avec Cloud à jour ; les exemples décrivent les champs du SDK actuel. Vérifiez `/info` pour les anciennes installations.

### GET /tasks et /tasks/{categoryId} :id=get-tasks

Interrogez la liste actuelle des tâches **inachevées**, éventuellement limitée à une catégorie/liste. Le résultat est un tableau complet, sans pagination serveur. Les enregistrements terminés, en retard et abandonnés relèvent de `/history`.

| Paramètre | Emplacement | Type | Obligatoire | Défaut / comportement |
| --- | --- | --- | --- | --- |
| `categoryId` | Path | integer | Seulement pour `/tasks/{categoryId}` | Omettez tout le segment du chemin pour la liste sans restriction. |

Ces routes ne prennent en charge aucun paramètre de requête `offset`, `limit`, `gid` ni plage de dates. Un segment de catégorie non entier est actuellement interprété comme une catégorie absente ; validez-le avant la requête pour éviter d’interroger toutes les tâches par accident.

```text
GET http://{host:port}/tasks
GET http://{host:port}/tasks/1
```

**Réponse :** `HttpResponse<Task[]>`. Tous les champs et structures imbriquées sont définis dans les [champs Task/History](/guide/api-reference?id=task-fields). Cet enregistrement fictif montre la structure HTTP complète au premier niveau ; `endTime=0` est une valeur de remplacement pour cette route, pas un horodatage d’achèvement.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 101, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 0, "startTime": 1792108800000, "deadline": 1792195199999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "Read a chapter", "endTime": 0,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Comportement et erreurs :** la sélection et l’ordre suivent la logique des listes de tâches LifeUp ; cet endpoint ne garantit pas un tri par heure d’achèvement. Un `data: []` réussi signifie que la liste sélectionnée n’a renvoyé aucun enregistrement. Les échecs d’autorisation/fournisseur utilisent l’[enveloppe commune d’erreur](/guide/api-reference?id=response-errors), pas des tableaux vides. Pour les rapports d’achèvement, utilisez `/history` plutôt que le `endTime` de cette route.

### GET /history :id=get-history

Interrogez les enregistrements visibles de tâches terminées, y compris les tâches achevées, en retard et abandonnées. L’historique supprimé est exclu.

| Paramètre | Emplacement | Type | Obligatoire | Défaut / comportement |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | Non | `0` ; nombre d’enregistrements à ignorer, à partir de zéro. |
| `limit` | Query | integer | Non | `100` ; demandez une taille positive, de préférence `1..100`. |
| `gid` | Query | integer | Non | Aucun filtre de groupe ; si fourni, sélectionne ce groupe de tâches entre les cycles. |

L’analyseur HTTP utilise `0` / `100` si `offset` / `limit` sont illisibles et ignore un `gid` illisible. Cette route ne borne pas les nombres interprétés. Validez vous-même les décalages positifs ou nuls et les limites positives. `time_range_start` / `time_range_end` ne sont **pas pris en charge** ; les fournir ne filtre pas l’historique.

```text
GET http://{host:port}/history?offset=0&limit=100
GET http://{host:port}/history?offset=0&limit=100&gid=10
```

**Réponse :** `HttpResponse<HistoryRecord[]>`, avec les [champs HTTP Task/History](/guide/api-reference?id=task-fields). `HistoryRecord` est le nom documentaire de la vue historique du modèle `Task` du SDK. `repeatEndCondition` vaut `null` dans cette vue ; `countProgress` peut être présent. Le `endTime` sauvegardé s’interprète avec `status`.

```json
{
  "code": 200,
  "message": "success",
  "data": [{
    "id": 100, "gid": 10, "name": "Read a chapter", "notes": "",
    "status": 1, "startTime": 1792022400000, "deadline": 1792108799999,
    "remindTime": 0, "frequency": 1, "weekdays": "",
    "exp": 5, "skillIds": [2], "coin": 10, "coinVariable": 0,
    "itemId": 0, "itemAmount": 0, "words": "", "categoryId": 1,
    "order": 0, "nameExtended": "", "endTime": 1792072800000,
    "items": [], "subTasks": [], "countProgress": null,
    "repeatEndCondition": null
  }]
}
```

**Ordre :** date de fin sauvegardée décroissante, du plus récent au plus ancien. Aucun critère secondaire n’est documenté pour les dates égales. La pagination n’est pas un instantané ; évitez de modifier les données pendant la collecte du rapport et dédupliquez par `id` en combinant les pages.

**Pagination et résultats vides :** suivez la [procédure commune](/guide/api-reference?id=pagination). Un tableau vide réussi signifie qu’aucun enregistrement visible ne correspond à cette page/ce groupe, y compris lorsque `offset` dépasse la fin. Il ne certifie pas l’absence de toute activité passée : les données supprimées sont exclues et aucun indicateur d’exhaustivité n’existe. Si une requête échoue, signalez des données indisponibles/incomplètes plutôt que zéro tâche. Les [erreurs communes](/guide/api-reference?id=response-errors) s’appliquent.

### Construire un rapport quotidien :id=daily-report

1. Choisissez le fuseau horaire du rapport. Calculez le début du jour calendaire (`dayStart`) et du jour suivant (`nextDayStart`). Ne supposez pas que chaque jour local dure exactement 24 heures.
2. Lisez `/history` avec `offset=0&limit=100`, vérifiez chaque réponse et collectez toutes les pages. Conservez tout filtre `gid` prévu à l’identique.
3. Sélectionnez `status == 1` et `dayStart <= endTime < nextDayStart`. Tenez compte des [limites des heures enregistrées](/guide/api-reference?id=task-times) en présentant les résultats.
4. Pour les variations réelles d’EXP et de pièces, lisez les [journaux de récompenses](/guide/api-reference?id=reward-journals) du même jour. Leurs filtres incluent les deux bornes : utilisez `time_range_start=dayStart` et `time_range_end=nextDayStart-1`.
5. Distinguez « aucun enregistrement trouvé dans les données disponibles » d’une lecture échouée/inachevée. Choisissez entre récompenses positives seules et variations nettes incluant les annulations, puis appliquez ce choix de manière cohérente.

Les champs `exp` et `coin` des tâches/de l’historique sont des récompenses configurées ; ils ne remplacent pas de manière fiable les montants des journaux. Une heure d’achèvement déplacée vers un autre jour ne signifie pas que l’heure de transaction du journal de récompenses a suivi.

### Références d’implémentation :id=api-task-queries-sources

[Routes HTTP](https://github.com/Ayagikei/LifeUp-SDK/blob/main/http/src/main/java/net/lifeupapp/lifeup/http/service/KtorService.kt) · [Analyse des tâches et de l’historique](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/tasks/TasksApi.kt).

## Requêtes des journaux EXP et pièces :id=reward-journals

Ces endpoints HTTP en lecture seule nécessitent l’autorisation de lecture des données LifeUp, LifeUp **1.106.0+** et LifeUp Cloud **3.0.0+**. Ils renvoient les variations enregistrées, y compris diminutions et annulations, plutôt que la configuration des récompenses des tâches. Lisez d’abord les [conventions communes](/guide/api-reference?id=http-query-reference).

### Paramètres des deux endpoints :id=journal-parameters

Le contrat suivant s’applique spécifiquement aux **deux** endpoints `GET /exp_records` et `GET /coin_records`.

| Paramètre | Emplacement | Type | Obligatoire | Défaut / comportement réel |
| --- | --- | --- | --- | --- |
| `offset` | Query | integer | Non | Défaut HTTP `0` ; le fournisseur ramène les valeurs négatives à `0`. |
| `limit` | Query | integer | Non | Défaut HTTP `100` ; le fournisseur limite à `1..200`. Utilisez `1..100` pour la pagination commune. |
| `time_range_start` | Query | integer (millisecondes Unix) | Non, ou par paire | Borne inférieure inclusive de l’heure enregistrée de la transaction. |
| `time_range_end` | Query | integer (millisecondes Unix) | Non, ou par paire | Borne supérieure inclusive ; un filtre valide exige `start < end`. |

Les valeurs de pagination illisibles ou hors plage utilisent les défauts HTTP. Les dates illisibles sont considérées comme absentes. Le SDK actuel transmet une plage uniquement si les deux bornes existent et si `start < end` ; sinon, il interroge **sans filtre de date**. Les appels directs bruts au ContentProvider valident différemment les plages invalides. Validez les bornes dans l’appelant HTTP.

Les deux endpoints trient par heure de transaction enregistrée décroissante, du plus récent au plus ancien, et excluent les entrées supprimées. Ils ne garantissent ni critère secondaire par ID ni instantané sur plusieurs pages. Suivez la [pagination](/guide/api-reference?id=pagination) en tenant compte de la limite effective du fournisseur. Un tableau vide réussi signifie qu’aucune entrée ne correspond à la plage/page choisie ; un échec de lecture ne signifie pas zéro activité. Aucun endpoint ne fournit d’indicateur d’exhaustivité pour les données supprimées ou indisponibles.

### GET /exp_records :id=get-exp-records

Interrogez les variations d’EXP. Les paramètres sont exactement les [quatre paramètres de journaux ci-dessus](/guide/api-reference?id=journal-parameters) ; aucun filtre `gid` n’existe.

```text
GET http://{host:port}/exp_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Réponse :** `HttpResponse<ExpRecord[]>`. La sérialisation actuelle inclut tous les champs indiqués, y compris les valeurs nulles autorisées.

| Champ | Type JSON | Signification / remplacement de l’analyseur |
| --- | --- | --- |
| `id` | integer ou `null` | ID de l’entrée du journal. |
| `time` | integer ou `null` | Heure de transaction en millisecondes Unix, distincte de l’heure d’achèvement modifiable de la tâche. |
| `value` | integer | Variation d’EXP par attribut associé ; remplacement `0`. Utilisez `isDecrease` pour le sens. |
| `isDecrease` | boolean | `true` pour une diminution, `false` pour une augmentation ; l’analyseur interprète l’entier fournisseur `1` comme vrai. |
| `totalValue` | integer | Variation globale d’EXP enregistrée, **pas un solde d’EXP** ; remplacement `0`. Les lots multi-attributs peuvent se chevaucher dans ce total sauvegardé ; voir les [totaux des rapports](/guide/api-reference?id=journal-totals). |
| `resCode` | integer | Code de motif propre à l’EXP ; remplacement `0`. |
| `relatedId` | integer ou `null` | ID de l’objet source lié. Pour un achèvement normal de tâche, c’est l’`id` de la tâche, pas son `gid`. D’autres motifs peuvent désigner d’autres ressources. |
| `content` | string ou `null` | Description de la variation. |
| `skillIds` | integer array | IDs des attributs/compétences associés ; tableau vide en remplacement. |
| `relatedAttributes` | string array | Anciennes chaînes d’attributs associées ; tableau vide en remplacement. |

Exemple fictif : 10 EXP pour chacun de deux attributs, soit 20 EXP au total.

```json
{
  "code":200,"message":"success","data":[{
    "id":301,"time":1792072800000,"value":10,"isDecrease":false,
    "totalValue":20,"resCode":1,"relatedId":100,"content":"Task completed",
    "skillIds":[2,3],"relatedAttributes":[]
  }]
}
```

**Erreurs :** [erreurs HTTP/fournisseur communes](/guide/api-reference?id=response-errors). Des bornes HTTP invalides peuvent supprimer silencieusement le filtre comme indiqué ci-dessus, plutôt que produire une erreur.

### GET /coin_records :id=get-coin-records

Interrogez les variations de pièces. Les paramètres sont exactement les [quatre paramètres de journaux ci-dessus](/guide/api-reference?id=journal-parameters) ; aucun filtre `gid` n’existe.

```text
GET http://{host:port}/coin_records?offset=0&limit=100&time_range_start=1792022400000&time_range_end=1792108799999
```

**Réponse :** `HttpResponse<CoinRecord[]>`. La sérialisation actuelle inclut tous les champs indiqués, y compris les valeurs nulles autorisées.

| Champ | Type JSON | Signification / remplacement de l’analyseur |
| --- | --- | --- |
| `id` | integer ou `null` | ID de l’entrée du journal. |
| `time` | integer ou `null` | Heure de transaction en millisecondes Unix. |
| `value` | integer | Montant de variation des pièces ; remplacement `0`. Utilisez `isDecrease` pour le sens. |
| `isDecrease` | boolean | `true` pour une diminution, `false` pour une augmentation ; l’analyseur interprète l’entier fournisseur `1` comme vrai. |
| `totalValue` | integer | Solde de pièces après l’opération ; remplacement `0`. Contrairement au `totalValue` EXP, c’est un solde. |
| `resCode` | integer | Code de motif propre aux pièces ; remplacement `0`. |
| `relatedId` | integer ou `null` | ID de l’objet source lié ; un achèvement normal utilise l’`id` de la tâche. Interprétez les autres sources selon leur code de motif. |
| `content` | string ou `null` | Description de la variation. |
| `savingBalance` | integer ou `null` | Solde d’épargne enregistré pour l’opération. |

Exemple fictif : diminution de 5 pièces, laissant un solde de 95.

```json
{
  "code":200,"message":"success","data":[{
    "id":401,"time":1792072800000,"value":5,"isDecrease":true,
    "totalValue":95,"resCode":0,"relatedId":null,"content":"Example purchase",
    "savingBalance":0
  }]
}
```

**Erreurs :** [erreurs HTTP/fournisseur communes](/guide/api-reference?id=response-errors). Des bornes HTTP invalides peuvent supprimer silencieusement le filtre comme indiqué ci-dessus, plutôt que produire une erreur.

### Codes de motif et totaux des rapports :id=journal-totals

Les domaines de codes de motif diffèrent. Quelques exemples :

| Motif | EXP `resCode` | Pièces `resCode` |
| --- | --- | --- |
| Terminer une tâche | `1` | `2` |
| Annuler l’achèvement d’une tâche | `101` | `3` |
| Terminer une sous-tâche | `12` | `11` |
| Annuler l’achèvement d’une sous-tâche | `106` | `12` |
| Modification par API | `200` | `28` |

Codes EXP complets : `0` inconnu ; `1` tâche terminée ; `2` succès ; `3` échange de mentions J’aime ; `4` série de jours d’utilisation ; `5` échange de pas ; `6` marquer comme terminée ; `7` annulation d’abandon ; `8` annulation de retard ; `9` manger une tomate ; `10` utiliser un objet ; `11` déblocage de succès utilisateur ; `12` sous-tâche terminée ; `200` API ; `101` annulation d’achèvement ; `102` abandon ; `103` retard ; `104` utilisation d’objet diminuant l’EXP ; `105` reverrouillage de succès utilisateur ; `106` annulation d’achèvement de sous-tâche. Les codes de motif des pièces utilisent le même domaine que les [enregistrements d’inventaire](#get-inventory-records). Préservez les futurs codes inconnus. Pour une variation nette, appliquez le sens avec `isDecrease` (`true` soustrait le montant enregistré). Ne supposez pas qu’une diminution est encodée par un `value` négatif ; les types numériques sont signés et aucune garantie de valeur non signée/absolue n’est déclarée.

Le `value` EXP s’applique par attribut. Ne sommez pas aveuglément les `totalValue` EXP entre enregistrements : la logique actuelle de traitement par lots peut enregistrer des totaux qui se chevauchent au-delà de trois attributs. Par exemple, une variation de 10 EXP pour chacun de quatre attributs peut produire des totaux sauvegardés de 40 et 10, au lieu d’une somme fiable de 40. Pour un rapport précis, rapprochez le `value` par attribut des attributs indiqués dans chaque entrée ; les associations manquantes limitent les conclusions possibles. N’additionnez pas `value` et `totalValue` et ne décrivez pas le `totalValue` EXP comme un solde.

Pour un jour calendaire, calculez les valeurs locales `dayStart` et `nextDayStart`, puis demandez `[dayStart, nextDayStart - 1]` car les deux bornes sont inclusives. Sélectionnez les motifs pour un rapport limité aux récompenses de tâches ; ne les filtrez pas pour l’ensemble des variations enregistrées. [Procédure de rapport quotidien](/guide/api-reference?id=daily-report).

### Références d’implémentation :id=api-ledgers-sources

[CoinRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/CoinRecord.kt) · [ExpRecord](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/ExpRecord.kt) · [Transmission des paramètres de date](https://github.com/Ayagikei/LifeUp-SDK/blob/main/core/src/main/java/net/lifeupapp/lifeup/api/content/records/LedgerUri.kt).

## Objets et catégories :id=get-items

`GET /items` renvoie `ShopItem[]`. Le paramètre facultatif répété `id` sélectionne les objets : `/items?id=1&id=2`. Les valeurs non entières sont rejetées. Les identifiants inexistants sont ignorés ; les valides conservent l’ordre demandé, doublons compris. Si tous sont invalides, le SDK n’envoie aucun filtre et renvoie la liste normale. Sans pagination.

`GET /items/{listId}` renvoie `ShopItem[]` d’une **catégorie**, pas un objet unique. `listId` est un identifiant de catégorie entier signé sur 64 bits ; `-1` signifie toutes. Une valeur de chemin invalide sélectionne toutes les catégories. La liste normale exclut les objets retirés/supprimés (`isDel=0`) et suit le tri configuré de boutique/catégorie. La sélection par identifiant peut récupérer un objet indépendamment de ce filtre normal.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Coffee","desc":"A small reward","icon":"","categoryId":0,"stockNumber":-1,"ownNumber":2,"price":10,"order":0,"disablePurchase":false,"maxPurchaseNumber":5,"titleColorString":"","actionText":"Use","unlist":false,"disableUse":false,"purchaseLimit":"[]","limitScope":"purchase"}]}
```

### ShopItem :id=model-shop-item

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de l’objet. |
| `name` | string | Nom de l’objet. |
| `desc` | string | Description. |
| `icon` | string | URI d’image lisible ou chaîne vide. Télécharger via `/files/{url}`. |
| `categoryId` | integer | Identifiant de catégorie de boutique. |
| `stockNumber` | integer | Stock disponible ; un stock négatif est considéré comme illimité pour calculer `maxPurchaseNumber`. |
| `ownNumber` | integer | Quantité possédée dans l’inventaire. |
| `price` | integer | Prix en pièces. |
| `order` | integer | Ordre enregistré dans la catégorie. |
| `disablePurchase` | boolean | Indicateur d’achat désactivé. |
| `maxPurchaseNumber` | integer ou null | Calculé à partir des pièces disponibles, du crédit et du stock fini ; un achat désactivé donne 0, un stock gratuit illimité peut donner 2147483647. Ce calcul n’évalue pas toutes les règles de limitation d’achat. |
| `titleColorString` | string ou null | Couleur personnalisée du titre. |
| `actionText` | string ou null | Texte personnalisé du bouton d’utilisation. |
| `unlist` | boolean | Indicateur de retrait/suppression ; normalement false dans les listes. |
| `disableUse` | boolean | Si l’objet possède un effet empêchant son utilisation. |
| `purchaseLimit` | string ou null | **Chaîne encodée en JSON**, et non tableau imbriqué ; configuration des limites d’achat de l’objet. |
| `limitScope` | string ou null | `purchase`, `use` ou `both`. |

### GET /items_categories :id=get-items-categories

Renvoie `ShopCategory[]`. `include_hidden` est facultatif, par défaut `false` ; seules les chaînes exactes minuscules `true` et `false` sont reconnues, toute autre valeur donne false. Inclut la catégorie virtuelle « Toutes ». Le serveur HTTP n’expose pas `/items_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false,"inventoryHidden":false}]}
```

### ShopCategory :id=model-shop-category

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de catégorie. |
| `name` | string | Nom de la catégorie. |
| `isAsc` | boolean | Indicateur configuré de tri croissant. |
| `sort` | string | Préférence de tri enregistrée. |
| `order` | integer | Ordre de la catégorie. |
| `hidden` | boolean | Masquée dans la boutique. |
| `inventoryHidden` | boolean | Masquée dans l’inventaire. |

### GET /tasks_categories :id=get-tasks-categories

Renvoie `TaskCategory[]`, incluant la catégorie « Toutes » et les catégories archivées. Aucun paramètre ni pagination. Le serveur HTTP n’expose pas `/tasks_categories/{id}`. Les valeurs de tri/filtre sont des préférences enregistrées de l’App ; ce point de terminaison ne les applique pas comme filtres de requête.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Daily","isAsc":true,"sort":"order","filter":"","order":0,"status":0,"type":0}]}
```

### TaskCategory :id=model-task-category

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de catégorie. |
| `name` | string | Nom. |
| `isAsc` | boolean | Indicateur enregistré de tri croissant. |
| `sort` | string | Préférence de tri enregistrée. |
| `filter` | string | Préférence enregistrée de regroupement/filtre. |
| `order` | integer | Ordre de la catégorie. |
| `status` | integer | 0 normale ; 1 archivée. |
| `type` | integer | 0 normale ; listes intelligentes : 10 quotidienne, 11 hebdomadaire, 12 mensuelle, 20 en cours. |

## Attributs et groupes d’attributs :id=get-skills

`GET /skills` renvoie `Skill[]`, sans paramètres ni pagination. Les attributs masqués/supprimés sont exclus et l’ordre enregistré est utilisé. `group_id` et `status` du ContentProvider sous-jacent ne sont **pas** des champs du modèle HTTP.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Strength","desc":"","icon":"","order":0,"color":-65536,"exp":150,"level":2,"untilNextLevelExp":50,"currentLevelExp":50,"type":1}]}
```

### Skill :id=model-skill

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de l’attribut. |
| `name` | string | Nom localisé de l’attribut. |
| `desc` | string | Description. |
| `icon` | string | URI d’icône lisible ou vide. |
| `order` | integer | Ordre enregistré. |
| `color` | integer | Entier de couleur Android compacté. |
| `exp` | integer | EXP totale actuelle. |
| `level` | integer | Niveau actuel. |
| `untilNextLevelExp` | integer | EXP restante avant le prochain niveau. |
| `currentLevelExp` | integer | EXP gagnée depuis le début du niveau actuel. |
| `type` | integer | 0 utilisateur ; 1 force ; 2 apprentissage ; 3 charme ; 4 endurance ; 5 vitalité ; 6 créativité. |

### GET /skill_groups :id=get-skill-groups

Renvoie `SkillGroup[]`. `include_hidden` utilise la même analyse booléenne stricte que `/items_categories`, par défaut false. Le dépôt actuel de l’App ignore ce drapeau pour les groupes et exclut toujours les groupes supprimés. Ordre enregistré croissant. Sans pagination.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"Personal","order":0,"collapsed":false}]}
```

### SkillGroup :id=model-skill-group

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant du groupe. |
| `content` | string | Titre du groupe. |
| `order` | integer | Ordre enregistré du groupe. |
| `collapsed` | boolean | État replié. |

## Succès :id=get-achievements

`GET /achievements` renvoie `Achievement[]` en chargeant les catégories dans leur ordre et en concaténant leurs succès. `GET /achievements/{id}` renvoie les succès **de la catégorie `id`**, pas le détail d’un succès. Les identifiants de chemin invalides équivalent à la route sans filtre. Le tri interne suit la préférence de chaque catégorie dans l’App. Aucun de ces points de terminaison n’est paginé.

```json
{"code":200,"message":"success","data":[{"id":10,"name":"First step","desc":"Complete a task","iconUri":"","categoryId":1,"status":0,"exp":10,"coin":5,"coinVariable":0,"type":0,"progress":0,"order":0,"itemId":null,"itemAmount":null,"unlockedTime":null,"items":[],"color":""}]}
```

### Achievement :id=model-achievement

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant du succès. |
| `name` | string | Titre. |
| `desc` | string | Description. |
| `iconUri` | string | URI d’icône ou vide. |
| `categoryId` | integer | Identifiant de catégorie. |
| `status` | integer | 0 incomplet ; 1 terminé avec récompense non réclamée ; 2 récompense réclamée/autre état terminé. |
| `exp` | integer | Récompense d’EXP. |
| `coin` | integer | Récompense en pièces. |
| `coinVariable` | integer | Récompense variable en pièces. |
| `type` | integer | 0 succès ; 1 titre de sous-catégorie. |
| `progress` | integer | Progression enregistrée. |
| `order` | integer | Ordre dans la catégorie. |
| `itemId` | integer ou null | Identifiant du premier objet de récompense (ancien champ pratique). |
| `itemAmount` | integer ou null | Quantité du premier objet de récompense. |
| `unlockedTime` | integer ou null | Heure de déblocage en millisecondes Unix. |
| `items` | RewardItem[] ou null | Liste complète des objets de récompense ; le parseur actuel renvoie un tableau vide si leur JSON est absent ou mal formé. |
| `color` | string ou null | Couleur personnalisée du titre. |

Les objets de récompense utilisent le modèle partagé [RewardItem](#reward-item).

### GET /achievement_categories :id=get-achievement-categories

Renvoie `AchievementCategory[]`, sans paramètres ni pagination. Le serveur HTTP n’expose pas `/achievement_categories/{id}`.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Milestones","desc":"","iconUri":"","isAsc":true,"sort":"order","filter":"","order":0,"type":0}]}
```

### AchievementCategory :id=model-achievement-category

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de catégorie. |
| `name` | string | Nom. |
| `desc` | string | Description. |
| `iconUri` | string | URI/chaîne d’icône. |
| `isAsc` | boolean | Indicateur de tri croissant. |
| `sort` | string | Préférence de tri enregistrée. |
| `filter` | string | Préférence enregistrée de regroupement/filtre. |
| `order` | integer | Ordre de la catégorie. |
| `type` | integer | 0 succès utilisateur ; 1 succès système. |

### GET /achievement_conditions/{id} :id=get-achievement-conditions

Renvoie `AchievementCondition[]` pour l’identifiant de **succès** `id`. Un identifiant non entier produit une enveloppe d’erreur avec le code 500. Sans conditions correspondantes, un tableau vide est renvoyé. Il n’existe pas de route de collection `/achievement_conditions`.

```json
{"code":200,"message":"success","data":[{"id":1,"type":0,"relatedId":42,"target":10,"current":3,"progress":30}]}
```

### AchievementCondition :id=model-achievement-condition

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de condition. |
| `type` | integer | Code de condition ; voir ci-dessous. |
| `relatedId` | integer | Identifiant de tâche/objet/attribut associé selon la condition. |
| `target` | integer | Valeur cible. |
| `current` | integer | Valeur cumulée actuelle. |
| `progress` | integer | Progression enregistrée. |

Codes de condition : 0 tâches terminées ; 1 série actuelle d’une tâche ; 2 ancien niveau d’attribut ; 3 tomates ; 4 jours d’utilisation de l’App ; 5 mentions J’aime ; 6 jours consécutifs d’achèvement ; 7 pièces actuelles ; 8 pièces gagnées en un jour ; 9 tomates de tâche ; 10 achats d’objets ; 11 utilisations d’objets ; 12 gains d’objets de coffres ; 13 niveau d’attribut ; 14 niveau de vie ; 15 gains cumulés d’objets ; 16 gains d’objets par synthèse ; 17 quantité d’objets possédée ; 18 temps de concentration de tâche ; 19 épargne ATM ; 20 API externe. Conditions répétées : 500 tâches terminées ; 501 hausses de niveau d’attribut ; 502 tomates ; 503 pièces ; 504 gains d’objets ; 505 achats d’objets ; 506 gains de coffres ; 507 gains de synthèse ; 508 utilisations d’objets ; 509 minutes de concentration de tâche ; 510 tomates de tâche ; 511 mentions J’aime ; 512 hausses d’épargne ATM ; 513 appels d’API externes ; 514 jours d’utilisation ; 515 hausses de niveau de vie ; 516 pièces quotidiennes ; 517 tâches terminées consécutivement ; 518 tomates quotidiennes ; 519 minutes de concentration quotidiennes ; 520 groupes de tâches distincts quotidiens ; 521 utilisations d’objets quotidiennes ; 522 achats d’objets quotidiens ; 523 achèvements quotidiens d’une tâche donnée ; 524 total quotidien des enregistrements de tâches terminées. Ce sont des codes entiers bruts, pas des noms d’énumération sérialisés.

## Synthèse :id=get-synthesis

`GET /synthesis` renvoie `Synthesis[]` des catégories visibles. `GET /synthesis/{id}` renvoie les recettes **de la catégorie `id`**, contenu masqué inclus. Les identifiants positifs ou nuls sélectionnent une catégorie ; les négatifs, toutes les catégories visibles. Les invalides reviennent à la route de collection. Les résultats suivent l’ordre enregistré croissant des recettes ; les supprimées sont exclues. Sans pagination.

```json
{"code":200,"message":"success","data":[{"id":1,"name":"Tea","desc":"","input":[{"itemId":2,"itemName":"Tea leaf","amount":2,"ownedNumber":5,"icon":""}],"output":[{"itemId":3,"itemName":"Tea","amount":1,"ownedNumber":0,"icon":""}],"categoryId":0,"canSynthesisTimes":2}]}
```

### Synthesis :id=model-synthesis

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de recette. |
| `name` | string | Nom. |
| `desc` | string | Description. |
| `input` | SynthesisItemInfo[] | Objets requis. |
| `output` | SynthesisItemInfo[] | Objets produits. |
| `categoryId` | integer ou null | Identifiant de catégorie. |
| `canSynthesisTimes` | integer | Nombre de synthèses actuellement possibles. |

### SynthesisItemInfo :id=model-synthesis-item-info

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `itemId` | integer | Identifiant de l’objet. |
| `itemName` | string | Nom de l’objet. |
| `amount` | integer | Quantité d’entrée/sortie par synthèse. |
| `ownedNumber` | integer | Quantité possédée. |
| `icon` | string | URI d’icône lisible ou vide. |

### GET /synthesis_categories et /synthesis_categories/{id} :id=get-synthesis-categories

Les deux renvoient `SynthesisCategory[]`. Le chemin facultatif `id` filtre l’identifiant de catégorie sans modifier la forme du tableau. Les identifiants invalides sélectionnent toutes les catégories. `include_hidden` est facultatif, utilise des booléens minuscules stricts et vaut false par défaut, même avec un identifiant de catégorie. Sans pagination.

```json
{"code":200,"message":"success","data":[{"id":0,"name":"Default","isAsc":true,"sort":"order","order":0,"hidden":false}]}
```

### SynthesisCategory :id=model-synthesis-category

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de catégorie. |
| `name` | string | Nom. |
| `isAsc` | boolean | Indicateur enregistré de tri croissant. |
| `sort` | string | Préférence de tri enregistrée. |
| `order` | integer | Ordre de la catégorie. |
| `hidden` | boolean | Indicateur masqué. |

## Ressentis :id=get-feelings

`GET /feelings` renvoie `Feelings[]`. `offset` vaut 0 et `limit` 100 par défaut ; les valeurs absentes ou non entières utilisent ces valeurs. Aucun bornage explicite. Utilisez des décalages non négatifs et des limites positives. Les ressentis supprimés sont exclus. Le tri suit la préférence de l’App (`createTime` croissant ou décroissant), pas un paramètre. Aucun filtre temporel.

```json
{"code":200,"message":"success","data":[{"id":1,"content":"A good day","isFav":false,"title":"Read","time":1700000000000,"attachments":[],"type":0}]}
```

### Feelings :id=model-feelings

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant du ressenti. |
| `content` | string | Texte. |
| `isFav` | boolean | Indicateur favori. |
| `title` | string | Titre associé. |
| `time` | integer | Heure de création en millisecondes Unix. |
| `attachments` | string[] | URI de pièces jointes lisibles pour les fichiers existants non vides. |
| `type` | integer | 0 tâche ; 1 succès ; 2 entrée indépendante. |

## Enregistrements Pomodoro :id=get-pomodoro-records

`GET /pomodoro_records` renvoie `PomodoroRecord[]`. Valeurs par défaut : `offset` 0, `limit` 100 ; aucun bornage explicite. `time_range_start` et `time_range_end` sont facultatifs, en millisecondes Unix. Le SDK ne transmet la plage que si les deux sont des entiers sur 64 bits et le début précède la fin ; sinon, elle est ignorée silencieusement.

Sans plage, les enregistrements terminés non supprimés avec `startTime != endTime` et `endTime` positif sont renvoyés dans l’ordre `endTime DESC, startTime DESC, id DESC`. Une plage valide sélectionne `start < endTime <= end` et exclut les lignes supprimées.

> [!WARNING]
> Les implémentations précédentes transmettaient `limit` et `offset` au DAO dans l’ordre inverse pour les plages de dates, sans préciser le tri. Le code local de LifeUp utilise désormais des arguments nommés et trie les résultats paginés par `endTime DESC, startTime DESC, id DESC` ; cette correction locale n’a pas encore été publiée. Tant que vous n’avez pas confirmé sa présence dans votre version installée de LifeUp, omettez la plage et filtrez les lignes côté client pour une pagination fiable.

```json
{"code":200,"message":"success","data":[{"id":1,"startTime":1700000000000,"endTime":1700001500000,"duration":1500000,"reward":1.0}]}
```

### PomodoroRecord :id=model-pomodoro-record

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de l’enregistrement. |
| `startTime` | integer ou null | Début en millisecondes Unix. |
| `endTime` | integer ou null | Fin en millisecondes Unix. |
| `duration` | integer | Millisecondes : `lastTime` enregistré s’il est non nul, sinon fin moins début. |
| `reward` | number | Tomates gagnées : abandon = 0 ; moitié = 0,5 × multiplicateur ; sinon multiplicateur. |

## Enregistrements d’inventaire :id=get-inventory-records

`GET /inventory_records` renvoie `InventoryRecord[]`. `offset` vaut 0 par défaut et est borné à 0 minimum ; `limit` vaut 100 et est borné à 1–200. Les paramètres facultatifs `time_range_start` et `time_range_end` ne sont transmis que si ce sont des entiers sur 64 bits avec début < fin ; le SDK ignore silencieusement les plages invalides/incomplètes. Les plages valides utilisent les bornes inclusives `time >= start AND time <= end`. Les enregistrements supprimés sont exclus (`isDel` null ou 0) ; tri `time DESC, id DESC`. Aucun filtre par identifiant d’objet.

```json
{"code":200,"message":"success","data":[{"id":1,"time":1700000000000,"itemId":2,"itemName":"Tea","changeNumber":1,"isDecrease":false,"resCode":0,"desc":"Purchase"}]}
```

### InventoryRecord :id=model-inventory-record

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de l’enregistrement. |
| `time` | integer ou null | Heure de création en millisecondes Unix. |
| `itemId` | integer ou null | Identifiant de l’objet associé. |
| `itemName` | string ou null | Nom de l’objet associé, si disponible. |
| `changeNumber` | integer | Variation de quantité enregistrée. |
| `isDecrease` | boolean | Si la variation diminue l’inventaire. |
| `resCode` | integer | Code du motif d’origine ; voir ci-dessous. |
| `desc` | string ou null | Description de l’enregistrement. |

Codes de motif : 0 achat ; 1 utilisation ; 2 tâche terminée ; 3 annulation d’achèvement ; 4 effacement des données ; 5 abandon de tâche ; 6 tâche en retard ; 7 déblocage de succès intégré ; 8 annulation d’abandon ; 9 annulation de retard ; 10 retour d’objet ; 11 sous-tâche terminée ; 12 annulation de sous-tâche ; 13 déblocage de succès utilisateur ; 14 annulation de succès utilisateur ; 15 dépôt ; 16 retrait ; 17 vente de tomates ; 20 objet de récompense ; 21 annulation de récompense ; 23 synthèse ; 24 coffre ; 25 intérêts ATM ; 26 échange de tomates contre objet ; 27 intérêts de crédit ; 28 API ; 29 variation de stock par effet d’objet. Les clients doivent préserver les futurs codes inconnus.

## Enregistrements de pas :id=get-step-records

`GET /step_records` renvoie `StepRecord[]`. Les valeurs/bornes de pagination et les règles d’omission de plage du SDK correspondent à `/inventory_records`. Le filtre temporel valide est inclusif sur `date` ; tri `date DESC` sans clé secondaire explicite.

```json
{"code":200,"message":"success","data":[{"id":1,"date":1700000000000,"dailyStepCount":5000,"totalStepCount":120000,"isGotReward":true,"isUserInput":false,"rewardLevel":1}]}
```

### StepRecord :id=model-step-record

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de l’enregistrement. |
| `date` | integer ou null | Date enregistrée en millisecondes Unix. |
| `dailyStepCount` | integer | Nombre de pas quotidien. |
| `totalStepCount` | integer | Nombre de pas cumulé enregistré. |
| `isGotReward` | boolean | Indicateur de récompense réclamée. |
| `isUserInput` | boolean | Indicateur de saisie utilisateur. |
| `rewardLevel` | integer ou null | Niveau de récompense enregistré. |

## Définitions des niveaux :id=get-level-defines

`GET /level_defines` renvoie un objet `LevelDefines` unique. Aucun paramètre. Utilise les définitions personnalisées lorsque ce mode est activé, sinon les définitions intégrées.

```json
{"code":200,"message":"success","data":{"custom":true,"levels":[{"id":1,"levelStart":1,"levelEnd":10,"perLevelExp":100}]}}
```

### LevelDefines :id=model-level-defines

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `custom` | boolean | Mode de niveaux personnalisés. |
| `levels` | LevelDefine[] | Plages de niveaux. |

### LevelDefine :id=model-level-define

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer ou null | Identifiant de définition. |
| `levelStart` | integer | Niveau de départ. |
| `levelEnd` | integer | Niveau final. |
| `perLevelExp` | integer | EXP requise par niveau dans la plage. |

Un JSON de niveaux mal formé devient actuellement un tableau `levels` vide sans faire échouer toute la requête.

## Statistiques :id=get-statistics

`GET /statistics` renvoie un objet `Statistics`. Les paramètres facultatifs `time_range_start` et `time_range_end` utilisent les millisecondes Unix et la même règle SDK : les deux valides et début < fin, sinon aucune plage envoyée. Sans plage, l’App va de son premier horodatage enregistré à maintenant ; s’il n’existe pas, elle utilise les 30 derniers jours. `usingDays` et `companionDays` couvrent toute la durée d’utilisation même avec une plage. Les autres métriques sont calculées par leurs méthodes statistiques respectives ; ne supposez pas que toutes les requêtes sous-jacentes partagent les mêmes règles d’inclusion des bornes.

```json
{"code":200,"message":"success","data":{"start":1700000000000,"end":1700086400000,"tomatoes":4,"pomodoroMinutes":100,"focusCount":4,"tasksCompleted":3,"tasksTotal":4,"taskCompleteRate":0.75,"feelingsCount":1,"usingDays":30,"companionDays":32,"interestChanged":2,"coinPurchaseConsumed":10}}
```

### Statistics :id=model-statistics

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `start` | integer ou null | Début effectif de la plage en millisecondes Unix. |
| `end` | integer ou null | Fin effective de la plage en millisecondes Unix. |
| `tomatoes` | integer | Statistique des tomates gagnées. |
| `pomodoroMinutes` | integer | Durée de concentration en minutes. |
| `focusCount` | integer | Nombre de sessions de concentration. |
| `tasksCompleted` | integer | Nombre de tâches terminées utilisé pour la statistique d’achèvement. |
| `tasksTotal` | integer | Nombre total de tâches utilisé pour cette statistique. |
| `taskCompleteRate` | number | Taux d’achèvement. |
| `feelingsCount` | integer | Nombre de ressentis. |
| `usingDays` | integer | Jours d’utilisation depuis le début. |
| `companionDays` | integer | Jours de compagnie depuis le début. |
| `interestChanged` | integer | Statistique de variation des pièces liée aux intérêts. |
| `coinPurchaseConsumed` | integer | Statistique des pièces dépensées en achats. |

## Informations de l’App et solde de pièces :id=get-info

`GET /info` renvoie `Info`. LifeUp Cloud ajoute sa propre version installée aux informations de l’App/fournisseur. Aucun paramètre.

```json
{"code":200,"message":"success","data":{"appVersion":1,"appVersionName":"example","apiVersion":1,"cloudVersion":1,"cloudVersionName":"example"}}
```

### Info :id=model-info

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `appVersion` | integer | Code de version LifeUp installé. |
| `appVersionName` | string | Nom de version LifeUp installé. |
| `apiVersion` | integer | Version de l’API LifeUp. |
| `cloudVersion` | integer | Code de version LifeUp Cloud installé. |
| `cloudVersionName` | string | Nom de version LifeUp Cloud installé. |

### GET /coin :id=get-coin

Appelle `lifeup://api/query?key=coin` via le ContentProvider et renvoie son objet résultat. Aucun paramètre. Un résultat null devient un objet vide. Les champs sont définis par le fournisseur, pas par une réponse typée `CoinData`. Une requête réussie fournit `value` (solde de pièces entier signé sur 64 bits) et `api_result: true` ; les échecs peuvent fournir les champs d’état/erreur décrits ci-dessous.

```json
{"code":200,"message":"success","data":{"value":50,"api_result":true}}
```

## Appeler une API de schéma d’URL :id=invoke-api

Le [catalogue d’API de schémas d’URL](/guide/api) définit les noms de méthodes, paramètres et résultats propres à chaque méthode. La passerelle HTTP accepte l’URL complète `lifeup://api/...`.

| Transport | Entrée | Exécution et réponse |
| --- | --- | --- |
| `GET /api` | Paramètre répété `url` encodé en URL | Lance une activité Android par URL dans l’ordre fourni. Renvoie la chaîne `success`. L’absence d’URL réussit aussi. |
| `POST /api` | JSON `RawQueryVo` | Lance d’abord chaque entrée de `urls`, puis `url` si présent. Renvoie la chaîne `success`. Un objet d’entrée vide réussit aussi. |
| `GET /api/contentprovider` | Paramètre répété `url` encodé en URL | Appelle le fournisseur de façon synchrone et renvoie `CallUrlResult[]` dans l’ordre fourni. L’absence d’URL produit une enveloppe d’erreur (`No url found`). |
| `POST /api/contentprovider` | JSON `RawQueryVo` | Appelle d’abord chaque entrée de `urls`, puis `url` ; renvoie `CallUrlResult[]`. Un objet vide renvoie un tableau vide. |

Définissez `Content-Type: application/json` pour les POST JSON. Encodez l’URL entière dans une requête GET, en préservant les `&`, `?`, `+` et encodages pour cent internes. Une réponse réussie de la passerelle d’activité confirme l’envoi, pas l’achèvement de l’action LifeUp. Les méthodes ContentProvider nécessitent l’autorisation de Cloud dans LifeUp et leur prise en charge dépend de la méthode du schéma d’URL. Les appels sont séquentiels ; une exception ultérieure n’annule pas les effets précédents.

```json
{"urls":["lifeup://api/query?key=coin"],"url":"lifeup://api/query?key=atm"}
```

Réponse de la passerelle d’activité :

```json
{"code":200,"message":"success","data":"success"}
```

Réponse de la passerelle fournisseur (résultat illustratif) :

```json
{"code":200,"message":"success","data":[{"url":"lifeup://api/query?key=coin","result":{"value":50,"api_result":true}},{"url":"lifeup://api/query?key=atm","result":{"value":100,"api_result":true}}]}
```

### RawQueryVo :id=model-raw-query

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `url` | string ou null | URL unique facultative. |
| `urls` | string[] ou null | Liste d’URL facultative ; traitée avant `url`. |

### CallUrlResult :id=model-call-url-result

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `url` | string | URL soumise. |
| `result` | object ou null | Bundle du fournisseur converti ; null ne fait pas échouer à lui seul l’enveloppe HTTP. |

La conversion Bundle conserve les valeurs Int/Long/Double/String/Boolean et les Bundles imbriqués. Les tableaux deviennent des tableaux de chaînes. Les autres types deviennent leur chaîne `toString()` (y compris null dans un Bundle, qui devient la chaîne `"null"`). Vérifiez les champs d’échec dans `result` même si le code externe vaut 200.

Le gestionnaire actuel de LifeUp ajoute `api_result` (boolean) aux appels terminés. Un échec de méthode intercepté renvoie `api_result: false`, `error_code` (string) et `error_message` (string). Les codes incluent `missing_required_parameter`, `invalid_parameter`, `entity_not_found`, `invalid_format`, `unsupported_api`, `cancelled` et `internal_error` ; chaque méthode peut en ajouter. Pendant une restauration, le fournisseur peut renvoyer `error_code: "503"` et `error_message` sans `api_result`. Un gestionnaire d’API absent peut lever une exception avant cette conversion, produisant une erreur externe de passerelle.

## Lire et téléverser des fichiers :id=files-download

### GET /files/{url} :id=files-get

Encodez l’URI lisible complète en un seul segment de chemin. Les octets sont lus via le résolveur de contenu Android, généralement pour les icônes, pièces jointes de ressentis, exports de sauvegarde ou fichiers téléversés. Le résultat est un flux d’octets, pas une enveloppe JSON de succès. Aucun nom de fichier ni type MIME n’est précisé. Les flux vides/illisibles ne deviennent pas un résultat structuré introuvable ; les exceptions passent par le gestionnaire global HTTP 500. Un paramètre correspondant vide produit une enveloppe d’erreur (`url is required`).

```bash
curl "$BASE/files/content%3A%2F%2Fexample.provider%2Fimages%2F1" -o image.bin
```

### POST /files/upload :id=files-upload

Envoyez `multipart/form-data`. Chaque partie fichier est acceptée quel que soit le nom du champ ; les autres parties sont ignorées. Le nom original est utilisé pour le fichier en cache ; à défaut, Cloud choisit `uploaded_image_<time>.jpg`. Renvoie un tableau de chaînes URI de contenu lisibles. Le téléversement fournit une URI pour des appels ultérieurs sans joindre automatiquement le fichier à un objet ou une tâche. Sans fichier, une enveloppe d’erreur contient `No files received`.

```bash
curl -X POST "$BASE/files/upload" -F 'file=@image.png'
```

```json
{"code":200,"message":"success","data":["content://example.fileprovider/cache/image.png"]}
```

## Exporter et importer des sauvegardes :id=files-backup

### GET /data/export :id=files-export

Déclenche la création d’une sauvegarde via le fournisseur. Le paramètre facultatif `withMedia` vaut `true` par défaut ; s’il est présent, `true` sans distinction de casse signifie vrai et toute autre valeur faux. Renvoie le Bundle converti, contenant actuellement `backup_file_uri` ; téléchargez cette URI via `/files/{url}`. Ce point de terminaison crée un export malgré sa méthode GET. Les éventuels champs d’état/erreur du fournisseur doivent être vérifiés. Un `backup_file_uri` vide indique l’absence de fichier exploitable. Un résultat null devient une erreur.

```json
{"code":200,"message":"success","data":{"backup_file_uri":"content://example.provider/backup/LifeUpExportBackup.zip","api_result":true}}
```

### POST /data/import :id=files-import

Envoyez `multipart/form-data` avec un fichier de sauvegarde. S’il y en a plusieurs, le dernier est retenu ; son nom de champ n’est pas vérifié. Le nom par défaut est `backup.lfbak`. Le champ facultatif `description` est lu mais sans effet. Cloud met le fichier en cache et lance l’activité de sauvegarde LifeUp ; la réponse confirme le téléversement et le lancement, **pas la restauration terminée**. Sans fichier, renvoie `No file received`.

```bash
curl -X POST "$BASE/data/import" -F 'file=@backup.lfbak'
```

```json
{"code":200,"message":"success","data":"File uploaded and BackupActivity launched"}
```

## Événements :id=get-events

### GET /events :id=get-events-poll

Renvoie `EventsPage`. `after` est un curseur exclusif d’identifiant d’événement (entier sur 64 bits, défaut 0). `limit` est un entier, défaut 50, borné à 1–200. Les valeurs non entières utilisent les défauts. Les événements retenus avec `id > after` sont renvoyés du plus ancien au plus récent. Au plus 200 événements sont conservés en mémoire ; les plus anciens sont supprimés et les redémarrages réinitialisent les identifiants. `latestId` est le dernier identifiant global disponible, pas nécessairement le dernier d’une page limitée. Reprenez au dernier événement réellement traité pour ne pas sauter un retard. Aucun historique durable ni accusé de livraison.

```json
{"code":200,"message":"success","data":{"latestId":2,"eventWs":true,"events":[{"id":1,"time":1700000000000,"action":"app.lifeup.task.complete","extras":{"id":"42"}}],"broadcasts":true}}
```

### EventsPage :id=model-events-page

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `latestId` | integer | Identifiant du dernier événement actuel. |
| `eventWs` | boolean | Réglage WebSocket de Cloud. |
| `events` | CloudEvent[] | Événements conservés après le curseur. |
| `broadcasts` | boolean ou null | Si les diffusions LifeUp sont activées ; null signifie inconnu ou non pris en charge. L’état est mis en cache cinq secondes. |

### CloudEvent :id=model-cloud-event

| Champ | Type JSON | Signification |
| --- | --- | --- |
| `id` | integer | Identifiant séquentiel d’événement en mémoire. |
| `time` | integer | Heure de réception Cloud en millisecondes Unix. |
| `action` | string | Action de diffusion Android. |
| `extras` | objet de valeurs chaîne | Extras de diffusion convertis par `toString()` ; null devient une chaîne vide. Les clés dépendent de l’action. |

### WebSocket /events :id=get-events-websocket

Lorsque `eventWs` est true, connectez-vous à `ws://HOST:PORT/events?after=ID` avec le jeton configuré. Le serveur rejoue les événements conservés après `after`, puis envoie les événements en direct sous forme de trames texte JSON `CloudEvent` individuelles, **sans** enveloppe HTTP. La relecture est limitée au tampon mémoire de 200 événements ; aucun paramètre WebSocket `limit`. Le serveur envoie des trames Ping toutes les 30 secondes. Reconnectez-vous avec le dernier identifiant réellement traité. Si désactivée, la route WebSocket n’est pas enregistrée ; l’interrogation HTTP reste disponible.

```json
{"id":2,"time":1700000001000,"action":"app.lifeup.item.use","extras":{"id":"3"}}
```

Les abonnements d’actions pris en charge sont `app.lifeup.task.complete`, `app.lifeup.task.overdue`, `app.lifeup.task.giveup`, `app.lifeup.achievement.unlock`, `app.lifeup.achievement.condition.unlock`, `app.lifeup.item.purchase`, `app.lifeup.item.reward`, `app.lifeup.item.use`, `app.lifeup.synthesis.complete`, `app.lifeup.pomodoro.start`, `app.lifeup.pomodoro.pause`, `app.lifeup.pomodoro.complete`, `app.lifeup.pomodoro.stop`, `app.lifeup.feelings.add`, `app.lifeup.level.up`, `app.lifeup.level.down`, `app.lifeup.item.countdown.start`, `app.lifeup.item.countdown.complete`, `app.lifeup.item.countdown.stop`, `app.lifeup.timing.start`, `app.lifeup.timing.complete`, `app.lifeup.timing.pause`, et `app.lifeup.timing.abandon`. La collecte nécessite l’activation des diffusions LifeUp. L’interrogation `/events` vérifie ce réglage sans l’activer automatiquement.

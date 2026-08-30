<h1 align="center" padding="100">Interface ouverte</h1>

<p align="center">Créez des possibilités infinies !</p>

> [!NOTE]
> Nous déployons progressivement **LifeUp v1.106.0** et **LifeUp Cloud v3.0.0**. Les délais de validation varient selon la plateforme ; cette documentation peut être mise à jour avant que les apps soient largement disponibles, et la date de sortie réelle peut être postérieure à celle indiquée ici.

?> Dans la version v1.90, `LifeUp` a ouvert diverses interfaces fonctionnelles, et toute intégration avec des applications externes est la bienvenue. <br/>Elle propose aussi l'effet « URL » pour les Objets de la Boutique, et les utilisateurs peuvent utiliser directement les Objets pour appeler des applications externes ou l'interface de `LifeUp`. <br/>Ces fonctionnalités peuvent donner à votre `LifeUp` des possibilités illimitées, mais elles demandent aussi un peu de compréhension et de pratique.

**Dernière mise à jour : 2026/08/28**

Les paramètres et définitions de l'API dans ce document sont basés sur la version **v1.106.0**.

Assurez-vous que votre App a été mise à jour vers **v1.106.0** avant d'utiliser la dernière API.

La mise à jour se déploie progressivement via Google Play ; si vous ne l'avez pas encore reçue, soyez patient, elle arrivera bientôt.

## Exemple de scénario

| Appelant | Scénario | Notes |
| ------ | -------- | ----- |
|**LifeUp→Autres applications**<br/>Implémenté via l'effet « URL » de l'Objet de la Boutique| **Après utilisation de l'Objet de la Boutique :**<br/>1. Utiliser un navigateur pour visiter une page web<br/>2. Ouvrir WeChat et scanner, ou ouvrir un mini-programme spécifique<br/>3. Ajouter automatiquement des enregistrements comptables ([par exemple, « Qianji » prend en charge une interface de comptabilité](http://docs.qianjiapp.com/plugin/auto_tasker.html))<br/>4. Enregistrer la configuration de l'outil d'automatisation Tasker (même la partager sur le Market), et importer automatiquement la configuration dans Tasker après utilisation<br/>5. Déclencher Tasker pour changer le fond d'écran<br/>6. ... (tant que l'application externe prend en charge cette méthode d'appel) | [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=en_US&gl=US) est un outil d'automatisation et il permet d'exporter la configuration sous forme d'Uri |
|**LifeUp→LifeUp**<br/>Implémenté via l'effet « URL » de l'Objet de la Boutique| **Après utilisation de l'Objet de la Boutique :**<br/>1. Ouvrir une page spécifique<br/>2. Augmenter le taux d'intérêt du distributeur automatique<br/>3. Afficher une fenêtre contextuelle pour que l'utilisateur sélectionne le produit et en réduise le prix (coupon de réduction)<br/>4. Déclencher la finalisation d'une Tâche<br/>5. Afficher un message motivationnel personnalisé<br/>6. Créer un modèle de Récompense de Tâche : il suffit de saisir le nom pour créer automatiquement une Tâche<br/>7. Afficher une fenêtre demandant à l'utilisateur de choisir une branche, créant une petite interaction contextuelle<br/>8. Plus d'opérations dans l'App... |  |
|**Applications externes/pages web→LifeUp** | **Configurer des outils d'automatisation :**<br/>1. Détecter quand le téléphone s'allume pour la première fois chaque jour, finaliser la Tâche de lever tôt, ou déclencher directement la pénalité « lever tard »<br/>2. Après chaque 25 mots, passer une carte NFC spécifique et finaliser automatiquement la Tâche<br/>3. Le GPS détecte qu'un nouvel endroit est atteint, et débloque le Succès « nouvel endroit »<br/>4. Lors de la connexion quotidienne au Wi-Fi du travail, le progrès de la condition de déblocage augmente ; après 20 jours cumulés, débloquer le Succès « Travailleur »<br/>5. Se récompenser avec des pièces « rentrer à la maison » lors de la première connexion au Wi-Fi de la maison chaque jour<br/>6. Capturer les notifications d'autres applications Pomodoro ou Concentration, et enregistrer automatiquement le chronométrage dans `LifeUp`<br/>7. Capturer la notification de fin ou d'achèvement de logiciels de sport et d'étude, et attribuer automatiquement des Points d'Expérience « force » et « connaissance »<br/>8. Dans la période que vous définissez, chaque fois que vous ouvrez votre téléphone, une pénalité est déclenchée<br/>9. ...<br/>**Liaison avec application externe/application auto-développée :**<br/>1. Si le Pomodoro de `LifeUp` ne vous convient pas : vous pouvez développer votre propre logiciel de chronométrage, qu'il s'agisse d'une application web ou Android, et le lier à « LifeUp » via l'interface pour ajouter des enregistrements de chronométrage ou des Récompenses<br/>2. Modifier certains mini-jeux d'intelligence (comme l'exemple Wordle ci-dessous). Lorsque le jeu est terminé avec succès, déclencher l'envoi de Récompenses par `LifeUp`<br/>3. ... |  |

<br/>En d'autres termes, tous les scénarios ci-dessus sont en réalité des « événements » qui déclenchent des « actions ».

Cette mise à jour de `LifeUp` fournit le point de déclenchement d'événement « utilisation d'Objets », puis diverses « actions » (Récompenses, finalisation de Tâches, etc.).

Si vous avez besoin de

- Cliquer sur un bouton web
- Passer une carte NFC
- Déverrouiller l'écran pour la première fois chaque matin au réveil

Ce type d'événement nécessite l'intervention d'applications externes. Par exemple, faire vous-même un développement secondaire ou utiliser des outils d'automatisation tels que `Tasker` et `MacroDroid`.

**La mise à jour LifeUp 1.90.2 ajoutera une série d'« événements », qui peuvent être reçus par des outils d'automatisation ou des applications externes.**

Peut servir à :

Après utilisation de l'Objet, déclencher des outils d'automatisation tels que Tasker pour changer le fond d'écran du launcher.

Après finalisation de la Tâche, déclencher un outil d'automatisation tel que Tasker pour ouvrir une App.

**Dans la version 1.90.2, il est possible de réaliser un « événement LifeUp » déclenchant une « opération Tasker ».**

Tasker dispose de permissions très étendues : il peut changer les fonds d'écran, désinstaller des Apps, augmenter le volume, choisir d'ouvrir des Apps spécifiques, et bien plus. Vous pouvez même écrire une logique d'interaction UI sans base en programmation.

---

## Recommandations

**Si vous n'êtes pas familier avec la programmation,** vous pouvez rechercher et importer directement des Objets spéciaux de la Boutique dans [Monde] → [Market] → étiquette [Link]/[API]/[Automate]. Vous pouvez aussi essayer de modifier les paramètres pour répondre à vos besoins.

**Si vous maîtrisez l'informatique,** vous pouvez lire la documentation des interfaces ci-dessous et créer vous-même l'effet souhaité. Utilisez-la avec un logiciel d'automatisation tel que [*Tasker*](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm). Même si vous ne modifiez pas la configuration Tasker, tant que vous parvenez à installer Tasker, vous pouvez importer des configurations d'automatisation partagées par d'autres sur le Market ou dans d'autres communautés.

**Si vous avez des bases en programmation,** vous pouvez développer des pages web ou des applications Android pour les intégrer à LifeUp. Cette page et des versions personnalisées de Wordle en sont des exemples. Vous êtes aussi invité à créer et partager des configurations d'outils d'automatisation.

---

## Appeler une autre application

Si vous souhaitez appeler une application externe dans *LifeUp*, il suffit d'ajouter un effet « Link » à l'Objet de la Boutique, **saisir un lien web ou un lien spécifique à l'application**, puis utiliser l'Objet pour déclencher l'appel.

**Voici quelques exemples (vous pouvez aussi aller dans « Monde »→« Market »→« Link » pour voir les Objets publics avec effet d'appel d'interface) :**

- Ouvrir Google dans le navigateur : https://www.google.com
- Facebook : [fb://](fb://)
- Ouvrir une App avec son nom de package/ID : [market://launch?id=net.sarasarasa.lifeup](market://launch?id=net.sarasarasa.lifeup)
- ...

En théorie, tant que l'App externe fournit l'URL, vous pouvez y accéder en utilisant l'Objet de la Boutique.

**Vous pouvez rechercher le lien d'application dont vous avez besoin en cherchant `URL Schemes` sur Google.**

**Ces liens n'ont aucun rapport avec `LifeUp` ; `LifeUp` ne fournit que la fonction de redirection par URL.**

**Nous ne maintenons donc pas (et ne maintiendrons pas) de liste d'URLs. Mais vous pouvez consulter les Objets publics de la Boutique contenant l'effet de lien sur la page [Monde]→[Market]→[Link].**

Vous pouvez trouver le nom de package d'une App (aussi appelé ID) :

- dans son URL Google Play : https://play.google.com/store/apps/details?id=net.sarasarasa.lifeup
- en utilisant une App de gestion d'applications
- en utilisant l'action App Info dans Tasker
- en utilisant l'action Launch App dans MacroDroid

---

## Appeler les APIs LifeUp

Si vous :

- Devez appeler l'interface `LifeUp` dans `LifeUp`. Il suffit d'ajouter un effet « link » à l'Objet de la Boutique, saisir **une URL spécifique** selon la documentation des APIs, puis utiliser l'Objet pour effectuer l'appel.
- Appelez via une page web, il suffit de rediriger vers les APIs LifeUp par hyperlien.
- Appelez via une App que vous développez vous-même, il suffit d'utiliser Intent pour rediriger vers le lien d'interface correspondant.
- Appelez via un outil d'automatisation (tel que Tasker), renseignez le lien API correspondant dans Browser URL de Tasker.

**Quelques exemples :**

Lorsque vous cliquez sur le lien ci-dessous, « LifeUp » affichera « You have learned to call APIs! ».

<a href="lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true">lifeup://api/toast?text=You have learned to call APIs!&type=1&isLong=true</a>

Lorsque vous cliquez sur le lien ci-dessous, vous obtiendrez une pièce dans « LifeUp », et le motif sera « Learn API Calls ».

<a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

Si vous copiez le lien dans l'effet « link » de l'Objet, utiliser l'Objet déclenchera le même effet.

**Exemple de liaison avec une application externe :**

[Wordle Clone (lifeupapp.fun)](https://wiki.lifeupapp.fun/en/example/wordle/index.html)

Wordle est un petit jeu de devinettes de mots : il faut deviner des mots de 5 lettres. Orange indique que la lettre est dans la réponse ; vert, qu'elle est à la bonne position.

**Cette version de Wordle prend en charge la liaison avec « LifeUp » :**

1. Si vous devinez le mot correctement, vous obtenez 10 pièces, avec un motif personnalisé.
2. Si vous ne devinez pas le mot à la fin, il y a un prix de consolation de 1 pièce.

![](_media/api/wordle.png ':size=30%')

<br/>

**Exemple de liaison avec Tasker :**

> Tasker s'invoque en sélectionnant `Action Category`→`Program`→`Shortcut`. Saisissez dans la colonne de raccourci le lien commençant par lifeup://.

Déverrouiller l'écran pour la première fois après 5 h chaque jour peut déclencher la finalisation de la Tâche que vous indiquez (par exemple, se lever).

**Note : un Task Group Id est requis pour importer cette configuration. Vous pouvez activer [Developer Mode] dans [Settings]→[Labs], puis consulter le gid sur la page de détails de la Tâche.**

Si vous avez Tasker installé, [cliquez ici pour importer les Tâches configurées.](taskerproject://H4sIAAAAAAAAAKVWTW/bOBA9p7+CENCeshZlfcWtzMJts0ABY1EkaS49FKxE20xlSZDG3s2/3xmSku1ELer25OF7Q/LNB0fO7mT3XbUfJEjWtXPPY8Vez73AY7Cfe8mETwLuiRcX2ae2XulSGacG7ejKY3s196bEXmR5IUGJIEl4NONxMAvDMPMtaOiyEdDuFGJoEaKON4RRMA2vMl8NG1alXHcCIWsQpAsRIYA/tNrqgosozXxjEFJtlVgAi9mN6hSwu41iH+Rj5hNO/J3eWvl5XZmY6JqNiPGOjVttBcfV1q7AcOA4MBwYLvPpLMqK79IymqHZORk6yUcc8YDPfiEfsyf5SJ7k42/ddsA+V2Wdf1fFJXtfb5tSgWJU9kNqrveqgkNujmSj7rpAXZxj9MY08ZsNxrwFlNhvDca2JvFh50X2vq4KDbqulrqzV+qVdT/i7HlOSOjoi6zcdOJlpf4tqKy0cHjdiGCa+XXTAy1ymd/2Hpk/nGxF+CcqbEgmkJGaPqgc+po+8B+VNJmm05TPro5LWklM71Kv1OeGyR3ULHfZx8RLl/lGFx229SVV0tgEggGTS2pvsKBRRVLIpuIZSYBGlJyKQRlREiVpMEvO6C9qpmRopqbVVHKUhAYBi3woi8zBZSE9LnNMERzKfAut9W7XhzIOtUPWun10bYdu1DuynHvc859x059w4SmX+VbriOxgRHaY8mPZnRIrWXZYoc4h73ZV4R61icV11D16GRDvHvqzUjApdLUudZdvJrIq2loXEzATdnJzvby+X/xz9/V+cfNx8W55fStelfAGU4E7Fm0rH+0A9l+t4Q12yJln/Z6Ev+CxUeLL8kHu5aSU1Xpi9ZwvwJ7knhtlx700m79nTREMTVHiA9k1r31fNtrvX8jbtS7mL+myr2gNDXNSXPdM72Wr5bd+7u77yZ6XSrb1Dvp6DmvDqv+augWsHY6Jg20ovd3ugA7sdx4Awzf7XLtvmTEdWAhaF8OyEp/wxk4xXTU7YIBfIwqHrVFEwygm4+Tc8d0FVwTp4QQNAgwCPVKJo4zQ0uHO0fl1cBy2W5ncPUmYmSo0Sp6PlHRspHAeh/zHIyXk6TR+OlLSPxsp6W+MlNEmC8Znzhlz5YSLfsLFjgtHuMRxwbNZ1VfC/to/ZOLF/9uCy6GeCQAA)

![](_media/api/tasker_01.png ':size=30%')

![](_media/api/tasker_02.png ':size=30%')

<br/>

**Comment utiliser MacroDroid pour appeler les APIs LifeUp :**

> [MacroDroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid&hl=en_US&gl=US) est aussi un outil d'automatisation ; il est gratuit et son interface est plus simple.

1. Ajoutez des macros, puis définissez les conditions dont vous avez besoin (ou faites-le plus tard)
2. Ajoutez `Actions`
3. Sélectionnez `Applications`
4. Sélectionnez `Open Website`
5. Saisissez une URL commençant par `lifeup://` dans le champ `Enter URL`
6. **[Décochez]** toutes les options ci-dessous, comme `URL encode parameters`...
7. Enregistrez ; vous pouvez cliquer sur l'action, puis sélectionner `Test action` pour vérifier

<br/>

**Grâce à cette fonction, vous pouvez étendre à l'infini les possibilités de LifeUp, que vous connaissiez ou non la programmation !**

Consultez ci-dessous les règles d'appel précises.

---

## Documentation des interfaces

### Basics - Examples

| Type             | Description   |
| ---------------- | ------------- |
| Exemple          | <a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a> |
| Format d'interface | fixed prefix/method name?parameter1=value1&parameter2=value2 |
| Préfixe fixe     | lifeup://api/ |
| Nom de la méthode | toast         |
| Paramètres       | ?text=You learned to call! &type=1&isLong=true |

<br/>

### Basics - Escaping (URL Encode)

Si la valeur de votre paramètre contient des symboles spéciaux tels que +, espace, =, %, &, #, etc., elle doit être échappée :

| Caractères spéciaux | Signification                                         | Remplacer par |
| :----------------- | :---------------------------------------------- | :--------- |
| +                  | Le signe + dans l'URL représente un espace        | +          |
| espaces             | Les espaces dans les URLs peuvent être + ou encodés              | %20        |
| /                  | Sépare répertoire et sous-répertoire            | %2F        |
| ?                  | Sépare l'URL réelle et les paramètres         | %3F        |
| %                  | Spécifie des caractères spéciaux                      | %          |
| #                  | Indique un signet                                  | %23        |
| &                  | Séparateur entre les paramètres spécifiés dans l'URL   | %26        |
| =                  | Valeur du paramètre spécifié dans l'URL | %3D        |

Prenons comme exemple l'interface du message contextuel ci-dessus. Si vous voulez que le texte final affiché soit `You have learned to call APIs!`,
il faut remplacer les espaces par + ; le résultat final est :

<a href="lifeup://api/toast?text=You learned to call! &type=1&isLong=true">lifeup://api/toast?text=You learned to call! &type=1&isLong=true</a>
<br/>

**Voici un outil de codage simple implémenté en Javascript :**

<iframe src="guide/html/url_encoded.html" frameborder="0" scrolling="no" width="90%"> </iframe>

<br/>

### Basics - LifeUp Data ID

Presque toutes les données stockées dans LifeUp ont un id unique.

Certaines des interfaces suivantes permettent de modifier des Objets de la Boutique **spécifiés** et de finaliser des Tâches **spécifiées**.

Pour que `LifeUp` trouve les données correspondantes, vous devez lui fournir un id.

**Vous pouvez activer « Settings » → « Labs » → « Developer Mode » pour voir l'id d'origine des données sur chaque page de détails dans l'App.**

Par exemple, si le nom de l'Attribut s'affiche comme « strength (1) », son id d'Attribut est 1.

#### Task id

Consultable sur la page de détails de l'événement.

id : s'il s'agit d'une Tâche répétitive, l'id est mis à jour à chaque répétition.

gid : l'id du groupe d'éléments. Pour la même Tâche répétitive, son gid ne change pas.

#### List id

Après activation de « Developer Mode », consultez-le dans la fenêtre contextuelle « Select List ».

#### Attribute id

Après activation de « Developer Mode », consultez-le sur la page « Custom Attributes ».

#### Shop item id

Après activation de « Developer Mode », cliquez sur l'Objet de la Boutique pour voir les détails.

#### Achievement condition id

Après personnalisation de la condition de déblocage du Succès « requires an external API call to unlock », vous pouvez voir l'id de la condition sur la page de détails.

<br/>

### Basics - Name Matching

Lorsqu'une API prend en charge la recherche de Tâches, d'Objets de la Boutique ou de sous-tâches par nom, LifeUp tente d'abord une correspondance exacte en ignorant la casse. Si aucune correspondance exacte n'est trouvée, il passe à une correspondance floue par inclusion.

Par exemple, si « Coin » et « Coin Box » existent tous deux, passer `name=Coin` correspond d'abord à « Coin » plutôt qu'au premier résultat flou qui apparaît.

Si des noms dupliqués ou similaires peuvent prêter à confusion, préférez passer l'id correspondant.

<br/>

### Basics - Return Values

Certaines interfaces peuvent renvoyer des valeurs.

**Si vous développez une application Android,** vous pouvez utiliser la méthode `onActivityResult` pour recevoir la valeur renvoyée.

**Si vous utilisez une application d'automatisation telle que Tasker :**

En général, ces applications ne peuvent pas recevoir de valeurs renvoyées de type Activity. Il faut donc ajouter un paramètre `broadcast`, puis utiliser l'événement `received intent` pour recevoir la valeur renvoyée.

Pour plus de détails, consultez les paramètres broadcast ci-dessous.

<br/>

### Basics - JSON Data Structure

?> Nécessite v1.98.0+

Cette section présente les structures JSON couramment utilisées dans l'API.

#### 1. Structure de Récompense d'Objets

Un tableau JSON spécifiant les Récompenses d'Objets ; chaque élément contient un ID et une quantité.

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

#### 2. Structure de condition de déblocage de Succès

```json
[
    {
        "type": 7,           // Condition type
        "related_id": null,  // Related ID (some types must provide)
        "target": 1000000    // Target value
    }
]
```

#### 3. Structure de limite d'achat

`purchase_limit` est un tableau JSON. Chaque objet représente une règle de restriction.

| Champ | Signification | Type | Obligatoire | Notes |
| ----- | ------- | ---- | -------- | ----- |
| limitType | Type de restriction | number | Oui | Voir le tableau des types ci-dessous |
| limitNumber | Valeur numérique principale | number | Non* | Utilisé par les règles basées sur quantité/plage |
| maxNumber | Limite supérieure d'une plage | number | Non | Utilisé par plage de Niveau d'Attribut / quantité d'Objets possédés |
| limitId | ID de la cible associée | number | Non* | Requis pour les règles basées sur Attribut / Objet / Tâche / cycle de Tâche / Succès |
| extendInfo | Données supplémentaires | string | Non | Utilisé par les règles basées sur le temps ; la valeur elle-même est une chaîne JSON |

**Définitions des types**

| limitType | Signification | Champs requis / notes |
| --------- | ------- | ----------------------- |
| 0 | Limite quotidienne de quantité | `limitNumber` : nombre max par jour |
| 1 | Limite hebdomadaire de quantité | `limitNumber` : nombre max par semaine |
| 2 | Limite mensuelle de quantité | `limitNumber` : nombre max par mois |
| 3 | Limite annuelle de quantité | `limitNumber` : nombre max par an |
| 10 | Règle de Niveau d'Attribut | `limitId` : ID d'Attribut<br/>`limitNumber` : niveau minimum<br/>`maxNumber` : niveau maximum optionnel |
| 20 | Plage horaire quotidienne | `extendInfo` : `{"startMinuteOfDay":540,"endMinuteOfDay":1320}` |
| 21 | Sélection des jours ouvrables | `extendInfo` : `{"weekdays":[1,2,3,4,5]}`<br/>Lundi = 1, dimanche = 7 |
| 22 | Plage horaire absolue | `extendInfo` : `{"startMillis":1710000000000,"endMillis":1710086400000}` |
| 23 | Sélection des mois | `extendInfo` : `{"months":[1,6,12]}` |
| 24 | Sélection du jour du mois | `extendInfo` : `{"daysOfMonth":[1,15,31]}` |
| 30 | Règle de quantité d'Objets possédés | `limitId` : ID de l'Objet cible<br/>`limitNumber` : quantité minimale possédée<br/>`maxNumber` : quantité maximale possédée optionnelle |
| 31 | Règle de Tâche finalisée | `limitId` : ID de Tâche |
| 32 | Règle de Succès débloqué | `limitId` : ID de Succès |
| 33 | Règle de cycle de Tâche finalisé | `limitId` : ID du groupe de Tâches répétitives (`groupId`)<br/>Validé par rapport au dernier cycle démarré dans ce groupe |

**Notes**

- Lorsque `limitType=33`, `limitId` n'est pas un ID de Tâche. Il doit s'agir du `groupId` de la Tâche répétitive.

- Les charges utiles compatibles avec les versions antérieures peuvent omettre `maxNumber` et `extendInfo`.
- `extendInfo` est un champ de type string ; lors d'un appel API via URL, la chaîne JSON qu'il contient nécessite généralement une couche supplémentaire d'échappement/encodage.

**Exemple :**

```json
[
    {
        "limitType": 0,
        "limitNumber": 5
    },
    {
        "limitType": 10,
        "limitId": 1,
        "limitNumber": 5,
        "maxNumber": 10
    }
]
```

#### 4. Structure d'effet d'Objet

```json
[
    {
        "type": 2,           // Effect type
        "info": {            // Effect parameters, different for different types
            "min": 100,      // Minimum value (used for gold rewards, etc.)
            "max": 200       // Maximum value (used for gold rewards, etc.)
        }
    }
]
```

#### Description des types d'effet

?> Les types 10-16 sont pris en charge à partir de v1.102.0+.

| Code de type | Signification | Description des paramètres |
| ------- | ---- | ------- |
| 0 | Aucun effet spécial | Aucun paramètre |
| 1 | Non utilisable | Aucun paramètre |
| 2 | Ajouter des pièces | min : pièces minimum<br/>max : pièces maximum (optionnel, par défaut min)<br/>using_limit : appliquer les limites du système (optionnel) |
| 3 | Retirer des pièces | min : pièces minimum<br/>max : pièces maximum (optionnel, par défaut min)<br/>using_limit : appliquer les limites du système (optionnel) |
| 4 | Ajouter de l'expérience | ids : tableau d'ID de Compétence<br/>value : valeur d'expérience (legacy, identique à min)<br/>min : expérience minimum (optionnel, si value n'est pas fourni)<br/>max : expérience maximum (optionnel, par défaut min/value)<br/>using_limit : utiliser la limite (optionnel, false par défaut) |
| 5 | Retirer de l'expérience | ids : tableau d'ID de Compétence<br/>value : valeur d'expérience (legacy, identique à min)<br/>min : expérience minimum (optionnel, si value n'est pas fourni)<br/>max : expérience maximum (optionnel, par défaut min/value)<br/>using_limit : utiliser la limite (optionnel, false par défaut) |
| 6 | Synthèse simple | require_number : quantité requise<br/>item_id : ID d'Objet |
| 7 | Ouvrir une Boîte de butin | items : tableau d'Objets ; chaque élément contient :<br/>- item_id : ID d'Objet<br/>- amount : quantité<br/>- probability : probabilité<br/>- is_fixed_reward : s'il s'agit d'une Récompense fixe |
| 8 | Compte à rebours | seconds : secondes du compte à rebours |
| 9 | Lien web | url : adresse du lien<br/>use_web_view : utiliser le navigateur intégré (optionnel, false par défaut) |
| 10 | Enregistrer une Émotion | Aucun paramètre |
| 11 | Modifier les pièces (augmenter ou diminuer) | min : pièces minimum (peut être négatif)<br/>max : pièces maximum (optionnel, par défaut min)<br/>using_limit : appliquer les limites du système (optionnel) |
| 12 | Modifier l'expérience (augmenter ou diminuer) | ids : tableau d'ID de Compétence<br/>value : valeur d'expérience (legacy, identique à min)<br/>min : expérience minimum (peut être négative)<br/>max : expérience maximum (optionnel, par défaut min/value)<br/>using_limit : utiliser la limite (optionnel, false par défaut) |
| 13 | Ajouter le stock d'Objet | item_id : ID de l'Objet cible<br/>min : variation minimale de stock<br/>max : variation maximale de stock (optionnel, par défaut min)<br/>using_limit : appliquer les limites de stock (optionnel) |
| 14 | Retirer le stock d'Objet | item_id : ID de l'Objet cible<br/>min : variation minimale de stock<br/>max : variation maximale de stock (optionnel, par défaut min)<br/>using_limit : appliquer les limites de stock (optionnel) |
| 15 | Modifier le stock d'Objet (augmenter ou diminuer) | item_id : ID de l'Objet cible<br/>min : variation minimale de stock (peut être négative)<br/>max : variation maximale de stock (optionnel, par défaut min)<br/>using_limit : appliquer les limites de stock (optionnel) |
| 16 | Lire un son | file_name : nom du fichier son local (préféré)<br/>uri : URI du son à importer (alternative à file_name)<br/>display_name : nom affiché (optionnel) |

**Exemples d'effet :**

Augmenter l'or aléatoirement :

```json
{
    "type": 2,
    "info": {
        "min": 100,
        "max": 200
    }
}
```

Augmenter les Points d'Expérience :

```json
{
    "type": 4,
    "info": {
        "ids": [1, 2],
        "value": 50,
        "using_limit": false
    }
}
```

Modifier les pièces (aléatoire +/-) :

```json
{
    "type": 11,
    "info": {
        "min": -10,
        "max": 20
    }
}
```

Modifier le stock d'Objet (aléatoire +/-) :

```json
{
    "type": 15,
    "info": {
        "item_id": 1,
        "min": -3,
        "max": 5
    }
}
```

Lire un son :

```json
{
    "type": 16,
    "info": {
        "display_name": "API test sound",
        "uri": "android.resource://net.sarasarasa.lifeup/raw/bellringing"
    }
}
```

Effet d'ouverture de Boîte de butin :

```json
{
    "type": 7,
    "info": {
        "items": [
            {
                "item_id": 1,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": false
            },
            {
                "item_id": 2,
                "amount": 1,
                "probability": 50,
                "is_fixed_reward": true
            }
        ]
    }
}
```

<br/>

### Popup message

**Nom de la méthode:** toast

**Description:** Affiche des messages contextuels de différents styles

**Exemple:** <a href="lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true">lifeup://api/toast?text=Live well, eat well!&type=1&isLong=true</a>

**Explication:** Le message « Live well, eat well! » s'affiche avec le style bonus et reste visible plus longtemps.

> Cliquez sur le lien de l'exemple pour tester l'effet

| Paramètre | Signification                | Type               | Exemple              | Obligatoire | Notes |
| --------- | ---------------------- | ------------------ | -------------------- | -------- | ----- |
| text      | Texte du message | Texte libre           | You learned to call! | oui      |       |
| type      | Style du texte        | Nombre de 0 à 6 | 1                    | non       | 0 - Style normal<br/>1 - Style bonus<br/>2 - Style tomate<br/>3 - Style succès<br/>4 - Style info<br/>5 - Style avertissement<br/>6 - Style erreur |
| isLong    | Durée d'affichage       | true ou false      | true                 | non       | true - long<br/>false - court |

<br/>

### Reward

**Nom de la méthode:** reward

**Description:** Accorde la Récompense directement. Le motif peut être personnalisé.

**Exemple:**

- Obtenir 1 pièce ; le motif est « Learn API Calls ». Le motif s'affichera sur la page de détails des pièces :

  <a href="lifeup://api/reward?type=coin&content=Learn API Calls&number=1">lifeup://api/reward?type=coin&content=Learn API Calls&number=1</a>

- Obtenir 300 Points d'Expérience pour « Learning, Creativity » ; le motif est « Learn API Calls ». Le motif s'affichera sur la page de détails des EXP :

  <a href="lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6">lifeup://api/reward?type=exp&content=Learn API Calls&number=300&skills=2&skills=6</a>

- Obtenir 1 Objet correspondant approximativement à « treasure » ; le motif est « Learn API Calls ». Le motif s'affichera dans l'historique de l'Inventaire :

  <a href="lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure">lifeup://api/reward?type=item&content=Learn API Calls&number=1&item_name=treasure</a>

| Paramètre | Signification                       | Type                            | Exemple            | Obligatoire | Notes                            |
| --------- | ----------------------------- | ------------------------------- | ------------------ | -------- | -------------------------------- |
| type      | Type de Récompense                   | actuellement seulement :<br/>coin<br/>exp<br/>item | coin | oui | coin - pièces<br/>exp - Points d'Expérience<br/>item - Objets de la Boutique |
| content   | Motif de la Récompense                 | texte libre                        | Learning API Calls | Oui      |                                  |
| skills    | Compétences (Attributs)           | tableau de nombres > 0 | 1                  | Non       | Uniquement lorsque type est exp<br/>Prend en charge les tableaux (p. ex. &skills=1&skills=2&skills=3)<br/>Pour savoir comment les obtenir, consultez la section « Basics - LifeUp Data ID » ci-dessus |
| number    | Nombre de Récompenses             | nombre > 0         | 1                  | Oui      | Pour les pièces, maximum 999999<br/>Pour les Points d'Expérience, maximum 99999<br/>Pour un Objet, maximum 999 |
| item_id   | ID de l'Objet                       | nombre > 0           | 1                  | non*      | uniquement lorsque type est item |
| item_name | Nom de l'Objet                     | texte libre                        | treasure           | non*      | uniquement lorsque type est item ; correspondance floue avec les noms d'Objets |
| silent    | Désactiver les invites de l'interface | true ou false                   | false              | non       | false par défaut                 |

<br/>

### Penalty

**Nom de la méthode:** penalty

**Description:** Applique une pénalité directement. Le motif peut être personnalisé.

**Exemple:** *Fondamentalement identique à l'interface reward

- Pénaliser 1 pièce ; le motif est « sleep in ». Le motif s'affichera sur la page de détails des pièces :

  <a href="lifeup://api/penalty?type=coin&content=sleep in&number=1">lifeup://api/penalty?type=coin&content=sleep in&number=1</a>

- Pénaliser 300 Points d'Expérience de « Strength » pour « sleep in ». Le motif s'affichera sur la page de détails des EXP :

  <a href="lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1">lifeup://api/penalty?type=exp&content=sleep in&number=300&skills=1</a>

- Pénaliser 1 Objet correspondant approximativement à « treasure » pour « sleep in ». Le motif s'affichera dans l'historique de l'Inventaire :

  <a href="lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure">lifeup://api/penalty?type=item&content=sleep in&number=1&item_name=treasure</a>

| Paramètre | Signification                       | Type                                                 | Exemple  | Obligatoire | Notes            |
| --------- | ----------------------------- | ---------------------------------------------------- | -------- | -------- | ---------------- |
| type      | Type de pénalité                  | Actuellement seulement :<br/>coin<br/>exp<br/>item | coin     | oui      | coin - pièces<br/>exp - Points d'Expérience<br/>item - Objets de la Boutique |
| content   | Motif de la pénalité            | texte libre                                             | Sleep In | Oui      |                  |
| skills    | Compétences (Attributs)           | tableau de nombres > 0                      | 1        | Non       | Uniquement lorsque type est exp<br/>Prend en charge les tableaux (p. ex. &skills=1&skills=2&skills=3)<br/>Pour savoir comment les obtenir, consultez la section « Basics - LifeUp Data ID » ci-dessus |
| number    | Nombre pénalisé             | nombre > 0                              | 1        | Oui      | Pour les pièces, maximum 999999<br/>Pour les Points d'Expérience, maximum 99999<br/>Pour un Objet, maximum 999 |
| item_id   | ID de l'Objet                       | nombre > 0                                | 1        | non*      | uniquement lorsque type est item |
| item_name | Nom de l'Objet                     | texte libre                                             | treasure | non*      | uniquement lorsque type est item ; correspondance floue avec les noms d'Objets |
| silent    | Désactiver les invites de l'interface | true ou false                                        | false    | non       | false par défaut |

<br/>

### Edit Coin

**Nom de la méthode:** edit_coin

**Description:** Modifie directement le solde de pièces de l'utilisateur. Le solde actuel sera défini sur la valeur indiquée. Le motif du changement peut être personnalisé et s'affichera dans l'historique des pièces.

**Exemple:**

- Définir les pièces à 1000 avec le motif « API adjustment » : <a href="lifeup://api/edit_coin?coin=1000&content=API adjustment">lifeup://api/edit_coin?coin=1000&content=API adjustment</a>
- Définir les pièces à 500 en silence : <a href="lifeup://api/edit_coin?coin=500&silent=true">lifeup://api/edit_coin?coin=500&silent=true</a>

| Paramètre | Signification | Type | Exemple | Obligatoire | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| coin | Solde cible de pièces | number >= 0 | 1000 | Oui | Solde final après l'opération ; maximum 999999 |
| content | Motif du changement | texte libre | API adjustment | Non | Si absent, utilise le motif par défaut du système |
| reason | Motif du changement (alias) | texte libre | API adjustment | Non | Alternative au paramètre content |
| silent | Désactiver la notification de l'interface | true ou false | false | Non | false par défaut ; true supprime le message toast |

<br/>

### Tasks

#### Add a Task

?> Certains champs comme `pin` requièrent v1.98.0+

**Nom de la méthode:** add_task

**Description:** Crée une Tâche directement

**Exemple:**
[lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin](lifeup://api/add_task?todo=This is an auto-added task&notes=notes&coin=10&coin_var=1&exp=2048&skills=1&skills=2&skills=3&category=0&item_name=coin)

| Paramètre         | Signification             | Valeurs                | Exemple   | Obligatoire | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| todo             | Contenu de la Tâche        | texte libre             | Write diary | Oui     |                                |
| notes            | Notes               | texte libre             | Notes      | Non       | Vide par défaut               |
| coin             | Récompense en pièces         | number >= 0         | 10         | Non       | 0 par défaut ; soumis aux limites du système                   |
| coin_var         | Variation de pièces| number >= 0          | 1          | Non       | 0 par défaut ; si >0, Récompense aléatoire entre [coin, coin+coin_var] |
| exp              | Récompense en Points d'Expérience   | number >= 0          | 100        | Non       | 0 par défaut ; soumis aux limites du système                   |
| skills           | ID de Compétence           | tableau de nombres > 0 | 1          | Non       | Prend en charge les tableaux (p. ex., &skills=1&skills=2) |
| category         | ID de liste             | number >= 0          | 0          | Non       | 0 par défaut (liste par défaut) ; listes intelligentes non autorisées |
| frequency        | Fréquence de répétition    | integer              | 0          | Non       | 0 par défaut (une fois)<br/>0 - Une fois<br/>1 - Quotidienne<br/>N (N>1) - Tous les N jours<br/>-1 - Illimitée<br/>-3 - Ebbinghaus (requiert v1.99.1)<br/>-4 - Mensuelle<br/>-5 - Annuelle |
| weekdays         | Jours de la semaine            | `1,3,5` ou `none`    | 1,3,5      | Non       | v1.106.0+ ; 1=lundi … 7=dimanche, jours **à répéter**. Si présent, frequency doit être omis ou égal à 1. `none` est rejeté à l'ajout ; à l'édition, `none` rétablit le mode quotidien. Les 7 jours sont traités comme quotidien |
| importance       | Niveau d'importance    | [1, 4]              | 1          | Non       | 1 par défaut                   |
| difficulty       | Niveau de difficulté    | [1, 4]              | 1          | Non       | 1 par défaut                   |
| deadline         | Date limite            | timestamp (millisecondes) | 1640995200000 | Non |                               |
| no_deadline      | Sans date limite         | true/false         | true      | Non       | v1.104.0+ ; valable uniquement pour les Tâches répétitives. Passer `&no_deadline=true` efface la date limite précise |
| color            | Couleur de l'étiquette           | chaîne de couleur         | #66CCFF    | Non       | # doit être échappé en %23        |
| background_url   | URL de l'image de fond| URL web             | http://example.com/bg.jpg | Non | Doit être une image web accessible |
| background_alpha | Opacité du fond  | float entre [0, 1] | 0.5        | Non       | 1.0 par défaut                |
| enable_outline   | Contour du texte | true ou false       | false      | Non       | Valable uniquement avec background_url ; ajoute un contour au texte pour une meilleure lisibilité |
| use_light_remark_text_color | Texte clair pour les notes | true ou false | false | Non | Valable uniquement avec background_url ; utilise une couleur claire pour les notes |
| start_time       | Heure de début          | timestamp (millisecondes) | 1640995200000 | Non | Heure de début de la Tâche              |
| auto_use_item    | Utiliser automatiquement les Objets de Récompense| true ou false      | false      | Non       | Utilise les Récompenses automatiquement à la finalisation |
| remind_time      | Heure de rappel       | timestamp (millisecondes) | 1640995200000 | Non | Heure de rappel de la Tâche          |
| pin              | Épingler la Tâche            | true ou false       | false      | Non       | Épingle la Tâche en haut                |
| words            | Texte de Récompense à la finalisation | texte libre         | Great job! | Non       | Texte motivationnel affiché à la finalisation de la Tâche |
| frozen           | État de gel       | true ou false       | false      | Non       | false par défaut              |
| freeze_until     | Geler jusqu'au        | timestamp (millisecondes) | 1640995200000 | Non | Effectif uniquement lorsque frozen est true |
| coin_penalty_factor | Facteur de pénalité en pièces| float entre [0, 100) | 0.5    | Non       |                               |
| exp_penalty_factor | Facteur de pénalité d'expérience| float entre [0, 100) | 0.5 | Non    |                               |
| write_feelings   | Activer les Émotions     | true ou false       | false      | Non       | false par défaut              |
| item_id          | ID de l'Objet             | number > 0          | 1          | Non*      | item_id ou item_name requis |
| item_name        | Nom de l'Objet           | texte libre            | Treasure   | Non*      | item_id ou item_name requis |
| item_amount      | Quantité d'Objet       | [1, 99]             | 1          | Non       | 1 par défaut                  |
| items            | Récompenses d'Objets        | texte JSON           | Voir [Structure de Récompense d'Objets](#1-item-rewards-structure) | Non | Définit plusieurs Récompenses d'Objets |
| task_type        | Type de Tâche           | [0, 4]              | 0          | Non       | Requiert v1.99.1<br/>0 - Tâche normale<br/>1 - Tâche de comptage<br/>2 - Tâche négative<br/>3 - Tâche API<br/>4 - Tâche chronométrée (v1.102.0+) |
| target_times     | Nombre cible        | number > 0          | 1          | Non       | Valable uniquement lorsque task_type est 1 (tâche de comptage) |
| is_affect_shop_reward | Affecte la Récompense de la Boutique | true/false      | false    | Non       | Valable uniquement lorsque task_type est 1 (tâche de comptage) ; indique si le calcul de Récompense des Objets est affecté |
| enable_proportional_settlement | Règlement proportionnel | true/false | false | Non | v1.104.0+ ; valable uniquement lorsque task_type est 1 (tâche de comptage). Une fois activé, le règlement de la progression de comptage accorde les Récompenses proportionnellement, et la finalisation n'accorde plus ce qui a déjà été réglé |
| expected_focus_minutes | Minutes de Concentration attendues | number > 0 | 25 | Non | Valable uniquement lorsque task_type est 4 (tâche chronométrée) ; 25 par défaut (v1.102.0+) |
| repeat_end_mode | Mode de fin de répétition | 0 ou 1 | 0 | Non | Valable uniquement pour les Tâches répétitives (frequency n'est pas 0 / -1)<br/>0 - Terminer par nombre<br/>1 - Terminer par date (v1.102.0+) |
| repeat_target_times | Nombre de fin de répétition | number > 0 | 3 | Non | Utilisé lorsque repeat_end_mode=0 (ou inféré par ce champ) ; ne pas confondre avec target_times (v1.102.0+) |
| repeat_end_date | Date de fin de répétition | timestamp (millisecondes) | 1640995200000 | Non | Utilisé lorsque repeat_end_mode=1 (ou inféré par ce champ) (v1.102.0+) |
| repeat_end_behavior | Comportement à la fin de la répétition | 0 ou 1 | 0 | Non | 0 - Terminer la Tâche une fois la condition atteinte<br/>1 - Geler la Tâche une fois la condition atteinte (v1.102.0+) |

**Réponse:**

| Champ    | Type    | Description      | Exemple | Notes                    |
| -------- | ------- | ---------------- | ------- | ------------------------ |
| task_id  | Number  | ID de Tâche          | 1000    |                          |
| task_gid | Number  | ID de groupe de Tâches    | 1000    |                          |

<br/>

#### Complete a Task

**Nom de la méthode:** complete

**Description:** Déclenche la finalisation d'une Tâche. Seules les Tâches non finalisées sont recherchées.

**Exemple:**

- Finaliser la Tâche avec l'id 1 : [lifeup://api/complete?id=1](lifeup://api/complete?id=1)
- Finaliser la Tâche avec le « task group id » 1 : [lifeup://api/complete?gid=1](lifeup://api/complete?gid=1)
- Rechercher des Tâches par nom et les finaliser : <a href="lifeup://api/complete?name=Start using&ui=true">lifeup://api/complete?name=Start using&ui=true</a>

**Explication:**

Chaque Tâche possède un id.

Pour les Tâches répétitives, l'id est renouvelé à chaque répétition, mais le « task group id » reste le même.

Pour obtenir l'id, activez « Developer Mode » sur la page « Labs », puis consultez-le sur la page « Task Details ».

| Paramètre | Signification                         | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------------------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tâche                         | nombre > 0 | 1       | non*      | ID de Tâche ; pour une Tâche répétitive, l'id est mis à jour à chaque répétition. |
| gid       | ID de groupe de Tâches                   | nombre > 0 | 1       | non*      | ID de groupe de Tâches ; |
| name      | nom                            | texte libre              | get up  | non*      | recherche floue ; une seule des Tâches trouvées |
| ui        | Afficher l'interface contextuelle | true ou false         | true    | non       | false par défaut ; seul un message s'affiche en arrière-plan |
| count                    | Valeur de comptage                        | Number                                                 | 1         | Non       | Applicable uniquement aux tâches de comptage ; utiliser avec le paramètre `count_set_type`     |
| count_set_type           | Mode de définition du comptage         | L'un des suivants :<br/>absolute<br/>relative        | absolute  | Non       | relative par défaut<br/>absolute - Définit directement la cible à la valeur<br/>relative - Ajoute ou soustrait par rapport à la valeur d'origine |
| count_force_sum_up       | Forcer le total des Récompenses de tâche de comptage  | true ou false                                          | true      | Non       |                                                                                                    |
| reward_factor            | Facteur de Récompense                      | Nombre décimal > 0                   | 1.1       | Non       | Non applicable aux tâches de comptage<br/>Le facteur affecte la quantité d'expérience et de pièces (pas la quantité d'Objets) |

**Avis:**

1. Pour pouvoir localiser la Tâche, il faut indiquer id, gid ou name.
2. Les tâches chronométrées ne peuvent pas être finalisées manuellement via cette API (v1.102.0+).

<br/>

#### Give up a Task

**Nom de la méthode:** give_up

**Description:** Déclenche l'abandon d'une Tâche.

**Exemple:**

- Rechercher des Tâches par nom et les abandonner : [lifeup://api/give_up?name=get up early](lifeup://api/give_up?name=get up early)

**Explication:**

| Paramètre | Signification       | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tâche       | nombre > 0 | 1       | non*      | ID de Tâche ; pour une Tâche répétitive, l'id est mis à jour à chaque répétition. |
| gid       | ID de groupe de Tâches | nombre > 0 | 1       | non*      | ID de groupe de Tâches ; |
| name      | nom          | texte libre              | get up  | non*      | recherche floue ; agit sur une seule Tâche correspondante |

**Avis:**

1. Pour pouvoir localiser la Tâche, il faut indiquer id, gid ou name.

<br/>

#### Freeze a task

**Nom de la méthode:** freeze

**Description:** Gèle une Tâche ; uniquement pour les Tâches répétitives.

**Exemple:**

- Rechercher des Tâches par nom et les geler : [lifeup://api/freeze?name=get up early](lifeup://api/freeze?name=get up early)

**Explication:**

| Paramètre | Signification       | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tâche       | nombre > 0 | 1       | non*      | ID de Tâche ; pour une Tâche répétitive, l'id est mis à jour à chaque répétition. |
| gid       | ID de groupe de Tâches | nombre > 0 | 1       | non*      | ID de groupe de Tâches ; |
| name      | nom          | texte libre              | get up  | non*      | recherche floue ; agit sur une seule Tâche correspondante |
| time      | Geler jusqu'au  | timestamp             | 1661688800682 | non | - |

**Avis:**

1. Pour pouvoir localiser la Tâche, il faut indiquer id, gid ou name.

<br/>

#### Unfreeze a task

**Nom de la méthode:** unfreeze

**Description:** Dégèle une Tâche.

**Exemple:**

- Rechercher des Tâches par nom et les dégeler : [lifeup://api/unfreeze?name=get up early](lifeup://api/unfreeze?name=get up early)

**Explication:**

| Paramètre | Signification       | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tâche       | nombre > 0 | 1       | non*      | ID de Tâche ; pour une Tâche répétitive, l'id est mis à jour à chaque répétition. |
| gid       | ID de groupe de Tâches | nombre > 0 | 1       | non*      | ID de groupe de Tâches ; |
| name      | nom          | texte libre              | get up  | non*      | recherche floue ; agit sur une seule Tâche correspondante |

**Avis:**

1. Pour pouvoir localiser la Tâche, il faut indiquer id, gid ou name.

<br/>

#### Delete a task

**Nom de la méthode:** delete_task

**Description:** Supprime une Tâche.

**Exemple:**

- Rechercher des Tâches par nom et les supprimer : [lifeup://api/delete_task?name=get up early](lifeup://api/delete_task?name=get up early)

**Explication:**

| Paramètre | Signification       | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------- | --------------------- | ------- | -------- | ----- |
| id        | ID de Tâche       | nombre > 0 | 1       | non*      | ID de Tâche ; pour une Tâche répétitive, l'id est mis à jour à chaque répétition. |
| gid       | ID de groupe de Tâches | nombre > 0 | 1       | non*      | ID de groupe de Tâches ; |
| name      | nom          | texte libre              | get up  | non*      | recherche floue ; agit sur une seule Tâche correspondante |

**Avis:**

1. Pour pouvoir localiser la Tâche, il faut indiquer id, gid ou name.

<br/>

### Edit Task

?> Requiert v1.98.0+

**Nom de la méthode:** edit_task

**Description:** Modifie le contenu et les propriétés d'une Tâche existante

**Exemple:**
[lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0](lifeup://api/edit_task?id=1&todo=Modified task content&notes=notes&coin=10&exp=20&skills=1&skills=2&category=0)

| Paramètre           | Signification              | Valeurs                | Exemple   | Obligatoire | Notes                           |
| ------------------ | -------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id                 | ID de Tâche              | nombre > 0 | 1        | Non*      | id, gid ou name requis |
| gid                | ID de groupe de Tâches        | nombre > 0 | 1        | Non*      | id, gid ou name requis |
| name               | Nom de la Tâche            | texte libre             | Write diary| Non*      | id, gid ou name requis |
| todo               | Contenu de la Tâche         | texte libre             | Write weekly| Non      |                                |
| notes              | Notes                | texte libre             | Note content| Non      |                                |
| coin               | Récompense en pièces          | number >= 0         | 10        | Non       | Pièces gagnées à la finalisation ; soumis aux limites du système    |
| coin_var           | Variation de pièces        | nombre > 0 | 1        | Non       | Récompense aléatoire entre [coin, coin+coin_var] |
| exp                | Récompense en Points d'Expérience    | number >= 0          | 20        | Non       | Points d'Expérience gagnés à la finalisation ; soumis aux limites du système        |
| skills             | ID de Compétence            | tableau de nombres > 0 | 1 | Non    | Prend en charge les tableaux (p. ex., &skills=1&skills=2) |
| category           | ID de liste              | nombre >= 0 | 0 | Non  | 0 pour la liste par défaut ; listes intelligentes non prises en charge |
| frequency          | Fréquence de répétition     | integer              | 0         | Non       | 0 par défaut (une fois)<br/>0 - Une fois<br/>1 - Quotidienne<br/>N (N>1) - Tous les N jours<br/>-1 - Illimitée<br/>-3 - Ebbinghaus (requiert v1.99.1)<br/>-4 - Mensuelle<br/>-5 - Annuelle |
| weekdays           | Jours de la semaine             | `1,3,5` ou `none`    | 1,3,5     | Non       | v1.106.0+ ; identique à add_task. Omettre pour ne pas modifier ; `none` rétablit le mode quotidien ; définir frequency sur une valeur autre que 1 efface aussi weekdays |
| importance         | Niveau d'importance     | [1, 4]              | 1         | Non       | 1 par défaut                   |
| difficulty         | Niveau de difficulté     | [1, 4]              | 2         | Non       | 1 par défaut                   |
| deadline           | Date limite             | timestamp (millisecondes) | 1640995200000 | Non |                               |
| no_deadline        | Sans date limite          | true/false         | true     | Non       | v1.104.0+ ; valable uniquement pour les Tâches répétitives. Passer `&no_deadline=true` efface la date limite précise |
| remind_time        | Heure de rappel        | timestamp (millisecondes) | 1640995200000 | Non |                               |
| start_time         | Heure de début           | timestamp (millisecondes) | 1640995200000 | Non |                               |
| color              | Couleur de l'étiquette            | chaîne de couleur         | #66CCFF   | Non       | # doit être échappé en %23        |
| background_url     | URL de l'image de fond | adresse URL web      | http://example.com/bg.jpg | Non |                         |
| background_alpha   | Opacité du fond   | décimal entre [0, 1] | 0.5 | Non   |                                |
| enable_outline     | Contour du texte  | true ou false       | false      | Non       | Valable uniquement avec background_url ; ajoute un contour au texte pour une meilleure lisibilité |
| use_light_remark_text_color | Texte clair pour les notes | true ou false | false | Non | Valable uniquement avec background_url ; utilise une couleur claire pour les notes |
| item_id            | ID de l'Objet              | nombre > 0 | 1        | Non*      | item_id ou item_name requis |
| item_name          | Nom de l'Objet            | texte libre             | Treasure  | Non*      | item_id ou item_name requis |
| item_amount        | Quantité d'Objet          | [1, 99]             | 1         | Non       | 1 par défaut                   |
| items              | JSON de Récompenses d'Objets    | texte JSON           | [{"itemId":1,"amount":1}] | Non | Définit plusieurs Récompenses d'Objets |
| auto_use_item      | Utiliser l'Objet automatiquement        | true ou false        | false     | Non       |                                |
| frozen             | État de gel        | true ou false        | false     | Non       | false par défaut              |
| freeze_until       | Geler jusqu'au         | timestamp (millisecondes) | 1640995200000 | Non | Effectif uniquement lorsque frozen est true |
| coin_penalty_factor| Facteur de pénalité en pièces  | décimal entre [0, 100) | 0.5 | Non |                                |
| exp_penalty_factor | Facteur de pénalité d'expérience | décimal entre [0, 100) | 0.5 | Non |                             |
| write_feelings     | Activer les Émotions      | true ou false        | false     | Non       |                                |
| pin                | Épingler la Tâche             | true ou false        | false     | Non       |                                |
| words              | Texte de Récompense à la finalisation | texte libre           | Great job!| Non       | Texte motivationnel affiché à la finalisation de la Tâche |
| task_type        | Type de Tâche           | [0, 4]              | 0          | Non       | Requiert v1.99.1<br/>0 - Tâche normale<br/>1 - Tâche de comptage<br/>2 - Tâche négative<br/>3 - Tâche API<br/>4 - Tâche chronométrée (v1.102.0+) |
| target_times     | Nombre cible        | number > 0          | 1          | Non       | Valable uniquement lorsque task_type est 1 (tâche de comptage) |
| is_affect_shop_reward | Affecte la Récompense de la Boutique | true/false      | false    | Non       | Valable uniquement lorsque task_type est 1 (tâche de comptage) ; indique si le calcul de Récompense des Objets est affecté |
| enable_proportional_settlement | Règlement proportionnel | true/false | false | Non | v1.104.0+ ; valable uniquement lorsque task_type est 1 (tâche de comptage). Pour les tâches de comptage existantes, ce paramètre peut être passé seul pour activer ou désactiver le règlement proportionnel ; modifier ce réglage ou la configuration de Récompense peut réinitialiser ou annuler la progression déjà réglée selon les règles de l'App |
| expected_focus_minutes | Minutes de Concentration attendues | number > 0 | 25 | Non | Valable uniquement lorsque task_type est 4 (tâche chronométrée) ; 25 par défaut (v1.102.0+) |
| repeat_target_times | Nombre de fin de répétition | number > 0 | 3 | Non | Valable uniquement pour les Tâches répétitives (frequency n'est pas 0 / -1) ; si repeat_target_times et repeat_end_date sont tous deux fournis, repeat_target_times a la priorité (v1.102.0+) |
| repeat_end_date | Date de fin de répétition | timestamp (millisecondes) | 1640995200000 | Non | Valable uniquement pour les Tâches répétitives (frequency n'est pas 0 / -1) (v1.102.0+) |
| repeat_end_behavior | Comportement à la fin de la répétition | 0 ou 1 | 0 | Non | 0 - Terminer la Tâche une fois la condition atteinte<br/>1 - Geler la Tâche une fois la condition atteinte (v1.102.0+) |
| coin_set_type     | Mode de définition des pièces | L'un de :<br/>absolute<br/>relative | absolute | Non | absolute - définit coin directement à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine de coin |
| exp_set_type      | Mode de définition de l'exp | L'un de :<br/>absolute<br/>relative | absolute | Non | absolute - définit exp directement à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine de exp |

**Réponse:**

| Champ     | Type    | Description      | Exemple | Notes             |
| --------- | ------- | ---------------- | ------- | ---------------- |
| task_id   | Number  | ID de Tâche          | 1000    |                  |
| task_gid  | Number  | ID de groupe de Tâches    | 1000    |                  |

<br/>

### Task Templates

?> Introduit dans v1.102.0+

**Nom de la méthode:** task_template

**Description:** CRUD pour les modèles de Tâches.

**Exemples:**

- Lister les modèles : `lifeup://api/task_template?method=list`
- Créer à partir de paramètres : `lifeup://api/task_template?method=create&name=MyTemplate&todo=Write diary&frequency=0`
- Créer à partir d'une Tâche existante : `lifeup://api/task_template?method=create&name=MyTemplate&from_task_id=1`
- Obtenir un modèle : `lifeup://api/task_template?method=get&id=1`
- Mettre à jour le nom du modèle : `lifeup://api/task_template?method=update&id=1&name=NewName`
- Mettre à jour le contenu du modèle à partir d'une Tâche : `lifeup://api/task_template?method=update&id=1&from_task_id=1`
- Supprimer un modèle : `lifeup://api/task_template?method=delete&id=1`

| Paramètre | Signification | Valeur | Exemple | Obligatoire | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| method | Opération | list / get / create / update / delete | list | Oui | - |
| id | ID de modèle | number > 0 | 1 | Non* | Requis pour get/update/delete ; alias : template_id |
| template_id | ID de modèle | number > 0 | 1 | Non* | Alias de id |
| name | Nom du modèle | text | MyTemplate | Non* | Requis pour create ; requis pour update si from_task_id/from_task_gid n'est pas utilisé |
| from_task_id | Créer à partir de l'ID de Tâche | number > 0 | 1 | Non | Pour create/update |
| from_task_gid | Créer à partir de l'ID de groupe de Tâches | number > 0 | 1 | Non | Pour create/update |
| todo | Contenu de la Tâche | text | Write diary | Non* | Requis pour create si from_task_id/from_task_gid n'est pas utilisé |
| notes | Notes | text | Notes | Non | Vide par défaut |
| category | ID de liste | number >= 0 | 0 | Non | Alias : category_id |
| category_id | ID de liste | number >= 0 | 0 | Non | Alias de category |
| frequency | Fréquence de répétition | integer | 0 | Non | Identique à add_task |
| weekdays | Jours de la semaine | `1,3,5` | 1,3,5 | Non | v1.106.0+ ; identique à add_task ; create rejette `none` |
| importance | Niveau d'importance | [1, 4] | 1 | Non | - |
| difficulty | Niveau de difficulté | [1, 4] | 1 | Non | - |
| coin | Récompense en pièces | number | 10 | Non | - |
| coin_var | Variation de pièces | number | 1 | Non | - |
| exp | Récompense en Points d'Expérience | number | 100 | Non | - |
| skills | ID de Compétence | array params | 1 | Non | Prend en charge les tableaux (p. ex., &skills=1&skills=2) |
| skill_ids | ID de Compétence | JSON array ou liste séparée par des virgules | [1,2] | Non | Alternative à skills |
| deadline | Date limite | timestamp (millisecondes) | 1640995200000 | Non | - |
| start_time | Heure de début | timestamp (millisecondes) | 1640995200000 | Non | - |
| remind_time | Heure de rappel | timestamp (millisecondes) | 1640995200000 | Non | - |
| words | Texte de Récompense à la finalisation | text | Great job! | Non | - |
| task_type | Type de Tâche | [0, 4] | 0 | Non | 0 - Normal<br/>1 - Comptage<br/>2 - Négative<br/>3 - API<br/>4 - Chronométrée |
| target_times | Nombre cible | number > 0 | 10 | Non | Valable uniquement lorsque task_type est 1 (tâche de comptage) |
| is_affect_shop_reward | Affecte la Récompense de la Boutique | true / false | false | Non | Valable uniquement lorsque task_type est 1 (tâche de comptage) |
| enable_proportional_settlement | Règlement proportionnel | true / false | false | Non | v1.104.0+ ; valable uniquement lorsque task_type est 1 (tâche de comptage). Les Tâches créées à partir du modèle conservent ce réglage de règlement de comptage |
| expected_focus_minutes | Minutes de Concentration attendues | number > 0 | 25 | Non | Valable uniquement lorsque task_type est 4 (tâche chronométrée) |
| repeat_end_mode | Mode de fin de répétition | 0 ou 1 | 0 | Non | Valable uniquement pour les Tâches répétitives (frequency n'est pas 0 / -1)<br/>0 - Terminer par nombre<br/>1 - Terminer par date |
| repeat_target_times | Nombre de fin de répétition | number > 0 | 3 | Non | Utilisé lorsque repeat_end_mode=0 (ou inféré par ce champ) |
| repeat_end_date | Date de fin de répétition | timestamp (millisecondes) | 1640995200000 | Non | Utilisé lorsque repeat_end_mode=1 (ou inféré par ce champ) |
| repeat_end_behavior | Comportement à la fin de la répétition | 0 ou 1 | 0 | Non | 0 - Terminer<br/>1 - Geler |

**Retour:**

| Champ | Signification | Type | Notes |
| ----- | ------- | ---- | ----- |
| templates | liste de modèles (chaîne JSON) | text | Uniquement pour method=list |
| count | nombre de modèles | number | Uniquement pour method=list |
| template | détail du modèle (chaîne JSON) | text | Uniquement pour method=get |
| id | ID de modèle | number | Pour get/create/update/delete |
| name | nom du modèle | text | Pour get/create/update |
| success | succès ou non | true / false | Pour create/update/delete |

<br/>

### History Task Operation

?> Requiert v1.98.0+

**Nom de la méthode:** history_operation

**Description:** Opère sur les Tâches finalisées, abandonnées ou expirées

**Exemples:**

- Supprimer une Tâche de l'historique : [lifeup://api/history_operation?id=1&operation=delete](lifeup://api/history_operation?id=1&operation=delete)
- Marquer une Tâche comme abandonnée : [lifeup://api/history_operation?id=1&operation=set_to_give_up](lifeup://api/history_operation?id=1&operation=set_to_give_up)
- Redémarrer une Tâche : [lifeup://api/history_operation?id=1&operation=restart](lifeup://api/history_operation?id=1&operation=restart)

!> Cette API ne s'applique qu'aux Tâches non en cours (finalisées, abandonnées ou expirées)

| Paramètre      | Signification           | Valeurs               | Exemple    | Obligatoire | Notes                           |
| ------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id            | ID de Tâche           | nombre > 0 | 1         | Oui      | ID de la Tâche de l'historique          |
| operation     | Type d'opération    | L'un de :<br/>delete<br/>complete<br/>undo_complete<br/>set_to_give_up<br/>set_to_overdue<br/>edit_completed_time<br/>restart | delete | Oui | delete - Supprimer la Tâche<br/>complete - Marquer comme finalisée<br/>undo_complete - Annuler la finalisation<br/>set_to_give_up - Marquer comme abandonnée<br/>set_to_overdue - Marquer comme expirée<br/>edit_completed_time - Modifier l'heure de finalisation<br/>restart - Redémarrer la Tâche |
| completed_time | Heure de finalisation   | timestamp (millisecondes) | 1640995200000 | Non* | Requis uniquement lorsque operation est edit_completed_time |

**Réponse:**

| Champ    | Type    | Description    | Exemple | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| task_id  | Number  | ID de Tâche        | 1000    | ID de la Tâche concernée  |

<br/>

### Shop Settings

**Nom de la méthode:** shop_settings

**Instructions:** Ajuste divers paramètres de la Boutique

**Exemple:**

- Définir le taux d'intérêt du distributeur automatique à 0,01 % : [lifeup://api/shop_settings?key=atm_interest&value=0.01](lifeup://api/shop_settings?key=atm_interest&value=0.01)
- Augmenter le taux d'intérêt de 0,01 % par clic : [lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative](lifeup://api/shop_settings?key=atm_interest&value=0.01&set_type=relative)

| Paramètre | Signification              | Type | Exemple | Obligatoire | Notes |
| --------- | -------------------- | ---- | ------- | -------- | ----- |
| key       | type                 | Actuellement seulement :<br/>atm_interest<br/>credit_interest<br/>line_of_credit<br/>discount_rate_for_returning<br/>atm_balance | atm_interest | oui | atm_interest - taux journalier du distributeur automatique<br/>credit_interest - taux journalier du prêt<br/>line_of_credit - montant empruntable<br/>discount_rate_for_returning - échelle de remise au retour<br/>atm_balance - définir le solde du distributeur automatique |
| value     | valeur numérique        | nombre décimal ou entier | 0.01 | oui | chaque key accepte des plages différentes<br/>Par exemple, les soldes du distributeur automatique n'acceptent pas les décimales |
| set_type  | Mode de définition de la valeur | L'un des suivants :<br/>absolute<br/>relative | absolute | non | absolute - valeur absolue, c'est-à-dire définir directement la cible à la valeur<br/>relative - valeur relative, ajoute ou soustrait par rapport à la valeur d'origine |
| silent    | Exécuter silencieusement (sans afficher l'interface) | Boolean | false | Non | Pris en charge à partir de v1.93.0-beta01 (502)<br/>false par défaut, ce qui affiche les invites de l'interface |

<br/>


### Jump

**Nom de la méthode:** goto

**Description:** Ouvre une page dans `LifeUp`

**Exemple:** [lifeup://api/goto?page=lab](lifeup://api/goto?page=lab)

**Explication:** Ouvre la page Labos

| Paramètre | Signification | Valeur | Exemple | Obligatoire | Notes |
| --------- | ------- | ----- | ------- | -------- | ----- |
| page | page | L'une des valeurs suivantes :<br/>main<br/>setting<br/>about<br/>pomodoro<br/>feelings<br/>achievement<br/>history<br/>add_task<br/>add_achievement<br/>add_achievement_cate<br/>exp<br/>coin<br/>backup<br/>add_item<br/>lab<br/>custom_attributes<br/>pomodoro_record<br/>synthesis<br/>pic_manage<br/>purchase_dialog<br/>task_detail<br/>dlc<br/>new_default<br/>use_item_dialog<br/>achievement_list<br/>user_achievement | lab | oui | `purchase_dialog` ouvre la fenêtre d'achat<br/> `use_item_dialog` ouvre la fenêtre d'utilisation d'Objet<br/>Les autres valeurs ouvrent des pages principales spécifiques |

#### 1. Jump to the item purchase/use pop-up window

Lorsque le paramètre `page` vaut `purchase_dialog` ou `use_item_dialog`, vous pouvez indiquer l'ID de l'Objet :

Par exemple : `lifeup://api/goto?page=purchase_dialog&id=1`

| Paramètre | Signification | Valeur            | Exemple | Obligatoire | Notes   |
| --------- | ------- | ---------------- | ------- | -------- | ------- |
| id        | ID de l'Objet | Entier positif | 1       | Oui      | ID de l'Objet |

<br/>

#### 2. Jump to the subpage of the home page

Lorsque le paramètre `page` vaut `main`, vous pouvez aussi indiquer la sous-page :

Par exemple, ouvrir la page Boutique : `lifeup://api/goto?page=main&sub_page=shop`

| Paramètre   | Signification       | Valeur | Exemple | Obligatoire | Notes  |
| ----------- | ------------- | ----- | ------- | -------- | ------ |
| sub_page    | nom de la sous-page | L'une de :<br/>todo<br/>shop<br/>inventory<br/>achievement<br/>status<br/>me<br/>statistic<br/>pomodoro<br/>feelings<br/>world | shop    | non       |      |
| category_id | ID de liste       | nombre | 0      | non       | Si `sub_page` est une page de liste, vous pouvez indiquer l'ID de liste cible. <br/>Par exemple la liste d'Objets de la Boutique, la liste de l'Inventaire ou la liste de Tâches. |

<br/>

#### 3. Jump to task details

Lorsque le paramètre `page` vaut `task_detail`, vous pouvez indiquer l'ID de la Tâche :

Par exemple, ouvrir la page de détail de la Tâche 53 : `lifeup://api/goto?page=task_detail&task_id=53`

| Paramètre | Signification       | Valeur         | Exemple      | Obligatoire | Notes |
| --------- | ------------- | ------------- | ------------ | -------- | ----- |
| task_id   | ID de Tâche       | ID de Tâche       | 53           | Non*      | ID de Tâche ; pour une Tâche répétitive, l'ID est mis à jour à chaque répétition. |
| task_gid  | ID de groupe de Tâches | ID de groupe de Tâches | 3            | Non*      | ID de groupe de Tâches |
| task_name | nom de la Tâche     | chaîne        | get up early | Non*      | nom de la Tâche ; recherche floue sur une seule correspondance. |

**Avis:**

1. Un seul des trois paramètres suffit.
    - Si plusieurs sont fournis en même temps, un ordre de priorité interne s'applique. Ce comportement n'est pas défini ; l'App ne garantit pas l'ordre.

<br/>

#### 4. Jump to new achievement page

Lorsque le paramètre `page` vaut `add_achievement`, vous devez **obligatoirement** indiquer l'ID de catégorie :

Par exemple, ouvrir la page de création de Succès avec la catégorie 1 : `lifeup://api/goto?page=add_achievement&category_id=1`

| Paramètre    | Signification         | Valeur         | Exemple | Obligatoire | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID de catégorie de Succès | ID de catégorie de Succès | 1       | Oui      |        |

#### 5. Jump to specific achievement category page

Lorsque le paramètre `page` vaut `user_achievement`, vous devez **obligatoirement** indiquer l'ID de catégorie :

Par exemple, ouvrir la page de catégorie de Succès 1 : `lifeup://api/goto?page=user_achievement&category_id=1`

| Paramètre    | Signification         | Valeur         | Exemple | Obligatoire | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID de catégorie de Succès | ID de catégorie de Succès | 1       | Oui      |        |

#### 6. Jump to specific synthesis category page

Lorsque le paramètre `page` vaut `synthesis`, vous pouvez optionnellement indiquer l'ID de catégorie :

Par exemple, ouvrir la page de catégorie de Synthèse 1 : `lifeup://api/goto?page=synthesis&category_id=1`

| Paramètre    | Signification         | Valeur         | Exemple | Obligatoire | Notes  |
| ------------ | --------------- | ------------- | ------- | -------- | ------ |
| category_id  | ID de catégorie de Synthèse | ID de catégorie de Synthèse | 1       | Non       |        |

Vous pouvez aussi ouvrir la page de Synthèse avec un filtre (v1.102.0+) :

Par exemple, filtrer par l'Objet produit d'ID 1 : `lifeup://api/goto?page=synthesis&filter_type=product&filter_item_id=1&filter_item_name=Gem`

| Paramètre        | Signification           | Valeur | Exemple | Obligatoire | Notes |
| --------------- | ----------------- | ----- | ------- | -------- | ----- |
| filter_type     | Type de filtre       | product / ingredient / related | product | Non* | Requiert filter_item_id |
| filter_item_id  | ID de l'Objet filtré    | nombre > 0 | 1 | Non* | Requiert filter_type |
| filter_item_name| Nom de l'Objet filtré  | texte | Gem | Non | Optionnel ; utilisé pour l'affichage |

### Shop

#### Adding Items

?> Certains champs comme `effects` requièrent v1.98.0+

**Nom de la méthode:** add_item

**Description:** Crée un Objet de Boutique avec des propriétés personnalisables, y compris les limites d'achat et les effets d'utilisation.

**Exemple:** [lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕](lifeup://api/add_item?name=Take a 10-minute break&desc=Go and take a short break!&price=10&action_text=rest&icon=☕)

| Paramètre        | Signification                | Valeurs               | Exemple       | Obligatoire | Notes                           |
| --------------- | --------------------- | -------------------- | ------------- | -------- | ------------------------------- |
| name            | Nom de l'Objet             | texte libre             | 10 minute break | Oui    |                                 |
| desc            | Description           | texte libre             | Take a break  | Non       |                                 |
| icon            | Icône                  | emoji, URL http(s) ou nom d'exemple intégré | ☕ | Non | Enregistré sous `emoji_*.webp`, `lifeup_sample_*` ou URL. L'emoji du nom ne définit pas l'icône. |
| price           | Prix                 | [0, 999999]         | 10            | Non       | 0 par défaut                    |
| stock_number    | Quantité en stock        | [-1, 99999]         | -1            | Non       | -1 signifie illimité              |
| action_text     | Texte du bouton d'action    | texte libre             | rest          | Non       |                                 |
| disable_purchase| Désactiver l'achat      | true ou false        | false         | Non       | false par défaut                |
| disable_use     | Désactiver l'utilisation           | true ou false        | false         | Non       | false par défaut                |
| category        | ID de catégorie           | nombre >= 0 | 0 | Non    | 0 pour la catégorie par défaut          |
| order           | Ordre d'affichage         | entier              | 1             | Non       | Position dans la catégorie            |
| purchase_limit  | Règles de restriction     | texte JSON            | Voir [Structure des limites d'achat](#3-purchase-limit-structure) | Non | Restrictions d'achat/utilisation configurables |
| limit_scope     | Portée de restriction     | purchase / use / both | purchase | Non | Effectif uniquement lorsque `purchase_limit` n'est pas vide ; `purchase` par défaut |
| effects         | Effets d'utilisation           | texte JSON            | Voir [Structure des effets d'Objet](#4-item-effects-structure) | Non | Effets à l'utilisation de l'Objet |
| own_number      | Quantité possédée initiale | entier             | 0             | Non       | Définit la quantité initiale dans l'Inventaire  |
| unlist          | Masquer de la Boutique        | true ou false        | false         | Non       | false par défaut                |

**Données de retour:**

| Champ    | Type    | Description    | Exemple | Notes                    |
| -------- | ------- | -------------- | ------- | ------------------------ |
| item_id  | Number  | ID de l'Objet        | 1000    | ID de l'Objet créé   |

!> Le paramètre effects remplace disable_use. Si vous définissez effects pour indiquer un Objet inutilisable, disable_use est ignoré.

<br/>

#### Edit Item

?> Requiert v1.98.0+

**Nom de la méthode:** item

**Description:** Modifie des Objets existants, y compris le prix, le stock, les effets et d'autres propriétés

**Exemples:**

- Ajuster le prix : [lifeup://api/item?id=1&set_price=1&set_price_type=relative](lifeup://api/item?id=1&set_price=1&set_price_type=relative)
- Modifier les effets : [lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1](lifeup://api/item?effects=%5B%7B%22type%22%3A2%2C%22info%22%3A%7B%22min%22%3A100%2C%22max%22%3A200%7D%7D%5D&id=1)
  - Le contenu décodé du paramètre effects est : `[{"type":2,"info":{"min":100,"max":200}}]`

| Paramètre         | Signification             | Valeurs               | Exemple   | Obligatoire | Notes                           |
| ---------------- | ------------------- | -------------------- | --------- | -------- | ------------------------------- |
| id               | ID de l'Objet             | nombre > 0| 1         | Non*      | id ou name requis      |
| name             | Nom de l'Objet           | texte libre             | Treasure  | Non*      | Pour la recherche floue, pas pour renommer  |
| set_name         | Définir le nom            | texte libre             | Treasure  | Non       | Ne peut pas être vide                 |
| set_desc         | Définir la description     | texte libre             | Get gift  | Non       |                                |
| set_icon         | Définir l'icône            | emoji, URL http(s) ou nom d'exemple intégré | ☕ | Non | Identique à `icon`. Les valeurs non prises en charge renvoient `unsupported_parameter`. |
| set_price        | Ajuster le prix        | entier              | 1         | Non       |                                |
| set_price_type   | Mode d'ajustement du prix | absolute ou relative | relative  | Non       | absolute - définit directement<br/>relative - ajoute ou soustrait |
| own_number       | Ajuster la quantité possédée| entier             | 1         | Non       | Accepte les valeurs négatives en mode relative |
| own_number_type  | Mode d'ajustement de la quantité possédée| absolute ou relative| relative  | Non       | absolute - définit directement<br/>relative - ajoute ou soustrait |
| stock_number     | Ajuster le stock        | [-1, 99999]         | 1         | Non       | -1 signifie stock illimité        |
| stock_number_type| Mode d'ajustement du stock | absolute ou relative | relative  | Non       | absolute - définit directement<br/>relative - ajoute ou soustrait |
| disable_purchase | Désactiver l'achat    | true ou false        | false     | Non       | false par défaut              |
| disable_use      | Désactiver l'utilisation         | true ou false        | false     | Non       | false par défaut              |
| action_text      | Texte du bouton d'utilisation     | texte libre             | Use       | Non       |                                |
| title_color_string| Couleur du titre        | chaîne de couleur         | #66CCFF   | Non       | # doit être échappé en %23<br/>Une valeur vide rétablit la valeur par défaut |
| effects          | Effets d'utilisation         | texte JSON            | Voir [Structure des effets d'Objet](#4-item-effects-structure) | Non | Définit les effets d'utilisation de l'Objet |
| purchase_limit   | Règles de restriction   | texte JSON            | Voir [Structure des limites d'achat](#3-purchase-limit-structure) | Non | Passer `null` pour effacer toutes les restrictions |
| limit_scope      | Portée de restriction   | purchase / use / both | purchase | Non | Mis à jour uniquement lorsque ce champ est fourni ; effacé automatiquement lorsque `purchase_limit` devient vide |
| category_id      | ID de catégorie         | nombre >= 0          | 1         | Non       | 0 pour la catégorie par défaut         |
| order            | Ordre d'affichage       | entier              | 1         | Non       | Position dans la catégorie           |
| unlist           | Retirer de la Boutique    | true ou false        | false     | Non       | false par défaut              |

!> Il faut fournir id ou name pour localiser l'Objet à modifier

<br/>

#### Adjust the Loot Box effect

**Nom de la méthode:** loot_box

**Description:** Modifie l'effet de Boîte de butin de l'Objet coffre indiqué ; permet d'ajuster la probabilité, le nombre de Récompenses et d'ajouter du contenu. (La suppression n'est pas prise en charge pour l'instant.)

**Exemple:** <a href="lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false">lifeup://api/loot_box?name=Coin loot box&sub_name=A big bag of coins&set_type=relative&probability=1&fixed=false</a>

**Explication:** Augmente de 1 point la proportion du [grand] sac de pièces d'or dans la boîte de pièces d'or.

| Paramètre   | Signification                               | Type                                                    | Exemple        | Obligatoire | Notes                                                        |
| ----------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id          | ID de l'Objet                               | nombre > 0                                 | 1              | non*      | Voir « Connaissances de base - ID de données LifeUp » ci-dessus pour l'obtention |
| name        | nom de l'Objet                             | texte libre                                                | Treasure chest | non*      | Lorsque l'ID est inconnu, recherche floue du produit, pas de modification du nom |
| sub_id      | ID de l'Objet contenu                       | nombre > 0                                 | 1              | non*      | ID du contenu du coffre                                         |
| sub_name    | nom de l'Objet contenu                     | texte libre                                                | Get a gift     | non*      | Recherche floue lorsque l'ID du contenu de la boîte est inconnu |
| set_type    | mode d'ajustement (absolute/relative) | l'une des valeurs suivantes : <br/>absolute<br/>relative | relative       | non       | absolute - valeur absolue, définit directement la cible<br/>relative - valeur relative, ajoute ou soustrait par rapport à la valeur d'origine |
| amount      | quantité de l'Objet contenu                | nombre                                                  | 1              | non       | nombre de Récompenses pour un seul Objet                          |
| probability | probabilité de l'Objet contenu       | nombre                                                  | 1              | non       | -                                                            |
| fixed       | Récompense fixe ou non          | boolean                                                 | true/false     | non       | -                                                            |

**Avis:**

1. Pour rechercher un produit, il faut fournir id ou name.
1. Pour rechercher un contenu, il faut fournir sub_id ou sub_name.
1. `name` et `sub_name` tentent d'abord une correspondance exacte, puis une recherche floue.
1. L'API héritée `loot_box` conserve son comportement de compatibilité : si le même Objet contenu apparaît plusieurs fois avec des quantités différentes, la première entrée correspondante est modifiée et `sub_amount` n'est pas utilisé pour lever l'ambiguïté. Utilisez `loot_box/v2` si vous avez besoin de modification, suppression ou fusion par quantité.

<br/>

#### Adjust the Loot Box effect (v2)

?> Cette API a été introduite dans la version v1.104.2.

**Nom de la méthode:** loot_box/v2

**Description:** Version améliorée de l'API loot_box. Modifie l'effet de Boîte de butin de l'Objet coffre indiqué ; permet d'ajuster la probabilité, le nombre de Récompenses, d'ajouter du contenu et de **supprimer du contenu**.

**Améliorations par rapport à v1 :**
- **`sub_amount` pour une correspondance précise** : Lorsque la boîte contient plusieurs entrées du même Objet avec des quantités différentes (p. ex. A x1 50 %, A x2 30 %), utilisez `sub_amount` pour cibler une entrée précise. Valeur par défaut : `1`. Si aucune entrée correspondante n'est trouvée, LifeUp recherche l'Objet via `sub_id` / `sub_name` et ajoute une nouvelle entrée ; si la requête est une suppression `amount=0`, aucune nouvelle entrée n'est ajoutée.
- **`set_type` indépendant** : `amount_set_type` et `probability_set_type` peuvent être contrôlés indépendamment. Le `set_type` global sert de valeur par défaut.
- **Prise en charge de la suppression** : Définir `amount=0` avec `amount_set_type=absolute` (ou un résultat `<=0` en mode `relative`) supprime l'entrée correspondante.
- **Fusion des doublons** : Si la modification de `amount` créerait un doublon d'une entrée existante avec le même Objet et la même quantité dans la même boîte, LifeUp fusionne dans l'entrée existante et continue d'appliquer les valeurs `probability` / `fixed` de la requête.

**Exemple:** <a href="lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10">lifeup://api/loot_box/v2?name=Coin loot box&sub_name=A big bag of coins&sub_amount=2&probability_set_type=relative&probability=10</a>

**Explication:** Augmente de 10 points la probabilité du [grand] sac de pièces d'or (x2) dans la boîte de pièces d'or.

| Paramètre              | Signification                               | Type                                                    | Exemple        | Obligatoire | Notes                                                        |
| ---------------------- | ------------------------------------- | ------------------------------------------------------- | -------------- | -------- | ------------------------------------------------------------ |
| id                     | ID de l'Objet                               | nombre > 0                                 | 1              | non*      | Voir « Connaissances de base - ID de données LifeUp » ci-dessus pour l'obtention |
| name                   | nom de l'Objet                             | texte libre                                                | Treasure chest | non*      | Lorsque l'ID est inconnu, recherche floue du produit, pas de modification du nom |
| sub_id                 | ID de l'Objet contenu                       | nombre > 0                                 | 1              | non*      | ID du contenu du coffre. Si sub_id et sub_name sont tous deux fournis, sub_id a la priorité |
| sub_name               | nom de l'Objet contenu                     | texte libre                                                | Get a gift     | non*      | Recherche floue lorsque l'ID du contenu de la boîte est inconnu |
| sub_amount             | quantité de l'Objet contenu pour la correspondance      | nombre                                                  | 2              | non       | Permet de cibler précisément une entrée avec cette quantité. Minimum `1`, défaut `1`. Si aucune correspondance n'est trouvée et que ce n'est pas une requête de suppression, une nouvelle entrée est ajoutée. |
| set_type               | mode d'ajustement global              | l'une de : `absolute` / `relative`                         | relative       | non       | Valeur par défaut pour `amount_set_type` et `probability_set_type` si non spécifié |
| amount_set_type        | mode d'ajustement pour amount          | l'une de : `absolute` / `relative`                         | relative       | non       | Remplace `set_type` pour le champ amount                    |
| probability_set_type   | mode d'ajustement pour probability     | l'une de : `absolute` / `relative`                         | absolute       | non       | Remplace `set_type` pour le champ probability               |
| amount                 | quantité de l'Objet contenu                | nombre                                                  | 1              | non       | nombre de Récompenses pour un seul Objet. `0` (absolute) ou un résultat calculé `<=0` (relative) supprime l'entrée |
| probability            | probabilité de l'Objet contenu       | nombre                                                  | 1              | non       | -                                                            |
| fixed                  | Récompense fixe ou non          | boolean                                                 | true/false     | non       | -                                                            |
| query                  | lister le contenu de la boîte                     | true ou false                                           | true           | non       | v1.105.1+. Renvoie uniquement le JSON de l'Objet ; sub_id / sub_name non requis |

**Avis:**

1. Pour rechercher un produit, il faut fournir id ou name.
1. Pour rechercher un contenu, il faut fournir sub_id ou sub_name. Utilisez `query=true` pour lister le contenu sans sub_id / sub_name.
1. Si `sub_id` et `sub_name` sont tous deux fournis, `sub_id` a la priorité. `sub_name` n'est utilisé que lorsqu'aucun `sub_id` valide n'est fourni.
1. `name` et `sub_name` tentent d'abord une correspondance exacte, puis une recherche floue.
1. `sub_amount` vaut `1` par défaut. Lorsque la boîte contient plusieurs entrées du même Objet avec des quantités différentes, indiquez `sub_amount` pour cibler une entrée précise. Si aucune correspondance n'est trouvée et que ce n'est pas une requête de suppression, une nouvelle entrée avec `amount=sub_amount` est ajoutée.
1. Pour supprimer une entrée, définissez `amount=0` avec `amount_set_type=absolute`, ou utilisez `amount_set_type=relative` avec une valeur négative qui amène le total à `<=0`. La suppression ne s'applique qu'aux entrées correspondantes ; si aucune entrée existante ne correspond, `amount=0` n'ajoute pas de nouvelle entrée.
1. Si la modification de `amount` d'une entrée créerait un doublon d'une entrée existante avec le même Objet et la même quantité dans la même boîte, LifeUp fusionne dans l'entrée existante et continue d'appliquer les valeurs `probability` / `fixed` de la requête.
1. Lorsque la suppression laisse la boîte vide, l'effet de Boîte de butin entier est supprimé de façon réversible (l'Objet lui-même est conservé et vous pouvez réajouter des entrées de Boîte de butin plus tard).

<br/>

#### Use items

?> Cette API a été introduite dans la version v1.93.0-beta01 (502).

**Nom de la méthode:** use_item

**Description:** Utilise un Objet spécifié.

**Exemple:**

- Ouvrir une boîte de pièces : [lifeup://api/use_item?name=coin_box&use_times=1](lifeup://api/use_item?name=coin_box&use_times=1)

| Paramètre | Signification     | Type                    | Exemple  | Obligatoire | Notes                                                        |
| --------- | ----------- | ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| id        | ID de l'Objet     | nombre > 0 | 1        | Non*      | Pour obtenir l'ID de l'Objet, voir la section « Connaissances de base - ID de données LifeUp » |
| name      | Nom de l'Objet   | texte libre                | coin_box | Non*      | Lorsque l'ID est inconnu ; effectue une recherche floue d'Objets      |
| use_times | Nombre d'utilisations | nombre > 0 | 1        | Non       | 1 par défaut<br/>Pour les Objets ordinaires ou l'ouverture de boîtes, correspond à la quantité de l'Objet<br/>Pour les Objets de Synthèse simples, cette valeur correspond à la « quantité de Synthèse » plutôt qu'au nombre d'Objets consommés |

**Retour:**

!> Cette API peut échouer pour diverses raisons ; les valeurs de retour peuvent inclure la cause précise de l'échec.

| Paramètre | Signification            | Type     | Exemple          | Obligatoire | Notes                                                        |
| --------- | ------------------ | -------- | ---------------- | -------- | ------------------------------------------------------------ |
| result    | Code de résultat        | nombre | 0                | Oui      | 0 - Utilisation réussie<br/>1 - Exception de base de données<br/>2 - Restriction de Points d'Expérience insuffisants<br/>3 - Objet introuvable<br/>4 - Conflit de compte à rebours en cours<br/>5 - Inventaire insuffisant<br/>6 - Objet inutilisable<br/>7 - Limite de pièces<br/>8 - Limite de stock cible<br/>9 - Restriction de niveau d'Attribut<br/>10 - Restriction horaire<br/>11 - Restriction de quantité d'Objets possédés<br/>12 - Restriction de finalisation de Tâche<br/>13 - Restriction de déverrouillage de Succès<br/>14 - Restriction de quantité par période<br/>15 - Restriction de cycle de Tâche terminé |
| desc      | Description du résultat | Texte     | RunningCountDown | Oui      |                                                              |

<br/>

### ATM

**⚠ Disponible uniquement à partir de v1.91+**

> Les opérations de dépôt et de retrait ici sont vérifiées.
>
> Si vous devez ajuster directement le solde du distributeur automatique, consultez l'interface « Shop Settings » ci-dessus.

#### Deposit

**Nom de la méthode:** deposit

**Description:** Le dépôt est vérifié pour sa validité (solde de pièces suffisant ou non).

**Exemple:**[lifeup://api/deposit?amount=500](lifeup://api/deposit?amount=500)

**Explication:** Dépose 500 pièces.

| Paramètre | Signification        | Type                    | Exemple | Obligatoire | Notes |
| --------- | -------------- | ----------------------- | ------- | -------- | ----- |
| amount    | montant du dépôt | nombre > 0 | 100     | oui      | -     |

**Retour:**

| Paramètre | Signification                              | Type              | Exemple | Obligatoire | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Succès ou non de l'opération | `true` ou `false` | true    | oui      | -     |

<br/>

#### Withdraw

**Nom de la méthode:** withdraw

**Description:** Le retrait est vérifié pour sa validité (solde du distributeur automatique suffisant ou non).

**Exemple:** [lifeup://api/withdraw?amount=500](lifeup://api/withdraw?amount=500)

**Explication:** Retire 500 pièces.

| Paramètre | Signification           | Type                    | Exemple | Obligatoire | Notes |
| --------- | ----------------- | ----------------------- | ------- | -------- | ----- |
| amount    | montant du retrait | nombre > 0 | 100     | oui      | -     |

**Retour:**

| Paramètre | Signification                              | Type              | Exemple | Obligatoire | Notes |
| --------- | ------------------------------------ | ----------------- | ------- | -------- | ----- |
| result    | Succès ou non de l'opération | `true` ou `false` | true    | oui      | -     |

<br/>

### Pomodoro Timer

**Nom de la méthode:** pomodoro_timer

**Description:** Contrôle le minuteur Pomodoro réel en compte à rebours ou en comptage progressif dans LifeUp. Cette API démarre
la même session de minuteur que l'interface de l'App ; elle n'ajoute pas directement d'enregistrements Pomodoro ni de tomates.

**Exemples:**

- Démarrer ou reprendre le compte à rebours de travail par défaut :
  [lifeup://api/pomodoro_timer?action=start&mode=countdown](lifeup://api/pomodoro_timer?action=start&mode=countdown)
- Démarrer le comptage progressif et sélectionner la Tâche 101 :
  [lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101](lifeup://api/pomodoro_timer?action=start&mode=count_up&task_id=101)
- Mettre en pause le compte à rebours actif :
  [lifeup://api/pomodoro_timer?action=pause&mode=countdown](lifeup://api/pomodoro_timer?action=pause&mode=countdown)
- Abandonner et réinitialiser le cycle Pomodoro :
  [lifeup://api/pomodoro_timer?action=abandon&mode=countdown](lifeup://api/pomodoro_timer?action=abandon&mode=countdown)
- Passer l'étape Pomodoro en cours :
  [lifeup://api/pomodoro_timer?action=skip](lifeup://api/pomodoro_timer?action=skip)
- Clôturer un comptage progressif sans recevoir de Récompenses en tomates :
  [lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false](lifeup://api/pomodoro_timer?action=complete&mode=count_up&receive_reward=false)
- Interroger les deux modes de minuteur :
  [lifeup://api/pomodoro_timer?action=status](lifeup://api/pomodoro_timer?action=status)

**Paramètres:**

| Paramètre | Signification | Type / valeurs | Obligatoire | Notes |
| --------- | ------- | ------------- | -------- | ----- |
| action | Opération | `start`, `pause`, `abandon`, `skip`, `complete`, `select_task`, `status` | oui | - |
| mode | Mode du minuteur | `countdown`, `count_up` | pour `start`, `pause`, `abandon` et `complete` | `skip` cible toujours le compte à rebours. |
| stage | Étape du compte à rebours | `work`, `short_break`, `long_break` | non | Valable uniquement avec `mode=countdown`. Si omis, l'étape canonique active, en pause ou suivante est utilisée ; un nouveau cycle démarre avec `work`. |
| receive_reward | Recevoir ou non des Récompenses en tomates | `true` ou `false` | pour `complete` | Booléen strict. `complete` ne prend en charge que `mode=count_up`. |
| task_id | ID de Tâche | entier positif | non | Ne peut pas être combiné avec `task_gid` ou `task_name`. |
| task_gid | ID de groupe de Tâches | entier positif | non | Peut être combiné avec `task_name` pour affiner la correspondance. |
| task_name | Nom de la Tâche | texte | non | La correspondance exacte est privilégiée, avec recherche floue en secours. |
| clear_task | Effacer la Tâche du minuteur | `true` ou `false` | non | `true` ne peut pas être combiné avec un localisateur de Tâche. |

`select_task` requiert un localisateur de Tâche ou `clear_task=true`. `start` peut inclure les mêmes
paramètres de sélection de Tâche. Les paramètres de durée personnalisée ne sont pas pris en charge : les comptes à rebours utilisent
la durée par défaut actuelle ou la durée Pomodoro de la Tâche sélectionnée.

`abandon&mode=countdown` équivaut à l'action de gauche de l'App : il abandonne l'étape en cours,
réinitialise le cycle Pomodoro et revient à une étape de travail arrêtée. `skip` équivaut à l'action
de droite : il fait passer le travail à une pause courte/longue, ou une pause au travail, sans démarrer automatiquement
l'étape suivante. Chaque appel à `skip` est une action réelle et non idempotente ; les appelants ne doivent pas le réessayer
automatiquement.

`complete&mode=count_up` clôt la session réelle de comptage progressif. Les sessions de moins de 30 secondes sont
consommées sans créer d'enregistrement. Avec `receive_reward=false`, un enregistrement qui atteint le seuil
est quand même enregistré comme abandonné mais n'accorde aucune tomate.

**Règles de changement de Tâche:**

- Un compte à rebours de travail en cours refuse les changements de Tâche.
- Un comptage progressif en cours autorise les changements de Tâche et met à jour sa notification.
- Un compte à rebours en pause autorise les changements de Tâche et conserve le temps écoulé tout en recalculant sa durée totale
  à partir des paramètres de la nouvelle Tâche.

**Valeurs de retour en cas de succès:**

| Paramètre | Signification | Type |
| --------- | ------- | ---- |
| api_result | Succès ou non de l'appel API | boolean |
| applied | Cet appel a-t-il modifié l'état du minuteur | boolean |
| mode | Mode de minuteur cible ou actuellement sélectionné | `countdown` ou `count_up` |
| state | État de `mode` | `running`, `paused` ou `stopped` |
| selected_task_id | ID de Tâche actuel du minuteur, ou `0` | number |
| can_start_in_background | Android autorise-t-il actuellement un démarrage de minuteur en arrière-plan | boolean |
| countdown_state | État canonique du compte à rebours | `running`, `paused` ou `stopped` |
| countdown_phase | Phase du cycle de compte à rebours | `idle`, `running`, `paused`, `completing`, `completed` ou `cancelled` |
| countdown_stage | Étape canonique du compte à rebours | `work`, `short_break` ou `long_break` |
| countdown_session_id | ID de session canonique du compte à rebours | texte ou null |
| countdown_total_millis | Durée totale du compte à rebours | millisecondes |
| countdown_remaining_millis | Durée restante du compte à rebours | millisecondes |
| count_up_state | État canonique du comptage progressif | `running`, `paused` ou `stopped` |
| count_up_elapsed_millis | Durée écoulée du comptage progressif | millisecondes |
| battery_optimization_ignored | LifeUp est-il exempté de l'optimisation de batterie | boolean |

Les réponses réussies à `complete` contiennent en plus `record_created`, `reward_tomatoes` et
`settled_elapsed_millis`.

Les appels répétés à `start`, `pause` ou `abandon` qui correspondent déjà à l'état demandé réussissent avec
`applied=false`. Les appels mutants ne fournissent pas de déduplication de nouvelle tentative interprocessus.

**Erreurs:**

Les échecs renvoient `api_result=false`, `error_code` et `error_message`. Les codes d'erreur stables
spécifiques au minuteur sont :

- `invalid_parameter`
- `missing_required_parameter`
- `unsupported_action_for_mode`
- `task_not_found`
- `task_change_not_allowed`
- `timer_mode_locked`
- `timer_state_conflict`
- `background_start_not_allowed`
- `timer_start_failed`
- `timer_settlement_failed`

Sur Android 12 et versions ultérieures, un appel ContentProvider en arrière-plan peut démarrer un minuteur uniquement lorsque LifeUp est
autorisé à ignorer l'optimisation de batterie. Sinon, il renvoie `background_start_not_allowed`
avant de modifier l'état du minuteur. Ouvrir le schéma d'URL via son Activity amène LifeUp au
premier plan avant le démarrage. Android peut empêcher une application tierce de lancer cet Activity depuis
l'arrière-plan ; dans ce cas, LifeUp ne reçoit aucun appel API et ne peut pas renvoyer d'erreur.

<br/>

### Pomodoro Record

#### Add Pomodoro Record

**Nom de la méthode:** add_pomodoro

**Description:** Ajoute un enregistrement de minutage Pomodoro

**Exemple:**

- Ajouter un enregistrement de 25 minutes (1 500 000 ms) lié à une Tâche dont le nom contient « learning » : [lifeup://api/add_pomodoro?task_name=learning&duration=1500000](lifeup://api/add_pomodoro?task_name=learning&duration=1500000)
- Ajouter un enregistrement pour `2022-08-01 11:00:00` - `2022-08-01 12:00:00` : [lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000](lifeup://api/add_pomodoro?start_time=1659322800000&end_time=1659326400000)

**Explication:**

| Paramètre        | Signification                    | Type                    | Exemple       | Obligatoire | Notes |
| ---------------- | -------------------------- | ----------------------- | ------------- | -------- | ----- |
| start_time       | heure de début du minutage          | timestamp               | 1659322800000 | non*      | Si vous ne connaissez pas les timestamps, cherchez « timestamp » sur le Web ! |
| duration         | durée de Concentration             | nombre (en millisecondes) <br/>doit être supérieur à 30000 | 1500000 | non* | |
| end_time         | heure de fin du minutage            | timestamp               | 1659326400000 | non*      |       |
| reward_tomatoes  | accorder ou non des tomates | true ou false           | true          | non       | false par défaut |
| task_id          | ID de Tâche                    | nombre > 0 | 1             | non       |       |
| task_gid         | ID de groupe de Tâches              | nombre > 0 | 1             | non       |       |
| task_name        | nom                       | texte libre                | learning      | non       | recherche floue ; agit sur une seule Tâche correspondante |
| ui               | Afficher l'interface de tomates récompensées | true ou false         | true          | non       | Introduit dans v1.94.0 ; true par défaut |

**Avis:**

1. Il faut fournir l'un de start_time, duration ou end_time.
2. Si seul duration est fourni, end_time vaut par défaut l'heure actuelle.
3. end_time doit être supérieur à start_time.
4. duration est d'au moins 30 000 millisecondes (30 secondes).
5. Si start_time, duration et end_time sont tous fournis, duration doit être inférieur ou égal à (end_time - start_time).

<br/>

#### Edit Pomodoro Record

> Introduit dans v1.94.0
> **Nom de la méthode:** edit_pomodoro

**Description:** Modifie un enregistrement de minutage Pomodoro existant ou en ajoute un nouveau si un `edit_item_id` valide est fourni.

**Exemple:**

- Modifier un enregistrement par ID, définir la durée à 45 minutes (2 700 000 ms) et accorder des tomates : [lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true](lifeup://api/edit_pomodoro?edit_item_id=123&duration=2700000&reward_tomatoes=true)
- Modifier un enregistrement par heure de début et de fin : [lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456](lifeup://api/edit_pomodoro?start_time=1659322800000&end_time=1659326400000&edit_item_id=456)

**Paramètres:**

| Paramètre       | Signification                    | Type                  | Exemple       | Obligatoire | Notes                                            |
| --------------- | -------------------------- | --------------------- | ------------- | -------- | ------------------------------------------------ |
| task_id         | ID de Tâche                    | Nombre > 0 | 101           | Non       | Identifiant unique de la Tâche                   |
| task_gid        | ID de groupe de Tâches              | Nombre > 0 | 5             | Non       | S'il est fourni, il remplace task_id                |
| task_name       | Nom de la Tâche                  | texte libre              | Study         | Non       | Requis si task_id ou task_gid n'est pas fourni   |
| start_time      | Heure de début du minutage          | Timestamp             | 1659322800000 | Non*      | Cherchez « timestamp » sur le Web si besoin     |
| end_time        | Heure de fin du minutage            | Timestamp             | 1659326400000 | Non*      | -                                                |
| duration        | Durée de Concentration             | Nombre (millisecondes) | 2700000       | Non*      | Au moins 30 000 millisecondes (30 secondes) |
| reward_tomatoes | Accorder ou non des tomates | true ou false         | true          | Non       | false par défaut                                 |
| edit_item_id    | ID de l'élément à modifier     | Nombre > 0 | 123           | Oui      | Indique l'ID de l'enregistrement à modifier                  |
| ui              | Afficher l'interface de tomates récompensées | true ou false         | true          | Non       |                                                  |
| delete          | Supprimer l'enregistrement          | true ou false         | true          | Non       | v1.105.1+. Suppression réversible de l'enregistrement Pomodoro (`isDel`), comme dans l'App |

**Valeurs de retour:**

| Paramètre | Signification                          | Type   | Exemple | Obligatoire | Notes                    |
| --------- | -------------------------------- | ------ | ------- | -------- | ------------------------ |
| tomatoes  | Tomates obtenues par cette action | Number | 2       | Non       | Renvoyé si `ui` vaut true |

**Notes:**

1. Il faut fournir au moins l'un de `start_time`, `duration` ou `end_time`.
2. `end_time` doit être supérieur à `start_time`.
3. `duration` doit être inférieur ou égal à (`end_time` - `start_time`).
4. Si `edit_item_id` est fourni et que l'enregistrement correspondant est trouvé, il est modifié ; sinon, un nouvel enregistrement est créé à partir des autres paramètres.

<br/>

### Unlock Achievement Conditions

**Nom de la méthode:** unlock_condition

**Description:** Condition de déverrouillage de Succès : nécessite un appel API externe pour déverrouiller

**Exemple:**

- Appeler la condition de déverrouillage avec l'id 2 : [lifeup://api/unlock_condition?id=2](lifeup://api/unlock_condition?id=2)

| Paramètre | Signification      | Type                  | Exemple | Obligatoire | Notes |
| --------- | ------------------ | --------------------- | ------- | -------- |------ |
| id        | id de condition | number greater than 0 | 2       | oui      |       |

<br/>

### Complete / Claim Achievement

?> Cette API a été introduite dans v1.105.1.

**Nom de la méthode:** complete_achievement

**Description:** Finalise un Succès manuel et réclame sa Récompense, ou réclame la Récompense d'un Succès automatique déjà déverrouillé. Même comportement que toucher la case de finalisation / le bouton de réclamation de Récompense dans l'App.

**Exemple:**

- Finaliser ou réclamer le Succès avec l'id 1 : [lifeup://api/complete_achievement?id=1](lifeup://api/complete_achievement?id=1)

| Paramètre | Signification        | Type                  | Exemple | Obligatoire | Notes |
| --------- | -------------------- | --------------------- | ------- | -------- | ----- |
| id        | id de Succès | number greater than 0 | 1       | oui      |       |

**Valeurs de retour:**

| Champ  | Type   | Description | Exemple | Notes |
| ------ | ------ | ----------- | ------- | ----- |
| id     | number | ID de Succès | 1 | |
| status | number | statut après l'appel | 2 | `0` verrouillé · `1` déverrouillé, Récompense non réclamée · `2` déverrouillé, Récompense réclamée |

**Notes:**

1. Succès manuels (sans conditions de déverrouillage) : s'ils sont encore verrouillés, cet appel finalise le Succès et accorde les Récompenses.
2. Succès automatiques (avec conditions de déverrouillage) : ne réclame les Récompenses que lorsque le Succès est déjà déverrouillé et qu'une Récompense est encore en attente. Si les conditions ne sont pas remplies, l'appel échoue avec `error_code=achievement_not_unlocked`.
3. Un nouvel appel après réclamation de la Récompense réussit avec `status=2` et n'accorde pas les Récompenses deux fois.
4. Cela diffère de `achievement?unlocked=true`, qui ne modifie que l'état de déverrouillage et n'accorde pas de Récompenses.

<br/>

### Set the number of steps

**Nom de la méthode:** step

**Description:** Définit le nombre de pas à la date indiquée ; par exemple, peut servir à saisir le nombre de pas avec un bracelet + outil d'automatisation. Peut aussi modifier des enregistrements historiques.

**Exemple:**

- Ajuster le nombre de pas du 2022-10-21 dans le fuseau horaire GMT+8 à 9999 pas : [lifeup://api/step?count=9999&time=1666282995643](lifeup://api/step?count=9999&time=1666282995643)

| Paramètre | Signification                         | Type                                | Exemple       | Obligatoire | Notes |
| --------- | ------------------------------------- | ----------------------------------- | ------------- | -------- | ----- |
| count     | nombre de pas                 | a number greater than or equal to 0 | 9999          | oui      |       |
| time      | horodatage arbitraire de la date | timestamp (ms)                      | 1666282995643 | oui      |       |

<br/>

### Edit Experience

?> Cette API a été introduite dans la version v1.93.0-beta01 (502).

**Nom de la méthode:** edit_exp

**Description:** Cette API peut définir par lot les valeurs actuelles de Points d'Expérience des Attributs. Elle peut fixer directement une valeur d'expérience précise ou un Niveau donné.

**Exemple:**

> Cette API affecte les données ; pour éviter une utilisation accidentelle, aucun lien cliquable direct n'est fourni ici.

- Réinitialiser les Points d'Expérience des Attributs [Strength] et [Knowledge] à 0 : lifeup://api/edit_exp?skills=1&skills=2&exp=0
- Ajuster directement les Points d'Expérience de [Charm] au Niveau 50 : lifeup://api/edit_exp?skills=3&level=50

| Paramètre | Signification              | Type                                      | Exemple | Obligatoire | Notes |
| --------- | -------------------- | ----------------------------------------- | ------- | -------- | ----- |
| skills    | ID d'Attribut (Compétence) | Array of numbers greater than 0           | 1       | Non       | Prend en charge les tableaux (p. ex., &skills=1&skills=2&skills=3)<br/>Pour obtenir l'ID d'Attribut, consultez la section « Connaissances de base - ID de données LifeUp » |
| exp       | Définir les Points d'Expérience | Number greater than or equal to 0 (int32) | 9999    | Non, mais exp ou level doit être fourni |                                                               |
| level     | Définir le Niveau            | Number greater than or equal to 0 (int32) | 50      | Non, mais exp ou level doit être fourni | Représente les Points d'Expérience de départ d'un Niveau donné<br/>et est affecté par les gradients de Niveau personnalisés. |

<br/>

### Add or edit Feelings

?> Cette API est disponible à partir de la version v1.93.4 (536).

**Nom de la méthode:** feeling

**Description:** Sert à créer ou mettre à jour des enregistrements d'Émotions.

**Exemple:**

- Créer un enregistrement d'Émotion : [lifeup://api/feeling?content=Happy&time=1633036800](lifeup://api/feeling?content=Happy&time=1633036800)
- Mettre à jour un enregistrement d'Émotion existant et le marquer comme favori : [lifeup://api/feeling?id=1&is_favorite=true](lifeup://api/feeling?id=1&is_favorite=true)
- Supprimer une Émotion : [lifeup://api/feeling?id=1&delete=true](lifeup://api/feeling?id=1&delete=true)

| Paramètre            | Signification           | Type                               | Exemple           | Obligatoire | Notes                                                                                                                                                                                                                                        |
| -------------------- | ----------------- | ---------------------------------- | ----------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                   | ID d'enregistrement d'Émotion | Number greater than 0              | 1                 | Non       | Si fourni, la méthode tente de mettre à jour un enregistrement précis. Obligatoire lors de la suppression.                                                                                                                                                           |
| content              | Contenu           | Any text                           | Happy             | Non       | Sert à créer un enregistrement ou à mettre à jour le contenu d'un enregistrement existant                                                                                                                                                                    |
| time                 | Horodatage         | Unix timestamp                     | 1633036800        | Non       | Heure de l'enregistrement ; par défaut, l'heure actuelle                                                                                                                                                                                             |
| is_favorite          | Marque de favori     | true or false                      | true              | Non       | Marque l'enregistrement comme favori ou non                                                                                                                                                                                                        |
| delete               | Supprimer            | true or false                      | true              | Non       | v1.105.1+. Supprime l'Émotion de façon réversible comme dans l'App (les pièces jointes sont retirées).                                                                                                                                                       |
| relate_type          | Type de relation     | Number between 0 and 3             | 1                 | Non       | Spécifie le type de relation associé à l'enregistrement :<br/>0 : Tâche<br/>1 : Succès personnalisé<br/>2 : Aucune relation<br/>3 : Utilisation d'Objet                                                                                                        |
| relate_id            | ID associé        | Number greater than 0              | 2                 | Non       | Spécifie l'ID de l'élément associé :<br/>Lorsque relate_type vaut 0 : représente l'ID de Tâche<br/>Lorsque relate_type vaut 1 : représente l'ID de Succès<br/>Lorsque relate_type vaut 3 : représente l'ID d'Objet<br/>Lorsque relate_type vaut 2 : aucun ID requis                |
| usage_count          | Nombre d'utilisations       | Integer greater than 1             | 1                 | Non       | Valable uniquement lorsque relate_type vaut 3 (utilisation d'Objet) ; enregistre le nombre d'utilisations de l'Objet.                                                                                                                                                          |
| image_uris           | URIs d'image        | List of URI strings                |                   | Non       | Prend en charge les URIs de fichiers locaux (file://) ou les images web distantes (http/https). Prend en charge les tableaux (p. ex., &image_uris=uri1&image_uris=uri2). |
| image_uris_update_mode | Mode de mise à jour       | APPEND or REPLACE | REPLACE           | Non       | Valable uniquement lors de la mise à jour d'un enregistrement existant avec image_uris.<br/>APPEND : ajoute aux images existantes.<br/>REPLACE : remplace les images existantes (par défaut).                                                               |
    
**Note:**

1. Si le paramètre `id` est fourni, la méthode tente de mettre à jour l'enregistrement d'Émotion correspondant. Une exception est levée si aucun enregistrement correspondant n'est trouvé.
2. Si `id` n'est pas fourni mais que `content` l'est, la méthode crée un nouvel enregistrement d'Émotion.

<br/>

### Tomato Count

?> Requiert v1.98.0+

**Nom de la méthode:** tomato

**Description:** Ajuste le nombre de tomates (augmenter, diminuer ou fixer une quantité précise)

**Exemples:**

- Ajouter 1 tomate : [lifeup://api/tomato?action=increase&number=1](lifeup://api/tomato?action=increase&number=1)
- Retirer 2 tomates : [lifeup://api/tomato?action=decrease&number=2](lifeup://api/tomato?action=decrease&number=2)
- Fixer le compteur Pomodoro à 10 : [lifeup://api/tomato?action=set&number=10](lifeup://api/tomato?action=set&number=10)

| Paramètre | Signification        | Valeurs                                        | Exemple   | Obligatoire | Notes                                                         |
| --------- | -------------- | --------------------------------------------- | --------- | -------- | ------------------------------------------------------------- |
| action    | Type d'opération | One of:<br/>increase<br/>decrease<br/>set     | increase  | Non       | increase - Ajouter des pomodoros (par défaut)<br/>decrease - Retirer des pomodoros<br/>set - Fixer le compteur Pomodoro à la valeur indiquée |
| number    | Quantité         | Integer                                       | 1         | Oui      | Signification selon action :<br/>increase/decrease - Quantité à ajouter/retirer<br/>set - Quantité cible |

**Réponse:**

| Champ    | Type    | Description              | Exemple |
| -------- | ------- | ------------------------ | ------- |
| tomatoes | Integer | Compteur Pomodoro actuel   | 10      |

<br/>

### Purchase Item

?> Requiert v1.98.0+

**Nom de la méthode:** purchase_item

**Description:** Achète un Objet précis

**Exemples:**

- Acheter l'Objet avec l'ID 1 : [lifeup://api/purchase_item?id=1](lifeup://api/purchase_item?id=1)
- Acheter l'Objet nommé "Health Potion" : [lifeup://api/purchase_item?name=Health%20Potion](lifeup://api/purchase_item?name=Health%20Potion)
- Acheter 5 exemplaires de l'Objet avec l'ID 1 : [lifeup://api/purchase_item?id=1&purchase_quantity=5](lifeup://api/purchase_item?id=1&purchase_quantity=5)

Si l'Objet a `purchase_limit` configuré et que `limit_scope` inclut `purchase`, cette API applique aussi ces restrictions.

| Paramètre         | Signification          | Valeurs                | Exemple       | Obligatoire | Notes                      |
| ----------------- | ---------------- | --------------------- | ------------- | -------- | -------------------------- |
| id                | ID d'Objet          | number greater than 0 | 1             | Non*      | id ou name requis |
| name              | Nom de l'Objet        | any text              | Health Potion | Non*      | id ou name requis |
| purchase_quantity | Quantité d'achat| number greater than 0 | 5             | Non       | 1 par défaut              |

**Réponse:**

| Champ  | Type    | Description        | Exemple         | Notes                       |
| ------ | ------- | ------------------ | --------------- | --------------------------- |
| itemId | Number  | ID d'Objet            | 1               | Renvoyé en cas d'achat réussi  |
| result | Integer | Code de résultat        | 0               | Voir les codes de résultat ci-dessous      |
| desc   | Text    | Description du résultat | PurchaseSuccess | Voir les codes de résultat ci-dessous      |

**Codes de résultat:**

| Code | Description               | Notes                         |
| ---- | ------------------------- | ----------------------------- |
| 0    | PurchaseSuccess           | Achat réussi            |
| 1    | DatabaseError             | Erreur de base de données                |
| 2    | NotEnoughCoin             | Pièces insuffisantes              |
| 3    | ItemNotFound              | Objet introuvable                |
| 4    | PurchaseAndUseSuccess     | Achat et utilisation réussis    |
| 5    | PurchaseSuccessAndUseFailure | Achat réussi mais utilisation échouée |
| 6    | NotPurchaseable           | Achat bloqué par les paramètres ou restrictions de l'Objet |
| 7    | OutOfStock                | Stock de la Boutique insuffisant      |

<br/>

### Synthesis

?> Requiert v1.98.0+

**Nom de la méthode:** synthesize

**Description:** Synthétise des Objets à l'aide d'une formule existante

**Exemples:**

- Synthétiser une fois avec la formule d'ID 1 : [lifeup://api/synthesize?id=1](lifeup://api/synthesize?id=1)
- Synthétiser 5 fois avec la formule d'ID 1 : [lifeup://api/synthesize?id=1&times=5](lifeup://api/synthesize?id=1&times=5)

**Comportement de diffusion:**

- Cette API sert à la **Synthèse par recette**.
- Lorsque `Broadcast events` est activé et que la Synthèse réussit, LifeUp envoie aussi l'événement de diffusion `app.lifeup.synthesis.complete`.
- Cet événement **n'est pas** envoyé pour la Synthèse simple dans `use_item` ; ce chemin relève toujours de `app.lifeup.item.use`.

| Paramètre | Signification            | Valeurs                | Exemple | Obligatoire | Notes                    |
| --------- | ----------------- | -------------------- | ------- | -------- | ------------------------ |
| id        | ID de formule        | number greater than 0 | 1       | Oui      | ID de la formule de Synthèse  |
| times     | Nombre de fois   | number greater than 0 | 5       | Non       | 1 par défaut           |

**Réponse:**

| Champ           | Type    | Description     | Exemple          | Notes                    |
| -------------- | ------- | --------------- | ---------------- | ------------------------ |
| formulaId      | Number  | ID de formule      | 1                |                          |
| result         | Integer | Code de résultat     | 0                | Voir les codes de résultat ci-dessous   |
| desc           | Text    | Description du résultat | SynthesisSuccess | Voir les codes de résultat ci-dessous |
| synthesisResults| Text   | Résultats de Synthèse | {...}           | Renvoyé uniquement en cas de succès |

**Codes de résultat:**

| Code | Description          | Notes                 |
| ---- | ------------------- | --------------------- |
| 0    | SynthesisSuccess    | Synthèse réussie  |
| 1    | FormulaNotFound     | Formule introuvable     |
| 2    | InsufficientMaterials| Matériaux insuffisants |
| 3    | DatabaseError       | Erreur de base de données        |
| 4    | UnknownError        | Autres erreurs         |

<br/>

### Synthesis Formula Management

?> Requiert v1.98.0+

**Nom de la méthode:** synthesis_formula

**Description:** Créer, modifier ou supprimer des formules de Synthèse

**Exemples:**

- Créer une formule : [lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D](lifeup://api/synthesis_formula?inputItems=%5B%7B%22item_id%22%3A%20296%2C%20%22amount%22%3A%2088%7D%5D&outputItems=%5B%7B%22item_id%22%3A%20295%2C%20%22amount%22%3A%201%7D%5D)
  - Ici, inputItems vaut `[{"item_id": 296, "amount": 88}]`
  - Ici, outputItems vaut `[{"item_id": 295, "amount": 1}]`
- Supprimer la formule : [lifeup://api/synthesis_formula?id=1&delete=true](lifeup://api/synthesis_formula?id=1&delete=true)

| Paramètre   | Signification        | Valeurs                | Exemple                        | Obligatoire | Notes                          |
| ----------- | -------------- | -------------------- | ------------------------------ | -------- | ------------------------------ |
| id          | ID de formule     | number greater than 0 | 1                             | Non       | Requis pour modifier ou supprimer  |
| delete      | Marque de suppression    | true or false        | true                          | Non       | Utilisé uniquement pour la suppression         |
| inputItems  | Objets d'entrée    | Item array, see below | [{"item_id":1,"amount":2}]     | Oui      | Requis pour créer ou modifier  |
| outputItems | Objets de sortie   | Item array, see below | [{"item_id":3,"amount":1}]     | Oui      | Requis pour créer ou modifier  |
| category    | ID de catégorie    | number greater than 0 | 1                             | Non       | Catégorie commune par défaut    |

!> inputItems et outputItems sont des tableaux JSON dont chaque élément contient les champs item_id et amount. Tous les ID d'Objet doivent exister et les quantités doivent être supérieures à 0

**Réponse:**

| Champ     | Type    | Description      | Exemple     | Notes                    |
| --------- | ------- | ---------------- | ----------- | ------------------------ |
| formulaId | Number  | ID de formule       | 1           | Renvoyé en cas de succès      |
| result    | Integer | Code de résultat      | 0           | Voir les codes de résultat ci-dessous   |
| desc      | Text    | Description du résultat | AddSuccess | Voir les codes de résultat ci-dessous   |

**Codes de résultat:**

| Code | Description     | Notes             |
| ---- | -------------- | ----------------- |
| 0    | Success        | Opération réussie |
| 1    | Failed         | Opération échouée  |

<br/>

### Subtask Management

?> Requiert v1.98.0+

**Nom de la méthode:** subtask

**Description:** Créer ou modifier des sous-tâches

**Exemples:**

- Ajouter une sous-tâche à la Tâche principale d'ID 1 : [lifeup://api/subtask?main_id=1&todo=Complete%20homework](lifeup://api/subtask?main_id=1&todo=Complete%20homework)
- Modifier une sous-tâche et définir les Récompenses : [lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5](lifeup://api/subtask?main_id=1&edit_id=2&coin=10&exp=5)

| Paramètre     | Signification            | Valeurs                | Exemple    | Obligatoire | Notes                           |
| ------------ | ------------------ | -------------------- | ---------- | -------- | ------------------------------- |
| main_id      | ID de Tâche principale       | number greater than 0 | 1         | Non*      | main_id, main_gid ou main_name requis |
| main_gid     | ID de groupe de Tâche principale | number greater than 0 | 1         | Non*      | main_id, main_gid ou main_name requis |
| main_name    | Nom de Tâche principale     | any text             | Study task | Non*      | main_id, main_gid ou main_name requis |
| edit_id      | ID de sous-tâche à modifier | number greater than 0 | 2         | Non*      | edit_id, edit_gid ou edit_name requis lors de la modification ; inutile à la création |
| edit_gid     | ID de groupe de sous-tâche   | number greater than 0 | 2         | Non*      | edit_id, edit_gid ou edit_name requis lors de la modification ; inutile à la création |
| edit_name    | Nom de sous-tâche       | any text             | Do homework| Non*      | edit_id, edit_gid ou edit_name requis lors de la modification ; inutile à la création |
| todo         | Contenu de Tâche       | any text             | Do homework| Non       | Requis lors de la création d'une sous-tâche |
| remind_time  | Heure de rappel      | timestamp (milliseconds)| 1640995200000 | Non | Passer null pour effacer le rappel    |
| order        | Ordre              | integer              | 1          | Non       | Position dans la liste de Tâches           |
| coin         | Récompense en pièces        | [0, 999999]         | 10         | Non       | Pièces obtenues à la finalisation    |
| coin_var     | Variation de pièces      | integer              | 5          | Non       | Variation aléatoire de la Récompense en pièces  |
| exp          | Récompense en Points d'Expérience  | [0, 99999]          | 5          | Non       | Points d'Expérience obtenus        |
| auto_use_item| Utiliser l'Objet automatiquement      | true or false        | true       | Non       | Utiliser l'Objet automatiquement à la finalisation |
| item_id      | ID d'Objet            | number greater than 0 | 1         | Non*      | item_id ou item_name requis |
| item_name    | Nom de l'Objet          | any text             | Health Potion| Non*    | item_id ou item_name requis |
| item_amount  | Quantité d'Objet        | number greater than 0 | 1         | Non       | Valable uniquement lors de la définition d'une Récompense d'Objet |
| items        | JSON d'Objets         | JSON text            | [{"item_id":1,"amount":1}] | Non | Définir plusieurs Récompenses d'Objet à la fois |
| coin_set_type     | Mode de définition des pièces | One of:<br/>absolute<br/>relative | absolute | Non | absolute - fixe directement les pièces à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine |
| exp_set_type      | Mode de définition de exp | One of:<br/>absolute<br/>relative | absolute | Non | absolute - fixe directement exp à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine |

**Réponse:**

| Champ        | Type    | Description      | Exemple | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID de Tâche principale     | 1       |                  |
| subtask_id   | Number  | ID de sous-tâche       | 2       |                  |
| subtask_gid  | Number  | ID de groupe de sous-tâche | 3       | Peut être vide     |

<br/>

### Category Management

?> Requiert v1.98.0+

**Nom de la méthode:** category

**Description:** Ajouter ou modifier des catégories (listes de Tâches, listes de Succès, listes de Boutique, listes de Synthèse)

**Exemples:**

- Créer une liste de Tâches : [lifeup://api/category?type=tasks&name=Study List](lifeup://api/category?type=tasks&name=Study List)
- Modifier une liste de Boutique : [lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1](lifeup://api/category?type=shop&edit_id=1&name=Equipment Shop&order=1)

| Paramètre        | Signification           | Valeurs               | Exemple    | Obligatoire | Notes                           |
| --------------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| type            | Type de catégorie     | One of:<br/>tasks<br/>achievements<br/>shop<br/>synthesis | tasks | Oui | tasks - Listes de Tâches<br/>achievements - Listes de Succès<br/>shop - Listes de Boutique<br/>synthesis - Listes de Synthèse |
| edit_id         | ID de catégorie à modifier| number greater than 0| 1         | Non       | Requis lors de la modification           |
| name            | Nom de catégorie     | any text             | Study List | Non       | Requis pour les nouvelles catégories ; optionnel lors de la modification |
| order           | Ordre de tri        | integer              | 1         | Non       | Position dans la liste            |
| hidden          | Masquer la catégorie     | true or false        | false     | Non       | tasks=archiver ; shop=masquer dans la Boutique ; synthesis=masquer. Les listes de Succès et la liste ALL de Synthèse rejettent avec `unsupported_parameter`. `false` réaffiche |
| inventory_hidden| Masquer dans l'Inventaire | true or false        | false     | Non       | Pris en charge uniquement pour les listes de Boutique   |
| icon_uri        | URI d'icône          | emoji, http(s) URL, content URI, or empty | 🏆 | Non | Pris en charge uniquement pour les listes de Succès. L'emoji est enregistré comme `emoji_*.webp`. Vide efface la valeur. |
| desc            | Description       | any text             | This is a description | Non | Pris en charge uniquement pour les listes de Succès |
| color           | Couleur d'étiquette         | color string         | #66CCFF   | Non       | Pris en charge uniquement pour les listes de Tâches ; # doit être échappé en %23 |

**Réponse:**

| Champ | Type    | Description    | Exemple | Notes                    |
| ----- | ------- | -------------- | ------- | ------------------------ |
| id    | Number  | ID de catégorie    | 1000    | ID de la catégorie nouvelle ou modifiée |

<br/>

### Export Backup

?> Requiert v1.98.0+

**Nom de la méthode:** export_backup

**Description:** Crée un fichier de sauvegarde et renvoie son URI (appels Content Provider uniquement)

!> Cette API ne peut être appelée que via Content Provider ; les appels directs par URL Scheme ne sont pas pris en charge

| Paramètre      | Signification        | Valeurs          | Exemple | Obligatoire | Notes                                         |
| ------------- | -------------- | --------------- | ------- | -------- | --------------------------------------------- |
| withMedia     | Inclure les fichiers média | true or false | true    | Non       | Indique si les fichiers média (images, effets sonores, etc.) sont inclus dans la sauvegarde<br/>true par défaut |
| callingPackage| Nom du package appelant | any text      | com.example.app | Non | Identifiant de package pour les appels Content Provider |

**Réponse:**

| Champ          | Type   | Description          | Exemple                                       |
| -------------- | ------ | -------------------- | --------------------------------------------- |
| backup_file_uri | Text   | URI du fichier de sauvegarde      | content://net.sarasarasa.lifeup.api/backup/file.zip |

<br/>

### Subtask Operation

?> Requiert v1.98.0+

**Nom de la méthode:** subtask_operation

**Description:** Finaliser, annuler la finalisation ou supprimer des sous-tâches

**Exemples:**

- Finaliser une sous-tâche : [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=complete)
- Supprimer une sous-tâche : [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=delete)
- Annuler la finalisation d'une sous-tâche : [lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete](lifeup://api/subtask_operation?main_id=1&edit_id=2&operation=undo_complete)

| Paramètre     | Signification          | Valeurs               | Exemple    | Obligatoire | Notes                          |
| ------------ | ---------------- | ------------------- | ---------- | -------- | ------------------------------ |
| main_id      | ID de Tâche principale     | number greater than 0| 1         | Non*      | main_id, main_gid ou main_name requis |
| main_gid     | ID de groupe de Tâche principale| number greater than 0| 1        | Non*      | main_id, main_gid ou main_name requis |
| main_name    | Nom de Tâche principale   | any text            | Study task | Non*      | main_id, main_gid ou main_name requis |
| edit_id      | ID de sous-tâche       | number greater than 0| 2         | Non*      | edit_id, edit_gid ou edit_name requis |
| edit_gid     | ID de groupe de sous-tâche | number greater than 0| 2         | Non*      | edit_id, edit_gid ou edit_name requis |
| edit_name    | Nom de sous-tâche     | any text            | Do homework| Non*      | edit_id, edit_gid ou edit_name requis |
| operation    | Type d'opération   | One of the following:<br/>complete<br/>undo_complete<br/>delete | complete | Oui | complete - Finaliser la Tâche<br/>undo_complete - Annuler la finalisation<br/>delete - Supprimer la Tâche |

**Réponse:**

| Champ        | Type    | Description      | Exemple | Notes            |
| ------------ | ------- | ---------------- | ------- | ---------------- |
| main_task_id | Number  | ID de Tâche principale     | 1       |                  |
| subtask_id   | Number  | ID de sous-tâche       | 2       |                  |
| subtask_gid  | Number  | ID de groupe de sous-tâche | 3       | Peut être vide     |

<br/>

### Achievement Management

?> Requiert v1.98.0+

**Nom de la méthode:** achievement

**Description:** Ajouter ou modifier des Succès personnalisés et des sous-catégories de Succès

**Exemples:**

- Créer un Succès : [lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1](lifeup://api/achievement?name=Collector&desc=Collect 100 items&category_id=1)
  - Vous devrez peut-être remplacer `category_id` par l'id réel de votre liste de Succès disponible pour tester cet exemple
- Créer un Succès avec conditions de déverrouillage : [lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1](lifeup://api/achievement?name=Millionaire&conditions_json=%5B%7B%22type%22%3A7%2C%22target%22%3A1000000%7D%5D&category_id=1)
  - Vous devrez peut-être remplacer `category_id` par l'id réel de votre liste de Succès disponible pour tester cet exemple
  - Le contenu décodé de `conditions_json` est `[{"type":7,"target":1000000}]`
- Modifier un Succès existant : [lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100](lifeup://api/achievement?edit_id=1&name=New Achievement Name&exp=100)

#### 1. Achievement Parameters

| Paramètre      | Signification           | Valeurs               | Exemple   | Obligatoire | Notes                           |
| ------------- | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| edit_id       | ID de Succès à modifier | number greater than 0 | 1      | Non       | Requis lors de la modification          |
| is_subcategory| Est une sous-catégorie    | true or false        | false     | Non       | false par défaut               |
| name          | Nom de Succès   | any text             | Collector | Non*      | Requis pour les nouveaux Succès   |
| desc          | Description       | any text             | Collect 100 items | Non |                               |
| icon_uri      | Icône              | emoji, http(s) URL, content URI, or empty | 🏆 | Non | Pas `icon`. L'emoji est enregistré comme fichier `emoji_`. Vide efface la valeur. |
| order         | Ordre de tri        | integer              | 1         | Non       | Position dans la liste                |
| category_id   | ID de catégorie       | number greater than 0 | 1        | Non*      | Requis lors de la création d'une sous-catégorie |
| unlocked      | État de déverrouillage     | true or false        | true      | Non       | true - déverrouiller immédiatement<br/>false - réinitialiser en verrouillé |
| unlock_time   | Heure de déverrouillage       | timestamp (milliseconds) | 1640995200000 | Non | Effectif uniquement lorsque déjà déverrouillé |
| delete        | Marque de suppression       | true or false        | false     | Non       |                                |
| secret        | Succès masqué| true or false        | false     | Non       |                                |
| write_feeling | Enregistrer des Émotions   | true or false        | false     | Non       |                                |
| color         | Couleur du titre       | color string         | #66CCFF   | Non       | # doit être échappé en %23        |
| auto_use_item | Utiliser l'Objet automatiquement     | true or false        | false     | Non       |                                |
| skills        | IDs de Compétence         | array of numbers greater than 0 | 1 | Non    | Prend en charge les tableaux (p. ex., &skills=1&skills=2) |
| exp           | Récompense en Points d'Expérience | integer              | 100       | Non       |                                |
| item_id       | ID d'Objet           | number greater than 0 | 1        | Non*      | item_id ou item_name requis |
| item_name     | Nom de l'Objet         | any text             | Treasure  | Non*      | item_id ou item_name requis |
| item_amount   | Quantité d'Objet     | [1, 99]             | 1         | Non       | 1 par défaut                   |
| items         | JSON de Récompenses d'Objet | JSON text            | [{"item_id":1,"amount":2}] | Non | Définir plusieurs Récompenses d'Objet ; voir le format ci-dessous |
| conditions_json| JSON de conditions de déverrouillage | JSON text      | [{"type":7,"target":1000000}] | Non | Définir les conditions de déverrouillage ; voir le format ci-dessous |
| coin         | Récompense en pièces       | [0, 999999]      | 10         | Non       | Nombre de pièces obtenues lors du déverrouillage du Succès |
| coin_var     | Variation de Récompense en pièces | integer              | 5          | Non       | Plage de variation des Récompenses en pièces |
| coin_set_type| Mode de définition des pièces | One of:<br/>absolute<br/>relative | absolute | Non | absolute - fixe directement les pièces à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine |
| exp_set_type | Mode de définition de exp | One of:<br/>absolute<br/>relative | absolute | Non | absolute - fixe directement exp à la valeur<br/>relative - ajoute ou soustrait par rapport à la valeur d'origine |

**Réponse:**

| Champ  | Type    | Description      | Exemple | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID de Succès   | 1000    | ID du Succès nouvellement créé ou modifié |

#### 2. Subcategory Parameters

| Paramètre     | Signification           | Valeurs               | Exemple   | Obligatoire | Notes                           |
| ------------ | ----------------- | -------------------- | --------- | -------- | ------------------------------- |
| is_collapsed | État replié   | true or false        | false     | Non       | S'applique uniquement aux sous-catégories   |

Les sous-catégories rejettent `icon_uri` (y compris emoji) avec `unsupported_parameter`. Modifier une sous-catégorie sans `is_subcategory=true` renvoie `is_subcategory_required`.
**Réponse:**

| Champ  | Type    | Description      | Exemple | Notes                    |
| ------ | ------- | ---------------- | ------- | ------------------------ |
| id     | Number  | ID de Succès   | 1000    | ID du Succès nouvellement créé ou modifié (sous-catégorie) |

#### 3. Unlock Condition Types

| Code de type | Description             | Requiert related_id | Type de related_id | Description de target  |
| --------- | ----------------------- | ------------------ | --------------- | ------------------ |
| 0         | Nombre de finalisations de Tâche   | Oui                | ID de Tâche         | Nombre de finalisations |
| 1         | Série de finalisations de Tâche  | Oui                | ID de Tâche         | Longueur de la série       |
| 3         | Nombre de Pomodoros         | Non                 | -               | Nombre de pomodoros |
| 4         | Jours d'utilisation de LifeUp      | Non                 | -               | Nombre de jours     |
| 5         | Nombre de likes             | Non                 | -               | Nombre de likes    |
| 6         | Série quotidienne de finalisations | Non                 | -               | Jours de série        |
| 7         | Pièces actuelles          | Non                 | -               | Montant de pièces    |
| 8         | Pièces gagnées en un jour| Non                 | -               | Montant de pièces    |
| 9         | Nombre de Pomodoros de Tâche    | Oui                | ID de Tâche         | Nombre de pomodoros |
| 10        | Nombre d'achats d'Objet    | Oui                | ID d'Objet         | Nombre d'achats     |
| 11        | Nombre d'utilisations d'Objet       | Oui                | ID d'Objet         | Nombre d'utilisations        |
| 12        | Nombre d'Objets de Boîte de butin    | Oui                | ID d'Objet         | Nombre obtenu     |
| 13        | Niveau de Compétence atteint    | Oui                | ID de Compétence        | Valeur de Niveau        |
| 14        | Niveau de vie            | Non                 | -               | Valeur de Niveau        |
| 15        | Total d'Objets obtenus   | Oui                | ID d'Objet         | Nombre total obtenu |
| 16        | Objets par Synthèse   | Oui                | ID d'Objet         | Nombre de Synthèses    |
| 17        | Quantité actuelle d'Objet  | Oui                | ID d'Objet         | Nombre possédé          |
| 18        | Durée de Concentration de Tâche    | Oui                | ID de Tâche         | Durée (minutes) |
| 19        | Épargne au distributeur           | Non                 | -               | Montant épargné     |
| 20        | API externe          | Non                 | -               | Défini par l'API        |
| 520       | Finaliser N Tâches distinctes par jour | Non         | -               | Nombre de Tâches distinctes (dédoublonné par ID de groupe ; type existant) |
| 524       | Finaliser N finalisations de Tâche par jour | Non       | -               | Nombre total de finalisations valides en un jour (v1.104.4+) |

> À partir de v1.104.4, les types `520` et `524` utilisent la sémantique suivante :
>
> - Les deux partagent la même définition de finalisation et la limite de jour du calendrier local (`TimeRange.today()`).
> - Les Tâches ordinaires comptent `COMPLETED` ; les Tâches négatives comptent `GIVE_UP`.
> - Le type `520` dédoublonne par `groupId` effectif (retombe sur l'id d'enregistrement de Tâche si l'id de groupe est absent). Finaliser la même Tâche illimitée plusieurs fois dans la journée compte toujours pour 1 Tâche distincte.
> - Le type `524` compte chaque ligne de finalisation valide. Finaliser la même Tâche illimitée 5 fois produit `completionCount = 5`.
> - Les Succès existants avec `type=520` conservent la sémantique de Tâches distinctes ; aucune migration n'est requise.

#### 4. JSON Format Specifications

##### Unlock Conditions (conditions_json)

```json
[
    {
        "type": 7,           // Condition type (refer to table above)
        "related_id": null,  // Related ID (required for some types)
        "target": 1000000    // Target value
    },
    {
        "type": 10,          // Example: Purchase specific item
        "related_id": 1,     // Item ID
        "target": 5          // Purchase 5 times
    },
    {
        "type": 520,         // Complete N distinct tasks daily
        "related_id": null,
        "target": 5
    },
    {
        "type": 524,         // Complete N task completions daily
        "related_id": null,
        "target": 10
    }
]
```

##### Item Rewards (items)

```json
[
    {
        "item_id": 1,    // Item ID
        "amount": 2      // Quantity
    },
    {
        "item_id": 2,
        "amount": 3
    }
]
```

<br/>

### Skill Management

?> Requiert v1.98.0+

**Nom de la méthode:** skill

**Description:** Créer ou modifier des Compétences personnalisées (Attributs)

**Exemples:**

- Créer une Compétence : [lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B](lifeup://api/skill?content=Programming&desc=Coding ability&color=%23FF6B6B)
- Modifier les Points d'Expérience d'une Compétence : [lifeup://api/skill?id=1&exp=100](lifeup://api/skill?id=1&exp=100)
- Supprimer une Compétence : [lifeup://api/skill?id=1&delete=true](lifeup://api/skill?id=1&delete=true)

| Paramètre    | Signification           | Valeurs               | Exemple    | Obligatoire | Notes                           |
| ----------- | ----------------- | -------------------- | ---------- | -------- | ------------------------------- |
| id          | ID de Compétence          | number greater than 0 | 1         | Non       | Requis lors de la modification           |
| content     | Nom de Compétence        | any text             | Programming| Non*      | Requis pour les nouvelles Compétences         |
| desc        | Description       | any text             | Coding ability | Non    |                                |
| icon        | Icône              | any text             | 💻         | Non       | Peut utiliser un emoji                   |
| color       | Couleur             | color string         | #FF6B6B    | Non       | # doit être échappé en %23        |
| type        | Type              | integer              | 0          | Non       |                                |
| order       | Ordre de tri        | integer              | 1          | Non       | Position brute dans la liste mixte. Utilisé seul, la Compétence est placée à cette position et le groupe final est déduit de la disposition ; utilisé avec `group_id`, elle est ajustée à la position légale la plus proche dans le groupe cible |
| group_id    | ID de groupe de Compétence    | integer              | 10         | Non       | Requiert v1.103.0+ ; ne peut pas être inférieur à `0`, et seul `0` déplace la Compétence vers la zone non groupée. Utilisé seul, les nouvelles Compétences sont ajoutées à la fin du groupe cible, tandis que les Compétences modifiées conservent leur position actuelle si elles y sont déjà ; sinon, elles passent à la fin du groupe ; utilisé avec `order`, `group_id` a la priorité |
| status      | Statut            | integer              | 0          | Non       |                                |
| exp         | Points d'Expérience | number greater than or equal to 0 | 100 | Non | Points d'Expérience actuels de la Compétence        |
| delete      | Marque de suppression       | true or false        | false      | Non       | Valable uniquement lors de la modification         |

**Réponse:**

| Champ  | Type    | Description    | Exemple | Notes                    |
| ------ | ------- | -------------- | ------- | ------------------------ |
| id     | Number  | ID de Compétence       | 1000    | ID de la Compétence nouvellement créée ou modifiée |

<br/>

### Skill Group Management :id=skill_group_management

Requiert v1.103.0+

**Nom de la méthode:** skill_group

**Description:** Créer, modifier, supprimer ou réordonner des groupes de Compétences. L'API de tri prend aussi en charge l'ordre mixte des groupes et des Compétences.

**Exemples:**

- Créer un groupe : [lifeup://api/skill_group?content=Combat](lifeup://api/skill_group?content=Combat)
- Modifier un groupe : [lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true](lifeup://api/skill_group?id=10&content=Combat&order=20&collapsed=true)
- Supprimer un groupe : [lifeup://api/skill_group?id=10&delete=true](lifeup://api/skill_group?id=10&delete=true)
- Trier groupes et Compétences ensemble :

```text
lifeup://api/skill_group?sort_json=[{"type":"skill","id":2},{"type":"group","id":10},{"type":"skill","id":3}]
```

| Paramètre | Signification | Valeurs | Exemple | Obligatoire | Notes |
| --------- | ------- | ------ | ------- | -------- | ----- |
| id | ID de groupe de Compétence | number greater than 0 | 10 | Non* | Requis lors de la modification ou de la suppression |
| content | Nom du groupe | any text | Combat | Non* | Requis lors de la création |
| order | Ordre de tri | integer | 20 | Non | Valeur brute `orderInCategory` ; doit être unique dans la liste mixte Compétence/groupe |
| collapsed | État replié | true or false | true | Non | Indique si le groupe est replié |
| delete | Marque de suppression | true or false | false | Non | Valable uniquement lors de la modification |
| sort_json | Nœuds de tri mixte | JSON array | `[{"type":"skill","id":2},{"type":"group","id":10}]` | Non* | Lorsqu'il est fourni, les paramètres CRUD sont ignorés et le plan de tri mixte est appliqué. Tri partiel pris en charge : les nœuds non spécifiés conservent leur ordre relatif |

Format de nœud `sort_json` :

| Champ | Signification | Valeurs |
| ----- | ------- | ------ |
| type | Type de nœud | `skill` / `group` |
| id | ID d'entité | number greater than 0 |

**Réponse:**

| Champ | Type | Description | Exemple | Notes |
| ----- | ---- | ----------- | ------- | ----- |
| id | Number | ID de groupe de Compétence | 10 | Renvoyé pour créer / modifier / supprimer |
| count | Number | Nombre de nœuds triés | 3 | Renvoyé pour les requêtes `sort_json` |

<br/>

### Paramètres de l'App

?> Requiert v1.98.0+

**Nom de la méthode:** app_settings

**Description:** Ajuste les paramètres de l'interface de l'App

**Exemples:**

- Activer le mode compact : [lifeup://api/app_settings?is_enable_compact_mode=true](lifeup://api/app_settings?is_enable_compact_mode=true)
- Activer le thème Material You : [lifeup://api/app_settings?is_enable_material_you=true](lifeup://api/app_settings?is_enable_material_you=true)
- Modifier les paramètres et redémarrer l'interface immédiatement : [lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true](lifeup://api/app_settings?is_enable_compact_mode=true&restart_activities=true)

| Paramètre              | Signification           | Valeurs          | Exemple | Obligatoire | Notes                           |
| --------------------- | ----------------- | --------------- | ------- | -------- | ------------------------------- |
| is_enable_compact_mode| Activer le mode compact| true or false  | true    | Non       | Simplifie les éléments de l'interface     |
| is_enable_material_you| Activer Material You| true or false  | true    | Non       | Active le thème Material You       |
| restart_activities    | Redémarrer l'interface | true or false   | true    | Non       | Applique les changements d'interface immédiatement |
| broadcast_event | Événements broadcast LifeUp Labs | true or false | true | Non | Désactivé par défaut. Même interrupteur que Paramètres → Labs |

**Réponse:**

| Champ  | Type    | Description  | Exemple | Notes                    |
| ------ | ------- | ------------ | ------- | ------------------------ |
| result | Integer | Code de résultat  | 0       | 0 indique le succès      |

<br/>

### Requête simple

!> Les fonctions de cette section sont destinées aux outils d'automatisation et au développement secondaire. Si vous devez interroger une liste complète de données, consultez [`LifeUp SDK`, `LifeUp Cloud`](https://github.com/Ayagikei/LifeUp-SDK) et [`LifeUp Desktop`.](https://github.com/Ayagikei/LifeUp-Desktop)

**Nom de la méthode:** query

**Description:** paramètres de requête

**Exemple:** - Interroger le nombre actuel de pièces : [lifeup://api/query?key=coin](lifeup://api/query?key=coin)
- Interroger l'interrupteur des événements broadcast : [lifeup://api/query?key=broadcast](lifeup://api/query?key=broadcast) → `{enabled}`

| Paramètre   | Signification              | Type                                                         | Exemple | Obligatoire                                    | Notes                                                        |
| ----------- | -------------------- | ------------------------------------------------------------ | ------- | ------------------------------------------- | ------------------------------------------------------------ |
| key         | type de requête        | Une seule des valeurs suivantes :<br/>coin<br/>atm<br/>item<br/>item_id_list<br/>tomato<br/>task<br/>broadcast | coin    | oui                                         | coin - montant actuel de pièces<br/>atm - solde actuel du distributeur<br/>item - informations de l'Objet pour l'`itemId` indiqué<br/>item_id_list - liste des IDs d'Objet pour le `categoryId` indiqué<br/>tomato - données tomate<br/>task - informations de Tâche (v1.101.0+)<br/>broadcast - interrupteur des événements broadcast Labs (`{enabled}`) |
| item_id     | id de l'Objet   | nombre supérieur à 0                                      | 1       | Lorsque key est `item`, obligatoire |                                                              |
| category_id | id de catégorie de la Boutique | nombre supérieur ou égal à 0                            | 0       | non*                                         | Obligatoire uniquement lorsque key est `item_id_list` ; représente l'ID de la liste à interroger. |
| task_id / taskId | ID de Tâche          | nombre supérieur à 0                                        | 1       | Lorsque key est `task`, l'un des trois* est obligatoire | ID de Tâche interrogée |
| task_gid / taskGid / task_group_id / taskGroupId | ID de groupe de Tâches | nombre supérieur à 0 | 1 | Lorsque key est `task`, l'un des trois* est obligatoire | ID de groupe de Tâches interrogé |
| task_name / taskName | Nom de Tâche      | texte quelconque                                                     | Study   | Lorsque key est `task`, l'un des trois* est obligatoire | Nom de Tâche avec correspondance floue |
| withSubTasks | Inclure les sous-tâches   | true or false                                                | true    | Non                                          | Disponible uniquement lorsque key est `task` ; true par défaut |

**Valeur de retour:**

Prise en charge depuis la version 1.90.2

Lors de l'interrogation coin/atm :

| Paramètre | Signification                             | Type               | Exemple | Obligatoire | Notes |
| --------- | ----------------------------------- | ------------------ | ------- | -------- | ----- |
| value     | Valeur numérique renvoyée par la requête | number             | 1000    | oui      |       |

Lors de l'interrogation d'un Objet :

| Paramètre        | Signification                         | Type     | Exemple   | Obligatoire | Notes |
| ---------------- | ------------------------------- | -------- | --------- | -------- | ----- |
| item_id          | id de l'Objet              | number   | 1         | oui      |       |
| name             | nom de l'Objet            | any text | Coffee    | oui      |       |
| desc             | description                     | any text |           | non       |       |
| icon             | URL de l'icône                        | any text | icon.webp | non       | S'il s'agit d'un fichier local, seul le nom du fichier est renvoyé |
| category_id      | id de catégorie                | number   | 1         | oui      |       |
| stock_number     | stock de la Boutique             | number   | -1        | oui      | `-1` représente un stock illimité dans la Boutique |
| own_number       | quantité dans l'Inventaire | number   | 10        | oui      |       |
| price            | prix                       | number   | 100       | oui      |       |
| order            | ordre                         | number   | 100       | oui      | Valeur de poids lors du tri personnalisé |
| disable_purchase | Désactiver l'achat     | true or false | true | oui |       |
| purchase_limit   | Règles de restriction               | JSON text | [{"limitType":0,"limitNumber":5}] | oui | Liste de restrictions actuelle |
| limit_scope      | Portée de restriction               | purchase / use / both | use | oui | Renvoyé comme valeur texte de l'API |

Lors de l'interrogation item_id_list :

| Paramètre | Signification                           | Type   | Exemple | Obligatoire | Notes |
| --------- | --------------------------------- | ------ | ------- | -------- | ----- |
| item_ids  | Tableau d'IDs d'Objet séparés par des virgules     | string | 1,2,3,4 | oui      |       |

Lors de l'interrogation tomato :

| Paramètre | Signification                  | Type   | Exemple | Obligatoire | Notes |
| --------- | ------------------------ | ------ | ------- | -------- | ----- |
| total     | Nombre total de tomates       | number | 100     | oui      |       |
| available | Tomates disponibles   | number | 50      | oui      |       |
| exchanged | Tomates échangées   | number | 50      | oui      |       |

Lors de l'interrogation task (v1.101.0+) :

| Paramètre   | Signification                      | Type        | Exemple | Obligatoire | Notes                           |
| ----------- | ---------------------------- | ----------- | ------- | -------- | ------------------------------- |
| _ID         | ID de Tâche                      | number      | 1       | oui      | -                               |
| _GID        | ID de groupe de Tâches                | number      | 1       | oui      | -                               |
| name        | Nom de Tâche                    | text        | Study   | oui      | -                               |
| notes       | Notes                        | text        | -       | non       | Peut être vide                    |
| status      | Statut de la Tâche                  | number      | 0       | oui      | 0=incomplète, 1=terminée       |
| startTime   | Heure de début                   | number      | -       | oui      | Horodatage Unix (millisecondes)   |
| deadline    | Date limite                | number      | -       | non       | Horodatage Unix (millisecondes), peut être vide |
| remindTime  | Heure de rappel                  | number      | -       | non       | Horodatage Unix (millisecondes), peut être vide |
| frequency   | Fréquence de répétition         | number      | -       | oui      | -                               |
| weekdays    | Jours de la semaine                     | text        | 1,3,5   | non       | v1.106.0+ ; vide hors mode jours de semaine. 1=lundi … 7=dimanche |
| exp         | Récompense de Points d'Expérience                   | number      | -       | oui      | -                               |
| skillIds    | Liste d'IDs de Compétence                | JSON text   | -       | oui      | Format de tableau JSON               |
| coin        | Récompense en pièces                  | number      | -       | non       | Peut être vide                    |
| coinVariable| Récompense aléatoire en pièces           | number      | -       | non       | Peut être vide                    |
| itemId      | ID du premier Objet de Récompense         | number      | -       | non       | Peut être vide                    |
| itemCount   | Quantité du premier Objet de Récompense      | number      | -       | non       | Renvoyé lorsque itemId existe     |
| items       | Liste de Récompenses d'Objets             | JSON text   | -       | oui      | Format de tableau JSON               |
| words       | Mots d'encouragement à la finalisation   | text        | -       | non       | Peut être vide                    |
| categoryId  | ID de catégorie                  | number      | -       | non       | Peut être vide                    |
| order       | Ordre                        | number      | -       | oui      | -                               |
| name_extended | Nom étendu              | text        | -       | oui      | Identique à name                    |
| subTasks    | Liste de sous-tâches                | JSON text   | -       | oui      | Format de tableau JSON, voir ci-dessous    |

**Description du champ sous-tâches (subTasks) :**

Le champ `subTasks` est un tableau JSON ; chaque élément contient les champs suivants :

- `id` : ID de sous-tâche
- `gid` : ID de groupe de sous-tâche
- `todo` : Contenu de la sous-tâche
- `status` : Statut de la sous-tâche (0=incomplète, 1=terminée)
- `remindTime` : Heure de rappel (horodatage Unix, millisecondes)
- `exp` : Récompense de Points d'Expérience
- `coin` : Récompense en pièces
- `coinVariable` : Récompense aléatoire en pièces
- `items` : Liste de Récompenses d'Objets
- `order` : Ordre
- `autoUseItem` : Utiliser automatiquement l'Objet

<br/>

### Requête Attributs :id=query_skill

!> Les fonctions de cette section sont destinées aux outils d'automatisation et au développement secondaire.

**Nom de la méthode:** query_skill

**Description:** Interroge les informations de base, les champs de tri bruts et les données de Niveau/expérience d'une Compétence spécifiée.

Vous pouvez utiliser cette API pour personnaliser vos widgets d'Attributs.

**Exemple:**

- Interroger l'Attribut force : [lifeup://api/query_skill?id=1](lifeup://api/query_skill?id=1)

| Paramètre | Signification              | Type                    | Exemple | Obligatoire | Notes |
| --------- | -------------------- | ----------------------- | ------- | -------- | ----- |
| id        | id d'Attribut (Compétence) | nombre supérieur à 0 | 1       | oui      | Pour savoir comment l'obtenir, consultez la section « Basics - LifeUp Data ID » ci-dessus |

**Valeur de retour:**

Prise en charge depuis la version 1.90.6

| Paramètre            | Signification                              | Type   | Exemple  | Obligatoire | Notes |
| -------------------  | ------------------------------------ | ------ | -------- | -------- | ----- |
| id                   | id de Compétence                             | number | 1        | oui      | Ajouté à `query_skill` en v1.103.0+ |
| name                 | nom de l'Attribut                       | string | strength | oui      |       |
| order                | ordre de tri brut                       | number | 20       | oui      | Ajouté en v1.103.0+ ; `orderInCategory` |
| group_id             | ID de groupe de Compétences                       | number | 10       | oui      | Ajouté en v1.103.0+ ; renvoie `0` lorsque la Compétence n'est pas dans un groupe |
| status               | statut                               | number | 0        | oui      | Ajouté en v1.103.0+ ; `0` = normal, `1` = masqué |
| level                | Niveau                                | number | 10       | oui      |       |
| total_exp            | Points d'Expérience totaux              | number | 10000    | oui      |       |
| until_next_level_exp | Points d'Expérience requis pour le Niveau suivant | number | 99       | oui      |       |
| current_level_exp    | Points d'Expérience gagnés au-delà du Niveau actuel       | Number | 1000     | Oui      |       |

<br/>

### Requête groupe de Compétences :id=query_skill_group

Requiert v1.103.0+

**Nom de la méthode:** query_skill_group

**Description:** Interroge un groupe de Compétences unique et renvoie son ordre brut et son état replié.

**Exemple:**

- Interroger un groupe de Compétences : [lifeup://api/query_skill_group?id=10](lifeup://api/query_skill_group?id=10)

| Paramètre | Signification | Type | Exemple | Obligatoire | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID de groupe de Compétences | number greater than 0 | 10 | oui | - |

**Valeur de retour:**

| Paramètre | Signification | Type | Exemple | Obligatoire | Notes |
| --------- | ------- | ---- | ------- | -------- | ----- |
| id | ID de groupe de Compétences | number | 10 | oui | - |
| content | Nom du groupe | string | Combat | oui | - |
| order | Ordre de tri brut | number | 20 | oui | `orderInCategory` |
| collapsed | État replié | string | true | oui | Renvoyé sous forme de texte `true` / `false` |

<br/>

<br/>

### Interface spéciale

#### Aléatoire

?> Cette API est disponible depuis v1.93.0.

**Nom de la méthode:** random

**Description:** Interface aléatoire simple qui peut déclencher l'une de plusieurs APIs au hasard.

**Exemple:**

- Probabilité égale d'afficher aléatoirement `scissors`, `rock` ou `paper` : [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper)

- 90 % de probabilité d'afficher `rock`, 5 % pour `scissors` et 5 % pour `paper` : [lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5](lifeup://api/random?api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dscissors&api=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dpaper&weight=90&weight=5&weight=5)

| Paramètre | Signification    | Valeurs                 | Exemple                                | Obligatoire | Notes |
| --------- | ---------- | ---------------------- | -------------------------------------- | -------- | ----- |
| api       | API aléatoire | Any text               | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Drock | Oui      | Prend en charge l'appel sous forme de tableau (c'est-à-dire plusieurs paramètres api, comme dans les exemples ci-dessus) |
| weight    | Poids     | Numbers greater than 0 | 1                                      | Non       | Prend en charge l'appel sous forme de tableau.<br/><br/>Si weight n'est pas spécifié, tous les poids sont égaux (probabilité uniforme).<br/>Si des poids sont spécifiés, ils sont assignés séquentiellement : p. ex., le premier poids correspond au premier paramètre api.<br/><br/>**Assurez-vous que le nombre de paramètres weight correspond au nombre de paramètres api, sinon cela peut ne pas prendre effet.** |

<br/>

#### Dialogue de confirmation

**Nom de la méthode:** confirm_dialog

**Description:** Affiche une fenêtre de sélection contextuelle. Vous pouvez personnaliser le titre, le texte, le bouton positif et le bouton négatif. D'autres interfaces peuvent aussi être appelées lors du clic sur un bouton.

**Exemple:**

- [<a href="lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe">lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe</a>](lifeup://api/confirm_dialog?title=Do you believe in love&positive_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dbelieve&negative_action=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Ddo not believe)
- Autres scénarios d'utilisation :
  - Choix de Récompenses
  - Sélection de branche d'événement

| Paramètre       | Signification              | Type     | Exemple  | Obligatoire | Notes |
| --------------- | -------------------- | -------- | -------- | -------- | ----- |
| title           | titre de la fenêtre contextuelle          | any text | Title    | oui      |       |
| message         | description détaillée de la fenêtre contextuelle | any text | This is the content of the popup window | non |  |
| positive_text   | texte du bouton positif | any text | YES      | non       |       |
| negative_text   | texte du bouton négatif | any text | NO       | non       |       |
| neutral_text    | texte du bouton neutre  | any text | QUESTION | non       |       |
| positive_action | réponse de lien du bouton positif | URL (other interface) | lifeup:%2F%2Fapi%2Ftoast%3Ftext%3D You clicked OK | non | Il s'agit en fait du texte échappé de l'interface de message contextuel. Pour les règles d'échappement, consultez « Basics - Escaping (URL Encode) ». |
| negative_action | réponse de lien du bouton négatif | URL (other interface) | Identique ci-dessus | non |  |
| neutral_action  | réponse de lien du bouton neutre  | URL (other interface) | Identique ci-dessus | non |  |
| cancel_action   | réponse de lien de l'action annuler   | URL (other interface) | Identique ci-dessus | non |  |

<br/>

#### Sans action

**Nom de la méthode:** placeholder

**Note:** Cette interface ne traite aucune logique en elle-même, mais vous pouvez l'utiliser avec callback et broadcast.

**Exemple:**

- [lifeup://api/placeholder?broadcast=app.lifeup.item.rest](lifeup://api/placeholder?broadcast=app.lifeup.item.rest)

<br/>

#### Espace réservé variable

`LifeUp` propose des méthodes d'intervention utilisateur pour les paramètres.

| Espace réservé                          | Signification                                                      | Exemple                                                      |
|--------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| [$text\|title]                       | Espace réservé texte                                             | [$text\|Enter task name]                                     |
| [$number\|Title]                     | Espace réservé numérique (sans décimale)                   | [$number\|Enter price]                                       |
| [$number\|Title\|signed]             | Espace réservé numérique (sans décimale), afficher le signe        | [$number\|Enter price\|signed]                               |
| [$decimal\|title]                    | Espace réservé numérique (avec décimale)                      | [$decimal\|Enter ATM rate]                                   |
| [$decimal\|title\|signed]            | Espace réservé numérique (avec décimale), afficher le signe           | [$decimal\|Enter ATM rate\|signed]                           |
| [$item]                              | Sélectionner un Objet ; remplacé par l'id de l'Objet              | [$item]                                                      |
| [$task_category]                     | Sélectionner une liste de Tâches ; remplacée par l'id de la liste    | [$task_category]                                             |
| [$time\|Anchor Time\|Offset in Milliseconds(optional)] | Espace réservé horaire<br/><br/>Valeurs possibles pour Anchor Time :<br/>`current`, `today`, `this_monday`, `last_monday`, `this_month`, `last_month`, `this_year`, `last_year` <br/><br/>Le décalage en millisecondes doit être un entier ; 0 millisecondes par défaut | Minuit aujourd'hui : [$time\|today]<br/>Minuit demain : [$time\|today\|86400000] |
| [$random_number\|Min\|Max]           | Espace réservé nombre aléatoire (sans décimale)             | [$random_number\|0\|3000]                                    |
| [$random_decimal\|Min\|Max]          | Espace réservé nombre aléatoire (avec décimale)                | [$random_decimal\|1.0\|2.0]                                  |

**Exemple 1 : lors de l'utilisation, sélectionner un Objet pour réduire le prix de 1 pièce**

Par exemple, après avoir configuré l'API de réduction de prix d'un Objet spécifique de la Boutique, vous pouvez vouloir laisser l'utilisateur choisir l'Objet lors de l'appel au lieu de prédéfinir l'id.

L'API suivante ne peut réduire que de 1 pièce le prix de l'Objet de la Boutique avec l'id 1 :

````url
lifeup://api/item?id=1&set_price=-1&set_price_type=relative
````

Il suffit de remplacer l'id de l'Objet par l'espace réservé [$item] ; lors de l'appel, l'utilisateur peut activement sélectionner l'Objet dont il souhaite réduire le prix :

<a href="lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative">lifeup://api/item?id=[$item]&set_price=-1&set_price_type=relative</a>

**Exemple 2 : modèle de Tâche — saisissez simplement le nom de la Tâche et la liste pour créer un modèle de Récompense prédéfini**

<a href="lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]">lifeup://api/add_task?todo=[$text|Enter a task name]&notes=This is a reward template for a task&coin=10&coin_var=10&exp=2048&skills=1&skills=2&skills=3&category=[$task_category]]</a>

<br/>

#### Callback de fin

Vous pouvez ajouter le paramètre callback à toutes les interfaces pour rappeler l'URL après l'appel.

Cela sert aussi à enchaîner plusieurs interfaces ; par exemple, si vous voulez un message après le saut :

lifeup://api/goto?page=lab + lifeup://api/toast?text=callback

Vous pouvez utiliser le paramètre callback. Consultez aussi la section **Basics - Escaping (URL Encode)** ci-dessus. Vous pouvez écrire ce type de traitement :

<a href="lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback">lifeup://api/goto?page=lab&callback=lifeup:%2F%2Fapi%2Ftoast%3Ftext%3Dtest callback</a>

Bien entendu, vous pouvez aussi ajouter plusieurs liens à un Objet de la Boutique pour obtenir le même effet.

De plus, ce callback est surtout utilisé pour :

application X → LifeUp → application X

ou

application X → LifeUp → application Y

<br/>

#### Valeur de retour par broadcast

!> Les fonctions de cette section sont destinées aux outils d'automatisation et au développement secondaire, et comportent une certaine courbe d'apprentissage.

En ajoutant ce paramètre, la valeur de retour d'origine de l'API peut aussi être envoyée par broadcast, afin que des outils d'automatisation tels que Tasker puissent la recevoir.

La valeur de broadcast équivaut à celle de la colonne d'action « Intent Received » dans Tasker. Vous pouvez saisir n'importe quel texte, tant que les deux correspondent.

**Par exemple, utiliser l'API d'interrogation des pièces d'or avec Tasker ([si vous utilisez MacroDroid, consultez ce lien.](https://github.com/Ayagikei/LifeUp/issues/43)) :**

[lifeup://api/query?key=coin](lifeup://api/query?key=coin)

1. Ajoutez le paramètre broadcast pour envoyer la valeur de retour à Tasker ; ce peut être n'importe quel texte, comme `app.lifeup.query.coin`.

   [lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin](lifeup://api/query?key=coin&broadcast=app.lifeup.query.coin)

2. Ajoutez un événement dans Tasker → « Intent Received », et saisissez `app.lifeup.query.coin` dans la colonne d'action.

3. La tâche Tasker peut alors recevoir la valeur de retour de `value` sous la forme d'une variable `%value`.

4. Vous pouvez ensuite évaluer dans Tasker le nombre de pièces d'or pour produire divers effets. (Par exemple, changer le fond d'écran du bureau selon le nombre de pièces ?)

![](_media/api/broadcast_01.png ':size=30%')

![](_media/api/broadcast_02.png ':size=30%')

![](_media/api/broadcast_03.png ':size=30%')

![](_media/api/broadcast_04.png ':size=30%')

<br/>

---

## Notification d'événements broadcast

!> Les fonctions de cette section sont destinées aux outils d'automatisation et au développement secondaire.

> Depuis la version 1.90.2, nous diffusons divers événements vers l'extérieur. Vous pouvez utiliser des outils d'automatisation tels que Tasker pour les recevoir et déclencher des actions Tasker.
>
### Activer

**Par défaut, les événements broadcast sont désactivés.**

Vous pouvez les activer dans `Paramètres` → `Labs` → `Mode développeur` → `Événements broadcast`.

### Exemple : changer le fond d'écran avec un Objet

1. Créez un Objet nommé « Change Wallpaper ».
2. Dans Tasker, allez dans `Configuration file` → `Event` → `System` → `Intent Received`, saisissez `app.lifeup.item.use` dans la colonne d'opération, puis revenez.
3. Cliquez sur New Task et saisissez un nom quelconque (par exemple, change wallpaper).
4. Cliquez sur le signe + en bas à droite pour ajouter une tâche, sélectionnez `Task` → `If`
5. Ajustez la colonne de condition à `%name eq change wallpaper`.
6. Revenez en arrière ; dans `Insert Action`, sélectionnez `If`.
7. Cliquez à nouveau sur le signe + en bas à droite, sélectionnez `Display` → `Set Wallpaper`
8. (Facultatif) Remplacez `Type` par `All`
9. Dans la colonne image, cliquez sur l'icône 🔍 et sélectionnez le fichier de fond d'écran souhaité
10. Quittez et vérifiez que cette configuration est activée.
11. Utilisez l'Objet « Wallpaper Change » dans `LifeUp` ; le fond d'écran devrait changer avec succès

![](_media/api/broadcast_sample_01.png ':size=30%')

![](_media/api/broadcast_sample_02.png ':size=30%')

![](_media/api/broadcast_sample_03.png ':size=30%')

![](_media/api/broadcast_sample_04.png ':size=30%')

Utiliser `Sans action` + `Valeur de retour par broadcast` permet d'obtenir cet effet de façon plus concise ; vous pouvez l'explorer.

<br/>

### Tâche terminée

**Nom:** app.lifeup.task.complete

**Valeur de retour:**

| Paramètres  | Signification          | Exemples        |
| ----------- | ---------------- | --------------- |
| task_id     | id de Tâche          | 1               |
| task_gid    | id de groupe de Tâches    | 1               |
| name        | nom de Tâche        | Getting started |
| category_id | id de catégorie de Tâche | 1               |

### Tâche abandonnée

**Nom:** app.lifeup.task.giveup

**Valeur de retour:**

| Paramètres  | Signification          | Exemples        |
| ----------- | ---------------- | --------------- |
| task_id     | id de Tâche          | 1               |
| task_gid    | id de groupe de Tâches    | 1               |
| name        | nom de Tâche        | Getting started |
| category_id | id de catégorie de Tâche | 1               |

### Tâche en retard

**Nom:** app.lifeup.task.overdue

**Valeur de retour:**

| Paramètres | Signification                 | Exemples                        |
| ---------- | ----------------------- | ------------------------------- |
| task_ids   | **tableau** d'ids de Tâche       | [1, 2, 3]                       |
| task_gids  | **tableau** d'ids de groupe de Tâches | [1, 2, 3]                       |
| names      | **tableau** de noms de Tâche     | [Getting started, Drink Waters] |
| task_ids_json  | **tableau Json** d'ids de Tâche   | [1, 2, 3]                       |
| task_gids_json | **tableau Json** d'ids de groupe de Tâches | [1, 2, 3]                       |
| names_json     | **tableau Json** de noms de Tâche | ["Getting started", "Drink Waters"]                      |

### Succès débloqué

**Nom:** app.lifeup.achievement.unlock

**Valeur de retour:**

| Paramètres     | Signification          | Exemples                 |
| -------------- | ---------------- | ------------------------ |
| achievement_id | id de Succès   | 1                        |
| name           | nom de Succès | Using LifeUp for 30 days |

### Objets achetés

**Nom:** app.lifeup.item.purchase

**Valeur de retour:**

| Paramètres | Signification           | Exemples          |
| ---------- | ----------------- | ----------------- |
| item_id    | id d'Objet           | 1                 |
| name       | nom d'Objet         | Break 10 branches |
| amount     | quantité achetée | 1                 |

### Objet utilisé

**Nom:** app.lifeup.item.use

**Description:** Envoyé lorsqu'un usage normal d'Objet ou un flux d'utilisation de Synthèse simple réussit.

**Valeur de retour:**

| Paramètres | Signification      | Exemples          |
| ---------- | ------------ | ----------------- |
| item_id    | id d'Objet      | 1                 |
| name       | nom d'Objet    | Break 10 branches |
| amount     | quantité utilisée | 1                 |

### Synthèse terminée

> [!NOTE]
> Cet événement broadcast est disponible depuis v1.102.8.

**Nom:** app.lifeup.synthesis.complete

**Description:** Envoyé lorsqu'une Synthèse de recette se termine avec succès.

**Valeur de retour:**

| Paramètres   | Signification                            | Exemples                                              |
| ------------ | ---------------------------------- | ----------------------------------------------------- |
| formula_id   | id de formule                         | 1                                                     |
| formula_name | nom de formule                       | Toolbox Recipe                                        |
| times        | nombre d'exécutions                    | 3                                                     |
| input_count  | nombre d'entrées d'Objet en entrée       | 2                                                     |
| output_count | nombre d'entrées d'Objet en sortie      | 1                                                     |
| inputs_json  | tableau JSON de toutes les entrées consommées  | [{"item_id":7,"name":"Wood","amount":6}]              |
| outputs_json | tableau JSON de toutes les sorties produites | [{"item_id":9,"name":"Toolbox","amount":3}]           |

**Notes:**

- Cet événement n'est envoyé qu'après une Synthèse réussie.
- Si les matériaux sont insuffisants, la formule n'existe pas, l'enregistrement échoue ou `Événements broadcast` est désactivé, cet événement n'est pas envoyé.
- Un seul appel API envoie un seul événement même si `times > 1`.
- Dans `inputs_json` et `outputs_json`, chaque élément utilise la structure suivante :

```json
{
  "item_id": 7,
  "name": "Wood",
  "amount": 6
}
```

- `amount` est le **total consommé / total produit** lors de cette exécution, et non la quantité par formule.

### Émotions ajoutées / mises à jour

**Nom:** app.lifeup.feelings.add

**Valeur de retour:**

| Paramètres | Signification | Exemples |
| --- | --- | --- |
| feelings_id | id d'Émotion | 1 |
| action_type | `add` ou `update` | add |
| content | texte de l'Émotion | Feeling good today! |
| create_time | horodatage de création (ms) | 1642060800000 |
| relate_type | type d'objet associé | 0 |
| related_id | id d'objet associé | 1 |
| attachments_count | nombre de pièces jointes | 2 |
| attachments | tableau de chemins de pièces jointes | ["/path/1", "/path/2"] |

### Montée de Niveau

**Nom:** app.lifeup.level.up

**Valeur de retour:**

| Paramètres | Signification       | Exemples |
| ---------- | ------------- | -------- |
| skill_id   | id de Compétence       | 1        |
| name       | nom          | strength |
| level      | Niveau actuel | 2        |

### Descente de Niveau

**Nom:** app.lifeup.level.down

**Valeur de retour:**

| Paramètres | Signification       | Exemples |
| ---------- | ------------- | -------- |
| skill_id   | id de Compétence       | 1        |
| name       | nom          | strength |
| level      | Niveau actuel | 2        |

### Compte à rebours d'Objet de la Boutique

**Nom:**

- Début : app.lifeup.item.countdown.start
- Arrêt : app.lifeup.item.countdown.stop
- Fin : app.lifeup.item.countdown.complete

**Valeur de retour:**

| Paramètres | Signification                       | Exemples                  |
| ---------- | ----------------------------- | ------------------------- |
| item_id    | id d'Objet                       | 1                         |
| name       | nom d'Objet                     | play games for 30 minutes |
| time_left  | temps restant (millisecondes) | 30000                     |

### Cycle de vie Pomodoro

?> Cet événement broadcast est disponible depuis v1.101.0 et fournit des données d'événement plus riches.

**Nom:**

- Début : app.lifeup.pomodoro.start
- Pause : app.lifeup.pomodoro.pause (nouveau en v1.101.0)
- Arrêt : app.lifeup.pomodoro.stop
- Fin : app.lifeup.pomodoro.complete

**Description:** Lorsque le minuteur Pomodoro démarre, se met en pause, s'arrête ou se termine, le système envoie les événements broadcast correspondants avec les informations de Tâche, l'état du minuteur et d'autres données détaillées.

**Valeur de retour:**

| Paramètre          | Signification                       | Exemple        | Notes                                                      |
| ------------------ | ----------------------------- | -------------- | ---------------------------------------------------------- |
| task_id            | ID de Tâche                       | 1              | Facultatif ; existe uniquement lorsque le Pomodoro est associé à une Tâche |
| task_gid           | ID de groupe de Tâches                 | 1              | Facultatif ; existe uniquement lorsque le Pomodoro est associé à une Tâche |
| name               | Nom de Tâche                     | Study English  | Nom de Tâche associé au Pomodoro ou nom personnalisé         |
| service_type       | Type de service                  | 0              | 0=Concentration, 1=pause courte, 2=pause longue                      |
| service_type_label | Libellé du type de service            | Focus          | Texte localisé du type de service                                |
| duration           | Durée totale (millisecondes) | 1500000        | Durée totale de Concentration ou de pause                           |
| remaining          | Durée restante (millisecondes) | 900000     | Durée restante actuelle                                 |
| elapsed            | Durée écoulée (millisecondes) | 600000       | Temps écoulé                                           |
| start              | Heure de début                    | 1639123456789  | Horodatage Unix (millisecondes)                              |
| event_time         | Heure de déclenchement de l'événement            | 1639123456789  | Horodatage Unix (millisecondes)                              |
| reason             | Motif d'arrêt                   | user           | Uniquement pour l'événement stop ; valeurs possibles : manual, cancel, complete, auto |

**Description du motif d'arrêt:**

Le paramètre `reason` n'existe que dans l'événement `app.lifeup.pomodoro.stop` et indique la raison de l'arrêt du Pomodoro :

- `manual` : arrêt manuel par l'utilisateur
- `cancel` : annulation par l'utilisateur
- `complete` : terminé normalement (note : à la fin, l'événement `app.lifeup.pomodoro.complete` est aussi déclenché)
- `auto` : arrêt automatique (p. ex., Tâche supprimée)

### Cycle de vie du chronomètre ascendant :id=broadcast_positive_timing

> [!NOTE]
> Ces événements concernent la fonctionnalité de chronomètre ascendant, et non les événements de compte à rebours Pomodoro ci-dessus. Avant de les utiliser, assurez-vous que `Paramètres` → `Labs` → `Mode développeur` → `Événements broadcast` est activé.

**Nom:**

- Début : app.lifeup.timing.start
- Pause : app.lifeup.timing.pause
- Fin : app.lifeup.timing.complete
- Abandon : app.lifeup.timing.abandon

**Description:** Lorsqu'un chronomètre ascendant démarre, se met en pause, se termine ou est abandonné manuellement, LifeUp envoie le broadcast correspondant. `complete` signifie que la session s'est terminée normalement et a été enregistrée. `abandon` signifie que la session en cours a été arrêtée ou abandonnée manuellement.

**Valeur de retour:**

| Paramètres | Signification                        | Exemples      | Notes                                            |
| ---------- | ------------------------------ | ------------- | ------------------------------------------------ |
| task_id    | ID de Tâche                        | 1             | Facultatif ; présent uniquement lorsque le minuteur est lié à une Tâche |
| name       | Nom de Tâche                      | Study English | Nom de Tâche liée ou nom personnalisé du minuteur          |
| time       | Durée accumulée (ms)      | 600000        | Durée totale écoulée du chronomètre ascendant actuel |
| start      | Heure de début                     | 1639123456789 | Horodatage Unix (millisecondes)                    |
| end        | Heure de fin                       | 1639127056789 | Présent uniquement dans les événements `complete` / `abandon`    |

---

## Intégration

Nous accueillons avec plaisir toute forme d'intégration de la part d'autres développeurs.

> Plus de détails seront bientôt disponibles...

### Besoin de plus d'API ?

Les fonctionnalités API ne sont encore qu'à une itération de version.

À l'avenir, nous continuerons d'ajouter des APIs pour couvrir davantage de scénarios d'utilisation.

Si vous avez besoin de plus d'API, vous pouvez ouvrir des Issues sur [Github](https://github.com/Ayagikei/LifeUp/issues/new/choose).

<br/>

### Comment appeler

#### Android

##### Utiliser le SDK

Consultez le module `core` sur : https://github.com/Ayagikei/LifeUp-SDK.

##### Sans utiliser le SDK

```kotlin
    /**
    * Define a method to handle the uri
    */
    private fun call(context: Context, uriString: String){
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(uriString)
            }
            context.startActivity(intent)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

fun xxx() {
        ...
        // Then call it where appropriate
        call(context, "lifeup://api/toast?text=You+learned+to+call!&type=1&isLong=true")
        ...
    }
````

<br/>

#### Page web

Si l'appel provient d'une page web, son déclenchement dépend du navigateur. Les navigateurs courants tels que Quark, Chrome et Edge conviennent. Mais certains navigateurs intégrés au système peuvent demander à l'utilisateur « s'il souhaite ouvrir Rensheng » à chaque apparition.

Si vous développez votre propre application WebView intégrée, vous devez vous assurer que le WebView peut gérer le schéma lifeup.

Pour une expérience cohérente, vous pouvez utiliser l'effet de lien produit dans `LifeUp` et cocher « Use built-in browser » pour l'ouvrir. En raison des paramètres de sécurité, cette méthode ne prend en charge que les liens HTTPS (pas HTTP).

**HTML**

Accédez directement à l'hyperlien

````htm
<a href="lifeup://api/toast?text=You learned to call!&type=1&isLong=true" target="_blank" rel="noopener">Click here to call</a>
````

**Javascript**

En fait, il s'agit aussi d'un hyperlien

````javascript
location.href='lifeup://api/reward?type=coin&content=consolation+prize&number=1'
````

<br/>

### Développeur d'application/web/automatisation

Faites-nous savoir si vous avez développé quelque chose en lien avec LifeUp !

<br/>

### Tout langage/plateforme prenant en charge le protocole HTTP

Pour plus de détails, consultez https://github.com/Ayagikei/LifeUp-SDK et [LifeUp Cloud - HTTP APIs - Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http).

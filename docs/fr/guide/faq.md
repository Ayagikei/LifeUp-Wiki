# FAQ

LifeUp est maintenue par deux coéquipiers indie sur leur temps libre :

- Un développeur s'occupe principalement de l'App.
- Un coéquipier se concentre sur les services backend et les opérations.

## Derrière l'app indie

Au lancement de LifeUp en 2020, les apps indie étaient encore relativement rares. En 2026, développeurs et apps indie sont partout — et c'est une bonne chose.

Mais nous avons aussi vu beaucoup de tendances peu recommandables : sortir une nouvelle app tous les mois ou deux puis l'abandonner après le lancement ; des apps entièrement construites avec du code généré par IA, sans vraie ingénierie derrière, pleines de bugs, aux performances médiocres et impossibles à maintenir ; des prix agressifs portés par le hype qui passent de dizaines à centaines de dollars avant même que l'app soit terminée, avec des messages urgents sur les forums poussant à acheter un abonnement « à vie » avant qu'il ne soit trop tard ; ou des apps qui encaissent un abonnement à vie en v1, le maintiennent à peine, puis « ressuscitent » soudain en v2.0 pour revendre des abonnements à vie — pour finir par rester sans maintenance, se casser ou être retirées, rendant ces abonnements à vie sans valeur.

En revanche, LifeUp est construite par des développeurs soucieux de la maintenance à long terme : ~6 ans d'itération continue avec plus de 400 versions. Nous sommes restés sur le modèle d'achat unique, et nos tarifs sont restés bien en dessous de la plupart des apps comparables, même après des ajustements modestes au fil des ans. LifeUp propose aussi de façon unique une [API](/guide/api.md) et un [client de bureau open source](/guide/api_desktop.md), pour intégrer LifeUp dans vos propres flux de travail avec l'IA et vos compétences de développement — ou même construire par-dessus. LifeUp prend aussi en charge des sauvegardes avec export complet des données, incluant vos fichiers média d'origine et une base SQLite — vous restez ainsi propriétaire et maître de vos données. Vous pouvez les convertir vers des formats compatibles avec d'autres apps, faire analyser les données par l'IA pour générer des graphiques, et plus encore (le tout est aussi possible — et plus direct — via l'API). Vous pouvez même importer votre sauvegarde directement dans [ulives](https://app.ulives.io/), notre nouvelle app iOS.

Certaines fonctionnalités et détails d'interface sont encore en cours de peaufinage, et nous les améliorons pas à pas.

Si LifeUp vous aide, la partager avec d'autres nous aide aussi beaucoup.

Si vous souhaitez soutenir le développement, vous pouvez aussi nous offrir un café depuis la page **About** de l'App.

## ⚙️ Configuration de compatibilité

Si vous rencontrez des problèmes comme :

- des rappels qui ne se déclenchent pas
- des rappels Pomodoro ou des comptes à rebours d'Objets qui ne fonctionnent pas en arrière-plan
- des actions de widget qui échouent (par exemple, impossible de cocher des Tâches de comptage)
- des problèmes d'actualisation du widget

consultez le guide de compatibilité :

> [!WARNING]
> [Configuration de compatibilité](/guide/compatibility.md)

## 🌍 Général

<details>
<summary>Politique de remboursement</summary>

LifeUp est actuellement listée comme app payante sur Google Play pour des raisons historiques, ce qui complique la migration vers un modèle de paiement après téléchargement.

Google Play peut rembourser automatiquement votre commande si vous désinstallez peu après l'achat.

Si ce remboursement automatique n'a pas lieu, contactez-nous dans les **7 jours** à [lifeup@ulives.io](mailto:lifeup@ulives.io).
Indiquez votre numéro de commande GPA et envoyez l'e-mail depuis le même compte Google utilisé pour l'achat.

Pour des raisons anti-abus, nous ne pouvons assurer le remboursement manuel qu'**une seule fois par utilisateur**.
Nous ne pouvons pas traiter les demandes de remboursement après 7 jours à compter de la date d'achat.

Note : les avis Google Play ne contiennent pas assez de détails sur la commande pour gérer un remboursement.

</details>

<details>
<summary>Mes données sont-elles privées et sécurisées ?</summary>

Oui. Nous prenons la confidentialité au sérieux.

La plupart des données restent sur votre appareil et ne transitent pas par nos serveurs.

La principale exception est le module Monde, où les utilisateurs peuvent partager publiquement des designs et des modèles.
Tout partage là-bas est opt-in : rien n'est publié tant que vous ne choisissez pas de le partager, et vous pouvez supprimer le contenu partagé à tout moment.

Pour en savoir plus, consultez notre [Politique de confidentialité](https://wiki.lifeupapp.fun/en/#/introduction/privacy-terms).

</details>

<details>
<summary>Comment sauvegarder mes données si les serveurs ne les stockent pas ?</summary>

LifeUp prend en charge l'export/import de sauvegardes et des cibles de sauvegarde de type cloud.

Vous pouvez utiliser :
- des fichiers de sauvegarde exportés
- WebDAV
- Google Drive
- Dropbox

</details>

<details>
<summary>Pourquoi n'y a-t-il pas la langue XX ? Ou pourquoi la traduction est-elle incomplète et affichée en anglais ?</summary>

La plupart des langues dans *LifeUp* sont maintenues par la communauté.

À partir de 2026, nous utiliserons la traduction IA pour les langues principales afin d'améliorer la qualité de base et d'accélérer les mises à jour.

Les relectures et corrections de la communauté restent les bienvenues.

Vous pouvez contribuer ici : [Crowdin - LifeUp](https://crowdin.com/project/lifeup).

</details>

<details>
<summary>Puis-je masquer le module Monde si je n'en ai pas besoin ?</summary>

Oui.

Vous pouvez personnaliser la barre de navigation inférieure dans :
`barre latérale` → `Paramètres` → `Affichage` → `Configuration du module`.

De là, vous pouvez masquer le module Monde ou le remplacer par un autre module.

</details>

<details>
<summary>Le podomètre est imprécis, ou je n'ai pas besoin de ce module ?</summary>

> Vous pouvez appuyer sur la petite icône point d'interrogation à côté du podomètre dans l'App pour voir comment il fonctionne.

- Pour une meilleure précision, ouvrez l'App le matin et le soir, et évitez les redémarrages fréquents de l'appareil.
- Vous pouvez aussi saisir le nombre de pas manuellement.
- Si vous n'en avez pas besoin, masquez le podomètre dans `Paramètres` → `Affichage`.

</details>

## ✅ Tâches

<details>
<summary>Puis-je masquer la boîte de dialogue de Récompense à l'achèvement d'une Tâche ?</summary>

Oui. Dans le flux normal d'achèvement, la boîte de dialogue de Récompense n'apparaît que lorsqu'une Tâche a des Récompenses configurées, comme des Points d'Expérience (XP) ou des Objets. Si vous laissez les Récompenses non définies, l'achèvement de la Tâche n'affichera pas cette boîte de dialogue.

Nous recommandons aussi de choisir un intervalle d'achèvement raisonnable plutôt que de découper une activité en de nombreuses petites Tâches. Cela réduit à la fois le travail de configuration et le nombre d'actions d'achèvement.

Si vous voulez conserver les Récompenses mais ignorer les boîtes de dialogue d'achèvement, vous pouvez utiliser l'une de ces options :

- **Quick Complete :** activez `Achèvement rapide` dans le coin supérieur droit de la liste de Tâches. Une fois activé, appuyer sur le cercle achève directement la Tâche sans afficher la boîte de dialogue de Récompense.
- **Glisser pour achever :** allez dans `barre latérale` → `Paramètres` → `Tâche` → `Swipe` → `Action de glisser la carte`. Sélectionnez `Balayer à Gauche` ou `Balayer à Droite`, puis réglez l'action sur `Terminer (sans dialogue)`.

Les deux options sans boîte de dialogue accordent toujours les Récompenses configurées, mais elles ignorent aussi les autres boîtes de dialogue d'achèvement, y compris la saisie d'Émotions et l'utilisation automatique d'Objets.

</details>

<details>
<summary>Comment annuler l'achèvement d'une Tâche ?</summary>

Vous pouvez annuler l'achèvement à plusieurs endroits :

1. Juste après l'achèvement, appuyez sur **Undo** dans l'invite en bas.
2. Dans `barre latérale` → `Historique`, appuyez sur `Annuler`.
3. Dans `Calendrier` → `Terminé`, appuyez sur `Annuler`.

Si la date limite de la Tâche est déjà passée, l'annulation directe n'est pas disponible.
Dans ce cas, modifiez plutôt le statut de l'enregistrement (par exemple, passez-le en retard ou abandonné).

</details>

<details>
<summary>Comment marquer une Tâche en retard comme achevée ?</summary>

Lorsqu'une Tâche devient en retard, une boîte de dialogue s'affiche et permet de la marquer comme achevée.

Après avoir fermé la boîte de dialogue, vous pouvez encore mettre à jour le statut de la Tâche depuis :
- `barre latérale` → `Historique`
- `Calendrier` → `Terminé`

</details>

<details>
<summary>Y a-t-il une pénalité de Points d'Expérience/pièces en cas d'échec d'une Tâche ?</summary>

Oui.

- La pénalité de Points d'Expérience est activée par défaut (facteur : `0.2x`).
- La pénalité de pièces est désactivée par défaut (facteur : `0`).

Vous pouvez modifier les paramètres globaux dans :
`barre latérale` → `Paramètres` → `Options avancées`

Vous pouvez aussi définir des pénalités par Tâche dans l'éditeur de Tâche.

</details>

<details>
<summary>Comment fonctionne le mécanisme de répétition ?</summary>

Définissez uniquement l'heure de début, la date limite, la fréquence de répétition et l'heure de rappel optionnelle du **premier** cycle.

LifeUp calculera ensuite automatiquement les cycles suivants.

</details>

<details>
<summary>Comment configurer une Tâche à accomplir N fois de façon irrégulière sur une période ?</summary>

LifeUp n'a pas encore de réglage direct pour « au moins/au plus N fois par cycle ». Vous pouvez toutefois y parvenir de plusieurs façons :

| Méthode | Configuration | Avantages | Inconvénients |
| :--- | :--- | :--- | :--- |
| **Tâche de comptage** | Fréquence `Hebdomadaire`, activez `Tâche compteur`, définissez le compteur (ex. 3). | Configuration simple ; progression claire (ex. 1/3). | **Les Récompenses ne sont accordées qu'après l'achèvement du compteur final.** Aucune Récompense pour chaque achèvement individuel. |
| **Tâche illimitée + objectif** | Fréquence `Illimité`, objectif 3, date limite dimanche. | **Récompenses accordées à chaque achèvement.** | **Doit être recréée manuellement chaque semaine** (car la Tâche se termine après achèvement). |
| **Sous-tâches** | Fréquence `Hebdomadaire`, ajoutez 3 sous-tâches à l'intérieur. | Permet de définir des Récompenses et rappels individuels pour chaque achèvement. | Nécessite d'entrer dans la page de détail pour cocher les sous-tâches ; doit être créée manuellement une par une (convient seulement aux petits nombres). |
| **Tâche illimitée (stats uniquement)** | Fréquence `Illimité`. | Configuration la plus simple ; Récompenses et stats à chaque achèvement. | **Aucune contrainte forcée.** Vous devez consulter vos stats manuellement pour voir si vous avez atteint l'objectif hebdomadaire. |

> [!NOTE]
> Nous envisageons d'ajouter une fonctionnalité « Récompense en temps réel » pour les **Tâches de comptage** (Récompense à chaque comptage immédiatement), actuellement en cours d'évaluation.

</details>

<details>
<summary>Comment masquer les Tâches achevées ou non démarrées ?</summary>

Cela se produit généralement dans l'un de ces cas :

1. Si une Tâche affiche `xx deadline`, cette Tâche a déjà commencé.
   - Modifiez la Tâche et ajustez l'`Heure de Début` si nécessaire.

2. Si une Tâche affiche `xx starts` et que la date n'est pas aujourd'hui :
   - Vérifiez si le bouton de repli en bas est replié.
   - Ouvrez le menu en haut à droite (`...`) → `Filtre`.
   - Confirmez que `Afficher Aujourd'hui` est activé.

> Note :
> - Les listes intelligentes (semaine/mois) ne prennent pas en charge le repli.
> - Pour les Tâches répétitives, un cycle complet est valide par défaut. Par exemple, un cycle de 21 jours peut être achevé n'importe quel jour de ces 21 jours. Si vous ne voulez le voir qu'en fin de cycle, ajustez l'heure de début une fois et laissez LifeUp calculer automatiquement les cycles suivants.

</details>

<details>
<summary>Comment éviter que les Tâches passent en retard à minuit ?</summary>

Le moment du passage en retard est contrôlé par l'heure limite de la Tâche.

Après avoir défini la date limite, appuyez sur le bouton `time` et choisissez une heure plus tardive.

Par exemple, si vous ne voulez pas qu'un Objet expire à `00:00`, réglez l'heure limite sur quelque chose comme `02:00` (jour suivant).

Vous pouvez aussi modifier les valeurs par défaut globales dans :
`Paramètres` → `Item` → `Paramètres par défaut des nouvelles tâches`

(La modification des valeurs par défaut n'affecte pas les Objets existants.)

</details>

<details>
<summary>Pourquoi le nombre cible de fois commence-t-il à 1/N ?</summary>

Contrairement aux Tâches de comptage, (1/N) **ici ne représente pas la progression totale.**

Au lieu de cela, **il indique le compteur de répétition actuel. Le fait que cette répétition soit achevée ou non est indiqué par ⚪ ou ✅.**

<br/>

Par exemple, ⚪1/10 signifie :
Cette Tâche sera répétée 10 fois au total (10 cartes seront générées), et elle en est actuellement à la 1re fois, non achevée.

Et ✅1/10 signifie :
La carte actuelle appartient à la 1re fois et est achevée.

Si la progression totale était utilisée, les cartes achevées afficheraient des statuts confus (⚪1/10 et ✅1/10 coexistant). De plus, les cartes pourraient disparaître à l'atteinte de l'objectif (ex. ✅9/10), ce qui serait contre-intuitif.

</details>

<details>
<summary>Comment définir plusieurs rappels pour une Tâche ?</summary>

Créez des sous-tâches et assignez à chacune une description/heure de rappel différente.

C'est la méthode recommandée pour simuler plusieurs rappels pour une Tâche principale.

</details>

<details>
<summary>Les sous-tâches peuvent-elles s'afficher directement dans la liste de Tâches ?</summary>

Pas pour le moment. Nous pourrons envisager cela dans de futures mises à jour.

</details>

## 🎁 Récompenses (Points d'Expérience, biens)

<details>
<summary>Puis-je attribuer des valeurs de Points d'Expérience différentes à différents Attributs pour une Tâche ?</summary>

Pas directement dans la version actuelle.

Pour une configuration rapide, une Tâche utilise actuellement une valeur de Points d'Expérience par Attribut. Si vous avez besoin de valeurs différentes par Attribut, utilisez cette solution de contournement :

1. Créez un Objet.
2. Configurez des effets de Points d'Expérience différents pour différents Attributs sur cet Objet.
3. Réglez l'Objet pour qu'il soit utilisé automatiquement après l'achèvement de la Tâche.

Vous obtenez ainsi l'achèvement de la Tâche + l'effet de l'Objet comme pipeline de Récompense combiné.

Nous prévoyons d'améliorer la prise en charge native de cela dans de futures versions.

</details>

<details>
<summary>Comment les Points d'Expérience et les pièces sont-ils calculés automatiquement ?</summary>

Les Points d'Expérience dépendent principalement de :
- la `Difficulté`
- l'`Importance`
- le `number of selected attributes`

Les pièces dépendent principalement de :
- la `Difficulté`
- l'`Importance`

</details>

<details>
<summary>Comment le Niveau de vie est-il calculé ?</summary>

Les Points d'Expérience du Niveau de vie sont positivement liés aux Points d'Expérience gagnés sur n'importe quel Attribut.

Lorsque des pénalités s'appliquent, les Points d'Expérience du Niveau de vie sont aussi réduits proportionnellement.

Le Niveau de vie est conçu comme un indicateur large et agrégé, nous ne recommandons donc pas de trop se concentrer sur la formule.

L'essentiel est qu'il reflète votre progression globale à long terme.

Référence de formule : chaque action de gain/perte de Points d'Expérience contribue à 1/5 aux Points d'Expérience du Niveau de vie, quel que soit le nombre d'Attributs récompensés dans cette action.

</details>

<details>
<summary>Puis-je définir des Récompenses personnalisées de Points d'Expérience et de pièces pour les Tâches ?</summary>

Oui.

Lors de la création d'une Tâche ou d'un Succès, appuyez sur le bouton de Récompense correspondant et configurez les valeurs manuellement.

</details>

<details>
<summary>Pourquoi les images d'Objets sont-elles manquantes ou ne s'affichent-elles pas ?</summary>

LifeUp est offline-first, les images d'Objets sont donc stockées localement sur votre appareil.

Si des images manquent, réfléchissez à ce qui s'est passé récemment :

**Après l'import d'une sauvegarde :**
- La sauvegarde peut ne pas inclure les fichiers image.
- Réimportez une sauvegarde complète incluant les images.

**Après des opérations de nettoyage/gestion de fichiers :**
- LifeUp ne supprime pas activement les fichiers image.
- Des outils de nettoyage/gestion de fichiers tiers avec des permissions étendues peuvent les supprimer par erreur.
- Utilisez ces outils avec prudence.

**Pour les Objets importés depuis Monde :**
- Il peut s'agir d'un problème temporaire de chargement réseau.
- Réessayez plus tard, ou remplacez par des images locales.

Si vous avez encore une ancienne sauvegarde avec images, vous pouvez d'abord restaurer cette sauvegarde pour récupérer les médias, puis restaurer votre dernière sauvegarde de données.

</details>

<details>
<summary>Comment supprimer un Objet de la Boutique ?</summary>

Sur la page `Boutique`, maintenez appuyé sur l'Objet, puis appuyez sur le bouton `Supprimer` en haut.

</details>

<details>
<summary>Comment effacer les Points d'Expérience et les pièces ?</summary>

Allez dans :
`barre latérale` → `Paramètres` → `Sauvegarde des données/Restauration/Effacer`

Vous pouvez y effacer les valeurs de Points d'Expérience et de pièces.

Note : si vous utilisez des fonctionnalités en ligne, les affichages côté serveur peuvent mettre un court instant à se rafraîchir.

</details>

<details>
<summary>Quels sont les plafonds de Niveau et les gradients d'expérience pour les Attributs ?</summary>

On peut considérer qu'il n'y a pas de limite de Niveau (actuellement 2000+, difficile à atteindre par des moyens normaux).

L'expérience requise pour chaque Niveau augmente, bien que le gradient actuel soit raide. (Les Récompenses ne devraient donc pas être évaluées uniquement par les plafonds de Niveau ; le plafond d'expérience est d'environ 2^63).

En fait, de nombreux utilisateurs resteront longtemps dans le gradient de 2500 Points d'Expérience. Nous pourrons optimiser le système de Niveaux ou permettre la personnalisation à l'avenir. (Le total de Points d'Expérience ne sera pas affecté).

| Niveau    | Points d'Expérience requis pour chaque Niveau |
| -------- | --------------------------------------------- |
| 1 → 2     | 300                                           |
| 2 → 3     | 700                                           |
| 3 → 4     | 1500                                          |
| 4 → 99    | 2500                                          |
| 99 → 150  | 5000                                          |
| 150 → 200 | 7500                                          |
| 200 → 250 | 15000                                         |
| 250 → 300 | 30000                                         |
| 300 → 325 | 50000                                         |
| 325 → 350 | 100000                                        |
| >350     | 500000                                        |

</details>

<details>
<summary>Comment configurer les prêts, les intérêts du DAB et les intérêts de prêt ?</summary>

Sur la page `Boutique`, ouvrez le menu en haut à droite (`...`) et sélectionnez `Paramètres`.

</details>

<details>
<summary>Comment personnaliser les Attributs ou Compétences ?</summary>

Allez dans :
`barre latérale` → `Paramètres` → `Paramètres Personnalisés` → `Customiser attributs`

Vous pouvez personnaliser les Attributs existants, créer de nouveaux Attributs pour les Compétences, et supprimer des Attributs si nécessaire.

Si vous voulez suivre des Compétences, créez des Attributs nommés d'après ces Compétences (par exemple, `Fishing` ou `Programming`).

</details>

<details>
<summary>Puis-je modifier les Attributs utilisés par les Récompenses sportives ou les Récompenses de likes Monde ?</summary>

Pas dans la version actuelle.

Ces correspondances de Récompense intégrées sont fixes pour l'instant.

</details>

<details>
<summary>Comment configurer des Récompenses Boîte de butin ?</summary>

Lors de la création d'un Objet de Boutique, ajoutez un effet `Boîte de butin` à cet Objet.

Configurez ensuite le pool de Récompenses, la probabilité et les paramètres associés dans cet effet.

</details>

<details>
<summary>Puis-je définir une probabilité de Boîte de butin inférieure à 1 % ?</summary>

Oui.

Après avoir configuré l'effet Boîte de butin, appuyez sur le bouton d'aide `?` dans l'App pour les détails de probabilité et les instructions de configuration.

</details>

<details>
<summary>Comment obtenir plus d'icônes ?</summary>

Nous sommes une petite équipe indie et ne pouvons pas maintenir actuellement un grand jeu d'icônes intégré.

Vous pouvez obtenir plus d'icônes de ces façons :

1. Importez des Objets depuis `Monde` → `Marché` et réutilisez leurs icônes.
2. Utilisez des ressources d'icônes externes (assurez-vous que les droits d'utilisation sont valides) :
   - [iconfont](https://www.iconfont.cn/)
   - [Flaticon](https://www.flaticon.com/)
3. Si possible, privilégiez les icônes à fond transparent pour un meilleur affichage dans l'App.

</details>

<details>
<summary>Que faire si les images de produits ne s'affichent pas ou sont manquantes ?</summary>

LifeUp est une app offline. Les images de produits sont enregistrées sur votre appareil et stockées de façon sécurisée dans le répertoire privé de l'App. Nous ne pouvons pas enquêter directement sur les changements de fichiers sur votre appareil.

Si les images de produits sont perdues ou ne s'affichent pas, réfléchissez aux opérations que vous avez effectuées récemment :

**Si des images manquent après la restauration d'une sauvegarde :**
- C'est généralement parce que le fichier de sauvegarde ne contient pas les fichiers image
- Vous devez réimporter une sauvegarde complète incluant les fichiers image

**Si des images ont été supprimées par erreur :**
- LifeUp ne supprime pas proactivement les fichiers image
- Si vous avez récemment utilisé la fonction de gestion d'images, vous avez peut-être supprimé des images par erreur et pouvez essayer de les restaurer depuis une sauvegarde
- De plus, certaines apps de nettoyage système avec des permissions élevées peuvent aussi supprimer les fichiers image ; utilisez ces apps avec prudence
- Si vous avez une ancienne sauvegarde contenant des images, sauvegardez d'abord les données actuelles, restaurez ensuite l'ancienne sauvegarde pour récupérer les images, puis restaurez vos données actuelles

**Si les images de produits importées depuis le module Monde ne s'affichent pas :**
- Cela peut être dû à des problèmes réseau
- Réessayez plus tard, ou remplacez l'image du produit par une image locale

**Dans de rares cas, des défauts système peuvent provoquer une perte d'images :**
- À notre connaissance, certaines versions système personnalisées de certains fabricants ont eu des défauts : lorsque l'App plante de façon répétée, elle peut effacer incorrectement les données de l'App, entraînant la perte des données et des fichiers image. Maintenez votre système à jour. De plus, nous ne pouvons pas exclure qu'il reste des défauts système pouvant provoquer des anomalies, car cela échappe au contrôle de l'App. Nous recommandons de sauvegarder fréquemment
- Dans des cas extrêmes, un stockage instable ou des problèmes matériels peuvent aussi provoquer une perte de fichiers image. Envisagez de sauvegarder régulièrement vers le cloud ou de remplacer l'appareil

</details>

## ⏰ Rappel / Pomodoro / Compte à rebours

<details>
<summary>Comment utiliser l'effet de compte à rebours d'un Objet de Boutique ?</summary>

Les effets de compte à rebours sont délivrés via des notifications de l'App.

Confirmez d'abord que l'autorisation de notification pour LifeUp est activée.

</details>

<details>
<summary>Le Pomodoro prend-il en charge le passage automatique au suivant ?</summary>

Pas actuellement.

Vous pouvez essayer le mode chronomètre ascendant.

En mode Pomodoro, lorsqu'une session de travail se termine, le chronomètre continue de compter vers le haut. Vous pouvez ensuite décider d'ajouter du temps supplémentaire aux enregistrements de Concentration. Le passage automatique au suivant entrerait en conflit avec ce flux de travail.

</details>

<details>
<summary>Comment démarrer rapidement un Pomodoro depuis la liste de Tâches ?</summary>

Vous pouvez :
1. Maintenir appuyée une Tâche et appuyer sur `Chronomètre` dans le menu d'actions.
2. Ou configurer une action de glissement sur `Chronomètre` dans les paramètres `Tâches`.

</details>

<details>
<summary>Le Pomodoro fournit-il des statistiques récapitulatives comme les apps Pomodoro dédiées ?</summary>

Pas encore.

Le Pomodoro de LifeUp reste un module léger en phase de développement précoce.

Actuellement disponible :
- Enregistrements détaillés par session
- Statistiques récapitulatives quotidiennes de base sur la page `Statut`

</details>

## 💾 Sauvegarde et restauration

<details>
<summary>Comment sauvegarder les données ?</summary>

Consultez d'abord le [Guide de sauvegarde et restauration](/guide/backup.md).

En bref, les méthodes de sauvegarde prises en charge incluent :
- Google Drive (recommandé)
- Dropbox
- Export de fichiers de sauvegarde
- Serveurs WebDAV

</details>

<details>
<summary>Pourquoi LifeUp est-elle conçue comme une app offline-first ?</summary>

LifeUp suit une architecture offline-first par conception.

Cela signifie :
- Vos données vous appartiennent et sont sous votre contrôle.
- Les données restent locales sauf si vous choisissez explicitement des options de sauvegarde/synchronisation.
- La plupart des fonctionnalités principales fonctionnent encore sans accès réseau.

Comme le client gère la logique principale localement, vous pouvez continuer à utiliser LifeUp même lorsque le réseau ou la disponibilité du serveur est limitée (sauf les fonctionnalités en ligne comme le module Monde).

</details>

## 🧭 Planification

<details>
<summary>Allez-vous ajouter des fonctionnalités IA ?</summary>

LifeUp est une app à faible coût, achat unique, maintenue par une petite équipe. Intégrer directement des fonctionnalités IA prêtes à l'emploi (où nous couvrons les coûts d'API) n'est pas réaliste compte tenu de notre modèle tarifaire — sauf à passer à un abonnement ou à multiplier le prix unique plusieurs fois pour correspondre aux coûts d'exploitation des apps IA modernes. Nous n'allons pas faire cela.

Cela dit, LifeUp est naturellement compatible avec l'IA :

1. Nous avons exposé la plupart de l'[API](/guide/api.md) et des fonctionnalités principales dès le début, ce qui la rend naturellement compatible avec les agents IA et les outils tiers. Les outils IA avec capacités d'agent peuvent déjà invoquer directement les fonctionnalités de LifeUp — créer des Tâches, des Objets, et plus encore. En fait, nous avons vu de nombreux utilisateurs partager des flux de travail combinant l'IA avec notre API, y compris des serveurs MCP LifeUp API personnalisés, des outils d'automatisation pour des entrées de journal quotidien générées par IA, et plus encore.

2. Nous prévoyons d'introduire à l'avenir des capacités IA BYOK (Bring Your Own API Key). Vous pourrez ainsi utiliser votre propre clé pour alimenter les fonctionnalités IA sans que nous supportions les coûts d'API récurrents.

3. Au final, l'IA n'est pas magique — sinon vous pourriez tout aussi facilement associer l'IA à notre API pour obtenir une intégration complète vous-même.

</details>

<details>
<summary>Y aura-t-il une version iOS de LifeUp ?</summary>

En **2025**, nous avons lancé [ulives](https://app.ulives.io/), une nouvelle app de productivité multiplateforme pour les utilisateurs iOS (aussi sur iPadOS et Mac Apple Silicon).

Un port direct de LifeUp vers iOS n'est pas réaliste :

- LifeUp est construite avec une technologie Android native.
- Son architecture offline-first lie étroitement l'interface, le modèle de données local et la logique métier à l'implémentation Android.
- Un port direct nécessiterait quand même de lourdes réécritures pour garder données et logique cohérentes.

Nous avons donc réorganisé et reconstruit avec une orientation multiplateforme via ulives.

ulives conserve l'esprit central de LifeUp tout en corrigeant plusieurs problèmes de conception et produit de longue date des générations précédentes. Vous pouvez le voir comme une évolution fraîche, pas seulement un clone un pour un.

**L'abonnement LifeUp ne débloque pas ulives**, mais vous pouvez importer une sauvegarde LifeUp (unidirectionnelle, potentiellement avec pertes). Voir [Qu'est-ce qu'ulives ?](/guide/faq?id=ulives_overview). Pour des raisons plus détaillées, consultez le document de comparaison : [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup).

</details>

<details id="ulives_overview">
<summary>Qu'est-ce qu'ulives ? Partage-t-il l'abonnement ou les données LifeUp ?</summary>


[ulives](https://app.ulives.io/) est une **réécriture complète** sur une technologie multiplateforme (KMP). Il hérite de la philosophie de gamification de LifeUp, mais le code, l'équipe, les tarifs et les plans à long terme sont séparés — un successeur spirituel, **pas** un port iOS de LifeUp.

**Pourquoi les abonnements sont-ils séparés ?**

- **Le tarif LifeUp reflète la portée Android uniquement :** LifeUp a toujours été construite avec une technologie purement native Android. Son prix d'abonnement à vie très bas a été défini autour du fait de **n'avoir qu'un client Android** — il n'a jamais été pensé pour acheter la maintenance de chaque future app que nous pourrions construire.
- **Le tarif ulives reflète le coût multiplateforme et la maintenabilité à long terme :** ulives est une réécriture complète avec un code multiplateforme, une équipe pas encore totalement unifiée, et un travail continu pour iOS plus les futures cibles Android et HarmonyOS. Premium est défini par un **développement durable et une maintenabilité à long terme**, pas par la copie de la répartition historique gratuit/payant de LifeUp.
- **Équipes de développement distinctes :** un port iOS de LifeUp a progressé lentement pour diverses raisons. Nous avons réorganisé une équipe dédiée pour ulives (encore petite aujourd'hui) pour livrer un produit multiplateforme plus rapidement et plus flexiblement.
- **Écosystèmes de boutique séparés :** l'App Store et Google Play sont des systèmes de paiement et de droits indépendants. Les licences ne peuvent pas être transférées directement entre les deux apps.

**En bref :**

- **L'abonnement LifeUp ↔ l'abonnement ulives ne se transfèrent pas :** un achat LifeUp sur Google Play **ne** débloque **pas** ulives sur l'App Store, et vice versa. Chaque app nécessite son propre achat.
- **Import unidirectionnel de données :** depuis ulives 1.7.22, vous pouvez importer une sauvegarde LifeUp (`.lfbak`) dans ulives. La conversion peut être avec pertes, et l'import **ne** se transfère **pas** vers LifeUp.
- **L'import ne transfère pas votre licence :** les sauvegardes déplacent les données d'utilisation (Tâches, Objets, etc.), pas les droits d'abonnement LifeUp.

**ulives Premium sur toutes les plateformes ulives :**

ulives lancera aussi son propre client **Android** (et le support natif HarmonyOS, etc.). **Premium acheté pour ulives est prévu pour fonctionner sur toutes les plateformes ulives** — iOS, Android, HarmonyOS — une fois la gestion de compte côté serveur prête. Les cas multiplateformes précoces peuvent nécessiter de nous contacter.

**Les deux apps proposent un abonnement à vie bien en dessous de la plupart des produits comparables** — mais les prix affichés doivent être lus en contexte : portée mono-plateforme vs multiplateforme, coût de développement et maintenance à long terme diffèrent.

Pour des raisons plus détaillées (modèle tarifaire, durabilité, investissement en développement et plans futurs des deux apps), consultez le document de comparaison : [ulives vs LifeUp — Comparison](https://app.ulives.io/docs/comparison-with-lifeup). FAQ ulives : [https://app.ulives.io/docs/faq](https://app.ulives.io/docs/faq)

</details>

## 🆘 Besoin d'aide supplémentaire ?

<details>
<summary>Nous contacter</summary>

Vous pouvez nous joindre à [lifeup@ulives.io](mailto:lifeup@ulives.io).

Vous pouvez aussi ouvrir une issue sur GitHub :
[https://github.com/Ayagikei/LifeUp/issues](https://github.com/Ayagikei/LifeUp/issues)

</details>

<details>
<summary>Vous souhaitez nous soutenir ?</summary>

Merci de soutenir LifeUp.

Si LifeUp vous a été utile, vous pouvez nous soutenir de deux façons simples :

1. Offrez-nous un café depuis la page **About** de la version **Google Play** de l'App.
2. Aidez plus de personnes à découvrir LifeUp en partageant votre expérience :
   - Recommandez LifeUp à des amis
   - Publiez vos histoires d'utilisation et flux de travail
   - Partagez des astuces, guides ou tutoriels

</details>

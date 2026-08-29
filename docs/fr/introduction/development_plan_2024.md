# Plan de développement 2024-2025

> [!NOTE]
> Il s'agit de notre plan de développement actuel. Nous ferons de notre mieux pour guider les améliorations et mises à jour du produit selon ce plan. Cependant, en raison de l'environnement en constante évolution, le contenu du plan de développement peut être modifié, ajouté ou retiré. La publication produit effective fait foi.

### I. Plan de développement

> Mis à jour : 2025/09/14

| Module | Sous-fonction | Raison du besoin | Priorité | Résultat |
| ---- | ------ | -------- | ------ | ---- |
| Capacités de base (1) | Sélection multiple d'Objets & utilisation auto des Objets à l'acquisition | ~ | P0 | ✅ Sélection multiple publiée en v1.94<br/>✅ Utilisation auto des Objets publiée en v1.96 |
| Capacités de base (2) | Popup de Récompense généralisée (prise en charge de tout nombre d'Attributs et d'Objets) | ~ | P0 | ✅ Publiée en v1.96 ; paramètres à assouplir dans les versions futures |
| Capacités de base (3) | Gestion des ressources sonores & effets sonores des Objets | ~ | P0 | ✅ Publiée |
| Capacités de base (4) | Optimisation des notifications | ~ | P0 | ✅ Publiée |
| Adaptation grand écran (tablette/pliable) | Adaptation tablettes et pliables basée sur l'Activity embedding | ~ | P1 | ✅ Prévue en v1.95 |
| Widgets | Extension widgets (widget Inventaire) | ~ | | ✅ Publiée en v1.94 |
| Intégration calendrier | - Sync bidirectionnelle Google Calendar<br/>- Sync bidirectionnelle calendrier système | - Beaucoup de retours à l'étranger.<br/>- LifeUp est un outil to-do avec des fonctions qui se chevauchent mais diffèrent des apps d'agenda (calendrier). | P1 | 🚧 |
| API | - Élargir les capacités API pour couvrir toutes les fonctions de base<br/>- Finalisation des fonctionnalités client bureau, prise en charge sauvegarde/restauration, etc. | - Il manque encore de nombreuses API comme l'édition.<br/>- LifeUp ne peut pas tout faire, mais l'API permet la personnalisation et l'extension. | P1 | 🚧 Prévue en v1.98.x |
| Succès | - Succès de type répétition | ~ | P2 | ✅ Publiée |
| Système de données | - Sauvegarde séparée des données et images<br/>- Prise en charge export/import partiel de données<br/>- Prise en charge du basculement multi-fichiers intégré | - L'upload WebDAV de gros fichiers échoue facilement.<br/>- L'export/import partiel peut servir à partager des systèmes de Récompenses.<br/>- Multi-fichiers intégrés pour faciliter les tests sans effacer les données. | P1 | 🚧 |
| Multi-plateforme (direction Flutter) | - Continuer à apprendre et utiliser Flutter pour la version multi-plateforme | - Prototype de version iOS | P2 | 🚧 En pause |
| Multi-plateforme (direction KMP) | - Explorer plus de possibilités avec KMP | - Explorer et apprendre la technologie KMP pour l'avenir | P0 | ✅ Publié ulives - nouvelle App iOS |

En résumé :

1. Nous mettrons en œuvre la direction établie précédemment : stabilité et optimisation des fonctionnalités existantes, sans ajouter arbitrairement de nouveaux modules fonctionnels.
2. Nous utiliserons une ou deux versions majeures pour résoudre certains défauts fonctionnels de base et points de friction.
3. Puis nous poursuivrons l'intégration calendrier et les Succès de type répétition.
4. Amélioration continue des API et autres aspects.

Le multi-plateforme sera l'un de nos objectifs clés pour 2024.

---

### II. Bilan 2023

Le parcours de développement semi-amateur semi-loisir de LifeUp a passé son cinquième anniversaire, entrant dans sa sixième année. Nous avons publié des centaines de versions, avec près de 5000 commits de code rien que sur le dépôt Android.

<br/>

Bien que le plan de développement proposé en octobre 2022 se concentrait sur l'approfondissement du système fonctionnel de LifeUp, en raison des changements d'environnement, nous avons rencontré de nombreux obstacles et difficultés en cours de route.

#### 1.1 Environnement

Exemples typiques :

- Impacté par de fausses signalements « anti-fraude » dans certaines provinces sans canal de recours, plusieurs cycles ont été nécessaires pour résoudre certains problèmes. Mais récemment, de nouveaux problèmes de fausses signalements sont apparus au Shandong, et nous n'avons pas encore trouvé de recours ou de chemin de reproduction.
- Les standards de review du marché Android domestique chinois s'accumulent couche par couche, avec des standards incohérents entre marchés et personnel, et des reviewers peu professionnels.
  - Certains marchés d'apps rejettent souvent les reviews sur des parties inchangées.
  - Un marché d'apps V a presque rejeté notre App LifeUp en invoquant la « conformité vie privée ». Le marché exigeait que notre App demande [lire toutes les permissions fichiers] ou [lire toutes les permissions photos] avec les explications correspondantes, pour que les utilisateurs puissent sélectionner des images depuis l'album. Cependant, LifeUp utilise une approche plus protectrice de la vie privée, n'a pas besoin de telles permissions, et ne lit pas directement les fichiers utilisateur. Notre App ouvre plutôt l'app album intégrée du système et ne reçoit que l'image sélectionnée par l'utilisateur, garantissant une protection maximale de la vie privée.
    Mais les reviewers ne connaissaient pas cette bonne pratique, et plusieurs jours ouvrables de communication avec le service client ont été nécessaires pour obtenir l'approbation.

<br/>

Pour réduire l'impact environnemental sur nous :

Nous avons renforcé le mécanisme de mise à jour in-app et réduit la fréquence de soumission aux reviews de marché.

La version domestique prend désormais en charge les mises à jour in-app et peut basculer entre les canaux stable ou beta.

![Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa](_media/development_plan_2024/Screenshot_2023-12-09-15-45-33-18_50eeeb96828cbaa.jpg)

Nous avons aussi mis à jour le site officiel (https://lifeupapp.fun/en/index.html) comme canal de téléchargement alternatif.

![image-20231209154445462](_media/development_plan_2024/image-20231209154445462.png)

Pour faciliter le téléchargement et l'installation de l'App via le site, en évitant les risques et retards de review de marché.

Les requêtes réseau in-app ont aussi ajouté des canaux de secours pour atténuer et prévenir les problèmes d'accès causés par de fausses signalements dans certaines provinces.

<br/>

Alors que les standards de review deviennent de plus en plus stricts, et en voyant les divers obstacles rencontrés par d'autres développeurs indépendants sur le marché Android domestique,

on peut dire que pour les développeurs indépendants, la plateforme Android domestique n'est plus la cible de lancement idéale en premier choix.

Après tout, Android domestique a les exigences de qualification les plus strictes et les standards de review les plus complexes et **changeants**.

> Mais ironiquement, en même temps, certaines apps copie de mauvaise qualité peuvent facilement être publiées et marquées « re-inspection manuelle réussie ».

C'est peut-être pourquoi beaucoup d'œuvres de développeurs indépendants vues sur Xiaohongshu n'ont que des versions iOS.

Google Play et App Store restent le premier choix.

> [!TIP]
> Chacun peut prêter plus d'attention et soutenir ces développeurs indépendants et petites équipes qui restent sur la plateforme Android domestique~

<br/>

Donc, en 2024 :

- Nous déplacerons les parties inachevées du plan précédent vers cette période, comme l'intégration calendrier, les Succès de type répétition, les capacités de base, le système de données, etc.
- Le développement multi-plateforme sera un objectif important pour nous, incluant possiblement deux directions :
  - Utiliser Flutter pour reproduire LifeUp (en raison de ressources limitées, avancé par notre collègue backend - Xiao Xiao)
  - Explorer plus de possibilités avec KMP (Kotlin Multiplatform)

#### 1.2 Croissance utilisateurs domestique

De plus, LifeUp a connu une croissance significative d'utilisateurs sur le marché chinois des apps en 2023. Merci à tous pour votre soutien !

- Pour réduire le temps passé à émettre manuellement des codes de rédemption et se concentrer davantage sur le développement : en 2023 nous avons connecté des méthodes de paiement automatisées (WeChat, Alipay) et pris en charge la connexion WeChat.
  - Cela nous a libéré beaucoup de temps.

- En 2023, une propagation utilisateur sur Qzone a de nouveau fait planter notre serveur pendant plusieurs jours.
- Nous avons aussi essayé d'opérer un compte public WeChat, Xiaohongshu, Bilibili, etc., pour promouvoir et présenter les mises à jour LifeUp et les usages créatifs.

- Par des discussions avec d'autres développeurs indépendants, nous avons constaté que la plupart ont vécu des difficultés similaires, choisissant finalement de fermer certains canaux de messagerie instantanée et réseaux sociaux. Nous nous identifions profondément.
  - Dans les grandes entreprises, il y a généralement des équipes de service client dédiées ou des bots pour gérer de nombreuses demandes, les transformant efficacement en besoins spécifiques ou retours de problèmes pour les développeurs.
  - **Mais les développeurs indépendants doivent généralement assumer le service client et les opérations ; gérer des utilisateurs déraisonnables consomme 100 % du temps de développement de ce développeur indépendant, affectant finalement le développeur, le produit et les utilisateurs centraux du produit.**
  - Par conséquent, nous tendons de plus en plus à recommander aux utilisateurs de fournir des retours par e-mail, etc.

<br/>

Donc, en 2024 :

- Nous continuerons à réduire l'investissement humain dans le travail de consultation répétitif, et améliorerons plutôt la documentation et les FAQ. Même s'il y a des consultations, elles seront traitées uniformément par e-mail, canal QQ, etc.
- Essayer une petite quantité d'opérations sur les réseaux sociaux.

#### 1.3 Croissance utilisateurs à l'étranger

Début 2022, nous avons rejoint Google Play Pass et avons connu une vague de croissance utilisateurs.

Mais cette croissance n'a pas duré longtemps ; mi-2022, la croissance utilisateurs a progressivement diminué significativement, sans signe d'amélioration.

Comme LifeUp est une App à achat unique, la croissance utilisateurs est très importante pour nous, et constitue la base pour continuer à opérer et avoir une chance de développer à temps plein à l'avenir.

Nous avons essayé de nombreuses méthodes pour améliorer la croissance :

![image-20231209154347665](_media/development_plan_2024/image-20231209154347665.png)

- Engagé un designer professionnel pour refaire les images promotionnelles du store
- Amélioré le support multilingue de l'App et des images promotionnelles
- Amélioré la description de l'App
- Amélioré la documentation de prise en main
- Augmenté la fréquence de mise à jour
- ...

Bien que nous ayons mis en œuvre de nombreuses méthodes et amélioré certains indicateurs. Nous n'avons toujours pas pu revenir à une période de croissance stable.

Nous avons dû laisser faire.

<br/>

La bonne nouvelle est qu'à la fin de 2023, il semble y avoir une certaine amélioration.

<br/>

Donc, en 2024 :

- Améliorer la construction de l'internationalisation (documentation, support linguistique in-app, etc.).

#### 1.4 Gestion de la qualité

Comme LifeUp est une App outil offline développée et testée uniquement par moi, éviter les problèmes de crash graves est particulièrement important.

Le processus d'itération de version en 2023 a pris plus de temps qu'auparavant, et nous avons réservé suffisamment de temps pour les tests beta afin d'assurer une préparation approfondie.

![image-20231209154314651](_media/development_plan_2024/image-20231209154314651.png)

Ces mesures semblent effectivement prévenir l'apparition de crashes graves à grande échelle.

Cependant, chaque mise à jour de version apporte inévitablement certains problèmes, y compris sur des chemins critiques.

Par conséquent, nous continuerons à améliorer la gestion de la qualité de LifeUp, avec la stabilité comme indicateur le plus important (surtout dans un environnement de plus en plus sévère et des défis de review).

<br/>

Donc, en 2024 :

- Renforcer la gestion de la qualité.

#### 1.5 Approfondissement des fonctions

Comme mentionné dans l'article du troisième anniversaire, LifeUp est une App qui a progressivement exploré et grandi.

Des choses comme la Boutique, les Succès personnalisés, l'API n'étaient pas dans le plan initial, mais ont été progressivement développées et ajoutées avec les mises à jour et retours.

Mais cela a aussi introduit certains problèmes :

- Certains modules ont des détails de planification grossiers.
  - Par exemple, les Récompenses d'Objets n'ont initialement considéré que les Récompenses uniques.
  - Les Attributs et autres systèmes n'ont pas non plus initialement considéré la personnalisation, et seul un refactoring progressif a pu prendre en charge les ajouts/suppressions et Niveaux personnalisés, etc.
  - Il y a beaucoup de tels problèmes, comme les popups de Récompense/pénalité d'Attribut et l'affichage de l'historique qui supportent au maximum 3.
- Ces modules nouvellement ajoutés manquent d'analyse et de planification globales pour l'App.

Nous continuerons dans la direction énoncée dans l'article du troisième anniversaire, en approfondissant les modules fonctionnels existants de l'App et en résolvant certains problèmes de friction, plutôt qu'en poursuivant de nouveaux modules fonctionnels.

Par exemple, nous prendrons en charge directement les Récompenses d'Objets en sélection multiple, améliorerons le mécanisme de sauvegarde, l'optimisation des notifications, la finalisation des widgets, etc.

#### 1.6 API et extensibilité

Comme mentionné ci-dessus, nous ne prévoyons plus d'introduire de nouveaux modules fonctionnels.

Mais il y aura certainement des demandes d'extension de l'App.

Nous avons donc introduit la fonction API en 2023.

Nous fournissons le cœur de LifeUp comme capacité fondamentale.

Même si les utilisateurs ne comprennent pas la programmation, ils peuvent utiliser des outils d'automatisation comme Tasker/MacroDroid pour étendre les fonctions, obtenant des capacités d'automatisation.

Exemples typiques :

- NFC, QR code pour terminer des Tâches
- Check-in auto au réveil
- Widgets personnalisés
- Et ainsi de suite...

Si les utilisateurs comprennent la programmation, ils peuvent étendre encore plus de gameplay ou même des Apps à partir de cela.

![img](_media/development_plan_2024/desktop.png)

Nous avons aussi développé une version bureau simple basée sur l'API (et open-sourcée).

Même après plusieurs versions d'expansion API, il nous manque encore de nombreuses capacités.

Par exemple, pas de prise en charge des opérations liées aux « pensées », pas de prise en charge de la mise à jour de données via Content Provider, etc.

Nous continuerons à élargir l'API en 2024 pour couvrir chaque aspect de l'App autant que possible.

> Bien que nous voyions actuellement beaucoup d'utilisateurs utiliser l'API pour un usage personnel, il y a encore peu de produits partagés et exécutables. Nous devons continuer à fournir des capacités API plus fortes pour construire un écosystème API.

#### 1.7 À propos de l'avenir

Avec les problèmes ci-dessus et les changements d'environnement, nous avons aussi progressivement ajusté le prix de l'adhésion à vie de LifeUp (même ainsi, le tarif d'adhésion de LifeUp est bien inférieur à la plupart des autres apps), et les mises à jour tendront progressivement à fournir des fonctionnalités en tant que fonctionnalités d'adhésion.

Nous réalisons progressivement que les apps servent ultimement les utilisateurs centraux.

Les retours et le soutien des utilisateurs centraux peuvent ultimement se refléter dans les améliorations de l'App, réalisant une co-création et un cycle positif entre développeur et utilisateurs.

Si nous essayons de plaire à tout le monde, l'App deviendra un fouillis de code, s'éloignera des demandes des utilisateurs centraux, et réduira les revenus et la motivation du développeur.

<br/>

Nous avons mentionné KMP (Kotlin Multiplatform) ci-dessus, qui est une technologie multi-plateforme relativement émergente. Elle peut aussi utiliser des capacités natives en mixte.

Pendant le développement de LifeUp, nous avons progressivement eu de nouvelles idées. Mais toutes les idées ne peuvent pas ou ne conviennent pas à être déployées sur LifeUp.

Par exemple, remplacer toute l'UI, des changements majeurs à la logique Boutique, etc., qui impacteraient inévitablement sérieusement l'expérience des utilisateurs existants. Nous avons aussi vu de nombreux cas de changements majeurs d'App menant à l'échec.

<br/>

De plus, quand LifeUp a été initialement développée, le framework de base de données officiel « Room » n'était pas encore disponible, nous avons donc choisi un framework de base de données de niche domestique.

Maintenant certains problèmes de performance sont devenus proéminents, et il est difficile de le remplacer.

De plus, LifeUp prend désormais en charge Material 3 et l'ancien Material Design, plus le mode sombre, le multilingue, la fragmentation des systèmes téléphoniques domestiques (la documentation de configuration de compatibilité ne fait que s'allonger, les systèmes natifs et versions à l'étranger n'ont généralement besoin que d'une configuration sur une seule page) et d'autres problèmes. Chaque page doit considérer de nombreuses choses complexes.

<br/>

Nous avons donc prévu d'explorer KMP pour voir si nous pouvons utiliser une technologie avec KMP.

Aussi pour avoir la chance d'implémenter plus d'idées et de nouveaux projets à l'avenir — plus de compétences ne font jamais de mal.

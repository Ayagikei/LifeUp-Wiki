# Plan de développement 2022/10 - 2023/12

> [!NOTE]
> Il s'agit d'un plan de développement expiré, conservé uniquement à des fins d'archive et de référence. L'environnement continue d'évoluer, et nos plans s'ajusteront en conséquence. Ce plan indique globalement notre direction de développement, mais nous ne promettons pas de l'exécuter entièrement, et nous pouvons aussi développer au-delà du plan.

<br/>

Le développement de LifeUp ces dernières années s'est toujours concentré sur de nouveaux modules fonctionnels ou l'ajout de fonctionnalités aux modules existants.

Aujourd'hui, nous estimons que les modules fonctionnels de LifeUp ont une largeur auto-cohérente suffisante, mais une profondeur insuffisante.

Par conséquent, les objectifs de développement suivants visent la profondeur fonctionnelle, en améliorant continuellement les modules existants disponibles, en augmentant la praticité (intégration calendrier, widgets, statistiques) ;

Et en élargissant continuellement les fonctionnalités API pour que les API puissent être pleinement étendues à diverses fonctions externes.
De plus, tenter d'améliorer notre système de données et explorer l'utilisation de Flutter pour développer des versions multi-plateformes.

<br/>

- **2023/01/26**
  - Ajout de l'élément « Côté PC LAN » à « Multi-plateforme », et explication correspondante ajoutée aux « API ».
  - Ajustement de la version estimée pour « Intégration calendrier », le progrès peut être retardé.
  - Ajustement de la version estimée pour « Points d'Expérience requis personnalisés », le progrès peut être avancé.
- **2022/10/16**
  - **Ajout de la feuille de route pour Attributs, Succès et Capacités de base**

| Module | Sous-fonction | Version estimée | Raison du besoin | Priorité | Résultat |
| ---- | ------ | -------- | ------ | ---- | ---- |
| Intégration calendrier | - Sync bidirectionnelle Google Calendar<br/>- Sync bidirectionnelle calendrier système | v1.91~1.93 | - Beaucoup de retours à l'étranger.<br/>- LifeUp est un outil to-do avec des fonctions qui se chevauchent mais diffèrent des apps d'agenda (calendrier). Développer toutes les fonctionnalités calendrier dans LifeUp serait énorme. L'intégration externe peut être une meilleure solution. | P0 | ~ |
| Widgets | - Widget Attributs<br/>- Widget Objets<br/>- etc... | v1.92~1.95 | - Utilisabilité.<br/>- De beaux widgets apportent aussi un niveau de gamification et de motivation. | P1 | ~ |
| Statistiques | - Statistiques de divers indicateurs<br/>- Statistiques Pomodoro détaillées<br/>- Génération de cartes de partage | v1.92~1.95 | - Statistiques Pomodoro insuffisantes.<br/>- Le module statistiques n'a pas été amélioré depuis longtemps, design et données obsolètes.<br/>- Les cartes de partage conviennent au partage externe par l'utilisateur, peuvent apporter des incitations et attirer plus d'utilisateurs dans une certaine mesure (nécessite un design UI soigné). | P1 | - Développement prévu de certaines cartes statistiques en v1.91 |
| API | - Développer SDK<br/>- Prise en charge des requêtes de liste<br/>- Plus d'API courantes | v1.91~1.95 | - Manque d'interface de données de liste. Après prise en charge des requêtes de liste, les tiers peuvent développer une UI personnalisée (comme une liste de Tâches), l'extensibilité peut être grandement améliorée.<br/>- Sur la base des interfaces ci-dessus, développer les SDK correspondants et le côté PC LAN.<br/>- LifeUp ne peut pas tout faire, mais l'API permet à chacun de personnaliser et d'étendre son LifeUp, et de réaliser une communauté open source. | P1 | - Première version de l'API de requête prévue en v1.91 |
| Attributs | - Points d'Expérience requis personnalisés | v1.91~1.92 | ~ | P2 | - Développement prévu terminé en v1.91 |
| Succès | - Succès de type répétition | v1.94~1.97 | ~ | P2 | ~ |
| Capacités de base | - Édition par lot (Tâches, Succès, etc.)<br/>- Sélection multiple d'Objets, emballage auto en boîtes, etc. | v1.94~1.97 | ~ | P1 | ~ |
| Système de données | - Sauvegarde séparée des données et images<br/>- Prise en charge export/import partiel de données<br/>- Prise en charge du basculement multi-fichiers intégré | ~ | - L'upload WebDAV de gros fichiers échoue facilement, les services cloud gratuits ont des limites de trafic, la sauvegarde complète avec images est trop volumineuse.<br/>- L'export/import partiel peut servir aux utilisateurs à partager des systèmes de Récompenses.<br/>- Les multi-fichiers intégrés permettent aux utilisateurs de basculer directement entre systèmes pour le débogage sans effacer les données à répétition. | P1 | ~ |
| Multi-plateforme | - Continuer à apprendre et utiliser Flutter pour développer une version multi-plateforme | Côté PC LAN : v1.91-1.92<br/>Flutter : v2.0 | - Prototype de version iOS.<br/>- Plus enclin à explorer de nouvelles implémentations qu'à reproduire un à un la version Android.<br/>- Peut-être adapté à Windows/macOS et autres plateformes, à investiguer.<br/>- Développer le côté PC LAN basé sur les API (lecture des données téléphone). | P1 | - Première version côté PC prévue en v1.91 |

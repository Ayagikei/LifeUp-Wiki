# Plan de développement 2026-2027

> [!NOTE]
> Il s'agit de notre plan de développement actuel. Nous ferons de notre mieux pour guider les améliorations et mises à jour du produit selon ce plan. Cependant, en raison de l'environnement en constante évolution, le contenu du plan de développement peut être modifié, ajouté ou retiré. La publication produit effective fait foi.

### I. Plan de développement

> Mis à jour : 2026/04

Contrairement à 2024-2025, nous prévoyons de continuer à améliorer les modules existants de LifeUp et **ulives** en 2026-2027, plutôt que d'ajouter de tout nouveaux modules fonctionnels.

| Module | Sous-fonction | Raison du besoin | Priorité | Résultat |
| ---- | ------ | -------- | ------ | ---- |
| Intégration calendrier | - Sync bidirectionnelle Google Calendar<br/>- Sync bidirectionnelle calendrier système | - Beaucoup de retours à l'étranger.<br/>- LifeUp est un outil to-do avec des fonctions qui se chevauchent mais diffèrent des apps d'agenda (calendrier). Développer toutes les fonctionnalités calendrier dans LifeUp serait énorme. L'intégration externe peut être une meilleure solution. | P0 | 🚧 |
| Optimisation fonctionnalité Crafting | - Intégration avec la Boutique<br/>- Filtrage amélioré | - Le Crafting est l'une des fonctionnalités centrales de LifeUp. Optimiser continuellement son intégration avec la Boutique et l'efficacité du filtrage pour améliorer la commodité utilisateur. | P0 | ✅ Publiée |
| Optimisation fonctionnalité Objets | - Effets d'utilisation plus riches (modifier les quantités d'autres Objets)<br/>- Déclencher des effets sonores<br/>- Prise en charge des limites d'utilisation<br/>- Conditions de limite élargies | - Le système d'Objets est central à la gamification de LifeUp. Actuellement en réglage en v1.103, amélioration continue de la flexibilité et du gameplay des Objets. | P0 | 🚧 Réglage v1.103 |
| Optimisation fonctionnalité Attributs | - Sous-catégories d'Attributs (regroupement)<br/>- Prise en charge du système de titres<br/>- Prise en charge du type [Statut]<br/>- Optimisation de la page Statut<br/>- Widget Life Level | - Le système d'Attributs est un autre pilier de la gamification. Nous continuerons à améliorer le système d'Attributs avec plus de personnalisation dimensionnelle et d'affichage. | P0 | 🚧 Sous-catégories publiées, autres en planification |
| Optimisation fonctionnalité Tâches | - Édition et filtrage explicites des tags<br/>- Optimisation de l'interaction d'édition des sous-Tâches<br/>- Comportement personnalisé de complétion forcée des sous-Tâches<br/>- Comportement personnalisé de retard ou de report | - Les Tâches sont la fonctionnalité centrale de LifeUp, optimisation continue de l'expérience d'édition et d'interaction des Tâches. | P1 | 🚧 |
| Récompenses par lot pour Tâches de comptage | - Prise en charge de la réclamation de Récompenses par lot pour les Tâches de comptage | - Le mécanisme actuel de Récompense pour Tâches de comptage est relativement simple, les Récompenses par lot peuvent fournir des incitations d'objectif plus flexibles. | P1 | 🚧 |
| Optimisation fonctionnalité Pensées/Réflexions | - Prise en charge de plus de styles de navigation | - La fonctionnalité Pensées est caractéristique de LifeUp, optimisation continue de son affichage et de son interaction. | P2 | 🚧 |
| Extension Succès | - Statistiques de type hebdomadaire/mensuel/annuel<br/>- Déverrouiller d'autres conditions de Succès | - Le système de Succès a besoin de conditions de déverrouillage plus diversifiées pour une expérience de Succès plus riche. | P2 | 🚧 |
| Système de données | - Sauvegarde séparée des données et images<br/>- Prise en charge export/import partiel de données<br/>- Prise en charge du basculement multi-fichiers intégré | - L'upload WebDAV de gros fichiers échoue facilement, les services cloud gratuits ont des limites de trafic, la sauvegarde complète avec images est trop volumineuse.<br/>- L'export/import partiel peut servir aux utilisateurs à partager des systèmes de Récompenses.<br/>- Les multi-fichiers intégrés permettent aux utilisateurs de basculer directement entre systèmes pour le débogage sans effacer les données à répétition. | P1 | 🚧 |
| API | - Élargir les capacités et la couverture API à toutes les fonctions de base | - Il manque encore certaines API comme certaines opérations liées aux pensées.<br/>- LifeUp ne peut pas tout faire, mais l'API permet à chacun de personnaliser et d'étendre son LifeUp, et de réaliser une communauté open source. | P1 | 🚧 |
| Développement **ulives** | - Continuer à améliorer les fonctionnalités **ulives**<br/>- Explorer le support multi-plateforme (iOS/iPadOS/macOS/autres) | - **ulives** est le produit de nouvelle génération de LifeUp, développé avec une technologie multi-plateforme moderne.<br/>- À l'avenir, extension possible vers Android ou d'autres plateformes. | P0 | 🚧 |

En résumé :

1. Nous continuerons à suivre la direction établie, en nous concentrant sur la stabilité et l'optimisation des fonctionnalités existantes.
2. Amélioration continue de la profondeur fonctionnelle de chaque module pour améliorer l'expérience utilisateur.
3. Avancer le développement **ulives** et explorer plus de support de plateformes.
4. Continuer à améliorer les API et autres aspects.

---

### II. Bilan et perspectives

#### 2.1 À propos de **ulives**

En 2025, nous avons lancé **ulives** sur iOS comme produit de nouvelle génération de LifeUp. Certains utilisateurs se demandent peut-être : pourquoi lancer une nouvelle App ? Pourquoi payer à nouveau ?

Voici nos réflexions et explications :

**Contraintes technologiques et architecturales**

LifeUp est développée sur la base de la technologie Android et a accumulé beaucoup de logique et de problèmes de compatibilité historique au fil de son développement. Compte tenu des contraintes d'architecture technique, il est quasi impossible de reproduire une version identique sur iOS ou HarmonyOS tout en maintenant la compatibilité des données.

De plus, LifeUp s'est développée progressivement, avec certaines conceptions produit compromises par la compatibilité et les décisions de design initiales, que nous ne pouvons peut-être pas changer facilement. Par exemple :

- **Monnaie personnalisée** : LifeUp repose sur un type de monnaie sous-jacent, rendant les changements architecturaux majeurs difficiles.
- **Module World** : Tôt dans le développement de LifeUp, en raison d'une coopération côté serveur, nous avions prévu d'ajouter ce module, mais la plupart des fonctionnalités n'ont pas été suffisamment considérées, ce qui se traduit aujourd'hui par un manque de fonctionnalités d'équipe.

Créer quelque chose de nouveau nous permet de considérer ces éléments sous un nouvel angle produit avec des concepts modernes.

**Dette technique**

Technologiquement, LifeUp a aussi marché sur des mines :

- Utilisation d'un framework ORM de base de données adapté au développement rapide initial mais pratiquement non maintenu, rendant la migration difficile.
- La couche sous-jacente ne supporte même pas les index composites, causant des goulots d'étranglement de performance.
- Nous avons consacré un effort considérable à optimiser continuellement les performances de l'App sous de grands volumes de données.

Pour **ulives**, nous avons utilisé une technologie multi-plateforme moderne (Kotlin Multiplatform) pour réexaminer et développer ces aspects. Les possibilités futures incluent l'extension vers Android ou d'autres plateformes (actuellement ne supporte que iOS, iPadOS et macOS).

**Coût et tarification**

Le faible tarif unique initial de LifeUp et le positionnement mono-plateforme nous ont laissé un contrôle des coûts limité pour les fonctionnalités nécessitant un investissement (comme le module World ou les fonctionnalités IA).

Le faible tarif de LifeUp (Android) est basé sur les coûts de maintenance mono-plateforme. **ulives** pourra avoir certains ajustements et plus de planification.

Comme les équipes de développement sont différentes, c'est un redéveloppement complet, et **ulives** est actuellement entièrement offline. Nous ne pouvons effectivement pas partager les adhésions ni offrir de remises supplémentaires, et pourrions ne pas fournir de telles remises à l'avenir pour ne pas léser les utilisateurs payants.

---

#### 2.2 Efficacité IA

Ces dernières années, nous avons assisté au développement florissant du développement assisté par IA, où de nombreux développeurs peuvent utiliser l'IA pour développer app après app en peu de temps.

En effet, nous essayons aussi d'utiliser l'IA dans notre processus de développement pour implémenter rapidement les cadres fonctionnels principaux et le scaffolding de code. Cependant, l'IA n'est pas toute-puissante — déterminer les routes de solution technique, l'acceptation finale et s'assurer que tout fonctionne nécessite encore un effort humain significatif.

Ce qui prend vraiment du temps, c'est le polissage des détails. Surtout pour l'optimisation des animations sur iOS, le réglage de la fluidité des interactions, la gestion des cas limites — le temps investi ici est souvent plusieurs fois celui de la logique fonctionnelle elle-même.

---

#### 2.3 Extensions utilisateurs et intégration IA

Nous avons aussi vu de nombreux utilisateurs implémenter des fonctions intéressantes en combinant l'IA avec l'API de LifeUp :

- Certains utilisent MCP (Model Context Protocol) pour connecter LifeUp à diverses chaînes d'outils IA
- Certains combinent LifeUp avec des apps de notes comme Obsidian pour l'automatisation de workflow
- Certains implémentent leurs propres outils web et scripts d'automatisation via les API

Nous continuons à accueillir les utilisateurs partageant des méthodes d'extension basées sur l'IA, et avons hâte de voir plus d'idées intéressantes !

---

#### 2.4 Rythme de développement et qualité

Nous insistons sur la maintenance à long terme de LifeUp, **ulives** et nos autres apps. Nous avons déjà des plans et objectifs de développement pluriannuels pour LifeUp, et continuerons à avancer.

Nous ne chercherons pas à lancer rapidement de nouvelles fonctionnalités en ignorant la qualité et la stabilité. Chaque fonctionnalité passe par une conception, un développement, des tests et une optimisation soignés pour s'assurer que le produit final livré peut résister à l'épreuve du temps.

C'est pourquoi nous choisissons d'investir plus de temps dans l'approfondissement et l'optimisation des fonctionnalités existantes plutôt que de lancer continuellement de nouveaux modules fonctionnels.

---

#### 2.5 Points forts de la communauté

Nous avons eu la chance de rencontrer de nombreux utilisateurs remarquables :

- Un utilisateur a rencontré un problème de crash étrange de LifeUp. Après plusieurs échanges d'informations, il a exporté son journal système (bugreport) et utilisé l'IA pour analyser que c'était causé par une corruption des données du calendrier système. Comme LifeUp utilise les notifications calendrier, l'App a été tuée par erreur par le système. Cela nous a aidés à identifier ce problème de compatibilité système extrêmement obscur.
- De nombreux utilisateurs ont partagé leurs créations, y compris des systèmes de Tâches intéressants, des designs d'Objets, des partages de Succès et d'autres contenus communautaires.

Le soutien massif de nos utilisateurs est ce qui nous pousse à continuer à maintenir et mettre à jour nos produits.

---

> Aperçu : En 2025 nous avons aussi lancé **ulives**, développée avec Kotlin Multiplatform, ne supportant actuellement que iOS, iPadOS et macOS, avec des plans pour supporter plus de plateformes à l'avenir.

# Notes de version

## Chronologie

![timeline](_media/release_log/timeline.png)

## Notes

| Plateforme        | Version                | Date de mise à jour         |
| :---------------- |:-----------------------|:----------------------------|
| LifeUp-Android    | v1.105.3              | 2026/08/26                  |
| LifeUp-iOS        | voir [feature/ulives] | 🎉App alternative disponible |
| LifeUp-Desktop    | v1.2.0                 | 2025/01/01                  |
| LifeUp Cloud(SDK) | v2.1.1                 | 2026/06/16                  |

(Une partie de la traduction a été générée par traduction automatique ou IA et peut contenir des imprécisions)

<!-- tabs:start -->

### **LifeUp-Android**

**v1.105.3 (2026/08/26)**

**🐛 Corrections**

1. **Correction de la finalisation anormale de Tâches après conversion locale d'une tâche d'équipe en tâche chronométrée.**

**v1.105.2 (2026/08/24)**

**🐛 Corrections**

1. **Correction du sélecteur de Tâches affichant une liste vide lorsqu'une liste intelligente est sélectionnée.**
2. **Correction de la recherche dans une liste intelligente affichant aussi des Tâches n'appartenant pas à cette liste.**

**v1.105.1 (2026/08/19)**

**✨ Fonctionnalités**

1. **Les effets sonores personnalisés peuvent être désactivés par scène** : coupez un signal sans affecter les autres ; l'aperçu reste disponible pour vérifier le son.

**♻️ Optimisation**

1. **Guide de sauvegarde plus clair lorsque les services Google Play sont indisponibles** : si Google Drive ne peut pas être utilisé, l'App explique pourquoi et suggère un fichier local, Dropbox ou WebDAV.

**🐛 Corrections**

1. **Correction du bouton Annuler sur la page Terminées du calendrier qui ne répondait pas.**
2. **Correction des limites d'achat/utilisation qui n'étaient pas restaurées (ou enregistrées vides) lors de l'édition d'un Objet.**

**v1.105.0 (2026/08/04)**

**ℹ️ Note importante**

1. **Android 6.0 est désormais la version minimale prise en charge** : pour anticiper les fonctionnalités et exigences des versions Android plus récentes, la version minimale est passée d'Android 5.0 à Android 6.0. Les utilisateurs Android 5.x ne peuvent pas installer ni mettre à jour vers cette version.

**✨ Fonctionnalités**

1. **Nouvelle API URL Scheme de contrôle Pomodoro** : les utilisateurs peuvent consulter l'état, sélectionner une Tâche et démarrer, mettre en pause, passer, abandonner ou terminer des sessions Pomodoro ou de comptage ascendant.
2. **Mécanisme d'ordre personnalisé des Tâches amélioré** : un nouveau mécanisme d'ordonnancement maintient l'ordre personnalisé stable lors de la copie, de la finalisation, de l'annulation et dans d'autres cas limites.

**♻️ Optimisation**

1. **Prise en charge du retour prédictif Android** : les éditeurs de Tâches, Boutique, Synthèse et Succès prennent désormais en charge le geste de retour prédictif du système.
2. **Initialisation de la connexion Facebook améliorée** : le SDK s'initialise à la demande de connexion, avec une meilleure gestion des états d'erreur.

**🐛 Corrections**

1. **Correction des requêtes URL Scheme d'édition écrasant des champs existants de façon inattendue** : les champs omis conservent leurs valeurs précédentes, et les paramètres de Récompense ou de relation invalides n'effacent plus les données existantes.
2. **Correction des titres de notification du minuteur positif ne suivant pas la Tâche sélectionnée dans certains cas limites.**
3. **Correction de l'aperçu RGB ne se rafraîchissant pas après le premier collage d'une valeur hexadécimale.**
4. **Correction des ombres manquantes sur la barre d'outils de sélection dans les pages de détail Synthèse et Succès.**

**v1.104.6 (2026/07/19, Google Play)**

**🐛 Corrections**

1. **Correction de la restauration incorrecte des sessions Pomodoro après un arrêt inattendu de l'App ou du service minuteur** : les sessions valides se restaurent correctement, l'état obsolète invalide est nettoyé.
2. **Correction des invites répétées après un changement de fuseau horaire système** : après confirmation de l'ajustement, les horaires des Tâches sont mis à jour sans réafficher la même invite.

**v1.104.5 (2026/07/17)**

**🐛 Corrections**

1. **Correction d'un problème dans la build v1.104.4 où l'ouverture de la page Pomodoro pouvait provoquer un plantage de l'App.**

**v1.104.4 (2026/07/17)**

**✨ Fonctionnalités**

1. **Les Objets prennent en charge des restrictions d'achat/utilisation selon des plages de Points d'Expérience d'Attributs** : définissez des conditions XP minimales et maximales pour contrôler si un Objet peut être acheté, utilisé ou les deux.
2. **Nouvelle condition de Succès pour finaliser des Tâches un total de N fois par jour** : contrairement à la condition de Tâches distinctes existante, cette condition compte chaque finalisation valide ce jour-là, y compris les répétitions de la même Tâche.

**♻️ Optimisation**

1. **Flux de règlement et de récupération Pomodoro reconstruit** : l'état du minuteur, les enregistrements de Concentration et le règlement des Récompenses suivent un processus unifié. La récupération est aussi plus fiable si le processus de l'App est terminé, réduisant les cas limites comme la perte de temps de Concentration. Si vous constatez des changements inattendus, contactez-nous à lifeup@ulives.io.
2. **Édition des quantités plus fluide pour les recettes de Synthèse** : touchez un ingrédient ou un résultat existant pour modifier sa quantité directement, sans resélectionner le même Objet. Vous pouvez toujours resélectionner l'Objet si nécessaire.
3. **Le Pomodoro peut s'ouvrir en paysage directement depuis l'accueil** : consultez et utilisez le minuteur plus confortablement en disposition horizontale.

**v1.104.3 (2026/07/09)**

**✨ Fonctionnalités**

1. **Nouveau guide « Configuration rapide » sur l'écran d'accueil** : deux nouvelles pages (5 et 6) après les cartes d'intro permettent de configurer les permissions de notification, la méthode de rappel, le style d'interface (Material 2/3) et l'affichage multi-fenêtres dès l'onboarding — avec des cartes en accordéon. Toutes les options restent modifiables plus tard dans les Paramètres.

**♻️ Optimisation**

1. **Texte d'intro de la page d'accueil mis à jour** : les pages 1–4 ont été réécrites pour mieux communiquer la valeur centrale de l'App : Tâches personnalisées → croissance des stats → système de Récompenses → connexion au monde.
2. **Dialogue Synthèse repensé en bottom sheet** : matériaux et résultats s'affichent dans une grille verticale, pour une mise en page plus claire et intuitive.
3. **Chargement des données plus rapide lors du changement de listes de tâches, de l'ordre de tri ou du regroupement**.

**🐛 Corrections**

1. **Correction des notifications « Succès débloqué » en double** pour certains Succès système.
2. **Correction du décompte inexact pour le Succès « Finaliser N Tâches distinctes par jour »** : les Tâches infinies ne sont plus exclues, et finaliser la même Tâche plusieurs fois le même jour compte pour une.
3. **Correction du bouton d'ajout (+) de la liste de Tâches se décalant parfois de sa position.**
4. **Correction des listes intelligentes ne filtrant pas les Tâches archivées lorsque « Regrouper par liste » est désactivé.**

**v1.104.2 (2026/07/03)**

**✨ Fonctionnalités**

1. **« Jours d'utilisation » renommé « Jours de compagnie » sur la page de statistiques** : touchez la carte pour personnaliser la date de début et définir votre propre anniversaire. Les descriptions de conditions de Succès associées utilisent aussi la formulation « compagnie ».
2. **Option « Sauvegarde et partage » ajoutée au menu de sauvegarde** : partagez les fichiers de sauvegarde directement vers d'autres apps via le panneau de partage système.
3. **API d'effets Boîte de butin v2** : une nouvelle route `loot_box/v2` prend en charge la correspondance précise d'Objets via `sub_amount`, l'ajout/suppression d'Objets et le contrôle indépendant des modes quantité et probabilité.

**♻️ Optimisation**

1. **URL Scheme privilégie désormais la correspondance exacte par nom** lors de l'édition d'Objets Boutique, Boîtes de butin ou sous-tâches, avec recherche floue uniquement en l'absence de correspondance exacte — évitant des modifications involontaires.
2. **« FAQ » de la barre latérale renommé « Notice » en anglais** : la version chinoise était déjà « 公告 » et reste inchangée.
3. **Effets ripple des boutons alignés sur le rayon des coins partout** : les animations ripple sur les contrôles arrondis ne dépassent plus les coins, pour des interactions plus soignées dans toute l'App.

**🐛 Corrections**

1. **Correction de la page Pomodoro ne rafraîchissant pas automatiquement le nombre de tomates après ajout ou édition d'un enregistrement.**
2. **Correction du toast des tomates gagnées n'apparaissant parfois pas après ajout d'un enregistrement Pomodoro.**
3. **Correction des enregistrements Pomodoro ajoutés manuellement calculant les tomates selon la Tâche sélectionnée au moment présent au lieu de celle choisie dans l'enregistrement** : le calcul utilise désormais la durée de Concentration spécifique à la Tâche réellement sélectionnée dans l'enregistrement. Si vous avez défini des durées de Concentration différentes par Tâche, les tomates saisies manuellement seront plus précises.
4. **Correction de l'affichage incorrect du « nombre de finalisations » pour les Tâches illimitées dans l'historique** : affiché comme ordinal quotidien (p. ex. « la Nième fois ce jour-là »).
5. **Correction du texte de motivation des Tâches pénalisantes absent** — il apparaît désormais après la finalisation de la pénalité.

**v1.104.1 (2026/06/17)**

**✨ Fonctionnalités**

1. **Options d'export de sauvegarde enrichies** : lors d'une sauvegarde manuelle, une nouvelle bottom sheet permet de choisir d'inclure les fichiers média, les infos sensibles du compte (état de connexion, identifiants WebDAV, etc.) et les images emoji — pour partager facilement une sauvegarde épurée. La section sauvegarde automatique reçoit aussi trois bascules persistantes correspondantes.
2. **Sélecteur de Tâches Pomodoro amélioré** : les Tâches chronométrées apparaissent en premier avec leur progression de Concentration (durée concentrée / durée cible / pourcentage). Une bascule active ou désactive la priorité aux Tâches chronométrées pour un accès rapide.
3. **Refonte de la page À propos** : réorganisée en sections Liens, Retour, Communauté et Développeur, avec de nouvelles entrées pour le site, le journal des versions, la FAQ et la doc API. Les utilisateurs en chinois simplifié ont une entrée Tencent Channel ; les utilisateurs internationaux accèdent à GitHub Issues/Discussions.
4. **Retirer des abonnés** : vous pouvez retirer des abonnés depuis la page des membres d'équipe.
5. **Amélioration du sélecteur d'Attributs Boutique** : bouton sélecteur d'Attributs ajouté au dialogue exp/effet Boutique, avec filtrage rapide par groupe de Compétences et sélection multiple par lot — bien plus pratique avec de nombreux Attributs.

**♻️ Optimisation**

1. **Statistiques Pomodoro avec format horaire commutable** : touchez la zone de stats Pomodoro dans le détail de Tâche pour alterner entre « heures/minutes », « jours/heures/minutes » et « minutes totales ».
2. **État de sous-tâches terminées plus clair** : les sous-tâches terminées sont barrées, distinguant mieux fait et en attente.
3. **Tri des enregistrements Pomodoro corrigé** : tri par heure de fin décroissante.

**🐛 Corrections**

1. **Correction du texte du bouton de retrait DAB dans plusieurs langues** : correction d'un usage incorrect du gérondif dans certaines locales.
2. **Correction du partage d'Objets Boutique sans connexion** : comportement anormal lors du partage d'Objets Boutique sans être connecté.
3. **Correction de l'état sélectionné du sélecteur de couleur** : le dialogue affichait un état de sélection incorrect.

**v1.104.0 (2026/05/23)**

**✨ Fonctionnalités**

1. **Les Tâches de comptage prennent en charge le règlement de Récompenses proportionnel en temps réel** : utile pour des Tâches avancées plusieurs fois à des moments flexibles dans un cycle, comme des habitudes finalisées quelques fois par semaine. Quand la progression du comptage change, LifeUp peut accorder ou annuler Exp, pièces et Récompenses d'Objets selon la progression actuelle au lieu d'attendre la finalisation.
2. **Outils d'historique du détail de Tâche plus puissants** : sélectionner une date dans le calendrier d'historique affiche le comptage du jour, avec ajout, édition ou création par lot d'enregistrements.
3. **Émotions et Objets mieux connectés** : le détail d'Objet peut accéder directement aux Émotions associées, et la page Émotions permet de filtrer par Objet Boutique.
4. **Heures de finalisation des sous-tâches enregistrées** : LifeUp enregistre quand chaque sous-tâche est terminée, préparant les données pour une future API et LifeUp Cloud.

**♻️ Optimisation**

1. **Filtres de visibilité des Objets Boutique plus précis** : en plus des Objets épuisés, vous pouvez masquer ceux dont l'achat est désactivé, limité ou momentanément inabordable. Les widgets Boutique suivent les mêmes règles.
2. **Recherche et rafraîchissement de la liste de Tâches plus stables** : la recherche en liste normale peut inclure les Tâches terminées visibles selon les paramètres ; le rafraîchissement des Tâches répétées et le tri personnalisé dans la liste Toutes sont plus stables avec beaucoup de Tâches.
3. **Statistiques d'historique du détail de Tâche selon la date sélectionnée** : Tâches de comptage et illimitées utilisent des niveaux de couleur différents sur la carte de contribution selon le nombre de finalisations du jour. Les stats mensuelles, annuelles, totales et séries sous l'historique se calculent aussi depuis la date sélectionnée au lieu des données du jour.
4. **Tri alphabétique plus intuitif** : le tri alphabétique suit l'ordre numérique naturel, les noms contenant des chiffres étant ordonnés par valeur numérique plutôt que caractère par caractère.
5. **Saisie des paramètres Boutique améliorée** : les champs focalisés défilent au-dessus du clavier virtuel.
6. **Gestion du mode sombre système plus fiable** : correction de courses d'état entre thème système et bascule manuelle du mode nuit.
7. **API URL Scheme élargie** : Ajouter/Modifier Tâche prend en charge la sémantique `no_deadline`, et les API de Tâches de comptage le drapeau de règlement en temps réel.
8. **Enregistrements d'intérêts de l'historique plus clairs** : les enregistrements d'intérêts DAB et crédit affichent le principal et les jours d'intérêt.

**🐛 Corrections**

1. **Correction des statistiques de Succès sur Ma page** : lorsque les Succès système sont masqués, les comptages suivent la même règle de visibilité.
2. **Correction de la formulation des enregistrements d'historique** : les enregistrements d'abandon ne s'affichent plus avec une formulation de pénalité de retard.
3. **Correction de la gestion des textes longs dans les API URL Scheme** : les descriptions longues de Compétences et Succès ne sont plus tronquées trop tôt.

**v1.103.6 (2026/05/10)**

**🐛 Corrections**

1. **Correction de l'indication d'intervalle de longue pause ne revenant pas à l'état initial de session de Concentration après Abandonner.**
2. **Correction du minuteur de Concentration additionnel restant visible et actif après Abandonner.**

**v1.103.5 (2026/05/10)**

**🐛 Corrections**

1. **Correction de l'indication de longue pause Pomodoro ne se rafraîchissant pas assez vite après une session de travail terminée naturellement.**
2. **Correction du minuteur Pomodoro affichant l'ancien intervalle de longue pause à 2 sessions avant l'ouverture des paramètres Pomodoro, au lieu de 4 sessions par défaut.**

**v1.103.4 (2026/05/05)**

**🐛 Corrections**

1. **Correction d'un problème où des Tâches pouvaient disparaître après une interruption anormale en état gelé dans certains cas limites.**

**v1.103.3 (2026/05/05)**

**ℹ️ Note de version**

1. **Cette version a été ignorée et n'a pas été publiée.**

**v1.103.2 (2026/04/30)**

**🐛 Corrections**

1. **Correction d'un problème de compatibilité où les champs de saisie pouvaient ne pas apparaître lors de l'édition des restrictions d'achat ou d'utilisation d'Objets dans certaines langues ou sur petits écrans.**
2. **Correction d'un problème où l'utilisation d'un Objet déclenchait incorrectement un dialogue de pénalité.**

**v1.103.1 (2026/04/25)**

**🐛 Corrections**

1. **Correction d'un comportement anormal lorsque l'effet d'utilisation d'un Objet modifie sa propre quantité**
2. **Correction de plantages et lenteurs capturés en production**
3. **Correction de valeurs de quantité incorrectes lors de l'édition de l'effet « Modifier la quantité d'Objet »**

**v1.103.0 (2026/04/12)**

**✨ Fonctionnalités**

1. **Les Attributs prennent en charge les sous-catégories et le déplacement rapide** : regroupez les Attributs plus clairement et déplacez un Attribut vers un groupe cible plus vite.
2. **Sélection d'Attributs plus fluide** : édition de Tâches, flux de Récompenses et autres sélecteurs d'Attributs plus faciles à parcourir avec de nombreux Attributs.
3. **Les Objets prennent en charge des restrictions d'achat/utilisation** : limites sur achat, utilisation ou les deux, avec des conditions enrichies (heure, Succès débloqués, Tâches terminées, quantité d'Objets possédés, plages de Niveaux d'Attributs).
4. **Les Succès ajoutent plus d'options de tri intégrées** : en plus de l'ordre personnalisé, tri alphabétique, par heure de finalisation et par date de création.
5. **Les Succès prennent en charge le déplacement rapide vers des sous-catégories** : déplacez un ou plusieurs Succès vers une sous-catégorie cible plus efficacement.
6. **La gestion des retards inclut désormais une entrée d'aide** : le dialogue de retard inclut une aide et présente plus clairement les changements de Récompense lors du retour à terminé.

**♻️ Optimisation**

1. **Affichage groupé des Attributs plus clair** : la page d'état et les dialogues de description présentent les Attributs groupés de façon plus structurée.
2. **Interactions liées aux Attributs plus cohérentes** : affichage groupé et sélection unifiés dans les dialogues d'Attributs et flux d'édition associés.
3. **Édition des restrictions d'Objets plus lisible** : types de restrictions plus riches, plus faciles à configurer et vérifier.
4. **Rendu barre d'état et barre supérieure plus stable sur plusieurs pages** : zones supérieures Boutique, Monde, Recherche, État, Succès, Ma page et WebDAV plus cohérentes au défilement, en mode sombre et Material You.
5. **Mise en page des Attributs sur la page d'état mieux adaptée aux textes longs** : noms d'Attributs et libellés de Niveau plus longs tiennent mieux, y compris sur écrans étroits ou grande police.

**🐛 Corrections**

1. **Correction du problème de variation de gid à la génération de copies** : les Tâches copiées depuis des Tâches en retard uniques ou infinies avaient des gids incohérents.
2. **Correction de la case « Aléatoire » non fonctionnelle dans la sélection d'Attributs** : certaines cases affichaient une case « Aléatoire » inactive.
3. **Correction du positionnement des bannières de Récompense** : bannières mal positionnées, masquées ou instables dans certains scénarios (surtout à la finalisation de Tâches).
4. **Correction de l'aperçu/animation de Récompense en cas de retard** : au retour à terminé, les changements XP, pièces et Objets sont présentés plus précisément sans valeurs confuses.
5. **Correction du retour à la ligne/désalignement de Niveau sur la page d'état dans certains cas** : mise en page plus stable avec noms d'Attributs ou libellés de Niveau longs.
6. **Correction du changement de page lorsque la liste Synthèse est courte** : balayage horizontal depuis les zones vides plus fiable avec peu d'éléments.
7. **Correction d'un plantage lors de la réclamation de Récompenses de Succès dans des cas particuliers.**

**v1.102.11 (2026/04/02)**

**🐛 Corrections**

1. **Correction d'échecs occasionnels de règlement et d'anomalies de rafraîchissement sur les Tâches de comptage de l'accueil.**

**v1.102.10 (2026/03/24)**

**🐛 Corrections**

1. **Correction d'un problème où les listes de formules Synthèse masquées ne pouvaient pas être maintenues pour éditer ou supprimer des formules.**

**v1.102.9 (2026/03/23)**

**♻️ Optimisation**

1. **Règle de désactivation de la navigation inférieure mise à jour** : au niveau interaction, il n'est plus possible de désactiver tous les modules de navigation inférieure.

**🐛 Corrections**

1. **Correction d'un plantage au démarrage** : l'App pouvait planter au lancement si tous les modules de navigation inférieure étaient désactivés.

**v1.102.8 (2026/03/23)**

**✨ Fonctionnalités**

1. **Réinitialiser la disposition par défaut des modules** : bouton « Restaurer la disposition par défaut » sur la page de configuration des modules.
2. **Nouvel événement broadcast de formule Synthèse** : événement API `app.lifeup.synthesis.complete`, envoyé quand une formule Synthèse se termine avec succès.
3. **La recherche Monde prend en charge le filtrage par tag source** : la section Monde peut filtrer par tags source, p. ex. filtrer les Objets API dans Vitrine avant la recherche.

**♻️ Optimisation**

1. **Typographie de la popup de déblocage de Succès améliorée** : rendu des polices et moins de problèmes de mise en page avec grandes tailles système.
2. **Logique de masquage des modules améliorée** : les Succès liés au module Monde s'affichent ou se masquent correctement.
3. **Comportement par défaut d'assignation des Tâches aléatoires ajusté** : les nouvelles Tâches aléatoires ne sont plus assignées automatiquement à la liste par défaut.

**🐛 Corrections**

1. **Correction d'un plantage rare lors du rafraîchissement de la liste de Tâches**.
2. **Correction du problème de titre API Émotions** : l'API ne fournissait pas correctement le titre Émotions, affectant parfois les titres d'Objets.
3. **Correction des problèmes de mise en page Pomodoro en paysage**.
4. **Correction du type d'horodatage de fin dans l'API historique des Tâches**.
5. **Champs de réponse API manquants ajoutés** : progression, état de finalisation, conditions de fin de récurrence et champs associés renvoyés correctement.
6. **Correction de valeurs obsolètes sur la page détail des Tâches de comptage** : rafraîchissement immédiat après mise à jour.
7. **Correction d'un problème pouvant provoquer des durées anormales d'enregistrements Pomodoro**.
8. **Correction de l'accueil ne se reconstruisant pas immédiatement en mode hors ligne** : la section Monde pouvait rester visible de façon inattendue.
9. **Correction d'un problème de chargement sur la page Tâches aléatoires** : la page pouvait rester bloquée en chargement.

**v1.102.2 - v1.102.7 (2026/02/03)**

**♻️ Optimisation**

1. **Tutoriel widgets + améliorations de texte** : guide d'ajout de widgets et textes/indications affinés.

**🐛 Corrections**

1. **Correction du blocage Pomodoro avec données anormales** : la page Pomodoro ne reste plus figée avec des données anormales.
2. **Correction de la désynchronisation du minuteur d'ajout de temps après extinction de l'écran** : le minuteur « ajouter du temps » reste synchronisé après extinction ou veille.
3. **Correction de la sélection de liste par défaut pour nouvelles Tâches** : meilleure gestion depuis les listes intelligentes, surtout si la liste par défaut est archivée (repli correct).

**v1.102.1 (2026/01/27)**

**✨ Fonctionnalités**

1. **Zoom d'aperçu d'image** : fonction de zoom restaurée après la refonte des pages, pour voir les détails plus facilement.

**🐛 Corrections**

1. **Optimisation mémoire WebDAV** : correction d'une consommation mémoire excessive lors des téléchargements WebDAV, pouvant provoquer plantages ou lenteurs.
2. **Rafraîchissement d'images Émotions** : les images éditées sur la page Émotions ne se rafraîchissaient pas immédiatement.

**v1.102.0 (2026/01/25, remplacée par v1.102.1 pendant le déploiement progressif)**

**✨ Fonctionnalités**

1. **Gestionnaire de sons** : importer, prévisualiser, supprimer et réutiliser des effets sonores, et les utiliser comme effets d'utilisation d'Objets.
2. **Boutique : nouveaux effets d'utilisation d'Objets** : EXP aléatoire, changements de stock, lecture sonore et flux de configuration amélioré.
3. **Tâches chronométrées** : nouveau type de Tâche avec durée de Concentration attendue ; finalisez la Tâche après l'objectif du minuteur.
4. **Options de début de semaine** : choisissez lundi / samedi / dimanche ; calendrier et statistiques suivent.
5. **Ignorer l'onboarding** : option pour passer le tutoriel au premier lancement.
6. **Saisie emoji pour les icônes** : entrez un emoji (y compris combinés) pour créer une icône rapidement.
7. **Calendrier : ouvrir le détail des Tâches récurrentes futures** : toucher une Tâche récurrente à une date future ouvre correctement son détail.
8. **Utilisateurs avancés : améliorations API** : l'API URL Scheme ajoute/étend le CRUD de modèles de Tâches, conditions de fin de récurrence, navigation de filtres Synthèse, etc.

**♻️ Optimisation**

1. **Performances et fluidité améliorées** : accès aux données et indexation optimisés pour listes de Tâches, historique Inventaire et statistiques plus fluides avec gros volumes.
2. **Meilleure UX de configuration des effets d'Objets** : sélection et affichage des effets améliorés, dialogues et icônes affinés.
3. **Améliorations de localisation** : traductions manquantes complétées dans plusieurs langues.

**🐛 Corrections**

1. **Correction de la réinitialisation de l'effet compte à rebours à l'édition** : confirmer un effet compte à rebours édité pouvait remettre la valeur à 1.
2. **Correction de l'utilisation automatique de Récompenses d'Objets sur Tâches d'équipe ne se déclenchant pas** : l'auto-utilisation ne se déclenchait pas après réclamation de Récompenses d'Objets d'équipe.
3. **Correction de l'invite « enregistrer Émotions » absente après Boîte de butin / Synthèse** : le dialogue Émotions pouvait ne pas apparaître après ouverture de Boîtes de butin ou Synthèse simple quand l'Objet a l'effet « enregistrer Émotions ».
4. **Correction des dialogues de règlement absents lors d'une finalisation manuelle Pomodoro** : finaliser manuellement une Tâche sur Pomodoro pouvait sauter les dialogues Récompenses/Émotions ; appui long sur le titre restauré.
5. **Correction du filtre repli widgets inefficace** : le filtre widget liste intelligente « Replier les Tâches non commencées » ne s'appliquait pas.
6. **Correction d'un plantage rare** : plantage dû à trop d'état sauvegardé dans certains cas.
7. **Correction de la navigation calendrier → détail pour Tâches futures** : échecs à l'ouverture de Tâches récurrentes futures depuis le calendrier.
8. **Correction de problèmes avec Tâches récurrentes Ebbinghaus** : étapes anormales et génération répétée indésirable dans de rares cas, avec garde-fou de limite supérieure.

**v1.101.8 (2026/01/12)**

**🐛 Corrections**

1. **Correction des paramètres de condition de fin de récurrence** : impossible de définir la fin pour « Tous les 2 jours » ou « Tous les N jours » personnalisé.
2. **Correction de la durée anormale du minuteur Pomodoro** : le minuteur pouvait durer bien plus que prévu à cause de la veille système ou du gel du processus si l'optimisation batterie n'était pas correctement désactivée.

**v1.101.7 (2026/01/11)**

**🐛 Corrections**

1. **Correction d'un problème pouvant raccourcir anormalement la durée du minuteur Pomodoro**.

**v1.101.6 (2026/01/10)**

**🐛 Corrections**

1. **Correction d'anomalies liées au basculement du mode sombre système**.

**v1.101.5 (2026/01/08)**

**♻️ Optimisation**

1. **Basculement mode sombre système optimisé** : correction des cas où l'App ne suivait pas automatiquement le thème système.
2. **Sélection d'Attributs pour Récompenses optimisée** : meilleure gestion sans Attribut sélectionné dans « Récompenses de persistance », « Récompenses par paliers » et « Récompenses J'aime ». Désélection d'Attributs prise en charge ; correction des Récompenses d'expérience mal accordées.
3. **Optimisation de configuration des performances** : réglages internes pouvant améliorer les performances de l'App.

**🐛 Corrections**

1. **Correction des requêtes statistiques et affichage des graphiques** : conditions corrigées pour les stats d'heure de finalisation de Tâches et données de graphiques inexactes.
2. **Correction de l'interaction du dialogue paramètres widget** : bouton « Confirmer » manquant dans le filtre Tâches du widget.
3. **Correction de la synchronisation du nombre de Tâches** : le compteur sur l'accueil ne se rafraîchissait pas correctement après modification depuis le détail de Tâche.
4. **Correction de la gestion d'utilisation d'Objet dans l'API Émotions** : mauvaise gestion des types « Utilisation d'Objet ».
5. **Correction de la navigation calendrier → détail** : plusieurs problèmes en passant du calendrier au détail de Tâche.

**v1.101.4 (2025/12/30)**

**♻️ Optimisation**

1. **Détection des mises à jour membres optimisée** : invite les membres à passer au « Canal stable pour membres » pour recevoir les mises à jour et garantir l'expérience fonctionnelle la plus stable.
2. **Réduction des requêtes réseau inutiles** : économie supplémentaire de données utilisateur et réduction des coûts serveur.

**🐛 Corrections**

1. **Correction de la mise à jour de progression des Succès (prioritaire)** : correction d'un bug où la progression des Succès ne se déclenchait pas correctement à la finalisation d'enregistrements Pomodoro.

**v1.101.3 (2025/12/14)**

**🐛 Corrections**

1. **Correction d'un problème où l'option « Échéance aujourd'hui » ignorait incorrectement le décalage d'échéance au lendemain.**

**v1.101.2 (2025/12/13)**

**🐛 Corrections**

1. **Correction de la réinitialisation de l'état de recherche** au retour sur les pages Boutique, Inventaire ou Tâches.
2. **Correction d'un plantage lié aux limites de `AlarmManager`** (env. 500 alarmes simultanées).
3. **Correction de plantages liés aux couleurs dynamiques, aux dialogues de fuseau horaire et aux menus contextuels.**
4. **Optimisation du rapport de plantages** pour ignorer les erreurs réseau courantes.

**v1.101.1 (2025/12/01)**

**🐛 Corrections**

1. **Correction de plantages potentiels causés par des erreurs de formatage de traduction.**

**v1.101.0 (2025/11/29)**

**✨ Fonctionnalités**

1. **Filtre d'Objets Synthèse** : filtrez la Synthèse par Objets pour une recherche et une gestion plus rapides.
2. **Détail d'Objet → recette de Synthèse** : consultez la recette de Synthèse d'un Objet directement sur sa page de détail.
3. **Boutique → entrée Synthèse** : si un Objet est utilisable en Synthèse, un bouton Synthèse apparaît à côté du bouton Acheter.
4. **Filtres de l'historique Inventaire** : filtres par date, Objets et description.
5. **Dialogue des nouveautés** : résumé de la nouvelle version au premier lancement après mise à jour.
6. **Durée de Concentration Pomodoro par Tâche** : logique Pomodoro refactorisée ; prise en charge d'une durée de Concentration personnalisée par Tâche.
7. **Effet d'utilisation d'Objet : « Enregistrer les Émotions après utilisation »** ; la page Émotions prend aussi en charge le filtrage par Objet.
8. **Diffusions du cycle de vie Pomodoro (API)** : ajout d'événements de diffusion du cycle de vie.
9. **API de requête simple** : prise en charge de la récupération des détails d'une seule Tâche.
10. **Incrémentation automatique des Tâches de comptage** : prise en charge de l'incrémentation automatique.
11. **Fin de récurrence par date** : les Tâches peuvent terminer la récurrence à une date précise.
12. **Amélioration des paramètres de widgets bureau** : page de paramètres des widgets dans l'App améliorée pour prévisualiser chaque widget pris en charge et, lorsque le système le permet, l'ajouter rapidement à l'écran d'accueil.

**♻️ Optimisation**

1. **UX de gestion des listes + mode sombre** : interactions et mode sombre affinés ; la liste « Toutes » affiche désormais un état de suppression désactivé au lieu d'une action impossible à supprimer.
2. **Page des paramètres Boutique** : déplacée vers une page indépendante, accessible depuis les Paramètres principaux.
3. **Arrière-plan par défaut des Tâches** : formulation clarifiée dans le dialogue d'aide.
4. **Indicateur Finalisation rapide** : lorsqu'activé, la page Tâches affiche un indicateur en haut de l'état Finalisation rapide.
5. **Mémorisation du repli par liste** : l'état replié/déplié est enregistré par liste pour éviter que « Toutes » n'affecte la liste du jour.
6. **Dialogue de retard (mode sombre)** : styles mode sombre améliorés lors du traitement des Tâches en retard.
7. **Logique du bouton filtre Émotions** : affiché uniquement pour les types prenant en charge le filtrage (Objets/Tâches).
8. **Flux Tâches locales uniquement en équipe** : interaction améliorée lors de la collecte de Tâches locales uniquement.
9. **Finition UI de la page Synthèse** : mise en page et retour visuel affinés pour une présentation plus fluide.
10. **Finition des interactions Objets** : interactions liées aux Objets simplifiées pour une réponse plus réactive.

**🐛 Corrections**

1. **Correction de la barre de filtres supérieure ne s'affichant pas correctement** après filtrage sur la page Historique.
2. **Correction du calcul des pénalités sur les Tâches négatives** : dans certains cas, le multiplicateur de pénalité 1× n'était pas appliqué correctement.
3. **Correction de la perte de l'option « Annuler la sélection »** dans le sélecteur de Tâches du minuteur Pomodoro dans certaines conditions.
4. **Correction de plusieurs problèmes de suivi du mode sombre système.**
5. **Correction de l'absence de popup de Récompense** lorsqu'un widget finalisait une Tâche de comptage.

**v1.100.6 (2025/11/08)**

**🐛 Corrections**

1. **Correction d'un plantage lors de la sélection d'Objets** si le focus de saisie débordait à cause de claviers externes/manettes ; efficacité de la correction en cours de vérification.
2. **Correction du dialogue intelligent de gestion du fuseau horaire** pour permettre le défilement jusqu'au contenu inférieur et aux boutons.

**v1.100.5 (2025/09/28)**

**✨ Fonctionnalités**

1. **Les effets sonores personnalisés prennent en charge la sélection de sons intégrés** : accédez à une bibliothèque d'effets audio intégrés pour une personnalisation plus pratique.
2. **Filtrage Synthèse amélioré** : option de filtre « Afficher uniquement les synthétisables » sur la page Synthèse pour une meilleure gestion des Objets.
3. **Prise en charge emoji dans l'API** : les API Objets, Attributs et Succès acceptent la saisie directe d'emoji pour une personnalisation accrue.
4. **Améliorations à la création d'équipes** : possibilité de sélectionner des listes cibles lors de la création d'équipes pour une meilleure organisation.
5. **Copie de Tâches d'équipe** : copie de Tâches d'équipe en Tâches locales sans adhésion à l'équipe requise.
6. **Amélioration de l'API Tâches** : prise en charge de paramètres pour l'état « police de note claire » dans les API liées aux Tâches.

**♻️ Optimisation**

1. **Logique « Abandonner les modifications » améliorée** : dialogue de confirmation optimisé pour l'édition d'Objets, Synthèse, Succès et listes de Succès — n'apparaît que lorsque des modifications réelles ont été effectuées.
2. **Conditions de déblocage des Succès** : les conditions de déblocage sont désormais développées par défaut pour une meilleure visibilité.
3. **Performances Synthèse améliorées** : requêtes optimisées sur la page de détail Synthèse.
4. **Stabilité de l'API toast** : appels toast plus stables et fiables.
5. **Flux de finalisation des Tâches d'équipe** : processus amélioré avec une meilleure gestion des erreurs et des indications utilisateur.
6. **Comportement de glisser-déposer Synthèse** : défilement vers le bord amélioré lors du tri personnalisé d'Objets sur la page Synthèse.
7. **Flux de collecte des Tâches d'équipe** : flux amélioré après collecte, avec saut vers les listes correspondantes.
8. **Optimisation des rappels calendrier** : logique des rappels calendrier plus fiable.

**🐛 Corrections**

1. **Correction des arrière-plans personnalisés des anciennes versions** utilisant incorrectement l'état global par défaut « police de note claire ».
2. **Correction de l'adaptation de la barre d'état** sur la page des effets sonores personnalisés.
3. **Correction du chevauchement possible de la description de Succès** avec les boutons de déblocage.
4. **Correction des problèmes de défilement** lors du tri par glisser-déposer sur la page de détail Synthèse.
5. **Correction de la disparition occasionnelle du bouton de recherche** lorsque le module Monde est placé dans la barre latérale.
6. **Tentative de correction des anomalies de suivi du mode nuit système.**
7. **Tentative de correction d'un problème où des finalisations consécutives de Tâches d'équipe pouvaient entraîner une duplication de Tâches.**
8. **Correction de la défaillance de la fonctionnalité Émotions** lors du déblocage de Succès.

**v1.100.4 (2025/09/07)**

**♻️ Optimisation**

1. **Amélioration du rapport de plantages** : collecte et signalement renforcés pour une meilleure analyse et débogage.

**🐛 Corrections**

1. **Correction d'un plantage causé par le SDK Facebook.**

**v1.100.3 (2025/09/06)**

**🐛 Corrections**

1. **Correction d'un problème où la recherche ne fonctionnait pas** lors de la sélection d'Objets.

**v1.100.2 (2025/09/05)**

**🐛 Corrections**

1. **Correction d'un problème où la liste par défaut ne pouvait pas être sélectionnée** dans certaines situations lors de la création ou de l'édition d'Objets en Boutique.

**v1.100.1 (2025/09/03)**

**✨ Fonctionnalités**

1. **Options de couleur de police pour arrière-plan personnalisé** : prise en charge de couleurs de police de note personnalisées pour une interface plus personnalisée.
2. **Effets d'utilisation d'Objets enrichis** : les effets de réduction aléatoire de pièces prennent aussi en charge l'activation de la fonction « Limiter l'utilisation ».

**♻️ Optimisation**

1. **Optimisation des rappels calendrier** : options pour ajuster la durée des événements de rappel calendrier insérés.
2. **Optimisation de l'interaction d'édition de Tâches** : logique du popup « Abandonner les modifications » améliorée — ne s'affiche plus en quittant sans modification.
3. **Mises à jour de localisation multilingue** : textes localisés mis à jour pour améliorer l'expérience utilisateur.

**🐛 Corrections**

1. **Correction de la page de configuration de compatibilité et de la page des paramètres de rappel** ne s'adaptant pas au mode sombre.
2. **Tentative de correction des plantages liés aux popups et au focus du clavier** sur plusieurs pages, améliorant la stabilité de l'App.
3. **Correction d'un problème où l'édition de Succès ne permettait pas de modifier l'utilisation automatique d'Objets.**

**v1.100.0-alpha (2025/07/29)**

**✨ Fonctionnalités**

1. **Minuteur Pomodoro, Points d'Expérience, historique Inventaire, détails des pièces** : ajout d'un saut en un clic vers la page de statistiques correspondante.
2. **Prise en charge de paramètres d'événements de rappel plus flexibles** (X minutes avant le début ou l'échéance).
3. **Prise en charge du masquage des listes Synthèse.**
4. **Prise en charge du changement d'Attributs** pour les compteurs de pas et les Récompenses de persistance.
5. **Prise en charge de la personnalisation des modules fonctionnels de la barre latérale** (p. ex. placer Boutique, communauté dans la barre latérale ou masquer des modules inutiles).
6. **Ajout de l'option expérimentale « Mode faible restriction »** : assouplit les limites numériques dans l'App (Points d'Expérience, chiffres de pièces, nombre d'Attributs sélectionnables pour les Tâches).
7. **Optimisation de l'UI et de la logique d'interaction du popup de traitement des retards.**
8. **Ajout d'une description pour les options d'utilisation automatique d'Objets.**
9. **Prise en charge de conditions de déblocage répétables supplémentaires** :
   - Acquisition quotidienne de tomates Pomodoro.
   - Temps de Concentration Pomodoro quotidien.
   - Finalisation quotidienne de N Tâches distinctes.
   - Utilisation quotidienne d'un Objet spécifique N fois.
   - Finalisation quotidienne d'une Tâche spécifique N fois.
10. **Options de liste intelligente migrées vers le popup de gestion des listes** (touchez le bouton liste en haut de la page de liste de Tâches).
11. **Ajout de l'option « Finalisation rapide »** : lorsqu'activée, la finalisation des Tâches ignore tous les popups.
12. **Extension de la portée des icônes de pièces personnalisées** : prise en charge des icônes monochromes (p. ex. icônes de pièces en haut de la Boutique).
13. **Le détail d'Objet identifie désormais la liste à laquelle il appartient** : plus facile de confirmer la propriété depuis l'Inventaire.
14. **Lors de l'édition de recettes Synthèse** : prise en charge du tri par glisser-déposer et de l'édition par clic des Objets.
15. **Ajout d'une API pour modifier directement le nombre de pièces.**
16. **L'API de requête prend en charge les informations Pomodoro** (nombre de tomates).
17. **Assouplissement des limites numériques pour certaines API** (API par défaut en faible restriction).
18. **Mécanisme de calcul de progression des conditions de Succès repensé et optimisé** : performances de calcul et vitesse de mise à jour de progression améliorées.

**♻️ Optimisation**

1. **Optimisation des jours de persistance sur Ma page** : prise en charge du recalcul manuel par clic.
2. **Correction des problèmes de mise en page RTL sur la page calendrier** ; début de semaine fixé au **« lundi »** (auparavant dimanche).
3. **L'affichage groupé dans les listes intelligentes Tâches et Boutique** prend en charge le repli/expansion par libellés de groupe.
4. **Lorsque la liste de Tâches développe terminées, non commencées, gelées en bas** : les libellés correspondants apparaissent aussi en haut.
5. **Les icônes d'Objets importées du module Monde sont sauvegardées localement de façon persistante** : évite l'impossibilité de chargement hors ligne.
6. **Le popup de sélection de liste identifie désormais les listes intelligentes.**
7. **Optimisation de la logique de liste par défaut pour Tâches d'équipe et aléatoires** : si la liste par défaut est archivée, sélection de la première liste par défaut.
8. **Optimisation de la logique de traitement des retards pour Tâches de comptage** : si le comptage est atteint, statut **« Terminé »** par défaut.

**🐛 Corrections**

1. **Correction de la restauration de l'état de la case « Utilisation automatique d'Objet »** lors de l'édition de Succès.
2. **Correction du comptage de la carte supérieure de liste intelligente** : échec à exclure les Tâches appartenant à des listes archivées.
3. **Correction de la mémorisation globale de la case « auto-utilisation » à l'achat d'Objet** : mémorisation indépendante par Objet.
4. **Correction de la mise à jour de progression de l'API de déblocage de Succès** dans certaines situations.
5. **Correction des problèmes de logique de liste par défaut** pour Tâches d'équipe et aléatoires.
6. **Mise à jour des bibliothèques de dépendances techniques** ; version API cible ajustée à 35 (Android 15).

**Corrections Alpha/Beta**

1. **Suppression de dépendances inutiles et adaptation à la taille de page 16K** : **réduction de la taille du paquet de l'App**.
2. **Correction de la logique d'utilisation automatique d'Objets** : pour les Objets URL, seul 1 Objet est utilisé et le reste est stocké dans l'Inventaire. (Auparavant, seul 1 prenait effet mais n'était pas stocké dans l'Inventaire, entraînant une perte d'effet d'utilisation)
3. **Correction d'un problème où les conditions de Succès répétables ne recalculaient pas la progression.**
4. **Correction d'un problème où les fichiers de sauvegarde n'incluaient pas les modèles de Tâches.**
5. **Correction d'un problème où la plupart des emojis régénéraient des icônes anormales après restauration de sauvegarde.**
6. **Mise à jour du lien du canal QQ** pour les retours dans l'App.
7. **Ajout de la diffusion de publication d'Émotions.**
8. **Refonte de l'interface de configuration de compatibilité et des paramètres de méthode de rappel.**
9. **Ajout de l'option « Restreindre l'utilisation d'Objet »** pour les **effets de réduction de pièces**.
10. **Mises à jour API** : l'API Tâches prend en charge les paramètres de message motivationnel.
11. **Correction d'un espacement supérieur anormal** sur la page des paramètres par défaut des nouveaux Objets.

**v1.99.5 (2025/07/29)**

**🐛 Corrections**

1. **Tentative de correction d'un problème où les arrière-plans personnalisés pouvaient ne pas s'afficher correctement** dans certaines situations.

**v1.99.3 (2025/06/30)**

**✨ Fonctionnalités**

1. **L'API sous-tâches prend en charge l'ajustement relatif** (`set_type`).
2. **Prise en charge du nettoyage automatique des événements de rappel calendrier expirés.**
3. **Optimisation de la logique de traitement des listes archivées** :

* Les listes intelligentes n'affichent plus les Tâches archivées.
- Les Tâches dans les listes archivées n'avancent pas automatiquement par défaut (similaire au statut gelé).

**♻️ Optimisation**

1. **Lors de l'ajout continu de Tâches/Succès** : prise en charge du défilement automatique vers le haut et du focus sur le champ de saisie.
2. **Optimisation de la formulation liée à la finalisation de Tâches négatives.**
3. **Optimisation de la logique d'affichage du popup « Abandonner les modifications »** sur la page d'édition de Tâches.
4. **Optimisation de la durée des événements de rappels calendrier** pour éviter des problèmes sur certains appareils.

**🐛 Corrections**

1. **Correction d'un problème où les widgets ne prenaient pas en charge l'affichage d'icônes de pièces personnalisées.**
2. **Correction d'un problème où la page de détail de Tâche ne prenait pas en charge l'affichage de Récompenses multi-Objets.**
3. **Correction de problèmes où certains scénarios (p. ex. widgets) ne respectaient pas les règles de tri des listes.**

**v1.99.1-rc02 (2025/06/20)**

**✨ Fonctionnalités**

1. **Prise en charge des conditions de déblocage répétables de Succès « Finaliser N Tâches consécutives ».**
2. **L'API Créer/Modifier Tâche prend en charge le type de Tâche** et l'ajustement relatif des pièces/Points d'Expérience.
3. **L'API Succès prend en charge la définition de pièces** et l'ajustement relatif des pièces/Points d'Expérience.
4. **Les API prennent en charge le saut vers des listes de Succès et de Synthèse spécifiques.**

**♻️ Optimisation**

1. **Optimisation de l'ordre des enregistrements d'historique d'Objets Inventaire** générés à l'ouverture de Boîtes de butin.
2. **Les options de filtre de la page statistiques prennent en charge la mémorisation.**
3. **Les options de la page de filtres prennent en charge l'opération « Tout sélectionner ».**
4. **Renforcement de la logique de déduplication lors de la création de Tâches.**
5. **Opérations complétées sur la page de détail de Tâche** : gel, ajustement d'échéance.
6. **Prise en charge de l'affichage de l'ID de liste Synthèse.**

**🐛 Corrections**

1. **Correction d'un problème où l'ancienne API Tâches ne pouvait pas créer/éditer des Tâches Ebbinghaus.**
2. **Correction d'un problème où l'affichage de la liste de Tâches et le nom de liste dans la barre supérieure pouvaient être incohérents** au lancement depuis le widget de liste de Tâches.
3. **Correction d'un problème où le texte de la carte en mode simple pouvait ne pas s'afficher entièrement.**

**v1.99.0 (2025/05/17)**

**✨ Fonctionnalités**

1. **Prise en charge des types de Succès répétables**
2. **Actions de rappel dans les notifications** : finaliser Tâche, rappeler plus tard
3. **Arrière-plan personnalisé** : option pour améliorer la lisibilité du texte
4. **Prise en charge de l'ajustement du style de recadrage des icônes de Succès**
5. **Prise en charge de l'ajustement des dates d'ancrage des Tâches mensuelles/annuelles**

**♻️ Optimisation**

1. **Optimisation de la logique de calcul de progression de déblocage des Succès**
2. **Amélioration des interactions de sélection d'Objets**
3. **Ajustement de la position du bouton de permission de rappel** lors de la création/édition de Tâches
4. **Optimisation de la logique de stockage de l'heure de rappel relative**
5. **Autorisation de geler les Tâches non répétitives et à répétition infinie**

**🐛 Corrections**

> Certaines corrections seront déployées progressivement sur [Version stable pour membres] et [Version officielle]

1. **Correction d'un problème où l'édition de Succès pouvait réinitialiser accidentellement la progression des conditions de déblocage API**
2. **Correction d'un problème où des Objets avec stock 0 pouvaient encore être achetés via l'API**
3. **Correction d'un problème où des listes supprimées pouvaient être sélectionnées sur la page de nouvel Objet dans certaines conditions**
4. **Correction d'un problème où les modèles de Tâches ne sauvegardaient pas l'état de Récompense de pièces calculée automatiquement**
5. **Suppression des animations de transition de page de détail** pour corriger les échecs d'interaction par appui long
6. **Correction d'un problème où les Tâches gelées apparaissaient dans la sélection de Tâches Pomodoro**
7. **Correction d'un problème où l'édition de Tâches par certaines méthodes réinitialisait incorrectement le statut à incomplet**
8. **Correction de problèmes d'interaction avec les popups Émotions**

**v1.98.5 (2025/05/01)**

**✨ Fonctionnalités**

1. **Prise en charge de la définition de dates d'ancrage** (p. ex. fin de mois) pour les Tâches récurrentes mensuelles et annuelles.
2. **Interaction de sélection multiple améliorée pour les Objets** : mode multi-sélection par défaut et restauration des sélections précédentes lors d'une nouvelle sélection.

**♻️ Optimisation**

1. **Prise en charge de la mémorisation des paramètres d'heure de rappel relative.**
2. **Optimisations UI mineures.**

**🐛 Corrections**

1. **Correction d'un problème où les Objets pouvaient encore être achetés via l'API lorsque le stock Boutique était insuffisant.**
2. **Correction d'un problème où les modèles de Tâches ne restauraient pas les Récompenses automatiques de pièces.**
3. **Correction de l'échec occasionnel de l'appui long sur les titres de Tâches.**
4. **Correction d'un problème où de nouveaux Objets pouvaient sélectionner des listes supprimées dans certaines conditions.**
5. **Correction de l'absence du bouton effacer dans le champ d'heure de rappel lors de l'édition de Tâches.**

**v1.98.4 (2025/04/14)**

**🐛 Corrections**

1. **Correction d'un problème où la barre de progression pouvait ne pas se mettre à jour rapidement** après la finalisation de sous-tâches sur la page de détail de Tâche.
2. **Correction d'un problème où l'édition d'une Tâche terminée pouvait incorrectement rétablir son statut à « incomplet ».**
3. **Correction d'un problème où la modification du statut de Tâches en retard pouvait affecter incorrectement le nombre cible de finalisations.**
4. **Correction d'un problème où la logique de sélection de Tâches Pomodoro affichait incorrectement les Tâches gelées et les listes archivées.**

**v1.98.3 (2025/02/16)**

**♻️ Optimisation**

1. **Ajout d'un avertissement** lors de l'utilisation de la méthode de rappel par notification par défaut sans la permission « alarme exacte ».

**🐛 Corrections**

1. **Correction d'un problème où l'API « finaliser Tâche » ne fonctionnait pas** lorsque le champ UI était true.
2. **Correction d'un problème où l'achat et l'utilisation de certaines quantités d'Objets pouvaient ne pas fonctionner correctement** (p. ex. 10).
3. **Correction d'un problème où la page Émotions pouvait rester indéfiniment en « chargement »** dans certains scénarios.

**v1.98.2 (2025/02/06)**

**🐛 Corrections**

1. **Correction d'un problème où, lors de l'utilisation d'un Objet qui déduit de l'expérience, l'expérience pouvait sembler insuffisante alors qu'elle était suffisante.**
2. **Correction d'un problème où l'édition d'un Objet après copie pouvait produire des effets d'utilisation dupliqués anormaux.**
3. **Correction d'un problème où l'appel de l'API « adjust item » pouvait produire des limites d'achat anormales.**
4. **Correction d'un problème où la modification de certains enregistrements Pomodoro pouvait réduire anormalement le nombre de tomates.**

**v1.98.1 (2025/01/14)**

**🐛 Corrections**

1. **Tentative de correction d'un problème d'autorisation de connexion Google**, où les données d'un nombre limité de comptes ne pouvaient pas être correctement autorisées et analysées.

**v1.98.0 (2025/01/01)**

**✨ Fonctionnalités**

1. **Intégration de la connexion Google et de l'autorisation Drive** via Credential Manager.
2. **Prise en charge de la sélection d'Emoji comme icônes.**
3. **Ajout de l'API ContentProvider Query : fonctionnalité Synthèse.**
4. **Ajout de l'API ContentProvider Query : fonctionnalité d'enregistrement Pomodoro.**
5. **Ajout de l'API ContentProvider Query : prise en charge du retour de plusieurs Objets.**
6. **Ajout de l'API tomato (ajuster le nombre de tomates).**
7. **Ajout de l'API export_backup (exporter une sauvegarde).**
8. **Ajout de l'API purchase_item (acheter un Objet).**
9. **Ajout de l'API synthesize (déclencher une Synthèse).**
10. **Ajout de l'API subtask (créer ou ajuster des sous-tâches).**
11. **Ajout de l'API subtask_operation (opérer sur les sous-tâches, p. ex. finaliser).**
12. **Ajout de l'API synthesis_formula (formule de Synthèse).**
13. **Ajout de l'API edit_task (éditer une Tâche).**
14. **Ajout de l'API category (créer ou ajuster une liste).**
15. **Ajout de l'API history_operation (ajuster l'historique).**
16. **Ajout de l'API AppSettingsScheme (ajuster certains paramètres de l'App).**
17. **Ajout de l'API achievement (créer ou éditer un Succès).**
18. **Ajout de l'API skill (créer ou éditer un Attribut).**
19. **Prise en charge de l'affichage de l'id et du gid des sous-tâches.**
20. **Prise en charge de l'affichage de l'id Synthèse.**
21. **Prise en charge de la requête creditLimit.**
22. **L'API ContentProvider prend en charge la requête de sous-tâches (id, gid).**
23. **API ContentProvider requête Objets : ajout du champ retourné « quantité maximale achetable ».**
24. **L'API ContentProvider Shop prend en charge la requête d'Objets par liste d'id spécifiée.**
25. **Optimisation de la valeur retournée lors de la requête d'une URL ContentProvider incorrecte.**
26. **L'interface de requête prend en charge la requête d'un Succès individuel.**

**♻️ Optimisation**

1. **Optimisation du tri personnalisé par défaut pour les nouveaux Objets.**
2. **Optimisation du tri personnalisé par défaut pour les nouveaux Attributs.**
3. **Ajout des paramètres `purchase_limit`, `disable_use` et `effects` à l'API « add_item ».**
4. **Ajout des paramètres `background_alpha`, `items`, `start_time`, `auto_use_item`, `remind_time` et `pin` à l'API « add_task ».**
5. **Ajout de la prise en charge de plus de fréquences de Tâches à l'API « add_task ».**
6. **Ajout de la prise en charge des paramètres `effects` et `purchase_limit` à l'API « item ».**
7. **Ajout de la prise en charge de la terminaison des opérations dans les API précédentes** (p. ex. saisie).
8. **Ajout de la prise en charge de la spécification du paramètre `signed` pour les espaces réservés numériques.**
9. **Ajout d'espaces réservés de nombre aléatoire et de décimal aléatoire.**

**v1.97.3 (2024/12/16)**

**✨ Fonctionnalités**

1. **Mémorisation de la dernière sélection de l'interrupteur « Utiliser la description d'équipe comme notes de Tâche ».**

**♻️ Optimisation**

1. **Optimisation des performances liées à l'effet d'utilisation des produits.**

**🐛 Corrections**

1. **Correction d'échecs d'appels API spécifiques.** Lors de l'utilisation d'une fonction de rappel spécifique pour appeler l'API produit, la fonction de déballage fonctionne normalement, mais l'opération interne de l'API pour ajouter des Objets ne pouvait pas s'exécuter.

**1.97.2 (2024/12/08)**

**✨ Fonctionnalités**

1. **Ajout de la génération automatique de Tâches via le mécanisme WorkManager du système**, pour éviter l'absence de génération de Tâches lorsque les widgets ne sont pas utilisés et que l'App n'a pas été lancée depuis plus d'un jour.
2. **Amélioration de la gestion des exceptions API** : retour d'un champ `success` unifié et transmission des informations d'exception à l'interface du content provider.

**♻️ Optimisation**

1. **Optimisation de la logique de génération d'heure par défaut** pour améliorer la précision de la génération d'heures mensuelles et annuelles.
2. **Optimisation de la logique de suppression des fichiers image inutilisés**, avec une vérification secondaire depuis la base de données pour éviter les suppressions accidentelles.

**🐛 Corrections**

1. **Amélioration des messages d'erreur API** lorsque les entités sont introuvables.
2. **Correction de problèmes de concurrence dans le téléchargeur intégré.**
3. **Correction de la logique des statistiques Pomodoro pour les scénarios à cheval sur deux jours**, en unifiant l'attribution des enregistrements à la période de l'heure de fin (auparavant, les enregistrements à cheval sur deux jours ne pouvaient pas être correctement attribués à la période du jour).
4. **Correction de problèmes où la continuité des Tâches et les comptages de finalisation par période pouvaient être incorrects** dans certains scénarios.

**1.97.1 (2024/11/20)**

**✨ Fonctionnalités**

1. **Traductions mises à jour.**
2. **Prise en charge de l'affichage automatique de plusieurs Récompenses d'Objets dans les notes.**

**♻️ Optimisation**

1. **Optimisation de la gestion des requêtes réseau** pour réduire les requêtes HTTP inutiles et améliorer les performances.
2. **Optimisation de l'affichage du Niveau sur la page d'état**, améliorant l'expérience visuelle et l'efficacité de transmission de l'information.

**🐛 Corrections**

1. **Correction de la couleur du texte du compteur de sous-tâches.**
2. **Correction des erreurs de calcul d'heure pour les Tâches mensuelles et annuelles**, garantissant des heures de déclenchement précises.
3. **Correction des problèmes de calcul d'heure pour les sous-tâches mensuelles et annuelles**, garantissant que toutes les sous-tâches sont planifiées avec précision.
4. **Correction d'un problème où l'arrière-plan de la Tâche ne pouvait pas être restauré correctement** lors de la restauration depuis un modèle de Tâche, garantissant l'application des paramètres d'arrière-plan.

**1.97.0 (2024/10/21)**

**♻️ Optimisation**

1. **Optimisation de l'effet d'affichage des cartes de Tâches non démarrées.**
2. **Correction de certains problèmes de performance.**
3. **Optimisation de la page de détail de Tâche**, résolvant le problème où cliquer sur le nom de la Tâche ne déclenchait parfois pas les interactions.

**✨ Fonctionnalités**

1. **Ajout de champs au format JSON à la diffusion API pour les Tâches en retard.**

**🐛 Corrections**

1. **Correction d'un problème où l'activation de Material 3 provoquait des plantages** lors de l'exécution de certaines API liées à l'UI.
2. **Suppression de certaines options expérimentales obsolètes**, comme l'interrupteur Émotions et l'interrupteur nouvel Attribut.

**🎉1.97.0-rc (2024/09/11)**

**✨ Fonctionnalités**

**Mises à jour principales**

- Cette mise à jour se concentre principalement sur les optimisations de performance et les corrections de bugs.
- Optimisation significative des performances globales de l'App. La récupération des listes de Tâches et diverses opérations sont désormais plus fluides. La version cible de l'API Android est mise à jour vers Android 14.

**Autres**

1. **Lorsque les pièces sont insuffisantes, le bouton d'achat d'Objet apparaît désormais désactivé.**
2. **Ajout de la recherche de Succès par nom dans la liste des Succès 🔍.**
3. **Ajout de la prise en charge des paramètres de taille de police dans l'App.**
4. **Optimisation de la logique aléatoire de Monde → Tâches aléatoires**, réduisant la fréquence d'apparition du dernier lot de Tâches pour plus d'aléatoire.
5. **Optimisation de la logique de regroupement des notifications** ; les notifications comme les déblocages d'Attributs et de Succès devraient se regrouper correctement.
6. **Statistiques → Partager prend en charge l'activation/désactivation de l'affichage des codes QR.**

**♻️ Optimisations**

1. **Optimisation de la logique d'accès réseau.**
2. **Ajout d'un effet de flou d'arrière-plan aux fenêtres contextuelles.**
3. **Optimisation des boutons sur les pages Boutique, Inventaire et vitrine**, utilisant désormais les styles officiels de boutons Material.
4. **L'API Content Provider pour interroger l'historique des Tâches renvoie désormais l'heure de fin de la Tâche.**
5. **L'API Content Provider pour interroger l'historique des Tâches prend en charge le filtrage par Group Id de Tâche.**
6. **Mise à jour des versions de nombreuses dépendances.**
7. **L'API Goto prend en charge la navigation vers la page « Paramètres par défaut du nouvel Objet ».**
8. **Lors de la navigation vers la page « Créer un Succès » via l'API Goto, le paramètre `category_id` est désormais obligatoire.**
9. **Ajout de guides in-app pour les effets de lien Tâche, Tâche compteur et Objet dans l'API.**
10. **Optimisation de la logique et des messages d'erreur pour la vérification des mises à jour des nouveaux utilisateurs.**
11. **Ajout de messages de chargement et d'erreur pour les opérations de suppression de compte.**
12. **Optimisation de la zone cliquable pour finaliser la Tâche principale sur la page de détail de Tâche.**
13. **Amélioration du message d'erreur lors de l'importation de sauvegardes**, empêchant plus strictement l'importation de fichiers de sauvegarde invalides.

**🐛 Corrections**

1. **Correction d'un problème où, lors de la création d'une nouvelle Tâche, si le message d'erreur pour un contenu vide était déclenché en premier, le message ne disparaissait pas automatiquement** même après la saisie de texte.
2. **Correction d'un problème où le bouton de filtre n'était pas affiché sur la page Statistiques** en mode barre de navigation inférieure.
3. **Correction de problèmes de mise en page sur certains appareils à petit écran** avec des ratios d'aspect étroits.
4. **Correction d'un problème où les Récompenses de sous-tâches pouvaient être anormalement liées lors de la copie de Tâches** (depuis la version 1.96.0).
5. **Correction de messages d'erreur causés par une connexion Dropbox anormale** lors de la sauvegarde automatique Dropbox.
6. **Tentative de correction de la consommation mémoire et des plantages** lors de la prévisualisation d'images extrêmement volumineuses.
7. **Correction d'un problème où, après l'achat d'un Objet et son marquage pour utilisation, les données du widget ne se rafraîchissaient pas correctement** si l'utilisation échouait.
8. **Correction d'un problème où l'édition d'un Succès modifiait l'heure de finalisation** et pouvait déclencher incorrectement des notifications de déblocage de Succès.
9. **Correction d'un problème où, en mode écran partagé sur grands écrans**, lorsque la liste et le détail de Tâches étaient affichés, finaliser des Tâches, sous-tâches ou mettre à jour des compteurs ne synchronisait pas les deux pages.
10. **Correction d'un problème où un appui long sur des Tâches uniques en retard dans la liste de Tâches ne permettait pas de supprimer l'affichage de l'échéance.**

**1.96.1(2024/07/11)**

**🐛 Corrections**

1. **Correction d'un problème où le nombre affiché d'Objets de Récompense était incorrect** lors de la finalisation de sous-tâches (les Récompenses réelles n'étaient pas affectées).

**🎉1.96.0 - beta01(2024/06/19)**

**✨ Fonctionnalités**

**Mises à jour principales**

1. **Lors de la finalisation de Tâches ou du déblocage de Succès, les Objets peuvent désormais être utilisés directement** pour déclencher leurs effets.
2. **La limite du nombre d'Objets utilisés à la fois est portée à 1000.**
3. **L'achat de Boîtes de butin ou d'Objets de Synthèse prend également en charge l'utilisation directe** (ouvrir/synthétiser).
4. **Les Tâches d'équipe prennent en charge la publication d'Émotions vers les Émotions locales.**
5. **Les URL Schemes tiers dans les notes de Tâches sont pris en charge** pour l'analyse et la navigation directes.
6. **La page Historique prend en charge la recherche d'enregistrements historiques par notes de Tâche.**
7. **Ajout de la prise en charge du chronométrage de Tâches historiques.**
8. **La page Statistiques prend en charge le filtrage par catégories principales.**
9. **Refactorisation des fenêtres contextuelles de Récompense et de pénalité de Points d'Expérience d'Attributs** : optimisation de la logique de limites de sélection d'Attributs lors de l'utilisation d'Objets, et séparation des fenêtres de réduction de Points d'Expérience pour retard.

**♻️ Optimisations**

1. **L'effet UI de sélection unique lors du choix d'Objets est désormais cohérent avec la sélection multiple.**
2. **Optimisation de la vitesse de chargement de la liste de Tâches.**
3. **Lors de l'ajout ou de l'édition de Tâches, l'heure d'échéance n'a plus besoin d'être postérieure à l'heure actuelle**, offrant une flexibilité pour créer des enregistrements historiques.
4. **Si l'affichage des id de données est activé, la fenêtre contextuelle Émotions affiche également l'id correspondant.**
5. **Optimisation des problèmes de performance liés à la fenêtre contextuelle de traitement des retards.**
6. **Unification de l'ordre des boutons pour les états de compte à rebours et de pause.**
7. **L'interaction pour supprimer des publications sur Monde → Profil personnel est désormais plus intuitive.**
8. **Optimisation des effets de chargement sur les pages Émotions et Succès.**

**🐛 Corrections**

-

**🎉1.95.0-rc01 (2024/05/24)**

**✨ Fonctionnalités**

**Mises à jour majeures**

1. **Prise en charge de l'affichage en écran partagé in-app sur les grands écrans** tels que tablettes et écrans pliables

**♻️ Optimisations**

1. **Les widgets Boutique et Inventaire prennent en charge des effets de recadrage cohérents in-app pour les images**
2. **Sur la page statistiques, lorsqu'un seul jour est sélectionné, les graphiques linéaires sont désormais pris en charge**

**🐛 Corrections**

1. **Correction d'un problème où le type de Tâche s'affichait incorrectement lors de l'édition de Tâches API**
2. **Correction d'un problème de statistiques anormales de finalisation, d'abandon et de retard de Tâches** sur la page statistiques

**1.94.3 (2024/05/10)**

**♻️ Optimisations**

1. **Les widgets tentent désormais de mettre à jour le thème pour s'adapter** lorsque le mode sombre système change
2. **Lorsque le module « Monde » est masqué, la notification point rouge pour les Succès système ne compte plus les données liées au module « Monde »**

**🐛 Corrections**

1. **Correction d'un problème de plantage à faible probabilité lors de la sélection multiple d'Objets**
2. **Correction d'un problème de plantage à faible probabilité lié aux fenêtres contextuelles**
3. **Correction d'un problème où le widget Inventaire pouvait ne pas se rafraîchir** lors de l'appel de l'API de modification d'Objet
4. **Correction d'un problème où le widget Inventaire pouvait utiliser des Objets « inutilisables »**

**1.94.2 (2024/04/26)**

**🐛 Corrections**

1. **Correction d'un problème de calcul anormal du compteur actuel de Tâches** (entraînant une progression imprécise pour les Tâches avec un nombre de répétitions cible défini)
   - Cette correction annule une optimisation précédente liée aux performances de l'annulation de Tâches, en attendant une solution plus raisonnable à l'avenir

**1.94.1 (2024/04/22)**

**🐛 Corrections**

1. **Correction d'un problème où le nombre de Pomodoros était calculé avec un de moins** lors de l'utilisation du chronomètre, de l'ajout de temps via l'API ou de l'ajout manuel d'enregistrements de temps.
2. **Correction d'un problème où la barre de sélection pouvait clignoter et disparaître** après la sélection d'Objets sur les pages Boutique/Inventaire puis le défilement.

**🎉1.94.0 (2024/04/22)**

**Mises à jour principales**

1. **Prise en charge de plusieurs Récompenses d'Objets**
2. **Widgets Inventaire**

**Thèmes UI**

1. **Les couleurs personnalisées (texte de Tâche, d'Objet) incluent désormais plus de valeurs prédéfinies**
2. **Adaptation à la fonction d'icône adaptative monochrome d'Android 14**
3. **Ajout de nombreuses adaptations linguistiques (version Google Play)**

**Succès**

1. **S'il existe des Succès avec des Récompenses non réclamées, un petit point rouge s'affiche désormais sur la liste des Succès.**

**Tâches**

1. **Les sous-tâches des Tâches de pénalité exécutent désormais correctement la logique de pénalité**
2. **Ajout de la « Gestion intelligente des fuseaux horaires »** ; si vous travaillez à travers les fuseaux horaires, LifeUp prend également en charge la détection automatique des changements de fuseau horaire et les ajustements horaires globaux
3. **La base statistique sur la page de détails mémorise désormais la dernière sélection**, et nous avons optimisé certaines valeurs par défaut dans certains scénarios
4. **Optimisation de la gestion de grâce des jours consécutifs de finalisation de Tâches sur la page « Ma page »** : si vous oubliez de finaliser une Tâche un jour, rattraper permet toujours de continuer la série

**Attributs**

1. **Prise en charge de la suppression des enregistrements de Points d'Expérience**
2. **Prise en charge de la réinitialisation des Points d'Expérience d'un Attribut individuel**

**Widgets**

1. **Un clic sur l'espace vide des widgets Boutique ou Inventaire entre désormais directement dans la liste visée par le widget**, et non la dernière liste
2. **Les widgets Tâches affichent désormais la progression des Tâches compteur**

**API**

1. **Ajout d'une API pour éditer les enregistrements Pomodoro**
2. **L'API de finalisation de Tâches gère désormais correctement les Tâches de pénalité**
3. **L'API de finalisation de Tâches prend également en charge le traitement des Tâches compteur** (ajout du paramètre `count`)
4. **L'API de finalisation de Tâches prend en charge un paramètre de coefficient de Récompense**
5. **L'API d'ajustement d'Objets prend en charge le changement de l'id de liste d'Objets**
6. **Les API de création et d'ajustement d'Objets prennent en charge un paramètre de critères de tri**
7. **L'API Jump prend en charge le saut vers la fenêtre contextuelle d'utilisation d'Objet**
8. **Unification de certaines définitions de paramètres**, comme `itemId` → `item_id`
9. **Ajout de notifications de diffusion pour le démarrage, la pause et l'arrêt d'un chronomètre**
10. **Le paramètre `title_color_string` de l'API d'ajustement d'Objets prend en charge le passage d'une chaîne vide** pour restaurer la valeur par défaut
11. **La diffusion de finalisation de Tâches inclut désormais l'id de liste**
12. **L'ouverture de Boîtes de butin et la fabrication déclenchent également la diffusion d'utilisation d'Objet**

**♻️ Optimisations**

1. **L'ajout ou l'édition de Tâches inclut désormais un avertissement si aucun Attribut n'est sélectionné et que des Points d'Expérience sont saisis**
2. **Optimisation des enregistrements de nouvelle tentative de téléversement**
3. **Optimisation de l'affichage du titre et des restrictions de saisie sur la page de Niveaux personnalisés**
4. **Optimisation des performances et des problèmes de synchronisation lors de l'annulation de Tâches très répétées**
5. **Refactorisation de la fenêtre contextuelle d'utilisation d'Objet, de la logique de l'interface calendrier, etc.**
6. **Optimisation de la logique des rappels de Tâches**, garantissant que les rappels de données supprimées ou antérieures ne sont plus émis
7. **Optimisation du texte d'attente dans l'interface de sauvegarde**
8. **Les images sélectionnées sur la page d'Attribut personnalisé sont également ajoutées à la sélection historique**
9. **L'édition des enregistrements Pomodoro tente désormais de corriger (augmenter ou diminuer) le bon nombre de Pomodoros**

**🐛 Corrections**

1. **Correction d'un Succès système lié aux statistiques et sauvegardes qui ne se déclenchait pas normalement** après restructuration
2. **Correction de conflits potentiels entre les widgets API random et toast API et le toast par défaut**
3. **Correction du détail de Tâche qui ne se rafraîchissait pas dans certains scénarios** lors de l'entrée depuis un widget
4. **Correction du risque d'erreurs lors de multiples ouvertures de Boîtes de butin** dans certaines situations particulières (épuisement préventif de l'Inventaire d'Objets)
5. **Correction du problème de non-affichage des sous-tâches sur la page de détails** après édition d'une Tâche sans sous-tâches et ajout de nouvelles sous-tâches
6. **Correction de certains cas particuliers où l'édition des Récompenses en pièces n'était pas possible**
7. **Correction de certains cas où la réclamation d'Objets d'équipe pouvait ne pas fonctionner**
8. **Correction d'anomalies de style MD2 dans certaines fenêtres contextuelles inférieures**
9. **Correction de valeurs de temps supplémentaire potentiellement incorrectes dans les minuteurs Pomodoro**
10. **Correction d'un problème où la barre de couleur du widget de changement de Points d'Expérience pouvait ne pas s'afficher**
11. **Correction de certaines Tâches qui ne s'affichaient pas correctement dans le calendrier en cours**
12. **Correction de certains problèmes de chargement de listes sur les pages historique et Émotions**
13. **Correction d'un problème où l'appel de l'API de finalisation de Tâche deux fois rapidement ne permettait pas deux finalisations consécutives**

**1.93.3 (2024/01/09)**

**✨ Fonctionnalités**

1. **Ajout de l'API [Émotions].**

**♻️ Optimisation**

1. **Le calcul des indicateurs de valeur moyenne sur la page statistiques exclut désormais les dates futures.**
2. **Après masquage de la liste des Succès système, plus d'alertes pour le déblocage de Succès système.**
3. **Mise à jour de l'API `goto` pour ne plus prendre en charge les fenêtres contextuelles d'achat d'Objets « non achetables ».**
4. **Optimisation de l'édition de Tâches pour résoudre le problème où la saisie du nombre de répétitions cible était masquée.**

**🐛 Corrections**

1. **Correction de l'effet UI edge-to-edge sur la page d'Attribut personnalisé.**
2. **Correction d'un problème où la pénalité n'était pas révoquée** si une Tâche était marquée comme abandonnée puis finalisée sur la page historique/calendrier.
3. **Correction d'un problème de style d'affichage de la fenêtre contextuelle inférieure et de la barre de navigation système inférieure** en mode Material2.
4. **Correction de la couleur de bordure incorrecte du champ de saisie de Tâche en mode nuit.**
5. **Correction d'un problème d'affichage pouvant survenir après rotation d'écran** en mode navigation système à trois boutons.

**1.93.3 (2023/12/02)**

**♻️ Optimisation**

1. **Ajout unifié d'un paramètre debug aux API** pour faciliter le débogage

**🐛 Corrections**

1. **Correction d'un problème où la sélection « Ignorer la fenêtre contextuelle de rappel » n'était pas effective**
2. **Correction d'un problème avec l'édition d'Émotions créées directement sur la page Émotions**
3. **Correction d'un problème où le téléversement de photos dynamiques d'équipe permettait de sélectionner jusqu'à 9 images**, alors que la limite réelle devrait être 3
4. **Correction d'un problème où l'API `use_item` ne déclenchait pas les effets de compte à rebours ou URL** lorsque `ui` est défini sur false
5. **Correction d'un problème où l'utilisation d'Objets dans le widget Boutique pouvait déclencher l'effet deux fois**

**1.93.1 -> 1.93.2 (2023/11/18)**

**♻️ Optimisation**

1. **Optimisation de la logique de mise à niveau de la base de données** pour éviter les retards dans les processus de mise à niveau
2. **Optimisation de la valeur par défaut de « Heure de début »** lors de l'édition de Tâches

**🐛 Corrections**

1. **Correction d'un problème où l'édition d'API produit entraînait la perte des effets d'utilisation du produit**
2. **Correction d'un problème où les Tâches en retard et abandonnées marquées comme finalisées ne restauraient pas les Récompenses**
3. **Correction d'un problème de tri personnalisé de Tâches ne répondant pas aux attentes**
4. **Correction de problèmes d'affichage et de tri liés aux Tâches uniques en retard**
5. **Correction d'une exception SQL lors du filtrage de la page historique**
6. **Correction d'un problème en mode simplifié où cliquer à nouveau sur le titre de la Tâche ne répondait pas**
7. **Correction d'un problème où le renommage de modèles de Tâches ne prenait pas effet**

**🎉1.93.0 (2023/10/24)**

**✨ Fonctionnalités**

**Thème UI**

1. **Adaptation complète à Material Design 3.**
2. **Prise en charge de la personnalisation des couleurs du thème Material Design 3**, y compris couleurs personnalisées, couleurs du fond d'écran et couleurs d'images.
3. **Amélioration de certains effets d'animation**, comme les fenêtres contextuelles.
4. **Optimisation des effets d'adaptation edge-to-edge (immersive).**

**Tâches**

1. **Prise en charge des modèles de Tâches.**
2. **Les statistiques sur la page de détails prennent en charge le basculement selon des critères temporels** et optimisent les options par défaut.
3. **La page historique prend en charge la recherche par noms de Tâches** et ajuste l'UI et les interactions associées.

**Succès**

1. **Prise en charge des Succès secrets.**
2. **Lors de l'ajout de Succès, prise en charge de « Continuer à ajouter le Succès suivant ».**

**Attributs**

1. **Prise en charge du masquage des Attributs.**

**Minuteur Pomodoro**

1. **Prise en charge de l'édition des enregistrements de temps.**
2. **Sur la page Pomodoro, prise en charge de la finalisation de Tâches** (appui long sur la Tâche sélectionnée en mode pause).

**Émotions**

1. **Prise en charge de l'ajout d'Émotions directement sur la page Émotions.**

**API**

1. **Ajout de l'API « use_item ».**
2. **Ajout de l'API « random ».**
3. **Ajout de l'API « edit_exp ».**
4. **L'API « item » prend désormais en charge l'ajustement de paramètres** tels que « action_text », « disable_use » et « title_color_string ».
5. **L'API « shop_settings » prend en charge le paramètre « silent ».**
6. **Prise en charge de l'espace réservé « time ».** Vous pouvez désormais définir des Tâches avec des dates comme « échéance demain » ou « échéance le mois prochain » sans outils d'automatisation.

**♻️ Optimisation**

1. **Ajout de préfixes à certains endroits affichant les id de données.**
2. **Optimisation de l'affichage des activités d'équipe.**
3. **Tentative de correction du problème où certaines notifications Toast étaient trop longues pour s'afficher entièrement.**
4. **Amélioration de la logique de finalisation par widget dans les équipes**, garantissant la cohérence avec le comportement in-app.
5. **Page statistiques : après sélection d'une plage « Personnalisée », cliquer à nouveau sur « Personnalisée » déclenche une nouvelle sélection de dates.**
6. **Compatibilité assurée avec Harmony OS 4** pour que les notifications de barre de progression affichent les boutons d'action.
7. **Amélioration de la logique d'interaction des demandes de notification.**
8. **Correction du problème où la méthode de saisie pouvait masquer la saisie du « Nombre de répétitions ».**
9. **Lors de la création de Tâches, le choix de l'utilisateur pour les heures de début non spécifiques (comme automatique ou échéance aujourd'hui) est enregistré.** Lors de l'édition, ces options sont restaurées plutôt que des heures spécifiques, pour éviter des écarts dans les heures éditées.
10. **Lors de la création de Tâches, si des avertissements inattendus de doublons surviennent, ils s'affichent également dans la fenêtre contextuelle « Vérifier les doublons ».**
11. **Ajout de la prise en charge de la langue indonésienne.**
12. **Traductions mises à jour.**

**🐛 Corrections**

1. **Correction d'un problème où, dans certains cas, le module Monde restait bloqué en chargement** (rotation indéfinie).
2. **Correction d'un problème où, dans certains cas, la Boutique/Inventaire restait en affichage de chargement** (rotation indéfinie).
3. **Correction de problèmes pouvant survenir lors de l'appel d'API avec contenu UI via un content provider.**
4. **Correction de problèmes de tri de Tâches ne répondant pas aux attentes.**
5. **Correction d'un problème où les données de la page statistiques étaient incorrectes** après sélection d'une plage « Personnalisée ».
6. **Correction d'un problème où les fenêtres contextuelles de demande de notification ne prenaient pas en charge le défilement.**
7. **Correction d'un problème où, dans certains cas, la recherche du module Monde affichait tout le contenu.**
8. **Correction d'un problème où l'option « Afficher les finalisées » affichait également les Tâches gelées.**
9. **Correction de problèmes de calcul de valeurs moyennes sur la page statistiques.**

**1.92.2 (2023/08/29)**

**✨ Fonctionnalités**

1. **Graphique de statistiques de pas** (<https://github.com/Ayagikei/LifeUp/issues/85>)

**♻️ Optimisation**

1. **La nouvelle page d'équipe affiche désormais un rappel du nombre de mots actuel et de la limite supérieure**

**🐛 Corrections**

1. **Correction du problème où « LifeUp » pouvait créer à plusieurs reprises des comptes de rappel calendrier** dans certaines conditions particulières
2. **Correction du problème où le bouton menu de l'édition d'équipe ne s'affichait pas correctement**
3. **Correction du problème où le Pomodoro pouvait ne pas déclencher le rappel par vibration** en mode démarrage automatique du chronométrage
4. **Correction du problème où la notification Pomodoro pouvait afficher incorrectement les Objets de Concentration** lorsqu'aucun Objet de Concentration n'était sélectionné

**1.92.1-rc02 - 1.92.1 (2023/08/18)**

**♻️ Optimisation**

1. **La durée sur la page d'état et la page statistiques peut désormais s'afficher au format « XX jours XX heures XX minutes ».**

**🐛 Corrections**

1. **Correction d'un problème où l'interaction pour fermer la fenêtre contextuelle de permission de notification n'était pas conforme aux attentes** sur Android 12 et versions ultérieures.
2. **Correction du problème où le graphique circulaire d'Attributs pouvait s'afficher en couleur transparente**, le rendant invisible.

**1.92.1-rc01 (2023/08/13)**

> Date de publication de la bêta fermée pour les membres

**✨ Fonctionnalités**

1. **La nouvelle version des statistiques intègre les cartes statistiques de l'ancienne version**, désormais fusionnées en une seule page et adaptées au mode barre de navigation inférieure.

2. **Mise à niveau du mécanisme de mise à jour in-app et de la fonction de rappel.**

   Prise en charge de trois canaux de mise à jour : version stable, version stable de la bêta fermée pour membres et version expérimentale de la bêta fermée pour membres, pour se concentrer sur les mises à jour ultérieures des membres de la bêta fermée.

3. **TargetSdkVersion est désormais adapté pour Android 13** et les demandes de permission de notification dynamiques.

4. **Refonte de la page d'édition de profil.**

5. **Version Google Play : optimisation du processus et des instructions de sélection du mode connexion/hors ligne.**

**♻️ Optimisation**

1. **Maintenance et mises à jour des dépendances techniques associées.**
2. **Amélioration de l'adaptation WSA et des instructions de connexion.**
3. **En cas d'échec de sauvegarde, une fenêtre contextuelle explique désormais la raison de l'échec**, évitant l'affichage incomplet des messages toast.

**🐛 Corrections**

1. **Correction d'un problème potentiel de dépassement de calcul provoquant un plantage** sur la page d'historique des pièces.
2. **Correction de problèmes de menu possibles sur la page de détails d'équipe** ne correspondant pas aux permissions attendues.
3. **Tentative de correction du problème de décalage horaire** dans le minuteur de compte à rebours.
4. **Correction de l'interruption du processus de finalisation de Tâche et de la disparition de la fenêtre contextuelle d'écriture de réflexion** causées par la rotation d'écran.

**1.92.0-rc02 (2023/07/16)**

**🐛 Corrections**

1. **Correction du problème où le widget Boutique pouvait ne pas fonctionner** lors du saut vers d'autres apps (exécution d'API)
2. **Correction d'une anomalie occasionnelle lors du changement de listes** dans le widget Boutique
3. **Correction du problème où le widget Boutique ne masquait pas les Objets épuisés ou non achetables** selon les paramètres de l'App
4. **Correction du problème où le widget Boutique pouvait ne pas répondre** lors du clic sur un Objet
5. **Correction de certains problèmes de plantage rares**

**🎉1.92.0-rc01 (2023/07/11)**

**✨ Fonctionnalités**

1. **Statistiques 2.0**
2. **Carte de partage**

**♻️ Optimisation**

1. **Vous pouvez désormais définir des prix pour les Objets « non achetables »** et les utiliser pour des scénarios comme les retours
2. **Lorsque vous désactivez « Définir la pénalité de Tâche séparément » dans les paramètres, le bouton de pénalité n'est plus affiché**
3. **Optimisation de l'UI des sous-tâches dans les détails d'équipe**
4. **Optimisation de l'UI des impressions**

**🐛 Corrections**

1. **Correction du problème où, lorsque le style de découpage d'Attribut est changé en « rectangle arrondi », l'icône d'édition pouvait afficher l'ancienne icône pendant longtemps**

**1.91.3-rc04 (2023/06/07)**

**♻️ Optimisation**

1. **L'API de saut vers les détails de Tâche prend désormais en charge les paramètres task_gid et task_name**
2. **Le Content Provider prend en charge l'URL de l'icône distante du produit**
   - Afin de corriger à l'avenir le problème où certaines icônes de produit ne peuvent pas s'afficher correctement sur le bureau

**🐛 Corrections**

1. **Correction du problème où le widget de liste Boutique n'affichait pas correctement les pièces actuelles**

**1.91.3 (2023/06/03)**

**✨ Fonctionnalités**

1. **Widget de liste d'Objets Boutique (grande et petite version)**
2. **Widget de changement du jour pour les Points d'Expérience**
3. **Ajout d'une API de saut vers les détails de Tâche**
4. **Émotions : prise en charge du tri par ordre chronologique croissant et ajout de l'affichage de l'année**

**♻️ Optimisation**

1. **Prise en charge de la définition de prix pour les Objets « non achetables »** et utilisation dans des scénarios comme les retours
2. **Lorsque « Paramétrage indépendant de la pénalité de Tâche » est désactivé dans les paramètres, le bouton de pénalité n'est plus affiché**
3. **Optimisation de l'UI d'affichage des sous-tâches dans les détails d'équipe**
4. **Optimisation de l'UI d'affichage des impressions**

**🐛 Corrections**

1. **Correction du problème où, si vous effacez les mots motivationnels lors de l'édition d'une Tâche, vous ne pouviez pas cliquer sur « Confirmer » pour fermer la fenêtre contextuelle**
2. **Correction du problème où la Tâche gelée ne pouvait pas être recherchée via l'API**
3. **Correction du problème où la Boutique et l'Inventaire ne pouvaient pas masquer la liste par défaut**

**1.91.2 (2023/05/09)**

**✨ Fonctionnalités**

1. **Les listes Boutique et Inventaire prennent en charge le masquage séparé**
2. **L'API `Goto` prend en charge le saut vers les sous-pages de la page principale** (Tâches, état, Boutique, Inventaire)
3. **Les statistiques de pièces prennent en charge l'exclusion de la consommation d'achats**

**♻️ Optimisations**

1. **Lors de la création d'un nouveau Succès ou de l'édition d'un Succès verrouillé, le bouton « Réinitialiser » n'est plus affiché**
2. **Le widget de pièces prend en charge le clic pour accéder à la Boutique**
3. **Lorsque la lecture de l'effet sonore échoue, un message d'erreur clair s'affiche**

**🐛 Corrections**

1. **Correction d'un problème où, lors de l'ajout d'enregistrements Pomodoro, si l'heure de fin est définie directement, la durée attendue pouvait ne pas être respectée**
2. **Correction d'un problème où, après réparation de l'étiquette de filtre de Tâches, la méthode de saisie apparaissait**
3. **Correction du problème où les intérêts ATM ne prenaient pas en charge la définition de la valeur absolue via l'API**
4. **Correction du problème de chargement anormal des données sur la page historique**
5. **Correction du problème où, lorsque le widget finalise une Tâche compteur, cliquer sur « Annuler » bloquait la page transparente**
6. **Correction du problème où la page statistiques ne se rafraîchissait pas automatiquement** en mode barre de navigation inférieure
7. **Correction du problème où la collecte de Tâches d'équipe était anormale** dans les fuseaux horaires GMT ±x,5

**1.91.1 (2023/03/27)**

**✨ Fonctionnalités**

1. **Ajout de l'option « Gestion des notifications » dans les Paramètres.**
2. **L'API Nouvelle Tâche prend désormais en charge la définition d'arrière-plans.**
3. **Ajout d'événements de diffusion API liés aux comptes à rebours de produit** ([New API · Issue #64 · Ayagikei/LifeUp (github.com)](https://github.com/Ayagikei/LifeUp/issues/64)).

**♻️ Optimisations**

1. **La fenêtre contextuelle de commentaires ne se ferme plus automatiquement lors d'un clic à l'extérieur.**
2. **Les widgets ne forcent plus la finalisation de Tâches non démarrées.**
3. **L'API de finalisation de Tâches ne force plus la finalisation de Tâches non démarrées** lorsque le paramètre « ui » est défini sur true.
4. **Lorsque le paramètre de coefficients de pénalité individuels par Tâche est désactivé, les coefficients de pénalité de Tâche précédemment définis sont ignorés** et la valeur globale est utilisée.
5. **Suppression automatique des espaces blancs des URL saisies par l'utilisateur.**
6. **Lorsque l'option « Masquer les Objets non achetables » est activée et qu'un Objet non achetable est créé, une invite s'affiche.**
7. **Lorsque l'utilisateur active les Niveaux personnalisés sans en définir, retour à la table de Niveaux intégrée.**
8. **Amélioration des images d'aperçu des widgets.**
9. **Les saisies de pas sont désormais limitées aux chiffres.** (<https://github.com/Ayagikei/LifeUp/issues/75>)
10. **Lors de l'utilisation du navigateur intégré pour les liens produit, le préfixe « https » n'est plus requis.**
11. **Ajout d'instructions « Configuration de compatibilité » pour la fonctionnalité de compte à rebours produit.**

**🐛 Corrections**

1. **Correction d'un comportement de clic inattendu lors de la sélection de produits dans la Boutique et l'Inventaire.**
2. **Correction d'un problème où les Tâches non répétitives ne pouvaient pas recevoir d'échéance lors de l'ajout via l'API.**
3. **Correction d'un problème où les images d'Attribut personnalisé pouvaient ne pas se mettre à jour sur certains appareils.**
4. **Correction d'un problème où les effets sonores personnalisés pouvaient provoquer un plantage de l'App.** Une nouvelle méthode a été implémentée, rendant les effets sonores en arrière-plan plus stables et consommant moins de mémoire, mais la vitesse de lecture peut être plus lente.
5. **Correction d'un problème où, sur Android 12 et versions ultérieures sans la configuration « Ignorer l'optimisation de la batterie », activer le minuteur Pomodoro automatique ou la pause pouvait provoquer un plantage en arrière-plan.**
6. **Correction d'un problème où les effets sonores de compte à rebours produit étaient affectés par le paramètre d'effets sonores Pomodoro.**
7. **Correction d'un problème d'erreurs de calcul en virgule flottante lors de la définition des taux d'intérêt quotidiens ATM via l'API.**
8. **Correction d'un problème où certaines images ne pouvaient pas être chargées sur Android 6.**
9. **Correction d'un problème où, lors de la restauration de données de sauvegarde d'une version supérieure vers une version inférieure, les messages d'erreur ne s'affichaient pas correctement.**
10. **Correction d'un problème de chevauchement de mise en page sur la page Pomodoro sur certains appareils.**

**🎉1.91.0 (2023/02/13-2023/02/26)**

**✨ Fonctionnalités**

1. **Prise en charge des dégradés de Niveaux personnalisés.**
2. **Ajout du premier lot de widgets :**
   - Pièces (petit, grand, cible)
   - Attributs (petit, grand)
3. **Prise en charge de l'interrogation de la plupart des détails de données dans LifeUp via l'API Content Provider**, notamment :
   - Proposer une nouvelle version de « LifeUp Cloud ».
   - Fournir une première version rudimentaire de la version bureau (Windows, Linux, macOS) pour usage en réseau local.
4. **Prise en charge de la suppression multiple des enregistrements du minuteur Pomodoro.**
5. **Prise en charge du démarrage automatique du repos et du travail pour le minuteur Pomodoro.**
6. **Améliorations API et champs ajoutés**, notamment :
   - Dépôts et retraits ATM.
   - Définir si l'achat de biens est interdit.
   - Définir les couleurs d'étiquette pour les Tâches.
   - Définir directement le solde ATM.
   - Requête simple pour les détails d'un produit spécifié.
   - Ajout d'un troisième bouton et d'une option d'opération à l'interface de fenêtre contextuelle.

**♻️ Optimisations**

1. **Amélioration de la vitesse de requête, de traitement et des performances** lors du traitement de grandes quantités de données.
2. **Correction des marges incorrectes pour les icônes adaptatives.**
3. **Optimisation de l'effet d'affichage des enregistrements du minuteur Pomodoro.**
4. **Amélioration de l'interaction lors de la restauration de sauvegarde.**
5. **Ajout de l'affichage UI pour l'obtention de la licence membre via Google Play.**
6. **Invite pour désactiver la fonction d'importation en un clic** si le fichier de sauvegarde sélectionné ne provient pas de LifeUp lors de l'importation directe depuis le système de fichiers.
7. **Fermeture automatique de la méthode de saisie lors de la recherche de biens** dans la fenêtre contextuelle de sélection de produit.
8. **Changements de comportement API**, notamment :
   - API de fenêtre contextuelle confirm_dialog. Si le texte ou l'opération d'un bouton n'est pas fourni, le bouton n'est pas affiché. Cela offre plus de flexibilité pour le contrôle des fenêtres contextuelles ; par exemple, vous pouvez configurer une fenêtre contextuelle textuelle sans boutons pour afficher du texte et des phrases motivationnelles.
   - API Penalty. Dans les versions précédentes, elle ne pouvait déduire que jusqu'à 100 Objets ; la limite est désormais étendue à 9 chiffres.

**🐛 Corrections**

1. **Correction du problème où la page du minuteur Pomodoro affichait « chargement » à la fin dans certaines circonstances.**
2. **Correction de plantages causés par certaines bibliothèques tierces.**
3. **Correction du problème où l'App plantait lors du placement du minuteur Pomodoro dans la barre de navigation inférieure** en raison d'une fenêtre contextuelle d'invite.
4. **Correction de l'affichage anormal des valeurs d'Attributs** lors de la consultation des profils d'autres utilisateurs.
5. **Correction du problème où les événements API et notifications de réduction de Niveau d'Attribut n'étaient pas envoyés correctement.**
6. **Correction de certains problèmes d'interaction avec les pages d'édition par appui long.**
7. **Correction de certaines marges anormales sur les pages de gestion d'images et Synthèse.**
8. **Correction de certaines fenêtres contextuelles non défilables**, entraînant une utilisation anormale en mode paysage.**

**✨Special Release: LifeUp Cloud v1.1.1 (2023/02/13)**

1. **Prise en charge des opérations de lecture et d'autorisation pour les informations Content Provider.**
2. **Lors du démarrage du service, demande d'un wake lock pour permettre une réponse même lorsque l'écran est verrouillé.**
3. **Ajout d'une série d'interfaces pour les Content Providers.**

**✨Special Release: LifeUp Desktop v1.0.1 (2023/02/13)**

Première version, conçue pour être utilisée conjointement avec « LifeUp Cloud » et l'App mobile.

Prend en charge les opérations suivantes :

- Interroger les Tâches, listes, Objets, Succès et listes d'Émotions.
- Acheter des Objets et finaliser des Tâches.
- Utiliser le navigateur d'images de bureau pour afficher des images d'Émotions agrandies.

**1.90.7 (2022/11/07)**

**✨ Fonctionnalités**

1. **Ajout : traduction vietnamienne et signature du traducteur (version Google)**
2. **Ajout : méthode de sélection d'image « Ignorer le recadrage », adaptée à la sélection d'animations gif (fonction membre)**
3. **Ajout : API de suppression de Tâche**
4. **Ajout : prise en charge du paramètre pour abandonner l'effet sonore de finalisation de Tâche**
5. **Ajout : opération de quantité MAX pour la Synthèse simple**
6. **Prise en charge du reverrouillage des Succès déjà débloqués**
7. **L'API « Ajouter un produit » prend en charge la spécification de l'id de liste**

**♻️ Optimisations**

1. **Amélioration de la description lors de la suppression de l'historique**
2. **La limite des Points d'Expérience passe de (3/4 décimales) à (4/5 décimales)**
3. **Ajout de l'affichage du coefficient de pénalité sur la page de détails**
4. **Amélioration globale de la conception interactive du sélecteur de date et heure**
5. **La fenêtre contextuelle de détails de Succès différencie désormais la couleur de l'icône selon que les conditions sont remplies ou non**
6. **Changement de l'icône de raccourci Pomodoro**
7. **Lors de la création d'une Tâche depuis une liste intelligente, si la liste sélectionnable est 0 ou 1, sélection automatique**
8. **Le mode développeur affiche l'ID de liste d'Objets**
9. **Limitation de la longueur de saisie de certains champs courants pour éviter les plantages**

**🐛 Corrections**

1. **Correction du calcul anormal des Récompenses lors de la modification de l'historique d'Objets dans certains scénarios**
2. **Correction du décalage entre l'interrupteur « Afficher les archives » et l'affichage dans certains scénarios**
3. **Amélioration de la logique de chargement des données du widget (peut corriger certains problèmes anormaux)**
4. **Réparation de la logique de calcul automatique lors de l'ajout manuel d'enregistrements de minutage ; il suffit désormais de remplir n'importe quel champ**
5. **Correction du problème de rafraîchissement anormal sur la page d'enregistrements du minuteur Pomodoro**
6. **Correction du problème où les sous-tâches ne pouvaient pas effacer les Récompenses d'Objets**
7. **Correction du problème où, après avoir tout sélectionné, resélectionner certains Objets ne prenait pas effet**
8. **Optimisation de la mémoire requise pour la prévisualisation d'images**
9. **Le widget se rafraîchit désormais après l'ajustement de l'ordre des listes**
10. **Optimisation du blocage de l'interface pour certaines méthodes de sauvegarde**

**1.90.6 (2022/10/21)**

**✨ Fonctionnalités**

1. **Ajout d'une API pour définir le nombre de pas à une date donnée**
2. **Ajout d'une API pour interroger l'état d'Attributs spécifiés (Points d'Expérience, Niveau)**
3. **Prise en charge de l'importation directe de données de sauvegarde depuis le gestionnaire de fichiers**
4. **Les API liées aux Objets de Récompense ne sont plus limitées à 99**

**♻️ Optimisations**

1. **Optimisation de l'animation de transition lors de l'entrée sur la page de détails d'événement**
2. **Optimisation de la page d'édition de Tâches, avec un effet visuel renforcé lors de l'activation de la pénalité et une meilleure aide**
3. **Changement des icônes d'opération sur la page de minutage**
4. **Dans la fenêtre contextuelle d'achat, ajout d'avertissements et d'instructions pour les Objets avec quantité propre négative**
5. **Optimisation de l'effet de barre d'état immersive sur la page d'accueil**
6. **Ajout d'un rappel de configuration de compatibilité sur la page Pomodoro**
7. **Amélioration de la vitesse d'exportation et de restauration des sauvegardes**
8. **Instructions pour le paramètre du nombre en stock**
9. **Suppression temporaire du paramètre [Lorsque l'inventaire du produit est à 0, la Récompense de Tâche correspondante est automatiquement retirée].**
10. **Optimisation du mécanisme de vérification de licence avec version d'essai gratuite**
11. **Lorsqu'une Tâche « Épinglée » est sélectionnée, l'action s'affiche désormais comme « Désépingler »**
12. **Lors du passage au minutage positif, l'avertissement *expérimental* n'apparaît plus à chaque fois**

**🐛 Corrections**

1. **Correction de la limite système anormale sur certaines pages ou avec des tablettes**
2. **Correction du problème où des données incorrectes s'affichaient lors de la première entrée dans l'Inventaire dans certains cas**
3. **Correction du problème où les données ne pouvaient pas être récupérées en raison de dommages internes (comme des images endommagées) lors de la restauration de sauvegardes corrompues**
4. **Correction du problème où le bouton « Acheter » s'affichait de manière inattendue après un appui long sur un Objet épuisé**
5. **Correction du problème où l'introduction des Attributs sur la nouvelle page d'équipe était l'ancienne version**

**1.90.5 (2022/09/22)**

**♻️ Optimisations**

1. **Adaptation à certains appareils avec conversion webp anormale (l'image recadrée peut être plus grande que l'originale). Après sélection d'une image, détermination de sa taille et compression secondaire.**
2. **Amélioration de la description des répétitions cibles sur la page de détails**
3. **Prise en charge de l'utilisation du même Objet pour accumuler le temps pendant le compte à rebours**
4. **Ajout de Tâches guide supplémentaires pour les débutants**
5. **Mise à jour des traductions**

**🐛 Corrections**

1. **Correction du problème d'interface anormale sur la page de composition**
2. **Correction de plusieurs plantages connus**
3. **Amélioration du problème où le compte à rebours des Objets pouvait être interrompu anormalement et accumuler du temps lors de comptes à rebours prolongés**
4. **Correction de l'exception d'interface de la fenêtre contextuelle d'Émotions lorsque le widget finalise une Tâche**

**1.90.4 (2022/09/15)**

1. **Correction du problème anormal lorsque le widget finalise une Tâche (peut provoquer une page transparente et empêcher de continuer)**
2. **Désactivation de la capacité du widget à sélectionner des images depuis les Émotions**

**1.90.3 (2022/09/14)**

1. **Correction du problème de focus lors du tri des sous-tâches**
2. **Amélioration de la couleur des Attributs dans les Tâches gelées ou non démarrées**
3. **Ajout de la diffusion d'événements pour les Tâches abandonnées**
4. **Correction de la couleur du texte de probabilité**
5. **Amélioration des Tâches de démarrage (Tâches prédéfinies)**
6. **Correction du problème où la boîte de dialogue d'importation d'Objets pouvait sélectionner la liste « Toutes » par défaut**
7. **Correction des problèmes de regroupement d'Objets dans la Boutique**
8. **Un avertissement s'affiche désormais lors de la définition d'une heure inhabituelle (l'heure ne correspond pas à la fréquence de répétition).**
9. **Amélioration des règles de calcul des Tâches dans le calendrier ; elles devraient désormais prédire avec précision les échéances des Tâches futures.**
10. **Correction du problème où le calendrier calculait la finalisation pour les Tâches gelées.**
11. **Amélioration du paramètre d'heure de début par défaut lors de l'édition de Tâches.**
12. **Amélioration du mécanisme de détection de licence.**
13. **Optimisation du traitement du compte à rebours des Objets. L'exécution répétée est interdite pour réduire l'accumulation de temps non souhaitée.**
14. **Correction du problème edge-to-edge lors de l'utilisation de touches virtuelles sur certaines pages.**
15. **Correction du problème où l'on ne pouvait pas sélectionner une image d'Émotion lorsque le widget de bureau finalisait une Tâche.**

**1.90.2 (2022/08/31)**

**✨ Fonctionnalités**

1. **Ajout d'événements de diffusion.**
   Vous pouvez désormais utiliser Tasker/MacroDroid pour recevoir des événements tels que l'utilisation d'Objets, la finalisation de Tâches, etc., et déclencher des actions Tasker.

   Par exemple : si un Objet est utilisé, cela déclenchera le changement de fonds d'écran aléatoires.
   En théorie, si vous le souhaitez, vous pouvez implémenter des fonctions comme le verrouillage d'applications et des scénarios d'interaction avec des jeux.

2. **Nouvelles API :**

- Abandonner des Tâches
- Geler des Tâches
- Dégeler des Tâches
- Interface vide
- Requête

3. **Ajout d'une valeur de retour pour les API d'ajout d'Objet et de Tâche**
4. **Lors de l'importation d'Objets depuis le marché, vous pouvez désormais sélectionner la liste cible**
5. **Adaptation à la couleur secondaire de Material 3**
6. **Mise à jour des traductions ; ajout de la prise en charge du coréen**

**♻️ Améliorations**

1. **Lors de l'ouverture de Boîtes de butin en lot, affichage également de la probabilité d'un seul produit**
2. **Optimisation de certains effets d'affichage de l'interface en mode nuit**
3. **Optimisation de la logique interactive de la fenêtre contextuelle de sélection de date et heure. Lors de la sélection du jour actuel, bascule automatique vers la page de sélection de l'heure.**
4. **Lorsque l'API appelle la sélection d'Objets et de listes, la fenêtre contextuelle ne prend plus en charge la fermeture directe (pour éviter la perte d'appels API)**
5. **Optimisation de la hauteur par défaut de certaines fenêtres contextuelles en bas de l'écran horizontal sur tablette**
6. **Optimisation du timing de fermeture automatique des fenêtres contextuelles**

**🐛 Corrections**

1. **Correction du problème où la recherche de Tâches par API pouvait échouer dans certains cas**
2. **Correction d'un plantage occasionnel sur la page de liste de Tâches**
3. **Correction du problème où le bouton « Annuler » apparaissait lors d'un appui long sur des Succès normaux non débloqués**
4. **Correction du problème où la fenêtre contextuelle de détails de Succès pouvait s'afficher de manière incomplète**
5. **Correction du problème où le téléversement pouvait échouer en raison d'images anormalement volumineuses**
6. **Correction du problème où own_number et stock_number de l'API Objets ne prenaient pas en charge les nombres négatifs**
7. **Correction du problème où le nombre de jours de persistance sur la page « Moi » s'affichait parfois anormalement comme 1**
8. **Correction du problème où « il y a -x jours » s'affichait parfois**
9. **Correction du problème où les API suivantes pouvaient être annulées anormalement lors d'appels API par lot**
10. **Correction du problème où le contenu saisi lors de la création d'une nouvelle équipe pouvait être perdu lors de la destruction de la page**

**1.90.1 (2022/08/22)**

**🐛 Corrections**

1. **Correction du problème de concurrence des appels API**
2. **Correction du problème où, lors de la sélection d'un grand nombre de produits (milliers), la sélection multiple pouvait provoquer un blocage**
3. **Correction du problème anormal lorsque le widget finalise une Tâche d'équipe**
4. **Correction du problème où l'édition des Points d'Expérience des sous-tâches n'était pas préremplie**

**🎉1.90.0 (rc01, rc02) (2022/08/15)**

**✨ Fonctionnalités**

1. **Optimisation des paramètres de Récompenses de Tâches :**
   - Ajustement de l'interface des paramètres de Récompenses
   - Les sous-tâches prennent en charge la définition de Récompenses en Points d'Expérience et Objets
   - La Récompense « texte seul » d'origine devient une Récompense indépendante de « mots »
   - Prise en charge de la définition de la valeur par défaut de Points d'Expérience

2. **Les Objets prennent en charge les restrictions d'achat par Niveau d'Attribut.**

3. **Les Objets prennent en charge l'effet « URL ».**
   Vous pouvez non seulement ouvrir des pages web, mais aussi appeler d'autres applications ou l'API de LifeUp. Permet des effets comme l'augmentation du prix après utilisation de l'Objet.

4. **API ouvertes.**
   Vous pouvez désormais intégrer des logiciels d'automatisation ou effectuer un développement secondaire.

   [Pour plus de détails, consultez la documentation API.](https://wiki.lifeupapp.fun/en/#/guide/api)

5. **La Boutique prend en charge l'affichage de l'effet de comptage non raffiné**

6. **Optimisation des notifications :**

   - Ajout d'une notification de changement de Niveau d'Attribut
   - Ajout d'une notification de Succès débloqué
   - Optimisation des groupes de notifications

7. **Prise en charge de l'ajout manuel d'enregistrements de minutage.**

8. **Possibilité de placer la page Pomodoro dans la barre de navigation**

9. **Prise en charge du masquage de la liste [Succès système]**

10. **La version cible de l'API est adaptée à Android 12L**

11. **Optimisation des effets d'immersion**

12. **Les widgets de l'App prennent en charge l'affichage de la fenêtre contextuelle de finalisation de Tâche**

13. **Vous pouvez désormais finaliser la Tâche sur la page de détails de l'élément**

14. **Dans la fenêtre contextuelle de retard, vous pouvez définir le nombre de Tâches compteur**

15. **Vous pouvez désormais modifier le nom de la Tâche d'équipe**

16. **Optimisation du timing des requêtes réseau du module monde, réduisant le trafic et la pression sur le serveur**

**♻️ Améliorations**

1. **Le mode nuit prend désormais en charge toutes les couleurs de thème, avec une personnalisation nocturne distincte pour chaque couleur, adaptée à Material 3**
1. **Ajout du lien « Optimisation de la batterie » dans la boîte de dialogue de configuration de compatibilité**
1. **Ajout de l'interrupteur « Garder l'écran allumé » dans les paramètres Pomodoro**
1. **Propose les deux options « Terminer » et « Accumuler » pour le compte à rebours de l'Objet en état pause**
1. **Lorsque le nombre d'objectifs modifiés est supérieur au nombre actuel, un message d'erreur s'affiche**
1. **Les éléments négatifs ne doivent pas s'afficher dans les paramètres de coefficients de pénalité**
1. **Optimisation de l'effet de rafraîchissement sur la page Historique**
1. **Optimisation de la logique de déclenchement automatique de la Tâche principale après finalisation d'une sous-tâche ; traitement direct sur la page de détails**
1.

**🐛 Corrections**

1. **Correction du problème où le bouton + apparaissait parfois sur la page Moments**
2. **Correction du problème où les Tâches négatives n'affichaient pas la boîte de dialogue d'Émotions**
3. **Correction du problème où l'objectif des Tâches négatives ne prenait pas effet**
4. **Tentative de réparation de l'effet du paramètre « geler jusqu'à... » pour les Tâches d'équipe**
5. **Correction du problème où l'image de la page Émotions pouvait s'afficher incorrectement**

**1.89.5 (2022/8/5)**

1. **Optimisation du problème de connexion réseau**
2. **Mise à jour des traductions**

**1.89.4 (2022/7/13)**

1. **Correction des informations sur les questions Xiaohong Dot**
2. **Correction du problème de génération répétée des Tâches répétitives (cette fois, cela devrait vraiment être réparé .jpg)**

**1.89.3 (2022/7/05)**

**♻️ Améliorations**

1. **Optimisation du critère de la liste d'interrupteurs coulissants**

**🐛 Corrections**

1. **Correction du problème où le calcul pouvait ne pas se terminer lorsqu'il y a beaucoup de conditions de Succès**
2. **Correction du problème où le rappel de notification des Tâches indéfinies affichait une échéance anormale**
3. **Correction du problème où la modification de l'arrière-plan d'un Objet affectait l'Objet copié après copie**
4. **Correction du problème où la Compétence lors de l'édition de Tâches d'équipe pouvait ne pas être héritée**

**1.89.2 (2022/6/23)**

**♻️ Améliorations**

1. **Suppression de l'autorisation CARMRA inutile**
2. **Mise à jour des traductions**

**🐛 Corrections**

1. **Correction de certains plantages**

**1.89.0-1.89.1 (2022/6/09)**

**✨ Fonctionnalités**

1. **Prise en charge du déblocage multiple des Succès conditionnels**
2. **Les détails de Succès prennent en charge l'affichage des détails et de la progression des conditions**
3. **Étiquettes de Tâches**
4. **Tâches répétitives sans échéance**
5. **Masquer les Objets épuisés ou dont l'achat est désactivé**
6. **Lors de la définition de l'effet de réduction de Points d'Expérience pour un Objet, la limitation d'utilisation est optionnelle**
7. **La page Inventaire prend en charge la sélection multiple, tout sélectionner et les retours par lot**
8. **La liste de Tâches par défaut prend en charge l'archivage**
9. **Refonte de certaines pages telles que les paramètres, Q&R, barre d'outils de la Boutique et page d'ajout de listes**
10. **Refonte de certaines icônes de l'App (icônes de cartes de Tâches par défaut, pièces, Points d'Expérience, icônes de Succès)**
11. **Le stockage des images a été déplacé vers le chemin privé externe de l'App pour éviter la suppression accidentelle de fichiers**

**♻️ Améliorations**

1. **Ajout du lien vers l'article [Configuration de compatibilité] sur la page des paramètres**
2. **Compte à rebours Pomodoro — l'opération de réinitialisation ajoute une boîte de dialogue de confirmation**
3. **Ajout d'une description pour le gel des Tâches**
4. **Ajout d'une description pour les sous-catégories de Succès**
5. **En mode hors ligne, ajout d'un bouton pour quitter le mode hors ligne sur la page de modification du profil**
6. **Optimisation des statistiques des Tâches négatives ; prise en charge de l'affichage du nombre d'abandons du jour et du suivi des Succès**
7. **Optimisation de la vitesse de démarrage de l'App**
8. **Les icônes de Succès prennent en charge l'affichage en grand**
9. **Ajout des statistiques de « j'aime » (reçus) pour les Tâches aléatoires**
10. **Optimisation unifiée de l'interaction de recherche**
11. **Lors de la sélection d'un Objet, basculer vers une liste vide affiche une mise en page vide (au lieu de chargement)**
12. **La page d'image agrandie s'adapte aux paramètres de couleur de thème actuels**
13. **Optimisation de l'effet d'animation lorsque la hauteur de la fenêtre contextuelle d'Objets et Tâches sélectionnés change**
14. **Dans les paramètres de sauvegarde, « Supprimer les données locales » prend également en charge la suppression des fichiers multimédias**
15. **Unification de la logique de stockage et de suppression des fichiers temporaires lors de la prise de photos**
16. **Distinction entre l'icône par défaut de l'Objet et l'icône qui ne charge pas**
17. **Activation par défaut du paramètre de pénalité indépendant pour les Tâches**
18. **Optimisation du rafraîchissement, de la logique d'animation et de la vitesse de chargement de la page Émotions**
19. **Certaines fenêtres contextuelles de détails ajoutent un bouton de raccourci « Sélectionner »**
20. **Lorsque les interrupteurs principaux « effets sonores » et « vibration » dans les paramètres avancés sont désactivés, des instructions correspondantes sont également affichées dans les paramètres Pomodoro**
21. **Optimisation du tri des nouveaux Succès et des sous-catégories**
22. **Mise à jour de la bibliothèque de base et des dépendances**
23. **Optimisation de la méthode et de la vitesse de calcul de la progression des Succès**
24. **Amélioration de la méthode de calcul des « fois cible (répétitions) » pour suivre l'amélioration statistique des enregistrements historiques, cohérente avec le nombre de fois dans les détails**
25. **Lors de la saisie du nombre de pièces et des répétitions cibles, toutes les valeurs actuelles sont automatiquement sélectionnées**
26. **Optimisation du message d'erreur lorsque la configuration WebDAV est anormale**
27. **Optimisation du message d'erreur lorsque la sauvegarde Google Drive est anormale**
28. **Possibilité de sélectionner le nom de la Tâche sur la page de détails**

**🐛 Corrections**

1. **Correction du problème où le comptage défini invalidait la Récompense de Tâches après exécution de la logique de répétition**
2. **Correction du problème de tri et de regroupement sur la page Boutique**
3. **Correction du problème anormal de défilement haut/bas dans les Tâches aléatoires dans certains cas**
4. **Correction du problème où la statistique Pomodoro sur la page d'état était imprécise après utilisation du minutage positif dans certains cas**
5. **Correction du problème où la logique de répétition des Tâches d'équipe perdait le paramètre de type compteur**
6. **Correction du problème où la Tâche sélectionnée par Pomodoro restait surlignée lors de la sélection de Tâches liées aux conditions de Succès**
7. **Correction du problème où l'image d'Émotion n'était pas stockée indépendamment et problèmes d'affichage**
8. **Correction du problème où le message d'échec de connexion pouvait apparaître fréquemment**
9. **Certains champs de saisie spéciaux pour les nouvelles Tâches, équipes et sous-tâches ne doivent pas autoriser la saisie clavier, ce qui pouvait provoquer un plantage de l'App**
10. **Optimisation de la façon de compter les finalisations d'Objets illimités dans les widgets, cohérente avec l'App**
11. **Correction du problème où, après ajustement du taux d'intérêt de l'ATM, l'intérêt pouvait être calculé selon le temps accumulé et le taux ajusté**
12. **Correction du problème où les Tâches gelées pouvaient encore s'afficher dans la liste intelligente**
13. **Optimisation du problème où le bouton d'action bloqué par la barre de sélection restait cliquable lors de la sélection de certains objets (Tâches, Objets de la Boutique)**
14. **Correction du problème où le changement de couleur d'un Objet ne rafraîchissait pas immédiatement l'interface**
15. **Correction du problème où fixer soudainement un taux d'intérêt élevé après l'avoir maintenu bas (sans obtenir 1 pièce) pouvait générer des intérêts énormes**
16. **Correction du problème où la boîte de recherche apparaissait après finalisation d'une Tâche après ouverture de la barre de recherche et utilisation du produit**
17. **Correction du problème où le nombre de finalisations du jour dans l'App pouvait ne pas correspondre au widget après modification du nom d'une Tâche infinie**
18. **Correction d'animations étranges lors de la finalisation de Tâches illimitées**
19. **Correction du problème où copier une Tâche ne copiait pas son arrière-plan**
20. **Correction du problème où, dans certains cas, les conditions de Succès étaient remplies mais le Succès ne pouvait pas être débloqué**
21. **Correction d'une exception dans le calcul des intervalles de dates (peut affecter plusieurs logiques)**
22. **Correction du problème où les Émotions n'étaient pas automatiquement filtrées depuis la page de détails de Tâches**

**1.88.4 (2022/4/21)**

1. **Correction du plantage lors de la recherche dans l'Inventaire**
2. **Correction du désordre d'affichage de l'arrière-plan personnalisé et de la page historique**
3. **Correction du chevauchement de l'interface lors de l'édition**
4. **Correction du problème où la quantité pouvait s'afficher anormalement lorsque le Succès octroyait des Objets en Récompense**
5. **Correction du problème où les fois de finalisation dans le calcul de Succès pouvaient ne pas correspondre aux fois réelles dans certains cas particuliers**
6. **Correction du problème où le titre pouvait disparaître lors de clics rapides sur la page historique**
7. **Lors de la création ou de l'édition d'une Tâche, après avoir cliqué sur la propriété, le clavier virtuel ne pouvait pas réapparaître en cliquant à nouveau sur le champ de saisie ayant le focus**
8. **Correction du plantage lors de la définition de la limite d'achat mensuelle en français**

**1.88.3 (2022/4/09)**

1. **Correction du problème où, après restauration de la sauvegarde, la sauvegarde cloud affichait un conflit**
2. **Correction du problème où l'heure de début de Tâche modifiée et l'heure de rappel de sous-tâche ne sélectionnaient pas par défaut l'heure saisie**
3. **Correction du problème où d'autres effets n'étaient calculés qu'une seule fois lors de la Synthèse simple par lot**
4. **Correction du problème où tout Attribut de Succès système atteignant le Niveau 10 n'était pas comptabilisé dans l'Attribut personnalisé**
5. **Correction de l'affichage anormal de l'interface textuelle sur la page « Moi » pour les non-membres**

**1.88.2(-)**

> Mises à jour incluses dans 1.88.3

**1.88.1 (2022/4/02)**

1. **Correction d'un plantage causé par le rappel de sauvegarde**

**1.88.0 (2022/3/30)**

✨ Fonctionnalités

1. **Ajout de la fonction de partage des « Tâches aléatoires » dans le module monde**
2. **Les Objets compteur peuvent optionnellement définir un coefficient affectant le nombre d'Objets**
3. **Prise en charge de la définition du taux d'intérêt des prêts**
4. **La gestion d'images prend en charge le filtrage en un clic des images inutilisées + tout sélectionner**
5. **Prise en charge de la taille de recadrage d'image personnalisée (icônes haute définition, fonction membre)**
6. **Affichage explicite de l'interrupteur « Émotions » dans le Succès**
7. **Optimisation de l'algorithme de tri de la liste « Toutes »**

⚡️ Optimisations

1. **Optimisation des effets visuels de certaines fenêtres contextuelles**
2. **Optimisation de l'interaction des fonctions de sauvegarde/restauration**
3. **Optimisation de la vitesse de chargement de la page de délégation**
4. **Optimisation majeure de la vitesse de chargement de la fenêtre contextuelle de sélection de produits**

🐛 Corrections

1. **Correction du désordre de l'arrière-plan personnalisé**
2. **Correction du problème où la Tâche pouvait être créée dans une liste supprimée**
3. **Correction de certains plantages**

**1.87.1（2022/3/07）**

1. **Le menu de tri de la Boutique et de l'Inventaire affiche explicitement le tri « personnalisé »**
2. **Correction du problème où un tri anormal pouvait survenir dans l'Inventaire**
3. **Ajout d'un bouton pour accéder au feedback par e-mail sur la page de commentaires**
4. **Optimisation du message d'échec de restauration en raison de problèmes de version de base de données**
5. **Correction du problème où le nombre de pièces n'était pas affiché sur la carte en mode compact**

**1.87.0 official version (2022/3/04)**

1. **Correction du problème où l'arrière-plan de carte personnalisé pouvait zoomer anormalement dans certains cas**
2. **Correction du problème où cliquer sur la notification de rappel de Tâche pouvait ouvrir de mauvais détails lors de rappels continus**
3. **Correction du problème où les chiffres de la carte n'étaient pas rafraîchis lors du glissement pour augmenter le compteur de Tâches compteur**
4. **Ajout d'une nouvelle Tâche guide pour certaines langues**

**1.87.0-rc02（2022/2/25）**

1. **Amélioration de la gestion des erreurs et des messages pour les opérations de récupération**
2. **Optimisation de l'interaction lors de la définition du « jour de la semaine » ; ajout d'un avertissement de configuration anormale (début et période pas le même jour)**
3. **Optimisation de l'harmonie des couleurs en mode nuit sur certaines pages**
4. **Correction du problème où le cache pouvait s'afficher incorrectement dans le sélecteur d'images et la gestion d'images**
5. **Correction du problème où l'opération « Télécharger » dans la fenêtre contextuelle de conflit de sauvegarde ne prenait pas en charge Google Drive/Dropbox**
6. **Correction du problème où la recherche de la Boutique pouvait afficher de mauvais résultats**
7. **Correction du problème où l'épinglage d'une Tâche pouvait échouer**
8. **Correction de certaines exceptions d'interface et problèmes de texte**

**1.87.0-rc01（2022/2/23）**

**✨ Fonctionnalité**

1. **Les sous-catégories de Succès prennent en charge le pliage**
2. **Introduction de l'interrupteur de style Material You (expérimental)**
3. **L'Inventaire prend en charge le tri par Boutique**
4. **L'Inventaire prend en charge l'opération « favori » sur les Objets**
5. **La Boutique prend en charge l'opération tout sélectionner**
6. **Les opérations liées à la Boutique et à l'Inventaire prennent en charge la sélection de quantité MAX**
7. **Les Tâches prennent en charge la création continue**
8. **Configuration de Tâche : la description de la Récompense d'Objet est automatiquement ajoutée aux remarques de la carte (c'est-à-dire « Récompense : [un produit] x1 » s'affiche automatiquement)**
9. **Les Tâches prennent en charge une durée de gel spécifiée**

**⚡️ Améliorations**

1. **Ajout d'un bouton « Ignorer » dans la fenêtre contextuelle de conflit de sauvegarde**
2. **La version Google Play prend en charge le français/polonais**
3. **Le rappel de notification au clic sur une Tâche prend désormais en charge le saut vers les détails de la Tâche**
4. **Lors de l'édition de l'heure liée à la Tâche, la fenêtre contextuelle par défaut pointe vers l'heure avant modification plutôt que l'heure actuelle**
5. **Chaque entrée de sélection de liste de la Boutique prend en charge les opérations « Renommer », « Supprimer » et « Nouveau »**
6. **Refonte de l'interface de la page d'extensions**
7. **Ajout d'une seconde fenêtre contextuelle de confirmation pour « Supprimer le compte calendrier »**
8. **Le produit n'est plus automatiquement retiré de la vente s'il est épuisé**
9. **La Tâche « Se lever tôt » de l'exemple passe à une pénalité de 0**
10. **Lors de l'obtention d'une Récompense d'Objet, si la quantité est négative, un avertissement associé apparaît désormais**
11. **Optimisation de l'algorithme aléatoire des pièces dans l'effet d'utilisation d'Objets**
12. **L'opération « Marquer comme terminée » ajoute un effet sonore de finalisation**
13. **Optimisation de partie de l'affichage de l'interface en mode nuit**
14. **Optimisation des performances de la liste de Tâches**

**🐛 Corrections**

1. **Correction de l'anomalie du texte « unconcerned » dans certaines langues**
2. **Correction du problème où l'icône du produit dans la fenêtre contextuelle « Retour » pouvait s'afficher anormalement**
3. **Correction du problème où la Tâche pouvait être générée à répétition lors d'une finalisation rapide**
4. **Correction du problème où la mémoire de la liste actuelle du système « Synthèse » pouvait être invalidée**
5. **Correction du problème où la connexion QQ pouvait être impossible en mode paysage**
6. **Correction du problème où, lors de l'édition d'une recette dans la liste [Toutes] du système « Synthèse », la recette pouvait disparaître de la liste d'origine**
7. **Correction du problème où cliquer plusieurs fois de suite pour finaliser une Tâche infinie pouvait faire revenir le nombre de finalisations à zéro**
8. **Correction du problème où l'intervalle de sauvegarde ne pouvait pas être défini sur « Mensuel »**
9. **Correction du problème où l'icône de Points d'Expérience ne s'affichait pas en mode simple**
10. **Correction du problème où les colonnes « Succès » et « Liste de Succès » manquaient dans la gestion d'images**
11. **Correction du problème où la page de détails de Tâche ne prenait pas en charge l'abandon de Tâches d'équipe**
12. **Correction du problème où le guide du module monde ne s'affichait pas correctement**
13. **Correction du problème où le produit pouvait être partagé avec succès lorsque le téléversement d'image échouait, mais l'image locale était écrasée**
14. **Correction de certains plantages et exceptions rares**

**1.86.0（2022/1/20）**

**Fonctionnalités**

1. **Sous-catégorie de Succès : division des catégories, comptage automatique par catégorie**
2. **Sauvegarde Google Drive**
3. **Fonction de gestion d'images (dans la page de sauvegarde)**
4. **Effet aléatoire de pièces sur les Objets**
5. **Copie par lot de Succès**
6. **Le comptage de pas prend en charge la saisie multiple de pas et plusieurs Récompenses**
7. **Pomodoro prend en charge la configuration de l'échange d'Objets**
8. **Prise en charge d'un ratio de remise de retour personnalisé**
9. **Format exclusif pour la sauvegarde (certains systèmes prennent en charge l'ouverture et l'importation directes)**
10. **La Synthèse simple prend en charge les opérations par lot**
11. **Nouvelle option d'effet sonore personnalisé : utilisation d'Objets**
12. **Nouvelle condition de déblocage de Succès : dépôt ATM actuel**
13. **Les statistiques du nombre de fois pour les éléments négatifs prennent en charge la page de détails**
14. **La liste « Toutes » prend en charge le renommage**
15. **Unification du nom et de la description des canaux de notification de l'App**

**Améliorations**

1. **Prioriser les Succès débloqués mais dont la Récompense n'a pas été reçue**
2. **Le temps de Concentration du jour Pomodoro sur la page d'état s'affiche en heures selon la durée**
3. **L'Inventaire ajoute l'affichage de la description des Objets**
4. **L'enregistrement d'un nouveau compte affiche une boîte de dialogue de confirmation**
5. **Prise en charge de l'affichage des annonces de maintenance**
6. **Ajout d'une boîte de dialogue de confirmation « Ignorer » pour le temps supplémentaire Pomodoro**
7. **Prise en charge de la sauvegarde des données lors de la désinstallation de l'App (nécessite le support du système)**
8. **Optimisation de la logique de sauvegarde et de récupération**
9. **Optimisation de la logique de retard pour les Objets uniques et illimités, avec prise en charge de l'édition**
10. **Optimisation de la base temporelle des statistiques graphiques des événements illimités, basée sur l'heure de finalisation plutôt que l'échéance**
11. **La carte en mode compact affiche également le temps de retard des Objets uniques et illimités**
12. **Tentative d'amélioration de la survie de la fonction de compte à rebours en arrière-plan**
13. **Optimisation de la fonction Émotions :**
    - Activée par défaut
    - La page de paramètres de Tâche d'équipe n'affiche pas l'interrupteur « Émotions » qui n'a en réalité aucun effet
    - Suppression de la fonction confuse de mémorisation de l'interrupteur Émotions
14. **Augmentation du nombre d'Objets affichés dans la fenêtre contextuelle de sélection des listes d'Objets et d'Inventaire**
15. **Lorsque la barre de notifications continue le minutage, l'effet de vibration en cours est également annulé**
16. **Le texte dynamique du module monde prend en charge la copie partielle**
17. **Optimisation de l'effet d'animation de rafraîchissement des données sur la page de Succès personnalisés**
18. **Optimisation de la logique de récupération ; affichage de la boîte de dialogue « Chargement » au lieu de bloquer l'interface**
19. **Optimisation du problème où le bouton du bas pouvait ne pas être visible dans la « fenêtre contextuelle de plantage »**
20. **En cliquant sur le rappel de notification de Tâche, saut vers la page de liste où se trouve la Tâche**
21. **L'icône d'Attribut personnalisé prend en charge la sélection dans la bibliothèque d'icônes intégrée de l'App**
22. **Optimisation du nom de l'opération de partage « Lire plus tard » au lieu d'afficher directement le nom de l'App**
23. **Optimisation de la notification de déblocage de Succès ; la description du Succès s'affiche désormais**
24. **Lorsque le widget de bureau entre sur la page d'accueil, saut automatique vers le module « délégation »**
25. **Optimisation de l'affichage du texte après finalisation de la liste du jour**
26. **Optimisation du texte et de la séquence d'opération de l'effet de compte à rebours des Objets**
27. **Lorsque tous les Attributs sont masqués, la page d'état n'affiche plus la carte « Attribut »**

**Corrections**

1. **Correction d'un plantage rare dans les fenêtres contextuelles de déblocage de Succès**
2. **Correction du problème où une Tâche pouvait occuper plusieurs lignes sur des widgets de bureau de largeur insuffisante**
3. **Correction du problème où la première autorisation d'exercice pour le comptage de pas pouvait afficher le total accumulé par le capteur**
4. **Correction du plantage ou de la confusion lors de la reprise après pause d'un compte à rebours puis démarrage d'un autre**
5. **Correction du plantage lors de la saisie d'un effet de compte à rebours de 0 minute sur un Objet**
6. **Correction du problème où le nom de la liste sélectionnée ne se rafraîchissait pas lors du renommage de la liste actuelle sur la page d'ajout ou d'édition d'Objets**
7. **Correction de l'affichage anormal des cartes avec fréquence de répétition « annuelle »**
8. **Correction du problème où les pièces personnalisées ne prenaient pas effet à temps dans certains cas**
9. **Correction du problème où les widgets affichaient des Objets gelés**
10. **Correction du problème où le Succès personnalisé n'affichait pas l'invite « appui long »**
11. **Correction du problème où le total de Points d'Expérience sur la page « Moi » ne comptabilisait pas ceux des Attributs personnalisés**
12. **Correction du problème où la page « Émotions » revenait en haut après prévisualisation anormale d'une image**
13. **Correction du problème où le raccourci statique « Pomodoro » ne sautait à la page d'accueil que si l'App était déjà démarrée sous MIUI**
14. **Correction du problème où les non-membres pouvaient aussi charger des arrière-plans personnalisés**
15. **Correction du problème où le nombre de pièces sur la page Boutique n'était pas rafraîchi à temps**
16. **Correction du problème où le calendrier ne pouvait pas passer à l'année suivante**
17. **Correction du problème où le nom de liste du widget n'était pas rafraîchi après modification du nom de la liste**

**Release Candidate → Version officielle**

1. **Optimisation du taux de réussite du téléversement de gros fichiers sur Google Drive ; plus de tentatives et stratégie de blocs optimisée**
2. **Correction du problème où les membres pouvaient ne pas voir le bouton d'arrière-plan personnalisé individuel de Tâche dans un environnement non chinois**
3. **En cas d'échec de la sauvegarde Google Drive/DropBox, saut vers la page de sauvegarde au lieu de la configuration WebDAV**
4. **Ajout d'une description dans la fenêtre contextuelle d'échec de vérification Google Play, avec chemin d'exportation des données**
5. **Le surnom sur la page « Moi » change de couleur selon le statut de membre**
6. **Élimination de l'erreur de virgule flottante du taux d'intérêt ATM dans la plupart des scénarios**
7. **Lors de la suppression des données locales, l'arrière-plan personnalisé, les images d'Attributs et les fichiers d'effets sonores sont également supprimés**
8. **Correction du problème anormal du graphique de comptage de pas**
9. **Correction du problème où les Attributs de la page de nouvelle Tâche ne se rafraîchissaient pas après clic sur le bouton d'aide, navigation vers la personnalisation d'Attributs et retour**
10. **Lors de la personnalisation de l'effet d'un Objet, cliquer à l'extérieur de la fenêtre contextuelle ne la ferme plus automatiquement, évitant la perte du contenu édité**
11. **Optimisation du problème d'interface en langues étrangères sur la page de paramètres d'Objets (texte russe trop long)**
12. **Tentative de correction du plantage du toast de couleur sur certains modèles**
13. **Correction du problème où le bouton d'utilisation restait cliquable lorsque la page Inventaire était sélectionnée**
14. **Correction de la logique d'affichage des Tâches uniques en retard dans la liste intelligente, adaptée à la nouvelle méthode de stockage de l'heure de retard**
15. **Lorsque l'Inventaire est sélectionné, la liste basculée doit être désélectionnée**

**1.85.4 (2021/12/08)**

Version habituelle de correction de bugs ; la prochaine version avec nouveautés est toujours en développement~

1. **Correction du problème où l'icône par défaut de pièces du widget ne s'affichait pas correctement hors mode sombre**
2. **Correction du problème où l'animation de la barre de progression ne se jouait pas normalement lors de montées/descentes de Niveau continues**
3. **Correction du problème où le nombre de pièces sur la page Inventaire n'était pas mis à jour à temps**
4. **Correction du problème où l'échéance pouvait être modifiée de force lors de l'édition de l'élément « jour de la semaine »**
5. **Correction du problème où la rotation d'écran pouvait faire perdre les informations des sous-tâches modifiées lors de l'édition de Tâches**
6. **Correction du problème où le nombre de pièces ne prenait pas réellement effet lors de la création ou de l'édition de produits**
7. **Conditions d'affichage des fois de finalisation annuelles sur la page de détails d'amendement**
8. **Optimisation du stockage des images dans l'App ; elles ne devraient pas être indexées dans l'album système**
9. **Optimisation de la description de l'interrupteur Émotions**
10. **Correction de certains plantages**

**1.85.3 (2021/11/18)**

1. **Optimisation de la méthode de calcul du temps de minutage ; compensation du temps de veille CPU**
2. **Correction du problème où la modification de l'icône lors de la copie d'un produit faisait perdre l'icône du produit d'origine**
3. **Autres corrections mineures (comme l'étiquette d'équipe)**

**1.85.2 (2021/11/07)**

1. **Correction du problème où aucun enregistrement ni Récompense n'était généré lors du règlement après suspension du minutage**
2. **Correction du problème où l'opération « déplacer vers » sous la liste intelligente faisait afficher la liste de manière incorrecte**
3. **Correction du problème où l'affichage de la valeur actuelle du « Nombre actuel de pièces » ne correspondait pas au calcul réel (l'affichage n'incluait pas les dépôts ATM)**
4. **Correction du problème où l'enregistrement et la Récompense se répétaient après la fin du travail Pomodoro puis deux clics consécutifs sur le bouton ignorer**

**1.85.1 (2021/11/02)**

0. **Correction du problème de chargement de la liste d'Émotions**

**1.85.0 2021/10/20)**
*Fonctionnalités*

1. **Pomodoro prend en charge le mode de minutage positif**
2. **Coller plusieurs lignes de texte pour créer rapidement des sous-tâches**
3. **Les Objets prennent en charge l'opération de copie**
4. **Glisser pour changer la direction de la liste d'Objets ; prise en charge de l'inverse (paramètres-Objets)**
5. **Prise en charge de l'effacement de l'enregistrement Pomodoro obtenu**
6. **Pomodoro ajoute un bouton forcé de bascule horizontal/vertical**
7. **Augmentation des conditions de déblocage de Succès :**
   ● Nombre de produits obtenus par Synthèse
   ● Quantité cumulée d'Objets obtenus
   ● Quantité actuelle du produit
   ● Niveau de vie
   ● (Répétitive) temps de Concentration de la Tâche
8. **L'icône de Compétence prend également en charge plusieurs paramètres de recadrage**
9. **Raccourci statique :**
   ● Nouvelle Tâche
   ● Entrer sur la page Pomodoro
10. **Augmentation de la personnalisation des effets sonores :**
    ● Obtention de Récompenses de Succès (Succès système et personnalisés inclus)
    ● Ouverture de Boîte de butin
    ● Synthèse (Synthèse simple et Synthèse incluses)
    ● Effet sonore de notification
11. **Personnalisation de l'icône de pièces**
12. **L'effet d'utilisation d'Objet prend en charge la définition de plusieurs effets de changement de Points d'Expérience**
13. **Modifications de l'adaptation des Compétences au graphique circulaire de Points d'Expérience**
14. **La page historique prend en charge le filtrage par statut**
15. **Fonction d'étiquette d'équipe**

*Améliorations*

1. **Lorsque la Récompense en pièces de sous-tâche est 0, elle n'est pas affichée dans les détails**
2. **Nouvelle page de liste de Succès et guide « Créer un Succès »**
3. **Optimisation de l'affichage des icônes de widgets**
4. **Ajout d'effets sonores lors de la finalisation de sous-tâches (détails, nouvelles pages)**
5. **Après saisie de contenu sur les pages de création ou d'édition (Tâches, Objets, Succès, Synthèse), un clic sur retour affiche une boîte de confirmation pour abandonner les modifications**
6. **Optimisation du tri lors de la création de produits (avec tri personnalisé, les nouveaux produits ont la priorité maximale)**
7. **Lors de l'édition de Tâches/Objets, la méthode de saisie ne doit pas s'ouvrir automatiquement**
8. **La page de nouvelle Tâche prend en charge le mode paysage sans perte de données**
9. **Adaptation de la couleur de thème membre pour les widgets de bureau**
10. **Optimisation du sélecteur d'Objets ; affichage d'abord, puis chargement asynchrone des données**
11. **L'étiquette Inventaire ajoute également les entrées « Synthèse » et « ATM »**
12. **Les opérations [Marquer comme terminée] et [Annuler] dans le changement d'état de l'historique reviennent au menu de premier niveau**
13. **Ajout d'une entrée rapide Pomodoro dans les détails de l'événement**
14. **Optimisation du tri de la liste « Toutes » de la Boutique (ajout de l'option de regroupement par liste, Boutique uniquement)**
15. **Après sélection des jours de la semaine pour la répétition, l'heure limite est recalculée. (Évite que, en répétant les jours ouvrables, l'échéance reste un samedi ou dimanche.)**
16. **Lors du retour à la page « Délégation », si le bouton « + » n'est pas affiché, son affichage est déclenché.**

*Corrections*

1. **Correction du problème où la progression de la liste n'était pas rafraîchie à temps lorsque la page Succès était dans la barre de navigation inférieure**
2. **Correction du problème de changement d'état des Objets historiques**
3. **Réparation de l'affichage de retard des comptes à rebours négatifs**
4. **Les Succès en pièces doivent être inclus dans le dépôt ATM**
5. **Correction du problème où, avec Pomodoro en pause, y revenir deux fois effaçait le temps**
6. **Correction du problème où la restriction d'achat pouvait devenir invalide dans certaines circonstances**
7. **Correction du problème où les enregistrements de compte à rebours pouvaient se répéter dans des cas rares**
8. **Correction du problème où cliquer rapidement sur différentes cartes de Tâche pouvait laisser le contenu d'une carte vide au retour sur la page**
9. **Ajustement de la logique de calcul automatique des pièces et Points d'Expérience**
10. **Correction de certains plantages**

**1.84.4 (2021/10/09)**

1. Correction du problème où l'icône intégrée pouvait ne pas s'afficher

2. Mise à jour du groupe Q

**1.84.3 (2021/10)**

1. Mise à jour des textes pour l'étranger

**1.84.2 (2021/09/26)**

1. Correction du blocage que pouvait provoquer la Synthèse

2. Correction du problème où les détails du produit affichaient des effets d'utilisation anormaux pour des produits indisponibles

3. Optimisation de l'effet visuel des coins arrondis des widgets

**1.84.1 (2021/09/20)**

1. Correction du problème où le nombre de répétitions cible ne pouvait pas être effacé lors de l'édition

**1.84.0 (2021/09/19)**

***Fonctionnalités***

1. Système de Compétences (personnalisation des Attributs)

   Tous les mécanismes d'origine sont adaptés au système de personnalisation des Attributs, comme les Attributs de Succès atteignant les conditions de déblocage, les Récompenses de Points d'Expérience des produits, etc.

2. Personnalisation de l'effet comestible du Pomodoro, permettant de modifier la valeur de Points d'Expérience et les types d'Attribut

3. L'icône de la Boutique prend en charge le changement de style de recadrage (paramètres de la Boutique)

4. Les détails du produit affichent désormais une liste d'effets d'utilisation

5. Ajout de la couleur de thème membre #6bab8b

6. Prise en charge de la suppression du compte calendrier de rappel

***Améliorations***

1. La page Pomodoro prend en charge l'affichage horizontal

2. Ajout de la description « Montant prêté » dans les paramètres du produit

3. Ajout d'un rappel de la taille de fichier de la synchronisation cloud

4. Mise à niveau des dépendances liées à Facebook et Dropbox

5. Optimisation partielle de l'interface et des textes de certaines pages

6. Optimisation de l'interaction lors de la création de sous-tâches

***Corrections***

1. Correction du problème où la version par défaut de l'icône d'Attribut était incohérente

2. Correction du problème où un clic rapide pour ouvrir la Boîte de butin pouvait provoquer des ouvertures répétées ou un plantage

3. Correction du problème où les événements de calendrier déjà rappelés n'étaient pas supprimés lors de la suppression d'Objets

4. Correction de l'état anormal après avoir passé un Objet de « Terminé » à « En retard » sur la page historique. Les données historiques devraient être réparées automatiquement lors de la mise à niveau vers la nouvelle version

5. Correction du problème où la liste sélectionnée était incorrectement marquée dans la boîte de dialogue de sélection de liste lors de la création d'un nouveau produit ; suppression de l'affichage de la liste « toutes »

6. Correction du problème où, en éditant d'autres contenus et les répétitions cibles, l'édition échouait à nouveau

7. Sur la page de nouveau Succès, correction du problème où la sélection d'Attribut ne pouvait pas être éditée et restait vide

8. Autres corrections mineures et optimisations

**1.83.16 (2021/08/20)**

1. Correction du plantage et de l'inefficacité de la modification d'avatar en mode hors ligne
2. Optimisation de l'interaction lors de la sélection de l'effet d'ouverture de produit
3. Correction du problème de focus de certains champs de texte longs
4. Correction du problème où l'échéance et l'heure du rappel s'affichaient incorrectement dans certains cas
5. Correction du problème où les changements de configuration du mode concis ne prenaient pas effet immédiatement

**1.83.15**

1. Prise en charge du marquage des Tâches de pénalité dans les widgets de l'App
2. Correction du comportement anormal de « plier les éléments hors sept jours »
3. La limite du nombre d'images d'Émotions a été portée à 9
4. La page de connexion affiche la dernière méthode de connexion
5. Lors de l'annulation de la pénalité (marquée comme terminée), aucune Récompense supplémentaire n'est accordée
6. La liste intelligente prend désormais en charge l'affichage des Objets terminés
7. Correction de la situation anormale de sauvegarde automatique dans le dossier « download » dans certains cas
8. Correction de certains problèmes d'affichage de l'interface

**1.83.14**

1. Correction du problème où Pomodoro pouvait ne pas enregistrer la durée lors de l'exécution de « ignorer »
2. Correction du problème où les Objets de pénalité exécutaient la logique de retard et de pénalité
3. Correction de problèmes liés à l'édition des pénalités
4. Correction de problèmes liés à la sélection d'images en mode paysage
5. Correction de l'échec occasionnel de restauration d'une sauvegarde depuis un chemin personnalisé

**1.83.8-1.83.13**
Fonctionnalités

1. Prise en charge du réglage indépendant de l'arrière-plan de carte
2. La fonction de suppression d'enregistrement prend désormais en charge la suppression des Émotions, entrepôts et enregistrements de minutage
3. Les Succès système peuvent choisir une Récompense en Points d'Expérience ou en pièces
4. Fonction de recherche d'événements
5. Prise en charge de la sauvegarde automatique locale dans le dossier « download » (Android 10 et supérieur)

Améliorations

1. Amélioration de la méthode d'appel par défaut des rappels par notification, ce qui peut théoriquement augmenter le taux de réussite au-dessus d'Android 6
2. Augmentation de la priorité de notification du minuteur Pomodoro à [Élevée], améliorant la survie du minuteur en arrière-plan et l'affichage des notifications
3. Sur la page, ajout des liens vers le groupe QQ et le site officiel, optimisation de l'interface ; QQ prend en charge l'adhésion au groupe en un clic
4. Amélioration du moment de déclenchement des notifications de Succès, qui devraient s'afficher immédiatement après activation sur la page d'accueil
5. Ajout de la case « Appliquer uniquement à la liste actuelle » dans l'option « Filtrer » de la liste d'Objets, séparant les options par défaut et toutes les listes
6. Ajout d'effets d'animation lors de la composition
7. Commentaires : ajout du canal de la communauté Rabbit Xiaochao, plus pratique pour téléverser des images et suivre les problèmes
8. Ajout de l'affichage de la valeur relative dans le champ de saisie des Objets de comptage
9. Optimisation de l'effet d'affichage des onglets non sélectionnés
10. Suppression de l'invite aléatoire lors du clic sur l'avatar ; clic pour entrer sur la page personnelle à la place
11. Lorsque la Récompense en pièces n'est pas définie, affichage « non défini » au lieu de « 0 »
12. Lorsque la probabilité d'ouverture de Boîte de butin est inférieure à 0,01 %, affichage « <0,01 % » au lieu de « 0,00 % »
13. L'interrupteur Émotions n'est plus mémorisé et est désactivé par défaut
14. Optimisation du processus de demande des permissions calendrier et caméra
15. Optimisation de l'effet au clic et de l'affichage de certaines pages
16. Optimisation de la méthode de rappel du calendrier, tentative de résolution du problème où certains appareils peuvent supprimer le compte calendrier

Corrections

1. Correction du plantage lors d'un filtrage continu sur la page Émotions
2. Tentative de correction du plantage rare de la boîte de dialogue configurée par défaut
3. Correction du problème où, avec un champ de saisie long, un clic sur le texte sautait automatiquement en bas
4. Correction du problème où les Récompenses aléatoires en pièces ne pouvaient pas être définies lors de la création d'une équipe
5. La version de distribution nationale supprime entièrement les dépendances liées à Firebase
6. Correction de l'exception occasionnelle lors de l'actualisation de la page de liste de Succès
7. Correction d'un plantage occasionnel lors de la sélection de l'icône intégrée
8. Correction du problème où les sous-tâches restaient visibles au retour sur la page de détails après les avoir toutes supprimées
9. Correction du problème où le nom de la liste par défaut de Synthèse ne pouvait pas être édité
10. Correction du problème où la boîte de filtre s'affichait sur la page de profil
11. Correction du problème où l'Objet d'équipe ne pouvait pas être hérité après définition de la Récompense produit

**1.83.7 (2021/06/24)**

1. Tri des listes par pièces ajoutées
2. Ajout de la sélection de langue sur la page de guide
3. Optimisation de la vitesse de chargement de la page Succès
4. Changement des informations du groupe QQ pour adhérer en un clic
5. Correction du problème où des clics continus pendant l'ouverture pouvaient déclencher plusieurs changements d'Inventaire
6. Correction de l'affichage incorrect des Objets en retard individuels dans la liste quotidienne d'Objets

**1.83.6 (2021/06/22)**

Fonctionnalités

1. (Membres) Prise en charge du réglage indépendant de l'arrière-plan de carte
2. La fonction de suppression d'enregistrement prend désormais en charge la suppression des Émotions, entrepôts et enregistrements de minutage
3. Les Succès système peuvent choisir une Récompense en Points d'Expérience ou en pièces
4. Fonction de recherche d'événements
5. Prise en charge de la sauvegarde automatique locale dans le dossier « download » (Android 10 et supérieur)

Optimisation

1. Amélioration de la méthode d'appel par défaut des rappels par notification, ce qui peut théoriquement augmenter le taux de réussite au-dessus d'Android 6
2. Augmentation de la priorité de notification du minuteur Pomodoro à [Élevée], améliorant la survie du minuteur en arrière-plan et l'affichage des notifications
3. Sur la page, ajout des liens vers le groupe QQ et le site officiel, optimisation de l'interface ; QQ prend en charge l'adhésion au groupe en un clic
4. Amélioration du moment de déclenchement des notifications de Succès, qui devraient s'afficher immédiatement après activation sur la page d'accueil
5. Ajout de la case « Appliquer uniquement à la liste actuelle » dans l'option « Filtrer » de la liste d'Objets, séparant les options par défaut et toutes les listes
6. Ajout d'effets d'animation lors de la composition
7. Commentaires : ajout du canal de la communauté Rabbit Xiaochao, plus pratique pour téléverser des images et suivre les problèmes
8. Ajout de l'affichage de la valeur relative dans le champ de saisie des Objets de comptage
9. Optimisation de l'effet d'affichage des onglets non sélectionnés
10. Suppression de l'invite aléatoire lors du clic sur l'avatar ; clic pour entrer sur la page personnelle à la place
11. Lorsque la Récompense en pièces n'est pas définie, affichage « non défini » au lieu de « 0 »
12. Lorsque la probabilité d'ouverture de Boîte de butin est inférieure à 0,01 %, affichage « <0,01 % » au lieu de « 0,00 % »

**1.83.0-alpha04 (2021/05/23)**

1. Prise en charge de la configuration libre, du tri et de la désactivation du module inférieur
   Les modules devront être adaptés progressivement ; seuls certains modules fonctionnels sont pris en charge pour l'instant (comme Pomodoro ; historique non adapté)
2. Ajout d'un second mode de pause à l'effet de compte à rebours du produit, qui reste dans la barre de notifications et peut être repris à tout moment
    Et ajout du logo « experimental »
3. Lors du choix d'ignorer le Pomodoro, ajout d'un rappel indiquant qu'aucun Pomodoro ne peut être obtenu
4. Ajout d'une indication pour développer et réduire la Tâche d'exemple
5. Correction du plantage que pouvait provoquer la disposition en haut de la liste sur certaines pages
6. Optimisation du message d'erreur réseau lorsque la connexion est interrompue
7. Optimisation du rappel de Récompense en pièces lors de la finalisation des sous-tâches, remplacé par un Toast non intrusif

**1.83.0-alpha03 (2021/05)**

1. Correction du problème où la disposition vide de la page de composition pouvait dépasser l'écran
2. Correction du problème où le nom de l'Attribut « Charme » s'affichait incorrectement sur la page de création
3. Correction de certains problèmes de paramètres de pièces
4. Optimisation de l'effet d'animation de la page Succès pour s'adapter au scénario de la barre de navigation inférieure
    (Adapté mais l'interface n'est pas encore prête ; attendez les mises à jour suivantes)
5. Mise à niveau de la version SDK cible vers Android 11
6. Correction du problème d'affichage vide de la page « Moment »
7. Correction du problème de calcul anormal des intérêts

**1.83.0-alpha02 (2021/05/16)**

1. Correction du problème où des recettes de Synthèse pouvaient être créées dans la liste « Toutes »
2. Après entrée dans l'interface du système de Synthèse, quel que soit la liste active, le contenu affiché est la liste « Toutes ».
3. Réparation simple de la méthode de calcul des intérêts ATM

**1.83.0-alpha01 (2021/05/16)**

1. Système de Synthèse complet, avec prise en charge de toute implémentation N-à-N
   - Liste de contrôle
   - Créer/Éditer
   - Boîte de dialogue de Synthèse
   - Mode nuit et prise en charge multilingue
   - L'« entrée » se trouve en haut de la page Boutique
2. Refactorisation du code interne de la page de nouvel Objet
    Pour la scalabilité de l'App, nous avons presque entièrement réorganisé le code de création d'Objets et pourrions aussi redesigner l'interface à l'avenir.
    Les mises à jour alpha suivantes ajouteront aussi « date de répétition cible », « heure de rappel relative », « Objets de type pénalité (à déterminer) » et d'autres fonctions.
    En cas de problème, vous pouvez revenir à l'ancienne version de la page à tout moment.

3. Ajout de l'entrée ATM en haut de la Boutique
4. Les pièces jointes d'Objet prennent en charge jusqu'à 9 images ; le chemin de stockage a été ajusté
5. Fonction TAG d'équipe
    L'implémentation est intégrée, mais le contenu TAG précis n'est pas encore configuré, donc non affiché pour l'instant

**1.82.16 (2021/05)**

1. Correction du problème où les Objets d'exemple n'exécutaient pas correctement la logique de retard (valable uniquement pour les nouveaux utilisateurs)
2. Correction du problème où le nombre de finalisations d'Objets illimités pouvait manquer 1 fois dans certains scénarios

**1.82.15 (2021/05)**

1. Correction du problème de lecture des effets sonores en arrière-plan

**1.82.14 (2021/05)**

-

**1.82.13 (2021/05)**

1. Correction du problème où les Objets illimités pouvaient ralentir le chargement de la liste et rendre le décompte d'annulations imprécis
2. Correction du problème où la finalisation de la Tâche dans le widget de bureau pouvait jouer plusieurs fois l'effet sonore de finalisation
3. Correction du problème où le décompte total des Objets en tête de la liste intelligente n'était pas précis
4. Prise en charge de la suppression de toutes les données locales et de la suppression de compte
5. Correction du problème où l'édition des sous-tâches d'Objets d'équipe ne pouvait pas être héritée

**1.82.12 (2021/05)**

1. Correction du problème de comptage lors de l'annulation de finalisation d'Objets illimités
2. Correction du problème où les Objets gelés étaient encore rappelés
3. Optimisations du changement de liste, ce qui peut augmenter la vitesse sur les anciens appareils et ajouter des animations de chargement
4. Correction du problème où l'effet sonore personnalisé de fin de repos ne prenait pas effet ; prise en charge du réglage de l'effet de fin de minutage produit
5. Correction du problème où Pomodoro ne comptabilisait pas le temps de Concentration lors de l'opération « ignorer »
6. Correction du problème où le bouton pause du compte à rebours produit ne prenait pas effet

**1.82.11 (2021/05)**

1. Correction du problème de comptage lors de l'annulation de finalisation d'Objets illimités
2. Correction du problème où les Objets gelés étaient encore rappelés
3. Optimisations du changement de liste, ce qui peut augmenter la vitesse sur les anciens appareils et ajouter des animations de chargement
4. Correction du problème où l'effet sonore personnalisé de fin de repos ne prenait pas effet ; prise en charge du réglage de l'effet de fin de minutage produit
5. Prise en charge de la langue russe

**1.82.10 (2021/05)**

1. Correction du problème où Pomodoro ne comptabilisait pas le temps de Concentration lors de l'opération « ignorer »
2. Correction du problème où le bouton pause du compte à rebours produit ne prenait pas effet
3. Capture d'un plantage provoqué par l'échec de création d'un rappel calendrier

**1.82.9 (2021/05)**

1. Correction du problème où la limite de temps de l'Objet copié pouvait être vidée et provoquer un plantage en cas de répétition
2. Optimisation de la vitesse d'actualisation après finalisation d'Objets illimités
2. Correction du problème de calcul de l'heure de rappel pour les Tâches d'équipe
3. Correction du problème où la finalisation par glissement pouvait laisser l'animation inachevée et l'écran vide
4. Les Tâches d'équipe prennent en charge l'abandon par glissement
5. La présentation du produit dans la fenêtre d'achat prend en charge le défilement

**1.82.8 (2021/04/28)**

**fonctionnalités**

1. Ajout de l'affichage de la série de finalisations en cours
2. Optimisation de l'effet de compte à rebours des Objets de la Boutique, avec ajout des opérations terminer et mettre en pause ; calcul en temps absolu en cas d'arrêt anormal
3. Prise en charge du réglage séparé du mode vibration et de l'interrupteur de sonnerie du Pomodoro
4. Prise en charge partielle de l'aperçu des échéances futures des événements en cours dans le calendrier
5. Prise en charge du redémarrage des événements uniques et illimités
6. Modification de l'affichage des données sur la page « Moi » : « En retard » et « Abandonner » deviennent « Succès (débloqué) » et « Émotions » ; la page statistiques affiche désormais le nombre d'« En retard » et « Abandonnés »
7. Prise en charge de la demande directe de création de widgets depuis la page de paramètres « widgets de bureau » (Android 8 ou supérieur uniquement)

**améliorations**

1. Prise en charge de l'affichage en grand des images d'Objets de la Boutique
2. Optimisation de la consommation d'énergie que pouvait provoquer le comptage de pas
3. Correction de certains problèmes d'affichage lorsque la police est trop grande
4. Optimisation de l'annulation des Objets illimités
5. Optimisation de l'affichage des notifications Pomodoro et ajout d'une barre de progression
6. Après finalisation de l'événement, suppression du rappel de notification actuellement affiché
7. Optimisation des statistiques de revenus et dépenses de pièces
8. Ajout de guides et conseils utilisateur
9. Lors de l'édition d'Objets, prise en charge de l'effacement de la sélection de Récompense produit
10. Lors de plantages continus, ajout d'un avis « Problèmes connus »
11. Optimisation de l'effet d'affichage lorsqu'aucun Attribut n'est sélectionné

【corrections】

1. Après tri de la liste sur la page d'accueil, l'état devrait être actualisé immédiatement
2. Correction du problème où la page de détails n'actualisait pas immédiatement la liste de sous-tâches
3. Correction forcée du plantage de la connexion autorisée Weibo
4. Correction du problème où le nom de l'Objet affiché dans la notification Pomodoro pouvait être incorrect
5. Correction du problème où le compte à rebours de la notification Pomodoro était imprécis
6. Correction du problème où la boîte de Récompense ne s'affichait pas lorsque l'Objet et le Succès n'avaient que des Récompenses marchandise
7. Correction du problème où l'achat à 0 pièce n'était pas possible dans certaines circonstances
8. Optimisation de la méthode de calcul de réparation des Objets Ebbinghaus
9. Optimisation de la méthode de calcul du nombre de finalisations du jour pour les événements illimités

**1.82.7 (2021/04/10)**

1. Correction de l'affichage de l'interface avec données vides sur l'écran [Moments]
2. La taille de police suit à nouveau les paramètres système
3. Mise à jour des traductions anglaise et portugaise

**1.82.5 (2021/04/02)**

1. Correction de certains problèmes d'enregistrement Pomodoro
2. Ajout de nouveaux guides

**1.82.4-alpha01/beta (2021/03/25)**

1. Correction des Récompenses de Boîtes de butin
2. Affichage des Émotions des Tâches sélectionnées
3. Récompenses de Points d'Expérience/pièces aléatoires pour Succès personnalisés
4. Les Tâches de la liste intelligente sont désormais regroupées par liste
5. Répétition annuelle
6. Plus d'améliorations et corrections de bugs

**1.82.1 (2021/03/12)**

1. Correction de certains problèmes de listes intelligentes
2. Correction du problème où la barre de progression pouvait ne pas changer après finalisation d'une Tâche
3. Correction d'un problème lors de la finalisation forcée d'une Tâche de comptage
4. Correction du problème où « NULL » s'affichait dans la boîte de dialogue inférieure de retard

**1.82.0 (2021/03/11)**

1. Listes intelligentes
2. Redesign des icônes d'Attributs
3. Nouvel effet d'Objet « Compte à rebours »
4. Le minuteur Pomodoro continue d'enregistrer le temps supplémentaire après la fin du minuteur ; vous pouvez choisir de mettre à jour le temps de Concentration et obtenir une Récompense supplémentaire.
5. Les Tâches de comptage peuvent désormais être finalisées de force sans atteindre le nombre cible.
6. Vous pouvez désormais choisir de finaliser des Tâches non démarrées et décider de reporter l'heure
7. Plus de corrections et améliorations

**1.81.6**

1. Correction de problèmes d'invite de rappel Pomodoro

**1.81.5 (2021/03/02)**

1. Traduction italienne (partielle)
2. Correction de l'icône de notification
3. Correction du rappel qui ne fonctionnait pas bien avec la répétition en semaine
4. Correction de la sélection « prendre une photo » qui ne fonctionnait pas
5. Autres corrections mineures

**1.81.0~1.81.4**

1. Refonte de partie de l'interface et des animations
2. La Tâche se termine automatiquement lorsque toutes ses sous-tâches sont terminées
3. Correction d'un bug de changement multiple de Points d'Expérience
4. Correction d'un bug de restauration Dropbox
5. Vous pouvez désormais retourner un Objet sans recevoir de pièces
6. Paramètre d'affichage en format 12 heures
7. Geler/Dégeler plusieurs Tâches

**1.80.7（2021/01/26)**

1. Ajout de statistiques d'Objets de la Boutique
2. Refonte de la boîte de dialogue de description des Attributs
3. Description personnalisée des Attributs
4. Ajout d'un paramètre de mode compact : masquer toutes les informations supplémentaires
5. Correction d'un bug de restauration depuis un fichier de sauvegarde
6. Plus de corrections et améliorations...

**1.80.6（2021/01/22)**

1. Les Objets avec effet de Boîte de butin peuvent désormais être partagés sur le marché
2. Nouvelle page de recherche : recherche d'utilisateurs par pseudonyme
3. Filtrer les Objets d'équipe/marché par plage horaire
4. Notification d'ajout rapide de Tâches
5. Les fichiers média peuvent être ignorés lors de la sauvegarde.
6. Plus de corrections et améliorations...

**1.80.5（2021/01/14)**

1. Ouvrir 10/50 Boîtes de butin en un clic
2. Ajout de la condition de déblocage [Obtenir l'Objet sélectionné un nombre déterminé de fois depuis les Boîtes de butin]
3. Paramètres de taux d'intérêt ATM
4. Saisie du nombre pour vendre/manger des tomates
5. Effet sonore personnalisé de fin du minuteur de repos
6. Ajout de guides utilisateur
7. Correction de certains problèmes et améliorations

**1.80.4（2021/01/04)**

1. Correction d'un plantage sur Android 6

**1.80.3（2021/01/04)**

1. Recadrage d'image libre
2. Voir/Ajouter l'icône des Objets sur le marché
3. Lors de la sélection Tâche/Objet, création directe d'un nouvel élément
4. Prise en charge de l'action COPIER pour les Succès utilisateur
5. Nombreuses corrections et améliorations

**1.80.0（2020/12/24)**

1. Effet Boîte de butin pour les Objets de la Boutique !
2. Intégration de la sauvegarde Dropbox
3. Configurations du mode compact
4. Ajout d'une barre d'historique de sélection de photos
5. Nombreuses corrections et améliorations

**1.79.x（2020/12)**

1. 3 paramètres de conditions de déblocage supplémentaires
2. Paramètres d'effets sonores personnalisés
3. Définir une Récompense d'Objet pour les Succès
4. Page d'enregistrement du minuteur Pomodoro
5. Créer une Tâche depuis la page Calendrier
6. 5 nouvelles couleurs de thème.
7. Nombreuses améliorations et corrections

**1.78.x（2020/11)**

1. Condition de déblocage de Succès personnalisés
2. Points d'Expérience personnalisés de Tâche
3. Nombreuses améliorations et corrections

**1.77.1（2020/11/05)**

1. Barre d'outils de changement de liste
2. Interrupteur d'affichage des Tâches terminées
3. Les listes peuvent désormais être archivées
4. Ajout d'une carte d'état des pièces
5. Vous pouvez désormais créer des Émotions pour les Succès utilisateur
6. Ajout d'un paramètre pour suivre le mode nuit du système

**1.77.0（2020/10/28)**

1. Ajout du module Marché pour la communauté, où vous pouvez partager des designs d'Objets de la Boutique ou importer des Objets
2. Correction de la logique de répétition mensuelle
3. Correction de la sauvegarde automatique WebDAV lorsqu'aucune sauvegarde n'avait encore été effectuée

**1.76.0（2020/10/13)**

1. Pièces par défaut des sous-tâches
2. Ajout d'icônes dans l'App pour créer des Objets de la Boutique et des Succès
3. Prix personnalisé des tomates
4. Paramètres globaux d'activation des effets sonores
5. Les Émotions peuvent désormais être recherchées par contenu de Tâche

**1.75.2（Released at 2020/10/05）**

1. Paramètre du nombre de pièces par défaut des sous-tâches
2. Plus de 100 icônes sélectionnables comme icônes d'Objets de la Boutique/Succès
3. Ajout du paramètre « Activer l'effet sonore »
4. Filtrer les Émotions par contenu de Tâche et meilleure interface des filtres
5. Créer des raccourcis Pomodoro
6. Prix de vente personnalisés des tomates
7. La page Pomodoro maintient l'écran allumé pendant le compte à rebours
8. Correction de certains problèmes

**1.75.1（Released at 2020/09/20）**

1. Correction de nombreux bugs de la 1.75.0

**1.75.0（Released at 2020/09/16）**

1. Pomodoro gamifié
2. Couleur personnalisée des étiquettes Tâche/liste
3. Sauvegarde automatique WebDAV
4. Paramètres de masquage des modules
5. Nombreuses améliorations et corrections

**1.74.2（Released at 2020/08/23）**

1. Langue portugaise

**1.74.0（Released at 2020/08/13）**

1. ATM : dépôt et retrait de pièces
2. Prise en charge de la sélection d'Objets de la Boutique comme Récompense de Tâche
3. Paramètre de quantité en stock des Objets de la Boutique
4. Amélioration des animations et correction de certains bugs
5. Ajout d'une indication pour le paramètre de fréquence de répétition
6. Plus... (description à mettre à jour ultérieurement)

**1.73.0（Released at 2020/07/26）**

**Fonctionnalités :**

- Succès utilisateur
- Animation de diminution de Points d'Expérience
- Édition de l'heure de finalisation de l'enregistrement historique
- Paramètre de pièces des sous-tâches d'équipe

**Amélioration :**

- Ajout d'un effet sonore de pièces

**Correction :**

- Problème de perte du paramètre de pièces des sous-tâches après répétition d'une Tâche

**1.72.1（Released at 2020/06/14）**

**Fonctionnalités :**

- Effacer les données de Succès

**Amélioration :**

- Meilleur affichage de la description des Objets de la Boutique

**Correction :**

- Problème d'édition des images d'Objets de la Boutique
- Problème d'édition du texte des Émotions

**1.72.0（Released at 2020/06/11）**

**Fonctionnalités :**

- Rappel de sous-tâche
- Pièces de sous-tâche
- Widget de l'App
  1. Paramètre d'opacité
  2. Affichage du nombre de pièces
  3. Affichage de la boîte de dialogue de saisie de Tâche de comptage
- Sélection de période sur la page statistiques
- Inventaire : retourner un Objet
- Prise en charge des sous-tâches pour les équipes

**Amélioration :**

- Glisser une Tâche de comptage ajoute désormais 1 finalisation au lieu de la marquer comme terminée
- Ajout du bouton Aider à traduire
- Ajout du paramètre de Récompense multiple de Points d'Expérience pour les Tâches de comptage

**Correction :**

- Correction : la partie transparente des images PNG apparaissait noire après recadrage.
- Correction : le widget de l'App ne fonctionnait pas bien sur certains appareils.
- Correction : le nombre de pièces s'affichait sur la page de détails lorsqu'il était à 0.
- Correction : Glisser pour terminer (sans boîte de dialogue) affichait incorrectement la page
- Correction : impossible de créer une sous-tâche en appuyant sur ENTREE sur certains appareils

**1.71.3/1.71.4（Released at 2020/04/16）**

**Corrections mineures concernant l'icône et le rapport de plantage**

**1.71.2（Released at 2020/04/14）**

**Fonctionnalités :**

- Langue turque (merci à **İbrahim DOĞAN** pour l'aide à la traduction)

- Personnalisation de l'arrière-plan et de l'opacité de la carte de Tâche
- Personnalisation du texte du bouton d'action d'Objet de l'Inventaire
- Émotions favorites
- Recherche d'Émotions

**Amélioration :**

- Nouvelle icône

- Le type de signalement prend en charge plusieurs langues
- Amélioration de l'interface de la page Paramètres
- Amélioration de la méthode de changement de couleur de thème et de langue. Plus besoin de redémarrer l'App.
- Amélioration de la page de recadrage d'image
- Amélioration de l'interface de sélection de liste
- Ajout de la description d'Objet de la Boutique sur la page de liste de la Boutique

**Corrections :**

- Correction du bug d'affichage incorrect de la date de déblocage du Succès
- Correction du bug où l'image d'Objet de la Boutique apparaissait vide si le fichier était supprimé.
- L'état des sous-tâches n'était pas effacé après qu'une Tâche unique était en retard.
- Correction du bug de manque d'espace pour afficher le degré de difficulté sur la page de détails de Tâche.
- Correction du bug où, après avoir marqué une Tâche en retard comme terminée, le nombre de finalisations de la Tâche suivante n'augmentait pas de un.
- Correction du bug d'affichage incorrect du nombre maximum de pièces dans les paramètres par défaut de Tâche.
- La page de sauvegarde/restauration de données est désormais défilable.
- Correction : glisser pour terminer une Tâche ne fonctionnait pas bien lors de glissements rapides sur plusieurs Tâches.
- Les widgets de l'App affichent désormais l'état Gelé
- Correction du bug où la barre de progression de la page Tâche affichait parfois une progression incorrecte

**Corrections serveur（2020/4/13）**

- Correction de la fonction de signalement qui ne fonctionnait pas

**v1.71.1 (Released at 2020/03/17)**

**Amélioration :**

- Meilleure animation de la barre de progression sur la page Tâche

**Corrections :**

- Correction d'un bug pouvant provoquer un plantage au lancement de l'App sur certains appareils
- Correction d'un bug lors de la sélection de photos

<!-- more -->

**v1.71.0 (Released at 2020/03/13)**

**Fonctionnalités :**

- Fonction Émotions

- Ajout de l'action au glissement : Terminer la Tâche (sans boîte de dialogue)

**Corrections :**

- Correction du bug d'affichage incorrect de l'état de la carte de Tâche

- Correction du bug où une Tâche annulée pouvait disparaître en cas de retard

- Correction de l'affichage incorrect du tri sélectionné

**v1.70.6 (Released at 2020/03/09)**

**Amélioration :**

- Les couleurs de l'invite de Succès débloqué correspondent à la couleur de thème

**Corrections :**

- Correction de l'affichage incorrect de l'état de la boîte de dialogue de retard après clic sur le bouton

- Correction d'un bug où COPIER ne copiait pas les sous-tâches
- Correction d'un plantage lors de l'utilisation de « Déplacer vers... »
- Correction de l'affichage incorrect de la carte de sélection sur certains appareils

**v1.70.5 (Released at 2020/03/06)**

**Corrections :**

- La carte To-Do reste en chargement lors du changement de couleur de thème ou de l'activation/désactivation du mode nuit

**v1.70.4 (Released at 2020/03/05)**

**Améliorations :**

- La page Boutique affiche le nombre de pièces lorsqu'il n'y a pas d'Objets
- Accès à la page de détail des pièces en cliquant sur le nombre de pièces dans la page Boutique
- Amélioration du format de texte du widget de l'App en anglais
- Accès à la page de détails de Tâche en cliquant sur la Tâche dans le widget de l'App

**Corrections :**

- Style d'affichage incorrect de l'activité d'équipe

**v1.70.3 (Released at 2020/03/05)**

**Améliorations :**

- La page Boutique affiche désormais le nombre de pièces lorsqu'il n'y a pas d'Objets
- Cliquer sur le nombre de pièces dans la page Boutique ouvre la page de détail des pièces
- Amélioration du format de texte anglais du widget de l'App
- Cliquer sur un élément du widget de l'App ouvre la page de détails de Tâche

**Corrections :**

- Correction : lors du filtre Aujourd'hui, l'indication de pied de page « xx tâche(s) pas encore démarrée(s) » ne s'affichait pas après finalisation de la Tâche

**v1.70.3 (Released at 2020/03/05)**

**Corrections importantes :**

- Correction de bugs de saisie du nombre de pièces
- Correction de bugs où les sous-tâches ne s'actualisaient pas correctement
- Correction de bugs empêchant d'aimer l'activité d'autres utilisateurs
- Correction de bugs empêchant le widget de l'App de finaliser des Tâches

**v1.70.2 (Released at 2020/03/04)**

**Fonctionnalités :**

- La communauté est désormais disponible pour tous les fuseaux horaires

- Copier des Tâches
- Prise en charge de l'édition des paramètres par défaut des nouvelles Tâches
- Liste de la Boutique

- Amélioration des actions du widget de l'App
- Ajout d'un menu pour les Tâches terminées sur la page Calendrier

**Améliorations :**

- Amélioration des animations de la carte de Tâche

- Suppression d'une permission inutile
- Ajout d'un son de finalisation
- Amélioration du style de l'interface de la page historique
- Ajout de la boîte de dialogue « Permission d'écriture/lecture du calendrier perdue » lors de l'activation du rappel calendrier système sans permissions accordées

**Corrections :**

- Correction de bugs concernant les Tâches de comptage en mode compact
- Correction de bugs concernant les Tâches répétées
- Correction d'un plantage pouvant survenir lors de la suppression de sous-tâches
- Correction d'un plantage lors de la saisie d'une URL WebDAV incorrecte
- Correction de l'affichage incorrect de la couleur de thème, pouvant survenir après restauration d'une sauvegarde

### **LifeUp-Desktop**

**v1.2.0 (2025/01/01)**

**✨ Fonctionnalités**

1. **Prise en charge de la gestion des archives**

- Sauvegarde sur ordinateur
- Restauration depuis l'ordinateur
- Prise en charge du glisser-déposer

2. **Prise en charge de la création de nouvelles Réflexions**

- Prise en charge de la sélection d'images
- Prise en charge de la synchronisation d'images vers le mobile

3. **Prise en charge de l'affichage des détails de Tâche**
4. **Améliorations du système d'achat**

- Utilisation de la nouvelle API « Purchase Items »
- Maintien des limites d'achat cohérentes avec l'App

5. **Prise en charge de la validation optionnelle d'API Token**
6. **Prise en charge multiplateforme**

- Windows
- Linux
- macOS (Apple Silicon)
- macOS (Intel) 🆕

7. **Amélioration de la gestion des erreurs et des notifications**

**v1.1.1 (2023/08/29)**

**🔧 Optimisation et corrections**

1. **Correction d'un comportement inattendu lors de la saisie de pièces**
2. **Correction du problème où la recherche de mises à jour pouvait provoquer un plantage de l'App**

**v1.1.0 (2023/06/25)**

**✨ Fonctionnalités**

1. **Prise en charge de la vérification automatique de l'adresse IP et de la connexion de « LifeUp Cloud »** (nécessite LifeUp Cloud v1.3.0)
2. **Prise en charge de l'ajout de Tâches**, mais les options actuellement prises en charge sont limitées (Corrigé [#6](https://github.com/Ayagikei/LifeUp-Desktop/issues/6))
3. **Prise en charge de l'export des Réflexions au format markdown** (Corrigé [#5](https://github.com/Ayagikei/LifeUp-Desktop/issues/5))
4. **Ajout du texte en chinois traditionnel**
5. **Ajout d'une version de publication macOS**
6. **Prise en charge de la recherche de mises à jour**

**🔧 Optimisation et corrections**

1. **Correction du problème où les sous-catégories de Succès ne s'affichaient pas correctement**
2. **Correction du problème où certaines icônes ne s'affichaient pas correctement** (nécessite LifeUp v1.91.3)
3. **Correction du problème de discordance de titre** (Corrigé [#8](https://github.com/Ayagikei/LifeUp-Desktop/issues/8))
4. **Ajout d'une option de raccourcis pour l'installateur Windows** (Corrigé [#13](https://github.com/Ayagikei/LifeUp-Desktop/issues/13))
5. **Amélioration de la méthode d'obtention de la taille de fenêtre**, adaptée aux résolutions inférieures à 1080p

**v1.0.2 (2023/02/20)**

1. **Ajout d'une fenêtre contextuelle de rapport d'erreur plus détaillée** [#2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)
2. **Amélioration de la configuration d'empaquetage**

**v1.0.1 (2023/02/12)**

1. **Première version**

### **LifeUp Cloud**

**v2.1.1 (2026/06/16)**

**✨ Fonctionnalités**

1. **Exposition de l'heure de finalisation des sous-tâches (`endTime`)** dans le modèle de données du SDK et les réponses de l'API HTTP.

**v2.1.0 (2026/03/22)**

**✨ Fonctionnalités**

1. **Ajout de la prise en charge de la configuration des locales et des mises à jour de localisation Top-14.**
2. **Exposition des champs de progression de comptage et de condition de fin de répétition pour les Tâches API.**

**🐛 Corrections**

1. **Correction des problèmes de compatibilité ContentProvider.**
2. **Adaptation de l'interface Android 15 et du comportement de démarrage du service.**

**v2.0.0 (2025/01/01)**

**✨ Fonctionnalités**

1. **Optimisation du service**

- Logique de découverte de service et compatibilité renforcées
- Prise en charge de la détection automatique d'IP sur davantage d'appareils
- Transitions d'état démarrage/pause du service optimisées
- Amélioration de la gestion des erreurs et des notifications

2. **Sécurité et performances**

- Ajout de la validation optionnelle d'API Token
- Ajout d'options de configuration CORS
- Prise en charge des paramètres de port personnalisés
- Prise en charge d'une durée de wake lock personnalisée

3. **Amélioration de l'interface**

- Toute nouvelle conception d'interface
- Amélioration de l'expérience visuelle globale

**v1.3.0 (2023/06/25)**

**✨ Fonctionnalités**

1. **Prise en charge de l'enregistrement du service mDNS** pour permettre au bureau de découvrir automatiquement son IP (nécessite le bureau v1.1.0)
2. **Ajout de valeurs de résultat pour les API invoquées via ContentProvider.**

**🔧 Améliorations**

1. **Élargissement de la zone cliquable du bouton de scan de code QR**
2. **Correction du plantage ActivityNotFound**

**v1.2.0 (2023/03/10)**

1. **Prise en charge du scan de code QR pour invoquer l'API**
2. **Amélioration de l'affichage de la liste d'IP**

**v1.1.2 (2023/02/12)**

1. **Prise en charge de l'interrogation de données complètes via Content Provider**, utilisée pour les fonctions du bureau
2. **Standardisation du contenu des réponses HTTP**

**v1.0.3-preview (2022/11/22)**

1. **Première version** (plus quelques corrections de la première version)

<!-- tabs:end -->

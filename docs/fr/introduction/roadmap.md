# Feuille de route de développement

Comme *LifeUp* est actuellement maintenu sur le temps libre et avec des ressources limitées, nous ne garantissons pas que le plan de développement puisse être exécuté avec précision, et nous ne promettons pas de date de lancement spécifique.

<br/>

## Stratégie de mise à jour

Le cycle de mise à jour des fonctionnalités locales restera entre 14 et 21 jours.

Et après chaque mise à jour de fonctionnalité, nous pouvons publier plusieurs correctifs.

Comme la fonction du module « Monde » implique plusieurs facteurs tels que le développement conjoint sur deux plateformes, la synchronisation des exigences, le déploiement serveur, les limitations de performance serveur et la compatibilité.

Le cycle de développement sera plus long que pour les fonctionnalités locales et consistera principalement en maintenance plutôt qu'en introduction de nouvelles fonctionnalités.



**Priorité des mises à jour (approximative) :**

Corrections de crash >> Corrections de bugs d'expérience affectant les nouveaux utilisateurs >> Mises à jour de fonctionnalités > Corrections de bugs UI et de détails.

<br/>

## Stratégie de numérotation des versions

Utilisation d'un numéro de version à trois chiffres, par exemple `1.80.3`.

**Le premier** (par exemple **1**.80.3) est le numéro de version utilisé pour une révision majeure de l'application, et 1 est la version officielle initiale. Il y aura beaucoup de refactorisation de code / refonte UI si cela apporte des améliorations.


**Le chiffre du milieu** (par exemple 1.**80**.3) est le numéro de version de fonctionnalité (feature). Le numéro de version augmente lorsqu'une fonctionnalité de niveau moyen est publiée ou lorsqu'un nombre relativement important de petites fonctionnalités s'accumule.

Par exemple :

> La version 64 a lancé le système Boutique & Magasin & Entrepôt.
>
> La version 70 a lancé le Mode simple.
>
> La version 80 a lancé le système de déballage.



**Le troisième chiffre** (par exemple 1.80.**3**) est le numéro de révision pour corriger certains problèmes / crashs à chaque publication de fonctionnalité. Il peut aussi apporter quelques petites fonctionnalités.


> L'ancienne version utilisait aussi un numéro de version à trois chiffres représenté par des lettres anglaises, comme 1.58c.
>
> La stratégie de base est la même qu'au-dessus, sauf que la troisième section devient une lettre anglaise et commence à `a`.
>
> Cependant, comme certains marchés d'applications ne prennent pas en charge cette stratégie de numérotation, elle est désormais abandonnée.

<br/>

Consultez le [Plan de développement 2026-2027](introduction/development_plan_2026_2027.md) pour notre feuille de route actuelle.

Consultez le [Plan de développement 2024-2025](introduction/development_plan_2024.md) pour la feuille de route précédente.

Consultez le [Plan de développement 2022/10 - 2023/12](introduction/development_plan_2023.md) pour les archives historiques.

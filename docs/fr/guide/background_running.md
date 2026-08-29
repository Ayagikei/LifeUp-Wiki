# Maintenir LifeUp en arrière-plan

## Pourquoi c'est nécessaire

Certains fabricants de téléphones restreignent agressivement les apps en arrière-plan pour améliorer les résultats de benchmark batterie. En conséquence, les fonctionnalités qui reposent sur l'exécution en arrière-plan peuvent échouer.

### Matrice d'impact sur la compatibilité

| Fonctionnalité | Nécessite le maintien en arrière-plan ? | Permissions supplémentaires | Notes |
| --- | --- | --- | --- |
| Rappel de Tâche (notification système) | ✔️ | Permission de notification | C'est la méthode de rappel par défaut. Si les rappels sont retardés ou absents, configurez le maintien en arrière-plan et assurez-vous que les notifications sont activées pour LifeUp. |
| Rappel de Tâche (événement calendrier) | ✖️ | Permission de lecture/écriture du calendrier | Vous pouvez basculer vers ce mode dans `Paramètres` → `Tâches` → `Changer le système de rappel`. |
| Rappel de fin de Pomodoro | ✔️ | - | Si le maintien en arrière-plan n'est pas configuré, les rappels peuvent être manqués, et le compte à rebours peut se mettre en pause ou se figer en arrière-plan. |
| Minuteur chronomètre | ✖️ | - | - |
| Actualisation auto du widget App | Généralement oui (selon appareil/OS) | - | Sans maintien en arrière-plan correct, les widgets peuvent rester sur « Chargement » ou afficher des états obsolètes comme « Toutes les tâches terminées ». |
| Action widget : terminer tâche de comptage / ouvrir détail tâche (hors MIUI) | ✖️ | - | - |
| Action widget : terminer tâche de comptage / ouvrir détail tâche (MIUI) | Variable | Peut nécessiter la permission MIUI popup/affichage en arrière-plan | MIUI peut bloquer les actions UI déclenchées par le widget en arrière-plan. |

- Certains systèmes gèlent ou arrêtent les tâches en arrière-plan lorsque l'écran est éteint.
- Les widgets peuvent se comporter différemment selon les launchers et variantes d'OS.
- Si vous ne vous intéressez qu'aux rappels, vous pouvez basculer vers les rappels calendrier pour réduire la dépendance à l'arrière-plan.

## Comment configurer

> [!WARNING]
> Ces paramètres peuvent légèrement augmenter la consommation de batterie.

D'après nos tests sur un OnePlus 8T, 24 heures d'utilisation en arrière-plan ont consommé environ **30 mAh**. Pour la plupart des utilisateurs, l'impact est faible.

LifeUp n'effectue que des opérations passives limitées en arrière-plan, comme les rappels, les mises à jour de widgets et le chronométrage Pomodoro.

---

### Étapes de configuration courantes

#### Paramètres généraux

> Vous n'avez pas besoin de terminer chaque étape. Chaque étape peut améliorer la priorité et la stabilité en arrière-plan.

**Paramètres système Android**

1. Dans LifeUp, ouvrez `Barre latérale` → `Paramètres` → `Problèmes de compatibilité`, puis appuyez sur `Accéder aux paramètres d'optimisation batterie`. Trouvez LifeUp et réglez sur **Ne pas optimiser**.

   a. Sur certains appareils, LifeUp peut ne pas apparaître après ce saut. Dans ce cas, ignorez cette étape.

2. Si vous avez besoin de rappels, assurez-vous que la permission de notification est accordée à LifeUp.

3. (Optionnel) Dans les paramètres de Tâches, activez `Notification d'ajout rapide`.

<br/>

**Gestionnaire d'arrière-plan du fabricant (Phone Manager)**

De nombreux fabricants ajoutent des restrictions d'arrière-plan supplémentaires. Si vous n'êtes pas sur un appareil type Pixel/AOSP, une configuration supplémentaire est généralement nécessaire.

1. Verrouillez LifeUp dans l'écran multitâche / applications récentes du système.

2. Dans la gestion des apps système / gestion batterie / phone manager, autorisez LifeUp à s'exécuter en arrière-plan (sans restrictions) et à démarrer automatiquement.

   a. Pour les guides spécifiques au fabricant, voir [dontkillmyapp.com](https://dontkillmyapp.com/).

3. Lors de l'utilisation des fonctionnalités LifeUp, évitez les modes agressifs comme l'économie d'énergie extrême ou les politiques « ne pas déranger » strictes, ou ajoutez LifeUp aux listes d'autorisation correspondantes.

<br/>

**Toujours pas de résultat ?**

D'après les retours utilisateurs et nos tests, LifeUp fonctionne normalement sur les appareils grand public après une configuration correcte. Cependant, les mises à jour système peuvent déplacer ou renommer les paramètres.

1. Revérifiez toutes les étapes ci-dessus et complétez les paramètres manquants.

   a. Les restrictions du phone manager sont souvent dispersées sur plusieurs pages et ne figurent pas comme permissions d'App standard.

   b. Essayez les étapes optionnelles (par exemple, activer la notification persistante) et testez à nouveau.

   c. Recherchez dans les paramètres système : optimisation batterie, restrictions d'arrière-plan, démarrage auto, et options popup/affichage en arrière-plan.

   d. Si vous ne vous intéressez qu'aux rappels, essayez le mode `Rappel calendrier`.

2. Demandez à d'autres utilisateurs ayant la même marque/modèle d'appareil dans la communauté, et indiquez votre version d'OS.

3. Contactez le support de votre fabricant de téléphone et demandez comment empêcher une App spécifique d'être arrêtée en arrière-plan.

---

### Les widgets App ne fonctionnent pas

1. Ouvrez d'abord LifeUp et laissez-le s'exécuter au premier plan un moment.
2. Réajoutez le widget (si nécessaire, essayez plus d'une fois).
3. S'il échoue à nouveau plus tard, relisez ce guide et revérifiez les paramètres de maintien en arrière-plan.
4. Si vous utilisez un launcher tiers, basculez vers le launcher système et testez à nouveau.
5. Si vous utilisez un thème personnalisé, basculez vers le thème système par défaut et testez à nouveau.
6. Redémarrez votre téléphone.
7. Essayez un autre launcher pour exclure un problème spécifique au launcher.

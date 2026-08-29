# Sauvegarde et restauration

> [!IMPORTANT]
> LifeUp est une application *offline-first*. La plupart de vos données personnelles restent sur votre appareil. Si la sauvegarde n'est pas configurée, la désinstallation de l'App, le changement de téléphone ou un dommage matériel peuvent entraîner une perte de données permanente.

## Navigation rapide

- [Pourquoi la sauvegarde compte](#why-backup)
- [Comment configurer les méthodes de sauvegarde](#configure-methods)
- [Comment sauvegarder](#how-to-backup)
- [Comment restaurer](#how-to-restore)
- [Migration vers un nouveau téléphone](#phone-migration)
- [Problèmes courants](#common-issues)

## 1) Pourquoi la sauvegarde compte :id=why-backup

### Quels risques couvrez-vous ?

La plupart des utilisateurs perdent leurs données dans l'une de ces situations :

1. Désinstallation de l'App (les fichiers dans le chemin de sauvegarde par défaut peuvent être supprimés par le nettoyage système)
2. Migration de téléphone sans déplacer les fichiers de sauvegarde
3. Dommage ou perte de l'appareil

Une sauvegarde fiable signifie que vos données existent sur un autre appareil ou support de stockage, et pas uniquement sur le même téléphone.

### Que contient une sauvegarde ?

Les sauvegardes incluent vos données locales essentielles, comme les Tâches, Attributs, données de la Boutique, Succès, Émotions, enregistrements Pomodoro et paramètres. Les fichiers média (pièces jointes, icônes, arrière-plans, audio) peuvent aussi être inclus.

> [!TIP]
> Si la taille de la sauvegarde dépasse 10 Mo, activez « Ignorer les fichiers média/images » ou augmentez l'intervalle de sauvegarde pour une meilleure stabilité.

## 2) Comment configurer les méthodes de sauvegarde :id=configure-methods

Pour la plupart des utilisateurs, cette priorité fonctionne le mieux :

| Méthode | Recommandation | Idéal pour | Sauvegarde auto | Notes |
| --- | --- | --- | --- | --- |
| Google Drive | ⭐⭐⭐⭐⭐ | Usage quotidien, sync cloud facile | Oui | Autorisation en un tap dans l'App |
| Dropbox | ⭐⭐⭐⭐ | Usage quotidien, sync multi-appareils | Oui | Prise en charge de l'autorisation in-app |
| Export local (chemin personnalisé) | ⭐⭐⭐⭐ | Copie manuelle vers PC / NAS | Non (manuel) | Solution de secours fiable et archives versionnées |
| WebDAV | ⭐⭐⭐ | Auto-hébergement / service WebDAV existant | Oui | Bonne alternative si vous utilisez déjà WebDAV |
| Sauvegarde auto vers le dossier Téléchargements (Android 10+) | ⭐⭐⭐ | Réduire le risque lié à la désinstallation | Oui | Ne protège pas contre les dommages matériels |

<details>
<summary>Configurer la sauvegarde auto Google Drive / Dropbox (recommandé)</summary>

Dans l'App, allez à :
`Barre latérale → Paramètres → Sauvegarde/Restauration/Effacement des données`

Puis :

1. Autorisez Google Drive ou Dropbox
2. Dans « Configuration de la sauvegarde cloud », sélectionnez votre méthode
3. Activez « Activer la sauvegarde cloud automatique »
4. Définissez « Intervalle de sauvegarde automatique »
5. Optionnel : activez « Ignorer les fichiers média/images »

</details>

<details>
<summary>Configurer la sauvegarde cloud WebDAV (optionnel)</summary>

Si vous utilisez un service compatible WebDAV :

1. Ouvrez `Configuration WebDAV`
2. Renseignez l'URL, le compte et le mot de passe
3. Lancez un test de connexion
4. Utilisez WebDAV comme méthode de sauvegarde cloud

</details>

<details>
<summary>Exporter vers un chemin personnalisé (secours manuel)</summary>

Utilisez ceci lorsque vous voulez des sauvegardes manuelles et portables :

1. Appuyez sur `Sauvegarder`
2. Choisissez `Chemin personnalisé`
3. Enregistrez le fichier généré (généralement `.lfbak`)
4. Copiez-le vers PC / NAS / stockage cloud

> [!WARNING]
> Ne gardez pas votre seule sauvegarde sur le même téléphone.

</details>

## 3) Comment sauvegarder :id=how-to-backup

<details>
<summary>Mettre en place un flux de sauvegarde auto quotidien</summary>

1. Terminez une configuration cloud (Google Drive ou Dropbox)
2. Activez la sauvegarde cloud automatique et l'intervalle
3. Déclenchez une sauvegarde manuelle pour vérifier que tout fonctionne
4. Consultez périodiquement l'indication « dernière sauvegarde »

</details>

<details>
<summary>Lancer une sauvegarde manuelle avant des changements critiques</summary>

Créez un export local supplémentaire avant :

- une mise à jour majeure de l'App
- une réinitialisation ou reflash du système
- une migration de téléphone

Utilisez : `Sauvegarder → Chemin personnalisé`, puis copiez le fichier vers un stockage externe.

</details>

## 4) Comment restaurer :id=how-to-restore

<details>
<summary>Restaurer depuis une sauvegarde cloud (Google Drive / Dropbox / WebDAV)</summary>

1. Configurez le même compte/méthode cloud sur l'appareil cible
2. Appuyez sur `Restaurer` et choisissez cette méthode
3. Confirmez la restauration (l'App redémarrera)

> [!WARNING]
> La restauration écrase les données locales actuelles. Si les données actuelles comptent, exportez d'abord une sauvegarde locale.

</details>

<details>
<summary>Restaurer depuis un fichier de sauvegarde local</summary>

1. Déplacez le fichier de sauvegarde vers l'appareil cible
2. Appuyez sur `Restaurer → Chemin personnalisé`
3. Sélectionnez le fichier de sauvegarde et confirmez

Vous pouvez aussi activer « Prise en charge de l'ouverture des fichiers de sauvegarde via le système de fichiers » pour importer directement depuis le gestionnaire de fichiers ou les apps de partage.

> [!TIP]
> Si la restauration échoue avec une erreur de lecture/écriture, essayez un autre chemin de fichier et resélectionnez le fichier.

</details>

### Migration vers un nouveau téléphone :id=phone-migration

<details>
<summary>Migrer vers un nouveau téléphone (système ou chemin de sauvegarde)</summary>

#### Option A : Utiliser d'abord la migration intégrée du téléphone

Certains téléphones prennent en charge la migration complète des données d'App (outils de migration du fabricant / clone système).

1. Lancez la migration système de l'ancien vers le nouveau téléphone.
2. Ouvrez LifeUp et vérifiez les données clés (Tâches, Attributs, données Boutique, Succès).
3. Même si la migration semble correcte, créez une nouvelle sauvegarde sur le nouveau téléphone.

#### Option B : Migrer via sauvegarde cloud ou fichier (universel)

1. Sur l'ancien téléphone, créez d'abord une sauvegarde récente.
2. Sur le nouveau téléphone, installez LifeUp.
3. Pour la migration cloud : configurez la même méthode/compte cloud, puis restaurez.
4. Pour la migration par fichier : transférez le fichier de sauvegarde, puis utilisez `Restaurer → Chemin personnalisé`.
5. Après la restauration, déclenchez une sauvegarde manuelle pour vérifier la chaîne de sauvegarde sur le nouveau téléphone.

> [!WARNING]
> La restauration écrase les données locales. Si le nouveau téléphone contient déjà des entrées importantes, exportez d'abord.

</details>

## 5) Problèmes courants :id=common-issues

<details>
<summary>Corriger l'erreur de restauration : fichier de sauvegarde invalide</summary>

- Confirmez que le fichier est généré par LifeUp.
- `.lfbak` est le format recommandé.

</details>

<details>
<summary>Corriger l'erreur de restauration : fichier de version de sauvegarde supérieure</summary>

Mettez LifeUp à jour vers la dernière version, puis restaurez à nouveau.

</details>

<details>
<summary>Améliorer une sauvegarde cloud lente ou instable</summary>

- Activez « Ignorer les fichiers média/images ».
- Augmentez l'intervalle de sauvegarde automatique.
- Nettoyez les fichiers média inutilisés avant la sauvegarde.

</details>

<details>
<summary>Décider si la sauvegarde auto vers le dossier Téléchargements suffit</summary>

- Cela aide contre les pertes liées à la désinstallation.
- Cela ne couvre pas les dommages ou la perte de l'appareil.
- Stratégie plus sûre : combiner sauvegarde cloud + export local périodique.

</details>

<h1 align="center" padding="100">Client bureau (API) réseau local 🖥</h1>

<p align="center">
 <img src="guide/_media/api/desktop.png" />
</p>

Nous avons créé un client bureau léger pour LifeUp basé sur les API LifeUp. Il prend en charge Windows, Linux et macOS.

**Ce n'est pas une App autonome.** Il lit vos données LifeUp hors ligne depuis votre téléphone via l'accès API.

<br/>

## Fonctionnalités

> [!NOTE]
> La version actuelle est surtout un aperçu technique des capacités API. Elle se concentre sur les opérations de consultation de base et ne couvre pas toutes les fonctions in-app.

- Entièrement open source. Vous pouvez personnaliser l'interface et implémenter vos propres fonctionnalités.
- Capacités de base actuelles :
  - Consulter la liste de Tâches et les terminer
  - Consulter la liste d'Attributs et les Niveaux
  - Consulter la liste d'Objets et les acheter
  - Consulter les Émotions et voir les images en pleine taille sur le bureau
  - Exporter les Émotions en fichiers Markdown
  - Ajouter des Tâches (toutes les options in-app ne sont pas encore couvertes)

<br/>

## Téléchargement

Tous les paquets bureau sont publiés sur [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases).

> [!WARNING]
> Avant d'utiliser le bureau, assurez-vous que LifeUp Cloud est en v2.0.0 ou supérieur.<br/>
> Si vous utilisez la build GitHub Releases, mettez à jour LifeUp Cloud dans `Settings` → `Labs`.<br/>
> Si vous utilisez la build Google Play, vous pouvez mettre à jour depuis [Google Play](https://play.google.com/store/apps/details?id=net.lifeupapp.lifeup.http) ou [LifeUp SDK Releases](https://github.com/Ayagikei/LifeUp-SDK/releases/latest).<br/>
> Certains navigateurs peuvent bloquer le téléchargement de l'installateur pour des raisons de sécurité. Choisissez **Conserver/Autoriser** (libellé variable selon le navigateur), ou utilisez un autre gestionnaire de téléchargements.

### Plateformes d'installation

<!-- tabs:start -->

#### **Windows**

- `LifeUp Desktop.msi`

> [!TIP]
> **Windows SmartScreen**<br/>
> Le MSI n'est pas actuellement signé EV, Windows peut donc afficher un avertissement « application non reconnue ».<br/>
> Après avoir confirmé que le fichier provient de la release officielle GitHub, cliquez sur **Plus d'infos → Exécuter quand même**.

#### **Linux**

- Téléchargez depuis [LifeUp Desktop Releases](https://github.com/Ayagikei/LifeUp-Desktop/releases) et utilisez `lifeup-desktop.deb`.

#### **macOS**

- Intel / x64 : `LifeUp-Desktop-x64.dmg`
- Apple Silicon / ARM64 : `LifeUp-Desktop-arm64.dmg`
- Les builds macOS ne sont pas encore entièrement testées ; certaines fonctions comme **Auto Connect** peuvent être indisponibles.

> [!TIP]
> **Gatekeeper / signature macOS**<br/>
> Les builds macOS actuelles ne sont pas notarisées. Un avertissement « développeur non identifié » peut apparaître.<br/>
> Vous pouvez ouvrir le `.dmg`, déplacer l'App dans Applications, puis clic droit sur l'App et choisir **Ouvrir**,<br/>
> ou aller dans **Réglages système → Confidentialité et sécurité** et cliquer sur **Ouvrir quand même**.<br/>
> Consultez le [guide officiel Apple](https://support.apple.com/en-hk/guide/mac-help/mh40616/mac) pour plus de détails.

<!-- tabs:end -->

Si un paquet manque temporairement, réessayez plus tard. Les assets de release peuvent encore être en cours de téléversement.

<br/>

## Mode d'emploi

### Première configuration

#### Prérequis

- Votre téléphone et le bureau doivent être sur le même LAN (par exemple, le même Wi-Fi).
- <del>Si votre réseau est complexe, testez d'abord si le bureau peut ping l'IP du téléphone.</del>
  - Les versions récentes du bureau prennent en charge la détection automatique de l'IP du téléphone, ce qui rend cette étape souvent inutile.

#### Sur le téléphone

1. Mettez LifeUp à jour vers la dernière version.
2. Dans LifeUp, ouvrez `Settings` → `Labs`, puis installez **LifeUp Cloud**.
3. Ouvrez LifeUp Cloud et accordez les autorisations requises :
   - Autorisation fenêtre flottante / affichage par-dessus les autres apps
   - Autorisation de lecture des données LifeUp
4. Appuyez sur **Start Service** dans LifeUp Cloud.

**Configuration supplémentaire recommandée**

- Effectuez la configuration de compatibilité pour LifeUp et LifeUp Cloud, et désactivez l'optimisation batterie pour réduire les arrêts en arrière-plan.
- Si vous utilisez MIUI (Xiaomi/Redmi), autorisez **Display UI in background** pour les deux apps.
- Gardez LifeUp et LifeUp Cloud en cours d'exécution.

#### Sur le bureau

1. Installez l'App bureau depuis le paquet de release.
2. Dans les paramètres bureau, saisissez l'IP de service affichée dans LifeUp Cloud.
   - Sur le bureau v1.1.0+, vous pouvez essayer **Auto Connect**.
3. Si tout est correctement configuré, vous devriez pouvoir consulter les données LifeUp sur le bureau.
   - En cas d'échec, revoyez la configuration supplémentaire ci-dessus.

### Utilisations suivantes

1. Ouvrez LifeUp et LifeUp Cloud sur le téléphone.
2. Appuyez sur **Start Service** dans LifeUp Cloud.
3. Lancez le client bureau.

<br/>

## FAQ

<details>
<summary>Puis-je ajouter des Tâches depuis le bureau ?</summary>

Oui. La build bureau actuelle prend en charge la création basique de Tâches.

Cependant, toutes les options avancées de Tâches in-app ne sont pas encore disponibles sur le bureau. Pour des configurations complexes, utilisez l'App mobile ou appelez les API via LifeUp Cloud.

</details>

<details>
<summary>J'ai cliqué sur « Request LifeUp Permission » dans LifeUp Cloud, mais rien ne s'est passé / API not found.</summary>

1. Si rien ne se passe, vous l'avez peut-être déjà accordée.
2. Si API not found apparaît, rejoignez la bêta adhérent et mettez LifeUp à jour vers la dernière version bêta.

</details>

<details>
<summary>Après verrouillage du téléphone un moment, le bureau ne peut plus lire les données.</summary>

Effectuez la configuration de compatibilité pour LifeUp et LifeUp Cloud.

</details>

<details>
<summary>Quand LifeUp et LifeUp Cloud sont en arrière-plan, certaines API ne s'exécutent pas.</summary>

> Cela n'affecte généralement pas l'usage bureau de base, mais peut affecter les appels API personnalisés.

Assurez-vous que LifeUp Cloud dispose de l'autorisation fenêtre flottante/affichage par-dessus les autres apps.

Si vous êtes sur MIUI (Xiaomi/Redmi), activez aussi l'autorisation **Display UI in background** pour les deux apps.

</details>

<details>
<summary>L'installation Windows échoue avec `Failed to launch JVM`.</summary>

Référence : [Issue #2](https://github.com/Ayagikei/LifeUp-Desktop/issues/2)

Cela est généralement lié à la configuration locale d'accessibilité de la JVM.

Une solution courante consiste à commenter ces lignes dans `~/.accessibility.properties` :

```txt
# assistive_technologies=com.sun.java.accessibility.AccessBridge
# screen_magnifier_present=true
```

Après modification, redémarrez l'App et testez à nouveau.

> `~` désigne votre répertoire personnel utilisateur.

</details>

<br/>

## Contribution

Le SDK, LifeUp Cloud et LifeUp Desktop sont open source.

Code source :

- [Ayagikei/LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK)
- [Ayagikei/LifeUp-Desktop](https://github.com/Ayagikei/LifeUp-Desktop)

# Politique de confidentialité et conditions de l'App *LifeUp*

?> La description suivante du serveur de l'application ne s'applique pas à la version Lite. La version Lite n'a aucune interaction avec le serveur de l'application.

LifeUp est une App qui vous aide à améliorer votre vie. Nous respectons votre vie privée et nous nous engageons à protéger vos informations personnelles. Cette politique de confidentialité explique comment nous collectons, utilisons, partageons et supprimons vos informations personnelles lorsque vous utilisez notre App.

### 1. Informations personnelles

LifeUp est une App offline first. Nous ne collectons pas activement les données utilisateur, par exemple votre nom, adresse e-mail. Vous pouvez éventuellement fournir certaines données pour autoriser la connexion afin d'accéder au module Monde, autoriser Google Drive ou Dropbox pour obtenir des capacités de sauvegarde cloud, etc.

Nous utilisons Google Firebase et Sentry pour collecter des rapports de problèmes et des données de performance uniquement à des fins d'analyse.

Voici un résumé de certaines données :

- **Pseudo, avatar, genre**
  Facultatif, utilisé pour la fonction de connexion afin d'accéder au module « Monde », sera transféré au serveur pour stockage, mais peut être modifié et supprimé
- **E-mail**
  Facultatif, pour la synchronisation Google Drive, stockage local, non transmis au serveur
- **URL WebDAV, compte et mot de passe**
  Facultatif, pour la synchronisation WebDAV, stockage local chiffré, non transmis au serveur
- **Informations de crash, données de performance**
  Transmises aux fournisseurs de services (Google Firebase, Sentry) pour l'analyse des problèmes et des performances, mais jamais liées à des identifiants utilisateur ou appareil, et ne contiennent pas de données utilisateur

Les méthodes détaillées de collecte et de traitement des données pour chaque fonction sont présentées ci-dessous.

#### 1.1 Informations utilisateur (autorisation tierce)

##### Connexion Google/Facebook

**Uniquement après que vous ayez confirmé l'autorisation de connexion,** nous créerons un compte avec le pseudo et la photo de profil que vous avez autorisés à fournir (et n'inclura pas d'informations telles que les comptes e-mail).

##### Google Drive

Comme les sauvegardes Google Drive dépendent des adresses e-mail, *LifeUp* demandera l'autorisation d'accès à l'adresse e-mail lorsque vous autorisez Google Drive. **Mais cette adresse ne sera utilisée que localement, *LifeUp* ne la transmettra pas au serveur de l'application ni ne la stockera.**

Et *LifeUp* ne demande que le stockage spécifique à l'App, ce qui signifie que nous n'avons pas l'autorisation d'accéder à vos fichiers privés.

##### Dropbox

Après que vous ayez autorisé Dropbox, **les informations pertinentes ne seront conservées que sur votre appareil pour la sauvegarde, et ne sont pas transmises au serveur de l'application.**

Et *LifeUp* ne demande que **le stockage spécifique à l'App, ce qui signifie que nous n'avons pas l'autorisation d'accéder à vos fichiers privés.**

##### Serveur WebDAV

**Votre URL WebDAV, votre compte et votre mot de passe ne seront stockés que localement et ne seront pas envoyés au serveur de l'application.** Et le mot de passe est stocké chiffré dans la base de données.

##### Mode hors ligne

***LifeUp* est également entièrement utilisable en mode hors ligne, mais ne peut pas accéder au module « Monde ».**

En mode hors ligne, **vous n'avez pas besoin de soumettre d'informations à notre serveur d'application.**
**Votre pseudo, avatar et autres informations seront stockés et disponibles localement.**

Nous pouvons uniquement interroger le serveur de l'application pour les dernières annonces et mises à jour, qui n'impliquent pas la soumission d'informations.

Vos interactions avec d'autres SDK comme Dropbox, Google Drive, Facebook. Ces requêtes répondront normalement lors de votre utilisation active.

En utilisation hors ligne, nous pouvons toujours utiliser Google Firebase, Sentry pour collecter des rapports de crash et de problèmes, mais comme expliqué ci-dessous, **ces informations ne contiennent pas de données utilisateur et ne sont pas liées aux informations utilisateur. Uniquement pour l'analyse des performances et la résolution des crashs, et stockées temporairement.**

Nous communiquerons également avec Google Play Services pour vérifier votre licence selon la demande de Google Play.

Si vous souhaitez refuser toutes les communications ci-dessus, vous pouvez directement désactiver l'autorisation de requêtes réseau de LifeUp. Cela n'affecte pas l'utilisation de LifeUp elle-même, mais peut affecter le fonctionnement de SDK tels que Google Drive.


#### 1.2 Autorisations

#### Stockage

L'application **ne demandera pas l'autorisation de lecture de l'espace de stockage**, elle ne lira donc aucun fichier que vous n'avez pas autorisé.

L'application a demandé l'autorisation de la caméra pour faciliter l'utilisation des pièces jointes d'images, le téléversement d'avatars et d'autres fonctions, et **ne pourra appeler la caméra qu'après que l'utilisateur ait accordé les autorisations.**

Par exemple, lorsque vous sélectionnez une image jointe, nous appelons directement le framework de stockage de fichiers du système pour y accéder.

Il n'autorisera *LifeUp* qu'avec le fichier unique que vous sélectionnez, nous n'aurons pas l'autorisation de lire d'autres fichiers.

En même temps, sauf si vous partagez activement des fichiers en dehors du module Monde, ils ne seront stockés que localement et ne passeront pas par le serveur.

#### Réseau

L'autorisation d'accès réseau sert à accéder au module « MONDE », à la connexion autorisée, et à la synchronisation Dropbox/WebDAV optionnelle et autres fonctions.

#### Calendrier

L'application propose également la fonction d'écriture d'événements dans l'application calendrier du système pour vous rappeler.

**Cette fonction nécessitera des autorisations de lecture et d'écriture du calendrier, et cette autorisation ne sera demandée que lorsque l'utilisateur utilise la fonction correspondante. Et *LifeUp* ne lira que les événements écrits par l'application elle-même.**

#### 1.3 Stockage des données

**L'application est une application offline first et n'a pas de fonction de synchronisation en ligne intégrée, la plupart des données sont donc stockées localement sur le téléphone mobile de l'utilisateur.**

Par exemple, toutes les Tâches locales que vous avez créées, toutes les Émotions enregistrées, les Succès que vous avez conçus, et les Objets de la Boutique.

**Seul le contenu que vous partagez activement publiquement dans le module « Monde » sera stocké sur le serveur.
Et ces contenus supportent tous les opérations de suppression et de destruction.**

Par exemple, l'équipe que vous avez créée dans le module « Monde », les activités que vous avez publiées après avoir accompli les Tâches d'équipe, les Objets de la Boutique activement partagés, et ainsi de suite.

En même temps, la grande majorité des requêtes au sein de l'application seront transmises sous forme chiffrée.

#### 1.4 Données de performance et rapports de crash

Nous utilisons [Google Firebase](https://firebase.google.com/) et [Sentry](https://sentry.io/) pour collecter les données de performance utilisateur et les rapports de crash afin de suivre et corriger les problèmes.

Ces données de performance peuvent inclure le modèle de votre appareil, l'état du réseau, l'ID d'instance, le moment où le problème s'est produit, et les pages associées, **mais ces données ne seront pas associées à vos données utilisateur** (n'inclut pas votre pseudo, ID utilisateur, adresse e-mail et toute information de contact, et ne collectera pas le contenu que vous saisissez et créez) et ne seront utilisées que pour analyser le problème et améliorer les performances.

Et ces données ne sont stockées temporairement que par Firebase et Sentry pendant une certaine période, **et nous ne les**
**partagerons / vendrons / louerons pas à des tiers.**

#### 1.5 Demande de suppression de données pour *LifeUp Lite*

##### 1. Stockage et suppression des données

LifeUp Lite, la version gratuite de LifeUp, stocke principalement les données sur l'appareil de l'utilisateur. Nous respectons votre vie privée et votre autonomie. Dans LifeUp Lite, comme aucun compte utilisateur n'est créé, toutes les données personnelles sont stockées localement sur votre appareil.

**Pour supprimer ces données, il suffit de désinstaller l'application LifeUp Lite de votre appareil. Lors de la désinstallation, toutes les données stockées localement seront définitivement supprimées.**

##### 2. Services tiers

LifeUp Lite s'intègre à des services tiers tels que Firebase et Admob pour des fonctionnalités et des publicités. Veuillez noter que les données collectées par ces services n'incluent pas d'informations personnelles liées à votre identité et sont utilisées conformément à leurs politiques de confidentialité respectives. Ces données sont automatiquement supprimées après une certaine période conformément aux politiques de ces services.

##### 3. Aide pour la suppression des données

Si vous avez besoin d'aide ou si vous avez des questions concernant la suppression de vos données, n'hésitez pas à nous contacter à lifeup@ulives.io. Notre équipe s'engage à vous aider pour toute question ou préoccupation liée à la confidentialité de vos données et vous guidera dans le processus si nécessaire.

##### 4. Conformité et mises à jour

Nous examinons et mettons à jour continuellement nos pratiques pour garantir la conformité avec les dernières réglementations et normes du secteur. Cette section de la Politique de confidentialité sera mise à jour si nécessaire pour refléter tout changement dans nos processus de gestion et de suppression des données.


#### 1.6 Demande de suppression de données pour *LifeUp Pro*

##### 1. Suppression des données dans LifeUp Pro

Les utilisateurs de LifeUp Pro peuvent supprimer leurs données de manière indépendante dans l'App.

Comme LifeUp Pro est principalement une application hors ligne, vous pouvez gérer vos données directement sur votre appareil.

Pour supprimer vos données, suivez ces étapes :

1. Allez à la page « Paramètres - Sauvegarde/Restauration/Effacement des données » dans l'App LifeUp Pro.
2. Choisissez les données spécifiques que vous souhaitez supprimer, comme les Tâches, les Récompenses d'Objets, les pensées locales et les données du mode hors ligne.
3. Confirmez votre action pour supprimer définitivement les données sélectionnées.

**Sinon, la désinstallation de l'App LifeUp Pro de votre appareil entraînera également la suppression de toutes les données stockées localement.**



##### 2. Suppression de compte dans LifeUp Pro

La suppression de votre compte dans LifeUp Pro est un processus distinct de la suppression des données.

Lorsque vous supprimez votre compte, cela supprimera :

- Vos publications publiques, comme les équipes et les mises à jour, publiées sur nos serveurs.
- Votre pseudo et autres informations personnelles associées à votre compte.
- Les associations OAuth liées à votre compte.

**Pour supprimer votre compte LifeUp Pro, suivez les étapes décrites précédemment :**

1. Accédez à la page « Paramètres - Sauvegarde/Restauration/Effacement des données ».
2. Appuyez sur le bouton « Supprimer le compte » en bas de la page.
3. Confirmez votre action pour supprimer définitivement votre compte et toutes les informations associées.

<br/>

**Si vous n'utilisez plus l'App LifeUp Pro mais souhaitez supprimer votre compte et vos données personnelles, contactez-nous à [lifeup@ulives.io](mailto:lifeup@ulives.io).**

Fournissez-nous les informations nécessaires liées à votre compte, et notre équipe vous aidera dans le processus de suppression.

Nous nous engageons à garantir votre vie privée et à traiter votre demande avec le plus grand soin et la plus stricte confidentialité.



##### 3. Services tiers

Comme LifeUp Lite, LifeUp Pro s'intègre à des services tiers tels que Firebase pour des fonctionnalités avancées. Les données collectées par ces services ne sont pas personnellement identifiables et sont gérées conformément à leurs politiques de confidentialité. Ces données sont automatiquement programmées pour suppression après une certaine période conformément aux politiques des services tiers.



##### 4. Mises à jour et conformité

Nous surveillons et mettons à jour continuellement nos pratiques pour nous aligner sur les dernières lois sur la vie privée et les normes du secteur. Cette section de la Politique de confidentialité sera modifiée si nécessaire pour refléter avec précision nos processus de gestion et de suppression des données pour les utilisateurs de LifeUp Pro.


### 2. Accord

En utilisant cette application, vous acceptez les termes de cette politique de confidentialité.

Vous acceptez d'être responsable de vos propres données.

Nous ne sommes en aucun cas responsables de toute perte de données causée par ou en relation avec l'utilisation de cette App, car il s'agit d'une application offline first.

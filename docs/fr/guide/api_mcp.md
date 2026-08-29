<h1 align="center" padding="100">MCP & Skills</h1>

Vous voulez que l'IA travaille avec LifeUp ? Il y a deux couches :

| | Rôle | Qui l'utilise |
|---|---|---|
| **MCP** `@lifeup/mcp` | Découvre LifeUp Cloud, envoie des requêtes HTTP, encode les paramètres et analyse les réponses | Cursor, Claude Desktop, WorkBuddy et tout client MCP |
| **Skills** `lifeup-cloud/` | Comment se connecter, quoi interroger et comment appeler chaque API | Inclus dans MCP comme `help` ; Claude Code / Pi peuvent aussi charger le dossier comme skill sur disque |

L'agent sur votre ordinateur atteint LifeUp Cloud sur le téléphone via le LAN, puis communique avec LifeUp. Les détails HTTP sont dans l'[API LifeUp Cloud](guide/api_cloud.md). Code source MCP : [LifeUp-SDK/mcp](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp).

> [!NOTE]
> Nécessite **LifeUp 1.106.0**+ et **LifeUp Cloud 3.0.0**+. Les versions antérieures peuvent encore se connecter, mais journaux, statistiques et courbe de Niveau sont incomplets. `status.update` peut inviter l'utilisateur à mettre à jour.

MCP donne à l'agent des **API lecture/écriture** ; la couche IA ajoute le **raisonnement** — prioriser le backlog du jour, résumer les statistiques hebdomadaires depuis les journaux, concevoir des Tâches selon vos Niveaux d'Attributs, ou **monter une gamification thématique complète en un seul prompt** (développement indie, académie de magie, etc.) — pas seulement récupérer des listes brutes.

## Essayez de demander

Une fois MCP installé, pas besoin de mémoriser les API — parlez simplement à l'IA.

**Planifiez votre journée**

- « Qu'est-ce qu'il reste aujourd'hui ? Trie par priorité et dis-moi par quoi commencer. »
- « Choisis une Tâche non terminée que je peux finir en environ 25 minutes. »

**Analysez vos données**

- « Sors les stats pomodoro, Concentration, pièces et Points d'Expérience de cette semaine — détaille d'où elles viennent et résume les tendances. »
- « D'où viennent mes pièces ce mois-ci ? Montre les principales sources et ce qui surprend. »

**Coachez et concevez**

- « Regarde mes Niveaux d'Attributs et conçois un ensemble de Tâches quotidiennes pour monter mes Compétences les plus faibles. »

**Configuration thématique en une fois**

- « Supprime les exemples et monte une configuration complète de développeur indie : listes, Boutique, Succès et Attributs. »
- « Conçois une routine RPG complète d'académie de magie — Tâches, Attributs, Objets Boutique et Succès. »

**Réfléchissez**

- « Regarde ce que j'ai terminé aujourd'hui et écris un court journal : ce que j'ai fait, et ce que je pourrais améliorer demain. »
- « Crée une liste de Succès appelée Morning Routine, puis ajoute 8 Succès avec des icônes emoji et des Récompenses en pièces. »
<br/>

## Démarrage rapide

Envoyez cette ligne à votre agent pour installer MCP et effectuer la première connexion :

```
Follow this doc to install the LifeUp MCP server and complete the first connection: https://raw.githubusercontent.com/Ayagikei/LifeUp-Wiki/master/docs/en/guide/api_mcp.md
```

<br/>

## Skills

Les fichiers Skills se trouvent dans [`mcp/skills/lifeup-cloud/`](https://github.com/Ayagikei/LifeUp-SDK/tree/feat/mcp/mcp/skills/lifeup-cloud) (une copie dans le repo — pas de package npm séparé).

- **Cursor / Claude Desktop / WorkBuddy :** installez uniquement MCP. `help` lit ce skill ; ne l'installez pas deux fois.
- **Claude Code / Pi / workflow personnalisé :** copiez le dossier dans le chemin skills de l'agent, ou pointez directement vers le repo.

```text
mcp/skills/lifeup-cloud/
  SKILL.md                 connexion + opérations courantes (lisez d'abord)
  references/
    basics.md              erreurs, encodage, JSON, timeouts
    discovery.md           mDNS / token
    query.md               ressources list_data
    tasks.md / economy.md
    api-index.md           une ligne par méthode
    methods/*.md           tableau complet des paramètres (charger à l'appel)
    broadcasts.md / gaps.md
```

L'agent lit la documentation progressivement :

1. `help` (ou `SKILL.md` sur disque) — flux global
2. `help api-index` — quelles méthodes existent
3. `help add_task` — paramètres d'une méthode
4. `call_api` / `list_data` — effectuer l'appel

Pour personnaliser : copiez le dossier et modifiez `SKILL.md` et `references/`. MCP `help` lit toujours la copie empaquetée sauf si vous recompilez MCP depuis votre fork.

<br/>

## Configuration

1. Téléphone et ordinateur sur le même LAN
2. LifeUp en cours d'exécution, avec Cloud autorisé pour **Read LifeUp Data**
3. LifeUp Cloud démarré (port par défaut `13276`)
4. [Node.js 20+](https://nodejs.org/) sur l'ordinateur

Le token est optionnel. S'il est défini, envoyez le token **brut** dans l'en-tête — pas `Bearer`.

<br/>

## Installer MCP

Jusqu'à la publication sur npm, installez depuis GitHub :

```json
{
  "mcpServers": {
    "lifeup": {
      "command": "npx",
      "args": ["-y", "github:Ayagikei/LifeUp-SDK#feat/mcp"]
    }
  }
}
```

`npx` clone le repo et compile `mcp/`. Quand cela arrivera sur `main`, retirez `#feat/mcp`.

Si vous avez déjà cloné [LifeUp-SDK](https://github.com/Ayagikei/LifeUp-SDK), utilisez l'installateur (compile MCP et met à jour les clients détectés ; relancer n'enregistre pas une seconde copie) :

```bash
./scripts/install-mcp.sh
```

Clients par défaut : Codex, Cursor, Claude Code, Claude Desktop, Pi. Les configs Pi avec `imports: ["codex"]` héritent de Codex et ne sont pas dupliquées.

Les apps GUI sur macOS n'ont souvent pas `npx` dans le `PATH` — utilisez un chemin absolu vers `npx`/`node`, ou clonez et exécutez `cd mcp && npm install && npm run build`.

| Variable | Rôle |
|---|---|
| `LIFEUP_HOST` | p. ex. `192.168.1.8:13276`, ignorer mDNS |
| `LIFEUP_TOKEN` | Processus uniquement, jamais écrit sur disque |
| `LIFEUP_MCP_CONFIG` | Chemin de config personnalisé |

Après publication : `npx -y @lifeup/mcp` (npmmirror en Chine).
<br/>

## Flux de l'agent :id=agent-workflow

1. `discover` — mDNS `_lifeup._tcp` ; le `port` du TXT est le port HTTP. Connexion automatique si exactement une instance Cloud est trouvée.
2. `connect` — passez `host` lorsque zéro ou plusieurs instances sont trouvées.
3. `status` — vérifiez les versions ; si inférieures à 1.106.0 / 3.0.0, surveillez `update`.
4. Listes : `list_data` (champs compacts par défaut).
5. Écritures : `complete_task` / `add_task` / `reward` / `purchase_item` ; tout le reste via `call_api`. Utilisez `via=launch` pour ouvrir l'interface de l'App.

Les appels destructifs nécessitent `confirm: true`. Ne pré-encodez pas les valeurs de paramètres.

## Événements

LifeUp : activez Labs → Broadcast events (désactivé par défaut ; Cloud Advanced peut afficher l'état et l'activer). **WebSocket event push** de Cloud est activé par défaut (3.0.0+) et est transport uniquement.

- `list_events` — `GET /events`, toujours disponible
- `subscribe_events` — `WS /events` ; erreur si le commutateur Cloud est désactivé ; HTTP fonctionne toujours

Détails : MCP `help broadcasts`.

<br/>

---

## Exemple : configuration développeur indie

Ci-dessous, le résultat d'une session MCP réelle : l'utilisateur a demandé à l'IA de **supprimer les exemples développeur intégrés de LifeUp**, puis de monter une configuration RPG complète autour du **développement de jeux indie** (listes de Tâches, Attributs, Boutique, Succès).

Vous pouvez commencer avec des prompts comme :

> Clear the sample tasks and shop items, then create a full indie game developer setup: task lists, attributes, shop items, and achievements.

### Ce qui a été créé

| Domaine | Contenu |
| --- | --- |
| Listes de Tâches | Morning Ritual, Coding Daily, Game Dev, Deep Learning, Learning & Recharge, Wrap-up |
| Attributs | Execution / Technical / Collaboration / Focus / Wellness / Creativity, plus **Developer Stats** (Game Design, Debugging, Architecture) |
| Boutique | **Dev Supplies** (consommables) + **Fun Collectibles** (Objets easter egg) |
| Succès | **Indie Dev Journey** (Hello World, First Bug Kill, Ship It!, …) |

> [!TIP]
> Cliquez sur une image pour zoomer. Utilisez les onglets ci-dessous pour basculer horizontalement au lieu de faire défiler une longue page.

<!-- tabs:start -->

#### **1 · Aperçu des Tâches**

Tâches récurrentes Morning Ritual dans la vue **All**, avec puces de catégorie pour Coding Daily, Game Dev, etc.

![Tasks · Morning Ritual and categories](_media/mcp/game-dev-example/02-tasks-overview.jpg ':size=45%')

#### **2 · Attributs**

Six Attributs principaux plus le groupe **Developer Stats**. Terminer des Tâches accorde de l'EXP aux Compétences correspondantes.

![Attributes panel](_media/mcp/game-dev-example/03-skills.jpg ':size=45%')

#### **3 · Fun Collectibles**

Objets easter egg de la Boutique : Inspiration Dice, RGB Keycap, Desk Cat, LEGO Brick, Retro Gamepad, Rubber Duck — certains avec pièces aléatoires ou bonus d'Attributs.

![Shop · Fun Collectibles](_media/mcp/game-dev-example/04-shop-fun-collection.jpg ':size=45%')

#### **4 · Succès**

Succès par jalons : première Tâche, premier bug corrigé, publier une démo, séries, pomodoros, Piggy Bank, Daily Pentakill, etc. — avec icônes emoji et conditions de déblocage.

![Indie Dev Journey achievements](_media/mcp/game-dev-example/06-achievements.jpg ':size=45%')

#### **5 · Détail Piggy Bank**

Exemple de condition par progression : atteindre **500 pièces** de solde actuel.

![Achievement detail · Piggy Bank](_media/mcp/game-dev-example/07-achievement-detail-piggy-bank.jpg ':size=45%')

#### **6 · Détail Daily Pentakill**

Exemple de condition par compteur : terminer **5 Tâches différentes en un jour**.

![Achievement detail · Daily Pentakill](_media/mcp/game-dev-example/08-achievement-detail-pentakill.jpg ':size=45%')

<!-- tabs:end -->

### Ce que l'IA fait typiquement

1. `list_tasks` / `list_items` — inspecte les exemples existants ; supprime les anciennes lignes si nécessaire (`confirm: true` pour les appels destructifs).
2. Crée des listes de Tâches / Boutique / Succès (`category`).
3. Crée des Attributs et groupes (`skill` / `skill_group`).
4. Écrit Tâches, Objets et Succès par lot (`add_task` / `add_item` / `achievement`).
5. Actualise les écrans correspondants dans l'App pour vérifier.

Pour les paramètres API, consultez [Skills](#skills) et [Flux de l'agent](#agent-workflow) ci-dessus ; tableaux par méthode via MCP `help add_task`, etc.

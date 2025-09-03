# 🌍 SimpleWarp

Un plugin **Minecraft Spigot/Paper** simple et léger permettant de définir et d’utiliser des warps via une commande unique `/warp`.  
Développé en Java pour l’exemple, avec package `fr.aarize.nomdupl`.

---

## ✨ Fonctionnalités
- Définir un warp avec `/warp set <nom>`.
- Liste des warps existants avec `/warp list`.
- Téléportation rapide avec `/warp <nom>`.
- Warps sauvegardés automatiquement dans la configuration (`config.yml`).
- Message de bienvenue à la connexion invitant les joueurs à découvrir les warps.
- Permissions configurables.

---

## 📥 Installation
1. Télécharge le fichier **SimpleWarp.jar** depuis les Releases ou compile le projet avec Gradle.
2. Place le fichier `.jar` dans le dossier `plugins/` de ton serveur Spigot ou Paper.
3. Redémarre ton serveur.
4. Le plugin générera automatiquement le fichier `config.yml`.

---

## ⚙️ Commandes
| Commande | Description |
|----------|-------------|
| `/warp set <nom>` | Définit un warp au lieu où se trouve le joueur |
| `/warp list` | Liste tous les warps disponibles |
| `/warp <nom>` | Téléporte le joueur vers le warp |

---

## 🔑 Permissions
| Permission | Description | Défaut |
|------------|-------------|---------|
| `simplewarp.set` | Permet de créer des warps | `op` |

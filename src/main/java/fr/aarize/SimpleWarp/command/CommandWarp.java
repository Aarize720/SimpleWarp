package fr.aarize.SimpleWarp.command;

import fr.aarize.SimpleWarp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class CommandWarp implements CommandExecutor {

    private final Main plugin;

    public CommandWarp(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seul un joueur peut utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usage: /warp set <name> | /warp list | /warp <name>");
            return true;
        }

        String sub = args[0].toLowerCase();

        if (sub.equals("set")) {
            if (!player.hasPermission("simplewarp.set")) {
                player.sendMessage("§cVous n'avez pas la permission de définir un warp.");
                return true;
            }
            if (args.length < 2) {
                player.sendMessage("Usage: /warp set <name>");
                return true;
            }
            String name = args[1].toLowerCase();
            plugin.getWarpManager().setWarp(name, player.getLocation());
            player.sendMessage("§aWarp '" + name + "' défini.");
            return true;
        }

        if (sub.equals("list")) {
            Set<String> warps = plugin.getWarpManager().listWarps();
            if (warps.isEmpty()) {
                player.sendMessage("Aucun warp défini.");
                return true;
            }
            player.sendMessage("Warps: " + String.join(", ", warps));
            return true;
        }

        // warp <name>
        String name = sub;
        Location loc = plugin.getWarpManager().getWarp(name);
        if (loc == null) {
            player.sendMessage("§cWarp inconnu: " + name);
            return true;
        }

        if (loc.getWorld() == null) {
            player.sendMessage("§cLe monde du warp n'existe pas ou n'est pas chargé.");
            return true;
        }

        player.teleport(loc);
        player.sendMessage("§aTéléporté vers '" + name + "'.");
        return true;
    }
}

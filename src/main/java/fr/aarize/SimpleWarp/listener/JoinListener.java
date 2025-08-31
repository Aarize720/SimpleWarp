package fr.aarize.SimpleWarp.listener;

import fr.aarize.SimpleWarp.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§6Bienvenue! Utilisez /warp list pour voir les warps disponibles.");
    }
}

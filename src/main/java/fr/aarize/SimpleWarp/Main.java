package fr.aarize.SimpleWarp;

import org.bukkit.plugin.java.JavaPlugin;
import fr.aarize.SimpleWarp.command.CommandWarp;
import fr.aarize.SimpleWarp.listener.JoinListener;

public class Main extends JavaPlugin {

    private WarpManager warpManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.warpManager = new WarpManager(this);

        getCommand("warp").setExecutor(new CommandWarp(this));
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        getLogger().info("SimpleWarp enabled");
    }

    @Override
    public void onDisable() {
        warpManager.save();
        getLogger().info("SimpleWarp disabled");
    }

    public WarpManager getWarpManager() {
        return warpManager;
    }
}

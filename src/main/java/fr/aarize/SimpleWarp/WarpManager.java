package fr.aarize.SimpleWarp;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class WarpManager {
    private final Main plugin;

    public WarpManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setWarp(String name, Location loc) {
        String serialized = serialize(loc);
        plugin.getConfig().set("warps." + name, serialized);
        plugin.saveConfig();
    }

    public Location getWarp(String name) {
        String s = plugin.getConfig().getString("warps." + name);
        if (s == null) return null;
        return deserialize(s);
    }

    public Set<String> listWarps() {
        FileConfiguration cfg = plugin.getConfig();
        if (!cfg.isConfigurationSection("warps")) return Collections.emptySet();
        return cfg.getConfigurationSection("warps").getKeys(false);
    }

    public void removeWarp(String name) {
        plugin.getConfig().set("warps." + name, null);
        plugin.saveConfig();
    }

    public void save() {
        plugin.saveConfig();
    }

    // simple serialization: world;x;y;z;yaw;pitch
    private String serialize(Location loc) {
        return String.join(";",
                loc.getWorld().getName(),
                String.valueOf(loc.getX()),
                String.valueOf(loc.getY()),
                String.valueOf(loc.getZ()),
                String.valueOf(loc.getYaw()),
                String.valueOf(loc.getPitch())
        );
    }

    private Location deserialize(String s) {
        try {
            String[] parts = s.split(";");
            if (parts.length != 6) return null;
            String world = parts[0];
            double x = Double.parseDouble(parts[1]);
            double y = Double.parseDouble(parts[2]);
            double z = Double.parseDouble(parts[3]);
            float yaw = Float.parseFloat(parts[4]);
            float pitch = Float.parseFloat(parts[5]);
            return new Location(plugin.getServer().getWorld(world), x, y, z, yaw, pitch);
        } catch (Exception e) {
            return null;
        }
    }
}

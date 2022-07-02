package mc.towercraft.rolles.util.tcthebridgecloud;

import mc.towercraft.rolles.util.tcthebridgecloud.config.YMLConfig;
import mc.towercraft.rolles.util.tcthebridgecloud.listener.TheBridgeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TCTheBridgeCloud extends JavaPlugin {

    public static YMLConfig config;

    @Override
    public void onEnable() {
        config = new YMLConfig(this);
        Bukkit.getPluginManager().registerEvents(new TheBridgeListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

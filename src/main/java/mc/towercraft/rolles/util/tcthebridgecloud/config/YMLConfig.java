package mc.towercraft.rolles.util.tcthebridgecloud.config;

import mc.towercraft.rolles.util.tcthebridgecloud.TCTheBridgeCloud;
import org.bukkit.configuration.file.FileConfiguration;

public class YMLConfig {

    public String groupServer;
    private FileConfiguration config;

    public YMLConfig(TCTheBridgeCloud plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
            plugin.saveDefaultConfig();
        }
        config = plugin.getConfig();
        groupServer = config.getString("server-group");
    }
}

package mc.towercraft.rolles.util.tcthebridgecloud.listener;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.ext.bridge.bukkit.BukkitCloudNetHelper;
import de.dytanic.cloudnet.wrapper.Wrapper;
import mc.towercraft.rolles.util.tcthebridgecloud.TCTheBridgeCloud;
import me.towercraft.connection.server.ServerConnectApi;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import plugily.projects.thebridge.api.events.game.TBGameStartEvent;
import plugily.projects.thebridge.api.events.game.TBGameStopEvent;
import plugily.projects.thebridge.arena.ArenaState;

public class TheBridgeListener implements Listener {

    private final TCTheBridgeCloud plugin;

    public TheBridgeListener(TCTheBridgeCloud plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGameStop(TBGameStopEvent event){
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            Bukkit.getOnlinePlayers().forEach(player -> ServerConnectApi.getInstance().connectByServerGroup(player, TCTheBridgeCloud.config.groupServer));
        }, 100);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            ServiceInfoSnapshot currentServiceInfoSnapshot = Wrapper.getInstance().getCurrentServiceInfoSnapshot();
            CloudNetDriver.getInstance().getCloudServiceProvider(currentServiceInfoSnapshot.getName()).stop();
        }, 200);
    }

    @EventHandler
    public void onGameStart(TBGameStartEvent event) {
        BukkitCloudNetHelper.changeToIngame(true);
    }
}

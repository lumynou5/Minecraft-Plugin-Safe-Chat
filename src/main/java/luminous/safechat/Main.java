package luminous.safechat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }
}

class ChatListener implements Listener {
    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        String sender = event.getPlayer().getName();
        String message = event.getMessage();
        event.setCancelled(true);
        Bukkit.broadcastMessage("<" + sender + "> " + message);
    }
}

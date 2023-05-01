package lumynous.safechat;

import lumynous.safechat.util.Fmt;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;

public class ChatListener implements Listener {
    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        String sender = event.getPlayer().getName();
        String message = event.getMessage();
        event.setCancelled(true);

        Map<String, String> formatArgs = new HashMap<>(Map.of(
                "sender", sender,
                "message", message
        ));

        Bukkit.broadcastMessage(Fmt.format(
                Main.config.globalMessageFormat,
                formatArgs
        ));
    }
}

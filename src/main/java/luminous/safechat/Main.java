package luminous.safechat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("safechat").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {
        sender.sendMessage("Safe Chat is enabled!");
        return true;
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

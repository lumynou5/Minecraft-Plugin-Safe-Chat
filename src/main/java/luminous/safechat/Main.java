package luminous.safechat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("safechat").setExecutor(this);
        Bukkit.getPluginCommand("msg").setExecutor(new ChatListener());
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {
        sender.sendMessage(ChatColor.GRAY + "Safe Chat is enabled!");
        return true;
    }
}

class ChatListener implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length < 2) {
            return false;
        }

        Player player = Bukkit.getPlayerExact(args[0]);
        if (player == null) {
            try {
                Bukkit.getPlayer(UUID.fromString(args[0]));
            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
        }
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not Found!");
            return true;
        }

        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]);
        }

        sender.sendMessage(ChatColor.GRAY + sender.getName() + " -> " + player.getName() + ": " + message);
        return true;
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        String sender = event.getPlayer().getName();
        String message = event.getMessage();
        event.setCancelled(true);
        Bukkit.broadcastMessage("<" + sender + "> " + message);
    }
}

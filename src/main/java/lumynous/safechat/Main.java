package lumynous.safechat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Main extends JavaPlugin {
    public static Config config;

    @Override
    public void onEnable() {
        // Register command executors.
        Bukkit.getPluginCommand("reload-config").setExecutor(this);
        Bukkit.getPluginCommand("msg").setExecutor(new DMCommand());

        // Register event listener.
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

        config = new Config(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {
        config = new Config(this);
        sender.sendMessage("Reloaded configurations!");
        return true;
    }
}

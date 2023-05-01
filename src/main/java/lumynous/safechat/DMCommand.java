package lumynous.safechat;

import lumynous.safechat.util.Fmt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DMCommand implements CommandExecutor {
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

        Player target = Bukkit.getOnlinePlayers()
                .stream()
                .filter((x) -> x.getName().equals(args[0]) || x.getUniqueId().equals(UUID.fromString(args[0])))
                .toList()
                .get(0);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not Found!");
            return true;
        }

        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(' ');
        }

        Map<String, String> formatArgs = Map.of(
                "sender", sender.getName(),
                "target", target.getName(),
                "message", message.toString()
        );

        sender.sendMessage(Fmt.format(
                Main.config.directMessageSenderFormat,
                formatArgs
        ));
        target.sendMessage(Fmt.format(
                Main.config.directMessageSenderFormat,
                formatArgs
        ));
        return true;
    }
}

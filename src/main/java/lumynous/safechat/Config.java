package lumynous.safechat;

import lumynous.safechat.util.Fmt;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.Objects;

public class Config {
    public final String globalMessageFormat;
    public final String directMessageSenderFormat;
    public final String directMessageTargetFormat;

    public static final Map<String, ChatColor> CHAT_COLOR_SHEET = Map.ofEntries(
            Map.entry("_BLACK", ChatColor.BLACK),
            Map.entry("_DARK_BLUE", ChatColor.DARK_BLUE),
            Map.entry("_DARK_GREEN", ChatColor.DARK_GREEN),
            Map.entry("_DARK_AQUA", ChatColor.DARK_AQUA),
            Map.entry("_DARK_RED", ChatColor.DARK_RED),
            Map.entry("_DARK_PURPLE", ChatColor.DARK_PURPLE),
            Map.entry("_GOLD", ChatColor.GOLD),
            Map.entry("_GRAY", ChatColor.GRAY),
            Map.entry("_DARK_GRAY", ChatColor.DARK_GRAY),
            Map.entry("_BLUE", ChatColor.BLUE),
            Map.entry("_GREEN", ChatColor.GREEN),
            Map.entry("_AQUA", ChatColor.AQUA),
            Map.entry("_RED", ChatColor.RED),
            Map.entry("_LIGHT_PURPLE", ChatColor.LIGHT_PURPLE),
            Map.entry("_YELLOW", ChatColor.YELLOW),
            Map.entry("_WHITE", ChatColor.WHITE),
            Map.entry("_MAGIC", ChatColor.MAGIC),
            Map.entry("_BOLD", ChatColor.BOLD),
            Map.entry("_STRIKETHROUGH", ChatColor.STRIKETHROUGH),
            Map.entry("_UNDERLINE", ChatColor.UNDERLINE),
            Map.entry("_ITALIC", ChatColor.ITALIC),
            Map.entry("_RESET", ChatColor.RESET)
    );

    public Config(JavaPlugin plugin) {
        plugin.saveDefaultConfig(); // Save the default configuration if had no one.
        FileConfiguration config = plugin.getConfig();

        globalMessageFormat = Fmt.format(
                Objects.requireNonNull(config.getString("global-message-format")),
                CHAT_COLOR_SHEET
        );
        directMessageSenderFormat = Fmt.format(
                Objects.requireNonNull(config.getString("direct-message-sender-format")),
                CHAT_COLOR_SHEET
        );
        directMessageTargetFormat = Fmt.format(
                Objects.requireNonNull(config.getString("direct-message-target-format")),
                CHAT_COLOR_SHEET
        );
    }
}

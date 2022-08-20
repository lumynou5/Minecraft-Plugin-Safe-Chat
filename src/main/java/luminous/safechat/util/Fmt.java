package luminous.safechat.util;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Fmt {
    public static String format(@NotNull String fmt, @NotNull Map<@NotNull String, ?> args) {
        String result = fmt;
        for (var arg : args.entrySet()) {
            if (arg.getValue() == null) continue;

            result = result.replaceAll("\\{" + arg.getKey() + "}", arg.getValue().toString());
        }
        return result;
    }
}

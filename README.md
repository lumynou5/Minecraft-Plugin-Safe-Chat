# Safe Chat

Safe Chat is a Minecraft plugin that protects players' messages.

## Features

The messages will be protected so no one is able to report while enable the plugin.
Because of the way this plugin uses, the game won't mark messages as unverified or unsafe, too.

![Screenshot](https://truth.bahamut.com.tw/s01/202208/2d76aca3213c8848910a35327962c83b.JPG?w=1000)

### Commands

- `reload-config`: Reload the configurations. Needed permission `bukkit.command.reload`.
- `msg`, `tell`, and `w`: (Override vanilla commands) Safe direct chat.

## Configurations

It's able to configure the format of the messages.
When the first time the plugin enabled, it'll automatically generate the configuration file,
you may change it with the description below:

The format may contain strings inside a pair of curly brackets that will be replaced.
The table below shows the general ones.

| Name             | Description                                  |
|------------------|----------------------------------------------|
| `_BLACK`         | Make the following text black.               |
| `_DARK_BLUE`     | Make the following text dark blue.           |
| `_DARK_GREEN`    | Make the following text dark green.          |
| `_DARK_AQUA`     | Make the following text dark aqua.           |
| `_DARK_RED`      | Make the following text dark red.            |
| `_DARK_PURPLE`   | Make the following text dark purple.         |
| `_GOLD`          | Make the following text gold.                |
| `_GRAY`          | Make the following text gray.                |
| `_DARK_GRAY`     | Make the following text dark gray.           |
| `_BLUE`          | Make the following text blue.                |
| `_GREEN`         | Make the following text green.               |
| `_AQUA`          | Make the following text aqua.                |
| `_RED`           | Make the following text red.                 |
| `_LIGHT_PURPLE`  | Make the following text light purple.        |
| `_YELLOW`        | Make the following text yellow.              |
| `_WHITE`         | Make the following text white.               |
| `_MAGIC`         | Make the following text "magic".             |
| `_BOLD`          | Make the following text bold.                |
| `_STRIKETHROUGH` | Make the following text strikethrough.       |
| `_UNDERLINE`     | Make the following text underline.           |
| `_ITALIC`        | Make the following text italic.              |
| `_RESET`         | Set the following text to the default style. |

You can find specific ones for every entry in the generated configuration file.

## Acknowledgements

Thanks [Sapiens_homo](https://gitlab.com/Sapiens_homo), who helped me to test the plugin.

## License

The source code is distributed under the MIT license.
See [LICENSE.md](LICENSE.md) for further information.

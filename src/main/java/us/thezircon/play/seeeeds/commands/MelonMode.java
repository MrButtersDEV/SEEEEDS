package us.thezircon.play.seeeeds.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.thezircon.play.seeeeds.SEEEEDS;

import java.util.List;
import java.util.UUID;

public class MelonMode implements TabExecutor {

    private static final SEEEEDS plugin = SEEEEDS.getPlugin(SEEEEDS.class);

    String msgEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("msgMelonMode.msgEnable"));
    String msgDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("msgMelonMode.msgDisable"));
    String msgNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("msgMelonMode.msgNoPerm"));
    boolean requirePermMelonMode = plugin.getConfig().getBoolean("requirePermMelonMode");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID uuid = player.getUniqueId();

            if (requirePermMelonMode && !player.hasPermission("seeeeds.melonmode")) {
                player.sendMessage(msgNoPerm);
                return false;
            }

            if (plugin.melonmode_list.contains(uuid)) {
                plugin.melonmode_list.remove(uuid);
                player.sendMessage(msgDisable);
            } else if (!plugin.melonmode_list.contains(uuid)) {
                plugin.melonmode_list.add(uuid);
                player.sendMessage(msgEnable);
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}

package us.thezircon.play.seeeeds.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import us.thezircon.play.seeeeds.SEEEEDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class eventBreakBlock implements Listener {

    private static final SEEEEDS plugin = SEEEEDS.getPlugin(SEEEEDS.class);

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Block block = e.getBlock();
        Player player = e.getPlayer();

        List<Material> disabled = Arrays.asList(Material.CACTUS, Material.SUGAR_CANE, Material.BAMBOO);

        if (disabled.contains(block.getType())) {
            return;
        }

        if(block.getBlockData() instanceof Ageable) {
            Ageable crop = (Ageable) block.getBlockData();

           if (crop.getAge() != crop.getMaximumAge() && !e.getPlayer().isSneaking() && plugin.getConfig().getBoolean("enablePrevention")) {
               e.setCancelled(true);
               player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("msgBreakCrop"))));
           }

        }

    }
}
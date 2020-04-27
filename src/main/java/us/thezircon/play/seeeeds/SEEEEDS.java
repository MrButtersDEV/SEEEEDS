package us.thezircon.play.seeeeds;

import org.bukkit.plugin.java.JavaPlugin;
import us.thezircon.play.seeeeds.commands.MelonMode;
import us.thezircon.play.seeeeds.listeners.eventBreakBlock;

import java.util.ArrayList;
import java.util.UUID;

public final class SEEEEDS extends JavaPlugin {

    public ArrayList<UUID> melonmode_list = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig(); // Saves Config.

        //Commands
        getCommand("melonmode").setExecutor(new MelonMode());

        //Listeners
        getServer().getPluginManager().registerEvents(new eventBreakBlock(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

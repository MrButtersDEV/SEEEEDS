package us.thezircon.play.seeeeds;

import org.bukkit.plugin.java.JavaPlugin;
import us.thezircon.play.seeeeds.listeners.eventBreakBlock;

public final class SEEEEDS extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig(); // Saves Config.

        //Listeners
        getServer().getPluginManager().registerEvents(new eventBreakBlock(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

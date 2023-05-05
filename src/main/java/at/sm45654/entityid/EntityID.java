package at.sm45654.entityid;

import at.sm45654.entityid.command.WandCMD;
import at.sm45654.entityid.item.Wand;
import at.sm45654.entityid.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntityID extends JavaPlugin {

    public static String prefix = ColorUtil.LIGHT_GREEN + "[" + ColorUtil.GREEN + "EntityID" + ColorUtil.LIGHT_GREEN + "] ";

    @Override
    public void onEnable() {
        getCommand("wand").setExecutor(new WandCMD());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Wand(), this);


    }

    @Override
    public void onDisable() {
    }
}

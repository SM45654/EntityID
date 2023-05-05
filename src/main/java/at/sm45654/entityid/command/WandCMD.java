package at.sm45654.entityid.command;

import at.sm45654.entityid.EntityID;
import at.sm45654.entityid.item.Wand;
import at.sm45654.entityid.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WandCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if (!(s instanceof Player)) {
            return false;
        }
        if (args.length == 0) {
            s.sendMessage(EntityID.prefix + ColorUtil.RED + "Usage: /wand [name]");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            s.sendMessage(EntityID.prefix + ColorUtil.RED + "Player does not exist or is not online!");
            return false;
        }
            Player p = Bukkit.getPlayer(args[0]);
            s.sendMessage(EntityID.prefix + ColorUtil.LIGHT_GREEN + "EntityID wand given to " + ColorUtil.GREEN + p.getName());
            Wand.getWand(p);

        return false;
    }
}

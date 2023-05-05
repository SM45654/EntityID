package at.sm45654.entityid.item;

import at.sm45654.entityid.EntityID;
import at.sm45654.entityid.util.ColorUtil;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Wand implements Listener {
    public static void getWand(Player p) {

        ItemStack wand = new ItemStack(Material.STICK, 1);
        ItemMeta meta = wand.getItemMeta();
        meta.setDisplayName(ColorUtil.GREEN + "EntityID Wand");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ColorUtil.LIGHT_GREEN + "Right click an entity to get its ID");
        meta.setLore(lore);
        wand.setItemMeta(meta);

    p.getInventory().addItem(wand);
    }




    @EventHandler
    public void onWandUse(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            return;
        }
        if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("EntityID Wand")) {
            return;
        }
        int id = e.getRightClicked().getEntityId();
        EntityType type = e.getRightClicked().getType();
        e.getPlayer().sendMessage(EntityID.prefix + ColorUtil.LIGHT_GREEN + type + "'s ID is: " + ColorUtil.GREEN + id);
    }



}

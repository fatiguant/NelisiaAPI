package fr.nelisia.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;

public class PlayerClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();
        switch (e.getCurrentItem().getType()){

            case DIAMOND_ORE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6FACTION §c§l[MAINTENANCE]")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToLogs(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(16));
                    player.sendMessage("§cerror to load the server faction!");
                }
                break;
            case DIAMOND_HOE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6FARMLAND §c§l[MAINTENANCE]")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToLogs(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(16));
                    player.sendMessage("§cerror to load the server farmland!");
                }
            case STONE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6MINAGE §c§l[MAINTENANCE]")){
                    e.setCancelled(true);
                    player.closeInventory();
                    sendToLogs(e.getCurrentItem().getItemMeta().getDisplayName(), e.getInventory().getName().substring(16));
                    player.sendMessage("§cerror to load the server minage!");
                }
                break;
            default: break;
        }
    }

    private void sendToLogs(String reason, String targetName) {
        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("nelisia.logs")){
                players.sendMessage("§2Logs §8» §fLe joueur §c" + targetName + " §fa essayé de rejoindre un serveur !");
            }
        }
    }
}

package fr.nelisia.core.commands;

import fr.nelisia.core.DatabaseManager.DataManager;
import fr.nelisia.core.Main;
import fr.nelisia.core.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import static org.bukkit.Material.COMMAND;
import static org.bukkit.event.player.PlayerTeleportEvent.*;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(label.equalsIgnoreCase("game")){

            Inventory game = Bukkit.createInventory(null, 9, "§dMenu des jeux");

            game.setItem(0, new ItemBuilder(Material.IRON_AXE).setName("§6FACTION §c§l[MAINTENANCE]").toItemStack());
            game.setItem(1, new ItemBuilder(Material.STONE).setName("§6MINAGE §c§l[MAINTENANCE]").toItemStack());
            game.setItem(2, new ItemBuilder(Material.DIAMOND_HOE).setName("§6FARMLAND §c§l[MAINTENANCE]").toItemStack());

            player.openInventory(game);
        }
        return false;
    }
}

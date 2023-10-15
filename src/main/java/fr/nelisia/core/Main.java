package fr.nelisia.core;


import fr.nelisia.core.DatabaseManager.DataManager;
import fr.nelisia.core.DatabaseManager.TeamTags;
import fr.nelisia.core.commands.Commands;
import fr.nelisia.core.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(this, this);
        getCommand("game").setExecutor(new Commands());

    }

    public void HotbarItem(String hotbarManager, Material item, int slot, int key) {
        this.hotbarManager = hotbarManager;
        this.key = String.valueOf(key);
        this.slot = slot;

    }

    private int slot;
    private ItemStack item;
    private String key;
    private String hotbarManager;

    public ItemStack getItem() {
        return item;
    }

    public int getSlot() {
        return slot;
    }

    public void giveItem(Player player) {
        ItemStack newItem = null;
        player.getInventory().setItem(slot, newItem);
    }

    public void ItemDelete(Player player) {
        PlayerInventory inventory = player.getInventory();
        ItemStack item = inventory.getItem(slot);
        inventory.remove(inventory.getItem(slot));
    }




    @EventHandler
    public void LeaveTheServer(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("");
        p.closeInventory();
    }

    private static void ItemDelete() {
    }


    @EventHandler
    public void rankDonate(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Player player = e.getPlayer();
        DataManager playerDB = new DataManager(p.getUniqueId());
        e.setJoinMessage("");
        p.setGameMode(GameMode.ADVENTURE);
        p.closeInventory();
        p.setOp(false);
        player.getInventory().clear();
        player.getEquipment().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.teleport(new Location(player.getWorld(),1572.5, 130.9, 601.4));
        player.sendMessage("§6§m------------------------------------");
        player.sendMessage("§fBienvenue §b" + DataManager.getNickname() + "§f sur le serveur ! ");
        player.sendMessage("§6§m------------------------------------");
        ItemStack games = new ItemBuilder(Material.COMPASS).setName("§dCarte du voyageur").toItemStack();
        player.getInventory().setItem(4, games);
        player.updateInventory();
        PlayerInventory inventory = player.getInventory();
        if(DataManager.getRank() != null) {
            if(DataManager.getRank().equals("Admin")) {
                player.setOp(true);
                if(DataManager.getMod().equals("true")) {
                    player.sendMessage("§4Avertissement: §cVous êtes toujours en mode modération !");
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setOp(true);
                }
                if(DataManager.getMod().equals("false")) {
                    player.setOp(true);
                    Bukkit.broadcastMessage("§5§l✦ §cAdmin " + DataManager.getNickname() + " §ea rejoint le lobby !");
                }
            }
            if(DataManager.getRank().equals("Responsable")) {
                player.setOp(true);
                if(DataManager.getMod().equals("true")) {
                    player.setOp(true);
                    player.sendMessage("§4Avertissement: §cVous êtes toujours en mode modération !");
                    player.setGameMode(GameMode.SPECTATOR);
                }
                if(DataManager.getMod().equals("false")) {
                    player.setOp(true);
                    Bukkit.broadcastMessage("§5§l✦ §6Responsable " + DataManager.getNickname() + " §ea rejoint le lobby !");
                }
            }
            if(DataManager.getRank().equals("Développeur")) {
                player.setOp(true);
                if(DataManager.getMod().equals("true")) {
                    player.setOp(true);
                    player.sendMessage("§4Avertissement: §cVous êtes toujours en mode modération !");
                    player.setGameMode(GameMode.SPECTATOR);
                }
                if(DataManager.getMod().equals("false")) {
                    player.setOp(true);
                    Bukkit.broadcastMessage("§5§l✦ §2Développeur " + player.getName() + " §ea rejoint le lobby !");
                }
            }
            if(DataManager.getRank().equals("SuperModo")) {
                player.setOp(false);
                if(DataManager.getMod().equals("true")) {
                    player.sendMessage("§4Avertissement: §cVous êtes toujours en mode modération !");
                    player.setGameMode(GameMode.SPECTATOR);
                }
                if(DataManager.getMod().equals("false")) {
                    Bukkit.broadcastMessage("§5§l✦ §cSuperModo " + DataManager.getNickname() + " §ea rejoint le lobby !");
                }
            }
            if(DataManager.getRank().equals("Modo")) {
                player.setOp(false);
                if(DataManager.getMod().equals("true")) {
                    player.sendMessage("§4Avertissement: §cVous êtes toujours en mode modération !");
                    player.setGameMode(GameMode.SPECTATOR);
                }
                if(DataManager.getMod().equals("false")) {
                    Bukkit.broadcastMessage("§5§l✦ §cModo " + DataManager.getNickname() + " §ea rejoint le lobby !");
                }
            }
            if(DataManager.getRank().equals("Helper")) {
                player.setOp(false);
                Bukkit.broadcastMessage("§5§l✦ §9Helper " + DataManager.getNickname() + " §ea rejoint le lobby !");
            }
            if(DataManager.getRank().equals("Youtuber")) {
                player.setOp(false);
                Bukkit.broadcastMessage("§5§l✦ §6Youtuber " + player.getName() + " §ea rejoint le lobby !");
            }
            if(DataManager.getRank().equals("Streamer")) {
                player.setOp(false);
                Bukkit.broadcastMessage("§5§l✦ §5Streamer " + player.getName() + " §ea rejoint le lobby !");
            }
            if(DataManager.getRank().equals("TikToker")) {
                player.setOp(false);
                Bukkit.broadcastMessage("§5§l✦ §fTik§cTok§f " + player.getName() + " §ea rejoint le lobby !");
            }
        }

        if(DataManager.getRank() != null) {
            p.setCustomNameVisible(true);

            String rankPower = "";
            String rankPrefix = "";
            if(DataManager.getRank().equals("Admin")) {
                rankPower = "A";
                rankPrefix = "§cAdmin ";
            } else if(DataManager.getRank().equals("SuperModo")) {
                rankPower = "B";
                rankPrefix = "§cSuperModo ";
            } else if(DataManager.getRank().equals("Développeur")) {
                rankPower = "C";
                rankPrefix = "§2Développeur ";
            } else if(DataManager.getRank().equals("SuperModo2")) {
                rankPower = "D";
                rankPrefix = "§cAdmin ";
            } else if(DataManager.getRank().equals("Modo")) {
                rankPower = "E";
                rankPrefix = "§cModo ";
            } else if(DataManager.getRank().equals("Helper")) {
                rankPower = "F";
                rankPrefix = "§9Helper §9";
            } else if(DataManager.getRank().equals("Youtuber")) {
                rankPower = "G";
                rankPrefix = "§6Youtuber ";
            } else if(DataManager.getRank().equals("Streamer")) {
                rankPower = "G";
                rankPrefix = "§5Streamer ";
            } else if(DataManager.getRank().equals("Tiktoker")) {
                rankPower = "G";
                rankPrefix = "§fTik§cTok§f ";
            } else if(DataManager.getRank().equals("Empereur")) {
                rankPower = "H";
                rankPrefix = "§6Empereur ";
            } else if(DataManager.getRank().equals("Joueur")) {
                rankPower = "X";
                rankPrefix = "§7Joueur ";
            }
            TeamTags.setNameTag(p, rankPower, rankPrefix);
            p.setCustomName(rankPrefix + DataManager.getNickname());
            p.setPlayerListName(rankPrefix + DataManager.getNickname());
        } else {
            playerDB.setNickname(p.getName());
            playerDB.setRank("Joueur");
            playerDB.setCoins(0.0);
            playerDB.setGems(0);
            playerDB.setMod("false");

            TeamTags.setNameTag(p, "O", "§7Joueur ");
            p.setCustomName("§7Joueur " + DataManager.getNickname());
            p.setPlayerListName("§7Joueur " + DataManager.getNickname());
        }
    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        DataManager playerDB = new DataManager(p.getUniqueId());

        String rankPrefix = "";
        if(DataManager.getRank().equals("Admin")) {
            rankPrefix = "§cAdmin ";
        } else if(DataManager.getRank().equals("Responsable")) {
            rankPrefix = "§6Responsable ";
        } else if(DataManager.getRank().equals("Développeur")) {
            rankPrefix = "§2Développeur ";
        } else if(DataManager.getRank().equals("SuperModo")) {
            rankPrefix = "§cSuperModo ";
        } else if(DataManager.getRank().equals("Modo")) {
            rankPrefix = "§cModo ";
        } else if(DataManager.getRank().equals("Helper")) {
            rankPrefix = "§9Helper §9";
        } else if(DataManager.getRank().equals("Youtuber")) {
            rankPrefix = "§6Youtuber ";
        } else if(DataManager.getRank().equals("Streamer")) {
            rankPrefix = "§5Streamer ";
        } else if(DataManager.getRank().equals("Tiktoker")) {
            rankPrefix = "§fTik§cTok§f ";
        } else if(DataManager.getRank().equals("Empereur")) {
            rankPrefix = "§6Empereur ";
        } else if(DataManager.getRank().equals("Joueur")) {
            rankPrefix = "§7Joueur ";
        }
        if(DataManager.getMod().equals("true")) {
            e.setFormat(rankPrefix + DataManager.getNickname() + " §8» §e" + e.getMessage());
        }
        if(DataManager.getMod().equals("false")) {
            e.setFormat(rankPrefix + DataManager.getNickname() + " §8» §f" + e.getMessage());
        }
    }

    public static String getPrefix() {
        return "§aNelisia §7»";
    }
}

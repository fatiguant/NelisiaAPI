package fr.nelisia.core.DatabaseManager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataManager {

    private UUID uuid;
    public static File file;
    private static FileConfiguration configFile;

    public DataManager(UUID uuid) {
        this.uuid = uuid;
        setupPlayerFile();
    }

    private void setupPlayerFile() {
        file = new File("../../../DataBase/Players/" + uuid + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void savePlayerFile() {
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setNickname(String name) { // set une variable
        configFile.set("Nickname", name);
        savePlayerFile();
    }
    public void setRank(String rank) { // set une variable
        configFile.set("Rank", rank);
        savePlayerFile();
    }

    public static void setCoins(double coins) {
        configFile.set("Coins", coins);
        savePlayerFile();
    }
    public void setGems(double gems) {
        configFile.set("Gems", gems);
        savePlayerFile();
    }

    public static void setMod(String mod) {
        configFile.set("Mod", mod);
        savePlayerFile();
    }

    public void optFriendRequest(String frequest) {
        configFile.set("OptionsFriendRequest", frequest);
    }
    public void optPrivateMessage(String pm) {
        configFile.set("OptionsPrivateMessage", pm);
    }

    public static String getNickname() {
        return configFile.getString("Nickname");
    }
    public static String getRank() {
        return configFile.getString("Rank");
    }
    public static int getCoins() {
        return configFile.getInt("Coins");
    }
    public static int getGems() {
        return configFile.getInt("Gems");
    }
    public static String getMod() {
        return configFile.getString("Mod");
    }

    public String getOptFR() {
        return configFile.getString("OptionsFriendRequest");
    }
    public String getOptPM() {
        return configFile.getString("OptionsPrivateMessage");
    }

}
package com.minestein.novauniverse.menu.main;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ServerSelectionMenuInNavigator {

    public enum Server {
        SG("Survival Games", "sg"),

        BMT("Build my Thing", "buildmything"),

        UHC("Ultra-Hardcore", "uhc"),

        LINES("Lines Survival", "lines"),

        BATTLE_ROYALE("Battle Royale", "battleroyale"),

        SPLEEF("Spleef", "spleef"),

        FREERUNNERS("Freerunners", "freerunners"),

        TNT_RUN("TNT Run", "tntrun"),

        BLOCKING_DEAD("Blocking Dead", "blockingdead"),

        WATCH_WOLVES("Watch_Wolves", "watchwolves"),

        GRAND_THEFT_MINECART("GTM", "gtm");

        String serverType;
        String cover;

        public String getCover() {
            return cover;
        }

        public String getServerType() {
            return serverType;
        }

        public String getServer(int serverID) {
            return this.serverType.concat(String.valueOf(serverID));
        }

        Server(String cover, String serverType) {
            this.cover = cover;
            this.serverType = serverType;
        }
    }

    public static ItemStack getPlaceholder() {
        ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            i.setItemMeta(m);
        }
        return i;
    }

    public static Inventory getInventory(Server server) {
        Inventory i = Bukkit.createInventory(null, 54, "§b§l>> §r"+server.getCover()+" §b§l<<");
        i.setItem(4, getRepresentative(server));

        for (int counter = 0; counter < 54; counter++) {
            if (i.getItem(counter)!=null) continue;
            if (counter >= 10 && counter <= 43) {
                if (counter == 18 || counter == 27 || counter == 36 || counter == 45 || counter == 17 || counter == 26 || counter == 35 || counter == 44) {
                    i.setItem(counter, getPlaceholder());
                    continue;
                }

                continue;
            }

            i.setItem(counter, getPlaceholder());
        }

        return i;
    }

    private static ItemStack createItem(Material mat, char colorcode,  String name, String... lore) {
        ItemStack i = new ItemStack(mat); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§"+colorcode+"§l"+name);
            m.setLore(Arrays.asList(lore));
            i.setItemMeta(m);
        }
        return i;
    }

    public static ItemStack getRepresentative(Server server) {
        char[] validColorcodes = new char[] {
            'c',
            '9',
            'a',
            'e',
            '6',
            'f',
            'd'
        };

        switch (server) {
            case SG:
                return createItem(Material.IRON_SWORD, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Survival Games", "§5PvP Deathmatch", "§7§o- 24 players", "§7§o- Awesome arenas", "§7§o- Epic battles", "§7§o- Much amaze");
            case BMT:
                return createItem(Material.WOOL, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Build my Thing", "§5Building Point-based", "§7§o- 6 players", "§7§o- Random/wacky words", "§7§o- Epic creations", "§7§o- Much fun");
            case UHC:
                return createItem(Material.ROTTEN_FLESH, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Ultra-Hardcore", "§5PvP Team-Deathmatch", "§7§o- 12 players", "§7§o- Two teams", "§7§o- Survival-style", "§7§o- So amaze");
            case LINES:
                return createItem(Material.GRASS, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Lines Survival", "§5PvP Survival", "§7§o- 6 players", "§7§o- Shrinking arena", "§7§oDefense-based", "§7§o- So amazeballs");
            case BATTLE_ROYALE:
                return createItem(Material.DIAMOND_AXE, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Battle Royale", "§5PvP Rounds", "§7§o- 12 players", "§7§o- 3 rounds", "§7§o1v1 battles", "§7§oHuge weapon selection");
            case SPLEEF:
                return createItem(Material.SNOW_BALL, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Spleef", "§5Last standing", "§7§o- 6 players", "§7§o- Multiple shovels", "§7§o- Different powers");
            case TNT_RUN:
                return createItem(Material.TNT, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "TNT Run");
            default:
                return null;
        }
    }
}

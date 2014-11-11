package com.minestein.novauniverse.menu.main;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ServerSelectionMenuInNavigator {

    public enum Server {
        SG("Survival Games", "sg", 24),

        BMT("Build my Thing", "buildmything", 6),

        UHC("Ultra-Hardcore", "uhc", 12),

        LINES("Lines Survival", "lines", 6),

        BATTLE_ROYALE("Battle Royale", "battleroyale", 12),

        SPLEEF("Spleef", "spleef", 6),

        FREERUNNERS("Freerunners", "freerunners", 12),

        TNT_RUN("TNT Run", "tntrun", 6),

        BLOCKING_DEAD("Blocking Dead", "blockingdead", 100),

        WATCH_WOLVES("Watch_Wolves", "watchwolves", 100),

        GRAND_THEFT_MINECART("GTM", "gtm", 100);

        String serverType;
        String cover;
        int playersAllowed;

        public String getCover() {
            return cover;
        }

        public String getServerType() {
            return serverType;
        }

        public String getServer(int serverID) {
            return this.serverType.concat(String.valueOf(serverID));
        }

        public int getPlayersAllowed() {
            return playersAllowed;
        }

        Server(String cover, String serverType, int playersAllowed) {
            this.cover = cover;
            this.serverType = serverType;
            this.playersAllowed = playersAllowed;
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
        HashMap<Integer, Integer> spacing = new HashMap<>();
        spacing.put(10, 1);
        spacing.put(11, 2);
        spacing.put(12, 3);
        spacing.put(13, 4);
        spacing.put(14, 5);
        spacing.put(15, 6);
        spacing.put(16, 7);
        spacing.put(19, 8);
        spacing.put(20, 9);
        spacing.put(21, 10);
        spacing.put(22, 11);
        spacing.put(23, 12);
        spacing.put(24, 13);
        spacing.put(25, 14);
        spacing.put(28, 15);
        spacing.put(29, 16);
        spacing.put(30, 17);
        spacing.put(31, 18);
        spacing.put(32, 19);
        spacing.put(33, 20);
        spacing.put(34, 21);
        spacing.put(37, 22);
        spacing.put(38, 23);
        spacing.put(39, 24);
        spacing.put(40, 25);
        spacing.put(41, 26);
        spacing.put(42, 27);
        spacing.put(43, 28);

        // 16

        Inventory i = Bukkit.createInventory(null, 54, "§b§l>> §r"+server.getCover()+" §b§l<<");
        i.setItem(4, getRepresentative(server));

        for (int counter = 0; counter < 54; counter++) {
            if (i.getItem(counter)!=null) continue;
            if (counter >= 10 && counter <= 43) {
                if (counter == 18 || counter == 27 || counter == 36 || counter == 45 || counter == 17 || counter == 26 || counter == 35 || counter == 44) {
                    i.setItem(counter, getPlaceholder());
                    continue;
                } else {
                    for (Integer keys : spacing.keySet()) {
                        i.setItem(keys, getServerStatus(server, spacing.get(keys)));
                    }
                }
            }

            if (counter >= 10 && counter <= 43) continue;

            i.setItem(counter, getPlaceholder());
        }

        return i;
    }

    public static ItemStack getServerStatus(Server server, int serverID) {
        ItemStack i = new ItemStack(Material.THIN_GLASS); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§a§l"+server.getCover()+"-"+serverID);
            m.setLore(Arrays.asList("§c§l§nOffline", " §rPlayers: §a§l0§8/§a§l"+server.getPlayersAllowed()));
            i.setItemMeta(m);
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
            case BLOCKING_DEAD:
                return createItem(Material.ROTTEN_FLESH, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Blocking Dead");
            case GRAND_THEFT_MINECART:
                return createItem(Material.MINECART, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Grand Theft Minecart");
            case WATCH_WOLVES:
                return createItem(Material.IRON_INGOT, validColorcodes[Main.getRandom().nextInt(validColorcodes.length)], "Watch_Wolves");
            default:
                return null;
        }
    }
}

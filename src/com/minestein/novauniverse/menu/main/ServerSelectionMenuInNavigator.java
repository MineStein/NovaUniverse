package com.minestein.novauniverse.menu.main;

import com.minestein.novauniverse.Main;
import net.minecraft.server.v1_7_R4.PathfinderGoalLookAtPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
public class ServerSelectionMenuInNavigator implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {
        Inventory i = e.getInventory();

        if (!i.getName().startsWith("§b§l>>")) return;
        if (e.getCurrentItem()==null) return;

        boolean hasBack;

        if (i.contains(getBack())) {
            hasBack = true;
        } else {
            hasBack = false;
        }

        e.setCancelled(true);

        if (e.getCurrentItem().getType().equals(Material.GOLDEN_CARROT)) {
            if (i.getName().contains("[1/2]")) {
                String title = i.getName();
                Player p = (Player) e.getWhoClicked();

                p.closeInventory();
                if (title.contains("Spleef")) {
                    p.openInventory(getInventory(Server.SPLEEF, 2, hasBack));
                } else if (title.contains("TNT Run")) {
                    p.openInventory(getInventory(Server.TNT_RUN, 2, hasBack));
                } else if (title.contains("Freerunners")) {
                    p.openInventory(getInventory(Server.FREERUNNERS, 2, hasBack));
                } else if (title.contains("Survival Games")) {
                    p.openInventory(getInventory(Server.SG, 2, hasBack));
                } else if (title.contains("Build my Thing")) {
                    p.openInventory(getInventory(Server.BMT, 2, hasBack));
                } else if (title.contains("Ultra-Hardcore")) {
                    p.openInventory(getInventory(Server.UHC, 2, hasBack));
                } else if (title.contains("Lines Survival")) {

                } else if (title.contains("Battle Royale")) {

                } else if (title.contains("Blocking Dead")) {

                } else if (title.contains("Watch_Wolves")) {

                } else if (title.contains("GTM")) {

                }
            } else {

            }
        }

        if (e.getCurrentItem().getType().equals(Material.INK_SACK)) {
            String title = i.getName();

            if (title.contains("Survival Games") || title.contains("Build my Thing") || title.contains("Ultra-Hardcore") || title.contains("Lines Survival")
                    || title.contains("Battle Royale")) {
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().openInventory(MainGamemodeInNavigator.getInventory(((Player) e.getWhoClicked())));
            } else if (title.contains("Spleef") || title.contains("Freerunners") || title.contains("TNT Run")) {
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().openInventory(ArcadeGamemodeInNavigator.getInventory(((Player) e.getWhoClicked())));
            } else if (title.contains("Blocking Dead") || title.contains("Watch_Wolves") || title.contains("GTM")) {
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().openInventory(GamemodeGamemodeInNavigator.getInventory(((Player) e.getWhoClicked())));
            }
        }
    }

    enum Category {
        MAIN,

        ARCADE,

        GAMEMODE;
    }

    public enum Server {
        SG("SG", "sg", 24, Category.MAIN),

        BMT("BMT", "buildmything", 6, Category.MAIN),

        UHC("UHC", "uhc", 12, Category.MAIN),

        LINES("Lines", "lines", 6, Category.MAIN),

        BATTLE_ROYALE("Royale", "battleroyale", 12, Category.MAIN),

        SPLEEF("Spleef", "spleef", 6, Category.ARCADE),

        FREERUNNERS("FR", "freerunners", 12, Category.ARCADE),

        TNT_RUN("TR", "tntrun", 6, Category.ARCADE),

        BLOCKING_DEAD("BD", "blockingdead", 100, Category.GAMEMODE),

        WATCH_WOLVES("WW", "watchwolves", 100, Category.GAMEMODE),

        GRAND_THEFT_MINECART("GTM", "gtm", 100, Category.GAMEMODE);

        String serverType;
        String cover;
        int playersAllowed;
        Category cat;

        public Category getCat() {
            return cat;
        }

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

        Server(String cover, String serverType, int playersAllowed, Category cat) {
            this.cover = cover;
            this.serverType = serverType;
            this.playersAllowed = playersAllowed;
            this.cat = cat;
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

    public static Inventory getInventory(Server server, int page, boolean withBack) {
        HashMap<Integer, Integer> spacingPg1 = new HashMap<>();
        spacingPg1.put(10, 1);
        spacingPg1.put(11, 2);
        spacingPg1.put(12, 3);
        spacingPg1.put(13, 4);
        spacingPg1.put(14, 5);
        spacingPg1.put(15, 6);
        spacingPg1.put(16, 7);
        spacingPg1.put(19, 8);
        spacingPg1.put(20, 9);
        spacingPg1.put(21, 10);
        spacingPg1.put(22, 11);
        spacingPg1.put(23, 12);
        spacingPg1.put(24, 13);
        spacingPg1.put(25, 14);
        spacingPg1.put(28, 15);
        spacingPg1.put(29, 16);
        spacingPg1.put(30, 17);
        spacingPg1.put(31, 18);
        spacingPg1.put(32, 19);
        spacingPg1.put(33, 20);
        spacingPg1.put(34, 21);
        spacingPg1.put(37, 22);
        spacingPg1.put(38, 23);
        spacingPg1.put(39, 24);
        spacingPg1.put(40, 25);
        spacingPg1.put(41, 26);
        spacingPg1.put(42, 27);
        spacingPg1.put(43, 28);

        HashMap<Integer, Integer> spacingPg2 = new HashMap<>();
        spacingPg2.put(10, 29);
        spacingPg2.put(11, 30);
        spacingPg2.put(12, 31);
        spacingPg2.put(13, 32);
        spacingPg2.put(14, 33);
        spacingPg2.put(15, 34);
        spacingPg2.put(16, 35);
        spacingPg2.put(19, 36);
        spacingPg2.put(20, 37);
        spacingPg2.put(21, 38);
        spacingPg2.put(22, 39);
        spacingPg2.put(23, 40);
        spacingPg2.put(24, 41);
        spacingPg2.put(25, 42);
        spacingPg2.put(28, 43);
        spacingPg2.put(29, 44);
        spacingPg2.put(30, 45);
        spacingPg2.put(31, 46);
        spacingPg2.put(32, 47);
        spacingPg2.put(33, 48);
        spacingPg2.put(34, 49);
        spacingPg2.put(37, 50);
        spacingPg2.put(38, 51);
        spacingPg2.put(39, 52);
        spacingPg2.put(40, 53);
        spacingPg2.put(41, 54);
        spacingPg2.put(42, 55);
        spacingPg2.put(43, 56);

        // 16

        Inventory i;

        if (page==1) {
            i = Bukkit.createInventory(null, 54, "§b§l>> §r"+server.getCover()+" §7[1/2] §b§l<<");
        } else {
            i = Bukkit.createInventory(null, 54, "§b§l>> §r"+server.getCover()+" §7[2/2] §b§l<<");
        }

        i.setItem(4, getRepresentative(server));

        HashMap<Integer, Integer> currentMap;

        if (page==1) {
            currentMap = spacingPg1;
        } else {
            currentMap = spacingPg2;
        }

        for (int counter = 0; counter < 54; counter++) {
            if (counter==0 && withBack) {
                i.setItem(counter, getBack());
            }

            if (counter==8) {
                i.setItem(counter, getNextPage());
            }

            if (i.getItem(counter)!=null) continue;
            if (counter >= 10 && counter <= 43) {
                if (counter == 18 || counter == 27 || counter == 36 || counter == 45 || counter == 17 || counter == 26 || counter == 35 || counter == 44) {
                    i.setItem(counter, getPlaceholder());
                    continue;
                } else {
                    for (Integer keys : currentMap.keySet()) {
                        i.setItem(keys, getServerStatus(server, currentMap.get(keys)));
                    }
                }
            }

            if (counter >= 10 && counter <= 43) continue;

            i.setItem(counter, getPlaceholder());
        }

        return i;
    }

    public static ItemStack getNextPage() {
        ItemStack i = new ItemStack(Material.GOLDEN_CARROT); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§c§lNext Page");
            m.setLore(Arrays.asList("§5§oGo to the next", "§5§opage of servers!"));
            i.setItemMeta(m);
        }
        return i;
    }

    public static ItemStack getBack() {
        ItemStack i = new ItemStack(Material.INK_SACK, 1, (byte) 1); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§c§lBACK");
            m.setLore(Arrays.asList("§5§oGo back to the", "§5§omain server menu."));
            i.setItemMeta(m);
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

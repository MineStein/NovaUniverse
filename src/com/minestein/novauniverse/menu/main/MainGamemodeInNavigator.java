package com.minestein.novauniverse.menu.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Random;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MainGamemodeInNavigator {

    public static Inventory getInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "§e§l>> §rMain Gamemodes");

        inventory.setItem(10, getPlayerInfo(player));
        inventory.setItem(12, getRepresentative());
        inventory.setItem(13, getArcadeRepresentative());
        inventory.setItem(14, getStandaloneGamemodes());
        inventory.setItem(16, getPlayerInfo(player));
        inventory.setItem(30, getSG(Mode.PLAY));
        inventory.setItem(31, getBMT(Mode.PLAY));
        inventory.setItem(32, getUHC(Mode.PLAY));
        inventory.setItem(39, getLines(Mode.PLAY));
        inventory.setItem(40, getRoyale(Mode.PLAY));

        for (int i = 0; i < 54; i++) {
            if (i == 39 || i == 40 || i == 41) continue;
            if (inventory.getItem(i) != null) continue;

            inventory.setItem(i, getPlaceholder());
        }

        return inventory;
    }

    /*public static Inventory getInventory(Player player) {
        Inventory inventory;

        inventory = Bukkit.createInventory(null, 54, "§e§l>> §rWhere to? (M)");

        inventory.setItem(0, getPlaceholder());
        inventory.setItem(1, getPlayerInfo(player));
        inventory.setItem(2, getPlaceholder());
        inventory.setItem(3, getArcadeRepresentative());
        inventory.setItem(4, getRepresentative());
        inventory.setItem(5, getStandaloneGamemodes());
        for (int i = 6; i < 27; i++) {
            inventory.setItem(i, getPlaceholder());
        }
        for (int i = 27; i < 48; i++) {
            inventory.setItem(i, getPlaceholder());
        }
        inventory.setItem(48, getSG(Mode.PLAY));
        inventory.setItem(49, getBMT(Mode.PLAY));
        inventory.setItem(50, getUHC(Mode.PLAY));
        for (int i = 51; i < 54; i++) {
            inventory.setItem(i, getPlaceholder());
        }

        return inventory;
    }
    */

    public static ItemStack getRoyale(Mode mode) {
        ItemStack i = new ItemStack(Material.DIAMOND_AXE);
        {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§d§lBATTLE ROYALE");
            m.setLore(makeLore(mode, "Fight against other players", "in 3 grueling rounds of epic PvP combat!", "6 players"));
            i.setItemMeta(m);
        }
        return i;
    }

    public static ItemStack getLines(Mode mode) {
      ItemStack i = new ItemStack(Material.GRASS);
        {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§d§lLINES SURVIVAL");
            m.setLore(makeLore(mode, "Fight against 4 players and gather", "resources in an ever-shrinking arena!", "4 players"));
            i.setItemMeta(m);
        }

        return i;
    }

    public static ItemStack getPlayerInfo(Player player) {
        ItemStack playerInfo = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
        {
            SkullMeta m = (SkullMeta) playerInfo.getItemMeta();
            m.setOwner(player.getName());
            m.setDisplayName("§e§lPROFILE & INFO");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§bName§8: §e§l" + player.getName().toUpperCase());
            if (player.isOp()) {
                lore.add("§bRank§8: §c§lStaff");
            } else {
                lore.add("§bRank§8: §e§lDefault");
            }
            lore.add("§bNovites§8: §e§l100");
            m.setLore(lore);
            playerInfo.setItemMeta(m);
        }

        return playerInfo;
    }

    public static ItemStack getRepresentative() {
        ItemStack representative = new ItemStack(Material.INK_SACK, 1, (byte) 10);
        {
            ItemMeta m = representative.getItemMeta();
            m.setDisplayName("§a§lMAIN GAMES");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§dFun gamemodes that last for");
            lore.add("§dover twenty minutes!");
            lore.add("");
            lore.add("§a§lCLICK §7to open!");
            m.setLore(lore);
            representative.setItemMeta(m);
        }

        return representative;
    }

    public static ItemStack getArcadeRepresentative() {
        ItemStack arcadeRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        {
            ItemMeta m = arcadeRepresentative.getItemMeta();
            m.setDisplayName("§7§lARCADE GAMES");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§dShort but sweet gamemodes");
            lore.add("§dthat don't last long!");
            lore.add("");
            lore.add("§a§lCLICK §7to open!");
            m.setLore(lore);
            arcadeRepresentative.setItemMeta(m);
        }

        return arcadeRepresentative;
    }

    public static ItemStack getStandaloneGamemodes() {
        ItemStack standaloneRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        {
            ItemMeta m = standaloneRepresentative.getItemMeta();
            m.setDisplayName("§7§lSTANDALONE GAMEMODES");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§dFull on gamemodes that");
            lore.add("§dnever end!");
            lore.add("");
            lore.add("§a§lCLICK §7to open!");
            m.setLore(lore);
            standaloneRepresentative.setItemMeta(m);
        }

        return standaloneRepresentative;
    }

    public static ItemStack getSG(Mode mode) {
        ItemStack sg = new ItemStack(Material.IRON_SWORD);
        {
            ItemMeta m = sg.getItemMeta();
            m.setDisplayName("§d§lSURVIVAL GAMES");
            m.setLore(makeLore(mode, "Fight for your life against 24 other", "players in a deathmatch-style arena!", "2 players"));
            sg.setItemMeta(m);
        }

        return sg;
    }

    public static ItemStack getBMT(Mode mode) {
        ItemStack bmt = new ItemStack(Material.WOOL, 1, (byte) new Random().nextInt(15));
        {
            ItemMeta m = bmt.getItemMeta();
            m.setDisplayName("§d§lBUILD MY THING");
            m.setLore(makeLore(mode, "Guess the word? Build the thing? ", "This is an instant hit to any player!", "2 players"));
            bmt.setItemMeta(m);
        }

        return bmt;
    }

    public static ItemStack getUHC(Mode mode) {
        ItemStack uhc = new ItemStack(Material.ROTTEN_FLESH);
        {
            ItemMeta m = uhc.getItemMeta();
            m.setDisplayName("§d§lULTRA-HARDCORE");
            m.setLore(makeLore(mode, "Fight in an ultra-hard scenario against", "equally tough players and environment dangers!", "12 players"));
            uhc.setItemMeta(m);
        }

        return uhc;
    }

    public static ItemStack getPlaceholder() {
        ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
        {
            ItemMeta m = placeholder.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            placeholder.setItemMeta(m);
        }

        return placeholder;
    }

    private static ArrayList<String> makeLore(Mode mode, String summary1, String summary2, String requirement) {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§e§lDESCRIPTION§8: §d" + summary1);
        lore.add("§d" + summary2);
        lore.add("§e§lREQUIREMENT§8: §d" + requirement);
        lore.add("");
        if (mode == Mode.PLAY) {
            lore.add("§a§lCLICK §7to play!");
        } else {
            lore.add("§a§lCLICK §7for info!");
        }

        return lore;
    }
}

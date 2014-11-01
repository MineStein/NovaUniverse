package com.minestein.novauniverse.menu.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ArcadeGamemodeInNavigator {

    private static ItemStack tntrun;
    private static ItemStack spleef;
    private static ItemStack freerunners;
    private static ItemStack placeholder;
    private static ItemStack representative;
    private static ItemStack arcadeRepresentative;
    private static ItemStack standaloneRepresentative;

    public static Inventory getInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "§e§l>> §rArcade");

        inventory.setItem(10, MainGamemodeInNavigator.getPlayerInfo(player));
        inventory.setItem(12, getMainGamesRepresentative());
        inventory.setItem(13, getRepresentative());
        inventory.setItem(14, getStandaloneGamemodes());
        inventory.setItem(16, MainGamemodeInNavigator.getPlayerInfo(player));
        inventory.setItem(30, getSpleef(Mode.PLAY));
        inventory.setItem(31, getFreerunners(Mode.PLAY));
        inventory.setItem(32, getTntrun(Mode.PLAY));

        for (int i = 0; i < 54; i++) {
            if (inventory.getItem(i) != null) continue;

            inventory.setItem(i, getPlaceholder());
        }

        return inventory;
    }

    public static ItemStack getTntrun(Mode mode) {
        tntrun = new ItemStack(Material.TNT);
        {
            ItemMeta m = tntrun.getItemMeta();
            m.setDisplayName("§d§lTNT Run");
            m.setLore(makeLore(mode, "Run and leap across treacherous jumps", "and be the last on standing in this game!", "2 players"));
            tntrun.setItemMeta(m);
        }

        return tntrun;
    }

    public static ItemStack getFreerunners(Mode mode) {
        freerunners = new ItemStack(Material.FEATHER);
        {
            ItemMeta m = freerunners.getItemMeta();
            m.setDisplayName("§d§lFreerunners");
            m.setLore(makeLore(mode, "Climb, jump, and skip across the rooftops", "of a city in this parkour-style game!!", "2 players"));
            freerunners.setItemMeta(m);
        }

        return freerunners;
    }

    public static ItemStack getSpleef(Mode mode) {
        spleef = new ItemStack(Material.SNOW_BALL);
        {
            ItemMeta m = spleef.getItemMeta();
            m.setDisplayName("§d§lSpleef");
            m.setLore(makeLore(mode, "Dig holes in the snow and ice to stop your", "opponents in this shivering game!", "2 players"));
            spleef.setItemMeta(m);
        }

        return spleef;
    }

    public static ItemStack getMainGamesRepresentative() {
        representative = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        {
            ItemMeta m = representative.getItemMeta();
            m.setDisplayName("§7§lMAIN GAMES");
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

    public static ItemStack getRepresentative() {
        arcadeRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 10);
        {
            ItemMeta m = arcadeRepresentative.getItemMeta();
            m.setDisplayName("§a§lARCADE GAMES");
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
        standaloneRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 8);
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

    public static ItemStack getPlaceholder() {
        placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
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

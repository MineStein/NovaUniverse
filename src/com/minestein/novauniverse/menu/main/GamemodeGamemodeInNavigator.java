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
public class GamemodeGamemodeInNavigator {

    private static ItemStack placeholder;
    private static ItemStack representative;
    private static ItemStack arcadeRepresentative;
    private static ItemStack standaloneRepresentative;
    private static ItemStack watchWolves;
    private static ItemStack grandTheftMinecart;
    private static ItemStack blockingDead;

    public static Inventory getInventory(Player player) {
        Inventory inventory;

        inventory = Bukkit.createInventory(null, 54, "§e§l>> §rWhere to? (G)");

        inventory.setItem(0, getPlaceholder());
        inventory.setItem(1, MainGamemodeInNavigator.getPlayerInfo(player));
        inventory.setItem(2, getPlaceholder());
        inventory.setItem(3, getArcadeRepresentative());
        inventory.setItem(4, getMainRepresentative());
        inventory.setItem(5, getRepresentative());
        for (int i = 6; i < 27; i++) {
            inventory.setItem(i, getPlaceholder());
        }
        for (int i = 27; i < 48; i++) {
            inventory.setItem(i, getPlaceholder());
        }
        inventory.setItem(48, getWatchWolves(Mode.PLAY));
        inventory.setItem(49, getGrandTheftMinecart(Mode.PLAY));
        inventory.setItem(50, getBlockingDead(Mode.PLAY));
        for (int i = 51; i < 54; i++) {
            inventory.setItem(i, getPlaceholder());
        }

        return inventory;
    }

    public static ItemStack getWatchWolves(Mode mode) {
        watchWolves = new ItemStack(Material.IRON_INGOT);
        {
            ItemMeta m = watchWolves.getItemMeta();
            m.setDisplayName("§d§lWATCH WOLVES");
            m.setLore(makeLore(mode, "Hack other players and the entire city of", "Chicago. Guns, hacking, and food crush = fun :3.", "Unlimited players"));
            watchWolves.setItemMeta(m);
        }

        return watchWolves;
    }

    public static ItemStack getGrandTheftMinecart(Mode mode) {
        grandTheftMinecart = new ItemStack(Material.IRON_BARDING);
        {
            ItemMeta m = grandTheftMinecart.getItemMeta();
            m.setDisplayName("§d§lGRAND THEFT MINECART");
            m.setLore(makeLore(mode, "Fight against other players, rob stores, and", "just cause general chaos upon San Blockdrea.", "Unlimited players"));
            grandTheftMinecart.setItemMeta(m);
        }

        return grandTheftMinecart;
    }

    public static ItemStack getBlockingDead(Mode mode) {
        blockingDead = new ItemStack(Material.SKULL_ITEM, 1, (byte) 2);
        {
            ItemMeta m = blockingDead.getItemMeta();
            m.setDisplayName("§d§lBLOCKING DEAD");
            m.setLore(makeLore(mode, "Zombies have risen! Gather groups and fight for your own", "survival. Can you survive and hold your own?", "Unlimited players"));
            blockingDead.setItemMeta(m);
        }

        return blockingDead;
    }

    public static ItemStack getMainRepresentative() {
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

    public static ItemStack getArcadeRepresentative() {
        arcadeRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 8);
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

    public static ItemStack getRepresentative() {
        standaloneRepresentative = new ItemStack(Material.INK_SACK, 1, (byte) 5);
        {
            ItemMeta m = standaloneRepresentative.getItemMeta();
            m.setDisplayName("§d§lSTANDALONE GAMEMODES");
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

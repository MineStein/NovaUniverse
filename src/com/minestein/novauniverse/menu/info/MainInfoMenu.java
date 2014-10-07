package com.minestein.novauniverse.menu.info;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MainInfoMenu {

    static Inventory inventory;
    static ItemStack commands;
    static ItemStack games;
    static ItemStack staff;
    static ItemStack comingSoon;
    static ItemStack maps;
    static ItemStack donate;
    static ItemStack back;
    static ItemStack pets;

    // Red - 1
    // Orange - 14
    // Yellow - 11
    // Green - 2
    // Light Blue 12
    // Dark Blue = 4
    // Purple - 5

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rInformation");

        inventory.setItem(0, getCommands());
        inventory.setItem(1, getGames());
        inventory.setItem(2, getStaff());
        inventory.setItem(3, getMaps());
        inventory.setItem(4, getDonate());
        inventory.setItem(5, getPets());
        for (int i = 6; i < 9; i++) {
            inventory.setItem(i, getComingSoon());
        }

        return inventory;
    }

    public static ItemStack getPets() {
        pets = new ItemStack(Material.INK_SACK, 1, (byte) 4);
        {
            ItemMeta m = pets.getItemMeta();
            m.setDisplayName("§1§lPETS §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oPet information.");
            m.setLore(lore);
            pets.setItemMeta(m);
        }

        return pets;
    }

    public static ItemStack getDonate() {
        donate = new ItemStack(Material.INK_SACK, 1, (byte) 12);
        {
            ItemMeta m = donate.getItemMeta();
            m.setDisplayName("§9§lDONATING §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oDonation information.");
            m.setLore(lore);
            donate.setItemMeta(m);
        }

        return donate;
    }

    public static ItemStack getCommands() {
        commands = new ItemStack(Material.INK_SACK, 1, (byte) 1);
        {
            ItemMeta m = commands.getItemMeta();
            m.setDisplayName("§4§lCOMMANDS §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oCommand information.");
            m.setLore(lore);
            commands.setItemMeta(m);
        }

        return commands;
    }

    public static ItemStack getGames() {
        games = new ItemStack(Material.INK_SACK, 1, (byte) 14);
        {
            ItemMeta m = games.getItemMeta();
            m.setDisplayName("§6§lGAMEMODES §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oGamemode information.");
            m.setLore(lore);
            games.setItemMeta(m);
        }

        return games;
    }

    public static ItemStack getStaff() {
        staff = new ItemStack(Material.INK_SACK, 1, (byte) 11);
        {
            ItemMeta m = staff.getItemMeta();
            m.setDisplayName("§e§lSTAFF §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oStaff information.");
            m.setLore(lore);
            staff.setItemMeta(m);
        }

        return staff;
    }

    public static ItemStack getMaps() {
        maps = new ItemStack(Material.INK_SACK, 1, (byte) 2);
        {
            ItemMeta m = maps.getItemMeta();
            m.setDisplayName("§2§lMAPS §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oMap information.");
            m.setLore(lore);
            maps.setItemMeta(m);
        }

        return maps;
    }

    public static ItemStack getComingSoon() {
        comingSoon = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
        {
            ItemMeta m = comingSoon.getItemMeta();
            m.setDisplayName("§7§lCOMING SOON");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oThis content has not");
            lore.add("§5§oarrived yet.");
            m.setLore(lore);
            comingSoon.setItemMeta(m);
        }

        return comingSoon;
    }

    public static ItemStack getBack() {
        back = new ItemStack(Material.INK_SACK, 1, (byte) 1);
        {
            ItemMeta m = back.getItemMeta();
            m.setDisplayName("§c§lBACK §7§o(Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oGo back to the main");
            lore.add("information menu.");
            m.setLore(lore);
            back.setItemMeta(m);
        }

        return back;
    }

    public static String[] makeInfo(String name, String ul1, String ul2, String ul3, String ul4) {
        String[] text = new String[]{
                "§4§l§m----------------------------------------",
                "§4§lDisclaimer§8: §cGames sporting the §4§l[§c§l18+§4§l]",
                "§clabel may contain themes some parents may find",
                "§cinnappropriate for younger players. Reasons",
                "§cwill be displayed in the description of such games.",
                "",
                "§cThank you, from the §5§lNova§6§lUniverse §cstaff.",
                "",
                "",
                "§cWelcome to the information collection! The",
                "§cfollowing text is information on the pre-",
                "§cselected category/item:",
                "",
                "§4§lNAME§8: §e§l" + name.toUpperCase(),
                "§4§lDESCRIPTION§8: §e§l" + ul1.toUpperCase(),
                "§c§l§o>> §e§l" + ul2.toUpperCase(),
                "§c§l§o>> §e§l" + ul3.toUpperCase(),
                "§c§l§o>> §e§l" + ul4.toUpperCase(),
                "§4§l§m----------------------------------------"
        };

        return text;
    }
}

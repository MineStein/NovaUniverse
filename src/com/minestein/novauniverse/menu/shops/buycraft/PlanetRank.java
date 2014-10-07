package com.minestein.novauniverse.menu.shops.buycraft;

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
public class PlanetRank {

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 9, "§e§l>> §b§lPlanet Rank");
        inventory.setItem(2, getOneMonth());
        inventory.setItem(3, getSixMonth());
        inventory.setItem(4, getTwelveMonth());
        return inventory;
    }

    public static ItemStack getOneMonth() {
        ItemStack oneMonth = new ItemStack(Material.IRON_BLOCK);
        {
            ItemMeta m = oneMonth.getItemMeta();
            m.setDisplayName("§a§l1 Month");
            oneMonth.setItemMeta(m);
        }

        return oneMonth;
    }

    public static ItemStack getSixMonth() {
        ItemStack sixMonth = new ItemStack(Material.GOLD_BLOCK);
        {
            ItemMeta m = sixMonth.getItemMeta();
            m.setDisplayName("§a§l6 Months");
            sixMonth.setItemMeta(m);
        }

        return sixMonth;
    }

    public static ItemStack getTwelveMonth() {
        ItemStack twelveMonth = new ItemStack(Material.DIAMOND_BLOCK);
        {
            ItemMeta m = twelveMonth.getItemMeta();
            m.setDisplayName("§a§l1 Year");
            twelveMonth.setItemMeta(m);
        }

        return twelveMonth;
    }

    public static ArrayList<String> getPrice(double price) {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§a§lPrice§8: §e" + price);
        return lore;
    }
}

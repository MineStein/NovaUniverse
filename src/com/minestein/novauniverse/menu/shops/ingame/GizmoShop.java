package com.minestein.novauniverse.menu.shops.ingame;

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
public class GizmoShop {

    private static ItemStack tpbow;
    private static ItemStack foodcrush;

    public static Inventory getInventory() {
        Inventory inventory;

        inventory = Bukkit.createInventory(null, 9, "§e§l>> §a§lGIZMO SHOP");
        inventory.setItem(0, getTpbow());
        inventory.setItem(1, getFoodcrush());

        return inventory;
    }

    public static ItemStack getTpbow() {
        tpbow = new ItemStack(Material.BOW);
        {
            ItemMeta m = tpbow.getItemMeta();
            m.setDisplayName("§c§lTELEPORT BOW§e§l>> §7§oGizmo");
            m.setLore(makeLore("Teleport over to where your arrow lands!", "Have fun playing around with this gizmo!", "200 novites"));
            tpbow.setItemMeta(m);
        }

        return tpbow;
    }

    public static ItemStack getFoodcrush() {
        foodcrush = new ItemStack(Material.BREAD);
        {
            ItemMeta m = foodcrush.getItemMeta();
            m.setDisplayName("§c§lFOOD CRUSH§e§l>> §7§oGizmo");
            m.setLore(makeLore("Crush food and get the highest score on ", "the server! (We all know the parody)!", "400 novites"));
            foodcrush.setItemMeta(m);
        }

        return foodcrush;
    }

    private static ArrayList<String> makeLore(String summary1, String summary2, String price) {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§e§lDESCRIPTION§8: §d" + summary1);
        lore.add("§d" + summary2);
        lore.add("§e§lPRICE§8: §d" + price);

        return lore;
    }
}

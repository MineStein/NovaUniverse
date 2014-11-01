package com.minestein.novauniverse.menu.pets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetColorMenu {

    static ItemMeta m;
    static Inventory inventory;
    static ItemStack[] colors = new ItemStack[]{
            new ItemStack(Material.INK_SACK, 1, (byte) 1),
            new ItemStack(Material.INK_SACK, 1, (byte) 2),
            new ItemStack(Material.INK_SACK, 1, (byte) 3),
            new ItemStack(Material.INK_SACK, 1, (byte) 4),
            new ItemStack(Material.INK_SACK, 1, (byte) 5),
            new ItemStack(Material.INK_SACK, 1, (byte) 6),
            new ItemStack(Material.INK_SACK, 1, (byte) 7),
            new ItemStack(Material.INK_SACK, 1, (byte) 8),
            new ItemStack(Material.INK_SACK, 1, (byte) 9)
    };

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rColor your Pet");
        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, colors[i]);
        }
        return inventory;
    }
}

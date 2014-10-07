package com.minestein.novauniverse.menu.info;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MapInfoMenu {

    static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 36, "§e§l>> §rMap Information");

        for (int i = 0; i < 35; i++) {
            inventory.setItem(i, MainInfoMenu.getComingSoon());
        }
        inventory.setItem(35, MainInfoMenu.getBack());

        return inventory;
    }
}

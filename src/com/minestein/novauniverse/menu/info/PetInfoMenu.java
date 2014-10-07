package com.minestein.novauniverse.menu.info;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetInfoMenu {

    static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rPet Information");

        for (int i = 0; i < 8; i++) {
            inventory.setItem(i, MainInfoMenu.getComingSoon());
        }
        inventory.setItem(8, MainInfoMenu.getBack());

        return inventory;
    }
}

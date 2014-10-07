package com.minestein.novauniverse.menu.pets;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class BuyPetsMenu {

    static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 18, "§e§l>> §rPurchase a pet");

        inventory.setItem(0, PetsMenu.getWolf());
        inventory.setItem(1, PetsMenu.getSheep());
        for (int i = 2; i < 17; i++) {
            inventory.setItem(i, MainPetsMenu.getComingSoon());
        }
        inventory.setItem(17, MainPetsMenu.getBack());

        return inventory;
    }
}

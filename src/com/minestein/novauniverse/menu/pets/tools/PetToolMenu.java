package com.minestein.novauniverse.menu.pets.tools;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetToolMenu {

    static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rPet Settings");
        return inventory;
    }
}

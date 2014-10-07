package com.minestein.novauniverse.menu.pets;

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
public class SelectPetsMenu {

    static Inventory inventory;
    static ItemStack removeCurrentPet;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 18, "§e§l>> §rSelect a pet");

        inventory.setItem(0, PetsMenu.getWolf());
        inventory.setItem(1, PetsMenu.getSheep());
        for (int i = 2; i < 16; i++) {
            inventory.setItem(i, MainPetsMenu.getComingSoon());
        }
        inventory.setItem(16, getRemoveCurrentPet());
        inventory.setItem(17, MainPetsMenu.getBack());

        return inventory;
    }

    public static ItemStack getRemoveCurrentPet() {
        removeCurrentPet = new ItemStack(Material.REDSTONE_TORCH_ON);
        {
            ItemMeta m = removeCurrentPet.getItemMeta();
            m.setDisplayName("§c§lCLEAR PETS §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oRemove your current");
            l.add("§5§opet that you have!");
            m.setLore(l);
            removeCurrentPet.setItemMeta(m);
        }
        return removeCurrentPet;
    }
}

package com.minestein.novauniverse.menu.pets;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetsMenu {

    public static ItemStack getWolf() {
        return createPetEggIcon("§c§lWOLF §7§o(Click)", (byte) 95);
    }

    public static ItemStack getSheep() {
        return createPetEggIcon("§c§lSHEEP §7§o(Click)", (byte) 91);
    }

    private static ItemStack createPetEggIcon(String name, byte data) {
        ItemStack item = new ItemStack(Material.MONSTER_EGG, 1, data);
        {
            ItemMeta m = item.getItemMeta();
            m.setDisplayName(name);
            item.setItemMeta(m);
        }
        return item;
    }
}

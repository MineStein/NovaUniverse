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
public class PetToolMenu {

    static Inventory inventory;
    static ItemStack name;
    static ItemStack cs;

    public static ItemStack getCs() {
        cs = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10); {
            ItemMeta m = cs.getItemMeta();
            m.setDisplayName("§7§lCOMING SOON");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oThis content has not");
            l.add("§5§oarrived yet!");
            m.setLore(l);
            cs.setItemMeta(m);
        }
        return cs;
    }

    public static ItemStack getName() {
        name = new ItemStack(Material.NAME_TAG); {
            ItemMeta m = name.getItemMeta();
            m.setDisplayName("§c§lNAME §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oChange the pet's");
            l.add("§5§oname to something else!");
            m.setLore(l);
            name.setItemMeta(m);
        }
        return name;
    }

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rPet Settings");
        inventory.setItem(0, getName());
        for (int i = 1; i < 9; i++) {
            inventory.setItem(i, getCs());
        }
        return inventory;
    }
}

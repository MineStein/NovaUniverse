package com.minestein.novauniverse.menu.pets;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetToolMenu {

    static Inventory inventory;
    static ItemStack name;
    static ItemStack cs;
    static ItemStack color;
    static ItemStack mount;

    public static ItemStack getCs() {
        cs = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
        {
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

    public static ItemStack getColor() {
        color = new ItemStack(Material.INK_SACK, 1, (byte) Main.getRandom().nextInt(15));
        {
            ItemMeta m = color.getItemMeta();
            m.setDisplayName("§c§lCOLOR §7§o(Click)");
            ArrayList<String> l = new ArrayList<String>();
            l.add("§5§oChange the color of");
            l.add("§5§oyour pet. NOTE:");
            l.add("§5§oonly available on ");
            l.add("§5§ocertain pets.");
            m.setLore(l);
            color.setItemMeta(m);
        }
        return color;
    }

    public static ItemStack getName() {
        name = new ItemStack(Material.NAME_TAG);
        {
            ItemMeta m = name.getItemMeta();
            m.setDisplayName("§c§lNAME §7§o(Click)");
            ArrayList<String> l = new ArrayList<String>();
            l.add("§5§oChange the pet's");
            l.add("§5§oname to something else!");
            m.setLore(l);
            name.setItemMeta(m);
        }
        return name;
    }

    public static ItemStack getMount() {
        mount = new ItemStack(Material.SADDLE); {
            ItemMeta m = mount.getItemMeta();
            m.setDisplayName("§c§lMOUNT §7§o(Click)");
            m.setLore(Arrays.asList("§5§oMount your pet."));
        }
        return mount;
    }

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rPet Settings");
        inventory.setItem(0, getName());
        inventory.setItem(1, getColor());
        inventory.setItem(2, getMount());
        for (int i = 3; i < 9; i++) {
            inventory.setItem(i, getCs());
        }
        return inventory;
    }
}

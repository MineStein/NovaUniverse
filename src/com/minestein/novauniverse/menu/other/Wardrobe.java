package com.minestein.novauniverse.menu.other;

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
public class Wardrobe {

    public enum Type {
        IRON, GOLD, DIAMOND
    }

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 54, "§e§l>> §rWhat to wear?");

        for (int i = 0; i < 3; i++) {
            inventory.setItem(i, getPurpleHolder());
        }
        inventory.setItem(3, getHelm(Type.IRON));
        inventory.setItem(4, getHelm(Type.GOLD));
        inventory.setItem(5, getHelm(Type.DIAMOND));
        for (int i = 6; i < 10; i++) {
            inventory.setItem(i, getPurpleHolder());
        }
        inventory.setItem(10, getRemove());
        inventory.setItem(11, getNormalHolder());
        inventory.setItem(12, getChest(Type.IRON));
        inventory.setItem(13, getChest(Type.GOLD));
        inventory.setItem(14, getChest(Type.DIAMOND));
        inventory.setItem(15, getNormalHolder());
        inventory.setItem(16, getRemove());
        inventory.setItem(17, getPurpleHolder());
        inventory.setItem(18, getPurpleHolder());
        inventory.setItem(19, getNormalHolder());
        inventory.setItem(20, getNormalHolder());
        inventory.setItem(21, getLegs(Type.IRON));
        inventory.setItem(22, getLegs(Type.GOLD));
        inventory.setItem(23, getLegs(Type.DIAMOND));
        inventory.setItem(24, getNormalHolder());
        inventory.setItem(25, getNormalHolder());
        inventory.setItem(26, getPurpleHolder());
        inventory.setItem(27, getPurpleHolder());
        inventory.setItem(28, getNormalHolder());
        inventory.setItem(29, getNormalHolder());
        inventory.setItem(30, getBoots(Type.IRON));
        inventory.setItem(31, getBoots(Type.GOLD));
        inventory.setItem(32, getBoots(Type.DIAMOND));
        inventory.setItem(33, getNormalHolder());
        inventory.setItem(34, getNormalHolder());
        inventory.setItem(35, getPurpleHolder());
        inventory.setItem(36, getPurpleHolder());
        for (int i = 37; i < 44; i++) {
            inventory.setItem(i, getNormalHolder());
        }
        inventory.setItem(44, getPurpleHolder());
        inventory.setItem(45, getPurpleHolder());
        for (int i = 46; i < 54; i++) {
            inventory.setItem(i, getPurpleHolder());
        }

        return inventory;
    }

    public static ItemStack getHelm(Type type) {
        ItemStack helm;

        switch (type) {
            case IRON:
                helm = new ItemStack(Material.IRON_HELMET);
            {
                ItemMeta m = helm.getItemMeta();
                m.setDisplayName("§e§l>> §7§lIRON HELMET");
                m.setLore(getLore());
                helm.setItemMeta(m);
            }
            break;
            case GOLD:
                helm = new ItemStack(Material.GOLD_HELMET);
            {
                ItemMeta m = helm.getItemMeta();
                m.setDisplayName("§e§l>> §6§lGOLD HELMET");
                m.setLore(getLore());
                helm.setItemMeta(m);
            }
            break;
            case DIAMOND:
                helm = new ItemStack(Material.DIAMOND_HELMET);
            {
                ItemMeta m = helm.getItemMeta();
                m.setDisplayName("§e§l>> §b§lDIAMOND HELMET");
                m.setLore(getLore());
                helm.setItemMeta(m);
            }
            break;
            default:
                helm = null;
        }

        return helm;
    }

    public static ItemStack getPurpleHolder() {
        ItemStack holder;

        holder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
        {
            ItemMeta m = holder.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            holder.setItemMeta(m);
        }

        return holder;
    }

    public static ItemStack getNormalHolder() {
        ItemStack holder;

        holder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 2);
        {
            ItemMeta m = holder.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            holder.setItemMeta(m);
        }

        return holder;
    }

    public static ItemStack getChest(Type type) {
        ItemStack chest;

        switch (type) {
            case IRON:
                chest = new ItemStack(Material.IRON_CHESTPLATE);
            {
                ItemMeta m = chest.getItemMeta();
                m.setDisplayName("§e§l>> §7§lIRON CHESTPLATE");
                m.setLore(getLore());
                chest.setItemMeta(m);
            }
            break;
            case GOLD:
                chest = new ItemStack(Material.GOLD_CHESTPLATE);
            {
                ItemMeta m = chest.getItemMeta();
                m.setDisplayName("§e§l>> §6§lGOLD CHESTPLATE");
                m.setLore(getLore());
                chest.setItemMeta(m);
            }
            break;
            case DIAMOND:
                chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
            {
                ItemMeta m = chest.getItemMeta();
                m.setDisplayName("§e§l>> §b§lDIAMOND CHESTPLATE");
                m.setLore(getLore());
                chest.setItemMeta(m);
            }
            break;
            default:
                chest = null;
        }

        return chest;
    }

    public static ItemStack getLegs(Type type) {
        ItemStack legs;

        switch (type) {
            case IRON:
                legs = new ItemStack(Material.IRON_LEGGINGS);
            {
                ItemMeta m = legs.getItemMeta();
                m.setDisplayName("§e§l>> §7§lIRON LEGGINGS");
                m.setLore(getLore());
                legs.setItemMeta(m);
            }
            break;
            case GOLD:
                legs = new ItemStack(Material.GOLD_LEGGINGS);
            {
                ItemMeta m = legs.getItemMeta();
                m.setDisplayName("§e§l>> §6§lGOLD LEGGINGS");
                m.setLore(getLore());
                legs.setItemMeta(m);
            }
            break;
            case DIAMOND:
                legs = new ItemStack(Material.DIAMOND_LEGGINGS);
            {
                ItemMeta m = legs.getItemMeta();
                m.setDisplayName("§e§l>> §b§lDIAMOND LEGGINGS");
                m.setLore(getLore());
                legs.setItemMeta(m);
            }
            break;
            default:
                legs = null;
        }

        return legs;
    }

    public static ItemStack getBoots(Type type) {
        ItemStack boots;

        switch (type) {
            case IRON:
                boots = new ItemStack(Material.IRON_BOOTS);
            {
                ItemMeta m = boots.getItemMeta();
                m.setDisplayName("§e§l>> §7§lIRON BOOTS");
                m.setLore(getLore());
                boots.setItemMeta(m);
            }
            break;
            case GOLD:
                boots = new ItemStack(Material.GOLD_BOOTS);
            {
                ItemMeta m = boots.getItemMeta();
                m.setDisplayName("§e§l>> §6§lGOLD BOOTS");
                m.setLore(getLore());
                boots.setItemMeta(m);
            }
            break;
            case DIAMOND:
                boots = new ItemStack(Material.DIAMOND_BOOTS);
            {
                ItemMeta m = boots.getItemMeta();
                m.setDisplayName("§e§l>> §b§lDIAMOND BOOTS");
                m.setLore(getLore());
                boots.setItemMeta(m);
            }
            break;
            default:
                boots = null;
        }

        return boots;
    }

    public static ItemStack getRemove() {
        ItemStack remove;

        remove = new ItemStack(Material.REDSTONE_TORCH_ON);
        {
            ItemMeta m = remove.getItemMeta();
            m.setDisplayName("§c§lCLEAR ARMOR §7§o(Click)");
            remove.setItemMeta(m);
        }

        return remove;
    }

    private static ArrayList<String> getLore() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§a§lCLICK §r§7to equip this!");
        return lore;
    }
}

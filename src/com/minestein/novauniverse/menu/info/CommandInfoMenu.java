package com.minestein.novauniverse.menu.info;

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
public class CommandInfoMenu {

    enum Type {RED, WHITE}

    static Inventory inventory;
    static ItemStack report;
    static ItemStack bug;
    static ItemStack skinreport;
    static ItemStack message;
    static ItemStack rocket;
    static ItemStack slap;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rCommand Information");

        inventory.setItem(0, getReport());
        inventory.setItem(1, getBug());
        inventory.setItem(2, getSkinreport());
        inventory.setItem(3, getMessage());
        inventory.setItem(4, getRocket());
        inventory.setItem(5, getSlap());
        for (int i = 6; i < 8; i++) {
            inventory.setItem(i, MainInfoMenu.getComingSoon());
        }
        inventory.setItem(8, MainInfoMenu.getBack());

        return inventory;
    }

    public static ItemStack getReport() {
        report = createItemStack(Type.RED, "report", "§5§oReport players.");

        return report;
    }

    public static ItemStack getBug() {
        bug = createItemStack(Type.WHITE, "bug", "§5§oReport bugs.");

        return bug;
    }

    public static ItemStack getSkinreport() {
        skinreport = createItemStack(Type.RED, "skinreport", "§5§oReport player's skins.");

        return skinreport;
    }

    public static ItemStack getMessage() {
        message = createItemStack(Type.WHITE, "message", "§5§oMessage your friends privately.");

        return message;
    }

    public static ItemStack getRocket() {
        rocket = createItemStack(Type.RED, "rocket", "§5§oSend players into the air.");

        return rocket;
    }

    public static ItemStack getSlap() {
        slap = createItemStack(Type.WHITE, "slap", "§5§oSlap players away.");

        return slap;
    }

    private static ItemStack createItemStack(Type type, String displayName, String text) {
        ItemStack itemStack;

        switch (type) {
            case RED:
                itemStack = new ItemStack(Material.REDSTONE);
            case WHITE:
                itemStack = new ItemStack(Material.SUGAR);
            default:
                itemStack = new ItemStack(Material.GLOWSTONE_DUST);
        }

        ItemMeta m = itemStack.getItemMeta();
        m.setDisplayName("§c§l" + displayName.toUpperCase() + " §7§o(Click)");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(text);
        m.setLore(lore);
        itemStack.setItemMeta(m);

        return itemStack;
    }

    /*
     * case RED:
                itemStack = new ItemStack(Material.REDSTONE);
            {
                ItemMeta m = itemStack.getItemMeta();
                m.setDisplayName("§c§l"+displayName.toUpperCase()+" §7§o(Click)");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(text);
                m.setLore(lore);
                itemStack.setItemMeta(m);
            }
            case WHITE:
                itemStack = new ItemStack(Material.SUGAR);
            {
                ItemMeta m = itemStack.getItemMeta();
                m.setDisplayName("§c§l"+displayName.toUpperCase()+" §7§o(Click)");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(text);
                m.setLore(lore);
                itemStack.setItemMeta(m);
            }
            default:
                itemStack = new ItemStack(Material.GLOWSTONE_DUST);
            {
                ItemMeta m = itemStack.getItemMeta();
                m.setDisplayName(displayName);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(text);
                m.setLore(lore);
                itemStack.setItemMeta(m);
            }
     */
}

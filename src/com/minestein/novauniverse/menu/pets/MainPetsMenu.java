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
public class MainPetsMenu {

    static Inventory inventory;
    static ItemStack comingSoon;
    static ItemStack buy;
    static ItemStack select;
    static ItemStack back;

    public static ItemStack getBack() {
        back = new ItemStack(Material.INK_SACK, 1, (byte) 1);
        {
            ItemMeta m = back.getItemMeta();
            m.setDisplayName("§c§lBACK §7§o(Click)");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§5§oGo back to the");
            lore.add("§5§omain pet area.");
            m.setLore(lore);
            back.setItemMeta(m);
        }
        return back;
    }

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rWhat to do?");

        inventory.setItem(0, getBuy());
        inventory.setItem(1, getSelect());
        for (int i = 2; i < 9; i++) {
            inventory.setItem(i, getComingSoon());
        }

        return inventory;
    }

    public static ItemStack getBuy() {
        buy = new ItemStack(Material.GOLD_NUGGET);
        {
            ItemMeta m = buy.getItemMeta();
            m.setDisplayName("§c§lBUY PETS §7§o(Click)");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§5§oPurchase a pet");
            lore.add("§5§oto follow you.");
            m.setLore(lore);
            buy.setItemMeta(m);
        }
        return buy;
    }

    public static ItemStack getSelect() {
        select = new ItemStack(Material.BONE);
        {
            ItemMeta m = select.getItemMeta();
            m.setDisplayName("§c§lSELECT A PET §7§o(Click)");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§5§oSelect a pet");
            lore.add("§5§oto follow you.");
            m.setLore(lore);
            select.setItemMeta(m);
        }
        return select;
    }

    public static ItemStack getComingSoon() {
        comingSoon = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 10);
        {
            ItemMeta m = comingSoon.getItemMeta();
            m.setDisplayName("§7§lCOMING SOON");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§5§oThis content has");
            lore.add("§5§onot arrived yet!");
            m.setLore(lore);
            comingSoon.setItemMeta(m);
        }

        return comingSoon;
    }
}

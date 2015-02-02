package com.minestein.novauniverse.menu.info;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MapInfoMenu {

    static Inventory inventory;

    enum Status {
        PRIVATE,

        PUBLIC;
    }

    public static ItemStack generateMap(String mapName, String author, Status status, String link) {
        ItemStack i = new ItemStack(Material.EMPTY_MAP); {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§e§l"+mapName.toUpperCase());
            m.setLore(Arrays.asList("§b§lAuthor: §e§l"+author.toUpperCase(), "§b§lStatus: §e§l"+status.toString(),"§b§lLink: §e§l".concat(link==null ? "§c§lNOPE" : link)));
            i.setItemMeta(m);
        }
        return i;
    }

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 36, "§e§l>> §rMap Information");

        inventory.setItem(0, generateMap("hub", "playman", Status.PRIVATE, null));
        inventory.setItem(1, generateMap("lobby", "ASB", Status.PUBLIC, "http://goo.gl/Drac33"));
        for (int i = 2; i < 35; i++) {
            inventory.setItem(i, MainInfoMenu.getComingSoon());
        }
        inventory.setItem(35, MainInfoMenu.getBack());

        return inventory;
    }
}

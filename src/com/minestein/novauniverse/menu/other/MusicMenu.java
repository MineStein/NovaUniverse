package com.minestein.novauniverse.menu.other;

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
public class MusicMenu {

    private static ItemStack createSong(String songTitle, String artist, String album) {
        ItemStack i = new ItemStack(Material.GOLD_RECORD);
        {
            ItemMeta m = i.getItemMeta();
            m.setDisplayName("§a§l"+songTitle.toUpperCase());
            m.setLore(Arrays.asList("§5§oArtist: §b"+artist.toUpperCase(), "§5§oAlbum: §b"+album.toUpperCase()));
            i.setItemMeta(m);
        }
        return i;
    }

    public static ItemStack gangnamStyle() {
        return createSong("gangnam style", "psy", "unknown");
    }

    public static Inventory getInventory() {
        Inventory i = Bukkit.createInventory(null, 9, "§e§l>> §rSelect a Song");
        i.setItem(0, gangnamStyle());
        return i;
    }
}

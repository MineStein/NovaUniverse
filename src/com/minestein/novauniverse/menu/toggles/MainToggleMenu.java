package com.minestein.novauniverse.menu.toggles;

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
public class MainToggleMenu {

    private static ItemStack speedOn;
    private static ItemStack speedOff;
    private static ItemStack jumpOn;
    private static ItemStack jumpOff;
    private static ItemStack tgglplyrsOn;
    private static ItemStack tgglplyrsOff;
    private static ItemStack bloodOn;
    private static ItemStack bloodOff;
    private static ItemStack languageOn;
    private static ItemStack languageOff;
    private static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 9, "§e§l>> §rToggles");

        inventory.setItem(0, getSpeedOn());
        inventory.setItem(1, getJumpOn());
        inventory.setItem(2, getTgglplyrsOn());
        inventory.setItem(3, getBloodOn());
        inventory.setItem(4, getLanguageOn());

        return inventory;
    }

    public static ItemStack getBloodOn() {
        bloodOn = new ItemStack(Material.EMERALD_BLOCK);
        {
            ItemMeta m = bloodOn.getItemMeta();
            m.setDisplayName("§c§lBLOOD§8§l:§a§lOn §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oEntities may bleed");
            l.add("§5§oin some games!");
            m.setLore(l);
            bloodOn.setItemMeta(m);
        }
        return bloodOn;
    }

    public static ItemStack getBloodOff() {
        bloodOff = new ItemStack(Material.REDSTONE_BLOCK);
        {
            ItemMeta m = bloodOff.getItemMeta();
            m.setDisplayName("§c§lBLOOD§8§l:§4§lOff §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oEntities may bleed");
            l.add("§5§oin some games!");
            m.setLore(l);
            bloodOff.setItemMeta(m);
        }
        return bloodOff;
    }

    public static ItemStack getLanguageOn() {
        languageOn = new ItemStack(Material.EMERALD_BLOCK);
        {
            ItemMeta m = languageOn.getItemMeta();
            m.setDisplayName("§c§lLANGUAGE§8§l:§a§lOn §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oCuss words may");
            l.add("§5§oappear within games!");
            m.setLore(l);
            languageOn.setItemMeta(m);
        }
        return languageOn;
    }

    public static ItemStack getLanguageOff() {
        languageOff = new ItemStack(Material.REDSTONE_BLOCK);
        {
            ItemMeta m = languageOff.getItemMeta();
            m.setDisplayName("§c§lLANGUAGE§8§l:§4§lOff §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oCuss words may");
            l.add("§5§oappear within games!");
            m.setLore(l);
            languageOff.setItemMeta(m);
        }
        return languageOff;
    }

    public static ItemStack getSpeedOn() {
        speedOn = new ItemStack(Material.EMERALD_BLOCK);
        {
            ItemMeta m = speedOn.getItemMeta();
            m.setDisplayName("§c§lSPEED§8§l:§a§lOn §7§o(Click)");
            ArrayList<String> l = new ArrayList<String>();
            l.add("§5§oMove faster around");
            l.add("§5§othe hub!");
            m.setLore(l);
            speedOn.setItemMeta(m);
        }
        return speedOn;
    }

    public static ItemStack getJumpOn() {
        jumpOn = new ItemStack(Material.EMERALD_BLOCK);
        {
            ItemMeta m = jumpOn.getItemMeta();
            m.setDisplayName("§c§lJUMP§8§l:§a§lOn §7§o(Click)");
            ArrayList<String> l = new ArrayList<String>();
            l.add("§5§oJump higher around");
            l.add("§5§othe hub!");
            m.setLore(l);
            jumpOn.setItemMeta(m);
        }
        return jumpOn;
    }

    public static ItemStack getJumpOff() {
        jumpOff = new ItemStack(Material.REDSTONE_BLOCK);
        {
            ItemMeta m = jumpOff.getItemMeta();
            m.setDisplayName("§c§lJUMP§8§l:§4§lOff §7§o(Click)");
            ArrayList<String> l = new ArrayList<String>();
            l.add("§5§oJump higher around");
            l.add("§5§othe hub!");
            m.setLore(l);
            jumpOff.setItemMeta(m);
        }
        return jumpOff;
    }

    public static ItemStack getSpeedOff() {
        speedOff = new ItemStack(Material.REDSTONE_BLOCK);
        {
            ItemMeta m = speedOff.getItemMeta();
            m.setDisplayName("§c§lSPEED§8§l:§4§lOff §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oMove faster around");
            l.add("§5§othe hub!");
            m.setLore(l);
            speedOff.setItemMeta(m);
        }
        return speedOff;
    }

    public static ItemStack getTgglplyrsOn() {
        tgglplyrsOn = new ItemStack(Material.EMERALD_BLOCK);
        {
            ItemMeta m = tgglplyrsOn.getItemMeta();
            m.setDisplayName("§c§lPLAYERS§8§l:§a§lOn §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oToggle player visibility");
            l.add("§5§oaround the hub!");
            m.setLore(l);
            tgglplyrsOn.setItemMeta(m);
        }
        return tgglplyrsOn;
    }

    public static ItemStack getTgglplyrsOff() {
        tgglplyrsOff = new ItemStack(Material.REDSTONE_BLOCK);
        {
            ItemMeta m = tgglplyrsOff.getItemMeta();
            m.setDisplayName("§c§lPLAYERS§8§l:§4§lOff §7§o(Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oToggle player visibility");
            l.add("§5§oaround the hub!");
            m.setLore(l);
            tgglplyrsOff.setItemMeta(m);
        }
        return tgglplyrsOff;
    }
}

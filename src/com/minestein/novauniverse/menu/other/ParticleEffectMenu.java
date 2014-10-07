package com.minestein.novauniverse.menu.other;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ParticleEffectMenu {

    private static ItemStack fireEffect;
    private static ItemStack smokeEffect;
    private static ItemStack enderEffect;
    public static HashMap<String, String> currentParticles;

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 9, "§e§l>> §a§lPARTICLE EFFECTS");
        inventory.setItem(0, getFireEffect());
        inventory.setItem(1, getSmokeEffect());
        inventory.setItem(2, getEnderEffect());

        return inventory;
    }

    public static ItemStack getFireEffect() {
        fireEffect = new ItemStack(Material.FIRE);
        {
            ItemMeta m = fireEffect.getItemMeta();
            m.setDisplayName("§c§lFIRE§e§l>> §7§oParticle Effect");
            fireEffect.setItemMeta(m);
        }

        return fireEffect;
    }

    public static ItemStack getSmokeEffect() {
        smokeEffect = new ItemStack(Material.STICK);
        {
            ItemMeta m = smokeEffect.getItemMeta();
            m.setDisplayName("§c§lSMOKE§e§l>> §7§oParticle Effect");
            smokeEffect.setItemMeta(m);
        }

        return smokeEffect;
    }

    public static ItemStack getEnderEffect() {
        enderEffect = new ItemStack(Material.EYE_OF_ENDER);
        {
            ItemMeta m = enderEffect.getItemMeta();
            m.setDisplayName("§c§lENDER§e§l>> §7§oParticle Effect");
            enderEffect.setItemMeta(m);
        }

        return enderEffect;
    }
}

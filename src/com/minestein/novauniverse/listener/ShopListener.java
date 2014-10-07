package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.menu.shops.buycraft.NovaRank;
import com.minestein.novauniverse.menu.shops.buycraft.PlanetRank;
import com.minestein.novauniverse.menu.shops.buycraft.StarRank;
import com.minestein.novauniverse.menu.shops.ingame.GizmoShop;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ShopListener implements Listener {

    @EventHandler
    public void onShopOpen(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Villager)) return;

        Villager clicked = (Villager) e.getRightClicked();
        Player clicker = e.getPlayer();

        if (clicked.getCustomName() == null) {
            return;
        }

        if (clicked.getCustomName().equals("§1NPC§r§e§l>> §a§lGIZMO SHOP")) {
            Inventory gizmoShop = GizmoShop.getInventory();
            clicker.openInventory(gizmoShop);
        } else if (clicked.getCustomName().equals("§1NPC§r§e§l>> §b§lPLANET RANK")) {
            clicker.openInventory(PlanetRank.getInventory());
        } else if (clicked.getCustomName().equals("§1NPC§r§e§l>> §b§lSTAR RANK")) {
            clicker.openInventory(StarRank.getInventory());
        } else if (clicked.getCustomName().equals("§1NPC§r§e§l>> §b§lNOVA RANK")) {
            clicker.openInventory(NovaRank.getInventory());
        }
    }

    @EventHandler
    public void onShopItemClick(InventoryClickEvent e) {
        if (e.getInventory().getName() == null) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        Player p = (Player) e.getWhoClicked();
        String item = e.getCurrentItem().getItemMeta().getDisplayName();

        if (e.getInventory().getName().equals(NovaRank.getInventory().getName())) {
            if (item.equalsIgnoreCase("§a§l1 Month")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Nova§8:§a1 Month", "http://novauniverse.buycraft.net/category/342387"));
            } else if (item.equalsIgnoreCase("§a§l6 Months")) {
                p.closeInventory();
                p.sendMessage(generateInformation(35.00, "Nova§8:§a6 Months", "http://novauniverse.buycraft.net/category/342387"));
            } else if (item.equalsIgnoreCase("§a§l1 Year")) {
                p.closeInventory();
                p.sendMessage(generateInformation(45.00, "Nova§8:§a1 Year", "http://novauniverse.buycraft.net/category/342387"));
            } else if (item.equalsIgnoreCase("§a§lLifetime")) {
                p.closeInventory();
                p.sendMessage(generateInformation(100.00, "Nova§8:§aLifetime", "http://novauniverse.buycraft.net/category/342387"));
            }
        } else if (e.getInventory().getName().equals(StarRank.getInventory().getName())) {
            if (item.equalsIgnoreCase("§a§l1 Month")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342385"));
            } else if (item.equalsIgnoreCase("§a§l6 Months")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342385"));
            } else if (item.equalsIgnoreCase("§a§l1 Year")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342385"));
            }
        } else if (e.getInventory().getName().equals(PlanetRank.getInventory().getName())) {
            if (item.equalsIgnoreCase("§a§l1 Month")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342384"));
            } else if (item.equalsIgnoreCase("§a§l6 Months")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342384"));
            } else if (item.equalsIgnoreCase("§a§l1 Year")) {
                p.closeInventory();
                p.sendMessage(generateInformation(25.00, "Star§8:§a1 Month", "http://novauniverse.buycraft.net/category/342384"));
            }
        }
    }

    private String[] generateInformation(double price, String name, String link) {
        return new String[]{
                "§b§l§m----------------------------------------",
                "§eItem Name§8: §b" + name.toUpperCase(),
                "",
                "§ePrice§8: §b" + price + "0 USD",
                "",
                "§eLink§8: §b" + link,
                "§b§l§m----------------------------------------"
        };
    }
}

package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.PetManager;
import com.minestein.novauniverse.menu.pets.BuyPetsMenu;
import com.minestein.novauniverse.menu.pets.MainPetsMenu;
import com.minestein.novauniverse.menu.pets.PetsMenu;
import com.minestein.novauniverse.menu.pets.SelectPetsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.DyeColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetListener implements Listener {

    @EventHandler
    public void onBuyPetMenuInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(BuyPetsMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This pet purchase slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(BuyPetsMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainPetsMenu.getInventory());
        } else {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4Pet purchase authorization is not ready! All pets are free right now!");

            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> p.openInventory(MainPetsMenu.getInventory()), 30);
        }
    }

    @EventHandler
    public void onSelectPetMenuInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(SelectPetsMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This pet selection slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(SelectPetsMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainPetsMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(PetsMenu.getWolf().getItemMeta().getDisplayName())) {
            if (PetManager.getPetList().containsKey(p.getName())) {
                p.sendMessage(Main.getPrefix() + "§4You already have a pet!");
                return;
            }

            p.sendMessage(Main.getPrefix() + "§bEnjoy your new friend!");
            Wolf wolf = p.getWorld().spawn(p.getLocation(), Wolf.class);
            wolf.setCustomName("§e§l" + p.getName().toUpperCase() + "§e§l's WOLF");
            wolf.setCustomNameVisible(true);
            wolf.setTamed(true);
            wolf.setAdult();
            wolf.setAgeLock(true);
            wolf.setBreed(false);
            wolf.setOwner(p);
            wolf.setAngry(false);
            wolf.setCollarColor(DyeColor.PURPLE);
            PetManager.getPetList().put(p.getName(), true);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(PetsMenu.getSheep().getItemMeta().getDisplayName())) {
            if (PetManager.getPetList().containsKey(p.getName())) {
                p.sendMessage(Main.getPrefix() + "§4You already have a pet!");
                return;
            }

            p.sendMessage(Main.getPrefix() + "§bEnjoy your new friend!");
            Sheep sheep = p.getWorld().spawn(p.getLocation(), Sheep.class);
            sheep.setCustomName("§e§l" + p.getName().toUpperCase() + "§e§l's SHEEP");
            sheep.setCustomNameVisible(true);
            sheep.setTarget(p);
            sheep.setAdult();
            sheep.setAgeLock(true);
            sheep.setBreed(false);
            sheep.setSheared(false);
            sheep.setColor(DyeColor.PURPLE);
            PetManager.getPetList().put(p.getName(), true);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(SelectPetsMenu.getRemoveCurrentPet().getItemMeta().getDisplayName())) {
            if (!PetManager.getPetList().containsKey(p.getName())) {
                p.sendMessage(Main.getPrefix() + "§4You don't have a pet!");
                return;
            }

            for (World worlds : Bukkit.getWorlds()) {
                for (Chunk chunks : worlds.getLoadedChunks()) {
                    for (Entity entity : chunks.getEntities()) {
                        if (entity instanceof Wolf) {
                            if (((Wolf) entity).getCustomName().equals("§e§l" + p.getName().toUpperCase() + "§e§l's WOLF")) {
                                entity.remove();
                            }
                        } else if (entity instanceof Sheep) {
                            if (((Sheep) entity).getCustomName().equals("§e§l" + p.getName().toUpperCase() + "§e§l's SHEEP")) {
                                entity.remove();
                            }
                        }
                    }
                }
            }


            p.sendMessage(Main.getPrefix() + "§bYou removed your pet!");
            PetManager.getPetList().remove(p.getName());
        }
    }

    @EventHandler
    public void onPetHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;

        if (e.getEntity() instanceof Sheep && ((Sheep) e.getEntity()).getCustomName().contains("SHEEP")) {
            e.setCancelled(true);
            e.setDamage(0);
        } else if (e.getEntity() instanceof Wolf && ((Wolf) e.getEntity()).getCustomName().contains("WOLF")) {
            e.setCancelled(true);
            e.setDamage(0);
        }
    }

    @EventHandler
    public void onPetMenuInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(MainPetsMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> p.openInventory(MainPetsMenu.getInventory()), 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getBuy().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(BuyPetsMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPetsMenu.getSelect().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(SelectPetsMenu.getInventory());
        }
    }
}

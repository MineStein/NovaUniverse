package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.menu.toggles.MainToggleMenu;
import com.minestein.novauniverse.util.particle.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ToggleListener implements Listener {

    ArrayList<String> playerToggleCooldown = new ArrayList<>();
    ArrayList<String> jumpCooldown = new ArrayList<>();
    ArrayList<String> speedCooldown = new ArrayList<>();

    @EventHandler
    public void onOpen(PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!e.getItem().getItemMeta().getDisplayName().equals(Main.getToggles().getItemMeta().getDisplayName()))
            return;

        p.openInventory(MainToggleMenu.getInventory(p));
    }

    @EventHandler
    public void onSelectToggle(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        String[] text = new String[]{
                "§c§l§m----------------------------------------",
                "§bThis ability is on cooldown. Please wait.",
                "§c§l§m----------------------------------------"
        };

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(MainToggleMenu.getInventory(p).getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().equals(MainToggleMenu.getSpeedOff())) {
            if (speedCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(0, MainToggleMenu.getSpeedOn());
                p.sendMessage(Main.getPrefix() + "§bSpeed toggled §a§lon§b.");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999999, 2));

                speedCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    speedCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lSPEED §bis no longer on cooldown!");
                }, 40);
            }
        } else if (e.getCurrentItem().equals(MainToggleMenu.getSpeedOn())) {
            if (speedCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(0, MainToggleMenu.getSpeedOff());
                p.sendMessage(Main.getPrefix() + "§bSpeed toggled §4§loff§b.");

                for (PotionEffect activeEffects : p.getActivePotionEffects()) {
                    if (activeEffects.getType().equals(PotionEffectType.SPEED)) {
                        p.removePotionEffect(PotionEffectType.SPEED);
                    }
                }

                speedCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    speedCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lSPEED §bis no longer on cooldown!");
                }, 40);
            }
        }

        if (e.getCurrentItem().equals(MainToggleMenu.getTgglplyrsOff())) {
            if (playerToggleCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(2, MainToggleMenu.getTgglplyrsOn());
                p.sendMessage(Main.getPrefix() + "§bPlayer invisibility toggled §a§lon§b.");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(players);

                    if (players.getWorld() != p.getWorld()) continue;
                    if (players.getName().equals(p.getName())) continue;

                    ParticleEffect.FIREWORKS_SPARK.display(1, 1, 1, 1, 1000, players.getLocation(), 2.0);
                }

                playerToggleCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    playerToggleCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lPLAYER INVISIBILITY §bis no longer on cooldown!");
                }, 40);
            }
        } else if (e.getCurrentItem().equals(MainToggleMenu.getTgglplyrsOn())) {
            if (playerToggleCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(2, MainToggleMenu.getTgglplyrsOff());
                p.sendMessage(Main.getPrefix() + "§bPlayer invisibility toggled §4§loff§b.");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(players);

                    if (players.getWorld() != p.getWorld()) continue;
                    if (players.getName().equals(p.getName())) continue;

                    ParticleEffect.FIREWORKS_SPARK.display(1, 1, 1, 1, 1000, players.getLocation(), 2.0);
                }

                playerToggleCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    playerToggleCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lPLAYER INVISIBILITY §bis no longer on cooldown!");
                }, 40);
            }
        }

        if (e.getCurrentItem().equals(MainToggleMenu.getJumpOff())) {
            if (jumpCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(1, MainToggleMenu.getJumpOn());
                p.sendMessage(Main.getPrefix() + "§bJump toggled §a§lon§b.");

                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 2));

                jumpCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    jumpCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lJUMP §bis no longer on cooldown!");
                }, 40);
            }

        } else if (e.getCurrentItem().equals(MainToggleMenu.getJumpOn())) {
            if (jumpCooldown.contains(p.getName())) {
                for (int i = 0; i < 10; i++) {
                    p.sendMessage("");
                }
                p.sendMessage(text);
                return;
            } else {
                e.getInventory().setItem(1, MainToggleMenu.getJumpOff());
                p.sendMessage(Main.getPrefix() + "§bJump toggled §4§loff§b.");

                for (PotionEffect activeEffects : p.getActivePotionEffects()) {
                    if (activeEffects.getType().equals(PotionEffectType.JUMP)) {
                        p.removePotionEffect(PotionEffectType.JUMP);
                    }
                }

                jumpCooldown.add(p.getName());

                Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                    jumpCooldown.remove(p.getName());
                    p.sendMessage(Main.getPrefix() + "§e§lJUMP §bis no longer on cooldown!");
                }, 40);
            }
        }
    }
}

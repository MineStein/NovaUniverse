package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.PetManager;
import com.minestein.novauniverse.managers.TimeManager;
import com.minestein.novauniverse.util.general.JSONText;
import com.minestein.novauniverse.util.particle.ParticleEffect;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        final Player p = e.getPlayer();

        if (Main.isMaintenance()) {
            if (p.isOp()) return;
            if (p.hasPermission("novau.maintenance.bypass")) return;

            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "\n§c§l§m-=§4§lSorry, §e§l" + p.getName().toUpperCase() + "§c§l§m §c§l§m=-\n§b§lServer is currently in maintenance!\n§b§lCheck back later, maintenance doesn't last long!");
        } else {
            e.allow();
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final CraftPlayer p = (CraftPlayer) e.getPlayer();

        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 99999, 1, false));

        e.setJoinMessage(Main.getPrefix() + "§e§l" + p.getName().toUpperCase() + " §bjoined!");

        // "{\"text\":\"\",\"extra\":[{\"text\":\"§8[§5NOVA§6U§8] §bWelcome to the server! Click on this message for more §bhelp!\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/help\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"§bThis is a hover message! They\\n§bbe found quite often around\\n§bthe server!\"}}}]}"

        final JSONText text = new JSONText("[\n" +
                "    {\n" +
                "        \"text\": \"§8[§5NOVA§6U§8] §bClick this for help!\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/help \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§5§oProvides help for a specified\n§5§ocommand/gives you a list\n§5§oof all commands.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]", p);

        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 3; i++) {
                    p.sendMessage("");
                }

                text.playOut();
            }
        }, 5);

        final ItemStack divider = new ItemStack(Material.NETHER_STAR);
        {
            ItemMeta m = divider.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            divider.setItemMeta(m);
        }

        if (Main.getSpawnpoint() != null) {
            p.teleport(Main.getSpawnpoint());
        } else {
            p.teleport(new Location(Bukkit.getWorld("world"), 881, 14, 332));
        }

        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setSaturation(8F);
        p.setExp(0F);
        p.setLevel(0);
        p.setRemainingAir(300);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                ParticleEffect.FIREWORKS_SPARK.display(1, 1, 1, 1, 1000, p.getLocation(), 2.0);
                ParticleEffect.RED_DUST.display(1, 1, 1, 1, 1000, p.getLocation(), 2.0);

                p.getInventory().setItem(0, Main.getNvgtr());
                p.getInventory().setItem(1, Main.getDnte());
                p.getInventory().setItem(2, Main.getInfo());
                p.getInventory().setItem(3, Main.getWardrobe());
                p.getInventory().setItem(4, divider);
                p.getInventory().setItem(7, Main.getToggles());
                p.getInventory().setItem(8, Main.getPets());

                p.sendMessage(Main.getPrefix() + "§bThe party will happen in §e§l" + TimeManager.formatTime(Main.getPartySeconds()));
            }
        }, 20);


        Main.getOnline().setScore(Bukkit.getOnlinePlayers().length);

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(Main.getScoreboard());

            p.showPlayer(players);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        final Player p = e.getPlayer();

        for (PotionEffect effects : p.getActivePotionEffects()) {
            if (effects.getType().equals(PotionEffectType.POISON)) {
                p.removePotionEffect(PotionEffectType.POISON);
            }
        }

        for (World worlds : Bukkit.getWorlds()) {
            for (Chunk chunks : worlds.getLoadedChunks()) {
                for (Entity entity : chunks.getEntities()) {
                    if (!(entity instanceof Wolf)) continue;

                    Wolf wolf = (Wolf) entity;

                    if (PetManager.getPetList().containsKey(p.getName())) {
                        PetManager.getPetList().remove(p.getName());
                    }

                    if (wolf.isTamed()) {
                        if (wolf.getOwner().getName().equals(p.getName())) {
                            wolf.remove();
                        }
                    }
                }
            }
        }

        e.setQuitMessage(Main.getPrefix() + "§e§l" + p.getName().toUpperCase() + " §bleft!");

        Main.getOnline().setScore(Bukkit.getOnlinePlayers().length - 1);

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(Main.getScoreboard());
        }
    }
}

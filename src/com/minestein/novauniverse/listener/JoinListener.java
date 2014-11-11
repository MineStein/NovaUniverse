package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.AchievementManager;
import com.minestein.novauniverse.managers.PetManager;
import com.minestein.novauniverse.managers.TimeManager;
import com.minestein.novauniverse.util.general.JSONText;
import com.minestein.novauniverse.util.particle.ParticleEffect;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class JoinListener implements Listener {

    ArrayList<String> joined = new ArrayList<>();
    boolean alreadyPiggiieeee = false;

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        final Player p = e.getPlayer();

        if (Main.isMaintenance()) {
            if (p.isOp()) return;
            if (p.hasPermission("novau.maintenance.bypass")) return;

            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "\n§c§l§m-=§4§lSorry, §e§l" + p.getName().toUpperCase() + "§c§l§m §c§l§m=-\n§b§lThis server is currently in maintenance!\n§b§lCheck back later, maintenance usually doesn't last long!");
        } else {
            e.allow();
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final CraftPlayer p = (CraftPlayer) e.getPlayer();

        if (!alreadyPiggiieeee) {
            for (int i = 0; i < 5; i++) {
                if (i == 1) {
                    WitherSkull skull = p.getWorld().spawn(new Location(p.getWorld(), 881.5000, 14.5000, 341.5000), WitherSkull.class);
                    skull.setDirection(new Vector(0, 0, 0));
                    skull.setVelocity(new Vector(0, 0, 0));
                    Pig pig = p.getWorld().spawn(new Location(p.getWorld(), 881.5000, 14.5000, 341.5000), Pig.class);
                    pig.setCustomName("§c§lPiggieeeee");
                    pig.setCustomNameVisible(true);
                    skull.setPassenger(pig);
                } else if (i == 2) {
                    WitherSkull skull = p.getWorld().spawn(new Location(p.getWorld(), 872.5000, 14.5000, 332.5000), WitherSkull.class);
                    skull.setDirection(new Vector(0, 0, 0));
                    skull.setVelocity(new Vector(0, 0, 0));
                    Sheep sheep = p.getWorld().spawn(new Location(p.getWorld(), 872.5000, 14.5000, 332.5000), Sheep.class);
                    sheep.setCustomName("§9§lSheepieeeee");
                    sheep.setColor(DyeColor.PURPLE);
                    sheep.setCustomNameVisible(true);
                    skull.setPassenger(sheep);
                } else if (i == 3) {
                    WitherSkull skull = p.getWorld().spawn(new Location(p.getWorld(), 881.5000, 14.5000, 323.5000), WitherSkull.class);
                    skull.setDirection(new Vector(0, 0, 0));
                    skull.setVelocity(new Vector(0, 0, 0));
                    Cow cow = p.getWorld().spawn(new Location(p.getWorld(), 881.5000, 14.5000, 323.5000), Cow.class);
                    cow.setCustomName("§e§lBob");
                    cow.setCustomNameVisible(true);
                    skull.setPassenger(cow);
                } else if (i == 4) {
                    WitherSkull skull = p.getWorld().spawn(new Location(p.getWorld(), 893.5000, 14.5000, 332.5000), WitherSkull.class);
                    skull.setDirection(new Vector(0, 0, 0));
                    skull.setVelocity(new Vector(0, 0, 0));
                    Wolf wolf = p.getWorld().spawn(new Location(p.getWorld(), 893.5000, 14.5000, 332.5000), Wolf.class);
                    wolf.setCustomName("§a§lWolfieeeee");
                    wolf.setTamed(true);
                    wolf.setSitting(true);
                    wolf.setCollarColor(DyeColor.PURPLE);
                    wolf.setCustomNameVisible(true);
                    skull.setPassenger(wolf);
                }
            }

            // 881.5000
            // 14
            // 341

            // 872
            // 14
            // 332

            // 881
            // 14
            // 323

            // 893
            // 14
            // 332

            alreadyPiggiieeee = true;
        }

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

        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {

            for (int i = 0; i < 3; i++) {
                p.sendMessage("");
            }

            text.playOut();
        }, 5);

        final ItemStack divider = new ItemStack(Material.NETHER_STAR);
        {
            ItemMeta m = divider.getItemMeta();
            m.setDisplayName("§5§lNOVA§6§lU");
            divider.setItemMeta(m);
        }

        p.teleport(new Location(Bukkit.getWorld("world"), 881, 14, 332));

        p.setMaxHealth(20.0);
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setSaturation(8F);
        p.setExp(0F);
        p.setLevel(10000);
        p.setRemainingAir(300);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
            ParticleEffect.FIREWORKS_SPARK.display(1, 1, 1, 1, 1000, p.getLocation(), 2.0);
            ParticleEffect.RED_DUST.display(1, 1, 1, 1, 1000, p.getLocation(), 2.0);

            p.getInventory().setItem(0, Main.getNvgtr());
            p.getInventory().setItem(1, Main.getDnte());
            p.getInventory().setItem(2, Main.getInfo());
            p.getInventory().setItem(3, Main.getWardrobe());
            p.getInventory().setItem(4, divider);
            p.getInventory().setItem(6, Main.getMusicSelector());
            p.getInventory().setItem(7, Main.getToggles());
            p.getInventory().setItem(8, Main.getPets());

            p.sendMessage(Main.getPrefix() + "§bThe party will happen in §e§l" + TimeManager.formatTime(Main.getPartySeconds()));

            if (!joined.contains(p.getName())) {
                for (int i = 0; i < 3; i++) {
                    p.sendMessage("");
                }

                p.sendMessage(AchievementManager.generateAchievementMessage(AchievementManager.Achievement.WELCOME));
                joined.add(p.getName());
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

        p.getActivePotionEffects().stream().filter(effects -> effects.getType().equals(PotionEffectType.POISON) || effects.getType().equals(PotionEffectType.SPEED) || effects.getType().equals(PotionEffectType.JUMP)).forEach(effects -> {
            p.removePotionEffect(effects.getType());
        });

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

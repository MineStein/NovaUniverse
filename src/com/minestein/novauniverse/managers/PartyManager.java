package com.minestein.novauniverse.managers;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PartyManager extends BukkitRunnable {

    @Override
    public void run() {
        if (Main.getPartySeconds() <= 3001) {
            Main.setPartySeconds(Main.getPartySeconds() - 1);

            Main.getPartyTimeLeft().setScore(Main.getPartySeconds());

            if (Main.getPartySeconds() == 3000 ||
                    Main.getPartySeconds() == 1500 ||
                    Main.getPartySeconds() == 2000 ||
                    Main.getPartySeconds() == 2500 ||
                    Main.getPartySeconds() == 1000 ||
                    Main.getPartySeconds() == 500 ||
                    Main.getPartySeconds() == 250 ||
                    Main.getPartySeconds() == 150 ||
                    Main.getPartySeconds() == 120 ||
                    Main.getPartySeconds() == 100 ||
                    Main.getPartySeconds() == 75 ||
                    Main.getPartySeconds() == 60 ||
                    Main.getPartySeconds() == 30 ||
                    Main.getPartySeconds() == 15 ||
                    Main.getPartySeconds() == 10 ||
                    Main.getPartySeconds() <= 5 && Main.getPartySeconds() > 0) {
                ChatUtil.broadcast(TimeManager.formatTime(Main.getPartySeconds()) + " §buntil party time!");
            } else if (Main.getPartySeconds() == 0) {
                Player[] online = Bukkit.getOnlinePlayers();
                Random random = new Random();
                Player selected = online[random.nextInt(online.length)];

                if (selected == null) {
                    Main.setPartySeconds(3001);
                    ChatUtil.broadcast("There was no winner for this party!");
                    return;
                }

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.getName().equals(selected.getName())) continue;

                    players.sendMessage(Main.getPrefix() + "§e§l" + selected.getName() + " §bhas won the party!");
                }

                selected.sendMessage(Main.getPrefix() + "§6§lYou have won the party!");

                Main.setPartySeconds(3001);
            }
        }
    }
}

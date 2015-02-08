package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ****************************************************************************************
 * Copyright MineStein © 2015
 * <p>
 * Any code contained within this document, and any associated API's with similar branding
 * are the sole property of MineStein. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * <p>
 * Thanks, and have a nice day.
 * ****************************************************************************************
 */
public class Time implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length==0) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                World world = p.getWorld();
                long fullTimeIn = world.getFullTime();
                long fullSecondsIn = fullTimeIn / 20;
                long minutesIn = fullSecondsIn / 60;
                long secondsIn = fullSecondsIn % 60;
                long fullTimeLeft = 24000 - fullTimeIn;
                long fullSecondsLeft = fullTimeLeft / 20;
                long minutesLeft = fullSecondsLeft / 60;
                long secondsLeft = fullSecondsLeft % 60;
                String[] text = new String[] {
                        "§bTime in §a§l"+world.getName(),
                        "§6§l§m------------------------------",
                        "§7Time in (ticks): §e§l§o"+fullTimeIn,
                        "§7Time in (seconds): §e§l§o"+fullSecondsIn,
                        "§7Time in: §e§l§o"+minutesIn+"m"+secondsIn+"s",
                        "§7Time left (ticks): §e§l§o"+fullTimeLeft,
                        "§7Time left (seconds): §e§l§o"+fullSecondsLeft,
                        "§7Time left: §e§l§o"+minutesLeft+"m"+secondsLeft+"s"
                };

                p.sendMessage(text);
            } else {
                sender.sendMessage(StockMessages.usage("time <world>"));
            }
        } else {
            if (Bukkit.getWorld(args[0])==null) {
                sender.sendMessage(Main.getPrefix()+"§4Could not find the world §c§l"+args[0]);
                return true;
            }

            World world = Bukkit.getWorld(args[0]);
            long fullTimeIn = world.getFullTime();
            long fullSecondsIn = fullTimeIn / 20;
            long minutesIn = fullSecondsIn / 60;
            long secondsIn = fullSecondsIn % 60;
            long fullTimeLeft = 24000 - fullTimeIn;
            long fullSecondsLeft = fullTimeLeft / 20;
            long minutesLeft = fullSecondsLeft / 60;
            long secondsLeft = fullSecondsLeft % 60;
            String[] text = new String[] {
                "§bTime in §a§l"+world.getName(),
                    "§6§l§m------------------------------",
                    "§7Time in (ticks): §e§l§o"+fullTimeIn,
                    "§7Time in (seconds): §e§l§o"+fullSecondsIn,
                    "§7Time in: §e§l§o"+minutesIn+"m"+secondsIn+"s",
                    "§7Time left (ticks): §e§l§o"+fullTimeLeft,
                    "§7Time left (seconds): §e§l§o"+fullSecondsLeft,
                    "§7Time left: §e§l§o"+minutesLeft+"m"+secondsLeft+"s"
            };

            sender.sendMessage(text);
        }
        return true;
    }
}

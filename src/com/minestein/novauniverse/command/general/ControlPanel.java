package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ControlPanel implements CommandExecutor {

    /*
     * statistics/stats <player> <game> - gets statistics
     * record <player> - gets hacking record
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        final String TAG = "§5Nova§cCP§e§l>> §f";

        if (args.length == 0) {
            String[] text = new String[]{
                    "§e§lCommand Help for /controlpanel",
                    "§6§l§m----------------------------------------",
                    "§e§l>> §7/controlpanel §7§ostatistics <player> <game>",
                    "     §7Aliase: §7§o/cp stats <player> <game>",
                    "     §7Hint: §7§o/controlpanel statistics help",
                    "§e§l>> §7/controlpanel §7§orecord <player>",
            };

            sender.sendMessage(text);
            return true;
        } else {
            String sub = args[0];

            if (args.length == 1) {
                if (sub.equalsIgnoreCase("stats") || sub.equalsIgnoreCase("statistics") || sub.equalsIgnoreCase("record")) {
                    sender.sendMessage(TAG + "§4Too few arguments!");
                } else {
                    sender.sendMessage(TAG + "§4Could not identify sub-command §c" + sub);
                    return true;
                }
            } else if (args.length == 2) {
                final Player p = Bukkit.getPlayer(args[1]);

                if (sub.equalsIgnoreCase("statistics") || sub.equalsIgnoreCase("stats")) {
                    sender.sendMessage(TAG + "§4Too few arguments for sub-command §c" + sub);
                    return true;
                } else if (sub.equalsIgnoreCase("record")) {
                    // TODO Query database.

                    sender.sendMessage(TAG + "§4Testing the waters...");
                    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(TAG + "§4Grabbing information...");
                        }
                    }, 20);
                    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(TAG + "§4Failed.");
                        }
                    }, 20);
                    return true;
                } else {
                    sender.sendMessage(TAG + "§4Could not identify sub-command §c" + sub);
                    return true;
                }
            } else if (args.length == 3) {
                String game = args[2];
                Player p;

                if (args[1].equalsIgnoreCase("help")) {
                    String[] text = new String[]{
                            "§e§lCommand Help for /controlpanel statistics",
                            "§7Usage: §7§o/controlpanel statistics <player> <game>",
                            "§6§l§m----------------------------------------",
                            "§e§l>> §7SG §8- §7§oSurvival Games",
                            "§e§l>> §7UHC §8- §7§oUltra-Hardcore",
                            "§e§l>> §7BMT §8- §7§oBuild My Thing",
                            "§e§l>> §7S §8- §7§oSpleef",
                            "§e§l>> §7FR §8- §7§oFreerunners",
                            "§e§l>> §7TR §8- §7§oTNT Run",
                            "§e§l>> §7GTM §8- §7§oGrand Theft Minecart",
                            "§e§l>> §7BD §8- §7§oBlocking Dead",
                            "§e§l>> §7WW §8- §7§oWatch Wolves"
                    };

                    sender.sendMessage(text);
                    return true;
                }

                if (Bukkit.getPlayer(args[1]) != null) {
                    p = Bukkit.getPlayer(args[1]);

                    if (!game.equalsIgnoreCase("sg") &&
                            !game.equalsIgnoreCase("uhc") &&
                            !game.equalsIgnoreCase("bmt") &&
                            !game.equalsIgnoreCase("s") &&
                            !game.equalsIgnoreCase("fr") &&
                            !game.equalsIgnoreCase("tr") &&
                            !game.equalsIgnoreCase("gtm") &&
                            !game.equalsIgnoreCase("bd") &&
                            !game.equalsIgnoreCase("ww")) {
                        sender.sendMessage(TAG + "§4Could not identify game §c" + game);
                        return true;
                    }

                    String[] text = new String[]{
                            "§e§l" + p.getName().toUpperCase() + "'s Statistics for " + game.toUpperCase(),
                            "§6§l§m----------------------------------------",
                            "§e§l>> §7Stat1: §e0",
                            "§e§l>> §7Stat2: §e1",
                            "§e§l>> §7Stat3: §e2",
                    };

                    sender.sendMessage(text);
                    return true;
                } else {
                    sender.sendMessage(TAG + "§4Could not identify player §c" + args[1]);
                    return true;
                }
            } else {
                if (sub.equalsIgnoreCase("statistics") || sub.equalsIgnoreCase("stats") || sub.equalsIgnoreCase("record")) {
                    sender.sendMessage(TAG + "§4Too many arguments for sub-command §c" + sub);
                    return true;
                } else {
                    sender.sendMessage(TAG + "§4Could not identify sub-command §c" + sub);
                    return true;
                }
            }
            return true;
        }
    }
}

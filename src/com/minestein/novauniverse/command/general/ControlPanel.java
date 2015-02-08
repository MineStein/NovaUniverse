package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.util.sql.MySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.ResultSet;
import java.sql.SQLException;

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
                    "§e§l>> §7/controlpanel §7§oban <player> <indefinite?> <reason>",
                    "§e§l>> §7/controlpanel §7§ounban <player>",
                    "§e§l>> §7/controlpanel §7§ogetban <player>"
            };

            sender.sendMessage(text);
            return true;
        }

        if (args.length==1) {
            String sub = args[0];

            if (sub.equalsIgnoreCase("statistics")||sub.equalsIgnoreCase("record")||sub.equalsIgnoreCase("ban")||sub.equalsIgnoreCase("unban")||sub.equalsIgnoreCase("getban"))  {
                sender.sendMessage(TAG+"§4Too few arguments!");
            } else {
                sender.sendMessage(TAG+"§4Unknown sub-command!");
            }
        }

        if (args.length==2) {
            String sub = args[0];
            String player = args[1];

            if (sub.equalsIgnoreCase("unban")) {
                try {
                    ResultSet check = MySQL.connection.prepareStatement("SELECT name FROM bans WHERE name='"+player+"'").executeQuery();

                    if (check.next()) {
                        MySQL.connection.prepareStatement("DELETE FROM bans WHERE name='"+player+"'").executeUpdate();
                        sender.sendMessage(TAG+"§bYou successfully unbanned §e§l"+player.toUpperCase());
                    } else {
                        sender.sendMessage(TAG+"§e§l"+player.toUpperCase()+" §bis not banned!");
                    }
                } catch (SQLException e) {
                    sender.sendMessage(TAG+"§4Failed to unban §c§l"+player+" §4due to an error! Logging...");
                    e.printStackTrace();
                }
            } else if (sub.equalsIgnoreCase("getban")) {
                try {
                    ResultSet check = MySQL.connection.prepareStatement("SELECT name FROM bans WHERE name='"+player+"'").executeQuery();

                    if (check.next()) {
                        ResultSet reason = MySQL.connection.prepareStatement("SELECT reason FROM bans WHERE name='"+player+"'").executeQuery();
                        ResultSet indefiniteCheck = MySQL.connection.prepareStatement("SELECT indefinite FROM bans WHERE name='"+player+"'").executeQuery();

                        String indefinite = (indefiniteCheck.getBoolean("indefinite")) ? "§c§l§oYES" : "§a§l§oNO";

                        String[] record = new String[] {
                            "§e§l"+player.toUpperCase()+"'s §bBan Record",
                                "§6§l§m------------------------------",
                                "§7Reason: §e§l§o"+reason.getString("reason"),
                                "§7Indefinite: "+indefinite
                        };

                        sender.sendMessage(record);
                    } else {
                        sender.sendMessage(TAG+"§e§l"+player.toUpperCase()+" §bis not banned!");
                    }
                } catch (SQLException e) {
                    sender.sendMessage(TAG+"§4Failed to get ban information for §c§l"+player+" §4due to an error! Logging...");
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}

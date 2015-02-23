package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import com.minestein.novauniverse.util.sql.MySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class Profile implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(StockMessages.onlyPlayers());
        }

        if (args.length==0) {
            String[] text = new String[] {
                    "§bCommand Help for §b/profile",
                    "§6§l§m------------------------------",
                    "§e§l>> §7/profile §7§oget",
                    "§e§l>> §7/profile §7§osetdescription <message>",
                    "§e§l>> §7/profile §7§osetbirthday <day> <month> <year>",
                    "§e§l>> §7/profile §7§osetlocation <location>",
            };

            sender.sendMessage(text);
        } else if (args.length==1) {
            String sub = args[0];

            if (sub.equalsIgnoreCase("get")) {
                try {
                    PreparedStatement stmt = MySQL.connection.prepareStatement("SELECT * FROM users WHERE name='"+sender.getName()+"'");
                    ResultSet set = stmt.executeQuery();

                    if (set.next()) {
                        String[] text = new String[] {
                                "§e§l"+sender.getName().toUpperCase()+"'s §bProfile",
                                "§6§l§m------------------------------",
                                "§7Last seen: §e"+set.getString("lastSeen"),
                                "§7Description: §e"+set.getString("description"),
                                "§7Birthday: §e"+set.getString("birthday"),
                                "§7Location: §e"+set.getString("location")
                        };

                        sender.sendMessage(text);
                    } else {
                        sender.sendMessage(Main.getPrefix()+"§4You don't have an account!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (sub.equalsIgnoreCase("setdescription")||sub.equalsIgnoreCase("setbirthday")||sub.equalsIgnoreCase("setlocation")) {
                sender.sendMessage(StockMessages.tooFewArguments());
            } else {
                sender.sendMessage(StockMessages.unknownCommand());
            }
        } else if (args.length==2||args.length==3&&(args[0].equalsIgnoreCase("setbirthday"))) {
            sender.sendMessage(StockMessages.tooFewArguments());
        } else if (args.length>=2&&!args[0].equalsIgnoreCase("setbirthday")) {
            String sub = args[0];
            StringBuilder builder = new StringBuilder();

            if (sub.equalsIgnoreCase("setbirthday")&&args.length>3) {
                sender.sendMessage(StockMessages.tooManyArguments());
                return true;
            }

            for (int i = 1; i < args.length; i++) {
                builder
                        .append(args[i])
                        .append(" ");
            }

            String message = builder.toString();

            if (sub.equalsIgnoreCase("setdescription")) {
                try {
                    MySQL.connection.prepareStatement("UPDATE users SET description='"+message+"' WHERE name='"+sender.getName()+"'").executeUpdate();
                    sender.sendMessage(Main.getPrefix()+"§a§lSUCCESS! §aYou changed your description to: §e§o"+message);
                } catch (SQLException e) {
                    sender.sendMessage(Main.getPrefix()+"§4Failed to execute update! Logging...");
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}

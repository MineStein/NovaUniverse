package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import com.minestein.novauniverse.util.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
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
public class Statistics implements CommandExecutor {

    Connection c = MySQL.connection;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length==0) {
            if (sender instanceof Player) {
                try {
                    ResultSet points = c.prepareStatement("SELECT points FROM users WHERE name='"+sender.getName()+"'").executeQuery();
                    ResultSet credits = c.prepareStatement("SELECT credits FROM users WHERE name='"+sender.getName()+"'").executeQuery();

                    StringBuilder stats = new StringBuilder();

                    stats
                            .append("§bStatistics for §e§l"+sender.getName().toUpperCase())
                            .append("\n")
                            .append("§6§l§m------------------------------")
                            .append("\n");

                    if (!points.next()||!credits.next()) {
                        sender.sendMessage(Main.getPrefix()+"§4You don't have any statistics! Generating new ones...");
                        c.prepareStatement("INSERT INTO users (name) VALUES ('"+sender.getName()+"')").executeUpdate();
                        sender.sendMessage(Main.getPrefix()+"§a§l§oNew statistics generated for §e§l"+sender.getName());
                        return true;
                    }

                    stats
                            .append("§7Credits: §e§l"+credits.getInt("credits"))
                            .append("\n")
                            .append("§7Points: §e§l"+points.getInt("points"));

                    sender.sendMessage(stats.toString());
                } catch (SQLException e) {
                    sender.sendMessage(Main.getPrefix()+"§4Uh oh! Failed to download statistics!");
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage(StockMessages.usage("stats <Player>"));
            }
        } else if (args.length==1) {
            try {
                ResultSet points = c.prepareStatement("SELECT points FROM users WHERE name='"+args[0]+"'").executeQuery();
                ResultSet credits = c.prepareStatement("SELECT credits FROM users WHERE name='"+args[0]+"'").executeQuery();

                StringBuilder stats = new StringBuilder();

                stats
                        .append("§bStatistics for §e§l"+args[0].toUpperCase())
                        .append("\n")
                        .append("§6§l§m------------------------------");

                if (!points.next()||!credits.next()) {
                    if (Bukkit.getPlayer(args[0])!=null) {
                        Player p = Bukkit.getPlayer(args[0]);

                        sender.sendMessage(Main.getPrefix()+"§4Could not locate §c§l"+args[0].toUpperCase()+"'s §4statistics! Alerting them...");
                        p.sendMessage(Main.getPrefix() + "§4You don't have any statistics! Generating new ones...");
                        c.prepareStatement("INSERT INTO users (name) VALUES ('"+p.getName()+"')").executeUpdate();
                        p.sendMessage(Main.getPrefix() + "§a§l§oNew statistics generated for §e§l" + sender.getName());
                    } else {
                        sender.sendMessage(Main.getPrefix()+"§4Could not locate §c§l"+args[0].toUpperCase()+"'s §4statistics! They will be alerted when they check their statistics.");
                    }

                    return true;
                }

                stats
                        .append("§7Credits: §e§l"+credits.getInt("credits"))
                        .append("\n")
                        .append("§7Points: §e§l"+points.getInt("points"));

                sender.sendMessage(stats.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

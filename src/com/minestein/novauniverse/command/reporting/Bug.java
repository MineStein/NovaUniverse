package com.minestein.novauniverse.command.reporting;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.sql.MySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.SQLException;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Bug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Main.getPrefix() + "§4/bug §c<Message>");
            return true;
        } else {
            if (args.length >= 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    stringBuilder.append(args[i].concat(" "));
                }

                String report = stringBuilder.toString();

                try {
                    MySQL.connection.prepareStatement("INSERT INTO bugs (reportedBy, report, server) VALUES ('"+sender.getName()+"', '"+report+"', 'lobby')").executeUpdate();
                    sender.sendMessage(Main.getPrefix() +"§bThanks for reporting the following bug: §e§l"+report.toUpperCase());
                } catch (SQLException e) {
                    sender.sendMessage(Main.getPrefix()+"§4Failed to report bug. Logging...");
                    e.printStackTrace();
                }

                return true;
            }
            return true;
        }
    }
}

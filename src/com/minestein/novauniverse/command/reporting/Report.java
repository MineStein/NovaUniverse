package com.minestein.novauniverse.command.reporting;

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
public class Report implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Main.getPrefix() + "§4/report §c<Player> <Message>");
            return true;
        } else if (args.length == 1) {
            sender.sendMessage(Main.getPrefix() + "§4/report <Player> §c<Message>");
            return true;
        } else {
            if (args.length > 1) {
                Player target = Bukkit.getPlayer(args[0]);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    stringBuilder.append(args[i].concat(" "));
                }

                String report = stringBuilder.toString();
                sender.sendMessage(Main.getPrefix() + "§bThank you for reporting §e§l"+target.getName().toUpperCase()+" §bfor §e§l"+report.toUpperCase());
                return true;
            }
            return true;
        }
    }
}

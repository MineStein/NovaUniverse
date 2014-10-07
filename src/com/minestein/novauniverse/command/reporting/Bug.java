package com.minestein.novauniverse.command.reporting;

import com.minestein.novauniverse.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
                sender.sendMessage(Main.getPrefix() + "§aThank you! You reported the following §c§lbug§8: §e" + report + "§a.");
                return true;
            }
            return true;
        }
    }
}

package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            String[] message = new String[]{

            };

            for (int i = 0; i < 2; i++) {
                sender.sendMessage("");
            }
            sender.sendMessage(message);
            for (int i = 0; i < 2; i++) {
                sender.sendMessage("");
            }
            return true;
        } else {
            sender.sendMessage(Main.getPrefix() + "§4Too many arguments!");
            return true;
        }
    }
}

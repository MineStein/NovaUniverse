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
public class SkinReport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Main.getPrefix() + "§4/skinreport §c<Player> <Message>");
            return true;
        } else if (args.length == 1) {
            sender.sendMessage(Main.getPrefix() + "§4/skinreport <Player> §c<Message>");
            return true;
        } else {
            if (args.length > 1) {

            }
        }
        return true;
    }
}

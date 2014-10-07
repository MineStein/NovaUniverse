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
     * stats <player> <game> - gets statistics
     * record <player> - gets hacking record
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Main.getPrefix() + "§7Usage: §4/controlpanel §c<Command> <Parameters>");
            return true;
        } else {
            if (args.length == 1) {
                sender.sendMessage(Main.getPrefix() + "§7Usage: §4/controlpanel §c<Command> <Parameters>");
                return true;
            } else if (args.length == 2) {
                String subcommand = args[0];
                Player target = Bukkit.getPlayer(args[1]);
                if (subcommand.equals("stats")) {
                    sender.sendMessage(Main.getPrefix() + "§4Too few arguments!");
                    return true;
                } else if (subcommand.equals("record")) {
                    sender.sendMessage(Main.getPrefix() + "§4Could not access §e§l" + args[1].toUpperCase() + "'s §4record!");
                    // TODO Grab info from sql
                    return true;
                } else {
                    sender.sendMessage(Main.getPrefix() + "§4Unknown sub-command.");
                    return true;
                }
            } else if (args.length == 3) {
                String subcommand = args[0];
                Player target = Bukkit.getPlayer(args[1]);
                String game = args[2];

                if (subcommand.equals("stats")) {
                    sender.sendMessage(Main.getPrefix() + "§4Could not access §e§l" + args[1].toUpperCase() + "'s §4statistics");
                    return true;
                } else if (subcommand.equals("record")) {
                    sender.sendMessage(Main.getPrefix() + "§4Too many arguments!");
                    return true;
                } else {
                    sender.sendMessage(Main.getPrefix() + "§4Unknown sub-command.");
                    return true;
                }
            }
            return true;
        }
    }
}

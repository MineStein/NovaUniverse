package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
public class Visibility implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.visibility")) {
            sender.sendMessage(StockMessages.noPermission());
            return true;
        }

        if (args.length==0) {
            // TODO Display menu

            /**
             * /v hide <player to hide:self> <player to hide from:all>
             * /v show <player to show:self> <player to show for:all>
             */
        } else if (args.length==1||args.length==2) {
            sender.sendMessage(StockMessages.tooFewArguments());
        } else if (args.length==3) {
            String sub = args[0];
            String p1 = args[1];
            String p2 = args[2];

            if (sub.equalsIgnoreCase("hide")) {
                if (p2.equalsIgnoreCase("all")) {

                } else {

                }
            } else if (sub.equalsIgnoreCase("show")) {
                if (p2.equalsIgnoreCase("all")) {

                } else {

                }
            } else {
                sender.sendMessage(Main.getPrefix()+"§4Unknown sub-command!");
            }
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

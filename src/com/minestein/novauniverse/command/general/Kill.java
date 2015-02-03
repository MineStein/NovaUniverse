package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
public class Kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.kill")) {
            sender.sendMessage(StockMessages.noPermission());
            return true;
        }

        if (args.length==0) {
            sender.sendMessage(StockMessages.usage("kill <player>"));
        } else if (args.length==1) {
            String args0 = args[0];

            if (Bukkit.getPlayer(args0)==null) {
                sender.sendMessage(StockMessages.offlinePlayer());
                return true;
            }

            Player target = Bukkit.getPlayer(args0);

            target.setHealth(20.0);
            sender.sendMessage(Main.getPrefix()+"§bYou killed §e§l"+args0.toUpperCase());
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

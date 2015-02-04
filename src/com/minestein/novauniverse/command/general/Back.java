package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Location;
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
public class Back implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(StockMessages.onlyPlayers());
            return true;
        }

        if (!sender.hasPermission("novau.back")) {
            sender.sendMessage(StockMessages.noPermission());
            return true;
        }

        Player p = (Player) sender;

        if (args.length==0) {
            if (CommandManager.getTeleportCache().containsKey(p.getName())) {
                Location loc = CommandManager.getTeleportCache().get(p.getName());

                p.sendMessage(StockMessages.teleporting());
                p.teleport(loc);
            } else {
                p.sendMessage(Main.getPrefix()+"§4You haven't teleported anywhere!");
            }
        } else {
            p.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

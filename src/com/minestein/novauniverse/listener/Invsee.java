package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

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
public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(StockMessages.onlyPlayers());
            return true;
        }

        final Player p = (Player) sender;

        if (!p.hasPermission("novau.invsee")) {
            p.sendMessage(StockMessages.noPermission());
            return true;
        }

        if (args.length==0) {
            p.sendMessage(StockMessages.usage("invsee <player>"));
        } else if (args.length==1) {
            if (Bukkit.getPlayer(args[0])!=null) {
                final Player target = Bukkit.getPlayer(args[0]);
                final Inventory i = Bukkit.createInventory(null, 36, target.getName()+"'s Inventory");
                i.setContents(target.getInventory().getContents());

                p.openInventory(i);
            } else {
                p.sendMessage(StockMessages.offlinePlayer());
            }
        } else {
            p.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}
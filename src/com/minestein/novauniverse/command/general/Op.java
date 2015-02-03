package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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
public class Op implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.op")) {
            sender.sendMessage(Main.getPrefix()+"§4You don't have permission!");
            return true;
        }

        if (args.length==0) {
            sender.sendMessage(Main.getPrefix()+"§7Usage: §4/op <player>");
        } else if (args.length==1) {
            final String args0 = args[0];
            final OfflinePlayer p = Bukkit.getOfflinePlayer(args0);

            Bukkit.getOperators().add(p);
            ChatUtil.broadcast("§7§o{Console: §6Opped §e§l"+args0+" §7}");
        }
        return true;
    }
}

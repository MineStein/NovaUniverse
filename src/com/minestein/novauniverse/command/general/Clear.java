package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

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
public class Clear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.clear")) {
            sender.sendMessage(StockMessages.noPermission());
            return true;
        }

        if (args.length==0) {
            if (sender instanceof Player) {
                PlayerInventory pi = ((Player) sender).getInventory();

                pi.clear();
                pi.setArmorContents(null);
                sender.sendMessage(Main.getPrefix()+"§bYou cleared your inventory!");
            } else {
                sender.sendMessage(StockMessages.usage("clear <player>"));
            }
        } else if (args.length==1) {
            String sub = args[0];

            if (Bukkit.getPlayer(args[0])==null) {
                sender.sendMessage(StockMessages.offlinePlayer());
                return true;
            }

            PlayerInventory ti = Bukkit.getPlayer(args[0]).getInventory();

            ti.clear();
            ti.setArmorContents(null);
            Bukkit.getPlayer(args[0]).sendMessage(Main.getPrefix()+"§e§l"+sender.getName()+" §bcleared your inventory!");
         } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

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
public class Leash implements CommandExecutor {

    public static ArrayList<String> leashed = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.leash")) {
            sender.sendMessage(StockMessages.noPermission());
            return true;
        }

        if (args.length==0) {
            sender.sendMessage(StockMessages.usage("leash <player>"));
        } else if (args.length==1) {
            if (Bukkit.getPlayer(args[0])!=null) {
                Player target = Bukkit.getPlayer(args[0]);

                if (leashed.contains(target.getName())) {
                    leashed.remove(target.getName());
                    sender.sendMessage(Main.getPrefix()+"§bYou unleashed §e§l"+target.getName().toUpperCase());
                    target.sendMessage(Main.getPrefix()+"§bYou have been unleashed!");
                } else {
                    leashed.add(target.getName());
                    sender.sendMessage(Main.getPrefix()+"§bYou leashed §e§l"+target.getName().toUpperCase());
                    target.sendMessage(Main.getPrefix()+"§bYou have been leashed!");
                }
            } else {
                sender.sendMessage(StockMessages.offlinePlayer());
            }
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

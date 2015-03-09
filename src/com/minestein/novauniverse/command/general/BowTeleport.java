package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import com.minestein.novauniverse.util.general.StockMessages;
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
public class BowTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length==0) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (CommandManager.getBowteleportCache().contains(p.getName())) {
                    CommandManager.getBowteleportCache().remove(p.getName());
                    p.sendMessage(Main.getPrefix()+"§bYou §c§l§oDISABLED §bbow teleportation!");
                } else {
                    CommandManager.getBowteleportCache().add(p.getName());
                    p.sendMessage(Main.getPrefix()+"§bYou §a§l§oENABLED §bbow teleportation!");
                }
            } else {
                sender.sendMessage(StockMessages.onlyPlayers());
            }
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

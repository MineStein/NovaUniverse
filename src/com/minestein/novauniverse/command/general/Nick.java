package com.minestein.novauniverse.command.general;

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
public class Nick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            ((Player) sender).setPlayerListName("§c"+sender.getName());
        }
        return true;
    }
}

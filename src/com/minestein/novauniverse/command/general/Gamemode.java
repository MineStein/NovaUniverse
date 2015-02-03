package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("novau.gamemode")) {
            sender.sendMessage(Main.getPrefix()+"§4You don't have permission!");
        }

        Player p = (Player) sender;

        if (args.length==0) {
            sender.sendMessage(Main.getPrefix()+"§7Usage: §4/gamemode <gamemode/target> [gamemode]");
        } else if (args.length==1) {
            String args0 = args[0];
            String gamemode;

            if (args0.equalsIgnoreCase("survival")||args0.equalsIgnoreCase("s")||args0.equalsIgnoreCase("0")) {
                gamemode = "survival";
                p.setGameMode(GameMode.SURVIVAL);
            } else if (args0.equalsIgnoreCase("creative")||args0.equalsIgnoreCase("c")||args0.equalsIgnoreCase("1")) {
                gamemode = "creative";
                p.setGameMode(GameMode.CREATIVE);
            } else if (args0.equalsIgnoreCase("adventure")||args0.equalsIgnoreCase("a")||args0.equalsIgnoreCase("2")) {
                gamemode = "adventure";
                p.setGameMode(GameMode.ADVENTURE);
            } else {
                p.sendMessage(Main.getPrefix()+"§4Unknown gamemode");
                return true;
            }

            p.sendMessage(Main.getPrefix()+"§bYou changed your gamemode to §e§l§o"+gamemode.toUpperCase());
        } else if (args.length==2) {
            String args0 = args[0];
            String gamemode;

            if (Bukkit.getPlayer(args[1])!=null) {
                p.sendMessage(Main.getPrefix()+"§4That player is offline!");
                return true;
            }
            
            Player target = Bukkit.getPlayer(args[0]);

            if (args0.equalsIgnoreCase("survival")||args0.equalsIgnoreCase("s")||args0.equalsIgnoreCase("0")) {
                gamemode = "survival";
                target.setGameMode(GameMode.SURVIVAL);
            } else if (args0.equalsIgnoreCase("creative")||args0.equalsIgnoreCase("c")||args0.equalsIgnoreCase("1")) {
                gamemode = "creative";
                target.setGameMode(GameMode.CREATIVE);
            } else if (args0.equalsIgnoreCase("adventure")||args0.equalsIgnoreCase("a")||args0.equalsIgnoreCase("2")) {
                gamemode = "adventure";
                target.setGameMode(GameMode.ADVENTURE);
            } else {
                p.sendMessage(Main.getPrefix()+"§4Unknown gamemode");
                return true;
            }

            p.sendMessage(Main.getPrefix()+"§bYou changed §e§l"+target.getName()+"'s §bgamemode to §e§l§o"+gamemode.toUpperCase());
            target.sendMessage(Main.getPrefix()+"§e§l"+p.getName()+" §bchanged your gamemode to §e§l§o"+gamemode.toUpperCase());
        }
        return true;
    }
}

package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.Bukkit;
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
public class Say implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmdd, String label, String[] args) {
        if (args.length==0) {
            sender.sendMessage(StockMessages.usage("say <message>"));
        } else {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < args.length; i++) {
                builder
                        .append(args[i])
                        .append(" ");
            }

            String msg = builder.toString();
            String says = " "+"§e§l"+sender.getName().toUpperCase()+" §7§osays";
            int saysLength = says.toCharArray().length + 2;
            int borderLength = msg.toCharArray().length + 2;
            StringBuilder borderBuilder = new StringBuilder()
                    .append("§3§l§m");

            for (int i = 0; i < saysLength; i++) {
                borderBuilder.append("-");
            }

            if (borderLength > saysLength) {
                for (int i = saysLength; i < borderLength; i++) {
                    borderBuilder.append("-");
                }
            }

            String border = borderBuilder.toString();

            String[] text = new String[] {
                border,
                    "§e§l"+sender.getName().toUpperCase()+" §7§osays...",
                    " §a§l§o"+msg,
                    border
            };

            for (int i = 0; i < text.length; i++) {
                Bukkit.broadcastMessage(text[i]);
            }
        }
        return true;
    }
}

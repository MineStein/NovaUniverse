package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Message implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Main.getPrefix() + "§7Usage§8: §4/message §c<Player> <Message>");
            return true;
        } else if (args.length == 1) {
            sender.sendMessage(Main.getPrefix() + "§7Usage§8: §4/message <Player> §c<Message>");
            return true;
        } else {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(Main.getPrefix() + "§e§l" + args[0].toUpperCase() + " §4is offline!");
                return true;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                stringBuilder.append(args[i].concat(" "));
            }

            String message = stringBuilder.toString();

            sender.sendMessage(Main.getPrefix() + "§e§lYOU" + "  §b§l§m--§r§b§l>  §e§l" + target.getName().toUpperCase() + "§8: §a" + message);
            target.sendMessage(Main.getPrefix() + "§e§l" + sender.getName().toUpperCase() + "  §b§l§m--§r§b§l>  §e§lYOU§8: §a" + message);
            return true;
        }
    }
}

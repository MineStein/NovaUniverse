package com.minestein.novauniverse.command.fun;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Author: Champ.
 */
public class Launch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!sender.hasPermission("novau.launch")) return true;

        if (args.length==0) {
            sender.sendMessage(Main.getPrefix()+"§7Usage: §4/launch <player>");
            return true;
        } else  if (args.length==1) {
            if (Bukkit.getPlayer(args[0])!=null) {
                Player target = Bukkit.getPlayer(args[0]);
                target.getLocation().getDirection().multiply(5);
                return true;
            } else {
                sender.sendMessage(Main.getPrefix()+"§e§l"+args[0].toUpperCase()+" §4is offline!");
                return true;
            }
        } else {
            sender.sendMessage(Main.getPrefix()+"§4Too many arguments!");
            return true;
        }
    }
}

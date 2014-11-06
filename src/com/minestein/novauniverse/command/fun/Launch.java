package com.minestein.novauniverse.command.fun;

import com.minestein.novauniverse.Main;
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

        if (args.length == 1) {

            sender.sendMessage(Main.getPrefix() + "§4/launch");
            return true;
        } else {
            Player player = (Player) sender;
            player.setVelocity(player.getLocation().getDirection().multiply(5));

        }
        return false;
    }
}

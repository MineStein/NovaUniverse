package com.minestein.novauniverse.command.fun;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Rocket implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("novau.rocket")) return true;

        if (args.length == 0) {

            sender.sendMessage(Main.getPrefix() + "§4/rocket §c<Player>");
            return true;
        } else {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                target.setVelocity(target.getLocation().getDirection().multiply(5));
                target.setVelocity(new Vector(target.getVelocity().getX(), 3.0D, target.getVelocity().getZ()));
                return true;
            } else {
                sender.sendMessage(Main.getPrefix() + "§4That player is offline!");
            }
        }
        return true;
    }
}

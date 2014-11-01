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
public class Maintenance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("novau.maintenance")) return true;

        if (args.length > 0) {
            sender.sendMessage(Main.getPrefix() + "§4Too many arguments!");
            return true;
        } else {
            if (Main.isMaintenance()) {
                Main.setMaintenance(false);
                sender.sendMessage(Main.getPrefix() + "§bThe server has been taken out of maintenance mode!");
                return true;
            } else {
                Main.setMaintenance(true);

                for (Player op : Bukkit.getOnlinePlayers()) {
                    if (op.isOp() || op.hasPermission("novau.maintenance.bypass")) continue;

                    op.kickPlayer("\n§c§l§m-=§4§lSorry, §e§l" + op.getName().toUpperCase() + "§c§l§m §c§l§m=-\n§b§lThis server is currently in maintenance!\n§b§lCheck back later, maintenance usually doesn't last long!");
                }

                sender.sendMessage(Main.getPrefix() + "§bThe server has been put into maintenance mode!");
            }
        }
        return true;
    }
}

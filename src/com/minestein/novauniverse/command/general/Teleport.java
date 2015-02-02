package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot use this command from console");
            return true;
        }

        final Player p = (Player) sender;

        if (!p.hasPermission("novauteleport")) {
            p.sendMessage(Main.getPrefix() + "§4Whoops! Looks like you don't have the proper permissions! (§c§lnovauniverse.teleport§4)");
            return true;
        }

        if (args.length==0) {
            p.sendMessage(Main.getPrefix() + "§7Usage§8: §4/teleport <Player/World/World,X,Y,Z>");
        } else if (args.length==1) {
            if (Bukkit.getPlayer(args[0])==null) {
                if (Bukkit.getWorld(args[0])!=null) {
                    Location loc = Bukkit.getWorld(args[0]).getSpawnLocation();
                    double x = loc.getX();
                    double y = loc.getY();
                    double z = loc.getZ();

                    p.teleport(new Location(Bukkit.getWorld(args[0]), x, y, z));
                    p.sendMessage(Main.getPrefix() + "§bTeleporting...");
                }

                p.sendMessage(Main.getPrefix()+"§4Looks like that player is not online!");
                return true;
            }

            final Player target = Bukkit.getPlayer(args[0]);

            double x = target.getLocation().getX();
            double y = target.getLocation().getY();
            double z = target.getLocation().getZ();

            Location loc = new Location(target.getWorld(), x,y,z);

            int counter = 0;

            while (loc.subtract(0, 1, 0).getBlock().getType()==Material.AIR) {
                counter++;
            }

            if (counter>=100) {
                p.sendMessage(Main.getPrefix()+"§4The location where you want to teleport is not safe.");
                p.sendMessage(Main.getPrefix()+"§4Type §a§l§oYES §4to proceed.");
                p.sendMessage(Main.getPrefix()+"§4Type §c§l§oNO §4to cancel.");
                return true;
            }

            p.teleport(target);
            p.sendMessage(Main.getPrefix()+"§bTeleporting...");
        } else if (args.length==2||args.length==3) {
            p.sendMessage(Main.getPrefix() + "§7Usage§8: §4/teleport <Player/World/World,X,Y,Z>");
        } else if (args.length==4) {
            double x, y, z;

            if (Bukkit.getWorld(args[0])==null) {
                sender.sendMessage(Main.getPrefix()+"§4Not a valid world!");
                return true;
            }

            World world = Bukkit.getWorld(args[0]);

            try {
                x = Double.parseDouble(args[1]);
                y = Double.parseDouble(args[2]);
                z = Double.parseDouble(args[3]);

                Location loc = new Location(world, x,y,z);

                int counter = 0;

                while (loc.subtract(0, 1, 0).getBlock().getType()==Material.AIR) {
                    counter++;
                }

                if (counter>=100) {
                    p.sendMessage(Main.getPrefix()+"§4The location where you want to teleport is not safe.");
                    p.sendMessage(Main.getPrefix()+"§4Type §a§l§oYES §4to proceed.");
                    p.sendMessage(Main.getPrefix()+"§4Type §c§l§oNO §4to cancel.");
                    return true;
                }

                p.teleport(new Location(world, x, y, z));
            } catch (NumberFormatException e) {
                p.sendMessage(Main.getPrefix() + "§4One of the values passed is not an integer or decimal!");
            }
        } else {
            p.sendMessage(Main.getPrefix()+"§4Too many arguments!");
        }
        return true;
    }
}

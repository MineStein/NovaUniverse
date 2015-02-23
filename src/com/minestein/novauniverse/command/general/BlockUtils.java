package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.util.general.StockMessages;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class BlockUtils implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmdd, String label, String[] args) {
        if (args.length==0) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                String[] text = new String[] {
                    "§bSome statistics",
                        "§6§l§m------------------------------",
                        "§7§oWorld: §e§l"+p.getWorld().getName(),
                        "§7§oX, Y, Z: §e§l"+p.getLocation().getX()+"§7§o, §e§l"+p.getLocation().getY()+"§7§o, §e§l"+p.getLocation().getZ(),
                        "§7Pitch/Yaw: §e§l"+p.getLocation().getPitch()+"§7/§e§l"+p.getLocation().getYaw(),
                        "",
                        "§c§l§oNot what you needed? Do §4/blockutils selected §c§l§oto get the selected block's info",
                };

                p.sendMessage(text);
            } else {
                sender.sendMessage(StockMessages.onlyPlayers());
            }
        } else if (args.length==1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                Block b = p.getTargetBlock(null, 5);

                String[] text = new String[] {
                        "§bSome statistics",
                        "§6§l§m------------------------------",
                        "§7§oWorld: §e§l"+b.getWorld().getName(),
                        "§7§oX, Y, Z: §e§l"+b.getLocation().getX()+"§7§o, §e§l"+b.getLocation().getY()+"§7§o, §e§l"+b.getLocation().getZ(),
                        "§7Pitch/Yaw: §e§l"+b.getLocation().getPitch()+"§7/§e§l"+b.getLocation().getYaw(),
                        "",
                        "§c§l§oNot what you needed? Do §4/blockutils selected §c§l§oto get the selected block's info",
                };

                p.sendMessage(text);
            } else {
                sender.sendMessage(StockMessages.onlyPlayers());
            }
        } else {
            sender.sendMessage(StockMessages.tooManyArguments());
        }
        return true;
    }
}

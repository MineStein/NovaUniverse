package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ChatListener implements Listener {

    Set<String> blocked = new HashSet<>();
    HashMap<String, String> repeat = new HashMap<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        final String message = e.getMessage();

        if (message.equalsIgnoreCase("yes")) {
            if (CommandManager.getTeleportUnsafe().containsKey(p.getName())) {
                p.sendMessage(Main.getPrefix()+"§bTeleporting...");
                p.teleport(CommandManager.getTeleportUnsafe().get(p.getName()));
                CommandManager.getTeleportUnsafe().remove(p.getName());

                e.setCancelled(true);
            }
        }

        if (message.equalsIgnoreCase("no")) {
            if (CommandManager.getTeleportUnsafe().containsKey(p.getName())) {
                p.sendMessage(Main.getPrefix()+"§4You have cancelled the teleportation.");
                CommandManager.getTeleportUnsafe().remove(p.getName());

                e.setCancelled(true);
            }
        }

        if (p.isOp()) {
            e.setFormat("§8(§c§lStaff§8) §e§l" + p.getName().toUpperCase() + "§8: §a" + e.getMessage());
        } else {
            e.setFormat("§8(§0§lUser§8) §e§l" + p.getName().toUpperCase() + "§8: §a" + e.getMessage());
        }

        if (repeat.containsKey(p.getName())) {
            if (e.getMessage().equalsIgnoreCase(repeat.get(p.getName()))) {
                e.setCancelled(true);
                p.sendMessage(Main.getPrefix()+"§4You already said that!");
            } else {
                repeat.remove(p.getName());
            }
        } else {
            repeat.put(p.getName(), e.getMessage());
        }
    }
}

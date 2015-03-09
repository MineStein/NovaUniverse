package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import com.minestein.novauniverse.util.sql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try {
            PreparedStatement stmt = MySQL.connection.prepareStatement("SELECT rank FROM users WHERE name='"+p.getName()+"'");
            ResultSet set = stmt.executeQuery();

            if(set.next()) {
                String rank = set.getString("rank");

                if (rank.equalsIgnoreCase("developer")) {
                    e.setFormat("§4§l§oDEVELOPER  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
                } else if (rank.equalsIgnoreCase("planet")) {
                    e.setFormat("§2§l§oPLANET  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
                } else if (rank.equalsIgnoreCase("star")) {
                    e.setFormat("§2§l§oSTAR  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
                } else if (rank.equalsIgnoreCase("nova")) {
                    e.setFormat("§2§l§oNOVA  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
                } else {
                    e.setFormat("§7§l§oDEFAULT  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
                }
            } else {
                e.setFormat("§7§l§oDEFAULT  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
            }
        } catch (SQLException ex) {
            e.setFormat("§7§l§oDEFAULT  §e§l"+p.getName().toUpperCase()+"§7: §a"+message);
            ex.printStackTrace();
        }
    }
}

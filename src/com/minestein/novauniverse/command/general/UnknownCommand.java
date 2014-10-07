package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.io.IOException;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class UnknownCommand implements Listener {

    @EventHandler
    public void onUnknownCommand(PlayerCommandPreprocessEvent e) throws IOException {
        final Player p = e.getPlayer();
        String command = e.getMessage().split(" ")[0];
        if (Bukkit.getHelpMap().getHelpTopic(command) == null) {
            e.setCancelled(true);
            p.sendMessage(Main.getPrefix() + "§4Could not locate command. Do §c/help §4for information");
        }
    }
}

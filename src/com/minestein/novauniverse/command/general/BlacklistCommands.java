package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * ****************************************************************************************
 * Copyright MineStein © 2015
 * <p>
 * Any code contained within this document, and any associated API's with similar branding
 * are the sole property of MineStein. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * <p>
 * Thanks, and have a nice day.
 * ****************************************************************************************
 */
public class BlacklistCommands implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final String msg = e.getMessage();
        final String[] blacklist = new String[] {
            "gamerule"
        };

        if (!CommandManager.getBlacklistAttempts().containsKey(p.getName())) {
            CommandManager.getBlacklistAttempts().put(p.getName(), 2);
            p.sendMessage(Main.getPrefix()+"§4You attempted a blacklisted command! Your attempt has been logged, and you have §c2 §4chances left!");
            return;
        }

        int chances = CommandManager.getBlacklistAttempts().get(p.getName());

        for (String strings : blacklist) {
            if (msg.startsWith("/"+strings)) {
                if (chances==0) {
                    p.sendMessage(Main.getPrefix()+"§4§l§oTsk. Tsk Tsk.");

                    p.kickPlayer("§e§l§oKICKED!\n§4You attempted to use a blacklisted command three times!");
                }

                CommandManager.getBlacklistAttempts().put(p.getName(), chances--);
                if (chances==0) {
                    CommandManager.getBlacklistAttempts().put(p.getName(), 3);
                    p.sendMessage(Main.getPrefix()+"§4§l§oTsk. Tsk Tsk.");
                    p.kickPlayer("§e§l§oKICKED!\n§4You attempted to use a blacklisted command three times!");
                    return;
                }

                p.sendMessage(Main.getPrefix()+"§4You attempted a blacklisted command! Your attempt has been logged, and you have §c"+1+" §4chance"+ (chances==1 ? "" : "s") +" left!");
                return;
            }
        }
    }
}

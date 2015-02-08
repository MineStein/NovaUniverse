package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
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
public class DisabledCommand implements Listener {

    @EventHandler
    public void on(PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final String msg = e.getMessage();
        final String[] cmds = new String[] {
            "blockdata", "achievement",
                "ban", "kick",
                "pardon", "clone",
                "debug", "defaultgamemode",
                "difficulty", "effect",
                "enchant", "entitydata",
                "execute", "fill",
                "gamerule", "give",
                "list", "particle",
                "playsound", "publish",
                "replaceitem", "scoreboard",
                "seed", "setblock",
                "setidletimeout", "setworldspawn",
                "spawnpoint", "spreadplayers",
                "summon", "tellraw",
                "testfor", "testforblock",
                "testforblocks", "title",
                "toggledownfall", "trigger",
                "weather", "whitelist",
                "worldborder", "xp",
                "me"
        };

        for (int i = 0; i < cmds.length; i++) {
            if (msg.toLowerCase().startsWith("/" + cmds[i])) {
                e.setCancelled(true);
                p.sendMessage(Main.getPrefix()+"§4That command is disabled!");
            }
        }
    }
}

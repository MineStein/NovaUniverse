package com.minestein.novauniverse.exception;

import com.minestein.novauniverse.Main;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ServerNotFoundException extends Exception {

    public ServerNotFoundException(Player p) {
        p.closeInventory();
        p.sendMessage(Main.getPrefix() + "§4This server currently is offline/doesn't exist! Check back later!");
    }
}

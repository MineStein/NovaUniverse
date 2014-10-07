package com.minestein.novauniverse.util.general;

import com.minestein.novauniverse.Main;
import org.bukkit.Bukkit;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ChatUtil {

    public static void broadcast(String message) {
        Bukkit.getServer().broadcastMessage(Main.getPrefix() + message);
    }
}

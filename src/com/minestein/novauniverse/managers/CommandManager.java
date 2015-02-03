package com.minestein.novauniverse.managers;

import org.bukkit.Location;

import java.util.HashMap;

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
public class CommandManager {

    private static HashMap<String, Location> teleportUnsafe = new HashMap<>();
    private static HashMap<String, Integer> blacklistAttempts = new HashMap<>();

    public static HashMap<String, Integer> getBlacklistAttempts() {
        return blacklistAttempts;
    }

    public static HashMap<String, Location> getTeleportUnsafe() {
        return teleportUnsafe;
    }
}

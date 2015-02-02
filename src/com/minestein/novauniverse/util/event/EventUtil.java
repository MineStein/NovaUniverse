package com.minestein.novauniverse.util.event;

import org.bukkit.event.Cancellable;

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
public class EventUtil {

    public static void cancel(Cancellable c) {
        c.setCancelled(true);
    }
}

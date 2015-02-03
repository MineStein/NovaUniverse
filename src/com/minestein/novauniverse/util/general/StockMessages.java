package com.minestein.novauniverse.util.general;

import com.minestein.novauniverse.Main;

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
public class StockMessages {

    public static String usage(String cmd) {
        return Main.getPrefix()+"§7Usage: §4/"+cmd;
    }

    public static String noPermission() {
        return Main.getPrefix()+"§4You don't have permission!";
    }

    public static String tooManyArguments() {
        return Main.getPrefix()+"§4Too many arguments!";
    }

    public static String tooFewArguments() {
        return Main.getPrefix()+"§4Too few arguments!";
    }

    public static String offlinePlayer() {
        return Main.getPrefix()+"§4That player is offline!";
    }
}

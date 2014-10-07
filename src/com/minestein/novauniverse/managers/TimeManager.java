package com.minestein.novauniverse.managers;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class TimeManager {

    public static String formatTime(int seconds) {
        int hours = seconds / 3600;
        int remainder = seconds % 3600;
        int mins = remainder / 60;
        int secs = remainder % 60;

        if (hours > 0) {
            return "§e" + hours + "h §8:§e " + mins + "m §8:§e " + secs + "s";
        } else if (mins > 0) {
            return "§e" + mins + "m §8:§e " + secs + "s";
        } else {
            return "§e" + String.valueOf(secs) + "s";
        }
    }
}
package com.minestein.novauniverse.managers;

import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class AchievementManager {

    enum Achievement {
        BROKEN_THE_GAME("broke the game", "Get a message that doesn't look fancy!", 20),
        INTO_THE_VOID("into the void", "Try and leap into the void!", 10);


        String name;
        String description;
        int points;

        public int getPoints() {
            return points;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        Achievement(String name, String description, int points) {
            this.name = name;
            this.description = description;
            this.points = points;
        }
    }

    private AchievementManager() {

    }

    public static String[] generateAchievementMessage() {
        return new String[]{
                "§1§l§m----------------------------------------",
                "§9§l§oAchievement Get!",

        };
    }

    public static void addAchievement(Achievement achievement, Player player) {

    }

    public static void removeAchievement(Achievement achievement, Player player) {

    }

    public static boolean hasAchievement() {


        return true;
    }
}

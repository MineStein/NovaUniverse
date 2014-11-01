package com.minestein.novauniverse.managers;

import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class AchievementManager {

    public enum Achievement {
        WELCOME("Welcome to §5§lNova§6§lUniverse", "Join §5§lNova§6§lUniverse §9for the first time.", 50),
        BYE_BYE("Bye Bye", "Receive a kick.", 20),
        SILENCE("Silence", "Be muted", 20),
        PIT_OF_DESPAIR("Pit of despair", "Find a way into the void!", 20);

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

    public static String[] generateAchievementMessage(Achievement achievement) {
        return new String[]{
                "§1§l§m§k----------------------------------------",
                "§a§l§oACHIEVEMENT GET! §7(§a§l+§r§2" + achievement.getPoints() + "§r§7)",
                "§e§l>> §9" + achievement.getName(),
                "§e§l>> §9" + achievement.getDescription(),
                "§1§l§m§k----------------------------------------"
        };
    }

    public static void addAchievement(Achievement achievement, Player player) {
        // TODO Add the achievement to the player.
    }

    public static void removeAchievement(Achievement achievement, Player player) {
        if (hasAchievement(achievement, player)) {
            // TODO Remove achievement
        } else if (!hasAchievement(achievement, player)) {
            // TODO Send
        }
    }

    public static boolean hasAchievement(Achievement achievement, Player player) {
        // TODO Query database for whether or not the player has the achievement.
        return true;
    }
}

package com.minestein.novauniverse.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class PetManager {

    private PetManager() {

    }

    private static HashMap<String, Boolean> petList = new HashMap<>();

    public static HashMap<String, Boolean> getPetList() {
        return petList;
    }

    public static boolean ownsPet(Player player) {
        // TODO Check if player has a pet via SQL

        return true;
    }
}

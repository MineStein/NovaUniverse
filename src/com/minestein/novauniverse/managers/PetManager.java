package com.minestein.novauniverse.managers;

import org.bukkit.entity.Entity;
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

    private static HashMap<String, Entity> petList = new HashMap<>();

    public static HashMap<String, Entity> getPetList() {
        return petList;
    }

    public static Entity getPet(Player p) {
        return petList.get(p.getName());
    }
}

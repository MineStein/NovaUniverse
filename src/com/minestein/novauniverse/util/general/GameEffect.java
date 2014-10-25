package com.minestein.novauniverse.util.general;

import com.minestein.novauniverse.util.particle.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class GameEffect {

    public static void playFormattedParticles(Location location, ParticleEffect effect) {
        effect.display(1, 1, 1, 1, 1000, location, 2.0);
    }

    public static void playSound(Player player, Sound sound) {
        player.playSound(player.getLocation(), sound, 1F, 1F);
    }
}

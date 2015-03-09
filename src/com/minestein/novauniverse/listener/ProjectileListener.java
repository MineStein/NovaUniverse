package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.managers.CommandManager;
import org.bukkit.Effect;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

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
public class ProjectileListener implements Listener {

    @EventHandler
    public void on(ProjectileHitEvent e) {
        if (e.getEntity().getShooter() instanceof Player&&e.getEntity() instanceof Arrow) {
            if (CommandManager.getBowteleportCache().contains(((Player) e.getEntity().getShooter()).getName())) {
                ((Player) e.getEntity().getShooter()).sendMessage(Main.getPrefix()+"§5§l§oPOOF!");
                ((Player) e.getEntity().getShooter()).teleport(e.getEntity().getLocation());
                ((Player) e.getEntity().getShooter()).playEffect(((Player) e.getEntity().getShooter()).getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
            }
        }
    }
}

package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.command.general.Leash;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        final Player p = e.getPlayer();

        // if (e.getFrom().getBlockX()==e.getTo().getBlockX()|| e.getFrom().getBlockY()==e.getTo().getBlockX()|| e.getFrom().getBlockZ()==e.getTo().getBlockZ()) return;

        if (e.getFrom().getPitch() != e.getTo().getPitch() || e.getFrom().getYaw() != e.getTo().getYaw()) return;

        if (Leash.leashed.contains(p.getName())) {
            e.setTo(e.getFrom());
            p.sendMessage(Main.getPrefix()+"§bYou are leashed!");
            return;
        }

        if (!p.isOp()) return;

        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
    }
}

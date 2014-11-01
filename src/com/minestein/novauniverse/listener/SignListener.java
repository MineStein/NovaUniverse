package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.exception.ServerNotFoundException;
import com.minestein.novauniverse.util.bungee.ServerConnection;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class SignListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) throws ServerNotFoundException {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!(e.getClickedBlock().getState() instanceof Sign)) return;

        Sign sign = (Sign) e.getClickedBlock().getState();

        if (sign.getLine(0).equals("[Connect]")) {
            if (sign.getLine(1).contains("TNT Run")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Freerunners")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Spleef")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Survival Games")) {
                ServerConnection.connect(e.getPlayer(), "sg");
            } else if (sign.getLine(1).contains("Build My Thing")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("UHC")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Grand Theft") && sign.getLine(2).equals("Minecart")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Watch Wolves")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else if (sign.getLine(1).contains("Blocking Dead")) {
                throw new ServerNotFoundException(e.getPlayer());
            } else {
                throw new ServerNotFoundException(e.getPlayer());
            }
        }
    }
}

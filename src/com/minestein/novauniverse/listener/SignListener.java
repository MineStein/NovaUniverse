package com.minestein.novauniverse.listener;

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
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!(e.getClickedBlock().getState() instanceof Sign)) return;

        Sign sign = (Sign) e.getClickedBlock().getState();

        if (sign.getLine(0).equals("[Connect]")) {
            if (sign.getLine(1).contains("TNT Run")) {
                ServerConnection.connect(e.getPlayer(), "tntrun");
            } else if (sign.getLine(1).contains("Freerunners")) {
                ServerConnection.connect(e.getPlayer(), "freerunners");
            } else if (sign.getLine(1).contains("Spleef")) {
                ServerConnection.connect(e.getPlayer(), "spleef");
            } else if (sign.getLine(1).contains("Survival Games")) {
                ServerConnection.connect(e.getPlayer(), "sg");
            } else if (sign.getLine(1).contains("Build My Thing")) {
                ServerConnection.connect(e.getPlayer(), "buildmything");
            } else if (sign.getLine(1).contains("UHC")) {
                ServerConnection.connect(e.getPlayer(), "uhc");
            } else if (sign.getLine(1).contains("Grand Theft") && sign.getLine(2).equals("Minecart")) {
                ServerConnection.connect(e.getPlayer(), "grandtheftminecart");
            } else if (sign.getLine(1).contains("Watch Wolves")) {
                ServerConnection.connect(e.getPlayer(), "watchwolves");
            } else if (sign.getLine(1).contains("Blocking Dead")) {
                ServerConnection.connect(e.getPlayer(), "blockingdead");
            } else return;
        }
    }
}

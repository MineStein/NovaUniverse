package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.menu.main.ServerSelectionMenuInNavigator;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class GameMasterListener implements Listener {

    @EventHandler
    public void onGameMasterInteract(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Villager)) return;

        Villager v = (Villager) e.getRightClicked();
        final Player p = e.getPlayer();

        if (v.getCustomName().equalsIgnoreCase("§1NPC§r§e§l>> §bJoin §a§lSurvival Games")) {
            p.openInventory(ServerSelectionMenuInNavigator.getInventory(ServerSelectionMenuInNavigator.Server.SG, 1, false));
        } else if (v.getCustomName().equalsIgnoreCase("§1NPC§r§e§l>> §bJoin §a§lUltra-Hardcore")) {
            p.openInventory(ServerSelectionMenuInNavigator.getInventory(ServerSelectionMenuInNavigator.Server.UHC, 1, false));
        } else if (v.getCustomName().equalsIgnoreCase("§1NPC§r§e§l>> §bJoin §a§lBuild my Thing")) {
            p.openInventory(ServerSelectionMenuInNavigator.getInventory(ServerSelectionMenuInNavigator.Server.BMT, 1, false));
        } else if (v.getCustomName().equalsIgnoreCase("§1NPC§r§e§l>> §bJoin §a§lBattle Royale")) {
            p.openInventory(ServerSelectionMenuInNavigator.getInventory(ServerSelectionMenuInNavigator.Server.BATTLE_ROYALE, 1, false));
        }
    }
}

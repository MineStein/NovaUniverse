package com.minestein.novauniverse.menu.info;

import com.minestein.novauniverse.menu.main.ArcadeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.GamemodeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.MainGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.Mode;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class GamemodeInfoMenu {

    static Inventory inventory;

    public static Inventory getInventory() {
        inventory = Bukkit.createInventory(null, 18, "§e§l>> §rGamemode Information");

        inventory.setItem(0, ArcadeGamemodeInNavigator.getFreerunners(Mode.INFO));
        inventory.setItem(1, ArcadeGamemodeInNavigator.getSpleef(Mode.INFO));
        inventory.setItem(2, ArcadeGamemodeInNavigator.getTntrun(Mode.INFO));
        inventory.setItem(3, GamemodeGamemodeInNavigator.getBlockingDead(Mode.INFO));
        inventory.setItem(4, GamemodeGamemodeInNavigator.getGrandTheftMinecart(Mode.INFO));
        inventory.setItem(5, GamemodeGamemodeInNavigator.getWatchWolves(Mode.INFO));
        inventory.setItem(6, MainGamemodeInNavigator.getBMT(Mode.INFO));
        inventory.setItem(7, MainGamemodeInNavigator.getSG(Mode.INFO));
        inventory.setItem(8, MainGamemodeInNavigator.getUHC(Mode.INFO));
        for (int i = 9; i < 17; i++) {
            inventory.setItem(i, MainInfoMenu.getComingSoon());
        }
        inventory.setItem(17, MainInfoMenu.getBack());

        return inventory;
    }
}

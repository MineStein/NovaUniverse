package com.minestein.novauniverse.widget;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public abstract class Widget extends ItemStack {

    String displayName;
    ArrayList<String> lore;
    String power;

    public Widget(String power, String displayName, ArrayList<String> lore) {
        this.displayName = displayName;
        this.lore = lore;
        this.power = power;
    }

    public abstract String getDisplayName();

    public abstract ArrayList<String> getLore();

    public abstract String getPower();

    public abstract void setPower(String power);

    public abstract void setLore(ArrayList<String> lore);

    public abstract void setDisplayName(String displayName);
}

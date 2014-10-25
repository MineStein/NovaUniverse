package com.minestein.novauniverse.util.general;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.Serializable;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class NPC implements Serializable {

    public class NPCClickEvent {
        Villager clicked;
        Player clicker;

        public NPCClickEvent(Villager clicked, Player clicker) {
            this.clicked = clicked;
            this.clicker = clicker;
        }

        public Villager getClicked() {
            return clicked;
        }

        public Player getClicker() {
            return clicker;
        }
    }

    public interface NPCClickEventHandler {
        public abstract void onNPCClick(NPCClickEvent event);
    }

    String name;
    World world;
    Location location;
    Listener listener;

    /**
     * @return the name of the NPC
     */
    public String getName() {
        return name;
    }

    /**
     * @return the world the NPC exists in
     */
    public World getWorld() {
        return world;
    }

    /**
     * @return the location of the NPC
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Creates a dupliate of the NPC with the exact same settings and configuration.
     *
     * @param world    the world to create the duplicate NPC at
     * @param location the location to create the duplicate NPC at
     */
    public void duplicate(World world, Location location) {

    }

    /**
     * Creates a duplicate of the NPC with the exact same settings and configuration.
     *
     * @param location the location to create the duplicate NPC at
     */
    public void duplicate(Location location) {
        Villager villager = this.world.spawn(location, Villager.class);

    }

    /**
     * Creates a new NPC
     *
     * @param name     the name the NPC will carry
     * @param world    the world the NPC will be contained in
     * @param location the location the NPC will be glued to
     */
    public NPC(String name, World world, Location location) {
        Villager villager = world.spawn(location, Villager.class);
        villager.setCustomNameVisible(true);
        villager.setCustomName("§1NPC§r" + name);
        villager.setProfession(Villager.Profession.LIBRARIAN);
        villager.setAdult();
        villager.setAgeLock(true);
        villager.setBreed(false);
        villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 6, false));
    }

    /**
     * @param message   the message to be formatted and sent to the recipient
     * @param recipient the player who receives the parsed and formatted message
     */
    public void chat(String message, Player recipient) {
        recipient.sendMessage("§8(§1NPC§8) §e§l" + name.toUpperCase() + " §6--> §e§lYOU§8:");
        recipient.sendMessage("§a" + message);
    }
}

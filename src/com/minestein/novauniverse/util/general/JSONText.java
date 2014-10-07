package com.minestein.novauniverse.util.general;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class JSONText {

    String JSONText;
    CraftPlayer craftPlayer;
    EntityPlayer recipeint;

    public JSONText(String JSONText, CraftPlayer craftPlayer) {
        this.JSONText = JSONText;
        this.craftPlayer = craftPlayer;

        this.recipeint = craftPlayer.getHandle();
    }

    public void playOut() {
        IChatBaseComponent component = ChatSerializer.a(JSONText);
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(component, true);

        recipeint.playerConnection.sendPacket(packetPlayOutChat);
    }

    public String getJSONText() {
        return JSONText;
    }

    public void setJSONText(String JSON) {
        this.JSONText = JSON;
    }

    public CraftPlayer getCraftPlayer() {
        return craftPlayer;
    }

    public void setCraftPlayer(CraftPlayer craftPlayer) {
        this.craftPlayer = craftPlayer;
    }

    public EntityPlayer getRecipeint() {
        return recipeint;
    }

    public void setRecipeint(EntityPlayer recipeint) {
        this.recipeint = recipeint;
    }
}

package com.minestein.novauniverse.util.bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.minestein.novauniverse.Main;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ServerConnection {

    public static void connect(Player playerToSend, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        playerToSend.sendPluginMessage(Main.plugin, "BungeeCord", out.toByteArray());
    }
}

package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.nms.Packets;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) return true;

            final EntityPlayer p = ((CraftPlayer) sender).getHandle();

            for (int i = 0; i < 2; i++) {
                sender.sendMessage("");
            }
            IChatBaseComponent comp = ChatSerializer.a(Packets.JSON.DIVIDE);
            PacketPlayOutChat div = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.HELP);
            PacketPlayOutChat packHelp = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.ROCKET);
            PacketPlayOutChat packRocket = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.SLAP);
            PacketPlayOutChat packSlap = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.CONTROL_PANEL);
            PacketPlayOutChat packControlPanel = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.MAINTENANCE);
            PacketPlayOutChat packMaintenance = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.MESSAGE);
            PacketPlayOutChat packMessage = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.BUG);
            PacketPlayOutChat packBug = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.REPORT);
            PacketPlayOutChat packReport = new PacketPlayOutChat(comp);
            comp = ChatSerializer.a(Packets.JSON.SKIN_REPORT);
            PacketPlayOutChat packSkinReport = new PacketPlayOutChat(comp);

            p.playerConnection.sendPacket(div);
            p.playerConnection.sendPacket(packHelp);
            p.playerConnection.sendPacket(packControlPanel);
            p.playerConnection.sendPacket(packRocket);
            p.playerConnection.sendPacket(packSlap);
            p.playerConnection.sendPacket(packMaintenance);
            p.playerConnection.sendPacket(packMessage);
            p.playerConnection.sendPacket(packBug);
            p.playerConnection.sendPacket(packReport);
            p.playerConnection.sendPacket(packSkinReport);
            p.playerConnection.sendPacket(div);
            for (int i = 0; i < 2; i++) {
                sender.sendMessage("");
            }
            return true;
        } else {
            sender.sendMessage(Main.getPrefix() + "§4Too many arguments!");
            return true;
        }
    }
}

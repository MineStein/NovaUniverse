package com.minestein.novauniverse.command.general;

import com.minestein.novauniverse.util.general.AnvilGUI;
import com.minestein.novauniverse.util.general.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Developer implements CommandExecutor {

    final String PREFIX = "§c§lDeveloper§4>> §f";

    public static class PlayerSearchMenu {

        public static ItemStack getPlayer(Player p) {
            ItemStack i = new ItemStack(Material.SKULL_ITEM,1,(byte) SkullType.PLAYER.ordinal()); {
                SkullMeta m = (SkullMeta) i.getItemMeta();
                m.setOwner(p.getName());
                m.setDisplayName("§e§lPROFILE & INFO");
                if (p.isOp()) {
                    m.setLore(Arrays.asList("§bName§8: §e§l"+p.getName().toUpperCase(), "§bRank§8: §c§l"+"Staff", "§bNovites§8: §e§l100"));
                } else {
                    m.setLore(Arrays.asList("§bName§8: §e§l"+p.getName().toUpperCase(), "§bRank§8: §e§l"+"Default", "§bNovites§8: §e§l100"));
                }
                i.setItemMeta(m);
            }
            return i;
        }

        public static ItemStack getTopper() {
            ItemStack i = new ItemStack(Material.ENDER_PEARL); {
                ItemMeta m = i.getItemMeta();
                m.setDisplayName("§e§l>> §rPlayer Search");
                m.setLore(Arrays.asList(
                        ""
                ));
                i.setItemMeta(m);
            }
            return i;
        }

        public static Inventory getInventory(String name) {
            Inventory i = Bukkit.createInventory(null, 54, "§e§l"+name);
            i.setItem(4, getTopper());
            return i;
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        final Player p = (Player) sender;

        if (!p.getName().equals("MineStein_") && !p.getName().equals("shierspade09123") && !p.getName().equals("tigerchamp34")) {
            p.sendMessage(PREFIX+"§bYou are not permitted to use developer commands!");
            return true;
        }

        if (args.length==0) {
            String[] text = new String[] {
                "§b§lCOMMANDS FOR §a§lDEVELOPER",
                    "§e§l/dev stop",
                    "§e§l/dev disable",
                    "§e§l/dev search",
                    "§7§o<> - required",
                    "§7§o[] - optional"
            };
            p.sendMessage(text);
            return true;
        } else {
            if (args.length==1) {
                String subcmd = args[0];
                if (subcmd.equalsIgnoreCase("stop")) {
                    ChatUtil.broadcast("§4§l§oEmergency server shutdown by §e§l"+p.getName());

                    Bukkit.shutdown();
                } else if (subcmd.equalsIgnoreCase("disable")) {
                    ChatUtil.broadcast("§4§l§oNovaUniverse has been disabled by §e§l"+p.getName());

                    Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("NovaUniverse"));
                } else if (subcmd.equalsIgnoreCase("search")) {
                    AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler() {
                        @Override
                        public void onAnvilClick(AnvilGUI.AnvilClickEvent event) {
                            if (event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT) {
                                event.setWillClose(true);
                                event.setWillDestroy(true);

                                PlayerSearchMenu.getInventory(event.getName());
                            } else {
                                event.setWillClose(false);
                                event.setWillDestroy(false);
                            }
                        }
                    });

                    ItemStack i = new ItemStack(Material.SKULL_ITEM,1,(byte) SkullType.PLAYER.ordinal()); {
                        SkullMeta m = (SkullMeta) i.getItemMeta();
                        m.setOwner(p.getName());
                        m.setDisplayName("§e§lPLAYER SEARCH");
                        m.setLore(Arrays.asList("§5§oEnter a player's", "§5§oname to search for", "§5§otheir information."));
                        i.setItemMeta(m);
                    }

                    gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, i);
                    gui.open();
                }
                return true;
            } else {
                return true;
            }
        }
    }
}

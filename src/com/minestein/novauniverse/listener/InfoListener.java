package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.menu.info.*;
import com.minestein.novauniverse.menu.main.ArcadeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.GamemodeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.MainGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.Mode;
import com.minestein.novauniverse.menu.info.PetInfoMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class InfoListener implements Listener {

    @EventHandler
    public void onInfoOpen(PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (e.getItem() == null) return;

        if (e.getItem().equals(Main.getInfo())) {
            e.getPlayer().openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onStaffInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(StaffInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This staff slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(StaffInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onGameInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(GamemodeInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This game slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(GamemodeInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getFreerunners(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("freerunners", "This game is parkour based.", "Slipping and falling will cause you ", "to be reset to the beginning of the", "current map."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getSpleef(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("spleef", "This game is tactic based.", "Break blocks to stop players", "in their cold tracks in order to", "win the game."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getTntrun(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("tnt run", "This game is parkour-tactic based.", "Run and try not to slip as the", "blocks behind you fall to defeat", "your opponents."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getBlockingDead(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("blocking dead ", "This game is survival based.", "The zombies roam the world of Minecraftia", "and many groups are fighting", "to ensure their safety."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getWatchWolves(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("watch wolves", "This game is tactic based.", "The city is in a panic as new groups of", "hackers clash for their own personal gain!", "Will you emerge victorious?"));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getGrandTheftMinecart(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("grand theft minecart §4§l[§c§l18+§4§l]", "This game is fighting-faction based.", "Form your own gang and take over the", "entire city! §4§l18+ for graphic blood, sexual,", "§4§lthemes expletives, and drug/alcohol usage."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getBMT(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("build my thing", "This game is intelligence-building based.", "Build with your arsenal of blocks and", "and guess other player's buildings in", "order to win this fun game."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getSG(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("survival games", "This game is survival-fighting based.", "Collect 'loot' from chests and", "fight to the death with other players to", "beat the other players."));
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getUHC(Mode.INFO).getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(MainInfoMenu.makeInfo("ultra-hardcore", "This game is survival based.", "Collect resources and fight other players", "and teams. This is in", "order to win this epic gamemode."));
        }
    }

    @EventHandler
    public void onCommandInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(CommandInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This command slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(CommandInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onMapInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(MapInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This map slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(MapInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onDonateInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(DonateInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This donation information slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(DonateInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onPetInfo(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(PetInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This pet slot has not yet been filled. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(PetInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getBack().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MainInfoMenu.getInventory());
        }
    }

    @EventHandler
    public void onInfoInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getInventory().getName().equals(MainInfoMenu.getInventory().getName())) return;

        e.setCancelled(true);

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getComingSoon().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4This content has not yet arrived. Please select a different option.");

            Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    p.openInventory(MainInfoMenu.getInventory());
                }
            }, 30);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getCommands().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(CommandInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getGames().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(GamemodeInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getStaff().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(StaffInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getMaps().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(MapInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getDonate().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(DonateInfoMenu.getInventory());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(MainInfoMenu.getPets().getItemMeta().getDisplayName())) {
            p.closeInventory();
            p.openInventory(PetInfoMenu.getInventory());
        }
    }
}

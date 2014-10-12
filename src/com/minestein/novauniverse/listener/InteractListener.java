package com.minestein.novauniverse.listener;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.exception.ServerNotFoundException;
import com.minestein.novauniverse.menu.main.ArcadeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.GamemodeGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.MainGamemodeInNavigator;
import com.minestein.novauniverse.menu.main.Mode;
import com.minestein.novauniverse.menu.other.ParticleEffectMenu;
import com.minestein.novauniverse.menu.other.Wardrobe;
import com.minestein.novauniverse.menu.pets.MainPetsMenu;
import com.minestein.novauniverse.menu.shops.ingame.GizmoShop;
import com.minestein.novauniverse.util.bungee.ServerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class InteractListener implements Listener {

    ArrayList<String> jumpCooldown = new ArrayList<String>();
    ArrayList<String> speedCooldown = new ArrayList<String>();
    ArrayList<String> playerToggleCooldown = new ArrayList<String>();
    ArrayList<String> stackerCooldown = new ArrayList<String>();

    @EventHandler
    public void onWardrobe(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(Wardrobe.getInventory().getName())) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getHelm(Wardrobe.Type.IRON).getItemMeta().getDisplayName())) {
                p.getInventory().setHelmet(Wardrobe.getHelm(Wardrobe.Type.IRON));
                p.sendMessage(Main.getPrefix() + "§bYou equipped an §7§liron §bhelmet!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getHelm(Wardrobe.Type.GOLD).getItemMeta().getDisplayName())) {
                p.getInventory().setHelmet(Wardrobe.getHelm(Wardrobe.Type.GOLD));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §6§lgolden §bhelmet!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getHelm(Wardrobe.Type.DIAMOND).getItemMeta().getDisplayName())) {
                p.getInventory().setHelmet(Wardrobe.getHelm(Wardrobe.Type.DIAMOND));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §b§ldiamond §bhelmet!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getChest(Wardrobe.Type.IRON).getItemMeta().getDisplayName())) {
                p.getInventory().setChestplate(Wardrobe.getChest(Wardrobe.Type.IRON));
                p.sendMessage(Main.getPrefix() + "§bYou equipped an §7§liron §bchestplate!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getChest(Wardrobe.Type.GOLD).getItemMeta().getDisplayName())) {
                p.getInventory().setChestplate(Wardrobe.getChest(Wardrobe.Type.GOLD));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §6§lgolden §bchestplate!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getChest(Wardrobe.Type.DIAMOND).getItemMeta().getDisplayName())) {
                p.getInventory().setChestplate(Wardrobe.getChest(Wardrobe.Type.DIAMOND));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §b§ldiamond §bchestplate!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getLegs(Wardrobe.Type.IRON).getItemMeta().getDisplayName())) {
                p.getInventory().setLeggings(Wardrobe.getLegs(Wardrobe.Type.IRON));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a pair of §7§liron §bleggings!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getLegs(Wardrobe.Type.GOLD).getItemMeta().getDisplayName())) {
                p.getInventory().setLeggings(Wardrobe.getLegs(Wardrobe.Type.GOLD));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a pair of §6§lgolden §bleggings!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getLegs(Wardrobe.Type.DIAMOND).getItemMeta().getDisplayName())) {
                p.getInventory().setLeggings(Wardrobe.getLegs(Wardrobe.Type.DIAMOND));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a pair of §b§ldiamond §bleggings!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getBoots(Wardrobe.Type.IRON).getItemMeta().getDisplayName())) {
                p.getInventory().setBoots(Wardrobe.getBoots(Wardrobe.Type.IRON));
                p.sendMessage(Main.getPrefix() + "§bYou equipped an §7§liron §bpair of boots!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getBoots(Wardrobe.Type.GOLD).getItemMeta().getDisplayName())) {
                p.getInventory().setBoots(Wardrobe.getBoots(Wardrobe.Type.GOLD));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §6§lgolden §bpair of boots!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getBoots(Wardrobe.Type.DIAMOND).getItemMeta().getDisplayName())) {
                p.getInventory().setBoots(Wardrobe.getBoots(Wardrobe.Type.DIAMOND));
                p.sendMessage(Main.getPrefix() + "§bYou equipped a §b§ldiamond §bpair of boots!");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Wardrobe.getRemove().getItemMeta().getDisplayName())) {
                p.getInventory().setArmorContents(null);
                p.closeInventory();
                p.sendMessage(Main.getPrefix() + "§bYou cleared all of your armor!");
            } else return;
        }
    }

    @EventHandler
    public void onOpenInventory(InventoryOpenEvent e) {
        if (e.getInventory().getType() == InventoryType.MERCHANT) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (e.getItem() == null) return;

        if (e.getItem().equals(Main.getNvgtr())) {
            Inventory toOpen = MainGamemodeInNavigator.getInventory(e.getPlayer());
            e.getPlayer().openInventory(toOpen);
        }

        if (e.getItem().equals(Main.getParticles())) {
            Inventory toOpen = ParticleEffectMenu.getInventory();
            e.getPlayer().openInventory(toOpen);
        }

        if (e.getItem().equals(Main.getDnte())) {
            e.getPlayer().sendMessage(Main.getPrefix() + "§bWelcome to the donation and info area!");
            e.getPlayer().sendMessage(Main.getPrefix() + " §bFeel free to interact with the NPC's!");
            e.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 919.50000, 14, 332.50000));
        }

        if (e.getItem().equals(Main.getWardrobe())) {
            e.getPlayer().openInventory(Wardrobe.getInventory());
        } else if (e.getItem().equals(Main.getPets())) {
            e.getPlayer().openInventory(MainPetsMenu.getInventory());
        } else {
            return;
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) throws ServerNotFoundException {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player p = (Player) event.getWhoClicked();

        if (event.getInventory().getName().equals(GizmoShop.getInventory().getName())) {
            if (event.getCurrentItem() == null) return;

            p.closeInventory();
            p.sendMessage(Main.getPrefix() + "§4Sorry! Gizmos aren't ready yet! Check back later!");
        } else if (event.getInventory().getName().equals(MainGamemodeInNavigator.getInventory(p).getName())) {
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getArcadeRepresentative().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(ArcadeGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getStandaloneGamemodes().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(GamemodeGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getSG(Mode.PLAY).getItemMeta().getDisplayName())) {
                ServerConnection.connect(p, "sg");
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getBMT(Mode.PLAY).getItemMeta().getDisplayName())) {
                ServerConnection.connect(p, "buildmything");
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MainGamemodeInNavigator.getUHC(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            }
        } else if (event.getInventory().getName().equals(ArcadeGamemodeInNavigator.getInventory(p).getName())) {
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getMainGamesRepresentative().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(MainGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getStandaloneGamemodes().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(GamemodeGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getTntrun(Mode.PLAY).getItemMeta().getDisplayName())) {
                ServerConnection.connect(p, "tntrun");
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getFreerunners(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ArcadeGamemodeInNavigator.getSpleef(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            }
        } else if (event.getInventory().getName().equals(GamemodeGamemodeInNavigator.getInventory(p).getName())) {
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getArcadeRepresentative().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(ArcadeGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getMainRepresentative().getItemMeta().getDisplayName())) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().openInventory(MainGamemodeInNavigator.getInventory(p));
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getBlockingDead(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getGrandTheftMinecart(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(GamemodeGamemodeInNavigator.getWatchWolves(Mode.PLAY).getItemMeta().getDisplayName())) {
                throw new ServerNotFoundException(p);
            }
        }
    }
}

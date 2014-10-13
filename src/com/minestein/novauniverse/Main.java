package com.minestein.novauniverse;

import com.minestein.novauniverse.command.fun.Rocket;
import com.minestein.novauniverse.command.fun.Slap;
import com.minestein.novauniverse.command.general.*;
import com.minestein.novauniverse.command.reporting.Bug;
import com.minestein.novauniverse.command.reporting.Report;
import com.minestein.novauniverse.command.reporting.SkinReport;
import com.minestein.novauniverse.listener.*;
import com.minestein.novauniverse.managers.PartyManager;
import com.minestein.novauniverse.util.general.NPC;
import me.confuser.barapi.BarAPI;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Main extends JavaPlugin {

    /*
     * Allowing turning off blood, certain dialogue, etc. in certain gamemodes
     */

    private static Scoreboard scoreboard;
    private static Objective objective;
    private static Score online;
    private static Score partyTimeLeft;
    private static final String PREFIX = "§8[§5NOVA§6U§8] §f";
    private static boolean maintenance;
    private static ItemStack nvgtr;
    private static ItemStack dnte;
    private static ItemStack infoBook;
    private static ItemStack particles;
    private static ItemStack wardrobe;
    private static ItemStack pets;
    private static ItemStack info;
    private static ItemStack toggles;
    private String currentMessage;
    private static final Location SPAWNPOINT = new Location(Bukkit.getWorld("world"), 881, 14, 332);
    public static Main plugin;
    public static Random random;
    private static int partySeconds;

    public static int getPartySeconds() {
        return partySeconds;
    }

    public static void setPartySeconds(int partySeconds) {
        Main.partySeconds = partySeconds;
    }

    public static Score getPartyTimeLeft() {
        return partyTimeLeft;
    }

    public static ItemStack getWardrobe() {
        return wardrobe;
    }

    public static ItemStack getPets() {
        return pets;
    }

    public static Random getRandom() {
        return random;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    public static Location getSpawnpoint() {
        return SPAWNPOINT;
    }

    public static ItemStack getDnte() {
        return dnte;
    }

    public static void setDnte(ItemStack dnte) {
        Main.dnte = dnte;
    }

    public static Scoreboard getScoreboard() {
        return scoreboard;
    }

    public static void setScoreboard(Scoreboard scoreboard) {
        Main.scoreboard = scoreboard;
    }

    public static Objective getObjective() {
        return objective;
    }

    public static void setObjective(Objective objective) {
        Main.objective = objective;
    }

    public static Score getOnline() {
        return online;
    }

    public static void setOnline(Score online) {
        Main.online = online;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static boolean isMaintenance() {
        return maintenance;
    }

    public static void setMaintenance(boolean maintenance) {
        Main.maintenance = maintenance;
    }

    public static ItemStack getNvgtr() {
        return nvgtr;
    }

    public static void setNvgtr(ItemStack nvgtr) {
        Main.nvgtr = nvgtr;
    }

    public static ItemStack getInfoBook() {
        return infoBook;
    }

    public static ItemStack getParticles() {
        return particles;
    }

    public static ItemStack getInfo() {
        return info;
    }

    public static ItemStack getToggles() {
        return toggles;
    }

    @Override
    public void onEnable() {
        plugin = this;

        scoreboard = getServer().getScoreboardManager().getNewScoreboard();
        objective = scoreboard.registerNewObjective("main", "dummy");
        objective.setDisplayName("§5§lNOVA§6§lUNIVERSE");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        online = objective.getScore("§e§lONLINE");
        partyTimeLeft = objective.getScore("§e§lPARTY TIME");

        random = new Random();

        maintenance = true;

        toggles = new ItemStack(Material.WATCH);
        {
            ItemMeta m = toggles.getItemMeta();
            m.setDisplayName("§c§lTOGGLES §7§o(Right-Click)");
            ArrayList<String> l = new ArrayList<>();
            l.add("§5§oToggle certain things!");
            m.setLore(l);
            toggles.setItemMeta(m);
        }

        info = new ItemStack(Material.EMERALD);
        {
            ItemMeta m = info.getItemMeta();
            m.setDisplayName("§c§lINFORMATION §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oGet info on the server!");
            m.setLore(lore);
            info.setItemMeta(m);
        }

        nvgtr = new ItemStack(Material.COMPASS);
        {
            ItemMeta m = nvgtr.getItemMeta();
            m.setDisplayName("§c§lNAVIGATOR §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oGo through our 9 gamemodes!");
            m.setLore(lore);
            nvgtr.setItemMeta(m);
        }

        pets = new ItemStack(Material.MONSTER_EGG);
        {
            ItemMeta m = pets.getItemMeta();
            m.setDisplayName("§c§lPETS §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oSelect a pet to follow you!");
            m.setLore(lore);
            pets.setItemMeta(m);
        }

        dnte = new ItemStack(Material.DIAMOND);
        {
            ItemMeta m = dnte.getItemMeta();
            m.setDisplayName("§c§lDONATE §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oGet information on donations!");
            m.setLore(lore);
            dnte.setItemMeta(m);
        }

        particles = new ItemStack(Material.EYE_OF_ENDER);
        {
            ItemMeta m = particles.getItemMeta();
            m.setDisplayName("§c§lPARTICLES §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oSelect your particles!");
            m.setLore(lore);
            particles.setItemMeta(m);
        }

        infoBook = new ItemStack(Material.WRITTEN_BOOK);
        {
            BookMeta m = (BookMeta) infoBook.getItemMeta();
            m.addPage("1", "2");
            m.setTitle("§c§lINFORMATION §7§o(Right-Click)");
            m.setDisplayName("§c§lINFORMATION §7§o(Right-Click)");
            m.setAuthor("MineStein");
            m.setPage(1, "Welcome, players! " +
                    "This book will entail certain helpful information from yours truly (MineStein_)!\n\n" +
                    "§lQ: §rDo you have a website?\n§lA: §rYes! Check it out at http://www.novau.enjin.com\n\n" +
                    "§r§lQ: §rDo you have donations set up?\n§lA: §rNot quite, but");
            m.setPage(2, "we are currently working on it!\n\n" +
                    "§lQ: §rWill there be an anti-cheat in place?§\n§lA: §rYes, MineStein_ is writing one!");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oRead about the server!");
            m.setLore(lore);
            infoBook.setItemMeta(m);
        }

        wardrobe = new ItemStack(Material.CHEST);
        {
            ItemMeta m = wardrobe.getItemMeta();
            m.setDisplayName("§c§lWARDROBE §7§o(Right-Click)");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§5§oChange your clothing (look sexy)");
            m.setLore(lore);
            wardrobe.setItemMeta(m);
        }

        getCommand("maintenance").setExecutor(new Maintenance());
        getCommand("rocket").setExecutor(new Rocket());
        getCommand("slap").setExecutor(new Slap());
        getCommand("bug").setExecutor(new Bug());
        getCommand("help").setExecutor(new Help());
        getCommand("message").setExecutor(new Message());
        getCommand("report").setExecutor(new Report());
        getCommand("skinreport").setExecutor(new SkinReport());
        getCommand("controlpanel").setExecutor(new ControlPanel());
        getCommand("tp").setExecutor(new Banned());

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new VitalListener(), this);
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new ShopListener(), this);
        pm.registerEvents(new InfoListener(), this);
        pm.registerEvents(new PetListener(), this);
        pm.registerEvents(new UnknownCommand(), this);
        pm.registerEvents(new ToggleListener(), this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(scoreboard);
        }

        for (World worlds : Bukkit.getWorlds()) {
            for (Chunk chunks : worlds.getLoadedChunks()) {
                for (Entity entities : chunks.getEntities()) {
                    if (entities instanceof Villager || entities instanceof Wolf || entities instanceof Sheep) {
                        entities.remove();
                    }
                }
            }
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (World worlds : Bukkit.getWorlds()) {
                    for (Chunk chunks : worlds.getLoadedChunks()) {
                        for (Entity entities : chunks.getEntities()) {
                            if (entities instanceof Wolf) {
                                Wolf entity = (Wolf) entities;
                                if (entity.getCustomName() == null) return;
                                if (entity.getCustomName().contains("WOLF")) {
                                    return;
                                }
                            } else if (entities instanceof Sheep) {
                                Sheep entity = (Sheep) entities;
                                if (entity.getCustomName() == null) return;
                                if (entity.getCustomName().contains("SHEEP")) {
                                    return;
                                }
                            }

                            if (!(entities instanceof Player) && !(entities instanceof Item) && !(entities instanceof Villager)) {
                                entities.remove();
                            }
                        }
                    }
                }
            }
        }, 0, 20);

        String[] validColorCodes = new String[]{
                "4", "c", "e", "a", "b", "9", "d"
        };

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                String[] messages = new String[]{
                        "Developed by §b§o@MineStien",
                        "This server is in §b§oalpha",
                        "The website is §b§onovauniverse.net",
                        "Use your §b§owardrobe §eto change armor",
                        "Use your §b§onavigator §eto enter a game",
                        "Use your §b§odonation item §eto donate",
                        "Use your §b§ojump toggle §eto jump high",
                        "Use your §b§ospeed toggle §eto run fast",
                        "Use your §b§oplayer toggle §efor invisibility",
                        "Do §b§o/help §eto receive information",
                        "Join one of our §b§onine §egamemodes",
                        "We have pets! Use your §b§opet menu"
                };

                currentMessage = messages[random.nextInt(messages.length)];
            }
        }, 0, 60);

        // lambda
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> BarAPI.setMessage("§" + validColorCodes[random.nextInt(validColorCodes.length)] + "§lNOVAU  §e" + currentMessage), 5, 10);

        NPC gs1 = new NPC("§e§l>> §a§lGIZMO SHOP", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 869.500000, 14, 360.50000));
        NPC gs2 = new NPC("§e§l>> §a§lGIZMO SHOP", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 893.500000, 14, 360.50000));
        NPC gs3 = new NPC("§e§l>> §a§lGIZMO SHOP", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 893.500000, 14, 304.50000));
        NPC gs4 = new NPC("§e§l>> §a§lGIZMO SHOP", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 869.50000, 14, 304.50000));
        NPC pi = new NPC("§e§l>> §b§lPLANET RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 328.50000));
        NPC si = new NPC("§e§l>> §b§lSTAR RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 332.50000));
        NPC ni = new NPC("§e§l>> §b§lNOVA RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 336.50000));

        setPartySeconds(3001);
        partyTimeLeft.setScore(getPartySeconds());
        online.setScore(Bukkit.getOnlinePlayers().length);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new PartyManager(), 10, 20);
    }

     /*
     @Override
     public void onDisable() {
        for (World worlds : Bukkit.getWorlds()) {
            for (Chunk chunks : worlds.getLoadedChunks()) {
                for (Entity entities : chunks.getEntities()) {
                    if (entities instanceof Villager) {
                        entities.remove();
                    }
                }
            }
        }
    }
    */
}
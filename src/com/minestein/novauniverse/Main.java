package com.minestein.novauniverse;

import com.gmail.filoghost.holograms.api.Hologram;
import com.gmail.filoghost.holograms.api.HolographicDisplaysAPI;
import com.gmail.filoghost.holograms.api.TouchHandler;
import com.minestein.novauniverse.command.fun.Launch;
import com.minestein.novauniverse.command.fun.Rocket;
import com.minestein.novauniverse.command.fun.Slap;
import com.minestein.novauniverse.command.general.*;
import com.minestein.novauniverse.command.reporting.Bug;
import com.minestein.novauniverse.command.reporting.Report;
import com.minestein.novauniverse.command.reporting.SkinReport;
import com.minestein.novauniverse.listener.*;
import com.minestein.novauniverse.managers.MusicManager;
import com.minestein.novauniverse.managers.PartyManager;
import com.minestein.novauniverse.menu.main.ServerSelectionMenuInNavigator;
import com.minestein.novauniverse.util.general.NPC;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
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
import java.util.Arrays;
import java.util.Random;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Main extends JavaPlugin {

    /*
     * TODO Provide toggles for turning off blood, certain dialogue, etc. in most gamemodes that involve such themes.
     *
     */

    private static Scoreboard scoreboard;
    private static Objective objective;
    private static Score online;
    private static Score partyTimeLeft;
    private int scoreboardTimer;
    private static final String PREFIX = "§8[§5NOVA§6U§8] §f";
    private static boolean maintenance;
    boolean alreadyPlayingSong;
    private static ItemStack nvgtr;
    private static ItemStack dnte;
    private static ItemStack infoBook;
    private static ItemStack particles;
    private static ItemStack wardrobe;
    private static ItemStack pets;
    private static ItemStack info;
    private static ItemStack toggles;
    private static ItemStack musicSelector;
    private static SongPlayer player;
    private String currentMessage;
    private static final Location SPAWNPOINT = new Location(Bukkit.getWorld("hub"), 56.500, 49.500, 630.500);
    public static Main plugin;
    public static Random random;
    private static int partySeconds;
    public static World lobby = Bukkit.getWorld("hub");

    public static int getPartySeconds() {
        return partySeconds;
    }

    public static void setPartySeconds(int partySeconds) {
        Main.partySeconds = partySeconds;
    }

    public static Score getPartyTimeLeft() {
        return partyTimeLeft;
    }

    public static SongPlayer getPlayer() {
        return player;
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

    public static ItemStack getMusicSelector() {
        return musicSelector;
    }

    private void changeScoreboard() {
        if (scoreboardTimer == 1) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§6§lN§5§lovaUniverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 2) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§e§lN§6§lo§5§lvaUniverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 3) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lN§e§lo§6§lv§5§laUniverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 4) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNo§e§l§6§lv§5§laUniverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 5) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNov§e§la§6§lU§5§lniverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 6) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNova§e§lU§6§ln§5§liverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 7) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaU§e§ln§6§li§5§lverse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 8) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUn§e§li§6§lv§5§lerse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 9) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUni§e§lv§6§le§5§lrse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 10) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUniv§e§le§6§lr§5§lse");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 11) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUnive§e§lr§6§ls§5§le");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 12) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUniver§e§ls§6§le");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer++;
        } else if (scoreboardTimer == 13) {
            Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective newObjective = newScoreboard.registerNewObjective("newScoreboard", "dummy");
            newObjective.setDisplayName("§5§lNovaUnivers§e§le");
            newObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score newOnline = newObjective.getScore("§e§lONLINE");
            newOnline.setScore(Bukkit.getOnlinePlayers().length);
            Score newTimeLeft = newObjective.getScore("§e§lPARTY TIME");
            newTimeLeft.setScore(Main.getPartySeconds());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(newScoreboard);
            }

            scoreboardTimer = 1;
        }

        // Red - 1
        // Orange - 14
        // Yellow - 11
        // Green - 2
        // Light Blue 12
        // Dark Blue = 4
        // Purple - 5
    }

    @Override
    public void onEnable() {
        plugin = this;

        scoreboardTimer = 1;

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
            lore.add("§5§oChange your clothing!");
            m.setLore(lore);
            wardrobe.setItemMeta(m);
        }

        musicSelector = new ItemStack(Material.JUKEBOX);
        {
            ItemMeta m = musicSelector.getItemMeta();
            m.setDisplayName("§c§lMUSIC §7§o(Right-Click)");
            m.setLore(Arrays.asList("§5§oChange the current music!"));
            musicSelector.setItemMeta(m);
        }

        getCommand("maintenance").setExecutor(new Maintenance());
        getCommand("rocket").setExecutor(new Rocket());
        getCommand("slap").setExecutor(new Slap());
        getCommand("launch").setExecutor(new Launch());
        getCommand("bug").setExecutor(new Bug());
        getCommand("help").setExecutor(new Help());
        getCommand("message").setExecutor(new Message());
        getCommand("report").setExecutor(new Report());
        getCommand("skinreport").setExecutor(new SkinReport());
        getCommand("controlpanel").setExecutor(new ControlPanel());
        getCommand("developer").setExecutor(new Developer());
        getCommand("tp").setExecutor(new Teleport());

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new VitalListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new ShopListener(), this);
        pm.registerEvents(new InfoListener(), this);
        pm.registerEvents(new PetListener(), this);
        pm.registerEvents(new UnknownCommand(), this);
        pm.registerEvents(new ToggleListener(), this);
        pm.registerEvents(new MusicManager(), this);
        pm.registerEvents(new DoubleJump(), this);
        pm.registerEvents(new ServerSelectionMenuInNavigator(), this);
        pm.registerEvents(new GameMasterListener(), this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getLogger().severe("Testing");

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(scoreboard);
        }

        for (World worlds : Bukkit.getWorlds()) {
            for (Chunk chunks : worlds.getLoadedChunks()) {
                for (Entity entities : chunks.getEntities()) {
                    if (entities instanceof Villager || entities instanceof Wolf || entities instanceof Sheep || entities instanceof Pig || entities instanceof Cow) {
                        entities.remove();
                    }
                }
            }
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                changeScoreboard();
            }
        }, 10, 1);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (World worlds : Bukkit.getWorlds()) {
                    worlds.setTime(1000);

                    if (worlds.isThundering()) {
                        worlds.setThunderDuration(0);
                        worlds.setThundering(false);
                    }

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

                            if (!(entities instanceof Player) && !(entities instanceof Item) && !(entities instanceof Villager) && !(entities instanceof WitherSkull) && !(entities instanceof Pig) && !(entities instanceof Wolf) && !(entities instanceof Cow) && !(entities instanceof Sheep)) {
                                entities.remove();
                            }
                        }
                    }
                }
            }
        }, 0, 20);

        final String[] validColorCodes = new String[]{
                "4", "c", "e", "a", "b", "9", "d"
        };

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                String[] messages = new String[] {
                    "§fwww.novauniverse.net",
                        "§fSQL-driven!",
                        "Much Amaze!",
                        "So fancy!",
                        "Mas o menos my amigos!",
                        "Man or machine?",
                        "iStone Air",
                        "iStone Mini",
                        "Doors 10, never Doors 8",
                        "A dip pulses underneath a broad brick.",
                        "In a wreck chalks a typewriter.",
                        "Whatever broad differential modifies his falling assembly.",
                        "No MOTD!",
                        "Am I fancy enough?",
                        "Plz rate and giv a like, big fan",
                        "And so he sat on the wall.",
                        "Dracula!",
                        "50% off (you wish)!",
                        "A poison fears opposite the becoming festival.",
                        "Across a ratio shines her overcome triangle.",
                        "These messages are so useful",
                        "☆_☆",
                        "0_0",
                        "O_O",
                        "O_o",
                        "o_O",
                        "0_O",
                        "§a§l:) §for §c§l:(§f?",
                };

                currentMessage = messages[random.nextInt(messages.length)];
            }
        }, 0, 60);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                BarAPI.setMessage("§" + validColorCodes[random.nextInt(validColorCodes.length)] + "§lNOVAU §5§o§l| §e" + currentMessage);
            }
        }, 5, 10);

        NPC sg = new NPC("§e§l>> §bJoin §a§lSurvival Games", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 881.500, 14.500, 390.500));
        NPC uhc = new NPC("§e§l>> §bJoin §a§lUltra-Hardcore", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 885.500, 14.500, 390.500));
        NPC bmt = new NPC("§e§l>> §bJoin §a§lBuild my Thing", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 877.500, 14.500, 390.500));
        NPC lines = new NPC("§e§l>> §bJoin §a§lLines Survival", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 885.500, 14.500, 386.500));
        NPC br = new NPC("§e§l>> §bJoin §a§lBattle Royale", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 877.500, 14.500, 386.500));
        NPC quake = new NPC("§e§l>> §bJoin §a§lQuake", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 877.500, 14.500, 382.500));

        NPC gs1 = new NPC("§e§l>> §a§lGIZMO SHOP", lobby, new Location(lobby, 65.500, 49, 630.500));
        NPC gs2 = new NPC("§e§l>> §a§lGIZMO SHOP", lobby, new Location(lobby, 56.500, 49, 621.500));
        NPC gs3 = new NPC("§e§l>> §a§lGIZMO SHOP", lobby, new Location(lobby, 47.500, 49, 630.500));
        NPC gs4 = new NPC("§e§l>> §a§lGIZMO SHOP", lobby, new Location(lobby, 56.500, 49, 639.500));

        NPC pi = new NPC("§e§l>> §b§lPLANET RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 328.50000));
        NPC si = new NPC("§e§l>> §b§lSTAR RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 332.50000));
        NPC ni = new NPC("§e§l>> §b§lNOVA RANK", Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 926.50000, 14, 336.50000));

        Hologram holo = HolographicDisplaysAPI.createHologram(this, new Location(lobby, 56.500, 52, 634.500), "§dWelcome to §5§lNova§6§lUniverse", "§6§l§m-------------------------", "§b§l§oBe sure to have fun!", "§b§l§oClick me for assistance!", "§6§l§m-------------------------");
        holo.setTouchHandler(new TouchHandler() {
            @Override
            public void onTouch(Hologram hologram, Player player) {
                player.performCommand("help");
            }
        });

        setPartySeconds(3001);
        partyTimeLeft.setScore(getPartySeconds());
        online.setScore(Bukkit.getOnlinePlayers().length);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new PartyManager(), 10, 20);
    }

    @Override
    public void onDisable() {
        for (Hologram holograms : HolographicDisplaysAPI.getHolograms(this)) {
            holograms.clearLines();
            holograms.delete();
        }
    }

    /* Gamemode Plans
     * SG:
     *  MaxPlayers: 24.
     *  Desc: Fight other players and gather supplies from loot chests.
     *  Win: Last standing.
     *  Theme: PvP.
     * UHC:
     *  MaxPlayers: 12.
     *  Desc: Fight other teams and gather supplies from a randomly generated world.
     *  Win: Last team standing.
     *  Theme: Team-based PvP
     * BuildMyThing:
     *  MaxPlayers: 6.
     *  Desc: Build creations based on a given word to earn points.
     *  Win: Get the most points.
     *  Theme: Point-based building.
     *
     */

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
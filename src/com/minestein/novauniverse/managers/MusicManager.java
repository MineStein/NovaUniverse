package com.minestein.novauniverse.managers;

import com.minestein.novauniverse.Main;
import com.minestein.novauniverse.util.general.ChatUtil;
import com.xxmicloxx.NoteBlockAPI.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class MusicManager implements Listener {

    String[] songs = new String[] {
        "Call me Maybe",
        "Gangnam Style"
    };
    Song currentSong;
    SongPlayer player = Main.getPlayer();

    @EventHandler
    public void onMusicEnd(SongEndEvent e) {
        String songTitle = songs[Main.getRandom().nextInt(songs.length)];
        currentSong = NBSDecoder.parse(new File(Main.getPlugin().getDataFolder(), songTitle));

        SongPlayer newPlayer = new RadioSongPlayer(currentSong);

        for (Player players : Bukkit.getOnlinePlayers()) {
            newPlayer.addPlayer(players);
        }

        ChatUtil.broadcast("§bNow playing song §e§l"+songTitle.toUpperCase());
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }

    public Song getCurrentSong() {
        return currentSong;
    }
}

package ch.fhnw.cs.swc.jukebox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicJukeBox implements JukeBox {
    private Map<String, Song> playlist = new HashMap<>();
    private Song actualSong;

    public Song getCurrentSong() {
        return actualSong;
    }

    public void addSong(Song song) {
        playlist.put(song.getTitle(), song);
    }

    public void playSong(String title) throws JukeBoxException {
        if (playlist.containsKey(title)) {
            actualSong = playlist.get(title);
            actualSong.start();
        } else {
            throw new JukeBoxException("No song found with title '" + title + "'");
        }
    }

    public List<Song> getPlayList() {
        return List.copyOf(playlist.values());
    }

}



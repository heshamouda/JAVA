package ch.fhnw.cs.swc.jukebox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JukeBoxStubTest {

    protected static String songTitle = "Icebreaker";
    protected JukeBox jukeBox;
    protected Song song;

    @BeforeEach
    public void setUp() {
        song = new SongStub(songTitle);
        jukeBox = new MusicJukeBox();
    }

    @Test
    public void testPlayOfNonExistingSong() {
        assertThrows(JukeBoxException.class, () -> jukeBox.playSong("not existing"));
    }

    @Test
    public void testGetPlayList() {
        jukeBox.addSong(song);
        List<Song> list = jukeBox.getPlayList();
        
        assertEquals(1, list.size());
        assertTrue(list.contains(song));
        
        // add a second song and test for correct play list
        Song song2 = new SongStub("Hello Kitty");
        jukeBox.addSong(song2);
        list = jukeBox.getPlayList();
        
        assertEquals(2, list.size());
        assertTrue(list.contains(song2));
    }

    @Test
    public void testPlaySong() {
        jukeBox.addSong(song);
        jukeBox.playSong(songTitle);
        Song mySong = jukeBox.getCurrentSong();
        assertTrue(mySong.isPlaying());
    }
    
    @Test
    public void testPlayOfAlreadyPlayingSong() {
        jukeBox.addSong(song);
        
        // play song; should not generate any exception
        try {
          jukeBox.playSong(songTitle);
        } catch(JukeBoxException e) {
          fail("no exception expected at first call of playTitle"); 
        }
        
        assertThrows(JukeBoxException.class, () -> jukeBox.playSong(songTitle));
    }


}

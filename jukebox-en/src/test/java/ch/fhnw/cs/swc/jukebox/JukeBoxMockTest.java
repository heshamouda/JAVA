package ch.fhnw.cs.swc.jukebox;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JukeBoxMockTest {

	protected static String songTitle = "Icebreaker";
	protected JukeBox jukeBox;
	protected Song song;

	@BeforeEach
	public void setUp() {
		 jukeBox = new MusicJukeBox();
	}

	/*
	 * testPlayOfNonExistingSong tries to play a non-existing song. The MusicJukeBox
	 * should generate an exception in this case and verify the correct exception
	 * message.
	 */
	@Test
	public void testPlayOfNonExistingSong() {
		assertThrows(JukeBoxException.class, () -> jukeBox.playSong("not existing"));
	}

	/*
	 * testGetPlayList adds two new songs to the MusicJukeBox and checks if the play
	 * list is not empty and the songs are in the list.
	 */
	@Test
	public void testGetPlayList() {
		Song song = mock(Song.class);	
		when(song.getTitle()).thenReturn(songTitle);
		jukeBox.addSong(song);		
	
		List<Song> list = jukeBox.getPlayList();
		assertEquals(1, list.size());
		assertTrue(list.contains(song));

		// add a second song and test for correct play list
		Song song2 = mock(Song.class);
		when(song2.getTitle()).thenReturn("Hello Kitty");
		jukeBox.addSong(song2);
		list = jukeBox.getPlayList();

		assertEquals(2, list.size());
		assertTrue(list.contains(song2));
	}

	/*
	 * testPlaySong adds a new song to the MusicJukeBox and tries to play it. It
	 * also retrieves the current song and verifies if it is currently played.
	 */
	@Test
	public void testPlaySong() {
		Song song = mock(Song.class);	
		when(song.getTitle()).thenReturn(songTitle);
		//the default value is false, so we should force true.
		when(song.isPlaying()).thenReturn(true);
		jukeBox.addSong(song);
		jukeBox.playSong(songTitle);
		Song mySong = jukeBox.getCurrentSong();
		assertTrue(mySong.isPlaying());
	}

	/*
	 * testPlayOfAlreadyPlayingSong adds a new song to the MusicJukeBox 
	 * and tries to start the song two times. 
	 * The second start of the already playing song
	 * should generate an exception caused by the Song class. 
	 */
	
	public void testPlayOfAlreadyPlayingSong() {
		Song song = mock(Song.class);	
		when(song.getTitle()).thenReturn(songTitle);
		
		jukeBox.addSong(song);

		// play song; should not generate any exception
		try {
			jukeBox.playSong(songTitle);
		} catch (JukeBoxException e) {
			fail("no exception expected at first call of playTitle");
		}

		doThrow(new JukeBoxException("is already playing")).when(song).start();
		assertThrows(JukeBoxException.class, () -> jukeBox.playSong(songTitle));
	}

	@Test
	public void testPlayOfAlreadyPlayingSongWithMockChaining() {
		Song song = mock(Song.class);	
		when(song.getTitle()).thenReturn(songTitle);
		
		jukeBox.addSong(song);
		
		doNothing()
		.doThrow(new JukeBoxException("is already playing")).when(song).start();
		// play song; should not generate any exception
		try {
			jukeBox.playSong(songTitle);
		} catch (JukeBoxException e) {
			fail("no exception expected at first call of playTitle");
		}
	
		assertThrows(JukeBoxException.class, () -> jukeBox.playSong(songTitle));
	}

}

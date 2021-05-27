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
		jukeBox.addSong(song);
		List<Song> list = jukeBox.getPlayList();

		assertEquals(1, list.size());
		assertTrue(list.contains(song));

		// add a second song and test for correct play list
		Song song2 = new SongStub2("Hello Kitty");
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
	@Test
	public void testPlayOfAlreadyPlayingSong() {
		jukeBox.addSong(song);

		// play song; should not generate any exception
		try {
			jukeBox.playSong(songTitle);
		} catch (JukeBoxException e) {
			fail("no exception expected at first call of playTitle");
		}

		assertThrows(JukeBoxException.class, () -> jukeBox.playSong(songTitle));
	}

}

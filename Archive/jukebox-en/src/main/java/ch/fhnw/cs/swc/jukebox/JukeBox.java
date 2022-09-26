package ch.fhnw.cs.swc.jukebox;

import java.util.List;

public interface JukeBox {

	/**
	 * Adds given song to the playlist.
	 * 
	 * @param song to add
	 */
    public void addSong(Song song);

	/**
	 * Plays a song given by its title.
	 * 
	 * @param songTitle song title to play.
	 * @throws JukeBoxException in case if song is just playing. 
	 */
    public void playSong(String title) throws JukeBoxException;

	/**
	 * Returns song which is currently playing.
	 * 
	 * @return song object
	 */
    public Song getCurrentSong();

	/**
	 * Returns the playlist.
	 * 
	 * @return list of all song objects added to this jukebox
	 */
    public List<Song> getPlayList();

}

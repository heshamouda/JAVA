package ch.fhnw.cs.swc.jukebox;

public interface Song {
	/**
	 * @return the title of this song.
	 */
	public String getTitle();
	/**
	 * @return the duration of this song.
	 */
	public float getPlayTime();
	/**
	 * @return whether the song is currently playing.
	 */
	public boolean isPlaying();
	/**
	 * Plays the song.
	 * @throws JukeBoxException if the song is already playing.
	 */
	public void start() throws JukeBoxException;
}
 
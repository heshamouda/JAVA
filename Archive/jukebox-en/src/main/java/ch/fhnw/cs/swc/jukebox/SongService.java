package ch.fhnw.cs.swc.jukebox;

import java.util.List;

/**
 * Provides methods to download songs from a remote service (like Spotify).
 */
public interface SongService {

	/**
	 * Retrieve a list of songs which are top ranked.
	 */
    List<Song> getTopPlaylist();
}

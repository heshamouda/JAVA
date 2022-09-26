package ch.fhnw.cs.swc.jukebox;

    public class SpotifyJukeBoxLoader {
        private SongService service;
        private JukeBox jukebox;

        /**
         * Untestable implementation of Spotify constructor.
         * It cannot be isolated for testing due to hard-wiring 
         * to SpotifySongService.
         * DO NOT USE
         * @param spotifyID
         */
        @Deprecated
        public SpotifyJukeBoxLoader(String spotifyID){
            jukebox = new MusicJukeBox();
            service = new SpotifySongService(spotifyID);
            for (Song song: service.getTopPlaylist()) {
                jukebox.addSong(song);
            }
        }
        
        public void playSong(String title) {
            jukebox.playSong(title);
        }
        public Song getCurrentSong() {
            return jukebox.getCurrentSong();
        }

        
        /**
         * A testable implementation of Spotify constructor.
         * It can be isolated for testing, since the actual service
         * and jukebox is passed as an argument. 
         * In a test, mocks can be passed in instead of the real 
         * service and jukebox.
         * But still not a good implementation: The constructor shouldn't 
         * do too much initialisation.
         * @param songService
         * @param jukebox
         */
        @Deprecated
        public SpotifyJukeBoxLoader(SongService songService, JukeBox jukebox){
            service = songService;
            this.jukebox = jukebox;
            for (Song song: service.getTopPlaylist()) {
                jukebox.addSong(song);
            }
        }

        /**
         * this constructor is just needed because we also have the 
         * deprecated custom constructors above.
         * If these are removed also this default constructor implementation
         * ca be removed 
         */
        public SpotifyJukeBoxLoader(){
        }
        
        
    /**
     * Set the SongService to be used for loading songs.
     * This setter can be used during testing to set mock objects
     * instead of real services.
     * @param spotifyID
     */
    public void setService(SongService songService){
        service = songService;
    }

    /**
     * Set the JukeBox used as target for this loader.
     * This setter can be used during testing to set mock objects
     * instead of a real jukebox.
     * @param jukebox load songs for this jukebox.
     */
    public void setJukeBox(JukeBox jukebox) {
    	this.jukebox = jukebox;
    }
    
    /**
     * As we introduced pure setters, we need this method to actually load the
     * songs into the jukebox.
     */
    public void loadSongs() {
    	if (service != null) {
	        for (Song song: service.getTopPlaylist()) {
	            jukebox.addSong(song);
	        }
    	}
    }
}

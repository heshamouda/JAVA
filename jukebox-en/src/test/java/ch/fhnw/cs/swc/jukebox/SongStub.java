package ch.fhnw.cs.swc.jukebox;

public class SongStub implements Song {
	
	private String title = null;
	private boolean isPlaying = false;

	public SongStub(String aTitle) {
		title = aTitle;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public float getPlayTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return isPlaying;
	}

	@Override
	public void start() throws JukeBoxException {

		if (isPlaying) {
			throw new JukeBoxException("The song starts for the second time, it is already playing ");
		}
		
		isPlaying = true;
	}

}

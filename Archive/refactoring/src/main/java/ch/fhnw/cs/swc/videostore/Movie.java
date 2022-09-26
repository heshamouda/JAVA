/**
 * 
 */
package ch.fhnw.cs.swc.videostore;

/**
 * @author Martin Fowler
 *
 */

public interface Movie {

	public float getPlayTime();
	public boolean isPlaying();
	public void start() throws MovieRentalException;


	public static final int CHILDRENS = 2; 
	public static final int REGULAR = 0; 
	public static final int NEW_RELEASE = 1; 



	public int getPriceCode() ;

	public String getTitle ();

} 
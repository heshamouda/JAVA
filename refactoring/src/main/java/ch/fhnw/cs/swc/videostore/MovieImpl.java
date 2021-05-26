package ch.fhnw.cs.swc.videostore;

import org.apache.commons.lang3.RandomUtils;

public class MovieImpl implements Movie {

    private final String title;
    private final long duration;
    private long startTime;
    private int priceCode;


    MovieImpl(String title, int priceCode) {
        this.title = title;
        this.duration = RandomUtils.nextLong();
        this.priceCode = priceCode;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getPlayTime() {
        return duration;
    }

    @Override
    public boolean isPlaying() {
        return System.currentTimeMillis() - startTime < duration;
    }

    @Override
    public void start() throws MovieRentalException {
        if (isPlaying()){
            throw new MovieRentalException("Movie is already playing");
        }
        startTime = System.currentTimeMillis();
    }

    @Override
    public int getPriceCode(){
        return priceCode;
    }


}

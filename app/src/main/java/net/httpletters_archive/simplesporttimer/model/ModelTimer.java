package net.httpletters_archive.simplesporttimer.model;

/**
 * Created by MyComp on 27.04.2017.
 */

public class ModelTimer implements Item {

    private String mTitle;
    private int mRound;
    private int mRest;
    private int mRepeat;

    public ModelTimer() {
    }

    public ModelTimer(String title, int round, int rest, int repeat) {
        this.mTitle = mTitle;
        this.mRound = mRound;
        this.mRest = mRest;
        this.mRepeat = mRepeat;
    }

    @Override
    public boolean isTimer() {
        return true;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
       return mTitle;
    }

    public void setRound(int round) {
        this.mRound = round;
    }

    public void setRest(int rest) {
        this.mRest = rest;
    }

    public void setRepeat(int repeat) {
        this.mRepeat = repeat;
    }
}
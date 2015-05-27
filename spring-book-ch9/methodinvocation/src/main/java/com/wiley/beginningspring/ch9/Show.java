package com.wiley.beginningspring.ch9;

/**
 * Created by mertcaliskan
 * on 27/07/14.
 */
public class Show {

    private String instrument;
    private String song;

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String guitarSong() {
        return "More Than Words";
    }

    public void present() {
        System.out.println("Playing " + song + " with instrument " + instrument);
    }
}

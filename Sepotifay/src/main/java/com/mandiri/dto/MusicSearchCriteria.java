package com.mandiri.dto;

public class MusicSearchCriteria {
    private final String title;
    private final String composer;
    private final String studio;

    private final String artistName;

    public MusicSearchCriteria(String title, String composer, String studio, String artistName) {
        this.title = title;
        this.composer = composer;
        this.studio = studio;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public String getComposer() {
        return composer;
    }

    public String getStudio() {
        return studio;
    }

    public String getArtistName(){
        return artistName;
    }
}

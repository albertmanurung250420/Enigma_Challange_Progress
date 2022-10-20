package com.mandiri.dto;

import com.mandiri.entity.Artists;
import org.springframework.data.domain.Page;

import java.util.List;

public class MusicRegisterDto<T> {

    private String id;
    private String title;
    private String composer;
    private String studio;

    private String artistId;

    public MusicRegisterDto(String id, String title, String composer, String studio, String artistId) {
        this.id = id;
        this.title = title;
        this.composer = composer;
        this.studio = studio;
        this.artistId=artistId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}

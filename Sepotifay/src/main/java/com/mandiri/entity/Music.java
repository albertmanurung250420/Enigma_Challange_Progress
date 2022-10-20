package com.mandiri.entity;

import com.mandiri.dto.MusicRegisterDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @NotNull
    private String title;
    @NotNull
    private String composer;
    @NotNull
    private String studio;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @NotNull
    private Artists artists;

    public Music(MusicRegisterDto musicRegisterFormDTO) {
        this.id = musicRegisterFormDTO.getId();
        this.title = musicRegisterFormDTO.getTitle();
        this.composer = musicRegisterFormDTO.getComposer();
        this.studio = musicRegisterFormDTO.getStudio();
    }

    public Music() {
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

    public Artists getArtist() {
        return artists;
    }

    public void setArtist(Artists artists) {
        this.artists = artists;
    }
}

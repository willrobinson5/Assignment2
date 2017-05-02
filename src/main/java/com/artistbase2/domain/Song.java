package com.artistbase2.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by web on 27/04/17.
 */
@Entity
public class Song {

    Long id;

    @NotEmpty
    String songTitle;

    @NotEmpty
    String songLength;

    private Artist artist;

    public Song() {

    }

    public Song(String songTitle){
        this.songTitle = songTitle;
    }

    public Song(String songTitle, Artist artist){
        this.songTitle = songTitle;
        this.artist = artist;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongLength() {
        return songLength;
    }

    public void setSongLength(String songLength) {
        this.songLength = songLength;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {

        this.artist = artist;
    }
}

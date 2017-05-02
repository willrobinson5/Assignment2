package com.artistbase2.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by web on 27/04/17.
 */
@Entity
public class Artist {

    Long id;

    @NotEmpty
    String artistFirstname;
    @NotEmpty
    String artistSurname;
    @NotEmpty
    String artistInfo;
    @NotEmpty
    String artistDOB;

    private Set<Song> songs;

    public Artist(){

    }

    public Artist(String artistFirstname, String artistSurname){
        this.artistFirstname = artistFirstname;
        this.artistSurname = artistSurname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistFirstname() {
        return artistFirstname;
    }

    public void setArtistFirstname(String artistFirstname) {
        this.artistFirstname = artistFirstname;
    }

    public String getArtistSurname() {
        return artistSurname;
    }

    public void setArtistSurname(String artistSurname) {
        this.artistSurname = artistSurname;
    }

    public String getArtistInfo() {
        return artistInfo;
    }

    public void setArtistInfo(String artistInfo) {
        this.artistInfo = artistInfo;
    }

    public String getArtistDOB() {
        return artistDOB;
    }

    public void setArtistDOB(String artistDOB) {
        this.artistDOB = artistDOB;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

}

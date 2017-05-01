package com.artistbase2.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by web on 27/04/17.
 */
@Entity
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String artistFirstname;
    @NotEmpty
    String artistSurname;
    @NotEmpty
    String artistInfo;
    @NotEmpty
    String artistDOB;

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

}

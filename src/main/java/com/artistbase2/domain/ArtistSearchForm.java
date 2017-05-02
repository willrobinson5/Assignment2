package com.artistbase2.domain;

/**
 * Created by web on 02/05/17.
 */
public class ArtistSearchForm {

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

    String artistFirstname;
    String artistSurname;

}

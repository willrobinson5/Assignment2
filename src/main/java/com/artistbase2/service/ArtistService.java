package com.artistbase2.service;

import com.artistbase2.domain.Artist;
import com.artistbase2.domain.ArtistRepository;

import com.artistbase2.domain.ArtistSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 27/04/17.
 */
@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    public Artist save(Artist a) {
        return artistRepository.save(a);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }

    public List<Artist> searchArtist(ArtistSearchForm artist) {
        return artistRepository.searchArtists(artist.getArtistFirstname(), artist.getArtistSurname());
    }
}

package com.artistbase2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 27/04/17.
 */
public interface ArtistRepository extends JpaRepository<Artist, Long>{

    List<Artist> findByArtistFirstnameAndArtistSurname(String artistFirstname, String artistSurname);

    @Query("SELECT a FROM Artist a WHERE a.artistFirstname like %?1% AND a.artistSurname like %?2%")
    List<Artist> searchArtists(String artistFirstname, String artistSurname);

}



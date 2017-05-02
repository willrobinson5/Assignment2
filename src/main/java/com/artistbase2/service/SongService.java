package com.artistbase2.service;

import com.artistbase2.domain.Song;
import com.artistbase2.domain.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 02/05/17.
 */
@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public Song save(Song s) {

        return songRepository.save(s); }

        public List<Song> findAll() { return songRepository.findAll();}
}

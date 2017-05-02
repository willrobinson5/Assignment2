package com.artistbase2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by web on 02/05/17.
 */
public interface SongRepository extends JpaRepository<Song, Long>{
}
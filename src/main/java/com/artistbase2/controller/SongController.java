package com.artistbase2.controller;

import com.artistbase2.domain.Artist;
import com.artistbase2.domain.Song;
import com.artistbase2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by web on 02/05/17.
 */
@Controller
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    SongService songService;

    //loads the view for adding a song onto an artist.
    @RequestMapping(value = "/addsong/{artist}", method = RequestMethod.GET)
    public String addSongView(Model model, @PathVariable Artist artist)
    {
        Song song = new Song();
        //passes through the artist into the song page.
        song.setArtist(artist);
        model.addAttribute("song", song);

        return "artist/addSong";
    }

    //Adds the song written in the form to the artist.
    @RequestMapping(value = "/addsong", method = RequestMethod.POST)
    public String addSong(Model model, @ModelAttribute("song") Song song)
    {
        songService.save(song);

        return "redirect:/";
    }

}

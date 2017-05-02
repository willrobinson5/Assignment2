package com.artistbase2.controller;

import com.artistbase2.domain.Artist;

import com.artistbase2.domain.ArtistSearchForm;
import com.artistbase2.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by web on 27/04/17.
 */
@Controller
@RequestMapping(value="/artist")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/addArtist", method = RequestMethod.GET)
    //takes the user to the artist view.
    public String addArtistView(Model model)
    {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "artist/addArtist";
    }

    //adds an arist into the artist table.
    @RequestMapping(value = "/addArtist", method = RequestMethod.POST)
    public String addArtist(Model model, @Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("artist", artist);
            model.addAttribute("message", "Please enter info in all fields");
            return "artist/addArtist";
        }
        artistService.save(artist); //Saves the artist table
        return "redirect:/";
    }
    //Search for the artist in the artist table to output the artists in the
    //artist view.
    @RequestMapping(value="/artistSearch", method=RequestMethod.GET)
    public String searchView(Model model)
    {
        ArtistSearchForm searchForm = new ArtistSearchForm();
        model.addAttribute("searchCriteria", searchForm);
        return "artist/artistSearch";
    }
    //POST method for the artist view.
    @RequestMapping(value="/artistSearch", method=RequestMethod.POST)
    public String searchView(Model model, @ModelAttribute("searchCriteria") ArtistSearchForm searchForm)
    {
        List<Artist> artists=artistService.searchArtist(searchForm);
        model.addAttribute("searchCriteria", searchForm);
        model.addAttribute("artists", artists);
        return "artist/artistSearch";
    }
    //Shows all artists.
    @RequestMapping(value = "/artistIndex", method = RequestMethod.GET)
    public String artistIndex(Model model, HttpSession session)
    {
        List<Artist> artist = artistService.findAll();
        model.addAttribute("artist", artist);
        return "artist/artistIndex";
    }

    //loads the update view.
    @RequestMapping(value = "/artistUpdate/{artist}", method = RequestMethod.GET)
    public String artistUpdateView(Model model, @PathVariable Artist artist)
    {
        model.addAttribute("artist", artist);
        return "artist/artistUpdate";
    }

    //saves the update form in the artist table.
    @RequestMapping(value = "/artistUpdate", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("user") Artist artist)
    {
        artistService.save(artist);
        return "redirect:/";
    }

    //Deletes the artist from the artist table.
    @RequestMapping(value = "/deleteArtist/{artist}", method = RequestMethod.GET)
    public String deleteArtist(@PathVariable Artist artist)
    {
        artistService.delete(artist);
        return "redirect:/";
    }

    //Shows the artist info page of the artists selected.
    @RequestMapping(value = "/artistInfo/{artist}", method = RequestMethod.GET)
    public String artistInfoView(Model model, @PathVariable Artist artist)
    {
        model.addAttribute("artist", artist);
        return "artist/artistInfo";
    }

}

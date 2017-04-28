package com.artistbase2.controller;

import com.artistbase2.domain.Artist;
import com.artistbase2.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

    public String addArtistView(Model model)
    {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "artist/addArtist";
    }

    @RequestMapping(value = "/addArtist", method = RequestMethod.POST)
//    @ResponseBody
    public String addArtist(Model model, @Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("artist", artist);
            model.addAttribute("message", "Please enter info in all fields");
            return "artist/addArtist";
        }
        artistService.save(artist);
        return "artist/artistIndex";
    }


    @RequestMapping(value = "/artistIndex", method = RequestMethod.GET)
    public String artistIndex(Model model, HttpSession session)
    {
        List<Artist> artist = artistService.findAll();
        model.addAttribute("artist", artist);
        return "artist/artistIndex";
    }

    @RequestMapping(value = "/artistUpdate/{artist}", method = RequestMethod.GET)
    public String artistUpdateView(Model model, @PathVariable Artist artist)
    {
        model.addAttribute("artist", artist);
        return "artist/artistUpdate";
    }

    @RequestMapping(value = "/artistUpdate", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("user") Artist artist)
    {
        artistService.save(artist);
        return "redirect:/artist/artistIndex";
    }

    @RequestMapping(value = "/delete/{artist}", method = RequestMethod.GET)
//    @ResponseBody
    public String deleteArtist(@PathVariable Artist artist)
    {
        artistService.delete(artist);
        return "redirect:/artist/artistIndex";
    }
}

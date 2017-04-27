package com.artistbase2.controller;

import com.artistbase2.domain.Artist;
import com.artistbase2.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

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
        return "redirect:/";
    }
}

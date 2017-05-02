package com.artistbase2.controller;

import com.artistbase2.domain.Artist;
import com.artistbase2.domain.User;
import com.artistbase2.service.ArtistService;
import com.artistbase2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by web on 19/04/17.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;
    ArtistService artistService;

    //Opens the home page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session)
    {
        //If there is no user logged in there will be no user session
        //so the page won't load.
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    //loads the maps view which shows the google maps api.
    @RequestMapping(value = "/maps", method = RequestMethod.GET)
    public String mapsView(Model model)
    {
        return "maps";
    }
}


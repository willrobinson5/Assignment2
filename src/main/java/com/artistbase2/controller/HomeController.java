package com.artistbase2.controller;

import com.artistbase2.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by web on 19/04/17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model)
    {
        User user = new User();

        user.setFirstname("Will");
        user.setSurname("Robinson");
        user.setPassword("password");

        model.addAttribute("user", user);
        return "index";
    }
}


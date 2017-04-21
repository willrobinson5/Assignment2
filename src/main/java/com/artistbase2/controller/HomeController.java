package com.artistbase2.controller;

import com.artistbase2.domain.User;
import com.artistbase2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by web on 19/04/17.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model)
    {

        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "index";
    }
}


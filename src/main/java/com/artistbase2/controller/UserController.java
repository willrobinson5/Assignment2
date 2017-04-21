package com.artistbase2.controller;

import com.artistbase2.domain.User;
import com.artistbase2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.ext.Attributes2Impl;

/**
 * Created by web on 19/04/17.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)

    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
    public String register(Model model, @ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
        //return "the user" + user.getFirstname();
    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user)
    {
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)
//    @ResponseBody
    public String delete(@PathVariable User user)
    {
        String name = user.getFirstname() + " " + user.getSurname();
        userService.delete(user);

        return "redirect:/";
    }
}

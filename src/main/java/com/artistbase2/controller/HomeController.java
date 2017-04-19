package com.artistbase2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by web on 19/04/17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String index()
    {
//        return ("Hello, world, this is demo project");
        return "index";
    }
}


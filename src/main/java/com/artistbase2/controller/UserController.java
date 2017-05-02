package com.artistbase2.controller;

import com.artistbase2.domain.LoginForm;
import com.artistbase2.domain.User;
import com.artistbase2.domain.UserSearchForm;
import com.artistbase2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by web on 19/04/17.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)

    //Loads the view for user registration.
    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    //Adds the user into the user table.
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult)
    {
        //Validation on the fields so if they are empty, output message.
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please enter info in all fields");
            return "user/register";
        }
        //Saves the user into the table.
        userService.save(user);
        return "redirect:/";
        //return "the user" + user.getFirstname();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String loginView(Model model)
    {
        LoginForm user = new LoginForm();
        model.addAttribute("user", user);
        return "user/login";
    }

    //logs the user into the home page if the details match the users table.
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @Valid @ModelAttribute("user") LoginForm user, BindingResult
            bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please enter info in all fields");
            return "user/login";
        }

        if(userService.validateLogin(user)==false)
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Your account name or password is incorrect");
            return "user/login";
        }
        session.setAttribute("login", true);
        return "redirect:/";
    }

    //logs the user out.
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session)
    {
        session.removeAttribute("login");
        return "redirect:/user/login";
    }

    //opens the search form
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String searchView(Model model)
    {
        UserSearchForm searchForm = new UserSearchForm();
        model.addAttribute("searchCriteria", searchForm);
        return "user/search";
    }

    //Searches the artists table for the letters inputted.
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String searchView(Model model, @ModelAttribute("searchCriteria") UserSearchForm searchForm)
    {
        List<User> users=userService.searchUsers(searchForm);
        model.addAttribute("searchCriteria", searchForm);
        model.addAttribute("users", users);
        return "user/search";
    }

    //Loads the users update form
    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user)
    {
        model.addAttribute("user", user);
        return "user/update";
    }

    //Updates the user of the user that was clicked on.
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
    }

    //deletes the artist that was clicked.
    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)
    public String delete(@PathVariable User user)
    {
        String name = user.getFirstname() + " " + user.getSurname();
        userService.delete(user);
        return "redirect:/";
    }
}

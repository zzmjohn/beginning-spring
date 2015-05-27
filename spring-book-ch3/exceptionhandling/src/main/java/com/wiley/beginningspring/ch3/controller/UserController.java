package com.wiley.beginningspring.ch3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wiley.beginningspring.ch3.domain.User;
import com.wiley.beginningspring.ch3.exception.UserNotFoundException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * User: mertcaliskan
 * Date: 12/06/14
 */
@Controller
public class UserController {

    private Map<String, User> users = new HashMap<String, User>();

    @PostConstruct
    public void setup() {
        users.put("mert", new User("Mert", "Caliskan"));
        users.put("kenan", new User("Kenan", "Sevindik"));
    }

    @RequestMapping(value = "/form")
    public ModelAndView user() {
        return new ModelAndView("userForm", "user", new User());
    }

    @RequestMapping(value = "/result")
    public ModelAndView processUser(String name) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = users.get(name);
        if ("johndoe".equals(name)) {
            throw new Exception();
        }
        if (user == null) {
            throw new UserNotFoundException(name);
        }
        modelAndView.addObject("u", user);
        modelAndView.setViewName("userResult");

        return modelAndView;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleException(UserNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("errorUser");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }
}
package com.wiley.beginningspring.ch3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wiley.beginningspring.ch3.domain.User;

import javax.validation.Valid;

@Controller
public class UserController {

	@RequestMapping(value = "/form")
	public ModelAndView user() {
			return new ModelAndView("userForm", "user", new User());
	}

	@RequestMapping(value = "/result", method= RequestMethod.POST)
	public ModelAndView processUser(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("u", user);

        if (result.hasErrors()) {
            modelAndView.setViewName("userForm");
        }
        else {
            modelAndView.setViewName("userResult");
        }

		return modelAndView;
	}
}
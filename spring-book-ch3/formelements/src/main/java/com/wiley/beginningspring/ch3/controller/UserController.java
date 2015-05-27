package com.wiley.beginningspring.ch3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wiley.beginningspring.ch3.domain.Gender;
import com.wiley.beginningspring.ch3.domain.User;

@Controller
public class UserController {

    private static final String[] countries = { "Turkey", "United States", "Germany" };


	@RequestMapping(value = "/form")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("userForm", "user", new User());
		modelAndView.addObject("genders", Gender.values());
		modelAndView.addObject("countries", countries);
		
		return modelAndView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView processUser(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userResult");
		
		modelAndView.addObject("u", user);

		return modelAndView;
	}
}
package com.wiley.beginningspring.ch3.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wiley.beginningspring.ch3.domain.User;

@Controller
public class FileUploadController {

	@RequestMapping("/form")
	public ModelAndView getFileUploadForm() {
		return new ModelAndView("fileUpload", "user", new User());
	}

	@RequestMapping(value = "/upload")
	public ModelAndView processUser(User user) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("fileUpload");
		modelAndView.addObject("userName", user.getName());
		modelAndView.addObject("fileLength", user.getFile().getBytes().length);

		return modelAndView;
	}
}

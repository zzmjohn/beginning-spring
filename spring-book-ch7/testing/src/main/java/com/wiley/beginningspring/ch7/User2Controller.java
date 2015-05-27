package com.wiley.beginningspring.ch7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wiley.beginningspring.ch7.domain.SimpleUser;
import com.wiley.beginningspring.ch7.exception.UserNotFoundException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * User: mertcaliskan
 * Date: 12/06/14
 */
@Controller
public class User2Controller {

    private Map<String, SimpleUser> users = new HashMap<String, SimpleUser>();

    @PostConstruct
    public void setup() {
        users.put("mert", new SimpleUser("Mert", "Caliskan"));
        users.put("kenan", new SimpleUser("Kenan", "Sevindik"));
    }

    @RequestMapping(value = "/findUser")
    public ModelAndView processUser(String name) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        SimpleUser user = users.get(name);

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
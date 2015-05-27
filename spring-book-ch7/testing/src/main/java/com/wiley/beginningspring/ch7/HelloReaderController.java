package com.wiley.beginningspring.ch7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: mertcaliskan
 * Date: 18/06/14
 */
@Controller
public class HelloReaderController {

    @RequestMapping(value = "/hello")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello Reader!");
        mv.setViewName("helloReader");

        return mv;
    }
}

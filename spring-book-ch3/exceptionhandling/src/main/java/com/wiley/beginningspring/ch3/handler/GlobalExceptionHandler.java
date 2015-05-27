package com.wiley.beginningspring.ch3.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: mertcaliskan
 * Date: 12/06/14
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException() {
        return new ModelAndView("errorGlobal");
    }
}

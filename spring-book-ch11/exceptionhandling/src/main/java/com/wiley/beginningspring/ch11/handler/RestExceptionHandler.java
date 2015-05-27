package com.wiley.beginningspring.ch11.handler;

import com.wiley.beginningspring.ch11.domain.RestErrorMessage;
import com.wiley.beginningspring.ch11.exception.RestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by mertcaliskan
 * on 04/10/14.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInvalidRequest(RestException e, ServletWebRequest request) {
        RestErrorMessage error = new RestErrorMessage(HttpStatus.valueOf(request.getResponse().getStatus()),
                e.getCode(),
                e.getMessage(),
                e.getDetailedMessage(),
                e.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.OK, request);
    }
}
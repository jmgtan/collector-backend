package org.humanitarian.collector.controllers;

import org.humanitarian.collector.controllers.responses.ExceptionResponse;
import org.humanitarian.collector.exceptions.BaseRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BaseRestException.class)
    public ExceptionResponse baseExceptionHandler(HttpServletResponse resp, BaseRestException ex) {
        resp.setStatus(ex.getStatusCode());

        return new ExceptionResponse(ex);
    }

    @ExceptionHandler(Exception.class)
    public ExceptionResponse catchAllExceptionHandler(HttpServletResponse resp, Exception ex) {
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        resp.setStatus(statusCode);

        return new ExceptionResponse(statusCode, ex.getMessage());
    }
}

package com.zain.javacoffee.controller;

import com.zain.javacoffee.utils.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.security.validator.ValidatorException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidatorException.class)
    ErrorMessage exceptionHandler(ValidatorException e) {
        return new ErrorMessage("400",e.getMessage());
    }
}

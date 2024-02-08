package com.otya.care.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {
    @ExceptionHandler(CareDuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleCaraDuplicateException(CareDuplicateException e) {
        return new ResponseEntity<>("{\"error\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
    }
}

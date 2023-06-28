package com.example.DominosEurekaClient.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException{

    @ExceptionHandler(value=UserNotPresent.class)
    protected ResponseEntity<Object> handleNotFound(UserNotPresent exception)
    {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}

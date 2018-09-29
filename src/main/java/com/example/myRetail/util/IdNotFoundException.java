package com.example.myRetail.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

    /*
    Set a 404 error status and give the consuming API a better message than a stack dump
     */
    public IdNotFoundException(String exception) {
        super(exception);
    }
}

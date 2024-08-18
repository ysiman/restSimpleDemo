package ru.home.restSimpleDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class MinikubeServiceException extends Exception {

    private HttpStatusCode httpStatusCode;

    public MinikubeServiceException(String message){
        super(message);
    }

    public MinikubeServiceException(String message, Throwable cause, HttpStatusCode httpStatus){
        super(message,cause);
        this.httpStatusCode = httpStatus;
    }

}

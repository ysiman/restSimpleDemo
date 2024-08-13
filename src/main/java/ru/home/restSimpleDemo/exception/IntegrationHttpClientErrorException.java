package ru.home.restSimpleDemo.exception;

import org.springframework.http.HttpStatusCode;

public class IntegrationHttpClientErrorException extends BaseHttpClientErrorException {


    public IntegrationHttpClientErrorException(HttpStatusCode httpStatus, String statusDesc) {
        super(httpStatus, statusDesc);
    }
}

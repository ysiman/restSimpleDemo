package ru.home.restSimpleDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class BaseHttpClientErrorException extends RuntimeException {
    protected HttpStatusCode httpStatus;
    protected String statusDesc;

    public BaseHttpClientErrorException() {
    }

    public BaseHttpClientErrorException(String message) {
        super(message);
    }

    public BaseHttpClientErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseHttpClientErrorException(Throwable cause) {
        super(cause);
    }

    public BaseHttpClientErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseHttpClientErrorException(HttpStatusCode httpStatus, String statusDesc) {
        super("HttpStatus: {}" + httpStatus + ", statusDesc: " + statusDesc);
        this.httpStatus = httpStatus;
        this.statusDesc = statusDesc;
    }

    public HttpStatusCode getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatusCode httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}

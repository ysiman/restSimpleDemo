package ru.home.restSimpleDemo.exception.api;

import ru.home.restSimpleDemo.dto.validation.ValidationError;

import java.util.List;

public class ApiRequestValidationException extends RuntimeException{
    private final List<ValidationError> validationErrors;

    public ApiRequestValidationException(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public ApiRequestValidationException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}

package ru.home.restSimpleDemo.validation.validator;

public interface ApiRequestValidator<T> {
    void validate(T request);
}

package ru.home.restSimpleDemo.validation.validator;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import ru.home.restSimpleDemo.dto.validation.ValidationError;
import ru.home.restSimpleDemo.exception.api.ApiRequestValidationException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor
public abstract class BaseRequestValidator<T> implements ApiRequestValidator<T> {

    protected ValidationError createValidationError(String fieldName, String errorMsg) {
        return new ValidationError(fieldName, errorMsg);
    }

    @Override
    public final void validate(T request) throws ApiRequestValidationException {
        String rqName = request.getClass().getSimpleName();
        log.debug("Начало валидации запроса {}", rqName);
        List<ValidationError> validationErrors = processValidation(request);
        if (CollectionUtils.isNotEmpty(validationErrors)) {
            log.error("Запрос {} не прошел валидацию", rqName);
            String errors = validationErrors.stream().map(ValidationError::getCode).collect(Collectors.joining(", "));
            log.error("Поля не прошедшие валидацию: {}", errors);
            throw new ApiRequestValidationException("Произошла ошибка валидации запроса", validationErrors);
        }
        log.debug("Валидация завершена без ошибок");
    }

    protected abstract List<ValidationError> processValidation(T request);
}

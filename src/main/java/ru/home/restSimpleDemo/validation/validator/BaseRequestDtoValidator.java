package ru.home.restSimpleDemo.validation.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import ru.home.restSimpleDemo.dto.validation.ValidationError;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseRequestDtoValidator<T> extends BaseRequestValidator<T> {
    protected Validator validator;

    @Override
    protected List<ValidationError> processValidation(T request){
        return validateDTO(convertRequestToValidationDto(request), getValidationGroup());
    }

    protected abstract<R> R convertRequestToValidationDto(T request);

    protected Class<?> getValidationGroup() {
        return Default.class;
    }

    private<R> List<ValidationError> validateDTO(R validationDTO, Class<?> validationGroup){
        return validator.validate(validationDTO, validationGroup).stream()
                .map(this::createValidationError)
                .collect(Collectors.toList());
    }

    @Nullable
    private ValidationError createValidationError(ConstraintViolation<?> violation){
        String fieldName = getLeafNodeName(violation);
        if (fieldName == null){
            return null;
        } else {
            return createValidationError(fieldName, violation.getMessage());
        }
    }

    /**
     * Метод получения последней ноды из пути атрибута (сам атрибут).
     *
     * @param violation  путь атрибута
     * @return           атрибут или null
     */
    private String getLeafNodeName(ConstraintViolation<?> violation){
        Iterator <Path.Node> nodes = violation.getPropertyPath().iterator();
        Path.Node leafNode = null;
        while (nodes.hasNext()){
            leafNode = nodes.next();
        }
        if (leafNode != null){
            return leafNode.getName();
        } else {
            return null;
        }
    }
}

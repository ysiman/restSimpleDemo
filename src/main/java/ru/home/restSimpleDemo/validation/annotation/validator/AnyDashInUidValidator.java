package ru.home.restSimpleDemo.validation.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.home.restSimpleDemo.validation.annotation.AnyDashInUid;



public class AnyDashInUidValidator implements ConstraintValidator<AnyDashInUid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isEmpty()) {
            return value.contains("-");
        }
        return true;
    }
}

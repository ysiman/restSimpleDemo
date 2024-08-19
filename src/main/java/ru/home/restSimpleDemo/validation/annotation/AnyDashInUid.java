package ru.home.restSimpleDemo.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.home.restSimpleDemo.validation.annotation.validator.AnyDashInUidValidator;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = AnyDashInUidValidator.class)
@Documented
public @interface AnyDashInUid {

    String message() default "{AnyDashInUidValidator.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

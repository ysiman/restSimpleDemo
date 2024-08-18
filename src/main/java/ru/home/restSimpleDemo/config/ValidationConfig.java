package ru.home.restSimpleDemo.config;

import jakarta.validation.ConstraintValidatorFactory;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;


@Configuration
public class ValidationConfig {

    @Bean
    public ValidatorFactory validatorFactory(final AutowireCapableBeanFactory autowireCapableBeanFactory) {
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorFactory( new SpringConstraintValidatorFactory(autowireCapableBeanFactory))
                .buildValidatorFactory();
    }

//    @Bean
//    public Validator validator(final AutowireCapableBeanFactory autowireCapableBeanFactory) {
//        SpringConstraintValidatorFactory scvf =  new SpringConstraintValidatorFactory(autowireCapableBeanFactory);
//        ConstraintValidatorFactory cvf = (ConstraintValidatorFactory) scvf;
//                ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure()
//                .constraintValidatorFactory( cvf)
//                .buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//        return validator;
//    }
    @Bean
    public Validator validator(ValidatorFactory validatorFactory) {
        return validatorFactory.getValidator();
    }
}

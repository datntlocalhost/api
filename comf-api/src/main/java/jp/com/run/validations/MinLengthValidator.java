package jp.com.run.validations;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

public class MinLengthValidator implements HibernateConstraintValidator<MinLength, String> {
    
    @Override
    public void initialize(ConstraintDescriptor<MinLength> constraintDescriptor,
        HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}

package jp.com.run.validations;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

import jp.co.run.validation.StringValidation;

public class LengthValidator implements HibernateConstraintValidator<Length, String> {

    private int minLength;

    private int maxLength;

    @Override
    public void initialize(ConstraintDescriptor<Length> constraintDescriptor,
        HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);

        this.minLength = (int) constraintDescriptor.getAttributes().get("minLength");
        this.maxLength = (int) constraintDescriptor.getAttributes().get("maxLength");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (!StringValidation.isMinLengthValid(value, minLength)
            || !StringValidation.isMaxLengthValid(value, maxLength)) {
            return false;
        }

        return true;
    }
}

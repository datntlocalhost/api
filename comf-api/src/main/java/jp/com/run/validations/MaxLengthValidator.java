package jp.com.run.validations;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

import jp.co.run.validation.StringValidation;

public class MaxLengthValidator implements HibernateConstraintValidator<MaxLength, String> {
    
    private int maxLength;

    @Override
    public void initialize(ConstraintDescriptor<MaxLength> constraintDescriptor,
        HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);
        
        this.maxLength = (int) constraintDescriptor.getAttributes().get("maxLength");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isMaxLengthValid(value, maxLength);
    }

}

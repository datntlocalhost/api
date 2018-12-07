package jp.com.run.validations;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

import jp.co.run.validation.StringValidation;

public class PasswordValidator implements HibernateConstraintValidator<Password, String> {

    @Override
    public void initialize(ConstraintDescriptor<Password> constraintDescriptor,
        HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isAlphabetCharacter(value, "", true);
    }
}

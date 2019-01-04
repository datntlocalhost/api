package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class PasswordValidator implements CommonConstraintValidator<Password, String> {
    
    @Override
    public void initialize(ConstraintDescriptor<Password> constraintDescriptor) {
        CommonConstraintValidator.super.initialize(constraintDescriptor);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isAlphabetCharacter(value, "", true);
    }
}

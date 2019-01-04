package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class EmailValidator implements CommonConstraintValidator<Email, String> {

    @Override
    public void initialize(ConstraintDescriptor<Email> constraintDescriptor) {
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isEmailValid(value, "._-");
    }
}

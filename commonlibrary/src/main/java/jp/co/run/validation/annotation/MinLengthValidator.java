package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;

public class MinLengthValidator implements CommonConstraintValidator<MinLength, String> {

    @Override
    public void initialize(ConstraintDescriptor<MinLength> constraintDescriptor) {
        CommonConstraintValidator.super.initialize(constraintDescriptor);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}

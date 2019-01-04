package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class LengthValidator implements CommonConstraintValidator<Length, String> {

    private int minLength;

    private int maxLength;

    @Override
    public void initialize(ConstraintDescriptor<Length> constraintDescriptor) {
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

package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class MaxLengthValidator implements CommonConstraintValidator<MaxLength, String> {
    
    private int maxLength;

    @Override
    public void initialize(ConstraintDescriptor<MaxLength> constraintDescriptor) {
        this.maxLength = (int) constraintDescriptor.getAttributes().get("maxLength");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isMaxLengthValid(value, maxLength);
    }

}

package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class KatakanaValidator implements CommonConstraintValidator<Katakana, String> {

    @Override
    public void initialize(ConstraintDescriptor<Katakana> constraintDescriptor) {
        CommonConstraintValidator.super.initialize(constraintDescriptor);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isKatakana(value, "", true);
    }
}

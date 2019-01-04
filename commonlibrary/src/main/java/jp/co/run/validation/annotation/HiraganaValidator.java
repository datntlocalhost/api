package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class HiraganaValidator implements CommonConstraintValidator<Hiragana, String> {

    @Override
    public void initialize(ConstraintDescriptor<Hiragana> constraintDescriptor) {
        CommonConstraintValidator.super.initialize(constraintDescriptor);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isHiragana(value, "", true);
    }
}

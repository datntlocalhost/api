package jp.co.run.validation.annotation;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.CommonConstraintValidator;
import jp.co.run.validation.StringValidation;

public class NotNullValidator implements CommonConstraintValidator<NotNull, String>{
    
    @Override
    public void initialize(ConstraintDescriptor<NotNull> constraintDescriptor) {
        CommonConstraintValidator.super.initialize(constraintDescriptor);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if (StringValidation.isNull(value) || StringValidation.isEmptyWithoutBlank(value)) {
            return false;
        }
        
        return true;
    }
}

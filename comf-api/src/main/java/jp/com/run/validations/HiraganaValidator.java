package jp.com.run.validations;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

import jp.co.run.validation.StringValidation;

public class HiraganaValidator implements HibernateConstraintValidator<Hiragana, String> {

    @Override
    public void initialize(ConstraintDescriptor<Hiragana> constraintDescriptor,
        HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringValidation.isHiragana(value, "");
    }
}

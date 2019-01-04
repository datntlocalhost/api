package jp.co.run.validation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.metadata.ConstraintDescriptor;

import jp.co.run.validation.annotation.Incubating;

@Incubating
public interface CommonConstraintValidator<A extends Annotation, T> extends ConstraintValidator<A, T>{

    default void initialize(ConstraintDescriptor<A>  constraintDescriptor) {}
}

package jp.com.run.validations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {NameValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface Name {

    /**
     * Message.
     *
     * @return the string
     */
    String message() default "";

    /**
     * Error code.
     *
     * @return the string
     */
    String errorCode() default "";

    /**
     * Item name.
     *
     * @return the string
     */
    String itemName() default "";

    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@link NotNull} annotations on the same element.
     *
     * @see javax.validation.constraints.NotNull
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        /**
         * Value.
         *
         * @return the not null[]
         */
        Name[] value();
    }

    
}

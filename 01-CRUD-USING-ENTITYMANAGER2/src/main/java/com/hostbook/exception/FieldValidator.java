package com.hostbook.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = GlobalException.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Target({ ElementType.FIELD })
public @interface FieldValidator {

    String message() default "default status error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

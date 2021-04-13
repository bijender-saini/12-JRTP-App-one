package com.hostbook.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.stereotype.Component;

//import org.hibernate.annotations.Target;

@Documented
@Constraint(validatedBy = EmailValidators.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EmployeeEmail {
	
    String message() default "Invalid card number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 }
	


package com.hostbook.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class EmailValidators implements ConstraintValidator<EmployeeEmail, String> {

	private static final String CREDIT_CARD_REGEX  = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile(CREDIT_CARD_REGEX);

	@Override
	public void initialize(EmployeeEmail constraintAnnotation) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		Matcher matcher = CREDIT_CARD_PATTERN.matcher(email);

		return matcher.matches();

	}
}
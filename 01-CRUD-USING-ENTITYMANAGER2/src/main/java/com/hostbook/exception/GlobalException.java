package com.hostbook.exception;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hostbook.dto.EmployeeDTO;
import com.hostbook.response.ErrorResponse;
import com.hostbook.response.Response;

@RestControllerAdvice
public class GlobalException implements ConstraintValidator<FieldValidator, EmployeeDTO> {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(final DataNotFoundException e, final WebRequest request) {
		ErrorResponse response=new ErrorResponse(new Date(),HttpStatus.BAD_REQUEST,e.getMessage());
				
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

	@Override
	public boolean isValid(EmployeeDTO value, ConstraintValidatorContext context) {

		if (value.getEmployeeName().isEmpty()) {
			throw new FieldValidationException("Name should not be empty");
		}
		if (!value.getEmployeeName().matches("[a-zA-Z]*")) {

			throw new FieldValidationException("please provide valid name format");
		}

		if (!value.getEmployeeEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

			throw new FieldValidationException("please provide valid Email id::");

		}
		
		if(value.getEmployeeDepartment().isEmpty()) {
			throw new FieldValidationException("Department Field should not be empty");
		}

		if (value.getEmployeeAddress().isEmpty()) {
			throw new FieldValidationException("Address should not be empty");
		}

		if (value.getEmployeeSalary().isEmpty()) {
			throw new FieldValidationException("salary should not be empty");

		}

		return true;
	}

	@ExceptionHandler(FieldValidationException.class)

	ResponseEntity<ErrorResponse> handleValidation(FieldValidationException ex) {

		ErrorResponse response=new ErrorResponse(new Date(),HttpStatus.BAD_REQUEST,ex.getMessage());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

}

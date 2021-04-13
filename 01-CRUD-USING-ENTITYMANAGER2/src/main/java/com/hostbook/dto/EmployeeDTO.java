package com.hostbook.dto;

import com.hostbook.exception.FieldValidator;

import lombok.Data;

@Data
@FieldValidator
public class EmployeeDTO {

	private String employeeName;

	private String employeeEmail;

	private String employeeAddress;

	private String employeeSalary;
	
	private String employeeDepartment;

}

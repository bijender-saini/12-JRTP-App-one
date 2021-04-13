package com.hostbook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee  {

	@Id
	//use for custom generator to define our own format
	
	//@GeneratedValue(strategy = GenerationType.)
	//@GeneratedValue(generator = "abcd")
	//@GenericGenerator(name = "abcd", strategy = "com.hostbook.generator.EmployeeIdGenerator")
	@GeneratedValue
	private String employeeId;

	private String employeeName;

	private String employeeEmail;

	private String employeeAddress;
	private Double employeeSalary;
	private String employeeDepartment;
	

}

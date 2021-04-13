package com.hostbook.controller;

import static com.hostbook.constant.UrlConstant.EMPLOYEE;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hostbook.domain.Employee;
import com.hostbook.dto.EmployeeDTO;
import com.hostbook.response.Response;
import com.hostbook.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	ResponseEntity<Response> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)

	{
		Employee saveEmployee = employeeService.saveEmployee(employeeDTO);
		
		
		Response respone=new Response(new Date(), HttpStatus.CREATED, "Employee saved Successfully", saveEmployee);
     return new ResponseEntity<>(respone,HttpStatus.CREATED);

	}

	@PutMapping("update/{id}")
	ResponseEntity<Response> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable("id") String id) {
		
		Employee updateEmployee = employeeService.updateEmployee(employeeDTO, id);
		
		Response respone=new Response(new Date(), HttpStatus.CREATED, "Employee update Successfully", updateEmployee);
     return new ResponseEntity<>(respone,HttpStatus.CREATED);
	}

	@GetMapping("employee/{id}")
	ResponseEntity<Response> getEmployee(@PathVariable("id") String id) {

		Employee employeeById = employeeService.getEmployeeById(id);
			Response respone=new Response(new Date(), HttpStatus.CREATED, "success", employeeById);
	     return new ResponseEntity<>(respone,HttpStatus.CREATED);

	}

	@GetMapping(EMPLOYEE)
	ResponseEntity<Response> getAllEmployee() {

		 List<Object> allEmployee = employeeService.getAllEmployee();
			Response respone=new Response(new Date(), HttpStatus.CREATED, "true", allEmployee);
		     return new ResponseEntity<>(respone,HttpStatus.OK);

	}

	@DeleteMapping("delete/{id}")
	ResponseEntity<Response> deleteEmployee(@PathVariable("id") String id) {

		
		Employee deleteEmployee = employeeService.deleteEmployee(id);
		Response respone=new Response(new Date(), HttpStatus.CREATED, "Employee update Successfully", deleteEmployee);
	     return new ResponseEntity<>(respone,HttpStatus.OK);
		
	}
	
	
	@GetMapping("employeeDepartment/{branch}")
	ResponseEntity<Response> getEmployeeByDepartment(@PathVariable ("branch") String branch)
	{
		
		List<Employee> employeeByDepartment = employeeService.getEmployeeByDepartment(branch);
		Response respone=new Response(new Date(), HttpStatus.OK, "success", employeeByDepartment);
	     return new ResponseEntity<>(respone,HttpStatus.CREATED);
	}

}

package com.hostbook.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbook.dao.EmployeeDao;
import com.hostbook.domain.Employee;
import com.hostbook.dto.EmployeeDTO;
import com.hostbook.exception.DataNotFoundException;

@Service

public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	

//@Transactional
	public Employee saveEmployee(EmployeeDTO employeeDTO) {

	    
		Employee employee = new Employee();
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
		employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
		employee.setEmployeeSalary(Double.parseDouble(employeeDTO.getEmployeeSalary()));
		employee.setEmployeeDepartment(employeeDTO.getEmployeeDepartment());
		
		
		return employeeDao.saveEmployee(employee);

	}

	//@Transactional
	public Employee updateEmployee(EmployeeDTO employeeDTO, String id) {

		Employee employee = employeeDao.getEmployee(id);

		if (employee == null) {
			throw new DataNotFoundException("Data not found with given Id");
		}

		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
		employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
		employee.setEmployeeSalary(Double.parseDouble(employeeDTO.getEmployeeSalary()));
		employee.setEmployeeDepartment(employeeDTO.getEmployeeDepartment());
		return employeeDao.updateEmployee(id, employee);
	}

	//@Transactional
	public Employee deleteEmployee(String id) {

		Employee employee = employeeDao.getEmployee(id);
		if (employee == null) {
			throw new DataNotFoundException("Data not found with given Id");
		}
		return employeeDao.deleteEmployee(id);

	}

	public List<Object> getAllEmployee() {

		List<Object> allEmployee = employeeDao.getAllEmployee();
		if (allEmployee.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}

		return allEmployee;
	}

	public Employee getEmployeeById(String id) {

		Employee employee = employeeDao.getEmployee(id);
		if (employee == null) {
			throw new DataNotFoundException("Data not found with given Id");
		}

		return employee;

	}

	public List<Employee> getEmployeeByDepartment(String branch) {
		
		List<Employee> employee = null;
		employee = employeeDao.getEmployeeByBranchName(branch);
		if (employee .isEmpty()) {
			throw new DataNotFoundException("Data not found with given branch");
		}

		return employee;

	}
}

package com.codemind.whirlpool.employee_management.service;

import java.util.List;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;

public interface EmployeeService {

	// Save Employee details
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	// List all the Employee details
	List<EmployeeDto> getAllEmployees();

	// Get the employee information
	EmployeeDto getEmployeeById(Long id);

	// Update the employee information
	EmployeeDto updateEmployeeById(Long id, EmployeeDto dto);

	// Soft-Delete the Employee Data
	void deleteEmployeeById(Long id);
}

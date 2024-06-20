package com.codemind.whirlpool.employee_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
	public EmployeeDto saveEmployeeData(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto response = employeeService.saveEmployee(employeeDto);
		return response;
	}

	@GetMapping("/{req-id}")
	public EmployeeDto fetchEmployeeById(@PathVariable(name = "req-id") Long id) {
		EmployeeDto response = employeeService.getEmployeeById(id);
		return response;
	}

	@GetMapping("/all")
	public List<EmployeeDto> fetchAllEmployee() {
		List<EmployeeDto> response = employeeService.getAllEmployees();
		return response;
	}

	@DeleteMapping("/{req-id}")
	public String deleteEmployeeData(@PathVariable(name = "req-id") Long id) {
		try {
			employeeService.deleteEmployeeById(id);
			return "Data Deleted for id : " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return "Data not Deleted for id : " + id;
		}
	}

}

package com.codemind.whirlpool.employee_management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> saveEmployeeData(@RequestBody EmployeeDto employeeDto) {
		log.info("START:EmployeeController--->saveEmployeeData");
		log.debug("New Request recied for employee : {}", employeeDto.getName());
		EmployeeDto response = employeeService.saveEmployee(employeeDto);
		log.info("END:EmployeeController--->saveEmployeeData");
		return new ResponseEntity<EmployeeDto>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{req-id}")
	public ResponseEntity<EmployeeDto> fetchEmployeeById(@PathVariable(name = "req-id") Long id) {
		EmployeeDto response = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeDto>(response, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> fetchAllEmployee() {
		List<EmployeeDto> response = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(response, HttpStatus.OK);
	}

	@PutMapping("/{req-id}")
	public ResponseEntity<EmployeeDto> updateEmployeeData(@PathVariable(name = "req-id") Long id,
			@RequestBody EmployeeDto dto) {
		EmployeeDto response = employeeService.updateEmployeeById(id, dto);
		return new ResponseEntity<EmployeeDto>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/{req-id}")
	public ResponseEntity<String> deleteEmployeeData(@PathVariable(name = "req-id") Long id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Data Deleted for id : " + id, HttpStatus.OK);
	}

}

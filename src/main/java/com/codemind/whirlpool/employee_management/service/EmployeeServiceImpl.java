package com.codemind.whirlpool.employee_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.enums.Department;
import com.codemind.whirlpool.employee_management.enums.Gender;
import com.codemind.whirlpool.employee_management.enums.Status;
import com.codemind.whirlpool.employee_management.model.Employee;
import com.codemind.whirlpool.employee_management.repository.EmployeeRepository;
import com.codemind.whirlpool.employee_management.util.EmployeeConverter;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	private EmployeeRepository employeeRepository;

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeConverter.getEmployeeEntity(employeeDto);
		Employee savedEmp = employeeRepository.save(employee);
		EmployeeDto response = EmployeeConverter.getEmployeeDto(savedEmp);

		return response;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (Employee emp : employees) {
			if ("ACTIVE".equalsIgnoreCase(emp.getIsActive().toString())) {
				EmployeeDto employeeDto = EmployeeConverter.getEmployeeDto(emp);
				employeeDtos.add(employeeDto);
			}

		}

		return employeeDtos;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			Employee employee = employeeData.get();
			EmployeeDto employeeDto = EmployeeConverter.getEmployeeDto(employee);
			return employeeDto;
		}
		return null;
	}

	@Override
	public EmployeeDto updateEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// employeeRepository.deleteById(id); ---> Hard Delete ---> Data is inconsistent
		// in DB.

		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			Employee employee = employeeData.get();
			employee.setIsActive(Status.IN_ACTIVE);
			employeeRepository.save(employee);
		} else {
			throw new RuntimeException("Employee with given Id Does not exists");
		}
	}

}

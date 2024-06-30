package com.codemind.whirlpool.employee_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.enums.Department;
import com.codemind.whirlpool.employee_management.enums.ErrorCode;
import com.codemind.whirlpool.employee_management.enums.Gender;
import com.codemind.whirlpool.employee_management.enums.Status;
import com.codemind.whirlpool.employee_management.exception.DataNotFoundException;
import com.codemind.whirlpool.employee_management.exception.ResourceNotFoundException;
import com.codemind.whirlpool.employee_management.model.Employee;
import com.codemind.whirlpool.employee_management.repository.EmployeeRepository;
import com.codemind.whirlpool.employee_management.util.EmployeeConverter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		log.info("START:EmployeeServiceImpl --->saveEmployee");
		log.debug("Converting the dto to entity");
		Employee employee = EmployeeConverter.getEmployeeEntity(employeeDto);
		Employee savedEmp = employeeRepository.save(employee);
		log.debug("Converting the entity to dto ");
		EmployeeDto response = EmployeeConverter.getEmployeeDto(savedEmp);
		log.info("END:EmployeeServiceImpl --->saveEmployee");
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
		} else {
			throw new DataNotFoundException(ErrorCode.DATA_NOT_FOUND.getCode(), ErrorCode.DATA_NOT_FOUND.getValue());
		}
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

	@Override
	public EmployeeDto updateEmployeeById(Long id, EmployeeDto dto) {
		// Step 1: Check if this Data already Exists
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			Employee existingEmployeeData = employeeData.get();
			Employee newEmployeeData = EmployeeConverter.getEmployeeEntity(dto);
			BeanUtils.copyProperties(newEmployeeData, existingEmployeeData);
			existingEmployeeData.setEmpId(id);
			Employee updatedEmpData = employeeRepository.save(existingEmployeeData);
			return EmployeeConverter.getEmployeeDto(updatedEmpData);
		} else {
			Employee newEmployeeData = EmployeeConverter.getEmployeeEntity(dto);
			Employee savedEmpData = employeeRepository.save(newEmployeeData);
			return EmployeeConverter.getEmployeeDto(savedEmpData);
		}
	}

}

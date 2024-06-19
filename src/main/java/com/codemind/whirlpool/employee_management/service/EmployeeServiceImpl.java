package com.codemind.whirlpool.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.enums.Department;
import com.codemind.whirlpool.employee_management.enums.Gender;
import com.codemind.whirlpool.employee_management.enums.Status;
import com.codemind.whirlpool.employee_management.model.Employee;
import com.codemind.whirlpool.employee_management.repository.EmployeeRepository;

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

		Employee employee = new Employee();
		String[] names = extractNames(employeeDto);
		employee.setFirstName(names[0]);
		employee.setMiddleName(names[1]);
		employee.setLastName(names[2]);
		employee.setDob(employeeDto.getDob());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(Department.valueOf(employeeDto.getDepartment()));
		employee.setFaculty(employeeDto.getFaculty());
		employee.setGender(Gender.valueOf(employeeDto.getGender()));
		employee.setJoinDate(employeeDto.getJoinDate());
		employee.setUserName(employeeDto.getUserName());
		employee.setPhoneNumber(employeeDto.getPhoneNumber());
		employee.setIsActive(Status.ACTIVE);

		Employee savedEmp = employeeRepository.save(employee);

		EmployeeDto response = new EmployeeDto();
		response.setId(savedEmp.getEmpId());
		String firstName = savedEmp.getFirstName();
		String middleName = savedEmp.getMiddleName();
		String lastName = savedEmp.getLastName();
		String fullName = firstName.concat(middleName).concat(lastName);
		response.setName(fullName);
		response.setDob(savedEmp.getDob());
		response.setEmail(savedEmp.getEmail());
		response.setDepartment(savedEmp.getDepartment().name());
		response.setFaculty(savedEmp.getFaculty());
		response.setGender(savedEmp.getGender().name());
		response.setJoinDate(savedEmp.getJoinDate());
		response.setPhoneNumber(savedEmp.getPhoneNumber());
		response.setUserName(savedEmp.getUserName());
		return response;
	}

	private String[] extractNames(EmployeeDto employeeDto) {
		String fullName = employeeDto.getName();
		String[] names = fullName.split(" ");
		return names;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto updateEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub

	}

}

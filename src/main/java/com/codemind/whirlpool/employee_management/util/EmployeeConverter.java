package com.codemind.whirlpool.employee_management.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.codemind.whirlpool.employee_management.dto.EmployeeDto;
import com.codemind.whirlpool.employee_management.dto.ParsedName;
import com.codemind.whirlpool.employee_management.enums.Department;
import com.codemind.whirlpool.employee_management.enums.Gender;
import com.codemind.whirlpool.employee_management.enums.Status;
import com.codemind.whirlpool.employee_management.model.Employee;

public class EmployeeConverter {

	public static Employee getEmployeeEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		ParsedName names = extractNames(employeeDto);
		employee.setFirstName(names.getFirstName());
		employee.setMiddleName(names.getMiddleName());
		employee.setLastName(names.getLastName());
		employee.setDob(employeeDto.getDob());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(Department.valueOf(employeeDto.getDepartment()));
		employee.setFaculty(employeeDto.getFaculty());
		employee.setGender(Gender.valueOf(employeeDto.getGender()));
		employee.setJoinDate(employeeDto.getJoinDate());
		employee.setUserName(employeeDto.getUserName());
		employee.setPhoneNumber(employeeDto.getPhoneNumber());
		employee.setIsActive(Status.ACTIVE);
		return employee;
	}

	public static EmployeeDto getEmployeeDto(Employee savedEmp) {
		EmployeeDto response = new EmployeeDto();
		response.setId(savedEmp.getEmpId());
		String fullName = getFullName(savedEmp);
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

	private static String getFullName(Employee savedEmp) {
		String firstName = savedEmp.getFirstName();
		String middleName = savedEmp.getMiddleName();
		String lastName = savedEmp.getLastName();
		String fullName = Stream.of(firstName, middleName, lastName).filter(part -> part != null && !part.isEmpty())
				.collect(Collectors.joining(" "));
		return fullName;
	}

	public static ParsedName extractNames(EmployeeDto employeeDto) {
		if (employeeDto.getName() == null || employeeDto.getName().trim().isEmpty()) {
			return new ParsedName("", "", "");
		}

		String[] nameParts = employeeDto.getName().trim().split("\\s+");
		String firstName = "";
		String middleName = "";
		String lastName = "";

		if (nameParts.length == 1) {
			firstName = nameParts[0];
		} else if (nameParts.length == 2) {
			firstName = nameParts[0];
			lastName = nameParts[1];
		} else if (nameParts.length >= 3) {
			firstName = nameParts[0];
			lastName = nameParts[nameParts.length - 1];
			middleName = String.join(" ", Arrays.copyOfRange(nameParts, 1, nameParts.length - 1));
		}

		return new ParsedName(firstName, middleName, lastName);
	}

}

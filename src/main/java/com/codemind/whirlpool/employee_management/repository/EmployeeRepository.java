package com.codemind.whirlpool.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemind.whirlpool.employee_management.model.Employee;

@Repository //Optional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

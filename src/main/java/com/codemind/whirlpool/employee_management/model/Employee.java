package com.codemind.whirlpool.employee_management.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.codemind.whirlpool.employee_management.enums.Department;
import com.codemind.whirlpool.employee_management.enums.Gender;
import com.codemind.whirlpool.employee_management.enums.Status;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "faculty")
	private String faculty;
	
	@Column(name = "department")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name = "join_date")
	private LocalDate joinDate;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_num")
	private String phoneNumber;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "is_active")
	@Enumerated(EnumType.STRING)
	private Status isActive;

	public Employee() {
	}

	public Employee(Long empId, String firstName, String middleName, String lastName, LocalDate dob, Gender gender,
			String faculty, Department department, LocalDate joinDate, String email, String phoneNumber,
			String userName, Status isActive) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.faculty = faculty;
		this.department = department;
		this.joinDate = joinDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.isActive = isActive;
	}

	public Status getIsActive() {
		return isActive;
	}

	public void setIsActive(Status isActive) {
		this.isActive = isActive;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dob=" + dob + ", gender=" + gender + ", faculty=" + faculty + ", department="
				+ department + ", joinDate=" + joinDate + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", userName=" + userName + "]";
	}
}

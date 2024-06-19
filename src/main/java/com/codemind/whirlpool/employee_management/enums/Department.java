package com.codemind.whirlpool.employee_management.enums;

public enum Department {
	COMPUTER_SCIENCE("Computer Science"), BIOLOGY("Biology"), CHEMISYRY("Chemistry"), PHYSICS("Physics"),
	MATHS("Maths");

	private String value;

	Department(String value) {
		this.value = value;
	}

}

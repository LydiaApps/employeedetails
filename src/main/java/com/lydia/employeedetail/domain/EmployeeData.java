package com.lydia.employeedetail.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeData {
	@JsonProperty("employeeData")
	private List<EmployeeDetails> employeeData;

	public List<EmployeeDetails> getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(List<EmployeeDetails> employeeData) {
		this.employeeData = employeeData;
	}
	

}

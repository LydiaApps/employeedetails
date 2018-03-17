package com.lydia.employeedetail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees {
	@JsonProperty("name")
	private String Name;
	@JsonProperty("id")
	private String Id;
	@JsonProperty("designation")
	private String Designation;
	@JsonProperty("salary")
	private String Salary;
	public String getName() {
		return Name;
	}
	private String Hiredate;

	public void setName(String name) {
		Name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	

	
	public String getHiredate() {
		return Hiredate;
	}

	public void setHiredate(String hiredate) {
		Hiredate = hiredate;
	}

}

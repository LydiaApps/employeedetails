package com.lydia.employeedetail.domain;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeInfo {
	@JsonProperty("id")
	@Id
	String id;
	@JsonProperty("name")
	String name;
	@JsonProperty("hiredate")
	String hiredate;
	@JsonProperty("salary")
	String salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}

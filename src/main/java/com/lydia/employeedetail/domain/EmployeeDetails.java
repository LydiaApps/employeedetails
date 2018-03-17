package com.lydia.employeedetail.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
@Document(collection = "employee")
public class EmployeeDetails {
@JsonProperty("id")
@Id
String id;
@JsonProperty("name")
String name;
@JsonProperty("hiredate")
String hiredate;
@JsonProperty("salary")
String salary;
@JsonProperty("emailid")
String emailid;
@JsonProperty("designation")
String designation;
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
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}

public EmployeeDetails(String id, String name, String hiredate, String salary, String emailid, String designation) {
	super();
	this.id = id;
	this.name = name;
	this.hiredate = hiredate;
	this.salary = salary;
	this.emailid = emailid;
	this.designation = designation;
}
public EmployeeDetails() {
	
}
@Override
public String toString() {
	return "EmployeeDetails [id=" + id + ", name=" + name + ", hiredate=" + hiredate + ", salary=" + salary
			+ ", emailid=" + emailid + ", designation=" + designation + "]";
}

}

package com.lydia.employeedetail.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lydia.employeedetail.domain.EmployeeDetails;
import com.lydia.employeedetail.domain.EmployeeInfo;
import com.lydia.employeedetail.mongo.MongoService;

@RestController
public class EmployeeDetailsController {
	@Autowired
	private MongoService mongoService;
	@RequestMapping("/employeedetail")
	public EmployeeDetails getEmployeeDetail(@RequestParam(value="id", defaultValue="none") String id) throws Exception {
		return mongoService.getDetails(id);
		
		
	}
	@RequestMapping("/employeeinfo")
	public List<EmployeeInfo> getEmployeeInfo() throws Exception {
		return mongoService.getInfo();
		
		
	}
	
}

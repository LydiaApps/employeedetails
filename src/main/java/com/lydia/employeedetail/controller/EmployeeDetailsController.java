package com.lydia.employeedetail.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lydia.employeedetail.domain.EmployeeDetails;
import com.lydia.employeedetail.domain.EmployeeInfo;
import com.lydia.employeedetail.domain.Employees;
import com.lydia.employeedetail.mongo.MongoService;

@RestController
public class EmployeeDetailsController {
	/*@RequestMapping(method=RequestMethod.GET, value="/employeeinfo")*/
	@Autowired
	private MongoService mongoService;
	@RequestMapping("/employeedetail")
	public List<EmployeeDetails> employeeDetail(@RequestParam(value="name", defaultValue="World") String name) throws Exception {
		return mongoService.getDetails();
		
		
	}
	@RequestMapping("/employeeinfo")
	public List<EmployeeInfo> employeeInfo(@RequestParam(value="name", defaultValue="World") String name) throws Exception {
		return mongoService.getInfo();
		
		
	}
	
}

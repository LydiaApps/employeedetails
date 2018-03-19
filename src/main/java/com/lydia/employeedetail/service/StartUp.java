package com.lydia.employeedetail.service;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.lydia.employeedetail.domain.EmployeeData;
import com.lydia.employeedetail.mongo.MongoService;
import com.lydia.employeedetail.util.Utility;

@Service
public class StartUp implements  ApplicationRunner {
	@Autowired
	MongoService mongoService;
	private static final Logger LOGGER= LoggerFactory.getLogger(StartUp.class);
	@Value("${app.mongo.source.data}")
	private String dataFilePath;
	@Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
		String jsonData;
		try {
			jsonData = Utility.readFile(dataFilePath,StandardCharsets.UTF_8);
			EmployeeData employeeData = new Gson().fromJson(jsonData,EmployeeData.class);
			mongoService.bulkInsert(employeeData.getEmployeeData(), "employeeDetails");
			LOGGER.info("Data Refreshed in mongo DB");
		} catch (Exception e) {
			LOGGER.error("Mongo DB Insert Failed:"+e.getMessage());
		}

    }
	   

}

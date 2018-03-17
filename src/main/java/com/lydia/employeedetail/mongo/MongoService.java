package com.lydia.employeedetail.mongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lydia.employeedetail.domain.EmployeeDetails;
import com.lydia.employeedetail.domain.EmployeeInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoService {
	
@Autowired 
MongoConfiguration mongoConfiguration;
	
/*
 * Function to bulk load data into mongo db
 * @param List of Employee details
 * @param collectionName
 * @return StatusCode
 * @throws exception
 * 
 */
private final MongoDbFactory mongo;

@Autowired
public MongoService(MongoDbFactory mongo) {
	this.mongo = mongo;
}
public Boolean bulkInsert(List<EmployeeDetails> emList, String collectionName) throws Exception {
	MongoDatabase db = this.mongo.getDb("test");
	try {
		MongoCollection<Document> col = db.getCollection("employee");
		ObjectMapper oMapper = new ObjectMapper();
		List<Document> liDocuments = new ArrayList<>();
		emList.forEach(em->{
			liDocuments.add(new Document(oMapper.convertValue(em, HashMap.class)));
			});
		/*for(EmployeeDetails emp : emList) {
			Map<String, Object> map = oMapper.convertValue(emp, Map.class);
			Document document = new Document(map);
			liDocuments.add(document);
		}*/
		col.insertMany(liDocuments);
	} catch (Exception e) {
		throw e;
	}
	return true;		
}
public Boolean insertData(EmployeeDetails emList, String collectionName) throws Exception {
	List<DBObject> array = new ArrayList<DBObject>();
	MongoDatabase db = this.mongo.getDb("test");
	try {
		MongoCollection<Document> col = db.getCollection("employee");
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> map = oMapper.convertValue(emList, Map.class);
		
		Document document = new Document(map);
		col.insertOne(document);
	} catch (Exception e) {
		throw e;
	}
	return true;		
}
public List<EmployeeDetails> getDetails(){
	MongoDatabase db = this.mongo.getDb("test");
	MongoCollection<Document> col = db.getCollection("employee");
	List<EmployeeDetails> liEmployeeDetails = new ArrayList<>();
	List<Document> liDocuments =  col.find().into(new ArrayList<Document>());
	liDocuments.forEach(document->{
		liEmployeeDetails.add( new Gson().fromJson(document.toJson(), EmployeeDetails.class));
		});
	return liEmployeeDetails;
	
}
public List<EmployeeInfo> getInfo(){
	MongoDatabase db = this.mongo.getDb("test");
	MongoCollection<Document> col = db.getCollection("employee");
	List<EmployeeInfo> liEmployeeDetails = new ArrayList<>();
	List<Document> liDocuments =  col.find().into(new ArrayList<Document>());
	liDocuments.forEach(document->{
		liEmployeeDetails.add( new Gson().fromJson(document.toJson(), EmployeeInfo.class));
		});
	return liEmployeeDetails;
	
}
}

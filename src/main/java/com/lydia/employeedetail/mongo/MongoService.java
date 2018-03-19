package com.lydia.employeedetail.mongo;

import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lydia.employeedetail.domain.EmployeeDetails;
import com.lydia.employeedetail.domain.EmployeeInfo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoService {

@Value("${app.db.name}")
private String dbName;
@Value("${app.emp.collection.name}")
private String collectionsName;
private final MongoDbFactory mongo;


@Autowired
public MongoService(MongoDbFactory mongo) {
	this.mongo = mongo;
}
/*
 * Function to bulk load data into mongo db
 * @param List of Employee details
 * @param collectionName
 * @return StatusCode
 * @throws exception
 * 
 */
public Boolean bulkInsert(List<EmployeeDetails> emList, String collectionName) throws Exception {
	MongoDatabase db = this.mongo.getDb(dbName);
	try {
		MongoCollection<Document> col = db.getCollection(collectionsName);
		ObjectMapper oMapper = new ObjectMapper();
		List<Document> liDocuments = new ArrayList<>();
		emList.forEach(em->{
			liDocuments.add(new Document(oMapper.convertValue(em, Map.class)));
			});
		col.insertMany(liDocuments);
	} catch (Exception e) {
		throw e;
	}
	return true;		
}
/*
 * Function to insert data into mongo db
 * @param List of Employee details
 * @param collectionName
 * @return StatusCode
 * @throws exception
 * 
 */
public Boolean insertData(EmployeeDetails emList, String collectionName) throws Exception {
	MongoDatabase db = this.mongo.getDb(dbName);
	try {
		MongoCollection<Document> col = db.getCollection(collectionsName);
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> map = oMapper.convertValue(emList, Map.class);	
		Document document = new Document(map);
		col.insertOne(document);
	} catch (Exception e) {
		throw e;
	}
	return true;		
}
/*
 * Function to get emplyee detail from mongo
 * @param emmName
  * @return StatusCode
 * @throws IllegalStateException
 * 
 */
public EmployeeDetails getDetails(String id){
	MongoDatabase db = this.mongo.getDb(dbName);
	MongoCollection<Document> col = db.getCollection(collectionsName);
	Bson query = eq("id",id);
	Document document = col.find(query).first();
	if(document==null) {
		throw new IllegalStateException("No Data Found Exception");
	}
	return new Gson().fromJson(document.toJson(), EmployeeDetails.class);
	
}
/*
 * Function to get employee info from mongo
  * @return StatusCode
 * @throws IllegalStateException
 * 
 */
public List<EmployeeInfo> getInfo(){
	MongoDatabase db = this.mongo.getDb(dbName);
	MongoCollection<Document> col = db.getCollection(collectionsName);
	List<EmployeeInfo> liEmployeeDetails = new ArrayList<>();
	List<Document> liDocuments =  col.find().into(new ArrayList<Document>());
	liDocuments.forEach(document->{
		liEmployeeDetails.add( new Gson().fromJson(document.toJson(), EmployeeInfo.class));
		});
	return liEmployeeDetails;
	
}
}

package com.lydia.employeedetail.mongo;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.*;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;

@Configuration
public class MongoConfiguration {
	private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "employeedb";
    MongodForTestsFactory factory = null;
    @Bean
    public DB mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        mongo.setPort(27018);
        //MongoClient mongoClient = mongo.getObject();
        factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
        MongoClient mongoClient = factory.newMongo();
        DB db = mongoClient.getDB(MONGO_DB_NAME);
       /* MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);*/
        return db;
    }
}
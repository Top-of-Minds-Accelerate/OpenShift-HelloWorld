package com.example.demo;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoDbConsumer {

	
	public String pingMongo() {
        
		// Connection string
        String uri = "mongodb://root:example@172.30.183.172:27017/sampledb?maxPoolSize=20&w=majority&authSource=sampledb";
        String err = "";	
        
        // Access...
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("admin");
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");
                return "SUCCESS";	
            } 
            catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
                err = me.getLocalizedMessage();
            }
        }
        return "shit................Details:" + err;	
	}
	
	
	
}

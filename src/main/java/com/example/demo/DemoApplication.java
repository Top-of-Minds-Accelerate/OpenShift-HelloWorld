package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
    	System.out.println("GOT A HIT - HOME");
    	return "Hello World BOS COMING UP";
    }

    @RequestMapping(
        value = "/hello2", 
        method = RequestMethod.GET, 
        produces="application/json"
    ) 
    @ResponseBody
    public String hello2() {
    	System.out.println("GOT A HIT - HELLO2");
    	return "{\"testar\": \"Hello Micke using JSON\"}";
    }
    
    @RequestMapping("/hello")
    String hello() {
    	System.out.println("GOT A HIT - HELLO");
    	return "{\"testar\": \"Hello Micke using JSON\"}";
    }

    @RequestMapping(value = "/xrates", method = RequestMethod.GET, produces="application/json") 
    String xrates() {
    	
    	// Log
    	System.out.println("Request for X-RATES received ");

    	ExchangeRateConsumer Consumer = new ExchangeRateConsumer();
    	String jsonData = Consumer.getDataFromExternalSource();
    	
    	return jsonData;
    } 
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

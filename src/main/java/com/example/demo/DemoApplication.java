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


    /**
    * The ROOT of the API. Just return a hello
    * @return A nice text
    */
    @RequestMapping("/")
    String home() {
    	System.out.println("GOT A HIT - root");
    	return "Hello World - Welcome to OPEN SHIFT BOS";
    }

    @RequestMapping("/oskar")
    String home() {
    	System.out.println("TJA JAG ÄR OSKAR!!! ");
    	return "Hello World - TJA JAG ÄR OSKAR!!! ";
    }


    
    /**
    * Endpoint to return a JSON object
    * @return   A nice JSON object
    */
    @RequestMapping(
        value = "/hello",
        method = RequestMethod.GET,
        produces="application/json"
    )
    @ResponseBody
    public String hello() {
    	System.out.println("GOT A HIT - Hello2");
    	return "{\"testar\": \"Hello TEAM using JSON\"}";
    }

    /**
    * sample ENDPOINT hitting an external API to fetch exchange rates!
    * @return   A nice JSON object with XRATES
    */
    @RequestMapping(value = "/xrates", method = RequestMethod.GET, produces="application/json")
    String xrates() {

    	// Log to console
    	System.out.println("Request for X-RATES received ");

    	ExchangeRateConsumer Consumer = new ExchangeRateConsumer();
    	String jsonData = Consumer.getDataFromExternalSource();

    	return jsonData;
    }


    /**
    * Defaul MAIN to start the APP
    * @return   A nice JSON object with XRATES
    */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

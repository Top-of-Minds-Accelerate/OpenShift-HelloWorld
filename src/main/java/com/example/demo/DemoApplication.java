package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
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

        int fullLength = -1;
        int baseLength = -1;
        int degSteps = 10;

        RobotController robot = new RobotController();
        try {
            fullLength = robot.getDistance();
            System.out.println("First Distance:  " + fullLength);

            robot.setAngle(0);
            baseLength = robot.getDistance();
            int step = 0;
            int area, currentDist, lastDist = -1;

            lastDist = baseLength;
            while(baseLength <= fullLength) {
                step++;
                robot.setAngle(step * degSteps);
                currentDist = robot.getDistance();

                int currentArea = 0.5 * lastDist * currentDist * Math.sin((double)degSteps);
                area += currentArea;
                lastDist = currentDist;

                baseLength = fullLength + 1;
            }

            System.out.println("Area: " + area);



        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return;
    }

}

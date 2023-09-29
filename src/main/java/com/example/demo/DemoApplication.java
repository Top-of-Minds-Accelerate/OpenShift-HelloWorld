package com.example.demo;

import com.example.demo.api.AreaResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@SpringBootApplication
public class DemoApplication {


    @RequestMapping(value = "/measurearea", method = RequestMethod.POST, produces="application/json")
    AreaResponse measureArea() {

        APIProxy apiProxy = new APIProxy();

        apiProxy.resetCamera();

        int initialDistanceToWall = apiProxy.measure().distance();
        int distanceTravelled = 0;
        int distanceToWallDiff = 0;
        do {
            distanceTravelled += apiProxy.moveForward(50).distanceMoved();
            int distanceToWall = apiProxy.measure().distance();
            distanceToWallDiff = Math.abs(initialDistanceToWall - distanceToWall);
        } while(distanceToWallDiff < 20);

        //Mät rakt fram

        int remainingDistance = apiProxy.measure().distance();
        AreaModel areaModel = new AreaModel(initialDistanceToWall, distanceTravelled, distanceTravelled + remainingDistance);
        return new AreaResponse(areaModel.getArea());
    }
    
	
    @RequestMapping(value = "/reset", method = RequestMethod.GET, produces="application/json")
    String reset() {

    	// Log to console
    	System.out.println("Reset distance....");

    	APIProxy Consumer = new APIProxy();
    	String jsonData = Consumer.resetCamera();

    	return jsonData;
    }
	
	

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
    String oskar() {
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

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World HAAANK - uppdaterad i GITHUB";
    }

    @RequestMapping(
        value = "/hello2", 
        method = RequestMethod.GET, 
        produces="application/json"
    ) 
    @ResponseBody
    public String hello2() {
        return "{\"testar\": \"Hello Hank using JSON\"}";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

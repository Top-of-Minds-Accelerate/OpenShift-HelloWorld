package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;



public class RobotController {



    public int getDistance() throws JsonProcessingException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://robotics-api-robotics.apps-crc.testing/v2/robot/sensor/distance"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Logga kan ju vara kul...
        //System.out.println(response.body());
        ObjectMapper objectMapper = new ObjectMapper();
        Distance dist = objectMapper.readValue(response.body(), Distance.class);
        return dist.distance;
    }


    public void setSensor(String degrees) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://robotics-api-robotics.apps-crc.testing/v2/robot/sensor/angle"))
                .method("PUT", HttpRequest.BodyPublishers.noBody())
                .build();

        // Response konstruktor
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Logga kan ju vara kul...
        System.out.println(response.body());


    }

    public void setAngle(int degrees) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://robotics-api-robotics.apps-crc.testing/v2/robot/sensor/angle"))
                .queryParam( "degrees", degrees)
                .method("PUT", HttpRequest.BodyPublishers.noBody())
                .build();

        // Response konstruktor
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

package com.example.demo;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.demo.api.MeasureDistanceResponse;
import com.example.demo.api.MoveForwardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class APIProxy {

    String baseURI = "http://robot-api-v4-accelerate-lab-v2.apps-crc.testing/v2/robot/";

    ObjectMapper objectMapper = new ObjectMapper();

    public MoveForwardResponse moveForward(int mm) {
        String uriString = baseURI + "forward?distance=" + mm;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .method("PUT", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            return objectMapper.readValue(response.body(), MoveForwardResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("No response received");
    }


    // 90 rakt fram, 180 vänster...
    public String moveCamera(int degrees) {

        String uri = baseURI + "sensor/angle?degrees=" + degrees;

        // Skapa request till EXCHANGE RATE API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method("PUT", HttpRequest.BodyPublishers.noBody())
                .build();

        // Response konstruktor
        HttpResponse<String> response = null;

        // Kör!!
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Logga kan ju vara kul...
        System.out.println(response.body());

        return response.body();
    }


    public MeasureDistanceResponse measure() {

        String uri = baseURI + "sensor/distance";
        int sum = 0;
        int numOfMeasurements = 0;
        for (int i = 0; i < 3; i++) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            try {
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                sum += objectMapper.readValue(response.body(), MeasureDistanceResponse.class).distance();
                numOfMeasurements++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (numOfMeasurements == 0) {
            throw new IllegalStateException("Failed to measure");
        }
        int average = sum / numOfMeasurements;
        return new MeasureDistanceResponse(average);

    }
}
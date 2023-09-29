package com.example.demo;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonParser;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.io.IOException;
import java.io.InputStreamReader;

public class APIProxy {

	String baseURI = "http://robot-api-v4-accelerate-lab-v2.apps-crc.testing/v2/robot/";
	

	public String forward(int mm) {

		String uri = baseURI + "forward?distance=" + mm;

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
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Logga kan ju vara kul...
		System.out.println(response.body());				
		
		return response.body();
	}

	
	public String resetDistance() {

		String uri = baseURI + "sensor/angle?degrees=180";

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
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Logga kan ju vara kul...
		System.out.println(response.body());				
		
		return response.body();
	}
	
	

	public String measure() {

		String uri = baseURI + "sensor/distance";

		// Skapa request till EXCHANGE RATE API
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		// Response konstruktor
		HttpResponse<String> response = null;

		// Kör!!
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

		return response.body();
	}
	
	















}

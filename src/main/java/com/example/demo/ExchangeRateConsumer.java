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

public class ExchangeRateConsumer {

	
	public String getDataFromExternalSource() {


		// Skapa request till EXCHANGE RATE API
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.exchangerate.host/latest"))
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

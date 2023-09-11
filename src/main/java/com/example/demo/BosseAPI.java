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

public class BosseAPI {


	public String getDistanceFromBosse() {

		// http://192.168.110.169:5000/api/v2/sensor/distance
		// Skapa request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://192.168.110.169:5000/api/v2/sensor/distance"))
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

		System.out.println(response.body());

		return response.body();
	}

















}

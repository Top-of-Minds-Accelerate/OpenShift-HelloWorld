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

public class AreaModel {

	int _width = 0;
	int _heightMid = 0;
	int _heightTotal = 0;
	int _robotBase = 240;
	
	public void setWidth(int value)
	{
		_width = value;
	}
	public void setHeightMid(int value)
	{
		_heightMid = value;
	}
	public void SetHeightTotal(int value)
	{
		_heightTotal = value;
	}
	
	
	// get AREA in mm2 
	public int getArea() {

		int area = 0;
	
		int areaHalv = _width * _heightTotal - ((_heightTotal - _heightMid) / 2);
		area = areaHalv * 2;
		
		return area;
	}



	public static void main(String[] args) {
		
		AreaModel model = new AreaModel();
		
		model.setHeightMid(1200);
		model.SetHeightTotal(1600);
		model.setWidth(400);
		
		System.out.println(model.getArea());
		
		
	}













}

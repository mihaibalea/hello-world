package com.application.jsonApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.application.jsonApp.domain.Class;
import com.google.gson.Gson;

public class Mainapp {
	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader("text.txt"));

		// convert the json string to object
		Class jsonObject = gson.fromJson(br, Class.class);

		System.out.println(gson.toJsonTree(jsonObject));
		
	}
}

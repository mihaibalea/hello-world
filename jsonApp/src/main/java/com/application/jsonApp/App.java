//package com.application.jsonApp;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import com.application.jsonApp.domain.WebApp;
//import com.google.gson.Gson;
//
///**
// * Hello world!
// *
// */
//public class App {
//	
//	public static void main(String[] args) {
//
//		// // JSONParser parser= new JSONParser();
//		// // try{
//		// // Object obj =(JSONObject) parser.parse(new InputStreamReader(new
//		// // FileInputStream("user.txt")));
//		// // JSONObject jsonObj = (JSONObject)obj;
//		// // String name = (String) jsonObj.get("Name");
//		// // String author = (String) jsonObj.get("Author");
//		// // JSONArray companyList = (JSONArray) jsonObj.get("company List");
//		// // System.out.println("Name :"+name);
//		// // System.out.println("Author:"+author);
//		// // }
//		// // finally{
//		// // System.out.println("DOne!!!");
//		// // }
//		//
//		// WebApp webAppClass = new WebApp();
//		//
//		// JSONParser parser = new JSONParser();
//		// try {
//		//
//		// // Read the Json Object
//		//
//		// Object obj = (JSONObject) parser
//		// .parse(new InputStreamReader(new
//		// FileInputStream("C:/Users/balea/Desktop/JSON.txt")));
//		//
//		// JSONObject jsonObject = (JSONObject) obj;
//		//
//		// // JSONObject servletMapping = (JSONObject)
//		// // jsonObject.get("servlet-mapping");
//		//
//		// // System.out.println(servletMapping.get("cofaxCDS"));
//		//
//		// // Here i read the "servlet" from json
//		//
//		// JSONArray servlets = (JSONArray) jsonObject.get("servlet");
//		//
//		// JSONObject servlet = (JSONObject) servlets.get(0);
//		//
//		//
//		// String servletName = (String) servlet.get("servlet-name");
//		// String servletCl=(String) servlet.get("servlet-class");
//		//
//		//
//		//
//		// JSONObject initParam = (JSONObject) servlet.get("init-param");
//		//
//		// String templatePath = (String) initParam.get("templatePath");
//		// String templateOverridePath = (String)
//		// initParam.get("templateOverridePath");
//		// String useJSP = (String) initParam.get("useJSP");
//		// String dataLog = (String) initParam.get("dataLog");
//		//
//		// InitParam initParamClass = new InitParam();
//		//
//		// initParamClass.setTemplatePath(templatePath);
//		// initParamClass.setTemplateOverridePath(templateOverridePath);
//		// initParamClass.setUseJSP(useJSP);
//		// initParamClass.setDataLog(dataLog);
//		//
//		//
//		// Servlet servletClass = new Servlet(servletName, servletCl,
//		// initParamClass);
//		//
//		//
//		// System.out.println(servletClass.toString());
//		//
//		//
//		// } catch (ParseException e) {
//		// e.printStackTrace();
//		// } catch (FileNotFoundException e) {
//		// e.printStackTrace();
//		// } catch (IOException e) {
//		// // TODO: handle ex ception
//		// e.printStackTrace();
//		// } finally {
//		// System.out.println("DONE!!!");
//		// }
//
//		Gson gson = new Gson();
//
//		try {
//
//			BufferedReader br = new BufferedReader(new FileReader("C:/Users/balea/Desktop/JSON.txt"));
//
//			// convert the json string back to object
//
//			WebApp obj = gson.fromJson(br, WebApp.class);
//
//			System.out.println(obj.getServlet());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}

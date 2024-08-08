package com.api;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// addressID- 50664
public class Shoppers_Address_CRUD {

	@Test
	public void addAddress()
	{
		JSONObject json = new JSONObject();
		
		json.put("addressId", "713103");
		json.put("buildingInfo", "Maharaja");
		json.put("city", "Amritsar");
		json.put("country", "India");
		json.put("landmark", "near Kulcha shop");
		json.put("name", "RajatLal");
		json.put("phone", "9090909011");
		json.put("pincode", "3412");
		json.put("state", "Punjab");
		json.put("streetInfo", "GuruShaeb gali");
		json.put("type", "customer");
		
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
			.body(json.toJSONString())
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/address")
		.then()
			.log().all();
	}
	
	@Test
	public void getAddress()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
		.when()
			.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/address")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
	
	@Test
	public void updateAddress()
	{
		JSONObject json = new JSONObject();
		
		json.put("addressId", "713103");
		json.put("buildingInfo", "Maharaja");
		json.put("city", "Amritsar");
		json.put("country", "India");
		json.put("landmark", "near Naan shop");
		json.put("name", "RajatLal");
		json.put("phone", "9090909011");
		json.put("pincode", "432101");
		json.put("state", "Punjab");
		json.put("streetInfo", "GuruShaeb gali");
		json.put("type", "customer&bussines");
		
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
			.pathParam("addressId", 50664)
			.body(json.toJSONString())
		.when()
			.put("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/address/{addressId}")
		.then()
			.assertThat().statusCode(200).log().all();
	}
	
	
	
}

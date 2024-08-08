package com.api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


// productId=  5203
// shoppersId = 109708

public class Shoppers_Register {

	@Test
	public void registerShopper()
	{
		String reg ="{\r\n"
				+ "  \"city\": \"Burdwan\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"ccc@gmail.com\",\r\n"
				+ "  \"firstName\": \"Komri\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"Pawan\",\r\n"
				+ "  \"password\": \"1212\",\r\n"
				+ "  \"phone\": 8889990000,\r\n"
				+ "  \"state\": \"USA\"\r\n"
				+ "}";
		
		given()
			.contentType(ContentType.JSON)
			.queryParam("zoneId", "ALPHA")
			.body(reg)
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers")
		.then()
			.log().all();
	}

}

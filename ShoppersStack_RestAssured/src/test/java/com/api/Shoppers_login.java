package com.api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


// productId=  5203
// shoppersId = 109708

public class Shoppers_login {

	@Test
	public void login()
	{
		JSONObject json = new JSONObject();
		
		json.put("email", "ccc@gmail.com");
		json.put("password", "1212");
		json.put("role", "SHOPPER");
		
		given().body(json.toJSONString())
			.contentType(ContentType.JSON)
		.when()
			.post("https://www.shoppersstack.com/shopping/users/login")
		.then()
			.log().all();
	}

	
	@Test
	public void viewProducts()
	{
		given()
			.contentType(ContentType.JSON)
			.queryParam("zoneId", "zoneId")
		.when()
			.get("https://www.shoppersstack.com/shopping/products/alpha")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
	
	
}

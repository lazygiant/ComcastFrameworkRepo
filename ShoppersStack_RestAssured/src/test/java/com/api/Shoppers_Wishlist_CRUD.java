package com.api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// productId=  5203
// shoppersId = 109708

public class Shoppers_Wishlist_CRUD {

	@Test
	public void addProdToWishlist()
	{
		JSONObject json = new JSONObject();
		json.put("productId", 5447);
		json.put("quantity", 1);
		
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers/109708/wishlist")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

	@Test
	public void viewProdFromWishlist()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId",109708)
		.when()
			.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/wishlist")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
	
	@Test
	public void deleteProdFromWishlist()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId",109708)
			.pathParam("productId",5203)
		.when()
			.delete("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/wishlist/{productId}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}
	
	
	
	
	

	
}

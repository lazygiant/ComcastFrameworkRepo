package com.api;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

//orderId- 25307
public class Shoppers_Order {

	@Test
	public void placeOrderFromCart()
	{
		String json = "{\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"addressId\": 50664,\r\n"
				+ "    \"buildingInfo\": \"string\",\r\n"
				+ "    \"city\": \"string\",\r\n"
				+ "    \"country\": \"string\",\r\n"
				+ "    \"landmark\": \"string\",\r\n"
				+ "    \"name\": \"string\",\r\n"
				+ "    \"phone\": \"string\",\r\n"
				+ "    \"pincode\": \"string\",\r\n"
				+ "    \"state\": \"string\",\r\n"
				+ "    \"streetInfo\": \"string\",\r\n"
				+ "    \"type\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"paymentMode\": \"COD\"\r\n"
				+ "}";
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
			.body(json)
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/orders")
		.then()
			.log().all();
	}
	
	@Test
	public void updateOrderStatus()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
			.pathParam("orderId", 25307)
			.queryParam("status", "DELIVERED")
		.when()
			.patch("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/orders/{orderId}")
		.then()
			.log().all();
	}
	
	@Test
	public void getInvoice()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.pathParam("shopperId", 109708)
			.pathParam("orderId", 25307)
		.when()
			.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/orders/{orderId}/invoice")
		.then()
			.assertThat().statusCode(200).log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

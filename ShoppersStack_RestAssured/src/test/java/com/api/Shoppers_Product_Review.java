package com.api;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

// review id - 10595

public class Shoppers_Product_Review {

	@Test
	public void addReview()
	{
	   String json="{\r\n"
	   		+ "  \"dateTime\": \"2024-08-08T06:08:01.125Z\",\r\n"
	   		+ "  \"description\": \"It was so handy to use waooooo!!!😀\",\r\n"
	   		+ "  \"heading\": \"string\",\r\n"
	   		+ "  \"rating\": 0,\r\n"
	   		+ "  \"shopperId\": 109708,\r\n"
	   		+ "  \"shopperName\": \"MohanLal\"\r\n"
	   		+ "}";
	   given()
	   		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
	   	    .contentType(ContentType.JSON)
	   	    .queryParam("productId", 5447)
	   	    .body(json)
	   .when()
	   		.post("https://www.shoppersstack.com/shopping/reviews")
	   .then()
	   		.assertThat().statusCode(200)
	   		.log().all();
	}
	
	@Test
	public void getReview()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("productId", 5447)
		.when()
			.get("https://www.shoppersstack.com/shopping/reviews/{productId}")
		.then()
			.assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void updateReview()
	{
		String json="{\r\n"
		   		+ "  \"dateTime\": \"2024-08-08T06:08:01.125Z\",\r\n"
		   		+ "  \"description\": \"😀😀😀😀😀!!!yoyo iphone yeahhhh hulalala!!!😀😀😀😀😀😀😀\",\r\n"
		   		+ "  \"heading\": \"reviews\",\r\n"
		   		+ "  \"rating\": 3.4,\r\n"
		   		+ "  \"shopperId\": 109708,\r\n"
		   		+ "  \"shopperName\": \"MohanLal\"\r\n"
		   		+ "}";
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.queryParam("productId", 5447)
			.pathParam("reviewId", 10595)
			.body(json)
		.when()
			.put("https://www.shoppersstack.com/shopping/reviews/{reviewId}")
		.then()
		    .log().all();
	}
	
	@Test
	public void deleteReview()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("reviewId", 10595)
			.queryParam("productId", 5447)
		.when()
			.delete("https://www.shoppersstack.com/shopping/reviews/{reviewId}")
		.then()
		   .assertThat().statusCode(200).log().all();
	}
	
	
}

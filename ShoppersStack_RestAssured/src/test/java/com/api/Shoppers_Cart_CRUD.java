package com.api;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

// productId=  5203
// shoppersId = 109708
public class Shoppers_Cart_CRUD 
{

	@Test
	public void addProdToCart()
	{
		JSONObject json = new JSONObject();
		json.put("productId", 5447);
		json.put("quantity", 1);
		
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.post("https://www.shoppersstack.com/shopping/shoppers/109708/carts")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
	
	@Test
	public void viewProdFromCart()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId",109708)
		.when()
			.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
	
	@Test
	public void updateQtyOfProdToCart()
	{
		JSONObject json = new JSONObject();
		json.put("productId", 5447);
		json.put("quantity", 10);
		
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("shopperId", 109708)
			.pathParam("itemId", 189596)
			.body(json.toJSONString())
		.when()
			.put("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts/{itemId}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
	
	@Test
	public void deleteProdFromCart()
	{
		given()
			.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjY2NAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3MjMxMjcyNjAsImlhdCI6MTcyMzA5MTI2MH0.Pg2dM7DYUyAreO1VRT_KWO2HcnWcCxLFZbm76odjtos")
			.contentType(ContentType.JSON)
			.pathParam("productId", 5203)
			.pathParam("shopperId", 109708)
		.when()
			.delete("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts/{productId}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}

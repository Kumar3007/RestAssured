package Demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Basics {
	
	public static void main(String[] args) {
		
		//validate if Add place API is working as expected
		
		//given:- all the input details
		//when:-Perform Actions and submit the API-Resources,http method
		//then:-Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given()
			.queryParam("key", "qaclick123")
			.header("content-Type","application/json")
			.body("{\r\n" + 
					"  \"location\": {\r\n" + 
					"    \"lat\": -38.383494,\r\n" + 
					"    \"lng\": 33.427362\r\n" + 
					"  },\r\n" + 
					"  \"accuracy\": 50,\r\n" + 
					"  \"name\": \"Frontline housebd\",\r\n" + 
					"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
					"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
					"  \"types\": [\r\n" + 
					"    \"shoe park\",\r\n" + 
					"    \"shop\"\r\n" + 
					"  ],\r\n" + 
					"  \"website\": \"http://google.com\",\r\n" + 
					"  \"language\": \"French-IN\"\r\n" + 
					"}\r\n" + 
					"")
			
			.when()
				.post("maps/api/place/add/json")
				
				
			.then()
				.assertThat()
				.log().all()
				.statusCode(200)
				.body("scope", equalTo("APP"))// body level validation use equal to
				.header("Server", "Apache/2.4.41 (Ubuntu)");
				
				
		
		
		
	}
	
	
}

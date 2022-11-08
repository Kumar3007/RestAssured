package Demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.PayLoad;
public class Basics2 {
	
	public static void main(String[] args) {
		
		//validate if Add place API is working as expected
		
		//given:- all the input details
		//when:-Perform Actions and submit the API-Resources,http method
		//then:-Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given()
			.log().all()
			.queryParam("key", "qaclick123")
			.header("content-Type","application/json")
			.body(PayLoad.AddPlace())
			
			.when()
				.post("maps/api/place/add/json")
				
				
			.then()
				.assertThat()
				.log().all()
				.statusCode(200) //status code validation
				.body("scope", equalTo("APP"))// body level validation use equal to
				.header("Server", "Apache/2.4.41 (Ubuntu)");//header validation
				
		//Add place---> update place with New Address-->Get place to validate if new address is present in response
		
				
		
		
		
	}
	
	
}

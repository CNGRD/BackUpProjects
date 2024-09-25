package test_scenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * {
 * 	"name" : "John Doe" ,
 *  "age" :30 ,
 *  "address" : {
 *  				"street":"123 Main st",
 *  				"city":"New York",
 *  				"zipcode":"10001"
 *  			},
 *  "contacts":[ 
 *  				"123-456-7890",
 *  			    "987-654-3210"
 * 			   ],
 * "preferences":{
 * 					"newsletter":true,
 * 					"promotion":false
 * 				 }
 * }
 */

//request using hashmap
public class ComplexUsingHashmap
{
	public static void main(String[] args) 
	{
		Map<String, Object> requestBody=new HashMap<>();
		requestBody.put("name","John Doe");
		requestBody.put("age",30);
		
		//address object
		Map<String,String> addressMap=new HashMap<String, String>();
		addressMap.put("street", "123 Main st");
		addressMap.put("city", "New York");
		addressMap.put("zipcode", "10001");
		
		//add to requestBody
		requestBody.put("address", addressMap);
		
		//contacts object
		List<String> contacts=new ArrayList<String>();
		contacts.add("123-456-7890");
		contacts.add("987-654-3210");
		
		//add contacts to requestBidy
		requestBody.put("contacts", contacts);
		
		//nested object preferences
		Map<String,Boolean> preferences=new HashMap<String, Boolean>();
		preferences.put("newsletter", true);
		preferences.put("promotion", false);
		
		Response res= RestAssured
					 .given()
					 .contentType(ContentType.JSON)
					 .body(requestBody)
					 .when()
					 .post("/users/create")
					 .then().statusCode(201).extract().response();
		System.out.println("Response is "+res.asString());
		
	}
	

}

package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForPartialUpdateTest
{
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Bahubali");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize",0);
		jsonObj.put("projectName", "Guruda");		
		
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_6105")
		.then()
		.log().all();
		
	}

}

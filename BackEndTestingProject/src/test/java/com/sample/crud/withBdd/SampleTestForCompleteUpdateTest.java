package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForCompleteUpdateTest
{
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "NGR_009");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize",0);
		jsonObj.put("projectName", "Pavan Kalyan");		
		
		given()
		.contentType(ContentType.JSON).body(jsonObj.toJSONString())
		.when()
		 .put("http://49.249.28.218:8091/project/NH_PROJ_6105")
		 .then()
		 .assertThat().statusCode(200)
		 .log().all();
		
		
		//"http://49.249.28.218:8091/project/NH_PROJ_6067"
		
		
		
	}

}

package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForDeleteTest
{
	@Test
	public void deleteDataFromServer()
	{
		
		Response resp=RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_6037");
		resp.then().log().all();
		resp.then().assertThat().statusCode(204);
		
	}

}

package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForDeleteTest
{
	@Test
	public void deleteDataFromServer()
	{
		
		given().delete("http://49.249.28.218:8091/project/NH_PROJ_6105").then().assertThat().statusCode(204).log().all();
		
		//"http://49.249.28.218:8091/project/NH_PROJ_6105"

		
	}

}

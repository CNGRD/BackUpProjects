package practicePostRequestTypes;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostReq_Via_HashMapObjectTest 
{
	@Test
	public void postDataToServer()
	{
		HashMap<String, Object> map=new HashMap();
		map.put("createdBy", "Monster");
		map.put("status", "Created");
		map.put("teamSize",0);
		map.put("projectName","DSA");
		
		given().contentType(ContentType.JSON).body(map)
		.when().post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}

}

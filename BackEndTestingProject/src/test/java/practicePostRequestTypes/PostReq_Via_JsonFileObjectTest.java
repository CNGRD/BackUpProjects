package practicePostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostReq_Via_JsonFileObjectTest 
{
	@Test
	public void postDataToServer()
	{
		File fileObj=new  File("./project.json");
		
		given().contentType(ContentType.JSON).body(fileObj)
		.when().post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}

}

package reqChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario_1_Delete_Project 
{
	@Test
	public void postDataToServer()
	{
		//generate random number to concatenate
		Random ran=new Random();
		int randNum=ran.nextInt(5000);
		//create an object to pojo class
		
		//Execute API-1 request ===> add a project inside the server
		ProjectPojo pobj=new ProjectPojo("KFI"+randNum, "created", "DJ", 0);
		
		
	Response resp=	given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		
		//capture projectName from the response
		String projectId=	resp.jsonPath().get("projectId");
		System.out.println(projectId);
		
		
		//delete project API-2
		given().delete("http://49.249.28.218:8091/project/"+projectId).then().log().all();
		
	}

}

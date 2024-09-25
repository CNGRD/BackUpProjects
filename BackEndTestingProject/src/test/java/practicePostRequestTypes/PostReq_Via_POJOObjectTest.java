package practicePostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostReq_Via_POJOObjectTest 
{
	@Test
	public void postDataToServer()
	{
		//generate random number to concatenate
		Random ran=new Random();
		int randNum=ran.nextInt(1000);
		//create an object to pojo class
		
		ProjectPojo pobj=new ProjectPojo("KFI"+randNum, "created", "NGRRAO", 0);
		
		
		given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}

}

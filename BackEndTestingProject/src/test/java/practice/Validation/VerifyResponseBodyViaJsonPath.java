package practice.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyViaJsonPath 
{
	@Test 
	public void sampleTest1()
	{
		Response resp= given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		
		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted",Matchers.equalTo(true) );
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_6314"));
		
		ArrayList<String> lst=resp.jsonPath().get("content.projectName");
		System.out.println(lst);
		
		
		
		
		
		/*
		 * int data=resp.jsonPath().get("numberOfElements"); System.out.println(data);
		 * 
		 * boolean data1=resp.jsonPath().get("pageable.sort.unsorted");
		 * System.out.println(data1);
		 * 
		 * 
		 * String proId=resp.jsonPath().get("content[0].projectId");
		 * System.out.println(proId);
		 */
		
		
		
	}

}

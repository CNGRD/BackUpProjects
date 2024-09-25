package practice.Validation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDataComplexJsonXpathTest 
{
	@Test
	public void sampleTest()
	{
		Response resp= given().get("http://49.249.28.218:8091/projects-paginated");
		//resp.then().log().all();
		
		List<String> lst=JsonPath.read(resp.asString(),".content[*].projectName");
		
		for(String data:lst)
		{
			System.out.println(data);
		}
		List<String> lst1=	JsonPath.read(resp.asString(),".content[*].[?(@.projectName==\"Abb_2895\")].projectId");
		String actProjectId=lst1.get(0);
		
		Assert.assertEquals(actProjectId,"NH_PROJ_6314");
		
		//extract firstProjectId
		//DB validation
		//request chaining	
	}

}

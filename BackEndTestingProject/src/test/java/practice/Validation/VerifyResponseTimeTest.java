package practice.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest 
{
	@Test
	public void verifyResTime()
	{
		Response resp=given().get("http://49.249.28.218:8091/project/NH_PROJ_5794");//get all projects
	    resp.then().log().all();
	    
	  long t=resp.time();
	  long timeTaken=resp.timeIn(TimeUnit.SECONDS);
	  System.out.println("Response time is :"+t);
	  System.out.println("Response time is :"+timeTaken);
	  resp.then().assertThat().time(Matchers.lessThan(600l));
	  resp.then().assertThat().time(Matchers.greaterThan(400l));
	  resp.then().assertThat().time(Matchers.both(Matchers.lessThan(600l)).and (Matchers.greaterThan(400l)));
	}

}

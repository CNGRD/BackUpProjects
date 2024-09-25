package practice.Validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest 
{
	@Test
	public void verifyHeader()
	{
		Response resp=given().get("http://49.249.28.218:8091/project/NH_PROJ_5794");//get all projects
	    resp.then().log().all();
	    
	    resp.then().assertThat().contentType(ContentType.JSON);//validating content type
	    resp.then().assertThat().statusLine("HTTP/1.1 200 ");//validating status line
	    resp.then().assertThat().statusCode(200);//validating status code
	    resp.then().assertThat().header("Transfer-Encoding", "chunked");
	}

}

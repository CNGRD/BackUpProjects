package authorization_test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_AuthTest 
{
	@Test
	public void sampleTest()
	{
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.log().all()
		.when()
		.get("http://49.249.29.5:8091/login")
		.then()
		.log().all();
		
	}

}

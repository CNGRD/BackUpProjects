package authorization_test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Oauth_2_Test 
{
	@Test
	public void sampleTest()
	{
		given()
		//in video he has used KEYCLOCK to generate Oauth2
		.formParam("client_id", "ninza-client")
		.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client-credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token")
		.then()
		.log().all();
		
	}

}

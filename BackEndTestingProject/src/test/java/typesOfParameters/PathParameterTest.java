package typesOfParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest
{
	@Test
	public void sampleTest()
	{
		given()
		//.pathParam("projectId","NH_PROJ_6392")
		.when()
		.get("http://49.249.28.218:8091/project?teamSize=10")
		.then()
		.log()
		.all();
	}

}

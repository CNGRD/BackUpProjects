package datadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddMultipleProjectTest 
{
	Random rand=new Random();
	int r=rand.nextInt(5000);
	String pName="Google"+r;
	String status="Created";
	String reqBody="{\r\n"
			+ "  \"createdBy\": \"Nithin\",\r\n"
			+ "  \"projectName\": \""+pName+"\",\r\n"
			+ "  \"status\": \""+status+"\",\r\n"
			+ "  \"teamSize\": 0\r\n"
			+ "}";
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pName,String status)
	{
		given()
			.contentType(ContentType.JSON)
			.body(reqBody)
		.when()
		    .post("http://49.249.28.218:8091/addProject")
		.then()
			.log().all();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="AirIndia_n1";
		objArr[0][1]="Created";
		
		objArr[1][0]="AirIndia_n2";
		objArr[1][1]="Created";
		
		objArr[2][0]="AirIndia_n3";
		objArr[2][1]="Created";
		return objArr;
	}	

}

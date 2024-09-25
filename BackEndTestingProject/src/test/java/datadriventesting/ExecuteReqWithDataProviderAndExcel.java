package datadriventesting;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ExecuteReqWithDataProviderAndExcel 
{
//	Random rand=new Random();
//	int r=rand.nextInt(5999999);
//	String pName="GoogleMonsterNGR"+r;
//	String status="Created";
//	String reqBody="{\r\n"
//			+ "  \"createdBy\": \"Nithin\",\r\n"
//			+ "  \"projectName\": \""+pName+"\",\r\n"
//			+ "  \"status\": \""+status+"\",\r\n"
//			+ "  \"teamSize\": 0\r\n"
//			+ "}";
	
	@Test(dataProvider = "getData")
	public void sampleTest(String pName,String status)
	{
		String reqBody="{\r\n"
				+ "  \"createdBy\": \"Nithin\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
			.contentType(ContentType.JSON)
			.body(reqBody)
		.when()
		    .post("http://49.249.28.218:8091/addProject")
		.then()
			.log().all();
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		int count=eLib.getRowCount("project");
		Object[][] objArr=new Object[count][2];
		
		for(int i=0;i<count;i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("project", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("project", i+1, 1);
		}
			return objArr;
			
	}
	
}

package com.ninza.hrm.api.projectTest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseClass.BaseApiClass;
import com.ninza.hrm.api.pojoclass.ProjectPojo;
import com.ninza.hrm.constants.endpoint.IEndPoint;

import io.restassured.response.Response;

public class ProjectTest extends BaseApiClass
{
	
	ProjectPojo pobj;
	@Test
	public void addSingleProjectWithCreated() throws Exception
	{
				//String baseUri=fLib.getDataFromPropertiesFile("BASEUri");
				
				String expectedMsg="Successfully Added";
				String projectName="KFI"+jLib.getRandomNumber();
				
				//create an object to pojo class
				
				pobj=new ProjectPojo(projectName, "created", "NGRRAO", 0);
				
			//verify the projectName in API layer	
			Response resp=given()
					   .spec(specReqObj)
					   .body(pobj)
					.when()
					   .post(IEndPoint.ADDProject);
					
			resp.then()
					  .assertThat().statusCode(201)
					  .assertThat().time(Matchers.lessThan(3000L))
					  .spec(specResObj)
					   .log().all();
			
			String actualMsg=resp.jsonPath().get("msg");
			Assert.assertEquals(expectedMsg, actualMsg);
			
			//verify the projectLayer in DB layer
			//dbLib.getDbConnection();
			boolean flag=dbLib.executeQueryVerifyAndGetData("select * from project", 4, projectName);
			Assert.assertTrue(flag," Project in DB is not Verified");
			//dbLib.closeDbconnection();
//			
//			boolean flag=false;
//			Driver dref=(Driver) new ProjectTest();
//			DriverManager.registerDriver(dref);
//			
//		  Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%", "root");
//		  ResultSet result=conn.createStatement().executeQuery("select * from project");
//		  while(result.next())
//		  {
//			  if(result.getString(4).equals(projectName))
//			  {
//				  flag=true;
//				  break;
//			  }
//		  }
//			conn.close();
//			Assert.assertTrue(flag,"project in DB is not verified");
				
		}
	
	//second test case
	@Test(dependsOnMethods = "addSingleProjectWithCreated")
	public void createDuplicateProjectTest() throws Exception
	{
		//String baseUri=fLib.getDataFromPropertiesFile("BASEUri");
		//verify the projectName in API layer	
		given()
			   .spec(specReqObj)
			   .body(pobj)
			.when()
			   .post(IEndPoint.ADDProject)
			.then()
			.assertThat().statusCode(409)
			.spec(specResObj)
			.log().all();
	}
	
	
	

}

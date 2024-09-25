package com.ninza.hrm.api.employeeTest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseClass.BaseApiClass;
import com.ninza.hrm.api.pojoclass.EmployeePOJO;
import com.ninza.hrm.api.pojoclass.ProjectPojo;
import com.ninza.hrm.constants.endpoint.IEndPoint;

import io.restassured.http.ContentType;

public class EmployeeTest extends BaseApiClass
{
	
	@Test
	public void addEmployeeTest() throws Exception
	{
		//String baseUri=fLib.getDataFromPropertiesFile("BASEUri");
		
		//create an object to pojo class
		String projectName="KI"+jLib.getRandomNumber();
		String user="KAI"+jLib.getRandomNumber();
		//Execute API-1 request ===> add a project inside the server
		ProjectPojo pobj=new ProjectPojo(projectName, "created", "DJ", 0);
		
		
		given()
		.spec(specReqObj)
		.body(pobj)
		.when().post(IEndPoint.ADDProject)
		.then()
		.spec(specResObj)
		.log().all();
	
		
		//API-2 add employee to same project
		//String designation, String dob, String email, String empName, double experience,
		//String mobileNo, String project, String role, String username
		
		EmployeePOJO empObj=new EmployeePOJO("SDET-2", "09/02/99", "ngrqsp.Jsp@gmail.com",
				user,4.0,"8619026769",projectName,"ROLE_EMPLOYEE", user);		
		
		given().spec(specReqObj)
		.body(empObj)
		.when()
			.post(IEndPoint.ADDEmp)
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			.assertThat().time(Matchers.lessThan(3000L))
			.spec(specResObj)
			.log().all();
		
		//verify the projectLayer in DB layer
		//dbLib.getDbConnection();
		boolean flag=dbLib.executeQueryVerifyAndGetData("select * from employee", 5, user);
		Assert.assertTrue(flag," Project in DB is not Verified");
		Assert.assertTrue(flag,"Employee in Db is not Verified");
		//dbLib.closeDbconnection();
		
	}
	

}

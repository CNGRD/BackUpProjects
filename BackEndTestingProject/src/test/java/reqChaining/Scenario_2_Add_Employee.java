package reqChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_Add_Employee 
{
	@Test
	public void addEmployee()
	{
		//generate random number to concatenate
				Random ran=new Random();
				int randNum=ran.nextInt(5000);
				//create an object to pojo class
				
				//Execute API-1 request ===> add a project inside the server
				ProjectPojo pobj=new ProjectPojo("KFI"+randNum, "created", "DJ", 0);
				
				
			Response resp=	given().contentType(ContentType.JSON).body(pobj)
				.when().post("http://49.249.28.218:8091/addProject");
				resp.then().assertThat().statusCode(201).log().all();
				
				//capture projectName from the response
				String projName=	resp.jsonPath().get("projectName");
				System.out.println(projName);
				
				//API-2 add employee to same project
				//String designation, String dob, String email, String empName, double experience,
				//String mobileNo, String project, String role, String username
				
				EmployeePOJO empObj=new EmployeePOJO("SDET-2", "09/02/99", "ngrqsp.Jsp@gmail.com",
						"KALKI"+randNum,4.0,"86190267"+randNum,projName,"ROLE_EMPLOYEE", "KAlKI"+randNum);		
				
				given().contentType(ContentType.JSON).body(empObj)
				.when().post("http://49.249.28.218:8091/employees");
				resp.then().assertThat().statusCode(201).log().all();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}

}

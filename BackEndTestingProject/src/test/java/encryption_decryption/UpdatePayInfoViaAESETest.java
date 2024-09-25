package encryption_decryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import javax.crypto.NoSuchPaddingException;

public class UpdatePayInfoViaAESETest 
{
	@Test
	public void sampleTrest() throws NoSuchPaddingException, Exception
	{
		EncryptAndDecryptUtility ed=new EncryptAndDecryptUtility();
		
		String jBody="{ \"employee\": { \"empId\":\"NHR_00001\", \"designation\": \"CEO\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 10000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }";
		String jReqBody=ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(jReqBody);
		given()
			.body(jReqBody)
		.when()
			.put("http://49.249.28.218:8091/payroll")
			
		.then()
			.log().all();
		
		
	}

}

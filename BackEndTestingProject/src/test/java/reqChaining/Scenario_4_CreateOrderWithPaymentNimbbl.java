package reqChaining;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_4_CreateOrderWithPaymentNimbbl 
{
	public static void main(String[] args) 
	{
		//https://nimbbl.biz/docs/homepage/
		
		//set base url
		baseURI="https://api.nimbbl.tech/";
		
		System.out.println("*****************Authorization POST Request*********************");
		
		//Authorization post request to generate token
		
		String accessKey="access_key_pKx7rWVgVpbXQvq2";
		String accessSecret="access_secret_DX3w55VKAkXbx7aB";
		
		String authorizationRequestBody="{\"access_Key\":\""+accessKey+"\",\"access_Secret\":\""+accessSecret+"\"}";
		
		Response authorizationResponseBody=given().body(authorizationRequestBody)
											.contentType(ContentType.JSON)
											.post("/api/v3/generate-token");
											
					authorizationResponseBody.then().log().all();
					
		String bearerToken=	authorizationResponseBody.jsonPath().get("token");
		
		//create an order POST request
		System.out.println("===========Create an order POST request=============");
		
		String invoice="Inv_"+new Random().nextInt();
		String createOrderRequestBody="{\"amount_before_tax\": 2100,\"tax\": 105,\"total_amount\": 2205,\"user\": {\"email\": \"wonderwoman@themyscira.gov\",\"first_name\": \"Diana\",\"last_name\": \"Prince\",\"country_code\": \"+91\"\"mobile_number\": \"9876543210\"  }";
		Response createOrderResponseBody=given()
										.header("Authorization","Bearer"+bearerToken)
										.body(createOrderRequestBody)
										.contentType(ContentType.JSON)
										.post("/api/v3/create-order");
		createOrderResponseBody.then().log().all();
		
		String orderId=createOrderResponseBody.jsonPath().get("order_id");
		String userToken=createOrderResponseBody.jsonPath().get("user.token");
		
		
		System.out.println("**************Initiate payment POST Request**************");
		LinkedHashMap<String, String> initiatePaymentHeader=new LinkedHashMap<String,String>();
		initiatePaymentHeader.put("Authorization","Bearer"+bearerToken);
		initiatePaymentHeader.put("x-nimbbl-user-token", userToken);
		String initiatePaymentRequestBody="{\"order_id\": \"o_BrbcdefghAD7zg\",\"callback_url\": \"https://mangoseller.awesome/transaction-response\",\"payment_mode_code\": \"debit_card\",\"card_details\": \"GtaB+scxNhddg3WKO8UjqFfVhBc7ukohKlx7E+IEO/7xNn64UK5lcPbOLI70KGBxRdh+5Vk1qUeB5GNVnHit4B5/zB0hfzH+48zEkyDLKMqyTwj6f3hjtm/aiv5Ee4y6J+vozJtdIzELZiS1lCFQYWWwSDblp6TjErrQNXG2YEs=\"}";
		Response initiatePaymentResponseBody=given()
											.headers(initiatePaymentHeader)
											.body(initiatePaymentRequestBody)
											.contentType(ContentType.JSON)
											.post("/api/v3/initiate-payment");
		
		
		initiatePaymentResponseBody.then().log().all();
		String redirectURL=initiatePaymentResponseBody.jsonPath().get("next[0].url");
		String transactionId=initiatePaymentResponseBody.jsonPath().get("transactionId");
		
		System.out.println("Redirect URL :"+redirectURL);
		System.out.println("TransactionID:"+transactionId);
		
		
		System.out.println("**********webhook payment confirmation*************");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(redirectURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Nithin");
		driver.findElement(By.id("password")).sendKeys("root123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("===============Transaction Enquiry POST Request=====================");
		
		
		LinkedHashMap<String, String> transactionEnquiryHeader=new LinkedHashMap<String,String>();
		transactionEnquiryHeader.put("Authorization","Bearer"+bearerToken);
		transactionEnquiryHeader.put("x-nimbbl-user-token", userToken);
		String transactionEnquiryRequestPayBody="{\"transaction_id\": \"o_Rz4Zx2WeyooEpyxa-221117104614\",\"order_id\": \"o_Rz4Zx2WeyooEpyxa\",\"invoice_id\": \"inv_asjjeibdhakk49hnek3\"}";
		Response transactionEnquiryResponsePayBody=given()
											.headers(transactionEnquiryHeader)
											.body(transactionEnquiryRequestPayBody)
											.contentType(ContentType.JSON)
											.post("/api/v3/transaction-enquiry");
		
		transactionEnquiryResponsePayBody.then().log().all();
		
		String orderStatus=transactionEnquiryResponsePayBody.jsonPath().get("order.status");
		
		//print order status
		System.out.println(orderStatus);
		
		}

}

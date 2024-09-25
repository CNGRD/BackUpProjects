package com.ninza.hrm.api.baseClass;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.FileUtility;
import com.ninza.hrm.api.genericutility.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClass 
{
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public static RequestSpecification specReqObj;
	public static ResponseSpecification specResObj;
	@BeforeSuite
	public void configBS() throws Exception
	{
		dbLib.getDbConnection();
		System.out.println("===========Connect To DB===========");
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		//builder.setAuth(basic("username", "password"));
		//builder.addHeader("","");
		specReqObj= builder.build();
		builder.setBaseUri(fLib.getDataFromPropertiesFile("BASEUri"));
		specReqObj=builder.build();
		
		ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		specResObj=resBuilder.build();
	}
	@AfterSuite
	public void configAS() throws SQLException
	{
		dbLib.closeDbconnection();
		System.out.println("=============DisConnect from DB==================");
	}
	

}

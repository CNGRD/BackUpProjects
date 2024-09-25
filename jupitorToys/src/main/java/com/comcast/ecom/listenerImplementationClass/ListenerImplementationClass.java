package com.comcast.ecom.listenerImplementationClass;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.ecom.baseUtil.BaseClass;
import com.comcast.ecom.javaUtility.UtilityClassObject;


public class ListenerImplementationClass implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite)
	{
		System.out.println("Configuraing ExtentReports");
		
		String time=new Date().toString().replace(" ","_").replace(":","_" );
		ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReports/report_"+time);
		spark.config().setDocumentTitle("Ecom Test Results");
		spark.config().setReportName("Ecomm Report");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10 home");
		report.setSystemInfo("Browser", "CHROME-126");
	}
	
	public void onFinish(ISuite suite)
	{
		System.out.println("Report BackUp");
		report.flush();
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("======"+result.getMethod().getMethodName()+"===START====");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod()+"=====STARTED=====");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("======"+result.getMethod().getMethodName()+"===END=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+" ==>COMPLETED<==");
	}
	public void onTestFailure(ITestResult result)
	{
		String testName=result.getMethod().getMethodName();
		
		TakesScreenshot eDriver=(TakesScreenshot) BaseClass.sDriver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		test.log(Status.FAIL, result.getThrowable());
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" ======>FAILED");
	}
	public void onTestSkipped(ITestResult result)
	{
		String testName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
	}
	
	
}

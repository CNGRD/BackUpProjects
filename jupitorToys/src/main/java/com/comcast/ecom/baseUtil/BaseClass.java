package com.comcast.ecom.baseUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.ecom.fileutilities.ExcelUtility;
import com.comcast.ecom.fileutilities.FileUtility;
import com.comcast.ecom.javaUtility.UtilityClassObject;
import com.comcast.ecom.javaUtility.WebDriverUtility;

public class BaseClass 
{
	public WebDriver driver=null;
	public static WebDriver sDriver=null;
	
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	@BeforeClass
	public void configBc() throws IOException
	{
		System.out.println("=============Launch the Browser============");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else
		{
			driver=new ChromeDriver();
		}
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		sDriver=driver;
		UtilityClassObject.setDriver(driver); 
	}
	
	
	@BeforeMethod
	public void configBm() throws IOException
	{
		System.out.println("BM");
		String URL=flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		
	}
	
	
	
	@AfterMethod 
	public void configAM()
	{
		
		System.out.println("=====Testing Done======");
	}
	
	
	@AfterClass
	public void configAc()
	{
		driver.quit();
	}
	
	
	

}

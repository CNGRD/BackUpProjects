package com.ecom.gtc.reg;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RegistrationPage 
{
	@Test
	public static void registrationTest() throws Exception
	{
		FileInputStream fis = new FileInputStream("./testScriptData/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		// generate the random number
		Random randomInt = new Random();
		int random = randomInt.nextInt(1000);
		
		  WebDriver driver = null; 
		  if (BROWSER.equals("chrome")) 
		  { 
			  driver = new ChromeDriver();
		  } 
		  else if (BROWSER.equals("firefox"))
		  { 
			  driver = new FirefoxDriver(); 
		  } 
		  else if (BROWSER.equals("edge")) 
		  { 
			  driver = new EdgeDriver(); 
		  } 
		  else 
		  { 
			  driver = new ChromeDriver(); 
		  }
		
		//login to the app
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
		  driver.manage().window().maximize();
		  driver.get(URL);
		 // click on login button
		  driver.findElement(By.linkText("Login")).click();
		  
		 //pass mail id and password data
		  driver.findElement(By.id("user_login")).sendKeys(USERNAME);
		  driver.findElement(By.id("user_pass")).sendKeys(PASSWORD);
		  driver.findElement(By.id("rememberme")).click();
		  driver.findElement(By.name("submit")).click();
		  
		  //close the browser
		  driver.close();
		
	}

}

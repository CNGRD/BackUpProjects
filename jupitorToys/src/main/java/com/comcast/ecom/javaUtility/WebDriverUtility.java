package com.comcast.ecom.javaUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForWebElementToBePresent(WebDriver diver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(diver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
}

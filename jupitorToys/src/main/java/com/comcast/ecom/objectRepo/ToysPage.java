package com.comcast.ecom.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToysPage 
{
	WebDriver driver;
	public ToysPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Shop")
	private WebElement linkText;
	
	@FindBy(xpath="//h4[text()='Stuffed Frog']/following-sibling::p//child::a[text()='Buy']")
	private WebElement buyStuffedFrog;
	
	@FindBy(xpath="//h4[text()='Fluffy Bunny']/following-sibling::p//child::a[text()='Buy']")
	private WebElement buyFluffyBunny;
	
	@FindBy(xpath="//h4[text()='Valentine Bear']/following-sibling::p//child::a[text()='Buy']")
	private WebElement buyValentineBear;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLinkText() {
		return linkText;
	}

	public WebElement getBuyStuffedFrog() {
		return buyStuffedFrog;
	}

	public WebElement getBuyFluffyBunny() {
		return buyFluffyBunny;
	}

	public WebElement getBuyValentineBear() {
		return buyValentineBear;
	}

	public void validateIndProPrice(String IndStuffedFrogPrice,String IndFluffyBunnyPrice,String IndValentineBearPrice)
	{
		String StuffedFrog1=driver.findElement(By.xpath("//h4[text()='Stuffed Frog']/following-sibling::p//child::span[text()='$10.99']")).getText();
		  if (StuffedFrog1.equals(IndStuffedFrogPrice)) 
		  {
			  System.out.println(" Individual Stuffed frog price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" Individual Stuffed frog price information is not verified==FAIL"); 
		  }
		  
		  String fluffyBunny1=driver.findElement(By.xpath("//h4[text()='Fluffy Bunny']/following-sibling::p//child::span[text()='$9.99']")).getText();
		  if (fluffyBunny1.equals(IndFluffyBunnyPrice)) 
		  {
			  System.out.println(" Individual Fluffy bunny price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" Individual Fluffy bunny price information is not verified==FAIL"); 
		  }
		  
		  String valentineBear1=driver.findElement(By.xpath("//h4[text()='Valentine Bear']/following-sibling::p//child::span[text()='$14.99']")).getText();
		  if (valentineBear1.equals(IndValentineBearPrice)) 
		  {
			  System.out.println(" Individual Valentine Bear price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" Individual Valentine Bear price information is not verified==FAIL"); 
		  }
	}
	
	public void validateSubTotalOfEach(String subtotalStuffedFrogPrice,String subtotalFluffyBunnyPrice,String subtotalValentineBearPrice)
	{
		String subTotalStuffedFrog=driver.findElement(By.xpath("//td[text()=' Stuffed Frog']/following-sibling::td[text()='$21.98']")).getText();
		  if (subTotalStuffedFrog.equals(subtotalStuffedFrogPrice)) 
		  {
			  System.out.println(" SubTotal Stuffed frog price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" SubToatl Stuffed frog price information is not verified==FAIL"); 
		  }
		  
		  String subTotalFluffyBunny=driver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/following-sibling::td[text()='$49.95']")).getText();
		  if (subTotalFluffyBunny.equals(subtotalFluffyBunnyPrice)) 
		  {
			  System.out.println(" SubTotal Fluffy bunny price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" SubTotal Fluffy bunny price information is not verified==FAIL"); 
		  }
		  
		  String subTotalValentineBear1=driver.findElement(By.xpath("//td[text()=' Valentine Bear']/following-sibling::td[text()='$44.97']")).getText();
		  if (subTotalValentineBear1.equals(subtotalValentineBearPrice)) 
		  {
			  System.out.println(" SubTotal Valentine Bear price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" SubTotal Valentine Bear price information is not verified==FAIL"); 
		  }
	}
	
	public void validateTotal(String expTotalPrice)
	{
		 String acttotalPrice=driver.findElement(By.xpath("//strong[contains(text(),'116.9')]")).getText();
		  if (acttotalPrice.equals(expTotalPrice)) 
		  {
			  System.out.println(" Total price information is verified==PASS"); 
		  }
		  else 
		  {
			  System.out.println(" Total price information is not verified==FAIL"); 
		  }
	}
	

}

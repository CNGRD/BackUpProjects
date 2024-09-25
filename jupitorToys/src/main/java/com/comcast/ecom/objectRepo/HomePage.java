package com.comcast.ecom.objectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.ecom.javaUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLinkText() {
		return linkText;
	}
	public void setLinkText(WebElement linkText) {
		this.linkText = linkText;
	}
	@FindBy(linkText="Home")
	private WebElement linkText;
	
	@FindBy(linkText="Contact")
	private WebElement linkText1;
	
	public WebElement getLinkText1() {
		return linkText1;
	}
	public void setLinkText1(WebElement linkText1) {
		this.linkText1 = linkText1;
	}
	
	public void navigateToContactsPage(WebDriver driver )
	{
		mousehover(driver, linkText);
		linkText1.click();
	}
	
}

package com.comcast.ecom.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='#/cart']")
	private WebElement cartClick;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCartClick() {
		return cartClick;
	}

	public void setCartClick(WebElement cartClick) {
		this.cartClick = cartClick;
	}
	
	
	public void addTocart()
	{
		ToysPage tPage=new ToysPage(driver);
		tPage.getLinkText().click();
		for(int i=1;i<=5;i++)
		{
			tPage.getBuyFluffyBunny().click();
		}
		for(int i=1;i<=3;i++)
		{
			tPage.getBuyValentineBear().click();
		}
		for(int i=1;i<=2;i++)
		{
			tPage.getBuyStuffedFrog().click();
		}
	}
	
}

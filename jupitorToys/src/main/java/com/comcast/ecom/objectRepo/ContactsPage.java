package com.comcast.ecom.objectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactsPage 
{
		@FindBy(xpath="//a[text()='Submit']")
	private WebElement buttonText;
	
	public WebElement getButtonText() {
		return buttonText;
	}
	//contact page elements
	@FindBy(id ="forename")
	private WebElement forename;
	
	@FindBy(id="surname")
	private WebElement surname;
	
	@FindBy(id="email")
	private WebElement emailid;
	
	@FindBy(id="telephone")
	private WebElement telephone;
	
	public WebElement getSurname() {
		return surname;
	}

	

	public WebElement getTelephone() {
		return telephone;
	}

	
	@FindBy(id="message")
	private WebElement message1;
	
	
	//error elements
	@FindBy(id ="forename-err")
	private WebElement forenameErr;
	
	@FindBy(id ="email-err")
	private WebElement emailErr;
	
	@FindBy(id ="message-err")
	private WebElement messageErr;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getMessage1() {
		return message1;
	}


	public WebElement getForename() {
		return forename;
	}

	
	public WebElement getEmailid() {
		return emailid;
	}

	

	
	public WebElement getForenameErr() {
		return forenameErr;
	}

	public WebElement getEmailErr() {
		return emailErr;
	}

	public WebElement getMessageErr() {
		return messageErr;
	}

	public WebElement getConfirmation() {
		return confirmation;
	}


	@FindBy(xpath="//a[text()='« Back']")
	private WebElement confirmation;
	
	
	
	public void validateError(String fornameError,String emailError,String messageError)
	{
		String actualForName = forenameErr.getText();
		 if(actualForName.equals(fornameError))
		 {
			System.out.println(" ForeName information is verified==PASS"); 
		} 
		 else 
		 {
			System.out.println(" Forename information is not verified==FAIL"); 
		}
		 String actualEmailError=emailErr.getText();
		 if(actualEmailError.equals(emailError)) 
		 {
			System.out.println(" Mail information is verified==PASS"); } 
		 else {
				System.out.println(" Mail information is not verified==FAIL");
				}
		 String actualMessageErr=messageErr.getText();
		if(actualMessageErr.equals(messageError)) 
		{
			System.out.println(" Message information is verified==PASS");
		}
		else 
		{
			System.out.println(" Message information is not verified==FAIL"); 
		}
	}
	
	public void validateMandatoryData(String foreName,String email,String message) throws EncryptedDocumentException, IOException
	{
		
		forename.sendKeys(foreName);
		emailid.sendKeys(email);
		message1.sendKeys(message);
		clickOnSubmitButton();
		Assert.assertEquals(confirmation.getText(),"« Back");
		System.out.println("======Validated======"); 
	}
	public void clickOnSubmitButton()
	{
		buttonText.click();
	}
	
	public void populateAllFields(String foreName,String surName,String email,String phno,String message)
	{
		forename.sendKeys(foreName);
		surname.sendKeys(surName);
		emailid.sendKeys(email);
		telephone.sendKeys(phno);
		message1.sendKeys(message);
		clickOnSubmitButton();
		Assert.assertEquals(confirmation.getText(),"« Back");
		System.out.println("======Validated======"); 
		
	}

}

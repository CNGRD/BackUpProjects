package test_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonWebSite 
{
	@Test
	public void amazonTest() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.navigate().to("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("washing machine");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.findElement(By.xpath("//span[contains(text(),'Portable Washing Machine, 13.3lbs')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
			
			
		WebElement ele= driver.findElement(By.xpath("//span[text()='6 Kilograms']"));
		Assert.assertEquals(ele.getText(), "6 Kilograms");
		System.out.println("Validated capacity successfully and capacity is :"+ele.getText());
		driver.close();
	}

}

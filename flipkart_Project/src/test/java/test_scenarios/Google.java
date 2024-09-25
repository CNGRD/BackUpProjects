package test_scenarios;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Google 
{
	@Test
	public void gTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("Nithin");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		List<WebElement> suggestions=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='G43f7e']/child::li")));
		
		List<String> suggestionText=new ArrayList<String>();
		
		for(WebElement suggest:suggestions)
		{
			suggestionText.add(suggest.getText());
		}
		
		Collections.sort(suggestionText);
		
		System.out.println("Sorted suggestions are");
		
		for(String suggestion:suggestionText)
		{
			System.out.println(suggestion);
		}
		if(suggestionText.size()>3)
		{
			System.out.println("The 3rd index suggestion is :"+suggestionText.get(2));
		}
		else
		{
			System.out.println("There are not enough suggestion");
		}
		driver.quit();
	}

}

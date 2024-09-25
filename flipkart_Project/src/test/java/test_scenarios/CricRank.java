package test_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CricRank 
{
	@Test
	public void cricTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.icc-cricket.com");
		
		WebElement element=driver.findElement(By.className("ot-sdk-row"));
		
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		exe.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='onetrust-button-group']//child::button[text()='Reject All']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		System.out.println("cookies rejected sucessfully");
		driver.findElement(By.xpath("//a[@text='Rankings']")).click();
		
		driver.findElement(By.linkText("Women's team rankings")).click();
		
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='si-table-body']//child::div//child::div"));
		
		for(WebElement e:ele)
		{
			System.out.println(ele.getFirst()+" "+ele.getLast());
			
		}
		
		driver.close();
	}

}

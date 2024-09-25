package test_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripApp 
{
	@Test
	public void mkTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.className("commonModal__close")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.findElement(By.id("listingFilterCheckbox")).click();
		
		List<WebElement> name =driver.findElements(By.xpath("//div[@class='makeFlex spaceBetween ']"));
		List<WebElement> price=driver.findElements(By.xpath("//div[@class='priceSection priceLockPersuasionExists ']"));
		
		for(WebElement e1:name)
		{
			for(WebElement e2:price)
			{
				System.out.println(e1+" block the price for "+e2);
			}
		}
		
		
		driver.quit();
	}

}

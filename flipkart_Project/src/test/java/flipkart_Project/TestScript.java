package flipkart_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScript 
{
	@Test
	public void fkTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("iphone16");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> names=driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> price=driver.findElements(By.xpath("//div[@class='KzDlHZ']/../following-sibling::div[@class='col col-5-12 BfVC2z']//div[@class='Nx9bqj _4b5DiR']"));
		
		for(WebElement ele:names)
		{
			for(WebElement p:price)
			{
				System.out.println(ele.getText()+"==========>"+p.getText());
			}
		}
		
		driver.close();
		
	}

}

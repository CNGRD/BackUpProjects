package flipkart_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScript2 
{
	@Test
	public void fkTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//span[text()='Home & Furniture']")).click();
		
		driver.findElement(By.xpath("//a[text()='Home Decor']"));
		
		//List<WebElement> elements=driver.findElements(By.xpath("//div[@class='_31z7R_']"));
		List<WebElement> elements=driver.findElements(By.xpath("//div[text()='More in ']/following-sibling::a"));
		for(WebElement ele:elements)
		{
			String options=ele.getText();
			System.out.println(options);
		}
		
		driver.close();
		
	}

}

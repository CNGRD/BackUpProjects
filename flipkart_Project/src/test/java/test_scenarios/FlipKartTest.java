package test_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKartTest 
{
	@Test
	public void fkTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("Watches");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//nav//child::a[text()=10]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		driver.findElement(By.xpath("//nav//child::a[text()=15]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		driver.findElement(By.xpath("//nav//child::a[text()=20]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		driver.findElement(By.xpath("//nav//child::a[text()=25]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		//driver.findElement(By.xpath("//nav//child::a[text()=30]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		
		//String str=driver.findElement(By.xpath("//div[@class='hCKiGj']//child::a[text()='Trendies Analog Watch  - For Men 38040PP01']/ancestor::div[@class='hCKiGj']")).getText();
		String str=driver.findElement(By.xpath("//div[@class='hCKiGj']//child::a[1]")).getText();
		System.out.println("First Watch details present in last webpage" );
		System.out.println(str);
		driver.close();
	}

}

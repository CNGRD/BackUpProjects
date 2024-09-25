package scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CricBuzzApp_SC1 
{
	@Test
	public void cricBuzzTest() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//a[text()='Rankings']")).click();
		
		//driver.findElement(By.xpath("//a[text()='Rankings']"));
		String batting = driver.findElement(By.xpath("//div[@class='cb-nav-main cb-bg-white']/h1[contains(text(),'Rankings')]")).getText();
		System.out.println(batting);
		Thread.sleep(3000);
	
		WebElement button = driver.findElement(By.id("batsmen-t20s-tab"));
		
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		
		exe.executeScript("arguments[0].click();",button);
		
		driver.quit();
		
		
		
		
		//Actions act=new Actions(driver);
		//WebElement e1= (WebElement) act.moveToElement(driver.findElement(By.xpath("//nav[@gtm-label='rankings']//child::a[text()='T20']")));
		//e1.click();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@gtm-label='rankings']//child::a[text()='T20']")));
//		element.click();
	}

}

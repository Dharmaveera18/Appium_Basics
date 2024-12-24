package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTests extends BrowserBaseTest {

	@Test
	public void browserTest() throws InterruptedException 
	{
		Thread.sleep(10000);
		
		driver.get("http://google.com");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Rahul shetty academy");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(2000);
	    Thread.sleep(2000);
	}
	
	
	
	//WebElement element = driver.findElement(By.id("yourElementId"));
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	
	//@Test
	public void scrollbrowserTest() throws InterruptedException 
	{
		Thread.sleep(10000);
		
		driver.get("http://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Products ']")).click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		
		String actualText = driver.findElement(By.xpath("//a[text()='Devops']")).getText();
		String expectedText = "Devops";
		
		Assert.assertEquals(actualText, expectedText);
		Thread.sleep(2000);
		
	    
	}
}

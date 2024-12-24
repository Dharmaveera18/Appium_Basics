package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
public class Assnment1_HandlingAlert extends BaseTest {
	
	
	//@Test(priority = 0)
	public void Handle_Alert1() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	
	
	//@Test(priority = 1)
	public void Handle_List_Dialog() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command two\")")).click();;
		String actualText = driver.findElement(By.id("android:id/message")).getText();
		String expectedText = "You selected: 1 , Command two";
		Assert.assertEquals(actualText, expectedText);
		//
	}
	
	//@Test(priority = 2)
	public void Handle_CheckBoxes() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		
		List<WebElement> elements = driver.findElements(By.className("android.widget.CheckedTextView"));
		
		for(int i = 1; i< elements.size(); i++)
		{
			elements.get(i).click();
			Thread.sleep(1000);
		}
		
		driver.findElement(By.id("android:id/button2")).click();
		
		//
	}
	
	//@Test(priority = 3)
	public void ClickOnRadioButton() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
	
//		WebElement ele = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']"));
//		ele.click();
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].click();", ele);
        
       
		List<WebElement> elements = driver.findElements(By.className("android.widget.CheckedTextView"));
		
		for(int i = 1; i<elements.size(); i++)
		{
			

			WebElement ele = driver.findElement(By.xpath("(//android.widget.CheckedTextView)["+i+"]"));
			ele.click();
			Thread.sleep(5000);
		}
		
		driver.findElement(By.id("android:id/button2")).click();
		
	}
	
	
	@Test(priority = 4)
	public void enterTextToTextFields() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Dharma");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Dharma@143");
		driver.findElement(By.id("android:id/button1")).click();
		
	}	
	
}

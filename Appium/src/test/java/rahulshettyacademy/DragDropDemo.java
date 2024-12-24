package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
public class DragDropDemo extends BaseTest {
	
	
	@Test
	public void dragDropDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));	
		
		//Selecting endX and endY is mandatory.
		dragDropGesture(source);
		Thread.sleep(3000);                    
		String actualText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		String expectedText = "Dropped!";
		Assert.assertEquals(actualText, expectedText);
	}

}

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
public class LongPress extends BaseTest {
	
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException, InterruptedException
	{
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longpressGesture(element);
		boolean value = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).isDisplayed();
	    Assert.assertTrue(value);
		
	}

}

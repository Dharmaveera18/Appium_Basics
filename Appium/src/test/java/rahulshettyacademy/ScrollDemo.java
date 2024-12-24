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
public class ScrollDemo extends BaseTest {
	
	
	@Test
	public void scrollTestDemo() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		String searchText = "WebView";
		
		scrollTillSpecificWebElement(searchText);
	    
		
		//When NO prior idea about till where to scroll// whenever you want to scroll little little.
		//Scroll untill end
		//scrolluntillEndAction();
	
	}

}

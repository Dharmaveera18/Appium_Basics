package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
public class AppiumBasics extends BaseTest {
	
	
	@Test
	public void wifiSettingNameTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		System.out.println("Trying to click on preferences");
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		System.out.println("Clicked on preferances");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(2000);
		String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
		String expectedText = "WiFi settings";
		Assert.assertEquals(actualText, expectedText);
		
	    driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Rahul wifi");
	    Thread.sleep(2000);
	    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	    
	    
	}

}

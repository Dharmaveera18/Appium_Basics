package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class MiscellaniousActivityActions extends BaseTest {
	
	
	@Test
	public void wifiSettingNameTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
			));

		
		
		DeviceRotation landscape1 = new DeviceRotation(0, 0, 0);
		driver.rotate(landscape1);
//		Thread.sleep(2000);
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
		Thread.sleep(2000);
		//To automate tests in landscape mode
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(2000);
		String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
		String expectedText = "WiFi settings";
		Assert.assertEquals(actualText, expectedText);
		
		
		driver.setClipboardText("Rahul wifi");
	    driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}

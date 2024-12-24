package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
public class Ecommerce_tc_1 extends BaseTest {
	
	
	@Test
	public void fillForm() throws MalformedURLException, URISyntaxException, InterruptedException
	{
	   Thread.sleep(2000);
	   //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dharma");
	   driver.hideKeyboard();
	   driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	   driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
	   String value = "Argentina";
	   scrollTillSpecificWebElement(value);
	   driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']")).click();
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	   String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	   Assert.assertEquals(toastMessage, "Please enter your name");
	   
	   
	   
	}

}

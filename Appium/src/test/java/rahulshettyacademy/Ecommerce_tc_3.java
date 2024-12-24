package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Ecommerce_tc_3 extends BaseTest {
	
	
	@Test
	public void fillForm() throws MalformedURLException, URISyntaxException, InterruptedException
	{
	   Thread.sleep(2000);
	   driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dharma");
	   driver.hideKeyboard();
	   driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	   driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
	   String value = "Argentina";
	   scrollTillSpecificWebElement(value);
	   driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']")).click();
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	   Thread.sleep(2000);
	   String value1 = "Jordan 6 Rings";
	   scrollTillSpecificWebElement(value1);
	   //driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]")).click();
	
	   int productcount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	
	   for(int i = 0; i<productcount; i++)
	   {
		   String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    
		   if(productName.equalsIgnoreCase("Jordan 6 Rings"))
		    {
			   driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			   Thread.sleep(2000);
		    }
	  
	   }
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	   Thread.sleep(2000);
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	   
	   String actualText_in_Cart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	   Assert.assertEquals(actualText_in_Cart, "Jordan 6 Rings");
	   
	   
	}

}

package rahulshettyacademy;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Ecommerce_tc_2 extends BaseTest {
	
	
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
	   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	   Thread.sleep(2000);
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	   
	   List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	   int count = productPrices.size();
	   Double totalsum = 0.0;
	   for(int i = 0; i<count; i++)
	   {
		  String amountString =  productPrices.get(i).getText();
		  
		  Double price = getformattedAmount(amountString);
		  totalsum = totalsum + price;  //160.97 + 120.00
	   }
	   
	   String DisplayTotalamtString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	   Double DisplayTotalsum = getformattedAmount(DisplayTotalamtString);
	   System.out.println(DisplayTotalsum);
	   Assert.assertEquals(totalsum, DisplayTotalsum);
	   
	   WebElement termsBttn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	   longpressGesture(termsBttn);
	   
	   driver.findElement(By.id("android:id/button1")).click();
	   driver.findElement(By.className("android.widget.CheckBox")).click();
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	   Thread.sleep(5000);
	}

}

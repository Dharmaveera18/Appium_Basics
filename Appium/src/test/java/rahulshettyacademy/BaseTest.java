package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void configAppium() throws InterruptedException, MalformedURLException, URISyntaxException
	{
		//How to start appium server programmatically

				        service = new AppiumServiceBuilder()
			           // .usingDriverExecutable(new File("C:\\Program Files\\nodejs"))  // Path to Node.js
			            .withAppiumJS(new File("/Users/dharmaveerah/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))  // Path to Appium's main.js
			            .withIPAddress("127.0.0.1")  // Set IP address to 127.0.0.1
			            .usingPort(4723)  // Port number
			            .build();

				 Thread.sleep(10000);
				// service.start();
				
				 Thread.sleep(10000);
				 UiAutomator2Options options = new UiAutomator2Options();
				 options.setChromedriverExecutable("/Users/dharmaveerah/Chrome_Drivers/chromedriver_win32/chromedriver.exe");
				 //options.setDeviceName("Rahulemulator");
				 //options.setDeviceName("myavd1");
				 //options.setDeviceName("Rahulemulator1");
				 options.setDeviceName("Medium_AVD");
				 Thread.sleep(10000);
				 options.setApp("/Users/dharmaveerah/eclipse-workspace/Appium/src/test/java/resources/General-Store.apk");
				 //options.setApp("/Users/dharmaveerah/eclipse-workspace/Appium/src/test/java/resources/ApiDemos-debug.apk");
				 Thread.sleep(10000);
				
				//For Android apps ==> object of AndroidDriver
				 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				 //driver.pressKey(new KeyEvent(AndroidKey.BACK));
				 //driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	
	
	
	public void longpressGesture(WebElement element) throws InterruptedException
	{
		//To perform longpress
		
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) element).getId(),
					    "duration",2000
					));
				
				Thread.sleep(2000);
	}
	
	
	public void scrollTillSpecificWebElement(String searchText)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + searchText + "\"));"));
	}
	
	public void scrolluntillEndAction() throws InterruptedException
	{
		boolean canScrollMore;
		do {
			        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 1.0
				));
			   Thread.sleep(1000);
		}
		while(canScrollMore);
	}
	
	
	public void swipeGesture(WebElement firstImage)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) firstImage).getId(),
			    "direction", "left",
			    "percent", 0.3
			));
	}
	
	public void dragDropGesture(WebElement source)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 652,
			    "endY", 580
			));
	}
	
	public Double getformattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1)); // ==> amountString.substring(1) ==> $160 ==>160
	    return price; 
	}
	
	@AfterClass
	public void tearDown()
	{
		//How to stop appium server programmatically
		driver.quit();
		service.stop();
		
	}

}

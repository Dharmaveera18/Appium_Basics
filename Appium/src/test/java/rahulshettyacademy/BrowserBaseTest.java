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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
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
				 options.setCapability("browserName", "Chrome");
				 Thread.sleep(10000);
					
					//For Android apps ==> object of AndroidDriver
					 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				
				 
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

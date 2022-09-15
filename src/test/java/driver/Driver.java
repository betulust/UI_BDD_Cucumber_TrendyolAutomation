package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class Driver {
	
	
	private static WebDriver driver;
	


	public static  WebDriver getDriver() {
		
		if(driver==null) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		return driver;
	}

	@AfterMethod
	public static void closeDriver() {
		
		if(driver!=null) {
			
			driver.quit();
			driver=null;
		}
	}
}

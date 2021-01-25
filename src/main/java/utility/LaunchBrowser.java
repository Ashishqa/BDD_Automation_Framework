package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchBrowser {
	
	
	WebDriver driver;
	
	
	public WebDriver browser(String browserName)
	{
		
		switch (browserName) {
		case "Chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("enable-automation");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver",new Paths().chromeExePath);  
			driver = new ChromeDriver(options);
			break;
		case "FireFox":
			System.setProperty("webdriver.gecko.driver",new Paths().fireFoxExePath);  
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-extensions");
			firefoxOptions.addArguments("disable-infobars");
			firefoxOptions.addArguments("--disable-notifications");
			firefoxOptions.addArguments("enable-automation");
			firefoxOptions.addArguments("--disable-popup-blocking");
			firefoxOptions.addArguments("start-maximized");
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			System.setProperty("webdriver.chrome.driver",new Paths().chromeExePath);  
			driver = new ChromeDriver();
			break;
		}
		return driver;
		
	}
	
	public void loadUrl(WebDriver driver,String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

}

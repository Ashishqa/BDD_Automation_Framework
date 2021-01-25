package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.Browsers;
import utility.Driver;
import utility.LaunchBrowser;

public class Hooks {

public static WebDriver driver;
	
	@Before("@Smoke")
	public void tearUp()
	{
		driver = new LaunchBrowser().browser(Browsers.Chrome.toString());
		Driver.setDriver(driver);
	}
	
	
	@After("@Smoke")
	public void tearDown(Scenario scenario)
	{
		if (scenario.isFailed()) {

			try {
				//Assert.iinfo(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png",scenario.getName()); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				//log.info(scenario.getName() + " is pass");
				scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Driver.getDriver().close();
		Driver.getDriver().quit();
	}
}

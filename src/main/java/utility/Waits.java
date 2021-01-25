package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Waits(WebDriver _driver, int waitInMilliSeconds)
	{
		this.driver= _driver;
		wait = new WebDriverWait(driver, waitInMilliSeconds);		
	}
	
	public void visibilityOfElement(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementToBeClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}

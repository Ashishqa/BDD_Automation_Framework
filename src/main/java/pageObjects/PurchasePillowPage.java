package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.*;

public class PurchasePillowPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@class='btn buy']")
	WebElement buyNow;

	@FindBy(className = "cart-checkout")
	WebElement checkOut;

	@FindBy(xpath = "//div[@class='cart-head']/span[1]")
	public WebElement shoppingCart;

	@FindBy(id = "snap-midtrans")
	public WebElement orderSummaryPopup;

	@FindBy(xpath = "//*[@id='application']/div[1]/a")
	WebElement continueOrder;

	@FindBy(xpath = "//*[@id='payment-list']/div[1]")
	public WebElement creditCard;

	@FindBy(name = "cardnumber")
	WebElement cardNumber;

	@FindBy(xpath = "//*[@placeholder='MM / YY']")
	WebElement expiryDate;

	@FindBy(xpath = "//*[@inputmode='numeric']")
	WebElement cvvNumber;

	@FindBy(xpath = "//*[@id='application']/div[1]/a")
	WebElement payNow;

	@FindBy(xpath = "//*[@id='application']")
	public WebElement passwordPopup;

	@FindBy(xpath = "//div/iframe")
	WebElement passwordiFrame;

	@FindBy(xpath = "//*[@id='PaRes']")
	WebElement password;

	@FindBy(name = "ok")
	public WebElement ok;

	@FindBy(xpath = "//*[@class='trans-status trans-success']")
	WebElement successfulTranscation;

	@FindBy(xpath = "//*[@class='trans-status trans-success']/span[1]")
	WebElement successfulTranscationMessage;

	@FindBy(xpath = "//h1[contains(text(),'COCO STORE')]")
	public WebElement cocoStore;

	public PurchasePillowPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnBuyNow() {
		new Waits(driver, 90).elementToBeClickable(buyNow);
		buyNow.click();
	}

	public void clickOnCheckOut() {
		new Waits(driver, 90).elementToBeClickable(checkOut);
		checkOut.click();
	}

	public void clickOnContinueFromOrderSummary() {
		driver.switchTo().frame(orderSummaryPopup);
		new Waits(driver, 90).visibilityOfElement(continueOrder);
		continueOrder.click();
	}

	public void selectCreditCard() {
		new Waits(driver, 90).visibilityOfElement(creditCard);
		creditCard.click();
	}

	public void enterCreditCardNumber(String cardNumbers) {
		new Waits(driver, 90).visibilityOfElement(cardNumber);
		cardNumber.clear();
		cardNumber.sendKeys(cardNumbers);
	}

	public void enterCreditCardExpiryDates(String expiryDates) {
		new Waits(driver, 90).visibilityOfElement(expiryDate);
		expiryDate.clear();
		expiryDate.sendKeys(expiryDates);
	}

	public void enterCvvNumber(String cvvNumbers) {
		new Waits(driver, 90).visibilityOfElement(cvvNumber);
		cvvNumber.clear();
		cvvNumber.sendKeys(cvvNumbers);
	}

	public void clickPayNow() {
		new Waits(driver, 90).visibilityOfElement(payNow);
		payNow.click();
	}

	public void enterPassword(String banksOtps) throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().frame(passwordiFrame);
		new Waits(driver, 90).visibilityOfElement(password);
		password.clear();
		password.sendKeys(banksOtps);
	}

	public String getSuccessMessage() {
		driver.switchTo().defaultContent();
		new Waits(driver, 90).visibilityOfElement(successfulTranscation);
		return successfulTranscationMessage.getText();
	}

}

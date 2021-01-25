package stepDefinitions;

import static hooks.Hooks.driver;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PurchasePillowPage;
import utility.*;;

public class PurchasePillow {
	
	PurchasePillowPage purchasePillow = new PurchasePillowPage(driver);
	
	@Given("^I am on the Midtrans Pillow buy now page \"([^\"]*)\"$")
	public void i_am_on_the_Midtrans_Pillow_buy_now_page(String arg1)  {
	    
	    driver.get(arg1);
	}

	@When("^I click on buy now button$")
	public void i_click_on_buy_now_button()  {
	    
	    purchasePillow.clickOnBuyNow();
	}

	@Then("^I must see shopping cart screen$")
	public void i_must_see_shopping_cart_screen()  {
	    
	    Assert.assertTrue(purchasePillow.shoppingCart.getText().contains("Shopping Cart"));
	}

	@And("^I click on checkout button$")
	public void i_click_on_checkout_button()  {
		purchasePillow.clickOnCheckOut();
	    
	}

	@Then("^I must see order summary screen$")
	public void i_must_see_order_summary_screen()  {
	    
		new Waits(driver,90).visibilityOfElement(purchasePillow.orderSummaryPopup);
	}

	@And("^I click on continue button$")
	public void i_click_on_continue_button()  {
	    
		purchasePillow.clickOnContinueFromOrderSummary();
	}

	@Then("^I should see select payment screen$")
	public void i_should_see_select_payment_screen()  {
		new Waits(driver,90).visibilityOfElement(purchasePillow.creditCard);
	    
	}

	@And("^I select credit or debit card option$")
	public void i_select_credit_or_debit_card_option()  {
	    
		purchasePillow.selectCreditCard();
	}

	@Then("^I enter card number \"([^\"]*)\"$")
	public void i_enter_card_number(String arg1)  {
	   purchasePillow.enterCreditCardNumber(arg1);
	}
	
	@Then("^I enter expiry date \"([^\"]*)\"$")
	public void i_enter_expiry_date(String arg1)  {
	    
		purchasePillow.enterCreditCardExpiryDates(arg1);
	}

	@And("^I enter cvv number (\\d+)$")
	public void i_enter_cvv_number(int arg1)  {
	    
		purchasePillow.enterCvvNumber(Integer.toString(arg1));
	}

	@And("^I click on pay now button$")
	public void i_click_on_pay_now_button()  {
	    
	    purchasePillow.clickPayNow();
	}

	@Then("^I must see issuing bank screen to enter otp$")
	public void i_must_see_issuing_bank_screen_to_enter_otp()  {
	    
		new Waits(driver,90).visibilityOfElement(purchasePillow.passwordPopup);
	}

	@And("^I enter bank's otp (\\d+)$")
	public void i_enter_bank_s_otp(int arg1) throws InterruptedException  {
	    
		purchasePillow.enterPassword(Integer.toString(arg1));
	}

	@And("^I click on ok button$")
	public void i_click_on_ok_button()  {
		
		new Waits(driver,90).visibilityOfElement(purchasePillow.ok);
	   purchasePillow.ok.click();
	}

	@Then("^I must see transaction successful and \"([^\"]*)\" message$")
	public void i_must_see_transaction_successful_and_message(String arg1)  {
	    
		Assert.assertTrue(purchasePillow.getSuccessMessage().contains("Thank you for your purchase."), "User payment is not successful");
	}
	
	@Then("^I must not see issuing bank screen to enter otp$")
	public void i_must_not_see_issuing_bank_screen_to_enter_otp()  {
	   	Assert.assertTrue(purchasePillow.cocoStore.isDisplayed(), "User payment is unsuccessful after entring invalid credit card details");
	}

}

@All
Feature: Purchase Pillow
  As a midtrans user I should be purchase pillow successful using credit card

@Smoke
  Scenario: Purchase pillow with valid credit card payment
    Given I am on the Midtrans Pillow buy now page "https://demo.midtrans.com/"
    When I click on buy now button
    Then I must see shopping cart screen
    And I click on checkout button
    Then I must see order summary screen
    And I click on continue button
    Then I should see select payment screen
    And I select credit or debit card option
    And I enter card number "4811111111111114"
    And I enter expiry date "12/24"
    And I enter cvv number 123
    And I click on pay now button
    Then I must see issuing bank screen to enter otp
    And I enter bank's otp 112233
    And I click on ok button
    Then I must see transaction successful and "Thank you for your purchase" message

@Smoke
  Scenario: Purchase pillow with invalid credit card payment
    Given I am on the Midtrans Pillow buy now page "https://demo.midtrans.com/"
    When I click on buy now button
    Then I must see shopping cart screen
    And I click on checkout button
    Then I must see order summary screen
    And I click on continue button
    Then I should see select payment screen
    And I select credit or debit card option
    And I enter card number "4811111111111114"
    And I enter expiry date "12/20"
    And I enter cvv number 123
    And I click on pay now button
    Then I must not see issuing bank screen to enter otp

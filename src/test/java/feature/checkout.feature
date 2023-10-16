@Reg
Feature: Checkout Funtionality


Scenario: checkout with valid firstname lastname and postalcode
When user enter "standard_user" and "secret_sauce" deatils 
And user click on Login button
And user  click on add to cart button
Then validate cart count is "1" 
And user nvaigate to checkout page 
And user enter personal details "Test" "Automation" "201301"
And user click on continue button
Then validate user navigate to checkout two page
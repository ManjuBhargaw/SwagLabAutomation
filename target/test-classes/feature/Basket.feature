Feature: Basket functionality

Background: user navigat swag lab app
When user enter "standard_user" and "secret_sauce" deatils 
And user click on Login button	
@Reg
Scenario: Verify the user able add to the product into the basket 
And user  click on add to cart button
Then validate cart count is "1"
     
     
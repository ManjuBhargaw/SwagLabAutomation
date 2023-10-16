@Regn
Feature: Login Funtionality

Scenario: Login with valid credentials
When user enter "standard_user" and "secret_sauce" deatils 
And user click on Login button
Then validate successful login


Scenario: Login with invalid credentials
When user enter "standard_ufgsser" and "secret_dsfsauce" deatils 
And user click on Login button
Then validate error message


Scenario: Login with valid username and invalid password
When user enter "standard_user" and "fgdfg" deatils 
And user click on Login button
Then validate error message

Scenario: Login with invalid username and valid password
When user enter "stadfdf" and "secret_sauce" deatils 
And user click on Login button
Then validate error message
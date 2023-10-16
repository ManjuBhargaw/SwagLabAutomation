package Stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;

public class loginpagesteps {
	Loginpage login=new Loginpage();
	
	
	@When("user enter {string} and {string} deatils")
	public void user_enter_and_deatils(String username, String pass) {
     login.user_enter_and_deatils(username, pass);
	
	}

	@When("user click on Login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();
	    
	}

	@Then("validate successful login")
	public void validate_successful_login() {
	 
	}
	@Then ("validate error message")
	public void validate_error_message()
	{
		
		login.validate_error_message();
	}

}

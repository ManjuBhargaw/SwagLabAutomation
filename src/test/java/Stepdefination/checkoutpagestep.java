package Stepdefination;

import java.security.PublicKey;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.checkoutpage;

public class checkoutpagestep {
checkoutpage checkout=  new checkoutpage();
	
@Then("user enter personal detail (string)(string)(string)")
public void user_enter_personal_detail(String fname,String lname,String pcode)  {	
	checkout.user_enter_personal_detail(fname, lname, pcode);
		}
	
@And("user click on continue button")

 public void user_click_on_continue_button()
 {
 checkout.clickoncontinuebtn();
 }
@Then("validate user navigate to checkout two page")
 public void validate_user_navigate_to_checkout_two_page()
 {
	
	checkout.validate_user_navigate_to_checkout_two_page();
 }


}

package Stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Basketpage;

public class Basketpagestep 
{
	Basketpage basket= new Basketpage();
	@And("user click on add to cart button")
	public void user_click_on_add_to_cart_button()
	{
		basket.clickonaddtocart();
	}
	
     @Then(" validate cart count is (string)")
     public void validate_cart_count_is (String count)
     {
    	 basket.validatecartcount(count);
    	 
     }
    @And("user nvaigate to checkout page") 
    public void user_nvaigate_to_checkout_page()
        {
    basket.user_nvaigate_to_checkout_page();	
    	
    }
	

}

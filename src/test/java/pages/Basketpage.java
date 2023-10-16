package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class Basketpage extends Base {
	public void clickonaddtocart() {
	WebElement addtocartbtn	=driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));
	clickonelement(addtocartbtn);
	}
	public void validatecartcount(String count) {
	WebElement cartcount=driver.findElement(By.cssSelector("span.shopping_cart_badge"));
	        
	          String cartvalue = cartcount.getText();
	          Assert.assertEquals(count, cartvalue);
	          
	          
	
	}
	public void user_nvaigate_to_checkout_page()
    {
		WebElement cartlink=driver.findElement(By.cssSelector("a.shopping_cart_link"));
		
			
		clickonelement(cartlink);
    
   WebElement checkoutbtn=driver.findElement(By.cssSelector("button#checkout"));
   clickonelement(checkoutbtn);
    
    
    } 	
	
	
	

}

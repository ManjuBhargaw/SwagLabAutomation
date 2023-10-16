package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;
import io.cucumber.java.en.Then;

public class checkoutpage extends Base {
	
	public void user_enter_personal_detail(String fname,String lname,String pcode)
			{
		WebElement firstname=driver.findElement(By.cssSelector("input#first-name"));
	    firstname.sendKeys(fname);
		
		WebElement lastname=driver.findElement(By.cssSelector("input#last-name"));
	    lastname.sendKeys(lname);
		WebElement postalcode	=driver.findElement(By.cssSelector("input#postal-code"));
		 postalcode.sendKeys(pcode);
		
			}
		public void clickoncontinuebtn() {
			WebElement continuebtn = driver.findElement(By.cssSelector("input#continue"));
			clickonelement(continuebtn);
		}
		 public void validate_user_navigate_to_checkout_two_page(){
			String url= driver.getCurrentUrl();
			Assert.assertTrue(url.contains("step-two"));
			
		}

}

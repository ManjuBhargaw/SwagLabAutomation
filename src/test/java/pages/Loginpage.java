package pages;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginpage extends Base{
	
	public void user_enter_and_deatils(String username, String pass) {
	WebElement userName=driver.findElement(By.xpath("//input[@id=\"user-name\"]"));	
	userName.sendKeys(username);
	WebElement password=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	password.sendKeys(pass);
		
	
	}
	public void user_click_on_login_button()
	{
		
		WebElement loginbtn =driver.findElement(By.cssSelector("#login-button"));
	    
		clickonelement(loginbtn);
	}
	
	public void validate_error_message() {
		WebElement errormsg=driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		Assert.assertTrue(errormsg.isDisplayed());
	}
	
	

//test Automation

}

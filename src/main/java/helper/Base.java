package helper;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Base {
	 	
	public static  Properties prop;
	public static WebDriver driver;
	
	static {
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"src/test/java/resource/env.properties");
			 prop=new Properties();
			prop.load(file);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
	
	@Before
	public void setup() {
		
	     String browsername   =prop.getProperty("browser");
         ChromeOptions option=new ChromeOptions();
         option.addArguments("---incognito");
         //option.addArguments("headless");
	     	     
	     switch(browsername) {
	     case"chrome":
	    	 driver=new ChromeDriver();
	    	 break;
	     case"ff":
	    	 driver=new FirefoxDriver();
	    	 break;
	     case"edge":
	    	 driver=new EdgeDriver();
	    	 break;
	     
	  /*   if(browsername.equals("chrome"))
		{
			 driver=new FirefoxDriver();
			
		}  else if (browsername.equals("ff"))
		{
			driver=new FirefoxDriver();
			
		} else if(browsername.equals("edge"))
		{
		  driver=new EdgeDriver();
			
		}*/
	     }	
		
		
	     //driver=new ChromeDriver(); 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	
	public void selectvalueFromDropDown(WebElement ele,String value,String type) {
		Select s=new Select(ele);
		
	//s.selectByVisibleText(value);
	
	switch(type)
	{
	case"index":
		s.selectByIndex(Integer.parseInt(value));
         break;
	case"value":
		s.selectByValue(value);
	    break;
	case"visibletext":
		s.selectByValue(value);
		break;
	}
	
	
	}
	WebElement country;
	
	private void test() {
		selectvalueFromDropDown(country, "index", "5");
	}
	

	
	public void selectBootstrapeDropDown(List<WebElement>list,String value)
	
	{
	for(WebElement ele:list)
	{
		String actualvalue=ele.getText();
		if(actualvalue.equals(value))
		{
			ele.click();
        	break;
		}
	}	
		
		
	}
	
	
      public void mousehover(WebElement ele) {
      
    	  waitforexpectedelement(driver.findElement(By.xpath("")),10 );
    	  
    	  Actions a=new Actions(driver);
      a.moveToElement(ele).build().perform();
	
	
	
}


      public void handleAlert(String action) {
	
	  Alert a=driver.switchTo().alert();
	   switch (action) {
	   case "accept":
		a.accept();
		break;
		case"dismiss":
			a.dismiss();
			break;
		case"getvalue":
		String value=a.getText();
		break;
	}
	
}


      public void waitforexpectedelement(WebElement ele,long wait) {
        WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(wait));
       w.until(ExpectedConditions.visibilityOf(ele));
}
      public void waitforelementTobeclickable(WebElement ele,long wait) {
          WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(wait));
         w.until(ExpectedConditions.elementToBeClickable(ele));

}
	

      public void clickonelement(WebElement ele) {
		waitforelementTobeclickable(ele, 10);
		try {
			ele.click();	
		} catch (Exception e) {
			waitforelementTobeclickable(ele, 10);
			executorofclickonelement(ele);
		}
		
      
    	  
    	  
	}
      public void executorofclickonelement(WebElement ele) {
    	  JavascriptExecutor js=(JavascriptExecutor)driver;
    	  js.executeScript("argument[0].scrollIntoview(true)", ele);
    	  js.executeScript("arguments[0].click", ele);
		
	}
      
      
      public void validateText(WebElement ele,String expectedvalue)
      {
		String actualvalue=ele.getText();
    	 Assert.assertEquals(expectedvalue, actualvalue);//content compare
    	 Assert.assertTrue("this logo is no present", ele.isDisplayed());
    	  
    	  
    	  
	}
      public void switchtoframe(String value,String type) {
		switch (type) {
		case "name":
		 driver.switchTo().frame(0);
		break;
		case"index":
			driver.switchTo().frame(Integer.parseInt(value));
			break;
		}  
    	  
    	  
	
		
		
	}
      
      public void switchwindow(String title) {
    	  Set<String> allwindows=driver.getWindowHandles();
    	  for(String windowid:allwindows) {
    		  
    		  driver.switchTo().window(windowid);
    		  if(driver.getTitle().contains(title))
    		  {
    			  break;
    		  }
    		  
    		  
    	  }
    	  
		
	}
  
      
      
      public void checkbox(WebElement ele) {
    	  if(!ele.isSelected())
    	  {
    		  clickonelement(ele);
    		  
    		  
    	  }
	}
     
    @After  
      public void TearDown(Scenario s) {
    	  if(s.isFailed()) {
    	  TakesScreenshot ts=(TakesScreenshot)driver;
    	 File capturesScr = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(capturesScr, new File("Screenshot/"+s.getName()+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	  }
    	driver.quit();  
	} 
}



	
	
	
	
	


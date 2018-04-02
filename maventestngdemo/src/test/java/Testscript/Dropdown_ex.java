package Testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dropdown_ex {

	//check for birth month
	@Test
	//("SmokeTest")
	 public  void  dropdowntest()
	 {
	  System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	  WebDriver   driver=new ChromeDriver();
	   
	   driver.get("https://accounts.google.com/SignUp?hl=en");
	   
	  WebElement  bday=driver.findElement(By.xpath("//*[@id='BirthMonth']/div[1]"));
	  
	//advanced explicit wait
	//  WebDriverWait  wait=new WebDriverWait(driver, 10);
	  
	//  wait.until(ExpectedConditions.elementToBeClickable(bday));
	  bday.click();
	    
	 
	   List<WebElement> nodrops= driver.findElements(By.className("goog-menuitem"));
	  
	   System.out.println(nodrops.size());
	   
	   for(WebElement  obj:nodrops)
	   {
	    if(obj.getText().equalsIgnoreCase("June"))
	   	    {
	       System.out.println(obj.getText());
	         obj.click();
	         break;
	    }
	    
	   }
	   
	 }
}

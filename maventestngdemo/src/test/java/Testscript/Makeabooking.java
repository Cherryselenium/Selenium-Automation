package Testscript;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Makeabooking extends BaseClass{
//WebDriver Driver;
//	Properties  prop=new Properties();
	
@Test
		public void MakeBookings() throws InterruptedException, IOException 
		{
	//code removed


	Thread.sleep(4000);	
	WebElement test = Driver.findElement(By.id(prop.getProperty("FrmLocation")));
		Thread.sleep(2000);
		test.click();
		Thread.sleep(1000);
		
		//WebElement drpdown=Driver.findElement(By.xpath("//*[contains(@id,'uld')]"));
		
		//test.findElement(By.partialLinkText("Johannesburg")).click();
		test.sendKeys("JNB");
		WebElement toDest = Driver.findElement(By.id(prop.getProperty("ToLocation")));
		toDest.click();
		Thread.sleep(4000);
		toDest.sendKeys("BOM");
		Thread.sleep(4000);
			//test.sendKeys("JNB");
			//	toDest.sendKeys("BOM");
		WebElement Dateselect = Driver.findElement(By.id(prop.getProperty("DateField")));
		//Dateselect.getText();
		
		Dateselect.click();
		WebElement table = Driver.findElement(By.className(prop.getProperty("TblDate")));
		//table.click();
		Thread.sleep(4000);
		List <WebElement> nocols=table.findElements(By.tagName("td"));
		for (WebElement cell: nocols){
			   //Select 27th Date 
			   if (cell.getText().equals("01")){
			      cell.findElement(By.linkText("01")).click();
			      break;
			 }
			   
		}		   
		
		Driver.findElement(By.xpath("//*[@id='hp-widget__paxCounter_pot']")).click();
		//Driver.findElement(By.xpath(xpathExpression))
		Select dropdownadult = new Select(Driver.findElement(By.xpath("//*[@id='js-adult_counter']")));
		dropdownadult.selectByVisibleText("01");
		Select dropdowninfant = new Select(Driver.findElement(By.xpath("//*[@id='js-infant_counter']")));
		dropdowninfant.selectByVisibleText("01");
		
		Thread.sleep(4000);
		Driver.findElement(By.id(prop.getProperty("BtnSearch"))).click();	
		Thread.sleep(4000);
		Driver.findElement(By.linkText("Book Now")).click();

		Thread.sleep(6000);
		JavascriptExecutor js=(JavascriptExecutor)(Driver);

		js.executeScript("window.scrollBy(0,800)");
					

		Driver.findElement(By.partialLinkText("Continue")).click();
		Thread.sleep(6000);
		//Driver.findElement(By.xpath("//*[@id=\"travellerId0\"]/div[1]/div/input[1]")).sendKeys(prop.getProperty("Firstname"));
		Driver.findElement(By.xpath("//*[@id='travellerId0']/div[1]/div/input[1]")).sendKeys(prop.getProperty("Firstname"));

		Driver.findElement(By.xpath("//*[@id='travellerId0']/div[1]/div/input[2]")).sendKeys(prop.getProperty("Lastname"));
		Driver.findElement(By.xpath("//*[@id='travellerContactDiv']/div[1]/div/div[1]/div/div[2]/input[1]")).sendKeys(prop.getProperty("Pno"));
		Driver.findElement(By.xpath("//*[@id='content']/div/div[6]/p[2]/button")).click();

		Thread.sleep(6000);
		Driver.findElement(By.partialLinkText("Credit/Debit")).click();
		Driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys(prop.getProperty("CardNumber"));
		Driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys(prop.getProperty("NameonCard"));
		Select dropdownmonth = new Select(Driver.findElement(By.xpath("//*[@id='PAYMENT_expiryMonth']")));
		dropdownmonth.selectByVisibleText("04");
		Select dropdownyear = new Select(Driver.findElement(By.xpath("//*[@id='PAYMENT_expiryYear']")));
		dropdownyear.selectByVisibleText("2035");
				Driver.findElement (By.xpath("//*[@id='PAYMENT_cvv']")).sendKeys(prop.getProperty("CVV"));;
		
		Driver.findElement(By.id("widgetPayBtn")).click();
}
	
	
}


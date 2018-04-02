package Testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Logintomakemytrip extends BaseClass{
//private static final String NULL = null;
//	Properties  prop=new Properties();
@Test

public void login() throws InterruptedException, IOException
{
	    Thread.sleep(4000);
	    Driver.findElement(By.className(prop.getProperty("login_icon"))).click();
	    //	Driver.findElement(By.className("ch__loginIcon")).click();
	    Thread.sleep(8000);
	    //Driver.findElement(By.id("//*[@id='ch_login_email']")).click();
	    Driver.findElement(By.xpath(prop.getProperty("emailid_xpath"))).sendKeys(prop.getProperty("emailid"));
	    Driver.findElement(By.xpath(prop.getProperty("Password_xpath"))).click();
	    Driver.findElement(By.xpath(prop.getProperty("Password_xpath"))).sendKeys(prop.getProperty("password"));
	    Thread.sleep(5000);
	    Driver.findElement(By.xpath(prop.getProperty("BtnLogin"))).click();
	    
	    //Driver.findElement(By.className("btn-primary btn")).click();
	//    Thread.sleep(4000);
	 //   Driver.findElement(By.xpath("//*[@id='failed_wallet_got_it']")).click();
	    

	}
}

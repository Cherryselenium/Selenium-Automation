package Testscript;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatabaseConnection {
  @Test
  public void DBconnection() {
  
	  public class AssertionDB {

		  WebDriver  driver;
		 @SuppressWarnings("deprecation")
		 @Test
		 public  void  logintest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		 {
		     System.setProperty
		        ("webdriver.chrome.driver", 
		                "C:\\Drivers\\chromedriver.exe");
		       ChromeOptions options = new ChromeOptions();

		       
		       options.addArguments("start-maximized");
		       driver = new ChromeDriver(options);
		       
		       
		       driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		     
		       
		       String url1 ="jdbc:mysql://localhost:3306/Selenium_test";
		          String dbClass = "com.mysql.jdbc.Driver";
		         Class.forName(dbClass).newInstance();
		          Connection con = DriverManager.getConnection(url1,"cherry", "cherry");
		          java.sql.Statement stmt = con.createStatement();
		            
		       
		         ResultSet result = stmt.executeQuery("select * from user_credential");
		       
		         while(result.next())
		         {
		             
		                         
		             driver.get("https://mail.rediff.com/cgi-bin/login.cgi/");
		      
		                      
		         String Userid = result.getString("name"); // by label
		         String pass=result.getString(2);
		         
		         driver.findElement(By.id("login1")).sendKeys(Userid);
		         driver.findElement(By.id("password")).sendKeys(pass);
		         driver.findElement(By.name("proceed")).click();
		         
		         String  Title=driver.getTitle();
		                 System.out.println("Expected title is "+Title);
		         
		         Assert.assertEquals("Login Error", Title);
		         
		                                 
		         }
		       
		     
		     
		 }
		 } 
  }
}

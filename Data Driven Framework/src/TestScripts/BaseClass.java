package TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
public static WebDriver Driver;
public static Properties  prop=new Properties();

	@BeforeTest
  public void initialize() throws IOException, InterruptedException {
	  //Locate the property file
	  	FileInputStream fis=new FileInputStream("C:\\Users\\aditya.tiwari\\eclipse-workspace\\Data Driven Framework\\src\\DataMap\\Data.Property");
	  
	    prop.load(fis);
	    FileInputStream fisUIproperty=new FileInputStream("C:\\Users\\aditya.tiwari\\eclipse-workspace\\Data Driven Framework\\src\\UIProperties\\UI.Property");
	    prop.load(fisUIproperty);
	    System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");	
        Driver = new ChromeDriver();
	    Driver.get(prop.getProperty("url"));
	    //Driver.get("https://www.makemytrip.com/");
	    Driver.manage().window().maximize();
	    Thread.sleep(4000);
	  
  
  }
	
	@AfterMethod
	public void takescreenshot(ITestResult result)
	{

	    String location = "C:/dynamicscreenshots/";  //location for images
	    String methodname = result.getName(); // fetching test method name
	    try {
	        File screenshots = ((TakesScreenshot) Driver)
	                               .getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenshots,new File(location + methodname + "_" + ".png"));
	    } catch (Exception e) {
	          e.printStackTrace();
	    } finally {
	          System.out.println("screenshot taken successfully");
	    }
	}
	
	
//	@AfterTest
	//public void Logout() {
	//	Driver.quit();
	//}

}

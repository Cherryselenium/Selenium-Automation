package TestScripts;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Takescreenshots extends BaseClass {
  //@Test
@AfterMethod
public void takescreenshot(ITestResult result)
{

    String location = "C:/dynamicscreenshots/";  //location for images
    String methodname = result.getName(); // fetching test method name
    try {
        File screenshots = ((TakesScreenshot) Driver)
                               .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(
            screenshots,
            new File(location + methodname + "_" + ".png"));
    } catch (Exception e) {
          e.printStackTrace();
    } finally {
          System.out.println("screenshot taken successfully");
    }
}
}

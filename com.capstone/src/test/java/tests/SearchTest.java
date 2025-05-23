package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SearchPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class SearchTest extends TestBase1 {
   


    @Test
    public void testSearchApple() throws Exception {
        searchPage.searchProduct("apple");

        
        if (!searchPage.isApplePresentInTitle()) {
            captureScreenshot("Search_Failed");
        
        }
        
    }

   


    // Screenshot method 
    public void captureScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

       
        File targetFile = new File(".//screenshot/" + fileName + ".png");
        
        FileUtils.copyFile(src, targetFile);

        
    }
}


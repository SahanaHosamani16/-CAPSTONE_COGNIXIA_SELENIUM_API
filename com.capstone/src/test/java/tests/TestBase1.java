package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import pages.MegaMenu;
import pages.SearchPage;

public class TestBase1 {
	
	 WebDriver driver;
	    SearchPage searchPage;
	    MegaMenu megaPage;

	 @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://ecommerce-playground.lambdatest.io/");
	        searchPage = new SearchPage(driver);
	        megaPage = new MegaMenu(driver);
	    }

	 
	 @AfterTest
	  	public void closeApp() throws Exception {

	  		Thread.sleep(7000);
	  		System.out.println("========closeApp==========");
	  		driver.close();
	  		driver.quit();

	  	}
}

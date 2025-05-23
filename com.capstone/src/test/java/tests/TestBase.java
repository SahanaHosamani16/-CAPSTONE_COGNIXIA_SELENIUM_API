package tests;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginInvalidCredential;
import pages.LoginvalidCredential;



public class TestBase {

	WebDriver driver;
	Logger Log;
	LoginInvalidCredential liv;
	 LoginvalidCredential lv;

	

	@BeforeTest
	public void launchApp() throws Exception {
FileInputStream fis=new FileInputStream("C:\\Users\\sahana.hosamani\\eclipse-workspace\\com.capstone\\testdata\\config.properties");  //windows and non-win
		
		Properties prop=new Properties();
		
		prop.load(fis);
		Log = Logger.getLogger("Lambda Application");
		PropertyConfigurator.configure("./testData\\log4j.properties");

		Log.info("========launchApp==========");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Log.info("application URL: " +prop.getProperty("lambdaApp"));
		
		driver.get(prop.getProperty("lambdaApp"));
		


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		
		liv = new LoginInvalidCredential(driver);
		lv=new  LoginvalidCredential(driver);

		


	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(7000);
		Log.info("========closeApp==========");
		driver.close();
		driver.quit();

	}

}


package pages;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginvalidCredential {

	WebDriver driver;
	Logger Log;

	public LoginvalidCredential(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//    By loginBtn = By.xpath("//input[@value='Login']");

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	By alertMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");

	By username = By.xpath("//input[@placeholder=\"E-Mail Address\"]");
	By password = By.xpath("//input[@placeholder=\"Password\"]");

	public void VerifyvalidCredentials() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\sahana.hosamani\\eclipse-workspace\\com.capstone\\testdata\\config.properties"); // windows
																												// and
																												// non-win
		Properties prop = new Properties();
		prop.load(fis);
		
		Log = Logger.getLogger("Lambda Application started");

		PropertyConfigurator.configure("./testData\\log4j.properties");

		Log.info("enter username: " + prop.getProperty("username"));
		driver.findElement(username).sendKeys(prop.getProperty("username"));
		Thread.sleep(2000);

		Log.info("enter password: " + prop.getProperty("password"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
	}

	public void clickLogin() {
		Log.info("Click on Login button");
		loginBtn.click();
	}

	public void logoutbtn() throws InterruptedException {
		Log.info("Click on Logout button");
		driver.findElement(By.partialLinkText("ogo")).click();

		Log.info("Application title, after logout sucessful:" + driver.getTitle());
		Log.info("Application URL, after logout sucessful:" + driver.getCurrentUrl());
		Thread.sleep(3000);

	}

//

}


package pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInvalidCredential {

	WebDriver driver;

	public LoginInvalidCredential(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	By alertMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");

	By username = By.xpath("//input[@placeholder=\"E-Mail Address\"]");
	By password = By.xpath("//input[@placeholder=\"Password\"]");

	public void VerifyInvalidCredentials() {
		driver.findElement(username).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");


	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void verifyLoginMessage() {
		String message = driver.findElement(alertMessage).getText();
		Assert.assertTrue("Expected warning message not found.",
				message.contains("Warning: Your account has exceeded allowed number of login attempts"));
	}
}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MegaMenu {
    WebDriver driver;

    public MegaMenu(WebDriver driver) {
        this.driver = driver;
    }

    By megaMenu = By.linkText("Mega Menu");
    By appleLink = By.linkText("Apple");

    public void hoverAndClickApple() {
//        WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(megaMenu));
    	 WebElement menu=driver.findElement(megaMenu);

        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);

        
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();

        
//        WebElement apple = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(appleLink));
        WebElement apple=driver.findElement(appleLink);
        
        apple.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

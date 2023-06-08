package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    // true - element is visible and displayed
    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    // true - element is clickable and enabled
    public boolean isInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    // get actual URL
    public String getURL() {
        return driver.getCurrentUrl();
    }
}


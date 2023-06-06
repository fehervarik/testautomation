package CucmberPages;

import CucmberPages.BasePage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenPage extends BasePage2 {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span")
    WebElement acceptButton;

    public OpenPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU/");
        assertTrue(isLoaded(acceptButton));
        // assert
    }

    public void acceptCookies() {
        acceptButton.click();
    }
}

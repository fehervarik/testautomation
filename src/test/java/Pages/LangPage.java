package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.xpath;

public class LangPage extends BasePage {

    public LangPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"utility-header-language-switch-link\"]/span/span")
    WebElement langButton;

    @FindBy(css = "#utility-header-registration-link > span")
    WebElement regButton;

    public void lang() {
        if (langButton.equals("magyar")) {
            driver.findElement(xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")).click();
        }

        if (langButton.equals("english")) {
            driver.findElement(xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")).click();
        }
    }

    public void validation() {

        if (langButton.equals("magyar")) {
            assertEquals("Register", regButton.getText()); // org.junit
        }
        if (langButton.equals("english")) {
            assertEquals("Regisztráció", regButton.getText()); // org.junit
        }
    }

}

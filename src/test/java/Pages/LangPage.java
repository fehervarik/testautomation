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

    /* nyelvváltás abban az esetben, ha ténylegesen váltani kell en -> hu, hu -> en */
    public void changeLang(String language) {
        if ((langButton.getText().equals("Magyar") &&
                language.equals("magyar")) ||
                (langButton.getText().equals("English") &&
                        language.equals("angol"))) {
            langButton.click();
        }
    }

    public void validation(String language) {

        if (language.equals("angol")) {
            assertEquals("Magyar", langButton.getText());
            assertEquals("Register", regButton.getText());
        }
        if (langButton.getText().equals("magyar")) {
            assertEquals("English", langButton.getText());
            assertEquals("Regisztráció", regButton.getText());
        }
    }

}

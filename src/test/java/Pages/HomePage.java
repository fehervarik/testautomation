package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span")
    WebElement acceptButton;

    @FindBy(xpath = "//*[@id=\"search-form\"]/button")
    WebElement searchButton;

    //@FindBy(xpath = "//*[@id=\"inside_header__autoComplete__input\"]/div/input")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/header/div/div[2]/div/form/div/div[1]/div/input")
    WebElement searchInput;


    public HomePage(WebDriver driver) {
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

    public void search(String product) {
        searchInput.click();
        searchInput.sendKeys(product);
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //bker mező keresés
        // kitölt senfKeys a product változóval
        //nagyító ikonra kattint
        //
    }


}

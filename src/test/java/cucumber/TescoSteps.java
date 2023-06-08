package cucumber;

import Pages.LangPage;
import Pages.SearchResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.HomePage;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {
    protected static WebDriver driver;

    protected static WebDriverWait wait;


    @Before
    public static void setup() throws IOException {

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TescoSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }

    @After
    public static void cleanup() {
        driver.quit();
    }

    HomePage homePage = new HomePage(driver);
    LangPage lang = new LangPage(driver);

    SearchResultPage searchResultPage = new SearchResultPage(driver);

    @Given("open main page")
    public void openMainPage() {
        homePage.open();
    }

    @And("accept cookies")
    public void acceptCookies() {
        homePage.acceptCookies();
    }

    @And("language is set to {string}")
    public void languageIsSetTo(String language) {
        lang.changeLang(language);
    }

    @When("change the language to {string}")
    public void change_the_language_to_language(String language) {
        lang.changeLang(language);
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String language) {
        lang.validation(language);
    }


    @When("user search for product {string}")
    public void userSearchForProduct(String product) {
        homePage.search(product);
    }

    @Then("it shows {string}")
    public void itShows(String numOfProd) {
        searchResultPage.searchResult(numOfProd);
    }

    @Then("it shows error message for {string}")
    public void itShowsErrorMessageFor(String invalidProductName) {
        searchResultPage.searchEmptyResult(invalidProductName);
    }
}

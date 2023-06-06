package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import CucmberPages.OpenPage;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"search-input\"]")
    WebElement searchButton;

    //public static Logger log = LogManager.getLogger();
       @Before // cucumber annotáció
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TescoSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));


        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }

    @After
    public static void cleanup() {
        driver.quit();
    }

  //  @BeforeStep
  //  public void screenshot() {
   //     log.info("Take screenshot");
   //     Utils.takeSnapShot(driver);
  //  }

    OpenPage openPage = new OpenPage(driver);
    @Given("open main page")
    public void openMainPage() {
        openPage.open();
    }

    @And("accept cookies")
    public void acceptCookies() {
        openPage.acceptCookies();
    }

    @And("language is set to {string}")
    public void languageIsSetTo(String lang) {
        WebElement languageIcon = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")));
        if(lang.equals("magyar")) {
            driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")).click();
        }

        if(lang.equals("english")) {
            driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")).click();
        }

    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String newLang) {
        languageIsSetTo(newLang);
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        WebElement titleH2 = wait.until(driver -> driver.findElement(By.cssSelector("#utility-header-registration-link > span")));

        if(lang.equals("magyar")) {
            assertEquals("Regisztráció", titleH2.getText()); // org.junit
        }
        if(lang.equals("english")) {
            assertEquals("Register", titleH2.getText()); // org.junit
        }

    }


    @Given("click on search field")
    public void clickOnSearchField() {
        searchButton.click();
    }

    @When("search after <products>")
    public void searchAfterProducts() {
    }

    @Then("it shows elements in <searchedProducts>")
    public void it_shows_elements_in_searched_products() {
    }

}

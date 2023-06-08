package cucumber;

import Pages.LangPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.OpenPage;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    //    @FindBy(xpath = "//*[@id=\"search-input\"]")
    @FindBy(id = "inside_header__submit")
    WebElement searchButton;

    //@FindBy(xpath = "//*[@id=\"inside_header__autoComplete__input\"]/div/input")
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/header/div/div[2]/div/form/div/div[1]/div/input")
    WebElement searchInput;

    //public static Logger log = LogManager.getLogger();
    @Before // cucumber annotáció
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

    //  @BeforeStep
    //  public void screenshot() {
    //     log.info("Take screenshot");
    //     Utils.takeSnapShot(driver);
    //  }

    OpenPage openPage = new OpenPage(driver);
    LangPage lang = new LangPage(driver);

    @Given("open main page")
    public void openMainPage() {
        openPage.open();
    }

    @And("accept cookies")
    public void acceptCookies() {
        openPage.acceptCookies();
    }

    @And("language is set to {string}")
    public void languageIsSetTo() {
        lang.lang();
    }

    @When("change the language to {string}")
    public void change_the_language_to_language() {
        lang.lang();
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn() {
        lang.validation();
    }

    @Given("click on search field")
    public void clickOnSearchField() {
        searchButton.click();
    }

    @When("the user type in the search field {string}")
    public void theUserTypeInTheSearchField(String product) {
        System.out.println("-----------  product: " + product);
        searchInput.sendKeys(product);
    }

    @Then("it shows elements in productlist")
    public void it_shows_elements_in_productlist() {
        System.out.println("-----------  it_shows_elements_in_productlist: ");
    }

}

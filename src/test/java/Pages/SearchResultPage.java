package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class SearchResultPage extends BasePage {
    //változók létrehozása
    //  validálás
    @FindBy(className = "pagination__items-displayed")
    WebElement result;

    @FindBy(xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div/div[2]/h3")
    WebElement notFoundMsgElement;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void searchResult(String numOfProd) {
        wait.until(ExpectedConditions.visibilityOf(result));
        System.out.println("result.getText: " + result.getText());
        System.out.println("numOfProd: " + numOfProd);
        if (null != result && StringUtils.isNoneBlank(result.getText())) {
            assertTrue(StringUtils.contains(result.getText(), numOfProd));
        }
    }

    public void searchEmptyResult(String invalidProductName) {
        wait.until(ExpectedConditions.visibilityOf(notFoundMsgElement));

        System.out.println("error msg: " + notFoundMsgElement.getText());
        System.out.println("product name: " + invalidProductName);
        //ha nem null és nem üres(blank)
        if (null != notFoundMsgElement && StringUtils.isNoneBlank(notFoundMsgElement.getText())) {
            //contains tartalmazza-e a szoveget
            assertTrue(StringUtils.contains(notFoundMsgElement.getText(), invalidProductName));
        }
    }

}

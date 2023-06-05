package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    public void isLoaded(SelenideElement element) {
        element.shouldBe(visible);
    }

    public void isInteractable(SelenideElement element) {
        element.shouldBe(enabled);
    }

    public String getURL() {
        return url();
    }
}
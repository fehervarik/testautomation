package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    SelenideElement userNameInput = $(byId("email"));

    SelenideElement passwordInput = $(byId("password"));

    SelenideElement loginButton = $(byXpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/section/div/form/div/button"));

    public void openPage() {
        open("https://bevasarlas.tesco.hu/groceries/hu-HU/login?from=https%3A%2F%2Fbevasarlas.tesco.hu%2Fgroceries%2Fhu-HU%2F"); // Selenide.open()
        isLoaded(loginButton);
    }

    public void validateUI() {
        userNameInput.shouldBe(visible).shouldBe(enabled);
        passwordInput.shouldBe(visible).shouldBe(enabled);
        loginButton.shouldBe(visible).shouldBe(enabled);
    }

    public void validateTitle() {
        assertEquals("Bejelentkezés - Tesco Online, Tesco Otthonról, Tesco Doboz Webáruház", title());
    }

    public MainPage login() {
        userNameInput.setValue("utina.84@gmail.com");
        passwordInput.setValue("Jelszó123");
        loginButton.click();
        return new MainPage();
    }
}
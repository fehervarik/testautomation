package pages;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    public void validateURL() {
        assertEquals("https://bevasarlas.tesco.hu/groceries/hu-HU/", url());
    }
}

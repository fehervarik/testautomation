import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

public class TescoTest {

    @Test
    @DisplayName("TC01_Tesco login test")
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.validateTitle();
        loginPage.validateUI();
        MainPage mainPage = loginPage.login();
        Thread.sleep(2000);
    }
}
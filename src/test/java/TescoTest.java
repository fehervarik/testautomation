import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TescoTest {

    @Test
    @DisplayName("Tesco login test")
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.validateTitle();
        loginPage.validateUI();
    }
}
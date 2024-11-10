package Practice.SauceDemo.Tests;

import Practice.SauceDemo.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        browser.get(baseUrl);
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("default", "default");
    }

    @Test
    public void wrongUsernameLogin() {
        browser.get(baseUrl);
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("alex", "default");
    }
}

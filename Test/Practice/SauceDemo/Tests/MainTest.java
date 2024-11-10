package Practice.SauceDemo.Tests;

import Practice.SauceDemo.Pages.LoginPage;
import Practice.SauceDemo.Pages.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends BaseTest{

    @Test
    public void mainPageTest() {
        browser.get(baseUrl);
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("default", "default");
        MainPage mainPage = new MainPage(browser);
        mainPage.sortProducts();

        mainPage.addProductToCart(1);
        mainPage.addProductToCart(3);
        mainPage.addProductToCart(4);

        Assert.assertEquals(mainPage.getCartNr(), 3);
    }
}

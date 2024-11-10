package Practice.SauceDemo.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final String baseUrl = "https://www.saucedemo.com/";
    protected WebDriver browser;

    @BeforeMethod
    public void initDriver() {
        browser = new FirefoxDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(2000); //nu e optim, dar functioneaza pentru ce am nevoie
            browser.close();
        } catch (Exception ex) {
            browser.quit();
        }
    }
}

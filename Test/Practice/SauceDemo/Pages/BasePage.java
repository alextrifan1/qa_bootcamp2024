package Practice.SauceDemo.Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver browser;

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }
}

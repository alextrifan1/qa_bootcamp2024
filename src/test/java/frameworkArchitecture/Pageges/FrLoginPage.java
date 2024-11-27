package frameworkArchitecture.Pageges;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FrLoginPage extends FrBasePage {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "pass";
    public static final String BTN = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > button";
    public static final String GO_TO_BTN = "#svelte > div.container-fluid > div.header.sticky-top.row > div:nth-child(2) > div > a > h2 > i";
    //public static final String GO_TO_LOGOUT = "#svelte > div.container-fluid > div.header.sticky-top.row > div:nth-child(2) > div > a > h2 > i";

    public FrLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        WebElement goToBtn = driver.findElement(By.cssSelector(GO_TO_BTN));

        goToBtn.click();

        Utils.waitForElement(driver, 1, By.id(USERNAME));

        WebElement userField = driver.findElement(By.id(USERNAME));
        WebElement passwordField = driver.findElement(By.id(PASSWORD));
        WebElement logBtn = driver.findElement(By.cssSelector(BTN));

        userField.sendKeys(username);
        passwordField.sendKeys(password);
        logBtn.click();
    }

    public void logout() {
        WebElement goToLogout = driver.findElement(By.cssSelector(GO_TO_BTN));
        goToLogout.click();
    }
}

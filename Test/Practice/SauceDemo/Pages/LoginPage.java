package Practice.SauceDemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class LoginPage extends BasePage{

    private static final String USERNAME_FIELD_SELECTOR = "user-name";
    private static final String PASSWORD_FIELD_SELECTOR = "password";
    private static final String LOGIN_BUTTON_SELECTOR = "login-button";
    private static final String USERLIST_SELECTOR = "login_credentials";
    private static final String PASSWORDLIST_SELECTOR = "#root > div > div.login_wrapper > div.login_credentials_wrap > div > div.login_password";
    private static final String EPIC_SADFACE = "#login_button_container > div > form > div.error-message-container.error > h3";

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void login(String username, String password) {
        WebElement usernameField = browser.findElement(By.id(USERNAME_FIELD_SELECTOR));
        WebElement passwordField = browser.findElement(By.id(PASSWORD_FIELD_SELECTOR));
        WebElement loginButton = browser.findElement(By.id(LOGIN_BUTTON_SELECTOR));


        // implementeaza alegere utilizator
        if (username.equals("default")) {
            username = getUser();
        }
        if (password.equals("default")) {
            password = getPassword();
        }

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        /*if (isErrorPresent()) {
            System.out.println("Eroare la login. Se vor folosi datele default");

            usernameField.clear();
            passwordField.clear();
            usernameField.sendKeys("default");
            passwordField.sendKeys("default");
            loginButton.click();
        }*/


    }

    private String getUser() {
        List<WebElement> usernames = browser.findElements(By.id(USERLIST_SELECTOR));
        return usernames.get(0).getText().split("\n")[1];
    }
    private String getPassword() {
        WebElement password = browser.findElement(By.cssSelector(PASSWORDLIST_SELECTOR));
        return password.getText().split("\n")[1];
    }

    private boolean isErrorPresent() {
        try {
            WebElement error = browser.findElement(By.cssSelector(EPIC_SADFACE));
            return !error.getText().isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

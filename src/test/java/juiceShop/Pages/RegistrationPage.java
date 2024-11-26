package juiceShop.Pages;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    // register page
    private static final String REGISTER_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1";
    private static final String REGISTER_EMAIL = "emailControl";
    private static final String REGISTER_PASSWORD = "passwordControl";
    private static final String REGISTER_CONFIRM = "repeatPasswordControl";
    private static final String SECURITY_QUESTION = "securityQuestion";
    private static final String SECURITY_OPTION1 = "#mat-option-0 > span";
    private static final String SECURITY_ANSWER = "securityAnswerControl";
    private static final String REGISTER_SUBMIT_BUTTON = "registerButton";
    private static final String COOKIES_MODAL = "body > div.cc-window.cc-floating.cc-type-info.cc-theme-classic.cc-bottom.cc-right.cc-color-override--1225450786 > div > a";
    private static final String REGISTER_STATIC_TEXT = "User Registration";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getRegisterHeader() {
        return driver.findElement(By.cssSelector(REGISTER_HEADER)).getText();
    }

    public String getRegisterPageStatic() {
        return REGISTER_STATIC_TEXT;
    }

    public void register(String email, String password, String securityAnswer) {
        WebElement emailField = driver.findElement(By.id(REGISTER_EMAIL));
        WebElement passwordField = driver.findElement(By.id(REGISTER_PASSWORD));
        WebElement passwordConfirm = driver.findElement(By.id(REGISTER_CONFIRM));
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordConfirm.clear();
        passwordConfirm.sendKeys(password);
        WebElement securityQuestionDropDown = Utils.waitForElement(driver, 10, By.name(SECURITY_QUESTION));
        securityQuestionDropDown.click();
        WebElement securityQ1 =  Utils.waitForElement(driver, 5, By.cssSelector(SECURITY_OPTION1));
        securityQ1.click();
        WebElement securityAnswerField = driver.findElement(By.id(SECURITY_ANSWER));
        securityAnswerField.clear();
        securityAnswerField.sendKeys(securityAnswer);
        WebElement cookiesButton = driver.findElement(By.cssSelector(COOKIES_MODAL));
        cookiesButton.click();
        WebElement submitButton = Utils.waitForElementClickable(driver, 10, By.id(REGISTER_SUBMIT_BUTTON));
        submitButton.click();
    }
}


package frameworkArchitecture.Pageges;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class FrRegisterPage extends FrBasePage {

    private static final String USERNAME = "username"; // id
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "password2";
    private static final String TITLE_SELECTOR_MS = "Ms";
    private static final String TITLE_SELECTOR_Mr = "Mr";
    private static final String INPUT_FIRST_NAME = "input-first-name";
    private static final String INPUT_LAST_NAME = "input-last-name";
    private static final String INPUT_EMAIL = "input-email";
    private static final String INPUT_DOB = "input-dob";
    private static final String INPUT_NATIONALITY = "input-nationality";
    private static final String ROMANIA = "#input-nationality > option:nth-child(144)";
    private static final String ACCEPT_TERMS_CONDITIONS = "terms";
    private static final String REGISTRATION_BTN = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(13) > button"; // selector
    public static final String GO_TO_BTN = "#svelte > div.container-fluid > div.header.sticky-top.row > div:nth-child(2) > div > a > h2 > i";
    public static final String GO_TO_REGISTER = "#svelte > div.container-fluid > div.main.row > div.content > p:nth-child(3) > div > a";

    public FrRegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String username, String password1, String password2, String title, String firstName, String lastName, String email, String dob) {
        // mers pe pagina de login
        WebElement goToBtn = driver.findElement(By.cssSelector(GO_TO_BTN));
        goToBtn.click();
        Utils.waitForElement(driver, 1, By.cssSelector(GO_TO_REGISTER));
        // mers pe pagina register
        WebElement goToRegBtn = driver.findElement(By.cssSelector(GO_TO_REGISTER));
        goToRegBtn.click();
        Utils.waitForElement(driver, 1, By.id(USERNAME));

        WebElement usernameField = driver.findElement(By.id(USERNAME));
        WebElement passwordField = driver.findElement(By.id(PASSWORD));
        WebElement confirmPasswordField = driver.findElement(By.id(CONFIRM_PASSWORD));
        WebElement titleBtn;
        if (title.equals(TITLE_SELECTOR_Mr)) {
            titleBtn = driver.findElement(By.id(TITLE_SELECTOR_Mr));
        } else {
            titleBtn = driver.findElement(By.id(TITLE_SELECTOR_MS));
        }
        WebElement firstNameField = driver.findElement(By.id(INPUT_FIRST_NAME));
        WebElement lastNameField = driver.findElement(By.id(INPUT_LAST_NAME));
        WebElement emailField = driver.findElement(By.id(INPUT_EMAIL));
        WebElement dobField = driver.findElement(By.id(INPUT_DOB));
        WebElement nationalityBtn = driver.findElement(By.id(INPUT_NATIONALITY));
        WebElement termsBtn = driver.findElement(By.id(ACCEPT_TERMS_CONDITIONS));
        WebElement registerBtn = driver.findElement(By.cssSelector(REGISTRATION_BTN));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password1);
        confirmPasswordField.sendKeys(password2);

        titleBtn.click();

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        dobField.clear();
        dobField.sendKeys(dob);

        //nationalityBtn.sendKeys("R");
        //Actions actions = new Actions(driver);
        //actions.moveToElement(nationalityBtn).click().moveToElement(nationalityBtn,0, -10).click().build().perform(); asta nu merge

        nationalityBtn.click();
        WebElement option = driver.findElement(By.cssSelector(ROMANIA));
        option.click();


        termsBtn.click();
        registerBtn.click();
    }
}

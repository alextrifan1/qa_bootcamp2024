package juiceShop;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTests {

    static final String baseUrl = Utils.getConfigProperty("baseUrl");

    WebDriver driver;

    @Test
    public void mainPage() {
        driver.get(baseUrl + "/#/");
        WebElement pageText = driver.findElement(By.cssSelector(Selectors.ALL_PRODUCTS_SELECTOR));
        Assert.assertEquals(pageText.getText(), "All Products");
    }
    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"", "Alex98876%", "alex", "Please provide an email address."});
        dp.add(new String[] {"alex@", "Alex98876%", "alex", "Email address is not valid."});
        dp.add(new String[] {"alex@alex.com", "", "alex", "Please provide a password."});
        dp.add(new String[] {"alex@alex.com", "Ale", "alex", "Password must be 5-40 characters long."});
        dp.add(new String[] {"alex@alex.com", "Alex98876%", "", "Please provide an answer to your security question."});
        return dp.iterator();
    }
    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister(String username, String password, String securityAns) {
        driver.get(baseUrl + "/#/login");
        WebElement dismissModalElement = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.MODAL_OK_BUTTON)
        );
        dismissModalElement.click();
        WebElement registerLink = driver.findElement(By.cssSelector(Selectors.REGISTER_URL));
        registerLink.click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector(Selectors.REGISTER_HEADER)).getText(),
                "User Registration"
        );
        WebElement usernameElement = driver.findElement(By.id(Selectors.REGISTER_EMAIL));
        usernameElement.clear();
        usernameElement.sendKeys("alex@alex.com");
        WebElement passwordElement = driver.findElement(By.id(Selectors.REGISTER_PASSWORD));
        passwordElement.clear();
        passwordElement.sendKeys("Alex98765$");
        WebElement passwordConfirm = driver.findElement(By.id(Selectors.REGISTER_CONFIRM));
        passwordConfirm.clear();
        passwordConfirm.sendKeys("Alex98765$");
        WebElement securityQuestion = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.SECURITY_QUESTION)
        );
        securityQuestion.click();
        WebElement securityQuestionChoice = driver.findElement(By.cssSelector(Selectors.SECURITY_OPTION1));
        securityQuestionChoice.click();
        WebElement securityAnswer = driver.findElement(By.id(Selectors.SECURITY_ANSWER));
        securityAnswer.clear();
        securityAnswer.sendKeys("alex");
        WebElement submitButton = driver.findElement(By.id(Selectors.REGISTER_SUBMIT_BUTTON));
        submitButton.click();
    }

    //////////////////////////////////////  tema  //////////////////////////////////////

    public static final String EMAIL_EMPTY_SELECTOR = "#mat-error-16";
    public static final String EMAIL_BAD_SELECTOR = "#mat-error-13";
    public static final String PASSWORD_EMPTY_SELECTOR = "#mat-error-14";
    public static final String PASSWORD_SHORT_SELECTOR = "#mat-error-15";
    public static final String SECURITY_EMPTY_SELECTOR = "#mat-error-10";

    @Test(dataProvider = "RegistrationDataProvider")
    public void negativeRegister(String username, String password, String securityAns, String expectedMsg) {
        driver.get(baseUrl + "/#/login");
        WebElement dismissModalElement = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.MODAL_OK_BUTTON)
        );
        dismissModalElement.click();
        WebElement registerLink = driver.findElement(By.cssSelector(Selectors.REGISTER_URL));
        registerLink.click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector(Selectors.REGISTER_HEADER)).getText(),
                "User Registration"
        );
        WebElement usernameElement = driver.findElement(By.id(Selectors.REGISTER_EMAIL));
        usernameElement.clear();
        usernameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.id(Selectors.REGISTER_PASSWORD));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement passwordConfirm = driver.findElement(By.id(Selectors.REGISTER_CONFIRM));
        passwordConfirm.clear();
        passwordConfirm.sendKeys(password);

        WebElement securityAnswer = driver.findElement(By.id(Selectors.SECURITY_ANSWER));
        securityAnswer.clear();
        securityAnswer.sendKeys(securityAns);

        WebElement submitButton = driver.findElement(By.id(Selectors.REGISTER_SUBMIT_BUTTON));
        submitButton.click();

        WebElement errorMsgElement = null;
        if (username.isEmpty()) {
            errorMsgElement = driver.findElement(By.id(EMAIL_EMPTY_SELECTOR));
        } else if (!username.matches("^[a-zA-Z]@[a-zA-Z]$")) {
            errorMsgElement = driver.findElement(By.id(EMAIL_BAD_SELECTOR));
        } else if (password.isEmpty()) {
            errorMsgElement = driver.findElement(By.id(PASSWORD_EMPTY_SELECTOR));
        } else if (password.length() < 5 || password.length() > 40) {
            errorMsgElement = driver.findElement(By.id(PASSWORD_SHORT_SELECTOR));
        } else if (securityAns.isEmpty()) {
            errorMsgElement = driver.findElement(By.id(SECURITY_EMPTY_SELECTOR));
        }


        if (errorMsgElement != null) {
            Assert.assertEquals(errorMsgElement.getText(), expectedMsg, "erori diferite");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void login01(){

        driver.get(baseUrl + "/#/login");
//        WebElement dismissModalElement = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted > span.mat-button-wrapper > mat-icon"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dismissModalElement = wait.until(
//                ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted > span.mat-button-wrapper > mat-icon")));
        WebElement dismissModalElement = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.MODAL_OK_BUTTON)
        );
        dismissModalElement.click();

        WebElement loginElement = driver.findElement(By.id(Selectors.USERNAME_ID));
        loginElement.sendKeys("alex@alex.com");

//        driver.findElement(By.id("email")).sendKeys("alex@alex.com");
        WebElement passwordElement = driver.findElement(By.id(Selectors.PASSWORD_ID));
        passwordElement.sendKeys("Abc123$");

        WebElement submitButton = driver.findElement(By.id(Selectors.SUBMIT_ID));
        submitButton.click();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        }
        catch (Exception ex) {
            driver.quit();
        }
    }

}
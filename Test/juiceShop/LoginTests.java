package juiceShop;

import frameworkUtils.Utils;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
   static final String baseurl = "http://57.151.123.81:3000";

    @BeforeMethod
    public void initDriver() {
        driver = Utils.getDriver();
    }
    @Test
    public void MainPage() {
        driver.get(baseurl);
    }

    @Test
    public void login01() {
        driver.get(baseurl + "/#/login");


        WebElement dismisModal = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted > span.mat-button-wrapper > mat-icon"));
        dismisModal.click();
        //inspect element, copy in bara de inspect la selector

        WebElement loginElement = driver.findElement(By.id("email"));
        loginElement.sendKeys("alex@alex.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Abc123$");

        WebElement submitButton = driver.findElement(By.id("loginButton"));
        submitButton.click();

    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        } catch (Exception ex) {
            throw ex;
        }
    }
}

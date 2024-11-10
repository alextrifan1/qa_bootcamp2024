package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExCurs1 {

    private static final String OK_TERMS_BUTTON = "#L2AGLb > div";

    @Test
    public static void test01() {
        //init browser
        WebDriver browser = new ChromeDriver();
        browser.get("http://www.google.com");

        //dismiss the terms&services popup
        WebDriverWait wait1 = new WebDriverWait(browser, Duration.ofSeconds(5));
        WebElement dismissModalElement = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OK_TERMS_BUTTON)));
        dismissModalElement.click();
        //sau foloseste metdoda din utils utils

        //
        WebElement searchBox = browser.findElement(By.name("q"));
        searchBox.sendKeys("koala", Keys.RETURN); //Keys.RETURN apasa enter

        //asteapta sa se incarce rezultatele
        //ctrl-f in inspect ca sa gasesti resultStats
        /*WebElement myDynamicElement = (new WebDriverWait(browser, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        System.out.println(myDynamicElement.getText());
        cred ca s a schimbat id ul, aici apare eroare
        */

        List<WebElement> resultTitleElements = browser.findElements(By.xpath("/html/body/div[3]/div/div[13]/div[1]/div[2]/div[2]/div/div/div[7]/div/style/text()"));//aici gaseste 0 elemente, nici cu xpath
        System.out.println(resultTitleElements.size());
        //...
    }
}

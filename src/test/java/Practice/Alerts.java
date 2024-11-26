package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {
    @Test
    public void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        WebElement btn = driver.findElement(By.cssSelector("body > main > div > div > div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(5) > button"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Alex");
        alert.accept();

        driver.quit();
    }
}

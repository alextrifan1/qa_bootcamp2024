package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Cookies {
    @Test
    public void cookies() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("http://google.com");

        //WebElement dismissModal = browser.findElement(By.className("#tHlp8d"));
        //dismissModal.click();
        Set<Cookie> setOfCookies = browser.manage().getCookies();
        System.out.println("Found " + setOfCookies.size() + "cookies");

        for (Cookie c : setOfCookies)
        {
            System.out.println("Cookie name: " + c.getName()); System.out.println("Cookie value: " +
                c.getValue());
        }

        Cookie cookie = new Cookie("test", "valoare test");
        browser.manage().addCookie(cookie);

        Cookie c = browser.manage().getCookieNamed("test");
        System.out.println("cookie name " + c.getName());
        System.out.println("cookie value " + c.getValue());

        browser.quit();
    }
}

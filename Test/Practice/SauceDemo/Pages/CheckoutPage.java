package Practice.SauceDemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver browser) {
        super(browser);
    }

    public void checkout() {
        WebElement checkout = browser.findElement(By.id("checkout"));
        checkout.click();
    }

    public void goToCheckout() {
        WebElement shoppingCart = browser.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
    }

    public void checkoutInfo(String fName, String lName, String zipCode) {
        WebElement fNameForm = browser.findElement(By.id("first-name"));
        WebElement lNameForm = browser.findElement(By.id("last-name"));
        WebElement zipForm = browser.findElement(By.id("postal-code"));
        WebElement continueBt = browser.findElement(By.id("continue"));

        fNameForm.clear();
        lNameForm.clear();
        zipForm.clear();

        fNameForm.sendKeys(fName);
        lNameForm.sendKeys(lName);
        zipForm.sendKeys(zipCode);

        continueBt.click();
    }

    public void finish() {
        WebElement fin = browser.findElement(By.id("finish"));
        fin.click();
    }
    public void backToProducts() {
        WebElement backTo = browser.findElement(By.id("back-to-products"));
        backTo.click();
    }
}

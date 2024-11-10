package Practice.SauceDemo.Pages;

import com.sun.jdi.ByteValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static juiceShop.frameworkUtils.Utils.waitForElement;

public class MainPage extends BasePage{

    public static final String SORT_PRODUCTS_SELECTOR = "#header_container > div.header_secondary_container > div > span > select";
    public static final String AZ_SORT = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)";
    public static final String ZA_SORT = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)";
    public static final String HILO_SORT = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)";
    public static final String LOHI_SORT = "#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)";
    public static final String ALL_PROD_SELECTOR = "inventory_item_name";
    public static final String ADD_TO_CART_BUTTON = "add-to-cart";

    public MainPage(WebDriver browser) {
        super(browser);
    }

    public List<WebElement> getProducts() {
        //WebElement products = browser.findElement(By.cssSelector(ALL_PRODUCTS_SELECTOR));
        List<WebElement> products = browser.findElements(By.className(ALL_PROD_SELECTOR));
        return products;
    }

    public void sortProducts() {
        for (String sortSelector : new String[]{AZ_SORT, ZA_SORT, HILO_SORT, LOHI_SORT}) {

            WebElement sortButton = browser.findElement(By.cssSelector(SORT_PRODUCTS_SELECTOR));
            sortButton.click();

            waitForElement(browser, 2, By.cssSelector(sortSelector));

            WebElement sortOption = browser.findElement(By.cssSelector(sortSelector));
            sortOption.click();
        }
    }

    public void addProductToCart(int nr) {
        List<WebElement> products = browser.findElements(By.className(ALL_PROD_SELECTOR)); // :(
        products.get(nr).click();
        WebElement addToCart = browser.findElement(By.id(ADD_TO_CART_BUTTON));
        addToCart.click();
        browser.navigate().back();
    }

    public int getCartNr() {
        WebElement cartCount = browser.findElement(By.className("shopping_cart_badge"));
        return Integer.parseInt(cartCount.getText());
    }



}

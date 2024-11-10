package Practice.SauceDemo.Tests;

import Practice.SauceDemo.Pages.CheckoutPage;
import Practice.SauceDemo.Pages.LoginPage;
import Practice.SauceDemo.Pages.MainPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void buyProductsTest() {
        browser.get(baseUrl);
        LoginPage lp = new LoginPage(browser);
        MainPage mp = new MainPage(browser);
        CheckoutPage ck = new CheckoutPage(browser);

        lp.login("default", "default");
        mp.addProductToCart(2);
        mp.addProductToCart(1);
        ck.goToCheckout();
        ck.checkout();
        ck.checkoutInfo("alex", "trifan", "888");
        ck.finish();
        ck.backToProducts();
    }
}

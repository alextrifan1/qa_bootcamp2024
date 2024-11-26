package juiceShop.Tests;

import juiceShop.Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MainTest extends BaseTest{
    @Test
    public void mainPageTest() {
        driver.get(baseUrl + "/#/");
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getProductsText(), mp.getProductsStaticText());
    }
}
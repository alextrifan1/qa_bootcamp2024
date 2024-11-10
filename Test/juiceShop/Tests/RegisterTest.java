package juiceShop.Tests;

import juiceShop.Pages.LoginPage;
import juiceShop.Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest{
    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex@alex.com", "Alex98876%", "alex"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister2(String username, String password, String securityAns) {
        driver.get(baseUrl + "/#/login");
        LoginPage lp = new LoginPage(driver);
        lp.awaitDismissModal();
        lp.newUser();
        RegistrationPage rp = new RegistrationPage(driver);
        Assert.assertEquals(rp.getRegisterHeader(), rp.getRegisterPageStatic());
        rp.register(username, password, securityAns);
    }

}
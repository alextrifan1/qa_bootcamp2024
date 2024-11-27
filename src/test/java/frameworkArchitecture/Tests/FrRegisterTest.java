package frameworkArchitecture.Tests;

import frameworkArchitecture.Pageges.FrRegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static frameworkArchitecture.Selectors.*;

public class FrRegisterTest extends FrBaseTest {
    @DataProvider(name = "ValidRegisterUsers")
    public Iterator<Object[]> validRegisterUsersDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex", "anaaremere1", "anaaremere1", "Mr", "alex", "trifan", "alext@gmail.com", "02/17/2004"});
        dp.add(new String[] {"taar1", "anaaremere2", "anaaremere2", "Ms", "maria", "oprea", "mop22@gmail.com", "01/27/2020"});
        dp.add(new String[] {"taar_1", "anaaremere2", "anaaremere2", "Ms", "maria", "oprea", "mop22@gmail.com", "01/27/2020"});
        return dp.iterator();
    }
    @DataProvider(name = "InvalidRegisterUsers")
    public Iterator<Object[]> invalidRegisterUsersDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"a", "anaaremere1", "anaaremere1", "Mr", "Alex", "Trifan", "alext@gmail.com", "02/17/2004"});
        dp.add(new String[]{"alex", "anaaremere1", "ana", "Mr", "Alex", "Trifan", "alext@gmail.com", "02/17/2004"});
        return dp.iterator();
    }

    @Test(dataProvider = "ValidRegisterUsers")
    public void validRegisterTest(String username, String password1, String password2, String title, String fName, String lName, String email, String dob) {
        driver.get(webStubsUrl);
        FrRegisterPage rp = new FrRegisterPage(driver);
        rp.register(username, password1, password2, title, fName, lName, email, dob);
        Assert.assertEquals(driver.findElement(By.cssSelector(WELCOME_MSG)).getText(), "Welcome to web-stubs, " + username + "!");
    }

    @Test(dataProvider = "InvalidRegisterUsers")
    public void invalidRegisterTest(String username, String password1, String password2, String title, String fName, String lName, String email, String dob) {
        driver.get(webStubsUrl);
        FrRegisterPage rp = new FrRegisterPage(driver);
        rp.register(username, password1, password2, title, fName, lName, email, dob);
        if (username.length() < 4 || username.length() > 35) {
            Assert.assertEquals(driver.findElement(By.cssSelector(LONGER_USERNAME)).getText(), "Please choose a longer username");
        }
        if (!password1.equals(password2)) {
            Assert.assertEquals(driver.findElement(By.cssSelector(PASSWORDS)).getText(), "Passwords do not match");
        }
    }
}

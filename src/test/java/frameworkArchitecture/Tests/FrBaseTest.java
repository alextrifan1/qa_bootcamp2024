package frameworkArchitecture.Tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FrBaseTest {
    protected static final String webStubsUrl = Utils.getConfigProperty("webStubsUrl");
    protected WebDriver driver;
    @BeforeMethod
    public void initDriver() {
        driver = Utils.getDriver();
    }
    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        }
        catch (Exception ex) {
            driver.quit();
        }
    }
}

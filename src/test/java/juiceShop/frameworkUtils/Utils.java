package juiceShop.frameworkUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Utils {

    private static final String configFile = "config.properties";

    public static String getConfigProperty(String property) {

        Properties configProps = new Properties();
        String baseUrl = "";

        try {
            configProps.load(new FileInputStream(configFile));
            baseUrl = configProps.getProperty(property).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return baseUrl;
    }

    public static WebDriver getDriver() {
        String browser = getConfigProperty("browser");
        WebDriver driver;

        switch (browser) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                if(Boolean.parseBoolean(getConfigProperty("headless"))) {
                    options.addArguments("--headless");

                }
                //options.setCapability("proxy", proxy);
                driver = new ChromeDriver(options);
                if(Boolean.parseBoolean(getConfigProperty("maximized"))) {
                    driver.manage().window().maximize();
                }
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                break;
            }
            default: {
                driver = new ChromeDriver();
            }
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //va astepta 5 sec pt fiecare elem din pagina, peste tot in cod
                                                                            //pt ca folosim get driver
        return driver;
    }

    public static WebElement waitForElement(WebDriver driver, long seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementClickable(WebDriver driver, long seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static int generateRandomNumber(int maxNumber) {
        Random rand = new Random();
        return rand.nextInt(maxNumber) ;
    }
    public static void serializeToFile(Object classObject, String fileName) {
        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(classObject);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object deserializeFromFile(String fileName) {
        Object deserializeObject =null;
        try {
            FileInputStream fileStream = new FileInputStream(new File(fileName));
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            deserializeObject = objectStream.readObject();
            objectStream.close();
            fileStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializeObject;
    }

}

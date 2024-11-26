package petStore;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static String petStoreUrl = "https://petstore.swagger.io/v2";
    protected  RequestSpecification httpRequest;
    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = petStoreUrl;
        httpRequest = RestAssured.given();
    }
}

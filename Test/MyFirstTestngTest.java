import org.testng.annotations.*;

public class MyFirstTestngTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("running -> before suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("running - > before class");
    }

    @BeforeGroups()
    public void beforeGroups() {
        System.out.println("running -> before groups");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("running -> before test");
    }

    @BeforeMethod
    public  void beforeMethod() {
        System.out.println("running -> before method");
    }

    @Test(testName = "MyFirstTest", description = "this is my first testNG test", groups = {"basicTest"}, priority = 2)//grija sa fie din testng nu junit
    public void test01() {
        System.out.println("my first testng test");
    }


    @Test(groups = {"print"})
    public void test02() {
        printSomething("Test02");
    }

    @Test(groups = {"print"}, enabled = false)
    public void test03() {
        printSomething("Test03");
    }

    private void printSomething(String something) {
        System.out.println("Printing something: " + something);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("running -> after method");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("running -> after test");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("running -> after groups");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("running -> after class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("running -> after suite");
    }
}

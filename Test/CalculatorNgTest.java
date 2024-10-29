import Testare.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalculatorNgTest {
    Calculator c;
    final String addFailMsg = "addition failed.";
    final String subFailMsg = "subtraction failed.";
    final String mulFailMsg = "multiplication failed.";
    final String divFailMsg = "divison failed.";
    final String sqrtFailMsg = "sqrt failed.";

    @DataProvider
    public Object[][] calculatorDataProviderClassic() {
        return new Object[][] {
                {100, 20, 80, "+", addFailMsg},
                {1000, 555, 445, "+", addFailMsg},
                {1, 0, 1, "+", addFailMsg}
        };
    }
    @DataProvider
    public Iterator<Object[]> calculatorDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new Object[]{100, 20, 80, "+", addFailMsg});
        dp.add(new Object[]{1000, 555, 445, "+", addFailMsg});
        return dp.iterator();
    }

    @BeforeMethod
    @BeforeGroups(groups = {"addition", "calculator"})
    @BeforeTest
    @BeforeClass
    @BeforeSuite
    public void setUp() {
        c = new Calculator();
    }

    @Test(testName = "AdditionPositive", groups = {"addition", "calculator"})
    public void test01() {
        Assert.assertEquals(37, c.compute(24, 13, "+"), "Addition fails");
    }

    @Test(testName = "AdditionNegatives", groups = {"addition", "calculator"})
    public void test02() {
        Assert.assertEquals(-23, c.compute(-11, -12, "+"), "Addition fails");
    }

    @Test(testName = "AddParams", groups = {"addition", "calculator"})
    @Parameters({"exp", "d1", "d2", "op", "errMsg"})
    public void test03(String exp, String d1, String d2, String op, String errMsg) {
        Assert.assertEquals(Double.parseDouble(exp), c.compute(Double.parseDouble(d1), Double.parseDouble(d2), op), errMsg);
    }

    @Test(testName = "AdditionDataProviderClasic", groups = {"addition", "calculator"}, dataProvider = "calculatorDataProviderClassic")
    public void test05(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }

    @Test(testName = "AdditionDataProviderClasic", groups = {"addition", "calculator"}, dataProvider = "calculatorDataProvider")
    public void test06(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }


    /// tests for "-"
    @DataProvider
    public Object[][] SubtractionDP() {
        return new Object[][] {
                {0, 10, 10, "-", subFailMsg},
                {75 ,100, 25, "-", subFailMsg},
                //{0.3, 1, 0.7, "-", subFailMsg}, cum fac sa am 0.300000004 fara sa pun eu de mana
                {-20, -18, 2, "-", subFailMsg},
                {10, -20, -30, "-", subFailMsg},
                {999, 999, 0, "-", subFailMsg},
                {25, 20, -5, "-", subFailMsg},
        };
    }
    @Test(testName = "SubtractionPositiveNegative", groups = {"subtraction", "calculator"}, dataProvider = "SubtractionDP")
    public void test_subtractionPositive(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }

    /// tests for "*"
    @DataProvider
    public Object[][] MultiplicationDP() {
        return new Object[][] {
                {0, 111, 0, "*", mulFailMsg},
                {-100 ,10, -10, "*", mulFailMsg},
                {0.4, 0.8, 0.5, "*", mulFailMsg},
                {144, 12, 12, "*", mulFailMsg},
                {600, -20, -30, "*", mulFailMsg},
        };
    }
    @Test(testName = "MultiplicationPositiveNegative", groups = {"multiplication", "calculator"}, dataProvider = "MultiplicationDP")
    public void test_multiplication(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }

    ///tests for "/"
    @DataProvider
    public Object[][] DivisionDP() {
        return new Object[][] {
                {0, 0, 111, "/", divFailMsg},
                {-1 ,10, -10, "/", divFailMsg},
                {1, 12, 12, "/", divFailMsg},
                {-3, -30, 10, "/", divFailMsg},
        };
    }

    @Test(testName = "DivisionNonZero", groups = {"divison", "calculator"}, dataProvider = "DivisionDP")
    public void test_divison01(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }

    @Test(testName = "DivionZero", groups = {"divison", "calculator"}, expectedExceptions = IllegalArgumentException.class)
    public void test_divison02() {
        double exp = 777;
        double d1 = 777;
        double d2 = 0;
        String op = "/";
        Assert.assertEquals(exp, c.compute(d1, d2, op), divFailMsg);
    }

    // tests for sqrt
    @DataProvider
    public Object[][] SQRTDP() {
        return new Object[][] {
                {0, 0, 111, "SQRT", sqrtFailMsg},
                //{,-1, -10, "SQRT", sqrtFailMsg}, NaN -> exceptie?
                {2, 4, 12, "SQRT", divFailMsg},
        };
    }

    @Test(testName = "sqrt", groups = {"sqrt", "calculator"}, dataProvider = "SQRTDP")
    public void test_sqrt(double exp, double d1, double d2, String op, String msg) {
        Assert.assertEquals(exp, c.compute(d1, d2, op), msg);
    }

}

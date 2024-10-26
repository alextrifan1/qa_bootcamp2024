import Testare.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalculatorNgTest {
    Calculator c;
    final String addFailMsg = "addition failed.";

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

}

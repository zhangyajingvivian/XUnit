package unit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-15 6:09 PM
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJunit4DemoChildern extends TestJunit4Demo{

    @BeforeClass
    public static void beforeAllTestCaseChildern() {
        System.out.println("unit.TestJunit4DemoChildern before all test case");
    }

    @AfterClass
    public static void afterAllTestCaseChildern() {
        System.out.println("unit.TestJunit4DemoChildern after all test case");
    }

    @Before
    public void beforeTestCaseChildern() {
        System.out.println("unit.TestJunit4DemoChildern i am @before");
    }

    @After
    public void afterTestCaseChildern() {
        System.out.println("unit.TestJunit4DemoChildern i am @after");
    }

    @Test
    public void testDemo1Childern() {
        System.out.println("unit.TestJunit4DemoChildern testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2Childern() {
        System.out.println("unit.TestJunit4DemoChildern testDemo2");
        assertTrue(false);
    }

    @Test
    public void testDemo3Childern() {
        System.out.println("unit.TestJunit4DemoChildern testDemo3");
        assertTrue(false);
    }
}

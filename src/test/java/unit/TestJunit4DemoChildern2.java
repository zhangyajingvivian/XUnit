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
public class TestJunit4DemoChildern2 extends TestJunit4Demo {

    @BeforeClass
    public static void beforeAllTestCaseChildern2() {
        System.out.println("unit.TestJunit4DemoChildern2 before all test case");
    }

    @AfterClass
    public static void afterAllTestCaseChildern2() {
        System.out.println("unit.TestJunit4DemoChildern2 after all test case");
    }

    @Before
    public void beforeTestCaseChildern2() {
        System.out.println("unit.TestJunit4DemoChildern2 i am @before");
    }

    @After
    public void afterTestCaseChildern2() {
        System.out.println("unit.TestJunit4DemoChildern2 i am @after");
    }

    @Test
    public void testDemo1Childern2() {
        System.out.println("unit.TestJunit4DemoChildern2 testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2Childern2() {
        System.out.println("unit.TestJunit4DemoChildern2 testDemo2");
        assertTrue(false);
    }

    @Test
    public void testDemo3Childern2() {
        System.out.println("unit.TestJunit4DemoChildern2 testDemo3");
        assertTrue(false);
    }
}

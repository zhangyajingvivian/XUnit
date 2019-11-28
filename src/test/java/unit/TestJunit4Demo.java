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
public class TestJunit4Demo {

    @BeforeClass
    public static void beforeAllTestCase() {
        System.out.println("before all test case");
    }

    @AfterClass
    public static void afterAllTestCase() {
        System.out.println("after all test case");
    }

    @Before
    public void beforeTestCase() {
        System.out.println("i am @before");
    }

    @After
    public void afterTestCase() {
        System.out.println("i am @after");
    }

    @Test
    public void testDemo1() {
        System.out.println("testDemo1");
        assertTrue(true);
    }

    @Test
    public void testDemo2() {
        System.out.println("testDemo2");
        assertTrue(false);
    }

    @Test
    public void testDemo3() {
        System.out.println("testDemo3");
        assertTrue(false);
    }
}

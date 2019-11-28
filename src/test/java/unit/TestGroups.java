package unit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-18 11:42 AM
 */
public class TestGroups {

    @Category({FastGroup.class, SlowGroup.class})
    @Test
    public void testDemo1() {
        assertTrue(false);
    }

    @Category(SlowGroup.class)
    @Test
    public void testDemo2() {
        assertEquals("diff two values", 100, 10);
        assertTrue(false);
    }

    @Category(SlowGroup.class)
    @Test
    public void testDemo3() {
        assertThat("actual value close to 10", 100.0, anyOf(closeTo(111, 10), equalTo(10.0)));
    }

    @Category(FastGroup.class)
    @Test
    public void testDemo4() {
        assertTrue(false);
    }
}

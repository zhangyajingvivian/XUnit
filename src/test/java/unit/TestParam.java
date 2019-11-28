package unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-18 2:43 PM
 */

@RunWith(Parameterized.class)
public class TestParam {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2},
                {3, 3},
                {4, 5},
                {5, 6}
        });
    }

    @Parameterized.Parameter
    public int actual;
    @Parameterized.Parameter(1)
    public int exception;

    @Test
    public void testDemo() {
        assertThat("demo", actual, equalTo(exception));
    }
}

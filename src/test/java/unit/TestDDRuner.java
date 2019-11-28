package unit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-18 3:08 PM
 */
@RunWith(JUnitParamsRunner.class)
public class TestDDRuner {

    @Test
    @Parameters({
            "17, false",
            "22, true"
    })
    public void testDemo(int age, boolean valid) {
        assertThat(age>17, equalTo(valid));
    }
}

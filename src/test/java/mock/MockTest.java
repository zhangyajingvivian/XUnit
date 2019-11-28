package mock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-19 2:15 PM
 */
public class MockTest {

    @Test
    public void testMockDemo() {
        List list = new ArrayList(){{add(1);add(2);add(3);add(4);add(5);}};
        assertThat(list.size(), equalTo(6));
    }

    @Test
    public void testMockDemo2() {
        List list = mock(ArrayList.class);
        list.add(1);
        when(list.size()).thenReturn(5);

        assertThat(list.size(), equalTo(5));
        verify(list).add(2);
    }
}

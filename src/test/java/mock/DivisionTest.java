package mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DivisionTest {

    Division division = new Division();
    Division2 division2 = new Division2();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void divid() throws Exception {
        assertThat(division.divid(10, 5), equalTo(2));
    }

    @Test
    public void dividReturnWithZero() {
        assertThat(division.divid(1, 2), equalTo(0));
    }

    @Test
    public void dividByZero() {
        assertThat(division.divid(100, 0), equalTo(null));
    }

    @Test
    public void dividBigDi() {
        assertThat(division.divid(101, 11), equalTo(null));
    }

    @Test
    public void divid2() {
        assertThat(division2.divid2(100, 10, 5, division), equalTo(2));
        Division mockDivision = mock(Division.class);
        when(mockDivision.divid(anyInt(), anyInt())).thenReturn(11);
        System.out.println(mockDivision.divid(2, 1));

        assertThat(division2.divid2(0, 0, 5, mockDivision), equalTo(0));
    }
}